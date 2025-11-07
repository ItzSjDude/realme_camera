package com.oplus.camera.sticker;

/* compiled from: StickerItemDBHelper.java */
/* loaded from: classes2.dex */
public class g_renamed {
    public static android.database.Cursor a_renamed(android.content.Context context, long j_renamed, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.oplus.camera.e_renamed.e_renamed("StickerItemDBHelper", "getStickerItemsCursor, empty categoryId!");
            return null;
        }
        if (com.oplus.camera.sticker.data.StickerCategoryItem.isMyCategory(str)) {
            android.database.Cursor cursorA = a_renamed(context, j_renamed);
            if (cursorA != null) {
                android.database.Cursor cursorA2 = a_renamed(context);
                if (cursorA2 != null) {
                    return new android.database.MergeCursor(new android.database.Cursor[]{cursorA2, cursorA});
                }
                com.oplus.camera.e_renamed.e_renamed("StickerItemDBHelper", "getStickerItemsCursor, recycleBinStickerCursor is_renamed null!");
                return cursorA;
            }
            com.oplus.camera.e_renamed.e_renamed("StickerItemDBHelper", "getStickerItemsCursor, myStickerCursor is_renamed null!");
            return null;
        }
        return a_renamed(context, com.oplus.camera.sticker.a_renamed.c_renamed.d_renamed.f5422a, null, "category_id = \"" + str + "\" AND attribute & " + j_renamed + " = " + j_renamed, null, "is_build_in ASC, is_valid DESC, position ASC");
    }

    public static com.oplus.camera.sticker.data.StickerItem a_renamed(android.database.Cursor cursor) {
        com.oplus.camera.sticker.data.StickerItem stickerItem = new com.oplus.camera.sticker.data.StickerItem();
        stickerItem.setStickerId(cursor.getLong(cursor.getColumnIndexOrThrow("_id")));
        stickerItem.setStickerUUID(cursor.getString(cursor.getColumnIndexOrThrow(com.heytap.accessory.constant.AFConstants.EXTRA_UUID)));
        stickerItem.setStickerName(cursor.getString(cursor.getColumnIndexOrThrow("name")));
        stickerItem.setFileDownloadUrl(cursor.getString(cursor.getColumnIndexOrThrow("file_url")));
        stickerItem.setFileMd5(cursor.getString(cursor.getColumnIndexOrThrow("file_md5")));
        stickerItem.setFileContentUri(cursor.getString(cursor.getColumnIndexOrThrow("file_content_uri")));
        stickerItem.setThumbnailUrl(cursor.getString(cursor.getColumnIndexOrThrow("thumbnail_url")));
        stickerItem.setThumbnailFileUri(cursor.getString(cursor.getColumnIndexOrThrow("thumbnail_file_uri")));
        stickerItem.setThumbnailMd5(cursor.getString(cursor.getColumnIndexOrThrow("thumbnail_md5")));
        stickerItem.setLogoUrl(cursor.getString(cursor.getColumnIndexOrThrow("logo_url")));
        stickerItem.setLogoFileUri(cursor.getString(cursor.getColumnIndexOrThrow("logo_file_uri")));
        stickerItem.setLogoMd5(cursor.getString(cursor.getColumnIndexOrThrow("logo_md5")));
        stickerItem.setDownloadUid(cursor.getString(cursor.getColumnIndexOrThrow("download_uuid")));
        stickerItem.setVersion(cursor.getLong(cursor.getColumnIndexOrThrow(com.oplus.camera.statistics.CameraStatisticsUtil.RUS_FILE_VERSION)));
        stickerItem.setProtocolVersion(cursor.getLong(cursor.getColumnIndexOrThrow("protocol_version")));
        stickerItem.setDownloadTime(cursor.getLong(cursor.getColumnIndexOrThrow("download_time")));
        stickerItem.setLastRequestTime(cursor.getLong(cursor.getColumnIndexOrThrow("request_time")));
        stickerItem.setCategoryId(cursor.getString(cursor.getColumnIndexOrThrow("category_id")));
        stickerItem.setCategoryPosition(cursor.getInt(cursor.getColumnIndexOrThrow("category_position")));
        stickerItem.setPosition(cursor.getInt(cursor.getColumnIndexOrThrow("position")));
        stickerItem.setDownloadState(cursor.getInt(cursor.getColumnIndexOrThrow("download_state")));
        stickerItem.setAttribute(cursor.getInt(cursor.getColumnIndexOrThrow("attribute")));
        stickerItem.setHasMusic(cursor.getInt(cursor.getColumnIndexOrThrow("has_music")) != 0);
        stickerItem.setNeedUpdate(cursor.getInt(cursor.getColumnIndexOrThrow("need_update")) != 0);
        stickerItem.setIsBuildIn(cursor.getInt(cursor.getColumnIndexOrThrow("is_build_in")) != 0);
        stickerItem.setStickerNew(cursor.getInt(cursor.getColumnIndexOrThrow("is_new")) != 0);
        stickerItem.setValid(cursor.getInt(cursor.getColumnIndexOrThrow("is_valid")) != 0);
        stickerItem.setMaterialType(cursor.getInt(cursor.getColumnIndexOrThrow("material_type")));
        return stickerItem;
    }

    public static android.database.Cursor a_renamed(android.content.Context context, long j_renamed) {
        return a_renamed(context, com.oplus.camera.sticker.a_renamed.c_renamed.d_renamed.f5422a, null, "download_time > 0 AND download_state = 8 AND attribute & " + j_renamed + " = " + j_renamed, null, "download_time DESC");
    }

    public static android.database.Cursor a_renamed(android.content.Context context) {
        return a_renamed(context, com.oplus.camera.sticker.a_renamed.c_renamed.d_renamed.f5422a, null, "uuid = '68714002-1206-472f-a3c8-74eea52f7808'", null, "");
    }

    public static com.oplus.camera.sticker.data.StickerItem a_renamed(android.content.Context context, java.lang.String str, java.lang.String str2) throws java.lang.Throwable {
        try {
            android.database.Cursor cursorA = a_renamed(context, com.oplus.camera.sticker.a_renamed.c_renamed.d_renamed.f5422a, null, str + " = ?", new java.lang.String[]{str2}, null);
            if (cursorA != null) {
                try {
                    if (cursorA.moveToFirst()) {
                        com.oplus.camera.sticker.data.StickerItem stickerItemA = a_renamed(cursorA);
                        if (cursorA != null) {
                            cursorA.close();
                        }
                        return stickerItemA;
                    }
                } finally {
                }
            }
            if (cursorA == null) {
                return null;
            }
            cursorA.close();
            return null;
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.e_renamed("StickerItemDBHelper", "getStickerItem, exception: " + e_renamed);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B_renamed:31:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:37:0x0066  */
    /* JADX WARN: Type inference failed for: r9v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r9v10, types: [android.content.ContentProviderClient] */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8, types: [android.content.ContentProviderClient] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.database.Cursor a_renamed(android.content.Context r9, android.net.Uri r10, java.lang.String[] r11, java.lang.String r12, java.lang.String[] r13, java.lang.String r14) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "StickerItemDBHelper"
            r1 = 0
            android.content.ContentResolver r2 = r9.getContentResolver()     // Catch: java.lang.Throwable -> L25 android.os.RemoteException -> L28
            android.content.ContentProviderClient r2 = r2.acquireUnstableContentProviderClient(r10)     // Catch: java.lang.Throwable -> L25 android.os.RemoteException -> L28
            if (r2 == 0) goto L1a
            r3 = r2
            r4 = r10
            r5 = r11
            r6 = r12
            r7 = r13
            r8 = r14
            android.database.Cursor r1 = r3.query(r4, r5, r6, r7, r8)     // Catch: android.os.RemoteException -> L18 java.lang.Throwable -> L63
            goto L1f
        L18:
            r3 = move-exception
            goto L2a
        L1a:
            java.lang.String r3 = "getUnstableContentProviderCursor, client is_renamed null!"
            com.oplus.camera.e_renamed.e_renamed(r0, r3)     // Catch: android.os.RemoteException -> L18 java.lang.Throwable -> L63
        L1f:
            if (r2 == 0) goto L5e
            r2.close()
            goto L5e
        L25:
            r9 = move-exception
            r2 = r1
            goto L64
        L28:
            r3 = move-exception
            r2 = r1
        L2a:
            java.lang.String r4 = "getUnstableContentProviderCursor, RemoteException! e_renamed: "
            com.oplus.camera.e_renamed.c_renamed(r0, r4, r3)     // Catch: java.lang.Throwable -> L63
            if (r2 == 0) goto L34
            r2.close()     // Catch: java.lang.Throwable -> L63
        L34:
            android.content.ContentResolver r9 = r9.getContentResolver()     // Catch: android.os.RemoteException -> L52 java.lang.Throwable -> L63
            android.content.ContentProviderClient r9 = r9.acquireUnstableContentProviderClient(r10)     // Catch: android.os.RemoteException -> L52 java.lang.Throwable -> L63
            if (r9 == 0) goto L4c
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r12
            r7 = r13
            r8 = r14
            android.database.Cursor r10 = r3.query(r4, r5, r6, r7, r8)     // Catch: android.os.RemoteException -> L4a java.lang.Throwable -> L5f
            r1 = r10
            goto L59
        L4a:
            r10 = move-exception
            goto L54
        L4c:
            java.lang.String r10 = "getUnstableContentProviderCursor2, client is_renamed null!"
            com.oplus.camera.e_renamed.e_renamed(r0, r10)     // Catch: android.os.RemoteException -> L4a java.lang.Throwable -> L5f
            goto L59
        L52:
            r10 = move-exception
            r9 = r2
        L54:
            java.lang.String r11 = "getUnstableContentProviderCursor, RemoteException again! "
            com.oplus.camera.e_renamed.c_renamed(r0, r11, r10)     // Catch: java.lang.Throwable -> L5f
        L59:
            if (r9 == 0) goto L5e
            r9.close()
        L5e:
            return r1
        L5f:
            r10 = move-exception
            r2 = r9
            r9 = r10
            goto L64
        L63:
            r9 = move-exception
        L64:
            if (r2 == 0) goto L69
            r2.close()
        L69:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.sticker.g_renamed.a_renamed(android.content.Context, android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String):android.database.Cursor");
    }

    public static java.util.List<com.oplus.camera.sticker.data.MultiStickerExtendedInfo> a_renamed(android.content.Context context, com.oplus.camera.sticker.data.StickerItem stickerItem) throws java.lang.Throwable {
        if (context == null || stickerItem == null) {
            return null;
        }
        if (stickerItem.getMaterialType() != 1) {
            com.oplus.camera.e_renamed.e_renamed("StickerItemDBHelper", "getMultiStickerInfo, not a_renamed multi type! item: " + stickerItem);
            return null;
        }
        if (android.text.TextUtils.isEmpty(stickerItem.getStickerUUID())) {
            com.oplus.camera.e_renamed.e_renamed("StickerItemDBHelper", "getMultiStickerInfo, sticker uuid is_renamed empty! item: " + stickerItem);
            return null;
        }
        java.lang.String[] strArr = {stickerItem.getStickerUUID()};
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            android.database.Cursor cursorA = a_renamed(context, com.oplus.camera.sticker.a_renamed.c_renamed.b_renamed.f5418a, null, "uuid = ?", strArr, null);
            while (cursorA != null) {
                try {
                    if (!cursorA.moveToNext()) {
                        break;
                    }
                    arrayList.add(b_renamed(cursorA));
                } finally {
                }
            }
            if (cursorA != null) {
                cursorA.close();
            }
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.e_renamed("StickerItemDBHelper", "getMultiStickerInfo, e_renamed = " + e_renamed);
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

    public static com.oplus.camera.sticker.data.AnimojiStickerExtendedInfo b_renamed(android.content.Context context, com.oplus.camera.sticker.data.StickerItem stickerItem) throws java.lang.Throwable {
        com.oplus.camera.sticker.data.AnimojiStickerExtendedInfo animojiStickerExtendedInfoC = null;
        if (context != null && stickerItem != null) {
            if (stickerItem.getMaterialType() != 2) {
                com.oplus.camera.e_renamed.e_renamed("StickerItemDBHelper", "getAnimojiStickerInfo, not a_renamed animoji type! item: " + stickerItem);
                return null;
            }
            if (android.text.TextUtils.isEmpty(stickerItem.getStickerUUID())) {
                com.oplus.camera.e_renamed.e_renamed("StickerItemDBHelper", "getAnimojiStickerInfo, sticker uuid is_renamed empty! item: " + stickerItem);
                return null;
            }
            try {
                android.database.Cursor cursorA = a_renamed(context, com.oplus.camera.sticker.a_renamed.c_renamed.a_renamed.f5416a, null, "uuid = ?", new java.lang.String[]{stickerItem.getStickerUUID()}, null);
                if (cursorA != null) {
                    try {
                        if (cursorA.getCount() > 0) {
                            cursorA.moveToFirst();
                            animojiStickerExtendedInfoC = c_renamed(cursorA);
                        }
                    } finally {
                    }
                }
                if (cursorA != null) {
                    cursorA.close();
                }
            } catch (java.lang.Exception e_renamed) {
                com.oplus.camera.e_renamed.e_renamed("StickerItemDBHelper", "getAnimojiStickerInfo, e_renamed: " + e_renamed);
            }
        }
        return animojiStickerExtendedInfoC;
    }

    private static com.oplus.camera.sticker.data.AnimojiStickerExtendedInfo c_renamed(android.database.Cursor cursor) {
        com.oplus.camera.sticker.data.AnimojiStickerExtendedInfo animojiStickerExtendedInfo = new com.oplus.camera.sticker.data.AnimojiStickerExtendedInfo();
        animojiStickerExtendedInfo.setBackgroundColor(cursor.getString(cursor.getColumnIndexOrThrow("background_color")));
        return animojiStickerExtendedInfo;
    }
}
