package androidx.media;

/* loaded from: classes.dex */
public final class AudioAttributesCompatParcelizer {
    public static androidx.media.AudioAttributesCompat read(androidx.versionedparcelable.a_renamed aVar) {
        androidx.media.AudioAttributesCompat audioAttributesCompat = new androidx.media.AudioAttributesCompat();
        audioAttributesCompat.f1267a = (androidx.media.a_renamed) aVar.b_renamed((androidx.versionedparcelable.a_renamed) audioAttributesCompat.f1267a, 1);
        return audioAttributesCompat;
    }

    public static void write(androidx.media.AudioAttributesCompat audioAttributesCompat, androidx.versionedparcelable.a_renamed aVar) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        aVar.a_renamed(false, false);
        aVar.a_renamed(audioAttributesCompat.f1267a, 1);
    }
}
