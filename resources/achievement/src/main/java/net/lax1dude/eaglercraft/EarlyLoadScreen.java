package net.lax1dude.eaglercraft;

import static net.lax1dude.eaglercraft.adapter.EaglerAdapterImpl2.*;

import java.nio.IntBuffer;

import net.lax1dude.eaglercraft.adapter.EaglerAdapterImpl2.BufferArrayGL;
import net.minecraft.src.GLAllocation;

public class EarlyLoadScreen {
	
	public static final String loadScreen = "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";
	public static final String enableScreen = "iVBORw0KGgoAAAANSUhEUgAAAIAAAACACAYAAADDPmHLAAAACXBIWXMAAC4jAAAuIwF4pT92AAAEAklEQVR42u2dvXbjIBBG7T0+xw+gTp06v//LmE6dO/VR5a3wGZNh+BGSFeveJgkIBrDy8TGKds8/Pz/PExyW8/P55AY4MP9YgmNzmeeZVUABAA8AKADgAQAFADwAoACABwAUAPAAgAIAHgBQAMADAAoAeABAAY7LOI7fpQDX65VPtZCt18w5d7rdbigAbOgBxnE8DcPwJnnDMCTrNJlsUVcizTnj9HWxeVvINfN9y361OdTEk30551ZZt3PsvYDYxOSChoPQ6sJ21mRLBm61jY0lpy61gDKWNdfcNcv5wErWLbfPF88I9/s9WtayzopXS85YtPqcMeT23SqedV1pucal1V4iTUooV/IaWSfbWHU5JmkvpmzrsayaB9DqfJnVTpMff72sc869/WzVlcjjOI7mOOVYfBzfT05exLfT5pqae008a71Ly6tPASV79CfPylvFjpm+teLH+tXiF5nA2LOAUMpCibckWpPBUOJT20btFuDjyK8p+S45Z4fX+ti+LDb3pef62PosWbfkDbBW8mFPhB/gt8Vr7gG+kZK9+C/GM2+ArffnnKRHbT5gSdJoK0+ydrziGyCW115LolLxnHOr59q3lt89b6U8Czg4pgdI5bUtKY3VzfOclGBtTLVSmmqn1cdyC7Iud+5791KX1MLJDz3Mg2s59pK6sM/asdTmLrRx5pzjS+e+awWw9lstVeuv1/a10rqwT8sn5LQr8RzaMVfmKrR2qfnFjs57/puLS0nyoTZp0fL8XGq+ap8v4AES+3Msx74kN2/tmblewWoXPl9o+RykZH5/5hTQYv+y+vj084XcPHpJbHmt1s7yGbV1q+UBnHO/gnoZje2RmuzK/Vr2F3sWEF6TGkvutqH5CG08qTmk5u77tLyK5Qtq62rgxRA8AO8FHBkygQeHLQAFADwAoACABwAUAPAAgAIAHgBQAMADAAoAeABAAQAPACgA4AEABQA8AKAAgAcAFAC+3gNM03Tqum7VQSyN4dtvMdZDKcBWC9oqhr8JoIEHeDwep77vf5VJfL0vl9fLa/u+f+vPfx9eszSGNXZo5AH6vlcXW36gsqykrzViwAIPYL3r3nXd63v5m6i9J2+VaT8viWGNHZQbYE97+KdjHPIGKH0XPSyL7eXSjPk2YZlsN03Tq21OjLAs598ZggIT2MpMbW3IMICFN0Dsv4xpfUbfAvIAK9wAcOAtAMgDwJHzAIACAB4AUADAAwAKAHgAQAEADwAoAOABAAUAPACgAIAHABQA8ACAAgAeAFAAwAMACgB4AEABAA8AKADgAQAFADwAoACABwAUAPAAgAIAHgBQAMADAAoAeABAAQAPACgA4AEABQA8AKAAgAcAFADwANCe/0of1jQ8XY5YAAAAAElFTkSuQmCC";

	private static BufferGL vbo = null;
	private static ProgramGL program = null;
	
