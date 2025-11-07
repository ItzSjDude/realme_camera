package com.oplus.camera.p172ui.preview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.RotateImageView;
import com.oplus.camera.p172ui.preview.ExposureSeekbarContainer;
import com.oplus.camera.util.Util;

/* compiled from: FocusIndicatorRotateLayout.java */
/* renamed from: com.oplus.camera.ui.preview.OplusGLSurfaceView_11 */
/* loaded from: classes2.dex */
public class FocusIndicatorRotateLayout extends RelativeLayout implements ExposureSeekbarContainer.InterfaceC3377a, FocusIndicator {

    /* renamed from: A */
    private boolean f22176A;

    /* renamed from: B */
    private float f22177B;

    /* renamed from: C */
    private float f22178C;

    /* renamed from: D */
    private PointF f22179D;

    /* renamed from: E */
    private PointF f22180E;

    /* renamed from: F */
    private float f22181F;

    /* renamed from: G */
    private float f22182G;

    /* renamed from: H */
    private boolean f22183H;

    /* renamed from: I */
    private TimeInterpolator f22184I;

    /* renamed from: J */
    private Interpolator f22185J;

    /* renamed from: K */
    private ValueAnimator f22186K;

    /* renamed from: L */
    private float f22187L;

    /* renamed from: M */
    private IntrinsicsJvm.kt_3 f22188M;

    /* renamed from: N */
    private AnimatorListenerAdapter f22189N;

    /* renamed from: PlatformImplementations.kt_3 */
    private int f22190a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Runnable f22191b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Runnable f22192c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f22193d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f22194e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f22195f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f22196g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f22197h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f22198i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f22199j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f22200k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f22201l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f22202m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f22203n;

    /* renamed from: o */
    private int f22204o;

    /* renamed from: p */
    private IFocusManagerProxy f22205p;

    /* renamed from: q */
    private RelativeLayout f22206q;

    /* renamed from: r */
    private ImageView f22207r;

    /* renamed from: s */
    private TextView f22208s;

    /* renamed from: t */
    private RelativeLayout f22209t;

    /* renamed from: u */
    private ImageView f22210u;

    /* renamed from: v */
    private TextView f22211v;

    /* renamed from: w */
    private ExposureSeekbarContainer f22212w;

    /* renamed from: x */
    private boolean f22213x;

    /* renamed from: y */
    private boolean f22214y;

    /* renamed from: z */
    private boolean f22215z;

    /* compiled from: FocusIndicatorRotateLayout.java */
    /* renamed from: com.oplus.camera.ui.preview.OplusGLSurfaceView_11$IntrinsicsJvm.kt_3 */
    public interface IntrinsicsJvm.kt_3 {
        void onVisibilityChanged(View view, int OplusGLSurfaceView_13);
    }

    public FocusIndicatorRotateLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FocusIndicatorRotateLayout(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        this(context, attributeSet, OplusGLSurfaceView_13, 0);
    }

