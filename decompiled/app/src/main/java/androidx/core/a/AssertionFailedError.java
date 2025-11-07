package androidx.core.a_renamed;

/* compiled from: FileProvider.java */
/* loaded from: classes.dex */
public class b_renamed extends android.content.ContentProvider {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.String[] f799a = {"_display_name", "_size"};

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final java.io.File f800b = new java.io.File("/");

    /* renamed from: c_renamed, reason: collision with root package name */
    private static java.util.HashMap<java.lang.String, androidx.core.a_renamed.b_renamed.a_renamed> f801c = new java.util.HashMap<>();
    private androidx.core.a_renamed.b_renamed.a_renamed d_renamed;

    /* compiled from: FileProvider.java */
    interface a_renamed {
        android.net.Uri a_renamed(java.io.File file);

        java.io.File a_renamed(android.net.Uri uri);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(android.content.Context context, android.content.pm.ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new java.lang.SecurityException("Provider must not be_renamed exported");
        }
        if (!providerInfo.grantUriPermissions) {
            throw new java.lang.SecurityException("Provider must grant uri permissions");
        }
        this.d_renamed = a_renamed(context, providerInfo.authority);
    }

    public static android.net.Uri a_renamed(android.content.Context context, java.lang.String str, java.io.File file) {
        return a_renamed(context, str).a_renamed(file);
    }

