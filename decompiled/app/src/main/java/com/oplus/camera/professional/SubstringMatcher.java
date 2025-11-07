package com.oplus.camera.professional;

/* compiled from: ImageItem.java */
/* loaded from: classes2.dex */
public class k_renamed extends android.widget.RelativeLayout {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static int f5180a = 198;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.content.Context f5181b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.widget.ImageView f5182c;
    private com.oplus.camera.professional.w_renamed d_renamed;
    private int e_renamed;
    private int f_renamed;
    private int g_renamed;

    public void setItemViewDrawable(android.graphics.drawable.Drawable drawable) {
        this.f5182c.setImageDrawable(drawable);
        this.f5182c.measure(com.oplus.camera.util.Util.getScreenWidth(), com.oplus.camera.util.Util.U_renamed());
    }

    public void setItemValueText(java.lang.String str) {
        this.d_renamed.setText(str);
        this.d_renamed.setTypeface(com.oplus.camera.util.Util.l_renamed(this.f5181b));
        this.d_renamed.setContentDescription(str);
        this.d_renamed.measure(com.oplus.camera.util.Util.getScreenWidth(), com.oplus.camera.util.Util.U_renamed());
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
        int measuredWidth;
        int measuredHeight;
        int bottom;
        int i5;
        int i6;
        int i7 = i3 - i_renamed;
        int i8 = i4 - i2;
        com.oplus.camera.professional.w_renamed wVar = this.d_renamed;
        int i9 = 0;
        if (wVar != null) {
            measuredWidth = wVar.getMeasuredWidth();
            measuredHeight = this.d_renamed.getMeasuredHeight();
        } else {
            measuredWidth = 0;
            measuredHeight = 0;
        }
        android.widget.ImageView imageView = this.f5182c;
        if (imageView != null) {
            int measuredWidth2 = imageView.getMeasuredWidth();
            int measuredHeight2 = this.f5182c.getMeasuredHeight();
            int i10 = this.g_renamed;
            if (i10 == 90) {
                i6 = (((i7 - measuredHeight) - this.e_renamed) - measuredWidth2) / 2;
                bottom = (i8 - measuredHeight2) / 2;
            } else if (i10 == 270) {
                i6 = (((i7 + measuredHeight) + this.e_renamed) - measuredWidth2) / 2;
                bottom = (i8 - measuredHeight2) / 2;
            } else {
                i6 = (i7 - measuredWidth2) / 2;
                bottom = this.f_renamed;
            }
            this.f5182c.layout(i6, bottom, measuredWidth2 + i6, bottom + measuredHeight2);
            i9 = measuredHeight2;
        } else {
            bottom = 0;
        }
        if (this.d_renamed != null) {
            int i11 = this.g_renamed;
            if (i11 == 90) {
                i5 = (((i7 + i9) + this.e_renamed) - measuredWidth) / 2;
                bottom = (i8 - measuredHeight) / 2;
            } else if (i11 == 270) {
                i5 = (((i7 - i9) - this.e_renamed) - measuredWidth) / 2;
                bottom = (i8 - measuredHeight) / 2;
            } else {
                i5 = (i7 - measuredWidth) / 2;
                android.widget.ImageView imageView2 = this.f5182c;
                if (imageView2 != null) {
                    bottom = imageView2.getBottom() + this.e_renamed;
                }
            }
            this.d_renamed.layout(i5, bottom, measuredWidth + i5, measuredHeight + bottom);
        }
    }
}
