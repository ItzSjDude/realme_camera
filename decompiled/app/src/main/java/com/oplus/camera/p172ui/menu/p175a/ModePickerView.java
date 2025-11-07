package com.oplus.camera.p172ui.menu.p175a;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.PathInterpolator;
import com.oplus.camera.CameraLog;
import com.oplus.camera.DimenConstants;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.CameraUIListener;
import com.oplus.camera.p172ui.inverse.InverseManager;
import com.oplus.camera.p172ui.inverse.InverseAble;
import com.oplus.camera.screen.p164b.BaseScreenMode;
import com.oplus.camera.util.Util;
import com.p078a.p079a.SimpleSpringListener;
import com.p078a.p079a.Spring;
import com.p078a.p079a.SpringConfig;
import com.p078a.p079a.SpringSystem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: ModePickerView.java */
/* renamed from: com.oplus.camera.ui.menu.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class ModePickerView extends View implements InverseAble {

    /* renamed from: A */
    private int f19024A;

    /* renamed from: B */
    private int f19025B;

    /* renamed from: C */
    private int f19026C;

    /* renamed from: D */
    private int f19027D;

    /* renamed from: E */
    private int f19028E;

    /* renamed from: F */
    private int f19029F;

    /* renamed from: G */
    private int f19030G;

    /* renamed from: H */
    private int f19031H;

    /* renamed from: I */
    private int f19032I;

    /* renamed from: J */
    private int f19033J;

    /* renamed from: K */
    private int f19034K;

    /* renamed from: L */
    private int f19035L;

    /* renamed from: M */
    private int f19036M;

    /* renamed from: N */
    private int f19037N;

    /* renamed from: O */
    private int f19038O;

    /* renamed from: P */
    private float f19039P;

    /* renamed from: Q */
    private float f19040Q;

    /* renamed from: R */
    private float f19041R;

    /* renamed from: S */
    private float f19042S;

    /* renamed from: T */
    private float f19043T;

    /* renamed from: U */
    private Spring f19044U;

    /* renamed from: V */
    private String[] f19045V;

    /* renamed from: W */
    private float[] f19046W;

    /* renamed from: PlatformImplementations.kt_3 */
    private final Object f19047a;

    /* renamed from: aA */
    private boolean f19048aA;

    /* renamed from: aB */
    private boolean f19049aB;

    /* renamed from: aC */
    private boolean f19050aC;

    /* renamed from: aD */
    private boolean f19051aD;

    /* renamed from: aE */
    private Paint f19052aE;

    /* renamed from: aF */
    private GestureDetector f19053aF;

    /* renamed from: aG */
    private COUIBaseListPopupWindow_8 f19054aG;

    /* renamed from: aH */
    private ArrangeAnim f19055aH;

    /* renamed from: aI */
    private float f19056aI;

    /* renamed from: aJ */
    private boolean f19057aJ;

    /* renamed from: aK */
    private int f19058aK;

    /* renamed from: aL */
    private boolean f19059aL;

    /* renamed from: aM */
    private int f19060aM;

    /* renamed from: aN */
    private float f19061aN;

    /* renamed from: aO */
    private int f19062aO;

    /* renamed from: aP */
    private BaseScreenMode f19063aP;

    /* renamed from: aQ */
    private boolean f19064aQ;

    /* renamed from: aa */
    private float[] f19065aa;

    /* renamed from: ab */
    private Context f19066ab;

    /* renamed from: ac */
    private HeadlineBackground f19067ac;

    /* renamed from: ad */
    private int f19068ad;

    /* renamed from: ae */
    private int f19069ae;

    /* renamed from: af */
    private int f19070af;

    /* renamed from: ag */
    private float[] f19071ag;

    /* renamed from: ah */
    private float[] f19072ah;

    /* renamed from: ai */
    private boolean f19073ai;

    /* renamed from: aj */
    private int f19074aj;

    /* renamed from: ak */
    private int f19075ak;

    /* renamed from: al */
    private int f19076al;

    /* renamed from: am */
    private int f19077am;

    /* renamed from: an */
    private int f19078an;

    /* renamed from: ao */
    private int f19079ao;

    /* renamed from: ap */
    private int f19080ap;

    /* renamed from: aq */
    private int f19081aq;

    /* renamed from: ar */
    private int f19082ar;

    /* renamed from: as */
    private float f19083as;

    /* renamed from: at */
    private float f19084at;

    /* renamed from: au */
    private int f19085au;

    /* renamed from: av */
    private int f19086av;

    /* renamed from: aw */
    private float f19087aw;

    /* renamed from: ax */
    private float f19088ax;

    /* renamed from: ay */
    private int f19089ay;

    /* renamed from: az */
    private boolean f19090az;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Object f19091b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final Object f19092c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final ArrayList<String> f19093d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private volatile int f19094e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private volatile int f19095f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private volatile boolean f19096g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private CameraUIListener f19097h;

    /* renamed from: OplusGLSurfaceView_13 */
    private ValueAnimator f19098i;

    /* renamed from: OplusGLSurfaceView_15 */
    private ValueAnimator f19099j;

    /* renamed from: OplusGLSurfaceView_5 */
    private ValueAnimator f19100k;

    /* renamed from: OplusGLSurfaceView_14 */
    private PathInterpolator f19101l;

    /* renamed from: OplusGLSurfaceView_6 */
    private PathInterpolator f19102m;

    /* renamed from: OplusGLSurfaceView_11 */
    private PathInterpolator f19103n;

    /* renamed from: o */
    private float[] f19104o;

    /* renamed from: p */
    private TextPaint f19105p;

    /* renamed from: q */
    private TextPaint f19106q;

    /* renamed from: r */
    private TextPaint f19107r;

    /* renamed from: s */
    private String[] f19108s;

    /* renamed from: t */
    private Drawable f19109t;

    /* renamed from: u */
    private float f19110u;

    /* renamed from: v */
    private float f19111v;

    /* renamed from: w */
    private float f19112w;

    /* renamed from: x */
    private float f19113x;

    /* renamed from: y */
    private float f19114y;

    /* renamed from: z */
    private float f19115z;

    /* compiled from: ModePickerView.java */
    /* renamed from: com.oplus.camera.ui.menu.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8$COUIBaseListPopupWindow_8 */
    public interface COUIBaseListPopupWindow_8 {
        /* renamed from: X */
        boolean mo19074X();

        /* renamed from: Y */
        boolean mo19075Y();

        /* renamed from: Z */
        boolean mo19076Z();

        /* renamed from: ay */
        void mo19138ay();

        /* renamed from: az */
        boolean mo19139az();

        /* renamed from: o */
        void mo19198o(int OplusGLSurfaceView_13);

        /* renamed from: p */
        boolean mo19202p(int OplusGLSurfaceView_13);
    }

    public ModePickerView(Context context, CameraUIListener cameraUIListener) {
        super(context);
        this.f19047a = new Object();
        this.f19091b = new Object();
        this.f19092c = new Object();
        this.f19093d = new ArrayList<>();
        this.f19094e = 0;
        this.f19095f = 0;
        this.f19096g = true;
        this.f19097h = null;
        this.f19098i = null;
        this.f19099j = null;
        this.f19100k = null;
        this.f19101l = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.f19102m = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f19103n = new PathInterpolator(0.2f, 0.0f, 0.0f, 1.0f);
        this.f19104o = null;
        this.f19105p = null;
        this.f19106q = null;
        this.f19107r = null;
        this.f19108s = null;
        this.f19109t = null;
        this.f19110u = 0.0f;
        this.f19111v = 0.0f;
        this.f19112w = 0.0f;
        this.f19113x = 0.0f;
        this.f19114y = 0.0f;
        this.f19115z = 0.0f;
        this.f19024A = 0;
        this.f19025B = 1;
        this.f19026C = 0;
        this.f19027D = 0;
        this.f19028E = 0;
        this.f19029F = 0;
        this.f19030G = 0;
        this.f19031H = 0;
        this.f19032I = 0;
        this.f19033J = -1;
        this.f19034K = 0;
        this.f19035L = 0;
        this.f19036M = 0;
        this.f19037N = 0;
        this.f19038O = 0;
        this.f19039P = 0.0f;
        this.f19040Q = 1.0f;
        this.f19041R = 0.0f;
        this.f19042S = 0.0f;
        this.f19043T = 0.0f;
        this.f19044U = null;
        this.f19045V = null;
        this.f19046W = null;
        this.f19065aa = null;
        this.f19067ac = null;
        this.f19068ad = 0;
        this.f19069ae = 255;
        this.f19070af = 255;
        this.f19071ag = null;
        this.f19072ah = null;
        this.f19073ai = false;
        this.f19074aj = 0;
        this.f19075ak = 0;
        this.f19076al = 0;
        this.f19077am = 0;
        this.f19078an = 0;
        this.f19079ao = 0;
        this.f19080ap = 0;
        this.f19081aq = 0;
        this.f19082ar = 0;
        this.f19083as = 0.0f;
        this.f19084at = 0.0f;
        this.f19085au = 0;
        this.f19086av = 0;
        this.f19087aw = 0.0f;
        this.f19088ax = 0.0f;
        this.f19089ay = -1;
        this.f19090az = false;
        this.f19048aA = false;
        this.f19049aB = true;
        this.f19050aC = false;
        this.f19051aD = true;
        this.f19052aE = null;
        this.f19053aF = null;
        this.f19054aG = null;
        this.f19055aH = null;
        this.f19056aI = 0.0f;
        this.f19057aJ = true;
        this.f19058aK = 0;
        this.f19059aL = false;
        this.f19060aM = 255;
        this.f19061aN = 0.0f;
        this.f19062aO = 0;
        this.f19063aP = null;
        this.f19064aQ = false;
        this.f19066ab = context;
        this.f19032I = this.f19066ab.getResources().getDimensionPixelSize(R.dimen.headline_item_extra_touch_offset);
        this.f19097h = cameraUIListener;
    }

    public void setListener(COUIBaseListPopupWindow_8 eVar) {
        this.f19054aG = eVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20428a(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        this.f19025B = OplusGLSurfaceView_13;
        int previewFrameWidth = getPreviewFrameWidth();
        int iM24192T = Util.m24192T();
        this.f19075ak = (int) Util.m24456h(R.dimen.headline_item_gap);
        if (Util.m24349al()) {
            this.f19076al = (int) Util.m24456h(R.dimen.max_seven_mode_headline_item_gap);
            this.f19077am = this.f19075ak;
        }
        if (1 == this.f19062aO) {
            previewFrameWidth = getResources().getDimensionPixelSize(R.dimen.vertical_headline_width);
            iM24192T = getResources().getDimensionPixelSize(R.dimen.vertical_headline_text_height);
            this.f19075ak = getResources().getDimensionPixelSize(R.dimen.vertical_headline_item_gap);
            this.f19078an = getResources().getDimensionPixelSize(R.dimen.vertical_headline_item_gap_offset);
            this.f19036M = getResources().getDimensionPixelOffset(R.dimen.vertical_headline_double_line_background_height);
            this.f19037N = getResources().getDimensionPixelOffset(R.dimen.vertical_headline_double_line_text_height);
            this.f19079ao = getResources().getDimensionPixelOffset(R.dimen.vertical_headline_text_max_width);
        }
        this.f19074aj = this.f19066ab.getColor(R.color.inverse_text_color);
        InverseManager.INS.registerInverse(this.f19066ab, this);
        this.f19109t = this.f19066ab.getDrawable(R.drawable.mode_edit);
        this.f19026C = (int) Util.m24456h(R.dimen.mode_edit_icon_size);
        this.f19027D = this.f19066ab.getResources().getDimensionPixelSize(R.dimen.mode_edit_icon_touch_size);
        this.f19034K = (int) Util.m24456h(R.dimen.head_line_background_height);
        this.f19029F = (int) Util.m24456h(R.dimen.mode_edit_icon_margin_right);
        this.f19028E = (int) Util.m24456h(R.dimen.mode_edit_icon_margin_top);
        this.f19089ay = iM24192T;
        this.f19033J = previewFrameWidth;
        float f2 = iM24192T;
        this.f19083as = f2 / 2.0f;
        float f3 = this.f19083as;
        this.f19087aw = previewFrameWidth / f3;
        this.f19088ax = f2 / f3;
        this.f19084at = (float) (this.f19087aw / Math.sin(Math.toRadians(22.5d)));
        this.f19085au = (int) (this.f19084at * Math.toRadians(126.0d) * this.f19083as);
        this.f19086av = this.f19089ay;
        if (1 == this.f19062aO) {
            this.f19053aF = new GestureDetector(getContext(), new IntrinsicsJvm.kt_5());
        } else {
            this.f19053aF = new GestureDetector(getContext(), new PlatformImplementations.kt_3());
        }
        this.f19030G = (int) Util.m24456h(R.dimen.mode_edit_icon_red_dot_xoffset);
        this.f19031H = (int) Util.m24456h(R.dimen.mode_edit_icon_red_dot_yoffset);
        this.f19105p = new TextPaint();
        this.f19106q = new TextPaint();
        this.f19107r = new TextPaint();
        this.f19052aE = new Paint();
        m20427a();
        m20419q();
        this.f19058aK = getResources().getDimensionPixelSize(R.dimen.headline_change_move_distance);
    }

    public void setHeadlineBackground(HeadlineBackground c3236b) {
        this.f19067ac = c3236b;
        HeadlineBackground c3236b2 = this.f19067ac;
        if (c3236b2 != null) {
            c3236b2.m20342a(this);
        }
    }

    /* renamed from: p */
    private void m20417p() {
        if (this.f19055aH != null) {
            return;
        }
        this.f19055aH = new ArrangeAnim(this.f19067ac, this, this.f19106q);
        this.f19055aH.m20321a(this.f19062aO);
        this.f19055aH.m20325a(new Animator.AnimatorListener() { // from class: com.oplus.camera.ui.menu.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ModePickerView.this.f19067ac.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ModePickerView.this.f19051aD = false;
                ModePickerView.this.setArrangeAlpha(0);
                ModePickerView.this.setRotateMode(2);
                ModePickerView c3239e = ModePickerView.this;
                c3239e.m20368a(c3239e.f19106q);
                ModePickerView.this.invalidate();
                Runnable runnableM20319a = ModePickerView.this.f19055aH.m20319a();
                if (runnableM20319a != null) {
                    runnableM20319a.run();
                }
            }
        });
        this.f19055aH.m20330b(new Animator.AnimatorListener() { // from class: com.oplus.camera.ui.menu.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ModePickerView.this.f19051aD = true;
                if (Util.m24495t() && ModePickerView.this.f19097h != null && ModePickerView.this.f19097h.mo10780bW()) {
                    return;
                }
                ModePickerView.this.f19067ac.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (ModePickerView.this.f19097h == null || !(ModePickerView.this.f19097h.mo10791bh() || ModePickerView.this.f19097h.mo10788be())) {
                    ModePickerView.this.setRotateMode(2);
                    ModePickerView c3239e = ModePickerView.this;
                    c3239e.m20368a(c3239e.f19106q);
                    ModePickerView.this.invalidate();
                    ModePickerView.this.setClipToOutline(true);
                    ModePickerView.this.f19067ac.setVisibility(0);
                }
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20427a() throws Resources.NotFoundException {
        this.f19052aE.setAntiAlias(true);
        this.f19052aE.setColor(this.f19066ab.getResources().getColor(R.color.camera_red_dot_hint_color, null));
    }

    /* renamed from: q */
    private void m20419q() throws Resources.NotFoundException {
        this.f19106q.reset();
        if (!this.f19073ai) {
            int color = getResources().getColor(R.color.num_seekbar_thumb_text_shadow_color, null);
            if (this.f19059aL) {
                color = Color.argb(Math.round(this.f19040Q * Color.alpha(color)), Color.red(color), Color.green(color), Color.blue(color));
            }
            this.f19106q.setShadowLayer(getResources().getDimensionPixelSize(R.dimen.video_clip_view_thumb_text_shadow_radius), 0.0f, getResources().getDimensionPixelSize(R.dimen.video_clip_view_thumb_text_shadow_y), color);
        }
        this.f19106q.setAntiAlias(true);
        this.f19106q.setTextSize(DimenConstants.m14495m());
        this.f19106q.setTypeface(Util.m24411c(true));
        this.f19106q.setColor(this.f19073ai ? this.f19074aj : -1);
        this.f19106q.setTextAlign(Paint.Align.CENTER);
        this.f19105p.setAntiAlias(true);
        this.f19105p.setTextSize(DimenConstants.m14495m());
        this.f19105p.setTypeface(Util.m24411c(true));
        this.f19105p.setColor(this.f19073ai ? this.f19074aj : -1);
        this.f19105p.setTextAlign(Paint.Align.CENTER);
        this.f19105p.setShadowLayer(getResources().getDimensionPixelSize(R.dimen.video_clip_view_thumb_text_shadow_radius), 0.0f, getResources().getDimensionPixelSize(R.dimen.video_clip_view_thumb_text_shadow_y), getResources().getColor(R.color.num_seekbar_thumb_text_shadow_color, null));
    }

    /* renamed from: r */
    private void m20420r() {
        this.f19107r.setAntiAlias(true);
        this.f19107r.setTextSize(DimenConstants.m14495m());
        this.f19107r.setTypeface(Util.m24411c(true));
        this.f19107r.setColor(this.f19073ai ? this.f19066ab.getColor(R.color.camera_white) : this.f19066ab.getColor(R.color.background_color));
        this.f19107r.setTextAlign(Paint.Align.CENTER);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m20370a(String[] strArr) {
        CameraLog.m12954a("ModePickerView", "updateTextArray, textArray: " + Arrays.toString(strArr));
        if (strArr == null || strArr.length <= 0) {
            throw new IllegalArgumentException("the text array can't be null or it's length can't be 0");
        }
        synchronized (this.f19091b) {
            this.f19045V = strArr;
        }
        String[] strArr2 = this.f19045V;
        this.f19104o = new float[strArr2.length + 1];
        this.f19046W = new float[strArr2.length + 1];
        this.f19065aa = new float[strArr2.length + 1];
        m20368a(this.f19106q);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20438a(List<Integer> list, int OplusGLSurfaceView_13) {
        CameraLog.m12954a("ModePickerView", "updateText, textIdList: " + list + ", currentIndex: " + OplusGLSurfaceView_13);
        if (list == null || list.size() <= 0 || OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 >= list.size()) {
            CameraLog.m12967f("ModePickerView", "updateText, the parameter is illegal");
            return;
        }
        synchronized (this.f19092c) {
            this.f19108s = m20375a(list);
        }
        synchronized (this.f19047a) {
            this.f19038O = this.f19108s.length - 1;
            setCurrentIndex(OplusGLSurfaceView_13);
        }
        m20370a(this.f19108s);
        m20448b(OplusGLSurfaceView_13, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20439a(List<Integer> list, boolean z, String str) {
        CameraLog.m12954a("ModePickerView", "updateTextAndIndex, textIdList: " + list);
        if (list == null || list.size() <= 0) {
            CameraLog.m12967f("ModePickerView", "updateText, the parameter is illegal");
            return;
        }
        synchronized (this.f19092c) {
            this.f19108s = m20375a(list);
        }
        synchronized (this.f19047a) {
            this.f19038O = this.f19108s.length - 1;
            this.f19024A = m20361a(this.f19108s, z, str);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m20361a(String[] strArr, boolean z, String str) {
        CameraLog.m12959b("ModePickerView", "updateTextAndIndex, textArray: " + Arrays.toString(strArr) + ", curMode: " + str);
        if (strArr == null || strArr.length <= 0) {
            throw new IllegalArgumentException("the text array can't be null or it's length can't be 0");
        }
        synchronized (this.f19091b) {
            String strM20378b = m20378b(strArr, z, str);
            String str2 = this.f19045V[this.f19095f];
            this.f19045V = strArr;
            this.f19104o = new float[this.f19045V.length + 1];
            this.f19046W = new float[this.f19045V.length + 1];
            this.f19065aa = new float[this.f19045V.length + 1];
            m20437a(strM20378b, str2);
        }
        return this.f19095f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20437a(String str, String str2) {
        int OplusGLSurfaceView_13 = this.f19080ap;
        int i2 = this.f19095f;
        int i3 = 0;
        while (true) {
            String[] strArr = this.f19045V;
            if (i3 >= strArr.length) {
                i3 = 0;
                break;
            } else if (str.equals(strArr[i3])) {
                break;
            } else {
                i3++;
            }
        }
        int i4 = 0;
        while (true) {
            String[] strArr2 = this.f19045V;
            if (i4 >= strArr2.length) {
                i4 = 0;
                break;
            } else if (str2.equals(strArr2[i4])) {
                break;
            } else {
                i4++;
            }
        }
        if (OplusGLSurfaceView_13 != i3) {
            this.f19080ap = i3;
        }
        m20448b(i4, false);
        CameraLog.m12954a("ModePickerView", "updateIndex, mLastIndex: " + this.f19080ap + ", mCurrentIndex: " + this.f19024A + ", " + str + ", " + str2 + ", " + i4);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private String m20378b(String[] strArr, boolean z, String str) {
        if (!z) {
            return this.f19045V[this.f19080ap];
        }
        for (String str2 : strArr) {
            if (str.equals(str2)) {
                return str;
            }
        }
        return this.f19066ab.getString(R.string.camera_mode_photo);
    }

    public int getLastIndex() {
        return this.f19080ap;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m20446b() {
        synchronized (this.f19092c) {
            if (this.f19108s == null) {
                return false;
            }
            if (this.f19024A >= 0 && this.f19024A < this.f19108s.length) {
                return this.f19108s[this.f19024A].equals(getContext().getString(R.string.camera_mode_more));
            }
            return false;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m20450c() {
        CameraLog.m12954a("ModePickerView", "slideNextItem");
        COUIBaseListPopupWindow_8 eVar = this.f19054aG;
        if (eVar == null || !eVar.mo19202p(this.f19024A)) {
            CameraLog.m12967f("ModePickerView", "slideNextItem, can not slide");
            return;
        }
        synchronized (this.f19047a) {
            if (this.f19024A + 1 > this.f19038O) {
                setCurrentIndex(this.f19038O);
                CameraLog.m12967f("ModePickerView", "slideNextItem, current index is max, can not slide");
            } else {
                setCurrentIndex(this.f19024A + 1);
                m20447b(this.f19024A);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m20454d() {
        CameraLog.m12954a("ModePickerView", "slidePreviousItem");
        COUIBaseListPopupWindow_8 eVar = this.f19054aG;
        if (eVar == null || !eVar.mo19202p(this.f19024A)) {
            CameraLog.m12967f("ModePickerView", "slidePreviousItem, can not slide");
            return;
        }
        synchronized (this.f19047a) {
            if (this.f19024A - 1 < 0) {
                setCurrentIndex(0);
                CameraLog.m12967f("ModePickerView", "slidePreviousItem, current index is min, can not slide");
            } else {
                setCurrentIndex(this.f19024A - 1);
                m20447b(this.f19024A);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m20447b(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("ModePickerView", "setCurrentIndexWithAnim, index: " + OplusGLSurfaceView_13 + ", mCurrentAnimIndex: " + this.f19095f);
        setRotateMode(0);
        synchronized (this.f19091b) {
            if (this.f19045V != null && this.f19045V.length > 0 && OplusGLSurfaceView_13 >= 0 && OplusGLSurfaceView_13 < this.f19045V.length) {
                if (this.f19104o != null && this.f19104o.length > 0 && OplusGLSurfaceView_13 + 1 < this.f19104o.length) {
                    this.f19080ap = this.f19095f;
                    this.f19095f = OplusGLSurfaceView_13;
                    this.f19096g = true;
                    return m20372a(this.f19080ap, this.f19095f);
                }
                CameraLog.m12967f("ModePickerView", "setCurrentIndexWithAnim, mTextItemTransit is illegal");
                return false;
            }
            CameraLog.m12967f("ModePickerView", "setCurrentIndexWithAnim, mTextArray: " + this.f19045V + ", index: " + OplusGLSurfaceView_13 + ", mCurrentAnimIndex: " + this.f19095f);
            return false;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m20372a(int OplusGLSurfaceView_13, int i2) {
        float[] fArr = this.f19104o;
        return m20371a((fArr[OplusGLSurfaceView_13] + fArr[OplusGLSurfaceView_13 + 1]) / 2.0f, (fArr[i2] + fArr[i2 + 1]) / 2.0f, i2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m20371a(float f2, float f3, int OplusGLSurfaceView_13) {
        if (this.f19044U == null) {
            m20423t();
        }
        this.f19044U.m5470a(f2).m5476b(f3);
        CameraLog.m12954a("ModePickerView", "startAnimation, startTransit: " + f2 + ", endTransit: " + f3);
        if (this.f19054aG == null) {
            return true;
        }
        m20451c(OplusGLSurfaceView_13);
        synchronized (this.f19047a) {
            setCurrentIndex(OplusGLSurfaceView_13);
            this.f19054aG.mo19198o(OplusGLSurfaceView_13);
        }
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20440a(boolean z) {
        synchronized (this.f19047a) {
            if (this.f19108s[this.f19024A].equals(getContext().getString(R.string.camera_mode_more))) {
                setCurrentIndex(getLastIndex());
            }
        }
        setVisibility(z ? 0 : 4);
        CameraLog.m12954a("ModePickerView", "backToLastHeadlineIndex, last index: " + this.f19024A);
        m20448b(this.f19024A, false);
        setHeadlineAngle(this.f19068ad);
        invalidate();
    }

    public void setTextArray(List<Integer> list) {
        this.f19045V = m20375a(list);
        String[] strArr = this.f19045V;
        this.f19104o = new float[strArr.length + 1];
        this.f19046W = new float[strArr.length + 1];
        this.f19065aa = new float[strArr.length + 1];
        post(new Runnable() { // from class: com.oplus.camera.ui.menu.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8.4
            @Override // java.lang.Runnable
            public void run() {
                ModePickerView c3239e = ModePickerView.this;
                c3239e.m20368a(c3239e.f19106q);
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private String[] m20375a(List<Integer> list) {
        String[] strArr = new String[list.size()];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < list.size(); OplusGLSurfaceView_13++) {
            strArr[OplusGLSurfaceView_13] = getContext().getString(list.get(OplusGLSurfaceView_13).intValue());
        }
        return strArr;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m20451c(int OplusGLSurfaceView_13) {
        synchronized (this.f19091b) {
            if (this.f19045V != null && this.f19045V.length > 0 && OplusGLSurfaceView_13 >= 0 && OplusGLSurfaceView_13 < this.f19045V.length) {
                if (OplusGLSurfaceView_13 != this.f19024A) {
                    this.f19080ap = this.f19095f;
                    this.f19095f = OplusGLSurfaceView_13;
                }
                CameraLog.m12954a("ModePickerView", "updateCurrentIndex, mLastIndex: " + this.f19080ap + ", mCurrentAnimIndex: " + this.f19095f);
                return;
            }
            CameraLog.m12966e("ModePickerView", "updateCurrentIndex, mTextArray: " + this.f19045V + ", index: " + OplusGLSurfaceView_13 + ", mCurrentIndex: " + this.f19095f);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float[] fArr;
        float[] fArr2;
        int length;
        COUIBaseListPopupWindow_8 eVar = this.f19054aG;
        int length2 = 0;
        if (eVar == null) {
            return false;
        }
        if (eVar.mo19074X()) {
            CameraLog.m12954a("ModePickerView", "onTouchEvent, return when isTimerSnapShotRunning");
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f19112w = motionEvent.getX();
            this.f19115z = motionEvent.getY();
            this.f19113x = this.f19112w;
            this.f19114y = this.f19115z;
            this.f19110u = 0.0f;
            this.f19090az = false;
            this.f19049aB = this.f19054aG.mo19202p(this.f19024A);
        } else if (action != 1) {
            if (action != 2) {
                if (action == 3 && m20455d(1)) {
                    return m20386b(false);
                }
            } else {
                if (!this.f19049aB) {
                    return false;
                }
                float x = motionEvent.getX() - this.f19112w;
                if (1 == this.f19062aO) {
                    x = motionEvent.getY() - this.f19115z;
                }
                if (m20373a(motionEvent)) {
                    CameraLog.m12954a("ModePickerView", "onTouchEvent, return when envet out of view");
                    return true;
                }
                if (10.0f > Math.abs(x)) {
                    CameraLog.m12954a("ModePickerView", "onTouchEvent, return when distance too small");
                    return true;
                }
                float width = (x / getWidth()) * 75.0f;
                if (1 == this.f19062aO) {
                    width = (x / Util.getScreenHeight()) * 75.0f;
                }
                float f2 = this.f19041R - x;
                if (m20384b(x)) {
                    this.f19110u = width;
                } else if (m20396d(f2) || m20391c(f2)) {
                    this.f19110u = this.f19111v + width;
                } else {
                    this.f19111v = this.f19110u;
                    this.f19110u = x;
                }
                if (m20422s()) {
                    CameraLog.m12954a("ModePickerView", "onTouchEvent, spring animation is running, set at rest");
                    this.f19064aQ = true;
                    this.f19044U.m5487j();
                }
                int OplusGLSurfaceView_13 = this.f19024A;
                if (1 == this.f19062aO) {
                    float f3 = this.f19041R - this.f19110u;
                    int i2 = OplusGLSurfaceView_13;
                    int i3 = 0;
                    while (true) {
                        fArr2 = this.f19104o;
                        if (i3 >= fArr2.length - 1) {
                            break;
                        }
                        if (f3 > fArr2[i3] && f3 < fArr2[i3 + 1]) {
                            CameraLog.m12954a("ModePickerView", "onTouchEvent, new index: " + i3 + ", currentIndex: " + this.f19024A);
                            i2 = i3;
                        }
                        i3++;
                    }
                    if (f3 < 0.0f) {
                        length = 0;
                    } else {
                        String[] strArr = this.f19045V;
                        length = f3 > fArr2[strArr.length - 1] ? strArr.length - 1 : i2;
                    }
                    int i4 = length - this.f19024A;
                    if (motionEvent.getEventTime() - motionEvent.getDownTime() >= 200.0f) {
                        setFinalTransit(f3);
                    } else if (i4 != 0) {
                        length = this.f19024A + (i4 < 0 ? -1 : 1);
                    }
                    setRotateMode(1);
                    this.f19051aD = false;
                    length2 = length;
                } else {
                    setFinalTransit(this.f19041R - this.f19110u);
                    setRotateMode(1);
                    this.f19051aD = false;
                    int i5 = this.f19024A;
                    int i6 = 0;
                    while (true) {
                        fArr = this.f19104o;
                        if (i6 >= fArr.length - 1) {
                            break;
                        }
                        float f4 = this.f19042S;
                        if (f4 > fArr[i6] && f4 < fArr[i6 + 1]) {
                            CameraLog.m12954a("ModePickerView", "onTouchEvent, new index: " + i6 + ", currentIndex: " + this.f19024A);
                            i5 = i6;
                        }
                        i6++;
                    }
                    float f5 = this.f19042S;
                    if (f5 >= 0.0f) {
                        length2 = f5 > fArr[this.f19045V.length - 1] ? r1.length - 1 : i5;
                    }
                }
                this.f19094e = length2;
                this.f19096g = true;
                invalidate();
            }
        } else if (m20455d(1)) {
            return m20386b(true);
        }
        GestureDetector gestureDetector = this.f19053aF;
        if (gestureDetector != null) {
            gestureDetector.onTouchEvent(motionEvent);
        }
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m20373a(MotionEvent motionEvent) {
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        boolean z = Math.abs(x - this.f19113x) < 100.0f;
        int OplusGLSurfaceView_13 = this.f19062aO;
        if (1 == OplusGLSurfaceView_13) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            boolean z2 = Math.abs(y2 - this.f19114y) < 100.0f;
            this.f19114y = y2;
            return (x2 < 0.0f || x2 > ((float) getWidth())) && !z2;
        }
        if (4 == OplusGLSurfaceView_13) {
            this.f19113x = x;
            return (y < 0.0f || y > ((float) getHeight())) && !z;
        }
        this.f19113x = x;
        return (y > ((float) getBottom()) || y < ((float) getTop())) && !z;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m20384b(float f2) {
        if (this.f19024A != 0 || 0.0f >= f2) {
            return this.f19024A == this.f19045V.length - 1 && 0.0f > f2;
        }
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m20386b(boolean z) {
        setRotateMode(0);
        this.f19051aD = true;
        float f2 = this.f19041R - this.f19110u;
        if (1 == this.f19062aO) {
            f2 = this.f19042S;
        }
        CameraLog.m12954a("ModePickerView", "performMoveAction, computeMoveAnimation: " + z);
        if (!z || !this.f19054aG.mo19202p(this.f19024A)) {
            m20400e(f2);
            return true;
        }
        this.f19042S = f2;
        float f3 = (this.f19104o[this.f19094e] + this.f19104o[this.f19094e + 1]) / 2.0f;
        CameraLog.m12954a("ModePickerView", "performMoveAction, mScrollCurrentIndex: " + this.f19094e + ", mCurrentIndex: " + this.f19024A + ", startTransit: " + f2 + ", endTransit: " + f3);
        if (this.f19094e != this.f19024A) {
            m20371a(f2, f3, this.f19094e);
        } else {
            m20400e(f2);
        }
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean m20391c(float f2) {
        if (m20455d(1)) {
            int OplusGLSurfaceView_13 = this.f19094e;
            String[] strArr = this.f19045V;
            if (OplusGLSurfaceView_13 == strArr.length - 1) {
                float[] fArr = this.f19104o;
                if (f2 > (fArr[strArr.length - 1] + fArr[strArr.length]) / 2.0f) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean m20396d(float f2) {
        return m20455d(1) && this.f19094e == 0 && f2 < this.f19104o[1] / 2.0f;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m20400e(float f2) {
        int OplusGLSurfaceView_13 = this.f19024A;
        this.f19094e = OplusGLSurfaceView_13;
        m20371a(f2, this.f19041R, OplusGLSurfaceView_13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public boolean m20422s() {
        Spring c1032f = this.f19044U;
        return (c1032f == null || c1032f.m5486i()) ? false : true;
    }

    private void setFinalTransit(float f2) {
        this.f19042S = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m20368a(TextPaint textPaint) {
        if (1 == this.f19062aO) {
            m20390c(textPaint);
        } else {
            m20381b(textPaint);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004e  */
    /* renamed from: IntrinsicsJvm.kt_4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m20381b(android.text.TextPaint r5) {
        /*
            r4 = this;
            float[] r0 = r4.f19104o
            r1 = 0
            r2 = 0
            r0[r1] = r2
            boolean r0 = com.oplus.camera.util.Util.m24349al()
            if (r0 == 0) goto L19
            java.lang.String[] r0 = r4.f19045V
            int r0 = r0.length
            r3 = 5
            if (r0 <= r3) goto L15
            int r0 = r4.f19076al
            goto L17
        L15:
            int r0 = r4.f19077am
        L17:
            r4.f19075ak = r0
        L19:
            java.lang.String[] r0 = r4.f19045V
            int r3 = r0.length
            if (r1 >= r3) goto L30
            r0 = r0[r1]
            float r0 = r5.measureText(r0)
            float r2 = r2 + r0
            int r0 = r4.f19075ak
            float r0 = (float) r0
            float r2 = r2 + r0
            float[] r0 = r4.f19104o
            int r1 = r1 + 1
            r0[r1] = r2
            goto L19
        L30:
            int r5 = r4.f19024A
            if (r5 < 0) goto L4e
            float[] r0 = r4.f19104o
            int r1 = r0.length
            int r1 = r1 + (-2)
            if (r5 <= r1) goto L3c
            goto L4e
        L3c:
            r1 = r0[r5]
            int r5 = r5 + 1
            r5 = r0[r5]
            float r1 = r1 + r5
            r5 = 1073741824(0x40000000, float:2.0)
            float r1 = r1 / r5
            r4.f19041R = r1
            float r5 = r4.f19041R
            r4.setFinalTransit(r5)
            goto L55
        L4e:
            java.lang.String r5 = "ModePickerView"
            java.lang.String r0 = "setHeadlineAngle, ROTATE_MODE_NO_ANIMATION , the parameter is illegal"
            com.oplus.camera.CameraLog.m12967f(r5, r0)
        L55:
            r4.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.menu.p175a.ModePickerView.m20381b(android.text.TextPaint):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x007d  */
    /* renamed from: IntrinsicsJvm.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m20390c(android.text.TextPaint r6) {
        /*
            r5 = this;
            android.content.res.Resources r6 = r5.getResources()
            r0 = 2131168417(0x7f070ca1, float:1.7951135E38)
            int r6 = r6.getDimensionPixelSize(r0)
            float r6 = (float) r6
            r0 = 0
            float r0 = r0 - r6
            float[] r6 = r5.f19104o
            r1 = 0
            r6[r1] = r0
            r6 = r1
        L14:
            java.lang.String[] r2 = r5.f19045V
            int r3 = r2.length
            if (r6 >= r3) goto L3a
            int r3 = r5.f19086av
            float r3 = (float) r3
            float r3 = r3 + r0
            int r4 = r5.f19075ak
            float r4 = (float) r4
            float r3 = r3 + r4
            r2 = r2[r6]
            boolean r2 = r5.m20444a(r2)
            if (r2 == 0) goto L32
            int r2 = r5.f19075ak
            float r2 = (float) r2
            float r0 = r0 + r2
            int r2 = r5.f19037N
            float r2 = (float) r2
            float r0 = r0 + r2
            goto L33
        L32:
            r0 = r3
        L33:
            float[] r2 = r5.f19104o
            int r6 = r6 + 1
            r2[r6] = r0
            goto L14
        L3a:
            int r6 = r2.length
            r0 = 1073741824(0x40000000, float:2.0)
            r2 = 2
            if (r6 <= r2) goto L61
            float[] r6 = r5.f19104o
            r3 = r6[r2]
            r4 = 3
            r6 = r6[r4]
            float r3 = r3 + r6
            int r6 = r5.f19075ak
            float r6 = (float) r6
            float r3 = r3 - r6
            float r3 = r3 / r0
            int r6 = r5.getHeight()
            float r6 = (float) r6
            float r6 = r6 / r0
            float r3 = r3 - r6
        L54:
            float[] r6 = r5.f19104o
            int r4 = r6.length
            if (r1 >= r4) goto L61
            r4 = r6[r1]
            float r4 = r4 - r3
            r6[r1] = r4
            int r1 = r1 + 1
            goto L54
        L61:
            int r6 = r5.f19024A
            java.lang.String r1 = "ModePickerView"
            if (r6 < 0) goto L7d
            float[] r3 = r5.f19104o
            int r4 = r3.length
            int r4 = r4 - r2
            if (r6 <= r4) goto L6e
            goto L7d
        L6e:
            r2 = r3[r6]
            int r6 = r6 + 1
            r6 = r3[r6]
            float r2 = r2 + r6
            float r2 = r2 / r0
            r5.f19041R = r2
            float r6 = r5.f19041R
            r5.f19042S = r6
            goto L82
        L7d:
            java.lang.String r6 = "setHeadlineAngle, ROTATE_MODE_NO_ANIMATION , the parameter is illegal"
            com.oplus.camera.CameraLog.m12967f(r1, r6)
        L82:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "initVerticalMeasure, mTextArray: "
            r6.append(r0)
            java.lang.String[] r0 = r5.f19045V
            java.lang.String r0 = java.util.Arrays.toString(r0)
            r6.append(r0)
            java.lang.String r0 = ", mTextItemTransit: "
            r6.append(r0)
            float[] r0 = r5.f19104o
            java.lang.String r0 = java.util.Arrays.toString(r0)
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            com.oplus.camera.CameraLog.m12959b(r1, r6)
            r5.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.menu.p175a.ModePickerView.m20390c(android.text.TextPaint):void");
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) throws Resources.NotFoundException {
        super.onDraw(canvas);
        if (1 == this.f19062aO) {
            m20435a(canvas);
        } else {
            m20380b(canvas);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m20380b(Canvas canvas) throws Resources.NotFoundException {
        int OplusGLSurfaceView_13;
        float f2;
        int i2;
        Paint.FontMetrics fontMetrics;
        Paint.FontMetrics fontMetrics2;
        float f3;
        canvas.drawColor(0);
        m20419q();
        m20420r();
        m20427a();
        Paint.FontMetrics fontMetrics3 = this.f19106q.getFontMetrics();
        Paint.FontMetrics fontMetrics4 = this.f19107r.getFontMetrics();
        float f4 = ((this.f19086av / 2.0f) - (fontMetrics3.bottom / 2.0f)) - (fontMetrics3.top / 2.0f);
        float f5 = ((this.f19086av / 2.0f) - (fontMetrics4.bottom / 2.0f)) - (fontMetrics4.top / 2.0f);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.baseline_arrange_vertical_offset);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.mode_picker_view_offset_a);
        int dimensionPixelOffset3 = getResources().getDimensionPixelOffset(R.dimen.mode_picker_view_offset_b);
        float f6 = dimensionPixelOffset;
        float f7 = dimensionPixelOffset2;
        float f8 = (f4 - f6) + f7;
        float f9 = (f5 - f6) + f7 + this.f19061aN;
        float f10 = 0.0f;
        this.f19104o[0] = 0.0f;
        int i3 = 3;
        if (this.f19068ad == 3) {
            this.f19055aH.m20320a(f4, f5, fontMetrics3, this.f19073ai, this.f19074aj);
        }
        canvas.translate((getWidth() / 2.0f) - this.f19042S, 0.0f);
        int i4 = 0;
        float f11 = 0.0f;
        float fMeasureText = 0.0f;
        while (true) {
            String[] strArr = this.f19045V;
            if (i4 >= strArr.length) {
                break;
            }
            fMeasureText = this.f19106q.measureText(strArr[i4]);
            if (Util.m24349al()) {
                m20402f(i4);
            }
            if (i4 == this.f19045V.length - 1) {
                this.f19081aq = (int) fMeasureText;
            }
            float f12 = f11 + fMeasureText + this.f19075ak;
            float f13 = (f11 + f12) / 2.0f;
            if (i4 == this.f19024A - 2) {
                f13 += f7;
            }
            if (i4 == this.f19024A - 1) {
                f13 -= dimensionPixelOffset3;
            }
            if (i4 == this.f19024A + 1) {
                f13 += dimensionPixelOffset3;
            }
            if (i4 == this.f19024A + 2) {
                f13 -= f7;
            }
            float f14 = f13;
            this.f19107r.setAlpha(this.f19059aL ? this.f19060aM : this.f19069ae);
            this.f19106q.setAlpha(this.f19059aL ? (int) (this.f19040Q * 255.0f) : this.f19069ae);
            this.f19046W[i4] = f14;
            int i5 = this.f19068ad;
            if (i5 == 1) {
                OplusGLSurfaceView_13 = i3;
                f2 = f7;
                i2 = dimensionPixelOffset3;
                fontMetrics = fontMetrics4;
                m20366a(canvas, f14, f8, f9, i4, this.f19094e);
            } else {
                OplusGLSurfaceView_13 = i3;
                f2 = f7;
                i2 = dimensionPixelOffset3;
                fontMetrics = fontMetrics4;
                if (i5 == OplusGLSurfaceView_13) {
                    this.f19055aH.m20322a(i4, canvas, this.f19107r, this.f19045V, this.f19069ae, fMeasureText);
                } else {
                    m20366a(canvas, f14, f8, f9, i4, this.f19095f);
                }
            }
            if (m20398d(this.f19045V[i4])) {
                float fM24204a = f14 + (fMeasureText / 2.0f) + Util.m24204a(3.0f);
                if (i4 != this.f19024A) {
                    f3 = fontMetrics3.top;
                    fontMetrics2 = fontMetrics;
                } else {
                    fontMetrics2 = fontMetrics;
                    f3 = fontMetrics2.top;
                }
                m20365a(canvas, fM24204a, f4 + f3);
            } else {
                fontMetrics2 = fontMetrics;
            }
            if (!m20455d(1)) {
                this.f19104o[i4 + 1] = f12;
            }
            i4++;
            fontMetrics4 = fontMetrics2;
            f11 = f12;
            f10 = f11;
            i3 = OplusGLSurfaceView_13;
            f7 = f2;
            dimensionPixelOffset3 = i2;
        }
        if (1 == this.f19025B && this.f19051aD) {
            m20367a(canvas, f10, fMeasureText, Util.m24192T(), f4 + fontMetrics3.top);
        }
        setHeadlineAngle(this.f19068ad);
        m20460h();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m20366a(Canvas canvas, float f2, float f3, float f4, int OplusGLSurfaceView_13, int i2) {
        if (OplusGLSurfaceView_13 != i2) {
            canvas.drawText(this.f19045V[OplusGLSurfaceView_13], f2, f3 + this.f19056aI, this.f19106q);
        } else {
            canvas.drawText(this.f19045V[OplusGLSurfaceView_13], f2, f4 + this.f19056aI, this.f19107r);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0086  */
    /* renamed from: COUIBaseListPopupWindow_12 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m20402f(int r13) {
        /*
            r12 = this;
            java.lang.String[] r0 = r12.f19045V
            int r0 = r0.length
            r1 = 5
            if (r0 <= r1) goto L86
            float r0 = r12.f19042S
            int r1 = r12.getWidth()
            float r1 = (float) r1
            r2 = 1073741824(0x40000000, float:2.0)
            float r1 = r1 / r2
            float r3 = r0 - r1
            int r0 = r12.getWidth()
            float r0 = (float) r0
            float r5 = r0 + r3
            android.text.TextPaint r0 = r12.f19106q
            java.lang.String[] r1 = r12.f19045V
            r1 = r1[r13]
            float r0 = r0.measureText(r1)
            int r1 = r12.f19075ak
            float r1 = (float) r1
            float r0 = r0 + r1
            r1 = 2131167119(0x7f07078f, float:1.7948503E38)
            float r1 = com.oplus.camera.util.Util.m24456h(r1)
            boolean r2 = r12.f19073ai
            if (r2 == 0) goto L35
            int r2 = r12.f19074aj
            goto L36
        L35:
            r2 = -1
        L36:
            r4 = 16777215(0xffffff, float:2.3509886E-38)
            r4 = r4 & r2
            float[] r6 = r12.f19104o
            r7 = r6[r13]
            int r7 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            r8 = 1
            r9 = 0
            r10 = 2
            if (r7 <= 0) goto L61
            r6 = r6[r13]
            float r6 = r6 + r0
            int r6 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r6 >= 0) goto L61
            android.graphics.LinearGradient r13 = new android.graphics.LinearGradient
            r0 = 0
            float r5 = r3 + r1
            r6 = 0
            int[] r7 = new int[r10]
            r7[r9] = r4
            r7[r8] = r2
            r8 = 0
            android.graphics.Shader$TileMode r9 = android.graphics.Shader.TileMode.CLAMP
            r2 = r13
            r4 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            goto L87
        L61:
            float[] r3 = r12.f19104o
            r6 = r3[r13]
            int r6 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r6 <= 0) goto L86
            r13 = r3[r13]
            float r13 = r13 + r0
            int r13 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r13 >= 0) goto L86
            android.graphics.LinearGradient r13 = new android.graphics.LinearGradient
            r6 = 0
            float r7 = r5 - r1
            r0 = 0
            int[] r1 = new int[r10]
            r1[r9] = r4
            r1[r8] = r2
            r10 = 0
            android.graphics.Shader$TileMode r11 = android.graphics.Shader.TileMode.CLAMP
            r4 = r13
            r8 = r0
            r9 = r1
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            goto L87
        L86:
            r13 = 0
        L87:
            android.text.TextPaint r12 = r12.f19106q
            r12.setShader(r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.menu.p175a.ModePickerView.m20402f(int):void");
    }

    public float getVerticalOffset() {
        return this.f19043T;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m20435a(Canvas canvas) throws Resources.NotFoundException {
        Paint.FontMetrics fontMetrics;
        int OplusGLSurfaceView_13;
        int i2;
        int i3;
        float f2;
        Paint.FontMetrics fontMetrics2;
        char c2;
        float f3;
        int i4 = this.f19068ad;
        canvas.drawColor(0);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.vertical_mode_picker_view_offset_a);
        m20419q();
        m20420r();
        m20427a();
        this.f19043T = ((Util.m24456h(R.dimen.vertical_headline_height) / 2.0f) + (Util.m24456h(R.dimen.vertical_headline_item_gap) / 2.0f)) - this.f19042S;
        canvas.translate(0.0f, this.f19043T);
        if (i4 != 3) {
            int[] iArrM20424u = m20424u();
            float f4 = this.f19043T;
            LinearGradient linearGradient = new LinearGradient(0.0f, -f4, 0.0f, getResources().getDimensionPixelSize(R.dimen.vertical_headline_height) + (-f4), iArrM20424u, new float[]{0.0f, 0.0833f, 0.4f, 0.4028f, 0.5972f, 0.6f, 0.9167f, 1.0f}, Shader.TileMode.CLAMP);
            float f5 = this.f19043T;
            LinearGradient linearGradient2 = new LinearGradient(0.0f, -f5, 0.0f, (-f5) + getResources().getDimensionPixelSize(R.dimen.vertical_headline_height), iArrM20424u, new float[]{0.0f, 0.0833f, 0.345f, 0.3472f, 0.6528f, 0.655f, 0.9167f, 1.0f}, Shader.TileMode.CLAMP);
            if (this.f19067ac.getBGHeight() < (this.f19036M + getResources().getDimensionPixelOffset(R.dimen.vertical_headline_bg_height)) / 2) {
                this.f19106q.setShader(linearGradient);
                this.f19107r.setShader(linearGradient);
            } else {
                this.f19106q.setShader(linearGradient2);
                this.f19107r.setShader(linearGradient2);
            }
        } else {
            this.f19106q.setShader(null);
            this.f19107r.setShader(null);
        }
        Paint.FontMetrics fontMetrics3 = this.f19106q.getFontMetrics();
        Paint.FontMetrics fontMetrics4 = this.f19107r.getFontMetrics();
        float f6 = ((this.f19086av / 2.0f) - (fontMetrics3.bottom / 2.0f)) - (fontMetrics3.top / 2.0f);
        float f7 = ((this.f19086av / 2.0f) - (fontMetrics4.bottom / 2.0f)) - (fontMetrics4.top / 2.0f);
        float f8 = this.f19043T;
        float f9 = this.f19104o[0];
        if (i4 == 3) {
            this.f19055aH.m20320a(f6, f7, fontMetrics3, this.f19073ai, this.f19074aj);
        }
        int i5 = this.f19050aC ? this.f19094e : this.f19024A;
        float width = getWidth() / 2.0f;
        int i6 = 0;
        while (true) {
            String[] strArr = this.f19045V;
            if (i6 >= strArr.length) {
                break;
            }
            float fMeasureText = this.f19106q.measureText(strArr[i6]);
            boolean z = fMeasureText > ((float) this.f19079ao);
            float f10 = this.f19089ay;
            int i7 = this.f19075ak;
            float dimensionPixelSize = i7 + f10;
            float f11 = f6 + f9;
            float f12 = f7 + f9;
            if (z) {
                dimensionPixelSize = i7 + getResources().getDimensionPixelSize(R.dimen.vertical_headline_double_line_text_height);
            }
            if (i6 == i5 - 1) {
                float f13 = dimensionPixelOffset;
                f11 -= f13;
                f12 -= f13;
            }
            if (i6 == i5 + 1) {
                float f14 = dimensionPixelOffset;
                f11 += f14;
                f12 += f14;
            }
            float f15 = f11;
            float f16 = f12;
            float f17 = f9 + dimensionPixelSize;
            this.f19107r.setAlpha(this.f19069ae);
            this.f19106q.setAlpha(this.f19069ae);
            this.f19065aa[i6] = f15;
            if (i4 == 1) {
                if (i6 != this.f19094e) {
                    if (z) {
                        String[] strArrM20449b = m20449b(this.f19045V[i6]);
                        float f18 = ((int) (f10 - (this.f19037N / 2))) / 2;
                        canvas.drawText(strArrM20449b[0], width, f15 - f18, this.f19106q);
                        canvas.drawText(strArrM20449b[1], width, ((this.f19037N / 2) + f15) - f18, this.f19106q);
                    } else {
                        canvas.drawText(this.f19045V[i6], width, f15, this.f19106q);
                    }
                } else if (z) {
                    String[] strArrM20449b2 = m20449b(this.f19045V[i6]);
                    float f19 = ((int) (f10 - (this.f19037N / 2))) / 2;
                    canvas.drawText(strArrM20449b2[0], width, f16 - f19, this.f19107r);
                    canvas.drawText(strArrM20449b2[1], width, ((this.f19037N / 2) + f15) - f19, this.f19107r);
                } else {
                    canvas.drawText(this.f19045V[i6], width, f16, this.f19107r);
                }
                fontMetrics = fontMetrics4;
                OplusGLSurfaceView_13 = i4;
                i2 = dimensionPixelOffset;
                i3 = i6;
                f2 = width;
            } else if (i4 == 3) {
                i2 = dimensionPixelOffset;
                i3 = i6;
                OplusGLSurfaceView_13 = i4;
                f2 = width;
                fontMetrics = fontMetrics4;
                this.f19055aH.m20323a(i6, canvas, this.f19107r, this.f19045V, this.f19069ae, fMeasureText, width, getWidth(), this.f19043T);
            } else {
                fontMetrics = fontMetrics4;
                OplusGLSurfaceView_13 = i4;
                i2 = dimensionPixelOffset;
                i3 = i6;
                f2 = width;
                if (i3 != this.f19095f) {
                    if (z) {
                        String[] strArrM20449b3 = m20449b(this.f19045V[i3]);
                        float f20 = ((int) (f10 - (this.f19037N / 2))) / 2;
                        canvas.drawText(strArrM20449b3[0], f2, f15 - f20, this.f19106q);
                        canvas.drawText(strArrM20449b3[1], f2, ((this.f19037N / 2) + f15) - f20, this.f19106q);
                    } else {
                        canvas.drawText(this.f19045V[i3], f2, f15, this.f19106q);
                    }
                } else if (z) {
                    String[] strArrM20449b4 = m20449b(this.f19045V[i3]);
                    float f21 = ((int) (f10 - (this.f19037N / 2))) / 2;
                    canvas.drawText(strArrM20449b4[0], f2, f16 - f21, this.f19107r);
                    canvas.drawText(strArrM20449b4[1], f2, (f16 + (this.f19037N / 2)) - f21, this.f19107r);
                } else {
                    canvas.drawText(this.f19045V[i3], f2, f16, this.f19107r);
                }
            }
            if (m20398d(this.f19045V[i3])) {
                this.f19052aE.setShader(m20456e());
                c2 = 0;
                float fM24204a = f2 + (fMeasureText / 2.0f) + Util.m24204a(3.0f);
                if (i3 != this.f19024A) {
                    f3 = fontMetrics3.top;
                    fontMetrics2 = fontMetrics;
                } else {
                    fontMetrics2 = fontMetrics;
                    f3 = fontMetrics2.top;
                }
                m20365a(canvas, fM24204a, f15 + f3);
            } else {
                fontMetrics2 = fontMetrics;
                c2 = 0;
            }
            i6 = i3 + 1;
            this.f19104o[i6] = f17;
            fontMetrics4 = fontMetrics2;
            width = f2;
            f9 = f17;
            dimensionPixelOffset = i2;
            i4 = OplusGLSurfaceView_13;
        }
        int i8 = i4;
        setHeadlineAngle(this.f19068ad);
        if (i8 != 3) {
            m20460h();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m20444a(String str) {
        TextPaint textPaint = this.f19106q;
        return textPaint != null && textPaint.measureText(str) > ((float) this.f19079ao);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public String[] m20449b(String str) {
        if (str.contains(" ") && Float.compare(this.f19106q.measureText(str.substring(0, str.indexOf(" "))), this.f19079ao) < 0) {
            return str.split("\\s");
        }
        int OplusGLSurfaceView_13 = 1;
        while (OplusGLSurfaceView_13 < str.length() && Float.compare(this.f19106q.measureText(str.substring(0, OplusGLSurfaceView_13)), this.f19079ao) < 0) {
            OplusGLSurfaceView_13++;
        }
        int i2 = OplusGLSurfaceView_13 - 1;
        String[] strArr = new String[2];
        strArr[0] = str.substring(0, i2);
        if (Float.compare(this.f19106q.measureText(str.substring(i2)), this.f19079ao) < 0) {
            strArr[1] = str.substring(i2);
        } else {
            int i3 = i2 + 1;
            while (i3 < str.length()) {
                if (Float.compare(this.f19106q.measureText(str.substring(i2, i3) + "..."), this.f19079ao) >= 0) {
                    break;
                }
                i3++;
            }
            strArr[1] = str.substring(i2, i3) + "...";
        }
        return strArr;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public LinearGradient m20456e() {
        int[] iArr = {15348807, getResources().getColor(R.color.camera_red_dot_hint_color, null), getResources().getColor(R.color.camera_red_dot_hint_color, null), 15348807};
        float f2 = this.f19043T;
        return new LinearGradient(0.0f, -f2, 0.0f, (-f2) + getResources().getDimensionPixelSize(R.dimen.vertical_headline_height), iArr, new float[]{0.0f, 0.1216f, 0.8784f, 1.0f}, Shader.TileMode.CLAMP);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean m20458f() {
        return this.f19048aA;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public boolean m20459g() {
        return this.f19090az;
    }

    public void setMultiFinger(boolean z) {
        this.f19090az = z;
    }

    public int getLastTextWidth() {
        return this.f19081aq;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m20455d(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 == this.f19068ad;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m20365a(Canvas canvas, float f2, float f3) {
        this.f19052aE.setAlpha(this.f19059aL ? (int) (this.f19040Q * 255.0f) : this.f19070af);
        canvas.drawCircle(f2, f3 + this.f19056aI, Util.m24204a(3.0f), this.f19052aE);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20441a(int... iArr) {
        int OplusGLSurfaceView_13 = 0;
        if (iArr != null && iArr.length > 0) {
            int length = iArr.length;
            int i2 = 0;
            while (OplusGLSurfaceView_13 < length) {
                String string = this.f19066ab.getString(iArr[OplusGLSurfaceView_13]);
                if (m20398d(string)) {
                    this.f19093d.remove(string);
                    this.f19096g = true;
                    i2 = 1;
                }
                OplusGLSurfaceView_13++;
            }
            OplusGLSurfaceView_13 = i2;
        } else if (!this.f19093d.isEmpty()) {
            this.f19093d.clear();
            this.f19096g = true;
            OplusGLSurfaceView_13 = 1;
        }
        if (OplusGLSurfaceView_13 != 0) {
            invalidate();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m20445b(int... iArr) {
        int OplusGLSurfaceView_13 = 0;
        if (iArr != null && iArr.length > 0) {
            int length = iArr.length;
            int i2 = 0;
            while (OplusGLSurfaceView_13 < length) {
                String string = this.f19066ab.getString(iArr[OplusGLSurfaceView_13]);
                if (!m20398d(string)) {
                    this.f19093d.add(string);
                    i2 = 1;
                }
                OplusGLSurfaceView_13++;
            }
            OplusGLSurfaceView_13 = i2;
        }
        if (OplusGLSurfaceView_13 != 0) {
            invalidate();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean m20398d(String str) {
        return !this.f19093d.isEmpty() && this.f19093d.contains(str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m20367a(Canvas canvas, float f2, float f3, int OplusGLSurfaceView_13, float f4) {
        float previewFrameWidth = f2 + ((getPreviewFrameWidth() - f3) / 2.0f);
        int i2 = this.f19026C;
        int i3 = (OplusGLSurfaceView_13 - i2) / 2;
        int i4 = (OplusGLSurfaceView_13 / 2) + (i2 / 2);
        if (((int) ((((int) ((previewFrameWidth - i2) - this.f19029F)) + (getPreviewFrameWidth() / 2.0f)) - this.f19042S)) > getPreviewFrameWidth()) {
            return;
        }
        int previewFrameWidth2 = getPreviewFrameWidth() / 2;
        int i5 = this.f19026C;
        int i6 = (int) ((previewFrameWidth2 - (this.f19029F + i5)) + this.f19042S);
        this.f19109t.setBounds(i6, i3, i5 + i6, i4);
        this.f19109t.setAlpha(this.f19059aL ? (int) (this.f19040Q * 255.0f) : this.f19070af);
        this.f19109t.draw(canvas);
        this.f19071ag = new float[2];
        float[] fArr = this.f19071ag;
        int i7 = this.f19027D;
        int i8 = this.f19026C;
        fArr[0] = i6 - ((i7 - i8) / 2);
        fArr[1] = i6 + i8 + ((i7 - i8) / 2);
        this.f19072ah = new float[2];
        float[] fArr2 = this.f19072ah;
        fArr2[0] = this.f19028E - ((i7 - i8) / 2);
        fArr2[1] = fArr2[0] + i7;
        if (m20398d(this.f19066ab.getString(R.string.camera_mode_arrange))) {
            m20365a(canvas, ((i6 + (this.f19026C / 2)) - this.f19030G) + (f3 / 2.0f) + Util.m24204a(3.0f), f4 - this.f19031H);
        }
    }

    private void setHeadlineAngle(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            int i2 = this.f19080ap;
            if (i2 < 0 || i2 > this.f19104o.length - 2 || this.f19095f < 0 || this.f19095f > this.f19104o.length - 2) {
                CameraLog.m12967f("ModePickerView", "setHeadlineAngle, ROTATE_MODE_SLIDE, the parameter is illegal");
                return;
            }
            if (this.f19080ap != this.f19095f) {
                float f2 = this.f19041R;
                float[] fArr = this.f19104o;
                int i3 = this.f19080ap;
                float fAbs = Math.abs(f2 - ((fArr[i3] + fArr[i3 + 1]) / 2.0f));
                float f3 = (this.f19104o[this.f19095f] + this.f19104o[this.f19095f + 1]) / 2.0f;
                float[] fArr2 = this.f19104o;
                int i4 = this.f19080ap;
                this.f19039P = fAbs / Math.abs(f3 - ((fArr2[i4] + fArr2[i4 + 1]) / 2.0f));
                if (this.f19039P > 1.0f) {
                    this.f19039P = 1.0f;
                }
            } else {
                this.f19039P = 1.0f;
            }
            setFinalTransit(this.f19041R);
            CameraLog.m12954a("ModePickerView", "setHeadlineAngle, ROTATE_MODE_SLIDE, angle:" + this.f19041R);
            return;
        }
        if (OplusGLSurfaceView_13 != 1) {
            if (OplusGLSurfaceView_13 != 2) {
                return;
            }
            if (this.f19095f >= 0) {
                int i5 = this.f19095f;
                float[] fArr3 = this.f19104o;
                if (i5 <= fArr3.length - 2) {
                    this.f19041R = (fArr3[this.f19095f] + this.f19104o[this.f19095f + 1]) / 2.0f;
                    setFinalTransit(this.f19041R);
                    this.f19039P = 1.0f;
                    CameraLog.m12954a("ModePickerView", "setHeadlineAngle, ROTATE_MODE_NO_ANIMATION, angle:" + this.f19041R);
                    return;
                }
            }
            CameraLog.m12967f("ModePickerView", "setHeadlineAngle, ROTATE_MODE_NO_ANIMATION , the parameter is illegal");
            return;
        }
        int i6 = this.f19024A;
        if (i6 < 0 || i6 > this.f19104o.length - 2 || this.f19094e < 0 || this.f19094e > this.f19104o.length - 2) {
            CameraLog.m12967f("ModePickerView", "setHeadlineAngle, ROTATE_MODE_FOLLOW_FINGER , the parameter is illegal");
            return;
        }
        int i7 = this.f19094e;
        int i8 = this.f19024A;
        if (i7 != i8) {
            float f4 = this.f19042S;
            float[] fArr4 = this.f19104o;
            float fAbs2 = Math.abs(f4 - ((fArr4[i8] + fArr4[i8 + 1]) / 2.0f));
            float f5 = (this.f19104o[this.f19094e] + this.f19104o[this.f19094e + 1]) / 2.0f;
            float[] fArr5 = this.f19104o;
            int i9 = this.f19024A;
            this.f19039P = fAbs2 / Math.abs(f5 - ((fArr5[i9] + fArr5[i9 + 1]) / 2.0f));
            if (this.f19039P > 1.0f) {
                this.f19039P = 1.0f;
            }
        } else {
            this.f19039P = 1.0f;
        }
        if (1 != this.f19062aO) {
            setFinalTransit(this.f19041R);
        }
        CameraLog.m12954a("ModePickerView", "setHeadlineAngle, ROTATE_MODE_FOLLOW_FINGER, angle:" + this.f19041R);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m20452c(String str) {
        int OplusGLSurfaceView_13 = 0;
        while (true) {
            String[] strArr = this.f19108s;
            if (OplusGLSurfaceView_13 >= strArr.length) {
                OplusGLSurfaceView_13 = -1;
                break;
            } else if (strArr[OplusGLSurfaceView_13].equals(str)) {
                break;
            } else {
                OplusGLSurfaceView_13++;
            }
        }
        synchronized (this.f19047a) {
            setCurrentIndex(OplusGLSurfaceView_13);
        }
        CameraLog.m12954a("ModePickerView", "setIndex, index: " + OplusGLSurfaceView_13);
        setVisibility(0);
        m20448b(this.f19024A, false);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m20460h() {
        CameraLog.m12954a("ModePickerView", "setHeadlineDrawer, mAnimationRatio: " + this.f19039P);
        float fM20401f = m20401f(this.f19103n.getInterpolation(this.f19039P));
        float fM20376b = ((((float) this.f19034K) / 2.0f) / this.f19083as) / (this.f19088ax / 2.0f);
        float f2 = this.f19059aL ? 1.0f : this.f19040Q;
        boolean z = this.f19057aJ || !this.f19059aL;
        if (1 == this.f19062aO) {
            fM20376b = m20376b(getResources().getDimensionPixelOffset(R.dimen.vertical_headline_bg_height) / this.f19089ay, this.f19036M / this.f19089ay);
        }
        if (z) {
            m20429a((int) fM20401f, (int) (this.f19089ay * fM20376b), f2);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private float m20376b(float f2, float f3) {
        int OplusGLSurfaceView_13 = this.f19080ap;
        int i2 = this.f19024A;
        if (this.f19068ad == 1) {
            i2 = this.f19094e;
            OplusGLSurfaceView_13 = i2;
        }
        float f4 = f3 - f2;
        if (!m20444a(this.f19045V[OplusGLSurfaceView_13]) && m20444a(this.f19045V[i2])) {
            return f2 + (f4 * this.f19103n.getInterpolation(this.f19039P));
        }
        if (!m20444a(this.f19045V[OplusGLSurfaceView_13]) || m20444a(this.f19045V[i2])) {
            return (m20444a(this.f19045V[OplusGLSurfaceView_13]) && m20444a(this.f19045V[i2])) ? f3 : f2;
        }
        return f3 - (f4 * this.f19103n.getInterpolation(this.f19039P));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20434a(int OplusGLSurfaceView_13, boolean z) throws Resources.NotFoundException {
        if (this.f19062aO == OplusGLSurfaceView_13) {
            return;
        }
        this.f19062aO = OplusGLSurfaceView_13;
        HeadlineBackground c3236b = this.f19067ac;
        if (c3236b != null) {
            c3236b.setScreenLayoutMode(OplusGLSurfaceView_13);
        }
        ArrangeAnim c3235a = this.f19055aH;
        if (c3235a != null) {
            c3235a.m20321a(this.f19062aO);
        }
        CameraLog.m12959b("ModePickerView", "setLayoutMode, " + OplusGLSurfaceView_13);
        if (m20422s()) {
            this.f19064aQ = true;
            this.f19044U.m5487j();
        }
        m20428a(this.f19025B);
        m20448b(this.f19024A, z);
        m20368a(this.f19106q);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20436a(BaseScreenMode abstractC2934a, boolean z) throws Resources.NotFoundException {
        this.f19063aP = abstractC2934a;
        m20434a(abstractC2934a.mo16539j(), z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20429a(int OplusGLSurfaceView_13, int i2, float f2) {
        HeadlineBackground c3236b = this.f19067ac;
        if (c3236b != null) {
            c3236b.m20339a(OplusGLSurfaceView_13, i2);
            this.f19067ac.setAlpha(f2);
            this.f19067ac.setOffsetY(this.f19056aI);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private float m20401f(float f2) {
        float fM20404g;
        float fM20404g2;
        float fMeasureText;
        if (this.f19062aO == 1) {
            if (this.f19068ad == 1) {
                fM20404g = this.f19106q.measureText(this.f19045V[this.f19024A]);
                fMeasureText = this.f19106q.measureText(this.f19045V[this.f19094e]);
            } else {
                fM20404g = this.f19106q.measureText(this.f19045V[this.f19080ap]);
                fMeasureText = this.f19106q.measureText(this.f19045V[this.f19024A]);
            }
            fM20404g2 = getWidth() - (getResources().getDimensionPixelSize(R.dimen.vertical_headline_bg_paddingX) * 2);
            if (fM20404g > fM20404g2) {
                fM20404g = fM20404g2;
            }
            if (fMeasureText <= fM20404g2) {
                fM20404g2 = fMeasureText;
            }
        } else if (this.f19068ad == 1) {
            fM20404g = m20404g(this.f19024A);
            fM20404g2 = m20404g(this.f19094e);
        } else {
            fM20404g = m20404g(this.f19080ap);
            fM20404g2 = m20404g(this.f19024A);
        }
        CameraLog.m12954a("ModePickerView", "getCurrentBackgroundLocation, startLocation: " + fM20404g + ", endLocation: " + fM20404g2);
        return fM20404g + ((fM20404g2 - fM20404g) * f2);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public boolean m20461i() {
        ArrangeAnim c3235a = this.f19055aH;
        return c3235a != null && c3235a.m20333d();
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m20462j() {
        ArrangeAnim c3235a = this.f19055aH;
        if (c3235a != null) {
            c3235a.m20334e();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private float m20404g(int OplusGLSurfaceView_13) {
        float[] fArr = this.f19104o;
        double d2 = (fArr[OplusGLSurfaceView_13 + 1] - fArr[OplusGLSurfaceView_13]) / 2.0d;
        float f2 = this.f19075ak / 2;
        float f3 = this.f19083as;
        return (float) (((d2 - (f2 / f3)) + (this.f19035L / f3)) * 2.0d);
    }

    @Override // com.oplus.camera.p172ui.inverse.InverseAble
    public void setInverseColor(boolean z) {
        this.f19073ai = z;
        invalidate();
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public boolean m20463k() {
        ValueAnimator valueAnimator = this.f19098i;
        if (valueAnimator != null) {
            return valueAnimator.isRunning();
        }
        return false;
    }

    public void setRotateMode(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("ModePickerView", "setRotateMode, rotateMode: " + OplusGLSurfaceView_13);
        this.f19068ad = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m20448b(int OplusGLSurfaceView_13, boolean z) {
        CameraLog.m12954a("ModePickerView", "setCurrentIndex, from mCurrentAnimIndex: " + this.f19095f + " to target index: " + OplusGLSurfaceView_13 + ", updateLastIndex: " + z);
        synchronized (this.f19091b) {
            if (this.f19045V != null && this.f19045V.length > 0 && OplusGLSurfaceView_13 >= 0 && OplusGLSurfaceView_13 < this.f19045V.length) {
                setRotateMode(2);
                if (z) {
                    this.f19080ap = this.f19095f;
                }
                this.f19095f = OplusGLSurfaceView_13;
                this.f19096g = true;
                invalidate();
                return true;
            }
            CameraLog.m12967f("ModePickerView", "setCurrentIndex, mTextArray: " + this.f19045V + ", index: " + OplusGLSurfaceView_13 + ", mCurrentAnimIndex: " + this.f19095f);
            return false;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m20426a(float f2, float f3) {
        synchronized (this.f19091b) {
            if (this.f19104o != null && this.f19104o.length > 0) {
                float fAbs = Math.abs(f2);
                float f4 = (this.f19104o[this.f19095f] + this.f19104o[this.f19095f + 1]) / 2.0f;
                float f5 = f2 >= 0.0f ? f4 + fAbs : f4 - fAbs;
                if (this.f19071ag != null && this.f19072ah != null && Float.compare(f5, this.f19071ag[0]) >= 0 && Float.compare(f5, this.f19071ag[1]) < 0 && Float.compare(f3, this.f19072ah[0]) >= 0 && Float.compare(f3, this.f19072ah[1]) < 0) {
                    return -2;
                }
                int OplusGLSurfaceView_13 = 0;
                while (true) {
                    if (OplusGLSurfaceView_13 >= this.f19104o.length - 1) {
                        OplusGLSurfaceView_13 = -1;
                        break;
                    }
                    float fMeasureText = this.f19106q.measureText(this.f19045V[OplusGLSurfaceView_13]) / 2.0f;
                    float f6 = (this.f19046W[OplusGLSurfaceView_13] - fMeasureText) - this.f19032I;
                    float f7 = this.f19046W[OplusGLSurfaceView_13] + fMeasureText + this.f19032I;
                    if (Float.compare(f5, f6) >= 0 && Float.compare(f5, f7) < 0) {
                        break;
                    }
                    OplusGLSurfaceView_13++;
                }
                if (this.f19045V != null && this.f19045V.length > 0 && OplusGLSurfaceView_13 >= 0 && OplusGLSurfaceView_13 < this.f19045V.length && this.f19095f != OplusGLSurfaceView_13) {
                    this.f19080ap = this.f19095f;
                    this.f19095f = OplusGLSurfaceView_13;
                    setRotateMode(0);
                    this.f19096g = true;
                    float f8 = (this.f19104o[this.f19080ap] + this.f19104o[this.f19080ap + 1]) / 2.0f;
                    float f9 = (this.f19104o[this.f19095f] + this.f19104o[this.f19095f + 1]) / 2.0f;
                    if (this.f19044U == null) {
                        m20423t();
                    }
                    this.f19044U.m5470a(f8).m5476b(f9);
                    CameraLog.m12954a("ModePickerView", "computeIndexOnTap, mCurrentAnimIndex: " + this.f19095f);
                    return this.f19095f;
                }
                CameraLog.m12967f("ModePickerView", "computeIndexOnTap, mTextArray: " + this.f19045V + ", targetIndex: " + OplusGLSurfaceView_13 + ", mCurrentAnimIndex: " + this.f19095f);
                return -1;
            }
            CameraLog.m12967f("ModePickerView", "computeIndexOnTap, mTextItemTransit is illegal");
            return -1;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m20425a(float f2) {
        synchronized (this.f19091b) {
            if (this.f19104o != null && this.f19104o.length > 0) {
                float fAbs = Math.abs(f2);
                float f3 = (this.f19104o[this.f19095f] + this.f19104o[this.f19095f + 1]) / 2.0f;
                float f4 = f2 >= 0.0f ? f3 + fAbs : f3 - fAbs;
                if (this.f19071ag != null && Float.compare(f4, this.f19071ag[0]) >= 0 && Float.compare(f4, this.f19071ag[1]) < 0) {
                    return -2;
                }
                int OplusGLSurfaceView_13 = 0;
                while (true) {
                    if (OplusGLSurfaceView_13 >= this.f19104o.length - 1) {
                        OplusGLSurfaceView_13 = -1;
                        break;
                    }
                    if (Float.compare(f4, this.f19104o[OplusGLSurfaceView_13]) >= 0 && Float.compare(f4, this.f19104o[OplusGLSurfaceView_13 + 1]) < 0) {
                        break;
                    }
                    OplusGLSurfaceView_13++;
                }
                if (this.f19045V != null && this.f19045V.length > 0 && OplusGLSurfaceView_13 >= 0 && OplusGLSurfaceView_13 < this.f19045V.length && this.f19095f != OplusGLSurfaceView_13) {
                    this.f19080ap = this.f19095f;
                    this.f19095f = OplusGLSurfaceView_13;
                    setRotateMode(0);
                    this.f19096g = true;
                    float f5 = (this.f19104o[this.f19080ap] + this.f19104o[this.f19080ap + 1]) / 2.0f;
                    float f6 = (this.f19104o[this.f19095f] + this.f19104o[this.f19095f + 1]) / 2.0f;
                    if (this.f19044U == null) {
                        m20423t();
                    }
                    this.f19044U.m5470a(f5).m5476b(f6);
                    CameraLog.m12954a("ModePickerView", "computeVerticalIndexOnTap,  mCurrentAnimIndex: " + this.f19095f + " , startAngle: " + f5 + ", endAngle: " + f6);
                    return this.f19095f;
                }
                CameraLog.m12967f("ModePickerView", "computeVerticalIndexOnTap, mTextArray: " + this.f19045V + ", targetIndex: " + OplusGLSurfaceView_13 + ", mCurrentAnimIndex: " + this.f19095f);
                return -1;
            }
            CameraLog.m12967f("ModePickerView", "computeVerticalIndexOnTap, mTextItemTransit is illegal");
            return -1;
        }
    }

    public void setArrangeAlpha(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("ModePickerView", "setArrangeAlpha, alpha: " + OplusGLSurfaceView_13);
        synchronized (this.f19091b) {
            this.f19069ae = OplusGLSurfaceView_13;
            this.f19096g = true;
        }
    }

    public void setArrangeEditAlpha(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("ModePickerView", "setArrangeEditAlpha, alpha: " + OplusGLSurfaceView_13);
        synchronized (this.f19091b) {
            this.f19070af = OplusGLSurfaceView_13;
        }
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public boolean m20464l() {
        ArrangeAnim c3235a = this.f19055aH;
        return c3235a != null && c3235a.m20331b();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20433a(int OplusGLSurfaceView_13, Runnable runnable) {
        m20417p();
        this.f19055aH.m20326a(runnable);
        this.f19055aH.m20324a(OplusGLSurfaceView_13, this.f19045V, this.f19046W);
        setRotateMode(3);
        if (1 == this.f19062aO) {
            setVisibility(4);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20443a(int[] iArr, Runnable runnable, int OplusGLSurfaceView_13) {
        m20417p();
        this.f19055aH.m20326a(runnable);
        this.f19055aH.m20329a(iArr, this.f19045V, this.f19065aa, OplusGLSurfaceView_13);
        setRotateMode(3);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m20453c(int[] iArr) {
        m20417p();
        m20368a(this.f19106q);
        this.f19055aH.m20327a(iArr, this.f19045V, this.f19042S);
        setArrangeAlpha(255);
        setRotateMode(3);
        if (1 == this.f19062aO) {
            setVisibility(0);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20442a(int[] iArr, int OplusGLSurfaceView_13) {
        m20417p();
        m20368a(this.f19106q);
        this.f19055aH.m20328a(iArr, this.f19045V, this.f19042S, OplusGLSurfaceView_13);
        setArrangeAlpha(255);
        setRotateMode(3);
        setVisibility(0);
    }

    public float getTextGap() {
        return this.f19075ak;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public void m20465m() {
        ArrangeAnim c3235a = this.f19055aH;
        if (c3235a != null) {
            c3235a.m20332c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCurrentIndex(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 > this.f19038O) {
            CameraLog.m12967f("ModePickerView", "setCurrentIndex, index is wrong, index: " + OplusGLSurfaceView_13);
            return;
        }
        if (OplusGLSurfaceView_13 != this.f19024A) {
            this.f19024A = OplusGLSurfaceView_13;
            if (this.f19067ac != null) {
                post(new Runnable() { // from class: com.oplus.camera.ui.menu.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8.5
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (ModePickerView.this.f19092c) {
                            ModePickerView.this.f19067ac.setContentDescription(ModePickerView.this.f19108s[ModePickerView.this.f19024A]);
                        }
                    }
                });
            }
        }
        CameraLog.m12954a("ModePickerView", "setCurrentIndex, mCurrentIndex: " + this.f19024A);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20432a(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15, long j2, TimeInterpolator timeInterpolator, boolean z, int i2) throws Resources.NotFoundException {
        m20431a(OplusGLSurfaceView_13, OplusGLSurfaceView_15, j2, timeInterpolator, null, z, i2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20431a(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15, long j2, TimeInterpolator timeInterpolator, Animator.AnimatorListener animatorListener, boolean z, int i2) throws Resources.NotFoundException {
        CameraLog.m12954a("ModePickerView", "setVisibilityWithAnimator, visibility: " + OplusGLSurfaceView_13 + ", duration: " + OplusGLSurfaceView_15 + ", startDelay: " + j2 + ", interpolator: " + timeInterpolator + ", listener: " + animatorListener + ", animType: " + i2);
        ValueAnimator valueAnimator = this.f19098i;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f19098i.cancel();
            this.f19098i = null;
        }
        this.f19057aJ = OplusGLSurfaceView_13 == 0;
        if (OplusGLSurfaceView_13 == 0) {
            m20364a(OplusGLSurfaceView_15, j2, timeInterpolator, animatorListener, z, i2);
        } else {
            m20379b(OplusGLSurfaceView_15, j2, timeInterpolator, animatorListener, z, i2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m20364a(long OplusGLSurfaceView_15, long j2, TimeInterpolator timeInterpolator, Animator.AnimatorListener animatorListener, boolean z, int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        long j3;
        TimeInterpolator interpolator;
        TimeInterpolator timeInterpolator2 = timeInterpolator == null ? this.f19102m : timeInterpolator;
        long duration = OplusGLSurfaceView_15 <= 0 ? 300L : OplusGLSurfaceView_15;
        if (z) {
            Animation animationM20388c = m20388c(true);
            duration = animationM20388c.getDuration();
            long startOffset = animationM20388c.getStartOffset();
            interpolator = animationM20388c.getInterpolator();
            j3 = startOffset;
        } else {
            j3 = j2;
            interpolator = timeInterpolator2;
        }
        this.f19098i = m20362a(0.0f, 1.0f, duration, j3, interpolator, new IntrinsicsJvm.kt_3(animatorListener));
        this.f19059aL = 3 == OplusGLSurfaceView_13;
        m20406g(0.0f);
        HeadlineBackground c3236b = this.f19067ac;
        if (c3236b != null) {
            c3236b.setAlpha(0.0f);
        }
        setVisibility(0);
        setEnabled(false);
        this.f19098i.start();
        if (2 != OplusGLSurfaceView_13) {
            if (3 == OplusGLSurfaceView_13) {
                m20395d(true);
            }
        } else {
            this.f19100k = ValueAnimator.ofFloat(-this.f19058aK, 0.0f);
            this.f19100k.setDuration(300L);
            this.f19100k.setStartDelay(100L);
            this.f19100k.setInterpolator(this.f19101l);
            this.f19100k.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8.6
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ModePickerView.this.f19056aI = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    ModePickerView.this.invalidate();
                }
            });
            this.f19100k.start();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m20379b(long OplusGLSurfaceView_15, long j2, TimeInterpolator timeInterpolator, Animator.AnimatorListener animatorListener, boolean z, int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        long j3;
        TimeInterpolator interpolator;
        TimeInterpolator timeInterpolator2 = timeInterpolator == null ? this.f19102m : timeInterpolator;
        long duration = OplusGLSurfaceView_15 <= 0 ? 250L : OplusGLSurfaceView_15;
        if (z) {
            Animation animationM20388c = m20388c(false);
            duration = animationM20388c.getDuration();
            long startOffset = animationM20388c.getStartOffset();
            interpolator = animationM20388c.getInterpolator();
            j3 = startOffset;
        } else {
            j3 = j2;
            interpolator = timeInterpolator2;
        }
        this.f19098i = m20362a(1.0f, 0.0f, duration, j3, interpolator, new IntrinsicsJvm.kt_4(animatorListener));
        this.f19059aL = 3 == OplusGLSurfaceView_13;
        m20406g(1.0f);
        HeadlineBackground c3236b = this.f19067ac;
        if (c3236b != null) {
            c3236b.setAlpha(1.0f);
        }
        setEnabled(false);
        this.f19098i.start();
        if (2 != OplusGLSurfaceView_13) {
            if (3 == OplusGLSurfaceView_13) {
                m20395d(false);
            }
        } else {
            this.f19100k = ValueAnimator.ofFloat(0.0f, -this.f19058aK);
            this.f19100k.setDuration(300L);
            this.f19100k.setInterpolator(this.f19101l);
            this.f19100k.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8.7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ModePickerView.this.f19056aI = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    ModePickerView.this.invalidate();
                }
            });
            this.f19100k.start();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Animation m20388c(boolean z) throws Resources.NotFoundException {
        Animation animationLoadAnimation;
        if (z) {
            animationLoadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.headline_vertical_in);
        } else {
            animationLoadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.headline_vertical_out);
        }
        startAnimation(animationLoadAnimation);
        this.f19067ac.startAnimation(animationLoadAnimation);
        return animationLoadAnimation;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private ValueAnimator m20362a(float f2, float f3, long OplusGLSurfaceView_15, long j2, TimeInterpolator timeInterpolator, Animator.AnimatorListener animatorListener) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f2, f3);
        valueAnimatorOfFloat.setDuration(OplusGLSurfaceView_15);
        valueAnimatorOfFloat.setStartDelay(j2);
        valueAnimatorOfFloat.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ModePickerView.this.m20406g(((Float) valueAnimator.getAnimatedValue()).floatValue());
                ModePickerView.this.invalidate();
            }
        });
        valueAnimatorOfFloat.addListener(animatorListener);
        return valueAnimatorOfFloat;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m20395d(boolean z) {
        int OplusGLSurfaceView_13 = z ? 0 : 255;
        int i2 = z ? 255 : 0;
        int i3 = z ? -this.f19058aK : 0;
        int i4 = z ? 0 : -this.f19058aK;
        int i5 = z ? 150 : 0;
        this.f19060aM = OplusGLSurfaceView_13;
        float f2 = i3;
        this.f19061aN = f2;
        invalidate();
        this.f19099j = ValueAnimator.ofInt(OplusGLSurfaceView_13, i2);
        long OplusGLSurfaceView_15 = 400;
        this.f19099j.setDuration(OplusGLSurfaceView_15);
        long j2 = i5;
        this.f19099j.setStartDelay(j2);
        this.f19099j.setInterpolator(this.f19102m);
        this.f19099j.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ModePickerView.this.f19060aM = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ModePickerView.this.invalidate();
            }
        });
        this.f19099j.start();
        this.f19100k = ValueAnimator.ofFloat(f2, i4);
        this.f19100k.setDuration(OplusGLSurfaceView_15);
        this.f19100k.setStartDelay(j2);
        this.f19100k.setInterpolator(this.f19101l);
        this.f19100k.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ModePickerView.this.f19061aN = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ModePickerView.this.invalidate();
            }
        });
        this.f19100k.addListener(new Animator.AnimatorListener() { // from class: com.oplus.camera.ui.menu.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ModePickerView.this.invalidate();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ModePickerView.this.f19059aL = false;
                ModePickerView.this.invalidate();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                ModePickerView.this.f19059aL = false;
                ModePickerView.this.invalidate();
            }
        });
        this.f19100k.start();
    }

    @Override // android.view.View
    public void setVisibility(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("ModePickerView", "setVisibility, visibility: " + OplusGLSurfaceView_13);
        super.setVisibility(OplusGLSurfaceView_13);
        HeadlineBackground c3236b = this.f19067ac;
        if (c3236b != null) {
            c3236b.m20341a(OplusGLSurfaceView_13, this);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m20408h(int OplusGLSurfaceView_13) {
        m20406g(1.0f);
        this.f19056aI = 0.0f;
        this.f19061aN = 0.0f;
        this.f19060aM = 255;
        setVisibility(OplusGLSurfaceView_13);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m20457e(int OplusGLSurfaceView_13) {
        m20408h(OplusGLSurfaceView_13);
        this.f19067ac.setOffsetY(this.f19056aI);
        invalidate();
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public void m20466n() {
        this.f19056aI = 0.0f;
        this.f19067ac.setOffsetY(this.f19056aI);
        invalidate();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20430a(int OplusGLSurfaceView_13, int i2, boolean z, boolean z2) throws Resources.NotFoundException {
        ValueAnimator valueAnimator;
        CameraLog.m12954a("ModePickerView", "setVisibility, visibility: " + OplusGLSurfaceView_13 + ", animType: " + i2);
        if (getVisibility() != OplusGLSurfaceView_13 || ((valueAnimator = this.f19098i) != null && valueAnimator.isRunning())) {
            ValueAnimator valueAnimator2 = this.f19098i;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.f19098i.cancel();
                this.f19098i = null;
            }
            if (i2 == 0) {
                m20408h(OplusGLSurfaceView_13);
            } else if (i2 == 1) {
                ValueAnimator valueAnimator3 = this.f19100k;
                if (valueAnimator3 != null && valueAnimator3.isRunning()) {
                    this.f19100k.cancel();
                }
                ValueAnimator valueAnimator4 = this.f19099j;
                if (valueAnimator4 != null && valueAnimator4.isRunning()) {
                    this.f19099j.cancel();
                    this.f19099j = null;
                }
                this.f19056aI = 0.0f;
                this.f19061aN = 0.0f;
                this.f19060aM = 255;
                if (OplusGLSurfaceView_13 == 0) {
                    m20432a(OplusGLSurfaceView_13, 160L, 0L, this.f19102m, z, i2);
                } else {
                    m20432a(OplusGLSurfaceView_13, 250L, 0L, this.f19102m, z, i2);
                }
            } else if (i2 != 2) {
                if (i2 == 3) {
                    if (OplusGLSurfaceView_13 == 0) {
                        if (this.f19067ac != null) {
                            this.f19067ac.m20340a((int) m20401f(this.f19103n.getInterpolation(1.0f)), (int) (((this.f19034K / 2.0f) / this.f19083as) / (this.f19088ax / 2.0f)), 250, 150);
                        }
                        m20432a(OplusGLSurfaceView_13, 250L, 150L, this.f19102m, z, i2);
                    } else {
                        m20432a(OplusGLSurfaceView_13, 250L, 0L, this.f19102m, z, i2);
                    }
                }
            } else if (OplusGLSurfaceView_13 == 0) {
                m20432a(OplusGLSurfaceView_13, 300L, z2 ? 300 : 100, this.f19102m, z, i2);
            } else {
                m20432a(OplusGLSurfaceView_13, 250L, 0L, this.f19102m, z, i2);
            }
            this.f19067ac.setOffsetY(this.f19056aI);
        }
    }

    /* compiled from: ModePickerView.java */
    /* renamed from: com.oplus.camera.ui.menu.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8$COUIBaseListPopupWindow_12 */
    private class COUIBaseListPopupWindow_12 extends SimpleSpringListener {
        private COUIBaseListPopupWindow_12() {
        }

        @Override // com.p078a.p079a.SimpleSpringListener, com.p078a.p079a.SpringListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo5464a(Spring c1032f) {
            synchronized (ModePickerView.this.f19091b) {
                ModePickerView.this.f19041R = (float) c1032f.m5478c();
                ModePickerView.this.invalidate();
            }
        }

        @Override // com.p078a.p079a.SimpleSpringListener, com.p078a.p079a.SpringListener
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo5465b(Spring c1032f) {
            CameraLog.m12954a("ModePickerView", "onSpringAtRest, mSlideAnim completed");
            if (ModePickerView.this.f19064aQ) {
                ModePickerView.this.f19064aQ = false;
                ModePickerView c3239e = ModePickerView.this;
                c3239e.m20368a(c3239e.f19106q);
            }
        }
    }

    /* renamed from: t */
    private void m20423t() {
        this.f19044U = SpringSystem.m5492c().m5449b().m5472a(SpringConfig.m5490b(2.0d, 35.0d));
        this.f19044U.m5473a(new COUIBaseListPopupWindow_12());
    }

    /* compiled from: ModePickerView.java */
    /* renamed from: com.oplus.camera.ui.menu.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 extends GestureDetector.SimpleOnGestureListener {
        private PlatformImplementations.kt_3() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) throws Resources.NotFoundException {
            if (ModePickerView.this.f19054aG != null && ModePickerView.this.f19054aG.mo19202p(ModePickerView.this.f19024A)) {
                if (ModePickerView.this.f19054aG != null && (ModePickerView.this.f19054aG.mo19075Y() || ModePickerView.this.f19054aG.mo19076Z())) {
                    CameraLog.m12954a("ModePickerView", "DefaultGestureDetector, onSingleTapUp, so return when isCapturingOrVideoRecording or isNoneSatUltraWideAngleChanging");
                    return false;
                }
                if (ModePickerView.this.m20463k() || ModePickerView.this.m20464l() || ModePickerView.this.getVisibility() != 0 || ModePickerView.this.f19054aG.mo19139az()) {
                    CameraLog.m12954a("ModePickerView", "DefaultGestureDetector, onSingleTapUp, can't response TouchEvent , isAnimationRunning or View is not visible");
                    return false;
                }
                if (!ModePickerView.this.m20455d(1)) {
                    if (ModePickerView.this.m20422s()) {
                        ModePickerView.this.f19064aQ = true;
                        ModePickerView.this.f19044U.m5487j();
                    }
                    float rawX = motionEvent.getRawX();
                    float y = motionEvent.getY();
                    int previewFrameWidth = ModePickerView.this.getPreviewFrameWidth();
                    if (3 == ModePickerView.this.f19062aO) {
                        previewFrameWidth = ModePickerView.this.f19063aP.m16505b();
                        rawX -= ModePickerView.this.f19063aP.mo16496a(ModePickerView.this.f19066ab).m23884a();
                    } else if (4 == ModePickerView.this.f19062aO) {
                        previewFrameWidth = ModePickerView.this.getResources().getDimensionPixelSize(R.dimen.rack_mode_headline_width);
                        rawX = motionEvent.getX(motionEvent.getActionIndex());
                    }
                    if (previewFrameWidth > 0 && Float.compare(rawX, 0.0f) >= 0 && Float.compare(rawX, previewFrameWidth) <= 0) {
                        int iM20426a = ModePickerView.this.m20426a(rawX - (previewFrameWidth / 2), y);
                        ModePickerView.this.f19048aA = false;
                        synchronized (ModePickerView.this.f19047a) {
                            if (iM20426a >= 0) {
                                try {
                                    ModePickerView.this.setCurrentIndex(iM20426a);
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            if (iM20426a < 0 || ModePickerView.this.f19054aG == null) {
                                if (iM20426a == -2 && ModePickerView.this.f19054aG != null) {
                                    ModePickerView.this.f19054aG.mo19138ay();
                                }
                            } else {
                                ModePickerView.this.f19054aG.mo19198o(ModePickerView.this.f19024A);
                            }
                        }
                        return true;
                    }
                    return super.onSingleTapUp(motionEvent);
                }
                CameraLog.m12954a("ModePickerView", "DefaultGestureDetector, onSingleTapUp, follow finger can't response TouchEvent");
                return false;
            }
            CameraLog.m12959b("ModePickerView", "DefaultGestureDetector, onSingleTapUp, can't response TouchEvent.");
            return false;
        }
    }

    /* compiled from: ModePickerView.java */
    /* renamed from: com.oplus.camera.ui.menu.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_5 */
    private class IntrinsicsJvm.kt_5 extends GestureDetector.SimpleOnGestureListener {
        private IntrinsicsJvm.kt_5() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) throws Resources.NotFoundException {
            if (ModePickerView.this.f19049aB) {
                if (ModePickerView.this.f19054aG != null && (ModePickerView.this.f19054aG.mo19075Y() || ModePickerView.this.f19054aG.mo19076Z())) {
                    CameraLog.m12954a("ModePickerView", "DefaultVerticalGestureDetector, onSingleTapUp, so return when isCapturingOrVideoRecording or isNoneSatUltraWideAngleChanging");
                    return false;
                }
                if (ModePickerView.this.m20463k() || ModePickerView.this.getVisibility() != 0) {
                    CameraLog.m12954a("ModePickerView", "DefaultVerticalGestureDetector, onSingleTapUp, can't response TouchEvent , isAnimationRunning or View is not visible");
                    return false;
                }
                if (!ModePickerView.this.m20455d(1)) {
                    if (ModePickerView.this.m20422s()) {
                        ModePickerView.this.f19064aQ = true;
                        ModePickerView.this.f19044U.m5487j();
                    }
                    float y = motionEvent.getY(motionEvent.getActionIndex());
                    int dimensionPixelSize = ModePickerView.this.getResources().getDimensionPixelSize(R.dimen.vertical_headline_height);
                    if (dimensionPixelSize > 0 && Float.compare(y, 0.0f) >= 0 && Float.compare(y, dimensionPixelSize) <= 0) {
                        int iM20425a = ModePickerView.this.m20425a(y - (dimensionPixelSize / 2));
                        ModePickerView.this.f19048aA = false;
                        synchronized (ModePickerView.this.f19047a) {
                            if (iM20425a >= 0) {
                                try {
                                    ModePickerView.this.setCurrentIndex(iM20425a);
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            if (iM20425a < 0 || ModePickerView.this.f19054aG == null) {
                                if (iM20425a == -2 && ModePickerView.this.f19054aG != null) {
                                    ModePickerView.this.f19054aG.mo19138ay();
                                }
                            } else {
                                ModePickerView.this.f19054aG.mo19198o(ModePickerView.this.f19024A);
                            }
                        }
                        return true;
                    }
                    return super.onSingleTapUp(motionEvent);
                }
                CameraLog.m12954a("ModePickerView", "DefaultVerticalGestureDetector, onSingleTapUp, follow finger can't response TouchEvent");
                return false;
            }
            CameraLog.m12959b("ModePickerView", "DefaultVerticalGestureDetector, onSingleTapUp, can't response TouchEvent.");
            return false;
        }
    }

    /* renamed from: o */
    public boolean m20467o() {
        return getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m20406g(float f2) {
        CameraLog.m12954a("ModePickerView", "updateAlpha, alpha: " + f2);
        if (!this.f19059aL) {
            setAlpha(f2);
        }
        setBGAlphaValue(f2);
        m20460h();
    }

    private void setBGAlphaValue(float f2) {
        synchronized (this.f19091b) {
            this.f19040Q = f2;
            invalidate();
        }
    }

    /* compiled from: ModePickerView.java */
    /* renamed from: com.oplus.camera.ui.menu.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_3 */
    private class IntrinsicsJvm.kt_3 implements Animator.AnimatorListener {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private Animator.AnimatorListener f19130b;

        public IntrinsicsJvm.kt_3(Animator.AnimatorListener animatorListener) {
            this.f19130b = null;
            this.f19130b = animatorListener;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            CameraLog.m12954a("ModePickerView", "DefaultShowAnimatorListener, onAnimationStart");
            Animator.AnimatorListener animatorListener = this.f19130b;
            if (animatorListener != null) {
                animatorListener.onAnimationStart(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            CameraLog.m12954a("ModePickerView", "DefaultShowAnimatorListener, onAnimationEnd");
            ModePickerView.this.m20406g(1.0f);
            ModePickerView.this.setEnabled(true);
            Animator.AnimatorListener animatorListener = this.f19130b;
            if (animatorListener != null) {
                animatorListener.onAnimationEnd(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            CameraLog.m12954a("ModePickerView", "DefaultShowAnimatorListener, onAnimationCancel");
            ModePickerView.this.m20406g(1.0f);
            ModePickerView.this.setEnabled(true);
            Animator.AnimatorListener animatorListener = this.f19130b;
            if (animatorListener != null) {
                animatorListener.onAnimationCancel(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Animator.AnimatorListener animatorListener = this.f19130b;
            if (animatorListener != null) {
                animatorListener.onAnimationRepeat(animator);
            }
        }
    }

    /* compiled from: ModePickerView.java */
    /* renamed from: com.oplus.camera.ui.menu.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_4 */
    private class IntrinsicsJvm.kt_4 implements Animator.AnimatorListener {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private Animator.AnimatorListener f19128b;

        public IntrinsicsJvm.kt_4(Animator.AnimatorListener animatorListener) {
            this.f19128b = null;
            this.f19128b = animatorListener;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            CameraLog.m12954a("ModePickerView", "DefaultHideAnimatorListener, onAnimationStart");
            ModePickerView.this.setVisibility(0);
            Animator.AnimatorListener animatorListener = this.f19128b;
            if (animatorListener != null) {
                animatorListener.onAnimationStart(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            CameraLog.m12954a("ModePickerView", "DefaultHideAnimatorListener, onAnimationEnd");
            ModePickerView.this.setVisibility(4);
            ModePickerView.this.m20406g(1.0f);
            ModePickerView.this.setEnabled(true);
            Animator.AnimatorListener animatorListener = this.f19128b;
            if (animatorListener != null) {
                animatorListener.onAnimationEnd(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            CameraLog.m12954a("ModePickerView", "DefaultHideAnimatorListener, onAnimationCancel");
            ModePickerView.this.setVisibility(4);
            ModePickerView.this.m20406g(1.0f);
            ModePickerView.this.setEnabled(true);
            Animator.AnimatorListener animatorListener = this.f19128b;
            if (animatorListener != null) {
                animatorListener.onAnimationCancel(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Animator.AnimatorListener animatorListener = this.f19128b;
            if (animatorListener != null) {
                animatorListener.onAnimationRepeat(animator);
            }
        }
    }

    /* renamed from: u */
    private int[] m20424u() {
        if (this.f19073ai) {
            return new int[]{436207616, getResources().getColor(R.color.color_black_with_full_percent_transparency), getResources().getColor(R.color.color_black_with_full_percent_transparency), getResources().getColor(R.color.color_white_with_full_percent_transparency), getResources().getColor(R.color.color_white_with_full_percent_transparency), getResources().getColor(R.color.color_black_with_full_percent_transparency), getResources().getColor(R.color.color_black_with_full_percent_transparency), 436207616};
        }
        return new int[]{getResources().getColor(R.color.color_white_with_0_percent_transparency), getResources().getColor(R.color.color_white_with_full_percent_transparency), getResources().getColor(R.color.color_white_with_full_percent_transparency), getResources().getColor(R.color.color_black_with_full_percent_transparency), getResources().getColor(R.color.color_black_with_full_percent_transparency), getResources().getColor(R.color.color_white_with_full_percent_transparency), getResources().getColor(R.color.color_white_with_full_percent_transparency), getResources().getColor(R.color.color_white_with_0_percent_transparency)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getPreviewFrameWidth() {
        int OplusGLSurfaceView_13 = this.f19062aO;
        if (3 == OplusGLSurfaceView_13) {
            return Util.getScreenWidth() / 2;
        }
        if (4 == OplusGLSurfaceView_13) {
            return getResources().getDimensionPixelSize(R.dimen.rack_mode_headline_width);
        }
        return Util.getScreenWidth();
    }
}
