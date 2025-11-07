package androidx.activity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.core.app.ComponentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;

/* compiled from: ComponentActivity.java */
/* renamed from: androidx.activity.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public class ComponentActivity_3 extends ComponentActivity implements OnBackPressedDispatcherOwner, LifecycleOwner, ViewModelStoreOwner, SavedStateRegistryOwner {

    /* renamed from: IntrinsicsJvm.kt_3 */
    private ViewModelStore f731c;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f733e;

    /* renamed from: PlatformImplementations.kt_3 */
    private final LifecycleRegistry f729a = new LifecycleRegistry(this);

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final SavedStateRegistryController f730b = SavedStateRegistryController.m4691a(this);

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final OnBackPressedDispatcher f732d = new OnBackPressedDispatcher(new Runnable() { // from class: androidx.activity.IntrinsicsJvm.kt_4.1
        @Override // java.lang.Runnable
        public void run() {
            ComponentActivity_3.super.onBackPressed();
        }
    });

    @Deprecated
    /* renamed from: j_ */
    public Object m722j_() {
        return null;
    }

    /* compiled from: ComponentActivity.java */
    /* renamed from: androidx.activity.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    static final class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        Object f735a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        ViewModelStore f736b;

        PlatformImplementations.kt_3() {
        }
    }

    public ComponentActivity_3() {
        if (getLifecycle() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        if (Build.VERSION.SDK_INT >= 19) {
            getLifecycle().mo3639a(new LifecycleEventObserver() { // from class: androidx.activity.ComponentActivity$2
                @Override // androidx.lifecycle.LifecycleEventObserver
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo714a(LifecycleOwner interfaceC0605h, Lifecycle.PlatformImplementations.kt_3 aVar) {
                    if (aVar == Lifecycle.PlatformImplementations.kt_3.ON_STOP) {
                        Window window = this.f714a.getWindow();
                        View viewPeekDecorView = window != null ? window.peekDecorView() : null;
                        if (viewPeekDecorView != null) {
                            viewPeekDecorView.cancelPendingInputEvents();
                        }
                    }
                }
            });
        }
        getLifecycle().mo3639a(new LifecycleEventObserver() { // from class: androidx.activity.ComponentActivity$3
            @Override // androidx.lifecycle.LifecycleEventObserver
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo714a(LifecycleOwner interfaceC0605h, Lifecycle.PlatformImplementations.kt_3 aVar) {
                if (aVar != Lifecycle.PlatformImplementations.kt_3.ON_DESTROY || this.f715a.isChangingConfigurations()) {
                    return;
                }
                this.f715a.getViewModelStore().m3681a();
            }
        });
        if (19 > Build.VERSION.SDK_INT || Build.VERSION.SDK_INT > 23) {
            return;
        }
        getLifecycle().mo3639a(new ImmLeaksCleaner(this));
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f730b.m4693a(bundle);
        ReportFragment.m3667a(this);
        int OplusGLSurfaceView_13 = this.f733e;
        if (OplusGLSurfaceView_13 != 0) {
            setContentView(OplusGLSurfaceView_13);
        }
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        Lifecycle lifecycle = getLifecycle();
        if (lifecycle instanceof LifecycleRegistry) {
            ((LifecycleRegistry) lifecycle).m3655b(Lifecycle.IntrinsicsJvm.kt_4.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.f730b.m4694b(bundle);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        PlatformImplementations.kt_3 aVar;
        Object objM722j_ = m722j_();
        ViewModelStore c0616s = this.f731c;
        if (c0616s == null && (aVar = (PlatformImplementations.kt_3) getLastNonConfigurationInstance()) != null) {
            c0616s = aVar.f736b;
        }
        if (c0616s == null && objM722j_ == null) {
            return null;
        }
        PlatformImplementations.kt_3 aVar2 = new PlatformImplementations.kt_3();
        aVar2.f735a = objM722j_;
        aVar2.f736b = c0616s;
        return aVar2;
    }

    @Override // androidx.core.app.ComponentActivity, androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.f729a;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        if (this.f731c == null) {
            PlatformImplementations.kt_3 aVar = (PlatformImplementations.kt_3) getLastNonConfigurationInstance();
            if (aVar != null) {
                this.f731c = aVar.f736b;
            }
            if (this.f731c == null) {
                this.f731c = new ViewModelStore();
            }
        }
        return this.f731c;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.f732d.m717a();
    }

    @Override // androidx.activity.OnBackPressedDispatcherOwner
    /* renamed from: IntrinsicsJvm.kt_4 */
    public final OnBackPressedDispatcher mo721b() {
        return this.f732d;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.f730b.m4692a();
    }
}
