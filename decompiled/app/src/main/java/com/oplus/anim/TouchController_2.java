package com.oplus.anim;

/* compiled from: PerformanceTracker.java */
/* loaded from: classes2.dex */
public class m_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final java.util.Set<com.oplus.anim.m_renamed.a_renamed> f3715a = new android.util.ArraySet();

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.util.Map<java.lang.String, com.oplus.anim.f_renamed.d_renamed> f3716b = new java.util.HashMap();

    /* renamed from: c_renamed, reason: collision with root package name */
    private final java.util.Comparator<android.util.Pair<java.lang.String, java.lang.Float>> f3717c = new java.util.Comparator<android.util.Pair<java.lang.String, java.lang.Float>>() { // from class: com.oplus.anim.m_renamed.1
        @Override // java.util.Comparator
        /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
        public int compare(android.util.Pair<java.lang.String, java.lang.Float> pair, android.util.Pair<java.lang.String, java.lang.Float> pair2) {
            float fFloatValue = ((java.lang.Float) pair.second).floatValue();
            float fFloatValue2 = ((java.lang.Float) pair2.second).floatValue();
            if (fFloatValue2 > fFloatValue) {
                return 1;
            }
            return fFloatValue > fFloatValue2 ? -1 : 0;
        }
    };
    private boolean d_renamed = false;

    /* compiled from: PerformanceTracker.java */
    public interface a_renamed {
        void a_renamed(float f_renamed);
    }

    void a_renamed(boolean z_renamed) {
        this.d_renamed = z_renamed;
    }

    public void a_renamed(java.lang.String str, float f_renamed) {
        if (this.d_renamed) {
            com.oplus.anim.f_renamed.d_renamed dVar = this.f3716b.get(str);
            if (dVar == null) {
                dVar = new com.oplus.anim.f_renamed.d_renamed();
                this.f3716b.put(str, dVar);
            }
            dVar.a_renamed(f_renamed);
            if (str.equals("__container")) {
                java.util.Iterator<com.oplus.anim.m_renamed.a_renamed> it = this.f3715a.iterator();
                while (it.hasNext()) {
                    it.next().a_renamed(f_renamed);
                }
            }
        }
    }
}
