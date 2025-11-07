package com.oplus.p125c.p126a.p131c;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.RecoverableSecurityException;
import android.content.Context;
import android.content.IntentSender;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.oplus.ocs.camera.CameraParameter;
import com.oplus.p125c.p126a.p130b.MediaItem.kt;
import com.oplus.p125c.p126a.p131c.ProjectManager.kt;
import com.oplus.p125c.p126a.p135e.Debugger.kt;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import p061c.p062a.C0887h;
import p061c.p069e.Closeable.kt;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: MediaStoreDataManager.kt */
/* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public final class C2439b {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final C2439b f10526a = new C2439b();

    private C2439b() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final ArrayList<MediaItem.kt> m9451a(Context context, int OplusGLSurfaceView_13) {
        Intrinsics.m5303c(context, "context");
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList<MediaItem.kt> arrayListM9452a = m9452a(context, m9446b(context, OplusGLSurfaceView_13));
        StringBuilder sb = new StringBuilder();
        sb.append("getCameraMediaItemList size = ");
        sb.append(arrayListM9452a != null ? Integer.valueOf(arrayListM9452a.size()) : null);
        sb.append(" , time = ");
        sb.append(System.currentTimeMillis() - jCurrentTimeMillis);
        Debugger.kt.m9503a("MediaStoreDataHelper", sb.toString());
        return arrayListM9452a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final ArrayList<MediaItem.kt> m9452a(Context context, Bundle bundle) {
        Intrinsics.m5303c(context, "context");
        Intrinsics.m5303c(bundle, "bundle");
        try {
            Debugger.kt.m9503a("MediaStoreDataHelper", "getCameraMediaItemList bundle = " + bundle + '}');
            Cursor cursorQuery = context.getContentResolver().query(UriManager.kt.m9458a(UriManager.kt.f10531a, null, 1, null), ProjectManager.kt.IntrinsicsJvm.kt_4.f10529a.m9456a(), bundle, null);
            Throwable th = (Throwable) null;
            try {
                ArrayList<MediaItem.kt> arrayListM9445a = f10526a.m9445a(cursorQuery);
                if (arrayListM9445a != null) {
                    C0887h.m5234b((List) arrayListM9445a);
                }
                return arrayListM9445a;
            } finally {
                Closeable.kt.m5285a(cursorQuery, th);
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            Debugger.kt.m9504a("MediaStoreDataHelper", "getCameraMediaItemList", COUIBaseListPopupWindow_8);
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final boolean m9453a(Context context, MediaItem.kt c2436a) throws IntentSender.SendIntentException {
        Intrinsics.m5303c(context, "context");
        Intrinsics.m5303c(c2436a, "mediaItem");
        try {
            try {
                if (c2436a.m9438k()) {
                    return f10526a.m9448b(context, c2436a);
                }
                return context.getContentResolver().delete(c2436a.m9434g(), null, null) >= 1;
            } catch (IntentSender.SendIntentException COUIBaseListPopupWindow_8) {
                Debugger.kt.m9508c("MediaStoreDataHelper", "deleteMediaItem run: ", COUIBaseListPopupWindow_8);
                return false;
            }
        } catch (RecoverableSecurityException unused) {
            PendingIntent pendingIntentCreateDeleteRequest = MediaStore.createDeleteRequest(context.getContentResolver(), C0887h.m5230b(c2436a.m9434g()));
            Intrinsics.m5297a((Object) pendingIntentCreateDeleteRequest, "MediaStore.createDeleteR…rayListOf(mediaItem.uri))");
            ((Activity) context).startIntentSenderForResult(pendingIntentCreateDeleteRequest.getIntentSender(), 100, null, 0, 0, 0);
            return false;
        } catch (SecurityException e2) {
            Debugger.kt.m9508c("MediaStoreDataHelper", "deleteMediaItem run: ", e2);
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.os.Bundle] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r8v0, types: [android.content.Context, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v4, types: [android.content.ContentResolver] */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.io.Closeable] */
    /* renamed from: PlatformImplementations.kt_3 */
    public final MediaItem.kt m9449a(Context context, String str) {
        Cursor cursor;
        Intrinsics.m5303c(context, "context");
        Intrinsics.m5303c(str, "mediaId");
        long jCurrentTimeMillis = System.currentTimeMillis();
        ?? bundle = new Bundle();
        bundle.putString("android:query-arg-sql-selection", "_id  = " + str);
        try {
            try {
                context = context.getContentResolver().query(UriManager.kt.m9458a(UriManager.kt.f10531a, null, 1, null), ProjectManager.kt.IntrinsicsJvm.kt_4.f10529a.m9456a(), bundle, null);
                bundle = (Throwable) 0;
                cursor = context;
            } finally {
                Closeable.kt.m5285a(context, bundle);
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            Debugger.kt.m9508c("MediaStoreDataHelper", "getMediaItem", COUIBaseListPopupWindow_8);
        }
        if (cursor == null) {
            return null;
        }
        if (cursor.getCount() <= 0) {
            Debugger.kt.m9503a("MediaStoreDataHelper", "getMediaItem count <= 0 ");
            return null;
        }
        cursor.moveToFirst();
        C2439b c2439b = f10526a;
        Intrinsics.m5297a((Object) cursor, "this");
        MediaItem.kt c2436aM9447b = c2439b.m9447b(cursor);
        Debugger.kt.m9503a("MediaStoreDataHelper", "getMediaItem cost time = " + (System.currentTimeMillis() - jCurrentTimeMillis));
        return c2436aM9447b;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final boolean m9448b(Context context, MediaItem.kt c2436a) {
        String parent = new File(c2436a.m9433f()).getParent();
        if (parent == null) {
            return false;
        }
        Locale locale = Locale.ROOT;
        Intrinsics.m5297a((Object) locale, "Locale.ROOT");
        if (parent == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = parent.toLowerCase(locale);
        Intrinsics.m5301b(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        return context.getContentResolver().delete(UriManager.kt.f10531a.m9469a(c2436a.m9437j()), "bucket_id = ? ", new String[]{String.valueOf(lowerCase.hashCode())}) >= 1;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Bundle m9446b(Context context, int OplusGLSurfaceView_13) {
        Bundle bundle = new Bundle();
        ArrayList<String> arrayListM9450a = f10526a.m9450a(context);
        if (arrayListM9450a.isEmpty()) {
            bundle.putString("android:query-arg-sql-selection", "relative_path = 'DCIM/Camera/' AND media_type IN (1,3) ");
            Debugger.kt.m9503a("MediaStoreDataHelper", "selection = relative_path = 'DCIM/Camera/' AND media_type IN (1,3) ");
        } else {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = arrayListM9450a.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            String str = "relative_path = 'DCIM/Camera/' AND media_type IN (1,3)  OR _id IN (" + ((Object) sb) + ')';
            Debugger.kt.m9503a("MediaStoreDataHelper", "selection = " + str);
            bundle.putString("android:query-arg-sql-selection", str);
        }
        bundle.putString("android:query-arg-sql-sort-order", "datetaken DESC, _id DESC");
        bundle.putString("android:query-arg-sql-limit", "0, " + OplusGLSurfaceView_13);
        return bundle;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private final ArrayList<MediaItem.kt> m9445a(Cursor cursor) {
        ArrayList<MediaItem.kt> arrayList = null;
        if (cursor != null) {
            if (cursor.getCount() <= 0) {
                Debugger.kt.m9503a("MediaStoreDataHelper", "getItemListFromCursor count is 0");
                return null;
            }
            arrayList = new ArrayList<>();
            while (cursor.moveToNext()) {
                arrayList.add(f10526a.m9447b(cursor));
            }
        }
        return arrayList;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final MediaItem.kt m9447b(Cursor cursor) {
        String string = cursor.getString(0);
        String string2 = cursor.getString(1);
        int OplusGLSurfaceView_13 = cursor.getInt(2);
        long OplusGLSurfaceView_15 = cursor.getLong(3);
        int i2 = cursor.getInt(4);
        String string3 = cursor.getString(5);
        int i3 = cursor.getInt(6);
        int i4 = cursor.getInt(7);
        String string4 = cursor.getString(8);
        boolean z = i2 == 3;
        Intrinsics.m5297a((Object) string, TtmlNode.ATTR_ID);
        Intrinsics.m5297a((Object) string2, CameraParameter.WaterMarkParamKeys.FILE_PATH);
        MediaItem.kt c2436a = new MediaItem.kt(string, string2, UriManager.kt.f10531a.m9468a(string, z), OplusGLSurfaceView_13, OplusGLSurfaceView_15, z, ProjectManager.kt.PlatformImplementations.kt_3.f10527a.m9454a().matcher(string3).matches());
        c2436a.m9425a(OplusGLSurfaceView_13);
        c2436a.m9428b(i3);
        c2436a.m9430c(i4);
        Intrinsics.m5297a((Object) string4, "mimeType");
        c2436a.m9426a(string4);
        return c2436a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4] */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.io.Closeable] */
    /* renamed from: PlatformImplementations.kt_3 */
    public final ArrayList<String> m9450a(Context context) {
        Throwable th;
        Intrinsics.m5303c(context, "context");
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            try {
                this = context.getContentResolver().query(UriManager.kt.m9461b(UriManager.kt.f10531a, null, 1, null), ProjectManager.kt.PlatformImplementations.kt_3.f10527a.m9455b(), m9444a(), null);
                th = (Throwable) null;
                Cursor cursor = this;
                if (cursor != null) {
                    if (cursor.getCount() <= 0) {
                        Debugger.kt.m9503a("MediaStoreDataHelper", "getCShotMediaIdList count < = 0");
                        return arrayList;
                    }
                    while (cursor.moveToNext()) {
                        if (ProjectManager.kt.PlatformImplementations.kt_3.f10527a.m9454a().matcher(cursor.getString(1)).matches()) {
                            arrayList.add(cursor.getString(0));
                        }
                    }
                }
            } finally {
                Closeable.kt.m5285a(this, th);
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            Debugger.kt.m9508c("MediaStoreDataHelper", "getCShotMediaIdList ", COUIBaseListPopupWindow_8);
        }
        Debugger.kt.m9503a("MediaStoreDataHelper", "getCShotMediaIdList array.size = " + arrayList.size() + ", cost time = " + (System.currentTimeMillis() - jCurrentTimeMillis));
        return arrayList;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private final Bundle m9444a() {
        Bundle bundle = new Bundle();
        bundle.putString("android:query-arg-sql-selection", "relative_path LIKE 'DCIM/Camera/Cshot/%'");
        bundle.putString("android:query-arg-sql-group-by", "relative_path");
        bundle.putString("android:query-arg-sql-having", "_data =  MIN (_data)");
        return bundle;
    }
}
