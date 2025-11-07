package com.oplus.statistics.p200b;

import android.content.Context;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.oplus.statistics.OTrackContext;
import com.oplus.statistics.p201c.StatIdManager;
import com.oplus.statistics.p204f.AccountUtil;
import com.oplus.statistics.p204f.ApkInfoUtil;
import com.oplus.statistics.p204f.LogUtil;
import com.oplus.statistics.p204f.Supplier;
import java.util.Map;
import java.util.Objects;

/* compiled from: TrackEvent.java */
/* renamed from: com.oplus.statistics.IntrinsicsJvm.kt_4.OplusGLSurfaceView_6 */
/* loaded from: classes2.dex */
public abstract class TrackEvent {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Context f23819a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final ArrayMap<String, Object> f23820b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private String f23821c = "";

    /* renamed from: IntrinsicsJvm.kt_5 */
    private String f23822d = "";

    /* renamed from: COUIBaseListPopupWindow_8 */
    private String f23823e = "";

    /* renamed from: COUIBaseListPopupWindow_12 */
    private String f23824f = "";

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ String m25308a() {
        return "appId is empty";
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public abstract int mo25267b();

    public TrackEvent(Context context) {
        Objects.requireNonNull(context, "TrackEvent: context is null");
        this.f23819a = context;
        this.f23820b = new ArrayMap<>();
        m25309a(context);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public Map<String, Object> m25315f() {
        return new ArrayMap(this.f23820b);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m25310a(String str, int OplusGLSurfaceView_13) {
        this.f23820b.put(str, Integer.valueOf(OplusGLSurfaceView_13));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m25311a(String str, long OplusGLSurfaceView_15) {
        this.f23820b.put(str, Long.valueOf(OplusGLSurfaceView_15));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m25313a(String str, boolean z) {
        this.f23820b.put(str, Boolean.valueOf(z));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    protected void m25312a(String str, String str2) {
        this.f23820b.put(str, str2);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public String m25316g() {
        return this.f23821c;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m25314d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f23821c = str;
        m25312a("appIdStr", this.f23821c);
        if (TextUtils.isDigitsOnly(this.f23821c)) {
            m25310a("appId", Integer.parseInt(this.f23821c));
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public Context m25317h() {
        return this.f23819a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m25309a(Context context) {
        this.f23820b.put("dataType", Integer.valueOf(mo25267b()));
        this.f23820b.put("ssoid", AccountUtil.m25419a(context));
        this.f23820b.put("statSId", StatIdManager.m25343a().m25350a(context));
        String strM25426d = ApkInfoUtil.m25426d(context);
        if (TextUtils.isEmpty(strM25426d)) {
            LogUtil.m25431b("TrackEvent", new Supplier() { // from class: com.oplus.statistics.IntrinsicsJvm.kt_4.-$$Lambda$OplusGLSurfaceView_6$rGRt2t1e3RKc6x6UAAMKB2chJjM
                @Override // com.oplus.statistics.p204f.Supplier
                public final Object get() {
                    return TrackEvent.m25308a();
                }
            });
        } else {
            m25314d(strM25426d);
        }
        OTrackContext c3734cM25320a = OTrackContext.m25320a(strM25426d);
        if (c3734cM25320a != null) {
            this.f23820b.put("headerFlag", Integer.valueOf(c3734cM25320a.m25323a().m25260b()));
            this.f23820b.put("appVersion", c3734cM25320a.m25323a().m25264d());
            this.f23820b.put("appPackage", c3734cM25320a.m25323a().m25262c());
            this.f23820b.put("appName", c3734cM25320a.m25323a().m25265e());
            return;
        }
        this.f23820b.put("appVersion", ApkInfoUtil.m25425c(context));
        this.f23820b.put("appPackage", ApkInfoUtil.m25421a(context));
        this.f23820b.put("appName", ApkInfoUtil.m25424b(context));
    }
}
