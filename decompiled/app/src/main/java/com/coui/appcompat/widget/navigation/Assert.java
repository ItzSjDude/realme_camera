package com.coui.appcompat.widget.navigation;

/* loaded from: classes.dex */
public class COUINavigationView extends android.widget.FrameLayout {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final int[] f2998a = {android.R_renamed.attr.state_checked};

    /* renamed from: b_renamed, reason: collision with root package name */
    private static final int[] f2999b = {-16842910};

    /* renamed from: c_renamed, reason: collision with root package name */
    private final androidx.appcompat.view.menu.h_renamed f3000c;
    private final com.coui.appcompat.widget.navigation.b_renamed d_renamed;
    private final com.coui.appcompat.widget.navigation.COUINavigationPresenter e_renamed;
    private android.view.MenuInflater f_renamed;
    private android.animation.Animator g_renamed;
    private android.animation.Animator h_renamed;
    private int i_renamed;
    private com.coui.appcompat.widget.navigation.COUINavigationView.c_renamed j_renamed;
    private com.coui.appcompat.widget.navigation.COUINavigationView.b_renamed k_renamed;
    private com.coui.appcompat.widget.navigation.COUINavigationView.a_renamed l_renamed;
    private android.view.View m_renamed;

    public interface a_renamed {
    }

    public interface b_renamed {
    }

    public interface c_renamed {
    }

    public int getMaxItemCount() {
        return 5;
    }

    private void a_renamed() throws android.content.res.Resources.NotFoundException {
        int dimensionPixelSize = getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_tool_navigation_item_height);
        if (this.i_renamed != 0) {
            dimensionPixelSize = getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.coui_tool_navigation_item_default_height);
        }
        this.d_renamed.setItemHeight(dimensionPixelSize);
    }

    public void setOnNavigationItemSelectedListener(com.coui.appcompat.widget.navigation.COUINavigationView.c_renamed cVar) {
        this.j_renamed = cVar;
    }

    public void setOnNavigationItemReselectedListener(com.coui.appcompat.widget.navigation.COUINavigationView.b_renamed bVar) {
        this.k_renamed = bVar;
    }

    public android.view.Menu getMenu() {
        return this.f3000c;
    }

    public android.content.res.ColorStateList getItemIconTintList() {
        return this.d_renamed.getIconTintList();
    }

    @java.lang.Deprecated
    public void setItemIconTintList(android.content.res.ColorStateList colorStateList) {
        this.d_renamed.setIconTintList(colorStateList);
    }

    public android.content.res.ColorStateList getItemTextColor() {
        return this.d_renamed.getItemTextColor();
    }

    public void setItemTextColor(android.content.res.ColorStateList colorStateList) {
        this.d_renamed.setItemTextColor(colorStateList);
    }

    public void setItemLayoutType(int i_renamed) throws android.content.res.Resources.NotFoundException {
        this.i_renamed = i_renamed;
        this.d_renamed.setItemLayoutType(i_renamed);
        a_renamed();
    }

    public int getItemBackgroundResource() {
        return this.d_renamed.getItemBackgroundRes();
    }

    public void setItemBackgroundResource(int i_renamed) {
        this.d_renamed.setItemBackgroundRes(i_renamed);
    }

    public int getSelectedItemId() {
        return this.d_renamed.getSelectedItemId();
    }

    public void setSelectedItemId(int i_renamed) {
        android.view.MenuItem menuItemFindItem = this.f3000c.findItem(i_renamed);
        if (menuItemFindItem == null || this.f3000c.performItemAction(menuItemFindItem, this.e_renamed, 0)) {
            return;
        }
        menuItemFindItem.setChecked(true);
    }

    public void setAnimationType(int i_renamed) {
        if (i_renamed == 1) {
            this.g_renamed.start();
        } else if (i_renamed == 2) {
            this.h_renamed.start();
        }
    }

    public void setNeedTextAnim(boolean z_renamed) {
        this.d_renamed.setNeedTextAnim(z_renamed);
    }

    public void setOnAnimatorListener(com.coui.appcompat.widget.navigation.COUINavigationView.a_renamed aVar) {
        this.l_renamed = aVar;
    }

    public android.view.View getDividerView() {
        return this.m_renamed;
    }

    private android.view.MenuInflater getMenuInflater() {
        if (this.f_renamed == null) {
            this.f_renamed = new androidx.appcompat.view.g_renamed(getContext());
        }
        return this.f_renamed;
    }

    @Override // android.view.View
    protected android.os.Parcelable onSaveInstanceState() {
        com.coui.appcompat.widget.navigation.COUINavigationView.SavedState savedState = new com.coui.appcompat.widget.navigation.COUINavigationView.SavedState(super.onSaveInstanceState());
        savedState.menuPresenterState = new android.os.Bundle();
        this.f3000c.savePresenterStates(savedState.menuPresenterState);
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(android.os.Parcelable parcelable) {
        if (!(parcelable instanceof com.coui.appcompat.widget.navigation.COUINavigationView.SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        com.coui.appcompat.widget.navigation.COUINavigationView.SavedState savedState = (com.coui.appcompat.widget.navigation.COUINavigationView.SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f3000c.restorePresenterStates(savedState.menuPresenterState);
    }

    static class SavedState extends androidx.customview.view.AbsSavedState {
        public static final android.os.Parcelable.Creator<com.coui.appcompat.widget.navigation.COUINavigationView.SavedState> CREATOR = new android.os.Parcelable.ClassLoaderCreator<com.coui.appcompat.widget.navigation.COUINavigationView.SavedState>() { // from class: com.coui.appcompat.widget.navigation.COUINavigationView.SavedState.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public com.coui.appcompat.widget.navigation.COUINavigationView.SavedState createFromParcel(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
                return new com.coui.appcompat.widget.navigation.COUINavigationView.SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public com.coui.appcompat.widget.navigation.COUINavigationView.SavedState createFromParcel(android.os.Parcel parcel) {
                return new com.coui.appcompat.widget.navigation.COUINavigationView.SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public com.coui.appcompat.widget.navigation.COUINavigationView.SavedState[] newArray(int i_renamed) {
                return new com.coui.appcompat.widget.navigation.COUINavigationView.SavedState[i_renamed];
            }
        };
        android.os.Bundle menuPresenterState;

        public SavedState(android.os.Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
            super(parcel, classLoader);
            readFromParcel(parcel, classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
            super.writeToParcel(parcel, i_renamed);
            parcel.writeBundle(this.menuPresenterState);
        }

        private void readFromParcel(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
            this.menuPresenterState = parcel.readBundle(classLoader);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(android.content.res.Configuration configuration) throws android.content.res.Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        a_renamed();
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }
}
