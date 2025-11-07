package com.oplus.camera.p172ui.modepanel;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public class SmoothScrollLayoutManager extends LinearLayoutManager {
    public SmoothScrollLayoutManager(Context context, int OplusGLSurfaceView_13, boolean z) {
        super(context, OplusGLSurfaceView_13, z);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.C0704t c0704t, int OplusGLSurfaceView_13) {
        LinearSmoothScroller c0723j = new LinearSmoothScroller(recyclerView.getContext()) { // from class: com.oplus.camera.ui.modepanel.SmoothScrollLayoutManager.1
            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return 150.0f / displayMetrics.densityDpi;
            }
        };
        c0723j.setTargetPosition(OplusGLSurfaceView_13);
        startSmoothScroll(c0723j);
    }
}
