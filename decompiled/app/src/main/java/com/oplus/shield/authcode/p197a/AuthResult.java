package com.oplus.shield.authcode.p197a;

import android.text.TextUtils;
import com.oplus.shield.Constants;
import com.oplus.shield.authcode.PermissionTable;
import com.oplus.shield.p198b.PLog;
import com.oplus.shield.p198b.SystemUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: AuthResult.java */
/* renamed from: com.oplus.shield.authcode.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class AuthResult {

    /* renamed from: PlatformImplementations.kt_3 */
    private String f23738a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f23739b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private byte[] f23740c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private long f23741d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Map<String, PermissionTable> f23742e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private String f23743f;

    public AuthResult(String str, int OplusGLSurfaceView_13, byte[] bArr) {
        this.f23738a = str;
        this.f23739b = OplusGLSurfaceView_13;
        this.f23740c = bArr;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public byte[] m25135a() {
        return this.f23740c;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m25136b() {
        return this.f23739b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m25137c() {
        this.f23741d = System.currentTimeMillis();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m25133a(String str) {
        this.f23743f = str;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public String m25138d() {
        return this.f23743f;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean m25139e() {
        return System.currentTimeMillis() - this.f23741d > Constants.f23728a;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m25140f() {
        this.f23742e = new ConcurrentHashMap();
        for (String str : SystemUtils.m25211a(new String(this.f23740c), ";")) {
            int iIndexOf = str.indexOf(",");
            if (iIndexOf != -1) {
                String strSubstring = str.substring(0, iIndexOf);
                String strSubstring2 = str.substring(iIndexOf + 1);
                if (TextUtils.equals(strSubstring, "epona") || TextUtils.equals(strSubstring, "tingle")) {
                    this.f23742e.put(strSubstring, new PermissionTable(strSubstring2));
                    PLog.m25194a("Package : " + this.f23738a + " Permission : type [" + strSubstring + "] -" + SystemUtils.m25211a(strSubstring2, ","));
                }
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m25134a(String str, String str2) {
        PermissionTable c3695d = this.f23742e.get(str);
        if (c3695d != null) {
            return c3695d.m25152a(str2);
        }
        return false;
    }
}
