package com.oplus.statistics.b_renamed;

/* compiled from: TrackEvent.java */
/* loaded from: classes2.dex */
public abstract class m_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.content.Context f7669a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final android.util.ArrayMap<java.lang.String, java.lang.Object> f7670b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.lang.String f7671c = "";
    private java.lang.String d_renamed = "";
    private java.lang.String e_renamed = "";
    private java.lang.String f_renamed = "";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ java.lang.String a_renamed() {
        return "appId is_renamed empty";
    }

    public abstract int b_renamed();

    public m_renamed(android.content.Context context) {
        java.util.Objects.requireNonNull(context, "TrackEvent: context is_renamed null");
        this.f7669a = context;
        this.f7670b = new android.util.ArrayMap<>();
        a_renamed(context);
    }

    public java.util.Map<java.lang.String, java.lang.Object> f_renamed() {
        return new android.util.ArrayMap(this.f7670b);
    }

    void a_renamed(java.lang.String str, int i_renamed) {
        this.f7670b.put(str, java.lang.Integer.valueOf(i_renamed));
    }

    protected void a_renamed(java.lang.String str, long j_renamed) {
        this.f7670b.put(str, java.lang.Long.valueOf(j_renamed));
    }

    protected void a_renamed(java.lang.String str, boolean z_renamed) {
        this.f7670b.put(str, java.lang.Boolean.valueOf(z_renamed));
    }

    protected void a_renamed(java.lang.String str, java.lang.String str2) {
        this.f7670b.put(str, str2);
    }

    public java.lang.String g_renamed() {
        return this.f7671c;
    }

    public void d_renamed(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.f7671c = str;
        a_renamed("appIdStr", this.f7671c);
        if (android.text.TextUtils.isDigitsOnly(this.f7671c)) {
            a_renamed("appId", java.lang.Integer.parseInt(this.f7671c));
        }
    }

    public android.content.Context h_renamed() {
        return this.f7669a;
    }

    private void a_renamed(android.content.Context context) {
        this.f7670b.put("dataType", java.lang.Integer.valueOf(b_renamed()));
        this.f7670b.put("ssoid", com.oplus.statistics.f_renamed.a_renamed.a_renamed(context));
        this.f7670b.put("statSId", com.oplus.statistics.c_renamed.f_renamed.a_renamed().a_renamed(context));
        java.lang.String strD = com.oplus.statistics.f_renamed.b_renamed.d_renamed(context);
        if (android.text.TextUtils.isEmpty(strD)) {
            com.oplus.statistics.f_renamed.d_renamed.b_renamed("TrackEvent", new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.b_renamed.-$$Lambda$m_renamed$rGRt2t1e3RKc6x6UAAMKB2chJjM
                @Override // com.oplus.statistics.f_renamed.e_renamed
                public final java.lang.Object get() {
                    return com.oplus.statistics.b_renamed.m_renamed.a_renamed();
                }
            });
        } else {
            d_renamed(strD);
        }
        com.oplus.statistics.c_renamed cVarA = com.oplus.statistics.c_renamed.a_renamed(strD);
        if (cVarA != null) {
            this.f7670b.put("headerFlag", java.lang.Integer.valueOf(cVarA.a_renamed().b_renamed()));
            this.f7670b.put("appVersion", cVarA.a_renamed().d_renamed());
            this.f7670b.put("appPackage", cVarA.a_renamed().c_renamed());
            this.f7670b.put("appName", cVarA.a_renamed().e_renamed());
            return;
        }
        this.f7670b.put("appVersion", com.oplus.statistics.f_renamed.b_renamed.c_renamed(context));
        this.f7670b.put("appPackage", com.oplus.statistics.f_renamed.b_renamed.a_renamed(context));
        this.f7670b.put("appName", com.oplus.statistics.f_renamed.b_renamed.b_renamed(context));
    }
}
