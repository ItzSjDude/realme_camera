package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.p036h.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: DefaultItemAnimator.java */
/* renamed from: androidx.recyclerview.widget.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
public class DefaultItemAnimator extends SimpleItemAnimator {

    /* renamed from: OplusGLSurfaceView_13 */
    private static TimeInterpolator f4155i;

    /* renamed from: OplusGLSurfaceView_15 */
    private ArrayList<RecyclerView.AbstractC0707w> f4163j = new ArrayList<>();

    /* renamed from: OplusGLSurfaceView_5 */
    private ArrayList<RecyclerView.AbstractC0707w> f4164k = new ArrayList<>();

    /* renamed from: OplusGLSurfaceView_14 */
    private ArrayList<IntrinsicsJvm.kt_4> f4165l = new ArrayList<>();

    /* renamed from: OplusGLSurfaceView_6 */
    private ArrayList<PlatformImplementations.kt_3> f4166m = new ArrayList<>();

    /* renamed from: PlatformImplementations.kt_3 */
    ArrayList<ArrayList<RecyclerView.AbstractC0707w>> f4156a = new ArrayList<>();

    /* renamed from: IntrinsicsJvm.kt_4 */
    ArrayList<ArrayList<IntrinsicsJvm.kt_4>> f4157b = new ArrayList<>();

    /* renamed from: IntrinsicsJvm.kt_3 */
    ArrayList<ArrayList<PlatformImplementations.kt_3>> f4158c = new ArrayList<>();

    /* renamed from: IntrinsicsJvm.kt_5 */
    ArrayList<RecyclerView.AbstractC0707w> f4159d = new ArrayList<>();

    /* renamed from: COUIBaseListPopupWindow_8 */
    ArrayList<RecyclerView.AbstractC0707w> f4160e = new ArrayList<>();

    /* renamed from: COUIBaseListPopupWindow_12 */
    ArrayList<RecyclerView.AbstractC0707w> f4161f = new ArrayList<>();

    /* renamed from: COUIBaseListPopupWindow_11 */
    ArrayList<RecyclerView.AbstractC0707w> f4162g = new ArrayList<>();

    /* compiled from: DefaultItemAnimator.java */
    /* renamed from: androidx.recyclerview.widget.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_4 */
    private static class IntrinsicsJvm.kt_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        public RecyclerView.AbstractC0707w f4201a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public int f4202b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public int f4203c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public int f4204d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        public int f4205e;

        IntrinsicsJvm.kt_4(RecyclerView.AbstractC0707w abstractC0707w, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
            this.f4201a = abstractC0707w;
            this.f4202b = OplusGLSurfaceView_13;
            this.f4203c = i2;
            this.f4204d = i3;
            this.f4205e = i4;
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    /* renamed from: androidx.recyclerview.widget.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        public RecyclerView.AbstractC0707w f4195a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public RecyclerView.AbstractC0707w f4196b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public int f4197c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public int f4198d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        public int f4199e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        public int f4200f;

        private PlatformImplementations.kt_3(RecyclerView.AbstractC0707w abstractC0707w, RecyclerView.AbstractC0707w abstractC0707w2) {
            this.f4195a = abstractC0707w;
            this.f4196b = abstractC0707w2;
        }

        PlatformImplementations.kt_3(RecyclerView.AbstractC0707w abstractC0707w, RecyclerView.AbstractC0707w abstractC0707w2, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
            this(abstractC0707w, abstractC0707w2);
            this.f4197c = OplusGLSurfaceView_13;
            this.f4198d = i2;
            this.f4199e = i3;
            this.f4200f = i4;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f4195a + ", newHolder=" + this.f4196b + ", fromX=" + this.f4197c + ", fromY=" + this.f4198d + ", toX=" + this.f4199e + ", toY=" + this.f4200f + '}';
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0690f
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo4124a() {
        boolean z = !this.f4163j.isEmpty();
        boolean z2 = !this.f4165l.isEmpty();
        boolean z3 = !this.f4166m.isEmpty();
        boolean z4 = !this.f4164k.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.AbstractC0707w> it = this.f4163j.iterator();
            while (it.hasNext()) {
                m4406u(it.next());
            }
            this.f4163j.clear();
            if (z2) {
                final ArrayList<IntrinsicsJvm.kt_4> arrayList = new ArrayList<>();
                arrayList.addAll(this.f4165l);
                this.f4157b.add(arrayList);
                this.f4165l.clear();
                Runnable runnable = new Runnable() { // from class: androidx.recyclerview.widget.COUIBaseListPopupWindow_8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            IntrinsicsJvm.kt_4 bVar = (IntrinsicsJvm.kt_4) it2.next();
                            DefaultItemAnimator.this.m4413b(bVar.f4201a, bVar.f4202b, bVar.f4203c, bVar.f4204d, bVar.f4205e);
                        }
                        arrayList.clear();
                        DefaultItemAnimator.this.f4157b.remove(arrayList);
                    }
                };
                if (z) {
                    ViewCompat.m2858a(arrayList.get(0).f4201a.itemView, runnable, m4138g());
                } else {
                    runnable.run();
                }
            }
            if (z3) {
                final ArrayList<PlatformImplementations.kt_3> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.f4166m);
                this.f4158c.add(arrayList2);
                this.f4166m.clear();
                Runnable runnable2 = new Runnable() { // from class: androidx.recyclerview.widget.COUIBaseListPopupWindow_8.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            DefaultItemAnimator.this.m4408a((PlatformImplementations.kt_3) it2.next());
                        }
                        arrayList2.clear();
                        DefaultItemAnimator.this.f4158c.remove(arrayList2);
                    }
                };
                if (z) {
                    ViewCompat.m2858a(arrayList2.get(0).f4195a.itemView, runnable2, m4138g());
                } else {
                    runnable2.run();
                }
            }
            if (z4) {
                final ArrayList<RecyclerView.AbstractC0707w> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.f4164k);
                this.f4156a.add(arrayList3);
                this.f4164k.clear();
                Runnable runnable3 = new Runnable() { // from class: androidx.recyclerview.widget.COUIBaseListPopupWindow_8.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            DefaultItemAnimator.this.m4416c((RecyclerView.AbstractC0707w) it2.next());
                        }
                        arrayList3.clear();
                        DefaultItemAnimator.this.f4156a.remove(arrayList3);
                    }
                };
                if (z || z2 || z3) {
                    ViewCompat.m2858a(arrayList3.get(0).itemView, runnable3, (z ? m4138g() : 0L) + Math.max(z2 ? m4135e() : 0L, z3 ? m4140h() : 0L));
                } else {
                    runnable3.run();
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo4410a(RecyclerView.AbstractC0707w abstractC0707w) {
        m4407v(abstractC0707w);
        this.f4163j.add(abstractC0707w);
        return true;
    }

    /* renamed from: u */
    private void m4406u(final RecyclerView.AbstractC0707w abstractC0707w) {
        final View view = abstractC0707w.itemView;
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f4161f.add(abstractC0707w);
        viewPropertyAnimatorAnimate.setDuration(m4138g()).alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.COUIBaseListPopupWindow_8.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                DefaultItemAnimator.this.m4536l(abstractC0707w);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                view.setAlpha(1.0f);
                DefaultItemAnimator.this.m4533i(abstractC0707w);
                DefaultItemAnimator.this.f4161f.remove(abstractC0707w);
                DefaultItemAnimator.this.m4415c();
            }
        }).start();
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean mo4414b(RecyclerView.AbstractC0707w abstractC0707w) {
        m4407v(abstractC0707w);
        abstractC0707w.itemView.setAlpha(0.0f);
        this.f4164k.add(abstractC0707w);
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    void m4416c(final RecyclerView.AbstractC0707w abstractC0707w) {
        final View view = abstractC0707w.itemView;
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f4159d.add(abstractC0707w);
        viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(m4136f()).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.COUIBaseListPopupWindow_8.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                DefaultItemAnimator.this.m4538n(abstractC0707w);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                view.setAlpha(1.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                DefaultItemAnimator.this.m4535k(abstractC0707w);
                DefaultItemAnimator.this.f4159d.remove(abstractC0707w);
                DefaultItemAnimator.this.m4415c();
            }
        }).start();
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo4411a(RecyclerView.AbstractC0707w abstractC0707w, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        View view = abstractC0707w.itemView;
        int translationX = OplusGLSurfaceView_13 + ((int) abstractC0707w.itemView.getTranslationX());
        int translationY = i2 + ((int) abstractC0707w.itemView.getTranslationY());
        m4407v(abstractC0707w);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            m4534j(abstractC0707w);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX(-i5);
        }
        if (i6 != 0) {
            view.setTranslationY(-i6);
        }
        this.f4165l.add(new IntrinsicsJvm.kt_4(abstractC0707w, translationX, translationY, i3, i4));
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    void m4413b(final RecyclerView.AbstractC0707w abstractC0707w, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        final View view = abstractC0707w.itemView;
        final int i5 = i3 - OplusGLSurfaceView_13;
        final int i6 = i4 - i2;
        if (i5 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i6 != 0) {
            view.animate().translationY(0.0f);
        }
        final ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.f4160e.add(abstractC0707w);
        viewPropertyAnimatorAnimate.setDuration(m4135e()).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.COUIBaseListPopupWindow_8.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                DefaultItemAnimator.this.m4537m(abstractC0707w);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                if (i5 != 0) {
                    view.setTranslationX(0.0f);
                }
                if (i6 != 0) {
                    view.setTranslationY(0.0f);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewPropertyAnimatorAnimate.setListener(null);
                DefaultItemAnimator.this.m4534j(abstractC0707w);
                DefaultItemAnimator.this.f4160e.remove(abstractC0707w);
                DefaultItemAnimator.this.m4415c();
            }
        }).start();
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo4412a(RecyclerView.AbstractC0707w abstractC0707w, RecyclerView.AbstractC0707w abstractC0707w2, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        if (abstractC0707w == abstractC0707w2) {
            return mo4411a(abstractC0707w, OplusGLSurfaceView_13, i2, i3, i4);
        }
        float translationX = abstractC0707w.itemView.getTranslationX();
        float translationY = abstractC0707w.itemView.getTranslationY();
        float alpha = abstractC0707w.itemView.getAlpha();
        m4407v(abstractC0707w);
        int i5 = (int) ((i3 - OplusGLSurfaceView_13) - translationX);
        int i6 = (int) ((i4 - i2) - translationY);
        abstractC0707w.itemView.setTranslationX(translationX);
        abstractC0707w.itemView.setTranslationY(translationY);
        abstractC0707w.itemView.setAlpha(alpha);
        if (abstractC0707w2 != null) {
            m4407v(abstractC0707w2);
            abstractC0707w2.itemView.setTranslationX(-i5);
            abstractC0707w2.itemView.setTranslationY(-i6);
            abstractC0707w2.itemView.setAlpha(0.0f);
        }
        this.f4166m.add(new PlatformImplementations.kt_3(abstractC0707w, abstractC0707w2, OplusGLSurfaceView_13, i2, i3, i4));
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m4408a(final PlatformImplementations.kt_3 aVar) {
        RecyclerView.AbstractC0707w abstractC0707w = aVar.f4195a;
        final View view = abstractC0707w == null ? null : abstractC0707w.itemView;
        RecyclerView.AbstractC0707w abstractC0707w2 = aVar.f4196b;
        final View view2 = abstractC0707w2 != null ? abstractC0707w2.itemView : null;
        if (view != null) {
            final ViewPropertyAnimator duration = view.animate().setDuration(m4140h());
            this.f4162g.add(aVar.f4195a);
            duration.translationX(aVar.f4199e - aVar.f4197c);
            duration.translationY(aVar.f4200f - aVar.f4198d);
            duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.COUIBaseListPopupWindow_8.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    DefaultItemAnimator.this.m4530b(aVar.f4195a, true);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    duration.setListener(null);
                    view.setAlpha(1.0f);
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                    DefaultItemAnimator.this.m4528a(aVar.f4195a, true);
                    DefaultItemAnimator.this.f4162g.remove(aVar.f4195a);
                    DefaultItemAnimator.this.m4415c();
                }
            }).start();
        }
        if (view2 != null) {
            final ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
            this.f4162g.add(aVar.f4196b);
            viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(m4140h()).alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.COUIBaseListPopupWindow_8.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    DefaultItemAnimator.this.m4530b(aVar.f4196b, false);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    viewPropertyAnimatorAnimate.setListener(null);
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(0.0f);
                    view2.setTranslationY(0.0f);
                    DefaultItemAnimator.this.m4528a(aVar.f4196b, false);
                    DefaultItemAnimator.this.f4162g.remove(aVar.f4196b);
                    DefaultItemAnimator.this.m4415c();
                }
            }).start();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m4403a(List<PlatformImplementations.kt_3> list, RecyclerView.AbstractC0707w abstractC0707w) {
        for (int size = list.size() - 1; size >= 0; size--) {
            PlatformImplementations.kt_3 aVar = list.get(size);
            if (m4404a(aVar, abstractC0707w) && aVar.f4195a == null && aVar.f4196b == null) {
                list.remove(aVar);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m4405b(PlatformImplementations.kt_3 aVar) {
        if (aVar.f4195a != null) {
            m4404a(aVar, aVar.f4195a);
        }
        if (aVar.f4196b != null) {
            m4404a(aVar, aVar.f4196b);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m4404a(PlatformImplementations.kt_3 aVar, RecyclerView.AbstractC0707w abstractC0707w) {
        boolean z = false;
        if (aVar.f4196b == abstractC0707w) {
            aVar.f4196b = null;
        } else {
            if (aVar.f4195a != abstractC0707w) {
                return false;
            }
            aVar.f4195a = null;
            z = true;
        }
        abstractC0707w.itemView.setAlpha(1.0f);
        abstractC0707w.itemView.setTranslationX(0.0f);
        abstractC0707w.itemView.setTranslationY(0.0f);
        m4528a(abstractC0707w, z);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0690f
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo4134d(RecyclerView.AbstractC0707w abstractC0707w) {
        View view = abstractC0707w.itemView;
        view.animate().cancel();
        int size = this.f4165l.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.f4165l.get(size).f4201a == abstractC0707w) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                m4534j(abstractC0707w);
                this.f4165l.remove(size);
            }
        }
        m4403a(this.f4166m, abstractC0707w);
        if (this.f4163j.remove(abstractC0707w)) {
            view.setAlpha(1.0f);
            m4533i(abstractC0707w);
        }
        if (this.f4164k.remove(abstractC0707w)) {
            view.setAlpha(1.0f);
            m4535k(abstractC0707w);
        }
        for (int size2 = this.f4158c.size() - 1; size2 >= 0; size2--) {
            ArrayList<PlatformImplementations.kt_3> arrayList = this.f4158c.get(size2);
            m4403a(arrayList, abstractC0707w);
            if (arrayList.isEmpty()) {
                this.f4158c.remove(size2);
            }
        }
        for (int size3 = this.f4157b.size() - 1; size3 >= 0; size3--) {
            ArrayList<IntrinsicsJvm.kt_4> arrayList2 = this.f4157b.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (arrayList2.get(size4).f4201a == abstractC0707w) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    m4534j(abstractC0707w);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f4157b.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f4156a.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.AbstractC0707w> arrayList3 = this.f4156a.get(size5);
            if (arrayList3.remove(abstractC0707w)) {
                view.setAlpha(1.0f);
                m4535k(abstractC0707w);
                if (arrayList3.isEmpty()) {
                    this.f4156a.remove(size5);
                }
            }
        }
        this.f4161f.remove(abstractC0707w);
        this.f4159d.remove(abstractC0707w);
        this.f4162g.remove(abstractC0707w);
        this.f4160e.remove(abstractC0707w);
        m4415c();
    }

    /* renamed from: v */
    private void m4407v(RecyclerView.AbstractC0707w abstractC0707w) {
        if (f4155i == null) {
            f4155i = new ValueAnimator().getInterpolator();
        }
        abstractC0707w.itemView.animate().setInterpolator(f4155i);
        mo4134d(abstractC0707w);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0690f
    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean mo4130b() {
        return (this.f4164k.isEmpty() && this.f4166m.isEmpty() && this.f4165l.isEmpty() && this.f4163j.isEmpty() && this.f4160e.isEmpty() && this.f4161f.isEmpty() && this.f4159d.isEmpty() && this.f4162g.isEmpty() && this.f4157b.isEmpty() && this.f4156a.isEmpty() && this.f4158c.isEmpty()) ? false : true;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    void m4415c() {
        if (mo4130b()) {
            return;
        }
        m4142i();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0690f
    /* renamed from: IntrinsicsJvm.kt_5 */
    public void mo4133d() {
        int size = this.f4165l.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            IntrinsicsJvm.kt_4 bVar = this.f4165l.get(size);
            View view = bVar.f4201a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            m4534j(bVar.f4201a);
            this.f4165l.remove(size);
        }
        for (int size2 = this.f4163j.size() - 1; size2 >= 0; size2--) {
            m4533i(this.f4163j.get(size2));
            this.f4163j.remove(size2);
        }
        int size3 = this.f4164k.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.AbstractC0707w abstractC0707w = this.f4164k.get(size3);
            abstractC0707w.itemView.setAlpha(1.0f);
            m4535k(abstractC0707w);
            this.f4164k.remove(size3);
        }
        for (int size4 = this.f4166m.size() - 1; size4 >= 0; size4--) {
            m4405b(this.f4166m.get(size4));
        }
        this.f4166m.clear();
        if (mo4130b()) {
            for (int size5 = this.f4157b.size() - 1; size5 >= 0; size5--) {
                ArrayList<IntrinsicsJvm.kt_4> arrayList = this.f4157b.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    IntrinsicsJvm.kt_4 bVar2 = arrayList.get(size6);
                    View view2 = bVar2.f4201a.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    m4534j(bVar2.f4201a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f4157b.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f4156a.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.AbstractC0707w> arrayList2 = this.f4156a.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.AbstractC0707w abstractC0707w2 = arrayList2.get(size8);
                    abstractC0707w2.itemView.setAlpha(1.0f);
                    m4535k(abstractC0707w2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f4156a.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.f4158c.size() - 1; size9 >= 0; size9--) {
                ArrayList<PlatformImplementations.kt_3> arrayList3 = this.f4158c.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    m4405b(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f4158c.remove(arrayList3);
                    }
                }
            }
            m4409a(this.f4161f);
            m4409a(this.f4160e);
            m4409a(this.f4159d);
            m4409a(this.f4162g);
            m4142i();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m4409a(List<RecyclerView.AbstractC0707w> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).itemView.animate().cancel();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0690f
    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo4129a(RecyclerView.AbstractC0707w abstractC0707w, List<Object> list) {
        return !list.isEmpty() || super.mo4129a(abstractC0707w, list);
    }
}
