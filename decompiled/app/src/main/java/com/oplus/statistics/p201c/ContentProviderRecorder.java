package com.oplus.statistics.p201c;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import com.oplus.statistics.p200b.TrackEvent;
import com.oplus.statistics.p204f.LogUtil;
import com.oplus.statistics.p204f.Supplier;
import java.util.Map;

/* compiled from: ContentProviderRecorder.java */
/* renamed from: com.oplus.statistics.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class ContentProviderRecorder implements IRecorder {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ String m25330a() {
        return "get provider client failed.";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public static /* synthetic */ String m25334b() {
        return "get resolver failed.";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public static /* synthetic */ String m25335c() {
        return "not support content provider";
    }

    @Override // com.oplus.statistics.p201c.IRecorder
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo25336a(Context context, TrackEvent abstractC3733m) {
        m25333a(context, "content://com.oplus.statistics.provider/track_event", m25329a(abstractC3733m));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private ContentValues m25329a(TrackEvent abstractC3733m) {
        ContentValues contentValues = new ContentValues();
        for (Map.Entry<String, Object> entry : abstractC3733m.m25315f().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                contentValues.put(key, (String) value);
            } else if (value instanceof Integer) {
                contentValues.put(key, (Integer) value);
            } else if (value instanceof Long) {
                contentValues.put(key, (Long) value);
            } else if (value instanceof Boolean) {
                contentValues.put(key, (Boolean) value);
            }
        }
        return contentValues;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m25332a(Context context) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("", "");
        boolean zM25333a = m25333a(context, "content://com.oplus.statistics.provider/support", contentValues);
        if (!zM25333a) {
            LogUtil.m25431b("ContentProviderRecorder", new Supplier() { // from class: com.oplus.statistics.IntrinsicsJvm.kt_3.-$$Lambda$IntrinsicsJvm.kt_4$RcPCcJEByRf51l3JlMsujXJR8Jc
                @Override // com.oplus.statistics.p204f.Supplier
                public final Object get() {
                    return ContentProviderRecorder.m25335c();
                }
            });
        }
        return zM25333a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m25333a(Context context, String str, ContentValues contentValues) {
        Uri uri = Uri.parse(str);
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            LogUtil.m25433d("ContentProviderRecorder", new Supplier() { // from class: com.oplus.statistics.IntrinsicsJvm.kt_3.-$$Lambda$IntrinsicsJvm.kt_4$logum9ZfsQakauZ7NmalWnt1OgQ
                @Override // com.oplus.statistics.p204f.Supplier
                public final Object get() {
                    return ContentProviderRecorder.m25334b();
                }
            });
            return false;
        }
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
        if (contentProviderClientAcquireUnstableContentProviderClient == null) {
            LogUtil.m25433d("ContentProviderRecorder", new Supplier() { // from class: com.oplus.statistics.IntrinsicsJvm.kt_3.-$$Lambda$IntrinsicsJvm.kt_4$MS_s9q4EDvKpOcUUpkv7IU16jQ8
                @Override // com.oplus.statistics.p204f.Supplier
                public final Object get() {
                    return ContentProviderRecorder.m25330a();
                }
            });
            return false;
        }
        try {
            try {
                contentProviderClientAcquireUnstableContentProviderClient.insert(uri, contentValues);
                contentProviderClientAcquireUnstableContentProviderClient.close();
                return true;
            } catch (RemoteException | IllegalArgumentException | IllegalStateException COUIBaseListPopupWindow_8) {
                LogUtil.m25428a("ContentProviderRecorder", new Supplier() { // from class: com.oplus.statistics.IntrinsicsJvm.kt_3.-$$Lambda$IntrinsicsJvm.kt_4$FTe1WuZHlwAEHmkxS3JqC2dbkJI
                    @Override // com.oplus.statistics.p204f.Supplier
                    public final Object get() {
                        return ContentProviderRecorder.m25331a(COUIBaseListPopupWindow_8);
                    }
                });
                contentProviderClientAcquireUnstableContentProviderClient.close();
                return false;
            }
        } catch (Throwable th) {
            contentProviderClientAcquireUnstableContentProviderClient.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ String m25331a(Exception exc) {
        return "insert exception:" + exc;
    }
}
