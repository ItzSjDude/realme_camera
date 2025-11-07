package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import com.airbnb.lottie.p083b.FontAssetManager_2;
import com.airbnb.lottie.p083b.ImageAssetManager_2;
import com.airbnb.lottie.p084c.KeyPath_2;
import com.airbnb.lottie.p084c.Marker_2;
import com.airbnb.lottie.p084c.p087c.CompositionLayer_3;
import com.airbnb.lottie.p089e.LayerParser_2;
import com.airbnb.lottie.p091f.Logger_3;
import com.airbnb.lottie.p091f.MiscUtils_2;
import com.airbnb.lottie.p091f.LottieValueAnimator;
import com.airbnb.lottie.p092g.LottieValueCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: LottieDrawable.java */
/* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_12 */
/* loaded from: classes.dex */
public class LottieDrawable extends Drawable implements Animatable, Drawable.Callback {

    /* renamed from: PlatformImplementations.kt_3 */
    FontAssetDelegate_2 f5816a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    TextDelegate_2 f5817b;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private LottieComposition f5819d;

    /* renamed from: OplusGLSurfaceView_5 */
    private ImageAssetManager_2 f5826k;

    /* renamed from: OplusGLSurfaceView_14 */
    private String f5827l;

    /* renamed from: OplusGLSurfaceView_6 */
    private ImageAssetDelegate_2 f5828m;

    /* renamed from: OplusGLSurfaceView_11 */
    private FontAssetManager_2 f5829n;

    /* renamed from: o */
    private boolean f5830o;

    /* renamed from: p */
    private CompositionLayer_3 f5831p;

    /* renamed from: r */
    private boolean f5833r;

    /* renamed from: s */
    private boolean f5834s;

    /* renamed from: t */
    private boolean f5835t;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final Matrix f5818c = new Matrix();

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final LottieValueAnimator f5820e = new LottieValueAnimator();

    /* renamed from: COUIBaseListPopupWindow_12 */
    private float f5821f = 1.0f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f5822g = true;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f5823h = false;

    /* renamed from: OplusGLSurfaceView_13 */
    private final ArrayList<PlatformImplementations.kt_3> f5824i = new ArrayList<>();

