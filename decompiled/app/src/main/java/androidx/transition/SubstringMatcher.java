package androidx.transition;

/* compiled from: Scene.java */
/* loaded from: classes.dex */
public class k_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.view.ViewGroup f1727a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.lang.Runnable f1728b;

    public void a_renamed() {
        java.lang.Runnable runnable;
        if (a_renamed(this.f1727a) != this || (runnable = this.f1728b) == null) {
            return;
        }
        runnable.run();
    }

    static void a_renamed(android.view.ViewGroup viewGroup, androidx.transition.k_renamed kVar) {
        viewGroup.setTag(androidx.transition.R_renamed.id_renamed.transition_current_scene, kVar);
    }

    public static androidx.transition.k_renamed a_renamed(android.view.ViewGroup viewGroup) {
        return (androidx.transition.k_renamed) viewGroup.getTag(androidx.transition.R_renamed.id_renamed.transition_current_scene);
    }
}
