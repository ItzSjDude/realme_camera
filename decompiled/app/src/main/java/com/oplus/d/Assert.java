package com.oplus.d_renamed;

/* compiled from: AppSettings.java */
/* loaded from: classes2.dex */
public class a_renamed implements android.provider.BaseColumns {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final java.lang.String f7468a = (java.lang.String) a_renamed();

    /* renamed from: b_renamed, reason: collision with root package name */
    public static final android.net.Uri f7469b = android.provider.Settings.System.getUriFor("video_call");

    /* renamed from: c_renamed, reason: collision with root package name */
    public static final android.net.Uri f7470c = android.provider.Settings.System.getUriFor("sip_call");
    public static final java.lang.String[] d_renamed = {"user_preferred_sub1", "user_preferred_sub2"};
    public static final android.net.Uri e_renamed = android.provider.Settings.System.getUriFor("mms_notification");
    public static final android.net.Uri f_renamed = android.provider.Settings.System.getUriFor("ringtone_sim2");
    public static final android.net.Uri g_renamed = android.provider.Settings.System.getUriFor("notification_sim2");
    public static final android.net.Uri h_renamed = android.provider.Settings.System.getUriFor("calendar_sound");
    public static final java.lang.String[] i_renamed = {"user_preferred_sub1", "user_preferred_sub2", "user_preferred_sub3"};

    private static java.lang.Object a_renamed() {
        return com.oplus.d_renamed.b_renamed.a_renamed.f7501a ? "com.oplus.appplatform.settings" : com.oplus.d_renamed.b_renamed.a_renamed();
    }

    /* compiled from: AppSettings.java */
    /* renamed from: com.oplus.d_renamed.a_renamed$a_renamed, reason: collision with other inner class name */
    private static final class AppSettings_2 {

        /* renamed from: b_renamed, reason: collision with root package name */
        private final android.net.Uri f7475b;

        /* renamed from: a_renamed, reason: collision with root package name */
        private final java.lang.Object f7474a = new java.lang.Object();

        /* renamed from: c_renamed, reason: collision with root package name */
        private java.util.concurrent.ConcurrentHashMap<java.lang.Integer, android.content.ContentProviderClient> f7476c = new java.util.concurrent.ConcurrentHashMap<>();

        public AppSettings_2(android.net.Uri uri) {
            this.f7475b = uri;
        }

        public android.content.ContentProviderClient a_renamed(android.content.ContentResolver contentResolver, int i_renamed) {
            android.content.ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient;
            if (i_renamed == -100 || i_renamed >= 0) {
                synchronized (this.f7474a) {
                    contentProviderClientAcquireUnstableContentProviderClient = this.f7476c.get(java.lang.Integer.valueOf(i_renamed));
                    if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                        contentProviderClientAcquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(a_renamed(i_renamed).getAuthority());
                        this.f7476c.put(java.lang.Integer.valueOf(i_renamed), contentProviderClientAcquireUnstableContentProviderClient);
                    }
                }
                return contentProviderClientAcquireUnstableContentProviderClient;
            }
            android.util.Log.e_renamed("AppSettings", "Cannot support user id_renamed (below zero) : " + i_renamed + " . Please use @link [ActivityManager.getCurrentUser] instead.");
            return null;
        }

