package androidx.cardview.p024a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.cardview.p024a.RoundRectDrawableWithShadow;

/* compiled from: CardViewApi17Impl.java */
/* renamed from: androidx.cardview.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
class CardViewApi17Impl extends CardViewBaseImpl {
    CardViewApi17Impl() {
    }

    @Override // androidx.cardview.p024a.CardViewBaseImpl, androidx.cardview.p024a.CardViewImpl
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo1842a() {
        RoundRectDrawableWithShadow.f2152a = new RoundRectDrawableWithShadow.PlatformImplementations.kt_3() { // from class: androidx.cardview.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.1
            @Override // androidx.cardview.p024a.RoundRectDrawableWithShadow.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo1843a(Canvas canvas, RectF rectF, float COUIBaseListPopupWindow_12, Paint paint) {
                canvas.drawRoundRect(rectF, COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12, paint);
            }
        };
    }
}
