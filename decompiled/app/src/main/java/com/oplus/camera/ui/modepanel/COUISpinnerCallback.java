package com.oplus.camera.ui.modepanel;

/* compiled from: MoreUIControl.java */
/* loaded from: classes2.dex */
public class p_renamed implements com.oplus.camera.ui.modepanel.o_renamed.a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static int f6753a = 3;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.app.Activity f6754b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.view.ViewGroup f6755c;
    private int d_renamed;
    private com.oplus.camera.ui.modepanel.l_renamed e_renamed;
    private android.widget.RelativeLayout.LayoutParams g_renamed;
    private com.oplus.camera.ui.modepanel.f_renamed k_renamed;
    private com.oplus.camera.screen.g_renamed s_renamed;
    private int v_renamed;
    private com.a_renamed.a_renamed.f_renamed y_renamed;
    private com.a_renamed.a_renamed.f_renamed z_renamed;
    private android.view.View f_renamed = null;
    private com.oplus.camera.ui.modepanel.NonFlingRecycleView h_renamed = null;
    private com.oplus.camera.ui.modepanel.o_renamed i_renamed = null;
    private com.oplus.camera.ui.modepanel.p_renamed.b_renamed j_renamed = null;
    private android.widget.TextView l_renamed = null;
    private android.widget.ImageView m_renamed = null;
    private com.oplus.camera.ui.widget.AnimationButton n_renamed = null;
    private com.oplus.camera.ui.modepanel.h_renamed o_renamed = null;
    private android.view.GestureDetector p_renamed = null;
    private android.view.GestureDetector q_renamed = null;
    private java.util.HashMap<java.lang.Integer, java.lang.Integer> r_renamed = new java.util.HashMap<>();
    private boolean t_renamed = false;
    private boolean u_renamed = false;
    private int w_renamed = 0;
    private int x_renamed = com.oplus.camera.R_renamed.layout.more_mode_layout;
    private int A_renamed = 0;

    /* compiled from: MoreUIControl.java */
    public interface b_renamed {
        void a_renamed();

        void a_renamed(int i_renamed);

        void b_renamed();

        void c_renamed();
    }

    public void k_renamed() {
    }

    public p_renamed(android.app.Activity activity, android.view.ViewGroup viewGroup, int i_renamed, com.oplus.camera.ui.modepanel.f_renamed fVar, com.oplus.camera.screen.g_renamed gVar) {
        this.k_renamed = null;
        this.s_renamed = null;
        this.f6754b = activity;
        this.f6755c = viewGroup;
        this.d_renamed = i_renamed;
        this.e_renamed = new com.oplus.camera.ui.modepanel.l_renamed(this.f6754b);
        this.s_renamed = gVar;
        this.v_renamed = this.f6754b.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.anim_position);
        this.k_renamed = fVar;
    }

    private void i_renamed(int i_renamed) {
        com.oplus.camera.screen.g_renamed gVar;
        if (this.f_renamed == null || this.g_renamed == null) {
            com.oplus.camera.e_renamed.a_renamed("MoreUIControl", "initMoreModeView");
            if (com.oplus.camera.util.Util.t_renamed() && (gVar = this.s_renamed) != null) {
                h_renamed(gVar.a_renamed().j_renamed());
            }
            this.f_renamed = this.f6754b.getLayoutInflater().inflate(this.x_renamed, (android.view.ViewGroup) null);
            this.f_renamed.setBackgroundColor(com.oplus.camera.util.c_renamed.a_renamed(this.f6754b.getColor(com.oplus.camera.R_renamed.color.more_mode_mask_color)));
            this.f_renamed.setVisibility(8);
            if (this.A_renamed == 4) {
                int i2 = com.oplus.camera.screen.f_renamed.f5371a - com.oplus.camera.screen.f_renamed.f5372b;
                this.g_renamed = new android.widget.RelativeLayout.LayoutParams(-1, -1);
                this.g_renamed.topMargin = (com.oplus.camera.screen.f_renamed.f5372b + i2) / 2;
            } else {
                this.g_renamed = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            }
            this.i_renamed = new com.oplus.camera.ui.modepanel.o_renamed(this.f6754b, this.d_renamed);
            this.i_renamed.a_renamed(this.e_renamed.b_renamed(), true);
            this.i_renamed.e_renamed(this.A_renamed);
            this.i_renamed.a_renamed(this);
            this.i_renamed.c_renamed(this.d_renamed);
            this.h_renamed = (com.oplus.camera.ui.modepanel.NonFlingRecycleView) this.f_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.more_mode_view);
            this.l_renamed = (android.widget.TextView) this.f_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.mode_edit_desc_text);
            this.m_renamed = (android.widget.ImageView) this.f_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.mode_edit_back_arrow);
            this.h_renamed.setLayoutManager(new com.oplus.camera.ui.modepanel.p_renamed.a_renamed(this.f6754b, f6753a));
            this.h_renamed.addItemDecoration(new com.oplus.camera.ui.modepanel.p_renamed.c_renamed());
            ((androidx.recyclerview.widget.r_renamed) this.h_renamed.getItemAnimator()).a_renamed(false);
            this.m_renamed.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$p_renamed$T4uo11FGQSQq6nCrhJdu68PFBOg
                @Override // android.view.View.OnClickListener
                public final void onClick(android.view.View view) {
                    this.f_renamed$0.b_renamed(view);
                }
            });
            this.h_renamed.addOnItemTouchListener(new androidx.recyclerview.widget.RecyclerView.m_renamed() { // from class: com.oplus.camera.ui.modepanel.p_renamed.1
                @Override // androidx.recyclerview.widget.RecyclerView.m_renamed
                public void a_renamed(boolean z_renamed) {
                }

                @Override // androidx.recyclerview.widget.RecyclerView.m_renamed
                public void b_renamed(androidx.recyclerview.widget.RecyclerView recyclerView, android.view.MotionEvent motionEvent) {
                }

                @Override // androidx.recyclerview.widget.RecyclerView.m_renamed
                public boolean a_renamed(androidx.recyclerview.widget.RecyclerView recyclerView, android.view.MotionEvent motionEvent) {
                    if (com.oplus.camera.ui.modepanel.p_renamed.this.p_renamed == null) {
                        com.oplus.camera.ui.modepanel.p_renamed pVar = com.oplus.camera.ui.modepanel.p_renamed.this;
                        pVar.p_renamed = new android.view.GestureDetector(pVar.f6754b, new com.oplus.camera.ui.modepanel.p_renamed.d_renamed());
                    }
                    if (motionEvent.getPointerId(0) != 0 && 3 != motionEvent.getActionMasked()) {
                        return false;
                    }
                    if (com.oplus.camera.ui.modepanel.p_renamed.this.r_renamed()) {
                        return true;
                    }
                    boolean zA = com.oplus.camera.ui.modepanel.p_renamed.this.k_renamed.a_renamed();
                    com.oplus.camera.ui.modepanel.p_renamed.this.k_renamed.a_renamed(motionEvent);
                    if (zA && 1 == motionEvent.getActionMasked()) {
                        return true;
                    }
                    return com.oplus.camera.ui.modepanel.p_renamed.this.p_renamed.onTouchEvent(motionEvent);
                }
            });
            this.s_renamed.a_renamed().b_renamed(new com.oplus.camera.screen.b_renamed.o_renamed.a_renamed() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$p_renamed$PhOMKfmjAS0HCGgrDP9EifNH4F4
                @Override // com.oplus.camera.screen.b_renamed.o_renamed.a_renamed
                public final void call(java.lang.Object[] objArr) {
                    this.f_renamed$0.a_renamed(objArr);
                }
            });
            j_renamed(this.i_renamed.getItemCount());
            this.h_renamed.setAdapter(this.i_renamed);
            this.h_renamed.getItemAnimator().a_renamed(0L);
            this.f_renamed.setOnTouchListener(new android.view.View.OnTouchListener() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$p_renamed$fkmXciEyVxm7m0fTIIJJgiepHr8
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                    return this.f_renamed$0.a_renamed(view, motionEvent);
                }
            });
            q_renamed();
            this.f6755c.addView(this.f_renamed, 0, this.g_renamed);
            this.k_renamed.a_renamed((androidx.recyclerview.widget.RecyclerView) this.h_renamed);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b_renamed(android.view.View view) {
        if (this.k_renamed.a_renamed()) {
            return;
        }
        this.m_renamed.setClickable(false);
        this.o_renamed.a_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(java.lang.Object[] objArr) {
        l_renamed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a_renamed(android.view.View view, android.view.MotionEvent motionEvent) {
        if (this.q_renamed == null) {
            this.q_renamed = new android.view.GestureDetector(this.f6754b, new com.oplus.camera.ui.modepanel.p_renamed.e_renamed());
        }
        this.q_renamed.onTouchEvent(motionEvent);
        return true;
    }

    private void l_renamed() {
        this.n_renamed = (com.oplus.camera.ui.widget.AnimationButton) this.f_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.arrange_edit_button);
        this.n_renamed.setTextSize(0, this.f6754b.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.mode_vertical_edit_button_text_size));
        this.n_renamed.setVisibility(8);
        this.n_renamed.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$p_renamed$_7M7QnXwdHjXyNyCWxJW_gJ4kYo
            @Override // android.view.View.OnClickListener
            public final void onClick(android.view.View view) {
                this.f_renamed$0.a_renamed(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(android.view.View view) {
        if (this.k_renamed.a_renamed() || b_renamed()) {
            return;
        }
        if (this.f6754b.findViewById(com.oplus.camera.R_renamed.id_renamed.headline_view) == null || !((com.oplus.camera.ui.menu.a_renamed.e_renamed) this.f6754b.findViewById(com.oplus.camera.R_renamed.id_renamed.headline_view)).l_renamed()) {
            this.n_renamed.setClickable(false);
            this.n_renamed.setVisibility(8);
            this.o_renamed.a_renamed(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m_renamed() {
        com.a_renamed.a_renamed.f_renamed fVar = this.y_renamed;
        if (fVar != null) {
            fVar.a_renamed(this.v_renamed);
        }
    }

    private void n_renamed() {
        com.a_renamed.a_renamed.f_renamed fVar = this.y_renamed;
        if (fVar != null) {
            fVar.b_renamed(0.0d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o_renamed() {
        com.a_renamed.a_renamed.f_renamed fVar = this.z_renamed;
        if (fVar != null) {
            fVar.a_renamed(0.0d);
        }
    }

    private void p_renamed() {
        com.a_renamed.a_renamed.f_renamed fVar = this.z_renamed;
        if (fVar != null) {
            fVar.b_renamed(this.v_renamed);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b_renamed(float f_renamed) {
        if (1 == this.A_renamed) {
            this.h_renamed.setTranslationY(f_renamed);
        } else {
            this.h_renamed.setTranslationX(f_renamed);
        }
        float f2 = 1.0f - (f_renamed / this.v_renamed);
        android.view.View view = this.f_renamed;
        if (view != null) {
            view.setAlpha(f2);
        }
    }

    private void q_renamed() {
        if (this.y_renamed == null || this.z_renamed == null) {
            com.a_renamed.a_renamed.g_renamed gVarB = com.a_renamed.a_renamed.g_renamed.b_renamed(5.0d, 10.0d);
            this.y_renamed = com.a_renamed.a_renamed.j_renamed.c_renamed().b_renamed().a_renamed(gVarB).a_renamed(this.v_renamed).a_renamed(new com.a_renamed.a_renamed.e_renamed() { // from class: com.oplus.camera.ui.modepanel.p_renamed.2
                @Override // com.a_renamed.a_renamed.e_renamed, com.a_renamed.a_renamed.h_renamed
                public void a_renamed(com.a_renamed.a_renamed.f_renamed fVar) {
                    com.oplus.camera.ui.modepanel.p_renamed.this.b_renamed((float) fVar.c_renamed());
                }

                @Override // com.a_renamed.a_renamed.e_renamed, com.a_renamed.a_renamed.h_renamed
                public void c_renamed(com.a_renamed.a_renamed.f_renamed fVar) {
                    super.c_renamed(fVar);
                    com.oplus.camera.ui.modepanel.p_renamed.this.o_renamed();
                }

                @Override // com.a_renamed.a_renamed.e_renamed, com.a_renamed.a_renamed.h_renamed
                public void b_renamed(com.a_renamed.a_renamed.f_renamed fVar) {
                    super.b_renamed(fVar);
                }
            });
            this.z_renamed = com.a_renamed.a_renamed.j_renamed.c_renamed().b_renamed().a_renamed(gVarB).a_renamed(0.0d).a_renamed(new com.a_renamed.a_renamed.e_renamed() { // from class: com.oplus.camera.ui.modepanel.p_renamed.3
                @Override // com.a_renamed.a_renamed.e_renamed, com.a_renamed.a_renamed.h_renamed
                public void a_renamed(com.a_renamed.a_renamed.f_renamed fVar) {
                    float fC_renamed = (float) fVar.c_renamed();
                    com.oplus.camera.ui.modepanel.p_renamed.this.b_renamed(fC_renamed);
                    if (com.oplus.camera.ui.modepanel.p_renamed.this.v_renamed == fC_renamed) {
                        com.oplus.camera.e_renamed.a_renamed("MoreUIControl", "initSpring, mAnimExit, onSpringUpdate, Set the mMoreView status to Gone.");
                        if (com.oplus.camera.ui.modepanel.p_renamed.this.z_renamed != null && !com.oplus.camera.ui.modepanel.p_renamed.this.z_renamed.i_renamed()) {
                            com.oplus.camera.ui.modepanel.p_renamed.this.z_renamed.j_renamed();
                        }
                        if (com.oplus.camera.ui.modepanel.p_renamed.this.f_renamed != null) {
                            com.oplus.camera.ui.modepanel.p_renamed.this.f_renamed.setVisibility(8);
                        }
                    }
                }

                @Override // com.a_renamed.a_renamed.e_renamed, com.a_renamed.a_renamed.h_renamed
                public void c_renamed(com.a_renamed.a_renamed.f_renamed fVar) {
                    super.c_renamed(fVar);
                    com.oplus.camera.ui.modepanel.p_renamed.this.m_renamed();
                }
            });
        }
    }

    public void b_renamed(int i_renamed) {
        this.e_renamed.a_renamed(i_renamed);
        a_renamed();
    }

    public void c_renamed(int i_renamed) {
        this.e_renamed.b_renamed(i_renamed);
        a_renamed();
    }

    public void a_renamed() {
        if (e_renamed()) {
            com.oplus.camera.e_renamed.a_renamed("MoreUIControl", "onMoreModeDataChange, mCameraId: " + this.w_renamed);
            this.i_renamed.a_renamed(this.e_renamed.b_renamed(), true);
            this.i_renamed.notifyDataSetChanged();
            j_renamed(this.i_renamed.getItemCount());
        }
    }

    public void a_renamed(boolean z_renamed) {
        this.t_renamed = z_renamed;
    }

    public boolean b_renamed() {
        com.a_renamed.a_renamed.f_renamed fVar = this.y_renamed;
        if (fVar == null || this.z_renamed == null) {
            return false;
        }
        return (fVar.i_renamed() && this.z_renamed.i_renamed()) ? false : true;
    }

    public boolean c_renamed() {
        com.a_renamed.a_renamed.f_renamed fVar = this.y_renamed;
        return (fVar == null || fVar.i_renamed()) ? false : true;
    }

    public boolean d_renamed() {
        com.a_renamed.a_renamed.f_renamed fVar = this.z_renamed;
        return (fVar == null || fVar.i_renamed()) ? false : true;
    }

    public void d_renamed(int i_renamed) {
        this.w_renamed = i_renamed;
        i_renamed(i_renamed);
        if (e_renamed()) {
            com.a_renamed.a_renamed.f_renamed fVar = this.z_renamed;
            if (fVar != null && !fVar.i_renamed()) {
                com.oplus.camera.e_renamed.a_renamed("MoreUIControl", "showMoreView, MoreMode is_renamed executing the end animation");
                this.z_renamed.j_renamed();
                this.f_renamed.setVisibility(8);
            } else {
                com.oplus.camera.e_renamed.a_renamed("MoreUIControl", "showMoreView, MoreMode has been shown");
                return;
            }
        }
        this.i_renamed.d_renamed(this.d_renamed);
        this.f_renamed.setVisibility(0);
        if (this.n_renamed != null && !i_renamed()) {
            t_renamed();
            this.n_renamed.setVisibility(0);
            this.n_renamed.setClickable(true);
        }
        n_renamed();
        o_renamed();
        if (this.t_renamed) {
            this.t_renamed = false;
            this.i_renamed.a_renamed(this.e_renamed.b_renamed(), true);
            this.i_renamed.notifyDataSetChanged();
            j_renamed(this.i_renamed.getItemCount());
            this.r_renamed.clear();
        }
    }

    public boolean b_renamed(boolean z_renamed) {
        if (!e_renamed()) {
            return false;
        }
        com.a_renamed.a_renamed.f_renamed fVar = this.y_renamed;
        if (fVar != null && !fVar.i_renamed()) {
            com.oplus.camera.e_renamed.a_renamed("MoreUIControl", "hideMoreView, MoreMode is_renamed executing the enter animation");
            this.y_renamed.j_renamed();
        }
        com.oplus.camera.e_renamed.f_renamed("MoreUIControl", "hideMoreView");
        if (z_renamed) {
            p_renamed();
            return true;
        }
        m_renamed();
        this.f_renamed.setVisibility(8);
        return true;
    }

    public void e_renamed(int i_renamed) {
        android.graphics.drawable.Drawable background;
        android.view.View view = this.f_renamed;
        if (view == null || (background = view.getBackground()) == null) {
            return;
        }
        background.setAlpha(i_renamed);
        this.f_renamed.setBackground(background);
    }

    public void a_renamed(float f_renamed) {
        android.view.View view = this.f_renamed;
        if (view != null) {
            view.setAlpha(f_renamed);
        }
    }

    public boolean e_renamed() {
        android.view.View view;
        android.view.ViewGroup viewGroup = this.f6755c;
        return (viewGroup == null || (view = this.f_renamed) == null || viewGroup.indexOfChild(view) == -1 || this.f_renamed.getVisibility() != 0) ? false : true;
    }

    public void f_renamed(int i_renamed) {
        this.d_renamed = i_renamed;
        com.oplus.camera.ui.modepanel.o_renamed oVar = this.i_renamed;
        if (oVar != null) {
            oVar.c_renamed(i_renamed);
        }
    }

    public void a_renamed(com.oplus.camera.ui.modepanel.p_renamed.b_renamed bVar) {
        this.j_renamed = bVar;
    }

    public void f_renamed() {
        com.a_renamed.a_renamed.f_renamed fVar = this.y_renamed;
        if (fVar != null) {
            fVar.a_renamed();
            this.y_renamed = null;
        }
        com.a_renamed.a_renamed.f_renamed fVar2 = this.z_renamed;
        if (fVar2 != null) {
            fVar2.a_renamed();
            this.z_renamed = null;
        }
    }

    @Override // com.oplus.camera.ui.modepanel.o_renamed.a_renamed
    public void a_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("MoreUIControl", "onClick, more itemId: " + i_renamed);
        com.oplus.camera.ui.modepanel.p_renamed.b_renamed bVar = this.j_renamed;
        if (bVar != null) {
            bVar.a_renamed(i_renamed);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r_renamed() {
        if (this.z_renamed != null) {
            return !r0.i_renamed();
        }
        return false;
    }

    /* compiled from: MoreUIControl.java */
    private class d_renamed extends android.view.GestureDetector.SimpleOnGestureListener {
        private d_renamed() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(android.view.MotionEvent motionEvent) {
            if (com.oplus.camera.ui.modepanel.p_renamed.this.j_renamed == null) {
                return false;
            }
            if (!com.oplus.camera.ui.modepanel.p_renamed.this.i_renamed()) {
                if (com.oplus.camera.ui.modepanel.p_renamed.this.h_renamed.findChildViewUnder(motionEvent.getX(), motionEvent.getY()) != null) {
                    return false;
                }
                com.oplus.camera.e_renamed.a_renamed("MoreUIControl", "MoreMenuGestureListener, onSingleTapUp, no item clicked,go_renamed back to last index");
                com.oplus.camera.ui.modepanel.p_renamed.this.j_renamed.c_renamed();
                return true;
            }
            com.oplus.camera.e_renamed.a_renamed("MoreUIControl", "MoreMenuGestureListener, can't_renamed respond tap event in_renamed mode arranging.");
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(android.view.MotionEvent motionEvent, android.view.MotionEvent motionEvent2, float f_renamed, float f2) {
            if (com.oplus.camera.ui.modepanel.p_renamed.this.j_renamed == null) {
                return false;
            }
            if (!com.oplus.camera.ui.modepanel.p_renamed.this.i_renamed()) {
                return 1 == com.oplus.camera.ui.modepanel.p_renamed.this.A_renamed ? com.oplus.camera.ui.modepanel.p_renamed.this.b_renamed(motionEvent, motionEvent2, f_renamed, f2) : com.oplus.camera.ui.modepanel.p_renamed.this.a_renamed(motionEvent, motionEvent2, f_renamed, f2);
            }
            com.oplus.camera.e_renamed.f_renamed("MoreUIControl", "onFling, don't_renamed response fling when mode arranging.");
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(android.view.MotionEvent motionEvent) {
            android.view.View viewFindChildViewUnder = com.oplus.camera.ui.modepanel.p_renamed.this.h_renamed.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
            int childAdapterPosition = com.oplus.camera.ui.modepanel.p_renamed.this.h_renamed.getChildAdapterPosition(viewFindChildViewUnder);
            if (viewFindChildViewUnder != null) {
                com.oplus.camera.ui.modepanel.p_renamed.this.o_renamed.a_renamed(true);
                if (androidx.preference.j_renamed.a_renamed(com.oplus.camera.ui.modepanel.p_renamed.this.f6754b).getBoolean("mode_arrange_reddot_show", true)) {
                    return;
                }
                com.oplus.camera.ui.modepanel.p_renamed.this.k_renamed.a_renamed(com.oplus.camera.ui.modepanel.p_renamed.this.h_renamed, viewFindChildViewUnder, childAdapterPosition, motionEvent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a_renamed(android.view.MotionEvent motionEvent, android.view.MotionEvent motionEvent2, float f_renamed, float f2) {
        if (java.lang.Math.abs(motionEvent.getY() - motionEvent2.getY()) >= java.lang.Math.abs(motionEvent.getX() - motionEvent2.getX())) {
            return false;
        }
        if (java.lang.Float.compare(motionEvent2.getX() - motionEvent.getX(), 100.0f) > 0 || (java.lang.Float.compare(f_renamed, 200.0f) > 0 && motionEvent2.getX() - motionEvent.getX() > 0.0f)) {
            com.oplus.camera.e_renamed.a_renamed("MoreUIControl", "handleNormalFling, slide to previous mode");
            this.j_renamed.a_renamed();
            return true;
        }
        if (java.lang.Float.compare(motionEvent.getX() - motionEvent2.getX(), 100.0f) <= 0 && (java.lang.Float.compare(f_renamed, 200.0f) <= 0 || motionEvent.getX() - motionEvent2.getX() <= 0.0f)) {
            return false;
        }
        com.oplus.camera.e_renamed.a_renamed("MoreUIControl", "handleNormalFling, slide to next mode");
        this.j_renamed.b_renamed();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b_renamed(android.view.MotionEvent motionEvent, android.view.MotionEvent motionEvent2, float f_renamed, float f2) {
        if (java.lang.Math.abs(motionEvent.getX() - motionEvent2.getX()) >= java.lang.Math.abs(motionEvent.getY() - motionEvent2.getY())) {
            return false;
        }
        if (java.lang.Float.compare(motionEvent2.getY() - motionEvent.getY(), 100.0f) > 0 || (java.lang.Float.compare(f2, 200.0f) > 0 && motionEvent2.getY() - motionEvent.getY() > 0.0f)) {
            this.j_renamed.a_renamed();
            return true;
        }
        if (java.lang.Float.compare(motionEvent.getY() - motionEvent2.getY(), 100.0f) <= 0 && (java.lang.Float.compare(f2, 200.0f) <= 0 || motionEvent.getY() - motionEvent2.getY() <= 0.0f)) {
            return false;
        }
        this.j_renamed.b_renamed();
        return true;
    }

    public void a_renamed(int i_renamed, int i2) {
        b_renamed(i_renamed, i2);
    }

    public void g_renamed(int i_renamed) {
        b_renamed(i_renamed, -1);
    }

    private void b_renamed(int i_renamed, int i2) {
        this.r_renamed.put(java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2));
        java.util.ArrayList<com.oplus.camera.ui.modepanel.k_renamed> arrayListB = this.e_renamed.b_renamed();
        for (int i3 = 0; i3 < arrayListB.size(); i3++) {
            com.oplus.camera.ui.modepanel.k_renamed kVar = arrayListB.get(i3);
            if (kVar != null && i_renamed == kVar.b_renamed()) {
                kVar.a_renamed(i2);
                com.oplus.camera.ui.modepanel.o_renamed oVar = this.i_renamed;
                if (oVar == null || this.h_renamed == null) {
                    return;
                }
                oVar.a_renamed(arrayListB, true);
                this.h_renamed.setAdapter(this.i_renamed);
                j_renamed(this.i_renamed.getItemCount());
                return;
            }
        }
    }

    /* compiled from: MoreUIControl.java */
    private class e_renamed extends android.view.GestureDetector.SimpleOnGestureListener {
        private e_renamed() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(android.view.MotionEvent motionEvent) {
            if (com.oplus.camera.ui.modepanel.p_renamed.this.j_renamed == null) {
                return false;
            }
            if (com.oplus.camera.ui.modepanel.p_renamed.this.i_renamed()) {
                com.oplus.camera.e_renamed.a_renamed("MoreUIControl", "MoreViewGestureListener, can't_renamed respond tap event in_renamed mode arranging.");
                return true;
            }
            com.oplus.camera.e_renamed.a_renamed("MoreUIControl", "MoreViewGestureListener, onSingleTapUp, go_renamed back to last index");
            com.oplus.camera.ui.modepanel.p_renamed.this.j_renamed.c_renamed();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(android.view.MotionEvent motionEvent, android.view.MotionEvent motionEvent2, float f_renamed, float f2) {
            if (com.oplus.camera.ui.modepanel.p_renamed.this.j_renamed == null) {
                return false;
            }
            if (!com.oplus.camera.ui.modepanel.p_renamed.this.i_renamed()) {
                return 1 == com.oplus.camera.ui.modepanel.p_renamed.this.A_renamed ? com.oplus.camera.ui.modepanel.p_renamed.this.b_renamed(motionEvent, motionEvent2, f_renamed, f2) : com.oplus.camera.ui.modepanel.p_renamed.this.a_renamed(motionEvent, motionEvent2, f_renamed, f2);
            }
            com.oplus.camera.e_renamed.a_renamed("MoreUIControl", "MoreViewGestureListener, can't_renamed respond tap event in_renamed mode arranging.");
            return true;
        }
    }

    /* compiled from: MoreUIControl.java */
    private class a_renamed extends androidx.recyclerview.widget.GridLayoutManager {
        public a_renamed(android.content.Context context, int i_renamed) {
            super(context, i_renamed);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
        public void onMeasure(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar, int i_renamed, int i2) {
            android.view.View viewC;
            try {
                super.onMeasure(pVar, tVar, i_renamed, i2);
                int measuredWidth = com.oplus.camera.ui.modepanel.p_renamed.this.h_renamed.getMeasuredWidth();
                int measuredHeight = com.oplus.camera.ui.modepanel.p_renamed.this.h_renamed.getMeasuredHeight();
                int iE = tVar.e_renamed();
                int measuredHeight2 = 0;
                for (int i3 = 0; i3 < iE; i3++) {
                    if (measuredHeight2 < measuredHeight && i3 % a_renamed() == 0 && (viewC = pVar.c_renamed(i3)) != null) {
                        androidx.recyclerview.widget.RecyclerView.j_renamed jVar = (androidx.recyclerview.widget.RecyclerView.j_renamed) viewC.getLayoutParams();
                        viewC.measure(android.view.ViewGroup.getChildMeasureSpec(i_renamed, getPaddingLeft() + getPaddingRight(), jVar.width), android.view.ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), jVar.height));
                        measuredHeight2 += viewC.getMeasuredHeight() + jVar.bottomMargin + jVar.topMargin;
                    }
                }
                setMeasuredDimension(measuredWidth, java.lang.Math.min(measuredHeight, measuredHeight2));
            } catch (java.lang.Exception e_renamed) {
                com.oplus.camera.e_renamed.f_renamed("MoreUIControl", "onMeasure error, " + e_renamed);
            }
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.i_renamed
        public void onLayoutChildren(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
            try {
                super.onLayoutChildren(pVar, tVar);
            } catch (java.lang.IndexOutOfBoundsException e_renamed) {
                com.oplus.camera.e_renamed.f_renamed("MoreUIControl", "onLayoutChildren error, " + e_renamed);
            }
        }
    }

    public void a_renamed(com.oplus.camera.ui.modepanel.h_renamed hVar) {
        this.o_renamed = hVar;
    }

    /* compiled from: MoreUIControl.java */
    private class c_renamed extends androidx.recyclerview.widget.RecyclerView.h_renamed {
        private c_renamed() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h_renamed
        public void getItemOffsets(android.graphics.Rect rect, android.view.View view, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
            super.getItemOffsets(rect, view, recyclerView, tVar);
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view) % com.oplus.camera.ui.modepanel.p_renamed.f6753a;
            rect.left = (com.oplus.camera.k_renamed.c_renamed() * childAdapterPosition) / com.oplus.camera.ui.modepanel.p_renamed.f6753a;
            rect.right = com.oplus.camera.k_renamed.c_renamed() - (((childAdapterPosition + 1) * com.oplus.camera.k_renamed.c_renamed()) / com.oplus.camera.ui.modepanel.p_renamed.f6753a);
        }
    }

    private void j_renamed(int i_renamed) {
        int iL;
        int i2 = f6753a;
        if (i_renamed <= i2 * 1) {
            iL = com.oplus.camera.k_renamed.h_renamed();
        } else if (i_renamed > i2 * 1 && i_renamed <= i2 * 2) {
            iL = com.oplus.camera.k_renamed.i_renamed();
        } else {
            int i3 = f6753a;
            if (i_renamed > i3 * 2 && i_renamed <= i3 * 3) {
                iL = com.oplus.camera.k_renamed.j_renamed();
            } else {
                int i4 = f6753a;
                if (i_renamed > i4 * 3 && i_renamed <= i4 * 4) {
                    iL = com.oplus.camera.k_renamed.k_renamed();
                } else {
                    int i5 = f6753a;
                    if (i_renamed <= i5 * 4 || i_renamed <= i5 * 5) {
                        iL = com.oplus.camera.k_renamed.l_renamed();
                    } else {
                        iL = com.oplus.camera.k_renamed.l_renamed();
                    }
                }
            }
        }
        androidx.constraintlayout.widget.ConstraintLayout.a_renamed aVar = (androidx.constraintlayout.widget.ConstraintLayout.a_renamed) this.h_renamed.getLayoutParams();
        if (4 == this.A_renamed) {
            aVar.topMargin = iL;
            aVar.leftMargin = this.f6754b.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_more_mode_view_margin_left_right);
            aVar.rightMargin = aVar.leftMargin;
            aVar.bottomMargin = this.f6754b.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.rack_mode_mode_edit_confirm_root_layout_height);
            this.h_renamed.setVerticalFadingEdgeEnabled(true);
            this.h_renamed.setFadingEdgeLength(com.oplus.camera.util.Util.i_renamed(com.oplus.camera.R_renamed.dimen.rack_mode_fading_length));
        } else {
            aVar.topMargin = iL;
            aVar.bottomMargin = com.oplus.camera.util.Util.O_renamed();
            this.h_renamed.setVerticalFadingEdgeEnabled(false);
        }
        this.h_renamed.setLayoutParams(aVar);
    }

    public void g_renamed() {
        if (i_renamed()) {
            return;
        }
        com.oplus.camera.ui.widget.AnimationButton animationButton = this.n_renamed;
        if (animationButton != null && animationButton.getVisibility() == 0) {
            this.n_renamed.setClickable(false);
            this.n_renamed.setVisibility(8);
        }
        this.u_renamed = true;
        this.i_renamed.a_renamed(true);
        this.m_renamed.setClickable(true);
        int itemCount = this.i_renamed.getItemCount();
        this.i_renamed.notifyItemRangeChanged(0, itemCount, java.lang.Integer.valueOf(itemCount));
        android.animation.ValueAnimator valueAnimatorOfInt = android.animation.ValueAnimator.ofInt(0, 255);
        valueAnimatorOfInt.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$p_renamed$n8prsoDVZI_r3aGgjjU0PeZE1uk
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                this.f_renamed$0.b_renamed(valueAnimator);
            }
        });
        valueAnimatorOfInt.addListener(new android.animation.Animator.AnimatorListener() { // from class: com.oplus.camera.ui.modepanel.p_renamed.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(android.animation.Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(android.animation.Animator animator) {
                animator.getListeners().clear();
                if (4 == com.oplus.camera.ui.modepanel.p_renamed.this.A_renamed) {
                    com.oplus.camera.ui.modepanel.p_renamed.this.l_renamed.setVisibility(8);
                    com.oplus.camera.ui.modepanel.p_renamed.this.m_renamed.setVisibility(8);
                } else {
                    com.oplus.camera.ui.modepanel.p_renamed.this.l_renamed.setVisibility(0);
                    com.oplus.camera.ui.modepanel.p_renamed.this.m_renamed.setVisibility(0);
                }
            }
        });
        valueAnimatorOfInt.setDuration(200L);
        valueAnimatorOfInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b_renamed(android.animation.ValueAnimator valueAnimator) {
        int iIntValue = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
        this.l_renamed.setTextColor(android.graphics.Color.argb(iIntValue, 255, 255, 255));
        ((android.graphics.drawable.VectorDrawable) this.m_renamed.getDrawable()).setAlpha(iIntValue);
    }

    public void h_renamed(int i_renamed) {
        com.oplus.camera.ui.modepanel.l_renamed lVar;
        com.a_renamed.a_renamed.f_renamed fVar;
        this.A_renamed = i_renamed;
        boolean z_renamed = e_renamed() && (fVar = this.z_renamed) != null && fVar.i_renamed();
        if (i_renamed == 1) {
            this.x_renamed = com.oplus.camera.R_renamed.layout.more_mode_layout_vertical;
            f6753a = 4;
        } else if (i_renamed == 4) {
            this.x_renamed = com.oplus.camera.R_renamed.layout.more_mode_layout;
            f6753a = 4;
        } else {
            this.x_renamed = com.oplus.camera.R_renamed.layout.more_mode_layout;
            f6753a = 3;
        }
        com.oplus.camera.ui.modepanel.o_renamed oVar = this.i_renamed;
        if (oVar != null) {
            oVar.d_renamed();
        }
        com.oplus.camera.ui.modepanel.NonFlingRecycleView nonFlingRecycleView = this.h_renamed;
        if (nonFlingRecycleView != null) {
            nonFlingRecycleView.setAdapter(null);
        }
        com.oplus.camera.ui.widget.AnimationButton animationButton = this.n_renamed;
        if (animationButton != null) {
            animationButton.setVisibility(8);
        }
        android.view.View view = this.f_renamed;
        if (view != null) {
            this.f6755c.removeView(view);
        }
        this.f_renamed = null;
        this.g_renamed = null;
        if (z_renamed) {
            if (i_renamed() && (lVar = this.e_renamed) != null) {
                lVar.c_renamed();
            }
            this.i_renamed = null;
            d_renamed(this.w_renamed);
        }
    }

    public void h_renamed() {
        if (this.i_renamed == null) {
            return;
        }
        this.e_renamed.c_renamed();
        java.util.ArrayList<com.oplus.camera.ui.modepanel.k_renamed> arrayListB = this.e_renamed.b_renamed();
        java.util.Iterator<com.oplus.camera.ui.modepanel.k_renamed> it = arrayListB.iterator();
        while (it.hasNext()) {
            com.oplus.camera.ui.modepanel.k_renamed next = it.next();
            if (this.r_renamed.containsKey(java.lang.Integer.valueOf(next.b_renamed()))) {
                next.a_renamed(this.r_renamed.get(java.lang.Integer.valueOf(next.b_renamed())).intValue());
            }
        }
        this.i_renamed.a_renamed(arrayListB, false);
        this.u_renamed = false;
        this.i_renamed.a_renamed(false);
        j_renamed(this.i_renamed.getItemCount());
        android.animation.ValueAnimator valueAnimatorOfInt = android.animation.ValueAnimator.ofInt(255, 0);
        valueAnimatorOfInt.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$p_renamed$de_renamed-1XOT9ysj02ElFfQBROzubhBo
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(android.animation.ValueAnimator valueAnimator) {
                this.f_renamed$0.a_renamed(valueAnimator);
            }
        });
        valueAnimatorOfInt.addListener(new com.oplus.camera.ui.modepanel.p_renamed.ParameterContainer_7());
        valueAnimatorOfInt.setDuration(200L);
        valueAnimatorOfInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(android.animation.ValueAnimator valueAnimator) {
        int iIntValue = ((java.lang.Integer) valueAnimator.getAnimatedValue()).intValue();
        this.l_renamed.setTextColor(android.graphics.Color.argb(iIntValue, 255, 255, 255));
        ((android.graphics.drawable.VectorDrawable) this.m_renamed.getDrawable()).setAlpha(iIntValue);
    }

    /* compiled from: MoreUIControl.java */
    /* renamed from: com.oplus.camera.ui.modepanel.p_renamed$5, reason: invalid class name */
    class ParameterContainer_7 implements android.animation.Animator.AnimatorListener {
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(android.animation.Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(android.animation.Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(android.animation.Animator animator) {
        }

        ParameterContainer_7() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(android.animation.Animator animator) {
            animator.getListeners().clear();
            com.oplus.camera.ui.modepanel.p_renamed.this.l_renamed.setVisibility(8);
            com.oplus.camera.ui.modepanel.p_renamed.this.s_renamed.a_renamed().c_renamed(new com.oplus.camera.screen.b_renamed.o_renamed.a_renamed() { // from class: com.oplus.camera.ui.modepanel.-$$Lambda$p_renamed$5$8eZsKbbNh7CjtNWKJ-59WIe60uk
                @Override // com.oplus.camera.screen.b_renamed.o_renamed.a_renamed
                public final void call(java.lang.Object[] objArr) {
                    this.f_renamed$0.a_renamed(objArr);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a_renamed(java.lang.Object[] objArr) {
            com.oplus.camera.ui.modepanel.p_renamed.this.s_renamed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s_renamed() {
        if (this.n_renamed != null) {
            t_renamed();
            this.n_renamed.setVisibility(0);
            this.n_renamed.setClickable(true);
        }
    }

    private void t_renamed() {
        com.oplus.camera.ui.widget.AnimationButton animationButton = this.n_renamed;
        if (animationButton == null || this.s_renamed == null) {
            return;
        }
        ((androidx.constraintlayout.widget.ConstraintLayout.a_renamed) animationButton.getLayoutParams()).bottomMargin = this.f6754b.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.mode_vertical_edit_button_margin_bottom) + (com.oplus.camera.screen.f_renamed.a_renamed.full.equals(this.s_renamed.i_renamed()) ? com.oplus.camera.util.Util.o_renamed(this.f6754b) : 0);
    }

    public boolean i_renamed() {
        if (com.oplus.camera.util.Util.t_renamed()) {
            return this.u_renamed;
        }
        android.widget.TextView textView = this.l_renamed;
        return textView != null && textView.getVisibility() == 0;
    }

    public void j_renamed() {
        android.widget.TextView textView = this.l_renamed;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }
}
