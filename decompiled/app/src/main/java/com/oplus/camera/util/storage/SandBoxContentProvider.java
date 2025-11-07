package com.oplus.camera.util.storage;

/* loaded from: classes2.dex */
public class SandBoxContentProvider extends android.content.ContentProvider {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.String f7368a = com.oplus.camera.util.Util.aP_renamed();

    /* renamed from: b_renamed, reason: collision with root package name */
    private static android.content.UriMatcher f7369b = new android.content.UriMatcher(-1);

    @Override // android.content.ContentProvider
    public int delete(android.net.Uri uri, java.lang.String str, java.lang.String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public android.net.Uri insert(android.net.Uri uri, android.content.ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    public android.database.Cursor query(android.net.Uri uri, java.lang.String[] strArr, java.lang.String str, java.lang.String[] strArr2, java.lang.String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(android.net.Uri uri, android.content.ContentValues contentValues, java.lang.String str, java.lang.String[] strArr) {
        return 0;
    }

    static {
        f7369b.addURI("com.oplus.camera.gallery.cache.provider", "/wallpaper/cache/*", 1);
        f7369b.addURI("com.oplus.camera.gallery.cache.provider", "/wallpaper/locked/*", 2);
    }

    @Override // android.content.ContentProvider
    public java.lang.String getType(android.net.Uri uri) {
        com.oplus.camera.e_renamed.a_renamed("SandBoxContentProvider", "getType, uri: " + uri.toString());
        int iMatch = f7369b.match(uri);
        if (iMatch == 1) {
            java.lang.String lastPathSegment = uri.getLastPathSegment();
            android.net.Uri uriA = a_renamed(f7368a, com.oplus.camera.Storage.b_renamed() + java.io.File.separator + lastPathSegment);
            if (uriA != null) {
                return uriA.toString();
            }
            return null;
        }
        if (iMatch != 2) {
            return null;
        }
        java.lang.String lastPathSegment2 = uri.getLastPathSegment();
        android.net.Uri uriA2 = a_renamed(f7368a, getContext().getExternalCacheDir().getPath() + java.io.File.separator + lastPathSegment2 + ".cshot");
        if (uriA2 != null) {
            return uriA2.toString();
        }
        return null;
    }

    private android.net.Uri a_renamed(java.lang.String str, java.lang.String str2) {
        if (!new java.io.File(str2).exists()) {
            return null;
        }
        android.net.Uri uriA = androidx.core.a_renamed.b_renamed.a_renamed(getContext(), "com.oplus.camera.gallery.cache.fileprovider", new java.io.File(str2));
        a_renamed(getContext(), str, uriA);
        return uriA;
    }

    private void a_renamed(android.content.Context context, java.lang.String str, android.net.Uri uri) {
        context.grantUriPermission(str, uri, 3);
    }

    public static void a_renamed(android.content.Context context) {
        android.net.Uri uriA = androidx.core.a_renamed.b_renamed.a_renamed(context, "com.oplus.camera.gallery.cache.fileprovider", new java.io.File(com.oplus.camera.util.Util.E_renamed(context).getPath()));
        android.net.Uri uriA2 = androidx.core.a_renamed.b_renamed.a_renamed(context, "com.oplus.camera.gallery.cache.fileprovider", new java.io.File(com.oplus.camera.Storage.b_renamed()));
        context.revokeUriPermission(f7368a, uriA, 3);
        context.revokeUriPermission(f7368a, uriA2, 3);
    }
}
