package com.oplus.camera.p172ui.beauty3d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.util.Util;
import java.util.Locale;

/* compiled from: Beauty3DGuideScanUI.java */
/* renamed from: com.oplus.camera.ui.beauty3d.COUIBaseListPopupWindow_12 */
/* loaded from: classes2.dex */
public class Beauty3DGuideScanUI implements View.OnClickListener, View.OnTouchListener {

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean f17758a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f17759b;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Activity f17762e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private ViewGroup f17763f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private ViewGroup f17764g;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f17760c = false;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f17761d = false;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private View f17765h = null;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f17766i = false;

    /* renamed from: OplusGLSurfaceView_15 */
    private View f17767j = null;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f17768k = false;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f17769l = true;

    /* renamed from: OplusGLSurfaceView_6 */
    private View f17770m = null;

    /* renamed from: OplusGLSurfaceView_11 */
    private View f17771n = null;

    /* renamed from: o */
    private ImageView f17772o = null;

    /* renamed from: p */
    private ImageView f17773p = null;

    /* renamed from: q */
    private ImageView f17774q = null;

    /* renamed from: r */
    private TextView f17775r = null;

    /* renamed from: s */
    private FrameAnimation f17776s = null;

    /* renamed from: t */
    private FrameAnimation f17777t = null;

    /* renamed from: u */
    private Beauty3DGuideScanListener f17778u = null;

    /* renamed from: v */
    private Point f17779v = null;

    /* renamed from: w */
    private TextView f17780w = null;

    /* renamed from: x */
    private Button f17781x = null;

    /* renamed from: y */
    private OplusCircleProgressView f17782y = null;

    /* renamed from: z */
    private ImageView f17783z = null;

    /* renamed from: A */
    private ObjectAnimator f17743A = null;

    /* renamed from: B */
    private ObjectAnimator f17744B = null;

    /* renamed from: C */
    private ObjectAnimator f17745C = null;

    /* renamed from: D */
    private ObjectAnimator f17746D = null;

    /* renamed from: E */
    private ObjectAnimator f17747E = null;

    /* renamed from: F */
    private ObjectAnimator f17748F = null;

    /* renamed from: G */
    private ObjectAnimator f17749G = null;

    /* renamed from: H */
    private AnimatorSet f17750H = null;

    /* renamed from: I */
    private boolean f17751I = false;

