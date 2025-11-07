package com.oplus.statistics.p203e;

import android.content.Context;
import android.util.ArrayMap;
import com.oplus.camera.statistics.model.VideoRecordMsgData;
import com.oplus.statistics.p199a.CommonAgent;
import com.oplus.statistics.p200b.CommonBean;
import com.oplus.statistics.p204f.LogUtil;
import com.oplus.statistics.p204f.Supplier;
import java.util.Map;

/* compiled from: ChattyEventTracker.java */
/* renamed from: com.oplus.statistics.COUIBaseListPopupWindow_8.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class ChattyEventTracker {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Map<String, PlatformImplementations.kt_3> f23881a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f23882b;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public static /* synthetic */ String m25392b() {
        return "context is empty.";
    }

    private ChattyEventTracker() {
        this.f23881a = new ArrayMap();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static ChattyEventTracker m25389a() {
        return IntrinsicsJvm.kt_4.f23887a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m25395a(final CommonBean c3724d) {
        final Context applicationContext = c3724d.m25317h().getApplicationContext();
        if (applicationContext == null) {
            LogUtil.m25428a("ChattyEventTracker", new Supplier() { // from class: com.oplus.statistics.COUIBaseListPopupWindow_8.-$$Lambda$PlatformImplementations.kt_3$6UBs0B4PZVyyf6Dd9ROqzMRIOqA
                @Override // com.oplus.statistics.p204f.Supplier
                public final Object get() {
                    return ChattyEventTracker.m25392b();
                }
            });
        } else {
            WorkThread.m25410a(new Runnable() { // from class: com.oplus.statistics.COUIBaseListPopupWindow_8.-$$Lambda$PlatformImplementations.kt_3$W0HoGLany-X7JiGpNF5YnHSvk04
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m25390a(applicationContext, c3724d);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public /* synthetic */ void m25390a(Context context, CommonBean c3724d) {
        m25391a(context, c3724d.m25316g(), c3724d.m25284c(), c3724d.m25279a());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m25391a(final Context context, String str, String str2, String str3) {
        String str4 = str + str2 + str3;
        PlatformImplementations.kt_3 aVar = this.f23881a.get(str4);
        if (aVar == null) {
            PlatformImplementations.kt_3 aVar2 = new PlatformImplementations.kt_3(str, str2, str3);
            aVar2.m25400a();
            this.f23881a.put(str4, aVar2);
        } else {
            aVar.m25400a();
        }
        this.f23882b++;
        int OplusGLSurfaceView_13 = this.f23882b;
        if (OplusGLSurfaceView_13 >= 100) {
            m25393b(context);
        } else {
            if (OplusGLSurfaceView_13 != 1 || WorkThread.m25409a().m25413a(1)) {
                return;
            }
            WorkThread.m25409a().m25412a(1, new Runnable() { // from class: com.oplus.statistics.COUIBaseListPopupWindow_8.-$$Lambda$PlatformImplementations.kt_3$rGp6_djotfzM0-_0UNGKIMoYxZQ
                @Override // java.lang.Runnable
                public final void run() {
                    this.COUIBaseListPopupWindow_12$0.m25393b(context);
                }
            }, 300000L);
        }
    }

    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public void m25393b(Context context) {
        for (PlatformImplementations.kt_3 aVar : this.f23881a.values()) {
            CommonBean c3724d = new CommonBean(context, "21000", "001", "chatty_event");
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put("app_id", String.valueOf(aVar.f23883a));
            arrayMap.put("log_tag", aVar.f23884b);
            arrayMap.put("event_id", aVar.f23885c);
            arrayMap.put(VideoRecordMsgData.KEY_PAUSE_CLICK_TIMES, String.valueOf(aVar.f23886d));
            c3724d.m25282a(arrayMap);
            CommonAgent.m25221a(context, c3724d);
        }
        this.f23882b = 0;
        this.f23881a.clear();
        WorkThread.m25409a().m25414b(1);
    }

    /* compiled from: ChattyEventTracker.java */
    /* renamed from: com.oplus.statistics.COUIBaseListPopupWindow_8.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4 */
    private static class IntrinsicsJvm.kt_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        private static final ChattyEventTracker f23887a = new ChattyEventTracker();
    }

    /* compiled from: ChattyEventTracker.java */
    /* renamed from: com.oplus.statistics.COUIBaseListPopupWindow_8.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private final String f23883a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private final String f23884b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private final String f23885c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private int f23886d;

        public PlatformImplementations.kt_3(String str, String str2, String str3) {
            this.f23883a = str;
            this.f23884b = str2;
            this.f23885c = str3;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public int m25400a() {
            int OplusGLSurfaceView_13 = this.f23886d;
            this.f23886d = OplusGLSurfaceView_13 + 1;
            return OplusGLSurfaceView_13;
        }
    }
}
