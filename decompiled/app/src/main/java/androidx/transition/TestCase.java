package androidx.transition;

/* compiled from: FragmentTransitionSupport.java */
@android.annotation.SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public class e_renamed extends androidx.fragment.app.n_renamed {
    @Override // androidx.fragment.app.n_renamed
    public boolean a_renamed(java.lang.Object obj) {
        return obj instanceof androidx.transition.m_renamed;
    }

    @Override // androidx.fragment.app.n_renamed
    public java.lang.Object b_renamed(java.lang.Object obj) {
        if (obj != null) {
            return ((androidx.transition.m_renamed) obj).mo2clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.n_renamed
    public java.lang.Object c_renamed(java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        androidx.transition.q_renamed qVar = new androidx.transition.q_renamed();
        qVar.a_renamed((androidx.transition.m_renamed) obj);
        return qVar;
    }

    @Override // androidx.fragment.app.n_renamed
    public void a_renamed(java.lang.Object obj, android.view.View view, java.util.ArrayList<android.view.View> arrayList) {
        androidx.transition.q_renamed qVar = (androidx.transition.q_renamed) obj;
        java.util.List<android.view.View> targets = qVar.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            a_renamed(targets, arrayList.get(i_renamed));
        }
        targets.add(view);
        arrayList.add(view);
        a_renamed(qVar, arrayList);
    }

    @Override // androidx.fragment.app.n_renamed
    public void a_renamed(java.lang.Object obj, android.view.View view) {
        if (view != null) {
            final android.graphics.Rect rect = new android.graphics.Rect();
            a_renamed(view, rect);
            ((androidx.transition.m_renamed) obj).setEpicenterCallback(new androidx.transition.m_renamed.c_renamed() { // from class: androidx.transition.e_renamed.1
                @Override // androidx.transition.m_renamed.c_renamed
                public android.graphics.Rect a_renamed(androidx.transition.m_renamed mVar) {
                    return rect;
                }
            });
        }
    }

    @Override // androidx.fragment.app.n_renamed
    public void a_renamed(java.lang.Object obj, java.util.ArrayList<android.view.View> arrayList) {
        androidx.transition.m_renamed mVar = (androidx.transition.m_renamed) obj;
        if (mVar == null) {
            return;
        }
        int i_renamed = 0;
        if (mVar instanceof androidx.transition.q_renamed) {
            androidx.transition.q_renamed qVar = (androidx.transition.q_renamed) mVar;
            int iA = qVar.a_renamed();
            while (i_renamed < iA) {
                a_renamed(qVar.b_renamed(i_renamed), arrayList);
                i_renamed++;
            }
            return;
        }
        if (a_renamed(mVar) || !a_renamed((java.util.List) mVar.getTargets())) {
            return;
        }
        int size = arrayList.size();
        while (i_renamed < size) {
            mVar.addTarget(arrayList.get(i_renamed));
            i_renamed++;
        }
    }

    private static boolean a_renamed(androidx.transition.m_renamed mVar) {
        return (a_renamed((java.util.List) mVar.getTargetIds()) && a_renamed((java.util.List) mVar.getTargetNames()) && a_renamed((java.util.List) mVar.getTargetTypes())) ? false : true;
    }

    @Override // androidx.fragment.app.n_renamed
    public java.lang.Object a_renamed(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
        androidx.transition.q_renamed qVar = new androidx.transition.q_renamed();
        if (obj != null) {
            qVar.a_renamed((androidx.transition.m_renamed) obj);
        }
        if (obj2 != null) {
            qVar.a_renamed((androidx.transition.m_renamed) obj2);
        }
        if (obj3 != null) {
            qVar.a_renamed((androidx.transition.m_renamed) obj3);
        }
        return qVar;
    }

    @Override // androidx.fragment.app.n_renamed
    public void b_renamed(java.lang.Object obj, final android.view.View view, final java.util.ArrayList<android.view.View> arrayList) {
        ((androidx.transition.m_renamed) obj).addListener(new androidx.transition.m_renamed.d_renamed() { // from class: androidx.transition.e_renamed.2
            @Override // androidx.transition.m_renamed.d_renamed
            public void a_renamed(androidx.transition.m_renamed mVar) {
            }

            @Override // androidx.transition.m_renamed.d_renamed
            public void c_renamed(androidx.transition.m_renamed mVar) {
            }

            @Override // androidx.transition.m_renamed.d_renamed
            public void d_renamed(androidx.transition.m_renamed mVar) {
            }

            @Override // androidx.transition.m_renamed.d_renamed
            public void e_renamed(androidx.transition.m_renamed mVar) {
            }

            @Override // androidx.transition.m_renamed.d_renamed
            public void b_renamed(androidx.transition.m_renamed mVar) {
                mVar.removeListener(this);
                view.setVisibility(8);
                int size = arrayList.size();
                for (int i_renamed = 0; i_renamed < size; i_renamed++) {
                    ((android.view.View) arrayList.get(i_renamed)).setVisibility(0);
                }
            }
        });
    }

    @Override // androidx.fragment.app.n_renamed
    public java.lang.Object b_renamed(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
        androidx.transition.m_renamed mVarA = (androidx.transition.m_renamed) obj;
        androidx.transition.m_renamed mVar = (androidx.transition.m_renamed) obj2;
        androidx.transition.m_renamed mVar2 = (androidx.transition.m_renamed) obj3;
        if (mVarA != null && mVar != null) {
            mVarA = new androidx.transition.q_renamed().a_renamed(mVarA).a_renamed(mVar).a_renamed(1);
        } else if (mVarA == null) {
            mVarA = mVar != null ? mVar : null;
        }
        if (mVar2 == null) {
            return mVarA;
        }
        androidx.transition.q_renamed qVar = new androidx.transition.q_renamed();
        if (mVarA != null) {
            qVar.a_renamed(mVarA);
        }
        qVar.a_renamed(mVar2);
        return qVar;
    }

    @Override // androidx.fragment.app.n_renamed
    public void a_renamed(android.view.ViewGroup viewGroup, java.lang.Object obj) {
        androidx.transition.o_renamed.a_renamed(viewGroup, (androidx.transition.m_renamed) obj);
    }

    @Override // androidx.fragment.app.n_renamed
    public void a_renamed(java.lang.Object obj, final java.lang.Object obj2, final java.util.ArrayList<android.view.View> arrayList, final java.lang.Object obj3, final java.util.ArrayList<android.view.View> arrayList2, final java.lang.Object obj4, final java.util.ArrayList<android.view.View> arrayList3) {
        ((androidx.transition.m_renamed) obj).addListener(new androidx.transition.n_renamed() { // from class: androidx.transition.e_renamed.3
            @Override // androidx.transition.n_renamed, androidx.transition.m_renamed.d_renamed
            public void e_renamed(androidx.transition.m_renamed mVar) {
                java.lang.Object obj5 = obj2;
                if (obj5 != null) {
                    androidx.transition.e_renamed.this.b_renamed(obj5, arrayList, (java.util.ArrayList<android.view.View>) null);
                }
                java.lang.Object obj6 = obj3;
                if (obj6 != null) {
                    androidx.transition.e_renamed.this.b_renamed(obj6, arrayList2, (java.util.ArrayList<android.view.View>) null);
                }
                java.lang.Object obj7 = obj4;
                if (obj7 != null) {
                    androidx.transition.e_renamed.this.b_renamed(obj7, arrayList3, (java.util.ArrayList<android.view.View>) null);
                }
            }

            @Override // androidx.transition.n_renamed, androidx.transition.m_renamed.d_renamed
            public void b_renamed(androidx.transition.m_renamed mVar) {
                mVar.removeListener(this);
            }
        });
    }

    @Override // androidx.fragment.app.n_renamed
    public void a_renamed(java.lang.Object obj, java.util.ArrayList<android.view.View> arrayList, java.util.ArrayList<android.view.View> arrayList2) {
        androidx.transition.q_renamed qVar = (androidx.transition.q_renamed) obj;
        if (qVar != null) {
            qVar.getTargets().clear();
            qVar.getTargets().addAll(arrayList2);
            b_renamed((java.lang.Object) qVar, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.n_renamed
    public void b_renamed(java.lang.Object obj, java.util.ArrayList<android.view.View> arrayList, java.util.ArrayList<android.view.View> arrayList2) {
        androidx.transition.m_renamed mVar = (androidx.transition.m_renamed) obj;
        int i_renamed = 0;
        if (mVar instanceof androidx.transition.q_renamed) {
            androidx.transition.q_renamed qVar = (androidx.transition.q_renamed) mVar;
            int iA = qVar.a_renamed();
            while (i_renamed < iA) {
                b_renamed((java.lang.Object) qVar.b_renamed(i_renamed), arrayList, arrayList2);
                i_renamed++;
            }
            return;
        }
        if (a_renamed(mVar)) {
            return;
        }
        java.util.List<android.view.View> targets = mVar.getTargets();
        if (targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (i_renamed < size) {
                mVar.addTarget(arrayList2.get(i_renamed));
                i_renamed++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                mVar.removeTarget(arrayList.get(size2));
            }
        }
    }

    @Override // androidx.fragment.app.n_renamed
    public void b_renamed(java.lang.Object obj, android.view.View view) {
        if (obj != null) {
            ((androidx.transition.m_renamed) obj).addTarget(view);
        }
    }

    @Override // androidx.fragment.app.n_renamed
    public void c_renamed(java.lang.Object obj, android.view.View view) {
        if (obj != null) {
            ((androidx.transition.m_renamed) obj).removeTarget(view);
        }
    }

    @Override // androidx.fragment.app.n_renamed
    public void a_renamed(java.lang.Object obj, final android.graphics.Rect rect) {
        if (obj != null) {
            ((androidx.transition.m_renamed) obj).setEpicenterCallback(new androidx.transition.m_renamed.c_renamed() { // from class: androidx.transition.e_renamed.4
                @Override // androidx.transition.m_renamed.c_renamed
                public android.graphics.Rect a_renamed(androidx.transition.m_renamed mVar) {
                    android.graphics.Rect rect2 = rect;
                    if (rect2 == null || rect2.isEmpty()) {
                        return null;
                    }
                    return rect;
                }
            });
        }
    }
}