	public static void paintScreen() {
		
		TextureGL tex = _wglGenTextures();
		_wglActiveTexture(_wGL_TEXTURE0);
		_wglBindTexture(_wGL_TEXTURE_2D, tex);
		_wglTexParameteri(_wGL_TEXTURE_2D, _wGL_TEXTURE_MAG_FILTER, _wGL_NEAREST);
		_wglTexParameteri(_wGL_TEXTURE_2D, _wGL_TEXTURE_MIN_FILTER, _wGL_NEAREST);
		_wglTexParameteri(_wGL_TEXTURE_2D, _wGL_TEXTURE_WRAP_S, _wGL_CLAMP);
		_wglTexParameteri(_wGL_TEXTURE_2D, _wGL_TEXTURE_WRAP_T, _wGL_CLAMP);
		//EaglerImage img = EaglerImage.loadImage(Base64.decodeBase64(loadScreen));
		EaglerImage img = EaglerAdapter.loadPNG(Base64.decodeBase64(loadScreen));
		IntBuffer upload = GLAllocation.createDirectIntBuffer(192*192);
		upload.put(img.data);
		upload.flip();
		_wglTexImage2D(_wGL_TEXTURE_2D, 0, _wGL_RGBA, 192, 192, 0, _wGL_RGBA, _wGL_UNSIGNED_BYTE, upload);
		
		upload.clear();
		upload.put(Float.floatToIntBits(0.0f)); upload.put(Float.floatToIntBits(0.0f));
		upload.put(Float.floatToIntBits(0.0f)); upload.put(Float.floatToIntBits(1.0f));
		upload.put(Float.floatToIntBits(1.0f)); upload.put(Float.floatToIntBits(0.0f));
		upload.put(Float.floatToIntBits(1.0f)); upload.put(Float.floatToIntBits(0.0f));
		upload.put(Float.floatToIntBits(0.0f)); upload.put(Float.floatToIntBits(1.0f));
		upload.put(Float.floatToIntBits(1.0f)); upload.put(Float.floatToIntBits(1.0f));
		upload.flip();
			
		vbo = _wglCreateBuffer();
		_wglBindBuffer(_wGL_ARRAY_BUFFER, vbo);
		_wglBufferData0(_wGL_ARRAY_BUFFER, upload, _wGL_STATIC_DRAW);

		ShaderGL vert = _wglCreateShader(_wGL_VERTEX_SHADER);
		_wglShaderSource(vert, _wgetShaderHeader()+"\nprecision lowp float; in vec2 a_pos; out vec2 v_pos; void main() { gl_Position = vec4(((v_pos = a_pos) - 0.5) * vec2(2.0, -2.0), 0.0, 1.0); }");
		_wglCompileShader(vert);
		
		ShaderGL frag = _wglCreateShader(_wGL_FRAGMENT_SHADER);
		_wglShaderSource(frag, _wgetShaderHeader()+"\nprecision lowp float; in vec2 v_pos; out vec4 fragColor; uniform sampler2D tex; uniform vec2 aspect; void main() { fragColor = vec4(texture(tex, clamp(v_pos * aspect - ((aspect - 1.0) * 0.5), 0.02, 0.98)).rgb, 1.0); }");
		_wglCompileShader(frag);
		
		program = _wglCreateProgram();
		
		_wglAttachShader(program, vert);
		_wglAttachShader(program, frag);
		_wglBindAttributeLocation(program, 0, "a_pos");
		_wglLinkProgram(program);
		_wglDetachShader(program, vert);
		_wglDetachShader(program, frag);
		_wglDeleteShader(vert);
		_wglDeleteShader(frag);
		
		try {
			Thread.sleep(50l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		_wglUseProgram(program);
		_wglUniform1i(_wglGetUniformLocation(program, "tex"), 0);

		int width = getCanvasWidth();
		int height = getCanvasHeight();
		float x, y;
		if(width > height) {
			x = (float)width / (float)height;
			y = 1.0f;
		}else {
			x = 1.0f;
			y = (float)height / (float)width;
		}
		
		_wglActiveTexture(_wGL_TEXTURE0);
		_wglBindTexture(_wGL_TEXTURE_2D, tex);
		
		_wglViewport(0, 0, width, height);
		_wglClearColor(1.0f, 1.0f, 1.0f, 1.0f);
		_wglClear(_wGL_COLOR_BUFFER_BIT | _wGL_DEPTH_BUFFER_BIT);
		
		_wglUniform2f(_wglGetUniformLocation(program, "aspect"), x, y);
		
		BufferArrayGL vao = _wglCreateVertexArray();
		_wglBindVertexArray(vao);
		_wglEnableVertexAttribArray(0);
		_wglVertexAttribPointer(0, 2, _wGL_FLOAT, false, 8, 0);
		_wglDrawArrays(_wGL_TRIANGLES, 0, 6);
		_wglDisableVertexAttribArray(0);
		_wglFlush();
		updateDisplay();

		_wglUseProgram(null);
		_wglBindBuffer(_wGL_ARRAY_BUFFER, null);
		_wglBindTexture(_wGL_TEXTURE_2D, null);
		_wglDeleteTextures(tex);
		_wglDeleteVertexArray(vao);
	}
	
	public static void paintEnable() {
		
		TextureGL tex = _wglGenTextures();
		_wglActiveTexture(_wGL_TEXTURE0);
		_wglBindTexture(_wGL_TEXTURE_2D, tex);
		_wglTexParameteri(_wGL_TEXTURE_2D, _wGL_TEXTURE_MAG_FILTER, _wGL_NEAREST);
		_wglTexParameteri(_wGL_TEXTURE_2D, _wGL_TEXTURE_MIN_FILTER, _wGL_NEAREST);
		_wglTexParameteri(_wGL_TEXTURE_2D, _wGL_TEXTURE_WRAP_S, _wGL_CLAMP);
		_wglTexParameteri(_wGL_TEXTURE_2D, _wGL_TEXTURE_WRAP_T, _wGL_CLAMP);
		//EaglerImage img = EaglerImage.loadImage(Base64.decodeBase64(enableScreen));
		EaglerImage img = EaglerAdapter.loadPNG(Base64.decodeBase64(enableScreen));
		IntBuffer upload = GLAllocation.createDirectIntBuffer(128*128);
		upload.put(img.data);
		upload.flip();
		_wglTexImage2D(_wGL_TEXTURE_2D, 0, _wGL_RGBA, 128, 128, 0, _wGL_RGBA, _wGL_UNSIGNED_BYTE, upload);
		
		try {
			Thread.sleep(50l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		_wglUseProgram(program);

		int width = getCanvasWidth();
		int height = getCanvasHeight();
		float x, y;
		if(width > height) {
			x = (float)width / (float)height;
			y = 1.0f;
		}else {
			x = 1.0f;
			y = (float)height / (float)width;
		}
		
		_wglActiveTexture(_wGL_TEXTURE0);
		_wglBindTexture(_wGL_TEXTURE_2D, tex);
		
		_wglViewport(0, 0, width, height);
		_wglClearColor(1.0f, 1.0f, 1.0f, 1.0f);
		_wglClear(_wGL_COLOR_BUFFER_BIT | _wGL_DEPTH_BUFFER_BIT);
		
		_wglUniform2f(_wglGetUniformLocation(program, "aspect"), x, y);

		BufferArrayGL vao = _wglCreateVertexArray();
		_wglBindVertexArray(vao);
		_wglBindBuffer(_wGL_ARRAY_BUFFER, vbo);
		_wglEnableVertexAttribArray(0);
		_wglVertexAttribPointer(0, 2, _wGL_FLOAT, false, 8, 0);
		_wglDrawArrays(_wGL_TRIANGLES, 0, 6);
		_wglDisableVertexAttribArray(0);
		_wglFlush();
		updateDisplay();

		_wglUseProgram(null);
		_wglBindBuffer(_wGL_ARRAY_BUFFER, null);
		_wglBindTexture(_wGL_TEXTURE_2D, null);
		_wglDeleteTextures(tex);
		_wglDeleteVertexArray(vao);
		
	}
	
}
