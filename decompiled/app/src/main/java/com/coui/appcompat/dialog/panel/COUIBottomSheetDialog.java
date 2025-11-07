package com.coui.appcompat.dialog.panel;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsAnimationController;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.p031c.MathUtils;
import com.coui.appcompat.dialog.panel.COUIPanelImeAnimController;
import com.coui.appcompat.dialog.panel.COUIBottomSheetBehavior;
import com.coui.appcompat.p099a.COUIDarkModeUtil;
import com.coui.appcompat.p099a.COUINavigationBarUtil;
import com.coui.appcompat.p099a.COUIPanelMultiWindowUtils;
import com.coui.appcompat.p099a.COUIThemeOverlay;
import com.coui.appcompat.p099a.COUIViewMarginUtil;
import com.coui.appcompat.widget.COUIPanelConstraintLayout;
import com.coui.appcompat.widget.IgnoreWindowInsetsFrameLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.p078a.p079a.Spring;
import com.p078a.p079a.SpringConfig;
import com.p078a.p079a.SpringSystem;
import com.p078a.p079a.SpringListener;
import coui.support.appcompat.R;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: COUIBottomSheetDialog.java */
/* renamed from: com.coui.appcompat.dialog.panel.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public class COUIBottomSheetDialog extends BottomSheetDialog {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final Interpolator f6716a = new PathInterpolator(0.0f, 0.0f, 0.15f, 1.0f);

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final Interpolator f6717b = new PathInterpolator(0.0f, 0.0f, 1.0f, 1.0f);

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final Interpolator f6718c = f6716a;

    /* renamed from: A */
    private boolean f6719A;

    /* renamed from: B */
    private boolean f6720B;

    /* renamed from: C */
    private int f6721C;

    /* renamed from: D */
    private int f6722D;

    /* renamed from: E */
    private int f6723E;

    /* renamed from: F */
    private View f6724F;

    /* renamed from: G */
    private Spring f6725G;

    /* renamed from: H */
    private Spring f6726H;

    /* renamed from: I */
    private View f6727I;

    /* renamed from: J */
    private ViewGroup f6728J;

    /* renamed from: K */
    private int f6729K;

    /* renamed from: L */
    private boolean f6730L;

    /* renamed from: M */
    private boolean f6731M;

    /* renamed from: N */
    private BottomSheetBehavior f6732N;

    /* renamed from: O */
    private boolean f6733O;

    /* renamed from: P */
    private InputMethodManager f6734P;

    /* renamed from: Q */
    private AnimatorSet f6735Q;

    /* renamed from: R */
    private float f6736R;

    /* renamed from: S */
    private float f6737S;

    /* renamed from: T */
    private boolean f6738T;

    /* renamed from: U */
    private boolean f6739U;

    /* renamed from: V */
    private int f6740V;

    /* renamed from: W */
    private View.OnApplyWindowInsetsListener f6741W;

    /* renamed from: X */
    private COUIPanelPullUpListener f6742X;

    /* renamed from: Y */
    private COUIPanelAdjustResizeHelper f6743Y;

    /* renamed from: Z */
    private WindowInsets f6744Z;

    /* renamed from: aa */
    private WindowInsets f6745aa;

    /* renamed from: ab */
    private boolean f6746ab;

    /* renamed from: ac */
    private boolean f6747ac;

    /* renamed from: ad */
    private int f6748ad;

    /* renamed from: ae */
    private Handler f6749ae;

    /* renamed from: af */
    private final int f6750af;

    /* renamed from: ag */
    private boolean f6751ag;

    /* renamed from: ah */
    private boolean f6752ah;

    /* renamed from: ai */
    private COUIPanelImeAnimController f6753ai;

    /* renamed from: aj */
    private int f6754aj;

    /* renamed from: ak */
    private boolean f6755ak;

    /* renamed from: al */
    private boolean f6756al;

    /* renamed from: am */
    private boolean f6757am;

    /* renamed from: an */
    private boolean f6758an;

    /* renamed from: ao */
    private boolean f6759ao;

    /* renamed from: ap */
    private int f6760ap;

    /* renamed from: aq */
    private boolean f6761aq;

    /* renamed from: ar */
    private ViewTreeObserver.OnPreDrawListener f6762ar;

    /* renamed from: as */
    private ComponentCallbacks f6763as;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f6764d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private IgnoreWindowInsetsFrameLayout f6765e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private View f6766f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private View f6767g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private ViewGroup f6768h;

    /* renamed from: OplusGLSurfaceView_13 */
    private View f6769i;

    /* renamed from: OplusGLSurfaceView_15 */
    private COUIPanelConstraintLayout f6770j;

    /* renamed from: OplusGLSurfaceView_5 */
    private ViewGroup f6771k;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f6772l;

    /* renamed from: OplusGLSurfaceView_6 */
    private String f6773m;

    /* renamed from: OplusGLSurfaceView_11 */
    private View.OnClickListener f6774n;

    /* renamed from: o */
    private String f6775o;

    /* renamed from: p */
    private View.OnClickListener f6776p;

    /* renamed from: q */
    private String f6777q;

    /* renamed from: r */
    private View.OnClickListener f6778r;

    /* renamed from: s */
    private Drawable f6779s;

    /* renamed from: t */
    private int f6780t;

    /* renamed from: u */
    private Drawable f6781u;

    /* renamed from: v */
    private int f6782v;

    /* renamed from: w */
    private WeakReference<Activity> f6783w;

    /* renamed from: x */
    private boolean f6784x;

    /* renamed from: y */
    private View.OnTouchListener f6785y;

    /* renamed from: z */
    private boolean f6786z;

    public COUIBottomSheetDialog(Context context, int OplusGLSurfaceView_13) {
        super(context, m6717a(context, OplusGLSurfaceView_13));
        this.f6764d = 0;
        this.f6772l = true;
        this.f6784x = false;
        this.f6786z = true;
        this.f6719A = true;
        this.f6720B = true;
        this.f6723E = 0;
        this.f6729K = 0;
        this.f6730L = true;
        this.f6731M = false;
        this.f6736R = 0.0f;
        this.f6737S = 0.0f;
        this.f6738T = false;
        this.f6739U = false;
        this.f6740V = 0;
        this.f6741W = null;
        this.f6742X = null;
        this.f6750af = 500;
        this.f6751ag = false;
        this.f6752ah = false;
        this.f6754aj = 0;
        this.f6757am = true;
        this.f6758an = false;
        this.f6759ao = false;
        this.f6761aq = false;
        this.f6762ar = new ViewTreeObserver.OnPreDrawListener() { // from class: com.coui.appcompat.dialog.panel.IntrinsicsJvm.kt_4.6
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                COUIBottomSheetDialog.this.m6791t();
                if (!COUIBottomSheetDialog.this.f6752ah || COUIBottomSheetDialog.this.m6788s()) {
                    COUIBottomSheetDialog.this.f6752ah = false;
                    COUIBottomSheetDialog dialogC1309b = COUIBottomSheetDialog.this;
                    dialogC1309b.m6725a(0, true, dialogC1309b.m6792u());
                } else if (COUIBottomSheetDialog.this.f6728J != null) {
                    COUIBottomSheetDialog dialogC1309b2 = COUIBottomSheetDialog.this;
                    dialogC1309b2.f6764d = dialogC1309b2.f6767g.getMeasuredHeight();
                    int measuredHeight = COUIBottomSheetDialog.this.f6733O ? COUIBottomSheetDialog.this.f6764d : COUIBottomSheetDialog.this.f6728J.getMeasuredHeight() + COUIViewMarginUtil.m6502a(COUIBottomSheetDialog.this.f6728J, 3);
                    if (COUIBottomSheetDialog.this.f6731M) {
                        measuredHeight = COUIBottomSheetDialog.this.f6729K;
                    }
                    COUIBottomSheetDialog.this.f6728J.setTranslationY(measuredHeight);
                    COUIBottomSheetDialog.this.f6766f.setAlpha(0.0f);
                    return true;
                }
                return true;
            }
        };
        this.f6763as = new ComponentCallbacks() { // from class: com.coui.appcompat.dialog.panel.IntrinsicsJvm.kt_4.7
            @Override // android.content.ComponentCallbacks
            public void onLowMemory() {
            }

            @Override // android.content.ComponentCallbacks
            public void onConfigurationChanged(Configuration configuration) {
                COUIBottomSheetDialog.this.m6803a(configuration);
            }
        };
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, R.styleable.COUIBottomSheetDialog, R.attr.couiBottomSheetDialogStyle, OplusGLSurfaceView_13);
        this.f6779s = m6720a(typedArrayObtainStyledAttributes, R.styleable.COUIBottomSheetDialog_panelDragViewIcon, R.drawable.coui_panel_drag_view);
        this.f6780t = typedArrayObtainStyledAttributes.getColor(R.styleable.COUIBottomSheetDialog_panelDragViewTintColor, context.getResources().getColor(R.color.coui_panel_drag_view_color));
        this.f6781u = m6720a(typedArrayObtainStyledAttributes, R.styleable.COUIBottomSheetDialog_panelBackground, R.drawable.coui_panel_bg_without_shadow);
        this.f6782v = typedArrayObtainStyledAttributes.getColor(R.styleable.COUIBottomSheetDialog_panelBackgroundTintColor, context.getResources().getColor(R.color.coui_panel_layout_tint));
        typedArrayObtainStyledAttributes.recycle();
        Drawable drawable = this.f6781u;
        if (drawable != null) {
            drawable.setTint(this.f6782v);
        }
        if (context instanceof Activity) {
            this.f6783w = new WeakReference<>((Activity) context);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static int m6717a(Context context, int OplusGLSurfaceView_13) {
        if (((OplusGLSurfaceView_13 >>> 24) & 255) >= 1) {
            return OplusGLSurfaceView_13;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.couiBottomSheetDialogStyle, typedValue, true);
        return typedValue.resourceId;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Drawable m6720a(TypedArray typedArray, int OplusGLSurfaceView_13, int i2) {
        Drawable drawable = typedArray != null ? typedArray.getDrawable(OplusGLSurfaceView_13) : null;
        return drawable == null ? getContext().getResources().getDrawable(i2, getContext().getTheme()) : drawable;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(int OplusGLSurfaceView_13) throws Resources.NotFoundException, ClassNotFoundException {
        setContentView(getLayoutInflater().inflate(OplusGLSurfaceView_13, (ViewGroup) null));
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(View view) throws Resources.NotFoundException, ClassNotFoundException {
        if (view == null) {
            throw new IllegalArgumentException("ContentView can't be null");
        }
        COUIThemeOverlay.m6468a().m6479a(getContext());
        if (!this.f6784x) {
            this.f6770j = m6724a(view.getContext());
            m6797w();
            this.f6769i = view;
            this.f6770j.m7956b(this.f6769i);
            super.setContentView(this.f6770j);
            this.f6728J = (ViewGroup) this.f6770j.getParent();
        } else if (view != null) {
            this.f6769i = view;
            super.setContentView(view);
            this.f6728J = (ViewGroup) view.getParent();
        }
        this.f6724F = this.f6728J;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private COUIPanelConstraintLayout m6724a(Context context) {
        COUIPanelConstraintLayout c1487l = new COUIPanelConstraintLayout(context);
        Drawable drawable = this.f6779s;
        if (drawable != null) {
            drawable.setTint(this.f6780t);
            c1487l.setDragViewDrawable(this.f6779s);
        }
        c1487l.setBackground(this.f6781u);
        return c1487l;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m6758f() {
        if (this.f6770j != null) {
            this.f6770j.setLayoutParams(new FrameLayout.LayoutParams(m6756f(getContext().getResources().getConfiguration()), -2));
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m6764g();
        m6766h();
        m6768i();
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m6764g() {
        this.f6732N = getBehavior();
        BottomSheetBehavior bottomSheetBehavior = this.f6732N;
        if (bottomSheetBehavior instanceof COUIBottomSheetBehavior) {
            ((COUIBottomSheetBehavior) bottomSheetBehavior).m6637a(this.f6729K);
            ((COUIBottomSheetBehavior) this.f6732N).m6641a(this.f6730L);
            if (this.f6731M) {
                ((COUIBottomSheetBehavior) this.f6732N).m6643b(4);
            } else {
                ((COUIBottomSheetBehavior) this.f6732N).m6643b(3);
            }
            this.f6721C = (int) getContext().getResources().getDimension(R.dimen.coui_panel_pull_up_max_offset);
            ((COUIBottomSheetBehavior) this.f6732N).m6638a(new COUIBottomSheetBehavior.AbstractC1299a() { // from class: com.coui.appcompat.dialog.panel.IntrinsicsJvm.kt_4.1
                @Override // com.coui.appcompat.dialog.panel.COUIBottomSheetBehavior.AbstractC1299a
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo6649a(View view, int OplusGLSurfaceView_13) {
                    if (OplusGLSurfaceView_13 == 1) {
                        if (Build.VERSION.SDK_INT < 30 || COUIBottomSheetDialog.this.m6788s() || COUIBottomSheetDialog.this.f6753ai == null || COUIBottomSheetDialog.this.f6753ai.m6882b() || COUIBottomSheetDialog.this.f6770j.getRootWindowInsets() == null || !COUIBottomSheetDialog.this.f6770j.getRootWindowInsets().isVisible(WindowInsets.Type.ime())) {
                            return;
                        }
                        COUIBottomSheetDialog.this.f6755ak = true;
                        COUIBottomSheetDialog.this.f6753ai.m6878a(COUIBottomSheetDialog.this.f6770j, new COUIPanelImeAnimController.PlatformImplementations.kt_3() { // from class: com.coui.appcompat.dialog.panel.IntrinsicsJvm.kt_4.1.1
                            @Override // com.coui.appcompat.dialog.panel.COUIPanelImeAnimController.PlatformImplementations.kt_3
                            /* renamed from: PlatformImplementations.kt_3 */
                            public boolean mo6819a(int i2) {
                                return true;
                            }

                            @Override // com.coui.appcompat.dialog.panel.COUIPanelImeAnimController.PlatformImplementations.kt_3
                            /* renamed from: PlatformImplementations.kt_3 */
                            public void mo6818a(WindowInsetsAnimationController windowInsetsAnimationController, boolean z) {
                                COUIBottomSheetDialog.this.f6755ak = z;
                            }
                        });
                        return;
                    }
                    if (OplusGLSurfaceView_13 == 2) {
                        if ((COUIBottomSheetDialog.this.f6732N instanceof COUIBottomSheetBehavior) && ((COUIBottomSheetBehavior) COUIBottomSheetDialog.this.f6732N).m6642a() && !COUIBottomSheetDialog.this.f6755ak) {
                            COUIBottomSheetDialog.this.m6787r();
                            return;
                        }
                        return;
                    }
                    if (OplusGLSurfaceView_13 != 3) {
                        if (OplusGLSurfaceView_13 != 5) {
                            return;
                        }
                        if (Build.VERSION.SDK_INT >= 30 && COUIBottomSheetDialog.this.f6753ai != null) {
                            COUIBottomSheetDialog.this.f6753ai.m6885e();
                        }
                        COUIBottomSheetDialog.this.dismiss();
                        return;
                    }
                    if (Build.VERSION.SDK_INT >= 30 && !COUIBottomSheetDialog.this.m6788s() && COUIBottomSheetDialog.this.f6753ai != null && COUIBottomSheetDialog.this.f6753ai.m6880a() && COUIBottomSheetDialog.this.f6755ak) {
                        COUIBottomSheetDialog.this.f6755ak = false;
                        COUIBottomSheetDialog.this.f6757am = true;
                        COUIBottomSheetDialog.this.f6753ai.m6885e();
                    }
                    COUIBottomSheetDialog.this.f6758an = false;
                }

                @Override // com.coui.appcompat.dialog.panel.COUIBottomSheetBehavior.AbstractC1299a
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo6648a(View view, float COUIBaseListPopupWindow_12) {
                    if (Build.VERSION.SDK_INT < 30 || COUIBottomSheetDialog.this.m6788s() || COUIBottomSheetDialog.this.f6753ai == null || !COUIBottomSheetDialog.this.f6753ai.m6880a()) {
                        return;
                    }
                    int OplusGLSurfaceView_13 = ((COUIBottomSheetBehavior) COUIBottomSheetDialog.this.f6732N).f6610h;
                    if (OplusGLSurfaceView_13 == 1 || OplusGLSurfaceView_13 == 2 || OplusGLSurfaceView_13 == 3) {
                        COUIBottomSheetDialog.this.f6755ak = true;
                        COUIBottomSheetDialog.this.f6753ai.m6877a(1, (int) ((COUIBottomSheetDialog.this.f6728J.getHeight() + COUIViewMarginUtil.m6502a(COUIBottomSheetDialog.this.f6728J, 3)) * Math.max(0.0f, 1.0f - COUIBaseListPopupWindow_12)));
                    }
                }
            });
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m6766h() {
        Window window = getWindow();
        if (window != null) {
            window.setDimAmount(0.0f);
            window.setLayout(-1, -1);
            window.setGravity(80);
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m6768i() {
        this.f6765e = (IgnoreWindowInsetsFrameLayout) findViewById(R.id_renamed.container);
        this.f6766f = findViewById(R.id_renamed.panel_outside);
        View view = this.f6766f;
        if (view != null) {
            View.OnTouchListener onTouchListener = this.f6785y;
            if (onTouchListener != null) {
                view.setOnTouchListener(onTouchListener);
            }
            this.f6766f.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.dialog.panel.IntrinsicsJvm.kt_4.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (COUIBottomSheetDialog.this.f6786z && COUIBottomSheetDialog.this.isShowing() && COUIBottomSheetDialog.this.f6719A) {
                        COUIBottomSheetDialog.this.cancel();
                    }
                }
            });
        }
        this.f6767g = findViewById(R.id_renamed.coordinator);
        this.f6768h = (ViewGroup) findViewById(R.id_renamed.design_bottom_sheet);
        ViewGroup viewGroup = this.f6768h;
        if (viewGroup != null) {
            if (this.f6784x) {
                viewGroup.setBackground(null);
            } else {
                viewGroup.setBackground(this.f6781u);
            }
            this.f6768h.setOutlineProvider(new ViewOutlineProvider() { // from class: com.coui.appcompat.dialog.panel.IntrinsicsJvm.kt_4.12
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view2, Outline outline) {
                    outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), COUIBottomSheetDialog.this.f6760ap);
                }
            });
            this.f6768h.setClipToOutline(true);
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m6771j() {
        int iM6447d = COUIPanelMultiWindowUtils.m6447d(getContext()) + getContext().getResources().getDimensionPixelOffset(R.dimen.coui_panel_normal_padding_top);
        View view = this.f6767g;
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.topMargin = iM6447d;
            this.f6767g.setLayoutParams(layoutParams);
        }
        m6758f();
        m6738b(getContext());
        m6749d(getContext().getResources().getConfiguration());
        m6751e(getContext().getResources().getConfiguration());
        m6744c(getContext().getResources().getConfiguration());
        m6739b(getContext().getResources().getConfiguration());
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m6739b(Configuration configuration) {
        Window window = getWindow();
        if (window != null) {
            if (configuration != null) {
                window.setNavigationBarColor(getContext().createConfigurationContext(configuration).getResources().getColor(R.color.coui_panel_navigation_bar_color));
            } else {
                window.setNavigationBarColor(getContext().getResources().getColor(R.color.coui_panel_navigation_bar_color));
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m6738b(Context context) {
        this.f6760ap = context.getResources().getDimensionPixelOffset(R.dimen.coui_bottom_sheet_bg_bottom_corner_radius);
        this.f6768h.invalidateOutline();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6730a(boolean z, Configuration configuration) {
        ViewGroup viewGroup;
        if (!this.f6733O || this.f6770j == null || (viewGroup = this.f6768h) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.f6770j.getLayoutParams();
        if (z) {
            layoutParams.height = -2;
            this.f6770j.setLayoutAtMaxHeight(true);
            layoutParams2.height = COUIPanelMultiWindowUtils.m6438a(getContext(), configuration);
        } else {
            layoutParams.height = COUIPanelMultiWindowUtils.m6438a(getContext(), configuration) - getContext().getResources().getDimensionPixelOffset(R.dimen.coui_bottom_sheet_margin_bottom_if_need);
            layoutParams2.height = -1;
        }
        this.f6768h.setLayoutParams(layoutParams);
        this.f6770j.setLayoutParams(layoutParams2);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f6749ae = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.coui.appcompat.dialog.panel.IntrinsicsJvm.kt_4.13
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.what != 500) {
                    return false;
                }
                if (Build.VERSION.SDK_INT >= 30) {
                    COUIBottomSheetDialog.this.f6753ai.m6885e();
                }
                COUIBottomSheetDialog dialogC1309b = COUIBottomSheetDialog.this;
                dialogC1309b.m6725a(0, true, dialogC1309b.m6792u());
                return true;
            }
        });
        m6771j();
        Window window = getWindow();
        if (window != null) {
            m6815d().m6859a(window.getAttributes().type);
            int OplusGLSurfaceView_13 = window.getAttributes().softInputMode & 15;
            if (OplusGLSurfaceView_13 == 5 && Build.VERSION.SDK_INT >= 30 && !m6788s() && !this.f6759ao) {
                this.f6751ag = true;
                this.f6752ah = true;
                OplusGLSurfaceView_13 = 0;
            }
            window.setSoftInputMode(OplusGLSurfaceView_13 | 16);
            m6728a(window);
        }
        View view = this.f6766f;
        if (view != null) {
            view.getViewTreeObserver().addOnPreDrawListener(this.f6762ar);
        }
        getContext().registerComponentCallbacks(this.f6763as);
        if (this.f6732N instanceof COUIBottomSheetBehavior) {
            this.f6742X = this.f6720B ? m6795v() : null;
            ((COUIBottomSheetBehavior) this.f6732N).m6640a(this.f6742X);
        }
        if (this.f6752ah) {
            m6773k();
        }
        m6777m();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        if (m6815d() != null) {
            m6815d().m6863b();
            this.f6743Y = null;
        }
        Window window = getWindow();
        if (window != null) {
            window.getDecorView().setOnApplyWindowInsetsListener(null);
            this.f6741W = null;
        }
        m6726a(this.f6735Q);
        if (this.f6763as != null) {
            getContext().unregisterComponentCallbacks(this.f6763as);
        }
        BottomSheetBehavior bottomSheetBehavior = this.f6732N;
        if (bottomSheetBehavior instanceof COUIBottomSheetBehavior) {
            ((COUIBottomSheetBehavior) bottomSheetBehavior).m6640a((COUIPanelPullUpListener) null);
            this.f6742X = null;
        }
        if (this.f6753ai != null && Build.VERSION.SDK_INT >= 30) {
            this.f6753ai.m6885e();
        }
        m6753e(true);
        this.f6749ae.removeCallbacksAndMessages(null);
        this.f6749ae = null;
        super.onDetachedFromWindow();
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private void m6773k() {
        if (Build.VERSION.SDK_INT < 30 || this.f6753ai != null) {
            return;
        }
        this.f6753ai = new COUIPanelImeAnimController();
        Handler handler = this.f6749ae;
        handler.sendMessageDelayed(Message.obtain(handler, 500, null), 500L);
        this.f6753ai.m6878a(this.f6770j, new COUIPanelImeAnimController.PlatformImplementations.kt_3() { // from class: com.coui.appcompat.dialog.panel.IntrinsicsJvm.kt_4.14
            @Override // com.coui.appcompat.dialog.panel.COUIPanelImeAnimController.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public boolean mo6819a(int OplusGLSurfaceView_13) {
                COUIBottomSheetDialog.this.f6757am = true;
                COUIBottomSheetDialog.this.f6752ah = (OplusGLSurfaceView_13 & WindowInsets.Type.ime()) != 0;
                return COUIBottomSheetDialog.this.f6752ah;
            }

            @Override // com.coui.appcompat.dialog.panel.COUIPanelImeAnimController.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo6818a(WindowInsetsAnimationController windowInsetsAnimationController, boolean z) {
                if (z) {
                    COUIBottomSheetDialog.this.f6749ae.removeMessages(500);
                    COUIBottomSheetDialog dialogC1309b = COUIBottomSheetDialog.this;
                    dialogC1309b.m6725a(z ? dialogC1309b.f6754aj : 0, true, COUIBottomSheetDialog.this.m6792u());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_14 */
    public void m6774l() {
        if (this.f6753ai == null || Build.VERSION.SDK_INT < 30 || m6788s()) {
            return;
        }
        this.f6751ag = false;
        if (this.f6753ai.m6884d() && this.f6753ai.m6880a()) {
            this.f6753ai.m6879a(true);
        } else {
            this.f6734P.showSoftInput(this.f6770j.findFocus(), 2);
        }
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private void m6777m() {
        if (getWindow() == null || this.f6741W != null) {
            return;
        }
        View decorView = getWindow().getDecorView();
        this.f6741W = new View.OnApplyWindowInsetsListener() { // from class: com.coui.appcompat.dialog.panel.IntrinsicsJvm.kt_4.15
            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) throws Resources.NotFoundException {
                if (COUIBottomSheetDialog.this.f6734P == null) {
                    COUIBottomSheetDialog dialogC1309b = COUIBottomSheetDialog.this;
                    dialogC1309b.f6734P = (InputMethodManager) dialogC1309b.getContext().getSystemService("input_method");
                }
                if (COUIBottomSheetDialog.this.m6788s()) {
                    COUIPanelConstraintLayout c1487l = COUIBottomSheetDialog.this.f6770j;
                    if (COUIBottomSheetDialog.this.f6757am) {
                        COUIBottomSheetDialog.this.m6815d().m6860a(COUIBottomSheetDialog.this.getContext(), c1487l, windowInsets);
                    }
                    COUIBottomSheetDialog.this.getWindow().setNavigationBarColor(COUIBottomSheetDialog.this.getContext().getResources().getColor(R.color.coui_common_background_color));
                } else if (COUIBottomSheetDialog.this.f6757am) {
                    boolean z = COUIBottomSheetDialog.this.getContext().getResources().getBoolean(R.bool.f24212x38a0da7a);
                    COUIBottomSheetDialog.this.m6815d().m6860a(COUIBottomSheetDialog.this.getContext(), z ? COUIBottomSheetDialog.this.f6770j : COUIBottomSheetDialog.this.f6768h, windowInsets);
                    COUIBottomSheetDialog dialogC1309b2 = COUIBottomSheetDialog.this;
                    dialogC1309b2.f6754aj = z ? dialogC1309b2.m6815d().m6864c() : dialogC1309b2.m6815d().m6866e();
                }
                COUIBottomSheetDialog.this.f6744Z = windowInsets;
                view.onApplyWindowInsets(COUIBottomSheetDialog.this.f6744Z);
                return COUIBottomSheetDialog.this.f6744Z;
            }
        };
        decorView.setOnApplyWindowInsetsListener(this.f6741W);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m6753e(boolean z) {
        if (getWindow() == null || Build.VERSION.SDK_INT < 30) {
            return;
        }
        int OplusGLSurfaceView_13 = 0;
        if (z) {
            this.f6756al = false;
            getWindow().getDecorView().setWindowInsetsAnimationCallback(null);
        } else {
            if (this.f6756al) {
                return;
            }
            this.f6756al = true;
            getWindow().getDecorView().setWindowInsetsAnimationCallback(new WindowInsetsAnimation.Callback(OplusGLSurfaceView_13) { // from class: com.coui.appcompat.dialog.panel.IntrinsicsJvm.kt_4.16
                @Override // android.view.WindowInsetsAnimation.Callback
                public void onPrepare(WindowInsetsAnimation windowInsetsAnimation) throws Resources.NotFoundException {
                    if ((windowInsetsAnimation.getTypeMask() & WindowInsets.Type.ime()) != 0) {
                        boolean z2 = COUIBottomSheetDialog.this.getContext().getResources().getBoolean(R.bool.f24212x38a0da7a);
                        COUIBottomSheetDialog dialogC1309b = COUIBottomSheetDialog.this;
                        dialogC1309b.f6771k = z2 ? dialogC1309b.f6770j : dialogC1309b.f6768h;
                        COUIBottomSheetDialog dialogC1309b2 = COUIBottomSheetDialog.this;
                        dialogC1309b2.f6758an = !dialogC1309b2.m6788s() && (COUIBottomSheetDialog.this.f6753ai == null || !COUIBottomSheetDialog.this.f6753ai.m6883c());
                        COUIBottomSheetDialog.this.f6757am = !r3.f6758an;
                        COUIBottomSheetDialog dialogC1309b3 = COUIBottomSheetDialog.this;
                        dialogC1309b3.f6764d = COUIPanelMultiWindowUtils.m6438a(dialogC1309b3.getContext(), COUIBottomSheetDialog.this.getContext().getResources().getConfiguration());
                    }
                }

                @Override // android.view.WindowInsetsAnimation.Callback
                public WindowInsets onProgress(WindowInsets windowInsets, List<WindowInsetsAnimation> list) throws Resources.NotFoundException {
                    boolean z2 = false;
                    int i2 = COUIBottomSheetDialog.this.f6744Z != null ? COUIBottomSheetDialog.this.f6744Z.getInsets(WindowInsets.Type.ime()).bottom : 0;
                    if (COUIPanelMultiWindowUtils.m6448e(COUIBottomSheetDialog.this.getContext()) && i2 > (COUIBottomSheetDialog.this.f6764d * 5) / 6) {
                        z2 = true;
                    }
                    if (COUIBottomSheetDialog.this.m6815d() == null || !COUIBottomSheetDialog.this.f6758an || z2 || COUIBottomSheetDialog.this.f6746ab || COUIBottomSheetDialog.this.f6755ak) {
                        COUIBottomSheetDialog.this.f6745aa = null;
                    } else {
                        COUIBottomSheetDialog.this.f6745aa = windowInsets;
                        COUIBottomSheetDialog.this.m6815d().m6860a(COUIBottomSheetDialog.this.getContext(), COUIBottomSheetDialog.this.f6771k, COUIBottomSheetDialog.this.f6745aa);
                    }
                    return windowInsets;
                }

                @Override // android.view.WindowInsetsAnimation.Callback
                public void onEnd(WindowInsetsAnimation windowInsetsAnimation) throws Resources.NotFoundException {
                    if ((windowInsetsAnimation.getTypeMask() & WindowInsets.Type.ime()) != 0) {
                        if (!COUIBottomSheetDialog.this.f6758an) {
                            return;
                        }
                        int i2 = COUIBottomSheetDialog.this.f6745aa != null ? COUIBottomSheetDialog.this.f6745aa.getInsets(WindowInsets.Type.ime()).bottom : 0;
                        if ((COUIBottomSheetDialog.this.f6744Z != null ? COUIBottomSheetDialog.this.f6744Z.getInsets(WindowInsets.Type.ime()).bottom : 0) == 0 && COUIBottomSheetDialog.this.f6744Z != null && COUIBottomSheetDialog.this.m6815d() != null) {
                            if (i2 > 0) {
                                COUIBottomSheetDialog.this.m6815d().m6860a(COUIBottomSheetDialog.this.getContext(), COUIBottomSheetDialog.this.f6771k, COUIBottomSheetDialog.this.f6744Z);
                            } else {
                                COUIBottomSheetDialog.this.m6815d().m6862a(COUIBottomSheetDialog.this.f6770j);
                            }
                        }
                        COUIBottomSheetDialog.this.f6758an = false;
                        COUIBottomSheetDialog.this.f6757am = true;
                    }
                    super.onEnd(windowInsetsAnimation);
                }
            });
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public View m6801a() {
        return this.f6769i;
    }

    @Override // android.app.Dialog
    public void hide() {
        COUIPanelConstraintLayout c1487l;
        if (!this.f6784x || (c1487l = this.f6770j) == null || c1487l.findFocus() == null) {
            super.hide();
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        m6785q();
        m6811b(true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6807a(boolean z) {
        this.f6747ac = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6802a(int OplusGLSurfaceView_13) {
        this.f6748ad = OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m6811b(boolean z) {
        if (isShowing() && z && !this.f6746ab) {
            m6787r();
            if (this.f6732N.getState() == 5) {
                m6782p();
                return;
            } else {
                m6781o();
                return;
            }
        }
        m6779n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: OplusGLSurfaceView_11 */
    public void m6779n() {
        super.dismiss();
    }

    /* renamed from: o */
    private void m6781o() {
        m6725a(0, false, (Animator.AnimatorListener) new AnimatorListenerAdapter() { // from class: com.coui.appcompat.dialog.panel.IntrinsicsJvm.kt_4.17
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                COUIBottomSheetDialog.this.f6746ab = false;
                if (!COUIBottomSheetDialog.this.f6747ac) {
                    COUIBottomSheetDialog.this.m6779n();
                    return;
                }
                COUIBottomSheetDialog dialogC1309b = COUIBottomSheetDialog.this;
                ValueAnimator valueAnimatorM6735b = dialogC1309b.m6735b(dialogC1309b.f6748ad);
                if (valueAnimatorM6735b == null) {
                    COUIBottomSheetDialog.this.m6779n();
                } else {
                    valueAnimatorM6735b.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.dialog.panel.IntrinsicsJvm.kt_4.17.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator2) {
                            COUIBottomSheetDialog.this.m6779n();
                        }
                    });
                    valueAnimatorM6735b.start();
                }
            }
        });
    }

    /* renamed from: p */
    private void m6782p() {
        ValueAnimator valueAnimatorM6735b = this.f6747ac ? m6735b(this.f6748ad) : null;
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(200L);
        animatorSet.setInterpolator(f6718c);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.coui.appcompat.dialog.panel.IntrinsicsJvm.kt_4.18
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                COUIBottomSheetDialog.this.f6746ab = true;
                super.onAnimationStart(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                COUIBottomSheetDialog.this.f6746ab = false;
                super.onAnimationCancel(animator);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                COUIBottomSheetDialog.this.f6746ab = false;
                COUIBottomSheetDialog.this.m6779n();
            }
        });
        if (valueAnimatorM6735b == null) {
            animatorSet.playTogether(m6757f(false));
        } else {
            animatorSet.playTogether(m6757f(false), valueAnimatorM6735b);
        }
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m6725a(int OplusGLSurfaceView_13, boolean z, Animator.AnimatorListener animatorListener) {
        int measuredHeight;
        int i2;
        float fAbs;
        AnimatorSet animatorSet = this.f6735Q;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.f6738T = true;
            this.f6735Q.end();
        }
        this.f6764d = this.f6767g.getMeasuredHeight();
        if (this.f6733O) {
            measuredHeight = this.f6764d;
        } else {
            measuredHeight = this.f6728J.getMeasuredHeight();
        }
        ViewGroup viewGroup = this.f6728J;
        if (viewGroup == null || measuredHeight <= 0) {
            return;
        }
        int height = viewGroup.getHeight() + COUIViewMarginUtil.m6502a(this.f6728J, 3);
        if (z) {
            if (this.f6731M) {
                measuredHeight = this.f6729K;
            }
            i2 = measuredHeight + OplusGLSurfaceView_13;
        } else {
            i2 = (int) this.f6736R;
        }
        if (z) {
            height = 0;
        } else if (this.f6731M && this.f6732N.getState() == 4) {
            height = this.f6729K;
        }
        this.f6735Q = new AnimatorSet();
        if (z) {
            fAbs = Math.abs(((i2 - height) * 120.0f) / this.f6764d) + 300.0f;
            this.f6735Q.setDuration((long) fAbs);
            this.f6735Q.setInterpolator(f6716a);
        } else {
            height -= this.f6740V;
            fAbs = Math.abs(((i2 - height) * 50.0f) / this.f6764d) + 200.0f;
            this.f6735Q.setInterpolator(f6717b);
        }
        this.f6735Q.setDuration((long) fAbs);
        if (animatorListener != null) {
            this.f6735Q.addListener(animatorListener);
        }
        this.f6735Q.playTogether(m6719a(i2, height, OplusGLSurfaceView_13), m6757f(z));
        this.f6735Q.start();
        this.f6746ab = !z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private ValueAnimator m6719a(final int OplusGLSurfaceView_13, final int i2, int i3) {
        final float COUIBaseListPopupWindow_12;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(OplusGLSurfaceView_13, i2);
        if (!this.f6752ah || m6815d() == null) {
            COUIBaseListPopupWindow_12 = 0.0f;
        } else {
            COUIBaseListPopupWindow_12 = i3 != 0 ? i3 : Math.abs(m6815d().m6865d());
        }
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.dialog.panel.IntrinsicsJvm.kt_4.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (COUIBottomSheetDialog.this.f6728J != null) {
                    float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    COUIBottomSheetDialog.this.f6728J.setTranslationY(fFloatValue);
                    if (!COUIBottomSheetDialog.this.f6738T) {
                        COUIBottomSheetDialog.this.f6736R = fFloatValue;
                    }
                    COUIBottomSheetDialog.this.f6738T = false;
                    if (COUIBottomSheetDialog.this.f6752ah) {
                        float f2 = COUIBaseListPopupWindow_12;
                        if (f2 == 0.0f || OplusGLSurfaceView_13 <= i2 || fFloatValue > f2) {
                            return;
                        }
                        COUIBottomSheetDialog.this.m6774l();
                        COUIBottomSheetDialog.this.f6752ah = false;
                    }
                }
            }
        });
        return valueAnimatorOfFloat;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private ValueAnimator m6757f(boolean z) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f6737S, z ? 1.0f : 0.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.dialog.panel.IntrinsicsJvm.kt_4.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (COUIBottomSheetDialog.this.f6766f != null) {
                    COUIBottomSheetDialog.this.f6737S = fFloatValue;
                    COUIBottomSheetDialog.this.f6766f.setAlpha(COUIBottomSheetDialog.this.f6737S);
                }
            }
        });
        return valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public ValueAnimator m6735b(int OplusGLSurfaceView_13) {
        if (COUINavigationBarUtil.m6432b(getContext()) && getWindow() != null) {
            final Window window = getWindow();
            int navigationBarColor = window.getNavigationBarColor();
            if (Color.alpha(OplusGLSurfaceView_13) == 0) {
                OplusGLSurfaceView_13 = Color.argb(1, Color.red(OplusGLSurfaceView_13), Color.green(OplusGLSurfaceView_13), Color.blue(OplusGLSurfaceView_13));
            }
            if (navigationBarColor != OplusGLSurfaceView_13) {
                ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(navigationBarColor), Integer.valueOf(OplusGLSurfaceView_13));
                valueAnimatorOfObject.setDuration(200L);
                valueAnimatorOfObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.dialog.panel.IntrinsicsJvm.kt_4.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        window.setNavigationBarColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                });
                return valueAnimatorOfObject;
            }
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m6809b() {
        AnimatorSet animatorSet;
        if (this.f6728J == null || (animatorSet = this.f6735Q) == null || animatorSet.isRunning()) {
            return;
        }
        m6727a(this.f6728J);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6727a(View view) {
        if (view == null) {
            return;
        }
        if (this.f6726H == null || this.f6727I != view) {
            this.f6727I = view;
            this.f6726H = SpringSystem.m5492c().m5449b();
            this.f6726H.m5472a(SpringConfig.m5490b(3.8d, 20.0d));
            this.f6726H.m5473a(new SpringListener() { // from class: com.coui.appcompat.dialog.panel.IntrinsicsJvm.kt_4.5
                @Override // com.p078a.p079a.SpringListener
                /* renamed from: IntrinsicsJvm.kt_4 */
                public void mo5465b(Spring c1032f) {
                }

                @Override // com.p078a.p079a.SpringListener
                /* renamed from: IntrinsicsJvm.kt_3 */
                public void mo5466c(Spring c1032f) {
                }

                @Override // com.p078a.p079a.SpringListener
                /* renamed from: IntrinsicsJvm.kt_5 */
                public void mo5467d(Spring c1032f) {
                }

                @Override // com.p078a.p079a.SpringListener
                /* renamed from: PlatformImplementations.kt_3 */
                public void mo5464a(Spring c1032f) {
                    if (COUIBottomSheetDialog.this.f6726H == null || COUIBottomSheetDialog.this.f6727I == null) {
                        return;
                    }
                    int iM5478c = (int) c1032f.m5478c();
                    if (iM5478c >= 100) {
                        COUIBottomSheetDialog.this.f6726H.m5476b(0.0d);
                    }
                    COUIBottomSheetDialog.this.f6727I.setTranslationY(iM5478c);
                }
            });
        }
        this.f6726H.m5476b(100.0d);
    }

    /* renamed from: q */
    private void m6785q() {
        Spring c1032f = this.f6726H;
        if (c1032f == null || c1032f.m5482e() == 0.0d) {
            return;
        }
        this.f6726H.m5487j();
        this.f6726H = null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6805a(View.OnTouchListener onTouchListener) {
        this.f6785y = onTouchListener;
        View view = this.f6766f;
        if (view != null) {
            view.setOnTouchListener(this.f6785y);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m6814c(boolean z) {
        this.f6731M = z;
        if (z) {
            this.f6733O = false;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m6816d(boolean z) {
        if (this.f6720B != z) {
            this.f6720B = z;
            if (this.f6732N instanceof COUIBottomSheetBehavior) {
                this.f6742X = this.f6720B ? m6795v() : null;
                ((COUIBottomSheetBehavior) this.f6732N).m6640a(this.f6742X);
            }
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, android.app.Dialog
    public void setCancelable(boolean z) {
        super.setCancelable(z);
        this.f6786z = z;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.f6786z) {
            this.f6786z = true;
        }
        this.f6719A = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public void m6787r() {
        COUIPanelImeAnimController c1313f;
        InputMethodManager inputMethodManager = this.f6734P;
        if (inputMethodManager == null || !inputMethodManager.isActive()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 30 && getWindow() != null) {
            this.f6757am = false;
        }
        if (!this.f6755ak) {
            this.f6734P.hideSoftInputFromWindow(this.f6768h.getWindowToken(), 0);
        } else {
            if (Build.VERSION.SDK_INT < 30 || (c1313f = this.f6753ai) == null) {
                return;
            }
            c1313f.m6885e();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public COUIPanelConstraintLayout m6812c() {
        return this.f6770j;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6728a(Window window) {
        int OplusGLSurfaceView_13;
        if (window == null) {
            return;
        }
        View decorView = window.getDecorView();
        if (Build.VERSION.SDK_INT >= 21) {
            int systemUiVisibility = decorView.getSystemUiVisibility() | 1024;
            window.setStatusBarColor(0);
            window.addFlags(Integer.MIN_VALUE);
            if (COUIDarkModeUtil.m6401a(getContext())) {
                OplusGLSurfaceView_13 = systemUiVisibility & (-8193) & (-17);
            } else {
                OplusGLSurfaceView_13 = Build.VERSION.SDK_INT >= 23 ? systemUiVisibility | 256 : systemUiVisibility | 16;
            }
            decorView.setSystemUiVisibility(OplusGLSurfaceView_13);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public boolean m6788s() {
        WeakReference<Activity> weakReference = this.f6783w;
        return (weakReference == null || weakReference.get() == null || !COUIPanelMultiWindowUtils.m6444b(this.f6783w.get())) ? false : true;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public COUIPanelAdjustResizeHelper m6815d() {
        if (this.f6743Y == null) {
            this.f6743Y = new COUIPanelAdjustResizeHelper();
        }
        return this.f6743Y;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6726a(Animator animator) {
        if (animator == null || !animator.isRunning()) {
            return;
        }
        animator.end();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public void m6791t() {
        View view = this.f6766f;
        if (view != null) {
            view.getViewTreeObserver().removeOnPreDrawListener(this.f6762ar);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6803a(Configuration configuration) {
        this.f6739U = true;
        if (m6815d() != null) {
            m6815d().m6862a(this.f6770j);
            m6815d().m6858a();
        }
        m6758f();
        m6749d(configuration);
        m6751e(configuration);
        m6744c(configuration);
        m6738b(getContext().createConfigurationContext(configuration));
        m6739b(configuration);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m6744c(Configuration configuration) {
        this.f6764d = COUIPanelMultiWindowUtils.m6438a(getContext(), configuration);
        if (this.f6733O) {
            m6730a(((float) configuration.smallestScreenWidthDp) < 480.0f && !(configuration.orientation == 2), configuration);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m6749d(Configuration configuration) {
        if (this.f6728J == null) {
            return;
        }
        COUIViewMarginUtil.m6503a(this.f6728J, 3, COUIPanelMultiWindowUtils.m6445c(getContext(), configuration));
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m6751e(Configuration configuration) {
        COUIPanelConstraintLayout c1487l = this.f6770j;
        if (c1487l == null || this.f6728J == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c1487l.getLayoutParams();
        CoordinatorLayout.C0411e c0411e = (CoordinatorLayout.C0411e) this.f6728J.getLayoutParams();
        if (layoutParams == null || c0411e == null) {
            return;
        }
        int iM6756f = m6756f(configuration);
        c0411e.width = iM6756f;
        layoutParams.width = iM6756f;
        this.f6728J.setLayoutParams(c0411e);
        this.f6770j.setLayoutParams(layoutParams);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int m6756f(Configuration configuration) {
        int OplusGLSurfaceView_13 = configuration.smallestScreenWidthDp;
        boolean z = (configuration.screenLayout & 15) == 1;
        boolean z2 = configuration.orientation == 2;
        if (OplusGLSurfaceView_13 >= 480.0f || (!z && z2)) {
            return (int) getContext().getResources().getDimension(R.dimen.coui_panel_landscape_width);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public Animator.AnimatorListener m6792u() {
        return new AnimatorListenerAdapter() { // from class: com.coui.appcompat.dialog.panel.IntrinsicsJvm.kt_4.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (COUIBottomSheetDialog.this.f6732N == null || COUIBottomSheetDialog.this.f6732N.getState() != 5) {
                    return;
                }
                ((COUIBottomSheetBehavior) COUIBottomSheetDialog.this.f6732N).m6643b(3);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (COUIBottomSheetDialog.this.f6728J != null) {
                    COUIBottomSheetDialog.this.f6728J.setTranslationY(COUIBottomSheetDialog.this.f6736R);
                    if (COUIBottomSheetDialog.this.f6732N != null && COUIBottomSheetDialog.this.f6732N.getState() == 3 && COUIBottomSheetDialog.this.f6761aq) {
                        COUIBottomSheetDialog.this.f6728J.performHapticFeedback(14);
                    }
                }
                if (COUIBottomSheetDialog.this.f6751ag && Build.VERSION.SDK_INT >= 30) {
                    COUIBottomSheetDialog.this.f6753ai.m6885e();
                    COUIBottomSheetDialog.this.f6734P.showSoftInput(COUIBottomSheetDialog.this.f6770j.findFocus(), 2);
                }
                COUIBottomSheetDialog.this.m6753e(false);
            }
        };
    }

    /* renamed from: v */
    private COUIPanelPullUpListener m6795v() {
        return new COUIPanelPullUpListener() { // from class: com.coui.appcompat.dialog.panel.IntrinsicsJvm.kt_4.9
            @Override // com.coui.appcompat.dialog.panel.COUIPanelPullUpListener
            /* renamed from: PlatformImplementations.kt_3 */
            public int mo6820a(int OplusGLSurfaceView_13, int i2) {
                if (COUIBottomSheetDialog.this.f6725G != null && COUIBottomSheetDialog.this.f6725G.m5482e() != 0.0d) {
                    COUIBottomSheetDialog.this.f6725G.m5487j();
                    return COUIBottomSheetDialog.this.f6722D;
                }
                int iM2447a = MathUtils.m2447a((int) (COUIBottomSheetDialog.this.f6724F.getPaddingBottom() - (OplusGLSurfaceView_13 * 0.19999999f)), 0, Math.min(COUIBottomSheetDialog.this.f6721C, COUIBottomSheetDialog.this.f6728J.getTop()));
                if (COUIBottomSheetDialog.this.f6722D != iM2447a) {
                    COUIBottomSheetDialog.this.f6722D = iM2447a;
                    COUIBottomSheetDialog dialogC1309b = COUIBottomSheetDialog.this;
                    dialogC1309b.m6748d(dialogC1309b.f6722D);
                }
                return COUIBottomSheetDialog.this.f6722D;
            }

            @Override // com.coui.appcompat.dialog.panel.COUIPanelPullUpListener
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo6822a(int OplusGLSurfaceView_13) {
                COUIBottomSheetDialog.this.m6816d(false);
                int top = COUIBottomSheetDialog.this.f6728J.getTop() - (OplusGLSurfaceView_13 - COUIBottomSheetDialog.this.f6722D);
                COUIBottomSheetDialog dialogC1309b = COUIBottomSheetDialog.this;
                dialogC1309b.m6743c(dialogC1309b.f6722D - top);
            }

            @Override // com.coui.appcompat.dialog.panel.COUIPanelPullUpListener
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo6821a() {
                COUIBottomSheetDialog.this.m6748d(0);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m6743c(final int OplusGLSurfaceView_13) {
        this.f6725G = SpringSystem.m5492c().m5449b();
        this.f6725G.m5472a(SpringConfig.m5490b(6.0d, 42.0d));
        this.f6723E = 0;
        this.f6725G.m5473a(new SpringListener() { // from class: com.coui.appcompat.dialog.panel.IntrinsicsJvm.kt_4.10
            @Override // com.p078a.p079a.SpringListener
            /* renamed from: IntrinsicsJvm.kt_3 */
            public void mo5466c(Spring c1032f) {
            }

            @Override // com.p078a.p079a.SpringListener
            /* renamed from: IntrinsicsJvm.kt_5 */
            public void mo5467d(Spring c1032f) {
            }

            @Override // com.p078a.p079a.SpringListener
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo5464a(Spring c1032f) {
                if (COUIBottomSheetDialog.this.f6725G == null || COUIBottomSheetDialog.this.f6728J == null) {
                    return;
                }
                if (c1032f.m5485h() && c1032f.m5482e() == 0.0d) {
                    COUIBottomSheetDialog.this.f6725G.m5487j();
                    return;
                }
                int iM5478c = (int) c1032f.m5478c();
                COUIBottomSheetDialog.this.f6728J.offsetTopAndBottom(iM5478c - COUIBottomSheetDialog.this.f6723E);
                COUIBottomSheetDialog.this.f6723E = iM5478c;
                COUIBottomSheetDialog.this.m6748d(OplusGLSurfaceView_13 - iM5478c);
            }

            @Override // com.p078a.p079a.SpringListener
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo5465b(Spring c1032f) {
                if ((COUIBottomSheetDialog.this.f6732N instanceof COUIBottomSheetBehavior) && COUIBottomSheetDialog.this.f6724F != null) {
                    COUIBottomSheetDialog.this.f6722D = 0;
                    COUIBottomSheetDialog.this.m6748d(0);
                    ((COUIBottomSheetBehavior) COUIBottomSheetDialog.this.f6732N).setStateInternal(3);
                }
                COUIBottomSheetDialog.this.m6816d(true);
            }
        });
        this.f6725G.m5476b(OplusGLSurfaceView_13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m6748d(int OplusGLSurfaceView_13) {
        View view = this.f6724F;
        if (view != null) {
            view.setPadding(view.getPaddingLeft(), this.f6724F.getPaddingTop(), this.f6724F.getPaddingRight(), OplusGLSurfaceView_13);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6804a(Drawable drawable) {
        COUIPanelConstraintLayout c1487l = this.f6770j;
        if (c1487l == null || drawable == null || this.f6781u == drawable) {
            return;
        }
        this.f6781u = drawable;
        c1487l.setBackground(this.f6781u);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6808a(boolean z, String str, View.OnClickListener onClickListener, String str2, View.OnClickListener onClickListener2, String str3, View.OnClickListener onClickListener3) {
        this.f6772l = z;
        m6806a(str, onClickListener);
        m6810b(str2, onClickListener2);
        m6813c(str3, onClickListener3);
        m6797w();
    }

    /* renamed from: w */
    private void m6797w() {
        COUIPanelConstraintLayout c1487l = this.f6770j;
        if (c1487l != null) {
            c1487l.setDividerVisibility(this.f6772l);
            this.f6770j.m7954a(this.f6773m, this.f6774n);
            this.f6770j.m7957b(this.f6775o, this.f6776p);
            this.f6770j.m7958c(this.f6777q, this.f6778r);
            this.f6770j.m7955b();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6806a(String str, View.OnClickListener onClickListener) {
        this.f6773m = str;
        this.f6774n = onClickListener;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m6810b(String str, View.OnClickListener onClickListener) {
        this.f6775o = str;
        this.f6776p = onClickListener;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m6813c(String str, View.OnClickListener onClickListener) {
        this.f6777q = str;
        this.f6778r = onClickListener;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public Button m6817e() {
        if (getWindow() != null) {
            return (Button) getWindow().findViewById(android.R.id_renamed.button3);
        }
        return null;
    }
}
