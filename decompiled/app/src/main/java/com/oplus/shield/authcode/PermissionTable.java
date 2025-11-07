package com.oplus.shield.authcode;

import com.oplus.shield.p198b.SystemUtils;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: PermissionTable.java */
/* renamed from: com.oplus.shield.authcode.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class PermissionTable {

    /* renamed from: PlatformImplementations.kt_3 */
    private List<String> f23746a = new CopyOnWriteArrayList();

    public PermissionTable(String str) {
        this.f23746a.clear();
        this.f23746a.addAll(SystemUtils.m25211a(str, ","));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m25152a(String str) {
        if (this.f23746a.size() != 0) {
            return this.f23746a.contains(str);
        }
        return false;
    }
}
