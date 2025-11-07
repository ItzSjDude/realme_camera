package com.coui.appcompat.preference;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.coui.appcompat.p099a.COUIRoundRectUtil;
import com.google.android.material.shape.MaterialShapeDrawable;

/* compiled from: COUIRecommendedDrawable.java */
/* renamed from: com.coui.appcompat.preference.COUIBaseListPopupWindow_12 */
/* loaded from: classes.dex */
public class COUIRecommendedDrawable extends MaterialShapeDrawable {

    /* renamed from: PlatformImplementations.kt_3 */
    private float f7083a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f7084b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Paint f7085c = new Paint(1);

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Path f7086d = new Path();

    public COUIRecommendedDrawable(float COUIBaseListPopupWindow_12, int OplusGLSurfaceView_13) {
        this.f7083a = COUIBaseListPopupWindow_12;
        this.f7084b = OplusGLSurfaceView_13;
        this.f7085c.setColor(this.f7084b);
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f7086d.reset();
        this.f7086d = COUIRoundRectUtil.m6450a().m6451a(getBounds(), this.f7083a);
        canvas.drawPath(this.f7086d, this.f7085c);
    }
}
