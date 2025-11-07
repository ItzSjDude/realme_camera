package androidx.core.h_renamed;

/* compiled from: AccessibilityDelegateCompat.java */
/* loaded from: classes.dex */
public class a_renamed {
    private static final android.view.View.AccessibilityDelegate DEFAULT_DELEGATE = new android.view.View.AccessibilityDelegate();
    private final android.view.View.AccessibilityDelegate mBridge;
    private final android.view.View.AccessibilityDelegate mOriginalDelegate;

    /* compiled from: AccessibilityDelegateCompat.java */
    /* renamed from: androidx.core.h_renamed.a_renamed$a_renamed, reason: collision with other inner class name */
    static final class AccessibilityDelegateCompat_2 extends android.view.View.AccessibilityDelegate {

        /* renamed from: a_renamed, reason: collision with root package name */
        final androidx.core.h_renamed.a_renamed f955a;

        AccessibilityDelegateCompat_2(androidx.core.h_renamed.a_renamed aVar) {
            this.f955a = aVar;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            return this.f955a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            this.f955a.onInitializeAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(android.view.View view, android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
            androidx.core.h_renamed.a_renamed.d_renamed dVarA = androidx.core.h_renamed.a_renamed.d_renamed.a_renamed(accessibilityNodeInfo);
            dVarA.k_renamed(androidx.core.h_renamed.v_renamed.G_renamed(view));
            dVarA.m_renamed(androidx.core.h_renamed.v_renamed.I_renamed(view));
            dVarA.h_renamed(androidx.core.h_renamed.v_renamed.H_renamed(view));
            this.f955a.onInitializeAccessibilityNodeInfo(view, dVarA);
            dVarA.a_renamed(accessibilityNodeInfo.getText(), view);
            java.util.List<androidx.core.h_renamed.a_renamed.d_renamed.a_renamed> actionList = androidx.core.h_renamed.a_renamed.getActionList(view);
            for (int i_renamed = 0; i_renamed < actionList.size(); i_renamed++) {
                dVarA.a_renamed(actionList.get(i_renamed));
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            this.f955a.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(android.view.ViewGroup viewGroup, android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            return this.f955a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(android.view.View view, int i_renamed) {
            this.f955a.sendAccessibilityEvent(view, i_renamed);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            this.f955a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public android.view.accessibility.AccessibilityNodeProvider getAccessibilityNodeProvider(android.view.View view) {
            androidx.core.h_renamed.a_renamed.e_renamed accessibilityNodeProvider = this.f955a.getAccessibilityNodeProvider(view);
            if (accessibilityNodeProvider != null) {
                return (android.view.accessibility.AccessibilityNodeProvider) accessibilityNodeProvider.a_renamed();
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(android.view.View view, int i_renamed, android.os.Bundle bundle) {
            return this.f955a.performAccessibilityAction(view, i_renamed, bundle);
        }
    }

    public a_renamed() {
        this(DEFAULT_DELEGATE);
    }

    public a_renamed(android.view.View.AccessibilityDelegate accessibilityDelegate) {
        this.mOriginalDelegate = accessibilityDelegate;
        this.mBridge = new androidx.core.h_renamed.a_renamed.AccessibilityDelegateCompat_2(this);
    }

    android.view.View.AccessibilityDelegate getBridge() {
        return this.mBridge;
    }

    public void sendAccessibilityEvent(android.view.View view, int i_renamed) {
        this.mOriginalDelegate.sendAccessibilityEvent(view, i_renamed);
    }

    public void sendAccessibilityEventUnchecked(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        return this.mOriginalDelegate.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void onPopulateAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void onInitializeAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(android.view.View view, androidx.core.h_renamed.a_renamed.d_renamed dVar) {
        this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, dVar.a_renamed());
    }

    public boolean onRequestSendAccessibilityEvent(android.view.ViewGroup viewGroup, android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        return this.mOriginalDelegate.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public androidx.core.h_renamed.a_renamed.e_renamed getAccessibilityNodeProvider(android.view.View view) {
        android.view.accessibility.AccessibilityNodeProvider accessibilityNodeProvider;
        if (android.os.Build.VERSION.SDK_INT < 16 || (accessibilityNodeProvider = this.mOriginalDelegate.getAccessibilityNodeProvider(view)) == null) {
            return null;
        }
        return new androidx.core.h_renamed.a_renamed.e_renamed(accessibilityNodeProvider);
    }

    public boolean performAccessibilityAction(android.view.View view, int i_renamed, android.os.Bundle bundle) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        java.util.List<androidx.core.h_renamed.a_renamed.d_renamed.a_renamed> actionList = getActionList(view);
        boolean zPerformAccessibilityAction = false;
        int i2 = 0;
        while (true) {
            if (i2 >= actionList.size()) {
                break;
            }
            androidx.core.h_renamed.a_renamed.d_renamed.a_renamed aVar = actionList.get(i2);
            if (aVar.a_renamed() == i_renamed) {
                zPerformAccessibilityAction = aVar.a_renamed(view, bundle);
                break;
            }
            i2++;
        }
        if (!zPerformAccessibilityAction && android.os.Build.VERSION.SDK_INT >= 16) {
            zPerformAccessibilityAction = this.mOriginalDelegate.performAccessibilityAction(view, i_renamed, bundle);
        }
        return (zPerformAccessibilityAction || i_renamed != androidx.core.R_renamed.id_renamed.accessibility_action_clickable_span) ? zPerformAccessibilityAction : performClickableSpanAction(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    private boolean performClickableSpanAction(int i_renamed, android.view.View view) {
        java.lang.ref.WeakReference weakReference;
        android.util.SparseArray sparseArray = (android.util.SparseArray) view.getTag(androidx.core.R_renamed.id_renamed.tag_accessibility_clickable_spans);
        if (sparseArray == null || (weakReference = (java.lang.ref.WeakReference) sparseArray.get(i_renamed)) == null) {
            return false;
        }
        android.text.style.ClickableSpan clickableSpan = (android.text.style.ClickableSpan) weakReference.get();
        if (!isSpanStillValid(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    private boolean isSpanStillValid(android.text.style.ClickableSpan clickableSpan, android.view.View view) {
        if (clickableSpan != null) {
            android.text.style.ClickableSpan[] clickableSpanArrD = androidx.core.h_renamed.a_renamed.d_renamed.d_renamed(view.createAccessibilityNodeInfo().getText());
            for (int i_renamed = 0; clickableSpanArrD != null && i_renamed < clickableSpanArrD.length; i_renamed++) {
                if (clickableSpan.equals(clickableSpanArrD[i_renamed])) {
                    return true;
                }
            }
        }
        return false;
    }

    static java.util.List<androidx.core.h_renamed.a_renamed.d_renamed.a_renamed> getActionList(android.view.View view) {
        java.util.List<androidx.core.h_renamed.a_renamed.d_renamed.a_renamed> list = (java.util.List) view.getTag(androidx.core.R_renamed.id_renamed.tag_accessibility_actions);
        return list == null ? java.util.Collections.emptyList() : list;
    }
}
