echo Welcome to DevForMOV! What would you like to do?;
echo 1: Compile Texture Pack;
echo 2: Compile Client;
echo 3: Start Server for Testing;
echo 4: Compile Both and Start Server;
echo 5: Push All Changes to Github;
read -p "Answer:" ans;
case $ans in
  1 ) echo Compiling EPK...; java -jar epkcompiler/CompilePackage.jar "resources" "output/assets.epk"; echo Compiled EPK; exit;;
  2 ) echo Compiling Client...; sh gradlew teavmc; echo Compiled classes.js; exit;;
  4 ) echo Compiling Client...; sh gradlew teavmc; echo Compiled classes.js; echo Compiling EPK...; java -jar epkcompiler/CompilePackage.jar "resources" "output/assets.epk"; echo Compiled EPK; echo Starting Server for Testing...; python -m http.server --directory output; exit;;
  3 ) echo Starting Server for Testing...; python -m http.server --directory output; exit;;
  5 ) git init; git add .; git commit -m 'test'; git remote set-url origin https://github.com/TheRealUnBot/DevForMOV.git; git push -u origin master; exit;;
esac