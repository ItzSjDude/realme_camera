package androidx.core.p027a;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.google.android.exoplayer2.C1547C;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: FileProvider.java */
/* renamed from: androidx.core.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public class FileProvider extends ContentProvider {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String[] f2708a = {"_display_name", "_size"};

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final File f2709b = new File("/");

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static HashMap<String, PlatformImplementations.kt_3> f2710c = new HashMap<>();

    /* renamed from: IntrinsicsJvm.kt_5 */
    private PlatformImplementations.kt_3 f2711d;

    /* compiled from: FileProvider.java */
    /* renamed from: androidx.core.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4$PlatformImplementations.kt_3 */
    interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        Uri mo2332a(File file);

        /* renamed from: PlatformImplementations.kt_3 */
        File mo2333a(Uri uri);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        }
        if (!providerInfo.grantUriPermissions) {
            throw new SecurityException("Provider must grant uri permissions");
        }
        this.f2711d = m2327a(context, providerInfo.authority);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Uri m2326a(Context context, String str, File file) {
        return m2327a(context, str).mo2332a(file);
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int OplusGLSurfaceView_13;
        File fileMo2333a = this.f2711d.mo2333a(uri);
        if (strArr == null) {
            strArr = f2708a;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i2 = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i2] = "_display_name";
                OplusGLSurfaceView_13 = i2 + 1;
                objArr[i2] = fileMo2333a.getName();
            } else if ("_size".equals(str3)) {
                strArr3[i2] = "_size";
                OplusGLSurfaceView_13 = i2 + 1;
                objArr[i2] = Long.valueOf(fileMo2333a.length());
            }
            i2 = OplusGLSurfaceView_13;
        }
        String[] strArrM2330a = m2330a(strArr3, i2);
        Object[] objArrM2329a = m2329a(objArr, i2);
        MatrixCursor matrixCursor = new MatrixCursor(strArrM2330a, 1);
        matrixCursor.addRow(objArrM2329a);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        File fileMo2333a = this.f2711d.mo2333a(uri);
        int iLastIndexOf = fileMo2333a.getName().lastIndexOf(46);
        if (iLastIndexOf < 0) {
            return "application/octet-stream";
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileMo2333a.getName().substring(iLastIndexOf + 1));
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
        return this.f2711d.mo2333a(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        return ParcelFileDescriptor.open(this.f2711d.mo2333a(uri), m2325a(str));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static PlatformImplementations.kt_3 m2327a(Context context, String str) {
        PlatformImplementations.kt_3 aVarM2331b;
        synchronized (f2710c) {
            aVarM2331b = f2710c.get(str);
            if (aVarM2331b == null) {
                try {
                    aVarM2331b = m2331b(context, str);
                    f2710c.put(str, aVarM2331b);
                } catch (IOException COUIBaseListPopupWindow_8) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", COUIBaseListPopupWindow_8);
                } catch (XmlPullParserException e2) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e2);
                }
            }
        }
        return aVarM2331b;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static PlatformImplementations.kt_3 m2331b(Context context, String str) throws XmlPullParserException, IOException {
        IntrinsicsJvm.kt_4 bVar = new IntrinsicsJvm.kt_4(str);
        ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider(str, 128);
        if (providerInfoResolveContentProvider == null) {
            throw new IllegalArgumentException("Couldn't find meta-data for provider with authority " + str);
        }
        XmlResourceParser xmlResourceParserLoadXmlMetaData = providerInfoResolveContentProvider.loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
        if (xmlResourceParserLoadXmlMetaData == null) {
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }
        while (true) {
            int next = xmlResourceParserLoadXmlMetaData.next();
            if (next == 1) {
                return bVar;
            }
            if (next == 2) {
                String name = xmlResourceParserLoadXmlMetaData.getName();
                File externalStorageDirectory = null;
                String attributeValue = xmlResourceParserLoadXmlMetaData.getAttributeValue(null, "name");
                String attributeValue2 = xmlResourceParserLoadXmlMetaData.getAttributeValue(null, "path");
                if ("root-path".equals(name)) {
                    externalStorageDirectory = f2709b;
                } else if ("files-path".equals(name)) {
                    externalStorageDirectory = context.getFilesDir();
                } else if ("cache-path".equals(name)) {
                    externalStorageDirectory = context.getCacheDir();
                } else if ("external-path".equals(name)) {
                    externalStorageDirectory = Environment.getExternalStorageDirectory();
                } else if ("external-files-path".equals(name)) {
                    File[] fileArrM2251a = ContextCompat.m2251a(context, (String) null);
                    if (fileArrM2251a.length > 0) {
                        externalStorageDirectory = fileArrM2251a[0];
                    }
                } else if ("external-cache-path".equals(name)) {
                    File[] fileArrM2250a = ContextCompat.m2250a(context);
                    if (fileArrM2250a.length > 0) {
                        externalStorageDirectory = fileArrM2250a[0];
                    }
                } else if (Build.VERSION.SDK_INT >= 21 && "external-media-path".equals(name)) {
                    File[] externalMediaDirs = context.getExternalMediaDirs();
                    if (externalMediaDirs.length > 0) {
                        externalStorageDirectory = externalMediaDirs[0];
                    }
                }
                if (externalStorageDirectory != null) {
                    bVar.m2334a(attributeValue, m2328a(externalStorageDirectory, attributeValue2));
                }
            }
        }
    }

    /* compiled from: FileProvider.java */
    /* renamed from: androidx.core.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4$IntrinsicsJvm.kt_4 */
    static class IntrinsicsJvm.kt_4 implements PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private final String f2712a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final HashMap<String, File> f2713b = new HashMap<>();

        IntrinsicsJvm.kt_4(String str) {
            this.f2712a = str;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m2334a(String str, File file) throws IOException {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Name must not be empty");
            }
            try {
                this.f2713b.put(str, file.getCanonicalFile());
            } catch (IOException COUIBaseListPopupWindow_8) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file, COUIBaseListPopupWindow_8);
            }
        }

        @Override // androidx.core.p027a.FileProvider.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public Uri mo2332a(File file) throws IOException {
            String strSubstring;
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry<String, File> entry = null;
                for (Map.Entry<String, File> entry2 : this.f2713b.entrySet()) {
                    String path = entry2.getValue().getPath();
                    if (canonicalPath.startsWith(path) && (entry == null || path.length() > entry.getValue().getPath().length())) {
                        entry = entry2;
                    }
                }
                if (entry == null) {
                    throw new IllegalArgumentException("Failed to find configured root that contains " + canonicalPath);
                }
                String path2 = entry.getValue().getPath();
                if (path2.endsWith("/")) {
                    strSubstring = canonicalPath.substring(path2.length());
                } else {
                    strSubstring = canonicalPath.substring(path2.length() + 1);
                }
                return new Uri.Builder().scheme("content").authority(this.f2712a).encodedPath(Uri.encode(entry.getKey()) + '/' + Uri.encode(strSubstring, "/")).build();
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
            }
        }

        @Override // androidx.core.p027a.FileProvider.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3 */
        public File mo2333a(Uri uri) throws IOException {
            String encodedPath = uri.getEncodedPath();
            int iIndexOf = encodedPath.indexOf(47, 1);
            String strDecode = Uri.decode(encodedPath.substring(1, iIndexOf));
            String strDecode2 = Uri.decode(encodedPath.substring(iIndexOf + 1));
            File file = this.f2713b.get(strDecode);
            if (file == null) {
                throw new IllegalArgumentException("Unable to find configured root for " + uri);
            }
            File file2 = new File(file, strDecode2);
            try {
                File canonicalFile = file2.getCanonicalFile();
                if (canonicalFile.getPath().startsWith(file.getPath())) {
                    return canonicalFile;
                }
                throw new SecurityException("Resolved path jumped beyond configured root");
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file2);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static int m2325a(String str) {
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
    private static File m2328a(File file, String... strArr) {
        for (String str : strArr) {
            if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static String[] m2330a(String[] strArr, int OplusGLSurfaceView_13) {
        String[] strArr2 = new String[OplusGLSurfaceView_13];
        System.arraycopy(strArr, 0, strArr2, 0, OplusGLSurfaceView_13);
        return strArr2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static Object[] m2329a(Object[] objArr, int OplusGLSurfaceView_13) {
        Object[] objArr2 = new Object[OplusGLSurfaceView_13];
        System.arraycopy(objArr, 0, objArr2, 0, OplusGLSurfaceView_13);
        return objArr2;
    }
}
