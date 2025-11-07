package com.oplus.camera.panorama;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.util.Util;

/* loaded from: classes2.dex */
public class PanoramaProgressBar extends View {

    /* renamed from: PlatformImplementations.kt_3 */
    private static int f14854a = 0;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static int f14855b = 0;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static int f14856c = 0;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static int f14857d = 0;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static int f14858e = 6;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static float f14859f = 6.0f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private static float f14860g = 6.0f;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private static int f14861h = 120;

    /* renamed from: OplusGLSurfaceView_13 */
    private static int f14862i = 120;

    /* renamed from: OplusGLSurfaceView_15 */
    private static int f14863j = 0;

    /* renamed from: OplusGLSurfaceView_5 */
    private static int f14864k = 0;

    /* renamed from: OplusGLSurfaceView_14 */
    private static int f14865l = 0;

    /* renamed from: OplusGLSurfaceView_6 */
    private static int f14866m = 36;

    /* renamed from: OplusGLSurfaceView_11 */
    private static int f14867n = 0;

    /* renamed from: o */
    private static int f14868o = 36;

    /* renamed from: p */
    private static int f14869p;

    /* renamed from: q */
    private static int f14870q;

    /* renamed from: r */
    private static int f14871r;

    /* renamed from: A */
    private int f14872A;

    /* renamed from: B */
    private int f14873B;

    /* renamed from: C */
    private int f14874C;

    /* renamed from: D */
    private int f14875D;

    /* renamed from: E */
    private int f14876E;

    /* renamed from: F */
    private int f14877F;

    /* renamed from: G */
    private int f14878G;

    /* renamed from: H */
    private int f14879H;

    /* renamed from: I */
    private int f14880I;

    /* renamed from: J */
    private int f14881J;

    /* renamed from: K */
    private Drawable f14882K;

    /* renamed from: L */
    private Drawable f14883L;

    /* renamed from: M */
    private PathInterpolator f14884M;

    /* renamed from: N */
    private PathInterpolator f14885N;

    /* renamed from: O */
    private ObjectAnimator f14886O;

    /* renamed from: P */
    private ObjectAnimator f14887P;

    /* renamed from: Q */
    private ObjectAnimator f14888Q;

    /* renamed from: R */
    private ObjectAnimator f14889R;

    /* renamed from: S */
    private ObjectAnimator f14890S;

    /* renamed from: T */
    private ObjectAnimator f14891T;

    /* renamed from: U */
    private ObjectAnimator f14892U;

    /* renamed from: V */
    private ObjectAnimator f14893V;

    /* renamed from: W */
    private ObjectAnimator f14894W;

    /* renamed from: aa */
    private Drawable f14895aa;

    /* renamed from: ab */
    private Rect f14896ab;

    /* renamed from: ac */
    private Rect f14897ac;

    /* renamed from: ad */
    private Rect f14898ad;

    /* renamed from: ae */
    private Rect f14899ae;

    /* renamed from: af */
    private Rect f14900af;

    /* renamed from: ag */
    private Resources f14901ag;

    /* renamed from: ah */
    private Paint f14902ah;

    /* renamed from: ai */
    private Paint f14903ai;

    /* renamed from: aj */
    private Paint f14904aj;

    /* renamed from: ak */
    private Path f14905ak;

    /* renamed from: al */
    private DashPathEffect f14906al;

    /* renamed from: am */
    private Paint f14907am;

    /* renamed from: an */
    private Paint f14908an;

    /* renamed from: ao */
    private int f14909ao;

    /* renamed from: ap */
    private float f14910ap;

    /* renamed from: aq */
    private int f14911aq;

    /* renamed from: ar */
    private RearPanoramaInterface f14912ar;

    /* renamed from: as */
    private int f14913as;

    /* renamed from: at */
    private Rect f14914at;

    /* renamed from: au */
    private int f14915au;

    /* renamed from: av */
    private int f14916av;

    /* renamed from: aw */
    private int f14917aw;

    /* renamed from: ax */
    private Bitmap f14918ax;

    /* renamed from: s */
    private Bitmap f14919s;

    /* renamed from: t */
    private Bitmap f14920t;

    /* renamed from: u */
    private Canvas f14921u;

    /* renamed from: v */
    private Paint f14922v;

    /* renamed from: w */
    private boolean f14923w;

    /* renamed from: x */
    private int f14924x;

    /* renamed from: y */
    private int f14925y;

    /* renamed from: z */
    private int f14926z;

