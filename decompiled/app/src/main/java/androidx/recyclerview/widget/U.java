package androidx.recyclerview.widget;

/* compiled from: OrientationHelper.java */
/* loaded from: classes.dex */
public abstract class n_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    protected final androidx.recyclerview.widget.RecyclerView.i_renamed f1541a;

    /* renamed from: b_renamed, reason: collision with root package name */
    final android.graphics.Rect f1542b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f1543c;

    public abstract int a_renamed(android.view.View view);

    public abstract void a_renamed(int i_renamed);

    public abstract int b_renamed(android.view.View view);

    public abstract int c_renamed(android.view.View view);

    public abstract int d_renamed();

    public abstract int d_renamed(android.view.View view);

    public abstract int e_renamed();

    public abstract int e_renamed(android.view.View view);

    public abstract int f_renamed();

    public abstract int f_renamed(android.view.View view);

    public abstract int g_renamed();

    public abstract int h_renamed();

    public abstract int i_renamed();

    public abstract int j_renamed();

    private n_renamed(androidx.recyclerview.widget.RecyclerView.i_renamed iVar) {
        this.f1543c = Integer.MIN_VALUE;
        this.f1542b = new android.graphics.Rect();
        this.f1541a = iVar;
    }

    public androidx.recyclerview.widget.RecyclerView.i_renamed a_renamed() {
        return this.f1541a;
    }

    public void b_renamed() {
        this.f1543c = g_renamed();
    }

    public int c_renamed() {
        if (Integer.MIN_VALUE == this.f1543c) {
            return 0;
        }
        return g_renamed() - this.f1543c;
    }

    public static androidx.recyclerview.widget.n_renamed a_renamed(androidx.recyclerview.widget.RecyclerView.i_renamed iVar, int i_renamed) {
        if (i_renamed == 0) {
            return a_renamed(iVar);
        }
        if (i_renamed == 1) {
            return b_renamed(iVar);
        }
        throw new java.lang.IllegalArgumentException("invalid orientation");
    }

    public static androidx.recyclerview.widget.n_renamed a_renamed(androidx.recyclerview.widget.RecyclerView.i_renamed iVar) {
        return new androidx.recyclerview.widget.n_renamed(iVar) { // from class: androidx.recyclerview.widget.n_renamed.1
            @Override // androidx.recyclerview.widget.n_renamed
            public int e_renamed() {
                return this.f1541a.getWidth() - this.f1541a.getPaddingRight();
            }

            @Override // androidx.recyclerview.widget.n_renamed
            public int f_renamed() {
                return this.f1541a.getWidth();
            }

            @Override // androidx.recyclerview.widget.n_renamed
            public void a_renamed(int i_renamed) {
                this.f1541a.offsetChildrenHorizontal(i_renamed);
            }

            @Override // androidx.recyclerview.widget.n_renamed
            public int d_renamed() {
                return this.f1541a.getPaddingLeft();
            }

            @Override // androidx.recyclerview.widget.n_renamed
            public int e_renamed(android.view.View view) {
                androidx.recyclerview.widget.RecyclerView.j_renamed jVar = (androidx.recyclerview.widget.RecyclerView.j_renamed) view.getLayoutParams();
                return this.f1541a.getDecoratedMeasuredWidth(view) + jVar.leftMargin + jVar.rightMargin;
            }

            @Override // androidx.recyclerview.widget.n_renamed
            public int f_renamed(android.view.View view) {
                androidx.recyclerview.widget.RecyclerView.j_renamed jVar = (androidx.recyclerview.widget.RecyclerView.j_renamed) view.getLayoutParams();
                return this.f1541a.getDecoratedMeasuredHeight(view) + jVar.topMargin + jVar.bottomMargin;
            }

            @Override // androidx.recyclerview.widget.n_renamed
            public int b_renamed(android.view.View view) {
                return this.f1541a.getDecoratedRight(view) + ((androidx.recyclerview.widget.RecyclerView.j_renamed) view.getLayoutParams()).rightMargin;
            }

            @Override // androidx.recyclerview.widget.n_renamed
            public int a_renamed(android.view.View view) {
                return this.f1541a.getDecoratedLeft(view) - ((androidx.recyclerview.widget.RecyclerView.j_renamed) view.getLayoutParams()).leftMargin;
            }

            @Override // androidx.recyclerview.widget.n_renamed
            public int c_renamed(android.view.View view) {
                this.f1541a.getTransformedBoundingBox(view, true, this.f1542b);
                return this.f1542b.right;
            }

            @Override // androidx.recyclerview.widget.n_renamed
            public int d_renamed(android.view.View view) {
                this.f1541a.getTransformedBoundingBox(view, true, this.f1542b);
                return this.f1542b.left;
            }

            @Override // androidx.recyclerview.widget.n_renamed
            public int g_renamed() {
                return (this.f1541a.getWidth() - this.f1541a.getPaddingLeft()) - this.f1541a.getPaddingRight();
            }

            @Override // androidx.recyclerview.widget.n_renamed
            public int h_renamed() {
                return this.f1541a.getPaddingRight();
            }

            @Override // androidx.recyclerview.widget.n_renamed
            public int i_renamed() {
                return this.f1541a.getWidthMode();
            }

            @Override // androidx.recyclerview.widget.n_renamed
            public int j_renamed() {
                return this.f1541a.getHeightMode();
            }
        };
    }

    public static androidx.recyclerview.widget.n_renamed b_renamed(androidx.recyclerview.widget.RecyclerView.i_renamed iVar) {
        return new androidx.recyclerview.widget.n_renamed(iVar) { // from class: androidx.recyclerview.widget.n_renamed.2
            @Override // androidx.recyclerview.widget.n_renamed
            public int e_renamed() {
                return this.f1541a.getHeight() - this.f1541a.getPaddingBottom();
            }

            @Override // androidx.recyclerview.widget.n_renamed
            public int f_renamed() {
                return this.f1541a.getHeight();
            }

            @Override // androidx.recyclerview.widget.n_renamed
            public void a_renamed(int i_renamed) {
                this.f1541a.offsetChildrenVertical(i_renamed);
            }

            @Override // androidx.recyclerview.widget.n_renamed
            public int d_renamed() {
                return this.f1541a.getPaddingTop();
            }

            @Override // androidx.recyclerview.widget.n_renamed
            public int e_renamed(android.view.View view) {
                androidx.recyclerview.widget.RecyclerView.j_renamed jVar = (androidx.recyclerview.widget.RecyclerView.j_renamed) view.getLayoutParams();
                return this.f1541a.getDecoratedMeasuredHeight(view) + jVar.topMargin + jVar.bottomMargin;
            }

            @Override // androidx.recyclerview.widget.n_renamed
            public int f_renamed(android.view.View view) {
                androidx.recyclerview.widget.RecyclerView.j_renamed jVar = (androidx.recyclerview.widget.RecyclerView.j_renamed) view.getLayoutParams();
                return this.f1541a.getDecoratedMeasuredWidth(view) + jVar.leftMargin + jVar.rightMargin;
            }

            @Override // androidx.recyclerview.widget.n_renamed
            public int b_renamed(android.view.View view) {
                return this.f1541a.getDecoratedBottom(view) + ((androidx.recyclerview.widget.RecyclerView.j_renamed) view.getLayoutParams()).bottomMargin;
            }

            @Override // androidx.recyclerview.widget.n_renamed
            public int a_renamed(android.view.View view) {
                return this.f1541a.getDecoratedTop(view) - ((androidx.recyclerview.widget.RecyclerView.j_renamed) view.getLayoutParams()).topMargin;
            }

            @Override // androidx.recyclerview.widget.n_renamed
            public int c_renamed(android.view.View view) {
                this.f1541a.getTransformedBoundingBox(view, true, this.f1542b);
                return this.f1542b.bottom;
            }

            @Override // androidx.recyclerview.widget.n_renamed
            public int d_renamed(android.view.View view) {
                this.f1541a.getTransformedBoundingBox(view, true, this.f1542b);
                return this.f1542b.top;
            }

            @Override // androidx.recyclerview.widget.n_renamed
            public int g_renamed() {
                return (this.f1541a.getHeight() - this.f1541a.getPaddingTop()) - this.f1541a.getPaddingBottom();
            }

            @Override // androidx.recyclerview.widget.n_renamed
            public int h_renamed() {
                return this.f1541a.getPaddingBottom();
            }

            @Override // androidx.recyclerview.widget.n_renamed
            public int i_renamed() {
                return this.f1541a.getHeightMode();
            }

            @Override // androidx.recyclerview.widget.n_renamed
            public int j_renamed() {
                return this.f1541a.getWidthMode();
            }
        };
    }
}
