package com.oplus.camera.entry;

/* compiled from: CameraEntry.java */
/* loaded from: classes2.dex */
public class b_renamed implements com.oplus.camera.entry.a_renamed {
    private static java.lang.Long h_renamed = -1L;
    private int i_renamed = 1;
    private int j_renamed = -1;
    private java.lang.String k_renamed = "";
    private android.app.Activity l_renamed = null;
    private java.lang.String m_renamed = "";
    private long n_renamed = 0;
    private boolean o_renamed = false;
    private boolean p_renamed = false;
    private boolean q_renamed = false;
    private boolean r_renamed = false;
    private boolean s_renamed = false;
    private boolean t_renamed = false;
    private boolean u_renamed = false;
    private float v_renamed = 0.0f;
    private boolean w_renamed = false;
    private int x_renamed = 3;
    private boolean y_renamed = true;
    private boolean z_renamed = true;
    private boolean A_renamed = false;
    private android.content.SharedPreferences B_renamed = null;
    private java.lang.String C_renamed = null;
    private int D_renamed = -1;
    private int E_renamed = 0;
    private java.util.Set<java.lang.String> F_renamed = new java.util.HashSet();

    /* compiled from: CameraEntry.java */
    private enum a_renamed {
        front_main,
        front_dual,
        front_wide,
        back_main,
        back_dual,
        back_second_dual,
        back_sat,
        back_wide,
        back_tele,
        back_mono,
        back_macro,
        back_streamer_main,
        back_microscope
    }

    public static boolean b_renamed(int i_renamed) {
        return 2 == i_renamed || 3 == i_renamed;
    }

    public void E_renamed() {
    }

    public void a_renamed(boolean z_renamed) {
        if ((1 == J_renamed() || 2 == J_renamed()) && !this.z_renamed) {
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            com.oplus.camera.e_renamed.a_renamed("CameraEntry", "saveCameraExitState, currentTime: " + jCurrentTimeMillis + ", justSaveTimeStamp: " + z_renamed);
            if (!z_renamed) {
                this.z_renamed = true;
            }
            android.content.SharedPreferences.Editor editorEdit = this.B_renamed.edit();
            if (!b_renamed(J_renamed())) {
                editorEdit.putLong(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_EXIT_TIME_STAMP, jCurrentTimeMillis);
            } else {
                editorEdit.putLong(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_EXIT_TIME_STAMP_FROM_OTHER_APP, jCurrentTimeMillis);
            }
            editorEdit.apply();
        }
    }

