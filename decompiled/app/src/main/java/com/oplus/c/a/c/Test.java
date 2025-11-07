package com.oplus.c_renamed.a_renamed.c_renamed;

/* compiled from: UriManager.kt */
/* loaded from: classes2.dex */
public final class d_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final com.oplus.c_renamed.a_renamed.c_renamed.d_renamed f3765a = new com.oplus.c_renamed.a_renamed.c_renamed.d_renamed();

    private d_renamed() {
    }

    public static /* synthetic */ android.net.Uri a_renamed(com.oplus.c_renamed.a_renamed.c_renamed.d_renamed dVar, java.lang.String str, int i_renamed, java.lang.Object obj) {
        if ((i_renamed & 1) != 0) {
            str = "external_primary";
        }
        return dVar.a_renamed(str);
    }

    public final android.net.Uri a_renamed(java.lang.String str) {
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(str, "volumeName");
        android.net.Uri contentUri = android.provider.MediaStore.Files.getContentUri(str);
        c_renamed.f_renamed.b_renamed.h_renamed.a_renamed((java.lang.Object) contentUri, "MediaStore.Files.getContentUri(volumeName)");
        return contentUri;
    }

    public static /* synthetic */ android.net.Uri b_renamed(com.oplus.c_renamed.a_renamed.c_renamed.d_renamed dVar, java.lang.String str, int i_renamed, java.lang.Object obj) {
        if ((i_renamed & 1) != 0) {
            str = "external_primary";
        }
        return dVar.b_renamed(str);
    }

    public final android.net.Uri b_renamed(java.lang.String str) {
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(str, "volumeName");
        android.net.Uri contentUri = android.provider.MediaStore.Images.Media.getContentUri(str);
        c_renamed.f_renamed.b_renamed.h_renamed.a_renamed((java.lang.Object) contentUri, "MediaStore.Images.Media.getContentUri(volumeName)");
        return contentUri;
    }

    public final android.net.Uri a_renamed() {
        android.net.Uri uri = android.net.Uri.parse("content://com.open.gallery.smart.provider/locked_pictures");
        c_renamed.f_renamed.b_renamed.h_renamed.a_renamed((java.lang.Object) uri, "Uri.parse(\"content://$GA…Y_OPEN/$LOCKED_PICTURES\")");
        return uri;
    }

    public final android.net.Uri a_renamed(boolean z_renamed) {
        if (z_renamed) {
            return c_renamed(this, null, 1, null);
        }
        return b_renamed(this, null, 1, null);
    }

    public final android.net.Uri a_renamed(java.lang.String str, boolean z_renamed) {
        c_renamed.f_renamed.b_renamed.h_renamed.c_renamed(str, "mediaId");
        if (z_renamed) {
            return b_renamed(this, str, null, 2, null);
        }
        return a_renamed(this, str, null, 2, null);
    }

    static /* synthetic */ android.net.Uri c_renamed(com.oplus.c_renamed.a_renamed.c_renamed.d_renamed dVar, java.lang.String str, int i_renamed, java.lang.Object obj) {
        if ((i_renamed & 1) != 0) {
            str = "external_primary";
        }
        return dVar.c_renamed(str);
    }

    private final android.net.Uri c_renamed(java.lang.String str) {
        android.net.Uri contentUri = android.provider.MediaStore.Video.Media.getContentUri(str);
        c_renamed.f_renamed.b_renamed.h_renamed.a_renamed((java.lang.Object) contentUri, "MediaStore.Video.Media.getContentUri(volumeName)");
        return contentUri;
    }

    static /* synthetic */ android.net.Uri a_renamed(com.oplus.c_renamed.a_renamed.c_renamed.d_renamed dVar, java.lang.String str, java.lang.String str2, int i_renamed, java.lang.Object obj) {
        if ((i_renamed & 2) != 0) {
            str2 = "external_primary";
        }
        return dVar.a_renamed(str, str2);
    }

    private final android.net.Uri a_renamed(java.lang.String str, java.lang.String str2) {
        android.net.Uri uriWithAppendedPath = android.net.Uri.withAppendedPath(b_renamed(str2), str);
        c_renamed.f_renamed.b_renamed.h_renamed.a_renamed((java.lang.Object) uriWithAppendedPath, "Uri.withAppendedPath(get…Uri(volumeName), mediaId)");
        return uriWithAppendedPath;
    }

    static /* synthetic */ android.net.Uri b_renamed(com.oplus.c_renamed.a_renamed.c_renamed.d_renamed dVar, java.lang.String str, java.lang.String str2, int i_renamed, java.lang.Object obj) {
        if ((i_renamed & 2) != 0) {
            str2 = "external_primary";
        }
        return dVar.b_renamed(str, str2);
    }

    private final android.net.Uri b_renamed(java.lang.String str, java.lang.String str2) {
        android.net.Uri uriWithAppendedPath = android.net.Uri.withAppendedPath(c_renamed(str2), str);
        c_renamed.f_renamed.b_renamed.h_renamed.a_renamed((java.lang.Object) uriWithAppendedPath, "Uri.withAppendedPath(get…Uri(volumeName), mediaId)");
        return uriWithAppendedPath;
    }
}
