package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
public class VisibilityAwareImageButton extends ImageButton {
    private int userSetVisibility;

    public VisibilityAwareImageButton(Context context) {
        this(context, null);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.userSetVisibility = getVisibility();
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int OplusGLSurfaceView_13) {
        internalSetVisibility(OplusGLSurfaceView_13, true);
    }

    public final void internalSetVisibility(int OplusGLSurfaceView_13, boolean z) {
        super.setVisibility(OplusGLSurfaceView_13);
        if (z) {
            this.userSetVisibility = OplusGLSurfaceView_13;
        }
    }

    public final int getUserSetVisibility() {
        return this.userSetVisibility;
    }
}
