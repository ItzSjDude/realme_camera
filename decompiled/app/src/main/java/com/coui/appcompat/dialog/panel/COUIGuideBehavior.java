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
public class COUIGuideBehavior<V extends View> extends BottomSheetBehavior<V> {

    /* renamed from: E */
    private static final int f6643E = C1694R.style.Widget_Design_BottomSheet_Modal;

    /* renamed from: A */
    private ShapeAppearanceModel f6644A;

    /* renamed from: B */
    private boolean f6645B;

    /* renamed from: C */
    private COUIGuideBehavior<V>.RunnableC1307b f6646C;

    /* renamed from: D */
    private ValueAnimator f6647D;

    /* renamed from: F */
    private boolean f6648F;

    /* renamed from: G */
    private boolean f6649G;

    /* renamed from: H */
    private boolean f6650H;

    /* renamed from: I */
    private int f6651I;

    /* renamed from: J */
    private boolean f6652J;

    /* renamed from: K */
    private final ArrayList<AbstractC1306a> f6653K;

    /* renamed from: L */
    private VelocityTracker f6654L;

    /* renamed from: M */
    private int f6655M;

    /* renamed from: N */
    private int f6656N;

    /* renamed from: O */
    private Map<View, Integer> f6657O;

    /* renamed from: P */
    private COUIPanelPullUpListener f6658P;

    /* renamed from: Q */
    private boolean f6659Q;

    /* renamed from: R */
    private boolean f6660R;

    /* renamed from: S */
    private final ViewDragHelper.PlatformImplementations.kt_3 f6661S;

    /* renamed from: PlatformImplementations.kt_3 */
    int f6662a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    int f6663b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    int f6664c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    float f6665d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    int f6666e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    float f6667f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    boolean f6668g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    int f6669h;

    /* renamed from: OplusGLSurfaceView_13 */
    ViewDragHelper f6670i;

    /* renamed from: OplusGLSurfaceView_15 */
    int f6671j;

    /* renamed from: OplusGLSurfaceView_5 */
    int f6672k;

    /* renamed from: OplusGLSurfaceView_14 */
    WeakReference<V> f6673l;

    /* renamed from: OplusGLSurfaceView_6 */
    WeakReference<View> f6674m;

    /* renamed from: OplusGLSurfaceView_11 */
    int f6675n;

    /* renamed from: o */
    boolean f6676o;

    /* renamed from: p */
    COUIPanelDragListener f6677p;

    /* renamed from: q */
    private int f6678q;

    /* renamed from: r */
    private boolean f6679r;

    /* renamed from: s */
    private boolean f6680s;

    /* renamed from: t */
    private float f6681t;

    /* renamed from: u */
    private int f6682u;

    /* renamed from: v */
    private boolean f6683v;

    /* renamed from: w */
    private int f6684w;

    /* renamed from: x */
    private boolean f6685x;

    /* renamed from: y */
    private MaterialShapeDrawable f6686y;

    /* renamed from: z */
    private boolean f6687z;

    /* renamed from: com.coui.appcompat.dialog.panel.COUIGuideBehavior$PlatformImplementations.kt_3 */
    public static abstract class AbstractC1306a {
        /* renamed from: PlatformImplementations.kt_3 */
        public abstract void m6680a(View view, float COUIBaseListPopupWindow_12);

        /* renamed from: PlatformImplementations.kt_3 */
        public abstract void m6681a(View view, int OplusGLSurfaceView_13);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int[] iArr) {
    }

