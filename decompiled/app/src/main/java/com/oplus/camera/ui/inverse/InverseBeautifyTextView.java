package com.oplus.camera.ui.inverse;

/* loaded from: classes2.dex */
public class InverseBeautifyTextView extends com.oplus.camera.ui.inverse.InverseTextView {
    public InverseBeautifyTextView(android.content.Context context) {
        super(context);
    }

    public InverseBeautifyTextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InverseBeautifyTextView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        com.oplus.camera.ui.inverse.e_renamed.INS.registerInverse(getContext(), this);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.oplus.camera.ui.inverse.e_renamed.INS.unRegisterInverse(getContext(), this);
    }

    @Override // com.oplus.camera.ui.inverse.InverseTextView, com.oplus.camera.ui.inverse.a_renamed
    public void setInverseColor(boolean z_renamed) {
        setShadowLayer(com.oplus.camera.util.Util.a_renamed(getContext(), com.oplus.camera.R_renamed.dimen.level_panel_text_shadow_radius, com.oplus.camera.util.Util.f7297a), 0.0f, 0.0f, getResources().getColor(z_renamed ? com.oplus.camera.R_renamed.color.color_black_with_0_percent_transparency : com.oplus.camera.R_renamed.color.color_black_with_20_percent_transparency, null));
        super.setInverseColor(z_renamed);
    }
}
