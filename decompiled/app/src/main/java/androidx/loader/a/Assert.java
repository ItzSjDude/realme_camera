package androidx.loader.a_renamed;

/* compiled from: LoaderManager.java */
/* loaded from: classes.dex */
public abstract class a_renamed {

    /* compiled from: LoaderManager.java */
    /* renamed from: androidx.loader.a_renamed.a_renamed$a_renamed, reason: collision with other inner class name */
    public interface LoaderManager_2<D_renamed> {
        void a_renamed(androidx.loader.b_renamed.a_renamed<D_renamed> aVar);

        void a_renamed(androidx.loader.b_renamed.a_renamed<D_renamed> aVar, D_renamed d_renamed);
    }

    public abstract void a_renamed();

    @java.lang.Deprecated
    public abstract void a_renamed(java.lang.String str, java.io.FileDescriptor fileDescriptor, java.io.PrintWriter printWriter, java.lang.String[] strArr);

    public static <T_renamed extends androidx.lifecycle.h_renamed & androidx.lifecycle.t_renamed> androidx.loader.a_renamed.a_renamed a_renamed(T_renamed t_renamed) {
        return new androidx.loader.a_renamed.b_renamed(t_renamed, t_renamed.getViewModelStore());
    }
}
