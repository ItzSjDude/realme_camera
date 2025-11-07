package androidx.constraintlayout.a_renamed.a_renamed;

/* compiled from: WidgetContainer.java */
/* loaded from: classes.dex */
public class q_renamed extends androidx.constraintlayout.a_renamed.a_renamed.f_renamed {
    protected java.util.ArrayList<androidx.constraintlayout.a_renamed.a_renamed.f_renamed> az_renamed = new java.util.ArrayList<>();

    @Override // androidx.constraintlayout.a_renamed.a_renamed.f_renamed
    public void g_renamed() {
        this.az_renamed.clear();
        super.g_renamed();
    }

    public void b_renamed(androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar) {
        this.az_renamed.add(fVar);
        if (fVar.l_renamed() != null) {
            ((androidx.constraintlayout.a_renamed.a_renamed.q_renamed) fVar.l_renamed()).c_renamed(fVar);
        }
        fVar.a_renamed((androidx.constraintlayout.a_renamed.a_renamed.f_renamed) this);
    }

    public void c_renamed(androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar) {
        this.az_renamed.remove(fVar);
        fVar.a_renamed((androidx.constraintlayout.a_renamed.a_renamed.f_renamed) null);
    }

    public androidx.constraintlayout.a_renamed.a_renamed.g_renamed T_renamed() {
        androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVarL = l_renamed();
        androidx.constraintlayout.a_renamed.a_renamed.g_renamed gVar = this instanceof androidx.constraintlayout.a_renamed.a_renamed.g_renamed ? (androidx.constraintlayout.a_renamed.a_renamed.g_renamed) this : null;
        while (fVarL != null) {
            androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVarL2 = fVarL.l_renamed();
            if (fVarL instanceof androidx.constraintlayout.a_renamed.a_renamed.g_renamed) {
                gVar = (androidx.constraintlayout.a_renamed.a_renamed.g_renamed) fVarL;
            }
            fVarL = fVarL2;
        }
        return gVar;
    }

    @Override // androidx.constraintlayout.a_renamed.a_renamed.f_renamed
    public void b_renamed(int i_renamed, int i2) {
        super.b_renamed(i_renamed, i2);
        int size = this.az_renamed.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.az_renamed.get(i3).b_renamed(w_renamed(), x_renamed());
        }
    }

    @Override // androidx.constraintlayout.a_renamed.a_renamed.f_renamed
    public void E_renamed() {
        super.E_renamed();
        java.util.ArrayList<androidx.constraintlayout.a_renamed.a_renamed.f_renamed> arrayList = this.az_renamed;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar = this.az_renamed.get(i_renamed);
            fVar.b_renamed(u_renamed(), v_renamed());
            if (!(fVar instanceof androidx.constraintlayout.a_renamed.a_renamed.g_renamed)) {
                fVar.E_renamed();
            }
        }
    }

    public void N_renamed() {
        E_renamed();
        java.util.ArrayList<androidx.constraintlayout.a_renamed.a_renamed.f_renamed> arrayList = this.az_renamed;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            androidx.constraintlayout.a_renamed.a_renamed.f_renamed fVar = this.az_renamed.get(i_renamed);
            if (fVar instanceof androidx.constraintlayout.a_renamed.a_renamed.q_renamed) {
                ((androidx.constraintlayout.a_renamed.a_renamed.q_renamed) fVar).N_renamed();
            }
        }
    }

    @Override // androidx.constraintlayout.a_renamed.a_renamed.f_renamed
    public void a_renamed(androidx.constraintlayout.a_renamed.c_renamed cVar) {
        super.a_renamed(cVar);
        int size = this.az_renamed.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            this.az_renamed.get(i_renamed).a_renamed(cVar);
        }
    }

    public void U_renamed() {
        this.az_renamed.clear();
    }
}
