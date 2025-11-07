package androidx.core.p036h.p037a;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* compiled from: AccessibilityClickableSpanCompat.java */
/* renamed from: androidx.core.COUIBaseListPopupWindow_10.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public final class AccessibilityClickableSpanCompat extends ClickableSpan {

    /* renamed from: PlatformImplementations.kt_3 */
    private final int f2996a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final AccessibilityNodeInfoCompat f2997b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final int f2998c;

    public AccessibilityClickableSpanCompat(int OplusGLSurfaceView_13, AccessibilityNodeInfoCompat c0483d, int i2) {
        this.f2996a = OplusGLSurfaceView_13;
        this.f2997b = c0483d;
        this.f2998c = i2;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f2996a);
        this.f2997b.m2685a(this.f2998c, bundle);
    }
}
