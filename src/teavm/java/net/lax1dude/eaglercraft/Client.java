package net.lax1dude.eaglercraft;

import org.teavm.jso.JSBody;
import org.teavm.jso.browser.Window;
import org.teavm.jso.core.JSError;
import org.teavm.jso.dom.html.HTMLDocument;
import org.teavm.jso.dom.html.HTMLElement;

import net.lax1dude.eaglercraft.adapter.EaglerAdapterImpl2;
import net.minecraft.client.Minecraft;
import net.minecraft.src.ServerList;

public class Client {
  private static final String crashImage = "data:image/png;base64,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";	
	public static HTMLElement rootElement = null;
	public static Minecraft instance = null;
    public static void main(String[] args) {
    	registerErrorHandler();
    	//try {
	    	String[] e = getOpts();
	    	EaglerAdapterImpl2.initializeContext(rootElement = Window.current().getDocument().getElementById(e[0]), e[1]);
	    	LocalStorageManager.loadStorage();
	    	if(e.length > 2 && e[2].length() > 0) {
	    		ServerList.loadDefaultServers(e[2]);
	    	}
	    	if(e.length > 3) {
	    		EaglerAdapterImpl2.setServerToJoinOnLaunch(e[3]);
	    	}
	    	run0();
		//}catch(Throwable t) {
		//	StringWriter s = new StringWriter();
		//	t.printStackTrace(new PrintWriter(s));
		//	showCrashScreen(s.toString());
		//}
    }

    private static void run0() {
    	System.out.println(" -------- starting minecraft -------- ");
    	instance = new Minecraft();
    	run1();
    }
    
    private static void run1() {
    	instance.run();
    }

	@JSBody(params = { }, script = "return window.minecraftOpts;")
	public static native String[] getOpts();

	@JSBody(params = { }, script = "window.minecraftError = null; window.onerror = function(message, file, line, column, errorObj) { if(errorObj) { window.minecraftError = errorObj; window.minecraftErrorL = \"\"+line+\":\"+column; javaMethods.get(\"net.lax1dude.eaglercraft.Client.handleNativeError()V\").invoke(); } else { alert(\"a native browser exception was thrown but your browser does not support fith argument in onerror\"); } };")
	public static native void registerErrorHandler();

	@JSBody(params = { }, script = "return window.minecraftError;")
	public static native JSError getWindowError();
	
	@JSBody(params = { }, script = "return window.minecraftErrorL;")
	public static native String getWindowErrorL();
	
	public static void handleNativeError() {
		JSError e = getWindowError();
		StringBuilder str = new StringBuilder();
		str.append("Native Browser Exception\n");
		str.append("----------------------------------\n");
		str.append("  Line: ").append(getWindowErrorL()).append('\n');
		str.append("  Type: ").append(e.getName()).append('\n');
		str.append("  Message: ").append(e.getMessage()).append('\n');
		str.append("----------------------------------\n\n");
		str.append(e.getStack()).append('\n');
		showCrashScreen(str.toString());
	}
	
	private static boolean isCrashed = false;
	
	private static void showCrashScreen(String t) {
		if(!isCrashed) {
			isCrashed = true;
			EaglerAdapterImpl2.removeEventHandlers();
			
			StringBuilder str = new StringBuilder();
			str.append("Game Crashed! I have fallen and I can't get up! Contact protonicKnight@proton.me to report this error!\n");
			str.append(t);
			str.append('\n').append('\n');
			str.append('\n');
			addArray(str, "window.minecraftOpts");
			str.append('\n');
			addDebug(str, "window.navigator.userAgent");
			addDebug(str, "window.navigator.vendor");
			addDebug(str, "window.navigator.language");
			addDebug(str, "window.navigator.hardwareConcurrency");
			addDebug(str, "window.navigator.deviceMemory");
			addDebug(str, "window.navigator.platform");
			addDebug(str, "window.navigator.product");
			str.append('\n');
			str.append("rootElement.clientWidth = ").append(rootElement.getClientWidth()).append('\n');
			str.append("rootElement.clientHeight = ").append(rootElement.getClientHeight()).append('\n');
			addDebug(str, "window.innerWidth");
			addDebug(str, "window.innerHeight");
			addDebug(str, "window.outerWidth");
			addDebug(str, "window.outerHeight");
			addDebug(str, "window.devicePixelRatio");
			addDebug(str, "window.screen.availWidth");
			addDebug(str, "window.screen.availHeight");
			addDebug(str, "window.screen.colorDepth");
			addDebug(str, "window.screen.pixelDepth");
			str.append('\n');
			addDebug(str, "window.currentContext");
			str.append('\n');
			addDebug(str, "window.location.href");
			addArray(str, "window.location.ancestorOrigins");
			str.append("\n----- Begin Minecraft Config -----\n");
			str.append(LocalStorageManager.dumpConfiguration());
			str.append("\n----- End Minecraft Config -----\n\n");
			addDebug(str, "window.minecraftServer");
			
			String s = rootElement.getAttribute("style");
			rootElement.setAttribute("style", (s == null ? "" : s) + "position:relative;");
			HTMLDocument doc = Window.current().getDocument();
			HTMLElement img = doc.createElement("img");
			HTMLElement div = doc.createElement("div");
			img.setAttribute("style", "z-index:100;position:absolute;top:10px;left:calc(50% - 151px);");
			img.setAttribute("src", crashImage);
			div.setAttribute("style", "z-index:100;position:absolute;top:135px;left:10%;right:10%;bottom:30px;background-color:white;border:1px solid #cccccc;overflow-x:hidden;overflow-y:scroll;overflow-wrap:break-word;white-space:pre-wrap;font: 14px monospace;padding:10px;");
			rootElement.appendChild(img);
			rootElement.appendChild(div);
			div.appendChild(doc.createTextNode(str.toString()));
			
		}
	}
	
	@JSBody(params = { "v" }, script = "try { return \"\"+window.eval(v); } catch(e) { return \"<error>\"; }")
	private static native String getString(String var);

	private static void addDebug(StringBuilder str, String var) {
		str.append(var).append(" = ").append(getString(var)).append('\n');
	}
	
	private static void addArray(StringBuilder str, String var) {
		str.append(var).append(" = ").append(getArray(var)).append('\n');
	}
	
	@JSBody(params = { "v" }, script = "try { return JSON.stringify(window.eval(v)); } catch(e) { return \"[\\\"<error>\\\"]\"; }")
	private static native String getArray(String var);
	
}
