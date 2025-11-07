package com.oplus.camera.p172ui.preview;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.SweepGradient;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Size;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import com.oplus.camera.ZoomUnit;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.p172ui.preview.ZoomSeekBar;
import com.oplus.camera.util.BackgroundUtil;
import com.oplus.camera.util.Util;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ZoomArcSeekBar.java */
/* renamed from: com.oplus.camera.ui.preview.af */
/* loaded from: classes2.dex */
public class ZoomArcSeekBar extends ZoomSeekBar {

    /* renamed from: di */
    private static float f21656di = 0.5f;

    /* renamed from: dA */
    private RectF f21657dA;

    /* renamed from: dB */
    private SweepGradient f21658dB;

    /* renamed from: dC */
    private int[] f21659dC;

    /* renamed from: dD */
    private float[] f21660dD;

    /* renamed from: dE */
    private int f21661dE;

    /* renamed from: dF */
    private int f21662dF;

    /* renamed from: dG */
    private int f21663dG;

    /* renamed from: dH */
    private int f21664dH;

    /* renamed from: dI */
    private int f21665dI;

    /* renamed from: dJ */
    private int f21666dJ;

    /* renamed from: dK */
    private int f21667dK;

    /* renamed from: dL */
    private float f21668dL;

    /* renamed from: dM */
    private float f21669dM;

    /* renamed from: dN */
    private float f21670dN;

    /* renamed from: dO */
    private float f21671dO;

    /* renamed from: dP */
    private Paint f21672dP;

    /* renamed from: dQ */
    private Paint f21673dQ;

    /* renamed from: dR */
    private Map<String, Size> f21674dR;

    /* renamed from: dS */
    private int f21675dS;

    /* renamed from: dj */
    private int f21676dj;

    /* renamed from: dk */
    private int f21677dk;

    /* renamed from: dl */
    private int f21678dl;

    /* renamed from: dm */
    private float f21679dm;

    /* renamed from: dn */
    private float f21680dn;

    /* renamed from: do */
    private Paint f21681do;

    /* renamed from: dp */
    private Paint f21682dp;

    /* renamed from: dq */
    private Paint f21683dq;

    /* renamed from: dr */
    private int f21684dr;

    /* renamed from: ds */
    private int f21685ds;

    /* renamed from: dt */
    private int f21686dt;

    /* renamed from: du */
    private int f21687du;

    /* renamed from: dv */
    private int f21688dv;

    /* renamed from: dw */
    private int f21689dw;

    /* renamed from: dx */
    private int f21690dx;

    /* renamed from: dy */
    private TextPaint f21691dy;

    /* renamed from: dz */
    private int f21692dz;

    @Override // com.oplus.camera.p172ui.preview.ZoomSeekBar
    public int getType() {
        return 1;
    }

    public ZoomArcSeekBar(Context context) {
        super(context);
        this.f21676dj = 0;
        this.f21677dk = 0;
        this.f21678dl = 0;
        this.f21679dm = 27.0f;
        this.f21680dn = 39.0f;
        this.f21681do = null;
        this.f21682dp = null;
        this.f21683dq = null;
        this.f21684dr = 0;
        this.f21685ds = 0;
        this.f21686dt = 0;
        this.f21687du = 0;
        this.f21688dv = 0;
        this.f21689dw = 0;
        this.f21690dx = 0;
        this.f21691dy = null;
        this.f21692dz = 0;
        this.f21657dA = null;
        this.f21658dB = null;
        this.f21659dC = null;
        this.f21660dD = null;
        this.f21661dE = 0;
        this.f21662dF = 0;
        this.f21663dG = 0;
        this.f21664dH = 0;
        this.f21665dI = 0;
        this.f21666dJ = 0;
        this.f21667dK = 0;
        this.f21668dL = 0.0f;
        this.f21669dM = 0.0f;
        this.f21670dN = 0.0f;
        this.f21671dO = 0.0f;
        this.f21672dP = null;
        this.f21673dQ = null;
        this.f21674dR = new HashMap();
        this.f21675dS = 0;
        m23063E();
    }

