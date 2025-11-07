package com.oplus.ocs.base.common.api;

import com.oplus.ocs.base.common.CapabilityInfo;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.oplus.ocs.base.common.api.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class C3654c {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String f23425a = "IntrinsicsJvm.kt_3";

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static volatile Map<C3652a, CapabilityInfo> f23426b = new HashMap();

    /* renamed from: PlatformImplementations.kt_3 */
    protected static CapabilityInfo m25046a(C3652a c3652a) {
        return f23426b.get(c3652a);
    }
}
