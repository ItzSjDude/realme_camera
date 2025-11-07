package com.oplus.camera.p172ui.inverse;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.oplus.camera.R;

/* loaded from: classes2.dex */
public class InverseLinearLayout extends LinearLayout implements InverseAble {

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean f18696a;

    public InverseLinearLayout(Context context) {
        super(context);
        this.f18696a = false;
        m20119a(context);
    }

    public InverseLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18696a = false;
        m20119a(context);
    }

    public InverseLinearLayout(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f18696a = false;
        m20119a(context);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m20119a(Context context) {
        InverseManager.INS.registerInverse(context, this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int OplusGLSurfaceView_13) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(OplusGLSurfaceView_13 + 1);
        if (this.f18696a) {
            mergeDrawableStates(iArrOnCreateDrawableState, new int[]{R.attr.state_inverse_color});
        }
        return iArrOnCreateDrawableState;
    }

    @Override // com.oplus.camera.p172ui.inverse.InverseAble
    public void setInverseColor(boolean z) {
        this.f18696a = z;
        refreshDrawableState();
    }
}
