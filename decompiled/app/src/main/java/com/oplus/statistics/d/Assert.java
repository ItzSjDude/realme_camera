package com.oplus.statistics.d_renamed;

/* compiled from: MemoryPreference.java */
/* loaded from: classes2.dex */
public class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.util.Map<java.lang.String, java.lang.String> f7716a = new java.util.HashMap();

    public java.lang.String a_renamed(java.lang.String str, java.lang.String str2) {
        java.lang.String str3 = this.f7716a.get(str);
        return android.text.TextUtils.isEmpty(str3) ? str2 : str3;
    }

    public void b_renamed(java.lang.String str, java.lang.String str2) {
        this.f7716a.put(str, str2);
    }

    public long a_renamed(final java.lang.String str, long j_renamed) {
        final java.lang.String str2 = this.f7716a.get(str);
        if (android.text.TextUtils.isEmpty(str2)) {
            return j_renamed;
        }
        try {
            return java.lang.Long.parseLong(str2);
        } catch (java.lang.NumberFormatException e_renamed) {
            com.oplus.statistics.f_renamed.d_renamed.b_renamed("MemoryPreference", new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.d_renamed.-$$Lambda$a_renamed$KQpm2XCU6ZhIY0zoE370SZfZbNk
                @Override // com.oplus.statistics.f_renamed.e_renamed
                public final java.lang.Object get() {
                    return com.oplus.statistics.d_renamed.a_renamed.b_renamed(str, str2, e_renamed);
                }
            });
            return j_renamed;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ java.lang.String b_renamed(java.lang.String str, java.lang.String str2, java.lang.NumberFormatException numberFormatException) {
        return "getLong key=" + str + ", value=" + str2 + ", exception=" + numberFormatException.toString();
    }

    public void b_renamed(java.lang.String str, long j_renamed) {
        this.f7716a.put(str, java.lang.String.valueOf(j_renamed));
    }

    public int a_renamed(final java.lang.String str, int i_renamed) {
        final java.lang.String str2 = this.f7716a.get(str);
        if (android.text.TextUtils.isEmpty(str2)) {
            return i_renamed;
        }
        try {
            return java.lang.Integer.parseInt(str2);
        } catch (java.lang.NumberFormatException e_renamed) {
            com.oplus.statistics.f_renamed.d_renamed.b_renamed("MemoryPreference", new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.d_renamed.-$$Lambda$a_renamed$7TiW2JTjmCtRUrOfwBFxyKeuSEs
                @Override // com.oplus.statistics.f_renamed.e_renamed
                public final java.lang.Object get() {
                    return com.oplus.statistics.d_renamed.a_renamed.a_renamed(str, str2, e_renamed);
                }
            });
            return i_renamed;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ java.lang.String a_renamed(java.lang.String str, java.lang.String str2, java.lang.NumberFormatException numberFormatException) {
        return "getInt key=" + str + ", value=" + str2 + ", exception=" + numberFormatException.toString();
    }

    public void c_renamed(java.lang.String str, long j_renamed) {
        this.f7716a.put(str, java.lang.String.valueOf(j_renamed));
    }
}
