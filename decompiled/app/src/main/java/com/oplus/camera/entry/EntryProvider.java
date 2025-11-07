package com.oplus.camera.entry;

/* loaded from: classes2.dex */
public class EntryProvider extends android.content.ContentProvider implements com.oplus.camera.d_renamed {
    com.oplus.camera.entry.c_renamed g_renamed = null;

    @Override // android.content.ContentProvider
    public int delete(android.net.Uri uri, java.lang.String str, java.lang.String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public java.lang.String getType(android.net.Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public android.net.Uri insert(android.net.Uri uri, android.content.ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public int update(android.net.Uri uri, android.content.ContentValues contentValues, java.lang.String str, java.lang.String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public android.database.Cursor query(android.net.Uri uri, java.lang.String[] strArr, java.lang.String str, java.lang.String[] strArr2, java.lang.String str2) {
        if (this.g_renamed == null) {
            this.g_renamed = new com.oplus.camera.entry.c_renamed();
            ((com.oplus.camera.MyApplication) getContext().getApplicationContext()).i_renamed();
            this.g_renamed.a_renamed();
            this.g_renamed.b_renamed();
            this.g_renamed.c_renamed();
            this.g_renamed.d_renamed();
            this.g_renamed.e_renamed();
        }
        java.lang.String path = uri.getPath();
        com.oplus.camera.e_renamed.f_renamed("EntryProvider", "query, uri path: " + path);
        if (path == null || !path.contains(com.oplus.camera.statistics.model.PreviewStaticInfoMsgData.EVENT_STATIC_INFO)) {
            return null;
        }
        return this.g_renamed;
    }
}
