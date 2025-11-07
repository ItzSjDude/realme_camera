package androidx.room;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Looper;
import androidx.p012a.p013a.p014a.ArchTaskExecutor;
import androidx.p046f.p047a.SupportSQLiteDatabase;
import androidx.p046f.p047a.SupportSQLiteOpenHelper;
import androidx.p046f.p047a.SupportSQLiteQuery;
import androidx.p046f.p047a.SupportSQLiteStatement;
import androidx.p046f.p047a.p048a.FrameworkSQLiteOpenHelperFactory;
import androidx.room.p053a.Migration;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: RoomDatabase.java */
/* renamed from: androidx.room.COUIBaseListPopupWindow_11 */
/* loaded from: classes.dex */
public abstract class RoomDatabase {

    /* renamed from: PlatformImplementations.kt_3 */
    @Deprecated
    protected volatile SupportSQLiteDatabase f4420a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    boolean f4421b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    @Deprecated
    protected List<IntrinsicsJvm.kt_4> f4422c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Executor f4423d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Executor f4424e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private SupportSQLiteOpenHelper f4425f;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f4427h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final ReentrantReadWriteLock f4428i = new ReentrantReadWriteLock();

    /* renamed from: OplusGLSurfaceView_15 */
    private final ThreadLocal<Integer> f4429j = new ThreadLocal<>();

    /* renamed from: OplusGLSurfaceView_5 */
    private final Map<String, Object> f4430k = new ConcurrentHashMap();

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final InvalidationTracker f4426g = mo4641c();

