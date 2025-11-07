package com.oplus.c_renamed.a_renamed.c_renamed;

/* compiled from: LockedPicturesDataManager.kt */
/* loaded from: classes2.dex */
public final class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final com.oplus.c_renamed.a_renamed.c_renamed.a_renamed f3759a = new com.oplus.c_renamed.a_renamed.c_renamed.a_renamed();

    private a_renamed() {
    }

    public final java.util.List<com.oplus.c_renamed.a_renamed.b_renamed.a_renamed> a_renamed(android.content.Context context, int i_renamed) {
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(context, "context");
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        java.util.ArrayList<java.lang.String> arrayListA = a_renamed(context);
        java.util.ArrayList<java.lang.String> arrayList = arrayListA;
        if (arrayList == null || arrayList.isEmpty()) {
            com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("LockedPicturesDataHelper", "getLockMediaItemList list.isNullOrEmpty()");
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("(");
        java.util.Iterator<T_renamed> it = arrayListA.iterator();
        while (it.hasNext()) {
            sb.append((java.lang.String) it.next());
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        java.lang.String string = sb.toString();
        c_renamed.f_renamed.b_renamed.h_renamed.a_renamed((java.lang.Object) string, "idInList.toString()");
        java.util.ArrayList<com.oplus.c_renamed.a_renamed.b_renamed.a_renamed> arrayListA2 = com.oplus.c_renamed.a_renamed.c_renamed.b_renamed.f3760a.a_renamed(context, a_renamed(context, string, i_renamed));
        com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("LockedPicturesDataHelper", "getMediaItemList cost time " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
        return arrayListA2;
    }

    public final boolean a_renamed(android.content.Context context, com.oplus.c_renamed.a_renamed.b_renamed.a_renamed aVar) {
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(context, "context");
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(aVar, "mediaItem");
        context.getContentResolver().delete(com.oplus.c_renamed.a_renamed.c_renamed.d_renamed.f3765a.a_renamed(), "media_id  = ? ", new java.lang.String[]{aVar.e_renamed()});
        return com.oplus.c_renamed.a_renamed.c_renamed.b_renamed.f3760a.a_renamed(context, aVar);
    }

    private final android.os.Bundle a_renamed(android.content.Context context, java.lang.String str, int i_renamed) {
        android.os.Bundle bundle = new android.os.Bundle();
        java.lang.String str2 = "_id IN_renamed " + str + " AND media_type IN_renamed (1,3)";
        com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("LockedPicturesDataHelper", "selection = " + str2);
        bundle.putString("android:query-arg-sql-selection", str2);
        bundle.putString("android:query-arg-sql-sort-order", "datetaken DESC, _id DESC");
        bundle.putString("android:query-arg-sql-limit", "0," + i_renamed);
        return bundle;
    }

    private final java.util.ArrayList<java.lang.String> a_renamed(android.content.Context context) {
        long jCurrentTimeMillis;
        android.database.Cursor cursor;
        try {
            jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            android.database.Cursor cursorQuery = context.getContentResolver().query(com.oplus.c_renamed.a_renamed.c_renamed.d_renamed.f3765a.a_renamed(), com.oplus.c_renamed.a_renamed.c_renamed.c_renamed.ProjectManager.kt_5.f3764a.a_renamed(), null, null, null);
            java.lang.Throwable th = (java.lang.Throwable) null;
            try {
                try {
                    cursor = cursorQuery;
                } finally {
                }
            } finally {
                c_renamed.e_renamed.a_renamed.a_renamed(cursorQuery, th);
            }
        } catch (java.lang.Exception e_renamed) {
            com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.c_renamed("LockedPicturesDataHelper", "getLockedPicturesIds", e_renamed);
        }
        if (cursor == null) {
            return null;
        }
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList<>();
        while (cursor.moveToNext()) {
            arrayList.add(cursor.getString(0));
        }
        com.oplus.c_renamed.a_renamed.e_renamed.a_renamed.a_renamed("LockedPicturesDataHelper", "getLockedPicturesIds cost time = " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
        return arrayList;
    }
}
