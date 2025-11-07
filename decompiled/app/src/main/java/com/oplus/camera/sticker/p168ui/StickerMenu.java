package com.oplus.camera.sticker.p168ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.p172ui.BackgroundSplitManager;
import com.oplus.camera.p172ui.RotateImageView;
import com.oplus.camera.p172ui.control.MainShutterButton;
import com.oplus.camera.p172ui.preview.p177a.ImageStickerTools;
import com.oplus.camera.sticker.data.StickerItem;
import com.oplus.camera.util.Util;
import java.util.ArrayList;

/* compiled from: StickerMenu.java */
/* renamed from: com.oplus.camera.sticker.ui.COUIBaseListPopupWindow_10 */
/* loaded from: classes2.dex */
public class StickerMenu {

    /* renamed from: D */
    private Drawable f16373D;

    /* renamed from: E */
    private Drawable f16374E;

    /* renamed from: F */
    private Drawable f16375F;

    /* renamed from: H */
    private StickerCategoryInterface f16377H;

    /* renamed from: R */
    private IntrinsicsJvm.kt_5 f16387R;

    /* renamed from: PlatformImplementations.kt_3 */
    private final int f16394a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final int f16395b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final int f16396c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final int f16397d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final int f16398e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final int f16399f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final int f16400g;

    /* renamed from: q */
    private boolean f16410q;

    /* renamed from: r */
    private int f16411r;

    /* renamed from: s */
    private Activity f16412s;

    /* renamed from: t */
    private RelativeLayout f16413t;

    /* renamed from: v */
    private RotateImageView f16415v;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private Interpolator f16401h = new PathInterpolator(0.33f, 0.0f, 0.66f, 1.0f);

    /* renamed from: OplusGLSurfaceView_13 */
    private TimeInterpolator f16402i = new PathInterpolator(0.75f, 0.1f, 0.75f, 1.0f);

    /* renamed from: OplusGLSurfaceView_15 */
    private AnimatorSet f16403j = null;

    /* renamed from: OplusGLSurfaceView_5 */
    private AnimatorSet f16404k = null;

    /* renamed from: OplusGLSurfaceView_14 */
    private AnimatorSet f16405l = null;

    /* renamed from: OplusGLSurfaceView_6 */
    private AnimatorSet f16406m = null;

    /* renamed from: OplusGLSurfaceView_11 */
    private Animator f16407n = null;

    /* renamed from: o */
    private Animator f16408o = null;

    /* renamed from: p */
    private boolean f16409p = false;

    /* renamed from: u */
    private RelativeLayout f16414u = null;

    /* renamed from: w */
    private MainShutterButton f16416w = null;

    /* renamed from: x */
    private StickerPageView f16417x = null;

    /* renamed from: y */
    private RotateImageView f16418y = null;

    /* renamed from: z */
    private StickerPageAdapter f16419z = null;

    /* renamed from: A */
    private StickerMenuListener f16370A = null;

    /* renamed from: B */
    private ImageDownloader f16371B = null;

    /* renamed from: C */
    private boolean f16372C = false;

    /* renamed from: G */
    private StickerCategoryAdapter f16376G = null;

    /* renamed from: I */
    private RelativeLayout f16378I = null;

    /* renamed from: J */
    private StickerCategoryContainer f16379J = null;

    /* renamed from: K */
    private StickerCategoryRecycleView f16380K = null;

    /* renamed from: L */
    private RotateImageView f16381L = null;

    /* renamed from: M */
    private RotateImageView f16382M = null;

    /* renamed from: N */
    private int f16383N = -1;

    /* renamed from: O */
    private boolean f16384O = false;

    /* renamed from: P */
    private IntrinsicsJvm.kt_3 f16385P = null;

    /* renamed from: Q */
    private LinearLayoutManager f16386Q = null;

    /* renamed from: S */
    private IntrinsicsJvm.kt_4 f16388S = null;

    /* renamed from: T */
    private PlatformImplementations.kt_3 f16389T = null;

