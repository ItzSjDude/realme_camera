package androidx.cardview.p024a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.cardview.R;

/* compiled from: RoundRectDrawableWithShadow.java */
/* renamed from: androidx.cardview.PlatformImplementations.kt_3.COUIBaseListPopupWindow_10 */
/* loaded from: classes.dex */
class RoundRectDrawableWithShadow extends Drawable {

    /* renamed from: PlatformImplementations.kt_3 */
    static PlatformImplementations.kt_3 f2152a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final double f2153b = Math.cos(Math.toRadians(45.0d));

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final int f2154c;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Paint f2156e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Paint f2157f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final RectF f2158g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private float f2159h;

    /* renamed from: OplusGLSurfaceView_13 */
    private Path f2160i;

    /* renamed from: OplusGLSurfaceView_15 */
    private float f2161j;

    /* renamed from: OplusGLSurfaceView_5 */
    private float f2162k;

    /* renamed from: OplusGLSurfaceView_14 */
    private float f2163l;

    /* renamed from: OplusGLSurfaceView_6 */
    private ColorStateList f2164m;

    /* renamed from: o */
    private final int f2166o;

    /* renamed from: p */
    private final int f2167p;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f2165n = true;

    /* renamed from: q */
    private boolean f2168q = true;

    /* renamed from: r */
    private boolean f2169r = false;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Paint f2155d = new Paint(5);

