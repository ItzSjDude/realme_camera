package com.oplus.camera.p172ui.preview;

import android.animation.Animator;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.oplus.camera.CameraLog;
import com.oplus.camera.ComboPreferences;
import com.oplus.camera.R;
import com.oplus.camera.p137b.SimpleAnimatorListener;
import com.oplus.camera.p172ui.OrientationAnimation;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.preview.AISceneUI;
import com.oplus.camera.util.Util;

/* compiled from: PIAISceneUI.java */
/* renamed from: com.oplus.camera.ui.preview.u */
/* loaded from: classes2.dex */
public class PIAISceneUI extends AISceneUI {

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f22419h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f22420i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f22421j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f22422k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f22423l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f22424m;

    /* renamed from: r */
    private int f22429r;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private RelativeLayout f22415d = null;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private AISceneView f22416e = null;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private PlatformImplementations.kt_3 f22417f = null;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private AISceneUI.PlatformImplementations.kt_3 f22418g = null;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f22425n = 0;

    /* renamed from: o */
    private int f22426o = 0;

    /* renamed from: p */
    private int f22427p = 67108863;

    /* renamed from: q */
    private int f22428q = 0;

    /* renamed from: s */
    private int f22430s = 0;

    /* renamed from: t */
    private int f22431t = 0;

    /* renamed from: u */
    private int f22432u = 0;

    /* renamed from: v */
    private OrientationAnimation f22433v = null;

    /* renamed from: w */
    private View.OnLayoutChangeListener f22434w = null;

    /* renamed from: x */
    private boolean f22435x = false;

