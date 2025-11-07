package com.oplus.camera.p172ui.menu.facebeauty;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.PathInterpolator;
import android.widget.RelativeLayout;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.inverse.InverseManager;
import com.oplus.camera.p172ui.inverse.InverseAble;

/* loaded from: classes2.dex */
public class FaceBeautyItemFrame extends RelativeLayout implements InverseAble {

    /* renamed from: PlatformImplementations.kt_3 */
    private final PathInterpolator f19152a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f19153b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f19154c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private ObjectAnimator f19155d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private ObjectAnimator f19156e;

    public FaceBeautyItemFrame(Context context) {
        this(context, null);
    }

    public FaceBeautyItemFrame(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceBeautyItemFrame(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f19152a = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f19153b = false;
        this.f19154c = false;
        this.f19155d = null;
        this.f19156e = null;
        m20490a(context);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m20490a(Context context) {
        InverseManager.INS.registerInverse(context, this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int OplusGLSurfaceView_13) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(OplusGLSurfaceView_13 + 1);
        if (this.f19153b) {
            mergeDrawableStates(iArrOnCreateDrawableState, new int[]{R.attr.state_inverse_color});
        }
        return iArrOnCreateDrawableState;
    }

    @Override // com.oplus.camera.p172ui.inverse.InverseAble
    public void setInverseColor(boolean z) {
        this.f19153b = z;
        refreshDrawableState();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20493a(boolean z, boolean z2) {
        if (z2) {
            setSelected(z);
            return;
        }
        super.setSelected(z);
        Drawable background = getBackground();
        if (background != null) {
            background.setAlpha(255);
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z) {
        boolean z2 = this.f19154c;
        this.f19154c = z;
        if (z2 != z) {
            ObjectAnimator objectAnimator = this.f19155d;
            if (objectAnimator != null && objectAnimator.isStarted()) {
                this.f19155d.cancel();
            }
            ObjectAnimator objectAnimator2 = this.f19156e;
            if (objectAnimator2 != null && objectAnimator2.isStarted()) {
                this.f19156e.cancel();
            }
            if (z) {
                super.setSelected(true);
                m20489a();
            } else {
                m20492b();
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m20489a() {
        CameraLog.m12954a("FaceBeautyItemFrame", "executeShowAnimator");
        Drawable background = getBackground();
        if (background != null) {
            this.f19155d = ObjectAnimator.ofInt(background, "alpha", 0, 255);
            this.f19155d.setInterpolator(this.f19152a);
            this.f19155d.setDuration(180L);
            this.f19155d.start();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m20492b() {
        CameraLog.m12954a("FaceBeautyItemFrame", "executeHideAnimator");
        Drawable background = getBackground();
        if (background != null) {
            this.f19156e = ObjectAnimator.ofInt(background, "alpha", 255, 0);
            this.f19156e.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.menu.facebeauty.FaceBeautyItemFrame.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    FaceBeautyItemFrame.super.setSelected(false);
                }
            });
            this.f19156e.setInterpolator(this.f19152a);
            this.f19156e.setDuration(180L);
            this.f19156e.start();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        InverseManager.INS.registerInverse(getContext(), this);
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ObjectAnimator objectAnimator = this.f19155d;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            this.f19155d.cancel();
            this.f19155d.removeAllListeners();
        }
        ObjectAnimator objectAnimator2 = this.f19156e;
        if (objectAnimator2 != null && objectAnimator2.isStarted()) {
            this.f19156e.cancel();
            this.f19156e.removeAllListeners();
            this.f19156e.removeAllUpdateListeners();
        }
        this.f19155d = null;
        this.f19156e = null;
        InverseManager.INS.unRegisterInverse(getContext(), this);
        super.onDetachedFromWindow();
    }
}
