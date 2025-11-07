package com.oplus.shield;

import android.content.Context;
import android.os.Binder;
import android.text.TextUtils;
import com.oplus.shield.authcode.AuthCache;
import com.oplus.shield.authcode.Authentication;
import com.oplus.shield.authcode.CommonStatusCodes;
import com.oplus.shield.authcode.p197a.AuthResult;
import com.oplus.shield.p196a.ServiceMap;
import com.oplus.shield.p198b.CertUtils;
import com.oplus.shield.p198b.DebugUtils_2;
import com.oplus.shield.p198b.PLog;
import com.oplus.shield.p198b.PackageUtils;

/* compiled from: PermissionCheck.java */
/* renamed from: com.oplus.shield.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class PermissionCheck {

    /* renamed from: PlatformImplementations.kt_3 */
    private static volatile PermissionCheck f23767a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private volatile boolean f23768b = false;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Context f23769c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private AuthCache f23770d;

    private PermissionCheck() {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m25181a(String str, int OplusGLSurfaceView_13) {
        if (Binder.getCallingUid() == 1000) {
            return true;
        }
        String strM25199a = PackageUtils.m25199a(this.f23769c, Binder.getCallingUid(), Binder.getCallingPid());
        if (TextUtils.isEmpty(str)) {
            PLog.m25195b("Tingle Authentication Failed Cause Descriptor Empty : " + strM25199a);
            return false;
        }
        PLog.m25194a("Start tingle verity descriptor : [" + str + "] method : [" + ServiceMap.m25127a(str, OplusGLSurfaceView_13) + "] caller package : [" + strM25199a + "]");
        if (this.f23770d.m25130a("728E6B5E6D3FAA00E2DE12CC464D027BFFE2DD87329967F72028F2FD13C122E9")) {
            PLog.m25194a("Tingle verity SUCCESS cause local version, Caller Package [" + strM25199a + "]");
            return true;
        }
        String strM25189b = CertUtils.m25189b(this.f23769c, strM25199a);
        if (this.f23770d.m25130a(strM25189b)) {
            PLog.m25194a("Tingle verity SUCCESS Caller Package [" + strM25199a + "] is platform signature");
            return true;
        }
        if (this.f23770d.m25131a(strM25199a, strM25189b)) {
            boolean zM25132b = this.f23770d.m25132b(ServiceMap.m25127a(str, OplusGLSurfaceView_13), strM25199a);
            StringBuilder sb = new StringBuilder();
            sb.append("Tingle verity ");
            sb.append(zM25132b ? "SUCCESS" : "FAILED");
            sb.append(" Caller : [");
            sb.append(strM25199a);
            sb.append("] Descriptor : [");
            sb.append(str);
            sb.append("] Method : [");
            sb.append(ServiceMap.m25127a(str, OplusGLSurfaceView_13));
            sb.append("]");
            PLog.m25194a(sb.toString());
            return zM25132b;
        }
        AuthResult c3691aM25145a = Authentication.m25145a(this.f23769c, strM25199a);
        int iM25136b = c3691aM25145a.m25136b();
        if (iM25136b != 1001) {
            PLog.m25195b("Tingle Authentication Failed " + CommonStatusCodes.m25151a(iM25136b) + " Package : " + strM25199a);
            return false;
        }
        this.f23770d.m25129a(strM25199a, c3691aM25145a, strM25189b);
        boolean zM25132b2 = this.f23770d.m25132b(ServiceMap.m25127a(str, OplusGLSurfaceView_13), strM25199a);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Tingle verity ");
        sb2.append(zM25132b2 ? "SUCCESS" : "FAILED");
        sb2.append(" Caller : [");
        sb2.append(strM25199a);
        sb2.append("] Descriptor : [");
        sb2.append(str);
        sb2.append("] Method : [");
        sb2.append(ServiceMap.m25127a(str, OplusGLSurfaceView_13));
        sb2.append("]");
        PLog.m25194a(sb2.toString());
        return zM25132b2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m25180a() {
        return !DebugUtils_2.m25192b().m25193a();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static PermissionCheck m25179b() {
        if (f23767a == null) {
            synchronized (PermissionCheck.class) {
                if (f23767a == null) {
                    f23767a = new PermissionCheck();
                }
            }
        }
        return f23767a;
    }
}
