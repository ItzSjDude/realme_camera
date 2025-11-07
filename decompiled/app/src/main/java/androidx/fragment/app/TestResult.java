package androidx.fragment.app;

/* compiled from: FragmentManager.java */
/* loaded from: classes.dex */
public abstract class h_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    static final androidx.fragment.app.f_renamed f1140a = new androidx.fragment.app.f_renamed();

    /* renamed from: b_renamed, reason: collision with root package name */
    private androidx.fragment.app.f_renamed f1141b = null;

    /* compiled from: FragmentManager.java */
    public static abstract class a_renamed {
        public void a_renamed(androidx.fragment.app.h_renamed hVar, androidx.fragment.app.Fragment fragment) {
        }

        public void a_renamed(androidx.fragment.app.h_renamed hVar, androidx.fragment.app.Fragment fragment, android.content.Context context) {
        }

        public void a_renamed(androidx.fragment.app.h_renamed hVar, androidx.fragment.app.Fragment fragment, android.os.Bundle bundle) {
        }

        public void a_renamed(androidx.fragment.app.h_renamed hVar, androidx.fragment.app.Fragment fragment, android.view.View view, android.os.Bundle bundle) {
        }

        public void b_renamed(androidx.fragment.app.h_renamed hVar, androidx.fragment.app.Fragment fragment) {
        }

        public void b_renamed(androidx.fragment.app.h_renamed hVar, androidx.fragment.app.Fragment fragment, android.content.Context context) {
        }

        public void b_renamed(androidx.fragment.app.h_renamed hVar, androidx.fragment.app.Fragment fragment, android.os.Bundle bundle) {
        }

        public void c_renamed(androidx.fragment.app.h_renamed hVar, androidx.fragment.app.Fragment fragment) {
        }

        public void c_renamed(androidx.fragment.app.h_renamed hVar, androidx.fragment.app.Fragment fragment, android.os.Bundle bundle) {
        }

        public void d_renamed(androidx.fragment.app.h_renamed hVar, androidx.fragment.app.Fragment fragment) {
        }

        public void d_renamed(androidx.fragment.app.h_renamed hVar, androidx.fragment.app.Fragment fragment, android.os.Bundle bundle) {
        }

        public void e_renamed(androidx.fragment.app.h_renamed hVar, androidx.fragment.app.Fragment fragment) {
        }

        public void f_renamed(androidx.fragment.app.h_renamed hVar, androidx.fragment.app.Fragment fragment) {
        }

        public void g_renamed(androidx.fragment.app.h_renamed hVar, androidx.fragment.app.Fragment fragment) {
        }
    }

    /* compiled from: FragmentManager.java */
    public interface b_renamed {
        void a_renamed();
    }

    public abstract androidx.fragment.app.Fragment a_renamed(java.lang.String str);

    public abstract androidx.fragment.app.k_renamed a_renamed();

    public abstract void a_renamed(int i_renamed, int i2);

    public abstract void a_renamed(androidx.fragment.app.h_renamed.a_renamed aVar);

    public abstract void a_renamed(androidx.fragment.app.h_renamed.a_renamed aVar, boolean z_renamed);

    public abstract void a_renamed(java.lang.String str, java.io.FileDescriptor fileDescriptor, java.io.PrintWriter printWriter, java.lang.String[] strArr);

    public abstract boolean b_renamed();

    public abstract boolean c_renamed();

    public abstract java.util.List<androidx.fragment.app.Fragment> d_renamed();

    public abstract boolean e_renamed();

    public abstract boolean g_renamed();

    public void a_renamed(androidx.fragment.app.f_renamed fVar) {
        this.f1141b = fVar;
    }

    public androidx.fragment.app.f_renamed f_renamed() {
        if (this.f1141b == null) {
            this.f1141b = f1140a;
        }
        return this.f1141b;
    }
}
