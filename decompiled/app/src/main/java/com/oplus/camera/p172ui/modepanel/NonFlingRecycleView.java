package com.oplus.camera.p172ui.modepanel;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public class NonFlingRecycleView extends RecyclerView {
    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean fling(int OplusGLSurfaceView_13, int i2) {
        return false;
    }

    public NonFlingRecycleView(Context context) {
        super(context);
    }

    public NonFlingRecycleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