    public void b_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.a_renamed("CameraEntry", "set mbShouldKeepCurrentMode: " + z_renamed);
        this.A_renamed = z_renamed;
    }

    public boolean a_renamed() {
        return this.A_renamed;
    }

    public boolean b_renamed() {
        long j_renamed = this.B_renamed.getLong(com.oplus.camera.ui.CameraUIInterface.KEY_REPORT_PERMISSION_TIME_STAMP, 0L);
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        if (jCurrentTimeMillis - j_renamed <= 86400000) {
            return false;
        }
        this.B_renamed.edit().putLong(com.oplus.camera.ui.CameraUIInterface.KEY_REPORT_PERMISSION_TIME_STAMP, jCurrentTimeMillis).apply();
        return true;
    }

    public boolean c_renamed() {
        return V_renamed() && this.y_renamed;
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:92:0x0156  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean a_renamed(java.lang.String r4, com.oplus.camera.entry.b_renamed.a_renamed r5) {
        /*
            Method dump skipped, instructions count: 988
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.entry.b_renamed.a_renamed(java.lang.String, com.oplus.camera.entry.b_renamed$a_renamed):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:209:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:221:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:304:0x04f7  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:308:0x0500  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:331:0x0533  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:341:0x054f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean b_renamed(java.lang.String r22, com.oplus.camera.entry.b_renamed.a_renamed r23) {
        /*
            Method dump skipped, instructions count: 1412
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.entry.b_renamed.b_renamed(java.lang.String, com.oplus.camera.entry.b_renamed$a_renamed):boolean");
    }

    public int a_renamed(java.lang.String str, int i_renamed) {
        if (com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_MULTI_VIDEO.equals(str)) {
            return com.oplus.camera.e_renamed.a_renamed.s_renamed();
        }
        if (i_renamed == 1) {
            if (b_renamed(str, com.oplus.camera.entry.b_renamed.a_renamed.front_dual)) {
                return com.oplus.camera.e_renamed.a_renamed.n_renamed();
            }
            if (b_renamed(str, com.oplus.camera.entry.b_renamed.a_renamed.front_wide)) {
                return com.oplus.camera.e_renamed.a_renamed.k_renamed();
            }
            return com.oplus.camera.e_renamed.a_renamed.i_renamed();
        }
        if (b_renamed(str, com.oplus.camera.entry.b_renamed.a_renamed.back_mono) || b_renamed(str, com.oplus.camera.entry.b_renamed.a_renamed.back_streamer_main)) {
            int iC = c_renamed(str);
            com.oplus.camera.e_renamed.b_renamed("CameraEntry", "getLogicCameraId, notDualCameraId: " + iC);
            if (-1 != iC) {
                return iC;
            }
        }
        if (b_renamed(str, com.oplus.camera.entry.b_renamed.a_renamed.back_dual)) {
            return com.oplus.camera.e_renamed.a_renamed.l_renamed();
        }
        if (b_renamed(str, com.oplus.camera.entry.b_renamed.a_renamed.back_second_dual)) {
            return com.oplus.camera.e_renamed.a_renamed.m_renamed();
        }
        if (b_renamed(str, com.oplus.camera.entry.b_renamed.a_renamed.back_tele)) {
            return com.oplus.camera.e_renamed.a_renamed.o_renamed();
        }
        if (b_renamed(str, com.oplus.camera.entry.b_renamed.a_renamed.back_macro)) {
            if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MACROLENS_EQUAL_ULTRAWIDELENS)) {
                return com.oplus.camera.e_renamed.a_renamed.j_renamed();
            }
            return com.oplus.camera.e_renamed.a_renamed.r_renamed();
        }
        if (b_renamed(str, com.oplus.camera.entry.b_renamed.a_renamed.back_wide) && J_renamed() == 1) {
            return com.oplus.camera.e_renamed.a_renamed.j_renamed();
        }
        if (b_renamed(str, com.oplus.camera.entry.b_renamed.a_renamed.back_sat) && this.i_renamed == 1) {
            return com.oplus.camera.e_renamed.a_renamed.p_renamed();
        }
        if (b_renamed(str, com.oplus.camera.entry.b_renamed.a_renamed.back_microscope) && this.i_renamed == 1) {
            return com.oplus.camera.e_renamed.a_renamed.q_renamed();
        }
        return com.oplus.camera.e_renamed.a_renamed.h_renamed();
    }

    public java.lang.String d_renamed() {
        java.lang.String str = this.C_renamed;
        return str != null ? str : this.i_renamed == 3 ? com.oplus.camera.aps.constant.ApsConstant.REC_MODE_COMMON : (!c_renamed() || a_renamed()) ? this.B_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_MODE, com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_COMMON) : com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_COMMON;
    }

    public java.lang.String a_renamed(int i_renamed) {
        java.lang.String str = this.C_renamed;
        return str != null ? str : this.i_renamed == 3 ? com.oplus.camera.aps.constant.ApsConstant.REC_MODE_COMMON : (!c_renamed() || a_renamed()) ? ((com.oplus.camera.ComboPreferences) this.B_renamed).a_renamed(this.l_renamed, i_renamed).getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_MODE, com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_COMMON) : com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_COMMON;
    }

    public int e_renamed() {
        return this.D_renamed;
    }

    public int f_renamed() {
        return this.E_renamed;
    }

    public boolean g_renamed() {
        return q_renamed() && this.F_renamed.contains("effect");
    }

    public boolean h_renamed() {
        return this.t_renamed;
    }

    public boolean i_renamed() {
        return q_renamed() && (this.F_renamed.contains("beauty") || this.F_renamed.contains(com.oplus.camera.statistics.model.MenuClickMsgData.KEY_FILTER));
    }

    public void j_renamed() {
        c_renamed(true);
    }

    public void c_renamed(boolean z_renamed) {
        this.C_renamed = null;
        this.F_renamed.clear();
        if (z_renamed) {
            this.y_renamed = false;
        }
    }

    public boolean k_renamed() {
        return q_renamed() && this.F_renamed.contains("encode10bit");
    }

    public boolean l_renamed() {
        return this.k_renamed.contains("retail") && !h_renamed();
    }

    public int m_renamed() throws java.lang.NumberFormatException {
        int intExtra = java.lang.Integer.parseInt(this.B_renamed.getString(com.oplus.camera.ui.CameraUIInterface.KEY_CAMERA_ID, java.lang.String.valueOf(0)));
        if (com.oplus.camera.screen.a_renamed.b_renamed.g_renamed()) {
            return 0;
        }
        if (com.oplus.camera.screen.a_renamed.b_renamed.h_renamed()) {
            return 1;
        }
        if (com.oplus.camera.util.Util.t_renamed() && this.C_renamed == null && !"com.heytap.speechassist".equals(this.k_renamed)) {
            return intExtra;
        }
        if (c_renamed() && !a_renamed()) {
            intExtra = 0;
        }
        try {
            intExtra = this.l_renamed.getIntent().getIntExtra("android.intent.extras.CAMERA_FACING", intExtra);
            if (intExtra > 1) {
                intExtra = 1;
            }
            if (this.r_renamed) {
                if (this.l_renamed.getIntent().getBooleanExtra("android.intent.extra.USE_FRONT_CAMERA", false) || this.l_renamed.getIntent().getBooleanExtra("com.google.assistant.extra.USE_FRONT_CAMERA", false)) {
                    intExtra = 1;
                } else if (n_renamed()) {
                    intExtra = 0;
                }
            }
        } catch (java.lang.Exception e_renamed) {
            e_renamed.printStackTrace();
        }
        com.oplus.camera.e_renamed.a_renamed("CameraEntry", "getIntentLegacyId, mCameraEntryType: " + this.i_renamed + ", cameraId: " + intExtra);
        return intExtra;
    }

    public boolean n_renamed() {
        android.os.Bundle extras = this.l_renamed.getIntent().getExtras();
        if (extras != null) {
            return extras.containsKey("com.oplus.camera.extra.IS_VOICE_INTERACTION_ROOT") || extras.containsKey("isVoiceQuery");
        }
        return false;
    }

    private boolean V_renamed() {
        return 1 == J_renamed() || 2 == J_renamed();
    }

    public static long o_renamed() {
        return h_renamed.longValue();
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void p_renamed() {
        /*
            r11 = this;
            android.content.SharedPreferences r0 = r11.B_renamed
            r1 = 0
            java.lang.String r3 = "pref_camera_exit_time_stamp_key"
            long r3 = r0.getLong(r3, r1)
            int r0 = r11.i_renamed
            boolean r0 = b_renamed(r0)
            r5 = 2131755451(0x7f1001bb, float:1.9141782E38)
            java.lang.String r6 = "pref_camera_flashmode_key"
            if (r0 == 0) goto L38
            android.content.SharedPreferences r0 = r11.B_renamed
            java.lang.String r3 = "pref_camera_exit_time_from_other_program_code"
            long r3 = r0.getLong(r3, r1)
            android.content.SharedPreferences r0 = r11.B_renamed
            android.content.SharedPreferences$Editor r0 = r0.edit()
            int r7 = r11.i_renamed
            java.lang.String r7 = b_renamed(r6, r7)
            android.app.Activity r8 = r11.l_renamed
            java.lang.String r8 = r8.getString(r5)
            android.content.SharedPreferences$Editor r0 = r0.putString(r7, r8)
            r0.apply()
        L38:
            long r7 = java.lang.System.currentTimeMillis()
            long r9 = r7 - r3
            r11.n_renamed = r9
            java.lang.Long r0 = java.lang.Long.valueOf(r7)
            com.oplus.camera.entry.b_renamed.h_renamed = r0
            boolean r0 = r11.V_renamed()
            r9 = 0
            if (r0 == 0) goto L99
            boolean r0 = r11.z_renamed
            if (r0 == 0) goto L96
            r11.z_renamed = r9
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r10 = "updateOverrideCameraModeStatus, currentTime: "
            r0.append(r10)
            r0.append(r7)
            java.lang.String r7 = ", timeStamp: "
            r0.append(r7)
            r0.append(r3)
            java.lang.String r7 = ", mCameraEnterTimeGap: "
            r0.append(r7)
            long r7 = r11.n_renamed
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            java.lang.String r7 = "CameraEntry"
            com.oplus.camera.e_renamed.a_renamed(r7, r0)
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 >= 0) goto L93
            long r3 = r11.n_renamed
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 >= 0) goto L93
            r0 = 300000(0x493e0, double:1.482197E-318)
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L93
            r0 = 1
            r11.y_renamed = r0
            r11.b_renamed(r9)
            goto Lb4
        L93:
            r11.y_renamed = r9
            goto Lb4
        L96:
            r11.y_renamed = r9
            goto Lb4
        L99:
            boolean r0 = r11.q_renamed()
            if (r0 == 0) goto La6
            boolean r0 = r11.z_renamed
            if (r0 == 0) goto Lb4
            r11.z_renamed = r9
            goto Lb4
        La6:
            boolean r0 = r11.w_renamed()
            if (r0 == 0) goto Lb4
            boolean r0 = r11.z_renamed
            if (r0 == 0) goto Lb4
            r11.z_renamed = r9
            r11.y_renamed = r9
        Lb4:
            int r0 = r11.i_renamed
            boolean r0 = b_renamed(r0)
            if (r0 == 0) goto Ld5
            android.content.SharedPreferences r0 = r11.B_renamed
            android.content.SharedPreferences$Editor r0 = r0.edit()
            int r1 = r11.i_renamed
            java.lang.String r1 = b_renamed(r6, r1)
            android.app.Activity r11 = r11.l_renamed
            java.lang.String r11 = r11.getString(r5)
            android.content.SharedPreferences$Editor r11 = r0.putString(r1, r11)
            r11.apply()
        Ld5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.entry.b_renamed.p_renamed():void");
    }

    public boolean q_renamed() {
        return (this.C_renamed == null && this.F_renamed.isEmpty()) ? false : true;
    }

    public boolean r_renamed() {
        return q_renamed() && this.C_renamed == "portrait";
    }

    private void a_renamed(android.content.Intent intent, android.os.Bundle bundle) throws java.lang.NumberFormatException {
        int intExtra;
        boolean booleanExtra;
        boolean booleanExtra2;
        boolean booleanExtra3;
        android.os.Bundle extras = intent.getExtras();
        if ("android.intent.action.MAIN".equals(this.m_renamed)) {
            return;
        }
        if (!"com.oplus.camera.action.SHORTCUT_TYPE_MENU".equals(this.m_renamed) || bundle == null) {
            this.F_renamed.clear();
            O_renamed();
            com.oplus.camera.e_renamed.a_renamed("CameraEntry", "parseIntentExtraInfo, mAction: " + this.m_renamed + ", extras: " + extras);
            try {
                intExtra = intent.getIntExtra("mode", -1);
            } catch (java.lang.Exception e_renamed) {
                e_renamed.printStackTrace();
                intExtra = -1;
            }
            if ("com.heytap.lab".equals(this.k_renamed) && -1 == intExtra) {
                intExtra = java.lang.Integer.parseInt(intent.getStringExtra("mode"));
            }
            if (intExtra != -1) {
                if (intExtra == 7 && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_TIME_LAPSE_PRO_SUPPORT)) {
                    intExtra = 19;
                }
                this.C_renamed = com.oplus.camera.entry.c_renamed.a_renamed(intExtra);
                if (!a_renamed(this.C_renamed)) {
                    intent.putExtra("android.intent.extras.CAMERA_FACING", 0);
                    this.F_renamed.add(com.oplus.camera.statistics.model.DcsMsgData.REAR);
                }
            }
            if (extras != null && extras.containsKey("encode10bit")) {
                try {
                    this.t_renamed = intent.getBooleanExtra("encode10bit", false);
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
                this.F_renamed.add("encode10bit");
            } else {
                this.t_renamed = false;
            }
            try {
                booleanExtra = intent.getBooleanExtra(com.oplus.camera.statistics.model.DcsMsgData.REAR, false);
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
                booleanExtra = false;
            }
            if (booleanExtra) {
                intent.putExtra("android.intent.extras.CAMERA_FACING", 0);
                this.F_renamed.add(com.oplus.camera.statistics.model.DcsMsgData.REAR);
                if (this.C_renamed == null && !"com.heytap.speechassist".equals(this.k_renamed)) {
                    this.C_renamed = com.oplus.camera.entry.c_renamed.a_renamed(0);
                }
            }
            try {
                booleanExtra2 = intent.getBooleanExtra(com.oplus.camera.statistics.model.DcsMsgData.FRONT, false);
            } catch (java.lang.Exception e3) {
                e3.printStackTrace();
                booleanExtra2 = false;
            }
            if (booleanExtra2) {
                intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
                this.F_renamed.add(com.oplus.camera.statistics.model.DcsMsgData.FRONT);
                if (this.C_renamed == null) {
                    this.C_renamed = com.oplus.camera.entry.c_renamed.a_renamed(0);
                }
            }
            try {
                booleanExtra3 = intent.getBooleanExtra("beauty", false);
            } catch (java.lang.Exception e4) {
                e4.printStackTrace();
                booleanExtra3 = false;
            }
            if (booleanExtra3) {
                this.F_renamed.add("beauty");
            }
            this.D_renamed = -1;
            this.E_renamed = 0;
            try {
                this.D_renamed = intent.getIntExtra("effect", -1);
            } catch (java.lang.Exception e5) {
                e5.printStackTrace();
            }
            if (this.D_renamed > 0) {
                this.F_renamed.add("effect");
                if (this.D_renamed == 4) {
                    try {
                        this.E_renamed = intent.getIntExtra(com.oplus.camera.statistics.model.MenuClickMsgData.KEY_FILTER, 0);
                    } catch (java.lang.Exception e6) {
                        e6.printStackTrace();
                    }
                }
            }
            if (intent.getBooleanExtra("com.oplus.camera.extra.IS_VOICE_INTERACTION_ROOT", false) && "android.media.action.STILL_IMAGE_CAMERA".equals(this.m_renamed) && !intent.getBooleanExtra("com.google.assistant.extra.CAMERA_OPEN_ONLY", false) && (intent.getFlags() & com.google.android.exoplayer2.source.ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES) == 0) {
                this.w_renamed = true;
                com.oplus.camera.e_renamed.a_renamed("CameraEntry", "parseIntentExtraInfo, set mbRequstVoiceCapture true");
            }
            if (this.w_renamed) {
                int intExtra2 = intent.getIntExtra("com.google.assistant.extrPACKAGE_NAME_HEYTAP_MARKETa.TIMER_DURATION_SECONDS", 3);
                com.oplus.camera.e_renamed.a_renamed("CameraEntry", "parseIntentExtraInfo, delayDuration: " + intExtra2);
                if (intExtra2 > 0 && intExtra2 <= 10) {
                    this.x_renamed = intExtra2;
                } else if (intExtra2 > 10) {
                    this.x_renamed = 10;
                }
            }
            try {
                this.v_renamed = intent.getFloatExtra(com.oplus.camera.statistics.CameraStatisticsUtil.PORTRAIT_ZOOM, 0.0f);
            } catch (java.lang.Exception e7) {
                e7.printStackTrace();
            }
            if ("com.oplus.camera.action.SHORTCUT_TYPE_MENU".equals(this.m_renamed) && java.lang.Float.compare(this.v_renamed, 0.0f) != 0) {
                this.u_renamed = true;
                this.C_renamed = com.oplus.camera.entry.c_renamed.a_renamed(0);
                intent.putExtra("android.intent.extras.CAMERA_FACING", 0);
                this.F_renamed.add(com.oplus.camera.statistics.model.DcsMsgData.REAR);
            }
            com.oplus.camera.e_renamed.b_renamed("CameraEntry", "parseIntentExtraInfo, mBestOpticalZoomValue: " + this.v_renamed + ", mExtraIntent: " + this.F_renamed);
            com.oplus.camera.util.AndroidTestHelper.init(intent);
        }
    }

    public boolean s_renamed() {
        return this.u_renamed;
    }

    public void t_renamed() {
        this.u_renamed = false;
    }

    public float u_renamed() {
        return this.v_renamed;
    }

    public java.lang.String v_renamed() {
        return this.k_renamed;
    }

    public boolean w_renamed() {
        return "android.media.action.STILL_IMAGE_CAMERA_SECURE".equals(this.m_renamed) || this.q_renamed;
    }

    public boolean x_renamed() {
        return this.w_renamed;
    }

    public void y_renamed() {
        this.s_renamed = false;
    }

    public void z_renamed() {
        this.w_renamed = false;
    }

    public int A_renamed() {
        return this.x_renamed;
    }

    public boolean B_renamed() {
        return this.p_renamed && !this.q_renamed;
    }

    public void C_renamed() {
        android.app.KeyguardManager keyguardManagerW = W_renamed();
        if (keyguardManagerW != null) {
            keyguardManagerW.requestDismissKeyguard(this.l_renamed, null);
        }
    }

    public boolean D_renamed() {
        android.app.KeyguardManager keyguardManagerW = W_renamed();
        if (keyguardManagerW != null) {
            return keyguardManagerW.isKeyguardLocked();
        }
        return false;
    }

    public void F_renamed() {
        if (w_renamed()) {
            this.l_renamed.setShowWhenLocked(true);
        } else {
            this.l_renamed.setShowWhenLocked(false);
        }
        this.o_renamed = false;
    }

    public void d_renamed(boolean z_renamed) {
        if (z_renamed && !w_renamed()) {
            this.l_renamed.setShowWhenLocked(false);
        }
        this.o_renamed = true;
    }

    public void G_renamed() {
        if (w_renamed()) {
            this.l_renamed.setShowWhenLocked(false);
        }
        this.l_renamed = null;
    }

    public boolean H_renamed() {
        return this.o_renamed;
    }

    public static boolean a_renamed(java.lang.String str) {
        if (com.oplus.camera.aps.constant.ApsConstant.REC_MODE_SLOW_VIDEO.equals(str) || "movie".equals(str) || com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_NIGHT.equals(str) || com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PROFESSIONAL.equals(str) || com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_MACRO.equals(str) || com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_HIGH_DEFINITION.equals(str) || com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_STREET.equals(str)) {
            return false;
        }
        if (com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PANORAMA.equals(str)) {
            return com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_FRONT_PANORAMA_SUPPORT);
        }
        return true;
    }

    public static boolean b_renamed(java.lang.String str) {
        return com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_STICKER.equals(str) || com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_COMMON.equals(str) || "portrait".equals(str) || com.oplus.camera.aps.constant.ApsConstant.REC_MODE_COMMON.equals(str);
    }

    private void b_renamed(android.content.Intent intent, android.os.Bundle bundle) throws java.lang.NumberFormatException {
        if (intent == null) {
            com.oplus.camera.e_renamed.f_renamed("CameraEntry", "parseIntent, intent is_renamed null");
            return;
        }
        this.m_renamed = intent.getAction();
        b_renamed(intent);
        java.lang.String str = this.m_renamed;
        if (str != null) {
            if ("android.media.action.STILL_IMAGE_CAMERA_SECURE".equals(str)) {
                this.s_renamed = true;
                this.i_renamed = 1;
            } else if ("android.media.action.IMAGE_CAPTURE".equals(this.m_renamed) || "android.media.action.IMAGE_CAPTURE_SECURE".equals(this.m_renamed)) {
                this.i_renamed = 2;
                this.C_renamed = com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_COMMON;
            } else if ("android.media.action.VIDEO_CAPTURE".equals(this.m_renamed) || "com.oplus.action.VIDEO_CAPTURE".equals(this.m_renamed)) {
                this.i_renamed = 3;
                this.C_renamed = com.oplus.camera.aps.constant.ApsConstant.REC_MODE_COMMON;
            } else if ("com.oplus.action.VIDEO_CAMERA".equals(this.m_renamed)) {
                this.i_renamed = 1;
                this.C_renamed = com.oplus.camera.aps.constant.ApsConstant.REC_MODE_COMMON;
            } else if ("android.media.action.STILL_IMAGE_CAMERA".equals(this.m_renamed)) {
                this.s_renamed = true;
                this.r_renamed = true;
                this.i_renamed = 1;
                if (n_renamed()) {
                    this.C_renamed = com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_COMMON;
                }
            } else {
                this.i_renamed = 1;
            }
            if (N_renamed()) {
                android.app.Application application = this.l_renamed.getApplication();
                if (application instanceof com.oplus.camera.MyApplication) {
                    ((com.oplus.camera.MyApplication) application).i_renamed();
                }
                java.lang.String configStringValue = com.oplus.camera.aps.config.CameraConfig.getConfigStringValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_QUICK_LAUNCH_SUPPORT_MODE);
                boolean zHasExtra = intent.hasExtra("android_camera_launch_type");
                if (configStringValue != null && zHasExtra) {
                    intent.putExtra("mode", java.lang.Integer.valueOf(configStringValue));
                }
            }
        }
        com.oplus.camera.e_renamed.a_renamed("CameraEntry", "parseIntent, mCameraEntryType: " + this.i_renamed + ", mCallPkg: " + this.k_renamed + ", mAction: " + this.m_renamed);
        a_renamed(intent, bundle);
        if (w_renamed()) {
            this.l_renamed.setShowWhenLocked(true);
        }
        if (B_renamed()) {
            C_renamed();
        }
    }

    public void a_renamed(android.content.Intent intent, android.app.Activity activity, android.content.SharedPreferences sharedPreferences, android.os.Bundle bundle) {
        this.l_renamed = activity;
        this.B_renamed = sharedPreferences;
        b_renamed(intent, bundle);
        p_renamed();
        com.oplus.camera.e_renamed.a_renamed("CameraEntry", "onCreate, mCameraEntryType: " + this.i_renamed + ", mCallPkg: " + this.k_renamed + ", mAction: " + this.m_renamed);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:17:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:18:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:22:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b_renamed(android.content.Intent r5) {
        /*
            r4 = this;
            java.lang.String r0 = ""
            r4.k_renamed = r0
            r0 = 0
            android.app.Activity r1 = r4.l_renamed     // Catch: java.lang.Exception -> Lc
            android.net.Uri r1 = r1.getReferrer()     // Catch: java.lang.Exception -> Lc
            goto L11
        Lc:
            r1 = move-exception
            r1.printStackTrace()
            r1 = r0
        L11:
            java.lang.String r2 = "extra_key_caller_package_name"
            java.lang.String r2 = r5.getStringExtra(r2)     // Catch: java.lang.Exception -> L20
            java.lang.String r3 = "android_camera_launch_type"
            java.lang.String r0 = r5.getStringExtra(r3)     // Catch: java.lang.Exception -> L1e
            goto L25
        L1e:
            r5 = move-exception
            goto L22
        L20:
            r5 = move-exception
            r2 = r0
        L22:
            r5.printStackTrace()
        L25:
            boolean r5 = android.text.TextUtils.isEmpty(r2)
            if (r5 != 0) goto L2e
            r4.k_renamed = r2
            goto L36
        L2e:
            if (r1 == 0) goto L36
            java.lang.String r5 = r1.getHost()
            r4.k_renamed = r5
        L36:
            boolean r5 = android.text.TextUtils.isEmpty(r0)
            if (r5 != 0) goto L5f
            java.lang.String r5 = "gimbal_launch_from_framework"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L48
            r5 = 4
            r4.j_renamed = r5
            goto L5f
        L48:
            java.lang.String r5 = "quick_launch_from_framework"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L54
            r5 = 5
            r4.j_renamed = r5
            goto L5f
        L54:
            java.lang.String r5 = "watch_launch_from_framework"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L5f
            r5 = 6
            r4.j_renamed = r5
        L5f:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = "initCallPkg, mCallPkg: "
            r5.append(r0)
            java.lang.String r0 = r4.k_renamed
            r5.append(r0)
            java.lang.String r0 = ", mCameraEntryTypeFromFramework: "
            r5.append(r0)
            int r4 = r4.j_renamed
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.String r5 = "CameraEntry"
            com.oplus.camera.e_renamed.a_renamed(r5, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.entry.b_renamed.b_renamed(android.content.Intent):void");
    }

    public boolean a_renamed(android.content.Intent intent) throws java.lang.NumberFormatException {
        com.oplus.camera.e_renamed.a_renamed("CameraEntry", "onNewIntent");
        android.app.Activity activity = this.l_renamed;
        if (activity == null) {
            com.oplus.camera.e_renamed.f_renamed("CameraEntry", "onNewIntent, mActivity is_renamed null");
            return false;
        }
        if (activity.getCallingActivity() != null) {
            intent.setFlags(469762048);
            this.l_renamed.finish();
            this.l_renamed.overridePendingTransition(com.oplus.camera.R_renamed.anim.coui_close_slide_enter, com.oplus.camera.R_renamed.anim.coui_close_slide_exit);
            this.l_renamed.startActivity(intent);
            return false;
        }
        this.l_renamed.setIntent(intent);
        b_renamed(intent, (android.os.Bundle) null);
        return true;
    }

    public java.lang.String I_renamed() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.C_renamed);
        sb.append(this.F_renamed.contains("beauty") ? "beauty" : "");
        return sb.toString();
    }

    public int J_renamed() {
        return this.i_renamed;
    }

    public long K_renamed() {
        return this.n_renamed;
    }

    public int c_renamed(java.lang.String str) {
        int i_renamed = this.B_renamed.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_INDEX, com.oplus.camera.ui.preview.a_renamed.j_renamed.p_renamed());
        int configIntValue = com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MONO_FILTER_MODE_PLACE);
        if ((configIntValue == 0 || 3 == configIntValue) && com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_COMMON.equals(str)) {
            i_renamed = this.B_renamed.getInt("key_filter_index", com.oplus.camera.ui.preview.a_renamed.j_renamed.s_renamed());
        } else if ((1 == configIntValue || 3 == configIntValue) && "portrait".equals(str)) {
            i_renamed = this.B_renamed.getInt(com.oplus.camera.ui.CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_INDEX, com.oplus.camera.ui.preview.a_renamed.j_renamed.p_renamed());
        }
        if (i_renamed == com.oplus.camera.ui.preview.a_renamed.j_renamed.h_renamed()) {
            return com.oplus.camera.ui.preview.a_renamed.j_renamed.u_renamed();
        }
        if (i_renamed == com.oplus.camera.ui.preview.a_renamed.j_renamed.i_renamed()) {
            return com.oplus.camera.ui.preview.a_renamed.j_renamed.v_renamed();
        }
        if (i_renamed == com.oplus.camera.ui.preview.a_renamed.j_renamed.j_renamed()) {
            return com.oplus.camera.ui.preview.a_renamed.j_renamed.w_renamed();
        }
        if (i_renamed == com.oplus.camera.ui.preview.a_renamed.j_renamed.k_renamed()) {
            return com.oplus.camera.ui.preview.a_renamed.j_renamed.x_renamed();
        }
        if (i_renamed == com.oplus.camera.ui.preview.a_renamed.j_renamed.l_renamed()) {
            return com.oplus.camera.e_renamed.a_renamed.h_renamed();
        }
        return -1;
    }

    public boolean L_renamed() {
        return -1 != this.j_renamed;
    }

    public int M_renamed() {
        return L_renamed() ? this.j_renamed : this.i_renamed;
    }

    public boolean N_renamed() {
        int i_renamed = this.j_renamed;
        return 5 == i_renamed || 6 == i_renamed;
    }

    public void O_renamed() {
        android.app.KeyguardManager keyguardManagerW;
        if (!L_renamed() || (keyguardManagerW = W_renamed()) == null) {
            return;
        }
        if (keyguardManagerW.isKeyguardLocked() && keyguardManagerW.isKeyguardSecure()) {
            this.q_renamed = true;
        }
        if (keyguardManagerW.isKeyguardLocked() || keyguardManagerW.isKeyguardSecure()) {
            this.p_renamed = true;
        }
    }

    private android.app.KeyguardManager W_renamed() {
        android.app.Activity activity = this.l_renamed;
        if (activity == null) {
            return null;
        }
        return (android.app.KeyguardManager) activity.getSystemService("keyguard");
    }

    public boolean P_renamed() {
        return this.p_renamed || w_renamed();
    }

    public static java.lang.String b_renamed(java.lang.String str, int i_renamed) {
        return (b_renamed(i_renamed) && -1 == e_renamed(str)) ? str.concat("_from_other_app") : str;
    }

    public static java.lang.String d_renamed(java.lang.String str) {
        int iE = e_renamed(str);
        return iE > 0 ? str.substring(0, iE) : str;
    }

    public boolean Q_renamed() {
        return "com.heytap.speechassist".equals(this.k_renamed);
    }

    public boolean R_renamed() {
        return "com.oplus.camera.action.SHORTCUT_TYPE_MENU".equals(this.m_renamed);
    }

    public boolean S_renamed() {
        return "com.oplus.appplatform".equals(this.k_renamed);
    }

    public boolean T_renamed() {
        return ("android.media.action.STILL_IMAGE_CAMERA".equals(this.m_renamed) || "android.media.action.STILL_IMAGE_CAMERA_SECURE".equals(this.m_renamed)) && this.s_renamed;
    }

    public boolean U_renamed() {
        float[] configFloatArrayValue = com.oplus.camera.aps.config.CameraConfig.getConfigFloatArrayValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_HYPER_LAPSE_ZOOM_LIST_SUPPORT);
        return (configFloatArrayValue == null || configFloatArrayValue.length == 0 || configFloatArrayValue[0] != 0.6f) ? false : true;
    }

    private static int e_renamed(java.lang.String str) {
        if (str == null) {
            return -2;
        }
        return str.indexOf("_from_other_app");
    }

    private boolean X_renamed() {
        int i_renamed = this.B_renamed.getInt("key_filter_index", com.oplus.camera.ui.preview.a_renamed.j_renamed.s_renamed());
        return i_renamed == com.oplus.camera.ui.preview.a_renamed.j_renamed.h_renamed() || i_renamed == com.oplus.camera.ui.preview.a_renamed.j_renamed.i_renamed() || i_renamed == com.oplus.camera.ui.preview.a_renamed.j_renamed.j_renamed() || i_renamed == com.oplus.camera.ui.preview.a_renamed.j_renamed.k_renamed();
    }
}
