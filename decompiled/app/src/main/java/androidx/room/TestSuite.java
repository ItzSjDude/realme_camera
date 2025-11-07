package androidx.room;

/* compiled from: RoomOpenHelper.java */
/* loaded from: classes.dex */
public class i_renamed extends androidx.f_renamed.a_renamed.c_renamed.a_renamed {

    /* renamed from: b_renamed, reason: collision with root package name */
    private androidx.room.a_renamed f1624b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final androidx.room.i_renamed.a_renamed f1625c;
    private final java.lang.String d_renamed;
    private final java.lang.String e_renamed;

    public i_renamed(androidx.room.a_renamed aVar, androidx.room.i_renamed.a_renamed aVar2, java.lang.String str, java.lang.String str2) {
        super(aVar2.f1626a);
        this.f1624b = aVar;
        this.f1625c = aVar2;
        this.d_renamed = str;
        this.e_renamed = str2;
    }

    @Override // androidx.f_renamed.a_renamed.c_renamed.a_renamed
    public void a_renamed(androidx.f_renamed.a_renamed.b_renamed bVar) {
        super.a_renamed(bVar);
    }

    @Override // androidx.f_renamed.a_renamed.c_renamed.a_renamed
    public void b_renamed(androidx.f_renamed.a_renamed.b_renamed bVar) throws android.database.SQLException {
        boolean zI = i_renamed(bVar);
        this.f1625c.b_renamed(bVar);
        if (!zI) {
            androidx.room.i_renamed.b_renamed bVarF = this.f1625c.f_renamed(bVar);
            if (!bVarF.f1627a) {
                throw new java.lang.IllegalStateException("Pre-packaged database has an_renamed invalid schema: " + bVarF.f1628b);
            }
        }
        f_renamed(bVar);
        this.f1625c.d_renamed(bVar);
    }

