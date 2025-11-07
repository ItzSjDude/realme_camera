package com.oplus.camera.sticker.p165a;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.oplus.camera.CameraLog;
import com.oplus.camera.sticker.data.BuildInStickerCategory;
import com.oplus.camera.sticker.data.StickerCategoryItem;
import com.oplus.camera.sticker.data.StickerCategoryItemWrapper;
import com.oplus.camera.sticker.p165a.StickerTableColumns;
import java.util.ArrayList;
import java.util.List;

/* compiled from: StickerCategoryTableHelper.java */
/* renamed from: com.oplus.camera.sticker.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class StickerCategoryTableHelper {
    /* renamed from: PlatformImplementations.kt_3 */
    public static String m16743a() {
        return "CREATE TABLE IF NOT EXISTS sticker_category (_id INTEGER PRIMARY KEY, readable_id TEXT UNIQUE, category_name TEXT, position INTEGER, icon_url TEXT, icon_md5 TEXT, icon_path TEXT, icon_file_uri TEXT, icon_highlight_url TEXT, icon_highlight_md5 TEXT, icon_highlight_path TEXT, icon_highlight_file_uri TEXT, is_new INTEGER DEFAULT 0, request_time INTEGER, is_valid INTEGER DEFAULT 1);";
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x01c5 A[Catch: Exception -> 0x01dc, TRY_ENTER, TRY_LEAVE, TryCatch #5 {Exception -> 0x01dc, blocks: (B:25:0x00f5, B:49:0x01c5, B:58:0x01d2, B:63:0x01db, B:62:0x01d8, B:47:0x01c0), top: B:82:0x003f, inners: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01d2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:? A[Catch: Exception -> 0x01dc, SYNTHETIC, TRY_LEAVE, TryCatch #5 {Exception -> 0x01dc, blocks: (B:25:0x00f5, B:49:0x01c5, B:58:0x01d2, B:63:0x01db, B:62:0x01d8, B:47:0x01c0), top: B:82:0x003f, inners: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean m16746a(android.content.Context r19, com.oplus.camera.sticker.data.StickerCategoryItemWrapper r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 520
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.sticker.p165a.StickerCategoryTableHelper.m16746a(android.content.Context, com.oplus.camera.sticker.data.StickerCategoryItemWrapper):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0224 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0214 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:115:? A[Catch: Exception -> 0x023c, all -> 0x023e, SYNTHETIC, TryCatch #1 {Exception -> 0x023c, blocks: (B:43:0x0148, B:67:0x0211, B:73:0x0224, B:78:0x022d, B:77:0x022a, B:65:0x020c, B:79:0x022e), top: B:102:0x0148 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0211 A[Catch: Exception -> 0x023c, all -> 0x023e, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x023c, blocks: (B:43:0x0148, B:67:0x0211, B:73:0x0224, B:78:0x022d, B:77:0x022a, B:65:0x020c, B:79:0x022e), top: B:102:0x0148 }] */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean m16747a(android.content.Context r22, java.util.List<com.oplus.camera.sticker.data.StickerCategoryItemWrapper> r23) {
        /*
            Method dump skipped, instructions count: 625
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.sticker.p165a.StickerCategoryTableHelper.m16747a(android.content.Context, java.util.List):boolean");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static List<StickerCategoryItem> m16744a(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = contentResolver.query(StickerTableColumns.IntrinsicsJvm.kt_3.f16177a, null, null, null, "position ASC");
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        do {
                            StickerCategoryItemWrapper stickerCategoryItemWrapperM16742a = m16742a(cursorQuery);
                            if (stickerCategoryItemWrapperM16742a != null && !TextUtils.isEmpty(stickerCategoryItemWrapperM16742a.getCategoryName())) {
                                arrayList.add(stickerCategoryItemWrapperM16742a);
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
            CameraLog.m12966e("StickerCategoryTableHelper", "getAllStickerCategory, COUIBaseListPopupWindow_8: " + COUIBaseListPopupWindow_8);
        }
        return arrayList;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static StickerCategoryItemWrapper m16742a(Cursor cursor) {
        StickerCategoryItemWrapper stickerCategoryItemWrapper = new StickerCategoryItemWrapper();
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

    /* renamed from: PlatformImplementations.kt_3 */
    public static StickerCategoryItem m16741a(Context context, String str, String str2) {
        ContentResolver contentResolver = context.getContentResolver();
        StickerCategoryItemWrapper stickerCategoryItemWrapperM16742a = null;
        try {
            Cursor cursorQuery = contentResolver.query(StickerTableColumns.IntrinsicsJvm.kt_3.f16177a, null, str + " = \"" + str2 + "\"", null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        stickerCategoryItemWrapperM16742a = m16742a(cursorQuery);
                        CameraLog.m12959b("StickerCategoryTableHelper", "getStickerCategory, item: " + stickerCategoryItemWrapperM16742a);
                    }
                } finally {
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12963c("StickerCategoryTableHelper", "getStickerCategory, COUIBaseListPopupWindow_8:", COUIBaseListPopupWindow_8);
        }
        return stickerCategoryItemWrapperM16742a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m16739a(Context context, BuildInStickerCategory buildInStickerCategory) {
        StickerCategoryItem stickerCategoryItemM16741a = m16741a(context, "readable_id", buildInStickerCategory.getReadableId());
        CameraLog.m12959b("StickerCategoryTableHelper", "isStickerCategoryCanAddOrUpdate, item: " + stickerCategoryItemM16741a + ", Category: " + buildInStickerCategory);
        if (stickerCategoryItemM16741a == null) {
            return 1;
        }
        return stickerCategoryItemM16741a.getIconVersion() < buildInStickerCategory.getIconVersion() ? 2 : 0;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m16740a(Context context, String str, String str2, ContentValues contentValues) {
        return context.getContentResolver().update(StickerTableColumns.IntrinsicsJvm.kt_3.f16177a, contentValues, str + " = ?", new String[]{String.valueOf(str2)});
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m16745a(Context context, long OplusGLSurfaceView_15, long j2) {
        String[] strArr = {String.valueOf(1)};
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_new", (Integer) 0);
        CameraLog.m12959b("StickerCategoryTableHelper", "autoClearStickerNewStatus, update count: " + context.getContentResolver().update(StickerTableColumns.IntrinsicsJvm.kt_3.f16177a, contentValues, "is_new = ? AND request_time < " + (OplusGLSurfaceView_15 - j2), strArr) + ", currTime: " + OplusGLSurfaceView_15);
    }
}
