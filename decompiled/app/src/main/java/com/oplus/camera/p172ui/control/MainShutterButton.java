package com.oplus.camera.p172ui.control;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.util.Util;

/* loaded from: classes2.dex */
public class MainShutterButton extends ShutterButton {

    /* renamed from: o */
    private static final Interpolator f17909o = new LinearInterpolator();

    /* renamed from: p */
    private static final Interpolator f17910p = new AccelerateDecelerateInterpolator();

    /* renamed from: q */
    private static final int f17911q = Color.parseColor("#FFEA3447");

    /* renamed from: r */
    private static final int f17912r = Color.parseColor("#E3E3E3");

    /* renamed from: s */
    private static final int f17913s = Color.parseColor("#4D4D4D");

    /* renamed from: t */
    private static final int f17914t = Color.parseColor("#FB822A");

    /* renamed from: u */
    private static final int f17915u = Color.parseColor("#E1651F");

    /* renamed from: v */
    private static final int f17916v = Color.parseColor("#757575");

    /* renamed from: w */
    private static final int f17917w = Color.parseColor("#33FB822A");

    /* renamed from: A */
    private int f17918A;

    /* renamed from: B */
    private int f17919B;

    /* renamed from: C */
    private float f17920C;

    /* renamed from: D */
    private int f17921D;

    /* renamed from: E */
    private int f17922E;

    /* renamed from: F */
    private int f17923F;

    /* renamed from: G */
    private int f17924G;

    /* renamed from: H */
    private int f17925H;

    /* renamed from: I */
    private int f17926I;

    /* renamed from: J */
    private int f17927J;

    /* renamed from: K */
    private int f17928K;

    /* renamed from: L */
    private int f17929L;

    /* renamed from: M */
    private int f17930M;

    /* renamed from: N */
    private int f17931N;

    /* renamed from: O */
    private float f17932O;

    /* renamed from: P */
    private float f17933P;

    /* renamed from: Q */
    private int f17934Q;

    /* renamed from: R */
    private int f17935R;

    /* renamed from: S */
    private int f17936S;

    /* renamed from: T */
    private int f17937T;

    /* renamed from: U */
    private int f17938U;

    /* renamed from: V */
    private int f17939V;

    /* renamed from: W */
    private int f17940W;

    /* renamed from: aA */
    private float f17941aA;

    /* renamed from: aB */
    private float f17942aB;

    /* renamed from: aC */
    private float f17943aC;

    /* renamed from: aD */
    private float f17944aD;

    /* renamed from: aE */
    private float f17945aE;

    /* renamed from: aF */
    private float f17946aF;

    /* renamed from: aG */
    private float f17947aG;

    /* renamed from: aH */
    private float f17948aH;

    /* renamed from: aI */
    private String f17949aI;

    /* renamed from: aJ */
    private String f17950aJ;

    /* renamed from: aK */
    private String f17951aK;

    /* renamed from: aL */
    private boolean f17952aL;

    /* renamed from: aM */
    private boolean f17953aM;

    /* renamed from: aN */
    private boolean f17954aN;

    /* renamed from: aO */
    private boolean f17955aO;

    /* renamed from: aP */
    private boolean f17956aP;

    /* renamed from: aQ */
    private boolean f17957aQ;

    /* renamed from: aR */
    private AnimatorSet f17958aR;

    /* renamed from: aS */
    private ValueAnimator f17959aS;

    /* renamed from: aT */
    private ValueAnimator f17960aT;

    /* renamed from: aU */
    private Canvas f17961aU;

    /* renamed from: aV */
    private Bitmap f17962aV;

    /* renamed from: aW */
    private Bitmap f17963aW;

    /* renamed from: aX */
    private Bitmap f17964aX;

    /* renamed from: aY */
    private Bitmap f17965aY;

    /* renamed from: aZ */
    private Bitmap f17966aZ;

    /* renamed from: aa */
    private int f17967aa;

    /* renamed from: ab */
    private int f17968ab;

    /* renamed from: ac */
    private int f17969ac;

    /* renamed from: ad */
    private int f17970ad;

    /* renamed from: ae */
    private int f17971ae;

    /* renamed from: af */
    private int f17972af;

    /* renamed from: ag */
    private int f17973ag;

    /* renamed from: ah */
    private int f17974ah;

    /* renamed from: ai */
    private int f17975ai;

    /* renamed from: aj */
    private int f17976aj;

    /* renamed from: ak */
    private int f17977ak;

    /* renamed from: al */
    private int f17978al;

    /* renamed from: am */
    private int f17979am;

    /* renamed from: an */
    private int f17980an;

    /* renamed from: ao */
    private int f17981ao;

    /* renamed from: ap */
    private int f17982ap;

    /* renamed from: aq */
    private int f17983aq;

    /* renamed from: ar */
    private int f17984ar;

    /* renamed from: as */
    private int f17985as;

    /* renamed from: at */
    private int f17986at;

    /* renamed from: au */
    private int f17987au;

    /* renamed from: av */
    private int f17988av;

    /* renamed from: aw */
    private int f17989aw;

    /* renamed from: ax */
    private int f17990ax;

    /* renamed from: ay */
    private int f17991ay;

    /* renamed from: az */
    private int f17992az;

    /* renamed from: bA */
    private ObjectAnimator f17993bA;

    /* renamed from: bB */
    private ValueAnimator f17994bB;

    /* renamed from: bC */
    private ValueAnimator f17995bC;

    /* renamed from: bD */
    private ValueAnimator f17996bD;

    /* renamed from: bE */
    private ValueAnimator f17997bE;

    /* renamed from: bF */
    private ValueAnimator f17998bF;

    /* renamed from: bG */
    private ValueAnimator f17999bG;

    /* renamed from: bH */
    private ValueAnimator f18000bH;

    /* renamed from: bI */
    private ValueAnimator f18001bI;

    /* renamed from: bJ */
    private ValueAnimator f18002bJ;

    /* renamed from: bK */
    private ValueAnimator f18003bK;

    /* renamed from: bL */
    private ValueAnimator f18004bL;

    /* renamed from: bM */
    private ValueAnimator f18005bM;

    /* renamed from: bN */
    private ValueAnimator f18006bN;

    /* renamed from: bO */
    private ValueAnimator f18007bO;

    /* renamed from: bP */
    private ValueAnimator f18008bP;

    /* renamed from: bQ */
    private ValueAnimator f18009bQ;

    /* renamed from: bR */
    private ValueAnimator f18010bR;

    /* renamed from: bS */
    private PathInterpolator f18011bS;

    /* renamed from: bT */
    private PathInterpolator f18012bT;

    /* renamed from: bU */
    private ValueAnimator.AnimatorUpdateListener f18013bU;

    /* renamed from: bV */
    private Path f18014bV;

    /* renamed from: ba */
    private Bitmap f18015ba;

    /* renamed from: bb */
    private RectF f18016bb;

    /* renamed from: bc */
    private RectF f18017bc;

    /* renamed from: bd */
    private RectF f18018bd;

    /* renamed from: be */
    private RectF f18019be;

    /* renamed from: bf */
    private RectF f18020bf;

    /* renamed from: bg_renamed */
    private RectF f18021bg;

    /* renamed from: bh */
    private Paint f18022bh;

    /* renamed from: bi */
    private Paint f18023bi;

    /* renamed from: bj */
    private Paint f18024bj;

    /* renamed from: bk */
    private Paint f18025bk;

    /* renamed from: bl */
    private Paint f18026bl;

    /* renamed from: bm */
    private Paint f18027bm;

    /* renamed from: bn */
    private Paint f18028bn;

    /* renamed from: bo */
    private Paint f18029bo;

    /* renamed from: bp */
    private Paint f18030bp;

    /* renamed from: bq */
    private Paint f18031bq;

    /* renamed from: br */
    private Paint f18032br;

    /* renamed from: bs */
    private Paint f18033bs;

    /* renamed from: bt */
    private Paint f18034bt;

    /* renamed from: bu */
    private Paint f18035bu;

    /* renamed from: bv */
    private Property<MainShutterButton, Float> f18036bv;

    /* renamed from: bw */
    private Property<MainShutterButton, Float> f18037bw;

    /* renamed from: bx */
    private Property<MainShutterButton, Integer> f18038bx;

    /* renamed from: by */
    private ObjectAnimator f18039by;

    /* renamed from: bz */
    private ObjectAnimator f18040bz;

    /* renamed from: x */
    private int f18041x;

    /* renamed from: y */
    private int f18042y;

    /* renamed from: z */
    private int f18043z;

