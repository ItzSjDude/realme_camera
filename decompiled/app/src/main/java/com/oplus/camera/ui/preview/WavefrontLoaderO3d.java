package com.oplus.camera.ui.preview;

/* compiled from: FocusManager.java */
/* loaded from: classes2.dex */
public class o_renamed implements com.oplus.camera.d_renamed, com.oplus.camera.ui.preview.s_renamed {
    private com.oplus.camera.ui.preview.f_renamed A_renamed;
    private com.oplus.camera.ComboPreferences B_renamed;
    private android.app.Activity n_renamed;
    private android.os.Handler t_renamed;
    private int g_renamed = 0;
    private boolean h_renamed = false;
    private boolean i_renamed = false;
    private boolean j_renamed = false;
    private boolean k_renamed = false;
    private boolean l_renamed = false;
    private boolean m_renamed = false;
    private com.oplus.camera.ui.preview.FaceView o_renamed = null;
    private com.oplus.camera.ui.preview.ac_renamed p_renamed = null;
    private com.oplus.camera.ui.preview.MultiFocusView q_renamed = null;
    private com.oplus.camera.ui.preview.n_renamed r_renamed = null;
    private boolean s_renamed = false;
    private int u_renamed = -1;
    private int v_renamed = 1;
    private int w_renamed = 90;
    private int x_renamed = 0;
    private int y_renamed = 0;
    private int z_renamed = 0;
    private int C_renamed = 4;
    private int D_renamed = 0;
    private boolean E_renamed = false;
    private boolean F_renamed = false;
    private boolean G_renamed = false;
    private java.lang.String H_renamed = "normal";
    private float I_renamed = 0.0f;
    private float J_renamed = 0.0f;
    private float K_renamed = 0.0f;
    private float L_renamed = 0.0f;
    private int M_renamed = 0;
    private int N_renamed = 0;
    private int O_renamed = 0;
    private int P_renamed = 0;
    private boolean Q_renamed = false;
    private boolean R_renamed = false;
    private boolean S_renamed = false;
    private boolean T_renamed = false;
    private android.graphics.Rect U_renamed = null;
    private android.graphics.Rect V_renamed = null;
    private android.util.Size W_renamed = null;

    public o_renamed(android.app.Activity activity, com.oplus.camera.ComboPreferences comboPreferences, com.oplus.camera.ui.preview.f_renamed fVar) {
        this.n_renamed = null;
        this.t_renamed = null;
        this.A_renamed = null;
        this.B_renamed = null;
        this.n_renamed = activity;
        this.B_renamed = comboPreferences;
        this.t_renamed = new com.oplus.camera.ui.preview.o_renamed.a_renamed(this.n_renamed.getMainLooper());
        this.A_renamed = fVar;
    }

