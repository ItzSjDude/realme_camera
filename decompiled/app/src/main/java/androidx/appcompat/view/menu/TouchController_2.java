package androidx.appcompat.view.menu;

/* compiled from: MenuPopupHelper.java */
/* loaded from: classes.dex */
public class m_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private final android.content.Context f408a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final androidx.appcompat.view.menu.h_renamed f409b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final boolean f410c;
    private final int d_renamed;
    private final int e_renamed;
    private android.view.View f_renamed;
    private int g_renamed;
    private boolean h_renamed;
    private androidx.appcompat.view.menu.n_renamed.a_renamed i_renamed;
    private androidx.appcompat.view.menu.l_renamed j_renamed;
    private android.widget.PopupWindow.OnDismissListener k_renamed;
    private final android.widget.PopupWindow.OnDismissListener l_renamed;

    public m_renamed(android.content.Context context, androidx.appcompat.view.menu.h_renamed hVar, android.view.View view, boolean z_renamed, int i_renamed) {
        this(context, hVar, view, z_renamed, i_renamed, 0);
    }

    public m_renamed(android.content.Context context, androidx.appcompat.view.menu.h_renamed hVar, android.view.View view, boolean z_renamed, int i_renamed, int i2) {
        this.g_renamed = 8388611;
        this.l_renamed = new android.widget.PopupWindow.OnDismissListener() { // from class: androidx.appcompat.view.menu.m_renamed.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                androidx.appcompat.view.menu.m_renamed.this.e_renamed();
            }
        };
        this.f408a = context;
        this.f409b = hVar;
        this.f_renamed = view;
        this.f410c = z_renamed;
        this.d_renamed = i_renamed;
        this.e_renamed = i2;
    }

    public void a_renamed(android.widget.PopupWindow.OnDismissListener onDismissListener) {
        this.k_renamed = onDismissListener;
    }

    public void a_renamed(android.view.View view) {
        this.f_renamed = view;
    }

    public void a_renamed(boolean z_renamed) {
        this.h_renamed = z_renamed;
        androidx.appcompat.view.menu.l_renamed lVar = this.j_renamed;
        if (lVar != null) {
            lVar.a_renamed(z_renamed);
        }
    }

    public void a_renamed(int i_renamed) {
        this.g_renamed = i_renamed;
    }

    public void a_renamed() {
        if (!c_renamed()) {
            throw new java.lang.IllegalStateException("MenuPopupHelper cannot be_renamed used without an_renamed anchor");
        }
    }

    public androidx.appcompat.view.menu.l_renamed b_renamed() {
        if (this.j_renamed == null) {
            this.j_renamed = g_renamed();
        }
        return this.j_renamed;
    }

    public boolean c_renamed() {
        if (f_renamed()) {
            return true;
        }
        if (this.f_renamed == null) {
            return false;
        }
        a_renamed(0, 0, false, false);
        return true;
    }

    public boolean a_renamed(int i_renamed, int i2) {
        if (f_renamed()) {
            return true;
        }
        if (this.f_renamed == null) {
            return false;
        }
        a_renamed(i_renamed, i2, true, true);
        return true;
    }

    private androidx.appcompat.view.menu.l_renamed g_renamed() {
        androidx.appcompat.view.menu.l_renamed rVar;
        android.view.Display defaultDisplay = ((android.view.WindowManager) this.f408a.getSystemService("window")).getDefaultDisplay();
        android.graphics.Point point = new android.graphics.Point();
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        if (java.lang.Math.min(point.x_renamed, point.y_renamed) >= this.f408a.getResources().getDimensionPixelSize(androidx.appcompat.R_renamed.dimen.abc_cascading_menus_min_smallest_width)) {
            rVar = new androidx.appcompat.view.menu.e_renamed(this.f408a, this.f_renamed, this.d_renamed, this.e_renamed, this.f410c);
        } else {
            rVar = new androidx.appcompat.view.menu.r_renamed(this.f408a, this.f409b, this.f_renamed, this.d_renamed, this.e_renamed, this.f410c);
        }
        rVar.a_renamed(this.f409b);
        rVar.a_renamed(this.l_renamed);
        rVar.a_renamed(this.f_renamed);
        rVar.setCallback(this.i_renamed);
        rVar.a_renamed(this.h_renamed);
        rVar.a_renamed(this.g_renamed);
        return rVar;
    }

    private void a_renamed(int i_renamed, int i2, boolean z_renamed, boolean z2) {
        androidx.appcompat.view.menu.l_renamed lVarB = b_renamed();
        lVarB.b_renamed(z2);
        if (z_renamed) {
            if ((androidx.core.h_renamed.c_renamed.a_renamed(this.g_renamed, androidx.core.h_renamed.v_renamed.g_renamed(this.f_renamed)) & 7) == 5) {
                i_renamed -= this.f_renamed.getWidth();
            }
            lVarB.b_renamed(i_renamed);
            lVarB.c_renamed(i2);
            int i3 = (int) ((this.f408a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            lVarB.a_renamed(new android.graphics.Rect(i_renamed - i3, i2 - i3, i_renamed + i3, i2 + i3));
        }
        lVarB.a__renamed();
    }

    public void d_renamed() {
        if (f_renamed()) {
            this.j_renamed.b_renamed();
        }
    }

    protected void e_renamed() {
        this.j_renamed = null;
        android.widget.PopupWindow.OnDismissListener onDismissListener = this.k_renamed;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public boolean f_renamed() {
        androidx.appcompat.view.menu.l_renamed lVar = this.j_renamed;
        return lVar != null && lVar.c_renamed();
    }

    public void a_renamed(androidx.appcompat.view.menu.n_renamed.a_renamed aVar) {
        this.i_renamed = aVar;
        androidx.appcompat.view.menu.l_renamed lVar = this.j_renamed;
        if (lVar != null) {
            lVar.setCallback(aVar);
        }
    }
}
