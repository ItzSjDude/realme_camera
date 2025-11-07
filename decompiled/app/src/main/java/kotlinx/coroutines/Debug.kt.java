package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicLong;

/* compiled from: Debug.kt */
/* renamed from: kotlinx.coroutines.ac */
/* loaded from: classes2.dex */
public final class Debug.kt {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final boolean f24552a = CoroutineContext.kt.class.desiredAssertionStatus();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final boolean f24553b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final boolean f24554c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static final AtomicLong f24555d;

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
    
        if (r0.equals("auto") != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
    
        if (r0.equals("on") != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004b, code lost:
    
        if (r0.equals("") != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004d, code lost:
    
        r0 = true;
     */
    static {
        /*
            java.lang.Class<kotlinx.coroutines.w> r0 = kotlinx.coroutines.CoroutineContext.kt.class
            boolean r0 = r0.desiredAssertionStatus()
            kotlinx.coroutines.Debug.kt.f24552a = r0
            java.lang.String r0 = "kotlinx.coroutines.debug"
            java.lang.String r0 = kotlinx.coroutines.internal.C3941s.m25903a(r0)
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L13
            goto L2f
        L13:
            int r3 = r0.hashCode()
            if (r3 == 0) goto L45
            r4 = 3551(0xddf, float:4.976E-42)
            if (r3 == r4) goto L3c
            r4 = 109935(0x1ad6f, float:1.54052E-40)
            if (r3 == r4) goto L32
            r4 = 3005871(0x2dddaf, float:4.212122E-39)
            if (r3 != r4) goto L69
            java.lang.String r3 = "auto"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L69
        L2f:
            boolean r0 = kotlinx.coroutines.Debug.kt.f24552a
            goto L4e
        L32:
            java.lang.String r3 = "off"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L69
            r0 = r1
            goto L4e
        L3c:
            java.lang.String r3 = "on"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L69
            goto L4d
        L45:
            java.lang.String r3 = ""
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L69
        L4d:
            r0 = r2
        L4e:
            kotlinx.coroutines.Debug.kt.f24553b = r0
            boolean r0 = kotlinx.coroutines.Debug.kt.f24553b
            if (r0 == 0) goto L5d
            java.lang.String r0 = "kotlinx.coroutines.stacktrace.recovery"
            boolean r0 = kotlinx.coroutines.internal.C3941s.m25904a(r0, r2)
            if (r0 == 0) goto L5d
            r1 = r2
        L5d:
            kotlinx.coroutines.Debug.kt.f24554c = r1
            java.util.concurrent.atomic.AtomicLong r0 = new java.util.concurrent.atomic.AtomicLong
            r1 = 0
            r0.<init>(r1)
            kotlinx.coroutines.Debug.kt.f24555d = r0
            return
        L69:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "System property 'kotlinx.coroutines.debug' has unrecognized value '"
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
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.Debug.kt.<clinit>():void");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static final boolean m25574a() {
        return f24552a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final boolean m25575b() {
        return f24553b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static final boolean m25576c() {
        return f24554c;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static final AtomicLong m25577d() {
        return f24555d;
    }
}
