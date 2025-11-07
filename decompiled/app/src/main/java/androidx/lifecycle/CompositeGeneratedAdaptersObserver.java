package androidx.lifecycle;

/* loaded from: classes.dex */
class CompositeGeneratedAdaptersObserver implements androidx.lifecycle.f_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final androidx.lifecycle.c_renamed[] f1213a;

    CompositeGeneratedAdaptersObserver(androidx.lifecycle.c_renamed[] cVarArr) {
        this.f1213a = cVarArr;
    }

    @Override // androidx.lifecycle.f_renamed
    public void a_renamed(androidx.lifecycle.h_renamed hVar, androidx.lifecycle.e_renamed.a_renamed aVar) {
        androidx.lifecycle.l_renamed lVar = new androidx.lifecycle.l_renamed();
        for (androidx.lifecycle.c_renamed cVar : this.f1213a) {
            cVar.a_renamed(hVar, aVar, false, lVar);
        }
        for (androidx.lifecycle.c_renamed cVar2 : this.f1213a) {
            cVar2.a_renamed(hVar, aVar, true, lVar);
        }
    }
}
