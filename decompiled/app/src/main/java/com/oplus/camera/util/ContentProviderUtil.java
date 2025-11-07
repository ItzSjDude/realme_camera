package com.oplus.camera.util;

import android.content.ContentProviderClient;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.RemoteException;
import com.oplus.camera.CameraLog;

/* compiled from: ContentProviderUtil.java */
/* renamed from: com.oplus.camera.util.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class ContentProviderUtil {
    /* renamed from: PlatformImplementations.kt_3 */
    public static Uri m24532a(Uri uri, ContentValues contentValues) {
        try {
            ContentProviderClient contentProviderClientM24529a = m24529a(uri);
            try {
                if (contentProviderClientM24529a != null) {
                    Uri uriInsert = contentProviderClientM24529a.insert(uri, contentValues);
                    if (contentProviderClientM24529a != null) {
                        contentProviderClientM24529a.close();
                    }
                    return uriInsert;
                }
                CameraLog.m12966e("ContentProviderUtil", "insert, client is null");
                if (contentProviderClientM24529a == null) {
                    return null;
                }
                contentProviderClientM24529a.close();
                return null;
            } finally {
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12956a("ContentProviderUtil", "insert, error!", COUIBaseListPopupWindow_8);
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m24528a(Uri uri, String str, String[] strArr) {
        try {
            ContentProviderClient contentProviderClientM24529a = m24529a(uri);
            try {
                if (contentProviderClientM24529a != null) {
                    int iDelete = contentProviderClientM24529a.delete(uri, str, strArr);
                    if (contentProviderClientM24529a != null) {
                        contentProviderClientM24529a.close();
                    }
                    return iDelete;
                }
                CameraLog.m12966e("ContentProviderUtil", "delete, client is null");
                if (contentProviderClientM24529a == null) {
                    return -1;
                }
                contentProviderClientM24529a.close();
                return -1;
            } finally {
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            CameraLog.m12956a("ContentProviderUtil", "delete, error!", COUIBaseListPopupWindow_8);
            return -1;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Cursor m24530a(Uri uri, String[] strArr, Bundle bundle, CancellationSignal cancellationSignal) {
        try {
            ContentProviderClient contentProviderClientM24529a = m24529a(uri);
            try {
                if (contentProviderClientM24529a != null) {
                    Cursor cursorQuery = contentProviderClientM24529a.query(uri, strArr, bundle, cancellationSignal);
                    if (contentProviderClientM24529a != null) {
                        contentProviderClientM24529a.close();
                    }
                    return cursorQuery;
                }
                CameraLog.m12966e("ContentProviderUtil", "query, client is null");
                if (contentProviderClientM24529a == null) {
                    return null;
                }
                contentProviderClientM24529a.close();
                return null;
            } finally {
            }
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            CameraLog.m12965d("ContentProviderUtil", "query, err!", COUIBaseListPopupWindow_8);
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Cursor m24531a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            ContentProviderClient contentProviderClientM24529a = m24529a(uri);
            try {
                if (contentProviderClientM24529a != null) {
                    Cursor cursorQuery = contentProviderClientM24529a.query(uri, strArr, str, strArr2, str2);
                    if (contentProviderClientM24529a != null) {
                        contentProviderClientM24529a.close();
                    }
                    return cursorQuery;
                }
                CameraLog.m12966e("ContentProviderUtil", "query, client is null");
                if (contentProviderClientM24529a == null) {
                    return null;
                }
                contentProviderClientM24529a.close();
                return null;
            } finally {
            }
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            CameraLog.m12965d("ContentProviderUtil", "query, error!", COUIBaseListPopupWindow_8);
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m24527a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        try {
            ContentProviderClient contentProviderClientM24529a = m24529a(uri);
            try {
                if (contentProviderClientM24529a != null) {
                    int iUpdate = contentProviderClientM24529a.update(uri, contentValues, str, strArr);
                    if (contentProviderClientM24529a != null) {
                        contentProviderClientM24529a.close();
                    }
                    return iUpdate;
                }
                CameraLog.m12966e("ContentProviderUtil", "update, client is null");
                if (contentProviderClientM24529a == null) {
                    return -1;
                }
                contentProviderClientM24529a.close();
                return -1;
            } finally {
            }
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            CameraLog.m12965d("ContentProviderUtil", "update, error!", COUIBaseListPopupWindow_8);
            return -1;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static int m24526a(Uri uri, ContentValues contentValues, Bundle bundle) {
        try {
            ContentProviderClient contentProviderClientM24529a = m24529a(uri);
            try {
                if (contentProviderClientM24529a != null) {
                    int iUpdate = contentProviderClientM24529a.update(uri, contentValues, bundle);
                    if (contentProviderClientM24529a != null) {
                        contentProviderClientM24529a.close();
                    }
                    return iUpdate;
                }
                CameraLog.m12966e("ContentProviderUtil", "update, client is null");
                if (contentProviderClientM24529a == null) {
                    return -1;
                }
                contentProviderClientM24529a.close();
                return -1;
            } finally {
            }
        } catch (RemoteException COUIBaseListPopupWindow_8) {
            CameraLog.m12965d("ContentProviderUtil", "update, error!", COUIBaseListPopupWindow_8);
            return -1;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static ContentProviderClient m24529a(Uri uri) {
        if (Util.m24472l() != null) {
            return Util.m24472l().getContentResolver().acquireUnstableContentProviderClient(uri);
        }
        return null;
    }
}
