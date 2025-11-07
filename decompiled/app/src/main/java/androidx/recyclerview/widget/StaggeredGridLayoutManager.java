package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends androidx.recyclerview.widget.RecyclerView.i_renamed implements androidx.recyclerview.widget.RecyclerView.s_renamed.b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    androidx.recyclerview.widget.StaggeredGridLayoutManager.c_renamed[] f1441a;

    /* renamed from: b_renamed, reason: collision with root package name */
    androidx.recyclerview.widget.n_renamed f1442b;

    /* renamed from: c_renamed, reason: collision with root package name */
    androidx.recyclerview.widget.n_renamed f1443c;
    private int j_renamed;
    private int k_renamed;
    private final androidx.recyclerview.widget.i_renamed l_renamed;
    private java.util.BitSet m_renamed;
    private boolean o_renamed;
    private boolean p_renamed;
    private androidx.recyclerview.widget.StaggeredGridLayoutManager.SavedState q_renamed;
    private int r_renamed;
    private int[] w_renamed;
    private int i_renamed = -1;
    boolean d_renamed = false;
    boolean e_renamed = false;
    int f_renamed = -1;
    int g_renamed = Integer.MIN_VALUE;
    androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup h_renamed = new androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup();
    private int n_renamed = 2;
    private final android.graphics.Rect s_renamed = new android.graphics.Rect();
    private final androidx.recyclerview.widget.StaggeredGridLayoutManager.a_renamed t_renamed = new androidx.recyclerview.widget.StaggeredGridLayoutManager.a_renamed();
    private boolean u_renamed = false;
    private boolean v_renamed = true;
    private final java.lang.Runnable x_renamed = new java.lang.Runnable() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.1
        @Override // java.lang.Runnable
        public void run() {
            androidx.recyclerview.widget.StaggeredGridLayoutManager.this.a_renamed();
        }
    };

    public StaggeredGridLayoutManager(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        androidx.recyclerview.widget.RecyclerView.i_renamed.b_renamed properties = getProperties(context, attributeSet, i_renamed, i2);
        b_renamed(properties.f1419a);
        a_renamed(properties.f1420b);
        a_renamed(properties.f1421c);
        this.l_renamed = new androidx.recyclerview.widget.i_renamed();
        j_renamed();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public boolean isAutoMeasureEnabled() {
        return this.n_renamed != 0;
    }

    private void j_renamed() {
        this.f1442b = androidx.recyclerview.widget.n_renamed.a_renamed(this, this.j_renamed);
        this.f1443c = androidx.recyclerview.widget.n_renamed.a_renamed(this, 1 - this.j_renamed);
    }

    boolean a_renamed() {
        int i_renamed;
        int iH;
        if (getChildCount() == 0 || this.n_renamed == 0 || !isAttachedToWindow()) {
            return false;
        }
        if (this.e_renamed) {
            i_renamed = h_renamed();
            iH = i_renamed();
        } else {
            i_renamed = i_renamed();
            iH = h_renamed();
        }
        if (i_renamed == 0 && b_renamed() != null) {
            this.h_renamed.a_renamed();
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        }
        if (!this.u_renamed) {
            return false;
        }
        int i2 = this.e_renamed ? -1 : 1;
        int i3 = iH + 1;
        androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem fullSpanItemA = this.h_renamed.a_renamed(i_renamed, i3, i2, true);
        if (fullSpanItemA == null) {
            this.u_renamed = false;
            this.h_renamed.a_renamed(i3);
            return false;
        }
        androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem fullSpanItemA2 = this.h_renamed.a_renamed(i_renamed, fullSpanItemA.mPosition, i2 * (-1), true);
        if (fullSpanItemA2 == null) {
            this.h_renamed.a_renamed(fullSpanItemA.mPosition);
        } else {
            this.h_renamed.a_renamed(fullSpanItemA2.mPosition + 1);
        }
        requestSimpleAnimationsInNextLayout();
        requestLayout();
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public void onScrollStateChanged(int i_renamed) {
        if (i_renamed == 0) {
            a_renamed();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public void onDetachedFromWindow(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.p_renamed pVar) {
        super.onDetachedFromWindow(recyclerView, pVar);
        removeCallbacks(this.x_renamed);
        for (int i_renamed = 0; i_renamed < this.i_renamed; i_renamed++) {
            this.f1441a[i_renamed].e_renamed();
        }
        recyclerView.requestLayout();
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:37:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:38:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    android.view.View b_renamed() {
        /*
            r12 = this;
            int r0 = r12.getChildCount()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.i_renamed
            r2.<init>(r3)
            int r3 = r12.i_renamed
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r12.j_renamed
            r5 = -1
            if (r3 != r1) goto L20
            boolean r3 = r12.d_renamed()
            if (r3 == 0) goto L20
            r3 = r1
            goto L21
        L20:
            r3 = r5
        L21:
            boolean r6 = r12.e_renamed
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
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b_renamed r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.b_renamed) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c_renamed r9 = r8.f1450a
            int r9 = r9.e_renamed
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L54
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c_renamed r9 = r8.f1450a
            boolean r9 = r12.a_renamed(r9)
            if (r9 == 0) goto L4d
            return r7
        L4d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c_renamed r9 = r8.f1450a
            int r9 = r9.e_renamed
            r2.clear(r9)
        L54:
            boolean r9 = r8.f1451b
            if (r9 == 0) goto L59
            goto La9
        L59:
            int r9 = r0 + r5
            if (r9 == r6) goto La9
            android.view.View r9 = r12.getChildAt(r9)
            boolean r10 = r12.e_renamed
            if (r10 == 0) goto L77
            androidx.recyclerview.widget.n_renamed r10 = r12.f1442b
            int r10 = r10.b_renamed(r7)
            androidx.recyclerview.widget.n_renamed r11 = r12.f1442b
            int r11 = r11.b_renamed(r9)
            if (r10 >= r11) goto L74
            return r7
        L74:
            if (r10 != r11) goto L8a
            goto L88
        L77:
            androidx.recyclerview.widget.n_renamed r10 = r12.f1442b
            int r10 = r10.a_renamed(r7)
            androidx.recyclerview.widget.n_renamed r11 = r12.f1442b
            int r11 = r11.a_renamed(r9)
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
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b_renamed r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.b_renamed) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c_renamed r8 = r8.f1450a
            int r8 = r8.e_renamed
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c_renamed r9 = r9.f1450a
            int r9 = r9.e_renamed
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.b_renamed():android.view.View");
    }

    private boolean a_renamed(androidx.recyclerview.widget.StaggeredGridLayoutManager.c_renamed cVar) {
        if (this.e_renamed) {
            if (cVar.d_renamed() < this.f1442b.e_renamed()) {
                return !cVar.c_renamed(cVar.f1452a.get(cVar.f1452a.size() - 1)).f1451b;
            }
        } else if (cVar.b_renamed() > this.f1442b.d_renamed()) {
            return !cVar.c_renamed(cVar.f1452a.get(0)).f1451b;
        }
        return false;
    }

    public void a_renamed(int i_renamed) {
        assertNotInLayoutOrScroll(null);
        if (i_renamed != this.i_renamed) {
            c_renamed();
            this.i_renamed = i_renamed;
            this.m_renamed = new java.util.BitSet(this.i_renamed);
            this.f1441a = new androidx.recyclerview.widget.StaggeredGridLayoutManager.c_renamed[this.i_renamed];
            for (int i2 = 0; i2 < this.i_renamed; i2++) {
                this.f1441a[i2] = new androidx.recyclerview.widget.StaggeredGridLayoutManager.c_renamed(i2);
            }
            requestLayout();
        }
    }

    public void b_renamed(int i_renamed) {
        if (i_renamed != 0 && i_renamed != 1) {
            throw new java.lang.IllegalArgumentException("invalid orientation.");
        }
        assertNotInLayoutOrScroll(null);
        if (i_renamed == this.j_renamed) {
            return;
        }
        this.j_renamed = i_renamed;
        androidx.recyclerview.widget.n_renamed nVar = this.f1442b;
        this.f1442b = this.f1443c;
        this.f1443c = nVar;
        requestLayout();
    }

    public void a_renamed(boolean z_renamed) {
        assertNotInLayoutOrScroll(null);
        androidx.recyclerview.widget.StaggeredGridLayoutManager.SavedState savedState = this.q_renamed;
        if (savedState != null && savedState.mReverseLayout != z_renamed) {
            this.q_renamed.mReverseLayout = z_renamed;
        }
        this.d_renamed = z_renamed;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public void assertNotInLayoutOrScroll(java.lang.String str) {
        if (this.q_renamed == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public void c_renamed() {
        this.h_renamed.a_renamed();
        requestLayout();
    }

    private void k_renamed() {
        if (this.j_renamed == 1 || !d_renamed()) {
            this.e_renamed = this.d_renamed;
        } else {
            this.e_renamed = !this.d_renamed;
        }
    }

    boolean d_renamed() {
        return getLayoutDirection() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public void setMeasuredDimension(android.graphics.Rect rect, int i_renamed, int i2) {
        int iChooseSize;
        int iChooseSize2;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.j_renamed == 1) {
            iChooseSize2 = chooseSize(i2, rect.height() + paddingTop, getMinimumHeight());
            iChooseSize = chooseSize(i_renamed, (this.k_renamed * this.i_renamed) + paddingLeft, getMinimumWidth());
        } else {
            iChooseSize = chooseSize(i_renamed, rect.width() + paddingLeft, getMinimumWidth());
            iChooseSize2 = chooseSize(i2, (this.k_renamed * this.i_renamed) + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(iChooseSize, iChooseSize2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public void onLayoutChildren(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        a_renamed(pVar, tVar, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public void onAdapterChanged(androidx.recyclerview.widget.RecyclerView.a_renamed aVar, androidx.recyclerview.widget.RecyclerView.a_renamed aVar2) {
        this.h_renamed.a_renamed();
        for (int i_renamed = 0; i_renamed < this.i_renamed; i_renamed++) {
            this.f1441a[i_renamed].e_renamed();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:89:0x0164  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a_renamed(androidx.recyclerview.widget.RecyclerView.p_renamed r9, androidx.recyclerview.widget.RecyclerView.t_renamed r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 389
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.a_renamed(androidx.recyclerview.widget.RecyclerView$p_renamed, androidx.recyclerview.widget.RecyclerView$t_renamed, boolean):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public void onLayoutCompleted(androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        super.onLayoutCompleted(tVar);
        this.f_renamed = -1;
        this.g_renamed = Integer.MIN_VALUE;
        this.q_renamed = null;
        this.t_renamed.a_renamed();
    }

    private void l_renamed() {
        if (this.f1443c.i_renamed() == 1073741824) {
            return;
        }
        int childCount = getChildCount();
        float fMax = 0.0f;
        for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
            android.view.View childAt = getChildAt(i_renamed);
            float fE_renamed = this.f1443c.e_renamed(childAt);
            if (fE_renamed >= fMax) {
                if (((androidx.recyclerview.widget.StaggeredGridLayoutManager.b_renamed) childAt.getLayoutParams()).a_renamed()) {
                    fE_renamed = (fE_renamed * 1.0f) / this.i_renamed;
                }
                fMax = java.lang.Math.max(fMax, fE_renamed);
            }
        }
        int i2 = this.k_renamed;
        int iRound = java.lang.Math.round(fMax * this.i_renamed);
        if (this.f1443c.i_renamed() == Integer.MIN_VALUE) {
            iRound = java.lang.Math.min(iRound, this.f1443c.g_renamed());
        }
        c_renamed(iRound);
        if (this.k_renamed == i2) {
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            android.view.View childAt2 = getChildAt(i3);
            androidx.recyclerview.widget.StaggeredGridLayoutManager.b_renamed bVar = (androidx.recyclerview.widget.StaggeredGridLayoutManager.b_renamed) childAt2.getLayoutParams();
            if (!bVar.f1451b) {
                if (d_renamed() && this.j_renamed == 1) {
                    childAt2.offsetLeftAndRight(((-((this.i_renamed - 1) - bVar.f1450a.e_renamed)) * this.k_renamed) - ((-((this.i_renamed - 1) - bVar.f1450a.e_renamed)) * i2));
                } else {
                    int i4 = bVar.f1450a.e_renamed * this.k_renamed;
                    int i5 = bVar.f1450a.e_renamed * i2;
                    if (this.j_renamed == 1) {
                        childAt2.offsetLeftAndRight(i4 - i5);
                    } else {
                        childAt2.offsetTopAndBottom(i4 - i5);
                    }
                }
            }
        }
    }

    private void a_renamed(androidx.recyclerview.widget.StaggeredGridLayoutManager.a_renamed aVar) {
        int iD;
        if (this.q_renamed.mSpanOffsetsSize > 0) {
            if (this.q_renamed.mSpanOffsetsSize == this.i_renamed) {
                for (int i_renamed = 0; i_renamed < this.i_renamed; i_renamed++) {
                    this.f1441a[i_renamed].e_renamed();
                    int i2 = this.q_renamed.mSpanOffsets[i_renamed];
                    if (i2 != Integer.MIN_VALUE) {
                        if (this.q_renamed.mAnchorLayoutFromEnd) {
                            iD = this.f1442b.e_renamed();
                        } else {
                            iD = this.f1442b.d_renamed();
                        }
                        i2 += iD;
                    }
                    this.f1441a[i_renamed].c_renamed(i2);
                }
            } else {
                this.q_renamed.invalidateSpanInfo();
                androidx.recyclerview.widget.StaggeredGridLayoutManager.SavedState savedState = this.q_renamed;
                savedState.mAnchorPosition = savedState.mVisibleAnchorPosition;
            }
        }
        this.p_renamed = this.q_renamed.mLastLayoutRTL;
        a_renamed(this.q_renamed.mReverseLayout);
        k_renamed();
        if (this.q_renamed.mAnchorPosition != -1) {
            this.f_renamed = this.q_renamed.mAnchorPosition;
            aVar.f1449c = this.q_renamed.mAnchorLayoutFromEnd;
        } else {
            aVar.f1449c = this.e_renamed;
        }
        if (this.q_renamed.mSpanLookupSize > 1) {
            this.h_renamed.f1445a = this.q_renamed.mSpanLookup;
            this.h_renamed.f1446b = this.q_renamed.mFullSpanItems;
        }
    }

    void a_renamed(androidx.recyclerview.widget.RecyclerView.t_renamed tVar, androidx.recyclerview.widget.StaggeredGridLayoutManager.a_renamed aVar) {
        if (b_renamed(tVar, aVar) || c_renamed(tVar, aVar)) {
            return;
        }
        aVar.b_renamed();
        aVar.f1447a = 0;
    }

    private boolean c_renamed(androidx.recyclerview.widget.RecyclerView.t_renamed tVar, androidx.recyclerview.widget.StaggeredGridLayoutManager.a_renamed aVar) {
        int iM;
        if (this.o_renamed) {
            iM = n_renamed(tVar.e_renamed());
        } else {
            iM = m_renamed(tVar.e_renamed());
        }
        aVar.f1447a = iM;
        aVar.f1448b = Integer.MIN_VALUE;
        return true;
    }

    boolean b_renamed(androidx.recyclerview.widget.RecyclerView.t_renamed tVar, androidx.recyclerview.widget.StaggeredGridLayoutManager.a_renamed aVar) {
        int i_renamed;
        int iD;
        if (!tVar.a_renamed() && (i_renamed = this.f_renamed) != -1) {
            if (i_renamed < 0 || i_renamed >= tVar.e_renamed()) {
                this.f_renamed = -1;
                this.g_renamed = Integer.MIN_VALUE;
            } else {
                androidx.recyclerview.widget.StaggeredGridLayoutManager.SavedState savedState = this.q_renamed;
                if (savedState == null || savedState.mAnchorPosition == -1 || this.q_renamed.mSpanOffsetsSize < 1) {
                    android.view.View viewFindViewByPosition = findViewByPosition(this.f_renamed);
                    if (viewFindViewByPosition != null) {
                        aVar.f1447a = this.e_renamed ? h_renamed() : i_renamed();
                        if (this.g_renamed != Integer.MIN_VALUE) {
                            if (aVar.f1449c) {
                                aVar.f1448b = (this.f1442b.e_renamed() - this.g_renamed) - this.f1442b.b_renamed(viewFindViewByPosition);
                            } else {
                                aVar.f1448b = (this.f1442b.d_renamed() + this.g_renamed) - this.f1442b.a_renamed(viewFindViewByPosition);
                            }
                            return true;
                        }
                        if (this.f1442b.e_renamed(viewFindViewByPosition) > this.f1442b.g_renamed()) {
                            if (aVar.f1449c) {
                                iD = this.f1442b.e_renamed();
                            } else {
                                iD = this.f1442b.d_renamed();
                            }
                            aVar.f1448b = iD;
                            return true;
                        }
                        int iA = this.f1442b.a_renamed(viewFindViewByPosition) - this.f1442b.d_renamed();
                        if (iA < 0) {
                            aVar.f1448b = -iA;
                            return true;
                        }
                        int iE = this.f1442b.e_renamed() - this.f1442b.b_renamed(viewFindViewByPosition);
                        if (iE < 0) {
                            aVar.f1448b = iE;
                            return true;
                        }
                        aVar.f1448b = Integer.MIN_VALUE;
                    } else {
                        aVar.f1447a = this.f_renamed;
                        int i2 = this.g_renamed;
                        if (i2 == Integer.MIN_VALUE) {
                            aVar.f1449c = l_renamed(aVar.f1447a) == 1;
                            aVar.b_renamed();
                        } else {
                            aVar.a_renamed(i2);
                        }
                        aVar.d_renamed = true;
                    }
                } else {
                    aVar.f1448b = Integer.MIN_VALUE;
                    aVar.f1447a = this.f_renamed;
                }
                return true;
            }
        }
        return false;
    }

    void c_renamed(int i_renamed) {
        this.k_renamed = i_renamed / this.i_renamed;
        this.r_renamed = android.view.View.MeasureSpec.makeMeasureSpec(i_renamed, this.f1443c.i_renamed());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public boolean supportsPredictiveItemAnimations() {
        return this.q_renamed == null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public int computeHorizontalScrollOffset(androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        return a_renamed(tVar);
    }

    private int a_renamed(androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        return androidx.recyclerview.widget.q_renamed.a_renamed(tVar, this.f1442b, b_renamed(!this.v_renamed), c_renamed(!this.v_renamed), this, this.v_renamed, this.e_renamed);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public int computeVerticalScrollOffset(androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        return a_renamed(tVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public int computeHorizontalScrollExtent(androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        return b_renamed(tVar);
    }

    private int b_renamed(androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        return androidx.recyclerview.widget.q_renamed.a_renamed(tVar, this.f1442b, b_renamed(!this.v_renamed), c_renamed(!this.v_renamed), this, this.v_renamed);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public int computeVerticalScrollExtent(androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        return b_renamed(tVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public int computeHorizontalScrollRange(androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        return c_renamed(tVar);
    }

    private int c_renamed(androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        return androidx.recyclerview.widget.q_renamed.b_renamed(tVar, this.f1442b, b_renamed(!this.v_renamed), c_renamed(!this.v_renamed), this, this.v_renamed);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public int computeVerticalScrollRange(androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        return c_renamed(tVar);
    }

    private void a_renamed(android.view.View view, androidx.recyclerview.widget.StaggeredGridLayoutManager.b_renamed bVar, boolean z_renamed) {
        if (bVar.f1451b) {
            if (this.j_renamed == 1) {
                a_renamed(view, this.r_renamed, getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), bVar.height, true), z_renamed);
                return;
            } else {
                a_renamed(view, getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), bVar.width, true), this.r_renamed, z_renamed);
                return;
            }
        }
        if (this.j_renamed == 1) {
            a_renamed(view, getChildMeasureSpec(this.k_renamed, getWidthMode(), 0, bVar.width, false), getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), bVar.height, true), z_renamed);
        } else {
            a_renamed(view, getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), bVar.width, true), getChildMeasureSpec(this.k_renamed, getHeightMode(), 0, bVar.height, false), z_renamed);
        }
    }

    private void a_renamed(android.view.View view, int i_renamed, int i2, boolean z_renamed) {
        boolean zShouldMeasureChild;
        calculateItemDecorationsForChild(view, this.s_renamed);
        androidx.recyclerview.widget.StaggeredGridLayoutManager.b_renamed bVar = (androidx.recyclerview.widget.StaggeredGridLayoutManager.b_renamed) view.getLayoutParams();
        int iA = a_renamed(i_renamed, bVar.leftMargin + this.s_renamed.left, bVar.rightMargin + this.s_renamed.right);
        int iA2 = a_renamed(i2, bVar.topMargin + this.s_renamed.top, bVar.bottomMargin + this.s_renamed.bottom);
        if (z_renamed) {
            zShouldMeasureChild = shouldReMeasureChild(view, iA, iA2, bVar);
        } else {
            zShouldMeasureChild = shouldMeasureChild(view, iA, iA2, bVar);
        }
        if (zShouldMeasureChild) {
            view.measure(iA, iA2);
        }
    }

    private int a_renamed(int i_renamed, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i_renamed;
        }
        int mode = android.view.View.MeasureSpec.getMode(i_renamed);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? android.view.View.MeasureSpec.makeMeasureSpec(java.lang.Math.max(0, (android.view.View.MeasureSpec.getSize(i_renamed) - i2) - i3), mode) : i_renamed;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public void onRestoreInstanceState(android.os.Parcelable parcelable) {
        if (parcelable instanceof androidx.recyclerview.widget.StaggeredGridLayoutManager.SavedState) {
            this.q_renamed = (androidx.recyclerview.widget.StaggeredGridLayoutManager.SavedState) parcelable;
            if (this.f_renamed != -1) {
                this.q_renamed.invalidateAnchorPositionInfo();
                this.q_renamed.invalidateSpanInfo();
            }
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public android.os.Parcelable onSaveInstanceState() {
        int iA;
        int iD;
        androidx.recyclerview.widget.StaggeredGridLayoutManager.SavedState savedState = this.q_renamed;
        if (savedState != null) {
            return new androidx.recyclerview.widget.StaggeredGridLayoutManager.SavedState(savedState);
        }
        androidx.recyclerview.widget.StaggeredGridLayoutManager.SavedState savedState2 = new androidx.recyclerview.widget.StaggeredGridLayoutManager.SavedState();
        savedState2.mReverseLayout = this.d_renamed;
        savedState2.mAnchorLayoutFromEnd = this.o_renamed;
        savedState2.mLastLayoutRTL = this.p_renamed;
        androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup lazySpanLookup = this.h_renamed;
        if (lazySpanLookup != null && lazySpanLookup.f1445a != null) {
            savedState2.mSpanLookup = this.h_renamed.f1445a;
            savedState2.mSpanLookupSize = savedState2.mSpanLookup.length;
            savedState2.mFullSpanItems = this.h_renamed.f1446b;
        } else {
            savedState2.mSpanLookupSize = 0;
        }
        if (getChildCount() > 0) {
            savedState2.mAnchorPosition = this.o_renamed ? h_renamed() : i_renamed();
            savedState2.mVisibleAnchorPosition = e_renamed();
            int i_renamed = this.i_renamed;
            savedState2.mSpanOffsetsSize = i_renamed;
            savedState2.mSpanOffsets = new int[i_renamed];
            for (int i2 = 0; i2 < this.i_renamed; i2++) {
                if (this.o_renamed) {
                    iA = this.f1441a[i2].b_renamed(Integer.MIN_VALUE);
                    if (iA != Integer.MIN_VALUE) {
                        iD = this.f1442b.e_renamed();
                        iA -= iD;
                    }
                } else {
                    iA = this.f1441a[i2].a_renamed(Integer.MIN_VALUE);
                    if (iA != Integer.MIN_VALUE) {
                        iD = this.f1442b.d_renamed();
                        iA -= iD;
                    }
                }
                savedState2.mSpanOffsets[i2] = iA;
            }
        } else {
            savedState2.mAnchorPosition = -1;
            savedState2.mVisibleAnchorPosition = -1;
            savedState2.mSpanOffsetsSize = 0;
        }
        return savedState2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public void onInitializeAccessibilityEvent(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            android.view.View viewB = b_renamed(false);
            android.view.View viewC = c_renamed(false);
            if (viewB == null || viewC == null) {
                return;
            }
            int position = getPosition(viewB);
            int position2 = getPosition(viewC);
            if (position < position2) {
                accessibilityEvent.setFromIndex(position);
                accessibilityEvent.setToIndex(position2);
            } else {
                accessibilityEvent.setFromIndex(position2);
                accessibilityEvent.setToIndex(position);
            }
        }
    }

    int e_renamed() {
        android.view.View viewC = this.e_renamed ? c_renamed(true) : b_renamed(true);
        if (viewC == null) {
            return -1;
        }
        return getPosition(viewC);
    }

    android.view.View b_renamed(boolean z_renamed) {
        int iD = this.f1442b.d_renamed();
        int iE = this.f1442b.e_renamed();
        int childCount = getChildCount();
        android.view.View view = null;
        for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
            android.view.View childAt = getChildAt(i_renamed);
            int iA = this.f1442b.a_renamed(childAt);
            if (this.f1442b.b_renamed(childAt) > iD && iA < iE) {
                if (iA >= iD || !z_renamed) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    android.view.View c_renamed(boolean z_renamed) {
        int iD = this.f1442b.d_renamed();
        int iE = this.f1442b.e_renamed();
        android.view.View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            android.view.View childAt = getChildAt(childCount);
            int iA = this.f1442b.a_renamed(childAt);
            int iB = this.f1442b.b_renamed(childAt);
            if (iB > iD && iA < iE) {
                if (iB <= iE || !z_renamed) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    private void b_renamed(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar, boolean z_renamed) {
        int iE;
        int i_renamed = i_renamed(Integer.MIN_VALUE);
        if (i_renamed != Integer.MIN_VALUE && (iE = this.f1442b.e_renamed() - i_renamed) > 0) {
            int i2 = iE - (-a_renamed(-iE, pVar, tVar));
            if (!z_renamed || i2 <= 0) {
                return;
            }
            this.f1442b.a_renamed(i2);
        }
    }

    private void c_renamed(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar, boolean z_renamed) {
        int iD;
        int iH = h_renamed(Integer.MAX_VALUE);
        if (iH != Integer.MAX_VALUE && (iD = iH - this.f1442b.d_renamed()) > 0) {
            int iA = iD - a_renamed(iD, pVar, tVar);
            if (!z_renamed || iA <= 0) {
                return;
            }
            this.f1442b.a_renamed(-iA);
        }
    }

    private void b_renamed(int i_renamed, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        int iG;
        int iG2;
        int iC;
        androidx.recyclerview.widget.i_renamed iVar = this.l_renamed;
        boolean z_renamed = false;
        iVar.f1536b = 0;
        iVar.f1537c = i_renamed;
        if (!isSmoothScrolling() || (iC = tVar.c_renamed()) == -1) {
            iG = 0;
            iG2 = 0;
        } else {
            if (this.e_renamed == (iC < i_renamed)) {
                iG = this.f1442b.g_renamed();
                iG2 = 0;
            } else {
                iG2 = this.f1442b.g_renamed();
                iG = 0;
            }
        }
        if (getClipToPadding()) {
            this.l_renamed.f_renamed = this.f1442b.d_renamed() - iG2;
            this.l_renamed.g_renamed = this.f1442b.e_renamed() + iG;
        } else {
            this.l_renamed.g_renamed = this.f1442b.f_renamed() + iG;
            this.l_renamed.f_renamed = -iG2;
        }
        androidx.recyclerview.widget.i_renamed iVar2 = this.l_renamed;
        iVar2.h_renamed = false;
        iVar2.f1535a = true;
        if (this.f1442b.i_renamed() == 0 && this.f1442b.f_renamed() == 0) {
            z_renamed = true;
        }
        iVar2.i_renamed = z_renamed;
    }

    private void d_renamed(int i_renamed) {
        androidx.recyclerview.widget.i_renamed iVar = this.l_renamed;
        iVar.e_renamed = i_renamed;
        iVar.d_renamed = this.e_renamed != (i_renamed == -1) ? -1 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public void offsetChildrenHorizontal(int i_renamed) {
        super.offsetChildrenHorizontal(i_renamed);
        for (int i2 = 0; i2 < this.i_renamed; i2++) {
            this.f1441a[i2].d_renamed(i_renamed);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public void offsetChildrenVertical(int i_renamed) {
        super.offsetChildrenVertical(i_renamed);
        for (int i2 = 0; i2 < this.i_renamed; i2++) {
            this.f1441a[i2].d_renamed(i_renamed);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public void onItemsRemoved(androidx.recyclerview.widget.RecyclerView recyclerView, int i_renamed, int i2) {
        b_renamed(i_renamed, i2, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public void onItemsAdded(androidx.recyclerview.widget.RecyclerView recyclerView, int i_renamed, int i2) {
        b_renamed(i_renamed, i2, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public void onItemsChanged(androidx.recyclerview.widget.RecyclerView recyclerView) {
        this.h_renamed.a_renamed();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public void onItemsMoved(androidx.recyclerview.widget.RecyclerView recyclerView, int i_renamed, int i2, int i3) {
        b_renamed(i_renamed, i2, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public void onItemsUpdated(androidx.recyclerview.widget.RecyclerView recyclerView, int i_renamed, int i2, java.lang.Object obj) {
        b_renamed(i_renamed, i2, 4);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:15:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:21:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:23:0x0045 A_renamed[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:24:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b_renamed(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.e_renamed
            if (r0 == 0) goto L9
            int r0 = r6.h_renamed()
            goto Ld
        L9:
            int r0 = r6.i_renamed()
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
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r4 = r6.h_renamed
            r4.b_renamed(r2)
            r4 = 1
            if (r9 == r4) goto L3e
            r5 = 2
            if (r9 == r5) goto L38
            if (r9 == r1) goto L2d
            goto L43
        L2d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.h_renamed
            r9.a_renamed(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r7 = r6.h_renamed
            r7.b_renamed(r8, r4)
            goto L43
        L38:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.h_renamed
            r9.a_renamed(r7, r8)
            goto L43
        L3e:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.h_renamed
            r9.b_renamed(r7, r8)
        L43:
            if (r3 > r0) goto L46
            return
        L46:
            boolean r7 = r6.e_renamed
            if (r7 == 0) goto L4f
            int r7 = r6.i_renamed()
            goto L53
        L4f:
            int r7 = r6.h_renamed()
        L53:
            if (r2 > r7) goto L58
            r6.requestLayout()
        L58:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.b_renamed(int, int, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v6 */
    private int a_renamed(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.i_renamed iVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        int i_renamed;
        int iD;
        int i2;
        androidx.recyclerview.widget.StaggeredGridLayoutManager.c_renamed cVarA;
        int iE;
        int i3;
        int iE2;
        int iE3;
        boolean z_renamed;
        boolean zG;
        ?? r9 = 0;
        this.m_renamed.set(0, this.i_renamed, true);
        if (this.l_renamed.i_renamed) {
            i_renamed = iVar.e_renamed == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else if (iVar.e_renamed == 1) {
            i_renamed = iVar.g_renamed + iVar.f1536b;
        } else {
            i_renamed = iVar.f_renamed - iVar.f1536b;
        }
        int i4 = i_renamed;
        a_renamed(iVar.e_renamed, i4);
        if (this.e_renamed) {
            iD = this.f1442b.e_renamed();
        } else {
            iD = this.f1442b.d_renamed();
        }
        int i5 = iD;
        boolean z2 = false;
        while (iVar.a_renamed(tVar) && (this.l_renamed.i_renamed || !this.m_renamed.isEmpty())) {
            android.view.View viewA = iVar.a_renamed(pVar);
            androidx.recyclerview.widget.StaggeredGridLayoutManager.b_renamed bVar = (androidx.recyclerview.widget.StaggeredGridLayoutManager.b_renamed) viewA.getLayoutParams();
            int iF = bVar.f_renamed();
            int iC = this.h_renamed.c_renamed(iF);
            boolean z3 = iC == -1 ? true : r9;
            if (z3) {
                cVarA = bVar.f1451b ? this.f1441a[r9] : a_renamed(iVar);
                this.h_renamed.a_renamed(iF, cVarA);
            } else {
                cVarA = this.f1441a[iC];
            }
            androidx.recyclerview.widget.StaggeredGridLayoutManager.c_renamed cVar = cVarA;
            bVar.f1450a = cVar;
            if (iVar.e_renamed == 1) {
                addView(viewA);
            } else {
                addView(viewA, r9);
            }
            a_renamed(viewA, bVar, (boolean) r9);
            if (iVar.e_renamed == 1) {
                int i6 = bVar.f1451b ? i_renamed(i5) : cVar.b_renamed(i5);
                int iE4 = this.f1442b.e_renamed(viewA) + i6;
                if (z3 && bVar.f1451b) {
                    androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem fullSpanItemE = e_renamed(i6);
                    fullSpanItemE.mGapDir = -1;
                    fullSpanItemE.mPosition = iF;
                    this.h_renamed.a_renamed(fullSpanItemE);
                }
                i3 = iE4;
                iE = i6;
            } else {
                int iH = bVar.f1451b ? h_renamed(i5) : cVar.a_renamed(i5);
                iE = iH - this.f1442b.e_renamed(viewA);
                if (z3 && bVar.f1451b) {
                    androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem fullSpanItemF = f_renamed(iH);
                    fullSpanItemF.mGapDir = 1;
                    fullSpanItemF.mPosition = iF;
                    this.h_renamed.a_renamed(fullSpanItemF);
                }
                i3 = iH;
            }
            if (bVar.f1451b && iVar.d_renamed == -1) {
                if (z3) {
                    this.u_renamed = true;
                } else {
                    if (iVar.e_renamed == 1) {
                        zG = f_renamed();
                    } else {
                        zG = g_renamed();
                    }
                    if (!zG) {
                        androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem fullSpanItemF2 = this.h_renamed.f_renamed(iF);
                        if (fullSpanItemF2 != null) {
                            fullSpanItemF2.mHasUnwantedGapAfter = true;
                        }
                        this.u_renamed = true;
                    }
                }
            }
            a_renamed(viewA, bVar, iVar);
            if (d_renamed() && this.j_renamed == 1) {
                int iE5 = bVar.f1451b ? this.f1443c.e_renamed() : this.f1443c.e_renamed() - (((this.i_renamed - 1) - cVar.e_renamed) * this.k_renamed);
                iE3 = iE5;
                iE2 = iE5 - this.f1443c.e_renamed(viewA);
            } else {
                int iD2 = bVar.f1451b ? this.f1443c.d_renamed() : (cVar.e_renamed * this.k_renamed) + this.f1443c.d_renamed();
                iE2 = iD2;
                iE3 = this.f1443c.e_renamed(viewA) + iD2;
            }
            if (this.j_renamed == 1) {
                layoutDecoratedWithMargins(viewA, iE2, iE, iE3, i3);
            } else {
                layoutDecoratedWithMargins(viewA, iE, iE2, i3, iE3);
            }
            if (bVar.f1451b) {
                a_renamed(this.l_renamed.e_renamed, i4);
            } else {
                a_renamed(cVar, this.l_renamed.e_renamed, i4);
            }
            a_renamed(pVar, this.l_renamed);
            if (!this.l_renamed.h_renamed || !viewA.hasFocusable()) {
                z_renamed = false;
            } else if (bVar.f1451b) {
                this.m_renamed.clear();
                z_renamed = false;
            } else {
                z_renamed = false;
                this.m_renamed.set(cVar.e_renamed, false);
            }
            r9 = z_renamed;
            z2 = true;
        }
        int i7 = r9;
        if (!z2) {
            a_renamed(pVar, this.l_renamed);
        }
        if (this.l_renamed.e_renamed == -1) {
            i2 = this.f1442b.d_renamed() - h_renamed(this.f1442b.d_renamed());
        } else {
            i2 = i_renamed(this.f1442b.e_renamed()) - this.f1442b.e_renamed();
        }
        return i2 > 0 ? java.lang.Math.min(iVar.f1536b, i2) : i7;
    }

    private androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem e_renamed(int i_renamed) {
        androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem fullSpanItem = new androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
        fullSpanItem.mGapPerSpan = new int[this.i_renamed];
        for (int i2 = 0; i2 < this.i_renamed; i2++) {
            fullSpanItem.mGapPerSpan[i2] = i_renamed - this.f1441a[i2].b_renamed(i_renamed);
        }
        return fullSpanItem;
    }

    private androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem f_renamed(int i_renamed) {
        androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem fullSpanItem = new androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem();
        fullSpanItem.mGapPerSpan = new int[this.i_renamed];
        for (int i2 = 0; i2 < this.i_renamed; i2++) {
            fullSpanItem.mGapPerSpan[i2] = this.f1441a[i2].a_renamed(i_renamed) - i_renamed;
        }
        return fullSpanItem;
    }

    private void a_renamed(android.view.View view, androidx.recyclerview.widget.StaggeredGridLayoutManager.b_renamed bVar, androidx.recyclerview.widget.i_renamed iVar) {
        if (iVar.e_renamed == 1) {
            if (bVar.f1451b) {
                a_renamed(view);
                return;
            } else {
                bVar.f1450a.b_renamed(view);
                return;
            }
        }
        if (bVar.f1451b) {
            b_renamed(view);
        } else {
            bVar.f1450a.a_renamed(view);
        }
    }

    private void a_renamed(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.i_renamed iVar) {
        int iMin;
        int iMin2;
        if (!iVar.f1535a || iVar.i_renamed) {
            return;
        }
        if (iVar.f1536b == 0) {
            if (iVar.e_renamed == -1) {
                b_renamed(pVar, iVar.g_renamed);
                return;
            } else {
                a_renamed(pVar, iVar.f_renamed);
                return;
            }
        }
        if (iVar.e_renamed == -1) {
            int iG = iVar.f_renamed - g_renamed(iVar.f_renamed);
            if (iG < 0) {
                iMin2 = iVar.g_renamed;
            } else {
                iMin2 = iVar.g_renamed - java.lang.Math.min(iG, iVar.f1536b);
            }
            b_renamed(pVar, iMin2);
            return;
        }
        int iJ = j_renamed(iVar.g_renamed) - iVar.g_renamed;
        if (iJ < 0) {
            iMin = iVar.f_renamed;
        } else {
            iMin = java.lang.Math.min(iJ, iVar.f1536b) + iVar.f_renamed;
        }
        a_renamed(pVar, iMin);
    }

    private void a_renamed(android.view.View view) {
        for (int i_renamed = this.i_renamed - 1; i_renamed >= 0; i_renamed--) {
            this.f1441a[i_renamed].b_renamed(view);
        }
    }

    private void b_renamed(android.view.View view) {
        for (int i_renamed = this.i_renamed - 1; i_renamed >= 0; i_renamed--) {
            this.f1441a[i_renamed].a_renamed(view);
        }
    }

    private void a_renamed(int i_renamed, int i2) {
        for (int i3 = 0; i3 < this.i_renamed; i3++) {
            if (!this.f1441a[i3].f1452a.isEmpty()) {
                a_renamed(this.f1441a[i3], i_renamed, i2);
            }
        }
    }

    private void a_renamed(androidx.recyclerview.widget.StaggeredGridLayoutManager.c_renamed cVar, int i_renamed, int i2) {
        int i3 = cVar.i_renamed();
        if (i_renamed == -1) {
            if (cVar.b_renamed() + i3 <= i2) {
                this.m_renamed.set(cVar.e_renamed, false);
            }
        } else if (cVar.d_renamed() - i3 >= i2) {
            this.m_renamed.set(cVar.e_renamed, false);
        }
    }

    private int g_renamed(int i_renamed) {
        int iA = this.f1441a[0].a_renamed(i_renamed);
        for (int i2 = 1; i2 < this.i_renamed; i2++) {
            int iA2 = this.f1441a[i2].a_renamed(i_renamed);
            if (iA2 > iA) {
                iA = iA2;
            }
        }
        return iA;
    }

    private int h_renamed(int i_renamed) {
        int iA = this.f1441a[0].a_renamed(i_renamed);
        for (int i2 = 1; i2 < this.i_renamed; i2++) {
            int iA2 = this.f1441a[i2].a_renamed(i_renamed);
            if (iA2 < iA) {
                iA = iA2;
            }
        }
        return iA;
    }

    boolean f_renamed() {
        int iB = this.f1441a[0].b_renamed(Integer.MIN_VALUE);
        for (int i_renamed = 1; i_renamed < this.i_renamed; i_renamed++) {
            if (this.f1441a[i_renamed].b_renamed(Integer.MIN_VALUE) != iB) {
                return false;
            }
        }
        return true;
    }

    boolean g_renamed() {
        int iA = this.f1441a[0].a_renamed(Integer.MIN_VALUE);
        for (int i_renamed = 1; i_renamed < this.i_renamed; i_renamed++) {
            if (this.f1441a[i_renamed].a_renamed(Integer.MIN_VALUE) != iA) {
                return false;
            }
        }
        return true;
    }

    private int i_renamed(int i_renamed) {
        int iB = this.f1441a[0].b_renamed(i_renamed);
        for (int i2 = 1; i2 < this.i_renamed; i2++) {
            int iB2 = this.f1441a[i2].b_renamed(i_renamed);
            if (iB2 > iB) {
                iB = iB2;
            }
        }
        return iB;
    }

    private int j_renamed(int i_renamed) {
        int iB = this.f1441a[0].b_renamed(i_renamed);
        for (int i2 = 1; i2 < this.i_renamed; i2++) {
            int iB2 = this.f1441a[i2].b_renamed(i_renamed);
            if (iB2 < iB) {
                iB = iB2;
            }
        }
        return iB;
    }

    private void a_renamed(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, int i_renamed) {
        while (getChildCount() > 0) {
            android.view.View childAt = getChildAt(0);
            if (this.f1442b.b_renamed(childAt) > i_renamed || this.f1442b.c_renamed(childAt) > i_renamed) {
                return;
            }
            androidx.recyclerview.widget.StaggeredGridLayoutManager.b_renamed bVar = (androidx.recyclerview.widget.StaggeredGridLayoutManager.b_renamed) childAt.getLayoutParams();
            if (bVar.f1451b) {
                for (int i2 = 0; i2 < this.i_renamed; i2++) {
                    if (this.f1441a[i2].f1452a.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.i_renamed; i3++) {
                    this.f1441a[i3].h_renamed();
                }
            } else if (bVar.f1450a.f1452a.size() == 1) {
                return;
            } else {
                bVar.f1450a.h_renamed();
            }
            removeAndRecycleView(childAt, pVar);
        }
    }

    private void b_renamed(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, int i_renamed) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            android.view.View childAt = getChildAt(childCount);
            if (this.f1442b.a_renamed(childAt) < i_renamed || this.f1442b.d_renamed(childAt) < i_renamed) {
                return;
            }
            androidx.recyclerview.widget.StaggeredGridLayoutManager.b_renamed bVar = (androidx.recyclerview.widget.StaggeredGridLayoutManager.b_renamed) childAt.getLayoutParams();
            if (bVar.f1451b) {
                for (int i2 = 0; i2 < this.i_renamed; i2++) {
                    if (this.f1441a[i2].f1452a.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.i_renamed; i3++) {
                    this.f1441a[i3].g_renamed();
                }
            } else if (bVar.f1450a.f1452a.size() == 1) {
                return;
            } else {
                bVar.f1450a.g_renamed();
            }
            removeAndRecycleView(childAt, pVar);
        }
    }

    private boolean k_renamed(int i_renamed) {
        if (this.j_renamed == 0) {
            return (i_renamed == -1) != this.e_renamed;
        }
        return ((i_renamed == -1) == this.e_renamed) == d_renamed();
    }

    private androidx.recyclerview.widget.StaggeredGridLayoutManager.c_renamed a_renamed(androidx.recyclerview.widget.i_renamed iVar) {
        int i_renamed;
        int i2;
        int i3 = -1;
        if (k_renamed(iVar.e_renamed)) {
            i_renamed = this.i_renamed - 1;
            i2 = -1;
        } else {
            i_renamed = 0;
            i3 = this.i_renamed;
            i2 = 1;
        }
        androidx.recyclerview.widget.StaggeredGridLayoutManager.c_renamed cVar = null;
        if (iVar.e_renamed == 1) {
            int i4 = Integer.MAX_VALUE;
            int iD = this.f1442b.d_renamed();
            while (i_renamed != i3) {
                androidx.recyclerview.widget.StaggeredGridLayoutManager.c_renamed cVar2 = this.f1441a[i_renamed];
                int iB = cVar2.b_renamed(iD);
                if (iB < i4) {
                    cVar = cVar2;
                    i4 = iB;
                }
                i_renamed += i2;
            }
            return cVar;
        }
        int i5 = Integer.MIN_VALUE;
        int iE = this.f1442b.e_renamed();
        while (i_renamed != i3) {
            androidx.recyclerview.widget.StaggeredGridLayoutManager.c_renamed cVar3 = this.f1441a[i_renamed];
            int iA = cVar3.a_renamed(iE);
            if (iA > i5) {
                cVar = cVar3;
                i5 = iA;
            }
            i_renamed += i2;
        }
        return cVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public boolean canScrollVertically() {
        return this.j_renamed == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public boolean canScrollHorizontally() {
        return this.j_renamed == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public int scrollHorizontallyBy(int i_renamed, androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        return a_renamed(i_renamed, pVar, tVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public int scrollVerticallyBy(int i_renamed, androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        return a_renamed(i_renamed, pVar, tVar);
    }

    private int l_renamed(int i_renamed) {
        if (getChildCount() == 0) {
            return this.e_renamed ? 1 : -1;
        }
        return (i_renamed < i_renamed()) != this.e_renamed ? -1 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s_renamed.b_renamed
    public android.graphics.PointF computeScrollVectorForPosition(int i_renamed) {
        int iL = l_renamed(i_renamed);
        android.graphics.PointF pointF = new android.graphics.PointF();
        if (iL == 0) {
            return null;
        }
        if (this.j_renamed == 0) {
            pointF.x_renamed = iL;
            pointF.y_renamed = 0.0f;
        } else {
            pointF.x_renamed = 0.0f;
            pointF.y_renamed = iL;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public void smoothScrollToPosition(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.t_renamed tVar, int i_renamed) {
        androidx.recyclerview.widget.j_renamed jVar = new androidx.recyclerview.widget.j_renamed(recyclerView.getContext());
        jVar.setTargetPosition(i_renamed);
        startSmoothScroll(jVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public void scrollToPosition(int i_renamed) {
        androidx.recyclerview.widget.StaggeredGridLayoutManager.SavedState savedState = this.q_renamed;
        if (savedState != null && savedState.mAnchorPosition != i_renamed) {
            this.q_renamed.invalidateAnchorPositionInfo();
        }
        this.f_renamed = i_renamed;
        this.g_renamed = Integer.MIN_VALUE;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public void collectAdjacentPrefetchPositions(int i_renamed, int i2, androidx.recyclerview.widget.RecyclerView.t_renamed tVar, androidx.recyclerview.widget.RecyclerView.i_renamed.a_renamed aVar) {
        int iB;
        int iA;
        if (this.j_renamed != 0) {
            i_renamed = i2;
        }
        if (getChildCount() == 0 || i_renamed == 0) {
            return;
        }
        a_renamed(i_renamed, tVar);
        int[] iArr = this.w_renamed;
        if (iArr == null || iArr.length < this.i_renamed) {
            this.w_renamed = new int[this.i_renamed];
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.i_renamed; i4++) {
            if (this.l_renamed.d_renamed == -1) {
                iB = this.l_renamed.f_renamed;
                iA = this.f1441a[i4].a_renamed(this.l_renamed.f_renamed);
            } else {
                iB = this.f1441a[i4].b_renamed(this.l_renamed.g_renamed);
                iA = this.l_renamed.g_renamed;
            }
            int i5 = iB - iA;
            if (i5 >= 0) {
                this.w_renamed[i3] = i5;
                i3++;
            }
        }
        java.util.Arrays.sort(this.w_renamed, 0, i3);
        for (int i6 = 0; i6 < i3 && this.l_renamed.a_renamed(tVar); i6++) {
            aVar.b_renamed(this.l_renamed.f1537c, this.w_renamed[i6]);
            this.l_renamed.f1537c += this.l_renamed.d_renamed;
        }
    }

    void a_renamed(int i_renamed, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        int i2;
        int i3;
        if (i_renamed > 0) {
            i3 = h_renamed();
            i2 = 1;
        } else {
            i2 = -1;
            i3 = i_renamed();
        }
        this.l_renamed.f1535a = true;
        b_renamed(i3, tVar);
        d_renamed(i2);
        androidx.recyclerview.widget.i_renamed iVar = this.l_renamed;
        iVar.f1537c = i3 + iVar.d_renamed;
        this.l_renamed.f1536b = java.lang.Math.abs(i_renamed);
    }

    int a_renamed(int i_renamed, androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        if (getChildCount() == 0 || i_renamed == 0) {
            return 0;
        }
        a_renamed(i_renamed, tVar);
        int iA = a_renamed(pVar, this.l_renamed, tVar);
        if (this.l_renamed.f1536b >= iA) {
            i_renamed = i_renamed < 0 ? -iA : iA;
        }
        this.f1442b.a_renamed(-i_renamed);
        this.o_renamed = this.e_renamed;
        androidx.recyclerview.widget.i_renamed iVar = this.l_renamed;
        iVar.f1536b = 0;
        a_renamed(pVar, iVar);
        return i_renamed;
    }

    int h_renamed() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    int i_renamed() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    private int m_renamed(int i_renamed) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            int position = getPosition(getChildAt(i2));
            if (position >= 0 && position < i_renamed) {
                return position;
            }
        }
        return 0;
    }

    private int n_renamed(int i_renamed) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            int position = getPosition(getChildAt(childCount));
            if (position >= 0 && position < i_renamed) {
                return position;
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public androidx.recyclerview.widget.RecyclerView.j_renamed generateDefaultLayoutParams() {
        if (this.j_renamed == 0) {
            return new androidx.recyclerview.widget.StaggeredGridLayoutManager.b_renamed(-2, -1);
        }
        return new androidx.recyclerview.widget.StaggeredGridLayoutManager.b_renamed(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public androidx.recyclerview.widget.RecyclerView.j_renamed generateLayoutParams(android.content.Context context, android.util.AttributeSet attributeSet) {
        return new androidx.recyclerview.widget.StaggeredGridLayoutManager.b_renamed(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public androidx.recyclerview.widget.RecyclerView.j_renamed generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof android.view.ViewGroup.MarginLayoutParams) {
            return new androidx.recyclerview.widget.StaggeredGridLayoutManager.b_renamed((android.view.ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new androidx.recyclerview.widget.StaggeredGridLayoutManager.b_renamed(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public boolean checkLayoutParams(androidx.recyclerview.widget.RecyclerView.j_renamed jVar) {
        return jVar instanceof androidx.recyclerview.widget.StaggeredGridLayoutManager.b_renamed;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
    public android.view.View onFocusSearchFailed(android.view.View view, int i_renamed, androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
        android.view.View viewFindContainingItemView;
        int i2;
        int iK;
        int iK2;
        int iK3;
        android.view.View viewA;
        if (getChildCount() == 0 || (viewFindContainingItemView = findContainingItemView(view)) == null) {
            return null;
        }
        k_renamed();
        int iO = o_renamed(i_renamed);
        if (iO == Integer.MIN_VALUE) {
            return null;
        }
        androidx.recyclerview.widget.StaggeredGridLayoutManager.b_renamed bVar = (androidx.recyclerview.widget.StaggeredGridLayoutManager.b_renamed) viewFindContainingItemView.getLayoutParams();
        boolean z_renamed = bVar.f1451b;
        androidx.recyclerview.widget.StaggeredGridLayoutManager.c_renamed cVar = bVar.f1450a;
        if (iO == 1) {
            i2 = h_renamed();
        } else {
            i2 = i_renamed();
        }
        b_renamed(i2, tVar);
        d_renamed(iO);
        androidx.recyclerview.widget.i_renamed iVar = this.l_renamed;
        iVar.f1537c = iVar.d_renamed + i2;
        this.l_renamed.f1536b = (int) (this.f1442b.g_renamed() * 0.33333334f);
        androidx.recyclerview.widget.i_renamed iVar2 = this.l_renamed;
        iVar2.h_renamed = true;
        iVar2.f1535a = false;
        a_renamed(pVar, iVar2, tVar);
        this.o_renamed = this.e_renamed;
        if (!z_renamed && (viewA = cVar.a_renamed(i2, iO)) != null && viewA != viewFindContainingItemView) {
            return viewA;
        }
        if (k_renamed(iO)) {
            for (int i3 = this.i_renamed - 1; i3 >= 0; i3--) {
                android.view.View viewA2 = this.f1441a[i3].a_renamed(i2, iO);
                if (viewA2 != null && viewA2 != viewFindContainingItemView) {
                    return viewA2;
                }
            }
        } else {
            for (int i4 = 0; i4 < this.i_renamed; i4++) {
                android.view.View viewA3 = this.f1441a[i4].a_renamed(i2, iO);
                if (viewA3 != null && viewA3 != viewFindContainingItemView) {
                    return viewA3;
                }
            }
        }
        boolean z2 = (this.d_renamed ^ true) == (iO == -1);
        if (!z_renamed) {
            if (z2) {
                iK3 = cVar.j_renamed();
            } else {
                iK3 = cVar.k_renamed();
            }
            android.view.View viewFindViewByPosition = findViewByPosition(iK3);
            if (viewFindViewByPosition != null && viewFindViewByPosition != viewFindContainingItemView) {
                return viewFindViewByPosition;
            }
        }
        if (k_renamed(iO)) {
            for (int i5 = this.i_renamed - 1; i5 >= 0; i5--) {
                if (i5 != cVar.e_renamed) {
                    if (z2) {
                        iK2 = this.f1441a[i5].j_renamed();
                    } else {
                        iK2 = this.f1441a[i5].k_renamed();
                    }
                    android.view.View viewFindViewByPosition2 = findViewByPosition(iK2);
                    if (viewFindViewByPosition2 != null && viewFindViewByPosition2 != viewFindContainingItemView) {
                        return viewFindViewByPosition2;
                    }
                }
            }
        } else {
            for (int i6 = 0; i6 < this.i_renamed; i6++) {
                if (z2) {
                    iK = this.f1441a[i6].j_renamed();
                } else {
                    iK = this.f1441a[i6].k_renamed();
                }
                android.view.View viewFindViewByPosition3 = findViewByPosition(iK);
                if (viewFindViewByPosition3 != null && viewFindViewByPosition3 != viewFindContainingItemView) {
                    return viewFindViewByPosition3;
                }
            }
        }
        return null;
    }

    private int o_renamed(int i_renamed) {
        return i_renamed != 1 ? i_renamed != 2 ? i_renamed != 17 ? i_renamed != 33 ? i_renamed != 66 ? (i_renamed == 130 && this.j_renamed == 1) ? 1 : Integer.MIN_VALUE : this.j_renamed == 0 ? 1 : Integer.MIN_VALUE : this.j_renamed == 1 ? -1 : Integer.MIN_VALUE : this.j_renamed == 0 ? -1 : Integer.MIN_VALUE : (this.j_renamed != 1 && d_renamed()) ? -1 : 1 : (this.j_renamed != 1 && d_renamed()) ? 1 : -1;
    }

    public static class b_renamed extends androidx.recyclerview.widget.RecyclerView.j_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        androidx.recyclerview.widget.StaggeredGridLayoutManager.c_renamed f1450a;

        /* renamed from: b_renamed, reason: collision with root package name */
        boolean f1451b;

        public b_renamed(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public b_renamed(int i_renamed, int i2) {
            super(i_renamed, i2);
        }

        public b_renamed(android.view.ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public b_renamed(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public boolean a_renamed() {
            return this.f1451b;
        }
    }

    class c_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        java.util.ArrayList<android.view.View> f1452a = new java.util.ArrayList<>();

        /* renamed from: b_renamed, reason: collision with root package name */
        int f1453b = Integer.MIN_VALUE;

        /* renamed from: c_renamed, reason: collision with root package name */
        int f1454c = Integer.MIN_VALUE;
        int d_renamed = 0;
        final int e_renamed;

        c_renamed(int i_renamed) {
            this.e_renamed = i_renamed;
        }

        int a_renamed(int i_renamed) {
            int i2 = this.f1453b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f1452a.size() == 0) {
                return i_renamed;
            }
            a_renamed();
            return this.f1453b;
        }

        void a_renamed() {
            androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem fullSpanItemF;
            android.view.View view = this.f1452a.get(0);
            androidx.recyclerview.widget.StaggeredGridLayoutManager.b_renamed bVarC = c_renamed(view);
            this.f1453b = androidx.recyclerview.widget.StaggeredGridLayoutManager.this.f1442b.a_renamed(view);
            if (bVarC.f1451b && (fullSpanItemF = androidx.recyclerview.widget.StaggeredGridLayoutManager.this.h_renamed.f_renamed(bVarC.f_renamed())) != null && fullSpanItemF.mGapDir == -1) {
                this.f1453b -= fullSpanItemF.getGapForSpan(this.e_renamed);
            }
        }

        int b_renamed() {
            int i_renamed = this.f1453b;
            if (i_renamed != Integer.MIN_VALUE) {
                return i_renamed;
            }
            a_renamed();
            return this.f1453b;
        }

        int b_renamed(int i_renamed) {
            int i2 = this.f1454c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f1452a.size() == 0) {
                return i_renamed;
            }
            c_renamed();
            return this.f1454c;
        }

        void c_renamed() {
            androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem fullSpanItemF;
            java.util.ArrayList<android.view.View> arrayList = this.f1452a;
            android.view.View view = arrayList.get(arrayList.size() - 1);
            androidx.recyclerview.widget.StaggeredGridLayoutManager.b_renamed bVarC = c_renamed(view);
            this.f1454c = androidx.recyclerview.widget.StaggeredGridLayoutManager.this.f1442b.b_renamed(view);
            if (bVarC.f1451b && (fullSpanItemF = androidx.recyclerview.widget.StaggeredGridLayoutManager.this.h_renamed.f_renamed(bVarC.f_renamed())) != null && fullSpanItemF.mGapDir == 1) {
                this.f1454c += fullSpanItemF.getGapForSpan(this.e_renamed);
            }
        }

        int d_renamed() {
            int i_renamed = this.f1454c;
            if (i_renamed != Integer.MIN_VALUE) {
                return i_renamed;
            }
            c_renamed();
            return this.f1454c;
        }

        void a_renamed(android.view.View view) {
            androidx.recyclerview.widget.StaggeredGridLayoutManager.b_renamed bVarC = c_renamed(view);
            bVarC.f1450a = this;
            this.f1452a.add(0, view);
            this.f1453b = Integer.MIN_VALUE;
            if (this.f1452a.size() == 1) {
                this.f1454c = Integer.MIN_VALUE;
            }
            if (bVarC.d_renamed() || bVarC.e_renamed()) {
                this.d_renamed += androidx.recyclerview.widget.StaggeredGridLayoutManager.this.f1442b.e_renamed(view);
            }
        }

        void b_renamed(android.view.View view) {
            androidx.recyclerview.widget.StaggeredGridLayoutManager.b_renamed bVarC = c_renamed(view);
            bVarC.f1450a = this;
            this.f1452a.add(view);
            this.f1454c = Integer.MIN_VALUE;
            if (this.f1452a.size() == 1) {
                this.f1453b = Integer.MIN_VALUE;
            }
            if (bVarC.d_renamed() || bVarC.e_renamed()) {
                this.d_renamed += androidx.recyclerview.widget.StaggeredGridLayoutManager.this.f1442b.e_renamed(view);
            }
        }

        void a_renamed(boolean z_renamed, int i_renamed) {
            int iA;
            if (z_renamed) {
                iA = b_renamed(Integer.MIN_VALUE);
            } else {
                iA = a_renamed(Integer.MIN_VALUE);
            }
            e_renamed();
            if (iA == Integer.MIN_VALUE) {
                return;
            }
            if (!z_renamed || iA >= androidx.recyclerview.widget.StaggeredGridLayoutManager.this.f1442b.e_renamed()) {
                if (z_renamed || iA <= androidx.recyclerview.widget.StaggeredGridLayoutManager.this.f1442b.d_renamed()) {
                    if (i_renamed != Integer.MIN_VALUE) {
                        iA += i_renamed;
                    }
                    this.f1454c = iA;
                    this.f1453b = iA;
                }
            }
        }

        void e_renamed() {
            this.f1452a.clear();
            f_renamed();
            this.d_renamed = 0;
        }

        void f_renamed() {
            this.f1453b = Integer.MIN_VALUE;
            this.f1454c = Integer.MIN_VALUE;
        }

        void c_renamed(int i_renamed) {
            this.f1453b = i_renamed;
            this.f1454c = i_renamed;
        }

        void g_renamed() {
            int size = this.f1452a.size();
            android.view.View viewRemove = this.f1452a.remove(size - 1);
            androidx.recyclerview.widget.StaggeredGridLayoutManager.b_renamed bVarC = c_renamed(viewRemove);
            bVarC.f1450a = null;
            if (bVarC.d_renamed() || bVarC.e_renamed()) {
                this.d_renamed -= androidx.recyclerview.widget.StaggeredGridLayoutManager.this.f1442b.e_renamed(viewRemove);
            }
            if (size == 1) {
                this.f1453b = Integer.MIN_VALUE;
            }
            this.f1454c = Integer.MIN_VALUE;
        }

        void h_renamed() {
            android.view.View viewRemove = this.f1452a.remove(0);
            androidx.recyclerview.widget.StaggeredGridLayoutManager.b_renamed bVarC = c_renamed(viewRemove);
            bVarC.f1450a = null;
            if (this.f1452a.size() == 0) {
                this.f1454c = Integer.MIN_VALUE;
            }
            if (bVarC.d_renamed() || bVarC.e_renamed()) {
                this.d_renamed -= androidx.recyclerview.widget.StaggeredGridLayoutManager.this.f1442b.e_renamed(viewRemove);
            }
            this.f1453b = Integer.MIN_VALUE;
        }

        public int i_renamed() {
            return this.d_renamed;
        }

        androidx.recyclerview.widget.StaggeredGridLayoutManager.b_renamed c_renamed(android.view.View view) {
            return (androidx.recyclerview.widget.StaggeredGridLayoutManager.b_renamed) view.getLayoutParams();
        }

        void d_renamed(int i_renamed) {
            int i2 = this.f1453b;
            if (i2 != Integer.MIN_VALUE) {
                this.f1453b = i2 + i_renamed;
            }
            int i3 = this.f1454c;
            if (i3 != Integer.MIN_VALUE) {
                this.f1454c = i3 + i_renamed;
            }
        }

        public int j_renamed() {
            if (androidx.recyclerview.widget.StaggeredGridLayoutManager.this.d_renamed) {
                return a_renamed(this.f1452a.size() - 1, -1, true);
            }
            return a_renamed(0, this.f1452a.size(), true);
        }

        public int k_renamed() {
            if (androidx.recyclerview.widget.StaggeredGridLayoutManager.this.d_renamed) {
                return a_renamed(0, this.f1452a.size(), true);
            }
            return a_renamed(this.f1452a.size() - 1, -1, true);
        }

        int a_renamed(int i_renamed, int i2, boolean z_renamed, boolean z2, boolean z3) {
            int iD = androidx.recyclerview.widget.StaggeredGridLayoutManager.this.f1442b.d_renamed();
            int iE = androidx.recyclerview.widget.StaggeredGridLayoutManager.this.f1442b.e_renamed();
            int i3 = i2 > i_renamed ? 1 : -1;
            while (i_renamed != i2) {
                android.view.View view = this.f1452a.get(i_renamed);
                int iA = androidx.recyclerview.widget.StaggeredGridLayoutManager.this.f1442b.a_renamed(view);
                int iB = androidx.recyclerview.widget.StaggeredGridLayoutManager.this.f1442b.b_renamed(view);
                boolean z4 = false;
                boolean z5 = !z3 ? iA >= iE : iA > iE;
                if (!z3 ? iB > iD : iB >= iD) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (z_renamed && z2) {
                        if (iA >= iD && iB <= iE) {
                            return androidx.recyclerview.widget.StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    } else {
                        if (z2) {
                            return androidx.recyclerview.widget.StaggeredGridLayoutManager.this.getPosition(view);
                        }
                        if (iA < iD || iB > iE) {
                            return androidx.recyclerview.widget.StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    }
                }
                i_renamed += i3;
            }
            return -1;
        }

        int a_renamed(int i_renamed, int i2, boolean z_renamed) {
            return a_renamed(i_renamed, i2, false, false, z_renamed);
        }

        public android.view.View a_renamed(int i_renamed, int i2) {
            android.view.View view = null;
            if (i2 == -1) {
                int size = this.f1452a.size();
                int i3 = 0;
                while (i3 < size) {
                    android.view.View view2 = this.f1452a.get(i3);
                    if ((androidx.recyclerview.widget.StaggeredGridLayoutManager.this.d_renamed && androidx.recyclerview.widget.StaggeredGridLayoutManager.this.getPosition(view2) <= i_renamed) || ((!androidx.recyclerview.widget.StaggeredGridLayoutManager.this.d_renamed && androidx.recyclerview.widget.StaggeredGridLayoutManager.this.getPosition(view2) >= i_renamed) || !view2.hasFocusable())) {
                        break;
                    }
                    i3++;
                    view = view2;
                }
            } else {
                int size2 = this.f1452a.size() - 1;
                while (size2 >= 0) {
                    android.view.View view3 = this.f1452a.get(size2);
                    if ((androidx.recyclerview.widget.StaggeredGridLayoutManager.this.d_renamed && androidx.recyclerview.widget.StaggeredGridLayoutManager.this.getPosition(view3) >= i_renamed) || ((!androidx.recyclerview.widget.StaggeredGridLayoutManager.this.d_renamed && androidx.recyclerview.widget.StaggeredGridLayoutManager.this.getPosition(view3) <= i_renamed) || !view3.hasFocusable())) {
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

        /* renamed from: a_renamed, reason: collision with root package name */
        int[] f1445a;

        /* renamed from: b_renamed, reason: collision with root package name */
        java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> f1446b;

        LazySpanLookup() {
        }

        int a_renamed(int i_renamed) {
            java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> list = this.f1446b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f1446b.get(size).mPosition >= i_renamed) {
                        this.f1446b.remove(size);
                    }
                }
            }
            return b_renamed(i_renamed);
        }

        int b_renamed(int i_renamed) {
            int[] iArr = this.f1445a;
            if (iArr == null || i_renamed >= iArr.length) {
                return -1;
            }
            int iG = g_renamed(i_renamed);
            if (iG == -1) {
                int[] iArr2 = this.f1445a;
                java.util.Arrays.fill(iArr2, i_renamed, iArr2.length, -1);
                return this.f1445a.length;
            }
            int i2 = iG + 1;
            java.util.Arrays.fill(this.f1445a, i_renamed, i2, -1);
            return i2;
        }

        int c_renamed(int i_renamed) {
            int[] iArr = this.f1445a;
            if (iArr == null || i_renamed >= iArr.length) {
                return -1;
            }
            return iArr[i_renamed];
        }

        void a_renamed(int i_renamed, androidx.recyclerview.widget.StaggeredGridLayoutManager.c_renamed cVar) {
            e_renamed(i_renamed);
            this.f1445a[i_renamed] = cVar.e_renamed;
        }

        int d_renamed(int i_renamed) {
            int length = this.f1445a.length;
            while (length <= i_renamed) {
                length *= 2;
            }
            return length;
        }

        void e_renamed(int i_renamed) {
            int[] iArr = this.f1445a;
            if (iArr == null) {
                this.f1445a = new int[java.lang.Math.max(i_renamed, 10) + 1];
                java.util.Arrays.fill(this.f1445a, -1);
            } else if (i_renamed >= iArr.length) {
                this.f1445a = new int[d_renamed(i_renamed)];
                java.lang.System.arraycopy(iArr, 0, this.f1445a, 0, iArr.length);
                int[] iArr2 = this.f1445a;
                java.util.Arrays.fill(iArr2, iArr.length, iArr2.length, -1);
            }
        }

        void a_renamed() {
            int[] iArr = this.f1445a;
            if (iArr != null) {
                java.util.Arrays.fill(iArr, -1);
            }
            this.f1446b = null;
        }

        void a_renamed(int i_renamed, int i2) {
            int[] iArr = this.f1445a;
            if (iArr == null || i_renamed >= iArr.length) {
                return;
            }
            int i3 = i_renamed + i2;
            e_renamed(i3);
            int[] iArr2 = this.f1445a;
            java.lang.System.arraycopy(iArr2, i3, iArr2, i_renamed, (iArr2.length - i_renamed) - i2);
            int[] iArr3 = this.f1445a;
            java.util.Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
            c_renamed(i_renamed, i2);
        }

        private void c_renamed(int i_renamed, int i2) {
            java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> list = this.f1446b;
            if (list == null) {
                return;
            }
            int i3 = i_renamed + i2;
            for (int size = list.size() - 1; size >= 0; size--) {
                androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem fullSpanItem = this.f1446b.get(size);
                if (fullSpanItem.mPosition >= i_renamed) {
                    if (fullSpanItem.mPosition < i3) {
                        this.f1446b.remove(size);
                    } else {
                        fullSpanItem.mPosition -= i2;
                    }
                }
            }
        }

        void b_renamed(int i_renamed, int i2) {
            int[] iArr = this.f1445a;
            if (iArr == null || i_renamed >= iArr.length) {
                return;
            }
            int i3 = i_renamed + i2;
            e_renamed(i3);
            int[] iArr2 = this.f1445a;
            java.lang.System.arraycopy(iArr2, i_renamed, iArr2, i3, (iArr2.length - i_renamed) - i2);
            java.util.Arrays.fill(this.f1445a, i_renamed, i3, -1);
            d_renamed(i_renamed, i2);
        }

        private void d_renamed(int i_renamed, int i2) {
            java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> list = this.f1446b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem fullSpanItem = this.f1446b.get(size);
                if (fullSpanItem.mPosition >= i_renamed) {
                    fullSpanItem.mPosition += i2;
                }
            }
        }

        private int g_renamed(int i_renamed) {
            if (this.f1446b == null) {
                return -1;
            }
            androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem fullSpanItemF = f_renamed(i_renamed);
            if (fullSpanItemF != null) {
                this.f1446b.remove(fullSpanItemF);
            }
            int size = this.f1446b.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                }
                if (this.f1446b.get(i2).mPosition >= i_renamed) {
                    break;
                }
                i2++;
            }
            if (i2 == -1) {
                return -1;
            }
            androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem fullSpanItem = this.f1446b.get(i2);
            this.f1446b.remove(i2);
            return fullSpanItem.mPosition;
        }

        public void a_renamed(androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem fullSpanItem) {
            if (this.f1446b == null) {
                this.f1446b = new java.util.ArrayList();
            }
            int size = this.f1446b.size();
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem fullSpanItem2 = this.f1446b.get(i_renamed);
                if (fullSpanItem2.mPosition == fullSpanItem.mPosition) {
                    this.f1446b.remove(i_renamed);
                }
                if (fullSpanItem2.mPosition >= fullSpanItem.mPosition) {
                    this.f1446b.add(i_renamed, fullSpanItem);
                    return;
                }
            }
            this.f1446b.add(fullSpanItem);
        }

        public androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem f_renamed(int i_renamed) {
            java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> list = this.f1446b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem fullSpanItem = this.f1446b.get(size);
                if (fullSpanItem.mPosition == i_renamed) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem a_renamed(int i_renamed, int i2, int i3, boolean z_renamed) {
            java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> list = this.f1446b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem fullSpanItem = this.f1446b.get(i4);
                if (fullSpanItem.mPosition >= i2) {
                    return null;
                }
                if (fullSpanItem.mPosition >= i_renamed && (i3 == 0 || fullSpanItem.mGapDir == i3 || (z_renamed && fullSpanItem.mHasUnwantedGapAfter))) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        @android.annotation.SuppressLint({"BanParcelableUsage"})
        static class FullSpanItem implements android.os.Parcelable {
            public static final android.os.Parcelable.Creator<androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> CREATOR = new android.os.Parcelable.Creator<androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem>() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.1
                @Override // android.os.Parcelable.Creator
                /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
                public androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem createFromParcel(android.os.Parcel parcel) {
                    return new androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
                public androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem[] newArray(int i_renamed) {
                    return new androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem[i_renamed];
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

            FullSpanItem(android.os.Parcel parcel) {
                this.mPosition = parcel.readInt();
                this.mGapDir = parcel.readInt();
                this.mHasUnwantedGapAfter = parcel.readInt() == 1;
                int i_renamed = parcel.readInt();
                if (i_renamed > 0) {
                    this.mGapPerSpan = new int[i_renamed];
                    parcel.readIntArray(this.mGapPerSpan);
                }
            }

            FullSpanItem() {
            }

            int getGapForSpan(int i_renamed) {
                int[] iArr = this.mGapPerSpan;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i_renamed];
            }

            @Override // android.os.Parcelable
            public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
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

            public java.lang.String toString() {
                return "FullSpanItem{mPosition=" + this.mPosition + ", mGapDir=" + this.mGapDir + ", mHasUnwantedGapAfter=" + this.mHasUnwantedGapAfter + ", mGapPerSpan=" + java.util.Arrays.toString(this.mGapPerSpan) + '}';
            }
        }
    }

    @android.annotation.SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements android.os.Parcelable {
        public static final android.os.Parcelable.Creator<androidx.recyclerview.widget.StaggeredGridLayoutManager.SavedState> CREATOR = new android.os.Parcelable.Creator<androidx.recyclerview.widget.StaggeredGridLayoutManager.SavedState>() { // from class: androidx.recyclerview.widget.StaggeredGridLayoutManager.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public androidx.recyclerview.widget.StaggeredGridLayoutManager.SavedState createFromParcel(android.os.Parcel parcel) {
                return new androidx.recyclerview.widget.StaggeredGridLayoutManager.SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public androidx.recyclerview.widget.StaggeredGridLayoutManager.SavedState[] newArray(int i_renamed) {
                return new androidx.recyclerview.widget.StaggeredGridLayoutManager.SavedState[i_renamed];
            }
        };
        boolean mAnchorLayoutFromEnd;
        int mAnchorPosition;
        java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> mFullSpanItems;
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

        SavedState(android.os.Parcel parcel) {
            this.mAnchorPosition = parcel.readInt();
            this.mVisibleAnchorPosition = parcel.readInt();
            this.mSpanOffsetsSize = parcel.readInt();
            int i_renamed = this.mSpanOffsetsSize;
            if (i_renamed > 0) {
                this.mSpanOffsets = new int[i_renamed];
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
            this.mFullSpanItems = parcel.readArrayList(androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(androidx.recyclerview.widget.StaggeredGridLayoutManager.SavedState savedState) {
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
        public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
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

    class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        int f1447a;

        /* renamed from: b_renamed, reason: collision with root package name */
        int f1448b;

        /* renamed from: c_renamed, reason: collision with root package name */
        boolean f1449c;
        boolean d_renamed;
        boolean e_renamed;
        int[] f_renamed;

        a_renamed() {
            a_renamed();
        }

        void a_renamed() {
            this.f1447a = -1;
            this.f1448b = Integer.MIN_VALUE;
            this.f1449c = false;
            this.d_renamed = false;
            this.e_renamed = false;
            int[] iArr = this.f_renamed;
            if (iArr != null) {
                java.util.Arrays.fill(iArr, -1);
            }
        }

        void a_renamed(androidx.recyclerview.widget.StaggeredGridLayoutManager.c_renamed[] cVarArr) {
            int length = cVarArr.length;
            int[] iArr = this.f_renamed;
            if (iArr == null || iArr.length < length) {
                this.f_renamed = new int[androidx.recyclerview.widget.StaggeredGridLayoutManager.this.f1441a.length];
            }
            for (int i_renamed = 0; i_renamed < length; i_renamed++) {
                this.f_renamed[i_renamed] = cVarArr[i_renamed].a_renamed(Integer.MIN_VALUE);
            }
        }

        void b_renamed() {
            this.f1448b = this.f1449c ? androidx.recyclerview.widget.StaggeredGridLayoutManager.this.f1442b.e_renamed() : androidx.recyclerview.widget.StaggeredGridLayoutManager.this.f1442b.d_renamed();
        }

        void a_renamed(int i_renamed) {
            if (this.f1449c) {
                this.f1448b = androidx.recyclerview.widget.StaggeredGridLayoutManager.this.f1442b.e_renamed() - i_renamed;
            } else {
                this.f1448b = androidx.recyclerview.widget.StaggeredGridLayoutManager.this.f1442b.d_renamed() + i_renamed;
            }
        }
    }
}
