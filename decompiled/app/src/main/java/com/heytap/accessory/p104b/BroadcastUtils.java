package com.heytap.accessory.p104b;

import android.content.Intent;
import com.heytap.accessory.BaseJobAgent;

/* compiled from: BroadcastUtils.java */
/* renamed from: com.heytap.accessory.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class BroadcastUtils {
    /* renamed from: PlatformImplementations.kt_3 */
    public static Intent m8569a(String str) {
        Intent intent = new Intent(BaseJobAgent.ACTION_REGISTRATION_REQUIRED);
        intent.setPackage(str);
        intent.addFlags(32);
        intent.addFlags(536870912);
        return intent;
    }
}
