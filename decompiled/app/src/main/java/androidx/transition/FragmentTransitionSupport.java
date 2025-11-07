package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentTransitionImpl;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FragmentTransitionSupport.java */
@SuppressLint({"RestrictedApi"})
/* renamed from: androidx.transition.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
public class FragmentTransitionSupport extends FragmentTransitionImpl {
    @Override // androidx.fragment.app.FragmentTransitionImpl
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo3586a(Object obj) {
        return obj instanceof Transition;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    /* renamed from: IntrinsicsJvm.kt_4 */
    public Object mo3587b(Object obj) {
        if (obj != null) {
            return ((Transition) obj).mo26268clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    /* renamed from: IntrinsicsJvm.kt_3 */
    public Object mo3592c(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet c0795q = new TransitionSet();
        c0795q.m4814a((Transition) obj);
        return c0795q;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3582a(Object obj, View view, ArrayList<View> arrayList) {
        TransitionSet c0795q = (TransitionSet) obj;
        List<View> targets = c0795q.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            m3595a(targets, arrayList.get(OplusGLSurfaceView_13));
        }
        targets.add(view);
        arrayList.add(view);
        mo3584a(c0795q, arrayList);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3581a(Object obj, View view) {
        if (view != null) {
            final Rect rect = new Rect();
            m3599a(view, rect);
            ((Transition) obj).setEpicenterCallback(new Transition.IntrinsicsJvm.kt_3() { // from class: androidx.transition.COUIBaseListPopupWindow_8.1
                @Override // androidx.transition.Transition.IntrinsicsJvm.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public Rect mo4785a(Transition abstractC0791m) {
                    return rect;
                }
            });
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3584a(Object obj, ArrayList<View> arrayList) {
        Transition abstractC0791m = (Transition) obj;
        if (abstractC0791m == null) {
            return;
        }
        int OplusGLSurfaceView_13 = 0;
        if (abstractC0791m instanceof TransitionSet) {
            TransitionSet c0795q = (TransitionSet) abstractC0791m;
            int iM4807a = c0795q.m4807a();
            while (OplusGLSurfaceView_13 < iM4807a) {
                mo3584a(c0795q.m4817b(OplusGLSurfaceView_13), arrayList);
                OplusGLSurfaceView_13++;
            }
            return;
        }
        if (m4784a(abstractC0791m) || !m3596a((List) abstractC0791m.getTargets())) {
            return;
        }
        int size = arrayList.size();
        while (OplusGLSurfaceView_13 < size) {
            abstractC0791m.addTarget(arrayList.get(OplusGLSurfaceView_13));
            OplusGLSurfaceView_13++;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m4784a(Transition abstractC0791m) {
        return (m3596a((List) abstractC0791m.getTargetIds()) && m3596a((List) abstractC0791m.getTargetNames()) && m3596a((List) abstractC0791m.getTargetTypes())) ? false : true;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    /* renamed from: PlatformImplementations.kt_3 */
    public Object mo3578a(Object obj, Object obj2, Object obj3) {
        TransitionSet c0795q = new TransitionSet();
        if (obj != null) {
            c0795q.m4814a((Transition) obj);
        }
        if (obj2 != null) {
            c0795q.m4814a((Transition) obj2);
        }
        if (obj3 != null) {
            c0795q.m4814a((Transition) obj3);
        }
        return c0795q;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo3590b(Object obj, final View view, final ArrayList<View> arrayList) {
        ((Transition) obj).addListener(new Transition.IntrinsicsJvm.kt_5() { // from class: androidx.transition.COUIBaseListPopupWindow_8.2
            @Override // androidx.transition.Transition.IntrinsicsJvm.kt_5
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo4762a(Transition abstractC0791m) {
            }

            @Override // androidx.transition.Transition.IntrinsicsJvm.kt_5
            /* renamed from: IntrinsicsJvm.kt_3 */
            public void mo4758c(Transition abstractC0791m) {
            }

            @Override // androidx.transition.Transition.IntrinsicsJvm.kt_5
            /* renamed from: IntrinsicsJvm.kt_5 */
            public void mo4759d(Transition abstractC0791m) {
            }

            @Override // androidx.transition.Transition.IntrinsicsJvm.kt_5
            /* renamed from: COUIBaseListPopupWindow_8 */
            public void mo4763e(Transition abstractC0791m) {
            }

            @Override // androidx.transition.Transition.IntrinsicsJvm.kt_5
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo4757b(Transition abstractC0791m) {
                abstractC0791m.removeListener(this);
                view.setVisibility(8);
                int size = arrayList.size();
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
                    ((View) arrayList.get(OplusGLSurfaceView_13)).setVisibility(0);
                }
            }
        });
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    /* renamed from: IntrinsicsJvm.kt_4 */
    public Object mo3588b(Object obj, Object obj2, Object obj3) {
        Transition abstractC0791mM4808a = (Transition) obj;
        Transition abstractC0791m = (Transition) obj2;
        Transition abstractC0791m2 = (Transition) obj3;
        if (abstractC0791mM4808a != null && abstractC0791m != null) {
            abstractC0791mM4808a = new TransitionSet().m4814a(abstractC0791mM4808a).m4814a(abstractC0791m).m4808a(1);
        } else if (abstractC0791mM4808a == null) {
            abstractC0791mM4808a = abstractC0791m != null ? abstractC0791m : null;
        }
        if (abstractC0791m2 == null) {
            return abstractC0791mM4808a;
        }
        TransitionSet c0795q = new TransitionSet();
        if (abstractC0791mM4808a != null) {
            c0795q.m4814a(abstractC0791mM4808a);
        }
        c0795q.m4814a(abstractC0791m2);
        return c0795q;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3579a(ViewGroup viewGroup, Object obj) {
        TransitionManager.m4798a(viewGroup, (Transition) obj);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3583a(Object obj, final Object obj2, final ArrayList<View> arrayList, final Object obj3, final ArrayList<View> arrayList2, final Object obj4, final ArrayList<View> arrayList3) {
        ((Transition) obj).addListener(new TransitionListenerAdapter() { // from class: androidx.transition.COUIBaseListPopupWindow_8.3
            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.IntrinsicsJvm.kt_5
            /* renamed from: COUIBaseListPopupWindow_8 */
            public void mo4763e(Transition abstractC0791m) {
                Object obj5 = obj2;
                if (obj5 != null) {
                    FragmentTransitionSupport.this.mo3591b(obj5, arrayList, (ArrayList<View>) null);
                }
                Object obj6 = obj3;
                if (obj6 != null) {
                    FragmentTransitionSupport.this.mo3591b(obj6, arrayList2, (ArrayList<View>) null);
                }
                Object obj7 = obj4;
                if (obj7 != null) {
                    FragmentTransitionSupport.this.mo3591b(obj7, arrayList3, (ArrayList<View>) null);
                }
            }

            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.IntrinsicsJvm.kt_5
            /* renamed from: IntrinsicsJvm.kt_4 */
            public void mo4757b(Transition abstractC0791m) {
                abstractC0791m.removeListener(this);
            }
        });
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3585a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        TransitionSet c0795q = (TransitionSet) obj;
        if (c0795q != null) {
            c0795q.getTargets().clear();
            c0795q.getTargets().addAll(arrayList2);
            mo3591b((Object) c0795q, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo3591b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        Transition abstractC0791m = (Transition) obj;
        int OplusGLSurfaceView_13 = 0;
        if (abstractC0791m instanceof TransitionSet) {
            TransitionSet c0795q = (TransitionSet) abstractC0791m;
            int iM4807a = c0795q.m4807a();
            while (OplusGLSurfaceView_13 < iM4807a) {
                mo3591b((Object) c0795q.m4817b(OplusGLSurfaceView_13), arrayList, arrayList2);
                OplusGLSurfaceView_13++;
            }
            return;
        }
        if (m4784a(abstractC0791m)) {
            return;
        }
        List<View> targets = abstractC0791m.getTargets();
        if (targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (OplusGLSurfaceView_13 < size) {
                abstractC0791m.addTarget(arrayList2.get(OplusGLSurfaceView_13));
                OplusGLSurfaceView_13++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                abstractC0791m.removeTarget(arrayList.get(size2));
            }
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo3589b(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).addTarget(view);
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void mo3593c(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).removeTarget(view);
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3580a(Object obj, final Rect rect) {
        if (obj != null) {
            ((Transition) obj).setEpicenterCallback(new Transition.IntrinsicsJvm.kt_3() { // from class: androidx.transition.COUIBaseListPopupWindow_8.4
                @Override // androidx.transition.Transition.IntrinsicsJvm.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public Rect mo4785a(Transition abstractC0791m) {
                    Rect rect2 = rect;
                    if (rect2 == null || rect2.isEmpty()) {
                        return null;
                    }
                    return rect;
                }
            });
        }
    }
}
