package org.andresoviedo.p225a.p226a;

import android.opengl.GLES20;
import com.p094b.p095a.Log;
import com.p094b.p095a.U;
import java.io.Closeable;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: GL.java */
/* renamed from: org.andresoviedo.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class GL {

    /* renamed from: PlatformImplementations.kt_3 */
    public static GL f24804a = new GL();

    /* renamed from: IntrinsicsJvm.kt_4 */
    Set<Integer> f24805b = new HashSet();

    /* renamed from: IntrinsicsJvm.kt_3 */
    Set<Integer> f24806c = new HashSet();

    /* renamed from: IntrinsicsJvm.kt_5 */
    Set<Integer> f24807d = new HashSet();

    /* renamed from: COUIBaseListPopupWindow_8 */
    Set<Integer> f24808e = new HashSet();

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Map<Integer, String> f24809f = new HashMap();

    /* renamed from: PlatformImplementations.kt_3 */
    public void m26080a(int OplusGLSurfaceView_13) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3("glActiveTexture", Integer.valueOf(OplusGLSurfaceView_13));
        try {
            GLES20.glActiveTexture(OplusGLSurfaceView_13);
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m26081a(int OplusGLSurfaceView_13, int i2) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3("glAttachShader", Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2));
        try {
            GLES20.glAttachShader(OplusGLSurfaceView_13, i2);
            IntrinsicsJvm.kt_4.m26119a(OplusGLSurfaceView_13).f24817d.add(Integer.valueOf(i2));
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m26086a(int OplusGLSurfaceView_13, int i2, String str) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3("glBindAttribLocation", Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2), str);
        try {
            GLES20.glBindAttribLocation(OplusGLSurfaceView_13, i2, str);
            IntrinsicsJvm.kt_4.m26119a(OplusGLSurfaceView_13).f24818e.put(Integer.valueOf(i2), str);
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m26094b(int OplusGLSurfaceView_13, int i2) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3("glBindTexture", Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2));
        try {
            GLES20.glBindTexture(OplusGLSurfaceView_13, i2);
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m26102c(int OplusGLSurfaceView_13, int i2) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3("glBlendFunc", Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2));
        try {
            GLES20.glBlendFunc(OplusGLSurfaceView_13, i2);
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m26093b(int OplusGLSurfaceView_13) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3("glClear", Integer.valueOf(OplusGLSurfaceView_13));
        try {
            GLES20.glClear(OplusGLSurfaceView_13);
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m26079a(float COUIBaseListPopupWindow_12, float f2, float f3, float f4) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3("glClearColor", Float.valueOf(COUIBaseListPopupWindow_12), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4));
        try {
            GLES20.glClearColor(COUIBaseListPopupWindow_12, f2, f3, f4);
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m26101c(int OplusGLSurfaceView_13) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3("glCompileShader", Integer.valueOf(OplusGLSurfaceView_13));
        try {
            GLES20.glCompileShader(OplusGLSurfaceView_13);
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m26077a() {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3("glCreateProgram", new Object[0]);
        try {
            int iGlCreateProgram = GLES20.glCreateProgram();
            U.m6362a(iGlCreateProgram != 0);
            IntrinsicsJvm.kt_4.f24814a.put(Integer.valueOf(iGlCreateProgram), new IntrinsicsJvm.kt_4(iGlCreateProgram));
            aVar.close();
            return iGlCreateProgram;
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public int m26105d(int OplusGLSurfaceView_13) {
        boolean z = true;
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3("glCreateShader", Integer.valueOf(OplusGLSurfaceView_13));
        try {
            int iGlCreateShader = GLES20.glCreateShader(OplusGLSurfaceView_13);
            if (iGlCreateShader == 0) {
                z = false;
            }
            U.m6362a(z);
            this.f24805b.add(Integer.valueOf(iGlCreateShader));
            aVar.close();
            return iGlCreateShader;
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m26090a(int OplusGLSurfaceView_13, int[] iArr, int i2) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3("glDeleteBuffers", Integer.valueOf(OplusGLSurfaceView_13), iArr, Integer.valueOf(i2));
        try {
            GLES20.glDeleteBuffers(OplusGLSurfaceView_13, iArr, i2);
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m26099b(int OplusGLSurfaceView_13, int[] iArr, int i2) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3("glDeleteFramebuffers", Integer.valueOf(OplusGLSurfaceView_13), iArr, Integer.valueOf(i2));
        try {
            GLES20.glDeleteFramebuffers(OplusGLSurfaceView_13, iArr, i2);
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m26109e(int OplusGLSurfaceView_13) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3("glDeleteProgram", Integer.valueOf(OplusGLSurfaceView_13));
        try {
            GLES20.glDeleteProgram(OplusGLSurfaceView_13);
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m26110f(int OplusGLSurfaceView_13) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3("glDeleteShader", Integer.valueOf(OplusGLSurfaceView_13));
        try {
            GLES20.glDeleteShader(OplusGLSurfaceView_13);
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m26104c(int OplusGLSurfaceView_13, int[] iArr, int i2) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3("glDeleteTextures", Integer.valueOf(OplusGLSurfaceView_13), iArr, Integer.valueOf(i2));
        try {
            GLES20.glDeleteTextures(OplusGLSurfaceView_13, iArr, i2);
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m26111g(int OplusGLSurfaceView_13) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3("glDisable", Integer.valueOf(OplusGLSurfaceView_13));
        try {
            GLES20.glDisable(OplusGLSurfaceView_13);
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m26112h(int OplusGLSurfaceView_13) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3("glDisableVertexAttribArray", Integer.valueOf(OplusGLSurfaceView_13));
        try {
            GLES20.glDisableVertexAttribArray(OplusGLSurfaceView_13);
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m26082a(int OplusGLSurfaceView_13, int i2, int i3) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3("glDrawArrays", Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2), Integer.valueOf(i3));
        try {
            GLES20.glDrawArrays(OplusGLSurfaceView_13, i2, i3);
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m26084a(int OplusGLSurfaceView_13, int i2, int i3, Buffer buffer) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3("glDrawElements", Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2), Integer.valueOf(i3), buffer);
        try {
            GLES20.glDrawElements(OplusGLSurfaceView_13, i2, i3, buffer);
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m26113i(int OplusGLSurfaceView_13) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3("glEnable", Integer.valueOf(OplusGLSurfaceView_13));
        try {
            GLES20.glEnable(OplusGLSurfaceView_13);
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m26114j(int OplusGLSurfaceView_13) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3("glEnableVertexAttribArray", Integer.valueOf(OplusGLSurfaceView_13));
        try {
            GLES20.glEnableVertexAttribArray(OplusGLSurfaceView_13);
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m26108d(int OplusGLSurfaceView_13, int[] iArr, int i2) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3("glGenTextures", Integer.valueOf(OplusGLSurfaceView_13), iArr, Integer.valueOf(i2));
        try {
            GLES20.glGenTextures(OplusGLSurfaceView_13, iArr, i2);
            for (int i3 = 0; i3 < OplusGLSurfaceView_13; i3++) {
                this.f24808e.add(Integer.valueOf(iArr[i3 + i2]));
            }
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m26078a(int OplusGLSurfaceView_13, String str) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3("glGetAttribLocation", Integer.valueOf(OplusGLSurfaceView_13), str);
        try {
            int iGlGetAttribLocation = GLES20.glGetAttribLocation(OplusGLSurfaceView_13, str);
            aVar.close();
            return iGlGetAttribLocation;
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m26091b() {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3("glGetError", new Object[0]);
        try {
            int iGlGetError = GLES20.glGetError();
            aVar.close();
            return iGlGetError;
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m26089a(int OplusGLSurfaceView_13, int i2, int[] iArr, int i3) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3("glGetProgramiv", Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2), iArr, Integer.valueOf(i3));
        try {
            GLES20.glGetProgramiv(OplusGLSurfaceView_13, i2, iArr, i3);
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public String m26115k(int OplusGLSurfaceView_13) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3("glGetProgramInfoLog", Integer.valueOf(OplusGLSurfaceView_13));
        try {
            String strGlGetProgramInfoLog = GLES20.glGetProgramInfoLog(OplusGLSurfaceView_13);
            aVar.close();
            return strGlGetProgramInfoLog;
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m26098b(int OplusGLSurfaceView_13, int i2, int[] iArr, int i3) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3("glGetShaderiv", Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2), iArr, Integer.valueOf(i3));
        try {
            GLES20.glGetShaderiv(OplusGLSurfaceView_13, i2, iArr, i3);
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public String m26116l(int OplusGLSurfaceView_13) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3("glGetShaderInfoLog", Integer.valueOf(OplusGLSurfaceView_13));
        try {
            String strGlGetShaderInfoLog = GLES20.glGetShaderInfoLog(OplusGLSurfaceView_13);
            aVar.close();
            return strGlGetShaderInfoLog;
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m26092b(int OplusGLSurfaceView_13, String str) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3("glGetUniformLocation", Integer.valueOf(OplusGLSurfaceView_13), str);
        try {
            int iGlGetUniformLocation = GLES20.glGetUniformLocation(OplusGLSurfaceView_13, str);
            aVar.close();
            return iGlGetUniformLocation;
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public static boolean m26076m(int OplusGLSurfaceView_13) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3("glIsProgram", Integer.valueOf(OplusGLSurfaceView_13));
        try {
            boolean zGlIsProgram = GLES20.glIsProgram(OplusGLSurfaceView_13);
            if (!zGlIsProgram) {
                Log.m6274a("GLES20", "" + OplusGLSurfaceView_13 + " is not PlatformImplementations.kt_3 valid program");
            }
            aVar.close();
            return zGlIsProgram;
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public void m26117n(int OplusGLSurfaceView_13) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3("glLinkProgram", Integer.valueOf(OplusGLSurfaceView_13));
        try {
            GLES20.glLinkProgram(OplusGLSurfaceView_13);
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m26083a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3("glScissor", Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        try {
            GLES20.glScissor(OplusGLSurfaceView_13, i2, i3, i4);
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m26103c(int OplusGLSurfaceView_13, String str) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3("glShaderSource", Integer.valueOf(OplusGLSurfaceView_13), str);
        try {
            GLES20.glShaderSource(OplusGLSurfaceView_13, str);
            this.f24809f.put(Integer.valueOf(OplusGLSurfaceView_13), str);
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m26095b(int OplusGLSurfaceView_13, int i2, int i3) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3("glTexParameteri", Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2), Integer.valueOf(i3));
        try {
            GLES20.glTexParameteri(OplusGLSurfaceView_13, i2, i3);
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m26107d(int OplusGLSurfaceView_13, int i2) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3("glUniform1i", Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2));
        try {
            GLES20.glUniform1i(OplusGLSurfaceView_13, i2);
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m26088a(int OplusGLSurfaceView_13, int i2, float[] fArr, int i3) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3("glUniform3fv", Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2), fArr, Integer.valueOf(i3));
        try {
            GLES20.glUniform3fv(OplusGLSurfaceView_13, i2, fArr, i3);
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m26097b(int OplusGLSurfaceView_13, int i2, float[] fArr, int i3) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3("glUniform4fv", Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2), fArr, Integer.valueOf(i3));
        try {
            GLES20.glUniform4fv(OplusGLSurfaceView_13, i2, fArr, i3);
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m26087a(int OplusGLSurfaceView_13, int i2, boolean z, float[] fArr, int i3) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3("glUniformMatrix4fv", Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2), Boolean.valueOf(z), fArr, Integer.valueOf(i3));
        try {
            GLES20.glUniformMatrix4fv(OplusGLSurfaceView_13, i2, z, fArr, i3);
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: o */
    public void m26118o(int OplusGLSurfaceView_13) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3("glUseProgram", Integer.valueOf(OplusGLSurfaceView_13));
        try {
            GLES20.glUseProgram(OplusGLSurfaceView_13);
            IntrinsicsJvm.kt_4.m26120b(OplusGLSurfaceView_13);
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m26085a(int OplusGLSurfaceView_13, int i2, int i3, boolean z, int i4, Buffer buffer) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3("glVertexAttribPointer", Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Integer.valueOf(i4), buffer);
        try {
            GLES20.glVertexAttribPointer(OplusGLSurfaceView_13, i2, i3, z, i4, buffer);
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m26096b(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3("glViewport", Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        try {
            GLES20.glViewport(OplusGLSurfaceView_13, i2, i3, i4);
            aVar.close();
        } catch (Throwable th) {
            try {
                aVar.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m26100c() {
        PlatformImplementations.kt_3.f24810a = Thread.currentThread().getId();
        Log.m6277c("GLES20", "onSurfaceCreated");
    }

    /* compiled from: GL.java */
    /* renamed from: org.andresoviedo.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
    static class PlatformImplementations.kt_3 implements Closeable {

        /* renamed from: PlatformImplementations.kt_3 */
        static long f24810a = -1;

        /* renamed from: IntrinsicsJvm.kt_4 */
        static List<PlatformImplementations.kt_3> f24811b = new ArrayList();

        /* renamed from: IntrinsicsJvm.kt_3 */
        String f24812c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        String f24813d;

        PlatformImplementations.kt_3(String str, Object... objArr) {
            this.f24813d = "";
            U.m6362a(Thread.currentThread().getId() == f24810a);
            this.f24812c = str;
            for (Object obj : objArr) {
                if (this.f24813d.isEmpty()) {
                    this.f24813d = String.valueOf(obj);
                } else {
                    this.f24813d += ", " + obj;
                }
            }
            f24811b.add(this);
        }

        public String toString() {
            return this.f24812c + "(" + this.f24813d + ")";
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            int size = f24811b.size();
            U.m6362a(size > 0 && f24811b.get(size + (-1)) == this);
            f24811b.remove(size - 1);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m26106d() {
        if (this.f24808e.size() > 0) {
            int[] iArr = new int[this.f24808e.size()];
            Iterator<Integer> it = this.f24808e.iterator();
            int OplusGLSurfaceView_13 = 0;
            while (it.hasNext()) {
                iArr[OplusGLSurfaceView_13] = it.next().intValue();
                OplusGLSurfaceView_13++;
            }
            this.f24808e.clear();
            m26104c(OplusGLSurfaceView_13, iArr, 0);
        }
        if (this.f24806c.size() > 0) {
            int[] iArr2 = new int[this.f24806c.size()];
            Iterator<Integer> it2 = this.f24806c.iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                iArr2[i2] = it2.next().intValue();
                i2++;
            }
            this.f24806c.clear();
            m26090a(i2, iArr2, 0);
        }
        if (this.f24807d.size() > 0) {
            int[] iArr3 = new int[this.f24807d.size()];
            Iterator<Integer> it3 = this.f24807d.iterator();
            int i3 = 0;
            while (it3.hasNext()) {
                iArr3[i3] = it3.next().intValue();
                i3++;
            }
            this.f24807d.clear();
            m26099b(i3, iArr3, 0);
        }
        if (this.f24805b.size() > 0) {
            Iterator<Integer> it4 = this.f24805b.iterator();
            while (it4.hasNext()) {
                m26110f(it4.next().intValue());
            }
            this.f24805b.clear();
        }
        if (IntrinsicsJvm.kt_4.f24814a.size() > 0) {
            Iterator<Integer> it5 = IntrinsicsJvm.kt_4.f24814a.keySet().iterator();
            while (it5.hasNext()) {
                m26109e(it5.next().intValue());
            }
            IntrinsicsJvm.kt_4.f24814a.clear();
        }
    }

    /* compiled from: GL.java */
    /* renamed from: org.andresoviedo.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3$IntrinsicsJvm.kt_4 */
    static class IntrinsicsJvm.kt_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        static Map<Integer, IntrinsicsJvm.kt_4> f24814a = new HashMap();

        /* renamed from: IntrinsicsJvm.kt_4 */
        int f24815b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        boolean f24816c = false;

        /* renamed from: IntrinsicsJvm.kt_5 */
        List<Integer> f24817d = new ArrayList();

        /* renamed from: COUIBaseListPopupWindow_8 */
        Map<Integer, String> f24818e = new HashMap();

        IntrinsicsJvm.kt_4(int OplusGLSurfaceView_13) {
            this.f24815b = OplusGLSurfaceView_13;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        static IntrinsicsJvm.kt_4 m26119a(int OplusGLSurfaceView_13) {
            U.m6362a(GL.m26076m(OplusGLSurfaceView_13) && f24814a.containsKey(Integer.valueOf(OplusGLSurfaceView_13)));
            return f24814a.get(Integer.valueOf(OplusGLSurfaceView_13));
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        static void m26120b(int OplusGLSurfaceView_13) {
            Iterator<IntrinsicsJvm.kt_4> it = f24814a.values().iterator();
            while (it.hasNext()) {
                it.next().f24816c = false;
            }
            m26119a(OplusGLSurfaceView_13).f24816c = true;
        }
    }
}