    @Override // androidx.f_renamed.a_renamed.c_renamed.a_renamed
    public void a_renamed(androidx.f_renamed.a_renamed.b_renamed bVar, int i_renamed, int i2) throws android.database.SQLException {
        boolean z_renamed;
        java.util.List<androidx.room.a_renamed.a_renamed> listA;
        androidx.room.a_renamed aVar = this.f1624b;
        if (aVar == null || (listA = aVar.d_renamed.a_renamed(i_renamed, i2)) == null) {
            z_renamed = false;
        } else {
            this.f1625c.g_renamed(bVar);
            java.util.Iterator<androidx.room.a_renamed.a_renamed> it = listA.iterator();
            while (it.hasNext()) {
                it.next().a_renamed(bVar);
            }
            androidx.room.i_renamed.b_renamed bVarF = this.f1625c.f_renamed(bVar);
            if (!bVarF.f1627a) {
                throw new java.lang.IllegalStateException("Migration didn't_renamed properly handle: " + bVarF.f1628b);
            }
            this.f1625c.h_renamed(bVar);
            f_renamed(bVar);
            z_renamed = true;
        }
        if (z_renamed) {
            return;
        }
        androidx.room.a_renamed aVar2 = this.f1624b;
        if (aVar2 != null && !aVar2.a_renamed(i_renamed, i2)) {
            this.f1625c.a_renamed(bVar);
            this.f1625c.b_renamed(bVar);
            return;
        }
        throw new java.lang.IllegalStateException("A_renamed migration from " + i_renamed + " to " + i2 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of_renamed the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
    }

    @Override // androidx.f_renamed.a_renamed.c_renamed.a_renamed
    public void b_renamed(androidx.f_renamed.a_renamed.b_renamed bVar, int i_renamed, int i2) throws android.database.SQLException {
        a_renamed(bVar, i_renamed, i2);
    }

    @Override // androidx.f_renamed.a_renamed.c_renamed.a_renamed
    public void c_renamed(androidx.f_renamed.a_renamed.b_renamed bVar) throws android.database.SQLException {
        super.c_renamed(bVar);
        e_renamed(bVar);
        this.f1625c.c_renamed(bVar);
        this.f1624b = null;
    }

    private void e_renamed(androidx.f_renamed.a_renamed.b_renamed bVar) throws android.database.SQLException {
        if (h_renamed(bVar)) {
            android.database.Cursor cursorA = bVar.a_renamed(new androidx.f_renamed.a_renamed.a_renamed("SELECT identity_hash FROM room_master_table WHERE id_renamed = 42 LIMIT 1"));
            try {
                java.lang.String string = cursorA.moveToFirst() ? cursorA.getString(0) : null;
                cursorA.close();
                if (!this.d_renamed.equals(string) && !this.e_renamed.equals(string)) {
                    throw new java.lang.IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by_renamed increasing the version number.");
                }
                return;
            } catch (java.lang.Throwable th) {
                cursorA.close();
                throw th;
            }
        }
        androidx.room.i_renamed.b_renamed bVarF = this.f1625c.f_renamed(bVar);
        if (!bVarF.f1627a) {
            throw new java.lang.IllegalStateException("Pre-packaged database has an_renamed invalid schema: " + bVarF.f1628b);
        }
        this.f1625c.h_renamed(bVar);
        f_renamed(bVar);
    }

    private void f_renamed(androidx.f_renamed.a_renamed.b_renamed bVar) throws android.database.SQLException {
        g_renamed(bVar);
        bVar.c_renamed(androidx.room.h_renamed.a_renamed(this.d_renamed));
    }

    private void g_renamed(androidx.f_renamed.a_renamed.b_renamed bVar) throws android.database.SQLException {
        bVar.c_renamed("CREATE TABLE IF NOT EXISTS room_master_table (id_renamed INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    private static boolean h_renamed(androidx.f_renamed.a_renamed.b_renamed bVar) {
        android.database.Cursor cursorB = bVar.b_renamed("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
        try {
            boolean z_renamed = false;
            if (cursorB.moveToFirst()) {
                if (cursorB.getInt(0) != 0) {
                    z_renamed = true;
                }
            }
            return z_renamed;
        } finally {
            cursorB.close();
        }
    }

    private static boolean i_renamed(androidx.f_renamed.a_renamed.b_renamed bVar) {
        android.database.Cursor cursorB = bVar.b_renamed("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z_renamed = false;
            if (cursorB.moveToFirst()) {
                if (cursorB.getInt(0) == 0) {
                    z_renamed = true;
                }
            }
            return z_renamed;
        } finally {
            cursorB.close();
        }
    }

    /* compiled from: RoomOpenHelper.java */
    public static abstract class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public final int f1626a;

        protected abstract void a_renamed(androidx.f_renamed.a_renamed.b_renamed bVar);

        protected abstract void b_renamed(androidx.f_renamed.a_renamed.b_renamed bVar);

        protected abstract void c_renamed(androidx.f_renamed.a_renamed.b_renamed bVar);

        protected abstract void d_renamed(androidx.f_renamed.a_renamed.b_renamed bVar);

        protected void g_renamed(androidx.f_renamed.a_renamed.b_renamed bVar) {
        }

        protected void h_renamed(androidx.f_renamed.a_renamed.b_renamed bVar) {
        }

        public a_renamed(int i_renamed) {
            this.f1626a = i_renamed;
        }

        @java.lang.Deprecated
        protected void e_renamed(androidx.f_renamed.a_renamed.b_renamed bVar) {
            throw new java.lang.UnsupportedOperationException("validateMigration is_renamed deprecated");
        }

        protected androidx.room.i_renamed.b_renamed f_renamed(androidx.f_renamed.a_renamed.b_renamed bVar) {
            e_renamed(bVar);
            return new androidx.room.i_renamed.b_renamed(true, null);
        }
    }

    /* compiled from: RoomOpenHelper.java */
    public static class b_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public final boolean f1627a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public final java.lang.String f1628b;

        public b_renamed(boolean z_renamed, java.lang.String str) {
            this.f1627a = z_renamed;
            this.f1628b = str;
        }
    }
}
