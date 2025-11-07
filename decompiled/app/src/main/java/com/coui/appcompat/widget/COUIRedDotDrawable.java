package com.coui.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.coui.appcompat.p099a.COUIHintRedDotHelper;
import coui.support.appcompat.R;

/* compiled from: COUIRedDotDrawable.java */
/* renamed from: com.coui.appcompat.widget.OplusGLSurfaceView_6 */
/* loaded from: classes.dex */
public class COUIRedDotDrawable extends Drawable {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f8363a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f8364b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private COUIHintRedDotHelper f8365c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private RectF f8366d;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int OplusGLSurfaceView_13) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public COUIRedDotDrawable(int OplusGLSurfaceView_13, int i2, Context context, RectF rectF) {
        this.f8363a = OplusGLSurfaceView_13;
        this.f8364b = i2;
        this.f8366d = rectF;
        this.f8365c = new COUIHintRedDotHelper(context, null, R.styleable.COUIHintRedDot, 0, R.style.Widget_COUI_COUIHintRedDot_Small);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f8365c.m6415a(canvas, this.f8363a, this.f8364b, this.f8366d);
    }
}
