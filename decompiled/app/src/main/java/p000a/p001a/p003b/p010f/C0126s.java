package p000a.p001a.p003b.p010f;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12.s */
/* loaded from: classes.dex */
public class C0126s {

    /* renamed from: PlatformImplementations.kt_3 */
    public int f566a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int[] f567b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int[] f568c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public int f569d = 0;

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean f570e = true;

    public C0126s(int OplusGLSurfaceView_13) {
        this.f566a = OplusGLSurfaceView_13;
        int i2 = this.f566a;
        this.f567b = new int[i2];
        this.f568c = new int[i2];
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m598a(Bitmap bitmap) {
        int OplusGLSurfaceView_13;
        int iHashCode = bitmap.hashCode();
        int i2 = 0;
        while (true) {
            if (i2 >= this.f566a) {
                i2 = -1;
                break;
            }
            if (iHashCode == this.f567b[i2]) {
                break;
            }
            i2++;
        }
        if (i2 != -1) {
            return this.f568c[i2];
        }
        this.f569d %= this.f566a;
        int[] iArr = this.f568c;
        int i3 = this.f569d;
        if (iArr[i3] == 0) {
            int[] iArr2 = new int[1];
            C0113f.m480a(iArr2.length, iArr2, 0, 6408, bitmap.getWidth(), bitmap.getHeight());
            OplusGLSurfaceView_13 = iArr2[0];
            this.f568c[this.f569d] = OplusGLSurfaceView_13;
        } else {
            OplusGLSurfaceView_13 = iArr[i3];
        }
        int[] iArr3 = this.f567b;
        int i4 = this.f569d;
        iArr3[i4] = iHashCode;
        this.f569d = i4 + 1;
        C0113f.m488b(OplusGLSurfaceView_13, bitmap.getWidth(), bitmap.getHeight());
        GLES20.glBindTexture(3553, OplusGLSurfaceView_13);
        GLUtils.texImage2D(3553, 0, 6408, bitmap, 0);
        if (this.f570e) {
            GLES20.glGenerateMipmap(3553);
        }
        GLES20.glBindTexture(3553, 0);
        return OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m599a() {
        for (int OplusGLSurfaceView_13 : this.f568c) {
            if (OplusGLSurfaceView_13 != 0) {
                C0113f.m476a(OplusGLSurfaceView_13);
            }
        }
        int i2 = this.f566a;
        this.f568c = new int[i2];
        this.f567b = new int[i2];
        this.f569d = 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m600a(boolean z) {
        this.f570e = z;
    }
}
