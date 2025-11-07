package com.oplus.p188d.p189a;

import android.compat.annotation.UnsupportedAppUsage;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.Downloads;
import android.text.TextUtils;
import android.util.Pair;
import com.android.providers.downloads.DownloadInfoData;
import com.android.providers.downloads.Downloads;
import com.heytap.accessory.constant.AFConstants;
import com.oplus.p188d.p189a.p190a.LogUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: DownloadManager.java */
/* renamed from: com.oplus.IntrinsicsJvm.kt_5.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class DownloadManager {

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static DownloadManager f23294d;

    /* renamed from: OplusGLSurfaceView_11 */
    private static int f23296n;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final ContentResolver f23297f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private final String f23298g;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f23300i;

    /* renamed from: OplusGLSurfaceView_15 */
    private DownloadStatesCallback f23301j;

    /* renamed from: OplusGLSurfaceView_5 */
    private IntrinsicsJvm.kt_4 f23302k;

    /* renamed from: OplusGLSurfaceView_14 */
    private IntrinsicsJvm.kt_3 f23303l;

    /* renamed from: IntrinsicsJvm.kt_3 */
    static final /* synthetic */ boolean f23293c = !DownloadManager.class.desiredAssertionStatus();

    /* renamed from: PlatformImplementations.kt_3 */
    @UnsupportedAppUsage
    public static final String[] f23291a = {"_id", "local_filename", Downloads.Impl.COLUMN_MEDIAPROVIDER_URI, Downloads.Impl.COLUMN_DESTINATION, "title", Downloads.Impl.COLUMN_DESCRIPTION, Downloads.Impl.COLUMN_URI, "status", Downloads.Impl.COLUMN_FILE_NAME_HINT, "media_type", "total_size", "last_modified_timestamp", "bytes_so_far", Downloads.Impl.COLUMN_ALLOW_WRITE, "local_uri", "reason", Downloads.Impl.COLUMN_NOTIFICATION_PACKAGE, Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI, "download_speed"};

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final String[] f23292b = {"_id", "_data AS local_filename", Downloads.Impl.COLUMN_MEDIAPROVIDER_URI, Downloads.Impl.COLUMN_DESTINATION, "title", Downloads.Impl.COLUMN_DESCRIPTION, Downloads.Impl.COLUMN_URI, "status", Downloads.Impl.COLUMN_FILE_NAME_HINT, Downloads.Impl.COLUMN_NOTIFICATION_PACKAGE, "mimetype AS media_type", "total_bytes AS total_size", "lastmod AS last_modified_timestamp", "current_bytes AS bytes_so_far", Downloads.Impl.COLUMN_ALLOW_WRITE, Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI, "download_speed", "'placeholder' AS local_uri", "'placeholder' AS reason"};

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static HandlerThread f23295e = new HandlerThread("DownloadManager");

    /* renamed from: COUIBaseListPopupWindow_10 */
    private Uri f23299h = Downloads.Impl.CONTENT_URI;

    /* renamed from: OplusGLSurfaceView_6 */
    private Handler f23304m = new Handler(f23295e.getLooper());

    /* compiled from: DownloadManager.java */
    /* renamed from: com.oplus.IntrinsicsJvm.kt_5.PlatformImplementations.kt_3.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        void m24960a();
    }

    static {
        f23295e.start();
        f23296n = 0;
    }

    /* compiled from: DownloadManager.java */
    /* renamed from: com.oplus.IntrinsicsJvm.kt_5.PlatformImplementations.kt_3.PlatformImplementations.kt_3$COUIBaseListPopupWindow_8 */
    public static class COUIBaseListPopupWindow_8 {

        /* renamed from: PlatformImplementations.kt_3 */
        static final /* synthetic */ boolean f23328a = !DownloadManager.class.desiredAssertionStatus();

        /* renamed from: IntrinsicsJvm.kt_3 */
        private Uri f23330c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private Uri f23331d;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private CharSequence f23333f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private CharSequence f23334g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        private String f23335h;

        /* renamed from: w */
        private Uri f23350w;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private int f23329b = 0;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private List<Pair<String, String>> f23332e = new ArrayList();

        /* renamed from: OplusGLSurfaceView_13 */
        private int f23336i = 6;

        /* renamed from: OplusGLSurfaceView_15 */
        private boolean f23337j = true;

        /* renamed from: OplusGLSurfaceView_5 */
        private boolean f23338k = true;

        /* renamed from: OplusGLSurfaceView_14 */
        private int f23339l = 0;

        /* renamed from: OplusGLSurfaceView_6 */
        private boolean f23340m = false;

        /* renamed from: OplusGLSurfaceView_11 */
        private boolean f23341n = false;

        /* renamed from: o */
        private boolean f23342o = false;

        /* renamed from: p */
        private String f23343p = null;

        /* renamed from: q */
        private int f23344q = 0;

        /* renamed from: r */
        private boolean f23345r = false;

        /* renamed from: s */
        private int f23346s = -1;

        /* renamed from: t */
        private int f23347t = -1;

        /* renamed from: u */
        private long f23348u = 0;

        /* renamed from: v */
        private long f23349v = -1;

        /* renamed from: x */
        private String f23351x = null;

        /* renamed from: y */
        private String f23352y = null;

        /* renamed from: z */
        private int f23353z = 1;

        public COUIBaseListPopupWindow_8(Uri uri) {
            if (uri == null) {
                throw new NullPointerException();
            }
            String scheme = uri.getScheme();
            if (scheme == null || (!scheme.equals("http") && !scheme.equals("https"))) {
                throw new IllegalArgumentException("Can only download HTTP/HTTPS URIs: " + uri);
            }
            this.f23330c = uri;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public COUIBaseListPopupWindow_8 m24978a(Uri uri) {
            this.f23331d = uri;
            return this;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public COUIBaseListPopupWindow_8 m24979a(CharSequence charSequence) {
            this.f23333f = charSequence;
            return this;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public COUIBaseListPopupWindow_8 m24980a(String str) {
            this.f23335h = str;
            return this;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public COUIBaseListPopupWindow_8 m24977a(int OplusGLSurfaceView_13) {
            this.f23336i = OplusGLSurfaceView_13;
            return this;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public COUIBaseListPopupWindow_8 m24981a(boolean z) {
            this.f23337j = z;
            return this;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public COUIBaseListPopupWindow_8 m24982b(int OplusGLSurfaceView_13) {
            this.f23353z = OplusGLSurfaceView_13;
            return this;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public COUIBaseListPopupWindow_8 m24983b(String str) {
            this.f23343p = str;
            return this;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public COUIBaseListPopupWindow_8 m24984b(boolean z) {
            this.f23345r = z;
            return this;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public COUIBaseListPopupWindow_8 m24985c(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.f23351x = str;
            }
            return this;
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        ContentValues m24986d(String str) {
            ContentValues contentValues = new ContentValues();
            if (!f23328a && this.f23330c == null) {
                throw new AssertionError();
            }
            contentValues.put(Downloads.Impl.COLUMN_URI, this.f23330c.toString());
            contentValues.put(Downloads.Impl.COLUMN_IS_PUBLIC_API, (Boolean) true);
            contentValues.put(Downloads.Impl.COLUMN_NOTIFICATION_PACKAGE, str);
            if (this.f23331d != null) {
                contentValues.put(Downloads.Impl.COLUMN_DESTINATION, (Integer) 4);
                contentValues.put(Downloads.Impl.COLUMN_FILE_NAME_HINT, this.f23331d.toString());
            } else {
                contentValues.put(Downloads.Impl.COLUMN_DESTINATION, Integer.valueOf(this.f23341n ? 5 : 2));
            }
            contentValues.put(Downloads.Impl.COLUMN_MEDIA_SCANNED, Integer.valueOf(this.f23340m ? 0 : 2));
            if (!this.f23332e.isEmpty()) {
                m24975a(contentValues);
            }
            m24976a(contentValues, "title", this.f23333f);
            m24976a(contentValues, Downloads.Impl.COLUMN_DESCRIPTION, this.f23334g);
            m24976a(contentValues, Downloads.Impl.COLUMN_MIME_TYPE, this.f23335h);
            contentValues.put(Downloads.Impl.COLUMN_VISIBILITY, Integer.valueOf(this.f23329b));
            contentValues.put(Downloads.Impl.COLUMN_ALLOWED_NETWORK_TYPES, Integer.valueOf(this.f23336i));
            contentValues.put(Downloads.Impl.COLUMN_ALLOW_ROAMING, Boolean.valueOf(this.f23337j));
            contentValues.put(Downloads.Impl.COLUMN_ALLOW_METERED, Boolean.valueOf(this.f23338k));
            contentValues.put(Downloads.Impl.COLUMN_FLAGS, Integer.valueOf(this.f23339l));
            contentValues.put(Downloads.Impl.COLUMN_IS_VISIBLE_IN_DOWNLOADS_UI, Integer.valueOf(this.f23353z));
            if (this.f23342o) {
                contentValues.put(Downloads.Impl.COLUMN_CONTROL, (Integer) 1);
                contentValues.put("status", (Integer) 193);
            }
            m24976a(contentValues, "extra", this.f23343p);
            contentValues.put(AFConstants.EXTRA_PRIORITY, Integer.valueOf(this.f23344q));
            contentValues.put("relpace_file", Boolean.valueOf(this.f23345r));
            contentValues.put("statistics_id", Integer.valueOf(this.f23346s));
            contentValues.put("time_out", Long.valueOf(this.f23348u));
            contentValues.put("fail_retry_count", Integer.valueOf(this.f23347t));
            contentValues.put("time_interval_for_fail", Long.valueOf(this.f23349v));
            Uri uri = this.f23350w;
            if (uri != null) {
                contentValues.put("backup_uri", uri.toString());
            }
            m24976a(contentValues, "md5", this.f23351x);
            m24976a(contentValues, "header_md5", this.f23352y);
            return contentValues;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m24975a(ContentValues contentValues) {
            int OplusGLSurfaceView_13 = 0;
            for (Pair<String, String> pair : this.f23332e) {
                contentValues.put(Downloads.Impl.RequestHeaders.INSERT_KEY_PREFIX + OplusGLSurfaceView_13, ((String) pair.first) + ": " + ((String) pair.second));
                OplusGLSurfaceView_13++;
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m24976a(ContentValues contentValues, String str, Object obj) {
            if (obj != null) {
                contentValues.put(str, obj.toString());
            }
        }
    }

    /* compiled from: DownloadManager.java */
    /* renamed from: com.oplus.IntrinsicsJvm.kt_5.PlatformImplementations.kt_3.PlatformImplementations.kt_3$IntrinsicsJvm.kt_5 */
    public static class IntrinsicsJvm.kt_5 {

        /* renamed from: PlatformImplementations.kt_3 */
        private long[] f23317a = null;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private String[] f23318b = null;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private Integer f23319c = null;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private String f23320d = null;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private String f23321e = Downloads.Impl.COLUMN_LAST_MODIFICATION;

        /* renamed from: COUIBaseListPopupWindow_12 */
        private int f23322f = 2;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private boolean f23323g = false;

        /* renamed from: COUIBaseListPopupWindow_10 */
        private boolean f23324h = false;

        /* renamed from: OplusGLSurfaceView_13 */
        private String[] f23325i = null;

        /* renamed from: OplusGLSurfaceView_15 */
        private String f23326j = null;

        /* renamed from: OplusGLSurfaceView_5 */
        private String[] f23327k = null;

        /* renamed from: PlatformImplementations.kt_3 */
        public IntrinsicsJvm.kt_5 m24967a(long... jArr) {
            this.f23317a = jArr;
            return this;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public IntrinsicsJvm.kt_5 m24968a(String... strArr) {
            this.f23327k = strArr;
            return this;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public IntrinsicsJvm.kt_5 m24971b(String... strArr) {
            this.f23318b = strArr;
            DownloadManager.m24930c(this.f23318b);
            return this;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public String[] m24969a() {
            String[] strArr = this.f23325i;
            if (strArr != null) {
                return strArr;
            }
            if (m24965e()) {
                return DownloadManager.f23291a;
            }
            return DownloadManager.f23292b;
        }

        /* renamed from: COUIBaseListPopupWindow_8 */
        private boolean m24965e() {
            return DownloadManager.f23296n > 0;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        Cursor m24966a(ContentResolver contentResolver, Uri uri) {
            try {
                return contentResolver.query(uri, m24969a(), m24972b(), m24974d(), m24973c());
            } catch (Exception COUIBaseListPopupWindow_8) {
                LogUtils.m24954d("DownloadManager", "runQuery, occur exception. COUIBaseListPopupWindow_8 = " + COUIBaseListPopupWindow_8.getMessage());
                return null;
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public String m24972b() {
            ArrayList arrayList = new ArrayList();
            long[] jArr = this.f23317a;
            if (jArr != null) {
                arrayList.add(DownloadManager.m24927b(jArr));
            }
            String[] strArr = this.f23327k;
            if (strArr != null) {
                arrayList.add(DownloadManager.m24935e(strArr));
            }
            if (LogUtils.f23308a) {
                LogUtils.m24951a("DownloadManager", "getSelection , mPackageNames = " + Arrays.toString(this.f23318b) + ", this = " + this);
            }
            String[] strArr2 = this.f23318b;
            if (strArr2 != null) {
                arrayList.add(DownloadManager.m24933d(strArr2));
            }
            if (this.f23319c != null) {
                ArrayList arrayList2 = new ArrayList();
                if ((this.f23319c.intValue() & 1) != 0) {
                    arrayList2.add(m24963a("=", 190));
                }
                if ((this.f23319c.intValue() & 2) != 0) {
                    arrayList2.add(m24963a("=", 192));
                }
                if ((this.f23319c.intValue() & 4) != 0) {
                    arrayList2.add(m24963a("=", 193));
                    arrayList2.add(m24963a("=", 194));
                    arrayList2.add(m24963a("=", 195));
                    arrayList2.add(m24963a("=", 196));
                    arrayList2.add(m24963a("=", 198));
                }
                if ((this.f23319c.intValue() & 8) != 0) {
                    arrayList2.add(m24963a("=", 200));
                }
                if ((this.f23319c.intValue() & 16) != 0) {
                    arrayList2.add("(" + m24963a(">=", 400) + " AND " + m24963a("<", 600) + ")");
                    arrayList2.add(m24963a("=", 199));
                }
                if (arrayList2.size() > 0) {
                    arrayList.add("(" + m24964a(" OR ", arrayList2) + ")");
                }
            }
            if (this.f23324h) {
                arrayList.add("is_visible_in_downloads_ui != '0'");
            } else if (this.f23323g) {
                arrayList.add("is_visible_in_downloads_ui = '1'");
            }
            arrayList.add("deleted != '1'");
            if (!TextUtils.isEmpty(this.f23326j)) {
                arrayList.add("uri = '" + this.f23326j + "'");
            }
            String strM24964a = m24964a(" AND ", arrayList);
            if (LogUtils.f23308a) {
                LogUtils.m24951a("DownloadManager", "getSelection. selection = " + strM24964a);
            }
            return strM24964a;
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public String m24973c() {
            return this.f23321e + " " + (this.f23322f == 1 ? "ASC" : "DESC");
        }

        /* renamed from: IntrinsicsJvm.kt_5 */
        public String[] m24974d() {
            String[] strArrM24931c = new String[0];
            String[] strArr = new String[0];
            String[] strArr2 = new String[0];
            long[] jArr = this.f23317a;
            if (jArr != null) {
                strArrM24931c = DownloadManager.m24931c(jArr);
            }
            String[] strArr3 = this.f23327k;
            if (strArr3 != null) {
                strArr = strArr3;
            }
            String[] strArr4 = this.f23318b;
            if (strArr4 != null) {
                strArr2 = strArr4;
            }
            String[] strArrM24970a = m24970a(strArrM24931c, strArr, strArr2);
            DownloadManager.m24930c(strArrM24970a);
            return strArrM24970a;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private String m24964a(String str, Iterable<String> iterable) {
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            for (String str2 : iterable) {
                if (!z) {
                    sb.append(str);
                }
                sb.append(str2);
                z = false;
            }
            return sb.toString();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private String m24963a(String str, int OplusGLSurfaceView_13) {
            return "status" + str + "'" + OplusGLSurfaceView_13 + "'";
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public String[] m24970a(String[] strArr, String[]... strArr2) {
            if (strArr == null || strArr2 == null) {
                return null;
            }
            int length = strArr.length;
            for (String[] strArr3 : strArr2) {
                if (strArr3 != null && strArr3.length > 0) {
                    length += strArr3.length;
                }
            }
            String[] strArr4 = (String[]) Arrays.copyOf(strArr, length);
            int length2 = strArr.length;
            for (String[] strArr5 : strArr2) {
                if (strArr5 != null && strArr5.length > 0) {
                    System.arraycopy(strArr5, 0, strArr4, length2, strArr5.length);
                    length2 += strArr5.length;
                }
            }
            return strArr4;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static DownloadManager m24921a(Context context) {
        return m24922a(context, (String) null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static synchronized DownloadManager m24922a(Context context, String str) {
        if (f23294d == null) {
            f23294d = new DownloadManager(context.getApplicationContext(), str);
        }
        return f23294d;
    }

    private DownloadManager(Context context, String str) {
        if (context == null) {
            throw new IllegalArgumentException("The context and resolver can't be null !");
        }
        this.f23297f = context.getContentResolver();
        String packageName = context.getPackageName();
        if (m24926b(context).equalsIgnoreCase(packageName)) {
            this.f23298g = null;
        } else {
            this.f23298g = TextUtils.isEmpty(str) ? packageName : str;
        }
        if (LogUtils.f23308a) {
            LogUtils.m24952b("DownloadManager", "DownloadManager. mPackageName = " + this.f23298g);
        }
        this.f23300i = context.getApplicationInfo().targetSdkVersion < 23;
        try {
            f23296n = context.getPackageManager().getApplicationInfo("com.android.providers.downloads", 128).metaData.getInt("provider_version");
        } catch (Exception e2) {
            LogUtils.m24954d("DownloadManager", "DownloadManager,exception: " + e2);
        }
    }

    @UnsupportedAppUsage(maxTargetSdk = 28, trackingBug = 115609023)
    /* renamed from: PlatformImplementations.kt_3 */
    public void m24946a(boolean z) {
        this.f23300i = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m24942a(COUIBaseListPopupWindow_8 eVar) {
        try {
            Uri uriInsert = this.f23297f.insert(Downloads.Impl.CONTENT_URI, eVar.m24986d(this.f23298g));
            if (uriInsert == null) {
                LogUtils.m24954d("DownloadManager", "enqueue, downloadUri = null, return -1.");
                return null;
            }
            return m24941a(Long.parseLong(uriInsert.getLastPathSegment()));
        } catch (Exception e2) {
            LogUtils.m24954d("DownloadManager", "enqueueWithUuid, occur exception. COUIBaseListPopupWindow_8 = " + e2.getMessage());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0052 A[PHI: r11
      0x0052: PHI (r11v6 android.database.Cursor) = (r11v5 android.database.Cursor), (r11v7 android.database.Cursor) binds: [B:22:0x0073, B:15:0x0050] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007a  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String m24941a(long r12) throws java.lang.Throwable {
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
            android.content.ContentResolver r5 = r11.f23297f     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L59
            android.net.Uri r6 = r11.f23299h     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L59
            java.lang.String r8 = m24927b(r2)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L59
            java.lang.String[] r9 = m24931c(r2)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L59
            r10 = 0
            android.database.Cursor r11 = r5.query(r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L59
            if (r11 == 0) goto L50
            boolean r12 = r11.moveToFirst()     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L77
            if (r12 == 0) goto L50
            int r12 = r11.getColumnIndex(r0)     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L77
            java.lang.String r12 = r11.getString(r12)     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L77
            boolean r13 = com.oplus.p188d.p189a.p190a.LogUtils.f23308a     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L77
            if (r13 == 0) goto L48
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L77
            r13.<init>()     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L77
            java.lang.String r0 = "enqueueWithUuid, uuid ="
            r13.append(r0)     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L77
            r13.append(r12)     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L77
            java.lang.String r13 = r13.toString()     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L77
            com.oplus.p188d.p189a.p190a.LogUtils.m24951a(r1, r13)     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> L77
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
            com.oplus.p188d.p189a.p190a.LogUtils.m24954d(r1, r12)     // Catch: java.lang.Throwable -> L77
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
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.p188d.p189a.DownloadManager.m24941a(long):java.lang.String");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Cursor m24938a(IntrinsicsJvm.kt_5 dVar) {
        return m24939a(dVar, f23291a);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Cursor m24939a(IntrinsicsJvm.kt_5 dVar, String[] strArr) {
        Cursor cursorM24966a = dVar.m24966a(this.f23297f, this.f23299h);
        if (cursorM24966a == null) {
            return null;
        }
        return new PlatformImplementations.kt_3(cursorM24966a, this.f23299h, this.f23300i);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m24937a(String... strArr) {
        Cursor cursorM24938a = null;
        try {
            try {
                cursorM24938a = m24938a(new IntrinsicsJvm.kt_5().m24968a(strArr));
            } catch (RuntimeException e2) {
                LogUtils.m24953c("DownloadManager", "Exception happened in restartDownload: " + e2);
                if (0 != 0) {
                }
            }
            if (cursorM24938a == null) {
                return 0;
            }
            cursorM24938a.moveToFirst();
            while (!cursorM24938a.isAfterLast()) {
                int OplusGLSurfaceView_13 = cursorM24938a.getInt(cursorM24938a.getColumnIndex("status"));
                if (OplusGLSurfaceView_13 != 8 && OplusGLSurfaceView_13 != 16) {
                    LogUtils.m24953c("DownloadManager", "restartDownloadWithUuid Cannot restart incomplete downloadid = " + cursorM24938a.getLong(cursorM24938a.getColumnIndex("_id")));
                    if (cursorM24938a != null) {
                        cursorM24938a.close();
                    }
                    return 0;
                }
                cursorM24938a.moveToNext();
            }
            if (cursorM24938a != null) {
                cursorM24938a.close();
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put(Downloads.Impl.COLUMN_CURRENT_BYTES, (Integer) 0);
            contentValues.put(Downloads.Impl.COLUMN_TOTAL_BYTES, (Integer) (-1));
            contentValues.putNull(Downloads.Impl._DATA);
            contentValues.put(Downloads.Impl.COLUMN_CONTROL, (Integer) 0);
            contentValues.put("status", (Integer) 190);
            contentValues.put(Downloads.Impl.COLUMN_FAILED_CONNECTIONS, (Integer) 0);
            return this.f23297f.update(this.f23299h, contentValues, m24935e(strArr), strArr);
        } finally {
            if (0 != 0) {
                cursorM24938a.close();
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m24947b(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            LogUtils.m24953c("DownloadManager", "resumeDownloadWithUuid input param 'uuids' can't be null");
            return 0;
        }
        if (LogUtils.f23308a) {
            LogUtils.m24952b("DownloadManager", "resumeDownloadWithUuid dumpArray= " + Arrays.toString(strArr));
        }
        String[] strArr2 = {Downloads.Impl.COLUMN_CONTROL, "status", AFConstants.EXTRA_UUID};
        ArrayList arrayList = new ArrayList(strArr.length);
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = this.f23297f.query(this.f23299h, strArr2, m24935e(strArr), strArr, null);
            } catch (RuntimeException e2) {
                LogUtils.m24953c("DownloadManager", "Exception happened in getUriForDownloadedFile: " + e2);
                if (0 != 0) {
                }
            }
            if (cursorQuery == null) {
                LogUtils.m24953c("DownloadManager", "resumeDownloadWithUuid return 0!");
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return 0;
            }
            if (LogUtils.f23308a) {
                LogUtils.m24952b("DownloadManager", "resumeDownloadWithUuid cursor.getCount() = " + cursorQuery.getCount());
            }
            cursorQuery.moveToFirst();
            while (!cursorQuery.isAfterLast()) {
                String string = cursorQuery.getString(cursorQuery.getColumnIndex(AFConstants.EXTRA_UUID));
                int OplusGLSurfaceView_13 = cursorQuery.getInt(cursorQuery.getColumnIndex("status"));
                int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex(Downloads.Impl.COLUMN_CONTROL));
                if (((Downloads.Impl.isStatusCompleted(OplusGLSurfaceView_13) || OplusGLSurfaceView_13 == 199) || i2 == 0) && OplusGLSurfaceView_13 != 193 && OplusGLSurfaceView_13 != 194 && OplusGLSurfaceView_13 != 195 && OplusGLSurfaceView_13 != 196 && OplusGLSurfaceView_13 != 198) {
                    LogUtils.m24953c("DownloadManager", "resumeDownloadWithUuid Cannot resume PlatformImplementations.kt_3 completed task. id_renamed = " + string + ", stauts = " + OplusGLSurfaceView_13);
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
                LogUtils.m24953c("DownloadManager", "resumeDownloadWithUuid resumeIdList size <= 0, return.");
                return 0;
            }
            if (LogUtils.f23308a) {
                LogUtils.m24952b("DownloadManager", "resumeDownloadWithUuid resumeIdList = " + arrayList);
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put(Downloads.Impl.COLUMN_CONTROL, (Integer) 0);
            contentValues.put("status", (Integer) 190);
            contentValues.put(Downloads.Impl.COLUMN_FAILED_CONNECTIONS, (Integer) 0);
            String[] strArr3 = (String[]) arrayList.toArray(new String[size]);
            return this.f23297f.update(this.f23299h, contentValues, m24935e(strArr3), strArr3);
        } catch (Throwable th) {
            if (0 != 0) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m24936a(int OplusGLSurfaceView_13, String... strArr) {
        if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException("setAllowedNetworkTypesWithUuid input param 'uuids' can't be null");
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(Downloads.Impl.COLUMN_ALLOWED_NETWORK_TYPES, Integer.valueOf(OplusGLSurfaceView_13));
        return this.f23297f.update(this.f23299h, contentValues, m24935e(strArr), strArr);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public List<DownloadInfoData> m24943a(long... jArr) {
        m24946a(true);
        ArrayList arrayList = new ArrayList();
        IntrinsicsJvm.kt_5 dVar = new IntrinsicsJvm.kt_5();
        dVar.m24967a(jArr);
        if (LogUtils.f23308a) {
            LogUtils.m24951a("DownloadManager", "getDownloadData -array-  mPackageName = " + this.f23298g);
        }
        if (!TextUtils.isEmpty(this.f23298g)) {
            dVar.m24971b(this.f23298g);
        }
        Cursor cursorM24938a = null;
        try {
            try {
                cursorM24938a = m24938a(dVar);
                int count = cursorM24938a.getCount();
                if (LogUtils.f23308a) {
                    LogUtils.m24951a("DownloadManager", "getDownloadData  IntrinsicsJvm.kt_3.getCount() = " + count);
                }
                if (count > 0 && cursorM24938a.moveToFirst()) {
                    do {
                        arrayList.add(new DownloadInfoData.BaseReader(this.f23297f, cursorM24938a).newDownloadInfoSimple());
                    } while (cursorM24938a.moveToNext());
                }
            } catch (Exception e2) {
                LogUtils.m24954d("DownloadManager", "exception = " + e2.getMessage());
                if (cursorM24938a != null) {
                }
            }
            return arrayList;
        } finally {
            if (cursorM24938a != null) {
                cursorM24938a.close();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006f A[PHI: r1
      0x006f: PHI (r1v6 android.database.Cursor) = (r1v5 android.database.Cursor), (r1v7 android.database.Cursor) binds: [B:31:0x0094, B:20:0x006d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009a  */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.oplus.IntrinsicsJvm.kt_5.PlatformImplementations.kt_3.PlatformImplementations.kt_3$IntrinsicsJvm.kt_5] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.oplus.IntrinsicsJvm.kt_5.PlatformImplementations.kt_3.PlatformImplementations.kt_3] */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.android.providers.downloads.DownloadInfoData m24940a(java.lang.String r5) throws java.lang.Throwable {
        /*
            r4 = this;
            java.lang.String r0 = "DownloadManager"
            r1 = 1
            r4.m24946a(r1)
            com.oplus.IntrinsicsJvm.kt_5.PlatformImplementations.kt_3.PlatformImplementations.kt_3$IntrinsicsJvm.kt_5 r2 = new com.oplus.IntrinsicsJvm.kt_5.PlatformImplementations.kt_3.PlatformImplementations.kt_3$IntrinsicsJvm.kt_5
            r2.<init>()
            java.lang.String[] r1 = new java.lang.String[r1]
            r3 = 0
            r1[r3] = r5
            r2.m24968a(r1)
            r5 = 0
            android.database.Cursor r1 = r4.m24938a(r2)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L7a
            boolean r2 = com.oplus.p188d.p189a.p190a.LogUtils.f23308a     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            if (r2 == 0) goto L3c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            r2.<init>()     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            java.lang.String r3 = "getDownloadDataWithUuid  IntrinsicsJvm.kt_3.getCount() = "
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
            com.oplus.p188d.p189a.p190a.LogUtils.m24951a(r0, r2)     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
        L3c:
            if (r1 == 0) goto L6d
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            if (r2 == 0) goto L6d
            com.android.providers.downloads.DownloadInfoData$BaseReader r2 = new com.android.providers.downloads.DownloadInfoData$BaseReader     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            android.content.ContentResolver r4 = r4.f23297f     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            r2.<init>(r4, r1)     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            com.android.providers.downloads.DownloadInfoData r4 = r2.newDownloadInfoSimple()     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            boolean r2 = com.oplus.p188d.p189a.p190a.LogUtils.f23308a     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            if (r2 == 0) goto L67
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            r2.<init>()     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            java.lang.String r3 = "getDownloadDataWithUuid. info = "
            r2.append(r3)     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            r2.append(r4)     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
            com.oplus.p188d.p189a.p190a.LogUtils.m24951a(r0, r2)     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L75
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
            com.oplus.p188d.p189a.p190a.LogUtils.m24954d(r0, r4)     // Catch: java.lang.Throwable -> L73
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
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.p188d.p189a.DownloadManager.m24940a(java.lang.String):com.android.providers.downloads.DownloadInfoData");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24945a(DownloadStatesCallback interfaceC3620b) {
        this.f23301j = interfaceC3620b;
        m24929c();
        if (LogUtils.f23308a) {
            LogUtils.m24952b("DownloadManager", "registerDownloadStatesCallback  mDownloadStatesCallback = " + this.f23301j);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24944a() {
        this.f23301j = null;
        m24934d();
        if (LogUtils.f23308a) {
            LogUtils.m24952b("DownloadManager", "unregisterDownloadStatesCallback  mDownloadStatesCallback = " + this.f23301j);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private synchronized void m24929c() {
        if (this.f23303l == null) {
            this.f23303l = new IntrinsicsJvm.kt_3(null);
            this.f23297f.registerContentObserver(OplusDownloads.f23360b, true, this.f23303l);
            this.f23297f.registerContentObserver(OplusDownloads.f23359a, true, this.f23303l);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private synchronized void m24934d() {
        if (this.f23303l != null) {
            this.f23297f.unregisterContentObserver(this.f23303l);
            this.f23303l = null;
        }
    }

    /* compiled from: DownloadManager.java */
    /* renamed from: com.oplus.IntrinsicsJvm.kt_5.PlatformImplementations.kt_3.PlatformImplementations.kt_3$IntrinsicsJvm.kt_3 */
    class IntrinsicsJvm.kt_3 extends ContentObserver {
        public IntrinsicsJvm.kt_3(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            onChange(z, null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, final Uri uri) {
            if (LogUtils.f23308a) {
                LogUtils.m24951a("DownloadManager", "onChange run, uri = " + uri);
            }
            if (DownloadManager.this.f23302k != null) {
                DownloadManager.this.f23302k.m24960a();
                return;
            }
            if (uri != null) {
                if (DownloadManager.this.f23301j != null) {
                    DownloadManager.this.f23304m.post(new Runnable() { // from class: com.oplus.IntrinsicsJvm.kt_5.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (LogUtils.f23308a) {
                                LogUtils.m24951a("DownloadManager", "onChange run, start! mPackageName=" + DownloadManager.this.f23298g + "/uri = " + uri);
                            }
                            if (uri.getPathSegments().size() > 2) {
                                String string = uri.toString();
                                String str = "insert";
                                if (!string.contains("insert")) {
                                    if (string.contains("update")) {
                                        str = "update";
                                    } else if (string.contains("delete")) {
                                        str = "delete";
                                    } else {
                                        if (!string.contains("timeout")) {
                                            LogUtils.m24954d("DownloadManager", "onChange type error uriString = " + string);
                                            return;
                                        }
                                        str = "timeout";
                                    }
                                }
                                String[] strArrSplit = uri.getLastPathSegment().split("-");
                                if (LogUtils.f23308a) {
                                    LogUtils.m24951a("DownloadManager", "onChange run, changeType = " + str + Arrays.toString(strArrSplit));
                                }
                                if (strArrSplit == null || strArrSplit.length <= 0) {
                                    LogUtils.m24954d("DownloadManager", "onChange error no valid id_renamed");
                                    return;
                                }
                                try {
                                    if (str.equalsIgnoreCase("delete")) {
                                        ArrayList arrayList = new ArrayList();
                                        for (String str2 : strArrSplit) {
                                            int iIndexOf = str2.indexOf(124);
                                            DownloadInfoData downloadInfoData = new DownloadInfoData();
                                            downloadInfoData.mId = Long.parseLong(str2.substring(0, iIndexOf));
                                            downloadInfoData.mUuid = str2.substring(iIndexOf + 1);
                                            arrayList.add(downloadInfoData);
                                        }
                                        if (DownloadManager.this.f23301j != null) {
                                            DownloadManager.this.f23301j.mo16900c(arrayList);
                                            return;
                                        } else {
                                            LogUtils.m24954d("DownloadManager", "onChange return mDownloadStatesCallback  is null");
                                            return;
                                        }
                                    }
                                    long[] jArr = new long[strArrSplit.length];
                                    for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < strArrSplit.length; OplusGLSurfaceView_13++) {
                                        Long lValueOf = Long.valueOf(Long.parseLong(strArrSplit[OplusGLSurfaceView_13]));
                                        jArr[OplusGLSurfaceView_13] = lValueOf.longValue();
                                        if (LogUtils.f23308a) {
                                            LogUtils.m24951a("DownloadManager", "onChange run, split OplusGLSurfaceView_13 = " + OplusGLSurfaceView_13 + "/ id_renamed =" + lValueOf);
                                        }
                                    }
                                    List<DownloadInfoData> listM24943a = DownloadManager.this.m24943a(jArr);
                                    if (listM24943a == null || listM24943a.size() <= 0) {
                                        return;
                                    }
                                    IntrinsicsJvm.kt_3.this.m24962a(listM24943a, str);
                                    return;
                                } catch (Exception COUIBaseListPopupWindow_8) {
                                    LogUtils.m24954d("DownloadManager", "exception = " + COUIBaseListPopupWindow_8.getMessage());
                                    return;
                                }
                            }
                            LogUtils.m24954d("DownloadManager", "onChange run, pathSegments.size <= 2, uri has't downloadid");
                        }
                    });
                    return;
                } else {
                    LogUtils.m24954d("DownloadManager", "onChange error mDownloadStatesCallback = null, return.");
                    return;
                }
            }
            LogUtils.m24954d("DownloadManager", "onChange error uri = null, return.");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: PlatformImplementations.kt_3 */
        public void m24962a(List<DownloadInfoData> list, String str) {
            if (list.get(0).mPackage != null) {
                if (DownloadManager.this.f23298g != null && !list.get(0).mPackage.equals(DownloadManager.this.f23298g)) {
                    LogUtils.m24954d("DownloadManager", "handleDownloadInfo list downloadInfo.mPackage = " + list.get(0).mPackage + ". is not equal " + DownloadManager.this.f23298g);
                    return;
                }
                if (LogUtils.f23308a) {
                    LogUtils.m24951a("DownloadManager", "handleDownloadInfo.list downloadInfos.size = " + list.size());
                }
                if (DownloadManager.this.f23301j != null) {
                    if (str.equalsIgnoreCase("insert")) {
                        DownloadManager.this.f23301j.mo16898a(list);
                        return;
                    } else if (str.equalsIgnoreCase("update")) {
                        DownloadManager.this.f23301j.mo16899b(list);
                        return;
                    } else {
                        if (str.equalsIgnoreCase("timeout")) {
                            DownloadManager.this.f23301j.mo16901d(list);
                            return;
                        }
                        return;
                    }
                }
                LogUtils.m24954d("DownloadManager", "handleDownloadInfo list mDownloadStatesCallback = null");
                return;
            }
            LogUtils.m24954d("DownloadManager", "downloadInfo.mPackage = null, return");
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static void m24930c(String[] strArr) {
        LogUtils.m24952b("DownloadManager", "dumpArray array= " + Arrays.toString(strArr));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static String m24926b(Context context) {
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(new Intent("coloros.intent.action.VIEW_DOWNLOADS"), 65536);
        if (listQueryIntentActivities != null && listQueryIntentActivities.size() > 0) {
            return listQueryIntentActivities.get(0).activityInfo.packageName;
        }
        List<ResolveInfo> listQueryIntentActivities2 = packageManager.queryIntentActivities(new Intent("com.oplus.providers.downloads.ui.intent.action.VIEW_DOWNLOADS"), 65536);
        return (listQueryIntentActivities2 == null || listQueryIntentActivities2.size() <= 0) ? "com.coloros.providers.downloads.ui" : listQueryIntentActivities2.get(0).activityInfo.packageName;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    static String m24933d(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < strArr.length; OplusGLSurfaceView_13++) {
            if (OplusGLSurfaceView_13 > 0) {
                sb.append("OR ");
            }
            sb.append(Downloads.Impl.COLUMN_NOTIFICATION_PACKAGE);
            sb.append(" = ? ");
        }
        sb.append(")");
        return sb.toString();
    }

    @UnsupportedAppUsage
    /* renamed from: IntrinsicsJvm.kt_4 */
    static String m24927b(long[] jArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < jArr.length; OplusGLSurfaceView_13++) {
            if (OplusGLSurfaceView_13 > 0) {
                sb.append("OR ");
            }
            sb.append("_id");
            sb.append(" = ? ");
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    static String m24935e(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < strArr.length; OplusGLSurfaceView_13++) {
            if (OplusGLSurfaceView_13 > 0) {
                sb.append("OR ");
            }
            sb.append(AFConstants.EXTRA_UUID);
            sb.append(" = ? ");
        }
        sb.append(")");
        return sb.toString();
    }

    @UnsupportedAppUsage
    /* renamed from: IntrinsicsJvm.kt_3 */
    static String[] m24931c(long[] jArr) {
        return m24923a(jArr, new String[jArr.length]);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static String[] m24923a(long[] jArr, String[] strArr) {
        if (!f23293c && strArr.length < jArr.length) {
            throw new AssertionError();
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < jArr.length; OplusGLSurfaceView_13++) {
            strArr[OplusGLSurfaceView_13] = Long.toString(jArr[OplusGLSurfaceView_13]);
        }
        return strArr;
    }

    /* compiled from: DownloadManager.java */
    /* renamed from: com.oplus.IntrinsicsJvm.kt_5.PlatformImplementations.kt_3.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    public static class PlatformImplementations.kt_3 extends CursorWrapper {

        /* renamed from: PlatformImplementations.kt_3 */
        static final /* synthetic */ boolean f23311a = !DownloadManager.class.desiredAssertionStatus();

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final Uri f23312b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final boolean f23313c;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private static long m24958c(int OplusGLSurfaceView_13) {
            switch (OplusGLSurfaceView_13) {
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

        /* renamed from: IntrinsicsJvm.kt_5 */
        private static long m24959d(int OplusGLSurfaceView_13) {
            if ((400 <= OplusGLSurfaceView_13 && OplusGLSurfaceView_13 < 488) || (500 <= OplusGLSurfaceView_13 && OplusGLSurfaceView_13 < 600)) {
                return (400 > OplusGLSurfaceView_13 || OplusGLSurfaceView_13 >= 488) ? 1011L : 1012L;
            }
            if (OplusGLSurfaceView_13 == 198) {
                return 1006L;
            }
            if (OplusGLSurfaceView_13 == 199) {
                return 1007L;
            }
            if (OplusGLSurfaceView_13 == 488) {
                return 1009L;
            }
            if (OplusGLSurfaceView_13 == 489) {
                return 1008L;
            }
            if (OplusGLSurfaceView_13 == 497) {
                return 1005L;
            }
            switch (OplusGLSurfaceView_13) {
                case Downloads.Impl.STATUS_FILE_ERROR /* 492 */:
                    return 1001L;
                case Downloads.Impl.STATUS_UNHANDLED_REDIRECT /* 493 */:
                case Downloads.Impl.STATUS_UNHANDLED_HTTP_CODE /* 494 */:
                    return 1002L;
                case Downloads.Impl.STATUS_HTTP_DATA_ERROR /* 495 */:
                    return 1004L;
                default:
                    return 1000L;
            }
        }

        public PlatformImplementations.kt_3(Cursor cursor, Uri uri, boolean z) {
            super(cursor);
            this.f23312b = uri;
            this.f23313c = z;
        }

        @Override // android.database.CursorWrapper, android.database.Cursor
        public int getInt(int OplusGLSurfaceView_13) {
            if (getColumnName(OplusGLSurfaceView_13).equals("reason")) {
                return (int) m24955a(super.getInt(getColumnIndex("status")));
            }
            if (getColumnName(OplusGLSurfaceView_13).equals("status")) {
                return m24957b(super.getInt(getColumnIndex("status")));
            }
            if (getColumnName(OplusGLSurfaceView_13).equals("status_detailed")) {
                return super.getInt(getColumnIndex("status"));
            }
            return super.getInt(OplusGLSurfaceView_13);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0028  */
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
                boolean r0 = r4.f23313c
                if (r0 == 0) goto L3b
                java.lang.String r4 = super.getString(r5)
                return r4
            L3b:
                java.lang.SecurityException r4 = new java.lang.SecurityException
                java.lang.String r5 = "COLUMN_LOCAL_FILENAME is deprecated; use ContentResolver.openFileDescriptor() instead"
                r4.<init>(r5)
                throw r4
            L43:
                java.lang.String r4 = r4.m24956a()
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oplus.p188d.p189a.DownloadManager.PlatformImplementations.kt_3.getString(int):java.lang.String");
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private String m24956a() {
            long OplusGLSurfaceView_15 = getLong(getColumnIndex(Downloads.Impl.COLUMN_DESTINATION));
            if (OplusGLSurfaceView_15 == 4 || OplusGLSurfaceView_15 == 0 || OplusGLSurfaceView_15 == 6) {
                String string = super.getString(getColumnIndex("local_filename"));
                if (string == null) {
                    return null;
                }
                return Uri.fromFile(new File(string)).toString();
            }
            return ContentUris.withAppendedId(Downloads.Impl.ALL_DOWNLOADS_CONTENT_URI, getLong(getColumnIndex("_id"))).toString();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static long m24955a(int OplusGLSurfaceView_13) {
            int iM24957b = m24957b(OplusGLSurfaceView_13);
            if (iM24957b == 4) {
                return m24958c(OplusGLSurfaceView_13);
            }
            if (iM24957b != 16) {
                return 0L;
            }
            return m24959d(OplusGLSurfaceView_13);
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public static int m24957b(int OplusGLSurfaceView_13) {
            switch (OplusGLSurfaceView_13) {
                case 190:
                    return 1;
                case 191:
                case 197:
                case 199:
                default:
                    if (f23311a || Downloads.Impl.isStatusError(OplusGLSurfaceView_13)) {
                        return 16;
                    }
                    throw new AssertionError();
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
