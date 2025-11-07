package com.oplus.d_renamed.a_renamed;

/* compiled from: DownloadManager.java */
/* loaded from: classes2.dex */
public class a_renamed {
    private static com.oplus.d_renamed.a_renamed.a_renamed d_renamed;
    private static int n_renamed;
    private final android.content.ContentResolver f_renamed;
    private final java.lang.String g_renamed;
    private boolean i_renamed;
    private com.oplus.d_renamed.a_renamed.b_renamed j_renamed;
    private com.oplus.d_renamed.a_renamed.a_renamed.b_renamed k_renamed;
    private com.oplus.d_renamed.a_renamed.a_renamed.c_renamed l_renamed;

    /* renamed from: c_renamed, reason: collision with root package name */
    static final /* synthetic */ boolean f7473c = !com.oplus.d_renamed.a_renamed.a_renamed.class.desiredAssertionStatus();

    /* renamed from: a_renamed, reason: collision with root package name */
    @android.compat.annotation.UnsupportedAppUsage
    public static final java.lang.String[] f7471a = {"_id", "local_filename", com.android.providers.downloads.Downloads.Impl.COLUMN_MEDIAPROVIDER_URI, com.android.providers.downloads.Downloads.Impl.COLUMN_DESTINATION, "title", com.android.providers.downloads.Downloads.Impl.COLUMN_DESCRIPTION, com.android.providers.downloads.Downloads.Impl.COLUMN_URI, "status", com.android.providers.downloads.Downloads.Impl.COLUMN_FILE_NAME_HINT, "media_type", "total_size", "last_modified_timestamp", "bytes_so_far", com.android.providers.downloads.Downloads.Impl.COLUMN_ALLOW_WRITE, "local_uri", "reason", com.android.providers.downloads.Downloads.Impl.COLUMN_NOTIFICATION_PACKAGE, com.android.providers.downloads.Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI, "download_speed"};

    /* renamed from: b_renamed, reason: collision with root package name */
    public static final java.lang.String[] f7472b = {"_id", "_data AS_renamed local_filename", com.android.providers.downloads.Downloads.Impl.COLUMN_MEDIAPROVIDER_URI, com.android.providers.downloads.Downloads.Impl.COLUMN_DESTINATION, "title", com.android.providers.downloads.Downloads.Impl.COLUMN_DESCRIPTION, com.android.providers.downloads.Downloads.Impl.COLUMN_URI, "status", com.android.providers.downloads.Downloads.Impl.COLUMN_FILE_NAME_HINT, com.android.providers.downloads.Downloads.Impl.COLUMN_NOTIFICATION_PACKAGE, "mimetype AS_renamed media_type", "total_bytes AS_renamed total_size", "lastmod AS_renamed last_modified_timestamp", "current_bytes AS_renamed bytes_so_far", com.android.providers.downloads.Downloads.Impl.COLUMN_ALLOW_WRITE, com.android.providers.downloads.Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI, "download_speed", "'placeholder' AS_renamed local_uri", "'placeholder' AS_renamed reason"};
    private static android.os.HandlerThread e_renamed = new android.os.HandlerThread("DownloadManager");
    private android.net.Uri h_renamed = android.provider.Downloads.Impl.CONTENT_URI;
    private android.os.Handler m_renamed = new android.os.Handler(e_renamed.getLooper());

    /* compiled from: DownloadManager.java */
    public interface b_renamed {
        void a_renamed();
    }

    static {
        e_renamed.start();
        n_renamed = 0;
    }

    /* compiled from: DownloadManager.java */
    public static class e_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        static final /* synthetic */ boolean f7489a = !com.oplus.d_renamed.a_renamed.a_renamed.class.desiredAssertionStatus();

        /* renamed from: c_renamed, reason: collision with root package name */
        private android.net.Uri f7491c;
        private android.net.Uri d_renamed;
        private java.lang.CharSequence f_renamed;
        private java.lang.CharSequence g_renamed;
        private java.lang.String h_renamed;
        private android.net.Uri w_renamed;

        /* renamed from: b_renamed, reason: collision with root package name */
        private int f7490b = 0;
        private java.util.List<android.util.Pair<java.lang.String, java.lang.String>> e_renamed = new java.util.ArrayList();
        private int i_renamed = 6;
        private boolean j_renamed = true;
        private boolean k_renamed = true;
        private int l_renamed = 0;
        private boolean m_renamed = false;
        private boolean n_renamed = false;
        private boolean o_renamed = false;
        private java.lang.String p_renamed = null;
        private int q_renamed = 0;
        private boolean r_renamed = false;
        private int s_renamed = -1;
        private int t_renamed = -1;
        private long u_renamed = 0;
        private long v_renamed = -1;
        private java.lang.String x_renamed = null;
        private java.lang.String y_renamed = null;
        private int z_renamed = 1;

        public e_renamed(android.net.Uri uri) {
            if (uri == null) {
                throw new java.lang.NullPointerException();
            }
            java.lang.String scheme = uri.getScheme();
            if (scheme == null || (!scheme.equals("http") && !scheme.equals("https"))) {
                throw new java.lang.IllegalArgumentException("Can only download HTTP/HTTPS URIs: " + uri);
            }
            this.f7491c = uri;
        }

        public com.oplus.d_renamed.a_renamed.a_renamed.e_renamed a_renamed(android.net.Uri uri) {
            this.d_renamed = uri;
            return this;
        }

        public com.oplus.d_renamed.a_renamed.a_renamed.e_renamed a_renamed(java.lang.CharSequence charSequence) {
            this.f_renamed = charSequence;
            return this;
        }

        public com.oplus.d_renamed.a_renamed.a_renamed.e_renamed a_renamed(java.lang.String str) {
            this.h_renamed = str;
            return this;
        }

        public com.oplus.d_renamed.a_renamed.a_renamed.e_renamed a_renamed(int i_renamed) {
            this.i_renamed = i_renamed;
            return this;
        }

        public com.oplus.d_renamed.a_renamed.a_renamed.e_renamed a_renamed(boolean z_renamed) {
            this.j_renamed = z_renamed;
            return this;
        }

        public com.oplus.d_renamed.a_renamed.a_renamed.e_renamed b_renamed(int i_renamed) {
            this.z_renamed = i_renamed;
            return this;
        }

        public com.oplus.d_renamed.a_renamed.a_renamed.e_renamed b_renamed(java.lang.String str) {
            this.p_renamed = str;
            return this;
        }

