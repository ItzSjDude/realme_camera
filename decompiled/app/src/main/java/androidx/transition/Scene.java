package androidx.transition;

import android.view.ViewGroup;

/* compiled from: Scene.java */
/* renamed from: androidx.transition.OplusGLSurfaceView_5 */
/* loaded from: classes.dex */
public class Scene {

    /* renamed from: PlatformImplementations.kt_3 */
    private ViewGroup f4624a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Runnable f4625b;

    /* renamed from: PlatformImplementations.kt_3 */
    public void m4794a() {
        Runnable runnable;
        if (m4792a(this.f4624a) != this || (runnable = this.f4625b) == null) {
            return;
        }
        runnable.run();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static void m4793a(ViewGroup viewGroup, Scene c0789k) {
        viewGroup.setTag(R.id_renamed.transition_current_scene, c0789k);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Scene m4792a(ViewGroup viewGroup) {
        return (Scene) viewGroup.getTag(R.id_renamed.transition_current_scene);
    }
}
