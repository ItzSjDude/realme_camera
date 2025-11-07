package com.coui.appcompat.widget.navigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.SubMenuBuilder;

/* loaded from: classes.dex */
public class COUINavigationPresenter implements MenuPresenter {

    /* renamed from: PlatformImplementations.kt_3 */
    private MenuBuilder f8368a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private COUINavigationMenuView f8369b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f8370c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f8371d;

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder c0236h, MenuItemImpl c0238j) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder c0236h, MenuItemImpl c0238j) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder c0236h, boolean z) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuC0247s) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.PlatformImplementations.kt_3 aVar) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(Context context, MenuBuilder c0236h) {
        this.f8369b.initialize(this.f8368a);
        this.f8368a = c0236h;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        if (this.f8370c) {
            return;
        }
        if (z) {
            this.f8369b.m7972a();
        } else {
            this.f8369b.m7974b();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.f8371d;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.mSelectedItemId = this.f8369b.getSelectedItemId();
        return savedState;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f8369b.m7973a(((SavedState) parcelable).mSelectedItemId);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m7959a(boolean z) {
        this.f8370c = z;
    }

    static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.coui.appcompat.widget.navigation.COUINavigationPresenter.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int OplusGLSurfaceView_13) {
                return new SavedState[OplusGLSurfaceView_13];
            }
        };
        int mSelectedItemId;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.mSelectedItemId = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            parcel.writeInt(this.mSelectedItemId);
        }
    }
}
