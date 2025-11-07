package com.coui.appcompat.dialog.panel;

import android.R;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.p031c.MathUtils;
import androidx.core.p036h.ViewCompat;
import androidx.core.p036h.p037a.AccessibilityNodeInfoCompat;
import androidx.core.p036h.p037a.AccessibilityViewCommand;
import androidx.customview.p039a.ViewDragHelper;
import androidx.customview.view.AbsSavedState;
import androidx.dynamicanimation.p043a.DynamicAnimation;
import androidx.dynamicanimation.p043a.FloatPropertyCompat;
import androidx.dynamicanimation.p043a.COUIPanelDragToHiddenAnimation;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.material.C1694R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.sensetime.stmobile.STMobileHumanActionNative;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class COUIBottomSheetBehavior<V extends View> extends BottomSheetBehavior<V> {

    /* renamed from: E */
    private static final int f6583E = C1694R.style.Widget_Design_BottomSheet_Modal;

    /* renamed from: A */
    private ShapeAppearanceModel f6584A;

    /* renamed from: B */
    private boolean f6585B;

    /* renamed from: C */
    private COUIBottomSheetBehavior<V>.RunnableC1300b f6586C;

    /* renamed from: D */
    private ValueAnimator f6587D;

    /* renamed from: F */
    private boolean f6588F;

    /* renamed from: G */
    private boolean f6589G;

    /* renamed from: H */
    private boolean f6590H;

    /* renamed from: I */
    private int f6591I;

    /* renamed from: J */
    private boolean f6592J;

    /* renamed from: K */
    private final ArrayList<AbstractC1299a> f6593K;

    /* renamed from: L */
    private VelocityTracker f6594L;

    /* renamed from: M */
    private int f6595M;

    /* renamed from: N */
    private int f6596N;

    /* renamed from: O */
    private Map<View, Integer> f6597O;

    /* renamed from: P */
    private COUIPanelPullUpListener f6598P;

    /* renamed from: Q */
    private boolean f6599Q;

    /* renamed from: R */
    private boolean f6600R;

    /* renamed from: S */
    private int f6601S;

    /* renamed from: T */
    private final ViewDragHelper.PlatformImplementations.kt_3 f6602T;

    /* renamed from: PlatformImplementations.kt_3 */
    int f6603a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    int f6604b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    int f6605c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    float f6606d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    int f6607e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    float f6608f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    boolean f6609g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    int f6610h;

    /* renamed from: OplusGLSurfaceView_13 */
    ViewDragHelper f6611i;

    /* renamed from: OplusGLSurfaceView_15 */
    int f6612j;

    /* renamed from: OplusGLSurfaceView_5 */
    int f6613k;

    /* renamed from: OplusGLSurfaceView_14 */
    WeakReference<V> f6614l;

    /* renamed from: OplusGLSurfaceView_6 */
    WeakReference<View> f6615m;

    /* renamed from: OplusGLSurfaceView_11 */
    int f6616n;

    /* renamed from: o */
    boolean f6617o;

    /* renamed from: p */
    COUIPanelDragListener f6618p;

    /* renamed from: q */
    private int f6619q;

    /* renamed from: r */
    private boolean f6620r;

    /* renamed from: s */
    private boolean f6621s;

    /* renamed from: t */
    private float f6622t;

    /* renamed from: u */
    private int f6623u;

    /* renamed from: v */
    private boolean f6624v;

    /* renamed from: w */
    private int f6625w;

    /* renamed from: x */
    private boolean f6626x;

    /* renamed from: y */
    private MaterialShapeDrawable f6627y;

    /* renamed from: z */
    private boolean f6628z;

    /* renamed from: com.coui.appcompat.dialog.panel.COUIBottomSheetBehavior$PlatformImplementations.kt_3 */
    public static abstract class AbstractC1299a {
        /* renamed from: PlatformImplementations.kt_3 */
        public abstract void mo6648a(View view, float COUIBaseListPopupWindow_12);

        /* renamed from: PlatformImplementations.kt_3 */
        public abstract void mo6649a(View view, int OplusGLSurfaceView_13);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int[] iArr) {
    }

    public COUIBottomSheetBehavior() {
        this.f6619q = 0;
        this.f6620r = true;
        this.f6621s = false;
        this.f6586C = null;
        this.f6606d = 0.5f;
        this.f6608f = -1.0f;
        this.f6589G = true;
        this.f6610h = 4;
        this.f6593K = new ArrayList<>();
        this.f6601S = 0;
        this.f6602T = new ViewDragHelper.PlatformImplementations.kt_3() { // from class: com.coui.appcompat.dialog.panel.COUIBottomSheetBehavior.5
            @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
            public boolean tryCaptureView(View view, int OplusGLSurfaceView_13) {
                if (COUIBottomSheetBehavior.this.f6610h == 1 || COUIBottomSheetBehavior.this.f6617o) {
                    return false;
                }
                if (COUIBottomSheetBehavior.this.f6610h == 3 && COUIBottomSheetBehavior.this.f6616n == OplusGLSurfaceView_13) {
                    View view2 = COUIBottomSheetBehavior.this.f6615m != null ? COUIBottomSheetBehavior.this.f6615m.get() : null;
                    if (view2 != null && view2.canScrollVertically(-1)) {
                        return false;
                    }
                }
                return COUIBottomSheetBehavior.this.f6614l != null && COUIBottomSheetBehavior.this.f6614l.get() == view;
            }

            @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
            public void onViewPositionChanged(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
                COUIBottomSheetBehavior.this.dispatchOnSlide(i2);
            }

            @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
            public void onViewDragStateChanged(int OplusGLSurfaceView_13) {
                if (OplusGLSurfaceView_13 == 1 && COUIBottomSheetBehavior.this.f6589G) {
                    COUIBottomSheetBehavior.this.setStateInternal(1);
                }
            }

            /* renamed from: PlatformImplementations.kt_3 */
            private boolean m6644a(View view) {
                return view.getTop() > (COUIBottomSheetBehavior.this.f6613k + COUIBottomSheetBehavior.this.getExpandedOffset()) / 2;
            }

            @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
            public void onViewReleased(View view, float COUIBaseListPopupWindow_12, float f2) {
                int OplusGLSurfaceView_13;
                COUIBottomSheetBehavior.this.f6599Q = false;
                if (COUIBottomSheetBehavior.this.f6598P != null && (COUIBottomSheetBehavior.this.f6613k - view.getHeight()) - COUIBottomSheetBehavior.this.m6619b(view) <= COUIBottomSheetBehavior.this.getExpandedOffset() && view.getTop() < COUIBottomSheetBehavior.this.getExpandedOffset()) {
                    COUIBottomSheetBehavior.this.f6598P.mo6822a(COUIBottomSheetBehavior.this.getExpandedOffset());
                    return;
                }
                int i2 = 5;
                int i3 = 3;
                if (f2 < 0.0f) {
                    if (COUIBottomSheetBehavior.this.f6620r) {
                        OplusGLSurfaceView_13 = COUIBottomSheetBehavior.this.f6604b;
                        COUIBottomSheetBehavior.this.startSettlingAnimation(view, i3, OplusGLSurfaceView_13, true);
                    } else if (view.getTop() > COUIBottomSheetBehavior.this.f6605c) {
                        OplusGLSurfaceView_13 = COUIBottomSheetBehavior.this.f6605c;
                        i2 = 6;
                    } else {
                        OplusGLSurfaceView_13 = COUIBottomSheetBehavior.this.f6603a;
                        i2 = 3;
                    }
                } else {
                    if (COUIBottomSheetBehavior.this.f6609g && COUIBottomSheetBehavior.this.shouldHide(view, f2)) {
                        if (COUIBottomSheetBehavior.this.f6618p != null && COUIBottomSheetBehavior.this.f6618p.mo6867a()) {
                            OplusGLSurfaceView_13 = COUIBottomSheetBehavior.this.f6604b;
                            COUIBottomSheetBehavior.this.f6600R = false;
                        } else if ((Math.abs(COUIBaseListPopupWindow_12) >= Math.abs(f2) || f2 <= 500.0f) && !m6644a(view)) {
                            if (COUIBottomSheetBehavior.this.f6620r) {
                                OplusGLSurfaceView_13 = COUIBottomSheetBehavior.this.f6604b;
                            } else if (Math.abs(view.getTop() - COUIBottomSheetBehavior.this.f6603a) < Math.abs(view.getTop() - COUIBottomSheetBehavior.this.f6605c)) {
                                OplusGLSurfaceView_13 = COUIBottomSheetBehavior.this.f6603a;
                            } else {
                                OplusGLSurfaceView_13 = COUIBottomSheetBehavior.this.f6605c;
                                i3 = 6;
                            }
                        } else {
                            OplusGLSurfaceView_13 = COUIBottomSheetBehavior.this.f6613k;
                            COUIBottomSheetBehavior.this.f6600R = true;
                        }
                    } else if (f2 != 0.0f && Math.abs(COUIBaseListPopupWindow_12) <= Math.abs(f2)) {
                        if (COUIBottomSheetBehavior.this.f6620r) {
                            if (COUIBottomSheetBehavior.this.f6618p != null) {
                                if (COUIBottomSheetBehavior.this.f6618p.mo6867a()) {
                                    OplusGLSurfaceView_13 = COUIBottomSheetBehavior.this.f6604b;
                                } else {
                                    OplusGLSurfaceView_13 = COUIBottomSheetBehavior.this.f6613k;
                                }
                            } else {
                                OplusGLSurfaceView_13 = COUIBottomSheetBehavior.this.f6607e;
                            }
                        } else {
                            int top = view.getTop();
                            if (Math.abs(top - COUIBottomSheetBehavior.this.f6605c) < Math.abs(top - COUIBottomSheetBehavior.this.f6607e)) {
                                OplusGLSurfaceView_13 = COUIBottomSheetBehavior.this.f6605c;
                                i3 = 6;
                            } else {
                                OplusGLSurfaceView_13 = COUIBottomSheetBehavior.this.f6607e;
                            }
                        }
                        i3 = 4;
                    } else {
                        int top2 = view.getTop();
                        if (COUIBottomSheetBehavior.this.f6620r) {
                            if (Math.abs(top2 - COUIBottomSheetBehavior.this.f6604b) < Math.abs(top2 - COUIBottomSheetBehavior.this.f6607e)) {
                                OplusGLSurfaceView_13 = COUIBottomSheetBehavior.this.f6604b;
                                i2 = 3;
                            } else {
                                OplusGLSurfaceView_13 = COUIBottomSheetBehavior.this.f6607e;
                                i2 = 4;
                            }
                        } else {
                            if (top2 < COUIBottomSheetBehavior.this.f6605c) {
                                if (top2 < Math.abs(top2 - COUIBottomSheetBehavior.this.f6607e)) {
                                    OplusGLSurfaceView_13 = COUIBottomSheetBehavior.this.f6603a;
                                    i2 = 3;
                                } else {
                                    OplusGLSurfaceView_13 = COUIBottomSheetBehavior.this.f6605c;
                                }
                            } else if (Math.abs(top2 - COUIBottomSheetBehavior.this.f6605c) < Math.abs(top2 - COUIBottomSheetBehavior.this.f6607e)) {
                                OplusGLSurfaceView_13 = COUIBottomSheetBehavior.this.f6605c;
                            } else {
                                OplusGLSurfaceView_13 = COUIBottomSheetBehavior.this.f6607e;
                                i2 = 4;
                            }
                            i2 = 6;
                        }
                    }
                    COUIBottomSheetBehavior.this.startSettlingAnimation(view, i3, OplusGLSurfaceView_13, true);
                }
                i3 = i2;
                COUIBottomSheetBehavior.this.startSettlingAnimation(view, i3, OplusGLSurfaceView_13, true);
            }

            @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
            public int clampViewPositionVertical(View view, int OplusGLSurfaceView_13, int i2) {
                int iMo6820a = 0;
                if (COUIBottomSheetBehavior.this.f6610h == 1) {
                    if (view.getTop() <= COUIBottomSheetBehavior.this.getExpandedOffset()) {
                        if (COUIBottomSheetBehavior.this.f6598P != null && COUIBottomSheetBehavior.this.getExpandedOffset() > 0) {
                            COUIBottomSheetBehavior.this.f6599Q = true;
                            iMo6820a = COUIBottomSheetBehavior.this.f6598P.mo6820a(i2, COUIBottomSheetBehavior.this.getExpandedOffset());
                        }
                    } else if (COUIBottomSheetBehavior.this.m6633g() > 10000.0f) {
                        OplusGLSurfaceView_13 = ((int) ((i2 * 0.5f) + 0.5f)) + view.getTop();
                    }
                }
                return MathUtils.m2447a(OplusGLSurfaceView_13, COUIBottomSheetBehavior.this.getExpandedOffset() - iMo6820a, COUIBottomSheetBehavior.this.f6609g ? COUIBottomSheetBehavior.this.f6613k : COUIBottomSheetBehavior.this.f6607e);
            }

            @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
            public int clampViewPositionHorizontal(View view, int OplusGLSurfaceView_13, int i2) {
                return view.getLeft();
            }

            @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
            public int getViewVerticalDragRange(View view) {
                if (COUIBottomSheetBehavior.this.f6609g) {
                    return COUIBottomSheetBehavior.this.f6613k;
                }
                return COUIBottomSheetBehavior.this.f6607e;
            }
        };
    }

    public COUIBottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6619q = 0;
        this.f6620r = true;
        this.f6621s = false;
        this.f6586C = null;
        this.f6606d = 0.5f;
        this.f6608f = -1.0f;
        this.f6589G = true;
        this.f6610h = 4;
        this.f6593K = new ArrayList<>();
        this.f6601S = 0;
        this.f6602T = new ViewDragHelper.PlatformImplementations.kt_3() { // from class: com.coui.appcompat.dialog.panel.COUIBottomSheetBehavior.5
            @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
            public boolean tryCaptureView(View view, int OplusGLSurfaceView_13) {
                if (COUIBottomSheetBehavior.this.f6610h == 1 || COUIBottomSheetBehavior.this.f6617o) {
                    return false;
                }
                if (COUIBottomSheetBehavior.this.f6610h == 3 && COUIBottomSheetBehavior.this.f6616n == OplusGLSurfaceView_13) {
                    View view2 = COUIBottomSheetBehavior.this.f6615m != null ? COUIBottomSheetBehavior.this.f6615m.get() : null;
                    if (view2 != null && view2.canScrollVertically(-1)) {
                        return false;
                    }
                }
                return COUIBottomSheetBehavior.this.f6614l != null && COUIBottomSheetBehavior.this.f6614l.get() == view;
            }

            @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
            public void onViewPositionChanged(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
                COUIBottomSheetBehavior.this.dispatchOnSlide(i2);
            }

            @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
            public void onViewDragStateChanged(int OplusGLSurfaceView_13) {
                if (OplusGLSurfaceView_13 == 1 && COUIBottomSheetBehavior.this.f6589G) {
                    COUIBottomSheetBehavior.this.setStateInternal(1);
                }
            }

            /* renamed from: PlatformImplementations.kt_3 */
            private boolean m6644a(View view) {
                return view.getTop() > (COUIBottomSheetBehavior.this.f6613k + COUIBottomSheetBehavior.this.getExpandedOffset()) / 2;
            }

            @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
            public void onViewReleased(View view, float COUIBaseListPopupWindow_12, float f2) {
                int OplusGLSurfaceView_13;
                COUIBottomSheetBehavior.this.f6599Q = false;
                if (COUIBottomSheetBehavior.this.f6598P != null && (COUIBottomSheetBehavior.this.f6613k - view.getHeight()) - COUIBottomSheetBehavior.this.m6619b(view) <= COUIBottomSheetBehavior.this.getExpandedOffset() && view.getTop() < COUIBottomSheetBehavior.this.getExpandedOffset()) {
                    COUIBottomSheetBehavior.this.f6598P.mo6822a(COUIBottomSheetBehavior.this.getExpandedOffset());
                    return;
                }
                int i2 = 5;
                int i3 = 3;
                if (f2 < 0.0f) {
                    if (COUIBottomSheetBehavior.this.f6620r) {
                        OplusGLSurfaceView_13 = COUIBottomSheetBehavior.this.f6604b;
                        COUIBottomSheetBehavior.this.startSettlingAnimation(view, i3, OplusGLSurfaceView_13, true);
                    } else if (view.getTop() > COUIBottomSheetBehavior.this.f6605c) {
                        OplusGLSurfaceView_13 = COUIBottomSheetBehavior.this.f6605c;
                        i2 = 6;
                    } else {
                        OplusGLSurfaceView_13 = COUIBottomSheetBehavior.this.f6603a;
                        i2 = 3;
                    }
                } else {
                    if (COUIBottomSheetBehavior.this.f6609g && COUIBottomSheetBehavior.this.shouldHide(view, f2)) {
                        if (COUIBottomSheetBehavior.this.f6618p != null && COUIBottomSheetBehavior.this.f6618p.mo6867a()) {
                            OplusGLSurfaceView_13 = COUIBottomSheetBehavior.this.f6604b;
                            COUIBottomSheetBehavior.this.f6600R = false;
                        } else if ((Math.abs(COUIBaseListPopupWindow_12) >= Math.abs(f2) || f2 <= 500.0f) && !m6644a(view)) {
                            if (COUIBottomSheetBehavior.this.f6620r) {
                                OplusGLSurfaceView_13 = COUIBottomSheetBehavior.this.f6604b;
                            } else if (Math.abs(view.getTop() - COUIBottomSheetBehavior.this.f6603a) < Math.abs(view.getTop() - COUIBottomSheetBehavior.this.f6605c)) {
                                OplusGLSurfaceView_13 = COUIBottomSheetBehavior.this.f6603a;
                            } else {
                                OplusGLSurfaceView_13 = COUIBottomSheetBehavior.this.f6605c;
                                i3 = 6;
                            }
                        } else {
                            OplusGLSurfaceView_13 = COUIBottomSheetBehavior.this.f6613k;
                            COUIBottomSheetBehavior.this.f6600R = true;
                        }
                    } else if (f2 != 0.0f && Math.abs(COUIBaseListPopupWindow_12) <= Math.abs(f2)) {
                        if (COUIBottomSheetBehavior.this.f6620r) {
                            if (COUIBottomSheetBehavior.this.f6618p != null) {
                                if (COUIBottomSheetBehavior.this.f6618p.mo6867a()) {
                                    OplusGLSurfaceView_13 = COUIBottomSheetBehavior.this.f6604b;
                                } else {
                                    OplusGLSurfaceView_13 = COUIBottomSheetBehavior.this.f6613k;
                                }
                            } else {
                                OplusGLSurfaceView_13 = COUIBottomSheetBehavior.this.f6607e;
                            }
                        } else {
                            int top = view.getTop();
                            if (Math.abs(top - COUIBottomSheetBehavior.this.f6605c) < Math.abs(top - COUIBottomSheetBehavior.this.f6607e)) {
                                OplusGLSurfaceView_13 = COUIBottomSheetBehavior.this.f6605c;
                                i3 = 6;
                            } else {
                                OplusGLSurfaceView_13 = COUIBottomSheetBehavior.this.f6607e;
                            }
                        }
                        i3 = 4;
                    } else {
                        int top2 = view.getTop();
                        if (COUIBottomSheetBehavior.this.f6620r) {
                            if (Math.abs(top2 - COUIBottomSheetBehavior.this.f6604b) < Math.abs(top2 - COUIBottomSheetBehavior.this.f6607e)) {
                                OplusGLSurfaceView_13 = COUIBottomSheetBehavior.this.f6604b;
                                i2 = 3;
                            } else {
                                OplusGLSurfaceView_13 = COUIBottomSheetBehavior.this.f6607e;
                                i2 = 4;
                            }
                        } else {
                            if (top2 < COUIBottomSheetBehavior.this.f6605c) {
                                if (top2 < Math.abs(top2 - COUIBottomSheetBehavior.this.f6607e)) {
                                    OplusGLSurfaceView_13 = COUIBottomSheetBehavior.this.f6603a;
                                    i2 = 3;
                                } else {
                                    OplusGLSurfaceView_13 = COUIBottomSheetBehavior.this.f6605c;
                                }
                            } else if (Math.abs(top2 - COUIBottomSheetBehavior.this.f6605c) < Math.abs(top2 - COUIBottomSheetBehavior.this.f6607e)) {
                                OplusGLSurfaceView_13 = COUIBottomSheetBehavior.this.f6605c;
                            } else {
                                OplusGLSurfaceView_13 = COUIBottomSheetBehavior.this.f6607e;
                                i2 = 4;
                            }
                            i2 = 6;
                        }
                    }
                    COUIBottomSheetBehavior.this.startSettlingAnimation(view, i3, OplusGLSurfaceView_13, true);
                }
                i3 = i2;
                COUIBottomSheetBehavior.this.startSettlingAnimation(view, i3, OplusGLSurfaceView_13, true);
            }

            @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
            public int clampViewPositionVertical(View view, int OplusGLSurfaceView_13, int i2) {
                int iMo6820a = 0;
                if (COUIBottomSheetBehavior.this.f6610h == 1) {
                    if (view.getTop() <= COUIBottomSheetBehavior.this.getExpandedOffset()) {
                        if (COUIBottomSheetBehavior.this.f6598P != null && COUIBottomSheetBehavior.this.getExpandedOffset() > 0) {
                            COUIBottomSheetBehavior.this.f6599Q = true;
                            iMo6820a = COUIBottomSheetBehavior.this.f6598P.mo6820a(i2, COUIBottomSheetBehavior.this.getExpandedOffset());
                        }
                    } else if (COUIBottomSheetBehavior.this.m6633g() > 10000.0f) {
                        OplusGLSurfaceView_13 = ((int) ((i2 * 0.5f) + 0.5f)) + view.getTop();
                    }
                }
                return MathUtils.m2447a(OplusGLSurfaceView_13, COUIBottomSheetBehavior.this.getExpandedOffset() - iMo6820a, COUIBottomSheetBehavior.this.f6609g ? COUIBottomSheetBehavior.this.f6613k : COUIBottomSheetBehavior.this.f6607e);
            }

            @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
            public int clampViewPositionHorizontal(View view, int OplusGLSurfaceView_13, int i2) {
                return view.getLeft();
            }

            @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
            public int getViewVerticalDragRange(View view) {
                if (COUIBottomSheetBehavior.this.f6609g) {
                    return COUIBottomSheetBehavior.this.f6613k;
                }
                return COUIBottomSheetBehavior.this.f6607e;
            }
        };
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1694R.styleable.BottomSheetBehavior_Layout);
        this.f6626x = typedArrayObtainStyledAttributes.hasValue(C1694R.styleable.BottomSheetBehavior_Layout_shapeAppearance);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(C1694R.styleable.BottomSheetBehavior_Layout_backgroundTint);
        if (zHasValue) {
            m6611a(context, attributeSet, zHasValue, MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, C1694R.styleable.BottomSheetBehavior_Layout_backgroundTint));
        } else {
            m6610a(context, attributeSet, zHasValue);
        }
        m6632f();
        if (Build.VERSION.SDK_INT >= 21) {
            this.f6608f = typedArrayObtainStyledAttributes.getDimension(C1694R.styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        }
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(C1694R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (typedValuePeekValue != null && typedValuePeekValue.data == -1) {
            m6637a(typedValuePeekValue.data);
        } else {
            m6637a(typedArrayObtainStyledAttributes.getDimensionPixelSize(C1694R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        }
        setHideable(typedArrayObtainStyledAttributes.getBoolean(C1694R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        setGestureInsetBottomIgnored(typedArrayObtainStyledAttributes.getBoolean(C1694R.styleable.f9179xed791f57, false));
        setFitToContents(typedArrayObtainStyledAttributes.getBoolean(C1694R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        m6641a(typedArrayObtainStyledAttributes.getBoolean(C1694R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        setDraggable(typedArrayObtainStyledAttributes.getBoolean(C1694R.styleable.BottomSheetBehavior_Layout_behavior_draggable, true));
        setSaveFlags(typedArrayObtainStyledAttributes.getInt(C1694R.styleable.BottomSheetBehavior_Layout_behavior_saveFlags, -1));
        setHalfExpandedRatio(typedArrayObtainStyledAttributes.getFloat(C1694R.styleable.f9178x40da2d0e, 0.5f));
        TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(C1694R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset);
        if (typedValuePeekValue2 != null && typedValuePeekValue2.type == 16) {
            setExpandedOffset(typedValuePeekValue2.data);
        } else {
            setExpandedOffset(typedArrayObtainStyledAttributes.getDimensionPixelOffset(C1694R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset, 0));
        }
        typedArrayObtainStyledAttributes.recycle();
        this.f6622t = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        this.f6600R = false;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v), (COUIBottomSheetBehavior<?>) this);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v, savedState.getSuperState());
        m6616a(savedState);
        if (savedState.state == 1 || savedState.state == 2) {
            this.f6610h = 4;
        } else {
            this.f6610h = savedState.state;
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
    public void onAttachedToLayoutParams(CoordinatorLayout.C0411e c0411e) {
        super.onAttachedToLayoutParams(c0411e);
        this.f6614l = null;
        this.f6611i = null;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.f6614l = null;
        this.f6611i = null;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int OplusGLSurfaceView_13) {
        MaterialShapeDrawable materialShapeDrawable;
        if (ViewCompat.m2901t(coordinatorLayout) && !ViewCompat.m2901t(v)) {
            v.setFitsSystemWindows(true);
        }
        if (this.f6614l == null) {
            this.f6625w = coordinatorLayout.getResources().getDimensionPixelSize(C1694R.dimen.design_bottom_sheet_peek_height_min);
            m6615a(coordinatorLayout);
            this.f6614l = new WeakReference<>(v);
            if (this.f6626x && (materialShapeDrawable = this.f6627y) != null) {
                ViewCompat.m2850a(v, materialShapeDrawable);
            }
            MaterialShapeDrawable materialShapeDrawable2 = this.f6627y;
            if (materialShapeDrawable2 != null) {
                float fM2896o = this.f6608f;
                if (fM2896o == -1.0f) {
                    fM2896o = ViewCompat.m2896o(v);
                }
                materialShapeDrawable2.setElevation(fM2896o);
                this.f6585B = this.f6610h == 3;
                this.f6627y.setInterpolation(this.f6585B ? 0.0f : 1.0f);
            }
            m6635h();
            if (ViewCompat.m2883f(v) == 0) {
                ViewCompat.m2867b((View) v, 1);
            }
        }
        if (this.f6611i == null) {
            this.f6611i = ViewDragHelper.m3091a(coordinatorLayout, this.f6602T);
        }
        int top = v.getTop();
        coordinatorLayout.onLayoutChild(v, OplusGLSurfaceView_13);
        this.f6612j = coordinatorLayout.getWidth();
        this.f6613k = coordinatorLayout.getHeight();
        if (!this.f6599Q) {
            this.f6604b = Math.max(0, (this.f6613k - v.getHeight()) - m6619b(v));
        }
        this.f6599Q = false;
        m6627d();
        m6623c();
        int i2 = this.f6610h;
        if (i2 == 3) {
            ViewCompat.m2882e(v, getExpandedOffset());
        } else if (i2 == 6) {
            ViewCompat.m2882e(v, this.f6605c);
        } else if (this.f6609g && i2 == 5) {
            ViewCompat.m2882e(v, this.f6613k);
        } else {
            int i3 = this.f6610h;
            if (i3 == 4) {
                ViewCompat.m2882e(v, this.f6607e);
            } else if (i3 == 1 || i3 == 2) {
                ViewCompat.m2882e(v, top - v.getTop());
            }
        }
        this.f6615m = new WeakReference<>(findScrollingChild(v));
        return true;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        ViewDragHelper c0535c;
        if (!v.isShown() || !this.f6589G) {
            this.f6590H = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            m6629e();
        }
        if (this.f6594L == null) {
            this.f6594L = VelocityTracker.obtain();
        }
        this.f6594L.addMovement(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                COUIPanelPullUpListener interfaceC1314g = this.f6598P;
                if (interfaceC1314g != null) {
                    interfaceC1314g.mo6821a();
                }
            } else if (actionMasked == 3) {
            }
            this.f6617o = false;
            this.f6616n = -1;
            if (this.f6590H) {
                this.f6590H = false;
                return false;
            }
        } else {
            this.f6595M = (int) motionEvent.getX();
            this.f6596N = (int) motionEvent.getY();
            if (this.f6610h != 2) {
                WeakReference<View> weakReference = this.f6615m;
                View view = weakReference != null ? weakReference.get() : null;
                if (view != null && coordinatorLayout.isPointInChildBounds(view, this.f6595M, this.f6596N)) {
                    this.f6616n = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.f6617o = true;
                }
            }
            this.f6590H = this.f6616n == -1 && !coordinatorLayout.isPointInChildBounds(v, this.f6595M, this.f6596N);
        }
        if (!this.f6590H && (c0535c = this.f6611i) != null && c0535c.m3111a(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.f6615m;
        View view2 = weakReference2 != null ? weakReference2.get() : null;
        return view2 != null ? (actionMasked != 2 || view2 == null || this.f6590H || this.f6610h == 1 || coordinatorLayout.isPointInChildBounds(view2, this.f6595M, this.f6596N) || this.f6611i == null || Math.abs(((float) this.f6596N) - motionEvent.getY()) <= ((float) this.f6611i.m3123d())) ? false : true : (actionMasked != 2 || this.f6590H || this.f6610h == 1 || this.f6611i == null || Math.abs(((float) this.f6596N) - motionEvent.getY()) <= ((float) this.f6611i.m3123d())) ? false : true;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.f6610h == 1 && actionMasked == 0) {
            return true;
        }
        ViewDragHelper c0535c = this.f6611i;
        if (c0535c != null) {
            c0535c.m3115b(motionEvent);
        }
        if (actionMasked == 0) {
            m6629e();
        }
        if (this.f6594L == null) {
            this.f6594L = VelocityTracker.obtain();
        }
        this.f6594L.addMovement(motionEvent);
        if (actionMasked == 2 && !this.f6590H && Math.abs(this.f6596N - motionEvent.getY()) > this.f6611i.m3123d()) {
            this.f6611i.m3109a(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.f6590H;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int OplusGLSurfaceView_13, int i2) {
        this.f6591I = 0;
        this.f6592J = false;
        return (OplusGLSurfaceView_13 & 2) != 0;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int OplusGLSurfaceView_13, int i2, int[] iArr, int i3) {
        if (i3 == 1) {
            return;
        }
        WeakReference<View> weakReference = this.f6615m;
        if (view != (weakReference != null ? weakReference.get() : null)) {
            return;
        }
        int top = v.getTop();
        int i4 = top - i2;
        if (i2 > 0) {
            if (i4 < getExpandedOffset()) {
                iArr[1] = top - getExpandedOffset();
                ViewCompat.m2882e(v, -iArr[1]);
                setStateInternal(3);
            } else {
                if (!this.f6589G) {
                    return;
                }
                iArr[1] = i2;
                ViewCompat.m2882e(v, -i2);
                setStateInternal(1);
            }
        } else if (i2 < 0 && !view.canScrollVertically(-1)) {
            int i5 = this.f6607e;
            if (i4 <= i5 || this.f6609g) {
                if (!this.f6589G) {
                    return;
                }
                iArr[1] = i2;
                if (i2 < -100) {
                    i2 = (int) (i2 * 0.5f);
                }
                ViewCompat.m2882e(v, -i2);
                setStateInternal(1);
            } else {
                iArr[1] = top - i5;
                ViewCompat.m2882e(v, -iArr[1]);
                setStateInternal(4);
            }
        }
        dispatchOnSlide(v.getTop());
        this.f6591I = i2;
        this.f6592J = true;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int OplusGLSurfaceView_13) {
        int i2;
        int i3 = 3;
        if (v.getTop() == getExpandedOffset()) {
            setStateInternal(3);
            return;
        }
        WeakReference<View> weakReference = this.f6615m;
        if (weakReference != null && view == weakReference.get() && this.f6592J) {
            if (this.f6591I > 0) {
                if (this.f6620r) {
                    i2 = this.f6604b;
                } else {
                    int top = v.getTop();
                    int i4 = this.f6605c;
                    if (top > i4) {
                        i2 = i4;
                        i3 = 6;
                    } else {
                        i2 = this.f6603a;
                    }
                }
            } else if (this.f6609g && shouldHide(v, m6633g())) {
                COUIPanelDragListener interfaceC1312e = this.f6618p;
                if (interfaceC1312e != null && interfaceC1312e.mo6867a()) {
                    i2 = this.f6604b;
                    this.f6600R = false;
                } else {
                    i2 = this.f6613k;
                    this.f6600R = true;
                    i3 = 5;
                }
            } else if (this.f6591I == 0) {
                int top2 = v.getTop();
                if (this.f6620r) {
                    if (Math.abs(top2 - this.f6604b) < Math.abs(top2 - this.f6607e)) {
                        i2 = this.f6604b;
                    } else {
                        i2 = this.f6607e;
                        i3 = 4;
                    }
                } else {
                    int i5 = this.f6605c;
                    if (top2 < i5) {
                        if (top2 < Math.abs(top2 - this.f6607e)) {
                            i2 = this.f6603a;
                        } else {
                            i2 = this.f6605c;
                        }
                    } else if (Math.abs(top2 - i5) < Math.abs(top2 - this.f6607e)) {
                        i2 = this.f6605c;
                    } else {
                        i2 = this.f6607e;
                        i3 = 4;
                    }
                    i3 = 6;
                }
            } else {
                if (this.f6620r) {
                    COUIPanelDragListener interfaceC1312e2 = this.f6618p;
                    if (interfaceC1312e2 != null) {
                        if (interfaceC1312e2.mo6867a()) {
                            i2 = this.f6604b;
                        } else {
                            i2 = this.f6613k;
                            i3 = 5;
                        }
                    } else {
                        i2 = this.f6607e;
                    }
                } else {
                    int top3 = v.getTop();
                    if (Math.abs(top3 - this.f6605c) < Math.abs(top3 - this.f6607e)) {
                        i2 = this.f6605c;
                        i3 = 6;
                    } else {
                        i2 = this.f6607e;
                    }
                }
                i3 = 4;
            }
            startSettlingAnimation(v, i3, i2, false);
            this.f6592J = false;
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float COUIBaseListPopupWindow_12, float f2) {
        WeakReference<View> weakReference = this.f6615m;
        if (weakReference == null || view != weakReference.get()) {
            return false;
        }
        return this.f6610h != 3 || super.onNestedPreFling(coordinatorLayout, v, view, COUIBaseListPopupWindow_12, f2);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public boolean isFitToContents() {
        return this.f6620r;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setFitToContents(boolean z) {
        if (this.f6620r == z) {
            return;
        }
        this.f6620r = z;
        if (this.f6614l != null) {
            m6623c();
        }
        setStateInternal((this.f6620r && this.f6610h == 6) ? 3 : this.f6610h);
        m6635h();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6637a(int OplusGLSurfaceView_13) {
        m6609a(OplusGLSurfaceView_13, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0015  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m6609a(int r4, boolean r5) {
        /*
            r3 = this;
            r0 = 1
            r1 = 0
            r2 = -1
            if (r4 != r2) goto Lc
            boolean r4 = r3.f6624v
            if (r4 != 0) goto L15
            r3.f6624v = r0
            goto L1f
        Lc:
            boolean r2 = r3.f6624v
            if (r2 != 0) goto L17
            int r2 = r3.f6623u
            if (r2 == r4) goto L15
            goto L17
        L15:
            r0 = r1
            goto L1f
        L17:
            r3.f6624v = r1
            int r4 = java.lang.Math.max(r1, r4)
            r3.f6623u = r4
        L1f:
            if (r0 == 0) goto L42
            java.lang.ref.WeakReference<V extends android.view.View> r4 = r3.f6614l
            if (r4 == 0) goto L42
            r3.m6623c()
            int r4 = r3.f6610h
            r0 = 4
            if (r4 != r0) goto L42
            java.lang.ref.WeakReference<V extends android.view.View> r4 = r3.f6614l
            java.lang.Object r4 = r4.get()
            android.view.View r4 = (android.view.View) r4
            if (r4 == 0) goto L42
            if (r5 == 0) goto L3f
            int r4 = r3.f6610h
            r3.m6624c(r4)
            goto L42
        L3f:
            r4.requestLayout()
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.dialog.panel.COUIBottomSheetBehavior.m6609a(int, boolean):void");
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public int getPeekHeight() {
        if (this.f6624v) {
            return -1;
        }
        return this.f6623u;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setHalfExpandedRatio(float COUIBaseListPopupWindow_12) {
        if (COUIBaseListPopupWindow_12 <= 0.0f || COUIBaseListPopupWindow_12 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be PlatformImplementations.kt_3 float value between 0 and 1");
        }
        this.f6606d = COUIBaseListPopupWindow_12;
        if (this.f6614l != null) {
            m6627d();
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public float getHalfExpandedRatio() {
        return this.f6606d;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setExpandedOffset(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0) {
            throw new IllegalArgumentException("offset must be greater than or equal to 0");
        }
        this.f6603a = OplusGLSurfaceView_13;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public int getExpandedOffset() {
        return this.f6620r ? this.f6604b : this.f6603a;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    @SuppressLint({"WrongConstant"})
    public void setHideable(boolean z) {
        if (this.f6609g != z) {
            this.f6609g = z;
            if (!z && this.f6610h == 5) {
                m6643b(4);
            }
            m6635h();
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public boolean isHideable() {
        return this.f6609g;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6641a(boolean z) {
        this.f6588F = z;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public boolean getSkipCollapsed() {
        return this.f6588F;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setDraggable(boolean z) {
        this.f6589G = z;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public boolean isDraggable() {
        return this.f6589G;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setSaveFlags(int OplusGLSurfaceView_13) {
        this.f6619q = OplusGLSurfaceView_13;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public int getSaveFlags() {
        return this.f6619q;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6638a(AbstractC1299a abstractC1299a) {
        if (this.f6593K.contains(abstractC1299a)) {
            return;
        }
        this.f6593K.add(abstractC1299a);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m6643b(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == this.f6610h) {
            return;
        }
        if (this.f6614l == null) {
            if (OplusGLSurfaceView_13 == 4 || OplusGLSurfaceView_13 == 3 || OplusGLSurfaceView_13 == 6 || (this.f6609g && OplusGLSurfaceView_13 == 5)) {
                this.f6610h = OplusGLSurfaceView_13;
                return;
            }
            return;
        }
        m6624c(OplusGLSurfaceView_13);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setGestureInsetBottomIgnored(boolean z) {
        this.f6628z = z;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public boolean isGestureInsetBottomIgnored() {
        return this.f6628z;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m6624c(final int OplusGLSurfaceView_13) {
        final V v = this.f6614l.get();
        if (v == null) {
            return;
        }
        ViewParent parent = v.getParent();
        if (parent != null && parent.isLayoutRequested() && ViewCompat.m2826D(v)) {
            v.post(new Runnable() { // from class: com.coui.appcompat.dialog.panel.COUIBottomSheetBehavior.1
                @Override // java.lang.Runnable
                public void run() {
                    COUIBottomSheetBehavior.this.settleToState(v, OplusGLSurfaceView_13);
                }
            });
        } else {
            settleToState(v, OplusGLSurfaceView_13);
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    @SuppressLint({"WrongConstant"})
    public int getState() {
        return this.f6610h;
    }

    void setStateInternal(int OplusGLSurfaceView_13) {
        V v;
        if (this.f6610h == OplusGLSurfaceView_13) {
            return;
        }
        this.f6610h = OplusGLSurfaceView_13;
        WeakReference<V> weakReference = this.f6614l;
        if (weakReference == null || (v = weakReference.get()) == null) {
            return;
        }
        if (OplusGLSurfaceView_13 == 3) {
            m6621b(true);
        } else if (OplusGLSurfaceView_13 == 6 || OplusGLSurfaceView_13 == 5 || OplusGLSurfaceView_13 == 4) {
            m6621b(false);
        }
        m6628d(OplusGLSurfaceView_13);
        for (int i2 = 0; i2 < this.f6593K.size(); i2++) {
            this.f6593K.get(i2).mo6649a((View) v, OplusGLSurfaceView_13);
        }
        m6635h();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m6628d(int OplusGLSurfaceView_13) {
        ValueAnimator valueAnimator;
        if (OplusGLSurfaceView_13 == 2) {
            return;
        }
        boolean z = OplusGLSurfaceView_13 == 3;
        if (this.f6585B != z) {
            this.f6585B = z;
            if (this.f6627y == null || (valueAnimator = this.f6587D) == null) {
                return;
            }
            if (valueAnimator.isRunning()) {
                this.f6587D.reverse();
                return;
            }
            float COUIBaseListPopupWindow_12 = z ? 0.0f : 1.0f;
            this.f6587D.setFloatValues(1.0f - COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12);
            this.f6587D.start();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int m6618b() {
        if (this.f6624v) {
            return Math.max(this.f6625w, this.f6613k - ((this.f6612j * 9) / 16));
        }
        return this.f6623u;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m6623c() {
        int iM6618b = m6618b();
        if (this.f6620r) {
            this.f6607e = Math.max(this.f6613k - iM6618b, this.f6604b);
        } else {
            this.f6607e = this.f6613k - iM6618b;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m6627d() {
        this.f6605c = (int) (this.f6613k * (1.0f - this.f6606d));
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m6629e() {
        this.f6616n = -1;
        VelocityTracker velocityTracker = this.f6594L;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f6594L = null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6616a(SavedState savedState) {
        int OplusGLSurfaceView_13 = this.f6619q;
        if (OplusGLSurfaceView_13 == 0) {
            return;
        }
        if (OplusGLSurfaceView_13 == -1 || (OplusGLSurfaceView_13 & 1) == 1) {
            this.f6623u = savedState.peekHeight;
        }
        int i2 = this.f6619q;
        if (i2 == -1 || (i2 & 2) == 2) {
            this.f6620r = savedState.fitToContents;
        }
        int i3 = this.f6619q;
        if (i3 == -1 || (i3 & 4) == 4) {
            this.f6609g = savedState.hideable;
        }
        int i4 = this.f6619q;
        if (i4 == -1 || (i4 & 8) == 8) {
            this.f6588F = savedState.skipCollapsed;
        }
    }

    boolean shouldHide(View view, float COUIBaseListPopupWindow_12) {
        if (this.f6588F) {
            return true;
        }
        if (view.getTop() < this.f6607e) {
            return false;
        }
        return Math.abs((((float) view.getTop()) + (COUIBaseListPopupWindow_12 * 0.1f)) - ((float) this.f6607e)) / ((float) m6618b()) > 0.5f;
    }

    View findScrollingChild(View view) {
        if (ViewCompat.m2906y(view) && view.getVisibility() == 0) {
            return view;
        }
        if (!(view instanceof ViewGroup) || view.getVisibility() != 0) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            View viewFindScrollingChild = findScrollingChild(viewGroup.getChildAt(OplusGLSurfaceView_13));
            if (viewFindScrollingChild != null) {
                return viewFindScrollingChild;
            }
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6610a(Context context, AttributeSet attributeSet, boolean z) {
        m6611a(context, attributeSet, z, null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6611a(Context context, AttributeSet attributeSet, boolean z, ColorStateList colorStateList) {
        if (this.f6626x) {
            this.f6584A = ShapeAppearanceModel.builder(context, attributeSet, C1694R.attr.bottomSheetStyle, f6583E).build();
            this.f6627y = new MaterialShapeDrawable(this.f6584A);
            this.f6627y.initializeElevationOverlay(context);
            if (z && colorStateList != null) {
                this.f6627y.setFillColor(colorStateList);
                return;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
            this.f6627y.setTint(typedValue.data);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m6632f() {
        this.f6587D = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f6587D.setDuration(500L);
        this.f6587D.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.dialog.panel.COUIBottomSheetBehavior.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (COUIBottomSheetBehavior.this.f6627y != null) {
                    COUIBottomSheetBehavior.this.f6627y.setInterpolation(fFloatValue);
                }
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6615a(CoordinatorLayout coordinatorLayout) {
        WindowInsets rootWindowInsets;
        if (Build.VERSION.SDK_INT < 29 || isGestureInsetBottomIgnored() || (rootWindowInsets = coordinatorLayout.getRootWindowInsets()) == null) {
            return;
        }
        this.f6623u += rootWindowInsets.getSystemGestureInsets().bottom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_11 */
    public float m6633g() {
        VelocityTracker velocityTracker = this.f6594L;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.f6622t);
        return this.f6594L.getYVelocity(this.f6616n);
    }

    void settleToState(View view, int OplusGLSurfaceView_13) {
        int expandedOffset;
        int i2;
        if (OplusGLSurfaceView_13 == 4) {
            expandedOffset = this.f6607e;
        } else if (OplusGLSurfaceView_13 == 6) {
            int i3 = this.f6605c;
            if (!this.f6620r || i3 > (i2 = this.f6604b)) {
                expandedOffset = i3;
            } else {
                OplusGLSurfaceView_13 = 3;
                expandedOffset = i2;
            }
        } else if (OplusGLSurfaceView_13 == 3) {
            expandedOffset = getExpandedOffset();
        } else if (this.f6609g && OplusGLSurfaceView_13 == 5) {
            expandedOffset = this.f6613k;
        } else {
            throw new IllegalArgumentException("Illegal state argument: " + OplusGLSurfaceView_13);
        }
        startSettlingAnimation(view, OplusGLSurfaceView_13, expandedOffset, false);
    }

    void startSettlingAnimation(View view, int OplusGLSurfaceView_13, int i2, boolean z) {
        boolean zM3112a;
        if (z && getState() == 1) {
            zM3112a = this.f6611i.m3110a(view.getLeft(), i2);
        } else {
            zM3112a = this.f6611i.m3112a(view, view.getLeft(), i2);
        }
        if (zM3112a) {
            setStateInternal(2);
            m6628d(OplusGLSurfaceView_13);
            float fM6633g = m6633g();
            if (OplusGLSurfaceView_13 == 5 && fM6633g > 10000.0f) {
                m6612a(view);
                return;
            } else {
                m6613a(view, OplusGLSurfaceView_13);
                return;
            }
        }
        setStateInternal(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6612a(final View view) {
        new COUIPanelDragToHiddenAnimation(view, new FloatPropertyCompat("offsetTopAndBottom") { // from class: com.coui.appcompat.dialog.panel.COUIBottomSheetBehavior.3
            @Override // androidx.dynamicanimation.p043a.FloatPropertyCompat
            /* renamed from: PlatformImplementations.kt_3 */
            public float mo3223a(Object obj) {
                COUIBottomSheetBehavior.this.f6601S = 0;
                return COUIBottomSheetBehavior.this.f6601S;
            }

            @Override // androidx.dynamicanimation.p043a.FloatPropertyCompat
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo3224a(Object obj, float COUIBaseListPopupWindow_12) {
                int OplusGLSurfaceView_13 = (int) COUIBaseListPopupWindow_12;
                ((View) obj).offsetTopAndBottom(OplusGLSurfaceView_13 - COUIBottomSheetBehavior.this.f6601S);
                COUIBottomSheetBehavior.this.dispatchOnSlide(view.getTop());
                COUIBottomSheetBehavior.this.f6601S = OplusGLSurfaceView_13;
            }
        }).mo3199g(m6633g()).m3196d(5000.0f).mo3197e(0.0f).mo3198f(this.f6613k - view.getTop()).m3216a(new DynamicAnimation.IntrinsicsJvm.kt_4() { // from class: com.coui.appcompat.dialog.panel.COUIBottomSheetBehavior.4
            @Override // androidx.dynamicanimation.p043a.DynamicAnimation.IntrinsicsJvm.kt_4
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo3225a(DynamicAnimation abstractC0549c, boolean z, float COUIBaseListPopupWindow_12, float f2) {
                COUIBottomSheetBehavior.this.setStateInternal(5);
            }
        }).mo3191a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6613a(View view, int OplusGLSurfaceView_13) {
        if (this.f6586C == null) {
            this.f6586C = new RunnableC1300b(view, OplusGLSurfaceView_13);
        }
        if (!((RunnableC1300b) this.f6586C).f6642d) {
            COUIBottomSheetBehavior<V>.RunnableC1300b runnableC1300b = this.f6586C;
            runnableC1300b.f6639a = OplusGLSurfaceView_13;
            ViewCompat.m2857a(view, runnableC1300b);
            ((RunnableC1300b) this.f6586C).f6642d = true;
            return;
        }
        this.f6586C.f6639a = OplusGLSurfaceView_13;
    }

    void dispatchOnSlide(int OplusGLSurfaceView_13) {
        float COUIBaseListPopupWindow_12;
        float expandedOffset;
        V v = this.f6614l.get();
        if (v == null || this.f6593K.isEmpty()) {
            return;
        }
        int i2 = this.f6607e;
        if (OplusGLSurfaceView_13 > i2 || i2 == getExpandedOffset()) {
            int i3 = this.f6607e;
            COUIBaseListPopupWindow_12 = i3 - OplusGLSurfaceView_13;
            expandedOffset = this.f6613k - i3;
        } else {
            int i4 = this.f6607e;
            COUIBaseListPopupWindow_12 = i4 - OplusGLSurfaceView_13;
            expandedOffset = i4 - getExpandedOffset();
        }
        float f2 = COUIBaseListPopupWindow_12 / expandedOffset;
        for (int i5 = 0; i5 < this.f6593K.size(); i5++) {
            this.f6593K.get(i5).mo6648a(v, f2);
        }
    }

    int getPeekHeightMin() {
        return this.f6625w;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void disableShapeAnimations() {
        this.f6587D = null;
    }

    /* renamed from: com.coui.appcompat.dialog.panel.COUIBottomSheetBehavior$IntrinsicsJvm.kt_4 */
    private class RunnableC1300b implements Runnable {

        /* renamed from: PlatformImplementations.kt_3 */
        int f6639a;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final View f6641c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private boolean f6642d;

        RunnableC1300b(View view, int OplusGLSurfaceView_13) {
            this.f6641c = view;
            this.f6639a = OplusGLSurfaceView_13;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (COUIBottomSheetBehavior.this.f6611i != null && COUIBottomSheetBehavior.this.f6611i.m3113a(true)) {
                ViewCompat.m2857a(this.f6641c, this);
            } else {
                COUIBottomSheetBehavior.this.setStateInternal(this.f6639a);
            }
            this.f6642d = false;
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.coui.appcompat.dialog.panel.COUIBottomSheetBehavior.SavedState.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int OplusGLSurfaceView_13) {
                return new SavedState[OplusGLSurfaceView_13];
            }
        };
        boolean fitToContents;
        boolean hideable;
        int peekHeight;
        boolean skipCollapsed;
        final int state;

        public SavedState(Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
            this.peekHeight = parcel.readInt();
            this.fitToContents = parcel.readInt() == 1;
            this.hideable = parcel.readInt() == 1;
            this.skipCollapsed = parcel.readInt() == 1;
        }

        public SavedState(Parcelable parcelable, COUIBottomSheetBehavior<?> cOUIBottomSheetBehavior) {
            super(parcelable);
            this.state = cOUIBottomSheetBehavior.f6610h;
            this.peekHeight = ((COUIBottomSheetBehavior) cOUIBottomSheetBehavior).f6623u;
            this.fitToContents = ((COUIBottomSheetBehavior) cOUIBottomSheetBehavior).f6620r;
            this.hideable = cOUIBottomSheetBehavior.f6609g;
            this.skipCollapsed = ((COUIBottomSheetBehavior) cOUIBottomSheetBehavior).f6588F;
        }

        @Deprecated
        public SavedState(Parcelable parcelable, int OplusGLSurfaceView_13) {
            super(parcelable);
            this.state = OplusGLSurfaceView_13;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            super.writeToParcel(parcel, OplusGLSurfaceView_13);
            parcel.writeInt(this.state);
            parcel.writeInt(this.peekHeight);
            parcel.writeInt(this.fitToContents ? 1 : 0);
            parcel.writeInt(this.hideable ? 1 : 0);
            parcel.writeInt(this.skipCollapsed ? 1 : 0);
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setUpdateImportantForAccessibilityOnSiblings(boolean z) {
        this.f6621s = z;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m6621b(boolean z) {
        Map<View, Integer> map;
        WeakReference<V> weakReference = this.f6614l;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (Build.VERSION.SDK_INT >= 16 && z) {
                if (this.f6597O != null) {
                    return;
                } else {
                    this.f6597O = new HashMap(childCount);
                }
            }
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
                View childAt = coordinatorLayout.getChildAt(OplusGLSurfaceView_13);
                if (childAt != this.f6614l.get()) {
                    if (z) {
                        if (Build.VERSION.SDK_INT >= 16) {
                            this.f6597O.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        }
                        if (this.f6621s) {
                            ViewCompat.m2867b(childAt, 4);
                        }
                    } else if (this.f6621s && (map = this.f6597O) != null && map.containsKey(childAt)) {
                        ViewCompat.m2867b(childAt, this.f6597O.get(childAt).intValue());
                    }
                }
            }
            if (z) {
                return;
            }
            this.f6597O = null;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m6635h() {
        V v;
        WeakReference<V> weakReference = this.f6614l;
        if (weakReference == null || (v = weakReference.get()) == null) {
            return;
        }
        ViewCompat.m2874c((View) v, STMobileHumanActionNative.ST_MOBILE_ENABLE_INPUT_CUSTOM);
        ViewCompat.m2874c((View) v, STMobileHumanActionNative.ST_MOBILE_DETECT_MODE_IMAGE);
        ViewCompat.m2874c((View) v, ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES);
        if (this.f6609g && this.f6610h != 5) {
            m6614a((COUIBottomSheetBehavior<V>) v, AccessibilityNodeInfoCompat.PlatformImplementations.kt_3.f3034u, 5);
        }
        int OplusGLSurfaceView_13 = this.f6610h;
        if (OplusGLSurfaceView_13 == 3) {
            m6614a((COUIBottomSheetBehavior<V>) v, AccessibilityNodeInfoCompat.PlatformImplementations.kt_3.f3033t, this.f6620r ? 4 : 6);
            return;
        }
        if (OplusGLSurfaceView_13 == 4) {
            m6614a((COUIBottomSheetBehavior<V>) v, AccessibilityNodeInfoCompat.PlatformImplementations.kt_3.f3032s, this.f6620r ? 3 : 6);
        } else {
            if (OplusGLSurfaceView_13 != 6) {
                return;
            }
            m6614a((COUIBottomSheetBehavior<V>) v, AccessibilityNodeInfoCompat.PlatformImplementations.kt_3.f3033t, 4);
            m6614a((COUIBottomSheetBehavior<V>) v, AccessibilityNodeInfoCompat.PlatformImplementations.kt_3.f3032s, 3);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6614a(V v, AccessibilityNodeInfoCompat.PlatformImplementations.kt_3 aVar, final int OplusGLSurfaceView_13) {
        ViewCompat.m2852a(v, aVar, null, new AccessibilityViewCommand() { // from class: com.coui.appcompat.dialog.panel.COUIBottomSheetBehavior.6
            @Override // androidx.core.p036h.p037a.AccessibilityViewCommand
            public boolean perform(View view, AccessibilityViewCommand.PlatformImplementations.kt_3 aVar2) {
                COUIBottomSheetBehavior.this.m6643b(OplusGLSurfaceView_13);
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m6619b(View view) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            }
        }
        return 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6639a(COUIPanelDragListener interfaceC1312e) {
        this.f6618p = interfaceC1312e;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m6642a() {
        return this.f6600R;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6640a(COUIPanelPullUpListener interfaceC1314g) {
        this.f6598P = interfaceC1314g;
    }
}
