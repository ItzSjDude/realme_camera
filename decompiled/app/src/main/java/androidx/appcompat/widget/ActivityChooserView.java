package androidx.appcompat.widget;

/* loaded from: classes.dex */
public class ActivityChooserView extends android.view.ViewGroup {

    /* renamed from: a_renamed, reason: collision with root package name */
    final androidx.appcompat.widget.ActivityChooserView.a_renamed f447a;

    /* renamed from: b_renamed, reason: collision with root package name */
    final android.widget.FrameLayout f448b;

    /* renamed from: c_renamed, reason: collision with root package name */
    final android.widget.FrameLayout f449c;
    androidx.core.h_renamed.b_renamed d_renamed;
    final android.database.DataSetObserver e_renamed;
    android.widget.PopupWindow.OnDismissListener f_renamed;
    boolean g_renamed;
    int h_renamed;
    private final androidx.appcompat.widget.ActivityChooserView.b_renamed i_renamed;
    private final android.view.View j_renamed;
    private final android.widget.ImageView k_renamed;
    private final int l_renamed;
    private final android.view.ViewTreeObserver.OnGlobalLayoutListener m_renamed;
    private androidx.appcompat.widget.ae_renamed n_renamed;
    private boolean o_renamed;
    private int p_renamed;

    public void setActivityChooserModel(androidx.appcompat.widget.c_renamed cVar) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        this.f447a.a_renamed(cVar);
        if (c_renamed()) {
            b_renamed();
            a_renamed();
        }
    }

    public void setExpandActivityOverflowButtonDrawable(android.graphics.drawable.Drawable drawable) {
        this.k_renamed.setImageDrawable(drawable);
    }

    public void setExpandActivityOverflowButtonContentDescription(int i_renamed) {
        this.k_renamed.setContentDescription(getContext().getString(i_renamed));
    }

    public void setProvider(androidx.core.h_renamed.b_renamed bVar) {
        this.d_renamed = bVar;
    }

    public boolean a_renamed() throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (c_renamed() || !this.o_renamed) {
            return false;
        }
        this.g_renamed = false;
        a_renamed(this.h_renamed);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [boolean, int] */
    void a_renamed(int i_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (this.f447a.d_renamed() == null) {
            throw new java.lang.IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.m_renamed);
        ?? r0 = this.f449c.getVisibility() == 0 ? 1 : 0;
        int iC = this.f447a.c_renamed();
        if (i_renamed != Integer.MAX_VALUE && iC > i_renamed + r0) {
            this.f447a.a_renamed(true);
            this.f447a.a_renamed(i_renamed - 1);
        } else {
            this.f447a.a_renamed(false);
            this.f447a.a_renamed(i_renamed);
        }
        androidx.appcompat.widget.ae_renamed listPopupWindow = getListPopupWindow();
        if (listPopupWindow.c_renamed()) {
            return;
        }
        if (this.g_renamed || r0 == 0) {
            this.f447a.a_renamed(true, r0);
        } else {
            this.f447a.a_renamed(false, false);
        }
        listPopupWindow.h_renamed(java.lang.Math.min(this.f447a.a_renamed(), this.l_renamed));
        listPopupWindow.a__renamed();
        androidx.core.h_renamed.b_renamed bVar = this.d_renamed;
        if (bVar != null) {
            bVar.a_renamed(true);
        }
        listPopupWindow.b__renamed().setContentDescription(getContext().getString(androidx.appcompat.R_renamed.string.abc_activitychooserview_choose_application));
        listPopupWindow.b__renamed().setSelector(new android.graphics.drawable.ColorDrawable(0));
    }

    public boolean b_renamed() {
        if (!c_renamed()) {
            return true;
        }
        getListPopupWindow().b_renamed();
        android.view.ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        viewTreeObserver.removeGlobalOnLayoutListener(this.m_renamed);
        return true;
    }

    public boolean c_renamed() {
        return getListPopupWindow().c_renamed();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        androidx.appcompat.widget.c_renamed cVarD = this.f447a.d_renamed();
        if (cVarD != null) {
            cVarD.registerObserver(this.e_renamed);
        }
        this.o_renamed = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        androidx.appcompat.widget.c_renamed cVarD = this.f447a.d_renamed();
        if (cVarD != null) {
            cVarD.unregisterObserver(this.e_renamed);
        }
        android.view.ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.m_renamed);
        }
        if (c_renamed()) {
            b_renamed();
        }
        this.o_renamed = false;
    }

    @Override // android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        android.view.View view = this.j_renamed;
        if (this.f449c.getVisibility() != 0) {
            i2 = android.view.View.MeasureSpec.makeMeasureSpec(android.view.View.MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(view, i_renamed, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z_renamed, int i_renamed, int i2, int i3, int i4) {
        this.j_renamed.layout(0, 0, i3 - i_renamed, i4 - i2);
        if (c_renamed()) {
            return;
        }
        b_renamed();
    }

    public androidx.appcompat.widget.c_renamed getDataModel() {
        return this.f447a.d_renamed();
    }

    public void setOnDismissListener(android.widget.PopupWindow.OnDismissListener onDismissListener) {
        this.f_renamed = onDismissListener;
    }

    public void setInitialActivityCount(int i_renamed) {
        this.h_renamed = i_renamed;
    }

    public void setDefaultActionButtonContentDescription(int i_renamed) {
        this.p_renamed = i_renamed;
    }

    androidx.appcompat.widget.ae_renamed getListPopupWindow() {
        if (this.n_renamed == null) {
            this.n_renamed = new androidx.appcompat.widget.ae_renamed(getContext());
            this.n_renamed.a_renamed(this.f447a);
            this.n_renamed.b_renamed(this);
            this.n_renamed.a_renamed(true);
            this.n_renamed.a_renamed((android.widget.AdapterView.OnItemClickListener) this.i_renamed);
            this.n_renamed.a_renamed((android.widget.PopupWindow.OnDismissListener) this.i_renamed);
        }
        return this.n_renamed;
    }

    private class b_renamed implements android.view.View.OnClickListener, android.view.View.OnLongClickListener, android.widget.AdapterView.OnItemClickListener, android.widget.PopupWindow.OnDismissListener {

        /* renamed from: a_renamed, reason: collision with root package name */
        final /* synthetic */ androidx.appcompat.widget.ActivityChooserView f454a;

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(android.widget.AdapterView<?> adapterView, android.view.View view, int i_renamed, long j_renamed) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            int itemViewType = ((androidx.appcompat.widget.ActivityChooserView.a_renamed) adapterView.getAdapter()).getItemViewType(i_renamed);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    this.f454a.a_renamed(Integer.MAX_VALUE);
                    return;
                }
                throw new java.lang.IllegalArgumentException();
            }
            this.f454a.b_renamed();
            if (this.f454a.g_renamed) {
                if (i_renamed > 0) {
                    this.f454a.f447a.d_renamed().c_renamed(i_renamed);
                    return;
                }
                return;
            }
            if (!this.f454a.f447a.e_renamed()) {
                i_renamed++;
            }
            android.content.Intent intentB = this.f454a.f447a.d_renamed().b_renamed(i_renamed);
            if (intentB != null) {
                intentB.addFlags(com.sensetime.stmobile.STMobileHumanActionNative.ST_MOBILE_ENABLE_INPUT_CUSTOM);
                this.f454a.getContext().startActivity(intentB);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            if (view == this.f454a.f449c) {
                this.f454a.b_renamed();
                android.content.Intent intentB = this.f454a.f447a.d_renamed().b_renamed(this.f454a.f447a.d_renamed().a_renamed(this.f454a.f447a.b_renamed()));
                if (intentB != null) {
                    intentB.addFlags(com.sensetime.stmobile.STMobileHumanActionNative.ST_MOBILE_ENABLE_INPUT_CUSTOM);
                    this.f454a.getContext().startActivity(intentB);
                    return;
                }
                return;
            }
            if (view == this.f454a.f448b) {
                androidx.appcompat.widget.ActivityChooserView activityChooserView = this.f454a;
                activityChooserView.g_renamed = false;
                activityChooserView.a_renamed(activityChooserView.h_renamed);
                return;
            }
            throw new java.lang.IllegalArgumentException();
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(android.view.View view) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            if (view == this.f454a.f449c) {
                if (this.f454a.f447a.getCount() > 0) {
                    androidx.appcompat.widget.ActivityChooserView activityChooserView = this.f454a;
                    activityChooserView.g_renamed = true;
                    activityChooserView.a_renamed(activityChooserView.h_renamed);
                }
                return true;
            }
            throw new java.lang.IllegalArgumentException();
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            a_renamed();
            if (this.f454a.d_renamed != null) {
                this.f454a.d_renamed.a_renamed(false);
            }
        }

        private void a_renamed() {
            if (this.f454a.f_renamed != null) {
                this.f454a.f_renamed.onDismiss();
            }
        }
    }

    private class a_renamed extends android.widget.BaseAdapter {

        /* renamed from: a_renamed, reason: collision with root package name */
        final /* synthetic */ androidx.appcompat.widget.ActivityChooserView f451a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private androidx.appcompat.widget.c_renamed f452b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private int f453c;
        private boolean d_renamed;
        private boolean e_renamed;
        private boolean f_renamed;

        @Override // android.widget.Adapter
        public long getItemId(int i_renamed) {
            return i_renamed;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }

        public void a_renamed(androidx.appcompat.widget.c_renamed cVar) {
            androidx.appcompat.widget.c_renamed cVarD = this.f451a.f447a.d_renamed();
            if (cVarD != null && this.f451a.isShown()) {
                cVarD.unregisterObserver(this.f451a.e_renamed);
            }
            this.f452b = cVar;
            if (cVar != null && this.f451a.isShown()) {
                cVar.registerObserver(this.f451a.e_renamed);
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i_renamed) {
            return (this.f_renamed && i_renamed == getCount() - 1) ? 1 : 0;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int iA = this.f452b.a_renamed();
            if (!this.d_renamed && this.f452b.b_renamed() != null) {
                iA--;
            }
            int iMin = java.lang.Math.min(iA, this.f453c);
            return this.f_renamed ? iMin + 1 : iMin;
        }

        @Override // android.widget.Adapter
        public java.lang.Object getItem(int i_renamed) {
            int itemViewType = getItemViewType(i_renamed);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    return null;
                }
                throw new java.lang.IllegalArgumentException();
            }
            if (!this.d_renamed && this.f452b.b_renamed() != null) {
                i_renamed++;
            }
            return this.f452b.a_renamed(i_renamed);
        }

        @Override // android.widget.Adapter
        public android.view.View getView(int i_renamed, android.view.View view, android.view.ViewGroup viewGroup) {
            int itemViewType = getItemViewType(i_renamed);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    if (view != null && view.getId() == 1) {
                        return view;
                    }
                    android.view.View viewInflate = android.view.LayoutInflater.from(this.f451a.getContext()).inflate(androidx.appcompat.R_renamed.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                    viewInflate.setId(1);
                    ((android.widget.TextView) viewInflate.findViewById(androidx.appcompat.R_renamed.id_renamed.title)).setText(this.f451a.getContext().getString(androidx.appcompat.R_renamed.string.abc_activity_chooser_view_see_all));
                    return viewInflate;
                }
                throw new java.lang.IllegalArgumentException();
            }
            if (view == null || view.getId() != androidx.appcompat.R_renamed.id_renamed.list_item) {
                view = android.view.LayoutInflater.from(this.f451a.getContext()).inflate(androidx.appcompat.R_renamed.layout.abc_activity_chooser_view_list_item, viewGroup, false);
            }
            android.content.pm.PackageManager packageManager = this.f451a.getContext().getPackageManager();
            android.widget.ImageView imageView = (android.widget.ImageView) view.findViewById(androidx.appcompat.R_renamed.id_renamed.icon);
            android.content.pm.ResolveInfo resolveInfo = (android.content.pm.ResolveInfo) getItem(i_renamed);
            imageView.setImageDrawable(resolveInfo.loadIcon(packageManager));
            ((android.widget.TextView) view.findViewById(androidx.appcompat.R_renamed.id_renamed.title)).setText(resolveInfo.loadLabel(packageManager));
            if (this.d_renamed && i_renamed == 0 && this.e_renamed) {
                view.setActivated(true);
            } else {
                view.setActivated(false);
            }
            return view;
        }

        public int a_renamed() {
            int i_renamed = this.f453c;
            this.f453c = Integer.MAX_VALUE;
            int iMakeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
            int iMakeMeasureSpec2 = android.view.View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            int iMax = 0;
            android.view.View view = null;
            for (int i2 = 0; i2 < count; i2++) {
                view = getView(i2, view, null);
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                iMax = java.lang.Math.max(iMax, view.getMeasuredWidth());
            }
            this.f453c = i_renamed;
            return iMax;
        }

        public void a_renamed(int i_renamed) {
            if (this.f453c != i_renamed) {
                this.f453c = i_renamed;
                notifyDataSetChanged();
            }
        }

        public android.content.pm.ResolveInfo b_renamed() {
            return this.f452b.b_renamed();
        }

        public void a_renamed(boolean z_renamed) {
            if (this.f_renamed != z_renamed) {
                this.f_renamed = z_renamed;
                notifyDataSetChanged();
            }
        }

        public int c_renamed() {
            return this.f452b.a_renamed();
        }

        public androidx.appcompat.widget.c_renamed d_renamed() {
            return this.f452b;
        }

        public void a_renamed(boolean z_renamed, boolean z2) {
            if (this.d_renamed == z_renamed && this.e_renamed == z2) {
                return;
            }
            this.d_renamed = z_renamed;
            this.e_renamed = z2;
            notifyDataSetChanged();
        }

        public boolean e_renamed() {
            return this.d_renamed;
        }
    }

    public static class InnerLayout extends android.widget.LinearLayout {

        /* renamed from: a_renamed, reason: collision with root package name */
        private static final int[] f450a = {android.R_renamed.attr.background};

        public InnerLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
            androidx.appcompat.widget.ar_renamed arVarA = androidx.appcompat.widget.ar_renamed.a_renamed(context, attributeSet, f450a);
            setBackgroundDrawable(arVarA.a_renamed(0));
            arVarA.b_renamed();
        }
    }
}