    /* renamed from: PlatformImplementations.kt_3 */
    private float m18870a(float COUIBaseListPopupWindow_12, float f2, float f3, boolean z) {
        return z ? COUIBaseListPopupWindow_12 - (((f2 - 1.0f) / 2.0f) * f3) : COUIBaseListPopupWindow_12 + (((f2 - 1.0f) / 2.0f) * f3);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m18896c(Canvas canvas, Bitmap bitmap) {
    }

    public MainShutterButton(Context context) {
        super(context);
        this.f18041x = 1;
        this.f18042y = 1;
        this.f18043z = 0;
        this.f17918A = 0;
        this.f17919B = 0;
        this.f17920C = 0.0f;
        this.f17921D = 0;
        this.f17922E = 0;
        this.f17923F = 0;
        this.f17924G = 0;
        this.f17925H = 0;
        this.f17926I = 0;
        this.f17927J = 0;
        this.f17928K = 0;
        this.f17929L = 0;
        this.f17930M = 0;
        this.f17931N = 0;
        this.f17932O = 0.0f;
        this.f17933P = 0.0f;
        this.f17934Q = 0;
        this.f17935R = 0;
        this.f17936S = 0;
        this.f17937T = 0;
        this.f17938U = 0;
        this.f17939V = 0;
        this.f17940W = 0;
        this.f17967aa = 0;
        this.f17968ab = 0;
        this.f17969ac = 0;
        this.f17970ad = 0;
        this.f17971ae = 0;
        this.f17972af = 0;
        this.f17973ag = 0;
        this.f17974ah = 0;
        this.f17975ai = 0;
        this.f17976aj = 0;
        this.f17977ak = 0;
        this.f17978al = 0;
        this.f17979am = 0;
        this.f17980an = 255;
        this.f17981ao = 0;
        this.f17982ap = 6;
        this.f17983aq = 12;
        this.f17984ar = 6;
        this.f17985as = 9;
        this.f17986at = 12;
        this.f17987au = 4;
        this.f17988av = 6;
        this.f17989aw = 0;
        this.f17990ax = 24;
        this.f17991ay = 128;
        this.f17992az = -1;
        this.f17941aA = 0.0f;
        this.f17942aB = 0.0f;
        this.f17943aC = 0.0f;
        this.f17944aD = 0.0f;
        this.f17945aE = 0.0f;
        this.f17946aF = 0.0f;
        this.f17947aG = 0.0f;
        this.f17948aH = 0.0f;
        this.f17949aI = null;
        this.f17950aJ = null;
        this.f17951aK = null;
        this.f17952aL = false;
        this.f17953aM = true;
        this.f17954aN = true;
        this.f17955aO = false;
        this.f17956aP = false;
        this.f17957aQ = false;
        this.f17958aR = null;
        this.f17959aS = null;
        this.f17960aT = null;
        this.f17961aU = null;
        this.f17962aV = null;
        this.f17963aW = null;
        this.f17964aX = null;
        this.f17965aY = null;
        this.f17966aZ = null;
        this.f18015ba = null;
        this.f18016bb = null;
        this.f18017bc = null;
        this.f18018bd = null;
        this.f18019be = null;
        this.f18020bf = null;
        this.f18021bg = null;
        this.f18022bh = null;
        this.f18023bi = null;
        this.f18024bj = null;
        this.f18025bk = null;
        this.f18026bl = null;
        this.f18027bm = null;
        this.f18028bn = null;
        this.f18029bo = null;
        this.f18030bp = null;
        this.f18031bq = null;
        this.f18032br = null;
        this.f18033bs = null;
        this.f18034bt = null;
        this.f18035bu = null;
        this.f18036bv = null;
        this.f18037bw = null;
        this.f18038bx = null;
        this.f18039by = null;
        this.f18040bz = null;
        this.f17993bA = null;
        this.f17994bB = null;
        this.f17995bC = null;
        this.f17996bD = null;
        this.f17997bE = null;
        this.f17998bF = null;
        this.f17999bG = null;
        this.f18000bH = null;
        this.f18001bI = null;
        this.f18002bJ = null;
        this.f18003bK = null;
        this.f18004bL = null;
        this.f18005bM = null;
        this.f18006bN = null;
        this.f18007bO = null;
        this.f18008bP = null;
        this.f18009bQ = null;
        this.f18010bR = null;
        this.f18011bS = null;
        this.f18012bT = null;
        this.f18013bU = null;
        this.f18014bV = new Path();
    }

    public MainShutterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18041x = 1;
        this.f18042y = 1;
        this.f18043z = 0;
        this.f17918A = 0;
        this.f17919B = 0;
        this.f17920C = 0.0f;
        this.f17921D = 0;
        this.f17922E = 0;
        this.f17923F = 0;
        this.f17924G = 0;
        this.f17925H = 0;
        this.f17926I = 0;
        this.f17927J = 0;
        this.f17928K = 0;
        this.f17929L = 0;
        this.f17930M = 0;
        this.f17931N = 0;
        this.f17932O = 0.0f;
        this.f17933P = 0.0f;
        this.f17934Q = 0;
        this.f17935R = 0;
        this.f17936S = 0;
        this.f17937T = 0;
        this.f17938U = 0;
        this.f17939V = 0;
        this.f17940W = 0;
        this.f17967aa = 0;
        this.f17968ab = 0;
        this.f17969ac = 0;
        this.f17970ad = 0;
        this.f17971ae = 0;
        this.f17972af = 0;
        this.f17973ag = 0;
        this.f17974ah = 0;
        this.f17975ai = 0;
        this.f17976aj = 0;
        this.f17977ak = 0;
        this.f17978al = 0;
        this.f17979am = 0;
        this.f17980an = 255;
        this.f17981ao = 0;
        this.f17982ap = 6;
        this.f17983aq = 12;
        this.f17984ar = 6;
        this.f17985as = 9;
        this.f17986at = 12;
        this.f17987au = 4;
        this.f17988av = 6;
        this.f17989aw = 0;
        this.f17990ax = 24;
        this.f17991ay = 128;
        this.f17992az = -1;
        this.f17941aA = 0.0f;
        this.f17942aB = 0.0f;
        this.f17943aC = 0.0f;
        this.f17944aD = 0.0f;
        this.f17945aE = 0.0f;
        this.f17946aF = 0.0f;
        this.f17947aG = 0.0f;
        this.f17948aH = 0.0f;
        this.f17949aI = null;
        this.f17950aJ = null;
        this.f17951aK = null;
        this.f17952aL = false;
        this.f17953aM = true;
        this.f17954aN = true;
        this.f17955aO = false;
        this.f17956aP = false;
        this.f17957aQ = false;
        this.f17958aR = null;
        this.f17959aS = null;
        this.f17960aT = null;
        this.f17961aU = null;
        this.f17962aV = null;
        this.f17963aW = null;
        this.f17964aX = null;
        this.f17965aY = null;
        this.f17966aZ = null;
        this.f18015ba = null;
        this.f18016bb = null;
        this.f18017bc = null;
        this.f18018bd = null;
        this.f18019be = null;
        this.f18020bf = null;
        this.f18021bg = null;
        this.f18022bh = null;
        this.f18023bi = null;
        this.f18024bj = null;
        this.f18025bk = null;
        this.f18026bl = null;
        this.f18027bm = null;
        this.f18028bn = null;
        this.f18029bo = null;
        this.f18030bp = null;
        this.f18031bq = null;
        this.f18032br = null;
        this.f18033bs = null;
        this.f18034bt = null;
        this.f18035bu = null;
        this.f18036bv = null;
        this.f18037bw = null;
        this.f18038bx = null;
        this.f18039by = null;
        this.f18040bz = null;
        this.f17993bA = null;
        this.f17994bB = null;
        this.f17995bC = null;
        this.f17996bD = null;
        this.f17997bE = null;
        this.f17998bF = null;
        this.f17999bG = null;
        this.f18000bH = null;
        this.f18001bI = null;
        this.f18002bJ = null;
        this.f18003bK = null;
        this.f18004bL = null;
        this.f18005bM = null;
        this.f18006bN = null;
        this.f18007bO = null;
        this.f18008bP = null;
        this.f18009bQ = null;
        this.f18010bR = null;
        this.f18011bS = null;
        this.f18012bT = null;
        this.f18013bU = null;
        this.f18014bV = new Path();
        m18944a(context, attributeSet, 0);
    }

