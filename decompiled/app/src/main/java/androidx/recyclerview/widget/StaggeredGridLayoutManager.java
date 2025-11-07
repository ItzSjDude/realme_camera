package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.AbstractC0693i implements RecyclerView.AbstractC0703s.IntrinsicsJvm.kt_4 {

    /* renamed from: PlatformImplementations.kt_3 */
    C0713c[] f4090a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    OrientationHelper f4091b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    OrientationHelper f4092c;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f4099j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f4100k;

    /* renamed from: OplusGLSurfaceView_14 */
    private final LayoutState f4101l;

    /* renamed from: OplusGLSurfaceView_6 */
    private BitSet f4102m;

    /* renamed from: o */
    private boolean f4104o;

    /* renamed from: p */
    private boolean f4105p;

    /* renamed from: q */
    private SavedState f4106q;

    /* renamed from: r */
    private int f4107r;

    /* renamed from: w */
    private int[] f4112w;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f4098i = -1;

    /* renamed from: IntrinsicsJvm.kt_5 */
    boolean f4093d = false;

    /* renamed from: COUIBaseListPopupWindow_8 */
    boolean f4094e = false;

    /* renamed from: COUIBaseListPopupWindow_12 */
    int f4095f = -1;

    /* renamed from: COUIBaseListPopupWindow_11 */
    int f4096g = Integer.MIN_VALUE;

    /* renamed from: COUIBaseListPopupWindow_10 */
    LazySpanLookup f4097h = new LazySpanLookup();

    /* renamed from: OplusGLSurfaceView_11 */
    private int f4103n = 2;

    /* renamed from: s */
    private final Rect f4108s = new Rect();

    /* renamed from: t */
    private final C0711a f4109t = new C0711a();

    /* renamed from: u */
    private boolean f4110u = false;

    /* renamed from: v */
    private boolean f4111v = true;

    /* renamed from: x */
    private final Runnable f4113x = new Runnable() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.1
        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.m4283a();
        }
    };

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        RecyclerView.AbstractC0693i.IntrinsicsJvm.kt_4 properties = getProperties(context, attributeSet, OplusGLSurfaceView_13, i2);
        m4286b(properties.f4035a);
        m4279a(properties.f4036b);
        m4282a(properties.f4037c);
        this.f4101l = new LayoutState();
        m4270j();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public boolean isAutoMeasureEnabled() {
        return this.f4103n != 0;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m4270j() {
        this.f4091b = OrientationHelper.m4496a(this, this.f4099j);
        this.f4092c = OrientationHelper.m4496a(this, 1 - this.f4099j);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    boolean m4283a() {
        int iM4296i;
        int iM4295h;
        if (getChildCount() == 0 || this.f4103n == 0 || !isAttachedToWindow()) {
            return false;
        }
        if (this.f4094e) {
            iM4296i = m4295h();
            iM4295h = m4296i();
        } else {
            iM4296i = m4296i();
            iM4295h = m4295h();
        }
        if (iM4296i == 0 && m4284b() != null) {
            this.f4097h.m4302a();
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        }
        if (!this.f4110u) {
            return false;
        }
        int OplusGLSurfaceView_13 = this.f4094e ? -1 : 1;
        int i2 = iM4295h + 1;
        LazySpanLookup.FullSpanItem fullSpanItemM4301a = this.f4097h.m4301a(iM4296i, i2, OplusGLSurfaceView_13, true);
        if (fullSpanItemM4301a == null) {
            this.f4110u = false;
            this.f4097h.m4300a(i2);
            return false;
        }
        LazySpanLookup.FullSpanItem fullSpanItemM4301a2 = this.f4097h.m4301a(iM4296i, fullSpanItemM4301a.mPosition, OplusGLSurfaceView_13 * (-1), true);
        if (fullSpanItemM4301a2 == null) {
            this.f4097h.m4300a(fullSpanItemM4301a.mPosition);
        } else {
            this.f4097h.m4300a(fullSpanItemM4301a2.mPosition + 1);
        }
        requestSimpleAnimationsInNextLayout();
        requestLayout();
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public void onScrollStateChanged(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0) {
            m4283a();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.C0700p c0700p) {
        super.onDetachedFromWindow(recyclerView, c0700p);
        removeCallbacks(this.f4113x);
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f4098i; OplusGLSurfaceView_13++) {
            this.f4090a[OplusGLSurfaceView_13].m4336e();
        }
        recyclerView.requestLayout();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008a  */
    /* renamed from: IntrinsicsJvm.kt_4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    android.view.View m4284b() {
        /*
            r12 = this;
            int r0 = r12.getChildCount()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.f4098i
            r2.<init>(r3)
            int r3 = r12.f4098i
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r12.f4099j
            r5 = -1
            if (r3 != r1) goto L20
            boolean r3 = r12.m4291d()
            if (r3 == 0) goto L20
            r3 = r1
            goto L21
        L20:
            r3 = r5
        L21:
            boolean r6 = r12.f4094e
            if (r6 == 0) goto L27
            r6 = r5
            goto L2b
        L27:
            int r0 = r0 + 1
            r6 = r0
            r0 = r4
        L2b:
            if (r0 >= r6) goto L2e
            r5 = r1
        L2e:
            if (r0 == r6) goto Lab
            android.view.View r7 = r12.getChildAt(r0)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$IntrinsicsJvm.kt_4 r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.C0712b) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$IntrinsicsJvm.kt_3 r9 = r8.f4124a
            int r9 = r9.f4130e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L54
            androidx.recyclerview.widget.StaggeredGridLayoutManager$IntrinsicsJvm.kt_3 r9 = r8.f4124a
            boolean r9 = r12.m4253a(r9)
            if (r9 == 0) goto L4d
            return r7
        L4d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$IntrinsicsJvm.kt_3 r9 = r8.f4124a
            int r9 = r9.f4130e
            r2.clear(r9)
        L54:
            boolean r9 = r8.f4125b
            if (r9 == 0) goto L59
            goto La9
        L59:
            int r9 = r0 + r5
            if (r9 == r6) goto La9
            android.view.View r9 = r12.getChildAt(r9)
            boolean r10 = r12.f4094e
            if (r10 == 0) goto L77
            androidx.recyclerview.widget.OplusGLSurfaceView_11 r10 = r12.f4091b
            int r10 = r10.mo4501b(r7)
            androidx.recyclerview.widget.OplusGLSurfaceView_11 r11 = r12.f4091b
            int r11 = r11.mo4501b(r9)
            if (r10 >= r11) goto L74
            return r7
        L74:
            if (r10 != r11) goto L8a
            goto L88
        L77:
            androidx.recyclerview.widget.OplusGLSurfaceView_11 r10 = r12.f4091b
            int r10 = r10.mo4498a(r7)
            androidx.recyclerview.widget.OplusGLSurfaceView_11 r11 = r12.f4091b
            int r11 = r11.mo4498a(r9)
            if (r10 <= r11) goto L86
            return r7
        L86:
            if (r10 != r11) goto L8a
        L88:
            r10 = r1
            goto L8b
        L8a:
            r10 = r4
        L8b:
            if (r10 == 0) goto La9
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$IntrinsicsJvm.kt_4 r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.C0712b) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$IntrinsicsJvm.kt_3 r8 = r8.f4124a
            int r8 = r8.f4130e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$IntrinsicsJvm.kt_3 r9 = r9.f4124a
            int r9 = r9.f4130e
            int r8 = r8 - r9
            if (r8 >= 0) goto La0
            r8 = r1
            goto La1
        La0:
            r8 = r4
        La1:
            if (r3 >= 0) goto La5
            r9 = r1
            goto La6
        La5:
            r9 = r4
        La6:
            if (r8 == r9) goto La9
            return r7
        La9:
            int r0 = r0 + r5
            goto L2e
        Lab:
            r12 = 0
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.m4284b():android.view.View");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m4253a(C0713c c0713c) {
        if (this.f4094e) {
            if (c0713c.m4334d() < this.f4091b.mo4507e()) {
                return !c0713c.m4331c(c0713c.f4126a.get(c0713c.f4126a.size() - 1)).f4125b;
            }
        } else if (c0713c.m4328b() > this.f4091b.mo4505d()) {
            return !c0713c.m4331c(c0713c.f4126a.get(0)).f4125b;
        }
        return false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m4279a(int OplusGLSurfaceView_13) {
        assertNotInLayoutOrScroll(null);
        if (OplusGLSurfaceView_13 != this.f4098i) {
            m4289c();
            this.f4098i = OplusGLSurfaceView_13;
            this.f4102m = new BitSet(this.f4098i);
            this.f4090a = new C0713c[this.f4098i];
            for (int i2 = 0; i2 < this.f4098i; i2++) {
                this.f4090a[i2] = new C0713c(i2);
            }
            requestLayout();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m4286b(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 != 0 && OplusGLSurfaceView_13 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        assertNotInLayoutOrScroll(null);
        if (OplusGLSurfaceView_13 == this.f4099j) {
            return;
        }
        this.f4099j = OplusGLSurfaceView_13;
        OrientationHelper abstractC0727n = this.f4091b;
        this.f4091b = this.f4092c;
        this.f4092c = abstractC0727n;
        requestLayout();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m4282a(boolean z) {
        assertNotInLayoutOrScroll(null);
        SavedState savedState = this.f4106q;
        if (savedState != null && savedState.mReverseLayout != z) {
            this.f4106q.mReverseLayout = z;
        }
        this.f4093d = z;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public void assertNotInLayoutOrScroll(String str) {
        if (this.f4106q == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m4289c() {
        this.f4097h.m4302a();
        requestLayout();
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private void m4271k() {
        if (this.f4099j == 1 || !m4291d()) {
            this.f4094e = this.f4093d;
        } else {
            this.f4094e = !this.f4093d;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    boolean m4291d() {
        return getLayoutDirection() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public void setMeasuredDimension(Rect rect, int OplusGLSurfaceView_13, int i2) {
        int iChooseSize;
        int iChooseSize2;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.f4099j == 1) {
            iChooseSize2 = chooseSize(i2, rect.height() + paddingTop, getMinimumHeight());
            iChooseSize = chooseSize(OplusGLSurfaceView_13, (this.f4100k * this.f4098i) + paddingLeft, getMinimumWidth());
        } else {
            iChooseSize = chooseSize(OplusGLSurfaceView_13, rect.width() + paddingLeft, getMinimumWidth());
            iChooseSize2 = chooseSize(i2, (this.f4100k * this.f4098i) + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(iChooseSize, iChooseSize2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public void onLayoutChildren(RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t) {
        m4249a(c0700p, c0704t, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public void onAdapterChanged(RecyclerView.AbstractC0685a abstractC0685a, RecyclerView.AbstractC0685a abstractC0685a2) {
        this.f4097h.m4302a();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f4098i; OplusGLSurfaceView_13++) {
            this.f4090a[OplusGLSurfaceView_13].m4336e();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:89:0x0164  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m4249a(androidx.recyclerview.widget.RecyclerView.C0700p r9, androidx.recyclerview.widget.RecyclerView.C0704t r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 389
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.m4249a(androidx.recyclerview.widget.RecyclerView$p, androidx.recyclerview.widget.RecyclerView$t, boolean):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public void onLayoutCompleted(RecyclerView.C0704t c0704t) {
        super.onLayoutCompleted(c0704t);
        this.f4095f = -1;
        this.f4096g = Integer.MIN_VALUE;
        this.f4106q = null;
        this.f4109t.m4316a();
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private void m4274l() {
        if (this.f4092c.mo4513i() == 1073741824) {
            return;
        }
        int childCount = getChildCount();
        float fMax = 0.0f;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            View childAt = getChildAt(OplusGLSurfaceView_13);
            float fMo4508e = this.f4092c.mo4508e(childAt);
            if (fMo4508e >= fMax) {
                if (((C0712b) childAt.getLayoutParams()).m4320a()) {
                    fMo4508e = (fMo4508e * 1.0f) / this.f4098i;
                }
                fMax = Math.max(fMax, fMo4508e);
            }
        }
        int i2 = this.f4100k;
        int iRound = Math.round(fMax * this.f4098i);
        if (this.f4092c.mo4513i() == Integer.MIN_VALUE) {
            iRound = Math.min(iRound, this.f4092c.mo4511g());
        }
        m4290c(iRound);
        if (this.f4100k == i2) {
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt2 = getChildAt(i3);
            C0712b c0712b = (C0712b) childAt2.getLayoutParams();
            if (!c0712b.f4125b) {
                if (m4291d() && this.f4099j == 1) {
                    childAt2.offsetLeftAndRight(((-((this.f4098i - 1) - c0712b.f4124a.f4130e)) * this.f4100k) - ((-((this.f4098i - 1) - c0712b.f4124a.f4130e)) * i2));
                } else {
                    int i4 = c0712b.f4124a.f4130e * this.f4100k;
                    int i5 = c0712b.f4124a.f4130e * i2;
                    if (this.f4099j == 1) {
                        childAt2.offsetLeftAndRight(i4 - i5);
                    } else {
                        childAt2.offsetTopAndBottom(i4 - i5);
                    }
                }
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m4251a(C0711a c0711a) {
        int iMo4505d;
        if (this.f4106q.mSpanOffsetsSize > 0) {
            if (this.f4106q.mSpanOffsetsSize == this.f4098i) {
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f4098i; OplusGLSurfaceView_13++) {
                    this.f4090a[OplusGLSurfaceView_13].m4336e();
                    int i2 = this.f4106q.mSpanOffsets[OplusGLSurfaceView_13];
                    if (i2 != Integer.MIN_VALUE) {
                        if (this.f4106q.mAnchorLayoutFromEnd) {
                            iMo4505d = this.f4091b.mo4507e();
                        } else {
                            iMo4505d = this.f4091b.mo4505d();
                        }
                        i2 += iMo4505d;
                    }
                    this.f4090a[OplusGLSurfaceView_13].m4333c(i2);
                }
            } else {
                this.f4106q.invalidateSpanInfo();
                SavedState savedState = this.f4106q;
                savedState.mAnchorPosition = savedState.mVisibleAnchorPosition;
            }
        }
        this.f4105p = this.f4106q.mLastLayoutRTL;
        m4282a(this.f4106q.mReverseLayout);
        m4271k();
        if (this.f4106q.mAnchorPosition != -1) {
            this.f4095f = this.f4106q.mAnchorPosition;
            c0711a.f4119c = this.f4106q.mAnchorLayoutFromEnd;
        } else {
            c0711a.f4119c = this.f4094e;
        }
        if (this.f4106q.mSpanLookupSize > 1) {
            this.f4097h.f4115a = this.f4106q.mSpanLookup;
            this.f4097h.f4116b = this.f4106q.mFullSpanItems;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m4281a(RecyclerView.C0704t c0704t, C0711a c0711a) {
        if (m4287b(c0704t, c0711a) || m4262c(c0704t, c0711a)) {
            return;
        }
        c0711a.m4319b();
        c0711a.f4117a = 0;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean m4262c(RecyclerView.C0704t c0704t, C0711a c0711a) {
        int iM4275m;
        if (this.f4104o) {
            iM4275m = m4276n(c0704t.m4230e());
        } else {
            iM4275m = m4275m(c0704t.m4230e());
        }
        c0711a.f4117a = iM4275m;
        c0711a.f4118b = Integer.MIN_VALUE;
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    boolean m4287b(RecyclerView.C0704t c0704t, C0711a c0711a) {
        int OplusGLSurfaceView_13;
        int iMo4505d;
        if (!c0704t.m4226a() && (OplusGLSurfaceView_13 = this.f4095f) != -1) {
            if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 >= c0704t.m4230e()) {
                this.f4095f = -1;
                this.f4096g = Integer.MIN_VALUE;
            } else {
                SavedState savedState = this.f4106q;
                if (savedState == null || savedState.mAnchorPosition == -1 || this.f4106q.mSpanOffsetsSize < 1) {
                    View viewFindViewByPosition = findViewByPosition(this.f4095f);
                    if (viewFindViewByPosition != null) {
                        c0711a.f4117a = this.f4094e ? m4295h() : m4296i();
                        if (this.f4096g != Integer.MIN_VALUE) {
                            if (c0711a.f4119c) {
                                c0711a.f4118b = (this.f4091b.mo4507e() - this.f4096g) - this.f4091b.mo4501b(viewFindViewByPosition);
                            } else {
                                c0711a.f4118b = (this.f4091b.mo4505d() + this.f4096g) - this.f4091b.mo4498a(viewFindViewByPosition);
                            }
                            return true;
                        }
                        if (this.f4091b.mo4508e(viewFindViewByPosition) > this.f4091b.mo4511g()) {
                            if (c0711a.f4119c) {
                                iMo4505d = this.f4091b.mo4507e();
                            } else {
                                iMo4505d = this.f4091b.mo4505d();
                            }
                            c0711a.f4118b = iMo4505d;
                            return true;
                        }
                        int iMo4498a = this.f4091b.mo4498a(viewFindViewByPosition) - this.f4091b.mo4505d();
                        if (iMo4498a < 0) {
                            c0711a.f4118b = -iMo4498a;
                            return true;
                        }
                        int iMo4507e = this.f4091b.mo4507e() - this.f4091b.mo4501b(viewFindViewByPosition);
                        if (iMo4507e < 0) {
                            c0711a.f4118b = iMo4507e;
                            return true;
                        }
                        c0711a.f4118b = Integer.MIN_VALUE;
                    } else {
                        c0711a.f4117a = this.f4095f;
                        int i2 = this.f4096g;
                        if (i2 == Integer.MIN_VALUE) {
                            c0711a.f4119c = m4273l(c0711a.f4117a) == 1;
                            c0711a.m4319b();
                        } else {
                            c0711a.m4317a(i2);
                        }
                        c0711a.f4120d = true;
                    }
                } else {
                    c0711a.f4118b = Integer.MIN_VALUE;
                    c0711a.f4117a = this.f4095f;
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    void m4290c(int OplusGLSurfaceView_13) {
        this.f4100k = OplusGLSurfaceView_13 / this.f4098i;
        this.f4107r = View.MeasureSpec.makeMeasureSpec(OplusGLSurfaceView_13, this.f4092c.mo4513i());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public boolean supportsPredictiveItemAnimations() {
        return this.f4106q == null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public int computeHorizontalScrollOffset(RecyclerView.C0704t c0704t) {
        return m4241a(c0704t);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m4241a(RecyclerView.C0704t c0704t) {
        if (getChildCount() == 0) {
            return 0;
        }
        return ScrollbarHelper.m4526a(c0704t, this.f4091b, m4285b(!this.f4111v), m4288c(!this.f4111v), this, this.f4111v, this.f4094e);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public int computeVerticalScrollOffset(RecyclerView.C0704t c0704t) {
        return m4241a(c0704t);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public int computeHorizontalScrollExtent(RecyclerView.C0704t c0704t) {
        return m4254b(c0704t);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int m4254b(RecyclerView.C0704t c0704t) {
        if (getChildCount() == 0) {
            return 0;
        }
        return ScrollbarHelper.m4525a(c0704t, this.f4091b, m4285b(!this.f4111v), m4288c(!this.f4111v), this, this.f4111v);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public int computeVerticalScrollExtent(RecyclerView.C0704t c0704t) {
        return m4254b(c0704t);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public int computeHorizontalScrollRange(RecyclerView.C0704t c0704t) {
        return m4260c(c0704t);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int m4260c(RecyclerView.C0704t c0704t) {
        if (getChildCount() == 0) {
            return 0;
        }
        return ScrollbarHelper.m4527b(c0704t, this.f4091b, m4285b(!this.f4111v), m4288c(!this.f4111v), this, this.f4111v);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public int computeVerticalScrollRange(RecyclerView.C0704t c0704t) {
        return m4260c(c0704t);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m4247a(View view, C0712b c0712b, boolean z) {
        if (c0712b.f4125b) {
            if (this.f4099j == 1) {
                m4245a(view, this.f4107r, getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), c0712b.height, true), z);
                return;
            } else {
                m4245a(view, getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), c0712b.width, true), this.f4107r, z);
                return;
            }
        }
        if (this.f4099j == 1) {
            m4245a(view, getChildMeasureSpec(this.f4100k, getWidthMode(), 0, c0712b.width, false), getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), c0712b.height, true), z);
        } else {
            m4245a(view, getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), c0712b.width, true), getChildMeasureSpec(this.f4100k, getHeightMode(), 0, c0712b.height, false), z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m4245a(View view, int OplusGLSurfaceView_13, int i2, boolean z) {
        boolean zShouldMeasureChild;
        calculateItemDecorationsForChild(view, this.f4108s);
        C0712b c0712b = (C0712b) view.getLayoutParams();
        int iM4239a = m4239a(OplusGLSurfaceView_13, c0712b.leftMargin + this.f4108s.left, c0712b.rightMargin + this.f4108s.right);
        int iM4239a2 = m4239a(i2, c0712b.topMargin + this.f4108s.top, c0712b.bottomMargin + this.f4108s.bottom);
        if (z) {
            zShouldMeasureChild = shouldReMeasureChild(view, iM4239a, iM4239a2, c0712b);
        } else {
            zShouldMeasureChild = shouldMeasureChild(view, iM4239a, iM4239a2, c0712b);
        }
        if (zShouldMeasureChild) {
            view.measure(iM4239a, iM4239a2);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m4239a(int OplusGLSurfaceView_13, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return OplusGLSurfaceView_13;
        }
        int mode = View.MeasureSpec.getMode(OplusGLSurfaceView_13);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(OplusGLSurfaceView_13) - i2) - i3), mode) : OplusGLSurfaceView_13;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f4106q = (SavedState) parcelable;
            if (this.f4095f != -1) {
                this.f4106q.invalidateAnchorPositionInfo();
                this.f4106q.invalidateSpanInfo();
            }
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public Parcelable onSaveInstanceState() {
        int iM4321a;
        int iMo4505d;
        SavedState savedState = this.f4106q;
        if (savedState != null) {
            return new SavedState(savedState);
        }
        SavedState savedState2 = new SavedState();
        savedState2.mReverseLayout = this.f4093d;
        savedState2.mAnchorLayoutFromEnd = this.f4104o;
        savedState2.mLastLayoutRTL = this.f4105p;
        LazySpanLookup lazySpanLookup = this.f4097h;
        if (lazySpanLookup != null && lazySpanLookup.f4115a != null) {
            savedState2.mSpanLookup = this.f4097h.f4115a;
            savedState2.mSpanLookupSize = savedState2.mSpanLookup.length;
            savedState2.mFullSpanItems = this.f4097h.f4116b;
        } else {
            savedState2.mSpanLookupSize = 0;
        }
        if (getChildCount() > 0) {
            savedState2.mAnchorPosition = this.f4104o ? m4295h() : m4296i();
            savedState2.mVisibleAnchorPosition = m4292e();
            int OplusGLSurfaceView_13 = this.f4098i;
            savedState2.mSpanOffsetsSize = OplusGLSurfaceView_13;
            savedState2.mSpanOffsets = new int[OplusGLSurfaceView_13];
            for (int i2 = 0; i2 < this.f4098i; i2++) {
                if (this.f4104o) {
                    iM4321a = this.f4090a[i2].m4329b(Integer.MIN_VALUE);
                    if (iM4321a != Integer.MIN_VALUE) {
                        iMo4505d = this.f4091b.mo4507e();
                        iM4321a -= iMo4505d;
                    }
                } else {
                    iM4321a = this.f4090a[i2].m4321a(Integer.MIN_VALUE);
                    if (iM4321a != Integer.MIN_VALUE) {
                        iMo4505d = this.f4091b.mo4505d();
                        iM4321a -= iMo4505d;
                    }
                }
                savedState2.mSpanOffsets[i2] = iM4321a;
            }
        } else {
            savedState2.mAnchorPosition = -1;
            savedState2.mVisibleAnchorPosition = -1;
            savedState2.mSpanOffsetsSize = 0;
        }
        return savedState2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View viewM4285b = m4285b(false);
            View viewM4288c = m4288c(false);
            if (viewM4285b == null || viewM4288c == null) {
                return;
            }
            int position = getPosition(viewM4285b);
            int position2 = getPosition(viewM4288c);
            if (position < position2) {
                accessibilityEvent.setFromIndex(position);
                accessibilityEvent.setToIndex(position2);
            } else {
                accessibilityEvent.setFromIndex(position2);
                accessibilityEvent.setToIndex(position);
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    int m4292e() {
        View viewM4288c = this.f4094e ? m4288c(true) : m4285b(true);
        if (viewM4288c == null) {
            return -1;
        }
        return getPosition(viewM4288c);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    View m4285b(boolean z) {
        int iMo4505d = this.f4091b.mo4505d();
        int iMo4507e = this.f4091b.mo4507e();
        int childCount = getChildCount();
        View view = null;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            View childAt = getChildAt(OplusGLSurfaceView_13);
            int iMo4498a = this.f4091b.mo4498a(childAt);
            if (this.f4091b.mo4501b(childAt) > iMo4505d && iMo4498a < iMo4507e) {
                if (iMo4498a >= iMo4505d || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    View m4288c(boolean z) {
        int iMo4505d = this.f4091b.mo4505d();
        int iMo4507e = this.f4091b.mo4507e();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int iMo4498a = this.f4091b.mo4498a(childAt);
            int iMo4501b = this.f4091b.mo4501b(childAt);
            if (iMo4501b > iMo4505d && iMo4498a < iMo4507e) {
                if (iMo4501b <= iMo4507e || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m4259b(RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t, boolean z) {
        int iMo4507e;
        int iM4268i = m4268i(Integer.MIN_VALUE);
        if (iM4268i != Integer.MIN_VALUE && (iMo4507e = this.f4091b.mo4507e() - iM4268i) > 0) {
            int OplusGLSurfaceView_13 = iMo4507e - (-m4278a(-iMo4507e, c0700p, c0704t));
            if (!z || OplusGLSurfaceView_13 <= 0) {
                return;
            }
            this.f4091b.mo4500a(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m4261c(RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t, boolean z) {
        int iMo4505d;
        int iM4267h = m4267h(Integer.MAX_VALUE);
        if (iM4267h != Integer.MAX_VALUE && (iMo4505d = iM4267h - this.f4091b.mo4505d()) > 0) {
            int iM4278a = iMo4505d - m4278a(iMo4505d, c0700p, c0704t);
            if (!z || iM4278a <= 0) {
                return;
            }
            this.f4091b.mo4500a(-iM4278a);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m4256b(int OplusGLSurfaceView_13, RecyclerView.C0704t c0704t) {
        int iMo4511g;
        int iMo4511g2;
        int iM4228c;
        LayoutState c0722i = this.f4101l;
        boolean z = false;
        c0722i.f4283b = 0;
        c0722i.f4284c = OplusGLSurfaceView_13;
        if (!isSmoothScrolling() || (iM4228c = c0704t.m4228c()) == -1) {
            iMo4511g = 0;
            iMo4511g2 = 0;
        } else {
            if (this.f4094e == (iM4228c < OplusGLSurfaceView_13)) {
                iMo4511g = this.f4091b.mo4511g();
                iMo4511g2 = 0;
            } else {
                iMo4511g2 = this.f4091b.mo4511g();
                iMo4511g = 0;
            }
        }
        if (getClipToPadding()) {
            this.f4101l.f4287f = this.f4091b.mo4505d() - iMo4511g2;
            this.f4101l.f4288g = this.f4091b.mo4507e() + iMo4511g;
        } else {
            this.f4101l.f4288g = this.f4091b.mo4509f() + iMo4511g;
            this.f4101l.f4287f = -iMo4511g2;
        }
        LayoutState c0722i2 = this.f4101l;
        c0722i2.f4289h = false;
        c0722i2.f4282a = true;
        if (this.f4091b.mo4513i() == 0 && this.f4091b.mo4509f() == 0) {
            z = true;
        }
        c0722i2.f4290i = z;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m4263d(int OplusGLSurfaceView_13) {
        LayoutState c0722i = this.f4101l;
        c0722i.f4286e = OplusGLSurfaceView_13;
        c0722i.f4285d = this.f4094e != (OplusGLSurfaceView_13 == -1) ? -1 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public void offsetChildrenHorizontal(int OplusGLSurfaceView_13) {
        super.offsetChildrenHorizontal(OplusGLSurfaceView_13);
        for (int i2 = 0; i2 < this.f4098i; i2++) {
            this.f4090a[i2].m4335d(OplusGLSurfaceView_13);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public void offsetChildrenVertical(int OplusGLSurfaceView_13) {
        super.offsetChildrenVertical(OplusGLSurfaceView_13);
        for (int i2 = 0; i2 < this.f4098i; i2++) {
            this.f4090a[i2].m4335d(OplusGLSurfaceView_13);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public void onItemsRemoved(RecyclerView recyclerView, int OplusGLSurfaceView_13, int i2) {
        m4255b(OplusGLSurfaceView_13, i2, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public void onItemsAdded(RecyclerView recyclerView, int OplusGLSurfaceView_13, int i2) {
        m4255b(OplusGLSurfaceView_13, i2, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public void onItemsChanged(RecyclerView recyclerView) {
        this.f4097h.m4302a();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public void onItemsMoved(RecyclerView recyclerView, int OplusGLSurfaceView_13, int i2, int i3) {
        m4255b(OplusGLSurfaceView_13, i2, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public void onItemsUpdated(RecyclerView recyclerView, int OplusGLSurfaceView_13, int i2, Object obj) {
        m4255b(OplusGLSurfaceView_13, i2, 4);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0045 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0046  */
    /* renamed from: IntrinsicsJvm.kt_4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m4255b(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.f4094e
            if (r0 == 0) goto L9
            int r0 = r6.m4295h()
            goto Ld
        L9:
            int r0 = r6.m4296i()
        Ld:
            r1 = 8
            if (r9 != r1) goto L1b
            if (r7 >= r8) goto L16
            int r2 = r8 + 1
            goto L1d
        L16:
            int r2 = r7 + 1
            r3 = r2
            r2 = r8
            goto L1f
        L1b:
            int r2 = r7 + r8
        L1d:
            r3 = r2
            r2 = r7
        L1f:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r4 = r6.f4097h
            r4.m4306b(r2)
            r4 = 1
            if (r9 == r4) goto L3e
            r5 = 2
            if (r9 == r5) goto L38
            if (r9 == r1) goto L2d
            goto L43
        L2d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.f4097h
            r9.m4303a(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r7 = r6.f4097h
            r7.m4307b(r8, r4)
            goto L43
        L38:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.f4097h
            r9.m4303a(r7, r8)
            goto L43
        L3e:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.f4097h
            r9.m4307b(r7, r8)
        L43:
            if (r3 > r0) goto L46
            return
        L46:
            boolean r7 = r6.f4094e
            if (r7 == 0) goto L4f
            int r7 = r6.m4296i()
            goto L53
        L4f:
            int r7 = r6.m4295h()
        L53:
            if (r2 > r7) goto L58
            r6.requestLayout()
        L58:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.m4255b(int, int, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* renamed from: PlatformImplementations.kt_3 */
    private int m4240a(RecyclerView.C0700p c0700p, LayoutState c0722i, RecyclerView.C0704t c0704t) {
        int OplusGLSurfaceView_13;
        int iMo4505d;
        int iM4268i;
        C0713c c0713cM4242a;
        int iMo4508e;
        int i2;
        int iMo4508e2;
        int iMo4508e3;
        boolean z;
        boolean zM4294g;
        ?? r9 = 0;
        this.f4102m.set(0, this.f4098i, true);
        if (this.f4101l.f4290i) {
            OplusGLSurfaceView_13 = c0722i.f4286e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else if (c0722i.f4286e == 1) {
            OplusGLSurfaceView_13 = c0722i.f4288g + c0722i.f4283b;
        } else {
            OplusGLSurfaceView_13 = c0722i.f4287f - c0722i.f4283b;
        }
        int i3 = OplusGLSurfaceView_13;
        m4243a(c0722i.f4286e, i3);
        if (this.f4094e) {
            iMo4505d = this.f4091b.mo4507e();
        } else {
            iMo4505d = this.f4091b.mo4505d();
        }
        int i4 = iMo4505d;
        boolean z2 = false;
        while (c0722i.m4479a(c0704t) && (this.f4101l.f4290i || !this.f4102m.isEmpty())) {
            View viewM4478a = c0722i.m4478a(c0700p);
            C0712b c0712b = (C0712b) viewM4478a.getLayoutParams();
            int iF = c0712b.m4157f();
            int iM4308c = this.f4097h.m4308c(iF);
            boolean z3 = iM4308c == -1 ? true : r9;
            if (z3) {
                c0713cM4242a = c0712b.f4125b ? this.f4090a[r9] : m4242a(c0722i);
                this.f4097h.m4304a(iF, c0713cM4242a);
            } else {
                c0713cM4242a = this.f4090a[iM4308c];
            }
            C0713c c0713c = c0713cM4242a;
            c0712b.f4124a = c0713c;
            if (c0722i.f4286e == 1) {
                addView(viewM4478a);
            } else {
                addView(viewM4478a, r9);
            }
            m4247a(viewM4478a, c0712b, (boolean) r9);
            if (c0722i.f4286e == 1) {
                int iM4268i2 = c0712b.f4125b ? m4268i(i4) : c0713c.m4329b(i4);
                int iMo4508e4 = this.f4091b.mo4508e(viewM4478a) + iM4268i2;
                if (z3 && c0712b.f4125b) {
                    LazySpanLookup.FullSpanItem fullSpanItemM4264e = m4264e(iM4268i2);
                    fullSpanItemM4264e.mGapDir = -1;
                    fullSpanItemM4264e.mPosition = iF;
                    this.f4097h.m4305a(fullSpanItemM4264e);
                }
                i2 = iMo4508e4;
                iMo4508e = iM4268i2;
            } else {
                int iM4267h = c0712b.f4125b ? m4267h(i4) : c0713c.m4321a(i4);
                iMo4508e = iM4267h - this.f4091b.mo4508e(viewM4478a);
                if (z3 && c0712b.f4125b) {
                    LazySpanLookup.FullSpanItem fullSpanItemM4265f = m4265f(iM4267h);
                    fullSpanItemM4265f.mGapDir = 1;
                    fullSpanItemM4265f.mPosition = iF;
                    this.f4097h.m4305a(fullSpanItemM4265f);
                }
                i2 = iM4267h;
            }
            if (c0712b.f4125b && c0722i.f4285d == -1) {
                if (z3) {
                    this.f4110u = true;
                } else {
                    if (c0722i.f4286e == 1) {
                        zM4294g = m4293f();
                    } else {
                        zM4294g = m4294g();
                    }
                    if (!zM4294g) {
                        LazySpanLookup.FullSpanItem fullSpanItemM4311f = this.f4097h.m4311f(iF);
                        if (fullSpanItemM4311f != null) {
                            fullSpanItemM4311f.mHasUnwantedGapAfter = true;
                        }
                        this.f4110u = true;
                    }
                }
            }
            m4246a(viewM4478a, c0712b, c0722i);
            if (m4291d() && this.f4099j == 1) {
                int iMo4507e = c0712b.f4125b ? this.f4092c.mo4507e() : this.f4092c.mo4507e() - (((this.f4098i - 1) - c0713c.f4130e) * this.f4100k);
                iMo4508e3 = iMo4507e;
                iMo4508e2 = iMo4507e - this.f4092c.mo4508e(viewM4478a);
            } else {
                int iMo4505d2 = c0712b.f4125b ? this.f4092c.mo4505d() : (c0713c.f4130e * this.f4100k) + this.f4092c.mo4505d();
                iMo4508e2 = iMo4505d2;
                iMo4508e3 = this.f4092c.mo4508e(viewM4478a) + iMo4505d2;
            }
            if (this.f4099j == 1) {
                layoutDecoratedWithMargins(viewM4478a, iMo4508e2, iMo4508e, iMo4508e3, i2);
            } else {
                layoutDecoratedWithMargins(viewM4478a, iMo4508e, iMo4508e2, i2, iMo4508e3);
            }
            if (c0712b.f4125b) {
                m4243a(this.f4101l.f4286e, i3);
            } else {
                m4252a(c0713c, this.f4101l.f4286e, i3);
            }
            m4250a(c0700p, this.f4101l);
            if (!this.f4101l.f4289h || !viewM4478a.hasFocusable()) {
                z = false;
            } else if (c0712b.f4125b) {
                this.f4102m.clear();
                z = false;
            } else {
                z = false;
                this.f4102m.set(c0713c.f4130e, false);
            }
            r9 = z;
            z2 = true;
        }
        int i5 = r9;
        if (!z2) {
            m4250a(c0700p, this.f4101l);
        }
        if (this.f4101l.f4286e == -1) {
            iM4268i = this.f4091b.mo4505d() - m4267h(this.f4091b.mo4505d());
        } else {
            iM4268i = m4268i(this.f4091b.mo4507e()) - this.f4091b.mo4507e();
        }
        return iM4268i > 0 ? Math.min(c0722i.f4283b, iM4268i) : i5;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private LazySpanLookup.FullSpanItem m4264e(int OplusGLSurfaceView_13) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.mGapPerSpan = new int[this.f4098i];
        for (int i2 = 0; i2 < this.f4098i; i2++) {
            fullSpanItem.mGapPerSpan[i2] = OplusGLSurfaceView_13 - this.f4090a[i2].m4329b(OplusGLSurfaceView_13);
        }
        return fullSpanItem;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private LazySpanLookup.FullSpanItem m4265f(int OplusGLSurfaceView_13) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.mGapPerSpan = new int[this.f4098i];
        for (int i2 = 0; i2 < this.f4098i; i2++) {
            fullSpanItem.mGapPerSpan[i2] = this.f4090a[i2].m4321a(OplusGLSurfaceView_13) - OplusGLSurfaceView_13;
        }
        return fullSpanItem;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m4246a(View view, C0712b c0712b, LayoutState c0722i) {
        if (c0722i.f4286e == 1) {
            if (c0712b.f4125b) {
                m4244a(view);
                return;
            } else {
                c0712b.f4124a.m4330b(view);
                return;
            }
        }
        if (c0712b.f4125b) {
            m4257b(view);
        } else {
            c0712b.f4124a.m4326a(view);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m4250a(RecyclerView.C0700p c0700p, LayoutState c0722i) {
        int iMin;
        int iMin2;
        if (!c0722i.f4282a || c0722i.f4290i) {
            return;
        }
        if (c0722i.f4283b == 0) {
            if (c0722i.f4286e == -1) {
                m4258b(c0700p, c0722i.f4288g);
                return;
            } else {
                m4248a(c0700p, c0722i.f4287f);
                return;
            }
        }
        if (c0722i.f4286e == -1) {
            int iM4266g = c0722i.f4287f - m4266g(c0722i.f4287f);
            if (iM4266g < 0) {
                iMin2 = c0722i.f4288g;
            } else {
                iMin2 = c0722i.f4288g - Math.min(iM4266g, c0722i.f4283b);
            }
            m4258b(c0700p, iMin2);
            return;
        }
        int iM4269j = m4269j(c0722i.f4288g) - c0722i.f4288g;
        if (iM4269j < 0) {
            iMin = c0722i.f4287f;
        } else {
            iMin = Math.min(iM4269j, c0722i.f4283b) + c0722i.f4287f;
        }
        m4248a(c0700p, iMin);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m4244a(View view) {
        for (int OplusGLSurfaceView_13 = this.f4098i - 1; OplusGLSurfaceView_13 >= 0; OplusGLSurfaceView_13--) {
            this.f4090a[OplusGLSurfaceView_13].m4330b(view);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m4257b(View view) {
        for (int OplusGLSurfaceView_13 = this.f4098i - 1; OplusGLSurfaceView_13 >= 0; OplusGLSurfaceView_13--) {
            this.f4090a[OplusGLSurfaceView_13].m4326a(view);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m4243a(int OplusGLSurfaceView_13, int i2) {
        for (int i3 = 0; i3 < this.f4098i; i3++) {
            if (!this.f4090a[i3].f4126a.isEmpty()) {
                m4252a(this.f4090a[i3], OplusGLSurfaceView_13, i2);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m4252a(C0713c c0713c, int OplusGLSurfaceView_13, int i2) {
        int iM4340i = c0713c.m4340i();
        if (OplusGLSurfaceView_13 == -1) {
            if (c0713c.m4328b() + iM4340i <= i2) {
                this.f4102m.set(c0713c.f4130e, false);
            }
        } else if (c0713c.m4334d() - iM4340i >= i2) {
            this.f4102m.set(c0713c.f4130e, false);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int m4266g(int OplusGLSurfaceView_13) {
        int iM4321a = this.f4090a[0].m4321a(OplusGLSurfaceView_13);
        for (int i2 = 1; i2 < this.f4098i; i2++) {
            int iM4321a2 = this.f4090a[i2].m4321a(OplusGLSurfaceView_13);
            if (iM4321a2 > iM4321a) {
                iM4321a = iM4321a2;
            }
        }
        return iM4321a;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int m4267h(int OplusGLSurfaceView_13) {
        int iM4321a = this.f4090a[0].m4321a(OplusGLSurfaceView_13);
        for (int i2 = 1; i2 < this.f4098i; i2++) {
            int iM4321a2 = this.f4090a[i2].m4321a(OplusGLSurfaceView_13);
            if (iM4321a2 < iM4321a) {
                iM4321a = iM4321a2;
            }
        }
        return iM4321a;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    boolean m4293f() {
        int iM4329b = this.f4090a[0].m4329b(Integer.MIN_VALUE);
        for (int OplusGLSurfaceView_13 = 1; OplusGLSurfaceView_13 < this.f4098i; OplusGLSurfaceView_13++) {
            if (this.f4090a[OplusGLSurfaceView_13].m4329b(Integer.MIN_VALUE) != iM4329b) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    boolean m4294g() {
        int iM4321a = this.f4090a[0].m4321a(Integer.MIN_VALUE);
        for (int OplusGLSurfaceView_13 = 1; OplusGLSurfaceView_13 < this.f4098i; OplusGLSurfaceView_13++) {
            if (this.f4090a[OplusGLSurfaceView_13].m4321a(Integer.MIN_VALUE) != iM4321a) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private int m4268i(int OplusGLSurfaceView_13) {
        int iM4329b = this.f4090a[0].m4329b(OplusGLSurfaceView_13);
        for (int i2 = 1; i2 < this.f4098i; i2++) {
            int iM4329b2 = this.f4090a[i2].m4329b(OplusGLSurfaceView_13);
            if (iM4329b2 > iM4329b) {
                iM4329b = iM4329b2;
            }
        }
        return iM4329b;
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private int m4269j(int OplusGLSurfaceView_13) {
        int iM4329b = this.f4090a[0].m4329b(OplusGLSurfaceView_13);
        for (int i2 = 1; i2 < this.f4098i; i2++) {
            int iM4329b2 = this.f4090a[i2].m4329b(OplusGLSurfaceView_13);
            if (iM4329b2 < iM4329b) {
                iM4329b = iM4329b2;
            }
        }
        return iM4329b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m4248a(RecyclerView.C0700p c0700p, int OplusGLSurfaceView_13) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.f4091b.mo4501b(childAt) > OplusGLSurfaceView_13 || this.f4091b.mo4504c(childAt) > OplusGLSurfaceView_13) {
                return;
            }
            C0712b c0712b = (C0712b) childAt.getLayoutParams();
            if (c0712b.f4125b) {
                for (int i2 = 0; i2 < this.f4098i; i2++) {
                    if (this.f4090a[i2].f4126a.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.f4098i; i3++) {
                    this.f4090a[i3].m4339h();
                }
            } else if (c0712b.f4124a.f4126a.size() == 1) {
                return;
            } else {
                c0712b.f4124a.m4339h();
            }
            removeAndRecycleView(childAt, c0700p);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m4258b(RecyclerView.C0700p c0700p, int OplusGLSurfaceView_13) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (this.f4091b.mo4498a(childAt) < OplusGLSurfaceView_13 || this.f4091b.mo4506d(childAt) < OplusGLSurfaceView_13) {
                return;
            }
            C0712b c0712b = (C0712b) childAt.getLayoutParams();
            if (c0712b.f4125b) {
                for (int i2 = 0; i2 < this.f4098i; i2++) {
                    if (this.f4090a[i2].f4126a.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.f4098i; i3++) {
                    this.f4090a[i3].m4338g();
                }
            } else if (c0712b.f4124a.f4126a.size() == 1) {
                return;
            } else {
                c0712b.f4124a.m4338g();
            }
            removeAndRecycleView(childAt, c0700p);
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean m4272k(int OplusGLSurfaceView_13) {
        if (this.f4099j == 0) {
            return (OplusGLSurfaceView_13 == -1) != this.f4094e;
        }
        return ((OplusGLSurfaceView_13 == -1) == this.f4094e) == m4291d();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private C0713c m4242a(LayoutState c0722i) {
        int OplusGLSurfaceView_13;
        int i2;
        int i3 = -1;
        if (m4272k(c0722i.f4286e)) {
            OplusGLSurfaceView_13 = this.f4098i - 1;
            i2 = -1;
        } else {
            OplusGLSurfaceView_13 = 0;
            i3 = this.f4098i;
            i2 = 1;
        }
        C0713c c0713c = null;
        if (c0722i.f4286e == 1) {
            int i4 = Integer.MAX_VALUE;
            int iMo4505d = this.f4091b.mo4505d();
            while (OplusGLSurfaceView_13 != i3) {
                C0713c c0713c2 = this.f4090a[OplusGLSurfaceView_13];
                int iM4329b = c0713c2.m4329b(iMo4505d);
                if (iM4329b < i4) {
                    c0713c = c0713c2;
                    i4 = iM4329b;
                }
                OplusGLSurfaceView_13 += i2;
            }
            return c0713c;
        }
        int i5 = Integer.MIN_VALUE;
        int iMo4507e = this.f4091b.mo4507e();
        while (OplusGLSurfaceView_13 != i3) {
            C0713c c0713c3 = this.f4090a[OplusGLSurfaceView_13];
            int iM4321a = c0713c3.m4321a(iMo4507e);
            if (iM4321a > i5) {
                c0713c = c0713c3;
                i5 = iM4321a;
            }
            OplusGLSurfaceView_13 += i2;
        }
        return c0713c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public boolean canScrollVertically() {
        return this.f4099j == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public boolean canScrollHorizontally() {
        return this.f4099j == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public int scrollHorizontallyBy(int OplusGLSurfaceView_13, RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t) {
        return m4278a(OplusGLSurfaceView_13, c0700p, c0704t);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public int scrollVerticallyBy(int OplusGLSurfaceView_13, RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t) {
        return m4278a(OplusGLSurfaceView_13, c0700p, c0704t);
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private int m4273l(int OplusGLSurfaceView_13) {
        if (getChildCount() == 0) {
            return this.f4094e ? 1 : -1;
        }
        return (OplusGLSurfaceView_13 < m4296i()) != this.f4094e ? -1 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0703s.IntrinsicsJvm.kt_4
    public PointF computeScrollVectorForPosition(int OplusGLSurfaceView_13) {
        int iM4273l = m4273l(OplusGLSurfaceView_13);
        PointF pointF = new PointF();
        if (iM4273l == 0) {
            return null;
        }
        if (this.f4099j == 0) {
            pointF.x = iM4273l;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = iM4273l;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.C0704t c0704t, int OplusGLSurfaceView_13) {
        LinearSmoothScroller c0723j = new LinearSmoothScroller(recyclerView.getContext());
        c0723j.setTargetPosition(OplusGLSurfaceView_13);
        startSmoothScroll(c0723j);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public void scrollToPosition(int OplusGLSurfaceView_13) {
        SavedState savedState = this.f4106q;
        if (savedState != null && savedState.mAnchorPosition != OplusGLSurfaceView_13) {
            this.f4106q.invalidateAnchorPositionInfo();
        }
        this.f4095f = OplusGLSurfaceView_13;
        this.f4096g = Integer.MIN_VALUE;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public void collectAdjacentPrefetchPositions(int OplusGLSurfaceView_13, int i2, RecyclerView.C0704t c0704t, RecyclerView.AbstractC0693i.PlatformImplementations.kt_3 aVar) {
        int iM4329b;
        int iM4321a;
        if (this.f4099j != 0) {
            OplusGLSurfaceView_13 = i2;
        }
        if (getChildCount() == 0 || OplusGLSurfaceView_13 == 0) {
            return;
        }
        m4280a(OplusGLSurfaceView_13, c0704t);
        int[] iArr = this.f4112w;
        if (iArr == null || iArr.length < this.f4098i) {
            this.f4112w = new int[this.f4098i];
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f4098i; i4++) {
            if (this.f4101l.f4285d == -1) {
                iM4329b = this.f4101l.f4287f;
                iM4321a = this.f4090a[i4].m4321a(this.f4101l.f4287f);
            } else {
                iM4329b = this.f4090a[i4].m4329b(this.f4101l.f4288g);
                iM4321a = this.f4101l.f4288g;
            }
            int i5 = iM4329b - iM4321a;
            if (i5 >= 0) {
                this.f4112w[i3] = i5;
                i3++;
            }
        }
        Arrays.sort(this.f4112w, 0, i3);
        for (int i6 = 0; i6 < i3 && this.f4101l.m4479a(c0704t); i6++) {
            aVar.mo4153b(this.f4101l.f4284c, this.f4112w[i6]);
            this.f4101l.f4284c += this.f4101l.f4285d;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m4280a(int OplusGLSurfaceView_13, RecyclerView.C0704t c0704t) {
        int i2;
        int iM4296i;
        if (OplusGLSurfaceView_13 > 0) {
            iM4296i = m4295h();
            i2 = 1;
        } else {
            i2 = -1;
            iM4296i = m4296i();
        }
        this.f4101l.f4282a = true;
        m4256b(iM4296i, c0704t);
        m4263d(i2);
        LayoutState c0722i = this.f4101l;
        c0722i.f4284c = iM4296i + c0722i.f4285d;
        this.f4101l.f4283b = Math.abs(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    int m4278a(int OplusGLSurfaceView_13, RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t) {
        if (getChildCount() == 0 || OplusGLSurfaceView_13 == 0) {
            return 0;
        }
        m4280a(OplusGLSurfaceView_13, c0704t);
        int iM4240a = m4240a(c0700p, this.f4101l, c0704t);
        if (this.f4101l.f4283b >= iM4240a) {
            OplusGLSurfaceView_13 = OplusGLSurfaceView_13 < 0 ? -iM4240a : iM4240a;
        }
        this.f4091b.mo4500a(-OplusGLSurfaceView_13);
        this.f4104o = this.f4094e;
        LayoutState c0722i = this.f4101l;
        c0722i.f4283b = 0;
        m4250a(c0700p, c0722i);
        return OplusGLSurfaceView_13;
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    int m4295h() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    /* renamed from: OplusGLSurfaceView_13 */
    int m4296i() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private int m4275m(int OplusGLSurfaceView_13) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            int position = getPosition(getChildAt(i2));
            if (position >= 0 && position < OplusGLSurfaceView_13) {
                return position;
            }
        }
        return 0;
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private int m4276n(int OplusGLSurfaceView_13) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            int position = getPosition(getChildAt(childCount));
            if (position >= 0 && position < OplusGLSurfaceView_13) {
                return position;
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public RecyclerView.C0694j generateDefaultLayoutParams() {
        if (this.f4099j == 0) {
            return new C0712b(-2, -1);
        }
        return new C0712b(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public RecyclerView.C0694j generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new C0712b(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public RecyclerView.C0694j generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new C0712b((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new C0712b(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public boolean checkLayoutParams(RecyclerView.C0694j c0694j) {
        return c0694j instanceof C0712b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0693i
    public View onFocusSearchFailed(View view, int OplusGLSurfaceView_13, RecyclerView.C0700p c0700p, RecyclerView.C0704t c0704t) {
        View viewFindContainingItemView;
        int iM4296i;
        int iM4342k;
        int iM4342k2;
        int iM4342k3;
        View viewM4324a;
        if (getChildCount() == 0 || (viewFindContainingItemView = findContainingItemView(view)) == null) {
            return null;
        }
        m4271k();
        int iM4277o = m4277o(OplusGLSurfaceView_13);
        if (iM4277o == Integer.MIN_VALUE) {
            return null;
        }
        C0712b c0712b = (C0712b) viewFindContainingItemView.getLayoutParams();
        boolean z = c0712b.f4125b;
        C0713c c0713c = c0712b.f4124a;
        if (iM4277o == 1) {
            iM4296i = m4295h();
        } else {
            iM4296i = m4296i();
        }
        m4256b(iM4296i, c0704t);
        m4263d(iM4277o);
        LayoutState c0722i = this.f4101l;
        c0722i.f4284c = c0722i.f4285d + iM4296i;
        this.f4101l.f4283b = (int) (this.f4091b.mo4511g() * 0.33333334f);
        LayoutState c0722i2 = this.f4101l;
        c0722i2.f4289h = true;
        c0722i2.f4282a = false;
        m4240a(c0700p, c0722i2, c0704t);
        this.f4104o = this.f4094e;
        if (!z && (viewM4324a = c0713c.m4324a(iM4296i, iM4277o)) != null && viewM4324a != viewFindContainingItemView) {
            return viewM4324a;
        }
        if (m4272k(iM4277o)) {
            for (int i2 = this.f4098i - 1; i2 >= 0; i2--) {
                View viewM4324a2 = this.f4090a[i2].m4324a(iM4296i, iM4277o);
                if (viewM4324a2 != null && viewM4324a2 != viewFindContainingItemView) {
                    return viewM4324a2;
                }
            }
        } else {
            for (int i3 = 0; i3 < this.f4098i; i3++) {
                View viewM4324a3 = this.f4090a[i3].m4324a(iM4296i, iM4277o);
                if (viewM4324a3 != null && viewM4324a3 != viewFindContainingItemView) {
                    return viewM4324a3;
                }
            }
        }
        boolean z2 = (this.f4093d ^ true) == (iM4277o == -1);
        if (!z) {
            if (z2) {
                iM4342k3 = c0713c.m4341j();
            } else {
                iM4342k3 = c0713c.m4342k();
            }
            View viewFindViewByPosition = findViewByPosition(iM4342k3);
            if (viewFindViewByPosition != null && viewFindViewByPosition != viewFindContainingItemView) {
                return viewFindViewByPosition;
            }
        }
        if (m4272k(iM4277o)) {
            for (int i4 = this.f4098i - 1; i4 >= 0; i4--) {
                if (i4 != c0713c.f4130e) {
                    if (z2) {
                        iM4342k2 = this.f4090a[i4].m4341j();
                    } else {
                        iM4342k2 = this.f4090a[i4].m4342k();
                    }
                    View viewFindViewByPosition2 = findViewByPosition(iM4342k2);
                    if (viewFindViewByPosition2 != null && viewFindViewByPosition2 != viewFindContainingItemView) {
                        return viewFindViewByPosition2;
                    }
                }
            }
        } else {
            for (int i5 = 0; i5 < this.f4098i; i5++) {
                if (z2) {
                    iM4342k = this.f4090a[i5].m4341j();
                } else {
                    iM4342k = this.f4090a[i5].m4342k();
                }
                View viewFindViewByPosition3 = findViewByPosition(iM4342k);
                if (viewFindViewByPosition3 != null && viewFindViewByPosition3 != viewFindContainingItemView) {
                    return viewFindViewByPosition3;
                }
            }
        }
        return null;
    }

    /* renamed from: o */
    private int m4277o(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 != 1 ? OplusGLSurfaceView_13 != 2 ? OplusGLSurfaceView_13 != 17 ? OplusGLSurfaceView_13 != 33 ? OplusGLSurfaceView_13 != 66 ? (OplusGLSurfaceView_13 == 130 && this.f4099j == 1) ? 1 : Integer.MIN_VALUE : this.f4099j == 0 ? 1 : Integer.MIN_VALUE : this.f4099j == 1 ? -1 : Integer.MIN_VALUE : this.f4099j == 0 ? -1 : Integer.MIN_VALUE : (this.f4099j != 1 && m4291d()) ? -1 : 1 : (this.f4099j != 1 && m4291d()) ? 1 : -1;
    }

    /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$IntrinsicsJvm.kt_4 */
    public static class C0712b extends RecyclerView.C0694j {

        /* renamed from: PlatformImplementations.kt_3 */
        C0713c f4124a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        boolean f4125b;

        public C0712b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0712b(int OplusGLSurfaceView_13, int i2) {
            super(OplusGLSurfaceView_13, i2);
        }

        public C0712b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public C0712b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public boolean m4320a() {
            return this.f4125b;
        }
    }

    /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$IntrinsicsJvm.kt_3 */
    class C0713c {

        /* renamed from: PlatformImplementations.kt_3 */
        ArrayList<View> f4126a = new ArrayList<>();

        /* renamed from: IntrinsicsJvm.kt_4 */
        int f4127b = Integer.MIN_VALUE;

        /* renamed from: IntrinsicsJvm.kt_3 */
        int f4128c = Integer.MIN_VALUE;

        /* renamed from: IntrinsicsJvm.kt_5 */
        int f4129d = 0;

        /* renamed from: COUIBaseListPopupWindow_8 */
        final int f4130e;

        C0713c(int OplusGLSurfaceView_13) {
            this.f4130e = OplusGLSurfaceView_13;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        int m4321a(int OplusGLSurfaceView_13) {
            int i2 = this.f4127b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f4126a.size() == 0) {
                return OplusGLSurfaceView_13;
            }
            m4325a();
            return this.f4127b;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m4325a() {
            LazySpanLookup.FullSpanItem fullSpanItemM4311f;
            View view = this.f4126a.get(0);
            C0712b c0712bM4331c = m4331c(view);
            this.f4127b = StaggeredGridLayoutManager.this.f4091b.mo4498a(view);
            if (c0712bM4331c.f4125b && (fullSpanItemM4311f = StaggeredGridLayoutManager.this.f4097h.m4311f(c0712bM4331c.m4157f())) != null && fullSpanItemM4311f.mGapDir == -1) {
                this.f4127b -= fullSpanItemM4311f.getGapForSpan(this.f4130e);
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        int m4328b() {
            int OplusGLSurfaceView_13 = this.f4127b;
            if (OplusGLSurfaceView_13 != Integer.MIN_VALUE) {
                return OplusGLSurfaceView_13;
            }
            m4325a();
            return this.f4127b;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        int m4329b(int OplusGLSurfaceView_13) {
            int i2 = this.f4128c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f4126a.size() == 0) {
                return OplusGLSurfaceView_13;
            }
            m4332c();
            return this.f4128c;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        void m4332c() {
            LazySpanLookup.FullSpanItem fullSpanItemM4311f;
            ArrayList<View> arrayList = this.f4126a;
            View view = arrayList.get(arrayList.size() - 1);
            C0712b c0712bM4331c = m4331c(view);
            this.f4128c = StaggeredGridLayoutManager.this.f4091b.mo4501b(view);
            if (c0712bM4331c.f4125b && (fullSpanItemM4311f = StaggeredGridLayoutManager.this.f4097h.m4311f(c0712bM4331c.m4157f())) != null && fullSpanItemM4311f.mGapDir == 1) {
                this.f4128c += fullSpanItemM4311f.getGapForSpan(this.f4130e);
            }
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        int m4334d() {
            int OplusGLSurfaceView_13 = this.f4128c;
            if (OplusGLSurfaceView_13 != Integer.MIN_VALUE) {
                return OplusGLSurfaceView_13;
            }
            m4332c();
            return this.f4128c;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m4326a(View view) {
            C0712b c0712bM4331c = m4331c(view);
            c0712bM4331c.f4124a = this;
            this.f4126a.add(0, view);
            this.f4127b = Integer.MIN_VALUE;
            if (this.f4126a.size() == 1) {
                this.f4128c = Integer.MIN_VALUE;
            }
            if (c0712bM4331c.m4155d() || c0712bM4331c.m4156e()) {
                this.f4129d += StaggeredGridLayoutManager.this.f4091b.mo4508e(view);
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        void m4330b(View view) {
            C0712b c0712bM4331c = m4331c(view);
            c0712bM4331c.f4124a = this;
            this.f4126a.add(view);
            this.f4128c = Integer.MIN_VALUE;
            if (this.f4126a.size() == 1) {
                this.f4127b = Integer.MIN_VALUE;
            }
            if (c0712bM4331c.m4155d() || c0712bM4331c.m4156e()) {
                this.f4129d += StaggeredGridLayoutManager.this.f4091b.mo4508e(view);
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m4327a(boolean z, int OplusGLSurfaceView_13) {
            int iM4321a;
            if (z) {
                iM4321a = m4329b(Integer.MIN_VALUE);
            } else {
                iM4321a = m4321a(Integer.MIN_VALUE);
            }
            m4336e();
            if (iM4321a == Integer.MIN_VALUE) {
                return;
            }
            if (!z || iM4321a >= StaggeredGridLayoutManager.this.f4091b.mo4507e()) {
                if (z || iM4321a <= StaggeredGridLayoutManager.this.f4091b.mo4505d()) {
                    if (OplusGLSurfaceView_13 != Integer.MIN_VALUE) {
                        iM4321a += OplusGLSurfaceView_13;
                    }
                    this.f4128c = iM4321a;
                    this.f4127b = iM4321a;
                }
            }
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        void m4336e() {
            this.f4126a.clear();
            m4337f();
            this.f4129d = 0;
        }

        /* renamed from: COUIBaseListPopupWindow_12 */
        void m4337f() {
            this.f4127b = Integer.MIN_VALUE;
            this.f4128c = Integer.MIN_VALUE;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        void m4333c(int OplusGLSurfaceView_13) {
            this.f4127b = OplusGLSurfaceView_13;
            this.f4128c = OplusGLSurfaceView_13;
        }

        /* renamed from: COUIBaseListPopupWindow_11 */
        void m4338g() {
            int size = this.f4126a.size();
            View viewRemove = this.f4126a.remove(size - 1);
            C0712b c0712bM4331c = m4331c(viewRemove);
            c0712bM4331c.f4124a = null;
            if (c0712bM4331c.m4155d() || c0712bM4331c.m4156e()) {
                this.f4129d -= StaggeredGridLayoutManager.this.f4091b.mo4508e(viewRemove);
            }
            if (size == 1) {
                this.f4127b = Integer.MIN_VALUE;
            }
            this.f4128c = Integer.MIN_VALUE;
        }

        /* renamed from: COUIBaseListPopupWindow_10 */
        void m4339h() {
            View viewRemove = this.f4126a.remove(0);
            C0712b c0712bM4331c = m4331c(viewRemove);
            c0712bM4331c.f4124a = null;
            if (this.f4126a.size() == 0) {
                this.f4128c = Integer.MIN_VALUE;
            }
            if (c0712bM4331c.m4155d() || c0712bM4331c.m4156e()) {
                this.f4129d -= StaggeredGridLayoutManager.this.f4091b.mo4508e(viewRemove);
            }
            this.f4127b = Integer.MIN_VALUE;
        }

        /* renamed from: OplusGLSurfaceView_13 */
        public int m4340i() {
            return this.f4129d;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        C0712b m4331c(View view) {
            return (C0712b) view.getLayoutParams();
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        void m4335d(int OplusGLSurfaceView_13) {
            int i2 = this.f4127b;
            if (i2 != Integer.MIN_VALUE) {
                this.f4127b = i2 + OplusGLSurfaceView_13;
            }
            int i3 = this.f4128c;
            if (i3 != Integer.MIN_VALUE) {
                this.f4128c = i3 + OplusGLSurfaceView_13;
            }
        }

        /* renamed from: OplusGLSurfaceView_15 */
        public int m4341j() {
            if (StaggeredGridLayoutManager.this.f4093d) {
                return m4322a(this.f4126a.size() - 1, -1, true);
            }
            return m4322a(0, this.f4126a.size(), true);
        }

        /* renamed from: OplusGLSurfaceView_5 */
        public int m4342k() {
            if (StaggeredGridLayoutManager.this.f4093d) {
                return m4322a(0, this.f4126a.size(), true);
            }
            return m4322a(this.f4126a.size() - 1, -1, true);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        int m4323a(int OplusGLSurfaceView_13, int i2, boolean z, boolean z2, boolean z3) {
            int iMo4505d = StaggeredGridLayoutManager.this.f4091b.mo4505d();
            int iMo4507e = StaggeredGridLayoutManager.this.f4091b.mo4507e();
            int i3 = i2 > OplusGLSurfaceView_13 ? 1 : -1;
            while (OplusGLSurfaceView_13 != i2) {
                View view = this.f4126a.get(OplusGLSurfaceView_13);
                int iMo4498a = StaggeredGridLayoutManager.this.f4091b.mo4498a(view);
                int iMo4501b = StaggeredGridLayoutManager.this.f4091b.mo4501b(view);
                boolean z4 = false;
                boolean z5 = !z3 ? iMo4498a >= iMo4507e : iMo4498a > iMo4507e;
                if (!z3 ? iMo4501b > iMo4505d : iMo4501b >= iMo4505d) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (z && z2) {
                        if (iMo4498a >= iMo4505d && iMo4501b <= iMo4507e) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    } else {
                        if (z2) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                        if (iMo4498a < iMo4505d || iMo4501b > iMo4507e) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    }
                }
                OplusGLSurfaceView_13 += i3;
            }
            return -1;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        int m4322a(int OplusGLSurfaceView_13, int i2, boolean z) {
            return m4323a(OplusGLSurfaceView_13, i2, false, false, z);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public View m4324a(int OplusGLSurfaceView_13, int i2) {
            View view = null;
            if (i2 == -1) {
                int size = this.f4126a.size();
                int i3 = 0;
                while (i3 < size) {
                    View view2 = this.f4126a.get(i3);
                    if ((StaggeredGridLayoutManager.this.f4093d && StaggeredGridLayoutManager.this.getPosition(view2) <= OplusGLSurfaceView_13) || ((!StaggeredGridLayoutManager.this.f4093d && StaggeredGridLayoutManager.this.getPosition(view2) >= OplusGLSurfaceView_13) || !view2.hasFocusable())) {
                        break;
                    }
                    i3++;
                    view = view2;
                }
            } else {
                int size2 = this.f4126a.size() - 1;
                while (size2 >= 0) {
                    View view3 = this.f4126a.get(size2);
                    if ((StaggeredGridLayoutManager.this.f4093d && StaggeredGridLayoutManager.this.getPosition(view3) >= OplusGLSurfaceView_13) || ((!StaggeredGridLayoutManager.this.f4093d && StaggeredGridLayoutManager.this.getPosition(view3) <= OplusGLSurfaceView_13) || !view3.hasFocusable())) {
                        break;
                    }
                    size2--;
                    view = view3;
                }
            }
            return view;
        }
    }

    static class LazySpanLookup {

        /* renamed from: PlatformImplementations.kt_3 */
        int[] f4115a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        List<FullSpanItem> f4116b;

        LazySpanLookup() {
        }

        /* renamed from: PlatformImplementations.kt_3 */
        int m4300a(int OplusGLSurfaceView_13) {
            List<FullSpanItem> list = this.f4116b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f4116b.get(size).mPosition >= OplusGLSurfaceView_13) {
                        this.f4116b.remove(size);
                    }
                }
            }
            return m4306b(OplusGLSurfaceView_13);
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        int m4306b(int OplusGLSurfaceView_13) {
            int[] iArr = this.f4115a;
            if (iArr == null || OplusGLSurfaceView_13 >= iArr.length) {
                return -1;
            }
            int iM4299g = m4299g(OplusGLSurfaceView_13);
            if (iM4299g == -1) {
                int[] iArr2 = this.f4115a;
                Arrays.fill(iArr2, OplusGLSurfaceView_13, iArr2.length, -1);
                return this.f4115a.length;
            }
            int i2 = iM4299g + 1;
            Arrays.fill(this.f4115a, OplusGLSurfaceView_13, i2, -1);
            return i2;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        int m4308c(int OplusGLSurfaceView_13) {
            int[] iArr = this.f4115a;
            if (iArr == null || OplusGLSurfaceView_13 >= iArr.length) {
                return -1;
            }
            return iArr[OplusGLSurfaceView_13];
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m4304a(int OplusGLSurfaceView_13, C0713c c0713c) {
            m4310e(OplusGLSurfaceView_13);
            this.f4115a[OplusGLSurfaceView_13] = c0713c.f4130e;
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        int m4309d(int OplusGLSurfaceView_13) {
            int length = this.f4115a.length;
            while (length <= OplusGLSurfaceView_13) {
                length *= 2;
            }
            return length;
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        void m4310e(int OplusGLSurfaceView_13) {
            int[] iArr = this.f4115a;
            if (iArr == null) {
                this.f4115a = new int[Math.max(OplusGLSurfaceView_13, 10) + 1];
                Arrays.fill(this.f4115a, -1);
            } else if (OplusGLSurfaceView_13 >= iArr.length) {
                this.f4115a = new int[m4309d(OplusGLSurfaceView_13)];
                System.arraycopy(iArr, 0, this.f4115a, 0, iArr.length);
                int[] iArr2 = this.f4115a;
                Arrays.fill(iArr2, iArr.length, iArr2.length, -1);
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m4302a() {
            int[] iArr = this.f4115a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f4116b = null;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m4303a(int OplusGLSurfaceView_13, int i2) {
            int[] iArr = this.f4115a;
            if (iArr == null || OplusGLSurfaceView_13 >= iArr.length) {
                return;
            }
            int i3 = OplusGLSurfaceView_13 + i2;
            m4310e(i3);
            int[] iArr2 = this.f4115a;
            System.arraycopy(iArr2, i3, iArr2, OplusGLSurfaceView_13, (iArr2.length - OplusGLSurfaceView_13) - i2);
            int[] iArr3 = this.f4115a;
            Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
            m4297c(OplusGLSurfaceView_13, i2);
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        private void m4297c(int OplusGLSurfaceView_13, int i2) {
            List<FullSpanItem> list = this.f4116b;
            if (list == null) {
                return;
            }
            int i3 = OplusGLSurfaceView_13 + i2;
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f4116b.get(size);
                if (fullSpanItem.mPosition >= OplusGLSurfaceView_13) {
                    if (fullSpanItem.mPosition < i3) {
                        this.f4116b.remove(size);
                    } else {
                        fullSpanItem.mPosition -= i2;
                    }
                }
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        void m4307b(int OplusGLSurfaceView_13, int i2) {
            int[] iArr = this.f4115a;
            if (iArr == null || OplusGLSurfaceView_13 >= iArr.length) {
                return;
            }
            int i3 = OplusGLSurfaceView_13 + i2;
            m4310e(i3);
            int[] iArr2 = this.f4115a;
            System.arraycopy(iArr2, OplusGLSurfaceView_13, iArr2, i3, (iArr2.length - OplusGLSurfaceView_13) - i2);
            Arrays.fill(this.f4115a, OplusGLSurfaceView_13, i3, -1);
            m4298d(OplusGLSurfaceView_13, i2);
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        private void m4298d(int OplusGLSurfaceView_13, int i2) {
            List<FullSpanItem> list = this.f4116b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f4116b.get(size);
                if (fullSpanItem.mPosition >= OplusGLSurfaceView_13) {
                    fullSpanItem.mPosition += i2;
                }
            }
        }

        /* renamed from: COUIBaseListPopupWindow_11 */
        private int m4299g(int OplusGLSurfaceView_13) {
            if (this.f4116b == null) {
                return -1;
            }
            FullSpanItem fullSpanItemM4311f = m4311f(OplusGLSurfaceView_13);
            if (fullSpanItemM4311f != null) {
                this.f4116b.remove(fullSpanItemM4311f);
            }
            int size = this.f4116b.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                }
                if (this.f4116b.get(i2).mPosition >= OplusGLSurfaceView_13) {
                    break;
                }
                i2++;
            }
            if (i2 == -1) {
                return -1;
            }
            FullSpanItem fullSpanItem = this.f4116b.get(i2);
            this.f4116b.remove(i2);
            return fullSpanItem.mPosition;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m4305a(FullSpanItem fullSpanItem) {
            if (this.f4116b == null) {
                this.f4116b = new ArrayList();
            }
            int size = this.f4116b.size();
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                FullSpanItem fullSpanItem2 = this.f4116b.get(OplusGLSurfaceView_13);
                if (fullSpanItem2.mPosition == fullSpanItem.mPosition) {
                    this.f4116b.remove(OplusGLSurfaceView_13);
                }
                if (fullSpanItem2.mPosition >= fullSpanItem.mPosition) {
                    this.f4116b.add(OplusGLSurfaceView_13, fullSpanItem);
                    return;
                }
            }
            this.f4116b.add(fullSpanItem);
        }

        /* renamed from: COUIBaseListPopupWindow_12 */
        public FullSpanItem m4311f(int OplusGLSurfaceView_13) {
            List<FullSpanItem> list = this.f4116b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f4116b.get(size);
                if (fullSpanItem.mPosition == OplusGLSurfaceView_13) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public FullSpanItem m4301a(int OplusGLSurfaceView_13, int i2, int i3, boolean z) {
            List<FullSpanItem> list = this.f4116b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                FullSpanItem fullSpanItem = this.f4116b.get(i4);
                if (fullSpanItem.mPosition >= i2) {
                    return null;
                }
                if (fullSpanItem.mPosition >= OplusGLSurfaceView_13 && (i3 == 0 || fullSpanItem.mGapDir == i3 || (z && fullSpanItem.mHasUnwantedGapAfter))) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        @SuppressLint({"BanParcelableUsage"})
        static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator<FullSpanItem>() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.1
                @Override // android.os.Parcelable.Creator
                /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
                public FullSpanItem[] newArray(int OplusGLSurfaceView_13) {
                    return new FullSpanItem[OplusGLSurfaceView_13];
                }
            };
            int mGapDir;
            int[] mGapPerSpan;
            boolean mHasUnwantedGapAfter;
            int mPosition;

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            FullSpanItem(Parcel parcel) {
                this.mPosition = parcel.readInt();
                this.mGapDir = parcel.readInt();
                this.mHasUnwantedGapAfter = parcel.readInt() == 1;
                int OplusGLSurfaceView_13 = parcel.readInt();
                if (OplusGLSurfaceView_13 > 0) {
                    this.mGapPerSpan = new int[OplusGLSurfaceView_13];
                    parcel.readIntArray(this.mGapPerSpan);
                }
            }

            FullSpanItem() {
            }

            int getGapForSpan(int OplusGLSurfaceView_13) {
                int[] iArr = this.mGapPerSpan;
                if (iArr == null) {
                    return 0;
                }
                return iArr[OplusGLSurfaceView_13];
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
                parcel.writeInt(this.mPosition);
                parcel.writeInt(this.mGapDir);
                parcel.writeInt(this.mHasUnwantedGapAfter ? 1 : 0);
                int[] iArr = this.mGapPerSpan;
                if (iArr != null && iArr.length > 0) {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.mGapPerSpan);
                } else {
                    parcel.writeInt(0);
                }
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.mPosition + ", mGapDir=" + this.mGapDir + ", mHasUnwantedGapAfter=" + this.mHasUnwantedGapAfter + ", mGapPerSpan=" + Arrays.toString(this.mGapPerSpan) + '}';
            }
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int OplusGLSurfaceView_13) {
                return new SavedState[OplusGLSurfaceView_13];
            }
        };
        boolean mAnchorLayoutFromEnd;
        int mAnchorPosition;
        List<LazySpanLookup.FullSpanItem> mFullSpanItems;
        boolean mLastLayoutRTL;
        boolean mReverseLayout;
        int[] mSpanLookup;
        int mSpanLookupSize;
        int[] mSpanOffsets;
        int mSpanOffsetsSize;
        int mVisibleAnchorPosition;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            this.mAnchorPosition = parcel.readInt();
            this.mVisibleAnchorPosition = parcel.readInt();
            this.mSpanOffsetsSize = parcel.readInt();
            int OplusGLSurfaceView_13 = this.mSpanOffsetsSize;
            if (OplusGLSurfaceView_13 > 0) {
                this.mSpanOffsets = new int[OplusGLSurfaceView_13];
                parcel.readIntArray(this.mSpanOffsets);
            }
            this.mSpanLookupSize = parcel.readInt();
            int i2 = this.mSpanLookupSize;
            if (i2 > 0) {
                this.mSpanLookup = new int[i2];
                parcel.readIntArray(this.mSpanLookup);
            }
            this.mReverseLayout = parcel.readInt() == 1;
            this.mAnchorLayoutFromEnd = parcel.readInt() == 1;
            this.mLastLayoutRTL = parcel.readInt() == 1;
            this.mFullSpanItems = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.mSpanOffsetsSize = savedState.mSpanOffsetsSize;
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mVisibleAnchorPosition = savedState.mVisibleAnchorPosition;
            this.mSpanOffsets = savedState.mSpanOffsets;
            this.mSpanLookupSize = savedState.mSpanLookupSize;
            this.mSpanLookup = savedState.mSpanLookup;
            this.mReverseLayout = savedState.mReverseLayout;
            this.mAnchorLayoutFromEnd = savedState.mAnchorLayoutFromEnd;
            this.mLastLayoutRTL = savedState.mLastLayoutRTL;
            this.mFullSpanItems = savedState.mFullSpanItems;
        }

        void invalidateSpanInfo() {
            this.mSpanOffsets = null;
            this.mSpanOffsetsSize = 0;
            this.mSpanLookupSize = 0;
            this.mSpanLookup = null;
            this.mFullSpanItems = null;
        }

        void invalidateAnchorPositionInfo() {
            this.mSpanOffsets = null;
            this.mSpanOffsetsSize = 0;
            this.mAnchorPosition = -1;
            this.mVisibleAnchorPosition = -1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mVisibleAnchorPosition);
            parcel.writeInt(this.mSpanOffsetsSize);
            if (this.mSpanOffsetsSize > 0) {
                parcel.writeIntArray(this.mSpanOffsets);
            }
            parcel.writeInt(this.mSpanLookupSize);
            if (this.mSpanLookupSize > 0) {
                parcel.writeIntArray(this.mSpanLookup);
            }
            parcel.writeInt(this.mReverseLayout ? 1 : 0);
            parcel.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
            parcel.writeInt(this.mLastLayoutRTL ? 1 : 0);
            parcel.writeList(this.mFullSpanItems);
        }
    }

    /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$PlatformImplementations.kt_3 */
    class C0711a {

        /* renamed from: PlatformImplementations.kt_3 */
        int f4117a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        int f4118b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        boolean f4119c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        boolean f4120d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        boolean f4121e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        int[] f4122f;

        C0711a() {
            m4316a();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m4316a() {
            this.f4117a = -1;
            this.f4118b = Integer.MIN_VALUE;
            this.f4119c = false;
            this.f4120d = false;
            this.f4121e = false;
            int[] iArr = this.f4122f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m4318a(C0713c[] c0713cArr) {
            int length = c0713cArr.length;
            int[] iArr = this.f4122f;
            if (iArr == null || iArr.length < length) {
                this.f4122f = new int[StaggeredGridLayoutManager.this.f4090a.length];
            }
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13++) {
                this.f4122f[OplusGLSurfaceView_13] = c0713cArr[OplusGLSurfaceView_13].m4321a(Integer.MIN_VALUE);
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        void m4319b() {
            this.f4118b = this.f4119c ? StaggeredGridLayoutManager.this.f4091b.mo4507e() : StaggeredGridLayoutManager.this.f4091b.mo4505d();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m4317a(int OplusGLSurfaceView_13) {
            if (this.f4119c) {
                this.f4118b = StaggeredGridLayoutManager.this.f4091b.mo4507e() - OplusGLSurfaceView_13;
            } else {
                this.f4118b = StaggeredGridLayoutManager.this.f4091b.mo4505d() + OplusGLSurfaceView_13;
            }
        }
    }
}
