package com.coui.appcompat.widget;

import android.annotation.SuppressLint;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Adapter;

/* compiled from: COUIAdapterView.java */
/* renamed from: com.coui.appcompat.widget.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public abstract class COUIAdapterView<T extends Adapter> extends ViewGroup {

    /* renamed from: A */
    int f7920A;

    /* renamed from: B */
    int f7921B;

    /* renamed from: C */
    long f7922C;

    /* renamed from: D */
    boolean f7923D;

    /* renamed from: PlatformImplementations.kt_3 */
    private int f7924a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private View f7925b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f7926c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f7927d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private COUIAdapterView<T>.COUIBaseListPopupWindow_8 f7928e;

    /* renamed from: OplusGLSurfaceView_15 */
    @ViewDebug.ExportedProperty(category = "scrolling")
    int f7929j;

    /* renamed from: OplusGLSurfaceView_5 */
    int f7930k;

    /* renamed from: OplusGLSurfaceView_14 */
    int f7931l;

    /* renamed from: OplusGLSurfaceView_6 */
    long f7932m;

    /* renamed from: OplusGLSurfaceView_11 */
    long f7933n;

    /* renamed from: o */
    boolean f7934o;

    /* renamed from: p */
    int f7935p;

    /* renamed from: q */
    boolean f7936q;

    /* renamed from: r */
    IntrinsicsJvm.kt_5 f7937r;

    /* renamed from: s */
    IntrinsicsJvm.kt_4 f7938s;

    /* renamed from: t */
    IntrinsicsJvm.kt_3 f7939t;

    /* renamed from: u */
    boolean f7940u;

    /* renamed from: v */
    @ViewDebug.ExportedProperty(category = "list")
    int f7941v;

    /* renamed from: w */
    long f7942w;

    /* renamed from: x */
    @ViewDebug.ExportedProperty(category = "list")
    int f7943x;

    /* renamed from: y */
    long f7944y;

    /* renamed from: z */
    @ViewDebug.ExportedProperty(category = "list")
    int f7945z;

    /* compiled from: COUIAdapterView.java */
    /* renamed from: com.coui.appcompat.widget.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 {
    }

    /* compiled from: COUIAdapterView.java */
    /* renamed from: com.coui.appcompat.widget.PlatformImplementations.kt_3$IntrinsicsJvm.kt_3 */
    public interface IntrinsicsJvm.kt_3 {
    }

    /* compiled from: COUIAdapterView.java */
    /* renamed from: com.coui.appcompat.widget.PlatformImplementations.kt_3$IntrinsicsJvm.kt_5 */
    public interface IntrinsicsJvm.kt_5 {
        /* renamed from: PlatformImplementations.kt_3 */
        void m7539a(COUIAdapterView<?> abstractC1446a);

        /* renamed from: PlatformImplementations.kt_3 */
        void m7540a(COUIAdapterView<?> abstractC1446a, View view, int OplusGLSurfaceView_13, long OplusGLSurfaceView_15);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    int m7529b(int OplusGLSurfaceView_13, boolean z) {
        return OplusGLSurfaceView_13;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    boolean m7530c() {
        return false;
    }

    public abstract T getAdapter();

    public abstract View getSelectedView();

    public abstract void setAdapter(T t);

    public abstract void setSelection(int OplusGLSurfaceView_13);

    public void setOnItemClickListener(IntrinsicsJvm.kt_4 bVar) {
        this.f7938s = bVar;
    }

    public final IntrinsicsJvm.kt_4 getOnItemClickListener() {
        return this.f7938s;
    }

    public void setOnItemLongClickListener(IntrinsicsJvm.kt_3 cVar) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.f7939t = cVar;
    }

    public final IntrinsicsJvm.kt_3 getOnItemLongClickListener() {
        return this.f7939t;
    }

    public void setOnItemSelectedListener(IntrinsicsJvm.kt_5 dVar) {
        this.f7937r = dVar;
    }

    public final IntrinsicsJvm.kt_5 getOnItemSelectedListener() {
        return this.f7937r;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int OplusGLSurfaceView_13) {
        throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int OplusGLSurfaceView_13, ViewGroup.LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int OplusGLSurfaceView_13) {
        throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        this.f7924a = getHeight();
    }

    @ViewDebug.CapturedViewProperty
    public int getSelectedItemPosition() {
        return this.f7941v;
    }

    @ViewDebug.CapturedViewProperty
    public long getSelectedItemId() {
        return this.f7942w;
    }

    public Object getSelectedItem() {
        Adapter adapter = getAdapter();
        int selectedItemPosition = getSelectedItemPosition();
        if (adapter == null || adapter.getCount() <= 0 || selectedItemPosition < 0) {
            return null;
        }
        return adapter.getItem(selectedItemPosition);
    }

    @ViewDebug.CapturedViewProperty
    public int getCount() {
        return this.f7945z;
    }

    public int getFirstVisiblePosition() {
        return this.f7929j;
    }

    public int getLastVisiblePosition() {
        return (this.f7929j + getChildCount()) - 1;
    }

    public void setEmptyView(View view) {
        this.f7925b = view;
        Adapter adapter = getAdapter();
        m7526a(adapter == null || adapter.isEmpty());
    }

    public View getEmptyView() {
        return this.f7925b;
    }

    @Override // android.view.View
    public void setFocusable(boolean z) {
        Adapter adapter = getAdapter();
        boolean z2 = true;
        boolean z3 = adapter == null || adapter.getCount() == 0;
        this.f7926c = z;
        if (!z) {
            this.f7927d = false;
        }
        if (!z || (z3 && !m7530c())) {
            z2 = false;
        }
        super.setFocusable(z2);
    }

    @Override // android.view.View
    public void setFocusableInTouchMode(boolean z) {
        Adapter adapter = getAdapter();
        boolean z2 = false;
        boolean z3 = adapter == null || adapter.getCount() == 0;
        this.f7927d = z;
        if (z) {
            this.f7926c = true;
        }
        if (z && (!z3 || m7530c())) {
            z2 = true;
        }
        super.setFocusableInTouchMode(z2);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    void m7531d() {
        Adapter adapter = getAdapter();
        boolean z = !(adapter == null || adapter.getCount() == 0) || m7530c();
        super.setFocusableInTouchMode(z && this.f7927d);
        super.setFocusable(z && this.f7926c);
        if (this.f7925b != null) {
            m7526a(adapter == null || adapter.isEmpty());
        }
    }

    @SuppressLint({"WrongCall"})
    /* renamed from: PlatformImplementations.kt_3 */
    private void m7526a(boolean z) {
        if (m7530c()) {
            z = false;
        }
        if (z) {
            View view = this.f7925b;
            if (view != null) {
                view.setVisibility(0);
                setVisibility(8);
            } else {
                setVisibility(0);
            }
            if (this.f7940u) {
                onLayout(false, getLeft(), getTop(), getRight(), getBottom());
                return;
            }
            return;
        }
        View view2 = this.f7925b;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        setVisibility(0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public long m7528a(int OplusGLSurfaceView_13) {
        Adapter adapter = getAdapter();
        if (adapter == null || OplusGLSurfaceView_13 < 0) {
            return Long.MIN_VALUE;
        }
        return adapter.getItemId(OplusGLSurfaceView_13);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        throw new RuntimeException("Don't call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    /* compiled from: COUIAdapterView.java */
    /* renamed from: com.coui.appcompat.widget.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    class PlatformImplementations.kt_3 extends DataSetObserver {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private Parcelable f7947b = null;

        PlatformImplementations.kt_3() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            COUIAdapterView abstractC1446a = COUIAdapterView.this;
            abstractC1446a.f7940u = true;
            abstractC1446a.f7920A = abstractC1446a.f7945z;
            COUIAdapterView abstractC1446a2 = COUIAdapterView.this;
            abstractC1446a2.f7945z = abstractC1446a2.getAdapter().getCount();
            if (COUIAdapterView.this.getAdapter().hasStableIds() && this.f7947b != null && COUIAdapterView.this.f7920A == 0 && COUIAdapterView.this.f7945z > 0) {
                COUIAdapterView.this.onRestoreInstanceState(this.f7947b);
                this.f7947b = null;
            } else {
                COUIAdapterView.this.m7536i();
            }
            COUIAdapterView.this.m7531d();
            COUIAdapterView.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            COUIAdapterView abstractC1446a = COUIAdapterView.this;
            abstractC1446a.f7940u = true;
            if (abstractC1446a.getAdapter().hasStableIds()) {
                this.f7947b = COUIAdapterView.this.onSaveInstanceState();
            }
            COUIAdapterView abstractC1446a2 = COUIAdapterView.this;
            abstractC1446a2.f7920A = abstractC1446a2.f7945z;
            COUIAdapterView abstractC1446a3 = COUIAdapterView.this;
            abstractC1446a3.f7945z = 0;
            abstractC1446a3.f7943x = -1;
            abstractC1446a3.f7944y = Long.MIN_VALUE;
            abstractC1446a3.f7941v = -1;
            abstractC1446a3.f7942w = Long.MIN_VALUE;
            abstractC1446a3.f7934o = false;
            abstractC1446a3.m7531d();
            COUIAdapterView.this.requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f7928e);
    }

    /* compiled from: COUIAdapterView.java */
    /* renamed from: com.coui.appcompat.widget.PlatformImplementations.kt_3$COUIBaseListPopupWindow_8 */
    private class COUIBaseListPopupWindow_8 implements Runnable {
        private COUIBaseListPopupWindow_8() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!COUIAdapterView.this.f7940u) {
                COUIAdapterView.this.m7524a();
            } else if (COUIAdapterView.this.getAdapter() != null) {
                COUIAdapterView.this.post(this);
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    void mo7532e() {
        if (this.f7937r != null) {
            if (this.f7936q || this.f7923D) {
                if (this.f7928e == null) {
                    this.f7928e = new COUIBaseListPopupWindow_8();
                }
                post(this.f7928e);
            } else {
                m7524a();
            }
        }
        if (this.f7943x == -1 || !isShown() || isInTouchMode()) {
            return;
        }
        sendAccessibilityEvent(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m7524a() {
        if (this.f7937r == null) {
            return;
        }
        int selectedItemPosition = getSelectedItemPosition();
        if (selectedItemPosition >= 0) {
            this.f7937r.m7540a(this, getSelectedView(), selectedItemPosition, getAdapter().getItemId(selectedItemPosition));
        } else {
            this.f7937r.m7539a(this);
        }
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        View selectedView = getSelectedView();
        return selectedView != null && selectedView.getVisibility() == 0 && selectedView.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.ViewGroup
    protected boolean canAnimate() {
        return super.canAnimate() && this.f7945z > 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003f  */
    /* renamed from: COUIBaseListPopupWindow_12 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void m7533f() {
        /*
            r5 = this;
            int r0 = r5.f7945z
            r1 = 1
            r2 = 0
            if (r0 <= 0) goto L41
            boolean r3 = r5.f7934o
            if (r3 == 0) goto L1d
            r5.f7934o = r2
            int r3 = r5.m7535h()
            if (r3 < 0) goto L1d
            int r4 = r5.m7529b(r3, r1)
            if (r4 != r3) goto L1d
            r5.setNextSelectedPositionInt(r3)
            r3 = r1
            goto L1e
        L1d:
            r3 = r2
        L1e:
            if (r3 != 0) goto L3f
            int r4 = r5.getSelectedItemPosition()
            if (r4 < r0) goto L28
            int r0 = r0 - r1
            goto L29
        L28:
            r0 = r4
        L29:
            if (r0 >= 0) goto L2c
            r0 = r2
        L2c:
            int r4 = r5.m7529b(r0, r1)
            if (r4 >= 0) goto L36
            int r4 = r5.m7529b(r0, r2)
        L36:
            if (r4 < 0) goto L3f
            r5.setNextSelectedPositionInt(r4)
            r5.m7534g()
            goto L42
        L3f:
            r1 = r3
            goto L42
        L41:
            r1 = r2
        L42:
            if (r1 != 0) goto L54
            r0 = -1
            r5.f7943x = r0
            r3 = -9223372036854775808
            r5.f7944y = r3
            r5.f7941v = r0
            r5.f7942w = r3
            r5.f7934o = r2
            r5.m7534g()
        L54:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.widget.COUIAdapterView.m7533f():void");
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    void m7534g() {
        if (this.f7943x == this.f7921B && this.f7944y == this.f7922C) {
            return;
        }
        mo7532e();
        this.f7921B = this.f7943x;
        this.f7922C = this.f7944y;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    int m7535h() {
        int OplusGLSurfaceView_13 = this.f7945z;
        if (OplusGLSurfaceView_13 == 0) {
            return -1;
        }
        long OplusGLSurfaceView_15 = this.f7932m;
        int i2 = this.f7931l;
        if (OplusGLSurfaceView_15 == Long.MIN_VALUE) {
            return -1;
        }
        int i3 = OplusGLSurfaceView_13 - 1;
        int iMin = Math.min(i3, Math.max(0, i2));
        long jUptimeMillis = SystemClock.uptimeMillis() + 100;
        Adapter adapter = getAdapter();
        if (adapter == null) {
            return -1;
        }
        int i4 = iMin;
        int i5 = i4;
        boolean z = false;
        while (SystemClock.uptimeMillis() <= jUptimeMillis) {
            if (adapter.getItemId(iMin) != OplusGLSurfaceView_15) {
                boolean z2 = i4 == i3;
                boolean z3 = i5 == 0;
                if (z2 && z3) {
                    break;
                }
                if (z3 || (z && !z2)) {
                    i4++;
                    z = false;
                    iMin = i4;
                } else if (z2 || (!z && !z3)) {
                    i5--;
                    z = true;
                    iMin = i5;
                }
            } else {
                return iMin;
            }
        }
        return -1;
    }

    void setSelectedPositionInt(int OplusGLSurfaceView_13) {
        this.f7943x = OplusGLSurfaceView_13;
        this.f7944y = m7528a(OplusGLSurfaceView_13);
    }

    void setNextSelectedPositionInt(int OplusGLSurfaceView_13) {
        this.f7941v = OplusGLSurfaceView_13;
        this.f7942w = m7528a(OplusGLSurfaceView_13);
        if (this.f7934o && this.f7935p == 0 && OplusGLSurfaceView_13 >= 0) {
            this.f7931l = OplusGLSurfaceView_13;
            this.f7932m = this.f7942w;
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    void m7536i() {
        if (getChildCount() > 0) {
            this.f7934o = true;
            this.f7933n = this.f7924a;
            int OplusGLSurfaceView_13 = this.f7943x;
            if (OplusGLSurfaceView_13 >= 0) {
                View childAt = getChildAt(OplusGLSurfaceView_13 - this.f7929j);
                this.f7932m = this.f7942w;
                this.f7931l = this.f7941v;
                if (childAt != null) {
                    this.f7930k = childAt.getTop();
                }
                this.f7935p = 0;
                return;
            }
            View childAt2 = getChildAt(0);
            Adapter adapter = getAdapter();
            int i2 = this.f7929j;
            if (i2 >= 0 && i2 < adapter.getCount()) {
                this.f7932m = adapter.getItemId(this.f7929j);
            } else {
                this.f7932m = -1L;
            }
            this.f7931l = this.f7929j;
            if (childAt2 != null) {
                this.f7930k = childAt2.getTop();
            }
            this.f7935p = 1;
        }
    }
}