        private android.net.Uri a_renamed(int i_renamed) {
            if (i_renamed == -100) {
                return this.f7475b;
            }
            android.net.Uri.Builder builderBuildUpon = this.f7475b.buildUpon();
            builderBuildUpon.encodedAuthority("" + i_renamed + "@" + this.f7475b.getEncodedAuthority());
            return builderBuildUpon.build();
        }
    }

    /* compiled from: AppSettings.java */
    public static class c_renamed implements android.provider.BaseColumns {
        protected static boolean a_renamed(android.content.ContentResolver contentResolver, android.net.Uri uri, java.lang.String str, java.lang.String str2) {
            try {
                android.content.ContentValues contentValues = new android.content.ContentValues();
                contentValues.put("name", str);
                contentValues.put(com.android.providers.downloads.Downloads.Impl.RequestHeaders.COLUMN_VALUE, str2);
                contentResolver.insert(uri, contentValues);
                return true;
            } catch (android.database.SQLException e_renamed) {
                android.util.Log.w_renamed("AppSettings", "Can't_renamed set key " + str + " in_renamed " + uri, e_renamed);
                return false;
            }
        }

        protected static android.net.Uri a_renamed(android.net.Uri uri, java.lang.String str) {
            return android.net.Uri.withAppendedPath(uri, str);
        }
    }

    /* compiled from: AppSettings.java */
    private static class b_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private static final java.lang.String[] f7492a = {com.android.providers.downloads.Downloads.Impl.RequestHeaders.COLUMN_VALUE};

        /* renamed from: b_renamed, reason: collision with root package name */
        private final android.net.Uri f7493b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private final com.oplus.d_renamed.a_renamed.AppSettings_2 f7494c;
        private final java.lang.String d_renamed;
        private final java.lang.String e_renamed;

        public b_renamed(android.net.Uri uri, java.lang.String str, java.lang.String str2, com.oplus.d_renamed.a_renamed.AppSettings_2 c0141a) {
            this.f7493b = uri;
            this.d_renamed = str;
            this.e_renamed = str2;
            this.f7494c = c0141a;
        }

        public boolean a_renamed(android.content.ContentResolver contentResolver, java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z_renamed, int i_renamed) throws android.os.RemoteException {
            android.content.ContentProviderClient contentProviderClientA = this.f7494c.a_renamed(contentResolver, i_renamed);
            if (contentProviderClientA == null) {
                android.util.Log.w_renamed("AppSettings", "Can't_renamed get provider for " + this.f7493b);
                return false;
            }
            try {
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putString(com.android.providers.downloads.Downloads.Impl.RequestHeaders.COLUMN_VALUE, str2);
                if (str3 != null) {
                    bundle.putString("_tag", str3);
                }
                if (z_renamed) {
                    bundle.putBoolean("_make_default", true);
                }
                contentProviderClientA.call(this.e_renamed, str, bundle);
                return true;
            } catch (android.os.RemoteException e_renamed) {
                android.util.Log.w_renamed("AppSettings", "Can't_renamed set key " + str + " in_renamed " + this.f7493b, e_renamed);
                return false;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B_renamed:36:0x00b5  */
        /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v4, types: [android.os.Bundle] */
        /* JADX WARN: Type inference failed for: r2v5 */
        /* JADX WARN: Type inference failed for: r2v6 */
        /* JADX WARN: Type inference failed for: r2v8, types: [android.database.Cursor] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.String a_renamed(android.content.ContentResolver r11, java.lang.String r12, int r13) throws java.lang.Throwable {
            /*
                r10 = this;
                java.lang.String r0 = " from "
                java.lang.String r1 = "Can't_renamed get key "
                com.oplus.d_renamed.a_renamed$a_renamed r2 = r10.f7494c
                android.content.ContentProviderClient r3 = r2.a_renamed(r11, r13)
                java.lang.String r11 = "AppSettings"
                r13 = 0
                if (r3 != 0) goto L26
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                java.lang.String r0 = "Can't_renamed get provider for "
                r12.append(r0)
                android.net.Uri r10 = r10.f7493b
                r12.append(r10)
                java.lang.String r10 = r12.toString()
                android.util.Log.w_renamed(r11, r10)
                return r13
            L26:
                java.lang.String r2 = r10.d_renamed
                if (r2 == 0) goto L3e
                android.os.Bundle r2 = new android.os.Bundle     // Catch: android.os.RemoteException -> L3e
                r2.<init>()     // Catch: android.os.RemoteException -> L3e
                java.lang.String r4 = r10.d_renamed     // Catch: android.os.RemoteException -> L3e
                android.os.Bundle r2 = r3.call(r4, r12, r2)     // Catch: android.os.RemoteException -> L3e
                if (r2 == 0) goto L3e
                java.lang.String r4 = "value"
                java.lang.String r10 = r2.getString(r4)     // Catch: android.os.RemoteException -> L3e
                return r10
            L3e:
                java.lang.String r2 = "name=?"
                r4 = 1
                java.lang.String[] r5 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L8d android.os.RemoteException -> L90
                r9 = 0
                r5[r9] = r12     // Catch: java.lang.Throwable -> L8d android.os.RemoteException -> L90
                com.oplus.d_renamed.a_renamed.a_renamed(r2, r5, r13)     // Catch: java.lang.Throwable -> L8d android.os.RemoteException -> L90
                android.net.Uri r2 = r10.f7493b     // Catch: java.lang.Throwable -> L8d android.os.RemoteException -> L90
                java.lang.String[] r5 = com.oplus.d_renamed.a_renamed.b_renamed.f7492a     // Catch: java.lang.Throwable -> L8d android.os.RemoteException -> L90
                java.lang.String r6 = "name=?"
                java.lang.String[] r7 = new java.lang.String[r4]     // Catch: java.lang.Throwable -> L8d android.os.RemoteException -> L90
                r7[r9] = r12     // Catch: java.lang.Throwable -> L8d android.os.RemoteException -> L90
                r8 = 0
                r4 = r2
                android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L8d android.os.RemoteException -> L90
                if (r2 != 0) goto L7b
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: android.os.RemoteException -> L8b java.lang.Throwable -> Lb2
                r3.<init>()     // Catch: android.os.RemoteException -> L8b java.lang.Throwable -> Lb2
                r3.append(r1)     // Catch: android.os.RemoteException -> L8b java.lang.Throwable -> Lb2
                r3.append(r12)     // Catch: android.os.RemoteException -> L8b java.lang.Throwable -> Lb2
                r3.append(r0)     // Catch: android.os.RemoteException -> L8b java.lang.Throwable -> Lb2
                android.net.Uri r4 = r10.f7493b     // Catch: android.os.RemoteException -> L8b java.lang.Throwable -> Lb2
                r3.append(r4)     // Catch: android.os.RemoteException -> L8b java.lang.Throwable -> Lb2
                java.lang.String r3 = r3.toString()     // Catch: android.os.RemoteException -> L8b java.lang.Throwable -> Lb2
                android.util.Log.w_renamed(r11, r3)     // Catch: android.os.RemoteException -> L8b java.lang.Throwable -> Lb2
                if (r2 == 0) goto L7a
                r2.close()
            L7a:
                return r13
            L7b:
                boolean r3 = r2.moveToNext()     // Catch: android.os.RemoteException -> L8b java.lang.Throwable -> Lb2
                if (r3 == 0) goto L85
                java.lang.String r13 = r2.getString(r9)     // Catch: android.os.RemoteException -> L8b java.lang.Throwable -> Lb2
            L85:
                if (r2 == 0) goto L8a
                r2.close()
            L8a:
                return r13
            L8b:
                r3 = move-exception
                goto L92
            L8d:
                r10 = move-exception
                r2 = r13
                goto Lb3
            L90:
                r3 = move-exception
                r2 = r13
            L92:
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb2
                r4.<init>()     // Catch: java.lang.Throwable -> Lb2
                r4.append(r1)     // Catch: java.lang.Throwable -> Lb2
                r4.append(r12)     // Catch: java.lang.Throwable -> Lb2
                r4.append(r0)     // Catch: java.lang.Throwable -> Lb2
                android.net.Uri r10 = r10.f7493b     // Catch: java.lang.Throwable -> Lb2
                r4.append(r10)     // Catch: java.lang.Throwable -> Lb2
                java.lang.String r10 = r4.toString()     // Catch: java.lang.Throwable -> Lb2
                android.util.Log.w_renamed(r11, r10, r3)     // Catch: java.lang.Throwable -> Lb2
                if (r2 == 0) goto Lb1
                r2.close()
            Lb1:
                return r13
            Lb2:
                r10 = move-exception
            Lb3:
                if (r2 == 0) goto Lb8
                r2.close()
            Lb8:
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oplus.d_renamed.a_renamed.b_renamed.a_renamed(android.content.ContentResolver, java.lang.String, int):java.lang.String");
        }
    }

    /* compiled from: AppSettings.java */
    public static final class d_renamed extends com.oplus.d_renamed.a_renamed.c_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public static final android.net.Uri f7498a = android.net.Uri.parse("content://" + com.oplus.d_renamed.a_renamed.f7468a + "/system");

        /* renamed from: b_renamed, reason: collision with root package name */
        private static final com.oplus.d_renamed.a_renamed.AppSettings_2 f7499b = new com.oplus.d_renamed.a_renamed.AppSettings_2(f7498a);

        /* renamed from: c_renamed, reason: collision with root package name */
        private static final com.oplus.d_renamed.a_renamed.b_renamed f7500c = new com.oplus.d_renamed.a_renamed.b_renamed(f7498a, "GET_system", "PUT_system", f7499b);

        public static java.lang.String a_renamed(android.content.ContentResolver contentResolver, java.lang.String str) {
            return a_renamed(contentResolver, str, -100);
        }

        public static java.lang.String a_renamed(android.content.ContentResolver contentResolver, java.lang.String str, int i_renamed) {
            return f7500c.a_renamed(contentResolver, str, i_renamed);
        }

        public static boolean a_renamed(android.content.ContentResolver contentResolver, java.lang.String str, java.lang.String str2) {
            if (android.os.Build.VERSION.SDK_INT > 28) {
                return f7500c.a_renamed(contentResolver, str, str2, null, false, -100);
            }
            return a_renamed(contentResolver, a_renamed(str), str, str2);
        }

        public static android.net.Uri a_renamed(java.lang.String str) {
            return a_renamed(f7498a, str);
        }

        public static int b_renamed(android.content.ContentResolver contentResolver, java.lang.String str, int i_renamed) {
            java.lang.String strA = a_renamed(contentResolver, str);
            if (strA == null) {
                return i_renamed;
            }
            try {
                return java.lang.Integer.parseInt(strA);
            } catch (java.lang.NumberFormatException unused) {
                return i_renamed;
            }
        }

        public static boolean c_renamed(android.content.ContentResolver contentResolver, java.lang.String str, int i_renamed) {
            return a_renamed(contentResolver, str, java.lang.Integer.toString(i_renamed));
        }
    }

    public static android.os.Bundle a_renamed(java.lang.String str, java.lang.String[] strArr, java.lang.String str2) {
        if (str == null && strArr == null && str2 == null) {
            return null;
        }
        android.os.Bundle bundle = new android.os.Bundle();
        if (str != null) {
            bundle.putString("android:query-arg-sql-selection", str);
        }
        if (strArr != null) {
            bundle.putStringArray("android:query-arg-sql-selection-args", strArr);
        }
        if (str2 != null) {
            bundle.putString("android:query-arg-sql-sort-order", str2);
        }
        return bundle;
    }
}
