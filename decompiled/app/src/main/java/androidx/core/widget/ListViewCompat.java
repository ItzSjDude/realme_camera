package androidx.core.widget;

import android.os.Build;
import android.view.View;
import android.widget.ListView;

/* compiled from: ListViewCompat.java */
/* renamed from: androidx.core.widget.COUIBaseListPopupWindow_11 */
/* loaded from: classes.dex */
public final class ListViewCompat {
    /* renamed from: PlatformImplementations.kt_3 */
    public static void m3039a(ListView listView, int OplusGLSurfaceView_13) {
        View childAt;
        if (Build.VERSION.SDK_INT >= 19) {
            listView.scrollListBy(OplusGLSurfaceView_13);
            return;
        }
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        if (firstVisiblePosition == -1 || (childAt = listView.getChildAt(0)) == null) {
            return;
        }
        listView.setSelectionFromTop(firstVisiblePosition, childAt.getTop() - OplusGLSurfaceView_13);
    }
}
