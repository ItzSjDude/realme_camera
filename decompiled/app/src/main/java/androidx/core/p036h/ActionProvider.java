package androidx.core.p036h;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: ActionProvider.java */
/* renamed from: androidx.core.COUIBaseListPopupWindow_10.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public abstract class ActionProvider {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Context f3052a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private PlatformImplementations.kt_3 f3053b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private IntrinsicsJvm.kt_4 f3054c;

    /* compiled from: ActionProvider.java */
    /* renamed from: androidx.core.COUIBaseListPopupWindow_10.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: IntrinsicsJvm.kt_3 */
        void mo1259c(boolean z);
    }

    /* compiled from: ActionProvider.java */
    /* renamed from: androidx.core.COUIBaseListPopupWindow_10.IntrinsicsJvm.kt_4$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo1184a(boolean z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract View mo1186a();

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo1187a(SubMenu subMenu) {
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean mo1188b() {
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean mo1189c() {
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean mo1192d() {
        return false;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean mo1193e() {
        return true;
    }

    public ActionProvider(Context context) {
        this.f3052a = context;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public View mo1190a(MenuItem menuItem) {
        return mo1186a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2769a(boolean z) {
        PlatformImplementations.kt_3 aVar = this.f3053b;
        if (aVar != null) {
            aVar.mo1259c(z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2768a(PlatformImplementations.kt_3 aVar) {
        this.f3053b = aVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo1191a(IntrinsicsJvm.kt_4 bVar) {
        if (this.f3054c != null && bVar != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting PlatformImplementations.kt_3 new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f3054c = bVar;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m2770f() {
        this.f3054c = null;
        this.f3053b = null;
    }
}
