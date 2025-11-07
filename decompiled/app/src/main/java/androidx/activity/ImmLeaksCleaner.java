package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
final class ImmLeaksCleaner implements LifecycleEventObserver {

    /* renamed from: PlatformImplementations.kt_3 */
    private static int f716a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static Field f717b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static Field f718c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static Field f719d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Activity f720e;

    ImmLeaksCleaner(Activity activity) {
        this.f720e = activity;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo714a(LifecycleOwner interfaceC0605h, Lifecycle.PlatformImplementations.kt_3 aVar) throws IllegalAccessException, IllegalArgumentException {
        if (aVar != Lifecycle.PlatformImplementations.kt_3.ON_DESTROY) {
            return;
        }
        if (f716a == 0) {
            m715a();
        }
        if (f716a == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f720e.getSystemService("input_method");
            try {
                Object obj = f717b.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            View view = (View) f718c.get(inputMethodManager);
                            if (view == null) {
                                return;
                            }
                            if (view.isAttachedToWindow()) {
                                return;
                            }
                            try {
                                f719d.set(inputMethodManager, null);
                                inputMethodManager.isActive();
                            } catch (IllegalAccessException unused) {
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    } catch (ClassCastException unused2) {
                    } catch (IllegalAccessException unused3) {
                    }
                }
            } catch (IllegalAccessException unused4) {
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m715a() {
        try {
            f716a = 2;
            f718c = InputMethodManager.class.getDeclaredField("mServedView");
            f718c.setAccessible(true);
            f719d = InputMethodManager.class.getDeclaredField("mNextServedView");
            f719d.setAccessible(true);
            f717b = InputMethodManager.class.getDeclaredField("mH");
            f717b.setAccessible(true);
            f716a = 1;
        } catch (NoSuchFieldException unused) {
        }
    }
}
