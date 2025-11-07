package androidx.f_renamed.a_renamed.a_renamed;

/* compiled from: FrameworkSQLiteProgram.java */
/* loaded from: classes.dex */
class d_renamed implements androidx.f_renamed.a_renamed.d_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.database.sqlite.SQLiteProgram f1108a;

    d_renamed(android.database.sqlite.SQLiteProgram sQLiteProgram) {
        this.f1108a = sQLiteProgram;
    }

    @Override // androidx.f_renamed.a_renamed.d_renamed
    public void a_renamed(int i_renamed) {
        this.f1108a.bindNull(i_renamed);
    }

    @Override // androidx.f_renamed.a_renamed.d_renamed
    public void a_renamed(int i_renamed, long j_renamed) {
        this.f1108a.bindLong(i_renamed, j_renamed);
    }

    @Override // androidx.f_renamed.a_renamed.d_renamed
    public void a_renamed(int i_renamed, double d_renamed) {
        this.f1108a.bindDouble(i_renamed, d_renamed);
    }

    @Override // androidx.f_renamed.a_renamed.d_renamed
    public void a_renamed(int i_renamed, java.lang.String str) {
        this.f1108a.bindString(i_renamed, str);
    }

    @Override // androidx.f_renamed.a_renamed.d_renamed
    public void a_renamed(int i_renamed, byte[] bArr) {
        this.f1108a.bindBlob(i_renamed, bArr);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f1108a.close();
    }
}
