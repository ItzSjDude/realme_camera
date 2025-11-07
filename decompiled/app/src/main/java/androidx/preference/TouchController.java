package androidx.preference;

/* compiled from: PreferenceViewHolder.java */
/* loaded from: classes.dex */
public class l_renamed extends androidx.recyclerview.widget.RecyclerView.w_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.util.SparseArray<android.view.View> f1378a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private boolean f1379b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f1380c;

    l_renamed(android.view.View view) {
        super(view);
        this.f1378a = new android.util.SparseArray<>(4);
        this.f1378a.put(android.R_renamed.id_renamed.title, view.findViewById(android.R_renamed.id_renamed.title));
        this.f1378a.put(android.R_renamed.id_renamed.summary, view.findViewById(android.R_renamed.id_renamed.summary));
        this.f1378a.put(android.R_renamed.id_renamed.icon, view.findViewById(android.R_renamed.id_renamed.icon));
        this.f1378a.put(androidx.preference.R_renamed.id_renamed.icon_frame, view.findViewById(androidx.preference.R_renamed.id_renamed.icon_frame));
        this.f1378a.put(android.R_renamed.id_renamed.icon_frame, view.findViewById(android.R_renamed.id_renamed.icon_frame));
    }

    public android.view.View a_renamed(int i_renamed) {
        android.view.View view = this.f1378a.get(i_renamed);
        if (view != null) {
            return view;
        }
        android.view.View viewFindViewById = this.itemView.findViewById(i_renamed);
        if (viewFindViewById != null) {
            this.f1378a.put(i_renamed, viewFindViewById);
        }
        return viewFindViewById;
    }

    public boolean a_renamed() {
        return this.f1379b;
    }

    public void a_renamed(boolean z_renamed) {
        this.f1379b = z_renamed;
    }

    public boolean b_renamed() {
        return this.f1380c;
    }

    public void b_renamed(boolean z_renamed) {
        this.f1380c = z_renamed;
    }
}
