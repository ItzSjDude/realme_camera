package com.oplus.statistics;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.oplus.statistics.OTrackConfig;
import com.oplus.statistics.p204f.ApkInfoUtil;
import com.oplus.statistics.p204f.LogUtil;
import com.oplus.statistics.p204f.Supplier;
import java.util.HashMap;
import java.util.Map;

/* compiled from: OTrackContext.java */
/* renamed from: com.oplus.statistics.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class OTrackContext {

    /* renamed from: PlatformImplementations.kt_3 */
    private static Map<String, OTrackContext> f23825a = new HashMap();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final String f23826b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final Context f23827c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private OTrackConfig f23828d;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public static /* synthetic */ String m25322b() {
        return "createDefaultConfig PackageManager.NameNotFoundException.";
    }

    private OTrackContext(String str, Context context, OTrackConfig c3720b) throws PackageManager.NameNotFoundException {
        OTrackConfig c3720bM25318a;
        this.f23826b = str;
        this.f23827c = context;
        if (c3720b != null) {
            c3720bM25318a = m25319a(this.f23827c, c3720b);
        } else {
            c3720bM25318a = m25318a(this.f23827c);
        }
        this.f23828d = c3720bM25318a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static synchronized OTrackContext m25320a(String str) {
        return f23825a.get(str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static synchronized OTrackContext m25321a(String str, Context context, OTrackConfig c3720b) {
        OTrackContext c3734cM25320a;
        c3734cM25320a = m25320a(str);
        if (c3734cM25320a == null) {
            c3734cM25320a = new OTrackContext(str, context, c3720b);
            f23825a.put(str, c3734cM25320a);
        }
        return c3734cM25320a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private OTrackConfig m25319a(Context context, OTrackConfig c3720b) {
        if (TextUtils.isEmpty(c3720b.m25262c())) {
            c3720b.m25259a(ApkInfoUtil.m25421a(context));
        }
        if (TextUtils.isEmpty(c3720b.m25264d())) {
            c3720b.m25261b(ApkInfoUtil.m25425c(context));
        }
        if (TextUtils.isEmpty(c3720b.m25265e())) {
            c3720b.m25263c(ApkInfoUtil.m25424b(context));
        }
        return c3720b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private OTrackConfig m25318a(Context context) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo;
        PackageManager packageManager = context.getPackageManager();
        try {
            packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
            LogUtil.m25431b("OTrackContext", new Supplier() { // from class: com.oplus.statistics.-$$Lambda$IntrinsicsJvm.kt_3$fbHcvn_5_wxf0tRDD0u7-FOxlUw
                @Override // com.oplus.statistics.p204f.Supplier
                public final Object get() {
                    return OTrackContext.m25322b();
                }
            });
            packageInfo = null;
        }
        if (packageInfo == null) {
            return OTrackConfig.f23784a;
        }
        return new OTrackConfig.PlatformImplementations.kt_3().m25273a(packageInfo.packageName).m25275b(packageInfo.versionName).m25276c(packageInfo.applicationInfo.loadLabel(packageManager).toString()).m25274a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public OTrackConfig m25323a() {
        if (OTrackConfig.f23784a.equals(this.f23828d)) {
            this.f23828d = m25318a(this.f23827c);
        }
        return this.f23828d;
    }
}
