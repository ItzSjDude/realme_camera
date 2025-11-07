package com.oplus.camera.p172ui.preview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.animation.AnimationUtils;
import android.view.animation.PathInterpolator;
import androidx.core.p027a.p028a.ResourcesCompat;
import com.oplus.camera.ZoomManager;
import com.oplus.camera.ZoomUnit;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.p172ui.CameraSeekBar;
import com.oplus.camera.p172ui.BackgroundSplitManager;
import com.oplus.camera.p172ui.inverse.InverseAble;
import com.oplus.camera.screen.ScreenModeManager;
import com.oplus.camera.util.Util;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ZoomSeekBar.java */
/* renamed from: com.oplus.camera.ui.preview.ai */
/* loaded from: classes2.dex */
public abstract class ZoomSeekBar extends CameraSeekBar implements BackgroundSplitManager.PlatformImplementations.kt_3, InverseAble {

    /* renamed from: ao */
    protected static final int f21698ao = (int) (Util.getScreenWidth() * 0.104f);

    /* renamed from: di */
    private static final PathInterpolator f21699di = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);

    /* renamed from: aA */
    protected boolean f21700aA;

    /* renamed from: aB */
    protected boolean f21701aB;

    /* renamed from: aC */
    protected int f21702aC;

    /* renamed from: aD */
    protected int f21703aD;

    /* renamed from: aE */
    protected int f21704aE;

    /* renamed from: aF */
    protected int f21705aF;

    /* renamed from: aG */
    protected int f21706aG;

    /* renamed from: aH */
    protected int f21707aH;

    /* renamed from: aI */
    protected int f21708aI;

    /* renamed from: aJ */
    protected int f21709aJ;

    /* renamed from: aK */
    protected int f21710aK;

    /* renamed from: aL */
    protected int f21711aL;

    /* renamed from: aM */
    protected int f21712aM;

    /* renamed from: aN */
    protected int f21713aN;

    /* renamed from: aO */
    protected int f21714aO;

    /* renamed from: aP */
    protected int f21715aP;

    /* renamed from: aQ */
    protected int f21716aQ;

    /* renamed from: aR */
    protected float f21717aR;

    /* renamed from: aS */
    protected float f21718aS;

    /* renamed from: aT */
    protected int f21719aT;

    /* renamed from: aU */
    protected int f21720aU;

    /* renamed from: aV */
    protected int f21721aV;

    /* renamed from: aW */
    protected int f21722aW;

    /* renamed from: aX */
    protected int f21723aX;

    /* renamed from: aY */
    protected int f21724aY;

    /* renamed from: aZ */
    protected float f21725aZ;

    /* renamed from: ap */
    protected VelocityTracker f21726ap;

    /* renamed from: aq */
    protected int f21727aq;

    /* renamed from: ar */
    protected int f21728ar;

    /* renamed from: as */
    protected int f21729as;

    /* renamed from: at */
    protected float f21730at;

    /* renamed from: au */
    protected float f21731au;

    /* renamed from: av */
    protected float f21732av;

    /* renamed from: aw */
    protected Context f21733aw;

    /* renamed from: ax */
    protected Resources f21734ax;

    /* renamed from: ay */
    protected boolean f21735ay;

    /* renamed from: az */
    protected boolean f21736az;

    /* renamed from: bA */
    protected Paint f21737bA;

    /* renamed from: bB */
    protected Paint f21738bB;

    /* renamed from: bC */
    protected int f21739bC;

    /* renamed from: bD */
    protected Paint f21740bD;

    /* renamed from: bE */
    protected int f21741bE;

    /* renamed from: bF */
    protected Paint f21742bF;

    /* renamed from: bG */
    protected Paint f21743bG;

    /* renamed from: bH */
    protected Paint f21744bH;

    /* renamed from: bI */
    protected TextPaint f21745bI;

    /* renamed from: bJ */
    protected int f21746bJ;

    /* renamed from: bK */
    protected ArrayList<Float> f21747bK;

    /* renamed from: bL */
    protected float[] f21748bL;

    /* renamed from: bM */
    protected int f21749bM;

    /* renamed from: bN */
    protected GestureDetector f21750bN;

    /* renamed from: bO */
    protected ZoomListener f21751bO;

    /* renamed from: bP */
    protected ZoomUnit f21752bP;

    /* renamed from: bQ */
    protected Paint f21753bQ;

    /* renamed from: bR */
    protected Paint f21754bR;

    /* renamed from: bS */
    protected Paint f21755bS;

    /* renamed from: bT */
    protected boolean f21756bT;

    /* renamed from: bU */
    protected int f21757bU;

    /* renamed from: bV */
    protected int f21758bV;

    /* renamed from: bW */
    protected int f21759bW;

    /* renamed from: bX */
    protected int f21760bX;

    /* renamed from: bY */
    protected int f21761bY;

    /* renamed from: bZ */
    protected int f21762bZ;

    /* renamed from: ba */
    protected float f21763ba;

    /* renamed from: bb */
    protected int f21764bb;

    /* renamed from: bc */
    protected int f21765bc;

    /* renamed from: bd */
    protected int f21766bd;

    /* renamed from: be */
    protected float f21767be;

    /* renamed from: bf */
    protected float f21768bf;

    /* renamed from: bg_renamed */
    protected boolean f21769bg;

    /* renamed from: bh */
    protected boolean f21770bh;

    /* renamed from: bi */
    protected boolean f21771bi;

    /* renamed from: bj */
    protected boolean f21772bj;

    /* renamed from: bk */
    protected boolean f21773bk;

    /* renamed from: bl */
    protected boolean f21774bl;

    /* renamed from: bm */
    protected boolean f21775bm;

    /* renamed from: bn */
    protected boolean f21776bn;

    /* renamed from: bo */
    protected boolean f21777bo;

    /* renamed from: bp */
    protected boolean f21778bp;

    /* renamed from: bq */
    protected int f21779bq;

    /* renamed from: br */
    protected String f21780br;

    /* renamed from: bs */
    protected float f21781bs;

    /* renamed from: bt */
    protected float f21782bt;

    /* renamed from: bu */
    protected float f21783bu;

    /* renamed from: bv */
    protected ArrayList<Float> f21784bv;

    /* renamed from: bw */
    protected ArrayList<Float> f21785bw;

    /* renamed from: bx */
    protected ArrayList<Float> f21786bx;

    /* renamed from: by */
    protected ArrayList<Integer> f21787by;

    /* renamed from: bz */
    protected Paint f21788bz;

    /* renamed from: cA */
    protected float f21789cA;

    /* renamed from: cB */
    protected float f21790cB;

    /* renamed from: cC */
    protected float f21791cC;

    /* renamed from: cD */
    protected float f21792cD;

    /* renamed from: cE */
    protected ArrayList<Float> f21793cE;

    /* renamed from: cF */
    protected Bitmap f21794cF;

    /* renamed from: cG */
    protected Bitmap f21795cG;

    /* renamed from: cH */
    protected Canvas f21796cH;

    /* renamed from: cI */
    protected Canvas f21797cI;

    /* renamed from: cJ */
    protected DecimalFormat f21798cJ;

    /* renamed from: cK */
    protected DecimalFormat f21799cK;

    /* renamed from: cL */
    protected float f21800cL;

    /* renamed from: cM */
    protected float f21801cM;

    /* renamed from: cN */
    protected float f21802cN;

    /* renamed from: cO */
    protected float f21803cO;

    /* renamed from: cP */
    protected float f21804cP;

    /* renamed from: cQ */
    protected float f21805cQ;

    /* renamed from: cR */
    protected float f21806cR;

    /* renamed from: cS */
    protected boolean f21807cS;

    /* renamed from: cT */
    protected boolean f21808cT;

    /* renamed from: cU */
    protected int f21809cU;

    /* renamed from: cV */
    protected String f21810cV;

    /* renamed from: cW */
    protected String f21811cW;

    /* renamed from: cX */
    protected String f21812cX;

    /* renamed from: cY */
    protected String f21813cY;

    /* renamed from: cZ */
    protected float f21814cZ;

    /* renamed from: ca */
    protected int f21815ca;

    /* renamed from: cb */
    protected RectF f21816cb;

    /* renamed from: cc */
    protected RectF f21817cc;

    /* renamed from: cd */
    protected Map<IntrinsicsJvm.kt_4, Bitmap> f21818cd;

    /* renamed from: ce */
    protected Map<IntrinsicsJvm.kt_4, Bitmap> f21819ce;

    /* renamed from: cf */
    protected float f21820cf;

    /* renamed from: cg */
    protected float f21821cg;

    /* renamed from: ch */
    protected float f21822ch;

    /* renamed from: ci */
    protected float f21823ci;

    /* renamed from: cj */
    protected float f21824cj;

    /* renamed from: ck */
    protected float f21825ck;

    /* renamed from: cl */
    protected float f21826cl;

    /* renamed from: cm */
    protected float f21827cm;

    /* renamed from: cn */
    protected float f21828cn;

    /* renamed from: co */
    protected float f21829co;

    /* renamed from: cp */
    protected float f21830cp;

    /* renamed from: cq */
    protected float f21831cq;

    /* renamed from: cr */
    protected boolean f21832cr;

    /* renamed from: cs */
    protected int f21833cs;

    /* renamed from: ct */
    protected int f21834ct;

    /* renamed from: cu */
    protected float f21835cu;

    /* renamed from: cv */
    protected float f21836cv;

    /* renamed from: cw */
    protected int f21837cw;

    /* renamed from: cx */
    protected int f21838cx;

    /* renamed from: cy */
    protected int f21839cy;

    /* renamed from: cz */
    protected float f21840cz;

    /* renamed from: dA */
    private int f21841dA;

    /* renamed from: dB */
    private int f21842dB;

    /* renamed from: dC */
    private PlatformImplementations.kt_3 f21843dC;

    /* renamed from: dD */
    private PlatformImplementations.kt_3 f21844dD;

    /* renamed from: dE */
    private PlatformImplementations.kt_3 f21845dE;

    /* renamed from: dF */
    private float f21846dF;

    /* renamed from: dG */
    private float f21847dG;

    /* renamed from: dH */
    private int f21848dH;

    /* renamed from: dI */
    private float f21849dI;

    /* renamed from: dJ */
    private int f21850dJ;

    /* renamed from: dK */
    private float f21851dK;

    /* renamed from: dL */
    private boolean f21852dL;

    /* renamed from: dM */
    private int f21853dM;

    /* renamed from: dN */
    private PathInterpolator f21854dN;

    /* renamed from: dO */
    private PathInterpolator f21855dO;

    /* renamed from: da */
    protected float f21856da;

    /* renamed from: db */
    protected float f21857db;

    /* renamed from: dc */
    protected float f21858dc;

    /* renamed from: dd */
    protected float f21859dd;

    /* renamed from: de */
    protected float f21860de;

    /* renamed from: df */
    protected AnimatorSet f21861df;

    /* renamed from: dg */
    protected boolean f21862dg;

    /* renamed from: dh */
    protected ScreenModeManager f21863dh;

    /* renamed from: dj */
    private boolean f21864dj;

    /* renamed from: dk */
    private int f21865dk;

    /* renamed from: dl */
    private Path f21866dl;

    /* renamed from: dm */
    private float f21867dm;

    /* renamed from: dn */
    private int f21868dn;

    /* renamed from: do */
    private long f21869do;

    /* renamed from: dp */
    private long f21870dp;

    /* renamed from: dq */
    private int f21871dq;

    /* renamed from: dr */
    private int f21872dr;

    /* renamed from: ds */
    private int[] f21873ds;

    /* renamed from: dt */
    private AnimatorSet f21874dt;

    /* renamed from: du */
    private boolean f21875du;

    /* renamed from: dv */
    private int f21876dv;

    /* renamed from: dw */
    private ValueAnimator f21877dw;

    /* renamed from: dx */
    private ArrayList<Float> f21878dx;

    /* renamed from: dy */
    private ValueAnimator f21879dy;

    /* renamed from: dz */
    private int f21880dz;

    /* compiled from: ZoomSeekBar.java */
    /* renamed from: com.oplus.camera.ui.preview.ai$PlatformImplementations.kt_3 */
    public enum PlatformImplementations.kt_3 {
        NORMAL,
        ICON_ONLY
    }

    /* compiled from: ZoomSeekBar.java */
    /* renamed from: com.oplus.camera.ui.preview.ai$IntrinsicsJvm.kt_4 */
    protected enum IntrinsicsJvm.kt_4 {
        ULTRA_WIDE,
        WIDE,
        TELE
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected abstract float mo23073a(float COUIBaseListPopupWindow_12, VelocityTracker velocityTracker);

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract String mo23075a(float COUIBaseListPopupWindow_12, float f2);

    /* renamed from: PlatformImplementations.kt_3 */
    protected boolean mo23078a(MotionEvent motionEvent) {
        return true;
    }

    public abstract int getLayoutHeight();

    public abstract int getType();

    public ZoomSeekBar(Context context) {
        super(context, null);
        this.f21726ap = null;
        this.f21727aq = 0;
        this.f21728ar = 0;
        this.f21729as = 0;
        this.f21730at = 0.0f;
        this.f21731au = 0.0f;
        this.f21732av = 0.0f;
        this.f21733aw = null;
        this.f21734ax = null;
        this.f21735ay = true;
        this.f21736az = true;
        this.f21700aA = true;
        this.f21701aB = true;
        this.f21702aC = 0;
        this.f21703aD = 0;
        this.f21704aE = 0;
        this.f21705aF = 0;
        this.f21706aG = 0;
        this.f21707aH = 0;
        this.f21708aI = 0;
        this.f21709aJ = 0;
        this.f21710aK = 0;
        this.f21711aL = 0;
        this.f21712aM = 0;
        this.f21713aN = 0;
        this.f21714aO = 0;
        this.f21715aP = 0;
        this.f21716aQ = 0;
        this.f21717aR = 0.0f;
        this.f21718aS = 0.0f;
        this.f21719aT = 0;
        this.f21720aU = 0;
        this.f21721aV = 0;
        this.f21722aW = 0;
        this.f21723aX = 0;
        this.f21724aY = 0;
        this.f21725aZ = 0.0f;
        this.f21763ba = 0.0f;
        this.f21764bb = 0;
        this.f21765bc = 0;
        this.f21766bd = 0;
        this.f21767be = 0.0f;
        this.f21768bf = 0.0f;
        this.f21769bg = false;
        this.f21770bh = false;
        this.f21771bi = false;
        this.f21772bj = false;
        this.f21773bk = false;
        this.f21774bl = false;
        this.f21775bm = false;
        this.f21776bn = false;
        this.f21777bo = false;
        this.f21778bp = false;
        this.f21779bq = 8;
        this.f21780br = null;
        this.f21781bs = 0.0f;
        this.f21782bt = 0.0f;
        this.f21783bu = 0.0f;
        this.f21784bv = null;
        this.f21785bw = null;
        this.f21786bx = null;
        this.f21787by = null;
        this.f21788bz = null;
        this.f21737bA = null;
        this.f21738bB = null;
        this.f21739bC = 0;
        this.f21740bD = null;
        this.f21741bE = 0;
        this.f21742bF = null;
        this.f21743bG = null;
        this.f21744bH = null;
        this.f21745bI = null;
        this.f21746bJ = 0;
        this.f21747bK = null;
        this.f21748bL = null;
        this.f21749bM = 1;
        this.f21750bN = null;
        this.f21751bO = null;
        this.f21752bP = null;
        this.f21753bQ = null;
        this.f21754bR = null;
        this.f21755bS = null;
        this.f21756bT = false;
        this.f21757bU = 0;
        this.f21758bV = 0;
        this.f21759bW = 0;
        this.f21760bX = 0;
        this.f21761bY = 0;
        this.f21762bZ = 0;
        this.f21815ca = 0;
        this.f21816cb = new RectF();
        this.f21817cc = new RectF();
        this.f21818cd = new HashMap();
        this.f21819ce = new HashMap();
        this.f21820cf = 0.0f;
        this.f21821cg = 1.0f;
        this.f21822ch = 0.0f;
        this.f21823ci = 0.0f;
        this.f21824cj = 0.0f;
        this.f21825ck = 0.0f;
        this.f21826cl = 0.0f;
        this.f21827cm = 0.0f;
        this.f21828cn = 0.0f;
        this.f21829co = 0.0f;
        this.f21830cp = 0.0f;
        this.f21831cq = 0.0f;
        this.f21832cr = false;
        this.f21833cs = 0;
        this.f21834ct = 0;
        this.f21835cu = 0.0f;
        this.f21836cv = 0.0f;
        this.f21837cw = 2;
        this.f21838cx = 2;
        this.f21839cy = 2;
        this.f21840cz = -1.0f;
        this.f21789cA = -1.0f;
        this.f21790cB = -1.0f;
        this.f21791cC = -1.0f;
        this.f21792cD = -1.0f;
        this.f21793cE = null;
        this.f21794cF = null;
        this.f21795cG = null;
        this.f21796cH = null;
        this.f21797cI = null;
        this.f21798cJ = null;
        this.f21799cK = null;
        this.f21800cL = 0.0f;
        this.f21801cM = 0.0f;
        this.f21802cN = 0.0f;
        this.f21803cO = 0.0f;
        this.f21804cP = 0.0f;
        this.f21805cQ = 0.0f;
        this.f21806cR = 0.31f;
        this.f21807cS = false;
        this.f21808cT = false;
        this.f21809cU = 0;
        this.f21810cV = "";
        this.f21811cW = "";
        this.f21812cX = "";
        this.f21813cY = "";
        this.f21814cZ = 0.0f;
        this.f21856da = -1.0f;
        this.f21857db = -1.0f;
        this.f21858dc = -1.0f;
        this.f21859dd = -1.0f;
        this.f21860de = 0.0f;
        this.f21861df = null;
        this.f21862dg = false;
        this.f21863dh = null;
        this.f21864dj = false;
        this.f21865dk = -1;
        this.f21866dl = null;
        this.f21867dm = 0.0f;
        this.f21868dn = 200;
        this.f21869do = 0L;
        this.f21870dp = 0L;
        this.f21871dq = 0;
        this.f21872dr = 0;
        this.f21873ds = null;
        this.f21875du = true;
        this.f21880dz = 0;
        this.f21841dA = 0;
        this.f21842dB = 0;
        this.f21843dC = PlatformImplementations.kt_3.NORMAL;
        this.f21844dD = PlatformImplementations.kt_3.NORMAL;
        this.f21845dE = PlatformImplementations.kt_3.NORMAL;
        this.f21846dF = 0.0f;
        this.f21847dG = 0.0f;
        this.f21848dH = 0;
        this.f21849dI = 0.0f;
        this.f21850dJ = 0;
        this.f21851dK = 0.0f;
        this.f21852dL = false;
        this.f21853dM = 0;
        this.f21854dN = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.f21855dO = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f21733aw = context;
        this.f21734ax = this.f21733aw.getResources();
        m23126u();
        setForceDarkAllowed(false);
        this.f21775bm = CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FRONT_CAMERA_AUTO_ZOOM);
    }

    /* renamed from: u */
    private void m23126u() {
        float COUIBaseListPopupWindow_12 = this.f21734ax.getDisplayMetrics().density;
        this.f21728ar = (int) (400.0f * COUIBaseListPopupWindow_12);
        this.f21729as = (int) (this.f21728ar * 10.0f);
        this.f21727aq = (int) (COUIBaseListPopupWindow_12 * 20.0f);
        this.f21752bP = new ZoomUnit();
        m23080E();
        this.f21866dl = new Path();
        this.f21763ba = 0.0f;
        this.f21846dF = this.f21734ax.getDimensionPixelSize(R.dimen.zoom_seekbar_switch_bar_radius) * 0.7f;
        m23086K();
        this.f21769bg = false;
        this.f21798cJ = new DecimalFormat("#.#");
        this.f21799cK = new DecimalFormat("0.0");
        this.f21871dq = this.f21734ax.getDimensionPixelSize(R.dimen.zoom_click_hotspot_width_offset);
        this.f21872dr = this.f21734ax.getDimensionPixelSize(R.dimen.zoom_hotspot_height);
        this.f21706aG = this.f21734ax.getDimensionPixelSize(R.dimen.zoom_click_point_radius);
        this.f21707aH = this.f21734ax.getDimensionPixelSize(R.dimen.zoom_click_point_gap);
        this.f21708aI = this.f21734ax.getDimensionPixelSize(R.dimen.zoom_click_point_shadow_radius);
        this.f21704aE = this.f21734ax.getDimensionPixelSize(R.dimen.zoom_focus_circle_stroke_width);
        this.f21705aF = this.f21734ax.getDimensionPixelSize(R.dimen.zoom_focus_circle_width) / 2;
        this.f21702aC = this.f21705aF - this.f21704aE;
        this.f21703aD = this.f21734ax.getDimensionPixelSize(R.dimen.zoom_focus_circle_radius_pressed);
        this.f21709aJ = this.f21734ax.getDimensionPixelSize(R.dimen.zoom_focus_text_size_normal);
        this.f21710aK = this.f21734ax.getDimensionPixelSize(R.dimen.zoom_focus_text_size_pressed);
        this.f21712aM = this.f21734ax.getDimensionPixelSize(R.dimen.zoom_current_text_move_distance_max);
        this.f21762bZ = this.f21734ax.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_focus_horizontal_hot_area_offset);
        this.f21815ca = this.f21734ax.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_focus_vertical_hot_area_offset);
        this.f21743bG = new Paint();
        this.f21743bG.setAntiAlias(true);
        this.f21744bH = new Paint();
        this.f21744bH.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.f21788bz = new Paint();
        this.f21788bz.setAntiAlias(true);
        this.f21788bz.setTextSize(this.f21709aJ);
        this.f21788bz.setColor(this.f21734ax.getColor(R.color.zoom_arc_seekbar_switch_bar_oval_stroke_color, null));
        this.f21788bz.setTextAlign(Paint.Align.CENTER);
        this.f21788bz.setTypeface(Util.m24473l(this.f21733aw));
        this.f21738bB = new Paint();
        this.f21738bB.setAntiAlias(true);
        this.f21738bB.setStyle(Paint.Style.FILL);
        this.f21739bC = this.f21734ax.getColor(R.color.zoom_seekbar_focus_circle_bg_color);
        this.f21738bB.setColor(this.f21739bC);
        this.f21740bD = new Paint();
        this.f21740bD.setAntiAlias(true);
        this.f21740bD.setStyle(Paint.Style.STROKE);
        this.f21740bD.setStrokeWidth(this.f21704aE);
        this.f21741bE = this.f21734ax.getColor(R.color.zoom_seekbar_focus_circle_stroke_color);
        this.f21740bD.setColor(this.f21741bE);
        this.f21742bF = new Paint();
        this.f21742bF.setAntiAlias(true);
        this.f21742bF.setStyle(Paint.Style.FILL);
        this.f21742bF.setColor(-1);
        this.f21753bQ = new Paint();
        this.f21753bQ.setAntiAlias(true);
        this.f17544u = new Paint();
        this.f17544u.setAntiAlias(true);
        this.f17545v = new Paint();
        this.f17545v.setAntiAlias(true);
        this.f17546w = new Paint();
        this.f17546w.setAntiAlias(true);
        this.f17547x = new Paint();
        this.f17547x.setAntiAlias(true);
        this.f17548y = new Paint();
        this.f17548y.setAntiAlias(true);
        this.f17515aj = new Paint();
        this.f17515aj.setAntiAlias(true);
        this.f17515aj.setTextSize(this.f21709aJ);
        this.f21757bU = this.f21734ax.getColor(R.color.zoom_arc_seekbar_switch_bar_text_color, null);
        this.f17515aj.setColor(this.f21757bU);
        this.f17515aj.setTextAlign(Paint.Align.CENTER);
        this.f17515aj.setTypeface(Util.m24411c(true));
        this.f21754bR = new Paint();
        this.f21754bR.setAntiAlias(true);
        this.f21758bV = this.f21734ax.getColor(R.color.zoom_seekbar_focus_circle_bg_color, null);
        this.f21759bW = this.f21734ax.getColor(R.color.zoom_seekbar_focus_circle_light_bg_color, null);
        this.f21760bX = this.f21758bV;
        this.f21754bR.setColor(this.f21760bX);
        this.f21754bR.setStyle(Paint.Style.FILL);
        this.f21820cf = this.f21734ax.getDimensionPixelSize(R.dimen.zoom_seekbar_switch_bar_radius);
        this.f21822ch = this.f21734ax.getDimensionPixelSize(R.dimen.zoom_seekbar_switch_bar_spacing);
        this.f21755bS = new Paint();
        this.f21755bS.setAntiAlias(true);
        this.f21761bY = this.f21734ax.getColor(R.color.zoom_arc_seekbar_switch_bar_oval_stroke_color, null);
        this.f21755bS.setColor(this.f21761bY);
        this.f21755bS.setStyle(Paint.Style.STROKE);
        this.f21821cg = this.f21734ax.getDimension(R.dimen.zoom_seekbar_oval_stroke_width);
        this.f21755bS.setStrokeWidth(this.f21821cg);
        Bitmap bitmapM23089a = m23089a(this.f21734ax, R.drawable.zoom_seek_bar_ultra_angle);
        Bitmap bitmapM23089a2 = m23089a(this.f21734ax, R.drawable.zoom_seek_bar_normal_len);
        Bitmap bitmapM23089a3 = m23089a(this.f21734ax, R.drawable.zoom_seek_bar_tele);
        if (bitmapM23089a != null) {
            this.f21826cl = bitmapM23089a.getWidth() / 2.0f;
            this.f21827cm = bitmapM23089a.getHeight() / 2.0f;
        }
        if (bitmapM23089a3 != null) {
            this.f21830cp = bitmapM23089a3.getWidth() / 2.0f;
            this.f21831cq = bitmapM23089a3.getHeight() / 2.0f;
        }
        this.f21818cd.put(IntrinsicsJvm.kt_4.ULTRA_WIDE, bitmapM23089a);
        this.f21818cd.put(IntrinsicsJvm.kt_4.WIDE, bitmapM23089a2);
        this.f21818cd.put(IntrinsicsJvm.kt_4.TELE, bitmapM23089a3);
        this.f21823ci = this.f17511af;
        this.f21824cj = (this.f17511af - (this.f21820cf * 2.0f)) - this.f21822ch;
        this.f21825ck = this.f21824cj;
        this.f21828cn = this.f17511af + (this.f21820cf * 2.0f) + this.f21822ch;
        this.f21829co = this.f21828cn;
        if (1 == getLayoutDirection()) {
            this.f21832cr = true;
            float f2 = this.f21824cj;
            this.f21824cj = this.f21828cn;
            this.f21828cn = f2;
            float f3 = this.f21825ck;
            this.f21825ck = this.f21829co;
            this.f21829co = f3;
        }
        BackgroundSplitManager.m18430a(getContext()).m18445a(this, "ZoomSeekBar");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Bitmap m23089a(Resources resources, int OplusGLSurfaceView_13) {
        Drawable drawableM2302a;
        if (resources == null || (drawableM2302a = ResourcesCompat.m2302a(this.f21734ax, OplusGLSurfaceView_13, null)) == null) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawableM2302a.getIntrinsicWidth(), drawableM2302a.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawableM2302a.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawableM2302a.draw(canvas);
        return bitmapCreateBitmap;
    }

    public void setCustomUltraWideIcon(int OplusGLSurfaceView_13) {
        this.f21880dz = OplusGLSurfaceView_13;
    }

    public void setCustomWideIcon(int OplusGLSurfaceView_13) {
        this.f21841dA = OplusGLSurfaceView_13;
    }

    public void setCustomTeleIcon(int OplusGLSurfaceView_13) {
        this.f21842dB = OplusGLSurfaceView_13;
    }

    public void setDisplayMode(PlatformImplementations.kt_3 aVar) {
        this.f21843dC = aVar;
    }

    @Override // com.oplus.camera.p172ui.BackgroundSplitManager.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18292a(boolean z, int OplusGLSurfaceView_13) {
        this.f21852dL = z;
        this.f21853dM = OplusGLSurfaceView_13;
        postInvalidate();
    }

    @Override // com.oplus.camera.p172ui.BackgroundSplitManager.PlatformImplementations.kt_3
    public void setNormalBackground(boolean z) {
        setLightBackground(z);
    }

    public void setScreenModeManager(ScreenModeManager c2953g) {
        this.f21863dh = c2953g;
    }

    @Override // com.oplus.camera.p172ui.inverse.InverseAble
    public void setInverseColor(boolean z) {
        CameraLog.m12954a("ZoomSeekBar", "setInverseColor, inverseColor: " + z);
        this.f21862dg = z;
        this.f21760bX = this.f21756bT ? this.f21759bW : this.f21758bV;
        this.f21760bX = z ? this.f21758bV : this.f21760bX;
        this.f21754bR.setColor(this.f21760bX);
        postInvalidate();
    }

    public void setLightBackground(boolean z) {
        CameraLog.m12954a("ZoomSeekBar", "setLightBackground, isLight: " + z);
        if (this.f21756bT == z) {
            return;
        }
        this.f21756bT = z;
        this.f21760bX = z ? this.f21759bW : this.f21758bV;
        this.f21760bX = this.f21862dg ? this.f21758bV : this.f21760bX;
        this.f21754bR.setColor(this.f21760bX);
        postInvalidate();
    }

    /* renamed from: E */
    private void m23080E() {
        this.f21879dy = new ValueAnimator();
        this.f21879dy.setDuration(500L);
        this.f21879dy.setInterpolator(f21699di);
        this.f21879dy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.preview.ai.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ZoomSeekBar.this.f17509ad = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        this.f21877dw = new ValueAnimator();
        this.f21877dw.setDuration(500L);
        this.f21877dw.setInterpolator(f21699di);
        this.f21877dw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.preview.ai.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ZoomSeekBar.this.f17498Q = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ZoomSeekBar.this.invalidate();
            }
        });
        this.f21874dt = new AnimatorSet();
        this.f21874dt.addListener(new Animator.AnimatorListener() { // from class: com.oplus.camera.ui.preview.ai.5
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
                ZoomSeekBar.this.f17517al.mo11559h();
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02e2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x04fc  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x050e  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0261  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r21) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 1446
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.preview.ZoomSeekBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m23100b(float COUIBaseListPopupWindow_12, float f2) {
        this.f21817cc.set(this.f21816cb.left - this.f21762bZ, this.f21816cb.top - this.f21815ca, this.f21816cb.right + this.f21762bZ, this.f21816cb.bottom + this.f21815ca);
        return this.f21817cc.contains(COUIBaseListPopupWindow_12, f2);
    }

    /* renamed from: F */
    private boolean m23081F() {
        return this.f21774bl && !this.f21773bk;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo23076a(float COUIBaseListPopupWindow_12, float f2, float f3, ArrayList<Float> arrayList, ArrayList<Float> arrayList2, int OplusGLSurfaceView_13, boolean z, boolean z2, boolean z3) {
        ZoomListener interfaceC3436ag;
        if (Math.abs(COUIBaseListPopupWindow_12 - this.f21783bu) < 1.0E-6f && Math.abs(f2 - this.f21781bs) < 1.0E-6f && Math.abs(f3 - this.f21782bt) < 1.0E-6f && OplusGLSurfaceView_13 == this.f21749bM && arrayList2.equals(this.f21747bK) && z2 == this.f21777bo && !z3) {
            CameraLog.m12966e("ZoomSeekBar", "init, skip the same configuration");
            if (!this.f21810cV.equals(mo23074a(m23154f(COUIBaseListPopupWindow_12)))) {
                m23145b(COUIBaseListPopupWindow_12, false);
            }
            if (this.f21833cs != 0 || (interfaceC3436ag = this.f21751bO) == null || !interfaceC3436ag.mo11581f() || arrayList2.contains(Float.valueOf(ZoomManager.f12334a))) {
                return;
            }
            this.f21701aB = false;
            m23146b(2, false);
            return;
        }
        this.f21774bl = this.f21773bk;
        this.f21776bn = this.f21777bo;
        this.f21773bk = z || z2;
        this.f21735ay = this.f21736az;
        this.f21700aA = this.f21701aB;
        this.f21845dE = this.f21844dD;
        this.f21834ct = this.f21833cs;
        ArrayList<Float> arrayList3 = this.f21747bK;
        if (arrayList3 != null) {
            this.f21793cE = new ArrayList<>(arrayList3);
        } else {
            this.f21793cE = null;
        }
        this.f21783bu = COUIBaseListPopupWindow_12;
        this.f21749bM = OplusGLSurfaceView_13;
        this.f21777bo = z2;
        this.f21747bK = arrayList2;
        this.f21746bJ = arrayList2.size();
        this.f21781bs = f2;
        this.f21782bt = f3;
        this.f21844dD = this.f21773bk ? PlatformImplementations.kt_3.ICON_ONLY : this.f21843dC;
        if (this.f17500S == 0) {
            for (IntrinsicsJvm.kt_4 bVar : IntrinsicsJvm.kt_4.values()) {
                this.f21819ce.put(bVar, this.f21818cd.get(bVar));
            }
        }
        if (this.f21773bk) {
            this.f21818cd.put(IntrinsicsJvm.kt_4.WIDE, m23089a(this.f21734ax, R.drawable.ic_zoom_front_camera_multi));
            this.f21818cd.put(IntrinsicsJvm.kt_4.TELE, m23089a(this.f21734ax, R.drawable.ic_zoom_front_camera_single));
        } else {
            Map<IntrinsicsJvm.kt_4, Bitmap> map = this.f21818cd;
            IntrinsicsJvm.kt_4 bVar2 = IntrinsicsJvm.kt_4.ULTRA_WIDE;
            Resources resources = this.f21734ax;
            int i2 = this.f21880dz;
            if (i2 <= 0) {
                i2 = R.drawable.zoom_seek_bar_ultra_angle;
            }
            map.put(bVar2, m23089a(resources, i2));
            Map<IntrinsicsJvm.kt_4, Bitmap> map2 = this.f21818cd;
            IntrinsicsJvm.kt_4 bVar3 = IntrinsicsJvm.kt_4.WIDE;
            Resources resources2 = this.f21734ax;
            int i3 = this.f21841dA;
            if (i3 <= 0) {
                i3 = R.drawable.zoom_seek_bar_normal_len;
            }
            map2.put(bVar3, m23089a(resources2, i3));
            Map<IntrinsicsJvm.kt_4, Bitmap> map3 = this.f21818cd;
            IntrinsicsJvm.kt_4 bVar4 = IntrinsicsJvm.kt_4.TELE;
            Resources resources3 = this.f21734ax;
            int i4 = this.f21842dB;
            if (i4 <= 0) {
                i4 = R.drawable.zoom_seek_bar_tele;
            }
            map3.put(bVar4, m23089a(resources3, i4));
        }
        if (m23081F() && !isShown()) {
            for (IntrinsicsJvm.kt_4 bVar5 : IntrinsicsJvm.kt_4.values()) {
                this.f21819ce.put(bVar5, this.f21818cd.get(bVar5));
            }
        }
        this.f21771bi = !arrayList.contains(Float.valueOf(ZoomManager.f12334a)) && arrayList2.contains(Float.valueOf(ZoomManager.f12334a));
        if (this.f21771bi) {
            arrayList.add(0, Float.valueOf(ZoomManager.f12334a));
        }
        this.f21736az = true;
        this.f21701aB = true;
        int iM23156h = m23156h(COUIBaseListPopupWindow_12);
        if (this.f21773bk) {
            iM23156h = COUIBaseListPopupWindow_12 == 1.0f ? 0 : 1;
        }
        this.f17504W = false;
        if (!this.f21751bO.mo11581f()) {
            m23146b(0, false);
        } else if (arrayList2.contains(Float.valueOf(ZoomManager.f12334a))) {
            float fMo11584i = this.f21751bO.mo11584i();
            if (Float.compare(fMo11584i, 0.0f) != 0) {
                this.f21736az = arrayList2.contains(Float.valueOf(fMo11584i));
            } else {
                this.f21736az = arrayList2.contains(Float.valueOf(2.0f));
            }
            if (this.f21736az) {
                m23146b(1, false);
                if (this.f21834ct != 1) {
                    m23135a(iM23156h, true);
                }
            } else {
                m23146b(3, false);
                if (this.f21834ct == 1) {
                    m23135a(iM23156h, false);
                } else if (this.f21774bl) {
                    this.f17504W = true;
                }
            }
        } else {
            this.f21701aB = false;
            m23146b(2, false);
            if (this.f21834ct == 1) {
                m23135a(iM23156h, false);
            } else if (this.f21845dE != this.f21844dD || this.f21774bl != this.f21773bk) {
                this.f17504W = true;
            }
        }
        if (this.f17504W) {
            if (this.f17543t.isStarted()) {
                this.f17543t.cancel();
            }
            CameraLog.m12959b("ZoomSeekBar", "init, start camera switch animator");
            this.f21837cw = this.f21713aN;
            this.f17543t.start();
        }
        this.f21716aQ = iM23156h;
        this.f21731au = m23157i(f3) / this.f17499R;
        this.f21732av = this.f21731au * 2.0f;
        this.f21784bv = getZoomSections();
        this.f21785bw = getSectionStep();
        this.f21787by = getIndicatorSections();
        ArrayList<Integer> arrayList4 = this.f21787by;
        this.f21764bb = arrayList4.get(arrayList4.size() - 1).intValue() + 1;
        this.f21720aU = this.f21764bb - 1;
        ArrayList<Float> arrayList5 = this.f21878dx;
        if (arrayList5 != null) {
            arrayList5.clear();
        } else {
            this.f21878dx = new ArrayList<>();
        }
        this.f21878dx.addAll(arrayList);
        this.f21748bL = new float[this.f21878dx.size()];
        for (int i5 = 0; i5 < this.f21748bL.length; i5++) {
            this.f21748bL[i5] = m23155g(this.f21878dx.get(i5).floatValue());
        }
        m23162w();
        float fM23155g = m23155g(COUIBaseListPopupWindow_12);
        if (1 == getLayoutDirection()) {
            fM23155g = Util.m24200a(1.0f, fM23155g);
        }
        this.f17509ad = fM23155g;
        this.f17510ae = this.f17509ad;
        this.f21811cW = this.f21810cV;
        if (this.f21845dE == PlatformImplementations.kt_3.ICON_ONLY) {
            this.f21810cV = mo23074a(m23154f(COUIBaseListPopupWindow_12));
        }
        if (!this.f21751bO.mo11581f() || !isShown() || ((this.f21834ct == 0 && this.f21833cs != 0) || this.f21793cE == null)) {
            setCurrentDisplayText(COUIBaseListPopupWindow_12);
            this.f21810cV = mo23074a(m23154f(COUIBaseListPopupWindow_12));
            setCenterPointIndex(iM23156h);
        } else {
            m23134a(iM23156h, COUIBaseListPopupWindow_12);
        }
        CameraLog.m12954a("ZoomSeekBar", "init, mCurrentDisplayText: " + this.f21810cV);
        setContentDescription(getContext().getResources().getString(R.string.camera_description_zoom_seek_bar) + this.f21810cV);
        mo18540o();
        mo18536k();
        postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G */
    public void m23082G() {
        if (this.f21844dD != PlatformImplementations.kt_3.ICON_ONLY || this.f17543t == null || this.f21776bn) {
            return;
        }
        if (this.f17543t.isStarted()) {
            this.f17543t.cancel();
        }
        this.f17543t.start();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m23135a(int OplusGLSurfaceView_13, boolean z) {
        float COUIBaseListPopupWindow_12;
        ZoomListener interfaceC3436ag;
        CameraLog.m12954a("ZoomSeekBar", "startTransformAnimator, mPreZoomBarType: " + this.f21834ct + ", mZoomBarType: " + this.f21833cs);
        if (this.f21834ct == 0 || this.f17500S == 15) {
            return;
        }
        ZoomListener interfaceC3436ag2 = this.f21751bO;
        if (interfaceC3436ag2 == null || !interfaceC3436ag2.mo11582g()) {
            ZoomListener interfaceC3436ag3 = this.f21751bO;
            if (interfaceC3436ag3 == null || !interfaceC3436ag3.mo11583h()) {
                this.f21836cv = this.f17512ag;
                this.f21837cw = this.f21713aN;
                this.f21839cy = OplusGLSurfaceView_13;
                this.f21838cx = m23132a(this.f21837cw, this.f21793cE);
                if (m23081F()) {
                    int i2 = this.f21716aQ;
                    if (i2 == 0) {
                        this.f21791cC = this.f21835cu;
                    } else if (i2 == 1) {
                        this.f21791cC = this.f21840cz;
                    }
                } else {
                    int i3 = this.f21838cx;
                    if (i3 == 1) {
                        this.f21791cC = this.f21789cA;
                    } else if (i3 == 2) {
                        this.f21791cC = this.f21790cB;
                    } else if (i3 == 3) {
                        this.f21791cC = this.f21840cz;
                    }
                }
                float f2 = this.f21824cj;
                int i4 = this.f21833cs;
                float f3 = 0.0f;
                if (i4 == 1) {
                    f3 = this.f17511af;
                    f2 = this.f21825ck;
                    COUIBaseListPopupWindow_12 = this.f21829co;
                } else if (i4 == 2) {
                    f3 = this.f21832cr ? this.f17511af + this.f21820cf : this.f17511af - this.f21820cf;
                    COUIBaseListPopupWindow_12 = this.f21832cr ? this.f21829co + this.f21820cf : this.f21829co - this.f21820cf;
                } else if (i4 != 3) {
                    COUIBaseListPopupWindow_12 = 0.0f;
                } else {
                    f3 = this.f21832cr ? (this.f17511af - this.f21820cf) - this.f21822ch : this.f17511af + this.f21820cf + this.f21822ch;
                    f2 = this.f21832cr ? (this.f21825ck - this.f21820cf) - this.f21822ch : this.f21825ck + this.f21820cf + this.f21822ch;
                    COUIBaseListPopupWindow_12 = 0.0f;
                }
                if (this.f21773bk) {
                    int i5 = this.f21839cy;
                    if (i5 == 0) {
                        this.f21792cD = f3;
                    } else if (i5 == 1) {
                        this.f21792cD = COUIBaseListPopupWindow_12;
                    }
                } else {
                    int iM23131a = m23131a(this.f21839cy);
                    if (iM23131a == 1) {
                        this.f21792cD = f2;
                    } else if (iM23131a == 2) {
                        this.f21792cD = f3;
                    } else if (iM23131a == 3) {
                        this.f21792cD = COUIBaseListPopupWindow_12;
                    }
                }
                if (z && this.f17541r != null) {
                    if (this.f17542s != null && this.f17542s.isStarted()) {
                        this.f17542s.cancel();
                    }
                    this.f17541r.start();
                } else if (!z && this.f17542s != null) {
                    if (this.f17541r != null && this.f17541r.isStarted()) {
                        this.f17541r.cancel();
                    }
                    this.f17542s.start();
                }
                if ((m18517b() || m23165z()) && (interfaceC3436ag = this.f21751bO) != null && interfaceC3436ag.mo11586k()) {
                    this.f17519an.postDelayed(new Runnable() { // from class: com.oplus.camera.ui.preview.ai.6
                        @Override // java.lang.Runnable
                        public void run() {
                            ZoomSeekBar.this.m23082G();
                            ZoomSeekBar.this.setStatus(15);
                        }
                    }, 25L);
                } else {
                    m23082G();
                    setStatus(15);
                }
            }
        }
    }

    /* renamed from: v */
    public void m23161v() {
        CameraLog.m12962c("ZoomSeekBar", "resetZoomBarType");
        mo18543r();
        this.f21833cs = 0;
        this.f21834ct = 0;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void m23146b(int OplusGLSurfaceView_13, boolean z) {
        if (this.f21833cs != OplusGLSurfaceView_13 || z) {
            CameraLog.m12954a("ZoomSeekBar", "setZoomBarType, " + this.f21833cs + " -> " + OplusGLSurfaceView_13);
            this.f21833cs = OplusGLSurfaceView_13;
            int i2 = this.f21832cr ? -1 : 1;
            if (!z) {
                float COUIBaseListPopupWindow_12 = this.f21823ci;
                this.f21835cu = COUIBaseListPopupWindow_12;
                this.f21789cA = this.f21824cj;
                this.f21790cB = COUIBaseListPopupWindow_12;
                this.f21840cz = this.f21828cn;
            }
            int i3 = this.f21833cs;
            if (i3 == 1) {
                this.f21824cj = this.f21825ck;
                this.f21823ci = this.f17511af;
                this.f21828cn = this.f21829co;
            } else {
                if (i3 != 2) {
                    if (i3 != 3) {
                        return;
                    }
                    float f2 = i2;
                    this.f21824cj = this.f21825ck + ((this.f21820cf + this.f21822ch) * f2);
                    this.f21823ci = this.f17511af + ((this.f21820cf + this.f21822ch) * f2);
                    this.f21828cn = this.f21823ci;
                    return;
                }
                float f3 = this.f17511af;
                float f4 = this.f21820cf;
                float f5 = i2;
                this.f21823ci = f3 - (f4 * f5);
                this.f21828cn = this.f21829co - (f4 * f5);
                this.f21824cj = this.f21823ci;
            }
        }
    }

    /* renamed from: w */
    protected void m23162w() {
        Paint.FontMetrics fontMetrics = this.f17515aj.getFontMetrics();
        this.f21763ba = ((fontMetrics.bottom - fontMetrics.top) / 2.0f) - fontMetrics.bottom;
    }

    @Override // com.oplus.camera.p172ui.CameraSeekBar
    /* renamed from: OplusGLSurfaceView_5 */
    protected void mo18536k() {
        Paint paint = this.f21753bQ;
        if (paint != null) {
            paint.setAlpha(255);
        }
        if (this.f17515aj != null) {
            this.f17515aj.setAlpha(Color.alpha(this.f21757bU));
            this.f17515aj.setColor(this.f21757bU);
            this.f17515aj.setTextSize(this.f21709aJ);
        }
        Paint paint2 = this.f21754bR;
        if (paint2 != null) {
            paint2.setAlpha(Color.alpha(this.f21760bX));
            this.f21754bR.setColor(this.f21760bX);
        }
        Paint paint3 = this.f21755bS;
        if (paint3 != null) {
            paint3.setColor(this.f21761bY);
            this.f21755bS.setAlpha(Color.alpha(this.f21761bY));
        }
    }

    @Override // com.oplus.camera.p172ui.CameraSeekBar, android.view.View
    protected void onDraw(Canvas canvas) {
        synchronized (this) {
            m23083H();
            super.onDraw(canvas);
        }
    }

    /* renamed from: H */
    private void m23083H() {
        int OplusGLSurfaceView_13;
        if (this.f21721aV != this.f21723aX) {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            if (jCurrentAnimationTimeMillis < this.f21870dp) {
                int i2 = (int) (jCurrentAnimationTimeMillis - this.f21869do);
                int i3 = this.f21722aW;
                if (!this.f21770bh) {
                    i2 = -i2;
                }
                int i4 = i3 + ((i2 * 360) / 1000);
                if (i4 >= 0) {
                    OplusGLSurfaceView_13 = i4 % 360;
                } else {
                    OplusGLSurfaceView_13 = (i4 % 360) + 360;
                }
                this.f21721aV = OplusGLSurfaceView_13;
                invalidate();
                return;
            }
            this.f21721aV = this.f21723aX;
        }
    }

    /* renamed from: x */
    public void m23163x() {
        this.f21794cF = Util.m24215a(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        this.f21796cH = new Canvas();
        this.f21796cH.setBitmap(this.f21794cF);
        this.f21795cG = Util.m24215a(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        this.f21797cI = new Canvas();
        this.f21797cI.setBitmap(this.f21795cG);
    }

    @Override // com.oplus.camera.p172ui.CameraSeekBar
    /* renamed from: r */
    public void mo18543r() {
        super.mo18543r();
        AnimatorSet animatorSet = this.f21861df;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        if (this.f21752bP != null) {
            this.f21752bP = null;
        }
        mo18540o();
        this.f21769bg = false;
        this.f21778bp = false;
        setRate(m23155g(1.0f));
        m23164y();
    }

    @Override // com.oplus.camera.p172ui.CameraSeekBar
    /* renamed from: o */
    protected void mo18540o() {
        this.f21788bz.setColor(-1);
        this.f21738bB.setColor(this.f21739bC);
        this.f21740bD.setColor(this.f21741bE);
        this.f21742bF.setColor(-1);
    }

    /* renamed from: y */
    public void m23164y() {
        Bitmap bitmap = this.f21794cF;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f21794cF.recycle();
            this.f21794cF = null;
        }
        Bitmap bitmap2 = this.f21795cG;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.f21795cG.recycle();
            this.f21795cG = null;
        }
        this.f21797cI = null;
        this.f21796cH = null;
    }

    @Override // com.oplus.camera.p172ui.CameraSeekBar
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18511a(AnimatorListenerAdapter animatorListenerAdapter, boolean z, boolean z2) {
        this.f21769bg = false;
        mo18542q();
        super.mo18511a(animatorListenerAdapter, z, z2);
    }

    @Override // com.oplus.camera.p172ui.CameraSeekBar
    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean mo18518b(boolean z) {
        this.f21769bg = false;
        return super.mo18518b(z);
    }

    @Override // com.oplus.camera.p172ui.CameraSeekBar
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo18521c(boolean z) {
        this.f21725aZ = 0.0f;
        super.mo18521c(z);
        m23163x();
    }

    @Override // com.oplus.camera.p172ui.CameraSeekBar
    /* renamed from: t */
    protected void mo18545t() {
        this.f21812cX = this.f21810cV;
        this.f21714aO = this.f21713aN;
    }

    @Override // com.oplus.camera.p172ui.CameraSeekBar
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo18512a(Canvas canvas) {
        m23136a(canvas, this.f17488G);
        m23160k(canvas);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m23139a(Canvas canvas, Bitmap bitmap, float COUIBaseListPopupWindow_12, float f2, Paint paint) {
        canvas.drawBitmap(bitmap, COUIBaseListPopupWindow_12 - this.f21830cp, f2 - this.f21831cq, paint);
    }

    /* renamed from: OplusGLSurfaceView_5 */
    protected void m23160k(Canvas canvas) {
        String str;
        m23162w();
        this.f17546w.setAlpha((int) (this.f17489H * 255.0f));
        this.f17547x.setAlpha((int) (this.f17492K * 255.0f));
        this.f17548y.setAlpha((int) (this.f17493L * 255.0f));
        int alpha = this.f17545v.getAlpha();
        float COUIBaseListPopupWindow_12 = this.f21789cA;
        float f2 = COUIBaseListPopupWindow_12 + ((this.f21824cj - COUIBaseListPopupWindow_12) * this.f17488G);
        float f3 = this.f21790cB;
        float f4 = f3 + ((this.f21823ci - f3) * this.f17488G);
        float f5 = this.f21840cz;
        float f6 = f5 + ((this.f21828cn - f5) * this.f17488G);
        int iRound = Math.round(this.f17488G * 255.0f);
        int iRound2 = Math.round((1.0f - this.f17488G) * 255.0f);
        Bitmap bitmapM23090a = m23090a(IntrinsicsJvm.kt_4.ULTRA_WIDE);
        Bitmap bitmapM23098b = m23098b(IntrinsicsJvm.kt_4.ULTRA_WIDE);
        Bitmap bitmapM23090a2 = m23090a(IntrinsicsJvm.kt_4.WIDE);
        Bitmap bitmapM23098b2 = m23098b(IntrinsicsJvm.kt_4.WIDE);
        Bitmap bitmapM23090a3 = m23090a(IntrinsicsJvm.kt_4.TELE);
        Bitmap bitmapM23098b3 = m23098b(IntrinsicsJvm.kt_4.TELE);
        String str2 = this.f21810cV;
        if (this.f21861df.isStarted()) {
            str2 = this.f21813cY;
        }
        String str3 = str2;
        if (this.f21701aB) {
            canvas.save();
            canvas.rotate(-this.f21721aV, f2, this.f17512ag);
            if (m23104c(IntrinsicsJvm.kt_4.ULTRA_WIDE) && (this.f21844dD == PlatformImplementations.kt_3.ICON_ONLY || this.f21845dE == PlatformImplementations.kt_3.ICON_ONLY)) {
                canvas.scale(this.f17488G, this.f17488G, f2, this.f17512ag);
            }
            if (bitmapM23098b != null) {
                this.f17545v.setAlpha(iRound);
                str = str3;
                m23139a(canvas, bitmapM23098b, f2, this.f17512ag, this.f17545v);
            } else {
                str = str3;
                this.f17515aj.setAlpha(iRound);
                canvas.drawText(str, f2, this.f17512ag + this.f21763ba, this.f17515aj);
            }
            canvas.restore();
        } else {
            str = str3;
        }
        if (this.f21700aA) {
            canvas.save();
            canvas.rotate(-this.f21721aV, f2, this.f17512ag);
            if (m23107d(IntrinsicsJvm.kt_4.ULTRA_WIDE) && (this.f21844dD == PlatformImplementations.kt_3.ICON_ONLY || this.f21845dE == PlatformImplementations.kt_3.ICON_ONLY)) {
                canvas.scale(1.0f - this.f17488G, 1.0f - this.f17488G, f2, this.f17512ag);
            }
            if (bitmapM23090a != null) {
                this.f17545v.setAlpha(iRound2);
                m23139a(canvas, bitmapM23090a, f2, this.f17512ag, this.f17545v);
            } else {
                this.f17515aj.setAlpha(iRound2);
                canvas.drawText(this.f21811cW, f2, this.f17512ag + this.f21763ba, this.f17515aj);
            }
            canvas.restore();
        }
        canvas.save();
        canvas.rotate(-this.f21721aV, f4, this.f17512ag);
        if (m23104c(IntrinsicsJvm.kt_4.WIDE) && (this.f21844dD == PlatformImplementations.kt_3.ICON_ONLY || this.f21845dE == PlatformImplementations.kt_3.ICON_ONLY)) {
            canvas.scale(this.f17488G, this.f17488G, f4, this.f17512ag);
        }
        if (bitmapM23098b2 != null) {
            this.f17545v.setAlpha(iRound);
            m23139a(canvas, bitmapM23098b2, f4, this.f17512ag, this.f17545v);
        } else {
            this.f17515aj.setAlpha(iRound);
            canvas.drawText(str, f4, this.f17512ag + this.f21763ba, this.f17515aj);
        }
        canvas.restore();
        canvas.save();
        canvas.rotate(-this.f21721aV, f4, this.f17512ag);
        if (this.f21844dD == PlatformImplementations.kt_3.ICON_ONLY || this.f21845dE == PlatformImplementations.kt_3.ICON_ONLY) {
            canvas.scale(1.0f - this.f17488G, 1.0f - this.f17488G, f4, this.f17512ag);
        }
        if (bitmapM23090a2 != null) {
            this.f17545v.setAlpha(iRound2);
            m23139a(canvas, bitmapM23090a2, f4, this.f17512ag, this.f17545v);
        } else {
            this.f17515aj.setAlpha(iRound2);
            canvas.drawText(this.f21811cW, f4, this.f17512ag + this.f21763ba, this.f17515aj);
        }
        canvas.restore();
        if (this.f21736az) {
            canvas.save();
            canvas.rotate(-this.f21721aV, f6, this.f17512ag);
            if (m23104c(IntrinsicsJvm.kt_4.TELE) && (this.f21844dD == PlatformImplementations.kt_3.ICON_ONLY || this.f21845dE == PlatformImplementations.kt_3.ICON_ONLY)) {
                canvas.scale(this.f17488G, this.f17488G, f6, this.f17512ag);
            }
            if (bitmapM23098b3 != null) {
                this.f17545v.setAlpha(iRound);
                m23139a(canvas, bitmapM23098b3, f6, this.f17512ag, this.f17545v);
            } else {
                this.f17515aj.setAlpha(iRound);
                canvas.drawText(str, f6, this.f17512ag + this.f21763ba, this.f17515aj);
            }
            canvas.restore();
        }
        if (this.f21735ay) {
            canvas.save();
            canvas.rotate(-this.f21721aV, f6, this.f17512ag);
            if (m23107d(IntrinsicsJvm.kt_4.TELE) && (this.f21844dD == PlatformImplementations.kt_3.ICON_ONLY || this.f21845dE == PlatformImplementations.kt_3.ICON_ONLY)) {
                canvas.scale(1.0f - this.f17488G, 1.0f - this.f17488G, f6, this.f17512ag);
            }
            if (bitmapM23090a3 != null) {
                this.f17545v.setAlpha(iRound2);
                m23139a(canvas, bitmapM23090a3, f6, this.f17512ag, this.f17545v);
            } else {
                this.f17515aj.setAlpha(iRound2);
                canvas.drawText(this.f21811cW, f6, this.f17512ag + this.f21763ba, this.f17515aj);
            }
            canvas.restore();
        }
        this.f17545v.setAlpha(alpha);
        float f7 = this.f21792cD;
        this.f21860de = f7;
        float f8 = this.f21791cC;
        this.f21856da = f8 - ((f8 - f7) * this.f17488G);
        canvas.save();
        m23137a(canvas, this.f21856da, this.f17512ag);
        canvas.restore();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m23136a(Canvas canvas, float COUIBaseListPopupWindow_12) {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        int OplusGLSurfaceView_13 = this.f21833cs;
        if (OplusGLSurfaceView_13 == 1) {
            int i2 = this.f21834ct;
            if (i2 == 3) {
                if (this.f21832cr) {
                    f6 = this.f21835cu;
                    f7 = this.f21820cf;
                } else {
                    f6 = this.f21835cu - (this.f21820cf * 3.0f);
                    f7 = this.f21822ch;
                }
                float f16 = f6 - f7;
                if (this.f21832cr) {
                    f8 = this.f21835cu + (this.f21820cf * 3.0f);
                    f9 = this.f21822ch;
                } else {
                    f8 = this.f21835cu;
                    f9 = this.f21820cf;
                }
                float f17 = f8 + f9;
                float f18 = this.f21823ci;
                float f19 = this.f21820cf;
                float f20 = this.f21822ch;
                float f21 = (f18 - (f19 * 3.0f)) - f20;
                float f22 = f18 + (f19 * 3.0f) + f20;
                RectF rectF = this.f21816cb;
                rectF.left = f16 - ((f16 - f21) * COUIBaseListPopupWindow_12);
                rectF.top = this.f17512ag - this.f21820cf;
                RectF rectF2 = this.f21816cb;
                float f23 = this.f17512ag;
                float f24 = this.f21820cf;
                rectF2.bottom = f23 + f24;
                RectF rectF3 = this.f21816cb;
                rectF3.right = f17 - ((f17 - f22) * COUIBaseListPopupWindow_12);
                canvas.drawRoundRect(rectF3, f24, f24, this.f21754bR);
            } else if (i2 == 2) {
                if (this.f21832cr) {
                    f2 = this.f21835cu - (this.f21820cf * 3.0f);
                    f3 = this.f21822ch;
                } else {
                    f2 = this.f21835cu;
                    f3 = this.f21820cf;
                }
                float f25 = f2 - f3;
                if (this.f21832cr) {
                    f4 = this.f21835cu;
                    f5 = this.f21820cf;
                } else {
                    f4 = this.f21835cu + (this.f21820cf * 3.0f);
                    f5 = this.f21822ch;
                }
                float f26 = f4 + f5;
                float f27 = this.f21823ci;
                float f28 = this.f21820cf;
                float f29 = this.f21822ch;
                float f30 = (f27 - (f28 * 3.0f)) - f29;
                float f31 = f27 + (f28 * 3.0f) + f29;
                RectF rectF4 = this.f21816cb;
                rectF4.left = f25 - ((f25 - f30) * COUIBaseListPopupWindow_12);
                rectF4.top = this.f17512ag - this.f21820cf;
                RectF rectF5 = this.f21816cb;
                float f32 = this.f17512ag;
                float f33 = this.f21820cf;
                rectF5.bottom = f32 + f33;
                RectF rectF6 = this.f21816cb;
                rectF6.right = f26 - ((f26 - f31) * COUIBaseListPopupWindow_12);
                canvas.drawRoundRect(rectF6, f33, f33, this.f21754bR);
            } else if (i2 == 1) {
                float f34 = this.f21823ci;
                float f35 = this.f21820cf;
                float f36 = this.f21822ch;
                float f37 = (f34 - (f35 * 3.0f)) - f36;
                float f38 = f34 + (f35 * 3.0f) + f36;
                RectF rectF7 = this.f21816cb;
                rectF7.left = f37;
                rectF7.top = this.f17512ag - this.f21820cf;
                RectF rectF8 = this.f21816cb;
                float f39 = this.f17512ag;
                float f40 = this.f21820cf;
                rectF8.bottom = f39 + f40;
                RectF rectF9 = this.f21816cb;
                rectF9.right = f38;
                canvas.drawRoundRect(rectF9, f40, f40, this.f21754bR);
            }
        } else if (OplusGLSurfaceView_13 == 2) {
            if (this.f21832cr) {
                f10 = this.f21823ci - (this.f21820cf * 3.0f);
                f11 = this.f21822ch;
            } else {
                f10 = this.f21823ci;
                f11 = this.f21820cf;
            }
            float f41 = f10 - f11;
            if (this.f21832cr) {
                f12 = this.f21823ci;
                f13 = this.f21820cf;
            } else {
                f12 = this.f21823ci + (this.f21820cf * 3.0f);
                f13 = this.f21822ch;
            }
            float f42 = f12 + f13;
            float f43 = this.f21835cu;
            float f44 = this.f21820cf;
            float f45 = this.f21822ch;
            float f46 = (f43 - (f44 * 3.0f)) - f45;
            float f47 = f43 + (f44 * 3.0f) + f45;
            RectF rectF10 = this.f21816cb;
            rectF10.left = f46 - ((f46 - f41) * COUIBaseListPopupWindow_12);
            rectF10.top = this.f17512ag - this.f21820cf;
            RectF rectF11 = this.f21816cb;
            float f48 = this.f17512ag;
            float f49 = this.f21820cf;
            rectF11.bottom = f48 + f49;
            RectF rectF12 = this.f21816cb;
            rectF12.right = f47 - ((f47 - f42) * COUIBaseListPopupWindow_12);
            canvas.drawRoundRect(rectF12, f49, f49, this.f21754bR);
        } else {
            if (OplusGLSurfaceView_13 != 3) {
                return;
            }
            float f50 = this.f21835cu;
            float f51 = this.f21820cf;
            float f52 = this.f21822ch;
            float f53 = (f50 - (f51 * 3.0f)) - f52;
            float f54 = f50 + (f51 * 3.0f) + f52;
            float f55 = this.f21832cr ? this.f21823ci - f51 : (this.f21823ci - (f51 * 3.0f)) - f52;
            if (this.f21832cr) {
                f14 = this.f21823ci + (this.f21820cf * 3.0f);
                f15 = this.f21822ch;
            } else {
                f14 = this.f21823ci;
                f15 = this.f21820cf;
            }
            float f56 = f14 + f15;
            RectF rectF13 = this.f21816cb;
            rectF13.left = f53 - ((f53 - f55) * COUIBaseListPopupWindow_12);
            rectF13.top = this.f17512ag - this.f21820cf;
            RectF rectF14 = this.f21816cb;
            float f57 = this.f17512ag;
            float f58 = this.f21820cf;
            rectF14.bottom = f57 + f58;
            RectF rectF15 = this.f21816cb;
            rectF15.right = f54 - ((f54 - f56) * COUIBaseListPopupWindow_12);
            canvas.drawRoundRect(rectF15, f58, f58, this.f21754bR);
        }
        if (this.f21852dL) {
            BackgroundSplitManager.m18430a(getContext()).m18444a(this, canvas, this.f21816cb, this.f21853dM);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23093a(Canvas canvas, Bitmap bitmap, float COUIBaseListPopupWindow_12, float f2, float f3, float f4, float f5, Paint paint) {
        m23092a(canvas, bitmap, COUIBaseListPopupWindow_12, 1.0f, 1.0f, f2, f3, f4, f5, paint);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23092a(Canvas canvas, Bitmap bitmap, float COUIBaseListPopupWindow_12, float f2, float f3, float f4, float f5, float f6, float f7, Paint paint) {
        canvas.save();
        canvas.rotate(COUIBaseListPopupWindow_12, f4, f5);
        canvas.scale(f2, f3, f4, f5);
        m23139a(canvas, bitmap, f6, f7, paint);
        canvas.restore();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23095a(Canvas canvas, String str, float COUIBaseListPopupWindow_12, float f2, float f3, float f4, float f5, Paint paint) {
        m23094a(canvas, str, COUIBaseListPopupWindow_12, 1.0f, 1.0f, f2, f3, f4, f5, paint);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23094a(Canvas canvas, String str, float COUIBaseListPopupWindow_12, float f2, float f3, float f4, float f5, float f6, float f7, Paint paint) {
        canvas.save();
        canvas.rotate(COUIBaseListPopupWindow_12, f4, f5);
        canvas.scale(f2, f3, f4, f5);
        canvas.drawText(str, f6, f7, paint);
        canvas.restore();
    }

    @Override // com.oplus.camera.p172ui.CameraSeekBar
    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo18516b(Canvas canvas) {
        m23138a(canvas, this.f21823ci, this.f17512ag, 0.0f);
        if (!this.f21861df.isRunning()) {
            m23142a(canvas, this.f21810cV, this.f21823ci, this.f17512ag, this.f21833cs);
        } else {
            m23141a(canvas, this.f21810cV, this.f21823ci, this.f17512ag);
        }
        super.mo18516b(canvas);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m23142a(Canvas canvas, String str, float COUIBaseListPopupWindow_12, float f2, int OplusGLSurfaceView_13) {
        float f3;
        float f4;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        if (OplusGLSurfaceView_13 == 0) {
            return;
        }
        m23162w();
        int currentBarIndex = getCurrentBarIndex();
        int iM23132a = m23132a(this.f21837cw, this.f21793cE);
        if (this.f21700aA && !this.f21701aB) {
            iM23132a++;
        } else if (!this.f21700aA && this.f21701aB) {
            iM23132a--;
        }
        int i10 = iM23132a;
        boolean z = this.f17491J < 0.999f;
        int iRound = Math.round(this.f17491J * 255.0f);
        int iRound2 = Math.round((1.0f - this.f17491J) * 255.0f);
        if (this.f17500S == 0) {
            this.f17515aj.setAlpha(255);
            this.f21753bQ.setAlpha(255);
        }
        if (this.f21844dD == PlatformImplementations.kt_3.ICON_ONLY || this.f21845dE == PlatformImplementations.kt_3.ICON_ONLY) {
            f3 = this.f17491J;
            f4 = 1.0f - this.f17491J;
        } else {
            f3 = 1.0f;
            f4 = 1.0f;
        }
        if (!this.f21701aB) {
            i2 = iRound;
            i3 = i10;
            i4 = iRound2;
        } else if (z) {
            if (this.f21844dD == PlatformImplementations.kt_3.NORMAL && currentBarIndex == 1) {
                this.f17515aj.setAlpha(iRound);
                float f5 = -this.f21721aV;
                float f6 = this.f21824cj;
                i9 = iRound2;
                i2 = iRound;
                m23094a(canvas, str, f5, f3, f3, f6, f2, f6, f2 + this.f21763ba, this.f17515aj);
            } else {
                i9 = iRound2;
                i2 = iRound;
                this.f21753bQ.setAlpha(i2);
                Bitmap bitmap = this.f21818cd.get(IntrinsicsJvm.kt_4.ULTRA_WIDE);
                float f7 = -this.f21721aV;
                float f8 = this.f21824cj;
                m23092a(canvas, bitmap, f7, f3, f3, f8, f2, f8, f2, this.f21753bQ);
            }
            if (this.f21845dE == PlatformImplementations.kt_3.NORMAL && i10 == 1) {
                int i11 = i9;
                this.f17515aj.setAlpha(i11);
                String str2 = this.f21811cW;
                float f9 = -this.f21721aV;
                float f10 = this.f21824cj;
                i3 = i10;
                i4 = i11;
                m23094a(canvas, str2, f9, f4, f4, f10, f2, f10, f2 + this.f21763ba, this.f17515aj);
            } else {
                i3 = i10;
                i4 = i9;
                Bitmap bitmap2 = this.f21819ce.get(IntrinsicsJvm.kt_4.ULTRA_WIDE);
                if (!this.f21700aA) {
                    bitmap2 = this.f21819ce.get(IntrinsicsJvm.kt_4.WIDE);
                }
                this.f21753bQ.setAlpha(i4);
                float f11 = -this.f21721aV;
                float f12 = this.f21824cj;
                m23092a(canvas, bitmap2, f11, f4, f4, f12, f2, f12, f2, this.f21753bQ);
            }
        } else {
            i2 = iRound;
            i3 = i10;
            i4 = iRound2;
            if (this.f21844dD == PlatformImplementations.kt_3.NORMAL && currentBarIndex == 1) {
                float f13 = -this.f21721aV;
                float f14 = this.f21824cj;
                m23095a(canvas, str, f13, f14, f2, f14, f2 + this.f21763ba, this.f17515aj);
            } else {
                Bitmap bitmap3 = this.f21818cd.get(IntrinsicsJvm.kt_4.ULTRA_WIDE);
                float f15 = -this.f21721aV;
                float f16 = this.f21824cj;
                m23093a(canvas, bitmap3, f15, f16, f2, f16, f2, this.f21753bQ);
            }
        }
        if (z) {
            if (this.f21844dD == PlatformImplementations.kt_3.NORMAL && currentBarIndex == 2) {
                this.f17515aj.setAlpha(i2);
                float f17 = -this.f21721aV;
                float f18 = this.f21823ci;
                i7 = currentBarIndex;
                i8 = 2;
                m23094a(canvas, str, f17, f3, f3, f18, f2, f18, f2 + this.f21763ba, this.f17515aj);
            } else {
                i7 = currentBarIndex;
                i8 = 2;
                this.f21753bQ.setAlpha(i2);
                Bitmap bitmap4 = this.f21818cd.get(IntrinsicsJvm.kt_4.WIDE);
                float f19 = -this.f21721aV;
                float f20 = this.f21823ci;
                m23092a(canvas, bitmap4, f19, f3, f3, f20, f2, f20, f2, this.f21753bQ);
            }
            if (this.f21845dE == PlatformImplementations.kt_3.NORMAL) {
                int i12 = i3;
                if (i12 == i8) {
                    this.f17515aj.setAlpha(i4);
                    String str3 = this.f21811cW;
                    float f21 = -this.f21721aV;
                    float f22 = this.f21823ci;
                    i5 = i12;
                    m23094a(canvas, str3, f21, f4, f4, f22, f2, f22, f2 + this.f21763ba, this.f17515aj);
                    i6 = i7;
                } else {
                    i5 = i12;
                }
            } else {
                i5 = i3;
            }
            Bitmap bitmap5 = this.f21819ce.get(IntrinsicsJvm.kt_4.WIDE);
            if (!this.f21700aA && this.f21701aB) {
                bitmap5 = this.f21819ce.get(IntrinsicsJvm.kt_4.TELE);
            }
            this.f21753bQ.setAlpha(i4);
            float f23 = -this.f21721aV;
            float f24 = this.f21823ci;
            m23092a(canvas, bitmap5, f23, f4, f4, f24, f2, f24, f2, this.f21753bQ);
            i6 = i7;
        } else {
            i5 = i3;
            if (this.f21844dD == PlatformImplementations.kt_3.NORMAL) {
                i6 = currentBarIndex;
                if (i6 == 2) {
                    float f25 = -this.f21721aV;
                    float f26 = this.f21823ci;
                    m23095a(canvas, str, f25, f26, f2, f26, f2 + this.f21763ba, this.f17515aj);
                }
            } else {
                i6 = currentBarIndex;
            }
            Bitmap bitmap6 = this.f21818cd.get(IntrinsicsJvm.kt_4.WIDE);
            float f27 = -this.f21721aV;
            float f28 = this.f21823ci;
            m23093a(canvas, bitmap6, f27, f28, f2, f28, f2, this.f21753bQ);
        }
        if (this.f21736az) {
            if (z) {
                if (this.f21844dD == PlatformImplementations.kt_3.NORMAL && i6 == 3) {
                    this.f17515aj.setAlpha(i2);
                    float f29 = -this.f21721aV;
                    float f30 = this.f21828cn;
                    m23094a(canvas, str, f29, f3, f3, f30, f2, f30, f2 + this.f21763ba, this.f17515aj);
                } else {
                    this.f21753bQ.setAlpha(i2);
                    Bitmap bitmap7 = this.f21818cd.get(IntrinsicsJvm.kt_4.TELE);
                    float f31 = -this.f21721aV;
                    float f32 = this.f21828cn;
                    m23092a(canvas, bitmap7, f31, f3, f3, f32, f2, f32, f2, this.f21753bQ);
                }
                if (this.f21845dE == PlatformImplementations.kt_3.NORMAL && i5 == 3) {
                    this.f17515aj.setAlpha(i4);
                    String str4 = this.f21811cW;
                    float f33 = -this.f21721aV;
                    float f34 = this.f21828cn;
                    m23094a(canvas, str4, f33, f4, f4, f34, f2, f34, f2 + this.f21763ba, this.f17515aj);
                } else {
                    Bitmap bitmap8 = this.f21819ce.get(IntrinsicsJvm.kt_4.TELE);
                    if (!this.f21735ay) {
                        bitmap8 = this.f21819ce.get(IntrinsicsJvm.kt_4.WIDE);
                    }
                    this.f21753bQ.setAlpha(i4);
                    float f35 = -this.f21721aV;
                    float f36 = this.f21828cn;
                    m23092a(canvas, bitmap8, f35, f4, f4, f36, f2, f36, f2, this.f21753bQ);
                }
            } else if (this.f21844dD == PlatformImplementations.kt_3.NORMAL && i6 == 3) {
                float f37 = -this.f21721aV;
                float f38 = this.f21828cn;
                m23094a(canvas, str, f37, f3, f3, f38, f2, f38, f2 + this.f21763ba, this.f17515aj);
            } else {
                Bitmap bitmap9 = this.f21818cd.get(IntrinsicsJvm.kt_4.TELE);
                float f39 = -this.f21721aV;
                float f40 = this.f21828cn;
                m23092a(canvas, bitmap9, f39, f3, f3, f40, f2, f40, f2, this.f21753bQ);
            }
        }
        canvas.save();
        m23137a(canvas, getOvalCenterX(), f2);
        canvas.restore();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m23141a(Canvas canvas, String str, float COUIBaseListPopupWindow_12, float f2) {
        m23162w();
        int currentBarIndex = getCurrentBarIndex();
        int slideToBarIndex = getSlideToBarIndex();
        if (Float.compare(this.f21814cZ, -1.0f) == 0) {
            float f3 = this.f21860de;
            if (f3 <= 0.0f) {
                f3 = COUIBaseListPopupWindow_12;
            }
            this.f21814cZ = f3;
        }
        if (this.f21701aB) {
            canvas.save();
            canvas.translate(this.f21824cj - COUIBaseListPopupWindow_12, 0.0f);
            canvas.rotate(-this.f21721aV, COUIBaseListPopupWindow_12, f2);
            int OplusGLSurfaceView_13 = ZoomSeekBar_4.f21885a[this.f21844dD.ordinal()];
            if (OplusGLSurfaceView_13 != 1) {
                if (OplusGLSurfaceView_13 == 2) {
                    this.f21753bQ.setAlpha(255);
                    canvas.drawBitmap(this.f21818cd.get(IntrinsicsJvm.kt_4.ULTRA_WIDE), COUIBaseListPopupWindow_12 - this.f21826cl, f2 - this.f21827cm, this.f21753bQ);
                }
            } else if (slideToBarIndex == 1) {
                this.f21753bQ.setAlpha(this.f21850dJ);
                this.f17515aj.setAlpha(this.f21848dH);
                canvas.drawText(this.f21813cY, COUIBaseListPopupWindow_12, (this.f21763ba + f2) - this.f21847dG, this.f17515aj);
                canvas.drawBitmap(this.f21818cd.get(IntrinsicsJvm.kt_4.ULTRA_WIDE), COUIBaseListPopupWindow_12 - this.f21826cl, (f2 - this.f21827cm) + this.f21849dI, this.f21753bQ);
            } else if (currentBarIndex == 1) {
                this.f21753bQ.setAlpha(this.f21848dH);
                this.f17515aj.setAlpha(this.f21850dJ);
                canvas.drawText(this.f21810cV, COUIBaseListPopupWindow_12, (this.f21763ba + f2) - this.f21849dI, this.f17515aj);
                canvas.drawBitmap(this.f21818cd.get(IntrinsicsJvm.kt_4.ULTRA_WIDE), COUIBaseListPopupWindow_12 - this.f21826cl, (f2 - this.f21827cm) + this.f21847dG, this.f21753bQ);
            } else {
                this.f21753bQ.setAlpha(255);
                canvas.drawBitmap(this.f21818cd.get(IntrinsicsJvm.kt_4.ULTRA_WIDE), COUIBaseListPopupWindow_12 - this.f21826cl, f2 - this.f21827cm, this.f21753bQ);
            }
            canvas.restore();
        }
        canvas.save();
        canvas.rotate(-this.f21721aV, COUIBaseListPopupWindow_12, f2);
        int i2 = ZoomSeekBar_4.f21885a[this.f21844dD.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                this.f21753bQ.setAlpha(255);
                canvas.drawBitmap(this.f21818cd.get(IntrinsicsJvm.kt_4.WIDE), COUIBaseListPopupWindow_12 - this.f21826cl, f2 - this.f21827cm, this.f21753bQ);
            }
        } else if (slideToBarIndex == 2) {
            this.f21753bQ.setAlpha(this.f21850dJ);
            this.f17515aj.setAlpha(this.f21848dH);
            canvas.drawText(this.f21813cY, COUIBaseListPopupWindow_12, (this.f21763ba + f2) - this.f21847dG, this.f17515aj);
            canvas.drawBitmap(this.f21818cd.get(IntrinsicsJvm.kt_4.WIDE), COUIBaseListPopupWindow_12 - this.f21826cl, (f2 - this.f21827cm) + this.f21849dI, this.f21753bQ);
        } else if (currentBarIndex == 2) {
            this.f21753bQ.setAlpha(this.f21848dH);
            this.f17515aj.setAlpha(this.f21850dJ);
            canvas.drawText(this.f21810cV, COUIBaseListPopupWindow_12, (this.f21763ba + f2) - this.f21849dI, this.f17515aj);
            canvas.drawBitmap(this.f21818cd.get(IntrinsicsJvm.kt_4.WIDE), COUIBaseListPopupWindow_12 - this.f21826cl, (f2 - this.f21827cm) + this.f21847dG, this.f21753bQ);
        } else {
            this.f21753bQ.setAlpha(255);
            canvas.drawBitmap(this.f21818cd.get(IntrinsicsJvm.kt_4.WIDE), COUIBaseListPopupWindow_12 - this.f21826cl, f2 - this.f21827cm, this.f21753bQ);
        }
        canvas.restore();
        if (this.f21736az) {
            canvas.save();
            canvas.translate(this.f21828cn - COUIBaseListPopupWindow_12, 0.0f);
            canvas.rotate(-this.f21721aV, COUIBaseListPopupWindow_12, f2);
            int i3 = ZoomSeekBar_4.f21885a[this.f21844dD.ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    this.f21753bQ.setAlpha(255);
                    canvas.drawBitmap(this.f21818cd.get(IntrinsicsJvm.kt_4.TELE), COUIBaseListPopupWindow_12 - this.f21830cp, f2 - this.f21831cq, this.f21753bQ);
                }
            } else if (slideToBarIndex == 3) {
                this.f21753bQ.setAlpha(this.f21850dJ);
                this.f17515aj.setAlpha(this.f21848dH);
                canvas.drawText(this.f21813cY, COUIBaseListPopupWindow_12, (this.f21763ba + f2) - this.f21847dG, this.f17515aj);
                canvas.drawBitmap(this.f21818cd.get(IntrinsicsJvm.kt_4.TELE), COUIBaseListPopupWindow_12 - this.f21826cl, (f2 - this.f21827cm) + this.f21849dI, this.f21753bQ);
            } else if (currentBarIndex == 3) {
                this.f21753bQ.setAlpha(this.f21848dH);
                this.f17515aj.setAlpha(this.f21850dJ);
                canvas.drawText(this.f21810cV, COUIBaseListPopupWindow_12, (this.f21763ba + f2) - this.f21849dI, this.f17515aj);
                canvas.drawBitmap(this.f21818cd.get(IntrinsicsJvm.kt_4.TELE), COUIBaseListPopupWindow_12 - this.f21826cl, (f2 - this.f21827cm) + this.f21847dG, this.f21753bQ);
            } else {
                this.f21753bQ.setAlpha(255);
                canvas.drawBitmap(this.f21818cd.get(IntrinsicsJvm.kt_4.TELE), COUIBaseListPopupWindow_12 - this.f21830cp, f2 - this.f21831cq, this.f21753bQ);
            }
            canvas.restore();
        }
        if (currentBarIndex == 1) {
            this.f21814cZ = this.f21824cj;
        } else if (currentBarIndex == 2) {
            this.f21814cZ = this.f21823ci;
        } else if (currentBarIndex == 3) {
            this.f21814cZ = this.f21828cn;
        }
        if (slideToBarIndex == 1) {
            this.f21860de = this.f21824cj;
        } else if (slideToBarIndex == 2) {
            this.f21860de = this.f21823ci;
        } else if (slideToBarIndex == 3) {
            this.f21860de = this.f21828cn;
        }
        float f4 = this.f21814cZ;
        this.f21856da = f4 - ((f4 - this.f21860de) * this.f21851dK);
        if (Float.compare(-1.0f, this.f17495N) != 0) {
            this.f21856da = this.f17495N - ((this.f17495N - this.f21860de) * this.f21851dK);
        }
        m23137a(canvas, this.f21856da, f2);
    }

    protected int getSlideToBarIndex() {
        return m23132a(this.f21716aQ, this.f21747bK);
    }

    protected int getCurrentBarIndex() {
        if (1 == this.f17500S || 2 == this.f17500S) {
            return m23132a(this.f21714aO, this.f21747bK);
        }
        if (9 == this.f17500S || 8 == this.f17500S) {
            return m23132a(this.f21715aP, this.f21747bK);
        }
        return m23132a(this.f21713aN, this.f21747bK);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected int m23131a(int OplusGLSurfaceView_13) {
        return m23132a(OplusGLSurfaceView_13, this.f21747bK);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected int m23132a(int OplusGLSurfaceView_13, ArrayList<Float> arrayList) {
        if (OplusGLSurfaceView_13 < 0 || arrayList == null || arrayList.size() <= OplusGLSurfaceView_13) {
            return 0;
        }
        float fFloatValue = arrayList.get(OplusGLSurfaceView_13).floatValue();
        if (Float.compare(fFloatValue, 1.0f) < 0) {
            return 1;
        }
        if (Float.compare(fFloatValue, 1.0f) < 0 || Float.compare(fFloatValue, 2.0f) >= 0) {
            return Float.compare(fFloatValue, 2.0f) >= 0 ? 3 : 0;
        }
        return 2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m23137a(Canvas canvas, float COUIBaseListPopupWindow_12, float f2) {
        canvas.drawCircle(COUIBaseListPopupWindow_12, f2, this.f21820cf, this.f21755bS);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m23138a(Canvas canvas, float COUIBaseListPopupWindow_12, float f2, float f3) {
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        int OplusGLSurfaceView_13 = this.f21833cs;
        if (OplusGLSurfaceView_13 == 1) {
            RectF rectF = this.f21816cb;
            float f10 = this.f21820cf;
            float f11 = this.f21822ch;
            rectF.left = ((COUIBaseListPopupWindow_12 - (f10 * 3.0f)) - f11) + (((f10 * 2.0f) + f11) * f3);
            rectF.top = f2 - f10;
            rectF.bottom = f2 + f10;
            rectF.right = ((COUIBaseListPopupWindow_12 + (3.0f * f10)) + f11) - (f3 * ((2.0f * f10) + f11));
            canvas.drawRoundRect(rectF, f10, f10, this.f21754bR);
        } else if (OplusGLSurfaceView_13 == 2) {
            RectF rectF2 = this.f21816cb;
            if (this.f21832cr) {
                float f12 = this.f21820cf;
                float f13 = this.f21822ch;
                f5 = (COUIBaseListPopupWindow_12 - (f12 * 3.0f)) - f13;
                f4 = f12 + f13;
            } else {
                f4 = this.f21820cf;
                f5 = COUIBaseListPopupWindow_12 - f4;
            }
            rectF2.left = f5 + (f4 * f3);
            RectF rectF3 = this.f21816cb;
            float f14 = this.f21820cf;
            rectF3.top = f2 - f14;
            rectF3.bottom = f2 + f14;
            if (this.f21832cr) {
                f6 = COUIBaseListPopupWindow_12 + f14;
            } else {
                float f15 = this.f21822ch;
                f6 = COUIBaseListPopupWindow_12 + (3.0f * f14) + f15;
                f14 += f15;
            }
            rectF3.right = f6 - (f3 * f14);
            RectF rectF4 = this.f21816cb;
            float f16 = this.f21820cf;
            canvas.drawRoundRect(rectF4, f16, f16, this.f21754bR);
        } else {
            if (OplusGLSurfaceView_13 != 3) {
                return;
            }
            RectF rectF5 = this.f21816cb;
            if (this.f21832cr) {
                float f17 = this.f21820cf;
                f8 = COUIBaseListPopupWindow_12 - f17;
                f7 = f17 + this.f21822ch;
            } else {
                f7 = this.f21820cf;
                f8 = (COUIBaseListPopupWindow_12 - (f7 * 3.0f)) - this.f21822ch;
            }
            rectF5.left = f8 + (f7 * f3);
            RectF rectF6 = this.f21816cb;
            float f18 = this.f21820cf;
            rectF6.top = f2 - f18;
            rectF6.bottom = f2 + f18;
            if (this.f21832cr) {
                f9 = COUIBaseListPopupWindow_12 + (3.0f * f18) + this.f21822ch;
            } else {
                f9 = COUIBaseListPopupWindow_12 + f18;
                f18 += this.f21822ch;
            }
            rectF6.right = f9 - (f3 * f18);
            RectF rectF7 = this.f21816cb;
            float f19 = this.f21820cf;
            canvas.drawRoundRect(rectF7, f19, f19, this.f21754bR);
        }
        if (this.f21852dL) {
            BackgroundSplitManager.m18430a(getContext()).m18444a(this, canvas, this.f21816cb, this.f21853dM);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraSeekBar
    /* renamed from: COUIBaseListPopupWindow_11 */
    protected void mo18529g(Canvas canvas) {
        if (0.0f >= this.f17549z) {
            m23164y();
        }
        super.mo18529g(canvas);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23133a(float COUIBaseListPopupWindow_12, boolean z) {
        float fM24201a = Util.m24201a(COUIBaseListPopupWindow_12, 0.0f, 1.0f);
        if (1 == getLayoutDirection()) {
            fM24201a = Util.m24200a(1.0f, fM24201a);
        }
        float fM23149c = m23149c(fM24201a);
        this.f21811cW = this.f21810cV;
        setCurrentDisplayText(fM23149c);
        if (this.f17517al != null) {
            this.f17517al.mo11548a(fM23149c, z);
        }
        setCenterPointIndex(m23156h(fM23149c));
        this.f21716aQ = this.f21713aN;
        CameraLog.m12954a("ZoomSeekBar", "onChanged, mCurrentDisplayText: " + this.f21810cV + ", zoom: " + fM23149c);
        StringBuilder sb = new StringBuilder();
        sb.append(getContext().getResources().getString(R.string.camera_description_zoom_seek_bar));
        sb.append(this.f21810cV);
        setContentDescription(sb.toString());
        invalidate();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private float m23102c(float COUIBaseListPopupWindow_12, float f2) {
        float fM24200a;
        float fMin = Math.min(COUIBaseListPopupWindow_12, f2);
        float fMax = Math.max(COUIBaseListPopupWindow_12, f2);
        if (Float.compare(fMin, fMax) == 0) {
            return -1.0f;
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f21748bL.length; OplusGLSurfaceView_13++) {
            if (1 == getLayoutDirection()) {
                float[] fArr = this.f21748bL;
                fM24200a = Util.m24200a(1.0f, fArr[(fArr.length - 1) - OplusGLSurfaceView_13]);
            } else {
                fM24200a = this.f21748bL[OplusGLSurfaceView_13];
            }
            if ((Float.compare(fM24200a, f2) > 0 && Float.compare(fM24200a, COUIBaseListPopupWindow_12) <= 0) || (Float.compare(fM24200a, f2) < 0 && Float.compare(fM24200a, COUIBaseListPopupWindow_12) >= 0)) {
                return fM24200a;
            }
            if (Float.compare(fM24200a, fMax) > 0) {
                return -1.0f;
            }
        }
        return -1.0f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Bitmap m23090a(IntrinsicsJvm.kt_4 bVar) {
        int iM23132a = m23132a(this.f21837cw, this.f21793cE);
        int OplusGLSurfaceView_13 = ZoomSeekBar_4.f21886b[bVar.ordinal()];
        if (OplusGLSurfaceView_13 != 1) {
            if (OplusGLSurfaceView_13 != 2) {
                if (OplusGLSurfaceView_13 == 3) {
                    if (!this.f21735ay) {
                        return null;
                    }
                    if (this.f21845dE == PlatformImplementations.kt_3.NORMAL && iM23132a == 3 && !this.f21774bl) {
                        return null;
                    }
                }
            } else if (this.f21845dE == PlatformImplementations.kt_3.NORMAL && iM23132a == 2 && !this.f21774bl) {
                return null;
            }
        } else {
            if (!this.f21700aA) {
                return null;
            }
            if (this.f21845dE == PlatformImplementations.kt_3.NORMAL && iM23132a == 1) {
                return null;
            }
        }
        return this.f21819ce.get(bVar);
    }

    /* compiled from: ZoomSeekBar.java */
    /* renamed from: com.oplus.camera.ui.preview.ai$3, reason: invalid class name */
    static /* synthetic */ class ZoomSeekBar_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        static final /* synthetic */ int[] f21885a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        static final /* synthetic */ int[] f21886b = new int[IntrinsicsJvm.kt_4.values().length];

        static {
            try {
                f21886b[IntrinsicsJvm.kt_4.ULTRA_WIDE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21886b[IntrinsicsJvm.kt_4.WIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f21886b[IntrinsicsJvm.kt_4.TELE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f21885a = new int[PlatformImplementations.kt_3.values().length];
            try {
                f21885a[PlatformImplementations.kt_3.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f21885a[PlatformImplementations.kt_3.ICON_ONLY.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Bitmap m23098b(IntrinsicsJvm.kt_4 bVar) {
        int iM23131a = m23131a(this.f21839cy);
        int OplusGLSurfaceView_13 = ZoomSeekBar_4.f21886b[bVar.ordinal()];
        if (OplusGLSurfaceView_13 != 1) {
            if (OplusGLSurfaceView_13 != 2) {
                if (OplusGLSurfaceView_13 == 3) {
                    if (!this.f21736az) {
                        return null;
                    }
                    if (this.f21844dD == PlatformImplementations.kt_3.NORMAL && iM23131a == 3 && !this.f21773bk) {
                        return null;
                    }
                }
            } else if (this.f21844dD == PlatformImplementations.kt_3.NORMAL && iM23131a == 2 && !this.f21773bk) {
                return null;
            }
        } else {
            if (!this.f21701aB) {
                return null;
            }
            if (this.f21844dD == PlatformImplementations.kt_3.NORMAL && iM23131a == 1) {
                return null;
            }
        }
        return this.f21818cd.get(bVar);
    }

    private float getOvalCenterX() {
        int currentBarIndex = getCurrentBarIndex();
        if (currentBarIndex == 1) {
            return this.f21824cj;
        }
        if (currentBarIndex == 2) {
            return this.f21823ci;
        }
        if (currentBarIndex == 3) {
            return this.f21828cn;
        }
        return this.f21823ci;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean m23104c(IntrinsicsJvm.kt_4 bVar) {
        return this.f21700aA && this.f21735ay;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean m23107d(IntrinsicsJvm.kt_4 bVar) {
        if (bVar != IntrinsicsJvm.kt_4.ULTRA_WIDE || this.f21701aB) {
            return bVar != IntrinsicsJvm.kt_4.TELE || this.f21736az;
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m23150c(int OplusGLSurfaceView_13, boolean z) {
        int i2;
        if (OplusGLSurfaceView_13 >= 0) {
            i2 = OplusGLSurfaceView_13 % 360;
        } else {
            i2 = (OplusGLSurfaceView_13 % 360) + 360;
        }
        if (i2 == this.f21723aX) {
            return;
        }
        this.f21723aX = i2;
        if (z) {
            this.f21722aW = this.f21721aV;
            this.f21869do = AnimationUtils.currentAnimationTimeMillis();
            int i3 = this.f21723aX - this.f21721aV;
            if (i3 < 0) {
                i3 += 360;
            }
            if (i3 > 180) {
                i3 -= 360;
            }
            this.f21770bh = i3 >= 0;
            this.f21870dp = this.f21869do + ((Math.abs(i3) * 1000) / 360);
        } else {
            this.f21721aV = this.f21723aX;
        }
        invalidate();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m23134a(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) {
        CameraLog.m12954a("ZoomSeekBar", "startSlideTo, centerPointIndex: " + OplusGLSurfaceView_13 + ", toValue: " + COUIBaseListPopupWindow_12);
        if ((m23129C() && OplusGLSurfaceView_13 == this.f21716aQ) || (!m23129C() && OplusGLSurfaceView_13 == this.f21713aN)) {
            if (this.f21810cV.equals(mo23074a(m23154f(COUIBaseListPopupWindow_12)))) {
                return;
            }
            m23145b(COUIBaseListPopupWindow_12, false);
            return;
        }
        if (9 == this.f17500S || 8 == this.f17500S || 10 == this.f17500S) {
            setCenterPointIndex(this.f21716aQ);
            this.f21811cW = this.f21810cV;
            setCurrentDisplayText(this.f21717aR);
            m23145b(this.f21718aS, false);
            return;
        }
        if ((!m23129C() && m23131a(OplusGLSurfaceView_13) == m23131a(this.f21713aN)) || OplusGLSurfaceView_13 == m23131a(OplusGLSurfaceView_13)) {
            setCenterPointIndex(OplusGLSurfaceView_13);
            if (this.f21810cV.equals(mo23074a(m23154f(COUIBaseListPopupWindow_12)))) {
                return;
            }
            m23145b(COUIBaseListPopupWindow_12, false);
            return;
        }
        if (this.f21861df.isRunning()) {
            this.f21861df.cancel();
            this.f17495N = this.f21856da;
        }
        this.f21725aZ = 0.0f;
        this.f21716aQ = OplusGLSurfaceView_13;
        this.f21717aR = COUIBaseListPopupWindow_12;
        this.f21718aS = COUIBaseListPopupWindow_12;
        this.f21814cZ = -1.0f;
        this.f21861df.start();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m23152d(int OplusGLSurfaceView_13, boolean z) {
        CameraLog.m12954a("ZoomSeekBar", "startSlideToWhenFront, centerPointIndex: " + OplusGLSurfaceView_13);
        boolean z2 = this.f21713aN != OplusGLSurfaceView_13;
        if (this.f21861df.isRunning()) {
            z2 = this.f21716aQ != OplusGLSurfaceView_13;
        }
        if (this.f17517al == null || -1 == OplusGLSurfaceView_13 || !z2) {
            return;
        }
        if (this.f21861df.isRunning()) {
            this.f21861df.cancel();
            this.f17495N = this.f21856da;
        }
        this.f21783bu = OplusGLSurfaceView_13 == 0 ? 1.0f : 1.17f;
        if (z) {
            this.f17517al.mo11547a(this.f21783bu);
        }
        this.f21725aZ = 0.0f;
        this.f21716aQ = OplusGLSurfaceView_13;
        this.f21814cZ = -1.0f;
        this.f21861df.start();
        this.f21808cT = true;
        this.f21717aR = 1.0f;
        this.f21718aS = 1.0f;
        invalidate();
    }

    /* renamed from: z */
    public boolean m23165z() {
        return getVisibility() == 0 && (3 == this.f17500S || 6 == this.f17500S);
    }

    /* renamed from: A */
    public boolean m23127A() {
        if (getVisibility() == 0) {
            return 2 == this.f17500S || 1 == this.f17500S;
        }
        return false;
    }

    /* renamed from: B */
    public boolean m23128B() {
        AnimatorSet animatorSet;
        return getVisibility() == 0 && this.f17500S == 0 && (animatorSet = this.f21861df) != null && animatorSet.isRunning();
    }

    public float getVelocityRate() {
        return this.f21730at;
    }

    /* renamed from: C */
    public boolean m23129C() {
        AnimatorSet animatorSet = this.f21861df;
        if (animatorSet != null) {
            return animatorSet.isRunning();
        }
        return false;
    }

    public void setZoomListener(ZoomListener interfaceC3436ag) {
        this.f21751bO = interfaceC3436ag;
    }

    public void setZoomValueUnit(boolean z) {
        CameraLog.m12954a("ZoomSeekBar", "setZoomValueUnit, zoomUnitvalue: " + z);
        this.f21778bp = z;
    }

    public boolean getZoomValueUnit() {
        CameraLog.m12954a("ZoomSeekBar", "getZoomValueUnit, mbZoomUnit: " + this.f21778bp);
        return this.f21778bp;
    }

    protected void setCenterPointIndex(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("ZoomSeekBar", "setCenterPointIndex, index: " + OplusGLSurfaceView_13);
        this.f21713aN = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m23145b(float COUIBaseListPopupWindow_12, boolean z) {
        CameraLog.m12954a("ZoomSeekBar", "updateUI, zoomValue: " + COUIBaseListPopupWindow_12 + ", rest: " + this.f21861df.isRunning());
        if (this.f21773bk) {
            return;
        }
        if (this.f21861df.isRunning()) {
            this.f21718aS = COUIBaseListPopupWindow_12;
            return;
        }
        if (z && m23127A()) {
            this.f17519an.removeMessages(1);
            this.f17519an.sendEmptyMessageDelayed(1, getCollapseDelay());
        }
        float fM23155g = m23155g(COUIBaseListPopupWindow_12);
        if (Float.compare(fM23155g, -0.042f) < 0) {
            fM23155g = -0.042f;
        } else if (Float.compare(fM23155g, 1.042f) > 0) {
            fM23155g = 1.042f;
        }
        if (1 == getLayoutDirection()) {
            setRate(1.0f - fM23155g);
        } else {
            setRate(fM23155g);
        }
        int iM23156h = m23156h(COUIBaseListPopupWindow_12);
        if (iM23156h != this.f21713aN) {
            if (this.f17500S == 0 && !this.f21751bO.mo11580e()) {
                m23134a(iM23156h, COUIBaseListPopupWindow_12);
                return;
            } else {
                setCenterPointIndex(iM23156h);
                this.f21716aQ = this.f21713aN;
            }
        }
        this.f21811cW = this.f21810cV;
        setCurrentDisplayText(COUIBaseListPopupWindow_12);
        CameraLog.m12954a("ZoomSeekBar", "updateUI, mCurrentDisplayText: " + this.f21810cV + ", rate: " + fM23155g);
        StringBuilder sb = new StringBuilder();
        sb.append(getContext().getResources().getString(R.string.camera_description_zoom_seek_bar));
        sb.append(this.f21810cV);
        setContentDescription(sb.toString());
        postInvalidate();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected boolean m23147b(float COUIBaseListPopupWindow_12) {
        int OplusGLSurfaceView_13 = 0;
        while (true) {
            float[] fArr = this.f21748bL;
            if (OplusGLSurfaceView_13 >= fArr.length) {
                return false;
            }
            if (Math.abs(COUIBaseListPopupWindow_12 - fArr[OplusGLSurfaceView_13]) <= 1.0E-5f) {
                return true;
            }
            OplusGLSurfaceView_13++;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public float m23144b(int OplusGLSurfaceView_13) {
        return this.f21747bK.get(OplusGLSurfaceView_13).floatValue();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public float m23149c(float COUIBaseListPopupWindow_12) {
        float fM23151d = m23151d(COUIBaseListPopupWindow_12);
        ArrayList<Integer> arrayList = this.f21787by;
        float fIntValue = arrayList.get(arrayList.size() - 1).intValue();
        if (fM23151d > fIntValue) {
            fM23151d = fIntValue;
        }
        float fFloatValue = 0.0f;
        int OplusGLSurfaceView_13 = 1;
        while (true) {
            if (OplusGLSurfaceView_13 >= this.f21784bv.size()) {
                break;
            }
            if (fM23151d <= this.f21787by.get(OplusGLSurfaceView_13).intValue()) {
                int i2 = OplusGLSurfaceView_13 - 1;
                fFloatValue = this.f21784bv.get(i2).floatValue() + (this.f21785bw.get(i2).floatValue() * (fM23151d - this.f21787by.get(i2).intValue()));
                break;
            }
            OplusGLSurfaceView_13++;
        }
        return Math.round(fFloatValue * 10000.0f) / 10000.0f;
    }

    public float getTotleAngle() {
        m23084I();
        m23085J();
        float fFloatValue = 0.0f;
        int OplusGLSurfaceView_13 = 0;
        while (OplusGLSurfaceView_13 < this.f21785bw.size()) {
            int i2 = OplusGLSurfaceView_13 + 1;
            fFloatValue += ((this.f21784bv.get(i2).floatValue() - this.f21784bv.get(OplusGLSurfaceView_13).floatValue()) / this.f21785bw.get(OplusGLSurfaceView_13).floatValue()) * this.f21786bx.get(OplusGLSurfaceView_13).floatValue();
            OplusGLSurfaceView_13 = i2;
        }
        return fFloatValue;
    }

    /* renamed from: I */
    private void m23084I() {
        if (this.f21784bv != null) {
            this.f21784bv = null;
        }
        this.f21784bv = getZoomSections();
    }

    /* renamed from: J */
    private void m23085J() {
        if (this.f21786bx != null) {
            this.f21786bx = null;
        }
        this.f21785bw = getSectionStep();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public float m23151d(float COUIBaseListPopupWindow_12) {
        float totleAngle = COUIBaseListPopupWindow_12 * getTotleAngle();
        float fFloatValue = 0.0f;
        int OplusGLSurfaceView_13 = 0;
        while (OplusGLSurfaceView_13 < this.f21785bw.size()) {
            int i2 = OplusGLSurfaceView_13 + 1;
            float fFloatValue2 = ((this.f21784bv.get(i2).floatValue() - this.f21784bv.get(OplusGLSurfaceView_13).floatValue()) / this.f21785bw.get(OplusGLSurfaceView_13).floatValue()) * this.f21786bx.get(OplusGLSurfaceView_13).floatValue();
            if (totleAngle <= fFloatValue2) {
                return fFloatValue + (totleAngle / this.f21786bx.get(OplusGLSurfaceView_13).floatValue());
            }
            totleAngle -= fFloatValue2;
            fFloatValue += (this.f21784bv.get(i2).floatValue() - this.f21784bv.get(OplusGLSurfaceView_13).floatValue()) / this.f21785bw.get(OplusGLSurfaceView_13).floatValue();
            OplusGLSurfaceView_13 = i2;
        }
        return fFloatValue;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public float m23153e(float COUIBaseListPopupWindow_12) {
        float totleAngle = getTotleAngle();
        m23085J();
        int OplusGLSurfaceView_13 = 0;
        float fFloatValue = 0.0f;
        while (true) {
            if (OplusGLSurfaceView_13 >= this.f21785bw.size()) {
                break;
            }
            int i2 = OplusGLSurfaceView_13 + 1;
            float fRound = Math.round((this.f21784bv.get(i2).floatValue() - this.f21784bv.get(OplusGLSurfaceView_13).floatValue()) / this.f21785bw.get(OplusGLSurfaceView_13).floatValue());
            if (COUIBaseListPopupWindow_12 <= fRound) {
                fFloatValue += COUIBaseListPopupWindow_12 * this.f21786bx.get(OplusGLSurfaceView_13).floatValue();
                break;
            }
            COUIBaseListPopupWindow_12 -= fRound;
            fFloatValue += fRound * this.f21786bx.get(OplusGLSurfaceView_13).floatValue();
            OplusGLSurfaceView_13 = i2;
        }
        float f2 = fFloatValue / totleAngle;
        if (Float.isNaN(f2)) {
            return 0.0f;
        }
        return f2;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public float m23154f(float COUIBaseListPopupWindow_12) {
        return ZoomManager.m11416a(COUIBaseListPopupWindow_12, this.f21749bM);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public float m23155g(float COUIBaseListPopupWindow_12) {
        float f2;
        if (this.f21784bv == null) {
            this.f21784bv = getZoomSections();
        }
        if (this.f21785bw == null) {
            this.f21785bw = getSectionStep();
        }
        if (this.f21787by == null) {
            this.f21787by = getIndicatorSections();
        }
        int OplusGLSurfaceView_13 = 1;
        while (true) {
            f2 = 0.0f;
            if (OplusGLSurfaceView_13 >= this.f21784bv.size()) {
                break;
            }
            if (COUIBaseListPopupWindow_12 <= this.f21784bv.get(OplusGLSurfaceView_13).floatValue()) {
                int i2 = OplusGLSurfaceView_13 - 1;
                float fFloatValue = (COUIBaseListPopupWindow_12 - this.f21784bv.get(i2).floatValue()) / (this.f21784bv.get(OplusGLSurfaceView_13).floatValue() - this.f21784bv.get(i2).floatValue());
                float fIntValue = this.f21787by.get(i2).intValue();
                float fIntValue2 = this.f21787by.get(OplusGLSurfaceView_13).intValue() - this.f21787by.get(i2).intValue();
                if (Float.isNaN(fFloatValue)) {
                    fFloatValue = 0.0f;
                }
                f2 = fIntValue + (fIntValue2 * fFloatValue);
            } else {
                OplusGLSurfaceView_13++;
            }
        }
        return m23153e(f2);
    }

    public float getCurrentZoom() {
        float fM23149c = m23149c(1 == getLayoutDirection() ? 1.0f - this.f17509ad : this.f17509ad);
        float COUIBaseListPopupWindow_12 = this.f21781bs;
        if (this.f21771bi) {
            COUIBaseListPopupWindow_12 = ZoomManager.f12334a;
        }
        if (fM23149c < COUIBaseListPopupWindow_12) {
            return COUIBaseListPopupWindow_12;
        }
        float f2 = this.f21782bt;
        return fM23149c > f2 ? f2 : fM23149c;
    }

    public ArrayList<Integer> getIndicatorSections() {
        int size = this.f21784bv.size();
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        for (int OplusGLSurfaceView_13 = 1; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            int i2 = OplusGLSurfaceView_13 - 1;
            arrayList.add(OplusGLSurfaceView_13, Integer.valueOf(Math.round((this.f21784bv.get(OplusGLSurfaceView_13).floatValue() - this.f21784bv.get(i2).floatValue()) / this.f21785bw.get(i2).floatValue()) + arrayList.get(i2).intValue()));
        }
        return arrayList;
    }

    public ArrayList<Float> getZoomSections() {
        ZoomListener interfaceC3436ag;
        ArrayList<Float> arrayList = new ArrayList<>();
        if (Float.compare(this.f21781bs, 1.0f) < 0) {
            arrayList.add(Float.valueOf(this.f21781bs));
        } else if (this.f21771bi) {
            arrayList.add(Float.valueOf(ZoomManager.f12334a));
        }
        if (Float.compare(this.f21781bs, 1.0f) <= 0) {
            arrayList.add(Float.valueOf(1.0f));
        }
        if (Float.compare(this.f21782bt, 4.0f) > 0) {
            arrayList.add(Float.valueOf(2.0f));
        }
        if (Float.compare(this.f21782bt, 4.0f) > 0 && (interfaceC3436ag = this.f21751bO) != null && Float.compare(interfaceC3436ag.mo11584i(), 0.0f) != 0) {
            float fMo11584i = this.f21751bO.mo11584i();
            if (Math.floor(fMo11584i * 10.0f) % 2.0d != 0.0d && Float.compare(fMo11584i, 2.0f) > 0 && Float.compare(fMo11584i, 5.0f) < 0) {
                arrayList.add(Float.valueOf((float) (Math.floor((fMo11584i - 0.1f) * 10.0f) / 10.0d)));
                arrayList.add(Float.valueOf(fMo11584i));
                arrayList.add(Float.valueOf((float) (Math.floor((fMo11584i + 0.1f) * 10.0f) / 10.0d)));
            }
        }
        if (Float.compare(this.f21782bt, 8.0f) > 0) {
            arrayList.add(Float.valueOf(5.0f));
        }
        if (Float.compare(this.f21782bt, 10.0f) > 0) {
            arrayList.add(Float.valueOf(10.0f));
        }
        if (Float.compare(this.f21782bt, 20.0f) > 0) {
            arrayList.add(Float.valueOf(20.0f));
        }
        arrayList.add(Float.valueOf(this.f21782bt));
        return arrayList;
    }

    protected ArrayList<Float> getSectionStep() {
        ZoomListener interfaceC3436ag;
        ArrayList<Float> arrayList = new ArrayList<>();
        this.f21786bx = new ArrayList<>();
        float COUIBaseListPopupWindow_12 = this.f21781bs;
        Float fValueOf = Float.valueOf(1.0f);
        int iCompare = Float.compare(COUIBaseListPopupWindow_12, 1.0f);
        Float fValueOf2 = Float.valueOf(0.1f);
        if (iCompare < 0 || this.f21771bi) {
            arrayList.add(fValueOf2);
            this.f21786bx.add(Float.valueOf(getIncreaseSpace() + 4.0540543f));
        }
        if (Float.compare(this.f21781bs, 1.0f) <= 0) {
            arrayList.add(fValueOf2);
            this.f21786bx.add(Float.valueOf(getIncreaseSpace() + 2.7027028f));
        }
        if (Float.compare(this.f21782bt, 4.0f) > 0) {
            arrayList.add(Float.valueOf(0.2f));
            this.f21786bx.add(Float.valueOf(getIncreaseSpace() + 2.0270271f));
        }
        if (Float.compare(this.f21782bt, 4.0f) > 0 && (interfaceC3436ag = this.f21751bO) != null && Float.compare(interfaceC3436ag.mo11584i(), 0.0f) != 0) {
            float fMo11584i = this.f21751bO.mo11584i();
            if (Math.floor(fMo11584i * 10.0f) % 2.0d != 0.0d && Float.compare(fMo11584i, 2.0f) > 0 && Float.compare(fMo11584i, 5.0f) < 0) {
                arrayList.add(fValueOf2);
                this.f21786bx.add(Float.valueOf(getIncreaseSpace() + 2.0270271f));
                arrayList.add(fValueOf2);
                this.f21786bx.add(Float.valueOf(getIncreaseSpace() + 2.0270271f));
                arrayList.add(Float.valueOf(0.2f));
                this.f21786bx.add(Float.valueOf(getIncreaseSpace() + 2.0270271f));
            }
        }
        if (Float.compare(this.f21782bt, 8.0f) > 0) {
            arrayList.add(Float.valueOf(0.2f));
            this.f21786bx.add(Float.valueOf(getIncreaseSpace() + 1.3513514f));
        }
        if (Float.compare(this.f21782bt, 10.0f) > 0) {
            if (Float.compare(this.f21782bt, 30.0f) > 0) {
                arrayList.add(Float.valueOf(2.0f));
                arrayList.add(Float.valueOf(2.0f));
                this.f21786bx.add(Float.valueOf(getIncreaseSpace() + 1.0810812f));
                this.f21786bx.add(Float.valueOf(getIncreaseSpace() + 1.0810812f));
            } else if (Float.compare(this.f21782bt, 20.0f) > 0) {
                arrayList.add(fValueOf);
                arrayList.add(fValueOf);
                this.f21786bx.add(Float.valueOf(getIncreaseSpace() + 1.0810812f));
                this.f21786bx.add(Float.valueOf(getIncreaseSpace() + 1.0810812f));
            } else {
                arrayList.add(Float.valueOf(0.5f));
                this.f21786bx.add(Float.valueOf(getIncreaseSpace() + 1.0810812f));
            }
        }
        return arrayList;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected boolean m23143a(float COUIBaseListPopupWindow_12, float f2, float f3, float f4, float f5) {
        return ((float) ((int) Math.sqrt(Math.pow((double) Math.abs(f3 - COUIBaseListPopupWindow_12), 2.0d) + Math.pow((double) Math.abs(f4 - f2), 2.0d)))) <= f5;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    protected int m23156h(float COUIBaseListPopupWindow_12) {
        int OplusGLSurfaceView_13 = 0;
        for (int i2 = 0; i2 < this.f21747bK.size() && Float.compare(this.f21747bK.get(i2).floatValue(), COUIBaseListPopupWindow_12) <= 0; i2++) {
            OplusGLSurfaceView_13 = i2;
        }
        return OplusGLSurfaceView_13;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    protected float m23157i(float COUIBaseListPopupWindow_12) {
        return Float.compare(COUIBaseListPopupWindow_12, 5.0f) > 0 ? 1.1f : 1.8f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m23140a(Canvas canvas, Drawable drawable, float COUIBaseListPopupWindow_12, float f2, float f3, int OplusGLSurfaceView_13) {
        float intrinsicWidth = ((drawable.getIntrinsicWidth() * f3) * 1.0f) / 2.0f;
        float intrinsicHeight = ((drawable.getIntrinsicHeight() * f3) * 1.0f) / 2.0f;
        drawable.setBounds((int) (COUIBaseListPopupWindow_12 - intrinsicWidth), (int) (f2 - intrinsicHeight), (int) (COUIBaseListPopupWindow_12 + intrinsicWidth), (int) (f2 + intrinsicHeight));
        drawable.setAlpha(OplusGLSurfaceView_13);
        drawable.draw(canvas);
    }

    public void setZoomClickVisibility(int OplusGLSurfaceView_13) {
        this.f21779bq = OplusGLSurfaceView_13;
    }

    /* compiled from: ZoomSeekBar.java */
    /* renamed from: com.oplus.camera.ui.preview.ai$IntrinsicsJvm.kt_3 */
    protected class IntrinsicsJvm.kt_3 implements GestureDetector.OnGestureListener {
        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float COUIBaseListPopupWindow_12, float f2) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
        }

        protected IntrinsicsJvm.kt_3() {
        }

        /* JADX WARN: Removed duplicated region for block: B:41:0x0136  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0161  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x016d  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0173  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x0175  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0180  */
        @Override // android.view.GestureDetector.OnGestureListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onSingleTapUp(android.view.MotionEvent r13) {
            /*
                Method dump skipped, instructions count: 482
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.preview.ZoomSeekBar.IntrinsicsJvm.kt_3.onSingleTapUp(android.view.MotionEvent):boolean");
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float COUIBaseListPopupWindow_12, float f2) {
            if (ZoomSeekBar.this.f21751bO.mo11577b() && motionEvent != null) {
                if (ZoomSeekBar.this.f17500S == 0) {
                    if (f2 >= 10.0f) {
                        ZoomSeekBar.this.mo18521c(false);
                        ZoomSeekBar.this.f21808cT = true;
                    } else if ((f2 < 10.0f && f2 >= 0.0f) || Math.abs(f2) / Math.abs(COUIBaseListPopupWindow_12) < ZoomSeekBar.this.m23119l(30.0f)) {
                        ZoomSeekBar.this.mo18521c(true);
                        ZoomSeekBar.this.f21808cT = true;
                    }
                } else if (2 == ZoomSeekBar.this.f17500S && f2 < 0.0f && Math.abs(f2) > 10.0f && Math.abs(COUIBaseListPopupWindow_12) / Math.abs(f2) < ZoomSeekBar.this.m23119l(15.0f) && motionEvent.getY() < ZoomSeekBar.this.getHeight() * 1.0f) {
                    ZoomSeekBar.this.mo18518b(false);
                    ZoomSeekBar.this.f21808cT = true;
                }
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (ZoomSeekBar.this.f17500S == 0 && ZoomSeekBar.this.f21769bg) {
                CameraLog.m12954a("ZoomSeekBar", "MyGestureListener, onLongPress to performExpand");
                ZoomSeekBar.this.mo18521c(false);
                ZoomSeekBar.this.f21808cT = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_14 */
    public double m23119l(float COUIBaseListPopupWindow_12) {
        return Math.tan((COUIBaseListPopupWindow_12 * 3.141592653589793d) / 180.0d);
    }

    public String getCurrentDisplayText() {
        return this.f21810cV;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String mo23074a(float COUIBaseListPopupWindow_12) {
        return this.f21752bP.m11590a(getZoomValueUnit(), COUIBaseListPopupWindow_12);
    }

    /* renamed from: K */
    private void m23086K() {
        if (this.f21861df == null) {
            this.f21861df = new AnimatorSet();
            this.f21861df.play(getEnterAnimator()).with(getExitAnimator()).with(getSlideBarAnimator());
            this.f21861df.addListener(new Animator.AnimatorListener() { // from class: com.oplus.camera.ui.preview.ai.7
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    ZoomSeekBar.this.mo18536k();
                    ZoomSeekBar abstractC3438ai = ZoomSeekBar.this;
                    abstractC3438ai.f21813cY = abstractC3438ai.mo23074a(abstractC3438ai.m23154f(abstractC3438ai.f21717aR));
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    ZoomSeekBar abstractC3438ai = ZoomSeekBar.this;
                    abstractC3438ai.setCenterPointIndex(abstractC3438ai.f21716aQ);
                    ZoomSeekBar abstractC3438ai2 = ZoomSeekBar.this;
                    abstractC3438ai2.f21811cW = abstractC3438ai2.f21810cV;
                    ZoomSeekBar abstractC3438ai3 = ZoomSeekBar.this;
                    abstractC3438ai3.setCurrentDisplayText(abstractC3438ai3.f21717aR);
                    ZoomSeekBar abstractC3438ai4 = ZoomSeekBar.this;
                    abstractC3438ai4.m23145b(abstractC3438ai4.f21718aS, false);
                    ZoomSeekBar.this.mo18536k();
                    ZoomSeekBar.this.f17495N = -1.0f;
                }
            });
        }
    }

    private Animator getSlideBarAnimator() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.01f, 1.0f);
        valueAnimatorOfFloat.setDuration(400L);
        valueAnimatorOfFloat.setInterpolator(this.f21854dN);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.preview.ai.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ZoomSeekBar.this.f21851dK = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ZoomSeekBar.this.invalidate();
            }
        });
        return valueAnimatorOfFloat;
    }

    private Animator getEnterAnimator() {
        AnimatorSet animatorSet = new AnimatorSet();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f21846dF, 0.0f);
        valueAnimatorOfFloat.setDuration(400L);
        valueAnimatorOfFloat.setStartDelay(100L);
        valueAnimatorOfFloat.setInterpolator(this.f21854dN);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.preview.ai.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ZoomSeekBar.this.f21847dG = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ZoomSeekBar.this.invalidate();
                if (0.0f == ZoomSeekBar.this.f21718aS || ZoomSeekBar.this.f21751bO == null || !ZoomSeekBar.this.f21751bO.mo11585j()) {
                    return;
                }
                ZoomSeekBar abstractC3438ai = ZoomSeekBar.this;
                abstractC3438ai.setCurrentDisplayText(abstractC3438ai.f21718aS);
            }
        });
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 255);
        valueAnimatorOfInt.setDuration(400L);
        valueAnimatorOfInt.setStartDelay(100L);
        valueAnimatorOfInt.setInterpolator(this.f21855dO);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.preview.ai.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ZoomSeekBar.this.f21848dH = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ZoomSeekBar.this.invalidate();
            }
        });
        animatorSet.play(valueAnimatorOfFloat).with(valueAnimatorOfInt);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentDisplayText(float COUIBaseListPopupWindow_12) {
        String strMo23074a = mo23074a(m23154f(COUIBaseListPopupWindow_12));
        CameraLog.m12959b("ZoomSeekBar", "setCurrentDisplayText: " + this.f21810cV + " -> " + strMo23074a);
        this.f21810cV = strMo23074a;
    }

    private Animator getExitAnimator() {
        AnimatorSet animatorSet = new AnimatorSet();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, this.f21846dF);
        valueAnimatorOfFloat.setDuration(400L);
        valueAnimatorOfFloat.setInterpolator(this.f21854dN);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.preview.ai.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ZoomSeekBar.this.f21849dI = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ZoomSeekBar.this.invalidate();
            }
        });
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(255, 0);
        valueAnimatorOfInt.setDuration(250L);
        valueAnimatorOfInt.setInterpolator(this.f21855dO);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.preview.ai.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ZoomSeekBar.this.f21850dJ = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ZoomSeekBar.this.invalidate();
            }
        });
        animatorSet.play(valueAnimatorOfFloat).with(valueAnimatorOfInt);
        return animatorSet;
    }

    public float[] getUltraWideZoomDotViewLocation() {
        ArrayList<Float> arrayList;
        if (3 < this.f21713aN || (arrayList = this.f21747bK) == null || !arrayList.contains(Float.valueOf(ZoomManager.f12334a))) {
            return null;
        }
        return new float[]{this.f21824cj, this.f17512ag - this.f21705aF};
    }

    @Override // android.view.View
    protected void onSizeChanged(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        super.onSizeChanged(OplusGLSurfaceView_13, i2, i3, i4);
        this.f21873ds = new int[2];
        getLocationOnScreen(this.f21873ds);
    }

    public int getFocusCircleRadius() {
        return this.f21705aF;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m23148b(MotionEvent motionEvent) {
        int[] iArr;
        return getParent() != null && getVisibility() == 0 && (iArr = this.f21873ds) != null && 2 <= iArr.length && motionEvent.getRawY() > ((float) this.f21873ds[1]) && Math.abs(this.f17512ag - (motionEvent.getRawY() - ((float) this.f21873ds[1]))) <= (((float) this.f21872dr) * 1.0f) / 2.0f;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public String m23158j(float COUIBaseListPopupWindow_12) {
        return mo23074a(m23154f(COUIBaseListPopupWindow_12));
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public String m23159k(float COUIBaseListPopupWindow_12) {
        return mo23074a(m23154f(COUIBaseListPopupWindow_12));
    }

    /* renamed from: D */
    public void m23130D() {
        ArrayList<Float> arrayList = this.f21878dx;
        if (arrayList == null || arrayList.size() == 0 || this.f21748bL == null) {
            return;
        }
        this.f21748bL = null;
        this.f21748bL = new float[this.f21878dx.size()];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f21748bL.length; OplusGLSurfaceView_13++) {
            this.f21748bL[OplusGLSurfaceView_13] = m23155g(this.f21878dx.get(OplusGLSurfaceView_13).floatValue());
        }
    }

    private float getIncreaseSpace() {
        return this.f17498Q;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        BackgroundSplitManager.m18430a(getContext()).m18442a(this);
        super.onDetachedFromWindow();
    }

    public String getSlideToDisplayText() {
        return this.f21813cY;
    }
}