    /* compiled from: RoundRectDrawableWithShadow.java */
    /* renamed from: androidx.cardview.PlatformImplementations.kt_3.COUIBaseListPopupWindow_10$PlatformImplementations.kt_3 */
    interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo1843a(Canvas canvas, RectF rectF, float COUIBaseListPopupWindow_12, Paint paint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    RoundRectDrawableWithShadow(Resources resources, ColorStateList colorStateList, float COUIBaseListPopupWindow_12, float f2, float f3) {
        this.f2166o = resources.getColor(R.color.cardview_shadow_start_color);
        this.f2167p = resources.getColor(R.color.cardview_shadow_end_color);
        this.f2154c = resources.getDimensionPixelSize(R.dimen.cardview_compat_inset_shadow);
        m1874b(colorStateList);
        this.f2156e = new Paint(5);
        this.f2156e.setStyle(Paint.Style.FILL);
        this.f2159h = (int) (COUIBaseListPopupWindow_12 + 0.5f);
        this.f2158g = new RectF();
        this.f2157f = new Paint(this.f2156e);
        this.f2157f.setAntiAlias(false);
        m1871a(f2, f3);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m1874b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f2164m = colorStateList;
        this.f2155d.setColor(this.f2164m.getColorForState(getState(), this.f2164m.getDefaultColor()));
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int m1876d(float COUIBaseListPopupWindow_12) {
        int OplusGLSurfaceView_13 = (int) (COUIBaseListPopupWindow_12 + 0.5f);
        return OplusGLSurfaceView_13 % 2 == 1 ? OplusGLSurfaceView_13 - 1 : OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1882a(boolean z) {
        this.f2168q = z;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int OplusGLSurfaceView_13) {
        this.f2155d.setAlpha(OplusGLSurfaceView_13);
        this.f2156e.setAlpha(OplusGLSurfaceView_13);
        this.f2157f.setAlpha(OplusGLSurfaceView_13);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f2165n = true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m1871a(float COUIBaseListPopupWindow_12, float f2) {
        if (COUIBaseListPopupWindow_12 < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + COUIBaseListPopupWindow_12 + ". Must be >= 0");
        }
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("Invalid max shadow size " + f2 + ". Must be >= 0");
        }
        float fM1876d = m1876d(COUIBaseListPopupWindow_12);
        float fM1876d2 = m1876d(f2);
        if (fM1876d > fM1876d2) {
            if (!this.f2169r) {
                this.f2169r = true;
            }
            fM1876d = fM1876d2;
        }
        if (this.f2163l == fM1876d && this.f2161j == fM1876d2) {
            return;
        }
        this.f2163l = fM1876d;
        this.f2161j = fM1876d2;
        this.f2162k = (int) ((fM1876d * 1.5f) + this.f2154c + 0.5f);
        this.f2165n = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int iCeil = (int) Math.ceil(m1870a(this.f2161j, this.f2159h, this.f2168q));
        int iCeil2 = (int) Math.ceil(m1873b(this.f2161j, this.f2159h, this.f2168q));
        rect.set(iCeil2, iCeil, iCeil2, iCeil);
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static float m1870a(float COUIBaseListPopupWindow_12, float f2, boolean z) {
        return z ? (float) ((COUIBaseListPopupWindow_12 * 1.5f) + ((1.0d - f2153b) * f2)) : COUIBaseListPopupWindow_12 * 1.5f;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    static float m1873b(float COUIBaseListPopupWindow_12, float f2, boolean z) {
        return z ? (float) (COUIBaseListPopupWindow_12 + ((1.0d - f2153b) * f2)) : COUIBaseListPopupWindow_12;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.f2164m;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f2155d.getColor() == colorForState) {
            return false;
        }
        this.f2155d.setColor(colorForState);
        this.f2165n = true;
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.f2164m;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f2155d.setColorFilter(colorFilter);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1879a(float COUIBaseListPopupWindow_12) {
        if (COUIBaseListPopupWindow_12 < 0.0f) {
            throw new IllegalArgumentException("Invalid radius " + COUIBaseListPopupWindow_12 + ". Must be >= 0");
        }
        float f2 = (int) (COUIBaseListPopupWindow_12 + 0.5f);
        if (this.f2159h == f2) {
            return;
        }
        this.f2159h = f2;
        this.f2165n = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f2165n) {
            m1875b(getBounds());
            this.f2165n = false;
        }
        canvas.translate(0.0f, this.f2163l / 2.0f);
        m1872a(canvas);
        canvas.translate(0.0f, (-this.f2163l) / 2.0f);
        f2152a.mo1843a(canvas, this.f2158g, this.f2159h, this.f2155d);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m1872a(Canvas canvas) {
        float COUIBaseListPopupWindow_12 = this.f2159h;
        float f2 = (-COUIBaseListPopupWindow_12) - this.f2162k;
        float f3 = COUIBaseListPopupWindow_12 + this.f2154c + (this.f2163l / 2.0f);
        float f4 = f3 * 2.0f;
        boolean z = this.f2158g.width() - f4 > 0.0f;
        boolean z2 = this.f2158g.height() - f4 > 0.0f;
        int iSave = canvas.save();
        canvas.translate(this.f2158g.left + f3, this.f2158g.top + f3);
        canvas.drawPath(this.f2160i, this.f2156e);
        if (z) {
            canvas.drawRect(0.0f, f2, this.f2158g.width() - f4, -this.f2159h, this.f2157f);
        }
        canvas.restoreToCount(iSave);
        int iSave2 = canvas.save();
        canvas.translate(this.f2158g.right - f3, this.f2158g.bottom - f3);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f2160i, this.f2156e);
        if (z) {
            canvas.drawRect(0.0f, f2, this.f2158g.width() - f4, (-this.f2159h) + this.f2162k, this.f2157f);
        }
        canvas.restoreToCount(iSave2);
        int iSave3 = canvas.save();
        canvas.translate(this.f2158g.left + f3, this.f2158g.bottom - f3);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f2160i, this.f2156e);
        if (z2) {
            canvas.drawRect(0.0f, f2, this.f2158g.height() - f4, -this.f2159h, this.f2157f);
        }
        canvas.restoreToCount(iSave3);
        int iSave4 = canvas.save();
        canvas.translate(this.f2158g.right - f3, this.f2158g.top + f3);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f2160i, this.f2156e);
        if (z2) {
            canvas.drawRect(0.0f, f2, this.f2158g.height() - f4, -this.f2159h, this.f2157f);
        }
        canvas.restoreToCount(iSave4);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m1877g() {
        float COUIBaseListPopupWindow_12 = this.f2159h;
        RectF rectF = new RectF(-COUIBaseListPopupWindow_12, -COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12);
        RectF rectF2 = new RectF(rectF);
        float f2 = this.f2162k;
        rectF2.inset(-f2, -f2);
        Path path = this.f2160i;
        if (path == null) {
            this.f2160i = new Path();
        } else {
            path.reset();
        }
        this.f2160i.setFillType(Path.FillType.EVEN_ODD);
        this.f2160i.moveTo(-this.f2159h, 0.0f);
        this.f2160i.rLineTo(-this.f2162k, 0.0f);
        this.f2160i.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f2160i.arcTo(rectF, 270.0f, -90.0f, false);
        this.f2160i.close();
        float f3 = this.f2159h;
        float f4 = this.f2162k;
        float f5 = f3 / (f3 + f4);
        Paint paint = this.f2156e;
        float f6 = f3 + f4;
        int OplusGLSurfaceView_13 = this.f2166o;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f6, new int[]{OplusGLSurfaceView_13, OplusGLSurfaceView_13, this.f2167p}, new float[]{0.0f, f5, 1.0f}, Shader.TileMode.CLAMP));
        Paint paint2 = this.f2157f;
        float f7 = this.f2159h;
        float f8 = this.f2162k;
        int i2 = this.f2166o;
        paint2.setShader(new LinearGradient(0.0f, (-f7) + f8, 0.0f, (-f7) - f8, new int[]{i2, i2, this.f2167p}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f2157f.setAntiAlias(false);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m1875b(Rect rect) {
        float COUIBaseListPopupWindow_12 = this.f2161j * 1.5f;
        this.f2158g.set(rect.left + this.f2161j, rect.top + COUIBaseListPopupWindow_12, rect.right - this.f2161j, rect.bottom - COUIBaseListPopupWindow_12);
        m1877g();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    float m1878a() {
        return this.f2159h;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1881a(Rect rect) {
        getPadding(rect);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m1884b(float COUIBaseListPopupWindow_12) {
        m1871a(COUIBaseListPopupWindow_12, this.f2161j);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    void m1886c(float COUIBaseListPopupWindow_12) {
        m1871a(this.f2163l, COUIBaseListPopupWindow_12);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    float m1883b() {
        return this.f2163l;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    float m1885c() {
        return this.f2161j;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    float m1887d() {
        float COUIBaseListPopupWindow_12 = this.f2161j;
        return (Math.max(COUIBaseListPopupWindow_12, this.f2159h + this.f2154c + (COUIBaseListPopupWindow_12 / 2.0f)) * 2.0f) + ((this.f2161j + this.f2154c) * 2.0f);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    float m1888e() {
        float COUIBaseListPopupWindow_12 = this.f2161j;
        return (Math.max(COUIBaseListPopupWindow_12, this.f2159h + this.f2154c + ((COUIBaseListPopupWindow_12 * 1.5f) / 2.0f)) * 2.0f) + (((this.f2161j * 1.5f) + this.f2154c) * 2.0f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1880a(ColorStateList colorStateList) {
        m1874b(colorStateList);
        invalidateSelf();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    ColorStateList m1889f() {
        return this.f2164m;
    }
}
