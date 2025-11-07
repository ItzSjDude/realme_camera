package com.google.android.material.datepicker;

/* loaded from: classes.dex */
class SmoothCalendarLayoutManager extends androidx.recyclerview.widget.LinearLayoutManager {
    private static final float MILLISECONDS_PER_INCH = 100.0f;

    SmoothCalendarLayoutManager(android.content.Context context, int i_renamed, boolean z_renamed) {
        super(context, i_renamed, z_renamed);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i_renamed
    public void smoothScrollToPosition(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.t_renamed tVar, int i_renamed) {
        androidx.recyclerview.widget.j_renamed jVar = new androidx.recyclerview.widget.j_renamed(recyclerView.getContext()) { // from class: com.google.android.material.datepicker.SmoothCalendarLayoutManager.1
            @Override // androidx.recyclerview.widget.j_renamed
            protected float calculateSpeedPerPixel(android.util.DisplayMetrics displayMetrics) {
                return com.google.android.material.datepicker.SmoothCalendarLayoutManager.MILLISECONDS_PER_INCH / displayMetrics.densityDpi;
            }
        };
        jVar.setTargetPosition(i_renamed);
        startSmoothScroll(jVar);
    }
}
