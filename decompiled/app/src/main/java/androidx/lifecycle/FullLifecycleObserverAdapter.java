package androidx.lifecycle;

/* loaded from: classes.dex */
class FullLifecycleObserverAdapter implements androidx.lifecycle.f_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final androidx.lifecycle.b_renamed f1214a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final androidx.lifecycle.f_renamed f1215b;

    FullLifecycleObserverAdapter(androidx.lifecycle.b_renamed bVar, androidx.lifecycle.f_renamed fVar) {
        this.f1214a = bVar;
        this.f1215b = fVar;
    }

    @Override // androidx.lifecycle.f_renamed
    public void a_renamed(androidx.lifecycle.h_renamed hVar, androidx.lifecycle.e_renamed.a_renamed aVar) {
        switch (aVar) {
            case ON_CREATE:
                this.f1214a.a_renamed(hVar);
                break;
            case ON_START:
                this.f1214a.b_renamed(hVar);
                break;
            case ON_RESUME:
                this.f1214a.c_renamed(hVar);
                break;
            case ON_PAUSE:
                this.f1214a.d_renamed(hVar);
                break;
            case ON_STOP:
                this.f1214a.e_renamed(hVar);
                break;
            case ON_DESTROY:
                this.f1214a.f_renamed(hVar);
                break;
            case ON_ANY:
                throw new java.lang.IllegalArgumentException("ON_ANY must not been send by_renamed anybody");
        }
        androidx.lifecycle.f_renamed fVar = this.f1215b;
        if (fVar != null) {
            fVar.a_renamed(hVar, aVar);
        }
    }
}
