package com.oplus.camera.p172ui.inverse;

import android.content.Context;
import android.util.AttributeSet;
import com.oplus.camera.R;
import com.oplus.camera.util.Util;

/* loaded from: classes2.dex */
public class InverseBeautifyTextView extends InverseTextView {
    public InverseBeautifyTextView(Context context) {
        super(context);
    }

    public InverseBeautifyTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InverseBeautifyTextView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        InverseManager.INS.registerInverse(getContext(), this);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        InverseManager.INS.unRegisterInverse(getContext(), this);
    }

    @Override // com.oplus.camera.p172ui.inverse.InverseTextView, com.oplus.camera.p172ui.inverse.InverseAble
    public void setInverseColor(boolean z) {
        setShadowLayer(Util.m24202a(getContext(), R.dimen.level_panel_text_shadow_radius, Util.f22962a), 0.0f, 0.0f, getResources().getColor(z ? R.color.color_black_with_0_percent_transparency : R.color.color_black_with_20_percent_transparency, null));
        super.setInverseColor(z);
    }
}