    @Override // android.content.ContentProvider
    public android.database.Cursor query(android.net.Uri uri, java.lang.String[] strArr, java.lang.String str, java.lang.String[] strArr2, java.lang.String str2) {
        int i_renamed;
        java.io.File fileA = this.d_renamed.a_renamed(uri);
        if (strArr == null) {
            strArr = f799a;
        }
        java.lang.String[] strArr3 = new java.lang.String[strArr.length];
        java.lang.Object[] objArr = new java.lang.Object[strArr.length];
        int i2 = 0;
        for (java.lang.String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i2] = "_display_name";
                i_renamed = i2 + 1;
                objArr[i2] = fileA.getName();
            } else if ("_size".equals(str3)) {
                strArr3[i2] = "_size";
                i_renamed = i2 + 1;
                objArr[i2] = java.lang.Long.valueOf(fileA.length());
            }
            i2 = i_renamed;
        }
        java.lang.String[] strArrA = a_renamed(strArr3, i2);
        java.lang.Object[] objArrA = a_renamed(objArr, i2);
        android.database.MatrixCursor matrixCursor = new android.database.MatrixCursor(strArrA, 1);
        matrixCursor.addRow(objArrA);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public java.lang.String getType(android.net.Uri uri) {
        java.io.File fileA = this.d_renamed.a_renamed(uri);
        int iLastIndexOf = fileA.getName().lastIndexOf(46);
        if (iLastIndexOf < 0) {
            return "application/octet-stream";
        }
        java.lang.String mimeTypeFromExtension = android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileA.getName().substring(iLastIndexOf + 1));
        return mimeTypeFromExtension != null ? mimeTypeFromExtension : "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public android.net.Uri insert(android.net.Uri uri, android.content.ContentValues contentValues) {
        throw new java.lang.UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public int update(android.net.Uri uri, android.content.ContentValues contentValues, java.lang.String str, java.lang.String[] strArr) {
        throw new java.lang.UnsupportedOperationException("No external updates");
    }

    @Override // android.content.ContentProvider
    public int delete(android.net.Uri uri, java.lang.String str, java.lang.String[] strArr) {
        return this.d_renamed.a_renamed(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public android.os.ParcelFileDescriptor openFile(android.net.Uri uri, java.lang.String str) throws java.io.FileNotFoundException {
        return android.os.ParcelFileDescriptor.open(this.d_renamed.a_renamed(uri), a_renamed(str));
    }

    private static androidx.core.a_renamed.b_renamed.a_renamed a_renamed(android.content.Context context, java.lang.String str) {
        androidx.core.a_renamed.b_renamed.a_renamed aVarB;
        synchronized (f801c) {
            aVarB = f801c.get(str);
            if (aVarB == null) {
                try {
                    aVarB = b_renamed(context, str);
                    f801c.put(str, aVarB);
                } catch (java.io.IOException e_renamed) {
                    throw new java.lang.IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e_renamed);
                } catch (org.xmlpull.v1.XmlPullParserException e2) {
                    throw new java.lang.IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e2);
                }
            }
        }
        return aVarB;
    }

    private static androidx.core.a_renamed.b_renamed.a_renamed b_renamed(android.content.Context context, java.lang.String str) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        androidx.core.a_renamed.b_renamed.FileProvider_3 c0014b = new androidx.core.a_renamed.b_renamed.FileProvider_3(str);
        android.content.pm.ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider(str, 128);
        if (providerInfoResolveContentProvider == null) {
            throw new java.lang.IllegalArgumentException("Couldn't_renamed find meta-data for provider with authority " + str);
        }
        android.content.res.XmlResourceParser xmlResourceParserLoadXmlMetaData = providerInfoResolveContentProvider.loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
        if (xmlResourceParserLoadXmlMetaData == null) {
            throw new java.lang.IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }
        while (true) {
            int next = xmlResourceParserLoadXmlMetaData.next();
            if (next == 1) {
                return c0014b;
            }
            if (next == 2) {
                java.lang.String name = xmlResourceParserLoadXmlMetaData.getName();
                java.io.File externalStorageDirectory = null;
                java.lang.String attributeValue = xmlResourceParserLoadXmlMetaData.getAttributeValue(null, "name");
                java.lang.String attributeValue2 = xmlResourceParserLoadXmlMetaData.getAttributeValue(null, "path");
                if ("root-path".equals(name)) {
                    externalStorageDirectory = f800b;
                } else if ("files-path".equals(name)) {
                    externalStorageDirectory = context.getFilesDir();
                } else if ("cache-path".equals(name)) {
                    externalStorageDirectory = context.getCacheDir();
                } else if ("external-path".equals(name)) {
                    externalStorageDirectory = android.os.Environment.getExternalStorageDirectory();
                } else if ("external-files-path".equals(name)) {
                    java.io.File[] fileArrA = androidx.core.a_renamed.a_renamed.a_renamed(context, (java.lang.String) null);
                    if (fileArrA.length > 0) {
                        externalStorageDirectory = fileArrA[0];
                    }
                } else if ("external-cache-path".equals(name)) {
                    java.io.File[] fileArrA2 = androidx.core.a_renamed.a_renamed.a_renamed(context);
                    if (fileArrA2.length > 0) {
                        externalStorageDirectory = fileArrA2[0];
                    }
                } else if (android.os.Build.VERSION.SDK_INT >= 21 && "external-media-path".equals(name)) {
                    java.io.File[] externalMediaDirs = context.getExternalMediaDirs();
                    if (externalMediaDirs.length > 0) {
                        externalStorageDirectory = externalMediaDirs[0];
                    }
                }
                if (externalStorageDirectory != null) {
                    c0014b.a_renamed(attributeValue, a_renamed(externalStorageDirectory, attributeValue2));
                }
            }
        }
    }

    /* compiled from: FileProvider.java */
    /* renamed from: androidx.core.a_renamed.b_renamed$b_renamed, reason: collision with other inner class name */
    static class FileProvider_3 implements androidx.core.a_renamed.b_renamed.a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final java.lang.String f802a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private final java.util.HashMap<java.lang.String, java.io.File> f803b = new java.util.HashMap<>();

        FileProvider_3(java.lang.String str) {
            this.f802a = str;
        }

        void a_renamed(java.lang.String str, java.io.File file) throws java.io.IOException {
            if (android.text.TextUtils.isEmpty(str)) {
                throw new java.lang.IllegalArgumentException("Name must not be_renamed empty");
            }
            try {
                this.f803b.put(str, file.getCanonicalFile());
            } catch (java.io.IOException e_renamed) {
                throw new java.lang.IllegalArgumentException("Failed to resolve canonical path for " + file, e_renamed);
            }
        }

        @Override // androidx.core.a_renamed.b_renamed.a_renamed
        public android.net.Uri a_renamed(java.io.File file) throws java.io.IOException {
            java.lang.String strSubstring;
            try {
                java.lang.String canonicalPath = file.getCanonicalPath();
                java.util.Map.Entry<java.lang.String, java.io.File> entry = null;
                for (java.util.Map.Entry<java.lang.String, java.io.File> entry2 : this.f803b.entrySet()) {
                    java.lang.String path = entry2.getValue().getPath();
                    if (canonicalPath.startsWith(path) && (entry == null || path.length() > entry.getValue().getPath().length())) {
                        entry = entry2;
                    }
                }
                if (entry == null) {
                    throw new java.lang.IllegalArgumentException("Failed to find configured root that contains " + canonicalPath);
                }
                java.lang.String path2 = entry.getValue().getPath();
                if (path2.endsWith("/")) {
                    strSubstring = canonicalPath.substring(path2.length());
                } else {
                    strSubstring = canonicalPath.substring(path2.length() + 1);
                }
                return new android.net.Uri.Builder().scheme("content").authority(this.f802a).encodedPath(android.net.Uri.encode(entry.getKey()) + '/' + android.net.Uri.encode(strSubstring, "/")).build();
            } catch (java.io.IOException unused) {
                throw new java.lang.IllegalArgumentException("Failed to resolve canonical path for " + file);
            }
        }

        @Override // androidx.core.a_renamed.b_renamed.a_renamed
        public java.io.File a_renamed(android.net.Uri uri) throws java.io.IOException {
            java.lang.String encodedPath = uri.getEncodedPath();
            int iIndexOf = encodedPath.indexOf(47, 1);
            java.lang.String strDecode = android.net.Uri.decode(encodedPath.substring(1, iIndexOf));
            java.lang.String strDecode2 = android.net.Uri.decode(encodedPath.substring(iIndexOf + 1));
            java.io.File file = this.f803b.get(strDecode);
            if (file == null) {
                throw new java.lang.IllegalArgumentException("Unable to find configured root for " + uri);
            }
            java.io.File file2 = new java.io.File(file, strDecode2);
            try {
                java.io.File canonicalFile = file2.getCanonicalFile();
                if (canonicalFile.getPath().startsWith(file.getPath())) {
                    return canonicalFile;
                }
                throw new java.lang.SecurityException("Resolved path jumped beyond configured root");
            } catch (java.io.IOException unused) {
                throw new java.lang.IllegalArgumentException("Failed to resolve canonical path for " + file2);
            }
        }
    }

    private static int a_renamed(java.lang.String str) {
        if ("r_renamed".equals(str)) {
            return com.google.android.exoplayer2.C_renamed.ENCODING_PCM_MU_LAW;
        }
        if ("w_renamed".equals(str) || "wt".equals(str)) {
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
        throw new java.lang.IllegalArgumentException("Invalid mode: " + str);
    }

    private static java.io.File a_renamed(java.io.File file, java.lang.String... strArr) {
        for (java.lang.String str : strArr) {
            if (str != null) {
                file = new java.io.File(file, str);
            }
        }
        return file;
    }

    private static java.lang.String[] a_renamed(java.lang.String[] strArr, int i_renamed) {
        java.lang.String[] strArr2 = new java.lang.String[i_renamed];
        java.lang.System.arraycopy(strArr, 0, strArr2, 0, i_renamed);
        return strArr2;
    }

    private static java.lang.Object[] a_renamed(java.lang.Object[] objArr, int i_renamed) {
        java.lang.Object[] objArr2 = new java.lang.Object[i_renamed];
        java.lang.System.arraycopy(objArr, 0, objArr2, 0, i_renamed);
        return objArr2;
    }
}
