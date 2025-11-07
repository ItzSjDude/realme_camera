package com.oplus.camera.sticker.a_renamed;

/* compiled from: StickerCategoryTableHelper.java */
/* loaded from: classes2.dex */
public class a_renamed {
    public static java.lang.String a_renamed() {
        return "CREATE TABLE IF NOT EXISTS sticker_category (_id INTEGER PRIMARY KEY, readable_id TEXT UNIQUE, category_name TEXT, position INTEGER, icon_url TEXT, icon_md5 TEXT, icon_path TEXT, icon_file_uri TEXT, icon_highlight_url TEXT, icon_highlight_md5 TEXT, icon_highlight_path TEXT, icon_highlight_file_uri TEXT, is_new INTEGER DEFAULT 0, request_time INTEGER, is_valid INTEGER DEFAULT 1);";
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:49:0x01c5 A_renamed[Catch: Exception -> 0x01dc, TRY_ENTER, TRY_LEAVE, TryCatch #5 {Exception -> 0x01dc, blocks: (B_renamed:25:0x00f5, B_renamed:49:0x01c5, B_renamed:58:0x01d2, B_renamed:63:0x01db, B_renamed:62:0x01d8, B_renamed:47:0x01c0), top: B_renamed:82:0x003f, inners: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:85:0x01d2 A_renamed[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:87:? A_renamed[Catch: Exception -> 0x01dc, SYNTHETIC, TRY_LEAVE, TryCatch #5 {Exception -> 0x01dc, blocks: (B_renamed:25:0x00f5, B_renamed:49:0x01c5, B_renamed:58:0x01d2, B_renamed:63:0x01db, B_renamed:62:0x01d8, B_renamed:47:0x01c0), top: B_renamed:82:0x003f, inners: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:89:? A_renamed[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a_renamed(android.content.Context r19, com.oplus.camera.sticker.data.StickerCategoryItemWrapper r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 520
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.sticker.a_renamed.a_renamed.a_renamed(android.content.Context, com.oplus.camera.sticker.data.StickerCategoryItemWrapper):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:110:0x0224 A_renamed[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:114:0x0214 A_renamed[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:115:? A_renamed[Catch: Exception -> 0x023c, all -> 0x023e, SYNTHETIC, TryCatch #1 {Exception -> 0x023c, blocks: (B_renamed:43:0x0148, B_renamed:67:0x0211, B_renamed:73:0x0224, B_renamed:78:0x022d, B_renamed:77:0x022a, B_renamed:65:0x020c, B_renamed:79:0x022e), top: B_renamed:102:0x0148 }] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:54:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:67:0x0211 A_renamed[Catch: Exception -> 0x023c, all -> 0x023e, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x023c, blocks: (B_renamed:43:0x0148, B_renamed:67:0x0211, B_renamed:73:0x0224, B_renamed:78:0x022d, B_renamed:77:0x022a, B_renamed:65:0x020c, B_renamed:79:0x022e), top: B_renamed:102:0x0148 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a_renamed(android.content.Context r22, java.util.List<com.oplus.camera.sticker.data.StickerCategoryItemWrapper> r23) {
        /*
            Method dump skipped, instructions count: 625
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.sticker.a_renamed.a_renamed.a_renamed(android.content.Context, java.util.List):boolean");
    }

    public static java.util.List<com.oplus.camera.sticker.data.StickerCategoryItem> a_renamed(android.content.Context context) {
        android.content.ContentResolver contentResolver = context.getContentResolver();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            android.database.Cursor cursorQuery = contentResolver.query(com.oplus.camera.sticker.a_renamed.c_renamed.StickerTableColumns_4.f5420a, null, null, null, "position ASC");
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        do {
                            com.oplus.camera.sticker.data.StickerCategoryItemWrapper stickerCategoryItemWrapperA = a_renamed(cursorQuery);
                            if (stickerCategoryItemWrapperA != null && !android.text.TextUtils.isEmpty(stickerCategoryItemWrapperA.getCategoryName())) {
                                arrayList.add(stickerCategoryItemWrapperA);
                            }
                        } while (cursorQuery.moveToNext());
                    }
                } finally {
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.e_renamed("StickerCategoryTableHelper", "getAllStickerCategory, e_renamed: " + e_renamed);
        }
        return arrayList;
    }

    public static com.oplus.camera.sticker.data.StickerCategoryItemWrapper a_renamed(android.database.Cursor cursor) {
        com.oplus.camera.sticker.data.StickerCategoryItemWrapper stickerCategoryItemWrapper = new com.oplus.camera.sticker.data.StickerCategoryItemWrapper();
        stickerCategoryItemWrapper.setReadableId(cursor.getString(cursor.getColumnIndexOrThrow("readable_id")));
        stickerCategoryItemWrapper.setCategoryName(cursor.getString(cursor.getColumnIndexOrThrow("category_name")));
        stickerCategoryItemWrapper.setPosition(cursor.getInt(cursor.getColumnIndexOrThrow("position")));
        stickerCategoryItemWrapper.setIconUrl(cursor.getString(cursor.getColumnIndexOrThrow("icon_url")));
        stickerCategoryItemWrapper.setIconPath(cursor.getString(cursor.getColumnIndexOrThrow("icon_path")));
        stickerCategoryItemWrapper.setIconFileUri(cursor.getString(cursor.getColumnIndexOrThrow("icon_file_uri")));
        stickerCategoryItemWrapper.setIconMd5(cursor.getString(cursor.getColumnIndexOrThrow("icon_md5")));
        stickerCategoryItemWrapper.setIconHighlightUrl(cursor.getString(cursor.getColumnIndexOrThrow("icon_highlight_url")));
        stickerCategoryItemWrapper.setIconHighlightPath(cursor.getString(cursor.getColumnIndexOrThrow("icon_highlight_path")));
        stickerCategoryItemWrapper.setIconHighlightFileUri(cursor.getString(cursor.getColumnIndexOrThrow("icon_highlight_file_uri")));
        stickerCategoryItemWrapper.setIconHighlightMd5(cursor.getString(cursor.getColumnIndexOrThrow("icon_highlight_md5")));
        stickerCategoryItemWrapper.setLastRequestTime(cursor.getLong(cursor.getColumnIndexOrThrow("request_time")));
        stickerCategoryItemWrapper.setCategoryNew(cursor.getInt(cursor.getColumnIndexOrThrow("is_new")) != 0);
        stickerCategoryItemWrapper.setCategoryValid(cursor.getInt(cursor.getColumnIndexOrThrow("is_valid")) != 0);
        stickerCategoryItemWrapper.setIconVersion(cursor.getInt(cursor.getColumnIndexOrThrow("icon_version")));
        return stickerCategoryItemWrapper;
    }

    public static com.oplus.camera.sticker.data.StickerCategoryItem a_renamed(android.content.Context context, java.lang.String str, java.lang.String str2) {
        android.content.ContentResolver contentResolver = context.getContentResolver();
        com.oplus.camera.sticker.data.StickerCategoryItemWrapper stickerCategoryItemWrapperA = null;
        try {
            android.database.Cursor cursorQuery = contentResolver.query(com.oplus.camera.sticker.a_renamed.c_renamed.StickerTableColumns_4.f5420a, null, str + " = \"" + str2 + "\"", null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        stickerCategoryItemWrapperA = a_renamed(cursorQuery);
                        com.oplus.camera.e_renamed.b_renamed("StickerCategoryTableHelper", "getStickerCategory, item: " + stickerCategoryItemWrapperA);
                    }
                } finally {
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.c_renamed("StickerCategoryTableHelper", "getStickerCategory, e_renamed:", e_renamed);
        }
        return stickerCategoryItemWrapperA;
    }

    public static int a_renamed(android.content.Context context, com.oplus.camera.sticker.data.BuildInStickerCategory buildInStickerCategory) {
        com.oplus.camera.sticker.data.StickerCategoryItem stickerCategoryItemA = a_renamed(context, "readable_id", buildInStickerCategory.getReadableId());
        com.oplus.camera.e_renamed.b_renamed("StickerCategoryTableHelper", "isStickerCategoryCanAddOrUpdate, item: " + stickerCategoryItemA + ", Category: " + buildInStickerCategory);
        if (stickerCategoryItemA == null) {
            return 1;
        }
        return stickerCategoryItemA.getIconVersion() < buildInStickerCategory.getIconVersion() ? 2 : 0;
    }

    public static int a_renamed(android.content.Context context, java.lang.String str, java.lang.String str2, android.content.ContentValues contentValues) {
        return context.getContentResolver().update(com.oplus.camera.sticker.a_renamed.c_renamed.StickerTableColumns_4.f5420a, contentValues, str + " = ?", new java.lang.String[]{java.lang.String.valueOf(str2)});
    }

    public static void a_renamed(android.content.Context context, long j_renamed, long j2) {
        java.lang.String[] strArr = {java.lang.String.valueOf(1)};
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("is_new", (java.lang.Integer) 0);
        com.oplus.camera.e_renamed.b_renamed("StickerCategoryTableHelper", "autoClearStickerNewStatus, update count: " + context.getContentResolver().update(com.oplus.camera.sticker.a_renamed.c_renamed.StickerTableColumns_4.f5420a, contentValues, "is_new = ? AND request_time < " + (j_renamed - j2), strArr) + ", currTime: " + j_renamed);
    }
}
