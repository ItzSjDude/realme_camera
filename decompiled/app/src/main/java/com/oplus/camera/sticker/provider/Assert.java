package com.oplus.camera.sticker.provider;

/* loaded from: classes2.dex */
public class StickerProvider extends android.content.ContentProvider {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final android.content.UriMatcher f5481a = new android.content.UriMatcher(-1);

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.oplus.camera.sticker.provider.StickerProvider.a_renamed f5482b = null;

    @Override // android.content.ContentProvider
    public java.lang.String getType(android.net.Uri uri) {
        return null;
    }

    static {
        f5481a.addURI("com.oplus.camera.sticker.db_renamed.provider", "sticker_item", 1);
        f5481a.addURI("com.oplus.camera.sticker.db_renamed.provider", "sticker_item/#", 2);
        f5481a.addURI("com.oplus.camera.sticker.db_renamed.provider", "sticker_category", 3);
        f5481a.addURI("com.oplus.camera.sticker.db_renamed.provider", "sticker_category/#", 4);
        f5481a.addURI("com.oplus.camera.sticker.db_renamed.provider", "sticker_view", 5);
        f5481a.addURI("com.oplus.camera.sticker.db_renamed.provider", "sticker_view/#", 6);
        f5481a.addURI("com.oplus.camera.sticker.db_renamed.provider", "multi_info", 7);
        f5481a.addURI("com.oplus.camera.sticker.db_renamed.provider", "multi_info/#", 8);
        f5481a.addURI("com.oplus.camera.sticker.db_renamed.provider", "animoji_info", 9);
        f5481a.addURI("com.oplus.camera.sticker.db_renamed.provider", "animoji_info/#", 10);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.f5482b = new com.oplus.camera.sticker.provider.StickerProvider.a_renamed(getContext());
        return true;
    }

    @Override // android.content.ContentProvider
    public android.database.Cursor query(android.net.Uri uri, java.lang.String[] strArr, java.lang.String str, java.lang.String[] strArr2, java.lang.String str2) {
        android.database.sqlite.SQLiteDatabase readableDatabase = this.f5482b.getReadableDatabase();
        java.lang.String queryParameter = uri.getQueryParameter("limit");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.database.sqlite.SQLiteQueryBuilder sQLiteQueryBuilder = new android.database.sqlite.SQLiteQueryBuilder();
        switch (f5481a.match(uri)) {
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
                throw new java.lang.IllegalStateException("query error! unknown uri: " + uri.toString());
        }
        android.database.Cursor cursorQuery = null;
        try {
            cursorQuery = sQLiteQueryBuilder.query(readableDatabase, strArr, str, a_renamed(arrayList, strArr2), null, null, str2, queryParameter);
            cursorQuery.setNotificationUri(getContext().getContentResolver(), uri);
            return cursorQuery;
        } catch (java.lang.IllegalStateException e_renamed) {
            com.oplus.camera.e_renamed.f_renamed("StickerProvider", "query exception! e_renamed: " + e_renamed);
            return cursorQuery;
        }
    }

