package androidx.fragment.app;

import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* compiled from: FragmentTransaction.java */
/* renamed from: androidx.fragment.app.OplusGLSurfaceView_5 */
/* loaded from: classes.dex */
public abstract class FragmentTransaction {

    /* renamed from: COUIBaseListPopupWindow_8 */
    int f3510e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    int f3511f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    int f3512g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    int f3513h;

    /* renamed from: OplusGLSurfaceView_13 */
    int f3514i;

    /* renamed from: OplusGLSurfaceView_15 */
    int f3515j;

    /* renamed from: OplusGLSurfaceView_5 */
    boolean f3516k;

    /* renamed from: OplusGLSurfaceView_6 */
    String f3518m;

    /* renamed from: OplusGLSurfaceView_11 */
    int f3519n;

    /* renamed from: o */
    CharSequence f3520o;

    /* renamed from: p */
    int f3521p;

    /* renamed from: q */
    CharSequence f3522q;

    /* renamed from: r */
    ArrayList<String> f3523r;

    /* renamed from: s */
    ArrayList<String> f3524s;

    /* renamed from: u */
    ArrayList<Runnable> f3526u;

    /* renamed from: IntrinsicsJvm.kt_5 */
    ArrayList<PlatformImplementations.kt_3> f3509d = new ArrayList<>();

    /* renamed from: OplusGLSurfaceView_14 */
    boolean f3517l = true;

    /* renamed from: t */
    boolean f3525t = false;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public abstract int mo3319b();

    /* renamed from: IntrinsicsJvm.kt_3 */
    public abstract int mo3324c();

    /* renamed from: IntrinsicsJvm.kt_5 */
    public abstract void mo3325d();

    /* compiled from: FragmentTransaction.java */
    /* renamed from: androidx.fragment.app.OplusGLSurfaceView_5$PlatformImplementations.kt_3 */
    static final class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        int f3527a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        Fragment f3528b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        int f3529c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        int f3530d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        int f3531e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        int f3532f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        Lifecycle.IntrinsicsJvm.kt_4 f3533g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        Lifecycle.IntrinsicsJvm.kt_4 f3534h;

        PlatformImplementations.kt_3() {
        }

        PlatformImplementations.kt_3(int OplusGLSurfaceView_13, Fragment fragment) {
            this.f3527a = OplusGLSurfaceView_13;
            this.f3528b = fragment;
            this.f3533g = Lifecycle.IntrinsicsJvm.kt_4.RESUMED;
            this.f3534h = Lifecycle.IntrinsicsJvm.kt_4.RESUMED;
        }

        PlatformImplementations.kt_3(int OplusGLSurfaceView_13, Fragment fragment, Lifecycle.IntrinsicsJvm.kt_4 bVar) {
            this.f3527a = OplusGLSurfaceView_13;
            this.f3528b = fragment;
            this.f3533g = fragment.mMaxState;
            this.f3534h = bVar;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m3544a(PlatformImplementations.kt_3 aVar) {
        this.f3509d.add(aVar);
        aVar.f3529c = this.f3510e;
        aVar.f3530d = this.f3511f;
        aVar.f3531e = this.f3512g;
        aVar.f3532f = this.f3513h;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public FragmentTransaction m3542a(Fragment fragment, String str) {
        mo3313a(0, fragment, str, 1);
        return this;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public FragmentTransaction m3541a(int OplusGLSurfaceView_13, Fragment fragment, String str) {
        mo3313a(OplusGLSurfaceView_13, fragment, str, 1);
        return this;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void mo3313a(int OplusGLSurfaceView_13, Fragment fragment, String str, int i2) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be PlatformImplementations.kt_3 public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            if (fragment.mTag != null && !str.equals(fragment.mTag)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
            fragment.mTag = str;
        }
        if (OplusGLSurfaceView_13 != 0) {
            if (OplusGLSurfaceView_13 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id_renamed");
            }
            if (fragment.mFragmentId != 0 && fragment.mFragmentId != OplusGLSurfaceView_13) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + OplusGLSurfaceView_13);
            }
            fragment.mFragmentId = OplusGLSurfaceView_13;
            fragment.mContainerId = OplusGLSurfaceView_13;
        }
        m3544a(new PlatformImplementations.kt_3(i2, fragment));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public FragmentTransaction m3540a(int OplusGLSurfaceView_13, Fragment fragment) {
        return m3545b(OplusGLSurfaceView_13, fragment, null);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public FragmentTransaction m3545b(int OplusGLSurfaceView_13, Fragment fragment, String str) {
        if (OplusGLSurfaceView_13 == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        mo3313a(OplusGLSurfaceView_13, fragment, str, 2);
        return this;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public FragmentTransaction mo3309a(Fragment fragment) {
        m3544a(new PlatformImplementations.kt_3(3, fragment));
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public FragmentTransaction mo3321b(Fragment fragment) {
        m3544a(new PlatformImplementations.kt_3(6, fragment));
        return this;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public FragmentTransaction m3546c(Fragment fragment) {
        m3544a(new PlatformImplementations.kt_3(7, fragment));
        return this;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public FragmentTransaction mo3310a(Fragment fragment, Lifecycle.IntrinsicsJvm.kt_4 bVar) {
        m3544a(new PlatformImplementations.kt_3(10, fragment, bVar));
        return this;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean mo3329h() {
        return this.f3509d.isEmpty();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public FragmentTransaction m3543a(String str) {
        if (!this.f3517l) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        this.f3516k = true;
        this.f3518m = str;
        return this;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public FragmentTransaction m3547i() {
        if (this.f3516k) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f3517l = false;
        return this;
    }
}
