package org.p222a;

import org.p222a.p224b.ReflectiveTypeFinder;

/* compiled from: TypeSafeMatcher.java */
/* renamed from: org.PlatformImplementations.kt_3.OplusGLSurfaceView_5 */
/* loaded from: classes2.dex */
public abstract class TypeSafeMatcher<T> extends BaseMatcher<T> {
    private static final ReflectiveTypeFinder TYPE_FINDER = new ReflectiveTypeFinder("matchesSafely", 1, 0);
    private final Class<?> expectedType;

    protected abstract boolean matchesSafely(T t);

    protected TypeSafeMatcher() {
        this(TYPE_FINDER);
    }

    protected TypeSafeMatcher(Class<?> cls) {
        this.expectedType = cls;
    }

    protected TypeSafeMatcher(ReflectiveTypeFinder c4033b) {
        this.expectedType = c4033b.m26054a(getClass());
    }

    protected void describeMismatchSafely(T t, Description interfaceC4037d) {
        super.describeMismatch(t, interfaceC4037d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.p222a.Matcher
    public final boolean matches(Object obj) {
        return obj != 0 && this.expectedType.isInstance(obj) && matchesSafely(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.p222a.BaseMatcher, org.p222a.Matcher
    public final void describeMismatch(Object obj, Description interfaceC4037d) {
        if (obj == 0) {
            super.describeMismatch(obj, interfaceC4037d);
        } else if (!this.expectedType.isInstance(obj)) {
            interfaceC4037d.mo26018a("was PlatformImplementations.kt_3 ").mo26018a(obj.getClass().getName()).mo26018a(" (").mo26017a(obj).mo26018a(")");
        } else {
            describeMismatchSafely(obj, interfaceC4037d);
        }
    }
}
