package com.oplus.camera.ui.inverse;

/* loaded from: classes2.dex */
public class InverseTextView extends android.widget.TextView implements com.oplus.camera.ui.inverse.a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private boolean f6243a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f6244b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f6245c;
    private com.oplus.camera.ui.inverse.d_renamed d_renamed;

    public InverseTextView(android.content.Context context) {
        super(context);
        this.f6243a = false;
        this.f6244b = 0;
        this.f6245c = false;
        this.d_renamed = null;
        a_renamed(context);
    }

    public InverseTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6243a = false;
        this.f6244b = 0;
        this.f6245c = false;
        this.d_renamed = null;
        a_renamed(context);
    }

    public InverseTextView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f6243a = false;
        this.f6244b = 0;
        this.f6245c = false;
        this.d_renamed = null;
        a_renamed(context);
    }

    private void a_renamed(android.content.Context context) {
        com.oplus.camera.ui.inverse.e_renamed.INS.registerInverse(context, this);
    }

    @Override // android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i_renamed) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i_renamed + 1);
        if (this.f6243a && b_renamed()) {
            mergeDrawableStates(iArrOnCreateDrawableState, new int[]{com.oplus.camera.R_renamed.attr.state_inverse_color});
        }
        return iArrOnCreateDrawableState;
    }

    private boolean b_renamed() {
        int i_renamed;
        com.oplus.camera.ui.inverse.d_renamed dVar = this.d_renamed;
        boolean z_renamed = dVar == null || dVar.inverseAble();
        return this.f6245c ? z_renamed : (!z_renamed || (i_renamed = this.f6244b) == 90 || i_renamed == 270) ? false : true;
    }

    public void setInverseColor(boolean z_renamed) {
        this.f6243a = z_renamed;
        refreshDrawableState();
    }

    public boolean a_renamed() {
        return this.f6243a;
    }

    public void setOrientation(int i_renamed) {
        this.f6244b = i_renamed;
        refreshDrawableState();
    }

    public void setHorizontalInverseAble(boolean z_renamed) {
        this.f6245c = z_renamed;
    }

    public void setInverseListener(com.oplus.camera.ui.inverse.d_renamed dVar) {
        this.d_renamed = dVar;
        postInvalidate();
    }
}
