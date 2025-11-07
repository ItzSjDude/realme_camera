package androidx.media;

import android.os.Build;
import androidx.media.VolumeProviderCompatApi21;

/* compiled from: VolumeProviderCompat.java */
/* renamed from: androidx.media.OplusGLSurfaceView_13 */
/* loaded from: classes.dex */
public abstract class VolumeProviderCompat {

    /* renamed from: PlatformImplementations.kt_3 */
    private final int f3700a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final int f3701b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f3702c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private PlatformImplementations.kt_3 f3703d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Object f3704e;

    /* compiled from: VolumeProviderCompat.java */
    /* renamed from: androidx.media.OplusGLSurfaceView_13$PlatformImplementations.kt_3 */
    public static abstract class PlatformImplementations.kt_3 {
        public abstract void onVolumeChanged(VolumeProviderCompat abstractC0630i);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3724a(int OplusGLSurfaceView_13) {
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m3727b(int OplusGLSurfaceView_13) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final int m3723a() {
        return this.f3702c;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final int m3726b() {
        return this.f3700a;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public final int m3728c() {
        return this.f3701b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3725a(PlatformImplementations.kt_3 aVar) {
        this.f3703d = aVar;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public Object m3729d() {
        if (this.f3704e == null && Build.VERSION.SDK_INT >= 21) {
            this.f3704e = VolumeProviderCompatApi21.m3732a(this.f3700a, this.f3701b, this.f3702c, new VolumeProviderCompatApi21.PlatformImplementations.kt_3() { // from class: androidx.media.OplusGLSurfaceView_13.1
                @Override // androidx.media.VolumeProviderCompatApi21.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo3730a(int OplusGLSurfaceView_13) {
                    VolumeProviderCompat.this.m3724a(OplusGLSurfaceView_13);
                }

                @Override // androidx.media.VolumeProviderCompatApi21.PlatformImplementations.kt_3
                /* renamed from: IntrinsicsJvm.kt_4 */
                public void mo3731b(int OplusGLSurfaceView_13) {
                    VolumeProviderCompat.this.m3727b(OplusGLSurfaceView_13);
                }
            });
        }
        return this.f3704e;
    }
}
