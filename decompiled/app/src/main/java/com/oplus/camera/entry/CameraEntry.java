package com.oplus.camera.entry;

import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.oplus.camera.CameraLog;
import com.oplus.camera.ComboPreferences;
import com.oplus.camera.MyApplication;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.preview.p177a.FilterHelper;
import com.oplus.camera.screen.p163a.OutCaptureManager;
import com.oplus.camera.statistics.CameraStatisticsUtil;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.statistics.model.MenuClickMsgData;
import com.oplus.camera.util.AndroidTestHelper;
import com.oplus.camera.util.Util;
import java.util.HashSet;
import java.util.Set;

/* compiled from: CameraEntry.java */
/* renamed from: com.oplus.camera.entry.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class CameraEntry implements CameraCallConstant {

    /* renamed from: COUIBaseListPopupWindow_10 */
    private static Long f13545h = -1L;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f13552i = 1;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f13553j = -1;

    /* renamed from: OplusGLSurfaceView_5 */
    private String f13554k = "";

    /* renamed from: OplusGLSurfaceView_14 */
    private Activity f13555l = null;

    /* renamed from: OplusGLSurfaceView_6 */
    private String f13556m = "";

    /* renamed from: OplusGLSurfaceView_11 */
    private long f13557n = 0;

    /* renamed from: o */
    private boolean f13558o = false;

    /* renamed from: p */
    private boolean f13559p = false;

    /* renamed from: q */
    private boolean f13560q = false;

    /* renamed from: r */
    private boolean f13561r = false;

    /* renamed from: s */
    private boolean f13562s = false;

    /* renamed from: t */
    private boolean f13563t = false;

    /* renamed from: u */
    private boolean f13564u = false;

    /* renamed from: v */
    private float f13565v = 0.0f;

    /* renamed from: w */
    private boolean f13566w = false;

    /* renamed from: x */
    private int f13567x = 3;

    /* renamed from: y */
    private boolean f13568y = true;

    /* renamed from: z */
    private boolean f13569z = true;

    /* renamed from: A */
    private boolean f13546A = false;

    /* renamed from: B */
    private SharedPreferences f13547B = null;

    /* renamed from: C */
    private String f13548C = null;

    /* renamed from: D */
    private int f13549D = -1;

    /* renamed from: E */
    private int f13550E = 0;

    /* renamed from: F */
    private Set<String> f13551F = new HashSet();

    /* compiled from: CameraEntry.java */
    /* renamed from: com.oplus.camera.entry.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    private enum PlatformImplementations.kt_3 {
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

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static boolean m13302b(int OplusGLSurfaceView_13) {
        return 2 == OplusGLSurfaceView_13 || 3 == OplusGLSurfaceView_13;
    }

    /* renamed from: E */
    public void m13312E() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13332a(boolean z) {
        if ((1 == m13317J() || 2 == m13317J()) && !this.f13569z) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            CameraLog.m12954a("CameraEntry", "saveCameraExitState, currentTime: " + jCurrentTimeMillis + ", justSaveTimeStamp: " + z);
            if (!z) {
                this.f13569z = true;
            }
            SharedPreferences.Editor editorEdit = this.f13547B.edit();
            if (!m13302b(m13317J())) {
                editorEdit.putLong(CameraUIInterface.KEY_CAMERA_EXIT_TIME_STAMP, jCurrentTimeMillis);
            } else {
                editorEdit.putLong(CameraUIInterface.KEY_CAMERA_EXIT_TIME_STAMP_FROM_OTHER_APP, jCurrentTimeMillis);
            }
            editorEdit.apply();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m13335b(boolean z) {
        CameraLog.m12954a("CameraEntry", "set mbShouldKeepCurrentMode: " + z);
        this.f13546A = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m13333a() {
        return this.f13546A;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m13336b() {
        long OplusGLSurfaceView_15 = this.f13547B.getLong(CameraUIInterface.KEY_REPORT_PERMISSION_TIME_STAMP, 0L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - OplusGLSurfaceView_15 <= 86400000) {
            return false;
        }
        this.f13547B.edit().putLong(CameraUIInterface.KEY_REPORT_PERMISSION_TIME_STAMP, jCurrentTimeMillis).apply();
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m13339c() {
        return m13293V() && this.f13568y;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0156  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean m13298a(java.lang.String r4, com.oplus.camera.entry.CameraEntry.PlatformImplementations.kt_3 r5) {
        /*
            Method dump skipped, instructions count: 988
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.entry.CameraEntry.m13298a(java.lang.String, com.oplus.camera.entry.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:209:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x04f7  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0500  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x0533  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x054f  */
    /* renamed from: IntrinsicsJvm.kt_4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean m13304b(java.lang.String r22, com.oplus.camera.entry.CameraEntry.PlatformImplementations.kt_3 r23) {
        /*
            Method dump skipped, instructions count: 1412
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.entry.CameraEntry.m13304b(java.lang.String, com.oplus.camera.entry.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3):boolean");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m13329a(String str, int OplusGLSurfaceView_13) {
        if (ApsConstant.CAPTURE_MODE_MULTI_VIDEO.equals(str)) {
            return CameraCharacteristicsUtil.m12996s();
        }
        if (OplusGLSurfaceView_13 == 1) {
            if (m13304b(str, PlatformImplementations.kt_3.front_dual)) {
                return CameraCharacteristicsUtil.m12991n();
            }
            if (m13304b(str, PlatformImplementations.kt_3.front_wide)) {
                return CameraCharacteristicsUtil.m12988k();
            }
            return CameraCharacteristicsUtil.m12986i();
        }
        if (m13304b(str, PlatformImplementations.kt_3.back_mono) || m13304b(str, PlatformImplementations.kt_3.back_streamer_main)) {
            int iM13337c = m13337c(str);
            CameraLog.m12959b("CameraEntry", "getLogicCameraId, notDualCameraId: " + iM13337c);
            if (-1 != iM13337c) {
                return iM13337c;
            }
        }
        if (m13304b(str, PlatformImplementations.kt_3.back_dual)) {
            return CameraCharacteristicsUtil.m12989l();
        }
        if (m13304b(str, PlatformImplementations.kt_3.back_second_dual)) {
            return CameraCharacteristicsUtil.m12990m();
        }
        if (m13304b(str, PlatformImplementations.kt_3.back_tele)) {
            return CameraCharacteristicsUtil.m12992o();
        }
        if (m13304b(str, PlatformImplementations.kt_3.back_macro)) {
            if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MACROLENS_EQUAL_ULTRAWIDELENS)) {
                return CameraCharacteristicsUtil.m12987j();
            }
            return CameraCharacteristicsUtil.m12995r();
        }
        if (m13304b(str, PlatformImplementations.kt_3.back_wide) && m13317J() == 1) {
            return CameraCharacteristicsUtil.m12987j();
        }
        if (m13304b(str, PlatformImplementations.kt_3.back_sat) && this.f13552i == 1) {
            return CameraCharacteristicsUtil.m12993p();
        }
        if (m13304b(str, PlatformImplementations.kt_3.back_microscope) && this.f13552i == 1) {
            return CameraCharacteristicsUtil.m12994q();
        }
        return CameraCharacteristicsUtil.m12985h();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public String m13340d() {
        String str = this.f13548C;
        return str != null ? str : this.f13552i == 3 ? ApsConstant.REC_MODE_COMMON : (!m13339c() || m13333a()) ? this.f13547B.getString(CameraUIInterface.KEY_CAMERA_MODE, ApsConstant.CAPTURE_MODE_COMMON) : ApsConstant.CAPTURE_MODE_COMMON;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m13330a(int OplusGLSurfaceView_13) {
        String str = this.f13548C;
        return str != null ? str : this.f13552i == 3 ? ApsConstant.REC_MODE_COMMON : (!m13339c() || m13333a()) ? ((ComboPreferences) this.f13547B).m11072a(this.f13555l, OplusGLSurfaceView_13).getString(CameraUIInterface.KEY_CAMERA_MODE, ApsConstant.CAPTURE_MODE_COMMON) : ApsConstant.CAPTURE_MODE_COMMON;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public int m13342e() {
        return this.f13549D;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public int m13343f() {
        return this.f13550E;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public boolean m13344g() {
        return m13353q() && this.f13551F.contains("effect");
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public boolean m13345h() {
        return this.f13563t;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public boolean m13346i() {
        return m13353q() && (this.f13551F.contains("beauty") || this.f13551F.contains(MenuClickMsgData.KEY_FILTER));
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m13347j() {
        m13338c(true);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m13338c(boolean z) {
        this.f13548C = null;
        this.f13551F.clear();
        if (z) {
            this.f13568y = false;
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public boolean m13348k() {
        return m13353q() && this.f13551F.contains("encode10bit");
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public boolean m13349l() {
        return this.f13554k.contains("retail") && !m13345h();
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public int m13350m() throws NumberFormatException {
        int intExtra = Integer.parseInt(this.f13547B.getString(CameraUIInterface.KEY_CAMERA_ID, String.valueOf(0)));
        if (OutCaptureManager.m16423g()) {
            return 0;
        }
        if (OutCaptureManager.m16424h()) {
            return 1;
        }
        if (Util.m24495t() && this.f13548C == null && !"com.heytap.speechassist".equals(this.f13554k)) {
            return intExtra;
        }
        if (m13339c() && !m13333a()) {
            intExtra = 0;
        }
        try {
            intExtra = this.f13555l.getIntent().getIntExtra("android.intent.extras.CAMERA_FACING", intExtra);
            if (intExtra > 1) {
                intExtra = 1;
            }
            if (this.f13561r) {
                if (this.f13555l.getIntent().getBooleanExtra("android.intent.extra.USE_FRONT_CAMERA", false) || this.f13555l.getIntent().getBooleanExtra("com.google.assistant.extra.USE_FRONT_CAMERA", false)) {
                    intExtra = 1;
                } else if (m13351n()) {
                    intExtra = 0;
                }
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        CameraLog.m12954a("CameraEntry", "getIntentLegacyId, mCameraEntryType: " + this.f13552i + ", cameraId: " + intExtra);
        return intExtra;
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public boolean m13351n() {
        Bundle extras = this.f13555l.getIntent().getExtras();
        if (extras != null) {
            return extras.containsKey("com.oplus.camera.extra.IS_VOICE_INTERACTION_ROOT") || extras.containsKey("isVoiceQuery");
        }
        return false;
    }

    /* renamed from: V */
    private boolean m13293V() {
        return 1 == m13317J() || 2 == m13317J();
    }

    /* renamed from: o */
    public static long m13307o() {
        return f13545h.longValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0093  */
    /* renamed from: p */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m13352p() {
        /*
            r11 = this;
            android.content.SharedPreferences r0 = r11.f13547B
            r1 = 0
            java.lang.String r3 = "pref_camera_exit_time_stamp_key"
            long r3 = r0.getLong(r3, r1)
            int r0 = r11.f13552i
            boolean r0 = m13302b(r0)
            r5 = 2131755451(0x7f1001bb, float:1.9141782E38)
            java.lang.String r6 = "pref_camera_flashmode_key"
            if (r0 == 0) goto L38
            android.content.SharedPreferences r0 = r11.f13547B
            java.lang.String r3 = "pref_camera_exit_time_from_other_program_code"
            long r3 = r0.getLong(r3, r1)
            android.content.SharedPreferences r0 = r11.f13547B
            android.content.SharedPreferences$Editor r0 = r0.edit()
            int r7 = r11.f13552i
            java.lang.String r7 = m13299b(r6, r7)
            android.app.Activity r8 = r11.f13555l
            java.lang.String r8 = r8.getString(r5)
            android.content.SharedPreferences$Editor r0 = r0.putString(r7, r8)
            r0.apply()
        L38:
            long r7 = java.lang.System.currentTimeMillis()
            long r9 = r7 - r3
            r11.f13557n = r9
            java.lang.Long r0 = java.lang.Long.valueOf(r7)
            com.oplus.camera.entry.CameraEntry.f13545h = r0
            boolean r0 = r11.m13293V()
            r9 = 0
            if (r0 == 0) goto L99
            boolean r0 = r11.f13569z
            if (r0 == 0) goto L96
            r11.f13569z = r9
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
            long r7 = r11.f13557n
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            java.lang.String r7 = "CameraEntry"
            com.oplus.camera.CameraLog.m12954a(r7, r0)
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 >= 0) goto L93
            long r3 = r11.f13557n
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 >= 0) goto L93
            r0 = 300000(0x493e0, double:1.482197E-318)
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L93
            r0 = 1
            r11.f13568y = r0
            r11.m13335b(r9)
            goto Lb4
        L93:
            r11.f13568y = r9
            goto Lb4
        L96:
            r11.f13568y = r9
            goto Lb4
        L99:
            boolean r0 = r11.m13353q()
            if (r0 == 0) goto La6
            boolean r0 = r11.f13569z
            if (r0 == 0) goto Lb4
            r11.f13569z = r9
            goto Lb4
        La6:
            boolean r0 = r11.m13359w()
            if (r0 == 0) goto Lb4
            boolean r0 = r11.f13569z
            if (r0 == 0) goto Lb4
            r11.f13569z = r9
            r11.f13568y = r9
        Lb4:
            int r0 = r11.f13552i
            boolean r0 = m13302b(r0)
            if (r0 == 0) goto Ld5
            android.content.SharedPreferences r0 = r11.f13547B
            android.content.SharedPreferences$Editor r0 = r0.edit()
            int r1 = r11.f13552i
            java.lang.String r1 = m13299b(r6, r1)
            android.app.Activity r11 = r11.f13555l
            java.lang.String r11 = r11.getString(r5)
            android.content.SharedPreferences$Editor r11 = r0.putString(r1, r11)
            r11.apply()
        Ld5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.entry.CameraEntry.m13352p():void");
    }

    /* renamed from: q */
    public boolean m13353q() {
        return (this.f13548C == null && this.f13551F.isEmpty()) ? false : true;
    }

    /* renamed from: r */
    public boolean m13354r() {
        return m13353q() && this.f13548C == "portrait";
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m13296a(Intent intent, Bundle bundle) throws NumberFormatException {
        int intExtra;
        boolean booleanExtra;
        boolean booleanExtra2;
        boolean booleanExtra3;
        Bundle extras = intent.getExtras();
        if ("android.intent.action.MAIN".equals(this.f13556m)) {
            return;
        }
        if (!"com.oplus.camera.action.SHORTCUT_TYPE_MENU".equals(this.f13556m) || bundle == null) {
            this.f13551F.clear();
            m13322O();
            CameraLog.m12954a("CameraEntry", "parseIntentExtraInfo, mAction: " + this.f13556m + ", extras: " + extras);
            try {
                intExtra = intent.getIntExtra("mode", -1);
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
                intExtra = -1;
            }
            if ("com.heytap.lab".equals(this.f13554k) && -1 == intExtra) {
                intExtra = Integer.parseInt(intent.getStringExtra("mode"));
            }
            if (intExtra != -1) {
                if (intExtra == 7 && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TIME_LAPSE_PRO_SUPPORT)) {
                    intExtra = 19;
                }
                this.f13548C = CameraInfoCursor.m13363a(intExtra);
                if (!m13297a(this.f13548C)) {
                    intent.putExtra("android.intent.extras.CAMERA_FACING", 0);
                    this.f13551F.add(DcsMsgData.REAR);
                }
            }
            if (extras != null && extras.containsKey("encode10bit")) {
                try {
                    this.f13563t = intent.getBooleanExtra("encode10bit", false);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                this.f13551F.add("encode10bit");
            } else {
                this.f13563t = false;
            }
            try {
                booleanExtra = intent.getBooleanExtra(DcsMsgData.REAR, false);
            } catch (Exception e2) {
                e2.printStackTrace();
                booleanExtra = false;
            }
            if (booleanExtra) {
                intent.putExtra("android.intent.extras.CAMERA_FACING", 0);
                this.f13551F.add(DcsMsgData.REAR);
                if (this.f13548C == null && !"com.heytap.speechassist".equals(this.f13554k)) {
                    this.f13548C = CameraInfoCursor.m13363a(0);
                }
            }
            try {
                booleanExtra2 = intent.getBooleanExtra(DcsMsgData.FRONT, false);
            } catch (Exception e3) {
                e3.printStackTrace();
                booleanExtra2 = false;
            }
            if (booleanExtra2) {
                intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
                this.f13551F.add(DcsMsgData.FRONT);
                if (this.f13548C == null) {
                    this.f13548C = CameraInfoCursor.m13363a(0);
                }
            }
            try {
                booleanExtra3 = intent.getBooleanExtra("beauty", false);
            } catch (Exception e4) {
                e4.printStackTrace();
                booleanExtra3 = false;
            }
            if (booleanExtra3) {
                this.f13551F.add("beauty");
            }
            this.f13549D = -1;
            this.f13550E = 0;
            try {
                this.f13549D = intent.getIntExtra("effect", -1);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            if (this.f13549D > 0) {
                this.f13551F.add("effect");
                if (this.f13549D == 4) {
                    try {
                        this.f13550E = intent.getIntExtra(MenuClickMsgData.KEY_FILTER, 0);
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
            }
            if (intent.getBooleanExtra("com.oplus.camera.extra.IS_VOICE_INTERACTION_ROOT", false) && "android.media.action.STILL_IMAGE_CAMERA".equals(this.f13556m) && !intent.getBooleanExtra("com.google.assistant.extra.CAMERA_OPEN_ONLY", false) && (intent.getFlags() & ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES) == 0) {
                this.f13566w = true;
                CameraLog.m12954a("CameraEntry", "parseIntentExtraInfo, set mbRequstVoiceCapture true");
            }
            if (this.f13566w) {
                int intExtra2 = intent.getIntExtra("com.google.assistant.extrPACKAGE_NAME_HEYTAP_MARKETa.TIMER_DURATION_SECONDS", 3);
                CameraLog.m12954a("CameraEntry", "parseIntentExtraInfo, delayDuration: " + intExtra2);
                if (intExtra2 > 0 && intExtra2 <= 10) {
                    this.f13567x = intExtra2;
                } else if (intExtra2 > 10) {
                    this.f13567x = 10;
                }
            }
            try {
                this.f13565v = intent.getFloatExtra(CameraStatisticsUtil.PORTRAIT_ZOOM, 0.0f);
            } catch (Exception e7) {
                e7.printStackTrace();
            }
            if ("com.oplus.camera.action.SHORTCUT_TYPE_MENU".equals(this.f13556m) && Float.compare(this.f13565v, 0.0f) != 0) {
                this.f13564u = true;
                this.f13548C = CameraInfoCursor.m13363a(0);
                intent.putExtra("android.intent.extras.CAMERA_FACING", 0);
                this.f13551F.add(DcsMsgData.REAR);
            }
            CameraLog.m12959b("CameraEntry", "parseIntentExtraInfo, mBestOpticalZoomValue: " + this.f13565v + ", mExtraIntent: " + this.f13551F);
            AndroidTestHelper.init(intent);
        }
    }

    /* renamed from: s */
    public boolean m13355s() {
        return this.f13564u;
    }

    /* renamed from: t */
    public void m13356t() {
        this.f13564u = false;
    }

    /* renamed from: u */
    public float m13357u() {
        return this.f13565v;
    }

    /* renamed from: v */
    public String m13358v() {
        return this.f13554k;
    }

    /* renamed from: w */
    public boolean m13359w() {
        return "android.media.action.STILL_IMAGE_CAMERA_SECURE".equals(this.f13556m) || this.f13560q;
    }

    /* renamed from: x */
    public boolean m13360x() {
        return this.f13566w;
    }

    /* renamed from: y */
    public void m13361y() {
        this.f13562s = false;
    }

    /* renamed from: z */
    public void m13362z() {
        this.f13566w = false;
    }

    /* renamed from: A */
    public int m13308A() {
        return this.f13567x;
    }

    /* renamed from: B */
    public boolean m13309B() {
        return this.f13559p && !this.f13560q;
    }

    /* renamed from: C */
    public void m13310C() {
        KeyguardManager keyguardManagerM13294W = m13294W();
        if (keyguardManagerM13294W != null) {
            keyguardManagerM13294W.requestDismissKeyguard(this.f13555l, null);
        }
    }

    /* renamed from: D */
    public boolean m13311D() {
        KeyguardManager keyguardManagerM13294W = m13294W();
        if (keyguardManagerM13294W != null) {
            return keyguardManagerM13294W.isKeyguardLocked();
        }
        return false;
    }

    /* renamed from: F */
    public void m13313F() {
        if (m13359w()) {
            this.f13555l.setShowWhenLocked(true);
        } else {
            this.f13555l.setShowWhenLocked(false);
        }
        this.f13558o = false;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m13341d(boolean z) {
        if (z && !m13359w()) {
            this.f13555l.setShowWhenLocked(false);
        }
        this.f13558o = true;
    }

    /* renamed from: G */
    public void m13314G() {
        if (m13359w()) {
            this.f13555l.setShowWhenLocked(false);
        }
        this.f13555l = null;
    }

    /* renamed from: H */
    public boolean m13315H() {
        return this.f13558o;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m13297a(String str) {
        if (ApsConstant.REC_MODE_SLOW_VIDEO.equals(str) || "movie".equals(str) || ApsConstant.CAPTURE_MODE_NIGHT.equals(str) || ApsConstant.CAPTURE_MODE_PROFESSIONAL.equals(str) || ApsConstant.CAPTURE_MODE_MACRO.equals(str) || ApsConstant.CAPTURE_MODE_HIGH_DEFINITION.equals(str) || ApsConstant.CAPTURE_MODE_STREET.equals(str)) {
            return false;
        }
        if (ApsConstant.CAPTURE_MODE_PANORAMA.equals(str)) {
            return CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_FRONT_PANORAMA_SUPPORT);
        }
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static boolean m13303b(String str) {
        return ApsConstant.CAPTURE_MODE_STICKER.equals(str) || ApsConstant.CAPTURE_MODE_COMMON.equals(str) || "portrait".equals(str) || ApsConstant.REC_MODE_COMMON.equals(str);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m13301b(Intent intent, Bundle bundle) throws NumberFormatException {
        if (intent == null) {
            CameraLog.m12967f("CameraEntry", "parseIntent, intent is null");
            return;
        }
        this.f13556m = intent.getAction();
        m13300b(intent);
        String str = this.f13556m;
        if (str != null) {
            if ("android.media.action.STILL_IMAGE_CAMERA_SECURE".equals(str)) {
                this.f13562s = true;
                this.f13552i = 1;
            } else if ("android.media.action.IMAGE_CAPTURE".equals(this.f13556m) || "android.media.action.IMAGE_CAPTURE_SECURE".equals(this.f13556m)) {
                this.f13552i = 2;
                this.f13548C = ApsConstant.CAPTURE_MODE_COMMON;
            } else if ("android.media.action.VIDEO_CAPTURE".equals(this.f13556m) || "com.oplus.action.VIDEO_CAPTURE".equals(this.f13556m)) {
                this.f13552i = 3;
                this.f13548C = ApsConstant.REC_MODE_COMMON;
            } else if ("com.oplus.action.VIDEO_CAMERA".equals(this.f13556m)) {
                this.f13552i = 1;
                this.f13548C = ApsConstant.REC_MODE_COMMON;
            } else if ("android.media.action.STILL_IMAGE_CAMERA".equals(this.f13556m)) {
                this.f13562s = true;
                this.f13561r = true;
                this.f13552i = 1;
                if (m13351n()) {
                    this.f13548C = ApsConstant.CAPTURE_MODE_COMMON;
                }
            } else {
                this.f13552i = 1;
            }
            if (m13321N()) {
                Application application = this.f13555l.getApplication();
                if (application instanceof MyApplication) {
                    ((MyApplication) application).m11104i();
                }
                String configStringValue = CameraConfig.getConfigStringValue(ConfigDataBase.KEY_QUICK_LAUNCH_SUPPORT_MODE);
                boolean zHasExtra = intent.hasExtra("android_camera_launch_type");
                if (configStringValue != null && zHasExtra) {
                    intent.putExtra("mode", Integer.valueOf(configStringValue));
                }
            }
        }
        CameraLog.m12954a("CameraEntry", "parseIntent, mCameraEntryType: " + this.f13552i + ", mCallPkg: " + this.f13554k + ", mAction: " + this.f13556m);
        m13296a(intent, bundle);
        if (m13359w()) {
            this.f13555l.setShowWhenLocked(true);
        }
        if (m13309B()) {
            m13310C();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13331a(Intent intent, Activity activity, SharedPreferences sharedPreferences, Bundle bundle) {
        this.f13555l = activity;
        this.f13547B = sharedPreferences;
        m13301b(intent, bundle);
        m13352p();
        CameraLog.m12954a("CameraEntry", "onCreate, mCameraEntryType: " + this.f13552i + ", mCallPkg: " + this.f13554k + ", mAction: " + this.f13556m);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003c  */
    /* renamed from: IntrinsicsJvm.kt_4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m13300b(android.content.Intent r5) {
        /*
            r4 = this;
            java.lang.String r0 = ""
            r4.f13554k = r0
            r0 = 0
            android.app.Activity r1 = r4.f13555l     // Catch: java.lang.Exception -> Lc
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
            r4.f13554k = r2
            goto L36
        L2e:
            if (r1 == 0) goto L36
            java.lang.String r5 = r1.getHost()
            r4.f13554k = r5
        L36:
            boolean r5 = android.text.TextUtils.isEmpty(r0)
            if (r5 != 0) goto L5f
            java.lang.String r5 = "gimbal_launch_from_framework"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L48
            r5 = 4
            r4.f13553j = r5
            goto L5f
        L48:
            java.lang.String r5 = "quick_launch_from_framework"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L54
            r5 = 5
            r4.f13553j = r5
            goto L5f
        L54:
            java.lang.String r5 = "watch_launch_from_framework"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L5f
            r5 = 6
            r4.f13553j = r5
        L5f:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = "initCallPkg, mCallPkg: "
            r5.append(r0)
            java.lang.String r0 = r4.f13554k
            r5.append(r0)
            java.lang.String r0 = ", mCameraEntryTypeFromFramework: "
            r5.append(r0)
            int r4 = r4.f13553j
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.String r5 = "CameraEntry"
            com.oplus.camera.CameraLog.m12954a(r5, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.entry.CameraEntry.m13300b(android.content.Intent):void");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m13334a(Intent intent) throws NumberFormatException {
        CameraLog.m12954a("CameraEntry", "onNewIntent");
        Activity activity = this.f13555l;
        if (activity == null) {
            CameraLog.m12967f("CameraEntry", "onNewIntent, mActivity is null");
            return false;
        }
        if (activity.getCallingActivity() != null) {
            intent.setFlags(469762048);
            this.f13555l.finish();
            this.f13555l.overridePendingTransition(R.anim.coui_close_slide_enter, R.anim.coui_close_slide_exit);
            this.f13555l.startActivity(intent);
            return false;
        }
        this.f13555l.setIntent(intent);
        m13301b(intent, (Bundle) null);
        return true;
    }

    /* renamed from: I */
    public String m13316I() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f13548C);
        sb.append(this.f13551F.contains("beauty") ? "beauty" : "");
        return sb.toString();
    }

    /* renamed from: J */
    public int m13317J() {
        return this.f13552i;
    }

    /* renamed from: K */
    public long m13318K() {
        return this.f13557n;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int m13337c(String str) {
        int OplusGLSurfaceView_13 = this.f13547B.getInt(CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_INDEX, FilterHelper.m22642p());
        int configIntValue = CameraConfig.getConfigIntValue(ConfigDataBase.KEY_MONO_FILTER_MODE_PLACE);
        if ((configIntValue == 0 || 3 == configIntValue) && ApsConstant.CAPTURE_MODE_COMMON.equals(str)) {
            OplusGLSurfaceView_13 = this.f13547B.getInt("key_filter_index", FilterHelper.m22645s());
        } else if ((1 == configIntValue || 3 == configIntValue) && "portrait".equals(str)) {
            OplusGLSurfaceView_13 = this.f13547B.getInt(CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_INDEX, FilterHelper.m22642p());
        }
        if (OplusGLSurfaceView_13 == FilterHelper.m22634h()) {
            return FilterHelper.m22647u();
        }
        if (OplusGLSurfaceView_13 == FilterHelper.m22635i()) {
            return FilterHelper.m22648v();
        }
        if (OplusGLSurfaceView_13 == FilterHelper.m22636j()) {
            return FilterHelper.m22649w();
        }
        if (OplusGLSurfaceView_13 == FilterHelper.m22637k()) {
            return FilterHelper.m22650x();
        }
        if (OplusGLSurfaceView_13 == FilterHelper.m22638l()) {
            return CameraCharacteristicsUtil.m12985h();
        }
        return -1;
    }

    /* renamed from: L */
    public boolean m13319L() {
        return -1 != this.f13553j;
    }

    /* renamed from: M */
    public int m13320M() {
        return m13319L() ? this.f13553j : this.f13552i;
    }

    /* renamed from: N */
    public boolean m13321N() {
        int OplusGLSurfaceView_13 = this.f13553j;
        return 5 == OplusGLSurfaceView_13 || 6 == OplusGLSurfaceView_13;
    }

    /* renamed from: O */
    public void m13322O() {
        KeyguardManager keyguardManagerM13294W;
        if (!m13319L() || (keyguardManagerM13294W = m13294W()) == null) {
            return;
        }
        if (keyguardManagerM13294W.isKeyguardLocked() && keyguardManagerM13294W.isKeyguardSecure()) {
            this.f13560q = true;
        }
        if (keyguardManagerM13294W.isKeyguardLocked() || keyguardManagerM13294W.isKeyguardSecure()) {
            this.f13559p = true;
        }
    }

    /* renamed from: W */
    private KeyguardManager m13294W() {
        Activity activity = this.f13555l;
        if (activity == null) {
            return null;
        }
        return (KeyguardManager) activity.getSystemService("keyguard");
    }

    /* renamed from: P */
    public boolean m13323P() {
        return this.f13559p || m13359w();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static String m13299b(String str, int OplusGLSurfaceView_13) {
        return (m13302b(OplusGLSurfaceView_13) && -1 == m13306e(str)) ? str.concat("_from_other_app") : str;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static String m13305d(String str) {
        int iM13306e = m13306e(str);
        return iM13306e > 0 ? str.substring(0, iM13306e) : str;
    }

    /* renamed from: Q */
    public boolean m13324Q() {
        return "com.heytap.speechassist".equals(this.f13554k);
    }

    /* renamed from: R */
    public boolean m13325R() {
        return "com.oplus.camera.action.SHORTCUT_TYPE_MENU".equals(this.f13556m);
    }

    /* renamed from: S */
    public boolean m13326S() {
        return "com.oplus.appplatform".equals(this.f13554k);
    }

    /* renamed from: T */
    public boolean m13327T() {
        return ("android.media.action.STILL_IMAGE_CAMERA".equals(this.f13556m) || "android.media.action.STILL_IMAGE_CAMERA_SECURE".equals(this.f13556m)) && this.f13562s;
    }

    /* renamed from: U */
    public boolean m13328U() {
        float[] configFloatArrayValue = CameraConfig.getConfigFloatArrayValue(ConfigDataBase.KEY_HYPER_LAPSE_ZOOM_LIST_SUPPORT);
        return (configFloatArrayValue == null || configFloatArrayValue.length == 0 || configFloatArrayValue[0] != 0.6f) ? false : true;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static int m13306e(String str) {
        if (str == null) {
            return -2;
        }
        return str.indexOf("_from_other_app");
    }

    /* renamed from: X */
    private boolean m13295X() {
        int OplusGLSurfaceView_13 = this.f13547B.getInt("key_filter_index", FilterHelper.m22645s());
        return OplusGLSurfaceView_13 == FilterHelper.m22634h() || OplusGLSurfaceView_13 == FilterHelper.m22635i() || OplusGLSurfaceView_13 == FilterHelper.m22636j() || OplusGLSurfaceView_13 == FilterHelper.m22637k();
    }
}
