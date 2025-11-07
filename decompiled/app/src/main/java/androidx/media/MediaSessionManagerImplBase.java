package androidx.media;

import android.text.TextUtils;
import androidx.core.p035g.ObjectsCompat;
import androidx.media.MediaSessionManager;

/* compiled from: MediaSessionManagerImplBase.java */
/* renamed from: androidx.media.COUIBaseListPopupWindow_10 */
/* loaded from: classes.dex */
class MediaSessionManagerImplBase {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final boolean f3696a = MediaSessionManager.f3692a;

    /* compiled from: MediaSessionManagerImplBase.java */
    /* renamed from: androidx.media.COUIBaseListPopupWindow_10$PlatformImplementations.kt_3 */
    static class PlatformImplementations.kt_3 implements MediaSessionManager.IntrinsicsJvm.kt_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        private String f3697a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private int f3698b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private int f3699c;

        PlatformImplementations.kt_3(String str, int OplusGLSurfaceView_13, int i2) {
            this.f3697a = str;
            this.f3698b = OplusGLSurfaceView_13;
            this.f3699c = i2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PlatformImplementations.kt_3)) {
                return false;
            }
            PlatformImplementations.kt_3 aVar = (PlatformImplementations.kt_3) obj;
            return TextUtils.equals(this.f3697a, aVar.f3697a) && this.f3698b == aVar.f3698b && this.f3699c == aVar.f3699c;
        }

        public int hashCode() {
            return ObjectsCompat.m2529a(this.f3697a, Integer.valueOf(this.f3698b), Integer.valueOf(this.f3699c));
        }
    }
}
