package com.airbnb.lottie.a_renamed.b_renamed;

/* compiled from: BaseKeyframeAnimation.java */
/* loaded from: classes.dex */
public abstract class a_renamed<K_renamed, A_renamed> {

    /* renamed from: c_renamed, reason: collision with root package name */
    protected com.airbnb.lottie.g_renamed.c_renamed<A_renamed> f2030c;
    private final com.airbnb.lottie.a_renamed.b_renamed.a_renamed.c_renamed<K_renamed> e_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    final java.util.List<com.airbnb.lottie.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_4> f2028a = new java.util.ArrayList(1);
    private boolean d_renamed = false;

    /* renamed from: b_renamed, reason: collision with root package name */
    protected float f2029b = 0.0f;
    private A_renamed f_renamed = null;
    private float g_renamed = -1.0f;
    private float h_renamed = -1.0f;

    /* compiled from: BaseKeyframeAnimation.java */
    /* renamed from: com.airbnb.lottie.a_renamed.b_renamed.a_renamed$a_renamed, reason: collision with other inner class name */
    public interface BaseKeyframeAnimation_4 {
        void a_renamed();
    }

    /* compiled from: BaseKeyframeAnimation.java */
    private interface c_renamed<T_renamed> {
        boolean a_renamed();

        boolean a_renamed(float f_renamed);

        com.airbnb.lottie.g_renamed.a_renamed<T_renamed> b_renamed();

        boolean b_renamed(float f_renamed);

        float c_renamed();

        float d_renamed();
    }

    abstract A_renamed a_renamed(com.airbnb.lottie.g_renamed.a_renamed<K_renamed> aVar, float f_renamed);

    a_renamed(java.util.List<? extends com.airbnb.lottie.g_renamed.a_renamed<K_renamed>> list) {
        this.e_renamed = a_renamed(list);
    }

    public void a_renamed() {
        this.d_renamed = true;
    }

    public void a_renamed(com.airbnb.lottie.a_renamed.b_renamed.a_renamed.BaseKeyframeAnimation_4 interfaceC0051a) {
        this.f2028a.add(interfaceC0051a);
    }

    public void a_renamed(float f_renamed) {
        if (this.e_renamed.a_renamed()) {
            return;
        }
        if (f_renamed < i_renamed()) {
            f_renamed = i_renamed();
        } else if (f_renamed > f_renamed()) {
            f_renamed = f_renamed();
        }
        if (f_renamed == this.f2029b) {
            return;
        }
        this.f2029b = f_renamed;
        if (this.e_renamed.a_renamed(f_renamed)) {
            b_renamed();
        }
    }

    public void b_renamed() {
        for (int i_renamed = 0; i_renamed < this.f2028a.size(); i_renamed++) {
            this.f2028a.get(i_renamed).a_renamed();
        }
    }

    protected com.airbnb.lottie.g_renamed.a_renamed<K_renamed> c_renamed() {
        com.airbnb.lottie.c_renamed.a_renamed("BaseKeyframeAnimation#getCurrentKeyframe");
        com.airbnb.lottie.g_renamed.a_renamed<K_renamed> aVarB = this.e_renamed.b_renamed();
        com.airbnb.lottie.c_renamed.b_renamed("BaseKeyframeAnimation#getCurrentKeyframe");
        return aVarB;
    }

    float d_renamed() {
        if (this.d_renamed) {
            return 0.0f;
        }
        com.airbnb.lottie.g_renamed.a_renamed<K_renamed> aVarC = c_renamed();
        if (aVarC.e_renamed()) {
            return 0.0f;
        }
        return (this.f2029b - aVarC.c_renamed()) / (aVarC.d_renamed() - aVarC.c_renamed());
    }

    protected float e_renamed() {
        com.airbnb.lottie.g_renamed.a_renamed<K_renamed> aVarC = c_renamed();
        if (aVarC.e_renamed()) {
            return 0.0f;
        }
        return aVarC.f2268c.getInterpolation(d_renamed());
    }

    private float i_renamed() {
        if (this.g_renamed == -1.0f) {
            this.g_renamed = this.e_renamed.c_renamed();
        }
        return this.g_renamed;
    }

    float f_renamed() {
        if (this.h_renamed == -1.0f) {
            this.h_renamed = this.e_renamed.d_renamed();
        }
        return this.h_renamed;
    }

