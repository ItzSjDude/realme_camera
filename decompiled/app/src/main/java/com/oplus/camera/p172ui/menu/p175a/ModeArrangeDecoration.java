package com.oplus.camera.p172ui.menu.p175a;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.util.Util;

/* compiled from: ModeArrangeDecoration.java */
/* renamed from: com.oplus.camera.ui.menu.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class ModeArrangeDecoration extends RecyclerView.AbstractC0692h {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f19020a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f19021b = 0;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f19022c = 0;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final String f19023d = "ModeArrangeDecoration";

    public ModeArrangeDecoration() {
        this.f19020a = 0;
        this.f19020a = (int) (Util.m24456h(R.dimen.headline_recycle_view_item_padding_left_right) + Util.m24456h(R.dimen.headline_recycle_view_text_padding_left_right));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20357a(int OplusGLSurfaceView_13) {
        this.f19021b = OplusGLSurfaceView_13 / 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0692h
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.C0704t c0704t) {
        RecyclerView.AbstractC0685a adapter = recyclerView.getAdapter();
        if (adapter == null) {
            return;
        }
        int OplusGLSurfaceView_13 = this.f19022c;
        if (1 == OplusGLSurfaceView_13) {
            super.getItemOffsets(rect, view, recyclerView, c0704t);
            if (recyclerView.getChildAdapterPosition(view) == 0 && m20356a(adapter) > 0) {
                rect.top = m20356a(adapter);
                return;
            } else {
                if (recyclerView.getChildAdapterPosition(view) != adapter.getItemCount() - 1 || m20356a(adapter) <= 0) {
                    return;
                }
                rect.bottom = m20356a(adapter);
                return;
            }
        }
        if (3 == OplusGLSurfaceView_13) {
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                rect.left = ((Util.getScreenWidth() / 4) - this.f19021b) - this.f19020a;
                rect.right = 0;
                return;
            } else if (recyclerView.getChildAdapterPosition(view) == adapter.getItemCount() - 1) {
                rect.left = 0;
                rect.right = ((Util.getScreenWidth() / 4) - this.f19021b) - this.f19020a;
                return;
            } else {
                rect.left = 0;
                rect.right = 0;
                return;
            }
        }
        if (recyclerView.getChildAdapterPosition(view) == 0) {
            rect.left = ((Util.getScreenWidth() / 2) - this.f19021b) - this.f19020a;
            rect.right = 0;
        } else if (recyclerView.getChildAdapterPosition(view) == adapter.getItemCount() - 1) {
            rect.left = 0;
            rect.right = ((Util.getScreenWidth() / 2) - this.f19021b) - this.f19020a;
        } else {
            rect.left = 0;
            rect.right = 0;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m20358b(int OplusGLSurfaceView_13) {
        CameraLog.m12959b("ModeArrangeDecoration", "setLayoutMode, " + OplusGLSurfaceView_13);
        this.f19022c = OplusGLSurfaceView_13;
        int i2 = this.f19022c;
        if (i2 == 3 || i2 == 4) {
            this.f19020a = (int) (Util.m24456h(R.dimen.fold_headline_recycle_view_item_padding_left_right) + Util.m24456h(R.dimen.headline_recycle_view_text_padding_left_right));
        } else {
            this.f19020a = (int) (Util.m24456h(R.dimen.headline_recycle_view_item_padding_left_right) + Util.m24456h(R.dimen.headline_recycle_view_text_padding_left_right));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m20356a(RecyclerView.AbstractC0685a abstractC0685a) {
        return (((int) Util.m24456h(R.dimen.mode_edit_head_line_vertical_height)) - ((abstractC0685a.getItemCount() * ((int) (Util.m24456h(R.dimen.headline_recycle_view_item_height) + Util.m24456h(R.dimen.mode_edit_head_line_vertical_item_gap)))) - ((int) Util.m24456h(R.dimen.mode_edit_head_line_vertical_item_gap)))) / 2;
    }
}
