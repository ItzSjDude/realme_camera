package androidx.core.graphics;

/* compiled from: BlendModeColorFilterCompat.java */
/* loaded from: classes.dex */
public class a_renamed {
    public static android.graphics.ColorFilter a_renamed(int i_renamed, androidx.core.graphics.b_renamed bVar) {
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            android.graphics.BlendMode blendModeA = androidx.core.graphics.c_renamed.a_renamed(bVar);
            if (blendModeA != null) {
                return new android.graphics.BlendModeColorFilter(i_renamed, blendModeA);
            }
            return null;
        }
        android.graphics.PorterDuff.Mode modeB = androidx.core.graphics.c_renamed.b_renamed(bVar);
        if (modeB != null) {
            return new android.graphics.PorterDuffColorFilter(i_renamed, modeB);
        }
        return null;
    }
}