    public A_renamed g_renamed() {
        A_renamed a2;
        float fD_renamed = d_renamed();
        if (this.f2030c == null && this.e_renamed.b_renamed(fD_renamed)) {
            return this.f_renamed;
        }
        com.airbnb.lottie.g_renamed.a_renamed<K_renamed> aVarC = c_renamed();
        if (aVarC.d_renamed != null && aVarC.e_renamed != null) {
            a2 = a_renamed(aVarC, fD_renamed, aVarC.d_renamed.getInterpolation(fD_renamed), aVarC.e_renamed.getInterpolation(fD_renamed));
        } else {
            a2 = a_renamed(aVarC, e_renamed());
        }
        this.f_renamed = a2;
        return a2;
    }

    public float h_renamed() {
        return this.f2029b;
    }

    public void a_renamed(com.airbnb.lottie.g_renamed.c_renamed<A_renamed> cVar) {
        com.airbnb.lottie.g_renamed.c_renamed<A_renamed> cVar2 = this.f2030c;
        if (cVar2 != null) {
            cVar2.a_renamed((com.airbnb.lottie.a_renamed.b_renamed.a_renamed<?, ?>) null);
        }
        this.f2030c = cVar;
        if (cVar != null) {
            cVar.a_renamed((com.airbnb.lottie.a_renamed.b_renamed.a_renamed<?, ?>) this);
        }
    }

    protected A_renamed a_renamed(com.airbnb.lottie.g_renamed.a_renamed<K_renamed> aVar, float f_renamed, float f2, float f3) {
        throw new java.lang.UnsupportedOperationException("This animation does not support split dimensions!");
    }

    private static <T_renamed> com.airbnb.lottie.a_renamed.b_renamed.a_renamed.c_renamed<T_renamed> a_renamed(java.util.List<? extends com.airbnb.lottie.g_renamed.a_renamed<T_renamed>> list) {
        if (list.isEmpty()) {
            return new com.airbnb.lottie.a_renamed.b_renamed.a_renamed.b_renamed();
        }
        if (list.size() == 1) {
            return new com.airbnb.lottie.a_renamed.b_renamed.a_renamed.e_renamed(list);
        }
        return new com.airbnb.lottie.a_renamed.b_renamed.a_renamed.d_renamed(list);
    }

    /* compiled from: BaseKeyframeAnimation.java */
    private static final class b_renamed<T_renamed> implements com.airbnb.lottie.a_renamed.b_renamed.a_renamed.c_renamed<T_renamed> {
        @Override // com.airbnb.lottie.a_renamed.b_renamed.a_renamed.c_renamed
        public boolean a_renamed() {
            return true;
        }

        @Override // com.airbnb.lottie.a_renamed.b_renamed.a_renamed.c_renamed
        public boolean a_renamed(float f_renamed) {
            return false;
        }

        @Override // com.airbnb.lottie.a_renamed.b_renamed.a_renamed.c_renamed
        public float c_renamed() {
            return 0.0f;
        }

        @Override // com.airbnb.lottie.a_renamed.b_renamed.a_renamed.c_renamed
        public float d_renamed() {
            return 1.0f;
        }

        private b_renamed() {
        }

        @Override // com.airbnb.lottie.a_renamed.b_renamed.a_renamed.c_renamed
        public com.airbnb.lottie.g_renamed.a_renamed<T_renamed> b_renamed() {
            throw new java.lang.IllegalStateException("not implemented");
        }

        @Override // com.airbnb.lottie.a_renamed.b_renamed.a_renamed.c_renamed
        public boolean b_renamed(float f_renamed) {
            throw new java.lang.IllegalStateException("not implemented");
        }
    }

    /* compiled from: BaseKeyframeAnimation.java */
    private static final class e_renamed<T_renamed> implements com.airbnb.lottie.a_renamed.b_renamed.a_renamed.c_renamed<T_renamed> {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final com.airbnb.lottie.g_renamed.a_renamed<T_renamed> f2034a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private float f2035b = -1.0f;

        @Override // com.airbnb.lottie.a_renamed.b_renamed.a_renamed.c_renamed
        public boolean a_renamed() {
            return false;
        }

        e_renamed(java.util.List<? extends com.airbnb.lottie.g_renamed.a_renamed<T_renamed>> list) {
            this.f2034a = list.get(0);
        }

