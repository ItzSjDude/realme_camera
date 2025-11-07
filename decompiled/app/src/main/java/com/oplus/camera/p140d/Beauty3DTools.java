package com.oplus.camera.p140d;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import com.oplus.camera.R;

/* compiled from: Beauty3DTools.java */
/* renamed from: com.oplus.camera.IntrinsicsJvm.kt_5.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class Beauty3DTools {

    /* renamed from: PlatformImplementations.kt_3 */
    private static Beauty3DTools f13154a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f13155b = false;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Context f13156c = null;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private SparseArray<Integer> f13157d = new SparseArray<>();

    /* renamed from: COUIBaseListPopupWindow_8 */
    private SparseArray<Integer> f13158e = new SparseArray<>();

    /* renamed from: COUIBaseListPopupWindow_12 */
    private SparseArray<Integer> f13159f = new SparseArray<>();

    /* renamed from: COUIBaseListPopupWindow_11 */
    private SparseArray<Integer> f13160g = new SparseArray<>();

    /* renamed from: COUIBaseListPopupWindow_10 */
    private SparseArray<Integer> f13161h = new SparseArray<>();

    /* renamed from: OplusGLSurfaceView_13 */
    private SparseArray<Integer> f13162i = new SparseArray<>();

    /* renamed from: PlatformImplementations.kt_3 */
    public int m12875a(float COUIBaseListPopupWindow_12, int OplusGLSurfaceView_13, float f2, int i2) {
        int i3 = i2 - ((int) ((((COUIBaseListPopupWindow_12 - f2) * 2.0f) / OplusGLSurfaceView_13) * 90));
        if (i3 >= 90) {
            return 90;
        }
        if (i3 < -90) {
            return -90;
        }
        return i3;
    }

    private Beauty3DTools() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Beauty3DTools m12873a() {
        if (f13154a == null) {
            f13154a = new Beauty3DTools();
        }
        return f13154a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12877a(Activity activity) {
        if (this.f13155b) {
            return;
        }
        this.f13156c = activity.getApplicationContext();
        m12874b();
        this.f13155b = true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Integer m12876a(int OplusGLSurfaceView_13) {
        return this.f13158e.get(OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public Integer m12878b(int OplusGLSurfaceView_13) {
        return this.f13157d.get(OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public Integer m12879c(int OplusGLSurfaceView_13) {
        return this.f13159f.get(OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public Integer m12880d(int OplusGLSurfaceView_13) {
        return this.f13160g.get(OplusGLSurfaceView_13);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public Integer m12881e(int OplusGLSurfaceView_13) {
        return this.f13161h.get(OplusGLSurfaceView_13);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public Integer m12882f(int OplusGLSurfaceView_13) {
        return this.f13162i.get(OplusGLSurfaceView_13);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m12874b() {
        this.f13157d.put(0, Integer.valueOf(R.string.beauty3d_standard_nose));
        this.f13157d.put(1, Integer.valueOf(R.string.beauty3d_width_nose));
        this.f13157d.put(2, Integer.valueOf(R.string.beauty3d_narrow_nose));
        this.f13158e.put(0, Integer.valueOf(R.string.beauty3d_standard_eye));
        this.f13158e.put(1, Integer.valueOf(R.string.beauty3d_small_eye));
        this.f13159f.put(0, Integer.valueOf(R.string.beauty3d_standard_chin));
        this.f13159f.put(1, Integer.valueOf(R.string.beauty3d_long_chin));
        this.f13159f.put(2, Integer.valueOf(R.string.beauty3d_short_chin));
        this.f13160g.put(0, Integer.valueOf(R.string.beauty3d_goose_face));
        this.f13160g.put(1, Integer.valueOf(R.string.beauty3d_square_face));
        this.f13160g.put(2, Integer.valueOf(R.string.beauty3d_long_face));
        this.f13160g.put(3, Integer.valueOf(R.string.beauty3d_round_face));
        this.f13161h.put(0, Integer.valueOf(R.string.beauty3d_standard_cheekbone));
        this.f13161h.put(1, Integer.valueOf(R.string.beauty3d_high_cheekbone));
        this.f13162i.put(5, Integer.valueOf(R.string.beauty3d_pelease_remove_glasses));
        this.f13162i.put(6, Integer.valueOf(R.string.beauty3d_face_change));
        this.f13162i.put(7, Integer.valueOf(R.string.beauty3d_keep_face_in_cicle));
        this.f13162i.put(8, Integer.valueOf(R.string.beauty3d_no_face));
        SparseArray<Integer> sparseArray = this.f13162i;
        Integer numValueOf = Integer.valueOf(R.string.beauty3d_orientatin_error_keep_vertical);
        sparseArray.put(9, numValueOf);
        this.f13162i.put(22, numValueOf);
        this.f13162i.put(10, Integer.valueOf(R.string.beauty3d_keep_face_forward));
        this.f13162i.put(11, Integer.valueOf(R.string.beauty3d_turn_to_left));
        this.f13162i.put(12, Integer.valueOf(R.string.beauty3d_turn_to_right));
        this.f13162i.put(13, Integer.valueOf(R.string.beauty3d_turn_to_up));
        this.f13162i.put(14, Integer.valueOf(R.string.beauty3d_wait_scan_complete));
        this.f13162i.put(15, Integer.valueOf(R.string.beauty3d_no_show_teeth));
        this.f13162i.put(16, Integer.valueOf(R.string.beauty3d_face_blurred));
        this.f13162i.put(17, Integer.valueOf(R.string.beauty3d_face_closer));
        this.f13162i.put(18, Integer.valueOf(R.string.beauty3d_continue_turn_to_left));
        this.f13162i.put(19, Integer.valueOf(R.string.beauty3d_continue_turn_to_right));
        this.f13162i.put(21, Integer.valueOf(R.string.beauty3d_over_max_frame_exit));
        this.f13162i.put(22, Integer.valueOf(R.string.beauty3d_program_error_exit));
        this.f13162i.put(20, Integer.valueOf(R.string.beauty3d_save_face_failed));
    }
}
