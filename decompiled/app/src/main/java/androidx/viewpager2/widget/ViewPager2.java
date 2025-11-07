package androidx.viewpager2.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.p036h.ViewCompat;
import androidx.core.p036h.p037a.AccessibilityNodeInfoCompat;
import androidx.core.p036h.p037a.AccessibilityViewCommand;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.R;
import androidx.viewpager2.adapter.StatefulAdapter;
import com.google.android.material.badge.BadgeDrawable;

/* loaded from: classes.dex */
public final class ViewPager2 extends ViewGroup {

    /* renamed from: PlatformImplementations.kt_3 */
    static boolean f4883a = true;

    /* renamed from: IntrinsicsJvm.kt_4 */
    int f4884b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    boolean f4885c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    LinearLayoutManager f4886d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    RecyclerView f4887e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    ScrollEventAdapter f4888f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    AbstractC0841a f4889g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private final Rect f4890h;

    /* renamed from: OplusGLSurfaceView_13 */
    private final Rect f4891i;

    /* renamed from: OplusGLSurfaceView_15 */
    private CompositeOnPageChangeCallback f4892j;

    /* renamed from: OplusGLSurfaceView_5 */
    private RecyclerView.AbstractC0687c f4893k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f4894l;

    /* renamed from: OplusGLSurfaceView_6 */
    private Parcelable f4895m;

    /* renamed from: OplusGLSurfaceView_11 */
    private PagerSnapHelper f4896n;

    /* renamed from: o */
    private CompositeOnPageChangeCallback f4897o;

    /* renamed from: p */
    private FakeDrag f4898p;

    /* renamed from: q */
    private PageTransformerAdapter f4899q;

    /* renamed from: r */
    private RecyclerView.AbstractC0690f f4900r;

    /* renamed from: s */
    private boolean f4901s;

    /* renamed from: t */
    private boolean f4902t;

    /* renamed from: u */
    private int f4903u;

    /* renamed from: androidx.viewpager2.widget.ViewPager2$COUIBaseListPopupWindow_8 */
    public static abstract class AbstractC0845e {
        public void onPageScrollStateChanged(int OplusGLSurfaceView_13) {
        }

        public void onPageScrolled(int OplusGLSurfaceView_13, float COUIBaseListPopupWindow_12, int i2) {
        }

        public void onPageSelected(int OplusGLSurfaceView_13) {
        }
    }

    /* renamed from: androidx.viewpager2.widget.ViewPager2$COUIBaseListPopupWindow_11 */
    public interface InterfaceC0847g {
        /* renamed from: PlatformImplementations.kt_3 */
        void m5079a(View view, float COUIBaseListPopupWindow_12);
    }

