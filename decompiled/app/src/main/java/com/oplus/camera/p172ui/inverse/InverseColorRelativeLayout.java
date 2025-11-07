package com.oplus.camera.p172ui.inverse;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.oplus.camera.util.BackgroundUtil;

/* loaded from: classes2.dex */
public class InverseColorRelativeLayout extends RelativeLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean f18691a;

    public InverseColorRelativeLayout(Context context) {
        super(context);
        this.f18691a = false;
        m20116a(context);
    }

    public InverseColorRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18691a = false;
        m20116a(context);
    }

    public InverseColorRelativeLayout(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f18691a = false;
        m20116a(context);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m20116a(Context context) {
        InverseManager.INS.registerBackgroundInverse(context, this, false);
    }

    @Override // android.view.View
    public void setBackgroundColor(int OplusGLSurfaceView_13) {
        int backgroundColor = InverseManager.INS.getBackgroundColor(this, BackgroundUtil.m24523a(OplusGLSurfaceView_13));
        if (this.f18691a) {
            backgroundColor = 0;
        }
        super.setBackgroundColor(backgroundColor);
    }

    public void setBackgroundAlwaysTransparent(boolean z) {
        this.f18691a = z;
    }
}