        public com.oplus.d_renamed.a_renamed.a_renamed.e_renamed b_renamed(boolean z_renamed) {
            this.r_renamed = z_renamed;
            return this;
        }

        public com.oplus.d_renamed.a_renamed.a_renamed.e_renamed c_renamed(java.lang.String str) {
            if (!android.text.TextUtils.isEmpty(str)) {
                this.x_renamed = str;
            }
            return this;
        }

        android.content.ContentValues d_renamed(java.lang.String str) {
            android.content.ContentValues contentValues = new android.content.ContentValues();
            if (!f7489a && this.f7491c == null) {
                throw new java.lang.AssertionError();
            }
            contentValues.put(com.android.providers.downloads.Downloads.Impl.COLUMN_URI, this.f7491c.toString());
            contentValues.put(com.android.providers.downloads.Downloads.Impl.COLUMN_IS_PUBLIC_API, (java.lang.Boolean) true);
            contentValues.put(com.android.providers.downloads.Downloads.Impl.COLUMN_NOTIFICATION_PACKAGE, str);
            if (this.d_renamed != null) {
                contentValues.put(com.android.providers.downloads.Downloads.Impl.COLUMN_DESTINATION, (java.lang.Integer) 4);
                contentValues.put(com.android.providers.downloads.Downloads.Impl.COLUMN_FILE_NAME_HINT, this.d_renamed.toString());
            } else {
                contentValues.put(com.android.providers.downloads.Downloads.Impl.COLUMN_DESTINATION, java.lang.Integer.valueOf(this.n_renamed ? 5 : 2));
            }
            contentValues.put(com.android.providers.downloads.Downloads.Impl.COLUMN_MEDIA_SCANNED, java.lang.Integer.valueOf(this.m_renamed ? 0 : 2));
            if (!this.e_renamed.isEmpty()) {
                a_renamed(contentValues);
            }
            a_renamed(contentValues, "title", this.f_renamed);
            a_renamed(contentValues, com.android.providers.downloads.Downloads.Impl.COLUMN_DESCRIPTION, this.g_renamed);
            a_renamed(contentValues, com.android.providers.downloads.Downloads.Impl.COLUMN_MIME_TYPE, this.h_renamed);
            contentValues.put(com.android.providers.downloads.Downloads.Impl.COLUMN_VISIBILITY, java.lang.Integer.valueOf(this.f7490b));
            contentValues.put(com.android.providers.downloads.Downloads.Impl.COLUMN_ALLOWED_NETWORK_TYPES, java.lang.Integer.valueOf(this.i_renamed));
            contentValues.put(com.android.providers.downloads.Downloads.Impl.COLUMN_ALLOW_ROAMING, java.lang.Boolean.valueOf(this.j_renamed));
            contentValues.put(com.android.providers.downloads.Downloads.Impl.COLUMN_ALLOW_METERED, java.lang.Boolean.valueOf(this.k_renamed));
            contentValues.put(com.android.providers.downloads.Downloads.Impl.COLUMN_FLAGS, java.lang.Integer.valueOf(this.l_renamed));
            contentValues.put(com.android.providers.downloads.Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI, java.lang.Integer.valueOf(this.z_renamed));
            if (this.o_renamed) {
                contentValues.put(com.android.providers.downloads.Downloads.Impl.COLUMN_CONTROL, (java.lang.Integer) 1);
                contentValues.put("status", (java.lang.Integer) 193);
            }
            a_renamed(contentValues, "extra", this.p_renamed);
            contentValues.put(com.heytap.accessory.constant.AFConstants.EXTRA_PRIORITY, java.lang.Integer.valueOf(this.q_renamed));
            contentValues.put("relpace_file", java.lang.Boolean.valueOf(this.r_renamed));
            contentValues.put("statistics_id", java.lang.Integer.valueOf(this.s_renamed));
            contentValues.put("time_out", java.lang.Long.valueOf(this.u_renamed));
            contentValues.put("fail_retry_count", java.lang.Integer.valueOf(this.t_renamed));
            contentValues.put("time_interval_for_fail", java.lang.Long.valueOf(this.v_renamed));
            android.net.Uri uri = this.w_renamed;
            if (uri != null) {
                contentValues.put("backup_uri", uri.toString());
            }
            a_renamed(contentValues, "md5", this.x_renamed);
            a_renamed(contentValues, "header_md5", this.y_renamed);
            return contentValues;
        }

        private void a_renamed(android.content.ContentValues contentValues) {
            int i_renamed = 0;
            for (android.util.Pair<java.lang.String, java.lang.String> pair : this.e_renamed) {
                contentValues.put(com.android.providers.downloads.Downloads.Impl.RequestHeaders.INSERT_KEY_PREFIX + i_renamed, ((java.lang.String) pair.first) + ": " + ((java.lang.String) pair.second));
                i_renamed++;
            }
        }

