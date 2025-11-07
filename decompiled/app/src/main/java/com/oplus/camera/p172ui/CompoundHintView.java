package com.oplus.camera.p172ui;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.PathInterpolator;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.menu.OplusTextView;

/* compiled from: CompoundHintView.java */
/* renamed from: com.oplus.camera.ui.COUIBaseListPopupWindow_12 */
/* loaded from: classes2.dex */
public class CompoundHintView {

    /* renamed from: COUIBaseListPopupWindow_8 */
    private CharSequence f18662e;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final OplusTextView f18665h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final OplusTextView f18666i;

    /* renamed from: PlatformImplementations.kt_3 */
    private PathInterpolator f18658a = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f18659b = -1;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f18660c = -1;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f18661d = -1;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f18663f = 0;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f18664g = false;

    public CompoundHintView(ViewGroup viewGroup) {
        this.f18665h = (OplusTextView) viewGroup.findViewById(R.id_renamed.camera_screen_hint_text);
        this.f18666i = (OplusTextView) viewGroup.findViewById(R.id_renamed.camera_screen_aux_hint_text);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20067a() {
        OplusTextView oplusTextView = this.f18665h;
        if (oplusTextView != null) {
            this.f18663f = oplusTextView.getMeasuredHeight();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m20074a(CharSequence charSequence) {
        CameraLog.m12967f("CompoundHintView", "setText:" + ((Object) charSequence));
        if (this.f18666i != null) {
            CharSequence charSequenceM20075b = m20075b();
            if (!TextUtils.equals(this.f18662e, charSequenceM20075b)) {
                this.f18666i.setText(charSequenceM20075b);
                this.f18666i.clearAnimation();
                this.f18666i.setVisibility(4);
            }
            this.f18662e = null;
        }
        OplusTextView oplusTextView = this.f18665h;
        if (oplusTextView != null) {
            oplusTextView.setText(charSequence);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public CharSequence m20075b() {
        OplusTextView oplusTextView = this.f18665h;
        return oplusTextView != null ? oplusTextView.getText() : "";
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20068a(float COUIBaseListPopupWindow_12) {
        OplusTextView oplusTextView = this.f18665h;
        if (oplusTextView != null) {
            oplusTextView.setAlpha(COUIBaseListPopupWindow_12);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20069a(int OplusGLSurfaceView_13) {
        OplusTextView oplusTextView = this.f18665h;
        if (oplusTextView != null) {
            oplusTextView.setVisibility(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int m20078c() {
        OplusTextView oplusTextView = this.f18665h;
        if (oplusTextView != null) {
            return oplusTextView.getVisibility();
        }
        return 8;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m20081d() {
        OplusTextView oplusTextView = this.f18665h;
        return oplusTextView != null && oplusTextView.getVisibility() == 0;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m20082e() {
        OplusTextView oplusTextView = this.f18665h;
        if (oplusTextView != null) {
            return oplusTextView.isShown();
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20072a(int OplusGLSurfaceView_13, boolean z) {
        OplusTextView oplusTextView = this.f18666i;
        if (oplusTextView != null) {
            oplusTextView.m20302a(OplusGLSurfaceView_13, z);
            this.f18666i.invalidate();
        }
        OplusTextView oplusTextView2 = this.f18665h;
        if (oplusTextView2 != null) {
            oplusTextView2.m20302a(OplusGLSurfaceView_13, z);
            this.f18665h.invalidate();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public OplusTextView m20083f() {
        return this.f18665h;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m20076b(int OplusGLSurfaceView_13) {
        OplusTextView oplusTextView = this.f18665h;
        if (oplusTextView == null || -1 == OplusGLSurfaceView_13 || oplusTextView.getBackground() == null) {
            return;
        }
        this.f18665h.setBackgroundResource(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20071a(int OplusGLSurfaceView_13, int i2, int i3) {
        if (this.f18666i != null) {
            int i4 = this.f18660c;
            if (i4 == -1) {
                i4 = OplusGLSurfaceView_13;
            }
            this.f18666i.setBackgroundResource(i4);
            int i5 = this.f18661d;
            if (i5 == -1) {
                i5 = i2;
            }
            OplusTextView oplusTextView = this.f18666i;
            oplusTextView.setTextColor(oplusTextView.getResources().getColor(i5));
        }
        this.f18660c = OplusGLSurfaceView_13;
        this.f18661d = i2;
        OplusTextView oplusTextView2 = this.f18665h;
        if (oplusTextView2 == null || -1 == i2 || i2 == 0) {
            return;
        }
        if (-1 != i3 && OplusGLSurfaceView_13 != 0) {
            oplusTextView2.setBackgroundResource(i3);
        } else {
            this.f18665h.setBackgroundResource(OplusGLSurfaceView_13);
        }
        OplusTextView oplusTextView3 = this.f18665h;
        oplusTextView3.setTextColor(oplusTextView3.getResources().getColor(i2));
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m20079c(int OplusGLSurfaceView_13) {
        if (this.f18666i != null) {
            int i2 = this.f18659b;
            if (i2 == -1) {
                i2 = OplusGLSurfaceView_13;
            }
            if (i2 == 0) {
                OplusTextView oplusTextView = this.f18666i;
                oplusTextView.setShadowLayer(4.0f, 0.0f, 0.0f, oplusTextView.getResources().getColor(R.color.color_black_with_70_percent_transparency));
            } else {
                this.f18666i.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
        }
        this.f18659b = OplusGLSurfaceView_13;
        OplusTextView oplusTextView2 = this.f18665h;
        if (oplusTextView2 != null) {
            if (OplusGLSurfaceView_13 == 0) {
                oplusTextView2.setShadowLayer(4.0f, 0.0f, 0.0f, oplusTextView2.getResources().getColor(R.color.color_black_with_70_percent_transparency));
            } else {
                oplusTextView2.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m20084g() {
        OplusTextView oplusTextView = this.f18666i;
        if (oplusTextView != null) {
            oplusTextView.clearAnimation();
            this.f18666i.setVisibility(4);
        }
        OplusTextView oplusTextView2 = this.f18665h;
        if (oplusTextView2 != null) {
            oplusTextView2.clearAnimation();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m20085h() {
        OplusTextView oplusTextView = this.f18666i;
        if (oplusTextView != null) {
            oplusTextView.setText((CharSequence) null);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20073a(Animation animation, boolean z) {
        OplusTextView oplusTextView = this.f18666i;
        if (oplusTextView != null) {
            if (!z) {
                this.f18662e = this.f18665h.getText();
                this.f18666i.setText((CharSequence) null);
                this.f18666i.clearAnimation();
                this.f18666i.setVisibility(4);
            } else if (!TextUtils.isEmpty(oplusTextView.getText().toString())) {
                animation.setStartOffset(150L);
                this.f18666i.clearAnimation();
                this.f18666i.setVisibility(0);
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setInterpolator(this.f18658a);
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.oplus.camera.ui.COUIBaseListPopupWindow_12.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation2) {
                        CompoundHintView.this.f18664g = true;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation2) {
                        CompoundHintView.this.f18664g = false;
                        CompoundHintView.this.f18666i.setVisibility(4);
                    }
                });
                this.f18666i.startAnimation(alphaAnimation);
            }
        }
        OplusTextView oplusTextView2 = this.f18665h;
        if (oplusTextView2 != null) {
            oplusTextView2.startAnimation(animation);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final void m20070a(int OplusGLSurfaceView_13, int i2) {
        OplusTextView oplusTextView = this.f18665h;
        if (oplusTextView != null) {
            oplusTextView.measure(OplusGLSurfaceView_13, i2);
        }
        OplusTextView oplusTextView2 = this.f18666i;
        if (oplusTextView2 != null) {
            oplusTextView2.measure(OplusGLSurfaceView_13, i2);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m20077b(int OplusGLSurfaceView_13, int i2, int i3) {
        int measuredWidth = OplusGLSurfaceView_13 - (this.f18666i.getMeasuredWidth() / 2);
        int measuredHeight = i2 - (this.f18666i.getMeasuredHeight() / 2);
        int measuredHeight2 = (this.f18663f - this.f18666i.getMeasuredHeight()) / 2;
        if (i3 == 90) {
            measuredWidth -= measuredHeight2;
        } else if (i3 != 270) {
            measuredHeight -= measuredHeight2;
        } else {
            measuredWidth += measuredHeight2;
        }
        OplusTextView oplusTextView = this.f18666i;
        oplusTextView.layout(measuredWidth, measuredHeight, oplusTextView.getMeasuredWidth() + measuredWidth, this.f18666i.getMeasuredHeight() + measuredHeight);
        int measuredWidth2 = OplusGLSurfaceView_13 - (this.f18665h.getMeasuredWidth() / 2);
        int measuredHeight3 = i2 - (this.f18665h.getMeasuredHeight() / 2);
        OplusTextView oplusTextView2 = this.f18665h;
        oplusTextView2.layout(measuredWidth2, measuredHeight3, oplusTextView2.getMeasuredWidth() + measuredWidth2, this.f18665h.getMeasuredHeight() + measuredHeight3);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public int m20086i() {
        OplusTextView oplusTextView = this.f18665h;
        if (oplusTextView != null) {
            return oplusTextView.getViewWidth();
        }
        return 0;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public int m20087j() {
        OplusTextView oplusTextView = this.f18665h;
        if (oplusTextView != null) {
            return oplusTextView.getViewHeight();
        }
        return 0;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public final int m20088k() {
        OplusTextView oplusTextView = this.f18665h;
        if (oplusTextView != null) {
            return oplusTextView.getMeasuredWidth();
        }
        return 0;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public final int m20089l() {
        OplusTextView oplusTextView = this.f18665h;
        if (oplusTextView != null) {
            return oplusTextView.getMeasuredHeight();
        }
        return 0;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m20080d(int OplusGLSurfaceView_13) {
        OplusTextView oplusTextView = this.f18666i;
        if (oplusTextView != null) {
            oplusTextView.setMaxWidth(OplusGLSurfaceView_13);
        }
        OplusTextView oplusTextView2 = this.f18665h;
        if (oplusTextView2 != null) {
            oplusTextView2.setMaxWidth(OplusGLSurfaceView_13);
        }
    }
}
