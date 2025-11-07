package com.oplus.statistics.c_renamed;

/* compiled from: ServiceRecorder.java */
/* loaded from: classes2.dex */
public class e_renamed implements com.oplus.statistics.c_renamed.c_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final java.lang.String f7680a = new java.lang.String(android.util.Base64.decode("Y29tLm5lYXJtZS5zdGF0aXN0aWNzLnJvbQ==", 0), java.nio.charset.StandardCharsets.UTF_8);

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final java.lang.String f7681b = new java.lang.String(android.util.Base64.decode("Y29tLm5lYXJtZS5zdGF0aXN0aWNzLnJvbS5zZXJ2aWNlLlJlY2VpdmVyU2VydmljZQ==", 0), java.nio.charset.StandardCharsets.UTF_8);

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ java.lang.String a_renamed(android.content.Context context) {
        return "add Task failed: bean or context is_renamed null. context=" + context;
    }

    @Override // com.oplus.statistics.c_renamed.c_renamed
    public void a_renamed(final android.content.Context context, com.oplus.statistics.b_renamed.m_renamed mVar) {
        if (mVar == null || context == null) {
            com.oplus.statistics.f_renamed.d_renamed.d_renamed("ServiceRecorder", new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.c_renamed.-$$Lambda$e_renamed$TtaG-mIwmCjR9X6pTPolbALh7wc
                @Override // com.oplus.statistics.f_renamed.e_renamed
                public final java.lang.Object get() {
                    return com.oplus.statistics.c_renamed.e_renamed.a_renamed(context);
                }
            });
            return;
        }
        try {
            context.startService(a_renamed(mVar));
        } catch (java.lang.Exception e_renamed) {
            com.oplus.statistics.f_renamed.d_renamed.b_renamed("ServiceRecorder", new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.c_renamed.-$$Lambda$e_renamed$m3MxwyoT2uZ6wMWM6xIIX9YiecU
                @Override // com.oplus.statistics.f_renamed.e_renamed
                public final java.lang.Object get() {
                    return com.oplus.statistics.c_renamed.e_renamed.a_renamed(e_renamed);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ java.lang.String a_renamed(java.lang.Exception exc) {
        return "startService exception=" + exc;
    }

    private android.content.Intent a_renamed(com.oplus.statistics.b_renamed.m_renamed mVar) {
        android.content.Intent intent = new android.content.Intent();
        intent.setComponent(new android.content.ComponentName(f7680a, f7681b));
        for (java.util.Map.Entry<java.lang.String, java.lang.Object> entry : mVar.f_renamed().entrySet()) {
            java.lang.String key = entry.getKey();
            java.lang.Object value = entry.getValue();
            if (value instanceof java.lang.String) {
                intent.putExtra(key, (java.lang.String) value);
            } else if (value instanceof java.lang.Integer) {
                intent.putExtra(key, (java.lang.Integer) value);
            } else if (value instanceof java.lang.Long) {
                intent.putExtra(key, (java.lang.Long) value);
            } else if (value instanceof java.lang.Boolean) {
                intent.putExtra(key, (java.lang.Boolean) value);
            }
        }
        return intent;
    }
}
