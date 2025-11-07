package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import androidx.versionedparcelable.VersionedParcel;

/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(VersionedParcel abstractC0814a) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f2945a = abstractC0814a.m4931b(iconCompat.f2945a, 1);
        iconCompat.f2947c = abstractC0814a.m4939b(iconCompat.f2947c, 2);
        iconCompat.f2948d = abstractC0814a.m4932b((VersionedParcel) iconCompat.f2948d, 3);
        iconCompat.f2949e = abstractC0814a.m4931b(iconCompat.f2949e, 4);
        iconCompat.f2950f = abstractC0814a.m4931b(iconCompat.f2950f, 5);
        iconCompat.f2951g = (ColorStateList) abstractC0814a.m4932b((VersionedParcel) iconCompat.f2951g, 6);
        iconCompat.f2953j = abstractC0814a.m4935b(iconCompat.f2953j, 7);
        iconCompat.mo2565e();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, VersionedParcel abstractC0814a) {
        abstractC0814a.m4927a(true, true);
        iconCompat.mo2561a(abstractC0814a.m4930a());
        if (-1 != iconCompat.f2945a) {
            abstractC0814a.m4915a(iconCompat.f2945a, 1);
        }
        if (iconCompat.f2947c != null) {
            abstractC0814a.m4929a(iconCompat.f2947c, 2);
        }
        if (iconCompat.f2948d != null) {
            abstractC0814a.m4917a(iconCompat.f2948d, 3);
        }
        if (iconCompat.f2949e != 0) {
            abstractC0814a.m4915a(iconCompat.f2949e, 4);
        }
        if (iconCompat.f2950f != 0) {
            abstractC0814a.m4915a(iconCompat.f2950f, 5);
        }
        if (iconCompat.f2951g != null) {
            abstractC0814a.m4917a(iconCompat.f2951g, 6);
        }
        if (iconCompat.f2953j != null) {
            abstractC0814a.m4924a(iconCompat.f2953j, 7);
        }
    }
}
