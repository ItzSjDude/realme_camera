package com.oplus.epona.internal;

/* loaded from: classes2.dex */
public class ActivityStackManager {
    private final java.util.Stack<java.lang.ref.WeakReference<android.app.Activity>> mActivityStack = new java.util.Stack<>();
    private final android.app.Application.ActivityLifecycleCallbacks mActivityLifecycleCallback = new android.app.Application.ActivityLifecycleCallbacks() { // from class: com.oplus.epona.internal.ActivityStackManager.1
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(android.app.Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(android.app.Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(android.app.Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(android.app.Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
            com.oplus.epona.internal.ActivityStackManager.this.pushTask(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(android.app.Activity activity) {
            com.oplus.epona.internal.ActivityStackManager.this.removeTask(activity);
        }
    };

    public void attach(android.app.Application application) {
        if (application != null) {
            application.registerActivityLifecycleCallbacks(this.mActivityLifecycleCallback);
        }
    }

    public android.app.Activity getCurrentActivity() {
        try {
            if (this.mActivityStack.size() > 0) {
                return this.mActivityStack.get(this.mActivityStack.size() - 1).get();
            }
            return null;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void pushTask(android.app.Activity activity) {
        if (activity == null) {
            return;
        }
        this.mActivityStack.push(new java.lang.ref.WeakReference<>(activity));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void removeTask(android.app.Activity activity) {
        android.app.Activity activity2;
        if (activity == null) {
            return;
        }
        for (int size = this.mActivityStack.size() - 1; size >= 0; size--) {
            try {
                java.lang.ref.WeakReference<android.app.Activity> weakReference = this.mActivityStack.get(size);
                if (weakReference != null && (activity2 = weakReference.get()) != null && activity2.getClass().getSimpleName().equals(activity.getClass().getSimpleName())) {
                    this.mActivityStack.remove(size);
                    break;
                }
            } catch (java.lang.Exception unused) {
            }
        }
    }
}
