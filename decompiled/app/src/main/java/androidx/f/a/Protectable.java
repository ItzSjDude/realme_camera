package androidx.f_renamed.a_renamed;

/* compiled from: SupportSQLiteOpenHelper.java */
/* loaded from: classes.dex */
public interface c_renamed {

    /* compiled from: SupportSQLiteOpenHelper.java */
    /* renamed from: androidx.f_renamed.a_renamed.c_renamed$c_renamed, reason: collision with other inner class name */
    public interface SupportSQLiteOpenHelper_2 {
        androidx.f_renamed.a_renamed.c_renamed a_renamed(androidx.f_renamed.a_renamed.c_renamed.b_renamed bVar);
    }

    java.lang.String a_renamed();

    void a_renamed(boolean z_renamed);

    androidx.f_renamed.a_renamed.b_renamed b_renamed();

    /* compiled from: SupportSQLiteOpenHelper.java */
    public static abstract class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public final int f1110a;

        public void a_renamed(androidx.f_renamed.a_renamed.b_renamed bVar) {
        }

        public abstract void a_renamed(androidx.f_renamed.a_renamed.b_renamed bVar, int i_renamed, int i2);

        public abstract void b_renamed(androidx.f_renamed.a_renamed.b_renamed bVar);

        public void c_renamed(androidx.f_renamed.a_renamed.b_renamed bVar) {
        }

        public a_renamed(int i_renamed) {
            this.f1110a = i_renamed;
        }

        public void b_renamed(androidx.f_renamed.a_renamed.b_renamed bVar, int i_renamed, int i2) {
            throw new android.database.sqlite.SQLiteException("Can't_renamed downgrade database from version " + i_renamed + " to " + i2);
        }

        public void d_renamed(androidx.f_renamed.a_renamed.b_renamed bVar) {
            android.util.Log.e_renamed("SupportSQLite", "Corruption reported by_renamed sqlite on_renamed database: " + bVar.f_renamed());
            if (!bVar.e_renamed()) {
                a_renamed(bVar.f_renamed());
                return;
            }
            java.util.List<android.util.Pair<java.lang.String, java.lang.String>> listG = null;
            try {
                try {
                    listG = bVar.g_renamed();
                } catch (android.database.sqlite.SQLiteException unused) {
                }
                try {
                    bVar.close();
                } catch (java.io.IOException unused2) {
                }
            } finally {
                if (listG != null) {
                    java.util.Iterator<android.util.Pair<java.lang.String, java.lang.String>> it = listG.iterator();
                    while (it.hasNext()) {
                        a_renamed((java.lang.String) it.next().second);
                    }
                } else {
                    a_renamed(bVar.f_renamed());
                }
            }
        }

        private void a_renamed(java.lang.String str) {
            if (str.equalsIgnoreCase(":memory:") || str.trim().length() == 0) {
                return;
            }
            android.util.Log.w_renamed("SupportSQLite", "deleting the database file: " + str);
            try {
                if (android.os.Build.VERSION.SDK_INT >= 16) {
                    android.database.sqlite.SQLiteDatabase.deleteDatabase(new java.io.File(str));
                } else {
                    try {
                        if (!new java.io.File(str).delete()) {
                            android.util.Log.e_renamed("SupportSQLite", "Could not delete the database file " + str);
                        }
                    } catch (java.lang.Exception e_renamed) {
                        android.util.Log.e_renamed("SupportSQLite", "error while deleting corrupted database file", e_renamed);
                    }
                }
            } catch (java.lang.Exception e2) {
                android.util.Log.w_renamed("SupportSQLite", "delete failed: ", e2);
            }
        }
    }

    /* compiled from: SupportSQLiteOpenHelper.java */
    public static class b_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public final android.content.Context f1111a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public final java.lang.String f1112b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public final androidx.f_renamed.a_renamed.c_renamed.a_renamed f1113c;

        b_renamed(android.content.Context context, java.lang.String str, androidx.f_renamed.a_renamed.c_renamed.a_renamed aVar) {
            this.f1111a = context;
            this.f1112b = str;
            this.f1113c = aVar;
        }

        public static androidx.f_renamed.a_renamed.c_renamed.b_renamed.a_renamed a_renamed(android.content.Context context) {
            return new androidx.f_renamed.a_renamed.c_renamed.b_renamed.a_renamed(context);
        }

        /* compiled from: SupportSQLiteOpenHelper.java */
        public static class a_renamed {

            /* renamed from: a_renamed, reason: collision with root package name */
            android.content.Context f1114a;

            /* renamed from: b_renamed, reason: collision with root package name */
            java.lang.String f1115b;

            /* renamed from: c_renamed, reason: collision with root package name */
            androidx.f_renamed.a_renamed.c_renamed.a_renamed f1116c;

            public androidx.f_renamed.a_renamed.c_renamed.b_renamed a_renamed() {
                androidx.f_renamed.a_renamed.c_renamed.a_renamed aVar = this.f1116c;
                if (aVar == null) {
                    throw new java.lang.IllegalArgumentException("Must set a_renamed callback to create the configuration.");
                }
                android.content.Context context = this.f1114a;
                if (context == null) {
                    throw new java.lang.IllegalArgumentException("Must set a_renamed non-null context to create the configuration.");
                }
                return new androidx.f_renamed.a_renamed.c_renamed.b_renamed(context, this.f1115b, aVar);
            }

            a_renamed(android.content.Context context) {
                this.f1114a = context;
            }

            public androidx.f_renamed.a_renamed.c_renamed.b_renamed.a_renamed a_renamed(java.lang.String str) {
                this.f1115b = str;
                return this;
            }

            public androidx.f_renamed.a_renamed.c_renamed.b_renamed.a_renamed a_renamed(androidx.f_renamed.a_renamed.c_renamed.a_renamed aVar) {
                this.f1116c = aVar;
                return this;
            }
        }
    }
}
