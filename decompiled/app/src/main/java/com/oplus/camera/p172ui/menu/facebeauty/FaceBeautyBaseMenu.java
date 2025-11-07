package com.oplus.camera.p172ui.menu.facebeauty;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.coui.appcompat.widget.COUIHintRedDot;
import com.google.android.material.badge.BadgeDrawable;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.OplusNumSeekBar;
import com.oplus.camera.p172ui.inverse.InverseManager;
import com.oplus.camera.p172ui.preview.p177a.FaceBeautyFilterListener;
import com.oplus.camera.statistics.model.MenuClickMsgData;
import com.oplus.camera.util.Util;

/* compiled from: FaceBeautyBaseMenu.java */
/* renamed from: com.oplus.camera.ui.menu.facebeauty.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public abstract class FaceBeautyBaseMenu implements View.OnClickListener {

    /* renamed from: PlatformImplementations.kt_3 */
    protected LinearLayout f19253a = null;

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected ViewGroup f19254b = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected ViewGroup f19255c = null;

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected ViewGroup f19256d = null;

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected int f19257e = 0;

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected int f19258f = 0;

    /* renamed from: COUIBaseListPopupWindow_11 */
    protected int f19259g = 150;

    /* renamed from: COUIBaseListPopupWindow_10 */
    protected boolean f19260h = false;

    /* renamed from: OplusGLSurfaceView_13 */
    protected boolean f19261i = false;

    /* renamed from: OplusGLSurfaceView_15 */
    protected boolean f19262j = false;

    /* renamed from: OplusGLSurfaceView_5 */
    protected boolean f19263k = true;

    /* renamed from: OplusGLSurfaceView_14 */
    protected boolean f19264l = true;

    /* renamed from: OplusGLSurfaceView_6 */
    protected boolean f19265m = false;

    /* renamed from: OplusGLSurfaceView_11 */
    protected FaceBeautyFilterListener f19266n = null;

    /* renamed from: o */
    protected PlatformImplementations.kt_3 f19267o = null;

    /* renamed from: p */
    protected Animator f19268p = null;

    /* renamed from: q */
    protected Animator f19269q = null;

    /* renamed from: r */
    protected Animator f19270r = null;

    /* renamed from: s */
    protected Animator f19271s = null;

    /* renamed from: t */
    protected PathInterpolator f19272t = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);

    /* renamed from: u */
    protected PathInterpolator f19273u = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);

    /* renamed from: v */
    protected int f19274v = 0;

    /* renamed from: w */
    protected int f19275w = 0;

    /* renamed from: x */
    protected int f19276x = 0;

    /* renamed from: y */
    protected Activity f19277y = null;

    /* compiled from: FaceBeautyBaseMenu.java */
    /* renamed from: com.oplus.camera.ui.menu.facebeauty.IntrinsicsJvm.kt_5$PlatformImplementations.kt_3 */
    interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        int mo20587a(int OplusGLSurfaceView_13, boolean z);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo20588a(int OplusGLSurfaceView_13);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo20589a(String str, int OplusGLSurfaceView_13, boolean z);

        /* renamed from: PlatformImplementations.kt_3 */
        int[] mo20590a(boolean z);

        /* renamed from: IntrinsicsJvm.kt_4 */
        int mo20591b();

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo20592b(boolean z);

        /* renamed from: IntrinsicsJvm.kt_3 */
        boolean mo20593c();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m20552a(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 == 1;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m20556b(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 == 2;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m20560c(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 == 3;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    protected void mo20564e(boolean z) {
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    protected void mo20566f(boolean z) {
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    protected void mo20568g(boolean z) {
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    protected void mo20570h(boolean z) {
    }

    /* renamed from: OplusGLSurfaceView_13 */
    protected void mo20572i(boolean z) {
    }

    /* renamed from: OplusGLSurfaceView_15 */
    protected void mo20574j(boolean z) {
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m20555b() {
        Animator animator;
        Animator animator2;
        Animator animator3;
        Animator animator4;
        FaceBeautyFilterListener interfaceC3409f = this.f19266n;
        return (interfaceC3409f != null && interfaceC3409f.mo20031b()) || ((animator = this.f19268p) != null && animator.isStarted()) || (((animator2 = this.f19269q) != null && animator2.isStarted()) || (((animator3 = this.f19270r) != null && animator3.isStarted()) || ((animator4 = this.f19271s) != null && animator4.isStarted())));
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected void m20558c() {
        int OplusGLSurfaceView_13;
        int i2;
        ViewGroup viewGroup;
        CameraLog.m12954a("FaceBeautyBaseMenu", "initTabLayout");
        this.f19258f = 0;
        PlatformImplementations.kt_3 aVar = this.f19267o;
        if (aVar != null) {
            this.f19258f = aVar.mo20591b();
        }
        this.f19253a.removeAllViews();
        if (this.f19260h) {
            this.f19254b = m20548a(R.id_renamed.camera_face_beauty_custom_tab_title_beauty, R.string.camera_face_beauty_custom_tab_title_beauty, true, 0);
            viewGroup = this.f19254b;
            if (this.f19258f == 0) {
                this.f19258f = 1;
            }
            OplusGLSurfaceView_13 = 1;
            i2 = 1;
        } else {
            if (this.f19254b != null) {
                this.f19254b = null;
            }
            if (1 == this.f19258f) {
                this.f19258f = 0;
            }
            OplusGLSurfaceView_13 = 0;
            i2 = 0;
            viewGroup = null;
        }
        if (this.f19261i) {
            int i3 = OplusGLSurfaceView_13 + 1;
            this.f19255c = m20548a(R.id_renamed.camera_face_beauty_custom_tab_title_makeup, R.string.camera_face_beauty_custom_tab_title_makeup, viewGroup == null, OplusGLSurfaceView_13);
            if (viewGroup == null) {
                viewGroup = this.f19255c;
                i2 = 2;
            }
            if (this.f19258f == 0) {
                this.f19258f = 2;
            }
            OplusGLSurfaceView_13 = i3;
        } else {
            if (this.f19255c != null) {
                this.f19255c = null;
            }
            if (2 == this.f19258f) {
                this.f19258f = 0;
            }
        }
        if (this.f19262j) {
            this.f19256d = m20548a(R.id_renamed.camera_face_beauty_custom_tab_title_filter_effect, R.string.camera_filter, viewGroup == null, OplusGLSurfaceView_13);
            if (viewGroup == null) {
                viewGroup = this.f19256d;
                i2 = 3;
            }
            if (this.f19258f == 0) {
                this.f19258f = 3;
            }
        } else {
            if (this.f19256d != null) {
                this.f19256d = null;
            }
            if (3 == this.f19258f) {
                this.f19258f = 0;
            }
        }
        if (!this.f19264l && this.f19256d != null && this.f19258f == 1) {
            this.f19258f = 3;
        }
        boolean z = this.f19253a.getChildCount() > 1;
        m20551a(z);
        int i4 = this.f19258f;
        if (i4 == 1) {
            ViewGroup viewGroup2 = this.f19254b;
            if (viewGroup2 != null) {
                viewGroup2.getChildAt(0).setSelected(z);
                return;
            }
            return;
        }
        if (i4 == 2) {
            ViewGroup viewGroup3 = this.f19255c;
            if (viewGroup3 != null) {
                viewGroup3.getChildAt(0).setSelected(z);
                return;
            }
            return;
        }
        if (i4 != 3) {
            if (viewGroup != null) {
                viewGroup.getChildAt(0).setSelected(z);
                this.f19258f = i2;
                return;
            }
            return;
        }
        ViewGroup viewGroup4 = this.f19256d;
        if (viewGroup4 != null) {
            viewGroup4.getChildAt(0).setSelected(z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m20551a(boolean z) {
        CameraLog.m12954a("FaceBeautyBaseMenu", "cleanTabBackground, needBackground: " + z);
        if (z || this.f19253a == null) {
            return;
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f19253a.getChildCount(); OplusGLSurfaceView_13++) {
            ((FrameLayout) this.f19253a.getChildAt(OplusGLSurfaceView_13)).getChildAt(0).setBackgroundResource(0);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected void m20554b(boolean z) {
        CameraLog.m12954a("FaceBeautyBaseMenu", "setTabFaceViewEnable, enable: " + z);
        this.f19264l = z;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    protected void m20561d() {
        CameraLog.m12954a("FaceBeautyBaseMenu", "disableFaceView, mbFaceBeautyEnable: " + this.f19264l);
        if (this.f19254b != null) {
            if (m20576k() && !this.f19264l) {
                m20563e();
            }
            if (this.f19264l) {
                this.f19254b.setAlpha(1.0f);
            } else {
                this.f19254b.setAlpha(0.5f);
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m20563e() {
        LinearLayout linearLayout;
        int childCount;
        if (this.f19256d == null || m20580m() || (linearLayout = this.f19253a) == null || (childCount = linearLayout.getChildCount()) == 1) {
            return;
        }
        m20573j();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            View childAt = ((FrameLayout) this.f19253a.getChildAt(OplusGLSurfaceView_13)).getChildAt(0);
            childAt.setSelected(this.f19256d.getChildAt(0).equals(childAt));
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m20565f() {
        CameraLog.m12954a("FaceBeautyBaseMenu", "showFilterTabRedDot");
        ViewGroup viewGroup = this.f19256d;
        if (viewGroup != null) {
            ((COUIHintRedDot) viewGroup.getChildAt(1)).setPointMode(1);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m20567g() {
        CameraLog.m12954a("FaceBeautyBaseMenu", "hideFilterTabRedDot");
        ViewGroup viewGroup = this.f19256d;
        if (viewGroup != null) {
            ((COUIHintRedDot) viewGroup.getChildAt(1)).setPointMode(0);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20550a(FaceBeautyFilterListener interfaceC3409f) {
        this.f19266n = interfaceC3409f;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected ViewGroup m20548a(int OplusGLSurfaceView_13, int i2, boolean z, int i3) throws Resources.NotFoundException {
        int dimensionPixelOffset;
        int dimensionPixelOffset2;
        LinearLayout linearLayout = this.f19253a;
        if (linearLayout == null) {
            return null;
        }
        Context context = linearLayout.getContext();
        Resources resources = context.getResources();
        ColorStateList colorStateList = context.getColorStateList(R.color.face_beauty_text_color);
        if (m20586r() == 0) {
            dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.face_beauty_custom_tab_text_left_right_spacing);
            dimensionPixelOffset2 = resources.getDimensionPixelOffset(R.dimen.face_beauty_custom_tab_text_margin_start);
        } else {
            dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.vertical_face_beauty_custom_tab_text_left_right_spacing);
            dimensionPixelOffset2 = resources.getDimensionPixelOffset(R.dimen.vertical_face_beauty_custom_tab_text_margin_top);
        }
        float dimension = resources.getDimension(R.dimen.face_beauty_custom_tab_text_size);
        int dimensionPixelOffset3 = resources.getDimensionPixelOffset(R.dimen.face_beauty_custom_tab_text_top_bottom_spacing);
        int dimensionPixelOffset4 = resources.getDimensionPixelOffset(R.dimen.face_beauty_custom_tab_text_top_spacing);
        int dimensionPixelOffset5 = resources.getDimensionPixelOffset(R.dimen.face_beauty_custom_tab_text_height);
        int dimensionPixelOffset6 = resources.getDimensionPixelOffset(R.dimen.face_beauty_custom_red_dot_diameter);
        TabContainerTextView tabContainerTextView = new TabContainerTextView(context);
        tabContainerTextView.setId(OplusGLSurfaceView_13);
        tabContainerTextView.setText(i2);
        tabContainerTextView.setTextColor(colorStateList);
        tabContainerTextView.setBackgroundResource(R.drawable.face_beauty_custom_tab_text_bg);
        tabContainerTextView.setTextSize(0, dimension);
        tabContainerTextView.setGravity(17);
        tabContainerTextView.setTypeface(Util.m24411c(true));
        if (1 == this.f19275w) {
            tabContainerTextView.setMaxLines(2);
        } else {
            tabContainerTextView.setSingleLine(true);
        }
        InverseManager.INS.registerInverse(context, tabContainerTextView);
        if (1 == this.f19275w) {
            dimensionPixelOffset5 = -2;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, dimensionPixelOffset5);
        tabContainerTextView.setPadding(dimensionPixelOffset, dimensionPixelOffset4, dimensionPixelOffset, dimensionPixelOffset3);
        tabContainerTextView.setOnClickListener(this);
        if (!z) {
            if (m20586r() == 0) {
                layoutParams.setMarginStart(dimensionPixelOffset2);
            } else {
                layoutParams.topMargin = dimensionPixelOffset2;
            }
        }
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.addView(tabContainerTextView);
        COUIHintRedDot cOUIHintRedDot = new COUIHintRedDot(context);
        cOUIHintRedDot.setPointMode(0);
        cOUIHintRedDot.setDotDiameter(dimensionPixelOffset6);
        frameLayout.addView(cOUIHintRedDot, new FrameLayout.LayoutParams(-2, -2, BadgeDrawable.TOP_END));
        this.f19253a.addView(frameLayout, i3, layoutParams);
        return frameLayout;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    protected void m20569h() {
        if (m20576k()) {
            return;
        }
        CameraLog.m12959b("FaceBeautyBaseMenu", "tabBeautyClick");
        this.f19267o.mo20593c();
        m20581n();
        this.f19259g = 200;
        mo20564e(true);
        this.f19267o.mo20589a(MenuClickMsgData.KEY_SMOOTH, 0, false);
        this.f19267o.mo20588a(this.f19257e);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    protected void m20571i() {
        if (m20578l()) {
            return;
        }
        CameraLog.m12959b("FaceBeautyBaseMenu", "tabMakeupClick");
        m20581n();
        this.f19259g = 200;
        mo20570h(true);
        this.f19267o.mo20589a(MenuClickMsgData.KEY_MAKEUP, 0, false);
        this.f19267o.mo20588a(this.f19257e);
    }

    /* renamed from: OplusGLSurfaceView_15 */
    protected void m20573j() {
        if (m20580m()) {
            return;
        }
        CameraLog.m12959b("FaceBeautyBaseMenu", "tabFilterClick");
        m20581n();
        this.f19259g = 200;
        FaceBeautyFilterListener interfaceC3409f = this.f19266n;
        if (interfaceC3409f != null) {
            interfaceC3409f.mo20028a(200);
        }
        m20575k(true);
        this.f19267o.mo20589a(MenuClickMsgData.KEY_FILTER, 0, false);
        this.f19267o.mo20588a(this.f19257e);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected Animator m20547a(final View view, boolean z) {
        CameraLog.m12954a("FaceBeautyBaseMenu", "showViews, view: " + view + ", needAnim: " + z);
        AnimatorSet animatorSet = new AnimatorSet();
        if (view == null) {
            return animatorSet;
        }
        if (z) {
            view.setVisibility(0);
            view.setAlpha(0.0f);
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
            objectAnimatorOfFloat.setInterpolator(this.f19272t);
            objectAnimatorOfFloat.setDuration(350L);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, m20583o(), m20584p(), 0.0f);
            objectAnimatorOfFloat2.setInterpolator(this.f19273u);
            objectAnimatorOfFloat2.setDuration(350L);
            animatorSet.play(objectAnimatorOfFloat2).with(objectAnimatorOfFloat);
            animatorSet.setStartDelay(this.f19259g);
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.menu.facebeauty.IntrinsicsJvm.kt_5.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    view.setVisibility(0);
                    view.setAlpha(0.0f);
                }
            });
            animatorSet.start();
        } else {
            view.setVisibility(0);
            view.setAlpha(1.0f);
        }
        view.setEnabled(true);
        return animatorSet;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    protected Animator m20553b(final View view, boolean z) {
        CameraLog.m12954a("FaceBeautyBaseMenu", "hideViews, view: " + view + ", needAnim: " + z);
        AnimatorSet animatorSet = new AnimatorSet();
        if (view == null) {
            return animatorSet;
        }
        if (z) {
            view.setAlpha(1.0f);
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
            objectAnimatorOfFloat.setInterpolator(this.f19272t);
            objectAnimatorOfFloat.setDuration(250L);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 0.9f);
            objectAnimatorOfFloat2.setInterpolator(this.f19273u);
            objectAnimatorOfFloat2.setDuration(400L);
            objectAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.menu.facebeauty.IntrinsicsJvm.kt_5.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    view.postInvalidate();
                }
            });
            ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 0.9f);
            objectAnimatorOfFloat3.setInterpolator(this.f19273u);
            objectAnimatorOfFloat3.setDuration(400L);
            animatorSet.play(objectAnimatorOfFloat2).with(objectAnimatorOfFloat3).with(objectAnimatorOfFloat);
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.menu.facebeauty.IntrinsicsJvm.kt_5.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    view.setVisibility(0);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    view.setVisibility(8);
                    view.setScaleY(1.0f);
                    view.setScaleX(1.0f);
                }
            });
            animatorSet.start();
        } else {
            view.setVisibility(8);
            view.setScaleY(1.0f);
            view.setScaleX(1.0f);
        }
        m20549a(view);
        view.setEnabled(false);
        return animatorSet;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    protected Animator m20557c(final View view, boolean z) {
        CameraLog.m12954a("FaceBeautyBaseMenu", "hideViews, view: " + view + ", needAnim: " + z);
        AnimatorSet animatorSet = new AnimatorSet();
        if (view == null) {
            return animatorSet;
        }
        if (z) {
            view.setAlpha(1.0f);
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, m20583o(), 0.0f, m20584p());
            objectAnimatorOfFloat.setInterpolator(this.f19273u);
            objectAnimatorOfFloat.setDuration(400L);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
            objectAnimatorOfFloat2.setInterpolator(this.f19272t);
            objectAnimatorOfFloat2.setDuration(250L);
            animatorSet.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.menu.facebeauty.IntrinsicsJvm.kt_5.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    FaceBeautyBaseMenu.this.f19263k = false;
                    view.setVisibility(0);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    FaceBeautyBaseMenu.this.f19263k = true;
                    view.setVisibility(8);
                }
            });
            animatorSet.start();
        } else {
            view.setVisibility(8);
        }
        m20549a(view);
        view.setEnabled(false);
        return animatorSet;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int childCount;
        LinearLayout linearLayout = this.f19253a;
        if (linearLayout != null && (childCount = linearLayout.getChildCount()) != 1 && this.f19265m && this.f19263k) {
            switch (view.getId()) {
                case R.id_renamed.camera_face_beauty_custom_tab_title_beauty /* 2131296414 */:
                    if (this.f19264l) {
                        m20569h();
                        break;
                    } else {
                        return;
                    }
                case R.id_renamed.camera_face_beauty_custom_tab_title_filter_effect /* 2131296415 */:
                    m20573j();
                    break;
                case R.id_renamed.camera_face_beauty_custom_tab_title_makeup /* 2131296416 */:
                    m20571i();
                    break;
            }
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
                View childAt = ((FrameLayout) this.f19253a.getChildAt(OplusGLSurfaceView_13)).getChildAt(0);
                childAt.setSelected(view.equals(childAt));
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public boolean m20576k() {
        return m20552a(this.f19257e);
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public boolean m20578l() {
        boolean zM20556b = m20556b(this.f19257e);
        CameraLog.m12962c("FaceBeautyBaseMenu", "isMakeupShown, " + zM20556b);
        return zM20556b;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public boolean m20580m() {
        return m20560c(this.f19257e);
    }

    /* renamed from: OplusGLSurfaceView_11 */
    protected void m20581n() {
        Animator animator = this.f19268p;
        if (animator != null && animator.isStarted()) {
            this.f19268p.cancel();
        }
        Animator animator2 = this.f19269q;
        if (animator2 != null && animator2.isStarted()) {
            this.f19269q.cancel();
        }
        Animator animator3 = this.f19270r;
        if (animator3 != null && animator3.isStarted()) {
            this.f19270r.cancel();
        }
        Animator animator4 = this.f19271s;
        if (animator4 == null || !animator4.isStarted()) {
            return;
        }
        this.f19271s.cancel();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m20549a(View view) {
        if ((view instanceof OplusNumSeekBar) && ((OplusNumSeekBar) view).m18324c()) {
            CameraLog.m12954a("FaceBeautyBaseMenu", "moving seekBar dispatchTouchEvent cancel");
            long jUptimeMillis = SystemClock.uptimeMillis();
            view.dispatchTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m20559c(boolean z) {
        this.f19265m = true;
        m20581n();
        this.f19259g = 150;
        FaceBeautyFilterListener interfaceC3409f = this.f19266n;
        if (interfaceC3409f != null) {
            interfaceC3409f.mo20028a(150);
        }
        int OplusGLSurfaceView_13 = this.f19258f;
        if (OplusGLSurfaceView_13 == 1) {
            mo20564e(z);
        } else if (OplusGLSurfaceView_13 == 2) {
            mo20570h(z);
        } else if (OplusGLSurfaceView_13 == 3) {
            m20575k(z);
        }
        ViewGroup viewGroup = this.f19254b;
        if (viewGroup != null) {
            if (this.f19264l) {
                viewGroup.setAlpha(1.0f);
            } else {
                viewGroup.setAlpha(0.5f);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m20562d(boolean z) {
        this.f19265m = false;
        m20581n();
        if (m20576k()) {
            mo20568g(z);
        }
        if (m20578l()) {
            mo20574j(z);
        }
        if (m20580m()) {
            m20579m(z);
        }
    }

    /* renamed from: o */
    protected String m20583o() {
        return 1 == this.f19275w ? "translationX" : "translationY";
    }

    /* renamed from: p */
    protected int m20584p() {
        if (1 == this.f19275w && 270 != this.f19276x) {
            return -this.f19274v;
        }
        return this.f19274v;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    protected void m20575k(boolean z) {
        CameraLog.m12954a("FaceBeautyBaseMenu", "showFilterEffect, needAnimation: " + z);
        if (m20578l()) {
            mo20572i(z);
        }
        if (m20576k()) {
            mo20566f(z);
        }
        this.f19257e = 3;
        this.f19267o.mo20592b(m20578l());
        FaceBeautyFilterListener interfaceC3409f = this.f19266n;
        if (interfaceC3409f != null) {
            interfaceC3409f.mo20029a(z);
        }
    }

    /* renamed from: OplusGLSurfaceView_14 */
    protected void m20577l(boolean z) {
        FaceBeautyFilterListener interfaceC3409f = this.f19266n;
        if (interfaceC3409f != null) {
            interfaceC3409f.mo20030b(z);
        }
    }

    /* renamed from: OplusGLSurfaceView_6 */
    protected void m20579m(boolean z) {
        FaceBeautyFilterListener interfaceC3409f = this.f19266n;
        if (interfaceC3409f != null) {
            interfaceC3409f.mo20032c(z);
        }
    }

    /* renamed from: q */
    public View mo20585q() {
        return this.f19253a;
    }

    /* renamed from: r */
    protected int m20586r() {
        return this.f19275w != 1 ? 0 : 1;
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public void m20582n(boolean z) {
        this.f19263k = z;
    }
}
