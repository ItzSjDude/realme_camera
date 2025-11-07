package androidx.room;

/* compiled from: InvalidationTracker.java */
/* loaded from: classes.dex */
public class d_renamed {
    private static final java.lang.String[] h_renamed = {"UPDATE", "DELETE", "INSERT"};

    /* renamed from: b_renamed, reason: collision with root package name */
    final java.lang.String[] f1599b;

    /* renamed from: c_renamed, reason: collision with root package name */
    final androidx.room.g_renamed f1600c;
    volatile androidx.f_renamed.a_renamed.f_renamed e_renamed;
    private java.util.Map<java.lang.String, java.util.Set<java.lang.String>> i_renamed;
    private androidx.room.d_renamed.a_renamed k_renamed;
    private final androidx.room.c_renamed l_renamed;
    private androidx.room.e_renamed m_renamed;
    java.util.concurrent.atomic.AtomicBoolean d_renamed = new java.util.concurrent.atomic.AtomicBoolean(false);
    private volatile boolean j_renamed = false;

    @android.annotation.SuppressLint({"RestrictedApi"})
    final androidx.a_renamed.a_renamed.b_renamed.b_renamed<androidx.room.d_renamed.b_renamed, androidx.room.d_renamed.c_renamed> f_renamed = new androidx.a_renamed.a_renamed.b_renamed.b_renamed<>();
    java.lang.Runnable g_renamed = new java.lang.Runnable() { // from class: androidx.room.d_renamed.1
        @Override // java.lang.Runnable
        public void run() {
            java.util.concurrent.locks.Lock lockA = androidx.room.d_renamed.this.f1600c.a_renamed();
            java.util.Set<java.lang.Integer> setA = null;
            try {
                try {
                    lockA.lock();
                } finally {
                    lockA.unlock();
                }
            } catch (android.database.sqlite.SQLiteException | java.lang.IllegalStateException e_renamed) {
                android.util.Log.e_renamed("ROOM", "Cannot run invalidation tracker. Is the db_renamed closed?", e_renamed);
            }
            if (androidx.room.d_renamed.this.a_renamed()) {
                if (androidx.room.d_renamed.this.d_renamed.compareAndSet(true, false)) {
                    if (androidx.room.d_renamed.this.f1600c.k_renamed()) {
                        return;
                    }
                    if (androidx.room.d_renamed.this.f1600c.f1618b) {
                        androidx.f_renamed.a_renamed.b_renamed bVarB = androidx.room.d_renamed.this.f1600c.b_renamed().b_renamed();
                        bVarB.a_renamed();
                        try {
                            setA = a_renamed();
                            bVarB.c_renamed();
                            bVarB.b_renamed();
                        } catch (java.lang.Throwable th) {
                            bVarB.b_renamed();
                            throw th;
                        }
                    } else {
                        setA = a_renamed();
                    }
                    if (setA == null || setA.isEmpty()) {
                        return;
                    }
                    synchronized (androidx.room.d_renamed.this.f_renamed) {
                        java.util.Iterator<java.util.Map.Entry<androidx.room.d_renamed.b_renamed, androidx.room.d_renamed.c_renamed>> it = androidx.room.d_renamed.this.f_renamed.iterator();
                        while (it.hasNext()) {
                            it.next().getValue().a_renamed(setA);
                        }
                    }
                }
            }
        }

        private java.util.Set<java.lang.Integer> a_renamed() {
            java.util.HashSet hashSet = new java.util.HashSet();
            android.database.Cursor cursorA = androidx.room.d_renamed.this.f1600c.a_renamed(new androidx.f_renamed.a_renamed.a_renamed("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"));
            while (cursorA.moveToNext()) {
                try {
                    hashSet.add(java.lang.Integer.valueOf(cursorA.getInt(0)));
                } catch (java.lang.Throwable th) {
                    cursorA.close();
                    throw th;
                }
            }
            cursorA.close();
            if (!hashSet.isEmpty()) {
                androidx.room.d_renamed.this.e_renamed.a_renamed();
            }
            return hashSet;
        }
    };

    /* renamed from: a_renamed, reason: collision with root package name */
    final java.util.HashMap<java.lang.String, java.lang.Integer> f1598a = new java.util.HashMap<>();

