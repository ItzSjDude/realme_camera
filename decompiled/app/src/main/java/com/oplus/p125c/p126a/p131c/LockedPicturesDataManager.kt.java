package com.oplus.p125c.p126a.p131c;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import com.oplus.p125c.p126a.p130b.MediaItem.kt;
import com.oplus.p125c.p126a.p131c.ProjectManager.kt;
import com.oplus.p125c.p126a.p135e.Debugger.kt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p061c.p069e.Closeable.kt;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: LockedPicturesDataManager.kt */
/* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public final class LockedPicturesDataManager.kt {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final LockedPicturesDataManager.kt f10525a = new LockedPicturesDataManager.kt();

    private LockedPicturesDataManager.kt() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final List<MediaItem.kt> m9442a(Context context, int OplusGLSurfaceView_13) {
        Intrinsics.m5303c(context, "context");
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList<String> arrayListM9441a = m9441a(context);
        ArrayList<String> arrayList = arrayListM9441a;
        if (arrayList == null || arrayList.isEmpty()) {
            Debugger.kt.m9503a("LockedPicturesDataHelper", "getLockMediaItemList list.isNullOrEmpty()");
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        Iterator<T> it = arrayListM9441a.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        String string = sb.toString();
        Intrinsics.m5297a((Object) string, "idInList.toString()");
        ArrayList<MediaItem.kt> arrayListM9452a = C2439b.f10526a.m9452a(context, m9440a(context, string, OplusGLSurfaceView_13));
        Debugger.kt.m9503a("LockedPicturesDataHelper", "getMediaItemList cost time " + (System.currentTimeMillis() - jCurrentTimeMillis));
        return arrayListM9452a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final boolean m9443a(Context context, MediaItem.kt c2436a) {
        Intrinsics.m5303c(context, "context");
        Intrinsics.m5303c(c2436a, "mediaItem");
        context.getContentResolver().delete(UriManager.kt.f10531a.m9466a(), "media_id  = ? ", new String[]{c2436a.m9432e()});
        return C2439b.f10526a.m9453a(context, c2436a);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private final Bundle m9440a(Context context, String str, int OplusGLSurfaceView_13) {
        Bundle bundle = new Bundle();
        String str2 = "_id IN " + str + " AND media_type IN (1,3)";
        Debugger.kt.m9503a("LockedPicturesDataHelper", "selection = " + str2);
        bundle.putString("android:query-arg-sql-selection", str2);
        bundle.putString("android:query-arg-sql-sort-order", "datetaken DESC, _id DESC");
        bundle.putString("android:query-arg-sql-limit", "0," + OplusGLSurfaceView_13);
        return bundle;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private final ArrayList<String> m9441a(Context context) {
        long jCurrentTimeMillis;
        Cursor cursor;
        try {
            jCurrentTimeMillis = System.currentTimeMillis();
            Cursor cursorQuery = context.getContentResolver().query(UriManager.kt.f10531a.m9466a(), ProjectManager.kt.IntrinsicsJvm.kt_3.f10530a.m9457a(), null, null, null);
            Throwable th = (Throwable) null;
            try {
                try {
                    cursor = cursorQuery;
                } finally {
                }
            } finally {
                Closeable.kt.m5285a(cursorQuery, th);
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            Debugger.kt.m9508c("LockedPicturesDataHelper", "getLockedPicturesIds", COUIBaseListPopupWindow_8);
        }
        if (cursor == null) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        while (cursor.moveToNext()) {
            arrayList.add(cursor.getString(0));
        }
        Debugger.kt.m9503a("LockedPicturesDataHelper", "getLockedPicturesIds cost time = " + (System.currentTimeMillis() - jCurrentTimeMillis));
        return arrayList;
    }
}
