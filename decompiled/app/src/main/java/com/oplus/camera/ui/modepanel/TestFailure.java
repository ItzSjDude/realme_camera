package com.oplus.camera.ui.modepanel;

/* compiled from: ItemDragHelper.java */
/* loaded from: classes2.dex */
public class f_renamed {
    private com.oplus.camera.screen.g_renamed A_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.app.Activity f6724a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.oplus.camera.ui.modepanel.e_renamed f6725b;
    private int l_renamed;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f6726c = -1;
    private androidx.recyclerview.widget.RecyclerView d_renamed = null;
    private androidx.recyclerview.widget.RecyclerView e_renamed = null;
    private androidx.recyclerview.widget.RecyclerView f_renamed = null;
    private com.oplus.camera.ui.CameraUIListener g_renamed = null;
    private int h_renamed = -1;
    private int i_renamed = -1;
    private float j_renamed = 0.3f;
    private float k_renamed = 0.1f;
    private androidx.recyclerview.widget.RecyclerView m_renamed = null;
    private boolean n_renamed = false;
    private android.view.View o_renamed = null;
    private int p_renamed = 0;
    private int q_renamed = 0;
    private int r_renamed = 0;
    private int s_renamed = 0;
    private int t_renamed = 0;
    private int u_renamed = 90;
    private long v_renamed = 0;
    private int w_renamed = -1;
    private android.graphics.Rect x_renamed = null;
    private long y_renamed = 0;
    private int[] z_renamed = null;
    private final java.lang.Runnable B_renamed = new java.lang.Runnable() { // from class: com.oplus.camera.ui.modepanel.f_renamed.1
        @Override // java.lang.Runnable
        public void run() throws android.database.SQLException {
            com.oplus.camera.ui.modepanel.f_renamed fVar = com.oplus.camera.ui.modepanel.f_renamed.this;
            float[] fArrD = fVar.d_renamed(fVar.f_renamed, com.oplus.camera.ui.modepanel.f_renamed.this.q_renamed, com.oplus.camera.ui.modepanel.f_renamed.this.r_renamed);
            com.oplus.camera.ui.modepanel.f_renamed fVar2 = com.oplus.camera.ui.modepanel.f_renamed.this;
            float[] fArrD2 = fVar2.d_renamed(fVar2.d_renamed, com.oplus.camera.ui.modepanel.f_renamed.this.q_renamed, com.oplus.camera.ui.modepanel.f_renamed.this.r_renamed);
            com.oplus.camera.ui.modepanel.f_renamed fVar3 = com.oplus.camera.ui.modepanel.f_renamed.this;
            boolean zA = fVar3.a_renamed(fVar3.f_renamed, (int) fArrD[0], (int) fArrD[1]);
            com.oplus.camera.ui.modepanel.f_renamed fVar4 = com.oplus.camera.ui.modepanel.f_renamed.this;
            boolean zA2 = fVar4.a_renamed(fVar4.d_renamed, (int) fArrD2[0], (int) fArrD2[1]);
            if (com.oplus.camera.ui.modepanel.f_renamed.this.a_renamed()) {
                if (zA || zA2) {
                    com.oplus.camera.ui.modepanel.f_renamed.this.a_renamed(r0.q_renamed, com.oplus.camera.ui.modepanel.f_renamed.this.r_renamed);
                    com.oplus.camera.ui.modepanel.f_renamed.this.d_renamed.removeCallbacks(com.oplus.camera.ui.modepanel.f_renamed.this.B_renamed);
                    androidx.core.h_renamed.v_renamed.a_renamed(com.oplus.camera.ui.modepanel.f_renamed.this.d_renamed, this);
                }
            }
        }
    };

    private boolean a_renamed(int i_renamed, int i2) {
        return (i_renamed == i2 || i_renamed == -1 || i2 == -1) ? false : true;
    }

    private boolean b_renamed(int i_renamed, int i2) {
        return i_renamed == -1 && i2 != -1;
    }

    public f_renamed(android.app.Activity activity, com.oplus.camera.screen.g_renamed gVar) {
        this.f6724a = null;
        this.f6725b = null;
        this.l_renamed = 0;
        this.A_renamed = null;
        this.f6724a = activity;
        this.f6725b = new com.oplus.camera.ui.modepanel.e_renamed(activity, gVar);
        this.l_renamed = com.oplus.camera.util.Util.getScreenHeight() - com.oplus.camera.util.Util.O_renamed();
        this.A_renamed = gVar;
    }

    public void a_renamed(androidx.recyclerview.widget.RecyclerView recyclerView) {
        if (recyclerView != this.e_renamed) {
            this.e_renamed = recyclerView;
        }
    }

    public void a_renamed(androidx.recyclerview.widget.RecyclerView recyclerView, com.oplus.camera.ui.CameraUIListener cameraUIListener) {
        if (recyclerView != this.f_renamed) {
            this.f_renamed = recyclerView;
        }
        if (cameraUIListener != this.g_renamed) {
            this.g_renamed = cameraUIListener;
        }
    }

    public void a_renamed(int i_renamed) {
        this.t_renamed = i_renamed;
        this.u_renamed = this.A_renamed.a_renamed().k_renamed();
        com.oplus.camera.ui.modepanel.e_renamed eVar = this.f6725b;
        if (eVar != null) {
            eVar.a_renamed(i_renamed);
        }
        if (3 == this.t_renamed) {
            this.l_renamed = com.oplus.camera.util.Util.getScreenHeight() - ((int) com.oplus.camera.util.Util.h_renamed(com.oplus.camera.R_renamed.dimen.fold_split_screen_control_panel_height));
        } else {
            this.l_renamed = com.oplus.camera.util.Util.getScreenHeight() - com.oplus.camera.util.Util.O_renamed();
        }
    }