    /* renamed from: OplusGLSurfaceView_15 */
    private final ValueAnimator.AnimatorUpdateListener f5825j = new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.COUIBaseListPopupWindow_12.1
        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (LottieDrawable.this.f5831p != null) {
                LottieDrawable.this.f5831p.mo5773a(LottieDrawable.this.f5820e.m6112d());
            }
        }
    };

    /* renamed from: q */
    private int f5832q = 255;

    /* renamed from: u */
    private boolean f5836u = true;

    /* renamed from: v */
    private boolean f5837v = false;

    /* compiled from: LottieDrawable.java */
    /* renamed from: com.airbnb.lottie.COUIBaseListPopupWindow_12$PlatformImplementations.kt_3 */
    private interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo6084a(LottieComposition c1136d);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public LottieDrawable() {
        this.f5820e.addUpdateListener(this.f5825j);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m6044a() {
        return this.f5830o;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6043a(boolean z) {
        if (this.f5830o == z) {
            return;
        }
        if (Build.VERSION.SDK_INT < 19) {
            Logger_3.m6100b("Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.f5830o = z;
        if (this.f5819d != null) {
            m6028x();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6042a(String str) {
        this.f5827l = str;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public String m6046b() {
        return this.f5827l;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m6045a(LottieComposition c1136d) {
        if (this.f5819d == c1136d) {
            return false;
        }
        this.f5837v = false;
        m6062e();
        this.f5819d = c1136d;
        m6028x();
        this.f5820e.m6108a(c1136d);
        m6056d(this.f5820e.getAnimatedFraction());
        m6063e(this.f5821f);
        Iterator it = new ArrayList(this.f5824i).iterator();
        while (it.hasNext()) {
            PlatformImplementations.kt_3 aVar = (PlatformImplementations.kt_3) it.next();
            if (aVar != null) {
                aVar.mo6084a(c1136d);
            }
            it.remove();
        }
        this.f5824i.clear();
        c1136d.m5848b(this.f5833r);
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof ImageView)) {
            return true;
        }
        ImageView imageView = (ImageView) callback;
        imageView.setImageDrawable(null);
        imageView.setImageDrawable(this);
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m6050b(boolean z) {
        this.f5833r = z;
        LottieComposition c1136d = this.f5819d;
        if (c1136d != null) {
            c1136d.m5848b(z);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m6055c(boolean z) {
        if (this.f5834s == z) {
            return;
        }
        this.f5834s = z;
        CompositionLayer_3 c1123b = this.f5831p;
        if (c1123b != null) {
            c1123b.mo5776a(z);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public PerformanceTracker_3 m6051c() {
        LottieComposition c1136d = this.f5819d;
        if (c1136d != null) {
            return c1136d.m5850c();
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m6059d(boolean z) {
        this.f5835t = z;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m6060d() {
        return this.f5835t;
    }

    /* renamed from: x */
    private void m6028x() {
        this.f5831p = new CompositionLayer_3(this, LayerParser_2.m6005a(this.f5819d), this.f5819d.m5856i(), this.f5819d);
        if (this.f5834s) {
            this.f5831p.mo5776a(true);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m6062e() {
        if (this.f5820e.isRunning()) {
            this.f5820e.cancel();
        }
        this.f5819d = null;
        this.f5831p = null;
        this.f5826k = null;
        this.f5820e.m6114f();
        invalidateSelf();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m6065e(boolean z) {
        this.f5823h = z;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.f5837v) {
            return;
        }
        this.f5837v = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int OplusGLSurfaceView_13) {
        this.f5832q = OplusGLSurfaceView_13;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f5832q;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Logger_3.m6100b("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f5837v = false;
        L_2.m5637a("Drawable#draw");
        if (this.f5823h) {
            try {
                m6023a(canvas);
            } catch (Throwable th) {
                Logger_3.m6101b("Lottie crashed in draw!", th);
            }
        } else {
            m6023a(canvas);
        }
        L_2.m5638b("Drawable#draw");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6023a(Canvas canvas) {
        if (!m6029y()) {
            m6026c(canvas);
        } else {
            m6027d(canvas);
        }
    }

    /* renamed from: y */
    private boolean m6029y() {
        LottieComposition c1136d = this.f5819d;
        return c1136d == null || getBounds().isEmpty() || m6021a(getBounds()) == m6021a(c1136d.m5851d());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private float m6021a(Rect rect) {
        return rect.width() / rect.height();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View) || ((View) callback).isInEditMode()) {
            return;
        }
        m6066f();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        m6067g();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return m6076p();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m6066f() {
        if (this.f5831p == null) {
            this.f5824i.add(new PlatformImplementations.kt_3() { // from class: com.airbnb.lottie.COUIBaseListPopupWindow_12.7
                @Override // com.airbnb.lottie.LottieDrawable.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo6084a(LottieComposition c1136d) {
                    LottieDrawable.this.m6066f();
                }
            });
            return;
        }
        if (this.f5822g || m6075o() == 0) {
            this.f5820e.m6117i();
        }
        if (this.f5822g) {
            return;
        }
        m6053c((int) (m6071k() < 0.0f ? m6069i() : m6070j()));
        this.f5820e.m6118j();
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m6067g() {
        this.f5824i.clear();
        this.f5820e.m6118j();
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m6068h() {
        if (this.f5831p == null) {
            this.f5824i.add(new PlatformImplementations.kt_3() { // from class: com.airbnb.lottie.COUIBaseListPopupWindow_12.8
                @Override // com.airbnb.lottie.LottieDrawable.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo6084a(LottieComposition c1136d) {
                    LottieDrawable.this.m6068h();
                }
            });
            return;
        }
        if (this.f5822g || m6075o() == 0) {
            this.f5820e.m6120l();
        }
        if (this.f5822g) {
            return;
        }
        m6053c((int) (m6071k() < 0.0f ? m6069i() : m6070j()));
        this.f5820e.m6118j();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6034a(final int OplusGLSurfaceView_13) {
        if (this.f5819d == null) {
            this.f5824i.add(new PlatformImplementations.kt_3() { // from class: com.airbnb.lottie.COUIBaseListPopupWindow_12.9
                @Override // com.airbnb.lottie.LottieDrawable.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo6084a(LottieComposition c1136d) {
                    LottieDrawable.this.m6034a(OplusGLSurfaceView_13);
                }
            });
        } else {
            this.f5820e.m6107a(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public float m6069i() {
        return this.f5820e.m6121m();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6033a(final float COUIBaseListPopupWindow_12) {
        LottieComposition c1136d = this.f5819d;
        if (c1136d == null) {
            this.f5824i.add(new PlatformImplementations.kt_3() { // from class: com.airbnb.lottie.COUIBaseListPopupWindow_12.10
                @Override // com.airbnb.lottie.LottieDrawable.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo6084a(LottieComposition c1136d2) {
                    LottieDrawable.this.m6033a(COUIBaseListPopupWindow_12);
                }
            });
        } else {
            m6034a((int) MiscUtils_2.m6127a(c1136d.m5853f(), this.f5819d.m5854g(), COUIBaseListPopupWindow_12));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m6048b(final int OplusGLSurfaceView_13) {
        if (this.f5819d == null) {
            this.f5824i.add(new PlatformImplementations.kt_3() { // from class: com.airbnb.lottie.COUIBaseListPopupWindow_12.11
                @Override // com.airbnb.lottie.LottieDrawable.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo6084a(LottieComposition c1136d) {
                    LottieDrawable.this.m6048b(OplusGLSurfaceView_13);
                }
            });
        } else {
            this.f5820e.m6109b(OplusGLSurfaceView_13 + 0.99f);
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public float m6070j() {
        return this.f5820e.m6122n();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m6047b(final float COUIBaseListPopupWindow_12) {
        LottieComposition c1136d = this.f5819d;
        if (c1136d == null) {
            this.f5824i.add(new PlatformImplementations.kt_3() { // from class: com.airbnb.lottie.COUIBaseListPopupWindow_12.12
                @Override // com.airbnb.lottie.LottieDrawable.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo6084a(LottieComposition c1136d2) {
                    LottieDrawable.this.m6047b(COUIBaseListPopupWindow_12);
                }
            });
        } else {
            m6048b((int) MiscUtils_2.m6127a(c1136d.m5853f(), this.f5819d.m5854g(), COUIBaseListPopupWindow_12));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m6049b(final String str) {
        LottieComposition c1136d = this.f5819d;
        if (c1136d == null) {
            this.f5824i.add(new PlatformImplementations.kt_3() { // from class: com.airbnb.lottie.COUIBaseListPopupWindow_12.13
                @Override // com.airbnb.lottie.LottieDrawable.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo6084a(LottieComposition c1136d2) {
                    LottieDrawable.this.m6049b(str);
                }
            });
            return;
        }
        Marker_2 c1134hM5849c = c1136d.m5849c(str);
        if (c1134hM5849c == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
        m6034a((int) c1134hM5849c.f5704a);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m6054c(final String str) {
        LottieComposition c1136d = this.f5819d;
        if (c1136d == null) {
            this.f5824i.add(new PlatformImplementations.kt_3() { // from class: com.airbnb.lottie.COUIBaseListPopupWindow_12.14
                @Override // com.airbnb.lottie.LottieDrawable.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo6084a(LottieComposition c1136d2) {
                    LottieDrawable.this.m6054c(str);
                }
            });
            return;
        }
        Marker_2 c1134hM5849c = c1136d.m5849c(str);
        if (c1134hM5849c == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
        m6048b((int) (c1134hM5849c.f5704a + c1134hM5849c.f5705b));
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m6058d(final String str) {
        LottieComposition c1136d = this.f5819d;
        if (c1136d == null) {
            this.f5824i.add(new PlatformImplementations.kt_3() { // from class: com.airbnb.lottie.COUIBaseListPopupWindow_12.2
                @Override // com.airbnb.lottie.LottieDrawable.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo6084a(LottieComposition c1136d2) {
                    LottieDrawable.this.m6058d(str);
                }
            });
            return;
        }
        Marker_2 c1134hM5849c = c1136d.m5849c(str);
        if (c1134hM5849c == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
        int OplusGLSurfaceView_13 = (int) c1134hM5849c.f5704a;
        m6035a(OplusGLSurfaceView_13, ((int) c1134hM5849c.f5705b) + OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6035a(final int OplusGLSurfaceView_13, final int i2) {
        if (this.f5819d == null) {
            this.f5824i.add(new PlatformImplementations.kt_3() { // from class: com.airbnb.lottie.COUIBaseListPopupWindow_12.3
                @Override // com.airbnb.lottie.LottieDrawable.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo6084a(LottieComposition c1136d) {
                    LottieDrawable.this.m6035a(OplusGLSurfaceView_13, i2);
                }
            });
        } else {
            this.f5820e.m6106a(OplusGLSurfaceView_13, i2 + 0.99f);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m6052c(float COUIBaseListPopupWindow_12) {
        this.f5820e.m6110c(COUIBaseListPopupWindow_12);
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public float m6071k() {
        return this.f5820e.m6116h();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6036a(Animator.AnimatorListener animatorListener) {
        this.f5820e.addListener(animatorListener);
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public void m6072l() {
        this.f5820e.removeAllListeners();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m6053c(final int OplusGLSurfaceView_13) {
        if (this.f5819d == null) {
            this.f5824i.add(new PlatformImplementations.kt_3() { // from class: com.airbnb.lottie.COUIBaseListPopupWindow_12.4
                @Override // com.airbnb.lottie.LottieDrawable.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo6084a(LottieComposition c1136d) {
                    LottieDrawable.this.m6053c(OplusGLSurfaceView_13);
                }
            });
        } else {
            this.f5820e.m6105a(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public int m6073m() {
        return (int) this.f5820e.m6113e();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m6056d(final float COUIBaseListPopupWindow_12) {
        if (this.f5819d == null) {
            this.f5824i.add(new PlatformImplementations.kt_3() { // from class: com.airbnb.lottie.COUIBaseListPopupWindow_12.5
                @Override // com.airbnb.lottie.LottieDrawable.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo6084a(LottieComposition c1136d) {
                    LottieDrawable.this.m6056d(COUIBaseListPopupWindow_12);
                }
            });
            return;
        }
        L_2.m5637a("Drawable#setProgress");
        this.f5820e.m6105a(MiscUtils_2.m6127a(this.f5819d.m5853f(), this.f5819d.m5854g(), COUIBaseListPopupWindow_12));
        L_2.m5638b("Drawable#setProgress");
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m6057d(int OplusGLSurfaceView_13) {
        this.f5820e.setRepeatMode(OplusGLSurfaceView_13);
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public int m6074n() {
        return this.f5820e.getRepeatMode();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m6064e(int OplusGLSurfaceView_13) {
        this.f5820e.setRepeatCount(OplusGLSurfaceView_13);
    }

    /* renamed from: o */
    public int m6075o() {
        return this.f5820e.getRepeatCount();
    }

    /* renamed from: p */
    public boolean m6076p() {
        LottieValueAnimator choreographerFrameCallbackC1192e = this.f5820e;
        if (choreographerFrameCallbackC1192e == null) {
            return false;
        }
        return choreographerFrameCallbackC1192e.isRunning();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m6041a(Boolean bool) {
        this.f5822g = bool.booleanValue();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m6063e(float COUIBaseListPopupWindow_12) {
        this.f5821f = COUIBaseListPopupWindow_12;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6038a(ImageAssetDelegate_2 interfaceC1084b) {
        this.f5828m = interfaceC1084b;
        ImageAssetManager_2 c1086b = this.f5826k;
        if (c1086b != null) {
            c1086b.m5634a(interfaceC1084b);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6037a(FontAssetDelegate_2 c1047a) {
        this.f5816a = c1047a;
        FontAssetManager_2 c1085a = this.f5829n;
        if (c1085a != null) {
            c1085a.m5631a(c1047a);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6040a(TextDelegate_2 c1211q) {
        this.f5817b = c1211q;
    }

    /* renamed from: q */
    public TextDelegate_2 m6077q() {
        return this.f5817b;
    }

    /* renamed from: r */
    public boolean m6078r() {
        return this.f5817b == null && this.f5819d.m5857j().size() > 0;
    }

    /* renamed from: s */
    public float m6079s() {
        return this.f5821f;
    }

    /* renamed from: t */
    public LottieComposition m6080t() {
        return this.f5819d;
    }

    /* renamed from: u */
    public void m6081u() {
        this.f5824i.clear();
        this.f5820e.cancel();
    }

    /* renamed from: v */
    public void m6082v() {
        this.f5824i.clear();
        this.f5820e.m6119k();
    }

    /* renamed from: w */
    public float m6083w() {
        return this.f5820e.m6112d();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f5819d == null) {
            return -1;
        }
        return (int) (r0.m5851d().width() * m6079s());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f5819d == null) {
            return -1;
        }
        return (int) (r0.m5851d().height() * m6079s());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public List<KeyPath_2> m6032a(KeyPath_2 c1131e) {
        if (this.f5831p == null) {
            Logger_3.m6100b("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.f5831p.mo5533a(c1131e, 0, arrayList, new KeyPath_2(new String[0]));
        return arrayList;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public <T> void m6039a(final KeyPath_2 c1131e, final T t, final LottieValueCallback<T> c1199c) {
        if (this.f5831p == null) {
            this.f5824i.add(new PlatformImplementations.kt_3() { // from class: com.airbnb.lottie.COUIBaseListPopupWindow_12.6
                @Override // com.airbnb.lottie.LottieDrawable.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo6084a(LottieComposition c1136d) {
                    LottieDrawable.this.m6039a(c1131e, t, c1199c);
                }
            });
            return;
        }
        boolean zIsEmpty = true;
        if (c1131e == KeyPath_2.f5698a) {
            this.f5831p.mo5534a((CompositionLayer_3) t, (LottieValueCallback<CompositionLayer_3>) c1199c);
        } else if (c1131e.m5829a() != null) {
            c1131e.m5829a().mo5534a(t, c1199c);
        } else {
            List<KeyPath_2> listM6032a = m6032a(c1131e);
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < listM6032a.size(); OplusGLSurfaceView_13++) {
                listM6032a.get(OplusGLSurfaceView_13).m5829a().mo5534a(t, c1199c);
            }
            zIsEmpty = true ^ listM6032a.isEmpty();
        }
        if (zIsEmpty) {
            invalidateSelf();
            if (t == InterfaceC1205k.f5924C) {
                m6056d(m6083w());
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public Bitmap m6061e(String str) {
        ImageAssetManager_2 c1086bM6030z = m6030z();
        if (c1086bM6030z != null) {
            return c1086bM6030z.m5633a(str);
        }
        return null;
    }

    /* renamed from: z */
    private ImageAssetManager_2 m6030z() {
        if (getCallback() == null) {
            return null;
        }
        ImageAssetManager_2 c1086b = this.f5826k;
        if (c1086b != null && !c1086b.m5635a(m6020B())) {
            this.f5826k = null;
        }
        if (this.f5826k == null) {
            this.f5826k = new ImageAssetManager_2(getCallback(), this.f5827l, this.f5828m, this.f5819d.m5859l());
        }
        return this.f5826k;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Typeface m6031a(String str, String str2) {
        FontAssetManager_2 c1085aM6019A = m6019A();
        if (c1085aM6019A != null) {
            return c1085aM6019A.m5630a(str, str2);
        }
        return null;
    }

    /* renamed from: A */
    private FontAssetManager_2 m6019A() {
        if (getCallback() == null) {
            return null;
        }
        if (this.f5829n == null) {
            this.f5829n = new FontAssetManager_2(getCallback(), this.f5816a);
        }
        return this.f5829n;
    }

    /* renamed from: B */
    private Context m6020B() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long OplusGLSurfaceView_15) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, OplusGLSurfaceView_15);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private float m6024b(Canvas canvas) {
        return Math.min(canvas.getWidth() / this.f5819d.m5851d().width(), canvas.getHeight() / this.f5819d.m5851d().height());
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m6026c(Canvas canvas) {
        float COUIBaseListPopupWindow_12;
        if (this.f5831p == null) {
            return;
        }
        int iSave = -1;
        Rect bounds = getBounds();
        float fWidth = bounds.width() / this.f5819d.m5851d().width();
        float fHeight = bounds.height() / this.f5819d.m5851d().height();
        if (this.f5836u) {
            float fMin = Math.min(fWidth, fHeight);
            if (fMin < 1.0f) {
                COUIBaseListPopupWindow_12 = 1.0f / fMin;
                fWidth /= COUIBaseListPopupWindow_12;
                fHeight /= COUIBaseListPopupWindow_12;
            } else {
                COUIBaseListPopupWindow_12 = 1.0f;
            }
            if (COUIBaseListPopupWindow_12 > 1.0f) {
                iSave = canvas.save();
                float fWidth2 = bounds.width() / 2.0f;
                float fHeight2 = bounds.height() / 2.0f;
                float f2 = fWidth2 * fMin;
                float f3 = fMin * fHeight2;
                canvas.translate(fWidth2 - f2, fHeight2 - f3);
                canvas.scale(COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12, f2, f3);
            }
        }
        this.f5818c.reset();
        this.f5818c.preScale(fWidth, fHeight);
        this.f5831p.mo5531a(canvas, this.f5818c, this.f5832q);
        if (iSave > 0) {
            canvas.restoreToCount(iSave);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m6027d(Canvas canvas) {
        float COUIBaseListPopupWindow_12;
        if (this.f5831p == null) {
            return;
        }
        float f2 = this.f5821f;
        float fM6024b = m6024b(canvas);
        if (f2 > fM6024b) {
            COUIBaseListPopupWindow_12 = this.f5821f / fM6024b;
        } else {
            fM6024b = f2;
            COUIBaseListPopupWindow_12 = 1.0f;
        }
        int iSave = -1;
        if (COUIBaseListPopupWindow_12 > 1.0f) {
            iSave = canvas.save();
            float fWidth = this.f5819d.m5851d().width() / 2.0f;
            float fHeight = this.f5819d.m5851d().height() / 2.0f;
            float f3 = fWidth * fM6024b;
            float f4 = fHeight * fM6024b;
            canvas.translate((m6079s() * fWidth) - f3, (m6079s() * fHeight) - f4);
            canvas.scale(COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12, f3, f4);
        }
        this.f5818c.reset();
        this.f5818c.preScale(fM6024b, fM6024b);
        this.f5831p.mo5531a(canvas, this.f5818c, this.f5832q);
        if (iSave > 0) {
            canvas.restoreToCount(iSave);
        }
    }
}
