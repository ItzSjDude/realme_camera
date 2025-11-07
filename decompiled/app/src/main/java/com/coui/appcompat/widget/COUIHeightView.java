package com.coui.appcompat.widget;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class COUIHeightView {

    /* renamed from: PlatformImplementations.kt_3 */
    private View f7317a;

    public void setHeight(int OplusGLSurfaceView_13) {
        View view = this.f7317a;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = OplusGLSurfaceView_13;
            this.f7317a.setLayoutParams(layoutParams);
        }
    }

    public int getHeight() {
        View view = this.f7317a;
        if (view != null) {
            return view.getHeight();
        }
        return 0;
    }
}
