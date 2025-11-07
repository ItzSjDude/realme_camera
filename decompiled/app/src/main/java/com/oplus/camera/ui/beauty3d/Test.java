package com.oplus.camera.ui.beauty3d;

/* compiled from: Beauty3DEditUI.java */
/* loaded from: classes2.dex */
public class d_renamed implements android.view.View.OnClickListener, com.oplus.camera.ui.OplusNumSeekBar.a_renamed {
    private com.oplus.camera.ui.beauty3d.i_renamed H_renamed;
    private android.widget.RelativeLayout J_renamed;
    private android.view.GestureDetector K_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.graphics.Point f5905a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.graphics.Point f5906b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.graphics.Point f5907c;
    private android.graphics.Point d_renamed;
    private android.graphics.Point e_renamed;
    private android.app.Activity f_renamed;
    private android.view.ViewGroup g_renamed = null;
    private int h_renamed = 0;
    private int i_renamed = 0;
    private boolean j_renamed = false;
    private android.widget.TextView k_renamed = null;
    private android.widget.TextView l_renamed = null;
    private android.widget.TextView m_renamed = null;
    private android.widget.TextView n_renamed = null;
    private android.widget.TextView o_renamed = null;
    private android.widget.TextView p_renamed = null;
    private android.widget.TextView q_renamed = null;
    private android.widget.ImageView r_renamed = null;
    private android.widget.ImageView s_renamed = null;
    private androidx.recyclerview.widget.RecyclerView t_renamed = null;
    private android.widget.RelativeLayout u_renamed = null;
    private android.widget.RelativeLayout v_renamed = null;
    private com.oplus.camera.ui.OplusNumSeekBar w_renamed = null;
    private com.oplus.camera.ui.OplusNumSeekBar x_renamed = null;
    private com.oplus.camera.ui.beauty3d.a_renamed y_renamed = null;
    private com.oplus.camera.ui.beauty3d.a_renamed z_renamed = null;
    private com.oplus.camera.ui.beauty3d.a_renamed A_renamed = null;
    private com.oplus.camera.ui.beauty3d.a_renamed B_renamed = null;
    private com.oplus.camera.ui.beauty3d.a_renamed C_renamed = null;
    private com.oplus.camera.ui.beauty3d.a_renamed D_renamed = null;
    private com.oplus.camera.ui.beauty3d.a_renamed E_renamed = null;
    private android.widget.LinearLayout F_renamed = null;
    private android.widget.LinearLayout G_renamed = null;
    private android.view.View I_renamed = null;
    private com.oplus.camera.ui.beauty3d.d_renamed.e_renamed L_renamed = null;
    private com.oplus.camera.ui.beauty3d.d_renamed.b_renamed M_renamed = null;
    private java.util.List<com.oplus.camera.ui.beauty3d.d_renamed.c_renamed> N_renamed = null;
    private boolean O_renamed = false;
    private android.view.View P_renamed = null;
    private android.view.View Q_renamed = null;
    private android.view.View R_renamed = null;
    private android.view.View S_renamed = null;
    private android.view.View T_renamed = null;
    private android.view.View U_renamed = null;
    private android.view.View V_renamed = null;
    private com.oplus.camera.ui.menu.OplusTextView W_renamed = null;
    private com.oplus.camera.ui.menu.OplusTextView X_renamed = null;
    private com.oplus.camera.ui.menu.OplusTextView Y_renamed = null;
    private com.oplus.camera.ui.menu.OplusTextView Z_renamed = null;
    private com.oplus.camera.ui.menu.OplusTextView aa_renamed = null;
    private android.widget.ImageView ab_renamed = null;
    private android.widget.ImageView ac_renamed = null;
    private java.lang.String ad_renamed = null;
    private java.lang.String ae_renamed = null;
    private java.lang.String af_renamed = null;
    private java.lang.String ag_renamed = null;
    private java.lang.String ah_renamed = null;
    private boolean ai_renamed = false;
    private com.oplus.camera.ui.beauty3d.c_renamed aj_renamed = new com.oplus.camera.ui.beauty3d.c_renamed();
    private com.oplus.camera.ui.camerascreenhint.CameraScreenHintView ak_renamed = null;
    private int al_renamed = 0;
    private int am_renamed = 0;
    private float an_renamed = 0.0f;
    private boolean ao_renamed = false;
    private int ap_renamed = 0;
    private boolean aq_renamed = false;
    private boolean ar_renamed = true;
    private int[] as_renamed = {2};
    private int[] at_renamed = {1};
    private int[] au_renamed = {0};
    private int[] av_renamed = new int[8];
    private android.util.SparseArray<int[]> aw_renamed = new android.util.SparseArray<>();
    private android.util.SparseArray<int[]> ax_renamed = null;
    private int ay_renamed = 0;
    private int az_renamed = 0;
    private android.view.View.OnTouchListener aA_renamed = new android.view.View.OnTouchListener() { // from class: com.oplus.camera.ui.beauty3d.d_renamed.1
        /* JADX WARN: Removed duplicated region for block: B_renamed:13:0x001a  */
        /* JADX WARN: Removed duplicated region for block: B_renamed:19:0x004a  */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onTouch(android.view.View r4, android.view.MotionEvent r5) {
            /*
                r3 = this;
                int r4 = r4.getId()
                r0 = 1
                r1 = 2131296659(0x7f090193, float:1.821124E38)
                if (r4 == r1) goto Lb
                return r0
            Lb:
                int r4 = r5.getActionMasked()
                if (r4 == 0) goto L4a
                if (r4 == r0) goto L1a
                r1 = 2
                if (r4 == r1) goto L4a
                r1 = 3
                if (r4 == r1) goto L1a
                goto L5b
            L1a:
                com.oplus.camera.ui.beauty3d.d_renamed r4 = com.oplus.camera.ui.beauty3d.d_renamed.this
                com.oplus.camera.ui.beauty3d.d_renamed.a_renamed(r4, r0)
                com.oplus.camera.ui.beauty3d.d_renamed r4 = com.oplus.camera.ui.beauty3d.d_renamed.this
                com.oplus.camera.ui.beauty3d.i_renamed r4 = com.oplus.camera.ui.beauty3d.d_renamed.a_renamed(r4)
                if (r4 == 0) goto L38
                com.oplus.camera.ui.beauty3d.d_renamed r4 = com.oplus.camera.ui.beauty3d.d_renamed.this
                com.oplus.camera.ui.beauty3d.i_renamed r4 = com.oplus.camera.ui.beauty3d.d_renamed.a_renamed(r4)
                com.oplus.camera.ui.beauty3d.d_renamed r1 = com.oplus.camera.ui.beauty3d.d_renamed.this
                int[] r1 = com.oplus.camera.ui.beauty3d.d_renamed.b_renamed(r1)
                java.lang.String r2 = "com.oplus.beauty3d.custom.mode"
                r4.a_renamed(r2, r1)
            L38:
                com.oplus.camera.ui.beauty3d.d_renamed r4 = com.oplus.camera.ui.beauty3d.d_renamed.this
                android.view.GestureDetector r4 = com.oplus.camera.ui.beauty3d.d_renamed.c_renamed(r4)
                if (r4 == 0) goto L5b
                com.oplus.camera.ui.beauty3d.d_renamed r3 = com.oplus.camera.ui.beauty3d.d_renamed.this
                android.view.GestureDetector r3 = com.oplus.camera.ui.beauty3d.d_renamed.c_renamed(r3)
                r3.onTouchEvent(r5)
                goto L5b
            L4a:
                com.oplus.camera.ui.beauty3d.d_renamed r4 = com.oplus.camera.ui.beauty3d.d_renamed.this
                android.view.GestureDetector r4 = com.oplus.camera.ui.beauty3d.d_renamed.c_renamed(r4)
                if (r4 == 0) goto L5b
                com.oplus.camera.ui.beauty3d.d_renamed r3 = com.oplus.camera.ui.beauty3d.d_renamed.this
                android.view.GestureDetector r3 = com.oplus.camera.ui.beauty3d.d_renamed.c_renamed(r3)
                r3.onTouchEvent(r5)
            L5b:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.beauty3d.d_renamed.SceneLoader_2.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    };
    private com.oplus.camera.ui.beauty3d.d_renamed.Beauty3DEditUI_7 aB_renamed = new com.oplus.camera.ui.beauty3d.d_renamed.Beauty3DEditUI_7() { // from class: com.oplus.camera.ui.beauty3d.d_renamed.2
        @Override // com.oplus.camera.ui.beauty3d.d_renamed.Beauty3DEditUI_7
        public void a_renamed(android.view.View view, int i_renamed) {
            com.oplus.camera.e_renamed.a_renamed("Beauty3DEditUI", "onItemClick, position: " + i_renamed);
            com.oplus.camera.ui.beauty3d.d_renamed.this.H_renamed();
            if (i_renamed == 0) {
                com.oplus.camera.ui.beauty3d.d_renamed.this.b_renamed(0);
                return;
            }
            if (i_renamed == 1) {
                com.oplus.camera.ui.beauty3d.d_renamed.this.b_renamed(1);
            } else if (i_renamed == 2) {
                com.oplus.camera.ui.beauty3d.d_renamed.this.b_renamed(2);
            } else {
                if (i_renamed != 3) {
                    return;
                }
                com.oplus.camera.ui.beauty3d.d_renamed.this.b_renamed(3);
            }
        }
    };

    @Override // com.oplus.camera.ui.OplusNumSeekBar.a_renamed
    public boolean a_renamed() {
        return true;
    }

    public d_renamed(android.app.Activity activity, com.oplus.camera.ui.beauty3d.i_renamed iVar, android.widget.RelativeLayout relativeLayout) {
        this.f5905a = null;
        this.f5906b = null;
        this.f5907c = null;
        this.d_renamed = null;
        this.e_renamed = null;
        this.f_renamed = null;
        this.H_renamed = null;
        this.J_renamed = null;
        this.K_renamed = null;
        this.f_renamed = activity;
        this.H_renamed = iVar;
        this.J_renamed = relativeLayout;
        this.K_renamed = new android.view.GestureDetector(this.f_renamed, new com.oplus.camera.ui.beauty3d.d_renamed.a_renamed());
        this.f5905a = new android.graphics.Point(400, 400);
        this.e_renamed = new android.graphics.Point(400, 1000);
        this.f5906b = new android.graphics.Point(400, 700);
        this.d_renamed = new android.graphics.Point(400, 1000);
        this.f5907c = new android.graphics.Point(400, 400);
        com.oplus.camera.d_renamed.c_renamed.a_renamed().a_renamed(this.f_renamed);
    }

    private void s_renamed() {
        if (this.I_renamed == null) {
            this.I_renamed = this.f_renamed.getLayoutInflater().inflate(com.oplus.camera.R_renamed.layout.beauty3d_bottom, (android.view.ViewGroup) null);
        }
        if (this.g_renamed == null) {
            this.g_renamed = (android.view.ViewGroup) this.f_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.camera);
        }
        this.I_renamed.setBackgroundColor(-16777216);
        this.I_renamed.setVisibility(8);
        this.I_renamed.setEnabled(false);
        this.I_renamed.setOnTouchListener(this.aA_renamed);
        int dimension = (int) this.f_renamed.getResources().getDimension(com.oplus.camera.R_renamed.dimen.beauty3d_edit_bottom_height);
        if (this.j_renamed) {
            return;
        }
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, dimension);
        layoutParams.addRule(12);
        this.g_renamed.addView(this.I_renamed, layoutParams);
        this.j_renamed = true;
        w_renamed();
    }

    private void t_renamed() {
        if (this.P_renamed == null) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) this.f_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.camera);
            this.P_renamed = this.f_renamed.getLayoutInflater().inflate(com.oplus.camera.R_renamed.layout.beauty3d_edit_setting, (android.view.ViewGroup) null);
            if (this.ai_renamed) {
                return;
            }
            android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(10);
            layoutParams.height = (int) this.f_renamed.getResources().getDimension(com.oplus.camera.R_renamed.dimen.beauty3d_scan_setting_height);
            layoutParams.topMargin = 0;
            this.P_renamed.setLayoutParams(layoutParams);
            viewGroup.addView(this.P_renamed, layoutParams);
            this.ai_renamed = true;
        }
    }

    public void b_renamed() {
        android.view.View view = this.I_renamed;
        if (view != null) {
            view.setVisibility(8);
            this.I_renamed.setEnabled(false);
        }
    }

    public void c_renamed() {
        android.view.View view = this.I_renamed;
        if (view != null) {
            view.setVisibility(0);
            this.I_renamed.setEnabled(true);
            this.I_renamed.setOnTouchListener(this.aA_renamed);
            x_renamed();
        }
    }

    public void d_renamed() {
        t_renamed();
        this.P_renamed.setOnTouchListener(this.aA_renamed);
        this.v_renamed = (android.widget.RelativeLayout) this.P_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.beauty3d_edit_setting);
        this.u_renamed = (android.widget.RelativeLayout) this.P_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.beauty3d_custom_setting);
        this.k_renamed = (android.widget.TextView) this.P_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.beauty3d_title);
        this.l_renamed = (android.widget.TextView) this.P_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.custom_title);
        this.k_renamed.setText(this.f_renamed.getString(com.oplus.camera.R_renamed.string.beauty3d_face_edit_title));
        this.q_renamed = (android.widget.TextView) this.P_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.custom_rescan);
        this.q_renamed.setOnClickListener(this);
        this.u_renamed.setVisibility(4);
        this.v_renamed.setVisibility(4);
    }

    private void u_renamed() {
        android.widget.RelativeLayout relativeLayout = this.u_renamed;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        android.widget.RelativeLayout relativeLayout2 = this.v_renamed;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(0);
        }
        android.widget.TextView textView = this.k_renamed;
        if (textView != null) {
            textView.setText(this.f_renamed.getString(com.oplus.camera.R_renamed.string.beauty3d_face_edit_title));
            this.k_renamed.setVisibility(0);
        }
    }

    private void v_renamed() {
        android.widget.RelativeLayout relativeLayout = this.u_renamed;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
            this.u_renamed.setEnabled(true);
        }
        android.widget.TextView textView = this.l_renamed;
        if (textView != null) {
            textView.setVisibility(0);
        }
        android.widget.TextView textView2 = this.k_renamed;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        android.widget.TextView textView3 = this.q_renamed;
        if (textView3 != null) {
            textView3.setVisibility(0);
            this.q_renamed.setClickable(true);
            this.q_renamed.setOnClickListener(this);
        }
    }

    public void e_renamed() {
        android.view.View view = this.P_renamed;
        if (view != null) {
            view.setVisibility(4);
            this.P_renamed.setEnabled(false);
        }
    }

    public void f_renamed() {
        android.view.View view = this.P_renamed;
        if (view != null) {
            view.setOnTouchListener(this.aA_renamed);
            this.P_renamed.setVisibility(0);
            this.P_renamed.setEnabled(true);
        }
    }

    private void w_renamed() {
        this.I_renamed.setClickable(true);
        this.m_renamed = (android.widget.TextView) this.I_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.face3d_cancel);
        this.n_renamed = (android.widget.TextView) this.I_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.face3d_customize_cancel);
        this.o_renamed = (android.widget.TextView) this.I_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.face3d_save);
        this.p_renamed = (android.widget.TextView) this.I_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.face3d_customize);
        this.r_renamed = (android.widget.ImageView) this.I_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.redo_left);
        this.s_renamed = (android.widget.ImageView) this.I_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.redo_right);
        this.G_renamed = (android.widget.LinearLayout) this.I_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.down_seekbar_container);
        this.F_renamed = (android.widget.LinearLayout) this.I_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.up_seekbar_container);
        this.w_renamed = (com.oplus.camera.ui.OplusNumSeekBar) this.I_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.up_seekbar);
        this.x_renamed = (com.oplus.camera.ui.OplusNumSeekBar) this.I_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.down_seekbar);
        this.ab_renamed = (android.widget.ImageView) this.I_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.up_seekbar_view);
        this.ac_renamed = (android.widget.ImageView) this.I_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.down_seekbar_view);
        this.x_renamed.setEnabled(true);
        this.w_renamed.setEnabled(true);
        this.G_renamed.setVisibility(8);
        this.F_renamed.setVisibility(8);
        this.r_renamed.setVisibility(4);
        this.s_renamed.setVisibility(4);
        this.r_renamed.setOnClickListener(this);
        this.s_renamed.setOnClickListener(this);
        this.m_renamed.setOnClickListener(this);
        this.p_renamed.setOnClickListener(this);
        this.o_renamed.setOnClickListener(this);
        this.n_renamed.setOnClickListener(this);
        this.x_renamed.setOnProgressChangedListener(this);
        this.w_renamed.setOnProgressChangedListener(this);
        this.t_renamed = (androidx.recyclerview.widget.RecyclerView) this.I_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.beauty3d_recyclerview);
        B_renamed();
    }

    public void g_renamed() {
        int i_renamed = this.h_renamed;
        if (i_renamed == 1) {
            this.ab_renamed.setImageDrawable(this.D_renamed.f_renamed);
            this.ac_renamed.setImageDrawable(this.C_renamed.f_renamed);
            return;
        }
        if (i_renamed == 2) {
            this.ac_renamed.setImageDrawable(this.B_renamed.f_renamed);
            return;
        }
        if (i_renamed == 3) {
            this.ac_renamed.setImageDrawable(this.z_renamed.f_renamed);
            this.ab_renamed.setImageDrawable(this.y_renamed.f_renamed);
        } else if (i_renamed == 4) {
            this.ac_renamed.setImageDrawable(this.E_renamed.f_renamed);
        } else {
            if (i_renamed != 5) {
                return;
            }
            this.ac_renamed.setImageDrawable(this.A_renamed.f_renamed);
        }
    }

    public void a_renamed(int[] iArr) {
        if (this.ax_renamed != null || iArr == null || iArr.length < 28) {
            return;
        }
        this.ax_renamed = new android.util.SparseArray<>();
        for (int i_renamed = 0; i_renamed < 4; i_renamed++) {
            int i2 = i_renamed * 7;
            this.ax_renamed.put(i_renamed, java.util.Arrays.copyOfRange(iArr, i2, i2 + 7));
        }
    }

    public int a_renamed(int i_renamed) {
        int[] iArr;
        android.util.SparseArray<int[]> sparseArray = this.ax_renamed;
        if (sparseArray == null || (iArr = sparseArray.get(this.am_renamed)) == null || iArr.length <= i_renamed) {
            return 0;
        }
        return iArr[i_renamed];
    }

    private void d_renamed(int[] iArr) {
        if (iArr == null || iArr.length != 7) {
            return;
        }
        com.oplus.camera.ui.beauty3d.a_renamed aVar = this.C_renamed;
        if (aVar != null) {
            aVar.a_renamed(a_renamed(0));
            this.C_renamed.f5897a = iArr[0];
        }
        com.oplus.camera.ui.beauty3d.a_renamed aVar2 = this.D_renamed;
        if (aVar2 != null) {
            aVar2.a_renamed(a_renamed(1));
            this.D_renamed.f5897a = iArr[1];
        }
        com.oplus.camera.ui.beauty3d.a_renamed aVar3 = this.B_renamed;
        if (aVar3 != null) {
            aVar3.a_renamed(a_renamed(2));
            this.B_renamed.f5897a = iArr[2];
        }
        com.oplus.camera.ui.beauty3d.a_renamed aVar4 = this.z_renamed;
        if (aVar4 != null) {
            aVar4.a_renamed(a_renamed(3));
            this.z_renamed.f5897a = iArr[3];
        }
        com.oplus.camera.ui.beauty3d.a_renamed aVar5 = this.y_renamed;
        if (aVar5 != null) {
            aVar5.a_renamed(a_renamed(4));
            this.y_renamed.f5897a = iArr[4];
        }
        com.oplus.camera.ui.beauty3d.a_renamed aVar6 = this.E_renamed;
        if (aVar6 != null) {
            aVar6.a_renamed(a_renamed(5));
            this.E_renamed.f5897a = iArr[5];
        }
        com.oplus.camera.ui.beauty3d.a_renamed aVar7 = this.A_renamed;
        if (aVar7 != null) {
            aVar7.a_renamed(a_renamed(6));
            this.A_renamed.f5897a = iArr[6];
        }
    }

    public void b_renamed(int i_renamed) {
        this.aq_renamed = true;
        this.h_renamed = 0;
        this.am_renamed = i_renamed;
        int[] iArr = this.aw_renamed.get(this.am_renamed);
        if (iArr == null) {
            return;
        }
        d_renamed(iArr);
        if (this.H_renamed != null) {
            M_renamed();
        }
        d_renamed(false);
        e_renamed(false);
        com.oplus.camera.ui.beauty3d.c_renamed cVar = this.aj_renamed;
        if (cVar != null) {
            cVar.f_renamed();
        }
    }

    public void h_renamed() {
        if (this.M_renamed != null) {
            com.oplus.camera.e_renamed.a_renamed("Beauty3DEditUI", "onUpdateStyleViewPosition, mChoseStyle: " + this.am_renamed);
            java.util.List list = this.M_renamed.d_renamed;
            for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
                if (i_renamed == this.am_renamed) {
                    list.set(i_renamed, true);
                } else {
                    list.set(i_renamed, false);
                }
            }
            this.M_renamed.notifyDataSetChanged();
        }
    }

    public void a_renamed(int i_renamed, int i2) {
        com.oplus.camera.e_renamed.a_renamed("Beauty3DEditUI", "setSeekBarProgress: progress: " + i2 + ", mTouchLcation: " + this.h_renamed);
        int i3 = this.h_renamed;
        if (i3 == 1) {
            if (this.C_renamed.d_renamed == i_renamed) {
                this.C_renamed.b_renamed(i2);
                return;
            } else {
                if (this.D_renamed.d_renamed == i_renamed) {
                    this.D_renamed.b_renamed(i2);
                    return;
                }
                return;
            }
        }
        if (i3 == 2) {
            this.B_renamed.b_renamed(i2);
            return;
        }
        if (i3 != 3) {
            if (i3 == 4) {
                this.E_renamed.b_renamed(i2);
                return;
            } else {
                if (i3 != 5) {
                    return;
                }
                this.A_renamed.b_renamed(i2);
                return;
            }
        }
        if (this.y_renamed.d_renamed == i_renamed) {
            this.y_renamed.b_renamed(i2);
        } else if (this.z_renamed.d_renamed == i_renamed) {
            this.z_renamed.b_renamed(i2);
        }
    }

    public void i_renamed() {
        c_renamed();
        f_renamed();
        android.widget.RelativeLayout relativeLayout = this.J_renamed;
        if (relativeLayout != null) {
            relativeLayout.setOnTouchListener(this.aA_renamed);
        }
    }

    public void b_renamed(int i_renamed, int i2) {
        k_renamed();
        this.am_renamed = i2;
        if (i_renamed == 2) {
            J_renamed();
        }
    }

    public void j_renamed() {
        d_renamed();
        s_renamed();
        z_renamed();
        if (this.y_renamed == null) {
            this.y_renamed = new com.oplus.camera.ui.beauty3d.a_renamed(0, 100, this.f_renamed.getDrawable(com.oplus.camera.R_renamed.drawable.beauty3d_small_face), com.oplus.camera.R_renamed.id_renamed.up_seekbar);
        }
        if (this.z_renamed == null) {
            this.z_renamed = new com.oplus.camera.ui.beauty3d.a_renamed(0, 100, this.f_renamed.getDrawable(com.oplus.camera.R_renamed.drawable.beauty3d_fix_face), com.oplus.camera.R_renamed.id_renamed.down_seekbar);
        }
        if (this.A_renamed == null) {
            this.A_renamed = new com.oplus.camera.ui.beauty3d.a_renamed(-50, 50, this.f_renamed.getDrawable(com.oplus.camera.R_renamed.drawable.beauty3d_chin), com.oplus.camera.R_renamed.id_renamed.down_seekbar);
        }
        if (this.B_renamed == null) {
            this.B_renamed = new com.oplus.camera.ui.beauty3d.a_renamed(0, 100, this.f_renamed.getDrawable(com.oplus.camera.R_renamed.drawable.beauty3d_big_eye), com.oplus.camera.R_renamed.id_renamed.down_seekbar);
        }
        if (this.E_renamed == null) {
            this.E_renamed = new com.oplus.camera.ui.beauty3d.a_renamed(0, 100, this.f_renamed.getDrawable(com.oplus.camera.R_renamed.drawable.beauty3d_cheekbone), com.oplus.camera.R_renamed.id_renamed.down_seekbar);
        }
        if (this.D_renamed == null) {
            this.D_renamed = new com.oplus.camera.ui.beauty3d.a_renamed(0, 100, this.f_renamed.getDrawable(com.oplus.camera.R_renamed.drawable.beauty3d_small_nose), com.oplus.camera.R_renamed.id_renamed.up_seekbar);
        }
        if (this.C_renamed == null) {
            this.C_renamed = new com.oplus.camera.ui.beauty3d.a_renamed(0, 100, this.f_renamed.getDrawable(com.oplus.camera.R_renamed.drawable.beauty3d_high_nose), com.oplus.camera.R_renamed.id_renamed.down_seekbar);
        }
    }

    public void k_renamed() {
        x_renamed();
        u_renamed();
        android.widget.TextView textView = this.m_renamed;
        if (textView != null) {
            textView.setVisibility(0);
            this.m_renamed.setClickable(true);
        }
        android.widget.TextView textView2 = this.n_renamed;
        if (textView2 != null) {
            textView2.setVisibility(8);
            this.n_renamed.setClickable(false);
        }
        android.widget.TextView textView3 = this.o_renamed;
        if (textView3 != null) {
            textView3.setVisibility(8);
            this.o_renamed.setClickable(false);
        }
        android.widget.TextView textView4 = this.p_renamed;
        if (textView4 != null) {
            textView4.setVisibility(0);
            this.p_renamed.setClickable(true);
        }
        K_renamed();
        H_renamed();
        android.widget.ImageView imageView = this.r_renamed;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
        android.widget.ImageView imageView2 = this.s_renamed;
        if (imageView2 != null) {
            imageView2.setVisibility(4);
        }
        this.i_renamed = 1;
    }

    private void x_renamed() {
        int iZ;
        android.view.View view = this.I_renamed;
        if (view == null) {
            return;
        }
        int i_renamed = 0;
        view.setVisibility(0);
        this.I_renamed.setEnabled(true);
        int dimension = (int) this.f_renamed.getResources().getDimension(com.oplus.camera.R_renamed.dimen.beauty3d_edit_custom_bottom_height);
        int dimension2 = (int) this.f_renamed.getResources().getDimension(com.oplus.camera.R_renamed.dimen.beauty3d_redo_margin_bottom);
        android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) this.I_renamed.getLayoutParams();
        if (com.oplus.camera.util.Util.aa_renamed() && (iZ = com.oplus.camera.util.Util.Z_renamed() - dimension2) > 0) {
            i_renamed = iZ;
        }
        layoutParams.bottomMargin = i_renamed;
        layoutParams.height = dimension;
        com.oplus.camera.e_renamed.a_renamed("Beauty3DEditUI", "refreshBottomLayout, bottomMargin: " + i_renamed + ", height: " + dimension);
        this.I_renamed.setLayoutParams(layoutParams);
        this.I_renamed.requestLayout();
    }

    private void y_renamed() {
        android.view.View view = this.Q_renamed;
        if (view == null || view.getVisibility() == 0) {
            return;
        }
        this.Q_renamed.setVisibility(0);
    }

    private void z_renamed() {
        android.widget.RelativeLayout relativeLayout;
        com.oplus.camera.e_renamed.a_renamed("Beauty3DEditUI", "initPreview");
        android.widget.RelativeLayout relativeLayout2 = this.J_renamed;
        if (relativeLayout2 != null) {
            relativeLayout2.setOnTouchListener(this.aA_renamed);
        }
        A_renamed();
        if (this.O_renamed || (relativeLayout = this.J_renamed) == null) {
            return;
        }
        relativeLayout.addView(this.Q_renamed, -1, -1);
        android.view.View viewFindViewById = this.Q_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.cheekbone_ffd);
        if (viewFindViewById != null) {
            viewFindViewById.measure(0, 0);
            this.ay_renamed = viewFindViewById.getMeasuredWidth() / 2;
        }
        b_renamed(false);
        a_renamed(this.R_renamed, this.f5905a, false);
        a_renamed(this.S_renamed, this.f5906b, false);
        a_renamed(this.T_renamed, this.d_renamed, false);
        a_renamed(this.U_renamed, this.f5907c, true);
        a_renamed(this.V_renamed, this.e_renamed, true);
        this.O_renamed = true;
    }

    private void a_renamed(android.view.View view, android.graphics.Point point, boolean z_renamed) {
        if (view == null || point == null) {
            com.oplus.camera.e_renamed.f_renamed("Beauty3DEditUI", "updateFiveSenseViewLayout, view or point null");
            return;
        }
        android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams != null) {
            if (z_renamed) {
                layoutParams.width = point.x_renamed + this.ay_renamed;
                layoutParams.topMargin = point.y_renamed - (view.getMeasuredHeight() / 2);
                view.setLayoutParams(layoutParams);
                view.requestLayout();
                return;
            }
            layoutParams.width = (1080 - point.x_renamed) + this.ay_renamed;
            layoutParams.topMargin = point.y_renamed - (view.getMeasuredHeight() / 2);
            view.setLayoutParams(layoutParams);
            view.requestLayout();
        }
    }

    private void A_renamed() {
        if (this.Q_renamed == null) {
            this.Q_renamed = this.f_renamed.getLayoutInflater().inflate(com.oplus.camera.R_renamed.layout.beauty3d_fivesence_hint, (android.view.ViewGroup) null);
            this.Q_renamed.setOnTouchListener(new android.view.View.OnTouchListener() { // from class: com.oplus.camera.ui.beauty3d.d_renamed.3
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                    return false;
                }
            });
        }
        this.R_renamed = this.Q_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.eye_hint);
        this.S_renamed = this.Q_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.nose_hint);
        this.T_renamed = this.Q_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.chin_hint);
        this.U_renamed = this.Q_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.face_hint);
        this.V_renamed = this.Q_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.cheekbone_hint);
        this.R_renamed.measure(0, 0);
        this.S_renamed.measure(0, 0);
        this.T_renamed.measure(0, 0);
        this.U_renamed.measure(0, 0);
        this.V_renamed.measure(0, 0);
        this.W_renamed = (com.oplus.camera.ui.menu.OplusTextView) this.Q_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.eye_hint_title);
        this.X_renamed = (com.oplus.camera.ui.menu.OplusTextView) this.Q_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.nose_hint_title);
        this.Y_renamed = (com.oplus.camera.ui.menu.OplusTextView) this.Q_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.chin_hint_title);
        this.Z_renamed = (com.oplus.camera.ui.menu.OplusTextView) this.Q_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.face_hint_title);
        this.aa_renamed = (com.oplus.camera.ui.menu.OplusTextView) this.Q_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.cheekbone_hint_title);
        this.ad_renamed = this.f_renamed.getString(com.oplus.camera.R_renamed.string.beauty3d_eye);
        this.ae_renamed = this.f_renamed.getString(com.oplus.camera.R_renamed.string.beauty3d_nose);
        this.af_renamed = this.f_renamed.getString(com.oplus.camera.R_renamed.string.beauty3d_chin);
        this.ag_renamed = this.f_renamed.getString(com.oplus.camera.R_renamed.string.beauty3d_face_size);
        this.ah_renamed = this.f_renamed.getString(com.oplus.camera.R_renamed.string.beauty3d_cheekbones);
        this.W_renamed.setText(this.ad_renamed);
        this.X_renamed.setText(this.ae_renamed);
        this.Y_renamed.setText(this.af_renamed);
        this.Z_renamed.setText(this.ag_renamed);
        this.aa_renamed.setText(this.ah_renamed);
    }

    public void a_renamed(java.lang.String[] strArr) {
        if (strArr == null || strArr.length != 5) {
            return;
        }
        com.oplus.camera.ui.menu.OplusTextView oplusTextView = this.aa_renamed;
        if (oplusTextView != null && strArr[0] != null && !strArr[0].equals(oplusTextView.getText())) {
            this.aa_renamed.setText(strArr[0]);
            com.oplus.camera.e_renamed.a_renamed("Beauty3DEditUI", "setFiveSenseTitles, update CheekBone");
        }
        com.oplus.camera.ui.menu.OplusTextView oplusTextView2 = this.Z_renamed;
        if (oplusTextView2 != null && strArr[1] != null && !strArr[1].equals(oplusTextView2.getText())) {
            this.Z_renamed.setText(strArr[1]);
            com.oplus.camera.e_renamed.a_renamed("Beauty3DEditUI", "setFiveSenseTitles, update Face");
        }
        com.oplus.camera.ui.menu.OplusTextView oplusTextView3 = this.Y_renamed;
        if (oplusTextView3 != null && strArr[2] != null && !strArr[2].equals(oplusTextView3.getText())) {
            this.Y_renamed.setText(strArr[2]);
            com.oplus.camera.e_renamed.a_renamed("Beauty3DEditUI", "setFiveSenseTitles, update Chin");
        }
        com.oplus.camera.ui.menu.OplusTextView oplusTextView4 = this.X_renamed;
        if (oplusTextView4 != null && strArr[3] != null && !strArr[3].equals(oplusTextView4.getText())) {
            this.X_renamed.setText(strArr[3]);
            com.oplus.camera.e_renamed.a_renamed("Beauty3DEditUI", "setFiveSenseTitles, update Nose");
        }
        com.oplus.camera.ui.menu.OplusTextView oplusTextView5 = this.W_renamed;
        if (oplusTextView5 == null || strArr[4] == null || strArr[4].equals(oplusTextView5.getText())) {
            return;
        }
        this.W_renamed.setText(strArr[4]);
        com.oplus.camera.e_renamed.a_renamed("Beauty3DEditUI", "setFiveSenseTitles, update Eye");
    }

    public void b_renamed(int[] iArr) {
        boolean z_renamed;
        if (iArr != null && iArr.length >= 10 && this.ar_renamed) {
            int i_renamed = 1440 - iArr[0];
            int i2 = 1080 - iArr[1];
            if (this.e_renamed.y_renamed == i_renamed && this.e_renamed.x_renamed == i2) {
                z_renamed = false;
            } else {
                android.graphics.Point point = this.e_renamed;
                point.y_renamed = i_renamed;
                point.x_renamed = i2;
                z_renamed = true;
            }
            int i3 = 1440 - iArr[2];
            int i4 = 1080 - iArr[3];
            if (this.f5907c.y_renamed != i3 || this.f5907c.x_renamed != i4) {
                android.graphics.Point point2 = this.f5907c;
                point2.y_renamed = i3;
                point2.x_renamed = i4;
                z_renamed = true;
            }
            int i5 = 1440 - iArr[4];
            int i6 = 1080 - iArr[5];
            if (this.d_renamed.y_renamed != i5 || this.d_renamed.x_renamed != i6) {
                android.graphics.Point point3 = this.d_renamed;
                point3.y_renamed = i5;
                point3.x_renamed = i6;
                z_renamed = true;
            }
            int i7 = 1440 - iArr[6];
            int i8 = 1080 - iArr[7];
            if (this.f5906b.y_renamed != i7 || this.f5906b.x_renamed != i8) {
                android.graphics.Point point4 = this.f5906b;
                point4.y_renamed = i7;
                point4.x_renamed = i8;
                z_renamed = true;
            }
            int i9 = 1440 - iArr[8];
            int i10 = 1080 - iArr[9];
            if (this.f5905a.y_renamed != i9 || this.f5905a.x_renamed != i10) {
                android.graphics.Point point5 = this.f5905a;
                point5.y_renamed = i9;
                point5.x_renamed = i10;
                z_renamed = true;
            }
            if (z_renamed) {
                com.oplus.camera.e_renamed.a_renamed("Beauty3DEditUI", "setFiveSenseViewParams, result: " + iArr[0] + ", " + iArr[1] + ", " + iArr[2] + ", " + iArr[3] + ", " + iArr[4] + ", " + iArr[5] + ", " + iArr[6] + ", " + iArr[7] + ", " + iArr[8] + ", " + iArr[9]);
                b_renamed(false);
                a_renamed(this.R_renamed, this.f5905a, false);
                a_renamed(this.S_renamed, this.f5906b, false);
                a_renamed(this.T_renamed, this.d_renamed, false);
                a_renamed(this.U_renamed, this.f5907c, true);
                a_renamed(this.V_renamed, this.e_renamed, true);
            }
            y_renamed();
        }
    }

    private void B_renamed() {
        this.L_renamed = new com.oplus.camera.ui.beauty3d.d_renamed.e_renamed(this.f_renamed);
        this.L_renamed.setOrientation(0);
        this.t_renamed.setLayoutManager(this.L_renamed);
        if (this.N_renamed == null) {
            this.N_renamed = new java.util.ArrayList(4);
            this.N_renamed.add(new com.oplus.camera.ui.beauty3d.d_renamed.c_renamed(this.f_renamed.getDrawable(com.oplus.camera.R_renamed.drawable.beauty3d_style_natural), this.f_renamed.getResources().getString(com.oplus.camera.R_renamed.string.beauty3d_face_style_natural)));
            this.N_renamed.add(new com.oplus.camera.ui.beauty3d.d_renamed.c_renamed(this.f_renamed.getDrawable(com.oplus.camera.R_renamed.drawable.beauty3d_style_goose_egg), this.f_renamed.getResources().getString(com.oplus.camera.R_renamed.string.beauty3d_face_style_delicate)));
            this.N_renamed.add(new com.oplus.camera.ui.beauty3d.d_renamed.c_renamed(this.f_renamed.getDrawable(com.oplus.camera.R_renamed.drawable.beauty3d_style_lolita), this.f_renamed.getResources().getString(com.oplus.camera.R_renamed.string.beauty3d_face_style_lolita)));
            this.N_renamed.add(new com.oplus.camera.ui.beauty3d.d_renamed.c_renamed(this.f_renamed.getDrawable(com.oplus.camera.R_renamed.drawable.beauty3d_style_mode), this.f_renamed.getResources().getString(com.oplus.camera.R_renamed.string.beauty3d_face_style_mode)));
        }
        this.M_renamed = new com.oplus.camera.ui.beauty3d.d_renamed.b_renamed(this.N_renamed, this.aB_renamed);
        this.t_renamed.setAdapter(this.M_renamed);
        this.t_renamed.addItemDecoration(new com.oplus.camera.ui.beauty3d.d_renamed.f_renamed((int) this.f_renamed.getResources().getDimension(com.oplus.camera.R_renamed.dimen.beauty3d_edit_recyclerview_item_space)));
        K_renamed();
    }

    public void a_renamed(boolean z_renamed) {
        if (z_renamed) {
            D_renamed();
            this.i_renamed = 0;
            this.h_renamed = 0;
            this.al_renamed = 0;
            this.aq_renamed = false;
            this.ao_renamed = false;
            com.oplus.camera.ui.beauty3d.c_renamed cVar = this.aj_renamed;
            if (cVar != null) {
                cVar.f_renamed();
            }
        } else {
            e_renamed();
            b_renamed();
            b_renamed(false);
        }
        r_renamed();
        this.J_renamed.setOnTouchListener(new android.view.View.OnTouchListener() { // from class: com.oplus.camera.ui.beauty3d.d_renamed.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                return false;
            }
        });
    }

    public void b_renamed(boolean z_renamed) {
        android.view.View view = this.Q_renamed;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        if (z_renamed) {
            com.oplus.camera.util.Util.b_renamed(this.Q_renamed);
        } else {
            this.Q_renamed.setVisibility(8);
        }
    }

    private void C_renamed() {
        android.view.View view = this.Q_renamed;
        if (view != null && this.O_renamed && this.J_renamed != null) {
            android.view.animation.Animation animation = view.getAnimation();
            if (animation != null) {
                animation.cancel();
            }
            this.Q_renamed.setVisibility(8);
            this.J_renamed.removeView(this.Q_renamed);
            this.Q_renamed.setAlpha(1.0f);
        }
        this.O_renamed = false;
    }

    public void l_renamed() {
        D_renamed();
        this.i_renamed = 0;
        this.ao_renamed = false;
        this.aq_renamed = false;
        this.f_renamed = null;
        this.g_renamed = null;
        this.I_renamed = null;
        this.P_renamed = null;
        this.k_renamed = null;
        this.l_renamed = null;
        this.m_renamed = null;
        this.n_renamed = null;
        this.o_renamed = null;
        this.p_renamed = null;
        this.q_renamed = null;
        this.r_renamed = null;
        this.s_renamed = null;
        this.t_renamed = null;
        this.u_renamed = null;
        this.v_renamed = null;
        this.J_renamed = null;
        this.w_renamed = null;
        this.x_renamed = null;
        this.F_renamed = null;
        this.G_renamed = null;
        this.R_renamed = null;
        this.S_renamed = null;
        this.T_renamed = null;
        this.U_renamed = null;
        this.V_renamed = null;
        this.W_renamed = null;
        this.X_renamed = null;
        this.Y_renamed = null;
        this.Z_renamed = null;
        this.aa_renamed = null;
    }

    private void D_renamed() {
        android.view.View view;
        android.view.View view2;
        C_renamed();
        android.view.ViewGroup viewGroup = this.g_renamed;
        if (viewGroup != null && (view2 = this.I_renamed) != null && this.j_renamed) {
            viewGroup.removeView(view2);
            this.j_renamed = false;
            this.I_renamed = null;
        }
        android.view.ViewGroup viewGroup2 = this.g_renamed;
        if (viewGroup2 == null || (view = this.P_renamed) == null || !this.ai_renamed) {
            return;
        }
        viewGroup2.removeView(view);
        this.ai_renamed = false;
        this.P_renamed = null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        int id_renamed = view.getId();
        if (id_renamed != com.oplus.camera.R_renamed.id_renamed.custom_rescan) {
            switch (id_renamed) {
                case com.oplus.camera.R_renamed.id_renamed.face3d_cancel /* 2131296608 */:
                    a_renamed(true);
                    com.oplus.camera.ui.beauty3d.i_renamed iVar = this.H_renamed;
                    if (iVar != null) {
                        iVar.a_renamed();
                        break;
                    }
                    break;
                case com.oplus.camera.R_renamed.id_renamed.face3d_customize /* 2131296609 */:
                    com.oplus.camera.ui.beauty3d.i_renamed iVar2 = this.H_renamed;
                    if (iVar2 != null) {
                        iVar2.a_renamed("com.oplus.beauty3d.mode", new int[]{3});
                    }
                    J_renamed();
                    break;
                case com.oplus.camera.R_renamed.id_renamed.face3d_customize_cancel /* 2131296610 */:
                    I_renamed();
                    break;
                case com.oplus.camera.R_renamed.id_renamed.face3d_save /* 2131296611 */:
                    a_renamed(true);
                    com.oplus.camera.ui.beauty3d.i_renamed iVar3 = this.H_renamed;
                    if (iVar3 != null) {
                        iVar3.a_renamed("com.oplus.beauty3d.custom.mode", this.as_renamed);
                        this.H_renamed.b_renamed();
                    }
                    E_renamed();
                    break;
                default:
                    switch (id_renamed) {
                        case com.oplus.camera.R_renamed.id_renamed.redo_left /* 2131297003 */:
                            m_renamed();
                            break;
                        case com.oplus.camera.R_renamed.id_renamed.redo_right /* 2131297004 */:
                            n_renamed();
                            break;
                    }
            }
        }
        a_renamed(true);
        com.oplus.camera.ui.beauty3d.i_renamed iVar4 = this.H_renamed;
        if (iVar4 != null) {
            iVar4.a_renamed();
        }
    }

    private void E_renamed() {
        boolean z_renamed;
        int[] iArr = this.av_renamed;
        if (iArr == null || iArr.length < 8) {
            return;
        }
        int i_renamed = this.az_renamed;
        int i2 = this.am_renamed;
        if (i_renamed != i2) {
            z_renamed = true;
            break;
        }
        int[] iArr2 = this.aw_renamed.get(i2);
        if (iArr2 != null) {
            int i3 = 0;
            while (i3 < iArr2.length) {
                int i4 = iArr2[i3];
                i3++;
                if (i4 != this.av_renamed[i3]) {
                    z_renamed = true;
                    break;
                }
            }
        }
        z_renamed = false;
        if (z_renamed) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            int i5 = this.av_renamed[0];
            java.lang.String str = null;
            if (i5 == 0) {
                str = com.oplus.camera.statistics.CameraStatisticsUtil.BEAUTY3D_NATURAL;
            } else if (i5 == 1) {
                str = com.oplus.camera.statistics.CameraStatisticsUtil.BEAUTY3D_GOOSE;
            } else if (i5 == 2) {
                str = com.oplus.camera.statistics.CameraStatisticsUtil.BEAUTY3D_LOLITA;
            } else if (i5 == 3) {
                str = com.oplus.camera.statistics.CameraStatisticsUtil.BEAUTY3D_MODE;
            }
            if (str != null) {
                sb.append(com.oplus.camera.statistics.CameraStatisticsUtil.format(com.oplus.camera.statistics.CameraStatisticsUtil.BEAUTY3D_CHOSE_STYLE, str));
            }
            sb.append(com.oplus.camera.statistics.CameraStatisticsUtil.format(com.oplus.camera.statistics.CameraStatisticsUtil.BEAUTY3D_HIGH_NOSE, java.lang.String.valueOf(this.av_renamed[1])));
            sb.append(com.oplus.camera.statistics.CameraStatisticsUtil.format(com.oplus.camera.statistics.CameraStatisticsUtil.BEAUTY3D_SMALL_NOSE, java.lang.String.valueOf(this.av_renamed[2])));
            sb.append(com.oplus.camera.statistics.CameraStatisticsUtil.format(com.oplus.camera.statistics.CameraStatisticsUtil.BEAUTY3D_EYE, java.lang.String.valueOf(this.av_renamed[3])));
            sb.append(com.oplus.camera.statistics.CameraStatisticsUtil.format(com.oplus.camera.statistics.CameraStatisticsUtil.BEAUTY3D_FIX_FACE, java.lang.String.valueOf(this.av_renamed[4])));
            sb.append(com.oplus.camera.statistics.CameraStatisticsUtil.format(com.oplus.camera.statistics.CameraStatisticsUtil.BEAUTY3D_SMALL_FACE, java.lang.String.valueOf(this.av_renamed[5])));
            sb.append(com.oplus.camera.statistics.CameraStatisticsUtil.format(com.oplus.camera.statistics.CameraStatisticsUtil.BEAUTY3D_CHEEKBONE, java.lang.String.valueOf(this.av_renamed[6])));
            sb.append(com.oplus.camera.statistics.CameraStatisticsUtil.format(com.oplus.camera.statistics.CameraStatisticsUtil.BEAUTY3D_CHIN, java.lang.String.valueOf(this.av_renamed[7])));
            if (sb.length() > 0) {
                com.oplus.camera.statistics.CameraStatisticsUtil.onCommon(this.f_renamed, com.oplus.camera.statistics.CameraStatisticsUtil.EVENT_MENU_CLICK, sb.toString());
            }
        }
    }

    public void m_renamed() {
        if (this.aj_renamed.c_renamed() < 2) {
            d_renamed(false);
            return;
        }
        this.ao_renamed = true;
        com.oplus.camera.ui.beauty3d.c_renamed cVar = this.aj_renamed;
        cVar.b_renamed(cVar.a_renamed());
        com.oplus.camera.ui.beauty3d.b_renamed bVarA = this.aj_renamed.a_renamed();
        this.aj_renamed.b_renamed(bVarA);
        com.oplus.camera.e_renamed.a_renamed("Beauty3DEditUI", "Beauty3DEditAction, mValueOwner: " + bVarA.f5901b + ", mValueLocation: " + bVarA.f5900a + ", mSbValue: " + bVarA.f5902c);
        this.h_renamed = bVarA.f5900a;
        a_renamed(bVarA.f5901b, bVarA.f5902c);
        M_renamed();
        G_renamed();
        if (this.aj_renamed.c_renamed() < 2) {
            d_renamed(false);
        } else {
            d_renamed(true);
        }
        if (this.aj_renamed.d_renamed() < 2) {
            e_renamed(false);
        } else {
            e_renamed(true);
        }
    }

    private void d_renamed(boolean z_renamed) {
        android.widget.ImageView imageView = this.r_renamed;
        if (imageView != null) {
            if (z_renamed) {
                imageView.setImageDrawable(this.f_renamed.getResources().getDrawable(com.oplus.camera.R_renamed.drawable.beauty3d_left_arrow));
                this.r_renamed.setClickable(true);
            } else {
                imageView.setImageDrawable(this.f_renamed.getResources().getDrawable(com.oplus.camera.R_renamed.drawable.beauty3d_left_arrow_grey));
                this.r_renamed.setClickable(false);
            }
        }
    }

    private void e_renamed(boolean z_renamed) {
        android.widget.ImageView imageView = this.s_renamed;
        if (imageView != null) {
            if (z_renamed) {
                imageView.setImageDrawable(this.f_renamed.getResources().getDrawable(com.oplus.camera.R_renamed.drawable.beauty3d_right_arrow));
                this.s_renamed.setClickable(true);
            } else {
                imageView.setImageDrawable(this.f_renamed.getResources().getDrawable(com.oplus.camera.R_renamed.drawable.beauty3d_right_arrow_grey));
                this.s_renamed.setClickable(false);
            }
        }
    }

    public void n_renamed() {
        if (this.aj_renamed.d_renamed() < 2) {
            e_renamed(false);
            return;
        }
        this.ao_renamed = true;
        com.oplus.camera.ui.beauty3d.c_renamed cVar = this.aj_renamed;
        cVar.a_renamed(cVar.b_renamed());
        com.oplus.camera.ui.beauty3d.b_renamed bVarB = this.aj_renamed.b_renamed();
        this.h_renamed = bVarB.f5900a;
        a_renamed(bVarB.f5901b, bVarB.f5902c);
        M_renamed();
        G_renamed();
        this.aj_renamed.a_renamed(bVarB);
        if (this.aj_renamed.c_renamed() < 2) {
            d_renamed(false);
        } else {
            d_renamed(true);
        }
        if (this.aj_renamed.d_renamed() < 2) {
            e_renamed(false);
        } else {
            e_renamed(true);
        }
    }

    private void F_renamed() {
        if (this.F_renamed.getVisibility() != 0) {
            this.F_renamed.setVisibility(0);
            this.F_renamed.setClickable(true);
        }
        if (this.G_renamed.getVisibility() != 0) {
            this.G_renamed.setVisibility(0);
            this.G_renamed.setClickable(true);
        }
    }

    private void c_renamed(int i_renamed, int i2) {
        if (this.F_renamed.getId() == i_renamed && this.F_renamed.getVisibility() != i2) {
            this.F_renamed.setVisibility(i2);
            if (i2 == 0) {
                this.F_renamed.setClickable(true);
                return;
            } else {
                this.F_renamed.setClickable(false);
                return;
            }
        }
        if (this.G_renamed.getId() != i_renamed || this.G_renamed.getVisibility() == i2) {
            return;
        }
        this.G_renamed.setVisibility(0);
        if (i2 == 0) {
            this.G_renamed.setClickable(true);
        } else {
            this.G_renamed.setClickable(false);
        }
    }

    private void G_renamed() {
        com.oplus.camera.e_renamed.a_renamed("Beauty3DEditUI", "showSeekBar");
        F_renamed();
        g_renamed();
        if (this.r_renamed.getVisibility() != 0) {
            this.r_renamed.setVisibility(0);
        }
        if (this.s_renamed.getVisibility() != 0) {
            this.s_renamed.setVisibility(0);
        }
        int i_renamed = this.h_renamed;
        if (i_renamed == 1) {
            c_renamed(com.oplus.camera.R_renamed.id_renamed.up_seekbar_container, 0);
            this.w_renamed.c_renamed(this.D_renamed.b_renamed()).d_renamed(this.D_renamed.a_renamed()).a_renamed(this.D_renamed.f5898b).b_renamed(this.D_renamed.f5899c).postInvalidate();
            this.x_renamed.c_renamed(this.C_renamed.b_renamed()).d_renamed(this.C_renamed.a_renamed()).a_renamed(this.C_renamed.f5898b).b_renamed(this.C_renamed.f5899c).postInvalidate();
            return;
        }
        if (i_renamed == 2) {
            c_renamed(com.oplus.camera.R_renamed.id_renamed.up_seekbar_container, 4);
            this.x_renamed.c_renamed(this.B_renamed.b_renamed()).d_renamed(this.B_renamed.a_renamed()).a_renamed(this.B_renamed.f5898b).b_renamed(this.B_renamed.f5899c).postInvalidate();
            return;
        }
        if (i_renamed == 3) {
            c_renamed(com.oplus.camera.R_renamed.id_renamed.up_seekbar_container, 0);
            this.w_renamed.c_renamed(this.y_renamed.b_renamed()).d_renamed(this.y_renamed.a_renamed()).a_renamed(this.y_renamed.f5898b).b_renamed(this.y_renamed.f5899c).postInvalidate();
            this.x_renamed.c_renamed(this.z_renamed.b_renamed()).d_renamed(this.z_renamed.a_renamed()).a_renamed(this.z_renamed.f5898b).b_renamed(this.z_renamed.f5899c).postInvalidate();
        } else if (i_renamed == 4) {
            c_renamed(com.oplus.camera.R_renamed.id_renamed.up_seekbar_container, 4);
            this.x_renamed.c_renamed(this.E_renamed.b_renamed()).d_renamed(this.E_renamed.a_renamed()).a_renamed(this.E_renamed.f5898b).b_renamed(this.E_renamed.f5899c).postInvalidate();
        } else {
            if (i_renamed != 5) {
                return;
            }
            c_renamed(com.oplus.camera.R_renamed.id_renamed.up_seekbar_container, 4);
            this.x_renamed.c_renamed(this.A_renamed.b_renamed()).d_renamed(this.A_renamed.a_renamed()).a_renamed(this.A_renamed.f5898b).b_renamed(this.A_renamed.f5899c).postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H_renamed() {
        com.oplus.camera.e_renamed.a_renamed("Beauty3DEditUI", "hideAllSeekBar");
        android.view.View view = this.I_renamed;
        if (view != null) {
            view.findViewById(com.oplus.camera.R_renamed.id_renamed.up_seekbar_container).setVisibility(8);
            this.I_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.up_seekbar_container).setEnabled(false);
            this.I_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.down_seekbar_container).setVisibility(8);
            this.I_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.down_seekbar_container).setEnabled(false);
        }
    }

    private void I_renamed() {
        new com.coui.appcompat.dialog.app.b_renamed.a_renamed(this.f_renamed, 2131821271).f_renamed(1).setNeutralButton(com.oplus.camera.R_renamed.string.beauty3d_give_up_customize_face, new android.content.DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.beauty3d.d_renamed.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i_renamed) {
                dialogInterface.dismiss();
                com.oplus.camera.ui.beauty3d.d_renamed.this.a_renamed(true);
                if (com.oplus.camera.ui.beauty3d.d_renamed.this.H_renamed != null) {
                    com.oplus.camera.ui.beauty3d.d_renamed.this.H_renamed.c_renamed();
                }
            }
        }).setNegativeButton(com.oplus.camera.R_renamed.string.beauty3d_cancel, new android.content.DialogInterface.OnClickListener() { // from class: com.oplus.camera.ui.beauty3d.d_renamed.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i_renamed) {
                dialogInterface.dismiss();
            }
        }).create().show();
    }

    private void J_renamed() {
        v_renamed();
        h_renamed();
        L_renamed();
        android.widget.TextView textView = this.p_renamed;
        if (textView != null) {
            textView.setVisibility(8);
            this.p_renamed.setClickable(false);
        }
        android.widget.TextView textView2 = this.m_renamed;
        if (textView2 != null) {
            textView2.setVisibility(8);
            this.m_renamed.setClickable(false);
        }
        android.widget.TextView textView3 = this.o_renamed;
        if (textView3 != null) {
            textView3.setVisibility(0);
            this.o_renamed.setClickable(true);
        }
        android.widget.TextView textView4 = this.n_renamed;
        if (textView4 != null) {
            textView4.setClickable(true);
            this.n_renamed.setVisibility(0);
        }
        a_renamed(this.f_renamed.getString(com.oplus.camera.R_renamed.string.beauty3d_customize_hint));
        com.oplus.camera.util.Util.ay_renamed().postDelayed(new java.lang.Runnable() { // from class: com.oplus.camera.ui.beauty3d.d_renamed.7
            @Override // java.lang.Runnable
            public void run() {
                com.oplus.camera.ui.beauty3d.d_renamed.this.r_renamed();
            }
        }, 3000L);
        this.i_renamed = 2;
    }

    private void K_renamed() {
        androidx.recyclerview.widget.RecyclerView recyclerView = this.t_renamed;
        if (recyclerView != null) {
            recyclerView.setClickable(false);
            this.t_renamed.setVisibility(8);
        }
    }

    private void L_renamed() {
        this.i_renamed = 2;
        androidx.recyclerview.widget.RecyclerView recyclerView = this.t_renamed;
        if (recyclerView != null) {
            recyclerView.setClickable(true);
            this.t_renamed.setVisibility(0);
        }
    }

    public int o_renamed() {
        return this.i_renamed;
    }

    public int[] p_renamed() {
        return this.av_renamed;
    }

    @Override // com.oplus.camera.ui.OplusNumSeekBar.a_renamed
    public void a_renamed(com.oplus.camera.ui.OplusNumSeekBar oplusNumSeekBar, int i_renamed, boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("Beauty3DEditUI", "onProgressChanged, progress: " + i_renamed);
        a_renamed(oplusNumSeekBar.getId(), i_renamed);
        M_renamed();
    }

    @Override // com.oplus.camera.ui.OplusNumSeekBar.a_renamed
    public void a_renamed(com.oplus.camera.ui.OplusNumSeekBar oplusNumSeekBar, int i_renamed) {
        this.ap_renamed = i_renamed;
        this.aj_renamed.a_renamed(new com.oplus.camera.ui.beauty3d.b_renamed(this.h_renamed, oplusNumSeekBar.getId(), i_renamed));
    }

    @Override // com.oplus.camera.ui.OplusNumSeekBar.a_renamed
    public void b_renamed(com.oplus.camera.ui.OplusNumSeekBar oplusNumSeekBar, int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("Beauty3DEditUI", "getProgressOnActionUp, progress: " + i_renamed + ", mDownProgress: " + this.ap_renamed);
        if (this.ap_renamed != i_renamed) {
            this.aj_renamed.a_renamed(new com.oplus.camera.ui.beauty3d.b_renamed(this.h_renamed, oplusNumSeekBar.getId(), i_renamed));
            this.aj_renamed.e_renamed();
            e_renamed(false);
            if (this.aj_renamed.c_renamed() < 2) {
                d_renamed(false);
            } else {
                d_renamed(true);
            }
            a_renamed(oplusNumSeekBar.getId(), i_renamed);
            return;
        }
        if (this.aj_renamed.c_renamed() > 1) {
            this.aj_renamed.a_renamed();
        }
    }

    private void M_renamed() {
        int[] iArr = this.av_renamed;
        iArr[0] = this.am_renamed;
        com.oplus.camera.ui.beauty3d.a_renamed aVar = this.C_renamed;
        if (aVar != null) {
            iArr[1] = aVar.f5897a;
        }
        com.oplus.camera.ui.beauty3d.a_renamed aVar2 = this.D_renamed;
        if (aVar2 != null) {
            this.av_renamed[2] = aVar2.f5897a;
        }
        com.oplus.camera.ui.beauty3d.a_renamed aVar3 = this.B_renamed;
        if (aVar3 != null) {
            this.av_renamed[3] = aVar3.f5897a;
        }
        com.oplus.camera.ui.beauty3d.a_renamed aVar4 = this.z_renamed;
        if (aVar4 != null) {
            this.av_renamed[4] = aVar4.f5897a;
        }
        com.oplus.camera.ui.beauty3d.a_renamed aVar5 = this.y_renamed;
        if (aVar5 != null) {
            this.av_renamed[5] = aVar5.f5897a;
        }
        com.oplus.camera.ui.beauty3d.a_renamed aVar6 = this.E_renamed;
        if (aVar6 != null) {
            this.av_renamed[6] = aVar6.f5897a;
        }
        com.oplus.camera.ui.beauty3d.a_renamed aVar7 = this.A_renamed;
        if (aVar7 != null) {
            this.av_renamed[7] = aVar7.f5897a;
        }
        com.oplus.camera.e_renamed.a_renamed("Beauty3DEditUI", "updateFiveSenseParams, updateFiveSenseParams: " + this.av_renamed[0] + ", " + this.av_renamed[1] + ", " + this.av_renamed[2] + ", " + this.av_renamed[3] + ", " + this.av_renamed[4] + ", " + this.av_renamed[5] + ", " + this.av_renamed[6] + ", " + this.av_renamed[7]);
        com.oplus.camera.ui.beauty3d.i_renamed iVar = this.H_renamed;
        if (iVar != null) {
            iVar.a_renamed("com.oplus.beauty3d.custom.style", this.av_renamed);
        }
    }

    public void c_renamed(int[] iArr) {
        if (iArr == null || iArr.length < 2 || iArr[0] != 2) {
            return;
        }
        int i_renamed = iArr[1];
        com.oplus.camera.e_renamed.a_renamed("Beauty3DEditUI", "upParams, location: " + i_renamed + ", mTouchLocation: " + this.h_renamed + ", mbRedo: " + this.ao_renamed + ", mbChangeStyle: " + this.aq_renamed);
        if (2 == this.i_renamed && (this.h_renamed == i_renamed || this.ao_renamed || this.aq_renamed)) {
            return;
        }
        if (i_renamed == 2 || i_renamed == 1 || i_renamed == 3 || i_renamed == 5 || i_renamed == 4) {
            com.oplus.camera.e_renamed.a_renamed("Beauty3DEditUI", "update, locatio: " + i_renamed);
            this.h_renamed = i_renamed;
            G_renamed();
        }
    }

    public void c_renamed(boolean z_renamed) {
        android.view.View view = this.P_renamed;
        if (view != null) {
            view.setEnabled(z_renamed);
            this.P_renamed.setClickable(z_renamed);
        }
        android.view.View view2 = this.I_renamed;
        if (view2 != null) {
            view2.setEnabled(z_renamed);
            this.I_renamed.setClickable(z_renamed);
        }
    }

    public void a_renamed(int i_renamed, int[] iArr) {
        this.az_renamed = i_renamed;
        this.am_renamed = i_renamed;
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = i2 * 7;
            this.aw_renamed.put(i2, java.util.Arrays.copyOfRange(iArr, i3, i3 + 7));
        }
    }

    public java.util.HashMap<java.lang.String, int[]> q_renamed() {
        java.util.HashMap<java.lang.String, int[]> map = new java.util.HashMap<>();
        com.oplus.camera.e_renamed.a_renamed("Beauty3DEditUI", "getBeauty3DEditCurrParams, mChoseStyle: " + this.am_renamed + ", mDegree: " + this.al_renamed);
        if (this.i_renamed != 1) {
            map.put("com.oplus.beauty3d.custom.style", this.av_renamed);
        }
        map.put("com.oplus.beauty3d.analyses.rotatedegree", new int[]{this.al_renamed});
        return map;
    }

    /* compiled from: Beauty3DEditUI.java */
    private class b_renamed extends androidx.recyclerview.widget.RecyclerView.a_renamed<com.oplus.camera.ui.beauty3d.d_renamed.b_renamed.a_renamed> {

        /* renamed from: a_renamed, reason: collision with root package name */
        public com.oplus.camera.ui.beauty3d.d_renamed.Beauty3DEditUI_7 f5916a;

        /* renamed from: c_renamed, reason: collision with root package name */
        private java.util.List<com.oplus.camera.ui.beauty3d.d_renamed.c_renamed> f5918c;
        private java.util.List<java.lang.Boolean> d_renamed = new java.util.ArrayList();

        public b_renamed(java.util.List<com.oplus.camera.ui.beauty3d.d_renamed.c_renamed> list, com.oplus.camera.ui.beauty3d.d_renamed.Beauty3DEditUI_7 abstractC0124d) {
            this.f5916a = null;
            this.f5918c = null;
            this.f5918c = list;
            this.f5916a = abstractC0124d;
            for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
                if (i_renamed == 0) {
                    this.d_renamed.add(true);
                } else {
                    this.d_renamed.add(false);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public com.oplus.camera.ui.beauty3d.d_renamed.b_renamed.a_renamed onCreateViewHolder(android.view.ViewGroup viewGroup, int i_renamed) {
            android.view.View viewInflate = android.view.LayoutInflater.from(viewGroup.getContext()).inflate(com.oplus.camera.R_renamed.layout.beauty3d_edit_item, viewGroup, false);
            com.oplus.camera.e_renamed.a_renamed("Beauty3DEditUI", "ViewHolder, onCreateViewHolder, Tag: " + i_renamed);
            return new com.oplus.camera.ui.beauty3d.d_renamed.b_renamed.a_renamed(viewInflate, this.f5916a);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(com.oplus.camera.ui.beauty3d.d_renamed.b_renamed.a_renamed aVar, int i_renamed) {
            aVar.f5919a.setImageDrawable(this.f5918c.get(i_renamed).f5922a);
            aVar.f5920b.setText(this.f5918c.get(i_renamed).f5923b);
            if (this.d_renamed.get(i_renamed).booleanValue()) {
                aVar.f5920b.setTextColor(com.oplus.camera.util.Util.A_renamed(com.oplus.camera.ui.beauty3d.d_renamed.this.f_renamed));
                aVar.f5919a.setHighLight(true);
            } else {
                aVar.f5920b.setTextColor(com.oplus.camera.ui.beauty3d.d_renamed.this.f_renamed.getColor(com.oplus.camera.R_renamed.color.camera_white));
                aVar.f5919a.setHighLight(false);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
        public int getItemCount() {
            return this.f5918c.size();
        }

        /* compiled from: Beauty3DEditUI.java */
        public class a_renamed extends androidx.recyclerview.widget.RecyclerView.w_renamed implements android.view.View.OnClickListener {

            /* renamed from: a_renamed, reason: collision with root package name */
            public com.oplus.camera.ui.beauty3d.BorderRoundImageView f5919a;

            /* renamed from: b_renamed, reason: collision with root package name */
            public android.widget.TextView f5920b;

            /* renamed from: c_renamed, reason: collision with root package name */
            public com.oplus.camera.ui.beauty3d.d_renamed.Beauty3DEditUI_7 f5921c;

            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                for (int i_renamed = 0; i_renamed < com.oplus.camera.ui.beauty3d.d_renamed.b_renamed.this.d_renamed.size(); i_renamed++) {
                    com.oplus.camera.ui.beauty3d.d_renamed.b_renamed.this.d_renamed.set(i_renamed, false);
                }
                com.oplus.camera.e_renamed.a_renamed("Beauty3DEditUI", "ViewHolder, onClick, Position: " + getPosition());
                com.oplus.camera.ui.beauty3d.d_renamed.b_renamed.this.d_renamed.set(getPosition(), true);
                com.oplus.camera.ui.beauty3d.d_renamed.b_renamed.this.notifyDataSetChanged();
                com.oplus.camera.ui.beauty3d.d_renamed.Beauty3DEditUI_7 abstractC0124d = this.f5921c;
                if (abstractC0124d != null) {
                    abstractC0124d.a_renamed(view, getPosition());
                }
            }

            public a_renamed(android.view.View view, com.oplus.camera.ui.beauty3d.d_renamed.Beauty3DEditUI_7 abstractC0124d) {
                super(view);
                this.f5919a = null;
                this.f5920b = null;
                this.f5921c = null;
                this.f5919a = (com.oplus.camera.ui.beauty3d.BorderRoundImageView) view.findViewById(com.oplus.camera.R_renamed.id_renamed.edit_item_view);
                this.f5920b = (android.widget.TextView) view.findViewById(com.oplus.camera.R_renamed.id_renamed.edit_item_title);
                this.f5921c = abstractC0124d;
                view.setOnClickListener(this);
            }
        }
    }

    /* compiled from: Beauty3DEditUI.java */
    private class c_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public android.graphics.drawable.Drawable f5922a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public java.lang.String f5923b;

        public c_renamed(android.graphics.drawable.Drawable drawable, java.lang.String str) {
            this.f5922a = null;
            this.f5923b = null;
            this.f5922a = drawable;
            this.f5923b = str;
        }
    }

    /* compiled from: Beauty3DEditUI.java */
    public class f_renamed extends androidx.recyclerview.widget.RecyclerView.h_renamed {

        /* renamed from: b_renamed, reason: collision with root package name */
        private int f5929b;

        public f_renamed(int i_renamed) {
            this.f5929b = 0;
            this.f5929b = i_renamed;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h_renamed
        public void getItemOffsets(android.graphics.Rect rect, android.view.View view, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.recyclerview.widget.RecyclerView.t_renamed tVar) {
            int i_renamed = this.f5929b;
            rect.right = i_renamed;
            rect.left = i_renamed;
        }
    }

    /* compiled from: Beauty3DEditUI.java */
    private class e_renamed extends androidx.recyclerview.widget.LinearLayoutManager {

        /* renamed from: b_renamed, reason: collision with root package name */
        private int[] f5927b;

        public e_renamed(android.content.Context context) {
            super(context);
            this.f5927b = new int[2];
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i_renamed
        public void onMeasure(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, androidx.recyclerview.widget.RecyclerView.t_renamed tVar, int i_renamed, int i2) {
            int mode = android.view.View.MeasureSpec.getMode(i_renamed);
            int mode2 = android.view.View.MeasureSpec.getMode(i2);
            int size = android.view.View.MeasureSpec.getSize(i_renamed);
            int size2 = android.view.View.MeasureSpec.getSize(i2);
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < getItemCount(); i5++) {
                a_renamed(pVar, i5, android.view.View.MeasureSpec.makeMeasureSpec(i5, 0), android.view.View.MeasureSpec.makeMeasureSpec(i5, 0), this.f5927b);
                if (getOrientation() == 0) {
                    int[] iArr = this.f5927b;
                    i4 += iArr[0];
                    if (i5 == 0) {
                        i3 = iArr[1];
                    }
                } else {
                    int[] iArr2 = this.f5927b;
                    i3 += iArr2[1];
                    if (i5 == 0) {
                        i4 = iArr2[0];
                    }
                }
            }
            if (mode == Integer.MIN_VALUE || mode == 0 || mode != 1073741824) {
                size = i4;
            }
            if (mode2 == Integer.MIN_VALUE || mode2 == 0 || mode2 != 1073741824) {
                size2 = i3;
            }
            setMeasuredDimension(size, size2);
        }

        private void a_renamed(androidx.recyclerview.widget.RecyclerView.p_renamed pVar, int i_renamed, int i2, int i3, int[] iArr) {
            android.view.View viewC = pVar.c_renamed(i_renamed);
            if (viewC != null) {
                androidx.recyclerview.widget.RecyclerView.j_renamed jVar = (androidx.recyclerview.widget.RecyclerView.j_renamed) viewC.getLayoutParams();
                viewC.measure(android.view.ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight(), jVar.width), android.view.ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom(), jVar.height));
                iArr[0] = viewC.getMeasuredWidth() + jVar.leftMargin + jVar.rightMargin;
                iArr[1] = viewC.getMeasuredHeight() + jVar.bottomMargin + jVar.topMargin;
                pVar.a_renamed(viewC);
            }
        }
    }

    private void N_renamed() {
        if (this.g_renamed != null && this.ak_renamed == null) {
            this.ak_renamed = (com.oplus.camera.ui.camerascreenhint.CameraScreenHintView) this.f_renamed.getLayoutInflater().inflate(com.oplus.camera.R_renamed.layout.camera_screen_hint, (android.view.ViewGroup) null);
            this.g_renamed.addView(this.ak_renamed);
            this.ak_renamed.setOrientation(0);
        }
    }

    public void a_renamed(java.lang.String str) {
        if (this.ak_renamed == null) {
            N_renamed();
            if (this.ak_renamed != null) {
                this.ak_renamed.a_renamed(0, (this.f_renamed.getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.down_hint_margin_bottom) + ((int) this.f_renamed.getResources().getDimension(com.oplus.camera.R_renamed.dimen.beauty3d_edit_custom_bottom_height))) - this.ak_renamed.getViewGap(), 0, true);
            }
        }
        com.oplus.camera.ui.camerascreenhint.CameraScreenHintView cameraScreenHintView = this.ak_renamed;
        if (cameraScreenHintView == null) {
            return;
        }
        cameraScreenHintView.bringToFront();
        this.ak_renamed.a_renamed(new com.oplus.camera.ui.camerascreenhint.a_renamed.CameraScreenHintInfo_2().a_renamed(str).a_renamed(true).b_renamed(false).a_renamed(0).b_renamed(com.oplus.camera.R_renamed.color.screen_hint_text_color).a_renamed());
    }

    public void r_renamed() {
        com.oplus.camera.ui.camerascreenhint.CameraScreenHintView cameraScreenHintView = this.ak_renamed;
        if (cameraScreenHintView == null || cameraScreenHintView.getHintTextView().getVisibility() != 0) {
            return;
        }
        this.ak_renamed.b_renamed(true);
    }

    /* compiled from: Beauty3DEditUI.java */
    /* renamed from: com.oplus.camera.ui.beauty3d.d_renamed$d_renamed, reason: collision with other inner class name */
    private abstract class Beauty3DEditUI_7 {
        void a_renamed(android.view.View view, int i_renamed) {
        }

        private Beauty3DEditUI_7() {
        }
    }

    /* compiled from: Beauty3DEditUI.java */
    private class a_renamed implements android.view.GestureDetector.OnGestureListener {
        private a_renamed() {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(android.view.MotionEvent motionEvent) {
            if (motionEvent == null) {
                return true;
            }
            com.oplus.camera.ui.beauty3d.d_renamed.this.ar_renamed = false;
            com.oplus.camera.ui.beauty3d.d_renamed.this.an_renamed = motionEvent.getRawX();
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(android.view.MotionEvent motionEvent) {
            com.oplus.camera.e_renamed.a_renamed("Beauty3DEditUI", "Beauty3DGestureListener, onShowPress");
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(android.view.MotionEvent motionEvent) {
            if (motionEvent == null) {
                return true;
            }
            float y_renamed = 1440.0f - motionEvent.getY();
            float x_renamed = 1080.0f - motionEvent.getX();
            com.oplus.camera.e_renamed.a_renamed("Beauty3DEditUI", "Beauty3DGestureListener, onSingleTapUp, x_renamed: " + y_renamed + ", y_renamed: " + x_renamed);
            if (com.oplus.camera.ui.beauty3d.d_renamed.this.i_renamed == 2) {
                com.oplus.camera.ui.beauty3d.d_renamed.this.ao_renamed = false;
                com.oplus.camera.ui.beauty3d.d_renamed.this.aq_renamed = false;
                com.oplus.camera.ui.beauty3d.d_renamed.this.H_renamed.a_renamed("com.oplus.beauty3d.custom.position", new int[]{(int) y_renamed, (int) x_renamed});
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(android.view.MotionEvent motionEvent, android.view.MotionEvent motionEvent2, float f_renamed, float f2) {
            if (motionEvent != null && motionEvent2 != null) {
                int x_renamed = (int) (motionEvent2.getX() - motionEvent.getX());
                com.oplus.camera.e_renamed.a_renamed("Beauty3DEditUI", "Beauty3DGestureListener, onScroll, e1.X_renamed: " + motionEvent.getX() + ", e2.X_renamed:" + motionEvent2.getX());
                if (java.lang.Math.abs(x_renamed) < 10) {
                    return true;
                }
                com.oplus.camera.ui.beauty3d.d_renamed.this.b_renamed(false);
                com.oplus.camera.ui.beauty3d.d_renamed.this.al_renamed = com.oplus.camera.d_renamed.c_renamed.a_renamed().a_renamed(motionEvent2.getRawX(), com.oplus.camera.util.Util.getScreenWidth(), com.oplus.camera.ui.beauty3d.d_renamed.this.an_renamed, com.oplus.camera.ui.beauty3d.d_renamed.this.al_renamed);
                com.oplus.camera.ui.beauty3d.d_renamed.this.H_renamed.a_renamed("com.oplus.beauty3d.analyses.rotatedegree", new int[]{com.oplus.camera.ui.beauty3d.d_renamed.this.al_renamed});
                com.oplus.camera.ui.beauty3d.d_renamed.this.an_renamed = motionEvent2.getRawX();
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(android.view.MotionEvent motionEvent, android.view.MotionEvent motionEvent2, float f_renamed, float f2) {
            com.oplus.camera.e_renamed.a_renamed("Beauty3DEditUI", "Beauty3DGestureListener, onFling");
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(android.view.MotionEvent motionEvent) {
            com.oplus.camera.e_renamed.a_renamed("Beauty3DEditUI", "Beauty3DGestureListener, onLongPress");
            if (com.oplus.camera.ui.beauty3d.d_renamed.this.i_renamed == 2) {
                com.oplus.camera.ui.beauty3d.d_renamed.this.H_renamed.a_renamed("com.oplus.beauty3d.custom.mode", com.oplus.camera.ui.beauty3d.d_renamed.this.at_renamed);
            }
        }
    }
}
