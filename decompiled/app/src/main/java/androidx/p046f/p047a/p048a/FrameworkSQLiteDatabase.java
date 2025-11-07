package androidx.p046f.p047a.p048a;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.p046f.p047a.SimpleSQLiteQuery;
import androidx.p046f.p047a.SupportSQLiteDatabase;
import androidx.p046f.p047a.SupportSQLiteQuery;
import androidx.p046f.p047a.SupportSQLiteStatement;
import java.io.IOException;
import java.util.List;

/* compiled from: FrameworkSQLiteDatabase.java */
/* renamed from: androidx.COUIBaseListPopupWindow_12.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
class FrameworkSQLiteDatabase implements SupportSQLiteDatabase {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String[] f3356a = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final String[] f3357b = new String[0];

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final SQLiteDatabase f3358c;

    FrameworkSQLiteDatabase(SQLiteDatabase sQLiteDatabase) {
        this.f3358c = sQLiteDatabase;
    }

    @Override // androidx.p046f.p047a.SupportSQLiteDatabase
    /* renamed from: PlatformImplementations.kt_3 */
    public SupportSQLiteStatement mo3252a(String str) {
        return new FrameworkSQLiteStatement(this.f3358c.compileStatement(str));
    }

    @Override // androidx.p046f.p047a.SupportSQLiteDatabase
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3253a() {
        this.f3358c.beginTransaction();
    }

    @Override // androidx.p046f.p047a.SupportSQLiteDatabase
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo3256b() {
        this.f3358c.endTransaction();
    }

    @Override // androidx.p046f.p047a.SupportSQLiteDatabase
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo3257c() {
        this.f3358c.setTransactionSuccessful();
    }

    @Override // androidx.p046f.p047a.SupportSQLiteDatabase
    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean mo3259d() {
        return this.f3358c.inTransaction();
    }

    @Override // androidx.p046f.p047a.SupportSQLiteDatabase
    /* renamed from: IntrinsicsJvm.kt_4 */
    public Cursor mo3255b(String str) {
        return mo3250a(new SimpleSQLiteQuery(str));
    }

    @Override // androidx.p046f.p047a.SupportSQLiteDatabase
    /* renamed from: PlatformImplementations.kt_3 */
    public Cursor mo3250a(final SupportSQLiteQuery interfaceC0564e) {
        return this.f3358c.rawQueryWithFactory(new SQLiteDatabase.CursorFactory() { // from class: androidx.COUIBaseListPopupWindow_12.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3.1
            @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
            public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                interfaceC0564e.mo3248a(new FrameworkSQLiteProgram(sQLiteQuery));
                return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
            }
        }, interfaceC0564e.mo3249b(), f3357b, null);
    }

    @Override // androidx.p046f.p047a.SupportSQLiteDatabase
    /* renamed from: PlatformImplementations.kt_3 */
    public Cursor mo3251a(final SupportSQLiteQuery interfaceC0564e, CancellationSignal cancellationSignal) {
        return this.f3358c.rawQueryWithFactory(new SQLiteDatabase.CursorFactory() { // from class: androidx.COUIBaseListPopupWindow_12.PlatformImplementations.kt_3.PlatformImplementations.kt_3.PlatformImplementations.kt_3.2
            @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
            public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
                interfaceC0564e.mo3248a(new FrameworkSQLiteProgram(sQLiteQuery));
                return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
            }
        }, interfaceC0564e.mo3249b(), f3357b, null, cancellationSignal);
    }

    @Override // androidx.p046f.p047a.SupportSQLiteDatabase
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo3258c(String str) throws SQLException {
        this.f3358c.execSQL(str);
    }

    @Override // androidx.p046f.p047a.SupportSQLiteDatabase
    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean mo3260e() {
        return this.f3358c.isOpen();
    }

    @Override // androidx.p046f.p047a.SupportSQLiteDatabase
    /* renamed from: COUIBaseListPopupWindow_12 */
    public String mo3261f() {
        return this.f3358c.getPath();
    }

    @Override // androidx.p046f.p047a.SupportSQLiteDatabase
    /* renamed from: COUIBaseListPopupWindow_11 */
    public List<Pair<String, String>> mo3262g() {
        return this.f3358c.getAttachedDbs();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f3358c.close();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    boolean m3254a(SQLiteDatabase sQLiteDatabase) {
        return this.f3358c == sQLiteDatabase;
    }
}
