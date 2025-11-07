package com.oplus.camera.p172ui.modepanel;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.oplus.camera.CameraLog;
import com.oplus.camera.DimenConstants;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.menu.p175a.ModePickerView;
import com.oplus.camera.p172ui.modepanel.MoreModeAdapter;
import com.oplus.camera.p172ui.widget.AnimationButton;
import com.oplus.camera.screen.ScreenModeConst;
import com.oplus.camera.screen.ScreenModeManager;
import com.oplus.camera.screen.p164b.ScreenModeFacade;
import com.oplus.camera.util.BackgroundUtil;
import com.oplus.camera.util.Util;
import com.p078a.p079a.SimpleSpringListener;
import com.p078a.p079a.Spring;
import com.p078a.p079a.SpringConfig;
import com.p078a.p079a.SpringSystem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: MoreUIControl.java */
/* renamed from: com.oplus.camera.ui.modepanel.p */
/* loaded from: classes2.dex */
public class MoreUIControl implements MoreModeAdapter.PlatformImplementations.kt_3 {

    /* renamed from: PlatformImplementations.kt_3 */
    public static int f20631a = 3;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Activity f20633b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private ViewGroup f20634c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f20635d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private ModePanelData f20636e;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private RelativeLayout.LayoutParams f20638g;

    /* renamed from: OplusGLSurfaceView_5 */
    private ItemDragHelper f20642k;

    /* renamed from: s */
    private ScreenModeManager f20650s;

    /* renamed from: v */
    private int f20653v;

    /* renamed from: y */
    private Spring f20656y;

    /* renamed from: z */
    private Spring f20657z;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private View f20637f = null;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private NonFlingRecycleView f20639h = null;

    /* renamed from: OplusGLSurfaceView_13 */
    private MoreModeAdapter f20640i = null;

    /* renamed from: OplusGLSurfaceView_15 */
    private IntrinsicsJvm.kt_4 f20641j = null;

    /* renamed from: OplusGLSurfaceView_14 */
    private TextView f20643l = null;

    /* renamed from: OplusGLSurfaceView_6 */
    private ImageView f20644m = null;

    /* renamed from: OplusGLSurfaceView_11 */
    private AnimationButton f20645n = null;

    /* renamed from: o */
    private ModeArrangeListener f20646o = null;

    /* renamed from: p */
    private GestureDetector f20647p = null;

    /* renamed from: q */
    private GestureDetector f20648q = null;

    /* renamed from: r */
    private HashMap<Integer, Integer> f20649r = new HashMap<>();

    /* renamed from: t */
    private boolean f20651t = false;

    /* renamed from: u */
    private boolean f20652u = false;

    /* renamed from: w */
    private int f20654w = 0;

    /* renamed from: x */
    private int f20655x = R.layout.more_mode_layout;

    /* renamed from: A */
    private int f20632A = 0;

    /* compiled from: MoreUIControl.java */
    /* renamed from: com.oplus.camera.ui.modepanel.p$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo20041a();

        /* renamed from: PlatformImplementations.kt_3 */
        void mo20042a(int OplusGLSurfaceView_13);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo20043b();

        /* renamed from: IntrinsicsJvm.kt_3 */
        void mo20044c();
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public void m22060k() {
    }

