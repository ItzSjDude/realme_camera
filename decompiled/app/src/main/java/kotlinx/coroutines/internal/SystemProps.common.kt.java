package kotlinx.coroutines.internal;

import p061c.p077k.C1005d;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SystemProps.common.kt */
/* renamed from: kotlinx.coroutines.internal.u */
/* loaded from: classes2.dex */
public final /* synthetic */ class SystemProps.common.kt {
    /* renamed from: PlatformImplementations.kt_3 */
    public static final boolean m25911a(String str, boolean z) {
        String strM25903a = C3941s.m25903a(str);
        return strM25903a != null ? Boolean.parseBoolean(strM25903a) : z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ int m25908a(String str, int OplusGLSurfaceView_13, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 1;
        }
        if ((i4 & 8) != 0) {
            i3 = Integer.MAX_VALUE;
        }
        return C3941s.m25899a(str, OplusGLSurfaceView_13, i2, i3);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final int m25907a(String str, int OplusGLSurfaceView_13, int i2, int i3) {
        return (int) C3941s.m25901a(str, OplusGLSurfaceView_13, i2, i3);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ long m25910a(String str, long OplusGLSurfaceView_15, long j2, long j3, int OplusGLSurfaceView_13, Object obj) {
        if ((OplusGLSurfaceView_13 & 4) != 0) {
            j2 = 1;
        }
        long j4 = j2;
        if ((OplusGLSurfaceView_13 & 8) != 0) {
            j3 = Long.MAX_VALUE;
        }
        return C3941s.m25901a(str, OplusGLSurfaceView_15, j4, j3);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final long m25909a(String str, long OplusGLSurfaceView_15, long j2, long j3) {
        String strM25903a = C3941s.m25903a(str);
        if (strM25903a == null) {
            return OplusGLSurfaceView_15;
        }
        Long lB = C1005d.m5352b(strM25903a);
        if (lB == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + strM25903a + '\'').toString());
        }
        long jLongValue = lB.longValue();
        if (j2 <= jLongValue && j3 >= jLongValue) {
            return jLongValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j2 + ".." + j3 + ", but is '" + jLongValue + '\'').toString());
    }
}
