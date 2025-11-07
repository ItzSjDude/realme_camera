package androidx.media;

/* compiled from: MediaSessionManagerImplApi28.java */
/* loaded from: classes.dex */
class g_renamed extends androidx.media.f_renamed {

    /* compiled from: MediaSessionManagerImplApi28.java */
    static final class a_renamed implements androidx.media.e_renamed.b_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        final android.media.session.MediaSessionManager.RemoteUserInfo f1279a;

        a_renamed(java.lang.String str, int i_renamed, int i2) {
            this.f1279a = new android.media.session.MediaSessionManager.RemoteUserInfo(str, i_renamed, i2);
        }

        a_renamed(android.media.session.MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.f1279a = remoteUserInfo;
        }

        public int hashCode() {
            return androidx.core.g_renamed.c_renamed.a_renamed(this.f1279a);
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof androidx.media.g_renamed.a_renamed) {
                return this.f1279a.equals(((androidx.media.g_renamed.a_renamed) obj).f1279a);
            }
            return false;
        }
    }
}