    /* compiled from: RoomDatabase.java */
    /* renamed from: androidx.room.COUIBaseListPopupWindow_11$IntrinsicsJvm.kt_4 */
    public static abstract class IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        public void m4652a(SupportSQLiteDatabase interfaceC0561b) {
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m4653b(SupportSQLiteDatabase interfaceC0561b) {
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public void m4654c(SupportSQLiteDatabase interfaceC0561b) {
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected abstract SupportSQLiteOpenHelper mo4640b(DatabaseConfiguration c0738a);

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected abstract InvalidationTracker mo4641c();

    /* renamed from: PlatformImplementations.kt_3 */
    Lock m4636a() {
        return this.f4428i.readLock();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m4638a(DatabaseConfiguration c0738a) {
        this.f4425f = mo4640b(c0738a);
        SupportSQLiteOpenHelper interfaceC0562c = this.f4425f;
        if (interfaceC0562c instanceof SQLiteCopyOpenHelper) {
            ((SQLiteCopyOpenHelper) interfaceC0562c).m4677a(c0738a);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            z = c0738a.f4339g == IntrinsicsJvm.kt_3.WRITE_AHEAD_LOGGING;
            this.f4425f.mo3265a(z);
        }
        this.f4422c = c0738a.f4337e;
        this.f4423d = c0738a.f4340h;
        this.f4424e = new TransactionExecutor(c0738a.f4341i);
        this.f4427h = c0738a.f4338f;
        this.f4421b = z;
        if (c0738a.f4342j) {
            this.f4426g.m4612a(c0738a.f4334b, c0738a.f4335c);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public SupportSQLiteOpenHelper m4639b() {
        return this.f4425f;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m4642d() {
        SupportSQLiteDatabase interfaceC0561b = this.f4420a;
        return interfaceC0561b != null && interfaceC0561b.mo3260e();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m4643e() {
        if (!this.f4427h && m4632l()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for PlatformImplementations.kt_3 long period of time.");
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m4644f() {
        if (!m4649k() && this.f4429j.get() != null) {
            throw new IllegalStateException("Cannot access database on PlatformImplementations.kt_3 different coroutine context inherited from PlatformImplementations.kt_3 suspending transaction.");
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Cursor m4633a(SupportSQLiteQuery interfaceC0564e) {
        return m4634a(interfaceC0564e, null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Cursor m4634a(SupportSQLiteQuery interfaceC0564e, CancellationSignal cancellationSignal) {
        m4643e();
        m4644f();
        if (cancellationSignal != null && Build.VERSION.SDK_INT >= 16) {
            return this.f4425f.mo3266b().mo3251a(interfaceC0564e, cancellationSignal);
        }
        return this.f4425f.mo3266b().mo3250a(interfaceC0564e);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public SupportSQLiteStatement m4635a(String str) {
        m4643e();
        m4644f();
        return this.f4425f.mo3266b().mo3252a(str);
    }

    @Deprecated
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m4645g() {
        m4643e();
        SupportSQLiteDatabase interfaceC0561bMo3266b = this.f4425f.mo3266b();
        this.f4426g.m4618b(interfaceC0561bMo3266b);
        interfaceC0561bMo3266b.mo3253a();
    }

    @Deprecated
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m4646h() {
        this.f4425f.mo3266b().mo3256b();
        if (m4649k()) {
            return;
        }
        this.f4426g.m4617b();
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public Executor m4647i() {
        return this.f4423d;
    }

    @Deprecated
    /* renamed from: OplusGLSurfaceView_15 */
    public void m4648j() {
        this.f4425f.mo3266b().mo3257c();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m4637a(SupportSQLiteDatabase interfaceC0561b) {
        this.f4426g.m4613a(interfaceC0561b);
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public boolean m4649k() {
        return this.f4425f.mo3266b().mo3259d();
    }

    /* compiled from: RoomDatabase.java */
    /* renamed from: androidx.room.COUIBaseListPopupWindow_11$IntrinsicsJvm.kt_3 */
    public enum IntrinsicsJvm.kt_3 {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        @SuppressLint({"NewApi"})
        IntrinsicsJvm.kt_3 resolve(Context context) {
            ActivityManager activityManager;
            if (this != AUTOMATIC) {
                return this;
            }
            if (Build.VERSION.SDK_INT >= 16 && (activityManager = (ActivityManager) context.getSystemService("activity")) != null && !isLowRamDevice(activityManager)) {
                return WRITE_AHEAD_LOGGING;
            }
            return TRUNCATE;
        }

        private static boolean isLowRamDevice(ActivityManager activityManager) {
            if (Build.VERSION.SDK_INT >= 19) {
                return activityManager.isLowRamDevice();
            }
            return false;
        }
    }

    /* compiled from: RoomDatabase.java */
    /* renamed from: androidx.room.COUIBaseListPopupWindow_11$PlatformImplementations.kt_3 */
    public static class PlatformImplementations.kt_3<T extends RoomDatabase> {

        /* renamed from: PlatformImplementations.kt_3 */
        private final Class<T> f4431a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final String f4432b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final Context f4433c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private ArrayList<IntrinsicsJvm.kt_4> f4434d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private Executor f4435e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private Executor f4436f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private SupportSQLiteOpenHelper.IntrinsicsJvm.kt_3 f4437g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        private boolean f4438h;

        /* renamed from: OplusGLSurfaceView_15 */
        private boolean f4440j;

        /* renamed from: OplusGLSurfaceView_14 */
        private boolean f4442l;

        /* renamed from: OplusGLSurfaceView_11 */
        private Set<Integer> f4444n;

        /* renamed from: o */
        private Set<Integer> f4445o;

        /* renamed from: p */
        private String f4446p;

        /* renamed from: q */
        private File f4447q;

        /* renamed from: OplusGLSurfaceView_13 */
        private IntrinsicsJvm.kt_3 f4439i = IntrinsicsJvm.kt_3.AUTOMATIC;

        /* renamed from: OplusGLSurfaceView_5 */
        private boolean f4441k = true;

        /* renamed from: OplusGLSurfaceView_6 */
        private final IntrinsicsJvm.kt_5 f4443m = new IntrinsicsJvm.kt_5();

        PlatformImplementations.kt_3(Context context, Class<T> cls, String str) {
            this.f4433c = context;
            this.f4431a = cls;
            this.f4432b = str;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public PlatformImplementations.kt_3<T> m4650a() {
            this.f4438h = true;
            return this;
        }

        @SuppressLint({"RestrictedApi"})
        /* renamed from: IntrinsicsJvm.kt_4 */
        public T m4651b() {
            Executor executor;
            if (this.f4433c == null) {
                throw new IllegalArgumentException("Cannot provide null context for the database.");
            }
            if (this.f4431a == null) {
                throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
            }
            if (this.f4435e == null && this.f4436f == null) {
                Executor executorM692b = ArchTaskExecutor.m692b();
                this.f4436f = executorM692b;
                this.f4435e = executorM692b;
            } else {
                Executor executor2 = this.f4435e;
                if (executor2 != null && this.f4436f == null) {
                    this.f4436f = executor2;
                } else if (this.f4435e == null && (executor = this.f4436f) != null) {
                    this.f4435e = executor;
                }
            }
            Set<Integer> set = this.f4445o;
            if (set != null && this.f4444n != null) {
                for (Integer num : set) {
                    if (this.f4444n.contains(num)) {
                        throw new IllegalArgumentException("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has PlatformImplementations.kt_3 start or end version equal to PlatformImplementations.kt_3 start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + num);
                    }
                }
            }
            if (this.f4437g == null) {
                this.f4437g = new FrameworkSQLiteOpenHelperFactory();
            }
            if (this.f4446p != null || this.f4447q != null) {
                if (this.f4432b == null) {
                    throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
                }
                if (this.f4446p != null && this.f4447q != null) {
                    throw new IllegalArgumentException("Both createFromAsset() and createFromFile() was called on this Builder but the database can only be created using one of the two configurations.");
                }
                this.f4437g = new SQLiteCopyOpenHelperFactory(this.f4446p, this.f4447q, this.f4437g);
            }
            Context context = this.f4433c;
            DatabaseConfiguration c0738a = new DatabaseConfiguration(context, this.f4432b, this.f4437g, this.f4443m, this.f4434d, this.f4438h, this.f4439i.resolve(context), this.f4435e, this.f4436f, this.f4440j, this.f4441k, this.f4442l, this.f4444n, this.f4446p, this.f4447q);
            T t = (T) Room.m4631a(this.f4431a, "_Impl");
            t.m4638a(c0738a);
            return t;
        }
    }

    /* compiled from: RoomDatabase.java */
    /* renamed from: androidx.room.COUIBaseListPopupWindow_11$IntrinsicsJvm.kt_5 */
    public static class IntrinsicsJvm.kt_5 {

        /* renamed from: PlatformImplementations.kt_3 */
        private HashMap<Integer, TreeMap<Integer, Migration>> f4448a = new HashMap<>();

        /* renamed from: PlatformImplementations.kt_3 */
        public List<Migration> m4656a(int OplusGLSurfaceView_13, int i2) {
            if (OplusGLSurfaceView_13 == i2) {
                return Collections.emptyList();
            }
            return m4655a(new ArrayList(), i2 > OplusGLSurfaceView_13, OplusGLSurfaceView_13, i2);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x003e  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0016 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0047 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:43:? A[LOOP:1: B:13:0x0026->B:43:?, LOOP_END, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0017  */
        /* renamed from: PlatformImplementations.kt_3 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private java.util.List<androidx.room.p053a.Migration> m4655a(java.util.List<androidx.room.p053a.Migration> r7, boolean r8, int r9, int r10) {
            /*
                r6 = this;
            L0:
                if (r8 == 0) goto L5
                if (r9 >= r10) goto L58
                goto L7
            L5:
                if (r9 <= r10) goto L58
            L7:
                java.util.HashMap<java.lang.Integer, java.util.TreeMap<java.lang.Integer, androidx.room.PlatformImplementations.kt_3.PlatformImplementations.kt_3>> r0 = r6.f4448a
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
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabase.IntrinsicsJvm.kt_5.m4655a(java.util.List, boolean, int, int):java.util.List");
        }
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private static boolean m4632l() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
