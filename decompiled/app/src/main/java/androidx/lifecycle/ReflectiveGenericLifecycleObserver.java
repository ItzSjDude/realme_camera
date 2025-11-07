package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ClassesInfoCache;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
class ReflectiveGenericLifecycleObserver implements LifecycleEventObserver {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Object f3623a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final ClassesInfoCache.PlatformImplementations.kt_3 f3624b;

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.f3623a = obj;
        this.f3624b = ClassesInfoCache.f3626a.m3627b(this.f3623a.getClass());
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo714a(LifecycleOwner interfaceC0605h, Lifecycle.PlatformImplementations.kt_3 aVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.f3624b.m3629a(interfaceC0605h, aVar, this.f3623a);
    }
}
