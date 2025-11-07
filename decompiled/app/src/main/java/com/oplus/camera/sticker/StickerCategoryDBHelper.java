package com.oplus.camera.sticker;

import android.content.Context;
import android.database.Cursor;
import com.oplus.camera.sticker.data.StickerCategoryItem;
import com.oplus.camera.sticker.p165a.StickerTableColumns;

/* compiled from: StickerCategoryDBHelper.java */
/* renamed from: com.oplus.camera.sticker.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class StickerCategoryDBHelper {
    /* renamed from: PlatformImplementations.kt_3 */
    private static String[] m16933a() {
        return new String[]{"_id", "category_id", "category_name", "category_position", "category_icon_file_uri", "category_highlight_icon_file_uri", "category_is_new", "category_request_time"};
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static StickerCategoryItem m16932a(Cursor cursor) {
        StickerCategoryItem stickerCategoryItem = new StickerCategoryItem();
        stickerCategoryItem.setReadableId(cursor.getString(1));
        stickerCategoryItem.setCategoryName(cursor.getString(2));
        stickerCategoryItem.setPosition(cursor.getInt(3));
        stickerCategoryItem.setIconFileUri(cursor.getString(4));
        stickerCategoryItem.setIconHighlightFileUri(cursor.getString(5));
        stickerCategoryItem.setCategoryNew(cursor.getInt(6) != 0);
        stickerCategoryItem.setLastRequestTime(cursor.getLong(7));
        return stickerCategoryItem;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Cursor m16930a(Context context, long OplusGLSurfaceView_15) {
        return m16931a(context, StickerTableColumns.COUIBaseListPopupWindow_8.f16181a, m16933a(), "attribute & " + OplusGLSurfaceView_15 + " = " + OplusGLSurfaceView_15 + ") GROUP BY (category_id", null, "category_position ASC");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006b  */
    /* JADX WARN: Type inference failed for: r10v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r10v10, types: [android.content.ContentProviderClient] */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8, types: [android.content.ContentProviderClient] */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.database.Cursor m16931a(android.content.Context r10, android.net.Uri r11, java.lang.String[] r12, java.lang.String r13, java.lang.String[] r14, java.lang.String r15) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "StickerCategoryDBHelper"
            r1 = 0
            android.content.ContentResolver r2 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L27 android.os.RemoteException -> L2a
            android.net.Uri r3 = com.oplus.camera.sticker.p165a.StickerTableColumns.IntrinsicsJvm.kt_3.f16177a     // Catch: java.lang.Throwable -> L27 android.os.RemoteException -> L2a
            android.content.ContentProviderClient r2 = r2.acquireUnstableContentProviderClient(r3)     // Catch: java.lang.Throwable -> L27 android.os.RemoteException -> L2a
            if (r2 == 0) goto L1c
            r4 = r2
            r5 = r11
            r6 = r12
            r7 = r13
            r8 = r14
            r9 = r15
            android.database.Cursor r1 = r4.query(r5, r6, r7, r8, r9)     // Catch: android.os.RemoteException -> L1a java.lang.Throwable -> L68
            goto L21
        L1a:
            r11 = move-exception
            goto L2c
        L1c:
            java.lang.String r11 = "getUnstableContentProviderCursor, client is null"
            com.oplus.camera.CameraLog.m12966e(r0, r11)     // Catch: android.os.RemoteException -> L1a java.lang.Throwable -> L68
        L21:
            if (r2 == 0) goto L63
            r2.close()
            goto L63
        L27:
            r10 = move-exception
            r2 = r1
            goto L69
        L2a:
            r11 = move-exception
            r2 = r1
        L2c:
            java.lang.String r3 = "getUnstableContentProviderCursor, RemoteException! COUIBaseListPopupWindow_8: "
            com.oplus.camera.CameraLog.m12963c(r0, r3, r11)     // Catch: java.lang.Throwable -> L68
            if (r2 == 0) goto L36
            r2.close()     // Catch: java.lang.Throwable -> L68
        L36:
            android.content.ContentResolver r10 = r10.getContentResolver()     // Catch: android.os.RemoteException -> L57 java.lang.Throwable -> L68
            android.net.Uri r11 = com.oplus.camera.sticker.p165a.StickerTableColumns.IntrinsicsJvm.kt_3.f16177a     // Catch: android.os.RemoteException -> L57 java.lang.Throwable -> L68
            android.content.ContentProviderClient r10 = r10.acquireUnstableContentProviderClient(r11)     // Catch: android.os.RemoteException -> L57 java.lang.Throwable -> L68
            if (r10 == 0) goto L51
            android.net.Uri r4 = com.oplus.camera.sticker.p165a.StickerTableColumns.IntrinsicsJvm.kt_3.f16177a     // Catch: android.os.RemoteException -> L4f java.lang.Throwable -> L64
            r3 = r10
            r5 = r12
            r6 = r13
            r7 = r14
            r8 = r15
            android.database.Cursor r11 = r3.query(r4, r5, r6, r7, r8)     // Catch: android.os.RemoteException -> L4f java.lang.Throwable -> L64
            r1 = r11
            goto L5e
        L4f:
            r11 = move-exception
            goto L59
        L51:
            java.lang.String r11 = "getUnstableContentProviderCursor2, client is null"
            com.oplus.camera.CameraLog.m12966e(r0, r11)     // Catch: android.os.RemoteException -> L4f java.lang.Throwable -> L64
            goto L5e
        L57:
            r11 = move-exception
            r10 = r2
        L59:
            java.lang.String r12 = "getUnstableContentProviderCursor, RemoteException again! "
            com.oplus.camera.CameraLog.m12963c(r0, r12, r11)     // Catch: java.lang.Throwable -> L64
        L5e:
            if (r10 == 0) goto L63
            r10.close()
        L63:
            return r1
        L64:
            r11 = move-exception
            r2 = r10
            r10 = r11
            goto L69
        L68:
            r10 = move-exception
        L69:
            if (r2 == 0) goto L6e
            r2.close()
        L6e:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.sticker.StickerCategoryDBHelper.m16931a(android.content.Context, android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String):android.database.Cursor");
    }
}
