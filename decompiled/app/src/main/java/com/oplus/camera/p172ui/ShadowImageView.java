package com.oplus.camera.p172ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.ImageView;
import com.oplus.camera.R;
import com.oplus.camera.util.Util;

/* compiled from: ShadowImageView.java */
/* renamed from: com.oplus.camera.ui.u */
/* loaded from: classes2.dex */
public class ShadowImageView extends ImageView {

    /* renamed from: PlatformImplementations.kt_3 */
    int f22505a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    int f22506b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Paint f22507c;

    public ShadowImageView(Context context) throws Resources.NotFoundException {
        super(context);
        m23914a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23914a() throws Resources.NotFoundException {
        float fM24202a = Util.m24202a(getContext(), R.dimen.level_panel_text_shadow_radius, Util.f22962a);
        int color = getResources().getColor(R.color.color_black_with_20_percent_transparency);
        setLayerType(1, null);
        this.f22507c = new Paint();
        this.f22507c.setMaskFilter(new BlurMaskFilter(fM24202a, BlurMaskFilter.Blur.OUTER));
        this.f22507c.setStyle(Paint.Style.FILL);
        this.f22507c.setColor(color);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        super.onLayout(z, OplusGLSurfaceView_13, i2, i3, i4);
        this.f22505a = OplusGLSurfaceView_13;
        this.f22506b = i2;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmapM24374b = Util.m24374b(getDrawable());
        canvas.drawBitmap(Bitmap.createScaledBitmap(bitmapM24374b.extractAlpha(), bitmapM24374b.getWidth(), bitmapM24374b.getHeight(), true), this.f22505a, this.f22506b, this.f22507c);
        super.onDraw(canvas);
    }
}
