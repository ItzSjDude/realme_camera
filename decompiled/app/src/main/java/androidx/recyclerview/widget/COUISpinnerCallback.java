package androidx.recyclerview.widget;

/* compiled from: RecyclerViewAccessibilityDelegate.java */
/* loaded from: classes.dex */
public class p_renamed extends androidx.core.h_renamed.a_renamed {
    private final androidx.recyclerview.widget.p_renamed.a_renamed mItemDelegate;
    final androidx.recyclerview.widget.RecyclerView mRecyclerView;

    public p_renamed(androidx.recyclerview.widget.RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
        androidx.core.h_renamed.a_renamed itemDelegate = getItemDelegate();
        if (itemDelegate != null && (itemDelegate instanceof androidx.recyclerview.widget.p_renamed.a_renamed)) {
            this.mItemDelegate = (androidx.recyclerview.widget.p_renamed.a_renamed) itemDelegate;
        } else {
            this.mItemDelegate = new androidx.recyclerview.widget.p_renamed.a_renamed(this);
        }
    }

    boolean shouldIgnore() {
        return this.mRecyclerView.hasPendingAdapterUpdates();
    }

    @Override // androidx.core.h_renamed.a_renamed
    public boolean performAccessibilityAction(android.view.View view, int i_renamed, android.os.Bundle bundle) {
        if (super.performAccessibilityAction(view, i_renamed, bundle)) {
            return true;
        }
        if (shouldIgnore() || this.mRecyclerView.getLayoutManager() == null) {
            return false;
        }
        return this.mRecyclerView.getLayoutManager().performAccessibilityAction(i_renamed, bundle);
    }

    @Override // androidx.core.h_renamed.a_renamed
    public void onInitializeAccessibilityNodeInfo(android.view.View view, androidx.core.h_renamed.a_renamed.d_renamed dVar) {
        super.onInitializeAccessibilityNodeInfo(view, dVar);
        if (shouldIgnore() || this.mRecyclerView.getLayoutManager() == null) {
            return;
        }
        this.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfo(dVar);
    }

    @Override // androidx.core.h_renamed.a_renamed
    public void onInitializeAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        if (!(view instanceof androidx.recyclerview.widget.RecyclerView) || shouldIgnore()) {
            return;
        }
        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().onInitializeAccessibilityEvent(accessibilityEvent);
        }
    }

    public androidx.core.h_renamed.a_renamed getItemDelegate() {
        return this.mItemDelegate;
    }

    /* compiled from: RecyclerViewAccessibilityDelegate.java */
    public static class a_renamed extends androidx.core.h_renamed.a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        final androidx.recyclerview.widget.p_renamed f1547a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private java.util.Map<android.view.View, androidx.core.h_renamed.a_renamed> f1548b = new java.util.WeakHashMap();

        public a_renamed(androidx.recyclerview.widget.p_renamed pVar) {
            this.f1547a = pVar;
        }

        void a_renamed(android.view.View view) {
            androidx.core.h_renamed.a_renamed aVarB = androidx.core.h_renamed.v_renamed.b_renamed(view);
            if (aVarB == null || aVarB == this) {
                return;
            }
            this.f1548b.put(view, aVarB);
        }

        androidx.core.h_renamed.a_renamed b_renamed(android.view.View view) {
            return this.f1548b.remove(view);
        }

        @Override // androidx.core.h_renamed.a_renamed
        public void onInitializeAccessibilityNodeInfo(android.view.View view, androidx.core.h_renamed.a_renamed.d_renamed dVar) {
            if (!this.f1547a.shouldIgnore() && this.f1547a.mRecyclerView.getLayoutManager() != null) {
                this.f1547a.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(view, dVar);
                androidx.core.h_renamed.a_renamed aVar = this.f1548b.get(view);
                if (aVar != null) {
                    aVar.onInitializeAccessibilityNodeInfo(view, dVar);
                    return;
                } else {
                    super.onInitializeAccessibilityNodeInfo(view, dVar);
                    return;
                }
            }
            super.onInitializeAccessibilityNodeInfo(view, dVar);
        }

        @Override // androidx.core.h_renamed.a_renamed
        public boolean performAccessibilityAction(android.view.View view, int i_renamed, android.os.Bundle bundle) {
            if (!this.f1547a.shouldIgnore() && this.f1547a.mRecyclerView.getLayoutManager() != null) {
                androidx.core.h_renamed.a_renamed aVar = this.f1548b.get(view);
                if (aVar != null) {
                    if (aVar.performAccessibilityAction(view, i_renamed, bundle)) {
                        return true;
                    }
                } else if (super.performAccessibilityAction(view, i_renamed, bundle)) {
                    return true;
                }
                return this.f1547a.mRecyclerView.getLayoutManager().performAccessibilityActionForItem(view, i_renamed, bundle);
            }
            return super.performAccessibilityAction(view, i_renamed, bundle);
        }

        @Override // androidx.core.h_renamed.a_renamed
        public void sendAccessibilityEvent(android.view.View view, int i_renamed) {
            androidx.core.h_renamed.a_renamed aVar = this.f1548b.get(view);
            if (aVar != null) {
                aVar.sendAccessibilityEvent(view, i_renamed);
            } else {
                super.sendAccessibilityEvent(view, i_renamed);
            }
        }

        @Override // androidx.core.h_renamed.a_renamed
        public void sendAccessibilityEventUnchecked(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            androidx.core.h_renamed.a_renamed aVar = this.f1548b.get(view);
            if (aVar != null) {
                aVar.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            } else {
                super.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        }

        @Override // androidx.core.h_renamed.a_renamed
        public boolean dispatchPopulateAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            androidx.core.h_renamed.a_renamed aVar = this.f1548b.get(view);
            if (aVar != null) {
                return aVar.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // androidx.core.h_renamed.a_renamed
        public void onPopulateAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            androidx.core.h_renamed.a_renamed aVar = this.f1548b.get(view);
            if (aVar != null) {
                aVar.onPopulateAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // androidx.core.h_renamed.a_renamed
        public void onInitializeAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            androidx.core.h_renamed.a_renamed aVar = this.f1548b.get(view);
            if (aVar != null) {
                aVar.onInitializeAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // androidx.core.h_renamed.a_renamed
        public boolean onRequestSendAccessibilityEvent(android.view.ViewGroup viewGroup, android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            androidx.core.h_renamed.a_renamed aVar = this.f1548b.get(viewGroup);
            if (aVar != null) {
                return aVar.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        @Override // androidx.core.h_renamed.a_renamed
        public androidx.core.h_renamed.a_renamed.e_renamed getAccessibilityNodeProvider(android.view.View view) {
            androidx.core.h_renamed.a_renamed aVar = this.f1548b.get(view);
            if (aVar != null) {
                return aVar.getAccessibilityNodeProvider(view);
            }
            return super.getAccessibilityNodeProvider(view);
        }
    }
}
