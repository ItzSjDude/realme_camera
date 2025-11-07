package androidx.lifecycle;

/* loaded from: classes.dex */
class ReflectiveGenericLifecycleObserver implements androidx.lifecycle.f_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.lang.Object f1225a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final androidx.lifecycle.a_renamed.ClassesInfoCache_2 f1226b;

    ReflectiveGenericLifecycleObserver(java.lang.Object obj) {
        this.f1225a = obj;
        this.f1226b = androidx.lifecycle.a_renamed.f1228a.b_renamed(this.f1225a.getClass());
    }

    @Override // androidx.lifecycle.f_renamed
    public void a_renamed(androidx.lifecycle.h_renamed hVar, androidx.lifecycle.e_renamed.a_renamed aVar) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        this.f1226b.a_renamed(hVar, aVar, this.f1225a);
    }
}
