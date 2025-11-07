package com.oplus.camera.capmode.a_renamed;

/* compiled from: MultiCameraDecision.java */
/* loaded from: classes2.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private int f4213a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f4214b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f4215c;
    private int d_renamed;
    private int e_renamed;
    private int f_renamed;
    private java.lang.String g_renamed;
    private java.lang.String h_renamed;
    private java.lang.String i_renamed;
    private int j_renamed;
    private int k_renamed;
    private int l_renamed;
    private int m_renamed;
    private int n_renamed;
    private java.lang.String o_renamed;
    private java.lang.String p_renamed;
    private boolean q_renamed;

    public a_renamed() {
        this.f4213a = 0;
        this.f4214b = 1;
        this.f4215c = 1;
        this.d_renamed = 0;
        this.e_renamed = 0;
        this.f_renamed = 1;
        this.g_renamed = "";
        this.h_renamed = "";
        this.i_renamed = "";
        this.j_renamed = -1;
        this.k_renamed = -1;
        this.l_renamed = -1;
        this.m_renamed = -1;
        this.n_renamed = -1;
        this.o_renamed = null;
        this.p_renamed = null;
        this.q_renamed = false;
    }

    public a_renamed(int i_renamed, int i2, int i3) {
        this.f4213a = 0;
        this.f4214b = 1;
        this.f4215c = 1;
        this.d_renamed = 0;
        this.e_renamed = 0;
        this.f_renamed = 1;
        this.g_renamed = "";
        this.h_renamed = "";
        this.i_renamed = "";
        this.j_renamed = -1;
        this.k_renamed = -1;
        this.l_renamed = -1;
        this.m_renamed = -1;
        this.n_renamed = -1;
        this.o_renamed = null;
        this.p_renamed = null;
        this.q_renamed = false;
        this.f4213a = i_renamed;
        this.f4214b = i2;
        this.f4215c = i3;
    }

    public com.oplus.camera.capmode.a_renamed.a_renamed a_renamed(java.lang.String str) {
        this.g_renamed = str;
        com.oplus.camera.e_renamed.b_renamed("MultiCameraDecision", "setBeforeModeName, beforeModeName: " + str);
        return this;
    }

    public com.oplus.camera.capmode.a_renamed.a_renamed b_renamed(java.lang.String str) {
        this.h_renamed = str;
        com.oplus.camera.e_renamed.b_renamed("MultiCameraDecision", "setAfterModeName, afterModeName: " + str);
        return this;
    }

    public com.oplus.camera.capmode.a_renamed.a_renamed a_renamed(int i_renamed) {
        this.j_renamed = i_renamed;
        return this;
    }

    public com.oplus.camera.capmode.a_renamed.a_renamed b_renamed(int i_renamed) {
        this.k_renamed = i_renamed;
        return this;
    }

    public com.oplus.camera.capmode.a_renamed.a_renamed c_renamed(int i_renamed) {
        this.l_renamed = i_renamed;
        return this;
    }

    public com.oplus.camera.capmode.a_renamed.a_renamed d_renamed(int i_renamed) {
        this.m_renamed = i_renamed;
        return this;
    }

    public com.oplus.camera.capmode.a_renamed.a_renamed a_renamed() {
        int i_renamed = this.d_renamed;
        if (i_renamed == 0) {
            this.j_renamed = 0;
            this.l_renamed = 1;
        } else if (i_renamed != 1) {
        }
        return this;
    }

    public com.oplus.camera.capmode.a_renamed.a_renamed b_renamed() {
        int i_renamed = this.d_renamed;
        if (i_renamed == 0) {
            this.j_renamed = 0;
            this.l_renamed = 1;
        } else if (i_renamed != 1) {
        }
        return this;
    }

    public boolean c_renamed() {
        return (com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_MULTI_VIDEO.equals(this.g_renamed) && !(this.j_renamed == this.k_renamed && -1 == this.l_renamed)) || com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_MULTI_VIDEO.equals(this.h_renamed);
    }

    public com.oplus.camera.capmode.a_renamed.a_renamed a_renamed(boolean z_renamed) {
        this.q_renamed = z_renamed;
        return this;
    }

    public void c_renamed(java.lang.String str) {
        this.i_renamed = str;
        com.oplus.camera.e_renamed.b_renamed("MultiCameraDecision", "setCurrentModeName, currentModeName: " + str);
    }

    public void d_renamed() {
        this.g_renamed = null;
        this.i_renamed = null;
        this.h_renamed = null;
    }

    public void e_renamed(int i_renamed) {
        this.n_renamed = i_renamed;
        if (com.oplus.ocs.camera.CameraUnitClient.CameraType.REAR_MAIN_FRONT_MAIN.equals(com.oplus.camera.e_renamed.a_renamed.b_renamed(i_renamed))) {
            this.o_renamed = com.oplus.ocs.camera.CameraUnitClient.CameraType.REAR_MAIN;
            this.p_renamed = com.oplus.ocs.camera.CameraUnitClient.CameraType.FRONT_MAIN;
        }
    }

    public java.lang.String e_renamed() {
        return this.p_renamed;
    }

    public java.lang.String toString() {
        return "MultiCameraDecision{mFirstCameraType=" + this.f4213a + ", mSecondCameraType=" + this.f4214b + ", mBottomCameraType=" + this.f4215c + ", mMultiCameraType=" + this.d_renamed + ", mMainLogicId=" + this.e_renamed + ", mSubLogicId=" + this.f_renamed + ", mBeforeModeName='" + this.g_renamed + "', mAfterModeName='" + this.h_renamed + "', mCurrentModeName='" + this.i_renamed + "', mMainBeforeLogicId=" + this.j_renamed + ", mMainAfterLogicId=" + this.k_renamed + ", mSubBeforeLogicId=" + this.l_renamed + ", mSubAfterLogicId=" + this.m_renamed + ", mMultiCameraId=" + this.n_renamed + ", mMainCameraType=" + this.o_renamed + ", mSubCameraType=" + this.p_renamed + '}';
    }
}
