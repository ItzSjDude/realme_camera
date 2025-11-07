package com.coui.appcompat.widget;

/* compiled from: ExpandableRecyclerPosition.java */
/* loaded from: classes.dex */
class x_renamed {
    private static java.util.ArrayList<com.coui.appcompat.widget.x_renamed> e_renamed = new java.util.ArrayList<>(5);

    /* renamed from: a_renamed, reason: collision with root package name */
    public int f3126a;

    /* renamed from: b_renamed, reason: collision with root package name */
    public int f3127b;

    /* renamed from: c_renamed, reason: collision with root package name */
    int f3128c;
    public int d_renamed;

    private void b_renamed() {
        this.f3126a = 0;
        this.f3127b = 0;
        this.f3128c = 0;
        this.d_renamed = 0;
    }

    private x_renamed() {
    }

    static com.coui.appcompat.widget.x_renamed a_renamed(int i_renamed, int i2, int i3, int i4) {
        com.coui.appcompat.widget.x_renamed xVarC = c_renamed();
        xVarC.d_renamed = i_renamed;
        xVarC.f3126a = i2;
        xVarC.f3127b = i3;
        xVarC.f3128c = i4;
        return xVarC;
    }

    private static com.coui.appcompat.widget.x_renamed c_renamed() {
        synchronized (e_renamed) {
            if (e_renamed.size() > 0) {
                com.coui.appcompat.widget.x_renamed xVarRemove = e_renamed.remove(0);
                xVarRemove.b_renamed();
                return xVarRemove;
            }
            return new com.coui.appcompat.widget.x_renamed();
        }
    }

    public void a_renamed() {
        synchronized (e_renamed) {
            if (e_renamed.size() < 5) {
                e_renamed.add(this);
            }
        }
    }
}
