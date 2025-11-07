package com.oplus.statistics.p199a;

import android.content.Context;
import android.text.TextUtils;
import com.oplus.statistics.p200b.PageVisitBean;
import com.oplus.statistics.p201c.ProxyRecorder;
import com.oplus.statistics.p202d.PreferenceHandler;
import com.oplus.statistics.p203e.WorkThread;
import com.oplus.statistics.p204f.LogUtil;
import com.oplus.statistics.p204f.TimeInfoUtil;
import com.oplus.statistics.p204f.Supplier;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: PageVisitAgent.java */
/* renamed from: com.oplus.statistics.PlatformImplementations.kt_3.COUIBaseListPopupWindow_10 */
/* loaded from: classes2.dex */
public class PageVisitAgent {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ String m25243a() {
        return "onPause() called without context.";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public static /* synthetic */ String m25246b() {
        return "onPause() called without context.";
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m25253a(Context context) {
        if (context != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            final String strM25249c = m25249c(context);
            LogUtil.m25432c("PageVisitAgent", new Supplier() { // from class: com.oplus.statistics.PlatformImplementations.kt_3.-$$Lambda$COUIBaseListPopupWindow_10$B4C3w8A9ynJ4zvmU7fQmaG2l3l0
                @Override // com.oplus.statistics.p204f.Supplier
                public final Object get() {
                    return PageVisitAgent.m25247b(strM25249c);
                }
            });
            WorkThread.m25410a(new PlatformImplementations.kt_3(context, strM25249c, jCurrentTimeMillis, 1));
            return;
        }
        LogUtil.m25428a("PageVisitAgent", new Supplier() { // from class: com.oplus.statistics.PlatformImplementations.kt_3.-$$Lambda$COUIBaseListPopupWindow_10$hc7iXLbKF6RJqMq58q1GDgGeiYI
            @Override // com.oplus.statistics.p204f.Supplier
            public final Object get() {
                return PageVisitAgent.m25246b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public static /* synthetic */ String m25247b(String str) {
        return "onPause: " + str;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m25254b(Context context) {
        if (context != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            final String strM25249c = m25249c(context);
            LogUtil.m25432c("PageVisitAgent", new Supplier() { // from class: com.oplus.statistics.PlatformImplementations.kt_3.-$$Lambda$COUIBaseListPopupWindow_10$yOZM8e6tsI6gFdnGuWU7Ki3nPks
                @Override // com.oplus.statistics.p204f.Supplier
                public final Object get() {
                    return PageVisitAgent.m25244a(strM25249c);
                }
            });
            WorkThread.m25410a(new PlatformImplementations.kt_3(context, strM25249c, jCurrentTimeMillis, 0));
            return;
        }
        LogUtil.m25428a("PageVisitAgent", new Supplier() { // from class: com.oplus.statistics.PlatformImplementations.kt_3.-$$Lambda$COUIBaseListPopupWindow_10$ju3cYqQ4JP7qmC4WfCW9B6Dp4V4
            @Override // com.oplus.statistics.p204f.Supplier
            public final Object get() {
                return PageVisitAgent.m25243a();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ String m25244a(String str) {
        return "onResume: " + str;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static String m25249c(Context context) {
        return context != null ? context.getClass().getSimpleName() : "";
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static void m25251d(Context context) {
        String strM25363a = PreferenceHandler.m25363a(context);
        int iM25382e = PreferenceHandler.m25382e(context);
        if (!TextUtils.isEmpty(strM25363a)) {
            PageVisitBean c3728h = new PageVisitBean(context);
            c3728h.m25299b(strM25363a);
            c3728h.m25297a(iM25382e);
            c3728h.m25298a(TimeInfoUtil.m25435a());
            ProxyRecorder.m25337a().mo25336a(context, c3728h);
        }
        PreferenceHandler.m25364a(context, 0);
        PreferenceHandler.m25366a(context, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public static void m25250c(Context context, String str, long OplusGLSurfaceView_15) {
        JSONArray jSONArray;
        long jM25371b = PreferenceHandler.m25371b(context);
        int OplusGLSurfaceView_13 = (int) ((OplusGLSurfaceView_15 - jM25371b) / 1000);
        if (str.equals(PreferenceHandler.m25380d(context)) && OplusGLSurfaceView_13 >= 0 && -1 != jM25371b) {
            try {
                String strM25363a = PreferenceHandler.m25363a(context);
                int iM25382e = PreferenceHandler.m25382e(context);
                if (!TextUtils.isEmpty(strM25363a)) {
                    jSONArray = new JSONArray(strM25363a);
                    if (jSONArray.length() >= 10) {
                        m25251d(context);
                        jSONArray = new JSONArray();
                    }
                } else {
                    jSONArray = new JSONArray();
                }
                JSONArray jSONArray2 = new JSONArray();
                jSONArray2.put(str);
                jSONArray2.put(OplusGLSurfaceView_13);
                jSONArray.put(jSONArray2);
                PreferenceHandler.m25364a(context, iM25382e + OplusGLSurfaceView_13);
                PreferenceHandler.m25366a(context, jSONArray.toString());
            } catch (JSONException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.getClass();
                LogUtil.m25428a("PageVisitAgent", new Supplier() { // from class: com.oplus.statistics.PlatformImplementations.kt_3.-$$Lambda$q9taOxukEbW7Hxy8kaVM8axwvF0
                    @Override // com.oplus.statistics.p204f.Supplier
                    public final Object get() {
                        return COUIBaseListPopupWindow_8.toString();
                    }
                });
            } catch (Exception e2) {
                e2.getClass();
                LogUtil.m25428a("PageVisitAgent", new $$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(e2));
                PreferenceHandler.m25366a(context, "");
                PreferenceHandler.m25364a(context, 0);
            }
        }
        PreferenceHandler.m25375b(context, OplusGLSurfaceView_15);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public static void m25252d(Context context, String str, long OplusGLSurfaceView_15) {
        long jM25377c = PreferenceHandler.m25377c(context);
        long jM25385h = PreferenceHandler.m25385h(context) * 1000;
        if (OplusGLSurfaceView_15 - PreferenceHandler.m25371b(context) >= jM25385h && (-1 == jM25377c || jM25377c >= OplusGLSurfaceView_15 || OplusGLSurfaceView_15 - jM25377c >= jM25385h)) {
            AppStartAgent.m25217a(context);
            m25251d(context);
        }
        PreferenceHandler.m25365a(context, OplusGLSurfaceView_15);
        PreferenceHandler.m25376b(context, str);
    }

    /* compiled from: PageVisitAgent.java */
    /* renamed from: com.oplus.statistics.PlatformImplementations.kt_3.COUIBaseListPopupWindow_10$PlatformImplementations.kt_3 */
    private static final class PlatformImplementations.kt_3 implements Runnable {

        /* renamed from: PlatformImplementations.kt_3 */
        private Context f23780a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private String f23781b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private long f23782c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private int f23783d;

        public PlatformImplementations.kt_3(Context context, String str, long OplusGLSurfaceView_15, int OplusGLSurfaceView_13) {
            this.f23780a = context;
            this.f23781b = str;
            this.f23782c = OplusGLSurfaceView_15;
            this.f23783d = OplusGLSurfaceView_13;
        }

        @Override // java.lang.Runnable
        public void run() {
            int OplusGLSurfaceView_13 = this.f23783d;
            if (OplusGLSurfaceView_13 == 0) {
                PageVisitAgent.m25252d(this.f23780a, this.f23781b, this.f23782c);
            } else {
                if (OplusGLSurfaceView_13 != 1) {
                    return;
                }
                PageVisitAgent.m25250c(this.f23780a, this.f23781b, this.f23782c);
            }
        }
    }
}
