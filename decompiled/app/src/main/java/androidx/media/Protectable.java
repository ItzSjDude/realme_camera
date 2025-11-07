package androidx.media;

/* compiled from: AudioAttributesImplBase.java */
/* loaded from: classes.dex */
class c_renamed implements androidx.media.a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    int f1273a = 0;

    /* renamed from: b_renamed, reason: collision with root package name */
    int f1274b = 0;

    /* renamed from: c_renamed, reason: collision with root package name */
    int f1275c = 0;
    int d_renamed = -1;

    c_renamed() {
    }

    public int a_renamed() {
        int i_renamed = this.d_renamed;
        return i_renamed != -1 ? i_renamed : androidx.media.AudioAttributesCompat.a_renamed(false, this.f1275c, this.f1273a);
    }

    public int b_renamed() {
        return this.f1274b;
    }

    public int c_renamed() {
        return this.f1273a;
    }

    public int d_renamed() {
        int i_renamed = this.f1275c;
        int iA = a_renamed();
        if (iA == 6) {
            i_renamed |= 4;
        } else if (iA == 7) {
            i_renamed |= 1;
        }
        return i_renamed & 273;
    }

    public int hashCode() {
        return java.util.Arrays.hashCode(new java.lang.Object[]{java.lang.Integer.valueOf(this.f1274b), java.lang.Integer.valueOf(this.f1275c), java.lang.Integer.valueOf(this.f1273a), java.lang.Integer.valueOf(this.d_renamed)});
    }

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof androidx.media.c_renamed)) {
            return false;
        }
        androidx.media.c_renamed cVar = (androidx.media.c_renamed) obj;
        return this.f1274b == cVar.b_renamed() && this.f1275c == cVar.d_renamed() && this.f1273a == cVar.c_renamed() && this.d_renamed == cVar.d_renamed;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("AudioAttributesCompat:");
        if (this.d_renamed != -1) {
            sb.append(" stream=");
            sb.append(this.d_renamed);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(androidx.media.AudioAttributesCompat.a_renamed(this.f1273a));
        sb.append(" content=");
        sb.append(this.f1274b);
        sb.append(" flags=0x");
        sb.append(java.lang.Integer.toHexString(this.f1275c).toUpperCase());
        return sb.toString();
    }
}
