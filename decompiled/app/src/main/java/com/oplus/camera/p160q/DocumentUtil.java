package com.oplus.camera.p160q;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.UriPermission;
import android.net.Uri;
import android.os.Environment;
import android.os.storage.StorageVolume;
import android.provider.DocumentsContract;
import com.oplus.camera.Storage;
import com.oplus.compat.p183b.p184a.UnSupportedApiVersionException;
import com.oplus.compat.p187os.UserHandleNative;
import com.oplus.compat.p187os.storage.StorageManagerNative;
import com.oplus.compat.p187os.storage.StorageVolumeNative;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

/* compiled from: DocumentUtil.java */
/* renamed from: com.oplus.camera.q.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class DocumentUtil {

    /* renamed from: PlatformImplementations.kt_3 */
    public static int f15848a = 101;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static Uri f15849b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static Context f15850c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static PlatformImplementations.kt_3 f15851d;

    /* compiled from: DocumentUtil.java */
    /* renamed from: com.oplus.camera.q.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void m16214a();

        /* renamed from: IntrinsicsJvm.kt_4 */
        void m16215b();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static boolean m16207d() {
        return true;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private static boolean m16211g(String str) {
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static StorageVolume m16204c() {
        String path;
        if (f15850c == null) {
            return null;
        }
        StorageVolume[] volumeList = new StorageVolume[0];
        try {
            volumeList = StorageManagerNative.getVolumeList(UserHandleNative.myUserId(), 0);
        } catch (UnSupportedApiVersionException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        if (volumeList == null) {
            return null;
        }
        for (StorageVolume storageVolume : volumeList) {
            try {
                path = StorageVolumeNative.getPath(storageVolume);
            } catch (UnSupportedApiVersionException e2) {
                e2.printStackTrace();
                path = null;
            }
            if ("mounted".equalsIgnoreCase(storageVolume.getState()) && path != null && Environment.isExternalStorageRemovable(new File(path))) {
                return storageVolume;
            }
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m16196a() {
        if (Storage.f12084j == null) {
            return false;
        }
        return m16210f(Storage.f12084j);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m16194a(Context context, PlatformImplementations.kt_3 aVar) {
        StorageVolume storageVolumeM16204c;
        Uri uri;
        f15850c = context.getApplicationContext();
        if (m16207d() || (storageVolumeM16204c = m16204c()) == null) {
            return;
        }
        String uuid = storageVolumeM16204c.getUuid();
        Iterator<UriPermission> it = context.getContentResolver().getPersistedUriPermissions().iterator();
        while (true) {
            if (!it.hasNext()) {
                uri = null;
                break;
            }
            UriPermission next = it.next();
            if (next.getUri().toString().contains(uuid)) {
                uri = next.getUri();
                break;
            }
        }
        if (uri != null) {
            f15849b = uri;
        } else {
            if (aVar == null || !(context instanceof Activity)) {
                return;
            }
            f15851d = aVar;
            ((Activity) context).startActivityForResult(storageVolumeM16204c.createAccessIntent(null), f15848a);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m16200b() {
        f15851d.m16215b();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m16195a(Intent intent) {
        Context context = f15850c;
        if (context != null) {
            context.getContentResolver().takePersistableUriPermission(intent.getData(), 3);
            f15849b = intent.getData();
            f15851d.m16214a();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private static Uri m16212h(String str) {
        String strReplaceFirst;
        if (!m16196a() || !m16211g(str)) {
            return null;
        }
        String strSubstring = str.substring(str.indexOf(File.separator, 1) + 1);
        if (strSubstring.contains(File.separator)) {
            strReplaceFirst = strSubstring.replaceFirst(File.separator, ":");
        } else {
            strReplaceFirst = strSubstring + ":";
        }
        return DocumentsContract.buildDocumentUriUsingTree(f15849b, strReplaceFirst);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m16197a(String str) {
        return new File(str).exists();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static boolean m16201b(String str) {
        return new File(str).isDirectory();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static boolean m16205c(String str) throws FileNotFoundException {
        if (!m16197a(str)) {
            return true;
        }
        if (m16211g(str)) {
            try {
                DocumentsContract.deleteDocument(f15850c.getContentResolver(), m16212h(str));
                return true;
            } catch (FileNotFoundException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
                return false;
            }
        }
        return new File(str).delete();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static byte[] m16208d(String str) {
        if (f15850c == null) {
            return null;
        }
        return m16199a(str, (byte[]) null);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static InputStream m16209e(String str) throws FileNotFoundException {
        if (m16211g(str)) {
            return f15850c.getContentResolver().openInputStream(m16212h(str));
        }
        return new FileInputStream(str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static byte[] m16199a(String str, byte[] bArr) throws IOException {
        try {
            InputStream inputStreamM16209e = m16209e(str);
            try {
                int iAvailable = inputStreamM16209e.available();
                if (bArr == null || bArr.length < iAvailable) {
                    bArr = new byte[iAvailable];
                }
                if (iAvailable == inputStreamM16209e.read(bArr)) {
                    if (inputStreamM16209e != null) {
                        inputStreamM16209e.close();
                    }
                    return bArr;
                }
                if (inputStreamM16209e != null) {
                    inputStreamM16209e.close();
                }
                return null;
            } finally {
            }
        } catch (IOException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static OutputStream m16193a(String str, String str2) throws FileNotFoundException {
        if (!m16206c(str, str2)) {
            return null;
        }
        if (m16211g(str)) {
            return f15850c.getContentResolver().openOutputStream(m16212h(str));
        }
        return new FileOutputStream(str);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public static boolean m16210f(String str) {
        if (m16197a(str)) {
            return m16201b(str);
        }
        if (m16211g(str)) {
            return m16213i(str);
        }
        return new File(str).mkdirs();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static boolean m16202b(String str, String str2) throws FileNotFoundException {
        if ((m16211g(str) && !m16211g(str2)) || (!m16211g(str) && m16211g(str2))) {
            return false;
        }
        if (m16197a(str2) && !m16205c(str2)) {
            return false;
        }
        if (m16211g(str2)) {
            try {
                DocumentsContract.renameDocument(f15850c.getContentResolver(), m16212h(str), new File(str2).getName());
                return true;
            } catch (FileNotFoundException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
                return false;
            }
        }
        return new File(str).renameTo(new File(str2));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m16198a(String str, String str2, byte[] bArr) {
        File file = new File(str);
        String str3 = file.getParent() + File.separator + ("temp_" + file.getName());
        if (m16203b(str3, str2, bArr)) {
            return m16202b(str3, str);
        }
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static boolean m16203b(String str, String str2, byte[] bArr) throws IOException {
        if (bArr == null) {
            return false;
        }
        try {
            OutputStream outputStreamM16193a = m16193a(str, str2);
            if (outputStreamM16193a == null) {
                if (outputStreamM16193a != null) {
                    outputStreamM16193a.close();
                }
                return false;
            }
            try {
                outputStreamM16193a.write(bArr);
                if (outputStreamM16193a != null) {
                    outputStreamM16193a.close();
                }
                return true;
            } finally {
            }
        } catch (IOException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return false;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static boolean m16206c(String str, String str2) throws FileNotFoundException {
        if (m16197a(str)) {
            return true;
        }
        int iLastIndexOf = str.lastIndexOf(File.separator);
        String strSubstring = str.substring(0, iLastIndexOf);
        if (m16211g(str)) {
            if (m16213i(strSubstring)) {
                try {
                    DocumentsContract.createDocument(f15850c.getContentResolver(), m16212h(strSubstring), str2, str.substring(iLastIndexOf + 1));
                    return true;
                } catch (FileNotFoundException COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                }
            }
            return false;
        }
        File file = new File(strSubstring);
        if (!file.exists() && !file.mkdirs()) {
            return false;
        }
        try {
            return new File(str).createNewFile();
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private static boolean m16213i(String str) throws FileNotFoundException {
        if (m16197a(str)) {
            return m16201b(str);
        }
        int iLastIndexOf = str.lastIndexOf("/");
        String strSubstring = str.substring(0, iLastIndexOf);
        if (m16213i(strSubstring)) {
            try {
                DocumentsContract.createDocument(f15850c.getContentResolver(), m16212h(strSubstring), "vnd.android.document/directory", str.substring(iLastIndexOf + 1));
                return true;
            } catch (FileNotFoundException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }
        return false;
    }
}
