package com.heytap.accessory.b_renamed.a_renamed;

/* compiled from: BufferPoolConfig.java */
/* loaded from: classes2.dex */
class d_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    android.content.Context f3257a;

    /* renamed from: b_renamed, reason: collision with root package name */
    int f3258b;

    /* renamed from: c_renamed, reason: collision with root package name */
    int f3259c;
    boolean d_renamed;

    static com.heytap.accessory.b_renamed.a_renamed.d_renamed a_renamed(android.content.Context context) {
        return new com.heytap.accessory.b_renamed.a_renamed.d_renamed(context);
    }

    private d_renamed(android.content.Context context) {
        if (context == null) {
            throw new java.lang.RuntimeException("Failed to configure the Pool!");
        }
        this.f3257a = context.getApplicationContext();
        this.d_renamed = true;
    }
}
