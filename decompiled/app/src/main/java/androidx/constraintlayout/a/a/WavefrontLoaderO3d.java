package androidx.constraintlayout.a_renamed.a_renamed;

/* compiled from: ResolutionNode.java */
/* loaded from: classes.dex */
public class o_renamed {
    java.util.HashSet<androidx.constraintlayout.a_renamed.a_renamed.o_renamed> h_renamed = new java.util.HashSet<>(2);
    int i_renamed = 0;

    public void a_renamed() {
    }

    public void a_renamed(androidx.constraintlayout.a_renamed.a_renamed.o_renamed oVar) {
        this.h_renamed.add(oVar);
    }

    public void b_renamed() {
        this.i_renamed = 0;
        this.h_renamed.clear();
    }

    public void e_renamed() {
        this.i_renamed = 0;
        java.util.Iterator<androidx.constraintlayout.a_renamed.a_renamed.o_renamed> it = this.h_renamed.iterator();
        while (it.hasNext()) {
            it.next().e_renamed();
        }
    }

    public void f_renamed() {
        this.i_renamed = 1;
        java.util.Iterator<androidx.constraintlayout.a_renamed.a_renamed.o_renamed> it = this.h_renamed.iterator();
        while (it.hasNext()) {
            it.next().a_renamed();
        }
    }

    public boolean g_renamed() {
        return this.i_renamed == 1;
    }
}
