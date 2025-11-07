package androidx.f_renamed.a_renamed.a_renamed;

/* compiled from: FrameworkSQLiteStatement.java */
/* loaded from: classes.dex */
class e_renamed extends androidx.f_renamed.a_renamed.a_renamed.d_renamed implements androidx.f_renamed.a_renamed.f_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.database.sqlite.SQLiteStatement f1109a;

    e_renamed(android.database.sqlite.SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.f1109a = sQLiteStatement;
    }

    @Override // androidx.f_renamed.a_renamed.f_renamed
    public int a_renamed() {
        return this.f1109a.executeUpdateDelete();
    }

    @Override // androidx.f_renamed.a_renamed.f_renamed
    public long b_renamed() {
        return this.f1109a.executeInsert();
    }
}