    public d_renamed(androidx.room.g_renamed gVar, java.util.Map<java.lang.String, java.lang.String> map, java.util.Map<java.lang.String, java.util.Set<java.lang.String>> map2, java.lang.String... strArr) {
        this.f1600c = gVar;
        this.k_renamed = new androidx.room.d_renamed.a_renamed(strArr.length);
        this.i_renamed = map2;
        this.l_renamed = new androidx.room.c_renamed(this.f1600c);
        int length = strArr.length;
        this.f1599b = new java.lang.String[length];
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            java.lang.String lowerCase = strArr[i_renamed].toLowerCase(java.util.Locale.US);
            this.f1598a.put(lowerCase, java.lang.Integer.valueOf(i_renamed));
            java.lang.String str = map.get(strArr[i_renamed]);
            if (str != null) {
                this.f1599b[i_renamed] = str.toLowerCase(java.util.Locale.US);
            } else {
                this.f1599b[i_renamed] = lowerCase;
            }
        }
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            java.lang.String lowerCase2 = entry.getValue().toLowerCase(java.util.Locale.US);
            if (this.f1598a.containsKey(lowerCase2)) {
                java.lang.String lowerCase3 = entry.getKey().toLowerCase(java.util.Locale.US);
                java.util.HashMap<java.lang.String, java.lang.Integer> map3 = this.f1598a;
                map3.put(lowerCase3, map3.get(lowerCase2));
            }
        }
    }

    void a_renamed(androidx.f_renamed.a_renamed.b_renamed bVar) {
        synchronized (this) {
            if (this.j_renamed) {
                android.util.Log.e_renamed("ROOM", "Invalidation tracker is_renamed initialized twice :/.");
                return;
            }
            bVar.c_renamed("PRAGMA temp_store = MEMORY;");
            bVar.c_renamed("PRAGMA recursive_triggers='ON_renamed';");
            bVar.c_renamed("CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
            b_renamed(bVar);
            this.e_renamed = bVar.a_renamed("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 ");
            this.j_renamed = true;
        }
    }

    void a_renamed(android.content.Context context, java.lang.String str) {
        this.m_renamed = new androidx.room.e_renamed(context, str, this, this.f1600c.i_renamed());
    }

    private static void a_renamed(java.lang.StringBuilder sb, java.lang.String str, java.lang.String str2) {
        sb.append("`");
        sb.append("room_table_modification_trigger_");
        sb.append(str);
        sb.append("_");
        sb.append(str2);
        sb.append("`");
    }

    private void a_renamed(androidx.f_renamed.a_renamed.b_renamed bVar, int i_renamed) throws android.database.SQLException {
        java.lang.String str = this.f1599b[i_renamed];
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.lang.String str2 : h_renamed) {
            sb.setLength(0);
            sb.append("DROP TRIGGER IF EXISTS ");
            a_renamed(sb, str, str2);
            bVar.c_renamed(sb.toString());
        }
    }

    private void b_renamed(androidx.f_renamed.a_renamed.b_renamed bVar, int i_renamed) throws android.database.SQLException {
        bVar.c_renamed("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i_renamed + ", 0)");
        java.lang.String str = this.f1599b[i_renamed];
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.lang.String str2 : h_renamed) {
            sb.setLength(0);
            sb.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            a_renamed(sb, str, str2);
            sb.append(" AFTER ");
            sb.append(str2);
            sb.append(" ON_renamed `");
            sb.append(str);
            sb.append("` BEGIN UPDATE ");
            sb.append("room_table_modification_log");
            sb.append(" SET ");
            sb.append("invalidated");
            sb.append(" = 1");
            sb.append(" WHERE ");
            sb.append("table_id");
            sb.append(" = ");
            sb.append(i_renamed);
            sb.append(" AND ");
            sb.append("invalidated");
            sb.append(" = 0");
            sb.append("; END");
            bVar.c_renamed(sb.toString());
        }
    }

    @android.annotation.SuppressLint({"RestrictedApi"})
    public void a_renamed(androidx.room.d_renamed.b_renamed bVar) {
        androidx.room.d_renamed.c_renamed cVarA;
        java.lang.String[] strArrB = b_renamed(bVar.f1605a);
        int[] iArr = new int[strArrB.length];
        int length = strArrB.length;
        for (int i_renamed = 0; i_renamed < length; i_renamed++) {
            java.lang.Integer num = this.f1598a.get(strArrB[i_renamed].toLowerCase(java.util.Locale.US));
            if (num == null) {
                throw new java.lang.IllegalArgumentException("There is_renamed no table with name " + strArrB[i_renamed]);
            }
            iArr[i_renamed] = num.intValue();
        }
        androidx.room.d_renamed.c_renamed cVar = new androidx.room.d_renamed.c_renamed(bVar, iArr, strArrB);
        synchronized (this.f_renamed) {
            cVarA = this.f_renamed.a_renamed(bVar, cVar);
        }
        if (cVarA == null && this.k_renamed.a_renamed(iArr)) {
            c_renamed();
        }
    }

    private java.lang.String[] b_renamed(java.lang.String[] strArr) {
        java.util.HashSet hashSet = new java.util.HashSet();
        for (java.lang.String str : strArr) {
            java.lang.String lowerCase = str.toLowerCase(java.util.Locale.US);
            if (this.i_renamed.containsKey(lowerCase)) {
                hashSet.addAll(this.i_renamed.get(lowerCase));
            } else {
                hashSet.add(str);
            }
        }
        return (java.lang.String[]) hashSet.toArray(new java.lang.String[hashSet.size()]);
    }

    @android.annotation.SuppressLint({"RestrictedApi"})
    public void b_renamed(androidx.room.d_renamed.b_renamed bVar) {
        androidx.room.d_renamed.c_renamed cVarB;
        synchronized (this.f_renamed) {
            cVarB = this.f_renamed.b_renamed(bVar);
        }
        if (cVarB == null || !this.k_renamed.b_renamed(cVarB.f1606a)) {
            return;
        }
        c_renamed();
    }

    boolean a_renamed() {
        if (!this.f1600c.d_renamed()) {
            return false;
        }
        if (!this.j_renamed) {
            this.f1600c.b_renamed().b_renamed();
        }
        if (this.j_renamed) {
            return true;
        }
        android.util.Log.e_renamed("ROOM", "database is_renamed not initialized even though it is_renamed open");
        return false;
    }

    public void b_renamed() {
        if (this.d_renamed.compareAndSet(false, true)) {
            this.f1600c.i_renamed().execute(this.g_renamed);
        }
    }

    public void a_renamed(java.lang.String... strArr) {
        synchronized (this.f_renamed) {
            java.util.Iterator<java.util.Map.Entry<androidx.room.d_renamed.b_renamed, androidx.room.d_renamed.c_renamed>> it = this.f_renamed.iterator();
            while (it.hasNext()) {
                java.util.Map.Entry<androidx.room.d_renamed.b_renamed, androidx.room.d_renamed.c_renamed> next = it.next();
                if (!next.getKey().a_renamed()) {
                    next.getValue().a_renamed(strArr);
                }
            }
        }
    }

    void b_renamed(androidx.f_renamed.a_renamed.b_renamed bVar) {
        if (bVar.d_renamed()) {
            return;
        }
        while (true) {
            try {
                java.util.concurrent.locks.Lock lockA = this.f1600c.a_renamed();
                lockA.lock();
                try {
                    int[] iArrA = this.k_renamed.a_renamed();
                    if (iArrA == null) {
                        return;
                    }
                    int length = iArrA.length;
                    bVar.a_renamed();
                    for (int i_renamed = 0; i_renamed < length; i_renamed++) {
                        try {
                            int i2 = iArrA[i_renamed];
                            if (i2 == 1) {
                                b_renamed(bVar, i_renamed);
                            } else if (i2 == 2) {
                                a_renamed(bVar, i_renamed);
                            }
                        } finally {
                        }
                    }
                    bVar.c_renamed();
                    bVar.b_renamed();
                    this.k_renamed.b_renamed();
                } finally {
                    lockA.unlock();
                }
            } catch (android.database.sqlite.SQLiteException | java.lang.IllegalStateException e_renamed) {
                android.util.Log.e_renamed("ROOM", "Cannot run invalidation tracker. Is the db_renamed closed?", e_renamed);
                return;
            }
        }
    }

    void c_renamed() {
        if (this.f1600c.d_renamed()) {
            b_renamed(this.f1600c.b_renamed().b_renamed());
        }
    }

    /* compiled from: InvalidationTracker.java */
    static class c_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        final int[] f1606a;

        /* renamed from: b_renamed, reason: collision with root package name */
        final androidx.room.d_renamed.b_renamed f1607b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private final java.lang.String[] f1608c;
        private final java.util.Set<java.lang.String> d_renamed;

        c_renamed(androidx.room.d_renamed.b_renamed bVar, int[] iArr, java.lang.String[] strArr) {
            this.f1607b = bVar;
            this.f1606a = iArr;
            this.f1608c = strArr;
            if (iArr.length == 1) {
                java.util.HashSet hashSet = new java.util.HashSet();
                hashSet.add(this.f1608c[0]);
                this.d_renamed = java.util.Collections.unmodifiableSet(hashSet);
                return;
            }
            this.d_renamed = null;
        }

        void a_renamed(java.util.Set<java.lang.Integer> set) {
            int length = this.f1606a.length;
            java.util.Set<java.lang.String> hashSet = null;
            for (int i_renamed = 0; i_renamed < length; i_renamed++) {
                if (set.contains(java.lang.Integer.valueOf(this.f1606a[i_renamed]))) {
                    if (length == 1) {
                        hashSet = this.d_renamed;
                    } else {
                        if (hashSet == null) {
                            hashSet = new java.util.HashSet<>(length);
                        }
                        hashSet.add(this.f1608c[i_renamed]);
                    }
                }
            }
            if (hashSet != null) {
                this.f1607b.a_renamed(hashSet);
            }
        }

        void a_renamed(java.lang.String[] strArr) {
            java.util.Set<java.lang.String> set = null;
            if (this.f1608c.length == 1) {
                int length = strArr.length;
                int i_renamed = 0;
                while (true) {
                    if (i_renamed >= length) {
                        break;
                    }
                    if (strArr[i_renamed].equalsIgnoreCase(this.f1608c[0])) {
                        set = this.d_renamed;
                        break;
                    }
                    i_renamed++;
                }
            } else {
                java.util.HashSet hashSet = new java.util.HashSet();
                for (java.lang.String str : strArr) {
                    java.lang.String[] strArr2 = this.f1608c;
                    int length2 = strArr2.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 < length2) {
                            java.lang.String str2 = strArr2[i2];
                            if (str2.equalsIgnoreCase(str)) {
                                hashSet.add(str2);
                                break;
                            }
                            i2++;
                        }
                    }
                }
                if (hashSet.size() > 0) {
                    set = hashSet;
                }
            }
            if (set != null) {
                this.f1607b.a_renamed(set);
            }
        }
    }

    /* compiled from: InvalidationTracker.java */
    public static abstract class b_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        final java.lang.String[] f1605a;

        public abstract void a_renamed(java.util.Set<java.lang.String> set);

        boolean a_renamed() {
            return false;
        }

        public b_renamed(java.lang.String[] strArr) {
            this.f1605a = (java.lang.String[]) java.util.Arrays.copyOf(strArr, strArr.length);
        }
    }

    /* compiled from: InvalidationTracker.java */
    static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        final long[] f1602a;

        /* renamed from: b_renamed, reason: collision with root package name */
        final boolean[] f1603b;

        /* renamed from: c_renamed, reason: collision with root package name */
        final int[] f1604c;
        boolean d_renamed;
        boolean e_renamed;

        a_renamed(int i_renamed) {
            this.f1602a = new long[i_renamed];
            this.f1603b = new boolean[i_renamed];
            this.f1604c = new int[i_renamed];
            java.util.Arrays.fill(this.f1602a, 0L);
            java.util.Arrays.fill(this.f1603b, false);
        }

        boolean a_renamed(int... iArr) {
            boolean z_renamed;
            synchronized (this) {
                z_renamed = false;
                for (int i_renamed : iArr) {
                    long j_renamed = this.f1602a[i_renamed];
                    this.f1602a[i_renamed] = 1 + j_renamed;
                    if (j_renamed == 0) {
                        this.d_renamed = true;
                        z_renamed = true;
                    }
                }
            }
            return z_renamed;
        }

        boolean b_renamed(int... iArr) {
            boolean z_renamed;
            synchronized (this) {
                z_renamed = false;
                for (int i_renamed : iArr) {
                    long j_renamed = this.f1602a[i_renamed];
                    this.f1602a[i_renamed] = j_renamed - 1;
                    if (j_renamed == 1) {
                        this.d_renamed = true;
                        z_renamed = true;
                    }
                }
            }
            return z_renamed;
        }

        int[] a_renamed() {
            synchronized (this) {
                if (this.d_renamed && !this.e_renamed) {
                    int length = this.f1602a.length;
                    int i_renamed = 0;
                    while (true) {
                        int i2 = 1;
                        if (i_renamed < length) {
                            boolean z_renamed = this.f1602a[i_renamed] > 0;
                            if (z_renamed != this.f1603b[i_renamed]) {
                                int[] iArr = this.f1604c;
                                if (!z_renamed) {
                                    i2 = 2;
                                }
                                iArr[i_renamed] = i2;
                            } else {
                                this.f1604c[i_renamed] = 0;
                            }
                            this.f1603b[i_renamed] = z_renamed;
                            i_renamed++;
                        } else {
                            this.e_renamed = true;
                            this.d_renamed = false;
                            return this.f1604c;
                        }
                    }
                }
                return null;
            }
        }

        void b_renamed() {
            synchronized (this) {
                this.e_renamed = false;
            }
        }
    }
}
