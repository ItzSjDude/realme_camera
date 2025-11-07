package androidx.viewpager.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: PagerAdapter.java */
/* renamed from: androidx.viewpager.widget.PlatformImplementations.kt_3 */
/* loaded from: classes.dex */
public abstract class PagerAdapter {

    /* renamed from: PlatformImplementations.kt_3 */
    private final DataSetObservable f4863a = new DataSetObservable();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private DataSetObserver f4864b;

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract int mo5000a();

    /* renamed from: PlatformImplementations.kt_3 */
    public int m5001a(Object obj) {
        return -1;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public CharSequence m5002a(int OplusGLSurfaceView_13) {
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m5006a(Parcelable parcelable, ClassLoader classLoader) {
    }

    @Deprecated
    /* renamed from: PlatformImplementations.kt_3 */
    public void m5007a(View view) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public abstract boolean mo5011a(View view, Object obj);

    /* renamed from: IntrinsicsJvm.kt_4 */
    public float m5012b(int OplusGLSurfaceView_13) {
        return 1.0f;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public Parcelable m5013b() {
        return null;
    }

    @Deprecated
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m5015b(View view) {
    }

    @Deprecated
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m5016b(View view, int OplusGLSurfaceView_13, Object obj) {
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m5009a(ViewGroup viewGroup) {
        m5007a((View) viewGroup);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Object mo5004a(ViewGroup viewGroup, int OplusGLSurfaceView_13) {
        return m5003a((View) viewGroup, OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void mo5010a(ViewGroup viewGroup, int OplusGLSurfaceView_13, Object obj) {
        m5008a((View) viewGroup, OplusGLSurfaceView_13, obj);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m5018b(ViewGroup viewGroup, int OplusGLSurfaceView_13, Object obj) {
        m5016b((View) viewGroup, OplusGLSurfaceView_13, obj);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m5017b(ViewGroup viewGroup) {
        m5015b((View) viewGroup);
    }

    @Deprecated
    /* renamed from: PlatformImplementations.kt_3 */
    public Object m5003a(View view, int OplusGLSurfaceView_13) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    @Deprecated
    /* renamed from: PlatformImplementations.kt_3 */
    public void m5008a(View view, int OplusGLSurfaceView_13, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m5019c() {
        synchronized (this) {
            if (this.f4864b != null) {
                this.f4864b.onChanged();
            }
        }
        this.f4863a.notifyChanged();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m5005a(DataSetObserver dataSetObserver) {
        this.f4863a.registerObserver(dataSetObserver);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m5014b(DataSetObserver dataSetObserver) {
        this.f4863a.unregisterObserver(dataSetObserver);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    void m5020c(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.f4864b = dataSetObserver;
        }
    }
}