    public COUIGuideBehavior() {
        this.f6678q = 0;
        this.f6679r = true;
        this.f6680s = false;
        this.f6646C = null;
        this.f6665d = 0.5f;
        this.f6667f = -1.0f;
        this.f6649G = true;
        this.f6669h = 4;
        this.f6653K = new ArrayList<>();
        this.f6661S = new ViewDragHelper.PlatformImplementations.kt_3() { // from class: com.coui.appcompat.dialog.panel.COUIGuideBehavior.3
            @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
            public boolean tryCaptureView(View view, int OplusGLSurfaceView_13) {
                if (COUIGuideBehavior.this.f6669h == 1 || COUIGuideBehavior.this.f6676o) {
                    return false;
                }
                if (COUIGuideBehavior.this.f6669h == 3 && COUIGuideBehavior.this.f6675n == OplusGLSurfaceView_13) {
                    View view2 = COUIGuideBehavior.this.f6674m != null ? COUIGuideBehavior.this.f6674m.get() : null;
                    if (view2 != null && view2.canScrollVertically(-1)) {
                        return false;
                    }
                }
                return COUIGuideBehavior.this.f6673l != null && COUIGuideBehavior.this.f6673l.get() == view;
            }

            @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
            public void onViewPositionChanged(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
                COUIGuideBehavior.this.dispatchOnSlide(i2);
            }

            @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
            public void onViewDragStateChanged(int OplusGLSurfaceView_13) {
                if (OplusGLSurfaceView_13 == 1 && COUIGuideBehavior.this.f6649G) {
                    COUIGuideBehavior.this.setStateInternal(1);
                }
            }

            /* renamed from: PlatformImplementations.kt_3 */
            private boolean m6676a(View view) {
                return view.getTop() > (COUIGuideBehavior.this.f6672k + COUIGuideBehavior.this.getExpandedOffset()) / 2;
            }

            @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
            public void onViewReleased(View view, float COUIBaseListPopupWindow_12, float f2) {
                int OplusGLSurfaceView_13;
                if (COUIGuideBehavior.this.f6658P != null && COUIGuideBehavior.this.f6672k - view.getHeight() < COUIGuideBehavior.this.getExpandedOffset() && view.getTop() < COUIGuideBehavior.this.getExpandedOffset()) {
                    COUIGuideBehavior.this.f6658P.mo6822a(COUIGuideBehavior.this.getExpandedOffset());
                    return;
                }
                int i2 = 4;
                if (f2 < 0.0f) {
                    if (COUIGuideBehavior.this.f6679r) {
                        OplusGLSurfaceView_13 = COUIGuideBehavior.this.f6663b;
                    } else if (view.getTop() > COUIGuideBehavior.this.f6664c) {
                        OplusGLSurfaceView_13 = COUIGuideBehavior.this.f6664c;
                        i2 = 6;
                    } else {
                        OplusGLSurfaceView_13 = COUIGuideBehavior.this.f6662a;
                    }
                    i2 = 3;
                } else if (COUIGuideBehavior.this.f6668g && COUIGuideBehavior.this.shouldHide(view, f2)) {
                    if (COUIGuideBehavior.this.f6677p != null && COUIGuideBehavior.this.f6677p.mo6867a()) {
                        OplusGLSurfaceView_13 = COUIGuideBehavior.this.f6663b;
                        COUIGuideBehavior.this.f6660R = false;
                    } else if ((Math.abs(COUIBaseListPopupWindow_12) >= Math.abs(f2) || f2 <= 500.0f) && !m6676a(view)) {
                        if (COUIGuideBehavior.this.f6679r) {
                            OplusGLSurfaceView_13 = COUIGuideBehavior.this.f6663b;
                        } else if (Math.abs(view.getTop() - COUIGuideBehavior.this.f6662a) < Math.abs(view.getTop() - COUIGuideBehavior.this.f6664c)) {
                            OplusGLSurfaceView_13 = COUIGuideBehavior.this.f6662a;
                        } else {
                            OplusGLSurfaceView_13 = COUIGuideBehavior.this.f6664c;
                            i2 = 6;
                        }
                    } else {
                        OplusGLSurfaceView_13 = COUIGuideBehavior.this.f6672k;
                        i2 = 5;
                        COUIGuideBehavior.this.f6660R = true;
                    }
                    i2 = 3;
                } else if (f2 != 0.0f && Math.abs(COUIBaseListPopupWindow_12) <= Math.abs(f2)) {
                    if (COUIGuideBehavior.this.f6679r) {
                        OplusGLSurfaceView_13 = COUIGuideBehavior.this.f6666e;
                    } else {
                        int top = view.getTop();
                        if (Math.abs(top - COUIGuideBehavior.this.f6664c) < Math.abs(top - COUIGuideBehavior.this.f6666e)) {
                            OplusGLSurfaceView_13 = COUIGuideBehavior.this.f6664c;
                            i2 = 6;
                        } else {
                            OplusGLSurfaceView_13 = COUIGuideBehavior.this.f6666e;
                        }
                    }
                } else {
                    int top2 = view.getTop();
                    if (COUIGuideBehavior.this.f6679r) {
                        if (Math.abs(top2 - COUIGuideBehavior.this.f6663b) < Math.abs(top2 - COUIGuideBehavior.this.f6666e)) {
                            OplusGLSurfaceView_13 = COUIGuideBehavior.this.f6663b;
                            i2 = 3;
                        } else {
                            OplusGLSurfaceView_13 = COUIGuideBehavior.this.f6666e;
                        }
                    } else {
                        if (top2 < COUIGuideBehavior.this.f6664c) {
                            if (top2 < Math.abs(top2 - COUIGuideBehavior.this.f6666e)) {
                                OplusGLSurfaceView_13 = COUIGuideBehavior.this.f6662a;
                                i2 = 3;
                            } else {
                                OplusGLSurfaceView_13 = COUIGuideBehavior.this.f6664c;
                            }
                        } else if (Math.abs(top2 - COUIGuideBehavior.this.f6664c) < Math.abs(top2 - COUIGuideBehavior.this.f6666e)) {
                            OplusGLSurfaceView_13 = COUIGuideBehavior.this.f6664c;
                        } else {
                            OplusGLSurfaceView_13 = COUIGuideBehavior.this.f6666e;
                        }
                        i2 = 6;
                    }
                }
                COUIGuideBehavior.this.startSettlingAnimation(view, i2, OplusGLSurfaceView_13, true);
            }

            @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
            public int clampViewPositionVertical(View view, int OplusGLSurfaceView_13, int i2) {
                int iMo6820a = 0;
                if (COUIGuideBehavior.this.f6658P != null) {
                    if (COUIGuideBehavior.this.f6669h == 3 || (COUIGuideBehavior.this.f6669h == 1 && view.getTop() <= COUIGuideBehavior.this.getExpandedOffset())) {
                        COUIGuideBehavior.this.f6659Q = true;
                        iMo6820a = COUIGuideBehavior.this.f6658P.mo6820a(i2, COUIGuideBehavior.this.getExpandedOffset());
                    }
                }
                return MathUtils.m2447a(OplusGLSurfaceView_13, COUIGuideBehavior.this.getExpandedOffset() - iMo6820a, COUIGuideBehavior.this.f6668g ? COUIGuideBehavior.this.f6672k : COUIGuideBehavior.this.f6666e);
            }

            @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
            public int clampViewPositionHorizontal(View view, int OplusGLSurfaceView_13, int i2) {
                return view.getLeft();
            }

            @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
            public int getViewVerticalDragRange(View view) {
                if (COUIGuideBehavior.this.f6668g) {
                    return COUIGuideBehavior.this.f6672k;
                }
                return COUIGuideBehavior.this.f6666e;
            }
        };
    }

