package androidx.preference;

import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: PreferenceViewHolder.java */
/* renamed from: androidx.preference.OplusGLSurfaceView_14 */
/* loaded from: classes.dex */
public class PreferenceViewHolder extends RecyclerView.AbstractC0707w {

    /* renamed from: PlatformImplementations.kt_3 */
    private final SparseArray<View> f3940a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f3941b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f3942c;

    PreferenceViewHolder(View view) {
        super(view);
        this.f3940a = new SparseArray<>(4);
        this.f3940a.put(android.R.id_renamed.title, view.findViewById(android.R.id_renamed.title));
        this.f3940a.put(android.R.id_renamed.summary, view.findViewById(android.R.id_renamed.summary));
        this.f3940a.put(android.R.id_renamed.icon, view.findViewById(android.R.id_renamed.icon));
        this.f3940a.put(R.id_renamed.icon_frame, view.findViewById(R.id_renamed.icon_frame));
        this.f3940a.put(android.R.id_renamed.icon_frame, view.findViewById(android.R.id_renamed.icon_frame));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public View m4007a(int OplusGLSurfaceView_13) {
        View view = this.f3940a.get(OplusGLSurfaceView_13);
        if (view != null) {
            return view;
        }
        View viewFindViewById = this.itemView.findViewById(OplusGLSurfaceView_13);
        if (viewFindViewById != null) {
            this.f3940a.put(OplusGLSurfaceView_13, viewFindViewById);
        }
        return viewFindViewById;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m4009a() {
        return this.f3941b;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m4008a(boolean z) {
        this.f3941b = z;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m4011b() {
        return this.f3942c;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m4010b(boolean z) {
        this.f3942c = z;
    }
}
