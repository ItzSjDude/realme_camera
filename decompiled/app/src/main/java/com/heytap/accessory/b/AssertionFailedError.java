package com.heytap.accessory.b_renamed;

/* compiled from: BroadcastUtils.java */
/* loaded from: classes2.dex */
public class b_renamed {
    public static android.content.Intent a_renamed(java.lang.String str) {
        android.content.Intent intent = new android.content.Intent(com.heytap.accessory.BaseJobAgent.ACTION_REGISTRATION_REQUIRED);
        intent.setPackage(str);
        intent.addFlags(32);
        intent.addFlags(536870912);
        return intent;
    }
}
