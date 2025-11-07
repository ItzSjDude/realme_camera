package androidx.core.p036h.p037a;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AccessibilityNodeProviderCompat.java */
/* renamed from: androidx.core.COUIBaseListPopupWindow_10.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8 */
/* loaded from: classes.dex */
public class AccessibilityNodeProviderCompat {

    /* renamed from: PlatformImplementations.kt_3 */
    private final Object f3047a;

    /* renamed from: PlatformImplementations.kt_3 */
    public AccessibilityNodeInfoCompat mo2749a(int OplusGLSurfaceView_13) {
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public List<AccessibilityNodeInfoCompat> m2751a(String str, int OplusGLSurfaceView_13) {
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean mo2752a(int OplusGLSurfaceView_13, int i2, Bundle bundle) {
        return false;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public AccessibilityNodeInfoCompat mo2753b(int OplusGLSurfaceView_13) {
        return null;
    }

    /* compiled from: AccessibilityNodeProviderCompat.java */
    /* renamed from: androidx.core.COUIBaseListPopupWindow_10.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8$PlatformImplementations.kt_3 */
    static class PlatformImplementations.kt_3 extends AccessibilityNodeProvider {

        /* renamed from: PlatformImplementations.kt_3 */
        final AccessibilityNodeProviderCompat f3048a;

        PlatformImplementations.kt_3(AccessibilityNodeProviderCompat c0484e) {
            this.f3048a = c0484e;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int OplusGLSurfaceView_13) {
            AccessibilityNodeInfoCompat c0483dMo2749a = this.f3048a.mo2749a(OplusGLSurfaceView_13);
            if (c0483dMo2749a == null) {
                return null;
            }
            return c0483dMo2749a.m2675a();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int OplusGLSurfaceView_13) {
            List<AccessibilityNodeInfoCompat> listM2751a = this.f3048a.m2751a(str, OplusGLSurfaceView_13);
            if (listM2751a == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = listM2751a.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(listM2751a.get(i2).m2675a());
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int OplusGLSurfaceView_13, int i2, Bundle bundle) {
            return this.f3048a.mo2752a(OplusGLSurfaceView_13, i2, bundle);
        }
    }

    /* compiled from: AccessibilityNodeProviderCompat.java */
    /* renamed from: androidx.core.COUIBaseListPopupWindow_10.PlatformImplementations.kt_3.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_4 */
    static class IntrinsicsJvm.kt_4 extends PlatformImplementations.kt_3 {
        IntrinsicsJvm.kt_4(AccessibilityNodeProviderCompat c0484e) {
            super(c0484e);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int OplusGLSurfaceView_13) {
            AccessibilityNodeInfoCompat c0483dMo2753b = this.f3048a.mo2753b(OplusGLSurfaceView_13);
            if (c0483dMo2753b == null) {
                return null;
            }
            return c0483dMo2753b.m2675a();
        }
    }

    public AccessibilityNodeProviderCompat() {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f3047a = new IntrinsicsJvm.kt_4(this);
        } else if (Build.VERSION.SDK_INT >= 16) {
            this.f3047a = new PlatformImplementations.kt_3(this);
        } else {
            this.f3047a = null;
        }
    }

    public AccessibilityNodeProviderCompat(Object obj) {
        this.f3047a = obj;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Object m2750a() {
        return this.f3047a;
    }
}
