package com.oplus.statistics.p201c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* compiled from: AppLifecycleCallbacks.java */
/* renamed from: com.oplus.statistics.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class AppLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f23829a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f23830b;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    /* compiled from: AppLifecycleCallbacks.java */
    /* renamed from: com.oplus.statistics.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private static final AppLifecycleCallbacks f23831a = new AppLifecycleCallbacks();
    }

    private AppLifecycleCallbacks() {
        this.f23829a = 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static AppLifecycleCallbacks m25324a() {
        return PlatformImplementations.kt_3.f23831a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public synchronized void m25327a(Application application) {
        if (!this.f23830b) {
            application.registerActivityLifecycleCallbacks(this);
            this.f23830b = true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.f23829a++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (m25325b()) {
            StatIdManager.m25343a().m25352c(activity.getApplicationContext());
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        this.f23829a--;
        if (m25326c()) {
            StatIdManager.m25343a().m25351b(activity.getApplicationContext());
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m25325b() {
        return this.f23829a == 1;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean m25326c() {
        return this.f23829a == 0;
    }
}
