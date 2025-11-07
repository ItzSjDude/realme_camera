package com.oplus.camera.p172ui.menu;

import java.util.ArrayList;
import java.util.List;

/* compiled from: OptionItemConfig.java */
/* renamed from: com.oplus.camera.ui.menu.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class OptionItemConfig {

    /* renamed from: PlatformImplementations.kt_3 */
    private String f19133a = null;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private List<String> f19134b;

    public OptionItemConfig() {
        this.f19134b = null;
        this.f19134b = new ArrayList();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m20468a() {
        return this.f19133a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m20469a(String str) {
        this.f19133a = str;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m20471b(String str) {
        if (this.f19134b.contains(str)) {
            return;
        }
        this.f19134b.add(str);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public List<String> m20470b() {
        return this.f19134b;
    }
}
