package com.airbnb.lottie;

/* compiled from: PerformanceTracker.java */
/* loaded from: classes.dex */
public class n_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private boolean f2287a = false;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.util.Set<com.airbnb.lottie.n_renamed.a_renamed> f2288b = new androidx.collection.ArraySet();

    /* renamed from: c_renamed, reason: collision with root package name */
    private final java.util.Map<java.lang.String, com.airbnb.lottie.f_renamed.f_renamed> f2289c = new java.util.HashMap();
    private final java.util.Comparator<androidx.core.g_renamed.d_renamed<java.lang.String, java.lang.Float>> d_renamed = new java.util.Comparator<androidx.core.g_renamed.d_renamed<java.lang.String, java.lang.Float>>() { // from class: com.airbnb.lottie.n_renamed.1
        @Override // java.util.Comparator
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public int compare(androidx.core.g_renamed.d_renamed<java.lang.String, java.lang.Float> dVar, androidx.core.g_renamed.d_renamed<java.lang.String, java.lang.Float> dVar2) {
            float fFloatValue = dVar.f919b.floatValue();
            float fFloatValue2 = dVar2.f919b.floatValue();
            if (fFloatValue2 > fFloatValue) {
                return 1;
            }
            return fFloatValue > fFloatValue2 ? -1 : 0;
        }
    };

    /* compiled from: PerformanceTracker.java */
    public interface a_renamed {
        void a_renamed(float f_renamed);
    }

    void a_renamed(boolean z_renamed) {
        this.f2287a = z_renamed;
    }

    public void a_renamed(java.lang.String str, float f_renamed) {
        if (this.f2287a) {
            com.airbnb.lottie.f_renamed.f_renamed fVar = this.f2289c.get(str);
            if (fVar == null) {
                fVar = new com.airbnb.lottie.f_renamed.f_renamed();
                this.f2289c.put(str, fVar);
            }
            fVar.a_renamed(f_renamed);
            if (str.equals("__container")) {
                java.util.Iterator<com.airbnb.lottie.n_renamed.a_renamed> it = this.f2288b.iterator();
                while (it.hasNext()) {
                    it.next().a_renamed(f_renamed);
                }
            }
        }
    }
}
