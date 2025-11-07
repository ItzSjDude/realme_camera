package androidx.transition;

/* compiled from: TransitionSet.java */
/* loaded from: classes.dex */
public class q_renamed extends androidx.transition.m_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    int f1745a;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.util.ArrayList<androidx.transition.m_renamed> f1747c = new java.util.ArrayList<>();
    private boolean d_renamed = true;

    /* renamed from: b_renamed, reason: collision with root package name */
    boolean f1746b = false;
    private int e_renamed = 0;

    @Override // androidx.transition.m_renamed
    public /* synthetic */ androidx.transition.m_renamed addTarget(java.lang.Class cls) {
        return a_renamed((java.lang.Class<?>) cls);
    }

    @Override // androidx.transition.m_renamed
    public /* synthetic */ androidx.transition.m_renamed removeTarget(java.lang.Class cls) {
        return b_renamed((java.lang.Class<?>) cls);
    }

    public androidx.transition.q_renamed a_renamed(int i_renamed) {
        if (i_renamed == 0) {
            this.d_renamed = true;
        } else if (i_renamed == 1) {
            this.d_renamed = false;
        } else {
            throw new android.util.AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i_renamed);
        }
        return this;
    }

    public androidx.transition.q_renamed a_renamed(androidx.transition.m_renamed mVar) {
        b_renamed(mVar);
        if (this.mDuration >= 0) {
            mVar.setDuration(this.mDuration);
        }
        if ((this.e_renamed & 1) != 0) {
            mVar.setInterpolator(getInterpolator());
        }
        if ((this.e_renamed & 2) != 0) {
            mVar.setPropagation(getPropagation());
        }
        if ((this.e_renamed & 4) != 0) {
            mVar.setPathMotion(getPathMotion());
        }
        if ((this.e_renamed & 8) != 0) {
            mVar.setEpicenterCallback(getEpicenterCallback());
        }
        return this;
    }

    private void b_renamed(androidx.transition.m_renamed mVar) {
        this.f1747c.add(mVar);
        mVar.mParent = this;
    }

    public int a_renamed() {
        return this.f1747c.size();
    }

    public androidx.transition.m_renamed b_renamed(int i_renamed) {
        if (i_renamed < 0 || i_renamed >= this.f1747c.size()) {
            return null;
        }
        return this.f1747c.get(i_renamed);
    }

    @Override // androidx.transition.m_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public androidx.transition.q_renamed setDuration(long j_renamed) {
        java.util.ArrayList<androidx.transition.m_renamed> arrayList;
        super.setDuration(j_renamed);
        if (this.mDuration >= 0 && (arrayList = this.f1747c) != null) {
            int size = arrayList.size();
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                this.f1747c.get(i_renamed).setDuration(j_renamed);
            }
        }
        return this;
    }

    @Override // androidx.transition.m_renamed
    /* renamed from: b_renamed, reason: merged with bridge method [inline-methods] */
    public androidx.transition.q_renamed setStartDelay(long j_renamed) {
        return (androidx.transition.q_renamed) super.setStartDelay(j_renamed);
    }

    @Override // androidx.transition.m_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public androidx.transition.q_renamed setInterpolator(android.animation.TimeInterpolator timeInterpolator) {
        this.e_renamed |= 1;
        java.util.ArrayList<androidx.transition.m_renamed> arrayList = this.f1747c;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                this.f1747c.get(i_renamed).setInterpolator(timeInterpolator);
            }
        }
        return (androidx.transition.q_renamed) super.setInterpolator(timeInterpolator);
    }

    @Override // androidx.transition.m_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public androidx.transition.q_renamed addTarget(android.view.View view) {
        for (int i_renamed = 0; i_renamed < this.f1747c.size(); i_renamed++) {
            this.f1747c.get(i_renamed).addTarget(view);
        }
        return (androidx.transition.q_renamed) super.addTarget(view);
    }

    @Override // androidx.transition.m_renamed
    /* renamed from: c_renamed, reason: merged with bridge method [inline-methods] */
    public androidx.transition.q_renamed addTarget(int i_renamed) {
        for (int i2 = 0; i2 < this.f1747c.size(); i2++) {
            this.f1747c.get(i2).addTarget(i_renamed);
        }
        return (androidx.transition.q_renamed) super.addTarget(i_renamed);
    }

    @Override // androidx.transition.m_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public androidx.transition.q_renamed addTarget(java.lang.String str) {
        for (int i_renamed = 0; i_renamed < this.f1747c.size(); i_renamed++) {
            this.f1747c.get(i_renamed).addTarget(str);
        }
        return (androidx.transition.q_renamed) super.addTarget(str);
    }

    public androidx.transition.q_renamed a_renamed(java.lang.Class<?> cls) {
        for (int i_renamed = 0; i_renamed < this.f1747c.size(); i_renamed++) {
            this.f1747c.get(i_renamed).addTarget(cls);
        }
        return (androidx.transition.q_renamed) super.addTarget(cls);
    }

    @Override // androidx.transition.m_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public androidx.transition.q_renamed addListener(androidx.transition.m_renamed.d_renamed dVar) {
        return (androidx.transition.q_renamed) super.addListener(dVar);
    }

    @Override // androidx.transition.m_renamed
    /* renamed from: d_renamed, reason: merged with bridge method [inline-methods] */
    public androidx.transition.q_renamed removeTarget(int i_renamed) {
        for (int i2 = 0; i2 < this.f1747c.size(); i2++) {
            this.f1747c.get(i2).removeTarget(i_renamed);
        }
        return (androidx.transition.q_renamed) super.removeTarget(i_renamed);
    }

    @Override // androidx.transition.m_renamed
    /* renamed from: b_renamed, reason: merged with bridge method [inline-methods] */
    public androidx.transition.q_renamed removeTarget(android.view.View view) {
        for (int i_renamed = 0; i_renamed < this.f1747c.size(); i_renamed++) {
            this.f1747c.get(i_renamed).removeTarget(view);
        }
        return (androidx.transition.q_renamed) super.removeTarget(view);
    }

    public androidx.transition.q_renamed b_renamed(java.lang.Class<?> cls) {
        for (int i_renamed = 0; i_renamed < this.f1747c.size(); i_renamed++) {
            this.f1747c.get(i_renamed).removeTarget(cls);
        }
        return (androidx.transition.q_renamed) super.removeTarget(cls);
    }

    @Override // androidx.transition.m_renamed
    /* renamed from: b_renamed, reason: merged with bridge method [inline-methods] */
    public androidx.transition.q_renamed removeTarget(java.lang.String str) {
        for (int i_renamed = 0; i_renamed < this.f1747c.size(); i_renamed++) {
            this.f1747c.get(i_renamed).removeTarget(str);
        }
        return (androidx.transition.q_renamed) super.removeTarget(str);
    }

    @Override // androidx.transition.m_renamed
    public androidx.transition.m_renamed excludeTarget(android.view.View view, boolean z_renamed) {
        for (int i_renamed = 0; i_renamed < this.f1747c.size(); i_renamed++) {
            this.f1747c.get(i_renamed).excludeTarget(view, z_renamed);
        }
        return super.excludeTarget(view, z_renamed);
    }

    @Override // androidx.transition.m_renamed
    public androidx.transition.m_renamed excludeTarget(java.lang.String str, boolean z_renamed) {
        for (int i_renamed = 0; i_renamed < this.f1747c.size(); i_renamed++) {
            this.f1747c.get(i_renamed).excludeTarget(str, z_renamed);
        }
        return super.excludeTarget(str, z_renamed);
    }

    @Override // androidx.transition.m_renamed
    public androidx.transition.m_renamed excludeTarget(int i_renamed, boolean z_renamed) {
        for (int i2 = 0; i2 < this.f1747c.size(); i2++) {
            this.f1747c.get(i2).excludeTarget(i_renamed, z_renamed);
        }
        return super.excludeTarget(i_renamed, z_renamed);
    }

    @Override // androidx.transition.m_renamed
    public androidx.transition.m_renamed excludeTarget(java.lang.Class<?> cls, boolean z_renamed) {
        for (int i_renamed = 0; i_renamed < this.f1747c.size(); i_renamed++) {
            this.f1747c.get(i_renamed).excludeTarget(cls, z_renamed);
        }
        return super.excludeTarget(cls, z_renamed);
    }

    @Override // androidx.transition.m_renamed
    /* renamed from: b_renamed, reason: merged with bridge method [inline-methods] */
    public androidx.transition.q_renamed removeListener(androidx.transition.m_renamed.d_renamed dVar) {
        return (androidx.transition.q_renamed) super.removeListener(dVar);
    }

    @Override // androidx.transition.m_renamed
    public void setPathMotion(androidx.transition.g_renamed gVar) {
        super.setPathMotion(gVar);
        this.e_renamed |= 4;
        if (this.f1747c != null) {
            for (int i_renamed = 0; i_renamed < this.f1747c.size(); i_renamed++) {
                this.f1747c.get(i_renamed).setPathMotion(gVar);
            }
        }
    }

    private void b_renamed() {
        androidx.transition.q_renamed.a_renamed aVar = new androidx.transition.q_renamed.a_renamed(this);
        java.util.Iterator<androidx.transition.m_renamed> it = this.f1747c.iterator();
        while (it.hasNext()) {
            it.next().addListener(aVar);
        }
        this.f1745a = this.f1747c.size();
    }

    /* compiled from: TransitionSet.java */
    static class a_renamed extends androidx.transition.n_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        androidx.transition.q_renamed f1750a;

        a_renamed(androidx.transition.q_renamed qVar) {
            this.f1750a = qVar;
        }

        @Override // androidx.transition.n_renamed, androidx.transition.m_renamed.d_renamed
        public void e_renamed(androidx.transition.m_renamed mVar) {
            if (this.f1750a.f1746b) {
                return;
            }
            this.f1750a.start();
            this.f1750a.f1746b = true;
        }

        @Override // androidx.transition.n_renamed, androidx.transition.m_renamed.d_renamed
        public void b_renamed(androidx.transition.m_renamed mVar) {
            androidx.transition.q_renamed qVar = this.f1750a;
            qVar.f1745a--;
            if (this.f1750a.f1745a == 0) {
                androidx.transition.q_renamed qVar2 = this.f1750a;
                qVar2.f1746b = false;
                qVar2.end();
            }
            mVar.removeListener(this);
        }
    }

    @Override // androidx.transition.m_renamed
    protected void createAnimators(android.view.ViewGroup viewGroup, androidx.transition.u_renamed uVar, androidx.transition.u_renamed uVar2, java.util.ArrayList<androidx.transition.t_renamed> arrayList, java.util.ArrayList<androidx.transition.t_renamed> arrayList2) {
        long startDelay = getStartDelay();
        int size = this.f1747c.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            androidx.transition.m_renamed mVar = this.f1747c.get(i_renamed);
            if (startDelay > 0 && (this.d_renamed || i_renamed == 0)) {
                long startDelay2 = mVar.getStartDelay();
                if (startDelay2 > 0) {
                    mVar.setStartDelay(startDelay2 + startDelay);
                } else {
                    mVar.setStartDelay(startDelay);
                }
            }
            mVar.createAnimators(viewGroup, uVar, uVar2, arrayList, arrayList2);
        }
    }

    @Override // androidx.transition.m_renamed
    protected void runAnimators() {
        if (this.f1747c.isEmpty()) {
            start();
            end();
            return;
        }
        b_renamed();
        if (!this.d_renamed) {
            for (int i_renamed = 1; i_renamed < this.f1747c.size(); i_renamed++) {
                androidx.transition.m_renamed mVar = this.f1747c.get(i_renamed - 1);
                final androidx.transition.m_renamed mVar2 = this.f1747c.get(i_renamed);
                mVar.addListener(new androidx.transition.n_renamed() { // from class: androidx.transition.q_renamed.1
                    @Override // androidx.transition.n_renamed, androidx.transition.m_renamed.d_renamed
                    public void b_renamed(androidx.transition.m_renamed mVar3) {
                        mVar2.runAnimators();
                        mVar3.removeListener(this);
                    }
                });
            }
            androidx.transition.m_renamed mVar3 = this.f1747c.get(0);
            if (mVar3 != null) {
                mVar3.runAnimators();
                return;
            }
            return;
        }
        java.util.Iterator<androidx.transition.m_renamed> it = this.f1747c.iterator();
        while (it.hasNext()) {
            it.next().runAnimators();
        }
    }

    @Override // androidx.transition.m_renamed
    public void captureStartValues(androidx.transition.t_renamed tVar) {
        if (isValidTarget(tVar.f1755b)) {
            java.util.Iterator<androidx.transition.m_renamed> it = this.f1747c.iterator();
            while (it.hasNext()) {
                androidx.transition.m_renamed next = it.next();
                if (next.isValidTarget(tVar.f1755b)) {
                    next.captureStartValues(tVar);
                    tVar.f1756c.add(next);
                }
            }
        }
    }

    @Override // androidx.transition.m_renamed
    public void captureEndValues(androidx.transition.t_renamed tVar) {
        if (isValidTarget(tVar.f1755b)) {
            java.util.Iterator<androidx.transition.m_renamed> it = this.f1747c.iterator();
            while (it.hasNext()) {
                androidx.transition.m_renamed next = it.next();
                if (next.isValidTarget(tVar.f1755b)) {
                    next.captureEndValues(tVar);
                    tVar.f1756c.add(next);
                }
            }
        }
    }

    @Override // androidx.transition.m_renamed
    void capturePropagationValues(androidx.transition.t_renamed tVar) {
        super.capturePropagationValues(tVar);
        int size = this.f1747c.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            this.f1747c.get(i_renamed).capturePropagationValues(tVar);
        }
    }

    @Override // androidx.transition.m_renamed
    public void pause(android.view.View view) {
        super.pause(view);
        int size = this.f1747c.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            this.f1747c.get(i_renamed).pause(view);
        }
    }

    @Override // androidx.transition.m_renamed
    public void resume(android.view.View view) {
        super.resume(view);
        int size = this.f1747c.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            this.f1747c.get(i_renamed).resume(view);
        }
    }

    @Override // androidx.transition.m_renamed
    protected void cancel() {
        super.cancel();
        int size = this.f1747c.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            this.f1747c.get(i_renamed).cancel();
        }
    }

    @Override // androidx.transition.m_renamed
    void forceToEnd(android.view.ViewGroup viewGroup) {
        super.forceToEnd(viewGroup);
        int size = this.f1747c.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            this.f1747c.get(i_renamed).forceToEnd(viewGroup);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.transition.m_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public androidx.transition.q_renamed setSceneRoot(android.view.ViewGroup viewGroup) {
        super.setSceneRoot(viewGroup);
        int size = this.f1747c.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            this.f1747c.get(i_renamed).setSceneRoot(viewGroup);
        }
        return this;
    }

    @Override // androidx.transition.m_renamed
    void setCanRemoveViews(boolean z_renamed) {
        super.setCanRemoveViews(z_renamed);
        int size = this.f1747c.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            this.f1747c.get(i_renamed).setCanRemoveViews(z_renamed);
        }
    }

    @Override // androidx.transition.m_renamed
    public void setPropagation(androidx.transition.p_renamed pVar) {
        super.setPropagation(pVar);
        this.e_renamed |= 2;
        int size = this.f1747c.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            this.f1747c.get(i_renamed).setPropagation(pVar);
        }
    }

    @Override // androidx.transition.m_renamed
    public void setEpicenterCallback(androidx.transition.m_renamed.c_renamed cVar) {
        super.setEpicenterCallback(cVar);
        this.e_renamed |= 8;
        int size = this.f1747c.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            this.f1747c.get(i_renamed).setEpicenterCallback(cVar);
        }
    }

    @Override // androidx.transition.m_renamed
    java.lang.String toString(java.lang.String str) {
        java.lang.String string = super.toString(str);
        for (int i_renamed = 0; i_renamed < this.f1747c.size(); i_renamed++) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(string);
            sb.append("\n_renamed");
            sb.append(this.f1747c.get(i_renamed).toString(str + "  "));
            string = sb.toString();
        }
        return string;
    }

    @Override // androidx.transition.m_renamed
    /* renamed from: clone */
    public androidx.transition.m_renamed mo2clone() {
        androidx.transition.q_renamed qVar = (androidx.transition.q_renamed) super.mo2clone();
        qVar.f1747c = new java.util.ArrayList<>();
        int size = this.f1747c.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            qVar.b_renamed(this.f1747c.get(i_renamed).mo2clone());
        }
        return qVar;
    }
}
