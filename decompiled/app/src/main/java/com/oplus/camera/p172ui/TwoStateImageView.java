package com.oplus.camera.p172ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/* compiled from: TwoStateImageView.java */
/* renamed from: com.oplus.camera.ui.w */
/* loaded from: classes2.dex */
public class TwoStateImageView extends ImageView {

    /* renamed from: PlatformImplementations.kt_3 */
    private final float f22514a;

    public TwoStateImageView(Context context) {
        super(context);
        this.f22514a = 0.4f;
    }

    public TwoStateImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22514a = 0.4f;
    }

    public TwoStateImageView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f22514a = 0.4f;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            setAlpha(1.0f);
        } else {
            setAlpha(0.4f);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23921a(boolean z, boolean z2) {
        super.setEnabled(z);
        if (z) {
            setAlpha(1.0f);
        } else if (z2) {
            setAlpha(0.4f);
        }
    }
}