    public COUIGuideBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6678q = 0;
        this.f6679r = true;
        this.f6680s = false;
        this.f6646C = null;
        this.f6665d = 0.5f;
        this.f6667f = -1.0f;
        this.f6649G = true;
        this.f6669h = 4;
        this.f6653K = new ArrayList<>();
        this.f6661S = new ViewDragHelper.PlatformImplementations.kt_3() { // from class: com.coui.appcompat.dialog.panel.COUIGuideBehavior.3
            @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
            public boolean tryCaptureView(View view, int OplusGLSurfaceView_13) {
                if (COUIGuideBehavior.this.f6669h == 1 || COUIGuideBehavior.this.f6676o) {
                    return false;
                }
                if (COUIGuideBehavior.this.f6669h == 3 && COUIGuideBehavior.this.f6675n == OplusGLSurfaceView_13) {
                    View view2 = COUIGuideBehavior.this.f6674m != null ? COUIGuideBehavior.this.f6674m.get() : null;
                    if (view2 != null && view2.canScrollVertically(-1)) {
                        return false;
                    }
                }
                return COUIGuideBehavior.this.f6673l != null && COUIGuideBehavior.this.f6673l.get() == view;
            }

            @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
            public void onViewPositionChanged(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
                COUIGuideBehavior.this.dispatchOnSlide(i2);
            }

            @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
            public void onViewDragStateChanged(int OplusGLSurfaceView_13) {
                if (OplusGLSurfaceView_13 == 1 && COUIGuideBehavior.this.f6649G) {
                    COUIGuideBehavior.this.setStateInternal(1);
                }
            }

            /* renamed from: PlatformImplementations.kt_3 */
            private boolean m6676a(View view) {
                return view.getTop() > (COUIGuideBehavior.this.f6672k + COUIGuideBehavior.this.getExpandedOffset()) / 2;
            }

            @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
            public void onViewReleased(View view, float COUIBaseListPopupWindow_12, float f2) {
                int OplusGLSurfaceView_13;
                if (COUIGuideBehavior.this.f6658P != null && COUIGuideBehavior.this.f6672k - view.getHeight() < COUIGuideBehavior.this.getExpandedOffset() && view.getTop() < COUIGuideBehavior.this.getExpandedOffset()) {
                    COUIGuideBehavior.this.f6658P.mo6822a(COUIGuideBehavior.this.getExpandedOffset());
                    return;
                }
                int i2 = 4;
                if (f2 < 0.0f) {
                    if (COUIGuideBehavior.this.f6679r) {
                        OplusGLSurfaceView_13 = COUIGuideBehavior.this.f6663b;
                    } else if (view.getTop() > COUIGuideBehavior.this.f6664c) {
                        OplusGLSurfaceView_13 = COUIGuideBehavior.this.f6664c;
                        i2 = 6;
                    } else {
                        OplusGLSurfaceView_13 = COUIGuideBehavior.this.f6662a;
                    }
                    i2 = 3;
                } else if (COUIGuideBehavior.this.f6668g && COUIGuideBehavior.this.shouldHide(view, f2)) {
                    if (COUIGuideBehavior.this.f6677p != null && COUIGuideBehavior.this.f6677p.mo6867a()) {
                        OplusGLSurfaceView_13 = COUIGuideBehavior.this.f6663b;
                        COUIGuideBehavior.this.f6660R = false;
                    } else if ((Math.abs(COUIBaseListPopupWindow_12) >= Math.abs(f2) || f2 <= 500.0f) && !m6676a(view)) {
                        if (COUIGuideBehavior.this.f6679r) {
                            OplusGLSurfaceView_13 = COUIGuideBehavior.this.f6663b;
                        } else if (Math.abs(view.getTop() - COUIGuideBehavior.this.f6662a) < Math.abs(view.getTop() - COUIGuideBehavior.this.f6664c)) {
                            OplusGLSurfaceView_13 = COUIGuideBehavior.this.f6662a;
                        } else {
                            OplusGLSurfaceView_13 = COUIGuideBehavior.this.f6664c;
                            i2 = 6;
                        }
                    } else {
                        OplusGLSurfaceView_13 = COUIGuideBehavior.this.f6672k;
                        i2 = 5;
                        COUIGuideBehavior.this.f6660R = true;
                    }
                    i2 = 3;
                } else if (f2 != 0.0f && Math.abs(COUIBaseListPopupWindow_12) <= Math.abs(f2)) {
                    if (COUIGuideBehavior.this.f6679r) {
                        OplusGLSurfaceView_13 = COUIGuideBehavior.this.f6666e;
                    } else {
                        int top = view.getTop();
                        if (Math.abs(top - COUIGuideBehavior.this.f6664c) < Math.abs(top - COUIGuideBehavior.this.f6666e)) {
                            OplusGLSurfaceView_13 = COUIGuideBehavior.this.f6664c;
                            i2 = 6;
                        } else {
                            OplusGLSurfaceView_13 = COUIGuideBehavior.this.f6666e;
                        }
                    }
                } else {
                    int top2 = view.getTop();
                    if (COUIGuideBehavior.this.f6679r) {
                        if (Math.abs(top2 - COUIGuideBehavior.this.f6663b) < Math.abs(top2 - COUIGuideBehavior.this.f6666e)) {
                            OplusGLSurfaceView_13 = COUIGuideBehavior.this.f6663b;
                            i2 = 3;
                        } else {
                            OplusGLSurfaceView_13 = COUIGuideBehavior.this.f6666e;
                        }
                    } else {
                        if (top2 < COUIGuideBehavior.this.f6664c) {
                            if (top2 < Math.abs(top2 - COUIGuideBehavior.this.f6666e)) {
                                OplusGLSurfaceView_13 = COUIGuideBehavior.this.f6662a;
                                i2 = 3;
                            } else {
                                OplusGLSurfaceView_13 = COUIGuideBehavior.this.f6664c;
                            }
                        } else if (Math.abs(top2 - COUIGuideBehavior.this.f6664c) < Math.abs(top2 - COUIGuideBehavior.this.f6666e)) {
                            OplusGLSurfaceView_13 = COUIGuideBehavior.this.f6664c;
                        } else {
                            OplusGLSurfaceView_13 = COUIGuideBehavior.this.f6666e;
                        }
                        i2 = 6;
                    }
                }
                COUIGuideBehavior.this.startSettlingAnimation(view, i2, OplusGLSurfaceView_13, true);
            }

            @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
            public int clampViewPositionVertical(View view, int OplusGLSurfaceView_13, int i2) {
                int iMo6820a = 0;
                if (COUIGuideBehavior.this.f6658P != null) {
                    if (COUIGuideBehavior.this.f6669h == 3 || (COUIGuideBehavior.this.f6669h == 1 && view.getTop() <= COUIGuideBehavior.this.getExpandedOffset())) {
                        COUIGuideBehavior.this.f6659Q = true;
                        iMo6820a = COUIGuideBehavior.this.f6658P.mo6820a(i2, COUIGuideBehavior.this.getExpandedOffset());
                    }
                }
                return MathUtils.m2447a(OplusGLSurfaceView_13, COUIGuideBehavior.this.getExpandedOffset() - iMo6820a, COUIGuideBehavior.this.f6668g ? COUIGuideBehavior.this.f6672k : COUIGuideBehavior.this.f6666e);
            }

            @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
            public int clampViewPositionHorizontal(View view, int OplusGLSurfaceView_13, int i2) {
                return view.getLeft();
            }

            @Override // androidx.customview.p039a.ViewDragHelper.PlatformImplementations.kt_3
            public int getViewVerticalDragRange(View view) {
                if (COUIGuideBehavior.this.f6668g) {
                    return COUIGuideBehavior.this.f6672k;
                }
                return COUIGuideBehavior.this.f6666e;
            }
        };
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1694R.styleable.BottomSheetBehavior_Layout);
        this.f6685x = typedArrayObtainStyledAttributes.hasValue(C1694R.styleable.BottomSheetBehavior_Layout_shapeAppearance);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(C1694R.styleable.BottomSheetBehavior_Layout_backgroundTint);
        if (zHasValue) {
            m6657a(context, attributeSet, zHasValue, MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, C1694R.styleable.BottomSheetBehavior_Layout_backgroundTint));
        } else {
            m6656a(context, attributeSet, zHasValue);
        }
        m6672e();
        if (Build.VERSION.SDK_INT >= 21) {
            this.f6667f = typedArrayObtainStyledAttributes.getDimension(C1694R.styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        }
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(C1694R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (typedValuePeekValue != null && typedValuePeekValue.data == -1) {
            setPeekHeight(typedValuePeekValue.data);
        } else {
            setPeekHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(C1694R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        }
        setHideable(typedArrayObtainStyledAttributes.getBoolean(C1694R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        setGestureInsetBottomIgnored(typedArrayObtainStyledAttributes.getBoolean(C1694R.styleable.f9179xed791f57, false));
        setFitToContents(typedArrayObtainStyledAttributes.getBoolean(C1694R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        setSkipCollapsed(typedArrayObtainStyledAttributes.getBoolean(C1694R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        setDraggable(typedArrayObtainStyledAttributes.getBoolean(C1694R.styleable.BottomSheetBehavior_Layout_behavior_draggable, true));
        setSaveFlags(typedArrayObtainStyledAttributes.getInt(C1694R.styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        setHalfExpandedRatio(typedArrayObtainStyledAttributes.getFloat(C1694R.styleable.f9178x40da2d0e, 0.5f));
        TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(C1694R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset);
        if (typedValuePeekValue2 != null && typedValuePeekValue2.type == 16) {
            setExpandedOffset(typedValuePeekValue2.data);
        } else {
            setExpandedOffset(typedArrayObtainStyledAttributes.getDimensionPixelOffset(C1694R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset, 0));
        }
        typedArrayObtainStyledAttributes.recycle();
        this.f6681t = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        this.f6660R = false;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v), (COUIGuideBehavior<?>) this);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v, savedState.getSuperState());
        m6660a(savedState);
        if (savedState.state == 1 || savedState.state == 2) {
            this.f6669h = 4;
        } else {
            this.f6669h = savedState.state;
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
    public void onAttachedToLayoutParams(CoordinatorLayout.C0411e c0411e) {
        super.onAttachedToLayoutParams(c0411e);
        this.f6673l = null;
        this.f6670i = null;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.f6673l = null;
        this.f6670i = null;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int OplusGLSurfaceView_13) {
        MaterialShapeDrawable materialShapeDrawable;
        if (ViewCompat.m2901t(coordinatorLayout) && !ViewCompat.m2901t(v)) {
            v.setFitsSystemWindows(true);
        }
        if (this.f6673l == null) {
            this.f6684w = coordinatorLayout.getResources().getDimensionPixelSize(C1694R.dimen.design_bottom_sheet_peek_height_min);
            m6659a(coordinatorLayout);
            this.f6673l = new WeakReference<>(v);
            if (this.f6685x && (materialShapeDrawable = this.f6686y) != null) {
                ViewCompat.m2850a(v, materialShapeDrawable);
            }
            MaterialShapeDrawable materialShapeDrawable2 = this.f6686y;
            if (materialShapeDrawable2 != null) {
                float fM2896o = this.f6667f;
                if (fM2896o == -1.0f) {
                    fM2896o = ViewCompat.m2896o(v);
                }
                materialShapeDrawable2.setElevation(fM2896o);
                this.f6645B = this.f6669h == 3;
                this.f6686y.setInterpolation(this.f6645B ? 0.0f : 1.0f);
            }
            m6675g();
            if (ViewCompat.m2883f(v) == 0) {
                ViewCompat.m2867b((View) v, 1);
            }
        }
        if (this.f6670i == null) {
            this.f6670i = ViewDragHelper.m3091a(coordinatorLayout, this.f6661S);
        }
        int top = v.getTop();
        coordinatorLayout.onLayoutChild(v, OplusGLSurfaceView_13);
        this.f6671j = coordinatorLayout.getWidth();
        this.f6672k = coordinatorLayout.getHeight();
        if (!this.f6659Q) {
            this.f6663b = Math.max(0, this.f6672k - v.getHeight());
        }
        this.f6659Q = false;
        m6668c();
        m6663b();
        int i2 = this.f6669h;
        if (i2 == 3) {
            ViewCompat.m2882e(v, getExpandedOffset());
        } else if (i2 == 6) {
            ViewCompat.m2882e(v, this.f6664c);
        } else if (this.f6668g && i2 == 5) {
            ViewCompat.m2882e(v, this.f6672k);
        } else {
            int i3 = this.f6669h;
            if (i3 == 4) {
                ViewCompat.m2882e(v, this.f6666e);
            } else if (i3 == 1 || i3 == 2) {
                ViewCompat.m2882e(v, top - v.getTop());
            }
        }
        this.f6674m = new WeakReference<>(findScrollingChild(v));
        return true;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        ViewDragHelper c0535c;
        if (!v.isShown() || !this.f6649G) {
            this.f6650H = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            m6669d();
        }
        if (this.f6654L == null) {
            this.f6654L = VelocityTracker.obtain();
        }
        this.f6654L.addMovement(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                COUIPanelPullUpListener interfaceC1314g = this.f6658P;
                if (interfaceC1314g != null) {
                    interfaceC1314g.mo6821a();
                }
            } else if (actionMasked == 3) {
            }
            this.f6676o = false;
            this.f6675n = -1;
            if (this.f6650H) {
                this.f6650H = false;
                return false;
            }
        } else {
            this.f6655M = (int) motionEvent.getX();
            this.f6656N = (int) motionEvent.getY();
            if (this.f6669h != 2) {
                WeakReference<View> weakReference = this.f6674m;
                View view = weakReference != null ? weakReference.get() : null;
                if (view != null && coordinatorLayout.isPointInChildBounds(view, this.f6655M, this.f6656N)) {
                    this.f6675n = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.f6676o = true;
                }
            }
            this.f6650H = this.f6675n == -1 && !coordinatorLayout.isPointInChildBounds(v, this.f6655M, this.f6656N);
        }
        if (!this.f6650H && (c0535c = this.f6670i) != null && c0535c.m3111a(motionEvent)) {
            return true;
        }
        if (Math.abs(this.f6656N - motionEvent.getY()) > Math.abs(this.f6655M - motionEvent.getX()) * 2.0f && this.f6670i != null && Math.abs(this.f6656N - motionEvent.getY()) > this.f6670i.m3123d()) {
            return true;
        }
        WeakReference<View> weakReference2 = this.f6674m;
        View view2 = weakReference2 != null ? weakReference2.get() : null;
        return (actionMasked != 2 || view2 == null || this.f6650H || this.f6669h == 1 || coordinatorLayout.isPointInChildBounds(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.f6670i == null || Math.abs(((float) this.f6656N) - motionEvent.getY()) <= ((float) this.f6670i.m3123d())) ? false : true;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.f6669h == 1 && actionMasked == 0) {
            return true;
        }
        ViewDragHelper c0535c = this.f6670i;
        if (c0535c != null) {
            c0535c.m3115b(motionEvent);
        }
        if (actionMasked == 0) {
            m6669d();
        }
        if (this.f6654L == null) {
            this.f6654L = VelocityTracker.obtain();
        }
        this.f6654L.addMovement(motionEvent);
        if (actionMasked == 2 && !this.f6650H && Math.abs(this.f6656N - motionEvent.getY()) > this.f6670i.m3123d()) {
            this.f6670i.m3109a(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.f6650H;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int OplusGLSurfaceView_13, int i2) {
        this.f6651I = 0;
        this.f6652J = false;
        return (OplusGLSurfaceView_13 & 2) != 0;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int OplusGLSurfaceView_13, int i2, int[] iArr, int i3) {
        if (i3 == 1) {
            return;
        }
        WeakReference<View> weakReference = this.f6674m;
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
                if (!this.f6649G) {
                    return;
                }
                iArr[1] = i2;
                ViewCompat.m2882e(v, -i2);
                setStateInternal(1);
            }
        } else if (i2 < 0 && !view.canScrollVertically(-1)) {
            int i5 = this.f6666e;
            if (i4 <= i5 || this.f6668g) {
                if (!this.f6649G) {
                    return;
                }
                iArr[1] = i2;
                ViewCompat.m2882e(v, -i2);
                setStateInternal(1);
            } else {
                iArr[1] = top - i5;
                ViewCompat.m2882e(v, -iArr[1]);
                setStateInternal(4);
            }
        }
        dispatchOnSlide(v.getTop());
        this.f6651I = i2;
        this.f6652J = true;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int OplusGLSurfaceView_13) {
        int i2;
        int i3 = 3;
        if (v.getTop() == getExpandedOffset()) {
            setStateInternal(3);
            return;
        }
        WeakReference<View> weakReference = this.f6674m;
        if (weakReference != null && view == weakReference.get() && this.f6652J) {
            if (this.f6651I > 0) {
                if (this.f6679r) {
                    i2 = this.f6663b;
                } else {
                    int top = v.getTop();
                    int i4 = this.f6664c;
                    if (top > i4) {
                        i2 = i4;
                        i3 = 6;
                    } else {
                        i2 = this.f6662a;
                    }
                }
            } else if (this.f6668g && shouldHide(v, m6673f())) {
                COUIPanelDragListener interfaceC1312e = this.f6677p;
                if (interfaceC1312e != null && interfaceC1312e.mo6867a()) {
                    i2 = this.f6663b;
                    this.f6660R = false;
                } else {
                    i2 = this.f6672k;
                    i3 = 5;
                    this.f6660R = true;
                }
            } else if (this.f6651I == 0) {
                int top2 = v.getTop();
                if (this.f6679r) {
                    if (Math.abs(top2 - this.f6663b) < Math.abs(top2 - this.f6666e)) {
                        i2 = this.f6663b;
                    } else {
                        i2 = this.f6666e;
                        i3 = 4;
                    }
                } else {
                    int i5 = this.f6664c;
                    if (top2 < i5) {
                        if (top2 < Math.abs(top2 - this.f6666e)) {
                            i2 = this.f6662a;
                        } else {
                            i2 = this.f6664c;
                        }
                    } else if (Math.abs(top2 - i5) < Math.abs(top2 - this.f6666e)) {
                        i2 = this.f6664c;
                    } else {
                        i2 = this.f6666e;
                        i3 = 4;
                    }
                    i3 = 6;
                }
            } else {
                if (this.f6679r) {
                    i2 = this.f6666e;
                } else {
                    int top3 = v.getTop();
                    if (Math.abs(top3 - this.f6664c) < Math.abs(top3 - this.f6666e)) {
                        i2 = this.f6664c;
                        i3 = 6;
                    } else {
                        i2 = this.f6666e;
                    }
                }
                i3 = 4;
            }
            startSettlingAnimation(v, i3, i2, false);
            this.f6652J = false;
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.AbstractC0408b
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float COUIBaseListPopupWindow_12, float f2) {
        WeakReference<View> weakReference = this.f6674m;
        if (weakReference == null || view != weakReference.get()) {
            return false;
        }
        return this.f6669h != 3 || super.onNestedPreFling(coordinatorLayout, v, view, COUIBaseListPopupWindow_12, f2);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public boolean isFitToContents() {
        return this.f6679r;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setFitToContents(boolean z) {
        if (this.f6679r == z) {
            return;
        }
        this.f6679r = z;
        if (this.f6673l != null) {
            m6663b();
        }
        setStateInternal((this.f6679r && this.f6669h == 6) ? 3 : this.f6669h);
        m6675g();
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setPeekHeight(int OplusGLSurfaceView_13) {
        m6655a(OplusGLSurfaceView_13, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0015  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m6655a(int r4, boolean r5) {
        /*
            r3 = this;
            r0 = 1
            r1 = 0
            r2 = -1
            if (r4 != r2) goto Lc
            boolean r4 = r3.f6683v
            if (r4 != 0) goto L15
            r3.f6683v = r0
            goto L1f
        Lc:
            boolean r2 = r3.f6683v
            if (r2 != 0) goto L17
            int r2 = r3.f6682u
            if (r2 == r4) goto L15
            goto L17
        L15:
            r0 = r1
            goto L1f
        L17:
            r3.f6683v = r1
            int r4 = java.lang.Math.max(r1, r4)
            r3.f6682u = r4
        L1f:
            if (r0 == 0) goto L42
            java.lang.ref.WeakReference<V extends android.view.View> r4 = r3.f6673l
            if (r4 == 0) goto L42
            r3.m6663b()
            int r4 = r3.f6669h
            r0 = 4
            if (r4 != r0) goto L42
            java.lang.ref.WeakReference<V extends android.view.View> r4 = r3.f6673l
            java.lang.Object r4 = r4.get()
            android.view.View r4 = (android.view.View) r4
            if (r4 == 0) goto L42
            if (r5 == 0) goto L3f
            int r4 = r3.f6669h
            r3.m6654a(r4)
            goto L42
        L3f:
            r4.requestLayout()
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.dialog.panel.COUIGuideBehavior.m6655a(int, boolean):void");
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public int getPeekHeight() {
        if (this.f6683v) {
            return -1;
        }
        return this.f6682u;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setHalfExpandedRatio(float COUIBaseListPopupWindow_12) {
        if (COUIBaseListPopupWindow_12 <= 0.0f || COUIBaseListPopupWindow_12 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be PlatformImplementations.kt_3 float value between 0 and 1");
        }
        this.f6665d = COUIBaseListPopupWindow_12;
        if (this.f6673l != null) {
            m6668c();
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public float getHalfExpandedRatio() {
        return this.f6665d;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setExpandedOffset(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0) {
            throw new IllegalArgumentException("offset must be greater than or equal to 0");
        }
        this.f6662a = OplusGLSurfaceView_13;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public int getExpandedOffset() {
        return this.f6679r ? this.f6663b : this.f6662a;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    @SuppressLint({"WrongConstant"})
    public void setHideable(boolean z) {
        if (this.f6668g != z) {
            this.f6668g = z;
            if (!z && this.f6669h == 5) {
                setState(4);
            }
            m6675g();
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public boolean isHideable() {
        return this.f6668g;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setSkipCollapsed(boolean z) {
        this.f6648F = z;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public boolean getSkipCollapsed() {
        return this.f6648F;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setDraggable(boolean z) {
        this.f6649G = z;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public boolean isDraggable() {
        return this.f6649G;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setSaveFlags(int OplusGLSurfaceView_13) {
        this.f6678q = OplusGLSurfaceView_13;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public int getSaveFlags() {
        return this.f6678q;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setState(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == this.f6669h) {
            return;
        }
        if (this.f6673l == null) {
            if (OplusGLSurfaceView_13 == 4 || OplusGLSurfaceView_13 == 3 || OplusGLSurfaceView_13 == 6 || (this.f6668g && OplusGLSurfaceView_13 == 5)) {
                this.f6669h = OplusGLSurfaceView_13;
                return;
            }
            return;
        }
        m6654a(OplusGLSurfaceView_13);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void setGestureInsetBottomIgnored(boolean z) {
        this.f6687z = z;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public boolean isGestureInsetBottomIgnored() {
        return this.f6687z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6654a(final int OplusGLSurfaceView_13) {
        final V v = this.f6673l.get();
        if (v == null) {
            return;
        }
        ViewParent parent = v.getParent();
        if (parent != null && parent.isLayoutRequested() && ViewCompat.m2826D(v)) {
            v.post(new Runnable() { // from class: com.coui.appcompat.dialog.panel.COUIGuideBehavior.1
                @Override // java.lang.Runnable
                public void run() {
                    COUIGuideBehavior.this.settleToState(v, OplusGLSurfaceView_13);
                }
            });
        } else {
            settleToState(v, OplusGLSurfaceView_13);
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    @SuppressLint({"WrongConstant"})
    public int getState() {
        return this.f6669h;
    }

    void setStateInternal(int OplusGLSurfaceView_13) {
        V v;
        if (this.f6669h == OplusGLSurfaceView_13) {
            return;
        }
        this.f6669h = OplusGLSurfaceView_13;
        WeakReference<V> weakReference = this.f6673l;
        if (weakReference == null || (v = weakReference.get()) == null) {
            return;
        }
        if (OplusGLSurfaceView_13 == 3) {
            m6661a(true);
        } else if (OplusGLSurfaceView_13 == 6 || OplusGLSurfaceView_13 == 5 || OplusGLSurfaceView_13 == 4) {
            m6661a(false);
        }
        m6664b(OplusGLSurfaceView_13);
        for (int i2 = 0; i2 < this.f6653K.size(); i2++) {
            this.f6653K.get(i2).m6681a((View) v, OplusGLSurfaceView_13);
        }
        m6675g();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m6664b(int OplusGLSurfaceView_13) {
        ValueAnimator valueAnimator;
        if (OplusGLSurfaceView_13 == 2) {
            return;
        }
        boolean z = OplusGLSurfaceView_13 == 3;
        if (this.f6645B != z) {
            this.f6645B = z;
            if (this.f6686y == null || (valueAnimator = this.f6647D) == null) {
                return;
            }
            if (valueAnimator.isRunning()) {
                this.f6647D.reverse();
                return;
            }
            float COUIBaseListPopupWindow_12 = z ? 0.0f : 1.0f;
            this.f6647D.setFloatValues(1.0f - COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12);
            this.f6647D.start();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m6652a() {
        if (this.f6683v) {
            return Math.max(this.f6684w, this.f6672k - ((this.f6671j * 9) / 16));
        }
        return this.f6682u;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m6663b() {
        int iM6652a = m6652a();
        if (this.f6679r) {
            this.f6666e = Math.max(this.f6672k - iM6652a, this.f6663b);
        } else {
            this.f6666e = this.f6672k - iM6652a;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m6668c() {
        this.f6664c = (int) (this.f6672k * (1.0f - this.f6665d));
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m6669d() {
        this.f6675n = -1;
        VelocityTracker velocityTracker = this.f6654L;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f6654L = null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6660a(SavedState savedState) {
        int OplusGLSurfaceView_13 = this.f6678q;
        if (OplusGLSurfaceView_13 == 0) {
            return;
        }
        if (OplusGLSurfaceView_13 == -1 || (OplusGLSurfaceView_13 & 1) == 1) {
            this.f6682u = savedState.peekHeight;
        }
        int i2 = this.f6678q;
        if (i2 == -1 || (i2 & 2) == 2) {
            this.f6679r = savedState.fitToContents;
        }
        int i3 = this.f6678q;
        if (i3 == -1 || (i3 & 4) == 4) {
            this.f6668g = savedState.hideable;
        }
        int i4 = this.f6678q;
        if (i4 == -1 || (i4 & 8) == 8) {
            this.f6648F = savedState.skipCollapsed;
        }
    }

    boolean shouldHide(View view, float COUIBaseListPopupWindow_12) {
        if (this.f6648F) {
            return true;
        }
        if (view.getTop() < this.f6666e) {
            return false;
        }
        return Math.abs((((float) view.getTop()) + (COUIBaseListPopupWindow_12 * 0.1f)) - ((float) this.f6666e)) / ((float) m6652a()) > 0.5f;
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
    private void m6656a(Context context, AttributeSet attributeSet, boolean z) {
        m6657a(context, attributeSet, z, null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6657a(Context context, AttributeSet attributeSet, boolean z, ColorStateList colorStateList) {
        if (this.f6685x) {
            this.f6644A = ShapeAppearanceModel.builder(context, attributeSet, C1694R.attr.bottomSheetStyle, f6643E).build();
            this.f6686y = new MaterialShapeDrawable(this.f6644A);
            this.f6686y.initializeElevationOverlay(context);
            if (z && colorStateList != null) {
                this.f6686y.setFillColor(colorStateList);
                return;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.colorBackground, typedValue, true);
            this.f6686y.setTint(typedValue.data);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m6672e() {
        this.f6647D = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f6647D.setDuration(500L);
        this.f6647D.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.dialog.panel.COUIGuideBehavior.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (COUIGuideBehavior.this.f6686y != null) {
                    COUIGuideBehavior.this.f6686y.setInterpolation(fFloatValue);
                }
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6659a(CoordinatorLayout coordinatorLayout) {
        WindowInsets rootWindowInsets;
        if (Build.VERSION.SDK_INT < 29 || isGestureInsetBottomIgnored() || (rootWindowInsets = coordinatorLayout.getRootWindowInsets()) == null) {
            return;
        }
        this.f6682u += rootWindowInsets.getSystemGestureInsets().bottom;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private float m6673f() {
        VelocityTracker velocityTracker = this.f6654L;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.f6681t);
        return this.f6654L.getYVelocity(this.f6675n);
    }

    void settleToState(View view, int OplusGLSurfaceView_13) {
        int expandedOffset;
        int i2;
        if (OplusGLSurfaceView_13 == 4) {
            expandedOffset = this.f6666e;
        } else if (OplusGLSurfaceView_13 == 6) {
            int i3 = this.f6664c;
            if (!this.f6679r || i3 > (i2 = this.f6663b)) {
                expandedOffset = i3;
            } else {
                OplusGLSurfaceView_13 = 3;
                expandedOffset = i2;
            }
        } else if (OplusGLSurfaceView_13 == 3) {
            expandedOffset = getExpandedOffset();
        } else if (this.f6668g && OplusGLSurfaceView_13 == 5) {
            expandedOffset = this.f6672k;
        } else {
            throw new IllegalArgumentException("Illegal state argument: " + OplusGLSurfaceView_13);
        }
        startSettlingAnimation(view, OplusGLSurfaceView_13, expandedOffset, false);
    }

    void startSettlingAnimation(View view, int OplusGLSurfaceView_13, int i2, boolean z) {
        boolean zM3112a;
        if (z) {
            zM3112a = this.f6670i.m3110a(view.getLeft(), i2);
        } else {
            zM3112a = this.f6670i.m3112a(view, view.getLeft(), i2);
        }
        if (zM3112a) {
            setStateInternal(2);
            m6664b(OplusGLSurfaceView_13);
            if (this.f6646C == null) {
                this.f6646C = new RunnableC1307b(view, OplusGLSurfaceView_13);
            }
            if (!((RunnableC1307b) this.f6646C).f6698d) {
                COUIGuideBehavior<V>.RunnableC1307b runnableC1307b = this.f6646C;
                runnableC1307b.f6695a = OplusGLSurfaceView_13;
                ViewCompat.m2857a(view, runnableC1307b);
                ((RunnableC1307b) this.f6646C).f6698d = true;
                return;
            }
            this.f6646C.f6695a = OplusGLSurfaceView_13;
            return;
        }
        setStateInternal(OplusGLSurfaceView_13);
    }

    void dispatchOnSlide(int OplusGLSurfaceView_13) {
        float COUIBaseListPopupWindow_12;
        float expandedOffset;
        V v = this.f6673l.get();
        if (v == null || this.f6653K.isEmpty()) {
            return;
        }
        int i2 = this.f6666e;
        if (OplusGLSurfaceView_13 > i2 || i2 == getExpandedOffset()) {
            int i3 = this.f6666e;
            COUIBaseListPopupWindow_12 = i3 - OplusGLSurfaceView_13;
            expandedOffset = this.f6672k - i3;
        } else {
            int i4 = this.f6666e;
            COUIBaseListPopupWindow_12 = i4 - OplusGLSurfaceView_13;
            expandedOffset = i4 - getExpandedOffset();
        }
        float f2 = COUIBaseListPopupWindow_12 / expandedOffset;
        for (int i5 = 0; i5 < this.f6653K.size(); i5++) {
            this.f6653K.get(i5).m6680a(v, f2);
        }
    }

    int getPeekHeightMin() {
        return this.f6684w;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior
    public void disableShapeAnimations() {
        this.f6647D = null;
    }

    /* renamed from: com.coui.appcompat.dialog.panel.COUIGuideBehavior$IntrinsicsJvm.kt_4 */
    private class RunnableC1307b implements Runnable {

        /* renamed from: PlatformImplementations.kt_3 */
        int f6695a;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final View f6697c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private boolean f6698d;

        RunnableC1307b(View view, int OplusGLSurfaceView_13) {
            this.f6697c = view;
            this.f6695a = OplusGLSurfaceView_13;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (COUIGuideBehavior.this.f6670i != null && COUIGuideBehavior.this.f6670i.m3113a(true)) {
                ViewCompat.m2857a(this.f6697c, this);
            } else {
                COUIGuideBehavior.this.setStateInternal(this.f6695a);
            }
            this.f6698d = false;
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.coui.appcompat.dialog.panel.COUIGuideBehavior.SavedState.1
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

        public SavedState(Parcelable parcelable, COUIGuideBehavior<?> cOUIGuideBehavior) {
            super(parcelable);
            this.state = cOUIGuideBehavior.f6669h;
            this.peekHeight = ((COUIGuideBehavior) cOUIGuideBehavior).f6682u;
            this.fitToContents = ((COUIGuideBehavior) cOUIGuideBehavior).f6679r;
            this.hideable = cOUIGuideBehavior.f6668g;
            this.skipCollapsed = ((COUIGuideBehavior) cOUIGuideBehavior).f6648F;
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
        this.f6680s = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6661a(boolean z) {
        Map<View, Integer> map;
        WeakReference<V> weakReference = this.f6673l;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (Build.VERSION.SDK_INT >= 16 && z) {
                if (this.f6657O != null) {
                    return;
                } else {
                    this.f6657O = new HashMap(childCount);
                }
            }
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
                View childAt = coordinatorLayout.getChildAt(OplusGLSurfaceView_13);
                if (childAt != this.f6673l.get()) {
                    if (z) {
                        if (Build.VERSION.SDK_INT >= 16) {
                            this.f6657O.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        }
                        if (this.f6680s) {
                            ViewCompat.m2867b(childAt, 4);
                        }
                    } else if (this.f6680s && (map = this.f6657O) != null && map.containsKey(childAt)) {
                        ViewCompat.m2867b(childAt, this.f6657O.get(childAt).intValue());
                    }
                }
            }
            if (z) {
                return;
            }
            this.f6657O = null;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m6675g() {
        V v;
        WeakReference<V> weakReference = this.f6673l;
        if (weakReference == null || (v = weakReference.get()) == null) {
            return;
        }
        ViewCompat.m2874c((View) v, STMobileHumanActionNative.ST_MOBILE_ENABLE_INPUT_CUSTOM);
        ViewCompat.m2874c((View) v, STMobileHumanActionNative.ST_MOBILE_DETECT_MODE_IMAGE);
        ViewCompat.m2874c((View) v, ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES);
        if (this.f6668g && this.f6669h != 5) {
            m6658a((COUIGuideBehavior<V>) v, AccessibilityNodeInfoCompat.PlatformImplementations.kt_3.f3034u, 5);
        }
        int OplusGLSurfaceView_13 = this.f6669h;
        if (OplusGLSurfaceView_13 == 3) {
            m6658a((COUIGuideBehavior<V>) v, AccessibilityNodeInfoCompat.PlatformImplementations.kt_3.f3033t, this.f6679r ? 4 : 6);
            return;
        }
        if (OplusGLSurfaceView_13 == 4) {
            m6658a((COUIGuideBehavior<V>) v, AccessibilityNodeInfoCompat.PlatformImplementations.kt_3.f3032s, this.f6679r ? 3 : 6);
        } else {
            if (OplusGLSurfaceView_13 != 6) {
                return;
            }
            m6658a((COUIGuideBehavior<V>) v, AccessibilityNodeInfoCompat.PlatformImplementations.kt_3.f3033t, 4);
            m6658a((COUIGuideBehavior<V>) v, AccessibilityNodeInfoCompat.PlatformImplementations.kt_3.f3032s, 3);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6658a(V v, AccessibilityNodeInfoCompat.PlatformImplementations.kt_3 aVar, final int OplusGLSurfaceView_13) {
        ViewCompat.m2852a(v, aVar, null, new AccessibilityViewCommand() { // from class: com.coui.appcompat.dialog.panel.COUIGuideBehavior.4
            @Override // androidx.core.p036h.p037a.AccessibilityViewCommand
            public boolean perform(View view, AccessibilityViewCommand.PlatformImplementations.kt_3 aVar2) {
                COUIGuideBehavior.this.setState(OplusGLSurfaceView_13);
                return true;
            }
        });
    }
}
