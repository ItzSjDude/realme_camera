package com.oplus.p188d;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.SQLException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.BaseColumns;
import android.provider.Settings;
import android.util.Log;
import com.android.providers.downloads.Downloads;
import com.oplus.p188d.p191b.OplusVersionUtils;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: AppSettings.java */
/* renamed from: com.oplus.IntrinsicsJvm.kt_5.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class AppSettings implements BaseColumns {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final String f23282a = (String) m24919a();

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final Uri f23283b = Settings.System.getUriFor("video_call");

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static final Uri f23284c = Settings.System.getUriFor("sip_call");

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static final String[] f23285d = {"user_preferred_sub1", "user_preferred_sub2"};

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static final Uri f23286e = Settings.System.getUriFor("mms_notification");

    /* renamed from: COUIBaseListPopupWindow_12 */
    public static final Uri f23287f = Settings.System.getUriFor("ringtone_sim2");

    /* renamed from: COUIBaseListPopupWindow_11 */
    public static final Uri f23288g = Settings.System.getUriFor("notification_sim2");

    /* renamed from: COUIBaseListPopupWindow_10 */
    public static final Uri f23289h = Settings.System.getUriFor("calendar_sound");

    /* renamed from: OplusGLSurfaceView_13 */
    public static final String[] f23290i = {"user_preferred_sub1", "user_preferred_sub2", "user_preferred_sub3"};

    /* renamed from: PlatformImplementations.kt_3 */
    private static Object m24919a() {
        return OplusVersionUtils.f23365a ? "com.oplus.appplatform.settings" : AppSettingsOplusCompat.m24997a();
    }

    /* compiled from: AppSettings.java */
    /* renamed from: com.oplus.IntrinsicsJvm.kt_5.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    private static final class PlatformImplementations.kt_3 {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final Uri f23306b;

        /* renamed from: PlatformImplementations.kt_3 */
        private final Object f23305a = new Object();

        /* renamed from: IntrinsicsJvm.kt_3 */
        private ConcurrentHashMap<Integer, ContentProviderClient> f23307c = new ConcurrentHashMap<>();

        public PlatformImplementations.kt_3(Uri uri) {
            this.f23306b = uri;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public ContentProviderClient m24949a(ContentResolver contentResolver, int OplusGLSurfaceView_13) {
            ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient;
            if (OplusGLSurfaceView_13 == -100 || OplusGLSurfaceView_13 >= 0) {
                synchronized (this.f23305a) {
                    contentProviderClientAcquireUnstableContentProviderClient = this.f23307c.get(Integer.valueOf(OplusGLSurfaceView_13));
                    if (contentProviderClientAcquireUnstableContentProviderClient == null) {
                        contentProviderClientAcquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(m24948a(OplusGLSurfaceView_13).getAuthority());
                        this.f23307c.put(Integer.valueOf(OplusGLSurfaceView_13), contentProviderClientAcquireUnstableContentProviderClient);
                    }
                }
                return contentProviderClientAcquireUnstableContentProviderClient;
            }
            Log.COUIBaseListPopupWindow_8("AppSettings", "Cannot support user id_renamed (below zero) : " + OplusGLSurfaceView_13 + " . Please use @link [ActivityManager.getCurrentUser] instead.");
            return null;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private Uri m24948a(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 == -100) {
                return this.f23306b;
            }
            Uri.Builder builderBuildUpon = this.f23306b.buildUpon();
            builderBuildUpon.encodedAuthority("" + OplusGLSurfaceView_13 + "@" + this.f23306b.getEncodedAuthority());
            return builderBuildUpon.build();
        }
    }

    /* compiled from: AppSettings.java */
    /* renamed from: com.oplus.IntrinsicsJvm.kt_5.PlatformImplementations.kt_3$IntrinsicsJvm.kt_3 */
    public static class IntrinsicsJvm.kt_3 implements BaseColumns {
        /* renamed from: PlatformImplementations.kt_3 */
        protected static boolean m24990a(ContentResolver contentResolver, Uri uri, String str, String str2) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("name", str);
                contentValues.put(Downloads.Impl.RequestHeaders.COLUMN_VALUE, str2);
                contentResolver.insert(uri, contentValues);
                return true;
            } catch (SQLException COUIBaseListPopupWindow_8) {
                Log.w("AppSettings", "Can't set key " + str + " in " + uri, COUIBaseListPopupWindow_8);
                return false;
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        protected static Uri m24989a(Uri uri, String str) {
            return Uri.withAppendedPath(uri, str);
        }
    }

    /* compiled from: AppSettings.java */
    /* renamed from: com.oplus.IntrinsicsJvm.kt_5.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4 */
    private static class IntrinsicsJvm.kt_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        private static final String[] f23354a = {Downloads.Impl.RequestHeaders.COLUMN_VALUE};

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final Uri f23355b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final PlatformImplementations.kt_3 f23356c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private final String f23357d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private final String f23358e;

        public IntrinsicsJvm.kt_4(Uri uri, String str, String str2, PlatformImplementations.kt_3 aVar) {
            this.f23355b = uri;
            this.f23357d = str;
            this.f23358e = str2;
            this.f23356c = aVar;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public boolean m24988a(ContentResolver contentResolver, String str, String str2, String str3, boolean z, int OplusGLSurfaceView_13) throws RemoteException {
            ContentProviderClient contentProviderClientM24949a = this.f23356c.m24949a(contentResolver, OplusGLSurfaceView_13);
            if (contentProviderClientM24949a == null) {
                Log.w("AppSettings", "Can't get provider for " + this.f23355b);
                return false;
            }
            try {
                Bundle bundle = new Bundle();
                bundle.putString(Downloads.Impl.RequestHeaders.COLUMN_VALUE, str2);
                if (str3 != null) {
                    bundle.putString("_tag", str3);
                }
                if (z) {
                    bundle.putBoolean("_make_default", true);
                }
                contentProviderClientM24949a.call(this.f23358e, str, bundle);
                return true;
            } catch (RemoteException COUIBaseListPopupWindow_8) {
                Log.w("AppSettings", "Can't set key " + str + " in " + this.f23355b, COUIBaseListPopupWindow_8);
                return false;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00b5  */
        /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v4, types: [android.os.Bundle] */
        /* JADX WARN: Type inference failed for: r2v5 */
        /* JADX WARN: Type inference failed for: r2v6 */
        /* JADX WARN: Type inference failed for: r2v8, types: [android.database.Cursor] */
        /* renamed from: PlatformImplementations.kt_3 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.String m24987a(android.content.ContentResolver r11, java.lang.String r12, int r13) throws java.lang.Throwable {
            /*
                r10 = this;
                java.lang.String r0 = " from "
                java.lang.String r1 = "Can't get key "
                com.oplus.IntrinsicsJvm.kt_5.PlatformImplementations.kt_3$PlatformImplementations.kt_3 r2 = r10.f23356c
                android.content.ContentProviderClient r3 = r2.m24949a(r11, r13)
                java.lang.String r11 = "AppSettings"
                r13 = 0
                if (r3 != 0) goto L26
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                java.lang.String r0 = "Can't get provider for "
                r12.append(r0)
                android.net.Uri r10 = r10.f23355b
                r12.append(r10)
                java.lang.String r10 = r12.toString()
                android.util.Log.w(r11, r10)
                return r13
            L26:
                java.lang.String r2 = r10.f23357d
                if (r2 == 0) goto L3e
                android.os.Bundle r2 = new android.os.Bundle     // Catch: android.os.RemoteException -> L3e
                r2.<init>()     // Catch: android.os.RemoteException -> L3e
                java.lang.String r4 = r10.f23357d     // Catch: android.os.RemoteException -> L3e
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
                com.oplus.p188d.AppSettings.m24918a(r2, r5, r13)     // Catch: java.lang.Throwable -> L8d android.os.RemoteException -> L90
                android.net.Uri r2 = r10.f23355b     // Catch: java.lang.Throwable -> L8d android.os.RemoteException -> L90
                java.lang.String[] r5 = com.oplus.p188d.AppSettings.IntrinsicsJvm.kt_4.f23354a     // Catch: java.lang.Throwable -> L8d android.os.RemoteException -> L90
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
                android.net.Uri r4 = r10.f23355b     // Catch: android.os.RemoteException -> L8b java.lang.Throwable -> Lb2
                r3.append(r4)     // Catch: android.os.RemoteException -> L8b java.lang.Throwable -> Lb2
                java.lang.String r3 = r3.toString()     // Catch: android.os.RemoteException -> L8b java.lang.Throwable -> Lb2
                android.util.Log.w(r11, r3)     // Catch: android.os.RemoteException -> L8b java.lang.Throwable -> Lb2
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
                android.net.Uri r10 = r10.f23355b     // Catch: java.lang.Throwable -> Lb2
                r4.append(r10)     // Catch: java.lang.Throwable -> Lb2
                java.lang.String r10 = r4.toString()     // Catch: java.lang.Throwable -> Lb2
                android.util.Log.w(r11, r10, r3)     // Catch: java.lang.Throwable -> Lb2
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
            throw new UnsupportedOperationException("Method not decompiled: com.oplus.p188d.AppSettings.IntrinsicsJvm.kt_4.m24987a(android.content.ContentResolver, java.lang.String, int):java.lang.String");
        }
    }

    /* compiled from: AppSettings.java */
    /* renamed from: com.oplus.IntrinsicsJvm.kt_5.PlatformImplementations.kt_3$IntrinsicsJvm.kt_5 */
    public static final class IntrinsicsJvm.kt_5 extends IntrinsicsJvm.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        public static final Uri f23362a = Uri.parse("content://" + AppSettings.f23282a + "/system");

        /* renamed from: IntrinsicsJvm.kt_4 */
        private static final PlatformImplementations.kt_3 f23363b = new PlatformImplementations.kt_3(f23362a);

        /* renamed from: IntrinsicsJvm.kt_3 */
        private static final IntrinsicsJvm.kt_4 f23364c = new IntrinsicsJvm.kt_4(f23362a, "GET_system", "PUT_system", f23363b);

        /* renamed from: PlatformImplementations.kt_3 */
        public static String m24992a(ContentResolver contentResolver, String str) {
            return m24993a(contentResolver, str, -100);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static String m24993a(ContentResolver contentResolver, String str, int OplusGLSurfaceView_13) {
            return f23364c.m24987a(contentResolver, str, OplusGLSurfaceView_13);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static boolean m24994a(ContentResolver contentResolver, String str, String str2) {
            if (Build.VERSION.SDK_INT > 28) {
                return f23364c.m24988a(contentResolver, str, str2, null, false, -100);
            }
            return m24990a(contentResolver, m24991a(str), str, str2);
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static Uri m24991a(String str) {
            return m24989a(f23362a, str);
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public static int m24995b(ContentResolver contentResolver, String str, int OplusGLSurfaceView_13) {
            String strM24992a = m24992a(contentResolver, str);
            if (strM24992a == null) {
                return OplusGLSurfaceView_13;
            }
            try {
                return Integer.parseInt(strM24992a);
            } catch (NumberFormatException unused) {
                return OplusGLSurfaceView_13;
            }
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public static boolean m24996c(ContentResolver contentResolver, String str, int OplusGLSurfaceView_13) {
            return m24994a(contentResolver, str, Integer.toString(OplusGLSurfaceView_13));
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Bundle m24918a(String str, String[] strArr, String str2) {
        if (str == null && strArr == null && str2 == null) {
            return null;
        }
        Bundle bundle = new Bundle();
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
