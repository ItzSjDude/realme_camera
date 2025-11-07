package androidx.core.app;

/* compiled from: ComponentActivity.java */
/* loaded from: classes.dex */
public class e_renamed extends android.app.Activity implements androidx.core.h_renamed.d_renamed.a_renamed, androidx.lifecycle.h_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private androidx.collection.SimpleArrayMap<java.lang.Class<? extends androidx.core.app.e_renamed.a_renamed>, androidx.core.app.e_renamed.a_renamed> f827a = new androidx.collection.SimpleArrayMap<>();

    /* renamed from: b_renamed, reason: collision with root package name */
    private androidx.lifecycle.i_renamed f828b = new androidx.lifecycle.i_renamed(this);

    /* compiled from: ComponentActivity.java */
    @java.lang.Deprecated
    public static class a_renamed {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @java.lang.Deprecated
    public void a_renamed(androidx.core.app.e_renamed.a_renamed aVar) {
        this.f827a.put(aVar.getClass(), aVar);
    }

    @Override // android.app.Activity
    @android.annotation.SuppressLint({"RestrictedApi"})
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        androidx.lifecycle.p_renamed.a_renamed(this);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(android.os.Bundle bundle) {
        this.f828b.a_renamed(androidx.lifecycle.e_renamed.b_renamed.CREATED);
        super.onSaveInstanceState(bundle);
    }

    @java.lang.Deprecated
    public <T_renamed extends androidx.core.app.e_renamed.a_renamed> T_renamed a_renamed(java.lang.Class<T_renamed> cls) {
        return (T_renamed) this.f827a.get(cls);
    }

    public androidx.lifecycle.e_renamed getLifecycle() {
        return this.f828b;
    }

    @Override // androidx.core.h_renamed.d_renamed.a_renamed
    public boolean a_renamed(android.view.KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(android.view.KeyEvent keyEvent) {
        android.view.View decorView = getWindow().getDecorView();
        if (decorView == null || !androidx.core.h_renamed.d_renamed.a_renamed(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(android.view.KeyEvent keyEvent) {
        android.view.View decorView = getWindow().getDecorView();
        if (decorView == null || !androidx.core.h_renamed.d_renamed.a_renamed(decorView, keyEvent)) {
            return androidx.core.h_renamed.d_renamed.a_renamed(this, decorView, this, keyEvent);
        }
        return true;
    }
}
