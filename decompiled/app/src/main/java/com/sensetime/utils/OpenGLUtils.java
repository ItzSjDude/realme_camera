package com.sensetime.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/* loaded from: classes2.dex */
public class OpenGLUtils {
    public static final int NO_TEXTURE = -1;
    public static final String TAG = "OpenGLUtils";

    public static int loadShader(int OplusGLSurfaceView_13, String str) {
        int iGlCreateShader = GLES20.glCreateShader(OplusGLSurfaceView_13);
        if (iGlCreateShader == 0) {
            return iGlCreateShader;
        }
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        Log.COUIBaseListPopupWindow_8("ES20_ERROR", "Could not compile shader " + OplusGLSurfaceView_13 + ":");
        Log.COUIBaseListPopupWindow_8("ES20_ERROR", GLES20.glGetShaderInfoLog(iGlCreateShader));
        GLES20.glDeleteShader(iGlCreateShader);
        return 0;
    }

    public static int createProgram(String str, String str2) {
        int iLoadShader;
        int iLoadShader2 = loadShader(35633, str);
        if (iLoadShader2 == 0 || (iLoadShader = loadShader(35632, str2)) == 0) {
            return 0;
        }
        int iGlCreateProgram = GLES20.glCreateProgram();
        if (iGlCreateProgram != 0) {
            GLES20.glAttachShader(iGlCreateProgram, iLoadShader2);
            checkGlError("glAttachShader");
            GLES20.glAttachShader(iGlCreateProgram, iLoadShader);
            checkGlError("glAttachShader");
            GLES20.glLinkProgram(iGlCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                Log.COUIBaseListPopupWindow_8("ES20_ERROR", "Could not link program: ");
                Log.COUIBaseListPopupWindow_8("ES20_ERROR", GLES20.glGetProgramInfoLog(iGlCreateProgram));
                GLES20.glDeleteProgram(iGlCreateProgram);
                return 0;
            }
        }
        return iGlCreateProgram;
    }

    public static void checkGlError(String str) {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError == 0) {
            return;
        }
        Log.COUIBaseListPopupWindow_8("ES20_ERROR", str + ": glError " + iGlGetError);
        throw new RuntimeException(str + ": glError " + iGlGetError);
    }

    public static String loadFromAssetsFile(String str, Resources resources) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        InputStream inputStreamOpen;
        String str2;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            inputStreamOpen = resources.getAssets().open(str);
            try {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            try {
                                int OplusGLSurfaceView_13 = inputStreamOpen.read();
                                if (OplusGLSurfaceView_13 == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(OplusGLSurfaceView_13);
                            } catch (Exception COUIBaseListPopupWindow_8) {
                                COUIBaseListPopupWindow_8 = COUIBaseListPopupWindow_8;
                                str2 = null;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException e2) {
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
                    str2 = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                    try {
                        String strReplaceAll = str2.replaceAll("\\r\\OplusGLSurfaceView_11", "\OplusGLSurfaceView_11");
                        try {
                            byteArrayOutputStream.close();
                            if (inputStreamOpen == null) {
                                return strReplaceAll;
                            }
                            inputStreamOpen.close();
                            return strReplaceAll;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            return strReplaceAll;
                        }
                    } catch (Exception e4) {
                        COUIBaseListPopupWindow_8 = e4;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        COUIBaseListPopupWindow_8.printStackTrace();
                        if (byteArrayOutputStream2 != null) {
                            try {
                                byteArrayOutputStream2.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                                return str2;
                            }
                        }
                        if (inputStreamOpen != null) {
                            inputStreamOpen.close();
                        }
                        return str2;
                    }
                } catch (Throwable th3) {
                    ByteArrayOutputStream byteArrayOutputStream3 = byteArrayOutputStream2;
                    th = th3;
                    byteArrayOutputStream = byteArrayOutputStream3;
                }
            } catch (Exception e6) {
                COUIBaseListPopupWindow_8 = e6;
                str2 = null;
            }
        } catch (Exception e7) {
            COUIBaseListPopupWindow_8 = e7;
            inputStreamOpen = null;
            str2 = null;
        } catch (Throwable th4) {
            byteArrayOutputStream = null;
            th = th4;
            inputStreamOpen = null;
        }
    }

    public static int loadSingleChannelTexture(ByteBuffer byteBuffer, int OplusGLSurfaceView_13, int i2, int i3) {
        int[] iArr = new int[1];
        if (i3 == -1) {
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(3553, iArr[0]);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glTexImage2D(3553, 0, 6406, OplusGLSurfaceView_13, i2, 0, 6406, 5121, byteBuffer);
        } else {
            GLES20.glBindTexture(3553, i3);
            GLES20.glTexSubImage2D(3553, 0, 0, 0, OplusGLSurfaceView_13, i2, 6406, 5121, byteBuffer);
            iArr[0] = i3;
        }
        return iArr[0];
    }

    public static int loadTexture(Buffer buffer, int OplusGLSurfaceView_13, int i2, int i3) {
        int[] iArr = new int[1];
        if (i3 == -1) {
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(3553, iArr[0]);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glTexImage2D(3553, 0, 6408, OplusGLSurfaceView_13, i2, 0, 6408, 5121, buffer);
        } else {
            GLES20.glBindTexture(3553, i3);
            GLES20.glTexSubImage2D(3553, 0, 0, 0, OplusGLSurfaceView_13, i2, 6408, 5121, buffer);
            iArr[0] = i3;
        }
        return iArr[0];
    }

    public static int loadTexture(Bitmap bitmap, int OplusGLSurfaceView_13, boolean z) {
        int[] iArr = {-1};
        if (OplusGLSurfaceView_13 == -1) {
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(3553, iArr[0]);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLUtils.texImage2D(3553, 0, bitmap, 0);
        } else {
            GLES20.glBindTexture(3553, OplusGLSurfaceView_13);
            GLUtils.texSubImage2D(3553, 0, 0, 0, bitmap);
            iArr[0] = OplusGLSurfaceView_13;
        }
        if (z) {
            bitmap.recycle();
        }
        return iArr[0];
    }

    public static void readPix(int OplusGLSurfaceView_13, int i2, int i3, byte[] bArr) {
        GLES20.glFinish();
        int[] iArr = {0};
        IntBuffer intBufferWrap = IntBuffer.wrap(iArr);
        GLES20.glGenFramebuffers(1, intBufferWrap);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, OplusGLSurfaceView_13, 0);
        GLES20.glReadPixels(0, 0, i2, i3, 6408, 5121, ByteBuffer.wrap(bArr));
        GLES20.glDeleteFramebuffers(1, intBufferWrap);
        GLES20.glFinish();
    }

    public static int genOESTexture() {
        int[] iArr = {-1};
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(36197, iArr[0]);
        GLES20.glTexParameterf(36197, 10241, 9729.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        return iArr[0];
    }

    public static void destroyTexture(int OplusGLSurfaceView_13) {
        if (-1 != OplusGLSurfaceView_13) {
            GLES20.glDeleteTextures(1, new int[]{OplusGLSurfaceView_13}, 0);
        }
    }
}
