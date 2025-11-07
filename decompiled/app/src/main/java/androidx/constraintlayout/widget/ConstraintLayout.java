package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.p025a.Metrics;
import androidx.constraintlayout.p025a.p026a.ConstraintAnchor;
import androidx.constraintlayout.p025a.p026a.ConstraintWidget;
import androidx.constraintlayout.p025a.p026a.ConstraintWidgetContainer;
import androidx.constraintlayout.p025a.p026a.Guideline;
import com.oplus.exif.OplusExifInterface;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {

    /* renamed from: PlatformImplementations.kt_3 */
    SparseArray<View> f2433a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    ConstraintWidgetContainer f2434b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    int f2435c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    int f2436d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    int f2437e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    int f2438f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private ArrayList<ConstraintHelper> f2439g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final ArrayList<ConstraintWidget> f2440h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f2441i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f2442j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f2443k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f2444l;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f2445m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f2446n;

    /* renamed from: o */
    private ConstraintSet f2447o;

    /* renamed from: p */
    private int f2448p;

    /* renamed from: q */
    private HashMap<String, Integer> f2449q;

    /* renamed from: r */
    private int f2450r;

    /* renamed from: s */
    private int f2451s;

    /* renamed from: t */
    private Metrics f2452t;

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m2173a(int OplusGLSurfaceView_13, Object obj, Object obj2) {
        if (OplusGLSurfaceView_13 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.f2449q == null) {
                this.f2449q = new HashMap<>();
            }
            String strSubstring = (String) obj;
            int iIndexOf = strSubstring.indexOf("/");
            if (iIndexOf != -1) {
                strSubstring = strSubstring.substring(iIndexOf + 1);
            }
            this.f2449q.put(strSubstring, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Object m2172a(int OplusGLSurfaceView_13, Object obj) {
        if (OplusGLSurfaceView_13 != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> map = this.f2449q;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.f2449q.get(str);
    }

    public ConstraintLayout(Context context) throws XmlPullParserException, IOException {
        super(context);
        this.f2433a = new SparseArray<>();
        this.f2439g = new ArrayList<>(4);
        this.f2440h = new ArrayList<>(100);
        this.f2434b = new ConstraintWidgetContainer();
        this.f2441i = 0;
        this.f2442j = 0;
        this.f2443k = Integer.MAX_VALUE;
        this.f2444l = Integer.MAX_VALUE;
        this.f2445m = true;
        this.f2446n = 7;
        this.f2447o = null;
        this.f2448p = -1;
        this.f2449q = new HashMap<>();
        this.f2450r = -1;
        this.f2451s = -1;
        this.f2435c = -1;
        this.f2436d = -1;
        this.f2437e = 0;
        this.f2438f = 0;
        m2164b((AttributeSet) null);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        super(context, attributeSet);
        this.f2433a = new SparseArray<>();
        this.f2439g = new ArrayList<>(4);
        this.f2440h = new ArrayList<>(100);
        this.f2434b = new ConstraintWidgetContainer();
        this.f2441i = 0;
        this.f2442j = 0;
        this.f2443k = Integer.MAX_VALUE;
        this.f2444l = Integer.MAX_VALUE;
        this.f2445m = true;
        this.f2446n = 7;
        this.f2447o = null;
        this.f2448p = -1;
        this.f2449q = new HashMap<>();
        this.f2450r = -1;
        this.f2451s = -1;
        this.f2435c = -1;
        this.f2436d = -1;
        this.f2437e = 0;
        this.f2438f = 0;
        m2164b(attributeSet);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) throws XmlPullParserException, IOException {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f2433a = new SparseArray<>();
        this.f2439g = new ArrayList<>(4);
        this.f2440h = new ArrayList<>(100);
        this.f2434b = new ConstraintWidgetContainer();
        this.f2441i = 0;
        this.f2442j = 0;
        this.f2443k = Integer.MAX_VALUE;
        this.f2444l = Integer.MAX_VALUE;
        this.f2445m = true;
        this.f2446n = 7;
        this.f2447o = null;
        this.f2448p = -1;
        this.f2449q = new HashMap<>();
        this.f2450r = -1;
        this.f2451s = -1;
        this.f2435c = -1;
        this.f2436d = -1;
        this.f2437e = 0;
        this.f2438f = 0;
        m2164b(attributeSet);
    }

    @Override // android.view.View
    public void setId(int OplusGLSurfaceView_13) {
        this.f2433a.remove(getId());
        super.setId(OplusGLSurfaceView_13);
        this.f2433a.put(getId(), this);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m2164b(AttributeSet attributeSet) throws XmlPullParserException, IOException {
        this.f2434b.m1970a(this);
        this.f2433a.put(getId(), this);
        this.f2447o = null;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < indexCount; OplusGLSurfaceView_13++) {
                int index = typedArrayObtainStyledAttributes.getIndex(OplusGLSurfaceView_13);
                if (index == R.styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.f2441i = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f2441i);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.f2442j = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f2442j);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.f2443k = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f2443k);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.f2444l = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f2444l);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.f2446n = typedArrayObtainStyledAttributes.getInt(index, this.f2446n);
                } else if (index == R.styleable.ConstraintLayout_Layout_constraintSet) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    try {
                        this.f2447o = new ConstraintSet();
                        this.f2447o.m2191a(getContext(), resourceId);
                    } catch (Resources.NotFoundException unused) {
                        this.f2447o = null;
                    }
                    this.f2448p = resourceId;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f2434b.m2039a(this.f2446n);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int OplusGLSurfaceView_13, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, OplusGLSurfaceView_13, layoutParams);
        if (Build.VERSION.SDK_INT < 14) {
            onViewAdded(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
        if (Build.VERSION.SDK_INT < 14) {
            onViewRemoved(view);
        }
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewAdded(view);
        }
        ConstraintWidget c0379fM2169a = m2169a(view);
        if ((view instanceof Guideline_2) && !(c0379fM2169a instanceof Guideline)) {
            C0398a c0398a = (C0398a) view.getLayoutParams();
            c0398a.f2491al = new Guideline();
            c0398a.f2477Y = true;
            ((Guideline) c0398a.f2491al).m2054a(c0398a.f2471S);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper abstractC0400b = (ConstraintHelper) view;
            abstractC0400b.m2180b();
            ((C0398a) view.getLayoutParams()).f2478Z = true;
            if (!this.f2439g.contains(abstractC0400b)) {
                this.f2439g.add(abstractC0400b);
            }
        }
        this.f2433a.put(view.getId(), view);
        this.f2445m = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onViewRemoved(view);
        }
        this.f2433a.remove(view.getId());
        ConstraintWidget c0379fM2169a = m2169a(view);
        this.f2434b.m2092c(c0379fM2169a);
        this.f2439g.remove(view);
        this.f2440h.remove(c0379fM2169a);
        this.f2445m = true;
    }

    public void setMinWidth(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == this.f2441i) {
            return;
        }
        this.f2441i = OplusGLSurfaceView_13;
        requestLayout();
    }

    public void setMinHeight(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == this.f2442j) {
            return;
        }
        this.f2442j = OplusGLSurfaceView_13;
        requestLayout();
    }

    public int getMinWidth() {
        return this.f2441i;
    }

    public int getMinHeight() {
        return this.f2442j;
    }

    public void setMaxWidth(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == this.f2443k) {
            return;
        }
        this.f2443k = OplusGLSurfaceView_13;
        requestLayout();
    }

    public void setMaxHeight(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == this.f2444l) {
            return;
        }
        this.f2444l = OplusGLSurfaceView_13;
        requestLayout();
    }

    public int getMaxWidth() {
        return this.f2443k;
    }

    public int getMaxHeight() {
        return this.f2444l;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m2162b() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        int childCount = getChildCount();
        boolean z = false;
        int OplusGLSurfaceView_13 = 0;
        while (true) {
            if (OplusGLSurfaceView_13 >= childCount) {
                break;
            }
            if (getChildAt(OplusGLSurfaceView_13).isLayoutRequested()) {
                z = true;
                break;
            }
            OplusGLSurfaceView_13++;
        }
        if (z) {
            this.f2440h.clear();
            m2165c();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r26v0, types: [androidx.constraintlayout.widget.ConstraintLayout] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v39 */
    /* JADX WARN: Type inference failed for: r3v40 */
    /* JADX WARN: Type inference failed for: r3v43 */
    /* JADX WARN: Type inference failed for: r3v49 */
    /* JADX WARN: Type inference failed for: r3v67 */
    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m2165c() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        int OplusGLSurfaceView_13;
        int i2;
        int i3;
        float COUIBaseListPopupWindow_12;
        int i4;
        ConstraintWidget c0379fM2161b;
        ConstraintWidget c0379fM2161b2;
        ConstraintWidget c0379fM2161b3;
        ConstraintWidget c0379fM2161b4;
        int i5;
        boolean zIsInEditMode = isInEditMode();
        int childCount = getChildCount();
        ?? r3 = 0;
        if (zIsInEditMode) {
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    m2173a(0, resourceName, Integer.valueOf(childAt.getId()));
                    int iIndexOf = resourceName.indexOf(47);
                    if (iIndexOf != -1) {
                        resourceName = resourceName.substring(iIndexOf + 1);
                    }
                    m2161b(childAt.getId()).m1971a(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        for (int i7 = 0; i7 < childCount; i7++) {
            ConstraintWidget c0379fM2169a = m2169a(getChildAt(i7));
            if (c0379fM2169a != null) {
                c0379fM2169a.mo1994g();
            }
        }
        if (this.f2448p != -1) {
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt2 = getChildAt(i8);
                if (childAt2.getId() == this.f2448p && (childAt2 instanceof Constraints)) {
                    this.f2447o = ((Constraints) childAt2).getConstraintSet();
                }
            }
        }
        ConstraintSet c0401c = this.f2447o;
        if (c0401c != null) {
            c0401c.m2196c(this);
        }
        this.f2434b.m2090U();
        int size = this.f2439g.size();
        if (size > 0) {
            for (int i9 = 0; i9 < size; i9++) {
                this.f2439g.get(i9).m2179a((ConstraintLayout) this);
            }
        }
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt3 = getChildAt(i10);
            if (childAt3 instanceof Placeholder) {
                ((Placeholder) childAt3).m2207a(this);
            }
        }
        int i11 = 0;
        while (i11 < childCount) {
            View childAt4 = getChildAt(i11);
            ConstraintWidget c0379fM2169a2 = m2169a(childAt4);
            if (c0379fM2169a2 != null) {
                C0398a c0398a = (C0398a) childAt4.getLayoutParams();
                c0398a.m2175a();
                if (c0398a.f2492am) {
                    c0398a.f2492am = r3;
                } else if (zIsInEditMode) {
                    try {
                        String resourceName2 = getResources().getResourceName(childAt4.getId());
                        m2173a(r3, resourceName2, Integer.valueOf(childAt4.getId()));
                        m2161b(childAt4.getId()).m1971a(resourceName2.substring(resourceName2.indexOf("id_renamed/") + 3));
                    } catch (Resources.NotFoundException unused2) {
                    }
                }
                c0379fM2169a2.m1988e(childAt4.getVisibility());
                if (c0398a.f2480aa) {
                    c0379fM2169a2.m1988e(8);
                }
                c0379fM2169a2.m1970a(childAt4);
                this.f2434b.m2091b(c0379fM2169a2);
                if (!c0398a.f2475W || !c0398a.f2474V) {
                    this.f2440h.add(c0379fM2169a2);
                }
                if (c0398a.f2477Y) {
                    Guideline c0382i = (Guideline) c0379fM2169a2;
                    int i12 = c0398a.f2488ai;
                    int i13 = c0398a.f2489aj;
                    float f2 = c0398a.f2490ak;
                    if (Build.VERSION.SDK_INT < 17) {
                        i12 = c0398a.f2479a;
                        i13 = c0398a.f2493b;
                        f2 = c0398a.f2494c;
                    }
                    if (f2 != -1.0f) {
                        c0382i.m2056e(f2);
                    } else if (i12 != -1) {
                        c0382i.m2057u(i12);
                    } else if (i13 != -1) {
                        c0382i.m2058v(i13);
                    }
                } else if (c0398a.f2495d != -1 || c0398a.f2496e != -1 || c0398a.f2497f != -1 || c0398a.f2498g != -1 || c0398a.f2508q != -1 || c0398a.f2507p != -1 || c0398a.f2509r != -1 || c0398a.f2510s != -1 || c0398a.f2499h != -1 || c0398a.f2500i != -1 || c0398a.f2501j != -1 || c0398a.f2502k != -1 || c0398a.f2503l != -1 || c0398a.f2469Q != -1 || c0398a.f2470R != -1 || c0398a.f2504m != -1 || c0398a.width == -1 || c0398a.height == -1) {
                    int i14 = c0398a.f2481ab;
                    int i15 = c0398a.f2482ac;
                    int i16 = c0398a.f2483ad;
                    int i17 = c0398a.f2484ae;
                    int i18 = c0398a.f2485af;
                    int i19 = c0398a.f2486ag;
                    float f3 = c0398a.f2487ah;
                    if (Build.VERSION.SDK_INT < 17) {
                        int i20 = c0398a.f2495d;
                        int i21 = c0398a.f2496e;
                        i16 = c0398a.f2497f;
                        i17 = c0398a.f2498g;
                        int i22 = c0398a.f2511t;
                        int i23 = c0398a.f2513v;
                        f3 = c0398a.f2517z;
                        if (i20 == -1 && i21 == -1) {
                            if (c0398a.f2508q != -1) {
                                i20 = c0398a.f2508q;
                            } else if (c0398a.f2507p != -1) {
                                i21 = c0398a.f2507p;
                            }
                        }
                        int i24 = i21;
                        i14 = i20;
                        OplusGLSurfaceView_13 = i24;
                        if (i16 == -1 && i17 == -1) {
                            if (c0398a.f2509r != -1) {
                                i16 = c0398a.f2509r;
                            } else if (c0398a.f2510s != -1) {
                                i17 = c0398a.f2510s;
                            }
                        }
                        i3 = i22;
                        i2 = i23;
                    } else {
                        OplusGLSurfaceView_13 = i15;
                        i2 = i19;
                        i3 = i18;
                    }
                    int i25 = i17;
                    float f4 = f3;
                    int i26 = i16;
                    if (c0398a.f2504m != -1) {
                        ConstraintWidget c0379fM2161b5 = m2161b(c0398a.f2504m);
                        if (c0379fM2161b5 != null) {
                            c0379fM2169a2.m1968a(c0379fM2161b5, c0398a.f2506o, c0398a.f2505n);
                        }
                    } else {
                        if (i14 != -1) {
                            ConstraintWidget c0379fM2161b6 = m2161b(i14);
                            if (c0379fM2161b6 != null) {
                                COUIBaseListPopupWindow_12 = f4;
                                i5 = i25;
                                c0379fM2169a2.m1965a(ConstraintAnchor.IntrinsicsJvm.kt_3.LEFT, c0379fM2161b6, ConstraintAnchor.IntrinsicsJvm.kt_3.LEFT, c0398a.leftMargin, i3);
                            } else {
                                COUIBaseListPopupWindow_12 = f4;
                                i5 = i25;
                            }
                            i4 = i5;
                        } else {
                            COUIBaseListPopupWindow_12 = f4;
                            i4 = i25;
                            if (OplusGLSurfaceView_13 != -1 && (c0379fM2161b = m2161b(OplusGLSurfaceView_13)) != null) {
                                c0379fM2169a2.m1965a(ConstraintAnchor.IntrinsicsJvm.kt_3.LEFT, c0379fM2161b, ConstraintAnchor.IntrinsicsJvm.kt_3.RIGHT, c0398a.leftMargin, i3);
                            }
                        }
                        if (i26 != -1) {
                            ConstraintWidget c0379fM2161b7 = m2161b(i26);
                            if (c0379fM2161b7 != null) {
                                c0379fM2169a2.m1965a(ConstraintAnchor.IntrinsicsJvm.kt_3.RIGHT, c0379fM2161b7, ConstraintAnchor.IntrinsicsJvm.kt_3.LEFT, c0398a.rightMargin, i2);
                            }
                        } else if (i4 != -1 && (c0379fM2161b2 = m2161b(i4)) != null) {
                            c0379fM2169a2.m1965a(ConstraintAnchor.IntrinsicsJvm.kt_3.RIGHT, c0379fM2161b2, ConstraintAnchor.IntrinsicsJvm.kt_3.RIGHT, c0398a.rightMargin, i2);
                        }
                        if (c0398a.f2499h != -1) {
                            ConstraintWidget c0379fM2161b8 = m2161b(c0398a.f2499h);
                            if (c0379fM2161b8 != null) {
                                c0379fM2169a2.m1965a(ConstraintAnchor.IntrinsicsJvm.kt_3.TOP, c0379fM2161b8, ConstraintAnchor.IntrinsicsJvm.kt_3.TOP, c0398a.topMargin, c0398a.f2512u);
                            }
                        } else if (c0398a.f2500i != -1 && (c0379fM2161b3 = m2161b(c0398a.f2500i)) != null) {
                            c0379fM2169a2.m1965a(ConstraintAnchor.IntrinsicsJvm.kt_3.TOP, c0379fM2161b3, ConstraintAnchor.IntrinsicsJvm.kt_3.BOTTOM, c0398a.topMargin, c0398a.f2512u);
                        }
                        if (c0398a.f2501j != -1) {
                            ConstraintWidget c0379fM2161b9 = m2161b(c0398a.f2501j);
                            if (c0379fM2161b9 != null) {
                                c0379fM2169a2.m1965a(ConstraintAnchor.IntrinsicsJvm.kt_3.BOTTOM, c0379fM2161b9, ConstraintAnchor.IntrinsicsJvm.kt_3.TOP, c0398a.bottomMargin, c0398a.f2514w);
                            }
                        } else if (c0398a.f2502k != -1 && (c0379fM2161b4 = m2161b(c0398a.f2502k)) != null) {
                            c0379fM2169a2.m1965a(ConstraintAnchor.IntrinsicsJvm.kt_3.BOTTOM, c0379fM2161b4, ConstraintAnchor.IntrinsicsJvm.kt_3.BOTTOM, c0398a.bottomMargin, c0398a.f2514w);
                        }
                        if (c0398a.f2503l != -1) {
                            View view = this.f2433a.get(c0398a.f2503l);
                            ConstraintWidget c0379fM2161b10 = m2161b(c0398a.f2503l);
                            if (c0379fM2161b10 != null && view != null && (view.getLayoutParams() instanceof C0398a)) {
                                C0398a c0398a2 = (C0398a) view.getLayoutParams();
                                c0398a.f2476X = true;
                                c0398a2.f2476X = true;
                                c0379fM2169a2.mo1959a(ConstraintAnchor.IntrinsicsJvm.kt_3.BASELINE).m1935a(c0379fM2161b10.mo1959a(ConstraintAnchor.IntrinsicsJvm.kt_3.BASELINE), 0, -1, ConstraintAnchor.IntrinsicsJvm.kt_4.STRONG, 0, true);
                                c0379fM2169a2.mo1959a(ConstraintAnchor.IntrinsicsJvm.kt_3.TOP).m1944i();
                                c0379fM2169a2.mo1959a(ConstraintAnchor.IntrinsicsJvm.kt_3.BOTTOM).m1944i();
                            }
                        }
                        float f5 = COUIBaseListPopupWindow_12;
                        if (f5 >= 0.0f && f5 != 0.5f) {
                            c0379fM2169a2.m1960a(f5);
                        }
                        if (c0398a.f2453A >= 0.0f && c0398a.f2453A != 0.5f) {
                            c0379fM2169a2.m1973b(c0398a.f2453A);
                        }
                    }
                    if (zIsInEditMode && (c0398a.f2469Q != -1 || c0398a.f2470R != -1)) {
                        c0379fM2169a2.m1961a(c0398a.f2469Q, c0398a.f2470R);
                    }
                    if (!c0398a.f2474V) {
                        if (c0398a.width == -1) {
                            c0379fM2169a2.m1966a(ConstraintWidget.PlatformImplementations.kt_3.MATCH_PARENT);
                            c0379fM2169a2.mo1959a(ConstraintAnchor.IntrinsicsJvm.kt_3.LEFT).f2204d = c0398a.leftMargin;
                            c0379fM2169a2.mo1959a(ConstraintAnchor.IntrinsicsJvm.kt_3.RIGHT).f2204d = c0398a.rightMargin;
                        } else {
                            c0379fM2169a2.m1966a(ConstraintWidget.PlatformImplementations.kt_3.MATCH_CONSTRAINT);
                            c0379fM2169a2.m2000j(0);
                        }
                    } else {
                        c0379fM2169a2.m1966a(ConstraintWidget.PlatformImplementations.kt_3.FIXED);
                        c0379fM2169a2.m2000j(c0398a.width);
                    }
                    if (!c0398a.f2475W) {
                        if (c0398a.height == -1) {
                            c0379fM2169a2.m1976b(ConstraintWidget.PlatformImplementations.kt_3.MATCH_PARENT);
                            c0379fM2169a2.mo1959a(ConstraintAnchor.IntrinsicsJvm.kt_3.TOP).f2204d = c0398a.topMargin;
                            c0379fM2169a2.mo1959a(ConstraintAnchor.IntrinsicsJvm.kt_3.BOTTOM).f2204d = c0398a.bottomMargin;
                            r3 = 0;
                        } else {
                            c0379fM2169a2.m1976b(ConstraintWidget.PlatformImplementations.kt_3.MATCH_CONSTRAINT);
                            r3 = 0;
                            c0379fM2169a2.m2002k(0);
                        }
                    } else {
                        r3 = 0;
                        c0379fM2169a2.m1976b(ConstraintWidget.PlatformImplementations.kt_3.FIXED);
                        c0379fM2169a2.m2002k(c0398a.height);
                    }
                    if (c0398a.f2454B != null) {
                        c0379fM2169a2.m1978b(c0398a.f2454B);
                    }
                    c0379fM2169a2.m1980c(c0398a.f2457E);
                    c0379fM2169a2.m1985d(c0398a.f2458F);
                    c0379fM2169a2.m2016r(c0398a.f2459G);
                    c0379fM2169a2.m2018s(c0398a.f2460H);
                    c0379fM2169a2.m1963a(c0398a.f2461I, c0398a.f2463K, c0398a.f2465M, c0398a.f2467O);
                    c0379fM2169a2.m1975b(c0398a.f2462J, c0398a.f2464L, c0398a.f2466N, c0398a.f2468P);
                }
            }
            i11++;
            r3 = r3;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final ConstraintWidget m2161b(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            return this.f2434b;
        }
        View viewFindViewById = this.f2433a.get(OplusGLSurfaceView_13);
        if (viewFindViewById == null && (viewFindViewById = findViewById(OplusGLSurfaceView_13)) != null && viewFindViewById != this && viewFindViewById.getParent() == this) {
            onViewAdded(viewFindViewById);
        }
        if (viewFindViewById == this) {
            return this.f2434b;
        }
        if (viewFindViewById == null) {
            return null;
        }
        return ((C0398a) viewFindViewById.getLayoutParams()).f2491al;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final ConstraintWidget m2169a(View view) {
        if (view == this) {
            return this.f2434b;
        }
        if (view == null) {
            return null;
        }
        return ((C0398a) view.getLayoutParams()).f2491al;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m2160a(int OplusGLSurfaceView_13, int i2) {
        boolean z;
        boolean z2;
        int baseline;
        int childMeasureSpec;
        int childMeasureSpec2;
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                C0398a c0398a = (C0398a) childAt.getLayoutParams();
                ConstraintWidget c0379f = c0398a.f2491al;
                if (!c0398a.f2477Y && !c0398a.f2478Z) {
                    c0379f.m1988e(childAt.getVisibility());
                    int measuredWidth = c0398a.width;
                    int measuredHeight = c0398a.height;
                    if (c0398a.f2474V || c0398a.f2475W || (!c0398a.f2474V && c0398a.f2461I == 1) || c0398a.width == -1 || (!c0398a.f2475W && (c0398a.f2462J == 1 || c0398a.height == -1))) {
                        if (measuredWidth == 0) {
                            childMeasureSpec = getChildMeasureSpec(OplusGLSurfaceView_13, paddingLeft, -2);
                            z = true;
                        } else if (measuredWidth == -1) {
                            childMeasureSpec = getChildMeasureSpec(OplusGLSurfaceView_13, paddingLeft, -1);
                            z = false;
                        } else {
                            z = measuredWidth == -2;
                            childMeasureSpec = getChildMeasureSpec(OplusGLSurfaceView_13, paddingLeft, measuredWidth);
                        }
                        if (measuredHeight == 0) {
                            z2 = true;
                            childMeasureSpec2 = getChildMeasureSpec(i2, paddingTop, -2);
                        } else if (measuredHeight == -1) {
                            childMeasureSpec2 = getChildMeasureSpec(i2, paddingTop, -1);
                            z2 = false;
                        } else {
                            z2 = measuredHeight == -2;
                            childMeasureSpec2 = getChildMeasureSpec(i2, paddingTop, measuredHeight);
                        }
                        childAt.measure(childMeasureSpec, childMeasureSpec2);
                        Metrics c0395f = this.f2452t;
                        if (c0395f != null) {
                            c0395f.f2390a++;
                        }
                        c0379f.m1979b(measuredWidth == -2);
                        c0379f.m1984c(measuredHeight == -2);
                        measuredWidth = childAt.getMeasuredWidth();
                        measuredHeight = childAt.getMeasuredHeight();
                    } else {
                        z = false;
                        z2 = false;
                    }
                    c0379f.m2000j(measuredWidth);
                    c0379f.m2002k(measuredHeight);
                    if (z) {
                        c0379f.m2008n(measuredWidth);
                    }
                    if (z2) {
                        c0379f.m2010o(measuredHeight);
                    }
                    if (c0398a.f2476X && (baseline = childAt.getBaseline()) != -1) {
                        c0379f.m2014q(baseline);
                    }
                }
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m2167d() {
        int childCount = getChildCount();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            View childAt = getChildAt(OplusGLSurfaceView_13);
            if (childAt instanceof Placeholder) {
                ((Placeholder) childAt).m2208b(this);
            }
        }
        int size = this.f2439g.size();
        if (size > 0) {
            for (int i2 = 0; i2 < size; i2++) {
                this.f2439g.get(i2).m2182c(this);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02cc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d6  */
    /* renamed from: IntrinsicsJvm.kt_4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m2163b(int r24, int r25) {
        /*
            Method dump skipped, instructions count: 739
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.m2163b(int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0133 A[PHI: r10
      0x0133: PHI (r10v3 boolean) = (r10v2 boolean), (r10v26 boolean), (r10v26 boolean) binds: [B:41:0x00de, B:57:0x0122, B:59:0x0128] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r25, int r26) throws java.lang.IllegalAccessException, android.content.res.Resources.NotFoundException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 967
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.onMeasure(int, int):void");
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m2166c(int OplusGLSurfaceView_13, int i2) {
        int mode = View.MeasureSpec.getMode(OplusGLSurfaceView_13);
        int size = View.MeasureSpec.getSize(OplusGLSurfaceView_13);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        ConstraintWidget.PlatformImplementations.kt_3 aVar = ConstraintWidget.PlatformImplementations.kt_3.FIXED;
        ConstraintWidget.PlatformImplementations.kt_3 aVar2 = ConstraintWidget.PlatformImplementations.kt_3.FIXED;
        getLayoutParams();
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                aVar = ConstraintWidget.PlatformImplementations.kt_3.WRAP_CONTENT;
            } else if (mode == 1073741824) {
                size = Math.min(this.f2443k, size) - paddingLeft;
            }
            size = 0;
        } else {
            aVar = ConstraintWidget.PlatformImplementations.kt_3.WRAP_CONTENT;
        }
        if (mode2 != Integer.MIN_VALUE) {
            if (mode2 == 0) {
                aVar2 = ConstraintWidget.PlatformImplementations.kt_3.WRAP_CONTENT;
            } else if (mode2 == 1073741824) {
                size2 = Math.min(this.f2444l, size2) - paddingTop;
            }
            size2 = 0;
        } else {
            aVar2 = ConstraintWidget.PlatformImplementations.kt_3.WRAP_CONTENT;
        }
        this.f2434b.m2004l(0);
        this.f2434b.m2006m(0);
        this.f2434b.m1966a(aVar);
        this.f2434b.m2000j(size);
        this.f2434b.m1976b(aVar2);
        this.f2434b.m2002k(size2);
        this.f2434b.m2004l((this.f2441i - getPaddingLeft()) - getPaddingRight());
        this.f2434b.m2006m((this.f2442j - getPaddingTop()) - getPaddingBottom());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m2174a(String str) {
        this.f2434b.mo2033N();
        Metrics c0395f = this.f2452t;
        if (c0395f != null) {
            c0395f.f2392c++;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        View content;
        int childCount = getChildCount();
        boolean zIsInEditMode = isInEditMode();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            C0398a c0398a = (C0398a) childAt.getLayoutParams();
            ConstraintWidget c0379f = c0398a.f2491al;
            if ((childAt.getVisibility() != 8 || c0398a.f2477Y || c0398a.f2478Z || zIsInEditMode) && !c0398a.f2480aa) {
                int iM2021u = c0379f.m2021u();
                int iM2022v = c0379f.m2022v();
                int iM2013q = c0379f.m2013q() + iM2021u;
                int iM2017s = c0379f.m2017s() + iM2022v;
                childAt.layout(iM2021u, iM2022v, iM2013q, iM2017s);
                if ((childAt instanceof Placeholder) && (content = ((Placeholder) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(iM2021u, iM2022v, iM2013q, iM2017s);
                }
            }
        }
        int size = this.f2439g.size();
        if (size > 0) {
            for (int i6 = 0; i6 < size; i6++) {
                this.f2439g.get(i6).m2181b(this);
            }
        }
    }

    public void setOptimizationLevel(int OplusGLSurfaceView_13) {
        this.f2434b.m2039a(OplusGLSurfaceView_13);
    }

    public int getOptimizationLevel() {
        return this.f2434b.m2043b();
    }

    @Override // android.view.ViewGroup
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public C0398a generateLayoutParams(AttributeSet attributeSet) {
        return new C0398a(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public C0398a generateDefaultLayoutParams() {
        return new C0398a(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new C0398a(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0398a;
    }

    public void setConstraintSet(ConstraintSet c0401c) {
        this.f2447o = c0401c;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public View m2168a(int OplusGLSurfaceView_13) {
        return this.f2433a.get(OplusGLSurfaceView_13);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) throws NumberFormatException {
        Object tag;
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = getWidth();
            float height = getHeight();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
                View childAt = getChildAt(OplusGLSurfaceView_13);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] strArrSplit = ((String) tag).split(",");
                    if (strArrSplit.length == 4) {
                        int i2 = Integer.parseInt(strArrSplit[0]);
                        int i3 = Integer.parseInt(strArrSplit[1]);
                        int i4 = Integer.parseInt(strArrSplit[2]);
                        int i5 = (int) ((i2 / 1080.0f) * width);
                        int i6 = (int) ((i3 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float COUIBaseListPopupWindow_12 = i5;
                        float f2 = i6;
                        float f3 = i5 + ((int) ((i4 / 1080.0f) * width));
                        canvas.drawLine(COUIBaseListPopupWindow_12, f2, f3, f2, paint);
                        float f4 = i6 + ((int) ((Integer.parseInt(strArrSplit[3]) / 1920.0f) * height));
                        canvas.drawLine(f3, f2, f3, f4, paint);
                        canvas.drawLine(f3, f4, COUIBaseListPopupWindow_12, f4, paint);
                        canvas.drawLine(COUIBaseListPopupWindow_12, f4, COUIBaseListPopupWindow_12, f2, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(COUIBaseListPopupWindow_12, f2, f3, f4, paint);
                        canvas.drawLine(COUIBaseListPopupWindow_12, f4, f3, f2, paint);
                    }
                }
            }
        }
    }

    /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$PlatformImplementations.kt_3 */
    public static class C0398a extends ViewGroup.MarginLayoutParams {

        /* renamed from: A */
        public float f2453A;

        /* renamed from: B */
        public String f2454B;

        /* renamed from: C */
        float f2455C;

        /* renamed from: D */
        int f2456D;

        /* renamed from: E */
        public float f2457E;

        /* renamed from: F */
        public float f2458F;

        /* renamed from: G */
        public int f2459G;

        /* renamed from: H */
        public int f2460H;

        /* renamed from: I */
        public int f2461I;

        /* renamed from: J */
        public int f2462J;

        /* renamed from: K */
        public int f2463K;

        /* renamed from: L */
        public int f2464L;

        /* renamed from: M */
        public int f2465M;

        /* renamed from: N */
        public int f2466N;

        /* renamed from: O */
        public float f2467O;

        /* renamed from: P */
        public float f2468P;

        /* renamed from: Q */
        public int f2469Q;

        /* renamed from: R */
        public int f2470R;

        /* renamed from: S */
        public int f2471S;

        /* renamed from: T */
        public boolean f2472T;

        /* renamed from: U */
        public boolean f2473U;

        /* renamed from: V */
        boolean f2474V;

        /* renamed from: W */
        boolean f2475W;

        /* renamed from: X */
        boolean f2476X;

        /* renamed from: Y */
        boolean f2477Y;

        /* renamed from: Z */
        boolean f2478Z;

        /* renamed from: PlatformImplementations.kt_3 */
        public int f2479a;

        /* renamed from: aa */
        boolean f2480aa;

        /* renamed from: ab */
        int f2481ab;

        /* renamed from: ac */
        int f2482ac;

        /* renamed from: ad */
        int f2483ad;

        /* renamed from: ae */
        int f2484ae;

        /* renamed from: af */
        int f2485af;

        /* renamed from: ag */
        int f2486ag;

        /* renamed from: ah */
        float f2487ah;

        /* renamed from: ai */
        int f2488ai;

        /* renamed from: aj */
        int f2489aj;

        /* renamed from: ak */
        float f2490ak;

        /* renamed from: al */
        ConstraintWidget f2491al;

        /* renamed from: am */
        public boolean f2492am;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public int f2493b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public float f2494c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public int f2495d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        public int f2496e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        public int f2497f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        public int f2498g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        public int f2499h;

        /* renamed from: OplusGLSurfaceView_13 */
        public int f2500i;

        /* renamed from: OplusGLSurfaceView_15 */
        public int f2501j;

        /* renamed from: OplusGLSurfaceView_5 */
        public int f2502k;

        /* renamed from: OplusGLSurfaceView_14 */
        public int f2503l;

        /* renamed from: OplusGLSurfaceView_6 */
        public int f2504m;

        /* renamed from: OplusGLSurfaceView_11 */
        public int f2505n;

        /* renamed from: o */
        public float f2506o;

        /* renamed from: p */
        public int f2507p;

        /* renamed from: q */
        public int f2508q;

        /* renamed from: r */
        public int f2509r;

        /* renamed from: s */
        public int f2510s;

        /* renamed from: t */
        public int f2511t;

        /* renamed from: u */
        public int f2512u;

        /* renamed from: v */
        public int f2513v;

        /* renamed from: w */
        public int f2514w;

        /* renamed from: x */
        public int f2515x;

        /* renamed from: y */
        public int f2516y;

        /* renamed from: z */
        public float f2517z;

        /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
        private static class PlatformImplementations.kt_3 {

            /* renamed from: PlatformImplementations.kt_3 */
            public static final SparseIntArray f2518a = new SparseIntArray();

            static {
                f2518a.append(R.styleable.f2539xfcfe33bc, 8);
                f2518a.append(R.styleable.f2540xe70a3555, 9);
                f2518a.append(R.styleable.f2542xad8c6ed1, 10);
                f2518a.append(R.styleable.f2543x48435ce0, 11);
                f2518a.append(R.styleable.f2548x47bdb612, 12);
                f2518a.append(R.styleable.f2547x50f4139c, 13);
                f2518a.append(R.styleable.f2523x99a32fb2, 14);
                f2518a.append(R.styleable.f2522xb038b5fc, 15);
                f2518a.append(R.styleable.f2520x767f147c, 16);
                f2518a.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
                f2518a.append(R.styleable.f2525x9539bc37, 3);
                f2518a.append(R.styleable.f2524xb994208e, 4);
                f2518a.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                f2518a.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                f2518a.append(R.styleable.f2529x3755bc51, 5);
                f2518a.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                f2518a.append(R.styleable.f2530x9e075ded, 7);
                f2518a.append(R.styleable.ConstraintLayout_Layout_android_orientation, 1);
                f2518a.append(R.styleable.f2544xb8f5b65, 17);
                f2518a.append(R.styleable.f2545x53e0486c, 18);
                f2518a.append(R.styleable.f2528x25efd865, 19);
                f2518a.append(R.styleable.f2527xa604959e, 20);
                f2518a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                f2518a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                f2518a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                f2518a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                f2518a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                f2518a.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                f2518a.append(R.styleable.f2535xc61dcb1f, 29);
                f2518a.append(R.styleable.f2549x7f3a81cd, 30);
                f2518a.append(R.styleable.f2526x60d10bba, 44);
                f2518a.append(R.styleable.f2537xd978695e, 45);
                f2518a.append(R.styleable.f2551xbe422c8c, 46);
                f2518a.append(R.styleable.f2536x4beab56, 47);
                f2518a.append(R.styleable.f2550x1b772784, 48);
                f2518a.append(R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                f2518a.append(R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                f2518a.append(R.styleable.f2552xc75c58b3, 31);
                f2518a.append(R.styleable.f2531xb0d8a09e, 32);
                f2518a.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                f2518a.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                f2518a.append(R.styleable.f2553x42d0e6b7, 35);
                f2518a.append(R.styleable.f2533xb9dc272f, 36);
                f2518a.append(R.styleable.f2532xb9dc2641, 37);
                f2518a.append(R.styleable.f2534x2c4d2ea2, 38);
                f2518a.append(R.styleable.f2538x729652a9, 39);
                f2518a.append(R.styleable.f2546xca7b95ed, 40);
                f2518a.append(R.styleable.f2541x3e79e0f4, 41);
                f2518a.append(R.styleable.f2521x1c610f8d, 42);
                f2518a.append(R.styleable.f2519xcda51867, 43);
            }
        }

        public C0398a(Context context, AttributeSet attributeSet) throws NumberFormatException {
            int OplusGLSurfaceView_13;
            super(context, attributeSet);
            this.f2479a = -1;
            this.f2493b = -1;
            this.f2494c = -1.0f;
            this.f2495d = -1;
            this.f2496e = -1;
            this.f2497f = -1;
            this.f2498g = -1;
            this.f2499h = -1;
            this.f2500i = -1;
            this.f2501j = -1;
            this.f2502k = -1;
            this.f2503l = -1;
            this.f2504m = -1;
            this.f2505n = 0;
            this.f2506o = 0.0f;
            this.f2507p = -1;
            this.f2508q = -1;
            this.f2509r = -1;
            this.f2510s = -1;
            this.f2511t = -1;
            this.f2512u = -1;
            this.f2513v = -1;
            this.f2514w = -1;
            this.f2515x = -1;
            this.f2516y = -1;
            this.f2517z = 0.5f;
            this.f2453A = 0.5f;
            this.f2454B = null;
            this.f2455C = 0.0f;
            this.f2456D = 1;
            this.f2457E = -1.0f;
            this.f2458F = -1.0f;
            this.f2459G = 0;
            this.f2460H = 0;
            this.f2461I = 0;
            this.f2462J = 0;
            this.f2463K = 0;
            this.f2464L = 0;
            this.f2465M = 0;
            this.f2466N = 0;
            this.f2467O = 1.0f;
            this.f2468P = 1.0f;
            this.f2469Q = -1;
            this.f2470R = -1;
            this.f2471S = -1;
            this.f2472T = false;
            this.f2473U = false;
            this.f2474V = true;
            this.f2475W = true;
            this.f2476X = false;
            this.f2477Y = false;
            this.f2478Z = false;
            this.f2480aa = false;
            this.f2481ab = -1;
            this.f2482ac = -1;
            this.f2483ad = -1;
            this.f2484ae = -1;
            this.f2485af = -1;
            this.f2486ag = -1;
            this.f2487ah = 0.5f;
            this.f2491al = new ConstraintWidget();
            this.f2492am = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                switch (PlatformImplementations.kt_3.f2518a.get(index)) {
                    case 1:
                        this.f2471S = typedArrayObtainStyledAttributes.getInt(index, this.f2471S);
                        break;
                    case 2:
                        this.f2504m = typedArrayObtainStyledAttributes.getResourceId(index, this.f2504m);
                        if (this.f2504m == -1) {
                            this.f2504m = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        this.f2505n = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f2505n);
                        break;
                    case 4:
                        this.f2506o = typedArrayObtainStyledAttributes.getFloat(index, this.f2506o) % 360.0f;
                        float COUIBaseListPopupWindow_12 = this.f2506o;
                        if (COUIBaseListPopupWindow_12 < 0.0f) {
                            this.f2506o = (360.0f - COUIBaseListPopupWindow_12) % 360.0f;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        this.f2479a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f2479a);
                        break;
                    case 6:
                        this.f2493b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f2493b);
                        break;
                    case 7:
                        this.f2494c = typedArrayObtainStyledAttributes.getFloat(index, this.f2494c);
                        break;
                    case 8:
                        this.f2495d = typedArrayObtainStyledAttributes.getResourceId(index, this.f2495d);
                        if (this.f2495d == -1) {
                            this.f2495d = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        this.f2496e = typedArrayObtainStyledAttributes.getResourceId(index, this.f2496e);
                        if (this.f2496e == -1) {
                            this.f2496e = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        this.f2497f = typedArrayObtainStyledAttributes.getResourceId(index, this.f2497f);
                        if (this.f2497f == -1) {
                            this.f2497f = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        this.f2498g = typedArrayObtainStyledAttributes.getResourceId(index, this.f2498g);
                        if (this.f2498g == -1) {
                            this.f2498g = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        this.f2499h = typedArrayObtainStyledAttributes.getResourceId(index, this.f2499h);
                        if (this.f2499h == -1) {
                            this.f2499h = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        this.f2500i = typedArrayObtainStyledAttributes.getResourceId(index, this.f2500i);
                        if (this.f2500i == -1) {
                            this.f2500i = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        this.f2501j = typedArrayObtainStyledAttributes.getResourceId(index, this.f2501j);
                        if (this.f2501j == -1) {
                            this.f2501j = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        this.f2502k = typedArrayObtainStyledAttributes.getResourceId(index, this.f2502k);
                        if (this.f2502k == -1) {
                            this.f2502k = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        this.f2503l = typedArrayObtainStyledAttributes.getResourceId(index, this.f2503l);
                        if (this.f2503l == -1) {
                            this.f2503l = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        this.f2507p = typedArrayObtainStyledAttributes.getResourceId(index, this.f2507p);
                        if (this.f2507p == -1) {
                            this.f2507p = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        this.f2508q = typedArrayObtainStyledAttributes.getResourceId(index, this.f2508q);
                        if (this.f2508q == -1) {
                            this.f2508q = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 19:
                        this.f2509r = typedArrayObtainStyledAttributes.getResourceId(index, this.f2509r);
                        if (this.f2509r == -1) {
                            this.f2509r = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        this.f2510s = typedArrayObtainStyledAttributes.getResourceId(index, this.f2510s);
                        if (this.f2510s == -1) {
                            this.f2510s = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 21:
                        this.f2511t = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f2511t);
                        break;
                    case 22:
                        this.f2512u = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f2512u);
                        break;
                    case 23:
                        this.f2513v = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f2513v);
                        break;
                    case 24:
                        this.f2514w = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f2514w);
                        break;
                    case 25:
                        this.f2515x = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f2515x);
                        break;
                    case 26:
                        this.f2516y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f2516y);
                        break;
                    case 27:
                        this.f2472T = typedArrayObtainStyledAttributes.getBoolean(index, this.f2472T);
                        break;
                    case 28:
                        this.f2473U = typedArrayObtainStyledAttributes.getBoolean(index, this.f2473U);
                        break;
                    case 29:
                        this.f2517z = typedArrayObtainStyledAttributes.getFloat(index, this.f2517z);
                        break;
                    case 30:
                        this.f2453A = typedArrayObtainStyledAttributes.getFloat(index, this.f2453A);
                        break;
                    case 31:
                        this.f2461I = typedArrayObtainStyledAttributes.getInt(index, 0);
                        if (this.f2461I == 1) {
                            Log.COUIBaseListPopupWindow_8("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 32:
                        this.f2462J = typedArrayObtainStyledAttributes.getInt(index, 0);
                        if (this.f2462J == 1) {
                            Log.COUIBaseListPopupWindow_8("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 33:
                        try {
                            this.f2463K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f2463K);
                            break;
                        } catch (Exception unused) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f2463K) == -2) {
                                this.f2463K = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.f2465M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f2465M);
                            break;
                        } catch (Exception unused2) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f2465M) == -2) {
                                this.f2465M = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 35:
                        this.f2467O = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.f2467O));
                        break;
                    case 36:
                        try {
                            this.f2464L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f2464L);
                            break;
                        } catch (Exception unused3) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f2464L) == -2) {
                                this.f2464L = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.f2466N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f2466N);
                            break;
                        } catch (Exception unused4) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f2466N) == -2) {
                                this.f2466N = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 38:
                        this.f2468P = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.f2468P));
                        break;
                    case 44:
                        this.f2454B = typedArrayObtainStyledAttributes.getString(index);
                        this.f2455C = Float.NaN;
                        this.f2456D = -1;
                        String str = this.f2454B;
                        if (str != null) {
                            int length = str.length();
                            int iIndexOf = this.f2454B.indexOf(44);
                            if (iIndexOf <= 0 || iIndexOf >= length - 1) {
                                OplusGLSurfaceView_13 = 0;
                            } else {
                                String strSubstring = this.f2454B.substring(0, iIndexOf);
                                if (strSubstring.equalsIgnoreCase(OplusExifInterface.GpsLongitudeRef.WEST)) {
                                    this.f2456D = 0;
                                } else if (strSubstring.equalsIgnoreCase("H")) {
                                    this.f2456D = 1;
                                }
                                OplusGLSurfaceView_13 = iIndexOf + 1;
                            }
                            int iIndexOf2 = this.f2454B.indexOf(58);
                            if (iIndexOf2 >= 0 && iIndexOf2 < length - 1) {
                                String strSubstring2 = this.f2454B.substring(OplusGLSurfaceView_13, iIndexOf2);
                                String strSubstring3 = this.f2454B.substring(iIndexOf2 + 1);
                                if (strSubstring2.length() <= 0 || strSubstring3.length() <= 0) {
                                    break;
                                } else {
                                    try {
                                        float f2 = Float.parseFloat(strSubstring2);
                                        float f3 = Float.parseFloat(strSubstring3);
                                        if (f2 <= 0.0f || f3 <= 0.0f) {
                                            break;
                                        } else if (this.f2456D == 1) {
                                            this.f2455C = Math.abs(f3 / f2);
                                            break;
                                        } else {
                                            this.f2455C = Math.abs(f2 / f3);
                                            break;
                                        }
                                    } catch (NumberFormatException unused5) {
                                        break;
                                    }
                                }
                            } else {
                                String strSubstring4 = this.f2454B.substring(OplusGLSurfaceView_13);
                                if (strSubstring4.length() > 0) {
                                    this.f2455C = Float.parseFloat(strSubstring4);
                                    break;
                                } else {
                                    break;
                                }
                            }
                        } else {
                            break;
                        }
                        break;
                    case 45:
                        this.f2457E = typedArrayObtainStyledAttributes.getFloat(index, this.f2457E);
                        break;
                    case 46:
                        this.f2458F = typedArrayObtainStyledAttributes.getFloat(index, this.f2458F);
                        break;
                    case 47:
                        this.f2459G = typedArrayObtainStyledAttributes.getInt(index, 0);
                        break;
                    case 48:
                        this.f2460H = typedArrayObtainStyledAttributes.getInt(index, 0);
                        break;
                    case 49:
                        this.f2469Q = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f2469Q);
                        break;
                    case 50:
                        this.f2470R = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f2470R);
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            m2175a();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m2175a() {
            this.f2477Y = false;
            this.f2474V = true;
            this.f2475W = true;
            if (this.width == -2 && this.f2472T) {
                this.f2474V = false;
                this.f2461I = 1;
            }
            if (this.height == -2 && this.f2473U) {
                this.f2475W = false;
                this.f2462J = 1;
            }
            if (this.width == 0 || this.width == -1) {
                this.f2474V = false;
                if (this.width == 0 && this.f2461I == 1) {
                    this.width = -2;
                    this.f2472T = true;
                }
            }
            if (this.height == 0 || this.height == -1) {
                this.f2475W = false;
                if (this.height == 0 && this.f2462J == 1) {
                    this.height = -2;
                    this.f2473U = true;
                }
            }
            if (this.f2494c == -1.0f && this.f2479a == -1 && this.f2493b == -1) {
                return;
            }
            this.f2477Y = true;
            this.f2474V = true;
            this.f2475W = true;
            if (!(this.f2491al instanceof Guideline)) {
                this.f2491al = new Guideline();
            }
            ((Guideline) this.f2491al).m2054a(this.f2471S);
        }

        public C0398a(int OplusGLSurfaceView_13, int i2) {
            super(OplusGLSurfaceView_13, i2);
            this.f2479a = -1;
            this.f2493b = -1;
            this.f2494c = -1.0f;
            this.f2495d = -1;
            this.f2496e = -1;
            this.f2497f = -1;
            this.f2498g = -1;
            this.f2499h = -1;
            this.f2500i = -1;
            this.f2501j = -1;
            this.f2502k = -1;
            this.f2503l = -1;
            this.f2504m = -1;
            this.f2505n = 0;
            this.f2506o = 0.0f;
            this.f2507p = -1;
            this.f2508q = -1;
            this.f2509r = -1;
            this.f2510s = -1;
            this.f2511t = -1;
            this.f2512u = -1;
            this.f2513v = -1;
            this.f2514w = -1;
            this.f2515x = -1;
            this.f2516y = -1;
            this.f2517z = 0.5f;
            this.f2453A = 0.5f;
            this.f2454B = null;
            this.f2455C = 0.0f;
            this.f2456D = 1;
            this.f2457E = -1.0f;
            this.f2458F = -1.0f;
            this.f2459G = 0;
            this.f2460H = 0;
            this.f2461I = 0;
            this.f2462J = 0;
            this.f2463K = 0;
            this.f2464L = 0;
            this.f2465M = 0;
            this.f2466N = 0;
            this.f2467O = 1.0f;
            this.f2468P = 1.0f;
            this.f2469Q = -1;
            this.f2470R = -1;
            this.f2471S = -1;
            this.f2472T = false;
            this.f2473U = false;
            this.f2474V = true;
            this.f2475W = true;
            this.f2476X = false;
            this.f2477Y = false;
            this.f2478Z = false;
            this.f2480aa = false;
            this.f2481ab = -1;
            this.f2482ac = -1;
            this.f2483ad = -1;
            this.f2484ae = -1;
            this.f2485af = -1;
            this.f2486ag = -1;
            this.f2487ah = 0.5f;
            this.f2491al = new ConstraintWidget();
            this.f2492am = false;
        }

        public C0398a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2479a = -1;
            this.f2493b = -1;
            this.f2494c = -1.0f;
            this.f2495d = -1;
            this.f2496e = -1;
            this.f2497f = -1;
            this.f2498g = -1;
            this.f2499h = -1;
            this.f2500i = -1;
            this.f2501j = -1;
            this.f2502k = -1;
            this.f2503l = -1;
            this.f2504m = -1;
            this.f2505n = 0;
            this.f2506o = 0.0f;
            this.f2507p = -1;
            this.f2508q = -1;
            this.f2509r = -1;
            this.f2510s = -1;
            this.f2511t = -1;
            this.f2512u = -1;
            this.f2513v = -1;
            this.f2514w = -1;
            this.f2515x = -1;
            this.f2516y = -1;
            this.f2517z = 0.5f;
            this.f2453A = 0.5f;
            this.f2454B = null;
            this.f2455C = 0.0f;
            this.f2456D = 1;
            this.f2457E = -1.0f;
            this.f2458F = -1.0f;
            this.f2459G = 0;
            this.f2460H = 0;
            this.f2461I = 0;
            this.f2462J = 0;
            this.f2463K = 0;
            this.f2464L = 0;
            this.f2465M = 0;
            this.f2466N = 0;
            this.f2467O = 1.0f;
            this.f2468P = 1.0f;
            this.f2469Q = -1;
            this.f2470R = -1;
            this.f2471S = -1;
            this.f2472T = false;
            this.f2473U = false;
            this.f2474V = true;
            this.f2475W = true;
            this.f2476X = false;
            this.f2477Y = false;
            this.f2478Z = false;
            this.f2480aa = false;
            this.f2481ab = -1;
            this.f2482ac = -1;
            this.f2483ad = -1;
            this.f2484ae = -1;
            this.f2485af = -1;
            this.f2486ag = -1;
            this.f2487ah = 0.5f;
            this.f2491al = new ConstraintWidget();
            this.f2492am = false;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x005a  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x007c  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0084  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        @android.annotation.TargetApi(17)
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void resolveLayoutDirection(int r7) {
            /*
                Method dump skipped, instructions count: 265
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.C0398a.resolveLayoutDirection(int):void");
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        this.f2445m = true;
        this.f2450r = -1;
        this.f2451s = -1;
        this.f2435c = -1;
        this.f2436d = -1;
        this.f2437e = 0;
        this.f2438f = 0;
    }
}
