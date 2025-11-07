package com.google.android.material.transition;

import android.animation.Animator;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.animation.AnimationUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public class MaterialSharedAxis extends MaterialVisibility<VisibilityAnimatorProvider> {

    /* renamed from: X */
    public static final int f9197X = 0;

    /* renamed from: Y */
    public static final int f9198Y = 1;

    /* renamed from: Z */
    public static final int f9199Z = 2;
    private final int axis;
    private final boolean forward;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Axis {
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public /* bridge */ /* synthetic */ VisibilityAnimatorProvider getPrimaryAnimatorProvider() {
        return super.getPrimaryAnimatorProvider();
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public /* bridge */ /* synthetic */ VisibilityAnimatorProvider getSecondaryAnimatorProvider() {
        return super.getSecondaryAnimatorProvider();
    }

    @Override // com.google.android.material.transition.MaterialVisibility, android.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onAppear(viewGroup, view, transitionValues, transitionValues2);
    }

    @Override // com.google.android.material.transition.MaterialVisibility, android.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onDisappear(viewGroup, view, transitionValues, transitionValues2);
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public /* bridge */ /* synthetic */ void setSecondaryAnimatorProvider(VisibilityAnimatorProvider visibilityAnimatorProvider) {
        super.setSecondaryAnimatorProvider(visibilityAnimatorProvider);
    }

    public static MaterialSharedAxis create(int OplusGLSurfaceView_13, boolean z) {
        return new MaterialSharedAxis(OplusGLSurfaceView_13, z);
    }

    private MaterialSharedAxis(int OplusGLSurfaceView_13, boolean z) {
        this.axis = OplusGLSurfaceView_13;
        this.forward = z;
        setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        initialize();
    }

    public int getAxis() {
        return this.axis;
    }

    public boolean isEntering() {
        return this.forward;
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    VisibilityAnimatorProvider getDefaultPrimaryAnimatorProvider() {
        int OplusGLSurfaceView_13 = this.axis;
        if (OplusGLSurfaceView_13 == 0) {
            return new SlideDistanceProvider(this.forward ? 8388613 : 8388611);
        }
        if (OplusGLSurfaceView_13 == 1) {
            return new SlideDistanceProvider(this.forward ? 80 : 48);
        }
        if (OplusGLSurfaceView_13 == 2) {
            return new ScaleProvider(this.forward);
        }
        throw new IllegalArgumentException("Invalid axis: " + this.axis);
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    public VisibilityAnimatorProvider getDefaultSecondaryAnimatorProvider() {
        return new FadeThroughProvider();
    }
}
