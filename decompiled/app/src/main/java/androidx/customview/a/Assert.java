package androidx.customview.a_renamed;

/* compiled from: ExploreByTouchHelper.java */
/* loaded from: classes.dex */
public abstract class a_renamed extends androidx.core.h_renamed.a_renamed {
    private static final java.lang.String DEFAULT_CLASS_NAME = "android.view.View";
    public static final int HOST_ID = -1;
    public static final int INVALID_ID = Integer.MIN_VALUE;
    private static final android.graphics.Rect INVALID_PARENT_BOUNDS = new android.graphics.Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    private static final androidx.customview.a_renamed.b_renamed.a_renamed<androidx.core.h_renamed.a_renamed.d_renamed> NODE_ADAPTER = new androidx.customview.a_renamed.b_renamed.a_renamed<androidx.core.h_renamed.a_renamed.d_renamed>() { // from class: androidx.customview.a_renamed.a_renamed.1
        @Override // androidx.customview.a_renamed.b_renamed.a_renamed
        public void a_renamed(androidx.core.h_renamed.a_renamed.d_renamed dVar, android.graphics.Rect rect) {
            dVar.a_renamed(rect);
        }
    };
    private static final androidx.customview.a_renamed.b_renamed.FocusStrategy_3<androidx.collection.SparseArrayCompat<androidx.core.h_renamed.a_renamed.d_renamed>, androidx.core.h_renamed.a_renamed.d_renamed> SPARSE_VALUES_ADAPTER = new androidx.customview.a_renamed.b_renamed.FocusStrategy_3<androidx.collection.SparseArrayCompat<androidx.core.h_renamed.a_renamed.d_renamed>, androidx.core.h_renamed.a_renamed.d_renamed>() { // from class: androidx.customview.a_renamed.a_renamed.2
        @Override // androidx.customview.a_renamed.b_renamed.FocusStrategy_3
        public androidx.core.h_renamed.a_renamed.d_renamed a_renamed(androidx.collection.SparseArrayCompat<androidx.core.h_renamed.a_renamed.d_renamed> sparseArrayCompat, int i_renamed) {
            return sparseArrayCompat.valueAt(i_renamed);
        }

        @Override // androidx.customview.a_renamed.b_renamed.FocusStrategy_3
        public int a_renamed(androidx.collection.SparseArrayCompat<androidx.core.h_renamed.a_renamed.d_renamed> sparseArrayCompat) {
            return sparseArrayCompat.size();
        }
    };
    private final android.view.View mHost;
    private final android.view.accessibility.AccessibilityManager mManager;
    private androidx.customview.a_renamed.a_renamed.ExploreByTouchHelper_2 mNodeProvider;
    private final android.graphics.Rect mTempScreenRect = new android.graphics.Rect();
    private final android.graphics.Rect mTempParentRect = new android.graphics.Rect();
    private final android.graphics.Rect mTempVisibleRect = new android.graphics.Rect();
    private final int[] mTempGlobalRect = new int[2];
    int mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
    int mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
    private int mHoveredVirtualViewId = Integer.MIN_VALUE;

    private static int keyToDirection(int i_renamed) {
        if (i_renamed == 19) {
            return 33;
        }
        if (i_renamed != 21) {
            return i_renamed != 22 ? 130 : 66;
        }
        return 17;
    }

    protected abstract int getVirtualViewAt(float f_renamed, float f2);

    protected abstract void getVisibleVirtualViews(java.util.List<java.lang.Integer> list);

    protected abstract boolean onPerformActionForVirtualView(int i_renamed, int i2, android.os.Bundle bundle);

    protected void onPopulateEventForHost(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
    }

    protected void onPopulateEventForVirtualView(int i_renamed, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
    }

    protected void onPopulateNodeForHost(androidx.core.h_renamed.a_renamed.d_renamed dVar) {
    }

    protected abstract void onPopulateNodeForVirtualView(int i_renamed, androidx.core.h_renamed.a_renamed.d_renamed dVar);

