package com.oplus.camera.p172ui.menu.levelcontrol;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Handler;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.RelativeLayout;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.inverse.InverseTextView;
import com.oplus.camera.p172ui.menu.levelcontrol.BaseScrollBar;
import com.oplus.camera.p172ui.menu.setting.ExpandableMenuPanel;
import com.oplus.camera.p172ui.preview.p177a.FilterHelper;
import com.oplus.camera.p172ui.preview.p177a.FilterTexturePreview;
import com.oplus.camera.statistics.model.MenuClickMsgData;
import com.oplus.camera.util.Util;
import java.util.List;

/* compiled from: FilterEffectMenu.java */
/* renamed from: com.oplus.camera.ui.menu.levelcontrol.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public class FilterEffectMenu extends ExpandableMenuPanel {

    /* renamed from: A */
    private int f19702A;

    /* renamed from: B */
    private FilterTexturePreview.PlatformImplementations.kt_3 f19703B;

    /* renamed from: PlatformImplementations.kt_3 */
    private int f19704a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Activity f19705b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private RelativeLayout f19706c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private RelativeLayout f19707d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private InverseTextView f19708e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private InverseTextView f19709f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private BaseScrollBar f19710g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private PlatformImplementations.kt_3 f19711h;

    /* renamed from: OplusGLSurfaceView_13 */
    private Handler f19712i;

    /* renamed from: OplusGLSurfaceView_15 */
    private AnimatorSet f19713j;

    /* renamed from: OplusGLSurfaceView_5 */
    private List<String> f19714k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f19715l;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f19716m;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f19717n;

    /* renamed from: o */
    private int f19718o;

    /* renamed from: p */
    private int f19719p;

    /* renamed from: q */
    private int f19720q;

    /* renamed from: r */
    private int f19721r;

    /* renamed from: s */
    private int f19722s;

    /* renamed from: t */
    private int f19723t;

    /* renamed from: u */
    private int f19724u;

    /* renamed from: v */
    private AnimatorSet f19725v;

    /* renamed from: w */
    private AnimatorSet f19726w;

    /* renamed from: x */
    private AnimatorSet f19727x;

    /* renamed from: y */
    private PathInterpolator f19728y;

    /* renamed from: z */
    private PathInterpolator f19729z;

    /* compiled from: FilterEffectMenu.java */
    /* renamed from: com.oplus.camera.ui.menu.levelcontrol.COUIBaseListPopupWindow_11$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo19993a();

        /* renamed from: PlatformImplementations.kt_3 */
        void mo19994a(int OplusGLSurfaceView_13, boolean z);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo19995a(GLProducerRender abstractC3285j);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo19996a(String str);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo19997a(boolean z);

        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo19998a(int OplusGLSurfaceView_13);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo19999b(String str);

        /* renamed from: IntrinsicsJvm.kt_4 */
        boolean mo20000b();

        /* renamed from: IntrinsicsJvm.kt_3 */
        boolean mo20001c();

        /* renamed from: IntrinsicsJvm.kt_5 */
        boolean mo20002d();

        /* renamed from: COUIBaseListPopupWindow_8 */
        int mo20003e();

        /* renamed from: COUIBaseListPopupWindow_12 */
        int mo20004f();

        /* renamed from: COUIBaseListPopupWindow_11 */
        boolean mo20005g();
    }

    @Override // com.oplus.camera.p172ui.menu.setting.ExpandableMenuPanel
    public void showMenuPanel(String str, boolean z, boolean z2) {
        if (this.mbExitAnimationRunning) {
            CameraLog.m12954a("FilterEffectMenu", "showMenuPanel, ExitAnimatorSet.isRunning, return");
            return;
        }
        PlatformImplementations.kt_3 aVar = this.f19711h;
        if (aVar == null || (!aVar.mo20002d() && !z)) {
            CameraLog.m12954a("FilterEffectMenu", "showMenuPanel, mMenuListener null, return!");
            return;
        }
        if (this.f19711h.mo20000b() || z) {
            this.f19721r = 1;
            this.f19711h.mo19999b(MenuClickMsgData.KEY_FILTER);
            m20888f(true);
        }
        super.showMenuPanel(str, z, false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20866a() {
        m20875b();
        PlatformImplementations.kt_3 aVar = this.f19711h;
        if (aVar != null) {
            BaseScrollBar abstractTextureViewSurfaceTextureListenerC3277b = this.f19710g;
            if (abstractTextureViewSurfaceTextureListenerC3277b instanceof HorizontalScrollBar) {
                ((HorizontalScrollBar) abstractTextureViewSurfaceTextureListenerC3277b).setRearMirrorEnable(aVar.mo20005g());
            }
        }
        AnimatorSet animatorSet = this.f19726w;
        if (animatorSet != null && animatorSet.isStarted()) {
            this.f19726w.cancel();
        }
        AnimatorSet animatorSet2 = this.f19727x;
        if (animatorSet2 != null && animatorSet2.isStarted()) {
            this.f19727x.cancel();
        }
        this.f19721r = 1;
        PlatformImplementations.kt_3 aVar2 = this.f19711h;
        if (aVar2 != null) {
            aVar2.mo19999b(MenuClickMsgData.KEY_FILTER);
        }
        if (this.f19714k == null) {
            CameraLog.m12967f("FilterEffectMenu", "showBeautyFilterPanel, mCurrMenuNames is null.");
            return;
        }
        this.f19716m = true;
        m20862j();
        this.f19710g.setFilterCategory(this.f19703B);
        this.f19707d.setVisibility(0);
        this.f19710g.setAlpha(0.0f);
        this.f19710g.setVisibility(0);
        if (this.f19725v == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f19710g, "alpha", 0.0f, 1.0f);
            objectAnimatorOfFloat.setInterpolator(this.f19728y);
            objectAnimatorOfFloat.setDuration(400L);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f19710g, getAnimationTranslateProp(), getAnimationTranslateDistance(), 0.0f);
            objectAnimatorOfFloat2.setInterpolator(this.f19729z);
            objectAnimatorOfFloat2.setDuration(400L);
            this.f19725v = new AnimatorSet();
            this.f19725v.play(objectAnimatorOfFloat2).with(objectAnimatorOfFloat);
            this.f19725v.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.menu.levelcontrol.COUIBaseListPopupWindow_11.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    FilterEffectMenu.this.f19710g.setAlpha(0.0f);
                    FilterEffectMenu.this.f19710g.setVisibility(0);
                }
            });
        }
        this.f19725v.setStartDelay(this.f19702A);
        this.f19725v.start();
    }

    public void setBeautyShowDelay(int OplusGLSurfaceView_13) {
        this.f19702A = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20873a(boolean z) {
        m20875b();
        m20882c(z);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m20878b(boolean z) {
        if (isEffectMenuOpen()) {
            m20875b();
            m20884d(z);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m20882c(boolean z) {
        BaseScrollBar abstractTextureViewSurfaceTextureListenerC3277b;
        CameraLog.m12954a("FilterEffectMenu", "hideFilterEffectMenu, needAni: " + z);
        AnimatorSet animatorSet = this.f19725v;
        if (animatorSet != null && animatorSet.isStarted()) {
            this.f19725v.cancel();
        }
        Handler handler = this.f19712i;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.f19716m = false;
        AnimatorSet animatorSet2 = this.f19726w;
        if ((animatorSet2 == null || !animatorSet2.isStarted()) && (abstractTextureViewSurfaceTextureListenerC3277b = this.f19710g) != null && abstractTextureViewSurfaceTextureListenerC3277b.isShown()) {
            if (z) {
                if (this.f19726w == null) {
                    ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f19710g, "alpha", 1.0f, 0.0f);
                    objectAnimatorOfFloat.setInterpolator(this.f19728y);
                    objectAnimatorOfFloat.setDuration(250L);
                    ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f19710g, "scaleX", 1.0f, 0.9f);
                    objectAnimatorOfFloat2.setInterpolator(this.f19729z);
                    objectAnimatorOfFloat2.setDuration(400L);
                    ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.f19710g, "scaleY", 1.0f, 0.9f);
                    objectAnimatorOfFloat3.setInterpolator(this.f19729z);
                    objectAnimatorOfFloat3.setDuration(400L);
                    this.f19726w = new AnimatorSet();
                    this.f19726w.play(objectAnimatorOfFloat2).with(objectAnimatorOfFloat3).with(objectAnimatorOfFloat);
                    this.f19726w.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.menu.levelcontrol.COUIBaseListPopupWindow_11.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                            FilterEffectMenu.this.f19710g.setVisibility(0);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            FilterEffectMenu.this.f19710g.setVisibility(8);
                            FilterEffectMenu.this.f19710g.setScaleY(1.0f);
                            FilterEffectMenu.this.f19710g.setScaleX(1.0f);
                        }
                    });
                }
                this.f19726w.start();
                return;
            }
            this.f19710g.setVisibility(8);
            this.f19710g.setScaleY(1.0f);
            this.f19710g.setScaleX(1.0f);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m20884d(boolean z) {
        BaseScrollBar abstractTextureViewSurfaceTextureListenerC3277b;
        CameraLog.m12954a("FilterEffectMenu", "closeFaceBeautyAnimator, needAni: " + z);
        AnimatorSet animatorSet = this.f19725v;
        if (animatorSet != null && animatorSet.isStarted()) {
            this.f19725v.cancel();
        }
        Handler handler = this.f19712i;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.f19716m = false;
        AnimatorSet animatorSet2 = this.f19727x;
        if ((animatorSet2 == null || !animatorSet2.isStarted()) && (abstractTextureViewSurfaceTextureListenerC3277b = this.f19710g) != null && abstractTextureViewSurfaceTextureListenerC3277b.isShown()) {
            if (z) {
                if (this.f19727x == null) {
                    ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f19710g, getAnimationTranslateProp(), 0.0f, getAnimationTranslateDistance());
                    objectAnimatorOfFloat.setInterpolator(this.f19729z);
                    objectAnimatorOfFloat.setDuration(400L);
                    ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f19710g, "alpha", 1.0f, 0.0f);
                    objectAnimatorOfFloat2.setInterpolator(this.f19728y);
                    objectAnimatorOfFloat2.setDuration(250L);
                    this.f19727x = new AnimatorSet();
                    this.f19727x.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
                    this.f19727x.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.menu.levelcontrol.COUIBaseListPopupWindow_11.3
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationStart(Animator animator) {
                            FilterEffectMenu.this.f19710g.setVisibility(0);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            FilterEffectMenu.this.f19710g.setVisibility(8);
                        }
                    });
                }
                this.f19727x.start();
                return;
            }
            this.f19710g.setVisibility(8);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m20875b() {
        CameraLog.m12954a("FilterEffectMenu", "cancelAnimation.");
        RelativeLayout relativeLayout = this.f19707d;
        if (relativeLayout != null) {
            relativeLayout.clearAnimation();
        }
        BaseScrollBar abstractTextureViewSurfaceTextureListenerC3277b = this.f19710g;
        if (abstractTextureViewSurfaceTextureListenerC3277b != null) {
            abstractTextureViewSurfaceTextureListenerC3277b.clearAnimation();
        }
        this.mbEnterAnimationRunning = false;
        this.mbExitAnimationRunning = false;
    }

    @Override // com.oplus.camera.p172ui.menu.setting.ExpandableMenuPanel
    public void hideMenuPanel(boolean z, boolean z2) {
        if (isEffectMenuOpen()) {
            if (isAnimationRunning() || m20890h()) {
                CameraLog.m12954a("FilterEffectMenu", "hideMenuPanel, anim isRunning, return.");
                return;
            }
            m20879b(true, z2);
        }
        m20885e();
    }

    /* compiled from: FilterEffectMenu.java */
    /* renamed from: com.oplus.camera.ui.menu.levelcontrol.COUIBaseListPopupWindow_11$IntrinsicsJvm.kt_4 */
    private class IntrinsicsJvm.kt_4 implements BaseScrollBar.PlatformImplementations.kt_3 {
        private IntrinsicsJvm.kt_4() {
        }

        @Override // com.oplus.camera.p172ui.menu.levelcontrol.BaseScrollBar.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo20830a() {
            if (FilterEffectMenu.this.f19711h != null) {
                FilterEffectMenu.this.f19711h.mo19993a();
            }
            if (FilterEffectMenu.this.f19710g != null) {
                FilterEffectMenu.this.f19710g.m20808a(FilterEffectMenu.this.f19718o, FilterEffectMenu.this.f19719p);
            }
        }

        @Override // com.oplus.camera.p172ui.menu.levelcontrol.BaseScrollBar.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo20832a(GLProducerRender abstractC3285j) {
            if (FilterEffectMenu.this.f19711h != null) {
                FilterEffectMenu.this.f19711h.mo19995a(abstractC3285j);
            }
        }

        @Override // com.oplus.camera.p172ui.menu.levelcontrol.BaseScrollBar.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo20831a(int OplusGLSurfaceView_13, boolean z) {
            if (FilterEffectMenu.this.f19711h != null) {
                FilterEffectMenu.this.f19715l = OplusGLSurfaceView_13;
                FilterEffectMenu.this.f19711h.mo19994a(OplusGLSurfaceView_13, z);
            }
        }

        @Override // com.oplus.camera.p172ui.menu.levelcontrol.BaseScrollBar.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo20833a(int OplusGLSurfaceView_13) {
            if (FilterEffectMenu.this.f19711h != null) {
                return FilterEffectMenu.this.f19711h.mo19998a(OplusGLSurfaceView_13);
            }
            return false;
        }

        @Override // com.oplus.camera.p172ui.menu.levelcontrol.BaseScrollBar.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean mo20834b() {
            return FilterEffectMenu.this.f19711h != null && FilterEffectMenu.this.f19711h.mo20000b() && !FilterEffectMenu.this.isAnimationRunning() && (FilterEffectMenu.this.f19713j == null || !FilterEffectMenu.this.f19713j.isRunning()) && FilterEffectMenu.this.f19716m;
        }

        @Override // com.oplus.camera.p172ui.menu.levelcontrol.BaseScrollBar.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_3 */
        public int mo20835c() {
            return FilterEffectMenu.this.f19715l;
        }

        @Override // com.oplus.camera.p172ui.menu.levelcontrol.BaseScrollBar.PlatformImplementations.kt_3
        /* renamed from: IntrinsicsJvm.kt_5 */
        public int mo20836d() {
            if (FilterEffectMenu.this.f19711h != null) {
                return FilterEffectMenu.this.f19711h.mo20003e();
            }
            return 0;
        }
    }

    public void setFilterEffectMenuListener(PlatformImplementations.kt_3 aVar) {
        this.f19711h = aVar;
    }

    public FilterEffectMenu(Activity activity) {
        super(activity);
        this.f19704a = 0;
        this.f19705b = null;
        this.f19706c = null;
        this.f19707d = null;
        this.f19708e = null;
        this.f19709f = null;
        this.f19710g = null;
        this.f19711h = null;
        this.f19712i = new Handler();
        this.f19713j = null;
        this.f19714k = null;
        this.f19715l = FilterHelper.f21279a;
        this.f19716m = false;
        this.f19717n = false;
        this.f19718o = 0;
        this.f19719p = 0;
        this.f19720q = 1;
        this.f19721r = 1;
        this.f19722s = R.layout.effects_menu_horizontal_common;
        this.f19723t = 0;
        this.f19724u = 0;
        this.f19725v = null;
        this.f19726w = null;
        this.f19727x = null;
        this.f19728y = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
        this.f19729z = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
        this.f19702A = 0;
        this.f19703B = FilterTexturePreview.PlatformImplementations.kt_3.Polarr;
        this.f19705b = activity;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20868a(int OplusGLSurfaceView_13, int i2) {
        CameraLog.m12954a("FilterEffectMenu", "setLayoutMode, layoutMode: " + OplusGLSurfaceView_13 + ", screenRotation: " + i2);
        this.f19723t = OplusGLSurfaceView_13;
        this.f19724u = i2;
        FilterHelper.m22600a(OplusGLSurfaceView_13, i2);
        if (OplusGLSurfaceView_13 == 0) {
            this.f19722s = R.layout.effects_menu_horizontal_common;
        } else if (OplusGLSurfaceView_13 != 1) {
            if (OplusGLSurfaceView_13 == 2) {
                this.f19722s = R.layout.effects_menu_horizontal_out_screen;
            } else if (OplusGLSurfaceView_13 == 3) {
                this.f19722s = R.layout.effects_menu_horizontal_split_screen;
            } else if (OplusGLSurfaceView_13 == 4) {
                this.f19722s = 90 == i2 ? R.layout.effects_menu_horizontal_rack : R.layout.effects_menu_horizontal_rack_270;
            }
        } else if (i2 == 0) {
            this.f19722s = R.layout.effects_menu_vertical;
        } else if (270 == i2) {
            this.f19722s = R.layout.effects_menu_vertical_270;
        } else {
            this.f19722s = R.layout.effects_menu_vertical_90;
        }
        AnimatorSet animatorSet = this.f19727x;
        if (animatorSet != null) {
            if (animatorSet.isStarted()) {
                this.f19727x.cancel();
            }
            this.f19727x = null;
        }
        AnimatorSet animatorSet2 = this.f19725v;
        if (animatorSet2 != null) {
            if (animatorSet2.isStarted()) {
                this.f19725v.cancel();
            }
            this.f19725v = null;
        }
        RelativeLayout relativeLayout = this.f19707d;
        if (relativeLayout != null) {
            this.f19706c.removeView(relativeLayout);
            this.f19707d = null;
        }
        BaseScrollBar abstractTextureViewSurfaceTextureListenerC3277b = this.f19710g;
        if (abstractTextureViewSurfaceTextureListenerC3277b == null || !abstractTextureViewSurfaceTextureListenerC3277b.m20818e()) {
            return;
        }
        this.f19710g.m20823j();
    }

    public void setCameraEntryType(int OplusGLSurfaceView_13) {
        this.f19720q = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20867a(int OplusGLSurfaceView_13) {
        this.f19704a = OplusGLSurfaceView_13;
        this.f19706c = (RelativeLayout) this.f19705b.findViewById(R.id_renamed.camera);
        if (this.f19706c == null) {
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m20880c() {
        BaseScrollBar abstractTextureViewSurfaceTextureListenerC3277b = this.f19710g;
        if (abstractTextureViewSurfaceTextureListenerC3277b != null) {
            abstractTextureViewSurfaceTextureListenerC3277b.m20813b();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m20883d() {
        BaseScrollBar abstractTextureViewSurfaceTextureListenerC3277b = this.f19710g;
        if (abstractTextureViewSurfaceTextureListenerC3277b != null) {
            abstractTextureViewSurfaceTextureListenerC3277b.m20815c();
        }
        Handler handler = this.f19712i;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.mbEnterAnimationRunning = false;
        this.mbExitAnimationRunning = false;
        hideWithoutAnim(true, false);
        m20873a(false);
        this.f19726w = null;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m20885e() {
        BaseScrollBar abstractTextureViewSurfaceTextureListenerC3277b = this.f19710g;
        if (abstractTextureViewSurfaceTextureListenerC3277b != null) {
            abstractTextureViewSurfaceTextureListenerC3277b.m20817d();
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.ExpandableMenuPanel
    public boolean onBackPressed() {
        if (isEffectMenuOpen()) {
            if (isAnimationRunning() || m20890h()) {
                CameraLog.m12954a("FilterEffectMenu", "onBackPressed, onClick, anim isRunning.");
            } else {
                m20879b(true, false);
                return true;
            }
        }
        return false;
    }

    @Override // com.oplus.camera.p172ui.menu.setting.ExpandableMenuPanel
    public boolean onSingleTapUp(int OplusGLSurfaceView_13, int i2) {
        if (isEffectMenuOpen() && i2 < respondSingleTouchEventY()) {
            if (isAnimationRunning() || m20890h()) {
                CameraLog.m12954a("FilterEffectMenu", "onSingleTapUp, onClick, anim isRunning.");
            } else {
                m20879b(true, false);
                return true;
            }
        }
        return false;
    }

    @Override // com.oplus.camera.p172ui.menu.setting.ExpandableMenuPanel
    public boolean isAnimationRunning() {
        AnimatorSet animatorSet;
        AnimatorSet animatorSet2;
        AnimatorSet animatorSet3;
        return this.mbEnterAnimationRunning || this.mbExitAnimationRunning || ((animatorSet = this.f19726w) != null && animatorSet.isRunning()) || (((animatorSet2 = this.f19725v) != null && animatorSet2.isRunning()) || ((animatorSet3 = this.f19727x) != null && animatorSet3.isRunning()));
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m20887f() {
        BaseScrollBar abstractTextureViewSurfaceTextureListenerC3277b = this.f19710g;
        if (abstractTextureViewSurfaceTextureListenerC3277b != null) {
            abstractTextureViewSurfaceTextureListenerC3277b.m20821h();
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.ExpandableMenuPanel
    public void scrollToNext() {
        BaseScrollBar abstractTextureViewSurfaceTextureListenerC3277b = this.f19710g;
        if (abstractTextureViewSurfaceTextureListenerC3277b != null) {
            abstractTextureViewSurfaceTextureListenerC3277b.m20819f();
        }
    }

    @Override // com.oplus.camera.p172ui.menu.setting.ExpandableMenuPanel
    public void scrollToPrevious() {
        BaseScrollBar abstractTextureViewSurfaceTextureListenerC3277b = this.f19710g;
        if (abstractTextureViewSurfaceTextureListenerC3277b != null) {
            abstractTextureViewSurfaceTextureListenerC3277b.m20820g();
        }
    }

    public void setMenuOpen(boolean z) {
        CameraLog.m12954a("FilterEffectMenu", "setMenuOpen, menuOpen: " + z);
        this.f19717n = z;
    }

    @Override // com.oplus.camera.p172ui.menu.setting.ExpandableMenuPanel
    public boolean isEffectMenuOpen() {
        AnimatorSet animatorSet;
        return this.f19716m || this.f19717n || this.mbEnterAnimationRunning || ((animatorSet = this.f19725v) != null && animatorSet.isRunning());
    }

    @Override // com.oplus.camera.p172ui.menu.setting.ExpandableMenuPanel
    public boolean isEffectOpen() {
        PlatformImplementations.kt_3 aVar = this.f19711h;
        if (aVar != null) {
            return aVar.mo20001c();
        }
        return FilterHelper.f21279a != this.f19715l;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m20862j() {
        m20863k();
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private void m20863k() {
        PlatformImplementations.kt_3 aVar;
        if (this.f19707d == null) {
            this.f19707d = (RelativeLayout) this.f19705b.getLayoutInflater().inflate(this.f19722s, (ViewGroup) null);
            ViewGroup.LayoutParams layoutParamsM20864l = m20864l();
            PlatformImplementations.kt_3 aVar2 = this.f19711h;
            if (aVar2 != null) {
                this.f19706c.addView(this.f19707d, aVar2.mo20004f(), layoutParamsM20864l);
            } else {
                this.f19706c.addView(this.f19707d, layoutParamsM20864l);
            }
            this.f19726w = null;
            this.f19710g = (BaseScrollBar) this.f19707d.findViewById(R.id_renamed.effect_scrollbar);
            this.f19710g.setCameraEntryType(this.f19720q);
            this.f19710g.setScrollBarTextureViewCallback(new IntrinsicsJvm.kt_4());
            PlatformImplementations.kt_3 aVar3 = this.f19711h;
            if (aVar3 != null) {
                BaseScrollBar abstractTextureViewSurfaceTextureListenerC3277b = this.f19710g;
                if (abstractTextureViewSurfaceTextureListenerC3277b instanceof HorizontalScrollBar) {
                    ((HorizontalScrollBar) abstractTextureViewSurfaceTextureListenerC3277b).setRearMirrorEnable(aVar3.mo20005g());
                    return;
                }
                return;
            }
            return;
        }
        if (this.f19721r != 1 || (aVar = this.f19711h) == null) {
            return;
        }
        aVar.mo19996a(MenuClickMsgData.KEY_FILTER);
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private ViewGroup.LayoutParams m20864l() {
        int OplusGLSurfaceView_13 = this.f19723t;
        if (OplusGLSurfaceView_13 == 1) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f19705b.getResources().getDimensionPixelSize(R.dimen.vertical_effect_menu_width), this.f19705b.getResources().getDimensionPixelSize(R.dimen.vertical_effect_menu_height));
            layoutParams.topMargin = this.f19705b.getResources().getDimensionPixelSize(R.dimen.vertical_effect_menu_margin_top);
            if (270 == this.f19724u) {
                layoutParams.addRule(11);
                layoutParams.rightMargin = this.f19705b.getResources().getDimensionPixelSize(R.dimen.vertical_effect_menu_margin_left);
                return layoutParams;
            }
            layoutParams.addRule(9);
            layoutParams.leftMargin = this.f19705b.getResources().getDimensionPixelSize(R.dimen.vertical_effect_menu_margin_left);
            return layoutParams;
        }
        if (OplusGLSurfaceView_13 == 3) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, this.f19705b.getResources().getDimensionPixelSize(R.dimen.effects_menu_height));
            layoutParams2.addRule(12);
            layoutParams2.bottomMargin = this.f19705b.getResources().getDimensionPixelOffset(R.dimen.fold_split_screen_effect_menu_margin_bottom);
            return layoutParams2;
        }
        if (OplusGLSurfaceView_13 == 4) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(this.f19705b.getResources().getDimensionPixelSize(R.dimen.rack_mode_effect_filter_menu_width), this.f19705b.getResources().getDimensionPixelSize(R.dimen.rack_mode_effect_filter_menu_height));
            layoutParams3.addRule(14);
            layoutParams3.addRule(12);
            layoutParams3.bottomMargin = this.f19705b.getResources().getDimensionPixelSize(R.dimen.rack_mode_effect_filter_menu_margin_bottom);
            return layoutParams3;
        }
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, this.f19705b.getResources().getDimensionPixelSize(R.dimen.effects_menu_height));
        layoutParams4.addRule(12);
        layoutParams4.bottomMargin = Util.m24187O();
        return layoutParams4;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private void m20865m() {
        RelativeLayout relativeLayout = this.f19707d;
        if (relativeLayout != null) {
            this.f19706c.removeView(relativeLayout);
        }
        this.f19707d = (RelativeLayout) this.f19705b.getLayoutInflater().inflate(this.f19722s, (ViewGroup) null);
        ViewGroup.LayoutParams layoutParamsM20864l = m20864l();
        PlatformImplementations.kt_3 aVar = this.f19711h;
        if (aVar != null) {
            this.f19706c.addView(this.f19707d, aVar.mo20004f(), layoutParamsM20864l);
        } else {
            this.f19706c.addView(this.f19707d, layoutParamsM20864l);
        }
        this.f19726w = null;
        this.f19710g = (BaseScrollBar) this.f19707d.findViewById(R.id_renamed.effect_scrollbar);
        this.f19710g.setCameraEntryType(this.f19720q);
        this.f19710g.setScrollBarTextureViewCallback(new IntrinsicsJvm.kt_4());
        PlatformImplementations.kt_3 aVar2 = this.f19711h;
        if (aVar2 != null) {
            BaseScrollBar abstractTextureViewSurfaceTextureListenerC3277b = this.f19710g;
            if (abstractTextureViewSurfaceTextureListenerC3277b instanceof HorizontalScrollBar) {
                ((HorizontalScrollBar) abstractTextureViewSurfaceTextureListenerC3277b).setRearMirrorEnable(aVar2.mo20005g());
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20872a(List<String> list, String str, int OplusGLSurfaceView_13) {
        this.f19714k = list;
        this.f19715l = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m20876b(int OplusGLSurfaceView_13) {
        BaseScrollBar abstractTextureViewSurfaceTextureListenerC3277b = this.f19710g;
        if (abstractTextureViewSurfaceTextureListenerC3277b != null) {
            abstractTextureViewSurfaceTextureListenerC3277b.m20814b(OplusGLSurfaceView_13);
        }
    }

    public int getTextureWidth() {
        return this.f19718o;
    }

    public int getTextureHeight() {
        return this.f19719p;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m20877b(int OplusGLSurfaceView_13, int i2) {
        BaseScrollBar abstractTextureViewSurfaceTextureListenerC3277b;
        CameraLog.m12954a("FilterEffectMenu", "notifyPreviewSizeChanged, Size: " + OplusGLSurfaceView_13 + "x" + i2);
        this.f19718o = OplusGLSurfaceView_13;
        this.f19719p = i2;
        if (!isEffectMenuOpen() || (abstractTextureViewSurfaceTextureListenerC3277b = this.f19710g) == null) {
            return;
        }
        abstractTextureViewSurfaceTextureListenerC3277b.m20808a(OplusGLSurfaceView_13, i2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20870a(int OplusGLSurfaceView_13, boolean z) {
        CameraLog.m12954a("FilterEffectMenu", "setVisibility, visible: " + OplusGLSurfaceView_13 + ", isAnim: " + z + ", isEffectMenuOpen: " + isEffectMenuOpen());
        if (isEffectMenuOpen()) {
            setExpandMenuAnimation(this.f19707d, OplusGLSurfaceView_13, z);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m20889g() {
        BaseScrollBar abstractTextureViewSurfaceTextureListenerC3277b = this.f19710g;
        if (abstractTextureViewSurfaceTextureListenerC3277b != null) {
            abstractTextureViewSurfaceTextureListenerC3277b.m20805a();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m20886e(boolean z) {
        CameraLog.m12954a("FilterEffectMenu", "reShowFilterEffectMenu, isAnim: " + z);
        if (this.f19714k == null) {
            CameraLog.m12967f("FilterEffectMenu", "reShowFilterEffectMenu failed, mCurrMenuNames: " + this.f19714k);
            return;
        }
        m20885e();
        m20865m();
        this.f19710g.setFilterCategory(this.f19703B);
        if (isEffectMenuOpen()) {
            setExpandMenuAnimation(this.f19707d, 4, z);
        }
        setExpandMenuAnimation(this.f19707d, 0, z);
        setExpandMenuAnimation(this.f19710g, 0, z);
        this.f19716m = true;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m20888f(boolean z) {
        m20874a(z, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20874a(boolean z, boolean z2) {
        CameraLog.m12954a("FilterEffectMenu", "show, isAnim: " + z);
        if (this.f19714k == null) {
            CameraLog.m12967f("FilterEffectMenu", "show failed, mCurrMenuNames: " + this.f19714k);
            return;
        }
        this.f19716m = true;
        m20862j();
        this.f19710g.setFilterCategory(this.f19703B);
        this.f19710g.setAlpha(1.0f);
        if (z) {
            setExpandMenuAnimation(this.f19707d, 0, true);
            setExpandMenuAnimation(this.f19710g, 0, true);
        } else {
            setExpandMenuAnimation(this.f19707d, 0, false);
            setExpandMenuAnimation(this.f19710g, 0, false);
        }
    }

    public void setFilterCategory(FilterTexturePreview.PlatformImplementations.kt_3 aVar) {
        this.f19703B = aVar;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m20879b(boolean z, boolean z2) {
        CameraLog.m12954a("FilterEffectMenu", "hideAnimator");
        Handler handler = this.f19712i;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        setExpandMenuAnimation(this.f19710g, 4, true);
        this.f19716m = false;
        m20885e();
        PlatformImplementations.kt_3 aVar = this.f19711h;
        if (aVar != null) {
            aVar.mo19997a(z2);
        }
        super.hideMenuPanel(z, z2);
    }

    @Override // com.oplus.camera.p172ui.menu.setting.ExpandableMenuPanel
    public void hideWithoutAnim(boolean z, boolean z2) {
        CameraLog.m12954a("FilterEffectMenu", "hideWithoutAnim");
        Handler handler = this.f19712i;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (isEffectMenuOpen()) {
            setExpandMenuAnimation(this.f19710g, 4, false);
            this.f19716m = false;
            m20885e();
            super.hideMenuPanel(z, false);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean m20890h() {
        BaseScrollBar abstractTextureViewSurfaceTextureListenerC3277b = this.f19710g;
        if (abstractTextureViewSurfaceTextureListenerC3277b != null) {
            return abstractTextureViewSurfaceTextureListenerC3277b.m20818e();
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20871a(GLModelParam c3284i) {
        if (this.f19710g == null || c3284i == null) {
            return;
        }
        c3284i.m20906b(this.f19718o);
        c3284i.m20911c(this.f19719p);
        c3284i.m20927g((this.f19718o * 1.0f) / this.f19719p);
        this.f19715l = c3284i.m20933l();
        this.f19710g.m20811a(c3284i);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20869a(int OplusGLSurfaceView_13, String str) {
        BaseScrollBar abstractTextureViewSurfaceTextureListenerC3277b = this.f19710g;
        if (abstractTextureViewSurfaceTextureListenerC3277b != null) {
            abstractTextureViewSurfaceTextureListenerC3277b.m20809a(OplusGLSurfaceView_13, str);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m20881c(int OplusGLSurfaceView_13) {
        BaseScrollBar abstractTextureViewSurfaceTextureListenerC3277b = this.f19710g;
        if (abstractTextureViewSurfaceTextureListenerC3277b != null) {
            abstractTextureViewSurfaceTextureListenerC3277b.m20807a(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m20891i() {
        BaseScrollBar abstractTextureViewSurfaceTextureListenerC3277b = this.f19710g;
        if (abstractTextureViewSurfaceTextureListenerC3277b != null) {
            abstractTextureViewSurfaceTextureListenerC3277b.m20822i();
        }
    }

    protected String getAnimationTranslateProp() {
        return 1 == this.f19723t ? "translationX" : "translationY";
    }

    protected int getAnimationTranslateDistance() {
        if (1 == this.f19723t && 270 != this.f19724u) {
            return -this.mMenuTranslateY;
        }
        return this.mMenuTranslateY;
    }
}
