package com.oplus.camera.ui.modepanel;

/* loaded from: classes2.dex */
public class NonFlingRecycleView extends androidx.recyclerview.widget.RecyclerView {
    @Override // androidx.recyclerview.widget.RecyclerView
    public boolean fling(int i_renamed, int i2) {
        return false;
    }

    public NonFlingRecycleView(android.content.Context context) {
        super(context);
    }

    public NonFlingRecycleView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
