package com.oplus.statistics.e_renamed;

/* compiled from: ChattyEventTracker.java */
/* loaded from: classes2.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.util.Map<java.lang.String, com.oplus.statistics.e_renamed.a_renamed.ChattyEventTracker_3> f7720a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private int f7721b;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ java.lang.String b_renamed() {
        return "context is_renamed empty.";
    }

    private a_renamed() {
        this.f7720a = new android.util.ArrayMap();
    }

    public static com.oplus.statistics.e_renamed.a_renamed a_renamed() {
        return com.oplus.statistics.e_renamed.a_renamed.b_renamed.f7725a;
    }

    public void a_renamed(final com.oplus.statistics.b_renamed.d_renamed dVar) {
        final android.content.Context applicationContext = dVar.h_renamed().getApplicationContext();
        if (applicationContext == null) {
            com.oplus.statistics.f_renamed.d_renamed.a_renamed("ChattyEventTracker", new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.e_renamed.-$$Lambda$a_renamed$6UBs0B4PZVyyf6Dd9ROqzMRIOqA
                @Override // com.oplus.statistics.f_renamed.e_renamed
                public final java.lang.Object get() {
                    return com.oplus.statistics.e_renamed.a_renamed.b_renamed();
                }
            });
        } else {
            com.oplus.statistics.e_renamed.c_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.statistics.e_renamed.-$$Lambda$a_renamed$W0HoGLany-X7JiGpNF5YnHSvk04
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.a_renamed(applicationContext, dVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a_renamed(android.content.Context context, com.oplus.statistics.b_renamed.d_renamed dVar) {
        a_renamed(context, dVar.g_renamed(), dVar.c_renamed(), dVar.a_renamed());
    }

    private void a_renamed(final android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.String str4 = str + str2 + str3;
        com.oplus.statistics.e_renamed.a_renamed.ChattyEventTracker_3 c0147a = this.f7720a.get(str4);
        if (c0147a == null) {
            com.oplus.statistics.e_renamed.a_renamed.ChattyEventTracker_3 c0147a2 = new com.oplus.statistics.e_renamed.a_renamed.ChattyEventTracker_3(str, str2, str3);
            c0147a2.a_renamed();
            this.f7720a.put(str4, c0147a2);
        } else {
            c0147a.a_renamed();
        }
        this.f7721b++;
        int i_renamed = this.f7721b;
        if (i_renamed >= 100) {
            b_renamed(context);
        } else {
            if (i_renamed != 1 || com.oplus.statistics.e_renamed.c_renamed.a_renamed().a_renamed(1)) {
                return;
            }
            com.oplus.statistics.e_renamed.c_renamed.a_renamed().a_renamed(1, new java.lang.Runnable() { // from class: com.oplus.statistics.e_renamed.-$$Lambda$a_renamed$rGp6_djotfzM0-_0UNGKIMoYxZQ
                @Override // java.lang.Runnable
                public final void run() {
                    this.f_renamed$0.b_renamed(context);
                }
            }, 300000L);
        }
    }

    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public void b_renamed(android.content.Context context) {
        for (com.oplus.statistics.e_renamed.a_renamed.ChattyEventTracker_3 c0147a : this.f7720a.values()) {
            com.oplus.statistics.b_renamed.d_renamed dVar = new com.oplus.statistics.b_renamed.d_renamed(context, "21000", "001", "chatty_event");
            android.util.ArrayMap arrayMap = new android.util.ArrayMap();
            arrayMap.put("app_id", java.lang.String.valueOf(c0147a.f7722a));
            arrayMap.put("log_tag", c0147a.f7723b);
            arrayMap.put("event_id", c0147a.f7724c);
            arrayMap.put(com.oplus.camera.statistics.model.VideoRecordMsgData.KEY_PAUSE_CLICK_TIMES, java.lang.String.valueOf(c0147a.d_renamed));
            dVar.a_renamed(arrayMap);
            com.oplus.statistics.a_renamed.d_renamed.a_renamed(context, dVar);
        }
        this.f7721b = 0;
        this.f7720a.clear();
        com.oplus.statistics.e_renamed.c_renamed.a_renamed().b_renamed(1);
    }

    /* compiled from: ChattyEventTracker.java */
    private static class b_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private static final com.oplus.statistics.e_renamed.a_renamed f7725a = new com.oplus.statistics.e_renamed.a_renamed();
    }

    /* compiled from: ChattyEventTracker.java */
    /* renamed from: com.oplus.statistics.e_renamed.a_renamed$a_renamed, reason: collision with other inner class name */
    static class ChattyEventTracker_3 {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final java.lang.String f7722a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private final java.lang.String f7723b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private final java.lang.String f7724c;
        private int d_renamed;

        public ChattyEventTracker_3(java.lang.String str, java.lang.String str2, java.lang.String str3) {
            this.f7722a = str;
            this.f7723b = str2;
            this.f7724c = str3;
        }

        public int a_renamed() {
            int i_renamed = this.d_renamed;
            this.d_renamed = i_renamed + 1;
            return i_renamed;
        }
    }
}
