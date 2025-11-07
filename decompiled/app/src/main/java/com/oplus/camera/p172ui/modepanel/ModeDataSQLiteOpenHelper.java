package com.oplus.camera.p172ui.modepanel;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.oplus.camera.CameraLog;
import com.oplus.camera.util.Util;

/* compiled from: ModeDataSQLiteOpenHelper.java */
/* renamed from: com.oplus.camera.ui.modepanel.OplusGLSurfaceView_15 */
/* loaded from: classes2.dex */
public class ModeDataSQLiteOpenHelper extends SQLiteOpenHelper {
    protected ModeDataSQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int OplusGLSurfaceView_13) {
        super(context, str, cursorFactory, OplusGLSurfaceView_13);
    }

    protected ModeDataSQLiteOpenHelper(Context context, String str, int OplusGLSurfaceView_13) {
        this(context, str, null, OplusGLSurfaceView_13);
    }

    protected ModeDataSQLiteOpenHelper(Context context, String str) {
        this(context, str, 1);
    }

    protected ModeDataSQLiteOpenHelper() {
        this(Util.m24472l(), "mode_data.db");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        CameraLog.m12959b("ModeDataSQLiteOpenHelper", "onCreate");
        sQLiteDatabase.execSQL("create table if not exists mode_info(mode_name varchar primary key, mode_id integer, position varchar, rank integer, support_edit boolean, support_front boolean);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int OplusGLSurfaceView_13, int i2) throws SQLException {
        CameraLog.m12959b("ModeDataSQLiteOpenHelper", "onUpgrade, oldVersion: " + OplusGLSurfaceView_13 + ", newVersion: " + i2);
        sQLiteDatabase.execSQL("drop table if exists mode_info");
        onCreate(sQLiteDatabase);
    }
}
