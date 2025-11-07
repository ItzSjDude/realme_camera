package com.oplus.camera.d_renamed;

/* compiled from: Beauty3DTools.java */
/* loaded from: classes2.dex */
public class c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static com.oplus.camera.d_renamed.c_renamed f4374a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private boolean f4375b = false;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.content.Context f4376c = null;
    private android.util.SparseArray<java.lang.Integer> d_renamed = new android.util.SparseArray<>();
    private android.util.SparseArray<java.lang.Integer> e_renamed = new android.util.SparseArray<>();
    private android.util.SparseArray<java.lang.Integer> f_renamed = new android.util.SparseArray<>();
    private android.util.SparseArray<java.lang.Integer> g_renamed = new android.util.SparseArray<>();
    private android.util.SparseArray<java.lang.Integer> h_renamed = new android.util.SparseArray<>();
    private android.util.SparseArray<java.lang.Integer> i_renamed = new android.util.SparseArray<>();

    public int a_renamed(float f_renamed, int i_renamed, float f2, int i2) {
        int i3 = i2 - ((int) ((((f_renamed - f2) * 2.0f) / i_renamed) * 90));
        if (i3 >= 90) {
            return 90;
        }
        if (i3 < -90) {
            return -90;
        }
        return i3;
    }

    private c_renamed() {
    }

    public static com.oplus.camera.d_renamed.c_renamed a_renamed() {
        if (f4374a == null) {
            f4374a = new com.oplus.camera.d_renamed.c_renamed();
        }
        return f4374a;
    }

    public void a_renamed(android.app.Activity activity) {
        if (this.f4375b) {
            return;
        }
        this.f4376c = activity.getApplicationContext();
        b_renamed();
        this.f4375b = true;
    }

    public java.lang.Integer a_renamed(int i_renamed) {
        return this.e_renamed.get(i_renamed);
    }

    public java.lang.Integer b_renamed(int i_renamed) {
        return this.d_renamed.get(i_renamed);
    }

    public java.lang.Integer c_renamed(int i_renamed) {
        return this.f_renamed.get(i_renamed);
    }

    public java.lang.Integer d_renamed(int i_renamed) {
        return this.g_renamed.get(i_renamed);
    }

    public java.lang.Integer e_renamed(int i_renamed) {
        return this.h_renamed.get(i_renamed);
    }

    public java.lang.Integer f_renamed(int i_renamed) {
        return this.i_renamed.get(i_renamed);
    }

    private void b_renamed() {
        this.d_renamed.put(0, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.beauty3d_standard_nose));
        this.d_renamed.put(1, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.beauty3d_width_nose));
        this.d_renamed.put(2, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.beauty3d_narrow_nose));
        this.e_renamed.put(0, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.beauty3d_standard_eye));
        this.e_renamed.put(1, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.beauty3d_small_eye));
        this.f_renamed.put(0, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.beauty3d_standard_chin));
        this.f_renamed.put(1, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.beauty3d_long_chin));
        this.f_renamed.put(2, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.beauty3d_short_chin));
        this.g_renamed.put(0, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.beauty3d_goose_face));
        this.g_renamed.put(1, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.beauty3d_square_face));
        this.g_renamed.put(2, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.beauty3d_long_face));
        this.g_renamed.put(3, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.beauty3d_round_face));
        this.h_renamed.put(0, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.beauty3d_standard_cheekbone));
        this.h_renamed.put(1, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.beauty3d_high_cheekbone));
        this.i_renamed.put(5, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.beauty3d_pelease_remove_glasses));
        this.i_renamed.put(6, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.beauty3d_face_change));
        this.i_renamed.put(7, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.beauty3d_keep_face_in_cicle));
        this.i_renamed.put(8, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.beauty3d_no_face));
        android.util.SparseArray<java.lang.Integer> sparseArray = this.i_renamed;
        java.lang.Integer numValueOf = java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.beauty3d_orientatin_error_keep_vertical);
        sparseArray.put(9, numValueOf);
        this.i_renamed.put(22, numValueOf);
        this.i_renamed.put(10, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.beauty3d_keep_face_forward));
        this.i_renamed.put(11, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.beauty3d_turn_to_left));
        this.i_renamed.put(12, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.beauty3d_turn_to_right));
        this.i_renamed.put(13, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.beauty3d_turn_to_up));
        this.i_renamed.put(14, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.beauty3d_wait_scan_complete));
        this.i_renamed.put(15, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.beauty3d_no_show_teeth));
        this.i_renamed.put(16, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.beauty3d_face_blurred));
        this.i_renamed.put(17, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.beauty3d_face_closer));
        this.i_renamed.put(18, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.beauty3d_continue_turn_to_left));
        this.i_renamed.put(19, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.beauty3d_continue_turn_to_right));
        this.i_renamed.put(21, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.beauty3d_over_max_frame_exit));
        this.i_renamed.put(22, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.beauty3d_program_error_exit));
        this.i_renamed.put(20, java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.beauty3d_save_face_failed));
    }
}
