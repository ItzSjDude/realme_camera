package com.oplus.camera.p172ui.preview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.res.Resources;
import android.hardware.HardwareBuffer;
import android.media.Image;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Size;
import android.view.animation.PathInterpolator;
import android.widget.RelativeLayout;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.p146gl.GLPaint;
import com.oplus.camera.p146gl.TeleSmallPreviewGLSurfaceView;
import com.oplus.camera.p172ui.CameraUIListener;
import com.oplus.camera.p172ui.menu.setting.CameraDrawerSettingUI;
import com.oplus.camera.p172ui.preview.CameraPreviewUI;
import com.oplus.camera.screen.p164b.BaseScreenMode;
import com.oplus.camera.util.Util;

/* compiled from: TeleSmallPreviewManager.java */
/* renamed from: com.oplus.camera.ui.preview.ab */
/* loaded from: classes2.dex */
public class TeleSmallPreviewManager implements CameraDrawerSettingUI.PlatformImplementations.kt_3, CameraPreviewUI.IntrinsicsJvm.kt_3 {

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Activity f21584e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Handler f21585f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private PreviewFrameLayout f21586g;

    /* renamed from: OplusGLSurfaceView_13 */
    private CameraUIListener f21588i;

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean f21580a = true;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f21581b = false;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f21582c = false;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f21583d = false;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private TeleSmallPreviewGLSurfaceView f21587h = null;

    /* renamed from: OplusGLSurfaceView_15 */
    private IntrinsicsJvm.kt_4 f21589j = null;

    /* renamed from: OplusGLSurfaceView_5 */
    private float f21590k = 1.0f;

    /* renamed from: OplusGLSurfaceView_14 */
    private float f21591l = 1.0f;

    /* renamed from: OplusGLSurfaceView_6 */
    private float f21592m = 1.0f;

    /* renamed from: OplusGLSurfaceView_11 */
    private float f21593n = 1.0f;

    /* renamed from: o */
    private Size f21594o = null;

    /* renamed from: p */
    private int f21595p = 0;

    /* renamed from: q */
    private boolean f21596q = false;

    /* renamed from: r */
    private boolean f21597r = false;

    /* renamed from: s */
    private boolean f21598s = false;

