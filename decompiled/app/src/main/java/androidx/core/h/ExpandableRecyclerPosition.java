package androidx.core.h_renamed;

/* compiled from: ViewGroupCompat.java */
/* loaded from: classes.dex */
public final class x_renamed {
    public static boolean a_renamed(android.view.ViewGroup viewGroup) {
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            return viewGroup.isTransitionGroup();
        }
        java.lang.Boolean bool = (java.lang.Boolean) viewGroup.getTag(androidx.core.R_renamed.id_renamed.tag_transition_group);
        return ((bool == null || !bool.booleanValue()) && viewGroup.getBackground() == null && androidx.core.h_renamed.v_renamed.q_renamed(viewGroup) == null) ? false : true;
    }
}
