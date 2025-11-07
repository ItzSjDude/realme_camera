package com.coui.appcompat.widget.floatingbutton;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import androidx.core.graphics.ColorUtils;
import java.lang.ref.WeakReference;

/* compiled from: COUIFloatingButtonTouchAnimation.java */
/* renamed from: com.coui.appcompat.widget.floatingbutton.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public class COUIFloatingButtonTouchAnimation extends ScaleAnimation {

    /* renamed from: PlatformImplementations.kt_3 */
    private WeakReference<View> f8099a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final float f8100b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final float f8101c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private float f8102d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private float f8103e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f8104f;

    public COUIFloatingButtonTouchAnimation(float COUIBaseListPopupWindow_12, float f2, float f3, float f4) {
        super(COUIBaseListPopupWindow_12, f2, COUIBaseListPopupWindow_12, f2, f3, f4);
        this.f8104f = 0;
        this.f8100b = COUIBaseListPopupWindow_12;
        this.f8101c = f2;
    }

    @Override // android.view.animation.ScaleAnimation, android.view.animation.Animation
    protected void applyTransformation(float COUIBaseListPopupWindow_12, Transformation transformation) {
        int color;
        super.applyTransformation(COUIBaseListPopupWindow_12, transformation);
        float f2 = this.f8100b;
        this.f8102d = f2 + ((this.f8101c - f2) * COUIBaseListPopupWindow_12);
        WeakReference<View> weakReference = this.f8099a;
        if (weakReference != null) {
            View view = weakReference.get();
            ColorStateList backgroundTintList = view.getBackgroundTintList();
            if (backgroundTintList != null) {
                color = backgroundTintList.getDefaultColor();
            } else {
                color = view.getBackground() instanceof ColorDrawable ? ((ColorDrawable) view.getBackground()).getColor() : Integer.MIN_VALUE;
            }
            if (color != Integer.MIN_VALUE) {
                this.f8103e = m7763a(COUIBaseListPopupWindow_12);
                this.f8104f = m7764a(color, this.f8103e);
                view.getBackground().setTint(this.f8104f);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private float m7763a(float COUIBaseListPopupWindow_12) {
        float f2 = this.f8100b;
        float f3 = this.f8101c;
        if (f2 > f3) {
            return 1.0f + (COUIBaseListPopupWindow_12 * (-0.19999999f));
        }
        if (f2 < f3) {
            return (COUIBaseListPopupWindow_12 * 0.19999999f) + 0.8f;
        }
        return 1.0f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m7764a(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) {
        float[] fArr = new float[3];
        ColorUtils.m2549a(OplusGLSurfaceView_13, fArr);
        fArr[2] = fArr[2] * COUIBaseListPopupWindow_12;
        int iM2547a = ColorUtils.m2547a(fArr);
        return Color.argb(Color.alpha(iM2547a), Math.min(255, Color.red(iM2547a)), Math.min(255, Color.green(iM2547a)), Math.min(255, Color.blue(iM2547a)));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m7765a(View view) {
        this.f8099a = new WeakReference<>(view);
    }

    @Override // android.view.animation.Animation
    public int getBackgroundColor() {
        return this.f8104f;
    }
}
