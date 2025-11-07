package com.google.android.material.transformation;

@java.lang.Deprecated
/* loaded from: classes.dex */
public abstract class ExpandableTransformationBehavior extends com.google.android.material.transformation.ExpandableBehavior {
    private android.animation.AnimatorSet currentAnimation;

    protected abstract android.animation.AnimatorSet onCreateExpandedStateChangeAnimation(android.view.View view, android.view.View view2, boolean z_renamed, boolean z2);

    public ExpandableTransformationBehavior() {
    }

    public ExpandableTransformationBehavior(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior
    protected boolean onExpandedStateChange(android.view.View view, android.view.View view2, boolean z_renamed, boolean z2) {
        boolean z3 = this.currentAnimation != null;
        if (z3) {
            this.currentAnimation.cancel();
        }
        this.currentAnimation = onCreateExpandedStateChangeAnimation(view, view2, z_renamed, z3);
        this.currentAnimation.addListener(new android.animation.AnimatorListenerAdapter() { // from class: com.google.android.material.transformation.ExpandableTransformationBehavior.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
                com.google.android.material.transformation.ExpandableTransformationBehavior.this.currentAnimation = null;
            }
        });
        this.currentAnimation.start();
        if (!z2) {
            this.currentAnimation.end();
        }
        return true;
    }
}
