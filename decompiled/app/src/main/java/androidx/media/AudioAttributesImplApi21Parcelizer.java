package androidx.media;

import android.media.AudioAttributes;
import androidx.versionedparcelable.VersionedParcel;

/* loaded from: classes.dex */
public final class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(VersionedParcel abstractC0814a) {
        AudioAttributesImplApi21 c0623b = new AudioAttributesImplApi21();
        c0623b.f3686a = (AudioAttributes) abstractC0814a.m4932b((VersionedParcel) c0623b.f3686a, 1);
        c0623b.f3687b = abstractC0814a.m4931b(c0623b.f3687b, 2);
        return c0623b;
    }

    public static void write(AudioAttributesImplApi21 c0623b, VersionedParcel abstractC0814a) {
        abstractC0814a.m4927a(false, false);
        abstractC0814a.m4917a(c0623b.f3686a, 1);
        abstractC0814a.m4915a(c0623b.f3687b, 2);
    }
}