    protected void onVirtualViewKeyboardFocusChanged(int i_renamed, boolean z_renamed) {
    }

    public a_renamed(android.view.View view) {
        if (view == null) {
            throw new java.lang.IllegalArgumentException("View may not be_renamed null");
        }
        this.mHost = view;
        this.mManager = (android.view.accessibility.AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (androidx.core.h_renamed.v_renamed.f_renamed(view) == 0) {
            androidx.core.h_renamed.v_renamed.b_renamed(view, 1);
        }
    }

    @Override // androidx.core.h_renamed.a_renamed
    public androidx.core.h_renamed.a_renamed.e_renamed getAccessibilityNodeProvider(android.view.View view) {
        if (this.mNodeProvider == null) {
            this.mNodeProvider = new androidx.customview.a_renamed.a_renamed.ExploreByTouchHelper_2();
        }
        return this.mNodeProvider;
    }

    public final boolean dispatchHoverEvent(android.view.MotionEvent motionEvent) {
        if (!this.mManager.isEnabled() || !this.mManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int virtualViewAt = getVirtualViewAt(motionEvent.getX(), motionEvent.getY());
            updateHoveredVirtualView(virtualViewAt);
            return virtualViewAt != Integer.MIN_VALUE;
        }
        if (action != 10 || this.mHoveredVirtualViewId == Integer.MIN_VALUE) {
            return false;
        }
        updateHoveredVirtualView(Integer.MIN_VALUE);
        return true;
    }

    public final boolean dispatchKeyEvent(android.view.KeyEvent keyEvent) {
        int i_renamed = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 61) {
            if (keyCode != 66) {
                switch (keyCode) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                        if (!keyEvent.hasNoModifiers()) {
                            return false;
                        }
                        int iKeyToDirection = keyToDirection(keyCode);
                        int repeatCount = keyEvent.getRepeatCount() + 1;
                        boolean z_renamed = false;
                        while (i_renamed < repeatCount && moveFocus(iKeyToDirection, null)) {
                            i_renamed++;
                            z_renamed = true;
                        }
                        return z_renamed;
                    case 23:
                        break;
                    default:
                        return false;
                }
            }
            if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
                return false;
            }
            clickKeyboardFocusedVirtualView();
            return true;
        }
        if (keyEvent.hasNoModifiers()) {
            return moveFocus(2, null);
        }
        if (keyEvent.hasModifiers(1)) {
            return moveFocus(1, null);
        }
        return false;
    }

    public final void onFocusChanged(boolean z_renamed, int i_renamed, android.graphics.Rect rect) {
        int i2 = this.mKeyboardFocusedVirtualViewId;
        if (i2 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i2);
        }
        if (z_renamed) {
            moveFocus(i_renamed, rect);
        }
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.mAccessibilityFocusedVirtualViewId;
    }

    public final int getKeyboardFocusedVirtualViewId() {
        return this.mKeyboardFocusedVirtualViewId;
    }

    private void getBoundsInParent(int i_renamed, android.graphics.Rect rect) {
        obtainAccessibilityNodeInfo(i_renamed).a_renamed(rect);
    }

    private boolean moveFocus(int i_renamed, android.graphics.Rect rect) {
        androidx.core.h_renamed.a_renamed.d_renamed dVar;
        androidx.collection.SparseArrayCompat<androidx.core.h_renamed.a_renamed.d_renamed> allNodes = getAllNodes();
        int i2 = this.mKeyboardFocusedVirtualViewId;
        androidx.core.h_renamed.a_renamed.d_renamed dVar2 = i2 == Integer.MIN_VALUE ? null : allNodes.get(i2);
        if (i_renamed == 1 || i_renamed == 2) {
            dVar = (androidx.core.h_renamed.a_renamed.d_renamed) androidx.customview.a_renamed.b_renamed.a_renamed(allNodes, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, dVar2, i_renamed, androidx.core.h_renamed.v_renamed.g_renamed(this.mHost) == 1, false);
        } else if (i_renamed == 17 || i_renamed == 33 || i_renamed == 66 || i_renamed == 130) {
            android.graphics.Rect rect2 = new android.graphics.Rect();
            int i3 = this.mKeyboardFocusedVirtualViewId;
            if (i3 != Integer.MIN_VALUE) {
                getBoundsInParent(i3, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                guessPreviouslyFocusedRect(this.mHost, i_renamed, rect2);
            }
            dVar = (androidx.core.h_renamed.a_renamed.d_renamed) androidx.customview.a_renamed.b_renamed.a_renamed(allNodes, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, dVar2, rect2, i_renamed);
        } else {
            throw new java.lang.IllegalArgumentException("direction must be_renamed one of_renamed {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return requestKeyboardFocusForVirtualView(dVar != null ? allNodes.keyAt(allNodes.indexOfValue(dVar)) : Integer.MIN_VALUE);
    }

    private androidx.collection.SparseArrayCompat<androidx.core.h_renamed.a_renamed.d_renamed> getAllNodes() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        getVisibleVirtualViews(arrayList);
        androidx.collection.SparseArrayCompat<androidx.core.h_renamed.a_renamed.d_renamed> sparseArrayCompat = new androidx.collection.SparseArrayCompat<>();
        for (int i_renamed = 0; i_renamed < arrayList.size(); i_renamed++) {
            sparseArrayCompat.put(i_renamed, createNodeForChild(i_renamed));
        }
        return sparseArrayCompat;
    }

    private static android.graphics.Rect guessPreviouslyFocusedRect(android.view.View view, int i_renamed, android.graphics.Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i_renamed == 17) {
            rect.set(width, 0, width, height);
        } else if (i_renamed == 33) {
            rect.set(0, height, width, height);
        } else if (i_renamed == 66) {
            rect.set(-1, 0, -1, height);
        } else if (i_renamed == 130) {
            rect.set(0, -1, width, -1);
        } else {
            throw new java.lang.IllegalArgumentException("direction must be_renamed one of_renamed {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return rect;
    }

    private boolean clickKeyboardFocusedVirtualView() {
        int i_renamed = this.mKeyboardFocusedVirtualViewId;
        return i_renamed != Integer.MIN_VALUE && onPerformActionForVirtualView(i_renamed, 16, null);
    }

    public final boolean sendEventForVirtualView(int i_renamed, int i2) {
        android.view.ViewParent parent;
        if (i_renamed == Integer.MIN_VALUE || !this.mManager.isEnabled() || (parent = this.mHost.getParent()) == null) {
            return false;
        }
        return androidx.core.h_renamed.y_renamed.a_renamed(parent, this.mHost, createEvent(i_renamed, i2));
    }

    public final void invalidateRoot() {
        invalidateVirtualView(-1, 1);
    }

    public final void invalidateVirtualView(int i_renamed) {
        invalidateVirtualView(i_renamed, 0);
    }

    public final void invalidateVirtualView(int i_renamed, int i2) {
        android.view.ViewParent parent;
        if (i_renamed == Integer.MIN_VALUE || !this.mManager.isEnabled() || (parent = this.mHost.getParent()) == null) {
            return;
        }
        android.view.accessibility.AccessibilityEvent accessibilityEventCreateEvent = createEvent(i_renamed, 2048);
        androidx.core.h_renamed.a_renamed.b_renamed.a_renamed(accessibilityEventCreateEvent, i2);
        androidx.core.h_renamed.y_renamed.a_renamed(parent, this.mHost, accessibilityEventCreateEvent);
    }

    @java.lang.Deprecated
    public int getFocusedVirtualView() {
        return getAccessibilityFocusedVirtualViewId();
    }

    private void updateHoveredVirtualView(int i_renamed) {
        int i2 = this.mHoveredVirtualViewId;
        if (i2 == i_renamed) {
            return;
        }
        this.mHoveredVirtualViewId = i_renamed;
        sendEventForVirtualView(i_renamed, 128);
        sendEventForVirtualView(i2, 256);
    }

    private android.view.accessibility.AccessibilityEvent createEvent(int i_renamed, int i2) {
        if (i_renamed == -1) {
            return createEventForHost(i2);
        }
        return createEventForChild(i_renamed, i2);
    }

    private android.view.accessibility.AccessibilityEvent createEventForHost(int i_renamed) {
        android.view.accessibility.AccessibilityEvent accessibilityEventObtain = android.view.accessibility.AccessibilityEvent.obtain(i_renamed);
        this.mHost.onInitializeAccessibilityEvent(accessibilityEventObtain);
        return accessibilityEventObtain;
    }

    @Override // androidx.core.h_renamed.a_renamed
    public void onInitializeAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        onPopulateEventForHost(accessibilityEvent);
    }

    private android.view.accessibility.AccessibilityEvent createEventForChild(int i_renamed, int i2) {
        android.view.accessibility.AccessibilityEvent accessibilityEventObtain = android.view.accessibility.AccessibilityEvent.obtain(i2);
        androidx.core.h_renamed.a_renamed.d_renamed dVarObtainAccessibilityNodeInfo = obtainAccessibilityNodeInfo(i_renamed);
        accessibilityEventObtain.getText().add(dVarObtainAccessibilityNodeInfo.q_renamed());
        accessibilityEventObtain.setContentDescription(dVarObtainAccessibilityNodeInfo.r_renamed());
        accessibilityEventObtain.setScrollable(dVarObtainAccessibilityNodeInfo.n_renamed());
        accessibilityEventObtain.setPassword(dVarObtainAccessibilityNodeInfo.m_renamed());
        accessibilityEventObtain.setEnabled(dVarObtainAccessibilityNodeInfo.l_renamed());
        accessibilityEventObtain.setChecked(dVarObtainAccessibilityNodeInfo.f_renamed());
        onPopulateEventForVirtualView(i_renamed, accessibilityEventObtain);
        if (accessibilityEventObtain.getText().isEmpty() && accessibilityEventObtain.getContentDescription() == null) {
            throw new java.lang.RuntimeException("Callbacks must add text or a_renamed content description in_renamed populateEventForVirtualViewId()");
        }
        accessibilityEventObtain.setClassName(dVarObtainAccessibilityNodeInfo.p_renamed());
        androidx.core.h_renamed.a_renamed.f_renamed.a_renamed(accessibilityEventObtain, this.mHost, i_renamed);
        accessibilityEventObtain.setPackageName(this.mHost.getContext().getPackageName());
        return accessibilityEventObtain;
    }

    androidx.core.h_renamed.a_renamed.d_renamed obtainAccessibilityNodeInfo(int i_renamed) {
        if (i_renamed == -1) {
            return createNodeForHost();
        }
        return createNodeForChild(i_renamed);
    }

    private androidx.core.h_renamed.a_renamed.d_renamed createNodeForHost() {
        androidx.core.h_renamed.a_renamed.d_renamed dVarA = androidx.core.h_renamed.a_renamed.d_renamed.a_renamed(this.mHost);
        androidx.core.h_renamed.v_renamed.a_renamed(this.mHost, dVarA);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        getVisibleVirtualViews(arrayList);
        if (dVarA.c_renamed() > 0 && arrayList.size() > 0) {
            throw new java.lang.RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            dVarA.b_renamed(this.mHost, ((java.lang.Integer) arrayList.get(i_renamed)).intValue());
        }
        return dVarA;
    }

    @Override // androidx.core.h_renamed.a_renamed
    public void onInitializeAccessibilityNodeInfo(android.view.View view, androidx.core.h_renamed.a_renamed.d_renamed dVar) {
        super.onInitializeAccessibilityNodeInfo(view, dVar);
        onPopulateNodeForHost(dVar);
    }

    private androidx.core.h_renamed.a_renamed.d_renamed createNodeForChild(int i_renamed) {
        androidx.core.h_renamed.a_renamed.d_renamed dVarB = androidx.core.h_renamed.a_renamed.d_renamed.b_renamed();
        dVarB.h_renamed(true);
        dVarB.c_renamed(true);
        dVarB.b_renamed(DEFAULT_CLASS_NAME);
        dVarB.b_renamed(INVALID_PARENT_BOUNDS);
        dVarB.d_renamed(INVALID_PARENT_BOUNDS);
        dVarB.b_renamed(this.mHost);
        onPopulateNodeForVirtualView(i_renamed, dVarB);
        if (dVarB.q_renamed() == null && dVarB.r_renamed() == null) {
            throw new java.lang.RuntimeException("Callbacks must add text or a_renamed content description in_renamed populateNodeForVirtualViewId()");
        }
        dVarB.a_renamed(this.mTempParentRect);
        if (this.mTempParentRect.equals(INVALID_PARENT_BOUNDS)) {
            throw new java.lang.RuntimeException("Callbacks must set parent bounds in_renamed populateNodeForVirtualViewId()");
        }
        int iD = dVarB.d_renamed();
        if ((iD & 64) != 0) {
            throw new java.lang.RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in_renamed populateNodeForVirtualViewId()");
        }
        if ((iD & 128) != 0) {
            throw new java.lang.RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in_renamed populateNodeForVirtualViewId()");
        }
        dVarB.a_renamed((java.lang.CharSequence) this.mHost.getContext().getPackageName());
        dVarB.a_renamed(this.mHost, i_renamed);
        if (this.mAccessibilityFocusedVirtualViewId == i_renamed) {
            dVarB.f_renamed(true);
            dVarB.a_renamed(128);
        } else {
            dVarB.f_renamed(false);
            dVarB.a_renamed(64);
        }
        boolean z_renamed = this.mKeyboardFocusedVirtualViewId == i_renamed;
        if (z_renamed) {
            dVarB.a_renamed(2);
        } else if (dVarB.g_renamed()) {
            dVarB.a_renamed(1);
        }
        dVarB.d_renamed(z_renamed);
        this.mHost.getLocationOnScreen(this.mTempGlobalRect);
        dVarB.c_renamed(this.mTempScreenRect);
        if (this.mTempScreenRect.equals(INVALID_PARENT_BOUNDS)) {
            dVarB.a_renamed(this.mTempScreenRect);
            if (dVarB.f959a != -1) {
                androidx.core.h_renamed.a_renamed.d_renamed dVarB2 = androidx.core.h_renamed.a_renamed.d_renamed.b_renamed();
                for (int i2 = dVarB.f959a; i2 != -1; i2 = dVarB2.f959a) {
                    dVarB2.c_renamed(this.mHost, -1);
                    dVarB2.b_renamed(INVALID_PARENT_BOUNDS);
                    onPopulateNodeForVirtualView(i2, dVarB2);
                    dVarB2.a_renamed(this.mTempParentRect);
                    this.mTempScreenRect.offset(this.mTempParentRect.left, this.mTempParentRect.top);
                }
                dVarB2.s_renamed();
            }
            this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
        }
        if (this.mHost.getLocalVisibleRect(this.mTempVisibleRect)) {
            this.mTempVisibleRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
            if (this.mTempScreenRect.intersect(this.mTempVisibleRect)) {
                dVarB.d_renamed(this.mTempScreenRect);
                if (isVisibleToUser(this.mTempScreenRect)) {
                    dVarB.e_renamed(true);
                }
            }
        }
        return dVarB;
    }

    boolean performAction(int i_renamed, int i2, android.os.Bundle bundle) {
        if (i_renamed == -1) {
            return performActionForHost(i2, bundle);
        }
        return performActionForChild(i_renamed, i2, bundle);
    }

    private boolean performActionForHost(int i_renamed, android.os.Bundle bundle) {
        return androidx.core.h_renamed.v_renamed.a_renamed(this.mHost, i_renamed, bundle);
    }

    private boolean performActionForChild(int i_renamed, int i2, android.os.Bundle bundle) {
        if (i2 == 1) {
            return requestKeyboardFocusForVirtualView(i_renamed);
        }
        if (i2 == 2) {
            return clearKeyboardFocusForVirtualView(i_renamed);
        }
        if (i2 == 64) {
            return requestAccessibilityFocus(i_renamed);
        }
        if (i2 == 128) {
            return clearAccessibilityFocus(i_renamed);
        }
        return onPerformActionForVirtualView(i_renamed, i2, bundle);
    }

    private boolean isVisibleToUser(android.graphics.Rect rect) {
        if (rect == null || rect.isEmpty() || this.mHost.getWindowVisibility() != 0) {
            return false;
        }
        java.lang.Object parent = this.mHost.getParent();
        while (parent instanceof android.view.View) {
            android.view.View view = (android.view.View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        return parent != null;
    }

    private boolean requestAccessibilityFocus(int i_renamed) {
        int i2;
        if (!this.mManager.isEnabled() || !this.mManager.isTouchExplorationEnabled() || (i2 = this.mAccessibilityFocusedVirtualViewId) == i_renamed) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            clearAccessibilityFocus(i2);
        }
        this.mAccessibilityFocusedVirtualViewId = i_renamed;
        this.mHost.invalidate();
        sendEventForVirtualView(i_renamed, 32768);
        return true;
    }

    private boolean clearAccessibilityFocus(int i_renamed) {
        if (this.mAccessibilityFocusedVirtualViewId != i_renamed) {
            return false;
        }
        this.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
        this.mHost.invalidate();
        sendEventForVirtualView(i_renamed, 65536);
        return true;
    }

    public final boolean requestKeyboardFocusForVirtualView(int i_renamed) {
        int i2;
        if ((!this.mHost.isFocused() && !this.mHost.requestFocus()) || (i2 = this.mKeyboardFocusedVirtualViewId) == i_renamed) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i2);
        }
        this.mKeyboardFocusedVirtualViewId = i_renamed;
        onVirtualViewKeyboardFocusChanged(i_renamed, true);
        sendEventForVirtualView(i_renamed, 8);
        return true;
    }

    public final boolean clearKeyboardFocusForVirtualView(int i_renamed) {
        if (this.mKeyboardFocusedVirtualViewId != i_renamed) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
        onVirtualViewKeyboardFocusChanged(i_renamed, false);
        sendEventForVirtualView(i_renamed, 8);
        return true;
    }

    /* compiled from: ExploreByTouchHelper.java */
    /* renamed from: androidx.customview.a_renamed.a_renamed$a_renamed, reason: collision with other inner class name */
    private class ExploreByTouchHelper_2 extends androidx.core.h_renamed.a_renamed.e_renamed {
        ExploreByTouchHelper_2() {
        }

        @Override // androidx.core.h_renamed.a_renamed.e_renamed
        public androidx.core.h_renamed.a_renamed.d_renamed a_renamed(int i_renamed) {
            return androidx.core.h_renamed.a_renamed.d_renamed.a_renamed(androidx.customview.a_renamed.a_renamed.this.obtainAccessibilityNodeInfo(i_renamed));
        }

        @Override // androidx.core.h_renamed.a_renamed.e_renamed
        public boolean a_renamed(int i_renamed, int i2, android.os.Bundle bundle) {
            return androidx.customview.a_renamed.a_renamed.this.performAction(i_renamed, i2, bundle);
        }

        @Override // androidx.core.h_renamed.a_renamed.e_renamed
        public androidx.core.h_renamed.a_renamed.d_renamed b_renamed(int i_renamed) {
            int i2 = i_renamed == 2 ? androidx.customview.a_renamed.a_renamed.this.mAccessibilityFocusedVirtualViewId : androidx.customview.a_renamed.a_renamed.this.mKeyboardFocusedVirtualViewId;
            if (i2 == Integer.MIN_VALUE) {
                return null;
            }
            return a_renamed(i2);
        }
    }
}
