package androidx.appcompat.widget;

/* compiled from: MenuPopupWindow.java */
/* loaded from: classes.dex */
public class ag_renamed extends androidx.appcompat.widget.ae_renamed implements androidx.appcompat.widget.af_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static java.lang.reflect.Method f543a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private androidx.appcompat.widget.af_renamed f544b;

    static {
        try {
            if (android.os.Build.VERSION.SDK_INT <= 28) {
                f543a = android.widget.PopupWindow.class.getDeclaredMethod("setTouchModal", java.lang.Boolean.TYPE);
            }
        } catch (java.lang.NoSuchMethodException unused) {
            android.util.Log.i_renamed("MenuPopupWindow", "Could not find method setTouchModal() on_renamed PopupWindow. Oh well.");
        }
    }

    public ag_renamed(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        super(context, attributeSet, i_renamed, i2);
    }

    @Override // androidx.appcompat.widget.ae_renamed
    androidx.appcompat.widget.ab_renamed a_renamed(android.content.Context context, boolean z_renamed) {
        androidx.appcompat.widget.ag_renamed.a_renamed aVar = new androidx.appcompat.widget.ag_renamed.a_renamed(context, z_renamed);
        aVar.setHoverListener(this);
        return aVar;
    }

    public void a_renamed(java.lang.Object obj) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            this.g_renamed.setEnterTransition((android.transition.Transition) obj);
        }
    }

    public void b_renamed(java.lang.Object obj) {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            this.g_renamed.setExitTransition((android.transition.Transition) obj);
        }
    }

    public void a_renamed(androidx.appcompat.widget.af_renamed afVar) {
        this.f544b = afVar;
    }

    public void c_renamed(boolean z_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (android.os.Build.VERSION.SDK_INT <= 28) {
            java.lang.reflect.Method method = f543a;
            if (method != null) {
                try {
                    method.invoke(this.g_renamed, java.lang.Boolean.valueOf(z_renamed));
                    return;
                } catch (java.lang.Exception unused) {
                    android.util.Log.i_renamed("MenuPopupWindow", "Could not invoke setTouchModal() on_renamed PopupWindow. Oh well.");
                    return;
                }
            }
            return;
        }
        this.g_renamed.setTouchModal(z_renamed);
    }

    @Override // androidx.appcompat.widget.af_renamed
    public void b_renamed(androidx.appcompat.view.menu.h_renamed hVar, android.view.MenuItem menuItem) {
        androidx.appcompat.widget.af_renamed afVar = this.f544b;
        if (afVar != null) {
            afVar.b_renamed(hVar, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.af_renamed
    public void a_renamed(androidx.appcompat.view.menu.h_renamed hVar, android.view.MenuItem menuItem) {
        androidx.appcompat.widget.af_renamed afVar = this.f544b;
        if (afVar != null) {
            afVar.a_renamed(hVar, menuItem);
        }
    }

    /* compiled from: MenuPopupWindow.java */
    public static class a_renamed extends androidx.appcompat.widget.ab_renamed {

        /* renamed from: b_renamed, reason: collision with root package name */
        final int f545b;

        /* renamed from: c_renamed, reason: collision with root package name */
        final int f546c;
        private androidx.appcompat.widget.af_renamed d_renamed;
        private android.view.MenuItem e_renamed;

        @Override // androidx.appcompat.widget.ab_renamed
        public /* bridge */ /* synthetic */ int a_renamed(int i_renamed, int i2, int i3, int i4, int i5) {
            return super.a_renamed(i_renamed, i2, i3, i4, i5);
        }

        @Override // androidx.appcompat.widget.ab_renamed
        public /* bridge */ /* synthetic */ boolean a_renamed(android.view.MotionEvent motionEvent, int i_renamed) {
            return super.a_renamed(motionEvent, i_renamed);
        }

        @Override // androidx.appcompat.widget.ab_renamed, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // androidx.appcompat.widget.ab_renamed, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // androidx.appcompat.widget.ab_renamed, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // androidx.appcompat.widget.ab_renamed, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // androidx.appcompat.widget.ab_renamed, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(android.view.MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        @Override // androidx.appcompat.widget.ab_renamed, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(android.graphics.drawable.Drawable drawable) {
            super.setSelector(drawable);
        }

        public a_renamed(android.content.Context context, boolean z_renamed) {
            super(context, z_renamed);
            android.content.res.Configuration configuration = context.getResources().getConfiguration();
            if (android.os.Build.VERSION.SDK_INT >= 17 && 1 == configuration.getLayoutDirection()) {
                this.f545b = 21;
                this.f546c = 22;
            } else {
                this.f545b = 22;
                this.f546c = 21;
            }
        }

        public void setHoverListener(androidx.appcompat.widget.af_renamed afVar) {
            this.d_renamed = afVar;
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i_renamed, android.view.KeyEvent keyEvent) {
            androidx.appcompat.view.menu.ListMenuItemView listMenuItemView = (androidx.appcompat.view.menu.ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i_renamed == this.f545b) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            }
            if (listMenuItemView != null && i_renamed == this.f546c) {
                setSelection(-1);
                ((androidx.appcompat.view.menu.g_renamed) getAdapter()).a_renamed().close(false);
                return true;
            }
            return super.onKeyDown(i_renamed, keyEvent);
        }

        @Override // androidx.appcompat.widget.ab_renamed, android.view.View
        public boolean onHoverEvent(android.view.MotionEvent motionEvent) {
            int headersCount;
            androidx.appcompat.view.menu.g_renamed gVar;
            int iPointToPosition;
            int i_renamed;
            if (this.d_renamed != null) {
                android.widget.ListAdapter adapter = getAdapter();
                if (adapter instanceof android.widget.HeaderViewListAdapter) {
                    android.widget.HeaderViewListAdapter headerViewListAdapter = (android.widget.HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    gVar = (androidx.appcompat.view.menu.g_renamed) headerViewListAdapter.getWrappedAdapter();
                } else {
                    headersCount = 0;
                    gVar = (androidx.appcompat.view.menu.g_renamed) adapter;
                }
                androidx.appcompat.view.menu.j_renamed item = null;
                if (motionEvent.getAction() != 10 && (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i_renamed = iPointToPosition - headersCount) >= 0 && i_renamed < gVar.getCount()) {
                    item = gVar.getItem(i_renamed);
                }
                android.view.MenuItem menuItem = this.e_renamed;
                if (menuItem != item) {
                    androidx.appcompat.view.menu.h_renamed hVarA = gVar.a_renamed();
                    if (menuItem != null) {
                        this.d_renamed.a_renamed(hVarA, menuItem);
                    }
                    this.e_renamed = item;
                    if (item != null) {
                        this.d_renamed.b_renamed(hVarA, item);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }
    }
}
