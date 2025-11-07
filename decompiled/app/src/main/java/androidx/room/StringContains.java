package androidx.room;

/* compiled from: RoomSQLiteQuery.java */
/* loaded from: classes.dex */
public class j_renamed implements androidx.f_renamed.a_renamed.d_renamed, androidx.f_renamed.a_renamed.e_renamed {
    static final java.util.TreeMap<java.lang.Integer, androidx.room.j_renamed> g_renamed = new java.util.TreeMap<>();

    /* renamed from: a_renamed, reason: collision with root package name */
    final long[] f1629a;

    /* renamed from: b_renamed, reason: collision with root package name */
    final double[] f1630b;

    /* renamed from: c_renamed, reason: collision with root package name */
    final java.lang.String[] f1631c;
    final byte[][] d_renamed;
    final int e_renamed;
    int f_renamed;
    private volatile java.lang.String h_renamed;
    private final int[] i_renamed;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public static androidx.room.j_renamed a_renamed(java.lang.String str, int i_renamed) {
        synchronized (g_renamed) {
            java.util.Map.Entry<java.lang.Integer, androidx.room.j_renamed> entryCeilingEntry = g_renamed.ceilingEntry(java.lang.Integer.valueOf(i_renamed));
            if (entryCeilingEntry != null) {
                g_renamed.remove(entryCeilingEntry.getKey());
                androidx.room.j_renamed value = entryCeilingEntry.getValue();
                value.b_renamed(str, i_renamed);
                return value;
            }
            androidx.room.j_renamed jVar = new androidx.room.j_renamed(i_renamed);
            jVar.b_renamed(str, i_renamed);
            return jVar;
        }
    }

    private j_renamed(int i_renamed) {
        this.e_renamed = i_renamed;
        int i2 = i_renamed + 1;
        this.i_renamed = new int[i2];
        this.f1629a = new long[i2];
        this.f1630b = new double[i2];
        this.f1631c = new java.lang.String[i2];
        this.d_renamed = new byte[i2][];
    }

    void b_renamed(java.lang.String str, int i_renamed) {
        this.h_renamed = str;
        this.f_renamed = i_renamed;
    }

    public void a_renamed() {
        synchronized (g_renamed) {
            g_renamed.put(java.lang.Integer.valueOf(this.e_renamed), this);
            c_renamed();
        }
    }

    private static void c_renamed() {
        if (g_renamed.size() <= 15) {
            return;
        }
        int size = g_renamed.size() - 10;
        java.util.Iterator<java.lang.Integer> it = g_renamed.descendingKeySet().iterator();
        while (true) {
            int i_renamed = size - 1;
            if (size <= 0) {
                return;
            }
            it.next();
            it.remove();
            size = i_renamed;
        }
    }

    @Override // androidx.f_renamed.a_renamed.e_renamed
    public java.lang.String b_renamed() {
        return this.h_renamed;
    }

    @Override // androidx.f_renamed.a_renamed.e_renamed
    public void a_renamed(androidx.f_renamed.a_renamed.d_renamed dVar) {
        for (int i_renamed = 1; i_renamed <= this.f_renamed; i_renamed++) {
            int i2 = this.i_renamed[i_renamed];
            if (i2 == 1) {
                dVar.a_renamed(i_renamed);
            } else if (i2 == 2) {
                dVar.a_renamed(i_renamed, this.f1629a[i_renamed]);
            } else if (i2 == 3) {
                dVar.a_renamed(i_renamed, this.f1630b[i_renamed]);
            } else if (i2 == 4) {
                dVar.a_renamed(i_renamed, this.f1631c[i_renamed]);
            } else if (i2 == 5) {
                dVar.a_renamed(i_renamed, this.d_renamed[i_renamed]);
            }
        }
    }

    @Override // androidx.f_renamed.a_renamed.d_renamed
    public void a_renamed(int i_renamed) {
        this.i_renamed[i_renamed] = 1;
    }

    @Override // androidx.f_renamed.a_renamed.d_renamed
    public void a_renamed(int i_renamed, long j_renamed) {
        this.i_renamed[i_renamed] = 2;
        this.f1629a[i_renamed] = j_renamed;
    }

    @Override // androidx.f_renamed.a_renamed.d_renamed
    public void a_renamed(int i_renamed, double d_renamed) {
        this.i_renamed[i_renamed] = 3;
        this.f1630b[i_renamed] = d_renamed;
    }

    @Override // androidx.f_renamed.a_renamed.d_renamed
    public void a_renamed(int i_renamed, java.lang.String str) {
        this.i_renamed[i_renamed] = 4;
        this.f1631c[i_renamed] = str;
    }

    @Override // androidx.f_renamed.a_renamed.d_renamed
    public void a_renamed(int i_renamed, byte[] bArr) {
        this.i_renamed[i_renamed] = 5;
        this.d_renamed[i_renamed] = bArr;
    }
}
