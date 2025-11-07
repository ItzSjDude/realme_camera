package com.oplus.camera.p172ui.p173a;

import com.oplus.camera.R;
import com.oplus.camera.util.Util;

/* compiled from: HintModel.java */
/* renamed from: com.oplus.camera.ui.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class HintModel {

    /* renamed from: t */
    private static int[] f17454t = {R.string.camera_zoom_not_support, R.string.camera_10bits_not_support_continuous_shot_tips, R.string.hint_function_not_support_1080_60, R.string.camera_AI_high_pixel_scenes_hint, R.string.camera_mode_macro_hint};

    /* renamed from: u */
    private static int[] f17455u = {R.string.camera_ai_scn_microspur, R.string.camera_picture_size_standard_high_hint, R.string.camera_AI_high_pixel_hint, R.string.camera_mode_macro, R.string.camera_video_hdr, R.string.camera_ultra_video_night, R.string.camera_super_eis, R.string.camera_super_eis_pro, R.string.camera_bokeh_move_farther_away, R.string.camera_bokeh_move_closer, R.string.camera_id_photo_mode_need_more_light, R.string.camera_bokeh_place_subject_not_found, R.string.camera_bokeh_camera_do_not_occlusion, R.string.camera_scene_night_keep_phone_steady, R.string.camera_scene_night_process_image_after_capture, R.string.camera_scene_ultra_dark_mode_tips, R.string.camera_video_hyper_lapse_hint, R.string.camera_intelligent_high_frame_slow_selected, R.string.camera_intelligent_high_frame_super_selected, R.string.camera_intelligent_high_frame_detecting, R.string.camera_intelligent_high_frame_recording, R.string.camera_intelligent_high_frame_saving, R.string.camera_panorama_rear_capturing, R.string.camera_panorama_rear_prepare, R.string.camera_panorama_front_previewing, R.string.camera_panorama_front_left_rotato, R.string.camera_panorama_front_right_rotato, R.string.camera_id_photo_mode_no_faces, R.string.camera_id_photo_mode_more_faces, R.string.camera_macro_best_focus_distance_text, R.string.camera_double_exposure_first_video_hint, R.string.camera_double_exposure_two_video_hint, R.string.camera_double_exposure_nobody_hint, R.string.mode_double_exposure_video_importing, R.string.camera_double_exposure_guide_hint_secord, R.string.camera_double_exposure_guide_hint_third, R.string.camera_10bit_hint, R.string.camera_scene_tripod_night_keep_steady_tips, R.string.camera_3d_photo_preview_hint};

    /* renamed from: PlatformImplementations.kt_3 */
    public int f17456a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int f17457b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int f17458c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean f17459d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean f17460e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean f17461f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    public boolean f17462g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean f17463h;

    /* renamed from: OplusGLSurfaceView_13 */
    public boolean f17464i;

    /* renamed from: OplusGLSurfaceView_15 */
    public boolean f17465j;

    /* renamed from: OplusGLSurfaceView_5 */
    public boolean f17466k;

    /* renamed from: OplusGLSurfaceView_14 */
    public int f17467l;

    /* renamed from: OplusGLSurfaceView_6 */
    public int f17468m;

    /* renamed from: OplusGLSurfaceView_11 */
    public int f17469n;

    /* renamed from: o */
    public int f17470o;

    /* renamed from: p */
    public int f17471p;

    /* renamed from: q */
    public Object[] f17472q;

    /* renamed from: r */
    public IntrinsicsJvm.kt_4 f17473r;

    /* renamed from: s */
    public PlatformImplementations.kt_3 f17474s;

    /* compiled from: HintModel.java */
    /* renamed from: com.oplus.camera.ui.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    public enum PlatformImplementations.kt_3 {
        UNKNOWN,
        SPECIAL,
        CONDITION,
        TEMP,
        TEMP_COMPATIBLE
    }

    /* compiled from: HintModel.java */
    /* renamed from: com.oplus.camera.ui.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4$IntrinsicsJvm.kt_4 */
    public enum IntrinsicsJvm.kt_4 {
        STRING,
        ICON,
        AI_SCENE
    }

    public HintModel() {
        this.f17456a = 0;
        this.f17457b = 0;
        this.f17458c = -1;
        this.f17459d = false;
        this.f17460e = false;
        this.f17461f = false;
        this.f17462g = false;
        this.f17463h = false;
        this.f17464i = false;
        this.f17465j = true;
        this.f17466k = false;
        this.f17467l = 0;
        this.f17468m = 0;
        this.f17469n = 0;
        this.f17470o = 0;
        this.f17471p = 0;
        this.f17472q = null;
        this.f17473r = IntrinsicsJvm.kt_4.STRING;
        this.f17474s = PlatformImplementations.kt_3.TEMP;
    }

    public HintModel(int OplusGLSurfaceView_13, boolean z, boolean z2, int i2, int i3, int i4, int i5, boolean z3, boolean z4, boolean z5, int i6, Object... objArr) {
        this.f17456a = 0;
        this.f17457b = 0;
        this.f17458c = -1;
        this.f17459d = false;
        this.f17460e = false;
        this.f17461f = false;
        this.f17462g = false;
        this.f17463h = false;
        this.f17464i = false;
        this.f17465j = true;
        this.f17466k = false;
        this.f17467l = 0;
        this.f17468m = 0;
        this.f17469n = 0;
        this.f17470o = 0;
        this.f17471p = 0;
        this.f17472q = null;
        this.f17473r = IntrinsicsJvm.kt_4.STRING;
        this.f17474s = PlatformImplementations.kt_3.TEMP;
        this.f17456a = OplusGLSurfaceView_13;
        this.f17458c = i6;
        this.f17459d = z;
        this.f17461f = z2;
        this.f17467l = i3;
        this.f17468m = i4;
        this.f17462g = z4;
        this.f17473r = IntrinsicsJvm.kt_4.STRING;
        this.f17472q = objArr;
        this.f17463h = z3;
        this.f17469n = i2;
        this.f17471p = i5;
        this.f17464i = z5;
        this.f17474s = m18507a(this);
    }

    public HintModel(int OplusGLSurfaceView_13, boolean z, boolean z2, int i2, boolean z3, int i3) {
        this.f17456a = 0;
        this.f17457b = 0;
        this.f17458c = -1;
        this.f17459d = false;
        this.f17460e = false;
        this.f17461f = false;
        this.f17462g = false;
        this.f17463h = false;
        this.f17464i = false;
        this.f17465j = true;
        this.f17466k = false;
        this.f17467l = 0;
        this.f17468m = 0;
        this.f17469n = 0;
        this.f17470o = 0;
        this.f17471p = 0;
        this.f17472q = null;
        this.f17473r = IntrinsicsJvm.kt_4.STRING;
        this.f17474s = PlatformImplementations.kt_3.TEMP;
        this.f17457b = OplusGLSurfaceView_13;
        this.f17460e = z;
        this.f17461f = z2;
        this.f17462g = z3;
        this.f17473r = IntrinsicsJvm.kt_4.ICON;
        this.f17469n = i2;
        this.f17471p = i3;
        this.f17474s = m18507a(this);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static PlatformImplementations.kt_3 m18507a(HintModel c3131b) {
        if (c3131b == null) {
            return PlatformImplementations.kt_3.UNKNOWN;
        }
        if (IntrinsicsJvm.kt_4.AI_SCENE == c3131b.f17473r) {
            return PlatformImplementations.kt_3.SPECIAL;
        }
        if (IntrinsicsJvm.kt_4.ICON == c3131b.f17473r) {
            return PlatformImplementations.kt_3.SPECIAL;
        }
        for (int OplusGLSurfaceView_13 : f17454t) {
            if (OplusGLSurfaceView_13 == c3131b.f17456a) {
                return PlatformImplementations.kt_3.TEMP_COMPATIBLE;
            }
        }
        for (int i2 : f17455u) {
            if (i2 == c3131b.f17456a) {
                return PlatformImplementations.kt_3.CONDITION;
            }
        }
        return PlatformImplementations.kt_3.TEMP;
    }

    public String toString() {
        String str;
        if (this.f17456a > 0) {
            if (this.f17458c > -1) {
                str = "text:" + Util.m24244a(this.f17456a, this.f17458c, this.f17472q) + " @ ";
            } else {
                str = "text:" + Util.m24245a(this.f17456a, this.f17472q) + " @ ";
            }
        } else {
            str = "text:null @ ";
        }
        return ((str + "mHintType:" + this.f17473r + " @ ") + "mHintCategory:" + this.f17474s + " @ ") + "mIconId:" + this.f17457b + " @ ";
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public boolean equals(Object obj) {
        return (obj instanceof HintModel) && hashCode() == ((HintModel) obj).hashCode();
    }
}
