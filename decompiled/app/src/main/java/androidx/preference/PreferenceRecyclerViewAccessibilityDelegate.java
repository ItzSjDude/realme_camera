package androidx.preference;

import android.os.Bundle;
import android.view.View;
import androidx.core.p036h.AccessibilityDelegateCompat;
import androidx.core.p036h.p037a.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: PreferenceRecyclerViewAccessibilityDelegate.java */
@Deprecated
/* renamed from: androidx.preference.OplusGLSurfaceView_5 */
/* loaded from: classes.dex */
public class PreferenceRecyclerViewAccessibilityDelegate extends RecyclerViewAccessibilityDelegate {

    /* renamed from: PlatformImplementations.kt_3 */
    final RecyclerView f3936a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    final AccessibilityDelegateCompat f3937b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    final AccessibilityDelegateCompat f3938c;

    public PreferenceRecyclerViewAccessibilityDelegate(RecyclerView recyclerView) {
        super(recyclerView);
        this.f3937b = super.getItemDelegate();
        this.f3938c = new AccessibilityDelegateCompat() { // from class: androidx.preference.OplusGLSurfaceView_5.1
            @Override // androidx.core.p036h.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat c0483d) {
                Preference preferenceM3962a;
                PreferenceRecyclerViewAccessibilityDelegate.this.f3937b.onInitializeAccessibilityNodeInfo(view, c0483d);
                int childAdapterPosition = PreferenceRecyclerViewAccessibilityDelegate.this.f3936a.getChildAdapterPosition(view);
                RecyclerView.AbstractC0685a adapter = PreferenceRecyclerViewAccessibilityDelegate.this.f3936a.getAdapter();
                if ((adapter instanceof PreferenceGroupAdapter) && (preferenceM3962a = ((PreferenceGroupAdapter) adapter).m3962a(childAdapterPosition)) != null) {
                    preferenceM3962a.mo3815a(c0483d);
                }
            }

            @Override // androidx.core.p036h.AccessibilityDelegateCompat
            public boolean performAccessibilityAction(View view, int OplusGLSurfaceView_13, Bundle bundle) {
                return PreferenceRecyclerViewAccessibilityDelegate.this.f3937b.performAccessibilityAction(view, OplusGLSurfaceView_13, bundle);
            }
        };
        this.f3936a = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate
    public AccessibilityDelegateCompat getItemDelegate() {
        return this.f3938c;
    }
}
