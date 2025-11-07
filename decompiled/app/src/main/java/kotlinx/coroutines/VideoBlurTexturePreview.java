package kotlinx.coroutines;

/* compiled from: Debug.kt */
/* loaded from: classes2.dex */
public final class ac_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final boolean f7784a = kotlinx.coroutines.w_renamed.class.desiredAssertionStatus();

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final boolean f7785b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private static final boolean f7786c;
    private static final java.util.concurrent.atomic.AtomicLong d_renamed;

    /* JADX WARN: Code restructure failed: missing block: B_renamed:14:0x002d, code lost:
    
        if (r0.equals("auto") != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:20:0x0042, code lost:
    
        if (r0.equals("on_renamed") != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:23:0x004b, code lost:
    
        if (r0.equals("") != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:24:0x004d, code lost:
    
        r0 = true;
     */
    static {
        /*
            java.lang.Class<kotlinx.coroutines.w_renamed> r0 = kotlinx.coroutines.w_renamed.class
            boolean r0 = r0.desiredAssertionStatus()
            kotlinx.coroutines.ac_renamed.f7784a = r0
            java.lang.String r0 = "kotlinx.coroutines.debug"
            java.lang.String r0 = kotlinx.coroutines.internal.s_renamed.a_renamed(r0)
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
            boolean r0 = kotlinx.coroutines.ac_renamed.f7784a
            goto L4e
        L32:
            java.lang.String r3 = "off"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L69
            r0 = r1
            goto L4e
        L3c:
            java.lang.String r3 = "on_renamed"
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
            kotlinx.coroutines.ac_renamed.f7785b = r0
            boolean r0 = kotlinx.coroutines.ac_renamed.f7785b
            if (r0 == 0) goto L5d
            java.lang.String r0 = "kotlinx.coroutines.stacktrace.recovery"
            boolean r0 = kotlinx.coroutines.internal.s_renamed.a_renamed(r0, r2)
            if (r0 == 0) goto L5d
            r1 = r2
        L5d:
            kotlinx.coroutines.ac_renamed.f7786c = r1
            java.util.concurrent.atomic.AtomicLong r0 = new java.util.concurrent.atomic.AtomicLong
            r1 = 0
            r0.<init>(r1)
            kotlinx.coroutines.ac_renamed.d_renamed = r0
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
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.ac_renamed.<clinit>():void");
    }

    public static final boolean a_renamed() {
        return f7784a;
    }

    public static final boolean b_renamed() {
        return f7785b;
    }

    public static final boolean c_renamed() {
        return f7786c;
    }

    public static final java.util.concurrent.atomic.AtomicLong d_renamed() {
        return d_renamed;
    }
}