    public void a_renamed() {
        this.o_renamed = (com.oplus.camera.ui.preview.FaceView) this.n_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.face_view);
        this.q_renamed = (com.oplus.camera.ui.preview.MultiFocusView) this.n_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.multi_focus_view);
    }

    public void b_renamed() {
        this.H_renamed = this.B_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER, this.n_renamed.getString(com.oplus.camera.R_renamed.string.camera_shutter_mode_default_value));
    }

    public void c_renamed() {
        com.oplus.camera.ui.preview.FaceView faceView = this.o_renamed;
        if (faceView != null) {
            faceView.d_renamed();
        }
    }

    public void d_renamed() {
        this.m_renamed = false;
        k_renamed(false);
        r_renamed();
        k_renamed();
    }

    public void e_renamed() {
        this.n_renamed = null;
        this.o_renamed = null;
        this.p_renamed = null;
        this.q_renamed = null;
        this.A_renamed = null;
        android.os.Handler handler = this.t_renamed;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.t_renamed = null;
        }
        com.oplus.camera.ui.preview.n_renamed nVar = this.r_renamed;
        if (nVar != null) {
            nVar.e_renamed();
            this.r_renamed = null;
        }
    }

    public void f_renamed() {
        if (this.r_renamed == null) {
            this.r_renamed = new com.oplus.camera.ui.preview.n_renamed(this.n_renamed, null);
            this.r_renamed.setVisibility(8);
            android.view.ViewGroup.LayoutParams layoutParams = new android.view.ViewGroup.LayoutParams(-1, -1);
            com.oplus.camera.ui.preview.PreviewFrameLayout previewFrameLayout = (com.oplus.camera.ui.preview.PreviewFrameLayout) this.n_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.frame_layout);
            if (previewFrameLayout != null) {
                previewFrameLayout.addView(this.r_renamed, layoutParams);
            }
            this.r_renamed.setFocusManager(this);
            this.r_renamed.a_renamed(this.y_renamed, this.z_renamed);
            this.r_renamed.a_renamed(this.O_renamed, false);
            com.oplus.camera.e_renamed.b_renamed("FocusManager", "initFocusExposureIndicator, previewFrameLayout: " + previewFrameLayout);
        }
    }

    private void P_renamed() {
        if (this.p_renamed == null) {
            this.p_renamed = new com.oplus.camera.ui.preview.ac_renamed(this.n_renamed);
            this.p_renamed.setId(com.oplus.camera.R_renamed.id_renamed.track_focus_view);
            android.view.ViewGroup.LayoutParams layoutParams = new android.view.ViewGroup.LayoutParams(-1, -1);
            com.oplus.camera.ui.preview.PreviewFrameLayout previewFrameLayout = (com.oplus.camera.ui.preview.PreviewFrameLayout) this.n_renamed.findViewById(com.oplus.camera.R_renamed.id_renamed.frame_layout);
            if (previewFrameLayout != null) {
                previewFrameLayout.addView(this.p_renamed, layoutParams);
            }
            this.p_renamed.a_renamed(this.U_renamed, this.V_renamed, this.W_renamed, new android.util.Size(this.y_renamed, this.z_renamed));
            this.p_renamed.setVisibility(8);
            this.p_renamed.setFocusManager(this);
            this.p_renamed.a_renamed(this.O_renamed, false);
            this.p_renamed.setDisplayOrientation(this.w_renamed);
        }
        com.oplus.camera.ui.preview.f_renamed fVar = this.A_renamed;
        if (fVar != null) {
            this.p_renamed.setRearMirrorEnable(fVar.d_renamed());
        }
    }

    public void a_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("FocusManager", "initialized");
        this.j_renamed = true;
        b_renamed(z_renamed);
    }

    public void a_renamed(int i_renamed) {
        this.v_renamed = i_renamed;
    }

    public void a_renamed(int i_renamed, int i2) {
        if (this.y_renamed != i_renamed || this.z_renamed != i2) {
            this.y_renamed = i_renamed;
            this.z_renamed = i2;
        }
        com.oplus.camera.ui.preview.n_renamed nVar = this.r_renamed;
        if (nVar != null) {
            nVar.a_renamed(i_renamed, i2);
        }
    }

    public void b_renamed(boolean z_renamed) {
        this.k_renamed = z_renamed;
    }

    public void b_renamed(int i_renamed) {
        com.oplus.camera.ui.preview.n_renamed nVar = this.r_renamed;
        if (nVar != null) {
            nVar.a_renamed(i_renamed, true);
        }
        com.oplus.camera.ui.preview.ac_renamed acVar = this.p_renamed;
        if (acVar != null) {
            acVar.a_renamed(i_renamed, true);
        }
        this.O_renamed = i_renamed;
    }

    public void c_renamed(int i_renamed) {
        this.w_renamed = i_renamed;
    }

    public void a_renamed(int i_renamed, int i2, int[] iArr, int i3, int i4) {
        if ((this.D_renamed != i_renamed || 1 == i_renamed) && this.n_renamed != null) {
            if (i2 != 1 && 1 == this.x_renamed) {
                com.oplus.camera.e_renamed.a_renamed("FocusManager", "updateFocusState, af_renamed is_renamed focusing, so discard caf state");
                return;
            }
            boolean z_renamed = this.D_renamed == i_renamed;
            this.D_renamed = i_renamed;
            this.T_renamed = i2 != this.C_renamed;
            this.C_renamed = i2;
            this.G_renamed = false;
            if (iArr != null) {
                this.G_renamed = iArr[0] == 1;
            }
            this.E_renamed = 1 == i4;
            if (!this.G_renamed || 1 != i_renamed) {
                this.F_renamed = !this.E_renamed && 1 == i_renamed;
            }
            com.oplus.camera.e_renamed.a_renamed("FocusManager", "updateFocusState, state: " + i_renamed + ", mode: " + i2 + ", isPdaf: " + this.G_renamed + ", mbPdafConvergeDone: " + this.E_renamed + ", mbAfMoving: " + this.F_renamed);
            if (i3 == 0 || i3 == 3 || i3 == 4 || i3 == 5) {
                com.oplus.camera.e_renamed.a_renamed("FocusManager", "updateFocusState, return, cameraState: " + i3);
                return;
            }
            if (z_renamed) {
                if (this.m_renamed && this.E_renamed) {
                    com.oplus.camera.e_renamed.a_renamed("FocusManager", "updateFocusState, on_renamed AF status converged");
                    this.t_renamed.removeMessages(12);
                    this.t_renamed.sendEmptyMessage(12);
                    return;
                }
                return;
            }
            this.t_renamed.removeMessages(10);
            this.t_renamed.sendEmptyMessage(10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q_renamed() {
        int i_renamed = this.D_renamed;
        switch (i_renamed) {
            case 1:
                l_renamed(this.G_renamed);
                break;
            case 2:
                a_renamed(this.C_renamed, i_renamed, true, this.G_renamed, false);
                break;
            case 3:
                if (this.T_renamed) {
                    com.oplus.camera.ui.preview.n_renamed nVar = this.r_renamed;
                    if (nVar != null && nVar.getVisibility() == 0) {
                        this.r_renamed.c_renamed(false);
                    }
                    this.T_renamed = false;
                    break;
                }
                break;
            case 4:
                if (3 == this.x_renamed) {
                    com.oplus.camera.e_renamed.e_renamed("FocusManager", "onFocusStateUpdate, af_renamed focused receive again");
                    break;
                } else {
                    if (2 == this.g_renamed && A_renamed()) {
                        this.A_renamed.c_renamed(true, true);
                    } else if (1 == this.g_renamed && O_renamed()) {
                        if (this.D_renamed == 4 && this.C_renamed == 1) {
                            d_renamed(3);
                        }
                        v_renamed();
                        com.oplus.camera.ui.preview.f_renamed fVar = this.A_renamed;
                        if (fVar != null) {
                            fVar.s_renamed();
                            a_renamed(T_renamed());
                            break;
                        }
                    }
                    a_renamed(this.C_renamed, this.D_renamed, false, this.G_renamed, true);
                    L_renamed();
                    break;
                }
                break;
            case 5:
                if (2 == this.g_renamed && A_renamed()) {
                    this.A_renamed.c_renamed(true, true);
                } else if (1 == this.g_renamed && O_renamed()) {
                    v_renamed();
                    com.oplus.camera.ui.preview.f_renamed fVar2 = this.A_renamed;
                    if (fVar2 != null) {
                        fVar2.s_renamed();
                        a_renamed(T_renamed());
                        break;
                    }
                }
                a_renamed(this.C_renamed, false, this.G_renamed, true);
                L_renamed();
                break;
            case 6:
                a_renamed(this.C_renamed, true, this.G_renamed, false);
                break;
        }
    }

    private void l_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("FocusManager", "onFocusStart");
        com.oplus.camera.ui.preview.FaceView faceView = this.o_renamed;
        if (faceView == null || !faceView.a_renamed()) {
            com.oplus.camera.ui.preview.MultiFocusView multiFocusView = this.q_renamed;
            if (multiFocusView == null || !multiFocusView.f_renamed()) {
                com.oplus.camera.ui.preview.f_renamed fVar = this.A_renamed;
                if ((fVar == null || !fVar.o_renamed()) && !this.R_renamed) {
                    if (z_renamed || this.S_renamed) {
                        if (this.S_renamed && I_renamed()) {
                            return;
                        }
                        v_renamed();
                        return;
                    }
                    f_renamed();
                    this.r_renamed.setAlpha(1.0f);
                    this.r_renamed.c_renamed();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(int i_renamed, int i2, boolean z_renamed, boolean z2, boolean z3) {
        com.oplus.camera.e_renamed.a_renamed("FocusManager", "onFocusSuccess, mode: " + i_renamed + ", mExposureState: " + this.u_renamed);
        if (i2 == 4 && i_renamed == 1) {
            d_renamed(3);
        }
        g_renamed();
        com.oplus.camera.ui.preview.FaceView faceView = this.o_renamed;
        if (faceView == null || !faceView.a_renamed()) {
            com.oplus.camera.ui.preview.MultiFocusView multiFocusView = this.q_renamed;
            if (multiFocusView == null || !multiFocusView.f_renamed()) {
                com.oplus.camera.ui.preview.f_renamed fVar = this.A_renamed;
                if (fVar == null || !fVar.o_renamed()) {
                    com.oplus.camera.ui.preview.n_renamed nVar = this.r_renamed;
                    if (nVar == null || nVar.getVisibility() == 0) {
                        if (z2 || this.S_renamed) {
                            if (z3) {
                                return;
                            }
                            v_renamed();
                        } else {
                            f_renamed();
                            this.r_renamed.setAlpha(1.0f);
                            this.r_renamed.a_renamed(z_renamed, z3, this.u_renamed != -1);
                            if (this.R_renamed) {
                                this.r_renamed.setVisibility(8);
                            }
                        }
                    }
                }
            }
        }
    }

    private void a_renamed(int i_renamed, boolean z_renamed, boolean z2, boolean z3) {
        com.oplus.camera.e_renamed.a_renamed("FocusManager", "onFocusFail, mode: " + i_renamed);
        g_renamed();
        com.oplus.camera.ui.preview.FaceView faceView = this.o_renamed;
        if (faceView == null || !faceView.a_renamed()) {
            com.oplus.camera.ui.preview.MultiFocusView multiFocusView = this.q_renamed;
            if (multiFocusView == null || !multiFocusView.f_renamed()) {
                com.oplus.camera.ui.preview.f_renamed fVar = this.A_renamed;
                if (fVar == null) {
                    com.oplus.camera.e_renamed.a_renamed("FocusManager", "onFocusFail, mCameraFocusListener is_renamed null");
                    return;
                }
                if ((fVar == null || !fVar.o_renamed()) && !this.R_renamed) {
                    com.oplus.camera.ui.preview.n_renamed nVar = this.r_renamed;
                    if (nVar == null || nVar.getVisibility() == 0) {
                        if (z2 || this.S_renamed) {
                            if (z3) {
                                return;
                            }
                            v_renamed();
                        } else {
                            f_renamed();
                            this.r_renamed.setAlpha(1.0f);
                            this.r_renamed.b_renamed(z_renamed, this.u_renamed != -1);
                        }
                    }
                }
            }
        }
    }

    public boolean g_renamed() {
        android.os.Handler handler = this.t_renamed;
        if (handler == null || !handler.hasMessages(5)) {
            return false;
        }
        this.t_renamed.removeMessages(9);
        this.t_renamed.removeMessages(5);
        m_renamed(false);
        return true;
    }

    public void a_renamed(android.content.SharedPreferences sharedPreferences, java.lang.String str) {
        if (com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER.equals(com.oplus.camera.entry.b_renamed.d_renamed(str))) {
            java.lang.String string = sharedPreferences.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER, this.n_renamed.getString(com.oplus.camera.R_renamed.string.camera_shutter_mode_default_value));
            if (string.equals(this.H_renamed)) {
                return;
            }
            this.H_renamed = string;
        }
    }

    public boolean h_renamed() {
        com.oplus.camera.ui.preview.f_renamed fVar;
        android.app.Activity activity = this.n_renamed;
        return (activity == null || !this.B_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TAP_SHUTTER, activity.getString(com.oplus.camera.R_renamed.string.camera_tap_shutter_default_value)).equals("on_renamed") || (fVar = this.A_renamed) == null || !fVar.j_renamed() || this.A_renamed.n_renamed() || this.v_renamed == 3 || !this.l_renamed || 2 == this.g_renamed || this.A_renamed.v_renamed() || !this.A_renamed.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TAP_SHUTTER)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("FocusManager", "doCapture, mAfFocusState: " + this.D_renamed);
        if (this.A_renamed.v_renamed()) {
            return;
        }
        if (!this.j_renamed || com.oplus.camera.Storage.w_renamed != 0) {
            this.A_renamed.b_renamed(true, false);
            this.A_renamed.b_renamed(false);
            return;
        }
        d_renamed(2);
        this.A_renamed.a_renamed(z_renamed);
        this.A_renamed.b_renamed(false);
        this.m_renamed = false;
        d_renamed(0);
        this.t_renamed.removeMessages(1);
    }

    public boolean c_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("FocusManager", "checkStateBeforeCapture, isAISSnapshot: " + z_renamed);
        if (!e_renamed(z_renamed)) {
            return false;
        }
        d_renamed(z_renamed);
        return true;
    }

    public void d_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("FocusManager", "delayCapture, isAISSnapshot: " + z_renamed);
        d_renamed(4);
        android.os.Handler handler = this.t_renamed;
        if (handler != null) {
            handler.removeMessages(5);
            if (z_renamed) {
                this.t_renamed.sendEmptyMessageDelayed(5, 240L);
            } else {
                this.t_renamed.sendEmptyMessageDelayed(5, com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
            }
            this.m_renamed = true;
        }
    }

    public boolean e_renamed(boolean z_renamed) {
        android.os.Handler handler;
        if (x_renamed() && (handler = this.t_renamed) != null && handler.hasMessages(6)) {
            this.t_renamed.removeMessages(6);
            this.t_renamed.sendEmptyMessageDelayed(6, 3000L);
        }
        return h_renamed(z_renamed);
    }

    public void i_renamed() {
        com.oplus.camera.ui.preview.f_renamed fVar = this.A_renamed;
        if (fVar != null) {
            fVar.b_renamed(false);
        }
        android.os.Handler handler = this.t_renamed;
        if (handler != null) {
            handler.removeMessages(5);
            this.m_renamed = false;
            if (4 == this.x_renamed) {
                d_renamed(0);
            }
        }
    }

    public void d_renamed(int i_renamed) {
        com.oplus.camera.e_renamed.a_renamed("FocusManager", "setFocusState(), mFocusState: " + this.x_renamed + "=>" + i_renamed);
        this.x_renamed = i_renamed;
    }

    public void j_renamed() {
        com.oplus.camera.e_renamed.a_renamed("FocusManager", "checkFocusStateBeforeCapture, mFocusState: " + this.x_renamed);
        if (C_renamed() && n_renamed() == 1 && this.x_renamed == 1) {
            l_renamed();
        }
    }

    private boolean R_renamed() {
        return this.A_renamed.c_renamed() && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SAT_ULTRAWIDE_FOCUS_SUPPORT);
    }

    public void e_renamed(int i_renamed) {
        this.g_renamed = i_renamed;
    }

    public void a_renamed(int i_renamed, int i2, boolean z_renamed) {
        int i3 = i_renamed;
        if (!this.j_renamed || this.x_renamed == 2 || this.A_renamed == null) {
            com.oplus.camera.e_renamed.b_renamed("FocusManager", "onSingleTapUp, mbInitialized: " + this.j_renamed + ", mFocusState: " + this.x_renamed + ", mCameraFocusListener: " + this.A_renamed);
            return;
        }
        f_renamed();
        if (z_renamed) {
            this.A_renamed.b_renamed(i3, i2);
            this.r_renamed.e_renamed();
            this.u_renamed = -1;
        }
        com.oplus.camera.e_renamed.a_renamed("FocusManager", "onSingleTapUp, fromUserTouch: " + z_renamed + ", mTouchType" + this.g_renamed);
        this.l_renamed = z_renamed;
        if (!this.A_renamed.r_renamed() || R_renamed()) {
            if (h_renamed() && this.A_renamed.k_renamed()) {
                this.A_renamed.b_renamed(true);
                m_renamed(true);
                return;
            } else if (!this.A_renamed.q_renamed()) {
                com.oplus.camera.e_renamed.a_renamed("FocusManager", "onSingleTapUp(), camera not support touch ae_renamed");
                return;
            }
        }
        this.M_renamed = i3;
        this.N_renamed = i2;
        if (1 == n_renamed()) {
            this.A_renamed.t_renamed();
            m_renamed();
            this.l_renamed = z_renamed;
        }
        if (h_renamed() && this.A_renamed.k_renamed()) {
            this.A_renamed.b_renamed(true);
            this.A_renamed.b_renamed(false, true);
        }
        if (!this.A_renamed.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_TRACK_FOCUS)) {
            this.A_renamed.g_renamed();
        }
        this.A_renamed.i_renamed();
        this.r_renamed.b_renamed(i3, i2);
        if (this.A_renamed.r_renamed()) {
            this.t_renamed.removeMessages(6);
            if (this.l_renamed && x_renamed()) {
                this.t_renamed.sendEmptyMessageDelayed(6, 3000L);
            }
        }
        int exposureRectWidth = this.r_renamed.getExposureRectWidth();
        if (this.A_renamed.d_renamed()) {
            i3 = this.y_renamed - i3;
        }
        int i4 = exposureRectWidth / 2;
        int i5 = this.y_renamed;
        int i6 = this.z_renamed;
        android.graphics.RectF rectF = new android.graphics.RectF((i3 - i4) / i5, (i2 - i4) / i6, (i3 + i4) / i5, (i4 + i2) / i6);
        if (C_renamed()) {
            if (1 == this.g_renamed) {
                v_renamed();
                this.A_renamed.s_renamed();
                P_renamed();
                this.p_renamed.h_renamed();
                int i7 = this.M_renamed;
                float f_renamed = exposureRectWidth / 2.0f;
                int i8 = this.N_renamed;
                a_renamed(new android.graphics.RectF(i7 - f_renamed, i8 - f_renamed, i7 + f_renamed, i8 + f_renamed));
                a_renamed(rectF, rectF);
                V_renamed();
            } else {
                k_renamed(true);
                this.r_renamed.c_renamed();
                a_renamed(rectF, rectF);
            }
            if (h_renamed()) {
                d_renamed(false);
                return;
            }
            return;
        }
        k_renamed(true);
        this.r_renamed.c_renamed();
        android.graphics.Rect rectA = com.oplus.camera.a_renamed.a_renamed(i3, i2, this.y_renamed, this.z_renamed, exposureRectWidth, this.k_renamed, this.w_renamed, 0, this.A_renamed.z_renamed(), com.oplus.camera.a_renamed.e_renamed());
        this.A_renamed.a_renamed(rectA, com.oplus.camera.util.Util.t_renamed() ? rectA : null);
        if (2 == this.g_renamed) {
            n_renamed(true);
        }
        this.Q_renamed = false;
        o_renamed();
    }

    public void k_renamed() {
        d_renamed(0);
        p_renamed();
        if (this.S_renamed) {
            k_renamed(false);
        }
        this.Q_renamed = false;
        o_renamed();
    }

    private boolean S_renamed() {
        com.oplus.camera.ui.preview.f_renamed fVar;
        return this.k_renamed || ((fVar = this.A_renamed) != null && fVar.d_renamed());
    }

    private android.graphics.Rect T_renamed() {
        com.oplus.camera.ui.preview.n_renamed nVar = this.r_renamed;
        return com.oplus.camera.a_renamed.a_renamed(this.M_renamed, this.N_renamed, this.y_renamed, this.z_renamed, nVar != null ? nVar.getExposureRectWidth() : 0, S_renamed(), this.w_renamed, 0, this.A_renamed.z_renamed(), com.oplus.camera.a_renamed.d_renamed());
    }

    private void a_renamed(android.graphics.RectF rectF, android.graphics.RectF rectF2) {
        com.oplus.camera.e_renamed.a_renamed("FocusManager", "Start autofocus.");
        com.oplus.camera.ui.preview.FaceView faceView = this.o_renamed;
        if (faceView != null && !this.S_renamed) {
            faceView.c_renamed();
        }
        com.oplus.camera.ui.preview.MultiFocusView multiFocusView = this.q_renamed;
        if (multiFocusView != null) {
            multiFocusView.c_renamed();
        }
        if (x_renamed()) {
            this.Q_renamed = true;
        }
        this.A_renamed.a_renamed(1, rectF, rectF2);
        if (rectF2 != null && !this.A_renamed.c_renamed()) {
            this.A_renamed.a_renamed(b_renamed(rectF2));
        }
        if (rectF != null && !this.A_renamed.c_renamed()) {
            this.A_renamed.b_renamed(b_renamed(rectF));
        }
        d_renamed(1);
        o_renamed();
        this.t_renamed.removeMessages(1);
    }

    private android.hardware.camera2.params.MeteringRectangle[] b_renamed(android.graphics.RectF rectF) {
        if (rectF == null) {
            return null;
        }
        com.oplus.camera.ui.preview.n_renamed nVar = this.r_renamed;
        int exposureRectWidth = nVar != null ? nVar.getExposureRectWidth() : 0;
        float fCenterX = this.y_renamed * rectF.centerX();
        float fCenterY = rectF.centerY();
        int i_renamed = this.z_renamed;
        android.graphics.Rect rectA = com.oplus.camera.a_renamed.a_renamed(fCenterX, fCenterY * i_renamed, this.y_renamed, i_renamed, exposureRectWidth, this.k_renamed, this.w_renamed, this.O_renamed, this.A_renamed.z_renamed(), com.oplus.camera.a_renamed.e_renamed());
        if (b_renamed(rectA)) {
            return new android.hardware.camera2.params.MeteringRectangle[]{new android.hardware.camera2.params.MeteringRectangle(rectA, com.oplus.camera.a_renamed.e_renamed())};
        }
        return null;
    }

    private boolean b_renamed(android.graphics.Rect rect) {
        return rect != null && rect.left >= 0 && rect.right >= 0 && rect.top >= 0 && rect.bottom >= 0;
    }

    public void l_renamed() {
        com.oplus.camera.e_renamed.a_renamed("FocusManager", "resetAutoFocusMode");
        this.g_renamed = 0;
        com.oplus.camera.ui.preview.f_renamed fVar = this.A_renamed;
        if (fVar != null) {
            fVar.s_renamed();
        }
        m_renamed();
    }

    public void m_renamed() {
        com.oplus.camera.e_renamed.a_renamed("FocusManager", "resetCameraFocusState()");
        p_renamed();
        if (this.S_renamed) {
            k_renamed(false);
        }
        if (this.o_renamed != null && !this.A_renamed.n_renamed()) {
            this.o_renamed.d_renamed();
        }
        com.oplus.camera.ui.preview.MultiFocusView multiFocusView = this.q_renamed;
        if (multiFocusView != null) {
            multiFocusView.d_renamed();
        }
        d_renamed(0);
        android.os.Handler handler = this.t_renamed;
        if (handler != null) {
            handler.removeMessages(1);
        }
    }

    public int n_renamed() {
        return this.A_renamed.w_renamed();
    }

    public void o_renamed() {
        com.oplus.camera.ui.preview.m_renamed mVar;
        if (this.j_renamed) {
            f_renamed();
            com.oplus.camera.ui.preview.FaceView faceView = this.o_renamed;
            boolean z_renamed = faceView != null && faceView.a_renamed();
            com.oplus.camera.ui.preview.MultiFocusView multiFocusView = this.q_renamed;
            boolean z2 = multiFocusView != null && multiFocusView.f_renamed();
            if (z_renamed) {
                mVar = this.o_renamed;
            } else if (z2) {
                mVar = this.q_renamed;
            } else {
                mVar = this.r_renamed;
            }
            boolean z3 = !this.l_renamed;
            android.os.Handler handler = this.t_renamed;
            if (handler != null) {
                handler.removeMessages(7);
            }
            this.r_renamed.setAlpha(1.0f);
            int i_renamed = this.C_renamed;
            if (4 == i_renamed || (3 == i_renamed && !this.S_renamed)) {
                mVar.a_renamed(z3, this.u_renamed != -1);
            }
            if (!this.l_renamed || this.t_renamed == null) {
                return;
            }
            boolean zM = this.A_renamed.m_renamed();
            com.oplus.camera.e_renamed.a_renamed("FocusManager", "updateFocusUI, isFixedFocusMode: " + zM + " mbNeedLockAF: " + this.Q_renamed);
            if (!zM && !this.Q_renamed) {
                this.t_renamed.removeMessages(6);
                this.t_renamed.sendEmptyMessageDelayed(6, 3000L);
            }
            this.t_renamed.removeMessages(7);
            this.t_renamed.removeMessages(8);
            if (zM) {
                this.t_renamed.sendEmptyMessageDelayed(7, 1000L);
                this.s_renamed = true;
            }
            this.r_renamed.c_renamed(true);
        }
    }

    public void p_renamed() {
        if (!this.j_renamed) {
            com.oplus.camera.e_renamed.b_renamed("FocusManager", "resetTouchFocusUi, initialize is_renamed not completed, abort!");
            return;
        }
        this.l_renamed = false;
        android.app.Activity activity = this.n_renamed;
        if (activity != null) {
            activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.o_renamed.1
                @Override // java.lang.Runnable
                public void run() {
                    if (com.oplus.camera.ui.preview.o_renamed.this.r_renamed != null) {
                        com.oplus.camera.ui.preview.o_renamed.this.r_renamed.e_renamed();
                    }
                    com.oplus.camera.ui.preview.o_renamed.this.u_renamed = -1;
                }
            });
        }
    }

    public void q_renamed() {
        android.os.Handler handler = this.t_renamed;
        if (handler != null) {
            handler.removeMessages(6);
            this.t_renamed.removeMessages(7);
            this.t_renamed.removeMessages(8);
        }
    }

    public void r_renamed() {
        this.t_renamed.removeMessages(1);
        this.t_renamed.removeMessages(5);
        this.t_renamed.removeCallbacksAndMessages(null);
    }

    @Override // com.oplus.camera.ui.preview.s_renamed
    public boolean s_renamed() {
        return (!E_renamed() || this.h_renamed) && (!C_renamed() || this.i_renamed);
    }

    public boolean t_renamed() {
        com.oplus.camera.ui.preview.n_renamed nVar = this.r_renamed;
        return nVar != null && nVar.getVisibility() == 0;
    }

    public boolean u_renamed() {
        com.oplus.camera.ui.preview.n_renamed nVar = this.r_renamed;
        return nVar != null && nVar.b_renamed();
    }

    public void f_renamed(boolean z_renamed) {
        this.i_renamed = z_renamed;
        this.h_renamed = z_renamed;
        android.app.Activity activity = this.n_renamed;
        if (activity != null) {
            activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.-$$Lambda$o_renamed$bMMSUhXmWaBaEHuDAY9eCTOIb5Q
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.W_renamed();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W_renamed() {
        com.oplus.camera.ui.preview.n_renamed nVar = this.r_renamed;
        if (nVar != null && nVar.getVisibility() == 0) {
            this.r_renamed.a_renamed(this.i_renamed);
        }
        com.oplus.camera.ui.preview.ac_renamed acVar = this.p_renamed;
        if (acVar == null || acVar.getVisibility() != 0) {
            return;
        }
        this.p_renamed.setLockState(this.h_renamed);
    }

    public void v_renamed() {
        android.app.Activity activity = this.n_renamed;
        if (activity != null) {
            activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.o_renamed.2
                @Override // java.lang.Runnable
                public void run() {
                    if (com.oplus.camera.ui.preview.o_renamed.this.r_renamed != null) {
                        com.oplus.camera.ui.preview.o_renamed.this.r_renamed.e_renamed();
                        if (com.oplus.camera.ui.preview.o_renamed.this.S_renamed && 1 == com.oplus.camera.ui.preview.o_renamed.this.u_renamed) {
                            return;
                        }
                        com.oplus.camera.ui.preview.o_renamed.this.u_renamed = -1;
                    }
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:119:0x01ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a_renamed(android.view.MotionEvent r15) {
        /*
            Method dump skipped, instructions count: 477
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.preview.o_renamed.a_renamed(android.view.MotionEvent):boolean");
    }

    private void d_renamed(float f_renamed) {
        com.oplus.camera.ui.preview.f_renamed fVar = this.A_renamed;
        if (fVar != null) {
            int iX = fVar.x_renamed();
            int iY = this.A_renamed.y_renamed();
            if (iX == 0 && iY == 0) {
                return;
            }
            this.A_renamed.a_renamed((int) (iY + ((iX - iY) * f_renamed)));
        }
    }

    public boolean w_renamed() {
        return this.u_renamed > 0;
    }

    public void g_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("FocusManager", "disableFocusIndicator, disable: " + z_renamed);
        com.oplus.camera.ui.preview.n_renamed nVar = this.r_renamed;
        if (nVar != null) {
            nVar.e_renamed(z_renamed);
        }
    }

    public boolean x_renamed() {
        return (this.A_renamed == null || (this.B_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TAP_SHUTTER, this.n_renamed.getString(com.oplus.camera.R_renamed.string.camera_tap_shutter_default_value)).equals("on_renamed") && this.A_renamed.j_renamed() && this.A_renamed.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_TAP_SHUTTER)) || !this.A_renamed.u_renamed() || this.v_renamed == 3) ? false : true;
    }

    public void y_renamed() {
        com.oplus.camera.ui.preview.ac_renamed acVar;
        if (!x_renamed() || s_renamed() || this.t_renamed == null || !this.A_renamed.a_renamed(com.oplus.camera.aps.config.CameraFunction.RESET_AUTO_FOCUS)) {
            return;
        }
        if (U_renamed() || (O_renamed() && (acVar = this.p_renamed) != null && acVar.f_renamed())) {
            this.t_renamed.removeMessages(6);
            this.t_renamed.sendEmptyMessage(6);
        }
    }

    public void z_renamed() {
        if (x_renamed() && !s_renamed() && this.t_renamed != null && U_renamed() && this.A_renamed.a_renamed(com.oplus.camera.aps.config.CameraFunction.RESET_AUTO_FOCUS)) {
            this.t_renamed.removeMessages(6);
            this.t_renamed.sendEmptyMessageDelayed(6, 3000L);
        }
    }

    private boolean U_renamed() {
        com.oplus.camera.ui.preview.n_renamed nVar = this.r_renamed;
        return nVar != null && java.lang.Math.abs(0.55f - nVar.getAlpha()) <= 0.01f && this.r_renamed.getVisibility() == 0;
    }

    public boolean A_renamed() {
        com.oplus.camera.ui.preview.ac_renamed acVar;
        com.oplus.camera.ui.preview.n_renamed nVar = this.r_renamed;
        return (nVar != null && nVar.getVisibility() == 0) || ((acVar = this.p_renamed) != null && acVar.d_renamed());
    }

    public boolean h_renamed(boolean z_renamed) {
        int i_renamed = this.D_renamed;
        boolean z2 = 2 == i_renamed || 6 == i_renamed || i_renamed == 0;
        com.oplus.camera.e_renamed.a_renamed("FocusManager", "inScanProgress, afDone: " + z2 + ", mAfFocusState: " + this.D_renamed + ", mbPdaf: " + this.G_renamed + ", mbPdafConvergeDone: " + this.E_renamed + ", mbAfMoving: " + this.F_renamed + ", isAISSnapshot: " + z_renamed);
        int i2 = this.C_renamed;
        if (4 != i2) {
            return 1 == i2 && this.D_renamed == 3 && !this.G_renamed;
        }
        if (z2 || this.E_renamed) {
            return false;
        }
        if (z_renamed) {
            return !this.F_renamed;
        }
        return this.D_renamed == 1 && !this.G_renamed;
    }

    public void B_renamed() {
        android.os.Handler handler = this.t_renamed;
        if (handler != null) {
            handler.removeMessages(13);
            this.t_renamed.sendEmptyMessage(13);
        }
    }

    private void V_renamed() {
        android.os.Handler handler = this.t_renamed;
        if (handler != null) {
            handler.removeMessages(6);
            this.t_renamed.removeMessages(8);
            this.t_renamed.removeMessages(7);
        }
    }

    public boolean C_renamed() {
        com.oplus.camera.ui.preview.f_renamed fVar = this.A_renamed;
        return (fVar == null || !fVar.r_renamed() || R_renamed()) ? false : true;
    }

    @Override // com.oplus.camera.ui.preview.s_renamed
    public boolean D_renamed() {
        com.oplus.camera.ui.preview.f_renamed fVar = this.A_renamed;
        return fVar != null && fVar.p_renamed();
    }

    public boolean E_renamed() {
        com.oplus.camera.ui.preview.f_renamed fVar = this.A_renamed;
        return fVar != null && fVar.q_renamed();
    }

    @Override // com.oplus.camera.ui.preview.s_renamed
    public boolean F_renamed() {
        com.oplus.camera.ui.preview.f_renamed fVar = this.A_renamed;
        return fVar != null && fVar.r_renamed() && this.A_renamed.q_renamed() && this.A_renamed.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_SUPPORT_EXPOSURE_FOCUS_SEPARATE);
    }

    @Override // com.oplus.camera.ui.preview.s_renamed
    public boolean G_renamed() {
        com.oplus.camera.ui.preview.f_renamed fVar = this.A_renamed;
        return fVar != null && fVar.a_renamed(com.oplus.camera.ui.CameraUIInterface.KEY_XPAN_EXPOSURE);
    }

    @Override // com.oplus.camera.ui.preview.s_renamed
    public void a_renamed(float f_renamed) {
        d_renamed(f_renamed);
    }

    @Override // com.oplus.camera.ui.preview.s_renamed
    public void i_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("FocusManager", "toggleAeAfLock, mbAEAFLocked: " + s_renamed());
        if (this.A_renamed == null) {
            com.oplus.camera.e_renamed.a_renamed("FocusManager", "toggleAeAfLock, mCameraFocusListener is_renamed null.");
            return;
        }
        if (this.r_renamed == null) {
            com.oplus.camera.e_renamed.e_renamed("FocusManager", "toggleAeAfLock, mFocusExposureContainer is_renamed null.");
            return;
        }
        if (s_renamed()) {
            e_renamed(0);
            if (this.A_renamed.n_renamed()) {
                com.oplus.camera.ui.preview.f_renamed fVar = this.A_renamed;
                if (fVar != null) {
                    fVar.s_renamed();
                    this.A_renamed.c_renamed(false, true);
                }
                p_renamed();
                if (this.S_renamed) {
                    k_renamed(false);
                }
                d_renamed(0);
                return;
            }
            com.oplus.camera.ui.preview.f_renamed fVar2 = this.A_renamed;
            if (fVar2 != null) {
                fVar2.c_renamed(false, true);
            }
            p_renamed();
            if (this.S_renamed) {
                k_renamed(false);
            }
            this.t_renamed.sendEmptyMessage(1);
            return;
        }
        e_renamed(2);
        android.graphics.RectF rectF = new android.graphics.RectF((this.M_renamed - (this.r_renamed.getExposureRectWidth() / 2)) / this.y_renamed, (this.N_renamed - (this.r_renamed.getExposureRectWidth() / 2)) / this.z_renamed, (this.M_renamed + (this.r_renamed.getExposureRectWidth() / 2)) / this.y_renamed, (this.N_renamed + (this.r_renamed.getExposureRectWidth() / 2)) / this.z_renamed);
        if (1 != this.x_renamed && C_renamed()) {
            this.A_renamed.t_renamed();
        }
        if (C_renamed() || E_renamed()) {
            int i_renamed = this.x_renamed;
            if (i_renamed == 3 || ((i_renamed == 0 && z_renamed) || !C_renamed())) {
                n_renamed(true);
                f_renamed(true);
                return;
            } else {
                a_renamed(rectF, rectF);
                return;
            }
        }
        com.oplus.camera.e_renamed.e_renamed("FocusManager", "toggleAeAfLock, do nothing, lock AE/AF is_renamed unsupported.");
    }

    @Override // com.oplus.camera.ui.preview.s_renamed
    public void H_renamed() {
        this.h_renamed = !this.h_renamed;
        com.oplus.camera.ui.preview.f_renamed fVar = this.A_renamed;
        if (fVar != null) {
            fVar.a_renamed(this.h_renamed, true);
        }
        com.oplus.camera.ui.preview.n_renamed nVar = this.r_renamed;
        if (nVar != null) {
            nVar.a_renamed(s_renamed());
        }
        com.oplus.camera.ui.preview.ac_renamed acVar = this.p_renamed;
        if (acVar != null) {
            acVar.setLockState(this.h_renamed);
        }
        L_renamed();
    }

    private void n_renamed(boolean z_renamed) {
        if (this.h_renamed != z_renamed) {
            H_renamed();
        }
    }

    @Override // com.oplus.camera.ui.preview.s_renamed
    public boolean I_renamed() {
        return this.h_renamed;
    }

    @Override // com.oplus.camera.ui.preview.s_renamed
    public boolean J_renamed() {
        return this.A_renamed.a_renamed();
    }

    @Override // com.oplus.camera.ui.preview.s_renamed
    public boolean K_renamed() {
        return this.A_renamed.b_renamed();
    }

    @Override // com.oplus.camera.ui.preview.s_renamed
    public boolean b_renamed(int i_renamed, int i2) {
        return this.A_renamed.a_renamed(i_renamed, i2);
    }

    @Override // com.oplus.camera.ui.preview.s_renamed
    public void a_renamed(float f_renamed, float f2, int i_renamed, int i2) {
        float f3 = i_renamed / 2.0f;
        int i3 = this.y_renamed;
        float f4 = i2 / 2.0f;
        int i4 = this.z_renamed;
        android.graphics.RectF rectF = new android.graphics.RectF((f_renamed - f3) / i3, (f2 - f4) / i4, (f3 + f_renamed) / i3, (f4 + f2) / i4);
        this.A_renamed.a_renamed((int) f_renamed, (int) f2, rectF);
        this.A_renamed.a_renamed(b_renamed(rectF));
        com.oplus.camera.e_renamed.b_renamed("FocusManager", "setExposurePointInfo, x_renamed: " + f_renamed + " y_renamed: " + f2 + "AE regions: " + rectF);
    }

    @Override // com.oplus.camera.ui.preview.s_renamed
    public void b_renamed(float f_renamed, float f2, int i_renamed, int i2) {
        float f3 = i_renamed / 2.0f;
        int i3 = this.y_renamed;
        float f4 = i2 / 2.0f;
        int i4 = this.z_renamed;
        android.graphics.RectF rectF = new android.graphics.RectF((f_renamed - f3) / i3, (f2 - f4) / i4, (f3 + f_renamed) / i3, (f4 + f2) / i4);
        this.A_renamed.b_renamed((int) f_renamed, (int) f2, rectF);
        this.A_renamed.b_renamed(b_renamed(rectF));
        d_renamed(1);
        com.oplus.camera.e_renamed.b_renamed("FocusManager", "setFocalPointInfo, AF regions: " + rectF);
    }

    @Override // com.oplus.camera.ui.preview.s_renamed
    public void L_renamed() {
        if (this.t_renamed != null) {
            V_renamed();
            this.t_renamed.sendEmptyMessageDelayed(7, 1000L);
        }
    }

    public void b_renamed(float f_renamed) {
        com.oplus.camera.ui.preview.n_renamed nVar = this.r_renamed;
        if (nVar == null || nVar.getVisibility() != 0) {
            return;
        }
        this.r_renamed.c_renamed(false);
    }

    public void a_renamed(android.graphics.Rect rect, android.graphics.Rect rect2, android.util.Size size) {
        this.U_renamed = rect;
        this.V_renamed = rect2;
        this.W_renamed = size;
        com.oplus.camera.ui.preview.ac_renamed acVar = this.p_renamed;
        if (acVar != null) {
            acVar.a_renamed(rect, rect2, size, new android.util.Size(this.y_renamed, this.z_renamed));
        }
    }

    /* compiled from: FocusManager.java */
    private class a_renamed extends android.os.Handler {
        public a_renamed(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            com.oplus.camera.e_renamed.a_renamed("FocusManager", "handleMessage, msg: " + message.what);
            boolean z_renamed = false;
            switch (message.what) {
                case 1:
                    com.oplus.camera.ui.preview.o_renamed.this.l_renamed();
                    com.oplus.camera.ui.preview.o_renamed.this.A_renamed.f_renamed();
                    com.oplus.camera.ui.preview.o_renamed.this.A_renamed.h_renamed();
                    break;
                case 2:
                    boolean z2 = com.oplus.camera.ui.preview.o_renamed.this.u_renamed != -1;
                    boolean z3 = com.oplus.camera.ui.preview.o_renamed.this.o_renamed != null && com.oplus.camera.ui.preview.o_renamed.this.o_renamed.a_renamed();
                    if (com.oplus.camera.ui.preview.o_renamed.this.q_renamed != null && com.oplus.camera.ui.preview.o_renamed.this.q_renamed.f_renamed()) {
                        z_renamed = true;
                    }
                    com.oplus.camera.ui.preview.m_renamed mVar = z3 ? com.oplus.camera.ui.preview.o_renamed.this.o_renamed : z_renamed ? com.oplus.camera.ui.preview.o_renamed.this.q_renamed : com.oplus.camera.ui.preview.o_renamed.this.r_renamed;
                    if (!com.oplus.camera.ui.preview.o_renamed.this.S_renamed && mVar != null) {
                        mVar.a_renamed(true, z2);
                        break;
                    }
                    break;
                case 5:
                    com.oplus.camera.ui.preview.o_renamed.this.t_renamed.removeMessages(5);
                    if (com.oplus.camera.ui.preview.o_renamed.this.h_renamed() && com.oplus.camera.util.Util.C_renamed()) {
                        com.oplus.camera.ui.preview.o_renamed.this.t_renamed.removeMessages(9);
                        com.oplus.camera.ui.preview.o_renamed.this.t_renamed.sendEmptyMessageDelayed(9, 100L);
                        break;
                    } else {
                        com.oplus.camera.ui.preview.o_renamed.this.m_renamed(false);
                        break;
                    }
                case 6:
                    if (!com.oplus.camera.ui.preview.o_renamed.this.s_renamed()) {
                        if (com.oplus.camera.ui.preview.o_renamed.this.p_renamed != null && com.oplus.camera.ui.preview.o_renamed.this.S_renamed) {
                            com.oplus.camera.ui.preview.o_renamed.this.k_renamed(false);
                        }
                        if (!com.oplus.camera.ui.preview.o_renamed.this.A_renamed.n_renamed()) {
                            if (com.oplus.camera.ui.preview.o_renamed.this.r_renamed != null) {
                                if (!com.oplus.camera.ui.preview.o_renamed.this.r_renamed.f_renamed()) {
                                    com.oplus.camera.ui.preview.o_renamed.this.r_renamed.e_renamed();
                                }
                            }
                            if (com.oplus.camera.ui.preview.o_renamed.this.t_renamed != null) {
                                com.oplus.camera.ui.preview.o_renamed.this.t_renamed.sendEmptyMessage(1);
                            }
                            if (!com.oplus.camera.ui.preview.o_renamed.this.A_renamed.m_renamed()) {
                                com.oplus.camera.ui.preview.o_renamed.this.d_renamed(0);
                                if (com.oplus.camera.ui.preview.o_renamed.this.t_renamed == null || !com.oplus.camera.ui.preview.o_renamed.this.t_renamed.hasMessages(5)) {
                                    com.oplus.camera.ui.preview.o_renamed.this.A_renamed.s_renamed();
                                    break;
                                } else {
                                    com.oplus.camera.ui.preview.o_renamed.this.t_renamed.removeMessages(9);
                                    com.oplus.camera.ui.preview.o_renamed.this.t_renamed.removeMessages(5);
                                    com.oplus.camera.ui.preview.o_renamed.this.m_renamed(true);
                                    break;
                                }
                            }
                        }
                    }
                    break;
                case 7:
                    if (com.oplus.camera.ui.preview.o_renamed.this.r_renamed != null) {
                        com.oplus.camera.ui.preview.o_renamed.this.r_renamed.setAlpha(0.55f);
                    }
                    if (com.oplus.camera.ui.preview.o_renamed.this.p_renamed != null) {
                        com.oplus.camera.ui.preview.o_renamed.this.p_renamed.setAlpha(0.55f);
                    }
                    if (com.oplus.camera.ui.preview.o_renamed.this.t_renamed != null) {
                        com.oplus.camera.ui.preview.o_renamed.this.t_renamed.removeMessages(8);
                        com.oplus.camera.ui.preview.o_renamed.this.t_renamed.sendEmptyMessageDelayed(8, 1000L);
                        if (com.oplus.camera.ui.preview.o_renamed.this.A_renamed.e_renamed() && 1 != com.oplus.camera.ui.preview.o_renamed.this.u_renamed) {
                            com.oplus.camera.ui.preview.o_renamed.this.t_renamed.removeMessages(13);
                            com.oplus.camera.ui.preview.o_renamed.this.t_renamed.sendEmptyMessageDelayed(13, 1500L);
                            break;
                        }
                    }
                    break;
                case 8:
                    if (com.oplus.camera.ui.preview.o_renamed.this.r_renamed != null) {
                        com.oplus.camera.ui.preview.o_renamed.this.r_renamed.d_renamed(false);
                    }
                    com.oplus.camera.ui.preview.o_renamed.this.s_renamed = false;
                    if (com.oplus.camera.ui.preview.o_renamed.this.t_renamed != null && !com.oplus.camera.ui.preview.o_renamed.this.x_renamed()) {
                        com.oplus.camera.ui.preview.o_renamed.this.t_renamed.sendEmptyMessageDelayed(6, 3000L);
                        break;
                    }
                    break;
                case 9:
                    com.oplus.camera.ui.preview.o_renamed.this.m_renamed(true);
                    break;
                case 10:
                    com.oplus.camera.ui.preview.o_renamed.this.Q_renamed();
                    break;
                case 12:
                    com.oplus.camera.ui.preview.o_renamed.this.d_renamed(3);
                    com.oplus.camera.ui.preview.o_renamed oVar = com.oplus.camera.ui.preview.o_renamed.this;
                    oVar.a_renamed(oVar.C_renamed, com.oplus.camera.ui.preview.o_renamed.this.D_renamed, true, com.oplus.camera.ui.preview.o_renamed.this.G_renamed, false);
                    com.oplus.camera.e_renamed.b_renamed("FocusManager", "handleMessage, check AF converged");
                    break;
                case 13:
                    com.oplus.camera.ui.preview.o_renamed.this.f_renamed(8);
                    break;
            }
        }
    }

    public void j_renamed(boolean z_renamed) {
        this.R_renamed = z_renamed;
    }

    public void f_renamed(final int i_renamed) {
        android.app.Activity activity = this.n_renamed;
        if (activity != null) {
            activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.-$$Lambda$o_renamed$Xz2LrB2YwV-TOn8-lQBADHN_NYI
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.g_renamed(i_renamed);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g_renamed(int i_renamed) {
        com.oplus.camera.ui.preview.n_renamed nVar = this.r_renamed;
        if (nVar != null) {
            nVar.setVisibility(i_renamed);
        }
    }

    public boolean M_renamed() {
        return this.m_renamed;
    }

    public void c_renamed(float f_renamed) {
        com.oplus.camera.ui.preview.ac_renamed acVar = this.p_renamed;
        if (acVar != null) {
            acVar.setZoomValue(f_renamed);
        }
    }

    public void a_renamed(int[] iArr) {
        android.app.Activity activity = this.n_renamed;
        if (activity != null) {
            activity.runOnUiThread(new java.lang.Runnable() { // from class: com.oplus.camera.ui.preview.o_renamed.3
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.camera.ui.preview.ac_renamed acVar = com.oplus.camera.ui.preview.o_renamed.this.p_renamed;
                    if (acVar != null) {
                        if (!com.oplus.camera.ui.preview.o_renamed.this.R_renamed || acVar.getVisibility() != 0) {
                            if (com.oplus.camera.ui.preview.o_renamed.this.R_renamed || 4 != acVar.getVisibility()) {
                                return;
                            }
                            acVar.setVisibility(0);
                            return;
                        }
                        acVar.setVisibility(4);
                    }
                }
            });
            com.oplus.camera.ui.preview.ac_renamed acVar = this.p_renamed;
            if (acVar != null) {
                acVar.a_renamed(iArr);
            }
        }
    }

    public void k_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.b_renamed("FocusManager", "stopTracking, needRepeating: " + z_renamed);
        com.oplus.camera.ui.preview.ac_renamed acVar = this.p_renamed;
        if (acVar != null) {
            acVar.b_renamed();
        }
        this.S_renamed = false;
        this.A_renamed.a_renamed(new int[]{0, 0, 0, 0}, z_renamed);
    }

    public void a_renamed(android.graphics.RectF rectF) {
        this.S_renamed = true;
        com.oplus.camera.ui.preview.ac_renamed acVar = this.p_renamed;
        if (acVar != null) {
            acVar.c_renamed();
            this.p_renamed.a_renamed(rectF);
            this.A_renamed.a_renamed(new int[]{0, 0, 0, 0}, false);
        }
    }

    public void a_renamed(android.graphics.Rect rect) {
        if (this.A_renamed != null) {
            com.oplus.camera.e_renamed.b_renamed("FocusManager", "startTracking, rect: " + rect);
            this.A_renamed.a_renamed(new int[]{rect.left, rect.top, rect.right, rect.bottom}, true);
            com.oplus.camera.ui.preview.ac_renamed acVar = this.p_renamed;
            if (acVar != null) {
                acVar.j_renamed();
            }
        }
    }

    public int N_renamed() {
        return this.u_renamed;
    }

    public boolean O_renamed() {
        return this.S_renamed;
    }
}
