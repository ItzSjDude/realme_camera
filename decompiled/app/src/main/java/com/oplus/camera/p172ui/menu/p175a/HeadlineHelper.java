package com.oplus.camera.p172ui.menu.p175a;

import android.content.Context;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.p172ui.modepanel.DataBaseOperator;
import com.oplus.camera.p172ui.modepanel.ModeDataInfo;
import com.oplus.camera.screen.p163a.OutCaptureManager;
import com.oplus.camera.util.Util;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/* compiled from: HeadlineHelper.java */
/* renamed from: com.oplus.camera.ui.menu.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class HeadlineHelper {

    /* renamed from: PlatformImplementations.kt_3 */
    private static Context f19014a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private List<Integer> f19015b = new ArrayList();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private List<Integer> f19016c = new ArrayList();

    /* renamed from: IntrinsicsJvm.kt_5 */
    private List<Integer> f19017d = new ArrayList();

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f19018e = 1;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f19019f = true;

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m20345a(int OplusGLSurfaceView_13) {
        switch (OplusGLSurfaceView_13) {
            case R.string.camera_mode_3d_photo /* 2131755586 */:
                return ApsConstant.CAPTURE_MODE_3D_PHOTO;
            case R.string.camera_mode_breeno_scan /* 2131755593 */:
                return ApsConstant.CAPTURE_MODE_BREENO_SCAN;
            case R.string.camera_mode_double_exposure /* 2131755595 */:
                return ApsConstant.REC_MODE_DOUBLE_EXPOSURE;
            case R.string.high_pixel_tip /* 2131756459 */:
                return ApsConstant.CAPTURE_MODE_HIGH_PIXEL;
            case R.string.ultra_high_resolution_tip /* 2131756763 */:
                return ApsConstant.CAPTURE_MODE_ULTRA_HIGH_RESOLUTION;
            default:
                switch (OplusGLSurfaceView_13) {
                    case R.string.camera_mode_fast_video /* 2131755597 */:
                        return ApsConstant.REC_MODE_FAST_VIDEO;
                    case R.string.camera_mode_fish_eye /* 2131755598 */:
                        return ApsConstant.CAPTURE_MODE_FISH_EYE;
                    case R.string.camera_mode_group_shot /* 2131755599 */:
                        return ApsConstant.CAPTURE_MODE_GROUP_SHOT;
                    case R.string.camera_mode_high_definition_108mp /* 2131755600 */:
                    case R.string.camera_mode_high_definition_48mp_oplus_r /* 2131755601 */:
                    case R.string.camera_mode_high_definition_50mp /* 2131755602 */:
                    case R.string.camera_mode_high_definition_64mp_oplus_r /* 2131755603 */:
                        return ApsConstant.CAPTURE_MODE_HIGH_DEFINITION;
                    default:
                        switch (OplusGLSurfaceView_13) {
                            case R.string.camera_mode_id_photo /* 2131755605 */:
                                return ApsConstant.CAPTURE_MODE_ID_PHOTO;
                            case R.string.camera_mode_long_exposure /* 2131755606 */:
                                return ApsConstant.CAPTURE_MODE_LONG_EXPOSURE;
                            default:
                                switch (OplusGLSurfaceView_13) {
                                    case R.string.camera_mode_microscope /* 2131755609 */:
                                        return ApsConstant.CAPTURE_MODE_MICROSCOPE;
                                    case R.string.camera_mode_more /* 2131755610 */:
                                        return ApsConstant.CAPTURE_MODE_MORE;
                                    case R.string.camera_mode_movie /* 2131755611 */:
                                        return "movie";
                                    case R.string.camera_mode_multi_video /* 2131755612 */:
                                        return ApsConstant.CAPTURE_MODE_MULTI_VIDEO;
                                    default:
                                        switch (OplusGLSurfaceView_13) {
                                            case R.string.camera_mode_name_soloop /* 2131755619 */:
                                                return ApsConstant.REC_MODE_SOLOOP;
                                            case R.string.camera_mode_night /* 2131755620 */:
                                                return ApsConstant.CAPTURE_MODE_NIGHT;
                                            case R.string.camera_mode_panorama /* 2131755621 */:
                                                return ApsConstant.CAPTURE_MODE_PANORAMA;
                                            default:
                                                switch (OplusGLSurfaceView_13) {
                                                    case R.string.camera_mode_portrait /* 2131755623 */:
                                                        return "portrait";
                                                    case R.string.camera_mode_professional /* 2131755624 */:
                                                        return ApsConstant.CAPTURE_MODE_PROFESSIONAL;
                                                    case R.string.camera_mode_slow_video /* 2131755625 */:
                                                        return ApsConstant.REC_MODE_SLOW_VIDEO;
                                                    default:
                                                        switch (OplusGLSurfaceView_13) {
                                                            case R.string.camera_mode_starry /* 2131755627 */:
                                                                return ApsConstant.CAPTURE_MODE_STARRY;
                                                            case R.string.camera_mode_sticker /* 2131755628 */:
                                                                return ApsConstant.CAPTURE_MODE_STICKER;
                                                            case R.string.camera_mode_street /* 2131755629 */:
                                                                return ApsConstant.CAPTURE_MODE_STREET;
                                                            case R.string.camera_mode_super_macro /* 2131755630 */:
                                                                break;
                                                            case R.string.camera_mode_super_text /* 2131755631 */:
                                                                return "superText";
                                                            case R.string.camera_mode_tilt_shift /* 2131755632 */:
                                                                return ApsConstant.CAPTURE_MODE_TILT_SHIFT;
                                                            case R.string.camera_mode_time_lapse_pro /* 2131755633 */:
                                                                return ApsConstant.REC_MODE_TIMELASPE_PRO;
                                                            case R.string.camera_mode_video /* 2131755634 */:
                                                                return ApsConstant.REC_MODE_COMMON;
                                                            case R.string.camera_mode_xpan /* 2131755635 */:
                                                                return ApsConstant.CAPTURE_MODE_XPAN;
                                                            default:
                                                                return ApsConstant.CAPTURE_MODE_COMMON;
                                                        }
                                                }
                                        }
                                }
                            case R.string.camera_mode_macro /* 2131755607 */:
                                return ApsConstant.CAPTURE_MODE_MACRO;
                        }
                }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static String m20351d(int OplusGLSurfaceView_13) {
        switch (OplusGLSurfaceView_13) {
            case 0:
                return ApsConstant.CAPTURE_MODE_PANORAMA;
            case 1:
                return ApsConstant.REC_MODE_FAST_VIDEO;
            case 2:
                return ApsConstant.REC_MODE_SLOW_VIDEO;
            case 3:
                return "movie";
            case 4:
                return ApsConstant.CAPTURE_MODE_PROFESSIONAL;
            case 5:
                return ApsConstant.CAPTURE_MODE_NIGHT;
            case 6:
            case 20:
            case 23:
            default:
                return ApsConstant.CAPTURE_MODE_COMMON;
            case 7:
                return ApsConstant.CAPTURE_MODE_STICKER;
            case 8:
                return "superText";
            case 9:
                return ApsConstant.CAPTURE_MODE_BREENO_SCAN;
            case 10:
                return ApsConstant.CAPTURE_MODE_MACRO;
            case 11:
                return ApsConstant.CAPTURE_MODE_ULTRA_HIGH_RESOLUTION;
            case 12:
                return ApsConstant.CAPTURE_MODE_HIGH_DEFINITION;
            case 13:
                return ApsConstant.CAPTURE_MODE_ID_PHOTO;
            case 14:
                return ApsConstant.CAPTURE_MODE_MULTI_VIDEO;
            case 15:
                return ApsConstant.CAPTURE_MODE_GROUP_SHOT;
            case 16:
                return ApsConstant.CAPTURE_MODE_MICROSCOPE;
            case 17:
                return ApsConstant.REC_MODE_SOLOOP;
            case 18:
                return ApsConstant.REC_MODE_DOUBLE_EXPOSURE;
            case 19:
                return ApsConstant.CAPTURE_MODE_STARRY;
            case 21:
                return ApsConstant.REC_MODE_COMMON;
            case 22:
                return "portrait";
            case 24:
                return ApsConstant.CAPTURE_MODE_TILT_SHIFT;
            case 25:
                return ApsConstant.REC_MODE_TIMELASPE_PRO;
            case 26:
                return ApsConstant.CAPTURE_MODE_STREET;
            case 27:
                return ApsConstant.CAPTURE_MODE_LONG_EXPOSURE;
            case 28:
                return ApsConstant.CAPTURE_MODE_XPAN;
            case 29:
                return ApsConstant.CAPTURE_MODE_FISH_EYE;
            case 30:
                return ApsConstant.CAPTURE_MODE_3D_PHOTO;
            case 31:
                return ApsConstant.CAPTURE_MODE_HIGH_PIXEL;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0058 A[RETURN, SYNTHETIC] */
    /* renamed from: COUIBaseListPopupWindow_8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int m20352e(int r0) {
        /*
            switch(r0) {
                case 2131755586: goto L64;
                case 2131755609: goto L61;
                case 2131756459: goto L5e;
                case 2131756763: goto L5b;
                default: goto L3;
            }
        L3:
            switch(r0) {
                case 2131755594: goto L58;
                case 2131755595: goto L55;
                default: goto L6;
            }
        L6:
            switch(r0) {
                case 2131755597: goto L53;
                case 2131755598: goto L50;
                case 2131755599: goto L4d;
                case 2131755600: goto L4a;
                case 2131755601: goto L4a;
                case 2131755602: goto L4a;
                case 2131755603: goto L4a;
                default: goto L9;
            }
        L9:
            switch(r0) {
                case 2131755605: goto L47;
                case 2131755606: goto L44;
                case 2131755607: goto L41;
                default: goto Lc;
            }
        Lc:
            switch(r0) {
                case 2131755611: goto L3f;
                case 2131755612: goto L3c;
                default: goto Lf;
            }
        Lf:
            switch(r0) {
                case 2131755620: goto L3a;
                case 2131755621: goto L38;
                case 2131755622: goto L58;
                case 2131755623: goto L35;
                case 2131755624: goto L33;
                case 2131755625: goto L31;
                case 2131755626: goto L2e;
                case 2131755627: goto L2b;
                case 2131755628: goto L29;
                case 2131755629: goto L26;
                case 2131755630: goto L41;
                case 2131755631: goto L23;
                case 2131755632: goto L20;
                case 2131755633: goto L1d;
                case 2131755634: goto L19;
                case 2131755635: goto L15;
                default: goto L12;
            }
        L12:
            r0 = -1
            goto L66
        L15:
            r0 = 28
            goto L66
        L19:
            r0 = 21
            goto L66
        L1d:
            r0 = 25
            goto L66
        L20:
            r0 = 24
            goto L66
        L23:
            r0 = 8
            goto L66
        L26:
            r0 = 26
            goto L66
        L29:
            r0 = 7
            goto L66
        L2b:
            r0 = 19
            goto L66
        L2e:
            r0 = 17
            goto L66
        L31:
            r0 = 2
            goto L66
        L33:
            r0 = 4
            goto L66
        L35:
            r0 = 22
            goto L66
        L38:
            r0 = 0
            goto L66
        L3a:
            r0 = 5
            goto L66
        L3c:
            r0 = 14
            goto L66
        L3f:
            r0 = 3
            goto L66
        L41:
            r0 = 10
            goto L66
        L44:
            r0 = 27
            goto L66
        L47:
            r0 = 13
            goto L66
        L4a:
            r0 = 12
            goto L66
        L4d:
            r0 = 15
            goto L66
        L50:
            r0 = 29
            goto L66
        L53:
            r0 = 1
            goto L66
        L55:
            r0 = 18
            goto L66
        L58:
            r0 = 20
            goto L66
        L5b:
            r0 = 11
            goto L66
        L5e:
            r0 = 31
            goto L66
        L61:
            r0 = 16
            goto L66
        L64:
            r0 = 30
        L66:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.menu.p175a.HeadlineHelper.m20352e(int):int");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20354a(Context context, int OplusGLSurfaceView_13, boolean z, boolean z2) {
        f19014a = context;
        this.f19018e = OplusGLSurfaceView_13;
        this.f19019f = z;
        this.f19017d.add(Integer.valueOf(R.string.camera_mode_common));
        this.f19017d.add(Integer.valueOf(R.string.camera_mode_video));
        this.f19017d.add(Integer.valueOf(R.string.camera_mode_night));
        this.f19017d.add(Integer.valueOf(R.string.camera_mode_portrait));
        this.f19017d.add(Integer.valueOf(R.string.camera_mode_time_lapse_pro));
        this.f19017d.add(Integer.valueOf(R.string.camera_mode_more));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20353a() {
        List<ModeDataInfo> listM21782a;
        CameraLog.m12954a("HeadlineHelper", "updateMode, mCameraEntryType: " + this.f19018e);
        int OplusGLSurfaceView_13 = this.f19018e;
        if (3 == OplusGLSurfaceView_13) {
            if (this.f19015b.contains(Integer.valueOf(R.string.camera_mode_video))) {
                return;
            }
            this.f19015b.add(Integer.valueOf(R.string.camera_mode_video));
            return;
        }
        if (2 == OplusGLSurfaceView_13) {
            if (!this.f19015b.contains(Integer.valueOf(R.string.camera_mode_common))) {
                this.f19015b.add(Integer.valueOf(R.string.camera_mode_common));
            }
            if (this.f19019f && !this.f19015b.contains(Integer.valueOf(R.string.camera_mode_portrait))) {
                this.f19015b.add(Integer.valueOf(R.string.camera_mode_portrait));
            }
        } else if (1 == OplusGLSurfaceView_13 && (listM21782a = DataBaseOperator.m21777a().m21782a("position_headline")) != null && !listM21782a.isEmpty()) {
            List list = (List) listM21782a.stream().sorted(Comparator.comparing(new Function() { // from class: com.oplus.camera.ui.menu.PlatformImplementations.kt_3.-$$Lambda$W2ZbH78ZdPmvIDG_VbnTW6dpYS4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return Integer.valueOf(((ModeDataInfo) obj).m21911d());
                }
            })).collect(Collectors.toList());
            this.f19015b.clear();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.f19015b.add(Integer.valueOf(m20346b(((ModeDataInfo) it.next()).m21912e())));
            }
            CameraLog.m12954a("HeadlineHelper", "updateMode, query mode list from database, rankList: " + this.f19015b);
        }
        this.f19016c.clear();
        for (Integer num : this.f19015b) {
            if (this.f19017d.contains(num)) {
                this.f19016c.add(num);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public List<Integer> m20355b() {
        if (this.f19015b.size() <= 0) {
            m20353a();
        }
        return OutCaptureManager.m16423g() ? this.f19016c : this.f19015b;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0184  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int m20344a(java.lang.String r1) {
        /*
            Method dump skipped, instructions count: 744
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.menu.p175a.HeadlineHelper.m20344a(java.lang.String):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01a2  */
    /* renamed from: IntrinsicsJvm.kt_4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int m20347b(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 722
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p172ui.menu.p175a.HeadlineHelper.m20347b(java.lang.String):int");
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static int m20348c() {
        int iM24319aH = Util.m24319aH();
        return 48 == iM24319aH ? R.string.camera_mode_high_definition_48mp_oplus_r : 50 == iM24319aH ? R.string.camera_mode_high_definition_50mp : 64 == iM24319aH ? R.string.camera_mode_high_definition_64mp_oplus_r : 108 == iM24319aH ? R.string.camera_mode_high_definition_108mp : R.string.camera_mode_high_definition_48mp_oplus_r;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static int m20346b(int OplusGLSurfaceView_13) {
        switch (OplusGLSurfaceView_13) {
            case 0:
                return R.string.camera_mode_panorama;
            case 1:
                return R.string.camera_mode_fast_video;
            case 2:
                return R.string.camera_mode_slow_video;
            case 3:
                return R.string.camera_mode_movie;
            case 4:
                return R.string.camera_mode_professional;
            case 5:
                return R.string.camera_mode_night;
            case 6:
            default:
                return 0;
            case 7:
                return R.string.camera_mode_sticker;
            case 8:
                return R.string.camera_mode_super_text;
            case 9:
                return R.string.camera_mode_breeno_scan;
            case 10:
                return Util.m24349al() ? R.string.camera_mode_super_macro : R.string.camera_mode_macro;
            case 11:
                return R.string.ultra_high_resolution_tip;
            case 12:
                return m20348c();
            case 13:
                return R.string.camera_mode_id_photo;
            case 14:
                return R.string.camera_mode_multi_video;
            case 15:
                return R.string.camera_mode_group_shot;
            case 16:
                return R.string.camera_mode_microscope;
            case 17:
                return R.string.camera_mode_name_soloop;
            case 18:
                return R.string.camera_mode_double_exposure;
            case 19:
                return R.string.camera_mode_starry;
            case 20:
                return R.string.camera_mode_common;
            case 21:
                return R.string.camera_mode_video;
            case 22:
                return R.string.camera_mode_portrait;
            case 23:
                return R.string.camera_mode_more;
            case 24:
                return R.string.camera_mode_tilt_shift;
            case 25:
                return R.string.camera_mode_time_lapse_pro;
            case 26:
                return R.string.camera_mode_street;
            case 27:
                return R.string.camera_mode_long_exposure;
            case 28:
                return R.string.camera_mode_xpan;
            case 29:
                return R.string.camera_mode_fish_eye;
            case 30:
                return R.string.camera_mode_3d_photo;
            case 31:
                return R.string.high_pixel_tip;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static int m20349c(int OplusGLSurfaceView_13) {
        switch (OplusGLSurfaceView_13) {
            case 0:
                return R.drawable.ic_mode_panorama;
            case 1:
            case 25:
                return R.drawable.ic_mode_timelapse;
            case 2:
                return R.drawable.ic_mode_slomo;
            case 3:
                return R.drawable.ic_mode_movie;
            case 4:
                return Util.m24352ao() ? R.drawable.ic_mode_pro_moon : R.drawable.ic_mode_pro;
            case 5:
                return R.drawable.ic_mode_id_night;
            case 6:
            case 20:
            case 21:
            case 23:
            default:
                return 0;
            case 7:
                return R.drawable.ic_mode_qshot;
            case 8:
                return R.drawable.ic_mode_superword;
            case 9:
                return R.drawable.ic_mode_id_breeno_scan;
            case 10:
                return R.drawable.ic_mode_macro;
            case 11:
            case 12:
            case 31:
                return R.drawable.ic_mode_ultra_high_resolution;
            case 13:
                return R.drawable.ic_mode_id_photo;
            case 14:
                return R.drawable.multi_video_entry;
            case 15:
            case 22:
                return R.drawable.ic_mode_id_portrait;
            case 16:
                return R.drawable.ic_mode_microscope;
            case 17:
                return R.drawable.ic_mode_soloop;
            case 18:
                return R.drawable.ic_mode_double_exposure;
            case 19:
                return R.drawable.ic_mode_starry;
            case 24:
                return R.drawable.ic_mode_tiltshift;
            case 26:
                return R.drawable.ic_mode_street;
            case 27:
                return R.drawable.ic_mode_long_exposure;
            case 28:
                return R.drawable.ic_mode_xpan;
            case 29:
                return R.drawable.ic_mode_fisheye;
            case 30:
                return R.drawable.ic_mode_3d_photo;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static int m20350c(String str) {
        if (f19014a.getString(R.string.camera_mode_panorama).equals(str)) {
            return 0;
        }
        if (f19014a.getString(R.string.camera_mode_fast_video).equals(str)) {
            return 1;
        }
        if (f19014a.getString(R.string.camera_mode_professional).equals(str)) {
            return 4;
        }
        if (f19014a.getString(R.string.camera_mode_slow_video).equals(str)) {
            return 2;
        }
        if (f19014a.getString(R.string.camera_mode_movie).equals(str)) {
            return 3;
        }
        if (f19014a.getString(R.string.camera_mode_night).equals(str)) {
            return 5;
        }
        if (f19014a.getString(R.string.camera_mode_sticker).equals(str)) {
            return 7;
        }
        if (f19014a.getString(R.string.camera_mode_super_text).equals(str)) {
            return 8;
        }
        if (f19014a.getString(R.string.camera_mode_group_shot).equals(str)) {
            return 15;
        }
        if (f19014a.getString(R.string.camera_mode_macro).equals(str)) {
            return 10;
        }
        if (f19014a.getString(R.string.camera_mode_microscope).equals(str)) {
            return 16;
        }
        if (f19014a.getString(R.string.camera_mode_time_lapse_pro).equals(str)) {
            return 25;
        }
        if (f19014a.getString(R.string.camera_mode_id_photo).equals(str)) {
            return 13;
        }
        if (f19014a.getString(R.string.camera_mode_fish_eye).equals(str)) {
            return 29;
        }
        if (f19014a.getString(R.string.camera_mode_multi_video).equals(str)) {
            return 14;
        }
        if (f19014a.getString(R.string.camera_mode_soloop).equals(str)) {
            return 17;
        }
        if (f19014a.getString(R.string.camera_mode_video).equals(str)) {
            return 21;
        }
        if (f19014a.getString(R.string.camera_mode_portrait).equals(str)) {
            return 22;
        }
        if (f19014a.getString(R.string.ultra_high_resolution_tip).equals(str)) {
            return 11;
        }
        if (f19014a.getString(R.string.high_pixel_tip).equals(str)) {
            return 31;
        }
        if (f19014a.getString(R.string.camera_mode_photo).equals(str) || f19014a.getString(R.string.camera_mode_common).equals(str)) {
            return 20;
        }
        if (f19014a.getString(R.string.camera_mode_double_exposure).equals(str)) {
            return 18;
        }
        if (f19014a.getString(R.string.camera_mode_starry).equals(str)) {
            return 19;
        }
        if (f19014a.getString(R.string.camera_mode_long_exposure).equals(str)) {
            return 27;
        }
        if (f19014a.getString(R.string.camera_mode_high_definition_48mp_oplus_r).equals(str) || f19014a.getString(R.string.camera_mode_high_definition_50mp).equals(str) || f19014a.getString(R.string.camera_mode_high_definition_64mp_oplus_r).equals(str) || f19014a.getString(R.string.camera_mode_high_definition_108mp).equals(str)) {
            return 12;
        }
        if (f19014a.getString(R.string.camera_mode_tilt_shift).equals(str)) {
            return 24;
        }
        if (f19014a.getString(R.string.camera_mode_3d_photo).equals(str)) {
            return 30;
        }
        if (f19014a.getString(R.string.camera_mode_street).equals(str)) {
            return 26;
        }
        return f19014a.getString(R.string.camera_mode_xpan).equals(str) ? 28 : -1;
    }
}
