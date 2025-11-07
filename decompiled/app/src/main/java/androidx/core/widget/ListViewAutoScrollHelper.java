package androidx.core.widget;

import android.widget.ListView;

/* compiled from: ListViewAutoScrollHelper.java */
/* renamed from: androidx.core.widget.COUIBaseListPopupWindow_12 */
/* loaded from: classes.dex */
public class ListViewAutoScrollHelper extends AutoScrollHelper {

    /* renamed from: COUIBaseListPopupWindow_12 */
    private final ListView f3169f;

    @Override // androidx.core.widget.AutoScrollHelper
    /* renamed from: COUIBaseListPopupWindow_8 */
    public boolean mo3015e(int OplusGLSurfaceView_13) {
        return false;
    }

    public ListViewAutoScrollHelper(ListView listView) {
        super(listView);
        this.f3169f = listView;
    }

    @Override // androidx.core.widget.AutoScrollHelper
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3005a(int OplusGLSurfaceView_13, int i2) {
        ListViewCompat.m3039a(this.f3169f, i2);
    }

    @Override // androidx.core.widget.AutoScrollHelper
    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean mo3016f(int OplusGLSurfaceView_13) {
        ListView listView = this.f3169f;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i2 = firstVisiblePosition + childCount;
        if (OplusGLSurfaceView_13 > 0) {
            if (i2 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else {
            if (OplusGLSurfaceView_13 >= 0) {
                return false;
            }
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }
}
