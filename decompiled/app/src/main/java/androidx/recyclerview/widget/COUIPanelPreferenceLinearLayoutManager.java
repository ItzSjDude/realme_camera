package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public class COUIPanelPreferenceLinearLayoutManager extends androidx.recyclerview.widget.LinearLayoutManager {
    public COUIPanelPreferenceLinearLayoutManager(android.content.Context context) {
        super(context);
    }

    public COUIPanelPreferenceLinearLayoutManager(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        super(context, attributeSet, i_renamed, i2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i_renamed
    public int computeVerticalScrollRange(androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        return super.computeVerticalScrollRange(tVar) + this.mRecyclerView.getScrollY();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i_renamed
    public int computeVerticalScrollOffset(androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        return super.computeVerticalScrollOffset(tVar) + this.mRecyclerView.getScrollY();
    }
}
