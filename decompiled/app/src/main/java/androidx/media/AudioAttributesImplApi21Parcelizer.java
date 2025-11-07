package androidx.media;

/* loaded from: classes.dex */
public final class AudioAttributesImplApi21Parcelizer {
    public static androidx.media.b_renamed read(androidx.versionedparcelable.a_renamed aVar) {
        androidx.media.b_renamed bVar = new androidx.media.b_renamed();
        bVar.f1271a = (android.media.AudioAttributes) aVar.b_renamed((androidx.versionedparcelable.a_renamed) bVar.f1271a, 1);
        bVar.f1272b = aVar.b_renamed(bVar.f1272b, 2);
        return bVar;
    }

    public static void write(androidx.media.b_renamed bVar, androidx.versionedparcelable.a_renamed aVar) {
        aVar.a_renamed(false, false);
        aVar.a_renamed(bVar.f1271a, 1);
        aVar.a_renamed(bVar.f1272b, 2);
    }
}
