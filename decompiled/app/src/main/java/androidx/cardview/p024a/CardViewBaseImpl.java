package androidx.cardview.p024a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.cardview.p024a.RoundRectDrawableWithShadow;

/* compiled from: CardViewBaseImpl.java */
/* renamed from: androidx.cardview.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
class CardViewBaseImpl implements CardViewImpl {

    /* renamed from: PlatformImplementations.kt_3 */
    final RectF f2139a = new RectF();

    @Override // androidx.cardview.p024a.CardViewImpl
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void mo1856g(CardViewDelegate interfaceC0367e) {
    }

    CardViewBaseImpl() {
    }

    @Override // androidx.cardview.p024a.CardViewImpl
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo1842a() {
        RoundRectDrawableWithShadow.f2152a = new RoundRectDrawableWithShadow.PlatformImplementations.kt_3() { // from class: androidx.cardview.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5.1
            @Override // androidx.cardview.p024a.RoundRectDrawableWithShadow.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo1843a(Canvas canvas, RectF rectF, float COUIBaseListPopupWindow_12, Paint paint) {
                float f2 = 2.0f * COUIBaseListPopupWindow_12;
                float fWidth = (rectF.width() - f2) - 1.0f;
                float fHeight = (rectF.height() - f2) - 1.0f;
                if (COUIBaseListPopupWindow_12 >= 1.0f) {
                    float f3 = COUIBaseListPopupWindow_12 + 0.5f;
                    float f4 = -f3;
                    CardViewBaseImpl.this.f2139a.set(f4, f4, f3, f3);
                    int iSave = canvas.save();
                    canvas.translate(rectF.left + f3, rectF.top + f3);
                    canvas.drawArc(CardViewBaseImpl.this.f2139a, 180.0f, 90.0f, true, paint);
                    canvas.translate(fWidth, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(CardViewBaseImpl.this.f2139a, 180.0f, 90.0f, true, paint);
                    canvas.translate(fHeight, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(CardViewBaseImpl.this.f2139a, 180.0f, 90.0f, true, paint);
                    canvas.translate(fWidth, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(CardViewBaseImpl.this.f2139a, 180.0f, 90.0f, true, paint);
                    canvas.restoreToCount(iSave);
                    canvas.drawRect((rectF.left + f3) - 1.0f, rectF.top, (rectF.right - f3) + 1.0f, rectF.top + f3, paint);
                    canvas.drawRect((rectF.left + f3) - 1.0f, rectF.bottom - f3, (rectF.right - f3) + 1.0f, rectF.bottom, paint);
                }
                canvas.drawRect(rectF.left, rectF.top + COUIBaseListPopupWindow_12, rectF.right, rectF.bottom - COUIBaseListPopupWindow_12, paint);
            }
        };
    }

    @Override // androidx.cardview.p024a.CardViewImpl
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo1847a(CardViewDelegate interfaceC0367e, Context context, ColorStateList colorStateList, float COUIBaseListPopupWindow_12, float f2, float f3) {
        RoundRectDrawableWithShadow c0370hM1859a = m1859a(context, colorStateList, COUIBaseListPopupWindow_12, f2, f3);
        c0370hM1859a.m1882a(interfaceC0367e.mo1839b());
        interfaceC0367e.mo1837a(c0370hM1859a);
        mo1855f(interfaceC0367e);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private RoundRectDrawableWithShadow m1859a(Context context, ColorStateList colorStateList, float COUIBaseListPopupWindow_12, float f2, float f3) {
        return new RoundRectDrawableWithShadow(context.getResources(), colorStateList, COUIBaseListPopupWindow_12, f2, f3);
    }

    @Override // androidx.cardview.p024a.CardViewImpl
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo1855f(CardViewDelegate interfaceC0367e) {
        Rect rect = new Rect();
        m1860j(interfaceC0367e).m1881a(rect);
        interfaceC0367e.mo1835a((int) Math.ceil(mo1849b(interfaceC0367e)), (int) Math.ceil(mo1851c(interfaceC0367e)));
        interfaceC0367e.mo1836a(rect.left, rect.top, rect.right, rect.bottom);
    }

    @Override // androidx.cardview.p024a.CardViewImpl
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void mo1857h(CardViewDelegate interfaceC0367e) {
        m1860j(interfaceC0367e).m1882a(interfaceC0367e.mo1839b());
        mo1855f(interfaceC0367e);
    }

    @Override // androidx.cardview.p024a.CardViewImpl
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo1848a(CardViewDelegate interfaceC0367e, ColorStateList colorStateList) {
        m1860j(interfaceC0367e).m1880a(colorStateList);
    }

    @Override // androidx.cardview.p024a.CardViewImpl
    /* renamed from: OplusGLSurfaceView_13 */
    public ColorStateList mo1858i(CardViewDelegate interfaceC0367e) {
        return m1860j(interfaceC0367e).m1889f();
    }

    @Override // androidx.cardview.p024a.CardViewImpl
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo1846a(CardViewDelegate interfaceC0367e, float COUIBaseListPopupWindow_12) {
        m1860j(interfaceC0367e).m1879a(COUIBaseListPopupWindow_12);
        mo1855f(interfaceC0367e);
    }

    @Override // androidx.cardview.p024a.CardViewImpl
    /* renamed from: IntrinsicsJvm.kt_5 */
    public float mo1853d(CardViewDelegate interfaceC0367e) {
        return m1860j(interfaceC0367e).m1878a();
    }

    @Override // androidx.cardview.p024a.CardViewImpl
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo1852c(CardViewDelegate interfaceC0367e, float COUIBaseListPopupWindow_12) {
        m1860j(interfaceC0367e).m1884b(COUIBaseListPopupWindow_12);
    }

    @Override // androidx.cardview.p024a.CardViewImpl
    /* renamed from: COUIBaseListPopupWindow_8 */
    public float mo1854e(CardViewDelegate interfaceC0367e) {
        return m1860j(interfaceC0367e).m1883b();
    }

    @Override // androidx.cardview.p024a.CardViewImpl
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo1850b(CardViewDelegate interfaceC0367e, float COUIBaseListPopupWindow_12) {
        m1860j(interfaceC0367e).m1886c(COUIBaseListPopupWindow_12);
        mo1855f(interfaceC0367e);
    }

    @Override // androidx.cardview.p024a.CardViewImpl
    /* renamed from: PlatformImplementations.kt_3 */
    public float mo1845a(CardViewDelegate interfaceC0367e) {
        return m1860j(interfaceC0367e).m1885c();
    }

    @Override // androidx.cardview.p024a.CardViewImpl
    /* renamed from: IntrinsicsJvm.kt_4 */
    public float mo1849b(CardViewDelegate interfaceC0367e) {
        return m1860j(interfaceC0367e).m1887d();
    }

    @Override // androidx.cardview.p024a.CardViewImpl
    /* renamed from: IntrinsicsJvm.kt_3 */
    public float mo1851c(CardViewDelegate interfaceC0367e) {
        return m1860j(interfaceC0367e).m1888e();
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private RoundRectDrawableWithShadow m1860j(CardViewDelegate interfaceC0367e) {
        return (RoundRectDrawableWithShadow) interfaceC0367e.mo1840c();
    }
}
