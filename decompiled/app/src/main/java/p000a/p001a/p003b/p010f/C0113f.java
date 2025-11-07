package p000a.p001a.p003b.p010f;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLUtils;
import android.os.Build;
import com.arcsoft.arcsoftjni.ArcSoftOffscreen;
import java.nio.ByteBuffer;
import p000a.p001a.p003b.C0001a;
import p000a.p001a.p003b.p007c.C0094d;
import p000a.p001a.p003b.p007c.C0097g;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12.COUIBaseListPopupWindow_12 */
/* loaded from: classes.dex */
public class C0113f {
    /* renamed from: PlatformImplementations.kt_3 */
    public static C0094d m473a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int[] iArr = {0};
        m480a(1, iArr, 0, 6408, bitmap.getWidth(), bitmap.getHeight());
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLUtils.texImage2D(3553, 0, 6408, bitmap, 0);
        return m486b(iArr[0], 6408, bitmap.getWidth(), bitmap.getHeight());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static ByteBuffer m474a(int OplusGLSurfaceView_13, int i2, int i3) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i2 * i3 * 4);
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        m477a(iArr[0], OplusGLSurfaceView_13);
        GLES20.glReadPixels(0, 0, i2, i3, 6408, 5121, byteBufferAllocate);
        m475a();
        GLES20.glDeleteFramebuffers(1, iArr, 0);
        return byteBufferAllocate;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m475a() {
        GLES20.glBindFramebuffer(36160, 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m476a(int OplusGLSurfaceView_13) {
        GLES20.glBindTexture(3553, OplusGLSurfaceView_13);
        GLES20.glDeleteTextures(1, new int[]{OplusGLSurfaceView_13}, 0);
        GLES20.glFlush();
        C0001a.m11a("del tex");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m477a(int OplusGLSurfaceView_13, int i2) {
        GLES20.glBindFramebuffer(36160, OplusGLSurfaceView_13);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m478a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, OplusGLSurfaceView_13, 0);
        GLES20.glBindTexture(3553, i2);
        GLES20.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, i3, i4);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glBindTexture(3553, 0);
        GLES20.glDeleteFramebuffers(1, iArr, 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m479a(int OplusGLSurfaceView_13, int i2, Rect rect) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(rect.width() * rect.height() * 4);
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        m477a(iArr[0], OplusGLSurfaceView_13);
        GLES20.glReadPixels(rect.left, rect.top, rect.width(), rect.height(), 6408, 5121, byteBufferAllocate);
        m475a();
        GLES20.glDeleteFramebuffers(1, iArr, 0);
        GLES20.glBindTexture(3553, i2);
        GLES20.glTexImage2D(3553, 0, 6408, rect.width(), rect.height(), 0, 6408, 5121, byteBufferAllocate);
        GLES20.glBindTexture(3553, 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m480a(int OplusGLSurfaceView_13, int[] iArr, int i2, int i3, int i4, int i5) {
        m481a(OplusGLSurfaceView_13, iArr, i2, i3, 5121, i4, i5);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m481a(int OplusGLSurfaceView_13, int[] iArr, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        GLES20.glGenTextures(OplusGLSurfaceView_13, iArr, i2);
        for (int i9 = 0; i9 < OplusGLSurfaceView_13; i9++) {
            C0097g.m306c(iArr[i2 + i9]);
        }
        for (int i10 = 0; i10 < OplusGLSurfaceView_13; i10++) {
            GLES20.glBindTexture(3553, iArr[i10]);
            C0114g.m492a("genTexturesWithParameter::texId=%IntrinsicsJvm.kt_5::width=%IntrinsicsJvm.kt_5::height=%IntrinsicsJvm.kt_5", Integer.valueOf(iArr[i10]), Integer.valueOf(i5), Integer.valueOf(i6));
            if (Build.VERSION.SDK_INT < 18 || !(i4 == 5126 || i4 == 5131 || i4 == 36193)) {
                GLES20.glTexImage2D(3553, 0, i3, i5, i6, 0, i3, i4, null);
            } else {
                if (i3 == 6408) {
                    i8 = 34842;
                } else if (i3 == 6407) {
                    i8 = 34843;
                } else {
                    i7 = i3;
                    GLES30.glTexImage2D(3553, 0, i7, i5, i6, 0, i3, i4, null);
                }
                i7 = i8;
                GLES30.glTexImage2D(3553, 0, i7, i5, i6, 0, i3, i4, null);
            }
            m487b();
        }
        GLES20.glBindTexture(3553, 0);
        C0001a.m11a("gen tex");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m482a(C0094d c0094d, int OplusGLSurfaceView_13, int i2) {
        if (OplusGLSurfaceView_13 <= 0) {
            OplusGLSurfaceView_13 = 1;
        }
        c0094d.f388b = OplusGLSurfaceView_13;
        if (i2 <= 0) {
            i2 = 1;
        }
        c0094d.f389c = i2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m483a(C0094d c0094d, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        if (c0094d != null) {
            if (c0094d.f388b == i3 && c0094d.f389c == i4) {
                return;
            }
            GLES30.glBindTexture(3553, c0094d.f387a);
            GLES30.glTexImage2D(3553, 0, OplusGLSurfaceView_13, i3, i4, 0, c0094d.f390d, i2, null);
            if (i3 <= 0) {
                i3 = 1;
            }
            c0094d.f388b = i3;
            c0094d.f389c = i4 > 0 ? i4 : 1;
            GLES30.glBindTexture(3553, 0);
            C0001a.m11a("resize tex gl3");
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m484a(C0094d c0094d, C0094d c0094d2) {
        int OplusGLSurfaceView_13 = c0094d.f387a;
        c0094d.f387a = c0094d2.f387a;
        c0094d2.f387a = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m485a(boolean z, boolean z2) {
        if (!z) {
            GLES20.glDisable(3042);
            return;
        }
        GLES20.glEnable(3042);
        if (z2) {
            GLES20.glBlendFunc(1, 771);
        } else {
            GLES20.glBlendFuncSeparate(ArcSoftOffscreen.ASVL_PAF_RGB32_B8G8R8A8, 771, 1, 771);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static C0094d m486b(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        C0094d c0094d = new C0094d();
        c0094d.f387a = OplusGLSurfaceView_13;
        c0094d.f390d = i2;
        c0094d.f388b = i3;
        c0094d.f389c = i4;
        return c0094d;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m487b() {
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m488b(int OplusGLSurfaceView_13, int i2, int i3) {
        GLES20.glBindTexture(3553, OplusGLSurfaceView_13);
        GLES20.glTexImage2D(3553, 0, 6408, i2, i3, 0, 6408, 5121, null);
        GLES20.glBindTexture(3553, 0);
        C0001a.m11a("resize tex id_renamed");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m489b(int OplusGLSurfaceView_13, int i2, Rect rect) {
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
        GLES20.glBindTexture(3553, OplusGLSurfaceView_13);
        GLES20.glCopyTexSubImage2D(3553, 0, rect.left, rect.top, 0, 0, rect.width(), rect.height());
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glBindTexture(3553, 0);
        GLES20.glDeleteFramebuffers(1, iArr, 0);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m490b(C0094d c0094d, int OplusGLSurfaceView_13, int i2) {
        if (c0094d != null) {
            if (c0094d.f388b == OplusGLSurfaceView_13 && c0094d.f389c == i2) {
                return;
            }
            GLES20.glBindTexture(3553, c0094d.f387a);
            int i3 = c0094d.f390d;
            GLES20.glTexImage2D(3553, 0, i3, OplusGLSurfaceView_13, i2, 0, i3, 5121, null);
            if (OplusGLSurfaceView_13 <= 0) {
                OplusGLSurfaceView_13 = 1;
            }
            c0094d.f388b = OplusGLSurfaceView_13;
            if (i2 <= 0) {
                i2 = 1;
            }
            c0094d.f389c = i2;
            GLES20.glBindTexture(3553, 0);
            C0001a.m11a("resize tex");
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static void m491c(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        GLES20.glTexParameterf(3553, 10242, OplusGLSurfaceView_13);
        GLES20.glTexParameterf(3553, 10243, i2);
        GLES20.glTexParameterf(3553, 10241, i3);
        GLES20.glTexParameterf(3553, 10240, i4);
    }
}
