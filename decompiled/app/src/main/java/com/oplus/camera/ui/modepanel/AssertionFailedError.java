package com.oplus.camera.ui.modepanel;

/* compiled from: DataBaseOperator.java */
/* loaded from: classes2.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static int f6712a = 2;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static volatile com.oplus.camera.ui.modepanel.b_renamed f6713b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.ui.modepanel.j_renamed f6714c;
    private android.content.SharedPreferences d_renamed;
    private android.content.Context e_renamed;

    public static com.oplus.camera.ui.modepanel.b_renamed a_renamed() {
        if (f6713b == null) {
            synchronized (com.oplus.camera.ui.modepanel.b_renamed.class) {
                if (f6713b == null) {
                    f6713b = new com.oplus.camera.ui.modepanel.b_renamed();
                }
            }
        }
        return f6713b;
    }

    private b_renamed() {
        this.f6714c = null;
        this.d_renamed = null;
        this.e_renamed = null;
        this.f6714c = new com.oplus.camera.ui.modepanel.j_renamed();
        this.e_renamed = com.oplus.camera.util.Util.l_renamed();
        android.content.Context context = this.e_renamed;
        if (context != null) {
            this.d_renamed = context.getSharedPreferences(this.e_renamed.getPackageName() + "_preferences", 0);
        } else {
            com.oplus.camera.e_renamed.f_renamed("DataBaseOperator", "context is_renamed null");
        }
        b_renamed();
    }

    public synchronized void b_renamed() {
        boolean z_renamed = true;
        if (this.e_renamed != null && !this.e_renamed.getDatabasePath("mode_data.db_renamed").exists()) {
            com.oplus.camera.e_renamed.a_renamed("DataBaseOperator", "initialize, db_renamed is_renamed not exist");
        } else if (e_renamed()) {
            com.oplus.camera.e_renamed.a_renamed("DataBaseOperator", "initialize, version is_renamed changed");
        } else {
            java.util.List<com.oplus.camera.ui.modepanel.i_renamed> listA = a_renamed("position_headline");
            java.util.List<com.oplus.camera.ui.modepanel.i_renamed> listA2 = a_renamed("position_mode_panel");
            if (listA != null && listA2 != null && !listA.isEmpty() && !listA2.isEmpty()) {
                z_renamed = false;
            }
        }
        com.oplus.camera.e_renamed.a_renamed("DataBaseOperator", "initialize, insertIntoDb: " + z_renamed);
        if (z_renamed) {
            c_renamed();
            d_renamed();
            if (this.d_renamed != null) {
                this.d_renamed.edit().putInt("pref_camera_mode_version", f6712a).apply();
            }
        }
    }

    private void c_renamed() throws android.database.SQLException {
        int i_renamed;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_NIGHT)) {
            arrayList.add(new com.oplus.camera.ui.modepanel.i_renamed(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_NIGHT, true, "position_headline", 0, 5, com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_FRONT_SUPERNIGHT_SUPPORT)));
            i_renamed = 1;
        } else {
            i_renamed = 0;
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_STREET_MODE)) {
            arrayList.add(new com.oplus.camera.ui.modepanel.i_renamed(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_STREET, true, "position_headline", i_renamed, 26, false));
            i_renamed++;
        }
        arrayList.add(new com.oplus.camera.ui.modepanel.i_renamed(com.oplus.camera.aps.constant.ApsConstant.REC_MODE_COMMON, false, "position_headline", i_renamed, 21, true));
        int i2 = i_renamed + 1;
        arrayList.add(new com.oplus.camera.ui.modepanel.i_renamed(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_COMMON, false, "position_headline", i2, 20, true));
        int i3 = i2 + 1;
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_PORTRAIT)) {
            arrayList.add(new com.oplus.camera.ui.modepanel.i_renamed("portrait", true, "position_headline", i3, 22, true));
            i3++;
        }
        int i4 = i3;
        if (com.oplus.camera.util.Util.al_renamed() && com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_HIGH_DEFINITION)) {
            arrayList.add(new com.oplus.camera.ui.modepanel.i_renamed(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_HIGH_DEFINITION, true, "position_headline", i4, 12, false));
        }
        arrayList.add(new com.oplus.camera.ui.modepanel.i_renamed(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_MORE, false, "position_headline", Integer.MAX_VALUE, 23, true));
        a_renamed(arrayList);
    }

    private void d_renamed() throws android.database.SQLException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(new com.oplus.camera.ui.modepanel.i_renamed(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PROFESSIONAL, true, "position_mode_panel", 0, 4, false));
        int i_renamed = 1;
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ULTRA_HIGH_RESOLUTION_SUPPORT)) {
            arrayList.add(new com.oplus.camera.ui.modepanel.i_renamed(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_ULTRA_HIGH_RESOLUTION, true, "position_mode_panel", 1, 11, false));
            i_renamed = 2;
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_HIGH_PIXEL_SUPPORT)) {
            arrayList.add(new com.oplus.camera.ui.modepanel.i_renamed(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_HIGH_PIXEL, true, "position_mode_panel", i_renamed, 31, false));
            i_renamed++;
        }
        arrayList.add(new com.oplus.camera.ui.modepanel.i_renamed(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PANORAMA, true, "position_mode_panel", i_renamed, 0, com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_FRONT_PANORAMA_SUPPORT)));
        int i2 = i_renamed + 1;
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_MACRO_MODE)) {
            arrayList.add(new com.oplus.camera.ui.modepanel.i_renamed(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_MACRO, true, "position_mode_panel", i2, 10, false));
            i2++;
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_MOVIE_MODE)) {
            arrayList.add(new com.oplus.camera.ui.modepanel.i_renamed("movie", false, "position_mode_panel", i2, 3, false));
            i2++;
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_SLOW_VIDEO)) {
            arrayList.add(new com.oplus.camera.ui.modepanel.i_renamed(com.oplus.camera.aps.constant.ApsConstant.REC_MODE_SLOW_VIDEO, true, "position_mode_panel", i2, 2, com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_FRONT_SLOW_VIDEO)));
            i2++;
        }
        if (!com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_TIME_LAPSE_PRO_SUPPORT)) {
            arrayList.add(new com.oplus.camera.ui.modepanel.i_renamed(com.oplus.camera.aps.constant.ApsConstant.REC_MODE_FAST_VIDEO, true, "position_mode_panel", i2, 1, true));
            i2++;
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_DOUBLE_EXPOSURE_SUPPORT)) {
            arrayList.add(new com.oplus.camera.ui.modepanel.i_renamed(com.oplus.camera.aps.constant.ApsConstant.REC_MODE_DOUBLE_EXPOSURE, false, "position_mode_panel", i2, 18, true));
            i2++;
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_LONG_EXPOSURE_MODE)) {
            arrayList.add(new com.oplus.camera.ui.modepanel.i_renamed(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_LONG_EXPOSURE, true, "position_mode_panel", i2, 27, false));
            i2++;
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_MULTI_VIDEO_MODE_SUPPORT)) {
            arrayList.add(new com.oplus.camera.ui.modepanel.i_renamed(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_MULTI_VIDEO, true, "position_mode_panel", i2, 14, true));
            i2++;
        }
        if (com.oplus.camera.aps.config.CameraConfig.isSupportMicroscope()) {
            arrayList.add(new com.oplus.camera.ui.modepanel.i_renamed(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_MICROSCOPE, true, "position_mode_panel", i2, 16, false));
            i2++;
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_TIME_LAPSE_PRO_SUPPORT)) {
            arrayList.add(new com.oplus.camera.ui.modepanel.i_renamed(com.oplus.camera.aps.constant.ApsConstant.REC_MODE_TIMELASPE_PRO, true, "position_mode_panel", i2, 25, true));
            i2++;
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_STICKER)) {
            arrayList.add(new com.oplus.camera.ui.modepanel.i_renamed(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_STICKER, true, "position_mode_panel", i2, 7, true));
            i2++;
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ID_PHOTO) && com.oplus.camera.util.Util.v_renamed(com.oplus.camera.util.Util.l_renamed()) && com.oplus.camera.l_renamed.c_renamed.g_renamed()) {
            arrayList.add(new com.oplus.camera.ui.modepanel.i_renamed(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_ID_PHOTO, true, "position_mode_panel", i2, 13, true));
            i2++;
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_FISH_EYE)) {
            arrayList.add(new com.oplus.camera.ui.modepanel.i_renamed(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_FISH_EYE, true, "position_mode_panel", i2, 29, false));
            i2++;
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPER_TEXT)) {
            arrayList.add(new com.oplus.camera.ui.modepanel.i_renamed("superText", true, "position_mode_panel", i2, 8, false));
            i2++;
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_STARRY_MODE)) {
            arrayList.add(new com.oplus.camera.ui.modepanel.i_renamed(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_STARRY, true, "position_mode_panel", i2, 19, false));
            i2++;
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_GROUP_SHOT)) {
            arrayList.add(new com.oplus.camera.ui.modepanel.i_renamed(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_GROUP_SHOT, true, "position_mode_panel", i2, 15, false));
            i2++;
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_TILT_SHIFT_PHOTO)) {
            arrayList.add(new com.oplus.camera.ui.modepanel.i_renamed(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_TILT_SHIFT, true, "position_mode_panel", i2, 24, false));
            i2++;
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_XPAN_MODE)) {
            arrayList.add(new com.oplus.camera.ui.modepanel.i_renamed(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_XPAN, false, "position_mode_panel", i2, 28, false));
            i2++;
        }
        int i3 = i2;
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_3D_PHOTO)) {
            arrayList.add(new com.oplus.camera.ui.modepanel.i_renamed(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_3D_PHOTO, true, "position_mode_panel", i3, 30, false));
        }
        a_renamed(arrayList);
    }

    public com.oplus.camera.ui.modepanel.i_renamed a_renamed(int i_renamed) {
        android.database.Cursor cursorRawQuery;
        com.oplus.camera.e_renamed.b_renamed("DataBaseOperator", "query, queryModeId: " + i_renamed);
        com.oplus.camera.ui.modepanel.j_renamed jVar = this.f6714c;
        com.oplus.camera.ui.modepanel.i_renamed iVar = null;
        if (jVar != null && (cursorRawQuery = jVar.getReadableDatabase().rawQuery("select * from mode_info where mode_id = ?", new java.lang.String[]{java.lang.String.valueOf(i_renamed)})) != null) {
            while (cursorRawQuery.moveToNext()) {
                iVar = new com.oplus.camera.ui.modepanel.i_renamed(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("mode_name")), java.lang.Boolean.parseBoolean(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("support_edit"))), cursorRawQuery.getString(cursorRawQuery.getColumnIndex("position")), cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("rank")), cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("mode_id")), java.lang.Boolean.parseBoolean(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("support_front"))));
            }
            cursorRawQuery.close();
        }
        return iVar;
    }

    public java.util.List<com.oplus.camera.ui.modepanel.i_renamed> a_renamed(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.oplus.camera.e_renamed.b_renamed("DataBaseOperator", "query, can't_renamed query null positon.");
            return null;
        }
        if (!"position_headline".equals(str) && !"position_mode_panel".equals(str)) {
            com.oplus.camera.e_renamed.b_renamed("DataBaseOperator", "query, position invalid, positioin: " + str);
            return null;
        }
        com.oplus.camera.ui.modepanel.j_renamed jVar = this.f6714c;
        if (jVar == null) {
            return null;
        }
        android.database.sqlite.SQLiteDatabase readableDatabase = jVar.getReadableDatabase();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.database.Cursor cursorRawQuery = readableDatabase.rawQuery("select * from mode_info where position = ?", new java.lang.String[]{str});
        if (cursorRawQuery != null) {
            while (cursorRawQuery.moveToNext()) {
                java.lang.String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("mode_name"));
                int i_renamed = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("mode_id"));
                java.lang.String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("position"));
                int i2 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("rank"));
                boolean z_renamed = java.lang.Boolean.parseBoolean(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("support_edit")));
                boolean z2 = java.lang.Boolean.parseBoolean(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("support_front")));
                if (com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_STICKER.equals(string) && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_STICKER)) {
                    com.oplus.camera.e_renamed.f_renamed("DataBaseOperator", "query, unsupport the sticker mode.");
                } else {
                    arrayList.add(new com.oplus.camera.ui.modepanel.i_renamed(string, z_renamed, string2, i2, i_renamed, z2));
                }
            }
            cursorRawQuery.close();
        }
        return arrayList;
    }

    public boolean a_renamed(java.util.List<com.oplus.camera.ui.modepanel.i_renamed> list) throws android.database.SQLException {
        if (this.f6714c == null || list == null || list.size() <= 0) {
            return false;
        }
        android.database.sqlite.SQLiteDatabase writableDatabase = this.f6714c.getWritableDatabase();
        while (true) {
            boolean z_renamed = false;
            for (com.oplus.camera.ui.modepanel.i_renamed iVar : list) {
                try {
                    writableDatabase.execSQL("insert into mode_info (mode_name, mode_id, position, rank, support_front, support_edit) values ('" + iVar.a_renamed() + "', '" + iVar.e_renamed() + "', '" + iVar.c_renamed() + "', '" + iVar.d_renamed() + "', '" + iVar.f_renamed() + "', '" + iVar.b_renamed() + "')");
                    z_renamed = true;
                } catch (android.database.SQLException e_renamed) {
                    com.oplus.camera.e_renamed.f_renamed("DataBaseOperator", "add, inserting modeInfo: " + iVar + " error, " + e_renamed);
                }
            }
            return z_renamed;
        }
    }

    public boolean b_renamed(int i_renamed) throws android.database.SQLException {
        com.oplus.camera.e_renamed.b_renamed("DataBaseOperator", "delete, modeId: " + i_renamed);
        com.oplus.camera.ui.modepanel.j_renamed jVar = this.f6714c;
        if (jVar == null || -1 == i_renamed) {
            return false;
        }
        jVar.getWritableDatabase().execSQL("delete from mode_info where mode_id = '" + i_renamed + "'");
        return true;
    }

    public void a_renamed(int i_renamed, int i2, boolean z_renamed) throws android.database.SQLException {
        com.oplus.camera.e_renamed.b_renamed("DataBaseOperator", "updateRank, modeId: " + i_renamed + ", rank: " + i2 + ", cache: " + z_renamed);
        com.oplus.camera.ui.modepanel.j_renamed jVar = this.f6714c;
        if (jVar != null) {
            jVar.getWritableDatabase().execSQL("update mode_info set rank = '" + i2 + "' where mode_id = '" + i_renamed + "'");
        }
    }

    public void a_renamed(int i_renamed, java.lang.String str) throws android.database.SQLException {
        com.oplus.camera.e_renamed.b_renamed("DataBaseOperator", "updatePosition, modeId: " + i_renamed + ", toPosition: " + str);
        com.oplus.camera.ui.modepanel.j_renamed jVar = this.f6714c;
        if (jVar != null) {
            jVar.getWritableDatabase().execSQL("update mode_info set position = '" + str + "' where mode_id = '" + i_renamed + "'");
        }
    }

    private boolean e_renamed() {
        android.content.SharedPreferences sharedPreferences = this.d_renamed;
        return (sharedPreferences == null || f6712a == sharedPreferences.getInt("pref_camera_mode_version", 0)) ? false : true;
    }
}
