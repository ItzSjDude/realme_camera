package com.oplus.camera.timelapsepro;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import androidx.core.p027a.ContextCompat;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.inverse.InverseTextView;

/* compiled from: EqualWidthNumberTextView.java */
/* renamed from: com.oplus.camera.timelapsepro.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class EqualWidthNumberTextView extends InverseTextView {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Paint f16692a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final int[] f16693b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f16694c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f16695d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f16696e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private float[] f16697f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private String f16698g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private float f16699h;

    public EqualWidthNumberTextView(Context context) {
        this(context, null);
    }

    public EqualWidthNumberTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EqualWidthNumberTextView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f16693b = new int[10];
        this.f16694c = 0;
        this.f16695d = 0;
        this.f16696e = 0;
        this.f16697f = null;
        this.f16692a = new Paint();
        this.f16692a.setAntiAlias(true);
        this.f16692a.setShadowLayer(getResources().getDimensionPixelSize(R.dimen.camera_time_split_shadow_radius_size), getResources().getDimensionPixelSize(R.dimen.camera_time_split_shadow_dx), getResources().getDimensionPixelSize(R.dimen.camera_time_split_shadow_dy), ContextCompat.m2254c(context, R.color.color_black_with_20_percent_transparency));
    }

    @Override // android.widget.TextView
    public void setTextColor(int OplusGLSurfaceView_13) {
        super.setTextColor(OplusGLSurfaceView_13);
        this.f16692a.setColor(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17430a(Typeface typeface, int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) {
        setTextSize(OplusGLSurfaceView_13, COUIBaseListPopupWindow_12);
        this.f16692a.setTypeface(typeface);
        this.f16692a.setTextSize(getTextSize());
        float[] fArr = new float[1];
        for (int i2 = 0; i2 < 10; i2++) {
            this.f16692a.getTextWidths(String.valueOf(i2), fArr);
            this.f16693b[i2] = (int) fArr[0];
            if (this.f16694c < fArr[0]) {
                this.f16694c = (int) fArr[0];
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private float m17428a(String str) {
        float[] fArr = new float[1];
        this.f16692a.getTextWidths(str, fArr);
        return fArr[0];
    }

    public void setTextToDraw(String str) {
        this.f16698g = str;
        this.f16695d = 0;
        this.f16697f = new float[str.length()];
        this.f16692a.getTextWidths(str, this.f16697f);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < str.length(); OplusGLSurfaceView_13++) {
            CameraLog.m12954a("EqualWidthNumberTextView", "setTextToDraw, char : " + str.charAt(OplusGLSurfaceView_13) + ", width: " + this.f16697f[OplusGLSurfaceView_13]);
            if (str.charAt(OplusGLSurfaceView_13) >= '0' && str.charAt(OplusGLSurfaceView_13) <= '9') {
                this.f16695d += this.f16694c;
            } else {
                this.f16697f[OplusGLSurfaceView_13] = m17428a(String.valueOf(str.charAt(OplusGLSurfaceView_13)));
                this.f16695d = (int) (this.f16695d + this.f16697f[OplusGLSurfaceView_13]);
            }
        }
        Paint.FontMetrics fontMetrics = this.f16692a.getFontMetrics();
        if (getIncludeFontPadding()) {
            this.f16696e = (int) (fontMetrics.bottom - fontMetrics.top);
            this.f16699h = -fontMetrics.top;
        } else {
            this.f16696e = (int) (fontMetrics.descent - fontMetrics.ascent);
            this.f16699h = -fontMetrics.ascent;
        }
        CameraLog.m12954a("EqualWidthNumberTextView", "setTextToDraw, setWidth : " + this.f16695d);
        setWidth(this.f16695d);
        setHeight(this.f16696e);
        m17429b(str);
        invalidate();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m17429b(String str) {
        Rect rect = new Rect();
        int OplusGLSurfaceView_13 = 0;
        int iWidth = 0;
        while (OplusGLSurfaceView_13 < str.length()) {
            int i2 = OplusGLSurfaceView_13 + 1;
            this.f16692a.getTextBounds(str, OplusGLSurfaceView_13, i2, rect);
            iWidth += rect.width();
            OplusGLSurfaceView_13 = i2;
        }
        float[] fArr = new float[str.length()];
        this.f16692a.getTextWidths(str, fArr);
        CameraLog.m12954a("EqualWidthNumberTextView", "log, ----------------");
        CameraLog.m12954a("EqualWidthNumberTextView", "log, text : " + str);
        for (int i3 = 0; i3 < str.length(); i3++) {
            CameraLog.m12954a("EqualWidthNumberTextView", "log, char: " + str.charAt(i3) + ", width: " + fArr[i3]);
        }
        this.f16692a.getTextBounds(str, 0, str.length(), rect);
        CameraLog.m12954a("EqualWidthNumberTextView", "log, rect.width length : " + rect.width());
        CameraLog.m12954a("EqualWidthNumberTextView", "log, measureText : " + this.f16692a.measureText(str));
        CameraLog.m12954a("EqualWidthNumberTextView", "log, textWidth : " + iWidth);
        CameraLog.m12954a("EqualWidthNumberTextView", "log, textHeight : " + (rect.bottom + rect.height()));
        CameraLog.m12954a("EqualWidthNumberTextView", "log, rect : " + rect);
        CameraLog.m12954a("EqualWidthNumberTextView", "log, fontSpacing : " + this.f16692a.getFontSpacing());
        Paint.FontMetrics fontMetrics = this.f16692a.getFontMetrics();
        CameraLog.m12954a("EqualWidthNumberTextView", "log, fontMetrics : top: " + fontMetrics.top + ", ascent: " + fontMetrics.ascent + ", leading: " + fontMetrics.leading + ", descent: " + fontMetrics.descent + ", bottom: " + fontMetrics.bottom);
    }

    @Override // android.view.View
    protected void onSizeChanged(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        super.onSizeChanged(OplusGLSurfaceView_13, i2, i3, i4);
        CameraLog.m12962c("EqualWidthNumberTextView", "onSizeChanged, w: " + OplusGLSurfaceView_13 + ", COUIBaseListPopupWindow_10: " + i2 + ", oldw: " + i3 + ", oldh: " + i4);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        int OplusGLSurfaceView_13 = 0;
        for (int i2 = 0; i2 < this.f16698g.length(); i2++) {
            int i3 = (this.f16698g.charAt(i2) < '0' || this.f16698g.charAt(i2) > '9') ? OplusGLSurfaceView_13 : ((this.f16694c - this.f16693b[this.f16698g.charAt(i2) - '0']) / 2) + OplusGLSurfaceView_13;
            canvas.drawText(String.valueOf(this.f16698g.charAt(i2)), i3, this.f16699h, this.f16692a);
            CameraLog.m12954a("EqualWidthNumberTextView", "onDraw, OplusGLSurfaceView_13 : " + i2 + ", char: " + this.f16698g.charAt(i2) + ", x: " + OplusGLSurfaceView_13 + ", drawX: " + i3);
            if (this.f16698g.charAt(i2) >= '0' && this.f16698g.charAt(i2) <= '9') {
                OplusGLSurfaceView_13 += this.f16694c;
            } else {
                OplusGLSurfaceView_13 = (int) (OplusGLSurfaceView_13 + this.f16697f[i2]);
            }
        }
        canvas.restore();
    }
}
