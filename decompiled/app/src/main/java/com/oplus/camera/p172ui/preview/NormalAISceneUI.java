package com.oplus.camera.p172ui.preview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.oplus.camera.CameraLog;
import com.oplus.camera.ComboPreferences;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.menu.OplusTextView;
import com.oplus.camera.p172ui.preview.AISceneUI;
import com.oplus.camera.util.Util;

/* compiled from: NormalAISceneUI.java */
/* renamed from: com.oplus.camera.ui.preview.t */
/* loaded from: classes2.dex */
public class NormalAISceneUI extends AISceneUI {

    /* renamed from: OplusGLSurfaceView_11 */
    private int f22396n;

    /* renamed from: q */
    private int f22399q;

    /* renamed from: r */
    private int f22400r;

    /* renamed from: x */
    private int f22406x;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private RelativeLayout f22386d = null;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private OplusTextView f22387e = null;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private ImageView f22388f = null;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private OplusTextView f22389g = null;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private ImageView f22390h = null;

    /* renamed from: OplusGLSurfaceView_13 */
    private PlatformImplementations.kt_3 f22391i = null;

    /* renamed from: OplusGLSurfaceView_15 */
    private AnimatorSet f22392j = null;

    /* renamed from: OplusGLSurfaceView_5 */
    private ObjectAnimator f22393k = null;

    /* renamed from: OplusGLSurfaceView_14 */
    private AISceneUI.PlatformImplementations.kt_3 f22394l = null;

    /* renamed from: OplusGLSurfaceView_6 */
    private View.OnLayoutChangeListener f22395m = null;

    /* renamed from: o */
    private int f22397o = 0;

    /* renamed from: p */
    private int f22398p = 0;

    /* renamed from: s */
    private int f22401s = 0;

    /* renamed from: t */
    private int f22402t = 0;

    /* renamed from: u */
    private int f22403u = 0;

    /* renamed from: v */
    private int f22404v = 0;

    /* renamed from: w */
    private boolean f22405w = false;