    public TeleSmallPreviewManager(Activity activity, CameraUIListener cameraUIListener) throws Resources.NotFoundException {
        this.f21584e = null;
        this.f21585f = null;
        this.f21586g = null;
        this.f21588i = null;
        this.f21584e = activity;
        this.f21588i = cameraUIListener;
        this.f21585f = new PlatformImplementations.kt_3(this.f21584e.getMainLooper());
        this.f21586g = (PreviewFrameLayout) this.f21584e.findViewById(R.id_renamed.frame_layout);
        m22992i();
        m22990g();
        m22991h();
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m22990g() {
        float[] configFloatArrayValue = CameraConfig.getConfigFloatArrayValue(ConfigDataBase.KEY_SAT_TELE_ZOOM_RANGE);
        if (configFloatArrayValue == null || configFloatArrayValue.length != 2) {
            return;
        }
        this.f21590k = configFloatArrayValue[0];
        this.f21591l = configFloatArrayValue[1];
        this.f21592m = Float.compare(20.0f, this.f21591l) >= 0 ? 15.0f : 20.0f;
        CameraLog.m12959b("TeleSmallPreviewManager", "initTeleZoomRange, range: (" + this.f21590k + ", " + this.f21591l + ")");
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m22991h() throws Resources.NotFoundException {
        RelativeLayout.LayoutParams layoutParams;
        TeleSmallPreviewGLSurfaceView c2770u = this.f21587h;
        if (c2770u == null) {
            this.f21587h = new TeleSmallPreviewGLSurfaceView(this.f21584e);
            this.f21587h.m14268b();
            BaseScreenMode abstractC2934aMo10769bL = this.f21588i.mo10769bL();
            if (abstractC2934aMo10769bL != null && abstractC2934aMo10769bL.mo16631r()) {
                layoutParams = m22979a(abstractC2934aMo10769bL);
            } else {
                layoutParams = new RelativeLayout.LayoutParams(0, 0);
                layoutParams.addRule(10);
                layoutParams.addRule(11);
                layoutParams.rightMargin = this.f21584e.getResources().getDimensionPixelSize(R.dimen.tele_small_preview_right_margin);
                layoutParams.topMargin = this.f21584e.getResources().getDimensionPixelSize(R.dimen.tele_small_preview_top_margin);
            }
            if (this.f21586g.getChildCount() > 3) {
                this.f21586g.addView(this.f21587h, 3, layoutParams);
            } else {
                this.f21586g.addView(this.f21587h, layoutParams);
            }
            GLPaint c2761l = new GLPaint();
            c2761l.m14024a(this.f21584e.getResources().getColor(R.color.color_white_with_full_percent_transparency));
            c2761l.m14023a(this.f21584e.getResources().getDimensionPixelSize(R.dimen.tele_small_preview_out_line_width));
            this.f21587h.setOuterFramePaint(c2761l);
            GLPaint c2761l2 = new GLPaint();
            c2761l2.m14024a(this.f21584e.getResources().getColor(R.color.color_white_with_full_percent_transparency));
            c2761l2.m14023a(this.f21584e.getResources().getDimensionPixelSize(R.dimen.tele_small_preview_inner_line_width));
            this.f21587h.setInnerFramePaint(c2761l2);
            GLPaint c2761l3 = new GLPaint();
            c2761l3.m14024a(this.f21584e.getResources().getColor(R.color.color_white_with_50_percent_transparency));
            c2761l3.m14023a(this.f21584e.getResources().getDimensionPixelSize(R.dimen.tele_small_preview_inner_line_width));
            this.f21587h.setLinePaint(c2761l3);
            this.f21587h.setVisibility(4);
            return;
        }
        c2770u.m14269e();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m23002b(boolean z) {
        TeleSmallPreviewGLSurfaceView c2770u = this.f21587h;
        if (c2770u != null) {
            c2770u.setRearMirrorEnable(z);
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m22992i() {
        HandlerThread handlerThread = new HandlerThread("ScreenModeChange State Thread");
        handlerThread.start();
        this.f21589j = new IntrinsicsJvm.kt_4(handlerThread.getLooper());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22996a(CameraDrawerSettingUI c3326f) {
        if (c3326f != null) {
            c3326f.m21406a(this);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22997a(CameraPreviewUI viewOnLayoutChangeListenerC3444g) {
        if (viewOnLayoutChangeListenerC3444g != null) {
            viewOnLayoutChangeListenerC3444g.m23350a(this);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m23000a(float COUIBaseListPopupWindow_12) {
        return Float.compare(COUIBaseListPopupWindow_12, this.f21592m) > 0;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m23001b(float COUIBaseListPopupWindow_12) {
        this.f21593n = COUIBaseListPopupWindow_12;
        float f2 = this.f21593n;
        float f3 = this.f21592m;
        if (f2 < f3) {
            this.f21593n = f3;
        }
        float f4 = this.f21590k / (this.f21593n * 2.0f);
        TeleSmallPreviewGLSurfaceView c2770u = this.f21587h;
        if (c2770u != null) {
            c2770u.setFrameDelta(f4);
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.CameraDrawerSettingUI.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21431a(boolean z) {
        this.f21596q = z;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m23005c(boolean z) {
        this.f21597r = z;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m23007d(boolean z) {
        IntrinsicsJvm.kt_4 bVar = this.f21589j;
        if (bVar == null) {
            return;
        }
        bVar.removeCallbacksAndMessages(null);
        Message messageObtain = Message.obtain();
        if (z) {
            messageObtain.what = 3;
            this.f21589j.sendMessage(messageObtain);
        } else {
            messageObtain.what = 4;
            this.f21589j.sendMessageDelayed(messageObtain, 60L);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m22999a() {
        return this.f21596q || this.f21597r || (Util.m24495t() && this.f21598s);
    }

    @Override // com.oplus.camera.p172ui.preview.CameraPreviewUI.IntrinsicsJvm.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22995a(RelativeLayout.LayoutParams layoutParams) throws Resources.NotFoundException {
        RelativeLayout.LayoutParams layoutParamsM22979a;
        if (this.f21587h != null) {
            BaseScreenMode abstractC2934aMo10769bL = this.f21588i.mo10769bL();
            if (abstractC2934aMo10769bL != null && abstractC2934aMo10769bL.mo16631r()) {
                layoutParamsM22979a = m22979a(abstractC2934aMo10769bL);
            } else {
                int OplusGLSurfaceView_13 = ((RelativeLayout.LayoutParams) this.f21586g.getLayoutParams()).topMargin - layoutParams.topMargin;
                layoutParamsM22979a = (RelativeLayout.LayoutParams) this.f21587h.getLayoutParams();
                layoutParamsM22979a.topMargin += OplusGLSurfaceView_13;
            }
            this.f21587h.setLayoutParams(layoutParamsM22979a);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m23009e(boolean z) {
        this.f21580a = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22994a(Size size) {
        CameraLog.m12959b("TeleSmallPreviewManager", "setPreviewSize, " + size);
        if (size != null) {
            this.f21594o = size;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m23003b() {
        TeleSmallPreviewGLSurfaceView c2770u = this.f21587h;
        return c2770u != null && c2770u.getVisibility() == 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22998a(boolean z, boolean z2, boolean z3) {
        Message messageObtainMessage;
        CameraLog.m12959b("TeleSmallPreviewManager", "setTeleSmallPreviewViewVisible, visible: " + z);
        this.f21582c = z2;
        if (this.f21598s && !z) {
            this.f21582c = false;
        }
        this.f21583d = z3;
        if (z) {
            messageObtainMessage = this.f21585f.obtainMessage(1);
            this.f21585f.removeMessages(1);
        } else {
            messageObtainMessage = this.f21585f.obtainMessage(2);
            this.f21585f.removeMessages(2);
        }
        this.f21585f.sendMessage(messageObtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m22984b(boolean z, boolean z2, boolean z3) throws Resources.NotFoundException {
        PathInterpolator pathInterpolator;
        Animator.AnimatorListener animatorListener;
        ObjectAnimator objectAnimatorOfFloat;
        ObjectAnimator objectAnimatorOfFloat2;
        CameraLog.m12959b("TeleSmallPreviewManager", "showTeleSmallPreviewView");
        TeleSmallPreviewGLSurfaceView c2770u = this.f21587h;
        if (c2770u == null) {
            CameraLog.m12959b("TeleSmallPreviewManager", "showTeleSmallPreviewView, view is null");
            return;
        }
        if (!z || c2770u.getVisibility() != 0) {
            if (z || 4 != this.f21587h.getVisibility()) {
                BaseScreenMode abstractC2934aMo10769bL = this.f21588i.mo10769bL();
                if (z) {
                    RelativeLayout.LayoutParams layoutParamsM22979a = (RelativeLayout.LayoutParams) this.f21587h.getLayoutParams();
                    Size size = this.f21594o;
                    if (size != null) {
                        this.f21595p = Util.m24426d(size.getWidth(), this.f21594o.getHeight());
                    }
                    layoutParamsM22979a.width = this.f21584e.getResources().getDimensionPixelSize(R.dimen.tele_small_preview_width);
                    layoutParamsM22979a.rightMargin = this.f21584e.getResources().getDimensionPixelSize(R.dimen.tele_small_preview_right_margin);
                    m22981a(layoutParamsM22979a, true, true);
                    int dimensionPixelSize = Util.m24495t() ? this.f21584e.getResources().getDimensionPixelSize(R.dimen.fold_full_tele_small_preview_top_margin) : 0;
                    int iM24198Z = Util.m24198Z();
                    int OplusGLSurfaceView_13 = this.f21595p;
                    if (OplusGLSurfaceView_13 == 0) {
                        layoutParamsM22979a.height = this.f21584e.getResources().getDimensionPixelSize(R.dimen.tele_small_preview_height_ratio_43);
                        layoutParamsM22979a.topMargin = this.f21584e.getResources().getDimensionPixelSize(R.dimen.tele_small_preview_top_margin);
                        if (3 == this.f21588i.mo10816ca()) {
                            layoutParamsM22979a.topMargin = (Util.m24186N() - ((RelativeLayout.LayoutParams) this.f21586g.getLayoutParams()).topMargin) + this.f21584e.getResources().getDimensionPixelSize(R.dimen.tele_small_preview_top_margin);
                        } else if (1 == this.f21588i.mo10816ca()) {
                            layoutParamsM22979a.width = this.f21584e.getResources().getDimensionPixelSize(R.dimen.fold_tele_small_preview_width);
                            layoutParamsM22979a.height = this.f21584e.getResources().getDimensionPixelSize(R.dimen.fold_full_tele_small_preview_height_ratio_43);
                            layoutParamsM22979a.rightMargin = dimensionPixelSize;
                            layoutParamsM22979a.topMargin = dimensionPixelSize;
                            if (abstractC2934aMo10769bL != null) {
                                if (6 == abstractC2934aMo10769bL.mo16572m()) {
                                    m22981a(layoutParamsM22979a, true, false);
                                    layoutParamsM22979a.rightMargin = dimensionPixelSize;
                                    if (iM24198Z != 0) {
                                        dimensionPixelSize = iM24198Z;
                                    }
                                    layoutParamsM22979a.bottomMargin = dimensionPixelSize;
                                } else if (5 == abstractC2934aMo10769bL.mo16572m()) {
                                    m22981a(layoutParamsM22979a, false, false);
                                    layoutParamsM22979a.leftMargin = dimensionPixelSize;
                                    if (iM24198Z != 0) {
                                        dimensionPixelSize = iM24198Z;
                                    }
                                    layoutParamsM22979a.bottomMargin = dimensionPixelSize;
                                }
                            }
                        }
                    } else if (OplusGLSurfaceView_13 == 1) {
                        layoutParamsM22979a.height = this.f21584e.getResources().getDimensionPixelSize(R.dimen.tele_small_preview_height_ratio_169);
                        layoutParamsM22979a.topMargin = this.f21584e.getResources().getDimensionPixelSize(R.dimen.tele_small_preview_top_margin);
                        if (2 == this.f21588i.mo10816ca() || 3 == this.f21588i.mo10816ca()) {
                            layoutParamsM22979a.topMargin = (Util.m24186N() - ((RelativeLayout.LayoutParams) this.f21586g.getLayoutParams()).topMargin) + this.f21584e.getResources().getDimensionPixelSize(R.dimen.tele_small_preview_top_margin);
                        } else if (1 == this.f21588i.mo10816ca()) {
                            layoutParamsM22979a.width = this.f21584e.getResources().getDimensionPixelSize(R.dimen.fold_tele_small_preview_width);
                            layoutParamsM22979a.height = this.f21584e.getResources().getDimensionPixelSize(R.dimen.fold_full_tele_small_preview_height_ratio_169);
                            layoutParamsM22979a.rightMargin = dimensionPixelSize;
                            layoutParamsM22979a.topMargin = dimensionPixelSize;
                            if (abstractC2934aMo10769bL != null) {
                                if (6 == abstractC2934aMo10769bL.mo16572m()) {
                                    m22981a(layoutParamsM22979a, true, false);
                                    layoutParamsM22979a.rightMargin = dimensionPixelSize;
                                    layoutParamsM22979a.bottomMargin = this.f21584e.getResources().getDimensionPixelSize(R.dimen.fold_full_tele_small_preview_top_margin_ratio_169);
                                } else if (5 == abstractC2934aMo10769bL.mo16572m()) {
                                    m22981a(layoutParamsM22979a, false, false);
                                    layoutParamsM22979a.leftMargin = dimensionPixelSize;
                                    layoutParamsM22979a.bottomMargin = this.f21584e.getResources().getDimensionPixelSize(R.dimen.fold_full_tele_small_preview_top_margin_ratio_169);
                                }
                            }
                        }
                    } else if (OplusGLSurfaceView_13 == 2) {
                        layoutParamsM22979a.height = this.f21584e.getResources().getDimensionPixelSize(R.dimen.tele_small_preview_height_ratio_11);
                        layoutParamsM22979a.topMargin = this.f21584e.getResources().getDimensionPixelSize(R.dimen.tele_small_preview_top_margin);
                        if (1 == this.f21588i.mo10816ca()) {
                            layoutParamsM22979a.width = this.f21584e.getResources().getDimensionPixelSize(R.dimen.fold_tele_small_preview_width);
                            layoutParamsM22979a.height = this.f21584e.getResources().getDimensionPixelSize(R.dimen.fold_full_tele_small_preview_height_ratio_11);
                            layoutParamsM22979a.rightMargin = dimensionPixelSize;
                            layoutParamsM22979a.topMargin = dimensionPixelSize;
                            if (abstractC2934aMo10769bL != null) {
                                if (6 == abstractC2934aMo10769bL.mo16572m()) {
                                    m22981a(layoutParamsM22979a, true, false);
                                    layoutParamsM22979a.rightMargin = dimensionPixelSize;
                                    if (iM24198Z != 0) {
                                        dimensionPixelSize = iM24198Z;
                                    }
                                    layoutParamsM22979a.bottomMargin = dimensionPixelSize;
                                } else if (5 == abstractC2934aMo10769bL.mo16572m()) {
                                    m22981a(layoutParamsM22979a, false, false);
                                    layoutParamsM22979a.leftMargin = dimensionPixelSize;
                                    if (iM24198Z != 0) {
                                        dimensionPixelSize = iM24198Z;
                                    }
                                    layoutParamsM22979a.bottomMargin = dimensionPixelSize;
                                }
                            }
                        }
                    } else if (OplusGLSurfaceView_13 == 6) {
                        layoutParamsM22979a.height = this.f21584e.getResources().getDimensionPixelSize(R.dimen.tele_small_preview_height_ratio_1415);
                        layoutParamsM22979a.topMargin = this.f21584e.getResources().getDimensionPixelSize(R.dimen.tele_small_preview_top_margin);
                        if (1 == this.f21588i.mo10816ca()) {
                            layoutParamsM22979a.width = this.f21584e.getResources().getDimensionPixelSize(R.dimen.fold_tele_small_preview_width);
                            layoutParamsM22979a.height = this.f21584e.getResources().getDimensionPixelSize(R.dimen.fold_full_tele_small_preview_height_ratio_1415);
                            layoutParamsM22979a.rightMargin = dimensionPixelSize;
                            layoutParamsM22979a.topMargin = dimensionPixelSize;
                            if (abstractC2934aMo10769bL != null) {
                                if (6 == abstractC2934aMo10769bL.mo16572m()) {
                                    m22981a(layoutParamsM22979a, true, false);
                                    layoutParamsM22979a.rightMargin = dimensionPixelSize;
                                    if (iM24198Z != 0) {
                                        dimensionPixelSize = iM24198Z;
                                    }
                                    layoutParamsM22979a.bottomMargin = dimensionPixelSize;
                                } else if (5 == abstractC2934aMo10769bL.mo16572m()) {
                                    m22981a(layoutParamsM22979a, false, false);
                                    layoutParamsM22979a.leftMargin = dimensionPixelSize;
                                    if (iM24198Z != 0) {
                                        dimensionPixelSize = iM24198Z;
                                    }
                                    layoutParamsM22979a.bottomMargin = dimensionPixelSize;
                                }
                            }
                        }
                    } else {
                        layoutParamsM22979a.height = this.f21584e.getResources().getDimensionPixelSize(R.dimen.tele_small_preview_height_ratio_full);
                        layoutParamsM22979a.topMargin = this.f21584e.getResources().getDimensionPixelSize(R.dimen.menu_panel_layout_height) + this.f21584e.getResources().getDimensionPixelSize(R.dimen.tele_small_preview_top_margin);
                    }
                    if (abstractC2934aMo10769bL != null && abstractC2934aMo10769bL.mo16631r()) {
                        layoutParamsM22979a = m22979a(abstractC2934aMo10769bL);
                    }
                    this.f21587h.setLayoutParams(layoutParamsM22979a);
                }
                PathInterpolator pathInterpolator2 = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
                if (z3 && !z) {
                    pathInterpolator = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
                } else {
                    pathInterpolator = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
                }
                if (z) {
                    animatorListener = new Animator.AnimatorListener() { // from class: com.oplus.camera.ui.preview.ab.1
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                            CameraLog.m12959b("TeleSmallPreviewManager", "showTeleSmallPreviewView, onAnimationStart");
                            if (TeleSmallPreviewManager.this.f21587h != null) {
                                if (TeleSmallPreviewManager.this.f21580a || TeleSmallPreviewManager.this.f21587h.getAnimation() == null) {
                                    TeleSmallPreviewManager.this.f21587h.setVisibility(0);
                                    TeleSmallPreviewManager.this.f21587h.setTeleSmallPreviewRenderModeDirty(false);
                                } else {
                                    TeleSmallPreviewManager.this.f21587h.getAnimation().cancel();
                                }
                            }
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            CameraLog.m12959b("TeleSmallPreviewManager", "showTeleSmallPreviewView, onAnimationEnd");
                            if (TeleSmallPreviewManager.this.f21587h != null) {
                                TeleSmallPreviewManager.this.f21587h.setTeleSmallPreviewRenderModeDirty(true);
                            }
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            CameraLog.m12959b("TeleSmallPreviewManager", "showTeleSmallPreviewView, onAnimationCancel");
                            if (TeleSmallPreviewManager.this.f21587h != null) {
                                TeleSmallPreviewManager.this.f21587h.setVisibility(4);
                                TeleSmallPreviewManager.this.f21587h.setTeleSmallPreviewRenderModeDirty(true);
                            }
                        }
                    };
                } else {
                    animatorListener = new Animator.AnimatorListener() { // from class: com.oplus.camera.ui.preview.ab.2
                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationRepeat(Animator animator) {
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                            CameraLog.m12959b("TeleSmallPreviewManager", "hideTeleSmallPreviewView, onAnimationStart");
                            if (TeleSmallPreviewManager.this.f21587h != null) {
                                TeleSmallPreviewManager.this.f21587h.setTeleSmallPreviewRenderModeDirty(false);
                            }
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            CameraLog.m12959b("TeleSmallPreviewManager", "hideTeleSmallPreviewView, onAnimationEnd");
                            if (TeleSmallPreviewManager.this.f21587h != null) {
                                TeleSmallPreviewManager.this.f21587h.setVisibility(4);
                                TeleSmallPreviewManager.this.f21587h.setTeleSmallPreviewRenderModeDirty(true);
                                TeleSmallPreviewManager.this.f21587h.m14269e();
                            }
                        }

                        @Override // android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            CameraLog.m12959b("TeleSmallPreviewManager", "hideTeleSmallPreviewView, onAnimationCancel");
                            if (TeleSmallPreviewManager.this.f21587h != null) {
                                TeleSmallPreviewManager.this.f21587h.setTeleSmallPreviewRenderModeDirty(true);
                            }
                        }
                    };
                }
                if (!z2) {
                    if (z) {
                        this.f21587h.setVisibility(0);
                        return;
                    } else {
                        this.f21587h.setVisibility(4);
                        return;
                    }
                }
                AnimatorSet animatorSet = new AnimatorSet();
                if (z) {
                    objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f21587h, "scaleX", 0.7f, 1.0f);
                    objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f21587h, "scaleY", 0.7f, 1.0f);
                } else {
                    objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f21587h, "scaleX", 1.0f, 0.7f);
                    objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f21587h, "scaleY", 1.0f, 0.7f);
                }
                animatorSet.setInterpolator(pathInterpolator2);
                animatorSet.addListener(animatorListener);
                animatorSet.setDuration(200L);
                animatorSet.setStartDelay(0L);
                animatorSet.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
                this.f21587h.clearAnimation();
                this.f21587h.invalidate();
                this.f21587h.m14267a(animatorSet, z ? 0 : 4, pathInterpolator);
                this.f21587h.m14270f();
                return;
            }
        }
        CameraLog.m12959b("TeleSmallPreviewManager", "showTeleSmallPreviewView, no need to change visibility");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private RelativeLayout.LayoutParams m22979a(BaseScreenMode abstractC2934a) throws Resources.NotFoundException {
        Size sizeM24180I = Util.m24180I();
        float width = sizeM24180I.getWidth() / sizeM24180I.getHeight();
        int dimensionPixelSize = this.f21584e.getResources().getDimensionPixelSize(R.dimen.fold_tele_small_preview_width);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimensionPixelSize, Math.round(dimensionPixelSize * width));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        if (abstractC2934a.mo16630q()) {
            if (1 == this.f21595p) {
                layoutParams.bottomMargin = Util.m24460i(R.dimen.fold_rack_low_16_9_tele_small_preview_right_margin);
            } else {
                layoutParams.bottomMargin = Util.m24460i(R.dimen.fold_rack_tele_small_preview_right_margin);
            }
            layoutParams.rightMargin = Util.m24460i(R.dimen.fold_rack_low_tele_small_preview_top_margin);
        } else {
            layoutParams.bottomMargin = Util.m24460i(R.dimen.fold_rack_tele_small_preview_right_margin);
            layoutParams.rightMargin = Util.m24460i(R.dimen.fold_rack_tele_small_preview_top_margin);
        }
        return layoutParams;
    }

    /* compiled from: TeleSmallPreviewManager.java */
    /* renamed from: com.oplus.camera.ui.preview.ab$IntrinsicsJvm.kt_4 */
    private class IntrinsicsJvm.kt_4 extends Handler {
        public IntrinsicsJvm.kt_4(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int OplusGLSurfaceView_13 = message.what;
            if (OplusGLSurfaceView_13 == 3) {
                TeleSmallPreviewManager.this.f21598s = true;
            } else {
                if (OplusGLSurfaceView_13 != 4) {
                    return;
                }
                TeleSmallPreviewManager.this.f21598s = false;
            }
        }
    }

    /* compiled from: TeleSmallPreviewManager.java */
    /* renamed from: com.oplus.camera.ui.preview.ab$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 extends Handler {
        public PlatformImplementations.kt_3(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Resources.NotFoundException {
            CameraLog.m12954a("TeleSmallPreviewManager", "handleMessage, msg: " + message.what);
            int OplusGLSurfaceView_13 = message.what;
            if (OplusGLSurfaceView_13 != 1) {
                if (OplusGLSurfaceView_13 == 2 && TeleSmallPreviewManager.this.f21581b) {
                    TeleSmallPreviewManager.this.f21581b = false;
                    TeleSmallPreviewManager c3431ab = TeleSmallPreviewManager.this;
                    c3431ab.m22984b(false, c3431ab.f21582c, TeleSmallPreviewManager.this.f21583d);
                    return;
                }
                return;
            }
            if (TeleSmallPreviewManager.this.f21580a) {
                TeleSmallPreviewManager.this.f21581b = true;
                TeleSmallPreviewManager c3431ab2 = TeleSmallPreviewManager.this;
                c3431ab2.m22984b(true, c3431ab2.f21582c, TeleSmallPreviewManager.this.f21583d);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m22981a(RelativeLayout.LayoutParams layoutParams, boolean z, boolean z2) {
        if (z) {
            layoutParams.removeRule(9);
            layoutParams.addRule(11);
        } else {
            layoutParams.removeRule(11);
            layoutParams.addRule(9);
        }
        if (z2) {
            layoutParams.removeRule(12);
            layoutParams.addRule(10);
        } else {
            layoutParams.removeRule(10);
            layoutParams.addRule(12);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m23004c() {
        TeleSmallPreviewGLSurfaceView c2770u = this.f21587h;
        if (c2770u != null) {
            c2770u.mo13788a();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m22993a(Image image) {
        HardwareBuffer hardwareBuffer = image.getHardwareBuffer();
        TeleSmallPreviewGLSurfaceView c2770u = this.f21587h;
        if (c2770u != null) {
            return c2770u.m14266a(hardwareBuffer);
        }
        return 0;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m23006d() throws Resources.NotFoundException {
        if (this.f21587h == null) {
            m22991h();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m23008e() {
        TeleSmallPreviewGLSurfaceView c2770u = this.f21587h;
        if (c2770u != null) {
            c2770u.mo13795d();
            this.f21586g.removeView(this.f21587h);
            this.f21587h = null;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m23010f() {
        this.f21584e = null;
        this.f21585f = null;
        this.f21586g = null;
        this.f21587h = null;
        this.f21594o = null;
        IntrinsicsJvm.kt_4 bVar = this.f21589j;
        if (bVar != null) {
            bVar.getLooper().quitSafely();
            this.f21589j = null;
        }
    }
}
