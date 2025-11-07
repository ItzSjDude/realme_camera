package p061c.p077k;

import p061c.p070f.p072b.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StringsJVM.kt */
/* renamed from: IntrinsicsJvm.kt_3.OplusGLSurfaceView_5.OplusGLSurfaceView_6 */
/* loaded from: classes.dex */
public class StringsJVM.kt extends StringNumberConversions.kt {
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ boolean m5356a(String str, String str2, boolean z, int OplusGLSurfaceView_13, Object obj) {
        if ((OplusGLSurfaceView_13 & 2) != 0) {
            z = false;
        }
        return C1005d.m5355a(str, str2, z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final boolean m5355a(String str, String str2, boolean z) {
        Intrinsics.m5305d(str, "$this$startsWith");
        Intrinsics.m5305d(str2, "prefix");
        if (!z) {
            return str.startsWith(str2);
        }
        return C1005d.m5354a(str, 0, str2, 0, str2.length(), z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final boolean m5354a(String str, int OplusGLSurfaceView_13, String str2, int i2, int i3, boolean z) {
        Intrinsics.m5305d(str, "$this$regionMatches");
        Intrinsics.m5305d(str2, "other");
        if (!z) {
            return str.regionMatches(OplusGLSurfaceView_13, str2, i2, i3);
        }
        return str.regionMatches(z, OplusGLSurfaceView_13, str2, i2, i3);
    }
}
