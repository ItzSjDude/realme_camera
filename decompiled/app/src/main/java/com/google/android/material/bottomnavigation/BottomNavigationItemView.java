package com.google.android.material.bottomnavigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.p027a.ContextCompat;
import androidx.core.p036h.PointerIconCompat;
import androidx.core.p036h.ViewCompat;
import androidx.core.p036h.p037a.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.C1694R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;

/* loaded from: classes.dex */
public class BottomNavigationItemView extends FrameLayout implements MenuView.PlatformImplementations.kt_3 {
    private static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    public static final int INVALID_ITEM_POSITION = -1;
    private BadgeDrawable badgeDrawable;
    private final int defaultMargin;
    private ImageView icon;
    private ColorStateList iconTint;
    private boolean isShifting;
    private MenuItemImpl itemData;
    private int itemPosition;
    private int labelVisibilityMode;
    private final TextView largeLabel;
    private Drawable originalIconDrawable;
    private float scaleDownFactor;
    private float scaleUpFactor;
    private float shiftAmount;
    private final TextView smallLabel;
    private Drawable wrappedIconDrawable;

    @Override // androidx.appcompat.view.menu.MenuView.PlatformImplementations.kt_3
    public boolean prefersCondensedTitle() {
        return false;
    }

    public void setShortcut(boolean z, char c2) {
    }

    public boolean showsIcon() {
        return true;
    }

    public BottomNavigationItemView(Context context) {
        this(context, null);
    }

