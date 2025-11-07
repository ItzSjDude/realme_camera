package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.collection.ArrayMap;
import androidx.core.p036h.ViewCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TransitionManager.java */
/* renamed from: androidx.transition.o */
/* loaded from: classes.dex */
public class TransitionManager {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static Transition f4646b = new AutoTransition();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>>> f4647c = new ThreadLocal<>();

    /* renamed from: PlatformImplementations.kt_3 */
    static ArrayList<ViewGroup> f4645a = new ArrayList<>();

    /* renamed from: PlatformImplementations.kt_3 */
    static ArrayMap<ViewGroup, ArrayList<Transition>> m4797a() {
        ArrayMap<ViewGroup, ArrayList<Transition>> arrayMap;
        WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>> weakReference = f4647c.get();
        if (weakReference != null && (arrayMap = weakReference.get()) != null) {
            return arrayMap;
        }
        ArrayMap<ViewGroup, ArrayList<Transition>> arrayMap2 = new ArrayMap<>();
        f4647c.set(new WeakReference<>(arrayMap2));
        return arrayMap2;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static void m4799b(ViewGroup viewGroup, Transition abstractC0791m) {
        if (abstractC0791m == null || viewGroup == null) {
            return;
        }
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3(abstractC0791m, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    /* compiled from: TransitionManager.java */
    /* renamed from: androidx.transition.o$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {

        /* renamed from: PlatformImplementations.kt_3 */
        Transition f4648a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        ViewGroup f4649b;

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        PlatformImplementations.kt_3(Transition abstractC0791m, ViewGroup viewGroup) {
            this.f4648a = abstractC0791m;
            this.f4649b = viewGroup;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m4801a() {
            this.f4649b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f4649b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            m4801a();
            TransitionManager.f4645a.remove(this.f4649b);
            ArrayList<Transition> arrayList = TransitionManager.m4797a().get(this.f4649b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<Transition> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().resume(this.f4649b);
                }
            }
            this.f4648a.clearValues(true);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            m4801a();
            if (!TransitionManager.f4645a.remove(this.f4649b)) {
                return true;
            }
            final ArrayMap<ViewGroup, ArrayList<Transition>> arrayMapM4797a = TransitionManager.m4797a();
            ArrayList<Transition> arrayList = arrayMapM4797a.get(this.f4649b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                arrayMapM4797a.put(this.f4649b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f4648a);
            this.f4648a.addListener(new TransitionListenerAdapter() { // from class: androidx.transition.o.PlatformImplementations.kt_3.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.IntrinsicsJvm.kt_5
                /* renamed from: IntrinsicsJvm.kt_4 */
                public void mo4757b(Transition abstractC0791m) {
                    ((ArrayList) arrayMapM4797a.get(PlatformImplementations.kt_3.this.f4649b)).remove(abstractC0791m);
                    abstractC0791m.removeListener(this);
                }
            });
            this.f4648a.captureValues(this.f4649b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((Transition) it.next()).resume(this.f4649b);
                }
            }
            this.f4648a.playTransition(this.f4649b);
            return true;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static void m4800c(ViewGroup viewGroup, Transition abstractC0791m) {
        ArrayList<Transition> arrayList = m4797a().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<Transition> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().pause(viewGroup);
            }
        }
        if (abstractC0791m != null) {
            abstractC0791m.captureValues(viewGroup, true);
        }
        Scene c0789kM4792a = Scene.m4792a(viewGroup);
        if (c0789kM4792a != null) {
            c0789kM4792a.m4794a();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m4798a(ViewGroup viewGroup, Transition abstractC0791m) {
        if (f4645a.contains(viewGroup) || !ViewCompat.m2823A(viewGroup)) {
            return;
        }
        f4645a.add(viewGroup);
        if (abstractC0791m == null) {
            abstractC0791m = f4646b;
        }
        Transition abstractC0791mMo26268clone = abstractC0791m.mo26268clone();
        m4800c(viewGroup, abstractC0791mMo26268clone);
        Scene.m4793a(viewGroup, null);
        m4799b(viewGroup, abstractC0791mMo26268clone);
    }
}
