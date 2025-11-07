package com.oplus.camera.p172ui.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.oplus.camera.R;
import com.oplus.camera.util.Util;

/* compiled from: XPanExposureTickDrawable.java */
/* renamed from: com.oplus.camera.ui.widget.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public class XPanExposureTickDrawable extends Drawable {

    /* renamed from: PlatformImplementations.kt_3 */
    private final float f22908a = Util.m24472l().getResources().getDimensionPixelSize(R.dimen.xpan_mode_exposure_wheel_tick_width);

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final int f22909b = Util.m24472l().getResources().getDimensionPixelSize(R.dimen.xpan_mode_exposure_wheel_tick_space);

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final int f22910c = Util.m24472l().getResources().getDimensionPixelSize(R.dimen.xpan_mode_exposure_wheel_tick_short);

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final int f22911d = Util.m24472l().getResources().getDimensionPixelSize(R.dimen.xpan_mode_exposure_wheel_tick_long);

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final int f22912e = Util.m24472l().getResources().getDimensionPixelSize(R.dimen.xpan_mode_exposure_wheel_tick_center);

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final int f22913f = 19;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f22914g = 9;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private Paint f22915h = new Paint(1);

    /* renamed from: OplusGLSurfaceView_13 */
    private Paint f22916i = new Paint(this.f22915h);

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

    public XPanExposureTickDrawable() {
        this.f22915h.setStyle(Paint.Style.STROKE);
        this.f22915h.setStrokeWidth(this.f22908a);
        this.f22915h.setColor(-1);
        this.f22915h.setAlpha(102);
        this.f22916i.setStyle(Paint.Style.STROKE);
        this.f22916i.setStrokeWidth(this.f22908a);
        this.f22916i.setColor(-1);
        this.f22916i.setAlpha(255);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < 19; OplusGLSurfaceView_13++) {
            int i2 = this.f22910c;
            if (OplusGLSurfaceView_13 == 9) {
                i2 = this.f22912e;
            } else if (OplusGLSurfaceView_13 % 3 == 0) {
                i2 = this.f22911d;
            }
            float COUIBaseListPopupWindow_12 = bounds.left + (this.f22908a / 2.0f) + (this.f22909b * OplusGLSurfaceView_13);
            float f2 = bounds.top + this.f22912e;
            canvas.drawLine(COUIBaseListPopupWindow_12, f2, COUIBaseListPopupWindow_12, f2 - i2, m24147b(OplusGLSurfaceView_13));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Paint m24147b(int OplusGLSurfaceView_13) {
        int i2 = this.f22914g;
        if (i2 == 9) {
            if (OplusGLSurfaceView_13 == 9) {
                return this.f22916i;
            }
            return this.f22915h;
        }
        if (i2 > 9) {
            if (OplusGLSurfaceView_13 >= 9 && OplusGLSurfaceView_13 <= i2) {
                return this.f22916i;
            }
            return this.f22915h;
        }
        if (OplusGLSurfaceView_13 >= i2 && OplusGLSurfaceView_13 <= 9) {
            return this.f22916i;
        }
        return this.f22915h;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24148a(int OplusGLSurfaceView_13) {
        this.f22914g = OplusGLSurfaceView_13;
    }
}
