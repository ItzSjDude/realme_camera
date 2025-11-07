package com.oplus.statistics.c_renamed;

/* compiled from: AppLifecycleCallbacks.java */
/* loaded from: classes2.dex */
public class a_renamed implements android.app.Application.ActivityLifecycleCallbacks {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f7675a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private boolean f7676b;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(android.app.Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
    }

    /* compiled from: AppLifecycleCallbacks.java */
    /* renamed from: com.oplus.statistics.c_renamed.a_renamed$a_renamed, reason: collision with other inner class name */
    private static class AppLifecycleCallbacks_2 {

        /* renamed from: a_renamed, reason: collision with root package name */
        private static final com.oplus.statistics.c_renamed.a_renamed f7677a = new com.oplus.statistics.c_renamed.a_renamed();
    }

    private a_renamed() {
        this.f7675a = 0;
    }

    public static com.oplus.statistics.c_renamed.a_renamed a_renamed() {
        return com.oplus.statistics.c_renamed.a_renamed.AppLifecycleCallbacks_2.f7677a;
    }

    public synchronized void a_renamed(android.app.Application application) {
        if (!this.f7676b) {
            application.registerActivityLifecycleCallbacks(this);
            this.f7676b = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(android.app.Activity activity) {
        this.f7675a++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(android.app.Activity activity) {
        if (b_renamed()) {
            com.oplus.statistics.c_renamed.f_renamed.a_renamed().c_renamed(activity.getApplicationContext());
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(android.app.Activity activity) {
        this.f7675a--;
        if (c_renamed()) {
            com.oplus.statistics.c_renamed.f_renamed.a_renamed().b_renamed(activity.getApplicationContext());
        }
    }

    private boolean b_renamed() {
        return this.f7675a == 1;
    }

    private boolean c_renamed() {
        return this.f7675a == 0;
    }
}
