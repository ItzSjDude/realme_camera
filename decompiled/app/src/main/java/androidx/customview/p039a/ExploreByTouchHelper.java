package androidx.customview.p039a;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.collection.SparseArrayCompat;
import androidx.core.p036h.AccessibilityDelegateCompat;
import androidx.core.p036h.ViewCompat;
import androidx.core.p036h.ViewParentCompat;
import androidx.core.p036h.p037a.AccessibilityEventCompat;
import androidx.core.p036h.p037a.AccessibilityNodeInfoCompat;
import androidx.core.p036h.p037a.AccessibilityNodeProviderCompat;
import androidx.core.p036h.p037a.AccessibilityRecordCompat;
import androidx.customview.p039a.FocusStrategy;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ExploreByTouchHelper.java */
/* renamed from: androidx.customview.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat {
    private static final String DEFAULT_CLASS_NAME = "android.view.View";
    public static final int HOST_ID = -1;
    public static final int INVALID_ID = Integer.MIN_VALUE;
    private static final Rect INVALID_PARENT_BOUNDS = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    private static final FocusStrategy.PlatformImplementations.kt_3<AccessibilityNodeInfoCompat> NODE_ADAPTER = new FocusStrategy.PlatformImplementations.kt_3<AccessibilityNodeInfoCompat>() { // from class: androidx.customview.PlatformImplementations.kt_3.PlatformImplementations.kt_3.1
        @Override // androidx.customview.p039a.FocusStrategy.PlatformImplementations.kt_3
        /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public void mo3068a(AccessibilityNodeInfoCompat c0483d, Rect rect) {
            c0483d.m2677a(rect);
        }
    };
    private static final FocusStrategy.IntrinsicsJvm.kt_4<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat> SPARSE_VALUES_ADAPTER = new FocusStrategy.IntrinsicsJvm.kt_4<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat>() { // from class: androidx.customview.PlatformImplementations.kt_3.PlatformImplementations.kt_3.2
        @Override // androidx.customview.p039a.FocusStrategy.IntrinsicsJvm.kt_4
        /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public AccessibilityNodeInfoCompat mo3070a(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat, int OplusGLSurfaceView_13) {
            return sparseArrayCompat.valueAt(OplusGLSurfaceView_13);
        }

        @Override // androidx.customview.p039a.FocusStrategy.IntrinsicsJvm.kt_4
        /* renamed from: PlatformImplementations.kt_3, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public int mo3069a(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat) {
            return sparseArrayCompat.size();
        }
    };
    private final View mHost;
    private final AccessibilityManager mManager;
    private PlatformImplementations.kt_3 mNodeProvider;
    private final Rect mTempScreenRect = new Rect();
    private final Rect mTempParentRect = new Rect();
    private final Rect mTempVisibleRect = new Rect();
    private final int[] mTempGlobalRect = new int[2];
    int mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
    int mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
    private int mHoveredVirtualViewId = Integer.MIN_VALUE;

    private static int keyToDirection(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 19) {
            return 33;
        }
        if (OplusGLSurfaceView_13 != 21) {
            return OplusGLSurfaceView_13 != 22 ? 130 : 66;
        }
        return 17;
    }

    protected abstract int getVirtualViewAt(float COUIBaseListPopupWindow_12, float f2);

    protected abstract void getVisibleVirtualViews(List<Integer> list);

    protected abstract boolean onPerformActionForVirtualView(int OplusGLSurfaceView_13, int i2, Bundle bundle);

    protected void onPopulateEventForHost(AccessibilityEvent accessibilityEvent) {
    }

    protected void onPopulateEventForVirtualView(int OplusGLSurfaceView_13, AccessibilityEvent accessibilityEvent) {
    }

    protected void onPopulateNodeForHost(AccessibilityNodeInfoCompat c0483d) {
    }

    protected abstract void onPopulateNodeForVirtualView(int OplusGLSurfaceView_13, AccessibilityNodeInfoCompat c0483d);

    protected void onVirtualViewKeyboardFocusChanged(int OplusGLSurfaceView_13, boolean z) {
    }

    public ExploreByTouchHelper(View view) {
        if (view == null) {
            throw new IllegalArgumentException("View may not be null");
        }
        this.mHost = view;
        this.mManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (ViewCompat.m2883f(view) == 0) {
            ViewCompat.m2867b(view, 1);
        }
    }

    @Override // androidx.core.p036h.AccessibilityDelegateCompat
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        if (this.mNodeProvider == null) {
            this.mNodeProvider = new PlatformImplementations.kt_3();
        }
        return this.mNodeProvider;
    }

    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
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

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int OplusGLSurfaceView_13 = 0;
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
                        boolean z = false;
                        while (OplusGLSurfaceView_13 < repeatCount && moveFocus(iKeyToDirection, null)) {
                            OplusGLSurfaceView_13++;
                            z = true;
                        }
                        return z;
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

    public final void onFocusChanged(boolean z, int OplusGLSurfaceView_13, Rect rect) {
        int i2 = this.mKeyboardFocusedVirtualViewId;
        if (i2 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i2);
        }
        if (z) {
            moveFocus(OplusGLSurfaceView_13, rect);
        }
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.mAccessibilityFocusedVirtualViewId;
    }

    public final int getKeyboardFocusedVirtualViewId() {
        return this.mKeyboardFocusedVirtualViewId;
    }

    private void getBoundsInParent(int OplusGLSurfaceView_13, Rect rect) {
        obtainAccessibilityNodeInfo(OplusGLSurfaceView_13).m2677a(rect);
    }

    private boolean moveFocus(int OplusGLSurfaceView_13, Rect rect) {
        AccessibilityNodeInfoCompat c0483d;
        SparseArrayCompat<AccessibilityNodeInfoCompat> allNodes = getAllNodes();
        int i2 = this.mKeyboardFocusedVirtualViewId;
        AccessibilityNodeInfoCompat c0483d2 = i2 == Integer.MIN_VALUE ? null : allNodes.get(i2);
        if (OplusGLSurfaceView_13 == 1 || OplusGLSurfaceView_13 == 2) {
            c0483d = (AccessibilityNodeInfoCompat) FocusStrategy.m3072a(allNodes, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, c0483d2, OplusGLSurfaceView_13, ViewCompat.m2885g(this.mHost) == 1, false);
        } else if (OplusGLSurfaceView_13 == 17 || OplusGLSurfaceView_13 == 33 || OplusGLSurfaceView_13 == 66 || OplusGLSurfaceView_13 == 130) {
            Rect rect2 = new Rect();
            int i3 = this.mKeyboardFocusedVirtualViewId;
            if (i3 != Integer.MIN_VALUE) {
                getBoundsInParent(i3, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                guessPreviouslyFocusedRect(this.mHost, OplusGLSurfaceView_13, rect2);
            }
            c0483d = (AccessibilityNodeInfoCompat) FocusStrategy.m3073a(allNodes, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, c0483d2, rect2, OplusGLSurfaceView_13);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return requestKeyboardFocusForVirtualView(c0483d != null ? allNodes.keyAt(allNodes.indexOfValue(c0483d)) : Integer.MIN_VALUE);
    }

    private SparseArrayCompat<AccessibilityNodeInfoCompat> getAllNodes() {
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat = new SparseArrayCompat<>();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < arrayList.size(); OplusGLSurfaceView_13++) {
            sparseArrayCompat.put(OplusGLSurfaceView_13, createNodeForChild(OplusGLSurfaceView_13));
        }
        return sparseArrayCompat;
    }

    private static Rect guessPreviouslyFocusedRect(View view, int OplusGLSurfaceView_13, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (OplusGLSurfaceView_13 == 17) {
            rect.set(width, 0, width, height);
        } else if (OplusGLSurfaceView_13 == 33) {
            rect.set(0, height, width, height);
        } else if (OplusGLSurfaceView_13 == 66) {
            rect.set(-1, 0, -1, height);
        } else if (OplusGLSurfaceView_13 == 130) {
            rect.set(0, -1, width, -1);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return rect;
    }

    private boolean clickKeyboardFocusedVirtualView() {
        int OplusGLSurfaceView_13 = this.mKeyboardFocusedVirtualViewId;
        return OplusGLSurfaceView_13 != Integer.MIN_VALUE && onPerformActionForVirtualView(OplusGLSurfaceView_13, 16, null);
    }

    public final boolean sendEventForVirtualView(int OplusGLSurfaceView_13, int i2) {
        ViewParent parent;
        if (OplusGLSurfaceView_13 == Integer.MIN_VALUE || !this.mManager.isEnabled() || (parent = this.mHost.getParent()) == null) {
            return false;
        }
        return ViewParentCompat.m2942a(parent, this.mHost, createEvent(OplusGLSurfaceView_13, i2));
    }

    public final void invalidateRoot() {
        invalidateVirtualView(-1, 1);
    }

    public final void invalidateVirtualView(int OplusGLSurfaceView_13) {
        invalidateVirtualView(OplusGLSurfaceView_13, 0);
    }

    public final void invalidateVirtualView(int OplusGLSurfaceView_13, int i2) {
        ViewParent parent;
        if (OplusGLSurfaceView_13 == Integer.MIN_VALUE || !this.mManager.isEnabled() || (parent = this.mHost.getParent()) == null) {
            return;
        }
        AccessibilityEvent accessibilityEventCreateEvent = createEvent(OplusGLSurfaceView_13, 2048);
        AccessibilityEventCompat.m2657a(accessibilityEventCreateEvent, i2);
        ViewParentCompat.m2942a(parent, this.mHost, accessibilityEventCreateEvent);
    }

    @Deprecated
    public int getFocusedVirtualView() {
        return getAccessibilityFocusedVirtualViewId();
    }

    private void updateHoveredVirtualView(int OplusGLSurfaceView_13) {
        int i2 = this.mHoveredVirtualViewId;
        if (i2 == OplusGLSurfaceView_13) {
            return;
        }
        this.mHoveredVirtualViewId = OplusGLSurfaceView_13;
        sendEventForVirtualView(OplusGLSurfaceView_13, 128);
        sendEventForVirtualView(i2, 256);
    }

    private AccessibilityEvent createEvent(int OplusGLSurfaceView_13, int i2) {
        if (OplusGLSurfaceView_13 == -1) {
            return createEventForHost(i2);
        }
        return createEventForChild(OplusGLSurfaceView_13, i2);
    }

    private AccessibilityEvent createEventForHost(int OplusGLSurfaceView_13) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(OplusGLSurfaceView_13);
        this.mHost.onInitializeAccessibilityEvent(accessibilityEventObtain);
        return accessibilityEventObtain;
    }

    @Override // androidx.core.p036h.AccessibilityDelegateCompat
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        onPopulateEventForHost(accessibilityEvent);
    }

    private AccessibilityEvent createEventForChild(int OplusGLSurfaceView_13, int i2) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i2);
        AccessibilityNodeInfoCompat c0483dObtainAccessibilityNodeInfo = obtainAccessibilityNodeInfo(OplusGLSurfaceView_13);
        accessibilityEventObtain.getText().add(c0483dObtainAccessibilityNodeInfo.m2728q());
        accessibilityEventObtain.setContentDescription(c0483dObtainAccessibilityNodeInfo.m2729r());
        accessibilityEventObtain.setScrollable(c0483dObtainAccessibilityNodeInfo.m2725n());
        accessibilityEventObtain.setPassword(c0483dObtainAccessibilityNodeInfo.m2724m());
        accessibilityEventObtain.setEnabled(c0483dObtainAccessibilityNodeInfo.m2722l());
        accessibilityEventObtain.setChecked(c0483dObtainAccessibilityNodeInfo.m2707f());
        onPopulateEventForVirtualView(OplusGLSurfaceView_13, accessibilityEventObtain);
        if (accessibilityEventObtain.getText().isEmpty() && accessibilityEventObtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or PlatformImplementations.kt_3 content description in populateEventForVirtualViewId()");
        }
        accessibilityEventObtain.setClassName(c0483dObtainAccessibilityNodeInfo.m2727p());
        AccessibilityRecordCompat.m2755a(accessibilityEventObtain, this.mHost, OplusGLSurfaceView_13);
        accessibilityEventObtain.setPackageName(this.mHost.getContext().getPackageName());
        return accessibilityEventObtain;
    }

    AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == -1) {
            return createNodeForHost();
        }
        return createNodeForChild(OplusGLSurfaceView_13);
    }

    private AccessibilityNodeInfoCompat createNodeForHost() {
        AccessibilityNodeInfoCompat c0483dM2660a = AccessibilityNodeInfoCompat.m2660a(this.mHost);
        ViewCompat.m2853a(this.mHost, c0483dM2660a);
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        if (c0483dM2660a.m2694c() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < size; OplusGLSurfaceView_13++) {
            c0483dM2660a.m2689b(this.mHost, ((Integer) arrayList.get(OplusGLSurfaceView_13)).intValue());
        }
        return c0483dM2660a;
    }

    @Override // androidx.core.p036h.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat c0483d) {
        super.onInitializeAccessibilityNodeInfo(view, c0483d);
        onPopulateNodeForHost(c0483d);
    }

    private AccessibilityNodeInfoCompat createNodeForChild(int OplusGLSurfaceView_13) {
        AccessibilityNodeInfoCompat c0483dM2666b = AccessibilityNodeInfoCompat.m2666b();
        c0483dM2666b.m2712h(true);
        c0483dM2666b.m2698c(true);
        c0483dM2666b.m2690b(DEFAULT_CLASS_NAME);
        c0483dM2666b.m2687b(INVALID_PARENT_BOUNDS);
        c0483dM2666b.m2700d(INVALID_PARENT_BOUNDS);
        c0483dM2666b.m2688b(this.mHost);
        onPopulateNodeForVirtualView(OplusGLSurfaceView_13, c0483dM2666b);
        if (c0483dM2666b.m2728q() == null && c0483dM2666b.m2729r() == null) {
            throw new RuntimeException("Callbacks must add text or PlatformImplementations.kt_3 content description in populateNodeForVirtualViewId()");
        }
        c0483dM2666b.m2677a(this.mTempParentRect);
        if (this.mTempParentRect.equals(INVALID_PARENT_BOUNDS)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int iM2699d = c0483dM2666b.m2699d();
        if ((iM2699d & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((iM2699d & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        c0483dM2666b.m2681a((CharSequence) this.mHost.getContext().getPackageName());
        c0483dM2666b.m2678a(this.mHost, OplusGLSurfaceView_13);
        if (this.mAccessibilityFocusedVirtualViewId == OplusGLSurfaceView_13) {
            c0483dM2666b.m2706f(true);
            c0483dM2666b.m2676a(128);
        } else {
            c0483dM2666b.m2706f(false);
            c0483dM2666b.m2676a(64);
        }
        boolean z = this.mKeyboardFocusedVirtualViewId == OplusGLSurfaceView_13;
        if (z) {
            c0483dM2666b.m2676a(2);
        } else if (c0483dM2666b.m2710g()) {
            c0483dM2666b.m2676a(1);
        }
        c0483dM2666b.m2701d(z);
        this.mHost.getLocationOnScreen(this.mTempGlobalRect);
        c0483dM2666b.m2695c(this.mTempScreenRect);
        if (this.mTempScreenRect.equals(INVALID_PARENT_BOUNDS)) {
            c0483dM2666b.m2677a(this.mTempScreenRect);
            if (c0483dM2666b.f3000a != -1) {
                AccessibilityNodeInfoCompat c0483dM2666b2 = AccessibilityNodeInfoCompat.m2666b();
                for (int i2 = c0483dM2666b.f3000a; i2 != -1; i2 = c0483dM2666b2.f3000a) {
                    c0483dM2666b2.m2696c(this.mHost, -1);
                    c0483dM2666b2.m2687b(INVALID_PARENT_BOUNDS);
                    onPopulateNodeForVirtualView(i2, c0483dM2666b2);
                    c0483dM2666b2.m2677a(this.mTempParentRect);
                    this.mTempScreenRect.offset(this.mTempParentRect.left, this.mTempParentRect.top);
                }
                c0483dM2666b2.m2730s();
            }
            this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
        }
        if (this.mHost.getLocalVisibleRect(this.mTempVisibleRect)) {
            this.mTempVisibleRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
            if (this.mTempScreenRect.intersect(this.mTempVisibleRect)) {
                c0483dM2666b.m2700d(this.mTempScreenRect);
                if (isVisibleToUser(this.mTempScreenRect)) {
                    c0483dM2666b.m2703e(true);
                }
            }
        }
        return c0483dM2666b;
    }

    boolean performAction(int OplusGLSurfaceView_13, int i2, Bundle bundle) {
        if (OplusGLSurfaceView_13 == -1) {
            return performActionForHost(i2, bundle);
        }
        return performActionForChild(OplusGLSurfaceView_13, i2, bundle);
    }

    private boolean performActionForHost(int OplusGLSurfaceView_13, Bundle bundle) {
        return ViewCompat.m2861a(this.mHost, OplusGLSurfaceView_13, bundle);
    }

    private boolean performActionForChild(int OplusGLSurfaceView_13, int i2, Bundle bundle) {
        if (i2 == 1) {
            return requestKeyboardFocusForVirtualView(OplusGLSurfaceView_13);
        }
        if (i2 == 2) {
            return clearKeyboardFocusForVirtualView(OplusGLSurfaceView_13);
        }
        if (i2 == 64) {
            return requestAccessibilityFocus(OplusGLSurfaceView_13);
        }
        if (i2 == 128) {
            return clearAccessibilityFocus(OplusGLSurfaceView_13);
        }
        return onPerformActionForVirtualView(OplusGLSurfaceView_13, i2, bundle);
    }

    private boolean isVisibleToUser(Rect rect) {
        if (rect == null || rect.isEmpty() || this.mHost.getWindowVisibility() != 0) {
            return false;
        }
        Object parent = this.mHost.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        return parent != null;
    }

    private boolean requestAccessibilityFocus(int OplusGLSurfaceView_13) {
        int i2;
        if (!this.mManager.isEnabled() || !this.mManager.isTouchExplorationEnabled() || (i2 = this.mAccessibilityFocusedVirtualViewId) == OplusGLSurfaceView_13) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            clearAccessibilityFocus(i2);
        }
        this.mAccessibilityFocusedVirtualViewId = OplusGLSurfaceView_13;
        this.mHost.invalidate();
        sendEventForVirtualView(OplusGLSurfaceView_13, 32768);
        return true;
    }

    private boolean clearAccessibilityFocus(int OplusGLSurfaceView_13) {
        if (this.mAccessibilityFocusedVirtualViewId != OplusGLSurfaceView_13) {
            return false;
        }
        this.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
        this.mHost.invalidate();
        sendEventForVirtualView(OplusGLSurfaceView_13, 65536);
        return true;
    }

    public final boolean requestKeyboardFocusForVirtualView(int OplusGLSurfaceView_13) {
        int i2;
        if ((!this.mHost.isFocused() && !this.mHost.requestFocus()) || (i2 = this.mKeyboardFocusedVirtualViewId) == OplusGLSurfaceView_13) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i2);
        }
        this.mKeyboardFocusedVirtualViewId = OplusGLSurfaceView_13;
        onVirtualViewKeyboardFocusChanged(OplusGLSurfaceView_13, true);
        sendEventForVirtualView(OplusGLSurfaceView_13, 8);
        return true;
    }

    public final boolean clearKeyboardFocusForVirtualView(int OplusGLSurfaceView_13) {
        if (this.mKeyboardFocusedVirtualViewId != OplusGLSurfaceView_13) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
        onVirtualViewKeyboardFocusChanged(OplusGLSurfaceView_13, false);
        sendEventForVirtualView(OplusGLSurfaceView_13, 8);
        return true;
    }

    /* compiled from: ExploreByTouchHelper.java */
    /* renamed from: androidx.customview.PlatformImplementations.kt_3.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 extends AccessibilityNodeProviderCompat {
        PlatformImplementations.kt_3() {
        }

        @Override // androidx.core.p036h.p037a.AccessibilityNodeProviderCompat
        /* renamed from: PlatformImplementations.kt_3 */
        public AccessibilityNodeInfoCompat mo2749a(int OplusGLSurfaceView_13) {
            return AccessibilityNodeInfoCompat.m2662a(ExploreByTouchHelper.this.obtainAccessibilityNodeInfo(OplusGLSurfaceView_13));
        }

        @Override // androidx.core.p036h.p037a.AccessibilityNodeProviderCompat
        /* renamed from: PlatformImplementations.kt_3 */
        public boolean mo2752a(int OplusGLSurfaceView_13, int i2, Bundle bundle) {
            return ExploreByTouchHelper.this.performAction(OplusGLSurfaceView_13, i2, bundle);
        }

        @Override // androidx.core.p036h.p037a.AccessibilityNodeProviderCompat
        /* renamed from: IntrinsicsJvm.kt_4 */
        public AccessibilityNodeInfoCompat mo2753b(int OplusGLSurfaceView_13) {
            int i2 = OplusGLSurfaceView_13 == 2 ? ExploreByTouchHelper.this.mAccessibilityFocusedVirtualViewId : ExploreByTouchHelper.this.mKeyboardFocusedVirtualViewId;
            if (i2 == Integer.MIN_VALUE) {
                return null;
            }
            return mo2749a(i2);
        }
    }
}
