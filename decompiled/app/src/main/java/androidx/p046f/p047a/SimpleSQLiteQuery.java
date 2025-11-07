package androidx.p046f.p047a;

/* compiled from: SimpleSQLiteQuery.java */
/* renamed from: androidx.COUIBaseListPopupWindow_12.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public final class SimpleSQLiteQuery implements SupportSQLiteQuery {

    /* renamed from: PlatformImplementations.kt_3 */
    private final String f3354a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Object[] f3355b;

    public SimpleSQLiteQuery(String str, Object[] objArr) {
        this.f3354a = str;
        this.f3355b = objArr;
    }

    public SimpleSQLiteQuery(String str) {
        this(str, null);
    }

    @Override // androidx.p046f.p047a.SupportSQLiteQuery
    /* renamed from: IntrinsicsJvm.kt_4 */
    public String mo3249b() {
        return this.f3354a;
    }

    @Override // androidx.p046f.p047a.SupportSQLiteQuery
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3248a(SupportSQLiteProgram interfaceC0563d) {
        m3247a(interfaceC0563d, this.f3355b);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m3247a(SupportSQLiteProgram interfaceC0563d, Object[] objArr) {
        if (objArr == null) {
            return;
        }
        int length = objArr.length;
        int OplusGLSurfaceView_13 = 0;
        while (OplusGLSurfaceView_13 < length) {
            Object obj = objArr[OplusGLSurfaceView_13];
            OplusGLSurfaceView_13++;
            m3246a(interfaceC0563d, OplusGLSurfaceView_13, obj);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m3246a(SupportSQLiteProgram interfaceC0563d, int OplusGLSurfaceView_13, Object obj) {
        if (obj == null) {
            interfaceC0563d.mo3271a(OplusGLSurfaceView_13);
            return;
        }
        if (obj instanceof byte[]) {
            interfaceC0563d.mo3275a(OplusGLSurfaceView_13, (byte[]) obj);
            return;
        }
        if (obj instanceof Float) {
            interfaceC0563d.mo3272a(OplusGLSurfaceView_13, ((Float) obj).floatValue());
            return;
        }
        if (obj instanceof Double) {
            interfaceC0563d.mo3272a(OplusGLSurfaceView_13, ((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Long) {
            interfaceC0563d.mo3273a(OplusGLSurfaceView_13, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof Integer) {
            interfaceC0563d.mo3273a(OplusGLSurfaceView_13, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Short) {
            interfaceC0563d.mo3273a(OplusGLSurfaceView_13, ((Short) obj).shortValue());
            return;
        }
        if (obj instanceof Byte) {
            interfaceC0563d.mo3273a(OplusGLSurfaceView_13, ((Byte) obj).byteValue());
            return;
        }
        if (obj instanceof String) {
            interfaceC0563d.mo3274a(OplusGLSurfaceView_13, (String) obj);
            return;
        }
        if (obj instanceof Boolean) {
            interfaceC0563d.mo3273a(OplusGLSurfaceView_13, ((Boolean) obj).booleanValue() ? 1L : 0L);
            return;
        }
        throw new IllegalArgumentException("Cannot bind " + obj + " at index " + OplusGLSurfaceView_13 + " Supported types: null, byte[], float, double, long, int, short, byte, string");
    }
}
