package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.collection.SimpleArrayMap;
import androidx.core.p036h.KeyEventDispatcher;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.LifecycleOwner;

/* compiled from: ComponentActivity.java */
/* renamed from: androidx.core.app.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
public class ComponentActivity extends Activity implements KeyEventDispatcher.PlatformImplementations.kt_3, LifecycleOwner {

    /* renamed from: PlatformImplementations.kt_3 */
    private SimpleArrayMap<Class<? extends PlatformImplementations.kt_3>, PlatformImplementations.kt_3> f2747a = new SimpleArrayMap<>();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private LifecycleRegistry f2748b = new LifecycleRegistry(this);

    /* compiled from: ComponentActivity.java */
    @Deprecated
    /* renamed from: androidx.core.app.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 */
    public static class PlatformImplementations.kt_3 {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    /* renamed from: PlatformImplementations.kt_3 */
    public void m2369a(PlatformImplementations.kt_3 aVar) {
        this.f2747a.put(aVar.getClass(), aVar);
    }

    @Override // android.app.Activity
    @SuppressLint({"RestrictedApi"})
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ReportFragment.m3667a(this);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        this.f2748b.m3654a(Lifecycle.IntrinsicsJvm.kt_4.CREATED);
        super.onSaveInstanceState(bundle);
    }

    @Deprecated
    /* renamed from: PlatformImplementations.kt_3 */
    public <T extends PlatformImplementations.kt_3> T m2368a(Class<T> cls) {
        return (T) this.f2747a.get(cls);
    }

    public Lifecycle getLifecycle() {
        return this.f2748b;
    }

    @Override // androidx.core.p036h.KeyEventDispatcher.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo925a(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !KeyEventDispatcher.m2779a(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !KeyEventDispatcher.m2779a(decorView, keyEvent)) {
            return KeyEventDispatcher.m2780a(this, decorView, this, keyEvent);
        }
        return true;
    }
}
