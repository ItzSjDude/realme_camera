package androidx.recyclerview.widget;

import android.content.Context;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public class COUILinearLayoutManager extends LinearLayoutManager {
    public COUILinearLayoutManager(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13, i2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void scrollToPositionWithOffset(int OplusGLSurfaceView_13, int i2) {
        super.scrollToPositionWithOffset(OplusGLSurfaceView_13, i2 - this.mRecyclerView.getPaddingTop());
    }
}
