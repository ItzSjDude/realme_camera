package androidx.constraintlayout.widget;

/* compiled from: ConstraintSet.java */
/* loaded from: classes.dex */
public class c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final int[] f759a = {0, 4, 8};

    /* renamed from: c_renamed, reason: collision with root package name */
    private static android.util.SparseIntArray f760c = new android.util.SparseIntArray();

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.util.HashMap<java.lang.Integer, androidx.constraintlayout.widget.c_renamed.a_renamed> f761b = new java.util.HashMap<>();

    private java.lang.String b_renamed(int i_renamed) {
        switch (i_renamed) {
            case 1:
                return com.google.android.exoplayer2.text.ttml.TtmlNode.LEFT;
            case 2:
                return com.google.android.exoplayer2.text.ttml.TtmlNode.RIGHT;
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return com.google.android.exoplayer2.text.ttml.TtmlNode.START;
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    static {
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_constraintLeft_toLeftOf, 25);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_constraintLeft_toRightOf, 26);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_constraintRight_toLeftOf, 29);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_constraintRight_toRightOf, 30);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_constraintTop_toTopOf, 36);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_constraintTop_toBottomOf, 35);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_constraintBottom_toTopOf, 4);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_constraintBottom_toBottomOf, 3);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_constraintBaseline_toBaselineOf, 1);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_editor_absoluteX, 6);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_editor_absoluteY, 7);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_constraintGuide_begin, 17);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_constraintGuide_end, 18);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_constraintGuide_percent, 19);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_android_orientation, 27);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_constraintStart_toEndOf, 32);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_constraintStart_toStartOf, 33);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_constraintEnd_toStartOf, 10);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_constraintEnd_toEndOf, 9);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_goneMarginLeft, 13);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_goneMarginTop, 16);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_goneMarginRight, 14);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_goneMarginBottom, 11);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_goneMarginStart, 15);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_goneMarginEnd, 12);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_constraintVertical_weight, 40);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_constraintHorizontal_weight, 39);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_constraintHorizontal_chainStyle, 41);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_constraintVertical_chainStyle, 42);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_constraintHorizontal_bias, 20);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_constraintVertical_bias, 37);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_constraintDimensionRatio, 5);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_constraintLeft_creator, 75);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_constraintTop_creator, 75);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_constraintRight_creator, 75);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_constraintBottom_creator, 75);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_constraintBaseline_creator, 75);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_android_layout_marginLeft, 24);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_android_layout_marginRight, 28);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_android_layout_marginStart, 31);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_android_layout_marginEnd, 8);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_android_layout_marginTop, 34);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_android_layout_marginBottom, 2);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_android_layout_width, 23);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_android_layout_height, 21);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_android_visibility, 22);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_android_alpha, 43);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_android_elevation, 44);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_android_rotationX, 45);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_android_rotationY, 46);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_android_rotation, 60);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_android_scaleX, 47);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_android_scaleY, 48);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_android_transformPivotX, 49);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_android_transformPivotY, 50);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_android_translationX, 51);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_android_translationY, 52);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_android_translationZ, 53);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_constraintWidth_default, 54);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_constraintHeight_default, 55);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_constraintWidth_max, 56);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_constraintHeight_max, 57);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_constraintWidth_min, 58);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_constraintHeight_min, 59);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_constraintCircle, 61);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_constraintCircleRadius, 62);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_constraintCircleAngle, 63);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_android_id, 38);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_constraintWidth_percent, 69);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_layout_constraintHeight_percent, 70);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_chainUseRtl, 71);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_barrierDirection, 72);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_constraint_referenced_ids, 73);
        f760c.append(androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet_barrierAllowsGoneWidgets, 74);
    }

    /* compiled from: ConstraintSet.java */
    private static class a_renamed {
        public int A_renamed;
        public int B_renamed;
        public int C_renamed;
        public int D_renamed;
        public int E_renamed;
        public int F_renamed;
        public int G_renamed;
        public int H_renamed;
        public int I_renamed;
        public int J_renamed;
        public int K_renamed;
        public int L_renamed;
        public int M_renamed;
        public int N_renamed;
        public int O_renamed;
        public int P_renamed;
        public float Q_renamed;
        public float R_renamed;
        public int S_renamed;
        public int T_renamed;
        public float U_renamed;
        public boolean V_renamed;
        public float W_renamed;
        public float X_renamed;
        public float Y_renamed;
        public float Z_renamed;

        /* renamed from: a_renamed, reason: collision with root package name */
        boolean f762a;
        public float aa_renamed;
        public float ab_renamed;
        public float ac_renamed;
        public float ad_renamed;
        public float ae_renamed;
        public float af_renamed;
        public float ag_renamed;
        public boolean ah_renamed;
        public boolean ai_renamed;
        public int aj_renamed;
        public int ak_renamed;
        public int al_renamed;
        public int am_renamed;
        public int an_renamed;
        public int ao_renamed;
        public float ap_renamed;
        public float aq_renamed;
        public boolean ar_renamed;
        public int as_renamed;
        public int at_renamed;
        public int[] au_renamed;
        public java.lang.String av_renamed;

        /* renamed from: b_renamed, reason: collision with root package name */
        public int f763b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public int f764c;
        int d_renamed;
        public int e_renamed;
        public int f_renamed;
        public float g_renamed;
        public int h_renamed;
        public int i_renamed;
        public int j_renamed;
        public int k_renamed;
        public int l_renamed;
        public int m_renamed;
        public int n_renamed;
        public int o_renamed;
        public int p_renamed;
        public int q_renamed;
        public int r_renamed;
        public int s_renamed;
        public int t_renamed;
        public float u_renamed;
        public float v_renamed;
        public java.lang.String w_renamed;
        public int x_renamed;
        public int y_renamed;
        public float z_renamed;

        private a_renamed() {
            this.f762a = false;
            this.e_renamed = -1;
            this.f_renamed = -1;
            this.g_renamed = -1.0f;
            this.h_renamed = -1;
            this.i_renamed = -1;
            this.j_renamed = -1;
            this.k_renamed = -1;
            this.l_renamed = -1;
            this.m_renamed = -1;
            this.n_renamed = -1;
            this.o_renamed = -1;
            this.p_renamed = -1;
            this.q_renamed = -1;
            this.r_renamed = -1;
            this.s_renamed = -1;
            this.t_renamed = -1;
            this.u_renamed = 0.5f;
            this.v_renamed = 0.5f;
            this.w_renamed = null;
            this.x_renamed = -1;
            this.y_renamed = 0;
            this.z_renamed = 0.0f;
            this.A_renamed = -1;
            this.B_renamed = -1;
            this.C_renamed = -1;
            this.D_renamed = -1;
            this.E_renamed = -1;
            this.F_renamed = -1;
            this.G_renamed = -1;
            this.H_renamed = -1;
            this.I_renamed = -1;
            this.J_renamed = 0;
            this.K_renamed = -1;
            this.L_renamed = -1;
            this.M_renamed = -1;
            this.N_renamed = -1;
            this.O_renamed = -1;
            this.P_renamed = -1;
            this.Q_renamed = 0.0f;
            this.R_renamed = 0.0f;
            this.S_renamed = 0;
            this.T_renamed = 0;
            this.U_renamed = 1.0f;
            this.V_renamed = false;
            this.W_renamed = 0.0f;
            this.X_renamed = 0.0f;
            this.Y_renamed = 0.0f;
            this.Z_renamed = 0.0f;
            this.aa_renamed = 1.0f;
            this.ab_renamed = 1.0f;
            this.ac_renamed = Float.NaN;
            this.ad_renamed = Float.NaN;
            this.ae_renamed = 0.0f;
            this.af_renamed = 0.0f;
            this.ag_renamed = 0.0f;
            this.ah_renamed = false;
            this.ai_renamed = false;
            this.aj_renamed = 0;
            this.ak_renamed = 0;
            this.al_renamed = -1;
            this.am_renamed = -1;
            this.an_renamed = -1;
            this.ao_renamed = -1;
            this.ap_renamed = 1.0f;
            this.aq_renamed = 1.0f;
            this.ar_renamed = false;
            this.as_renamed = -1;
            this.at_renamed = -1;
        }

        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public androidx.constraintlayout.widget.c_renamed.a_renamed clone() {
            androidx.constraintlayout.widget.c_renamed.a_renamed aVar = new androidx.constraintlayout.widget.c_renamed.a_renamed();
            aVar.f762a = this.f762a;
            aVar.f763b = this.f763b;
            aVar.f764c = this.f764c;
            aVar.e_renamed = this.e_renamed;
            aVar.f_renamed = this.f_renamed;
            aVar.g_renamed = this.g_renamed;
            aVar.h_renamed = this.h_renamed;
            aVar.i_renamed = this.i_renamed;
            aVar.j_renamed = this.j_renamed;
            aVar.k_renamed = this.k_renamed;
            aVar.l_renamed = this.l_renamed;
            aVar.m_renamed = this.m_renamed;
            aVar.n_renamed = this.n_renamed;
            aVar.o_renamed = this.o_renamed;
            aVar.p_renamed = this.p_renamed;
            aVar.q_renamed = this.q_renamed;
            aVar.r_renamed = this.r_renamed;
            aVar.s_renamed = this.s_renamed;
            aVar.t_renamed = this.t_renamed;
            aVar.u_renamed = this.u_renamed;
            aVar.v_renamed = this.v_renamed;
            aVar.w_renamed = this.w_renamed;
            aVar.A_renamed = this.A_renamed;
            aVar.B_renamed = this.B_renamed;
            aVar.u_renamed = this.u_renamed;
            aVar.u_renamed = this.u_renamed;
            aVar.u_renamed = this.u_renamed;
            aVar.u_renamed = this.u_renamed;
            aVar.u_renamed = this.u_renamed;
            aVar.C_renamed = this.C_renamed;
            aVar.D_renamed = this.D_renamed;
            aVar.E_renamed = this.E_renamed;
            aVar.F_renamed = this.F_renamed;
            aVar.G_renamed = this.G_renamed;
            aVar.H_renamed = this.H_renamed;
            aVar.I_renamed = this.I_renamed;
            aVar.J_renamed = this.J_renamed;
            aVar.K_renamed = this.K_renamed;
            aVar.L_renamed = this.L_renamed;
            aVar.M_renamed = this.M_renamed;
            aVar.N_renamed = this.N_renamed;
            aVar.O_renamed = this.O_renamed;
            aVar.P_renamed = this.P_renamed;
            aVar.Q_renamed = this.Q_renamed;
            aVar.R_renamed = this.R_renamed;
            aVar.S_renamed = this.S_renamed;
            aVar.T_renamed = this.T_renamed;
            aVar.U_renamed = this.U_renamed;
            aVar.V_renamed = this.V_renamed;
            aVar.W_renamed = this.W_renamed;
            aVar.X_renamed = this.X_renamed;
            aVar.Y_renamed = this.Y_renamed;
            aVar.Z_renamed = this.Z_renamed;
            aVar.aa_renamed = this.aa_renamed;
            aVar.ab_renamed = this.ab_renamed;
            aVar.ac_renamed = this.ac_renamed;
            aVar.ad_renamed = this.ad_renamed;
            aVar.ae_renamed = this.ae_renamed;
            aVar.af_renamed = this.af_renamed;
            aVar.ag_renamed = this.ag_renamed;
            aVar.ah_renamed = this.ah_renamed;
            aVar.ai_renamed = this.ai_renamed;
            aVar.aj_renamed = this.aj_renamed;
            aVar.ak_renamed = this.ak_renamed;
            aVar.al_renamed = this.al_renamed;
            aVar.am_renamed = this.am_renamed;
            aVar.an_renamed = this.an_renamed;
            aVar.ao_renamed = this.ao_renamed;
            aVar.ap_renamed = this.ap_renamed;
            aVar.aq_renamed = this.aq_renamed;
            aVar.as_renamed = this.as_renamed;
            aVar.at_renamed = this.at_renamed;
            int[] iArr = this.au_renamed;
            if (iArr != null) {
                aVar.au_renamed = java.util.Arrays.copyOf(iArr, iArr.length);
            }
            aVar.x_renamed = this.x_renamed;
            aVar.y_renamed = this.y_renamed;
            aVar.z_renamed = this.z_renamed;
            aVar.ar_renamed = this.ar_renamed;
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a_renamed(androidx.constraintlayout.widget.b_renamed bVar, int i_renamed, androidx.constraintlayout.widget.d_renamed.a_renamed aVar) {
            a_renamed(i_renamed, aVar);
            if (bVar instanceof androidx.constraintlayout.widget.a_renamed) {
                this.at_renamed = 1;
                androidx.constraintlayout.widget.a_renamed aVar2 = (androidx.constraintlayout.widget.a_renamed) bVar;
                this.as_renamed = aVar2.getType();
                this.au_renamed = aVar2.getReferencedIds();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a_renamed(int i_renamed, androidx.constraintlayout.widget.d_renamed.a_renamed aVar) {
            a_renamed(i_renamed, (androidx.constraintlayout.widget.ConstraintLayout.a_renamed) aVar);
            this.U_renamed = aVar.an_renamed;
            this.X_renamed = aVar.aq_renamed;
            this.Y_renamed = aVar.ar_renamed;
            this.Z_renamed = aVar.as_renamed;
            this.aa_renamed = aVar.at_renamed;
            this.ab_renamed = aVar.au_renamed;
            this.ac_renamed = aVar.av_renamed;
            this.ad_renamed = aVar.aw_renamed;
            this.ae_renamed = aVar.ax_renamed;
            this.af_renamed = aVar.ay_renamed;
            this.ag_renamed = aVar.az_renamed;
            this.W_renamed = aVar.ap_renamed;
            this.V_renamed = aVar.ao_renamed;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a_renamed(int i_renamed, androidx.constraintlayout.widget.ConstraintLayout.a_renamed aVar) {
            this.d_renamed = i_renamed;
            this.h_renamed = aVar.d_renamed;
            this.i_renamed = aVar.e_renamed;
            this.j_renamed = aVar.f_renamed;
            this.k_renamed = aVar.g_renamed;
            this.l_renamed = aVar.h_renamed;
            this.m_renamed = aVar.i_renamed;
            this.n_renamed = aVar.j_renamed;
            this.o_renamed = aVar.k_renamed;
            this.p_renamed = aVar.l_renamed;
            this.q_renamed = aVar.p_renamed;
            this.r_renamed = aVar.q_renamed;
            this.s_renamed = aVar.r_renamed;
            this.t_renamed = aVar.s_renamed;
            this.u_renamed = aVar.z_renamed;
            this.v_renamed = aVar.A_renamed;
            this.w_renamed = aVar.B_renamed;
            this.x_renamed = aVar.m_renamed;
            this.y_renamed = aVar.n_renamed;
            this.z_renamed = aVar.o_renamed;
            this.A_renamed = aVar.Q_renamed;
            this.B_renamed = aVar.R_renamed;
            this.C_renamed = aVar.S_renamed;
            this.g_renamed = aVar.f754c;
            this.e_renamed = aVar.f752a;
            this.f_renamed = aVar.f753b;
            this.f763b = aVar.width;
            this.f764c = aVar.height;
            this.D_renamed = aVar.leftMargin;
            this.E_renamed = aVar.rightMargin;
            this.F_renamed = aVar.topMargin;
            this.G_renamed = aVar.bottomMargin;
            this.Q_renamed = aVar.F_renamed;
            this.R_renamed = aVar.E_renamed;
            this.T_renamed = aVar.H_renamed;
            this.S_renamed = aVar.G_renamed;
            this.ah_renamed = aVar.T_renamed;
            this.ai_renamed = aVar.U_renamed;
            this.aj_renamed = aVar.I_renamed;
            this.ak_renamed = aVar.J_renamed;
            this.ah_renamed = aVar.T_renamed;
            this.al_renamed = aVar.M_renamed;
            this.am_renamed = aVar.N_renamed;
            this.an_renamed = aVar.K_renamed;
            this.ao_renamed = aVar.L_renamed;
            this.ap_renamed = aVar.O_renamed;
            this.aq_renamed = aVar.P_renamed;
            if (android.os.Build.VERSION.SDK_INT >= 17) {
                this.H_renamed = aVar.getMarginEnd();
                this.I_renamed = aVar.getMarginStart();
            }
        }

        public void a_renamed(androidx.constraintlayout.widget.ConstraintLayout.a_renamed aVar) {
            aVar.d_renamed = this.h_renamed;
            aVar.e_renamed = this.i_renamed;
            aVar.f_renamed = this.j_renamed;
            aVar.g_renamed = this.k_renamed;
            aVar.h_renamed = this.l_renamed;
            aVar.i_renamed = this.m_renamed;
            aVar.j_renamed = this.n_renamed;
            aVar.k_renamed = this.o_renamed;
            aVar.l_renamed = this.p_renamed;
            aVar.p_renamed = this.q_renamed;
            aVar.q_renamed = this.r_renamed;
            aVar.r_renamed = this.s_renamed;
            aVar.s_renamed = this.t_renamed;
            aVar.leftMargin = this.D_renamed;
            aVar.rightMargin = this.E_renamed;
            aVar.topMargin = this.F_renamed;
            aVar.bottomMargin = this.G_renamed;
            aVar.x_renamed = this.P_renamed;
            aVar.y_renamed = this.O_renamed;
            aVar.z_renamed = this.u_renamed;
            aVar.A_renamed = this.v_renamed;
            aVar.m_renamed = this.x_renamed;
            aVar.n_renamed = this.y_renamed;
            aVar.o_renamed = this.z_renamed;
            aVar.B_renamed = this.w_renamed;
            aVar.Q_renamed = this.A_renamed;
            aVar.R_renamed = this.B_renamed;
            aVar.F_renamed = this.Q_renamed;
            aVar.E_renamed = this.R_renamed;
            aVar.H_renamed = this.T_renamed;
            aVar.G_renamed = this.S_renamed;
            aVar.T_renamed = this.ah_renamed;
            aVar.U_renamed = this.ai_renamed;
            aVar.I_renamed = this.aj_renamed;
            aVar.J_renamed = this.ak_renamed;
            aVar.M_renamed = this.al_renamed;
            aVar.N_renamed = this.am_renamed;
            aVar.K_renamed = this.an_renamed;
            aVar.L_renamed = this.ao_renamed;
            aVar.O_renamed = this.ap_renamed;
            aVar.P_renamed = this.aq_renamed;
            aVar.S_renamed = this.C_renamed;
            aVar.f754c = this.g_renamed;
            aVar.f752a = this.e_renamed;
            aVar.f753b = this.f_renamed;
            aVar.width = this.f763b;
            aVar.height = this.f764c;
            if (android.os.Build.VERSION.SDK_INT >= 17) {
                aVar.setMarginStart(this.I_renamed);
                aVar.setMarginEnd(this.H_renamed);
            }
            aVar.a_renamed();
        }
    }

    public void a_renamed(androidx.constraintlayout.widget.ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.f761b.clear();
        for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
            android.view.View childAt = constraintLayout.getChildAt(i_renamed);
            androidx.constraintlayout.widget.ConstraintLayout.a_renamed aVar = (androidx.constraintlayout.widget.ConstraintLayout.a_renamed) childAt.getLayoutParams();
            int id_renamed = childAt.getId();
            if (id_renamed == -1) {
                throw new java.lang.RuntimeException("All children of_renamed ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f761b.containsKey(java.lang.Integer.valueOf(id_renamed))) {
                this.f761b.put(java.lang.Integer.valueOf(id_renamed), new androidx.constraintlayout.widget.c_renamed.a_renamed());
            }
            androidx.constraintlayout.widget.c_renamed.a_renamed aVar2 = this.f761b.get(java.lang.Integer.valueOf(id_renamed));
            aVar2.a_renamed(id_renamed, aVar);
            aVar2.J_renamed = childAt.getVisibility();
            if (android.os.Build.VERSION.SDK_INT >= 17) {
                aVar2.U_renamed = childAt.getAlpha();
                aVar2.X_renamed = childAt.getRotation();
                aVar2.Y_renamed = childAt.getRotationX();
                aVar2.Z_renamed = childAt.getRotationY();
                aVar2.aa_renamed = childAt.getScaleX();
                aVar2.ab_renamed = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    aVar2.ac_renamed = pivotX;
                    aVar2.ad_renamed = pivotY;
                }
                aVar2.ae_renamed = childAt.getTranslationX();
                aVar2.af_renamed = childAt.getTranslationY();
                if (android.os.Build.VERSION.SDK_INT >= 21) {
                    aVar2.ag_renamed = childAt.getTranslationZ();
                    if (aVar2.V_renamed) {
                        aVar2.W_renamed = childAt.getElevation();
                    }
                }
            }
            if (childAt instanceof androidx.constraintlayout.widget.a_renamed) {
                androidx.constraintlayout.widget.a_renamed aVar3 = (androidx.constraintlayout.widget.a_renamed) childAt;
                aVar2.ar_renamed = aVar3.a_renamed();
                aVar2.au_renamed = aVar3.getReferencedIds();
                aVar2.as_renamed = aVar3.getType();
            }
        }
    }

    public void a_renamed(androidx.constraintlayout.widget.d_renamed dVar) {
        int childCount = dVar.getChildCount();
        this.f761b.clear();
        for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
            android.view.View childAt = dVar.getChildAt(i_renamed);
            androidx.constraintlayout.widget.d_renamed.a_renamed aVar = (androidx.constraintlayout.widget.d_renamed.a_renamed) childAt.getLayoutParams();
            int id_renamed = childAt.getId();
            if (id_renamed == -1) {
                throw new java.lang.RuntimeException("All children of_renamed ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f761b.containsKey(java.lang.Integer.valueOf(id_renamed))) {
                this.f761b.put(java.lang.Integer.valueOf(id_renamed), new androidx.constraintlayout.widget.c_renamed.a_renamed());
            }
            androidx.constraintlayout.widget.c_renamed.a_renamed aVar2 = this.f761b.get(java.lang.Integer.valueOf(id_renamed));
            if (childAt instanceof androidx.constraintlayout.widget.b_renamed) {
                aVar2.a_renamed((androidx.constraintlayout.widget.b_renamed) childAt, id_renamed, aVar);
            }
            aVar2.a_renamed(id_renamed, aVar);
        }
    }

    public void b_renamed(androidx.constraintlayout.widget.ConstraintLayout constraintLayout) {
        c_renamed(constraintLayout);
        constraintLayout.setConstraintSet(null);
    }

    void c_renamed(androidx.constraintlayout.widget.ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        java.util.HashSet hashSet = new java.util.HashSet(this.f761b.keySet());
        for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
            android.view.View childAt = constraintLayout.getChildAt(i_renamed);
            int id_renamed = childAt.getId();
            if (id_renamed == -1) {
                throw new java.lang.RuntimeException("All children of_renamed ConstraintLayout must have ids to use ConstraintSet");
            }
            if (this.f761b.containsKey(java.lang.Integer.valueOf(id_renamed))) {
                hashSet.remove(java.lang.Integer.valueOf(id_renamed));
                androidx.constraintlayout.widget.c_renamed.a_renamed aVar = this.f761b.get(java.lang.Integer.valueOf(id_renamed));
                if (childAt instanceof androidx.constraintlayout.widget.a_renamed) {
                    aVar.at_renamed = 1;
                }
                if (aVar.at_renamed != -1 && aVar.at_renamed == 1) {
                    androidx.constraintlayout.widget.a_renamed aVar2 = (androidx.constraintlayout.widget.a_renamed) childAt;
                    aVar2.setId(id_renamed);
                    aVar2.setType(aVar.as_renamed);
                    aVar2.setAllowsGoneWidget(aVar.ar_renamed);
                    if (aVar.au_renamed != null) {
                        aVar2.setReferencedIds(aVar.au_renamed);
                    } else if (aVar.av_renamed != null) {
                        aVar.au_renamed = a_renamed(aVar2, aVar.av_renamed);
                        aVar2.setReferencedIds(aVar.au_renamed);
                    }
                }
                androidx.constraintlayout.widget.ConstraintLayout.a_renamed aVar3 = (androidx.constraintlayout.widget.ConstraintLayout.a_renamed) childAt.getLayoutParams();
                aVar.a_renamed(aVar3);
                childAt.setLayoutParams(aVar3);
                childAt.setVisibility(aVar.J_renamed);
                if (android.os.Build.VERSION.SDK_INT >= 17) {
                    childAt.setAlpha(aVar.U_renamed);
                    childAt.setRotation(aVar.X_renamed);
                    childAt.setRotationX(aVar.Y_renamed);
                    childAt.setRotationY(aVar.Z_renamed);
                    childAt.setScaleX(aVar.aa_renamed);
                    childAt.setScaleY(aVar.ab_renamed);
                    if (!java.lang.Float.isNaN(aVar.ac_renamed)) {
                        childAt.setPivotX(aVar.ac_renamed);
                    }
                    if (!java.lang.Float.isNaN(aVar.ad_renamed)) {
                        childAt.setPivotY(aVar.ad_renamed);
                    }
                    childAt.setTranslationX(aVar.ae_renamed);
                    childAt.setTranslationY(aVar.af_renamed);
                    if (android.os.Build.VERSION.SDK_INT >= 21) {
                        childAt.setTranslationZ(aVar.ag_renamed);
                        if (aVar.V_renamed) {
                            childAt.setElevation(aVar.W_renamed);
                        }
                    }
                }
            }
        }
        java.util.Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            java.lang.Integer num = (java.lang.Integer) it.next();
            androidx.constraintlayout.widget.c_renamed.a_renamed aVar4 = this.f761b.get(num);
            if (aVar4.at_renamed != -1 && aVar4.at_renamed == 1) {
                androidx.constraintlayout.widget.a_renamed aVar5 = new androidx.constraintlayout.widget.a_renamed(constraintLayout.getContext());
                aVar5.setId(num.intValue());
                if (aVar4.au_renamed != null) {
                    aVar5.setReferencedIds(aVar4.au_renamed);
                } else if (aVar4.av_renamed != null) {
                    aVar4.au_renamed = a_renamed(aVar5, aVar4.av_renamed);
                    aVar5.setReferencedIds(aVar4.au_renamed);
                }
                aVar5.setType(aVar4.as_renamed);
                androidx.constraintlayout.widget.ConstraintLayout.a_renamed aVarA = constraintLayout.generateDefaultLayoutParams();
                aVar5.b_renamed();
                aVar4.a_renamed(aVarA);
                constraintLayout.addView(aVar5, aVarA);
            }
            if (aVar4.f762a) {
                androidx.constraintlayout.widget.e_renamed eVar = new androidx.constraintlayout.widget.e_renamed(constraintLayout.getContext());
                eVar.setId(num.intValue());
                androidx.constraintlayout.widget.ConstraintLayout.a_renamed aVarA2 = constraintLayout.generateDefaultLayoutParams();
                aVar4.a_renamed(aVarA2);
                constraintLayout.addView(eVar, aVarA2);
            }
        }
    }

    public void a_renamed(int i_renamed, int i2, int i3, int i4) {
        if (!this.f761b.containsKey(java.lang.Integer.valueOf(i_renamed))) {
            this.f761b.put(java.lang.Integer.valueOf(i_renamed), new androidx.constraintlayout.widget.c_renamed.a_renamed());
        }
        androidx.constraintlayout.widget.c_renamed.a_renamed aVar = this.f761b.get(java.lang.Integer.valueOf(i_renamed));
        switch (i2) {
            case 1:
                if (i4 == 1) {
                    aVar.h_renamed = i3;
                    aVar.i_renamed = -1;
                    return;
                } else if (i4 == 2) {
                    aVar.i_renamed = i3;
                    aVar.h_renamed = -1;
                    return;
                } else {
                    throw new java.lang.IllegalArgumentException("left to " + b_renamed(i4) + " undefined");
                }
            case 2:
                if (i4 == 1) {
                    aVar.j_renamed = i3;
                    aVar.k_renamed = -1;
                    return;
                } else if (i4 == 2) {
                    aVar.k_renamed = i3;
                    aVar.j_renamed = -1;
                    return;
                } else {
                    throw new java.lang.IllegalArgumentException("right to " + b_renamed(i4) + " undefined");
                }
            case 3:
                if (i4 == 3) {
                    aVar.l_renamed = i3;
                    aVar.m_renamed = -1;
                    aVar.p_renamed = -1;
                    return;
                } else if (i4 == 4) {
                    aVar.m_renamed = i3;
                    aVar.l_renamed = -1;
                    aVar.p_renamed = -1;
                    return;
                } else {
                    throw new java.lang.IllegalArgumentException("right to " + b_renamed(i4) + " undefined");
                }
            case 4:
                if (i4 == 4) {
                    aVar.o_renamed = i3;
                    aVar.n_renamed = -1;
                    aVar.p_renamed = -1;
                    return;
                } else if (i4 == 3) {
                    aVar.n_renamed = i3;
                    aVar.o_renamed = -1;
                    aVar.p_renamed = -1;
                    return;
                } else {
                    throw new java.lang.IllegalArgumentException("right to " + b_renamed(i4) + " undefined");
                }
            case 5:
                if (i4 == 5) {
                    aVar.p_renamed = i3;
                    aVar.o_renamed = -1;
                    aVar.n_renamed = -1;
                    aVar.l_renamed = -1;
                    aVar.m_renamed = -1;
                    return;
                }
                throw new java.lang.IllegalArgumentException("right to " + b_renamed(i4) + " undefined");
            case 6:
                if (i4 == 6) {
                    aVar.r_renamed = i3;
                    aVar.q_renamed = -1;
                    return;
                } else if (i4 == 7) {
                    aVar.q_renamed = i3;
                    aVar.r_renamed = -1;
                    return;
                } else {
                    throw new java.lang.IllegalArgumentException("right to " + b_renamed(i4) + " undefined");
                }
            case 7:
                if (i4 == 7) {
                    aVar.t_renamed = i3;
                    aVar.s_renamed = -1;
                    return;
                } else if (i4 == 6) {
                    aVar.s_renamed = i3;
                    aVar.t_renamed = -1;
                    return;
                } else {
                    throw new java.lang.IllegalArgumentException("right to " + b_renamed(i4) + " undefined");
                }
            default:
                throw new java.lang.IllegalArgumentException(b_renamed(i2) + " to " + b_renamed(i4) + " unknown");
        }
    }

    public void a_renamed(int i_renamed, int i2) {
        a_renamed(i_renamed).f764c = i2;
    }

    public void b_renamed(int i_renamed, int i2) {
        a_renamed(i_renamed).f763b = i2;
    }

    private androidx.constraintlayout.widget.c_renamed.a_renamed a_renamed(int i_renamed) {
        if (!this.f761b.containsKey(java.lang.Integer.valueOf(i_renamed))) {
            this.f761b.put(java.lang.Integer.valueOf(i_renamed), new androidx.constraintlayout.widget.c_renamed.a_renamed());
        }
        return this.f761b.get(java.lang.Integer.valueOf(i_renamed));
    }

    public void a_renamed(android.content.Context context, int i_renamed) throws org.xmlpull.v1.XmlPullParserException, android.content.res.Resources.NotFoundException, java.io.IOException {
        android.content.res.XmlResourceParser xml = context.getResources().getXml(i_renamed);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    java.lang.String name = xml.getName();
                    androidx.constraintlayout.widget.c_renamed.a_renamed aVarA = a_renamed(context, android.util.Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        aVarA.f762a = true;
                    }
                    this.f761b.put(java.lang.Integer.valueOf(aVarA.d_renamed), aVarA);
                }
            }
        } catch (java.io.IOException e_renamed) {
            e_renamed.printStackTrace();
        } catch (org.xmlpull.v1.XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    private static int a_renamed(android.content.res.TypedArray typedArray, int i_renamed, int i2) {
        int resourceId = typedArray.getResourceId(i_renamed, i2);
        return resourceId == -1 ? typedArray.getInt(i_renamed, -1) : resourceId;
    }

    private androidx.constraintlayout.widget.c_renamed.a_renamed a_renamed(android.content.Context context, android.util.AttributeSet attributeSet) {
        androidx.constraintlayout.widget.c_renamed.a_renamed aVar = new androidx.constraintlayout.widget.c_renamed.a_renamed();
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.R_renamed.styleable.ConstraintSet);
        a_renamed(aVar, typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        return aVar;
    }

    private void a_renamed(androidx.constraintlayout.widget.c_renamed.a_renamed aVar, android.content.res.TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i_renamed = 0; i_renamed < indexCount; i_renamed++) {
            int index = typedArray.getIndex(i_renamed);
            int i2 = f760c.get(index);
            switch (i2) {
                case 1:
                    aVar.p_renamed = a_renamed(typedArray, index, aVar.p_renamed);
                    break;
                case 2:
                    aVar.G_renamed = typedArray.getDimensionPixelSize(index, aVar.G_renamed);
                    break;
                case 3:
                    aVar.o_renamed = a_renamed(typedArray, index, aVar.o_renamed);
                    break;
                case 4:
                    aVar.n_renamed = a_renamed(typedArray, index, aVar.n_renamed);
                    break;
                case 5:
                    aVar.w_renamed = typedArray.getString(index);
                    break;
                case 6:
                    aVar.A_renamed = typedArray.getDimensionPixelOffset(index, aVar.A_renamed);
                    break;
                case 7:
                    aVar.B_renamed = typedArray.getDimensionPixelOffset(index, aVar.B_renamed);
                    break;
                case 8:
                    aVar.H_renamed = typedArray.getDimensionPixelSize(index, aVar.H_renamed);
                    break;
                case 9:
                    aVar.t_renamed = a_renamed(typedArray, index, aVar.t_renamed);
                    break;
                case 10:
                    aVar.s_renamed = a_renamed(typedArray, index, aVar.s_renamed);
                    break;
                case 11:
                    aVar.N_renamed = typedArray.getDimensionPixelSize(index, aVar.N_renamed);
                    break;
                case 12:
                    aVar.O_renamed = typedArray.getDimensionPixelSize(index, aVar.O_renamed);
                    break;
                case 13:
                    aVar.K_renamed = typedArray.getDimensionPixelSize(index, aVar.K_renamed);
                    break;
                case 14:
                    aVar.M_renamed = typedArray.getDimensionPixelSize(index, aVar.M_renamed);
                    break;
                case 15:
                    aVar.P_renamed = typedArray.getDimensionPixelSize(index, aVar.P_renamed);
                    break;
                case 16:
                    aVar.L_renamed = typedArray.getDimensionPixelSize(index, aVar.L_renamed);
                    break;
                case 17:
                    aVar.e_renamed = typedArray.getDimensionPixelOffset(index, aVar.e_renamed);
                    break;
                case 18:
                    aVar.f_renamed = typedArray.getDimensionPixelOffset(index, aVar.f_renamed);
                    break;
                case 19:
                    aVar.g_renamed = typedArray.getFloat(index, aVar.g_renamed);
                    break;
                case 20:
                    aVar.u_renamed = typedArray.getFloat(index, aVar.u_renamed);
                    break;
                case 21:
                    aVar.f764c = typedArray.getLayoutDimension(index, aVar.f764c);
                    break;
                case 22:
                    aVar.J_renamed = typedArray.getInt(index, aVar.J_renamed);
                    aVar.J_renamed = f759a[aVar.J_renamed];
                    break;
                case 23:
                    aVar.f763b = typedArray.getLayoutDimension(index, aVar.f763b);
                    break;
                case 24:
                    aVar.D_renamed = typedArray.getDimensionPixelSize(index, aVar.D_renamed);
                    break;
                case 25:
                    aVar.h_renamed = a_renamed(typedArray, index, aVar.h_renamed);
                    break;
                case 26:
                    aVar.i_renamed = a_renamed(typedArray, index, aVar.i_renamed);
                    break;
                case 27:
                    aVar.C_renamed = typedArray.getInt(index, aVar.C_renamed);
                    break;
                case 28:
                    aVar.E_renamed = typedArray.getDimensionPixelSize(index, aVar.E_renamed);
                    break;
                case 29:
                    aVar.j_renamed = a_renamed(typedArray, index, aVar.j_renamed);
                    break;
                case 30:
                    aVar.k_renamed = a_renamed(typedArray, index, aVar.k_renamed);
                    break;
                case 31:
                    aVar.I_renamed = typedArray.getDimensionPixelSize(index, aVar.I_renamed);
                    break;
                case 32:
                    aVar.q_renamed = a_renamed(typedArray, index, aVar.q_renamed);
                    break;
                case 33:
                    aVar.r_renamed = a_renamed(typedArray, index, aVar.r_renamed);
                    break;
                case 34:
                    aVar.F_renamed = typedArray.getDimensionPixelSize(index, aVar.F_renamed);
                    break;
                case 35:
                    aVar.m_renamed = a_renamed(typedArray, index, aVar.m_renamed);
                    break;
                case 36:
                    aVar.l_renamed = a_renamed(typedArray, index, aVar.l_renamed);
                    break;
                case 37:
                    aVar.v_renamed = typedArray.getFloat(index, aVar.v_renamed);
                    break;
                case 38:
                    aVar.d_renamed = typedArray.getResourceId(index, aVar.d_renamed);
                    break;
                case 39:
                    aVar.R_renamed = typedArray.getFloat(index, aVar.R_renamed);
                    break;
                case 40:
                    aVar.Q_renamed = typedArray.getFloat(index, aVar.Q_renamed);
                    break;
                case 41:
                    aVar.S_renamed = typedArray.getInt(index, aVar.S_renamed);
                    break;
                case 42:
                    aVar.T_renamed = typedArray.getInt(index, aVar.T_renamed);
                    break;
                case 43:
                    aVar.U_renamed = typedArray.getFloat(index, aVar.U_renamed);
                    break;
                case 44:
                    aVar.V_renamed = true;
                    aVar.W_renamed = typedArray.getDimension(index, aVar.W_renamed);
                    break;
                case 45:
                    aVar.Y_renamed = typedArray.getFloat(index, aVar.Y_renamed);
                    break;
                case 46:
                    aVar.Z_renamed = typedArray.getFloat(index, aVar.Z_renamed);
                    break;
                case 47:
                    aVar.aa_renamed = typedArray.getFloat(index, aVar.aa_renamed);
                    break;
                case 48:
                    aVar.ab_renamed = typedArray.getFloat(index, aVar.ab_renamed);
                    break;
                case 49:
                    aVar.ac_renamed = typedArray.getFloat(index, aVar.ac_renamed);
                    break;
                case 50:
                    aVar.ad_renamed = typedArray.getFloat(index, aVar.ad_renamed);
                    break;
                case 51:
                    aVar.ae_renamed = typedArray.getDimension(index, aVar.ae_renamed);
                    break;
                case 52:
                    aVar.af_renamed = typedArray.getDimension(index, aVar.af_renamed);
                    break;
                case 53:
                    aVar.ag_renamed = typedArray.getDimension(index, aVar.ag_renamed);
                    break;
                default:
                    switch (i2) {
                        case 60:
                            aVar.X_renamed = typedArray.getFloat(index, aVar.X_renamed);
                            break;
                        case 61:
                            aVar.x_renamed = a_renamed(typedArray, index, aVar.x_renamed);
                            break;
                        case 62:
                            aVar.y_renamed = typedArray.getDimensionPixelSize(index, aVar.y_renamed);
                            break;
                        case 63:
                            aVar.z_renamed = typedArray.getFloat(index, aVar.z_renamed);
                            break;
                        default:
                            switch (i2) {
                                case 69:
                                    aVar.ap_renamed = typedArray.getFloat(index, 1.0f);
                                    break;
                                case 70:
                                    aVar.aq_renamed = typedArray.getFloat(index, 1.0f);
                                    break;
                                case 71:
                                    android.util.Log.e_renamed("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                    break;
                                case 72:
                                    aVar.as_renamed = typedArray.getInt(index, aVar.as_renamed);
                                    break;
                                case 73:
                                    aVar.av_renamed = typedArray.getString(index);
                                    break;
                                case 74:
                                    aVar.ar_renamed = typedArray.getBoolean(index, aVar.ar_renamed);
                                    break;
                                case 75:
                                    android.util.Log.w_renamed("ConstraintSet", "unused attribute 0x" + java.lang.Integer.toHexString(index) + "   " + f760c.get(index));
                                    break;
                                default:
                                    android.util.Log.w_renamed("ConstraintSet", "Unknown attribute 0x" + java.lang.Integer.toHexString(index) + "   " + f760c.get(index));
                                    break;
                            }
                    }
            }
        }
    }

    private int[] a_renamed(android.view.View view, java.lang.String str) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        int iIntValue;
        java.lang.Object objA;
        java.lang.String[] strArrSplit = str.split(",");
        android.content.Context context = view.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i_renamed = 0;
        int i2 = 0;
        while (i_renamed < strArrSplit.length) {
            java.lang.String strTrim = strArrSplit[i_renamed].trim();
            try {
                iIntValue = androidx.constraintlayout.widget.R_renamed.id_renamed.class.getField(strTrim).getInt(null);
            } catch (java.lang.Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, com.google.android.exoplayer2.text.ttml.TtmlNode.ATTR_ID, context.getPackageName());
            }
            if (iIntValue == 0 && view.isInEditMode() && (view.getParent() instanceof androidx.constraintlayout.widget.ConstraintLayout) && (objA = ((androidx.constraintlayout.widget.ConstraintLayout) view.getParent()).a_renamed(0, strTrim)) != null && (objA instanceof java.lang.Integer)) {
                iIntValue = ((java.lang.Integer) objA).intValue();
            }
            iArr[i2] = iIntValue;
            i_renamed++;
            i2++;
        }
        return i2 != strArrSplit.length ? java.util.Arrays.copyOf(iArr, i2) : iArr;
    }
}
