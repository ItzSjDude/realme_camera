package androidx.recyclerview.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class COUIPanelPreferenceLinearLayoutManager extends LinearLayoutManager {
    public COUIPanelPreferenceLinearLayoutManager(Context context) {
        super(context);
    }

    public COUIPanelPreferenceLinearLayoutManager(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13, i2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public int computeVerticalScrollRange(RecyclerView.C0704t c0704t) {
        return super.computeVerticalScrollRange(c0704t) + this.mRecyclerView.getScrollY();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public int computeVerticalScrollOffset(RecyclerView.C0704t c0704t) {
        return super.computeVerticalScrollOffset(c0704t) + this.mRecyclerView.getScrollY();
    }
}
