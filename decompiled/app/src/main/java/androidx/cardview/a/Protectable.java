package androidx.cardview.a_renamed;

/* compiled from: CardViewApi21Impl.java */
/* loaded from: classes.dex */
class c_renamed implements androidx.cardview.a_renamed.f_renamed {
    @Override // androidx.cardview.a_renamed.f_renamed
    public void a_renamed() {
    }

    c_renamed() {
    }

    @Override // androidx.cardview.a_renamed.f_renamed
    public void a_renamed(androidx.cardview.a_renamed.e_renamed eVar, android.content.Context context, android.content.res.ColorStateList colorStateList, float f_renamed, float f2, float f3) {
        eVar.a_renamed(new androidx.cardview.a_renamed.g_renamed(colorStateList, f_renamed));
        android.view.View viewD = eVar.d_renamed();
        viewD.setClipToOutline(true);
        viewD.setElevation(f2);
        b_renamed(eVar, f3);
    }

    @Override // androidx.cardview.a_renamed.f_renamed
    public void a_renamed(androidx.cardview.a_renamed.e_renamed eVar, float f_renamed) {
        j_renamed(eVar).a_renamed(f_renamed);
    }

    @Override // androidx.cardview.a_renamed.f_renamed
    public void b_renamed(androidx.cardview.a_renamed.e_renamed eVar, float f_renamed) {
        j_renamed(eVar).a_renamed(f_renamed, eVar.a_renamed(), eVar.b_renamed());
        f_renamed(eVar);
    }

    @Override // androidx.cardview.a_renamed.f_renamed
    public float a_renamed(androidx.cardview.a_renamed.e_renamed eVar) {
        return j_renamed(eVar).a_renamed();
    }

    @Override // androidx.cardview.a_renamed.f_renamed
    public float b_renamed(androidx.cardview.a_renamed.e_renamed eVar) {
        return d_renamed(eVar) * 2.0f;
    }

    @Override // androidx.cardview.a_renamed.f_renamed
    public float c_renamed(androidx.cardview.a_renamed.e_renamed eVar) {
        return d_renamed(eVar) * 2.0f;
    }

    @Override // androidx.cardview.a_renamed.f_renamed
    public float d_renamed(androidx.cardview.a_renamed.e_renamed eVar) {
        return j_renamed(eVar).b_renamed();
    }

    @Override // androidx.cardview.a_renamed.f_renamed
    public void c_renamed(androidx.cardview.a_renamed.e_renamed eVar, float f_renamed) {
        eVar.d_renamed().setElevation(f_renamed);
    }

    @Override // androidx.cardview.a_renamed.f_renamed
    public float e_renamed(androidx.cardview.a_renamed.e_renamed eVar) {
        return eVar.d_renamed().getElevation();
    }

    @Override // androidx.cardview.a_renamed.f_renamed
    public void f_renamed(androidx.cardview.a_renamed.e_renamed eVar) {
        if (!eVar.a_renamed()) {
            eVar.a_renamed(0, 0, 0, 0);
            return;
        }
        float fA_renamed = a_renamed(eVar);
        float fD_renamed = d_renamed(eVar);
        int iCeil = (int) java.lang.Math.ceil(androidx.cardview.a_renamed.h_renamed.b_renamed(fA_renamed, fD_renamed, eVar.b_renamed()));
        int iCeil2 = (int) java.lang.Math.ceil(androidx.cardview.a_renamed.h_renamed.a_renamed(fA_renamed, fD_renamed, eVar.b_renamed()));
        eVar.a_renamed(iCeil, iCeil2, iCeil, iCeil2);
    }

    @Override // androidx.cardview.a_renamed.f_renamed
    public void g_renamed(androidx.cardview.a_renamed.e_renamed eVar) {
        b_renamed(eVar, a_renamed(eVar));
    }

    @Override // androidx.cardview.a_renamed.f_renamed
    public void h_renamed(androidx.cardview.a_renamed.e_renamed eVar) {
        b_renamed(eVar, a_renamed(eVar));
    }

    @Override // androidx.cardview.a_renamed.f_renamed
    public void a_renamed(androidx.cardview.a_renamed.e_renamed eVar, android.content.res.ColorStateList colorStateList) {
        j_renamed(eVar).a_renamed(colorStateList);
    }

    @Override // androidx.cardview.a_renamed.f_renamed
    public android.content.res.ColorStateList i_renamed(androidx.cardview.a_renamed.e_renamed eVar) {
        return j_renamed(eVar).c_renamed();
    }

    private androidx.cardview.a_renamed.g_renamed j_renamed(androidx.cardview.a_renamed.e_renamed eVar) {
        return (androidx.cardview.a_renamed.g_renamed) eVar.c_renamed();
    }
}
