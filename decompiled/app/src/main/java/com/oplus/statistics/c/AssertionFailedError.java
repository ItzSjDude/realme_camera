package com.oplus.statistics.c_renamed;

/* compiled from: ContentProviderRecorder.java */
/* loaded from: classes2.dex */
public class b_renamed implements com.oplus.statistics.c_renamed.c_renamed {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ java.lang.String a_renamed() {
        return "get provider client failed.";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ java.lang.String b_renamed() {
        return "get resolver failed.";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ java.lang.String c_renamed() {
        return "not support content provider";
    }

    @Override // com.oplus.statistics.c_renamed.c_renamed
    public void a_renamed(android.content.Context context, com.oplus.statistics.b_renamed.m_renamed mVar) {
        a_renamed(context, "content://com.oplus.statistics.provider/track_event", a_renamed(mVar));
    }

    private android.content.ContentValues a_renamed(com.oplus.statistics.b_renamed.m_renamed mVar) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : mVar.f_renamed().entrySet()) {
            java.lang.String key = entry.getKey();
            java.lang.Object value = entry.getValue();
            if (value instanceof java.lang.String) {
                contentValues.put(key, (java.lang.String) value);
            } else if (value instanceof java.lang.Integer) {
                contentValues.put(key, (java.lang.Integer) value);
            } else if (value instanceof java.lang.Long) {
                contentValues.put(key, (java.lang.Long) value);
            } else if (value instanceof java.lang.Boolean) {
                contentValues.put(key, (java.lang.Boolean) value);
            }
        }
        return contentValues;
    }

    public static boolean a_renamed(android.content.Context context) {
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put("", "");
        boolean zA = a_renamed(context, "content://com.oplus.statistics.provider/support", contentValues);
        if (!zA) {
            com.oplus.statistics.f_renamed.d_renamed.b_renamed("ContentProviderRecorder", new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.c_renamed.-$$Lambda$b_renamed$RcPCcJEByRf51l3JlMsujXJR8Jc
                @Override // com.oplus.statistics.f_renamed.e_renamed
                public final java.lang.Object get() {
                    return com.oplus.statistics.c_renamed.b_renamed.c_renamed();
                }
            });
        }
        return zA;
    }

    private static boolean a_renamed(android.content.Context context, java.lang.String str, android.content.ContentValues contentValues) {
        android.net.Uri uri = android.net.Uri.parse(str);
        android.content.ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver == null) {
            com.oplus.statistics.f_renamed.d_renamed.d_renamed("ContentProviderRecorder", new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.c_renamed.-$$Lambda$b_renamed$logum9ZfsQakauZ7NmalWnt1OgQ
                @Override // com.oplus.statistics.f_renamed.e_renamed
                public final java.lang.Object get() {
                    return com.oplus.statistics.c_renamed.b_renamed.b_renamed();
                }
            });
            return false;
        }
        android.content.ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
        if (contentProviderClientAcquireUnstableContentProviderClient == null) {
            com.oplus.statistics.f_renamed.d_renamed.d_renamed("ContentProviderRecorder", new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.c_renamed.-$$Lambda$b_renamed$MS_s9q4EDvKpOcUUpkv7IU16jQ8
                @Override // com.oplus.statistics.f_renamed.e_renamed
                public final java.lang.Object get() {
                    return com.oplus.statistics.c_renamed.b_renamed.a_renamed();
                }
            });
            return false;
        }
        try {
            try {
                contentProviderClientAcquireUnstableContentProviderClient.insert(uri, contentValues);
                contentProviderClientAcquireUnstableContentProviderClient.close();
                return true;
            } catch (android.os.RemoteException | java.lang.IllegalArgumentException | java.lang.IllegalStateException e_renamed) {
                com.oplus.statistics.f_renamed.d_renamed.a_renamed("ContentProviderRecorder", new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.c_renamed.-$$Lambda$b_renamed$FTe1WuZHlwAEHmkxS3JqC2dbkJI
                    @Override // com.oplus.statistics.f_renamed.e_renamed
                    public final java.lang.Object get() {
                        return com.oplus.statistics.c_renamed.b_renamed.a_renamed(e_renamed);
                    }
                });
                contentProviderClientAcquireUnstableContentProviderClient.close();
                return false;
            }
        } catch (java.lang.Throwable th) {
            contentProviderClientAcquireUnstableContentProviderClient.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ java.lang.String a_renamed(java.lang.Exception exc) {
        return "insert exception:" + exc;
    }
}
