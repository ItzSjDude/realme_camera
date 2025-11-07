package com.oplus.c_renamed.a_renamed.c_renamed;

/* compiled from: MediaStoreDataManager.kt */
/* loaded from: classes2.dex */
public final class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final com.oplus.c_renamed.a_renamed.c_renamed.b_renamed f3760a = new com.oplus.c_renamed.a_renamed.c_renamed.b_renamed();

    private b_renamed() {
    }

    public final java.util.ArrayList<com.oplus.c_renamed.a_renamed.b_renamed.a_renamed> a_renamed(android.content.Context context, int i_renamed) {
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(context, "context");
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        java.util.ArrayList<com.oplus.c_renamed.a_renamed.b_renamed.a_renamed> arrayListA = a_renamed(context, b_renamed(context, i_renamed));
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("getCameraMediaItemList size = ");
        sb.append(arrayListA != null ? java.lang.Integer.valueOf(arrayListA.size()) : null);
        sb.append(" , time = ");
        sb.append(java.lang.System.currentTimeMillis() - jCurrentTimeMillis);
        com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("MediaStoreDataHelper", sb.toString());
        return arrayListA;
    }

    public final java.util.ArrayList<com.oplus.c_renamed.a_renamed.b_renamed.a_renamed> a_renamed(android.content.Context context, android.os.Bundle bundle) {
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(context, "context");
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(bundle, "bundle");
        try {
            com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("MediaStoreDataHelper", "getCameraMediaItemList bundle = " + bundle + '}');
            android.database.Cursor cursorQuery = context.getContentResolver().query(com.oplus.c_renamed.a_renamed.c_renamed.d_renamed.a_renamed(com.oplus.c_renamed.a_renamed.c_renamed.d_renamed.f3765a, null, 1, null), com.oplus.c_renamed.a_renamed.c_renamed.c_renamed.b_renamed.f3763a.a_renamed(), bundle, null);
            java.lang.Throwable th = (java.lang.Throwable) null;
            try {
                java.util.ArrayList<com.oplus.c_renamed.a_renamed.b_renamed.a_renamed> arrayListA = f3760a.a_renamed(cursorQuery);
                if (arrayListA != null) {
                    c_renamed.a_renamed.h_renamed.b_renamed((java.util.List) arrayListA);
                }
                return arrayListA;
            } finally {
                c_renamed.e_renamed.a_renamed.a_renamed(cursorQuery, th);
            }
        } catch (java.lang.Exception e_renamed) {
            com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("MediaStoreDataHelper", "getCameraMediaItemList", e_renamed);
            return null;
        }
    }

    public final boolean a_renamed(android.content.Context context, com.oplus.c_renamed.a_renamed.b_renamed.a_renamed aVar) throws android.content.IntentSender.SendIntentException {
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(context, "context");
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(aVar, "mediaItem");
        try {
            try {
                if (aVar.k_renamed()) {
                    return f3760a.b_renamed(context, aVar);
                }
                return context.getContentResolver().delete(aVar.g_renamed(), null, null) >= 1;
            } catch (android.content.IntentSender.SendIntentException e_renamed) {
                com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.c_renamed("MediaStoreDataHelper", "deleteMediaItem run: ", e_renamed);
                return false;
            }
        } catch (android.app.RecoverableSecurityException unused) {
            android.app.PendingIntent pendingIntentCreateDeleteRequest = android.provider.MediaStore.createDeleteRequest(context.getContentResolver(), c_renamed.a_renamed.h_renamed.b_renamed(aVar.g_renamed()));
            c_renamed.f_renamed.b_renamed.h_renamed.a_renamed((java.lang.Object) pendingIntentCreateDeleteRequest, "MediaStore.createDeleteR…rayListOf(mediaItem.uri))");
            ((android.app.Activity) context).startIntentSenderForResult(pendingIntentCreateDeleteRequest.getIntentSender(), 100, null, 0, 0, 0);
            return false;
        } catch (java.lang.SecurityException e2) {
            com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.c_renamed("MediaStoreDataHelper", "deleteMediaItem run: ", e2);
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
    public final com.oplus.c_renamed.a_renamed.b_renamed.a_renamed a_renamed(android.content.Context context, java.lang.String str) {
        android.database.Cursor cursor;
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(context, "context");
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(str, "mediaId");
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        ?? bundle = new android.os.Bundle();
        bundle.putString("android:query-arg-sql-selection", "_id  = " + str);
        try {
            try {
                context = context.getContentResolver().query(com.oplus.c_renamed.a_renamed.c_renamed.d_renamed.a_renamed(com.oplus.c_renamed.a_renamed.c_renamed.d_renamed.f3765a, null, 1, null), com.oplus.c_renamed.a_renamed.c_renamed.c_renamed.b_renamed.f3763a.a_renamed(), bundle, null);
                bundle = (java.lang.Throwable) 0;
                cursor = context;
            } finally {
                c_renamed.e_renamed.a_renamed.a_renamed(context, bundle);
            }
        } catch (java.lang.Exception e_renamed) {
            com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.c_renamed("MediaStoreDataHelper", "getMediaItem", e_renamed);
        }
        if (cursor == null) {
            return null;
        }
        if (cursor.getCount() <= 0) {
            com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("MediaStoreDataHelper", "getMediaItem count <= 0 ");
            return null;
        }
        cursor.moveToFirst();
        com.oplus.c_renamed.a_renamed.c_renamed.b_renamed bVar = f3760a;
        c_renamed.f_renamed.b_renamed.h_renamed.a_renamed((java.lang.Object) cursor, "this");
        com.oplus.c_renamed.a_renamed.b_renamed.a_renamed aVarB = bVar.b_renamed(cursor);
        com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("MediaStoreDataHelper", "getMediaItem cost time = " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
        return aVarB;
    }

    private final boolean b_renamed(android.content.Context context, com.oplus.c_renamed.a_renamed.b_renamed.a_renamed aVar) {
        java.lang.String parent = new java.io.File(aVar.f_renamed()).getParent();
        if (parent == null) {
            return false;
        }
        java.util.Locale locale = java.util.Locale.ROOT;
        c_renamed.f_renamed.b_renamed.h_renamed.a_renamed((java.lang.Object) locale, "Locale.ROOT");
        if (parent == null) {
            throw new java.lang.NullPointerException("null cannot be_renamed cast to non-null type java.lang.String");
        }
        java.lang.String lowerCase = parent.toLowerCase(locale);
        c_renamed.f_renamed.b_renamed.h_renamed.b_renamed(lowerCase, "(this as_renamed java.lang.String).toLowerCase(locale)");
        return context.getContentResolver().delete(com.oplus.c_renamed.a_renamed.c_renamed.d_renamed.f3765a.a_renamed(aVar.j_renamed()), "bucket_id = ? ", new java.lang.String[]{java.lang.String.valueOf(lowerCase.hashCode())}) >= 1;
    }

    private final android.os.Bundle b_renamed(android.content.Context context, int i_renamed) {
        android.os.Bundle bundle = new android.os.Bundle();
        java.util.ArrayList<java.lang.String> arrayListA = f3760a.a_renamed(context);
        if (arrayListA.isEmpty()) {
            bundle.putString("android:query-arg-sql-selection", "relative_path = 'DCIM/Camera/' AND media_type IN_renamed (1,3) ");
            com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("MediaStoreDataHelper", "selection = relative_path = 'DCIM/Camera/' AND media_type IN_renamed (1,3) ");
        } else {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.util.Iterator<java.lang.String> it = arrayListA.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            java.lang.String str = "relative_path = 'DCIM/Camera/' AND media_type IN_renamed (1,3)  OR _id IN_renamed (" + ((java.lang.Object) sb) + ')';
            com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("MediaStoreDataHelper", "selection = " + str);
            bundle.putString("android:query-arg-sql-selection", str);
        }
        bundle.putString("android:query-arg-sql-sort-order", "datetaken DESC, _id DESC");
        bundle.putString("android:query-arg-sql-limit", "0, " + i_renamed);
        return bundle;
    }

    private final java.util.ArrayList<com.oplus.c_renamed.a_renamed.b_renamed.a_renamed> a_renamed(android.database.Cursor cursor) {
        java.util.ArrayList<com.oplus.c_renamed.a_renamed.b_renamed.a_renamed> arrayList = null;
        if (cursor != null) {
            if (cursor.getCount() <= 0) {
                com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("MediaStoreDataHelper", "getItemListFromCursor count is_renamed 0");
                return null;
            }
            arrayList = new java.util.ArrayList<>();
            while (cursor.moveToNext()) {
                arrayList.add(f3760a.b_renamed(cursor));
            }
        }
        return arrayList;
    }

    private final com.oplus.c_renamed.a_renamed.b_renamed.a_renamed b_renamed(android.database.Cursor cursor) {
        java.lang.String string = cursor.getString(0);
        java.lang.String string2 = cursor.getString(1);
        int i_renamed = cursor.getInt(2);
        long j_renamed = cursor.getLong(3);
        int i2 = cursor.getInt(4);
        java.lang.String string3 = cursor.getString(5);
        int i3 = cursor.getInt(6);
        int i4 = cursor.getInt(7);
        java.lang.String string4 = cursor.getString(8);
        boolean z_renamed = i2 == 3;
        c_renamed.f_renamed.b_renamed.h_renamed.a_renamed((java.lang.Object) string, com.google.android.exoplayer2.text.ttml.TtmlNode.ATTR_ID);
        c_renamed.f_renamed.b_renamed.h_renamed.a_renamed((java.lang.Object) string2, com.oplus.ocs.camera.CameraParameter.WaterMarkParamKeys.FILE_PATH);
        com.oplus.c_renamed.a_renamed.b_renamed.a_renamed aVar = new com.oplus.c_renamed.a_renamed.b_renamed.a_renamed(string, string2, com.oplus.c_renamed.a_renamed.c_renamed.d_renamed.f3765a.a_renamed(string, z_renamed), i_renamed, j_renamed, z_renamed, com.oplus.c_renamed.a_renamed.c_renamed.c_renamed.a_renamed.f3761a.a_renamed().matcher(string3).matches());
        aVar.a_renamed(i_renamed);
        aVar.b_renamed(i3);
        aVar.c_renamed(i4);
        c_renamed.f_renamed.b_renamed.h_renamed.a_renamed((java.lang.Object) string4, "mimeType");
        aVar.a_renamed(string4);
        return aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.oplus.c_renamed.a_renamed.c_renamed.b_renamed] */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.io.Closeable] */
    public final java.util.ArrayList<java.lang.String> a_renamed(android.content.Context context) {
        java.lang.Throwable th;
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(context, "context");
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>();
        try {
            try {
                this = context.getContentResolver().query(com.oplus.c_renamed.a_renamed.c_renamed.d_renamed.b_renamed(com.oplus.c_renamed.a_renamed.c_renamed.d_renamed.f3765a, null, 1, null), com.oplus.c_renamed.a_renamed.c_renamed.c_renamed.a_renamed.f3761a.b_renamed(), a_renamed(), null);
                th = (java.lang.Throwable) null;
                android.database.Cursor cursor = this;
                if (cursor != null) {
                    if (cursor.getCount() <= 0) {
                        com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("MediaStoreDataHelper", "getCShotMediaIdList count < = 0");
                        return arrayList;
                    }
                    while (cursor.moveToNext()) {
                        if (com.oplus.c_renamed.a_renamed.c_renamed.c_renamed.a_renamed.f3761a.a_renamed().matcher(cursor.getString(1)).matches()) {
                            arrayList.add(cursor.getString(0));
                        }
                    }
                }
            } finally {
                c_renamed.e_renamed.a_renamed.a_renamed(this, th);
            }
        } catch (java.lang.Exception e_renamed) {
            com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.c_renamed("MediaStoreDataHelper", "getCShotMediaIdList ", e_renamed);
        }
        com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("MediaStoreDataHelper", "getCShotMediaIdList array.size = " + arrayList.size() + ", cost time = " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
        return arrayList;
    }

    private final android.os.Bundle a_renamed() {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("android:query-arg-sql-selection", "relative_path LIKE 'DCIM/Camera/Cshot/%'");
        bundle.putString("android:query-arg-sql-group-by_renamed", "relative_path");
        bundle.putString("android:query-arg-sql-having", "_data =  MIN (_data)");
        return bundle;
    }
}
