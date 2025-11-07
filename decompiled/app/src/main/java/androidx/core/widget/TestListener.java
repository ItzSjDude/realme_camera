package androidx.core.widget;

/* compiled from: ListViewCompat.java */
/* loaded from: classes.dex */
public final class g_renamed {
    public static void a_renamed(android.widget.ListView listView, int i_renamed) {
        android.view.View childAt;
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            listView.scrollListBy(i_renamed);
            return;
        }
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        if (firstVisiblePosition == -1 || (childAt = listView.getChildAt(0)) == null) {
            return;
        }
        listView.setSelectionFromTop(firstVisiblePosition, childAt.getTop() - i_renamed);
    }
}
