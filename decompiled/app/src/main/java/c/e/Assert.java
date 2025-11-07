package c_renamed.e_renamed;

/* compiled from: Closeable.kt */
/* loaded from: classes.dex */
public final class a_renamed {
    public static final void a_renamed(java.io.Closeable closeable, java.lang.Throwable th) throws java.io.IOException {
        if (closeable == null) {
            return;
        }
        if (th == null) {
            closeable.close();
            return;
        }
        try {
            closeable.close();
        } catch (java.lang.Throwable th2) {
            c_renamed.a_renamed.a_renamed(th, th2);
        }
    }
}
