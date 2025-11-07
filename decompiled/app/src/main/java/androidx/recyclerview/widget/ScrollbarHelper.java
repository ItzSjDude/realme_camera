package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: ScrollbarHelper.java */
/* renamed from: androidx.recyclerview.widget.q */
/* loaded from: classes.dex */
class ScrollbarHelper {
    /* renamed from: PlatformImplementations.kt_3 */
    static int m4526a(RecyclerView.C0704t c0704t, OrientationHelper abstractC0727n, View view, View view2, RecyclerView.AbstractC0693i abstractC0693i, boolean z, boolean z2) {
        int iMax;
        if (abstractC0693i.getChildCount() == 0 || c0704t.m4230e() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMin = Math.min(abstractC0693i.getPosition(view), abstractC0693i.getPosition(view2));
        int iMax2 = Math.max(abstractC0693i.getPosition(view), abstractC0693i.getPosition(view2));
        if (z2) {
            iMax = Math.max(0, (c0704t.m4230e() - iMax2) - 1);
        } else {
            iMax = Math.max(0, iMin);
        }
        if (!z) {
            return iMax;
        }
        return Math.round((iMax * (Math.abs(abstractC0727n.mo4501b(view2) - abstractC0727n.mo4498a(view)) / (Math.abs(abstractC0693i.getPosition(view) - abstractC0693i.getPosition(view2)) + 1))) + (abstractC0727n.mo4505d() - abstractC0727n.mo4498a(view)));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    static int m4525a(RecyclerView.C0704t c0704t, OrientationHelper abstractC0727n, View view, View view2, RecyclerView.AbstractC0693i abstractC0693i, boolean z) {
        if (abstractC0693i.getChildCount() == 0 || c0704t.m4230e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(abstractC0693i.getPosition(view) - abstractC0693i.getPosition(view2)) + 1;
        }
        return Math.min(abstractC0727n.mo4511g(), abstractC0727n.mo4501b(view2) - abstractC0727n.mo4498a(view));
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    static int m4527b(RecyclerView.C0704t c0704t, OrientationHelper abstractC0727n, View view, View view2, RecyclerView.AbstractC0693i abstractC0693i, boolean z) {
        if (abstractC0693i.getChildCount() == 0 || c0704t.m4230e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return c0704t.m4230e();
        }
        return (int) (((abstractC0727n.mo4501b(view2) - abstractC0727n.mo4498a(view)) / (Math.abs(abstractC0693i.getPosition(view) - abstractC0693i.getPosition(view2)) + 1)) * c0704t.m4230e());
    }
}
