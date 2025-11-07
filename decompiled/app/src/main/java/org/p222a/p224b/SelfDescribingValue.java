package org.p222a.p224b;

import org.p222a.Description;
import org.p222a.SelfDescribing;

/* compiled from: SelfDescribingValue.java */
/* renamed from: org.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class SelfDescribingValue<T> implements SelfDescribing {

    /* renamed from: PlatformImplementations.kt_3 */
    private T f24795a;

    public SelfDescribingValue(T t) {
        this.f24795a = t;
    }

    @Override // org.p222a.SelfDescribing
    public void describeTo(Description interfaceC4037d) {
        interfaceC4037d.mo26017a(this.f24795a);
    }
}
