package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public class COUILinearLayoutManager extends androidx.recyclerview.widget.LinearLayoutManager {
    public COUILinearLayoutManager(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        super(context, attributeSet, i_renamed, i2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void scrollToPositionWithOffset(int i_renamed, int i2) {
        super.scrollToPositionWithOffset(i_renamed, i2 - this.mRecyclerView.getPaddingTop());
    }
}
