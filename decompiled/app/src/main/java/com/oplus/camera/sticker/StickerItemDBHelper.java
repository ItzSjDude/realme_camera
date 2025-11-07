package com.oplus.camera.sticker;

import android.content.Context;
import android.database.Cursor;
import android.database.MergeCursor;
import android.text.TextUtils;
import com.heytap.accessory.constant.AFConstants;
import com.oplus.camera.CameraLog;
import com.oplus.camera.statistics.CameraStatisticsUtil;
import com.oplus.camera.sticker.data.AnimojiStickerExtendedInfo;
import com.oplus.camera.sticker.data.MultiStickerExtendedInfo;
import com.oplus.camera.sticker.data.StickerCategoryItem;
import com.oplus.camera.sticker.data.StickerItem;
import com.oplus.camera.sticker.p165a.StickerTableColumns;
import java.util.ArrayList;
import java.util.List;

/* compiled from: StickerItemDBHelper.java */
/* renamed from: com.oplus.camera.sticker.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public class StickerItemDBHelper {
    /* renamed from: PlatformImplementations.kt_3 */
    public static Cursor m16950a(Context context, long OplusGLSurfaceView_15, String str) {
        if (TextUtils.isEmpty(str)) {
            CameraLog.m12966e("StickerItemDBHelper", "getStickerItemsCursor, empty categoryId!");
            return null;
        }
        if (StickerCategoryItem.isMyCategory(str)) {
            Cursor cursorM16949a = m16949a(context, OplusGLSurfaceView_15);
            if (cursorM16949a != null) {
                Cursor cursorM16948a = m16948a(context);
                if (cursorM16948a != null) {
                    return new MergeCursor(new Cursor[]{cursorM16948a, cursorM16949a});
                }
                CameraLog.m12966e("StickerItemDBHelper", "getStickerItemsCursor, recycleBinStickerCursor is null!");
                return cursorM16949a;
            }
            CameraLog.m12966e("StickerItemDBHelper", "getStickerItemsCursor, myStickerCursor is null!");
            return null;
        }
        return m16951a(context, StickerTableColumns.IntrinsicsJvm.kt_5.f16179a, null, "category_id = \"" + str + "\" AND attribute & " + OplusGLSurfaceView_15 + " = " + OplusGLSurfaceView_15, null, "is_build_in ASC, is_valid DESC, position ASC");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static StickerItem m16953a(Cursor cursor) {
        StickerItem stickerItem = new StickerItem();
        stickerItem.setStickerId(cursor.getLong(cursor.getColumnIndexOrThrow("_id")));
        stickerItem.setStickerUUID(cursor.getString(cursor.getColumnIndexOrThrow(AFConstants.EXTRA_UUID)));
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
        stickerItem.setVersion(cursor.getLong(cursor.getColumnIndexOrThrow(CameraStatisticsUtil.RUS_FILE_VERSION)));
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

    /* renamed from: PlatformImplementations.kt_3 */
    public static Cursor m16949a(Context context, long OplusGLSurfaceView_15) {
        return m16951a(context, StickerTableColumns.IntrinsicsJvm.kt_5.f16179a, null, "download_time > 0 AND download_state = 8 AND attribute & " + OplusGLSurfaceView_15 + " = " + OplusGLSurfaceView_15, null, "download_time DESC");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Cursor m16948a(Context context) {
        return m16951a(context, StickerTableColumns.IntrinsicsJvm.kt_5.f16179a, null, "uuid = '68714002-1206-472f-a3c8-74eea52f7808'", null, "");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static StickerItem m16952a(Context context, String str, String str2) throws Throwable {
        try {
            Cursor cursorM16951a = m16951a(context, StickerTableColumns.IntrinsicsJvm.kt_5.f16179a, null, str + " = ?", new String[]{str2}, null);
            if (cursorM16951a != null) {
                try {
                    if (cursorM16951a.moveToFirst()) {
                        StickerItem stickerItemM16953a = m16953a(cursorM16951a);
                        if (cursorM16951a != null) {
                            cursorM16951a.close();
                        }
                        return stickerItemM16953a;
                    }
                } finally {
                }
            }
            if (cursorM16951a == null) {
                return null;
            }
            cursorM16951a.close();
            return null;
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12966e("StickerItemDBHelper", "getStickerItem, exception: " + COUIBaseListPopupWindow_8);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Type inference failed for: r9v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r9v10, types: [android.content.ContentProviderClient] */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8, types: [android.content.ContentProviderClient] */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.database.Cursor m16951a(android.content.Context r9, android.net.Uri r10, java.lang.String[] r11, java.lang.String r12, java.lang.String[] r13, java.lang.String r14) throws java.lang.Throwable {
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
            java.lang.String r3 = "getUnstableContentProviderCursor, client is null!"
            com.oplus.camera.CameraLog.m12966e(r0, r3)     // Catch: android.os.RemoteException -> L18 java.lang.Throwable -> L63
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
            java.lang.String r4 = "getUnstableContentProviderCursor, RemoteException! COUIBaseListPopupWindow_8: "
            com.oplus.camera.CameraLog.m12963c(r0, r4, r3)     // Catch: java.lang.Throwable -> L63
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
            java.lang.String r10 = "getUnstableContentProviderCursor2, client is null!"
            com.oplus.camera.CameraLog.m12966e(r0, r10)     // Catch: android.os.RemoteException -> L4a java.lang.Throwable -> L5f
            goto L59
        L52:
            r10 = move-exception
            r9 = r2
        L54:
            java.lang.String r11 = "getUnstableContentProviderCursor, RemoteException again! "
            com.oplus.camera.CameraLog.m12963c(r0, r11, r10)     // Catch: java.lang.Throwable -> L5f
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
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.sticker.StickerItemDBHelper.m16951a(android.content.Context, android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String):android.database.Cursor");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static List<MultiStickerExtendedInfo> m16954a(Context context, StickerItem stickerItem) throws Throwable {
        if (context == null || stickerItem == null) {
            return null;
        }
        if (stickerItem.getMaterialType() != 1) {
            CameraLog.m12966e("StickerItemDBHelper", "getMultiStickerInfo, not PlatformImplementations.kt_3 multi type! item: " + stickerItem);
            return null;
        }
        if (TextUtils.isEmpty(stickerItem.getStickerUUID())) {
            CameraLog.m12966e("StickerItemDBHelper", "getMultiStickerInfo, sticker uuid is empty! item: " + stickerItem);
            return null;
        }
        String[] strArr = {stickerItem.getStickerUUID()};
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorM16951a = m16951a(context, StickerTableColumns.IntrinsicsJvm.kt_4.f16175a, null, "uuid = ?", strArr, null);
            while (cursorM16951a != null) {
                try {
                    if (!cursorM16951a.moveToNext()) {
                        break;
                    }
                    arrayList.add(m16956b(cursorM16951a));
                } finally {
                }
            }
            if (cursorM16951a != null) {
                cursorM16951a.close();
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12966e("StickerItemDBHelper", "getMultiStickerInfo, COUIBaseListPopupWindow_8 = " + COUIBaseListPopupWindow_8);
        }
        return arrayList;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static MultiStickerExtendedInfo m16956b(Cursor cursor) {
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

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static AnimojiStickerExtendedInfo m16955b(Context context, StickerItem stickerItem) throws Throwable {
        AnimojiStickerExtendedInfo animojiStickerExtendedInfoM16957c = null;
        if (context != null && stickerItem != null) {
            if (stickerItem.getMaterialType() != 2) {
                CameraLog.m12966e("StickerItemDBHelper", "getAnimojiStickerInfo, not PlatformImplementations.kt_3 animoji type! item: " + stickerItem);
                return null;
            }
            if (TextUtils.isEmpty(stickerItem.getStickerUUID())) {
                CameraLog.m12966e("StickerItemDBHelper", "getAnimojiStickerInfo, sticker uuid is empty! item: " + stickerItem);
                return null;
            }
            try {
                Cursor cursorM16951a = m16951a(context, StickerTableColumns.PlatformImplementations.kt_3.f16173a, null, "uuid = ?", new String[]{stickerItem.getStickerUUID()}, null);
                if (cursorM16951a != null) {
                    try {
                        if (cursorM16951a.getCount() > 0) {
                            cursorM16951a.moveToFirst();
                            animojiStickerExtendedInfoM16957c = m16957c(cursorM16951a);
                        }
                    } finally {
                    }
                }
                if (cursorM16951a != null) {
                    cursorM16951a.close();
                }
            } catch (Exception COUIBaseListPopupWindow_8) {
                CameraLog.m12966e("StickerItemDBHelper", "getAnimojiStickerInfo, COUIBaseListPopupWindow_8: " + COUIBaseListPopupWindow_8);
            }
        }
        return animojiStickerExtendedInfoM16957c;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static AnimojiStickerExtendedInfo m16957c(Cursor cursor) {
        AnimojiStickerExtendedInfo animojiStickerExtendedInfo = new AnimojiStickerExtendedInfo();
        animojiStickerExtendedInfo.setBackgroundColor(cursor.getString(cursor.getColumnIndexOrThrow("background_color")));
        return animojiStickerExtendedInfo;
    }
}
