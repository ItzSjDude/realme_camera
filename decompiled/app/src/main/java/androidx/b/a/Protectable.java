package androidx.b_renamed.a_renamed;

/* compiled from: ResourceCursorAdapter.java */
/* loaded from: classes.dex */
public abstract class c_renamed extends androidx.b_renamed.a_renamed.a_renamed {
    private int j_renamed;
    private int k_renamed;
    private android.view.LayoutInflater l_renamed;

    @java.lang.Deprecated
    public c_renamed(android.content.Context context, int i_renamed, android.database.Cursor cursor, boolean z_renamed) {
        super(context, cursor, z_renamed);
        this.k_renamed = i_renamed;
        this.j_renamed = i_renamed;
        this.l_renamed = (android.view.LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // androidx.b_renamed.a_renamed.a_renamed
    public android.view.View a_renamed(android.content.Context context, android.database.Cursor cursor, android.view.ViewGroup viewGroup) {
        return this.l_renamed.inflate(this.j_renamed, viewGroup, false);
    }

    @Override // androidx.b_renamed.a_renamed.a_renamed
    public android.view.View b_renamed(android.content.Context context, android.database.Cursor cursor, android.view.ViewGroup viewGroup) {
        return this.l_renamed.inflate(this.k_renamed, viewGroup, false);
    }
}
