package com.oplus.statistics.p201c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import com.oplus.statistics.p200b.TrackEvent;
import com.oplus.statistics.p204f.LogUtil;
import com.oplus.statistics.p204f.Supplier;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/* compiled from: ServiceRecorder.java */
/* renamed from: com.oplus.statistics.IntrinsicsJvm.kt_3.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class ServiceRecorder implements IRecorder {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String f23834a = new String(Base64.decode("Y29tLm5lYXJtZS5zdGF0aXN0aWNzLnJvbQ==", 0), StandardCharsets.UTF_8);

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final String f23835b = new String(Base64.decode("Y29tLm5lYXJtZS5zdGF0aXN0aWNzLnJvbS5zZXJ2aWNlLlJlY2VpdmVyU2VydmljZQ==", 0), StandardCharsets.UTF_8);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ String m25341a(Context context) {
        return "add Task failed: bean or context is null. context=" + context;
    }

    @Override // com.oplus.statistics.p201c.IRecorder
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo25336a(final Context context, TrackEvent abstractC3733m) {
        if (abstractC3733m == null || context == null) {
            LogUtil.m25433d("ServiceRecorder", new Supplier() { // from class: com.oplus.statistics.IntrinsicsJvm.kt_3.-$$Lambda$COUIBaseListPopupWindow_8$TtaG-mIwmCjR9X6pTPolbALh7wc
                @Override // com.oplus.statistics.p204f.Supplier
                public final Object get() {
                    return ServiceRecorder.m25341a(context);
                }
            });
            return;
        }
        try {
            context.startService(m25340a(abstractC3733m));
        } catch (Exception COUIBaseListPopupWindow_8) {
            LogUtil.m25431b("ServiceRecorder", new Supplier() { // from class: com.oplus.statistics.IntrinsicsJvm.kt_3.-$$Lambda$COUIBaseListPopupWindow_8$m3MxwyoT2uZ6wMWM6xIIX9YiecU
                @Override // com.oplus.statistics.p204f.Supplier
                public final Object get() {
                    return ServiceRecorder.m25342a(COUIBaseListPopupWindow_8);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ String m25342a(Exception exc) {
        return "startService exception=" + exc;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private Intent m25340a(TrackEvent abstractC3733m) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(f23834a, f23835b));
        for (Map.Entry<String, Object> entry : abstractC3733m.m25315f().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                intent.putExtra(key, (String) value);
            } else if (value instanceof Integer) {
                intent.putExtra(key, (Integer) value);
            } else if (value instanceof Long) {
                intent.putExtra(key, (Long) value);
            } else if (value instanceof Boolean) {
                intent.putExtra(key, (Boolean) value);
            }
        }
        return intent;
    }
}
