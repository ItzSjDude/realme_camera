package androidx.media;

/* compiled from: MediaSessionManager.java */
/* loaded from: classes.dex */
public final class e_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    static final boolean f1276a = android.util.Log.isLoggable("MediaSessionManager", 3);

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final java.lang.Object f1277b = new java.lang.Object();

    /* compiled from: MediaSessionManager.java */
    interface b_renamed {
    }

    /* compiled from: MediaSessionManager.java */
    public static final class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        androidx.media.e_renamed.b_renamed f1278a;

        public a_renamed(java.lang.String str, int i_renamed, int i2) {
            if (android.os.Build.VERSION.SDK_INT >= 28) {
                this.f1278a = new androidx.media.g_renamed.a_renamed(str, i_renamed, i2);
            } else {
                this.f1278a = new androidx.media.h_renamed.a_renamed(str, i_renamed, i2);
            }
        }

        public a_renamed(android.media.session.MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.f1278a = new androidx.media.g_renamed.a_renamed(remoteUserInfo);
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof androidx.media.e_renamed.a_renamed) {
                return this.f1278a.equals(((androidx.media.e_renamed.a_renamed) obj).f1278a);
            }
            return false;
        }

        public int hashCode() {
            return this.f1278a.hashCode();
        }
    }
}
