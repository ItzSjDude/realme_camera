package com.oplus.camera.q_renamed;

/* compiled from: DocumentUtil.java */
/* loaded from: classes2.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static int f5295a = 101;

    /* renamed from: b_renamed, reason: collision with root package name */
    private static android.net.Uri f5296b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private static android.content.Context f5297c;
    private static com.oplus.camera.q_renamed.a_renamed.DocumentUtil_2 d_renamed;

    /* compiled from: DocumentUtil.java */
    /* renamed from: com.oplus.camera.q_renamed.a_renamed$a_renamed, reason: collision with other inner class name */
    public interface DocumentUtil_2 {
        void a_renamed();

        void b_renamed();
    }

    private static boolean d_renamed() {
        return true;
    }

    private static boolean g_renamed(java.lang.String str) {
        return false;
    }

    private static android.os.storage.StorageVolume c_renamed() {
        java.lang.String path;
        if (f5297c == null) {
            return null;
        }
        android.os.storage.StorageVolume[] volumeList = new android.os.storage.StorageVolume[0];
        try {
            volumeList = com.oplus.compat.os.storage.StorageManagerNative.getVolumeList(com.oplus.compat.os.UserHandleNative.myUserId(), 0);
        } catch (com.oplus.compat.b_renamed.a_renamed.b_renamed e_renamed) {
            e_renamed.printStackTrace();
        }
        if (volumeList == null) {
            return null;
        }
        for (android.os.storage.StorageVolume storageVolume : volumeList) {
            try {
                path = com.oplus.compat.os.storage.StorageVolumeNative.getPath(storageVolume);
            } catch (com.oplus.compat.b_renamed.a_renamed.b_renamed e2) {
                e2.printStackTrace();
                path = null;
            }
            if ("mounted".equalsIgnoreCase(storageVolume.getState()) && path != null && android.os.Environment.isExternalStorageRemovable(new java.io.File(path))) {
                return storageVolume;
            }
        }
        return null;
    }

    public static boolean a_renamed() {
        if (com.oplus.camera.Storage.j_renamed == null) {
            return false;
        }
        return f_renamed(com.oplus.camera.Storage.j_renamed);
    }

    public static void a_renamed(android.content.Context context, com.oplus.camera.q_renamed.a_renamed.DocumentUtil_2 interfaceC0109a) {
        android.os.storage.StorageVolume storageVolumeC;
        android.net.Uri uri;
        f5297c = context.getApplicationContext();
        if (d_renamed() || (storageVolumeC = c_renamed()) == null) {
            return;
        }
        java.lang.String uuid = storageVolumeC.getUuid();
        java.util.Iterator<android.content.UriPermission> it = context.getContentResolver().getPersistedUriPermissions().iterator();
        while (true) {
            if (!it.hasNext()) {
                uri = null;
                break;
            }
            android.content.UriPermission next = it.next();
            if (next.getUri().toString().contains(uuid)) {
                uri = next.getUri();
                break;
            }
        }
        if (uri != null) {
            f5296b = uri;
        } else {
            if (interfaceC0109a == null || !(context instanceof android.app.Activity)) {
                return;
            }
            d_renamed = interfaceC0109a;
            ((android.app.Activity) context).startActivityForResult(storageVolumeC.createAccessIntent(null), f5295a);
        }
    }

    public static void b_renamed() {
        d_renamed.b_renamed();
    }

    public static void a_renamed(android.content.Intent intent) {
        android.content.Context context = f5297c;
        if (context != null) {
            context.getContentResolver().takePersistableUriPermission(intent.getData(), 3);
            f5296b = intent.getData();
            d_renamed.a_renamed();
        }
    }

    private static android.net.Uri h_renamed(java.lang.String str) {
        java.lang.String strReplaceFirst;
        if (!a_renamed() || !g_renamed(str)) {
            return null;
        }
        java.lang.String strSubstring = str.substring(str.indexOf(java.io.File.separator, 1) + 1);
        if (strSubstring.contains(java.io.File.separator)) {
            strReplaceFirst = strSubstring.replaceFirst(java.io.File.separator, ":");
        } else {
            strReplaceFirst = strSubstring + ":";
        }
        return android.provider.DocumentsContract.buildDocumentUriUsingTree(f5296b, strReplaceFirst);
    }

    public static boolean a_renamed(java.lang.String str) {
        return new java.io.File(str).exists();
    }

    public static boolean b_renamed(java.lang.String str) {
        return new java.io.File(str).isDirectory();
    }

    public static boolean c_renamed(java.lang.String str) throws java.io.FileNotFoundException {
        if (!a_renamed(str)) {
            return true;
        }
        if (g_renamed(str)) {
            try {
                android.provider.DocumentsContract.deleteDocument(f5297c.getContentResolver(), h_renamed(str));
                return true;
            } catch (java.io.FileNotFoundException e_renamed) {
                e_renamed.printStackTrace();
                return false;
            }
        }
        return new java.io.File(str).delete();
    }

    public static byte[] d_renamed(java.lang.String str) {
        if (f5297c == null) {
            return null;
        }
        return a_renamed(str, (byte[]) null);
    }

    public static java.io.InputStream e_renamed(java.lang.String str) throws java.io.FileNotFoundException {
        if (g_renamed(str)) {
            return f5297c.getContentResolver().openInputStream(h_renamed(str));
        }
        return new java.io.FileInputStream(str);
    }

    public static byte[] a_renamed(java.lang.String str, byte[] bArr) throws java.io.IOException {
        try {
            java.io.InputStream inputStreamE = e_renamed(str);
            try {
                int iAvailable = inputStreamE.available();
                if (bArr == null || bArr.length < iAvailable) {
                    bArr = new byte[iAvailable];
                }
                if (iAvailable == inputStreamE.read(bArr)) {
                    if (inputStreamE != null) {
                        inputStreamE.close();
                    }
                    return bArr;
                }
                if (inputStreamE != null) {
                    inputStreamE.close();
                }
                return null;
            } finally {
            }
        } catch (java.io.IOException e_renamed) {
            e_renamed.printStackTrace();
            return null;
        }
    }

    public static java.io.OutputStream a_renamed(java.lang.String str, java.lang.String str2) throws java.io.FileNotFoundException {
        if (!c_renamed(str, str2)) {
            return null;
        }
        if (g_renamed(str)) {
            return f5297c.getContentResolver().openOutputStream(h_renamed(str));
        }
        return new java.io.FileOutputStream(str);
    }

    public static boolean f_renamed(java.lang.String str) {
        if (a_renamed(str)) {
            return b_renamed(str);
        }
        if (g_renamed(str)) {
            return i_renamed(str);
        }
        return new java.io.File(str).mkdirs();
    }

    public static boolean b_renamed(java.lang.String str, java.lang.String str2) throws java.io.FileNotFoundException {
        if ((g_renamed(str) && !g_renamed(str2)) || (!g_renamed(str) && g_renamed(str2))) {
            return false;
        }
        if (a_renamed(str2) && !c_renamed(str2)) {
            return false;
        }
        if (g_renamed(str2)) {
            try {
                android.provider.DocumentsContract.renameDocument(f5297c.getContentResolver(), h_renamed(str), new java.io.File(str2).getName());
                return true;
            } catch (java.io.FileNotFoundException e_renamed) {
                e_renamed.printStackTrace();
                return false;
            }
        }
        return new java.io.File(str).renameTo(new java.io.File(str2));
    }

    public static boolean a_renamed(java.lang.String str, java.lang.String str2, byte[] bArr) {
        java.io.File file = new java.io.File(str);
        java.lang.String str3 = file.getParent() + java.io.File.separator + ("temp_" + file.getName());
        if (b_renamed(str3, str2, bArr)) {
            return b_renamed(str3, str);
        }
        return false;
    }

    public static boolean b_renamed(java.lang.String str, java.lang.String str2, byte[] bArr) throws java.io.IOException {
        if (bArr == null) {
            return false;
        }
        try {
            java.io.OutputStream outputStreamA = a_renamed(str, str2);
            if (outputStreamA == null) {
                if (outputStreamA != null) {
                    outputStreamA.close();
                }
                return false;
            }
            try {
                outputStreamA.write(bArr);
                if (outputStreamA != null) {
                    outputStreamA.close();
                }
                return true;
            } finally {
            }
        } catch (java.io.IOException e_renamed) {
            e_renamed.printStackTrace();
            return false;
        }
    }

    public static boolean c_renamed(java.lang.String str, java.lang.String str2) throws java.io.FileNotFoundException {
        if (a_renamed(str)) {
            return true;
        }
        int iLastIndexOf = str.lastIndexOf(java.io.File.separator);
        java.lang.String strSubstring = str.substring(0, iLastIndexOf);
        if (g_renamed(str)) {
            if (i_renamed(strSubstring)) {
                try {
                    android.provider.DocumentsContract.createDocument(f5297c.getContentResolver(), h_renamed(strSubstring), str2, str.substring(iLastIndexOf + 1));
                    return true;
                } catch (java.io.FileNotFoundException e_renamed) {
                    e_renamed.printStackTrace();
                }
            }
            return false;
        }
        java.io.File file = new java.io.File(strSubstring);
        if (!file.exists() && !file.mkdirs()) {
            return false;
        }
        try {
            return new java.io.File(str).createNewFile();
        } catch (java.io.IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private static boolean i_renamed(java.lang.String str) throws java.io.FileNotFoundException {
        if (a_renamed(str)) {
            return b_renamed(str);
        }
        int iLastIndexOf = str.lastIndexOf("/");
        java.lang.String strSubstring = str.substring(0, iLastIndexOf);
        if (i_renamed(strSubstring)) {
            try {
                android.provider.DocumentsContract.createDocument(f5297c.getContentResolver(), h_renamed(strSubstring), "vnd.android.document/directory", str.substring(iLastIndexOf + 1));
                return true;
            } catch (java.io.FileNotFoundException e_renamed) {
                e_renamed.printStackTrace();
            }
        }
        return false;
    }
}
