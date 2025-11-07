package androidx.core.g_renamed;

/* compiled from: LogWriter.java */
@java.lang.Deprecated
/* loaded from: classes.dex */
public class b_renamed extends java.io.Writer {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.String f916a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.lang.StringBuilder f917b = new java.lang.StringBuilder(128);

    public b_renamed(java.lang.String str) {
        this.f916a = str;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a_renamed();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        a_renamed();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i_renamed, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c2 = cArr[i_renamed + i3];
            if (c2 == '\n_renamed') {
                a_renamed();
            } else {
                this.f917b.append(c2);
            }
        }
    }

    private void a_renamed() {
        if (this.f917b.length() > 0) {
            android.util.Log.d_renamed(this.f916a, this.f917b.toString());
            java.lang.StringBuilder sb = this.f917b;
            sb.delete(0, sb.length());
        }
    }
}
