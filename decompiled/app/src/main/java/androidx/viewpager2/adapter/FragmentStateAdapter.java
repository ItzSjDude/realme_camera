package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.collection.LongSparseArray;
import androidx.core.p036h.ViewCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: FragmentStateAdapter.java */
/* renamed from: androidx.viewpager2.adapter.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public abstract class FragmentStateAdapter extends RecyclerView.AbstractC0685a<FragmentViewHolder> implements StatefulAdapter {

    /* renamed from: PlatformImplementations.kt_3 */
    final Lifecycle f4870a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    final FragmentManager f4871b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    final LongSparseArray<Fragment> f4872c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    PlatformImplementations.kt_3 f4873d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private IntrinsicsJvm.kt_4 f4874e;

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    public long getItemId(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m5023a(final FragmentViewHolder c0834b) {
        Fragment fragment = this.f4872c.get(c0834b.getItemId());
        if (fragment == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        FrameLayout frameLayoutM5032a = c0834b.m5032a();
        View view = fragment.getView();
        if (!fragment.isAdded() && view != null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        if (fragment.isAdded() && view == null) {
            m5021a(fragment, frameLayoutM5032a);
            return;
        }
        if (fragment.isAdded() && view.getParent() != null) {
            if (view.getParent() != frameLayoutM5032a) {
                m5022a(view, frameLayoutM5032a);
                return;
            }
            return;
        }
        if (fragment.isAdded()) {
            m5022a(view, frameLayoutM5032a);
            return;
        }
        if (!m5024a()) {
            m5021a(fragment, frameLayoutM5032a);
            List<IntrinsicsJvm.kt_3.PlatformImplementations.kt_3> listM5025a = this.f4873d.m5025a(fragment);
            try {
                fragment.setMenuVisibility(false);
                this.f4871b.mo3389a().m3542a(fragment, "COUIBaseListPopupWindow_12" + c0834b.getItemId()).mo3310a(fragment, Lifecycle.IntrinsicsJvm.kt_4.STARTED).mo3325d();
                this.f4874e.m5028a(false);
                return;
            } finally {
                this.f4873d.m5027a(listM5025a);
            }
        }
        if (this.f4871b.mo3398e()) {
            return;
        }
        this.f4870a.mo3639a(new LifecycleEventObserver() { // from class: androidx.viewpager2.adapter.FragmentStateAdapter$2
            @Override // androidx.lifecycle.LifecycleEventObserver
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo714a(LifecycleOwner interfaceC0605h, Lifecycle.PlatformImplementations.kt_3 aVar) {
                if (this.f4866b.m5024a()) {
                    return;
                }
                interfaceC0605h.getLifecycle().mo3640b(this);
                if (ViewCompat.m2826D(c0834b.m5032a())) {
                    this.f4866b.m5023a(c0834b);
                }
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m5021a(final Fragment fragment, final FrameLayout frameLayout) {
        this.f4871b.mo3393a(new FragmentManager.PlatformImplementations.kt_3() { // from class: androidx.viewpager2.adapter.PlatformImplementations.kt_3.1
            @Override // androidx.fragment.app.FragmentManager.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo3404a(FragmentManager abstractC0586h, Fragment fragment2, View view, Bundle bundle) {
                if (fragment2 == fragment) {
                    abstractC0586h.mo3392a(this);
                    FragmentStateAdapter.this.m5022a(view, frameLayout);
                }
            }
        }, false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m5022a(View view, FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 1) {
            throw new IllegalStateException("Design assumption violated.");
        }
        if (view.getParent() == frameLayout) {
            return;
        }
        if (frameLayout.getChildCount() > 0) {
            frameLayout.removeAllViews();
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        frameLayout.addView(view);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    boolean m5024a() {
        return this.f4871b.mo3400g();
    }

    /* compiled from: FragmentStateAdapter.java */
    /* renamed from: androidx.viewpager2.adapter.PlatformImplementations.kt_3$IntrinsicsJvm.kt_4 */
    class IntrinsicsJvm.kt_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        final /* synthetic */ FragmentStateAdapter f4879a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private ViewPager2 f4880b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private long f4881c;

        /* renamed from: PlatformImplementations.kt_3 */
        void m5028a(boolean z) {
            int currentItem;
            Fragment fragment;
            if (this.f4879a.m5024a() || this.f4880b.getScrollState() != 0 || this.f4879a.f4872c.isEmpty() || this.f4879a.getItemCount() == 0 || (currentItem = this.f4880b.getCurrentItem()) >= this.f4879a.getItemCount()) {
                return;
            }
            long itemId = this.f4879a.getItemId(currentItem);
            if ((itemId != this.f4881c || z) && (fragment = this.f4879a.f4872c.get(itemId)) != null && fragment.isAdded()) {
                this.f4881c = itemId;
                FragmentTransaction abstractC0589kMo3389a = this.f4879a.f4871b.mo3389a();
                ArrayList arrayList = new ArrayList();
                Fragment fragment2 = null;
                for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.f4879a.f4872c.size(); OplusGLSurfaceView_13++) {
                    long jKeyAt = this.f4879a.f4872c.keyAt(OplusGLSurfaceView_13);
                    Fragment fragmentValueAt = this.f4879a.f4872c.valueAt(OplusGLSurfaceView_13);
                    if (fragmentValueAt.isAdded()) {
                        if (jKeyAt != this.f4881c) {
                            abstractC0589kMo3389a.mo3310a(fragmentValueAt, Lifecycle.IntrinsicsJvm.kt_4.STARTED);
                            arrayList.add(this.f4879a.f4873d.m5026a(fragmentValueAt, Lifecycle.IntrinsicsJvm.kt_4.STARTED));
                        } else {
                            fragment2 = fragmentValueAt;
                        }
                        fragmentValueAt.setMenuVisibility(jKeyAt == this.f4881c);
                    }
                }
                if (fragment2 != null) {
                    abstractC0589kMo3389a.mo3310a(fragment2, Lifecycle.IntrinsicsJvm.kt_4.RESUMED);
                    arrayList.add(this.f4879a.f4873d.m5026a(fragment2, Lifecycle.IntrinsicsJvm.kt_4.RESUMED));
                }
                if (abstractC0589kMo3389a.mo3329h()) {
                    return;
                }
                abstractC0589kMo3389a.mo3325d();
                Collections.reverse(arrayList);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    this.f4879a.f4873d.m5027a((List<IntrinsicsJvm.kt_3.PlatformImplementations.kt_3>) it.next());
                }
            }
        }
    }

    /* compiled from: FragmentStateAdapter.java */
    /* renamed from: androidx.viewpager2.adapter.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private List<IntrinsicsJvm.kt_3> f4878a;

        /* renamed from: PlatformImplementations.kt_3 */
        public List<IntrinsicsJvm.kt_3.PlatformImplementations.kt_3> m5026a(Fragment fragment, Lifecycle.IntrinsicsJvm.kt_4 bVar) {
            ArrayList arrayList = new ArrayList();
            Iterator<IntrinsicsJvm.kt_3> it = this.f4878a.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().m5030a(fragment, bVar));
            }
            return arrayList;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m5027a(List<IntrinsicsJvm.kt_3.PlatformImplementations.kt_3> list) {
            Iterator<IntrinsicsJvm.kt_3.PlatformImplementations.kt_3> it = list.iterator();
            while (it.hasNext()) {
                it.next().mo5031a();
            }
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public List<IntrinsicsJvm.kt_3.PlatformImplementations.kt_3> m5025a(Fragment fragment) {
            ArrayList arrayList = new ArrayList();
            Iterator<IntrinsicsJvm.kt_3> it = this.f4878a.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().m5029a(fragment));
            }
            return arrayList;
        }
    }

    /* compiled from: FragmentStateAdapter.java */
    /* renamed from: androidx.viewpager2.adapter.PlatformImplementations.kt_3$IntrinsicsJvm.kt_3 */
    public static abstract class IntrinsicsJvm.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private static final PlatformImplementations.kt_3 f4882a = new PlatformImplementations.kt_3() { // from class: androidx.viewpager2.adapter.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3.1
            @Override // androidx.viewpager2.adapter.FragmentStateAdapter.IntrinsicsJvm.kt_3.PlatformImplementations.kt_3
            /* renamed from: PlatformImplementations.kt_3 */
            public void mo5031a() {
            }
        };

        /* compiled from: FragmentStateAdapter.java */
        /* renamed from: androidx.viewpager2.adapter.PlatformImplementations.kt_3$IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
        public interface PlatformImplementations.kt_3 {
            /* renamed from: PlatformImplementations.kt_3 */
            void mo5031a();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public PlatformImplementations.kt_3 m5029a(Fragment fragment) {
            return f4882a;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public PlatformImplementations.kt_3 m5030a(Fragment fragment, Lifecycle.IntrinsicsJvm.kt_4 bVar) {
            return f4882a;
        }
    }
}