    @Override // com.oplus.camera.p172ui.preview.ZoomSeekBar
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo23076a(float COUIBaseListPopupWindow_12, float f2, float f3, ArrayList<Float> arrayList, ArrayList<Float> arrayList2, int OplusGLSurfaceView_13, boolean z, boolean z2, boolean z3) {
        if (arrayList.size() > 0 && Float.compare(f3, arrayList.get(arrayList.size() - 1).floatValue()) > 0) {
            arrayList.add(Float.valueOf(f3));
        }
        this.f21674dR.clear();
        super.mo23076a(COUIBaseListPopupWindow_12, CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_OPLUS_NIGHT_MODE_MAX_ZOOM_SUPPORT) ? new BigDecimal(f2).setScale(1, 1).floatValue() : f2, f3, arrayList, arrayList2, OplusGLSurfaceView_13, z, z2, z3);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23077a(int OplusGLSurfaceView_13, int i2, int i3, int i4, float COUIBaseListPopupWindow_12, float f2, float f3) {
        this.f17499R = OplusGLSurfaceView_13;
        this.f17511af = (this.f17499R * 1.0f) / 2.0f;
        this.f21820cf = i3;
        this.f21825ck = (this.f17511af - (this.f21820cf * 2.0f)) - this.f21822ch;
        this.f21829co = this.f17511af + (this.f21820cf * 2.0f) + this.f21822ch;
        if (1 == getLayoutDirection()) {
            float f4 = this.f21825ck;
            this.f21825ck = this.f21829co;
            this.f21829co = f4;
        }
        m23146b(this.f21833cs, true);
        this.f21677dk = i2;
        this.f21671dO = (this.f21677dk - (this.f21664dH / 2)) - this.f21733aw.getResources().getDimensionPixelSize(R.dimen.zoom_arc_seekbar_indicator_line_padding_top);
        this.f17512ag = i4;
        this.f17513ah = COUIBaseListPopupWindow_12;
        this.f21821cg = f2 * this.f21734ax.getDimension(R.dimen.zoom_seekbar_oval_stroke_width);
        this.f21755bS.setStrokeWidth(this.f21821cg);
        this.f21679dm = 27.0f + f3;
        this.f21680dn = f3 + 39.0f;
    }

