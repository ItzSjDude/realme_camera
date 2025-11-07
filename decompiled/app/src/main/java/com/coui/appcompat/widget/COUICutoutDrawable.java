package com.coui.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.p036h.GravityCompat;
import com.coui.appcompat.p099a.COUIChangeTextUtil;
import java.util.Locale;

/* compiled from: COUICutoutDrawable.java */
/* renamed from: com.coui.appcompat.widget.IntrinsicsJvm.kt_5 */
/* loaded from: classes.dex */
public class COUICutoutDrawable extends GradientDrawable {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Paint f7951a = new Paint(1);

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final RectF f7952b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f7953c;

    public COUICutoutDrawable() {
        m7547d();
        this.f7952b = new RectF();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m7547d() {
        this.f7951a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f7951a.setColor(-1);
        this.f7951a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m7550a() {
        return !this.f7952b.isEmpty();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public RectF m7551b() {
        return this.f7952b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m7548a(float COUIBaseListPopupWindow_12, float f2, float f3, float f4) {
        if (COUIBaseListPopupWindow_12 == this.f7952b.left && f2 == this.f7952b.top && f3 == this.f7952b.right && f4 == this.f7952b.bottom) {
            return;
        }
        this.f7952b.set(COUIBaseListPopupWindow_12, f2, f3, f4);
        invalidateSelf();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m7549a(RectF rectF) {
        m7548a(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m7552c() {
        m7548a(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        m7543a(canvas);
        super.draw(canvas);
        canvas.drawRect(this.f7952b, this.f7951a);
        m7546c(canvas);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7543a(Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (m7544a(callback)) {
            ((View) callback).setLayerType(2, null);
        } else {
            m7545b(canvas);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m7545b(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f7953c = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
        } else {
            this.f7953c = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null, 31);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m7546c(Canvas canvas) {
        if (m7544a(getCallback())) {
            return;
        }
        canvas.restoreToCount(this.f7953c);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m7544a(Drawable.Callback callback) {
        return callback instanceof View;
    }

    /* compiled from: COUICutoutDrawable.java */
    /* renamed from: com.coui.appcompat.widget.IntrinsicsJvm.kt_5$PlatformImplementations.kt_3 */
    public static final class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private static final boolean f7954a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private static final Paint f7955b;

        /* renamed from: A */
        private float f7956A;

        /* renamed from: B */
        private float f7957B;

        /* renamed from: C */
        private float f7958C;

        /* renamed from: D */
        private float f7959D;

        /* renamed from: E */
        private int[] f7960E;

        /* renamed from: F */
        private boolean f7961F;

        /* renamed from: I */
        private Interpolator f7964I;

        /* renamed from: J */
        private Interpolator f7965J;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final View f7966c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private boolean f7967d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private float f7968e;

        /* renamed from: OplusGLSurfaceView_6 */
        private ColorStateList f7976m;

        /* renamed from: OplusGLSurfaceView_11 */
        private ColorStateList f7977n;

        /* renamed from: o */
        private float f7978o;

        /* renamed from: p */
        private float f7979p;

        /* renamed from: q */
        private float f7980q;

        /* renamed from: r */
        private float f7981r;

        /* renamed from: s */
        private float f7982s;

        /* renamed from: t */
        private float f7983t;

        /* renamed from: u */
        private CharSequence f7984u;

        /* renamed from: v */
        private CharSequence f7985v;

        /* renamed from: w */
        private boolean f7986w;

        /* renamed from: x */
        private boolean f7987x;

        /* renamed from: y */
        private Bitmap f7988y;

        /* renamed from: z */
        private Paint f7989z;

        /* renamed from: OplusGLSurfaceView_13 */
        private int f7972i = 16;

        /* renamed from: OplusGLSurfaceView_15 */
        private int f7973j = 16;

        /* renamed from: OplusGLSurfaceView_5 */
        private float f7974k = 30.0f;

        /* renamed from: OplusGLSurfaceView_14 */
        private float f7975l = 30.0f;

        /* renamed from: G */
        private final TextPaint f7962G = new TextPaint(129);

        /* renamed from: H */
        private final TextPaint f7963H = new TextPaint(this.f7962G);

        /* renamed from: COUIBaseListPopupWindow_11 */
        private final Rect f7970g = new Rect();

        /* renamed from: COUIBaseListPopupWindow_12 */
        private final Rect f7969f = new Rect();

        /* renamed from: COUIBaseListPopupWindow_10 */
        private final RectF f7971h = new RectF();

        /* renamed from: PlatformImplementations.kt_3 */
        private float m7553a(float COUIBaseListPopupWindow_12, float f2, float f3) {
            return COUIBaseListPopupWindow_12 < f2 ? f2 : COUIBaseListPopupWindow_12 > f3 ? f3 : COUIBaseListPopupWindow_12;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        private static float m7559b(float COUIBaseListPopupWindow_12, float f2, float f3) {
            return COUIBaseListPopupWindow_12 + (f3 * (f2 - COUIBaseListPopupWindow_12));
        }

        static {
            f7954a = Build.VERSION.SDK_INT < 18;
            f7955b = null;
            Paint paint = f7955b;
            if (paint != null) {
                paint.setAntiAlias(true);
                f7955b.setColor(-65281);
            }
        }

        public PlatformImplementations.kt_3(View view) {
            this.f7966c = view;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m7581a(Interpolator interpolator) {
            this.f7965J = interpolator;
            m7600m();
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m7589b(Interpolator interpolator) {
            this.f7964I = interpolator;
            m7600m();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m7573a(float COUIBaseListPopupWindow_12) {
            if (this.f7974k != COUIBaseListPopupWindow_12) {
                this.f7974k = COUIBaseListPopupWindow_12;
                m7600m();
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m7577a(ColorStateList colorStateList) {
            if (this.f7977n != colorStateList) {
                this.f7977n = colorStateList;
                m7600m();
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m7588b(ColorStateList colorStateList) {
            if (this.f7976m != colorStateList) {
                this.f7976m = colorStateList;
                m7600m();
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public Rect m7572a() {
            return this.f7969f;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m7575a(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
            if (m7558a(this.f7969f, OplusGLSurfaceView_13, i2, i3, i4)) {
                return;
            }
            this.f7969f.set(OplusGLSurfaceView_13, i2, i3, i4);
            this.f7961F = true;
            m7565q();
            Log.IntrinsicsJvm.kt_5("COUICollapseTextHelper", "setExpandedBounds: " + this.f7969f);
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public Rect m7584b() {
            return this.f7970g;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m7587b(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
            if (m7558a(this.f7970g, OplusGLSurfaceView_13, i2, i3, i4)) {
                return;
            }
            this.f7970g.set(OplusGLSurfaceView_13, i2, i3, i4);
            this.f7961F = true;
            m7565q();
            Log.IntrinsicsJvm.kt_5("COUICollapseTextHelper", "setCollapsedBounds: " + this.f7970g);
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public float m7590c() {
            if (this.f7984u == null) {
                return 0.0f;
            }
            m7556a(this.f7963H);
            TextPaint textPaint = this.f7963H;
            CharSequence charSequence = this.f7984u;
            return textPaint.measureText(charSequence, 0, charSequence.length());
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public float m7591d() {
            m7556a(this.f7963H);
            if (Locale.getDefault().getLanguage().equals("my")) {
                return (-this.f7963H.ascent()) * 1.3f;
            }
            return -this.f7963H.ascent();
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        public float m7592e() {
            m7556a(this.f7963H);
            float fDescent = this.f7963H.descent() - this.f7963H.ascent();
            return Locale.getDefault().getLanguage().equals("my") ? fDescent * 1.3f : fDescent;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m7579a(RectF rectF) {
            float fM7590c;
            boolean zM7560b = m7560b(this.f7984u);
            if (!zM7560b) {
                fM7590c = this.f7970g.left;
            } else {
                fM7590c = this.f7970g.right - m7590c();
            }
            rectF.left = fM7590c;
            rectF.top = this.f7970g.top;
            rectF.right = !zM7560b ? rectF.left + m7590c() : this.f7970g.right;
            rectF.bottom = this.f7970g.top + m7591d();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m7556a(TextPaint textPaint) {
            textPaint.setTextSize(this.f7975l);
        }

        /* renamed from: q */
        private void m7565q() {
            this.f7967d = this.f7970g.width() > 0 && this.f7970g.height() > 0 && this.f7969f.width() > 0 && this.f7969f.height() > 0;
        }

        /* renamed from: COUIBaseListPopupWindow_12 */
        public int m7593f() {
            return this.f7972i;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m7574a(int OplusGLSurfaceView_13) {
            if (this.f7972i != OplusGLSurfaceView_13) {
                this.f7972i = OplusGLSurfaceView_13;
                m7600m();
            }
        }

        /* renamed from: COUIBaseListPopupWindow_11 */
        public int m7594g() {
            return this.f7973j;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m7586b(int OplusGLSurfaceView_13) {
            if (this.f7973j != OplusGLSurfaceView_13) {
                this.f7973j = OplusGLSurfaceView_13;
                m7600m();
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m7576a(int OplusGLSurfaceView_13, ColorStateList colorStateList) {
            this.f7977n = colorStateList;
            this.f7975l = OplusGLSurfaceView_13;
            m7600m();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m7580a(Typeface typeface) {
            COUIChangeTextUtil.m6389a((Paint) this.f7962G, true);
            COUIChangeTextUtil.m6389a((Paint) this.f7963H, true);
            m7600m();
        }

        /* renamed from: COUIBaseListPopupWindow_10 */
        public float m7595h() {
            return this.f7968e;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m7585b(float COUIBaseListPopupWindow_12) {
            float fM7553a = m7553a(COUIBaseListPopupWindow_12, 0.0f, 1.0f);
            if (fM7553a != this.f7968e) {
                this.f7968e = fM7553a;
                m7566r();
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public final boolean m7583a(int[] iArr) {
            this.f7960E = iArr;
            if (!m7596i()) {
                return false;
            }
            m7600m();
            return true;
        }

        /* renamed from: OplusGLSurfaceView_13 */
        final boolean m7596i() {
            ColorStateList colorStateList;
            ColorStateList colorStateList2 = this.f7977n;
            return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f7976m) != null && colorStateList.isStateful());
        }

        /* renamed from: OplusGLSurfaceView_15 */
        public float m7597j() {
            return this.f7968e;
        }

        /* renamed from: OplusGLSurfaceView_5 */
        float m7598k() {
            return this.f7974k;
        }

        /* renamed from: r */
        private void m7566r() {
            m7561c(this.f7968e);
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        private void m7561c(float COUIBaseListPopupWindow_12) {
            m7562d(COUIBaseListPopupWindow_12);
            this.f7982s = m7554a(this.f7980q, this.f7981r, COUIBaseListPopupWindow_12, this.f7964I);
            this.f7983t = m7554a(this.f7978o, this.f7979p, COUIBaseListPopupWindow_12, this.f7964I);
            m7563e(m7554a(this.f7974k, this.f7975l, COUIBaseListPopupWindow_12, this.f7965J));
            if (this.f7977n != this.f7976m) {
                this.f7962G.setColor(m7555a(m7567s(), m7599l(), COUIBaseListPopupWindow_12));
            } else {
                this.f7962G.setColor(m7599l());
            }
            this.f7966c.postInvalidate();
        }

        /* renamed from: s */
        private int m7567s() {
            int[] iArr = this.f7960E;
            if (iArr != null) {
                return this.f7976m.getColorForState(iArr, 0);
            }
            return this.f7976m.getDefaultColor();
        }

        /* renamed from: OplusGLSurfaceView_14 */
        public int m7599l() {
            int[] iArr = this.f7960E;
            if (iArr != null) {
                return this.f7977n.getColorForState(iArr, 0);
            }
            return this.f7977n.getDefaultColor();
        }

        /* renamed from: t */
        private void m7568t() {
            float COUIBaseListPopupWindow_12 = this.f7959D;
            m7564f(this.f7975l);
            CharSequence charSequence = this.f7985v;
            float fMeasureText = charSequence != null ? this.f7962G.measureText(charSequence, 0, charSequence.length()) : 0.0f;
            int iM2773a = GravityCompat.m2773a(this.f7973j, this.f7986w ? 1 : 0);
            int OplusGLSurfaceView_13 = iM2773a & 112;
            if (OplusGLSurfaceView_13 != 48) {
                if (OplusGLSurfaceView_13 == 80) {
                    this.f7979p = this.f7970g.bottom;
                } else {
                    this.f7979p = this.f7970g.centerY() + (((this.f7962G.descent() - this.f7962G.ascent()) / 2.0f) - this.f7962G.descent());
                }
            } else if (Locale.getDefault().getLanguage().equals("my")) {
                this.f7979p = this.f7970g.top - (this.f7962G.ascent() * 1.3f);
            } else {
                this.f7979p = this.f7970g.top - this.f7962G.ascent();
            }
            int i2 = iM2773a & 8388615;
            if (i2 == 1) {
                this.f7981r = this.f7970g.centerX() - (fMeasureText / 2.0f);
            } else if (i2 == 5) {
                this.f7981r = this.f7970g.right - fMeasureText;
            } else {
                this.f7981r = this.f7970g.left;
            }
            m7564f(this.f7974k);
            CharSequence charSequence2 = this.f7985v;
            float fMeasureText2 = charSequence2 != null ? this.f7962G.measureText(charSequence2, 0, charSequence2.length()) : 0.0f;
            int iM2773a2 = GravityCompat.m2773a(this.f7972i, this.f7986w ? 1 : 0);
            int i3 = iM2773a2 & 112;
            if (i3 == 48) {
                this.f7978o = this.f7969f.top - this.f7962G.ascent();
            } else if (i3 == 80) {
                this.f7978o = this.f7969f.bottom;
            } else {
                this.f7978o = this.f7969f.centerY() + (((this.f7962G.getFontMetrics().bottom - this.f7962G.getFontMetrics().top) / 2.0f) - this.f7962G.getFontMetrics().bottom);
            }
            int i4 = iM2773a2 & 8388615;
            if (i4 == 1) {
                this.f7980q = this.f7969f.centerX() - (fMeasureText2 / 2.0f);
            } else if (i4 == 5) {
                this.f7980q = this.f7969f.right - fMeasureText2;
            } else {
                this.f7980q = this.f7969f.left;
            }
            m7570v();
            m7563e(COUIBaseListPopupWindow_12);
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        private void m7562d(float COUIBaseListPopupWindow_12) {
            this.f7971h.left = m7554a(this.f7969f.left, this.f7970g.left, COUIBaseListPopupWindow_12, this.f7964I);
            this.f7971h.top = m7554a(this.f7978o, this.f7979p, COUIBaseListPopupWindow_12, this.f7964I);
            this.f7971h.right = m7554a(this.f7969f.right, this.f7970g.right, COUIBaseListPopupWindow_12, this.f7964I);
            this.f7971h.bottom = m7554a(this.f7969f.bottom, this.f7970g.bottom, COUIBaseListPopupWindow_12, this.f7964I);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m7578a(Canvas canvas) {
            float fAscent;
            int iSave = canvas.save();
            if (this.f7985v != null && this.f7967d) {
                float COUIBaseListPopupWindow_12 = this.f7982s;
                float f2 = this.f7983t;
                boolean z = this.f7987x && this.f7988y != null;
                if (z) {
                    fAscent = this.f7956A * this.f7958C;
                    float f3 = this.f7957B;
                } else {
                    fAscent = this.f7962G.ascent() * this.f7958C;
                    this.f7962G.descent();
                    float f4 = this.f7958C;
                }
                if (z) {
                    f2 += fAscent;
                }
                float f5 = f2;
                float f6 = this.f7958C;
                if (f6 != 1.0f) {
                    canvas.scale(f6, f6, COUIBaseListPopupWindow_12, f5);
                }
                if (z) {
                    canvas.drawBitmap(this.f7988y, COUIBaseListPopupWindow_12, f5, this.f7989z);
                } else {
                    CharSequence charSequence = this.f7985v;
                    canvas.drawText(charSequence, 0, charSequence.length(), COUIBaseListPopupWindow_12, f5, this.f7962G);
                }
            } else {
                canvas.drawText(" ", 0.0f, 0.0f, this.f7962G);
            }
            canvas.restoreToCount(iSave);
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        private boolean m7560b(CharSequence charSequence) {
            return m7571w();
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        private void m7563e(float COUIBaseListPopupWindow_12) {
            m7564f(COUIBaseListPopupWindow_12);
            this.f7987x = f7954a && this.f7958C != 1.0f;
            if (this.f7987x) {
                m7569u();
            }
            this.f7966c.postInvalidate();
        }

        /* renamed from: COUIBaseListPopupWindow_12 */
        private void m7564f(float COUIBaseListPopupWindow_12) {
            float f2;
            boolean z;
            if (this.f7984u == null) {
                return;
            }
            float fWidth = this.f7970g.width();
            float fWidth2 = this.f7969f.width();
            if (m7557a(COUIBaseListPopupWindow_12, this.f7975l)) {
                float f3 = this.f7975l;
                this.f7958C = 1.0f;
                f2 = f3;
            } else {
                f2 = this.f7974k;
                if (m7557a(COUIBaseListPopupWindow_12, f2)) {
                    this.f7958C = 1.0f;
                } else {
                    this.f7958C = COUIBaseListPopupWindow_12 / this.f7974k;
                }
                float f4 = this.f7975l / this.f7974k;
                fWidth = fWidth2 * f4 > fWidth ? Math.min(fWidth / f4, fWidth2) : fWidth2;
            }
            if (fWidth > 0.0f) {
                z = this.f7959D != f2 || this.f7961F;
                this.f7959D = f2;
                this.f7961F = false;
            } else {
                z = false;
            }
            if (this.f7985v == null || z) {
                this.f7962G.setTextSize(this.f7959D);
                this.f7962G.setLinearText(this.f7958C != 1.0f);
                CharSequence charSequenceEllipsize = TextUtils.ellipsize(this.f7984u, this.f7962G, fWidth, TextUtils.TruncateAt.END);
                if (!TextUtils.equals(charSequenceEllipsize, this.f7985v)) {
                    this.f7985v = charSequenceEllipsize;
                }
            }
            this.f7986w = m7571w();
        }

        /* renamed from: u */
        private void m7569u() {
            if (this.f7988y != null || this.f7969f.isEmpty() || TextUtils.isEmpty(this.f7985v)) {
                return;
            }
            m7561c(0.0f);
            this.f7956A = this.f7962G.ascent();
            this.f7957B = this.f7962G.descent();
            TextPaint textPaint = this.f7962G;
            CharSequence charSequence = this.f7985v;
            int iRound = Math.round(textPaint.measureText(charSequence, 0, charSequence.length()));
            int iRound2 = Math.round(this.f7957B - this.f7956A);
            if (iRound <= 0 || iRound2 <= 0) {
                return;
            }
            this.f7988y = Bitmap.createBitmap(iRound, iRound2, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.f7988y);
            CharSequence charSequence2 = this.f7985v;
            canvas.drawText(charSequence2, 0, charSequence2.length(), 0.0f, iRound2 - this.f7962G.descent(), this.f7962G);
            if (this.f7989z == null) {
                this.f7989z = new Paint(3);
            }
        }

        /* renamed from: OplusGLSurfaceView_6 */
        public void m7600m() {
            if (this.f7966c.getHeight() <= 0 || this.f7966c.getWidth() <= 0) {
                return;
            }
            m7568t();
            m7566r();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m7582a(CharSequence charSequence) {
            if (charSequence == null || !charSequence.equals(this.f7984u)) {
                this.f7984u = charSequence;
                this.f7985v = null;
                m7570v();
                m7600m();
            }
        }

        /* renamed from: OplusGLSurfaceView_11 */
        CharSequence m7601n() {
            return this.f7984u;
        }

        /* renamed from: v */
        private void m7570v() {
            Bitmap bitmap = this.f7988y;
            if (bitmap != null) {
                bitmap.recycle();
                this.f7988y = null;
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private static boolean m7557a(float COUIBaseListPopupWindow_12, float f2) {
            return Math.abs(COUIBaseListPopupWindow_12 - f2) < 0.001f;
        }

        /* renamed from: o */
        ColorStateList m7602o() {
            return this.f7976m;
        }

        /* renamed from: p */
        public ColorStateList m7603p() {
            return this.f7977n;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private static int m7555a(int OplusGLSurfaceView_13, int i2, float COUIBaseListPopupWindow_12) {
            float f2 = 1.0f - COUIBaseListPopupWindow_12;
            return Color.argb((int) ((Color.alpha(OplusGLSurfaceView_13) * f2) + (Color.alpha(i2) * COUIBaseListPopupWindow_12)), (int) ((Color.red(OplusGLSurfaceView_13) * f2) + (Color.red(i2) * COUIBaseListPopupWindow_12)), (int) ((Color.green(OplusGLSurfaceView_13) * f2) + (Color.green(i2) * COUIBaseListPopupWindow_12)), (int) ((Color.blue(OplusGLSurfaceView_13) * f2) + (Color.blue(i2) * COUIBaseListPopupWindow_12)));
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private static float m7554a(float COUIBaseListPopupWindow_12, float f2, float f3, Interpolator interpolator) {
            if (interpolator != null) {
                f3 = interpolator.getInterpolation(f3);
            }
            return m7559b(COUIBaseListPopupWindow_12, f2, f3);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private static boolean m7558a(Rect rect, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
            return rect.left == OplusGLSurfaceView_13 && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
        }

        /* renamed from: w */
        private boolean m7571w() {
            return Build.VERSION.SDK_INT > 16 && this.f7966c.getLayoutDirection() == 1;
        }
    }
}
