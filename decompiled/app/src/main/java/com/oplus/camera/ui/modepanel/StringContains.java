package com.oplus.camera.ui.modepanel;

/* compiled from: ModeDataSQLiteOpenHelper.java */
/* loaded from: classes2.dex */
public class j_renamed extends android.database.sqlite.SQLiteOpenHelper {
    protected j_renamed(android.content.Context context, java.lang.String str, android.database.sqlite.SQLiteDatabase.CursorFactory cursorFactory, int i_renamed) {
        super(context, str, cursorFactory, i_renamed);
    }

    protected j_renamed(android.content.Context context, java.lang.String str, int i_renamed) {
        this(context, str, null, i_renamed);
    }

    protected j_renamed(android.content.Context context, java.lang.String str) {
        this(context, str, 1);
    }

    protected j_renamed() {
        this(com.oplus.camera.util.Util.l_renamed(), "mode_data.db_renamed");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) throws android.database.SQLException {
        com.oplus.camera.e_renamed.b_renamed("ModeDataSQLiteOpenHelper", "onCreate");
        sQLiteDatabase.execSQL("create table if not exists mode_info(mode_name varchar primary key, mode_id integer, position varchar, rank integer, support_edit boolean, support_front boolean);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i_renamed, int i2) throws android.database.SQLException {
        com.oplus.camera.e_renamed.b_renamed("ModeDataSQLiteOpenHelper", "onUpgrade, oldVersion: " + i_renamed + ", newVersion: " + i2);
        sQLiteDatabase.execSQL("drop table if exists mode_info");
        onCreate(sQLiteDatabase);
    }
}
