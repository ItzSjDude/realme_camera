package androidx.media;

/* compiled from: AudioAttributesImplApi21.java */
@android.annotation.TargetApi(21)
/* loaded from: classes.dex */
class b_renamed implements androidx.media.a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    android.media.AudioAttributes f1271a;

    /* renamed from: b_renamed, reason: collision with root package name */
    int f1272b = -1;

    b_renamed() {
    }

    public int hashCode() {
        return this.f1271a.hashCode();
    }

    public boolean equals(java.lang.Object obj) {
        if (obj instanceof androidx.media.b_renamed) {
            return this.f1271a.equals(((androidx.media.b_renamed) obj).f1271a);
        }
        return false;
    }

    public java.lang.String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f1271a;
    }
}
