package com.oplus.camera.p172ui.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.DecelerateInterpolator;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.widget.Wheel;
import com.oplus.camera.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/* loaded from: classes2.dex */
public class XPanExposureWheel extends Wheel {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final String f22734b = "XPanExposureWheel";

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final int f22735c = Util.m24472l().getResources().getDimensionPixelSize(R.dimen.xpan_mode_exposure_wheel_triangle_margin_top);

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static final int f22736d = Util.m24472l().getResources().getDimensionPixelSize(R.dimen.xpan_mode_exposure_wheel_triangle_height);

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static final int f22737e = Util.m24472l().getResources().getDimensionPixelSize(R.dimen.xpan_mode_exposure_wheel_triangle_width);

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static final int f22738f = Util.m24472l().getResources().getDimensionPixelSize(R.dimen.xpan_mode_exposure_wheel_indicator_offsetX);

    /* renamed from: COUIBaseListPopupWindow_11 */
    private static final int f22739g = Util.m24472l().getResources().getDimensionPixelSize(R.dimen.xpan_mode_exposure_wheel_indicator_offsetY);

    /* renamed from: COUIBaseListPopupWindow_10 */
    private static final int f22740h = Util.m24472l().getResources().getDimensionPixelSize(R.dimen.xpan_mode_exposure_wheel_indicator_pivotY);

    /* renamed from: OplusGLSurfaceView_13 */
    private final ArrayList<String> f22741i;

    /* renamed from: OplusGLSurfaceView_15 */
    private final ArrayList<Integer> f22742j;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f22743k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f22744l;

    /* renamed from: OplusGLSurfaceView_6 */
    private Drawable f22745m;

    /* renamed from: OplusGLSurfaceView_11 */
    private Rect f22746n;

    /* renamed from: o */
    private String f22747o;

    /* renamed from: p */
    private final Paint f22748p;

    /* renamed from: q */
    private XPanExposureTickDrawable f22749q;

    /* renamed from: r */
    private InterfaceC3517b f22750r;

    /* renamed from: s */
    private Wheel.PlatformImplementations.kt_3 f22751s;

    /* renamed from: com.oplus.camera.ui.widget.XPanExposureWheel$IntrinsicsJvm.kt_4 */
    public interface InterfaceC3517b {
        void onExposureChanged(int OplusGLSurfaceView_13);
    }

    /* renamed from: com.oplus.camera.ui.widget.XPanExposureWheel$1 */
    class C35151 extends Wheel.PlatformImplementations.kt_3 {
        C35151() {
        }

        @Override // com.oplus.camera.p172ui.widget.Wheel.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo24079a(Wheel c3523f, int OplusGLSurfaceView_13, boolean z) {
            super.mo24079a(c3523f, OplusGLSurfaceView_13, z);
            XPanExposureWheel.this.m24070a(OplusGLSurfaceView_13);
        }