    /* renamed from: J */
    private TimeInterpolator f17752J = new PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f);

    /* renamed from: K */
    private TimeInterpolator f17753K = new PathInterpolator(0.0f, 0.0f, 0.1f, 1.0f);

    /* renamed from: L */
    private TimeInterpolator f17754L = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);

    /* renamed from: M */
    private int[] f17755M = {R.drawable.beauty3d_scan_00, R.drawable.beauty3d_scan_01, R.drawable.beauty3d_scan_02, R.drawable.beauty3d_scan_03, R.drawable.beauty3d_scan_04, R.drawable.beauty3d_scan_05, R.drawable.beauty3d_scan_06, R.drawable.beauty3d_scan_07, R.drawable.beauty3d_scan_08, R.drawable.beauty3d_scan_09, R.drawable.beauty3d_scan_10, R.drawable.beauty3d_scan_11, R.drawable.beauty3d_scan_12, R.drawable.beauty3d_scan_13, R.drawable.beauty3d_scan_14, R.drawable.beauty3d_scan_15, R.drawable.beauty3d_scan_16, R.drawable.beauty3d_scan_17, R.drawable.beauty3d_scan_18, R.drawable.beauty3d_scan_19, R.drawable.beauty3d_scan_20, R.drawable.beauty3d_scan_21, R.drawable.beauty3d_scan_22, R.drawable.beauty3d_scan_23, R.drawable.beauty3d_scan_24, R.drawable.beauty3d_scan_25, R.drawable.beauty3d_scan_26, R.drawable.beauty3d_scan_27, R.drawable.beauty3d_scan_28, R.drawable.beauty3d_scan_29};

    /* renamed from: N */
    private int[] f17756N = {R.drawable.beauty3d_scan_loading_00, R.drawable.beauty3d_scan_loading_01, R.drawable.beauty3d_scan_loading_02, R.drawable.beauty3d_scan_loading_03, R.drawable.beauty3d_scan_loading_04, R.drawable.beauty3d_scan_loading_05, R.drawable.beauty3d_scan_loading_06, R.drawable.beauty3d_scan_loading_07, R.drawable.beauty3d_scan_loading_08, R.drawable.beauty3d_scan_loading_09, R.drawable.beauty3d_scan_loading_10, R.drawable.beauty3d_scan_loading_11, R.drawable.beauty3d_scan_loading_12, R.drawable.beauty3d_scan_loading_13, R.drawable.beauty3d_scan_loading_14, R.drawable.beauty3d_scan_loading_15, R.drawable.beauty3d_scan_loading_16, R.drawable.beauty3d_scan_loading_17, R.drawable.beauty3d_scan_loading_18, R.drawable.beauty3d_scan_loading_19, R.drawable.beauty3d_scan_loading_20, R.drawable.beauty3d_scan_loading_21, R.drawable.beauty3d_scan_loading_22, R.drawable.beauty3d_scan_loading_23};

    /* renamed from: O */
    private Handler f17757O = new Handler() { // from class: com.oplus.camera.ui.beauty3d.COUIBaseListPopupWindow_12.1
        @Override // android.os.Handler
        public void handleMessage(Message message) throws Resources.NotFoundException {
            int OplusGLSurfaceView_13 = message.what;
            if (OplusGLSurfaceView_13 != 1) {
                if (OplusGLSurfaceView_13 == 2 && Beauty3DGuideScanUI.this.f17782y != null) {
                    Beauty3DGuideScanUI.this.f17782y.m18570a(((Integer) message.obj).intValue());
                    return;
                }
                return;
            }
            Integer num = (Integer) message.obj;
            CameraLog.m12954a("Beauty3DGuideScanUI", "handleMessage, mbNeedUpdate: " + Beauty3DGuideScanUI.this.f17769l);
            if (Beauty3DGuideScanUI.this.f17775r == null || !Beauty3DGuideScanUI.this.f17769l) {
                return;
            }
            String string = Beauty3DGuideScanUI.this.f17762e.getResources().getString(num.intValue());
            Beauty3DGuideScanUI.this.m18712c(num.intValue());
            if (num.intValue() == R.string.beauty3d_wait_scan_complete) {
                Beauty3DGuideScanUI.this.m18679d(num.intValue());
                return;
            }
            Beauty3DGuideScanUI.this.m18702a(string);
            Beauty3DGuideScanUI.this.f17769l = false;
            postDelayed(new Runnable() { // from class: com.oplus.camera.ui.beauty3d.COUIBaseListPopupWindow_12.1.1
                @Override // java.lang.Runnable
                public void run() {
                    Beauty3DGuideScanUI.this.f17769l = true;
                    Beauty3DGuideScanUI.this.f17775r.setText("");
                }
            }, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
        }
    };

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return true;
    }

    public Beauty3DGuideScanUI(Activity activity, ViewGroup viewGroup, ViewGroup viewGroup2) {
        this.f17758a = false;
        this.f17759b = false;
        this.f17762e = null;
        this.f17763f = null;
        this.f17764g = null;
        this.f17762e = activity;
        this.f17763f = viewGroup;
        this.f17764g = viewGroup2;
        this.f17758a = false;
        this.f17759b = false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18700a(Beauty3DGuideScanListener interfaceC3138e) {
        this.f17778u = interfaceC3138e;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m18705a() {
        return this.f17758a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m18710b() {
        View view;
        return this.f17759b && (view = this.f17771n) != null && view.getVisibility() == 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18697a(int OplusGLSurfaceView_13, boolean z, int i2, int i3) {
        if (this.f17762e == null || this.f17763f == null) {
            return;
        }
        m18685i();
        CameraLog.m12954a("Beauty3DGuideScanUI", "showGuideView, mbGuideAdd: " + this.f17758a);
        if (this.f17758a) {
            return;
        }
        ((Button) this.f17770m.findViewById(R.id_renamed.start_face_scan)).setOnClickListener(this);
        TextView textView = (TextView) this.f17770m.findViewById(R.id_renamed.skip);
        textView.setOnClickListener(this);
        this.f17764g.addView(this.f17770m, m18665a(OplusGLSurfaceView_13, z, textView, false, i2, i3));
        this.f17758a = true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private RelativeLayout.LayoutParams m18665a(int OplusGLSurfaceView_13, boolean z, TextView textView, boolean z2, int i2, int i3) {
        View viewFindViewById = this.f17770m.findViewById(R.id_renamed.guide_background_top);
        View viewFindViewById2 = this.f17770m.findViewById(R.id_renamed.guide_background_bottom);
        viewFindViewById.setVisibility(0);
        viewFindViewById2.setVisibility(0);
        TextView textView2 = (TextView) this.f17770m.findViewById(R.id_renamed.beauty3d_face);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (OplusGLSurfaceView_13 == 2 && !z) {
            m18668a(textView2, textView, layoutParams, i2, i3);
        } else if ((OplusGLSurfaceView_13 == 0 && !z) || z) {
            if (z2) {
                m18667a(textView2, textView);
            }
            layoutParams.addRule(12);
            layoutParams.addRule(10);
            layoutParams.bottomMargin = i2;
            layoutParams.topMargin = i3;
        }
        return layoutParams;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m18668a(TextView textView, TextView textView2, RelativeLayout.LayoutParams layoutParams, int OplusGLSurfaceView_13, int i2) {
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) textView.getLayoutParams();
        layoutParams2.topMargin = (int) this.f17762e.getResources().getDimension(R.dimen.beauty3d_guide_margin_top_1_1);
        textView.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) textView2.getLayoutParams();
        layoutParams3.bottomMargin = (int) this.f17762e.getResources().getDimension(R.dimen.beauty3d_guide_margin_bottom_1_1);
        textView2.setLayoutParams(layoutParams3);
        layoutParams.addRule(12);
        layoutParams.addRule(10);
        layoutParams.bottomMargin = OplusGLSurfaceView_13;
        layoutParams.topMargin = i2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18695a(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            View view = this.f17770m;
            if (view == null || !this.f17758a) {
                return;
            }
            this.f17764g.removeView(view);
            CameraLog.m12954a("Beauty3DGuideScanUI", "onViewDismiss, mRootView.removeGuideView.");
            this.f17770m = null;
            this.f17758a = false;
            Beauty3DGuideScanListener interfaceC3138e = this.f17778u;
            if (interfaceC3138e != null) {
                interfaceC3138e.mo18659a();
                return;
            }
            return;
        }
        if (1 == OplusGLSurfaceView_13) {
            View view2 = this.f17771n;
            if (view2 != null && this.f17759b) {
                this.f17763f.removeView(view2);
                CameraLog.m12954a("Beauty3DGuideScanUI", "onViewDismiss, mRootPreviewView.removeScanView.");
                this.f17771n = null;
                this.f17759b = false;
            }
            View view3 = this.f17765h;
            if (view3 != null && this.f17766i) {
                this.f17764g.removeView(view3);
                this.f17766i = false;
                this.f17765h = null;
            }
            View view4 = this.f17767j;
            if (view4 != null && this.f17768k) {
                this.f17764g.removeView(view4);
                this.f17768k = false;
                this.f17767j = null;
            }
            m18693p();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m18711c() {
        CameraLog.m12954a("Beauty3DGuideScanUI", "onScanViewHide");
        m18716f();
        m18717g();
        OplusCircleProgressView oplusCircleProgressView = this.f17782y;
        if (oplusCircleProgressView != null) {
            oplusCircleProgressView.setVisibility(0);
        }
        ObjectAnimator objectAnimator = this.f17749G;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.f17749G.cancel();
        }
        if (this.f17783z != null) {
            CameraLog.m12954a("Beauty3DGuideScanUI", "onScanViewHide, reset scanCircle");
            this.f17783z.setScaleX(1.0f);
            this.f17783z.setScaleY(1.0f);
        }
        View view = this.f17771n;
        if (view != null) {
            view.setVisibility(8);
            ((ImageView) this.f17771n.findViewById(R.id_renamed.scan_foreground_middle)).setImageResource(R.drawable.beauty3d_scan_foreground);
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m18685i() {
        if (this.f17770m == null) {
            this.f17770m = this.f17762e.getLayoutInflater().inflate(R.layout.beauty3d_guide, (ViewGroup) null, false);
        }
        this.f17770m.setOnTouchListener(this);
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m18687j() {
        if (this.f17771n == null) {
            this.f17771n = this.f17762e.getLayoutInflater().inflate(R.layout.beauty3d_scan, (ViewGroup) null, false);
        }
        this.f17771n.setOnTouchListener(this);
        this.f17771n.setAlpha(0.0f);
        this.f17775r = (TextView) this.f17771n.findViewById(R.id_renamed.hint);
        this.f17772o = (ImageView) this.f17771n.findViewById(R.id_renamed.scan_left_arrow);
        this.f17773p = (ImageView) this.f17771n.findViewById(R.id_renamed.scan_right_arrow);
        this.f17774q = (ImageView) this.f17771n.findViewById(R.id_renamed.scan_up_arrow);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m18714d() {
        m18695a(0);
        m18695a(1);
        this.f17762e = null;
        this.f17770m = null;
        this.f17771n = null;
        this.f17758a = false;
        this.f17759b = false;
        this.f17760c = false;
        this.f17778u = null;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private void m18688k() {
        this.f17743A = ObjectAnimator.ofFloat(this.f17771n, "alpha", 0.0f, 1.0f);
        this.f17743A.setInterpolator(this.f17752J);
        this.f17743A.setDuration(320L);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18701a(Integer num) {
        Handler handler = this.f17757O;
        if (handler == null || !this.f17760c) {
            return;
        }
        handler.removeMessages(1);
        Message messageObtain = Message.obtain();
        messageObtain.obj = num;
        messageObtain.what = 1;
        this.f17757O.sendMessage(messageObtain);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m18708b(int OplusGLSurfaceView_13, boolean z, int i2, int i3) {
        if (this.f17762e == null || this.f17763f == null) {
            return;
        }
        m18687j();
        m18688k();
        CameraLog.m12954a("Beauty3DGuideScanUI", "showBeauty3DScanView, mbScanAdd: " + this.f17759b);
        this.f17771n.setVisibility(0);
        if (!this.f17759b) {
            this.f17783z = (ImageView) this.f17771n.findViewById(R.id_renamed.scan_circle);
            if (this.f17776s == null) {
                this.f17776s = new FrameAnimation(this.f17783z, this.f17755M, 33, true);
            }
            this.f17782y = (OplusCircleProgressView) this.f17771n.findViewById(R.id_renamed.circle_progress);
            ImageView imageView = (ImageView) this.f17771n.findViewById(R.id_renamed.scan_foreground_middle);
            View viewFindViewById = this.f17771n.findViewById(R.id_renamed.scan_foreground_top);
            View viewFindViewById2 = this.f17771n.findViewById(R.id_renamed.scan_foreground_bottom);
            if (OplusGLSurfaceView_13 == 2 && !z) {
                viewFindViewById.setVisibility(8);
                viewFindViewById2.setVisibility(8);
            } else if (OplusGLSurfaceView_13 == 0 && !z) {
                viewFindViewById.setVisibility(0);
                viewFindViewById2.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f17783z.getLayoutParams();
                int dimension = (int) this.f17762e.getResources().getDimension(R.dimen.beauty3d_scan_imageview_margin_top);
                layoutParams.addRule(10);
                layoutParams.topMargin = dimension;
                this.f17783z.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
                layoutParams2.addRule(10);
                layoutParams2.topMargin = dimension;
                imageView.setLayoutParams(layoutParams2);
            } else if (z) {
                this.f17762e.findViewById(R.id_renamed.beauty3d_setting).setVisibility(0);
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f17771n.getLayoutParams();
                layoutParams3.addRule(12);
                layoutParams3.bottomMargin = i2;
                this.f17771n.setLayoutParams(layoutParams3);
                viewFindViewById.setVisibility(0);
                viewFindViewById2.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f17783z.getLayoutParams();
                int dimension2 = (int) this.f17762e.getResources().getDimension(R.dimen.beauty3d_scan_imageview_margin_top);
                layoutParams4.addRule(10);
                layoutParams4.topMargin = dimension2;
                this.f17783z.setLayoutParams(layoutParams4);
                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
                layoutParams5.addRule(10);
                layoutParams5.topMargin = dimension2;
                imageView.setLayoutParams(layoutParams5);
            }
            this.f17771n.requestLayout();
            this.f17779v = this.f17782y.getCenterPoint();
            this.f17763f.addView(this.f17771n, new ViewGroup.LayoutParams(-1, -1));
        }
        m18707b(OplusGLSurfaceView_13, z);
        m18703a(z);
        this.f17759b = true;
        if (this.f17743A.isStarted()) {
            this.f17743A.cancel();
        }
        this.f17743A.start();
        this.f17760c = false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18696a(int OplusGLSurfaceView_13, boolean z) {
        m18688k();
        m18703a(z);
        m18707b(OplusGLSurfaceView_13, z);
        m18689l();
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private void m18689l() {
        this.f17760c = true;
        View view = this.f17771n;
        if (view != null && view.getVisibility() != 0) {
            this.f17771n.setVisibility(0);
        }
        FrameAnimation c3141h = this.f17776s;
        if (c3141h != null) {
            if (!c3141h.m18762b()) {
                this.f17776s.m18761a();
            }
            this.f17776s.m18764d();
        }
        Button button = this.f17781x;
        if (button != null) {
            button.setVisibility(4);
            this.f17781x.setClickable(false);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18704a(boolean z, final boolean z2) {
        if (this.f17761d) {
            CameraLog.m12954a("Beauty3DGuideScanUI", "stop3DScan, mbExiting: " + this.f17761d + " return");
            return;
        }
        this.f17761d = true;
        this.f17760c = false;
        Handler handler = this.f17757O;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f17769l = true;
        }
        if (z) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f17771n, "alpha", 1.0f, 0.0f);
            objectAnimatorOfFloat.setInterpolator(this.f17752J);
            objectAnimatorOfFloat.setDuration(320L);
            objectAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.oplus.camera.ui.beauty3d.COUIBaseListPopupWindow_12.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Beauty3DGuideScanUI.this.m18690m();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    CameraLog.m12954a("Beauty3DGuideScanUI", "stop3DScan, onAnimationEnd");
                    Beauty3DGuideScanUI.this.f17743A = null;
                    Beauty3DGuideScanUI.this.m18694q();
                    if (z2) {
                        Beauty3DGuideScanUI.this.m18695a(1);
                    } else {
                        Beauty3DGuideScanUI.this.m18711c();
                    }
                    if (Beauty3DGuideScanUI.this.f17778u != null) {
                        Beauty3DGuideScanUI.this.f17778u.mo18661a(true);
                    }
                    Beauty3DGuideScanUI.this.f17761d = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    CameraLog.m12954a("Beauty3DGuideScanUI", "stop3DScan, onAnimationCancel");
                }
            });
            objectAnimatorOfFloat.start();
            return;
        }
        m18690m();
        this.f17743A = null;
        m18694q();
        if (z2) {
            m18695a(1);
        } else {
            m18711c();
        }
        Beauty3DGuideScanListener interfaceC3138e = this.f17778u;
        if (interfaceC3138e != null) {
            interfaceC3138e.mo18661a(false);
        }
        this.f17761d = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_6 */
    public void m18690m() {
        ObjectAnimator objectAnimator = this.f17743A;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.f17743A.cancel();
        }
        ObjectAnimator objectAnimator2 = this.f17744B;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
            this.f17744B = null;
        }
        FrameAnimation c3141h = this.f17776s;
        if (c3141h != null) {
            c3141h.m18761a();
        }
        FrameAnimation c3141h2 = this.f17777t;
        if (c3141h2 != null) {
            c3141h2.m18761a();
        }
        AnimatorSet animatorSet = this.f17750H;
        if (animatorSet == null || !animatorSet.isRunning()) {
            return;
        }
        this.f17750H.cancel();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id_renamed.scan_cancel /* 2131297031 */:
                m18704a(true, true);
                break;
            case R.id_renamed.skip /* 2131297085 */:
                m18695a(0);
                break;
            case R.id_renamed.start_face_scan /* 2131297112 */:
                m18695a(0);
                CameraLog.m12954a("Beauty3DGuideScanUI", "onClick, startScan, disMiss Guide.");
                Beauty3DGuideScanListener interfaceC3138e = this.f17778u;
                if (interfaceC3138e != null) {
                    interfaceC3138e.mo18662b();
                    break;
                }
                break;
            case R.id_renamed.start_scan /* 2131297113 */:
                m18689l();
                Beauty3DGuideScanListener interfaceC3138e2 = this.f17778u;
                if (interfaceC3138e2 != null) {
                    interfaceC3138e2.mo18660a("com.oplus.beauty3d.scan.state", new int[]{1});
                    break;
                }
                break;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m18715e() {
        m18695a(0);
        m18704a(false, false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18703a(boolean z) {
        m18691n();
        this.f17765h.setVisibility(0);
        this.f17765h.setEnabled(true);
        if (z) {
            m18676c(z);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m18676c(boolean z) {
        View view = this.f17765h;
        if (view != null) {
            if (z) {
                view.setBackgroundColor(this.f17762e.getResources().getColor(R.color.beauty3d_scan_background));
            } else {
                view.setBackgroundColor(this.f17762e.getResources().getColor(R.color.background_color));
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private void m18691n() {
        if (this.f17765h == null) {
            ViewGroup viewGroup = (ViewGroup) this.f17762e.findViewById(R.id_renamed.camera);
            this.f17765h = this.f17762e.getLayoutInflater().inflate(R.layout.beauty3d_scan_setting, (ViewGroup) null, false);
            this.f17765h.setBackgroundColor(this.f17762e.getResources().getColor(R.color.background_color));
            this.f17765h.setOnTouchListener(this);
            if (this.f17766i) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(10);
            layoutParams.height = (int) this.f17762e.getResources().getDimension(R.dimen.beauty3d_scan_setting_height);
            layoutParams.topMargin = 0;
            viewGroup.addView(this.f17765h, layoutParams);
            this.f17766i = true;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m18716f() {
        View view = this.f17765h;
        if (view != null) {
            view.setVisibility(8);
            this.f17765h.setEnabled(false);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m18707b(int OplusGLSurfaceView_13, boolean z) {
        m18692o();
        this.f17780w = (TextView) this.f17767j.findViewById(R.id_renamed.scan_cancel);
        this.f17781x = (Button) this.f17767j.findViewById(R.id_renamed.start_scan);
        if (Util.m24338aa()) {
            m18666a(this.f17780w);
        }
        this.f17767j.setVisibility(0);
        this.f17767j.setEnabled(true);
        this.f17767j.setOnTouchListener(this);
        if (z) {
            m18675c(this.f17762e.getColor(R.color.beauty3d_scan_background), false);
        }
        this.f17780w.setEnabled(true);
        this.f17780w.setClickable(true);
        this.f17780w.setOnClickListener(this);
        this.f17781x.setVisibility(0);
        this.f17781x.setEnabled(true);
        this.f17781x.setClickable(true);
        this.f17781x.setOnClickListener(this);
    }

    /* renamed from: o */
    private void m18692o() {
        if (this.f17767j == null) {
            this.f17767j = this.f17762e.getLayoutInflater().inflate(R.layout.beauty3d_scan_bottom, (ViewGroup) null, false);
            this.f17767j.setBackgroundColor(this.f17762e.getResources().getColor(R.color.background_color));
            ViewGroup viewGroup = (ViewGroup) this.f17762e.findViewById(R.id_renamed.camera);
            if (this.f17768k) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            layoutParams.bottomMargin = 0;
            layoutParams.height = Util.m24187O();
            viewGroup.addView(this.f17767j, layoutParams);
            this.f17768k = true;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m18717g() {
        View view = this.f17767j;
        if (view != null) {
            view.setVisibility(8);
            this.f17767j.setEnabled(false);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m18675c(int OplusGLSurfaceView_13, boolean z) {
        CameraLog.m12954a("Beauty3DGuideScanUI", "updateBeauty3DControlPanelBgColor, color: " + OplusGLSurfaceView_13 + ", needAnimation: " + z);
        View view = this.f17767j;
        if (view == null) {
            return;
        }
        if (z) {
            Util.m24269a(view, OplusGLSurfaceView_13, 200, (Interpolator) null, (Animator.AnimatorListener) null);
        } else {
            view.setBackgroundColor(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m18713c(int OplusGLSurfaceView_13, boolean z, int i2, int i3) {
        View view;
        if (!this.f17758a || (view = this.f17770m) == null) {
            return false;
        }
        this.f17770m.setLayoutParams(m18665a(OplusGLSurfaceView_13, z, (TextView) view.findViewById(R.id_renamed.skip), true, i2, i3));
        this.f17770m.requestLayout();
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m18667a(TextView textView, TextView textView2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
        layoutParams.topMargin = (int) this.f17762e.getResources().getDimension(R.dimen.beauty3d_guide_margin_top);
        textView.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) textView2.getLayoutParams();
        layoutParams2.bottomMargin = (int) this.f17762e.getResources().getDimension(R.dimen.beauty3d_guide_textview_margin_bottom);
        textView2.setLayoutParams(layoutParams2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m18706b(int OplusGLSurfaceView_13) {
        Handler handler = this.f17757O;
        if (handler == null || !this.f17760c) {
            return;
        }
        handler.removeMessages(2);
        Message messageObtain = Message.obtain();
        messageObtain.obj = Integer.valueOf(OplusGLSurfaceView_13);
        messageObtain.what = 2;
        this.f17757O.sendMessage(messageObtain);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m18666a(TextView textView) {
        if (textView != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.topMargin = this.f17762e.getResources().getDimensionPixelSize(R.dimen.control_panel_margin_top);
            textView.setLayoutParams(layoutParams);
            textView.requestLayout();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m18709b(boolean z) {
        View view = this.f17767j;
        if (view != null) {
            view.setEnabled(z);
            this.f17767j.setClickable(z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18702a(String str) {
        if (this.f17775r == null) {
            this.f17775r = (TextView) this.f17771n.findViewById(R.id_renamed.hint);
        }
        this.f17775r.setText("");
        if (this.f17744B == null) {
            if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
                float COUIBaseListPopupWindow_12 = 30;
                float f2 = -30;
                this.f17744B = ObjectAnimator.ofFloat(this.f17775r, "translationX", 0.0f, COUIBaseListPopupWindow_12, f2, COUIBaseListPopupWindow_12, f2, 0.0f);
            } else {
                float f3 = -30;
                float f4 = 30;
                this.f17744B = ObjectAnimator.ofFloat(this.f17775r, "translationX", 0.0f, f3, f4, f3, f4, 0.0f);
            }
        }
        if (!TextUtils.isEmpty(str)) {
            this.f17775r.setText(str);
        }
        this.f17744B.setDuration(300L);
        if (this.f17744B.isRunning()) {
            this.f17744B.cancel();
        }
        this.f17744B.start();
    }

    /* renamed from: p */
    private void m18693p() {
        FrameAnimation c3141h = this.f17776s;
        if (c3141h != null) {
            c3141h.m18761a();
        }
        this.f17776s = null;
        FrameAnimation c3141h2 = this.f17777t;
        if (c3141h2 != null) {
            c3141h2.m18761a();
        }
        this.f17777t = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public void m18694q() {
        ImageView imageView = this.f17772o;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
        ImageView imageView2 = this.f17773p;
        if (imageView2 != null) {
            imageView2.setVisibility(4);
        }
        ImageView imageView3 = this.f17774q;
        if (imageView3 != null) {
            imageView3.setVisibility(4);
        }
        ObjectAnimator objectAnimator = this.f17745C;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.f17745C.cancel();
        }
        ObjectAnimator objectAnimator2 = this.f17746D;
        if (objectAnimator2 != null && objectAnimator2.isRunning()) {
            this.f17746D.cancel();
        }
        ObjectAnimator objectAnimator3 = this.f17747E;
        if (objectAnimator3 != null && objectAnimator3.isRunning()) {
            this.f17747E.cancel();
        }
        ObjectAnimator objectAnimator4 = this.f17748F;
        if (objectAnimator4 == null || !objectAnimator4.isRunning()) {
            return;
        }
        this.f17748F.cancel();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m18712c(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == R.string.beauty3d_turn_to_left || OplusGLSurfaceView_13 == R.string.beauty3d_continue_turn_to_left) {
            CameraLog.m12954a("Beauty3DGuideScanUI", "updateArrow, turn left");
            m18699a(this.f17772o, "translationX");
            m18698a(this.f17747E, this.f17773p);
            m18698a(this.f17748F, this.f17774q);
            return;
        }
        if (OplusGLSurfaceView_13 == R.string.beauty3d_turn_to_right || OplusGLSurfaceView_13 == R.string.beauty3d_continue_turn_to_right) {
            CameraLog.m12954a("Beauty3DGuideScanUI", "updateArrow, turn right");
            m18699a(this.f17773p, "translationX");
            m18698a(this.f17746D, this.f17772o);
            m18698a(this.f17748F, this.f17774q);
            return;
        }
        if (OplusGLSurfaceView_13 == R.string.beauty3d_turn_to_up) {
            CameraLog.m12954a("Beauty3DGuideScanUI", "updateArrow, turn up");
            m18699a(this.f17774q, "translationY");
            m18698a(this.f17747E, this.f17773p);
            m18698a(this.f17746D, this.f17772o);
            return;
        }
        ObjectAnimator objectAnimator = this.f17745C;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.f17745C.cancel();
        }
        m18698a(this.f17747E, this.f17773p);
        m18698a(this.f17746D, this.f17772o);
        m18698a(this.f17748F, this.f17774q);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18699a(View view, String str) {
        PropertyValuesHolder propertyValuesHolderOfFloat;
        if (view == null || view.getVisibility() == 0) {
            return;
        }
        ObjectAnimator objectAnimator = this.f17745C;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.f17745C.cancel();
        }
        CameraLog.m12954a("Beauty3DGuideScanUI", "playStartArrowAnim");
        if (view.getId() == R.id_renamed.scan_right_arrow) {
            propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, 0.0f, 100);
        } else {
            propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, 0.0f, -100);
        }
        this.f17745C = ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolderOfFloat, PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f, 1.0f, 0.0f));
        this.f17745C.setInterpolator(this.f17753K);
        this.f17745C.setDuration(1200L);
        this.f17745C.setRepeatCount(-1);
        this.f17745C.setRepeatMode(1);
        this.f17745C.start();
        view.setVisibility(0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m18698a(ObjectAnimator objectAnimator, final View view) {
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        if (objectAnimator != null && objectAnimator.isRunning()) {
            CameraLog.m12954a("Beauty3DGuideScanUI", "playFadeOutArrowAnim, animator is Running");
            return;
        }
        CameraLog.m12954a("Beauty3DGuideScanUI", "playFadeOutArrowAnim");
        if (objectAnimator == null) {
            objectAnimator = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
            objectAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.beauty3d.COUIBaseListPopupWindow_12.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    view.setVisibility(4);
                    view.setAlpha(1.0f);
                }
            });
        }
        objectAnimator.setInterpolator(this.f17752J);
        objectAnimator.setDuration(200L);
        objectAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m18679d(int OplusGLSurfaceView_13) {
        ImageView imageView;
        if (this.f17777t == null && (imageView = this.f17783z) != null) {
            this.f17777t = new FrameAnimation(imageView, this.f17756N, 41, true);
        }
        FrameAnimation c3141h = this.f17776s;
        if (c3141h != null && !c3141h.m18762b()) {
            this.f17776s.m18761a();
        }
        FrameAnimation c3141h2 = this.f17777t;
        if (c3141h2 == null || c3141h2.m18763c()) {
            return;
        }
        TextView textView = this.f17775r;
        if (textView != null) {
            textView.setText(OplusGLSurfaceView_13);
        }
        CameraLog.m12954a("Beauty3DGuideScanUI", "startScanLoadAnim, mScanLoadAnimation start");
        this.f17777t.m18764d();
        this.f17782y.setVisibility(4);
        View view = this.f17771n;
        if (view != null) {
            ((ImageView) view.findViewById(R.id_renamed.scan_foreground_middle)).setImageResource(R.drawable.beauty3d_sacn_load_foreground);
        }
        PropertyValuesHolder propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat("scaleX", 1.0f, 0.75f);
        PropertyValuesHolder propertyValuesHolderOfFloat2 = PropertyValuesHolder.ofFloat("scaleY", 1.0f, 0.75f);
        ObjectAnimator objectAnimator = this.f17749G;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.f17749G.cancel();
        }
        this.f17749G = ObjectAnimator.ofPropertyValuesHolder(this.f17783z, propertyValuesHolderOfFloat, propertyValuesHolderOfFloat2);
        this.f17749G.setDuration(500L);
        this.f17749G.setInterpolator(this.f17754L);
        CameraLog.m12954a("Beauty3DGuideScanUI", "startScanLoadAnim, scaleAnim start");
        this.f17749G.start();
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m18718h() {
        CameraLog.m12954a("Beauty3DGuideScanUI", "scanComplete");
        AnimatorSet animatorSet = this.f17750H;
        if (animatorSet != null && animatorSet.isRunning()) {
            CameraLog.m12954a("Beauty3DGuideScanUI", "scanComplete,isRunning return");
            return;
        }
        this.f17750H = new AnimatorSet();
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f17783z, PropertyValuesHolder.ofFloat("scaleX", 0.0f, 2.0f), PropertyValuesHolder.ofFloat("scaleY", 0.0f, 2.0f));
        objectAnimatorOfPropertyValuesHolder.setInterpolator(this.f17754L);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f17783z, "alpha", 1.0f, 0.0f);
        this.f17750H.setDuration(500L);
        this.f17750H.playTogether(objectAnimatorOfPropertyValuesHolder, objectAnimatorOfFloat);
        this.f17750H.addListener(new Animator.AnimatorListener() { // from class: com.oplus.camera.ui.beauty3d.COUIBaseListPopupWindow_12.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Beauty3DGuideScanUI.this.f17751I = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                CameraLog.m12954a("Beauty3DGuideScanUI", "scanComplete, onAnimationEnd, mbScanCompleteCancel: " + Beauty3DGuideScanUI.this.f17751I);
                if (Beauty3DGuideScanUI.this.f17757O == null || Beauty3DGuideScanUI.this.f17751I) {
                    return;
                }
                Beauty3DGuideScanUI.this.f17757O.post(new Runnable() { // from class: com.oplus.camera.ui.beauty3d.COUIBaseListPopupWindow_12.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Beauty3DGuideScanUI.this.f17783z.setAlpha(1.0f);
                        if (Beauty3DGuideScanUI.this.f17778u != null) {
                            Beauty3DGuideScanUI.this.f17778u.mo18663c();
                            Beauty3DGuideScanUI.this.m18704a(false, true);
                        }
                    }
                });
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Beauty3DGuideScanUI.this.f17751I = true;
            }
        });
        this.f17750H.start();
    }
}
