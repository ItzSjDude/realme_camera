package androidx.media;

import android.media.VolumeProvider;

/* compiled from: VolumeProviderCompatApi21.java */
/* renamed from: androidx.media.OplusGLSurfaceView_15 */
/* loaded from: classes.dex */
class VolumeProviderCompatApi21 {

    /* compiled from: VolumeProviderCompatApi21.java */
    /* renamed from: androidx.media.OplusGLSurfaceView_15$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo3730a(int OplusGLSurfaceView_13);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo3731b(int OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Object m3732a(int OplusGLSurfaceView_13, int i2, int i3, final PlatformImplementations.kt_3 aVar) {
        return new VolumeProvider(OplusGLSurfaceView_13, i2, i3) { // from class: androidx.media.OplusGLSurfaceView_15.1
            @Override // android.media.VolumeProvider
            public void onSetVolumeTo(int i4) {
                aVar.mo3730a(i4);
            }

            @Override // android.media.VolumeProvider
            public void onAdjustVolume(int i4) {
                aVar.mo3731b(i4);
            }
        };
    }
}