    public MoreUIControl(Activity activity, ViewGroup viewGroup, int OplusGLSurfaceView_13, ItemDragHelper c3348f, ScreenModeManager c2953g) {
        this.f20642k = null;
        this.f20650s = null;
        this.f20633b = activity;
        this.f20634c = viewGroup;
        this.f20635d = OplusGLSurfaceView_13;
        this.f20636e = new ModePanelData(this.f20633b);
        this.f20650s = c2953g;
        this.f20653v = this.f20633b.getResources().getDimensionPixelSize(R.dimen.anim_position);
        this.f20642k = c3348f;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m22017i(int OplusGLSurfaceView_13) {
        ScreenModeManager c2953g;
        if (this.f20637f == null || this.f20638g == null) {
            CameraLog.m12954a("MoreUIControl", "initMoreModeView");
            if (Util.m24495t() && (c2953g = this.f20650s) != null) {
                m22057h(c2953g.mo16411a().mo16539j());
            }
            this.f20637f = this.f20633b.getLayoutInflater().inflate(this.f20655x, (ViewGroup) null);
            this.f20637f.setBackgroundColor(BackgroundUtil.m24523a(this.f20633b.getColor(R.color.more_mode_mask_color)));
            this.f20637f.setVisibility(8);
            if (this.f20632A == 4) {
                int i2 = ScreenModeConst.f16034a - ScreenModeConst.f16035b;
                this.f20638g = new RelativeLayout.LayoutParams(-1, -1);
                this.f20638g.topMargin = (ScreenModeConst.f16035b + i2) / 2;
            } else {
                this.f20638g = new RelativeLayout.LayoutParams(-1, -1);
            }
            this.f20640i = new MoreModeAdapter(this.f20633b, this.f20635d);
            this.f20640i.m21987a(this.f20636e.m21937b(), true);
            this.f20640i.m21992e(this.f20632A);
            this.f20640i.m21986a(this);
            this.f20640i.m21989c(this.f20635d);
            this.f20639h = (NonFlingRecycleView) this.f20637f.findViewById(R.id_renamed.more_mode_view);
            this.f20643l = (TextView) this.f20637f.findViewById(R.id_renamed.mode_edit_desc_text);
            this.f20644m = (ImageView) this.f20637f.findViewById(R.id_renamed.mode_edit_back_arrow);
            this.f20639h.setLayoutManager(new PlatformImplementations.kt_3(this.f20633b, f20631a));
            this.f20639h.addItemDecoration(new IntrinsicsJvm.kt_3());
            ((SimpleItemAnimator) this.f20639h.getItemAnimator()).m4529a(false);
            this.f20644m.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$p$T4uo11FGQSQq6nCrhJdu68PFBOg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.COUIBaseListPopupWindow_12$0.m22008b(view);
                }
            });
            this.f20639h.addOnItemTouchListener(new RecyclerView.InterfaceC0697m() { // from class: com.oplus.camera.ui.modepanel.p.1
                @Override // androidx.recyclerview.widget.RecyclerView.InterfaceC0697m
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo4163a(boolean z) {
                }

                @Override // androidx.recyclerview.widget.RecyclerView.InterfaceC0697m
                /* renamed from: IntrinsicsJvm.kt_4 */
                public void mo4165b(RecyclerView recyclerView, MotionEvent motionEvent) {
                }

                @Override // androidx.recyclerview.widget.RecyclerView.InterfaceC0697m
                /* renamed from: PlatformImplementations.kt_3 */
                public boolean mo4164a(RecyclerView recyclerView, MotionEvent motionEvent) {
                    if (MoreUIControl.this.f20647p == null) {
                        MoreUIControl c3358p = MoreUIControl.this;
                        c3358p.f20647p = new GestureDetector(c3358p.f20633b, new IntrinsicsJvm.kt_5());
                    }
                    if (motionEvent.getPointerId(0) != 0 && 3 != motionEvent.getActionMasked()) {
                        return false;
                    }
                    if (MoreUIControl.this.m22034r()) {
                        return true;
                    }
                    boolean zM21900a = MoreUIControl.this.f20642k.m21900a();
                    MoreUIControl.this.f20642k.m21896a(motionEvent);
                    if (zM21900a && 1 == motionEvent.getActionMasked()) {
                        return true;
                    }
                    return MoreUIControl.this.f20647p.onTouchEvent(motionEvent);
                }
            });
            this.f20650s.mo16411a().mo16533b(new ScreenModeFacade.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$p$PhOMKfmjAS0HCGgrDP9EifNH4F4
                @Override // com.oplus.camera.screen.p164b.ScreenModeFacade.PlatformImplementations.kt_3
                public final void call(Object[] objArr) {
                    this.COUIBaseListPopupWindow_12$0.m22000a(objArr);
                }
            });
            m22020j(this.f20640i.getItemCount());
            this.f20639h.setAdapter(this.f20640i);
            this.f20639h.getItemAnimator().m4125a(0L);
            this.f20637f.setOnTouchListener(new View.OnTouchListener() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$p$fkmXciEyVxm7m0fTIIJJgiepHr8
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return this.COUIBaseListPopupWindow_12$0.m22002a(view, motionEvent);
                }
            });
            m22032q();
            this.f20634c.addView(this.f20637f, 0, this.f20638g);
            this.f20642k.m21897a((RecyclerView) this.f20639h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public /* synthetic */ void m22008b(View view) {
        if (this.f20642k.m21900a()) {
            return;
        }
        this.f20644m.setClickable(false);
        this.f20646o.mo20025a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m22000a(Object[] objArr) {
        m22023l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ boolean m22002a(View view, MotionEvent motionEvent) {
        if (this.f20648q == null) {
            this.f20648q = new GestureDetector(this.f20633b, new COUIBaseListPopupWindow_8());
        }
        this.f20648q.onTouchEvent(motionEvent);
        return true;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private void m22023l() {
        this.f20645n = (AnimationButton) this.f20637f.findViewById(R.id_renamed.arrange_edit_button);
        this.f20645n.setTextSize(0, this.f20633b.getResources().getDimensionPixelSize(R.dimen.mode_vertical_edit_button_text_size));
        this.f20645n.setVisibility(8);
        this.f20645n.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$p$_7M7QnXwdHjXyNyCWxJW_gJ4kYo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.COUIBaseListPopupWindow_12$0.m21998a(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m21998a(View view) {
        if (this.f20642k.m21900a() || m22044b()) {
            return;
        }
        if (this.f20633b.findViewById(R.id_renamed.headline_view) == null || !((ModePickerView) this.f20633b.findViewById(R.id_renamed.headline_view)).m20464l()) {
            this.f20645n.setClickable(false);
            this.f20645n.setVisibility(8);
            this.f20646o.mo20026a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_6 */
    public void m22025m() {
        Spring c1032f = this.f20656y;
        if (c1032f != null) {
            c1032f.m5470a(this.f20653v);
        }
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private void m22027n() {
        Spring c1032f = this.f20656y;
        if (c1032f != null) {
            c1032f.m5476b(0.0d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m22029o() {
        Spring c1032f = this.f20657z;
        if (c1032f != null) {
            c1032f.m5470a(0.0d);
        }
    }

    /* renamed from: p */
    private void m22031p() {
        Spring c1032f = this.f20657z;
        if (c1032f != null) {
            c1032f.m5476b(this.f20653v);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m22005b(float COUIBaseListPopupWindow_12) {
        if (1 == this.f20632A) {
            this.f20639h.setTranslationY(COUIBaseListPopupWindow_12);
        } else {
            this.f20639h.setTranslationX(COUIBaseListPopupWindow_12);
        }
        float f2 = 1.0f - (COUIBaseListPopupWindow_12 / this.f20653v);
        View view = this.f20637f;
        if (view != null) {
            view.setAlpha(f2);
        }
    }

    /* renamed from: q */
    private void m22032q() {
        if (this.f20656y == null || this.f20657z == null) {
            SpringConfig c1033gM5490b = SpringConfig.m5490b(5.0d, 10.0d);
            this.f20656y = SpringSystem.m5492c().m5449b().m5472a(c1033gM5490b).m5470a(this.f20653v).m5473a(new SimpleSpringListener() { // from class: com.oplus.camera.ui.modepanel.p.2
                @Override // com.p078a.p079a.SimpleSpringListener, com.p078a.p079a.SpringListener
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo5464a(Spring c1032f) {
                    MoreUIControl.this.m22005b((float) c1032f.m5478c());
                }

                @Override // com.p078a.p079a.SimpleSpringListener, com.p078a.p079a.SpringListener
                /* renamed from: IntrinsicsJvm.kt_3 */
                public void mo5466c(Spring c1032f) {
                    super.mo5466c(c1032f);
                    MoreUIControl.this.m22029o();
                }

                @Override // com.p078a.p079a.SimpleSpringListener, com.p078a.p079a.SpringListener
                /* renamed from: IntrinsicsJvm.kt_4 */
                public void mo5465b(Spring c1032f) {
                    super.mo5465b(c1032f);
                }
            });
            this.f20657z = SpringSystem.m5492c().m5449b().m5472a(c1033gM5490b).m5470a(0.0d).m5473a(new SimpleSpringListener() { // from class: com.oplus.camera.ui.modepanel.p.3
                @Override // com.p078a.p079a.SimpleSpringListener, com.p078a.p079a.SpringListener
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo5464a(Spring c1032f) {
                    float fM5478c = (float) c1032f.m5478c();
                    MoreUIControl.this.m22005b(fM5478c);
                    if (MoreUIControl.this.f20653v == fM5478c) {
                        CameraLog.m12954a("MoreUIControl", "initSpring, mAnimExit, onSpringUpdate, Set the mMoreView status to Gone.");
                        if (MoreUIControl.this.f20657z != null && !MoreUIControl.this.f20657z.m5486i()) {
                            MoreUIControl.this.f20657z.m5487j();
                        }
                        if (MoreUIControl.this.f20637f != null) {
                            MoreUIControl.this.f20637f.setVisibility(8);
                        }
                    }
                }

                @Override // com.p078a.p079a.SimpleSpringListener, com.p078a.p079a.SpringListener
                /* renamed from: IntrinsicsJvm.kt_3 */
                public void mo5466c(Spring c1032f) {
                    super.mo5466c(c1032f);
                    MoreUIControl.this.m22025m();
                }
            });
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m22043b(int OplusGLSurfaceView_13) {
        this.f20636e.m21936a(OplusGLSurfaceView_13);
        m22037a();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m22046c(int OplusGLSurfaceView_13) {
        this.f20636e.m21938b(OplusGLSurfaceView_13);
        m22037a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22037a() {
        if (m22051e()) {
            CameraLog.m12954a("MoreUIControl", "onMoreModeDataChange, mCameraId: " + this.f20654w);
            this.f20640i.m21987a(this.f20636e.m21937b(), true);
            this.f20640i.notifyDataSetChanged();
            m22020j(this.f20640i.getItemCount());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22042a(boolean z) {
        this.f20651t = z;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m22044b() {
        Spring c1032f = this.f20656y;
        if (c1032f == null || this.f20657z == null) {
            return false;
        }
        return (c1032f.m5486i() && this.f20657z.m5486i()) ? false : true;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m22047c() {
        Spring c1032f = this.f20656y;
        return (c1032f == null || c1032f.m5486i()) ? false : true;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m22049d() {
        Spring c1032f = this.f20657z;
        return (c1032f == null || c1032f.m5486i()) ? false : true;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m22048d(int OplusGLSurfaceView_13) {
        this.f20654w = OplusGLSurfaceView_13;
        m22017i(OplusGLSurfaceView_13);
        if (m22051e()) {
            Spring c1032f = this.f20657z;
            if (c1032f != null && !c1032f.m5486i()) {
                CameraLog.m12954a("MoreUIControl", "showMoreView, MoreMode is executing the end animation");
                this.f20657z.m5487j();
                this.f20637f.setVisibility(8);
            } else {
                CameraLog.m12954a("MoreUIControl", "showMoreView, MoreMode has been shown");
                return;
            }
        }
        this.f20640i.m21991d(this.f20635d);
        this.f20637f.setVisibility(0);
        if (this.f20645n != null && !m22058i()) {
            m22036t();
            this.f20645n.setVisibility(0);
            this.f20645n.setClickable(true);
        }
        m22027n();
        m22029o();
        if (this.f20651t) {
            this.f20651t = false;
            this.f20640i.m21987a(this.f20636e.m21937b(), true);
            this.f20640i.notifyDataSetChanged();
            m22020j(this.f20640i.getItemCount());
            this.f20649r.clear();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m22045b(boolean z) {
        if (!m22051e()) {
            return false;
        }
        Spring c1032f = this.f20656y;
        if (c1032f != null && !c1032f.m5486i()) {
            CameraLog.m12954a("MoreUIControl", "hideMoreView, MoreMode is executing the enter animation");
            this.f20656y.m5487j();
        }
        CameraLog.m12967f("MoreUIControl", "hideMoreView");
        if (z) {
            m22031p();
            return true;
        }
        m22025m();
        this.f20637f.setVisibility(8);
        return true;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m22050e(int OplusGLSurfaceView_13) {
        Drawable background;
        View view = this.f20637f;
        if (view == null || (background = view.getBackground()) == null) {
            return;
        }
        background.setAlpha(OplusGLSurfaceView_13);
        this.f20637f.setBackground(background);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22038a(float COUIBaseListPopupWindow_12) {
        View view = this.f20637f;
        if (view != null) {
            view.setAlpha(COUIBaseListPopupWindow_12);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m22051e() {
        View view;
        ViewGroup viewGroup = this.f20634c;
        return (viewGroup == null || (view = this.f20637f) == null || viewGroup.indexOfChild(view) == -1 || this.f20637f.getVisibility() != 0) ? false : true;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m22053f(int OplusGLSurfaceView_13) {
        this.f20635d = OplusGLSurfaceView_13;
        MoreModeAdapter c3357o = this.f20640i;
        if (c3357o != null) {
            c3357o.m21989c(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22041a(IntrinsicsJvm.kt_4 bVar) {
        this.f20641j = bVar;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m22052f() {
        Spring c1032f = this.f20656y;
        if (c1032f != null) {
            c1032f.m5475a();
            this.f20656y = null;
        }
        Spring c1032f2 = this.f20657z;
        if (c1032f2 != null) {
            c1032f2.m5475a();
            this.f20657z = null;
        }
    }

    @Override // com.oplus.camera.p172ui.modepanel.MoreModeAdapter.PlatformImplementations.kt_3
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo21993a(int OplusGLSurfaceView_13) {
        CameraLog.m12954a("MoreUIControl", "onClick, more itemId: " + OplusGLSurfaceView_13);
        IntrinsicsJvm.kt_4 bVar = this.f20641j;
        if (bVar != null) {
            bVar.mo20042a(OplusGLSurfaceView_13);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public boolean m22034r() {
        if (this.f20657z != null) {
            return !r0.m5486i();
        }
        return false;
    }

    /* compiled from: MoreUIControl.java */
    /* renamed from: com.oplus.camera.ui.modepanel.p$IntrinsicsJvm.kt_5 */
    private class IntrinsicsJvm.kt_5 extends GestureDetector.SimpleOnGestureListener {
        private IntrinsicsJvm.kt_5() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (MoreUIControl.this.f20641j == null) {
                return false;
            }
            if (!MoreUIControl.this.m22058i()) {
                if (MoreUIControl.this.f20639h.findChildViewUnder(motionEvent.getX(), motionEvent.getY()) != null) {
                    return false;
                }
                CameraLog.m12954a("MoreUIControl", "MoreMenuGestureListener, onSingleTapUp, no item clicked,go back to last index");
                MoreUIControl.this.f20641j.mo20044c();
                return true;
            }
            CameraLog.m12954a("MoreUIControl", "MoreMenuGestureListener, can't respond tap event in mode arranging.");
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float COUIBaseListPopupWindow_12, float f2) {
            if (MoreUIControl.this.f20641j == null) {
                return false;
            }
            if (!MoreUIControl.this.m22058i()) {
                return 1 == MoreUIControl.this.f20632A ? MoreUIControl.this.m22009b(motionEvent, motionEvent2, COUIBaseListPopupWindow_12, f2) : MoreUIControl.this.m22001a(motionEvent, motionEvent2, COUIBaseListPopupWindow_12, f2);
            }
            CameraLog.m12967f("MoreUIControl", "onFling, don't response fling when mode arranging.");
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            View viewFindChildViewUnder = MoreUIControl.this.f20639h.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
            int childAdapterPosition = MoreUIControl.this.f20639h.getChildAdapterPosition(viewFindChildViewUnder);
            if (viewFindChildViewUnder != null) {
                MoreUIControl.this.f20646o.mo20026a(true);
                if (PreferenceManager.m3981a(MoreUIControl.this.f20633b).getBoolean("mode_arrange_reddot_show", true)) {
                    return;
                }
                MoreUIControl.this.f20642k.m21898a(MoreUIControl.this.f20639h, viewFindChildViewUnder, childAdapterPosition, motionEvent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m22001a(MotionEvent motionEvent, MotionEvent motionEvent2, float COUIBaseListPopupWindow_12, float f2) {
        if (Math.abs(motionEvent.getY() - motionEvent2.getY()) >= Math.abs(motionEvent.getX() - motionEvent2.getX())) {
            return false;
        }
        if (Float.compare(motionEvent2.getX() - motionEvent.getX(), 100.0f) > 0 || (Float.compare(COUIBaseListPopupWindow_12, 200.0f) > 0 && motionEvent2.getX() - motionEvent.getX() > 0.0f)) {
            CameraLog.m12954a("MoreUIControl", "handleNormalFling, slide to previous mode");
            this.f20641j.mo20041a();
            return true;
        }
        if (Float.compare(motionEvent.getX() - motionEvent2.getX(), 100.0f) <= 0 && (Float.compare(COUIBaseListPopupWindow_12, 200.0f) <= 0 || motionEvent.getX() - motionEvent2.getX() <= 0.0f)) {
            return false;
        }
        CameraLog.m12954a("MoreUIControl", "handleNormalFling, slide to next mode");
        this.f20641j.mo20043b();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m22009b(MotionEvent motionEvent, MotionEvent motionEvent2, float COUIBaseListPopupWindow_12, float f2) {
        if (Math.abs(motionEvent.getX() - motionEvent2.getX()) >= Math.abs(motionEvent.getY() - motionEvent2.getY())) {
            return false;
        }
        if (Float.compare(motionEvent2.getY() - motionEvent.getY(), 100.0f) > 0 || (Float.compare(f2, 200.0f) > 0 && motionEvent2.getY() - motionEvent.getY() > 0.0f)) {
            this.f20641j.mo20041a();
            return true;
        }
        if (Float.compare(motionEvent.getY() - motionEvent2.getY(), 100.0f) <= 0 && (Float.compare(f2, 200.0f) <= 0 || motionEvent.getY() - motionEvent2.getY() <= 0.0f)) {
            return false;
        }
        this.f20641j.mo20043b();
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22039a(int OplusGLSurfaceView_13, int i2) {
        m22006b(OplusGLSurfaceView_13, i2);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m22055g(int OplusGLSurfaceView_13) {
        m22006b(OplusGLSurfaceView_13, -1);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m22006b(int OplusGLSurfaceView_13, int i2) {
        this.f20649r.put(Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2));
        ArrayList<ModeInfo> arrayListM21937b = this.f20636e.m21937b();
        for (int i3 = 0; i3 < arrayListM21937b.size(); i3++) {
            ModeInfo c3353k = arrayListM21937b.get(i3);
            if (c3353k != null && OplusGLSurfaceView_13 == c3353k.m21922b()) {
                c3353k.m21920a(i2);
                MoreModeAdapter c3357o = this.f20640i;
                if (c3357o == null || this.f20639h == null) {
                    return;
                }
                c3357o.m21987a(arrayListM21937b, true);
                this.f20639h.setAdapter(this.f20640i);
                m22020j(this.f20640i.getItemCount());
                return;
            }
        }
    }

    /* compiled from: MoreUIControl.java */
    /* renamed from: com.oplus.camera.ui.modepanel.p$COUIBaseListPopupWindow_8 */
    private class COUIBaseListPopupWindow_8 extends GestureDetector.SimpleOnGestureListener {
        private COUIBaseListPopupWindow_8() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (MoreUIControl.this.f20641j == null) {
                return false;
            }
            if (MoreUIControl.this.m22058i()) {
                CameraLog.m12954a("MoreUIControl", "MoreViewGestureListener, can't respond tap event in mode arranging.");
                return true;
            }
            CameraLog.m12954a("MoreUIControl", "MoreViewGestureListener, onSingleTapUp, go back to last index");
            MoreUIControl.this.f20641j.mo20044c();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float COUIBaseListPopupWindow_12, float f2) {
            if (MoreUIControl.this.f20641j == null) {
                return false;
            }
            if (!MoreUIControl.this.m22058i()) {
                return 1 == MoreUIControl.this.f20632A ? MoreUIControl.this.m22009b(motionEvent, motionEvent2, COUIBaseListPopupWindow_12, f2) : MoreUIControl.this.m22001a(motionEvent, motionEvent2, COUIBaseListPopupWindow_12, f2);
            }
            CameraLog.m12954a("MoreUIControl", "MoreViewGestureListener, can't respond tap event in mode arranging.");
            return true;
        }
    }

    /* compiled from: MoreUIControl.java */
    /* renamed from: com.oplus.camera.ui.modepanel.p$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 extends GridLayoutManager {
        public PlatformImplementations.kt_3(Context context, int OplusGLSurfaceView_13) {
            super(context, OplusGLSurfaceView_13);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
        public void onMeasure(RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t, int OplusGLSurfaceView_13, int i2) {
            View viewM4201c;
            try {
                super.onMeasure(c0700p, c0704t, OplusGLSurfaceView_13, i2);
                int measuredWidth = MoreUIControl.this.f20639h.getMeasuredWidth();
                int measuredHeight = MoreUIControl.this.f20639h.getMeasuredHeight();
                int iM4230e = c0704t.m4230e();
                int measuredHeight2 = 0;
                for (int i3 = 0; i3 < iM4230e; i3++) {
                    if (measuredHeight2 < measuredHeight && i3 % m4055a() == 0 && (viewM4201c = c0700p.m4201c(i3)) != null) {
                        RecyclerView.C0694j c0694j = (RecyclerView.C0694j) viewM4201c.getLayoutParams();
                        viewM4201c.measure(ViewGroup.getChildMeasureSpec(OplusGLSurfaceView_13, getPaddingLeft() + getPaddingRight(), c0694j.width), ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), c0694j.height));
                        measuredHeight2 += viewM4201c.getMeasuredHeight() + c0694j.bottomMargin + c0694j.topMargin;
                    }
                }
                setMeasuredDimension(measuredWidth, Math.min(measuredHeight, measuredHeight2));
            } catch (Exception COUIBaseListPopupWindow_8) {
                CameraLog.m12967f("MoreUIControl", "onMeasure error, " + COUIBaseListPopupWindow_8);
            }
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0693i
        public void onLayoutChildren(RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t) {
            try {
                super.onLayoutChildren(c0700p, c0704t);
            } catch (IndexOutOfBoundsException COUIBaseListPopupWindow_8) {
                CameraLog.m12967f("MoreUIControl", "onLayoutChildren error, " + COUIBaseListPopupWindow_8);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m22040a(ModeArrangeListener interfaceC3350h) {
        this.f20646o = interfaceC3350h;
    }

    /* compiled from: MoreUIControl.java */
    /* renamed from: com.oplus.camera.ui.modepanel.p$IntrinsicsJvm.kt_3 */
    private class IntrinsicsJvm.kt_3 extends RecyclerView.AbstractC0692h {
        private IntrinsicsJvm.kt_3() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0692h
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.C0704t c0704t) {
            super.getItemOffsets(rect, view, recyclerView, c0704t);
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view) % MoreUIControl.f20631a;
            rect.left = (DimenConstants.m14485c() * childAdapterPosition) / MoreUIControl.f20631a;
            rect.right = DimenConstants.m14485c() - (((childAdapterPosition + 1) * DimenConstants.m14485c()) / MoreUIControl.f20631a);
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m22020j(int OplusGLSurfaceView_13) {
        int iM14494l;
        int i2 = f20631a;
        if (OplusGLSurfaceView_13 <= i2 * 1) {
            iM14494l = DimenConstants.m14490h();
        } else if (OplusGLSurfaceView_13 > i2 * 1 && OplusGLSurfaceView_13 <= i2 * 2) {
            iM14494l = DimenConstants.m14491i();
        } else {
            int i3 = f20631a;
            if (OplusGLSurfaceView_13 > i3 * 2 && OplusGLSurfaceView_13 <= i3 * 3) {
                iM14494l = DimenConstants.m14492j();
            } else {
                int i4 = f20631a;
                if (OplusGLSurfaceView_13 > i4 * 3 && OplusGLSurfaceView_13 <= i4 * 4) {
                    iM14494l = DimenConstants.m14493k();
                } else {
                    int i5 = f20631a;
                    if (OplusGLSurfaceView_13 <= i5 * 4 || OplusGLSurfaceView_13 <= i5 * 5) {
                        iM14494l = DimenConstants.m14494l();
                    } else {
                        iM14494l = DimenConstants.m14494l();
                    }
                }
            }
        }
        ConstraintLayout.C0398a c0398a = (ConstraintLayout.C0398a) this.f20639h.getLayoutParams();
        if (4 == this.f20632A) {
            c0398a.topMargin = iM14494l;
            c0398a.leftMargin = this.f20633b.getResources().getDimensionPixelSize(R.dimen.rack_mode_more_mode_view_margin_left_right);
            c0398a.rightMargin = c0398a.leftMargin;
            c0398a.bottomMargin = this.f20633b.getResources().getDimensionPixelSize(R.dimen.rack_mode_mode_edit_confirm_root_layout_height);
            this.f20639h.setVerticalFadingEdgeEnabled(true);
            this.f20639h.setFadingEdgeLength(Util.m24460i(R.dimen.rack_mode_fading_length));
        } else {
            c0398a.topMargin = iM14494l;
            c0398a.bottomMargin = Util.m24187O();
            this.f20639h.setVerticalFadingEdgeEnabled(false);
        }
        this.f20639h.setLayoutParams(c0398a);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m22054g() {
        if (m22058i()) {
            return;
        }
        AnimationButton animationButton = this.f20645n;
        if (animationButton != null && animationButton.getVisibility() == 0) {
            this.f20645n.setClickable(false);
            this.f20645n.setVisibility(8);
        }
        this.f20652u = true;
        this.f20640i.m21988a(true);
        this.f20644m.setClickable(true);
        int itemCount = this.f20640i.getItemCount();
        this.f20640i.notifyItemRangeChanged(0, itemCount, Integer.valueOf(itemCount));
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 255);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$p$n8prsoDVZI_r3aGgjjU0PeZE1uk
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.COUIBaseListPopupWindow_12$0.m22007b(valueAnimator);
            }
        });
        valueAnimatorOfInt.addListener(new Animator.AnimatorListener() { // from class: com.oplus.camera.ui.modepanel.p.4
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
                animator.getListeners().clear();
                if (4 == MoreUIControl.this.f20632A) {
                    MoreUIControl.this.f20643l.setVisibility(8);
                    MoreUIControl.this.f20644m.setVisibility(8);
                } else {
                    MoreUIControl.this.f20643l.setVisibility(0);
                    MoreUIControl.this.f20644m.setVisibility(0);
                }
            }
        });
        valueAnimatorOfInt.setDuration(200L);
        valueAnimatorOfInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public /* synthetic */ void m22007b(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f20643l.setTextColor(Color.argb(iIntValue, 255, 255, 255));
        ((VectorDrawable) this.f20644m.getDrawable()).setAlpha(iIntValue);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m22057h(int OplusGLSurfaceView_13) {
        ModePanelData c3354l;
        Spring c1032f;
        this.f20632A = OplusGLSurfaceView_13;
        boolean z = m22051e() && (c1032f = this.f20657z) != null && c1032f.m5486i();
        if (OplusGLSurfaceView_13 == 1) {
            this.f20655x = R.layout.more_mode_layout_vertical;
            f20631a = 4;
        } else if (OplusGLSurfaceView_13 == 4) {
            this.f20655x = R.layout.more_mode_layout;
            f20631a = 4;
        } else {
            this.f20655x = R.layout.more_mode_layout;
            f20631a = 3;
        }
        MoreModeAdapter c3357o = this.f20640i;
        if (c3357o != null) {
            c3357o.m21990d();
        }
        NonFlingRecycleView nonFlingRecycleView = this.f20639h;
        if (nonFlingRecycleView != null) {
            nonFlingRecycleView.setAdapter(null);
        }
        AnimationButton animationButton = this.f20645n;
        if (animationButton != null) {
            animationButton.setVisibility(8);
        }
        View view = this.f20637f;
        if (view != null) {
            this.f20634c.removeView(view);
        }
        this.f20637f = null;
        this.f20638g = null;
        if (z) {
            if (m22058i() && (c3354l = this.f20636e) != null) {
                c3354l.m21940c();
            }
            this.f20640i = null;
            m22048d(this.f20654w);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m22056h() {
        if (this.f20640i == null) {
            return;
        }
        this.f20636e.m21940c();
        ArrayList<ModeInfo> arrayListM21937b = this.f20636e.m21937b();
        Iterator<ModeInfo> it = arrayListM21937b.iterator();
        while (it.hasNext()) {
            ModeInfo next = it.next();
            if (this.f20649r.containsKey(Integer.valueOf(next.m21922b()))) {
                next.m21920a(this.f20649r.get(Integer.valueOf(next.m21922b())).intValue());
            }
        }
        this.f20640i.m21987a(arrayListM21937b, false);
        this.f20652u = false;
        this.f20640i.m21988a(false);
        m22020j(this.f20640i.getItemCount());
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(255, 0);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$p$de-1XOT9ysj02ElFfQBROzubhBo
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.COUIBaseListPopupWindow_12$0.m21997a(valueAnimator);
            }
        });
        valueAnimatorOfInt.addListener(new MoreUIControl_7());
        valueAnimatorOfInt.setDuration(200L);
        valueAnimatorOfInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m21997a(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        this.f20643l.setTextColor(Color.argb(iIntValue, 255, 255, 255));
        ((VectorDrawable) this.f20644m.getDrawable()).setAlpha(iIntValue);
    }

    /* compiled from: MoreUIControl.java */
    /* renamed from: com.oplus.camera.ui.modepanel.p$5, reason: invalid class name */
    class MoreUIControl_7 implements Animator.AnimatorListener {
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        MoreUIControl_7() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            animator.getListeners().clear();
            MoreUIControl.this.f20643l.setVisibility(8);
            MoreUIControl.this.f20650s.mo16411a().mo16564c(new ScreenModeFacade.PlatformImplementations.kt_3() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$p$5$8eZsKbbNh7CjtNWKJ-59WIe60uk
                @Override // com.oplus.camera.screen.p164b.ScreenModeFacade.PlatformImplementations.kt_3
                public final void call(Object[] objArr) {
                    this.COUIBaseListPopupWindow_12$0.m22061a(objArr);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: PlatformImplementations.kt_3 */
        public /* synthetic */ void m22061a(Object[] objArr) {
            MoreUIControl.this.m22035s();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public void m22035s() {
        if (this.f20645n != null) {
            m22036t();
            this.f20645n.setVisibility(0);
            this.f20645n.setClickable(true);
        }
    }

    /* renamed from: t */
    private void m22036t() {
        AnimationButton animationButton = this.f20645n;
        if (animationButton == null || this.f20650s == null) {
            return;
        }
        ((ConstraintLayout.C0398a) animationButton.getLayoutParams()).bottomMargin = this.f20633b.getResources().getDimensionPixelSize(R.dimen.mode_vertical_edit_button_margin_bottom) + (ScreenModeConst.PlatformImplementations.kt_3.full.equals(this.f20650s.mo16414i()) ? Util.m24484o(this.f20633b) : 0);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public boolean m22058i() {
        if (Util.m24495t()) {
            return this.f20652u;
        }
        TextView textView = this.f20643l;
        return textView != null && textView.getVisibility() == 0;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m22059j() {
        TextView textView = this.f20643l;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }
}
