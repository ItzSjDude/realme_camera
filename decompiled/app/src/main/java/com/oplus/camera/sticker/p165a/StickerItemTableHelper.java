package com.oplus.camera.sticker.p165a;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.heytap.accessory.constant.AFConstants;
import com.oplus.camera.CameraLog;
import com.oplus.camera.statistics.CameraStatisticsUtil;
import com.oplus.camera.sticker.data.BuildInSticker;
import com.oplus.camera.sticker.data.MultiStickerExtendedInfo;
import com.oplus.camera.sticker.data.StickerItem;
import com.oplus.camera.sticker.data.StickerItemWrapper;
import com.oplus.camera.sticker.p165a.StickerTableColumns;
import com.oplus.camera.sticker.p167c.FileUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: StickerItemTableHelper.java */
/* renamed from: com.oplus.camera.sticker.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class StickerItemTableHelper {
    /* renamed from: PlatformImplementations.kt_3 */
    public static String m16752a() {
        return "CREATE TABLE IF NOT EXISTS sticker_item (_id INTEGER PRIMARY KEY, uuid TEXT NOT NULL UNIQUE, name TEXT, file_url TEXT, file_md5 TEXT, file_path TEXT, file_content_uri TEXT, thumbnail_url TEXT, thumbnail_path TEXT, thumbnail_file_uri TEXT, thumbnail_md5 TEXT, version INTEGER, logo_url TEXT, logo_path TEXT, logo_file_uri TEXT, logo_md5 TEXT, has_music INTEGER DEFAULT 0, attribute INTEGER, protocol_version TEXT, position INTEGER, need_update INTEGER DEFAULT 0, is_build_in INTEGER DEFAULT 0, is_new INTEGER DEFAULT 0, category_id TEXT, category_position INTEGER, request_time INTEGER, is_valid INTEGER DEFAULT 1, download_uuid TEXT, download_state INTEGER, download_time INTEGER);";
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static String m16763b() {
        return "CREATE TABLE IF NOT EXISTS animoji_info (uuid TEXT NOT NULL, background_color TEXT NOT NULL, FOREIGN KEY(uuid)REFERENCES sticker_item(uuid));";
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static String m16767c() {
        return "CREATE TABLE IF NOT EXISTS multi_info (uuid TEXT NOT NULL, sticker_fit_to_size INTEGER, sticker_name TEXT, position_type INTEGER, z_position INTEGER, base_size_16_9 TEXT, display_rect_16_9 TEXT, file_content_uri_16_9 TEXT, base_size_4_3 TEXT, display_rect_4_3 TEXT, file_content_uri_4_3 TEXT, base_size_1_1 TEXT, display_rect_1_1 TEXT, file_content_uri_1_1 TEXT, FOREIGN KEY(uuid)REFERENCES sticker_item(uuid));";
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m16757a(Context context, BuildInSticker buildInSticker) {
        if (buildInSticker == null || TextUtils.isEmpty(buildInSticker.getStickerUUID())) {
            throw new IllegalArgumentException("isBuildInStickerCanAddOrUpdate, invalid Sticker!");
        }
        StickerItemWrapper stickerItemWrapperM16750a = m16750a(context, AFConstants.EXTRA_UUID, buildInSticker.getStickerUUID());
        CameraLog.m12959b("StickerItemTableHelper", "isBuildInStickerCanAddOrUpdate, item: " + stickerItemWrapperM16750a + ", Sticker: " + buildInSticker);
        return stickerItemWrapperM16750a == null || stickerItemWrapperM16750a.getVersion() < buildInSticker.getVersion();
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x040b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:128:? A[Catch: Exception -> 0x0415, SYNTHETIC, TRY_LEAVE, TryCatch #6 {Exception -> 0x0415, blocks: (B:92:0x03fa, B:103:0x040b, B:108:0x0414, B:107:0x0411, B:90:0x03f5), top: B:119:0x03f5, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:130:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x03fa A[Catch: Exception -> 0x0415, TRY_ENTER, TRY_LEAVE, TryCatch #6 {Exception -> 0x0415, blocks: (B:92:0x03fa, B:103:0x040b, B:108:0x0414, B:107:0x0411, B:90:0x03f5), top: B:119:0x03f5, inners: #2 }] */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean m16758a(android.content.Context r24, com.oplus.camera.sticker.data.StickerItemWrapper r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1089
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.sticker.p165a.StickerItemTableHelper.m16758a(android.content.Context, com.oplus.camera.sticker.data.StickerItemWrapper):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:154:0x04c5  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x04d1  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0485 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0451 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:190:? A[Catch: Exception -> 0x04a2, all -> 0x04cd, SYNTHETIC, TryCatch #7 {all -> 0x04cd, blocks: (B:110:0x0451, B:152:0x04af, B:134:0x0485, B:139:0x048e, B:138:0x048b, B:106:0x0435, B:108:0x044c, B:140:0x048f), top: B:168:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:192:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:193:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02ca  */
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
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean m16761a(android.content.Context r26, java.util.List<com.oplus.camera.sticker.data.StickerItemWrapper> r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1248
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.sticker.p165a.StickerItemTableHelper.m16761a(android.content.Context, java.util.List):boolean");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m16748a(Context context, StickerItem stickerItem) {
        CameraLog.m12966e("StickerItemTableHelper", "updateStickerDownloadTime item: " + stickerItem);
        ContentValues contentValues = new ContentValues();
        contentValues.put("download_time", Long.valueOf(System.currentTimeMillis()));
        return m16749a(context, AFConstants.EXTRA_UUID, stickerItem.getStickerUUID(), contentValues);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m16749a(Context context, String str, String str2, ContentValues contentValues) {
        CameraLog.m12966e("StickerItemTableHelper", "updateStickerItem");
        return context.getContentResolver().update(StickerTableColumns.IntrinsicsJvm.kt_5.f16179a, contentValues, str + " = ?", new String[]{str2});
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static List<StickerItem> m16755a(Context context, boolean z) {
        ContentResolver contentResolver = context.getContentResolver();
        String str = !z ? "is_build_in <> 1" : null;
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = contentResolver.query(StickerTableColumns.IntrinsicsJvm.kt_5.f16179a, null, str, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        do {
                            StickerItemWrapper stickerItemWrapperM16751a = m16751a(cursorQuery);
                            if (stickerItemWrapperM16751a != null && !TextUtils.isEmpty(stickerItemWrapperM16751a.getStickerUUID())) {
                                arrayList.add(stickerItemWrapperM16751a);
                            }
                        } while (cursorQuery.moveToNext());
                    }
                } finally {
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12966e("StickerItemTableHelper", "getAllStickerItem, COUIBaseListPopupWindow_8: " + COUIBaseListPopupWindow_8);
        }
        return arrayList;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static StickerItemWrapper m16750a(Context context, String str, String str2) {
        ContentResolver contentResolver = context.getContentResolver();
        StickerItemWrapper stickerItemWrapperM16751a = null;
        try {
            Cursor cursorQuery = contentResolver.query(StickerTableColumns.IntrinsicsJvm.kt_5.f16179a, null, str + " = ?", new String[]{str2}, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        stickerItemWrapperM16751a = m16751a(cursorQuery);
                    }
                } finally {
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12966e("StickerItemTableHelper", "getStickerItem, COUIBaseListPopupWindow_8: " + COUIBaseListPopupWindow_8);
        }
        return stickerItemWrapperM16751a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static StickerItemWrapper m16751a(Cursor cursor) {
        StickerItemWrapper stickerItemWrapper = new StickerItemWrapper();
        stickerItemWrapper.setStickerId(cursor.getLong(cursor.getColumnIndexOrThrow("_id")));
        stickerItemWrapper.setStickerUUID(cursor.getString(cursor.getColumnIndexOrThrow(AFConstants.EXTRA_UUID)));
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
        stickerItemWrapper.setVersion(cursor.getLong(cursor.getColumnIndexOrThrow(CameraStatisticsUtil.RUS_FILE_VERSION)));
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

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m16765b(Context context, StickerItem stickerItem) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("download_state", (Integer) 0);
        contentValues.put("download_uuid", "");
        m16749a(context, AFConstants.EXTRA_UUID, stickerItem.getStickerUUID(), contentValues);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static List<StickerItem> m16754a(Context context) {
        Cursor cursorQuery = context.getContentResolver().query(StickerTableColumns.IntrinsicsJvm.kt_5.f16179a, null, m16753a(23), null, null);
        ArrayList arrayList = new ArrayList();
        if (cursorQuery != null && cursorQuery.moveToFirst()) {
            do {
                arrayList.add(m16751a(cursorQuery));
            } while (cursorQuery.moveToNext());
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return arrayList;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static String m16753a(int OplusGLSurfaceView_13) {
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        sb.append("download_state");
        sb.append(" IN (");
        if ((OplusGLSurfaceView_13 & 1) != 0) {
            sb.append(1);
            sb.append(",");
        }
        if ((OplusGLSurfaceView_13 & 2) != 0) {
            sb.append(2);
            sb.append(",");
        }
        if ((OplusGLSurfaceView_13 & 4) != 0) {
            sb.append(4);
            sb.append(",");
        }
        if ((OplusGLSurfaceView_13 & 8) != 0) {
            sb.append(8);
            sb.append(",");
        }
        if ((OplusGLSurfaceView_13 & 16) != 0) {
            sb.append(16);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m16756a(Context context, long OplusGLSurfaceView_15, long j2) {
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver != null) {
            String[] strArr = {String.valueOf(1)};
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_new", (Integer) 0);
            CameraLog.m12959b("StickerItemTableHelper", "autoClearStickerNewStatus, update count: " + contentResolver.update(StickerTableColumns.IntrinsicsJvm.kt_5.f16179a, contentValues, "is_new = ? AND request_time < " + (OplusGLSurfaceView_15 - j2), strArr) + ", currTime: " + OplusGLSurfaceView_15);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m16764b(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        String[] strArr = {String.valueOf(0)};
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_valid", (Integer) 0);
        CameraLog.m12959b("StickerItemTableHelper", "preCheckStickerValid, update count: " + contentResolver.update(StickerTableColumns.IntrinsicsJvm.kt_5.f16179a, contentValues, "download_state = ? AND is_build_in <> 1", strArr));
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static void m16769c(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        ArrayList<StickerItemWrapper> arrayList = new ArrayList();
        Cursor cursorQuery = contentResolver.query(StickerTableColumns.IntrinsicsJvm.kt_5.f16179a, null, "is_valid = 0 AND is_build_in <> 1", null, null);
        while (cursorQuery != null) {
            try {
                if (!cursorQuery.moveToNext()) {
                    break;
                } else {
                    arrayList.add(m16751a(cursorQuery));
                }
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        for (StickerItemWrapper stickerItemWrapper : arrayList) {
            CameraLog.m12959b("StickerItemTableHelper", "postCheckStickerValidStatus, delete item: " + stickerItemWrapper + ", deleteThumbResult: " + FileUtils.m16818b(stickerItemWrapper.getThumbnailPath()) + ", deleteLogoResult: " + FileUtils.m16818b(stickerItemWrapper.getLogoPath()));
        }
        CameraLog.m12959b("StickerItemTableHelper", "postCheckStickerValidStatus, delete invalid sticker, count: " + contentResolver.delete(StickerTableColumns.IntrinsicsJvm.kt_5.f16179a, "is_valid = 0 AND is_build_in <> 1", null));
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006e A[Catch: Throwable -> 0x0098, Exception -> 0x00a4, TRY_LEAVE, TryCatch #2 {Throwable -> 0x0098, blocks: (B:18:0x0045, B:20:0x004b, B:21:0x006e), top: B:40:0x0045, outer: #1 }] */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean m16759a(android.content.Context r13, java.lang.String r14, com.oplus.camera.sticker.data.AnimojiStickerExtendedInfo r15) {
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
            java.lang.String r13 = "updateOrAddToAniMojiExtendTable, animojiStickerExtendedInfo color is empty!"
            com.oplus.camera.CameraLog.m12966e(r1, r13)
            return r0
        L19:
            boolean r2 = android.text.TextUtils.isEmpty(r14)
            if (r2 == 0) goto L25
            java.lang.String r13 = "updateOrAddToAniMojiExtendTable, uuid is empty!"
            com.oplus.camera.CameraLog.m12966e(r1, r13)
            return r0
        L25:
            android.content.ContentResolver r13 = r13.getContentResolver()
            java.lang.String r8 = "uuid = ?"
            r9 = 1
            java.lang.String[] r10 = new java.lang.String[r9]
            r10[r0] = r14
            android.net.Uri r11 = com.oplus.camera.sticker.p165a.StickerTableColumns.PlatformImplementations.kt_3.f16173a
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
            com.oplus.camera.CameraLog.m12959b(r1, r13)     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> La4
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
            com.oplus.camera.CameraLog.m12959b(r1, r13)     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> La4
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
            java.lang.String r2 = "updateOrAddToAniMojiExtendTable cause PlatformImplementations.kt_3 exception, exception: "
            r15.append(r2)
            r15.append(r13)
            java.lang.String r13 = ", uuid: "
            r15.append(r13)
            r15.append(r14)
            java.lang.String r13 = r15.toString()
            com.oplus.camera.CameraLog.m12966e(r1, r13)
            return r0
        Lc2:
            java.lang.String r13 = "updateOrAddToAniMojiExtendTable, context or category is null!"
            com.oplus.camera.CameraLog.m12966e(r1, r13)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.sticker.p165a.StickerItemTableHelper.m16759a(android.content.Context, java.lang.String, com.oplus.camera.sticker.data.AnimojiStickerExtendedInfo):boolean");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m16760a(Context context, String str, List<MultiStickerExtendedInfo> list) {
        if (context == null || list == null || list.isEmpty()) {
            CameraLog.m12966e("StickerItemTableHelper", "addToMultiStickerExtendTable, context or category is null!");
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            CameraLog.m12966e("StickerItemTableHelper", "addToMultiStickerExtendTable, uuid is empty!");
            return false;
        }
        ContentResolver contentResolver = context.getContentResolver();
        String[] strArr = {str};
        Uri uri = StickerTableColumns.IntrinsicsJvm.kt_4.f16175a;
        try {
            CameraLog.m12959b("StickerItemTableHelper", "addToMultiStickerExtendTable, delete exist data. count: " + contentResolver.delete(uri, "uuid = ?", strArr));
            ArrayList arrayList = new ArrayList();
            for (MultiStickerExtendedInfo multiStickerExtendedInfo : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(AFConstants.EXTRA_UUID, str);
                contentValues.put("sticker_fit_to_size", Integer.valueOf(multiStickerExtendedInfo.getIsFitToSize() ? 1 : 0));
                contentValues.put(CameraStatisticsUtil.STICKER_NAME, multiStickerExtendedInfo.getStickerName());
                contentValues.put("position_type", Integer.valueOf(multiStickerExtendedInfo.getPositionType()));
                contentValues.put("z_position", Integer.valueOf(multiStickerExtendedInfo.getZPosition()));
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
            int iBulkInsert = contentResolver.bulkInsert(uri, (ContentValues[]) arrayList.toArray(new ContentValues[0]));
            int size = list.size();
            if (iBulkInsert == size) {
                return true;
            }
            CameraLog.m12966e("StickerItemTableHelper", "addToMultiStickerExtendTable, insert count error! count: " + iBulkInsert + ", size: " + size);
            return false;
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12966e("StickerItemTableHelper", "addToMultiStickerExtendTable cause PlatformImplementations.kt_3 exception, exception: " + COUIBaseListPopupWindow_8 + ", sticker: " + str);
            return false;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static List<MultiStickerExtendedInfo> m16768c(Context context, StickerItem stickerItem) {
        if (context == null || stickerItem == null) {
            return null;
        }
        if (stickerItem.getMaterialType() != 1) {
            CameraLog.m12966e("StickerItemTableHelper", "getMultiStickerInfo, not PlatformImplementations.kt_3 multi type! item: " + stickerItem);
            return null;
        }
        if (TextUtils.isEmpty(stickerItem.getStickerUUID())) {
            CameraLog.m12966e("StickerItemTableHelper", "getMultiStickerInfo, sticker uuid is empty! item: " + stickerItem);
            return null;
        }
        ContentResolver contentResolver = context.getContentResolver();
        String[] strArr = {stickerItem.getStickerUUID()};
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = contentResolver.query(StickerTableColumns.IntrinsicsJvm.kt_4.f16175a, null, "uuid = ?", strArr, null);
            while (cursorQuery != null) {
                try {
                    if (!cursorQuery.moveToNext()) {
                        break;
                    }
                    arrayList.add(m16762b(cursorQuery));
                } finally {
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12966e("StickerItemTableHelper", "getMultiStickerInfo, COUIBaseListPopupWindow_8:" + COUIBaseListPopupWindow_8);
        }
        return arrayList;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static MultiStickerExtendedInfo m16762b(Cursor cursor) {
        MultiStickerExtendedInfo multiStickerExtendedInfo = new MultiStickerExtendedInfo();
        multiStickerExtendedInfo.setIsFitToSize(cursor.getInt(cursor.getColumnIndexOrThrow("sticker_fit_to_size")) == 1);
        multiStickerExtendedInfo.setStickerName(cursor.getString(cursor.getColumnIndexOrThrow(CameraStatisticsUtil.STICKER_NAME)));
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

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static boolean m16770d(Context context, StickerItem stickerItem) {
        if (context == null || stickerItem == null) {
            CameraLog.m12966e("StickerItemTableHelper", "deleteMultiStickerInfo, parameter is null! context: " + context);
            return false;
        }
        CameraLog.m12959b("StickerItemTableHelper", "deleteMultiStickerInfo, count: " + context.getContentResolver().delete(StickerTableColumns.IntrinsicsJvm.kt_4.f16175a, "uuid = ?", new String[]{stickerItem.getStickerUUID()}) + ", item name: " + stickerItem.getStickerName());
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static boolean m16766b(Context context, StickerItemWrapper stickerItemWrapper) {
        if (context == null || stickerItemWrapper == null) {
            CameraLog.m12966e("StickerItemTableHelper", "deleteAnimojiStickerInfo, parameter is null! context: " + context);
            return false;
        }
        CameraLog.m12959b("StickerItemTableHelper", "deleteAnimojiStickerInfo, count: " + context.getContentResolver().delete(StickerTableColumns.PlatformImplementations.kt_3.f16173a, "uuid = ?", new String[]{stickerItemWrapper.getStickerUUID()}) + ", item name: " + stickerItemWrapper.getStickerName());
        return true;
    }
}
