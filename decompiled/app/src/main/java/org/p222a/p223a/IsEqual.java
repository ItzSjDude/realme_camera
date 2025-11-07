package org.p222a.p223a;

import java.lang.reflect.Array;
import org.p222a.BaseMatcher;
import org.p222a.Description;
import org.p222a.Matcher;

/* compiled from: IsEqual.java */
/* renamed from: org.PlatformImplementations.kt_3.PlatformImplementations.kt_3.COUIBaseListPopupWindow_12 */
/* loaded from: classes2.dex */
public class IsEqual<T> extends BaseMatcher<T> {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Object f24785a;

    public IsEqual(T t) {
        this.f24785a = t;
    }

    @Override // org.p222a.Matcher
    public boolean matches(Object obj) {
        return m26038a(obj, this.f24785a);
    }

    @Override // org.p222a.SelfDescribing
    public void describeTo(Description interfaceC4037d) {
        interfaceC4037d.mo26017a(this.f24785a);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m26038a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        if (obj2 == null || !m26039b(obj)) {
            return obj.equals(obj2);
        }
        return m26039b(obj2) && m26040b(obj, obj2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static boolean m26040b(Object obj, Object obj2) {
        return m26041c(obj, obj2) && m26042d(obj, obj2);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static boolean m26041c(Object obj, Object obj2) {
        return Array.getLength(obj) == Array.getLength(obj2);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static boolean m26042d(Object obj, Object obj2) {
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < Array.getLength(obj); OplusGLSurfaceView_13++) {
            if (!m26038a(Array.get(obj, OplusGLSurfaceView_13), Array.get(obj2, OplusGLSurfaceView_13))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static boolean m26039b(Object obj) {
        return obj.getClass().isArray();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static <T> Matcher<T> m26037a(T t) {
        return new IsEqual(t);
    }
}
