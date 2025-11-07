package com.oplus.camera.sticker.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.util.Base64;
import com.heytap.accessory.constant.AFConstants;
import com.oplus.camera.CameraLog;
import com.oplus.camera.sticker.p165a.StickerCategoryTableHelper;
import com.oplus.camera.sticker.p165a.StickerItemTableHelper;
import com.oplus.camera.sticker.p165a.StickerTableColumns;
import com.oplus.camera.sticker.p165a.StickerViewHelper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class StickerProvider extends ContentProvider {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final UriMatcher f16271a = new UriMatcher(-1);

    /* renamed from: IntrinsicsJvm.kt_4 */
    private C3004a f16272b = null;

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    static {
        f16271a.addURI("com.oplus.camera.sticker.db.provider", "sticker_item", 1);
        f16271a.addURI("com.oplus.camera.sticker.db.provider", "sticker_item/#", 2);
        f16271a.addURI("com.oplus.camera.sticker.db.provider", "sticker_category", 3);
        f16271a.addURI("com.oplus.camera.sticker.db.provider", "sticker_category/#", 4);
        f16271a.addURI("com.oplus.camera.sticker.db.provider", "sticker_view", 5);
        f16271a.addURI("com.oplus.camera.sticker.db.provider", "sticker_view/#", 6);
        f16271a.addURI("com.oplus.camera.sticker.db.provider", "multi_info", 7);
        f16271a.addURI("com.oplus.camera.sticker.db.provider", "multi_info/#", 8);
        f16271a.addURI("com.oplus.camera.sticker.db.provider", "animoji_info", 9);
        f16271a.addURI("com.oplus.camera.sticker.db.provider", "animoji_info/#", 10);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.f16272b = new C3004a(getContext());
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        SQLiteDatabase readableDatabase = this.f16272b.getReadableDatabase();
        String queryParameter = uri.getQueryParameter("limit");
        ArrayList arrayList = new ArrayList();
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        switch (f16271a.match(uri)) {
            case 1:
                sQLiteQueryBuilder.setTables("sticker_item");
                break;
            case 2:
                sQLiteQueryBuilder.setTables("sticker_item");
                sQLiteQueryBuilder.appendWhere("_id=?");
                arrayList.add(uri.getPathSegments().get(1));
                break;
            case 3:
                sQLiteQueryBuilder.setTables("sticker_category");
                break;
            case 4:
                sQLiteQueryBuilder.setTables("sticker_category");
                sQLiteQueryBuilder.appendWhere("_id=?");
                arrayList.add(uri.getPathSegments().get(1));
                break;
            case 5:
                sQLiteQueryBuilder.setTables("sticker_view");
                break;
            case 6:
                sQLiteQueryBuilder.setTables("sticker_view");
                sQLiteQueryBuilder.appendWhere("_id=?");
                arrayList.add(uri.getPathSegments().get(1));
                break;
            case 7:
                sQLiteQueryBuilder.setTables("multi_info");
                break;
            case 8:
                sQLiteQueryBuilder.setTables("multi_info");
                sQLiteQueryBuilder.appendWhere("_id=?");
                arrayList.add(uri.getPathSegments().get(1));
                break;
            case 9:
                sQLiteQueryBuilder.setTables("animoji_info");
                break;
            case 10:
                sQLiteQueryBuilder.setTables("animoji_info");
                sQLiteQueryBuilder.appendWhere("_id=?");
                arrayList.add(uri.getPathSegments().get(1));
                break;
            default:
                throw new IllegalStateException("query error! unknown uri: " + uri.toString());
        }
        Cursor cursorQuery = null;
        try {
            cursorQuery = sQLiteQueryBuilder.query(readableDatabase, strArr, str, m16989a(arrayList, strArr2), null, null, str2, queryParameter);
            cursorQuery.setNotificationUri(getContext().getContentResolver(), uri);
            return cursorQuery;
        } catch (IllegalStateException COUIBaseListPopupWindow_8) {
            CameraLog.m12967f("StickerProvider", "query exception! COUIBaseListPopupWindow_8: " + COUIBaseListPopupWindow_8);
            return cursorQuery;
        }
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        SQLiteDatabase writableDatabase = this.f16272b.getWritableDatabase();
        if (writableDatabase == null) {
            throw new IllegalStateException("insert, couldn't open database for uri: " + uri);
        }
        Uri uriM16987a = m16987a(writableDatabase, uri, contentValues);
        m16988a(uriM16987a);
        return uriM16987a;
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        SQLiteDatabase writableDatabase = this.f16272b.getWritableDatabase();
        if (writableDatabase == null) {
            throw new IllegalStateException("bulkInsert couldn't open database for uri: " + uri);
        }
        writableDatabase.beginTransaction();
        int OplusGLSurfaceView_13 = 0;
        for (ContentValues contentValues : contentValuesArr) {
            try {
                if (contentValues != null && m16987a(writableDatabase, uri, contentValues) != null) {
                    OplusGLSurfaceView_13++;
                }
            } catch (Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
        }
        writableDatabase.setTransactionSuccessful();
        writableDatabase.endTransaction();
        m16988a(uri);
        return OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Uri m16987a(SQLiteDatabase sQLiteDatabase, Uri uri, ContentValues contentValues) {
        if (contentValues == null) {
            throw new IllegalStateException("insert exception! Attempting to insert null values");
        }
        int iMatch = f16271a.match(uri);
        long jInsert = -1;
        if (iMatch != 1) {
            if (iMatch != 3) {
                if (iMatch == 5) {
                    throw new IllegalStateException("insert exception! Can not insert PlatformImplementations.kt_3 row into db View!");
                }
                if (iMatch != 7) {
                    if (iMatch == 9) {
                        if (!contentValues.containsKey(AFConstants.EXTRA_UUID)) {
                            throw new IllegalStateException("insert exception! Attempting to add animoji info without uuid");
                        }
                        jInsert = sQLiteDatabase.insert("animoji_info", null, contentValues);
                    } else {
                        CameraLog.m12966e("StickerProvider", "insert error! unsupported uri! uri: " + uri);
                    }
                } else {
                    if (!contentValues.containsKey(AFConstants.EXTRA_UUID)) {
                        throw new IllegalStateException("insert exception! Attempting to add multi info without uuid");
                    }
                    jInsert = sQLiteDatabase.insert("multi_info", null, contentValues);
                }
            } else {
                if (!contentValues.containsKey("readable_id")) {
                    throw new IllegalStateException("insert exception! Attempting to add sticker category without id_renamed");
                }
                jInsert = sQLiteDatabase.insert("sticker_category", null, contentValues);
            }
        } else {
            if (!contentValues.containsKey(AFConstants.EXTRA_UUID)) {
                throw new IllegalStateException("insert exception! Attempting to add sticker without uuid");
            }
            jInsert = sQLiteDatabase.insert("sticker_item", null, contentValues);
        }
        if (jInsert <= 0) {
            return null;
        }
        return ContentUris.withAppendedId(uri, jInsert);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0101  */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int delete(android.net.Uri r11, java.lang.String r12, java.lang.String[] r13) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.sticker.provider.StickerProvider.delete(android.net.Uri, java.lang.String, java.lang.String[]):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ed  */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int update(android.net.Uri r11, android.content.ContentValues r12, java.lang.String r13, java.lang.String[] r14) {
        /*
            Method dump skipped, instructions count: 294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.sticker.provider.StickerProvider.update(android.net.Uri, android.content.ContentValues, java.lang.String, java.lang.String[]):int");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private String[] m16989a(List<String> list, String[] strArr) {
        int size = list.size();
        if (size == 0) {
            return strArr;
        }
        int length = strArr != null ? strArr.length : 0;
        String[] strArr2 = new String[size + length];
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            strArr2[OplusGLSurfaceView_13] = list.get(OplusGLSurfaceView_13);
        }
        for (int i2 = 0; i2 < length; i2++) {
            strArr2[size + i2] = strArr[i2];
        }
        return strArr2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m16988a(Uri uri) {
        if (uri == null) {
            return;
        }
        String queryParameter = uri.getQueryParameter("notify");
        if (queryParameter == null || "true".equals(queryParameter)) {
            getContext().getContentResolver().notifyChange(uri, null);
            if (uri.equals(StickerTableColumns.COUIBaseListPopupWindow_8.f16181a)) {
                return;
            }
            getContext().getContentResolver().notifyChange(StickerTableColumns.COUIBaseListPopupWindow_8.f16181a, null);
        }
    }

    /* renamed from: com.oplus.camera.sticker.provider.StickerProvider$PlatformImplementations.kt_3 */
    private static class C3004a extends SQLiteOpenHelper {
        public C3004a(Context context) {
            super(context, "sticker.db", (SQLiteDatabase.CursorFactory) null, 4);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
            m16991a(sQLiteDatabase, 0, 4);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int OplusGLSurfaceView_13, int i2) throws SQLException {
            m16991a(sQLiteDatabase, OplusGLSurfaceView_13, 4);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m16991a(SQLiteDatabase sQLiteDatabase, int OplusGLSurfaceView_13, int i2) throws SQLException {
            CameraLog.m12959b("StickerProvider", "updateDatabase, fromVersion: " + OplusGLSurfaceView_13 + ", toVersion: " + i2);
            if (OplusGLSurfaceView_13 >= i2) {
                return;
            }
            if (OplusGLSurfaceView_13 < 1) {
                sQLiteDatabase.execSQL(StickerCategoryTableHelper.m16743a());
                sQLiteDatabase.execSQL(StickerItemTableHelper.m16752a());
                sQLiteDatabase.execSQL(StickerViewHelper.m16771a());
            }
            if (OplusGLSurfaceView_13 < 2) {
                sQLiteDatabase.execSQL("alter table sticker_item add material_type INTEGER DEFAULT 0");
                sQLiteDatabase.execSQL(StickerItemTableHelper.m16767c());
                sQLiteDatabase.execSQL(StickerItemTableHelper.m16763b());
                sQLiteDatabase.execSQL("DROP VIEW IF EXISTS sticker_view");
                sQLiteDatabase.execSQL(StickerViewHelper.m16772b());
            }
            if (OplusGLSurfaceView_13 < 3) {
                sQLiteDatabase.execSQL("alter table sticker_category add icon_version INTEGER DEFAULT 0");
                CameraLog.m12966e("StickerProvider", "updateDatabase, add icon_version(column) to sticker_category(table)");
                sQLiteDatabase.execSQL("DROP VIEW IF EXISTS sticker_view");
                sQLiteDatabase.execSQL(StickerViewHelper.m16772b());
            }
            if (OplusGLSurfaceView_13 < 4) {
                CameraLog.m12966e("StickerProvider", "updateDatabase, replace pattern 1, start");
                String str = "%s=REPLACE(%<s, '" + String.format(".%s.", new String(Base64.decode("b3Bwbw==", 0))) + "', '.oplus.')";
                String str2 = String.format("UPDATE %s SET %s, %s, %s, %s", "sticker_category", String.format(str, "icon_path"), String.format(str, "icon_file_uri"), String.format(str, "icon_highlight_path"), String.format(str, "icon_highlight_file_uri"));
                String str3 = String.format("UPDATE %s SET %s, %s, %s, %s", "sticker_item", String.format(str, "file_path"), String.format(str, "file_content_uri"), String.format(str, "thumbnail_path"), String.format(str, "thumbnail_file_uri"));
                String str4 = String.format("UPDATE %s SET %s, %s, %s", "multi_info", String.format(str, "file_content_uri_1_1"), String.format(str, "file_content_uri_4_3"), String.format(str, "file_content_uri_16_9"));
                CameraLog.m12959b("StickerProvider", "updateDatabase, replaceStickerCategoryCommand: " + str2);
                CameraLog.m12959b("StickerProvider", "updateDatabase, replaceStickerItemCommand: " + str3);
                CameraLog.m12959b("StickerProvider", "updateDatabase, replaceMultiInfoCommand: " + str4);
                try {
                    sQLiteDatabase.execSQL(str2);
                    sQLiteDatabase.execSQL(str3);
                    sQLiteDatabase.execSQL(str4);
                    CameraLog.m12966e("StickerProvider", "updateDatabase, replace pattern 1, end");
                } catch (Throwable th) {
                    CameraLog.m12965d("StickerProvider", "updateDatabase, replace pattern failed", th);
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int OplusGLSurfaceView_13, int i2) throws SQLException {
            CameraLog.m12966e("StickerProvider", "onDowngrade, oldVersion: " + OplusGLSurfaceView_13 + ", newVersion: " + i2);
            m16990a(sQLiteDatabase);
            m16991a(sQLiteDatabase, 0, 4);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m16990a(SQLiteDatabase sQLiteDatabase) throws SQLException {
            try {
                sQLiteDatabase.execSQL("DROP VIEW IF EXISTS sticker_view");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS sticker_item");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS sticker_category");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS multi_info");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS animoji_info");
            } catch (SQLException COUIBaseListPopupWindow_8) {
                CameraLog.m12963c("StickerProvider", "deleteAllTables, couldn't delete table in downloads database. COUIBaseListPopupWindow_8: ", COUIBaseListPopupWindow_8);
            }
        }
    }
}
