package com.oplus.camera.ui;

/* compiled from: ShadowImageView.java */
/* loaded from: classes2.dex */
public class u_renamed extends android.widget.ImageView {

    /* renamed from: a_renamed, reason: collision with root package name */
    int f7180a;

    /* renamed from: b_renamed, reason: collision with root package name */
    int f7181b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.graphics.Paint f7182c;

    public u_renamed(android.content.Context context) throws android.content.res.Resources.NotFoundException {
        super(context);
        a_renamed();
    }

    private void a_renamed() throws android.content.res.Resources.NotFoundException {
        float fA_renamed = com.oplus.camera.util.Util.a_renamed(getContext(), com.oplus.camera.R_renamed.dimen.level_panel_text_shadow_radius, com.oplus.camera.util.Util.f7297a);
        int color = getResources().getColor(com.oplus.camera.R_renamed.color.color_black_with_20_percent_transparency);
        setLayerType(1, null);
        this.f7182c = new android.graphics.Paint();
        this.f7182c.setMaskFilter(new android.graphics.BlurMaskFilter(fA_renamed, android.graphics.BlurMaskFilter.Blur.OUTER));
        this.f7182c.setStyle(android.graphics.Paint.Style.FILL);
        this.f7182c.setColor(color);
    }

    @Override // android.view.View
    protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
        super.onLayout(z_renamed, i_renamed, i2, i3, i4);
        this.f7180a = i_renamed;
        this.f7181b = i2;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        android.graphics.Bitmap bitmapB = com.oplus.camera.util.Util.b_renamed(getDrawable());
        canvas.drawBitmap(android.graphics.Bitmap.createScaledBitmap(bitmapB.extractAlpha(), bitmapB.getWidth(), bitmapB.getHeight(), true), this.f7180a, this.f7181b, this.f7182c);
        super.onDraw(canvas);
    }
}
