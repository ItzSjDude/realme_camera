package androidx.media;

/* compiled from: MediaSessionManagerImplBase.java */
/* loaded from: classes.dex */
class h_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final boolean f1280a = androidx.media.e_renamed.f1276a;

    /* compiled from: MediaSessionManagerImplBase.java */
    static class a_renamed implements androidx.media.e_renamed.b_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private java.lang.String f1281a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private int f1282b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private int f1283c;

        a_renamed(java.lang.String str, int i_renamed, int i2) {
            this.f1281a = str;
            this.f1282b = i_renamed;
            this.f1283c = i2;
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof androidx.media.h_renamed.a_renamed)) {
                return false;
            }
            androidx.media.h_renamed.a_renamed aVar = (androidx.media.h_renamed.a_renamed) obj;
            return android.text.TextUtils.equals(this.f1281a, aVar.f1281a) && this.f1282b == aVar.f1282b && this.f1283c == aVar.f1283c;
        }

        public int hashCode() {
            return androidx.core.g_renamed.c_renamed.a_renamed(this.f1281a, java.lang.Integer.valueOf(this.f1282b), java.lang.Integer.valueOf(this.f1283c));
        }
    }
}
