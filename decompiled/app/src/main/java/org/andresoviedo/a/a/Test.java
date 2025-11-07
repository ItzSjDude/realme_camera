package org.andresoviedo.a_renamed.a_renamed;

/* compiled from: GLUtil.java */
/* loaded from: classes2.dex */
public final class d_renamed {
    public static int a_renamed(int i_renamed, int i2, java.lang.String[] strArr) {
        int iA = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.a_renamed();
        if (iA != 0) {
            org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.a_renamed(iA, i_renamed);
            org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.a_renamed(iA, i2);
            if (strArr != null) {
                int length = strArr.length;
                for (int i3 = 0; i3 < length; i3++) {
                    org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.a_renamed(iA, i3, strArr[i3]);
                }
            }
            org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.n_renamed(iA);
            int[] iArr = new int[1];
            org.andresoviedo.a_renamed.a_renamed.c_renamed cVar = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
            org.andresoviedo.a_renamed.a_renamed.c_renamed cVar2 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
            cVar.a_renamed(iA, 35714, iArr, 0);
            if (iArr[0] == 0) {
                android.util.Log.e_renamed("GLUtil", "Error compiling program: " + org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.k_renamed(iA));
                org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.e_renamed(iA);
                iA = 0;
            }
        }
        if (iA != 0) {
            return iA;
        }
        throw new java.lang.RuntimeException("Error creating program.");
    }

    public static int a_renamed(int i_renamed, java.lang.String str) {
        int iD = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.d_renamed(i_renamed);
        org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.c_renamed(iD, str);
        org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.c_renamed(iD);
        int[] iArr = new int[1];
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar2 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        cVar.b_renamed(iD, 35713, iArr, 0);
        android.util.Log.d_renamed("GLUtil", "Shader compilation info: " + org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.l_renamed(iD));
        if (iArr[0] == 0) {
            android.util.Log.e_renamed("GLUtil", "Shader error: " + org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.l_renamed(iD) + "\n_renamed" + str);
            org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.f_renamed(iD);
        }
        return iD;
    }

    public static int a_renamed(java.io.InputStream inputStream) {
        android.util.Log.v_renamed("GLUtil", "Loading texture from stream...");
        int[] iArr = new int[1];
        org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.d_renamed(1, iArr, 0);
        a_renamed("glGenTextures");
        if (iArr[0] == 0) {
            throw new java.lang.RuntimeException("Error loading texture.");
        }
        android.util.Log.v_renamed("GLUtil", "Handler: " + iArr[0]);
        android.graphics.Bitmap bitmapB = b_renamed(inputStream);
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar2 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        cVar.b_renamed(3553, iArr[0]);
        a_renamed("glBindTexture");
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar3 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        android.opengl.GLUtils.texImage2D(3553, 0, bitmapB, 0);
        a_renamed("texImage2D");
        bitmapB.recycle();
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar4 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar5 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar6 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar7 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        cVar4.b_renamed(3553, 10241, 9728);
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar8 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar9 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar10 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        org.andresoviedo.a_renamed.a_renamed.c_renamed cVar11 = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
        cVar8.b_renamed(3553, 10240, 9728);
        android.util.Log.v_renamed("GLUtil", "Loaded texture ok");
        return iArr[0];
    }

    private static android.graphics.Bitmap b_renamed(java.io.InputStream inputStream) {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inScaled = false;
        android.graphics.Bitmap bitmapDecodeStream = android.graphics.BitmapFactory.decodeStream(inputStream, null, options);
        if (bitmapDecodeStream != null) {
            return bitmapDecodeStream;
        }
        throw new java.lang.RuntimeException("couldn't_renamed load bitmap");
    }

    public static boolean a_renamed(java.lang.String str) {
        boolean z_renamed = false;
        while (true) {
            int iB = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a.b_renamed();
            org.andresoviedo.a_renamed.a_renamed.c_renamed cVar = org.andresoviedo.a_renamed.a_renamed.c_renamed.f7951a;
            if (iB == 0) {
                return z_renamed;
            }
            android.util.Log.e_renamed("GLUtil", str + ": glError " + iB);
            z_renamed = true;
            android.util.Log.e_renamed("GLUtil", java.lang.Thread.currentThread().getStackTrace()[3].toString());
            android.util.Log.e_renamed("GLUtil", java.lang.Thread.currentThread().getStackTrace()[4].toString());
            android.util.Log.e_renamed("GLUtil", java.lang.Thread.currentThread().getStackTrace()[5].toString());
            android.util.Log.e_renamed("GLUtil", java.lang.Thread.currentThread().getStackTrace()[6].toString());
        }
    }

    public static java.nio.ByteBuffer a_renamed(int i_renamed) {
        java.nio.ByteBuffer byteBufferAllocateDirect = java.nio.ByteBuffer.allocateDirect(i_renamed);
        byteBufferAllocateDirect.order(java.nio.ByteOrder.nativeOrder());
        return byteBufferAllocateDirect;
    }

    public static java.nio.FloatBuffer b_renamed(int i_renamed) {
        return a_renamed(i_renamed * 4).asFloatBuffer();
    }
}
