package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TooltipCompat;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.p027a.p028a.ResourcesCompat;
import androidx.core.p036h.AccessibilityDelegateCompat;
import androidx.core.p036h.ViewCompat;
import androidx.core.p036h.p037a.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.C1694R;

/* loaded from: classes.dex */
public class NavigationMenuItemView extends ForegroundLinearLayout implements MenuView.PlatformImplementations.kt_3 {
    private static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    private final AccessibilityDelegateCompat accessibilityDelegate;
    private FrameLayout actionArea;
    boolean checkable;
    private Drawable emptyDrawable;
    private boolean hasIconTintList;
    private int iconSize;
    private ColorStateList iconTintList;
    private MenuItemImpl itemData;
    private boolean needsEmptyIcon;
    private final CheckedTextView textView;

    @Override // androidx.appcompat.view.menu.MenuView.PlatformImplementations.kt_3
    public boolean prefersCondensedTitle() {
        return false;
    }

    public void setShortcut(boolean z, char c2) {
    }

    public boolean showsIcon() {
        return true;
    }

    public NavigationMenuItemView(Context context) {
        this(context, null);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.accessibilityDelegate = new AccessibilityDelegateCompat() { // from class: com.google.android.material.internal.NavigationMenuItemView.1
            @Override // androidx.core.p036h.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat c0483d) {
                super.onInitializeAccessibilityNodeInfo(view, c0483d);
                c0483d.m2684a(NavigationMenuItemView.this.checkable);
            }
        };
        setOrientation(0);
        LayoutInflater.from(context).inflate(C1694R.layout.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(C1694R.dimen.design_navigation_icon_size));
        this.textView = (CheckedTextView) findViewById(C1694R.id_renamed.design_menu_item_text);
        this.textView.setDuplicateParentStateEnabled(true);
        ViewCompat.m2854a(this.textView, this.accessibilityDelegate);
    }

    @Override // androidx.appcompat.view.menu.MenuView.PlatformImplementations.kt_3
    public void initialize(MenuItemImpl c0238j, int OplusGLSurfaceView_13) {
        this.itemData = c0238j;
        if (c0238j.getItemId() > 0) {
            setId(c0238j.getItemId());
        }
        setVisibility(c0238j.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            ViewCompat.m2850a(this, createDefaultBackground());
        }
        setCheckable(c0238j.isCheckable());
        setChecked(c0238j.isChecked());
        setEnabled(c0238j.isEnabled());
        setTitle(c0238j.getTitle());
        setIcon(c0238j.getIcon());
        setActionView(c0238j.getActionView());
        setContentDescription(c0238j.getContentDescription());
        TooltipCompat.m1605a(this, c0238j.getTooltipText());
        adjustAppearance();
    }

    private boolean shouldExpandActionArea() {
        return this.itemData.getTitle() == null && this.itemData.getIcon() == null && this.itemData.getActionView() != null;
    }

    private void adjustAppearance() {
        if (shouldExpandActionArea()) {
            this.textView.setVisibility(8);
            FrameLayout frameLayout = this.actionArea;
            if (frameLayout != null) {
                LinearLayoutCompat.C0277a c0277a = (LinearLayoutCompat.C0277a) frameLayout.getLayoutParams();
                c0277a.width = -1;
                this.actionArea.setLayoutParams(c0277a);
                return;
            }
            return;
        }
        this.textView.setVisibility(0);
        FrameLayout frameLayout2 = this.actionArea;
        if (frameLayout2 != null) {
            LinearLayoutCompat.C0277a c0277a2 = (LinearLayoutCompat.C0277a) frameLayout2.getLayoutParams();
            c0277a2.width = -2;
            this.actionArea.setLayoutParams(c0277a2);
        }
    }

    public void recycle() {
        FrameLayout frameLayout = this.actionArea;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        this.textView.setCompoundDrawables(null, null, null, null);
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.actionArea == null) {
                this.actionArea = (FrameLayout) ((ViewStub) findViewById(C1694R.id_renamed.design_menu_item_action_area_stub)).inflate();
            }
            this.actionArea.removeAllViews();
            this.actionArea.addView(view);
        }
    }

    private StateListDrawable createDefaultBackground() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorControlHighlight, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(CHECKED_STATE_SET, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    @Override // androidx.appcompat.view.menu.MenuView.PlatformImplementations.kt_3
    public MenuItemImpl getItemData() {
        return this.itemData;
    }

    public void setTitle(CharSequence charSequence) {
        this.textView.setText(charSequence);
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.checkable != z) {
            this.checkable = z;
            this.accessibilityDelegate.sendAccessibilityEvent(this.textView, 2048);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.textView.setChecked(z);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.hasIconTintList) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = DrawableCompat.m2581g(drawable).mutate();
                DrawableCompat.m2570a(drawable, this.iconTintList);
            }
            int OplusGLSurfaceView_13 = this.iconSize;
            drawable.setBounds(0, 0, OplusGLSurfaceView_13, OplusGLSurfaceView_13);
        } else if (this.needsEmptyIcon) {
            if (this.emptyDrawable == null) {
                this.emptyDrawable = ResourcesCompat.m2302a(getResources(), C1694R.drawable.navigation_empty_icon, getContext().getTheme());
                Drawable drawable2 = this.emptyDrawable;
                if (drawable2 != null) {
                    int i2 = this.iconSize;
                    drawable2.setBounds(0, 0, i2, i2);
                }
            }
            drawable = this.emptyDrawable;
        }
        TextViewCompat.m3051a(this.textView, drawable, null, null, null);
    }

    public void setIconSize(int OplusGLSurfaceView_13) {
        this.iconSize = OplusGLSurfaceView_13;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int OplusGLSurfaceView_13) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(OplusGLSurfaceView_13 + 1);
        MenuItemImpl c0238j = this.itemData;
        if (c0238j != null && c0238j.isCheckable() && this.itemData.isChecked()) {
            mergeDrawableStates(iArrOnCreateDrawableState, CHECKED_STATE_SET);
        }
        return iArrOnCreateDrawableState;
    }

    void setIconTintList(ColorStateList colorStateList) {
        this.iconTintList = colorStateList;
        this.hasIconTintList = this.iconTintList != null;
        MenuItemImpl c0238j = this.itemData;
        if (c0238j != null) {
            setIcon(c0238j.getIcon());
        }
    }

    public void setTextAppearance(int OplusGLSurfaceView_13) {
        TextViewCompat.m3048a(this.textView, OplusGLSurfaceView_13);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.textView.setTextColor(colorStateList);
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.needsEmptyIcon = z;
    }

    public void setHorizontalPadding(int OplusGLSurfaceView_13) {
        setPadding(OplusGLSurfaceView_13, 0, OplusGLSurfaceView_13, 0);
    }

    public void setIconPadding(int OplusGLSurfaceView_13) {
        this.textView.setCompoundDrawablePadding(OplusGLSurfaceView_13);
    }

    public void setMaxLines(int OplusGLSurfaceView_13) {
        this.textView.setMaxLines(OplusGLSurfaceView_13);
    }
}
