package com.oplus.camera.util;

/* compiled from: OpenGLUtils.java */
/* loaded from: classes2.dex */
public class k_renamed {
    public static int a_renamed(android.graphics.Bitmap bitmap) {
        if (bitmap == null) {
            return -1;
        }
        int[] iArr = new int[1];
        android.opengl.GLES20.glGenTextures(1, iArr, 0);
        android.opengl.GLES20.glBindTexture(3553, iArr[0]);
        android.opengl.GLES20.glTexParameterf(3553, 10240, 9729.0f);
        android.opengl.GLES20.glTexParameterf(3553, 10241, 9729.0f);
        android.opengl.GLES20.glTexParameterf(3553, 10242, 33071.0f);
        android.opengl.GLES20.glTexParameterf(3553, 10243, 33071.0f);
        android.opengl.GLUtils.texImage2D(3553, 0, bitmap, 0);
        return iArr[0];
    }

    public static void a_renamed(int i_renamed) {
        android.opengl.GLES20.glDeleteTextures(1, new int[]{i_renamed}, 0);
    }

    public static int a_renamed(java.lang.String str, java.lang.String str2) {
        int[] iArr = new int[1];
        int iA = a_renamed(35633, str);
        if (iA == 0) {
            return 0;
        }
        int iA2 = a_renamed(35632, str2);
        if (iA2 == 0) {
            android.opengl.GLES20.glDeleteShader(iA);
            return 0;
        }
        int iGlCreateProgram = android.opengl.GLES20.glCreateProgram();
        if (iGlCreateProgram == 0) {
            return 0;
        }
        android.opengl.GLES20.glAttachShader(iGlCreateProgram, iA);
        android.opengl.GLES20.glAttachShader(iGlCreateProgram, iA2);
        android.opengl.GLES20.glLinkProgram(iGlCreateProgram);
        android.opengl.GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 0) {
            com.oplus.camera.e_renamed.f_renamed(com.sensetime.utils.OpenGLUtils.TAG, "loadProgram error, " + android.opengl.GLES20.glGetProgramInfoLog(iGlCreateProgram));
            android.opengl.GLES20.glDeleteProgram(iGlCreateProgram);
            return 0;
        }
        android.opengl.GLES20.glDeleteShader(iA);
        android.opengl.GLES20.glDeleteShader(iA2);
        return iGlCreateProgram;
    }

    public static void a_renamed(java.lang.String str) {
        int iGlGetError = android.opengl.GLES20.glGetError();
        if (iGlGetError != 0) {
            com.oplus.camera.e_renamed.d_renamed(com.sensetime.utils.OpenGLUtils.TAG, "checkGlError, op: " + str + ", glError: 0x" + java.lang.Integer.toHexString(iGlGetError), new java.lang.Throwable());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B_renamed:104:0x00e4 A_renamed[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:112:0x00da A_renamed[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:121:? A_renamed[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:96:0x00ee A_renamed[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r8v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r8v11, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v12, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v14, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a_renamed(android.content.Context r8, int r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.util.k_renamed.a_renamed(android.content.Context, int):java.lang.String");
    }

    public static com.oplus.camera.gl_renamed.d_renamed b_renamed(android.content.Context context, int i_renamed) {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inScaled = false;
        android.graphics.Bitmap bitmapDecodeResource = android.graphics.BitmapFactory.decodeResource(context.getResources(), i_renamed, options);
        if (bitmapDecodeResource == null) {
            com.oplus.camera.e_renamed.f_renamed(com.sensetime.utils.OpenGLUtils.TAG, "loadTextureFromDisk: load texture failed from " + i_renamed);
            return null;
        }
        return new com.oplus.camera.gl_renamed.d_renamed(bitmapDecodeResource);
    }

    public static int a_renamed(int i_renamed, java.lang.String str) {
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
        com.oplus.camera.e_renamed.f_renamed(com.sensetime.utils.OpenGLUtils.TAG, "loadShader, Could not compile shader " + i_renamed + ": " + android.opengl.GLES20.glGetShaderInfoLog(iGlCreateShader));
        android.opengl.GLES20.glDeleteShader(iGlCreateShader);
        return 0;
    }

    public static int b_renamed(java.lang.String str, java.lang.String str2) {
        int iA = a_renamed(35633, str);
        if (iA == 0) {
            a_renamed("loadVertexShader");
            return 0;
        }
        int iA2 = a_renamed(35632, str2);
        if (iA2 == 0) {
            a_renamed("loadFragmentShader");
            return 0;
        }
        int iGlCreateProgram = android.opengl.GLES20.glCreateProgram();
        if (iGlCreateProgram == 0) {
            a_renamed("glCreateProgram");
            return 0;
        }
        android.opengl.GLES20.glAttachShader(iGlCreateProgram, iA);
        a_renamed("glAttachVertexShader");
        android.opengl.GLES20.glAttachShader(iGlCreateProgram, iA2);
        a_renamed("glAttachFragmentShader");
        android.opengl.GLES20.glLinkProgram(iGlCreateProgram);
        int[] iArr = new int[1];
        android.opengl.GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        if (1 == iArr[0]) {
            return iGlCreateProgram;
        }
        com.oplus.camera.e_renamed.f_renamed(com.sensetime.utils.OpenGLUtils.TAG, "createProgram, Could not link program: " + android.opengl.GLES20.glGetProgramInfoLog(iGlCreateProgram));
        android.opengl.GLES20.glDeleteProgram(iGlCreateProgram);
        return 0;
    }

    public static java.lang.String a_renamed(java.lang.String str, android.content.res.Resources resources) throws java.io.IOException {
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.io.InputStream inputStreamOpen;
        java.lang.String str2;
        java.lang.String strReplaceAll = null;
        try {
            byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            try {
                inputStreamOpen = resources.getAssets().open(str);
                while (true) {
                    try {
                        int i_renamed = inputStreamOpen.read();
                        if (i_renamed == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(i_renamed);
                    } catch (java.lang.Throwable th) {
                        th = th;
                    }
                }
                str2 = new java.lang.String(byteArrayOutputStream.toByteArray(), "UTF-8");
            } finally {
            }
        } catch (java.lang.Exception e_renamed) {
            e_renamed = e_renamed;
            e_renamed.printStackTrace();
            return strReplaceAll;
        }
        try {
            strReplaceAll = str2.replaceAll("\\r_renamed\\n_renamed", "\n_renamed");
            if (inputStreamOpen != null) {
                inputStreamOpen.close();
            }
            byteArrayOutputStream.close();
        } catch (java.lang.Exception e2) {
            e_renamed = e2;
            strReplaceAll = str2;
            e_renamed.printStackTrace();
            return strReplaceAll;
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (java.lang.Throwable th3) {
                    th.addSuppressed(th3);
                }
            }
            throw th;
        }
        return strReplaceAll;
    }

    public static void a_renamed(int[] iArr, int[] iArr2, int i_renamed, int i2) {
        android.opengl.GLES31.glGenFramebuffers(iArr.length, iArr, 0);
        android.opengl.GLES31.glGenTextures(iArr2.length, iArr2, 0);
        for (int i3 = 0; i3 < iArr2.length; i3++) {
            android.opengl.GLES31.glBindTexture(3553, iArr2[i3]);
            android.opengl.GLES31.glTexStorage2D(3553, 1, 32856, i_renamed, i2);
            android.opengl.GLES31.glTexParameterf(3553, 10240, 9729.0f);
            android.opengl.GLES31.glTexParameterf(3553, 10241, 9729.0f);
            android.opengl.GLES31.glTexParameterf(3553, 10242, 33071.0f);
            android.opengl.GLES31.glTexParameterf(3553, 10243, 33071.0f);
            android.opengl.GLES31.glBindFramebuffer(36160, iArr[i3]);
            android.opengl.GLES31.glFramebufferTexture2D(36160, 36064, 3553, iArr2[i3], 0);
            android.opengl.GLES31.glBindTexture(3553, 0);
            android.opengl.GLES31.glBindFramebuffer(36160, 0);
        }
        a_renamed("createStorageFrameBuffer");
    }

    public static java.nio.FloatBuffer a_renamed(float[] fArr) {
        java.nio.ByteBuffer byteBufferAllocateDirect = java.nio.ByteBuffer.allocateDirect(fArr.length * 4);
        byteBufferAllocateDirect.order(java.nio.ByteOrder.nativeOrder());
        java.nio.FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr);
        floatBufferAsFloatBuffer.position(0);
        return floatBufferAsFloatBuffer;
    }
}
