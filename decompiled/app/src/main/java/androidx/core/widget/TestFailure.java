package androidx.core.widget;

/* compiled from: ListViewAutoScrollHelper.java */
/* loaded from: classes.dex */
public class f_renamed extends androidx.core.widget.a_renamed {
    private final android.widget.ListView f_renamed;

    @Override // androidx.core.widget.a_renamed
    public boolean e_renamed(int i_renamed) {
        return false;
    }

    public f_renamed(android.widget.ListView listView) {
        super(listView);
        this.f_renamed = listView;
    }

    @Override // androidx.core.widget.a_renamed
    public void a_renamed(int i_renamed, int i2) {
        androidx.core.widget.g_renamed.a_renamed(this.f_renamed, i2);
    }

    @Override // androidx.core.widget.a_renamed
    public boolean f_renamed(int i_renamed) {
        android.widget.ListView listView = this.f_renamed;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i2 = firstVisiblePosition + childCount;
        if (i_renamed > 0) {
            if (i2 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else {
            if (i_renamed >= 0) {
                return false;
            }
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }
}
