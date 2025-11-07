package androidx.activity;

/* compiled from: ComponentActivity.java */
/* loaded from: classes.dex */
public class b_renamed extends androidx.core.app.e_renamed implements androidx.activity.d_renamed, androidx.lifecycle.h_renamed, androidx.lifecycle.t_renamed, androidx.savedstate.c_renamed {

    /* renamed from: c_renamed, reason: collision with root package name */
    private androidx.lifecycle.s_renamed f190c;
    private int e_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private final androidx.lifecycle.i_renamed f188a = new androidx.lifecycle.i_renamed(this);

    /* renamed from: b_renamed, reason: collision with root package name */
    private final androidx.savedstate.b_renamed f189b = androidx.savedstate.b_renamed.a_renamed(this);
    private final androidx.activity.OnBackPressedDispatcher d_renamed = new androidx.activity.OnBackPressedDispatcher(new java.lang.Runnable() { // from class: androidx.activity.b_renamed.1
        @Override // java.lang.Runnable
        public void run() {
            androidx.activity.b_renamed.super.onBackPressed();
        }
    });

    @java.lang.Deprecated
    public java.lang.Object j__renamed() {
        return null;
    }

    /* compiled from: ComponentActivity.java */
    static final class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        java.lang.Object f192a;

        /* renamed from: b_renamed, reason: collision with root package name */
        androidx.lifecycle.s_renamed f193b;

        a_renamed() {
        }
    }

    public b_renamed() {
        if (getLifecycle() == null) {
            throw new java.lang.IllegalStateException("getLifecycle() returned null in_renamed ComponentActivity's_renamed constructor. Please make sure you are lazily constructing your Lifecycle in_renamed the first call to getLifecycle() rather than relying on_renamed field initialization.");
        }
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            getLifecycle().a_renamed(new androidx.lifecycle.f_renamed() { // from class: androidx.activity.ComponentActivity$2
                @Override // androidx.lifecycle.f_renamed
                public void a_renamed(androidx.lifecycle.h_renamed hVar, androidx.lifecycle.e_renamed.a_renamed aVar) {
                    if (aVar == androidx.lifecycle.e_renamed.a_renamed.ON_STOP) {
                        android.view.Window window = this.f176a.getWindow();
                        android.view.View viewPeekDecorView = window != null ? window.peekDecorView() : null;
                        if (viewPeekDecorView != null) {
                            viewPeekDecorView.cancelPendingInputEvents();
                        }
                    }
                }
            });
        }
        getLifecycle().a_renamed(new androidx.lifecycle.f_renamed() { // from class: androidx.activity.ComponentActivity$3
            @Override // androidx.lifecycle.f_renamed
            public void a_renamed(androidx.lifecycle.h_renamed hVar, androidx.lifecycle.e_renamed.a_renamed aVar) {
                if (aVar != androidx.lifecycle.e_renamed.a_renamed.ON_DESTROY || this.f177a.isChangingConfigurations()) {
                    return;
                }
                this.f177a.getViewModelStore().a_renamed();
            }
        });
        if (19 > android.os.Build.VERSION.SDK_INT || android.os.Build.VERSION.SDK_INT > 23) {
            return;
        }
        getLifecycle().a_renamed(new androidx.activity.ImmLeaksCleaner(this));
    }

    @Override // androidx.core.app.e_renamed, android.app.Activity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        this.f189b.a_renamed(bundle);
        androidx.lifecycle.p_renamed.a_renamed(this);
        int i_renamed = this.e_renamed;
        if (i_renamed != 0) {
            setContentView(i_renamed);
        }
    }

    @Override // androidx.core.app.e_renamed, android.app.Activity
    protected void onSaveInstanceState(android.os.Bundle bundle) {
        androidx.lifecycle.e_renamed lifecycle = getLifecycle();
        if (lifecycle instanceof androidx.lifecycle.i_renamed) {
            ((androidx.lifecycle.i_renamed) lifecycle).b_renamed(androidx.lifecycle.e_renamed.b_renamed.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.f189b.b_renamed(bundle);
    }

    @Override // android.app.Activity
    public final java.lang.Object onRetainNonConfigurationInstance() {
        androidx.activity.b_renamed.a_renamed aVar;
        java.lang.Object objJ_ = j__renamed();
        androidx.lifecycle.s_renamed sVar = this.f190c;
        if (sVar == null && (aVar = (androidx.activity.b_renamed.a_renamed) getLastNonConfigurationInstance()) != null) {
            sVar = aVar.f193b;
        }
        if (sVar == null && objJ_ == null) {
            return null;
        }
        androidx.activity.b_renamed.a_renamed aVar2 = new androidx.activity.b_renamed.a_renamed();
        aVar2.f192a = objJ_;
        aVar2.f193b = sVar;
        return aVar2;
    }

    @Override // androidx.core.app.e_renamed, androidx.lifecycle.h_renamed
    public androidx.lifecycle.e_renamed getLifecycle() {
        return this.f188a;
    }

    @Override // androidx.lifecycle.t_renamed
    public androidx.lifecycle.s_renamed getViewModelStore() {
        if (getApplication() == null) {
            throw new java.lang.IllegalStateException("Your activity is_renamed not yet attached to the Application instance. You can't_renamed request ViewModel before onCreate call.");
        }
        if (this.f190c == null) {
            androidx.activity.b_renamed.a_renamed aVar = (androidx.activity.b_renamed.a_renamed) getLastNonConfigurationInstance();
            if (aVar != null) {
                this.f190c = aVar.f193b;
            }
            if (this.f190c == null) {
                this.f190c = new androidx.lifecycle.s_renamed();
            }
        }
        return this.f190c;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.d_renamed.a_renamed();
    }

    @Override // androidx.activity.d_renamed
    public final androidx.activity.OnBackPressedDispatcher b_renamed() {
        return this.d_renamed;
    }

    @Override // androidx.savedstate.c_renamed
    public final androidx.savedstate.a_renamed getSavedStateRegistry() {
        return this.f189b.a_renamed();
    }
}
