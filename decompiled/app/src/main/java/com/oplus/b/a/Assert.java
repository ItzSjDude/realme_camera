package com.oplus.b_renamed.a_renamed;

/* compiled from: AppFeatureCache.java */
/* loaded from: classes2.dex */
public class a_renamed {

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final java.util.ArrayList<com.oplus.b_renamed.a_renamed.a_renamed.b_renamed> f3723c = new java.util.ArrayList<>();
    private static final android.net.Uri d_renamed = android.net.Uri.parse("content://com.oplus.customize.coreapp.configmanager.configprovider.AppFeatureProvider").buildUpon().appendPath("app_feature").build();

    /* renamed from: a_renamed, reason: collision with root package name */
    public static boolean f3721a = false;

    /* renamed from: b_renamed, reason: collision with root package name */
    public static com.oplus.b_renamed.a_renamed.a_renamed.c_renamed f3722b = com.oplus.b_renamed.a_renamed.a_renamed.c_renamed.CACHE_INVAILD;

    /* compiled from: AppFeatureCache.java */
    /* renamed from: com.oplus.b_renamed.a_renamed.a_renamed$a_renamed, reason: collision with other inner class name */
    private static class AppFeatureCache_2 {

        /* renamed from: a_renamed, reason: collision with root package name */
        static final com.oplus.b_renamed.a_renamed.a_renamed f3724a = new com.oplus.b_renamed.a_renamed.a_renamed();
    }

    /* compiled from: AppFeatureCache.java */
    public enum c_renamed {
        CACHE_ONLY,
        CACHE_AND_DB,
        CACHE_INVAILD
    }

    public static com.oplus.b_renamed.a_renamed.a_renamed a_renamed() {
        return com.oplus.b_renamed.a_renamed.a_renamed.AppFeatureCache_2.f3724a;
    }

    public android.database.Cursor a_renamed(java.lang.String str) {
        if (!f3721a) {
            return null;
        }
        java.util.ArrayList<com.oplus.b_renamed.a_renamed.a_renamed.b_renamed> arrayList = f3723c;
        if (arrayList == null || arrayList.size() != 0) {
            return b_renamed(str);
        }
        return null;
    }

    private android.database.Cursor b_renamed(java.lang.String str) {
        android.database.MatrixCursor matrixCursorB = b_renamed();
        synchronized (com.oplus.b_renamed.a_renamed.a_renamed.class) {
            java.util.Iterator<com.oplus.b_renamed.a_renamed.a_renamed.b_renamed> it = f3723c.iterator();
            while (it.hasNext()) {
                com.oplus.b_renamed.a_renamed.a_renamed.b_renamed next = it.next();
                if (matrixCursorB != null && next != null && next.a_renamed() != null && next.a_renamed().equals(str)) {
                    matrixCursorB.addRow(new java.lang.Object[]{next.d_renamed(), next.a_renamed(), next.b_renamed(), next.c_renamed()});
                }
            }
        }
        if (matrixCursorB == null || matrixCursorB.getCount() != 0) {
            return matrixCursorB;
        }
        matrixCursorB.close();
        return null;
    }

    private android.database.MatrixCursor b_renamed() {
        return new android.database.MatrixCursor(new java.lang.String[]{"_id", "featurename", "parameters", "lists"});
    }

    /* compiled from: AppFeatureCache.java */
    public static class b_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private java.lang.Integer f3725a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private java.lang.String f3726b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private java.lang.String f3727c;
        private java.lang.String d_renamed;

        public java.lang.String a_renamed() {
            return this.f3726b;
        }

        public java.lang.String b_renamed() {
            return this.f3727c;
        }

        public java.lang.String c_renamed() {
            return this.d_renamed;
        }

        public java.lang.Integer d_renamed() {
            return this.f3725a;
        }

        public java.lang.String toString() {
            return "AppFeatureData{_id='" + this.f3725a + "'featureName='" + this.f3726b + "', parameters='" + this.f3727c + "', jasonStr='" + this.d_renamed + "'}";
        }
    }
}