    public FocusIndicatorRotateLayout(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13, i2);
        this.f22191b = new PlatformImplementations.kt_3();
        this.f22192c = new IntrinsicsJvm.kt_4();
        this.f22193d = 0;
        this.f22194e = 0;
        this.f22195f = 0;
        this.f22196g = 0;
        this.f22197h = 0;
        this.f22198i = 0;
        this.f22199j = 0;
        this.f22200k = 0;
        this.f22201l = 0;
        this.f22202m = 0;
        this.f22203n = 0;
        this.f22204o = 0;
        this.f22206q = null;
        this.f22207r = null;
        this.f22208s = null;
        this.f22209t = null;
        this.f22210u = null;
        this.f22211v = null;
        this.f22212w = null;
        this.f22213x = false;
        this.f22214y = false;
        this.f22215z = false;
        this.f22176A = false;
        this.f22177B = -1.0f;
        this.f22178C = -1.0f;
        this.f22179D = new PointF(0.0f, 0.0f);
        this.f22180E = new PointF(0.0f, 0.0f);
        this.f22181F = -1.0f;
        this.f22182G = -1.0f;
        this.f22183H = false;
        this.f22184I = new LinearInterpolator();
        this.f22185J = null;
        this.f22186K = null;
        this.f22187L = 1.0f;
        this.f22188M = null;
        this.f22189N = new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.preview.OplusGLSurfaceView_11.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (FocusIndicatorRotateLayout.this.f22212w != null) {
                    FocusIndicatorRotateLayout.this.f22212w.m22111a(FocusIndicatorRotateLayout.this.f22212w.getTranslationX() + (FocusIndicatorRotateLayout.this.f22212w.getContainerWidth() / 2.0f), FocusIndicatorRotateLayout.this.f22212w.getTranslationY() + (FocusIndicatorRotateLayout.this.f22212w.getContainerHeight() / 2.0f), FocusIndicatorRotateLayout.this.f22194e, FocusIndicatorRotateLayout.this.f22193d, FocusIndicatorRotateLayout.this.f22204o);
                }
            }
        };
        Resources resources = context.getResources();
        this.f22195f = resources.getDimensionPixelSize(R.dimen.focus_indicator_container_width);
        this.f22196g = resources.getDimensionPixelSize(R.dimen.focus_indicator_container_height);
        this.f22198i = resources.getDimensionPixelSize(R.dimen.exposure_indicator_container_height);
        this.f22197h = resources.getDimensionPixelSize(R.dimen.exposure_indicator_container_width);
        this.f22199j = resources.getDimensionPixelSize(R.dimen.exposure_indicator_width);
        this.f22200k = resources.getDimensionPixelSize(R.dimen.exposure_indicator_height);
        this.f22201l = resources.getDimensionPixelSize(R.dimen.focus_indicator_width);
        this.f22202m = resources.getDimensionPixelSize(R.dimen.focus_indicator_height);
        this.f22203n = resources.getDimensionPixelSize(R.dimen.exposure_indicator_min_margin);
        this.f22185J = AnimationUtils.loadInterpolator(context, R.anim.unity_in_out_path_interpolator);
        m23571a(context);
        this.f22186K = ValueAnimator.ofFloat(0.0f);
        this.f22186K.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.preview.-$$Lambda$OplusGLSurfaceView_11$QTgl4PKG4LN4-eEPUCmG8NWSAI0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.COUIBaseListPopupWindow_12$0.m23570a(valueAnimator);
            }
        });
        this.f22186K.addListener(this.f22189N);
        setId(R.id_renamed.focus_exposure_indicator_container);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m23570a(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        RelativeLayout relativeLayout = this.f22209t;
        if (relativeLayout != null) {
            relativeLayout.setRotation(fFloatValue);
        }
        RelativeLayout relativeLayout2 = this.f22206q;
        if (relativeLayout2 != null) {
            relativeLayout2.setRotation(fFloatValue);
        }
        ExposureSeekbarContainer exposureSeekbarContainer = this.f22212w;
        if (exposureSeekbarContainer != null) {
            exposureSeekbarContainer.setRotation(fFloatValue);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23571a(Context context) {
        inflate(context, R.layout.focus_exposure_indicator, this);
        setOnTouchListener(new View.OnTouchListener() { // from class: com.oplus.camera.ui.preview.-$$Lambda$OplusGLSurfaceView_11$JxbP8c3M2Q_3LFygzSxqHKObnmQ
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.COUIBaseListPopupWindow_12$0.m23581c(view, motionEvent);
            }
        });
        if (this.f22209t == null) {
            this.f22209t = (RelativeLayout) findViewById(R.id_renamed.focus_indicator_container);
            this.f22210u = (ImageView) findViewById(R.id_renamed.focus_indicator);
            this.f22209t.setOnTouchListener(new View.OnTouchListener() { // from class: com.oplus.camera.ui.preview.-$$Lambda$OplusGLSurfaceView_11$rU1Yx006DxsePhrLYwKoUM4qOCo
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return this.COUIBaseListPopupWindow_12$0.m23578b(view, motionEvent);
                }
            });
            this.f22211v = (TextView) findViewById(R.id_renamed.focus_indicator_text);
        }
        if (this.f22206q == null) {
            this.f22206q = (RelativeLayout) findViewById(R.id_renamed.exposure_indicator_container);
            this.f22207r = (ImageView) findViewById(R.id_renamed.exposure_indicator);
            this.f22207r.setOnTouchListener(new View.OnTouchListener() { // from class: com.oplus.camera.ui.preview.-$$Lambda$OplusGLSurfaceView_11$64K9V7jIyMTZz9MdAQdK0PRM78I
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return this.COUIBaseListPopupWindow_12$0.m23574a(view, motionEvent);
                }
            });
            this.f22208s = (TextView) findViewById(R.id_renamed.exposure_indicator_text);
        }
        if (this.f22212w == null) {
            this.f22212w = (ExposureSeekbarContainer) findViewById(R.id_renamed.exposure_seekbar_container);
            this.f22212w.setOnSeekbarChangeListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public /* synthetic */ boolean m23581c(View view, MotionEvent motionEvent) {
        if (motionEvent != null) {
            return m23573a(motionEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public /* synthetic */ boolean m23578b(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || !m23575a(view, motionEvent, 0.2f) || !this.f22205p.mo23646F()) {
            return false;
        }
        m23586i();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ boolean m23574a(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || !this.f22205p.mo23646F()) {
            return false;
        }
        m23584g();
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m23575a(View view, MotionEvent motionEvent, float COUIBaseListPopupWindow_12) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        return (((((float) view.getWidth()) * COUIBaseListPopupWindow_12) > x ? 1 : ((((float) view.getWidth()) * COUIBaseListPopupWindow_12) == x ? 0 : -1)) < 0 && (x > (((float) view.getWidth()) - (((float) view.getWidth()) * COUIBaseListPopupWindow_12)) ? 1 : (x == (((float) view.getWidth()) - (((float) view.getWidth()) * COUIBaseListPopupWindow_12)) ? 0 : -1)) < 0) && (((((float) view.getHeight()) * COUIBaseListPopupWindow_12) > y ? 1 : ((((float) view.getHeight()) * COUIBaseListPopupWindow_12) == y ? 0 : -1)) < 0 && (y > (((float) view.getHeight()) - (((float) view.getHeight()) * COUIBaseListPopupWindow_12)) ? 1 : (y == (((float) view.getHeight()) - (((float) view.getHeight()) * COUIBaseListPopupWindow_12)) ? 0 : -1)) < 0);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m23584g() {
        CameraLog.m12959b("FocusIndicatorRotateLayout", "startMovingExposure, mbIsStartMovingFocus: " + this.f22176A + ", mbIsStartMovingExposure: " + this.f22215z);
        IFocusManagerProxy interfaceC3456s = this.f22205p;
        if (interfaceC3456s == null || this.f22176A || this.f22215z || !interfaceC3456s.mo23651K() || !this.f22205p.mo23646F()) {
            return;
        }
        this.f22215z = true;
        this.f22179D.set(this.f22206q.getTranslationX() + (this.f22197h / 2.0f), this.f22206q.getTranslationY() + (this.f22198i / 2.0f));
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m23585h() {
        CameraLog.m12959b("FocusIndicatorRotateLayout", "stopMovingExposure, mbIsStartMovingExposure: " + this.f22215z + ", mMovingExposurePointf: " + this.f22179D);
        if (this.f22215z) {
            this.f22215z = false;
            this.f22205p.mo23658a(this.f22179D.x, this.f22179D.y, this.f22199j, this.f22200k);
            this.f22179D.set(0.0f, 0.0f);
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m23586i() {
        CameraLog.m12959b("FocusIndicatorRotateLayout", "startMovingFocus, mbIsStartMovingFocus: " + this.f22176A + ", mbIsStartMovingExposure: " + this.f22215z);
        IFocusManagerProxy interfaceC3456s = this.f22205p;
        if (interfaceC3456s == null || this.f22176A || this.f22215z || !interfaceC3456s.mo23651K() || !this.f22205p.mo23646F()) {
            return;
        }
        this.f22176A = true;
        this.f22180E.set(this.f22209t.getTranslationX() + (this.f22195f / 2.0f), this.f22209t.getTranslationY() + (this.f22196g / 2.0f));
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m23587j() {
        CameraLog.m12959b("FocusIndicatorRotateLayout", "stopMovingFocus, mbIsStartMovingFocus: " + this.f22176A + ", mMovingFocusPointf: " + this.f22180E);
        if (this.f22176A) {
            this.f22176A = false;
            this.f22205p.mo23672b(this.f22180E.x, this.f22180E.y, this.f22201l, this.f22202m);
            this.f22180E.set(0.0f, 0.0f);
        }
    }

    public void setFocusManager(IFocusManagerProxy interfaceC3456s) {
        this.f22205p = interfaceC3456s;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m23573a(MotionEvent motionEvent) {
        boolean zMo23675b;
        IFocusManagerProxy interfaceC3456s = this.f22205p;
        if (interfaceC3456s == null || !interfaceC3456s.mo23651K()) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (this.f22205p != null) {
            setAlpha(1.0f);
            this.f22205p.mo23652L();
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            if (!this.f22176A && !this.f22215z) {
                return false;
            }
            this.f22177B = x;
            this.f22178C = y;
            this.f22181F = this.f22177B;
            this.f22182G = this.f22178C;
            return true;
        }
        if (action != 2) {
            m23585h();
            m23587j();
            this.f22181F = -1.0f;
            this.f22182G = -1.0f;
            return true;
        }
        if (this.f22181F > -0.5f && this.f22182G > -0.5f) {
            float x2 = motionEvent.getX() - this.f22181F;
            float y2 = motionEvent.getY() - this.f22182G;
            if (this.f22215z) {
                zMo23675b = this.f22205p.mo23675b((int) (this.f22179D.x + x2), (int) (this.f22179D.y + y2));
                if (zMo23675b) {
                    this.f22179D.offset(x2, y2);
                    m23600d((int) this.f22179D.x, (int) this.f22179D.y);
                }
            } else {
                zMo23675b = false;
            }
            if (this.f22176A && (zMo23675b = this.f22205p.mo23675b((int) (this.f22180E.x + x2), (int) (this.f22180E.y + y2)))) {
                this.f22180E.offset(x2, y2);
                m23598c((int) this.f22180E.x, (int) this.f22180E.y);
            }
            this.f22183H = true;
            if (zMo23675b) {
                this.f22181F = x;
                this.f22182G = y;
            }
            m23599c(false);
        }
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23589a(int OplusGLSurfaceView_13, int i2) {
        this.f22193d = i2;
        this.f22194e = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private float m23576b(float COUIBaseListPopupWindow_12) {
        int OplusGLSurfaceView_13 = this.f22199j;
        int i2 = this.f22203n;
        return Util.m24201a(COUIBaseListPopupWindow_12, (OplusGLSurfaceView_13 / 2.0f) + i2, (this.f22194e - (OplusGLSurfaceView_13 / 2.0f)) - i2);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private float m23579c(float COUIBaseListPopupWindow_12) {
        int OplusGLSurfaceView_13 = this.f22200k;
        int i2 = this.f22203n;
        return Util.m24201a(COUIBaseListPopupWindow_12, (OplusGLSurfaceView_13 / 2.0f) + i2, (this.f22193d - (OplusGLSurfaceView_13 / 2.0f)) - i2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m23593b(int OplusGLSurfaceView_13, int i2) {
        m23600d(OplusGLSurfaceView_13, i2);
        m23598c(OplusGLSurfaceView_13, i2);
        m23569a(OplusGLSurfaceView_13, i2, false);
        m23591a(this.f22205p.mo23706s());
        m23599c(true);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m23598c(int OplusGLSurfaceView_13, int i2) {
        float fM23576b = m23576b(OplusGLSurfaceView_13);
        float fM23579c = m23579c(i2) - (this.f22196g / 2.0f);
        this.f22209t.setRotation(-this.f22204o);
        this.f22209t.setTranslationX(fM23576b - (this.f22195f / 2.0f));
        this.f22209t.setTranslationY(fM23579c);
        this.f22209t.requestLayout();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m23600d(int OplusGLSurfaceView_13, int i2) {
        float fM23576b = m23576b(OplusGLSurfaceView_13);
        float fM23579c = m23579c(i2) - (this.f22198i / 2.0f);
        this.f22206q.setRotation(-this.f22204o);
        this.f22206q.setTranslationX(fM23576b - (this.f22197h / 2.0f));
        this.f22206q.setTranslationY(fM23579c);
        this.f22206q.requestLayout();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23569a(int OplusGLSurfaceView_13, int i2, boolean z) {
        if (this.f22183H) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        final float fM23576b = m23576b(OplusGLSurfaceView_13);
        final float fM23579c = m23579c(i2);
        if (z) {
            ExposureSeekbarContainer exposureSeekbarContainer = this.f22212w;
            float alpha = exposureSeekbarContainer != null ? exposureSeekbarContainer.getAlpha() : 1.0f;
            if (Float.compare(alpha, 0.0f) > 0) {
                ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f22212w, (Property<ExposureSeekbarContainer, Float>) ALPHA, alpha, 0.0f);
                objectAnimatorOfFloat.setDuration(300L);
                objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.preview.OplusGLSurfaceView_11.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        FocusIndicatorRotateLayout.this.m23565a(fM23576b, fM23579c);
                    }
                });
                objectAnimatorOfFloat.start();
                return;
            }
            m23565a(fM23576b, fM23579c);
            return;
        }
        this.f22212w.m22111a(fM23576b, fM23579c, this.f22194e, this.f22193d, this.f22204o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m23565a(float COUIBaseListPopupWindow_12, float f2) {
        ExposureSeekbarContainer exposureSeekbarContainer = this.f22212w;
        if (exposureSeekbarContainer != null) {
            exposureSeekbarContainer.m22111a(COUIBaseListPopupWindow_12, f2, this.f22194e, this.f22193d, this.f22204o);
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f22212w, (Property<ExposureSeekbarContainer, Float>) ALPHA, this.f22212w.getAlpha(), 1.0f);
            objectAnimatorOfFloat.setDuration(300L);
            objectAnimatorOfFloat.start();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23591a(boolean z) {
        if (z) {
            PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(Util.m24164A(getContext()), PorterDuff.Mode.SRC_ATOP);
            this.f22210u.setColorFilter(porterDuffColorFilter);
            this.f22207r.setColorFilter(porterDuffColorFilter);
        } else {
            this.f22210u.setColorFilter((ColorFilter) null);
            this.f22207r.setColorFilter((ColorFilter) null);
        }
        this.f22212w.setLockedState(z);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m23594b(boolean z) {
        ExposureSeekbarContainer exposureSeekbarContainer = this.f22212w;
        if (exposureSeekbarContainer != null) {
            exposureSeekbarContainer.m22113a(z);
        }
        this.f22183H = false;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m23599c(boolean z) {
        boolean z2 = false;
        if (this.f22183H) {
            this.f22211v.setVisibility(0);
        } else {
            this.f22211v.setVisibility(8);
        }
        if (this.f22183H) {
            this.f22208s.setVisibility(0);
        } else {
            this.f22208s.setVisibility(8);
        }
        if (this.f22205p.mo23647G()) {
            this.f22207r.setVisibility(8);
            this.f22210u.setImageResource(R.drawable.hasselbald_xpan_indicator_focus);
        } else {
            this.f22207r.setVisibility(0);
            this.f22210u.setImageResource(R.drawable.ic_indicator_focus);
        }
        this.f22212w.setToggleViewEnable(this.f22205p.mo23650J());
        if (this.f22205p.mo23644D()) {
            if (!this.f22183H && !m23602d()) {
                z2 = true;
            }
            setManualExposureEnable(z2);
            return;
        }
        setManualExposureEnable(false);
    }

    public void setManualExposureEnable(boolean z) {
        this.f22214y = z;
        this.f22212w.setVisibility(z ? 0 : 8);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m23596b() {
        return this.f22212w.isShown();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m23601d(boolean z) {
        this.f22212w.m22114b(z);
    }

    public void setMoveDistance(float COUIBaseListPopupWindow_12) {
        this.f22212w.setMoveDistance(COUIBaseListPopupWindow_12);
    }

    public int getFocusRectWidth() {
        return this.f22201l;
    }

    public int getExposureRectWidth() {
        return this.f22199j;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m23597c() {
        if (this.f22213x) {
            CameraLog.m12962c("FocusIndicatorRotateLayout", "showStart, mbForceDisableFocusIndicator is true.");
            return;
        }
        m23603e();
        if (this.f22190a != 0) {
            CameraLog.m12962c("FocusIndicatorRotateLayout", "showStart, short circle, mState: " + this.f22190a);
            return;
        }
        setVisibility(0);
        m23599c(false);
        m23566a(1.2f, 1.2f, false);
        m23567a(1.0f, 1.0f, true, false, 250L);
        m23588k();
        this.f22190a = 1;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private void m23588k() {
        this.f22212w.animate().alphaBy(0.0f).alpha(1.0f).setDuration(250L).setInterpolator(this.f22185J);
    }

    @Override // com.oplus.camera.p172ui.preview.FocusIndicator
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22148a(boolean z, boolean z2) {
        m23592a(z, false, z2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23592a(boolean z, boolean z2, boolean z3) {
        if (this.f22213x || z3) {
            CameraLog.m12962c("FocusIndicatorRotateLayout", "showSuccess, mbForceDisableFocusIndicator: " + this.f22213x + ", isExposureAdjusting: " + z3);
            return;
        }
        if (!z2 && this.f22190a != 1) {
            CameraLog.m12962c("FocusIndicatorRotateLayout", "showSuccess, short circle, aEAFLocked: " + z2 + " mState: " + this.f22190a);
            return;
        }
        setVisibility(0);
        m23599c(false);
        m23567a(1.0f, 1.0f, true, z, 100L);
        this.f22190a = 2;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m23595b(boolean z, boolean z2) {
        if (this.f22213x || z2) {
            CameraLog.m12962c("FocusIndicatorRotateLayout", "showFail, mbForceDisableFocusIndicator: " + this.f22213x + ", isExposureAdjusting: " + z2);
            return;
        }
        if (this.f22190a != 1) {
            CameraLog.m12962c("FocusIndicatorRotateLayout", "showFail, short circle, mState: " + this.f22190a);
            return;
        }
        setVisibility(0);
        m23599c(false);
        m23567a(1.0f, 1.0f, true, z, 100L);
        this.f22190a = 2;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m23602d() {
        return this.f22190a == 0;
    }

    public void setOnVisibilityChangedListener(IntrinsicsJvm.kt_3 cVar) {
        this.f22188M = cVar;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m23603e() {
        removeCallbacks(this.f22191b);
        this.f22183H = false;
        m23594b(true);
        this.f22191b.run();
        m23566a(1.0f, 1.0f, false);
    }

    @Override // android.view.View
    public void setAlpha(float COUIBaseListPopupWindow_12) {
        this.f22187L = COUIBaseListPopupWindow_12;
        this.f22212w.setAlpha(COUIBaseListPopupWindow_12);
        this.f22209t.setAlpha(COUIBaseListPopupWindow_12);
        this.f22207r.setAlpha(COUIBaseListPopupWindow_12);
        this.f22208s.setAlpha(COUIBaseListPopupWindow_12);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int OplusGLSurfaceView_13) {
        super.onVisibilityChanged(view, OplusGLSurfaceView_13);
        IntrinsicsJvm.kt_3 cVar = this.f22188M;
        if (cVar != null) {
            cVar.onVisibilityChanged(view, OplusGLSurfaceView_13);
        }
    }

    @Override // android.view.View
    public float getAlpha() {
        return this.f22187L;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23566a(float COUIBaseListPopupWindow_12, float f2, boolean z) {
        m23567a(COUIBaseListPopupWindow_12, f2, z, false, 0L);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23567a(float COUIBaseListPopupWindow_12, float f2, boolean z, boolean z2, long OplusGLSurfaceView_15) {
        this.f22206q.animate().cancel();
        this.f22209t.animate().cancel();
        if (z) {
            this.f22206q.animate().withLayer().setDuration(OplusGLSurfaceView_15).scaleX(COUIBaseListPopupWindow_12).scaleY(f2).setInterpolator(this.f22185J).withEndAction(z2 ? this.f22192c : null);
            this.f22209t.animate().withLayer().setDuration(OplusGLSurfaceView_15).scaleX(COUIBaseListPopupWindow_12).scaleY(f2).setInterpolator(this.f22185J).withEndAction(z2 ? this.f22192c : null);
        } else {
            this.f22206q.setScaleX(COUIBaseListPopupWindow_12);
            this.f22206q.setScaleY(f2);
            this.f22209t.setScaleX(COUIBaseListPopupWindow_12);
            this.f22209t.setScaleY(f2);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m23604e(boolean z) {
        this.f22213x = z;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean m23605f() {
        return this.f22183H;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m23568a(int OplusGLSurfaceView_13) {
        this.f22186K.cancel();
        float rotation = this.f22206q.getRotation();
        int i2 = (int) rotation;
        long jM18346c = RotateImageView.m18346c(i2, OplusGLSurfaceView_13);
        this.f22186K.setFloatValues(rotation, RotateImageView.m18345b(i2, OplusGLSurfaceView_13) + rotation);
        this.f22186K.setDuration(jM18346c);
        this.f22186K.start();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m23590a(int OplusGLSurfaceView_13, boolean z) {
        this.f22204o = OplusGLSurfaceView_13;
        m23568a(-OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.p172ui.preview.ExposureSeekbarContainer.InterfaceC3377a
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22117a(float COUIBaseListPopupWindow_12) {
        this.f22205p.mo23657a(COUIBaseListPopupWindow_12);
    }

    @Override // com.oplus.camera.p172ui.preview.ExposureSeekbarContainer.InterfaceC3377a
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22116a() {
        this.f22205p.mo23694i(true);
    }

    /* compiled from: FocusIndicatorRotateLayout.java */
    /* renamed from: com.oplus.camera.ui.preview.OplusGLSurfaceView_11$IntrinsicsJvm.kt_4 */
    private class IntrinsicsJvm.kt_4 implements Runnable {
        private IntrinsicsJvm.kt_4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FocusIndicatorRotateLayout c3451n = FocusIndicatorRotateLayout.this;
            c3451n.postDelayed(c3451n.f22191b, 200L);
        }
    }

    /* compiled from: FocusIndicatorRotateLayout.java */
    /* renamed from: com.oplus.camera.ui.preview.OplusGLSurfaceView_11$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 implements Runnable {
        private PlatformImplementations.kt_3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FocusIndicatorRotateLayout.this.setVisibility(4);
            FocusIndicatorRotateLayout.this.f22190a = 0;
        }
    }
}
