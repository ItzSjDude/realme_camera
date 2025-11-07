package androidx.core.p036h;

import android.os.Build;
import android.view.ViewGroup;
import androidx.core.R;

/* compiled from: ViewGroupCompat.java */
/* renamed from: androidx.core.COUIBaseListPopupWindow_10.x */
/* loaded from: classes.dex */
public final class ViewGroupCompat {
    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m2935a(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 21) {
            return viewGroup.isTransitionGroup();
        }
        Boolean bool = (Boolean) viewGroup.getTag(R.id_renamed.tag_transition_group);
        return ((bool == null || !bool.booleanValue()) && viewGroup.getBackground() == null && ViewCompat.m2898q(viewGroup) == null) ? false : true;
    }
}
