package org.andresoviedo.a_renamed.a_renamed;

/* compiled from: GL.java */
/* loaded from: classes2.dex */
public class c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static org.andresoviedo.a_renamed.a_renamed.c_renamed f7951a = new org.andresoviedo.a_renamed.a_renamed.c_renamed();

    /* renamed from: b_renamed, reason: collision with root package name */
    java.util.Set<java.lang.Integer> f7952b = new java.util.HashSet();

    /* renamed from: c_renamed, reason: collision with root package name */
    java.util.Set<java.lang.Integer> f7953c = new java.util.HashSet();
    java.util.Set<java.lang.Integer> d_renamed = new java.util.HashSet();
    java.util.Set<java.lang.Integer> e_renamed = new java.util.HashSet();
    private java.util.Map<java.lang.Integer, java.lang.String> f_renamed = new java.util.HashMap();

    public void a_renamed(int i_renamed) {
        org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed aVar = new org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed("glActiveTexture", java.lang.Integer.valueOf(i_renamed));
        try {
            android.opengl.GLES20.glActiveTexture(i_renamed);
            aVar.close();
        } catch (java.lang.Throwable th) {
            try {
                aVar.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void a_renamed(int i_renamed, int i2) {
        org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed aVar = new org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed("glAttachShader", java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2));
        try {
            android.opengl.GLES20.glAttachShader(i_renamed, i2);
            org.andresoviedo.a_renamed.a_renamed.c_renamed.b_renamed.a_renamed(i_renamed).d_renamed.add(java.lang.Integer.valueOf(i2));
            aVar.close();
        } catch (java.lang.Throwable th) {
            try {
                aVar.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void a_renamed(int i_renamed, int i2, java.lang.String str) {
        org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed aVar = new org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed("glBindAttribLocation", java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2), str);
        try {
            android.opengl.GLES20.glBindAttribLocation(i_renamed, i2, str);
            org.andresoviedo.a_renamed.a_renamed.c_renamed.b_renamed.a_renamed(i_renamed).e_renamed.put(java.lang.Integer.valueOf(i2), str);
            aVar.close();
        } catch (java.lang.Throwable th) {
            try {
                aVar.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void b_renamed(int i_renamed, int i2) {
        org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed aVar = new org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed("glBindTexture", java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2));
        try {
            android.opengl.GLES20.glBindTexture(i_renamed, i2);
            aVar.close();
        } catch (java.lang.Throwable th) {
            try {
                aVar.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void c_renamed(int i_renamed, int i2) {
        org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed aVar = new org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed("glBlendFunc", java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2));
        try {
            android.opengl.GLES20.glBlendFunc(i_renamed, i2);
            aVar.close();
        } catch (java.lang.Throwable th) {
            try {
                aVar.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void b_renamed(int i_renamed) {
        org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed aVar = new org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed("glClear", java.lang.Integer.valueOf(i_renamed));
        try {
            android.opengl.GLES20.glClear(i_renamed);
            aVar.close();
        } catch (java.lang.Throwable th) {
            try {
                aVar.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void a_renamed(float f_renamed, float f2, float f3, float f4) {
        org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed aVar = new org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed("glClearColor", java.lang.Float.valueOf(f_renamed), java.lang.Float.valueOf(f2), java.lang.Float.valueOf(f3), java.lang.Float.valueOf(f4));
        try {
            android.opengl.GLES20.glClearColor(f_renamed, f2, f3, f4);
            aVar.close();
        } catch (java.lang.Throwable th) {
            try {
                aVar.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void c_renamed(int i_renamed) {
        org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed aVar = new org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed("glCompileShader", java.lang.Integer.valueOf(i_renamed));
        try {
            android.opengl.GLES20.glCompileShader(i_renamed);
            aVar.close();
        } catch (java.lang.Throwable th) {
            try {
                aVar.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public int a_renamed() {
        org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed aVar = new org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed("glCreateProgram", new java.lang.Object[0]);
        try {
            int iGlCreateProgram = android.opengl.GLES20.glCreateProgram();
            com.b_renamed.a_renamed.n_renamed.a_renamed(iGlCreateProgram != 0);
            org.andresoviedo.a_renamed.a_renamed.c_renamed.b_renamed.f7957a.put(java.lang.Integer.valueOf(iGlCreateProgram), new org.andresoviedo.a_renamed.a_renamed.c_renamed.b_renamed(iGlCreateProgram));
            aVar.close();
            return iGlCreateProgram;
        } catch (java.lang.Throwable th) {
            try {
                aVar.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public int d_renamed(int i_renamed) {
        boolean z_renamed = true;
        org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed aVar = new org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed("glCreateShader", java.lang.Integer.valueOf(i_renamed));
        try {
            int iGlCreateShader = android.opengl.GLES20.glCreateShader(i_renamed);
            if (iGlCreateShader == 0) {
                z_renamed = false;
            }
            com.b_renamed.a_renamed.n_renamed.a_renamed(z_renamed);
            this.f7952b.add(java.lang.Integer.valueOf(iGlCreateShader));
            aVar.close();
            return iGlCreateShader;
        } catch (java.lang.Throwable th) {
            try {
                aVar.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void a_renamed(int i_renamed, int[] iArr, int i2) {
        org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed aVar = new org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed("glDeleteBuffers", java.lang.Integer.valueOf(i_renamed), iArr, java.lang.Integer.valueOf(i2));
        try {
            android.opengl.GLES20.glDeleteBuffers(i_renamed, iArr, i2);
            aVar.close();
        } catch (java.lang.Throwable th) {
            try {
                aVar.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void b_renamed(int i_renamed, int[] iArr, int i2) {
        org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed aVar = new org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed("glDeleteFramebuffers", java.lang.Integer.valueOf(i_renamed), iArr, java.lang.Integer.valueOf(i2));
        try {
            android.opengl.GLES20.glDeleteFramebuffers(i_renamed, iArr, i2);
            aVar.close();
        } catch (java.lang.Throwable th) {
            try {
                aVar.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void e_renamed(int i_renamed) {
        org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed aVar = new org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed("glDeleteProgram", java.lang.Integer.valueOf(i_renamed));
        try {
            android.opengl.GLES20.glDeleteProgram(i_renamed);
            aVar.close();
        } catch (java.lang.Throwable th) {
            try {
                aVar.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void f_renamed(int i_renamed) {
        org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed aVar = new org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed("glDeleteShader", java.lang.Integer.valueOf(i_renamed));
        try {
            android.opengl.GLES20.glDeleteShader(i_renamed);
            aVar.close();
        } catch (java.lang.Throwable th) {
            try {
                aVar.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void c_renamed(int i_renamed, int[] iArr, int i2) {
        org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed aVar = new org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed("glDeleteTextures", java.lang.Integer.valueOf(i_renamed), iArr, java.lang.Integer.valueOf(i2));
        try {
            android.opengl.GLES20.glDeleteTextures(i_renamed, iArr, i2);
            aVar.close();
        } catch (java.lang.Throwable th) {
            try {
                aVar.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void g_renamed(int i_renamed) {
        org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed aVar = new org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed("glDisable", java.lang.Integer.valueOf(i_renamed));
        try {
            android.opengl.GLES20.glDisable(i_renamed);
            aVar.close();
        } catch (java.lang.Throwable th) {
            try {
                aVar.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void h_renamed(int i_renamed) {
        org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed aVar = new org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed("glDisableVertexAttribArray", java.lang.Integer.valueOf(i_renamed));
        try {
            android.opengl.GLES20.glDisableVertexAttribArray(i_renamed);
            aVar.close();
        } catch (java.lang.Throwable th) {
            try {
                aVar.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void a_renamed(int i_renamed, int i2, int i3) {
        org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed aVar = new org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed("glDrawArrays", java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3));
        try {
            android.opengl.GLES20.glDrawArrays(i_renamed, i2, i3);
            aVar.close();
        } catch (java.lang.Throwable th) {
            try {
                aVar.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void a_renamed(int i_renamed, int i2, int i3, java.nio.Buffer buffer) {
        org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed aVar = new org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed("glDrawElements", java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3), buffer);
        try {
            android.opengl.GLES20.glDrawElements(i_renamed, i2, i3, buffer);
            aVar.close();
        } catch (java.lang.Throwable th) {
            try {
                aVar.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void i_renamed(int i_renamed) {
        org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed aVar = new org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed("glEnable", java.lang.Integer.valueOf(i_renamed));
        try {
            android.opengl.GLES20.glEnable(i_renamed);
            aVar.close();
        } catch (java.lang.Throwable th) {
            try {
                aVar.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void j_renamed(int i_renamed) {
        org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed aVar = new org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed("glEnableVertexAttribArray", java.lang.Integer.valueOf(i_renamed));
        try {
            android.opengl.GLES20.glEnableVertexAttribArray(i_renamed);
            aVar.close();
        } catch (java.lang.Throwable th) {
            try {
                aVar.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void d_renamed(int i_renamed, int[] iArr, int i2) {
        org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed aVar = new org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed("glGenTextures", java.lang.Integer.valueOf(i_renamed), iArr, java.lang.Integer.valueOf(i2));
        try {
            android.opengl.GLES20.glGenTextures(i_renamed, iArr, i2);
            for (int i3 = 0; i3 < i_renamed; i3++) {
                this.e_renamed.add(java.lang.Integer.valueOf(iArr[i3 + i2]));
            }
            aVar.close();
        } catch (java.lang.Throwable th) {
            try {
                aVar.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public int a_renamed(int i_renamed, java.lang.String str) {
        org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed aVar = new org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed("glGetAttribLocation", java.lang.Integer.valueOf(i_renamed), str);
        try {
            int iGlGetAttribLocation = android.opengl.GLES20.glGetAttribLocation(i_renamed, str);
            aVar.close();
            return iGlGetAttribLocation;
        } catch (java.lang.Throwable th) {
            try {
                aVar.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public int b_renamed() {
        org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed aVar = new org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed("glGetError", new java.lang.Object[0]);
        try {
            int iGlGetError = android.opengl.GLES20.glGetError();
            aVar.close();
            return iGlGetError;
        } catch (java.lang.Throwable th) {
            try {
                aVar.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void a_renamed(int i_renamed, int i2, int[] iArr, int i3) {
        org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed aVar = new org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed("glGetProgramiv", java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2), iArr, java.lang.Integer.valueOf(i3));
        try {
            android.opengl.GLES20.glGetProgramiv(i_renamed, i2, iArr, i3);
            aVar.close();
        } catch (java.lang.Throwable th) {
            try {
                aVar.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public java.lang.String k_renamed(int i_renamed) {
        org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed aVar = new org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed("glGetProgramInfoLog", java.lang.Integer.valueOf(i_renamed));
        try {
            java.lang.String strGlGetProgramInfoLog = android.opengl.GLES20.glGetProgramInfoLog(i_renamed);
            aVar.close();
            return strGlGetProgramInfoLog;
        } catch (java.lang.Throwable th) {
            try {
                aVar.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void b_renamed(int i_renamed, int i2, int[] iArr, int i3) {
        org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed aVar = new org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed("glGetShaderiv", java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2), iArr, java.lang.Integer.valueOf(i3));
        try {
            android.opengl.GLES20.glGetShaderiv(i_renamed, i2, iArr, i3);
            aVar.close();
        } catch (java.lang.Throwable th) {
            try {
                aVar.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public java.lang.String l_renamed(int i_renamed) {
        org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed aVar = new org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed("glGetShaderInfoLog", java.lang.Integer.valueOf(i_renamed));
        try {
            java.lang.String strGlGetShaderInfoLog = android.opengl.GLES20.glGetShaderInfoLog(i_renamed);
            aVar.close();
            return strGlGetShaderInfoLog;
        } catch (java.lang.Throwable th) {
            try {
                aVar.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public int b_renamed(int i_renamed, java.lang.String str) {
        org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed aVar = new org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed("glGetUniformLocation", java.lang.Integer.valueOf(i_renamed), str);
        try {
            int iGlGetUniformLocation = android.opengl.GLES20.glGetUniformLocation(i_renamed, str);
            aVar.close();
            return iGlGetUniformLocation;
        } catch (java.lang.Throwable th) {
            try {
                aVar.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static boolean m_renamed(int i_renamed) {
        org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed aVar = new org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed("glIsProgram", java.lang.Integer.valueOf(i_renamed));
        try {
            boolean zGlIsProgram = android.opengl.GLES20.glIsProgram(i_renamed);
            if (!zGlIsProgram) {
                com.b_renamed.a_renamed.b_renamed.a_renamed("GLES20", "" + i_renamed + " is_renamed not a_renamed valid program");
            }
            aVar.close();
            return zGlIsProgram;
        } catch (java.lang.Throwable th) {
            try {
                aVar.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void n_renamed(int i_renamed) {
        org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed aVar = new org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed("glLinkProgram", java.lang.Integer.valueOf(i_renamed));
        try {
            android.opengl.GLES20.glLinkProgram(i_renamed);
            aVar.close();
        } catch (java.lang.Throwable th) {
            try {
                aVar.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void a_renamed(int i_renamed, int i2, int i3, int i4) {
        org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed aVar = new org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed("glScissor", java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(i4));
        try {
            android.opengl.GLES20.glScissor(i_renamed, i2, i3, i4);
            aVar.close();
        } catch (java.lang.Throwable th) {
            try {
                aVar.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void c_renamed(int i_renamed, java.lang.String str) {
        org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed aVar = new org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed("glShaderSource", java.lang.Integer.valueOf(i_renamed), str);
        try {
            android.opengl.GLES20.glShaderSource(i_renamed, str);
            this.f_renamed.put(java.lang.Integer.valueOf(i_renamed), str);
            aVar.close();
        } catch (java.lang.Throwable th) {
            try {
                aVar.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void b_renamed(int i_renamed, int i2, int i3) {
        org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed aVar = new org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed("glTexParameteri", java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3));
        try {
            android.opengl.GLES20.glTexParameteri(i_renamed, i2, i3);
            aVar.close();
        } catch (java.lang.Throwable th) {
            try {
                aVar.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void d_renamed(int i_renamed, int i2) {
        org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed aVar = new org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed("glUniform1i", java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2));
        try {
            android.opengl.GLES20.glUniform1i(i_renamed, i2);
            aVar.close();
        } catch (java.lang.Throwable th) {
            try {
                aVar.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void a_renamed(int i_renamed, int i2, float[] fArr, int i3) {
        org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed aVar = new org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed("glUniform3fv", java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2), fArr, java.lang.Integer.valueOf(i3));
        try {
            android.opengl.GLES20.glUniform3fv(i_renamed, i2, fArr, i3);
            aVar.close();
        } catch (java.lang.Throwable th) {
            try {
                aVar.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void b_renamed(int i_renamed, int i2, float[] fArr, int i3) {
        org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed aVar = new org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed("glUniform4fv", java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2), fArr, java.lang.Integer.valueOf(i3));
        try {
            android.opengl.GLES20.glUniform4fv(i_renamed, i2, fArr, i3);
            aVar.close();
        } catch (java.lang.Throwable th) {
            try {
                aVar.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void a_renamed(int i_renamed, int i2, boolean z_renamed, float[] fArr, int i3) {
        org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed aVar = new org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed("glUniformMatrix4fv", java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2), java.lang.Boolean.valueOf(z_renamed), fArr, java.lang.Integer.valueOf(i3));
        try {
            android.opengl.GLES20.glUniformMatrix4fv(i_renamed, i2, z_renamed, fArr, i3);
            aVar.close();
        } catch (java.lang.Throwable th) {
            try {
                aVar.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void o_renamed(int i_renamed) {
        org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed aVar = new org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed("glUseProgram", java.lang.Integer.valueOf(i_renamed));
        try {
            android.opengl.GLES20.glUseProgram(i_renamed);
            org.andresoviedo.a_renamed.a_renamed.c_renamed.b_renamed.b_renamed(i_renamed);
            aVar.close();
        } catch (java.lang.Throwable th) {
            try {
                aVar.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void a_renamed(int i_renamed, int i2, int i3, boolean z_renamed, int i4, java.nio.Buffer buffer) {
        org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed aVar = new org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed("glVertexAttribPointer", java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3), java.lang.Boolean.valueOf(z_renamed), java.lang.Integer.valueOf(i4), buffer);
        try {
            android.opengl.GLES20.glVertexAttribPointer(i_renamed, i2, i3, z_renamed, i4, buffer);
            aVar.close();
        } catch (java.lang.Throwable th) {
            try {
                aVar.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void b_renamed(int i_renamed, int i2, int i3, int i4) {
        org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed aVar = new org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed("glViewport", java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(i4));
        try {
            android.opengl.GLES20.glViewport(i_renamed, i2, i3, i4);
            aVar.close();
        } catch (java.lang.Throwable th) {
            try {
                aVar.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public void c_renamed() {
        org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed.f7954a = java.lang.Thread.currentThread().getId();
        com.b_renamed.a_renamed.b_renamed.c_renamed("GLES20", "onSurfaceCreated");
    }

    /* compiled from: GL.java */
    static class a_renamed implements java.io.Closeable {

        /* renamed from: a_renamed, reason: collision with root package name */
        static long f7954a = -1;

        /* renamed from: b_renamed, reason: collision with root package name */
        static java.util.List<org.andresoviedo.a_renamed.a_renamed.c_renamed.a_renamed> f7955b = new java.util.ArrayList();

        /* renamed from: c_renamed, reason: collision with root package name */
        java.lang.String f7956c;
        java.lang.String d_renamed;

        a_renamed(java.lang.String str, java.lang.Object... objArr) {
            this.d_renamed = "";
            com.b_renamed.a_renamed.n_renamed.a_renamed(java.lang.Thread.currentThread().getId() == f7954a);
            this.f7956c = str;
            for (java.lang.Object obj : objArr) {
                if (this.d_renamed.isEmpty()) {
                    this.d_renamed = java.lang.String.valueOf(obj);
                } else {
                    this.d_renamed += ", " + obj;
                }
            }
            f7955b.add(this);
        }

        public java.lang.String toString() {
            return this.f7956c + "(" + this.d_renamed + ")";
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            int size = f7955b.size();
            com.b_renamed.a_renamed.n_renamed.a_renamed(size > 0 && f7955b.get(size + (-1)) == this);
            f7955b.remove(size - 1);
        }
    }

    public void d_renamed() {
        if (this.e_renamed.size() > 0) {
            int[] iArr = new int[this.e_renamed.size()];
            java.util.Iterator<java.lang.Integer> it = this.e_renamed.iterator();
            int i_renamed = 0;
            while (it.hasNext()) {
                iArr[i_renamed] = it.next().intValue();
                i_renamed++;
            }
            this.e_renamed.clear();
            c_renamed(i_renamed, iArr, 0);
        }
        if (this.f7953c.size() > 0) {
            int[] iArr2 = new int[this.f7953c.size()];
            java.util.Iterator<java.lang.Integer> it2 = this.f7953c.iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                iArr2[i2] = it2.next().intValue();
                i2++;
            }
            this.f7953c.clear();
            a_renamed(i2, iArr2, 0);
        }
        if (this.d_renamed.size() > 0) {
            int[] iArr3 = new int[this.d_renamed.size()];
            java.util.Iterator<java.lang.Integer> it3 = this.d_renamed.iterator();
            int i3 = 0;
            while (it3.hasNext()) {
                iArr3[i3] = it3.next().intValue();
                i3++;
            }
            this.d_renamed.clear();
            b_renamed(i3, iArr3, 0);
        }
        if (this.f7952b.size() > 0) {
            java.util.Iterator<java.lang.Integer> it4 = this.f7952b.iterator();
            while (it4.hasNext()) {
                f_renamed(it4.next().intValue());
            }
            this.f7952b.clear();
        }
        if (org.andresoviedo.a_renamed.a_renamed.c_renamed.b_renamed.f7957a.size() > 0) {
            java.util.Iterator<java.lang.Integer> it5 = org.andresoviedo.a_renamed.a_renamed.c_renamed.b_renamed.f7957a.keySet().iterator();
            while (it5.hasNext()) {
                e_renamed(it5.next().intValue());
            }
            org.andresoviedo.a_renamed.a_renamed.c_renamed.b_renamed.f7957a.clear();
        }
    }

    /* compiled from: GL.java */
    static class b_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        static java.util.Map<java.lang.Integer, org.andresoviedo.a_renamed.a_renamed.c_renamed.b_renamed> f7957a = new java.util.HashMap();

        /* renamed from: b_renamed, reason: collision with root package name */
        int f7958b;

        /* renamed from: c_renamed, reason: collision with root package name */
        boolean f7959c = false;
        java.util.List<java.lang.Integer> d_renamed = new java.util.ArrayList();
        java.util.Map<java.lang.Integer, java.lang.String> e_renamed = new java.util.HashMap();

        b_renamed(int i_renamed) {
            this.f7958b = i_renamed;
        }

        static org.andresoviedo.a_renamed.a_renamed.c_renamed.b_renamed a_renamed(int i_renamed) {
            com.b_renamed.a_renamed.n_renamed.a_renamed(org.andresoviedo.a_renamed.a_renamed.c_renamed.m_renamed(i_renamed) && f7957a.containsKey(java.lang.Integer.valueOf(i_renamed)));
            return f7957a.get(java.lang.Integer.valueOf(i_renamed));
        }

        static void b_renamed(int i_renamed) {
            java.util.Iterator<org.andresoviedo.a_renamed.a_renamed.c_renamed.b_renamed> it = f7957a.values().iterator();
            while (it.hasNext()) {
                it.next().f7959c = false;
            }
            a_renamed(i_renamed).f7959c = true;
        }
    }
}