    /* renamed from: E */
    private void m23063E() {
        Resources resources = this.f21733aw.getResources();
        this.f21676dj = resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_unfold_anim_radius_between_distance);
        this.f21677dk = resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_bg_circle_radius);
        this.f17512ag = resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_focus_circle_center_y);
        this.f21669dM = resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_indicator_focus_center_y);
        this.f21670dN = resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_indicator_icon_y);
        this.f21667dK = resources.getDimensionPixelSize(R.dimen.num_seekbar_section_radius);
        this.f21690dx = resources.getDimensionPixelSize(R.dimen.zoom_current_focus_change_move_distance);
        this.f21684dr = BackgroundUtil.m24523a(resources.getColor(R.color.zoom_arc_seekbar_bg_color));
        this.f21681do = new Paint();
        this.f21681do.setAntiAlias(true);
        this.f21681do.setStyle(Paint.Style.FILL);
        this.f21681do.setColor(this.f21684dr);
        this.f21687du = this.f21681do.getAlpha();
        this.f21678dl = resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_bg_stroke_width);
        this.f21685ds = resources.getColor(R.color.zoom_arc_seekbar_bg_stroke_color);
        this.f21682dp = new Paint();
        this.f21682dp.setAntiAlias(true);
        this.f21682dp.setStyle(Paint.Style.STROKE);
        this.f21682dp.setStrokeWidth(this.f21678dl);
        this.f21682dp.setColor(this.f21685ds);
        this.f21686dt = this.f21682dp.getAlpha();
        this.f21683dq = new Paint();
        this.f21683dq.setAntiAlias(true);
        this.f21683dq.setStyle(Paint.Style.STROKE);
        this.f21683dq.setStrokeWidth(this.f21678dl);
        this.f21692dz = resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_marker_arc_radius);
        int OplusGLSurfaceView_13 = this.f21685ds;
        this.f21659dC = new int[]{Color.parseColor("#00FFFFFF"), OplusGLSurfaceView_13, OplusGLSurfaceView_13, Color.parseColor("#00FFFFFF")};
        this.f21660dD = getSweepGradientPositions();
        this.f21658dB = new SweepGradient(this.f17511af, this.f21677dk, this.f21659dC, this.f21660dD);
        this.f21703aD = resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_focus_circle_radius_pressed);
        this.f21711aL = resources.getColor(R.color.zoom_arc_seekbar_indicator_circle_color);
        this.f21661dE = resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_indicator_circle_stroke_width);
        this.f21662dF = resources.getColor(R.color.zoom_arc_seekbar_indicator_circle_stroke_color);
        this.f21737bA = new Paint();
        this.f21737bA.setAntiAlias(true);
        this.f21737bA.setStyle(Paint.Style.FILL);
        this.f21737bA.setColor(this.f21711aL);
        this.f21724aY = this.f21737bA.getAlpha();
        this.f21673dQ = new Paint();
        this.f21673dQ.setAntiAlias(true);
        this.f21673dQ.setStyle(Paint.Style.STROKE);
        this.f21673dQ.setStrokeWidth(this.f21661dE);
        this.f21673dQ.setColor(this.f21662dF);
        this.f21745bI = new TextPaint(1);
        this.f21719aT = resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_indicator_text_size);
        this.f21745bI.setTextSize(this.f21719aT);
        this.f21745bI.setColor(-1);
        this.f21745bI.setTextAlign(Paint.Align.CENTER);
        this.f21745bI.setTypeface(Util.m24473l(this.f21733aw));
        this.f21691dy = new TextPaint(1);
        this.f21688dv = resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_mark_text_size);
        this.f21691dy.setTextSize(this.f21688dv);
        this.f21691dy.setColor(-1);
        this.f21691dy.setTextAlign(Paint.Align.CENTER);
        this.f21691dy.setTypeface(Util.m24411c(true));
        this.f21689dw = resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_marker_center_margin_top);
        this.f21675dS = resources.getDimensionPixelSize(R.dimen.zoom_seek_arc_bar_mark_button_click_size);
        Paint.FontMetrics fontMetrics = this.f21745bI.getFontMetrics();
        this.f21668dL = ((fontMetrics.bottom - fontMetrics.top) / 2.0f) - fontMetrics.bottom;
        this.f21663dG = resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_indicator_line_width);
        this.f21664dH = resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_indicator_line_height);
        this.f21671dO = (this.f21677dk - (this.f21664dH / 2)) - resources.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_indicator_line_padding_top);
        this.f21672dP = new Paint(1);
        this.f21665dI = this.f21733aw.getColor(R.color.color_white_with_50_percent_transparency);
        this.f21666dJ = this.f21733aw.getColor(R.color.color_white_with_15_percent_transparency);
    }

    @Override // com.oplus.camera.p172ui.preview.ZoomSeekBar
    public int getLayoutHeight() {
        return this.f21734ax.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_height);
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private void m23070l(float COUIBaseListPopupWindow_12) {
        m23072n(COUIBaseListPopupWindow_12);
    }

    @Override // com.oplus.camera.p172ui.CameraSeekBar
    /* renamed from: COUIBaseListPopupWindow_12 */
    protected void mo18526f() {
        super.mo18526f();
        m23070l(1.0f);
    }

    @Override // com.oplus.camera.p172ui.preview.ZoomSeekBar
    /* renamed from: PlatformImplementations.kt_3 */
    public String mo23075a(float COUIBaseListPopupWindow_12, float f2) {
        for (Map.Entry<String, Size> entry : this.f21674dR.entrySet()) {
            Size value = entry.getValue();
            if (((int) Math.pow(Math.abs(value.getWidth() - COUIBaseListPopupWindow_12) + Math.abs(value.getHeight() - f2), 2.0d)) <= Math.pow(this.f21675dS, 2.0d)) {
                CameraLog.m12954a("ZoomArcSeekBar", "onClickZoomArcSeekBar, touched zoom value : " + entry.getKey());
                return entry.getKey();
            }
        }
        return "";
    }

    @Override // com.oplus.camera.p172ui.preview.ZoomSeekBar, com.oplus.camera.p172ui.CameraSeekBar
    /* renamed from: COUIBaseListPopupWindow_11 */
    protected void mo18529g(Canvas canvas) throws Resources.NotFoundException {
        if (0.0f != this.f17549z) {
            m23070l(this.f17484C);
            m23067b(canvas, this.f17485D);
            if (this.f21797cI == null || this.f21796cH == null) {
                m23163x();
            }
            this.f21797cI.drawPaint(this.f21744bH);
            this.f21796cH.drawPaint(this.f21744bH);
            m23069b(this.f21797cI, this.f21810cV, this.f17486E, this.f17485D);
            this.f21797cI.drawBitmap(this.f21794cF, 0.0f, 0.0f, this.f21743bG);
            canvas.drawBitmap(this.f21795cG, 0.0f, 0.0f, this.f21743bG);
        }
        m23066a(canvas, this.f21810cV);
        super.mo18529g(canvas);
    }

    @Override // com.oplus.camera.p172ui.CameraSeekBar
    /* renamed from: COUIBaseListPopupWindow_12 */
    protected void mo18527f(Canvas canvas) throws Resources.NotFoundException {
        m23070l(this.f17484C);
        m23079u();
        if (1.0f != this.f17549z) {
            m23067b(canvas, this.f17485D);
            if (this.f21797cI == null || this.f21796cH == null) {
                m23163x();
            }
            this.f21797cI.drawPaint(this.f21744bH);
            this.f21796cH.drawPaint(this.f21744bH);
            m23069b(this.f21797cI, this.f21810cV, this.f17486E, this.f17485D);
            this.f21797cI.drawBitmap(this.f21794cF, 0.0f, 0.0f, this.f21743bG);
            canvas.drawBitmap(this.f21795cG, 0.0f, 0.0f, this.f21743bG);
        }
        m23066a(canvas, this.f21812cX);
        super.mo18527f(canvas);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23066a(Canvas canvas, String str) {
        float COUIBaseListPopupWindow_12 = this.f17482A;
        float f2 = this.f17483B;
        this.f21753bQ.setAlpha(Math.round(255.0f * COUIBaseListPopupWindow_12));
        this.f21754bR.setAlpha(Math.round(Color.alpha(this.f21760bX) * COUIBaseListPopupWindow_12));
        this.f17515aj.setAlpha(Math.round(Color.alpha(this.f21757bU) * COUIBaseListPopupWindow_12));
        this.f21755bS.setAlpha(Math.round(COUIBaseListPopupWindow_12 * Color.alpha(this.f21761bY)));
        m23138a(canvas, this.f21823ci, this.f17512ag - (this.f21690dx * f2), 0.0f);
        m23142a(canvas, str, this.f21823ci, this.f17512ag - (f2 * this.f21690dx), this.f21833cs);
    }

    @Override // com.oplus.camera.p172ui.CameraSeekBar
    /* renamed from: OplusGLSurfaceView_15 */
    public void mo18535j(Canvas canvas) throws Resources.NotFoundException {
        m23079u();
        m23067b(canvas, 1.0f);
        if (this.f21797cI == null || this.f21796cH == null) {
            m23163x();
        }
        this.f21797cI.drawPaint(this.f21744bH);
        this.f21796cH.drawPaint(this.f21744bH);
        m23069b(this.f21797cI, this.f21810cV, 1.0f, 1.0f);
        this.f21797cI.drawBitmap(this.f21794cF, 0.0f, 0.0f, this.f21743bG);
        canvas.drawBitmap(this.f21795cG, 0.0f, 0.0f, this.f21743bG);
    }

    @Override // com.oplus.camera.p172ui.CameraSeekBar
    /* renamed from: p */
    public void mo18541p() {
        CameraLog.m12954a("ZoomArcSeekBar", "onScaleBegin, mStatus: " + this.f17500S);
        if (!isShown() || this.f17501T || this.f17503V) {
            return;
        }
        if (this.f17500S == 0 || 10 == this.f17500S) {
            this.f17503V = true;
            if (this.f17538o != null && this.f17538o.isStarted()) {
                this.f17495N = this.f21856da;
                this.f17497P = this.f21858dc;
                this.f17496O = this.f21857db;
                this.f17537n.setCurrentFraction(m23064a(this.f17537n.getInterpolator(), this.f17487F, 0.0f, 1.0f));
                this.f17538o.cancel();
            } else {
                this.f17495N = -1.0f;
                this.f17497P = -1.0f;
                this.f17496O = -1.0f;
            }
            this.f21715aP = this.f21713aN;
            if (this.f17539p != null && this.f17539p.isStarted()) {
                this.f17540q.setCurrentFraction(m23064a(this.f17540q.getInterpolator(), this.f17494M, 255.0f, 0.0f));
                this.f17539p.cancel();
            }
            this.f17540q.start();
            this.f17537n.start();
            setStatus(8);
        }
    }

    @Override // com.oplus.camera.p172ui.CameraSeekBar
    /* renamed from: q */
    public void mo18542q() {
        CameraLog.m12954a("ZoomArcSeekBar", "onScaleEnd, mStatus: " + this.f17500S);
        if (9 == this.f17500S || 8 == this.f17500S) {
            this.f17503V = false;
            if (this.f17537n != null && this.f17537n.isStarted()) {
                if (m23131a(this.f21715aP) != m23131a(this.f21713aN)) {
                    this.f17495N = this.f21856da;
                    this.f17497P = this.f21858dc;
                    this.f17496O = this.f21857db;
                    this.f17538o.setCurrentFraction(m23064a(this.f17538o.getInterpolator(), 1.0f - this.f17487F, 1.0f, 0.0f));
                } else {
                    this.f17538o.setCurrentFraction(m23064a(this.f17538o.getInterpolator(), this.f17487F, 1.0f, 0.0f));
                }
                this.f17537n.cancel();
            } else {
                this.f17495N = -1.0f;
                this.f17497P = -1.0f;
                this.f17496O = -1.0f;
            }
            if (this.f17540q != null && this.f17540q.isStarted()) {
                this.f17539p.setCurrentFraction(m23064a(this.f17539p.getInterpolator(), this.f17494M, 0.0f, 255.0f));
                this.f17540q.cancel();
            }
            this.f17539p.start();
            this.f17538o.start();
            setStatus(10);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private float m23064a(TimeInterpolator timeInterpolator, float COUIBaseListPopupWindow_12, float f2, float f3) {
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

    @Override // com.oplus.camera.p172ui.CameraSeekBar
    /* renamed from: IntrinsicsJvm.kt_3 */
    protected void mo18520c(Canvas canvas) {
        m23162w();
        if (1.0f > this.f17487F) {
            m23138a(canvas, this.f21823ci, this.f17512ag, this.f17487F);
            m23065a(canvas, this.f17494M, this.f17487F);
            int currentBarIndex = getCurrentBarIndex();
            if (currentBarIndex == 1) {
                this.f21814cZ = this.f21824cj;
            } else if (currentBarIndex == 2) {
                this.f21814cZ = this.f21823ci;
            } else if (currentBarIndex == 3) {
                this.f21814cZ = this.f21828cn;
            }
            this.f21856da = this.f21814cZ - ((this.f21814cZ - this.f17511af) * this.f17487F);
            m23137a(canvas, this.f21856da, this.f17512ag);
            canvas.save();
            canvas.rotate(-this.f21721aV, this.f21856da, this.f17512ag);
            canvas.drawText(this.f21810cV, this.f21856da, this.f17512ag + this.f21763ba, this.f17515aj);
            canvas.restore();
            return;
        }
        mo18523d(canvas);
        setStatus(9);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23065a(Canvas canvas, int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) {
        this.f17544u.setAlpha(OplusGLSurfaceView_13);
        if (this.f21833cs == 1 && getCurrentBarIndex() != 1) {
            this.f21857db = this.f21824cj - ((this.f21824cj - this.f17511af) * COUIBaseListPopupWindow_12);
            canvas.save();
            canvas.rotate(-this.f21721aV, this.f21857db, this.f17512ag);
            canvas.drawBitmap(this.f21818cd.get(ZoomSeekBar.IntrinsicsJvm.kt_4.ULTRA_WIDE), this.f21857db - this.f21826cl, this.f17512ag - this.f21827cm, this.f17544u);
            canvas.restore();
        }
        if (getCurrentBarIndex() != 3 && this.f21736az) {
            this.f21858dc = this.f21828cn - ((this.f21828cn - this.f17511af) * COUIBaseListPopupWindow_12);
            canvas.save();
            canvas.rotate(-this.f21721aV, this.f21858dc, this.f17512ag);
            canvas.drawBitmap(this.f21818cd.get(ZoomSeekBar.IntrinsicsJvm.kt_4.TELE), this.f21858dc - this.f21830cp, this.f17512ag - this.f21831cq, this.f17544u);
            canvas.restore();
        }
        if (getCurrentBarIndex() != 2) {
            this.f21859dd = this.f21823ci - ((this.f21823ci - this.f17511af) * COUIBaseListPopupWindow_12);
            canvas.save();
            canvas.rotate(-this.f21721aV, this.f21859dd, this.f17512ag);
            canvas.drawBitmap(this.f21818cd.get(ZoomSeekBar.IntrinsicsJvm.kt_4.WIDE), this.f21859dd - this.f21830cp, this.f17512ag - this.f21831cq, this.f17544u);
            canvas.restore();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m23068b(Canvas canvas, int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12) {
        this.f17544u.setAlpha(OplusGLSurfaceView_13);
        if (this.f21833cs == 1 && getCurrentBarIndex() != 1) {
            this.f21857db = this.f21824cj - ((this.f21824cj - this.f17511af) * COUIBaseListPopupWindow_12);
            canvas.save();
            canvas.rotate(-this.f21721aV, this.f21857db, this.f17512ag);
            canvas.drawBitmap(this.f21818cd.get(ZoomSeekBar.IntrinsicsJvm.kt_4.ULTRA_WIDE), this.f21857db - this.f21826cl, this.f17512ag - this.f21827cm, this.f17544u);
            canvas.restore();
        }
        if (getCurrentBarIndex() != 3 && this.f21736az) {
            this.f21858dc = this.f21828cn - ((this.f21828cn - this.f17511af) * COUIBaseListPopupWindow_12);
            canvas.save();
            canvas.rotate(-this.f21721aV, this.f21858dc, this.f17512ag);
            canvas.drawBitmap(this.f21818cd.get(ZoomSeekBar.IntrinsicsJvm.kt_4.TELE), this.f21858dc - this.f21830cp, this.f17512ag - this.f21831cq, this.f17544u);
            canvas.restore();
        }
        if (getCurrentBarIndex() != 2) {
            this.f21859dd = this.f21823ci - ((this.f21823ci - this.f17511af) * COUIBaseListPopupWindow_12);
            canvas.save();
            canvas.rotate(-this.f21721aV, this.f21859dd, this.f17512ag);
            canvas.drawBitmap(this.f21818cd.get(ZoomSeekBar.IntrinsicsJvm.kt_4.WIDE), this.f21859dd - this.f21830cp, this.f17512ag - this.f21831cq, this.f17544u);
            canvas.restore();
        }
    }

    @Override // com.oplus.camera.p172ui.CameraSeekBar
    /* renamed from: IntrinsicsJvm.kt_5 */
    protected void mo18523d(Canvas canvas) {
        m23162w();
        m23138a(canvas, this.f21823ci, this.f17512ag, 1.0f);
        m23137a(canvas, this.f17511af, this.f17512ag);
        canvas.save();
        canvas.rotate(-this.f21721aV, this.f17511af, this.f17512ag);
        canvas.drawText(this.f21810cV, this.f17511af, this.f17512ag + this.f21763ba, this.f17515aj);
        canvas.restore();
    }

    @Override // com.oplus.camera.p172ui.CameraSeekBar
    /* renamed from: COUIBaseListPopupWindow_8 */
    protected void mo18525e(Canvas canvas) {
        m23162w();
        if (0.0f < this.f17487F) {
            m23138a(canvas, this.f21823ci, this.f17512ag, this.f17487F);
            m23068b(canvas, this.f17494M, this.f17487F);
            int currentBarIndex = getCurrentBarIndex();
            if (currentBarIndex == 1) {
                this.f21860de = this.f21824cj;
            } else if (currentBarIndex == 2) {
                this.f21860de = this.f21823ci;
            } else if (currentBarIndex == 3) {
                this.f21860de = this.f21828cn;
            }
            this.f21856da = this.f21860de - ((this.f21860de - this.f17511af) * this.f17487F);
            if (Float.compare(-1.0f, this.f17495N) != 0) {
                this.f21856da = this.f21860de - ((this.f21860de - this.f17495N) * this.f17487F);
            }
            m23137a(canvas, this.f21856da, this.f17512ag);
            canvas.save();
            canvas.rotate(-this.f21721aV, this.f21856da, this.f17512ag);
            canvas.drawText(this.f21810cV, this.f21856da, this.f17512ag + this.f21763ba, this.f17515aj);
            canvas.restore();
            return;
        }
        mo18516b(canvas);
        setStatus(0);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m23069b(Canvas canvas, String str, float COUIBaseListPopupWindow_12, float f2) throws Resources.NotFoundException {
        float totleAngle;
        float f3;
        float f4;
        int OplusGLSurfaceView_13;
        int i2;
        float f5;
        float totleAngle2 = (getTotleAngle() * this.f17509ad) + 90.0f;
        if (TextUtils.isEmpty(str)) {
            CameraLog.m12967f("ZoomArcSeekBar", "drawIndicatorLines, text is null");
            return;
        }
        m23130D();
        float f6 = this.f21671dO;
        int i3 = this.f21676dj;
        float f7 = (f6 - i3) + (i3 * f2);
        int i4 = 0;
        while (i4 < this.f21764bb) {
            float fE = m23153e(i4);
            boolean zB = m23147b(fE);
            float fRound = Math.round(m23149c(fE) * 100.0f) / 100.0f;
            boolean z = (Float.compare(fRound, 10.0f) < 0 && 1.0E-5f >= Math.abs(fRound % 1.0f)) || (Float.compare(fRound, 10.0f) > 0 && 1.0E-5f >= Math.abs(fRound % 10.0f));
            if (1 == getLayoutDirection()) {
                totleAngle = getTotleAngle();
                fE = 1.0f - fE;
            } else {
                totleAngle = getTotleAngle();
            }
            float f8 = totleAngle2 - (totleAngle * fE);
            double IntrinsicsJvm.kt_5 = f8;
            int i5 = i4;
            float fCos = (float) Math.cos(Math.toRadians(IntrinsicsJvm.kt_5));
            float fSin = (float) Math.sin(Math.toRadians(IntrinsicsJvm.kt_5));
            float f9 = this.f17511af + (f7 * fCos);
            float f10 = this.f21677dk - (f7 * fSin);
            this.f21672dP.setStrokeWidth(this.f21664dH);
            int i6 = this.f21663dG;
            float f11 = f9 - ((i6 * 1.0f) / 2.0f);
            float f12 = ((i6 * 1.0f) / 2.0f) + f9;
            if (zB) {
                this.f21672dP.setColor(-1);
            } else if (z) {
                this.f21672dP.setColor(this.f21665dI);
            } else {
                this.f21672dP.setColor(this.f21666dJ);
            }
            int iM23071m = m23071m(f8);
            if (Float.compare(COUIBaseListPopupWindow_12, 1.0f) <= 0) {
                iM23071m = (int) (iM23071m * COUIBaseListPopupWindow_12);
            }
            int i7 = iM23071m;
            this.f21672dP.setAlpha(i7);
            int iSave = canvas.save();
            float f13 = 90.0f - f8;
            canvas.rotate(f13, f9, f10);
            if (Float.compare(fRound, 1.0f) < 0 && !zB && this.f21771bi) {
                canvas.drawCircle((f11 + f12) / 2.0f, (f10 + f10) / 2.0f, this.f21667dK / 2, this.f21672dP);
                f3 = f13;
                i2 = i7;
                f4 = totleAngle2;
                OplusGLSurfaceView_13 = iSave;
                f5 = fRound;
            } else {
                f3 = f13;
                f4 = totleAngle2;
                OplusGLSurfaceView_13 = iSave;
                i2 = i7;
                f5 = fRound;
                canvas.drawLine(f11, f10, f12, f10, this.f21672dP);
            }
            canvas.restoreToCount(OplusGLSurfaceView_13);
            if (zB) {
                String strMo23074a = mo23074a(m23154f(f5));
                int iSave2 = canvas.save();
                this.f21691dy.getTextBounds(strMo23074a, 0, strMo23074a.length(), new Rect());
                float f14 = (f7 - (this.f21664dH / 2)) - this.f21689dw;
                float f15 = this.f17511af + (fCos * f14);
                float f16 = this.f21677dk - (f14 * fSin);
                canvas.rotate(f3, f15, f16);
                canvas.rotate(-this.f21721aV, f15, f16);
                if (Float.compare(COUIBaseListPopupWindow_12, 1.0f) <= 0) {
                    this.f21691dy.setAlpha((int) (255.0f * COUIBaseListPopupWindow_12));
                } else {
                    this.f21691dy.setAlpha(255);
                }
                int dimensionPixelSize = this.f21734ax.getDimensionPixelSize(R.dimen.zoom_arc_seekbar_marker_text_y_offset);
                this.f21691dy.setAlpha(i2);
                canvas.drawText(strMo23074a, f15, dimensionPixelSize + f16, this.f21691dy);
                this.f21674dR.put(Float.toString(m23154f(f5)), new Size((int) f15, ((int) f16) + dimensionPixelSize));
                canvas.restoreToCount(iSave2);
            }
            i4 = i5 + 1;
            totleAngle2 = f4;
        }
        int iSave3 = canvas.save();
        float f17 = this.f21670dN;
        int i8 = this.f21676dj;
        float f18 = (f17 + i8) - (i8 * f2);
        int i9 = Float.compare(COUIBaseListPopupWindow_12, 1.0f) <= 0 ? (int) (255 * COUIBaseListPopupWindow_12) : 255;
        m23140a(canvas, this.f21734ax.getDrawable(R.drawable.zoom_indicator), this.f17511af, (r2.getIntrinsicHeight() / 2) + f18, 1.0f, i9);
        canvas.restoreToCount(iSave3);
    }

    private float[] getSweepGradientPositions() {
        float COUIBaseListPopupWindow_12 = this.f21679dm;
        float f2 = this.f21680dn;
        return new float[]{((COUIBaseListPopupWindow_12 + 180.0f) * 1.0f) / 360.0f, ((180.0f + f2) * 1.0f) / 360.0f, ((360.0f - f2) * 1.0f) / 360.0f, ((360.0f - COUIBaseListPopupWindow_12) * 1.0f) / 360.0f};
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private int m23071m(float COUIBaseListPopupWindow_12) {
        float f2;
        float f3;
        float f4 = this.f21679dm;
        float f5 = this.f21680dn;
        int alpha = this.f21672dP.getAlpha();
        if (COUIBaseListPopupWindow_12 < f5 || COUIBaseListPopupWindow_12 > 180.0f - f5) {
            if (COUIBaseListPopupWindow_12 >= f4 && COUIBaseListPopupWindow_12 <= f5) {
                f2 = (alpha * 1.0f) / (f5 - f4);
                f3 = COUIBaseListPopupWindow_12 - f4;
            } else if (COUIBaseListPopupWindow_12 < 180.0f - f5 || COUIBaseListPopupWindow_12 > 180.0f - f4) {
                alpha = 0;
            } else {
                f2 = (alpha * 1.0f) / (f4 - f5);
                f3 = (COUIBaseListPopupWindow_12 + f4) - 180.0f;
            }
            alpha = (int) (f2 * f3);
        }
        return Math.max(alpha, 0);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m23067b(Canvas canvas, float COUIBaseListPopupWindow_12) {
        canvas.clipRect(this.f21863dh.mo16411a().mo16620a(this.f21733aw.getResources(), new Rect(0, 0, canvas.getWidth(), canvas.getHeight())), Region.Op.INTERSECT);
        float f2 = this.f21677dk - (this.f21676dj * (1.0f - COUIBaseListPopupWindow_12));
        canvas.drawCircle(this.f17511af, this.f21677dk, f2 - this.f21678dl, this.f21681do);
        canvas.drawCircle(this.f17511af, this.f21677dk, f2 - (this.f21678dl * 0.5f), this.f21682dp);
    }

    @Override // com.oplus.camera.p172ui.preview.ZoomSeekBar
    /* renamed from: PlatformImplementations.kt_3 */
    protected boolean mo23078a(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (0.0f > y || y > measuredHeight) {
            return true;
        }
        int OplusGLSurfaceView_13 = measuredWidth / 2;
        return Math.pow((double) Math.abs(x - ((float) OplusGLSurfaceView_13)), 2.0d) + Math.pow(Math.abs(((double) y) - (Math.sqrt(Math.pow((double) this.f21677dk, 2.0d) - Math.pow((double) OplusGLSurfaceView_13, 2.0d)) + ((double) measuredHeight))), 2.0d) < Math.pow((double) this.f21677dk, 2.0d);
    }

    @Override // com.oplus.camera.p172ui.preview.ZoomSeekBar
    /* renamed from: PlatformImplementations.kt_3 */
    public String mo23074a(float COUIBaseListPopupWindow_12) {
        boolean zoomValueUnit = getZoomValueUnit();
        CameraLog.m12954a("ZoomArcSeekBar", "zoomValueUnit, changeUnit:" + zoomValueUnit);
        if (this.f21752bP == null) {
            this.f21752bP = new ZoomUnit();
        }
        return this.f21752bP.m11590a(zoomValueUnit, COUIBaseListPopupWindow_12);
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private void m23072n(float COUIBaseListPopupWindow_12) {
        if (COUIBaseListPopupWindow_12 > 1.0f || COUIBaseListPopupWindow_12 < 0.0f) {
            this.f21681do.setColor(this.f21684dr);
            this.f21682dp.setColor(this.f21685ds);
            this.f21683dq.setColor(this.f21685ds);
        } else {
            this.f21681do.setColor(this.f21684dr);
            this.f21681do.setAlpha((int) (this.f21687du * COUIBaseListPopupWindow_12));
            this.f21682dp.setColor(-1);
            this.f21682dp.setAlpha((int) (this.f21686dt * COUIBaseListPopupWindow_12));
            this.f21683dq.setColor(-1);
            this.f21683dq.setAlpha((int) (this.f21686dt * COUIBaseListPopupWindow_12));
        }
    }

    @Override // com.oplus.camera.p172ui.preview.ZoomSeekBar
    /* renamed from: PlatformImplementations.kt_3 */
    public float mo23073a(float COUIBaseListPopupWindow_12, VelocityTracker velocityTracker) {
        float fMin = Math.min(Math.max(this.f21731au + (((this.f21732av - this.f21731au) / (this.f21729as - this.f21728ar)) * (Math.abs((int) velocityTracker.getXVelocity()) - this.f21728ar)), this.f21731au), this.f21732av);
        if (Math.abs(COUIBaseListPopupWindow_12) <= this.f21727aq && fMin > this.f21731au * 2.0f) {
            fMin /= 2.0f;
        }
        return (-COUIBaseListPopupWindow_12) * fMin;
    }

    /* renamed from: u */
    public void m23079u() {
        if (this.f21863dh == null || this.f21863dh.mo16411a().mo16539j() != 4 || this.f21863dh.mo16411a().mo16630q()) {
            return;
        }
        this.f21681do.setColor(this.f21733aw.getResources().getColor(R.color.zoom_seekbar_focus_circle_stroke_color));
    }
}
