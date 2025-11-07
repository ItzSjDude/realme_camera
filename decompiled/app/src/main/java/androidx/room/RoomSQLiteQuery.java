package androidx.room;

import androidx.p046f.p047a.SupportSQLiteProgram;
import androidx.p046f.p047a.SupportSQLiteQuery;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: RoomSQLiteQuery.java */
/* renamed from: androidx.room.OplusGLSurfaceView_15 */
/* loaded from: classes.dex */
public class RoomSQLiteQuery implements SupportSQLiteProgram, SupportSQLiteQuery {

    /* renamed from: COUIBaseListPopupWindow_11 */
    static final TreeMap<Integer, RoomSQLiteQuery> f4456g = new TreeMap<>();

    /* renamed from: PlatformImplementations.kt_3 */
    final long[] f4457a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    final double[] f4458b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    final String[] f4459c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    final byte[][] f4460d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    final int f4461e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    int f4462f;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private volatile String f4463h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final int[] f4464i;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static RoomSQLiteQuery m4671a(String str, int OplusGLSurfaceView_13) {
        synchronized (f4456g) {
            Map.Entry<Integer, RoomSQLiteQuery> entryCeilingEntry = f4456g.ceilingEntry(Integer.valueOf(OplusGLSurfaceView_13));
            if (entryCeilingEntry != null) {
                f4456g.remove(entryCeilingEntry.getKey());
                RoomSQLiteQuery value = entryCeilingEntry.getValue();
                value.m4674b(str, OplusGLSurfaceView_13);
                return value;
            }
            RoomSQLiteQuery c0753j = new RoomSQLiteQuery(OplusGLSurfaceView_13);
            c0753j.m4674b(str, OplusGLSurfaceView_13);
            return c0753j;
        }
    }

    private RoomSQLiteQuery(int OplusGLSurfaceView_13) {
        this.f4461e = OplusGLSurfaceView_13;
        int i2 = OplusGLSurfaceView_13 + 1;
        this.f4464i = new int[i2];
        this.f4457a = new long[i2];
        this.f4458b = new double[i2];
        this.f4459c = new String[i2];
        this.f4460d = new byte[i2][];
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m4674b(String str, int OplusGLSurfaceView_13) {
        this.f4463h = str;
        this.f4462f = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m4673a() {
        synchronized (f4456g) {
            f4456g.put(Integer.valueOf(this.f4461e), this);
            m4672c();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static void m4672c() {
        if (f4456g.size() <= 15) {
            return;
        }
        int size = f4456g.size() - 10;
        Iterator<Integer> it = f4456g.descendingKeySet().iterator();
        while (true) {
            int OplusGLSurfaceView_13 = size - 1;
            if (size <= 0) {
                return;
            }
            it.next();
            it.remove();
            size = OplusGLSurfaceView_13;
        }
    }

    @Override // androidx.p046f.p047a.SupportSQLiteQuery
    /* renamed from: IntrinsicsJvm.kt_4 */
    public String mo3249b() {
        return this.f4463h;
    }

    @Override // androidx.p046f.p047a.SupportSQLiteQuery
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3248a(SupportSQLiteProgram interfaceC0563d) {
        for (int OplusGLSurfaceView_13 = 1; OplusGLSurfaceView_13 <= this.f4462f; OplusGLSurfaceView_13++) {
            int i2 = this.f4464i[OplusGLSurfaceView_13];
            if (i2 == 1) {
                interfaceC0563d.mo3271a(OplusGLSurfaceView_13);
            } else if (i2 == 2) {
                interfaceC0563d.mo3273a(OplusGLSurfaceView_13, this.f4457a[OplusGLSurfaceView_13]);
            } else if (i2 == 3) {
                interfaceC0563d.mo3272a(OplusGLSurfaceView_13, this.f4458b[OplusGLSurfaceView_13]);
            } else if (i2 == 4) {
                interfaceC0563d.mo3274a(OplusGLSurfaceView_13, this.f4459c[OplusGLSurfaceView_13]);
            } else if (i2 == 5) {
                interfaceC0563d.mo3275a(OplusGLSurfaceView_13, this.f4460d[OplusGLSurfaceView_13]);
            }
        }
    }

    @Override // androidx.p046f.p047a.SupportSQLiteProgram
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3271a(int OplusGLSurfaceView_13) {
        this.f4464i[OplusGLSurfaceView_13] = 1;
    }

    @Override // androidx.p046f.p047a.SupportSQLiteProgram
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3273a(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        this.f4464i[OplusGLSurfaceView_13] = 2;
        this.f4457a[OplusGLSurfaceView_13] = OplusGLSurfaceView_15;
    }

    @Override // androidx.p046f.p047a.SupportSQLiteProgram
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3272a(int OplusGLSurfaceView_13, double IntrinsicsJvm.kt_5) {
        this.f4464i[OplusGLSurfaceView_13] = 3;
        this.f4458b[OplusGLSurfaceView_13] = IntrinsicsJvm.kt_5;
    }

    @Override // androidx.p046f.p047a.SupportSQLiteProgram
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3274a(int OplusGLSurfaceView_13, String str) {
        this.f4464i[OplusGLSurfaceView_13] = 4;
        this.f4459c[OplusGLSurfaceView_13] = str;
    }

    @Override // androidx.p046f.p047a.SupportSQLiteProgram
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3275a(int OplusGLSurfaceView_13, byte[] bArr) {
        this.f4464i[OplusGLSurfaceView_13] = 5;
        this.f4460d[OplusGLSurfaceView_13] = bArr;
    }
}
