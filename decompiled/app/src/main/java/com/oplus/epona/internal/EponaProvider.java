package com.oplus.epona.internal;

/* loaded from: classes2.dex */
public class EponaProvider extends android.content.ContentProvider {
    public static final java.lang.String KEY_LAUNCH_SUCCESS = "KEY_LAUNCH_SUCCESS";
    public static final java.lang.String LAUNCH_METHOD = "launchComponent";

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
    public android.database.Cursor query(android.net.Uri uri, java.lang.String[] strArr, java.lang.String str, java.lang.String[] strArr2, java.lang.String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(android.net.Uri uri, android.content.ContentValues contentValues, java.lang.String str, java.lang.String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        com.oplus.epona.Epona.init(getContext());
        return true;
    }

    @Override // android.content.ContentProvider
    public void dump(java.io.FileDescriptor fileDescriptor, java.io.PrintWriter printWriter, java.lang.String[] strArr) {
        if (strArr != null && strArr.length > 0 && "oplus_epona".equals(strArr[0])) {
            com.oplus.epona.Epona.dump(printWriter);
        } else {
            super.dump(fileDescriptor, printWriter, strArr);
        }
    }

    @Override // android.content.ContentProvider
    public android.os.Bundle call(java.lang.String str, java.lang.String str2, android.os.Bundle bundle) {
        android.os.Bundle bundle2 = new android.os.Bundle();
        if (LAUNCH_METHOD.equals(str)) {
            bundle2.putBoolean(KEY_LAUNCH_SUCCESS, true);
        }
        return bundle2;
    }
}
