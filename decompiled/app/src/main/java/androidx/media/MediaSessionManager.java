package androidx.media;

import android.media.session.MediaSessionManager;
import android.os.Build;
import android.util.Log;
import androidx.media.MediaSessionManagerImplApi28;
import androidx.media.MediaSessionManagerImplBase;

/* compiled from: MediaSessionManager.java */
/* renamed from: androidx.media.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
public final class MediaSessionManager {

    /* renamed from: PlatformImplementations.kt_3 */
    static final boolean f3692a = Log.isLoggable("MediaSessionManager", 3);

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final Object f3693b = new Object();

    /* compiled from: MediaSessionManager.java */
    /* renamed from: androidx.media.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_4 */
    interface IntrinsicsJvm.kt_4 {
    }

    /* compiled from: MediaSessionManager.java */
    /* renamed from: androidx.media.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 */
    public static final class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        IntrinsicsJvm.kt_4 f3694a;

        public PlatformImplementations.kt_3(String str, int OplusGLSurfaceView_13, int i2) {
            if (Build.VERSION.SDK_INT >= 28) {
                this.f3694a = new MediaSessionManagerImplApi28.PlatformImplementations.kt_3(str, OplusGLSurfaceView_13, i2);
            } else {
                this.f3694a = new MediaSessionManagerImplBase.PlatformImplementations.kt_3(str, OplusGLSurfaceView_13, i2);
            }
        }

        public PlatformImplementations.kt_3(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.f3694a = new MediaSessionManagerImplApi28.PlatformImplementations.kt_3(remoteUserInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PlatformImplementations.kt_3) {
                return this.f3694a.equals(((PlatformImplementations.kt_3) obj).f3694a);
            }
            return false;
        }

        public int hashCode() {
            return this.f3694a.hashCode();
        }
    }
}
