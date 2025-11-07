package androidx.media;

import androidx.versionedparcelable.VersionedParcel;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public final class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(VersionedParcel abstractC0814a) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.f3680a = (AudioAttributesImpl) abstractC0814a.m4933b((VersionedParcel) audioAttributesCompat.f3680a, 1);
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, VersionedParcel abstractC0814a) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        abstractC0814a.m4927a(false, false);
        abstractC0814a.m4919a(audioAttributesCompat.f3680a, 1);
    }
}
