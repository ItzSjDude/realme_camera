package com.oplus.camera.p172ui;

import android.content.Context;
import android.util.AttributeSet;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.inverse.InverseTextView;

/* loaded from: classes2.dex */
public class HighLightInverseTextView extends InverseTextView {

    /* renamed from: PlatformImplementations.kt_3 */
    protected boolean f17120a;

    public HighLightInverseTextView(Context context) {
        super(context);
        this.f17120a = false;
    }

    public HighLightInverseTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17120a = false;
    }

    public HighLightInverseTextView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f17120a = false;
    }

    public void setHighLight(boolean z) {
        this.f17120a = z;
        refreshDrawableState();
        invalidate();
    }

    @Override // com.oplus.camera.p172ui.inverse.InverseTextView, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int OplusGLSurfaceView_13) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(OplusGLSurfaceView_13 + 1);
        if (this.f17120a) {
            mergeDrawableStates(iArrOnCreateDrawableState, new int[]{R.attr.state_high_light});
        }
        return iArrOnCreateDrawableState;
    }
}
