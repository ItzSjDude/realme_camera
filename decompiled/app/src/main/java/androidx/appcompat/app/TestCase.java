package androidx.appcompat.app;

/* compiled from: AppCompatDelegate.java */
/* loaded from: classes.dex */
public abstract class e_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static int f266a = -100;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final androidx.collection.ArraySet<java.lang.ref.WeakReference<androidx.appcompat.app.e_renamed>> f267b = new androidx.collection.ArraySet<>();

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final java.lang.Object f268c = new java.lang.Object();

    public abstract androidx.appcompat.app.a_renamed a_renamed();

    public void a_renamed(int i_renamed) {
    }

    public void a_renamed(android.content.Context context) {
    }

    public abstract void a_renamed(android.content.res.Configuration configuration);

    public abstract void a_renamed(android.os.Bundle bundle);

    public abstract void a_renamed(android.view.View view);

    public abstract void a_renamed(android.view.View view, android.view.ViewGroup.LayoutParams layoutParams);

    public abstract void a_renamed(androidx.appcompat.widget.Toolbar toolbar);

    public abstract void a_renamed(java.lang.CharSequence charSequence);

    public abstract android.view.MenuInflater b_renamed();

    public abstract <T_renamed extends android.view.View> T_renamed b_renamed(int i_renamed);

    public abstract void b_renamed(android.os.Bundle bundle);

    public abstract void b_renamed(android.view.View view, android.view.ViewGroup.LayoutParams layoutParams);

    public abstract void c_renamed();

    public abstract void c_renamed(int i_renamed);

    public abstract void c_renamed(android.os.Bundle bundle);

    public abstract void d_renamed();

    public abstract boolean d_renamed(int i_renamed);

    public abstract void e_renamed();

    public abstract void f_renamed();

    public abstract void g_renamed();

    public abstract void h_renamed();

    public int i_renamed() {
        return -100;
    }

    public static androidx.appcompat.app.e_renamed a_renamed(android.app.Activity activity, androidx.appcompat.app.d_renamed dVar) {
        return new androidx.appcompat.app.AppCompatDelegateImpl(activity, dVar);
    }

    public static androidx.appcompat.app.e_renamed a_renamed(android.app.Dialog dialog, androidx.appcompat.app.d_renamed dVar) {
        return new androidx.appcompat.app.AppCompatDelegateImpl(dialog, dVar);
    }

    e_renamed() {
    }

    public static int j_renamed() {
        return f266a;
    }

    static void a_renamed(androidx.appcompat.app.e_renamed eVar) {
        synchronized (f268c) {
            c_renamed(eVar);
            f267b.add(new java.lang.ref.WeakReference<>(eVar));
        }
    }

    static void b_renamed(androidx.appcompat.app.e_renamed eVar) {
        synchronized (f268c) {
            c_renamed(eVar);
        }
    }

    private static void c_renamed(androidx.appcompat.app.e_renamed eVar) {
        synchronized (f268c) {
            java.util.Iterator<java.lang.ref.WeakReference<androidx.appcompat.app.e_renamed>> it = f267b.iterator();
            while (it.hasNext()) {
                androidx.appcompat.app.e_renamed eVar2 = it.next().get();
                if (eVar2 == eVar || eVar2 == null) {
                    it.remove();
                }
            }
        }
    }
}