        private void a_renamed(android.content.ContentValues contentValues, java.lang.String str, java.lang.Object obj) {
            if (obj != null) {
                contentValues.put(str, obj.toString());
            }
        }
    }

    /* compiled from: DownloadManager.java */
    public static class d_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private long[] f7486a = null;

        /* renamed from: b_renamed, reason: collision with root package name */
        private java.lang.String[] f7487b = null;

        /* renamed from: c_renamed, reason: collision with root package name */
        private java.lang.Integer f7488c = null;
        private java.lang.String d_renamed = null;
        private java.lang.String e_renamed = com.android.providers.downloads.Downloads.Impl.COLUMN_LAST_MODIFICATION;
        private int f_renamed = 2;
        private boolean g_renamed = false;
        private boolean h_renamed = false;
        private java.lang.String[] i_renamed = null;
        private java.lang.String j_renamed = null;
        private java.lang.String[] k_renamed = null;

        public com.oplus.d_renamed.a_renamed.a_renamed.d_renamed a_renamed(long... jArr) {
            this.f7486a = jArr;
            return this;
        }

        public com.oplus.d_renamed.a_renamed.a_renamed.d_renamed a_renamed(java.lang.String... strArr) {
            this.k_renamed = strArr;
            return this;
        }

        public com.oplus.d_renamed.a_renamed.a_renamed.d_renamed b_renamed(java.lang.String... strArr) {
            this.f7487b = strArr;
            com.oplus.d_renamed.a_renamed.a_renamed.c_renamed(this.f7487b);
            return this;
        }

        public java.lang.String[] a_renamed() {
            java.lang.String[] strArr = this.i_renamed;
            if (strArr != null) {
                return strArr;
            }
            if (e_renamed()) {
                return com.oplus.d_renamed.a_renamed.a_renamed.f7471a;
            }
            return com.oplus.d_renamed.a_renamed.a_renamed.f7472b;
        }

        private boolean e_renamed() {
            return com.oplus.d_renamed.a_renamed.a_renamed.n_renamed > 0;
        }

        android.database.Cursor a_renamed(android.content.ContentResolver contentResolver, android.net.Uri uri) {
            try {
                return contentResolver.query(uri, a_renamed(), b_renamed(), d_renamed(), c_renamed());
            } catch (java.lang.Exception e_renamed) {
                com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.d_renamed("DownloadManager", "runQuery, occur exception. e_renamed = " + e_renamed.getMessage());
                return null;
            }
        }

        public java.lang.String b_renamed() {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            long[] jArr = this.f7486a;
            if (jArr != null) {
                arrayList.add(com.oplus.d_renamed.a_renamed.a_renamed.b_renamed(jArr));
            }
            java.lang.String[] strArr = this.k_renamed;
            if (strArr != null) {
                arrayList.add(com.oplus.d_renamed.a_renamed.a_renamed.e_renamed(strArr));
            }
            if (com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.f7477a) {
                com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.a_renamed("DownloadManager", "getSelection , mPackageNames = " + java.util.Arrays.toString(this.f7487b) + ", this = " + this);
            }
            java.lang.String[] strArr2 = this.f7487b;
            if (strArr2 != null) {
                arrayList.add(com.oplus.d_renamed.a_renamed.a_renamed.d_renamed(strArr2));
            }
            if (this.f7488c != null) {
                java.util.ArrayList arrayList2 = new java.util.ArrayList();
                if ((this.f7488c.intValue() & 1) != 0) {
                    arrayList2.add(a_renamed("=", 190));
                }
                if ((this.f7488c.intValue() & 2) != 0) {
                    arrayList2.add(a_renamed("=", 192));
                }
                if ((this.f7488c.intValue() & 4) != 0) {
                    arrayList2.add(a_renamed("=", 193));
                    arrayList2.add(a_renamed("=", 194));
                    arrayList2.add(a_renamed("=", 195));
                    arrayList2.add(a_renamed("=", 196));
                    arrayList2.add(a_renamed("=", 198));
                }
                if ((this.f7488c.intValue() & 8) != 0) {
                    arrayList2.add(a_renamed("=", 200));
                }
                if ((this.f7488c.intValue() & 16) != 0) {
                    arrayList2.add("(" + a_renamed(">=", 400) + " AND " + a_renamed("<", 600) + ")");
                    arrayList2.add(a_renamed("=", 199));
                }
                if (arrayList2.size() > 0) {
                    arrayList.add("(" + a_renamed(" OR ", arrayList2) + ")");
                }
            }
            if (this.h_renamed) {
                arrayList.add("is_visible_in_downloads_ui != '0'");
            } else if (this.g_renamed) {
                arrayList.add("is_visible_in_downloads_ui = '1'");
            }
            arrayList.add("deleted != '1'");
            if (!android.text.TextUtils.isEmpty(this.j_renamed)) {
                arrayList.add("uri = '" + this.j_renamed + "'");
            }
            java.lang.String strA = a_renamed(" AND ", arrayList);
            if (com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.f7477a) {
                com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.a_renamed("DownloadManager", "getSelection. selection = " + strA);
            }
            return strA;
        }

        public java.lang.String c_renamed() {
            return this.e_renamed + " " + (this.f_renamed == 1 ? "ASC" : "DESC");
        }

        public java.lang.String[] d_renamed() {
            java.lang.String[] strArrC = new java.lang.String[0];
            java.lang.String[] strArr = new java.lang.String[0];
            java.lang.String[] strArr2 = new java.lang.String[0];
            long[] jArr = this.f7486a;
            if (jArr != null) {
                strArrC = com.oplus.d_renamed.a_renamed.a_renamed.c_renamed(jArr);
            }
            java.lang.String[] strArr3 = this.k_renamed;
            if (strArr3 != null) {
                strArr = strArr3;
            }
            java.lang.String[] strArr4 = this.f7487b;
            if (strArr4 != null) {
                strArr2 = strArr4;
            }
            java.lang.String[] strArrA = a_renamed(strArrC, strArr, strArr2);
            com.oplus.d_renamed.a_renamed.a_renamed.c_renamed(strArrA);
            return strArrA;
        }

        private java.lang.String a_renamed(java.lang.String str, java.lang.Iterable<java.lang.String> iterable) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            boolean z_renamed = true;
            for (java.lang.String str2 : iterable) {
                if (!z_renamed) {
                    sb.append(str);
                }
                sb.append(str2);
                z_renamed = false;
            }
            return sb.toString();
        }

        private java.lang.String a_renamed(java.lang.String str, int i_renamed) {
            return "status" + str + "'" + i_renamed + "'";
        }

        public java.lang.String[] a_renamed(java.lang.String[] strArr, java.lang.String[]... strArr2) {
            if (strArr == null || strArr2 == null) {
                return null;
            }
            int length = strArr.length;
            for (java.lang.String[] strArr3 : strArr2) {
                if (strArr3 != null && strArr3.length > 0) {
                    length += strArr3.length;
                }
            }
            java.lang.String[] strArr4 = (java.lang.String[]) java.util.Arrays.copyOf(strArr, length);
            int length2 = strArr.length;
            for (java.lang.String[] strArr5 : strArr2) {
                if (strArr5 != null && strArr5.length > 0) {
                    java.lang.System.arraycopy(strArr5, 0, strArr4, length2, strArr5.length);
                    length2 += strArr5.length;
                }
            }
            return strArr4;
        }
    }

    public static com.oplus.d_renamed.a_renamed.a_renamed a_renamed(android.content.Context context) {
        return a_renamed(context, (java.lang.String) null);
    }

    public static synchronized com.oplus.d_renamed.a_renamed.a_renamed a_renamed(android.content.Context context, java.lang.String str) {
        if (d_renamed == null) {
            d_renamed = new com.oplus.d_renamed.a_renamed.a_renamed(context.getApplicationContext(), str);
        }
        return d_renamed;
    }

    private a_renamed(android.content.Context context, java.lang.String str) {
        if (context == null) {
            throw new java.lang.IllegalArgumentException("The context and resolver can't_renamed be_renamed null !");
        }
        this.f_renamed = context.getContentResolver();
        java.lang.String packageName = context.getPackageName();
        if (b_renamed(context).equalsIgnoreCase(packageName)) {
            this.g_renamed = null;
        } else {
            this.g_renamed = android.text.TextUtils.isEmpty(str) ? packageName : str;
        }
        if (com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.f7477a) {
            com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.b_renamed("DownloadManager", "DownloadManager. mPackageName = " + this.g_renamed);
        }
        this.i_renamed = context.getApplicationInfo().targetSdkVersion < 23;
        try {
            n_renamed = context.getPackageManager().getApplicationInfo("com.android.providers.downloads", 128).metaData.getInt("provider_version");
        } catch (java.lang.Exception e2) {
            com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.d_renamed("DownloadManager", "DownloadManager,exception: " + e2);
        }
    }

    @android.compat.annotation.UnsupportedAppUsage(maxTargetSdk = 28, trackingBug = 115609023)
    public void a_renamed(boolean z_renamed) {
        this.i_renamed = z_renamed;
    }

    public java.lang.String a_renamed(com.oplus.d_renamed.a_renamed.a_renamed.e_renamed eVar) {
        try {
            android.net.Uri uriInsert = this.f_renamed.insert(android.provider.Downloads.Impl.CONTENT_URI, eVar.d_renamed(this.g_renamed));
            if (uriInsert == null) {
                com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.d_renamed("DownloadManager", "enqueue, downloadUri = null, return -1.");
                return null;
            }
            return a_renamed(java.lang.Long.parseLong(uriInsert.getLastPathSegment()));
        } catch (java.lang.Exception e2) {
            com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.d_renamed("DownloadManager", "enqueueWithUuid, occur exception. e_renamed = " + e2.getMessage());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:16:0x0052 A_renamed[PHI: r11
      0x0052: PHI (r11v6 android.database.Cursor) = (r11v5 android.database.Cursor), (r11v7 android.database.Cursor) binds: [B_renamed:22:0x0073, B_renamed:15:0x0050] A_renamed[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:27:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String a_renamed(long r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.String r0 = "uuid"
            java.lang.String r1 = "DownloadManager"
            r2 = 1
            r3 = 0
            long[] r2 = new long[r2]     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L59
            r4 = 0
            r2[r4] = r12     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L59
            java.lang.String[] r7 = new java.lang.String[]{r0}     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L59
            android.content.ContentResolver r5 = r11.f_renamed     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L59
            android.net.Uri r6 = r11.h_renamed     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L59
            java.lang.String r8 = b_renamed(r2)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L59
            java.lang.String[] r9 = c_renamed(r2)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L59
            r10 = 0
            android.database.Cursor r11 = r5.query(r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L59
            if (r11 == 0) goto L50
            boolean r12 = r11.moveToFirst()     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L77
            if (r12 == 0) goto L50
            int r12 = r11.getColumnIndex(r0)     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L77
            java.lang.String r12 = r11.getString(r12)     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L77
            boolean r13 = com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.f7477a     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L77
            if (r13 == 0) goto L48
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L77
            r13.<init>()     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L77
            java.lang.String r0 = "enqueueWithUuid, uuid ="
            r13.append(r0)     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L77
            r13.append(r12)     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L77
            java.lang.String r13 = r13.toString()     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L77
            com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.a_renamed(r1, r13)     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L77
        L48:
            if (r11 == 0) goto L4d
            r11.close()
        L4d:
            return r12
        L4e:
            r12 = move-exception
            goto L5b
        L50:
            if (r11 == 0) goto L76
        L52:
            r11.close()
            goto L76
        L56:
            r12 = move-exception
            r11 = r3
            goto L78
        L59:
            r12 = move-exception
            r11 = r3
        L5b:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L77
            r13.<init>()     // Catch: java.lang.Throwable -> L77
            java.lang.String r0 = "exception = "
            r13.append(r0)     // Catch: java.lang.Throwable -> L77
            java.lang.String r12 = r12.getMessage()     // Catch: java.lang.Throwable -> L77
            r13.append(r12)     // Catch: java.lang.Throwable -> L77
            java.lang.String r12 = r13.toString()     // Catch: java.lang.Throwable -> L77
            com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.d_renamed(r1, r12)     // Catch: java.lang.Throwable -> L77
            if (r11 == 0) goto L76
            goto L52
        L76:
            return r3
        L77:
            r12 = move-exception
        L78:
            if (r11 == 0) goto L7d
            r11.close()
        L7d:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.d_renamed.a_renamed.a_renamed.a_renamed(long):java.lang.String");
    }

    public android.database.Cursor a_renamed(com.oplus.d_renamed.a_renamed.a_renamed.d_renamed dVar) {
        return a_renamed(dVar, f7471a);
    }

    public android.database.Cursor a_renamed(com.oplus.d_renamed.a_renamed.a_renamed.d_renamed dVar, java.lang.String[] strArr) {
        android.database.Cursor cursorA = dVar.a_renamed(this.f_renamed, this.h_renamed);
        if (cursorA == null) {
            return null;
        }
        return new com.oplus.d_renamed.a_renamed.a_renamed.DownloadManager_6(cursorA, this.h_renamed, this.i_renamed);
    }

    public int a_renamed(java.lang.String... strArr) {
        android.database.Cursor cursorA = null;
        try {
            try {
                cursorA = a_renamed(new com.oplus.d_renamed.a_renamed.a_renamed.d_renamed().a_renamed(strArr));
            } catch (java.lang.RuntimeException e2) {
                com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.c_renamed("DownloadManager", "Exception happened in_renamed restartDownload: " + e2);
                if (0 != 0) {
                }
            }
            if (cursorA == null) {
                return 0;
            }
            cursorA.moveToFirst();
            while (!cursorA.isAfterLast()) {
                int i_renamed = cursorA.getInt(cursorA.getColumnIndex("status"));
                if (i_renamed != 8 && i_renamed != 16) {
                    com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.c_renamed("DownloadManager", "restartDownloadWithUuid Cannot restart incomplete downloadid = " + cursorA.getLong(cursorA.getColumnIndex("_id")));
                    if (cursorA != null) {
                        cursorA.close();
                    }
                    return 0;
                }
                cursorA.moveToNext();
            }
            if (cursorA != null) {
                cursorA.close();
            }
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put(com.android.providers.downloads.Downloads.Impl.COLUMN_CURRENT_BYTES, (java.lang.Integer) 0);
            contentValues.put(com.android.providers.downloads.Downloads.Impl.COLUMN_TOTAL_BYTES, (java.lang.Integer) (-1));
            contentValues.putNull(com.android.providers.downloads.Downloads.Impl._DATA);
            contentValues.put(com.android.providers.downloads.Downloads.Impl.COLUMN_CONTROL, (java.lang.Integer) 0);
            contentValues.put("status", (java.lang.Integer) 190);
            contentValues.put(com.android.providers.downloads.Downloads.Impl.COLUMN_FAILED_CONNECTIONS, (java.lang.Integer) 0);
            return this.f_renamed.update(this.h_renamed, contentValues, e_renamed(strArr), strArr);
        } finally {
            if (0 != 0) {
                cursorA.close();
            }
        }
    }

    public int b_renamed(java.lang.String... strArr) {
        if (strArr == null || strArr.length == 0) {
            com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.c_renamed("DownloadManager", "resumeDownloadWithUuid input param 'uuids' can't_renamed be_renamed null");
            return 0;
        }
        if (com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.f7477a) {
            com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.b_renamed("DownloadManager", "resumeDownloadWithUuid dumpArray= " + java.util.Arrays.toString(strArr));
        }
        java.lang.String[] strArr2 = {com.android.providers.downloads.Downloads.Impl.COLUMN_CONTROL, "status", com.heytap.accessory.constant.AFConstants.EXTRA_UUID};
        java.util.ArrayList arrayList = new java.util.ArrayList(strArr.length);
        android.database.Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.f_renamed.query(this.h_renamed, strArr2, e_renamed(strArr), strArr, null);
            } catch (java.lang.RuntimeException e2) {
                com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.c_renamed("DownloadManager", "Exception happened in_renamed getUriForDownloadedFile: " + e2);
                if (0 != 0) {
                }
            }
            if (cursorQuery == null) {
                com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.c_renamed("DownloadManager", "resumeDownloadWithUuid return 0!");
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return 0;
            }
            if (com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.f7477a) {
                com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.b_renamed("DownloadManager", "resumeDownloadWithUuid cursor.getCount() = " + cursorQuery.getCount());
            }
            cursorQuery.moveToFirst();
            while (!cursorQuery.isAfterLast()) {
                java.lang.String string = cursorQuery.getString(cursorQuery.getColumnIndex(com.heytap.accessory.constant.AFConstants.EXTRA_UUID));
                int i_renamed = cursorQuery.getInt(cursorQuery.getColumnIndex("status"));
                int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex(com.android.providers.downloads.Downloads.Impl.COLUMN_CONTROL));
                if (((android.provider.Downloads.Impl.isStatusCompleted(i_renamed) || i_renamed == 199) || i2 == 0) && i_renamed != 193 && i_renamed != 194 && i_renamed != 195 && i_renamed != 196 && i_renamed != 198) {
                    com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.c_renamed("DownloadManager", "resumeDownloadWithUuid Cannot resume a_renamed completed task. id_renamed = " + string + ", stauts = " + i_renamed);
                } else {
                    arrayList.add(string);
                }
                cursorQuery.moveToNext();
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            int size = arrayList.size();
            if (size <= 0) {
                com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.c_renamed("DownloadManager", "resumeDownloadWithUuid resumeIdList size <= 0, return.");
                return 0;
            }
            if (com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.f7477a) {
                com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.b_renamed("DownloadManager", "resumeDownloadWithUuid resumeIdList = " + arrayList);
            }
            android.content.ContentValues contentValues = new android.content.ContentValues();
            contentValues.put(com.android.providers.downloads.Downloads.Impl.COLUMN_CONTROL, (java.lang.Integer) 0);
            contentValues.put("status", (java.lang.Integer) 190);
            contentValues.put(com.android.providers.downloads.Downloads.Impl.COLUMN_FAILED_CONNECTIONS, (java.lang.Integer) 0);
            java.lang.String[] strArr3 = (java.lang.String[]) arrayList.toArray(new java.lang.String[size]);
            return this.f_renamed.update(this.h_renamed, contentValues, e_renamed(strArr3), strArr3);
        } catch (java.lang.Throwable th) {
            if (0 != 0) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public int a_renamed(int i_renamed, java.lang.String... strArr) {
        if (strArr == null || strArr.length == 0) {
            throw new java.lang.IllegalArgumentException("setAllowedNetworkTypesWithUuid input param 'uuids' can't_renamed be_renamed null");
        }
        android.content.ContentValues contentValues = new android.content.ContentValues();
        contentValues.put(com.android.providers.downloads.Downloads.Impl.COLUMN_ALLOWED_NETWORK_TYPES, java.lang.Integer.valueOf(i_renamed));
        return this.f_renamed.update(this.h_renamed, contentValues, e_renamed(strArr), strArr);
    }

    public java.util.List<com.android.providers.downloads.DownloadInfoData> a_renamed(long... jArr) {
        a_renamed(true);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.oplus.d_renamed.a_renamed.a_renamed.d_renamed dVar = new com.oplus.d_renamed.a_renamed.a_renamed.d_renamed();
        dVar.a_renamed(jArr);
        if (com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.f7477a) {
            com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.a_renamed("DownloadManager", "getDownloadData -array-  mPackageName = " + this.g_renamed);
        }
        if (!android.text.TextUtils.isEmpty(this.g_renamed)) {
            dVar.b_renamed(this.g_renamed);
        }
        android.database.Cursor cursorA = null;
        try {
            try {
                cursorA = a_renamed(dVar);
                int count = cursorA.getCount();
                if (com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.f7477a) {
                    com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.a_renamed("DownloadManager", "getDownloadData  c_renamed.getCount() = " + count);
                }
                if (count > 0 && cursorA.moveToFirst()) {
                    do {
                        arrayList.add(new com.android.providers.downloads.DownloadInfoData.BaseReader(this.f_renamed, cursorA).newDownloadInfoSimple());
                    } while (cursorA.moveToNext());
                }
            } catch (java.lang.Exception e2) {
                com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.d_renamed("DownloadManager", "exception = " + e2.getMessage());
                if (cursorA != null) {
                }
            }
            return arrayList;
        } finally {
            if (cursorA != null) {
                cursorA.close();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B_renamed:21:0x006f A_renamed[PHI: r1
      0x006f: PHI (r1v6 android.database.Cursor) = (r1v5 android.database.Cursor), (r1v7 android.database.Cursor) binds: [B_renamed:31:0x0094, B_renamed:20:0x006d] A_renamed[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:35:0x009a  */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.oplus.d_renamed.a_renamed.a_renamed$d_renamed] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.oplus.d_renamed.a_renamed.a_renamed] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.android.providers.downloads.DownloadInfoData a_renamed(java.lang.String r5) throws java.lang.Throwable {
        /*
            r4 = this;
            java.lang.String r0 = "DownloadManager"
            r1 = 1
            r4.a_renamed(r1)
            com.oplus.d_renamed.a_renamed.a_renamed$d_renamed r2 = new com.oplus.d_renamed.a_renamed.a_renamed$d_renamed
            r2.<init>()
            java.lang.String[] r1 = new java.lang.String[r1]
            r3 = 0
            r1[r3] = r5
            r2.a_renamed(r1)
            r5 = 0
            android.database.Cursor r1 = r4.a_renamed(r2)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L7a
            boolean r2 = com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.f7477a     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            if (r2 == 0) goto L3c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            r2.<init>()     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            java.lang.String r3 = "getDownloadDataWithUuid  c_renamed.getCount() = "
            r2.append(r3)     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            if (r1 == 0) goto L31
            int r3 = r1.getCount()     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            goto L32
        L31:
            r3 = r5
        L32:
            r2.append(r3)     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.a_renamed(r0, r2)     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
        L3c:
            if (r1 == 0) goto L6d
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            if (r2 == 0) goto L6d
            com.android.providers.downloads.DownloadInfoData$BaseReader r2 = new com.android.providers.downloads.DownloadInfoData$BaseReader     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            android.content.ContentResolver r4 = r4.f_renamed     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            r2.<init>(r4, r1)     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            com.android.providers.downloads.DownloadInfoData r4 = r2.newDownloadInfoSimple()     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            boolean r2 = com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.f7477a     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            if (r2 == 0) goto L67
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            r2.<init>()     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            java.lang.String r3 = "getDownloadDataWithUuid. info = "
            r2.append(r3)     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            r2.append(r4)     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.a_renamed(r0, r2)     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
        L67:
            if (r1 == 0) goto L6c
            r1.close()
        L6c:
            return r4
        L6d:
            if (r1 == 0) goto L97
        L6f:
            r1.close()
            goto L97
        L73:
            r4 = move-exception
            goto L98
        L75:
            r4 = move-exception
            goto L7c
        L77:
            r4 = move-exception
            r1 = r5
            goto L98
        L7a:
            r4 = move-exception
            r1 = r5
        L7c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L73
            r2.<init>()     // Catch: java.lang.Throwable -> L73
            java.lang.String r3 = "exception = "
            r2.append(r3)     // Catch: java.lang.Throwable -> L73
            java.lang.String r4 = r4.getMessage()     // Catch: java.lang.Throwable -> L73
            r2.append(r4)     // Catch: java.lang.Throwable -> L73
            java.lang.String r4 = r2.toString()     // Catch: java.lang.Throwable -> L73
            com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.d_renamed(r0, r4)     // Catch: java.lang.Throwable -> L73
            if (r1 == 0) goto L97
            goto L6f
        L97:
            return r5
        L98:
            if (r1 == 0) goto L9d
            r1.close()
        L9d:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.d_renamed.a_renamed.a_renamed.a_renamed(java.lang.String):com.android.providers.downloads.DownloadInfoData");
    }

    public void a_renamed(com.oplus.d_renamed.a_renamed.b_renamed bVar) {
        this.j_renamed = bVar;
        c_renamed();
        if (com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.f7477a) {
            com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.b_renamed("DownloadManager", "registerDownloadStatesCallback  mDownloadStatesCallback = " + this.j_renamed);
        }
    }

    public void a_renamed() {
        this.j_renamed = null;
        d_renamed();
        if (com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.f7477a) {
            com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.b_renamed("DownloadManager", "unregisterDownloadStatesCallback  mDownloadStatesCallback = " + this.j_renamed);
        }
    }

    private synchronized void c_renamed() {
        if (this.l_renamed == null) {
            this.l_renamed = new com.oplus.d_renamed.a_renamed.a_renamed.c_renamed(null);
            this.f_renamed.registerContentObserver(com.oplus.d_renamed.a_renamed.c_renamed.f7496b, true, this.l_renamed);
            this.f_renamed.registerContentObserver(com.oplus.d_renamed.a_renamed.c_renamed.f7495a, true, this.l_renamed);
        }
    }

    private synchronized void d_renamed() {
        if (this.l_renamed != null) {
            this.f_renamed.unregisterContentObserver(this.l_renamed);
            this.l_renamed = null;
        }
    }

    /* compiled from: DownloadManager.java */
    class c_renamed extends android.database.ContentObserver {
        public c_renamed(android.os.Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z_renamed) {
            onChange(z_renamed, null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z_renamed, final android.net.Uri uri) {
            if (com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.f7477a) {
                com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.a_renamed("DownloadManager", "onChange run, uri = " + uri);
            }
            if (com.oplus.d_renamed.a_renamed.a_renamed.this.k_renamed != null) {
                com.oplus.d_renamed.a_renamed.a_renamed.this.k_renamed.a_renamed();
                return;
            }
            if (uri != null) {
                if (com.oplus.d_renamed.a_renamed.a_renamed.this.j_renamed != null) {
                    com.oplus.d_renamed.a_renamed.a_renamed.this.m_renamed.post(new java.lang.Runnable() { // from class: com.oplus.d_renamed.a_renamed.a_renamed.c_renamed.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.f7477a) {
                                com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.a_renamed("DownloadManager", "onChange run, start! mPackageName=" + com.oplus.d_renamed.a_renamed.a_renamed.this.g_renamed + "/uri = " + uri);
                            }
                            if (uri.getPathSegments().size() > 2) {
                                java.lang.String string = uri.toString();
                                java.lang.String str = "insert";
                                if (!string.contains("insert")) {
                                    if (string.contains("update")) {
                                        str = "update";
                                    } else if (string.contains("delete")) {
                                        str = "delete";
                                    } else {
                                        if (!string.contains("timeout")) {
                                            com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.d_renamed("DownloadManager", "onChange type error uriString = " + string);
                                            return;
                                        }
                                        str = "timeout";
                                    }
                                }
                                java.lang.String[] strArrSplit = uri.getLastPathSegment().split("-");
                                if (com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.f7477a) {
                                    com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.a_renamed("DownloadManager", "onChange run, changeType = " + str + java.util.Arrays.toString(strArrSplit));
                                }
                                if (strArrSplit == null || strArrSplit.length <= 0) {
                                    com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.d_renamed("DownloadManager", "onChange error no valid id_renamed");
                                    return;
                                }
                                try {
                                    if (str.equalsIgnoreCase("delete")) {
                                        java.util.ArrayList arrayList = new java.util.ArrayList();
                                        for (java.lang.String str2 : strArrSplit) {
                                            int iIndexOf = str2.indexOf(124);
                                            com.android.providers.downloads.DownloadInfoData downloadInfoData = new com.android.providers.downloads.DownloadInfoData();
                                            downloadInfoData.mId = java.lang.Long.parseLong(str2.substring(0, iIndexOf));
                                            downloadInfoData.mUuid = str2.substring(iIndexOf + 1);
                                            arrayList.add(downloadInfoData);
                                        }
                                        if (com.oplus.d_renamed.a_renamed.a_renamed.this.j_renamed != null) {
                                            com.oplus.d_renamed.a_renamed.a_renamed.this.j_renamed.c_renamed(arrayList);
                                            return;
                                        } else {
                                            com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.d_renamed("DownloadManager", "onChange return mDownloadStatesCallback  is_renamed null");
                                            return;
                                        }
                                    }
                                    long[] jArr = new long[strArrSplit.length];
                                    for (int i_renamed = 0; i_renamed < strArrSplit.length; i_renamed++) {
                                        java.lang.Long lValueOf = java.lang.Long.valueOf(java.lang.Long.parseLong(strArrSplit[i_renamed]));
                                        jArr[i_renamed] = lValueOf.longValue();
                                        if (com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.f7477a) {
                                            com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.a_renamed("DownloadManager", "onChange run, split i_renamed = " + i_renamed + "/ id_renamed =" + lValueOf);
                                        }
                                    }
                                    java.util.List<com.android.providers.downloads.DownloadInfoData> listA = com.oplus.d_renamed.a_renamed.a_renamed.this.a_renamed(jArr);
                                    if (listA == null || listA.size() <= 0) {
                                        return;
                                    }
                                    com.oplus.d_renamed.a_renamed.a_renamed.c_renamed.this.a_renamed(listA, str);
                                    return;
                                } catch (java.lang.Exception e_renamed) {
                                    com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.d_renamed("DownloadManager", "exception = " + e_renamed.getMessage());
                                    return;
                                }
                            }
                            com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.d_renamed("DownloadManager", "onChange run, pathSegments.size <= 2, uri has't_renamed downloadid");
                        }
                    });
                    return;
                } else {
                    com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.d_renamed("DownloadManager", "onChange error mDownloadStatesCallback = null, return.");
                    return;
                }
            }
            com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.d_renamed("DownloadManager", "onChange error uri = null, return.");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a_renamed(java.util.List<com.android.providers.downloads.DownloadInfoData> list, java.lang.String str) {
            if (list.get(0).mPackage != null) {
                if (com.oplus.d_renamed.a_renamed.a_renamed.this.g_renamed != null && !list.get(0).mPackage.equals(com.oplus.d_renamed.a_renamed.a_renamed.this.g_renamed)) {
                    com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.d_renamed("DownloadManager", "handleDownloadInfo list downloadInfo.mPackage = " + list.get(0).mPackage + ". is_renamed not equal " + com.oplus.d_renamed.a_renamed.a_renamed.this.g_renamed);
                    return;
                }
                if (com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.f7477a) {
                    com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.a_renamed("DownloadManager", "handleDownloadInfo.list downloadInfos.size = " + list.size());
                }
                if (com.oplus.d_renamed.a_renamed.a_renamed.this.j_renamed != null) {
                    if (str.equalsIgnoreCase("insert")) {
                        com.oplus.d_renamed.a_renamed.a_renamed.this.j_renamed.a_renamed(list);
                        return;
                    } else if (str.equalsIgnoreCase("update")) {
                        com.oplus.d_renamed.a_renamed.a_renamed.this.j_renamed.b_renamed(list);
                        return;
                    } else {
                        if (str.equalsIgnoreCase("timeout")) {
                            com.oplus.d_renamed.a_renamed.a_renamed.this.j_renamed.d_renamed(list);
                            return;
                        }
                        return;
                    }
                }
                com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.d_renamed("DownloadManager", "handleDownloadInfo list mDownloadStatesCallback = null");
                return;
            }
            com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.d_renamed("DownloadManager", "downloadInfo.mPackage = null, return");
        }
    }

    public static void c_renamed(java.lang.String[] strArr) {
        com.oplus.d_renamed.a_renamed.a_renamed.a_renamed.b_renamed("DownloadManager", "dumpArray array= " + java.util.Arrays.toString(strArr));
    }

    private static java.lang.String b_renamed(android.content.Context context) {
        android.content.pm.PackageManager packageManager = context.getPackageManager();
        java.util.List<android.content.pm.ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(new android.content.Intent("coloros.intent.action.VIEW_DOWNLOADS"), 65536);
        if (listQueryIntentActivities != null && listQueryIntentActivities.size() > 0) {
            return listQueryIntentActivities.get(0).activityInfo.packageName;
        }
        java.util.List<android.content.pm.ResolveInfo> listQueryIntentActivities2 = packageManager.queryIntentActivities(new android.content.Intent("com.oplus.providers.downloads.ui.intent.action.VIEW_DOWNLOADS"), 65536);
        return (listQueryIntentActivities2 == null || listQueryIntentActivities2.size() <= 0) ? "com.coloros.providers.downloads.ui" : listQueryIntentActivities2.get(0).activityInfo.packageName;
    }

    static java.lang.String d_renamed(java.lang.String[] strArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("(");
        for (int i_renamed = 0; i_renamed < strArr.length; i_renamed++) {
            if (i_renamed > 0) {
                sb.append("OR ");
            }
            sb.append(com.android.providers.downloads.Downloads.Impl.COLUMN_NOTIFICATION_PACKAGE);
            sb.append(" = ? ");
        }
        sb.append(")");
        return sb.toString();
    }

    @android.compat.annotation.UnsupportedAppUsage
    static java.lang.String b_renamed(long[] jArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("(");
        for (int i_renamed = 0; i_renamed < jArr.length; i_renamed++) {
            if (i_renamed > 0) {
                sb.append("OR ");
            }
            sb.append("_id");
            sb.append(" = ? ");
        }
        sb.append(")");
        return sb.toString();
    }

    static java.lang.String e_renamed(java.lang.String[] strArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("(");
        for (int i_renamed = 0; i_renamed < strArr.length; i_renamed++) {
            if (i_renamed > 0) {
                sb.append("OR ");
            }
            sb.append(com.heytap.accessory.constant.AFConstants.EXTRA_UUID);
            sb.append(" = ? ");
        }
        sb.append(")");
        return sb.toString();
    }

    @android.compat.annotation.UnsupportedAppUsage
    static java.lang.String[] c_renamed(long[] jArr) {
        return a_renamed(jArr, new java.lang.String[jArr.length]);
    }

    static java.lang.String[] a_renamed(long[] jArr, java.lang.String[] strArr) {
        if (!f7473c && strArr.length < jArr.length) {
            throw new java.lang.AssertionError();
        }
        for (int i_renamed = 0; i_renamed < jArr.length; i_renamed++) {
            strArr[i_renamed] = java.lang.Long.toString(jArr[i_renamed]);
        }
        return strArr;
    }

    /* compiled from: DownloadManager.java */
    /* renamed from: com.oplus.d_renamed.a_renamed.a_renamed$a_renamed, reason: collision with other inner class name */
    public static class DownloadManager_6 extends android.database.CursorWrapper {

        /* renamed from: a_renamed, reason: collision with root package name */
        static final /* synthetic */ boolean f7480a = !com.oplus.d_renamed.a_renamed.a_renamed.class.desiredAssertionStatus();

        /* renamed from: b_renamed, reason: collision with root package name */
        private final android.net.Uri f7481b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private final boolean f7482c;

        private static long c_renamed(int i_renamed) {
            switch (i_renamed) {
                case 193:
                    return 5L;
                case 194:
                    return 1L;
                case 195:
                    return 2L;
                case 196:
                    return 3L;
                case 197:
                default:
                    return 4L;
                case 198:
                    return 6L;
            }
        }

        private static long d_renamed(int i_renamed) {
            if ((400 <= i_renamed && i_renamed < 488) || (500 <= i_renamed && i_renamed < 600)) {
                return (400 > i_renamed || i_renamed >= 488) ? 1011L : 1012L;
            }
            if (i_renamed == 198) {
                return 1006L;
            }
            if (i_renamed == 199) {
                return 1007L;
            }
            if (i_renamed == 488) {
                return 1009L;
            }
            if (i_renamed == 489) {
                return 1008L;
            }
            if (i_renamed == 497) {
                return 1005L;
            }
            switch (i_renamed) {
                case com.android.providers.downloads.Downloads.Impl.STATUS_FILE_ERROR /* 492 */:
                    return 1001L;
                case com.android.providers.downloads.Downloads.Impl.STATUS_UNHANDLED_REDIRECT /* 493 */:
                case com.android.providers.downloads.Downloads.Impl.STATUS_UNHANDLED_HTTP_CODE /* 494 */:
                    return 1002L;
                case com.android.providers.downloads.Downloads.Impl.STATUS_HTTP_DATA_ERROR /* 495 */:
                    return 1004L;
                default:
                    return 1000L;
            }
        }

        public DownloadManager_6(android.database.Cursor cursor, android.net.Uri uri, boolean z_renamed) {
            super(cursor);
            this.f7481b = uri;
            this.f7482c = z_renamed;
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public int getInt(int i_renamed) {
            if (getColumnName(i_renamed).equals("reason")) {
                return (int) a_renamed(super.getInt(getColumnIndex("status")));
            }
            if (getColumnName(i_renamed).equals("status")) {
                return b_renamed(super.getInt(getColumnIndex("status")));
            }
            if (getColumnName(i_renamed).equals("status_detailed")) {
                return super.getInt(getColumnIndex("status"));
            }
            return super.getInt(i_renamed);
        }

        /* JADX WARN: Removed duplicated region for block: B_renamed:13:0x0028  */
        @Override // android.database.CursorWrapper, android.database.Cursor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.String getString(int r5) {
            /*
                r4 = this;
                java.lang.String r0 = r4.getColumnName(r5)
                int r1 = r0.hashCode()
                r2 = -1204869480(0xffffffffb82f2698, float:-4.1759195E-5)
                r3 = 1
                if (r1 == r2) goto L1e
                r2 = 22072411(0x150cc5b, float:3.8350184E-38)
                if (r1 == r2) goto L14
                goto L28
            L14:
                java.lang.String r1 = "local_filename"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L28
                r0 = r3
                goto L29
            L1e:
                java.lang.String r1 = "local_uri"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L28
                r0 = 0
                goto L29
            L28:
                r0 = -1
            L29:
                if (r0 == 0) goto L43
                if (r0 == r3) goto L32
                java.lang.String r4 = super.getString(r5)
                return r4
            L32:
                boolean r0 = r4.f7482c
                if (r0 == 0) goto L3b
                java.lang.String r4 = super.getString(r5)
                return r4
            L3b:
                java.lang.SecurityException r4 = new java.lang.SecurityException
                java.lang.String r5 = "COLUMN_LOCAL_FILENAME is_renamed deprecated; use ContentResolver.openFileDescriptor() instead"
                r4.<init>(r5)
                throw r4
            L43:
                java.lang.String r4 = r4.a_renamed()
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oplus.d_renamed.a_renamed.a_renamed.DownloadManager_6.getString(int):java.lang.String");
        }

        private java.lang.String a_renamed() {
            long j_renamed = getLong(getColumnIndex(com.android.providers.downloads.Downloads.Impl.COLUMN_DESTINATION));
            if (j_renamed == 4 || j_renamed == 0 || j_renamed == 6) {
                java.lang.String string = super.getString(getColumnIndex("local_filename"));
                if (string == null) {
                    return null;
                }
                return android.net.Uri.fromFile(new java.io.File(string)).toString();
            }
            return android.content.ContentUris.withAppendedId(android.provider.Downloads.Impl.ALL_DOWNLOADS_CONTENT_URI, getLong(getColumnIndex("_id"))).toString();
        }

        public static long a_renamed(int i_renamed) {
            int iB = b_renamed(i_renamed);
            if (iB == 4) {
                return c_renamed(i_renamed);
            }
            if (iB != 16) {
                return 0L;
            }
            return d_renamed(i_renamed);
        }

        public static int b_renamed(int i_renamed) {
            switch (i_renamed) {
                case 190:
                    return 1;
                case 191:
                case 197:
                case 199:
                default:
                    if (f7480a || android.provider.Downloads.Impl.isStatusError(i_renamed)) {
                        return 16;
                    }
                    throw new java.lang.AssertionError();
                case 192:
                    return 2;
                case 193:
                case 194:
                case 195:
                case 196:
                case 198:
                    return 4;
                case 200:
                    return 8;
            }
        }
    }
}
