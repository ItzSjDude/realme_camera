package a_renamed.a_renamed.b_renamed.f_renamed;

/* loaded from: classes.dex */
public class f_renamed {
    public static a_renamed.a_renamed.b_renamed.c_renamed.d_renamed a_renamed(android.graphics.Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int[] iArr = {0};
        a_renamed(1, iArr, 0, 6408, bitmap.getWidth(), bitmap.getHeight());
        android.opengl.GLES20.glBindTexture(3553, iArr[0]);
        android.opengl.GLES20.glTexParameterf(3553, 10241, 9729.0f);
        android.opengl.GLES20.glTexParameterf(3553, 10240, 9729.0f);
        android.opengl.GLES20.glTexParameterf(3553, 10242, 33071.0f);
        android.opengl.GLES20.glTexParameterf(3553, 10243, 33071.0f);
        android.opengl.GLUtils.texImage2D(3553, 0, 6408, bitmap, 0);
        return b_renamed(iArr[0], 6408, bitmap.getWidth(), bitmap.getHeight());
    }

    public static java.nio.ByteBuffer a_renamed(int i_renamed, int i2, int i3) {
        java.nio.ByteBuffer byteBufferAllocate = java.nio.ByteBuffer.allocate(i2 * i3 * 4);
        int[] iArr = new int[1];
        android.opengl.GLES20.glGenFramebuffers(1, iArr, 0);
        a_renamed(iArr[0], i_renamed);
        android.opengl.GLES20.glReadPixels(0, 0, i2, i3, 6408, 5121, byteBufferAllocate);
        a_renamed();
        android.opengl.GLES20.glDeleteFramebuffers(1, iArr, 0);
        return byteBufferAllocate;
    }

    public static void a_renamed() {
        android.opengl.GLES20.glBindFramebuffer(36160, 0);
    }

    public static void a_renamed(int i_renamed) {
        android.opengl.GLES20.glBindTexture(3553, i_renamed);
        android.opengl.GLES20.glDeleteTextures(1, new int[]{i_renamed}, 0);
        android.opengl.GLES20.glFlush();
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("del tex");
    }

    public static void a_renamed(int i_renamed, int i2) {
        android.opengl.GLES20.glBindFramebuffer(36160, i_renamed);
        android.opengl.GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
    }

