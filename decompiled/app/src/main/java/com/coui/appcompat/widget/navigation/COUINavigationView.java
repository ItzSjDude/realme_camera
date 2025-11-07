package com.coui.appcompat.widget.navigation;

import android.R;
import android.animation.Animator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.customview.view.AbsSavedState;

/* loaded from: classes.dex */
public class COUINavigationView extends FrameLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final int[] f8372a = {R.attr.state_checked};

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final int[] f8373b = {-16842910};

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final MenuBuilder f8374c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private final COUINavigationMenuView f8375d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private final COUINavigationPresenter f8376e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private MenuInflater f8377f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private Animator f8378g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private Animator f8379h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f8380i;

    /* renamed from: OplusGLSurfaceView_15 */
    private InterfaceC1494c f8381j;

    /* renamed from: OplusGLSurfaceView_5 */
    private InterfaceC1493b f8382k;

    /* renamed from: OplusGLSurfaceView_14 */
    private InterfaceC1492a f8383l;

    /* renamed from: OplusGLSurfaceView_6 */
    private View f8384m;

    /* renamed from: com.coui.appcompat.widget.navigation.COUINavigationView$PlatformImplementations.kt_3 */
    public interface InterfaceC1492a {
    }

    /* renamed from: com.coui.appcompat.widget.navigation.COUINavigationView$IntrinsicsJvm.kt_4 */
    public interface InterfaceC1493b {
    }

    /* renamed from: com.coui.appcompat.widget.navigation.COUINavigationView$IntrinsicsJvm.kt_3 */
    public interface InterfaceC1494c {
    }

    public int getMaxItemCount() {
        return 5;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7962a() throws Resources.NotFoundException {
        int dimensionPixelSize = getResources().getDimensionPixelSize(coui.support.appcompat.R.dimen.coui_tool_navigation_item_height);
        if (this.f8380i != 0) {
            dimensionPixelSize = getResources().getDimensionPixelSize(coui.support.appcompat.R.dimen.coui_tool_navigation_item_default_height);
        }
        this.f8375d.setItemHeight(dimensionPixelSize);
    }

    public void setOnNavigationItemSelectedListener(InterfaceC1494c interfaceC1494c) {
        this.f8381j = interfaceC1494c;
    }

    public void setOnNavigationItemReselectedListener(InterfaceC1493b interfaceC1493b) {
        this.f8382k = interfaceC1493b;
    }

    public Menu getMenu() {
        return this.f8374c;
    }

    public ColorStateList getItemIconTintList() {
        return this.f8375d.getIconTintList();
    }

    @Deprecated
    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f8375d.setIconTintList(colorStateList);
    }

    public ColorStateList getItemTextColor() {
        return this.f8375d.getItemTextColor();
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f8375d.setItemTextColor(colorStateList);
    }

    public void setItemLayoutType(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        this.f8380i = OplusGLSurfaceView_13;
        this.f8375d.setItemLayoutType(OplusGLSurfaceView_13);
        m7962a();
    }

    public int getItemBackgroundResource() {
        return this.f8375d.getItemBackgroundRes();
    }

    public void setItemBackgroundResource(int OplusGLSurfaceView_13) {
        this.f8375d.setItemBackgroundRes(OplusGLSurfaceView_13);
    }

    public int getSelectedItemId() {
        return this.f8375d.getSelectedItemId();
    }

    public void setSelectedItemId(int OplusGLSurfaceView_13) {
        MenuItem menuItemFindItem = this.f8374c.findItem(OplusGLSurfaceView_13);
        if (menuItemFindItem == null || this.f8374c.performItemAction(menuItemFindItem, this.f8376e, 0)) {
            return;
        }
        menuItemFindItem.setChecked(true);
    }

    public void setAnimationType(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 1) {
            this.f8378g.start();
        } else if (OplusGLSurfaceView_13 == 2) {
            this.f8379h.start();
        }
    }

    public void setNeedTextAnim(boolean z) {
        this.f8375d.setNeedTextAnim(z);
    }

    public void setOnAnimatorListener(InterfaceC1492a interfaceC1492a) {
        this.f8383l = interfaceC1492a;
    }

    public View getDividerView() {
        return this.f8384m;
    }

    private MenuInflater getMenuInflater() {
        if (this.f8377f == null) {
            this.f8377f = new SupportMenuInflater(getContext());
        }
        return this.f8377f;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.menuPresenterState = new Bundle();
        this.f8374c.savePresenterStates(savedState.menuPresenterState);
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f8374c.restorePresenterStates(savedState.menuPresenterState);
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.coui.appcompat.widget.navigation.COUINavigationView.SavedState.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int OplusGLSurfaceView_13) {
                return new SavedState[OplusGLSurfaceView_13];
            }
        };
        Bundle menuPresenterState;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            readFromParcel(parcel, classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            super.writeToParcel(parcel, OplusGLSurfaceView_13);
            parcel.writeBundle(this.menuPresenterState);
        }

        private void readFromParcel(Parcel parcel, ClassLoader classLoader) {
            this.menuPresenterState = parcel.readBundle(classLoader);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        m7962a();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }
}
