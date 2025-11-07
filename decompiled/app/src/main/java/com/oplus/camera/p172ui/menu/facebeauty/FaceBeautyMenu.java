package com.oplus.camera.p172ui.menu.facebeauty;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraFunction;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.CameraUIListener;
import com.oplus.camera.p172ui.OplusNumAISeekBar;
import com.oplus.camera.p172ui.OplusNumSeekBar;
import com.oplus.camera.p172ui.menu.facebeauty.FaceBeautyBaseMenu;
import com.oplus.camera.p172ui.menu.facebeauty.FaceBeautyCustomMenu;
import com.oplus.camera.p172ui.preview.p177a.FaceBeautyFilterListener;
import com.oplus.camera.statistics.CameraStatisticsUtil;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.statistics.model.MenuClickMsgData;
import com.oplus.camera.util.ToastUtil;
import com.oplus.camera.util.Util;

/* compiled from: FaceBeautyMenu.java */
/* renamed from: com.oplus.camera.ui.menu.facebeauty.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public class FaceBeautyMenu implements View.OnClickListener, OplusNumSeekBar.InterfaceC3101a, FaceBeautyBaseMenu.PlatformImplementations.kt_3, FaceBeautyCustomMenu.PlatformImplementations.kt_3 {

    /* renamed from: PlatformImplementations.kt_3 */
    private int f19335a;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f19337c;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private CameraUIListener f19340f;

    /* renamed from: t */
    private Activity f19354t;

    /* renamed from: u */
    private PlatformImplementations.kt_3 f19355u;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f19336b = 0;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f19338d = 0;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f19339e = 0;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f19341g = 0;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f19342h = 0;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f19343i = 0;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f19344j = 0;

    /* renamed from: OplusGLSurfaceView_5 */
    private int[] f19345k = {0, 0, 0, 0, 0, 0, 0, 0};

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f19346l = false;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f19347m = false;

    /* renamed from: OplusGLSurfaceView_11 */
    private boolean f19348n = false;

    /* renamed from: o */
    private boolean f19349o = false;

    /* renamed from: p */
    private boolean f19350p = false;

    /* renamed from: q */
    private boolean f19351q = true;

    /* renamed from: r */
    private PathInterpolator f19352r = new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);

    /* renamed from: s */
    private PathInterpolator f19353s = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);

    /* renamed from: v */
    private FaceBeautyCustomMenu f19356v = null;

    /* renamed from: w */
    private FaceBeautyCommonMenu f19357w = null;

    /* renamed from: x */
    private AnimatorSet f19358x = null;

    /* renamed from: y */
    private AnimatorSet f19359y = null;

    /* renamed from: z */
    private AnimatorSet f19360z = null;

    /* renamed from: A */
    private AnimatorSet f19327A = null;

    /* renamed from: B */
    private FaceBeautyFilterListener f19328B = null;

    /* renamed from: C */
    private int f19329C = 0;

    /* renamed from: D */
    private int f19330D = 0;

    /* renamed from: E */
    private boolean f19331E = true;

    /* renamed from: F */
    private boolean f19332F = true;

    /* renamed from: G */
    private boolean f19333G = false;

    /* renamed from: H */
    private AnimatorListenerAdapter f19334H = new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.menu.facebeauty.COUIBaseListPopupWindow_11.1
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (FaceBeautyMenu.this.f19346l) {
                if (1 == FaceBeautyMenu.this.f19336b) {
                    FaceBeautyMenu.this.f19356v.m20627y().setVisibility(0);
                    FaceBeautyMenu.this.f19356v.mo20585q().setVisibility(0);
                    FaceBeautyMenu.this.f19356v.m20627y().setAlpha(1.0f);
                    FaceBeautyMenu.this.f19356v.mo20585q().setAlpha(0.0f);
                    return;
                }
                if (2 == FaceBeautyMenu.this.f19336b) {
                    FaceBeautyMenu.this.f19357w.m20599s().setVisibility(0);
                    FaceBeautyMenu.this.f19357w.mo20585q().setVisibility(0);
                    FaceBeautyMenu.this.f19357w.m20600t().setVisibility(8);
                    FaceBeautyMenu.this.f19357w.m20599s().setAlpha(1.0f);
                    FaceBeautyMenu.this.f19357w.mo20585q().setAlpha(0.0f);
                    FaceBeautyMenu.this.f19357w.m20600t().setAlpha(0.0f);
                }
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (FaceBeautyMenu.this.f19346l) {
                return;
            }
            FaceBeautyMenu viewOnClickListenerC3261g = FaceBeautyMenu.this;
            viewOnClickListenerC3261g.m20641a(viewOnClickListenerC3261g.m20664y());
        }
    };

    /* compiled from: FaceBeautyMenu.java */
    /* renamed from: com.oplus.camera.ui.menu.facebeauty.COUIBaseListPopupWindow_11$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        int mo20045a(int OplusGLSurfaceView_13);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo20046a();

        /* renamed from: PlatformImplementations.kt_3 */
        void mo20047a(int OplusGLSurfaceView_13, int i2, boolean z);

        /* renamed from: PlatformImplementations.kt_3 */
        void mo20048a(View view);

        /* renamed from: IntrinsicsJvm.kt_4 */
        int mo20049b();

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo20050b(int OplusGLSurfaceView_13);

        /* renamed from: IntrinsicsJvm.kt_3 */
        int mo20051c(int OplusGLSurfaceView_13);

        /* renamed from: IntrinsicsJvm.kt_3 */
        boolean mo20052c();

        /* renamed from: IntrinsicsJvm.kt_5 */
        int mo20053d();

        /* renamed from: IntrinsicsJvm.kt_5 */
        void mo20054d(int OplusGLSurfaceView_13);

        /* renamed from: COUIBaseListPopupWindow_8 */
        int[] mo20055e();

        /* renamed from: COUIBaseListPopupWindow_12 */
        int[] mo20056f();

        /* renamed from: COUIBaseListPopupWindow_11 */
        void mo20057g();

        /* renamed from: COUIBaseListPopupWindow_10 */
        int mo20058h();
    }

    public FaceBeautyMenu(Activity activity, PlatformImplementations.kt_3 aVar, int OplusGLSurfaceView_13, CameraUIListener cameraUIListener) {
        this.f19335a = 0;
        this.f19340f = null;
        this.f19354t = null;
        this.f19355u = null;
        this.f19354t = activity;
        Util.m24489q(this.f19354t);
        this.f19355u = aVar;
        this.f19337c = OplusGLSurfaceView_13;
        this.f19340f = cameraUIListener;
        this.f19335a = activity.getApplicationContext().getResources().getDimensionPixelSize(R.dimen.face_beauty_menu_translate_y);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public int m20674e() {
        return this.f19336b;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public View m20668b(int OplusGLSurfaceView_13) {
        BeautyMenuInterface interfaceC3255aM20664y;
        CameraLog.m12962c("FaceBeautyMenu", "getLayout, menuType: " + OplusGLSurfaceView_13 + ", mMenuType: " + this.f19336b);
        int i2 = this.f19336b;
        this.f19336b = OplusGLSurfaceView_13;
        if (i2 != this.f19336b && (interfaceC3255aM20664y = m20664y()) != null) {
            interfaceC3255aM20664y.mo20527a();
        }
        int i3 = this.f19336b;
        if (i3 == 1) {
            if (this.f19356v == null || this.f19331E) {
                FaceBeautyCustomMenu c3260f = this.f19356v;
                if (c3260f != null) {
                    c3260f.mo20527a();
                }
                this.f19356v = new FaceBeautyCustomMenu(this.f19354t, this, this, this, this, this.f19328B, this.f19329C, this.f19330D);
                this.f19331E = false;
            }
            return this.f19356v.m20627y();
        }
        if (i3 != 2) {
            return null;
        }
        if (this.f19357w == null || this.f19332F) {
            FaceBeautyCommonMenu c3259e = this.f19357w;
            if (c3259e != null) {
                c3259e.mo20527a();
            }
            this.f19357w = new FaceBeautyCommonMenu(this.f19354t, this, this, this.f19329C, this.f19330D);
            this.f19357w.m20550a(this.f19328B);
            this.f19332F = false;
        }
        return this.f19357w.m20599s();
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m20677f() {
        int OplusGLSurfaceView_13 = this.f19336b;
        if (OplusGLSurfaceView_13 == 1) {
            this.f19356v.m20565f();
        } else {
            if (OplusGLSurfaceView_13 != 2) {
                return;
            }
            this.f19357w.m20565f();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m20680g() {
        int OplusGLSurfaceView_13 = this.f19336b;
        if (OplusGLSurfaceView_13 == 1) {
            this.f19356v.m20567g();
        } else {
            if (OplusGLSurfaceView_13 != 2) {
                return;
            }
            this.f19357w.m20567g();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean m20683h() {
        return this.f19351q;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m20671c(boolean z) {
        FaceBeautyCommonMenu c3259e;
        this.f19351q = z;
        int OplusGLSurfaceView_13 = this.f19336b;
        if (OplusGLSurfaceView_13 != 1) {
            if (OplusGLSurfaceView_13 == 2 && (c3259e = this.f19357w) != null) {
                c3259e.m20554b(this.f19351q);
                this.f19357w.m20561d();
                return;
            }
            return;
        }
        FaceBeautyCustomMenu c3260f = this.f19356v;
        if (c3260f != null) {
            c3260f.m20554b(this.f19351q);
            this.f19356v.m20561d();
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public ViewGroup.LayoutParams m20684i() {
        int OplusGLSurfaceView_13 = this.f19336b;
        if (OplusGLSurfaceView_13 == 1) {
            return this.f19356v.m20612a(this.f19329C, this.f19330D);
        }
        if (OplusGLSurfaceView_13 != 2) {
            return null;
        }
        return this.f19357w.m20598b(this.f19329C, this.f19330D);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m20673d(boolean z) {
        CameraLog.m12954a("FaceBeautyMenu", "setMenuOpen, menuOpen: " + z);
        this.f19346l = z;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m20670c(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("FaceBeautyMenu", "setProperCameraId, cameraId: " + OplusGLSurfaceView_13);
        this.f19338d = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20666a(int OplusGLSurfaceView_13, int i2) {
        this.f19329C = OplusGLSurfaceView_13;
        this.f19330D = i2;
        this.f19332F = true;
        this.f19331E = true;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m20676e(boolean z) {
        CameraLog.m12954a("FaceBeautyMenu", "open, needAnim: " + z + ", mMenuType: " + this.f19336b);
        int OplusGLSurfaceView_13 = this.f19336b;
        if (OplusGLSurfaceView_13 == 1) {
            m20660i(z);
        } else {
            if (OplusGLSurfaceView_13 != 2) {
                return;
            }
            m20662k(z);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m20679f(boolean z) {
        CameraLog.m12954a("FaceBeautyMenu", "close, needAnim: " + z);
        m20638a(this.f19358x);
        m20638a(this.f19360z);
        int OplusGLSurfaceView_13 = this.f19336b;
        if (OplusGLSurfaceView_13 == 1) {
            m20661j(z);
        } else {
            if (OplusGLSurfaceView_13 != 2) {
                return;
            }
            if (this.f19340f.mo10814c() && this.f19355u.mo20049b() == 0) {
                this.f19350p = true;
            }
            m20663l(z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m20638a(Animator animator) {
        if (animator == null || !animator.isStarted()) {
            return;
        }
        animator.cancel();
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public boolean m20685j() {
        if (1 == this.f19336b) {
            FaceBeautyCustomMenu c3260f = this.f19356v;
            return c3260f != null && c3260f.m20580m();
        }
        FaceBeautyCommonMenu c3259e = this.f19357w;
        return c3259e != null && c3259e.m20580m();
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m20681g(boolean z) {
        this.f19350p = z;
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public void m20686k() {
        FaceBeautyCustomMenu c3260f;
        if (1 == this.f19336b && (c3260f = this.f19356v) != null && this.f19347m) {
            c3260f.m20613a(0, true, false);
            this.f19356v.m20628z().scrollTo(0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y */
    public BeautyMenuInterface m20664y() {
        int OplusGLSurfaceView_13 = this.f19336b;
        if (OplusGLSurfaceView_13 == 1) {
            return this.f19356v;
        }
        if (OplusGLSurfaceView_13 != 2) {
            return null;
        }
        return this.f19357w;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public boolean m20687l() {
        FaceBeautyCustomMenu c3260f = this.f19356v;
        if (c3260f != null) {
            return c3260f.m20622t();
        }
        return true;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public boolean m20688m() {
        AnimatorSet animatorSet;
        AnimatorSet animatorSet2;
        AnimatorSet animatorSet3;
        FaceBeautyFilterListener interfaceC3409f;
        FaceBeautyCommonMenu c3259e;
        FaceBeautyCustomMenu c3260f;
        AnimatorSet animatorSet4 = this.f19358x;
        return (animatorSet4 != null && animatorSet4.isStarted()) || ((animatorSet = this.f19359y) != null && animatorSet.isStarted()) || (((animatorSet2 = this.f19360z) != null && animatorSet2.isStarted()) || (((animatorSet3 = this.f19327A) != null && animatorSet3.isStarted()) || (((interfaceC3409f = this.f19328B) != null && interfaceC3409f.mo20031b()) || (((c3259e = this.f19357w) != null && c3259e.m20555b()) || ((c3260f = this.f19356v) != null && c3260f.m20555b())))));
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public boolean m20689n() {
        return this.f19346l;
    }

    /* renamed from: o */
    public boolean m20690o() {
        FaceBeautyCommonMenu c3259e;
        return this.f19336b == 2 && (c3259e = this.f19357w) != null && c3259e.m20576k();
    }

    /* renamed from: p */
    public void m20691p() {
        m20637F();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(final View view) {
        if (m20688m()) {
            CameraLog.m12966e("FaceBeautyMenu", "onClick, isAnimationRunning");
        }
        if (this.f19356v.m20609A().m18324c()) {
            CameraLog.m12966e("FaceBeautyMenu", "onClick, isThumbOnDragging so return");
            return;
        }
        RecyclerView.AbstractC0698n abstractC0698n = null;
        switch (view.getId()) {
            case R.id_renamed.face_beauty_none /* 2131296622 */:
                CameraLog.m12954a("FaceBeautyMenu", "onClick, close face beauty");
                boolean z = this.f19347m;
                if (z) {
                    abstractC0698n = new RecyclerView.AbstractC0698n() { // from class: com.oplus.camera.ui.menu.facebeauty.COUIBaseListPopupWindow_11.2
                        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0698n
                        public void onScrollStateChanged(RecyclerView recyclerView, int OplusGLSurfaceView_13) {
                            if (OplusGLSurfaceView_13 == 0) {
                                FaceBeautyMenu.this.f19355u.mo20048a(view);
                            }
                        }
                    };
                    m20640a((View) this.f19356v.m20609A(), false);
                    m20633B();
                    this.f19356v.m20619o(false);
                    this.f19356v.m20620p(true);
                    this.f19356v.m20613a(-3, false, false);
                } else {
                    m20632A();
                    m20639a(this.f19356v.m20609A());
                    this.f19356v.m20624v();
                    this.f19356v.m20620p(m20635D());
                    this.f19356v.m20613a(0, false, false);
                    this.f19356v.m20614a(this.f19355u.mo20045a(0), this.f19355u.mo20055e());
                }
                boolean zM20617a = this.f19356v.m20617a(1, abstractC0698n);
                if (z && !zM20617a) {
                    this.f19355u.mo20048a(view);
                }
                mo20589a(MenuClickMsgData.KEY_NONE_SMOOTH, 0, true);
                break;
            case R.id_renamed.face_beauty_reset /* 2131296623 */:
                CameraLog.m12954a("FaceBeautyMenu", "onClick, reset face beauty");
                if (this.f19347m && !m20635D()) {
                    m20665z();
                }
                this.f19356v.m20617a(0, (RecyclerView.AbstractC0698n) null);
                break;
        }
    }

    /* renamed from: z */
    private void m20665z() {
        ToastUtil.m24640a(this.f19354t, R.string.camera_face_beauty_menu_reset_toast);
        this.f19355u.mo20046a();
        this.f19356v.m20615a(true, true);
        this.f19356v.m20613a(0, false, false);
        this.f19356v.m20614a(this.f19355u.mo20045a(0), this.f19355u.mo20055e());
        this.f19342h++;
        mo20589a(MenuClickMsgData.KEY_RESET_SMOOTH, 0, true);
    }

    /* renamed from: q */
    public void m20692q() {
        this.f19356v.m20616a(m20694s(), m20695t(), m20693r(), this.f19340f.mo10726ae(), this.f19340f.mo10728ag());
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m20669b(final int OplusGLSurfaceView_13, final boolean z) {
        this.f19340f.onMakeupTypeChanged(OplusGLSurfaceView_13, z);
        Activity activity = this.f19354t;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.ui.menu.facebeauty.COUIBaseListPopupWindow_11.3
                @Override // java.lang.Runnable
                public void run() {
                    if (FaceBeautyMenu.this.f19356v != null) {
                        FaceBeautyMenu.this.f19356v.m20613a(OplusGLSurfaceView_13, false, true);
                        if (FaceBeautyMenu.this.f19348n && FaceBeautyMenu.this.m20689n()) {
                            if (OplusGLSurfaceView_13 == 0) {
                                if (FaceBeautyMenu.this.f19349o) {
                                    FaceBeautyMenu.this.f19349o = false;
                                    FaceBeautyMenu viewOnClickListenerC3261g = FaceBeautyMenu.this;
                                    viewOnClickListenerC3261g.m20640a((View) viewOnClickListenerC3261g.f19356v.m20609A(), false);
                                }
                            } else {
                                if (!FaceBeautyMenu.this.f19349o) {
                                    FaceBeautyMenu.this.f19349o = true;
                                    FaceBeautyMenu viewOnClickListenerC3261g2 = FaceBeautyMenu.this;
                                    viewOnClickListenerC3261g2.m20639a(viewOnClickListenerC3261g2.f19356v.m20609A());
                                    FaceBeautyMenu.this.f19356v.m20624v();
                                } else if (!FaceBeautyMenu.this.f19356v.m20609A().isShown()) {
                                    FaceBeautyMenu viewOnClickListenerC3261g3 = FaceBeautyMenu.this;
                                    viewOnClickListenerC3261g3.m20639a(viewOnClickListenerC3261g3.f19356v.m20609A());
                                    FaceBeautyMenu.this.f19356v.m20624v();
                                }
                                FaceBeautyMenu.this.f19356v.m20618b(FaceBeautyMenu.this.f19355u.mo20051c(OplusGLSurfaceView_13), FaceBeautyMenu.this.f19355u.mo20056f());
                            }
                            if (1 == FaceBeautyMenu.this.f19356v.m20626x().get(OplusGLSurfaceView_13).m20531d() && z) {
                                FaceBeautyMenu.this.f19340f.mo10679a(R.string.camera_beauty_makeup_tips, -1, true, false, false, false);
                            }
                        }
                    }
                    if (z) {
                        FaceBeautyMenu viewOnClickListenerC3261g4 = FaceBeautyMenu.this;
                        viewOnClickListenerC3261g4.m20650b(OplusGLSurfaceView_13, viewOnClickListenerC3261g4.f19355u.mo20051c(OplusGLSurfaceView_13));
                    }
                    FaceBeautyMenu.this.f19355u.mo20057g();
                }
            });
        }
    }

    @Override // com.oplus.camera.p172ui.menu.facebeauty.FaceBeautyCustomMenu.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo20629a(View view, int OplusGLSurfaceView_13) {
        CameraLog.m12954a("FaceBeautyMenu", "onItemClick, position: " + OplusGLSurfaceView_13 + ", mMenuType: " + this.f19336b + ", mbCurrentTapMakeup: " + this.f19348n);
        if (m20688m()) {
            CameraLog.m12966e("FaceBeautyMenu", "onItemClick, isAnimationRunning");
            return;
        }
        if (this.f19356v.m20609A().m18324c()) {
            CameraLog.m12966e("FaceBeautyMenu", "onItemClick, isThumbOnDragging");
            this.f19356v.m20609A().m18322b();
            return;
        }
        if (1 == this.f19336b) {
            if (this.f19348n) {
                m20669b(OplusGLSurfaceView_13, true);
                this.f19356v.m20613a(OplusGLSurfaceView_13, true, this.f19348n);
                this.f19340f.onMakeupTypeChanged(OplusGLSurfaceView_13, true);
                if (OplusGLSurfaceView_13 == 0) {
                    if (this.f19349o) {
                        this.f19349o = false;
                        m20640a((View) this.f19356v.m20609A(), false);
                    }
                } else {
                    if (!this.f19349o) {
                        this.f19349o = true;
                        m20639a(this.f19356v.m20609A());
                        this.f19356v.m20624v();
                    }
                    this.f19356v.m20618b(this.f19355u.mo20051c(OplusGLSurfaceView_13), this.f19355u.mo20056f());
                }
                m20650b(OplusGLSurfaceView_13, this.f19355u.mo20051c(OplusGLSurfaceView_13));
                return;
            }
            int i2 = OplusGLSurfaceView_13 - 2;
            int iMo20045a = this.f19355u.mo20045a(i2);
            mo20589a(MenuClickMsgData.KEY_COMMON_CUSTOM_BEAUTY[i2], iMo20045a, !this.f19347m);
            if (!this.f19347m) {
                m20632A();
                m20639a(this.f19356v.m20609A());
                this.f19356v.m20624v();
                this.f19356v.m20620p(m20635D());
            }
            this.f19356v.m20613a(i2, true, this.f19348n);
            this.f19356v.m20614a(iMo20045a, this.f19355u.mo20055e());
            int[] iArr = this.f19345k;
            if (i2 < iArr.length) {
                iArr[i2] = iArr[i2] + 1;
            }
        }
    }

    @Override // com.oplus.camera.p172ui.OplusNumSeekBar.InterfaceC3101a
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18328a(OplusNumSeekBar oplusNumSeekBar, int OplusGLSurfaceView_13, boolean z) {
        m20653c(OplusGLSurfaceView_13, false);
    }

    @Override // com.oplus.camera.p172ui.OplusNumSeekBar.InterfaceC3101a
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo18327a(OplusNumSeekBar oplusNumSeekBar, int OplusGLSurfaceView_13) {
        FaceBeautyCommonMenu c3259e = this.f19357w;
        if (c3259e != null) {
            c3259e.m20582n(false);
            return;
        }
        FaceBeautyCustomMenu c3260f = this.f19356v;
        if (c3260f != null) {
            c3260f.m20582n(false);
        }
    }

    @Override // com.oplus.camera.p172ui.OplusNumSeekBar.InterfaceC3101a
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo18330b(OplusNumSeekBar oplusNumSeekBar, int OplusGLSurfaceView_13) {
        m20653c(OplusGLSurfaceView_13, true);
        if (1 == this.f19336b) {
            this.f19356v.m20620p(m20635D());
        }
        FaceBeautyCommonMenu c3259e = this.f19357w;
        if (c3259e != null) {
            c3259e.m20582n(true);
            return;
        }
        FaceBeautyCustomMenu c3260f = this.f19356v;
        if (c3260f != null) {
            c3260f.m20582n(true);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m20653c(int OplusGLSurfaceView_13, boolean z) {
        int i2 = this.f19336b;
        if (1 != i2) {
            if (2 == i2) {
                this.f19355u.mo20047a(0, OplusGLSurfaceView_13, z);
                if (!this.f19347m && OplusGLSurfaceView_13 != 0) {
                    m20632A();
                    return;
                } else {
                    if (this.f19347m && OplusGLSurfaceView_13 == 0) {
                        m20633B();
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (this.f19348n) {
            this.f19340f.onMakeupValueChanged(this.f19356v.m20625w(), OplusGLSurfaceView_13, z);
            if (z) {
                m20650b(this.f19356v.m20625w(), OplusGLSurfaceView_13);
                return;
            }
            return;
        }
        if (this.f19356v.m20625w() >= 0) {
            this.f19355u.mo20047a(this.f19356v.m20625w(), OplusGLSurfaceView_13, z);
            if (z) {
                mo20589a(MenuClickMsgData.KEY_COMMON_CUSTOM_BEAUTY[this.f19356v.m20625w()], OplusGLSurfaceView_13, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m20650b(int OplusGLSurfaceView_13, int i2) {
        String str;
        if (OplusGLSurfaceView_13 <= 0) {
            CameraLog.m12962c("FaceBeautyMenu", "reportMakeupDCS, index is " + OplusGLSurfaceView_13);
            i2 = 0;
            str = MenuClickMsgData.KEY_MAKEUP_CLEAR;
        } else {
            str = MenuClickMsgData.sKeyMakeupList.get(OplusGLSurfaceView_13);
        }
        mo20589a(str, i2, true);
    }

    @Override // com.oplus.camera.p172ui.OplusNumSeekBar.InterfaceC3101a
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo18329a() {
        return this.f19355u.mo20052c();
    }

    @Override // com.oplus.camera.p172ui.menu.facebeauty.FaceBeautyCustomMenu.PlatformImplementations.kt_3
    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean mo20631d() {
        CameraUIListener cameraUIListener = this.f19340f;
        return cameraUIListener != null && cameraUIListener.mo10769bL().mo16630q();
    }

    /* renamed from: A */
    private void m20632A() {
        this.f19355u.mo20050b(102);
        this.f19347m = true;
    }

    /* renamed from: B */
    private void m20633B() {
        this.f19355u.mo20050b(0);
        this.f19347m = false;
    }

    /* renamed from: r */
    public boolean m20693r() {
        CameraUIListener cameraUIListener = this.f19340f;
        return cameraUIListener != null && cameraUIListener.mo10848h(CameraFunction.FACE_BEAUTY_PROCESS);
    }

    /* renamed from: s */
    public boolean m20694s() {
        CameraUIListener cameraUIListener = this.f19340f;
        return cameraUIListener != null && cameraUIListener.mo10848h(CameraUIInterface.KEY_SUPPORT_MAKEUP);
    }

    /* renamed from: t */
    public boolean m20695t() {
        CameraUIListener cameraUIListener = this.f19340f;
        return cameraUIListener != null && cameraUIListener.mo10884z();
    }

    /* renamed from: u */
    public boolean m20696u() {
        return m20693r() || m20694s() || m20695t();
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m20660i(boolean z) {
        this.f19347m = this.f19355u.mo20049b() != 0;
        this.f19349o = m20694s() && this.f19340f.mo10726ae() != 0;
        this.f19356v.m20554b(this.f19351q);
        m20692q();
        m20634C();
        if (this.f19347m) {
            this.f19356v.m20624v();
            this.f19356v.m20613a(Math.max(this.f19356v.m20625w(), 0), true, false);
            FaceBeautyCustomMenu c3260f = this.f19356v;
            c3260f.m20614a(this.f19355u.mo20045a(c3260f.m20625w()), this.f19355u.mo20055e());
            this.f19356v.m20619o(true);
            this.f19356v.m20620p(m20635D());
        } else {
            this.f19356v.m20613a(-3, true, false);
            this.f19356v.m20623u();
            this.f19356v.m20619o(false);
            this.f19356v.m20620p(true);
        }
        m20642a(this.f19356v, z);
        this.f19356v.m20559c(z);
    }

    /* renamed from: C */
    private void m20634C() {
        LinearLayout linearLayout;
        FaceBeautyCustomMenu c3260f = this.f19356v;
        if (c3260f != null) {
            LinearLayout linearLayout2 = (LinearLayout) c3260f.mo20585q();
            if (linearLayout2 != null) {
                int childCount = linearLayout2.getChildCount();
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
                    ((TabContainerTextView) ((FrameLayout) linearLayout2.getChildAt(OplusGLSurfaceView_13)).getChildAt(0)).setLightBgColor(this.f19333G);
                }
            }
            if (!Util.m24495t()) {
                this.f19356v.m20621s();
            }
        }
        FaceBeautyCommonMenu c3259e = this.f19357w;
        if (c3259e == null || (linearLayout = (LinearLayout) c3259e.mo20585q()) == null) {
            return;
        }
        int childCount2 = linearLayout.getChildCount();
        for (int i2 = 0; i2 < childCount2; i2++) {
            ((TabContainerTextView) ((FrameLayout) linearLayout.getChildAt(i2)).getChildAt(0)).setLightBgColor(this.f19333G);
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m20661j(boolean z) {
        FaceBeautyCustomMenu c3260f = this.f19356v;
        if (c3260f == null) {
            return;
        }
        if (c3260f.m20609A().m18324c()) {
            CameraLog.m12954a("FaceBeautyMenu", "closeCustomBeautyMenu, isThumbOnDragging");
            this.f19356v.m20609A().m18322b();
        }
        if (z) {
            m20651b((FaceBeautyBaseMenu) this.f19356v, true);
            this.f19356v.m20562d(true);
        } else {
            this.f19356v.m20562d(false);
            m20641a(this.f19356v);
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private void m20662k(boolean z) {
        if (this.f19357w != null) {
            this.f19347m = this.f19355u.mo20049b() != 0;
            boolean zM20695t = m20695t();
            boolean zM20693r = m20693r();
            this.f19357w.m20554b(this.f19351q);
            this.f19357w.m20597a(zM20693r, zM20695t);
            this.f19357w.m20596a(this.f19355u.mo20045a(0), this.f19355u.mo20053d());
            m20634C();
            if (this.f19357w.m20600t().m18324c()) {
                CameraLog.m12954a("FaceBeautyMenu", "closeCustomBeautyMenu, isThumbOnDragging");
                this.f19357w.m20600t().m18322b();
            }
            m20642a(this.f19357w, z);
            this.f19357w.m20559c(z);
            this.f19344j++;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m20672d(int OplusGLSurfaceView_13) {
        FaceBeautyCommonMenu c3259e;
        if (2 != this.f19336b || (c3259e = this.f19357w) == null) {
            return;
        }
        c3259e.m20596a(OplusGLSurfaceView_13, this.f19355u.mo20053d());
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private void m20663l(boolean z) {
        FaceBeautyCommonMenu c3259e = this.f19357w;
        if (c3259e == null) {
            return;
        }
        if (c3259e.m20600t().m18324c()) {
            CameraLog.m12954a("FaceBeautyMenu", "closeCommonBeautyMenu, isThumbOnDragging");
            this.f19357w.m20600t().m18322b();
        }
        if (z) {
            m20651b((FaceBeautyBaseMenu) this.f19357w, true);
            this.f19357w.m20562d(true);
        } else {
            this.f19357w.m20562d(false);
            m20641a(this.f19357w);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m20641a(BeautyMenuInterface interfaceC3255a) {
        if (interfaceC3255a != null) {
            interfaceC3255a.mo20527a();
        }
    }

    /* renamed from: D */
    private boolean m20635D() {
        int OplusGLSurfaceView_13 = 0;
        for (int i2 : this.f19355u.mo20055e()) {
            int iMo20045a = this.f19355u.mo20045a(OplusGLSurfaceView_13);
            if (iMo20045a != i2 && iMo20045a != -100000) {
                return false;
            }
            OplusGLSurfaceView_13++;
        }
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m20642a(FaceBeautyBaseMenu abstractViewOnClickListenerC3258d, boolean z) {
        AnimatorSet animatorSet;
        View viewMo20585q = (abstractViewOnClickListenerC3258d == null || abstractViewOnClickListenerC3258d.mo20585q() == null) ? null : abstractViewOnClickListenerC3258d.mo20585q();
        if (viewMo20585q == null || ((animatorSet = this.f19358x) != null && animatorSet.isStarted())) {
            CameraLog.m12954a("FaceBeautyMenu", "openFaceBeautyTab, menu: " + abstractViewOnClickListenerC3258d + ", tabView is null, return");
            return;
        }
        AnimatorSet animatorSet2 = this.f19359y;
        if (animatorSet2 != null && animatorSet2.isStarted()) {
            this.f19359y.cancel();
        }
        if (z) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewMo20585q, m20697v(), m20698w(), 0.0f);
            objectAnimatorOfFloat.setInterpolator(this.f19353s);
            objectAnimatorOfFloat.setDuration(400L);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(viewMo20585q, "alpha", 0.0f, 1.0f);
            objectAnimatorOfFloat2.setInterpolator(this.f19352r);
            objectAnimatorOfFloat2.setDuration(400L);
            this.f19358x = new AnimatorSet();
            this.f19358x.play(objectAnimatorOfFloat2).with(objectAnimatorOfFloat);
            this.f19358x.setStartDelay(150L);
            this.f19358x.addListener(new AnimatorListenerAdapter() { // from class: com.oplus.camera.ui.menu.facebeauty.COUIBaseListPopupWindow_11.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    if (FaceBeautyMenu.this.f19346l) {
                        if (1 == FaceBeautyMenu.this.f19336b) {
                            FaceBeautyMenu.this.f19356v.m20627y().setVisibility(0);
                            FaceBeautyMenu.this.f19356v.mo20585q().setVisibility(0);
                            FaceBeautyMenu.this.f19356v.m20610B();
                            FaceBeautyMenu.this.f19356v.m20627y().setAlpha(1.0f);
                            FaceBeautyMenu.this.f19356v.mo20585q().setAlpha(0.0f);
                            return;
                        }
                        if (2 == FaceBeautyMenu.this.f19336b) {
                            FaceBeautyMenu.this.f19357w.m20599s().setVisibility(0);
                            FaceBeautyMenu.this.f19357w.mo20585q().setVisibility(0);
                            FaceBeautyMenu.this.f19357w.m20600t().setVisibility(8);
                            FaceBeautyMenu.this.f19357w.m20599s().setAlpha(1.0f);
                            FaceBeautyMenu.this.f19357w.mo20585q().setAlpha(0.0f);
                            FaceBeautyMenu.this.f19357w.m20600t().setAlpha(0.0f);
                        }
                    }
                }
            });
            this.f19358x.start();
            return;
        }
        m20636E();
    }

    /* renamed from: E */
    private void m20636E() {
        int OplusGLSurfaceView_13 = this.f19336b;
        if (1 == OplusGLSurfaceView_13) {
            this.f19356v.m20627y().setVisibility(0);
            this.f19356v.mo20585q().setVisibility(0);
            this.f19356v.m20627y().setAlpha(1.0f);
            this.f19356v.mo20585q().setAlpha(1.0f);
            return;
        }
        if (2 == OplusGLSurfaceView_13) {
            this.f19357w.m20599s().setVisibility(0);
            this.f19357w.mo20585q().setVisibility(0);
            this.f19357w.m20600t().setVisibility(8);
            this.f19357w.m20599s().setAlpha(1.0f);
            this.f19357w.mo20585q().setAlpha(1.0f);
            this.f19357w.m20600t().setAlpha(1.0f);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m20651b(FaceBeautyBaseMenu abstractViewOnClickListenerC3258d, boolean z) {
        AnimatorSet animatorSet;
        View viewMo20585q = (abstractViewOnClickListenerC3258d == null || abstractViewOnClickListenerC3258d.mo20585q() == null) ? null : abstractViewOnClickListenerC3258d.mo20585q();
        if (viewMo20585q == null || ((animatorSet = this.f19359y) != null && animatorSet.isStarted())) {
            CameraLog.m12954a("FaceBeautyMenu", "closeFaceBeautyTab, menu: " + abstractViewOnClickListenerC3258d + ", mBeautyTabExitAnimationSet.isStarted(): " + this.f19359y.isStarted() + ", so return");
            return;
        }
        AnimatorSet animatorSet2 = this.f19358x;
        if (animatorSet2 != null && animatorSet2.isStarted()) {
            this.f19358x.cancel();
        }
        if (z) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewMo20585q, m20697v(), 0.0f, m20698w());
            objectAnimatorOfFloat.setInterpolator(this.f19353s);
            objectAnimatorOfFloat.setDuration(400L);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(viewMo20585q, "alpha", 1.0f, 0.0f);
            objectAnimatorOfFloat2.setInterpolator(this.f19352r);
            objectAnimatorOfFloat2.setDuration(250L);
            this.f19359y = new AnimatorSet();
            this.f19359y.play(objectAnimatorOfFloat2).with(objectAnimatorOfFloat);
            this.f19359y.addListener(this.f19334H);
            this.f19359y.start();
            return;
        }
        viewMo20585q.setVisibility(8);
        viewMo20585q.setAlpha(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m20639a(View view) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(this.f19352r);
        objectAnimatorOfFloat.setDuration(400L);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, m20697v(), m20698w(), 0.0f);
        objectAnimatorOfFloat2.setInterpolator(this.f19353s);
        objectAnimatorOfFloat2.setDuration(400L);
        this.f19360z = new AnimatorSet();
        this.f19360z.play(objectAnimatorOfFloat2).with(objectAnimatorOfFloat);
        this.f19360z.setStartDelay(150L);
        this.f19360z.start();
        view.setEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m20640a(View view, boolean z) {
        AnimatorSet animatorSet = this.f19360z;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.setInterpolator(this.f19352r);
        objectAnimatorOfFloat.setDuration(250L);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, m20697v(), 0.0f, m20698w());
        objectAnimatorOfFloat2.setInterpolator(this.f19353s);
        objectAnimatorOfFloat2.setDuration(400L);
        this.f19327A = new AnimatorSet();
        if (z) {
            this.f19327A.addListener(this.f19334H);
        }
        this.f19327A.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
        this.f19327A.start();
        view.setEnabled(false);
    }

    /* renamed from: F */
    private void m20637F() {
        StringBuilder sb = new StringBuilder();
        int OplusGLSurfaceView_13 = 0;
        while (true) {
            int[] iArr = this.f19345k;
            if (OplusGLSurfaceView_13 >= iArr.length) {
                break;
            }
            if (iArr[OplusGLSurfaceView_13] > 0) {
                sb.append(CameraStatisticsUtil.format(CameraStatisticsUtil.CUSTOM_BEAUTY_CLICK_NUMS[OplusGLSurfaceView_13], String.valueOf(this.f19345k[OplusGLSurfaceView_13])));
                this.f19345k[OplusGLSurfaceView_13] = 0;
            }
            OplusGLSurfaceView_13++;
        }
        int i2 = this.f19341g;
        if (i2 > 0) {
            sb.append(CameraStatisticsUtil.format(CameraStatisticsUtil.FACE_BEAUTY_RESET_SHOW, String.valueOf(i2)));
            this.f19341g = 0;
        }
        int i3 = this.f19342h;
        if (i3 > 0) {
            sb.append(CameraStatisticsUtil.format(CameraStatisticsUtil.FACE_BEAUTY_RESET_OK, String.valueOf(i3)));
            this.f19342h = 0;
        }
        int i4 = this.f19343i;
        if (i4 > 0) {
            sb.append(CameraStatisticsUtil.format(CameraStatisticsUtil.FACE_BEAUTY_RESET_CANCEL, String.valueOf(i4)));
            this.f19343i = 0;
        }
        int i5 = this.f19344j;
        if (i5 > 0) {
            sb.append(CameraStatisticsUtil.format(CameraStatisticsUtil.FACE_BEAUTY_COMMON_SHOW, String.valueOf(i5)));
            this.f19344j = 0;
        }
        if (sb.length() > 0) {
            CameraStatisticsUtil.onCommon(this.f19354t, CameraStatisticsUtil.EVENT_MENU_CLICK, sb.toString());
        }
    }

    @Override // com.oplus.camera.p172ui.menu.facebeauty.FaceBeautyBaseMenu.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo20589a(String str, int OplusGLSurfaceView_13, boolean z) {
        MenuClickMsgData menuClickMsgData = new MenuClickMsgData(this.f19354t);
        if (z) {
            menuClickMsgData.buildEvent(true);
        } else {
            menuClickMsgData.buildMenuSelect();
        }
        menuClickMsgData.mFuncKeyId = 2;
        menuClickMsgData.mItem = str;
        menuClickMsgData.mItemValue = String.valueOf(OplusGLSurfaceView_13);
        menuClickMsgData.mCameraId = this.f19340f.mo10653G();
        menuClickMsgData.mCameraEnterType = String.valueOf(this.f19337c);
        menuClickMsgData.mCaptureType = !this.f19340f.mo10648B() ? 1 : 0;
        menuClickMsgData.mCaptureMode = this.f19340f.mo10736ao();
        menuClickMsgData.mRearOrFront = CameraCharacteristicsUtil.m12974a(this.f19338d) ? DcsMsgData.FRONT : DcsMsgData.REAR;
        menuClickMsgData.report();
    }

    @Override // com.oplus.camera.p172ui.menu.facebeauty.FaceBeautyBaseMenu.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo20588a(int OplusGLSurfaceView_13) {
        this.f19355u.mo20054d(OplusGLSurfaceView_13);
    }

    @Override // com.oplus.camera.p172ui.menu.facebeauty.FaceBeautyBaseMenu.PlatformImplementations.kt_3
    /* renamed from: IntrinsicsJvm.kt_4 */
    public int mo20591b() {
        return this.f19355u.mo20058h();
    }

    @Override // com.oplus.camera.p172ui.menu.facebeauty.FaceBeautyBaseMenu.PlatformImplementations.kt_3
    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean mo20593c() {
        return this.f19340f.mo10705aJ();
    }

    @Override // com.oplus.camera.p172ui.menu.facebeauty.FaceBeautyBaseMenu.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public int mo20587a(int OplusGLSurfaceView_13, boolean z) {
        if (OplusGLSurfaceView_13 >= 0) {
            if (z) {
                return this.f19355u.mo20051c(OplusGLSurfaceView_13);
            }
            return this.f19355u.mo20045a(OplusGLSurfaceView_13);
        }
        CameraLog.m12959b("FaceBeautyMenu", "getValueAtIndex, index: " + OplusGLSurfaceView_13 + ", so return 0!");
        return 0;
    }

    @Override // com.oplus.camera.p172ui.menu.facebeauty.FaceBeautyBaseMenu.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public int[] mo20590a(boolean z) {
        if (z) {
            return this.f19355u.mo20056f();
        }
        return this.f19355u.mo20055e();
    }

    @Override // com.oplus.camera.p172ui.menu.facebeauty.FaceBeautyBaseMenu.PlatformImplementations.kt_3
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo20592b(boolean z) {
        CameraLog.m12959b("FaceBeautyMenu", "currentTapChange, currentMakeup: " + z);
        this.f19348n = z;
        if (this.f19348n) {
            this.f19349o = this.f19340f.mo10726ae() != 0;
            this.f19340f.mo10861l(7);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20667a(FaceBeautyFilterListener interfaceC3409f) {
        this.f19328B = interfaceC3409f;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m20675e(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("FaceBeautyMenu", "notifyPreviewLayoutSizeChanged, previewType: " + OplusGLSurfaceView_13);
        this.f19339e = OplusGLSurfaceView_13;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m20678f(int OplusGLSurfaceView_13) {
        OplusNumAISeekBar oplusNumAISeekBarM20609A;
        OplusNumAISeekBar oplusNumAISeekBarM20600t;
        FaceBeautyCommonMenu c3259e = this.f19357w;
        if (c3259e != null && (oplusNumAISeekBarM20600t = c3259e.m20600t()) != null) {
            oplusNumAISeekBarM20600t.m18318a(OplusGLSurfaceView_13, true);
        }
        FaceBeautyCustomMenu c3260f = this.f19356v;
        if (c3260f == null || (oplusNumAISeekBarM20609A = c3260f.m20609A()) == null) {
            return;
        }
        oplusNumAISeekBarM20609A.m18318a(OplusGLSurfaceView_13, true);
    }

    /* renamed from: v */
    protected String m20697v() {
        return 1 == this.f19329C ? "translationX" : "translationY";
    }

    /* renamed from: w */
    protected int m20698w() {
        if (1 == this.f19329C && 270 != this.f19330D) {
            return -this.f19335a;
        }
        return this.f19335a;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m20682h(boolean z) {
        this.f19333G = z;
    }

    /* renamed from: x */
    public void m20699x() {
        FaceBeautyCustomMenu c3260f = this.f19356v;
        if (c3260f != null) {
            c3260f.m20621s();
        }
    }
}
