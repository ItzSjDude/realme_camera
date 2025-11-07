package com.oplus.camera.ui;

/* loaded from: classes2.dex */
public class HighLightInverseTextView extends com.oplus.camera.ui.inverse.InverseTextView {

    /* renamed from: a_renamed, reason: collision with root package name */
    protected boolean f5759a;

    public HighLightInverseTextView(android.content.Context context) {
        super(context);
        this.f5759a = false;
    }

    public HighLightInverseTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5759a = false;
    }

    public HighLightInverseTextView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f5759a = false;
    }

    public void setHighLight(boolean z_renamed) {
        this.f5759a = z_renamed;
        refreshDrawableState();
        invalidate();
    }

    @Override // com.oplus.camera.ui.inverse.InverseTextView, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i_renamed) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i_renamed + 1);
        if (this.f5759a) {
            mergeDrawableStates(iArrOnCreateDrawableState, new int[]{com.oplus.camera.R_renamed.attr.state_high_light});
        }
        return iArrOnCreateDrawableState;
    }
}
