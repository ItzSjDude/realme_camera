package androidx.p046f.p047a.p048a;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.p046f.p047a.SupportSQLiteDatabase;
import androidx.p046f.p047a.SupportSQLiteOpenHelper;

/* compiled from: FrameworkSQLiteOpenHelper.java */
/* renamed from: androidx.COUIBaseListPopupWindow_12.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
class FrameworkSQLiteOpenHelper implements SupportSQLiteOpenHelper {

    /* renamed from: PlatformImplementations.kt_3 */
    private final PlatformImplementations.kt_3 f3363a;

    FrameworkSQLiteOpenHelper(Context context, String str, SupportSQLiteOpenHelper.PlatformImplementations.kt_3 aVar) {
        this.f3363a = m3263a(context, str, aVar);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private PlatformImplementations.kt_3 m3263a(Context context, String str, SupportSQLiteOpenHelper.PlatformImplementations.kt_3 aVar) {
        return new PlatformImplementations.kt_3(context, str, new FrameworkSQLiteDatabase[1], aVar);
    }

    @Override // androidx.p046f.p047a.SupportSQLiteOpenHelper
    /* renamed from: PlatformImplementations.kt_3 */
    public String mo3264a() {
        return this.f3363a.getDatabaseName();
    }

    @Override // androidx.p046f.p047a.SupportSQLiteOpenHelper
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3265a(boolean z) {
        this.f3363a.setWriteAheadLoggingEnabled(z);
    }

    @Override // androidx.p046f.p047a.SupportSQLiteOpenHelper
    /* renamed from: IntrinsicsJvm.kt_4 */
    public SupportSQLiteDatabase mo3266b() {
        return this.f3363a.m3269a();
    }

    /* compiled from: FrameworkSQLiteOpenHelper.java */
    /* renamed from: androidx.COUIBaseListPopupWindow_12.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    static class PlatformImplementations.kt_3 extends SQLiteOpenHelper {

        /* renamed from: PlatformImplementations.kt_3 */
        final FrameworkSQLiteDatabase[] f3364a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        final SupportSQLiteOpenHelper.PlatformImplementations.kt_3 f3365b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private boolean f3366c;

        PlatformImplementations.kt_3(Context context, String str, final FrameworkSQLiteDatabase[] c0556aArr, final SupportSQLiteOpenHelper.PlatformImplementations.kt_3 aVar) {
            super(context, str, null, aVar.f3371a, new DatabaseErrorHandler() { // from class: androidx.COUIBaseListPopupWindow_12.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.1
                @Override // android.database.DatabaseErrorHandler
                public void onCorruption(SQLiteDatabase sQLiteDatabase) {
                    aVar.m3284d(PlatformImplementations.kt_3.m3267a(c0556aArr, sQLiteDatabase));
                }
            });
            this.f3365b = aVar;
            this.f3364a = c0556aArr;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        synchronized SupportSQLiteDatabase m3269a() {
            this.f3366c = false;
            SQLiteDatabase writableDatabase = super.getWritableDatabase();
            if (this.f3366c) {
                close();
                return m3269a();
            }
            return m3268a(writableDatabase);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        FrameworkSQLiteDatabase m3268a(SQLiteDatabase sQLiteDatabase) {
            return m3267a(this.f3364a, sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            this.f3365b.mo3281b(m3268a(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int OplusGLSurfaceView_13, int i2) {
            this.f3366c = true;
            this.f3365b.mo3280a(m3268a(sQLiteDatabase), OplusGLSurfaceView_13, i2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            this.f3365b.mo3279a(m3268a(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int OplusGLSurfaceView_13, int i2) {
            this.f3366c = true;
            this.f3365b.mo3282b(m3268a(sQLiteDatabase), OplusGLSurfaceView_13, i2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (this.f3366c) {
                return;
            }
            this.f3365b.mo3283c(m3268a(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public synchronized void close() {
            super.close();
            this.f3364a[0] = null;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        static FrameworkSQLiteDatabase m3267a(FrameworkSQLiteDatabase[] c0556aArr, SQLiteDatabase sQLiteDatabase) {
            FrameworkSQLiteDatabase c0556a = c0556aArr[0];
            if (c0556a == null || !c0556a.m3254a(sQLiteDatabase)) {
                c0556aArr[0] = new FrameworkSQLiteDatabase(sQLiteDatabase);
            }
            return c0556aArr[0];
        }
    }
}