    public static void a_renamed(int i_renamed, int i2, int i3, int i4) {
        int[] iArr = new int[1];
        android.opengl.GLES20.glGenFramebuffers(1, iArr, 0);
        android.opengl.GLES20.glBindFramebuffer(36160, iArr[0]);
        android.opengl.GLES20.glFramebufferTexture2D(36160, 36064, 3553, i_renamed, 0);
        android.opengl.GLES20.glBindTexture(3553, i2);
        android.opengl.GLES20.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, i3, i4);
        android.opengl.GLES20.glBindFramebuffer(36160, 0);
        android.opengl.GLES20.glBindTexture(3553, 0);
        android.opengl.GLES20.glDeleteFramebuffers(1, iArr, 0);
    }

    public static void a_renamed(int i_renamed, int i2, android.graphics.Rect rect) {
        java.nio.ByteBuffer byteBufferAllocate = java.nio.ByteBuffer.allocate(rect.width() * rect.height() * 4);
        int[] iArr = new int[1];
        android.opengl.GLES20.glGenFramebuffers(1, iArr, 0);
        a_renamed(iArr[0], i_renamed);
        android.opengl.GLES20.glReadPixels(rect.left, rect.top, rect.width(), rect.height(), 6408, 5121, byteBufferAllocate);
        a_renamed();
        android.opengl.GLES20.glDeleteFramebuffers(1, iArr, 0);
        android.opengl.GLES20.glBindTexture(3553, i2);
        android.opengl.GLES20.glTexImage2D(3553, 0, 6408, rect.width(), rect.height(), 0, 6408, 5121, byteBufferAllocate);
        android.opengl.GLES20.glBindTexture(3553, 0);
    }

    public static void a_renamed(int i_renamed, int[] iArr, int i2, int i3, int i4, int i5) {
        a_renamed(i_renamed, iArr, i2, i3, 5121, i4, i5);
    }

    public static void a_renamed(int i_renamed, int[] iArr, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        android.opengl.GLES20.glGenTextures(i_renamed, iArr, i2);
        for (int i9 = 0; i9 < i_renamed; i9++) {
            a_renamed.a_renamed.b_renamed.c_renamed.g_renamed.c_renamed(iArr[i2 + i9]);
        }
        for (int i10 = 0; i10 < i_renamed; i10++) {
            android.opengl.GLES20.glBindTexture(3553, iArr[i10]);
            a_renamed.a_renamed.b_renamed.f_renamed.g_renamed.a_renamed("genTexturesWithParameter::texId=%d_renamed::width=%d_renamed::height=%d_renamed", java.lang.Integer.valueOf(iArr[i10]), java.lang.Integer.valueOf(i5), java.lang.Integer.valueOf(i6));
            if (android.os.Build.VERSION.SDK_INT < 18 || !(i4 == 5126 || i4 == 5131 || i4 == 36193)) {
                android.opengl.GLES20.glTexImage2D(3553, 0, i3, i5, i6, 0, i3, i4, null);
            } else {
                if (i3 == 6408) {
                    i8 = 34842;
                } else if (i3 == 6407) {
                    i8 = 34843;
                } else {
                    i7 = i3;
                    android.opengl.GLES30.glTexImage2D(3553, 0, i7, i5, i6, 0, i3, i4, null);
                }
                i7 = i8;
                android.opengl.GLES30.glTexImage2D(3553, 0, i7, i5, i6, 0, i3, i4, null);
            }
            b_renamed();
        }
        android.opengl.GLES20.glBindTexture(3553, 0);
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("gen tex");
    }

    public static void a_renamed(a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar, int i_renamed, int i2) {
        if (i_renamed <= 0) {
            i_renamed = 1;
        }
        dVar.f35b = i_renamed;
        if (i2 <= 0) {
            i2 = 1;
        }
        dVar.f36c = i2;
    }

    public static void a_renamed(a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar, int i_renamed, int i2, int i3, int i4) {
        if (dVar != null) {
            if (dVar.f35b == i3 && dVar.f36c == i4) {
                return;
            }
            android.opengl.GLES30.glBindTexture(3553, dVar.f34a);
            android.opengl.GLES30.glTexImage2D(3553, 0, i_renamed, i3, i4, 0, dVar.d_renamed, i2, null);
            if (i3 <= 0) {
                i3 = 1;
            }
            dVar.f35b = i3;
            dVar.f36c = i4 > 0 ? i4 : 1;
            android.opengl.GLES30.glBindTexture(3553, 0);
            a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("resize tex gl3");
        }
    }

    public static void a_renamed(a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar, a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar2) {
        int i_renamed = dVar.f34a;
        dVar.f34a = dVar2.f34a;
        dVar2.f34a = i_renamed;
    }

    public static void a_renamed(boolean z_renamed, boolean z2) {
        if (!z_renamed) {
            android.opengl.GLES20.glDisable(3042);
            return;
        }
        android.opengl.GLES20.glEnable(3042);
        if (z2) {
            android.opengl.GLES20.glBlendFunc(1, 771);
        } else {
            android.opengl.GLES20.glBlendFuncSeparate(com.arcsoft.arcsoftjni.ArcSoftOffscreen.ASVL_PAF_RGB32_B8G8R8A8, 771, 1, 771);
        }
    }

    public static a_renamed.a_renamed.b_renamed.c_renamed.d_renamed b_renamed(int i_renamed, int i2, int i3, int i4) {
        a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar = new a_renamed.a_renamed.b_renamed.c_renamed.d_renamed();
        dVar.f34a = i_renamed;
        dVar.d_renamed = i2;
        dVar.f35b = i3;
        dVar.f36c = i4;
        return dVar;
    }

    public static void b_renamed() {
        android.opengl.GLES20.glTexParameterf(3553, 10241, 9729.0f);
        android.opengl.GLES20.glTexParameterf(3553, 10240, 9729.0f);
        android.opengl.GLES20.glTexParameterf(3553, 10242, 33071.0f);
        android.opengl.GLES20.glTexParameterf(3553, 10243, 33071.0f);
    }

    public static void b_renamed(int i_renamed, int i2, int i3) {
        android.opengl.GLES20.glBindTexture(3553, i_renamed);
        android.opengl.GLES20.glTexImage2D(3553, 0, 6408, i2, i3, 0, 6408, 5121, null);
        android.opengl.GLES20.glBindTexture(3553, 0);
        a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("resize tex id_renamed");
    }

    public static void b_renamed(int i_renamed, int i2, android.graphics.Rect rect) {
        int[] iArr = new int[1];
        android.opengl.GLES20.glGenFramebuffers(1, iArr, 0);
        android.opengl.GLES20.glBindFramebuffer(36160, iArr[0]);
        android.opengl.GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
        android.opengl.GLES20.glBindTexture(3553, i_renamed);
        android.opengl.GLES20.glCopyTexSubImage2D(3553, 0, rect.left, rect.top, 0, 0, rect.width(), rect.height());
        android.opengl.GLES20.glBindFramebuffer(36160, 0);
        android.opengl.GLES20.glBindTexture(3553, 0);
        android.opengl.GLES20.glDeleteFramebuffers(1, iArr, 0);
    }

    public static void b_renamed(a_renamed.a_renamed.b_renamed.c_renamed.d_renamed dVar, int i_renamed, int i2) {
        if (dVar != null) {
            if (dVar.f35b == i_renamed && dVar.f36c == i2) {
                return;
            }
            android.opengl.GLES20.glBindTexture(3553, dVar.f34a);
            int i3 = dVar.d_renamed;
            android.opengl.GLES20.glTexImage2D(3553, 0, i3, i_renamed, i2, 0, i3, 5121, null);
            if (i_renamed <= 0) {
                i_renamed = 1;
            }
            dVar.f35b = i_renamed;
            if (i2 <= 0) {
                i2 = 1;
            }
            dVar.f36c = i2;
            android.opengl.GLES20.glBindTexture(3553, 0);
            a_renamed.a_renamed.b_renamed.a_renamed.a_renamed("resize tex");
        }
    }

    public static void c_renamed(int i_renamed, int i2, int i3, int i4) {
        android.opengl.GLES20.glTexParameterf(3553, 10242, i_renamed);
        android.opengl.GLES20.glTexParameterf(3553, 10243, i2);
        android.opengl.GLES20.glTexParameterf(3553, 10241, i3);
        android.opengl.GLES20.glTexParameterf(3553, 10240, i4);
    }
}
