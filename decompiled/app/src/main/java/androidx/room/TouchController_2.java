package androidx.room;

/* compiled from: SharedSQLiteStatement.java */
/* loaded from: classes.dex */
public abstract class m_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.util.concurrent.atomic.AtomicBoolean f1638a = new java.util.concurrent.atomic.AtomicBoolean(false);

    /* renamed from: b_renamed, reason: collision with root package name */
    private final androidx.room.g_renamed f1639b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private volatile androidx.f_renamed.a_renamed.f_renamed f1640c;

    protected abstract java.lang.String a_renamed();

    public m_renamed(androidx.room.g_renamed gVar) {
        this.f1639b = gVar;
    }

    protected void b_renamed() {
        this.f1639b.e_renamed();
    }

    private androidx.f_renamed.a_renamed.f_renamed d_renamed() {
        return this.f1639b.a_renamed(a_renamed());
    }

    private androidx.f_renamed.a_renamed.f_renamed a_renamed(boolean z_renamed) {
        if (z_renamed) {
            if (this.f1640c == null) {
                this.f1640c = d_renamed();
            }
            return this.f1640c;
        }
        return d_renamed();
    }

    public androidx.f_renamed.a_renamed.f_renamed c_renamed() {
        b_renamed();
        return a_renamed(this.f1638a.compareAndSet(false, true));
    }

    public void a_renamed(androidx.f_renamed.a_renamed.f_renamed fVar) {
        if (fVar == this.f1640c) {
            this.f1638a.set(false);
        }
    }
}
