package com.oplus.camera.ui.inverse;

/* loaded from: classes2.dex */
public class InverseRelativeLayout extends android.widget.RelativeLayout implements com.oplus.camera.ui.inverse.a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private boolean f6242a;

    public InverseRelativeLayout(android.content.Context context) {
        super(context);
        this.f6242a = false;
        a_renamed(context);
    }

    public InverseRelativeLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6242a = false;
        a_renamed(context);
    }

    public InverseRelativeLayout(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f6242a = false;
        a_renamed(context);
    }

    private void a_renamed(android.content.Context context) {
        com.oplus.camera.ui.inverse.e_renamed.INS.registerInverse(context, this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i_renamed) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i_renamed + 1);
        if (this.f6242a) {
            mergeDrawableStates(iArrOnCreateDrawableState, new int[]{com.oplus.camera.R_renamed.attr.state_inverse_color});
        }
        return iArrOnCreateDrawableState;
    }

    @Override // com.oplus.camera.ui.inverse.a_renamed
    public void setInverseColor(boolean z_renamed) {
        this.f6242a = z_renamed;
        refreshDrawableState();
    }
}