    @Override // android.content.ContentProvider
    public android.net.Uri insert(android.net.Uri uri, android.content.ContentValues contentValues) {
        android.database.sqlite.SQLiteDatabase writableDatabase = this.f5482b.getWritableDatabase();
        if (writableDatabase == null) {
            throw new java.lang.IllegalStateException("insert, couldn't_renamed open database for uri: " + uri);
        }
        android.net.Uri uriA = a_renamed(writableDatabase, uri, contentValues);
        a_renamed(uriA);
        return uriA;
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(android.net.Uri uri, android.content.ContentValues[] contentValuesArr) {
        android.database.sqlite.SQLiteDatabase writableDatabase = this.f5482b.getWritableDatabase();
        if (writableDatabase == null) {
            throw new java.lang.IllegalStateException("bulkInsert couldn't_renamed open database for uri: " + uri);
        }
        writableDatabase.beginTransaction();
        int i_renamed = 0;
        for (android.content.ContentValues contentValues : contentValuesArr) {
            try {
                if (contentValues != null && a_renamed(writableDatabase, uri, contentValues) != null) {
                    i_renamed++;
                }
            } catch (java.lang.Throwable th) {
                writableDatabase.endTransaction();
                throw th;
            }
        }
        writableDatabase.setTransactionSuccessful();
        writableDatabase.endTransaction();
        a_renamed(uri);
        return i_renamed;
    }

    private android.net.Uri a_renamed(android.database.sqlite.SQLiteDatabase sQLiteDatabase, android.net.Uri uri, android.content.ContentValues contentValues) {
        if (contentValues == null) {
            throw new java.lang.IllegalStateException("insert exception! Attempting to insert null values");
        }
        int iMatch = f5481a.match(uri);
        long jInsert = -1;
        if (iMatch != 1) {
            if (iMatch != 3) {
                if (iMatch == 5) {
                    throw new java.lang.IllegalStateException("insert exception! Can not insert a_renamed row into db_renamed View!");
                }
                if (iMatch != 7) {
                    if (iMatch == 9) {
                        if (!contentValues.containsKey(com.heytap.accessory.constant.AFConstants.EXTRA_UUID)) {
                            throw new java.lang.IllegalStateException("insert exception! Attempting to add animoji info without uuid");
                        }
                        jInsert = sQLiteDatabase.insert("animoji_info", null, contentValues);
                    } else {
                        com.oplus.camera.e_renamed.e_renamed("StickerProvider", "insert error! unsupported uri! uri: " + uri);
                    }
                } else {
                    if (!contentValues.containsKey(com.heytap.accessory.constant.AFConstants.EXTRA_UUID)) {
                        throw new java.lang.IllegalStateException("insert exception! Attempting to add multi info without uuid");
                    }
                    jInsert = sQLiteDatabase.insert("multi_info", null, contentValues);
                }
            } else {
                if (!contentValues.containsKey("readable_id")) {
                    throw new java.lang.IllegalStateException("insert exception! Attempting to add sticker category without id_renamed");
                }
                jInsert = sQLiteDatabase.insert("sticker_category", null, contentValues);
            }
        } else {
            if (!contentValues.containsKey(com.heytap.accessory.constant.AFConstants.EXTRA_UUID)) {
                throw new java.lang.IllegalStateException("insert exception! Attempting to add sticker without uuid");
            }
            jInsert = sQLiteDatabase.insert("sticker_item", null, contentValues);
        }
        if (jInsert <= 0) {
            return null;
        }
        return android.content.ContentUris.withAppendedId(uri, jInsert);
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:19:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:26:0x0101  */
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

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:19:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:26:0x00ed  */
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

    private java.lang.String[] a_renamed(java.util.List<java.lang.String> list, java.lang.String[] strArr) {
        int size = list.size();
        if (size == 0) {
            return strArr;
        }
        int length = strArr != null ? strArr.length : 0;
        java.lang.String[] strArr2 = new java.lang.String[size + length];
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            strArr2[i_renamed] = list.get(i_renamed);
        }
        for (int i2 = 0; i2 < length; i2++) {
            strArr2[size + i2] = strArr[i2];
        }
        return strArr2;
    }

    private void a_renamed(android.net.Uri uri) {
        if (uri == null) {
            return;
        }
        java.lang.String queryParameter = uri.getQueryParameter("notify");
        if (queryParameter == null || "true".equals(queryParameter)) {
            getContext().getContentResolver().notifyChange(uri, null);
            if (uri.equals(com.oplus.camera.sticker.a_renamed.c_renamed.e_renamed.f5424a)) {
                return;
            }
            getContext().getContentResolver().notifyChange(com.oplus.camera.sticker.a_renamed.c_renamed.e_renamed.f5424a, null);
        }
    }

    private static class a_renamed extends android.database.sqlite.SQLiteOpenHelper {
        public a_renamed(android.content.Context context) {
            super(context, "sticker.db_renamed", (android.database.sqlite.SQLiteDatabase.CursorFactory) null, 4);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(android.database.sqlite.SQLiteDatabase sQLiteDatabase) throws android.database.SQLException {
            a_renamed(sQLiteDatabase, 0, 4);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i_renamed, int i2) throws android.database.SQLException {
            a_renamed(sQLiteDatabase, i_renamed, 4);
        }

        private void a_renamed(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i_renamed, int i2) throws android.database.SQLException {
            com.oplus.camera.e_renamed.b_renamed("StickerProvider", "updateDatabase, fromVersion: " + i_renamed + ", toVersion: " + i2);
            if (i_renamed >= i2) {
                return;
            }
            if (i_renamed < 1) {
                sQLiteDatabase.execSQL(com.oplus.camera.sticker.a_renamed.a_renamed.a_renamed());
                sQLiteDatabase.execSQL(com.oplus.camera.sticker.a_renamed.b_renamed.a_renamed());
                sQLiteDatabase.execSQL(com.oplus.camera.sticker.a_renamed.d_renamed.a_renamed());
            }
            if (i_renamed < 2) {
                sQLiteDatabase.execSQL("alter table sticker_item add material_type INTEGER DEFAULT 0");
                sQLiteDatabase.execSQL(com.oplus.camera.sticker.a_renamed.b_renamed.c_renamed());
                sQLiteDatabase.execSQL(com.oplus.camera.sticker.a_renamed.b_renamed.b_renamed());
                sQLiteDatabase.execSQL("DROP VIEW IF EXISTS sticker_view");
                sQLiteDatabase.execSQL(com.oplus.camera.sticker.a_renamed.d_renamed.b_renamed());
            }
            if (i_renamed < 3) {
                sQLiteDatabase.execSQL("alter table sticker_category add icon_version INTEGER DEFAULT 0");
                com.oplus.camera.e_renamed.e_renamed("StickerProvider", "updateDatabase, add icon_version(column) to sticker_category(table)");
                sQLiteDatabase.execSQL("DROP VIEW IF EXISTS sticker_view");
                sQLiteDatabase.execSQL(com.oplus.camera.sticker.a_renamed.d_renamed.b_renamed());
            }
            if (i_renamed < 4) {
                com.oplus.camera.e_renamed.e_renamed("StickerProvider", "updateDatabase, replace pattern 1, start");
                java.lang.String str = "%s_renamed=REPLACE(%<s_renamed, '" + java.lang.String.format(".%s_renamed.", new java.lang.String(android.util.Base64.decode("b3Bwbw==", 0))) + "', '.oplus.')";
                java.lang.String str2 = java.lang.String.format("UPDATE %s_renamed SET %s_renamed, %s_renamed, %s_renamed, %s_renamed", "sticker_category", java.lang.String.format(str, "icon_path"), java.lang.String.format(str, "icon_file_uri"), java.lang.String.format(str, "icon_highlight_path"), java.lang.String.format(str, "icon_highlight_file_uri"));
                java.lang.String str3 = java.lang.String.format("UPDATE %s_renamed SET %s_renamed, %s_renamed, %s_renamed, %s_renamed", "sticker_item", java.lang.String.format(str, "file_path"), java.lang.String.format(str, "file_content_uri"), java.lang.String.format(str, "thumbnail_path"), java.lang.String.format(str, "thumbnail_file_uri"));
                java.lang.String str4 = java.lang.String.format("UPDATE %s_renamed SET %s_renamed, %s_renamed, %s_renamed", "multi_info", java.lang.String.format(str, "file_content_uri_1_1"), java.lang.String.format(str, "file_content_uri_4_3"), java.lang.String.format(str, "file_content_uri_16_9"));
                com.oplus.camera.e_renamed.b_renamed("StickerProvider", "updateDatabase, replaceStickerCategoryCommand: " + str2);
                com.oplus.camera.e_renamed.b_renamed("StickerProvider", "updateDatabase, replaceStickerItemCommand: " + str3);
                com.oplus.camera.e_renamed.b_renamed("StickerProvider", "updateDatabase, replaceMultiInfoCommand: " + str4);
                try {
                    sQLiteDatabase.execSQL(str2);
                    sQLiteDatabase.execSQL(str3);
                    sQLiteDatabase.execSQL(str4);
                    com.oplus.camera.e_renamed.e_renamed("StickerProvider", "updateDatabase, replace pattern 1, end");
                } catch (java.lang.Throwable th) {
                    com.oplus.camera.e_renamed.d_renamed("StickerProvider", "updateDatabase, replace pattern failed", th);
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(android.database.sqlite.SQLiteDatabase sQLiteDatabase, int i_renamed, int i2) throws android.database.SQLException {
            com.oplus.camera.e_renamed.e_renamed("StickerProvider", "onDowngrade, oldVersion: " + i_renamed + ", newVersion: " + i2);
            a_renamed(sQLiteDatabase);
            a_renamed(sQLiteDatabase, 0, 4);
        }

        private void a_renamed(android.database.sqlite.SQLiteDatabase sQLiteDatabase) throws android.database.SQLException {
            try {
                sQLiteDatabase.execSQL("DROP VIEW IF EXISTS sticker_view");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS sticker_item");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS sticker_category");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS multi_info");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS animoji_info");
            } catch (android.database.SQLException e_renamed) {
                com.oplus.camera.e_renamed.c_renamed("StickerProvider", "deleteAllTables, couldn't_renamed delete table in_renamed downloads database. e_renamed: ", e_renamed);
            }
        }
    }
}
