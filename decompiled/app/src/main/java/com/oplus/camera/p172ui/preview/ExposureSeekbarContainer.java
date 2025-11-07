package com.oplus.camera.p172ui.preview;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieOnCompositionLoadedListener;
import com.airbnb.lottie.InterfaceC1205k;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.p084c.KeyPath_2;
import com.airbnb.lottie.p092g.LottieFrameInfo;
import com.airbnb.lottie.p092g.LottieValueCallback;
import com.airbnb.lottie.p092g.SimpleLottieValueCallback;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.RotateLottieAnimationView;
import com.oplus.camera.util.Util;

/* loaded from: classes2.dex */
public class ExposureSeekbarContainer extends RelativeLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String f20735a = "ExposureSeekbarContainer";

    /* renamed from: IntrinsicsJvm.kt_4 */
    private PorterDuffColorFilter f20736b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private RotateLottieAnimationView f20737c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private FrameLayout f20738d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private FrameLayout f20739e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private LottieAnimationView f20740f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f20741g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f20742h;

    /* renamed from: OplusGLSurfaceView_13 */
    private float f20743i;

    /* renamed from: OplusGLSurfaceView_15 */
    private float f20744j;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f20745k;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f20746l;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f20747m;

    /* renamed from: OplusGLSurfaceView_11 */
    private float f20748n;

    /* renamed from: o */
    private InterfaceC3377a f20749o;

    /* renamed from: p */
    private LottieValueCallback<ColorFilter> f20750p;

    /* renamed from: com.oplus.camera.ui.preview.ExposureSeekbarContainer$PlatformImplementations.kt_3 */
    public interface InterfaceC3377a {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo22116a();

        /* renamed from: PlatformImplementations.kt_3 */
        void mo22117a(float COUIBaseListPopupWindow_12);
    }

    public ExposureSeekbarContainer(Context context) {
        this(context, null);
    }

    public ExposureSeekbarContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ExposureSeekbarContainer(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        this(context, attributeSet, OplusGLSurfaceView_13, 0);
    }

    public ExposureSeekbarContainer(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13, i2);
        this.f20736b = null;
        this.f20737c = null;
        this.f20738d = null;
        this.f20739e = null;
        this.f20740f = null;
        this.f20741g = 0;
        this.f20742h = 0;
        this.f20743i = 1.0f;
        this.f20744j = 0.0f;
        this.f20745k = false;
        this.f20746l = false;
        this.f20747m = false;
        this.f20748n = 1.0f;
        this.f20749o = null;
        this.f20750p = new LottieValueCallback<ColorFilter>() { // from class: com.oplus.camera.ui.preview.ExposureSeekbarContainer.1
            @Override // com.airbnb.lottie.p092g.LottieValueCallback
            /* renamed from: IntrinsicsJvm.kt_4, reason: merged with bridge method [inline-methods] */
            public ColorFilter mo5523a(LottieFrameInfo c1198b) {
                if (ExposureSeekbarContainer.this.f20745k) {
                    return ExposureSeekbarContainer.this.f20736b;
                }
                return null;
            }
        };
        this.f20736b = new PorterDuffColorFilter(Util.m24164A(context), PorterDuff.Mode.SRC_ATOP);
        this.f20741g = getResources().getDimensionPixelSize(R.dimen.exposure_bar_container_width);
        this.f20742h = getResources().getDimensionPixelSize(R.dimen.exposure_bar_container_height);
        this.f20743i = (float) (Util.getScreenWidth() * 1.3333333333333333d);
        m22105a(context);
        setProgress(50.0f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m22105a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.exposure_seekbar_layout, this);
        this.f20737c = (RotateLottieAnimationView) findViewById(R.id_renamed.ae_af_toggle);
        this.f20737c.setAnimation(R.raw.exposure_lock_lottie_anim);
        this.f20740f = (LottieAnimationView) findViewById(R.id_renamed.exposure_seekbar);
        this.f20740f.setAnimation(R.raw.exposure_bar_lottie_anim);
        this.f20738d = (FrameLayout) findViewById(R.id_renamed.ae_af_toggle_wrapper);
        this.f20739e = (FrameLayout) findViewById(R.id_renamed.exposure_seekbar_wrapper);
        this.f20737c.m5514a(new LottieOnCompositionLoadedListener() { // from class: com.oplus.camera.ui.preview.-$$Lambda$ExposureSeekbarContainer$3d5tp06rTYagvfUyY-Typd8UQQ4
            @Override // com.airbnb.lottie.LottieOnCompositionLoadedListener
            public final void onCompositionLoaded(LottieComposition c1136d) {
                this.COUIBaseListPopupWindow_12$0.m22110b(c1136d);
            }
        });
        this.f20740f.m5514a(new LottieOnCompositionLoadedListener() { // from class: com.oplus.camera.ui.preview.-$$Lambda$ExposureSeekbarContainer$RZOaKOML0bENKAR5ydHoVSHipVw
            @Override // com.airbnb.lottie.LottieOnCompositionLoadedListener
            public final void onCompositionLoaded(LottieComposition c1136d) {
                this.COUIBaseListPopupWindow_12$0.m22107a(c1136d);
            }
        });
        this.f20738d.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.ui.preview.-$$Lambda$ExposureSeekbarContainer$j0Jv_n_h8Ky4lPoLmUlCbY2Waa0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.COUIBaseListPopupWindow_12$0.m22106a(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public /* synthetic */ void m22110b(LottieComposition c1136d) {
        this.f20737c.m5509a(new KeyPath_2("**"), (KeyPath_2) InterfaceC1205k.f5926E, (LottieValueCallback<KeyPath_2>) this.f20750p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m22107a(LottieComposition c1136d) {
        this.f20740f.m5509a(new KeyPath_2("**"), (KeyPath_2) InterfaceC1205k.f5926E, (LottieValueCallback<KeyPath_2>) this.f20750p);
        this.f20740f.m5510a(new KeyPath_2("line", "*"), (KeyPath_2) InterfaceC1205k.f5930c, (SimpleLottieValueCallback<KeyPath_2>) new SimpleLottieValueCallback() { // from class: com.oplus.camera.ui.preview.-$$Lambda$ExposureSeekbarContainer$dpr_aN8n9Pcg1JqvUDZETHAVUEk
            @Override // com.airbnb.lottie.p092g.SimpleLottieValueCallback
            public final Object getValue(LottieFrameInfo c1198b) {
                return this.COUIBaseListPopupWindow_12$0.m22104a(c1198b);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ Integer m22104a(LottieFrameInfo c1198b) {
        return Integer.valueOf(this.f20746l ? 100 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m22106a(View view) {
        CameraLog.m12954a(f20735a, "onClick, v: " + view + ", alpha: " + getAlpha());
        InterfaceC3377a interfaceC3377a = this.f20749o;
        if (interfaceC3377a != null) {
            interfaceC3377a.mo22116a();
        }
    }

    public void setOnSeekbarChangeListener(InterfaceC3377a interfaceC3377a) {
        this.f20749o = interfaceC3377a;
    }

    public float getDampingFactor() {
        float COUIBaseListPopupWindow_12 = this.f20744j;
        return (COUIBaseListPopupWindow_12 < 20.0f || COUIBaseListPopupWindow_12 > 80.0f) ? 80.0f : 200.0f;
    }

    public void setLockedState(boolean z) {
        if (this.f20745k == z) {
            CameraLog.m12959b(f20735a, "setLockedState, same locked state, locked: " + z);
            return;
        }
        CameraLog.m12959b(f20735a, "setLockedState, state from " + this.f20745k + " to " + z);
        this.f20745k = z;
        this.f20750p.m6174a((LottieValueCallback<ColorFilter>) (z ? this.f20736b : null));
        if (this.f20737c.isShown()) {
            this.f20737c.setSpeed(z ? 1.0f : -1.0f);
            this.f20737c.m5507a();
            CameraLog.m12959b(f20735a, "setLockedState, is shown");
        } else {
            this.f20737c.m5518e();
            this.f20737c.setProgress(z ? 1.0f : 0.0f);
            this.f20737c.invalidate();
            CameraLog.m12959b(f20735a, "setLockedState, is not shown");
        }
        this.f20740f.invalidate();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22113a(boolean z) {
        setVisibility(4);
        setLockedState(false);
        if (this.f20740f != null) {
            m22114b(false);
            if (z) {
                setProgress(50.0f);
            }
        }
    }

    public float getContainerWidth() {
        return this.f20741g;
    }

    public float getContainerHeight() {
        return this.f20742h;
    }

    private void setProgress(float COUIBaseListPopupWindow_12) {
        if (Float.compare(this.f20744j, COUIBaseListPopupWindow_12) == 0) {
            CameraLog.m12959b(f20735a, "setProgress, progress unchanged.");
            return;
        }
        this.f20744j = COUIBaseListPopupWindow_12;
        this.f20740f.setProgress(this.f20744j / 100.0f);
        InterfaceC3377a interfaceC3377a = this.f20749o;
        if (interfaceC3377a != null) {
            interfaceC3377a.mo22117a(this.f20744j / 100.0f);
        }
        CameraLog.m12959b(f20735a, "setProgress, mProgress: " + this.f20744j + " lottie progress: " + this.f20740f.getProgress());
    }

    public void setToggleViewEnable(boolean z) {
        this.f20747m = z;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m22114b(boolean z) {
        if (this.f20746l == z) {
            CameraLog.m12959b(f20735a, "expandExposureSeekbar, same state, mExpandSeekbar: " + this.f20746l);
            return;
        }
        CameraLog.m12959b(f20735a, "expandExposureSeekbar, state from " + this.f20746l + " to " + z + ", mToggleWrapperEnable: " + this.f20747m);
        this.f20746l = z;
        this.f20740f.invalidate();
        this.f20737c.m5518e();
        this.f20737c.setProgress(this.f20745k ? 1.0f : 0.0f);
        this.f20737c.invalidate();
        this.f20738d.setVisibility((z && this.f20747m) ? 0 : 8);
    }

    public void setMoveDistance(float COUIBaseListPopupWindow_12) {
        CameraLog.m12959b(f20735a, "setMoveDistance, moveDistance: " + COUIBaseListPopupWindow_12);
        float fM24201a = Util.m24201a(this.f20744j + ((COUIBaseListPopupWindow_12 / this.f20743i) * getDampingFactor()), 0.0f, 100.0f);
        m22114b(true);
        setProgress(fM24201a);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x003d A[PHI: r8
      0x003d: PHI (r8v5 boolean) = (r8v3 boolean), (r8v12 boolean) binds: [B:38:0x0058, B:23:0x003b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004a A[PHI: r9
      0x004a: PHI (r9v11 boolean) = (r9v9 boolean), (r9v16 boolean) binds: [B:30:0x0048, B:16:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m22111a(float r8, float r9, int r10, int r11, int r12) {
        /*
            r7 = this;
            int r0 = r7.f20741g
            int r1 = r7.f20742h
            float r0 = (float) r0
            r2 = 1073741824(0x40000000, float:2.0)
            float r0 = r0 / r2
            float r3 = r8 - r0
            float r1 = (float) r1
            float r1 = r1 / r2
            float r2 = r9 - r1
            r4 = 1
            r5 = 0
            if (r12 == 0) goto L4d
            r6 = 90
            if (r12 == r6) goto L3f
            r6 = 180(0xb4, float:2.52E-43)
            if (r12 == r6) goto L30
            r6 = 270(0x10e, float:3.78E-43)
            if (r12 == r6) goto L20
            r8 = r5
            goto L5b
        L20:
            float r11 = (float) r11
            float r11 = r11 - r0
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 < 0) goto L28
            r9 = r4
            goto L29
        L28:
            r9 = r5
        L29:
            float r10 = (float) r10
            float r10 = r10 - r1
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 < 0) goto L4b
            goto L4a
        L30:
            int r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r8 > 0) goto L36
            r8 = r4
            goto L37
        L36:
            r8 = r5
        L37:
            float r10 = (float) r11
            float r10 = r10 - r1
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 < 0) goto L5b
        L3d:
            r5 = r4
            goto L5b
        L3f:
            int r9 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r9 > 0) goto L45
            r9 = r4
            goto L46
        L45:
            r9 = r5
        L46:
            int r8 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r8 > 0) goto L4b
        L4a:
            r5 = r4
        L4b:
            r8 = r9
            goto L5b
        L4d:
            float r10 = (float) r10
            float r10 = r10 - r0
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 < 0) goto L55
            r8 = r4
            goto L56
        L55:
            r8 = r5
        L56:
            int r9 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r9 > 0) goto L5b
            goto L3d
        L5b:
            int r9 = -r12
            float r9 = (float) r9
            r7.setRotation(r9)
            r7.setTranslationX(r3)
            r7.setTranslationY(r2)
            android.widget.FrameLayout r9 = r7.f20738d
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            android.widget.RelativeLayout$LayoutParams r9 = (android.widget.RelativeLayout.LayoutParams) r9
            android.widget.FrameLayout r10 = r7.f20739e
            android.view.ViewGroup$LayoutParams r10 = r10.getLayoutParams()
            android.widget.RelativeLayout$LayoutParams r10 = (android.widget.RelativeLayout.LayoutParams) r10
            r11 = 21
            r12 = 20
            if (r8 == 0) goto L89
            r9.removeRule(r11)
            r9.addRule(r12)
            r10.removeRule(r11)
            r10.addRule(r12)
            goto L95
        L89:
            r9.removeRule(r12)
            r9.addRule(r11)
            r10.removeRule(r12)
            r10.addRule(r11)
        L95:
            r8 = 10
            r10 = 12
            if (r5 == 0) goto La2
            r9.removeRule(r8)
            r9.addRule(r10)
            goto La8
        La2:
            r9.removeRule(r10)
            r9.addRule(r8)
        La8:
            r7.requestLayout()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.preview.ExposureSeekbarContainer.m22111a(float, float, int, int, int):void");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22112a(int OplusGLSurfaceView_13, boolean z) {
        this.f20737c.m18349a(OplusGLSurfaceView_13, z);
    }

    @Override // android.view.View
    public void setAlpha(float COUIBaseListPopupWindow_12) {
        this.f20748n = COUIBaseListPopupWindow_12;
        this.f20740f.setAlpha(COUIBaseListPopupWindow_12);
        this.f20737c.setAlpha(COUIBaseListPopupWindow_12);
    }

    @Override // android.view.View
    public float getAlpha() {
        return this.f20748n;
    }
}
