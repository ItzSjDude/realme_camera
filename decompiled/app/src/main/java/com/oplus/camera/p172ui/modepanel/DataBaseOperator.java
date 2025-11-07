package com.oplus.camera.p172ui.modepanel;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.oplus.camera.CameraLog;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.p153l.RegionCommonFeatureAdapter;
import com.oplus.camera.util.Util;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DataBaseOperator.java */
/* renamed from: com.oplus.camera.ui.modepanel.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class DataBaseOperator {

    /* renamed from: PlatformImplementations.kt_3 */
    public static int f20501a = 2;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static volatile DataBaseOperator f20502b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private ModeDataSQLiteOpenHelper f20503c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private SharedPreferences f20504d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Context f20505e;

    /* renamed from: PlatformImplementations.kt_3 */
    public static DataBaseOperator m21777a() {
        if (f20502b == null) {
            synchronized (DataBaseOperator.class) {
                if (f20502b == null) {
                    f20502b = new DataBaseOperator();
                }
            }
        }
        return f20502b;
    }

    private DataBaseOperator() {
        this.f20503c = null;
        this.f20504d = null;
        this.f20505e = null;
        this.f20503c = new ModeDataSQLiteOpenHelper();
        this.f20505e = Util.m24472l();
        Context context = this.f20505e;
        if (context != null) {
            this.f20504d = context.getSharedPreferences(this.f20505e.getPackageName() + "_preferences", 0);
        } else {
            CameraLog.m12967f("DataBaseOperator", "context is null");
        }
        m21786b();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public synchronized void m21786b() {
        boolean z = true;
        if (this.f20505e != null && !this.f20505e.getDatabasePath("mode_data.db").exists()) {
            CameraLog.m12954a("DataBaseOperator", "initialize, db is not exist");
        } else if (m21780e()) {
            CameraLog.m12954a("DataBaseOperator", "initialize, version is changed");
        } else {
            List<ModeDataInfo> listM21782a = m21782a("position_headline");
            List<ModeDataInfo> listM21782a2 = m21782a("position_mode_panel");
            if (listM21782a != null && listM21782a2 != null && !listM21782a.isEmpty() && !listM21782a2.isEmpty()) {
                z = false;
            }
        }
        CameraLog.m12954a("DataBaseOperator", "initialize, insertIntoDb: " + z);
        if (z) {
            m21778c();
            m21779d();
            if (this.f20504d != null) {
                this.f20504d.edit().putInt("pref_camera_mode_version", f20501a).apply();
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m21778c() throws SQLException {
        int OplusGLSurfaceView_13;
        ArrayList arrayList = new ArrayList();
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_NIGHT)) {
            arrayList.add(new ModeDataInfo(ApsConstant.CAPTURE_MODE_NIGHT, true, "position_headline", 0, 5, CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_FRONT_SUPERNIGHT_SUPPORT)));
            OplusGLSurfaceView_13 = 1;
        } else {
            OplusGLSurfaceView_13 = 0;
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_STREET_MODE)) {
            arrayList.add(new ModeDataInfo(ApsConstant.CAPTURE_MODE_STREET, true, "position_headline", OplusGLSurfaceView_13, 26, false));
            OplusGLSurfaceView_13++;
        }
        arrayList.add(new ModeDataInfo(ApsConstant.REC_MODE_COMMON, false, "position_headline", OplusGLSurfaceView_13, 21, true));
        int i2 = OplusGLSurfaceView_13 + 1;
        arrayList.add(new ModeDataInfo(ApsConstant.CAPTURE_MODE_COMMON, false, "position_headline", i2, 20, true));
        int i3 = i2 + 1;
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_PORTRAIT)) {
            arrayList.add(new ModeDataInfo("portrait", true, "position_headline", i3, 22, true));
            i3++;
        }
        int i4 = i3;
        if (Util.m24349al() && CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_HIGH_DEFINITION)) {
            arrayList.add(new ModeDataInfo(ApsConstant.CAPTURE_MODE_HIGH_DEFINITION, true, "position_headline", i4, 12, false));
        }
        arrayList.add(new ModeDataInfo(ApsConstant.CAPTURE_MODE_MORE, false, "position_headline", Integer.MAX_VALUE, 23, true));
        m21785a(arrayList);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m21779d() throws SQLException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ModeDataInfo(ApsConstant.CAPTURE_MODE_PROFESSIONAL, true, "position_mode_panel", 0, 4, false));
        int OplusGLSurfaceView_13 = 1;
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ULTRA_HIGH_RESOLUTION_SUPPORT)) {
            arrayList.add(new ModeDataInfo(ApsConstant.CAPTURE_MODE_ULTRA_HIGH_RESOLUTION, true, "position_mode_panel", 1, 11, false));
            OplusGLSurfaceView_13 = 2;
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_HIGH_PIXEL_SUPPORT)) {
            arrayList.add(new ModeDataInfo(ApsConstant.CAPTURE_MODE_HIGH_PIXEL, true, "position_mode_panel", OplusGLSurfaceView_13, 31, false));
            OplusGLSurfaceView_13++;
        }
        arrayList.add(new ModeDataInfo(ApsConstant.CAPTURE_MODE_PANORAMA, true, "position_mode_panel", OplusGLSurfaceView_13, 0, CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_FRONT_PANORAMA_SUPPORT)));
        int i2 = OplusGLSurfaceView_13 + 1;
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_MACRO_MODE)) {
            arrayList.add(new ModeDataInfo(ApsConstant.CAPTURE_MODE_MACRO, true, "position_mode_panel", i2, 10, false));
            i2++;
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_MOVIE_MODE)) {
            arrayList.add(new ModeDataInfo("movie", false, "position_mode_panel", i2, 3, false));
            i2++;
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_SLOW_VIDEO)) {
            arrayList.add(new ModeDataInfo(ApsConstant.REC_MODE_SLOW_VIDEO, true, "position_mode_panel", i2, 2, CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FRONT_SLOW_VIDEO)));
            i2++;
        }
        if (!CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TIME_LAPSE_PRO_SUPPORT)) {
            arrayList.add(new ModeDataInfo(ApsConstant.REC_MODE_FAST_VIDEO, true, "position_mode_panel", i2, 1, true));
            i2++;
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_DOUBLE_EXPOSURE_SUPPORT)) {
            arrayList.add(new ModeDataInfo(ApsConstant.REC_MODE_DOUBLE_EXPOSURE, false, "position_mode_panel", i2, 18, true));
            i2++;
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_LONG_EXPOSURE_MODE)) {
            arrayList.add(new ModeDataInfo(ApsConstant.CAPTURE_MODE_LONG_EXPOSURE, true, "position_mode_panel", i2, 27, false));
            i2++;
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_MULTI_VIDEO_MODE_SUPPORT)) {
            arrayList.add(new ModeDataInfo(ApsConstant.CAPTURE_MODE_MULTI_VIDEO, true, "position_mode_panel", i2, 14, true));
            i2++;
        }
        if (CameraConfig.isSupportMicroscope()) {
            arrayList.add(new ModeDataInfo(ApsConstant.CAPTURE_MODE_MICROSCOPE, true, "position_mode_panel", i2, 16, false));
            i2++;
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_TIME_LAPSE_PRO_SUPPORT)) {
            arrayList.add(new ModeDataInfo(ApsConstant.REC_MODE_TIMELASPE_PRO, true, "position_mode_panel", i2, 25, true));
            i2++;
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_STICKER)) {
            arrayList.add(new ModeDataInfo(ApsConstant.CAPTURE_MODE_STICKER, true, "position_mode_panel", i2, 7, true));
            i2++;
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_ID_PHOTO) && Util.m24500v(Util.m24472l()) && RegionCommonFeatureAdapter.m14538g()) {
            arrayList.add(new ModeDataInfo(ApsConstant.CAPTURE_MODE_ID_PHOTO, true, "position_mode_panel", i2, 13, true));
            i2++;
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_FISH_EYE)) {
            arrayList.add(new ModeDataInfo(ApsConstant.CAPTURE_MODE_FISH_EYE, true, "position_mode_panel", i2, 29, false));
            i2++;
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPER_TEXT)) {
            arrayList.add(new ModeDataInfo("superText", true, "position_mode_panel", i2, 8, false));
            i2++;
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_STARRY_MODE)) {
            arrayList.add(new ModeDataInfo(ApsConstant.CAPTURE_MODE_STARRY, true, "position_mode_panel", i2, 19, false));
            i2++;
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_GROUP_SHOT)) {
            arrayList.add(new ModeDataInfo(ApsConstant.CAPTURE_MODE_GROUP_SHOT, true, "position_mode_panel", i2, 15, false));
            i2++;
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_TILT_SHIFT_PHOTO)) {
            arrayList.add(new ModeDataInfo(ApsConstant.CAPTURE_MODE_TILT_SHIFT, true, "position_mode_panel", i2, 24, false));
            i2++;
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_XPAN_MODE)) {
            arrayList.add(new ModeDataInfo(ApsConstant.CAPTURE_MODE_XPAN, false, "position_mode_panel", i2, 28, false));
            i2++;
        }
        int i3 = i2;
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_3D_PHOTO)) {
            arrayList.add(new ModeDataInfo(ApsConstant.CAPTURE_MODE_3D_PHOTO, true, "position_mode_panel", i3, 30, false));
        }
        m21785a(arrayList);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public ModeDataInfo m21781a(int OplusGLSurfaceView_13) {
        Cursor cursorRawQuery;
        CameraLog.m12959b("DataBaseOperator", "query, queryModeId: " + OplusGLSurfaceView_13);
        ModeDataSQLiteOpenHelper c3352j = this.f20503c;
        ModeDataInfo c3351i = null;
        if (c3352j != null && (cursorRawQuery = c3352j.getReadableDatabase().rawQuery("select * from mode_info where mode_id = ?", new String[]{String.valueOf(OplusGLSurfaceView_13)})) != null) {
            while (cursorRawQuery.moveToNext()) {
                c3351i = new ModeDataInfo(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("mode_name")), Boolean.parseBoolean(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("support_edit"))), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("position")), cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("rank")), cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("mode_id")), Boolean.parseBoolean(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("support_front"))));
            }
            cursorRawQuery.close();
        }
        return c3351i;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public List<ModeDataInfo> m21782a(String str) {
        if (TextUtils.isEmpty(str)) {
            CameraLog.m12959b("DataBaseOperator", "query, can't query null positon.");
            return null;
        }
        if (!"position_headline".equals(str) && !"position_mode_panel".equals(str)) {
            CameraLog.m12959b("DataBaseOperator", "query, position invalid, positioin: " + str);
            return null;
        }
        ModeDataSQLiteOpenHelper c3352j = this.f20503c;
        if (c3352j == null) {
            return null;
        }
        SQLiteDatabase readableDatabase = c3352j.getReadableDatabase();
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = readableDatabase.rawQuery("select * from mode_info where position = ?", new String[]{str});
        if (cursorRawQuery != null) {
            while (cursorRawQuery.moveToNext()) {
                String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("mode_name"));
                int OplusGLSurfaceView_13 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("mode_id"));
                String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("position"));
                int i2 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("rank"));
                boolean z = Boolean.parseBoolean(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("support_edit")));
                boolean z2 = Boolean.parseBoolean(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("support_front")));
                if (ApsConstant.CAPTURE_MODE_STICKER.equals(string) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_STICKER)) {
                    CameraLog.m12967f("DataBaseOperator", "query, unsupport the sticker mode.");
                } else {
                    arrayList.add(new ModeDataInfo(string, z, string2, i2, OplusGLSurfaceView_13, z2));
                }
            }
            cursorRawQuery.close();
        }
        return arrayList;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m21785a(List<ModeDataInfo> list) throws SQLException {
        if (this.f20503c == null || list == null || list.size() <= 0) {
            return false;
        }
        SQLiteDatabase writableDatabase = this.f20503c.getWritableDatabase();
        while (true) {
            boolean z = false;
            for (ModeDataInfo c3351i : list) {
                try {
                    writableDatabase.execSQL("insert into mode_info (mode_name, mode_id, position, rank, support_front, support_edit) values ('" + c3351i.m21908a() + "', '" + c3351i.m21912e() + "', '" + c3351i.m21910c() + "', '" + c3351i.m21911d() + "', '" + c3351i.m21913f() + "', '" + c3351i.m21909b() + "')");
                    z = true;
                } catch (SQLException COUIBaseListPopupWindow_8) {
                    CameraLog.m12967f("DataBaseOperator", "add, inserting modeInfo: " + c3351i + " error, " + COUIBaseListPopupWindow_8);
                }
            }
            return z;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m21787b(int OplusGLSurfaceView_13) throws SQLException {
        CameraLog.m12959b("DataBaseOperator", "delete, modeId: " + OplusGLSurfaceView_13);
        ModeDataSQLiteOpenHelper c3352j = this.f20503c;
        if (c3352j == null || -1 == OplusGLSurfaceView_13) {
            return false;
        }
        c3352j.getWritableDatabase().execSQL("delete from mode_info where mode_id = '" + OplusGLSurfaceView_13 + "'");
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21783a(int OplusGLSurfaceView_13, int i2, boolean z) throws SQLException {
        CameraLog.m12959b("DataBaseOperator", "updateRank, modeId: " + OplusGLSurfaceView_13 + ", rank: " + i2 + ", cache: " + z);
        ModeDataSQLiteOpenHelper c3352j = this.f20503c;
        if (c3352j != null) {
            c3352j.getWritableDatabase().execSQL("update mode_info set rank = '" + i2 + "' where mode_id = '" + OplusGLSurfaceView_13 + "'");
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m21784a(int OplusGLSurfaceView_13, String str) throws SQLException {
        CameraLog.m12959b("DataBaseOperator", "updatePosition, modeId: " + OplusGLSurfaceView_13 + ", toPosition: " + str);
        ModeDataSQLiteOpenHelper c3352j = this.f20503c;
        if (c3352j != null) {
            c3352j.getWritableDatabase().execSQL("update mode_info set position = '" + str + "' where mode_id = '" + OplusGLSurfaceView_13 + "'");
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean m21780e() {
        SharedPreferences sharedPreferences = this.f20504d;
        return (sharedPreferences == null || f20501a == sharedPreferences.getInt("pref_camera_mode_version", 0)) ? false : true;
    }
}
