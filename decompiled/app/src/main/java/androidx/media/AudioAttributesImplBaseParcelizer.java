package androidx.media;

import androidx.versionedparcelable.VersionedParcel;

/* loaded from: classes.dex */
public final class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(VersionedParcel abstractC0814a) {
        AudioAttributesImplBase c0624c = new AudioAttributesImplBase();
        c0624c.f3688a = abstractC0814a.m4931b(c0624c.f3688a, 1);
        c0624c.f3689b = abstractC0814a.m4931b(c0624c.f3689b, 2);
        c0624c.f3690c = abstractC0814a.m4931b(c0624c.f3690c, 3);
        c0624c.f3691d = abstractC0814a.m4931b(c0624c.f3691d, 4);
        return c0624c;
    }

    public static void write(AudioAttributesImplBase c0624c, VersionedParcel abstractC0814a) {
        abstractC0814a.m4927a(false, false);
        abstractC0814a.m4915a(c0624c.f3688a, 1);
        abstractC0814a.m4915a(c0624c.f3689b, 2);
        abstractC0814a.m4915a(c0624c.f3690c, 3);
        abstractC0814a.m4915a(c0624c.f3691d, 4);
    }
}
