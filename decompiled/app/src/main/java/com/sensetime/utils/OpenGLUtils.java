package com.sensetime.utils;

/* loaded from: classes2.dex */
public class OpenGLUtils {
    public static final int NO_TEXTURE = -1;
    public static final java.lang.String TAG = "OpenGLUtils";

    public static int loadShader(int i_renamed, java.lang.String str) {
        int iGlCreateShader = android.opengl.GLES20.glCreateShader(i_renamed);
        if (iGlCreateShader == 0) {
            return iGlCreateShader;
        }
        android.opengl.GLES20.glShaderSource(iGlCreateShader, str);
        android.opengl.GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        android.opengl.GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        android.util.Log.e_renamed("ES20_ERROR", "Could not compile shader " + i_renamed + ":");
        android.util.Log.e_renamed("ES20_ERROR", android.opengl.GLES20.glGetShaderInfoLog(iGlCreateShader));
        android.opengl.GLES20.glDeleteShader(iGlCreateShader);
        return 0;
    }

    public static int createProgram(java.lang.String str, java.lang.String str2) {
        int iLoadShader;
        int iLoadShader2 = loadShader(35633, str);
        if (iLoadShader2 == 0 || (iLoadShader = loadShader(35632, str2)) == 0) {
            return 0;
        }
        int iGlCreateProgram = android.opengl.GLES20.glCreateProgram();
        if (iGlCreateProgram != 0) {
            android.opengl.GLES20.glAttachShader(iGlCreateProgram, iLoadShader2);
            checkGlError("glAttachShader");
            android.opengl.GLES20.glAttachShader(iGlCreateProgram, iLoadShader);
            checkGlError("glAttachShader");
            android.opengl.GLES20.glLinkProgram(iGlCreateProgram);
            int[] iArr = new int[1];
            android.opengl.GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                android.util.Log.e_renamed("ES20_ERROR", "Could not link program: ");
                android.util.Log.e_renamed("ES20_ERROR", android.opengl.GLES20.glGetProgramInfoLog(iGlCreateProgram));
                android.opengl.GLES20.glDeleteProgram(iGlCreateProgram);
                return 0;
            }
        }
        return iGlCreateProgram;
    }

    public static void checkGlError(java.lang.String str) {
        int iGlGetError = android.opengl.GLES20.glGetError();
        if (iGlGetError == 0) {
            return;
        }
        android.util.Log.e_renamed("ES20_ERROR", str + ": glError " + iGlGetError);
        throw new java.lang.RuntimeException(str + ": glError " + iGlGetError);
    }

    public static java.lang.String loadFromAssetsFile(java.lang.String str, android.content.res.Resources resources) throws java.lang.Throwable {
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.lang.Throwable th;
        java.io.InputStream inputStreamOpen;
        java.lang.String str2;
        java.io.ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            inputStreamOpen = resources.getAssets().open(str);
            try {
                try {
                    byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                    while (true) {
                        try {
                            try {
                                int i_renamed = inputStreamOpen.read();
                                if (i_renamed == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(i_renamed);
                            } catch (java.lang.Exception e_renamed) {
                                e_renamed = e_renamed;
                                str2 = null;
                            }
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (java.io.IOException e2) {
                                    e2.printStackTrace();
                                    throw th;
                                }
                            }
                            if (inputStreamOpen != null) {
                                inputStreamOpen.close();
                            }
                            throw th;
                        }
                    }
                    str2 = new java.lang.String(byteArrayOutputStream.toByteArray(), "UTF-8");
                    try {
                        java.lang.String strReplaceAll = str2.replaceAll("\\r_renamed\\n_renamed", "\n_renamed");
                        try {
                            byteArrayOutputStream.close();
                            if (inputStreamOpen == null) {
                                return strReplaceAll;
                            }
                            inputStreamOpen.close();
                            return strReplaceAll;
                        } catch (java.io.IOException e3) {
                            e3.printStackTrace();
                            return strReplaceAll;
                        }
                    } catch (java.lang.Exception e4) {
                        e_renamed = e4;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        e_renamed.printStackTrace();
                        if (byteArrayOutputStream2 != null) {
                            try {
                                byteArrayOutputStream2.close();
                            } catch (java.io.IOException e5) {
                                e5.printStackTrace();
                                return str2;
                            }
                        }
                        if (inputStreamOpen != null) {
                            inputStreamOpen.close();
                        }
                        return str2;
                    }
                } catch (java.lang.Throwable th3) {
                    java.io.ByteArrayOutputStream byteArrayOutputStream3 = byteArrayOutputStream2;
                    th = th3;
                    byteArrayOutputStream = byteArrayOutputStream3;
                }
            } catch (java.lang.Exception e6) {
                e_renamed = e6;
                str2 = null;
            }
        } catch (java.lang.Exception e7) {
            e_renamed = e7;
            inputStreamOpen = null;
            str2 = null;
        } catch (java.lang.Throwable th4) {
            byteArrayOutputStream = null;
            th = th4;
            inputStreamOpen = null;
        }
    }

    public static int loadSingleChannelTexture(java.nio.ByteBuffer byteBuffer, int i_renamed, int i2, int i3) {
        int[] iArr = new int[1];
        if (i3 == -1) {
            android.opengl.GLES20.glGenTextures(1, iArr, 0);
            android.opengl.GLES20.glBindTexture(3553, iArr[0]);
            android.opengl.GLES20.glTexParameterf(3553, 10240, 9729.0f);
            android.opengl.GLES20.glTexParameterf(3553, 10241, 9729.0f);
            android.opengl.GLES20.glTexParameterf(3553, 10242, 33071.0f);
            android.opengl.GLES20.glTexParameterf(3553, 10243, 33071.0f);
            android.opengl.GLES20.glTexImage2D(3553, 0, 6406, i_renamed, i2, 0, 6406, 5121, byteBuffer);
        } else {
            android.opengl.GLES20.glBindTexture(3553, i3);
            android.opengl.GLES20.glTexSubImage2D(3553, 0, 0, 0, i_renamed, i2, 6406, 5121, byteBuffer);
            iArr[0] = i3;
        }
        return iArr[0];
    }

    public static int loadTexture(java.nio.Buffer buffer, int i_renamed, int i2, int i3) {
        int[] iArr = new int[1];
        if (i3 == -1) {
            android.opengl.GLES20.glGenTextures(1, iArr, 0);
            android.opengl.GLES20.glBindTexture(3553, iArr[0]);
            android.opengl.GLES20.glTexParameterf(3553, 10240, 9729.0f);
            android.opengl.GLES20.glTexParameterf(3553, 10241, 9729.0f);
            android.opengl.GLES20.glTexParameterf(3553, 10242, 33071.0f);
            android.opengl.GLES20.glTexParameterf(3553, 10243, 33071.0f);
            android.opengl.GLES20.glTexImage2D(3553, 0, 6408, i_renamed, i2, 0, 6408, 5121, buffer);
        } else {
            android.opengl.GLES20.glBindTexture(3553, i3);
            android.opengl.GLES20.glTexSubImage2D(3553, 0, 0, 0, i_renamed, i2, 6408, 5121, buffer);
            iArr[0] = i3;
        }
        return iArr[0];
    }

    public static int loadTexture(android.graphics.Bitmap bitmap, int i_renamed, boolean z_renamed) {
        int[] iArr = {-1};
        if (i_renamed == -1) {
            android.opengl.GLES20.glGenTextures(1, iArr, 0);
            android.opengl.GLES20.glBindTexture(3553, iArr[0]);
            android.opengl.GLES20.glTexParameterf(3553, 10240, 9729.0f);
            android.opengl.GLES20.glTexParameterf(3553, 10241, 9729.0f);
            android.opengl.GLES20.glTexParameterf(3553, 10242, 33071.0f);
            android.opengl.GLES20.glTexParameterf(3553, 10243, 33071.0f);
            android.opengl.GLUtils.texImage2D(3553, 0, bitmap, 0);
        } else {
            android.opengl.GLES20.glBindTexture(3553, i_renamed);
            android.opengl.GLUtils.texSubImage2D(3553, 0, 0, 0, bitmap);
            iArr[0] = i_renamed;
        }
        if (z_renamed) {
            bitmap.recycle();
        }
        return iArr[0];
    }

    public static void readPix(int i_renamed, int i2, int i3, byte[] bArr) {
        android.opengl.GLES20.glFinish();
        int[] iArr = {0};
        java.nio.IntBuffer intBufferWrap = java.nio.IntBuffer.wrap(iArr);
        android.opengl.GLES20.glGenFramebuffers(1, intBufferWrap);
        android.opengl.GLES20.glBindFramebuffer(36160, iArr[0]);
        android.opengl.GLES20.glFramebufferTexture2D(36160, 36064, 3553, i_renamed, 0);
        android.opengl.GLES20.glReadPixels(0, 0, i2, i3, 6408, 5121, java.nio.ByteBuffer.wrap(bArr));
        android.opengl.GLES20.glDeleteFramebuffers(1, intBufferWrap);
        android.opengl.GLES20.glFinish();
    }

    public static int genOESTexture() {
        int[] iArr = {-1};
        android.opengl.GLES20.glGenTextures(1, iArr, 0);
        android.opengl.GLES20.glBindTexture(36197, iArr[0]);
        android.opengl.GLES20.glTexParameterf(36197, 10241, 9729.0f);
        android.opengl.GLES20.glTexParameterf(36197, 10240, 9729.0f);
        android.opengl.GLES20.glTexParameteri(36197, 10242, 33071);
        android.opengl.GLES20.glTexParameteri(36197, 10243, 33071);
        return iArr[0];
    }

    public static void destroyTexture(int i_renamed) {
        if (-1 != i_renamed) {
            android.opengl.GLES20.glDeleteTextures(1, new int[]{i_renamed}, 0);
        }
    }
}
