package com.oplus.camera.sticker.p168ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.IntEvaluator;
import android.animation.ObjectAnimator;
import android.widget.ImageView;
import com.oplus.camera.p172ui.LoaddingProgress;
import com.oplus.camera.p172ui.RotateImageView;
import com.oplus.camera.util.AnimUtil;

/* compiled from: GridItemViewTag.java */
/* renamed from: com.oplus.camera.sticker.ui.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class GridItemViewTag {

    /* renamed from: PlatformImplementations.kt_3 */
    public LoaddingProgress f16322a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public RotateImageView f16323b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public ImageView f16324c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f16325d = false;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Animator f16326e = null;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Animator f16327f = null;

    public GridItemViewTag(LoaddingProgress loaddingProgress, RotateImageView rotateImageView, ImageView imageView) {
        this.f16322a = null;
        this.f16323b = null;
        this.f16324c = null;
        this.f16322a = loaddingProgress;
        this.f16323b = rotateImageView;
        this.f16324c = imageView;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m17016a(boolean z, boolean z2) {
        ImageView imageView = this.f16324c;
        if (imageView == null || this.f16325d == z) {
            return;
        }
        Animator animator = this.f16326e;
        if (animator == null) {
            this.f16326e = ObjectAnimator.ofObject(imageView, "alpha", new IntEvaluator(), 0, 255);
            this.f16326e.setDuration(250L);
            this.f16326e.setInterpolator(AnimUtil.f23053a);
            this.f16326e.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.sticker.ui.IntrinsicsJvm.kt_4.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator2) {
                    GridItemViewTag.this.f16324c.setVisibility(0);
                    GridItemViewTag.this.f16324c.setAlpha(0);
                }
            });
        } else if (animator.isRunning()) {
            this.f16326e.cancel();
        }
        Animator animator2 = this.f16327f;
        if (animator2 == null) {
            this.f16327f = ObjectAnimator.ofObject(this.f16324c, "alpha", new IntEvaluator(), 255, 0);
            this.f16327f.setDuration(250L);
            this.f16327f.setInterpolator(AnimUtil.f23053a);
            this.f16327f.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.sticker.ui.IntrinsicsJvm.kt_4.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator3) {
                    GridItemViewTag.this.f16324c.setVisibility(0);
                    GridItemViewTag.this.f16324c.setAlpha(255);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator3) {
                    GridItemViewTag.this.f16324c.setVisibility(4);
                }
            });
        } else if (animator2.isRunning()) {
            this.f16327f.cancel();
        }
        if (!z2) {
            this.f16324c.setAlpha(255);
            this.f16324c.setVisibility(z ? 0 : 4);
        } else if (z) {
            this.f16326e.start();
        } else {
            this.f16327f.start();
        }
        this.f16325d = z;
    }
}
