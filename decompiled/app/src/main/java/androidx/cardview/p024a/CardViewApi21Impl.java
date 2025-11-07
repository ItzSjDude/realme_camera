package androidx.cardview.p024a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

/* compiled from: CardViewApi21Impl.java */
/* renamed from: androidx.cardview.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
class CardViewApi21Impl implements CardViewImpl {
    @Override // androidx.cardview.p024a.CardViewImpl
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo1842a() {
    }

    CardViewApi21Impl() {
    }

    @Override // androidx.cardview.p024a.CardViewImpl
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo1847a(CardViewDelegate interfaceC0367e, Context context, ColorStateList colorStateList, float COUIBaseListPopupWindow_12, float f2, float f3) {
        interfaceC0367e.mo1837a(new RoundRectDrawable(colorStateList, COUIBaseListPopupWindow_12));
        View viewMo1841d = interfaceC0367e.mo1841d();
        viewMo1841d.setClipToOutline(true);
        viewMo1841d.setElevation(f2);
        mo1850b(interfaceC0367e, f3);
    }

    @Override // androidx.cardview.p024a.CardViewImpl
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo1846a(CardViewDelegate interfaceC0367e, float COUIBaseListPopupWindow_12) {
        m1844j(interfaceC0367e).m1865a(COUIBaseListPopupWindow_12);
    }

    @Override // androidx.cardview.p024a.CardViewImpl
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo1850b(CardViewDelegate interfaceC0367e, float COUIBaseListPopupWindow_12) {
        m1844j(interfaceC0367e).m1866a(COUIBaseListPopupWindow_12, interfaceC0367e.mo1838a(), interfaceC0367e.mo1839b());
        mo1855f(interfaceC0367e);
    }

    @Override // androidx.cardview.p024a.CardViewImpl
    /* renamed from: PlatformImplementations.kt_3 */
    public float mo1845a(CardViewDelegate interfaceC0367e) {
        return m1844j(interfaceC0367e).m1864a();
    }

    @Override // androidx.cardview.p024a.CardViewImpl
    /* renamed from: IntrinsicsJvm.kt_4 */
    public float mo1849b(CardViewDelegate interfaceC0367e) {
        return mo1853d(interfaceC0367e) * 2.0f;
    }

    @Override // androidx.cardview.p024a.CardViewImpl
    /* renamed from: IntrinsicsJvm.kt_3 */
    public float mo1851c(CardViewDelegate interfaceC0367e) {
        return mo1853d(interfaceC0367e) * 2.0f;
    }

    @Override // androidx.cardview.p024a.CardViewImpl
    /* renamed from: IntrinsicsJvm.kt_5 */
    public float mo1853d(CardViewDelegate interfaceC0367e) {
        return m1844j(interfaceC0367e).m1868b();
    }

    @Override // androidx.cardview.p024a.CardViewImpl
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo1852c(CardViewDelegate interfaceC0367e, float COUIBaseListPopupWindow_12) {
        interfaceC0367e.mo1841d().setElevation(COUIBaseListPopupWindow_12);
    }

    @Override // androidx.cardview.p024a.CardViewImpl
    /* renamed from: COUIBaseListPopupWindow_8 */
    public float mo1854e(CardViewDelegate interfaceC0367e) {
        return interfaceC0367e.mo1841d().getElevation();
    }

    @Override // androidx.cardview.p024a.CardViewImpl
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void mo1855f(CardViewDelegate interfaceC0367e) {
        if (!interfaceC0367e.mo1838a()) {
            interfaceC0367e.mo1836a(0, 0, 0, 0);
            return;
        }
        float fMo1845a = mo1845a(interfaceC0367e);
        float fMo1853d = mo1853d(interfaceC0367e);
        int iCeil = (int) Math.ceil(RoundRectDrawableWithShadow.m1873b(fMo1845a, fMo1853d, interfaceC0367e.mo1839b()));
        int iCeil2 = (int) Math.ceil(RoundRectDrawableWithShadow.m1870a(fMo1845a, fMo1853d, interfaceC0367e.mo1839b()));
        interfaceC0367e.mo1836a(iCeil, iCeil2, iCeil, iCeil2);
    }

    @Override // androidx.cardview.p024a.CardViewImpl
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void mo1856g(CardViewDelegate interfaceC0367e) {
        mo1850b(interfaceC0367e, mo1845a(interfaceC0367e));
    }

    @Override // androidx.cardview.p024a.CardViewImpl
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void mo1857h(CardViewDelegate interfaceC0367e) {
        mo1850b(interfaceC0367e, mo1845a(interfaceC0367e));
    }

    @Override // androidx.cardview.p024a.CardViewImpl
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo1848a(CardViewDelegate interfaceC0367e, ColorStateList colorStateList) {
        m1844j(interfaceC0367e).m1867a(colorStateList);
    }

    @Override // androidx.cardview.p024a.CardViewImpl
    /* renamed from: OplusGLSurfaceView_13 */
    public ColorStateList mo1858i(CardViewDelegate interfaceC0367e) {
        return m1844j(interfaceC0367e).m1869c();
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private RoundRectDrawable m1844j(CardViewDelegate interfaceC0367e) {
        return (RoundRectDrawable) interfaceC0367e.mo1840c();
    }
}
