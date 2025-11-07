package com.airbnb.lottie.p080a.p081a;

import android.graphics.Path;
import com.airbnb.lottie.p091f.Utils_4;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CompoundTrimPathContent.java */
/* renamed from: com.airbnb.lottie.PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
public class CompoundTrimPathContent_2 {

    /* renamed from: PlatformImplementations.kt_3 */
    private List<TrimPathContent_2> f5284a = new ArrayList();

    /* renamed from: PlatformImplementations.kt_3 */
    void m5539a(TrimPathContent_2 c1067s) {
        this.f5284a.add(c1067s);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m5538a(Path path) {
        for (int size = this.f5284a.size() - 1; size >= 0; size--) {
            Utils_4.m6148a(path, this.f5284a.get(size));
        }
    }
}
