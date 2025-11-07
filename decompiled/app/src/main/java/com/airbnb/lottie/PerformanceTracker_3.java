package com.airbnb.lottie;

import androidx.collection.ArraySet;
import androidx.core.p035g.Pair;
import com.airbnb.lottie.p091f.MeanCalculator_2;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: PerformanceTracker.java */
/* renamed from: com.airbnb.lottie.OplusGLSurfaceView_11 */
/* loaded from: classes.dex */
public class PerformanceTracker_3 {

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean f5963a = false;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Set<PlatformImplementations.kt_3> f5964b = new ArraySet();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final Map<String, MeanCalculator_2> f5965c = new HashMap();

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final Comparator<Pair<String, Float>> f5966d = new Comparator<Pair<String, Float>>() { // from class: com.airbnb.lottie.OplusGLSurfaceView_11.1
        @Override // java.util.Comparator
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public int compare(Pair<String, Float> c0457d, Pair<String, Float> c0457d2) {
            float fFloatValue = c0457d.f2938b.floatValue();
            float fFloatValue2 = c0457d2.f2938b.floatValue();
            if (fFloatValue2 > fFloatValue) {
                return 1;
            }
            return fFloatValue > fFloatValue2 ? -1 : 0;
        }
    };

    /* compiled from: PerformanceTracker.java */
    /* renamed from: com.airbnb.lottie.OplusGLSurfaceView_11$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void m6196a(float COUIBaseListPopupWindow_12);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m6194a(boolean z) {
        this.f5963a = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m6193a(String str, float COUIBaseListPopupWindow_12) {
        if (this.f5963a) {
            MeanCalculator_2 c1193f = this.f5965c.get(str);
            if (c1193f == null) {
                c1193f = new MeanCalculator_2();
                this.f5965c.put(str, c1193f);
            }
            c1193f.m6125a(COUIBaseListPopupWindow_12);
            if (str.equals("__container")) {
                Iterator<PlatformImplementations.kt_3> it = this.f5964b.iterator();
                while (it.hasNext()) {
                    it.next().m6196a(COUIBaseListPopupWindow_12);
                }
            }
        }
    }
}
