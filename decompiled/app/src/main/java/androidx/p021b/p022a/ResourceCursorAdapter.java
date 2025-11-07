package androidx.p021b.p022a;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: ResourceCursorAdapter.java */
/* renamed from: androidx.IntrinsicsJvm.kt_4.PlatformImplementations.kt_3.IntrinsicsJvm.kt_3 */
/* loaded from: classes.dex */
public abstract class ResourceCursorAdapter extends CursorAdapter {

    /* renamed from: OplusGLSurfaceView_15 */
    private int f2035j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f2036k;

    /* renamed from: OplusGLSurfaceView_14 */
    private LayoutInflater f2037l;

    @Deprecated
    public ResourceCursorAdapter(Context context, int OplusGLSurfaceView_13, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.f2036k = OplusGLSurfaceView_13;
        this.f2035j = OplusGLSurfaceView_13;
        this.f2037l = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // androidx.p021b.p022a.CursorAdapter
    /* renamed from: PlatformImplementations.kt_3 */
    public View mo1524a(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f2037l.inflate(this.f2035j, viewGroup, false);
    }

    @Override // androidx.p021b.p022a.CursorAdapter
    /* renamed from: IntrinsicsJvm.kt_4 */
    public View mo1766b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f2037l.inflate(this.f2036k, viewGroup, false);
    }
}
