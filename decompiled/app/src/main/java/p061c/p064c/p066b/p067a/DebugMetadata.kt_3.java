package p061c.p064c.p066b.p067a;

import java.lang.reflect.Field;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: DebugMetadata.kt */
/* renamed from: IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.COUIBaseListPopupWindow_12 */
/* loaded from: classes.dex */
public final class DebugMetadata.kt_3 {
    /* renamed from: PlatformImplementations.kt_3 */
    public static final StackTraceElement m5260a(AbstractC0918a abstractC0918a) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        String strM5259e;
        Intrinsics.m5305d(abstractC0918a, "$this$getStackTraceElementImpl");
        InterfaceC0922e interfaceC0922eM5262b = m5262b(abstractC0918a);
        if (interfaceC0922eM5262b == null) {
            return null;
        }
        m5261a(1, interfaceC0922eM5262b.m5255a());
        int iM5263c = m5263c(abstractC0918a);
        int OplusGLSurfaceView_13 = iM5263c < 0 ? -1 : interfaceC0922eM5262b.m5257c()[iM5263c];
        String strM5267a = DebugMetadata.kt.f5032b.m5267a(abstractC0918a);
        if (strM5267a == null) {
            strM5259e = interfaceC0922eM5262b.m5259e();
        } else {
            strM5259e = strM5267a + '/' + interfaceC0922eM5262b.m5259e();
        }
        return new StackTraceElement(strM5259e, interfaceC0922eM5262b.m5258d(), interfaceC0922eM5262b.m5256b(), OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final InterfaceC0922e m5262b(AbstractC0918a abstractC0918a) {
        return (InterfaceC0922e) abstractC0918a.getClass().getAnnotation(InterfaceC0922e.class);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final int m5263c(AbstractC0918a abstractC0918a) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        try {
            Field declaredField = abstractC0918a.getClass().getDeclaredField("label");
            Intrinsics.m5301b(declaredField, "field");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(abstractC0918a);
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static final void m5261a(int OplusGLSurfaceView_13, int i2) {
        if (i2 <= OplusGLSurfaceView_13) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + OplusGLSurfaceView_13 + ", got " + i2 + ". Please update the Kotlin standard library.").toString());
    }
}
