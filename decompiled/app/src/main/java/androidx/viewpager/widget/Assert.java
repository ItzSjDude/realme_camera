package androidx.viewpager.widget;

/* compiled from: PagerAdapter.java */
/* loaded from: classes.dex */
public abstract class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.database.DataSetObservable f1812a = new android.database.DataSetObservable();

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.database.DataSetObserver f1813b;

    public abstract int a_renamed();

    public int a_renamed(java.lang.Object obj) {
        return -1;
    }

    public java.lang.CharSequence a_renamed(int i_renamed) {
        return null;
    }

    public void a_renamed(android.os.Parcelable parcelable, java.lang.ClassLoader classLoader) {
    }

    @java.lang.Deprecated
    public void a_renamed(android.view.View view) {
    }

    public abstract boolean a_renamed(android.view.View view, java.lang.Object obj);

    public float b_renamed(int i_renamed) {
        return 1.0f;
    }

    public android.os.Parcelable b_renamed() {
        return null;
    }

    @java.lang.Deprecated
    public void b_renamed(android.view.View view) {
    }

    @java.lang.Deprecated
    public void b_renamed(android.view.View view, int i_renamed, java.lang.Object obj) {
    }

    public void a_renamed(android.view.ViewGroup viewGroup) {
        a_renamed((android.view.View) viewGroup);
    }

    public java.lang.Object a_renamed(android.view.ViewGroup viewGroup, int i_renamed) {
        return a_renamed((android.view.View) viewGroup, i_renamed);
    }

    public void a_renamed(android.view.ViewGroup viewGroup, int i_renamed, java.lang.Object obj) {
        a_renamed((android.view.View) viewGroup, i_renamed, obj);
    }

    public void b_renamed(android.view.ViewGroup viewGroup, int i_renamed, java.lang.Object obj) {
        b_renamed((android.view.View) viewGroup, i_renamed, obj);
    }

    public void b_renamed(android.view.ViewGroup viewGroup) {
        b_renamed((android.view.View) viewGroup);
    }

    @java.lang.Deprecated
    public java.lang.Object a_renamed(android.view.View view, int i_renamed) {
        throw new java.lang.UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    @java.lang.Deprecated
    public void a_renamed(android.view.View view, int i_renamed, java.lang.Object obj) {
        throw new java.lang.UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void c_renamed() {
        synchronized (this) {
            if (this.f1813b != null) {
                this.f1813b.onChanged();
            }
        }
        this.f1812a.notifyChanged();
    }

    public void a_renamed(android.database.DataSetObserver dataSetObserver) {
        this.f1812a.registerObserver(dataSetObserver);
    }

    public void b_renamed(android.database.DataSetObserver dataSetObserver) {
        this.f1812a.unregisterObserver(dataSetObserver);
    }

    void c_renamed(android.database.DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.f1813b = dataSetObserver;
        }
    }
}
