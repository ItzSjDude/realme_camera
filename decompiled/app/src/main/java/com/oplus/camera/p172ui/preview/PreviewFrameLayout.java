package com.oplus.camera.p172ui.preview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/* loaded from: classes2.dex */
public class PreviewFrameLayout extends RelativeLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    private OnSizeChangedListener f20883a;

    public interface OnSizeChangedListener {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo22202a(int OplusGLSurfaceView_13, int i2, int i3, int i4);
    }

    public PreviewFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnSizeChangedListener(OnSizeChangedListener onSizeChangedListener) {
        this.f20883a = onSizeChangedListener;
    }

    @Override // android.view.View
    protected void onSizeChanged(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        OnSizeChangedListener onSizeChangedListener = this.f20883a;
        if (onSizeChangedListener != null) {
            onSizeChangedListener.mo22202a(OplusGLSurfaceView_13, i2, i3, i4);
        }
    }
}
