package androidx.room;

/* compiled from: RoomDatabase.java */
/* loaded from: classes.dex */
public abstract class g_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    @java.lang.Deprecated
    protected volatile androidx.f_renamed.a_renamed.b_renamed f1617a;

    /* renamed from: b_renamed, reason: collision with root package name */
    boolean f1618b;

    /* renamed from: c_renamed, reason: collision with root package name */
    @java.lang.Deprecated
    protected java.util.List<androidx.room.g_renamed.b_renamed> f1619c;
    private java.util.concurrent.Executor d_renamed;
    private java.util.concurrent.Executor e_renamed;
    private androidx.f_renamed.a_renamed.c_renamed f_renamed;
    private boolean h_renamed;
    private final java.util.concurrent.locks.ReentrantReadWriteLock i_renamed = new java.util.concurrent.locks.ReentrantReadWriteLock();
    private final java.lang.ThreadLocal<java.lang.Integer> j_renamed = new java.lang.ThreadLocal<>();
    private final java.util.Map<java.lang.String, java.lang.Object> k_renamed = new java.util.concurrent.ConcurrentHashMap();
    private final androidx.room.d_renamed g_renamed = c_renamed();

    /* compiled from: RoomDatabase.java */
    public static abstract class b_renamed {
        public void a_renamed(androidx.f_renamed.a_renamed.b_renamed bVar) {
        }

        public void b_renamed(androidx.f_renamed.a_renamed.b_renamed bVar) {
        }

        public void c_renamed(androidx.f_renamed.a_renamed.b_renamed bVar) {
        }
    }

    protected abstract androidx.f_renamed.a_renamed.c_renamed b_renamed(androidx.room.a_renamed aVar);

    protected abstract androidx.room.d_renamed c_renamed();

    java.util.concurrent.locks.Lock a_renamed() {
        return this.i_renamed.readLock();
    }

    public void a_renamed(androidx.room.a_renamed aVar) {
        this.f_renamed = b_renamed(aVar);
        androidx.f_renamed.a_renamed.c_renamed cVar = this.f_renamed;
        if (cVar instanceof androidx.room.k_renamed) {
            ((androidx.room.k_renamed) cVar).a_renamed(aVar);
        }
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            z_renamed = aVar.g_renamed == androidx.room.g_renamed.c_renamed.WRITE_AHEAD_LOGGING;
            this.f_renamed.a_renamed(z_renamed);
        }
        this.f1619c = aVar.e_renamed;
        this.d_renamed = aVar.h_renamed;
        this.e_renamed = new androidx.room.n_renamed(aVar.i_renamed);
        this.h_renamed = aVar.f_renamed;
        this.f1618b = z_renamed;
        if (aVar.j_renamed) {
            this.g_renamed.a_renamed(aVar.f1576b, aVar.f1577c);
        }
    }

    public androidx.f_renamed.a_renamed.c_renamed b_renamed() {
        return this.f_renamed;
    }

    public boolean d_renamed() {
        androidx.f_renamed.a_renamed.b_renamed bVar = this.f1617a;
        return bVar != null && bVar.e_renamed();
    }

    public void e_renamed() {
        if (!this.h_renamed && l_renamed()) {
            throw new java.lang.IllegalStateException("Cannot access database on_renamed the main thread since it may potentially lock the UI for a_renamed long period of_renamed time.");
        }
    }

    public void f_renamed() {
        if (!k_renamed() && this.j_renamed.get() != null) {
            throw new java.lang.IllegalStateException("Cannot access database on_renamed a_renamed different coroutine context inherited from a_renamed suspending transaction.");
        }
    }

    public android.database.Cursor a_renamed(androidx.f_renamed.a_renamed.e_renamed eVar) {
        return a_renamed(eVar, null);
    }

    public android.database.Cursor a_renamed(androidx.f_renamed.a_renamed.e_renamed eVar, android.os.CancellationSignal cancellationSignal) {
        e_renamed();
        f_renamed();
        if (cancellationSignal != null && android.os.Build.VERSION.SDK_INT >= 16) {
            return this.f_renamed.b_renamed().a_renamed(eVar, cancellationSignal);
        }
        return this.f_renamed.b_renamed().a_renamed(eVar);
    }

    public androidx.f_renamed.a_renamed.f_renamed a_renamed(java.lang.String str) {
        e_renamed();
        f_renamed();
        return this.f_renamed.b_renamed().a_renamed(str);
    }

    @java.lang.Deprecated
    public void g_renamed() {
        e_renamed();
        androidx.f_renamed.a_renamed.b_renamed bVarB = this.f_renamed.b_renamed();
        this.g_renamed.b_renamed(bVarB);
        bVarB.a_renamed();
    }

    @java.lang.Deprecated
    public void h_renamed() {
        this.f_renamed.b_renamed().b_renamed();
        if (k_renamed()) {
            return;
        }
        this.g_renamed.b_renamed();
    }

    public java.util.concurrent.Executor i_renamed() {
        return this.d_renamed;
    }

    @java.lang.Deprecated
    public void j_renamed() {
        this.f_renamed.b_renamed().c_renamed();
    }

    protected void a_renamed(androidx.f_renamed.a_renamed.b_renamed bVar) {
        this.g_renamed.a_renamed(bVar);
    }

    public boolean k_renamed() {
        return this.f_renamed.b_renamed().d_renamed();
    }

    /* compiled from: RoomDatabase.java */
    public enum c_renamed {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        @android.annotation.SuppressLint({"NewApi"})
        androidx.room.g_renamed.c_renamed resolve(android.content.Context context) {
            android.app.ActivityManager activityManager;
            if (this != AUTOMATIC) {
                return this;
            }
            if (android.os.Build.VERSION.SDK_INT >= 16 && (activityManager = (android.app.ActivityManager) context.getSystemService("activity")) != null && !isLowRamDevice(activityManager)) {
                return WRITE_AHEAD_LOGGING;
            }
            return TRUNCATE;
        }

        private static boolean isLowRamDevice(android.app.ActivityManager activityManager) {
            if (android.os.Build.VERSION.SDK_INT >= 19) {
                return activityManager.isLowRamDevice();
            }
            return false;
        }
    }

    /* compiled from: RoomDatabase.java */
    public static class a_renamed<T_renamed extends androidx.room.g_renamed> {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final java.lang.Class<T_renamed> f1620a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private final java.lang.String f1621b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private final android.content.Context f1622c;
        private java.util.ArrayList<androidx.room.g_renamed.b_renamed> d_renamed;
        private java.util.concurrent.Executor e_renamed;
        private java.util.concurrent.Executor f_renamed;
        private androidx.f_renamed.a_renamed.c_renamed.SupportSQLiteOpenHelper_2 g_renamed;
        private boolean h_renamed;
        private boolean j_renamed;
        private boolean l_renamed;
        private java.util.Set<java.lang.Integer> n_renamed;
        private java.util.Set<java.lang.Integer> o_renamed;
        private java.lang.String p_renamed;
        private java.io.File q_renamed;
        private androidx.room.g_renamed.c_renamed i_renamed = androidx.room.g_renamed.c_renamed.AUTOMATIC;
        private boolean k_renamed = true;
        private final androidx.room.g_renamed.d_renamed m_renamed = new androidx.room.g_renamed.d_renamed();

        a_renamed(android.content.Context context, java.lang.Class<T_renamed> cls, java.lang.String str) {
            this.f1622c = context;
            this.f1620a = cls;
            this.f1621b = str;
        }

        public androidx.room.g_renamed.a_renamed<T_renamed> a_renamed() {
            this.h_renamed = true;
            return this;
        }

        @android.annotation.SuppressLint({"RestrictedApi"})
        public T_renamed b_renamed() {
            java.util.concurrent.Executor executor;
            if (this.f1622c == null) {
                throw new java.lang.IllegalArgumentException("Cannot provide null context for the database.");
            }
            if (this.f1620a == null) {
                throw new java.lang.IllegalArgumentException("Must provide an_renamed abstract class that extends RoomDatabase");
            }
            if (this.e_renamed == null && this.f_renamed == null) {
                java.util.concurrent.Executor executorB = androidx.a_renamed.a_renamed.a_renamed.a_renamed.b_renamed();
                this.f_renamed = executorB;
                this.e_renamed = executorB;
            } else {
                java.util.concurrent.Executor executor2 = this.e_renamed;
                if (executor2 != null && this.f_renamed == null) {
                    this.f_renamed = executor2;
                } else if (this.e_renamed == null && (executor = this.f_renamed) != null) {
                    this.e_renamed = executor;
                }
            }
            java.util.Set<java.lang.Integer> set = this.o_renamed;
            if (set != null && this.n_renamed != null) {
                for (java.lang.Integer num : set) {
                    if (this.n_renamed.contains(num)) {
                        throw new java.lang.IllegalArgumentException("Inconsistency detected. A_renamed Migration was supplied to addMigration(Migration... migrations) that has a_renamed start or end version equal to a_renamed start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + num);
                    }
                }
            }
            if (this.g_renamed == null) {
                this.g_renamed = new androidx.f_renamed.a_renamed.a_renamed.c_renamed();
            }
            if (this.p_renamed != null || this.q_renamed != null) {
                if (this.f1621b == null) {
                    throw new java.lang.IllegalArgumentException("Cannot create from asset or file for an_renamed in_renamed-memory database.");
                }
                if (this.p_renamed != null && this.q_renamed != null) {
                    throw new java.lang.IllegalArgumentException("Both createFromAsset() and createFromFile() was called on_renamed this Builder but the database can only be_renamed created using one of_renamed the two configurations.");
                }
                this.g_renamed = new androidx.room.l_renamed(this.p_renamed, this.q_renamed, this.g_renamed);
            }
            android.content.Context context = this.f1622c;
            androidx.room.a_renamed aVar = new androidx.room.a_renamed(context, this.f1621b, this.g_renamed, this.m_renamed, this.d_renamed, this.h_renamed, this.i_renamed.resolve(context), this.e_renamed, this.f_renamed, this.j_renamed, this.k_renamed, this.l_renamed, this.n_renamed, this.p_renamed, this.q_renamed);
            T_renamed t_renamed = (T_renamed) androidx.room.f_renamed.a_renamed(this.f1620a, "_Impl");
            t_renamed.a_renamed(aVar);
            return t_renamed;
        }
    }

    /* compiled from: RoomDatabase.java */
    public static class d_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private java.util.HashMap<java.lang.Integer, java.util.TreeMap<java.lang.Integer, androidx.room.a_renamed.a_renamed>> f1623a = new java.util.HashMap<>();

        public java.util.List<androidx.room.a_renamed.a_renamed> a_renamed(int i_renamed, int i2) {
            if (i_renamed == i2) {
                return java.util.Collections.emptyList();
            }
            return a_renamed(new java.util.ArrayList(), i2 > i_renamed, i_renamed, i2);
        }

        /* JADX WARN: Removed duplicated region for block: B_renamed:19:0x003e  */
        /* JADX WARN: Removed duplicated region for block: B_renamed:31:0x0016 A_renamed[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B_renamed:36:0x0047 A_renamed[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B_renamed:43:? A_renamed[LOOP:1: B_renamed:13:0x0026->B_renamed:43:?, LOOP_END, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B_renamed:9:0x0017  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private java.util.List<androidx.room.a_renamed.a_renamed> a_renamed(java.util.List<androidx.room.a_renamed.a_renamed> r7, boolean r8, int r9, int r10) {
            /*
                r6 = this;
            L0:
                if (r8 == 0) goto L5
                if (r9 >= r10) goto L58
                goto L7
            L5:
                if (r9 <= r10) goto L58
            L7:
                java.util.HashMap<java.lang.Integer, java.util.TreeMap<java.lang.Integer, androidx.room.a_renamed.a_renamed>> r0 = r6.f1623a
                java.lang.Integer r1 = java.lang.Integer.valueOf(r9)
                java.lang.Object r0 = r0.get(r1)
                java.util.TreeMap r0 = (java.util.TreeMap) r0
                r1 = 0
                if (r0 != 0) goto L17
                return r1
            L17:
                if (r8 == 0) goto L1e
                java.util.NavigableSet r2 = r0.descendingKeySet()
                goto L22
            L1e:
                java.util.Set r2 = r0.keySet()
            L22:
                java.util.Iterator r2 = r2.iterator()
            L26:
                boolean r3 = r2.hasNext()
                r4 = 1
                r5 = 0
                if (r3 == 0) goto L54
                java.lang.Object r3 = r2.next()
                java.lang.Integer r3 = (java.lang.Integer) r3
                int r3 = r3.intValue()
                if (r8 == 0) goto L40
                if (r3 > r10) goto L45
                if (r3 <= r9) goto L45
            L3e:
                r5 = r4
                goto L45
            L40:
                if (r3 < r10) goto L45
                if (r3 >= r9) goto L45
                goto L3e
            L45:
                if (r5 == 0) goto L26
                java.lang.Integer r9 = java.lang.Integer.valueOf(r3)
                java.lang.Object r9 = r0.get(r9)
                r7.add(r9)
                r9 = r3
                goto L55
            L54:
                r4 = r5
            L55:
                if (r4 != 0) goto L0
                return r1
            L58:
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.g_renamed.d_renamed.a_renamed(java.util.List, boolean, int, int):java.util.List");
        }
    }

    private static boolean l_renamed() {
        return android.os.Looper.getMainLooper().getThread() == java.lang.Thread.currentThread();
    }
}
