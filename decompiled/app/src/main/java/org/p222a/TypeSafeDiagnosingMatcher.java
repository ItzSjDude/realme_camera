package org.p222a;

import org.p222a.Description;
import org.p222a.p224b.ReflectiveTypeFinder;

/* compiled from: TypeSafeDiagnosingMatcher.java */
/* renamed from: org.PlatformImplementations.kt_3.OplusGLSurfaceView_15 */
/* loaded from: classes2.dex */
public abstract class TypeSafeDiagnosingMatcher<T> extends BaseMatcher<T> {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final ReflectiveTypeFinder f24799a = new ReflectiveTypeFinder("matchesSafely", 2, 0);

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Class<?> f24800b;

    /* renamed from: PlatformImplementations.kt_3 */
    protected abstract boolean mo26027a(T t, Description interfaceC4037d);

    protected TypeSafeDiagnosingMatcher(ReflectiveTypeFinder c4033b) {
        this.f24800b = c4033b.m26054a(getClass());
    }

    protected TypeSafeDiagnosingMatcher() {
        this(f24799a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.p222a.Matcher
    public final boolean matches(Object obj) {
        return obj != 0 && this.f24800b.isInstance(obj) && mo26027a(obj, new Description.PlatformImplementations.kt_3());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.p222a.BaseMatcher, org.p222a.Matcher
    public final void describeMismatch(Object obj, Description interfaceC4037d) {
        if (obj == 0 || !this.f24800b.isInstance(obj)) {
            super.describeMismatch(obj, interfaceC4037d);
        } else {
            mo26027a(obj, interfaceC4037d);
        }
    }
}
