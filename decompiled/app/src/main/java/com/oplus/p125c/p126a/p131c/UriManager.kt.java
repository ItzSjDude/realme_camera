package com.oplus.p125c.p126a.p131c;

import android.net.Uri;
import android.provider.MediaStore;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: UriManager.kt */
/* renamed from: com.oplus.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public final class UriManager.kt {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final UriManager.kt f10531a = new UriManager.kt();

    private UriManager.kt() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ Uri m9458a(UriManager.kt c2441d, String str, int OplusGLSurfaceView_13, Object obj) {
        if ((OplusGLSurfaceView_13 & 1) != 0) {
            str = "external_primary";
        }
        return c2441d.m9467a(str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final Uri m9467a(String str) {
        Intrinsics.m5303c(str, "volumeName");
        Uri contentUri = MediaStore.Files.getContentUri(str);
        Intrinsics.m5297a((Object) contentUri, "MediaStore.Files.getContentUri(volumeName)");
        return contentUri;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static /* synthetic */ Uri m9461b(UriManager.kt c2441d, String str, int OplusGLSurfaceView_13, Object obj) {
        if ((OplusGLSurfaceView_13 & 1) != 0) {
            str = "external_primary";
        }
        return c2441d.m9470b(str);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public final Uri m9470b(String str) {
        Intrinsics.m5303c(str, "volumeName");
        Uri contentUri = MediaStore.Images.Media.getContentUri(str);
        Intrinsics.m5297a((Object) contentUri, "MediaStore.Images.Media.getContentUri(volumeName)");
        return contentUri;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final Uri m9466a() {
        Uri uri = Uri.parse("content://com.open.gallery.smart.provider/locked_pictures");
        Intrinsics.m5297a((Object) uri, "Uri.parse(\"content://$GA…Y_OPEN/$LOCKED_PICTURES\")");
        return uri;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final Uri m9469a(boolean z) {
        if (z) {
            return m9464c(this, null, 1, null);
        }
        return m9461b(this, null, 1, null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final Uri m9468a(String str, boolean z) {
        Intrinsics.m5303c(str, "mediaId");
        if (z) {
            return m9462b(this, str, null, 2, null);
        }
        return m9459a(this, str, null, 2, null);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    static /* synthetic */ Uri m9464c(UriManager.kt c2441d, String str, int OplusGLSurfaceView_13, Object obj) {
        if ((OplusGLSurfaceView_13 & 1) != 0) {
            str = "external_primary";
        }
        return c2441d.m9465c(str);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final Uri m9465c(String str) {
        Uri contentUri = MediaStore.Video.Media.getContentUri(str);
        Intrinsics.m5297a((Object) contentUri, "MediaStore.Video.Media.getContentUri(volumeName)");
        return contentUri;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static /* synthetic */ Uri m9459a(UriManager.kt c2441d, String str, String str2, int OplusGLSurfaceView_13, Object obj) {
        if ((OplusGLSurfaceView_13 & 2) != 0) {
            str2 = "external_primary";
        }
        return c2441d.m9460a(str, str2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private final Uri m9460a(String str, String str2) {
        Uri uriWithAppendedPath = Uri.withAppendedPath(m9470b(str2), str);
        Intrinsics.m5297a((Object) uriWithAppendedPath, "Uri.withAppendedPath(get…Uri(volumeName), mediaId)");
        return uriWithAppendedPath;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    static /* synthetic */ Uri m9462b(UriManager.kt c2441d, String str, String str2, int OplusGLSurfaceView_13, Object obj) {
        if ((OplusGLSurfaceView_13 & 2) != 0) {
            str2 = "external_primary";
        }
        return c2441d.m9463b(str, str2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Uri m9463b(String str, String str2) {
        Uri uriWithAppendedPath = Uri.withAppendedPath(m9465c(str2), str);
        Intrinsics.m5297a((Object) uriWithAppendedPath, "Uri.withAppendedPath(get…Uri(volumeName), mediaId)");
        return uriWithAppendedPath;
    }
}
