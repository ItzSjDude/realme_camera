package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.p012a.p013a.p015b.SafeIterableMap;
import androidx.p046f.p047a.SimpleSQLiteQuery;
import androidx.p046f.p047a.SupportSQLiteDatabase;
import androidx.p046f.p047a.SupportSQLiteStatement;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;

/* compiled from: InvalidationTracker.java */
/* renamed from: androidx.room.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
public class InvalidationTracker {

    /* renamed from: COUIBaseListPopupWindow_10 */
    private static final String[] f4378h = {"UPDATE", "DELETE", "INSERT"};

    /* renamed from: IntrinsicsJvm.kt_4 */
    final String[] f4380b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    final RoomDatabase f4381c;

    /* renamed from: COUIBaseListPopupWindow_8 */
    volatile SupportSQLiteStatement f4383e;

    /* renamed from: OplusGLSurfaceView_13 */
    private Map<String, Set<String>> f4386i;

    /* renamed from: OplusGLSurfaceView_5 */
    private PlatformImplementations.kt_3 f4388k;

    /* renamed from: OplusGLSurfaceView_14 */
    private final InvalidationLiveDataContainer f4389l;

    /* renamed from: OplusGLSurfaceView_6 */
    private MultiInstanceInvalidationClient f4390m;

    /* renamed from: IntrinsicsJvm.kt_5 */
    AtomicBoolean f4382d = new AtomicBoolean(false);

    /* renamed from: OplusGLSurfaceView_15 */
    private volatile boolean f4387j = false;

    /* renamed from: COUIBaseListPopupWindow_12 */
    @SuppressLint({"RestrictedApi"})
    final SafeIterableMap<IntrinsicsJvm.kt_4, IntrinsicsJvm.kt_3> f4384f = new SafeIterableMap<>();

    /* renamed from: COUIBaseListPopupWindow_11 */
    Runnable f4385g = new Runnable() { // from class: androidx.room.IntrinsicsJvm.kt_5.1
        @Override // java.lang.Runnable
        public void run() {
            Lock lockM4636a = InvalidationTracker.this.f4381c.m4636a();
            Set<Integer> setM4621a = null;
            try {
                try {
                    lockM4636a.lock();
                } finally {
                    lockM4636a.unlock();
                }
            } catch (SQLiteException | IllegalStateException COUIBaseListPopupWindow_8) {
                Log.COUIBaseListPopupWindow_8("ROOM", "Cannot run invalidation tracker. Is the db closed?", COUIBaseListPopupWindow_8);
            }
            if (InvalidationTracker.this.m4616a()) {
                if (InvalidationTracker.this.f4382d.compareAndSet(true, false)) {
                    if (InvalidationTracker.this.f4381c.m4649k()) {
                        return;
                    }
                    if (InvalidationTracker.this.f4381c.f4421b) {
                        SupportSQLiteDatabase interfaceC0561bMo3266b = InvalidationTracker.this.f4381c.m4639b().mo3266b();
                        interfaceC0561bMo3266b.mo3253a();
                        try {
                            setM4621a = m4621a();
                            interfaceC0561bMo3266b.mo3257c();
                            interfaceC0561bMo3266b.mo3256b();
                        } catch (Throwable th) {
                            interfaceC0561bMo3266b.mo3256b();
                            throw th;
                        }
                    } else {
                        setM4621a = m4621a();
                    }
                    if (setM4621a == null || setM4621a.isEmpty()) {
                        return;
                    }
                    synchronized (InvalidationTracker.this.f4384f) {
                        Iterator<Map.Entry<IntrinsicsJvm.kt_4, IntrinsicsJvm.kt_3>> it = InvalidationTracker.this.f4384f.iterator();
                        while (it.hasNext()) {
                            it.next().getValue().m4628a(setM4621a);
                        }
                    }
                }
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private Set<Integer> m4621a() {
            HashSet hashSet = new HashSet();
            Cursor cursorM4633a = InvalidationTracker.this.f4381c.m4633a(new SimpleSQLiteQuery("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"));
            while (cursorM4633a.moveToNext()) {
                try {
                    hashSet.add(Integer.valueOf(cursorM4633a.getInt(0)));
                } catch (Throwable th) {
                    cursorM4633a.close();
                    throw th;
                }
            }
            cursorM4633a.close();
            if (!hashSet.isEmpty()) {
                InvalidationTracker.this.f4383e.mo3276a();
            }
            return hashSet;
        }
    };

    /* renamed from: PlatformImplementations.kt_3 */
    final HashMap<String, Integer> f4379a = new HashMap<>();

    public InvalidationTracker(RoomDatabase abstractC0750g, Map<String, String> map, Map<String, Set<String>> map2, String... strArr) {
        this.f4381c = abstractC0750g;
        this.f4388k = new PlatformImplementations.kt_3(strArr.length);
        this.f4386i = map2;
        this.f4389l = new InvalidationLiveDataContainer(this.f4381c);
        int length = strArr.length;
        this.f4380b = new String[length];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
            String lowerCase = strArr[OplusGLSurfaceView_13].toLowerCase(Locale.US);
            this.f4379a.put(lowerCase, Integer.valueOf(OplusGLSurfaceView_13));
            String str = map.get(strArr[OplusGLSurfaceView_13]);
            if (str != null) {
                this.f4380b[OplusGLSurfaceView_13] = str.toLowerCase(Locale.US);
            } else {
                this.f4380b[OplusGLSurfaceView_13] = lowerCase;
            }
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String lowerCase2 = entry.getValue().toLowerCase(Locale.US);
            if (this.f4379a.containsKey(lowerCase2)) {
                String lowerCase3 = entry.getKey().toLowerCase(Locale.US);
                HashMap<String, Integer> map3 = this.f4379a;
                map3.put(lowerCase3, map3.get(lowerCase2));
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m4613a(SupportSQLiteDatabase interfaceC0561b) {
        synchronized (this) {
            if (this.f4387j) {
                Log.COUIBaseListPopupWindow_8("ROOM", "Invalidation tracker is initialized twice :/.");
                return;
            }
            interfaceC0561b.mo3258c("PRAGMA temp_store = MEMORY;");
            interfaceC0561b.mo3258c("PRAGMA recursive_triggers='ON';");
            interfaceC0561b.mo3258c("CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
            m4618b(interfaceC0561b);
            this.f4383e = interfaceC0561b.mo3252a("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 ");
            this.f4387j = true;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m4612a(Context context, String str) {
        this.f4390m = new MultiInstanceInvalidationClient(context, str, this, this.f4381c.m4647i());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m4609a(StringBuilder sb, String str, String str2) {
        sb.append("`");
        sb.append("room_table_modification_trigger_");
        sb.append(str);
        sb.append("_");
        sb.append(str2);
        sb.append("`");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m4608a(SupportSQLiteDatabase interfaceC0561b, int OplusGLSurfaceView_13) throws SQLException {
        String str = this.f4380b[OplusGLSurfaceView_13];
        StringBuilder sb = new StringBuilder();
        for (String str2 : f4378h) {
            sb.setLength(0);
            sb.append("DROP TRIGGER IF EXISTS ");
            m4609a(sb, str, str2);
            interfaceC0561b.mo3258c(sb.toString());
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m4610b(SupportSQLiteDatabase interfaceC0561b, int OplusGLSurfaceView_13) throws SQLException {
        interfaceC0561b.mo3258c("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + OplusGLSurfaceView_13 + ", 0)");
        String str = this.f4380b[OplusGLSurfaceView_13];
        StringBuilder sb = new StringBuilder();
        for (String str2 : f4378h) {
            sb.setLength(0);
            sb.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            m4609a(sb, str, str2);
            sb.append(" AFTER ");
            sb.append(str2);
            sb.append(" ON `");
            sb.append(str);
            sb.append("` BEGIN UPDATE ");
            sb.append("room_table_modification_log");
            sb.append(" SET ");
            sb.append("invalidated");
            sb.append(" = 1");
            sb.append(" WHERE ");
            sb.append("table_id");
            sb.append(" = ");
            sb.append(OplusGLSurfaceView_13);
            sb.append(" AND ");
            sb.append("invalidated");
            sb.append(" = 0");
            sb.append("; END");
            interfaceC0561b.mo3258c(sb.toString());
        }
    }

    @SuppressLint({"RestrictedApi"})
    /* renamed from: PlatformImplementations.kt_3 */
    public void m4614a(IntrinsicsJvm.kt_4 bVar) {
        IntrinsicsJvm.kt_3 cVarMo698a;
        String[] strArrM4611b = m4611b(bVar.f4397a);
        int[] iArr = new int[strArrM4611b.length];
        int length = strArrM4611b.length;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
            Integer num = this.f4379a.get(strArrM4611b[OplusGLSurfaceView_13].toLowerCase(Locale.US));
            if (num == null) {
                throw new IllegalArgumentException("There is no table with name " + strArrM4611b[OplusGLSurfaceView_13]);
            }
            iArr[OplusGLSurfaceView_13] = num.intValue();
        }
        IntrinsicsJvm.kt_3 cVar = new IntrinsicsJvm.kt_3(bVar, iArr, strArrM4611b);
        synchronized (this.f4384f) {
            cVarMo698a = this.f4384f.mo698a(bVar, cVar);
        }
        if (cVarMo698a == null && this.f4388k.m4622a(iArr)) {
            m4620c();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private String[] m4611b(String[] strArr) {
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (this.f4386i.containsKey(lowerCase)) {
                hashSet.addAll(this.f4386i.get(lowerCase));
            } else {
                hashSet.add(str);
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    @SuppressLint({"RestrictedApi"})
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m4619b(IntrinsicsJvm.kt_4 bVar) {
        IntrinsicsJvm.kt_3 cVarMo699b;
        synchronized (this.f4384f) {
            cVarMo699b = this.f4384f.mo699b(bVar);
        }
        if (cVarMo699b == null || !this.f4388k.m4625b(cVarMo699b.f4398a)) {
            return;
        }
        m4620c();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    boolean m4616a() {
        if (!this.f4381c.m4642d()) {
            return false;
        }
        if (!this.f4387j) {
            this.f4381c.m4639b().mo3266b();
        }
        if (this.f4387j) {
            return true;
        }
        Log.COUIBaseListPopupWindow_8("ROOM", "database is not initialized even though it is open");
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m4617b() {
        if (this.f4382d.compareAndSet(false, true)) {
            this.f4381c.m4647i().execute(this.f4385g);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m4615a(String... strArr) {
        synchronized (this.f4384f) {
            Iterator<Map.Entry<IntrinsicsJvm.kt_4, IntrinsicsJvm.kt_3>> it = this.f4384f.iterator();
            while (it.hasNext()) {
                Map.Entry<IntrinsicsJvm.kt_4, IntrinsicsJvm.kt_3> next = it.next();
                if (!next.getKey().mo4627a()) {
                    next.getValue().m4629a(strArr);
                }
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m4618b(SupportSQLiteDatabase interfaceC0561b) {
        if (interfaceC0561b.mo3259d()) {
            return;
        }
        while (true) {
            try {
                Lock lockM4636a = this.f4381c.m4636a();
                lockM4636a.lock();
                try {
                    int[] iArrM4623a = this.f4388k.m4623a();
                    if (iArrM4623a == null) {
                        return;
                    }
                    int length = iArrM4623a.length;
                    interfaceC0561b.mo3253a();
                    for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
                        try {
                            int i2 = iArrM4623a[OplusGLSurfaceView_13];
                            if (i2 == 1) {
                                m4610b(interfaceC0561b, OplusGLSurfaceView_13);
                            } else if (i2 == 2) {
                                m4608a(interfaceC0561b, OplusGLSurfaceView_13);
                            }
                        } finally {
                        }
                    }
                    interfaceC0561b.mo3257c();
                    interfaceC0561b.mo3256b();
                    this.f4388k.m4624b();
                } finally {
                    lockM4636a.unlock();
                }
            } catch (SQLiteException | IllegalStateException COUIBaseListPopupWindow_8) {
                Log.COUIBaseListPopupWindow_8("ROOM", "Cannot run invalidation tracker. Is the db closed?", COUIBaseListPopupWindow_8);
                return;
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    void m4620c() {
        if (this.f4381c.m4642d()) {
            m4618b(this.f4381c.m4639b().mo3266b());
        }
    }

    /* compiled from: InvalidationTracker.java */
    /* renamed from: androidx.room.IntrinsicsJvm.kt_5$IntrinsicsJvm.kt_3 */
    static class IntrinsicsJvm.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        final int[] f4398a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        final IntrinsicsJvm.kt_4 f4399b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final String[] f4400c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private final Set<String> f4401d;

        IntrinsicsJvm.kt_3(IntrinsicsJvm.kt_4 bVar, int[] iArr, String[] strArr) {
            this.f4399b = bVar;
            this.f4398a = iArr;
            this.f4400c = strArr;
            if (iArr.length == 1) {
                HashSet hashSet = new HashSet();
                hashSet.add(this.f4400c[0]);
                this.f4401d = Collections.unmodifiableSet(hashSet);
                return;
            }
            this.f4401d = null;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m4628a(Set<Integer> set) {
            int length = this.f4398a.length;
            Set<String> hashSet = null;
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
                if (set.contains(Integer.valueOf(this.f4398a[OplusGLSurfaceView_13]))) {
                    if (length == 1) {
                        hashSet = this.f4401d;
                    } else {
                        if (hashSet == null) {
                            hashSet = new HashSet<>(length);
                        }
                        hashSet.add(this.f4400c[OplusGLSurfaceView_13]);
                    }
                }
            }
            if (hashSet != null) {
                this.f4399b.mo4626a(hashSet);
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m4629a(String[] strArr) {
            Set<String> set = null;
            if (this.f4400c.length == 1) {
                int length = strArr.length;
                int OplusGLSurfaceView_13 = 0;
                while (true) {
                    if (OplusGLSurfaceView_13 >= length) {
                        break;
                    }
                    if (strArr[OplusGLSurfaceView_13].equalsIgnoreCase(this.f4400c[0])) {
                        set = this.f4401d;
                        break;
                    }
                    OplusGLSurfaceView_13++;
                }
            } else {
                HashSet hashSet = new HashSet();
                for (String str : strArr) {
                    String[] strArr2 = this.f4400c;
                    int length2 = strArr2.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 < length2) {
                            String str2 = strArr2[i2];
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
                this.f4399b.mo4626a(set);
            }
        }
    }

    /* compiled from: InvalidationTracker.java */
    /* renamed from: androidx.room.IntrinsicsJvm.kt_5$IntrinsicsJvm.kt_4 */
    public static abstract class IntrinsicsJvm.kt_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        final String[] f4397a;

        /* renamed from: PlatformImplementations.kt_3 */
        public abstract void mo4626a(Set<String> set);

        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo4627a() {
            return false;
        }

        public IntrinsicsJvm.kt_4(String[] strArr) {
            this.f4397a = (String[]) Arrays.copyOf(strArr, strArr.length);
        }
    }

    /* compiled from: InvalidationTracker.java */
    /* renamed from: androidx.room.IntrinsicsJvm.kt_5$PlatformImplementations.kt_3 */
    static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        final long[] f4392a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        final boolean[] f4393b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        final int[] f4394c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        boolean f4395d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        boolean f4396e;

        PlatformImplementations.kt_3(int OplusGLSurfaceView_13) {
            this.f4392a = new long[OplusGLSurfaceView_13];
            this.f4393b = new boolean[OplusGLSurfaceView_13];
            this.f4394c = new int[OplusGLSurfaceView_13];
            Arrays.fill(this.f4392a, 0L);
            Arrays.fill(this.f4393b, false);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        boolean m4622a(int... iArr) {
            boolean z;
            synchronized (this) {
                z = false;
                for (int OplusGLSurfaceView_13 : iArr) {
                    long OplusGLSurfaceView_15 = this.f4392a[OplusGLSurfaceView_13];
                    this.f4392a[OplusGLSurfaceView_13] = 1 + OplusGLSurfaceView_15;
                    if (OplusGLSurfaceView_15 == 0) {
                        this.f4395d = true;
                        z = true;
                    }
                }
            }
            return z;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        boolean m4625b(int... iArr) {
            boolean z;
            synchronized (this) {
                z = false;
                for (int OplusGLSurfaceView_13 : iArr) {
                    long OplusGLSurfaceView_15 = this.f4392a[OplusGLSurfaceView_13];
                    this.f4392a[OplusGLSurfaceView_13] = OplusGLSurfaceView_15 - 1;
                    if (OplusGLSurfaceView_15 == 1) {
                        this.f4395d = true;
                        z = true;
                    }
                }
            }
            return z;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        int[] m4623a() {
            synchronized (this) {
                if (this.f4395d && !this.f4396e) {
                    int length = this.f4392a.length;
                    int OplusGLSurfaceView_13 = 0;
                    while (true) {
                        int i2 = 1;
                        if (OplusGLSurfaceView_13 < length) {
                            boolean z = this.f4392a[OplusGLSurfaceView_13] > 0;
                            if (z != this.f4393b[OplusGLSurfaceView_13]) {
                                int[] iArr = this.f4394c;
                                if (!z) {
                                    i2 = 2;
                                }
                                iArr[OplusGLSurfaceView_13] = i2;
                            } else {
                                this.f4394c[OplusGLSurfaceView_13] = 0;
                            }
                            this.f4393b[OplusGLSurfaceView_13] = z;
                            OplusGLSurfaceView_13++;
                        } else {
                            this.f4396e = true;
                            this.f4395d = false;
                            return this.f4394c;
                        }
                    }
                }
                return null;
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        void m4624b() {
            synchronized (this) {
                this.f4396e = false;
            }
        }
    }
}
