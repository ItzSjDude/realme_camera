package androidx.recyclerview.widget;

/* compiled from: ScrollbarHelper.java */
/* loaded from: classes.dex */
class q_renamed {
    static int a_renamed(androidx.recyclerview.widget.RecyclerView.t_renamed tVar, androidx.recyclerview.widget.n_renamed nVar, android.view.View view, android.view.View view2, androidx.recyclerview.widget.RecyclerView.i_renamed iVar, boolean z_renamed, boolean z2) {
        int iMax;
        if (iVar.getChildCount() == 0 || tVar.e_renamed() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMin = java.lang.Math.min(iVar.getPosition(view), iVar.getPosition(view2));
        int iMax2 = java.lang.Math.max(iVar.getPosition(view), iVar.getPosition(view2));
        if (z2) {
            iMax = java.lang.Math.max(0, (tVar.e_renamed() - iMax2) - 1);
        } else {
            iMax = java.lang.Math.max(0, iMin);
        }
        if (!z_renamed) {
            return iMax;
        }
        return java.lang.Math.round((iMax * (java.lang.Math.abs(nVar.b_renamed(view2) - nVar.a_renamed(view)) / (java.lang.Math.abs(iVar.getPosition(view) - iVar.getPosition(view2)) + 1))) + (nVar.d_renamed() - nVar.a_renamed(view)));
    }

    static int a_renamed(androidx.recyclerview.widget.RecyclerView.t_renamed tVar, androidx.recyclerview.widget.n_renamed nVar, android.view.View view, android.view.View view2, androidx.recyclerview.widget.RecyclerView.i_renamed iVar, boolean z_renamed) {
        if (iVar.getChildCount() == 0 || tVar.e_renamed() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z_renamed) {
            return java.lang.Math.abs(iVar.getPosition(view) - iVar.getPosition(view2)) + 1;
        }
        return java.lang.Math.min(nVar.g_renamed(), nVar.b_renamed(view2) - nVar.a_renamed(view));
    }

    static int b_renamed(androidx.recyclerview.widget.RecyclerView.t_renamed tVar, androidx.recyclerview.widget.n_renamed nVar, android.view.View view, android.view.View view2, androidx.recyclerview.widget.RecyclerView.i_renamed iVar, boolean z_renamed) {
        if (iVar.getChildCount() == 0 || tVar.e_renamed() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z_renamed) {
            return tVar.e_renamed();
        }
        return (int) (((nVar.b_renamed(view2) - nVar.a_renamed(view)) / (java.lang.Math.abs(iVar.getPosition(view) - iVar.getPosition(view2)) + 1)) * tVar.e_renamed());
    }
}
