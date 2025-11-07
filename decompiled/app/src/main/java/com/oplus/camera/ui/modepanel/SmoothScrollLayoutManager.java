package com.oplus.camera.ui.modepanel;

/* loaded from: classes2.dex */
public class SmoothScrollLayoutManager extends androidx.recyclerview.widget.LinearLayoutManager {
    public SmoothScrollLayoutManager(android.content.Context context, int i_renamed, boolean z_renamed) {
        super(context, i_renamed, z_renamed);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i_renamed
    public void smoothScrollToPosition(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.t_renamed tVar, int i_renamed) {
        androidx.recyclerview.widget.j_renamed jVar = new androidx.recyclerview.widget.j_renamed(recyclerView.getContext()) { // from class: com.oplus.camera.ui.modepanel.SmoothScrollLayoutManager.1
            @Override // androidx.recyclerview.widget.j_renamed
            protected float calculateSpeedPerPixel(android.util.DisplayMetrics displayMetrics) {
                return 150.0f / displayMetrics.densityDpi;
            }
        };
        jVar.setTargetPosition(i_renamed);
        startSmoothScroll(jVar);
    }
}
