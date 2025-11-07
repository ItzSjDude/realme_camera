package com.oplus.camera.util.storage;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import androidx.core.p027a.FileProvider;
import com.oplus.camera.CameraLog;
import com.oplus.camera.Storage;
import com.oplus.camera.util.Util;
import java.io.File;

/* loaded from: classes2.dex */
public class SandBoxContentProvider extends ContentProvider {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String f23106a = Util.m24327aP();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static UriMatcher f23107b = new UriMatcher(-1);

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    static {
        f23107b.addURI("com.oplus.camera.gallery.cache.provider", "/wallpaper/cache/*", 1);
        f23107b.addURI("com.oplus.camera.gallery.cache.provider", "/wallpaper/locked/*", 2);
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        CameraLog.m12954a("SandBoxContentProvider", "getType, uri: " + uri.toString());
        int iMatch = f23107b.match(uri);
        if (iMatch == 1) {
            String lastPathSegment = uri.getLastPathSegment();
            Uri uriM24646a = m24646a(f23106a, Storage.m11124b() + File.separator + lastPathSegment);
            if (uriM24646a != null) {
                return uriM24646a.toString();
            }
            return null;
        }
        if (iMatch != 2) {
            return null;
        }
        String lastPathSegment2 = uri.getLastPathSegment();
        Uri uriM24646a2 = m24646a(f23106a, getContext().getExternalCacheDir().getPath() + File.separator + lastPathSegment2 + ".cshot");
        if (uriM24646a2 != null) {
            return uriM24646a2.toString();
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Uri m24646a(String str, String str2) {
        if (!new File(str2).exists()) {
            return null;
        }
        Uri uriM2326a = FileProvider.m2326a(getContext(), "com.oplus.camera.gallery.cache.fileprovider", new File(str2));
        m24648a(getContext(), str, uriM2326a);
        return uriM2326a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m24648a(Context context, String str, Uri uri) {
        context.grantUriPermission(str, uri, 3);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m24647a(Context context) {
        Uri uriM2326a = FileProvider.m2326a(context, "com.oplus.camera.gallery.cache.fileprovider", new File(Util.m24172E(context).getPath()));
        Uri uriM2326a2 = FileProvider.m2326a(context, "com.oplus.camera.gallery.cache.fileprovider", new File(Storage.m11124b()));
        context.revokeUriPermission(f23106a, uriM2326a, 3);
        context.revokeUriPermission(f23106a, uriM2326a2, 3);
    }
}