    /* renamed from: y */
    private OrientationAnimation.PlatformImplementations.kt_3 f22436y = new OrientationAnimation.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.preview.u.1
        @Override // com.oplus.camera.p172ui.OrientationAnimation.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo18007a(int OplusGLSurfaceView_13) {
            PIAISceneUI.this.f22425n = OplusGLSurfaceView_13;
            PIAISceneUI.this.mo22227f(OplusGLSurfaceView_13);
        }

        @Override // com.oplus.camera.p172ui.OrientationAnimation.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo18008a() {
            return PIAISceneUI.this.f22415d != null && PIAISceneUI.this.f22415d.getVisibility() == 0;
        }

        @Override // com.oplus.camera.p172ui.OrientationAnimation.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo18006a(float COUIBaseListPopupWindow_12) {
            if (PIAISceneUI.this.f22415d != null) {
                PIAISceneUI.this.f22415d.setAlpha(COUIBaseListPopupWindow_12);
            }
        }
    };

    /* renamed from: z */
    private Handler f22437z = new Handler(Looper.getMainLooper()) { // from class: com.oplus.camera.ui.preview.u.4
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int OplusGLSurfaceView_13 = message.what;
            if (OplusGLSurfaceView_13 == 1) {
                CameraLog.m12962c("PIAISceneUI", "handleMessage: 1");
                if (PIAISceneUI.this.f22426o == 0) {
                    PIAISceneUI.this.f22437z.removeMessages(3000);
                    PIAISceneUI.this.mo22230h();
                    return;
                }
                return;
            }
            if (OplusGLSurfaceView_13 != 2) {
                return;
            }
            CameraLog.m12962c("PIAISceneUI", "handleMessage: 2");
            if (PIAISceneUI.this.f22426o != 0) {
                PIAISceneUI.this.m23877q();
            }
        }
    };

    /* renamed from: PlatformImplementations.kt_3 */
    private int m23861a(int OplusGLSurfaceView_13, int i2, boolean z) {
        return z ? (1 << (OplusGLSurfaceView_13 - 1)) | i2 : (~(1 << (OplusGLSurfaceView_13 - 1))) & i2;
    }

    public PIAISceneUI(Activity activity, ViewGroup viewGroup, ComboPreferences comboPreferences) {
        this.f22419h = 0;
        this.f22420i = 0;
        this.f22421j = 0;
        this.f22422k = 0;
        this.f22423l = 0;
        this.f22424m = 0;
        this.f22429r = 0;
        this.f20892a = activity;
        this.f20893b = viewGroup;
        this.f20894c = comboPreferences;
        this.f22419h = this.f20892a.getResources().getDimensionPixelSize(R.dimen.pi_ai_scene_margin_top);
        this.f22420i = this.f20892a.getResources().getDimensionPixelSize(R.dimen.pi_ai_scene_margin_start);
        this.f22421j = (int) (Util.getScreenWidth() * 1.3333333333333333d);
        this.f22422k = (int) ((Util.getScreenWidth() / 2.0f) * 1.3333333333333333d);
        this.f22423l = this.f20892a.getResources().getDimensionPixelOffset(R.dimen.fold_split_hint_view_margin_top_offset_rotate);
        this.f22424m = Util.getScreenWidth();
        this.f22429r = this.f20892a.getResources().getDimensionPixelSize(R.dimen.toast_margin_top);
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private void m23872l() {
        if (this.f22415d != null || this.f20893b == null) {
            return;
        }
        this.f20892a.getLayoutInflater().inflate(R.layout.pi_ai_scene_layout, this.f20893b);
        this.f22415d = (RelativeLayout) this.f20892a.findViewById(R.id_renamed.ai_scene_layout);
        this.f22416e = (AISceneView) this.f22415d.findViewById(R.id_renamed.ai_scene_text);
    }

    @Override // com.oplus.camera.p172ui.preview.AISceneUI
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22215a(boolean z) {
        m23874n();
        if (this.f22415d != null && this.f20893b != null) {
            this.f20893b.removeView(this.f22415d);
            this.f22415d = null;
            this.f22416e = null;
        }
        this.f22426o = 0;
    }

    @Override // com.oplus.camera.p172ui.preview.AISceneUI
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22213a(View.OnLayoutChangeListener onLayoutChangeListener) {
        this.f22434w = onLayoutChangeListener;
        m23873m();
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private void m23873m() {
        View.OnLayoutChangeListener onLayoutChangeListener;
        RelativeLayout relativeLayout = this.f22415d;
        if (relativeLayout == null || (onLayoutChangeListener = this.f22434w) == null) {
            return;
        }
        relativeLayout.addOnLayoutChangeListener(onLayoutChangeListener);
    }

    @Override // com.oplus.camera.p172ui.preview.AISceneUI
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo22218b(int OplusGLSurfaceView_13) {
        this.f22426o = OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.p172ui.preview.AISceneUI
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22209a(int OplusGLSurfaceView_13, int i2, int i3) {
        this.f22426o = OplusGLSurfaceView_13;
        mo22229g(i2);
        if (m23870i(OplusGLSurfaceView_13)) {
            if (mo22232i()) {
                mo22230h();
                return;
            }
            return;
        }
        if (this.f22426o != 0) {
            m23872l();
        }
        if (this.f22415d == null) {
            return;
        }
        PlatformImplementations.kt_3 aVarM23864a = m23864a(OplusGLSurfaceView_13, i3);
        if (-1 == aVarM23864a.m23879a()) {
            mo22230h();
            return;
        }
        this.f22416e.setText(aVarM23864a.m23879a());
        mo22227f(i2);
        m23874n();
        m23877q();
    }

    @Override // com.oplus.camera.p172ui.preview.AISceneUI
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22214a(AISceneUI.PlatformImplementations.kt_3 aVar) {
        this.f22418g = aVar;
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private void m23874n() {
        AISceneView aISceneView = this.f22416e;
        if (aISceneView != null) {
            aISceneView.m22065a();
        }
    }

    @Override // com.oplus.camera.p172ui.preview.AISceneUI
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo22219b(int OplusGLSurfaceView_13, boolean z) {
        this.f22427p = m23861a(OplusGLSurfaceView_13, this.f22427p, z);
    }

    @Override // com.oplus.camera.p172ui.preview.AISceneUI
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo22220c(int OplusGLSurfaceView_13) {
        RelativeLayout relativeLayout = this.f22415d;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean m23870i(int OplusGLSurfaceView_13) {
        return ((this.f22427p >> (OplusGLSurfaceView_13 - 1)) & 1) == 0;
    }

    @Override // com.oplus.camera.p172ui.preview.AISceneUI
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo22222d() {
        this.f20894c.edit().remove("oplus.camera.ai_scene_enable_list").apply();
    }

    @Override // com.oplus.camera.p172ui.preview.AISceneUI
    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean mo22225e(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 == 0 ? (this.f20894c == null || this.f20892a == null || !"on".equals(this.f20894c.getString(CameraUIInterface.KEY_PI_AI, this.f20892a.getString(R.string.camera_pi_ai_default_value)))) ? false : true : ((mo22224e() >> (OplusGLSurfaceView_13 - 1)) & 1) > 0;
    }

    @Override // com.oplus.camera.p172ui.preview.AISceneUI
    /* renamed from: COUIBaseListPopupWindow_8 */
    public int mo22224e() {
        return this.f22427p & this.f20894c.getInt("oplus.camera.ai_scene_enable_list", 67108863);
    }

    @Override // com.oplus.camera.p172ui.preview.AISceneUI
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void mo22230h() {
        Handler handler = this.f22437z;
        if (handler != null && handler.hasMessages(2)) {
            this.f22437z.removeMessages(2);
        }
        m23874n();
        m23878r();
    }

    /* renamed from: o */
    private void m23875o() {
        this.f22433v = new OrientationAnimation(1.0f, 0.0f);
        this.f22433v.setDuration(300L);
        this.f22433v.m23903a(this.f22436y);
    }

    @Override // com.oplus.camera.p172ui.preview.AISceneUI
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22210a(int OplusGLSurfaceView_13, int i2, int i3, boolean z) {
        if (this.f22430s == OplusGLSurfaceView_13 && this.f22431t == i2 && this.f22424m == i3 && this.f22435x == z) {
            return;
        }
        this.f22430s = OplusGLSurfaceView_13;
        this.f22431t = i2;
        this.f22424m = i3;
        this.f22435x = z;
        mo22227f(this.f22425n);
    }

    @Override // com.oplus.camera.p172ui.preview.AISceneUI
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo22223d(int OplusGLSurfaceView_13) {
        this.f22432u = OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.p172ui.preview.AISceneUI
    /* renamed from: COUIBaseListPopupWindow_12 */
    protected void mo22227f(int OplusGLSurfaceView_13) {
        if (this.f22415d == null || this.f22416e == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE);
        this.f22415d.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        int measuredWidth = this.f22415d.getMeasuredWidth();
        int measuredHeight = this.f22415d.getMeasuredHeight();
        this.f22415d.layout(0, 0, measuredWidth, measuredHeight);
        if (OplusGLSurfaceView_13 == 90) {
            layoutParams.addRule(9);
            layoutParams.leftMargin = this.f22420i - ((measuredWidth - measuredHeight) / 2);
            int iM24186N = ((this.f22421j - measuredHeight) / 2) + Util.m24186N();
            int i2 = this.f22430s;
            layoutParams.topMargin = (iM24186N + i2) - this.f22431t;
            if (3 == this.f22428q) {
                layoutParams.topMargin = ((this.f22422k - measuredHeight) / 2) + i2 + this.f22423l;
            }
        } else if (OplusGLSurfaceView_13 == 270) {
            layoutParams.addRule(11);
            layoutParams.rightMargin = this.f22420i - ((measuredWidth - measuredHeight) / 2);
            int iM24186N2 = ((this.f22421j - measuredHeight) / 2) + Util.m24186N();
            int i3 = this.f22430s;
            layoutParams.topMargin = (iM24186N2 - i3) - this.f22431t;
            if (3 == this.f22428q) {
                layoutParams.topMargin = (((this.f22422k - measuredHeight) / 2) - i3) + this.f22423l;
            }
        } else if (this.f22435x) {
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            layoutParams.leftMargin = ((m23876p() - measuredWidth) / 2) - this.f22430s;
            layoutParams.bottomMargin = this.f20892a.getResources().getDimensionPixelSize(R.dimen.low_rack_mode_camera_screen_hint_view_margin_bottom);
        } else {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            layoutParams.leftMargin = ((m23876p() - measuredWidth) / 2) - this.f22430s;
            layoutParams.topMargin = (((this.f22419h + Util.m24186N()) + this.f22429r) - this.f22431t) + this.f22432u;
        }
        this.f22416e.setZ(999.0f);
        this.f22415d.setLayoutParams(layoutParams);
        this.f22415d.setRotation(-this.f22425n);
    }

    /* renamed from: p */
    private int m23876p() {
        if (3 == this.f22428q) {
            return this.f22424m / 2;
        }
        return this.f22424m;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private PlatformImplementations.kt_3 m23864a(int OplusGLSurfaceView_13, int i2) {
        if (this.f22417f == null) {
            this.f22417f = new PlatformImplementations.kt_3();
        }
        switch (OplusGLSurfaceView_13) {
            case 1:
                this.f22417f.m23880a(R.string.camera_ai_scn_beach);
                break;
            case 2:
                this.f22417f.m23880a(R.string.camera_ai_scn_bluesky);
                break;
            case 3:
                this.f22417f.m23880a(R.string.camera_ai_scn_cat);
                break;
            case 4:
                this.f22417f.m23880a(R.string.camera_ai_scn_text);
                break;
            case 5:
                this.f22417f.m23880a(R.string.camera_ai_scn_dog);
                break;
            case 6:
                this.f22417f.m23880a(R.string.camera_ai_scn_firework);
                break;
            case 7:
                this.f22417f.m23880a(R.string.camera_ai_scn_gourmet);
                break;
            case 8:
                this.f22417f.m23880a(R.string.camera_ai_scn_grass);
                break;
            case 9:
                this.f22417f.m23880a(R.string.camera_ai_scn_indoor);
                break;
            case 10:
                this.f22417f.m23880a(R.string.camera_ai_scn_infant);
                break;
            case 11:
                this.f22417f.m23880a(R.string.camera_ai_scn_landscape);
                break;
            case 12:
                CameraLog.m12959b("PIAISceneUI", "getDataByAIScene, subCode: " + i2);
                this.f22417f.m23880a(R.string.camera_ai_scn_night);
                break;
            case 13:
                this.f22417f.m23880a(R.string.camera_ai_scn_snow);
                break;
            case 14:
                this.f22417f.m23880a(R.string.camera_ai_scn_spotlight);
                break;
            case 15:
                this.f22417f.m23880a(R.string.camera_ai_scn_sunset);
                break;
            case 16:
                this.f22417f.m23880a(R.string.camera_ai_scn_portrait);
                break;
            case 17:
                this.f22417f.m23880a(R.string.camera_ai_scn_multi_portrait);
                break;
            case 18:
                this.f22417f.m23880a(R.string.camera_ai_scn_microspur);
                break;
            case 19:
                this.f22417f.m23880a(R.string.camera_ai_scn_backlight);
                break;
            case 20:
                this.f22417f.m23880a(R.string.camera_ai_scn_purecolor);
                break;
            case 21:
                this.f22417f.m23880a(R.string.camera_ai_scn_moire);
                break;
            case 22:
                this.f22417f.m23880a(R.string.camera_ai_scn_flower);
                break;
            case 23:
                this.f22417f.m23880a(R.string.camera_ai_scn_plant);
                break;
            case 24:
                this.f22417f.m23880a(R.string.camera_ai_scn_birds);
                break;
            case 25:
                this.f22417f.m23880a(R.string.camera_ai_scn_architecture);
                break;
            case 26:
                this.f22417f.m23880a(R.string.camera_video_hdr);
                break;
            default:
                this.f22417f.m23880a(-1);
                break;
        }
        return this.f22417f;
    }

    @Override // com.oplus.camera.p172ui.preview.AISceneUI
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void mo22229g(int OplusGLSurfaceView_13) {
        RelativeLayout relativeLayout;
        if (this.f22433v == null) {
            m23875o();
        }
        if (OplusGLSurfaceView_13 == -1) {
            OplusGLSurfaceView_13 = 0;
        }
        if (OplusGLSurfaceView_13 % 180 == 0) {
            OplusGLSurfaceView_13 = 0;
        }
        if (!this.f22433v.m23904b() && this.f22433v.m23901a() != OplusGLSurfaceView_13 && this.f22436y.mo18008a() && (relativeLayout = this.f22415d) != null) {
            relativeLayout.startAnimation(this.f22433v);
        }
        this.f22433v.m23902a(OplusGLSurfaceView_13, true);
    }

    @Override // com.oplus.camera.p172ui.preview.AISceneUI
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void mo22231h(int OplusGLSurfaceView_13) {
        this.f22428q = OplusGLSurfaceView_13;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_15 */
    public void m23871j(int OplusGLSurfaceView_13) {
        RelativeLayout relativeLayout = this.f22415d;
        if (relativeLayout != null) {
            if (relativeLayout.getVisibility() != OplusGLSurfaceView_13) {
                this.f22415d.setVisibility(OplusGLSurfaceView_13);
            }
            AISceneUI.PlatformImplementations.kt_3 aVar = this.f22418g;
            if (aVar != null) {
                if (OplusGLSurfaceView_13 != 0) {
                    aVar.mo20038b(0);
                } else {
                    aVar.mo20038b(mo22217b());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public void m23877q() {
        if (this.f22415d == null || this.f22416e == null) {
            return;
        }
        this.f22418g.mo20034a();
        this.f22416e.m22066a(new SimpleAnimatorListener() { // from class: com.oplus.camera.ui.preview.u.2
            @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                PIAISceneUI.this.m23871j(0);
            }
        });
    }

    @Override // com.oplus.camera.p172ui.preview.AISceneUI
    /* renamed from: COUIBaseListPopupWindow_12 */
    public int mo22226f() {
        return this.f22426o;
    }

    /* renamed from: r */
    private void m23878r() {
        if (this.f22415d == null || this.f22416e == null) {
            return;
        }
        this.f22418g.mo20037b();
        if (this.f22415d.getVisibility() == 0) {
            this.f22416e.m22067b(new SimpleAnimatorListener() { // from class: com.oplus.camera.ui.preview.u.3
                @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PIAISceneUI.this.m23871j(8);
                }

                @Override // com.oplus.camera.p137b.SimpleAnimatorListener, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    PIAISceneUI.this.m23871j(8);
                }
            });
        }
    }

    @Override // com.oplus.camera.p172ui.preview.AISceneUI
    /* renamed from: OplusGLSurfaceView_13 */
    public boolean mo22232i() {
        RelativeLayout relativeLayout = this.f22415d;
        return relativeLayout != null && relativeLayout.isShown();
    }

    @Override // com.oplus.camera.p172ui.preview.AISceneUI
    /* renamed from: OplusGLSurfaceView_15 */
    public boolean mo22233j() {
        AISceneView aISceneView = this.f22416e;
        return aISceneView != null && aISceneView.m22068b();
    }

    @Override // com.oplus.camera.p172ui.preview.AISceneUI
    /* renamed from: COUIBaseListPopupWindow_11 */
    public RelativeLayout mo22228g() {
        return this.f22415d;
    }

    @Override // com.oplus.camera.p172ui.preview.AISceneUI
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22212a(MotionEvent motionEvent) {
        if (1 == motionEvent.getAction()) {
            this.f22437z.removeMessages(1);
            if (this.f22426o == 0) {
                mo22230h();
            }
        }
    }

    @Override // com.oplus.camera.p172ui.preview.AISceneUI
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22211a(int OplusGLSurfaceView_13, boolean z) {
        CameraLog.m12962c("PIAISceneUI", "reversAIScene");
        m23868c(OplusGLSurfaceView_13, z);
        AISceneUI.PlatformImplementations.kt_3 aVar = this.f22418g;
        if (aVar == null || this.f22426o != OplusGLSurfaceView_13) {
            return;
        }
        aVar.mo20036a(OplusGLSurfaceView_13, z, false);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m23868c(int OplusGLSurfaceView_13, boolean z) {
        int iM23861a = m23861a(OplusGLSurfaceView_13, this.f20894c.getInt("oplus.camera.ai_scene_enable_list", 67108863), z);
        CameraLog.m12954a("PIAISceneUI", "setAISceneEnableStatus, scene: " + OplusGLSurfaceView_13 + ", enabled: " + z + ", status: " + Integer.toBinaryString(iM23861a));
        this.f20894c.edit().putInt("oplus.camera.ai_scene_enable_list", iM23861a).apply();
    }

    /* compiled from: PIAISceneUI.java */
    /* renamed from: com.oplus.camera.ui.preview.u$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private int f22442a;

        private PlatformImplementations.kt_3() {
            this.f22442a = -1;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m23880a(int OplusGLSurfaceView_13) {
            this.f22442a = OplusGLSurfaceView_13;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public int m23879a() {
            return this.f22442a;
        }
    }
}