    public interface RearPanoramaInterface {
        void onReportDirectionChange(int OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14903a() {
        CameraLog.m12954a("PanoramaProgressBar", "startArrowAnimation, mDirection: " + this.f14924x);
        int OplusGLSurfaceView_13 = this.f14924x;
        if (OplusGLSurfaceView_13 != -1) {
            if (OplusGLSurfaceView_13 == 2) {
                m14895p();
                return;
            } else {
                if (OplusGLSurfaceView_13 != 3) {
                    return;
                }
                m14893n();
                return;
            }
        }
        int i2 = this.f14925y;
        if (4 == i2) {
            m14892m();
        } else if (5 == i2) {
            m14894o();
        }
    }

    public PanoramaProgressBar(Context context) {
        super(context);
        this.f14919s = null;
        this.f14920t = null;
        this.f14921u = null;
        this.f14922v = null;
        this.f14923w = false;
        this.f14924x = -1;
        this.f14925y = 0;
        this.f14926z = 0;
        this.f14872A = 0;
        this.f14873B = 0;
        this.f14874C = 0;
        this.f14875D = 0;
        this.f14876E = 0;
        this.f14877F = 0;
        this.f14878G = 0;
        this.f14879H = 0;
        this.f14880I = 0;
        this.f14881J = 0;
        this.f14882K = null;
        this.f14883L = null;
        this.f14884M = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.f14885N = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f14886O = null;
        this.f14887P = null;
        this.f14888Q = null;
        this.f14889R = null;
        this.f14890S = null;
        this.f14891T = null;
        this.f14892U = null;
        this.f14893V = null;
        this.f14894W = null;
        this.f14895aa = null;
        this.f14896ab = new Rect();
        this.f14897ac = new Rect();
        this.f14898ad = new Rect();
        this.f14899ae = new Rect();
        this.f14900af = new Rect();
        this.f14901ag = null;
        this.f14902ah = null;
        this.f14903ai = null;
        this.f14904aj = null;
        this.f14905ak = null;
        this.f14906al = null;
        this.f14907am = null;
        this.f14908an = null;
        this.f14909ao = 0;
        this.f14910ap = 0.0f;
        this.f14911aq = 0;
        this.f14912ar = null;
        this.f14913as = 0;
        this.f14914at = new Rect();
        this.f14915au = -1;
        this.f14916av = 0;
        this.f14917aw = 0;
        this.f14918ax = null;
        this.f14901ag = context.getApplicationContext().getResources();
        this.f14895aa = this.f14901ag.getDrawable(R.drawable.panrama_progress_bar_bg);
        this.f14882K = this.f14901ag.getDrawable(R.drawable.arrow_left);
        this.f14883L = this.f14901ag.getDrawable(R.drawable.arrow_right);
        m14888i();
        f14861h = this.f14901ag.getDimensionPixelSize(R.dimen.panorama_arrow_width);
        f14862i = this.f14901ag.getDimensionPixelSize(R.dimen.panorama_arrow_height);
        f14858e = this.f14901ag.getDimensionPixelSize(R.dimen.panorama_line_width);
        f14859f = this.f14901ag.getDimension(R.dimen.panorama_line_dash_width);
        f14860g = this.f14901ag.getDimension(R.dimen.panorama_line_spacing_width);
        f14866m = this.f14901ag.getDimensionPixelSize(R.dimen.panorama_progressbar_margin_left);
        f14868o = this.f14901ag.getDimensionPixelSize(R.dimen.panorama_arrow_margin_left);
        f14869p = this.f14901ag.getColor(R.color.color_white_with_full_percent_transparency);
        f14870q = Util.m24164A(context);
        f14871r = this.f14901ag.getDimensionPixelOffset(R.dimen.panorama_line_offset_threshold);
        this.f14875D = Util.m24495t() ? this.f14901ag.getDimensionPixelSize(R.dimen.full_screen_panorama_init_rect_width) : this.f14901ag.getDimensionPixelOffset(R.dimen.panorama_init_rect_width);
        this.f14909ao = this.f14901ag.getDimensionPixelSize(R.dimen.panorama_rim_width);
        this.f14910ap = this.f14909ao / 2.0f;
        this.f14911aq = Util.m24495t() ? this.f14901ag.getDimensionPixelSize(R.dimen.full_screen_panorama_rim_rect_width) : this.f14901ag.getDimensionPixelOffset(R.dimen.panorama_rim_rect_width);
        this.f14908an = new Paint();
        this.f14908an.setStyle(Paint.Style.STROKE);
        this.f14908an.setStrokeWidth(this.f14909ao);
        this.f14908an.setColor(-1);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m14888i() {
        Drawable drawable = this.f14882K;
        if (drawable != null) {
            this.f14886O = ObjectAnimator.ofInt(drawable, "alpha", 0, 255);
            this.f14886O.setInterpolator(this.f14885N);
            this.f14886O.setDuration(250L);
            this.f14887P = ObjectAnimator.ofInt(this.f14882K, "alpha", 255, 0);
            this.f14887P.setInterpolator(this.f14885N);
            this.f14887P.setDuration(250L);
        }
        Drawable drawable2 = this.f14883L;
        if (drawable2 != null) {
            this.f14888Q = ObjectAnimator.ofInt(drawable2, "alpha", 0, 255);
            this.f14888Q.setInterpolator(this.f14885N);
            this.f14888Q.setDuration(250L);
            this.f14889R = ObjectAnimator.ofInt(this.f14883L, "alpha", 255, 0);
            this.f14889R.setInterpolator(this.f14885N);
            this.f14889R.setDuration(250L);
        }
    }

    public void setRearPanoramaInterface(RearPanoramaInterface rearPanoramaInterface) {
        this.f14912ar = rearPanoramaInterface;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14904a(int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int i6) {
        f14854a = OplusGLSurfaceView_13;
        f14855b = i2;
        f14856c = i3;
        f14857d = i4;
        f14867n = i5;
        f14866m = i6;
        Bitmap bitmap = this.f14920t;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.f14920t = Util.m24215a(f14854a, f14855b, Bitmap.Config.ARGB_8888);
        Rect rect = this.f14896ab;
        int i7 = f14856c;
        int i8 = f14857d;
        rect.set(i7, i8, f14854a + i7, f14855b + i8);
        this.f14902ah = new Paint();
        this.f14902ah.setStyle(Paint.Style.STROKE);
        this.f14902ah.setAntiAlias(true);
        this.f14902ah.setStrokeWidth(f14858e);
        this.f14902ah.setColor(f14870q);
        this.f14903ai = new Paint();
        this.f14903ai.setStyle(Paint.Style.STROKE);
        this.f14903ai.setAntiAlias(true);
        this.f14903ai.setStrokeWidth(f14858e);
        this.f14903ai.setColor(f14869p);
        this.f14906al = new DashPathEffect(new float[]{f14859f, f14860g}, 0.0f);
        this.f14903ai.setPathEffect(this.f14906al);
        this.f14905ak = new Path();
        this.f14905ak.moveTo(f14856c, f14857d + (this.f14896ab.height() / 2.0f));
        this.f14905ak.lineTo(this.f14896ab.right, f14857d + (this.f14896ab.height() / 2.0f));
        this.f14907am = new Paint();
        this.f14922v = new Paint();
        this.f14922v.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.f14904aj = new Paint();
        m14889j();
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m14889j() {
        Paint paint = this.f14902ah;
        if (paint != null) {
            this.f14891T = ObjectAnimator.ofInt(paint, "alpha", 0, 255);
            this.f14891T.setInterpolator(this.f14885N);
            this.f14891T.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.panorama.PanoramaProgressBar.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    if (PanoramaProgressBar.this.f14902ah != null) {
                        PanoramaProgressBar.this.f14902ah.setColor(PanoramaProgressBar.f14870q);
                    }
                }
            });
            this.f14891T.setDuration(250L);
            this.f14890S = ObjectAnimator.ofInt(this.f14902ah, "alpha", 255, 0);
            this.f14890S.setInterpolator(this.f14885N);
            this.f14890S.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.panorama.PanoramaProgressBar.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    if (PanoramaProgressBar.this.f14902ah != null) {
                        PanoramaProgressBar.this.f14902ah.setColor(PanoramaProgressBar.f14870q);
                    }
                }
            });
            this.f14890S.setDuration(250L);
        }
        Paint paint2 = this.f14903ai;
        if (paint2 != null) {
            this.f14893V = ObjectAnimator.ofInt(paint2, "alpha", 0, 255);
            this.f14893V.setInterpolator(this.f14885N);
            this.f14893V.setDuration(250L);
            this.f14892U = ObjectAnimator.ofInt(this.f14903ai, "alpha", 255, 0);
            this.f14892U.setInterpolator(this.f14885N);
            this.f14892U.setDuration(250L);
        }
        Paint paint3 = this.f14904aj;
        if (paint3 != null) {
            this.f14894W = ObjectAnimator.ofInt(paint3, "alpha", 255, 0);
            this.f14894W.setInterpolator(this.f14885N);
            this.f14894W.setDuration(250L);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m14908b() {
        int OplusGLSurfaceView_13;
        int i2 = this.f14924x;
        if (i2 == -1) {
            int i3 = f14854a / 2;
            int i4 = this.f14875D;
            this.f14926z = (i3 - (i4 / 2)) + this.f14913as;
            int i5 = this.f14926z;
            this.f14873B = i4 + i5;
            this.f14872A = f14857d;
            int i6 = this.f14872A;
            this.f14874C = f14855b + i6;
            Rect rect = this.f14897ac;
            int i7 = f14867n;
            rect.set(i5, i6 + i7, this.f14873B, this.f14874C - i7);
            this.f14899ae.set((this.f14926z - f14868o) - f14861h, this.f14872A + ((this.f14896ab.height() - f14862i) / 2), this.f14926z - f14868o, this.f14874C - ((this.f14896ab.height() - f14862i) / 2));
            this.f14900af.set(this.f14873B + f14868o, this.f14872A + ((this.f14896ab.height() - f14862i) / 2), this.f14873B + f14868o + f14861h, this.f14874C - ((this.f14896ab.height() - f14862i) / 2));
            int i8 = this.f14925y;
            if (i8 == 0) {
                return;
            }
            if (2 == i8) {
                this.f14879H++;
                this.f14878G = (int) (f14864k * this.f14884M.getInterpolation(this.f14879H / 48.0f));
                if (48 == this.f14879H) {
                    this.f14878G = f14864k;
                }
                Rect rect2 = this.f14897ac;
                int i9 = this.f14926z;
                int i10 = this.f14878G;
                rect2.left = i9 - i10;
                rect2.right = this.f14873B - i10;
                this.f14899ae.set(((i9 - f14868o) - f14861h) - i10, this.f14872A + ((this.f14896ab.height() - f14862i) / 2) + this.f14876E, (this.f14926z - f14868o) - this.f14878G, (this.f14874C - ((this.f14896ab.height() - f14862i) / 2)) + this.f14876E);
                this.f14900af.set((this.f14873B + f14868o) - this.f14878G, this.f14872A + ((this.f14896ab.height() - f14862i) / 2), ((this.f14873B + f14868o) + f14861h) - this.f14878G, this.f14874C - ((this.f14896ab.height() - f14862i) / 2));
                if (48 == this.f14879H) {
                    this.f14898ad.set(this.f14900af);
                    this.f14878G = 0;
                    this.f14879H = 0;
                    setContentDescription(getContext().getString(R.string.camera_description_arrow_left_to_right));
                    this.f14924x = 3;
                    this.f14923w = true;
                    return;
                }
                return;
            }
            if (3 == i8) {
                this.f14879H++;
                this.f14878G = (int) (f14864k * this.f14884M.getInterpolation(this.f14879H / 48.0f));
                if (48 == this.f14879H) {
                    this.f14878G = f14864k;
                }
                Rect rect3 = this.f14897ac;
                int i11 = this.f14926z;
                int i12 = this.f14878G;
                rect3.left = i11 + i12;
                rect3.right = this.f14873B + i12;
                this.f14899ae.set(((i11 - f14868o) - f14861h) + i12, this.f14872A + ((this.f14896ab.height() - f14862i) / 2) + this.f14876E, (this.f14926z - f14868o) + this.f14878G, (this.f14874C - ((this.f14896ab.height() - f14862i) / 2)) + this.f14876E);
                this.f14900af.set(this.f14873B + f14868o + this.f14878G, this.f14872A + ((this.f14896ab.height() - f14862i) / 2) + this.f14876E, this.f14873B + f14868o + f14861h + this.f14878G, (this.f14874C - ((this.f14896ab.height() - f14862i) / 2)) + this.f14876E);
                if (48 == this.f14879H) {
                    this.f14898ad.set(this.f14899ae);
                    this.f14878G = 0;
                    this.f14879H = 0;
                    setContentDescription(getContext().getString(R.string.camera_description_arrow_right_to_left));
                    this.f14924x = 2;
                    this.f14923w = true;
                    return;
                }
                return;
            }
            if (4 == i8) {
                this.f14879H++;
                this.f14878G = (int) ((this.f14926z - this.f14913as) * this.f14884M.getInterpolation(this.f14879H / 48.0f));
                if (48 == this.f14879H) {
                    this.f14878G = this.f14926z - this.f14913as;
                }
                Rect rect4 = this.f14897ac;
                int i13 = this.f14926z;
                int i14 = this.f14878G;
                rect4.left = i13 - i14;
                rect4.right = this.f14873B - i14;
                this.f14899ae.set(((i13 - f14868o) - f14861h) - i14, this.f14872A + ((this.f14896ab.height() - f14862i) / 2) + this.f14876E, (this.f14926z - f14868o) - this.f14878G, (this.f14874C - ((this.f14896ab.height() - f14862i) / 2)) + this.f14876E);
                this.f14900af.set((this.f14873B + f14868o) - this.f14878G, this.f14872A + ((this.f14896ab.height() - f14862i) / 2) + this.f14876E, ((this.f14873B + f14868o) + f14861h) - this.f14878G, (this.f14874C - ((this.f14896ab.height() - f14862i) / 2)) + this.f14876E);
                if (48 == this.f14879H) {
                    this.f14898ad.set(this.f14900af);
                    this.f14879H = 0;
                    this.f14878G = 0;
                    this.f14924x = 3;
                    this.f14923w = true;
                    return;
                }
                return;
            }
            if (5 == i8) {
                this.f14879H++;
                this.f14878G = (int) ((this.f14926z - this.f14913as) * this.f14884M.getInterpolation(this.f14879H / 48.0f));
                Rect rect5 = this.f14897ac;
                int i15 = this.f14926z;
                int i16 = this.f14878G;
                rect5.left = i15 + i16;
                rect5.right = this.f14873B + i16;
                this.f14899ae.set(((i15 - f14868o) - f14861h) + i16, this.f14872A + ((this.f14896ab.height() - f14862i) / 2) + this.f14876E, (this.f14926z - f14868o) + this.f14878G, (this.f14874C - ((this.f14896ab.height() - f14862i) / 2)) + this.f14876E);
                this.f14900af.set(this.f14873B + f14868o + this.f14878G, this.f14872A + ((this.f14896ab.height() - f14862i) / 2) + this.f14876E, this.f14873B + f14868o + f14861h + this.f14878G, (this.f14874C - ((this.f14896ab.height() - f14862i) / 2)) + this.f14876E);
                if (48 == this.f14879H) {
                    this.f14898ad.set(this.f14899ae);
                    this.f14879H = 0;
                    this.f14878G = 0;
                    this.f14924x = 2;
                    this.f14923w = true;
                    return;
                }
                return;
            }
            if (7 == i8) {
                this.f14879H++;
                this.f14917aw = (int) (this.f14876E * this.f14884M.getInterpolation(this.f14879H / 48.0f));
                int i17 = this.f14915au;
                if (2 == i17 || 5 == (OplusGLSurfaceView_13 = this.f14916av)) {
                    this.f14878G = (int) ((this.f14914at.left - this.f14926z) * this.f14884M.getInterpolation(this.f14879H / 48.0f));
                    this.f14897ac.left = this.f14914at.left - this.f14878G;
                    Rect rect6 = this.f14897ac;
                    rect6.right = rect6.left + this.f14875D;
                    this.f14899ae.set((this.f14897ac.left - f14868o) - f14861h, ((this.f14872A + ((this.f14896ab.height() - f14862i) / 2)) + this.f14876E) - this.f14917aw, this.f14897ac.left - f14868o, ((this.f14874C - ((this.f14896ab.height() - f14862i) / 2)) + this.f14876E) - this.f14917aw);
                    this.f14900af.set(this.f14897ac.right + f14868o, this.f14872A + ((this.f14896ab.height() - f14862i) / 2), this.f14897ac.right + f14868o + f14861h, this.f14874C - ((this.f14896ab.height() - f14862i) / 2));
                } else if (3 == i17 || 4 == OplusGLSurfaceView_13) {
                    this.f14878G = (int) ((this.f14914at.right - this.f14873B) * this.f14884M.getInterpolation(this.f14879H / 48.0f));
                    this.f14897ac.right = this.f14914at.right - this.f14878G;
                    Rect rect7 = this.f14897ac;
                    rect7.left = rect7.right - this.f14875D;
                    this.f14899ae.set((this.f14897ac.left - f14868o) - f14861h, this.f14872A + ((this.f14896ab.height() - f14862i) / 2), this.f14897ac.left - f14868o, this.f14874C - ((this.f14896ab.height() - f14862i) / 2));
                    this.f14900af.set(this.f14897ac.right + f14868o, ((this.f14872A + ((this.f14896ab.height() - f14862i) / 2)) + this.f14876E) - this.f14917aw, this.f14897ac.right + f14868o + f14861h, ((this.f14874C - ((this.f14896ab.height() - f14862i) / 2)) + this.f14876E) - this.f14917aw);
                }
                if (48 == this.f14879H) {
                    this.f14879H = 0;
                    this.f14878G = 0;
                    this.f14924x = -1;
                    this.f14923w = true;
                    return;
                }
                return;
            }
            return;
        }
        if (i2 == 2) {
            int i18 = f14856c;
            this.f14873B = (f14854a + i18) - f14866m;
            this.f14926z = this.f14873B - this.f14875D;
            this.f14872A = f14857d;
            this.f14874C = this.f14872A + f14855b;
            if (this.f14926z <= i18) {
                this.f14926z = i18;
            }
            Rect rect8 = this.f14897ac;
            int i19 = this.f14926z;
            int i20 = this.f14872A;
            int i21 = f14867n;
            rect8.set(i19, i20 + i21, this.f14873B, this.f14874C - i21);
            int i22 = this.f14925y;
            if (i22 == 0) {
                int i23 = this.f14926z;
                int i24 = f14856c;
                int i25 = f14866m + i24;
                int i26 = f14868o;
                int i27 = f14861h;
                if (i23 <= i25 + i26 + i27) {
                    this.f14898ad.set(i24 + i26, this.f14872A + ((this.f14896ab.height() - f14862i) / 2) + this.f14876E, f14856c + f14868o + f14861h, (this.f14874C - ((this.f14896ab.height() - f14862i) / 2)) + this.f14876E);
                    return;
                } else {
                    this.f14898ad.set((i23 - i26) - i27, this.f14872A + ((this.f14896ab.height() - f14862i) / 2) + this.f14876E, this.f14926z - f14868o, (this.f14874C - ((this.f14896ab.height() - f14862i) / 2)) + this.f14876E);
                    return;
                }
            }
            if (3 == i22) {
                this.f14879H++;
                this.f14878G = (int) (f14864k * m14902a(this.f14879H / 48.0f));
                if (48 == this.f14879H) {
                    this.f14878G = f14864k;
                }
                this.f14898ad.set((this.f14926z - f14868o) - (this.f14878G - (f14864k - f14861h)), this.f14872A + ((this.f14896ab.height() - f14862i) / 2) + this.f14876E, this.f14926z - f14868o, (this.f14874C - ((this.f14896ab.height() - f14862i) / 2)) + this.f14876E);
                if (this.f14898ad.right - this.f14898ad.left >= f14861h) {
                    Rect rect9 = this.f14898ad;
                    rect9.left = rect9.right - f14861h;
                    this.f14878G = 0;
                    this.f14879H = 0;
                    return;
                }
                return;
            }
            if (1 == i22) {
                this.f14879H++;
                this.f14878G = (int) (f14863j * this.f14884M.getInterpolation(this.f14879H / 48.0f));
                if (48 == this.f14879H) {
                    this.f14878G = f14863j;
                }
                Rect rect10 = this.f14897ac;
                int i28 = this.f14926z;
                int i29 = this.f14878G;
                rect10.left = i28 - i29;
                rect10.right = this.f14873B - i29;
                this.f14899ae.set(((i28 - f14868o) - f14861h) - i29, this.f14872A + ((this.f14896ab.height() - f14862i) / 2) + this.f14876E, (this.f14926z - f14868o) - this.f14878G, (this.f14874C - ((this.f14896ab.height() - f14862i) / 2)) + this.f14876E);
                this.f14900af.set((this.f14873B + f14868o) - this.f14878G, this.f14872A + ((this.f14896ab.height() - f14862i) / 2), ((this.f14873B + f14868o) + f14861h) - this.f14878G, this.f14874C - ((this.f14896ab.height() - f14862i) / 2));
                if (48 == this.f14879H) {
                    this.f14879H = 0;
                    this.f14878G = 0;
                    this.f14924x = 3;
                    this.f14923w = true;
                    return;
                }
                return;
            }
            if (6 == i22) {
                this.f14879H++;
                this.f14878G = (int) (f14865l * this.f14884M.getInterpolation(this.f14879H / 48.0f));
                Rect rect11 = this.f14897ac;
                int i30 = this.f14926z;
                int i31 = this.f14878G;
                rect11.left = i30 - i31;
                rect11.right = this.f14873B - i31;
                this.f14899ae.set(((i30 - f14868o) - f14861h) - i31, this.f14872A + ((this.f14896ab.height() - f14862i) / 2) + this.f14876E, (this.f14926z - f14868o) - this.f14878G, (this.f14874C - ((this.f14896ab.height() - f14862i) / 2)) + this.f14876E);
                this.f14900af.set((this.f14873B + f14868o) - this.f14878G, this.f14872A + ((this.f14896ab.height() - f14862i) / 2), ((this.f14873B + f14868o) + f14861h) - this.f14878G, this.f14874C - ((this.f14896ab.height() - f14862i) / 2));
                if (48 == this.f14879H) {
                    this.f14879H = 0;
                    this.f14878G = 0;
                    this.f14924x = -1;
                    this.f14923w = true;
                    return;
                }
                return;
            }
            return;
        }
        if (i2 != 3) {
            return;
        }
        this.f14926z = f14856c + f14866m;
        int i32 = this.f14926z;
        this.f14873B = this.f14875D + i32;
        this.f14872A = f14857d;
        this.f14874C = this.f14872A + f14855b;
        int i33 = this.f14873B;
        if (i32 >= i33) {
            this.f14926z = i33;
        }
        Rect rect12 = this.f14897ac;
        int i34 = this.f14926z;
        int i35 = this.f14872A;
        int i36 = f14867n;
        rect12.set(i34, i35 + i36, this.f14873B, this.f14874C - i36);
        int i37 = this.f14925y;
        if (i37 == 0) {
            int i38 = this.f14873B;
            int i39 = f14868o;
            int i40 = f14861h;
            int i41 = i38 + i39 + i40;
            int i42 = f14856c;
            int i43 = f14854a;
            if (i41 >= (i42 + i43) - i39) {
                this.f14898ad.set(((i42 + i43) - i40) - i39, this.f14872A + ((this.f14896ab.height() - f14862i) / 2) + this.f14876E, (f14856c + f14854a) - f14868o, (this.f14874C - ((this.f14896ab.height() - f14862i) / 2)) + this.f14876E);
                return;
            } else {
                this.f14898ad.set(i38 + i39, this.f14872A + ((this.f14896ab.height() - f14862i) / 2) + this.f14876E, this.f14873B + f14868o + f14861h, (this.f14874C - ((this.f14896ab.height() - f14862i) / 2)) + this.f14876E);
                return;
            }
        }
        if (2 == i37) {
            this.f14879H++;
            this.f14878G = (int) (f14864k * m14902a(this.f14879H / 48.0f));
            if (48 == this.f14879H) {
                this.f14878G = f14864k;
            }
            this.f14898ad.set(this.f14873B + f14868o, this.f14872A + ((this.f14896ab.height() - f14862i) / 2) + this.f14876E, this.f14873B + f14868o + (this.f14878G - (f14864k - f14861h)), (this.f14874C - ((this.f14896ab.height() - f14862i) / 2)) + this.f14876E);
            if (this.f14898ad.right - this.f14898ad.left >= f14861h) {
                Rect rect13 = this.f14898ad;
                rect13.right = rect13.left + f14861h;
                this.f14878G = 0;
                this.f14879H = 0;
                return;
            }
            return;
        }
        if (1 == i37) {
            this.f14879H++;
            this.f14878G = (int) (f14863j * this.f14884M.getInterpolation(this.f14879H / 48.0f));
            if (48 == this.f14879H) {
                this.f14878G = f14863j;
            }
            Rect rect14 = this.f14897ac;
            int i44 = this.f14926z;
            int i45 = this.f14878G;
            rect14.left = i44 + i45;
            rect14.right = this.f14873B + i45;
            this.f14899ae.set(((i44 - f14868o) - f14861h) + i45, this.f14872A + ((this.f14896ab.height() - f14862i) / 2) + this.f14876E, (this.f14926z - f14868o) + this.f14878G, (this.f14874C - ((this.f14896ab.height() - f14862i) / 2)) + this.f14876E);
            this.f14900af.set(this.f14873B + f14868o + this.f14878G, this.f14872A + ((this.f14896ab.height() - f14862i) / 2), this.f14873B + f14868o + f14861h + this.f14878G, this.f14874C - ((this.f14896ab.height() - f14862i) / 2));
            if (48 == this.f14879H) {
                this.f14879H = 0;
                this.f14878G = 0;
                this.f14924x = 2;
                this.f14923w = true;
                return;
            }
            return;
        }
        if (6 == i37) {
            this.f14879H++;
            this.f14878G = (int) (f14865l * this.f14884M.getInterpolation(this.f14879H / 48.0f));
            Rect rect15 = this.f14897ac;
            int i46 = this.f14926z;
            int i47 = this.f14878G;
            rect15.left = i46 + i47;
            rect15.right = this.f14873B + i47;
            this.f14899ae.set(((i46 - f14868o) - f14861h) + i47, this.f14872A + ((this.f14896ab.height() - f14862i) / 2) + this.f14876E, (this.f14926z - f14868o) + this.f14878G, (this.f14874C - ((this.f14896ab.height() - f14862i) / 2)) + this.f14876E);
            this.f14900af.set(this.f14873B + f14868o + this.f14878G, this.f14872A + ((this.f14896ab.height() - f14862i) / 2), this.f14873B + f14868o + f14861h + this.f14878G, this.f14874C - ((this.f14896ab.height() - f14862i) / 2));
            if (48 == this.f14879H) {
                this.f14879H = 0;
                this.f14878G = 0;
                this.f14924x = -1;
                this.f14923w = true;
            }
        }
    }

    public void setDisplay(Canvas canvas) {
        this.f14895aa.setBounds(this.f14896ab);
        this.f14895aa.draw(canvas);
        m14885b(canvas);
        m14883a(canvas);
        Bitmap bitmap = this.f14919s;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, this.f14897ac.left, this.f14897ac.top, this.f14907am);
        } else {
            Bitmap bitmap2 = this.f14920t;
            if (bitmap2 != null) {
                canvas.drawBitmap(bitmap2, this.f14897ac.left, this.f14897ac.top, this.f14907am);
            }
        }
        m14886c(canvas);
        int OplusGLSurfaceView_13 = this.f14924x;
        if (OplusGLSurfaceView_13 == -1) {
            this.f14882K.setBounds(this.f14899ae);
            this.f14882K.draw(canvas);
            this.f14883L.setBounds(this.f14900af);
            this.f14883L.draw(canvas);
        } else if (OplusGLSurfaceView_13 == 2) {
            int i2 = this.f14925y;
            if (6 == i2 || 1 == i2) {
                this.f14882K.setBounds(this.f14899ae);
                this.f14882K.draw(canvas);
                this.f14883L.setBounds(this.f14900af);
                this.f14883L.draw(canvas);
            } else {
                this.f14882K.setBounds(this.f14898ad);
                this.f14882K.draw(canvas);
            }
        } else if (OplusGLSurfaceView_13 == 3) {
            int i3 = this.f14925y;
            if (6 == i3 || 1 == i3) {
                this.f14882K.setBounds(this.f14899ae);
                this.f14882K.draw(canvas);
                this.f14883L.setBounds(this.f14900af);
                this.f14883L.draw(canvas);
            } else {
                this.f14883L.setBounds(this.f14898ad);
                this.f14883L.draw(canvas);
            }
        }
        if (this.f14923w && this.f14878G == 0) {
            setAnimationState(0);
            this.f14923w = false;
            CameraLog.m12954a("PanoramaProgressBar", "setDisplay, animate end");
        }
        this.f14907am.reset();
        if (this.f14925y == 0) {
            if (!Util.m24495t()) {
                this.f14882K.setAlpha(255);
                this.f14883L.setAlpha(255);
            }
            this.f14902ah.setAlpha(255);
            this.f14903ai.setAlpha(255);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14883a(Canvas canvas) {
        int OplusGLSurfaceView_13;
        if (this.f14918ax == null || 7 != this.f14925y) {
            return;
        }
        int i2 = this.f14915au;
        if (3 == i2 || 4 == (OplusGLSurfaceView_13 = this.f14916av)) {
            canvas.drawBitmap(this.f14918ax, this.f14897ac.right - this.f14918ax.getWidth(), this.f14897ac.top, this.f14904aj);
        } else if (2 == i2 || 5 == OplusGLSurfaceView_13) {
            canvas.drawBitmap(this.f14918ax, this.f14897ac.left, this.f14897ac.top, this.f14904aj);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m14885b(Canvas canvas) {
        int OplusGLSurfaceView_13 = this.f14924x;
        if (OplusGLSurfaceView_13 == 2 || OplusGLSurfaceView_13 == 3) {
            if (6 == this.f14925y) {
                canvas.drawPath(this.f14905ak, this.f14903ai);
            } else if (Math.abs(this.f14898ad.centerY() - this.f14896ab.centerY()) < f14871r) {
                this.f14902ah.setColor(f14870q);
            } else {
                this.f14902ah.setColor(f14869p);
            }
            canvas.drawPath(this.f14905ak, this.f14902ah);
            return;
        }
        int i2 = this.f14925y;
        if (2 == i2 || 7 == i2 || 3 == i2 || 4 == i2 || 5 == i2) {
            canvas.drawPath(this.f14905ak, this.f14902ah);
        }
        canvas.drawPath(this.f14905ak, this.f14903ai);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m14886c(Canvas canvas) {
        int OplusGLSurfaceView_13;
        int i2 = this.f14924x;
        if (i2 != -1) {
            if (i2 == 2) {
                canvas.drawRect(this.f14897ac.left + this.f14910ap, this.f14897ac.top + this.f14910ap, this.f14897ac.left + this.f14910ap + this.f14911aq, this.f14897ac.bottom - this.f14910ap, this.f14908an);
                return;
            } else {
                if (i2 != 3) {
                    return;
                }
                canvas.drawRect((this.f14897ac.right - this.f14910ap) - this.f14911aq, this.f14897ac.top + this.f14910ap, this.f14897ac.right - this.f14910ap, this.f14897ac.bottom - this.f14910ap, this.f14908an);
                return;
            }
        }
        int i3 = this.f14925y;
        if (4 == i3) {
            canvas.drawRect((this.f14897ac.right - this.f14910ap) - this.f14911aq, this.f14897ac.top + this.f14910ap, this.f14897ac.right - this.f14910ap, this.f14897ac.bottom - this.f14910ap, this.f14908an);
            return;
        }
        if (5 == i3) {
            canvas.drawRect(this.f14897ac.left + this.f14910ap, this.f14897ac.top + this.f14910ap, this.f14897ac.left + this.f14910ap + this.f14911aq, this.f14897ac.bottom - this.f14910ap, this.f14908an);
            return;
        }
        if (7 == i3) {
            int i4 = this.f14915au;
            if (3 == i4 || 4 == (OplusGLSurfaceView_13 = this.f14916av)) {
                canvas.drawRect((this.f14897ac.right - this.f14910ap) - this.f14911aq, this.f14897ac.top + this.f14910ap, this.f14897ac.right - this.f14910ap, this.f14897ac.bottom - this.f14910ap, this.f14908an);
                return;
            } else {
                if (2 == i4 || 5 == OplusGLSurfaceView_13) {
                    canvas.drawRect(this.f14897ac.left + this.f14910ap, this.f14897ac.top + this.f14910ap, this.f14897ac.left + this.f14910ap + this.f14911aq, this.f14897ac.bottom - this.f14910ap, this.f14908an);
                    return;
                }
                return;
            }
        }
        canvas.drawRect(this.f14897ac.left + this.f14910ap, this.f14897ac.top + this.f14910ap, this.f14897ac.right - this.f14910ap, this.f14897ac.bottom - this.f14910ap, this.f14908an);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        m14908b();
        setDisplay(canvas);
        if (m14911e()) {
            invalidate();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m14909c() {
        CameraLog.m12959b("TAG", "resetProgressBar");
        Bitmap bitmap = this.f14919s;
        if (bitmap != null) {
            bitmap.recycle();
            this.f14919s = null;
        }
        Bitmap bitmap2 = this.f14920t;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.f14920t = null;
        }
        this.f14926z = 0;
        this.f14872A = 0;
        this.f14873B = 0;
        this.f14874C = 0;
        this.f14875D = Util.m24495t() ? this.f14901ag.getDimensionPixelSize(R.dimen.full_screen_panorama_rim_rect_width) : this.f14901ag.getDimensionPixelOffset(R.dimen.panorama_rim_rect_width);
        this.f14876E = 0;
        this.f14877F = 0;
        this.f14897ac.setEmpty();
        m14912f();
        setAnimationState(0);
        setDirection(-1);
    }

    @Override // android.view.View
    public void setVisibility(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            this.f14919s = null;
        }
        super.setVisibility(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14906a(Bitmap bitmap, int OplusGLSurfaceView_13, int i2) {
        Bitmap bitmap2;
        this.f14876E = i2;
        if (OplusGLSurfaceView_13 == 0 && this.f14875D > this.f14877F) {
            this.f14924x = -1;
        }
        if (OplusGLSurfaceView_13 < 0) {
            this.f14875D = this.f14877F;
        } else {
            this.f14875D = this.f14877F + OplusGLSurfaceView_13;
        }
        if (OplusGLSurfaceView_13 > 0 && (bitmap2 = this.f14919s) != null) {
            int width = bitmap2.getWidth();
            int i3 = f14854a;
            if (width != i3) {
                this.f14919s = Util.m24215a(i3, f14855b, Bitmap.Config.ARGB_8888);
                this.f14921u = new Canvas(this.f14919s);
            }
            this.f14921u.save();
            this.f14921u.drawBitmap(bitmap, 0.0f, 0.0f, this.f14922v);
            this.f14921u.restore();
        } else {
            this.f14919s = bitmap;
        }
        invalidate();
    }

    public void setFrameSize(int OplusGLSurfaceView_13) {
        if (this.f14877F == OplusGLSurfaceView_13) {
            return;
        }
        this.f14877F = OplusGLSurfaceView_13;
        int i2 = f14854a;
        int i3 = this.f14877F;
        f14863j = i2 - i3;
        int i4 = f14866m;
        f14864k = ((i2 - i3) / 2) - i4;
        f14865l = ((i2 - i3) / 2) - i4;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m14910d() {
        Bitmap bitmap = this.f14919s;
        if (bitmap != null) {
            bitmap.recycle();
            this.f14919s = null;
        }
        Bitmap bitmap2 = this.f14920t;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.f14920t = null;
        }
        Bitmap bitmap3 = this.f14918ax;
        if (bitmap3 != null) {
            bitmap3.recycle();
            this.f14918ax = null;
        }
    }

    public void setAnimationState(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("PanoramaProgressBar", "setAnimationStateState, animationState: " + OplusGLSurfaceView_13);
        this.f14925y = OplusGLSurfaceView_13;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m14911e() {
        return this.f14925y != 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public float m14902a(float COUIBaseListPopupWindow_12) {
        return ((float) (Math.cos((COUIBaseListPopupWindow_12 + 1.0f) * 3.141592653589793d) * 0.5d)) + 0.5f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m14882a(int OplusGLSurfaceView_13) {
        if (m14911e()) {
            return;
        }
        setAnimationState(OplusGLSurfaceView_13);
        this.f14878G = 0;
        this.f14879H = 0;
        this.f14880I = 0;
        m14884b(OplusGLSurfaceView_13);
        invalidate();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m14884b(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 1) {
            this.f14912ar.onReportDirectionChange(3 == this.f14924x ? 1 : 2);
        } else if (OplusGLSurfaceView_13 == 2) {
            this.f14912ar.onReportDirectionChange(5);
        } else {
            if (OplusGLSurfaceView_13 != 3) {
                return;
            }
            this.f14912ar.onReportDirectionChange(4);
        }
    }

    public void setDirection(int OplusGLSurfaceView_13) {
        this.f14924x = OplusGLSurfaceView_13;
        postInvalidate();
    }

    public int getDirection() {
        return this.f14924x;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m14912f() {
        this.f14898ad.setEmpty();
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m14913g() {
        m14912f();
        this.f14878G = 0;
        this.f14879H = 0;
        setAnimationState(0);
        setDirection(-1);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected boolean m14907a(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        Rect rect = this.f14896ab;
        if (rect == null || !rect.contains(x, y) || this.f14875D != this.f14877F) {
            return false;
        }
        if (-1 == this.f14924x) {
            if (x < this.f14926z) {
                m14882a(2);
                m14892m();
            } else if (x > this.f14873B) {
                m14882a(3);
                m14894o();
            }
        } else if (!m14911e()) {
            int OplusGLSurfaceView_13 = this.f14924x;
            if (3 == OplusGLSurfaceView_13) {
                m14890k();
            } else if (2 == OplusGLSurfaceView_13) {
                m14891l();
            }
            m14882a(1);
        }
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m14905a(Bitmap bitmap) {
        int OplusGLSurfaceView_13;
        CameraLog.m12954a("PanoramaProgressBar", "finishAndReset");
        if (-1 == this.f14924x && this.f14925y == 0) {
            this.f14878G = 0;
            this.f14879H = 0;
            return;
        }
        this.f14917aw = 0;
        this.f14878G = 0;
        this.f14879H = 0;
        this.f14914at.set(this.f14897ac);
        this.f14915au = this.f14924x;
        this.f14916av = this.f14925y;
        setForceResetBitmap(bitmap);
        setDirection(-1);
        setAnimationState(7);
        ObjectAnimator objectAnimator = this.f14894W;
        if (objectAnimator != null && this.f14904aj != null) {
            if (objectAnimator.isRunning()) {
                this.f14894W.cancel();
            }
            this.f14904aj.setAlpha(255);
            this.f14894W.start();
        }
        int i2 = this.f14915au;
        if (3 == i2 || 4 == (OplusGLSurfaceView_13 = this.f14916av)) {
            m14893n();
        } else if (2 == i2 || 5 == OplusGLSurfaceView_13) {
            m14895p();
        }
    }

    public void setForceResetBitmap(Bitmap bitmap) {
        Bitmap bitmap2 = this.f14918ax;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.f14918ax = null;
        }
        if (bitmap != null) {
            this.f14918ax = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private void m14890k() {
        CameraLog.m12954a("PanoramaProgressBar", "startArrowLeftToRightAnimator");
        m14897r();
        m14898s();
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private void m14891l() {
        CameraLog.m12954a("PanoramaProgressBar", "startArrowLeftToRightAnimator");
        m14896q();
        m14899t();
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private void m14892m() {
        CameraLog.m12954a("PanoramaProgressBar", "startArrowNoneToLeftAnimator");
        m14896q();
        m14900u();
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private void m14893n() {
        CameraLog.m12954a("PanoramaProgressBar", "startArrowLeftToNoneAnimator");
        m14897r();
        m14901v();
    }

    /* renamed from: o */
    private void m14894o() {
        CameraLog.m12954a("PanoramaProgressBar", "startArrowNoneToRightAnimator");
        m14898s();
        m14900u();
    }

    /* renamed from: p */
    private void m14895p() {
        CameraLog.m12954a("PanoramaProgressBar", "startArrowRightToNoneAnimator");
        m14899t();
        m14901v();
    }

    /* renamed from: q */
    private void m14896q() {
        ObjectAnimator objectAnimator = this.f14886O;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.f14886O.cancel();
        }
        ObjectAnimator objectAnimator2 = this.f14887P;
        if (objectAnimator2 != null) {
            if (objectAnimator2.isRunning()) {
                this.f14887P.cancel();
            }
            this.f14887P.start();
        }
    }

    /* renamed from: r */
    private void m14897r() {
        ObjectAnimator objectAnimator = this.f14887P;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.f14887P.cancel();
        }
        ObjectAnimator objectAnimator2 = this.f14886O;
        if (objectAnimator2 != null) {
            if (objectAnimator2.isRunning()) {
                this.f14886O.cancel();
            }
            this.f14886O.start();
        }
    }

    /* renamed from: s */
    private void m14898s() {
        ObjectAnimator objectAnimator = this.f14888Q;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.f14888Q.cancel();
        }
        ObjectAnimator objectAnimator2 = this.f14889R;
        if (objectAnimator2 != null) {
            if (objectAnimator2.isRunning()) {
                this.f14889R.cancel();
            }
            this.f14889R.start();
        }
    }

    /* renamed from: t */
    private void m14899t() {
        ObjectAnimator objectAnimator = this.f14889R;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.f14889R.cancel();
        }
        ObjectAnimator objectAnimator2 = this.f14888Q;
        if (objectAnimator2 != null) {
            if (objectAnimator2.isRunning()) {
                this.f14888Q.cancel();
            }
            this.f14888Q.start();
        }
    }

    /* renamed from: u */
    private void m14900u() {
        ObjectAnimator objectAnimator = this.f14890S;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.f14890S.cancel();
        }
        ObjectAnimator objectAnimator2 = this.f14891T;
        if (objectAnimator2 != null) {
            if (objectAnimator2.isRunning()) {
                this.f14891T.cancel();
            }
            this.f14891T.start();
        }
        ObjectAnimator objectAnimator3 = this.f14893V;
        if (objectAnimator3 != null && objectAnimator3.isRunning()) {
            this.f14893V.cancel();
        }
        ObjectAnimator objectAnimator4 = this.f14892U;
        if (objectAnimator4 != null) {
            if (objectAnimator4.isRunning()) {
                this.f14892U.cancel();
            }
            this.f14892U.start();
        }
    }

    /* renamed from: v */
    private void m14901v() {
        ObjectAnimator objectAnimator = this.f14891T;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.f14891T.cancel();
        }
        ObjectAnimator objectAnimator2 = this.f14890S;
        if (objectAnimator2 != null) {
            if (objectAnimator2.isRunning()) {
                this.f14890S.cancel();
            }
            this.f14890S.start();
        }
        ObjectAnimator objectAnimator3 = this.f14892U;
        if (objectAnimator3 != null && objectAnimator3.isRunning()) {
            this.f14892U.cancel();
        }
        ObjectAnimator objectAnimator4 = this.f14893V;
        if (objectAnimator4 != null) {
            if (objectAnimator4.isRunning()) {
                this.f14893V.cancel();
            }
            this.f14893V.start();
        }
    }

    public void setRectMarginLeft(int OplusGLSurfaceView_13) {
        this.f14913as = OplusGLSurfaceView_13;
    }
}