    public ViewPager2(Context context) {
        super(context);
        this.f4890h = new Rect();
        this.f4891i = new Rect();
        this.f4892j = new CompositeOnPageChangeCallback(3);
        this.f4885c = false;
        this.f4893k = new AbstractC0843c() { // from class: androidx.viewpager2.widget.ViewPager2.1
            @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0843c, androidx.recyclerview.widget.RecyclerView.AbstractC0687c
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f4885c = true;
                viewPager2.f4888f.m5099a();
            }
        };
        this.f4894l = -1;
        this.f4900r = null;
        this.f4901s = false;
        this.f4902t = true;
        this.f4903u = -1;
        m5035a(context, (AttributeSet) null);
    }

    public ViewPager2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4890h = new Rect();
        this.f4891i = new Rect();
        this.f4892j = new CompositeOnPageChangeCallback(3);
        this.f4885c = false;
        this.f4893k = new AbstractC0843c() { // from class: androidx.viewpager2.widget.ViewPager2.1
            @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0843c, androidx.recyclerview.widget.RecyclerView.AbstractC0687c
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f4885c = true;
                viewPager2.f4888f.m5099a();
            }
        };
        this.f4894l = -1;
        this.f4900r = null;
        this.f4901s = false;
        this.f4902t = true;
        this.f4903u = -1;
        m5035a(context, attributeSet);
    }

    public ViewPager2(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f4890h = new Rect();
        this.f4891i = new Rect();
        this.f4892j = new CompositeOnPageChangeCallback(3);
        this.f4885c = false;
        this.f4893k = new AbstractC0843c() { // from class: androidx.viewpager2.widget.ViewPager2.1
            @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0843c, androidx.recyclerview.widget.RecyclerView.AbstractC0687c
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f4885c = true;
                viewPager2.f4888f.m5099a();
            }
        };
        this.f4894l = -1;
        this.f4900r = null;
        this.f4901s = false;
        this.f4902t = true;
        this.f4903u = -1;
        m5035a(context, attributeSet);
    }

    public ViewPager2(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13, i2);
        this.f4890h = new Rect();
        this.f4891i = new Rect();
        this.f4892j = new CompositeOnPageChangeCallback(3);
        this.f4885c = false;
        this.f4893k = new AbstractC0843c() { // from class: androidx.viewpager2.widget.ViewPager2.1
            @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0843c, androidx.recyclerview.widget.RecyclerView.AbstractC0687c
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f4885c = true;
                viewPager2.f4888f.m5099a();
            }
        };
        this.f4894l = -1;
        this.f4900r = null;
        this.f4901s = false;
        this.f4902t = true;
        this.f4903u = -1;
        m5035a(context, attributeSet);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m5035a(Context context, AttributeSet attributeSet) {
        AbstractC0841a c0842b;
        if (f4883a) {
            c0842b = new C0846f();
        } else {
            c0842b = new C0842b();
        }
        this.f4889g = c0842b;
        this.f4887e = new C0849i(context);
        this.f4887e.setId(ViewCompat.m2836a());
        this.f4887e.setDescendantFocusability(131072);
        this.f4886d = new C0844d(context);
        this.f4887e.setLayoutManager(this.f4886d);
        this.f4887e.setScrollingTouchSlop(1);
        m5037b(context, attributeSet);
        this.f4887e.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f4887e.addOnChildAttachStateChangeListener(m5039f());
        this.f4888f = new ScrollEventAdapter(this);
        this.f4898p = new FakeDrag(this, this.f4888f, this.f4887e);
        this.f4896n = new C0848h();
        this.f4896n.m4549a(this.f4887e);
        this.f4887e.addOnScrollListener(this.f4888f);
        this.f4897o = new CompositeOnPageChangeCallback(3);
        this.f4888f.m5101a(this.f4897o);
        AbstractC0845e abstractC0845e = new AbstractC0845e() { // from class: androidx.viewpager2.widget.ViewPager2.2
            @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0845e
            public void onPageSelected(int OplusGLSurfaceView_13) {
                if (ViewPager2.this.f4884b != OplusGLSurfaceView_13) {
                    ViewPager2 viewPager2 = ViewPager2.this;
                    viewPager2.f4884b = OplusGLSurfaceView_13;
                    viewPager2.f4889g.mo5069e();
                }
            }

            @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0845e
            public void onPageScrollStateChanged(int OplusGLSurfaceView_13) {
                if (OplusGLSurfaceView_13 == 0) {
                    ViewPager2.this.m5041a();
                }
            }
        };
        AbstractC0845e abstractC0845e2 = new AbstractC0845e() { // from class: androidx.viewpager2.widget.ViewPager2.3
            @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0845e
            public void onPageSelected(int OplusGLSurfaceView_13) {
                ViewPager2.this.clearFocus();
                if (ViewPager2.this.hasFocus()) {
                    ViewPager2.this.f4887e.requestFocus(2);
                }
            }
        };
        this.f4897o.m5086a(abstractC0845e);
        this.f4897o.m5086a(abstractC0845e2);
        this.f4889g.mo5059a(this.f4897o, this.f4887e);
        this.f4897o.m5086a(this.f4892j);
        this.f4899q = new PageTransformerAdapter(this.f4886d);
        this.f4897o.m5086a(this.f4899q);
        RecyclerView recyclerView = this.f4887e;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private RecyclerView.InterfaceC0695k m5039f() {
        return new RecyclerView.InterfaceC0695k() { // from class: androidx.viewpager2.widget.ViewPager2.4
            @Override // androidx.recyclerview.widget.RecyclerView.InterfaceC0695k
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo4161b(View view) {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.InterfaceC0695k
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo4160a(View view) {
                RecyclerView.C0694j c0694j = (RecyclerView.C0694j) view.getLayoutParams();
                if (c0694j.width != -1 || c0694j.height != -1) {
                    throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
                }
            }
        };
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        if (this.f4889g.mo5060a()) {
            return this.f4889g.mo5063b();
        }
        return super.getAccessibilityClassName();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m5037b(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ViewPager2);
        ViewCompat.m2845a(this, context, R.styleable.ViewPager2, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        try {
            setOrientation(typedArrayObtainStyledAttributes.getInt(R.styleable.ViewPager2_android_orientation, 0));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.mRecyclerViewId = this.f4887e.getId();
        int OplusGLSurfaceView_13 = this.f4894l;
        if (OplusGLSurfaceView_13 == -1) {
            OplusGLSurfaceView_13 = this.f4884b;
        }
        savedState.mCurrentItem = OplusGLSurfaceView_13;
        Parcelable parcelable = this.f4895m;
        if (parcelable != null) {
            savedState.mAdapterState = parcelable;
        } else {
            Object adapter = this.f4887e.getAdapter();
            if (adapter instanceof StatefulAdapter) {
                savedState.mAdapterState = ((StatefulAdapter) adapter).m5034b();
            }
        }
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f4894l = savedState.mCurrentItem;
        this.f4895m = savedState.mAdapterState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m5040g() {
        RecyclerView.AbstractC0685a adapter;
        if (this.f4894l == -1 || (adapter = getAdapter()) == 0) {
            return;
        }
        Parcelable parcelable = this.f4895m;
        if (parcelable != null) {
            if (adapter instanceof StatefulAdapter) {
                ((StatefulAdapter) adapter).m5033a(parcelable);
            }
            this.f4895m = null;
        }
        this.f4884b = Math.max(0, Math.min(this.f4894l, adapter.getItemCount() - 1));
        this.f4894l = -1;
        this.f4887e.scrollToPosition(this.f4884b);
        this.f4889g.mo5067c();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int OplusGLSurfaceView_13 = ((SavedState) parcelable).mRecyclerViewId;
            sparseArray.put(this.f4887e.getId(), sparseArray.get(OplusGLSurfaceView_13));
            sparseArray.remove(OplusGLSurfaceView_13);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        m5040g();
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.viewpager2.widget.ViewPager2.SavedState.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                if (Build.VERSION.SDK_INT >= 24) {
                    return new SavedState(parcel, classLoader);
                }
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int OplusGLSurfaceView_13) {
                return new SavedState[OplusGLSurfaceView_13];
            }
        };
        Parcelable mAdapterState;
        int mCurrentItem;
        int mRecyclerViewId;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            readValues(parcel, classLoader);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            readValues(parcel, null);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void readValues(Parcel parcel, ClassLoader classLoader) {
            this.mRecyclerViewId = parcel.readInt();
            this.mCurrentItem = parcel.readInt();
            this.mAdapterState = parcel.readParcelable(classLoader);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            super.writeToParcel(parcel, OplusGLSurfaceView_13);
            parcel.writeInt(this.mRecyclerViewId);
            parcel.writeInt(this.mCurrentItem);
            parcel.writeParcelable(this.mAdapterState, OplusGLSurfaceView_13);
        }
    }

    public void setAdapter(RecyclerView.AbstractC0685a abstractC0685a) {
        RecyclerView.AbstractC0685a adapter = this.f4887e.getAdapter();
        this.f4889g.mo5064b((RecyclerView.AbstractC0685a<?>) adapter);
        m5038b((RecyclerView.AbstractC0685a<?>) adapter);
        this.f4887e.setAdapter(abstractC0685a);
        this.f4884b = 0;
        m5040g();
        this.f4889g.mo5058a((RecyclerView.AbstractC0685a<?>) abstractC0685a);
        m5036a((RecyclerView.AbstractC0685a<?>) abstractC0685a);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m5036a(RecyclerView.AbstractC0685a<?> abstractC0685a) {
        if (abstractC0685a != null) {
            abstractC0685a.registerAdapterDataObserver(this.f4893k);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m5038b(RecyclerView.AbstractC0685a<?> abstractC0685a) {
        if (abstractC0685a != null) {
            abstractC0685a.unregisterAdapterDataObserver(this.f4893k);
        }
    }

    public RecyclerView.AbstractC0685a getAdapter() {
        return this.f4887e.getAdapter();
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        throw new IllegalStateException(getClass().getSimpleName() + " does not support direct child views");
    }

    @Override // android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        measureChild(this.f4887e, OplusGLSurfaceView_13, i2);
        int measuredWidth = this.f4887e.getMeasuredWidth();
        int measuredHeight = this.f4887e.getMeasuredHeight();
        int measuredState = this.f4887e.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), OplusGLSurfaceView_13, measuredState), resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, measuredState << 16));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        int measuredWidth = this.f4887e.getMeasuredWidth();
        int measuredHeight = this.f4887e.getMeasuredHeight();
        this.f4890h.left = getPaddingLeft();
        this.f4890h.right = (i3 - OplusGLSurfaceView_13) - getPaddingRight();
        this.f4890h.top = getPaddingTop();
        this.f4890h.bottom = (i4 - i2) - getPaddingBottom();
        Gravity.apply(BadgeDrawable.TOP_START, measuredWidth, measuredHeight, this.f4890h, this.f4891i);
        this.f4887e.layout(this.f4891i.left, this.f4891i.top, this.f4891i.right, this.f4891i.bottom);
        if (this.f4885c) {
            m5041a();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m5041a() {
        PagerSnapHelper c0728o = this.f4896n;
        if (c0728o == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        View viewMo4487a = c0728o.mo4487a(this.f4886d);
        if (viewMo4487a == null) {
            return;
        }
        int position = this.f4886d.getPosition(viewMo4487a);
        if (position != this.f4884b && getScrollState() == 0) {
            this.f4897o.onPageSelected(position);
        }
        this.f4885c = false;
    }

    int getPageSize() {
        int height;
        int paddingBottom;
        RecyclerView recyclerView = this.f4887e;
        if (getOrientation() == 0) {
            height = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            paddingBottom = recyclerView.getPaddingRight();
        } else {
            height = recyclerView.getHeight() - recyclerView.getPaddingTop();
            paddingBottom = recyclerView.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public void setOrientation(int OplusGLSurfaceView_13) {
        this.f4886d.setOrientation(OplusGLSurfaceView_13);
        this.f4889g.mo5068d();
    }

    public int getOrientation() {
        return this.f4886d.getOrientation();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    boolean m5047b() {
        return this.f4886d.getLayoutDirection() == 1;
    }

    public void setCurrentItem(int OplusGLSurfaceView_13) {
        m5042a(OplusGLSurfaceView_13, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m5042a(int OplusGLSurfaceView_13, boolean z) {
        if (m5048c()) {
            throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
        }
        m5045b(OplusGLSurfaceView_13, z);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m5045b(int OplusGLSurfaceView_13, boolean z) {
        RecyclerView.AbstractC0685a adapter = getAdapter();
        if (adapter == null) {
            if (this.f4894l != -1) {
                this.f4894l = Math.max(OplusGLSurfaceView_13, 0);
                return;
            }
            return;
        }
        if (adapter.getItemCount() <= 0) {
            return;
        }
        int iMin = Math.min(Math.max(OplusGLSurfaceView_13, 0), adapter.getItemCount() - 1);
        if (iMin == this.f4884b && this.f4888f.m5103c()) {
            return;
        }
        if (iMin == this.f4884b && z) {
            return;
        }
        double dM5105e = this.f4884b;
        this.f4884b = iMin;
        this.f4889g.mo5069e();
        if (!this.f4888f.m5103c()) {
            dM5105e = this.f4888f.m5105e();
        }
        this.f4888f.m5100a(iMin, z);
        if (!z) {
            this.f4887e.scrollToPosition(iMin);
            return;
        }
        double IntrinsicsJvm.kt_5 = iMin;
        if (Math.abs(IntrinsicsJvm.kt_5 - dM5105e) > 3.0d) {
            this.f4887e.scrollToPosition(IntrinsicsJvm.kt_5 > dM5105e ? iMin - 3 : iMin + 3);
            RecyclerView recyclerView = this.f4887e;
            recyclerView.post(new RunnableC0850j(iMin, recyclerView));
            return;
        }
        this.f4887e.smoothScrollToPosition(iMin);
    }

    public int getCurrentItem() {
        return this.f4884b;
    }

    public int getScrollState() {
        return this.f4888f.m5102b();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m5048c() {
        return this.f4898p.m5088a();
    }

    public void setUserInputEnabled(boolean z) {
        this.f4902t = z;
        this.f4889g.mo5070f();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m5049d() {
        return this.f4902t;
    }

    public void setOffscreenPageLimit(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 1 && OplusGLSurfaceView_13 != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or PlatformImplementations.kt_3 number > 0");
        }
        this.f4903u = OplusGLSurfaceView_13;
        this.f4887e.requestLayout();
    }

    public int getOffscreenPageLimit() {
        return this.f4903u;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int OplusGLSurfaceView_13) {
        return this.f4887e.canScrollHorizontally(OplusGLSurfaceView_13);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int OplusGLSurfaceView_13) {
        return this.f4887e.canScrollVertically(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m5044a(AbstractC0845e abstractC0845e) {
        this.f4892j.m5086a(abstractC0845e);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m5046b(AbstractC0845e abstractC0845e) {
        this.f4892j.m5087b(abstractC0845e);
    }

    public void setPageTransformer(InterfaceC0847g interfaceC0847g) {
        if (interfaceC0847g != null) {
            if (!this.f4901s) {
                this.f4900r = this.f4887e.getItemAnimator();
                this.f4901s = true;
            }
            this.f4887e.setItemAnimator(null);
        } else if (this.f4901s) {
            this.f4887e.setItemAnimator(this.f4900r);
            this.f4900r = null;
            this.f4901s = false;
        }
        if (interfaceC0847g == this.f4899q.m5089a()) {
            return;
        }
        this.f4899q.m5090a(interfaceC0847g);
        m5050e();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m5050e() {
        if (this.f4899q.m5089a() == null) {
            return;
        }
        double dM5105e = this.f4888f.m5105e();
        int OplusGLSurfaceView_13 = (int) dM5105e;
        float COUIBaseListPopupWindow_12 = (float) (dM5105e - OplusGLSurfaceView_13);
        this.f4899q.onPageScrolled(OplusGLSurfaceView_13, COUIBaseListPopupWindow_12, Math.round(getPageSize() * COUIBaseListPopupWindow_12));
    }

    @Override // android.view.View
    public void setLayoutDirection(int OplusGLSurfaceView_13) {
        super.setLayoutDirection(OplusGLSurfaceView_13);
        this.f4889g.mo5071g();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.f4889g.mo5056a(accessibilityNodeInfo);
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int OplusGLSurfaceView_13, Bundle bundle) {
        if (this.f4889g.mo5062a(OplusGLSurfaceView_13, bundle)) {
            return this.f4889g.mo5066b(OplusGLSurfaceView_13, bundle);
        }
        return super.performAccessibilityAction(OplusGLSurfaceView_13, bundle);
    }

    /* renamed from: androidx.viewpager2.widget.ViewPager2$OplusGLSurfaceView_13 */
    private class C0849i extends RecyclerView {
        C0849i(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        public CharSequence getAccessibilityClassName() {
            if (ViewPager2.this.f4889g.mo5072h()) {
                return ViewPager2.this.f4889g.mo5073i();
            }
            return super.getAccessibilityClassName();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.f4884b);
            accessibilityEvent.setToIndex(ViewPager2.this.f4884b);
            ViewPager2.this.f4889g.mo5055a(accessibilityEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.m5049d() && super.onTouchEvent(motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.m5049d() && super.onInterceptTouchEvent(motionEvent);
        }
    }

    /* renamed from: androidx.viewpager2.widget.ViewPager2$IntrinsicsJvm.kt_5 */
    private class C0844d extends LinearLayoutManager {
        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            return false;
        }

        C0844d(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
        public boolean performAccessibilityAction(RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t, int OplusGLSurfaceView_13, Bundle bundle) {
            if (ViewPager2.this.f4889g.mo5061a(OplusGLSurfaceView_13)) {
                return ViewPager2.this.f4889g.mo5065b(OplusGLSurfaceView_13);
            }
            return super.performAccessibilityAction(c0700p, c0704t, OplusGLSurfaceView_13, bundle);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
        public void onInitializeAccessibilityNodeInfo(RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t, AccessibilityNodeInfoCompat c0483d) {
            super.onInitializeAccessibilityNodeInfo(c0700p, c0704t, c0483d);
            ViewPager2.this.f4889g.mo5057a(c0483d);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
        public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t, View view, AccessibilityNodeInfoCompat c0483d) {
            ViewPager2.this.f4889g.mo5054a(view, c0483d);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        protected void calculateExtraLayoutSpace(RecyclerView.C0704t c0704t, int[] iArr) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.calculateExtraLayoutSpace(c0704t, iArr);
                return;
            }
            int pageSize = ViewPager2.this.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }
    }

    /* renamed from: androidx.viewpager2.widget.ViewPager2$COUIBaseListPopupWindow_10 */
    private class C0848h extends PagerSnapHelper {
        C0848h() {
        }

        @Override // androidx.recyclerview.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
        /* renamed from: PlatformImplementations.kt_3 */
        public View mo4487a(RecyclerView.AbstractC0693i abstractC0693i) {
            if (ViewPager2.this.m5048c()) {
                return null;
            }
            return super.mo4487a(abstractC0693i);
        }
    }

    /* renamed from: androidx.viewpager2.widget.ViewPager2$OplusGLSurfaceView_15 */
    private static class RunnableC0850j implements Runnable {

        /* renamed from: PlatformImplementations.kt_3 */
        private final int f4920a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final RecyclerView f4921b;

        RunnableC0850j(int OplusGLSurfaceView_13, RecyclerView recyclerView) {
            this.f4920a = OplusGLSurfaceView_13;
            this.f4921b = recyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4921b.smoothScrollToPosition(this.f4920a);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m5043a(RecyclerView.AbstractC0692h abstractC0692h) {
        this.f4887e.addItemDecoration(abstractC0692h);
    }

    public int getItemDecorationCount() {
        return this.f4887e.getItemDecorationCount();
    }

    /* renamed from: androidx.viewpager2.widget.ViewPager2$PlatformImplementations.kt_3 */
    private abstract class AbstractC0841a {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo5054a(View view, AccessibilityNodeInfoCompat c0483d) {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void mo5055a(AccessibilityEvent accessibilityEvent) {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void mo5056a(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void mo5057a(AccessibilityNodeInfoCompat c0483d) {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void mo5058a(RecyclerView.AbstractC0685a<?> abstractC0685a) {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void mo5059a(CompositeOnPageChangeCallback c0852b, RecyclerView recyclerView) {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo5060a() {
            return false;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo5061a(int OplusGLSurfaceView_13) {
            return false;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo5062a(int OplusGLSurfaceView_13, Bundle bundle) {
            return false;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo5064b(RecyclerView.AbstractC0685a<?> abstractC0685a) {
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        void mo5067c() {
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        void mo5068d() {
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        void mo5069e() {
        }

        /* renamed from: COUIBaseListPopupWindow_12 */
        void mo5070f() {
        }

        /* renamed from: COUIBaseListPopupWindow_11 */
        void mo5071g() {
        }

        /* renamed from: COUIBaseListPopupWindow_10 */
        boolean mo5072h() {
            return false;
        }

        private AbstractC0841a() {
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        String mo5063b() {
            throw new IllegalStateException("Not implemented.");
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        boolean mo5066b(int OplusGLSurfaceView_13, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        boolean mo5065b(int OplusGLSurfaceView_13) {
            throw new IllegalStateException("Not implemented.");
        }

        /* renamed from: OplusGLSurfaceView_13 */
        CharSequence mo5073i() {
            throw new IllegalStateException("Not implemented.");
        }
    }

    /* renamed from: androidx.viewpager2.widget.ViewPager2$IntrinsicsJvm.kt_4 */
    class C0842b extends AbstractC0841a {
        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0841a
        /* renamed from: COUIBaseListPopupWindow_10 */
        public boolean mo5072h() {
            return true;
        }

        C0842b() {
            super();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0841a
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo5061a(int OplusGLSurfaceView_13) {
            return (OplusGLSurfaceView_13 == 8192 || OplusGLSurfaceView_13 == 4096) && !ViewPager2.this.m5049d();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0841a
        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean mo5065b(int OplusGLSurfaceView_13) {
            if (mo5061a(OplusGLSurfaceView_13)) {
                return false;
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0841a
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo5057a(AccessibilityNodeInfoCompat c0483d) {
            if (ViewPager2.this.m5049d()) {
                return;
            }
            c0483d.m2693b(AccessibilityNodeInfoCompat.PlatformImplementations.kt_3.f3027n);
            c0483d.m2693b(AccessibilityNodeInfoCompat.PlatformImplementations.kt_3.f3026m);
            c0483d.m2715i(false);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0841a
        /* renamed from: OplusGLSurfaceView_13 */
        public CharSequence mo5073i() {
            if (mo5072h()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }
    }

    /* renamed from: androidx.viewpager2.widget.ViewPager2$COUIBaseListPopupWindow_12 */
    class C0846f extends AbstractC0841a {

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final AccessibilityViewCommand f4912c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private final AccessibilityViewCommand f4913d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private RecyclerView.AbstractC0687c f4914e;

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0841a
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo5060a() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0841a
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo5062a(int OplusGLSurfaceView_13, Bundle bundle) {
            return OplusGLSurfaceView_13 == 8192 || OplusGLSurfaceView_13 == 4096;
        }

        C0846f() {
            super();
            this.f4912c = new AccessibilityViewCommand() { // from class: androidx.viewpager2.widget.ViewPager2.COUIBaseListPopupWindow_12.1
                @Override // androidx.core.p036h.p037a.AccessibilityViewCommand
                public boolean perform(View view, AccessibilityViewCommand.PlatformImplementations.kt_3 aVar) {
                    C0846f.this.m5077c(((ViewPager2) view).getCurrentItem() + 1);
                    return true;
                }
            };
            this.f4913d = new AccessibilityViewCommand() { // from class: androidx.viewpager2.widget.ViewPager2.COUIBaseListPopupWindow_12.2
                @Override // androidx.core.p036h.p037a.AccessibilityViewCommand
                public boolean perform(View view, AccessibilityViewCommand.PlatformImplementations.kt_3 aVar) {
                    C0846f.this.m5077c(((ViewPager2) view).getCurrentItem() - 1);
                    return true;
                }
            };
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0841a
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo5059a(CompositeOnPageChangeCallback c0852b, RecyclerView recyclerView) {
            ViewCompat.m2867b((View) recyclerView, 2);
            this.f4914e = new AbstractC0843c() { // from class: androidx.viewpager2.widget.ViewPager2.COUIBaseListPopupWindow_12.3
                @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0843c, androidx.recyclerview.widget.RecyclerView.AbstractC0687c
                public void onChanged() {
                    C0846f.this.m5078j();
                }
            };
            if (ViewCompat.m2883f(ViewPager2.this) == 0) {
                ViewCompat.m2867b((View) ViewPager2.this, 1);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0841a
        /* renamed from: IntrinsicsJvm.kt_4 */
        public String mo5063b() {
            if (mo5060a()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0841a
        /* renamed from: IntrinsicsJvm.kt_3 */
        public void mo5067c() {
            m5078j();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0841a
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo5058a(RecyclerView.AbstractC0685a<?> abstractC0685a) {
            m5078j();
            if (abstractC0685a != null) {
                abstractC0685a.registerAdapterDataObserver(this.f4914e);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0841a
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo5064b(RecyclerView.AbstractC0685a<?> abstractC0685a) {
            if (abstractC0685a != null) {
                abstractC0685a.unregisterAdapterDataObserver(this.f4914e);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0841a
        /* renamed from: IntrinsicsJvm.kt_5 */
        public void mo5068d() {
            m5078j();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0841a
        /* renamed from: COUIBaseListPopupWindow_8 */
        public void mo5069e() {
            m5078j();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0841a
        /* renamed from: COUIBaseListPopupWindow_12 */
        public void mo5070f() {
            m5078j();
            if (Build.VERSION.SDK_INT < 21) {
                ViewPager2.this.sendAccessibilityEvent(2048);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0841a
        /* renamed from: COUIBaseListPopupWindow_11 */
        public void mo5071g() {
            m5078j();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0841a
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo5056a(AccessibilityNodeInfo accessibilityNodeInfo) {
            AccessibilityNodeInfoCompat c0483dM2661a = AccessibilityNodeInfoCompat.m2661a(accessibilityNodeInfo);
            m5075b(c0483dM2661a);
            if (Build.VERSION.SDK_INT >= 16) {
                m5076c(c0483dM2661a);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0841a
        /* renamed from: PlatformImplementations.kt_3 */
        void mo5054a(View view, AccessibilityNodeInfoCompat c0483d) {
            m5074b(view, c0483d);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0841a
        /* renamed from: IntrinsicsJvm.kt_4 */
        public boolean mo5066b(int OplusGLSurfaceView_13, Bundle bundle) {
            int currentItem;
            if (!mo5062a(OplusGLSurfaceView_13, bundle)) {
                throw new IllegalStateException();
            }
            if (OplusGLSurfaceView_13 == 8192) {
                currentItem = ViewPager2.this.getCurrentItem() - 1;
            } else {
                currentItem = ViewPager2.this.getCurrentItem() + 1;
            }
            m5077c(currentItem);
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0841a
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo5055a(AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setSource(ViewPager2.this);
            accessibilityEvent.setClassName(mo5063b());
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        void m5077c(int OplusGLSurfaceView_13) {
            if (ViewPager2.this.m5049d()) {
                ViewPager2.this.m5045b(OplusGLSurfaceView_13, true);
            }
        }

        /* renamed from: OplusGLSurfaceView_15 */
        void m5078j() {
            int itemCount;
            ViewPager2 viewPager2 = ViewPager2.this;
            int OplusGLSurfaceView_13 = android.R.id_renamed.accessibilityActionPageLeft;
            ViewCompat.m2874c((View) viewPager2, android.R.id_renamed.accessibilityActionPageLeft);
            ViewCompat.m2874c((View) viewPager2, android.R.id_renamed.accessibilityActionPageRight);
            ViewCompat.m2874c((View) viewPager2, android.R.id_renamed.accessibilityActionPageUp);
            ViewCompat.m2874c((View) viewPager2, android.R.id_renamed.accessibilityActionPageDown);
            if (ViewPager2.this.getAdapter() == null || (itemCount = ViewPager2.this.getAdapter().getItemCount()) == 0 || !ViewPager2.this.m5049d()) {
                return;
            }
            if (ViewPager2.this.getOrientation() == 0) {
                boolean zM5047b = ViewPager2.this.m5047b();
                int i2 = zM5047b ? 16908360 : 16908361;
                if (zM5047b) {
                    OplusGLSurfaceView_13 = 16908361;
                }
                if (ViewPager2.this.f4884b < itemCount - 1) {
                    ViewCompat.m2852a(viewPager2, new AccessibilityNodeInfoCompat.PlatformImplementations.kt_3(i2, null), null, this.f4912c);
                }
                if (ViewPager2.this.f4884b > 0) {
                    ViewCompat.m2852a(viewPager2, new AccessibilityNodeInfoCompat.PlatformImplementations.kt_3(OplusGLSurfaceView_13, null), null, this.f4913d);
                    return;
                }
                return;
            }
            if (ViewPager2.this.f4884b < itemCount - 1) {
                ViewCompat.m2852a(viewPager2, new AccessibilityNodeInfoCompat.PlatformImplementations.kt_3(android.R.id_renamed.accessibilityActionPageDown, null), null, this.f4912c);
            }
            if (ViewPager2.this.f4884b > 0) {
                ViewCompat.m2852a(viewPager2, new AccessibilityNodeInfoCompat.PlatformImplementations.kt_3(android.R.id_renamed.accessibilityActionPageUp, null), null, this.f4913d);
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        private void m5075b(AccessibilityNodeInfoCompat c0483d) {
            int itemCount;
            int itemCount2 = 1;
            if (ViewPager2.this.getAdapter() == null) {
                itemCount = 0;
                itemCount2 = 0;
            } else if (ViewPager2.this.getOrientation() == 1) {
                itemCount = ViewPager2.this.getAdapter().getItemCount();
            } else {
                itemCount2 = ViewPager2.this.getAdapter().getItemCount();
                itemCount = 1;
            }
            c0483d.m2683a(AccessibilityNodeInfoCompat.IntrinsicsJvm.kt_4.m2741a(itemCount, itemCount2, false, 0));
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        private void m5074b(View view, AccessibilityNodeInfoCompat c0483d) {
            c0483d.m2691b(AccessibilityNodeInfoCompat.IntrinsicsJvm.kt_3.m2742a(ViewPager2.this.getOrientation() == 1 ? ViewPager2.this.f4886d.getPosition(view) : 0, 1, ViewPager2.this.getOrientation() == 0 ? ViewPager2.this.f4886d.getPosition(view) : 0, 1, false, false));
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        private void m5076c(AccessibilityNodeInfoCompat c0483d) {
            int itemCount;
            RecyclerView.AbstractC0685a adapter = ViewPager2.this.getAdapter();
            if (adapter == null || (itemCount = adapter.getItemCount()) == 0 || !ViewPager2.this.m5049d()) {
                return;
            }
            if (ViewPager2.this.f4884b > 0) {
                c0483d.m2676a(8192);
            }
            if (ViewPager2.this.f4884b < itemCount - 1) {
                c0483d.m2676a(4096);
            }
            c0483d.m2715i(true);
        }
    }

    /* renamed from: androidx.viewpager2.widget.ViewPager2$IntrinsicsJvm.kt_3 */
    private static abstract class AbstractC0843c extends RecyclerView.AbstractC0687c {
        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0687c
        public abstract void onChanged();

        private AbstractC0843c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0687c
        public final void onItemRangeChanged(int OplusGLSurfaceView_13, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0687c
        public final void onItemRangeChanged(int OplusGLSurfaceView_13, int i2, Object obj) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0687c
        public final void onItemRangeInserted(int OplusGLSurfaceView_13, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0687c
        public final void onItemRangeRemoved(int OplusGLSurfaceView_13, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0687c
        public final void onItemRangeMoved(int OplusGLSurfaceView_13, int i2, int i3) {
            onChanged();
        }
    }
}
