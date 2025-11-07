package com.oplus.anim.p111a.p112a;

import android.graphics.Path;
import com.oplus.anim.p121f.Utils_2;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CompoundTrimPathContent.java */
/* renamed from: com.oplus.anim.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class CompoundTrimPathContent {

    /* renamed from: PlatformImplementations.kt_3 */
    private List<TrimPathContent> f9880a = new ArrayList();

    /* renamed from: PlatformImplementations.kt_3 */
    void m8815a(TrimPathContent c2292s) {
        this.f9880a.add(c2292s);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8814a(Path path) {
        for (int size = this.f9880a.size() - 1; size >= 0; size--) {
            Utils_2.m9294a(path, this.f9880a.get(size));
        }
    }
}
