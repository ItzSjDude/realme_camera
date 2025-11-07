package com.oplus.shield;

/* compiled from: PermissionCheck.java */
/* loaded from: classes2.dex */
public class b_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static volatile com.oplus.shield.b_renamed f7627a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private volatile boolean f7628b = false;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.content.Context f7629c;
    private com.oplus.shield.authcode.a_renamed d_renamed;

    private b_renamed() {
    }

    public boolean a_renamed(java.lang.String str, int i_renamed) {
        if (android.os.Binder.getCallingUid() == 1000) {
            return true;
        }
        java.lang.String strA = com.oplus.shield.b_renamed.e_renamed.a_renamed(this.f7629c, android.os.Binder.getCallingUid(), android.os.Binder.getCallingPid());
        if (android.text.TextUtils.isEmpty(str)) {
            com.oplus.shield.b_renamed.d_renamed.b_renamed("Tingle Authentication Failed Cause Descriptor Empty : " + strA);
            return false;
        }
        com.oplus.shield.b_renamed.d_renamed.a_renamed("Start tingle verity descriptor : [" + str + "] method : [" + com.oplus.shield.a_renamed.b_renamed.a_renamed(str, i_renamed) + "] caller package : [" + strA + "]");
        if (this.d_renamed.a_renamed("728E6B5E6D3FAA00E2DE12CC464D027BFFE2DD87329967F72028F2FD13C122E9")) {
            com.oplus.shield.b_renamed.d_renamed.a_renamed("Tingle verity SUCCESS cause local version, Caller Package [" + strA + "]");
            return true;
        }
        java.lang.String strB = com.oplus.shield.b_renamed.b_renamed.b_renamed(this.f7629c, strA);
        if (this.d_renamed.a_renamed(strB)) {
            com.oplus.shield.b_renamed.d_renamed.a_renamed("Tingle verity SUCCESS Caller Package [" + strA + "] is_renamed platform signature");
            return true;
        }
        if (this.d_renamed.a_renamed(strA, strB)) {
            boolean zB = this.d_renamed.b_renamed(com.oplus.shield.a_renamed.b_renamed.a_renamed(str, i_renamed), strA);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Tingle verity ");
            sb.append(zB ? "SUCCESS" : "FAILED");
            sb.append(" Caller : [");
            sb.append(strA);
            sb.append("] Descriptor : [");
            sb.append(str);
            sb.append("] Method : [");
            sb.append(com.oplus.shield.a_renamed.b_renamed.a_renamed(str, i_renamed));
            sb.append("]");
            com.oplus.shield.b_renamed.d_renamed.a_renamed(sb.toString());
            return zB;
        }
        com.oplus.shield.authcode.a_renamed.a_renamed aVarA = com.oplus.shield.authcode.b_renamed.a_renamed(this.f7629c, strA);
        int iB = aVarA.b_renamed();
        if (iB != 1001) {
            com.oplus.shield.b_renamed.d_renamed.b_renamed("Tingle Authentication Failed " + com.oplus.shield.authcode.c_renamed.a_renamed(iB) + " Package : " + strA);
            return false;
        }
        this.d_renamed.a_renamed(strA, aVarA, strB);
        boolean zB2 = this.d_renamed.b_renamed(com.oplus.shield.a_renamed.b_renamed.a_renamed(str, i_renamed), strA);
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append("Tingle verity ");
        sb2.append(zB2 ? "SUCCESS" : "FAILED");
        sb2.append(" Caller : [");
        sb2.append(strA);
        sb2.append("] Descriptor : [");
        sb2.append(str);
        sb2.append("] Method : [");
        sb2.append(com.oplus.shield.a_renamed.b_renamed.a_renamed(str, i_renamed));
        sb2.append("]");
        com.oplus.shield.b_renamed.d_renamed.a_renamed(sb2.toString());
        return zB2;
    }

    public boolean a_renamed() {
        return !com.oplus.shield.b_renamed.c_renamed.b_renamed().a_renamed();
    }

    public static com.oplus.shield.b_renamed b_renamed() {
        if (f7627a == null) {
            synchronized (com.oplus.shield.b_renamed.class) {
                if (f7627a == null) {
                    f7627a = new com.oplus.shield.b_renamed();
                }
            }
        }
        return f7627a;
    }
}
