package com.oplus.camera.ui.menu.a_renamed;

/* compiled from: HeadlineHelper.java */
/* loaded from: classes2.dex */
public class c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static android.content.Context f6346a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.util.List<java.lang.Integer> f6347b = new java.util.ArrayList();

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.util.List<java.lang.Integer> f6348c = new java.util.ArrayList();
    private java.util.List<java.lang.Integer> d_renamed = new java.util.ArrayList();
    private int e_renamed = 1;
    private boolean f_renamed = true;

    public static java.lang.String a_renamed(int i_renamed) {
        switch (i_renamed) {
            case com.oplus.camera.R_renamed.string.camera_mode_3d_photo /* 2131755586 */:
                return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_3D_PHOTO;
            case com.oplus.camera.R_renamed.string.camera_mode_breeno_scan /* 2131755593 */:
                return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_BREENO_SCAN;
            case com.oplus.camera.R_renamed.string.camera_mode_double_exposure /* 2131755595 */:
                return com.oplus.camera.aps.constant.ApsConstant.REC_MODE_DOUBLE_EXPOSURE;
            case com.oplus.camera.R_renamed.string.high_pixel_tip /* 2131756459 */:
                return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_HIGH_PIXEL;
            case com.oplus.camera.R_renamed.string.ultra_high_resolution_tip /* 2131756763 */:
                return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_ULTRA_HIGH_RESOLUTION;
            default:
                switch (i_renamed) {
                    case com.oplus.camera.R_renamed.string.camera_mode_fast_video /* 2131755597 */:
                        return com.oplus.camera.aps.constant.ApsConstant.REC_MODE_FAST_VIDEO;
                    case com.oplus.camera.R_renamed.string.camera_mode_fish_eye /* 2131755598 */:
                        return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_FISH_EYE;
                    case com.oplus.camera.R_renamed.string.camera_mode_group_shot /* 2131755599 */:
                        return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_GROUP_SHOT;
                    case com.oplus.camera.R_renamed.string.camera_mode_high_definition_108mp /* 2131755600 */:
                    case com.oplus.camera.R_renamed.string.camera_mode_high_definition_48mp_oplus_r /* 2131755601 */:
                    case com.oplus.camera.R_renamed.string.camera_mode_high_definition_50mp /* 2131755602 */:
                    case com.oplus.camera.R_renamed.string.camera_mode_high_definition_64mp_oplus_r /* 2131755603 */:
                        return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_HIGH_DEFINITION;
                    default:
                        switch (i_renamed) {
                            case com.oplus.camera.R_renamed.string.camera_mode_id_photo /* 2131755605 */:
                                return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_ID_PHOTO;
                            case com.oplus.camera.R_renamed.string.camera_mode_long_exposure /* 2131755606 */:
                                return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_LONG_EXPOSURE;
                            default:
                                switch (i_renamed) {
                                    case com.oplus.camera.R_renamed.string.camera_mode_microscope /* 2131755609 */:
                                        return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_MICROSCOPE;
                                    case com.oplus.camera.R_renamed.string.camera_mode_more /* 2131755610 */:
                                        return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_MORE;
                                    case com.oplus.camera.R_renamed.string.camera_mode_movie /* 2131755611 */:
                                        return "movie";
                                    case com.oplus.camera.R_renamed.string.camera_mode_multi_video /* 2131755612 */:
                                        return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_MULTI_VIDEO;
                                    default:
                                        switch (i_renamed) {
                                            case com.oplus.camera.R_renamed.string.camera_mode_name_soloop /* 2131755619 */:
                                                return com.oplus.camera.aps.constant.ApsConstant.REC_MODE_SOLOOP;
                                            case com.oplus.camera.R_renamed.string.camera_mode_night /* 2131755620 */:
                                                return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_NIGHT;
                                            case com.oplus.camera.R_renamed.string.camera_mode_panorama /* 2131755621 */:
                                                return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PANORAMA;
                                            default:
                                                switch (i_renamed) {
                                                    case com.oplus.camera.R_renamed.string.camera_mode_portrait /* 2131755623 */:
                                                        return "portrait";
                                                    case com.oplus.camera.R_renamed.string.camera_mode_professional /* 2131755624 */:
                                                        return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PROFESSIONAL;
                                                    case com.oplus.camera.R_renamed.string.camera_mode_slow_video /* 2131755625 */:
                                                        return com.oplus.camera.aps.constant.ApsConstant.REC_MODE_SLOW_VIDEO;
                                                    default:
                                                        switch (i_renamed) {
                                                            case com.oplus.camera.R_renamed.string.camera_mode_starry /* 2131755627 */:
                                                                return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_STARRY;
                                                            case com.oplus.camera.R_renamed.string.camera_mode_sticker /* 2131755628 */:
                                                                return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_STICKER;
                                                            case com.oplus.camera.R_renamed.string.camera_mode_street /* 2131755629 */:
                                                                return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_STREET;
                                                            case com.oplus.camera.R_renamed.string.camera_mode_super_macro /* 2131755630 */:
                                                                break;
                                                            case com.oplus.camera.R_renamed.string.camera_mode_super_text /* 2131755631 */:
                                                                return "superText";
                                                            case com.oplus.camera.R_renamed.string.camera_mode_tilt_shift /* 2131755632 */:
                                                                return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_TILT_SHIFT;
                                                            case com.oplus.camera.R_renamed.string.camera_mode_time_lapse_pro /* 2131755633 */:
                                                                return com.oplus.camera.aps.constant.ApsConstant.REC_MODE_TIMELASPE_PRO;
                                                            case com.oplus.camera.R_renamed.string.camera_mode_video /* 2131755634 */:
                                                                return com.oplus.camera.aps.constant.ApsConstant.REC_MODE_COMMON;
                                                            case com.oplus.camera.R_renamed.string.camera_mode_xpan /* 2131755635 */:
                                                                return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_XPAN;
                                                            default:
                                                                return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_COMMON;
                                                        }
                                                }
                                        }
                                }
                            case com.oplus.camera.R_renamed.string.camera_mode_macro /* 2131755607 */:
                                return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_MACRO;
                        }
                }
        }
    }

    public static java.lang.String d_renamed(int i_renamed) {
        switch (i_renamed) {
            case 0:
                return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PANORAMA;
            case 1:
                return com.oplus.camera.aps.constant.ApsConstant.REC_MODE_FAST_VIDEO;
            case 2:
                return com.oplus.camera.aps.constant.ApsConstant.REC_MODE_SLOW_VIDEO;
            case 3:
                return "movie";
            case 4:
                return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PROFESSIONAL;
            case 5:
                return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_NIGHT;
            case 6:
            case 20:
            case 23:
            default:
                return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_COMMON;
            case 7:
                return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_STICKER;
            case 8:
                return "superText";
            case 9:
                return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_BREENO_SCAN;
            case 10:
                return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_MACRO;
            case 11:
                return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_ULTRA_HIGH_RESOLUTION;
            case 12:
                return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_HIGH_DEFINITION;
            case 13:
                return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_ID_PHOTO;
            case 14:
                return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_MULTI_VIDEO;
            case 15:
                return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_GROUP_SHOT;
            case 16:
                return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_MICROSCOPE;
            case 17:
                return com.oplus.camera.aps.constant.ApsConstant.REC_MODE_SOLOOP;
            case 18:
                return com.oplus.camera.aps.constant.ApsConstant.REC_MODE_DOUBLE_EXPOSURE;
            case 19:
                return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_STARRY;
            case 21:
                return com.oplus.camera.aps.constant.ApsConstant.REC_MODE_COMMON;
            case 22:
                return "portrait";
            case 24:
                return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_TILT_SHIFT;
            case 25:
                return com.oplus.camera.aps.constant.ApsConstant.REC_MODE_TIMELASPE_PRO;
            case 26:
                return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_STREET;
            case 27:
                return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_LONG_EXPOSURE;
            case 28:
                return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_XPAN;
            case 29:
                return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_FISH_EYE;
            case 30:
                return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_3D_PHOTO;
            case 31:
                return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_HIGH_PIXEL;
        }
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:33:0x0058 A_renamed[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int e_renamed(int r0) {
        /*
            switch(r0) {
                case 2131755586: goto L64;
                case 2131755609: goto L61;
                case 2131756459: goto L5e;
                case 2131756763: goto L5b;
                default: goto L3_renamed;
            }
        L3_renamed:
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
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.menu.a_renamed.c_renamed.e_renamed(int):int");
    }

    public void a_renamed(android.content.Context context, int i_renamed, boolean z_renamed, boolean z2) {
        f6346a = context;
        this.e_renamed = i_renamed;
        this.f_renamed = z_renamed;
        this.d_renamed.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_mode_common));
        this.d_renamed.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_mode_video));
        this.d_renamed.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_mode_night));
        this.d_renamed.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_mode_portrait));
        this.d_renamed.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_mode_time_lapse_pro));
        this.d_renamed.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_mode_more));
    }

    public void a_renamed() {
        java.util.List<com.oplus.camera.ui.modepanel.i_renamed> listA;
        com.oplus.camera.e_renamed.a_renamed("HeadlineHelper", "updateMode, mCameraEntryType: " + this.e_renamed);
        int i_renamed = this.e_renamed;
        if (3 == i_renamed) {
            if (this.f6347b.contains(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_mode_video))) {
                return;
            }
            this.f6347b.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_mode_video));
            return;
        }
        if (2 == i_renamed) {
            if (!this.f6347b.contains(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_mode_common))) {
                this.f6347b.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_mode_common));
            }
            if (this.f_renamed && !this.f6347b.contains(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_mode_portrait))) {
                this.f6347b.add(java.lang.Integer.valueOf(com.oplus.camera.R_renamed.string.camera_mode_portrait));
            }
        } else if (1 == i_renamed && (listA = com.oplus.camera.ui.modepanel.b_renamed.a_renamed().a_renamed("position_headline")) != null && !listA.isEmpty()) {
            java.util.List list = (java.util.List) listA.stream().sorted(java.util.Comparator.comparing(new java.util.function.Function() { // from class: com.oplus.camera.ui.menu.a_renamed.-$$Lambda$W2ZbH78ZdPmvIDG_VbnTW6dpYS4
                @Override // java.util.function.Function
                public final java.lang.Object apply(java.lang.Object obj) {
                    return java.lang.Integer.valueOf(((com.oplus.camera.ui.modepanel.i_renamed) obj).d_renamed());
                }
            })).collect(java.util.stream.Collectors.toList());
            this.f6347b.clear();
            java.util.Iterator it = list.iterator();
            while (it.hasNext()) {
                this.f6347b.add(java.lang.Integer.valueOf(b_renamed(((com.oplus.camera.ui.modepanel.i_renamed) it.next()).e_renamed())));
            }
            com.oplus.camera.e_renamed.a_renamed("HeadlineHelper", "updateMode, query mode list from database, rankList: " + this.f6347b);
        }
        this.f6348c.clear();
        for (java.lang.Integer num : this.f6347b) {
            if (this.d_renamed.contains(num)) {
                this.f6348c.add(num);
            }
        }
    }

    public java.util.List<java.lang.Integer> b_renamed() {
        if (this.f6347b.size() <= 0) {
            a_renamed();
        }
        return com.oplus.camera.screen.a_renamed.b_renamed.g_renamed() ? this.f6348c : this.f6347b;
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:104:0x0184  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int a_renamed(java.lang.String r1) {
        /*
            Method dump skipped, instructions count: 744
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.menu.a_renamed.c_renamed.a_renamed(java.lang.String):int");
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:107:0x01a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int b_renamed(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 722
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.ui.menu.a_renamed.c_renamed.b_renamed(java.lang.String):int");
    }

    private static int c_renamed() {
        int iAH = com.oplus.camera.util.Util.aH_renamed();
        return 48 == iAH ? com.oplus.camera.R_renamed.string.camera_mode_high_definition_48mp_oplus_r : 50 == iAH ? com.oplus.camera.R_renamed.string.camera_mode_high_definition_50mp : 64 == iAH ? com.oplus.camera.R_renamed.string.camera_mode_high_definition_64mp_oplus_r : 108 == iAH ? com.oplus.camera.R_renamed.string.camera_mode_high_definition_108mp : com.oplus.camera.R_renamed.string.camera_mode_high_definition_48mp_oplus_r;
    }

    public static int b_renamed(int i_renamed) {
        switch (i_renamed) {
            case 0:
                return com.oplus.camera.R_renamed.string.camera_mode_panorama;
            case 1:
                return com.oplus.camera.R_renamed.string.camera_mode_fast_video;
            case 2:
                return com.oplus.camera.R_renamed.string.camera_mode_slow_video;
            case 3:
                return com.oplus.camera.R_renamed.string.camera_mode_movie;
            case 4:
                return com.oplus.camera.R_renamed.string.camera_mode_professional;
            case 5:
                return com.oplus.camera.R_renamed.string.camera_mode_night;
            case 6:
            default:
                return 0;
            case 7:
                return com.oplus.camera.R_renamed.string.camera_mode_sticker;
            case 8:
                return com.oplus.camera.R_renamed.string.camera_mode_super_text;
            case 9:
                return com.oplus.camera.R_renamed.string.camera_mode_breeno_scan;
            case 10:
                return com.oplus.camera.util.Util.al_renamed() ? com.oplus.camera.R_renamed.string.camera_mode_super_macro : com.oplus.camera.R_renamed.string.camera_mode_macro;
            case 11:
                return com.oplus.camera.R_renamed.string.ultra_high_resolution_tip;
            case 12:
                return c_renamed();
            case 13:
                return com.oplus.camera.R_renamed.string.camera_mode_id_photo;
            case 14:
                return com.oplus.camera.R_renamed.string.camera_mode_multi_video;
            case 15:
                return com.oplus.camera.R_renamed.string.camera_mode_group_shot;
            case 16:
                return com.oplus.camera.R_renamed.string.camera_mode_microscope;
            case 17:
                return com.oplus.camera.R_renamed.string.camera_mode_name_soloop;
            case 18:
                return com.oplus.camera.R_renamed.string.camera_mode_double_exposure;
            case 19:
                return com.oplus.camera.R_renamed.string.camera_mode_starry;
            case 20:
                return com.oplus.camera.R_renamed.string.camera_mode_common;
            case 21:
                return com.oplus.camera.R_renamed.string.camera_mode_video;
            case 22:
                return com.oplus.camera.R_renamed.string.camera_mode_portrait;
            case 23:
                return com.oplus.camera.R_renamed.string.camera_mode_more;
            case 24:
                return com.oplus.camera.R_renamed.string.camera_mode_tilt_shift;
            case 25:
                return com.oplus.camera.R_renamed.string.camera_mode_time_lapse_pro;
            case 26:
                return com.oplus.camera.R_renamed.string.camera_mode_street;
            case 27:
                return com.oplus.camera.R_renamed.string.camera_mode_long_exposure;
            case 28:
                return com.oplus.camera.R_renamed.string.camera_mode_xpan;
            case 29:
                return com.oplus.camera.R_renamed.string.camera_mode_fish_eye;
            case 30:
                return com.oplus.camera.R_renamed.string.camera_mode_3d_photo;
            case 31:
                return com.oplus.camera.R_renamed.string.high_pixel_tip;
        }
    }

    public static int c_renamed(int i_renamed) {
        switch (i_renamed) {
            case 0:
                return com.oplus.camera.R_renamed.drawable.ic_mode_panorama;
            case 1:
            case 25:
                return com.oplus.camera.R_renamed.drawable.ic_mode_timelapse;
            case 2:
                return com.oplus.camera.R_renamed.drawable.ic_mode_slomo;
            case 3:
                return com.oplus.camera.R_renamed.drawable.ic_mode_movie;
            case 4:
                return com.oplus.camera.util.Util.ao_renamed() ? com.oplus.camera.R_renamed.drawable.ic_mode_pro_moon : com.oplus.camera.R_renamed.drawable.ic_mode_pro;
            case 5:
                return com.oplus.camera.R_renamed.drawable.ic_mode_id_night;
            case 6:
            case 20:
            case 21:
            case 23:
            default:
                return 0;
            case 7:
                return com.oplus.camera.R_renamed.drawable.ic_mode_qshot;
            case 8:
                return com.oplus.camera.R_renamed.drawable.ic_mode_superword;
            case 9:
                return com.oplus.camera.R_renamed.drawable.ic_mode_id_breeno_scan;
            case 10:
                return com.oplus.camera.R_renamed.drawable.ic_mode_macro;
            case 11:
            case 12:
            case 31:
                return com.oplus.camera.R_renamed.drawable.ic_mode_ultra_high_resolution;
            case 13:
                return com.oplus.camera.R_renamed.drawable.ic_mode_id_photo;
            case 14:
                return com.oplus.camera.R_renamed.drawable.multi_video_entry;
            case 15:
            case 22:
                return com.oplus.camera.R_renamed.drawable.ic_mode_id_portrait;
            case 16:
                return com.oplus.camera.R_renamed.drawable.ic_mode_microscope;
            case 17:
                return com.oplus.camera.R_renamed.drawable.ic_mode_soloop;
            case 18:
                return com.oplus.camera.R_renamed.drawable.ic_mode_double_exposure;
            case 19:
                return com.oplus.camera.R_renamed.drawable.ic_mode_starry;
            case 24:
                return com.oplus.camera.R_renamed.drawable.ic_mode_tiltshift;
            case 26:
                return com.oplus.camera.R_renamed.drawable.ic_mode_street;
            case 27:
                return com.oplus.camera.R_renamed.drawable.ic_mode_long_exposure;
            case 28:
                return com.oplus.camera.R_renamed.drawable.ic_mode_xpan;
            case 29:
                return com.oplus.camera.R_renamed.drawable.ic_mode_fisheye;
            case 30:
                return com.oplus.camera.R_renamed.drawable.ic_mode_3d_photo;
        }
    }

    public static int c_renamed(java.lang.String str) {
        if (f6346a.getString(com.oplus.camera.R_renamed.string.camera_mode_panorama).equals(str)) {
            return 0;
        }
        if (f6346a.getString(com.oplus.camera.R_renamed.string.camera_mode_fast_video).equals(str)) {
            return 1;
        }
        if (f6346a.getString(com.oplus.camera.R_renamed.string.camera_mode_professional).equals(str)) {
            return 4;
        }
        if (f6346a.getString(com.oplus.camera.R_renamed.string.camera_mode_slow_video).equals(str)) {
            return 2;
        }
        if (f6346a.getString(com.oplus.camera.R_renamed.string.camera_mode_movie).equals(str)) {
            return 3;
        }
        if (f6346a.getString(com.oplus.camera.R_renamed.string.camera_mode_night).equals(str)) {
            return 5;
        }
        if (f6346a.getString(com.oplus.camera.R_renamed.string.camera_mode_sticker).equals(str)) {
            return 7;
        }
        if (f6346a.getString(com.oplus.camera.R_renamed.string.camera_mode_super_text).equals(str)) {
            return 8;
        }
        if (f6346a.getString(com.oplus.camera.R_renamed.string.camera_mode_group_shot).equals(str)) {
            return 15;
        }
        if (f6346a.getString(com.oplus.camera.R_renamed.string.camera_mode_macro).equals(str)) {
            return 10;
        }
        if (f6346a.getString(com.oplus.camera.R_renamed.string.camera_mode_microscope).equals(str)) {
            return 16;
        }
        if (f6346a.getString(com.oplus.camera.R_renamed.string.camera_mode_time_lapse_pro).equals(str)) {
            return 25;
        }
        if (f6346a.getString(com.oplus.camera.R_renamed.string.camera_mode_id_photo).equals(str)) {
            return 13;
        }
        if (f6346a.getString(com.oplus.camera.R_renamed.string.camera_mode_fish_eye).equals(str)) {
            return 29;
        }
        if (f6346a.getString(com.oplus.camera.R_renamed.string.camera_mode_multi_video).equals(str)) {
            return 14;
        }
        if (f6346a.getString(com.oplus.camera.R_renamed.string.camera_mode_soloop).equals(str)) {
            return 17;
        }
        if (f6346a.getString(com.oplus.camera.R_renamed.string.camera_mode_video).equals(str)) {
            return 21;
        }
        if (f6346a.getString(com.oplus.camera.R_renamed.string.camera_mode_portrait).equals(str)) {
            return 22;
        }
        if (f6346a.getString(com.oplus.camera.R_renamed.string.ultra_high_resolution_tip).equals(str)) {
            return 11;
        }
        if (f6346a.getString(com.oplus.camera.R_renamed.string.high_pixel_tip).equals(str)) {
            return 31;
        }
        if (f6346a.getString(com.oplus.camera.R_renamed.string.camera_mode_photo).equals(str) || f6346a.getString(com.oplus.camera.R_renamed.string.camera_mode_common).equals(str)) {
            return 20;
        }
        if (f6346a.getString(com.oplus.camera.R_renamed.string.camera_mode_double_exposure).equals(str)) {
            return 18;
        }
        if (f6346a.getString(com.oplus.camera.R_renamed.string.camera_mode_starry).equals(str)) {
            return 19;
        }
        if (f6346a.getString(com.oplus.camera.R_renamed.string.camera_mode_long_exposure).equals(str)) {
            return 27;
        }
        if (f6346a.getString(com.oplus.camera.R_renamed.string.camera_mode_high_definition_48mp_oplus_r).equals(str) || f6346a.getString(com.oplus.camera.R_renamed.string.camera_mode_high_definition_50mp).equals(str) || f6346a.getString(com.oplus.camera.R_renamed.string.camera_mode_high_definition_64mp_oplus_r).equals(str) || f6346a.getString(com.oplus.camera.R_renamed.string.camera_mode_high_definition_108mp).equals(str)) {
            return 12;
        }
        if (f6346a.getString(com.oplus.camera.R_renamed.string.camera_mode_tilt_shift).equals(str)) {
            return 24;
        }
        if (f6346a.getString(com.oplus.camera.R_renamed.string.camera_mode_3d_photo).equals(str)) {
            return 30;
        }
        if (f6346a.getString(com.oplus.camera.R_renamed.string.camera_mode_street).equals(str)) {
            return 26;
        }
        return f6346a.getString(com.oplus.camera.R_renamed.string.camera_mode_xpan).equals(str) ? 28 : -1;
    }
}
