package com.google.android.material.navigation;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.appcompat.p016a.p017a.AppCompatResources;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.p027a.ContextCompat;
import androidx.core.p036h.WindowInsetsCompat;
import androidx.core.p036h.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.C1694R;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.internal.NavigationMenuPresenter;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* loaded from: classes.dex */
public class NavigationView extends ScrimInsetsFrameLayout {
    private static final int PRESENTER_NAVIGATION_VIEW_ID = 1;
    OnNavigationItemSelectedListener listener;
    private final int maxWidth;
    private final NavigationMenu menu;
    private MenuInflater menuInflater;
    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
    private final NavigationMenuPresenter presenter;
    private final int[] tmpLocation;
    private static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    private static final int[] DISABLED_STATE_SET = {-16842910};
    private static final int DEF_STYLE_RES = C1694R.style.Widget_Design_NavigationView;

    public interface OnNavigationItemSelectedListener {
        boolean onNavigationItemSelected(MenuItem menuItem);
    }

    public NavigationView(Context context) {
        this(context, null);
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C1694R.attr.navigationViewStyle);
    }

    public NavigationView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        ColorStateList colorStateListCreateDefaultColorStateList;
        boolean z;
        int iM1560g;
        super(MaterialThemeOverlay.wrap(context, attributeSet, OplusGLSurfaceView_13, DEF_STYLE_RES), attributeSet, OplusGLSurfaceView_13);
        this.presenter = new NavigationMenuPresenter();
        this.tmpLocation = new int[2];
        Context context2 = getContext();
        this.menu = new NavigationMenu(context2);
        TintTypedArray c0322arObtainTintedStyledAttributes = ThemeEnforcement.obtainTintedStyledAttributes(context2, attributeSet, C1694R.styleable.NavigationView, OplusGLSurfaceView_13, DEF_STYLE_RES, new int[0]);
        if (c0322arObtainTintedStyledAttributes.m1561g(C1694R.styleable.NavigationView_android_background)) {
            ViewCompat.m2850a(this, c0322arObtainTintedStyledAttributes.m1546a(C1694R.styleable.NavigationView_android_background));
        }
        if (getBackground() == null || (getBackground() instanceof ColorDrawable)) {
            Drawable background = getBackground();
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            if (background instanceof ColorDrawable) {
                materialShapeDrawable.setFillColor(ColorStateList.valueOf(((ColorDrawable) background).getColor()));
            }
            materialShapeDrawable.initializeElevationOverlay(context2);
            ViewCompat.m2850a(this, materialShapeDrawable);
        }
        if (c0322arObtainTintedStyledAttributes.m1561g(C1694R.styleable.NavigationView_elevation)) {
            setElevation(c0322arObtainTintedStyledAttributes.m1556e(C1694R.styleable.NavigationView_elevation, 0));
        }
        setFitsSystemWindows(c0322arObtainTintedStyledAttributes.m1547a(C1694R.styleable.NavigationView_android_fitsSystemWindows, false));
        this.maxWidth = c0322arObtainTintedStyledAttributes.m1556e(C1694R.styleable.NavigationView_android_maxWidth, 0);
        if (c0322arObtainTintedStyledAttributes.m1561g(C1694R.styleable.NavigationView_itemIconTint)) {
            colorStateListCreateDefaultColorStateList = c0322arObtainTintedStyledAttributes.m1557e(C1694R.styleable.NavigationView_itemIconTint);
        } else {
            colorStateListCreateDefaultColorStateList = createDefaultColorStateList(R.attr.textColorSecondary);
        }
        if (c0322arObtainTintedStyledAttributes.m1561g(C1694R.styleable.NavigationView_itemTextAppearance)) {
            iM1560g = c0322arObtainTintedStyledAttributes.m1560g(C1694R.styleable.NavigationView_itemTextAppearance, 0);
            z = true;
        } else {
            z = false;
            iM1560g = 0;
        }
        if (c0322arObtainTintedStyledAttributes.m1561g(C1694R.styleable.NavigationView_itemIconSize)) {
            setItemIconSize(c0322arObtainTintedStyledAttributes.m1556e(C1694R.styleable.NavigationView_itemIconSize, 0));
        }
        ColorStateList colorStateListM1557e = c0322arObtainTintedStyledAttributes.m1561g(C1694R.styleable.NavigationView_itemTextColor) ? c0322arObtainTintedStyledAttributes.m1557e(C1694R.styleable.NavigationView_itemTextColor) : null;
        if (!z && colorStateListM1557e == null) {
            colorStateListM1557e = createDefaultColorStateList(R.attr.textColorPrimary);
        }
        Drawable drawableM1546a = c0322arObtainTintedStyledAttributes.m1546a(C1694R.styleable.NavigationView_itemBackground);
        if (drawableM1546a == null && hasShapeAppearance(c0322arObtainTintedStyledAttributes)) {
            drawableM1546a = createDefaultItemBackground(c0322arObtainTintedStyledAttributes);
        }
        if (c0322arObtainTintedStyledAttributes.m1561g(C1694R.styleable.NavigationView_itemHorizontalPadding)) {
            this.presenter.setItemHorizontalPadding(c0322arObtainTintedStyledAttributes.m1556e(C1694R.styleable.NavigationView_itemHorizontalPadding, 0));
        }
        int iM1556e = c0322arObtainTintedStyledAttributes.m1556e(C1694R.styleable.NavigationView_itemIconPadding, 0);
        setItemMaxLines(c0322arObtainTintedStyledAttributes.m1544a(C1694R.styleable.NavigationView_itemMaxLines, 1));
        this.menu.setCallback(new MenuBuilder.PlatformImplementations.kt_3() { // from class: com.google.android.material.navigation.NavigationView.1
            @Override // androidx.appcompat.view.menu.MenuBuilder.PlatformImplementations.kt_3
            public void onMenuModeChange(MenuBuilder c0236h) {
            }

            @Override // androidx.appcompat.view.menu.MenuBuilder.PlatformImplementations.kt_3
            public boolean onMenuItemSelected(MenuBuilder c0236h, MenuItem menuItem) {
                return NavigationView.this.listener != null && NavigationView.this.listener.onNavigationItemSelected(menuItem);
            }
        });
        this.presenter.setId(1);
        this.presenter.initForMenu(context2, this.menu);
        this.presenter.setItemIconTintList(colorStateListCreateDefaultColorStateList);
        this.presenter.setOverScrollMode(getOverScrollMode());
        if (z) {
            this.presenter.setItemTextAppearance(iM1560g);
        }
        this.presenter.setItemTextColor(colorStateListM1557e);
        this.presenter.setItemBackground(drawableM1546a);
        this.presenter.setItemIconPadding(iM1556e);
        this.menu.addMenuPresenter(this.presenter);
        addView((View) this.presenter.getMenuView(this));
        if (c0322arObtainTintedStyledAttributes.m1561g(C1694R.styleable.NavigationView_menu)) {
            inflateMenu(c0322arObtainTintedStyledAttributes.m1560g(C1694R.styleable.NavigationView_menu, 0));
        }
        if (c0322arObtainTintedStyledAttributes.m1561g(C1694R.styleable.NavigationView_headerLayout)) {
            inflateHeaderView(c0322arObtainTintedStyledAttributes.m1560g(C1694R.styleable.NavigationView_headerLayout, 0));
        }
        c0322arObtainTintedStyledAttributes.m1551b();
        setupInsetScrimsListener();
    }

    @Override // android.view.View
    public void setOverScrollMode(int OplusGLSurfaceView_13) {
        super.setOverScrollMode(OplusGLSurfaceView_13);
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        if (navigationMenuPresenter != null) {
            navigationMenuPresenter.setOverScrollMode(OplusGLSurfaceView_13);
        }
    }

    private boolean hasShapeAppearance(TintTypedArray c0322ar) {
        return c0322ar.m1561g(C1694R.styleable.NavigationView_itemShapeAppearance) || c0322ar.m1561g(C1694R.styleable.NavigationView_itemShapeAppearanceOverlay);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    @Override // android.view.View
    public void setElevation(float COUIBaseListPopupWindow_12) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.setElevation(COUIBaseListPopupWindow_12);
        }
        MaterialShapeUtils.setElevation(this, COUIBaseListPopupWindow_12);
    }

    private final Drawable createDefaultItemBackground(TintTypedArray c0322ar) {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(ShapeAppearanceModel.builder(getContext(), c0322ar.m1560g(C1694R.styleable.NavigationView_itemShapeAppearance, 0), c0322ar.m1560g(C1694R.styleable.NavigationView_itemShapeAppearanceOverlay, 0)).build());
        materialShapeDrawable.setFillColor(MaterialResources.getColorStateList(getContext(), c0322ar, C1694R.styleable.NavigationView_itemShapeFillColor));
        return new InsetDrawable((Drawable) materialShapeDrawable, c0322ar.m1556e(C1694R.styleable.NavigationView_itemShapeInsetStart, 0), c0322ar.m1556e(C1694R.styleable.NavigationView_itemShapeInsetTop, 0), c0322ar.m1556e(C1694R.styleable.NavigationView_itemShapeInsetEnd, 0), c0322ar.m1556e(C1694R.styleable.NavigationView_itemShapeInsetBottom, 0));
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.menuState = new Bundle();
        this.menu.savePresenterStates(savedState.menuState);
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
        this.menu.restorePresenterStates(savedState.menuState);
    }

    public void setNavigationItemSelectedListener(OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
        this.listener = onNavigationItemSelectedListener;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        int mode = View.MeasureSpec.getMode(OplusGLSurfaceView_13);
        if (mode == Integer.MIN_VALUE) {
            OplusGLSurfaceView_13 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(OplusGLSurfaceView_13), this.maxWidth), 1073741824);
        } else if (mode == 0) {
            OplusGLSurfaceView_13 = View.MeasureSpec.makeMeasureSpec(this.maxWidth, 1073741824);
        }
        super.onMeasure(OplusGLSurfaceView_13, i2);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout
    protected void onInsetsChanged(WindowInsetsCompat c0490ad) {
        this.presenter.dispatchApplyWindowInsets(c0490ad);
    }

    public void inflateMenu(int OplusGLSurfaceView_13) {
        this.presenter.setUpdateSuspended(true);
        getMenuInflater().inflate(OplusGLSurfaceView_13, this.menu);
        this.presenter.setUpdateSuspended(false);
        this.presenter.updateMenuView(false);
    }

    public Menu getMenu() {
        return this.menu;
    }

    public View inflateHeaderView(int OplusGLSurfaceView_13) {
        return this.presenter.inflateHeaderView(OplusGLSurfaceView_13);
    }

    public void addHeaderView(View view) {
        this.presenter.addHeaderView(view);
    }

    public void removeHeaderView(View view) {
        this.presenter.removeHeaderView(view);
    }

    public int getHeaderCount() {
        return this.presenter.getHeaderCount();
    }

    public View getHeaderView(int OplusGLSurfaceView_13) {
        return this.presenter.getHeaderView(OplusGLSurfaceView_13);
    }

    public ColorStateList getItemIconTintList() {
        return this.presenter.getItemTintList();
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.presenter.setItemIconTintList(colorStateList);
    }

    public ColorStateList getItemTextColor() {
        return this.presenter.getItemTextColor();
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.presenter.setItemTextColor(colorStateList);
    }

    public Drawable getItemBackground() {
        return this.presenter.getItemBackground();
    }

    public void setItemBackgroundResource(int OplusGLSurfaceView_13) {
        setItemBackground(ContextCompat.m2248a(getContext(), OplusGLSurfaceView_13));
    }

    public void setItemBackground(Drawable drawable) {
        this.presenter.setItemBackground(drawable);
    }

    public int getItemHorizontalPadding() {
        return this.presenter.getItemHorizontalPadding();
    }

    public void setItemHorizontalPadding(int OplusGLSurfaceView_13) {
        this.presenter.setItemHorizontalPadding(OplusGLSurfaceView_13);
    }

    public void setItemHorizontalPaddingResource(int OplusGLSurfaceView_13) {
        this.presenter.setItemHorizontalPadding(getResources().getDimensionPixelSize(OplusGLSurfaceView_13));
    }

    public int getItemIconPadding() {
        return this.presenter.getItemIconPadding();
    }

    public void setItemIconPadding(int OplusGLSurfaceView_13) {
        this.presenter.setItemIconPadding(OplusGLSurfaceView_13);
    }

    public void setItemIconPaddingResource(int OplusGLSurfaceView_13) {
        this.presenter.setItemIconPadding(getResources().getDimensionPixelSize(OplusGLSurfaceView_13));
    }

    public void setCheckedItem(int OplusGLSurfaceView_13) {
        MenuItem menuItemFindItem = this.menu.findItem(OplusGLSurfaceView_13);
        if (menuItemFindItem != null) {
            this.presenter.setCheckedItem((MenuItemImpl) menuItemFindItem);
        }
    }

    public void setCheckedItem(MenuItem menuItem) {
        MenuItem menuItemFindItem = this.menu.findItem(menuItem.getItemId());
        if (menuItemFindItem != null) {
            this.presenter.setCheckedItem((MenuItemImpl) menuItemFindItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }

    public MenuItem getCheckedItem() {
        return this.presenter.getCheckedItem();
    }

    public void setItemTextAppearance(int OplusGLSurfaceView_13) {
        this.presenter.setItemTextAppearance(OplusGLSurfaceView_13);
    }

    public void setItemIconSize(int OplusGLSurfaceView_13) {
        this.presenter.setItemIconSize(OplusGLSurfaceView_13);
    }

    public void setItemMaxLines(int OplusGLSurfaceView_13) {
        this.presenter.setItemMaxLines(OplusGLSurfaceView_13);
    }

    public int getItemMaxLines() {
        return this.presenter.getItemMaxLines();
    }

    private MenuInflater getMenuInflater() {
        if (this.menuInflater == null) {
            this.menuInflater = new SupportMenuInflater(getContext());
        }
        return this.menuInflater;
    }

    private ColorStateList createDefaultColorStateList(int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(OplusGLSurfaceView_13, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateListM729a = AppCompatResources.m729a(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = colorStateListM729a.getDefaultColor();
        return new ColorStateList(new int[][]{DISABLED_STATE_SET, CHECKED_STATE_SET, EMPTY_STATE_SET}, new int[]{colorStateListM729a.getColorForState(DISABLED_STATE_SET, defaultColor), i2, defaultColor});
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (Build.VERSION.SDK_INT < 16) {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.onGlobalLayoutListener);
        } else {
            getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
        }
    }

    private void setupInsetScrimsListener() {
        this.onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.google.android.material.navigation.NavigationView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                NavigationView navigationView = NavigationView.this;
                navigationView.getLocationOnScreen(navigationView.tmpLocation);
                boolean z = NavigationView.this.tmpLocation[1] == 0;
                NavigationView.this.presenter.setBehindStatusBar(z);
                NavigationView.this.setDrawTopInsetForeground(z);
                Context context = NavigationView.this.getContext();
                if (!(context instanceof Activity) || Build.VERSION.SDK_INT < 21) {
                    return;
                }
                Activity activity = (Activity) context;
                NavigationView.this.setDrawBottomInsetForeground((activity.findViewById(R.id_renamed.content).getHeight() == NavigationView.this.getHeight()) && (Color.alpha(activity.getWindow().getNavigationBarColor()) != 0));
            }
        };
        getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.navigation.NavigationView.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int OplusGLSurfaceView_13) {
                return new SavedState[OplusGLSurfaceView_13];
            }
        };
        public Bundle menuState;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.menuState = parcel.readBundle(classLoader);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            super.writeToParcel(parcel, OplusGLSurfaceView_13);
            parcel.writeBundle(this.menuState);
        }
    }
}
