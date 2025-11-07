package com.oplus.anim;

import android.util.ArraySet;
import android.util.Pair;
import com.oplus.anim.p121f.MeanCalculator;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: PerformanceTracker.java */
/* renamed from: com.oplus.anim.OplusGLSurfaceView_6 */
/* loaded from: classes2.dex */
public class PerformanceTracker {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Set<PlatformImplementations.kt_3> f10449a = new ArraySet();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Map<String, MeanCalculator> f10450b = new HashMap();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final Comparator<Pair<String, Float>> f10451c = new Comparator<Pair<String, Float>>() { // from class: com.oplus.anim.OplusGLSurfaceView_6.1
        @Override // java.util.Comparator
        /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
        public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float fFloatValue = ((Float) pair.second).floatValue();
            float fFloatValue2 = ((Float) pair2.second).floatValue();
            if (fFloatValue2 > fFloatValue) {
                return 1;
            }
            return fFloatValue > fFloatValue2 ? -1 : 0;
        }
    };

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f10452d = false;

    /* compiled from: PerformanceTracker.java */
    /* renamed from: com.oplus.anim.OplusGLSurfaceView_6$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void m9355a(float COUIBaseListPopupWindow_12);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m9353a(boolean z) {
        this.f10452d = z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m9352a(String str, float COUIBaseListPopupWindow_12) {
        if (this.f10452d) {
            MeanCalculator c2406d = this.f10450b.get(str);
            if (c2406d == null) {
                c2406d = new MeanCalculator();
                this.f10450b.put(str, c2406d);
            }
            c2406d.m9272a(COUIBaseListPopupWindow_12);
            if (str.equals("__container")) {
                Iterator<PlatformImplementations.kt_3> it = this.f10449a.iterator();
                while (it.hasNext()) {
                    it.next().m9355a(COUIBaseListPopupWindow_12);
                }
            }
        }
    }
}
