package com.google.android.material.bottomnavigation;

/* loaded from: classes.dex */
public class BottomNavigationPresenter implements androidx.appcompat.view.menu.n_renamed {
    private int id_renamed;
    private androidx.appcompat.view.menu.h_renamed menu;
    private com.google.android.material.bottomnavigation.BottomNavigationMenuView menuView;
    private boolean updateSuspended = false;

    @Override // androidx.appcompat.view.menu.n_renamed
    public boolean collapseItemActionView(androidx.appcompat.view.menu.h_renamed hVar, androidx.appcompat.view.menu.j_renamed jVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public boolean expandItemActionView(androidx.appcompat.view.menu.h_renamed hVar, androidx.appcompat.view.menu.j_renamed jVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public void onCloseMenu(androidx.appcompat.view.menu.h_renamed hVar, boolean z_renamed) {
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public boolean onSubMenuSelected(androidx.appcompat.view.menu.s_renamed sVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public void setCallback(androidx.appcompat.view.menu.n_renamed.a_renamed aVar) {
    }

    public void setBottomNavigationMenuView(com.google.android.material.bottomnavigation.BottomNavigationMenuView bottomNavigationMenuView) {
        this.menuView = bottomNavigationMenuView;
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public void initForMenu(android.content.Context context, androidx.appcompat.view.menu.h_renamed hVar) {
        this.menu = hVar;
        this.menuView.initialize(this.menu);
    }

    public androidx.appcompat.view.menu.o_renamed getMenuView(android.view.ViewGroup viewGroup) {
        return this.menuView;
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public void updateMenuView(boolean z_renamed) {
        if (this.updateSuspended) {
            return;
        }
        if (z_renamed) {
            this.menuView.buildMenuView();
        } else {
            this.menuView.updateMenuView();
        }
    }

    public void setId(int i_renamed) {
        this.id_renamed = i_renamed;
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public int getId() {
        return this.id_renamed;
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public android.os.Parcelable onSaveInstanceState() {
        com.google.android.material.bottomnavigation.BottomNavigationPresenter.SavedState savedState = new com.google.android.material.bottomnavigation.BottomNavigationPresenter.SavedState();
        savedState.selectedItemId = this.menuView.getSelectedItemId();
        savedState.badgeSavedStates = com.google.android.material.badge.BadgeUtils.createParcelableBadgeStates(this.menuView.getBadgeDrawables());
        return savedState;
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public void onRestoreInstanceState(android.os.Parcelable parcelable) {
        if (parcelable instanceof com.google.android.material.bottomnavigation.BottomNavigationPresenter.SavedState) {
            com.google.android.material.bottomnavigation.BottomNavigationPresenter.SavedState savedState = (com.google.android.material.bottomnavigation.BottomNavigationPresenter.SavedState) parcelable;
            this.menuView.tryRestoreSelectedItemId(savedState.selectedItemId);
            this.menuView.setBadgeDrawables(com.google.android.material.badge.BadgeUtils.createBadgeDrawablesFromSavedStates(this.menuView.getContext(), savedState.badgeSavedStates));
        }
    }

    public void setUpdateSuspended(boolean z_renamed) {
        this.updateSuspended = z_renamed;
    }

    static class SavedState implements android.os.Parcelable {
        public static final android.os.Parcelable.Creator<com.google.android.material.bottomnavigation.BottomNavigationPresenter.SavedState> CREATOR = new android.os.Parcelable.Creator<com.google.android.material.bottomnavigation.BottomNavigationPresenter.SavedState>() { // from class: com.google.android.material.bottomnavigation.BottomNavigationPresenter.SavedState.1
            /* JADX WARN: Can't_renamed rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public com.google.android.material.bottomnavigation.BottomNavigationPresenter.SavedState createFromParcel(android.os.Parcel parcel) {
                return new com.google.android.material.bottomnavigation.BottomNavigationPresenter.SavedState(parcel);
            }

            /* JADX WARN: Can't_renamed rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public com.google.android.material.bottomnavigation.BottomNavigationPresenter.SavedState[] newArray(int i_renamed) {
                return new com.google.android.material.bottomnavigation.BottomNavigationPresenter.SavedState[i_renamed];
            }
        };
        com.google.android.material.internal.ParcelableSparseArray badgeSavedStates;
        int selectedItemId;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        SavedState() {
        }

        SavedState(android.os.Parcel parcel) {
            this.selectedItemId = parcel.readInt();
            this.badgeSavedStates = (com.google.android.material.internal.ParcelableSparseArray) parcel.readParcelable(getClass().getClassLoader());
        }

        @Override // android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
            parcel.writeInt(this.selectedItemId);
            parcel.writeParcelable(this.badgeSavedStates, 0);
        }
    }
}
