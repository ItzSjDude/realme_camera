package androidx.core.graphics.drawable;

/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static androidx.core.graphics.drawable.IconCompat read(androidx.versionedparcelable.a_renamed aVar) {
        androidx.core.graphics.drawable.IconCompat iconCompat = new androidx.core.graphics.drawable.IconCompat();
        iconCompat.f925a = aVar.b_renamed(iconCompat.f925a, 1);
        iconCompat.f927c = aVar.b_renamed(iconCompat.f927c, 2);
        iconCompat.d_renamed = aVar.b_renamed((androidx.versionedparcelable.a_renamed) iconCompat.d_renamed, 3);
        iconCompat.e_renamed = aVar.b_renamed(iconCompat.e_renamed, 4);
        iconCompat.f_renamed = aVar.b_renamed(iconCompat.f_renamed, 5);
        iconCompat.g_renamed = (android.content.res.ColorStateList) aVar.b_renamed((androidx.versionedparcelable.a_renamed) iconCompat.g_renamed, 6);
        iconCompat.j_renamed = aVar.b_renamed(iconCompat.j_renamed, 7);
        iconCompat.e_renamed();
        return iconCompat;
    }

    public static void write(androidx.core.graphics.drawable.IconCompat iconCompat, androidx.versionedparcelable.a_renamed aVar) {
        aVar.a_renamed(true, true);
        iconCompat.a_renamed(aVar.a_renamed());
        if (-1 != iconCompat.f925a) {
            aVar.a_renamed(iconCompat.f925a, 1);
        }
        if (iconCompat.f927c != null) {
            aVar.a_renamed(iconCompat.f927c, 2);
        }
        if (iconCompat.d_renamed != null) {
            aVar.a_renamed(iconCompat.d_renamed, 3);
        }
        if (iconCompat.e_renamed != 0) {
            aVar.a_renamed(iconCompat.e_renamed, 4);
        }
        if (iconCompat.f_renamed != 0) {
            aVar.a_renamed(iconCompat.f_renamed, 5);
        }
        if (iconCompat.g_renamed != null) {
            aVar.a_renamed(iconCompat.g_renamed, 6);
        }
        if (iconCompat.j_renamed != null) {
            aVar.a_renamed(iconCompat.j_renamed, 7);
        }
    }
}
