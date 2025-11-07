package com.oplus.camera.timelapsepro;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.core.p027a.ContextCompat;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.menu.levelcontrol.BlurMenuSeekBar;
import com.oplus.camera.professional.ProfessionalAnimConstant;
import com.oplus.camera.timelapsepro.p170a.ScaleDataWrapper;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class TimeLapseProParamScaleBar extends BlurMenuSeekBar {

    /* renamed from: A */
    private ValueAnimator f16666A;

    /* renamed from: B */
    private ValueAnimator f16667B;

    /* renamed from: C */
    private BlurMenuSeekBar.AbstractC3273c f16668C;

    /* renamed from: OplusGLSurfaceView_13 */
    private final int f16669i;

    /* renamed from: OplusGLSurfaceView_15 */
    private final int f16670j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f16671k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f16672l;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f16673m;

    /* renamed from: OplusGLSurfaceView_11 */
    private List<? extends ScaleDataWrapper> f16674n;

    /* renamed from: o */
    private final Paint f16675o;

    /* renamed from: p */
    private String f16676p;

    /* renamed from: q */
    private float f16677q;

    /* renamed from: r */
    private float f16678r;

    /* renamed from: s */
    private float f16679s;

    /* renamed from: t */
    private InterfaceC3044b f16680t;

    /* renamed from: u */
    private InterfaceC3043a f16681u;

    /* renamed from: v */
    private InterfaceC3045c f16682v;

    /* renamed from: w */
    private long f16683w;

    /* renamed from: x */
    private boolean f16684x;

    /* renamed from: y */
    private boolean f16685y;

    /* renamed from: z */
    private int f16686z;

    /* renamed from: com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar$PlatformImplementations.kt_3 */
    public interface InterfaceC3043a {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo17426a();

        /* renamed from: PlatformImplementations.kt_3 */
        void mo17427a(TimeLapseProParamScaleBar timeLapseProParamScaleBar);
    }

    /* renamed from: com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar$IntrinsicsJvm.kt_4 */
    public interface InterfaceC3044b {
        void onValueChanged(TimeLapseProParamScaleBar timeLapseProParamScaleBar, int OplusGLSurfaceView_13);
    }

    /* renamed from: com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar$IntrinsicsJvm.kt_3 */
    public interface InterfaceC3045c {
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.BlurMenuSeekBar
    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean mo17421d() {
        return false;
    }

    public TimeLapseProParamScaleBar(Context context) {
        this(context, null);
    }

    public TimeLapseProParamScaleBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TimeLapseProParamScaleBar(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f16671k = 0;
        this.f16672l = 0;
        this.f16673m = true;
        this.f16680t = null;
        this.f16681u = null;
        this.f16682v = null;
        this.f16683w = 0L;
        this.f16684x = true;
        this.f16685y = false;
        this.f16686z = 255;
        this.f16666A = null;
        this.f16667B = null;
        this.f16668C = new BlurMenuSeekBar.AbstractC3273c() { // from class: com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.1
            @Override // com.oplus.camera.p172ui.menu.levelcontrol.BlurMenuSeekBar.AbstractC3273c, com.oplus.camera.p172ui.menu.levelcontrol.BlurMenuSeekBar.InterfaceC3274d
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo17423a(int i2) {
                super.mo17423a(i2);
                if (TimeLapseProParamScaleBar.this.f16680t == null || TimeLapseProParamScaleBar.this.f19515c == TimeLapseProParamScaleBar.this.f16672l) {
                    return;
                }
                TimeLapseProParamScaleBar.this.f16680t.onValueChanged(TimeLapseProParamScaleBar.this, i2);
                if (TimeLapseProParamScaleBar.this.f16673m) {
                    TimeLapseProParamScaleBar timeLapseProParamScaleBar = TimeLapseProParamScaleBar.this;
                    timeLapseProParamScaleBar.f16672l = timeLapseProParamScaleBar.f19515c;
                }
            }

            @Override // com.oplus.camera.p172ui.menu.levelcontrol.BlurMenuSeekBar.AbstractC3273c, com.oplus.camera.p172ui.menu.levelcontrol.BlurMenuSeekBar.InterfaceC3274d
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo17422a() {
                super.mo17422a();
            }

            @Override // com.oplus.camera.p172ui.menu.levelcontrol.BlurMenuSeekBar.AbstractC3273c, com.oplus.camera.p172ui.menu.levelcontrol.BlurMenuSeekBar.InterfaceC3274d
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo17424a(boolean z) {
                super.mo17424a(z);
                if (z || TimeLapseProParamScaleBar.this.f16681u == null) {
                    return;
                }
                TimeLapseProParamScaleBar.this.f16681u.mo17426a();
            }

            @Override // com.oplus.camera.p172ui.menu.levelcontrol.BlurMenuSeekBar.AbstractC3273c, com.oplus.camera.p172ui.menu.levelcontrol.BlurMenuSeekBar.InterfaceC3274d
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo17425b() {
                super.mo17425b();
            }
        };
        this.f16675o = new Paint();
        m17409g();
        setScaleBarValueChangeListener(this.f16668C);
        this.f16669i = getResources().getDimensionPixelSize(R.dimen.blur_menu_seekbar_line_height_offset0);
        m20769e();
        this.f16670j = getResources().getDimensionPixelSize(R.dimen.time_lapse_pro_space_gap);
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.BlurMenuSeekBar
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo17413a() {
        this.f19519g = new int[]{0, 0, 0, 0, 0, 0};
        this.f19520h = getResources().getDimensionPixelSize(R.dimen.blur_menu_seekbar_line_height);
        this.f19514b = getResources().getColor(R.color.color_white_with_0_percent_transparency);
    }

    public void setLineSpace(int OplusGLSurfaceView_13) {
        this.f19517e = OplusGLSurfaceView_13;
    }

    public void setAutoState(final boolean z) {
        if (z) {
            this.f16668C.mo17423a(this.f16671k);
        } else {
            this.f16668C.mo17423a(this.f16672l);
            InterfaceC3044b interfaceC3044b = this.f16680t;
            if (interfaceC3044b != null) {
                interfaceC3044b.onValueChanged(this, this.f16672l);
            }
        }
        m20765a(!z, new Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$TimeLapseProParamScaleBar$xlfwaDzBjMFpdGiACziW5O8brf0
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.m17410g(z);
            }
        }, new Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$TimeLapseProParamScaleBar$cLlMrtj8OSzMdwiNQYHg6MarDjg
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.m17408f(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_12 */
    public /* synthetic */ void m17408f(boolean z) {
        this.f16673m = !z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_11 */
    public /* synthetic */ void m17410g(boolean z) {
        this.f16673m = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public /* synthetic */ void m17403d(boolean z) {
        this.f16673m = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_8 */
    public /* synthetic */ void m17406e(boolean z) {
        this.f16673m = !z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17416a(final boolean z) throws Resources.NotFoundException {
        super.m20765a(z, new Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$TimeLapseProParamScaleBar$2ZepaALwnTxHUpHtvX40N4CfGtM
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.m17406e(z);
            }
        }, new Runnable() { // from class: com.oplus.camera.timelapsepro.-$$Lambda$TimeLapseProParamScaleBar$ranlkqjM1bzxzD99u5kjNwnCea4
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.m17403d(z);
            }
        });
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.BlurMenuSeekBar
    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void mo17418b() {
        super.mo17418b();
        InterfaceC3043a interfaceC3043a = this.f16681u;
        if (interfaceC3043a != null) {
            interfaceC3043a.mo17427a(this);
        }
    }

    public void setValueList(List<? extends ScaleDataWrapper> list) {
        this.f16674n = list;
        super.setLevelNum(list.size());
        if (this.f16673m) {
            setTextForDraw(m17402d(this.f19515c));
        } else {
            setTextForDraw(m17402d(this.f16671k));
        }
    }

    public int getCurrentIndex() {
        return this.f19515c;
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.BlurMenuSeekBar
    public void setCurrentIndex(int OplusGLSurfaceView_13) {
        super.setCurrentIndex(OplusGLSurfaceView_13);
        List<? extends ScaleDataWrapper> list = this.f16674n;
        if (list == null || list.size() <= 0) {
            return;
        }
        setTextForDraw(m17402d(OplusGLSurfaceView_13));
    }

    public void setDefaultIndex(int OplusGLSurfaceView_13) {
        this.f16671k = OplusGLSurfaceView_13;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m17409g() throws Resources.NotFoundException {
        this.f16675o.setAntiAlias(true);
        this.f16675o.setColor(getResources().getColor(R.color.color_white_with_80_percent_transparency));
        this.f16675o.setStyle(Paint.Style.FILL);
        this.f16675o.setTextAlign(Paint.Align.CENTER);
        this.f16675o.setTextSize(getResources().getDimensionPixelSize(R.dimen.blur_menu_seekbar_value_text_size_small));
        this.f16675o.setShadowLayer(getResources().getDimensionPixelSize(R.dimen.camera_time_split_shadow_radius_size), getResources().getDimensionPixelSize(R.dimen.camera_time_split_shadow_dx), getResources().getDimensionPixelSize(R.dimen.camera_time_split_shadow_dy), ContextCompat.m2254c(this.f19503a, R.color.color_black_with_20_percent_transparency));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int m17400b(String str) {
        float[] fArr = new float[str.length()];
        this.f16675o.getTextWidths(str, fArr);
        float COUIBaseListPopupWindow_12 = 0.0f;
        for (float f2 : fArr) {
            COUIBaseListPopupWindow_12 += f2;
        }
        return (int) COUIBaseListPopupWindow_12;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private String m17402d(int OplusGLSurfaceView_13) {
        return TextUtils.isEmpty(this.f16674n.get(OplusGLSurfaceView_13).mo17463g_()) ? this.f16674n.get(OplusGLSurfaceView_13).mo17462f_() : String.format("%s %s", this.f16674n.get(OplusGLSurfaceView_13).mo17462f_(), this.f16674n.get(OplusGLSurfaceView_13).mo17463g_());
    }

    private void setTextForDraw(String str) {
        if (str.equals(this.f16676p)) {
            return;
        }
        this.f16676p = str;
        this.f16675o.getTextBounds(str, 0, str.length(), new Rect());
        this.f16677q = r0.width() >> 1;
        this.f16679s = r0.height() >> 1;
        this.f16678r = getMeasuredHeight() - getResources().getDimensionPixelSize(R.dimen.time_lapse_pro_scale_text_y_default);
        if (this.f16682v == null || System.currentTimeMillis() - this.f16683w <= 40) {
            return;
        }
        this.f16683w = System.currentTimeMillis();
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.BlurMenuSeekBar
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo17414a(int OplusGLSurfaceView_13) {
        super.mo17414a(OplusGLSurfaceView_13);
        List<? extends ScaleDataWrapper> list = this.f16674n;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f16671k = OplusGLSurfaceView_13;
        this.f16672l = OplusGLSurfaceView_13;
        setTextForDraw(m17402d(OplusGLSurfaceView_13));
    }

    public void setShowText(boolean z) {
        CameraLog.m12954a("TimeLapseProParamScaleBar", "setShowText, showText: " + z);
        this.f16684x = z;
        if (!z) {
            this.f16685y = false;
        }
        this.f16686z = this.f16684x ? 255 : 0;
        invalidate();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m17419b(boolean z) {
        m17417a(z, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17417a(boolean z, boolean z2) {
        CameraLog.m12954a("TimeLapseProParamScaleBar", "showTextWithAnim, showText: " + z + ", anim: " + z2 + ", mbShowText: " + this.f16684x);
        if (this.f16684x == z) {
            return;
        }
        this.f16684x = z;
        this.f16685y = z2;
        if (this.f16685y) {
            this.f16686z = this.f16684x ? 0 : 255;
            if (this.f16684x) {
                m17411h();
                return;
            }
            if (this.f16666A != null) {
                CameraLog.m12954a("TimeLapseProParamScaleBar", "showTextWithAnim, cancel: ");
                this.f16666A.cancel();
            }
            m17412i();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m17411h() {
        if (this.f16666A == null) {
            this.f16666A = ValueAnimator.ofInt(0, 255);
            this.f16666A.setDuration(250L);
            this.f16666A.setStartDelay(150L);
            this.f16666A.setInterpolator(ProfessionalAnimConstant.f15694a);
            this.f16666A.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    TimeLapseProParamScaleBar.this.f16686z = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    TimeLapseProParamScaleBar.this.invalidate();
                }
            });
            this.f16666A.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    TimeLapseProParamScaleBar.this.f16686z = 0;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    TimeLapseProParamScaleBar.this.f16686z = 255;
                }
            });
        }
        this.f16666A.start();
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m17412i() {
        if (this.f16667B == null) {
            this.f16667B = ValueAnimator.ofInt(255, 0);
            this.f16667B.setDuration(250L);
            this.f16667B.setInterpolator(ProfessionalAnimConstant.f15694a);
            this.f16667B.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    TimeLapseProParamScaleBar.this.f16686z = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    TimeLapseProParamScaleBar.this.invalidate();
                }
            });
            this.f16667B.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.timelapsepro.TimeLapseProParamScaleBar.5
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    super.onAnimationCancel(animator);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    TimeLapseProParamScaleBar.this.f16686z = 0;
                }
            });
        }
        this.f16667B.start();
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.BlurMenuSeekBar, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f16675o.setAlpha(this.f16686z);
        if (this.f16678r < 0.0f) {
            this.f16678r = getMeasuredHeight() - getResources().getDimensionPixelSize(R.dimen.time_lapse_pro_scale_text_y_default);
        }
        if (this.f16676p == null || this.f16686z <= 0) {
            return;
        }
        canvas.save();
        if (getRotation() == 0.0f) {
            m17396a(canvas, getMeasuredWidth() >> 1, this.f16678r);
        } else if (getRotation() == 270.0f) {
            canvas.rotate(90.0f, getMeasuredWidth() >> 1, getMeasuredHeight() >> 1);
            m17396a(canvas, getMeasuredWidth() - (this.f16677q + getResources().getDimensionPixelSize(R.dimen.time_lapse_pro_scale_text_margin_vertical)), (getMeasuredHeight() >> 1) + this.f16679s);
        } else {
            canvas.rotate(270.0f, getMeasuredWidth() >> 1, getMeasuredHeight() >> 1);
            m17396a(canvas, this.f16677q + getResources().getDimensionPixelSize(R.dimen.time_lapse_pro_scale_text_margin_vertical), (getMeasuredHeight() >> 1) + this.f16679s);
        }
        canvas.restore();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m17396a(Canvas canvas, float COUIBaseListPopupWindow_12, float f2) {
        String[] strArrSplit = this.f16676p.split(" ");
        if (strArrSplit.length > 1) {
            int iM17400b = m17400b(strArrSplit[0]);
            int iM17400b2 = m17400b(strArrSplit[1]);
            this.f16675o.setTextSize(getResources().getDimensionPixelSize(R.dimen.blur_menu_seekbar_value_text_size_small));
            canvas.drawText(strArrSplit[0], (COUIBaseListPopupWindow_12 - (this.f16670j >> 1)) - (iM17400b2 >> 1), f2, this.f16675o);
            if (m17397a(strArrSplit[1])) {
                this.f16675o.setTextSize(getResources().getDimensionPixelSize(R.dimen.professional_mode_guide_title_text_size));
            }
            canvas.drawText(strArrSplit[1], COUIBaseListPopupWindow_12 + (this.f16670j >> 1) + (iM17400b >> 1), f2, this.f16675o);
            return;
        }
        canvas.drawText(this.f16676p, COUIBaseListPopupWindow_12, f2, this.f16675o);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m17397a(String str) {
        return Pattern.compile("[一-龥]").matcher(str).find();
    }

    @Override // com.oplus.camera.p172ui.menu.levelcontrol.BlurMenuSeekBar
    /* renamed from: IntrinsicsJvm.kt_3 */
    protected void mo17420c() {
        super.mo17420c();
        InterfaceC3043a interfaceC3043a = this.f16681u;
        if (interfaceC3043a != null) {
            interfaceC3043a.mo17426a();
        }
    }

    public void setScaleListener(InterfaceC3044b interfaceC3044b) {
        this.f16680t = interfaceC3044b;
    }

    public void setScaleSpace(int OplusGLSurfaceView_13) {
        this.f19518f = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17415a(int OplusGLSurfaceView_13, int i2) {
        setScaleSpace(OplusGLSurfaceView_13);
        setRemainder(i2);
    }

    public void setMoveListener(InterfaceC3043a interfaceC3043a) {
        this.f16681u = interfaceC3043a;
    }

    public void setTextUpdateListener(InterfaceC3045c interfaceC3045c) {
        this.f16682v = interfaceC3045c;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        this.f16681u = null;
        this.f16680t = null;
        this.f16682v = null;
        super.onDetachedFromWindow();
    }
}
