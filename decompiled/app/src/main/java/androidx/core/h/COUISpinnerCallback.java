package androidx.core.h_renamed;

/* compiled from: NestedScrollingParentHelper.java */
/* loaded from: classes.dex */
public class p_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f986a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f987b;

    public p_renamed(android.view.ViewGroup viewGroup) {
    }

    public void a_renamed(android.view.View view, android.view.View view2, int i_renamed) {
        a_renamed(view, view2, i_renamed, 0);
    }

    public void a_renamed(android.view.View view, android.view.View view2, int i_renamed, int i2) {
        if (i2 == 1) {
            this.f987b = i_renamed;
        } else {
            this.f986a = i_renamed;
        }
    }

    public int a_renamed() {
        return this.f987b | this.f986a;
    }

    public void a_renamed(android.view.View view, int i_renamed) {
        if (i_renamed == 1) {
            this.f987b = 0;
        } else {
            this.f986a = 0;
        }
    }
}
