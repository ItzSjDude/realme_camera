package androidx.fragment.app;

/* compiled from: FragmentTransaction.java */
/* loaded from: classes.dex */
public abstract class k_renamed {
    int e_renamed;
    int f_renamed;
    int g_renamed;
    int h_renamed;
    int i_renamed;
    int j_renamed;
    boolean k_renamed;
    java.lang.String m_renamed;
    int n_renamed;
    java.lang.CharSequence o_renamed;
    int p_renamed;
    java.lang.CharSequence q_renamed;
    java.util.ArrayList<java.lang.String> r_renamed;
    java.util.ArrayList<java.lang.String> s_renamed;
    java.util.ArrayList<java.lang.Runnable> u_renamed;
    java.util.ArrayList<androidx.fragment.app.k_renamed.a_renamed> d_renamed = new java.util.ArrayList<>();
    boolean l_renamed = true;
    boolean t_renamed = false;

    public abstract int b_renamed();

    public abstract int c_renamed();

    public abstract void d_renamed();

    /* compiled from: FragmentTransaction.java */
    static final class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        int f1174a;

        /* renamed from: b_renamed, reason: collision with root package name */
        androidx.fragment.app.Fragment f1175b;

        /* renamed from: c_renamed, reason: collision with root package name */
        int f1176c;
        int d_renamed;
        int e_renamed;
        int f_renamed;
        androidx.lifecycle.e_renamed.b_renamed g_renamed;
        androidx.lifecycle.e_renamed.b_renamed h_renamed;

        a_renamed() {
        }

        a_renamed(int i_renamed, androidx.fragment.app.Fragment fragment) {
            this.f1174a = i_renamed;
            this.f1175b = fragment;
            this.g_renamed = androidx.lifecycle.e_renamed.b_renamed.RESUMED;
            this.h_renamed = androidx.lifecycle.e_renamed.b_renamed.RESUMED;
        }

        a_renamed(int i_renamed, androidx.fragment.app.Fragment fragment, androidx.lifecycle.e_renamed.b_renamed bVar) {
            this.f1174a = i_renamed;
            this.f1175b = fragment;
            this.g_renamed = fragment.mMaxState;
            this.h_renamed = bVar;
        }
    }

    void a_renamed(androidx.fragment.app.k_renamed.a_renamed aVar) {
        this.d_renamed.add(aVar);
        aVar.f1176c = this.e_renamed;
        aVar.d_renamed = this.f_renamed;
        aVar.e_renamed = this.g_renamed;
        aVar.f_renamed = this.h_renamed;
    }

    public androidx.fragment.app.k_renamed a_renamed(androidx.fragment.app.Fragment fragment, java.lang.String str) {
        a_renamed(0, fragment, str, 1);
        return this;
    }

    public androidx.fragment.app.k_renamed a_renamed(int i_renamed, androidx.fragment.app.Fragment fragment, java.lang.String str) {
        a_renamed(i_renamed, fragment, str, 1);
        return this;
    }

    void a_renamed(int i_renamed, androidx.fragment.app.Fragment fragment, java.lang.String str, int i2) {
        java.lang.Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !java.lang.reflect.Modifier.isPublic(modifiers) || (cls.isMemberClass() && !java.lang.reflect.Modifier.isStatic(modifiers))) {
            throw new java.lang.IllegalStateException("Fragment " + cls.getCanonicalName() + " must be_renamed a_renamed public static class to be_renamed  properly recreated from instance state.");
        }
        if (str != null) {
            if (fragment.mTag != null && !str.equals(fragment.mTag)) {
                throw new java.lang.IllegalStateException("Can't_renamed change tag of_renamed fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
            fragment.mTag = str;
        }
        if (i_renamed != 0) {
            if (i_renamed == -1) {
                throw new java.lang.IllegalArgumentException("Can't_renamed add fragment " + fragment + " with tag " + str + " to container view with no id_renamed");
            }
            if (fragment.mFragmentId != 0 && fragment.mFragmentId != i_renamed) {
                throw new java.lang.IllegalStateException("Can't_renamed change container ID_renamed of_renamed fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i_renamed);
            }
            fragment.mFragmentId = i_renamed;
            fragment.mContainerId = i_renamed;
        }
        a_renamed(new androidx.fragment.app.k_renamed.a_renamed(i2, fragment));
    }

    public androidx.fragment.app.k_renamed a_renamed(int i_renamed, androidx.fragment.app.Fragment fragment) {
        return b_renamed(i_renamed, fragment, null);
    }

    public androidx.fragment.app.k_renamed b_renamed(int i_renamed, androidx.fragment.app.Fragment fragment, java.lang.String str) {
        if (i_renamed == 0) {
            throw new java.lang.IllegalArgumentException("Must use non-zero containerViewId");
        }
        a_renamed(i_renamed, fragment, str, 2);
        return this;
    }

    public androidx.fragment.app.k_renamed a_renamed(androidx.fragment.app.Fragment fragment) {
        a_renamed(new androidx.fragment.app.k_renamed.a_renamed(3, fragment));
        return this;
    }

    public androidx.fragment.app.k_renamed b_renamed(androidx.fragment.app.Fragment fragment) {
        a_renamed(new androidx.fragment.app.k_renamed.a_renamed(6, fragment));
        return this;
    }

    public androidx.fragment.app.k_renamed c_renamed(androidx.fragment.app.Fragment fragment) {
        a_renamed(new androidx.fragment.app.k_renamed.a_renamed(7, fragment));
        return this;
    }

    public androidx.fragment.app.k_renamed a_renamed(androidx.fragment.app.Fragment fragment, androidx.lifecycle.e_renamed.b_renamed bVar) {
        a_renamed(new androidx.fragment.app.k_renamed.a_renamed(10, fragment, bVar));
        return this;
    }

    public boolean h_renamed() {
        return this.d_renamed.isEmpty();
    }

    public androidx.fragment.app.k_renamed a_renamed(java.lang.String str) {
        if (!this.l_renamed) {
            throw new java.lang.IllegalStateException("This FragmentTransaction is_renamed not allowed to be_renamed added to the back stack.");
        }
        this.k_renamed = true;
        this.m_renamed = str;
        return this;
    }

    public androidx.fragment.app.k_renamed i_renamed() {
        if (this.k_renamed) {
            throw new java.lang.IllegalStateException("This transaction is_renamed already being added to the back stack");
        }
        this.l_renamed = false;
        return this;
    }
}