    public void a_renamed(androidx.recyclerview.widget.RecyclerView recyclerView, android.view.View view, int i_renamed, android.view.MotionEvent motionEvent) {
        if (java.lang.System.currentTimeMillis() - this.v_renamed < android.view.ViewConfiguration.getLongPressTimeout()) {
            com.oplus.camera.e_renamed.f_renamed("ItemDragHelper", "startDrag, time interval is_renamed too short.");
            return;
        }
        if (a_renamed() || b_renamed()) {
            com.oplus.camera.e_renamed.f_renamed("ItemDragHelper", "startDrag, float view is_renamed shown, parent: " + recyclerView + ", isAnimationRunning: " + b_renamed());
            return;
        }
        if (this.p_renamed == 0) {
            com.oplus.camera.e_renamed.f_renamed("ItemDragHelper", "startDrag, mLastTouchX is_renamed invalid.");
            return;
        }
        int pointerCount = motionEvent.getPointerCount();
        if (1 < pointerCount) {
            com.oplus.camera.e_renamed.a_renamed("ItemDragHelper", "startDrag, can't_renamed process multi-touch events, count: " + pointerCount);
            return;
        }
        if (5 == motionEvent.getActionMasked() || 6 == motionEvent.getActionMasked()) {
            return;
        }
        this.p_renamed = (int) (motionEvent.getX() + 0.5f);
        this.m_renamed = recyclerView;
        this.o_renamed = view;
        this.n_renamed = false;
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition != -1) {
            i_renamed = childAdapterPosition;
        }
        com.oplus.camera.ui.modepanel.k_renamed kVar = (com.oplus.camera.ui.modepanel.k_renamed) this.o_renamed.getTag(com.oplus.camera.R_renamed.id_renamed.tag_recycle_view_mode_info);
        if (kVar == null || !kVar.g_renamed()) {
            com.oplus.camera.e_renamed.f_renamed("ItemDragHelper", "startDrag, mDragModeInfo: " + kVar + " can't_renamed be_renamed selected.");
            return;
        }
        a_renamed(this.o_renamed, kVar);
        this.f6726c = recyclerView == this.e_renamed ? 0 : 1;
        this.d_renamed = recyclerView;
        this.h_renamed = i_renamed;
        this.i_renamed = -1;
        android.graphics.Rect rectC = com.oplus.camera.ui.modepanel.c_renamed.c_renamed(this.o_renamed, this.t_renamed, this.u_renamed);
        com.oplus.camera.ui.modepanel.k_renamed kVar2 = (com.oplus.camera.ui.modepanel.k_renamed) this.o_renamed.getTag(com.oplus.camera.R_renamed.id_renamed.tag_recycle_view_mode_info);
        int iB = b_renamed(recyclerView);
        boolean z_renamed = 1 == android.text.TextUtils.getLayoutDirectionFromLocale(java.util.Locale.getDefault());
        if (4 == this.t_renamed) {
            if (this.u_renamed == 90) {
                rectC.right = rectC.left;
                rectC.left += this.o_renamed.getHeight();
            } else {
                int i2 = com.oplus.camera.screen.f_renamed.f5372b - rectC.bottom;
                int i3 = com.oplus.camera.screen.f_renamed.f5371a - rectC.left;
                rectC.top = i2;
                rectC.left = i3;
            }
        }
        this.f6725b.a_renamed(kVar2, iB, z_renamed ? com.oplus.camera.util.Util.getScreenWidth() - rectC.right : rectC.left, rectC.top, view.getWidth());
        androidx.recyclerview.widget.RecyclerView.j_renamed jVar = (androidx.recyclerview.widget.RecyclerView.j_renamed) this.o_renamed.getLayoutParams();
        this.s_renamed = this.o_renamed.getWidth() + jVar.leftMargin + jVar.rightMargin;
        if (this.e_renamed.getChildAt(0) != null) {
            this.x_renamed = com.oplus.camera.ui.modepanel.c_renamed.c_renamed(this.e_renamed.getChildAt(0), this.t_renamed, this.u_renamed);
        } else {
            this.x_renamed = com.oplus.camera.ui.modepanel.c_renamed.c_renamed(this.e_renamed, this.t_renamed, this.u_renamed);
            android.graphics.Rect rect = this.x_renamed;
            rect.bottom = rect.top + com.oplus.camera.k_renamed.e_renamed();
        }
        this.g_renamed.g_renamed(0);
        a_renamed(z_renamed);
    }

    private void a_renamed(boolean z_renamed) {
        int[] iArr = this.z_renamed;
        if (iArr == null || java.util.Arrays.binarySearch(iArr, 0) < 0) {
            this.z_renamed = new int[com.oplus.camera.ui.modepanel.p_renamed.f6753a];
            for (int i_renamed = 0; i_renamed < com.oplus.camera.ui.modepanel.p_renamed.f6753a; i_renamed++) {
                android.view.View viewFindViewByPosition = this.e_renamed.getLayoutManager().findViewByPosition(i_renamed);
                if (viewFindViewByPosition != null) {
                    int i2 = this.t_renamed;
                    if (4 == i2) {
                        this.z_renamed[i_renamed] = com.oplus.camera.ui.modepanel.c_renamed.c_renamed(viewFindViewByPosition, i2, this.u_renamed).top;
                    } else {
                        this.z_renamed[i_renamed] = com.oplus.camera.ui.modepanel.c_renamed.c_renamed(viewFindViewByPosition, i2, this.u_renamed).left;
                    }
                }
            }
        }
        for (int i3 = 1; i3 < com.oplus.camera.ui.modepanel.p_renamed.f6753a; i3++) {
            int[] iArr2 = this.z_renamed;
            if (iArr2[i3] == 0) {
                if (z_renamed) {
                    iArr2[i3] = (iArr2[i3 - 1] - com.oplus.camera.k_renamed.d_renamed()) - com.oplus.camera.k_renamed.c_renamed();
                } else {
                    iArr2[i3] = iArr2[i3 - 1] + com.oplus.camera.k_renamed.d_renamed() + com.oplus.camera.k_renamed.c_renamed();
                }
            }
        }
    }

    private int b_renamed(androidx.recyclerview.widget.RecyclerView recyclerView) {
        if (recyclerView == this.e_renamed) {
            return 1;
        }
        return recyclerView == this.f_renamed ? 2 : -1;
    }

    public void a_renamed(android.view.MotionEvent motionEvent) {
        if (motionEvent == null) {
            return;
        }
        int pointerCount = motionEvent.getPointerCount();
        int actionMasked = motionEvent.getActionMasked();
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (java.lang.System.currentTimeMillis() - this.v_renamed < android.view.ViewConfiguration.getLongPressTimeout() && 1 != actionMasked && 3 != actionMasked && 4 != actionMasked) {
            com.oplus.camera.e_renamed.a_renamed("ItemDragHelper", "onDrag, time interval is_renamed too short, action: " + actionMasked);
            return;
        }
        if (pointerCount > 1 && 1 != actionMasked && 6 != actionMasked && 3 != actionMasked) {
            com.oplus.camera.e_renamed.a_renamed("ItemDragHelper", "onDrag, can't_renamed process multi-touch events, count: " + pointerCount + ", action: " + actionMasked);
            return;
        }
        if (5 == actionMasked || (6 == actionMasked && motionEvent.getPointerId(action) != this.w_renamed)) {
            com.oplus.camera.e_renamed.a_renamed("ItemDragHelper", "onDrag, can't_renamed process action: " + actionMasked + ", index: " + action + ", getPointerId: " + motionEvent.getPointerId(action) + ", mActivePointerId: " + this.w_renamed);
            return;
        }
        if (actionMasked == 0) {
            if (-1 != this.w_renamed) {
                return;
            } else {
                this.w_renamed = motionEvent.getPointerId(0);
            }
        }
        if (motionEvent.getPointerId(0) != this.w_renamed) {
            return;
        }
        this.p_renamed = (int) (motionEvent.getX() + 0.5f);
        this.q_renamed = (int) (motionEvent.getRawX() + 0.5f);
        this.r_renamed = (int) (motionEvent.getRawY() + 0.5f);
        this.f6725b.a_renamed(motionEvent);
        if (this.e_renamed == null || this.f_renamed == null) {
            com.oplus.camera.e_renamed.f_renamed("ItemDragHelper", "onDrag, host is_renamed null, mModelistHost: " + this.e_renamed + ", mHeadlineHost: " + this.f_renamed);
            return;
        }
        if (!this.f6725b.c_renamed()) {
            com.oplus.camera.e_renamed.a_renamed("ItemDragHelper", "onDrag, can't_renamed process event when float view is_renamed not shown.");
            return;
        }
        com.oplus.camera.ui.modepanel.k_renamed kVar = (com.oplus.camera.ui.modepanel.k_renamed) this.o_renamed.getTag(com.oplus.camera.R_renamed.id_renamed.tag_recycle_view_mode_info);
        android.graphics.Rect rectG = this.f6725b.g_renamed();
        c_renamed(rectG, kVar);
        com.oplus.camera.e_renamed.a_renamed("ItemDragHelper", "onDrag, mDividY: " + this.l_renamed + ", mLastTouchX: " + this.p_renamed + ", event: " + motionEvent);
        if (2 == actionMasked) {
            a_renamed(this.q_renamed, this.r_renamed);
            c_renamed();
        } else if (1 == actionMasked || 6 == actionMasked || 3 == actionMasked || 4 == actionMasked) {
            this.v_renamed = java.lang.System.currentTimeMillis();
            a_renamed(rectG);
        }
    }

    private void c_renamed() {
        androidx.recyclerview.widget.RecyclerView recyclerView = this.d_renamed;
        if (recyclerView != null) {
            recyclerView.removeCallbacks(this.B_renamed);
            this.B_renamed.run();
            this.d_renamed.invalidate();
        }
    }

    private void a_renamed(final android.graphics.Rect rect) {
        com.oplus.camera.e_renamed.f_renamed("ItemDragHelper", "stopDrag, mLastItemPos: " + this.h_renamed + ", mLastHost: " + this.d_renamed);
        if (this.f6725b.c_renamed()) {
            final com.oplus.camera.ui.modepanel.k_renamed kVar = (com.oplus.camera.ui.modepanel.k_renamed) this.o_renamed.getTag(com.oplus.camera.R_renamed.id_renamed.tag_recycle_view_mode_info);
            this.A_renamed.a_renamed().d_renamed(new com.oplus.camera.screen.b_renamed.o_renamed.a_renamed() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$f_renamed$nn3_UedtgcXhr12iuvuOG8tLijA
                @Override // com.oplus.camera.screen.b_renamed.o_renamed.a_renamed
                public final void call(java.lang.Object[] objArr) throws android.database.SQLException {
                    this.f_renamed$0.d_renamed(rect, kVar, objArr);
                }
            }, new com.oplus.camera.screen.b_renamed.o_renamed.a_renamed() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$f_renamed$dniMN-FK4i6uMMThUVP9jwrTQTc
                @Override // com.oplus.camera.screen.b_renamed.o_renamed.a_renamed
                public final void call(java.lang.Object[] objArr) throws android.database.SQLException {
                    this.f_renamed$0.c_renamed(rect, kVar, objArr);
                }
            });
            this.y_renamed = 0L;
        }
        this.n_renamed = false;
        this.p_renamed = 0;
        this.w_renamed = -1;
        this.i_renamed = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d_renamed(android.graphics.Rect rect, com.oplus.camera.ui.modepanel.k_renamed kVar, java.lang.Object[] objArr) throws android.database.SQLException {
        a_renamed(rect, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c_renamed(android.graphics.Rect rect, com.oplus.camera.ui.modepanel.k_renamed kVar, java.lang.Object[] objArr) throws android.database.SQLException {
        b_renamed(rect, kVar);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:27:0x0179  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a_renamed(android.graphics.Rect r16, final com.oplus.camera.ui.modepanel.k_renamed r17) throws android.database.SQLException {
        /*
            Method dump skipped, instructions count: 554
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.modepanel.f_renamed.a_renamed(android.graphics.Rect, com.oplus.camera.ui.modepanel.k_renamed):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b_renamed(boolean z_renamed, androidx.recyclerview.widget.RecyclerView recyclerView, com.oplus.camera.ui.modepanel.k_renamed kVar, int i_renamed) {
        com.oplus.camera.e_renamed.f_renamed("ItemDragHelper", "adsorpt, finalAdsorpt: " + z_renamed);
        final com.oplus.camera.ui.modepanel.a_renamed aVar = (com.oplus.camera.ui.modepanel.a_renamed) recyclerView.getAdapter();
        if (!z_renamed) {
            com.oplus.camera.ui.modepanel.k_renamed kVarB = aVar.b_renamed(this.h_renamed);
            kVarB.b_renamed(0);
            kVarB.c_renamed(this.f6724a.getColor(com.oplus.camera.R_renamed.color.color_white_with_full_percent_transparency));
            aVar.notifyItemChanged(this.h_renamed);
        } else {
            kVar.b_renamed(0);
            kVar.c_renamed(this.f6724a.getColor(com.oplus.camera.R_renamed.color.color_white_with_full_percent_transparency));
            kVar.e_renamed(true);
            aVar.notifyItemChanged(i_renamed);
        }
        if (recyclerView == this.e_renamed) {
            this.f6725b.b_renamed();
        } else {
            this.f_renamed.post(new java.lang.Runnable() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$f_renamed$NymiioZp384awSCQNl6vsgJeMiw
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.b_renamed(aVar);
                }
            });
        }
        c_renamed(this.e_renamed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b_renamed(com.oplus.camera.ui.modepanel.a_renamed aVar) {
        this.f6725b.b_renamed();
        aVar.notifyDataSetChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:29:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:38:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:42:0x01a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b_renamed(android.graphics.Rect r14, final com.oplus.camera.ui.modepanel.k_renamed r15) throws android.database.SQLException {
        /*
            Method dump skipped, instructions count: 445
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.modepanel.f_renamed.b_renamed(android.graphics.Rect, com.oplus.camera.ui.modepanel.k_renamed):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(boolean z_renamed, androidx.recyclerview.widget.RecyclerView recyclerView, com.oplus.camera.ui.modepanel.k_renamed kVar, int i_renamed) {
        com.oplus.camera.e_renamed.f_renamed("ItemDragHelper", "adsorpt, finalAdsorpt: " + z_renamed);
        final com.oplus.camera.ui.modepanel.a_renamed aVar = (com.oplus.camera.ui.modepanel.a_renamed) recyclerView.getAdapter();
        if (!z_renamed) {
            com.oplus.camera.ui.modepanel.k_renamed kVarB = aVar.b_renamed(this.h_renamed);
            kVarB.b_renamed(0);
            kVarB.c_renamed(this.f6724a.getColor(com.oplus.camera.R_renamed.color.color_white_with_full_percent_transparency));
            aVar.notifyItemChanged(this.h_renamed);
        } else {
            kVar.b_renamed(0);
            kVar.c_renamed(this.f6724a.getColor(com.oplus.camera.R_renamed.color.color_white_with_full_percent_transparency));
            kVar.e_renamed(true);
            aVar.notifyItemChanged(i_renamed);
        }
        if (recyclerView == this.e_renamed) {
            this.f6725b.b_renamed();
        } else {
            this.f_renamed.post(new java.lang.Runnable() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$f_renamed$mYHulACzkUqhq_pXcWGrp9EiGK0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.a_renamed(aVar);
                }
            });
        }
        c_renamed(this.e_renamed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(com.oplus.camera.ui.modepanel.a_renamed aVar) {
        this.f6725b.b_renamed();
        aVar.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B_renamed:52:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:54:0x01c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a_renamed(float r23, float r24) throws android.database.SQLException {
        /*
            Method dump skipped, instructions count: 548
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.modepanel.f_renamed.a_renamed(float, float):boolean");
    }

    private int a_renamed(androidx.recyclerview.widget.RecyclerView recyclerView, float f_renamed, int i_renamed) {
        if (recyclerView != this.f_renamed) {
            return i_renamed;
        }
        android.view.View viewD = d_renamed();
        android.view.View viewE = e_renamed();
        if (viewD == null || viewE == null) {
            if (viewD != null || viewE == null) {
                return i_renamed;
            }
            com.oplus.camera.ui.modepanel.a_renamed aVar = (com.oplus.camera.ui.modepanel.a_renamed) recyclerView.getAdapter();
            return aVar != null && aVar.b_renamed(i_renamed) != null && 20 == aVar.b_renamed(i_renamed).b_renamed() ? i_renamed - 1 : i_renamed;
        }
        android.graphics.Rect rectC = com.oplus.camera.ui.modepanel.c_renamed.c_renamed(viewD, this.t_renamed, this.u_renamed);
        android.graphics.Rect rectC2 = com.oplus.camera.ui.modepanel.c_renamed.c_renamed(viewE, this.t_renamed, this.u_renamed);
        int i2 = (rectC.left + rectC2.right) / 2;
        if (f_renamed >= i2 && f_renamed <= rectC2.right) {
            i_renamed++;
        }
        com.oplus.camera.e_renamed.f_renamed("ItemDragHelper", "regulateHeadlineIndex, middle: " + i2 + ", touchRawX: " + f_renamed + ", videoRect: " + rectC + ", photoRect: " + rectC2 + ", itemPos: " + i_renamed);
        return i_renamed;
    }

    private int b_renamed(androidx.recyclerview.widget.RecyclerView recyclerView, float f_renamed, int i_renamed) {
        if (recyclerView != this.f_renamed) {
            return i_renamed;
        }
        android.view.View viewD = d_renamed();
        android.view.View viewE = e_renamed();
        if (viewD == null || viewE == null) {
            if (viewD != null || viewE == null) {
                return i_renamed;
            }
            com.oplus.camera.ui.modepanel.a_renamed aVar = (com.oplus.camera.ui.modepanel.a_renamed) recyclerView.getAdapter();
            return aVar != null && aVar.b_renamed(i_renamed) != null && 20 == aVar.b_renamed(i_renamed).b_renamed() ? i_renamed - 1 : i_renamed;
        }
        android.graphics.Rect rectC = com.oplus.camera.ui.modepanel.c_renamed.c_renamed(viewD, this.t_renamed, this.u_renamed);
        android.graphics.Rect rectC2 = com.oplus.camera.ui.modepanel.c_renamed.c_renamed(viewE, this.t_renamed, this.u_renamed);
        int i2 = (rectC.top + rectC2.bottom) / 2;
        if (f_renamed >= i2 && f_renamed <= rectC2.bottom) {
            i_renamed++;
        }
        com.oplus.camera.e_renamed.f_renamed("ItemDragHelper", "regulateVerticalHeadlineIndex, middle: " + i2 + ", touchRawY: " + f_renamed + ", videoRect: " + rectC + ", photoRect: " + rectC2 + ", itemPos: " + i_renamed);
        return i_renamed;
    }

    private int c_renamed(androidx.recyclerview.widget.RecyclerView recyclerView, float f_renamed, int i_renamed) {
        if (this.u_renamed != 90) {
            f_renamed = com.oplus.camera.screen.f_renamed.f5372b - f_renamed;
        }
        return b_renamed(recyclerView, f_renamed, i_renamed);
    }

    private android.view.View d_renamed() {
        int childCount = this.f_renamed.getLayoutManager().getChildCount();
        for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
            android.view.View childAt = this.f_renamed.getLayoutManager().getChildAt(i_renamed);
            if (((com.oplus.camera.ui.modepanel.k_renamed) childAt.getTag(com.oplus.camera.R_renamed.id_renamed.tag_recycle_view_mode_info)).b_renamed() == 21) {
                return childAt;
            }
        }
        return null;
    }

    private android.view.View e_renamed() {
        int childCount = this.f_renamed.getLayoutManager().getChildCount();
        for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
            android.view.View childAt = this.f_renamed.getLayoutManager().getChildAt(i_renamed);
            if (((com.oplus.camera.ui.modepanel.k_renamed) childAt.getTag(com.oplus.camera.R_renamed.id_renamed.tag_recycle_view_mode_info)).b_renamed() == 20) {
                return childAt;
            }
        }
        return null;
    }

    private android.view.View a_renamed(androidx.recyclerview.widget.RecyclerView recyclerView, float f_renamed, float f2) {
        android.view.View viewFindChildViewUnder = recyclerView.findChildViewUnder(f_renamed, f2);
        if (viewFindChildViewUnder != null) {
            return viewFindChildViewUnder;
        }
        int childCount = recyclerView.getLayoutManager().getChildCount();
        for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
            android.view.View childAt = recyclerView.getLayoutManager().getChildAt(i_renamed);
            float translationX = childAt.getTranslationX();
            float translationY = childAt.getTranslationY();
            if (f2 >= childAt.getTop() + translationY && f2 <= childAt.getBottom() + translationY && f_renamed < childAt.getLeft() + translationX) {
                if (childAt.getVisibility() == 0) {
                    return childAt;
                }
                return null;
            }
        }
        return null;
    }

    private android.view.View b_renamed(androidx.recyclerview.widget.RecyclerView recyclerView, float f_renamed, float f2) {
        android.view.View viewFindChildViewUnder = recyclerView.findChildViewUnder(f_renamed, f2);
        if (viewFindChildViewUnder != null) {
            return viewFindChildViewUnder;
        }
        int childCount = recyclerView.getLayoutManager().getChildCount() - 1;
        for (int i_renamed = childCount; i_renamed >= 0; i_renamed--) {
            android.view.View childAt = recyclerView.getLayoutManager().getChildAt(i_renamed);
            float translationX = childAt.getTranslationX();
            if (i_renamed == 0 && f_renamed <= childAt.getLeft() + translationX) {
                return childAt;
            }
            if (f_renamed >= childAt.getLeft() + translationX && f_renamed <= childAt.getRight() + translationX) {
                return childAt;
            }
        }
        android.view.View childAt2 = recyclerView.getLayoutManager().getChildAt(childCount);
        if (childAt2 == null) {
            return null;
        }
        if (f_renamed > childAt2.getRight() + childAt2.getTranslationX()) {
            return childAt2;
        }
        return null;
    }

    private android.view.View c_renamed(androidx.recyclerview.widget.RecyclerView recyclerView, float f_renamed, float f2) {
        android.view.View viewFindChildViewUnder = recyclerView.findChildViewUnder(f_renamed, f2);
        if (viewFindChildViewUnder != null) {
            return viewFindChildViewUnder;
        }
        int childCount = recyclerView.getLayoutManager().getChildCount() - 1;
        for (int i_renamed = childCount; i_renamed >= 0; i_renamed--) {
            android.view.View childAt = recyclerView.getLayoutManager().getChildAt(i_renamed);
            float translationY = childAt.getTranslationY();
            if (i_renamed == 0 && f2 <= childAt.getTop() + translationY) {
                return childAt;
            }
            if (f2 >= childAt.getTop() + translationY && f2 <= childAt.getBottom() + translationY) {
                return childAt;
            }
        }
        android.view.View childAt2 = recyclerView.getLayoutManager().getChildAt(childCount);
        if (f2 > childAt2.getBottom() + childAt2.getTranslationY()) {
            return childAt2;
        }
        return null;
    }

    private void a_renamed(androidx.recyclerview.widget.RecyclerView recyclerView, android.view.View view, int i_renamed) {
        recyclerView.getLayoutManager();
        if (this.h_renamed == 0 || i_renamed == 0) {
            recyclerView.scrollToPosition(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float[] d_renamed(androidx.recyclerview.widget.RecyclerView recyclerView, float f_renamed, float f2) {
        return this.A_renamed.a_renamed().a_renamed(recyclerView, f_renamed, f2);
    }

    private int a_renamed(androidx.recyclerview.widget.RecyclerView recyclerView, android.view.View view, int i_renamed, float f_renamed, float f2) {
        com.oplus.camera.ui.modepanel.a_renamed aVar = (com.oplus.camera.ui.modepanel.a_renamed) recyclerView.getAdapter();
        if (aVar == null || (i_renamed == -1 && aVar.getItemCount() == 0)) {
            return 0;
        }
        if (view == null) {
            return i_renamed;
        }
        if (recyclerView == this.e_renamed) {
            if (1 == this.t_renamed) {
                if (view.getRight() >= f_renamed) {
                    return i_renamed;
                }
            } else if (view.getTop() + (view.getHeight() * this.k_renamed) >= f2) {
                return i_renamed;
            }
        } else if (1 == this.t_renamed) {
            if (view.getBottom() >= f2) {
                return i_renamed;
            }
        } else if (view.getRight() >= f_renamed) {
            return i_renamed;
        }
        return i_renamed + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a_renamed(androidx.recyclerview.widget.RecyclerView recyclerView, int i_renamed, int i2) {
        androidx.recyclerview.widget.RecyclerView recyclerView2;
        if (!this.f6725b.c_renamed()) {
            return false;
        }
        androidx.recyclerview.widget.RecyclerView.i_renamed layoutManager = recyclerView.getLayoutManager();
        int childCount = layoutManager.getChildCount();
        android.view.View childAt = null;
        for (int i3 = 0; i3 < childCount; i3++) {
            childAt = recyclerView.getLayoutManager().getChildAt(i3);
            if (childAt != null) {
                break;
            }
        }
        if (childAt == null) {
            return false;
        }
        android.graphics.Rect rectC = com.oplus.camera.ui.modepanel.c_renamed.c_renamed(childAt, this.t_renamed, this.u_renamed);
        if (this.r_renamed < rectC.top || this.r_renamed > rectC.bottom) {
            com.oplus.camera.e_renamed.f_renamed("ItemDragHelper", "scrollIfNecessary, mLastTouchRawY: " + this.r_renamed + ", rect: " + rectC);
            return false;
        }
        int iB = layoutManager.canScrollHorizontally() ? com.oplus.camera.ui.modepanel.c_renamed.b_renamed(recyclerView, i_renamed, i2) : 0;
        int iA = layoutManager.canScrollVertically() ? com.oplus.camera.ui.modepanel.c_renamed.a_renamed(recyclerView, i_renamed, i2) : 0;
        if (iB != 0 && recyclerView == (recyclerView2 = this.f_renamed) && recyclerView2.getLayoutManager() != null) {
            com.oplus.camera.ui.modepanel.a_renamed aVar = (com.oplus.camera.ui.modepanel.a_renamed) recyclerView.getAdapter();
            if (aVar == null) {
                return false;
            }
            int itemCount = aVar.getItemCount();
            if (iB > 0 && aVar.b_renamed(itemCount - 1).b_renamed() == this.f6725b.a_renamed()) {
                android.view.View childAt2 = recyclerView.getChildAt(childCount - 1);
                android.graphics.Rect rectC2 = com.oplus.camera.ui.modepanel.c_renamed.c_renamed(childAt2, this.t_renamed, this.u_renamed);
                int position = recyclerView.getLayoutManager().getPosition(childAt2);
                if (rectC2.right < (com.oplus.camera.util.Util.getScreenWidth() / 4.0f) * 3.0f && position == itemCount - 2) {
                    return false;
                }
            }
            if (iB < 0 && aVar.b_renamed(0).b_renamed() == this.f6725b.a_renamed()) {
                android.view.View childAt3 = recyclerView.getChildAt(0);
                android.graphics.Rect rectC3 = com.oplus.camera.ui.modepanel.c_renamed.c_renamed(childAt3, this.t_renamed, this.u_renamed);
                int position2 = recyclerView.getLayoutManager().getPosition(childAt3);
                if (rectC3.left > (com.oplus.camera.util.Util.getScreenWidth() / 4.0f) * 1.0f && position2 == 0) {
                    return false;
                }
            }
        }
        if (iB != 0 || iA != 0) {
            recyclerView.scrollBy(iB, iA);
        }
        return (iB == 0 && iA == 0) ? false : true;
    }

    private int a_renamed(androidx.recyclerview.widget.RecyclerView recyclerView, android.view.View view, float f_renamed, float f2, int i_renamed, int i2) {
        int iA = a_renamed(view);
        boolean z_renamed = 1 == this.t_renamed;
        if (iA == -1) {
            if (recyclerView == this.f_renamed && view == null) {
                android.view.View childAt = this.f_renamed.getLayoutManager().getChildAt(recyclerView.getLayoutManager().getChildCount() - 1);
                if (childAt == null) {
                    return -1;
                }
                if (!z_renamed && f_renamed >= childAt.getRight() + childAt.getTranslationX() && f2 >= childAt.getTop() + childAt.getTranslationY() && f2 <= childAt.getBottom() + childAt.getTranslationY()) {
                    return this.f_renamed.getAdapter().getItemCount();
                }
                if (z_renamed && f_renamed >= childAt.getLeft() + childAt.getTranslationX() && f_renamed <= childAt.getRight() + childAt.getTranslationX() && f2 >= childAt.getBottom() + childAt.getTranslationY()) {
                    return this.f_renamed.getAdapter().getItemCount();
                }
            }
            return -1;
        }
        if (iA == this.h_renamed && i_renamed == i2) {
            return -1;
        }
        return iA;
    }

    private boolean a_renamed(androidx.recyclerview.widget.RecyclerView recyclerView, android.view.View view, int i_renamed, int i2, float f_renamed, float f2) {
        if (!this.f6725b.c_renamed()) {
            return false;
        }
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        if (jCurrentTimeMillis - this.v_renamed < android.view.ViewConfiguration.getLongPressTimeout()) {
            com.oplus.camera.e_renamed.f_renamed("ItemDragHelper", "isItemNeedChange, time interval does not meet the requirements, no transposition is_renamed allowed, interval: " + (jCurrentTimeMillis - this.v_renamed));
            return false;
        }
        if (recyclerView == this.e_renamed) {
            return a_renamed(recyclerView, view, i_renamed, i2);
        }
        if (1 == this.t_renamed) {
            return b_renamed(recyclerView, view, i_renamed, i2, f2);
        }
        return a_renamed(recyclerView, view, i_renamed, i2, f_renamed);
    }

    private boolean a_renamed(androidx.recyclerview.widget.RecyclerView recyclerView, android.view.View view, int i_renamed, int i2) {
        if (view != null && i_renamed != -1 && i2 != -1 && i_renamed != i2) {
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            if (recyclerView == this.f_renamed && jCurrentTimeMillis - this.y_renamed < android.view.ViewConfiguration.getLongPressTimeout() * 2) {
                return false;
            }
            this.y_renamed = jCurrentTimeMillis;
            android.graphics.Rect rectG = this.f6725b.g_renamed();
            android.graphics.Rect rectC = com.oplus.camera.ui.modepanel.c_renamed.c_renamed(view, this.t_renamed, this.u_renamed);
            if (rectG != null && rectC != null) {
                if (4 == this.t_renamed) {
                    if (rectC.height() > java.lang.Math.abs(rectG.centerX() - rectC.centerX()) || rectC.height() > java.lang.Math.abs(rectG.centerY() - rectC.centerY())) {
                        return true;
                    }
                } else if (rectC.width() > java.lang.Math.abs(rectG.centerX() - rectC.centerX()) || rectC.width() > java.lang.Math.abs(rectG.centerY() - rectC.centerY())) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    private boolean a_renamed(androidx.recyclerview.widget.RecyclerView recyclerView, android.view.View view, int i_renamed, int i2, float f_renamed) {
        if (view == null || i_renamed == -1 || i2 == -1 || i_renamed == i2 || recyclerView.getScrollState() != 0) {
            return false;
        }
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        if (this.f6725b.g_renamed() == null) {
            return false;
        }
        if (4 != this.t_renamed) {
            float fH_renamed = (((r6.top + this.f6725b.h_renamed()) + r6.bottom) + this.f6725b.h_renamed()) / 2.0f;
            if (fH_renamed <= this.l_renamed || fH_renamed > r6 + com.oplus.camera.k_renamed.n_renamed()) {
                return false;
            }
        }
        this.y_renamed = jCurrentTimeMillis;
        if (i_renamed > i2) {
            if (f_renamed < view.getRight() - (view.getWidth() * this.j_renamed)) {
                return true;
            }
        } else if (f_renamed > view.getLeft() + (view.getWidth() * this.j_renamed)) {
            return true;
        }
        return false;
    }

    private boolean b_renamed(androidx.recyclerview.widget.RecyclerView recyclerView, android.view.View view, int i_renamed, int i2, float f_renamed) {
        if (view == null || i_renamed == -1 || i2 == -1 || i_renamed == i2 || recyclerView.getScrollState() != 0) {
            return false;
        }
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        if (this.f6725b.g_renamed() == null) {
            return false;
        }
        this.y_renamed = jCurrentTimeMillis;
        if (i_renamed > i2) {
            if (f_renamed < view.getBottom() - (view.getHeight() * this.j_renamed)) {
                return true;
            }
        } else if (f_renamed > view.getTop() + (view.getHeight() * this.j_renamed)) {
            return true;
        }
        return false;
    }

    private int a_renamed(android.view.View view) {
        if (view == null) {
            com.oplus.camera.e_renamed.f_renamed("ItemDragHelper", "getPositionByChildView, but itemView is_renamed null.");
            return -1;
        }
        try {
            return ((androidx.recyclerview.widget.RecyclerView.j_renamed) view.getLayoutParams()).g_renamed();
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.d_renamed("ItemDragHelper", "getPositionByChildView error.", e_renamed);
            return -1;
        }
    }

    public boolean a_renamed() {
        return this.f6725b.c_renamed();
    }

    public boolean b_renamed() {
        return this.f6725b.d_renamed();
    }

    private boolean a_renamed(android.view.View view, com.oplus.camera.ui.modepanel.k_renamed kVar) {
        boolean zB = com.oplus.camera.ui.modepanel.c_renamed.b_renamed(kVar);
        if (zB) {
            kVar.b_renamed(4);
            view.setVisibility(4);
        }
        return zB;
    }

    private boolean a_renamed(androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView recyclerView2, int i_renamed, int i2, com.oplus.camera.ui.modepanel.k_renamed kVar) throws android.database.SQLException {
        int i3 = 0;
        if (!com.oplus.camera.ui.modepanel.c_renamed.a_renamed(kVar)) {
            com.oplus.camera.e_renamed.f_renamed("ItemDragHelper", "changeRecycler, " + kVar.a_renamed() + " don't_renamed support change host.");
            return false;
        }
        if (i_renamed < 0) {
            com.oplus.camera.e_renamed.f_renamed("ItemDragHelper", "changeRecycler, fItemFromPos: " + i_renamed + " is_renamed invalid.");
            return false;
        }
        com.oplus.camera.ui.modepanel.a_renamed aVar = (com.oplus.camera.ui.modepanel.a_renamed) recyclerView2.getAdapter();
        aVar.a_renamed(i2, kVar);
        java.util.List<com.oplus.camera.ui.modepanel.k_renamed> listC = aVar.c_renamed();
        ((com.oplus.camera.ui.modepanel.a_renamed) recyclerView.getAdapter()).a_renamed(i_renamed);
        recyclerView.invalidateItemDecorations();
        com.oplus.camera.ui.modepanel.b_renamed.a_renamed().a_renamed(kVar.b_renamed(), recyclerView2 == this.f_renamed ? "position_headline" : "position_mode_panel");
        java.util.Iterator<com.oplus.camera.ui.modepanel.k_renamed> it = listC.iterator();
        while (it.hasNext()) {
            com.oplus.camera.ui.modepanel.b_renamed.a_renamed().a_renamed(it.next().b_renamed(), i3, true);
            i3++;
        }
        com.oplus.camera.e_renamed.f_renamed("ItemDragHelper", "changeRecycler, id_renamed: " + kVar.b_renamed() + ", fItemFromPos: " + i_renamed + ", fItemToPos: " + i2);
        return true;
    }

    private void c_renamed(final androidx.recyclerview.widget.RecyclerView recyclerView) {
        int iL;
        int itemCount = recyclerView.getAdapter().getItemCount();
        if (itemCount <= com.oplus.camera.ui.modepanel.p_renamed.f6753a * 1) {
            iL = com.oplus.camera.k_renamed.h_renamed();
        } else if (itemCount > com.oplus.camera.ui.modepanel.p_renamed.f6753a * 1 && itemCount <= com.oplus.camera.ui.modepanel.p_renamed.f6753a * 2) {
            iL = com.oplus.camera.k_renamed.i_renamed();
        } else if (itemCount > com.oplus.camera.ui.modepanel.p_renamed.f6753a * 2 && itemCount <= com.oplus.camera.ui.modepanel.p_renamed.f6753a * 3) {
            iL = com.oplus.camera.k_renamed.j_renamed();
        } else if (itemCount > com.oplus.camera.ui.modepanel.p_renamed.f6753a * 3 && itemCount <= com.oplus.camera.ui.modepanel.p_renamed.f6753a * 4) {
            iL = com.oplus.camera.k_renamed.k_renamed();
        } else if (itemCount <= com.oplus.camera.ui.modepanel.p_renamed.f6753a * 4 || itemCount <= com.oplus.camera.ui.modepanel.p_renamed.f6753a * 5) {
            iL = com.oplus.camera.k_renamed.l_renamed();
        } else {
            iL = com.oplus.camera.k_renamed.l_renamed();
        }
        final androidx.constraintlayout.widget.ConstraintLayout.a_renamed aVar = (androidx.constraintlayout.widget.ConstraintLayout.a_renamed) recyclerView.getLayoutParams();
        if (aVar.topMargin == iL) {
            return;
        }
        android.animation.ValueAnimator valueAnimatorOfInt = android.animation.ValueAnimator.ofInt(aVar.topMargin, iL);
        valueAnimatorOfInt.setInterpolator(androidx.core.h_renamed.b_renamed.b_renamed.a_renamed(0.3f, 0.0f, 0.1f, 1.0f));
        valueAnimatorOfInt.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$f_renamed$diUbNxd1Axia-04if1v_mBDIMk4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                com.oplus.camera.ui.modepanel.f_renamed.a_renamed(aVar, recyclerView, valueAnimator);
            }
        });
        valueAnimatorOfInt.setDuration(200L);
        valueAnimatorOfInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a_renamed(androidx.constraintlayout.widget.ConstraintLayout.a_renamed aVar, androidx.recyclerview.widget.RecyclerView recyclerView, android.animation.ValueAnimator valueAnimator) {
        aVar.topMargin = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
        recyclerView.setLayoutParams(aVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B_renamed:7:0x001e, code lost:
    
        r7 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean b_renamed(androidx.recyclerview.widget.RecyclerView r8, int r9, int r10) throws android.database.SQLException {
        /*
            r7 = this;
            androidx.recyclerview.widget.RecyclerView$a_renamed r0 = r8.getAdapter()
            com.oplus.camera.ui.modepanel.a_renamed r0 = (com.oplus.camera.ui.modepanel.a_renamed) r0
            androidx.recyclerview.widget.RecyclerView r7 = r7.f_renamed
            java.lang.String r1 = ", toPos: "
            java.lang.String r2 = "ItemDragHelper"
            r3 = 0
            r4 = 1
            if (r8 != r7) goto L4c
            if (r9 >= r10) goto L22
            com.oplus.camera.ui.modepanel.k_renamed r7 = r0.b_renamed(r10)
            int r7 = r7.b_renamed()
            r5 = 21
            if (r7 != r5) goto L20
        L1e:
            r7 = r4
            goto L2f
        L20:
            r7 = r3
            goto L2f
        L22:
            com.oplus.camera.ui.modepanel.k_renamed r7 = r0.b_renamed(r10)
            int r7 = r7.b_renamed()
            r5 = 20
            if (r7 != r5) goto L20
            goto L1e
        L2f:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "changeItem, no mode are allowed to be_renamed inserted between the video and capture mode, fromPos: "
            r5.append(r6)
            r5.append(r9)
            r5.append(r1)
            r5.append(r10)
            java.lang.String r5 = r5.toString()
            com.oplus.camera.e_renamed.a_renamed(r2, r5)
            if (r7 == 0) goto L4c
            return r3
        L4c:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r5 = "changeItem, fromPos: "
            r7.append(r5)
            r7.append(r9)
            r7.append(r1)
            r7.append(r10)
            java.lang.String r7 = r7.toString()
            com.oplus.camera.e_renamed.f_renamed(r2, r7)
            r0.a_renamed(r9, r10)
            r8.invalidateItemDecorations()
            java.util.List r7 = r0.c_renamed()
            java.util.Iterator r7 = r7.iterator()
        L74:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L8d
            java.lang.Object r8 = r7.next()
            com.oplus.camera.ui.modepanel.k_renamed r8 = (com.oplus.camera.ui.modepanel.k_renamed) r8
            com.oplus.camera.ui.modepanel.b_renamed r9 = com.oplus.camera.ui.modepanel.b_renamed.a_renamed()
            int r8 = r8.b_renamed()
            r9.a_renamed(r8, r3, r4)
            int r3 = r3 + r4
            goto L74
        L8d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.modepanel.f_renamed.b_renamed(androidx.recyclerview.widget.RecyclerView, int, int):boolean");
    }

    private void c_renamed(final android.graphics.Rect rect, final com.oplus.camera.ui.modepanel.k_renamed kVar) {
        if (rect == null || rect.width() < com.oplus.camera.k_renamed.g_renamed() || rect.height() < com.oplus.camera.k_renamed.g_renamed()) {
            com.oplus.camera.e_renamed.f_renamed("ItemDragHelper", "handleDragUI, floatRect: " + rect + " is_renamed invalid.");
            return;
        }
        this.A_renamed.a_renamed().c_renamed(new com.oplus.camera.screen.b_renamed.o_renamed.a_renamed() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$f_renamed$hmiAkvk-CI-Zs-hS4rbHeZj-v_Q
            @Override // com.oplus.camera.screen.b_renamed.o_renamed.a_renamed
            public final void call(java.lang.Object[] objArr) {
                this.f_renamed$0.b_renamed(rect, kVar, objArr);
            }
        }, new com.oplus.camera.screen.b_renamed.o_renamed.a_renamed() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$f_renamed$99Lpj3Rv3guSo9zVFsK-zG8Xc-0
            @Override // com.oplus.camera.screen.b_renamed.o_renamed.a_renamed
            public final void call(java.lang.Object[] objArr) throws android.content.res.Resources.NotFoundException {
                this.f_renamed$0.a_renamed(rect, kVar, objArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b_renamed(android.graphics.Rect rect, com.oplus.camera.ui.modepanel.k_renamed kVar, java.lang.Object[] objArr) {
        d_renamed(rect, kVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(android.graphics.Rect rect, com.oplus.camera.ui.modepanel.k_renamed kVar, java.lang.Object[] objArr) throws android.content.res.Resources.NotFoundException {
        e_renamed(rect, kVar);
    }

    private void d_renamed(android.graphics.Rect rect, com.oplus.camera.ui.modepanel.k_renamed kVar) {
        if (rect.centerY() >= this.l_renamed && com.oplus.camera.ui.modepanel.c_renamed.a_renamed(kVar)) {
            this.f6725b.e_renamed();
        } else if (rect.bottom <= this.l_renamed) {
            this.f6725b.f_renamed();
        }
        if (rect.centerY() < this.l_renamed || com.oplus.camera.ui.modepanel.c_renamed.a_renamed(kVar) || this.n_renamed) {
            return;
        }
        this.n_renamed = true;
        android.widget.Toast.makeText(this.f6724a, com.oplus.camera.R_renamed.string.camera_mode_arrange_not_support_drag, 0).show();
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.g_renamed;
        if (cameraUIListener != null) {
            cameraUIListener.b_renamed(com.oplus.camera.statistics.model.ReminderMsgData.TYPE_DISABLE_CODE, com.oplus.camera.statistics.model.ReminderMsgData.CODE_IMMOVABLE_MODE);
        }
    }

    private void e_renamed(android.graphics.Rect rect, com.oplus.camera.ui.modepanel.k_renamed kVar) throws android.content.res.Resources.NotFoundException {
        boolean zA = this.A_renamed.a_renamed().a_renamed(this.f6724a, rect);
        boolean zB = this.A_renamed.a_renamed().b_renamed(this.f6724a, rect);
        if (zB && com.oplus.camera.ui.modepanel.c_renamed.a_renamed(kVar)) {
            this.f6725b.e_renamed();
        } else if (zA) {
            this.f6725b.f_renamed();
        }
        if (!zB || com.oplus.camera.ui.modepanel.c_renamed.a_renamed(kVar) || this.n_renamed) {
            return;
        }
        this.n_renamed = true;
        android.widget.Toast toastMakeText = android.widget.Toast.makeText(this.f6724a, com.oplus.camera.R_renamed.string.camera_mode_arrange_not_support_drag, 0);
        int i_renamed = this.t_renamed;
        if ((1 == i_renamed || 4 == i_renamed) && this.g_renamed.bL_renamed() != null) {
            int iK = this.g_renamed.bL_renamed().k_renamed();
            if (iK == 90) {
                toastMakeText.setGravity(8388627, 0, -com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.camera_mode_arrange_not_support_drag_yOffset));
                android.view.View view = toastMakeText.getView();
                view.setRotation(90.0f);
                view.setElevation(300.0f);
            } else if (iK == 270) {
                toastMakeText.setGravity(8388629, 0, -com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.camera_mode_arrange_not_support_drag_yOffset));
                android.view.View view2 = toastMakeText.getView();
                view2.setRotation(270.0f);
                view2.setElevation(300.0f);
            }
        }
        toastMakeText.show();
        com.oplus.camera.ui.CameraUIListener cameraUIListener = this.g_renamed;
        if (cameraUIListener != null) {
            cameraUIListener.b_renamed(com.oplus.camera.statistics.model.ReminderMsgData.TYPE_DISABLE_CODE, com.oplus.camera.statistics.model.ReminderMsgData.CODE_IMMOVABLE_MODE);
        }
    }

    private android.graphics.Rect b_renamed(int i_renamed) {
        if (i_renamed < 0) {
            return null;
        }
        android.view.View childAt = this.f_renamed.getLayoutManager().getChildAt(i_renamed);
        if (childAt == null) {
            android.graphics.Rect rectC = com.oplus.camera.ui.modepanel.c_renamed.c_renamed(this.f_renamed.getLayoutManager().getChildAt(this.f_renamed.getLayoutManager().getChildCount() - 1), this.t_renamed, this.u_renamed);
            if (4 == this.t_renamed) {
                int iB = rectC.bottom + (com.oplus.camera.k_renamed.b_renamed() * 2);
                return new android.graphics.Rect(rectC.left, iB, rectC.right, this.o_renamed.getWidth() + iB);
            }
            int iB2 = rectC.right + (com.oplus.camera.k_renamed.b_renamed() * 2);
            return new android.graphics.Rect(iB2, rectC.top, this.o_renamed.getWidth() + iB2, rectC.bottom);
        }
        if (!this.f_renamed.isAnimating()) {
            return com.oplus.camera.ui.modepanel.c_renamed.c_renamed(childAt, this.t_renamed, this.u_renamed);
        }
        int iFindFirstVisibleItemPosition = ((androidx.recyclerview.widget.LinearLayoutManager) this.f_renamed.getLayoutManager()).findFirstVisibleItemPosition();
        if (this.i_renamed != -1) {
            android.view.View childAt2 = this.f_renamed.getLayoutManager().getChildAt(this.i_renamed - iFindFirstVisibleItemPosition);
            android.view.View childAt3 = this.f_renamed.getLayoutManager().getChildAt(this.h_renamed - iFindFirstVisibleItemPosition);
            android.graphics.Rect rectC2 = com.oplus.camera.ui.modepanel.c_renamed.c_renamed(childAt2, this.t_renamed, this.u_renamed);
            android.graphics.Rect rectC3 = com.oplus.camera.ui.modepanel.c_renamed.c_renamed(childAt3, this.t_renamed, this.u_renamed);
            if (this.i_renamed < this.h_renamed) {
                int right = childAt.getRight();
                android.graphics.Rect rect = new android.graphics.Rect(right - rectC2.width(), rectC3.top, right, rectC3.bottom);
                return com.oplus.camera.util.Util.t_renamed() ? a_renamed(true, childAt2, childAt3, rectC2, rectC3, childAt, rect) : rect;
            }
            int left = childAt.getLeft();
            android.graphics.Rect rect2 = new android.graphics.Rect(left, rectC3.top, rectC2.width() + left, rectC3.bottom);
            return com.oplus.camera.util.Util.t_renamed() ? a_renamed(false, childAt2, childAt3, rectC2, rectC3, childAt, rect2) : rect2;
        }
        return com.oplus.camera.ui.modepanel.c_renamed.c_renamed(childAt, this.t_renamed, this.u_renamed);
    }

    private android.graphics.Rect c_renamed(int i_renamed) {
        int width;
        int width2;
        int width3;
        int height;
        com.oplus.camera.e_renamed.a_renamed("ItemDragHelper", "getHeadlineTargetVertical, position: " + i_renamed);
        androidx.recyclerview.widget.RecyclerView.i_renamed layoutManager = this.f_renamed.getLayoutManager();
        android.view.View viewFindViewByPosition = layoutManager != null ? layoutManager.findViewByPosition(i_renamed) : null;
        int i2 = 0;
        if (viewFindViewByPosition != null) {
            int[] iArr = new int[2];
            viewFindViewByPosition.getLocationOnScreen(iArr);
            int i3 = this.t_renamed;
            if (1 == i3 || 4 == i3) {
                int i4 = this.u_renamed;
                if (90 == i4) {
                    int i5 = iArr[0];
                    int i6 = iArr[1];
                    int height2 = i5 - viewFindViewByPosition.getHeight();
                    width3 = viewFindViewByPosition.getWidth() + i6;
                    width = i5;
                    i2 = height2;
                    width2 = i6;
                } else if (270 == i4) {
                    i2 = iArr[0];
                    int i7 = iArr[1];
                    width2 = i7 - viewFindViewByPosition.getWidth();
                    width3 = i7;
                    width = viewFindViewByPosition.getHeight() + i2;
                } else {
                    width2 = iArr[1];
                    i2 = iArr[0];
                    width = viewFindViewByPosition.getWidth() + i2;
                    height = viewFindViewByPosition.getHeight();
                }
            } else {
                width2 = iArr[1];
                i2 = iArr[0];
                width = viewFindViewByPosition.getWidth() + i2;
                height = viewFindViewByPosition.getHeight();
            }
            width3 = height + width2;
        } else {
            width = 0;
            width2 = 0;
            width3 = 0;
        }
        if (viewFindViewByPosition == null) {
            return d_renamed(i_renamed);
        }
        return new android.graphics.Rect(i2, width2, width, width3);
    }

    private android.graphics.Rect d_renamed(int i_renamed) {
        int iFindFirstVisibleItemPosition;
        int iB;
        int height;
        int width;
        int i2;
        int width2;
        int width3;
        int iB2;
        int height2;
        int width4;
        com.oplus.camera.e_renamed.a_renamed("ItemDragHelper", "getHeadlineNextTarget, position: " + i_renamed);
        androidx.recyclerview.widget.RecyclerView.i_renamed layoutManager = this.f_renamed.getLayoutManager();
        int iCenterX = 0;
        if (layoutManager == null) {
            return new android.graphics.Rect(0, 0, 0, 0);
        }
        if (i_renamed == layoutManager.getChildCount()) {
            iFindFirstVisibleItemPosition = i_renamed - 1;
        } else {
            iFindFirstVisibleItemPosition = (i_renamed >= layoutManager.getChildCount() || i_renamed < 0) ? 0 : ((androidx.recyclerview.widget.LinearLayoutManager) this.f_renamed.getLayoutManager()).findFirstVisibleItemPosition() + 1;
        }
        if (4 == this.t_renamed) {
            iFindFirstVisibleItemPosition = ((androidx.recyclerview.widget.LinearLayoutManager) this.f_renamed.getLayoutManager()).findLastVisibleItemPosition();
        }
        android.graphics.Rect rectC = c_renamed(iFindFirstVisibleItemPosition);
        int i3 = this.t_renamed;
        if (1 == i3) {
            int i4 = this.u_renamed;
            if (90 == i4) {
                iCenterX = com.oplus.camera.k_renamed.b_renamed() + rectC.right;
                int height3 = this.o_renamed.getHeight() + iCenterX;
                width2 = rectC.centerY() - (this.o_renamed.getWidth() / 2);
                width3 = this.o_renamed.getWidth() + width2;
                i2 = height3;
            } else if (270 == i4) {
                iB2 = com.oplus.camera.k_renamed.b_renamed() + rectC.left;
                height2 = iB2 - this.o_renamed.getHeight();
                width2 = rectC.centerY() - (this.o_renamed.getWidth() / 2);
                width4 = this.o_renamed.getWidth();
                int i5 = height2;
                width3 = width4 + width2;
                i2 = iB2;
                iCenterX = i5;
            } else {
                iCenterX = rectC.centerX() - (this.o_renamed.getWidth() / 2);
                iB = rectC.top + com.oplus.camera.k_renamed.b_renamed();
                height = iB - this.o_renamed.getHeight();
                width = this.o_renamed.getWidth();
                i2 = width + iCenterX;
                int i6 = height;
                width3 = iB;
                width2 = i6;
            }
        } else if (4 == i3) {
            int i7 = this.u_renamed;
            if (90 == i7) {
                iB2 = rectC.right;
                height2 = rectC.left;
                width2 = rectC.bottom + com.oplus.camera.k_renamed.b_renamed();
                width4 = this.o_renamed.getWidth();
                int i52 = height2;
                width3 = width4 + width2;
                i2 = iB2;
                iCenterX = i52;
            } else if (270 == i7) {
                int i8 = rectC.right;
                int i9 = rectC.left;
                int iB3 = rectC.top - com.oplus.camera.k_renamed.b_renamed();
                width2 = iB3 - this.o_renamed.getWidth();
                i2 = i8;
                iCenterX = i9;
                width3 = iB3;
            } else {
                i2 = 0;
                width2 = 0;
                width3 = 0;
            }
        } else {
            iCenterX = rectC.centerX() - (this.o_renamed.getWidth() / 2);
            iB = rectC.top + com.oplus.camera.k_renamed.b_renamed();
            height = iB - this.o_renamed.getHeight();
            width = this.o_renamed.getWidth();
            i2 = width + iCenterX;
            int i62 = height;
            width3 = iB;
            width2 = i62;
        }
        return new android.graphics.Rect(iCenterX, width2, i2, width3);
    }

    private android.graphics.Rect a_renamed(androidx.recyclerview.widget.RecyclerView recyclerView, int i_renamed) {
        int iD;
        int iD2;
        int iD3;
        int iE;
        android.view.View viewFindViewByPosition = recyclerView.getLayoutManager().findViewByPosition(i_renamed);
        int i2 = 0;
        if (viewFindViewByPosition != null) {
            int[] iArr = new int[2];
            viewFindViewByPosition.getLocationOnScreen(iArr);
            int i3 = this.t_renamed;
            if (1 == i3 || 4 == i3) {
                int i4 = this.u_renamed;
                if (90 == i4) {
                    int i5 = iArr[0];
                    iD = iArr[1];
                    int iE2 = i5 - com.oplus.camera.k_renamed.e_renamed();
                    iD3 = com.oplus.camera.k_renamed.d_renamed() + iD;
                    iD2 = i5;
                    i2 = iE2;
                } else if (270 == i4) {
                    i2 = iArr[0];
                    int i6 = iArr[1];
                    iD3 = i6;
                    iD = i6 - com.oplus.camera.k_renamed.d_renamed();
                    iD2 = com.oplus.camera.k_renamed.e_renamed() + i2;
                } else {
                    iD = iArr[1];
                    i2 = iArr[0];
                    iD2 = com.oplus.camera.k_renamed.d_renamed() + i2;
                    iE = com.oplus.camera.k_renamed.e_renamed();
                }
            } else {
                iD = iArr[1];
                i2 = iArr[0];
                iD2 = com.oplus.camera.k_renamed.d_renamed() + i2;
                iE = com.oplus.camera.k_renamed.e_renamed();
            }
            iD3 = iE + iD;
        } else {
            iD = 0;
            iD2 = 0;
            iD3 = 0;
        }
        if (i_renamed == recyclerView.getChildCount()) {
            return b_renamed(recyclerView, i_renamed);
        }
        return new android.graphics.Rect(i2, iD, iD2, iD3);
    }

    private android.graphics.Rect b_renamed(androidx.recyclerview.widget.RecyclerView recyclerView, int i_renamed) {
        int iC;
        int iD;
        int iD2;
        int i2;
        int iD3;
        if (i_renamed % com.oplus.camera.ui.modepanel.p_renamed.f6753a == 0) {
            android.graphics.Rect rectA = a_renamed(recyclerView, i_renamed - com.oplus.camera.ui.modepanel.p_renamed.f6753a);
            int i3 = this.u_renamed;
            if (90 == i3) {
                iD2 = rectA.left;
                iC = iD2 - com.oplus.camera.k_renamed.e_renamed();
                iD = rectA.top;
                i2 = rectA.bottom;
            } else if (270 == i3) {
                iC = rectA.right;
                iD2 = com.oplus.camera.k_renamed.e_renamed() + iC;
                iD = rectA.top;
                i2 = rectA.bottom;
            } else {
                iC = rectA.left;
                iD2 = rectA.right;
                iD = rectA.bottom;
                iD3 = com.oplus.camera.k_renamed.e_renamed();
                i2 = iD3 + iD;
            }
        } else {
            android.graphics.Rect rectA2 = a_renamed(recyclerView, i_renamed - 1);
            int i4 = this.u_renamed;
            if (90 == i4) {
                iC = rectA2.left;
                iD = com.oplus.camera.k_renamed.c_renamed() + rectA2.bottom;
                iD2 = rectA2.right;
                iD3 = com.oplus.camera.k_renamed.d_renamed();
                i2 = iD3 + iD;
            } else if (270 == i4) {
                iC = rectA2.left;
                int iC2 = rectA2.top - com.oplus.camera.k_renamed.c_renamed();
                int i5 = rectA2.right;
                iD = iC2 - com.oplus.camera.k_renamed.d_renamed();
                i2 = iC2;
                iD2 = i5;
            } else {
                iC = com.oplus.camera.k_renamed.c_renamed() + rectA2.right;
                iD = rectA2.top;
                iD2 = com.oplus.camera.k_renamed.d_renamed() + iC;
                i2 = rectA2.bottom;
            }
        }
        return new android.graphics.Rect(iC, iD, iD2, i2);
    }

    private android.graphics.Rect a_renamed(boolean z_renamed, android.view.View view, android.view.View view2, android.graphics.Rect rect, android.graphics.Rect rect2, android.view.View view3, android.graphics.Rect rect3) {
        if (z_renamed) {
            int i_renamed = this.t_renamed;
            if (4 == i_renamed) {
                int i2 = rect2.bottom;
                return new android.graphics.Rect(rect2.left, i2 - view.getWidth(), rect2.right, i2);
            }
            if (1 == i_renamed) {
                int[] iArr = new int[2];
                this.f_renamed.getLocationOnScreen(iArr);
                if (5 == this.g_renamed.bL_renamed().m_renamed()) {
                    return new android.graphics.Rect(iArr[0] + view3.getTop(), iArr[1] - view3.getRight(), iArr[0] + view3.getBottom(), iArr[1] - view3.getLeft());
                }
                if (6 == this.g_renamed.bL_renamed().m_renamed()) {
                    return new android.graphics.Rect(iArr[0] - view3.getBottom(), iArr[1] + view3.getLeft(), iArr[0] - view3.getTop(), iArr[1] + view3.getRight());
                }
                return new android.graphics.Rect(iArr[0] + view3.getLeft(), iArr[1] + view3.getTop(), iArr[0] + view3.getRight(), iArr[1] + view3.getBottom());
            }
        } else {
            int i3 = this.t_renamed;
            if (4 == i3) {
                int i4 = rect2.top;
                return new android.graphics.Rect(rect2.left, i4, rect2.right, view.getWidth() + i4);
            }
            if (1 == i3) {
                int[] iArr2 = new int[2];
                this.f_renamed.getLocationOnScreen(iArr2);
                if (5 == this.g_renamed.bL_renamed().m_renamed()) {
                    return new android.graphics.Rect(iArr2[0] + view3.getTop(), iArr2[1] - view3.getRight(), iArr2[0] + view3.getBottom(), iArr2[1] - view3.getLeft());
                }
                if (6 == this.g_renamed.bL_renamed().m_renamed()) {
                    return new android.graphics.Rect(iArr2[0] - view3.getBottom(), iArr2[1] + view3.getLeft(), iArr2[0] - view3.getTop(), iArr2[1] + view3.getRight());
                }
                return new android.graphics.Rect(iArr2[0] + view3.getLeft(), iArr2[1] + view3.getTop(), iArr2[0] + view3.getRight(), iArr2[1] + view3.getBottom());
            }
        }
        return rect3;
    }
}
