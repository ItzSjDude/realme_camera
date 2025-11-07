package androidx.core.h_renamed;

/* compiled from: ActionProvider.java */
/* loaded from: classes.dex */
public abstract class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.content.Context f973a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private androidx.core.h_renamed.b_renamed.a_renamed f974b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private androidx.core.h_renamed.b_renamed.ActionProvider_3 f975c;

    /* compiled from: ActionProvider.java */
    public interface a_renamed {
        void c_renamed(boolean z_renamed);
    }

    /* compiled from: ActionProvider.java */
    /* renamed from: androidx.core.h_renamed.b_renamed$b_renamed, reason: collision with other inner class name */
    public interface ActionProvider_3 {
        void a_renamed(boolean z_renamed);
    }

    public abstract android.view.View a_renamed();

    public void a_renamed(android.view.SubMenu subMenu) {
    }

    public boolean b_renamed() {
        return false;
    }

    public boolean c_renamed() {
        return false;
    }

    public boolean d_renamed() {
        return false;
    }

    public boolean e_renamed() {
        return true;
    }

    public b_renamed(android.content.Context context) {
        this.f973a = context;
    }

    public android.view.View a_renamed(android.view.MenuItem menuItem) {
        return a_renamed();
    }

    public void a_renamed(boolean z_renamed) {
        androidx.core.h_renamed.b_renamed.a_renamed aVar = this.f974b;
        if (aVar != null) {
            aVar.c_renamed(z_renamed);
        }
    }

    public void a_renamed(androidx.core.h_renamed.b_renamed.a_renamed aVar) {
        this.f974b = aVar;
    }

    public void a_renamed(androidx.core.h_renamed.b_renamed.ActionProvider_3 interfaceC0023b) {
        if (this.f975c != null && interfaceC0023b != null) {
            android.util.Log.w_renamed("ActionProvider(support)", "setVisibilityListener: Setting a_renamed new ActionProvider.VisibilityListener when one is_renamed already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is_renamed still in_renamed use somewhere else?");
        }
        this.f975c = interfaceC0023b;
    }

    public void f_renamed() {
        this.f975c = null;
        this.f974b = null;
    }
}