        @Override // com.airbnb.lottie.a_renamed.b_renamed.a_renamed.c_renamed
        public boolean a_renamed(float f_renamed) {
            return !this.f2034a.e_renamed();
        }

        @Override // com.airbnb.lottie.a_renamed.b_renamed.a_renamed.c_renamed
        public com.airbnb.lottie.g_renamed.a_renamed<T_renamed> b_renamed() {
            return this.f2034a;
        }

        @Override // com.airbnb.lottie.a_renamed.b_renamed.a_renamed.c_renamed
        public float c_renamed() {
            return this.f2034a.c_renamed();
        }

        @Override // com.airbnb.lottie.a_renamed.b_renamed.a_renamed.c_renamed
        public float d_renamed() {
            return this.f2034a.d_renamed();
        }

        @Override // com.airbnb.lottie.a_renamed.b_renamed.a_renamed.c_renamed
        public boolean b_renamed(float f_renamed) {
            if (this.f2035b == f_renamed) {
                return true;
            }
            this.f2035b = f_renamed;
            return false;
        }
    }

    /* compiled from: BaseKeyframeAnimation.java */
    private static final class d_renamed<T_renamed> implements com.airbnb.lottie.a_renamed.b_renamed.a_renamed.c_renamed<T_renamed> {

        /* renamed from: a_renamed, reason: collision with root package name */
        private final java.util.List<? extends com.airbnb.lottie.g_renamed.a_renamed<T_renamed>> f2031a;

        /* renamed from: c_renamed, reason: collision with root package name */
        private com.airbnb.lottie.g_renamed.a_renamed<T_renamed> f2033c = null;
        private float d_renamed = -1.0f;

        /* renamed from: b_renamed, reason: collision with root package name */
        private com.airbnb.lottie.g_renamed.a_renamed<T_renamed> f2032b = c_renamed(0.0f);

        @Override // com.airbnb.lottie.a_renamed.b_renamed.a_renamed.c_renamed
        public boolean a_renamed() {
            return false;
        }

        d_renamed(java.util.List<? extends com.airbnb.lottie.g_renamed.a_renamed<T_renamed>> list) {
            this.f2031a = list;
        }

        @Override // com.airbnb.lottie.a_renamed.b_renamed.a_renamed.c_renamed
        public boolean a_renamed(float f_renamed) {
            if (this.f2032b.a_renamed(f_renamed)) {
                return !this.f2032b.e_renamed();
            }
            this.f2032b = c_renamed(f_renamed);
            return true;
        }

        private com.airbnb.lottie.g_renamed.a_renamed<T_renamed> c_renamed(float f_renamed) {
            java.util.List<? extends com.airbnb.lottie.g_renamed.a_renamed<T_renamed>> list = this.f2031a;
            com.airbnb.lottie.g_renamed.a_renamed<T_renamed> aVar = list.get(list.size() - 1);
            if (f_renamed >= aVar.c_renamed()) {
                return aVar;
            }
            for (int size = this.f2031a.size() - 2; size >= 1; size--) {
                com.airbnb.lottie.g_renamed.a_renamed<T_renamed> aVar2 = this.f2031a.get(size);
                if (this.f2032b != aVar2 && aVar2.a_renamed(f_renamed)) {
                    return aVar2;
                }
            }
            return this.f2031a.get(0);
        }

        @Override // com.airbnb.lottie.a_renamed.b_renamed.a_renamed.c_renamed
        public com.airbnb.lottie.g_renamed.a_renamed<T_renamed> b_renamed() {
            return this.f2032b;
        }

        @Override // com.airbnb.lottie.a_renamed.b_renamed.a_renamed.c_renamed
        public float c_renamed() {
            return this.f2031a.get(0).c_renamed();
        }

        @Override // com.airbnb.lottie.a_renamed.b_renamed.a_renamed.c_renamed
        public float d_renamed() {
            return this.f2031a.get(r1.size() - 1).d_renamed();
        }

        @Override // com.airbnb.lottie.a_renamed.b_renamed.a_renamed.c_renamed
        public boolean b_renamed(float f_renamed) {
            if (this.f2033c == this.f2032b && this.d_renamed == f_renamed) {
                return true;
            }
            this.f2033c = this.f2032b;
            this.d_renamed = f_renamed;
            return false;
        }
    }
}
