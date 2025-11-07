package androidx.room;

import android.database.Cursor;
import android.database.SQLException;
import androidx.p046f.p047a.SimpleSQLiteQuery;
import androidx.p046f.p047a.SupportSQLiteDatabase;
import androidx.p046f.p047a.SupportSQLiteOpenHelper;
import androidx.room.p053a.Migration;
import java.util.Iterator;
import java.util.List;

/* compiled from: RoomOpenHelper.java */
/* renamed from: androidx.room.OplusGLSurfaceView_13 */
/* loaded from: classes.dex */
public class RoomOpenHelper extends SupportSQLiteOpenHelper.PlatformImplementations.kt_3 {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private DatabaseConfiguration f4449b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final PlatformImplementations.kt_3 f4450c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final String f4451d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final String f4452e;

    public RoomOpenHelper(DatabaseConfiguration c0738a, PlatformImplementations.kt_3 aVar, String str, String str2) {
        super(aVar.f4453a);
        this.f4449b = c0738a;
        this.f4450c = aVar;
        this.f4451d = str;
        this.f4452e = str2;
    }

    @Override // androidx.p046f.p047a.SupportSQLiteOpenHelper.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3279a(SupportSQLiteDatabase interfaceC0561b) {
        super.mo3279a(interfaceC0561b);
    }

    @Override // androidx.p046f.p047a.SupportSQLiteOpenHelper.PlatformImplementations.kt_3
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo3281b(SupportSQLiteDatabase interfaceC0561b) throws SQLException {
        boolean zM4662i = m4662i(interfaceC0561b);
        this.f4450c.mo4664b(interfaceC0561b);
        if (!zM4662i) {
            IntrinsicsJvm.kt_4 bVarMo4668f = this.f4450c.mo4668f(interfaceC0561b);
            if (!bVarMo4668f.f4454a) {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + bVarMo4668f.f4455b);
            }
        }
        m4659f(interfaceC0561b);
        this.f4450c.mo4666d(interfaceC0561b);
    }

    @Override // androidx.p046f.p047a.SupportSQLiteOpenHelper.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3280a(SupportSQLiteDatabase interfaceC0561b, int OplusGLSurfaceView_13, int i2) throws SQLException {
        boolean z;
        List<Migration> listM4656a;
        DatabaseConfiguration c0738a = this.f4449b;
        if (c0738a == null || (listM4656a = c0738a.f4336d.m4656a(OplusGLSurfaceView_13, i2)) == null) {
            z = false;
        } else {
            this.f4450c.mo4669g(interfaceC0561b);
            Iterator<Migration> it = listM4656a.iterator();
            while (it.hasNext()) {
                it.next().m4587a(interfaceC0561b);
            }
            IntrinsicsJvm.kt_4 bVarMo4668f = this.f4450c.mo4668f(interfaceC0561b);
            if (!bVarMo4668f.f4454a) {
                throw new IllegalStateException("Migration didn't properly handle: " + bVarMo4668f.f4455b);
            }
            this.f4450c.mo4670h(interfaceC0561b);
            m4659f(interfaceC0561b);
            z = true;
        }
        if (z) {
            return;
        }
        DatabaseConfiguration c0738a2 = this.f4449b;
        if (c0738a2 != null && !c0738a2.m4586a(OplusGLSurfaceView_13, i2)) {
            this.f4450c.mo4663a(interfaceC0561b);
            this.f4450c.mo4664b(interfaceC0561b);
            return;
        }
        throw new IllegalStateException("A migration from " + OplusGLSurfaceView_13 + " to " + i2 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
    }

    @Override // androidx.p046f.p047a.SupportSQLiteOpenHelper.PlatformImplementations.kt_3
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo3282b(SupportSQLiteDatabase interfaceC0561b, int OplusGLSurfaceView_13, int i2) throws SQLException {
        mo3280a(interfaceC0561b, OplusGLSurfaceView_13, i2);
    }

    @Override // androidx.p046f.p047a.SupportSQLiteOpenHelper.PlatformImplementations.kt_3
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo3283c(SupportSQLiteDatabase interfaceC0561b) throws SQLException {
        super.mo3283c(interfaceC0561b);
        m4658e(interfaceC0561b);
        this.f4450c.mo4665c(interfaceC0561b);
        this.f4449b = null;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m4658e(SupportSQLiteDatabase interfaceC0561b) throws SQLException {
        if (m4661h(interfaceC0561b)) {
            Cursor cursorMo3250a = interfaceC0561b.mo3250a(new SimpleSQLiteQuery("SELECT identity_hash FROM room_master_table WHERE id_renamed = 42 LIMIT 1"));
            try {
                String string = cursorMo3250a.moveToFirst() ? cursorMo3250a.getString(0) : null;
                cursorMo3250a.close();
                if (!this.f4451d.equals(string) && !this.f4452e.equals(string)) {
                    throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
                }
                return;
            } catch (Throwable th) {
                cursorMo3250a.close();
                throw th;
            }
        }
        IntrinsicsJvm.kt_4 bVarMo4668f = this.f4450c.mo4668f(interfaceC0561b);
        if (!bVarMo4668f.f4454a) {
            throw new IllegalStateException("Pre-packaged database has an invalid schema: " + bVarMo4668f.f4455b);
        }
        this.f4450c.mo4670h(interfaceC0561b);
        m4659f(interfaceC0561b);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m4659f(SupportSQLiteDatabase interfaceC0561b) throws SQLException {
        m4660g(interfaceC0561b);
        interfaceC0561b.mo3258c(RoomMasterTable.m4657a(this.f4451d));
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m4660g(SupportSQLiteDatabase interfaceC0561b) throws SQLException {
        interfaceC0561b.mo3258c("CREATE TABLE IF NOT EXISTS room_master_table (id_renamed INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private static boolean m4661h(SupportSQLiteDatabase interfaceC0561b) {
        Cursor cursorMo3255b = interfaceC0561b.mo3255b("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
        try {
            boolean z = false;
            if (cursorMo3255b.moveToFirst()) {
                if (cursorMo3255b.getInt(0) != 0) {
                    z = true;
                }
            }
            return z;
        } finally {
            cursorMo3255b.close();
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private static boolean m4662i(SupportSQLiteDatabase interfaceC0561b) {
        Cursor cursorMo3255b = interfaceC0561b.mo3255b("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z = false;
            if (cursorMo3255b.moveToFirst()) {
                if (cursorMo3255b.getInt(0) == 0) {
                    z = true;
                }
            }
            return z;
        } finally {
            cursorMo3255b.close();
        }
    }

    /* compiled from: RoomOpenHelper.java */
    /* renamed from: androidx.room.OplusGLSurfaceView_13$PlatformImplementations.kt_3 */
    public static abstract class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        public final int f4453a;

        /* renamed from: PlatformImplementations.kt_3 */
        protected abstract void mo4663a(SupportSQLiteDatabase interfaceC0561b);

        /* renamed from: IntrinsicsJvm.kt_4 */
        protected abstract void mo4664b(SupportSQLiteDatabase interfaceC0561b);

        /* renamed from: IntrinsicsJvm.kt_3 */
        protected abstract void mo4665c(SupportSQLiteDatabase interfaceC0561b);

        /* renamed from: IntrinsicsJvm.kt_5 */
        protected abstract void mo4666d(SupportSQLiteDatabase interfaceC0561b);

        /* renamed from: COUIBaseListPopupWindow_11 */
        protected void mo4669g(SupportSQLiteDatabase interfaceC0561b) {
        }

        /* renamed from: COUIBaseListPopupWindow_10 */
        protected void mo4670h(SupportSQLiteDatabase interfaceC0561b) {
        }

        public PlatformImplementations.kt_3(int OplusGLSurfaceView_13) {
            this.f4453a = OplusGLSurfaceView_13;
        }

        @Deprecated
        /* renamed from: COUIBaseListPopupWindow_8 */
        protected void m4667e(SupportSQLiteDatabase interfaceC0561b) {
            throw new UnsupportedOperationException("validateMigration is deprecated");
        }

        /* renamed from: COUIBaseListPopupWindow_12 */
        protected IntrinsicsJvm.kt_4 mo4668f(SupportSQLiteDatabase interfaceC0561b) {
            m4667e(interfaceC0561b);
            return new IntrinsicsJvm.kt_4(true, null);
        }
    }

    /* compiled from: RoomOpenHelper.java */
    /* renamed from: androidx.room.OplusGLSurfaceView_13$IntrinsicsJvm.kt_4 */
    public static class IntrinsicsJvm.kt_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        public final boolean f4454a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public final String f4455b;

        public IntrinsicsJvm.kt_4(boolean z, String str) {
            this.f4454a = z;
            this.f4455b = str;
        }
    }
}
