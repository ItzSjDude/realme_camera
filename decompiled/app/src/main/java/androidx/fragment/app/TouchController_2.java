package androidx.fragment.app;

/* compiled from: FragmentTransitionCompat21.java */
/* loaded from: classes.dex */
class m_renamed extends androidx.fragment.app.n_renamed {
    m_renamed() {
    }

    @Override // androidx.fragment.app.n_renamed
    public boolean a_renamed(java.lang.Object obj) {
        return obj instanceof android.transition.Transition;
    }

    @Override // androidx.fragment.app.n_renamed
    public java.lang.Object b_renamed(java.lang.Object obj) {
        if (obj != null) {
            return ((android.transition.Transition) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.n_renamed
    public java.lang.Object c_renamed(java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        android.transition.TransitionSet transitionSet = new android.transition.TransitionSet();
        transitionSet.addTransition((android.transition.Transition) obj);
        return transitionSet;
    }

    @Override // androidx.fragment.app.n_renamed
    public void a_renamed(java.lang.Object obj, android.view.View view, java.util.ArrayList<android.view.View> arrayList) {
        android.transition.TransitionSet transitionSet = (android.transition.TransitionSet) obj;
        java.util.List<android.view.View> targets = transitionSet.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            a_renamed(targets, arrayList.get(i_renamed));
        }
        targets.add(view);
        arrayList.add(view);
        a_renamed(transitionSet, arrayList);
    }

    @Override // androidx.fragment.app.n_renamed
    public void a_renamed(java.lang.Object obj, android.view.View view) {
        if (view != null) {
            final android.graphics.Rect rect = new android.graphics.Rect();
            a_renamed(view, rect);
            ((android.transition.Transition) obj).setEpicenterCallback(new android.transition.Transition.EpicenterCallback() { // from class: androidx.fragment.app.m_renamed.1
                @Override // android.transition.Transition.EpicenterCallback
                public android.graphics.Rect onGetEpicenter(android.transition.Transition transition) {
                    return rect;
                }
            });
        }
    }

    @Override // androidx.fragment.app.n_renamed
    public void a_renamed(java.lang.Object obj, java.util.ArrayList<android.view.View> arrayList) {
        android.transition.Transition transition = (android.transition.Transition) obj;
        if (transition == null) {
            return;
        }
        int i_renamed = 0;
        if (transition instanceof android.transition.TransitionSet) {
            android.transition.TransitionSet transitionSet = (android.transition.TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i_renamed < transitionCount) {
                a_renamed(transitionSet.getTransitionAt(i_renamed), arrayList);
                i_renamed++;
            }
            return;
        }
        if (a_renamed(transition) || !a_renamed((java.util.List) transition.getTargets())) {
            return;
        }
        int size = arrayList.size();
        while (i_renamed < size) {
            transition.addTarget(arrayList.get(i_renamed));
            i_renamed++;
        }
    }

    private static boolean a_renamed(android.transition.Transition transition) {
        return (a_renamed((java.util.List) transition.getTargetIds()) && a_renamed((java.util.List) transition.getTargetNames()) && a_renamed((java.util.List) transition.getTargetTypes())) ? false : true;
    }

    @Override // androidx.fragment.app.n_renamed
    public java.lang.Object a_renamed(java.lang.Object obj, java.lang.Object obj2, java.lang.Object obj3) {
        android.transition.TransitionSet transitionSet = new android.transition.TransitionSet();
        if (obj != null) {
            transitionSet.addTransition((android.transition.Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.addTransition((android.transition.Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.addTransition((android.transition.Transition) obj3);
        }
        return transitionSet;
    }

    @Override // androidx.fragment.app.n_renamed
    public void b_renamed(java.lang.Object obj, final android.view.View view, final java.util.ArrayList<android.view.View> arrayList) {
        ((android.transition.Transition) obj).addListener(new android.transition.Transition.TransitionListener() { // from class: androidx.fragment.app.m_renamed.2
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(android.transition.Transition transition) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(android.transition.Transition transition) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(android.transition.Transition transition) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(android.transition.Transition transition) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(android.transition.Transition transition) {
                transition.removeListener(this);
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
        android.transition.Transition ordering = (android.transition.Transition) obj;
        android.transition.Transition transition = (android.transition.Transition) obj2;
        android.transition.Transition transition2 = (android.transition.Transition) obj3;
        if (ordering != null && transition != null) {
            ordering = new android.transition.TransitionSet().addTransition(ordering).addTransition(transition).setOrdering(1);
        } else if (ordering == null) {
            ordering = transition != null ? transition : null;
        }
        if (transition2 == null) {
            return ordering;
        }
        android.transition.TransitionSet transitionSet = new android.transition.TransitionSet();
        if (ordering != null) {
            transitionSet.addTransition(ordering);
        }
        transitionSet.addTransition(transition2);
        return transitionSet;
    }

    @Override // androidx.fragment.app.n_renamed
    public void a_renamed(android.view.ViewGroup viewGroup, java.lang.Object obj) {
        android.transition.TransitionManager.beginDelayedTransition(viewGroup, (android.transition.Transition) obj);
    }

    @Override // androidx.fragment.app.n_renamed
    public void a_renamed(java.lang.Object obj, final java.lang.Object obj2, final java.util.ArrayList<android.view.View> arrayList, final java.lang.Object obj3, final java.util.ArrayList<android.view.View> arrayList2, final java.lang.Object obj4, final java.util.ArrayList<android.view.View> arrayList3) {
        ((android.transition.Transition) obj).addListener(new android.transition.Transition.TransitionListener() { // from class: androidx.fragment.app.m_renamed.3
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(android.transition.Transition transition) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(android.transition.Transition transition) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(android.transition.Transition transition) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(android.transition.Transition transition) {
                java.lang.Object obj5 = obj2;
                if (obj5 != null) {
                    androidx.fragment.app.m_renamed.this.b_renamed(obj5, arrayList, (java.util.ArrayList<android.view.View>) null);
                }
                java.lang.Object obj6 = obj3;
                if (obj6 != null) {
                    androidx.fragment.app.m_renamed.this.b_renamed(obj6, arrayList2, (java.util.ArrayList<android.view.View>) null);
                }
                java.lang.Object obj7 = obj4;
                if (obj7 != null) {
                    androidx.fragment.app.m_renamed.this.b_renamed(obj7, arrayList3, (java.util.ArrayList<android.view.View>) null);
                }
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(android.transition.Transition transition) {
                transition.removeListener(this);
            }
        });
    }

    @Override // androidx.fragment.app.n_renamed
    public void a_renamed(java.lang.Object obj, java.util.ArrayList<android.view.View> arrayList, java.util.ArrayList<android.view.View> arrayList2) {
        android.transition.TransitionSet transitionSet = (android.transition.TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.getTargets().clear();
            transitionSet.getTargets().addAll(arrayList2);
            b_renamed((java.lang.Object) transitionSet, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.n_renamed
    public void b_renamed(java.lang.Object obj, java.util.ArrayList<android.view.View> arrayList, java.util.ArrayList<android.view.View> arrayList2) {
        java.util.List<android.view.View> targets;
        android.transition.Transition transition = (android.transition.Transition) obj;
        int i_renamed = 0;
        if (transition instanceof android.transition.TransitionSet) {
            android.transition.TransitionSet transitionSet = (android.transition.TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i_renamed < transitionCount) {
                b_renamed((java.lang.Object) transitionSet.getTransitionAt(i_renamed), arrayList, arrayList2);
                i_renamed++;
            }
            return;
        }
        if (a_renamed(transition) || (targets = transition.getTargets()) == null || targets.size() != arrayList.size() || !targets.containsAll(arrayList)) {
            return;
        }
        int size = arrayList2 == null ? 0 : arrayList2.size();
        while (i_renamed < size) {
            transition.addTarget(arrayList2.get(i_renamed));
            i_renamed++;
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            transition.removeTarget(arrayList.get(size2));
        }
    }

    @Override // androidx.fragment.app.n_renamed
    public void b_renamed(java.lang.Object obj, android.view.View view) {
        if (obj != null) {
            ((android.transition.Transition) obj).addTarget(view);
        }
    }

    @Override // androidx.fragment.app.n_renamed
    public void c_renamed(java.lang.Object obj, android.view.View view) {
        if (obj != null) {
            ((android.transition.Transition) obj).removeTarget(view);
        }
    }

    @Override // androidx.fragment.app.n_renamed
    public void a_renamed(java.lang.Object obj, final android.graphics.Rect rect) {
        if (obj != null) {
            ((android.transition.Transition) obj).setEpicenterCallback(new android.transition.Transition.EpicenterCallback() { // from class: androidx.fragment.app.m_renamed.4
                @Override // android.transition.Transition.EpicenterCallback
                public android.graphics.Rect onGetEpicenter(android.transition.Transition transition) {
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
