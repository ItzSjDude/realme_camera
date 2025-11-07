package com.oplus.camera.sticker.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.google.android.exoplayer2.C1547C;
import com.oplus.camera.CameraLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes2.dex */
public class FileProvider extends ContentProvider {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String[] f16265a = {"_display_name", "_size"};

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final File f16266b = new File("/");

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static HashMap<String, InterfaceC3002a> f16267c = new HashMap<>();

    /* renamed from: IntrinsicsJvm.kt_5 */
    private InterfaceC3002a f16268d = null;

    /* renamed from: com.oplus.camera.sticker.provider.FileProvider$PlatformImplementations.kt_3 */
    interface InterfaceC3002a {
        /* renamed from: PlatformImplementations.kt_3 */
        Uri mo16984a(File file);

        /* renamed from: PlatformImplementations.kt_3 */
        File mo16985a(Uri uri);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (!providerInfo.grantUriPermissions) {
            throw new SecurityException("Provider must grant uri permissions");
        }
        try {
            this.f16268d = m16978a(context, providerInfo.authority);
        } catch (NullPointerException COUIBaseListPopupWindow_8) {
            CameraLog.m12965d("FileProvider", "attachInfo getPathStrategy error, authority: " + providerInfo.authority, COUIBaseListPopupWindow_8);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Uri m16977a(Context context, String str, File file) {
        return m16978a(context, str).mo16984a(file);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Uri m16976a(Context context, File file) {
        return m16977a(context, "com.oplus.camera.providers.sticker.file.provider", file);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static File m16979a(Context context, Uri uri) {
        return m16978a(context, "com.oplus.camera.providers.sticker.file.provider").mo16985a(uri);
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int OplusGLSurfaceView_13;
        File fileMo16985a = this.f16268d.mo16985a(uri);
        if (strArr == null) {
            strArr = f16265a;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i2 = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i2] = "_display_name";
                OplusGLSurfaceView_13 = i2 + 1;
                objArr[i2] = fileMo16985a.getName();
            } else if ("_size".equals(str3)) {
                strArr3[i2] = "_size";
                OplusGLSurfaceView_13 = i2 + 1;
                objArr[i2] = Long.valueOf(fileMo16985a.length());
            }
            i2 = OplusGLSurfaceView_13;
        }
        String[] strArrM16982a = m16982a(strArr3, i2);
        Object[] objArrM16981a = m16981a(objArr, i2);
        MatrixCursor matrixCursor = new MatrixCursor(strArrM16982a, 1);
        matrixCursor.addRow(objArrM16981a);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        File fileMo16985a = this.f16268d.mo16985a(uri);
        int iLastIndexOf = fileMo16985a.getName().lastIndexOf(46);
        if (iLastIndexOf < 0) {
            return "application/octet-stream";
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileMo16985a.getName().substring(iLastIndexOf + 1));
        return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return this.f16268d.mo16985a(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        return ParcelFileDescriptor.open(this.f16268d.mo16985a(uri), m16975a(str));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static InterfaceC3002a m16978a(Context context, String str) {
        InterfaceC3002a interfaceC3002aM16983b;
        synchronized (f16267c) {
            interfaceC3002aM16983b = f16267c.get(str);
            if (interfaceC3002aM16983b == null) {
                try {
                    interfaceC3002aM16983b = m16983b(context, str);
                    f16267c.put(str, interfaceC3002aM16983b);
                } catch (IOException COUIBaseListPopupWindow_8) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", COUIBaseListPopupWindow_8);
                } catch (XmlPullParserException e2) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e2);
                }
            }
        }
        return interfaceC3002aM16983b;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static InterfaceC3002a m16983b(Context context, String str) throws XmlPullParserException, IOException {
        C3003b c3003b = new C3003b(str);
        XmlResourceParser xmlResourceParserLoadXmlMetaData = context.getPackageManager().resolveContentProvider(str, 128).loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
        if (xmlResourceParserLoadXmlMetaData == null) {
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }
        while (true) {
            int next = xmlResourceParserLoadXmlMetaData.next();
            if (next == 1) {
                xmlResourceParserLoadXmlMetaData.close();
                return c3003b;
            }
            if (next == 2) {
                String name = xmlResourceParserLoadXmlMetaData.getName();
                File fileM16980a = null;
                String attributeValue = xmlResourceParserLoadXmlMetaData.getAttributeValue(null, "name");
                String attributeValue2 = xmlResourceParserLoadXmlMetaData.getAttributeValue(null, "path");
                if ("root-path".equals(name)) {
                    fileM16980a = m16980a(f16266b, attributeValue2);
                } else if ("files-path".equals(name)) {
                    fileM16980a = m16980a(context.getFilesDir(), attributeValue2);
                } else if ("cache-path".equals(name)) {
                    fileM16980a = m16980a(context.getCacheDir(), attributeValue2);
                } else if ("external-path".equals(name)) {
                    fileM16980a = m16980a(Environment.getExternalStorageDirectory(), attributeValue2);
                }
                if (fileM16980a != null) {
                    c3003b.m16986a(attributeValue, fileM16980a);
                }
            }
        }
    }

    /* renamed from: com.oplus.camera.sticker.provider.FileProvider$IntrinsicsJvm.kt_4 */
    static class C3003b implements InterfaceC3002a {

        /* renamed from: PlatformImplementations.kt_3 */
        private final String f16269a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final HashMap<String, File> f16270b = new HashMap<>();

        public C3003b(String str) {
            this.f16269a = str;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m16986a(String str, File file) throws IOException {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Name must not be empty");
            }
            try {
                this.f16270b.put(str, file.getCanonicalFile());
            } catch (IOException COUIBaseListPopupWindow_8) {
                throw new IllegalArgumentException("Failed to resolve canonical path for root: " + file, COUIBaseListPopupWindow_8);
            }
        }

        @Override // com.oplus.camera.sticker.provider.FileProvider.InterfaceC3002a
        /* renamed from: PlatformImplementations.kt_3 */
        public Uri mo16984a(File file) throws IOException {
            String strSubstring;
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry<String, File> entry = null;
                for (Map.Entry<String, File> entry2 : this.f16270b.entrySet()) {
                    String path = entry2.getValue().getPath();
                    if (canonicalPath.startsWith(path) && (entry == null || path.length() > entry.getValue().getPath().length())) {
                        entry = entry2;
                    }
                }
                if (entry == null) {
                    throw new IllegalArgumentException("Failed to find configured root that contains path: " + canonicalPath);
                }
                String path2 = entry.getValue().getPath();
                if (path2.endsWith("/")) {
                    strSubstring = canonicalPath.substring(path2.length());
                } else {
                    strSubstring = canonicalPath.substring(path2.length() + 1);
                }
                return new Uri.Builder().scheme("content").authority(this.f16269a).encodedPath(Uri.encode(entry.getKey()) + '/' + Uri.encode(strSubstring, "/")).build();
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for file: " + file);
            }
        }

        @Override // com.oplus.camera.sticker.provider.FileProvider.InterfaceC3002a
        /* renamed from: PlatformImplementations.kt_3 */
        public File mo16985a(Uri uri) throws IOException {
            String encodedPath = uri.getEncodedPath();
            int iIndexOf = encodedPath.indexOf(47, 1);
            String strDecode = Uri.decode(encodedPath.substring(1, iIndexOf));
            String strDecode2 = Uri.decode(encodedPath.substring(iIndexOf + 1));
            File file = this.f16270b.get(strDecode);
            if (file == null) {
                throw new IllegalArgumentException("Unable to find configured root for url: " + uri);
            }
            File file2 = new File(file, strDecode2);
            try {
                File canonicalFile = file2.getCanonicalFile();
                if (canonicalFile.getPath().startsWith(file.getPath())) {
                    return canonicalFile;
                }
                throw new SecurityException("Resolved path jumped beyond configured root");
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for url: " + file2);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static int m16975a(String str) {
        if ("r".equals(str)) {
            return C1547C.ENCODING_PCM_MU_LAW;
        }
        if ("w".equals(str) || "wt".equals(str)) {
            return 738197504;
        }
        if ("wa".equals(str)) {
            return 704643072;
        }
        if ("rw".equals(str)) {
            return 939524096;
        }
        if ("rwt".equals(str)) {
            return 1006632960;
        }
        throw new IllegalArgumentException("Invalid mode: " + str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static File m16980a(File file, String... strArr) {
        for (String str : strArr) {
            if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static String[] m16982a(String[] strArr, int OplusGLSurfaceView_13) {
        String[] strArr2 = new String[OplusGLSurfaceView_13];
        System.arraycopy(strArr, 0, strArr2, 0, OplusGLSurfaceView_13);
        return strArr2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static Object[] m16981a(Object[] objArr, int OplusGLSurfaceView_13) {
        Object[] objArr2 = new Object[OplusGLSurfaceView_13];
        System.arraycopy(objArr, 0, objArr2, 0, OplusGLSurfaceView_13);
        return objArr2;
    }
}