    public NormalAISceneUI(Activity activity, ViewGroup viewGroup, ComboPreferences comboPreferences) {
        this.f22396n = 0;
        this.f22399q = 0;
        this.f22400r = 0;
        this.f22406x = 0;
        this.f20892a = activity;
        this.f20893b = viewGroup;
        this.f20894c = comboPreferences;
        this.f22396n = this.f20892a.getResources().getDimensionPixelSize(R.dimen.camera_hint_margin);
        this.f22399q = (int) (Util.getScreenWidth() * 1.3333333333333333d);
        this.f22400r = Util.getScreenWidth();
        this.f22406x = this.f20892a.getResources().getDimensionPixelSize(R.dimen.toast_margin_top);
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private void m23847l() {
        if (this.f22386d != null || this.f20893b == null) {
            return;
        }
        this.f20892a.getLayoutInflater().inflate(R.layout.ai_scene_layout, this.f20893b);
        this.f22386d = (RelativeLayout) this.f20892a.findViewById(R.id_renamed.ai_scene_layout);
        this.f22387e = (OplusTextView) this.f22386d.findViewById(R.id_renamed.ai_scene_text);
        this.f22388f = (ImageView) this.f22386d.findViewById(R.id_renamed.ai_scene_second_divide);
        this.f22389g = (OplusTextView) this.f22386d.findViewById(R.id_renamed.ai_scene_right_text);
        this.f22390h = (ImageView) this.f22386d.findViewById(R.id_renamed.ai_scene_close);
        if (this.f22392j == null) {
            this.f22392j = new AnimatorSet();
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f22386d, (Property<RelativeLayout, Float>) View.SCALE_X, 0.0f, 1.0f);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f22386d, (Property<RelativeLayout, Float>) View.SCALE_Y, 0.0f, 1.0f);
            this.f22392j.setInterpolator(new PathInterpolator(0.35f, 2.0f, 0.0f, 1.0f));
            this.f22392j.setDuration(240L);
            this.f22392j.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
            this.f22392j.addListener(new Animator.AnimatorListener() { // from class: com.oplus.camera.ui.preview.t.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    if (NormalAISceneUI.this.f22386d != null) {
                        NormalAISceneUI.this.f22386d.setAlpha(1.0f);
                        NormalAISceneUI.this.m23846j(0);
                    }
                }
            });
        }
        if (this.f22393k == null) {
            this.f22393k = ObjectAnimator.ofFloat(this.f22386d, (Property<RelativeLayout, Float>) View.ALPHA, 1.0f, 0.0f);
            this.f22393k.setInterpolator(new PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f));
            this.f22393k.setDuration(240L);
            this.f22393k.addListener(new Animator.AnimatorListener() { // from class: com.oplus.camera.ui.preview.t.2
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
                    NormalAISceneUI.this.m23846j(8);
                }
            });
        }
        ImageView imageView = this.f22390h;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.ui.preview.t.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CameraLog.m12959b("NormalAISceneUI", "mAISceneCloseView, onClick, code: " + view.getTag());
                    if (NormalAISceneUI.this.f22394l != null) {
                        NormalAISceneUI.this.f22394l.mo20035a(((Integer) view.getTag()).intValue());
                    }
                }
            });
        }
        m23852q();
    }

    @Override // com.oplus.camera.p172ui.preview.AISceneUI
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22215a(boolean z) {
        m23848m();
        if (this.f22386d != null && this.f20893b != null) {
            this.f20893b.removeView(this.f22386d);
            this.f22386d = null;
            this.f22387e = null;
        }
        this.f22392j = null;
        this.f22393k = null;
        this.f22405w = z;
        this.f22402t = 0;
        this.f22403u = 0;
    }

    @Override // com.oplus.camera.p172ui.preview.AISceneUI
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo22218b(int OplusGLSurfaceView_13) {
        this.f22402t = OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.p172ui.preview.AISceneUI
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22209a(int OplusGLSurfaceView_13, int i2, int i3) {
        this.f22402t = OplusGLSurfaceView_13;
        this.f22403u = i3;
        m23845i(i2);
        if (this.f22405w) {
            return;
        }
        m23847l();
        if (this.f22386d == null) {
            return;
        }
        PlatformImplementations.kt_3 aVarM23842a = m23842a(OplusGLSurfaceView_13, i3);
        if (aVarM23842a.m23853a() == -1) {
            m23848m();
            m23851p();
            return;
        }
        this.f22387e.setText(aVarM23842a.m23853a());
        if (aVarM23842a.m23859c()) {
            this.f22389g.setText(aVarM23842a.m23856b());
            this.f22388f.setVisibility(0);
            this.f22389g.setVisibility(0);
        } else {
            this.f22389g.setVisibility(8);
            this.f22388f.setVisibility(8);
        }
        if (aVarM23842a.m23860d()) {
            this.f22390h.setTag(Integer.valueOf(OplusGLSurfaceView_13));
            this.f22390h.setVisibility(0);
        } else {
            this.f22390h.setVisibility(8);
        }
        mo22227f(i2);
        m23848m();
        m23850o();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m23840a(View view) {
        if (view == null) {
            return 0;
        }
        view.measure(Util.getScreenWidth(), Util.getScreenWidth());
        return view.getWidth();
    }

    @Override // com.oplus.camera.p172ui.preview.AISceneUI
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22214a(AISceneUI.PlatformImplementations.kt_3 aVar) {
        this.f22394l = aVar;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private void m23848m() {
        ObjectAnimator objectAnimator = this.f22393k;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.f22393k.cancel();
        }
        AnimatorSet animatorSet = this.f22392j;
        if (animatorSet == null || !animatorSet.isRunning()) {
            return;
        }
        this.f22392j.cancel();
    }

    @Override // com.oplus.camera.p172ui.preview.AISceneUI
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void mo22230h() {
        if (this.f22386d != null) {
            m23848m();
            m23851p();
        }
    }

    @Override // com.oplus.camera.p172ui.preview.AISceneUI
    /* renamed from: COUIBaseListPopupWindow_12 */
    protected void mo22227f(int OplusGLSurfaceView_13) {
        if (this.f22386d != null) {
            m23845i(OplusGLSurfaceView_13);
            if (this.f22405w) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE);
            this.f22386d.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            int measuredWidth = this.f22386d.getMeasuredWidth();
            int measuredHeight = this.f22386d.getMeasuredHeight();
            this.f22386d.layout(0, 0, measuredWidth, measuredHeight);
            if (this.f22397o > 0) {
                int i2 = this.f22406x;
            }
            if (OplusGLSurfaceView_13 == 90) {
                layoutParams.addRule(9);
                layoutParams.addRule(10);
                layoutParams.leftMargin = (this.f22396n + (measuredHeight / 2)) - (measuredWidth / 2);
                layoutParams.topMargin = (((this.f22399q - measuredHeight) - this.f22397o) / 2) + Util.m24186N();
            } else if (OplusGLSurfaceView_13 == 270) {
                layoutParams.addRule(11);
                layoutParams.addRule(10);
                layoutParams.rightMargin = (this.f22396n + (measuredHeight / 2)) - (measuredWidth / 2);
                layoutParams.topMargin = (((this.f22399q - measuredHeight) + this.f22397o) / 2) + Util.m24186N();
            } else {
                layoutParams.addRule(10);
                layoutParams.addRule(11);
                layoutParams.topMargin = Util.m24186N() + this.f22396n + this.f22398p + this.f22406x;
                layoutParams.rightMargin = ((m23849n() - measuredWidth) - this.f22397o) / 2;
            }
            this.f22386d.setZ(999.0f);
            this.f22386d.setLayoutParams(layoutParams);
            this.f22386d.setRotation(-this.f22401s);
        }
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private int m23849n() {
        if (3 == this.f22404v) {
            return this.f22400r / 2;
        }
        return this.f22400r;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private PlatformImplementations.kt_3 m23842a(int OplusGLSurfaceView_13, int i2) {
        if (this.f22391i == null) {
            this.f22391i = new PlatformImplementations.kt_3();
        }
        this.f22391i.m23857b(-1);
        this.f22391i.m23855a(false);
        this.f22391i.m23858b(false);
        switch (OplusGLSurfaceView_13) {
            case 1:
                this.f22391i.m23854a(R.string.camera_ai_scn_beach);
                break;
            case 2:
                this.f22391i.m23854a(R.string.camera_ai_scn_bluesky);
                break;
            case 3:
                this.f22391i.m23854a(R.string.camera_ai_scn_cat);
                break;
            case 4:
                this.f22391i.m23854a(R.string.camera_ai_scn_text);
                break;
            case 5:
                this.f22391i.m23854a(R.string.camera_ai_scn_dog);
                break;
            case 6:
                this.f22391i.m23854a(R.string.camera_ai_scn_firework);
                break;
            case 7:
                this.f22391i.m23854a(R.string.camera_ai_scn_gourmet);
                break;
            case 8:
                this.f22391i.m23854a(R.string.camera_ai_scn_grass);
                break;
            case 9:
                this.f22391i.m23854a(R.string.camera_ai_scn_indoor);
                break;
            case 10:
                this.f22391i.m23854a(R.string.camera_ai_scn_infant);
                break;
            case 11:
                this.f22391i.m23854a(R.string.camera_ai_scn_landscape);
                break;
            case 12:
                CameraLog.m12959b("NormalAISceneUI", "getDataByAIScene, subCode: " + i2);
                this.f22391i.m23854a(R.string.camera_ai_scn_night);
                if (i2 != 1) {
                    if (i2 == 2) {
                        this.f22391i.m23857b(-1);
                        this.f22391i.m23855a(false);
                        this.f22391i.m23858b(true);
                        break;
                    }
                } else {
                    this.f22391i.m23857b(R.string.camera_ai_scn_night_capture_tips);
                    this.f22391i.m23855a(true);
                    this.f22391i.m23858b(true);
                    break;
                }
                break;
            case 13:
                this.f22391i.m23854a(R.string.camera_ai_scn_snow);
                break;
            case 14:
                this.f22391i.m23854a(R.string.camera_ai_scn_spotlight);
                break;
            case 15:
                this.f22391i.m23854a(R.string.camera_ai_scn_sunset);
                break;
            case 16:
                this.f22391i.m23854a(R.string.camera_ai_scn_portrait);
                break;
            case 17:
                this.f22391i.m23854a(R.string.camera_ai_scn_multi_portrait);
                break;
            case 18:
                this.f22391i.m23854a(R.string.camera_ai_scn_microspur);
                break;
            case 19:
                this.f22391i.m23854a(R.string.camera_ai_scn_backlight);
                break;
            case 20:
                this.f22391i.m23854a(R.string.camera_ai_scn_purecolor);
                break;
            case 21:
                this.f22391i.m23854a(R.string.camera_ai_scn_moire);
                break;
            case 22:
                this.f22391i.m23854a(R.string.camera_ai_scn_flower);
                break;
            case 23:
                this.f22391i.m23854a(R.string.camera_ai_scn_plant);
                break;
            case 24:
                this.f22391i.m23854a(R.string.camera_ai_scn_birds);
                break;
            case 25:
                this.f22391i.m23854a(R.string.camera_ai_scn_architecture);
                break;
            case 26:
                this.f22391i.m23854a(R.string.camera_video_hdr);
                break;
            default:
                this.f22391i.m23854a(-1);
                break;
        }
        return this.f22391i;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m23845i(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 180) {
            this.f22401s = 0;
        } else {
            this.f22401s = OplusGLSurfaceView_13;
        }
    }

    @Override // com.oplus.camera.p172ui.preview.AISceneUI
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22216a(boolean z, boolean z2) {
        this.f22405w = z;
        m23847l();
        RelativeLayout relativeLayout = this.f22386d;
        if (relativeLayout != null) {
            if (this.f22405w) {
                if (relativeLayout.getVisibility() == 0) {
                    m23846j(8);
                }
            } else {
                if (!z2 || relativeLayout.getVisibility() == 0) {
                    return;
                }
                mo22209a(this.f22402t, this.f22401s, this.f22403u);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_15 */
    public void m23846j(int OplusGLSurfaceView_13) {
        RelativeLayout relativeLayout = this.f22386d;
        if (relativeLayout != null) {
            if (relativeLayout.getVisibility() != OplusGLSurfaceView_13) {
                this.f22386d.setVisibility(OplusGLSurfaceView_13);
            }
            AISceneUI.PlatformImplementations.kt_3 aVar = this.f22394l;
            if (aVar != null) {
                if (OplusGLSurfaceView_13 != 0) {
                    aVar.mo20038b(0);
                } else {
                    aVar.mo20038b(mo22217b());
                }
            }
        }
    }

    @Override // com.oplus.camera.p172ui.preview.AISceneUI
    /* renamed from: IntrinsicsJvm.kt_4 */
    public int mo22217b() {
        RelativeLayout relativeLayout = this.f22386d;
        if (relativeLayout == null || relativeLayout.getVisibility() != 0) {
            return 0;
        }
        return m23840a(this.f22386d);
    }

    /* renamed from: o */
    private void m23850o() {
        AnimatorSet animatorSet = this.f22392j;
        if (animatorSet != null) {
            animatorSet.start();
        }
    }

    /* renamed from: p */
    private void m23851p() {
        if (this.f22393k == null || this.f22386d.getVisibility() != 0) {
            return;
        }
        this.f22393k.start();
    }

    @Override // com.oplus.camera.p172ui.preview.AISceneUI
    /* renamed from: COUIBaseListPopupWindow_11 */
    public void mo22229g(int OplusGLSurfaceView_13) {
        mo22227f(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.p172ui.preview.AISceneUI
    /* renamed from: COUIBaseListPopupWindow_12 */
    public int mo22226f() {
        return this.f22402t;
    }

    @Override // com.oplus.camera.p172ui.preview.AISceneUI
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22213a(View.OnLayoutChangeListener onLayoutChangeListener) {
        this.f22395m = onLayoutChangeListener;
        m23852q();
    }

    /* renamed from: q */
    private void m23852q() {
        View.OnLayoutChangeListener onLayoutChangeListener;
        RelativeLayout relativeLayout = this.f22386d;
        if (relativeLayout == null || (onLayoutChangeListener = this.f22395m) == null) {
            return;
        }
        relativeLayout.addOnLayoutChangeListener(onLayoutChangeListener);
    }

    @Override // com.oplus.camera.p172ui.preview.AISceneUI
    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean mo22221c() {
        RelativeLayout relativeLayout = this.f22386d;
        return relativeLayout != null && relativeLayout.getVisibility() == 0;
    }

    @Override // com.oplus.camera.p172ui.preview.AISceneUI
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo22208a(int OplusGLSurfaceView_13) {
        this.f22398p = OplusGLSurfaceView_13;
    }

    @Override // com.oplus.camera.p172ui.preview.AISceneUI
    /* renamed from: PlatformImplementations.kt_3 */
    public int mo22207a() {
        return this.f22396n;
    }

    @Override // com.oplus.camera.p172ui.preview.AISceneUI
    /* renamed from: OplusGLSurfaceView_13 */
    public boolean mo22232i() {
        RelativeLayout relativeLayout = this.f22386d;
        if (relativeLayout == null) {
            return false;
        }
        return relativeLayout.isShown();
    }

    @Override // com.oplus.camera.p172ui.preview.AISceneUI
    /* renamed from: OplusGLSurfaceView_15 */
    public boolean mo22233j() {
        ObjectAnimator objectAnimator = this.f22393k;
        return objectAnimator != null && objectAnimator.isRunning();
    }

    @Override // com.oplus.camera.p172ui.preview.AISceneUI
    /* renamed from: COUIBaseListPopupWindow_11 */
    public RelativeLayout mo22228g() {
        return this.f22386d;
    }

    @Override // com.oplus.camera.p172ui.preview.AISceneUI
    /* renamed from: COUIBaseListPopupWindow_10 */
    public void mo22231h(int OplusGLSurfaceView_13) {
        this.f22404v = OplusGLSurfaceView_13;
    }

    /* compiled from: NormalAISceneUI.java */
    /* renamed from: com.oplus.camera.ui.preview.t$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private int f22411b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private int f22412c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private boolean f22413d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private boolean f22414e;

        private PlatformImplementations.kt_3() {
            this.f22411b = -1;
            this.f22412c = -1;
            this.f22413d = false;
            this.f22414e = false;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m23854a(int OplusGLSurfaceView_13) {
            this.f22411b = OplusGLSurfaceView_13;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m23857b(int OplusGLSurfaceView_13) {
            this.f22412c = OplusGLSurfaceView_13;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m23855a(boolean z) {
            this.f22413d = z;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m23858b(boolean z) {
            this.f22414e = z;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public int m23853a() {
            return this.f22411b;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public int m23856b() {
            return this.f22412c;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public boolean m23859c() {
            return this.f22413d;
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public boolean m23860d() {
            return this.f22414e;
        }
    }
}
