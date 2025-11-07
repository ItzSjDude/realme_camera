package androidx.activity;

/* loaded from: classes.dex */
final class ImmLeaksCleaner implements androidx.lifecycle.f_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static int f178a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static java.lang.reflect.Field f179b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private static java.lang.reflect.Field f180c;
    private static java.lang.reflect.Field d_renamed;
    private android.app.Activity e_renamed;

    ImmLeaksCleaner(android.app.Activity activity) {
        this.e_renamed = activity;
    }

    @Override // androidx.lifecycle.f_renamed
    public void a_renamed(androidx.lifecycle.h_renamed hVar, androidx.lifecycle.e_renamed.a_renamed aVar) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        if (aVar != androidx.lifecycle.e_renamed.a_renamed.ON_DESTROY) {
            return;
        }
        if (f178a == 0) {
            a_renamed();
        }
        if (f178a == 1) {
            android.view.inputmethod.InputMethodManager inputMethodManager = (android.view.inputmethod.InputMethodManager) this.e_renamed.getSystemService("input_method");
            try {
                java.lang.Object obj = f179b.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            android.view.View view = (android.view.View) f180c.get(inputMethodManager);
                            if (view == null) {
                                return;
                            }
                            if (view.isAttachedToWindow()) {
                                return;
                            }
                            try {
                                d_renamed.set(inputMethodManager, null);
                                inputMethodManager.isActive();
                            } catch (java.lang.IllegalAccessException unused) {
                            }
                        } catch (java.lang.Throwable th) {
                            throw th;
                        }
                    } catch (java.lang.ClassCastException unused2) {
                    } catch (java.lang.IllegalAccessException unused3) {
                    }
                }
            } catch (java.lang.IllegalAccessException unused4) {
            }
        }
    }

    private static void a_renamed() {
        try {
            f178a = 2;
            f180c = android.view.inputmethod.InputMethodManager.class.getDeclaredField("mServedView");
            f180c.setAccessible(true);
            d_renamed = android.view.inputmethod.InputMethodManager.class.getDeclaredField("mNextServedView");
            d_renamed.setAccessible(true);
            f179b = android.view.inputmethod.InputMethodManager.class.getDeclaredField("mH");
            f179b.setAccessible(true);
            f178a = 1;
        } catch (java.lang.NoSuchFieldException unused) {
        }
    }
}
