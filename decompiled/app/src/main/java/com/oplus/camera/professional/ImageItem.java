package com.oplus.camera.professional;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.oplus.camera.util.Util;

/* compiled from: ImageItem.java */
/* renamed from: com.oplus.camera.professional.OplusGLSurfaceView_5 */
/* loaded from: classes2.dex */
public class ImageItem extends RelativeLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    public static int f15584a = 198;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Context f15585b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private ImageView f15586c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private ProfessionalTextView f15587d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f15588e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f15589f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f15590g;

    public void setItemViewDrawable(Drawable drawable) {
        this.f15586c.setImageDrawable(drawable);
        this.f15586c.measure(Util.getScreenWidth(), Util.m24193U());
    }

    public void setItemValueText(String str) {
        this.f15587d.setText(str);
        this.f15587d.setTypeface(Util.m24473l(this.f15585b));
        this.f15587d.setContentDescription(str);
        this.f15587d.measure(Util.getScreenWidth(), Util.m24193U());
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        int measuredWidth;
        int measuredHeight;
        int bottom;
        int i5;
        int i6;
        int i7 = i3 - OplusGLSurfaceView_13;
        int i8 = i4 - i2;
        ProfessionalTextView c2905w = this.f15587d;
        int i9 = 0;
        if (c2905w != null) {
            measuredWidth = c2905w.getMeasuredWidth();
            measuredHeight = this.f15587d.getMeasuredHeight();
        } else {
            measuredWidth = 0;
            measuredHeight = 0;
        }
        ImageView imageView = this.f15586c;
        if (imageView != null) {
            int measuredWidth2 = imageView.getMeasuredWidth();
            int measuredHeight2 = this.f15586c.getMeasuredHeight();
            int i10 = this.f15590g;
            if (i10 == 90) {
                i6 = (((i7 - measuredHeight) - this.f15588e) - measuredWidth2) / 2;
                bottom = (i8 - measuredHeight2) / 2;
            } else if (i10 == 270) {
                i6 = (((i7 + measuredHeight) + this.f15588e) - measuredWidth2) / 2;
                bottom = (i8 - measuredHeight2) / 2;
            } else {
                i6 = (i7 - measuredWidth2) / 2;
                bottom = this.f15589f;
            }
            this.f15586c.layout(i6, bottom, measuredWidth2 + i6, bottom + measuredHeight2);
            i9 = measuredHeight2;
        } else {
            bottom = 0;
        }
        if (this.f15587d != null) {
            int i11 = this.f15590g;
            if (i11 == 90) {
                i5 = (((i7 + i9) + this.f15588e) - measuredWidth) / 2;
                bottom = (i8 - measuredHeight) / 2;
            } else if (i11 == 270) {
                i5 = (((i7 - i9) - this.f15588e) - measuredWidth) / 2;
                bottom = (i8 - measuredHeight) / 2;
            } else {
                i5 = (i7 - measuredWidth) / 2;
                ImageView imageView2 = this.f15586c;
                if (imageView2 != null) {
                    bottom = imageView2.getBottom() + this.f15588e;
                }
            }
            this.f15587d.layout(i5, bottom, measuredWidth + i5, measuredHeight + bottom);
        }
    }
}
