package androidx.appcompat.view.menu;

/* compiled from: MenuDialogHelper.java */
/* loaded from: classes.dex */
class i_renamed implements android.content.DialogInterface.OnClickListener, android.content.DialogInterface.OnDismissListener, android.content.DialogInterface.OnKeyListener, androidx.appcompat.view.menu.n_renamed.a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    androidx.appcompat.view.menu.f_renamed f390a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private androidx.appcompat.view.menu.h_renamed f391b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private androidx.appcompat.app.b_renamed f392c;
    private androidx.appcompat.view.menu.n_renamed.a_renamed d_renamed;

    public i_renamed(androidx.appcompat.view.menu.h_renamed hVar) {
        this.f391b = hVar;
    }

    public void a_renamed(android.os.IBinder iBinder) {
        androidx.appcompat.view.menu.h_renamed hVar = this.f391b;
        androidx.appcompat.app.b_renamed.a_renamed aVar = new androidx.appcompat.app.b_renamed.a_renamed(hVar.getContext());
        this.f390a = new androidx.appcompat.view.menu.f_renamed(aVar.getContext(), androidx.appcompat.R_renamed.layout.abc_list_menu_item_layout);
        this.f390a.setCallback(this);
        this.f391b.addMenuPresenter(this.f390a);
        aVar.setAdapter(this.f390a.a_renamed(), this);
        android.view.View headerView = hVar.getHeaderView();
        if (headerView != null) {
            aVar.setCustomTitle(headerView);
        } else {
            aVar.setIcon(hVar.getHeaderIcon()).setTitle(hVar.getHeaderTitle());
        }
        aVar.setOnKeyListener(this);
        this.f392c = aVar.create();
        this.f392c.setOnDismissListener(this);
        android.view.WindowManager.LayoutParams attributes = this.f392c.getWindow().getAttributes();
        attributes.type = com.heytap.accessory.CommonStatusCodes.TIME_EXPIRED;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f392c.show();
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(android.content.DialogInterface dialogInterface, int i_renamed, android.view.KeyEvent keyEvent) {
        android.view.Window window;
        android.view.View decorView;
        android.view.KeyEvent.DispatcherState keyDispatcherState;
        android.view.View decorView2;
        android.view.KeyEvent.DispatcherState keyDispatcherState2;
        if (i_renamed == 82 || i_renamed == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                android.view.Window window2 = this.f392c.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f392c.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f391b.close(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f391b.performShortcut(i_renamed, keyEvent, 0);
    }

    public void a_renamed() {
        androidx.appcompat.app.b_renamed bVar = this.f392c;
        if (bVar != null) {
            bVar.dismiss();
        }
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(android.content.DialogInterface dialogInterface) {
        this.f390a.onCloseMenu(this.f391b, true);
    }

    @Override // androidx.appcompat.view.menu.n_renamed.a_renamed
    public void a_renamed(androidx.appcompat.view.menu.h_renamed hVar, boolean z_renamed) {
        if (z_renamed || hVar == this.f391b) {
            a_renamed();
        }
        androidx.appcompat.view.menu.n_renamed.a_renamed aVar = this.d_renamed;
        if (aVar != null) {
            aVar.a_renamed(hVar, z_renamed);
        }
    }

    @Override // androidx.appcompat.view.menu.n_renamed.a_renamed
    public boolean a_renamed(androidx.appcompat.view.menu.h_renamed hVar) {
        androidx.appcompat.view.menu.n_renamed.a_renamed aVar = this.d_renamed;
        if (aVar != null) {
            return aVar.a_renamed(hVar);
        }
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i_renamed) {
        this.f391b.performItemAction((androidx.appcompat.view.menu.j_renamed) this.f390a.a_renamed().getItem(i_renamed), 0);
    }
}
