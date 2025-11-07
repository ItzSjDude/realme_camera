package com.oplus.camera.sticker.a_renamed;

/* compiled from: StickerItemTableHelper.java */
/* loaded from: classes2.dex */
public class b_renamed {
    public static java.lang.String a_renamed() {
        return "CREATE TABLE IF NOT EXISTS sticker_item (_id INTEGER PRIMARY KEY, uuid TEXT NOT NULL UNIQUE, name TEXT, file_url TEXT, file_md5 TEXT, file_path TEXT, file_content_uri TEXT, thumbnail_url TEXT, thumbnail_path TEXT, thumbnail_file_uri TEXT, thumbnail_md5 TEXT, version INTEGER, logo_url TEXT, logo_path TEXT, logo_file_uri TEXT, logo_md5 TEXT, has_music INTEGER DEFAULT 0, attribute INTEGER, protocol_version TEXT, position INTEGER, need_update INTEGER DEFAULT 0, is_build_in INTEGER DEFAULT 0, is_new INTEGER DEFAULT 0, category_id TEXT, category_position INTEGER, request_time INTEGER, is_valid INTEGER DEFAULT 1, download_uuid TEXT, download_state INTEGER, download_time INTEGER);";
    }

    public static java.lang.String b_renamed() {
        return "CREATE TABLE IF NOT EXISTS animoji_info (uuid TEXT NOT NULL, background_color TEXT NOT NULL, FOREIGN KEY(uuid)REFERENCES sticker_item(uuid));";
    }

    public static java.lang.String c_renamed() {
        return "CREATE TABLE IF NOT EXISTS multi_info (uuid TEXT NOT NULL, sticker_fit_to_size INTEGER, sticker_name TEXT, position_type INTEGER, z_position INTEGER, base_size_16_9 TEXT, display_rect_16_9 TEXT, file_content_uri_16_9 TEXT, base_size_4_3 TEXT, display_rect_4_3 TEXT, file_content_uri_4_3 TEXT, base_size_1_1 TEXT, display_rect_1_1 TEXT, file_content_uri_1_1 TEXT, FOREIGN KEY(uuid)REFERENCES sticker_item(uuid));";
    }

