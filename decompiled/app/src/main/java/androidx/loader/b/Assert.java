package androidx.loader.b_renamed;

/* compiled from: Loader.java */
/* loaded from: classes.dex */
public class a_renamed<D_renamed> {

    /* renamed from: a_renamed, reason: collision with root package name */
    int f1262a;

    /* renamed from: b_renamed, reason: collision with root package name */
    androidx.loader.b_renamed.a_renamed.Loader_2<D_renamed> f1263b;

    /* renamed from: c_renamed, reason: collision with root package name */
    boolean f1264c;
    boolean d_renamed;
    boolean e_renamed;
    boolean f_renamed;
    boolean g_renamed;

    /* compiled from: Loader.java */
    /* renamed from: androidx.loader.b_renamed.a_renamed$a_renamed, reason: collision with other inner class name */
    public interface Loader_2<D_renamed> {
    }

    protected void b_renamed() {
    }

    protected boolean d_renamed() {
        return false;
    }

    protected void f_renamed() {
    }

    protected void h_renamed() {
    }

    protected void j_renamed() {
    }

    public void a_renamed(androidx.loader.b_renamed.a_renamed.Loader_2<D_renamed> interfaceC0034a) {
        androidx.loader.b_renamed.a_renamed.Loader_2<D_renamed> interfaceC0034a2 = this.f1263b;
        if (interfaceC0034a2 == null) {
            throw new java.lang.IllegalStateException("No listener register");
        }
        if (interfaceC0034a2 != interfaceC0034a) {
            throw new java.lang.IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.f1263b = null;
    }

    public final void a_renamed() {
        this.f1264c = true;
        this.e_renamed = false;
        this.d_renamed = false;
        b_renamed();
    }

    public boolean c_renamed() {
        return d_renamed();
    }

    public void e_renamed() {
        this.f1264c = false;
        f_renamed();
    }

    public void g_renamed() {
        this.d_renamed = true;
        h_renamed();
    }

    public void i_renamed() {
        j_renamed();
        this.e_renamed = true;
        this.f1264c = false;
        this.d_renamed = false;
        this.f_renamed = false;
        this.g_renamed = false;
    }

    public java.lang.String a_renamed(D_renamed d_renamed) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(64);
        androidx.core.g_renamed.a_renamed.a_renamed(d_renamed, sb);
        sb.append("}");
        return sb.toString();
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(64);
        androidx.core.g_renamed.a_renamed.a_renamed(this, sb);
        sb.append(" id_renamed=");
        sb.append(this.f1262a);
        sb.append("}");
        return sb.toString();
    }

    @java.lang.Deprecated
    public void a_renamed(java.lang.String str, java.io.FileDescriptor fileDescriptor, java.io.PrintWriter printWriter, java.lang.String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f1262a);
        printWriter.print(" mListener=");
        printWriter.println(this.f1263b);
        if (this.f1264c || this.f_renamed || this.g_renamed) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f1264c);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f_renamed);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.g_renamed);
        }
        if (this.d_renamed || this.e_renamed) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.d_renamed);
            printWriter.print(" mReset=");
            printWriter.println(this.e_renamed);
        }
    }
}
