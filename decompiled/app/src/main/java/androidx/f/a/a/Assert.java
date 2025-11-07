package androidx.f_renamed.a_renamed.a_renamed;

/* compiled from: FrameworkSQLiteDatabase.java */
/* loaded from: classes.dex */
class a_renamed implements androidx.f_renamed.a_renamed.b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.String[] f1095a = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final java.lang.String[] f1096b = new java.lang.String[0];

    /* renamed from: c_renamed, reason: collision with root package name */
    private final android.database.sqlite.SQLiteDatabase f1097c;

    a_renamed(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        this.f1097c = sQLiteDatabase;
    }

    @Override // androidx.f_renamed.a_renamed.b_renamed
    public androidx.f_renamed.a_renamed.f_renamed a_renamed(java.lang.String str) {
        return new androidx.f_renamed.a_renamed.a_renamed.e_renamed(this.f1097c.compileStatement(str));
    }

    @Override // androidx.f_renamed.a_renamed.b_renamed
    public void a_renamed() {
        this.f1097c.beginTransaction();
    }

    @Override // androidx.f_renamed.a_renamed.b_renamed
    public void b_renamed() {
        this.f1097c.endTransaction();
    }

    @Override // androidx.f_renamed.a_renamed.b_renamed
    public void c_renamed() {
        this.f1097c.setTransactionSuccessful();
    }

    @Override // androidx.f_renamed.a_renamed.b_renamed
    public boolean d_renamed() {
        return this.f1097c.inTransaction();
    }

    @Override // androidx.f_renamed.a_renamed.b_renamed
    public android.database.Cursor b_renamed(java.lang.String str) {
        return a_renamed(new androidx.f_renamed.a_renamed.a_renamed(str));
    }

    @Override // androidx.f_renamed.a_renamed.b_renamed
    public android.database.Cursor a_renamed(final androidx.f_renamed.a_renamed.e_renamed eVar) {
        return this.f1097c.rawQueryWithFactory(new android.database.sqlite.SQLiteDatabase.CursorFactory() { // from class: androidx.f_renamed.a_renamed.a_renamed.a_renamed.1
            @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
            public android.database.Cursor newCursor(android.database.sqlite.SQLiteDatabase sQLiteDatabase, android.database.sqlite.SQLiteCursorDriver sQLiteCursorDriver, java.lang.String str, android.database.sqlite.SQLiteQuery sQLiteQuery) {
                eVar.a_renamed(new androidx.f_renamed.a_renamed.a_renamed.d_renamed(sQLiteQuery));
                return new android.database.sqlite.SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
            }
        }, eVar.b_renamed(), f1096b, null);
    }

    @Override // androidx.f_renamed.a_renamed.b_renamed
    public android.database.Cursor a_renamed(final androidx.f_renamed.a_renamed.e_renamed eVar, android.os.CancellationSignal cancellationSignal) {
        return this.f1097c.rawQueryWithFactory(new android.database.sqlite.SQLiteDatabase.CursorFactory() { // from class: androidx.f_renamed.a_renamed.a_renamed.a_renamed.2
            @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
            public android.database.Cursor newCursor(android.database.sqlite.SQLiteDatabase sQLiteDatabase, android.database.sqlite.SQLiteCursorDriver sQLiteCursorDriver, java.lang.String str, android.database.sqlite.SQLiteQuery sQLiteQuery) {
                eVar.a_renamed(new androidx.f_renamed.a_renamed.a_renamed.d_renamed(sQLiteQuery));
                return new android.database.sqlite.SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
            }
        }, eVar.b_renamed(), f1096b, null, cancellationSignal);
    }

    @Override // androidx.f_renamed.a_renamed.b_renamed
    public void c_renamed(java.lang.String str) throws android.database.SQLException {
        this.f1097c.execSQL(str);
    }

    @Override // androidx.f_renamed.a_renamed.b_renamed
    public boolean e_renamed() {
        return this.f1097c.isOpen();
    }

    @Override // androidx.f_renamed.a_renamed.b_renamed
    public java.lang.String f_renamed() {
        return this.f1097c.getPath();
    }

    @Override // androidx.f_renamed.a_renamed.b_renamed
    public java.util.List<android.util.Pair<java.lang.String, java.lang.String>> g_renamed() {
        return this.f1097c.getAttachedDbs();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.f1097c.close();
    }

    boolean a_renamed(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
        return this.f1097c == sQLiteDatabase;
    }
}
