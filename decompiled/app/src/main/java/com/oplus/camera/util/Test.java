package com.oplus.camera.util;

/* compiled from: ContentProviderUtil.java */
/* loaded from: classes2.dex */
public class d_renamed {
    public static android.net.Uri a_renamed(android.net.Uri uri, android.content.ContentValues contentValues) {
        try {
            android.content.ContentProviderClient contentProviderClientA = a_renamed(uri);
            try {
                if (contentProviderClientA != null) {
                    android.net.Uri uriInsert = contentProviderClientA.insert(uri, contentValues);
                    if (contentProviderClientA != null) {
                        contentProviderClientA.close();
                    }
                    return uriInsert;
                }
                com.oplus.camera.e_renamed.e_renamed("ContentProviderUtil", "insert, client is_renamed null");
                if (contentProviderClientA == null) {
                    return null;
                }
                contentProviderClientA.close();
                return null;
            } finally {
            }
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.a_renamed("ContentProviderUtil", "insert, error!", e_renamed);
            return null;
        }
    }

    public static int a_renamed(android.net.Uri uri, java.lang.String str, java.lang.String[] strArr) {
        try {
            android.content.ContentProviderClient contentProviderClientA = a_renamed(uri);
            try {
                if (contentProviderClientA != null) {
                    int iDelete = contentProviderClientA.delete(uri, str, strArr);
                    if (contentProviderClientA != null) {
                        contentProviderClientA.close();
                    }
                    return iDelete;
                }
                com.oplus.camera.e_renamed.e_renamed("ContentProviderUtil", "delete, client is_renamed null");
                if (contentProviderClientA == null) {
                    return -1;
                }
                contentProviderClientA.close();
                return -1;
            } finally {
            }
        } catch (java.lang.Exception e_renamed) {
            com.oplus.camera.e_renamed.a_renamed("ContentProviderUtil", "delete, error!", e_renamed);
            return -1;
        }
    }

    public static android.database.Cursor a_renamed(android.net.Uri uri, java.lang.String[] strArr, android.os.Bundle bundle, android.os.CancellationSignal cancellationSignal) {
        try {
            android.content.ContentProviderClient contentProviderClientA = a_renamed(uri);
            try {
                if (contentProviderClientA != null) {
                    android.database.Cursor cursorQuery = contentProviderClientA.query(uri, strArr, bundle, cancellationSignal);
                    if (contentProviderClientA != null) {
                        contentProviderClientA.close();
                    }
                    return cursorQuery;
                }
                com.oplus.camera.e_renamed.e_renamed("ContentProviderUtil", "query, client is_renamed null");
                if (contentProviderClientA == null) {
                    return null;
                }
                contentProviderClientA.close();
                return null;
            } finally {
            }
        } catch (android.os.RemoteException e_renamed) {
            com.oplus.camera.e_renamed.d_renamed("ContentProviderUtil", "query, err!", e_renamed);
            return null;
        }
    }

    public static android.database.Cursor a_renamed(android.net.Uri uri, java.lang.String[] strArr, java.lang.String str, java.lang.String[] strArr2, java.lang.String str2) {
        try {
            android.content.ContentProviderClient contentProviderClientA = a_renamed(uri);
            try {
                if (contentProviderClientA != null) {
                    android.database.Cursor cursorQuery = contentProviderClientA.query(uri, strArr, str, strArr2, str2);
                    if (contentProviderClientA != null) {
                        contentProviderClientA.close();
                    }
                    return cursorQuery;
                }
                com.oplus.camera.e_renamed.e_renamed("ContentProviderUtil", "query, client is_renamed null");
                if (contentProviderClientA == null) {
                    return null;
                }
                contentProviderClientA.close();
                return null;
            } finally {
            }
        } catch (android.os.RemoteException e_renamed) {
            com.oplus.camera.e_renamed.d_renamed("ContentProviderUtil", "query, error!", e_renamed);
            return null;
        }
    }

    public static int a_renamed(android.net.Uri uri, android.content.ContentValues contentValues, java.lang.String str, java.lang.String[] strArr) {
        try {
            android.content.ContentProviderClient contentProviderClientA = a_renamed(uri);
            try {
                if (contentProviderClientA != null) {
                    int iUpdate = contentProviderClientA.update(uri, contentValues, str, strArr);
                    if (contentProviderClientA != null) {
                        contentProviderClientA.close();
                    }
                    return iUpdate;
                }
                com.oplus.camera.e_renamed.e_renamed("ContentProviderUtil", "update, client is_renamed null");
                if (contentProviderClientA == null) {
                    return -1;
                }
                contentProviderClientA.close();
                return -1;
            } finally {
            }
        } catch (android.os.RemoteException e_renamed) {
            com.oplus.camera.e_renamed.d_renamed("ContentProviderUtil", "update, error!", e_renamed);
            return -1;
        }
    }

    public static int a_renamed(android.net.Uri uri, android.content.ContentValues contentValues, android.os.Bundle bundle) {
        try {
            android.content.ContentProviderClient contentProviderClientA = a_renamed(uri);
            try {
                if (contentProviderClientA != null) {
                    int iUpdate = contentProviderClientA.update(uri, contentValues, bundle);
                    if (contentProviderClientA != null) {
                        contentProviderClientA.close();
                    }
                    return iUpdate;
                }
                com.oplus.camera.e_renamed.e_renamed("ContentProviderUtil", "update, client is_renamed null");
                if (contentProviderClientA == null) {
                    return -1;
                }
                contentProviderClientA.close();
                return -1;
            } finally {
            }
        } catch (android.os.RemoteException e_renamed) {
            com.oplus.camera.e_renamed.d_renamed("ContentProviderUtil", "update, error!", e_renamed);
            return -1;
        }
    }

    private static android.content.ContentProviderClient a_renamed(android.net.Uri uri) {
        if (com.oplus.camera.util.Util.l_renamed() != null) {
            return com.oplus.camera.util.Util.l_renamed().getContentResolver().acquireUnstableContentProviderClient(uri);
        }
        return null;
    }
}
