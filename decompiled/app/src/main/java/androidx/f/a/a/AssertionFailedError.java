package androidx.f_renamed.a_renamed.a_renamed;

/* compiled from: FrameworkSQLiteOpenHelper.java */
/* loaded from: classes.dex */
class b_renamed implements androidx.f_renamed.a_renamed.c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final androidx.f_renamed.a_renamed.a_renamed.b_renamed.a_renamed f1102a;

    b_renamed(android.content.Context context, java.lang.String str, androidx.f_renamed.a_renamed.c_renamed.a_renamed aVar) {
        this.f1102a = a_renamed(context, str, aVar);
    }

    private androidx.f_renamed.a_renamed.a_renamed.b_renamed.a_renamed a_renamed(android.content.Context context, java.lang.String str, androidx.f_renamed.a_renamed.c_renamed.a_renamed aVar) {
        return new androidx.f_renamed.a_renamed.a_renamed.b_renamed.a_renamed(context, str, new androidx.f_renamed.a_renamed.a_renamed.a_renamed[1], aVar);
    }

    @Override // androidx.f_renamed.a_renamed.c_renamed
    public java.lang.String a_renamed() {
        return this.f1102a.getDatabaseName();
    }

    @Override // androidx.f_renamed.a_renamed.c_renamed
    public void a_renamed(boolean z_renamed) {
        this.f1102a.setWriteAheadLoggingEnabled(z_renamed);
    }

    @Override // androidx.f_renamed.a_renamed.c_renamed
    public androidx.f_renamed.a_renamed.b_renamed b_renamed() {
        return this.f1102a.a_renamed();
    }

    /* compiled from: FrameworkSQLiteOpenHelper.java */
    static class a_renamed extends android.database.sqlite.SQLiteOpenHelper {

        /* renamed from: a_renamed, reason: collision with root package name */
        final androidx.f_renamed.a_renamed.a_renamed.a_renamed[] f1103a;

        /* renamed from: b_renamed, reason: collision with root package name */
        final androidx.f_renamed.a_renamed.c_renamed.a_renamed f1104b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private boolean f1105c;

        a_renamed(android.content.Context context, java.lang.String str, final androidx.f_renamed.a_renamed.a_renamed.a_renamed[] aVarArr, final androidx.f_renamed.a_renamed.c_renamed.a_renamed aVar) {
            super(context, str, null, aVar.f1110a, new android.database.DatabaseErrorHandler() { // from class: androidx.f_renamed.a_renamed.a_renamed.b_renamed.a_renamed.1
                @Override // android.database.DatabaseErrorHandler
                public void onCorruption(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
                    aVar.d_renamed(androidx.f_renamed.a_renamed.a_renamed.b_renamed.a_renamed.a_renamed(aVarArr, sQLiteDatabase));
                }
            });
            this.f1104b = aVar;
            this.f1103a = aVarArr;
        }

        synchronized androidx.f_renamed.a_renamed.b_renamed a_renamed() {
            this.f1105c = false;
            android.database.sqlite.SQLiteDatabase writableDatabase = super.getWritableDatabase();
            if (this.f1105c) {
                close();
                return a_renamed();
            }
            return a_renamed(writableDatabase);
        }

        androidx.f_renamed.a_renamed.a_renamed.a_renamed a_renamed(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
            return a_renamed(this.f1103a, sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
            this.f1104b.b_renamed(a_renamed(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i_renamed, int i2) {
            this.f1105c = true;
            this.f1104b.a_renamed(a_renamed(sQLiteDatabase), i_renamed, i2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
            this.f1104b.a_renamed(a_renamed(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i_renamed, int i2) {
            this.f1105c = true;
            this.f1104b.b_renamed(a_renamed(sQLiteDatabase), i_renamed, i2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
            if (this.f1105c) {
                return;
            }
            this.f1104b.c_renamed(a_renamed(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public synchronized void close() {
            super.close();
            this.f1103a[0] = null;
        }

        static androidx.f_renamed.a_renamed.a_renamed.a_renamed a_renamed(androidx.f_renamed.a_renamed.a_renamed.a_renamed[] aVarArr, android.database.sqlite.SQLiteDatabase sQLiteDatabase) {
            androidx.f_renamed.a_renamed.a_renamed.a_renamed aVar = aVarArr[0];
            if (aVar == null || !aVar.a_renamed(sQLiteDatabase)) {
                aVarArr[0] = new androidx.f_renamed.a_renamed.a_renamed.a_renamed(sQLiteDatabase);
            }
            return aVarArr[0];
        }
    }
}
