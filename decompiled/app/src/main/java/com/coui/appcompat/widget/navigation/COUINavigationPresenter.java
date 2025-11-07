package com.coui.appcompat.widget.navigation;

/* loaded from: classes.dex */
public class COUINavigationPresenter implements androidx.appcompat.view.menu.n_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private androidx.appcompat.view.menu.h_renamed f2995a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.coui.appcompat.widget.navigation.b_renamed f2996b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f2997c;
    private int d_renamed;

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

    @Override // androidx.appcompat.view.menu.n_renamed
    public void initForMenu(android.content.Context context, androidx.appcompat.view.menu.h_renamed hVar) {
        this.f2996b.initialize(this.f2995a);
        this.f2995a = hVar;
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public void updateMenuView(boolean z_renamed) {
        if (this.f2997c) {
            return;
        }
        if (z_renamed) {
            this.f2996b.a_renamed();
        } else {
            this.f2996b.b_renamed();
        }
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public int getId() {
        return this.d_renamed;
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public android.os.Parcelable onSaveInstanceState() {
        com.coui.appcompat.widget.navigation.COUINavigationPresenter.SavedState savedState = new com.coui.appcompat.widget.navigation.COUINavigationPresenter.SavedState();
        savedState.mSelectedItemId = this.f2996b.getSelectedItemId();
        return savedState;
    }

    @Override // androidx.appcompat.view.menu.n_renamed
    public void onRestoreInstanceState(android.os.Parcelable parcelable) {
        if (parcelable instanceof com.coui.appcompat.widget.navigation.COUINavigationPresenter.SavedState) {
            this.f2996b.a_renamed(((com.coui.appcompat.widget.navigation.COUINavigationPresenter.SavedState) parcelable).mSelectedItemId);
        }
    }

    public void a_renamed(boolean z_renamed) {
        this.f2997c = z_renamed;
    }

    static class SavedState implements android.os.Parcelable {
        public static final android.os.Parcelable.Creator<com.coui.appcompat.widget.navigation.COUINavigationPresenter.SavedState> CREATOR = new android.os.Parcelable.Creator<com.coui.appcompat.widget.navigation.COUINavigationPresenter.SavedState>() { // from class: com.coui.appcompat.widget.navigation.COUINavigationPresenter.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public com.coui.appcompat.widget.navigation.COUINavigationPresenter.SavedState createFromParcel(android.os.Parcel parcel) {
                return new com.coui.appcompat.widget.navigation.COUINavigationPresenter.SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public com.coui.appcompat.widget.navigation.COUINavigationPresenter.SavedState[] newArray(int i_renamed) {
                return new com.coui.appcompat.widget.navigation.COUINavigationPresenter.SavedState[i_renamed];
            }
        };
        int mSelectedItemId;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        SavedState() {
        }

        SavedState(android.os.Parcel parcel) {
            this.mSelectedItemId = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
            parcel.writeInt(this.mSelectedItemId);
        }
    }
}
