package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.p036h.p037a.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;

/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {

    /* renamed from: PlatformImplementations.kt_3 */
    boolean f3979a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    int f3980b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    int[] f3981c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    View[] f3982d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    final SparseIntArray f3983e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    final SparseIntArray f3984f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    AbstractC0672c f3985g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    final Rect f3986h;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f3987i;

    public GridLayoutManager(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13, i2);
        this.f3979a = false;
        this.f3980b = -1;
        this.f3983e = new SparseIntArray();
        this.f3984f = new SparseIntArray();
        this.f3985g = new C0670a();
        this.f3986h = new Rect();
        m4057a(getProperties(context, attributeSet, OplusGLSurfaceView_13, i2).f4036b);
    }

    public GridLayoutManager(Context context, int OplusGLSurfaceView_13) {
        super(context);
        this.f3979a = false;
        this.f3980b = -1;
        this.f3983e = new SparseIntArray();
        this.f3984f = new SparseIntArray();
        this.f3985g = new C0670a();
        this.f3986h = new Rect();
        m4057a(OplusGLSurfaceView_13);
    }

    public GridLayoutManager(Context context, int OplusGLSurfaceView_13, int i2, boolean z) {
        super(context, i2, z);
        this.f3979a = false;
        this.f3980b = -1;
        this.f3983e = new SparseIntArray();
        this.f3984f = new SparseIntArray();
        this.f3985g = new C0670a();
        this.f3986h = new Rect();
        m4057a(OplusGLSurfaceView_13);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setStackFromEnd(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.setStackFromEnd(false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public int getRowCountForAccessibility(RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t) {
        if (this.mOrientation == 0) {
            return this.f3980b;
        }
        if (c0704t.m4230e() < 1) {
            return 0;
        }
        return m4039a(c0700p, c0704t, c0704t.m4230e() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public int getColumnCountForAccessibility(RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t) {
        if (this.mOrientation == 1) {
            return this.f3980b;
        }
        if (c0704t.m4230e() < 1) {
            return 0;
        }
        return m4039a(c0700p, c0704t, c0704t.m4230e() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t, View view, AccessibilityNodeInfoCompat c0483d) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof C0671b)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, c0483d);
            return;
        }
        C0671b c0671b = (C0671b) layoutParams;
        int iM4039a = m4039a(c0700p, c0704t, c0671b.m4157f());
        if (this.mOrientation == 0) {
            c0483d.m2691b(AccessibilityNodeInfoCompat.IntrinsicsJvm.kt_3.m2742a(c0671b.m4060a(), c0671b.m4061b(), iM4039a, 1, false, false));
        } else {
            c0483d.m2691b(AccessibilityNodeInfoCompat.IntrinsicsJvm.kt_3.m2742a(iM4039a, 1, c0671b.m4060a(), c0671b.m4061b(), false, false));
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public void onLayoutChildren(RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t) {
        if (c0704t.m4226a()) {
            m4052c();
        }
        super.onLayoutChildren(c0700p, c0704t);
        m4049b();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public void onLayoutCompleted(RecyclerView.C0704t c0704t) {
        super.onLayoutCompleted(c0704t);
        this.f3979a = false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m4049b() {
        this.f3983e.clear();
        this.f3984f.clear();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m4052c() {
        int childCount = getChildCount();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            C0671b c0671b = (C0671b) getChildAt(OplusGLSurfaceView_13).getLayoutParams();
            int iF = c0671b.m4157f();
            this.f3983e.put(iF, c0671b.m4061b());
            this.f3984f.put(iF, c0671b.m4060a());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public void onItemsAdded(RecyclerView recyclerView, int OplusGLSurfaceView_13, int i2) {
        this.f3985g.m4063a();
        this.f3985g.m4065b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public void onItemsChanged(RecyclerView recyclerView) {
        this.f3985g.m4063a();
        this.f3985g.m4065b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public void onItemsRemoved(RecyclerView recyclerView, int OplusGLSurfaceView_13, int i2) {
        this.f3985g.m4063a();
        this.f3985g.m4065b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public void onItemsUpdated(RecyclerView recyclerView, int OplusGLSurfaceView_13, int i2, Object obj) {
        this.f3985g.m4063a();
        this.f3985g.m4065b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public void onItemsMoved(RecyclerView recyclerView, int OplusGLSurfaceView_13, int i2, int i3) {
        this.f3985g.m4063a();
        this.f3985g.m4065b();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public RecyclerView.C0694j generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new C0671b(-2, -1);
        }
        return new C0671b(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public RecyclerView.C0694j generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new C0671b(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public RecyclerView.C0694j generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new C0671b((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new C0671b(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public boolean checkLayoutParams(RecyclerView.C0694j c0694j) {
        return c0694j instanceof C0671b;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m4053d() {
        int height;
        int paddingTop;
        if (getOrientation() == 1) {
            height = getWidth() - getPaddingRight();
            paddingTop = getPaddingLeft();
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = getPaddingTop();
        }
        m4050b(height - paddingTop);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public void setMeasuredDimension(Rect rect, int OplusGLSurfaceView_13, int i2) {
        int iChooseSize;
        int iChooseSize2;
        if (this.f3981c == null) {
            super.setMeasuredDimension(rect, OplusGLSurfaceView_13, i2);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            iChooseSize2 = chooseSize(i2, rect.height() + paddingTop, getMinimumHeight());
            int[] iArr = this.f3981c;
            iChooseSize = chooseSize(OplusGLSurfaceView_13, iArr[iArr.length - 1] + paddingLeft, getMinimumWidth());
        } else {
            iChooseSize = chooseSize(OplusGLSurfaceView_13, rect.width() + paddingLeft, getMinimumWidth());
            int[] iArr2 = this.f3981c;
            iChooseSize2 = chooseSize(i2, iArr2[iArr2.length - 1] + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(iChooseSize, iChooseSize2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m4050b(int OplusGLSurfaceView_13) {
        this.f3981c = m4046a(this.f3981c, this.f3980b, OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static int[] m4046a(int[] iArr, int OplusGLSurfaceView_13, int i2) {
        int i3;
        if (iArr == null || iArr.length != OplusGLSurfaceView_13 + 1 || iArr[iArr.length - 1] != i2) {
            iArr = new int[OplusGLSurfaceView_13 + 1];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i2 / OplusGLSurfaceView_13;
        int i6 = i2 % OplusGLSurfaceView_13;
        int i7 = 0;
        for (int i8 = 1; i8 <= OplusGLSurfaceView_13; i8++) {
            i4 += i6;
            if (i4 <= 0 || OplusGLSurfaceView_13 - i4 >= i6) {
                i3 = i5;
            } else {
                i3 = i5 + 1;
                i4 -= OplusGLSurfaceView_13;
            }
            i7 += i3;
            iArr[i8] = i7;
        }
        return iArr;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    int m4056a(int OplusGLSurfaceView_13, int i2) {
        if (this.mOrientation == 1 && isLayoutRTL()) {
            int[] iArr = this.f3981c;
            int i3 = this.f3980b;
            return iArr[i3 - OplusGLSurfaceView_13] - iArr[(i3 - OplusGLSurfaceView_13) - i2];
        }
        int[] iArr2 = this.f3981c;
        return iArr2[i2 + OplusGLSurfaceView_13] - iArr2[OplusGLSurfaceView_13];
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void onAnchorReady(RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t, LinearLayoutManager.C0674a c0674a, int OplusGLSurfaceView_13) {
        super.onAnchorReady(c0700p, c0704t, c0674a, OplusGLSurfaceView_13);
        m4053d();
        if (c0704t.m4230e() > 0 && !c0704t.m4226a()) {
            m4045a(c0700p, c0704t, c0674a, OplusGLSurfaceView_13);
        }
        m4054e();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m4054e() {
        View[] viewArr = this.f3982d;
        if (viewArr == null || viewArr.length != this.f3980b) {
            this.f3982d = new View[this.f3980b];
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public int scrollHorizontallyBy(int OplusGLSurfaceView_13, RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t) {
        m4053d();
        m4054e();
        return super.scrollHorizontallyBy(OplusGLSurfaceView_13, c0700p, c0704t);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public int scrollVerticallyBy(int OplusGLSurfaceView_13, RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t) {
        m4053d();
        m4054e();
        return super.scrollVerticallyBy(OplusGLSurfaceView_13, c0700p, c0704t);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m4045a(RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t, LinearLayoutManager.C0674a c0674a, int OplusGLSurfaceView_13) {
        boolean z = OplusGLSurfaceView_13 == 1;
        int iM4047b = m4047b(c0700p, c0704t, c0674a.f3995b);
        if (z) {
            while (iM4047b > 0 && c0674a.f3995b > 0) {
                c0674a.f3995b--;
                iM4047b = m4047b(c0700p, c0704t, c0674a.f3995b);
            }
            return;
        }
        int iM4230e = c0704t.m4230e() - 1;
        int i2 = c0674a.f3995b;
        while (i2 < iM4230e) {
            int i3 = i2 + 1;
            int iM4047b2 = m4047b(c0700p, c0704t, i3);
            if (iM4047b2 <= iM4047b) {
                break;
            }
            i2 = i3;
            iM4047b = iM4047b2;
        }
        c0674a.f3995b = i2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    View findReferenceChild(RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t, int OplusGLSurfaceView_13, int i2, int i3) {
        ensureLayoutState();
        int iMo4505d = this.mOrientationHelper.mo4505d();
        int iMo4507e = this.mOrientationHelper.mo4507e();
        int i4 = i2 > OplusGLSurfaceView_13 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (OplusGLSurfaceView_13 != i2) {
            View childAt = getChildAt(OplusGLSurfaceView_13);
            int position = getPosition(childAt);
            if (position >= 0 && position < i3 && m4047b(c0700p, c0704t, position) == 0) {
                if (((RecyclerView.C0694j) childAt.getLayoutParams()).m4155d()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.mOrientationHelper.mo4498a(childAt) < iMo4507e && this.mOrientationHelper.mo4501b(childAt) >= iMo4505d) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            OplusGLSurfaceView_13 += i4;
        }
        return view != null ? view : view2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m4039a(RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t, int OplusGLSurfaceView_13) {
        if (!c0704t.m4226a()) {
            return this.f3985g.m4066c(OplusGLSurfaceView_13, this.f3980b);
        }
        int iM4195b = c0700p.m4195b(OplusGLSurfaceView_13);
        if (iM4195b == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + OplusGLSurfaceView_13);
            return 0;
        }
        return this.f3985g.m4066c(iM4195b, this.f3980b);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int m4047b(RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t, int OplusGLSurfaceView_13) {
        if (!c0704t.m4226a()) {
            return this.f3985g.m4064b(OplusGLSurfaceView_13, this.f3980b);
        }
        int i2 = this.f3984f.get(OplusGLSurfaceView_13, -1);
        if (i2 != -1) {
            return i2;
        }
        int iM4195b = c0700p.m4195b(OplusGLSurfaceView_13);
        if (iM4195b == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + OplusGLSurfaceView_13);
            return 0;
        }
        return this.f3985g.m4064b(iM4195b, this.f3980b);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int m4051c(RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t, int OplusGLSurfaceView_13) {
        if (!c0704t.m4226a()) {
            return this.f3985g.mo4058a(OplusGLSurfaceView_13);
        }
        int i2 = this.f3983e.get(OplusGLSurfaceView_13, -1);
        if (i2 != -1) {
            return i2;
        }
        int iM4195b = c0700p.m4195b(OplusGLSurfaceView_13);
        if (iM4195b == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + OplusGLSurfaceView_13);
            return 1;
        }
        return this.f3985g.mo4058a(iM4195b);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void collectPrefetchPositionsForLayoutState(RecyclerView.C0704t c0704t, LinearLayoutManager.C0676c c0676c, RecyclerView.AbstractC0693i.PlatformImplementations.kt_3 aVar) {
        int iMo4058a = this.f3980b;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f3980b && c0676c.m4082a(c0704t) && iMo4058a > 0; OplusGLSurfaceView_13++) {
            int i2 = c0676c.f4006d;
            aVar.mo4153b(i2, Math.max(0, c0676c.f4009g));
            iMo4058a -= this.f3985g.mo4058a(i2);
            c0676c.f4006d += c0676c.f4007e;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v28 */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void layoutChunk(RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t, LinearLayoutManager.C0676c c0676c, LinearLayoutManager.C0675b c0675b) {
        int OplusGLSurfaceView_13;
        int i2;
        int i3;
        int i4;
        int iMo4510f;
        int i5;
        int iMo4510f2;
        int iMo4510f3;
        int childMeasureSpec;
        int childMeasureSpec2;
        View viewM4079a;
        int iMo4514j = this.mOrientationHelper.mo4514j();
        ?? r5 = 0;
        boolean z = iMo4514j != 1073741824;
        int i6 = getChildCount() > 0 ? this.f3981c[this.f3980b] : 0;
        if (z) {
            m4053d();
        }
        boolean z2 = c0676c.f4007e == 1;
        int iM4047b = this.f3980b;
        if (!z2) {
            iM4047b = m4047b(c0700p, c0704t, c0676c.f4006d) + m4051c(c0700p, c0704t, c0676c.f4006d);
        }
        int i7 = iM4047b;
        int i8 = 0;
        while (i8 < this.f3980b && c0676c.m4082a(c0704t) && i7 > 0) {
            int i9 = c0676c.f4006d;
            int iM4051c = m4051c(c0700p, c0704t, i9);
            if (iM4051c > this.f3980b) {
                throw new IllegalArgumentException("Item at position " + i9 + " requires " + iM4051c + " spans but GridLayoutManager has only " + this.f3980b + " spans.");
            }
            i7 -= iM4051c;
            if (i7 < 0 || (viewM4079a = c0676c.m4079a(c0700p)) == null) {
                break;
            }
            this.f3982d[i8] = viewM4079a;
            i8++;
        }
        if (i8 == 0) {
            c0675b.f4000b = true;
            return;
        }
        float COUIBaseListPopupWindow_12 = 0.0f;
        m4044a(c0700p, c0704t, i8, z2);
        int i10 = 0;
        int i11 = 0;
        while (i10 < i8) {
            View view = this.f3982d[i10];
            if (c0676c.f4014l == null) {
                if (z2) {
                    addView(view);
                } else {
                    addView(view, r5);
                }
            } else if (z2) {
                addDisappearingView(view);
            } else {
                addDisappearingView(view, r5);
            }
            calculateItemDecorationsForChild(view, this.f3986h);
            m4043a(view, iMo4514j, (boolean) r5);
            int iMo4508e = this.mOrientationHelper.mo4508e(view);
            if (iMo4508e > i11) {
                i11 = iMo4508e;
            }
            float fMo4510f = (this.mOrientationHelper.mo4510f(view) * 1.0f) / ((C0671b) view.getLayoutParams()).f3989b;
            if (fMo4510f > COUIBaseListPopupWindow_12) {
                COUIBaseListPopupWindow_12 = fMo4510f;
            }
            i10++;
            r5 = 0;
        }
        if (z) {
            m4041a(COUIBaseListPopupWindow_12, i6);
            i11 = 0;
            for (int i12 = 0; i12 < i8; i12++) {
                View view2 = this.f3982d[i12];
                m4043a(view2, 1073741824, true);
                int iMo4508e2 = this.mOrientationHelper.mo4508e(view2);
                if (iMo4508e2 > i11) {
                    i11 = iMo4508e2;
                }
            }
        }
        for (int i13 = 0; i13 < i8; i13++) {
            View view3 = this.f3982d[i13];
            if (this.mOrientationHelper.mo4508e(view3) != i11) {
                C0671b c0671b = (C0671b) view3.getLayoutParams();
                Rect rect = c0671b.f4040d;
                int i14 = rect.top + rect.bottom + c0671b.topMargin + c0671b.bottomMargin;
                int i15 = rect.left + rect.right + c0671b.leftMargin + c0671b.rightMargin;
                int iM4056a = m4056a(c0671b.f3988a, c0671b.f3989b);
                if (this.mOrientation == 1) {
                    childMeasureSpec2 = getChildMeasureSpec(iM4056a, 1073741824, i15, c0671b.width, false);
                    childMeasureSpec = View.MeasureSpec.makeMeasureSpec(i11 - i14, 1073741824);
                } else {
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i11 - i15, 1073741824);
                    childMeasureSpec = getChildMeasureSpec(iM4056a, 1073741824, i14, c0671b.height, false);
                    childMeasureSpec2 = iMakeMeasureSpec;
                }
                m4042a(view3, childMeasureSpec2, childMeasureSpec, true);
            }
        }
        int i16 = 0;
        c0675b.f3999a = i11;
        if (this.mOrientation == 1) {
            if (c0676c.f4008f == -1) {
                int i17 = c0676c.f4004b;
                OplusGLSurfaceView_13 = i17 - i11;
                i2 = i17;
            } else {
                int i18 = c0676c.f4004b;
                i2 = i18 + i11;
                OplusGLSurfaceView_13 = i18;
            }
            i4 = 0;
            i3 = 0;
        } else if (c0676c.f4008f == -1) {
            i3 = c0676c.f4004b;
            i4 = i3 - i11;
            OplusGLSurfaceView_13 = 0;
            i2 = 0;
        } else {
            int i19 = c0676c.f4004b;
            int i20 = i19 + i11;
            OplusGLSurfaceView_13 = 0;
            i2 = 0;
            i3 = i20;
            i4 = i19;
        }
        while (i16 < i8) {
            View view4 = this.f3982d[i16];
            C0671b c0671b2 = (C0671b) view4.getLayoutParams();
            if (this.mOrientation == 1) {
                if (isLayoutRTL()) {
                    int paddingLeft = getPaddingLeft() + this.f3981c[this.f3980b - c0671b2.f3988a];
                    iMo4510f3 = paddingLeft;
                    i5 = OplusGLSurfaceView_13;
                    iMo4510f2 = i2;
                    iMo4510f = paddingLeft - this.mOrientationHelper.mo4510f(view4);
                } else {
                    int paddingLeft2 = getPaddingLeft() + this.f3981c[c0671b2.f3988a];
                    iMo4510f = paddingLeft2;
                    i5 = OplusGLSurfaceView_13;
                    iMo4510f2 = i2;
                    iMo4510f3 = this.mOrientationHelper.mo4510f(view4) + paddingLeft2;
                }
            } else {
                int paddingTop = getPaddingTop() + this.f3981c[c0671b2.f3988a];
                iMo4510f = i4;
                i5 = paddingTop;
                iMo4510f2 = this.mOrientationHelper.mo4510f(view4) + paddingTop;
                iMo4510f3 = i3;
            }
            layoutDecoratedWithMargins(view4, iMo4510f, i5, iMo4510f3, iMo4510f2);
            if (c0671b2.m4155d() || c0671b2.m4156e()) {
                c0675b.f4001c = true;
            }
            c0675b.f4002d |= view4.hasFocusable();
            i16++;
            i4 = iMo4510f;
            OplusGLSurfaceView_13 = i5;
            i3 = iMo4510f3;
            i2 = iMo4510f2;
        }
        Arrays.fill(this.f3982d, (Object) null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m4043a(View view, int OplusGLSurfaceView_13, boolean z) {
        int childMeasureSpec;
        int childMeasureSpec2;
        C0671b c0671b = (C0671b) view.getLayoutParams();
        Rect rect = c0671b.f4040d;
        int i2 = rect.top + rect.bottom + c0671b.topMargin + c0671b.bottomMargin;
        int i3 = rect.left + rect.right + c0671b.leftMargin + c0671b.rightMargin;
        int iM4056a = m4056a(c0671b.f3988a, c0671b.f3989b);
        if (this.mOrientation == 1) {
            childMeasureSpec2 = getChildMeasureSpec(iM4056a, OplusGLSurfaceView_13, i3, c0671b.width, false);
            childMeasureSpec = getChildMeasureSpec(this.mOrientationHelper.mo4511g(), getHeightMode(), i2, c0671b.height, true);
        } else {
            int childMeasureSpec3 = getChildMeasureSpec(iM4056a, OplusGLSurfaceView_13, i2, c0671b.height, false);
            int childMeasureSpec4 = getChildMeasureSpec(this.mOrientationHelper.mo4511g(), getWidthMode(), i3, c0671b.width, true);
            childMeasureSpec = childMeasureSpec3;
            childMeasureSpec2 = childMeasureSpec4;
        }
        m4042a(view, childMeasureSpec2, childMeasureSpec, z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m4041a(float COUIBaseListPopupWindow_12, int OplusGLSurfaceView_13) {
        m4050b(Math.max(Math.round(COUIBaseListPopupWindow_12 * this.f3980b), OplusGLSurfaceView_13));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m4042a(View view, int OplusGLSurfaceView_13, int i2, boolean z) {
        boolean zShouldMeasureChild;
        RecyclerView.C0694j c0694j = (RecyclerView.C0694j) view.getLayoutParams();
        if (z) {
            zShouldMeasureChild = shouldReMeasureChild(view, OplusGLSurfaceView_13, i2, c0694j);
        } else {
            zShouldMeasureChild = shouldMeasureChild(view, OplusGLSurfaceView_13, i2, c0694j);
        }
        if (zShouldMeasureChild) {
            view.measure(OplusGLSurfaceView_13, i2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m4044a(RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t, int OplusGLSurfaceView_13, boolean z) {
        int i2;
        int i3;
        int i4 = 0;
        int i5 = -1;
        if (z) {
            i3 = 1;
            i5 = OplusGLSurfaceView_13;
            i2 = 0;
        } else {
            i2 = OplusGLSurfaceView_13 - 1;
            i3 = -1;
        }
        while (i2 != i5) {
            View view = this.f3982d[i2];
            C0671b c0671b = (C0671b) view.getLayoutParams();
            c0671b.f3989b = m4051c(c0700p, c0704t, getPosition(view));
            c0671b.f3988a = i4;
            i4 += c0671b.f3989b;
            i2 += i3;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m4055a() {
        return this.f3980b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m4057a(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == this.f3980b) {
            return;
        }
        this.f3979a = true;
        if (OplusGLSurfaceView_13 < 1) {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + OplusGLSurfaceView_13);
        }
        this.f3980b = OplusGLSurfaceView_13;
        this.f3985g.m4063a();
        requestLayout();
    }

    /* renamed from: androidx.recyclerview.widget.GridLayoutManager$IntrinsicsJvm.kt_3 */
    public static abstract class AbstractC0672c {

        /* renamed from: PlatformImplementations.kt_3 */
        final SparseIntArray f3990a = new SparseIntArray();

        /* renamed from: IntrinsicsJvm.kt_4 */
        final SparseIntArray f3991b = new SparseIntArray();

        /* renamed from: IntrinsicsJvm.kt_3 */
        private boolean f3992c = false;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private boolean f3993d = false;

        /* renamed from: PlatformImplementations.kt_3 */
        public abstract int mo4058a(int OplusGLSurfaceView_13);

        /* renamed from: PlatformImplementations.kt_3 */
        public void m4063a() {
            this.f3990a.clear();
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m4065b() {
            this.f3991b.clear();
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        int m4064b(int OplusGLSurfaceView_13, int i2) {
            if (!this.f3992c) {
                return mo4059a(OplusGLSurfaceView_13, i2);
            }
            int i3 = this.f3990a.get(OplusGLSurfaceView_13, -1);
            if (i3 != -1) {
                return i3;
            }
            int iMo4059a = mo4059a(OplusGLSurfaceView_13, i2);
            this.f3990a.put(OplusGLSurfaceView_13, iMo4059a);
            return iMo4059a;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        int m4066c(int OplusGLSurfaceView_13, int i2) {
            if (!this.f3993d) {
                return m4067d(OplusGLSurfaceView_13, i2);
            }
            int i3 = this.f3991b.get(OplusGLSurfaceView_13, -1);
            if (i3 != -1) {
                return i3;
            }
            int iM4067d = m4067d(OplusGLSurfaceView_13, i2);
            this.f3991b.put(OplusGLSurfaceView_13, iM4067d);
            return iM4067d;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x002b -> B:17:0x0030). Please report as PlatformImplementations.kt_3 decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x002d -> B:17:0x0030). Please report as PlatformImplementations.kt_3 decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x002f -> B:17:0x0030). Please report as PlatformImplementations.kt_3 decompilation issue!!! */
        /* renamed from: PlatformImplementations.kt_3 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int mo4059a(int r6, int r7) {
            /*
                r5 = this;
                int r0 = r5.mo4058a(r6)
                r1 = 0
                if (r0 != r7) goto L8
                return r1
            L8:
                boolean r2 = r5.f3992c
                if (r2 == 0) goto L20
                android.util.SparseIntArray r2 = r5.f3990a
                int r2 = m4062a(r2, r6)
                if (r2 < 0) goto L20
                android.util.SparseIntArray r3 = r5.f3990a
                int r3 = r3.get(r2)
                int r4 = r5.mo4058a(r2)
                int r3 = r3 + r4
                goto L30
            L20:
                r2 = r1
                r3 = r2
            L22:
                if (r2 >= r6) goto L33
                int r4 = r5.mo4058a(r2)
                int r3 = r3 + r4
                if (r3 != r7) goto L2d
                r3 = r1
                goto L30
            L2d:
                if (r3 <= r7) goto L30
                r3 = r4
            L30:
                int r2 = r2 + 1
                goto L22
            L33:
                int r0 = r0 + r3
                if (r0 > r7) goto L37
                return r3
            L37:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.AbstractC0672c.mo4059a(int, int):int");
        }

        /* renamed from: PlatformImplementations.kt_3 */
        static int m4062a(SparseIntArray sparseIntArray, int OplusGLSurfaceView_13) {
            int size = sparseIntArray.size() - 1;
            int i2 = 0;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (sparseIntArray.keyAt(i3) < OplusGLSurfaceView_13) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            int i4 = i2 - 1;
            if (i4 < 0 || i4 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i4);
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public int m4067d(int OplusGLSurfaceView_13, int i2) {
            int iMo4058a;
            int i3;
            int i4;
            int iM4062a;
            if (!this.f3993d || (iM4062a = m4062a(this.f3991b, OplusGLSurfaceView_13)) == -1) {
                iMo4058a = 0;
                i3 = 0;
                i4 = 0;
            } else {
                i3 = this.f3991b.get(iM4062a);
                i4 = iM4062a + 1;
                iMo4058a = mo4058a(iM4062a) + m4064b(iM4062a, i2);
                if (iMo4058a == i2) {
                    i3++;
                    iMo4058a = 0;
                }
            }
            int iMo4058a2 = mo4058a(OplusGLSurfaceView_13);
            while (i4 < OplusGLSurfaceView_13) {
                int iMo4058a3 = mo4058a(i4);
                iMo4058a += iMo4058a3;
                if (iMo4058a == i2) {
                    i3++;
                    iMo4058a = 0;
                } else if (iMo4058a > i2) {
                    i3++;
                    iMo4058a = iMo4058a3;
                }
                i4++;
            }
            return iMo4058a + iMo4058a2 > i2 ? i3 + 1 : i3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x00d7, code lost:
    
        if (r13 == (r2 > r8)) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0105  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View onFocusSearchFailed(android.view.View r23, int r24, androidx.recyclerview.widget.RecyclerView.C0700p r25, androidx.recyclerview.widget.RecyclerView.C0704t r26) {
        /*
            Method dump skipped, instructions count: 333
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.RecyclerView$p, androidx.recyclerview.widget.RecyclerView$t):android.view.View");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && !this.f3979a;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public int computeHorizontalScrollRange(RecyclerView.C0704t c0704t) {
        if (this.f3987i) {
            return m4040a(c0704t);
        }
        return super.computeHorizontalScrollRange(c0704t);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public int computeVerticalScrollRange(RecyclerView.C0704t c0704t) {
        if (this.f3987i) {
            return m4040a(c0704t);
        }
        return super.computeVerticalScrollRange(c0704t);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public int computeHorizontalScrollOffset(RecyclerView.C0704t c0704t) {
        if (this.f3987i) {
            return m4048b(c0704t);
        }
        return super.computeHorizontalScrollOffset(c0704t);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public int computeVerticalScrollOffset(RecyclerView.C0704t c0704t) {
        if (this.f3987i) {
            return m4048b(c0704t);
        }
        return super.computeVerticalScrollOffset(c0704t);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m4040a(RecyclerView.C0704t c0704t) {
        if (getChildCount() != 0 && c0704t.m4230e() != 0) {
            ensureLayoutState();
            View viewFindFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled(), true);
            View viewFindFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled(), true);
            if (viewFindFirstVisibleChildClosestToStart != null && viewFindFirstVisibleChildClosestToEnd != null) {
                if (!isSmoothScrollbarEnabled()) {
                    return this.f3985g.m4066c(c0704t.m4230e() - 1, this.f3980b) + 1;
                }
                int iMo4501b = this.mOrientationHelper.mo4501b(viewFindFirstVisibleChildClosestToEnd) - this.mOrientationHelper.mo4498a(viewFindFirstVisibleChildClosestToStart);
                int iM4066c = this.f3985g.m4066c(getPosition(viewFindFirstVisibleChildClosestToStart), this.f3980b);
                return (int) ((iMo4501b / ((this.f3985g.m4066c(getPosition(viewFindFirstVisibleChildClosestToEnd), this.f3980b) - iM4066c) + 1)) * (this.f3985g.m4066c(c0704t.m4230e() - 1, this.f3980b) + 1));
            }
        }
        return 0;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int m4048b(RecyclerView.C0704t c0704t) {
        int iMax;
        if (getChildCount() != 0 && c0704t.m4230e() != 0) {
            ensureLayoutState();
            boolean zIsSmoothScrollbarEnabled = isSmoothScrollbarEnabled();
            View viewFindFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!zIsSmoothScrollbarEnabled, true);
            View viewFindFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!zIsSmoothScrollbarEnabled, true);
            if (viewFindFirstVisibleChildClosestToStart != null && viewFindFirstVisibleChildClosestToEnd != null) {
                int iM4066c = this.f3985g.m4066c(getPosition(viewFindFirstVisibleChildClosestToStart), this.f3980b);
                int iM4066c2 = this.f3985g.m4066c(getPosition(viewFindFirstVisibleChildClosestToEnd), this.f3980b);
                int iMin = Math.min(iM4066c, iM4066c2);
                int iMax2 = Math.max(iM4066c, iM4066c2);
                int iM4066c3 = this.f3985g.m4066c(c0704t.m4230e() - 1, this.f3980b) + 1;
                if (this.mShouldReverseLayout) {
                    iMax = Math.max(0, (iM4066c3 - iMax2) - 1);
                } else {
                    iMax = Math.max(0, iMin);
                }
                if (!zIsSmoothScrollbarEnabled) {
                    return iMax;
                }
                return Math.round((iMax * (Math.abs(this.mOrientationHelper.mo4501b(viewFindFirstVisibleChildClosestToEnd) - this.mOrientationHelper.mo4498a(viewFindFirstVisibleChildClosestToStart)) / ((this.f3985g.m4066c(getPosition(viewFindFirstVisibleChildClosestToEnd), this.f3980b) - this.f3985g.m4066c(getPosition(viewFindFirstVisibleChildClosestToStart), this.f3980b)) + 1))) + (this.mOrientationHelper.mo4505d() - this.mOrientationHelper.mo4498a(viewFindFirstVisibleChildClosestToStart)));
            }
        }
        return 0;
    }

    /* renamed from: androidx.recyclerview.widget.GridLayoutManager$PlatformImplementations.kt_3 */
    public static final class C0670a extends AbstractC0672c {
        @Override // androidx.recyclerview.widget.GridLayoutManager.AbstractC0672c
        /* renamed from: PlatformImplementations.kt_3 */
        public int mo4058a(int OplusGLSurfaceView_13) {
            return 1;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.AbstractC0672c
        /* renamed from: PlatformImplementations.kt_3 */
        public int mo4059a(int OplusGLSurfaceView_13, int i2) {
            return OplusGLSurfaceView_13 % i2;
        }
    }

    /* renamed from: androidx.recyclerview.widget.GridLayoutManager$IntrinsicsJvm.kt_4 */
    public static class C0671b extends RecyclerView.C0694j {

        /* renamed from: PlatformImplementations.kt_3 */
        int f3988a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        int f3989b;

        public C0671b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3988a = -1;
            this.f3989b = 0;
        }

        public C0671b(int OplusGLSurfaceView_13, int i2) {
            super(OplusGLSurfaceView_13, i2);
            this.f3988a = -1;
            this.f3989b = 0;
        }

        public C0671b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f3988a = -1;
            this.f3989b = 0;
        }

        public C0671b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f3988a = -1;
            this.f3989b = 0;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public int m4060a() {
            return this.f3988a;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public int m4061b() {
            return this.f3989b;
        }
    }
}
