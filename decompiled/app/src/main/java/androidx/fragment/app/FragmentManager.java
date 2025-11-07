package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

/* compiled from: FragmentManager.java */
/* renamed from: androidx.fragment.app.COUIBaseListPopupWindow_10 */
/* loaded from: classes.dex */
public abstract class FragmentManager {

    /* renamed from: PlatformImplementations.kt_3 */
    static final FragmentFactory f3434a = new FragmentFactory();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private FragmentFactory f3435b = null;

    /* compiled from: FragmentManager.java */
    /* renamed from: androidx.fragment.app.COUIBaseListPopupWindow_10$PlatformImplementations.kt_3 */
    public static abstract class PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        public void m3401a(FragmentManager abstractC0586h, Fragment fragment) {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m3402a(FragmentManager abstractC0586h, Fragment fragment, Context context) {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m3403a(FragmentManager abstractC0586h, Fragment fragment, Bundle bundle) {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void mo3404a(FragmentManager abstractC0586h, Fragment fragment, View view, Bundle bundle) {
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m3405b(FragmentManager abstractC0586h, Fragment fragment) {
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m3406b(FragmentManager abstractC0586h, Fragment fragment, Context context) {
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m3407b(FragmentManager abstractC0586h, Fragment fragment, Bundle bundle) {
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public void m3408c(FragmentManager abstractC0586h, Fragment fragment) {
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public void m3409c(FragmentManager abstractC0586h, Fragment fragment, Bundle bundle) {
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public void m3410d(FragmentManager abstractC0586h, Fragment fragment) {
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public void m3411d(FragmentManager abstractC0586h, Fragment fragment, Bundle bundle) {
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        public void m3412e(FragmentManager abstractC0586h, Fragment fragment) {
        }

        /* renamed from: COUIBaseListPopupWindow_12 */
        public void m3413f(FragmentManager abstractC0586h, Fragment fragment) {
        }

        /* renamed from: COUIBaseListPopupWindow_11 */
        public void m3414g(FragmentManager abstractC0586h, Fragment fragment) {
        }
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: androidx.fragment.app.COUIBaseListPopupWindow_10$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        void m3415a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract Fragment mo3388a(String str);

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract FragmentTransaction mo3389a();

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void mo3390a(int OplusGLSurfaceView_13, int i2);

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void mo3392a(PlatformImplementations.kt_3 aVar);

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void mo3393a(PlatformImplementations.kt_3 aVar, boolean z);

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract void mo3394a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    /* renamed from: IntrinsicsJvm.kt_4 */
    public abstract boolean mo3395b();

    /* renamed from: IntrinsicsJvm.kt_3 */
    public abstract boolean mo3396c();

    /* renamed from: IntrinsicsJvm.kt_5 */
    public abstract List<Fragment> mo3397d();

    /* renamed from: COUIBaseListPopupWindow_8 */
    public abstract boolean mo3398e();

    /* renamed from: COUIBaseListPopupWindow_11 */
    public abstract boolean mo3400g();

    /* renamed from: PlatformImplementations.kt_3 */
    public void m3391a(FragmentFactory c0584f) {
        this.f3435b = c0584f;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public FragmentFactory mo3399f() {
        if (this.f3435b == null) {
            this.f3435b = f3434a;
        }
        return this.f3435b;
    }
}
