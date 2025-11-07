package com.oplus.camera.p172ui.modepanel;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.p036h.p038b.PathInterpolatorCompat_2;
import com.oplus.camera.CameraLog;
import com.oplus.camera.DimenConstants;
import com.oplus.camera.R;
import com.oplus.camera.util.Util;

/* compiled from: FloatView.java */
/* renamed from: com.oplus.camera.ui.modepanel.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class FloatView extends RelativeLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final float f20510a = DimenConstants.m14488f() / DimenConstants.m14495m();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final float f20511b = DimenConstants.m14495m() / DimenConstants.m14488f();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final float f20512c = (DimenConstants.m14488f() * 1.27f) / DimenConstants.m14495m();

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final Interpolator f20513d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final Interpolator f20514e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final Interpolator f20515f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private TextPaint f20516g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private TextPaint f20517h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f20518i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f20519j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f20520k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f20521l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f20522m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f20523n;

    /* renamed from: o */
    private ImageView f20524o;

    /* renamed from: p */
    private TextView f20525p;

    /* renamed from: q */
    private AnimatorSet f20526q;

    /* renamed from: r */
    private int f20527r;

    /* renamed from: s */
    private int f20528s;

    /* renamed from: t */
    private boolean f20529t;

    /* renamed from: u */
    private int f20530u;

    /* renamed from: v */
    private int f20531v;

    protected FloatView(Context context) {
        this(context, null);
    }

    protected FloatView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected FloatView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f20513d = PathInterpolatorCompat_2.m2772a(0.4f, 0.0f, 0.2f, 1.0f);
        this.f20514e = PathInterpolatorCompat_2.m2772a(0.33f, 0.0f, 0.67f, 1.0f);
        this.f20515f = PathInterpolatorCompat_2.m2772a(0.3f, 0.0f, 0.1f, 1.0f);
        this.f20516g = null;
        this.f20517h = null;
        this.f20518i = 0;
        this.f20519j = 0;
        this.f20520k = 0;
        this.f20521l = 0;
        this.f20522m = 0;
        this.f20523n = 0;
        this.f20524o = null;
        this.f20525p = null;
        this.f20526q = new AnimatorSet();
        this.f20527r = 0;
        this.f20528s = 0;
        this.f20529t = false;
        this.f20530u = 0;
        this.f20531v = 90;
        inflate(context, R.layout.float_view_layout, this);
        this.f20524o = (ImageView) findViewById(R.id_renamed.float_item_icon);
        this.f20525p = (TextView) findViewById(R.id_renamed.float_item_text);
        this.f20522m = getResources().getDimensionPixelSize(R.dimen.more_item_top_padding);
        this.f20518i = getResources().getDimensionPixelSize(R.dimen.more_icon_title_spacing);
        m21806d();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m21806d() {
        this.f20516g = new TextPaint();
        this.f20516g.setTextSize(DimenConstants.m14488f());
        this.f20516g.setColor(this.f20520k);
        this.f20516g.setStyle(Paint.Style.FILL);
        this.f20516g.setFlags(1);
        this.f20516g.setTypeface(Util.m24473l(getContext()));
        this.f20517h = new TextPaint();
        this.f20517h.setTextSize(DimenConstants.m14495m());
        this.f20517h.setColor(this.f20520k);
        this.f20517h.setStyle(Paint.Style.FILL);
        this.f20517h.setFlags(1);
        this.f20517h.setTypeface(Util.m24473l(getContext()));
    }

    private void setGradientAlpha(float COUIBaseListPopupWindow_12) {
        if (this.f20529t) {
            return;
        }
        int iArgb = Color.argb(COUIBaseListPopupWindow_12, 1.0f, 1.0f, 1.0f);
        GradientDrawable gradientDrawable = (GradientDrawable) this.f20525p.getBackground();
        gradientDrawable.setColor(iArgb);
        this.f20525p.setBackground(gradientDrawable);
    }

    protected int getModeId() {
        return this.f20523n;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m21819a(ModeInfo c3353k, int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        CameraLog.m12954a("FloatView", "initChildren, id_renamed: " + c3353k.m21922b() + ", type: " + OplusGLSurfaceView_13);
        Bitmap bitmapM24216a = Util.m24216a(getContext(), c3353k.m21925c());
        this.f20524o.setImageBitmap(bitmapM24216a);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f20524o.getLayoutParams();
        layoutParams.topMargin = (int) (((float) this.f20522m) + (((float) (DimenConstants.m14497o() - bitmapM24216a.getHeight())) * 0.5f));
        this.f20524o.setLayoutParams(layoutParams);
        this.f20525p.setText(c3353k.m21919a());
        this.f20525p.setTypeface(Util.m24411c(true));
        this.f20523n = c3353k.m21922b();
        if (1 != OplusGLSurfaceView_13) {
            if (2 == OplusGLSurfaceView_13) {
                this.f20524o.setVisibility(4);
                this.f20524o.setAlpha(0.0f);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f20525p.getLayoutParams();
                layoutParams2.width = (int) Math.ceil(this.f20517h.measureText(c3353k.m21919a()) + (DimenConstants.m14489g() * 2));
                layoutParams2.addRule(13);
                this.f20525p.setLayoutParams(layoutParams2);
                this.f20525p.setTextSize(0, DimenConstants.m14495m());
                GradientDrawable gradientDrawable = (GradientDrawable) this.f20525p.getBackground();
                gradientDrawable.setColor(Color.argb(0.1f, 1.0f, 1.0f, 1.0f));
                this.f20525p.setBackground(gradientDrawable);
                return;
            }
            return;
        }
        float fM21801a = m21801a(c3353k.m21919a(), this.f20516g);
        this.f20525p.setTag(R.id_renamed.tag_float_view_text_margin_top, Float.valueOf(fM21801a));
        this.f20525p.setTextSize(0, DimenConstants.m14488f());
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f20525p.getLayoutParams();
        Paint.FontMetrics fontMetrics = this.f20516g.getFontMetrics();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.float_view_top_margin_offset);
        if (((Integer) getTag(R.id_renamed.tag_float_view_measure_width)).intValue() > DimenConstants.m14486d()) {
            layoutParams3.topMargin = ((int) (((this.f20522m + DimenConstants.m14497o()) + this.f20518i) - fM21801a)) + dimensionPixelSize;
        } else {
            layoutParams3.topMargin = ((int) ((((this.f20522m + DimenConstants.m14497o()) + this.f20518i) - fM21801a) - ((DimenConstants.m14481a() - (fontMetrics.bottom - fontMetrics.top)) / 2.0f))) + dimensionPixelSize;
        }
        layoutParams3.addRule(14);
        layoutParams3.width = (int) Math.ceil(this.f20516g.measureText(c3353k.m21919a()) + (DimenConstants.m14489g() * 2));
        this.f20525p.setLayoutParams(layoutParams3);
        GradientDrawable gradientDrawable2 = (GradientDrawable) this.f20525p.getBackground();
        gradientDrawable2.setColor(Color.argb(0.0f, 1.0f, 1.0f, 1.0f));
        this.f20525p.setBackground(gradientDrawable2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private float m21801a(String str, TextPaint textPaint) {
        StaticLayout.Builder.obtain(str, 0, str.length(), textPaint, this.f20521l).setMaxLines(this.f20519j).setAlignment(Layout.Alignment.ALIGN_CENTER).setEllipsize(TextUtils.TruncateAt.END).setTextDirection(TextDirectionHeuristics.LOCALE).build();
        return textPaint.getFontMetrics().ascent - textPaint.getFontMetrics().top;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m21814a() {
        if (0.0f == this.f20524o.getAlpha()) {
            return;
        }
        if (getTag(R.id_renamed.tag_float_view_anim_headline) == null || !((Animator) getTag(R.id_renamed.tag_float_view_anim_headline)).isRunning()) {
            this.f20524o.setAlpha(1.0f);
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            valueAnimatorOfFloat.setInterpolator(this.f20514e);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$IntrinsicsJvm.kt_5$VE8tu2SVc_4pOVveeZwOVeLHUOo
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.COUIBaseListPopupWindow_12$0.m21811f(valueAnimator);
                }
            });
            valueAnimatorOfFloat.setDuration(200L);
            valueAnimatorOfFloat.start();
            setTag(R.id_renamed.tag_float_view_anim_headline, valueAnimatorOfFloat);
            float COUIBaseListPopupWindow_12 = 1 == ((Integer) getTag(R.id_renamed.tag_float_view_type_from)).intValue() ? 1.27f : f20512c;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, (Property<FloatView, Float>) SCALE_X, getScaleX(), COUIBaseListPopupWindow_12);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, (Property<FloatView, Float>) SCALE_Y, getScaleY(), COUIBaseListPopupWindow_12);
            objectAnimatorOfFloat.setDuration(200L).start();
            objectAnimatorOfFloat2.setDuration(200L).start();
            ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.f20525p, (Property<TextView, Float>) TRANSLATION_Y, this.f20525p.getTranslationY(), ((getHeight() / 2) - (this.f20525p.getHeight() / 2)) - this.f20525p.getTop());
            objectAnimatorOfFloat3.setDuration(200L);
            objectAnimatorOfFloat3.start();
            if (1 == ((Integer) getTag(R.id_renamed.tag_float_view_type_from)).intValue()) {
                int iCeil = (int) Math.ceil(this.f20516g.measureText(this.f20525p.getText().toString()) + (DimenConstants.m14489g() * 2));
                if (iCeil > DimenConstants.m14486d()) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
                    layoutParams.width = iCeil;
                    setLayoutParams(layoutParams);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f20525p.getLayoutParams();
                    layoutParams2.width = iCeil;
                    this.f20525p.setLayoutParams(layoutParams2);
                    return;
                }
                return;
            }
            int iIntValue = ((Integer) getTag(R.id_renamed.tag_float_view_measure_width)).intValue();
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) getLayoutParams();
            layoutParams3.width = Math.max(iIntValue, DimenConstants.m14486d());
            setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f20525p.getLayoutParams();
            layoutParams4.width = iIntValue;
            this.f20525p.setLayoutParams(layoutParams4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_12 */
    public /* synthetic */ void m21811f(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f20524o.setAlpha(fFloatValue);
        GradientDrawable gradientDrawable = (GradientDrawable) this.f20525p.getBackground();
        gradientDrawable.setColor(Color.argb((1.0f - fFloatValue) * 0.1f, 1.0f, 1.0f, 1.0f));
        this.f20525p.setBackground(gradientDrawable);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void m21820b() {
        if (1.0f == this.f20524o.getAlpha()) {
            return;
        }
        if (getTag(R.id_renamed.tag_float_view_anim_modelist) == null || !((Animator) getTag(R.id_renamed.tag_float_view_anim_modelist)).isRunning()) {
            this.f20529t = true;
            this.f20524o.setVisibility(0);
            float fFloatValue = 0.0f;
            this.f20524o.setAlpha(0.0f);
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimatorOfFloat.setInterpolator(this.f20514e);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$IntrinsicsJvm.kt_5$RZo5pF01pvDdmgFjWb2gxsQ7T2M
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.COUIBaseListPopupWindow_12$0.m21809e(valueAnimator);
                }
            });
            valueAnimatorOfFloat.setDuration(200L);
            valueAnimatorOfFloat.start();
            setTag(R.id_renamed.tag_float_view_anim_modelist, valueAnimatorOfFloat);
            if (1 != ((Integer) getTag(R.id_renamed.tag_float_view_type_from)).intValue()) {
                if (this.f20525p.getTag(R.id_renamed.tag_float_view_text_margin_top) == null) {
                    if (((Integer) getTag(R.id_renamed.tag_float_view_measure_width)).intValue() > DimenConstants.m14486d()) {
                        fFloatValue = (((this.f20522m + DimenConstants.m14497o()) + this.f20518i) - this.f20525p.getTop()) + this.f20517h.getFontMetrics().descent;
                    } else {
                        Paint.FontMetrics fontMetrics = this.f20517h.getFontMetrics();
                        fFloatValue = ((((this.f20522m + DimenConstants.m14497o()) + this.f20518i) - m21801a(this.f20525p.getText().toString(), this.f20517h)) - this.f20525p.getTop()) - ((this.f20525p.getHeight() - (fontMetrics.bottom - fontMetrics.top)) / 2.0f);
                    }
                    this.f20525p.setTag(R.id_renamed.tag_float_view_text_margin_top, Float.valueOf(fFloatValue));
                } else {
                    fFloatValue = ((Float) this.f20525p.getTag(R.id_renamed.tag_float_view_text_margin_top)).floatValue();
                }
            }
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f20525p, (Property<TextView, Float>) TRANSLATION_Y, this.f20525p.getTranslationY(), fFloatValue);
            objectAnimatorOfFloat.setDuration(200L);
            objectAnimatorOfFloat.start();
            float fM14488f = 1 != ((Integer) getTag(R.id_renamed.tag_float_view_type_from)).intValue() ? (DimenConstants.m14488f() * 1.15f) / DimenConstants.m14495m() : 1.0f;
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f20525p, (Property<TextView, Float>) SCALE_X, this.f20525p.getScaleX(), fM14488f);
            ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.f20525p, (Property<TextView, Float>) SCALE_Y, this.f20525p.getScaleY(), fM14488f);
            objectAnimatorOfFloat2.setDuration(200L).start();
            objectAnimatorOfFloat3.setDuration(200L).start();
            int iIntValue = ((Integer) getTag(R.id_renamed.tag_float_view_measure_width)).intValue();
            if (iIntValue > DimenConstants.m14486d()) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f20525p.getLayoutParams();
                if (4 == this.f20530u) {
                    layoutParams.width = iIntValue;
                    layoutParams.height = DimenConstants.m14487e();
                    layoutParams2.width = iIntValue;
                } else {
                    layoutParams.width = DimenConstants.m14486d();
                    layoutParams.height = DimenConstants.m14487e();
                    layoutParams2.width = DimenConstants.m14486d();
                }
                setLayoutParams(layoutParams);
                this.f20525p.setLayoutParams(layoutParams2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_8 */
    public /* synthetic */ void m21809e(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f20524o.setAlpha(fFloatValue);
        GradientDrawable gradientDrawable = (GradientDrawable) this.f20525p.getBackground();
        gradientDrawable.setColor(Color.argb((1.0f - fFloatValue) * 0.1f, 1.0f, 1.0f, 1.0f));
        this.f20525p.setBackground(gradientDrawable);
    }

    protected Rect getFloatLocation() {
        if (0.0f == this.f20524o.getAlpha()) {
            return DragHelperUtils.m21798c(this.f20525p, this.f20530u, this.f20531v);
        }
        return DragHelperUtils.m21798c(this, this.f20530u, this.f20531v);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m21816a(int OplusGLSurfaceView_13) {
        setTag(R.id_renamed.tag_float_view_type_from, Integer.valueOf(OplusGLSurfaceView_13));
        this.f20529t = false;
        if (1 == OplusGLSurfaceView_13) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, (Property<FloatView, Float>) SCALE_X, 1.0f, f20510a);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, (Property<FloatView, Float>) SCALE_Y, 1.0f, f20510a);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
            animatorSet.setInterpolator(this.f20513d);
            animatorSet.setDuration(200L).start();
            postDelayed(new Runnable() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$IntrinsicsJvm.kt_5$fzODbe1bIMXJ558ukT1zXA7elzo
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m21810f();
                }
            }, 200L);
            return;
        }
        if (2 == OplusGLSurfaceView_13) {
            ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this, (Property<FloatView, Float>) SCALE_X, 1.0f, 0.9f);
            objectAnimatorOfFloat3.setInterpolator(this.f20513d);
            ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this, (Property<FloatView, Float>) SCALE_Y, 1.0f, 0.9f);
            objectAnimatorOfFloat4.setInterpolator(this.f20513d);
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.1f, 0.7f);
            valueAnimatorOfFloat.setInterpolator(this.f20514e);
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$IntrinsicsJvm.kt_5$QYYfPHf2NKQ0Jf_i_Cuz6rTWWVc
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.COUIBaseListPopupWindow_12$0.m21807d(valueAnimator);
                }
            });
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playTogether(objectAnimatorOfFloat3, objectAnimatorOfFloat4, valueAnimatorOfFloat);
            animatorSet2.setDuration(200L).start();
            postDelayed(new Runnable() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$IntrinsicsJvm.kt_5$Mz_5tnuj8Geg4crOWA4lfVZXrwI
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m21808e();
                }
            }, 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_12 */
    public /* synthetic */ void m21810f() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, (Property<FloatView, Float>) SCALE_X, f20510a, 1.15f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, (Property<FloatView, Float>) SCALE_Y, f20510a, 1.15f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        animatorSet.setInterpolator(this.f20513d);
        animatorSet.setDuration(200L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public /* synthetic */ void m21807d(ValueAnimator valueAnimator) {
        setGradientAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_8 */
    public /* synthetic */ void m21808e() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, (Property<FloatView, Float>) SCALE_X, 0.9f, f20512c);
        objectAnimatorOfFloat.setInterpolator(this.f20513d);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, (Property<FloatView, Float>) SCALE_Y, 0.9f, f20512c);
        objectAnimatorOfFloat2.setInterpolator(this.f20513d);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.7f, 0.1f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$IntrinsicsJvm.kt_5$iNYon3EQJoADA4b47HfwaSkTx_E
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.COUIBaseListPopupWindow_12$0.m21805c(valueAnimator);
            }
        });
        valueAnimatorOfFloat.setInterpolator(this.f20514e);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, valueAnimatorOfFloat);
        animatorSet.setDuration(200L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public /* synthetic */ void m21805c(ValueAnimator valueAnimator) {
        setGradientAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m21818a(Rect rect, int OplusGLSurfaceView_13) {
        if (this.f20526q.isRunning()) {
            this.f20526q.end();
        }
        this.f20526q.removeAllListeners();
        this.f20527r = 0;
        this.f20528s = 0;
        Rect rectM21798c = DragHelperUtils.m21798c(this, this.f20530u, this.f20531v);
        int i2 = this.f20530u;
        if (1 == i2 || 4 == i2) {
            rectM21798c = m21813a(rectM21798c);
        }
        if (rectM21798c.width() == 0 || rectM21798c.height() == 0) {
            rectM21798c = rect;
        }
        int iCenterX = rect.centerX() - rectM21798c.centerX();
        int iCenterY = rect.centerY() - rectM21798c.centerY();
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, iCenterX);
        valueAnimatorOfInt.setInterpolator(this.f20515f);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$IntrinsicsJvm.kt_5$Kf8E8CG25W5CtT39bhXmxo1xC60
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.COUIBaseListPopupWindow_12$0.m21804b(valueAnimator);
            }
        });
        ValueAnimator valueAnimatorOfInt2 = ValueAnimator.ofInt(0, iCenterY);
        valueAnimatorOfInt2.setInterpolator(this.f20515f);
        valueAnimatorOfInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$IntrinsicsJvm.kt_5$uM_cHLhT-Xp6YeTW1SM_LYar1RE
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.COUIBaseListPopupWindow_12$0.m21802a(valueAnimator);
            }
        });
        float COUIBaseListPopupWindow_12 = 1.0f;
        if (2 == OplusGLSurfaceView_13) {
            if (1 == ((Integer) getTag(R.id_renamed.tag_float_view_type_from)).intValue()) {
                COUIBaseListPopupWindow_12 = f20511b;
                final GradientDrawable gradientDrawable = (GradientDrawable) this.f20525p.getBackground();
                Rect bounds = gradientDrawable.getBounds();
                final int i3 = bounds.right;
                final int i4 = bounds.bottom;
                ValueAnimator valueAnimatorOfInt3 = ValueAnimator.ofInt(0, (int) (bounds.height() * 0.06f));
                valueAnimatorOfInt3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$IntrinsicsJvm.kt_5$Z63t23L2aCR7p2BAOlmeuAx_eNY
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        this.COUIBaseListPopupWindow_12$0.m21803a(gradientDrawable, i3, i4, valueAnimator);
                    }
                });
                valueAnimatorOfInt3.setDuration(200L).start();
            }
        } else if (2 == ((Integer) getTag(R.id_renamed.tag_float_view_type_from)).intValue()) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f20525p, (Property<TextView, Float>) SCALE_X, this.f20525p.getScaleX(), f20510a);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f20525p, (Property<TextView, Float>) SCALE_Y, this.f20525p.getScaleY(), f20510a);
            objectAnimatorOfFloat.setDuration(200L).start();
            objectAnimatorOfFloat2.setDuration(200L).start();
        }
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this, (Property<FloatView, Float>) SCALE_X, getScaleX(), COUIBaseListPopupWindow_12);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this, (Property<FloatView, Float>) SCALE_Y, getScaleY(), COUIBaseListPopupWindow_12);
        objectAnimatorOfFloat3.setInterpolator(this.f20513d);
        objectAnimatorOfFloat4.setInterpolator(this.f20513d);
        this.f20526q.playTogether(valueAnimatorOfInt, valueAnimatorOfInt2, objectAnimatorOfFloat3, objectAnimatorOfFloat4);
        this.f20526q.setDuration(200L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public /* synthetic */ void m21804b(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        int OplusGLSurfaceView_13 = iIntValue - this.f20527r;
        this.f20527r = iIntValue;
        m21815a(OplusGLSurfaceView_13, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m21802a(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        int OplusGLSurfaceView_13 = iIntValue - this.f20528s;
        this.f20528s = iIntValue;
        m21815a(0.0f, OplusGLSurfaceView_13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m21803a(GradientDrawable gradientDrawable, int OplusGLSurfaceView_13, int i2, ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        gradientDrawable.setBounds(iIntValue, iIntValue, OplusGLSurfaceView_13 - iIntValue, i2 - iIntValue);
        this.f20525p.setBackground(gradientDrawable);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m21815a(float COUIBaseListPopupWindow_12, float f2) {
        if (0.0f != COUIBaseListPopupWindow_12) {
            setX(getX() + COUIBaseListPopupWindow_12);
        }
        if (0.0f != f2) {
            setY(getY() + f2);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected boolean m21821c() {
        Object tag = getTag(R.id_renamed.tag_float_view_anim_headline);
        Object tag2 = getTag(R.id_renamed.tag_float_view_anim_modelist);
        if (tag == null || !((Animator) tag).isRunning()) {
            return tag2 != null && ((Animator) tag2).isRunning();
        }
        return true;
    }

    protected float getTextTranslationY() {
        TextView textView = this.f20525p;
        if (textView == null) {
            return 0.0f;
        }
        textView.getTranslationY();
        return 0.0f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected float m21812a(String str, int OplusGLSurfaceView_13) {
        if (1 == OplusGLSurfaceView_13) {
            return this.f20516g.measureText(str);
        }
        if (2 == OplusGLSurfaceView_13) {
            return this.f20517h.measureText(str);
        }
        return 0.0f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21817a(int OplusGLSurfaceView_13, int i2) {
        this.f20530u = OplusGLSurfaceView_13;
        this.f20531v = i2;
        if (OplusGLSurfaceView_13 == 1) {
            this.f20518i = getResources().getDimensionPixelSize(R.dimen.vertical_more_icon_title_spacing);
            this.f20522m = getResources().getDimensionPixelSize(R.dimen.vertical_more_item_top_padding);
        } else {
            this.f20518i = getResources().getDimensionPixelSize(R.dimen.more_icon_title_spacing);
            this.f20522m = getResources().getDimensionPixelSize(R.dimen.more_item_top_padding);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Rect m21813a(Rect rect) {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        int OplusGLSurfaceView_13 = this.f20530u;
        if (1 != OplusGLSurfaceView_13 && 4 != OplusGLSurfaceView_13) {
            return rect;
        }
        int i2 = this.f20531v;
        if (270 == i2) {
            return new Rect(iArr[0], iArr[1] - ((int) (getHeight() * getScaleY())), iArr[0] + ((int) (getWidth() * getScaleX())), iArr[1]);
        }
        return 90 == i2 ? new Rect(iArr[0] - ((int) (getWidth() * getScaleX())), iArr[1], iArr[0], iArr[1] + ((int) (getHeight() * getScaleY()))) : rect;
    }
}
