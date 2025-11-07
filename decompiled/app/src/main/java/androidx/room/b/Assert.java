package androidx.room.b_renamed;

/* compiled from: CopyLock.java */
/* loaded from: classes.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.util.Map<java.lang.String, java.util.concurrent.locks.Lock> f1578a = new java.util.HashMap();

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.io.File f1579b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final java.util.concurrent.locks.Lock f1580c;
    private final boolean d_renamed;
    private java.nio.channels.FileChannel e_renamed;

    public a_renamed(java.lang.String str, java.io.File file, boolean z_renamed) {
        this.f1579b = new java.io.File(file, str + ".lck");
        this.f1580c = a_renamed(this.f1579b.getAbsolutePath());
        this.d_renamed = z_renamed;
    }

    public void a_renamed() throws java.io.IOException {
        this.f1580c.lock();
        if (this.d_renamed) {
            try {
                this.e_renamed = new java.io.FileOutputStream(this.f1579b).getChannel();
                this.e_renamed.lock();
            } catch (java.io.IOException e_renamed) {
                throw new java.lang.IllegalStateException("Unable to grab copy lock.", e_renamed);
            }
        }
    }

    public void b_renamed() {
        java.nio.channels.FileChannel fileChannel = this.e_renamed;
        if (fileChannel != null) {
            try {
                fileChannel.close();
            } catch (java.io.IOException unused) {
            }
        }
        this.f1580c.unlock();
    }

    private static java.util.concurrent.locks.Lock a_renamed(java.lang.String str) {
        java.util.concurrent.locks.Lock reentrantLock;
        synchronized (f1578a) {
            reentrantLock = f1578a.get(str);
            if (reentrantLock == null) {
                reentrantLock = new java.util.concurrent.locks.ReentrantLock();
                f1578a.put(str, reentrantLock);
            }
        }
        return reentrantLock;
    }
}