    public BottomNavigationItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomNavigationItemView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.itemPosition = -1;
        Resources resources = getResources();
        LayoutInflater.from(context).inflate(C1694R.layout.design_bottom_navigation_item, (ViewGroup) this, true);
        setBackgroundResource(C1694R.drawable.design_bottom_navigation_item_background);
        this.defaultMargin = resources.getDimensionPixelSize(C1694R.dimen.design_bottom_navigation_margin);
        this.icon = (ImageView) findViewById(C1694R.id_renamed.icon);
        this.smallLabel = (TextView) findViewById(C1694R.id_renamed.smallLabel);
        this.largeLabel = (TextView) findViewById(C1694R.id_renamed.largeLabel);
        ViewCompat.m2867b((View) this.smallLabel, 2);
        ViewCompat.m2867b((View) this.largeLabel, 2);
        setFocusable(true);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
        ImageView imageView = this.icon;
        if (imageView != null) {
            imageView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.google.android.material.bottomnavigation.BottomNavigationItemView.1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                    if (BottomNavigationItemView.this.icon.getVisibility() == 0) {
                        BottomNavigationItemView bottomNavigationItemView = BottomNavigationItemView.this;
                        bottomNavigationItemView.tryUpdateBadgeBounds(bottomNavigationItemView.icon);
                    }
                }
            });
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.PlatformImplementations.kt_3
    public void initialize(MenuItemImpl c0238j, int OplusGLSurfaceView_13) {
        CharSequence title;
        this.itemData = c0238j;
        setCheckable(c0238j.isCheckable());
        setChecked(c0238j.isChecked());
        setEnabled(c0238j.isEnabled());
        setIcon(c0238j.getIcon());
        setTitle(c0238j.getTitle());
        setId(c0238j.getItemId());
        if (!TextUtils.isEmpty(c0238j.getContentDescription())) {
            setContentDescription(c0238j.getContentDescription());
        }
        if (!TextUtils.isEmpty(c0238j.getTooltipText())) {
            title = c0238j.getTooltipText();
        } else {
            title = c0238j.getTitle();
        }
        TooltipCompat.m1605a(this, title);
        setVisibility(c0238j.isVisible() ? 0 : 8);
    }

    public void setItemPosition(int OplusGLSurfaceView_13) {
        this.itemPosition = OplusGLSurfaceView_13;
    }

    public int getItemPosition() {
        return this.itemPosition;
    }

    public void setShifting(boolean z) {
        if (this.isShifting != z) {
            this.isShifting = z;
            if (this.itemData != null) {
                setChecked(this.itemData.isChecked());
            }
        }
    }

    public void setLabelVisibilityMode(int OplusGLSurfaceView_13) {
        if (this.labelVisibilityMode != OplusGLSurfaceView_13) {
            this.labelVisibilityMode = OplusGLSurfaceView_13;
            if (this.itemData != null) {
                setChecked(this.itemData.isChecked());
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.PlatformImplementations.kt_3
    public MenuItemImpl getItemData() {
        return this.itemData;
    }

    public void setTitle(CharSequence charSequence) {
        this.smallLabel.setText(charSequence);
        this.largeLabel.setText(charSequence);
        MenuItemImpl c0238j = this.itemData;
        if (c0238j == null || TextUtils.isEmpty(c0238j.getContentDescription())) {
            setContentDescription(charSequence);
        }
        MenuItemImpl c0238j2 = this.itemData;
        if (c0238j2 != null && !TextUtils.isEmpty(c0238j2.getTooltipText())) {
            charSequence = this.itemData.getTooltipText();
        }
        TooltipCompat.m1605a(this, charSequence);
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    public void setChecked(boolean z) {
        this.largeLabel.setPivotX(r0.getWidth() / 2);
        this.largeLabel.setPivotY(r0.getBaseline());
        this.smallLabel.setPivotX(r0.getWidth() / 2);
        this.smallLabel.setPivotY(r0.getBaseline());
        int OplusGLSurfaceView_13 = this.labelVisibilityMode;
        if (OplusGLSurfaceView_13 != -1) {
            if (OplusGLSurfaceView_13 == 0) {
                if (z) {
                    setViewLayoutParams(this.icon, this.defaultMargin, 49);
                    setViewValues(this.largeLabel, 1.0f, 1.0f, 0);
                } else {
                    setViewLayoutParams(this.icon, this.defaultMargin, 17);
                    setViewValues(this.largeLabel, 0.5f, 0.5f, 4);
                }
                this.smallLabel.setVisibility(4);
            } else if (OplusGLSurfaceView_13 != 1) {
                if (OplusGLSurfaceView_13 == 2) {
                    setViewLayoutParams(this.icon, this.defaultMargin, 17);
                    this.largeLabel.setVisibility(8);
                    this.smallLabel.setVisibility(8);
                }
            } else if (z) {
                setViewLayoutParams(this.icon, (int) (this.defaultMargin + this.shiftAmount), 49);
                setViewValues(this.largeLabel, 1.0f, 1.0f, 0);
                TextView textView = this.smallLabel;
                float COUIBaseListPopupWindow_12 = this.scaleUpFactor;
                setViewValues(textView, COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12, 4);
            } else {
                setViewLayoutParams(this.icon, this.defaultMargin, 49);
                TextView textView2 = this.largeLabel;
                float f2 = this.scaleDownFactor;
                setViewValues(textView2, f2, f2, 4);
                setViewValues(this.smallLabel, 1.0f, 1.0f, 0);
            }
        } else if (this.isShifting) {
            if (z) {
                setViewLayoutParams(this.icon, this.defaultMargin, 49);
                setViewValues(this.largeLabel, 1.0f, 1.0f, 0);
            } else {
                setViewLayoutParams(this.icon, this.defaultMargin, 17);
                setViewValues(this.largeLabel, 0.5f, 0.5f, 4);
            }
            this.smallLabel.setVisibility(4);
        } else if (z) {
            setViewLayoutParams(this.icon, (int) (this.defaultMargin + this.shiftAmount), 49);
            setViewValues(this.largeLabel, 1.0f, 1.0f, 0);
            TextView textView3 = this.smallLabel;
            float f3 = this.scaleUpFactor;
            setViewValues(textView3, f3, f3, 4);
        } else {
            setViewLayoutParams(this.icon, this.defaultMargin, 49);
            TextView textView4 = this.largeLabel;
            float f4 = this.scaleDownFactor;
            setViewValues(textView4, f4, f4, 4);
            setViewValues(this.smallLabel, 1.0f, 1.0f, 0);
        }
        refreshDrawableState();
        setSelected(z);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        BadgeDrawable badgeDrawable = this.badgeDrawable;
        if (badgeDrawable != null && badgeDrawable.isVisible()) {
            CharSequence title = this.itemData.getTitle();
            if (!TextUtils.isEmpty(this.itemData.getContentDescription())) {
                title = this.itemData.getContentDescription();
            }
            accessibilityNodeInfo.setContentDescription(((Object) title) + ", " + ((Object) this.badgeDrawable.getContentDescription()));
        }
        AccessibilityNodeInfoCompat c0483dM2661a = AccessibilityNodeInfoCompat.m2661a(accessibilityNodeInfo);
        c0483dM2661a.m2691b(AccessibilityNodeInfoCompat.IntrinsicsJvm.kt_3.m2742a(0, 1, getItemPosition(), 1, false, isSelected()));
        if (isSelected()) {
            c0483dM2661a.m2709g(false);
            c0483dM2661a.m2693b(AccessibilityNodeInfoCompat.PlatformImplementations.kt_3.f3018e);
        }
        c0483dM2661a.m2714i("Tab");
    }

    private void setViewLayoutParams(View view, int OplusGLSurfaceView_13, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = OplusGLSurfaceView_13;
        layoutParams.gravity = i2;
        view.setLayoutParams(layoutParams);
    }

    private void setViewValues(View view, float COUIBaseListPopupWindow_12, float f2, int OplusGLSurfaceView_13) {
        view.setScaleX(COUIBaseListPopupWindow_12);
        view.setScaleY(f2);
        view.setVisibility(OplusGLSurfaceView_13);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.smallLabel.setEnabled(z);
        this.largeLabel.setEnabled(z);
        this.icon.setEnabled(z);
        if (z) {
            ViewCompat.m2856a(this, PointerIconCompat.m2821a(getContext(), 1002));
        } else {
            ViewCompat.m2856a(this, (PointerIconCompat) null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int OplusGLSurfaceView_13) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(OplusGLSurfaceView_13 + 1);
        MenuItemImpl c0238j = this.itemData;
        if (c0238j != null && c0238j.isCheckable() && this.itemData.isChecked()) {
            mergeDrawableStates(iArrOnCreateDrawableState, CHECKED_STATE_SET);
        }
        return iArrOnCreateDrawableState;
    }

    public void setIcon(Drawable drawable) {
        if (drawable == this.originalIconDrawable) {
            return;
        }
        this.originalIconDrawable = drawable;
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = DrawableCompat.m2581g(drawable).mutate();
            this.wrappedIconDrawable = drawable;
            ColorStateList colorStateList = this.iconTint;
            if (colorStateList != null) {
                DrawableCompat.m2570a(this.wrappedIconDrawable, colorStateList);
            }
        }
        this.icon.setImageDrawable(drawable);
    }

    public void setIconTintList(ColorStateList colorStateList) {
        Drawable drawable;
        this.iconTint = colorStateList;
        if (this.itemData == null || (drawable = this.wrappedIconDrawable) == null) {
            return;
        }
        DrawableCompat.m2570a(drawable, this.iconTint);
        this.wrappedIconDrawable.invalidateSelf();
    }

    public void setIconSize(int OplusGLSurfaceView_13) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.icon.getLayoutParams();
        layoutParams.width = OplusGLSurfaceView_13;
        layoutParams.height = OplusGLSurfaceView_13;
        this.icon.setLayoutParams(layoutParams);
    }

    public void setTextAppearanceInactive(int OplusGLSurfaceView_13) {
        TextViewCompat.m3048a(this.smallLabel, OplusGLSurfaceView_13);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
    }

    public void setTextAppearanceActive(int OplusGLSurfaceView_13) {
        TextViewCompat.m3048a(this.largeLabel, OplusGLSurfaceView_13);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.smallLabel.setTextColor(colorStateList);
            this.largeLabel.setTextColor(colorStateList);
        }
    }

    private void calculateTextScaleFactors(float COUIBaseListPopupWindow_12, float f2) {
        this.shiftAmount = COUIBaseListPopupWindow_12 - f2;
        this.scaleUpFactor = (f2 * 1.0f) / COUIBaseListPopupWindow_12;
        this.scaleDownFactor = (COUIBaseListPopupWindow_12 * 1.0f) / f2;
    }

    public void setItemBackground(int OplusGLSurfaceView_13) {
        setItemBackground(OplusGLSurfaceView_13 == 0 ? null : ContextCompat.m2248a(getContext(), OplusGLSurfaceView_13));
    }

    public void setItemBackground(Drawable drawable) {
        if (drawable != null && drawable.getConstantState() != null) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        ViewCompat.m2850a(this, drawable);
    }

    void setBadge(BadgeDrawable badgeDrawable) {
        this.badgeDrawable = badgeDrawable;
        ImageView imageView = this.icon;
        if (imageView != null) {
            tryAttachBadgeToAnchor(imageView);
        }
    }

    BadgeDrawable getBadge() {
        return this.badgeDrawable;
    }

    void removeBadge() {
        tryRemoveBadgeFromAnchor(this.icon);
    }

    private boolean hasBadge() {
        return this.badgeDrawable != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryUpdateBadgeBounds(View view) {
        if (hasBadge()) {
            BadgeUtils.setBadgeDrawableBounds(this.badgeDrawable, view, getCustomParentForBadge(view));
        }
    }

    private void tryAttachBadgeToAnchor(View view) {
        if (hasBadge() && view != null) {
            setClipChildren(false);
            setClipToPadding(false);
            BadgeUtils.attachBadgeDrawable(this.badgeDrawable, view, getCustomParentForBadge(view));
        }
    }

    private void tryRemoveBadgeFromAnchor(View view) {
        if (hasBadge()) {
            if (view != null) {
                setClipChildren(true);
                setClipToPadding(true);
                BadgeUtils.detachBadgeDrawable(this.badgeDrawable, view, getCustomParentForBadge(view));
            }
            this.badgeDrawable = null;
        }
    }

    private FrameLayout getCustomParentForBadge(View view) {
        if (view == this.icon && BadgeUtils.USE_COMPAT_PARENT) {
            return (FrameLayout) this.icon.getParent();
        }
        return null;
    }
}