        @Override // com.oplus.camera.p172ui.widget.Wheel.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo24080b(Wheel c3523f) {
            int OplusGLSurfaceView_13 = (XPanExposureWheel.this.f22744l + 5) / 10;
            Log.IntrinsicsJvm.kt_5(XPanExposureWheel.f22734b, "onStopTrackingTouch() - showValue: " + OplusGLSurfaceView_13 + ", preValue: " + XPanExposureWheel.this.f22744l);
            final ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat((float) XPanExposureWheel.this.f22744l, (float) (OplusGLSurfaceView_13 * 10));
            valueAnimatorOfFloat.setDuration(50L);
            valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.widget.-$$Lambda$XPanExposureWheel$1$dEYFk9TWJ1la5640GYajS7qjC2U
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.COUIBaseListPopupWindow_12$0.m24078a(valueAnimatorOfFloat, valueAnimator);
                }
            });
            valueAnimatorOfFloat.start();
            super.mo24080b(c3523f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: PlatformImplementations.kt_3 */
        public /* synthetic */ void m24078a(ValueAnimator valueAnimator, ValueAnimator valueAnimator2) {
            if (valueAnimator2 != valueAnimator) {
                return;
            }
            XPanExposureWheel.this.setValue(((Float) valueAnimator2.getAnimatedValue()).intValue());
        }
    }

    /* renamed from: com.oplus.camera.ui.widget.XPanExposureWheel$PlatformImplementations.kt_3 */
    private class C3516a extends Drawable {
        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int OplusGLSurfaceView_13) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }

        private C3516a() {
        }

        /* synthetic */ C3516a(XPanExposureWheel xPanExposureWheel, C35151 c35151) {
            this();
        }
    }

    public XPanExposureWheel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22741i = new ArrayList<>(Arrays.asList("-3.0", "-2.7", "-2.3", "-2.0", "-1.7", "-1.3", "-1.0", "-0.7", "-0.3", "+0.3", "+0.7", "+1.0", "+1.3", "+1.7", "+2.0", "+2.3", "+2.7", "+3.0"));
        this.f22742j = new ArrayList<>();
        this.f22743k = false;
        this.f22744l = 0;
        this.f22745m = null;
        this.f22746n = new Rect();
        this.f22747o = "0.0";
        this.f22748p = new Paint(1);
        this.f22749q = null;
        this.f22750r = null;
        this.f22751s = new C35151();
        m24074d();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m24074d() {
        this.f22748p.setColor(-1);
        this.f22748p.setStyle(Paint.Style.FILL);
        this.f22748p.setTextSize(Util.m24472l().getResources().getDimensionPixelSize(R.dimen.xpan_mode_ev_wheel_text_size));
        this.f22748p.setTextAlign(Paint.Align.CENTER);
        this.f22745m = Util.m24472l().getDrawable(R.drawable.xpan_triangle_indicator);
        m24139a(this.f22751s);
        m24075e();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24077a(InterfaceC3517b interfaceC3517b) {
        this.f22750r = interfaceC3517b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public static /* synthetic */ boolean m24072b(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 % 2 == 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24076a(int OplusGLSurfaceView_13, int i2) {
        IntStream intStreamFilter = IntStream.rangeClosed(OplusGLSurfaceView_13, i2).filter(new IntPredicate() { // from class: com.oplus.camera.ui.widget.-$$Lambda$XPanExposureWheel$KTFn2bAysia70b-MCm2AjNFQaGA
            @Override // java.util.function.IntPredicate
            public final boolean test(int i3) {
                return XPanExposureWheel.m24072b(i3);
            }
        });
        final ArrayList<Integer> arrayList = this.f22742j;
        Objects.requireNonNull(arrayList);
        intStreamFilter.forEachOrdered(new IntConsumer() { // from class: com.oplus.camera.ui.widget.-$$Lambda$hobVwP6p8vZmS_btJelTxt7Jx3k
            @Override // java.util.function.IntConsumer
            public final void accept(int i3) {
                arrayList.add(Integer.valueOf(i3));
            }
        });
        ArrayList<Integer> arrayList2 = this.f22742j;
        arrayList2.remove(arrayList2.size() / 2);
        setValue(getMaxValue() / 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m24070a(int OplusGLSurfaceView_13) {
        int maxValue = getMaxValue() - OplusGLSurfaceView_13;
        int i2 = (maxValue + 5) / 10;
        int size = ((this.f22742j.size() * 10) / 2) - 5;
        Log.IntrinsicsJvm.kt_5(f22734b, "onWheelValueChanged() - getMaxValue(): " + getMaxValue() + ", wheelValue: " + OplusGLSurfaceView_13 + ", invertedWheelValue: " + maxValue + ", mappingNowValue: " + i2);
        if (maxValue < 5) {
            InterfaceC3517b interfaceC3517b = this.f22750r;
            if (interfaceC3517b != null) {
                interfaceC3517b.onExposureChanged(this.f22742j.get(0).intValue());
            }
            this.f22747o = this.f22741i.get(0);
            this.f22749q.m24148a(0);
        } else if (maxValue < size) {
            InterfaceC3517b interfaceC3517b2 = this.f22750r;
            if (interfaceC3517b2 != null) {
                interfaceC3517b2.onExposureChanged(this.f22742j.get(i2).intValue());
            }
            this.f22747o = this.f22741i.get(i2);
            this.f22749q.m24148a(i2);
        } else {
            int i3 = size + 10;
            if (maxValue < i3) {
                InterfaceC3517b interfaceC3517b3 = this.f22750r;
                if (interfaceC3517b3 != null) {
                    interfaceC3517b3.onExposureChanged(0);
                }
                this.f22747o = "0.0";
                this.f22749q.m24148a(9);
            } else if (maxValue >= i3 && maxValue < (this.f22742j.size() * 10) - 5) {
                InterfaceC3517b interfaceC3517b4 = this.f22750r;
                if (interfaceC3517b4 != null) {
                    interfaceC3517b4.onExposureChanged(this.f22742j.get(i2 - 1).intValue());
                }
                this.f22747o = this.f22741i.get(i2 - 1);
                this.f22749q.m24148a(i2);
            } else {
                InterfaceC3517b interfaceC3517b5 = this.f22750r;
                if (interfaceC3517b5 != null) {
                    interfaceC3517b5.onExposureChanged(this.f22742j.get(r1.size() - 1).intValue());
                }
                this.f22747o = this.f22741i.get(this.f22742j.size() - 1);
                this.f22749q.m24148a(this.f22742j.size());
            }
        }
        this.f22744l = OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.p172ui.widget.Wheel, android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.f22743k && getWidth() != 0) {
            this.f22743k = true;
            m24075e();
        }
        super.onDraw(canvas);
        if (this.f22743k) {
            Rect rect = this.f22870a;
            int iCenterX = rect.centerX() - (f22737e / 2);
            int OplusGLSurfaceView_13 = rect.top + f22735c;
            this.f22746n.set(iCenterX, OplusGLSurfaceView_13, rect.centerX() + (f22737e / 2), f22736d + OplusGLSurfaceView_13);
            Drawable drawable = this.f22745m;
            if (drawable != null) {
                drawable.setBounds(this.f22746n);
                this.f22745m.draw(canvas);
            }
            int iCenterX2 = rect.centerX();
            int i2 = rect.top + f22739g;
            int i3 = rect.top + f22740h;
            canvas.save();
            canvas.rotate(90.0f, iCenterX2, i3);
            canvas.drawText(this.f22747o, iCenterX2 - f22738f, i2, this.f22748p);
            canvas.restore();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m24075e() {
        setWheelLengthRatio(1.0f);
        setFadingEdgeLength(0);
        if (this.f22749q == null) {
            this.f22749q = new XPanExposureTickDrawable();
        }
        setCurrentValueIndicatorDrawable(this.f22749q);
        setWheelDrawable(new C3516a(this, null));
        setMaxValue(this.f22742j.size() * 10);
        setValue(getMaxValue() / 2);
    }
}
