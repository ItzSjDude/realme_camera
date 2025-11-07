package com.oplus.camera.filmvideomode;

/* compiled from: FilmModeBarRecyclerView.java */
/* loaded from: classes2.dex */
public class i_renamed extends androidx.recyclerview.widget.COUIRecyclerView {
    private com.oplus.camera.filmvideomode.h_renamed f_renamed;

    public i_renamed(android.content.Context context) {
        super(context);
        this.f_renamed = null;
    }

    public void setOnItemClickListener(com.oplus.camera.filmvideomode.k_renamed.d_renamed dVar) {
        this.f_renamed.a_renamed(dVar);
    }

    public void a_renamed(int i_renamed, java.lang.String str) {
        this.f_renamed.a_renamed(i_renamed, str);
    }

    public void a_renamed(int i_renamed, java.lang.String str, boolean z_renamed) {
        android.view.View viewA = a_renamed(i_renamed);
        this.f_renamed.a_renamed(i_renamed, str);
        this.f_renamed.a_renamed(i_renamed, z_renamed);
        if (viewA != null) {
            this.f_renamed.a_renamed(viewA, str);
            if (com.oplus.camera.professional.x_renamed.a_renamed(i_renamed) && z_renamed) {
                if (viewA.isSelected()) {
                    this.f_renamed.a_renamed(viewA, 0, false);
                    return;
                } else {
                    this.f_renamed.a_renamed(viewA, 0, true);
                    return;
                }
            }
            this.f_renamed.a_renamed(viewA, 8, true);
            return;
        }
        com.oplus.camera.filmvideomode.h_renamed hVar = this.f_renamed;
        hVar.notifyItemChanged(hVar.b_renamed(i_renamed));
    }

    public void a_renamed(int i_renamed, boolean z_renamed, boolean z2) {
        android.view.View viewA = a_renamed(i_renamed);
        if (viewA != null) {
            if (viewA instanceof com.oplus.camera.filmvideomode.d_renamed) {
                com.oplus.camera.filmvideomode.d_renamed dVar = (com.oplus.camera.filmvideomode.d_renamed) viewA;
                dVar.b_renamed(z_renamed, true);
                dVar.a_renamed(z2 ? 0 : 8, true);
                return;
            }
            viewA.setEnabled(z_renamed);
            return;
        }
        com.oplus.camera.filmvideomode.h_renamed hVar = this.f_renamed;
        hVar.notifyItemChanged(hVar.b_renamed(i_renamed));
    }

    @Override // android.view.View
    public boolean isSelected() {
        return getSelectedPosition() != -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(androidx.recyclerview.widget.RecyclerView.a_renamed aVar) {
        super.setAdapter(aVar);
        this.f_renamed = (com.oplus.camera.filmvideomode.h_renamed) aVar;
    }

    public android.view.View a_renamed(int i_renamed) {
        androidx.recyclerview.widget.RecyclerView.w_renamed wVarFindViewHolderForAdapterPosition = findViewHolderForAdapterPosition(this.f_renamed.b_renamed(i_renamed));
        if (wVarFindViewHolderForAdapterPosition != null) {
            return wVarFindViewHolderForAdapterPosition.itemView;
        }
        return null;
    }

    public int getSelectedPosition() {
        com.oplus.camera.filmvideomode.h_renamed hVar = this.f_renamed;
        return hVar.b_renamed(hVar.b_renamed());
    }
}
