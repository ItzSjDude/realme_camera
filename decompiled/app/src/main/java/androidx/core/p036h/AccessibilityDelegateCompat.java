package androidx.core.p036h;

import android.os.Build;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.R;
import androidx.core.p036h.p037a.AccessibilityNodeInfoCompat;
import androidx.core.p036h.p037a.AccessibilityNodeProviderCompat;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;

/* compiled from: AccessibilityDelegateCompat.java */
/* renamed from: androidx.core.COUIBaseListPopupWindow_10.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public class AccessibilityDelegateCompat {
    private static final View.AccessibilityDelegate DEFAULT_DELEGATE = new View.AccessibilityDelegate();
    private final View.AccessibilityDelegate mBridge;
    private final View.AccessibilityDelegate mOriginalDelegate;

    /* compiled from: AccessibilityDelegateCompat.java */
    /* renamed from: androidx.core.COUIBaseListPopupWindow_10.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    static final class PlatformImplementations.kt_3 extends View.AccessibilityDelegate {

        /* renamed from: PlatformImplementations.kt_3 */
        final AccessibilityDelegateCompat f2995a;

        PlatformImplementations.kt_3(AccessibilityDelegateCompat c0479a) {
            this.f2995a = c0479a;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f2995a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f2995a.onInitializeAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            AccessibilityNodeInfoCompat c0483dM2661a = AccessibilityNodeInfoCompat.m2661a(accessibilityNodeInfo);
            c0483dM2661a.m2719k(ViewCompat.m2829G(view));
            c0483dM2661a.m2723m(ViewCompat.m2831I(view));
            c0483dM2661a.m2711h(ViewCompat.m2830H(view));
            this.f2995a.onInitializeAccessibilityNodeInfo(view, c0483dM2661a);
            c0483dM2661a.m2682a(accessibilityNodeInfo.getText(), view);
            List<AccessibilityNodeInfoCompat.PlatformImplementations.kt_3> actionList = AccessibilityDelegateCompat.getActionList(view);
            for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < actionList.size(); OplusGLSurfaceView_13++) {
                c0483dM2661a.m2679a(actionList.get(OplusGLSurfaceView_13));
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f2995a.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f2995a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int OplusGLSurfaceView_13) {
            this.f2995a.sendAccessibilityEvent(view, OplusGLSurfaceView_13);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f2995a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            AccessibilityNodeProviderCompat accessibilityNodeProvider = this.f2995a.getAccessibilityNodeProvider(view);
            if (accessibilityNodeProvider != null) {
                return (AccessibilityNodeProvider) accessibilityNodeProvider.m2750a();
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int OplusGLSurfaceView_13, Bundle bundle) {
            return this.f2995a.performAccessibilityAction(view, OplusGLSurfaceView_13, bundle);
        }
    }

    public AccessibilityDelegateCompat() {
        this(DEFAULT_DELEGATE);
    }

    public AccessibilityDelegateCompat(View.AccessibilityDelegate accessibilityDelegate) {
        this.mOriginalDelegate = accessibilityDelegate;
        this.mBridge = new PlatformImplementations.kt_3(this);
    }

    View.AccessibilityDelegate getBridge() {
        return this.mBridge;
    }

    public void sendAccessibilityEvent(View view, int OplusGLSurfaceView_13) {
        this.mOriginalDelegate.sendAccessibilityEvent(view, OplusGLSurfaceView_13);
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return this.mOriginalDelegate.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat c0483d) {
        this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, c0483d.m2675a());
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.mOriginalDelegate.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        if (Build.VERSION.SDK_INT < 16 || (accessibilityNodeProvider = this.mOriginalDelegate.getAccessibilityNodeProvider(view)) == null) {
            return null;
        }
        return new AccessibilityNodeProviderCompat(accessibilityNodeProvider);
    }

    public boolean performAccessibilityAction(View view, int OplusGLSurfaceView_13, Bundle bundle) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        List<AccessibilityNodeInfoCompat.PlatformImplementations.kt_3> actionList = getActionList(view);
        boolean zPerformAccessibilityAction = false;
        int i2 = 0;
        while (true) {
            if (i2 >= actionList.size()) {
                break;
            }
            AccessibilityNodeInfoCompat.PlatformImplementations.kt_3 aVar = actionList.get(i2);
            if (aVar.m2736a() == OplusGLSurfaceView_13) {
                zPerformAccessibilityAction = aVar.m2738a(view, bundle);
                break;
            }
            i2++;
        }
        if (!zPerformAccessibilityAction && Build.VERSION.SDK_INT >= 16) {
            zPerformAccessibilityAction = this.mOriginalDelegate.performAccessibilityAction(view, OplusGLSurfaceView_13, bundle);
        }
        return (zPerformAccessibilityAction || OplusGLSurfaceView_13 != R.id_renamed.accessibility_action_clickable_span) ? zPerformAccessibilityAction : performClickableSpanAction(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    private boolean performClickableSpanAction(int OplusGLSurfaceView_13, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(R.id_renamed.tag_accessibility_clickable_spans);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(OplusGLSurfaceView_13)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (!isSpanStillValid(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    private boolean isSpanStillValid(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] clickableSpanArrM2671d = AccessibilityNodeInfoCompat.m2671d(view.createAccessibilityNodeInfo().getText());
            for (int OplusGLSurfaceView_13 = 0; clickableSpanArrM2671d != null && OplusGLSurfaceView_13 < clickableSpanArrM2671d.length; OplusGLSurfaceView_13++) {
                if (clickableSpan.equals(clickableSpanArrM2671d[OplusGLSurfaceView_13])) {
                    return true;
                }
            }
        }
        return false;
    }

    static List<AccessibilityNodeInfoCompat.PlatformImplementations.kt_3> getActionList(View view) {
        List<AccessibilityNodeInfoCompat.PlatformImplementations.kt_3> list = (List) view.getTag(R.id_renamed.tag_accessibility_actions);
        return list == null ? Collections.emptyList() : list;
    }
}