    /* renamed from: U */
    private View.OnClickListener f16390U = new View.OnClickListener() { // from class: com.oplus.camera.sticker.ui.COUIBaseListPopupWindow_10.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((StickerMenu.this.f16404k != null && StickerMenu.this.f16404k.isRunning()) || !StickerMenu.this.f16370A.mo12675i() || !StickerMenu.this.f16415v.isEnabled() || !StickerMenu.this.f16415v.isClickable()) {
                CameraLog.m12954a("StickerMenu", "mEnterMenuButtonOnClickListener, onClick, return");
            } else {
                StickerMenu.this.m17136d(true);
            }
        }
    };

    /* renamed from: V */
    private View.OnClickListener f16391V = new View.OnClickListener() { // from class: com.oplus.camera.sticker.ui.COUIBaseListPopupWindow_10.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (StickerMenu.this.f16383N != 0) {
                StickerMenu.this.f16377H.mo17078a(0, 0, StickerMenu.this.f16388S.f16443c, false);
            }
        }
    };

    /* renamed from: W */
    private View.OnClickListener f16392W = new View.OnClickListener() { // from class: com.oplus.camera.sticker.ui.COUIBaseListPopupWindow_10.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (StickerMenu.this.f16370A != null) {
                StickerMenu.this.f16370A.mo12673g();
            }
        }
    };

    /* renamed from: X */
    private ContentObserver f16393X = new ContentObserver(null) { // from class: com.oplus.camera.sticker.ui.COUIBaseListPopupWindow_10.10
        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            CameraLog.m12954a("StickerMenu", "onChange, slefChange: " + z);
            StickerMenu.this.f16412s.runOnUiThread(new Runnable() { // from class: com.oplus.camera.sticker.ui.COUIBaseListPopupWindow_10.10.1
                @Override // java.lang.Runnable
                public void run() {
                    StickerMenu.this.m17112a();
                }
            });
        }
    };

    /* compiled from: StickerMenu.java */
    /* renamed from: com.oplus.camera.sticker.ui.COUIBaseListPopupWindow_10$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void m17143a();
    }

    public StickerMenu(Activity activity, int OplusGLSurfaceView_13, boolean z) {
        this.f16410q = false;
        this.f16411r = 0;
        this.f16412s = null;
        this.f16413t = null;
        this.f16415v = null;
        this.f16373D = null;
        this.f16374E = null;
        this.f16375F = null;
        this.f16377H = null;
        this.f16387R = null;
        CameraLog.m12954a("StickerMenu", "StickerMenu");
        this.f16412s = activity;
        this.f16410q = this.f16412s.getResources().getConfiguration().getLayoutDirection() == 0;
        this.f16413t = (RelativeLayout) this.f16412s.findViewById(R.id_renamed.camera);
        this.f16411r = OplusGLSurfaceView_13;
        this.f16387R = new IntrinsicsJvm.kt_5();
        this.f16394a = this.f16412s.getResources().getDimensionPixelSize(R.dimen.sticker_type_view_item_size);
        this.f16395b = this.f16412s.getResources().getDimensionPixelSize(R.dimen.sticker_view_padding);
        this.f16396c = this.f16412s.getResources().getDimensionPixelSize(R.dimen.sticker_view_second_padding);
        this.f16397d = this.f16412s.getResources().getDimensionPixelSize(R.dimen.sticker_recycle_top_margin);
        this.f16398e = this.f16412s.getResources().getDimensionPixelSize(R.dimen.sticker_recycle_list_padding);
        this.f16399f = this.f16412s.getResources().getDimensionPixelSize(R.dimen.sticker_recycle_list_margin_left);
        this.f16400g = this.f16412s.getResources().getDimensionPixelSize(R.dimen.sticker_recycle_list_margin_right);
        if (this.f16413t == null) {
            return;
        }
        CameraLog.m12952a("StickerMenus");
        this.f16415v = (RotateImageView) activity.getLayoutInflater().inflate(R.layout.enter_sticker_button, (ViewGroup) null);
        this.f16415v.m18348a(this.f16411r, true);
        this.f16415v.setOnClickListener(this.f16390U);
        BackgroundSplitManager.m18430a(this.f16412s).m18445a(this.f16415v, "StickerButton");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f16412s.getResources().getDimensionPixelSize(R.dimen.sticker_enter_button_width), this.f16412s.getResources().getDimensionPixelSize(R.dimen.sticker_enter_button_height));
        layoutParams.addRule(20);
        layoutParams.addRule(2, R.id_renamed.control_panel_layout);
        layoutParams.bottomMargin = this.f16412s.getResources().getDimensionPixelSize(R.dimen.sticker_menu_button_top_margin);
        layoutParams.setMarginStart(this.f16412s.getResources().getDimensionPixelSize(R.dimen.sticker_menu_button_right_margin));
        if (z) {
            m17133c(true);
        } else {
            m17133c(false);
        }
        this.f16413t.addView(this.f16415v, layoutParams);
        this.f16373D = this.f16412s.getDrawable(R.drawable.sticker_music_play);
        this.f16374E = this.f16412s.getDrawable(R.drawable.sticker_music_pause);
        this.f16375F = this.f16373D;
        this.f16377H = new StickerCategoryInterface() { // from class: com.oplus.camera.sticker.ui.COUIBaseListPopupWindow_10.11
            @Override // com.oplus.camera.sticker.p168ui.StickerCategoryInterface
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo17078a(int i2, int i3, String str, boolean z2) {
                if (StickerMenu.this.f16370A != null) {
                    StickerMenu.this.f16370A.mo12667b(str);
                    StickerMenu.this.f16383N = i2;
                    StickerMenu.this.m17121a(str, z2);
                    StickerMenu.this.f16417x.m4977a(StickerMenu.this.f16383N, false);
                    StickerMenu.this.m17113a(i3);
                    ImageStickerTools.m22687b(StickerMenu.this.f16412s).m22719b(str);
                }
                if (StickerMenu.this.f16376G != null && i2 == 0) {
                    StickerMenu.this.f16376G.m17075b(-1);
                }
                StickerMenu.this.m17093j();
            }

            @Override // com.oplus.camera.sticker.p168ui.StickerCategoryInterface
            /* renamed from: PlatformImplementations.kt_3 */
            public boolean mo17079a() {
                return !StickerMenu.this.f16384O;
            }

            @Override // com.oplus.camera.sticker.p168ui.StickerCategoryInterface
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo17080b() {
                if (StickerMenu.this.f16370A != null) {
                    StickerMenu.this.f16370A.mo12670d();
                }
            }
        };
        CameraLog.m12958b("StickerMenus");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_15 */
    public void m17093j() {
        IntrinsicsJvm.kt_4 bVar = this.f16388S;
        if (bVar == null) {
            return;
        }
        if (this.f16383N == 0) {
            this.f16381L.setImageDrawable(bVar.f16441a);
        } else {
            this.f16381L.setImageDrawable(bVar.f16442b);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17124a(boolean z, boolean z2) {
        RotateImageView rotateImageView;
        CameraLog.m12954a("StickerMenu", "onResume");
        CameraLog.m12952a("StickerMenus.onResume");
        m17112a();
        if (z && (rotateImageView = this.f16415v) != null) {
            rotateImageView.setAlpha(0.0f);
        }
        if (!z2) {
            m17114a(0, false, false);
        }
        m17137e();
        CameraLog.m12958b("StickerMenus.onResume");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17119a(final String str) {
        Activity activity = this.f16412s;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.sticker.ui.COUIBaseListPopupWindow_10.12
                @Override // java.lang.Runnable
                public void run() {
                    if (StickerMenu.this.f16419z != null) {
                        StickerMenu.this.f16419z.m17148a(str);
                    }
                }
            });
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17112a() {
        CameraLog.m12954a("StickerMenu", "updateLayout, mGridViewRelativeLayout: " + this.f16414u);
        if (this.f16414u != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, m17101n());
            layoutParams.addRule(12);
            layoutParams.bottomMargin = Util.m24198Z();
            this.f16414u.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m17126b() {
        CameraLog.m12954a("StickerMenu", "onPause");
        if (m17140g()) {
            m17130b(true, false, false);
        }
        m17123a(false);
        this.f16383N = -1;
        m17139f();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m17131c() {
        CameraLog.m12954a("StickerMenu", "onDestroy");
        this.f16412s = null;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m17134d() {
        if (this.f16417x == null) {
            CameraLog.m12952a("StickerMenus.initEffectMenuPanel");
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, m17101n());
            layoutParams.addRule(12);
            layoutParams.bottomMargin = Util.m24198Z();
            this.f16414u = (RelativeLayout) LayoutInflater.from(this.f16412s).inflate(R.layout.sticker_page_view, (ViewGroup) null);
            RelativeLayout relativeLayout = (RelativeLayout) this.f16412s.findViewById(R.id_renamed.control_panel_button_layout);
            RelativeLayout relativeLayout2 = (RelativeLayout) this.f16412s.findViewById(R.id_renamed.control_panel_layout);
            this.f16416w = (MainShutterButton) this.f16412s.findViewById(R.id_renamed.shutter_button);
            relativeLayout2.addView(this.f16414u, relativeLayout2.indexOfChild(relativeLayout), layoutParams);
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f16416w, "translationY", 0.0f, m17103o());
            objectAnimatorOfFloat.setInterpolator(this.f16402i);
            objectAnimatorOfFloat.setDuration(300L);
            this.f16405l = new AnimatorSet();
            this.f16405l.play(objectAnimatorOfFloat);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f16416w, "translationY", m17103o(), 0.0f);
            objectAnimatorOfFloat2.setInterpolator(this.f16402i);
            objectAnimatorOfFloat2.setDuration(300L);
            this.f16406m = new AnimatorSet();
            this.f16406m.play(objectAnimatorOfFloat2);
            StickerMenuListener interfaceC3016i = this.f16370A;
            StickerItem stickerItemMo12672f = interfaceC3016i != null ? interfaceC3016i.mo12672f() : null;
            this.f16417x = (StickerPageView) this.f16412s.findViewById(R.id_renamed.page_view);
            this.f16419z = new StickerPageAdapter(this.f16412s, this.f16411r, stickerItemMo12672f, this.f16370A, this.f16371B);
            if (-1 == this.f16383N && 1 < this.f16419z.mo5000a()) {
                this.f16383N = 1;
            }
            this.f16419z.m17152c(this.f16383N);
            this.f16417x.setAdapter(this.f16419z);
            this.f16417x.m4977a(this.f16419z.m17153d(), false);
            this.f16417x.setStickerCategoryInterface(this.f16377H);
            this.f16417x.setOnPageChangeListener(new ViewPager.InterfaceC0827f() { // from class: com.oplus.camera.sticker.ui.COUIBaseListPopupWindow_10.13
                @Override // androidx.viewpager.widget.ViewPager.InterfaceC0827f
                public void onPageScrolled(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12, int i2) {
                    if (COUIBaseListPopupWindow_12 != 0.0f || StickerMenu.this.f16376G == null || OplusGLSurfaceView_13 >= StickerMenu.this.f16376G.getItemCount()) {
                        return;
                    }
                    StickerMenu.this.f16370A.mo12662a(StickerMenu.this.f16376G.m17073a(OplusGLSurfaceView_13).f16443c);
                }

                @Override // androidx.viewpager.widget.ViewPager.InterfaceC0827f
                public void onPageSelected(int OplusGLSurfaceView_13) {
                    int i2;
                    CameraLog.m12959b("StickerMenu", "onPageSelected, position: " + OplusGLSurfaceView_13);
                    if (OplusGLSurfaceView_13 == 0) {
                        StickerMenu.this.f16377H.mo17078a(0, 0, StickerMenu.this.f16388S.f16443c, false);
                    }
                    if (StickerMenu.this.f16419z == null || StickerMenu.this.f16376G == null || StickerMenu.this.f16377H == null || StickerMenu.this.f16380K == null || StickerMenu.this.f16383N == OplusGLSurfaceView_13) {
                        return;
                    }
                    int iFindFirstCompletelyVisibleItemPosition = StickerMenu.this.f16386Q.findFirstCompletelyVisibleItemPosition();
                    int iFindLastCompletelyVisibleItemPosition = StickerMenu.this.f16386Q.findLastCompletelyVisibleItemPosition();
                    int i3 = OplusGLSurfaceView_13 - 1;
                    if (i3 < 0) {
                        StickerMenu.this.f16380K.scrollTo(0, 0);
                        StickerMenu c3015h = StickerMenu.this;
                        c3015h.m17121a(c3015h.f16376G.m17073a(0).f16443c, false);
                    } else {
                        if (iFindFirstCompletelyVisibleItemPosition > i3 || i3 > iFindLastCompletelyVisibleItemPosition) {
                            int itemCount = StickerMenu.this.f16376G.getItemCount();
                            if (i3 == 0 || 1 == i3 || (2 == i3 && 2 == StickerMenu.this.f16383N)) {
                                StickerMenu.this.f16380K.scrollToPosition(0);
                            } else {
                                int i4 = itemCount - 1;
                                if (i3 == i4 || i3 == itemCount - 2 || (i3 == itemCount - 3 && StickerMenu.this.f16383N == i2)) {
                                    StickerMenu.this.f16380K.scrollToPosition(i4);
                                } else {
                                    if (i3 > StickerMenu.this.f16383N - 1) {
                                        StickerMenu.this.f16380K.scrollToPosition(i3 - 3);
                                    } else {
                                        StickerMenu.this.f16380K.scrollToPosition(i3 - 1);
                                    }
                                    StickerMenu.this.f16384O = true;
                                    StickerMenu.this.f16387R.m17145a(i3);
                                }
                            }
                        } else {
                            StickerMenu.this.m17113a(i3);
                        }
                        StickerMenu c3015h2 = StickerMenu.this;
                        c3015h2.m17121a(c3015h2.f16376G.m17073a(i3).f16443c, false);
                    }
                    StickerMenu.this.f16383N = OplusGLSurfaceView_13;
                    StickerMenu.this.f16419z.m17152c(StickerMenu.this.f16383N);
                    StickerMenu.this.f16376G.m17075b(i3);
                    StickerMenu.this.m17093j();
                }

                @Override // androidx.viewpager.widget.ViewPager.InterfaceC0827f
                public void onPageScrollStateChanged(int OplusGLSurfaceView_13) {
                    CameraLog.m12959b("StickerMenu", "onPageScrollStateChanged, position: " + OplusGLSurfaceView_13);
                }
            });
            this.f16418y = new RotateImageView(this.f16412s);
            this.f16418y.setImageDrawable(this.f16375F);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            if (this.f16410q) {
                layoutParams2.addRule(11);
                layoutParams2.rightMargin = this.f16412s.getResources().getDimensionPixelSize(R.dimen.sticker_music_margin_right);
            } else {
                layoutParams2.addRule(9);
                layoutParams2.leftMargin = this.f16412s.getResources().getDimensionPixelSize(R.dimen.sticker_music_margin_right);
            }
            layoutParams2.addRule(8);
            layoutParams2.bottomMargin = this.f16412s.getResources().getDimensionPixelSize(R.dimen.sticker_music_margin_bottom);
            layoutParams2.addRule(2, R.id_renamed.control_panel_layout);
            this.f16413t.addView(this.f16418y, layoutParams2);
            this.f16418y.setVisibility(this.f16372C ? 0 : 4);
            this.f16418y.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.sticker.ui.COUIBaseListPopupWindow_10.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (StickerMenu.this.f16370A != null) {
                        StickerMenu.this.f16370A.mo12674h();
                    }
                }
            });
        } else {
            StickerMenuListener interfaceC3016i2 = this.f16370A;
            this.f16419z = new StickerPageAdapter(this.f16412s, this.f16411r, interfaceC3016i2 != null ? interfaceC3016i2.mo12672f() : null, this.f16370A, this.f16371B);
            this.f16419z.m17152c(this.f16383N);
            this.f16417x.setAdapter(this.f16419z);
            this.f16417x.m4977a(this.f16419z.m17153d(), false);
        }
        CameraLog.m12958b("StickerMenus.initEffectMenuPanel");
    }

    /* compiled from: StickerMenu.java */
    /* renamed from: com.oplus.camera.sticker.ui.COUIBaseListPopupWindow_10$IntrinsicsJvm.kt_5 */
    public class IntrinsicsJvm.kt_5 implements View.OnLayoutChangeListener {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private int f16457b = -1;

        public IntrinsicsJvm.kt_5() {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m17145a(int OplusGLSurfaceView_13) {
            this.f16457b = OplusGLSurfaceView_13;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (StickerMenu.this.f16384O) {
                int i9 = this.f16457b;
                if (i9 != -1) {
                    StickerMenu.this.m17113a(i9);
                }
                StickerMenu.this.f16384O = false;
                this.f16457b = -1;
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17113a(int OplusGLSurfaceView_13) {
        int i2;
        int i3;
        int i4;
        if (this.f16376G != null) {
            int childCount = this.f16380K.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = this.f16380K.getChildAt(i5);
                if (((Integer) childAt.getTag()).intValue() == OplusGLSurfaceView_13) {
                    int left = childAt.getLeft();
                    int itemCount = this.f16376G.getItemCount();
                    if (OplusGLSurfaceView_13 == 0) {
                        i4 = this.f16398e;
                    } else {
                        if (OplusGLSurfaceView_13 == 1) {
                            i2 = this.f16398e + this.f16394a;
                            i3 = this.f16395b;
                        } else if (OplusGLSurfaceView_13 == itemCount - 1) {
                            i2 = this.f16398e + (this.f16394a * 4);
                            i3 = this.f16395b * 4;
                        } else if (OplusGLSurfaceView_13 == itemCount - 2) {
                            i2 = this.f16398e + (this.f16394a * 3);
                            i3 = this.f16395b * 3;
                        } else {
                            i2 = this.f16398e + (this.f16394a * 2);
                            i3 = this.f16395b * 2;
                        }
                        i4 = i2 + i3;
                    }
                    int i6 = left - i4;
                    if (i6 != Integer.MAX_VALUE) {
                        this.f16380K.smoothScrollBy(i6, 0);
                    }
                }
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17116a(final StickerItem stickerItem, final boolean z) {
        Activity activity = this.f16412s;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.sticker.ui.COUIBaseListPopupWindow_10.15
                @Override // java.lang.Runnable
                public void run() {
                    if (StickerMenu.this.f16419z != null) {
                        StickerMenu.this.f16419z.m17147a(stickerItem, z);
                    }
                }
            });
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17121a(String str, boolean z) {
        StickerPageAdapter c3017j = this.f16419z;
        if (c3017j != null) {
            c3017j.m17150a(str, z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17115a(StickerItem stickerItem) {
        if (stickerItem == null) {
            this.f16372C = false;
        } else {
            m17128b(stickerItem.getStickerUUID());
            this.f16372C = stickerItem.hasMusic();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m17128b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f16375F = ImageStickerTools.m22687b(this.f16412s).m22717a(str) ? this.f16374E : this.f16373D;
        RotateImageView rotateImageView = this.f16418y;
        if (rotateImageView != null) {
            rotateImageView.setImageDrawable(this.f16375F);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17120a(String str, int OplusGLSurfaceView_13, int i2, String str2, boolean z, StickerItem stickerItem) throws Throwable {
        if (this.f16419z == null || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f16419z.m17149a(str, OplusGLSurfaceView_13, i2, ImageStickerTools.m22687b(this.f16412s).m22705a(this.f16412s, Uri.parse(str2)), z, stickerItem);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m17137e() {
        CameraLog.m12954a("StickerMenu", "registerNavigationBarObserver");
        this.f16412s.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("manual_hide_navigationbar"), true, this.f16393X);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m17139f() {
        CameraLog.m12954a("StickerMenu", "unregisterNavigationBarObserver");
        this.f16412s.getContentResolver().unregisterContentObserver(this.f16393X);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17118a(StickerMenuListener interfaceC3016i) {
        this.f16370A = interfaceC3016i;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17117a(ImageDownloader c3010c) {
        this.f16371B = c3010c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17114a(int OplusGLSurfaceView_13, boolean z, boolean z2) {
        CameraLog.m12954a("StickerMenu", "setVisibility, visible: " + OplusGLSurfaceView_13 + ", includePanel: " + z2);
        if (z) {
            if (m17140g()) {
                if (z2) {
                    RelativeLayout relativeLayout = this.f16414u;
                    if (relativeLayout != null) {
                        Util.m24270a(relativeLayout, OplusGLSurfaceView_13, (Animation.AnimationListener) null, 300L);
                    }
                    StickerCategoryContainer c3013f = this.f16379J;
                    if (c3013f != null) {
                        Util.m24270a(c3013f, OplusGLSurfaceView_13, (Animation.AnimationListener) null, 300L);
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.f16415v != null) {
                m17095k();
                if (OplusGLSurfaceView_13 == 0) {
                    Animator animatorM17099m = m17099m();
                    if (animatorM17099m != null) {
                        animatorM17099m.start();
                        return;
                    }
                    return;
                }
                Animator animatorM17097l = m17097l();
                if (animatorM17097l != null) {
                    animatorM17097l.start();
                    return;
                }
                return;
            }
            return;
        }
        if (!m17140g()) {
            if (this.f16415v != null) {
                m17095k();
                this.f16415v.setVisibility(OplusGLSurfaceView_13);
                this.f16415v.setAlpha(OplusGLSurfaceView_13 == 0 ? 1.0f : 0.0f);
                return;
            }
            return;
        }
        if (z2) {
            RelativeLayout relativeLayout2 = this.f16414u;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(OplusGLSurfaceView_13);
            }
            StickerCategoryContainer c3013f2 = this.f16379J;
            if (c3013f2 != null) {
                c3013f2.setVisibility(OplusGLSurfaceView_13);
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private void m17095k() {
        Animator animator = this.f16407n;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.f16408o;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private Animator m17097l() {
        RotateImageView rotateImageView = this.f16415v;
        if (rotateImageView != null && rotateImageView.getVisibility() != 0) {
            return null;
        }
        this.f16408o = ObjectAnimator.ofFloat(this.f16415v, "alpha", 1.0f, 0.0f);
        this.f16408o.setInterpolator(this.f16401h);
        this.f16408o.setDuration(180L);
        this.f16408o.addListener(new Animator.AnimatorListener() { // from class: com.oplus.camera.sticker.ui.COUIBaseListPopupWindow_10.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                StickerMenu.this.f16415v.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                StickerMenu.this.f16415v.setClickable(false);
                StickerMenu.this.f16415v.setVisibility(4);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                StickerMenu.this.f16415v.setClickable(true);
                StickerMenu.this.f16415v.setVisibility(0);
                StickerMenu.this.f16415v.setAlpha(1.0f);
            }
        });
        return this.f16408o;
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private Animator m17099m() {
        if (this.f16415v.getVisibility() == 0 && 1.0f == this.f16415v.getAlpha()) {
            return null;
        }
        this.f16407n = ObjectAnimator.ofFloat(this.f16415v, "alpha", 0.0f, 1.0f);
        this.f16407n.setInterpolator(this.f16401h);
        this.f16407n.setDuration(180L);
        this.f16407n.addListener(new Animator.AnimatorListener() { // from class: com.oplus.camera.sticker.ui.COUIBaseListPopupWindow_10.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                StickerMenu.this.f16415v.setVisibility(0);
                StickerMenu.this.f16415v.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                StickerMenu.this.f16415v.setClickable(true);
                if (StickerMenu.this.f16389T != null) {
                    StickerMenu.this.f16389T.m17143a();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                StickerMenu.this.f16415v.setClickable(false);
                StickerMenu.this.f16415v.setVisibility(4);
                StickerMenu.this.f16415v.setAlpha(0.0f);
            }
        });
        return this.f16407n;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17123a(boolean z) {
        RotateImageView rotateImageView;
        CameraLog.m12954a("StickerMenu", "setEnable, enable: " + z + ", isStickerMenuOpen: " + m17140g());
        if (m17140g() || (rotateImageView = this.f16415v) == null) {
            return;
        }
        rotateImageView.setClickable(z);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m17132c(String str) {
        if ("square".equals(str)) {
            RotateImageView rotateImageView = this.f16415v;
            rotateImageView.setBackground(rotateImageView.getResources().getDrawable(R.drawable.switch_camera_button_gray_bg));
        } else {
            RotateImageView rotateImageView2 = this.f16415v;
            rotateImageView2.setBackground(rotateImageView2.getResources().getDrawable(R.drawable.common_button_bg));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m17129b(boolean z) {
        CameraLog.m12954a("StickerMenu", "setStickerPanelEnable, enable: " + z);
        StickerPageAdapter c3017j = this.f16419z;
        if (c3017j != null) {
            c3017j.m17151a(z);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public boolean m17140g() {
        AnimatorSet animatorSet;
        return this.f16409p || ((animatorSet = this.f16403j) != null && animatorSet.isRunning());
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m17135d(final String str) {
        Activity activity = this.f16412s;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.sticker.ui.COUIBaseListPopupWindow_10.4
                @Override // java.lang.Runnable
                public void run() {
                    StickerMenu.this.f16372C = true;
                    StickerMenu.this.m17128b(str);
                    Util.m24270a(StickerMenu.this.f16418y, 0, (Animation.AnimationListener) null, 300L);
                    if (StickerMenu.this.f16379J != null) {
                        StickerMenu.this.f16379J.m17077a(StickerMenu.this.f16372C);
                    }
                }
            });
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m17141h() {
        Activity activity = this.f16412s;
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.oplus.camera.sticker.ui.COUIBaseListPopupWindow_10.5
                @Override // java.lang.Runnable
                public void run() {
                    StickerMenu.this.f16372C = false;
                    Util.m24270a(StickerMenu.this.f16418y, 8, (Animation.AnimationListener) null, 300L);
                    if (StickerMenu.this.f16379J != null) {
                        StickerMenu.this.f16379J.m17077a(StickerMenu.this.f16372C);
                    }
                }
            });
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m17127b(int OplusGLSurfaceView_13) {
        this.f16411r = OplusGLSurfaceView_13;
        RotateImageView rotateImageView = this.f16415v;
        if (rotateImageView != null) {
            rotateImageView.m18348a(this.f16411r, true);
        }
        StickerPageAdapter c3017j = this.f16419z;
        if (c3017j != null) {
            c3017j.m17154d(this.f16411r);
        }
        StickerCategoryAdapter c3012e = this.f16376G;
        if (c3012e != null) {
            c3012e.m17076c(this.f16411r);
        }
        RotateImageView rotateImageView2 = this.f16418y;
        if (rotateImageView2 != null) {
            rotateImageView2.m18348a(this.f16411r, true);
        }
        RotateImageView rotateImageView3 = this.f16381L;
        if (rotateImageView3 != null) {
            rotateImageView3.m18348a(this.f16411r, true);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m17133c(boolean z) {
        if (z) {
            this.f16415v.setImageDrawable(Util.m24376b(this.f16412s, R.drawable.sticker_menu_control_button_highlight));
        } else {
            this.f16415v.setImageResource(R.drawable.sticker_menu_control_button);
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public boolean m17142i() {
        AnimatorSet animatorSet = this.f16403j;
        if (animatorSet != null && animatorSet.isRunning()) {
            return true;
        }
        AnimatorSet animatorSet2 = this.f16404k;
        return animatorSet2 != null && animatorSet2.isRunning();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17122a(ArrayList<IntrinsicsJvm.kt_4> arrayList, int OplusGLSurfaceView_13, boolean z) {
        boolean z2;
        int i2;
        CameraLog.m12952a("StickerMenus.updateStickerCategoryMenu");
        if (this.f16378I == null) {
            this.f16379J = new StickerCategoryContainer(this.f16412s);
            this.f16379J.setBackgroundColor(this.f16412s.getResources().getColor(R.color.plugin_background_color));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f16412s.getResources().getDimensionPixelSize(R.dimen.sticker_recycle_background_height));
            layoutParams.addRule(2, R.id_renamed.control_panel_layout);
            this.f16378I = (RelativeLayout) LayoutInflater.from(this.f16412s).inflate(R.layout.sticker_category_menu, (ViewGroup) this.f16379J, false);
            this.f16376G = new StickerCategoryAdapter(this.f16412s, this.f16377H, this.f16411r);
            this.f16376G.m17074a(arrayList);
            this.f16381L = (RotateImageView) this.f16378I.findViewById(R.id_renamed.sticker_download_icon);
            this.f16388S = arrayList.get(0);
            this.f16381L.setImageDrawable(this.f16388S.f16442b);
            this.f16381L.setOnClickListener(this.f16391V);
            this.f16382M = (RotateImageView) this.f16378I.findViewById(R.id_renamed.iv_back);
            this.f16382M.setOnClickListener(this.f16392W);
            this.f16380K = (StickerCategoryRecycleView) this.f16378I.findViewById(R.id_renamed.RecyclerView);
            this.f16380K.addOnLayoutChangeListener(this.f16387R);
            this.f16380K.setStickerCategoryInterface(this.f16377H);
            this.f16386Q = new LinearLayoutManager(this.f16412s);
            this.f16386Q.setOrientation(0);
            this.f16380K.setItemViewCacheSize(100);
            this.f16380K.setLayoutManager(this.f16386Q);
            this.f16380K.setAdapter(this.f16376G);
            this.f16385P = new IntrinsicsJvm.kt_3(this.f16412s, this.f16395b, this.f16398e, this.f16396c);
            this.f16380K.addItemDecoration(this.f16385P);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.f16394a);
            layoutParams2.addRule(5);
            layoutParams2.leftMargin = this.f16399f - this.f16398e;
            layoutParams2.rightMargin = this.f16400g;
            layoutParams2.topMargin = this.f16397d;
            if (!m17140g() || this.f16376G.getItemCount() <= 1) {
                this.f16379J.setVisibility(4);
            }
            this.f16379J.addView(this.f16378I, layoutParams2);
            RelativeLayout relativeLayout = (RelativeLayout) this.f16412s.findViewById(R.id_renamed.control_panel_layout);
            RelativeLayout relativeLayout2 = this.f16413t;
            relativeLayout2.addView(this.f16379J, relativeLayout2.indexOfChild(relativeLayout), layoutParams);
        } else if (arrayList.size() > 1) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f16378I.getLayoutParams();
            layoutParams3.width = -1;
            layoutParams3.height = this.f16394a;
            layoutParams3.addRule(5);
            layoutParams3.leftMargin = this.f16399f - this.f16398e;
            layoutParams3.rightMargin = this.f16400g;
            layoutParams3.topMargin = this.f16397d;
            this.f16378I.setLayoutParams(layoutParams3);
            this.f16376G.m17074a(arrayList);
            this.f16376G.notifyDataSetChanged();
        }
        if (z || (i2 = this.f16383N) == -1 || i2 >= arrayList.size()) {
            if (-1 == this.f16383N) {
                this.f16383N = 1;
            } else {
                this.f16383N = OplusGLSurfaceView_13;
            }
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.f16383N < arrayList.size()) {
            StickerPageAdapter c3017j = this.f16419z;
            if (c3017j != null) {
                c3017j.m17152c(this.f16383N);
                this.f16417x.m4977a(this.f16419z.m17153d(), false);
            }
            if (z2) {
                this.f16384O = true;
                this.f16387R.m17145a(this.f16383N);
            }
            this.f16385P.m17144a(arrayList.size());
            m17121a(arrayList.get(this.f16383N).f16443c, true);
        }
        int i3 = this.f16383N - 1;
        StickerCategoryAdapter c3012e = this.f16376G;
        if (c3012e != null && this.f16380K != null && i3 >= 0 && i3 < c3012e.getItemCount()) {
            this.f16376G.m17075b(i3);
            this.f16380K.scrollToPosition(i3);
            m17093j();
        }
        CameraLog.m12958b("StickerMenus.updateStickerCategoryMenu");
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m17136d(boolean z) {
        StickerCategoryContainer c3013f;
        CameraLog.m12954a("StickerMenu", "show, isAnim: " + z);
        AnimatorSet animatorSet = this.f16404k;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.f16409p = true;
        RotateImageView rotateImageView = this.f16415v;
        if (rotateImageView != null) {
            rotateImageView.setClickable(false);
        }
        RelativeLayout relativeLayout = this.f16414u;
        if (relativeLayout != null) {
            relativeLayout.setEnabled(false);
        }
        RelativeLayout relativeLayout2 = this.f16378I;
        if (relativeLayout2 != null) {
            relativeLayout2.setEnabled(false);
        }
        StickerMenuListener interfaceC3016i = this.f16370A;
        if (interfaceC3016i != null) {
            interfaceC3016i.mo12671e();
            this.f16370A.mo12663a(z);
        }
        m17134d();
        AnimatorSet animatorSet2 = this.f16405l;
        if (animatorSet2 != null) {
            animatorSet2.start();
        }
        if (z) {
            Util.m24270a(this.f16414u, 0, (Animation.AnimationListener) null, 300L);
            if (this.f16372C) {
                Util.m24270a(this.f16418y, 0, (Animation.AnimationListener) null, 300L);
            }
            StickerCategoryAdapter c3012e = this.f16376G;
            if (c3012e != null && c3012e.getItemCount() > 1 && (c3013f = this.f16379J) != null) {
                Util.m24270a(c3013f, 0, (Animation.AnimationListener) null, 300L);
                this.f16379J.m17077a(this.f16372C);
            }
            this.f16403j = new AnimatorSet();
            this.f16403j.play(m17097l());
            this.f16403j.addListener(new Animator.AnimatorListener() { // from class: com.oplus.camera.sticker.ui.COUIBaseListPopupWindow_10.6
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (StickerMenu.this.f16414u != null) {
                        StickerMenu.this.f16414u.setEnabled(true);
                    }
                    if (StickerMenu.this.f16370A != null) {
                        StickerMenu.this.f16370A.mo12661a();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    if (StickerMenu.this.f16414u != null) {
                        StickerMenu.this.f16414u.setEnabled(true);
                    }
                    if (StickerMenu.this.f16370A != null) {
                        StickerMenu.this.f16370A.mo12661a();
                    }
                }
            });
            this.f16403j.start();
        } else {
            RotateImageView rotateImageView2 = this.f16415v;
            if (rotateImageView2 != null) {
                rotateImageView2.setAlpha(0.0f);
            }
            RelativeLayout relativeLayout3 = this.f16414u;
            if (relativeLayout3 != null) {
                relativeLayout3.setVisibility(0);
                this.f16414u.setEnabled(true);
            }
            StickerMenuListener interfaceC3016i2 = this.f16370A;
            if (interfaceC3016i2 != null) {
                interfaceC3016i2.mo12661a();
            }
            StickerCategoryAdapter c3012e2 = this.f16376G;
            if (c3012e2 != null && c3012e2.getItemCount() > 1) {
                StickerCategoryContainer c3013f2 = this.f16379J;
                if (c3013f2 != null) {
                    c3013f2.setVisibility(0);
                    this.f16379J.m17077a(this.f16372C);
                }
                m17113a(this.f16383N);
            }
        }
        this.f16412s.getWindow().setNavigationBarColor(this.f16412s.getColor(R.color.background_color));
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m17138e(boolean z) {
        m17125a(z, true, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17125a(boolean z, final boolean z2, boolean z3) {
        AnimatorSet animatorSet = this.f16403j;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.f16405l;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        RelativeLayout relativeLayout = this.f16414u;
        if (relativeLayout != null) {
            relativeLayout.setEnabled(false);
        }
        RelativeLayout relativeLayout2 = this.f16378I;
        if (relativeLayout2 != null) {
            relativeLayout2.setEnabled(false);
        }
        StickerMenuListener interfaceC3016i = this.f16370A;
        if (interfaceC3016i != null && z2) {
            interfaceC3016i.mo12666b();
        }
        Util.m24270a(this.f16414u, 4, (Animation.AnimationListener) null, 300L);
        this.f16412s.getWindow().setNavigationBarColor(this.f16412s.getColor(android.R.color.transparent));
        StickerCategoryContainer c3013f = this.f16379J;
        if (c3013f != null) {
            Util.m24270a(c3013f, 4, (Animation.AnimationListener) null, 300L);
            this.f16379J.m17077a(this.f16372C);
        }
        if (this.f16372C) {
            Util.m24270a(this.f16418y, 4, (Animation.AnimationListener) null, 300L);
        }
        this.f16404k = new AnimatorSet();
        if (!z) {
            this.f16404k.play(m17099m());
        }
        this.f16404k.addListener(new Animator.AnimatorListener() { // from class: com.oplus.camera.sticker.ui.COUIBaseListPopupWindow_10.7
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (StickerMenu.this.f16414u != null) {
                    StickerMenu.this.f16414u.setEnabled(true);
                }
                if (StickerMenu.this.f16378I != null) {
                    StickerMenu.this.f16378I.setEnabled(true);
                }
                if (StickerMenu.this.f16370A == null || !z2) {
                    return;
                }
                StickerMenu.this.f16370A.mo12669c();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (StickerMenu.this.f16414u != null) {
                    StickerMenu.this.f16414u.setEnabled(true);
                }
                if (StickerMenu.this.f16370A != null && z2) {
                    StickerMenu.this.f16370A.mo12669c();
                }
                if (StickerMenu.this.f16378I != null) {
                    StickerMenu.this.f16378I.setEnabled(true);
                }
            }
        });
        AnimatorSet animatorSet3 = this.f16406m;
        if (animatorSet3 != null && z3) {
            animatorSet3.start();
        }
        this.f16404k.start();
        this.f16409p = false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m17130b(boolean z, boolean z2, boolean z3) {
        AnimatorSet animatorSet = this.f16403j;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.f16404k;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        AnimatorSet animatorSet3 = this.f16405l;
        if (animatorSet3 != null) {
            animatorSet3.cancel();
        }
        AnimatorSet animatorSet4 = this.f16406m;
        if (animatorSet4 != null) {
            animatorSet4.cancel();
        }
        RelativeLayout relativeLayout = this.f16414u;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
        StickerCategoryContainer c3013f = this.f16379J;
        if (c3013f != null) {
            c3013f.setVisibility(4);
            this.f16379J.m17077a(this.f16372C);
        }
        RotateImageView rotateImageView = this.f16418y;
        if (rotateImageView != null && this.f16372C) {
            rotateImageView.setVisibility(4);
        }
        RotateImageView rotateImageView2 = this.f16415v;
        if (rotateImageView2 != null) {
            rotateImageView2.setTranslationY(0.0f);
            this.f16415v.setTranslationX(0.0f);
            this.f16415v.setAlpha(1.0f);
            if (z) {
                this.f16415v.setVisibility(4);
            }
        }
        MainShutterButton mainShutterButton = this.f16416w;
        if (mainShutterButton != null) {
            mainShutterButton.setTranslationY(0.0f);
            this.f16416w.setScaleX(1.0f);
            this.f16416w.setScaleY(1.0f);
        }
        RotateImageView rotateImageView3 = this.f16415v;
        if (rotateImageView3 != null) {
            rotateImageView3.setClickable(true);
        }
        StickerMenuListener interfaceC3016i = this.f16370A;
        if (interfaceC3016i != null) {
            interfaceC3016i.mo12668b(z2);
        }
        this.f16409p = false;
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private int m17101n() {
        return Util.m24187O() - Util.m24198Z();
    }

    /* renamed from: o */
    private int m17103o() {
        return this.f16412s.getResources().getDimensionPixelSize(R.dimen.sticker_shutter_button_translate_y);
    }

    /* compiled from: StickerMenu.java */
    /* renamed from: com.oplus.camera.sticker.ui.COUIBaseListPopupWindow_10$IntrinsicsJvm.kt_3 */
    class IntrinsicsJvm.kt_3 extends RecyclerView.AbstractC0692h {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private int f16446b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private int f16447c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private int f16448d = 0;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private int f16449e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private int f16450f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private int f16451g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        private int f16452h;

        /* renamed from: OplusGLSurfaceView_13 */
        private int f16453i;

        /* renamed from: OplusGLSurfaceView_15 */
        private Activity f16454j;

        /* renamed from: OplusGLSurfaceView_5 */
        private Paint f16455k;

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0692h
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.C0704t c0704t) {
            super.getItemOffsets(rect, view, recyclerView, c0704t);
            rect.top = 0;
            rect.bottom = 0;
            if (this.f16448d > 6) {
                if (StickerMenu.this.f16410q) {
                    if (((Integer) view.getTag()).intValue() == 0) {
                        rect.right = 0;
                        rect.left = this.f16447c;
                        return;
                    } else if (((Integer) view.getTag()).intValue() == this.f16448d - 1) {
                        rect.right = this.f16447c;
                        rect.left = this.f16446b;
                        return;
                    } else {
                        rect.right = 0;
                        rect.left = this.f16446b;
                        return;
                    }
                }
                if (((Integer) view.getTag()).intValue() == 0) {
                    rect.left = 0;
                    rect.right = this.f16447c;
                    return;
                } else if (((Integer) view.getTag()).intValue() == this.f16448d - 1) {
                    rect.left = this.f16447c;
                    rect.right = this.f16446b;
                    return;
                } else {
                    rect.left = 0;
                    rect.right = this.f16446b;
                    return;
                }
            }
            if (StickerMenu.this.f16410q) {
                if (((Integer) view.getTag()).intValue() == 0) {
                    rect.right = 0;
                    rect.left = this.f16447c;
                    return;
                } else {
                    if (((Integer) view.getTag()).intValue() != 0) {
                        rect.right = 0;
                        rect.left = this.f16446b;
                        return;
                    }
                    return;
                }
            }
            if (((Integer) view.getTag()).intValue() == 0) {
                rect.left = 0;
                rect.right = this.f16447c;
            } else if (((Integer) view.getTag()).intValue() != 0) {
                rect.left = 0;
                rect.right = this.f16446b;
            }
        }

        public IntrinsicsJvm.kt_3(Activity activity, int OplusGLSurfaceView_13, int i2, int i3) throws Resources.NotFoundException {
            int screenWidth;
            this.f16446b = 0;
            this.f16447c = 0;
            this.f16449e = 0;
            this.f16450f = 0;
            this.f16451g = 0;
            this.f16452h = 0;
            this.f16453i = 0;
            this.f16454j = null;
            this.f16455k = null;
            this.f16454j = activity;
            this.f16446b = OplusGLSurfaceView_13;
            this.f16447c = i2;
            this.f16449e = i3;
            if (StickerMenu.this.f16410q) {
                screenWidth = this.f16454j.getResources().getDimensionPixelSize(R.dimen.sticker_recycle_line_left_padding);
            } else {
                screenWidth = Util.getScreenWidth() - this.f16454j.getResources().getDimensionPixelSize(R.dimen.sticker_recycle_line_left_padding);
            }
            this.f16450f = screenWidth;
            this.f16451g = this.f16454j.getResources().getDimensionPixelSize(R.dimen.sticker_recycle_line_top_padding);
            this.f16452h = this.f16454j.getResources().getDimensionPixelSize(R.dimen.sticker_recycle_line_width);
            this.f16453i = this.f16454j.getResources().getDimensionPixelSize(R.dimen.sticker_recycle_line_height);
            this.f16455k = new Paint();
            this.f16455k.setColor(this.f16454j.getResources().getColor(R.color.color_white_with_30_percent_transparency));
            this.f16455k.setStrokeWidth(this.f16452h);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m17144a(int OplusGLSurfaceView_13) {
            this.f16448d = OplusGLSurfaceView_13;
        }
    }

    /* compiled from: StickerMenu.java */
    /* renamed from: com.oplus.camera.sticker.ui.COUIBaseListPopupWindow_10$IntrinsicsJvm.kt_4 */
    public static class IntrinsicsJvm.kt_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        public Drawable f16441a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public Drawable f16442b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public String f16443c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public boolean f16444d;

        public IntrinsicsJvm.kt_4(Drawable drawable, Drawable drawable2, String str, boolean z) {
            this.f16441a = null;
            this.f16442b = null;
            this.f16443c = null;
            this.f16444d = false;
            this.f16441a = drawable;
            this.f16442b = drawable2;
            this.f16443c = str;
            this.f16444d = z;
        }
    }
}
