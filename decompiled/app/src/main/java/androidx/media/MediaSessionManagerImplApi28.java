package androidx.media;

import android.media.session.MediaSessionManager;
import androidx.core.p035g.ObjectsCompat;
import androidx.media.MediaSessionManager;

/* compiled from: MediaSessionManagerImplApi28.java */
/* renamed from: androidx.media.COUIBaseListPopupWindow_11 */
/* loaded from: classes.dex */
class MediaSessionManagerImplApi28 extends MediaSessionManagerImplApi21 {

    /* compiled from: MediaSessionManagerImplApi28.java */
    /* renamed from: androidx.media.COUIBaseListPopupWindow_11$PlatformImplementations.kt_3 */
    static final class PlatformImplementations.kt_3 implements MediaSessionManager.IntrinsicsJvm.kt_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        final MediaSessionManager.RemoteUserInfo f3695a;

        PlatformImplementations.kt_3(String str, int OplusGLSurfaceView_13, int i2) {
            this.f3695a = new MediaSessionManager.RemoteUserInfo(str, OplusGLSurfaceView_13, i2);
        }

        PlatformImplementations.kt_3(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.f3695a = remoteUserInfo;
        }

        public int hashCode() {
            return ObjectsCompat.m2529a(this.f3695a);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PlatformImplementations.kt_3) {
                return this.f3695a.equals(((PlatformImplementations.kt_3) obj).f3695a);
            }
            return false;
        }
    }
}
