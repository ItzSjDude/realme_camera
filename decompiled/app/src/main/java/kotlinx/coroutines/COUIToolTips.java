package kotlinx.coroutines;

/* compiled from: CoroutineContext.kt */
/* loaded from: classes2.dex */
public final class s_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final boolean f7903a;

    /* JADX WARN: Code restructure failed: missing block: B_renamed:15:0x0028, code lost:
    
        if (r0.equals("on_renamed") != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B_renamed:18:0x0031, code lost:
    
        if (r0.equals("") != false) goto L19;
     */
    static {
        /*
            java.lang.String r0 = "kotlinx.coroutines.scheduler"
            java.lang.String r0 = kotlinx.coroutines.internal.s_renamed.a_renamed(r0)
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
            java.lang.String r1 = "on_renamed"
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
            kotlinx.coroutines.s_renamed.f7903a = r0
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
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.s_renamed.<clinit>():void");
    }

    public static final kotlinx.coroutines.t_renamed a_renamed() {
        return f7903a ? kotlinx.coroutines.b_renamed.c_renamed.f7822b : kotlinx.coroutines.k_renamed.f7895b;
    }

    public static final c_renamed.c_renamed.g_renamed a_renamed(kotlinx.coroutines.y_renamed yVar, c_renamed.c_renamed.g_renamed gVar) {
        c_renamed.c_renamed.g_renamed gVarPlus = yVar.a_renamed().plus(gVar);
        c_renamed.c_renamed.g_renamed gVarPlus2 = kotlinx.coroutines.ac_renamed.b_renamed() ? gVarPlus.plus(new kotlinx.coroutines.w_renamed(kotlinx.coroutines.ac_renamed.d_renamed().incrementAndGet())) : gVarPlus;
        return (gVarPlus == kotlinx.coroutines.aj_renamed.a_renamed() || gVarPlus.get(c_renamed.c_renamed.e_renamed.f1897a) != null) ? gVarPlus2 : gVarPlus2.plus(kotlinx.coroutines.aj_renamed.a_renamed());
    }

    public static final java.lang.String a_renamed(c_renamed.c_renamed.g_renamed gVar) {
        kotlinx.coroutines.w_renamed wVar;
        java.lang.String strA;
        if (!kotlinx.coroutines.ac_renamed.b_renamed() || (wVar = (kotlinx.coroutines.w_renamed) gVar.get(kotlinx.coroutines.w_renamed.f7906a)) == null) {
            return null;
        }
        kotlinx.coroutines.x_renamed xVar = (kotlinx.coroutines.x_renamed) gVar.get(kotlinx.coroutines.x_renamed.f7908a);
        if (xVar == null || (strA = xVar.a_renamed()) == null) {
            strA = "coroutine";
        }
        return strA + '#' + wVar.a_renamed();
    }
}