    public static boolean a_renamed(android.content.Context context, com.oplus.camera.sticker.data.BuildInSticker buildInSticker) {
        if (buildInSticker == null || android.text.TextUtils.isEmpty(buildInSticker.getStickerUUID())) {
            throw new java.lang.IllegalArgumentException("isBuildInStickerCanAddOrUpdate, invalid Sticker!");
        }
        com.oplus.camera.sticker.data.StickerItemWrapper stickerItemWrapperA = a_renamed(context, com.heytap.accessory.constant.AFConstants.EXTRA_UUID, buildInSticker.getStickerUUID());
        com.oplus.camera.e_renamed.b_renamed("StickerItemTableHelper", "isBuildInStickerCanAddOrUpdate, item: " + stickerItemWrapperA + ", Sticker: " + buildInSticker);
        return stickerItemWrapperA == null || stickerItemWrapperA.getVersion() < buildInSticker.getVersion();
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:121:0x040b A_renamed[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:128:? A_renamed[Catch: Exception -> 0x0415, SYNTHETIC, TRY_LEAVE, TryCatch #6 {Exception -> 0x0415, blocks: (B_renamed:92:0x03fa, B_renamed:103:0x040b, B_renamed:108:0x0414, B_renamed:107:0x0411, B_renamed:90:0x03f5), top: B_renamed:119:0x03f5, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:130:? A_renamed[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:92:0x03fa A_renamed[Catch: Exception -> 0x0415, TRY_ENTER, TRY_LEAVE, TryCatch #6 {Exception -> 0x0415, blocks: (B_renamed:92:0x03fa, B_renamed:103:0x040b, B_renamed:108:0x0414, B_renamed:107:0x0411, B_renamed:90:0x03f5), top: B_renamed:119:0x03f5, inners: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a_renamed(android.content.Context r24, com.oplus.camera.sticker.data.StickerItemWrapper r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1089
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.sticker.a_renamed.b_renamed.a_renamed(android.content.Context, com.oplus.camera.sticker.data.StickerItemWrapper):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B_renamed:154:0x04c5  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:160:0x04d1  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:169:0x0485 A_renamed[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:173:0x0451 A_renamed[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:190:? A_renamed[Catch: Exception -> 0x04a2, all -> 0x04cd, SYNTHETIC, TryCatch #7 {all -> 0x04cd, blocks: (B_renamed:110:0x0451, B_renamed:152:0x04af, B_renamed:134:0x0485, B_renamed:139:0x048e, B_renamed:138:0x048b, B_renamed:106:0x0435, B_renamed:108:0x044c, B_renamed:140:0x048f), top: B_renamed:168:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:192:? A_renamed[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:193:? A_renamed[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:81:0x02ca  */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v69 */
    /* JADX WARN: Type inference failed for: r1v71 */
    /* JADX WARN: Type inference failed for: r1v8, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r20v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v5, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v75 */
    /* JADX WARN: Type inference failed for: r4v82 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a_renamed(android.content.Context r26, java.util.List<com.oplus.camera.sticker.data.StickerItemWrapper> r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.sticker.a_renamed.b_renamed.a_renamed(android.content.Context, java.util.List):boolean");
    }

    public static int a_renamed(android.content.Context context, com.oplus.camera.sticker.data.StickerItem stickerItem) {
        com.oplus.camera.e_renamed.e_renamed("StickerItemTableHelper", "updateStickerDownloadTime item: " + stickerItem);
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("download_time", java.lang.Long.valueOf(java.lang.System.currentTimeMillis()));
        return a_renamed(context, com.heytap.accessory.constant.AFConstants.EXTRA_UUID, stickerItem.getStickerUUID(), contentValues);
    }

    public static int a_renamed(android.content.Context context, java.lang.String str, java.lang.String str2, android.content.ContentValues contentValues) {
        com.oplus.camera.e_renamed.e_renamed("StickerItemTableHelper", "updateStickerItem");
        return context.getContentResolver().update(com.oplus.camera.sticker.a_renamed.c_renamed.d_renamed.f5422a, contentValues, str + " = ?", new java.lang.String[]{str2});
    }

    public static java.util.List<com.oplus.camera.sticker.data.StickerItem> a_renamed(android.content.Context context, boolean z_renamed) {
        android.content.ContentResolver contentResolver = context.getContentResolver();
        java.lang.String str = !z_renamed ? "is_build_in <> 1" : null;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            android.database.Cursor cursorQuery = contentResolver.query(com.oplus.camera.sticker.a_renamed.c_renamed.d_renamed.f5422a, null, str, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        do {
                            com.oplus.camera.sticker.data.StickerItemWrapper stickerItemWrapperA = a_renamed(cursorQuery);
                            if (stickerItemWrapperA != null && !android.text.TextUtils.isEmpty(stickerItemWrapperA.getStickerUUID())) {
                                arrayList.add(stickerItemWrapperA);
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
            com.oplus.camera.e_renamed.e_renamed("StickerItemTableHelper", "getAllStickerItem, e_renamed: " + e_renamed);
        }
        return arrayList;
    }

    public static com.oplus.camera.sticker.data.StickerItemWrapper a_renamed(android.content.Context context, java.lang.String str, java.lang.String str2) {
        android.content.ContentResolver contentResolver = context.getContentResolver();
        com.oplus.camera.sticker.data.StickerItemWrapper stickerItemWrapperA = null;
        try {
            android.database.Cursor cursorQuery = contentResolver.query(com.oplus.camera.sticker.a_renamed.c_renamed.d_renamed.f5422a, null, str + " = ?", new java.lang.String[]{str2}, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        stickerItemWrapperA = a_renamed(cursorQuery);
                    }
                } finally {
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.e_renamed("StickerItemTableHelper", "getStickerItem, e_renamed: " + e_renamed);
        }
        return stickerItemWrapperA;
    }

    public static com.oplus.camera.sticker.data.StickerItemWrapper a_renamed(android.database.Cursor cursor) {
        com.oplus.camera.sticker.data.StickerItemWrapper stickerItemWrapper = new com.oplus.camera.sticker.data.StickerItemWrapper();
        stickerItemWrapper.setStickerId(cursor.getLong(cursor.getColumnIndexOrThrow("_id")));
        stickerItemWrapper.setStickerUUID(cursor.getString(cursor.getColumnIndexOrThrow(com.heytap.accessory.constant.AFConstants.EXTRA_UUID)));
        stickerItemWrapper.setStickerName(cursor.getString(cursor.getColumnIndexOrThrow("name")));
        stickerItemWrapper.setFileDownloadUrl(cursor.getString(cursor.getColumnIndexOrThrow("file_url")));
        stickerItemWrapper.setFileMd5(cursor.getString(cursor.getColumnIndexOrThrow("file_md5")));
        stickerItemWrapper.setFilePath(cursor.getString(cursor.getColumnIndexOrThrow("file_path")));
        stickerItemWrapper.setFileContentUri(cursor.getString(cursor.getColumnIndexOrThrow("file_content_uri")));
        stickerItemWrapper.setThumbnailUrl(cursor.getString(cursor.getColumnIndexOrThrow("thumbnail_url")));
        stickerItemWrapper.setThumbnailPath(cursor.getString(cursor.getColumnIndexOrThrow("thumbnail_path")));
        stickerItemWrapper.setThumbnailFileUri(cursor.getString(cursor.getColumnIndexOrThrow("thumbnail_file_uri")));
        stickerItemWrapper.setThumbnailMd5(cursor.getString(cursor.getColumnIndexOrThrow("thumbnail_md5")));
        stickerItemWrapper.setLogoUrl(cursor.getString(cursor.getColumnIndexOrThrow("logo_url")));
        stickerItemWrapper.setLogoPath(cursor.getString(cursor.getColumnIndexOrThrow("logo_path")));
        stickerItemWrapper.setLogoFileUri(cursor.getString(cursor.getColumnIndexOrThrow("logo_file_uri")));
        stickerItemWrapper.setLogoMd5(cursor.getString(cursor.getColumnIndexOrThrow("logo_md5")));
        stickerItemWrapper.setDownloadUid(cursor.getString(cursor.getColumnIndexOrThrow("download_uuid")));
        stickerItemWrapper.setVersion(cursor.getLong(cursor.getColumnIndexOrThrow(com.oplus.camera.statistics.CameraStatisticsUtil.RUS_FILE_VERSION)));
        stickerItemWrapper.setProtocolVersion(cursor.getLong(cursor.getColumnIndexOrThrow("protocol_version")));
        stickerItemWrapper.setDownloadTime(cursor.getLong(cursor.getColumnIndexOrThrow("download_time")));
        stickerItemWrapper.setLastRequestTime(cursor.getLong(cursor.getColumnIndexOrThrow("request_time")));
        stickerItemWrapper.setCategoryId(cursor.getString(cursor.getColumnIndexOrThrow("category_id")));
        stickerItemWrapper.setCategoryPosition(cursor.getInt(cursor.getColumnIndexOrThrow("category_position")));
        stickerItemWrapper.setPosition(cursor.getInt(cursor.getColumnIndexOrThrow("position")));
        stickerItemWrapper.setDownloadState(cursor.getInt(cursor.getColumnIndexOrThrow("download_state")));
        stickerItemWrapper.setAttribute(cursor.getLong(cursor.getColumnIndexOrThrow("attribute")));
        stickerItemWrapper.setHasMusic(cursor.getInt(cursor.getColumnIndexOrThrow("has_music")) != 0);
        stickerItemWrapper.setNeedUpdate(cursor.getInt(cursor.getColumnIndexOrThrow("need_update")) != 0);
        stickerItemWrapper.setIsBuildIn(cursor.getInt(cursor.getColumnIndexOrThrow("is_build_in")) != 0);
        stickerItemWrapper.setStickerNew(cursor.getInt(cursor.getColumnIndexOrThrow("is_new")) != 0);
        stickerItemWrapper.setValid(cursor.getInt(cursor.getColumnIndexOrThrow("is_valid")) != 0);
        stickerItemWrapper.setMaterialType(cursor.getInt(cursor.getColumnIndexOrThrow("material_type")));
        return stickerItemWrapper;
    }

    public static void b_renamed(android.content.Context context, com.oplus.camera.sticker.data.StickerItem stickerItem) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("download_state", (java.lang.Integer) 0);
        contentValues.put("download_uuid", "");
        a_renamed(context, com.heytap.accessory.constant.AFConstants.EXTRA_UUID, stickerItem.getStickerUUID(), contentValues);
    }

    public static java.util.List<com.oplus.camera.sticker.data.StickerItem> a_renamed(android.content.Context context) {
        android.database.Cursor cursorQuery = context.getContentResolver().query(com.oplus.camera.sticker.a_renamed.c_renamed.d_renamed.f5422a, null, a_renamed(23), null, null);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (cursorQuery != null && cursorQuery.moveToFirst()) {
            do {
                arrayList.add(a_renamed(cursorQuery));
            } while (cursorQuery.moveToNext());
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return arrayList;
    }

    private static java.lang.String a_renamed(int i_renamed) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(" ");
        sb.append("download_state");
        sb.append(" IN_renamed (");
        if ((i_renamed & 1) != 0) {
            sb.append(1);
            sb.append(",");
        }
        if ((i_renamed & 2) != 0) {
            sb.append(2);
            sb.append(",");
        }
        if ((i_renamed & 4) != 0) {
            sb.append(4);
            sb.append(",");
        }
        if ((i_renamed & 8) != 0) {
            sb.append(8);
            sb.append(",");
        }
        if ((i_renamed & 16) != 0) {
            sb.append(16);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        return sb.toString();
    }

    public static void a_renamed(android.content.Context context, long j_renamed, long j2) {
        android.content.ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver != null) {
            java.lang.String[] strArr = {java.lang.String.valueOf(1)};
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put("is_new", (java.lang.Integer) 0);
            com.oplus.camera.e_renamed.b_renamed("StickerItemTableHelper", "autoClearStickerNewStatus, update count: " + contentResolver.update(com.oplus.camera.sticker.a_renamed.c_renamed.d_renamed.f5422a, contentValues, "is_new = ? AND request_time < " + (j_renamed - j2), strArr) + ", currTime: " + j_renamed);
        }
    }

    public static void b_renamed(android.content.Context context) {
        android.content.ContentResolver contentResolver = context.getContentResolver();
        java.lang.String[] strArr = {java.lang.String.valueOf(0)};
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("is_valid", (java.lang.Integer) 0);
        com.oplus.camera.e_renamed.b_renamed("StickerItemTableHelper", "preCheckStickerValid, update count: " + contentResolver.update(com.oplus.camera.sticker.a_renamed.c_renamed.d_renamed.f5422a, contentValues, "download_state = ? AND is_build_in <> 1", strArr));
    }

    public static void c_renamed(android.content.Context context) {
        android.content.ContentResolver contentResolver = context.getContentResolver();
        java.util.ArrayList<com.oplus.camera.sticker.data.StickerItemWrapper> arrayList = new java.util.ArrayList();
        android.database.Cursor cursorQuery = contentResolver.query(com.oplus.camera.sticker.a_renamed.c_renamed.d_renamed.f5422a, null, "is_valid = 0 AND is_build_in <> 1", null, null);
        while (cursorQuery != null) {
            try {
                if (!cursorQuery.moveToNext()) {
                    break;
                } else {
                    arrayList.add(a_renamed(cursorQuery));
                }
            } catch (java.lang.Throwable th) {
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (java.lang.Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        for (com.oplus.camera.sticker.data.StickerItemWrapper stickerItemWrapper : arrayList) {
            com.oplus.camera.e_renamed.b_renamed("StickerItemTableHelper", "postCheckStickerValidStatus, delete item: " + stickerItemWrapper + ", deleteThumbResult: " + com.oplus.camera.sticker.c_renamed.b_renamed.b_renamed(stickerItemWrapper.getThumbnailPath()) + ", deleteLogoResult: " + com.oplus.camera.sticker.c_renamed.b_renamed.b_renamed(stickerItemWrapper.getLogoPath()));
        }
        com.oplus.camera.e_renamed.b_renamed("StickerItemTableHelper", "postCheckStickerValidStatus, delete invalid sticker, count: " + contentResolver.delete(com.oplus.camera.sticker.a_renamed.c_renamed.d_renamed.f5422a, "is_valid = 0 AND is_build_in <> 1", null));
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:21:0x006e A_renamed[Catch: Throwable -> 0x0098, Exception -> 0x00a4, TRY_LEAVE, TryCatch #2 {Throwable -> 0x0098, blocks: (B_renamed:18:0x0045, B_renamed:20:0x004b, B_renamed:21:0x006e), top: B_renamed:40:0x0045, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a_renamed(android.content.Context r13, java.lang.String r14, com.oplus.camera.sticker.data.AnimojiStickerExtendedInfo r15) {
        /*
            r0 = 0
            java.lang.String r1 = "StickerItemTableHelper"
            if (r13 == 0) goto Lc2
            if (r15 != 0) goto L9
            goto Lc2
        L9:
            java.lang.String r2 = r15.getBackgroundColor()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L19
            java.lang.String r13 = "updateOrAddToAniMojiExtendTable, animojiStickerExtendedInfo color is_renamed empty!"
            com.oplus.camera.e_renamed.e_renamed(r1, r13)
            return r0
        L19:
            boolean r2 = android.text.TextUtils.isEmpty(r14)
            if (r2 == 0) goto L25
            java.lang.String r13 = "updateOrAddToAniMojiExtendTable, uuid is_renamed empty!"
            com.oplus.camera.e_renamed.e_renamed(r1, r13)
            return r0
        L25:
            android.content.ContentResolver r13 = r13.getContentResolver()
            java.lang.String r8 = "uuid = ?"
            r9 = 1
            java.lang.String[] r10 = new java.lang.String[r9]
            r10[r0] = r14
            android.net.Uri r11 = com.oplus.camera.sticker.a_renamed.c_renamed.a_renamed.f5416a
            android.content.ContentValues r12 = new android.content.ContentValues
            r12.<init>()
            r4 = 0
            r7 = 0
            r2 = r13
            r3 = r11
            r5 = r8
            r6 = r10
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Exception -> La4
            java.lang.String r3 = "background_color"
            if (r2 == 0) goto L6e
            int r4 = r2.getCount()     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> La4
            if (r4 <= 0) goto L6e
            r2.moveToFirst()     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> La4
            java.lang.String r15 = r15.getBackgroundColor()     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> La4
            r12.put(r3, r15)     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> La4
            int r13 = r13.update(r11, r12, r8, r10)     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> La4
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> La4
            r15.<init>()     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> La4
            java.lang.String r3 = "updateOrAddToAniMojiExtendTable, update single item. count: "
            r15.append(r3)     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> La4
            r15.append(r13)     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> La4
            java.lang.String r13 = r15.toString()     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> La4
            com.oplus.camera.e_renamed.b_renamed(r1, r13)     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> La4
            goto L92
        L6e:
            java.lang.String r4 = "uuid"
            r12.put(r4, r14)     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> La4
            java.lang.String r15 = r15.getBackgroundColor()     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> La4
            r12.put(r3, r15)     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> La4
            android.net.Uri r13 = r13.insert(r11, r12)     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> La4
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> La4
            r15.<init>()     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> La4
            java.lang.String r3 = "updateOrAddToAniMojiExtendTable, insert single item. insertUri: "
            r15.append(r3)     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> La4
            r15.append(r13)     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> La4
            java.lang.String r13 = r15.toString()     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> La4
            com.oplus.camera.e_renamed.b_renamed(r1, r13)     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> La4
        L92:
            if (r2 == 0) goto L97
            r2.close()     // Catch: java.lang.Exception -> La4
        L97:
            return r9
        L98:
            r13 = move-exception
            if (r2 == 0) goto La3
            r2.close()     // Catch: java.lang.Throwable -> L9f java.lang.Exception -> La4
            goto La3
        L9f:
            r15 = move-exception
            r13.addSuppressed(r15)     // Catch: java.lang.Exception -> La4
        La3:
            throw r13     // Catch: java.lang.Exception -> La4
        La4:
            r13 = move-exception
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r2 = "updateOrAddToAniMojiExtendTable cause a_renamed exception, exception: "
            r15.append(r2)
            r15.append(r13)
            java.lang.String r13 = ", uuid: "
            r15.append(r13)
            r15.append(r14)
            java.lang.String r13 = r15.toString()
            com.oplus.camera.e_renamed.e_renamed(r1, r13)
            return r0
        Lc2:
            java.lang.String r13 = "updateOrAddToAniMojiExtendTable, context or category is_renamed null!"
            com.oplus.camera.e_renamed.e_renamed(r1, r13)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.sticker.a_renamed.b_renamed.a_renamed(android.content.Context, java.lang.String, com.oplus.camera.sticker.data.AnimojiStickerExtendedInfo):boolean");
    }

    public static boolean a_renamed(android.content.Context context, java.lang.String str, java.util.List<com.oplus.camera.sticker.data.MultiStickerExtendedInfo> list) {
        if (context == null || list == null || list.isEmpty()) {
            com.oplus.camera.e_renamed.e_renamed("StickerItemTableHelper", "addToMultiStickerExtendTable, context or category is_renamed null!");
            return false;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            com.oplus.camera.e_renamed.e_renamed("StickerItemTableHelper", "addToMultiStickerExtendTable, uuid is_renamed empty!");
            return false;
        }
        android.content.ContentResolver contentResolver = context.getContentResolver();
        java.lang.String[] strArr = {str};
        android.net.Uri uri = com.oplus.camera.sticker.a_renamed.c_renamed.b_renamed.f5418a;
        try {
            com.oplus.camera.e_renamed.b_renamed("StickerItemTableHelper", "addToMultiStickerExtendTable, delete exist data. count: " + contentResolver.delete(uri, "uuid = ?", strArr));
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (com.oplus.camera.sticker.data.MultiStickerExtendedInfo multiStickerExtendedInfo : list) {
                android.content.ContentValues contentValues = new android.content.ContentValues();
                contentValues.put(com.heytap.accessory.constant.AFConstants.EXTRA_UUID, str);
                contentValues.put("sticker_fit_to_size", java.lang.Integer.valueOf(multiStickerExtendedInfo.getIsFitToSize() ? 1 : 0));
                contentValues.put(com.oplus.camera.statistics.CameraStatisticsUtil.STICKER_NAME, multiStickerExtendedInfo.getStickerName());
                contentValues.put("position_type", java.lang.Integer.valueOf(multiStickerExtendedInfo.getPositionType()));
                contentValues.put("z_position", java.lang.Integer.valueOf(multiStickerExtendedInfo.getZPosition()));
                contentValues.put("base_size_16_9", multiStickerExtendedInfo.getBaseSize16x9());
                contentValues.put("display_rect_16_9", multiStickerExtendedInfo.getDisplayRect16x9());
                contentValues.put("base_size_4_3", multiStickerExtendedInfo.getBaseSize4x3());
                contentValues.put("display_rect_4_3", multiStickerExtendedInfo.getDisplayRect4x3());
                contentValues.put("base_size_1_1", multiStickerExtendedInfo.getBaseSize1x1());
                contentValues.put("display_rect_1_1", multiStickerExtendedInfo.getDisplayRect1x1());
                contentValues.put("file_content_uri_16_9", multiStickerExtendedInfo.getFileContentUri16x9());
                contentValues.put("file_content_uri_4_3", multiStickerExtendedInfo.getFileContentUri4x3());
                contentValues.put("file_content_uri_1_1", multiStickerExtendedInfo.getFileContentUri1x1());
                arrayList.add(contentValues);
            }
            int iBulkInsert = contentResolver.bulkInsert(uri, (android.content.ContentValues[]) arrayList.toArray(new android.content.ContentValues[0]));
            int size = list.size();
            if (iBulkInsert == size) {
                return true;
            }
            com.oplus.camera.e_renamed.e_renamed("StickerItemTableHelper", "addToMultiStickerExtendTable, insert count error! count: " + iBulkInsert + ", size: " + size);
            return false;
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.e_renamed("StickerItemTableHelper", "addToMultiStickerExtendTable cause a_renamed exception, exception: " + e_renamed + ", sticker: " + str);
            return false;
        }
    }

    public static java.util.List<com.oplus.camera.sticker.data.MultiStickerExtendedInfo> c_renamed(android.content.Context context, com.oplus.camera.sticker.data.StickerItem stickerItem) {
        if (context == null || stickerItem == null) {
            return null;
        }
        if (stickerItem.getMaterialType() != 1) {
            com.oplus.camera.e_renamed.e_renamed("StickerItemTableHelper", "getMultiStickerInfo, not a_renamed multi type! item: " + stickerItem);
            return null;
        }
        if (android.text.TextUtils.isEmpty(stickerItem.getStickerUUID())) {
            com.oplus.camera.e_renamed.e_renamed("StickerItemTableHelper", "getMultiStickerInfo, sticker uuid is_renamed empty! item: " + stickerItem);
            return null;
        }
        android.content.ContentResolver contentResolver = context.getContentResolver();
        java.lang.String[] strArr = {stickerItem.getStickerUUID()};
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            android.database.Cursor cursorQuery = contentResolver.query(com.oplus.camera.sticker.a_renamed.c_renamed.b_renamed.f5418a, null, "uuid = ?", strArr, null);
            while (cursorQuery != null) {
                try {
                    if (!cursorQuery.moveToNext()) {
                        break;
                    }
                    arrayList.add(b_renamed(cursorQuery));
                } finally {
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.e_renamed("StickerItemTableHelper", "getMultiStickerInfo, e_renamed:" + e_renamed);
        }
        return arrayList;
    }

    private static com.oplus.camera.sticker.data.MultiStickerExtendedInfo b_renamed(android.database.Cursor cursor) {
        com.oplus.camera.sticker.data.MultiStickerExtendedInfo multiStickerExtendedInfo = new com.oplus.camera.sticker.data.MultiStickerExtendedInfo();
        multiStickerExtendedInfo.setIsFitToSize(cursor.getInt(cursor.getColumnIndexOrThrow("sticker_fit_to_size")) == 1);
        multiStickerExtendedInfo.setStickerName(cursor.getString(cursor.getColumnIndexOrThrow(com.oplus.camera.statistics.CameraStatisticsUtil.STICKER_NAME)));
        multiStickerExtendedInfo.setPositionType(cursor.getInt(cursor.getColumnIndexOrThrow("position_type")));
        multiStickerExtendedInfo.setZPosition(cursor.getInt(cursor.getColumnIndexOrThrow("z_position")));
        multiStickerExtendedInfo.setBaseSize16x9(cursor.getString(cursor.getColumnIndexOrThrow("base_size_16_9")));
        multiStickerExtendedInfo.setDisplayRect16x9(cursor.getString(cursor.getColumnIndexOrThrow("display_rect_16_9")));
        multiStickerExtendedInfo.setFileContentUri16x9(cursor.getString(cursor.getColumnIndexOrThrow("file_content_uri_16_9")));
        multiStickerExtendedInfo.setBaseSize4x3(cursor.getString(cursor.getColumnIndexOrThrow("base_size_4_3")));
        multiStickerExtendedInfo.setDisplayRect4x3(cursor.getString(cursor.getColumnIndexOrThrow("display_rect_4_3")));
        multiStickerExtendedInfo.setFileContentUri4x3(cursor.getString(cursor.getColumnIndexOrThrow("file_content_uri_4_3")));
        multiStickerExtendedInfo.setBaseSize1x1(cursor.getString(cursor.getColumnIndexOrThrow("base_size_1_1")));
        multiStickerExtendedInfo.setDisplayRect1x1(cursor.getString(cursor.getColumnIndexOrThrow("display_rect_1_1")));
        multiStickerExtendedInfo.setFileContentUri1x1(cursor.getString(cursor.getColumnIndexOrThrow("file_content_uri_1_1")));
        return multiStickerExtendedInfo;
    }

    public static boolean d_renamed(android.content.Context context, com.oplus.camera.sticker.data.StickerItem stickerItem) {
        if (context == null || stickerItem == null) {
            com.oplus.camera.e_renamed.e_renamed("StickerItemTableHelper", "deleteMultiStickerInfo, parameter is_renamed null! context: " + context);
            return false;
        }
        com.oplus.camera.e_renamed.b_renamed("StickerItemTableHelper", "deleteMultiStickerInfo, count: " + context.getContentResolver().delete(com.oplus.camera.sticker.a_renamed.c_renamed.b_renamed.f5418a, "uuid = ?", new java.lang.String[]{stickerItem.getStickerUUID()}) + ", item name: " + stickerItem.getStickerName());
        return true;
    }

    public static boolean b_renamed(android.content.Context context, com.oplus.camera.sticker.data.StickerItemWrapper stickerItemWrapper) {
        if (context == null || stickerItemWrapper == null) {
            com.oplus.camera.e_renamed.e_renamed("StickerItemTableHelper", "deleteAnimojiStickerInfo, parameter is_renamed null! context: " + context);
            return false;
        }
        com.oplus.camera.e_renamed.b_renamed("StickerItemTableHelper", "deleteAnimojiStickerInfo, count: " + context.getContentResolver().delete(com.oplus.camera.sticker.a_renamed.c_renamed.a_renamed.f5416a, "uuid = ?", new java.lang.String[]{stickerItemWrapper.getStickerUUID()}) + ", item name: " + stickerItemWrapper.getStickerName());
        return true;
    }
}
