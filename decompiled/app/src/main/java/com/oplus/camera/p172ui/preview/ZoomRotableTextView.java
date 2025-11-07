package com.oplus.camera.p172ui.preview;

import android.animation.Animator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.RotableTextView;
import com.oplus.camera.util.AnimUtil;
import com.oplus.camera.util.Util;

/* compiled from: ZoomRotableTextView.java */
/* renamed from: com.oplus.camera.ui.preview.ah */
/* loaded from: classes2.dex */
public class ZoomRotableTextView extends RotableTextView {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f21693a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f21694b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f21695c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f21696d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Animator f21697e;

    public ZoomRotableTextView(Context context) {
        this(context, null);
    }

    public ZoomRotableTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ZoomRotableTextView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        this(context, attributeSet, OplusGLSurfaceView_13, 0);
    }

    public ZoomRotableTextView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13, i2);
        this.f21693a = 0;
        this.f21694b = 0;
        this.f21695c = 0;
        this.f21696d = 0;
        this.f21697e = null;
        this.f21694b = Util.m24164A(getContext());
        this.f21693a = getContext().getColor(R.color.color_white_with_15_percent_transparency);
        this.f21696d = getContext().getColor(R.color.color_black_with_full_percent_transparency);
        this.f21695c = getContext().getColor(R.color.color_white_with_full_percent_transparency);
        setTextColor(this.f21695c);
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        drawable.setTint(this.f21693a);
        super.setBackground(drawable);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        Animator animator = this.f21697e;
        if (animator != null && animator.isRunning()) {
            this.f21697e.cancel();
        }
        this.f21697e = null;
        super.onDetachedFromWindow();
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean z) {
        boolean zIsSelected = isSelected();
        super.setSelected(z);
        if (zIsSelected != z) {
            Animator animator = this.f21697e;
            if (animator != null && animator.isRunning()) {
                this.f21697e.cancel();
            }
            this.f21697e = AnimUtil.m24518a(this, z ? this.f21696d : this.f21695c, z ? this.f21694b : this.f21693a);
            Animator animator2 = this.f21697e;
            if (animator2 != null) {
                animator2.start();
            }
        }
    }
}
