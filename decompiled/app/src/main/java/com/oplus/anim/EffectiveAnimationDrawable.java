package com.oplus.anim;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.View;
import com.oplus.anim.p114b.FontAssetManager;
import com.oplus.anim.p114b.ImageAssetManager;
import com.oplus.anim.p115c.KeyPath;
import com.oplus.anim.p115c.Marker;
import com.oplus.anim.p115c.p118c.CompositionLayer;
import com.oplus.anim.p120e.LayerParser;
import com.oplus.anim.p121f.MiscUtils;
import com.oplus.anim.p121f.OplusLog;
import com.oplus.anim.p121f.EffectiveValueAnimator;
import com.oplus.anim.p122g.EffectiveValueCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: EffectiveAnimationDrawable.java */
/* renamed from: com.oplus.anim.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class EffectiveAnimationDrawable extends Drawable implements Animatable, Drawable.Callback {

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final String f10041c = "IntrinsicsJvm.kt_4";

    /* renamed from: PlatformImplementations.kt_3 */
    FontAssetDelegate f10042a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    TextDelegate f10043b;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private EffectiveAnimationComposition f10048h;

    /* renamed from: OplusGLSurfaceView_15 */
    private ImageAssetManager f10050j;

    /* renamed from: OplusGLSurfaceView_5 */
    private String f10051k;

    /* renamed from: OplusGLSurfaceView_14 */
    private ImageAssetDelegate f10052l;

    /* renamed from: OplusGLSurfaceView_6 */
    private FontAssetManager f10053m;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f10054n;

    /* renamed from: o */
    private CompositionLayer f10055o;

    /* renamed from: q */
    private boolean f10057q;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final Matrix f10044d = new Matrix();

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final EffectiveValueAnimator f10045e = new EffectiveValueAnimator();

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final Set<Object> f10046f = new HashSet();

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final ArrayList<PlatformImplementations.kt_3> f10047g = new ArrayList<>();

    /* renamed from: OplusGLSurfaceView_13 */
    private float f10049i = 1.0f;

    /* renamed from: p */
    private int f10056p = 255;

    /* renamed from: r */
    private boolean f10058r = false;

    /* compiled from: EffectiveAnimationDrawable.java */
    /* renamed from: com.oplus.anim.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    private interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo8942a(EffectiveAnimationComposition c2272a);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public EffectiveAnimationDrawable() {
        this.f10045e.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.anim.IntrinsicsJvm.kt_4.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (EffectiveAnimationDrawable.this.f10055o != null) {
                    EffectiveAnimationDrawable.this.f10055o.mo9081a(EffectiveAnimationDrawable.this.f10045e.m9256d());
                }
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m8907a() {
        return this.f10054n;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8906a(boolean z) {
        if (this.f10054n == z) {
            return;
        }
        if (Build.VERSION.SDK_INT < 19) {
            Log.w(f10041c, "Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.f10054n = z;
        if (this.f10048h != null) {
            m8891v();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8905a(String str) {
        this.f10051k = str;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public String m8909b() {
        return this.f10051k;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m8908a(EffectiveAnimationComposition c2272a) {
        if (this.f10048h == c2272a) {
            return false;
        }
        if (OplusLog.f10386b) {
            OplusLog.m9286b("EffectiveAnimationDrawable::setComposition:composition = " + c2272a.toString());
        }
        OplusLog.m9286b("EffectiveAnimationDrawable::setComposition");
        this.f10058r = false;
        m8918d();
        this.f10048h = c2272a;
        m8891v();
        this.f10045e.m9252a(c2272a);
        m8924e(this.f10045e.getAnimatedFraction());
        m8919d(this.f10049i);
        m8892w();
        Iterator it = new ArrayList(this.f10047g).iterator();
        while (it.hasNext()) {
            ((PlatformImplementations.kt_3) it.next()).mo8942a(c2272a);
            it.remove();
        }
        this.f10047g.clear();
        c2272a.m8790b(this.f10057q);
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m8913b(boolean z) {
        this.f10057q = z;
        EffectiveAnimationComposition c2272a = this.f10048h;
        if (c2272a != null) {
            c2272a.m8790b(z);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public PerformanceTracker m8914c() {
        EffectiveAnimationComposition c2272a = this.f10048h;
        if (c2272a != null) {
            return c2272a.m8792c();
        }
        return null;
    }

    /* renamed from: v */
    private void m8891v() {
        this.f10055o = new CompositionLayer(this, LayerParser.m9223a(this.f10048h), this.f10048h.m8798i(), this.f10048h);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m8918d() {
        if (this.f10045e.isRunning()) {
            this.f10045e.cancel();
        }
        this.f10048h = null;
        this.f10055o = null;
        this.f10050j = null;
        this.f10045e.m9258f();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.f10058r) {
            return;
        }
        this.f10058r = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f10056p;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int OplusGLSurfaceView_13) {
        this.f10056p = OplusGLSurfaceView_13;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Log.w("EffectiveAnimation", "Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float COUIBaseListPopupWindow_12;
        this.f10058r = false;
        L.m9347a("Drawable#draw#start");
        L.m9349c("Drawable#draw");
        if (this.f10055o == null) {
            return;
        }
        float f2 = this.f10049i;
        float fM8888a = m8888a(canvas);
        if (f2 > fM8888a) {
            COUIBaseListPopupWindow_12 = this.f10049i / fM8888a;
        } else {
            fM8888a = f2;
            COUIBaseListPopupWindow_12 = 1.0f;
        }
        int iSave = -1;
        if (COUIBaseListPopupWindow_12 > 1.0f) {
            iSave = canvas.save();
            float fWidth = this.f10048h.m8793d().width() / 2.0f;
            float fHeight = this.f10048h.m8793d().height() / 2.0f;
            float f3 = fWidth * fM8888a;
            float f4 = fHeight * fM8888a;
            canvas.translate((m8937q() * fWidth) - f3, (m8937q() * fHeight) - f4);
            canvas.scale(COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12, f3, f4);
        }
        this.f10044d.reset();
        this.f10044d.preScale(fM8888a, fM8888a);
        this.f10055o.mo8807a(canvas, this.f10044d, this.f10056p);
        L.m9347a("Drawable#draw#end time = " + L.m9350d("Drawable#draw"));
        if (iSave > 0) {
            canvas.restoreToCount(iSave);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        m8923e();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        m8926f();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return m8934n();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m8923e() {
        if (this.f10055o == null) {
            this.f10047g.add(new PlatformImplementations.kt_3() { // from class: com.oplus.anim.IntrinsicsJvm.kt_4.7
                @Override // com.oplus.anim.EffectiveAnimationDrawable.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo8942a(EffectiveAnimationComposition c2272a) {
                    EffectiveAnimationDrawable.this.m8923e();
                }
            });
        } else {
            this.f10045e.m9261i();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m8926f() {
        this.f10047g.clear();
        this.f10045e.m9262j();
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m8927g() {
        if (this.f10055o == null) {
            this.f10047g.add(new PlatformImplementations.kt_3() { // from class: com.oplus.anim.IntrinsicsJvm.kt_4.8
                @Override // com.oplus.anim.EffectiveAnimationDrawable.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo8942a(EffectiveAnimationComposition c2272a) {
                    EffectiveAnimationDrawable.this.m8927g();
                }
            });
        } else {
            this.f10045e.m9264l();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8899a(final int OplusGLSurfaceView_13) {
        if (this.f10048h == null) {
            this.f10047g.add(new PlatformImplementations.kt_3() { // from class: com.oplus.anim.IntrinsicsJvm.kt_4.9
                @Override // com.oplus.anim.EffectiveAnimationDrawable.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo8942a(EffectiveAnimationComposition c2272a) {
                    EffectiveAnimationDrawable.this.m8899a(OplusGLSurfaceView_13);
                }
            });
        } else {
            this.f10045e.m9254b(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public float m8928h() {
        return this.f10045e.m9265m();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m8912b(final String str) {
        EffectiveAnimationComposition c2272a = this.f10048h;
        if (c2272a == null) {
            this.f10047g.add(new PlatformImplementations.kt_3() { // from class: com.oplus.anim.IntrinsicsJvm.kt_4.10
                @Override // com.oplus.anim.EffectiveAnimationDrawable.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo8942a(EffectiveAnimationComposition c2272a2) {
                    EffectiveAnimationDrawable.this.m8912b(str);
                }
            });
            return;
        }
        Marker c2359hM8791c = c2272a.m8791c(str);
        if (c2359hM8791c == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
        m8899a((int) c2359hM8791c.f10315b);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8898a(final float COUIBaseListPopupWindow_12) {
        EffectiveAnimationComposition c2272a = this.f10048h;
        if (c2272a == null) {
            this.f10047g.add(new PlatformImplementations.kt_3() { // from class: com.oplus.anim.IntrinsicsJvm.kt_4.11
                @Override // com.oplus.anim.EffectiveAnimationDrawable.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo8942a(EffectiveAnimationComposition c2272a2) {
                    EffectiveAnimationDrawable.this.m8898a(COUIBaseListPopupWindow_12);
                }
            });
        } else {
            m8899a((int) MiscUtils.m9274a(c2272a.m8795f(), this.f10048h.m8796g(), COUIBaseListPopupWindow_12));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m8911b(final int OplusGLSurfaceView_13) {
        if (this.f10048h == null) {
            this.f10047g.add(new PlatformImplementations.kt_3() { // from class: com.oplus.anim.IntrinsicsJvm.kt_4.12
                @Override // com.oplus.anim.EffectiveAnimationDrawable.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo8942a(EffectiveAnimationComposition c2272a) {
                    EffectiveAnimationDrawable.this.m8911b(OplusGLSurfaceView_13);
                }
            });
        } else {
            this.f10045e.m9253b(OplusGLSurfaceView_13 + 0.99f);
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public float m8929i() {
        return this.f10045e.m9266n();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m8917c(final String str) {
        EffectiveAnimationComposition c2272a = this.f10048h;
        if (c2272a == null) {
            this.f10047g.add(new PlatformImplementations.kt_3() { // from class: com.oplus.anim.IntrinsicsJvm.kt_4.13
                @Override // com.oplus.anim.EffectiveAnimationDrawable.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo8942a(EffectiveAnimationComposition c2272a2) {
                    EffectiveAnimationDrawable.this.m8917c(str);
                }
            });
            return;
        }
        Marker c2359hM8791c = c2272a.m8791c(str);
        if (c2359hM8791c == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
        m8911b((int) (c2359hM8791c.f10315b + c2359hM8791c.f10316c));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m8910b(final float COUIBaseListPopupWindow_12) {
        EffectiveAnimationComposition c2272a = this.f10048h;
        if (c2272a == null) {
            this.f10047g.add(new PlatformImplementations.kt_3() { // from class: com.oplus.anim.IntrinsicsJvm.kt_4.14
                @Override // com.oplus.anim.EffectiveAnimationDrawable.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo8942a(EffectiveAnimationComposition c2272a2) {
                    EffectiveAnimationDrawable.this.m8910b(COUIBaseListPopupWindow_12);
                }
            });
        } else {
            m8911b((int) MiscUtils.m9274a(c2272a.m8795f(), this.f10048h.m8796g(), COUIBaseListPopupWindow_12));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m8921d(final String str) {
        EffectiveAnimationComposition c2272a = this.f10048h;
        if (c2272a == null) {
            this.f10047g.add(new PlatformImplementations.kt_3() { // from class: com.oplus.anim.IntrinsicsJvm.kt_4.2
                @Override // com.oplus.anim.EffectiveAnimationDrawable.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo8942a(EffectiveAnimationComposition c2272a2) {
                    EffectiveAnimationDrawable.this.m8921d(str);
                }
            });
            return;
        }
        Marker c2359hM8791c = c2272a.m8791c(str);
        if (c2359hM8791c == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
        int OplusGLSurfaceView_13 = (int) c2359hM8791c.f10315b;
        m8900a(OplusGLSurfaceView_13, ((int) c2359hM8791c.f10316c) + OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8900a(final int OplusGLSurfaceView_13, final int i2) {
        if (this.f10048h == null) {
            this.f10047g.add(new PlatformImplementations.kt_3() { // from class: com.oplus.anim.IntrinsicsJvm.kt_4.3
                @Override // com.oplus.anim.EffectiveAnimationDrawable.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo8942a(EffectiveAnimationComposition c2272a) {
                    EffectiveAnimationDrawable.this.m8900a(OplusGLSurfaceView_13, i2);
                }
            });
        } else {
            this.f10045e.m9250a(OplusGLSurfaceView_13, i2 + 0.99f);
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public float m8930j() {
        return this.f10045e.m9260h();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m8915c(float COUIBaseListPopupWindow_12) {
        this.f10045e.m9249a(COUIBaseListPopupWindow_12);
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public int m8931k() {
        return (int) this.f10045e.m9257e();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m8916c(final int OplusGLSurfaceView_13) {
        if (this.f10048h == null) {
            this.f10047g.add(new PlatformImplementations.kt_3() { // from class: com.oplus.anim.IntrinsicsJvm.kt_4.4
                @Override // com.oplus.anim.EffectiveAnimationDrawable.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo8942a(EffectiveAnimationComposition c2272a) {
                    EffectiveAnimationDrawable.this.m8916c(OplusGLSurfaceView_13);
                }
            });
        } else {
            this.f10045e.m9251a(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public int m8932l() {
        return this.f10045e.getRepeatMode();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m8920d(int OplusGLSurfaceView_13) {
        this.f10045e.setRepeatMode(OplusGLSurfaceView_13);
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public int m8933m() {
        return this.f10045e.getRepeatCount();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m8925e(int OplusGLSurfaceView_13) {
        this.f10045e.setRepeatCount(OplusGLSurfaceView_13);
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public boolean m8934n() {
        return this.f10045e.isRunning();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8903a(ImageAssetDelegate interfaceC2418j) {
        this.f10052l = interfaceC2418j;
        ImageAssetManager c2311b = this.f10050j;
        if (c2311b != null) {
            c2311b.m8949a(interfaceC2418j);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8902a(FontAssetDelegate c2417i) {
        this.f10042a = c2417i;
        FontAssetManager c2310a = this.f10053m;
        if (c2310a != null) {
            c2310a.m8946a(c2417i);
        }
    }

    /* renamed from: o */
    public TextDelegate m8935o() {
        return this.f10043b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8904a(TextDelegate c2424p) {
        this.f10043b = c2424p;
    }

    /* renamed from: p */
    public boolean m8936p() {
        return this.f10043b == null && this.f10048h.m8799j().size() > 0;
    }

    /* renamed from: q */
    public float m8937q() {
        return this.f10049i;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m8919d(float COUIBaseListPopupWindow_12) {
        this.f10049i = COUIBaseListPopupWindow_12;
        m8892w();
    }

    /* renamed from: r */
    public EffectiveAnimationComposition m8938r() {
        return this.f10048h;
    }

    /* renamed from: w */
    private void m8892w() {
        if (this.f10048h == null) {
            return;
        }
        float fM8937q = m8937q();
        setBounds(0, 0, (int) (this.f10048h.m8793d().width() * fM8937q), (int) (this.f10048h.m8793d().height() * fM8937q));
    }

    /* renamed from: s */
    public void m8939s() {
        this.f10047g.clear();
        this.f10045e.cancel();
    }

    /* renamed from: t */
    public void m8940t() {
        this.f10047g.clear();
        this.f10045e.m9263k();
    }

    /* renamed from: u */
    public float m8941u() {
        return this.f10045e.m9256d();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m8924e(final float COUIBaseListPopupWindow_12) {
        EffectiveAnimationComposition c2272a = this.f10048h;
        if (c2272a == null) {
            this.f10047g.add(new PlatformImplementations.kt_3() { // from class: com.oplus.anim.IntrinsicsJvm.kt_4.5
                @Override // com.oplus.anim.EffectiveAnimationDrawable.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo8942a(EffectiveAnimationComposition c2272a2) {
                    EffectiveAnimationDrawable.this.m8924e(COUIBaseListPopupWindow_12);
                }
            });
        } else {
            m8916c((int) MiscUtils.m9274a(c2272a.m8795f(), this.f10048h.m8796g(), COUIBaseListPopupWindow_12));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f10048h == null) {
            return -1;
        }
        return (int) (r0.m8793d().width() * m8937q());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f10048h == null) {
            return -1;
        }
        return (int) (r0.m8793d().height() * m8937q());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public List<KeyPath> m8897a(KeyPath c2357f) {
        if (this.f10055o == null) {
            Log.w("EffectiveAnimation", "Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.f10055o.mo8809a(c2357f, 0, arrayList, new KeyPath(new String[0]));
        return arrayList;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public <T> void m8901a(final KeyPath c2357f, final T t, final EffectiveValueCallback<T> c2412b) {
        if (this.f10055o == null) {
            this.f10047g.add(new PlatformImplementations.kt_3() { // from class: com.oplus.anim.IntrinsicsJvm.kt_4.6
                @Override // com.oplus.anim.EffectiveAnimationDrawable.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo8942a(EffectiveAnimationComposition c2272a) {
                    EffectiveAnimationDrawable.this.m8901a(c2357f, t, c2412b);
                }
            });
            return;
        }
        boolean zIsEmpty = true;
        if (c2357f.m9137a() != null) {
            c2357f.m9137a().mo8810a(t, c2412b);
        } else {
            List<KeyPath> listM8897a = m8897a(c2357f);
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < listM8897a.size(); OplusGLSurfaceView_13++) {
                if (OplusLog.f10387c) {
                    OplusLog.m9285a("EffectiveAnimationDrawable::KeyPath = " + listM8897a.get(OplusGLSurfaceView_13));
                }
                listM8897a.get(OplusGLSurfaceView_13).m9137a().mo8810a(t, c2412b);
            }
            zIsEmpty = true ^ listM8897a.isEmpty();
        }
        if (zIsEmpty) {
            invalidateSelf();
            if (t == InterfaceC2361d.f10343y) {
                m8924e(m8941u());
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public Bitmap m8922e(String str) {
        ImageAssetManager c2311bM8893x = m8893x();
        if (c2311bM8893x != null) {
            return c2311bM8893x.m8948a(str);
        }
        return null;
    }

    /* renamed from: x */
    private ImageAssetManager m8893x() {
        if (getCallback() == null) {
            return null;
        }
        ImageAssetManager c2311b = this.f10050j;
        if (c2311b != null && !c2311b.m8950a(m8895z())) {
            this.f10050j = null;
        }
        if (this.f10050j == null) {
            this.f10050j = new ImageAssetManager(getCallback(), this.f10051k, this.f10052l, this.f10048h.m8801l());
        }
        return this.f10050j;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Typeface m8896a(String str, String str2) {
        FontAssetManager c2310aM8894y = m8894y();
        if (c2310aM8894y != null) {
            return c2310aM8894y.m8945a(str, str2);
        }
        return null;
    }

    /* renamed from: y */
    private FontAssetManager m8894y() {
        if (getCallback() == null) {
            return null;
        }
        if (this.f10053m == null) {
            this.f10053m = new FontAssetManager(getCallback(), this.f10042a);
        }
        return this.f10053m;
    }

    /* renamed from: z */
    private Context m8895z() {
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

    /* renamed from: PlatformImplementations.kt_3 */
    private float m8888a(Canvas canvas) {
        return Math.min(canvas.getWidth() / this.f10048h.m8793d().width(), canvas.getHeight() / this.f10048h.m8793d().height());
    }
}