    public MainShutterButton(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f18041x = 1;
        this.f18042y = 1;
        this.f18043z = 0;
        this.f17918A = 0;
        this.f17919B = 0;
        this.f17920C = 0.0f;
        this.f17921D = 0;
        this.f17922E = 0;
        this.f17923F = 0;
        this.f17924G = 0;
        this.f17925H = 0;
        this.f17926I = 0;
        this.f17927J = 0;
        this.f17928K = 0;
        this.f17929L = 0;
        this.f17930M = 0;
        this.f17931N = 0;
        this.f17932O = 0.0f;
        this.f17933P = 0.0f;
        this.f17934Q = 0;
        this.f17935R = 0;
        this.f17936S = 0;
        this.f17937T = 0;
        this.f17938U = 0;
        this.f17939V = 0;
        this.f17940W = 0;
        this.f17967aa = 0;
        this.f17968ab = 0;
        this.f17969ac = 0;
        this.f17970ad = 0;
        this.f17971ae = 0;
        this.f17972af = 0;
        this.f17973ag = 0;
        this.f17974ah = 0;
        this.f17975ai = 0;
        this.f17976aj = 0;
        this.f17977ak = 0;
        this.f17978al = 0;
        this.f17979am = 0;
        this.f17980an = 255;
        this.f17981ao = 0;
        this.f17982ap = 6;
        this.f17983aq = 12;
        this.f17984ar = 6;
        this.f17985as = 9;
        this.f17986at = 12;
        this.f17987au = 4;
        this.f17988av = 6;
        this.f17989aw = 0;
        this.f17990ax = 24;
        this.f17991ay = 128;
        this.f17992az = -1;
        this.f17941aA = 0.0f;
        this.f17942aB = 0.0f;
        this.f17943aC = 0.0f;
        this.f17944aD = 0.0f;
        this.f17945aE = 0.0f;
        this.f17946aF = 0.0f;
        this.f17947aG = 0.0f;
        this.f17948aH = 0.0f;
        this.f17949aI = null;
        this.f17950aJ = null;
        this.f17951aK = null;
        this.f17952aL = false;
        this.f17953aM = true;
        this.f17954aN = true;
        this.f17955aO = false;
        this.f17956aP = false;
        this.f17957aQ = false;
        this.f17958aR = null;
        this.f17959aS = null;
        this.f17960aT = null;
        this.f17961aU = null;
        this.f17962aV = null;
        this.f17963aW = null;
        this.f17964aX = null;
        this.f17965aY = null;
        this.f17966aZ = null;
        this.f18015ba = null;
        this.f18016bb = null;
        this.f18017bc = null;
        this.f18018bd = null;
        this.f18019be = null;
        this.f18020bf = null;
        this.f18021bg = null;
        this.f18022bh = null;
        this.f18023bi = null;
        this.f18024bj = null;
        this.f18025bk = null;
        this.f18026bl = null;
        this.f18027bm = null;
        this.f18028bn = null;
        this.f18029bo = null;
        this.f18030bp = null;
        this.f18031bq = null;
        this.f18032br = null;
        this.f18033bs = null;
        this.f18034bt = null;
        this.f18035bu = null;
        this.f18036bv = null;
        this.f18037bw = null;
        this.f18038bx = null;
        this.f18039by = null;
        this.f18040bz = null;
        this.f17993bA = null;
        this.f17994bB = null;
        this.f17995bC = null;
        this.f17996bD = null;
        this.f17997bE = null;
        this.f17998bF = null;
        this.f17999bG = null;
        this.f18000bH = null;
        this.f18001bI = null;
        this.f18002bJ = null;
        this.f18003bK = null;
        this.f18004bL = null;
        this.f18005bM = null;
        this.f18006bN = null;
        this.f18007bO = null;
        this.f18008bP = null;
        this.f18009bQ = null;
        this.f18010bR = null;
        this.f18011bS = null;
        this.f18012bT = null;
        this.f18013bU = null;
        this.f18014bV = new Path();
        m18944a(context, attributeSet, OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m18944a(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        setButtonTypeAndInvalidate(new MainShutterButtonInfo(1, "button_color_inside_none", "button_shape_ring_none"));
        m18889b(context, attributeSet, OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m18889b(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MainShutterButton, OplusGLSurfaceView_13, 0);
        Resources resources = context.getResources();
        try {
            try {
                this.f18043z = typedArrayObtainStyledAttributes.getDimensionPixelSize(18, resources.getDimensionPixelSize(R.dimen.shutter_button_big_circle_radius));
                this.f17918A = typedArrayObtainStyledAttributes.getDimensionPixelSize(14, resources.getDimensionPixelSize(R.dimen.shutter_button_small_circle_radius));
                this.f17921D = typedArrayObtainStyledAttributes.getDimensionPixelSize(16, resources.getDimensionPixelSize(R.dimen.shutter_button_inside_rect_length));
                this.f17922E = typedArrayObtainStyledAttributes.getDimensionPixelSize(15, resources.getDimensionPixelSize(R.dimen.shutter_button_inside_rect_corner_radius));
                this.f17925H = typedArrayObtainStyledAttributes.getInt(0, resources.getInteger(R.integer.main_btn_default_angleAnimationDurationMillis));
                this.f17926I = typedArrayObtainStyledAttributes.getInt(22, resources.getInteger(R.integer.main_btn_default_sweepAnimationDuration));
                this.f17927J = typedArrayObtainStyledAttributes.getInt(17, resources.getInteger(R.integer.main_btn_default_miniSweepAngle));
                this.f17945aE = 360 - this.f17927J;
                this.f17931N = typedArrayObtainStyledAttributes.getDimensionPixelSize(4, resources.getDimensionPixelSize(R.dimen.shutter_button_big_circle_radius_scaled));
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
            typedArrayObtainStyledAttributes.recycle();
            this.f17934Q = getResources().getDimensionPixelOffset(R.dimen.camera_button_path_width);
            this.f17935R = getResources().getDimensionPixelOffset(R.dimen.step_next_width);
            this.f17936S = getResources().getDimensionPixelOffset(R.dimen.step_next_height);
            this.f17938U = getResources().getDimensionPixelOffset(R.dimen.step_next_top);
            this.f17937T = getResources().getDimensionPixelOffset(R.dimen.step_next_left);
            this.f17940W = this.f17938U + this.f17936S;
            this.f17939V = this.f17937T + this.f17935R;
            this.f17967aa = getResources().getDimensionPixelOffset(R.dimen.step_complete_width);
            this.f17968ab = getResources().getDimensionPixelOffset(R.dimen.step_complete_height);
            this.f17969ac = getResources().getDimensionPixelOffset(R.dimen.step_complete_left);
            this.f17970ad = getResources().getDimensionPixelOffset(R.dimen.step_complete_top);
            this.f17971ae = getResources().getDimensionPixelOffset(R.dimen.step_complete_hook_x1);
            this.f17972af = getResources().getDimensionPixelOffset(R.dimen.step_complete_hook_y1);
            this.f17973ag = getResources().getDimensionPixelOffset(R.dimen.step_complete_hook_x2);
            this.f17974ah = getResources().getDimensionPixelOffset(R.dimen.step_complete_hook_y2);
            this.f17975ai = getResources().getDimensionPixelOffset(R.dimen.step_complete_hook_x3);
            this.f17976aj = getResources().getDimensionPixelOffset(R.dimen.step_complete_hook_y3);
            this.f17987au = getResources().getDimensionPixelOffset(R.dimen.double_exposure_shutter_shadow_offset);
            this.f17932O = this.f18043z - this.f17918A;
            this.f18022bh = new Paint();
            this.f18022bh.setAntiAlias(true);
            this.f18022bh.setStyle(Paint.Style.STROKE);
            this.f18022bh.setStrokeWidth(this.f17932O);
            this.f18023bi = new Paint();
            this.f18023bi.setAntiAlias(true);
            this.f18023bi.setStyle(Paint.Style.FILL);
            this.f18023bi.setAlpha(128);
            this.f18024bj = new Paint();
            this.f18024bj.setAntiAlias(true);
            this.f18024bj.setStyle(Paint.Style.FILL);
            this.f18024bj.setColor(f17911q);
            this.f18025bk = new Paint();
            this.f18025bk.setAntiAlias(true);
            this.f18025bk.setStyle(Paint.Style.FILL);
            this.f18025bk.setAlpha(51);
            this.f18027bm = new Paint();
            this.f18027bm.setAntiAlias(true);
            this.f18027bm.setStyle(Paint.Style.STROKE);
            this.f18027bm.setStrokeWidth(this.f17932O);
            this.f18028bn = new Paint();
            this.f18028bn.setAntiAlias(true);
            this.f18028bn.setStyle(Paint.Style.FILL);
            this.f18030bp = new Paint();
            this.f18030bp.setAntiAlias(true);
            this.f18030bp.setColor(-1);
            this.f18030bp.setStyle(Paint.Style.STROKE);
            this.f18030bp.setStrokeWidth(this.f17934Q);
            this.f18030bp.setStrokeCap(Paint.Cap.SQUARE);
            this.f18030bp.setStrokeJoin(Paint.Join.ROUND);
            this.f18031bq = new Paint(this.f18030bp);
            if (Util.m24352ao()) {
                this.f17933P = getResources().getDimensionPixelOffset(R.dimen.shutter_button_hasseiblad_arc_thickness);
                this.f18032br = new Paint();
                this.f18032br.setAntiAlias(true);
                this.f18032br.setColor(f17914t);
                this.f18032br.setStyle(Paint.Style.FILL);
                Paint paint = this.f18032br;
                paint.setAlpha(paint.getColor() >>> 24);
                this.f18032br.setShader(m18905e(f17914t, f17915u));
                this.f18033bs = new Paint();
                this.f18033bs.setAntiAlias(true);
                this.f18033bs.setColor(f17914t);
                this.f18033bs.setStyle(Paint.Style.STROKE);
                Paint paint2 = this.f18033bs;
                paint2.setAlpha(paint2.getColor() >>> 24);
                this.f18033bs.setShader(m18905e(f17914t, f17915u));
                this.f18034bt = new Paint();
                this.f18034bt.setAntiAlias(true);
                this.f18034bt.setColor(f17917w);
                this.f18034bt.setStyle(Paint.Style.STROKE);
                this.f18034bt.setStrokeWidth(this.f17933P);
                this.f18035bu = new Paint();
                this.f18035bu.setAntiAlias(true);
                this.f18035bu.setColor(f17914t);
                this.f18035bu.setStyle(Paint.Style.STROKE);
                this.f18035bu.setStrokeCap(Paint.Cap.ROUND);
                this.f18035bu.setStrokeWidth(this.f17933P);
                this.f18026bl = new Paint();
                this.f18026bl.setAntiAlias(true);
                this.f18026bl.setStyle(Paint.Style.FILL);
                this.f18026bl.setColor(f17914t);
                Paint paint3 = this.f18026bl;
                paint3.setAlpha(paint3.getColor() >>> 24);
                this.f18026bl.setShader(m18905e(f17914t, f17915u));
            }
            m18918k();
            m18928p();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Bitmap m18873a(Bitmap bitmap, int OplusGLSurfaceView_13) {
        Drawable drawable = getContext().getDrawable(OplusGLSurfaceView_13);
        drawable.setState(getDrawableState());
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = this.f17961aU;
        if (canvas == null) {
            this.f17961aU = new Canvas(bitmap);
        } else {
            canvas.setBitmap(bitmap);
        }
        drawable.setBounds(0, 0, this.f17961aU.getWidth(), this.f17961aU.getHeight());
        this.f17961aU.drawColor(0, BlendMode.CLEAR);
        drawable.draw(this.f17961aU);
        return bitmap;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Bitmap m18874a(Bitmap bitmap, int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) {
        Drawable drawable = getContext().getDrawable(OplusGLSurfaceView_13);
        drawable.setState(getDrawableState());
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = this.f17961aU;
        if (canvas == null) {
            this.f17961aU = new Canvas(bitmap);
        } else {
            canvas.setBitmap(bitmap);
        }
        drawable.setTint(f17916v);
        double IntrinsicsJvm.kt_5 = 1.0d - COUIBaseListPopupWindow_12;
        drawable.setBounds((int) (((this.f17961aU.getWidth() / 2.0f) * IntrinsicsJvm.kt_5) + 0.0d), (int) (((this.f17961aU.getHeight() / 2.0f) * IntrinsicsJvm.kt_5) + 0.0d), (int) (this.f17961aU.getWidth() - ((this.f17961aU.getWidth() / 2.0f) * IntrinsicsJvm.kt_5)), (int) (this.f17961aU.getHeight() - ((this.f17961aU.getHeight() / 2.0f) * IntrinsicsJvm.kt_5)));
        this.f17961aU.drawColor(0, BlendMode.CLEAR);
        drawable.draw(this.f17961aU);
        return bitmap;
    }

    @Override // com.oplus.camera.p172ui.control.ShutterButton, com.oplus.camera.p172ui.RotateImageView, com.oplus.camera.p172ui.inverse.InverseAble
    public void setInverseColor(final boolean z) {
        this.f18081n = z;
        m18918k();
        refreshDrawableState();
        m18939x();
        post(new Runnable() { // from class: com.oplus.camera.ui.control.-$$Lambda$MainShutterButton$K6b3K5fIqeHI87OactLQ4tWRGNo
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.m18885a(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m18885a(boolean z) {
        if (z) {
            setBackgroundColor(0);
        } else if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_UI_SHUTTER_BUTTON_TYPE_LOW_LIGHT)) {
            setBackgroundResource(R.drawable.button_shutter_low_shadow_background);
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_5 */
    public void m18918k() {
        int OplusGLSurfaceView_13;
        if (this.f18081n) {
            OplusGLSurfaceView_13 = f17913s;
        } else {
            OplusGLSurfaceView_13 = (this.f17955aO || !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_UI_SHUTTER_BUTTON_TYPE_LOW_LIGHT)) ? -1 : f17912r;
        }
        this.f17978al = OplusGLSurfaceView_13;
        this.f17979am = Util.m24164A(getContext());
        int i2 = this.f17978al;
        this.f17992az = i2;
        ValueAnimator valueAnimator = this.f17996bD;
        if (valueAnimator != null) {
            valueAnimator.setIntValues(this.f17979am, i2);
        }
        Paint paint = this.f18022bh;
        if (paint != null) {
            paint.setColor(this.f17978al);
        }
        Paint paint2 = this.f18023bi;
        if (paint2 != null) {
            paint2.setColor(this.f17978al);
        }
        Paint paint3 = this.f18025bk;
        if (paint3 != null) {
            paint3.setColor(this.f17978al);
        }
        Paint paint4 = this.f18027bm;
        if (paint4 != null) {
            paint4.setColor(this.f17978al);
        }
        Paint paint5 = this.f18028bn;
        if (paint5 != null) {
            paint5.setColor(this.f17978al);
        }
        Paint paint6 = this.f18030bp;
        if (paint6 != null) {
            paint6.setColor(this.f17978al);
        }
        if (Util.m24352ao()) {
            Paint paint7 = this.f18032br;
            if (paint7 != null) {
                paint7.setColor(f17914t);
                Paint paint8 = this.f18032br;
                paint8.setAlpha(paint8.getColor() >>> 24);
                this.f18032br.setShader(m18905e(f17914t, f17915u));
            }
            Paint paint9 = this.f18033bs;
            if (paint9 != null) {
                paint9.setColor(f17914t);
                Paint paint10 = this.f18033bs;
                paint10.setAlpha(paint10.getColor() >>> 24);
                this.f18033bs.setShader(m18905e(f17914t, f17915u));
            }
            Paint paint11 = this.f18034bt;
            if (paint11 != null) {
                paint11.setColor(f17917w);
            }
            Paint paint12 = this.f18035bu;
            if (paint12 != null) {
                paint12.setColor(f17914t);
            }
            Paint paint13 = this.f18026bl;
            if (paint13 != null) {
                paint13.setColor(f17914t);
                Paint paint14 = this.f18026bl;
                paint14.setAlpha(paint14.getColor() >>> 24);
                this.f18026bl.setShader(m18905e(f17914t, f17915u));
            }
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        if (this.f17998bF == null || this.f17997bE == null) {
            CameraLog.m12954a("MainShutterButton", "setPressed, return because Animator is null");
            return;
        }
        boolean z2 = z != isPressed();
        super.setPressed(z);
        if (z2) {
            m18936u();
            if (isPressed()) {
                float COUIBaseListPopupWindow_12 = this.f17941aA;
                int OplusGLSurfaceView_13 = this.f18043z;
                if (COUIBaseListPopupWindow_12 <= OplusGLSurfaceView_13) {
                    COUIBaseListPopupWindow_12 = OplusGLSurfaceView_13;
                }
                this.f17997bE.setFloatValues(COUIBaseListPopupWindow_12, this.f17931N);
                this.f17998bF.setDuration((long) (((this.f17931N - COUIBaseListPopupWindow_12) * 100.0f) / (r2 - this.f18043z)));
                this.f17997bE.start();
            } else {
                float f2 = this.f17941aA;
                int i2 = this.f18043z;
                if (f2 <= i2) {
                    f2 = i2;
                }
                this.f17998bF.setFloatValues(f2, this.f18043z);
                this.f17998bF.setDuration((long) (((f2 - this.f18043z) * 100.0f) / (this.f17931N - r2)));
                this.f17998bF.start();
            }
            invalidate();
        }
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private void m18919l() {
        if (m18924n()) {
            return;
        }
        this.f17952aL = true;
        ValueAnimator valueAnimator = this.f17959aS;
        if (valueAnimator != null) {
            valueAnimator.setRepeatCount(-1);
            this.f17959aS.start();
        }
        AnimatorSet animatorSet = this.f17958aR;
        if (animatorSet != null) {
            animatorSet.start();
        }
        invalidate();
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private void m18922m() {
        if (m18924n()) {
            this.f17952aL = false;
            ValueAnimator valueAnimator = this.f17959aS;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            AnimatorSet animatorSet = this.f17958aR;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            invalidate();
        }
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean m18924n() {
        return this.f17952aL;
    }

    /* JADX WARN: Removed duplicated region for block: B:172:0x096a  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0972  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02ec  */
    @Override // com.oplus.camera.p172ui.control.ShutterButton, com.oplus.camera.p172ui.RotateImageView, android.widget.ImageView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onDraw(android.graphics.Canvas r18) {
        /*
            Method dump skipped, instructions count: 4233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.control.MainShutterButton.onDraw(android.graphics.Canvas):void");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m18880a(Canvas canvas, boolean z) {
        m18881a(canvas, z, false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m18881a(Canvas canvas, boolean z, boolean z2) {
        if ("button_color_inside_red".equals(this.f17949aI)) {
            this.f18024bj.setAlpha(this.f17980an);
            this.f18029bo = this.f18024bj;
        } else if ("button_color_inside_grey".equals(this.f17949aI)) {
            this.f18025bk.setAlpha(51);
            this.f18029bo = this.f18025bk;
        }
        if (z) {
            if (isPressed()) {
                Paint paint = this.f18029bo;
                if (paint != null) {
                    paint.setAlpha(51);
                }
                this.f18027bm.setAlpha(128);
            } else {
                this.f18027bm.setAlpha(255);
            }
        }
        if (this.f18029bo != null && 2 != this.f18041x) {
            int OplusGLSurfaceView_13 = "button_shape_ring_none".equals(this.f17950aJ) ? this.f17918A : this.f17919B;
            RectF rectF = "button_shape_ring_none".equals(this.f17950aJ) ? this.f18016bb : this.f18017bc;
            float COUIBaseListPopupWindow_12 = OplusGLSurfaceView_13;
            RectF rectF2 = new RectF((rectF.left + COUIBaseListPopupWindow_12) - (((rectF.right - rectF.left) / 2.0f) * this.f17947aG), (rectF.top + COUIBaseListPopupWindow_12) - (((rectF.bottom - rectF.top) / 2.0f) * this.f17947aG), (rectF.right - COUIBaseListPopupWindow_12) + (((rectF.right - rectF.left) / 2.0f) * this.f17947aG), (rectF.bottom - COUIBaseListPopupWindow_12) + (((rectF.bottom - rectF.top) / 2.0f) * this.f17947aG));
            int alpha = this.f18029bo.getAlpha();
            this.f18029bo.setAlpha((int) (this.f17948aH * 255.0f));
            canvas.drawRoundRect(rectF2, COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12, this.f18029bo);
            this.f18029bo.setAlpha(alpha);
        }
        if (this.f17955aO && !isPressed()) {
            Bitmap bitmap = this.f17966aZ;
            if (bitmap == null) {
                this.f17966aZ = m18873a(bitmap, R.drawable.shutter_button_shadow);
            }
            Bitmap bitmap2 = this.f17966aZ;
            canvas.drawBitmap(bitmap2, new Rect(0, 0, bitmap2.getWidth(), this.f17966aZ.getHeight()), this.f18019be, this.f18031bq);
        }
        if (z2) {
            RectF rectF3 = this.f18018bd;
            int i2 = this.f18043z;
            canvas.drawRoundRect(rectF3, i2, i2, this.f18032br);
        } else {
            RectF rectF4 = this.f18018bd;
            int i3 = this.f18043z;
            canvas.drawRoundRect(rectF4, i3, i3, this.f18027bm);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m18879a(Canvas canvas, Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        canvas.drawBitmap(bitmap, (Rect) null, new RectF((getWidth() - bitmap.getWidth()) / 2, (getHeight() - bitmap.getHeight()) / 2, (getWidth() + bitmap.getWidth()) / 2, (getHeight() + bitmap.getHeight()) / 2), (Paint) null);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m18890b(Canvas canvas, Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        canvas.drawBitmap(bitmap, (Rect) null, new RectF((getWidth() - bitmap.getWidth()) / 2, (getHeight() - bitmap.getHeight()) / 2, (getWidth() + bitmap.getWidth()) / 2, (getHeight() + bitmap.getHeight()) / 2), (Paint) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m18926o() {
        setModeAppearing(!this.f17953aM);
        if (this.f17953aM) {
            return;
        }
        this.f17942aB = (this.f17942aB + this.f17927J) % 360.0f;
    }

    /* renamed from: p */
    private void m18928p() {
        m18930q();
        m18940y();
        m18941z();
    }

    /* renamed from: q */
    private void m18930q() {
        this.f18036bv = new Property<MainShutterButton, Float>(Float.class, "angle") { // from class: com.oplus.camera.ui.control.MainShutterButton.1
            @Override // android.util.Property
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public Float get(MainShutterButton mainShutterButton) {
                return Float.valueOf(mainShutterButton.getCurrentGlobalAngle());
            }

            @Override // android.util.Property
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public void set(MainShutterButton mainShutterButton, Float COUIBaseListPopupWindow_12) {
                mainShutterButton.setCurrentGlobalAngle(COUIBaseListPopupWindow_12.floatValue());
            }
        };
        this.f18037bw = new Property<MainShutterButton, Float>(Float.class, "arc") { // from class: com.oplus.camera.ui.control.MainShutterButton.12
            @Override // android.util.Property
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public Float get(MainShutterButton mainShutterButton) {
                return Float.valueOf(mainShutterButton.getCurrentSweepAngle());
            }

            @Override // android.util.Property
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public void set(MainShutterButton mainShutterButton, Float COUIBaseListPopupWindow_12) {
                mainShutterButton.setCurrentSweepAngle(COUIBaseListPopupWindow_12.floatValue());
            }
        };
        this.f17959aS = ValueAnimator.ofFloat(0.0f, 360.0f);
        this.f17959aS.setInterpolator(f17909o);
        this.f17959aS.setDuration(this.f17925H);
        this.f17959aS.setRepeatMode(1);
        this.f17959aS.setRepeatCount(-1);
        this.f17959aS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.23
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                MainShutterButton.this.setCurrentGlobalAngle(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.f17958aR = new AnimatorSet();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(360.0f, this.f17927J);
        valueAnimatorOfFloat.setInterpolator(f17909o);
        valueAnimatorOfFloat.setDuration(this.f17926I);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.31
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                MainShutterButton.this.setCurrentSweepAngle(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.control.MainShutterButton.32
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                MainShutterButton.this.setModeAppearing(false);
            }
        });
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(this.f17927J, 270.0f);
        valueAnimatorOfFloat2.setInterpolator(f17909o);
        valueAnimatorOfFloat2.setDuration(this.f17926I);
        valueAnimatorOfFloat2.setRepeatMode(2);
        valueAnimatorOfFloat2.setRepeatCount(-1);
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.33
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                MainShutterButton.this.setCurrentSweepAngle(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        valueAnimatorOfFloat2.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.control.MainShutterButton.34
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                MainShutterButton.this.m18926o();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                MainShutterButton.this.setModeAppearing(true);
            }
        });
        this.f17958aR.playSequentially(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        this.f17960aT = ValueAnimator.ofFloat(360.0f, this.f17927J);
        this.f17960aT.setInterpolator(f17909o);
        this.f17960aT.setDuration(this.f17926I);
        this.f17960aT.setRepeatMode(2);
        this.f17960aT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.35
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                MainShutterButton.this.setCurrentSweepAngle(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.f17960aT.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.control.MainShutterButton.36
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                MainShutterButton.this.m23921a(false, false);
                MainShutterButton.this.setClickable(false);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                MainShutterButton.this.setButtonTypeAndInvalidate(1);
                MainShutterButton.this.setEnabled(true);
                MainShutterButton.this.setClickable(true);
                if (MainShutterButton.this.f17959aS != null) {
                    MainShutterButton.this.f17959aS.cancel();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                MainShutterButton.this.setButtonTypeAndInvalidate(1);
                MainShutterButton.this.setEnabled(true);
                MainShutterButton.this.setClickable(true);
                if (MainShutterButton.this.f17959aS != null) {
                    MainShutterButton.this.f17959aS.cancel();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                MainShutterButton.this.m18926o();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setModeAppearing(boolean z) {
        CameraLog.m12954a("MainShutterButton", "setModeAppearing, " + this.f17953aM + " -> " + z);
        this.f17953aM = z;
    }

    public float getCurrentGlobalAngle() {
        return this.f17943aC;
    }

    public void setCurrentGlobalAngle(float COUIBaseListPopupWindow_12) {
        this.f17943aC = COUIBaseListPopupWindow_12;
        invalidate();
    }

    public float getCurrentSweepAngle() {
        return this.f17944aD;
    }

    public void setCurrentSweepAngle(float COUIBaseListPopupWindow_12) {
        this.f17944aD = COUIBaseListPopupWindow_12;
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        CameraLog.m12954a("MainShutterButton", "onAttachedToWindow, mButtonType: " + this.f18041x);
        if (4 == this.f18041x) {
            m18919l();
        }
        super.onAttachedToWindow();
    }

    @Override // com.oplus.camera.p172ui.RotateImageView, android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        CameraLog.m12954a("MainShutterButton", " onDetachedFromWindow, mButtonType: " + this.f18041x);
        if (4 == this.f18041x) {
            m18922m();
        }
        super.onDetachedFromWindow();
    }

    public void setButtonTypeAndInvalidate(MainShutterButtonInfo c3200b) {
        CameraLog.m12954a("MainShutterButton", "setButtonTypeAndInvalidate, mShutterButtonType: " + c3200b.m19225a() + ", mInfoInsideColor: " + c3200b.m19229b() + ", mRingShape: " + c3200b.m19237d() + ", mInfoInsideRectColor: " + c3200b.m19238e() + ", mbMoreModeShown: " + c3200b.m19241h());
        ObjectAnimator objectAnimator = this.f18039by;
        if (objectAnimator != null && objectAnimator.isRunning() && 6 == c3200b.m19225a()) {
            this.f18039by.cancel();
        }
        ValueAnimator valueAnimator = this.f18005bM;
        if (valueAnimator != null && valueAnimator.isRunning() && 22 == c3200b.m19225a()) {
            this.f18005bM.cancel();
        }
        ValueAnimator valueAnimator2 = this.f17960aT;
        if (valueAnimator2 != null && valueAnimator2.isRunning() && 13 == c3200b.m19225a()) {
            this.f17960aT.cancel();
        }
        m18933s();
        m18935t();
        int OplusGLSurfaceView_13 = this.f18041x;
        String str = this.f17949aI;
        String str2 = this.f17950aJ;
        boolean z = this.f17955aO;
        String str3 = this.f17951aK;
        this.f17955aO = c3200b.m19240g();
        this.f17949aI = c3200b.m19229b();
        this.f17950aJ = c3200b.m19237d();
        this.f17951aK = c3200b.m19233c();
        this.f17989aw = c3200b.m19238e();
        setButtonType(c3200b.m19225a());
        setNextButtonType(c3200b.m19242i());
        if (z != c3200b.m19240g()) {
            m18918k();
        }
        if (this.f18041x != 4 && m18924n()) {
            this.f17952aL = false;
            m18932r();
        }
        if (c3200b.m19239f()) {
            if ("button_color_inside_red".equals(this.f17949aI)) {
                this.f17980an = 0;
            }
            m18948c();
        } else {
            this.f17980an = 255;
        }
        int i2 = this.f18041x;
        if (3 == i2 || 29 == i2 || 34 == i2) {
            m18860D();
            return;
        }
        if (4 == i2 && 3 == OplusGLSurfaceView_13 && "button_color_ring_theme".equals(str3)) {
            m18861E();
            m18919l();
            return;
        }
        if (32 == this.f18041x && 4 == OplusGLSurfaceView_13) {
            m18862F();
            return;
        }
        int i3 = this.f18041x;
        if (4 == i3) {
            m18919l();
            return;
        }
        if (14 == i3) {
            m18919l();
            return;
        }
        if (5 == i3 && "button_shape_dial_rotate".equals(this.f17950aJ)) {
            m18949d();
            return;
        }
        int i4 = this.f18041x;
        if (16 == i4) {
            m18864H();
            return;
        }
        if (17 == i4) {
            m18867K();
            return;
        }
        if (18 == i4) {
            m18865I();
            return;
        }
        if (19 == i4) {
            m18866J();
            return;
        }
        if (25 == i4) {
            m18868L();
            return;
        }
        if (26 == i4 && OplusGLSurfaceView_13 != i4) {
            m18869M();
            return;
        }
        int i5 = this.f18041x;
        if (28 == i5) {
            m18919l();
            return;
        }
        if ((1 == i5 || 23 == i5) && str != null && !str.equals(this.f17949aI)) {
            m18902d("button_color_inside_red".equals(this.f17949aI), c3200b.m19241h() && "button_shape_ring_none".equals(str2) && "button_shape_ring_none".equals(this.f17950aJ));
            return;
        }
        int i6 = this.f18041x;
        if (31 == i6 || 36 == i6) {
            m18863G();
        } else {
            invalidate();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m18876a(int OplusGLSurfaceView_13, String str) {
        this.f17949aI = str;
        setButtonTypeAndInvalidate(OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m18901d(int OplusGLSurfaceView_13, int i2) {
        this.f17989aw = i2;
        setButtonTypeAndInvalidate(OplusGLSurfaceView_13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setButtonTypeAndInvalidate(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("MainShutterButton", "setButtonTypeAndInvalidate, buttonType: " + OplusGLSurfaceView_13);
        m18933s();
        m18935t();
        int i2 = this.f18041x;
        String str = this.f17951aK;
        setButtonType(OplusGLSurfaceView_13);
        if (this.f18041x != 4 && m18924n()) {
            this.f17952aL = false;
            m18932r();
        }
        int i3 = this.f18041x;
        if (3 == i3 || 29 == i3 || 34 == i3) {
            m18860D();
            return;
        }
        if (4 == i3 && 3 == i2 && "button_color_ring_theme".equals(str)) {
            m18861E();
            m18919l();
            return;
        }
        if (32 == this.f18041x && 4 == i2) {
            m18862F();
            return;
        }
        int i4 = this.f18041x;
        if (4 == i4) {
            m18919l();
            return;
        }
        if (14 == i4) {
            m18919l();
            return;
        }
        if (5 == i4 && "button_shape_dial_rotate".equals(this.f17950aJ)) {
            m18949d();
            return;
        }
        int i5 = this.f18041x;
        if (25 == i5) {
            m18868L();
        } else if (31 == i5 || 36 == i5) {
            m18863G();
        } else {
            invalidate();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18945a(MainShutterButtonInfo c3200b) {
        MainShutterButtonInfo shutterButtonInfo = getShutterButtonInfo();
        if (shutterButtonInfo == null) {
            CameraLog.m12967f("MainShutterButton", "switchToModeType, null == currentButtonInfo");
            return;
        }
        CameraLog.m12954a("MainShutterButton", "switchToModeType, before shutterButtonType: " + shutterButtonInfo.m19225a() + ", before insideColor: " + shutterButtonInfo.m19229b() + ", before ringShape: " + shutterButtonInfo.m19237d() + " -> after shutterButtonType: " + c3200b.m19225a() + ", after insideColor: " + c3200b.m19229b() + ", after ringShape: " + c3200b.m19237d());
        setButtonTypeAndInvalidate(c3200b);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m18947b(MainShutterButtonInfo c3200b) {
        return c3200b.m19225a() == this.f18041x && c3200b.m19229b().equals(this.f17949aI) && c3200b.m19237d().equals(this.f17950aJ);
    }

    /* renamed from: r */
    private void m18932r() {
        ValueAnimator valueAnimator = this.f17959aS;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        AnimatorSet animatorSet = this.f17958aR;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        invalidate();
    }

    /* renamed from: s */
    private void m18933s() {
        ValueAnimator valueAnimator = this.f17994bB;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f17994bB.cancel();
    }

    /* renamed from: t */
    private void m18935t() {
        ValueAnimator valueAnimator = this.f18010bR;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f18010bR.cancel();
    }

    /* renamed from: u */
    private void m18936u() {
        ValueAnimator valueAnimator = this.f17997bE;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f17997bE.cancel();
        }
        ValueAnimator valueAnimator2 = this.f17998bF;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            return;
        }
        this.f17998bF.cancel();
    }

    public void setButtonType(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("MainShutterButton", "setButtonType, type: " + this.f18041x + " => " + OplusGLSurfaceView_13);
        this.f18041x = OplusGLSurfaceView_13;
        if (12 == this.f18041x) {
            this.f17977ak = 0;
        }
        if (this.f17924G != 0) {
            this.f17924G = 0;
        }
    }

    public void setNextButtonType(int OplusGLSurfaceView_13) {
        this.f18042y = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18943a(int OplusGLSurfaceView_13, String str, int i2) {
        CameraLog.m12954a("MainShutterButton", "setButtonType, insideRectColor: " + this.f17989aw + " => " + i2 + ", inSideColor: " + this.f17949aI + " => " + str);
        this.f17949aI = str;
        this.f17989aw = i2;
        setButtonType(OplusGLSurfaceView_13);
    }

    public int getButtonType() {
        return this.f18041x;
    }

    public String getInsideColor() {
        return this.f17949aI;
    }

    public String getRingShape() {
        return this.f17950aJ;
    }

    public MainShutterButtonInfo getShutterButtonInfo() {
        return new MainShutterButtonInfo(this.f18041x, this.f17949aI);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18942a() {
        m18937v();
        m18938w();
        m18859C();
        m18939x();
    }

    /* renamed from: v */
    private void m18937v() {
        this.f18016bb = null;
        this.f18018bd = null;
        this.f18020bf = null;
        this.f18022bh = null;
        this.f18023bi = null;
        this.f18024bj = null;
        this.f18025bk = null;
    }

    /* renamed from: w */
    private void m18938w() {
        this.f17959aS = null;
        this.f17958aR = null;
        this.f18036bv = null;
        this.f18037bw = null;
        this.f18038bx = null;
    }

    /* renamed from: x */
    private void m18939x() {
        Bitmap bitmap = this.f17962aV;
        if (bitmap != null) {
            bitmap.recycle();
            this.f17962aV = null;
        }
        Bitmap bitmap2 = this.f17963aW;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.f17963aW = null;
        }
        Bitmap bitmap3 = this.f17964aX;
        if (bitmap3 != null) {
            bitmap3.recycle();
            this.f17964aX = null;
        }
        Bitmap bitmap4 = this.f17965aY;
        if (bitmap4 != null) {
            bitmap4.recycle();
            this.f17965aY = null;
        }
        this.f17961aU = null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m18946b() {
        ObjectAnimator objectAnimator = this.f18040bz;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.f17930M = 0;
        }
        ObjectAnimator objectAnimator2 = this.f18039by;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
    }

    /* renamed from: y */
    private void m18940y() {
        Resources resources = getResources();
        this.f17982ap = resources.getDimensionPixelSize(R.dimen.shutter_button_line_height);
        this.f17986at = resources.getDimensionPixelSize(R.dimen.shutter_button_long_line_height);
        this.f17988av = resources.getDimensionPixelSize(R.dimen.shutter_button_long_line_padding);
        int OplusGLSurfaceView_13 = this.f17988av;
        this.f17990ax = (OplusGLSurfaceView_13 * 2) + this.f17986at;
        int i2 = this.f17918A;
        int i3 = this.f17990ax;
        this.f17919B = i2 - i3;
        this.f17984ar = OplusGLSurfaceView_13;
        int i4 = this.f17982ap;
        this.f17983aq = (i3 - i4) - this.f17984ar;
        this.f17985as = (i3 - i4) / 2;
        this.f18038bx = new Property<MainShutterButton, Integer>(Integer.class, "dial") { // from class: com.oplus.camera.ui.control.MainShutterButton.2
            @Override // android.util.Property
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public Integer get(MainShutterButton mainShutterButton) {
                return Integer.valueOf(mainShutterButton.getDialValue());
            }

            @Override // android.util.Property
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public void set(MainShutterButton mainShutterButton, Integer num) {
                mainShutterButton.setDialValue(num.intValue());
            }
        };
        this.f18039by = ObjectAnimator.ofInt(this, this.f18038bx, 0, 60);
        this.f18039by.setInterpolator(new LinearInterpolator());
        this.f18039by.setDuration(600L);
        this.f18039by.addListener(new Animator.AnimatorListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                MainShutterButton.this.f17923F = 0;
                CameraLog.m12954a("MainShutterButton", "onAnimationEnd, mRingDotPrepareAnimator end, mButtonType: " + MainShutterButton.this.f18041x);
                if (MainShutterButton.this.f18040bz != null) {
                    if ((2 == MainShutterButton.this.f18041x || 5 == MainShutterButton.this.f18041x) && "button_shape_dial_rotate".equals(MainShutterButton.this.f17950aJ)) {
                        MainShutterButton.this.f18040bz.setCurrentFraction(0.5f);
                        MainShutterButton.this.f18040bz.start();
                        if (2 != MainShutterButton.this.f18041x) {
                            MainShutterButton.this.setButtonType(2);
                        }
                    }
                }
            }
        });
        this.f17994bB = ValueAnimator.ofInt(0, 360);
        this.f17994bB.setInterpolator(new LinearInterpolator());
        this.f17994bB.setDuration(this.f17929L);
        this.f17994bB.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.control.MainShutterButton.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                MainShutterButton.this.m18918k();
            }
        });
        this.f17994bB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (MainShutterButton.this.f17928K != iIntValue) {
                    MainShutterButton.this.f17928K = iIntValue;
                    MainShutterButton.this.invalidate();
                }
                if (360 != iIntValue || 1 >= MainShutterButton.this.f18042y) {
                    return;
                }
                MainShutterButton.this.setButtonTypeAndInvalidate(4);
            }
        });
        this.f17995bC = ValueAnimator.ofInt(255, 77);
        this.f17995bC.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f));
        this.f17995bC.setDuration(180L);
        this.f17995bC.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.control.MainShutterButton.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                MainShutterButton.this.f17991ay = 255;
            }
        });
        this.f17995bC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (((Integer) valueAnimator.getAnimatedValue()).intValue() != MainShutterButton.this.f17991ay) {
                    MainShutterButton.this.f17991ay = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    MainShutterButton.this.invalidate();
                }
            }
        });
        this.f17996bD = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(this.f17979am), Integer.valueOf(this.f17978al));
        this.f17996bD.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f));
        this.f17996bD.setDuration(250L);
        this.f17996bD.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.control.MainShutterButton.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                MainShutterButton mainShutterButton = MainShutterButton.this;
                mainShutterButton.f17992az = mainShutterButton.f17979am;
            }
        });
        this.f17996bD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.-$$Lambda$MainShutterButton$kAPST3TKwqPRkOCehgR5ePHHd_M
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.COUIBaseListPopupWindow_12$0.m18877a(valueAnimator);
            }
        });
        this.f18010bR = ValueAnimator.ofInt(0, 360);
        this.f18010bR.setInterpolator(new LinearInterpolator());
        this.f18010bR.setDuration(this.f17929L);
        this.f18010bR.setRepeatCount(-1);
        this.f18010bR.setRepeatMode(1);
        this.f18010bR.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.control.MainShutterButton.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (Util.m24352ao()) {
                    MainShutterButton.this.f17957aQ = false;
                } else {
                    MainShutterButton.this.f18027bm.setAlpha(128);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
                if (!Util.m24352ao()) {
                    if (128 == MainShutterButton.this.f18027bm.getAlpha()) {
                        MainShutterButton.this.f18027bm.setAlpha(255);
                        MainShutterButton.this.f18022bh.setColor(-7829368);
                        return;
                    } else {
                        MainShutterButton.this.f18027bm.setAlpha(128);
                        MainShutterButton.this.f18022bh.setColor(-1);
                        return;
                    }
                }
                MainShutterButton.this.f17957aQ = !r1.f17957aQ;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (Util.m24352ao()) {
                    MainShutterButton.this.f17957aQ = false;
                }
                MainShutterButton.this.m18918k();
            }
        });
        this.f18010bR.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (MainShutterButton.this.f17928K != iIntValue) {
                    MainShutterButton.this.f17928K = iIntValue;
                    MainShutterButton.this.invalidate();
                }
            }
        });
        this.f18040bz = ObjectAnimator.ofInt(this, this.f18038bx, 0, 120);
        this.f18040bz.setRepeatMode(1);
        this.f18040bz.setRepeatCount(-1);
        this.f18040bz.setInterpolator(new LinearInterpolator());
        this.f18040bz.setDuration(12000L);
        this.f18040bz.addListener(new Animator.AnimatorListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.11
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                MainShutterButton.this.m18858B();
                MainShutterButton.this.f17993bA.start();
            }
        });
        this.f17993bA = ObjectAnimator.ofInt(this, this.f18038bx, 0, 60);
        this.f17993bA.setInterpolator(new PathInterpolator(0.576f, 0.16f, 0.421f, 0.853f));
        this.f17993bA.addListener(new Animator.AnimatorListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.13
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                MainShutterButton.this.f17930M = 0;
                MainShutterButton.this.f17924G = 0;
                if (6 == MainShutterButton.this.f18041x && "button_shape_dial_rotate".equals(MainShutterButton.this.f17950aJ)) {
                    MainShutterButton.this.setButtonType(1);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m18877a(ValueAnimator valueAnimator) {
        this.f17992az = ((Integer) valueAnimator.getAnimatedValue()).intValue();
    }

    /* renamed from: z */
    private void m18941z() {
        this.f18013bU = new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.14
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                MainShutterButton.this.f17941aA = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                float COUIBaseListPopupWindow_12 = MainShutterButton.this.f17941aA - MainShutterButton.this.f17918A;
                if (MainShutterButton.this.f18018bd == null) {
                    float f2 = COUIBaseListPopupWindow_12 / 2.0f;
                    MainShutterButton.this.f18018bd = new RectF(((r0.getWidth() / 2) - MainShutterButton.this.f17941aA) + f2, ((MainShutterButton.this.getHeight() / 2) - MainShutterButton.this.f17941aA) + f2, ((MainShutterButton.this.getWidth() / 2) + MainShutterButton.this.f17941aA) - f2, ((MainShutterButton.this.getWidth() / 2) + MainShutterButton.this.f17941aA) - f2);
                } else {
                    float f3 = COUIBaseListPopupWindow_12 / 2.0f;
                    MainShutterButton.this.f18018bd.set(((MainShutterButton.this.getWidth() / 2) - MainShutterButton.this.f17941aA) + f3, ((MainShutterButton.this.getHeight() / 2) - MainShutterButton.this.f17941aA) + f3, ((MainShutterButton.this.getWidth() / 2) + MainShutterButton.this.f17941aA) - f3, ((MainShutterButton.this.getWidth() / 2) + MainShutterButton.this.f17941aA) - f3);
                }
                MainShutterButton.this.f18027bm.setStrokeWidth(COUIBaseListPopupWindow_12);
                MainShutterButton.this.f17932O = COUIBaseListPopupWindow_12;
                if (MainShutterButton.this.f18022bh != null) {
                    MainShutterButton.this.f18022bh.setStrokeWidth(COUIBaseListPopupWindow_12);
                }
                MainShutterButton.this.invalidate();
            }
        };
        this.f17997bE = ValueAnimator.ofFloat(this.f18043z, this.f17931N);
        this.f17997bE.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.66f, 1.0f));
        this.f17997bE.setDuration(100L);
        this.f17997bE.addUpdateListener(this.f18013bU);
        this.f17998bF = ValueAnimator.ofFloat(this.f17931N, this.f18043z);
        this.f17998bF.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.66f, 1.0f));
        this.f17998bF.setDuration(100L);
        this.f17998bF.addUpdateListener(this.f18013bU);
    }

    /* renamed from: A */
    private void m18857A() {
        this.f18001bI = ValueAnimator.ofInt(0, 255);
        this.f18001bI.setInterpolator(AnimationUtils.loadInterpolator(getContext(), R.anim.accelerate_decelerate_path_interpolator));
        this.f18001bI.setDuration(440L);
        this.f18001bI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.15
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                MainShutterButton.this.f17980an = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                MainShutterButton.this.invalidate();
            }
        });
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m18948c() {
        if (this.f18001bI == null) {
            m18857A();
        }
        ValueAnimator valueAnimator = this.f18001bI;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public void m18858B() {
        this.f17993bA.setIntValues(this.f17930M, 120);
        this.f17993bA.setDuration(((120 - this.f17930M) * 800) / 120);
    }

    /* renamed from: C */
    private void m18859C() {
        this.f18039by = null;
        this.f18040bz = null;
        this.f17993bA = null;
        this.f17994bB = null;
        this.f17997bE = null;
        this.f17998bF = null;
        this.f18010bR = null;
        ValueAnimator valueAnimator = this.f17999bG;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f17999bG = null;
        }
        ValueAnimator valueAnimator2 = this.f18000bH;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.f18000bH = null;
        }
        ValueAnimator valueAnimator3 = this.f18001bI;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
            this.f18001bI = null;
        }
        ValueAnimator valueAnimator4 = this.f17960aT;
        if (valueAnimator4 != null) {
            valueAnimator4.cancel();
            this.f17960aT = null;
        }
    }

    public int getDialValue() {
        return this.f17930M;
    }

    public void setDialValue(int OplusGLSurfaceView_13) {
        this.f17930M = OplusGLSurfaceView_13;
        invalidate();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m18949d() {
        ObjectAnimator objectAnimator = this.f18039by;
        if (objectAnimator != null) {
            objectAnimator.start();
        }
    }

    /* renamed from: D */
    private void m18860D() {
        if (this.f17994bB != null) {
            long OplusGLSurfaceView_15 = Util.m24352ao() ? (long) (this.f17981ao + 133.36f) : 133L;
            this.f17981ao = 0;
            this.f17994bB.setDuration(Math.max(0L, this.f17929L - OplusGLSurfaceView_15));
            this.f17994bB.start();
        }
        ValueAnimator valueAnimator = this.f17995bC;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    /* renamed from: E */
    private void m18861E() {
        ValueAnimator valueAnimator = this.f17996bD;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    /* renamed from: F */
    private void m18862F() {
        ValueAnimator valueAnimator = this.f17959aS;
        if (valueAnimator != null) {
            valueAnimator.setCurrentFraction(valueAnimator.getAnimatedFraction());
            this.f17959aS.start();
        }
        if (this.f17960aT != null) {
            float COUIBaseListPopupWindow_12 = this.f17953aM ? this.f17927J : 360.0f;
            float f2 = this.f17953aM ? 360.0f : this.f17927J;
            this.f17960aT.setRepeatCount(!this.f17953aM ? 1 : 0);
            this.f17960aT.setFloatValues(COUIBaseListPopupWindow_12, f2);
            this.f17960aT.setCurrentFraction(m18871a(this.f17960aT.getInterpolator(), this.f17944aD, COUIBaseListPopupWindow_12, f2));
            this.f17960aT.start();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private float m18871a(TimeInterpolator timeInterpolator, float COUIBaseListPopupWindow_12, float f2, float f3) {
        if (timeInterpolator == null) {
            return 0.0f;
        }
        float f4 = f3 - f2;
        float f5 = Float.MAX_VALUE;
        float f6 = 0.0f;
        for (float f7 = 0.0f; f7 < 1.0f; f7 += 0.02f) {
            float fAbs = Math.abs(COUIBaseListPopupWindow_12 - ((timeInterpolator.getInterpolation(f7) * f4) + f2));
            if (fAbs < f5) {
                f6 = f7;
                f5 = fAbs;
            }
        }
        return f6;
    }

    /* renamed from: G */
    private void m18863G() {
        ValueAnimator valueAnimator = this.f18010bR;
        if (valueAnimator != null) {
            valueAnimator.setDuration(this.f17929L);
            this.f18010bR.start();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m18950e() {
        CameraLog.m12954a("MainShutterButton", "pauseFastVideoDialAnimator");
        ObjectAnimator objectAnimator = this.f18040bz;
        if (objectAnimator == null || !objectAnimator.isRunning()) {
            return;
        }
        this.f18040bz.pause();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m18951f() {
        ValueAnimator valueAnimator = this.f17994bB;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f17994bB.resume();
        }
        ValueAnimator valueAnimator2 = this.f17995bC;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            return;
        }
        this.f17995bC.resume();
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m18952g() {
        ValueAnimator valueAnimator = this.f17994bB;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f17994bB.pause();
        }
        ValueAnimator valueAnimator2 = this.f17995bC;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            return;
        }
        this.f17995bC.pause();
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m18953h() {
        CameraLog.m12954a("MainShutterButton", "resumeFastVideoDialAnimator");
        ObjectAnimator objectAnimator = this.f18040bz;
        if (objectAnimator != null) {
            objectAnimator.resume();
        }
    }

    public void setShutterButtonTime(int OplusGLSurfaceView_13) {
        this.f17929L = OplusGLSurfaceView_13;
    }

    public void setShutterButtonProgress(float COUIBaseListPopupWindow_12) {
        if (this.f18041x != 12) {
            CameraLog.m12967f("MainShutterButton", "setShutterButtonProgress, button type is error, mButtonType: " + this.f18041x);
            return;
        }
        CameraLog.m12954a("MainShutterButton", "setShutterButtonProgress, progress: " + COUIBaseListPopupWindow_12);
        this.f17977ak = (int) (COUIBaseListPopupWindow_12 * 360.0f);
        if (this.f17977ak > 360) {
            this.f17977ak = 360;
        }
        invalidate();
    }

    /* renamed from: H */
    private void m18864H() {
        if (this.f18002bJ == null) {
            this.f18002bJ = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f18002bJ.setDuration(300L);
            this.f18002bJ.setInterpolator(new PathInterpolator(0.17f, 0.0f, 0.83f, 1.0f));
            this.f18002bJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.16
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    MainShutterButton.this.f17946aF = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    MainShutterButton.this.invalidate();
                }
            });
            this.f18002bJ.addListener(new Animator.AnimatorListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.17
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    MainShutterButton.this.setButtonTypeAndInvalidate(20);
                }
            });
        }
        this.f18002bJ.start();
    }

    /* renamed from: I */
    private void m18865I() {
        if (this.f18004bL == null) {
            this.f18004bL = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f18004bL.setDuration(300L);
            this.f18004bL.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f));
            this.f18004bL.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.18
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    MainShutterButton.this.f17946aF = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    MainShutterButton.this.invalidate();
                }
            });
            this.f18004bL.addListener(new Animator.AnimatorListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.19
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    MainShutterButton.this.setButtonTypeAndInvalidate(1);
                }
            });
        }
        this.f18004bL.start();
    }

    /* renamed from: J */
    private void m18866J() {
        if (this.f18005bM == null) {
            this.f18005bM = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f18005bM.setDuration(300L);
            this.f18005bM.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f));
            this.f18005bM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.20
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    MainShutterButton.this.f17946aF = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    MainShutterButton.this.invalidate();
                }
            });
            this.f18005bM.addListener(new Animator.AnimatorListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.21
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    MainShutterButton.this.setButtonTypeAndInvalidate(1);
                }
            });
        }
        this.f18005bM.start();
    }

    /* renamed from: K */
    private void m18867K() {
        if (this.f18003bK == null) {
            this.f18003bK = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f18003bK.setDuration(300L);
            this.f18003bK.setInterpolator(new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f));
            this.f18003bK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.22
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    MainShutterButton.this.f17946aF = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    MainShutterButton.this.invalidate();
                }
            });
            this.f18003bK.addListener(new Animator.AnimatorListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.24
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    MainShutterButton.this.setButtonTypeAndInvalidate(21);
                }
            });
        }
        this.f18003bK.start();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m18902d(boolean z, boolean z2) {
        CameraLog.m12954a("MainShutterButton", "startInsideRedAnimator, show: " + z + ", mInsideRedScaleValue: " + this.f17947aG + ", mInsideRedAlphaValue: " + this.f17948aH + ", needAnimation: " + z2 + ", visible: " + getVisibility());
        if (getVisibility() != 0 || !z2) {
            this.f17947aG = z ? 1.0f : 0.7f;
            this.f17948aH = z ? 1.0f : 0.0f;
            return;
        }
        ValueAnimator valueAnimator = this.f18006bN;
        if (valueAnimator == null) {
            this.f18006bN = new ValueAnimator();
            this.f18006bN.setInterpolator(new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f));
            this.f18006bN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.25
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    MainShutterButton.this.f17947aG = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    MainShutterButton.this.invalidate();
                }
            });
        } else {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.f18007bO;
        if (valueAnimator2 == null) {
            this.f18007bO = new ValueAnimator();
            this.f18007bO.setInterpolator(new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f));
            this.f18007bO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.26
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    MainShutterButton.this.f17948aH = ((Float) valueAnimator3.getAnimatedValue()).floatValue();
                }
            });
        } else {
            valueAnimator2.cancel();
        }
        if (z) {
            this.f18006bN.setFloatValues(this.f17947aG, 1.0f);
            this.f18007bO.setFloatValues(this.f17948aH, 1.0f);
        } else {
            this.f18006bN.setFloatValues(this.f17947aG, 0.7f);
            this.f18007bO.setFloatValues(this.f17948aH, 0.0f);
        }
        this.f18006bN.setDuration(500L);
        this.f18007bO.setDuration(250L);
        this.f18006bN.start();
        this.f18007bO.start();
    }

    /* renamed from: L */
    private void m18868L() {
        ValueAnimator valueAnimator = this.f18008bP;
        if (valueAnimator == null) {
            this.f18008bP = ValueAnimator.ofFloat(this.f18043z, 0.0f);
            this.f18008bP.setInterpolator(new DecelerateInterpolator(1.0f));
            this.f18008bP.setDuration(300L);
            this.f18008bP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.27
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    MainShutterButton.this.f17920C = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    MainShutterButton.this.invalidate();
                }
            });
            this.f18008bP.addListener(new Animator.AnimatorListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.28
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    int OplusGLSurfaceView_13 = MainShutterButton.this.f17956aP ? 29 : 28;
                    MainShutterButton.this.f17956aP = false;
                    if (25 == MainShutterButton.this.f18041x) {
                        MainShutterButton.this.f17981ao = 300;
                        MainShutterButton.this.setButtonTypeAndInvalidate(new MainShutterButtonInfo(OplusGLSurfaceView_13));
                    }
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.f18008bP.start();
    }

    /* renamed from: M */
    private void m18869M() {
        ValueAnimator valueAnimator = this.f18009bQ;
        if (valueAnimator == null) {
            this.f18009bQ = ValueAnimator.ofFloat(0.0f, this.f18043z);
            this.f18009bQ.setInterpolator(new DecelerateInterpolator(1.0f));
            this.f18009bQ.setDuration(300L);
            this.f18009bQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.29
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    MainShutterButton.this.f17920C = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    MainShutterButton.this.invalidate();
                }
            });
            this.f18009bQ.addListener(new Animator.AnimatorListener() { // from class: com.oplus.camera.ui.control.MainShutterButton.30
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    MainShutterButton.this.setButtonType(26);
                    MainShutterButton.this.invalidate();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    MainShutterButton.this.setButtonType(23);
                    MainShutterButton.this.invalidate();
                }
            });
        } else {
            valueAnimator.cancel();
        }
        this.f18009bQ.start();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m18891b(Canvas canvas, boolean z) {
        canvas.save();
        canvas.translate(getWidth() / 2.0f, getHeight() / 2.0f);
        canvas.rotate(180.0f);
        int OplusGLSurfaceView_13 = 0;
        while (OplusGLSurfaceView_13 < 60) {
            if (!z) {
                int i2 = this.f17919B;
                int i3 = this.f17985as;
                canvas.drawLine(0.0f, i2 + i3, 0.0f, i2 + i3 + this.f17982ap, this.f18028bn);
            } else if (OplusGLSurfaceView_13 % 5 == 0) {
                int i4 = this.f17919B;
                int i5 = this.f17988av;
                canvas.drawLine(0.0f, i4 + i5, 0.0f, i4 + i5 + this.f17986at, this.f18028bn);
            } else {
                int i6 = this.f17930M;
                if (i6 <= 60 || i6 == 0) {
                    int i7 = OplusGLSurfaceView_13 == this.f17930M ? this.f17988av : this.f17983aq;
                    int i8 = OplusGLSurfaceView_13 == this.f17930M ? this.f17986at : this.f17982ap;
                    if (OplusGLSurfaceView_13 >= this.f17930M) {
                        int i9 = this.f17919B;
                        canvas.drawLine(0.0f, i9 + i7, 0.0f, i9 + i7 + i8, this.f18028bn);
                    }
                } else {
                    int i10 = OplusGLSurfaceView_13 == i6 + (-60) ? this.f17988av : this.f17983aq;
                    int i11 = OplusGLSurfaceView_13 == this.f17930M - 60 ? this.f17986at : this.f17982ap;
                    int i12 = this.f17930M;
                    if (OplusGLSurfaceView_13 <= i12 - 60 || i12 == 0) {
                        int i13 = this.f17919B;
                        canvas.drawLine(0.0f, i13 + i10, 0.0f, i13 + i10 + i11, this.f18028bn);
                    }
                }
            }
            canvas.rotate(6.0f, 0.0f, 0.0f);
            OplusGLSurfaceView_13++;
        }
        canvas.restore();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m18878a(Canvas canvas) {
        if ("button_shape_ring_none".equals(this.f17950aJ)) {
            return;
        }
        int OplusGLSurfaceView_13 = this.f18041x;
        if (OplusGLSurfaceView_13 != 9) {
            if (OplusGLSurfaceView_13 != 24) {
                if (OplusGLSurfaceView_13 != 31) {
                    switch (OplusGLSurfaceView_13) {
                        case 6:
                            if ("button_shape_dial_still".equals(this.f17950aJ)) {
                                this.f17954aN = false;
                                m18891b(canvas, this.f17954aN);
                                break;
                            } else if ("button_shape_dial_rotate".equals(this.f17950aJ)) {
                                ObjectAnimator objectAnimator = this.f18040bz;
                                if (objectAnimator != null && objectAnimator.isRunning()) {
                                    this.f18040bz.cancel();
                                }
                                this.f17954aN = true;
                                m18891b(canvas, this.f17954aN);
                                break;
                            }
                            break;
                    }
                    return;
                }
                if ("button_shape_dial_still".equals(this.f17950aJ)) {
                    this.f17954aN = false;
                    m18891b(canvas, this.f17954aN);
                    return;
                }
                return;
            }
            Bitmap bitmap = this.f18015ba;
            if (bitmap == null) {
                this.f18015ba = m18874a(bitmap, R.drawable.countdown_cancel_button, 0.35f);
            }
            m18890b(canvas, this.f18015ba);
            return;
        }
        if ("button_shape_dial_still".equals(this.f17950aJ)) {
            this.f17954aN = false;
            m18891b(canvas, this.f17954aN);
            return;
        }
        if ("button_shape_dial_rotate".equals(this.f17950aJ)) {
            this.f17954aN = true;
            m18891b(canvas, this.f17954aN);
            return;
        }
        if ("button_shape_countdown_ten_seconds".equals(this.f17950aJ)) {
            Bitmap bitmap2 = this.f17963aW;
            if (bitmap2 == null) {
                this.f17963aW = m18873a(bitmap2, R.drawable.countdown_10s_selector);
            }
            m18879a(canvas, this.f17963aW);
            return;
        }
        if ("button_shape_countdown_three_seconds".equals(this.f17950aJ)) {
            Bitmap bitmap3 = this.f17962aV;
            if (bitmap3 == null) {
                this.f17962aV = m18873a(bitmap3, R.drawable.countdown_3s_selector);
            }
            m18879a(canvas, this.f17962aV);
            return;
        }
        if ("button_shape_next_step".equals(this.f17950aJ)) {
            Bitmap bitmap4 = this.f17964aX;
            if (bitmap4 == null) {
                this.f17964aX = m18873a(bitmap4, R.drawable.ic_next_step);
            }
            m18896c(canvas, this.f17964aX);
            return;
        }
        if ("button_shape_complete".equals(this.f17950aJ)) {
            Bitmap bitmap5 = this.f17965aY;
            if (bitmap5 == null) {
                this.f17965aY = m18873a(bitmap5, R.drawable.ic_complete);
            }
            m18896c(canvas, this.f17965aY);
        }
    }

    public int getShutterPadding() {
        return (getMeasuredHeight() / 2) - this.f18043z;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Shader m18905e(int OplusGLSurfaceView_13, int i2) {
        return new LinearGradient(0.0f, 0.0f, 0.0f, getHeight() * 1.0f, OplusGLSurfaceView_13, i2, Shader.TileMode.CLAMP);
    }
}
