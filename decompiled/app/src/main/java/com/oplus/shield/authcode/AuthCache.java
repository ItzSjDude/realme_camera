package com.oplus.shield.authcode;

import android.content.Context;
import android.text.TextUtils;
import android.util.LruCache;
import com.oplus.shield.authcode.p197a.AuthResult;
import com.oplus.shield.p198b.PackageUtils;
import java.util.Arrays;

/* compiled from: AuthCache.java */
/* renamed from: com.oplus.shield.authcode.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class AuthCache {

    /* renamed from: PlatformImplementations.kt_3 */
    private LruCache<String, AuthResult> f23735a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Context f23736b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private String f23737c;

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m25130a(String str) {
        return TextUtils.equals(this.f23737c, str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m25131a(String str, String str2) {
        AuthResult c3691aM25146a = Authentication.m25146a(this.f23736b, str, PackageUtils.m25201b(this.f23736b, str));
        AuthResult c3691a = this.f23735a.get(str);
        if (c3691aM25146a == null || c3691a == null || c3691a.m25139e() || !TextUtils.equals(str2, c3691a.m25138d())) {
            return false;
        }
        return Arrays.equals(c3691aM25146a.m25135a(), c3691a.m25135a());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m25129a(String str, AuthResult c3691a, String str2) {
        c3691a.m25140f();
        c3691a.m25137c();
        c3691a.m25133a(str2);
        this.f23735a.put(str, c3691a);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m25132b(String str, String str2) {
        AuthResult c3691a = this.f23735a.get(str2);
        if (c3691a != null) {
            return c3691a.m25134a("tingle", str);
        }
        return false;
    }
}
