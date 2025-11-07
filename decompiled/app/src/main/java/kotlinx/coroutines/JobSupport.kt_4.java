package kotlinx.coroutines;

import kotlinx.coroutines.internal.LockFreeLinkedList.kt_5;
import kotlinx.coroutines.internal.LockFreeLinkedList.kt;
import p061c.p070f.p072b.Intrinsics;

/* compiled from: JobSupport.kt */
/* renamed from: kotlinx.coroutines.bg_renamed */
/* loaded from: classes2.dex */
public final class JobSupport.kt_4 extends LockFreeLinkedList.kt_5 implements JobSupport.kt_13 {
    @Override // kotlinx.coroutines.JobSupport.kt_13
    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean mo25605b() {
        return true;
    }

    @Override // kotlinx.coroutines.JobSupport.kt_13
    /* renamed from: k_ */
    public JobSupport.kt_4 mo25606k_() {
        return this;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public final String m25787a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("List{");
        sb.append(str);
        sb.append("}[");
        Object objE = m25856e();
        if (objE == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        }
        boolean z = true;
        for (LockFreeLinkedList.kt c3931iM25857f = (LockFreeLinkedList.kt) objE; !Intrinsics.m5299a(c3931iM25857f, r5); c3931iM25857f = c3931iM25857f.m25857f()) {
            if (c3931iM25857f instanceof JobSupport.kt_12) {
                JobSupport.kt_12 abstractC3899bb = (JobSupport.kt_12) c3931iM25857f;
                if (z) {
                    z = false;
                } else {
                    sb.append(", ");
                }
                sb.append(abstractC3899bb);
            }
        }
        sb.append("]");
        String string = sb.toString();
        Intrinsics.m5301b(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedList.kt
    public String toString() {
        return Debug.kt.m25575b() ? m25787a("Active") : super.toString();
    }
}
