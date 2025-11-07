package org.p222a.p224b;

import java.lang.reflect.Method;

/* compiled from: ReflectiveTypeFinder.java */
/* renamed from: org.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class ReflectiveTypeFinder {

    /* renamed from: PlatformImplementations.kt_3 */
    private final String f24792a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final int f24793b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final int f24794c;

    public ReflectiveTypeFinder(String str, int OplusGLSurfaceView_13, int i2) {
        this.f24792a = str;
        this.f24793b = OplusGLSurfaceView_13;
        this.f24794c = i2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Class<?> m26054a(Class<?> cls) throws SecurityException {
        while (cls != Object.class) {
            for (Method method : cls.getDeclaredMethods()) {
                if (m26055a(method)) {
                    return m26056b(method);
                }
            }
            cls = cls.getSuperclass();
        }
        throw new Error("Cannot determine correct type for " + this.f24792a + "() method.");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected boolean m26055a(Method method) {
        return method.getName().equals(this.f24792a) && method.getParameterTypes().length == this.f24793b && !method.isSynthetic();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected Class<?> m26056b(Method method) {
        return method.getParameterTypes()[this.f24794c];
    }
}
