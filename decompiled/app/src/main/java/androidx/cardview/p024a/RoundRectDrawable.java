package androidx.cardview.p024a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* compiled from: RoundRectDrawable.java */
/* renamed from: androidx.cardview.PlatformImplementations.kt_3.COUIBaseListPopupWindow_11 */
/* loaded from: classes.dex */
class RoundRectDrawable extends Drawable {

    /* renamed from: PlatformImplementations.kt_3 */
    private float f2141a;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final RectF f2143c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final Rect f2144d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private float f2145e;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private ColorStateList f2148h;

    /* renamed from: OplusGLSurfaceView_13 */
    private PorterDuffColorFilter f2149i;

    /* renamed from: OplusGLSurfaceView_15 */
    private ColorStateList f2150j;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f2146f = false;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f2147g = true;

    /* renamed from: OplusGLSurfaceView_5 */
    private PorterDuff.Mode f2151k = PorterDuff.Mode.SRC_IN;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Paint f2142b = new Paint(5);

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    RoundRectDrawable(ColorStateList colorStateList, float COUIBaseListPopupWindow_12) {
        this.f2141a = COUIBaseListPopupWindow_12;
        m1863b(colorStateList);
        this.f2143c = new RectF();
        this.f2144d = new Rect();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m1863b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f2148h = colorStateList;
        this.f2142b.setColor(this.f2148h.getColorForState(getState(), this.f2148h.getDefaultColor()));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1866a(float COUIBaseListPopupWindow_12, boolean z, boolean z2) {
        if (COUIBaseListPopupWindow_12 == this.f2145e && this.f2146f == z && this.f2147g == z2) {
            return;
        }
        this.f2145e = COUIBaseListPopupWindow_12;
        this.f2146f = z;
        this.f2147g = z2;
        m1862a((Rect) null);
        invalidateSelf();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    float m1864a() {
        return this.f2145e;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z;
        Paint paint = this.f2142b;
        if (this.f2149i == null || paint.getColorFilter() != null) {
            z = false;
        } else {
            paint.setColorFilter(this.f2149i);
            z = true;
        }
        RectF rectF = this.f2143c;
        float COUIBaseListPopupWindow_12 = this.f2141a;
        canvas.drawRoundRect(rectF, COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12, paint);
        if (z) {
            paint.setColorFilter(null);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m1862a(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f2143c.set(rect.left, rect.top, rect.right, rect.bottom);
        this.f2144d.set(rect);
        if (this.f2146f) {
            this.f2144d.inset((int) Math.ceil(RoundRectDrawableWithShadow.m1873b(this.f2145e, this.f2141a, this.f2147g)), (int) Math.ceil(RoundRectDrawableWithShadow.m1870a(this.f2145e, this.f2141a, this.f2147g)));
            this.f2143c.set(this.f2144d);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        m1862a(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f2144d, this.f2141a);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m1865a(float COUIBaseListPopupWindow_12) {
        if (COUIBaseListPopupWindow_12 == this.f2141a) {
            return;
        }
        this.f2141a = COUIBaseListPopupWindow_12;
        m1862a((Rect) null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int OplusGLSurfaceView_13) {
        this.f2142b.setAlpha(OplusGLSurfaceView_13);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f2142b.setColorFilter(colorFilter);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public float m1868b() {
        return this.f2141a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1867a(ColorStateList colorStateList) {
        m1863b(colorStateList);
        invalidateSelf();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public ColorStateList m1869c() {
        return this.f2148h;
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f2150j = colorStateList;
        this.f2149i = m1861a(this.f2150j, this.f2151k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f2151k = mode;
        this.f2149i = m1861a(this.f2150j, this.f2151k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f2148h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z = colorForState != this.f2142b.getColor();
        if (z) {
            this.f2142b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f2150j;
        if (colorStateList2 == null || (mode = this.f2151k) == null) {
            return z;
        }
        this.f2149i = m1861a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f2150j;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f2148h) != null && colorStateList.isStateful()) || super.isStateful();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private PorterDuffColorFilter m1861a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }
}
