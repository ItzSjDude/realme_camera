package com.oplus.camera.ui.menu.a_renamed;

/* compiled from: ModeArrangeDecoration.java */
/* loaded from: classes2.dex */
public class d_renamed extends androidx.recyclerview.widget.RecyclerView.h_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f6349a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f6350b = 0;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f6351c = 0;
    private final java.lang.String d_renamed = "ModeArrangeDecoration";

    public d_renamed() {
        this.f6349a = 0;
        this.f6349a = (int) (com.oplus.camera.util.Util.h_renamed(com.oplus.camera.R_renamed.dimen.headline_recycle_view_item_padding_left_right) + com.oplus.camera.util.Util.h_renamed(com.oplus.camera.R_renamed.dimen.headline_recycle_view_text_padding_left_right));
    }

    public void a_renamed(int i_renamed) {
        this.f6350b = i_renamed / 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h_renamed
    public void getItemOffsets(android.graphics.Rect rect, android.view.View view, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        androidx.recyclerview.widget.RecyclerView.a_renamed adapter = recyclerView.getAdapter();
        if (adapter == null) {
            return;
        }
        int i_renamed = this.f6351c;
        if (1 == i_renamed) {
            super.getItemOffsets(rect, view, recyclerView, tVar);
            if (recyclerView.getChildAdapterPosition(view) == 0 && a_renamed(adapter) > 0) {
                rect.top = a_renamed(adapter);
                return;
            } else {
                if (recyclerView.getChildAdapterPosition(view) != adapter.getItemCount() - 1 || a_renamed(adapter) <= 0) {
                    return;
                }
                rect.bottom = a_renamed(adapter);
                return;
            }
        }
        if (3 == i_renamed) {
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = ((com.oplus.camera.util.Util.getScreenWidth() / 4) - this.f6350b) - this.f6349a;
                rect.right = 0;
                return;
            } else if (recyclerView.getChildAdapterPosition(view) == adapter.getItemCount() - 1) {
                rect.left = 0;
                rect.right = ((com.oplus.camera.util.Util.getScreenWidth() / 4) - this.f6350b) - this.f6349a;
                return;
            } else {
                rect.left = 0;
                rect.right = 0;
                return;
            }
        }
        if (recyclerView.getChildAdapterPosition(view) == 0) {
            rect.left = ((com.oplus.camera.util.Util.getScreenWidth() / 2) - this.f6350b) - this.f6349a;
            rect.right = 0;
        } else if (recyclerView.getChildAdapterPosition(view) == adapter.getItemCount() - 1) {
            rect.left = 0;
            rect.right = ((com.oplus.camera.util.Util.getScreenWidth() / 2) - this.f6350b) - this.f6349a;
        } else {
            rect.left = 0;
            rect.right = 0;
        }
    }

    public void b_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.b_renamed("ModeArrangeDecoration", "setLayoutMode, " + i_renamed);
        this.f6351c = i_renamed;
        int i2 = this.f6351c;
        if (i2 == 3 || i2 == 4) {
            this.f6349a = (int) (com.oplus.camera.util.Util.h_renamed(com.oplus.camera.R_renamed.dimen.fold_headline_recycle_view_item_padding_left_right) + com.oplus.camera.util.Util.h_renamed(com.oplus.camera.R_renamed.dimen.headline_recycle_view_text_padding_left_right));
        } else {
            this.f6349a = (int) (com.oplus.camera.util.Util.h_renamed(com.oplus.camera.R_renamed.dimen.headline_recycle_view_item_padding_left_right) + com.oplus.camera.util.Util.h_renamed(com.oplus.camera.R_renamed.dimen.headline_recycle_view_text_padding_left_right));
        }
    }

    private int a_renamed(androidx.recyclerview.widget.RecyclerView.a_renamed aVar) {
        return (((int) com.oplus.camera.util.Util.h_renamed(com.oplus.camera.R_renamed.dimen.mode_edit_head_line_vertical_height)) - ((aVar.getItemCount() * ((int) (com.oplus.camera.util.Util.h_renamed(com.oplus.camera.R_renamed.dimen.headline_recycle_view_item_height) + com.oplus.camera.util.Util.h_renamed(com.oplus.camera.R_renamed.dimen.mode_edit_head_line_vertical_item_gap)))) - ((int) com.oplus.camera.util.Util.h_renamed(com.oplus.camera.R_renamed.dimen.mode_edit_head_line_vertical_item_gap)))) / 2;
    }
}
