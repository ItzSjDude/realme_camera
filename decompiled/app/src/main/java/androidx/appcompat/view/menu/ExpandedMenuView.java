package androidx.appcompat.view.menu;

/* loaded from: classes.dex */
public final class ExpandedMenuView extends android.widget.ListView implements android.widget.AdapterView.OnItemClickListener, androidx.appcompat.view.menu.h_renamed.b_renamed, androidx.appcompat.view.menu.o_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final int[] f351a = {android.R_renamed.attr.background, android.R_renamed.attr.divider};

    /* renamed from: b_renamed, reason: collision with root package name */
    private androidx.appcompat.view.menu.h_renamed f352b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f353c;

    public ExpandedMenuView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, android.R_renamed.attr.listViewStyle);
    }

    public ExpandedMenuView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        androidx.appcompat.widget.ar_renamed arVarA = androidx.appcompat.widget.ar_renamed.a_renamed(context, attributeSet, f351a, i_renamed, 0);
        if (arVarA.g_renamed(0)) {
            setBackgroundDrawable(arVarA.a_renamed(0));
        }
        if (arVarA.g_renamed(1)) {
            setDivider(arVarA.a_renamed(1));
        }
        arVarA.b_renamed();
    }

    @Override // androidx.appcompat.view.menu.o_renamed
    public void initialize(androidx.appcompat.view.menu.h_renamed hVar) {
        this.f352b = hVar;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // androidx.appcompat.view.menu.h_renamed.b_renamed
    public boolean a_renamed(androidx.appcompat.view.menu.j_renamed jVar) {
        return this.f352b.performItemAction(jVar, 0);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(android.widget.AdapterView adapterView, android.view.View view, int i_renamed, long j_renamed) {
        a_renamed((androidx.appcompat.view.menu.j_renamed) getAdapter().getItem(i_renamed));
    }

    public int getWindowAnimations() {
        return this.f353c;
    }
}
