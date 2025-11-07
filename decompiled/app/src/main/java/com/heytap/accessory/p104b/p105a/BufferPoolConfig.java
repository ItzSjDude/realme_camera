package com.heytap.accessory.p104b.p105a;

import android.content.Context;

/* compiled from: BufferPoolConfig.java */
/* renamed from: com.heytap.accessory.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
class BufferPoolConfig {

    /* renamed from: PlatformImplementations.kt_3 */
    Context f9471a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    int f9472b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    int f9473c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    boolean f9474d;

    /* renamed from: PlatformImplementations.kt_3 */
    static BufferPoolConfig m8544a(Context context) {
        return new BufferPoolConfig(context);
    }

    private BufferPoolConfig(Context context) {
        if (context == null) {
            throw new RuntimeException("Failed to configure the Pool!");
        }
        this.f9471a = context.getApplicationContext();
        this.f9474d = true;
    }
}
