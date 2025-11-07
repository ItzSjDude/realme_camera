package androidx.fragment.app;

/* compiled from: FragmentHostCallback.java */
/* loaded from: classes.dex */
public abstract class g_renamed<E_renamed> extends androidx.fragment.app.d_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.app.Activity f1137a;

    /* renamed from: b_renamed, reason: collision with root package name */
    final androidx.fragment.app.i_renamed f1138b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final android.content.Context f1139c;
    private final android.os.Handler d_renamed;
    private final int e_renamed;

    @Override // androidx.fragment.app.d_renamed
    public android.view.View a_renamed(int i_renamed) {
        return null;
    }

    public void a_renamed(androidx.fragment.app.Fragment fragment, java.lang.String[] strArr, int i_renamed) {
    }

    public void a_renamed(java.lang.String str, java.io.FileDescriptor fileDescriptor, java.io.PrintWriter printWriter, java.lang.String[] strArr) {
    }

    @Override // androidx.fragment.app.d_renamed
    public boolean a_renamed() {
        return true;
    }

    public boolean a_renamed(androidx.fragment.app.Fragment fragment) {
        return true;
    }

    public boolean a_renamed(java.lang.String str) {
        return false;
    }

    void b_renamed(androidx.fragment.app.Fragment fragment) {
    }

    public void e_renamed() {
    }

    public boolean f_renamed() {
        return true;
    }

    public abstract E_renamed h_renamed();

    g_renamed(androidx.fragment.app.c_renamed cVar) {
        this(cVar, cVar, new android.os.Handler(), 0);
    }

    g_renamed(android.app.Activity activity, android.content.Context context, android.os.Handler handler, int i_renamed) {
        this.f1138b = new androidx.fragment.app.i_renamed();
        this.f1137a = activity;
        this.f1139c = (android.content.Context) androidx.core.g_renamed.f_renamed.a_renamed(context, "context == null");
        this.d_renamed = (android.os.Handler) androidx.core.g_renamed.f_renamed.a_renamed(handler, "handler == null");
        this.e_renamed = i_renamed;
    }

    public android.view.LayoutInflater c_renamed() {
        return android.view.LayoutInflater.from(this.f1139c);
    }

    public void a_renamed(androidx.fragment.app.Fragment fragment, @android.annotation.SuppressLint({"UnknownNullness"}) android.content.Intent intent, int i_renamed, android.os.Bundle bundle) {
        if (i_renamed != -1) {
            throw new java.lang.IllegalStateException("Starting activity with a_renamed requestCode requires a_renamed FragmentActivity host");
        }
        this.f1139c.startActivity(intent);
    }

    public void a_renamed(androidx.fragment.app.Fragment fragment, @android.annotation.SuppressLint({"UnknownNullness"}) android.content.IntentSender intentSender, int i_renamed, android.content.Intent intent, int i2, int i3, int i4, android.os.Bundle bundle) throws android.content.IntentSender.SendIntentException {
        if (i_renamed != -1) {
            throw new java.lang.IllegalStateException("Starting intent sender with a_renamed requestCode requires a_renamed FragmentActivity host");
        }
        androidx.core.app.a_renamed.a_renamed(this.f1137a, intentSender, i_renamed, intent, i2, i3, i4, bundle);
    }

    public int g_renamed() {
        return this.e_renamed;
    }

    android.app.Activity i_renamed() {
        return this.f1137a;
    }

    android.content.Context j_renamed() {
        return this.f1139c;
    }

    android.os.Handler k_renamed() {
        return this.d_renamed;
    }
}
