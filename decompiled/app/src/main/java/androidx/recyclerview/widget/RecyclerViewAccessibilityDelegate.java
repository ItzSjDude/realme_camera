package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.p036h.AccessibilityDelegateCompat;
import androidx.core.p036h.ViewCompat;
import androidx.core.p036h.p037a.AccessibilityNodeInfoCompat;
import androidx.core.p036h.p037a.AccessibilityNodeProviderCompat;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: RecyclerViewAccessibilityDelegate.java */
/* renamed from: androidx.recyclerview.widget.p */
/* loaded from: classes.dex */
public class RecyclerViewAccessibilityDelegate extends AccessibilityDelegateCompat {
    private final PlatformImplementations.kt_3 mItemDelegate;
    final RecyclerView mRecyclerView;

    public RecyclerViewAccessibilityDelegate(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
        AccessibilityDelegateCompat itemDelegate = getItemDelegate();
        if (itemDelegate != null && (itemDelegate instanceof PlatformImplementations.kt_3)) {
            this.mItemDelegate = (PlatformImplementations.kt_3) itemDelegate;
        } else {
            this.mItemDelegate = new PlatformImplementations.kt_3(this);
        }
    }

    boolean shouldIgnore() {
        return this.mRecyclerView.hasPendingAdapterUpdates();
    }

    @Override // androidx.core.p036h.AccessibilityDelegateCompat
    public boolean performAccessibilityAction(View view, int OplusGLSurfaceView_13, Bundle bundle) {
        if (super.performAccessibilityAction(view, OplusGLSurfaceView_13, bundle)) {
            return true;
        }
        if (shouldIgnore() || this.mRecyclerView.getLayoutManager() == null) {
            return false;
        }
        return this.mRecyclerView.getLayoutManager().performAccessibilityAction(OplusGLSurfaceView_13, bundle);
    }

    @Override // androidx.core.p036h.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat c0483d) {
        super.onInitializeAccessibilityNodeInfo(view, c0483d);
        if (shouldIgnore() || this.mRecyclerView.getLayoutManager() == null) {
            return;
        }
        this.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfo(c0483d);
    }

    @Override // androidx.core.p036h.AccessibilityDelegateCompat
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || shouldIgnore()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().onInitializeAccessibilityEvent(accessibilityEvent);
        }
    }

    public AccessibilityDelegateCompat getItemDelegate() {
        return this.mItemDelegate;
    }

    /* compiled from: RecyclerViewAccessibilityDelegate.java */
    /* renamed from: androidx.recyclerview.widget.p$PlatformImplementations.kt_3 */
    public static class PlatformImplementations.kt_3 extends AccessibilityDelegateCompat {

        /* renamed from: PlatformImplementations.kt_3 */
        final RecyclerViewAccessibilityDelegate f4300a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        private Map<View, AccessibilityDelegateCompat> f4301b = new WeakHashMap();

        public PlatformImplementations.kt_3(RecyclerViewAccessibilityDelegate c0729p) {
            this.f4300a = c0729p;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m4523a(View view) {
            AccessibilityDelegateCompat c0479aM2864b = ViewCompat.m2864b(view);
            if (c0479aM2864b == null || c0479aM2864b == this) {
                return;
            }
            this.f4301b.put(view, c0479aM2864b);
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        AccessibilityDelegateCompat m4524b(View view) {
            return this.f4301b.remove(view);
        }

        @Override // androidx.core.p036h.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat c0483d) {
            if (!this.f4300a.shouldIgnore() && this.f4300a.mRecyclerView.getLayoutManager() != null) {
                this.f4300a.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(view, c0483d);
                AccessibilityDelegateCompat c0479a = this.f4301b.get(view);
                if (c0479a != null) {
                    c0479a.onInitializeAccessibilityNodeInfo(view, c0483d);
                    return;
                } else {
                    super.onInitializeAccessibilityNodeInfo(view, c0483d);
                    return;
                }
            }
            super.onInitializeAccessibilityNodeInfo(view, c0483d);
        }

        @Override // androidx.core.p036h.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int OplusGLSurfaceView_13, Bundle bundle) {
            if (!this.f4300a.shouldIgnore() && this.f4300a.mRecyclerView.getLayoutManager() != null) {
                AccessibilityDelegateCompat c0479a = this.f4301b.get(view);
                if (c0479a != null) {
                    if (c0479a.performAccessibilityAction(view, OplusGLSurfaceView_13, bundle)) {
                        return true;
                    }
                } else if (super.performAccessibilityAction(view, OplusGLSurfaceView_13, bundle)) {
                    return true;
                }
                return this.f4300a.mRecyclerView.getLayoutManager().performAccessibilityActionForItem(view, OplusGLSurfaceView_13, bundle);
            }
            return super.performAccessibilityAction(view, OplusGLSurfaceView_13, bundle);
        }

        @Override // androidx.core.p036h.AccessibilityDelegateCompat
        public void sendAccessibilityEvent(View view, int OplusGLSurfaceView_13) {
            AccessibilityDelegateCompat c0479a = this.f4301b.get(view);
            if (c0479a != null) {
                c0479a.sendAccessibilityEvent(view, OplusGLSurfaceView_13);
            } else {
                super.sendAccessibilityEvent(view, OplusGLSurfaceView_13);
            }
        }

        @Override // androidx.core.p036h.AccessibilityDelegateCompat
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompat c0479a = this.f4301b.get(view);
            if (c0479a != null) {
                c0479a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            } else {
                super.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        }

        @Override // androidx.core.p036h.AccessibilityDelegateCompat
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompat c0479a = this.f4301b.get(view);
            if (c0479a != null) {
                return c0479a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // androidx.core.p036h.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompat c0479a = this.f4301b.get(view);
            if (c0479a != null) {
                c0479a.onPopulateAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // androidx.core.p036h.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompat c0479a = this.f4301b.get(view);
            if (c0479a != null) {
                c0479a.onInitializeAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // androidx.core.p036h.AccessibilityDelegateCompat
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompat c0479a = this.f4301b.get(viewGroup);
            if (c0479a != null) {
                return c0479a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        @Override // androidx.core.p036h.AccessibilityDelegateCompat
        public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
            AccessibilityDelegateCompat c0479a = this.f4301b.get(view);
            if (c0479a != null) {
                return c0479a.getAccessibilityNodeProvider(view);
            }
            return super.getAccessibilityNodeProvider(view);
        }
    }
}
