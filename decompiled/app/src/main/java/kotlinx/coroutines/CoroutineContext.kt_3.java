package kotlinx.coroutines;

import kotlinx.coroutines.p216b.Dispatcher.kt_3;
import p061c.p064c.ContinuationInterceptor.kt;
import p061c.p064c.CoroutineContext.kt_4;

/* compiled from: CoroutineContext.kt */
/* renamed from: kotlinx.coroutines.s */
/* loaded from: classes2.dex */
public final class CoroutineContext.kt_3 {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final boolean f24738a;

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0028, code lost:
    
        if (r0.equals("on") != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0031, code lost:
    
        if (r0.equals("") != false) goto L19;
     */
    static {
        /*
            java.lang.String r0 = "kotlinx.coroutines.scheduler"
            java.lang.String r0 = kotlinx.coroutines.internal.C3941s.m25903a(r0)
            if (r0 != 0) goto L9
            goto L33
        L9:
            int r1 = r0.hashCode()
            if (r1 == 0) goto L2b
            r2 = 3551(0xddf, float:4.976E-42)
            if (r1 == r2) goto L22
            r2 = 109935(0x1ad6f, float:1.54052E-40)
            if (r1 != r2) goto L37
            java.lang.String r1 = "off"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L37
            r0 = 0
            goto L34
        L22:
            java.lang.String r1 = "on"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L37
            goto L33
        L2b:
            java.lang.String r1 = ""
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L37
        L33:
            r0 = 1
        L34:
            kotlinx.coroutines.CoroutineContext.kt_3.f24738a = r0
            return
        L37:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "System property 'kotlinx.coroutines.scheduler' has unrecognized value '"
            r1.append(r2)
            r1.append(r0)
            r0 = 39
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.CoroutineContext.kt_3.<clinit>():void");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final CoroutineDispatcher.kt m25943a() {
        return f24738a ? Dispatcher.kt_3.f24619b : CommonPool.kt.f24728b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final CoroutineContext.kt_4 m25941a(CoroutineScope.kt_2 interfaceC3963y, CoroutineContext.kt_4 interfaceC0932g) {
        CoroutineContext.kt_4 interfaceC0932gPlus = interfaceC3963y.mo25556a().plus(interfaceC0932g);
        CoroutineContext.kt_4 interfaceC0932gPlus2 = Debug.kt.m25575b() ? interfaceC0932gPlus.plus(new CoroutineContext.kt(Debug.kt.m25577d().incrementAndGet())) : interfaceC0932gPlus;
        return (interfaceC0932gPlus == Dispatchers.kt.m25601a() || interfaceC0932gPlus.get(ContinuationInterceptor.kt.f5037a) != null) ? interfaceC0932gPlus2 : interfaceC0932gPlus2.plus(Dispatchers.kt.m25601a());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final String m25942a(CoroutineContext.kt_4 interfaceC0932g) {
        CoroutineContext.kt c3961w;
        String strM25949a;
        if (!Debug.kt.m25575b() || (c3961w = (CoroutineContext.kt) interfaceC0932g.get(CoroutineContext.kt.f24741a)) == null) {
            return null;
        }
        CoroutineName.kt c3962x = (CoroutineName.kt) interfaceC0932g.get(CoroutineName.kt.f24743a);
        if (c3962x == null || (strM25949a = c3962x.m25949a()) == null) {
            strM25949a = "coroutine";
        }
        return strM25949a + '#' + c3961w.m25947a();
    }
}
