package androidx.appcompat.widget;

/* loaded from: classes.dex */
public class Toolbar extends android.view.ViewGroup {
    private static final java.lang.String TAG = "Toolbar";
    private androidx.appcompat.view.menu.n_renamed.a_renamed mActionMenuPresenterCallback;
    int mButtonGravity;
    android.widget.ImageButton mCollapseButtonView;
    private java.lang.CharSequence mCollapseDescription;
    private android.graphics.drawable.Drawable mCollapseIcon;
    private boolean mCollapsible;
    private int mContentInsetEndWithActions;
    private int mContentInsetStartWithNavigation;
    private androidx.appcompat.widget.aj_renamed mContentInsets;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    android.view.View mExpandedActionView;
    private androidx.appcompat.widget.Toolbar.a_renamed mExpandedMenuPresenter;
    private int mGravity;
    private final java.util.ArrayList<android.view.View> mHiddenViews;
    private android.widget.ImageView mLogoView;
    private int mMaxButtonHeight;
    private androidx.appcompat.view.menu.h_renamed.a_renamed mMenuBuilderCallback;
    private androidx.appcompat.widget.ActionMenuView mMenuView;
    private final androidx.appcompat.widget.ActionMenuView.e_renamed mMenuViewItemClickListener;
    private android.widget.ImageButton mNavButtonView;
    androidx.appcompat.widget.Toolbar.c_renamed mOnMenuItemClickListener;
    private androidx.appcompat.widget.ActionMenuPresenter mOuterActionMenuPresenter;
    private android.content.Context mPopupContext;
    private int mPopupTheme;
    private final java.lang.Runnable mShowOverflowMenuRunnable;
    private java.lang.CharSequence mSubtitleText;
    private int mSubtitleTextAppearance;
    private android.content.res.ColorStateList mSubtitleTextColor;
    private android.widget.TextView mSubtitleTextView;
    private final int[] mTempMargins;
    private final java.util.ArrayList<android.view.View> mTempViews;
    private int mTitleMarginBottom;
    private int mTitleMarginEnd;
    private int mTitleMarginStart;
    private int mTitleMarginTop;
    private java.lang.CharSequence mTitleText;
    private int mTitleTextAppearance;
    private android.content.res.ColorStateList mTitleTextColor;
    private android.widget.TextView mTitleTextView;
    private androidx.appcompat.widget.as_renamed mWrapper;

    public interface c_renamed {
        boolean a_renamed(android.view.MenuItem menuItem);
    }

    public Toolbar(android.content.Context context) {
        this(context, null);
    }

    public Toolbar(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R_renamed.attr.toolbarStyle);
    }

    public Toolbar(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.mGravity = 8388627;
        this.mTempViews = new java.util.ArrayList<>();
        this.mHiddenViews = new java.util.ArrayList<>();
        this.mTempMargins = new int[2];
        this.mMenuViewItemClickListener = new androidx.appcompat.widget.ActionMenuView.e_renamed() { // from class: androidx.appcompat.widget.Toolbar.1
            @Override // androidx.appcompat.widget.ActionMenuView.e_renamed
            public boolean a_renamed(android.view.MenuItem menuItem) {
                if (androidx.appcompat.widget.Toolbar.this.mOnMenuItemClickListener != null) {
                    return androidx.appcompat.widget.Toolbar.this.mOnMenuItemClickListener.a_renamed(menuItem);
                }
                return false;
            }
        };
        this.mShowOverflowMenuRunnable = new java.lang.Runnable() { // from class: androidx.appcompat.widget.Toolbar.2
            @Override // java.lang.Runnable
            public void run() {
                androidx.appcompat.widget.Toolbar.this.showOverflowMenu();
            }
        };
        androidx.appcompat.widget.ar_renamed arVarA = androidx.appcompat.widget.ar_renamed.a_renamed(getContext(), attributeSet, androidx.appcompat.R_renamed.styleable.Toolbar, i_renamed, 0);
        this.mTitleTextAppearance = arVarA.g_renamed(androidx.appcompat.R_renamed.styleable.Toolbar_titleTextAppearance, 0);
        this.mSubtitleTextAppearance = arVarA.g_renamed(androidx.appcompat.R_renamed.styleable.Toolbar_subtitleTextAppearance, 0);
        this.mGravity = arVarA.c_renamed(androidx.appcompat.R_renamed.styleable.Toolbar_android_gravity, this.mGravity);
        this.mButtonGravity = arVarA.c_renamed(androidx.appcompat.R_renamed.styleable.Toolbar_buttonGravity, 48);
        int iD = arVarA.d_renamed(androidx.appcompat.R_renamed.styleable.Toolbar_titleMargin, 0);
        iD = arVarA.g_renamed(androidx.appcompat.R_renamed.styleable.Toolbar_titleMargins) ? arVarA.d_renamed(androidx.appcompat.R_renamed.styleable.Toolbar_titleMargins, iD) : iD;
        this.mTitleMarginBottom = iD;
        this.mTitleMarginTop = iD;
        this.mTitleMarginEnd = iD;
        this.mTitleMarginStart = iD;
        int iD2 = arVarA.d_renamed(androidx.appcompat.R_renamed.styleable.Toolbar_titleMarginStart, -1);
        if (iD2 >= 0) {
            this.mTitleMarginStart = iD2;
        }
        int iD3 = arVarA.d_renamed(androidx.appcompat.R_renamed.styleable.Toolbar_titleMarginEnd, -1);
        if (iD3 >= 0) {
            this.mTitleMarginEnd = iD3;
        }
        int iD4 = arVarA.d_renamed(androidx.appcompat.R_renamed.styleable.Toolbar_titleMarginTop, -1);
        if (iD4 >= 0) {
            this.mTitleMarginTop = iD4;
        }
        int iD5 = arVarA.d_renamed(androidx.appcompat.R_renamed.styleable.Toolbar_titleMarginBottom, -1);
        if (iD5 >= 0) {
            this.mTitleMarginBottom = iD5;
        }
        this.mMaxButtonHeight = arVarA.e_renamed(androidx.appcompat.R_renamed.styleable.Toolbar_maxButtonHeight, -1);
        int iD6 = arVarA.d_renamed(androidx.appcompat.R_renamed.styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int iD7 = arVarA.d_renamed(androidx.appcompat.R_renamed.styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int iE = arVarA.e_renamed(androidx.appcompat.R_renamed.styleable.Toolbar_contentInsetLeft, 0);
        int iE2 = arVarA.e_renamed(androidx.appcompat.R_renamed.styleable.Toolbar_contentInsetRight, 0);
        ensureContentInsets();
        this.mContentInsets.b_renamed(iE, iE2);
        if (iD6 != Integer.MIN_VALUE || iD7 != Integer.MIN_VALUE) {
            this.mContentInsets.a_renamed(iD6, iD7);
        }
        this.mContentInsetStartWithNavigation = arVarA.d_renamed(androidx.appcompat.R_renamed.styleable.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.mContentInsetEndWithActions = arVarA.d_renamed(androidx.appcompat.R_renamed.styleable.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.mCollapseIcon = arVarA.a_renamed(androidx.appcompat.R_renamed.styleable.Toolbar_collapseIcon);
        this.mCollapseDescription = arVarA.c_renamed(androidx.appcompat.R_renamed.styleable.Toolbar_collapseContentDescription);
        java.lang.CharSequence charSequenceC = arVarA.c_renamed(androidx.appcompat.R_renamed.styleable.Toolbar_title);
        if (!android.text.TextUtils.isEmpty(charSequenceC)) {
            setTitle(charSequenceC);
        }
        java.lang.CharSequence charSequenceC2 = arVarA.c_renamed(androidx.appcompat.R_renamed.styleable.Toolbar_subtitle);
        if (!android.text.TextUtils.isEmpty(charSequenceC2)) {
            setSubtitle(charSequenceC2);
        }
        this.mPopupContext = getContext();
        setPopupTheme(arVarA.g_renamed(androidx.appcompat.R_renamed.styleable.Toolbar_popupTheme, 0));
        android.graphics.drawable.Drawable drawableA = arVarA.a_renamed(androidx.appcompat.R_renamed.styleable.Toolbar_navigationIcon);
        if (drawableA != null) {
            setNavigationIcon(drawableA);
        }
        java.lang.CharSequence charSequenceC3 = arVarA.c_renamed(androidx.appcompat.R_renamed.styleable.Toolbar_navigationContentDescription);
        if (!android.text.TextUtils.isEmpty(charSequenceC3)) {
            setNavigationContentDescription(charSequenceC3);
        }
        android.graphics.drawable.Drawable drawableA2 = arVarA.a_renamed(androidx.appcompat.R_renamed.styleable.Toolbar_logo);
        if (drawableA2 != null) {
            setLogo(drawableA2);
        }
        java.lang.CharSequence charSequenceC4 = arVarA.c_renamed(androidx.appcompat.R_renamed.styleable.Toolbar_logoDescription);
        if (!android.text.TextUtils.isEmpty(charSequenceC4)) {
            setLogoDescription(charSequenceC4);
        }
        if (arVarA.g_renamed(androidx.appcompat.R_renamed.styleable.Toolbar_titleTextColor)) {
            setTitleTextColor(arVarA.e_renamed(androidx.appcompat.R_renamed.styleable.Toolbar_titleTextColor));
        }
        if (arVarA.g_renamed(androidx.appcompat.R_renamed.styleable.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(arVarA.e_renamed(androidx.appcompat.R_renamed.styleable.Toolbar_subtitleTextColor));
        }
        if (arVarA.g_renamed(androidx.appcompat.R_renamed.styleable.Toolbar_menu)) {
            inflateMenu(arVarA.g_renamed(androidx.appcompat.R_renamed.styleable.Toolbar_menu, 0));
        }
        arVarA.b_renamed();
    }

    public void setPopupTheme(int i_renamed) {
        if (this.mPopupTheme != i_renamed) {
            this.mPopupTheme = i_renamed;
            if (i_renamed == 0) {
                this.mPopupContext = getContext();
            } else {
                this.mPopupContext = new android.view.ContextThemeWrapper(getContext(), i_renamed);
            }
        }
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    public void setTitleMargin(int i_renamed, int i2, int i3, int i4) {
        this.mTitleMarginStart = i_renamed;
        this.mTitleMarginTop = i2;
        this.mTitleMarginEnd = i3;
        this.mTitleMarginBottom = i4;
        requestLayout();
    }

    public int getTitleMarginStart() {
        return this.mTitleMarginStart;
    }

    public void setTitleMarginStart(int i_renamed) {
        this.mTitleMarginStart = i_renamed;
        requestLayout();
    }

    public int getTitleMarginTop() {
        return this.mTitleMarginTop;
    }

    public void setTitleMarginTop(int i_renamed) {
        this.mTitleMarginTop = i_renamed;
        requestLayout();
    }

    public int getTitleMarginEnd() {
        return this.mTitleMarginEnd;
    }

    public void setTitleMarginEnd(int i_renamed) {
        this.mTitleMarginEnd = i_renamed;
        requestLayout();
    }

    public int getTitleMarginBottom() {
        return this.mTitleMarginBottom;
    }

    public void setTitleMarginBottom(int i_renamed) {
        this.mTitleMarginBottom = i_renamed;
        requestLayout();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i_renamed) {
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i_renamed);
        }
        ensureContentInsets();
        this.mContentInsets.a_renamed(i_renamed == 1);
    }

    public void setLogo(int i_renamed) {
        setLogo(androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(getContext(), i_renamed));
    }

    public boolean canShowOverflowMenu() {
        androidx.appcompat.widget.ActionMenuView actionMenuView;
        return getVisibility() == 0 && (actionMenuView = this.mMenuView) != null && actionMenuView.a_renamed();
    }

    public boolean isOverflowMenuShowing() {
        androidx.appcompat.widget.ActionMenuView actionMenuView = this.mMenuView;
        return actionMenuView != null && actionMenuView.g_renamed();
    }

    public boolean isOverflowMenuShowPending() {
        androidx.appcompat.widget.ActionMenuView actionMenuView = this.mMenuView;
        return actionMenuView != null && actionMenuView.h_renamed();
    }

    public boolean showOverflowMenu() {
        androidx.appcompat.widget.ActionMenuView actionMenuView = this.mMenuView;
        return actionMenuView != null && actionMenuView.e_renamed();
    }

    public boolean hideOverflowMenu() {
        androidx.appcompat.widget.ActionMenuView actionMenuView = this.mMenuView;
        return actionMenuView != null && actionMenuView.f_renamed();
    }

    public void setMenu(androidx.appcompat.view.menu.h_renamed hVar, androidx.appcompat.widget.ActionMenuPresenter actionMenuPresenter) {
        if (hVar == null && this.mMenuView == null) {
            return;
        }
        ensureMenuView();
        androidx.appcompat.view.menu.h_renamed hVarD = this.mMenuView.d_renamed();
        if (hVarD == hVar) {
            return;
        }
        if (hVarD != null) {
            hVarD.removeMenuPresenter(this.mOuterActionMenuPresenter);
            hVarD.removeMenuPresenter(this.mExpandedMenuPresenter);
        }
        if (this.mExpandedMenuPresenter == null) {
            this.mExpandedMenuPresenter = new androidx.appcompat.widget.Toolbar.a_renamed();
        }
        actionMenuPresenter.b_renamed(true);
        if (hVar != null) {
            hVar.addMenuPresenter(actionMenuPresenter, this.mPopupContext);
            hVar.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
        } else {
            actionMenuPresenter.initForMenu(this.mPopupContext, null);
            this.mExpandedMenuPresenter.initForMenu(this.mPopupContext, null);
            actionMenuPresenter.updateMenuView(true);
            this.mExpandedMenuPresenter.updateMenuView(true);
        }
        this.mMenuView.setPopupTheme(this.mPopupTheme);
        this.mMenuView.setPresenter(actionMenuPresenter);
        this.mOuterActionMenuPresenter = actionMenuPresenter;
    }

    public void dismissPopupMenus() {
        androidx.appcompat.widget.ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null) {
            actionMenuView.i_renamed();
        }
    }

    public boolean isTitleTruncated() {
        android.text.Layout layout;
        android.widget.TextView textView = this.mTitleTextView;
        if (textView == null || (layout = textView.getLayout()) == null) {
            return false;
        }
        int lineCount = layout.getLineCount();
        for (int i_renamed = 0; i_renamed < lineCount; i_renamed++) {
            if (layout.getEllipsisCount(i_renamed) > 0) {
                return true;
            }
        }
        return false;
    }

    public void setLogo(android.graphics.drawable.Drawable drawable) {
        if (drawable != null) {
            ensureLogoView();
            if (!isChildOrHidden(this.mLogoView)) {
                addSystemView(this.mLogoView, true);
            }
        } else {
            android.widget.ImageView imageView = this.mLogoView;
            if (imageView != null && isChildOrHidden(imageView)) {
                removeView(this.mLogoView);
                this.mHiddenViews.remove(this.mLogoView);
            }
        }
        android.widget.ImageView imageView2 = this.mLogoView;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public android.graphics.drawable.Drawable getLogo() {
        android.widget.ImageView imageView = this.mLogoView;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public void setLogoDescription(int i_renamed) {
        setLogoDescription(getContext().getText(i_renamed));
    }

    public void setLogoDescription(java.lang.CharSequence charSequence) {
        if (!android.text.TextUtils.isEmpty(charSequence)) {
            ensureLogoView();
        }
        android.widget.ImageView imageView = this.mLogoView;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public java.lang.CharSequence getLogoDescription() {
        android.widget.ImageView imageView = this.mLogoView;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    private void ensureLogoView() {
        if (this.mLogoView == null) {
            this.mLogoView = new androidx.appcompat.widget.AppCompatImageView(getContext());
        }
    }

    public boolean hasExpandedActionView() {
        androidx.appcompat.widget.Toolbar.a_renamed aVar = this.mExpandedMenuPresenter;
        return (aVar == null || aVar.f508b == null) ? false : true;
    }

    public void collapseActionView() {
        androidx.appcompat.widget.Toolbar.a_renamed aVar = this.mExpandedMenuPresenter;
        androidx.appcompat.view.menu.j_renamed jVar = aVar == null ? null : aVar.f508b;
        if (jVar != null) {
            jVar.collapseActionView();
        }
    }

    public java.lang.CharSequence getTitle() {
        return this.mTitleText;
    }

    public void setTitle(int i_renamed) {
        setTitle(getContext().getText(i_renamed));
    }

    public void setTitle(java.lang.CharSequence charSequence) {
        if (!android.text.TextUtils.isEmpty(charSequence)) {
            if (this.mTitleTextView == null) {
                android.content.Context context = getContext();
                this.mTitleTextView = new androidx.appcompat.widget.AppCompatTextView(context);
                this.mTitleTextView.setSingleLine();
                this.mTitleTextView.setEllipsize(android.text.TextUtils.TruncateAt.END);
                int i_renamed = this.mTitleTextAppearance;
                if (i_renamed != 0) {
                    this.mTitleTextView.setTextAppearance(context, i_renamed);
                }
                android.content.res.ColorStateList colorStateList = this.mTitleTextColor;
                if (colorStateList != null) {
                    this.mTitleTextView.setTextColor(colorStateList);
                }
            }
            if (!isChildOrHidden(this.mTitleTextView)) {
                addSystemView(this.mTitleTextView, true);
            }
        } else {
            android.widget.TextView textView = this.mTitleTextView;
            if (textView != null && isChildOrHidden(textView)) {
                removeView(this.mTitleTextView);
                this.mHiddenViews.remove(this.mTitleTextView);
            }
        }
        android.widget.TextView textView2 = this.mTitleTextView;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.mTitleText = charSequence;
    }

    public java.lang.CharSequence getSubtitle() {
        return this.mSubtitleText;
    }

    public void setSubtitle(int i_renamed) {
        setSubtitle(getContext().getText(i_renamed));
    }

    public void setSubtitle(java.lang.CharSequence charSequence) {
        if (!android.text.TextUtils.isEmpty(charSequence)) {
            if (this.mSubtitleTextView == null) {
                android.content.Context context = getContext();
                this.mSubtitleTextView = new androidx.appcompat.widget.AppCompatTextView(context);
                this.mSubtitleTextView.setSingleLine();
                this.mSubtitleTextView.setEllipsize(android.text.TextUtils.TruncateAt.END);
                int i_renamed = this.mSubtitleTextAppearance;
                if (i_renamed != 0) {
                    this.mSubtitleTextView.setTextAppearance(context, i_renamed);
                }
                android.content.res.ColorStateList colorStateList = this.mSubtitleTextColor;
                if (colorStateList != null) {
                    this.mSubtitleTextView.setTextColor(colorStateList);
                }
            }
            if (!isChildOrHidden(this.mSubtitleTextView)) {
                addSystemView(this.mSubtitleTextView, true);
            }
        } else {
            android.widget.TextView textView = this.mSubtitleTextView;
            if (textView != null && isChildOrHidden(textView)) {
                removeView(this.mSubtitleTextView);
                this.mHiddenViews.remove(this.mSubtitleTextView);
            }
        }
        android.widget.TextView textView2 = this.mSubtitleTextView;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.mSubtitleText = charSequence;
    }

    public void setTitleTextAppearance(android.content.Context context, int i_renamed) {
        this.mTitleTextAppearance = i_renamed;
        android.widget.TextView textView = this.mTitleTextView;
        if (textView != null) {
            textView.setTextAppearance(context, i_renamed);
        }
    }

    public void setSubtitleTextAppearance(android.content.Context context, int i_renamed) {
        this.mSubtitleTextAppearance = i_renamed;
        android.widget.TextView textView = this.mSubtitleTextView;
        if (textView != null) {
            textView.setTextAppearance(context, i_renamed);
        }
    }

    public void setTitleTextColor(int i_renamed) {
        setTitleTextColor(android.content.res.ColorStateList.valueOf(i_renamed));
    }

    public void setTitleTextColor(android.content.res.ColorStateList colorStateList) {
        this.mTitleTextColor = colorStateList;
        android.widget.TextView textView = this.mTitleTextView;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setSubtitleTextColor(int i_renamed) {
        setSubtitleTextColor(android.content.res.ColorStateList.valueOf(i_renamed));
    }

    public void setSubtitleTextColor(android.content.res.ColorStateList colorStateList) {
        this.mSubtitleTextColor = colorStateList;
        android.widget.TextView textView = this.mSubtitleTextView;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public java.lang.CharSequence getNavigationContentDescription() {
        android.widget.ImageButton imageButton = this.mNavButtonView;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public void setNavigationContentDescription(int i_renamed) {
        setNavigationContentDescription(i_renamed != 0 ? getContext().getText(i_renamed) : null);
    }

    public void setNavigationContentDescription(java.lang.CharSequence charSequence) {
        if (!android.text.TextUtils.isEmpty(charSequence)) {
            ensureNavButtonView();
        }
        android.widget.ImageButton imageButton = this.mNavButtonView;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i_renamed) {
        setNavigationIcon(androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(getContext(), i_renamed));
    }

    public void setNavigationIcon(android.graphics.drawable.Drawable drawable) {
        if (drawable != null) {
            ensureNavButtonView();
            if (!isChildOrHidden(this.mNavButtonView)) {
                addSystemView(this.mNavButtonView, true);
            }
        } else {
            android.widget.ImageButton imageButton = this.mNavButtonView;
            if (imageButton != null && isChildOrHidden(imageButton)) {
                removeView(this.mNavButtonView);
                this.mHiddenViews.remove(this.mNavButtonView);
            }
        }
        android.widget.ImageButton imageButton2 = this.mNavButtonView;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public android.graphics.drawable.Drawable getNavigationIcon() {
        android.widget.ImageButton imageButton = this.mNavButtonView;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public void setNavigationOnClickListener(android.view.View.OnClickListener onClickListener) {
        ensureNavButtonView();
        this.mNavButtonView.setOnClickListener(onClickListener);
    }

    public java.lang.CharSequence getCollapseContentDescription() {
        android.widget.ImageButton imageButton = this.mCollapseButtonView;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public void setCollapseContentDescription(int i_renamed) {
        setCollapseContentDescription(i_renamed != 0 ? getContext().getText(i_renamed) : null);
    }

    public void setCollapseContentDescription(java.lang.CharSequence charSequence) {
        if (!android.text.TextUtils.isEmpty(charSequence)) {
            ensureCollapseButtonView();
        }
        android.widget.ImageButton imageButton = this.mCollapseButtonView;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public android.graphics.drawable.Drawable getCollapseIcon() {
        android.widget.ImageButton imageButton = this.mCollapseButtonView;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public void setCollapseIcon(int i_renamed) {
        setCollapseIcon(androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(getContext(), i_renamed));
    }

    public void setCollapseIcon(android.graphics.drawable.Drawable drawable) {
        if (drawable != null) {
            ensureCollapseButtonView();
            this.mCollapseButtonView.setImageDrawable(drawable);
        } else {
            android.widget.ImageButton imageButton = this.mCollapseButtonView;
            if (imageButton != null) {
                imageButton.setImageDrawable(this.mCollapseIcon);
            }
        }
    }

    public android.view.Menu getMenu() {
        ensureMenu();
        return this.mMenuView.getMenu();
    }

    public void setOverflowIcon(android.graphics.drawable.Drawable drawable) {
        ensureMenu();
        this.mMenuView.setOverflowIcon(drawable);
    }

    public android.graphics.drawable.Drawable getOverflowIcon() {
        ensureMenu();
        return this.mMenuView.getOverflowIcon();
    }

    private void ensureMenu() {
        ensureMenuView();
        if (this.mMenuView.d_renamed() == null) {
            androidx.appcompat.view.menu.h_renamed hVar = (androidx.appcompat.view.menu.h_renamed) this.mMenuView.getMenu();
            if (this.mExpandedMenuPresenter == null) {
                this.mExpandedMenuPresenter = new androidx.appcompat.widget.Toolbar.a_renamed();
            }
            this.mMenuView.setExpandedActionViewsExclusive(true);
            hVar.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
        }
    }

    private void ensureMenuView() {
        if (this.mMenuView == null) {
            this.mMenuView = new androidx.appcompat.widget.ActionMenuView(getContext());
            this.mMenuView.setPopupTheme(this.mPopupTheme);
            this.mMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
            this.mMenuView.a_renamed(this.mActionMenuPresenterCallback, this.mMenuBuilderCallback);
            androidx.appcompat.widget.Toolbar.b_renamed bVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            bVarGenerateDefaultLayoutParams.f264a = 8388613 | (this.mButtonGravity & 112);
            this.mMenuView.setLayoutParams(bVarGenerateDefaultLayoutParams);
            addSystemView(this.mMenuView, false);
        }
    }

    private android.view.MenuInflater getMenuInflater() {
        return new androidx.appcompat.view.g_renamed(getContext());
    }

    public void inflateMenu(int i_renamed) {
        getMenuInflater().inflate(i_renamed, getMenu());
    }

    public void setOnMenuItemClickListener(androidx.appcompat.widget.Toolbar.c_renamed cVar) {
        this.mOnMenuItemClickListener = cVar;
    }

    public void setContentInsetsRelative(int i_renamed, int i2) {
        ensureContentInsets();
        this.mContentInsets.a_renamed(i_renamed, i2);
    }

    public int getContentInsetStart() {
        androidx.appcompat.widget.aj_renamed ajVar = this.mContentInsets;
        if (ajVar != null) {
            return ajVar.c_renamed();
        }
        return 0;
    }

    public int getContentInsetEnd() {
        androidx.appcompat.widget.aj_renamed ajVar = this.mContentInsets;
        if (ajVar != null) {
            return ajVar.d_renamed();
        }
        return 0;
    }

    public void setContentInsetsAbsolute(int i_renamed, int i2) {
        ensureContentInsets();
        this.mContentInsets.b_renamed(i_renamed, i2);
    }

    public int getContentInsetLeft() {
        androidx.appcompat.widget.aj_renamed ajVar = this.mContentInsets;
        if (ajVar != null) {
            return ajVar.a_renamed();
        }
        return 0;
    }

    public int getContentInsetRight() {
        androidx.appcompat.widget.aj_renamed ajVar = this.mContentInsets;
        if (ajVar != null) {
            return ajVar.b_renamed();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i_renamed = this.mContentInsetStartWithNavigation;
        return i_renamed != Integer.MIN_VALUE ? i_renamed : getContentInsetStart();
    }

    public void setContentInsetStartWithNavigation(int i_renamed) {
        if (i_renamed < 0) {
            i_renamed = Integer.MIN_VALUE;
        }
        if (i_renamed != this.mContentInsetStartWithNavigation) {
            this.mContentInsetStartWithNavigation = i_renamed;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public int getContentInsetEndWithActions() {
        int i_renamed = this.mContentInsetEndWithActions;
        return i_renamed != Integer.MIN_VALUE ? i_renamed : getContentInsetEnd();
    }

    public void setContentInsetEndWithActions(int i_renamed) {
        if (i_renamed < 0) {
            i_renamed = Integer.MIN_VALUE;
        }
        if (i_renamed != this.mContentInsetEndWithActions) {
            this.mContentInsetEndWithActions = i_renamed;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() != null) {
            return java.lang.Math.max(getContentInsetStart(), java.lang.Math.max(this.mContentInsetStartWithNavigation, 0));
        }
        return getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        androidx.appcompat.view.menu.h_renamed hVarD;
        androidx.appcompat.widget.ActionMenuView actionMenuView = this.mMenuView;
        if ((actionMenuView == null || (hVarD = actionMenuView.d_renamed()) == null || !hVarD.hasVisibleItems()) ? false : true) {
            return java.lang.Math.max(getContentInsetEnd(), java.lang.Math.max(this.mContentInsetEndWithActions, 0));
        }
        return getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        if (androidx.core.h_renamed.v_renamed.g_renamed(this) == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (androidx.core.h_renamed.v_renamed.g_renamed(this) == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    private void ensureNavButtonView() {
        if (this.mNavButtonView == null) {
            this.mNavButtonView = new androidx.appcompat.widget.l_renamed(getContext(), null, androidx.appcompat.R_renamed.attr.toolbarNavigationButtonStyle);
            androidx.appcompat.widget.Toolbar.b_renamed bVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            bVarGenerateDefaultLayoutParams.f264a = 8388611 | (this.mButtonGravity & 112);
            this.mNavButtonView.setLayoutParams(bVarGenerateDefaultLayoutParams);
        }
    }

    void ensureCollapseButtonView() {
        if (this.mCollapseButtonView == null) {
            this.mCollapseButtonView = new androidx.appcompat.widget.l_renamed(getContext(), null, androidx.appcompat.R_renamed.attr.toolbarNavigationButtonStyle);
            this.mCollapseButtonView.setImageDrawable(this.mCollapseIcon);
            this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
            androidx.appcompat.widget.Toolbar.b_renamed bVarGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            bVarGenerateDefaultLayoutParams.f264a = 8388611 | (this.mButtonGravity & 112);
            bVarGenerateDefaultLayoutParams.f510b = 2;
            this.mCollapseButtonView.setLayoutParams(bVarGenerateDefaultLayoutParams);
            this.mCollapseButtonView.setOnClickListener(new android.view.View.OnClickListener() { // from class: androidx.appcompat.widget.Toolbar.3
                @Override // android.view.View.OnClickListener
                public void onClick(android.view.View view) {
                    androidx.appcompat.widget.Toolbar.this.collapseActionView();
                }
            });
        }
    }

    private void addSystemView(android.view.View view, boolean z_renamed) {
        androidx.appcompat.widget.Toolbar.b_renamed bVarGenerateLayoutParams;
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            bVarGenerateLayoutParams = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(layoutParams)) {
            bVarGenerateLayoutParams = generateLayoutParams(layoutParams);
        } else {
            bVarGenerateLayoutParams = (androidx.appcompat.widget.Toolbar.b_renamed) layoutParams;
        }
        bVarGenerateLayoutParams.f510b = 1;
        if (z_renamed && this.mExpandedActionView != null) {
            view.setLayoutParams(bVarGenerateLayoutParams);
            this.mHiddenViews.add(view);
        } else {
            addView(view, bVarGenerateLayoutParams);
        }
    }

    @Override // android.view.View
    protected android.os.Parcelable onSaveInstanceState() {
        androidx.appcompat.widget.Toolbar.SavedState savedState = new androidx.appcompat.widget.Toolbar.SavedState(super.onSaveInstanceState());
        androidx.appcompat.widget.Toolbar.a_renamed aVar = this.mExpandedMenuPresenter;
        if (aVar != null && aVar.f508b != null) {
            savedState.expandedMenuItemId = this.mExpandedMenuPresenter.f508b.getItemId();
        }
        savedState.isOverflowOpen = isOverflowMenuShowing();
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(android.os.Parcelable parcelable) {
        android.view.MenuItem menuItemFindItem;
        if (!(parcelable instanceof androidx.appcompat.widget.Toolbar.SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        androidx.appcompat.widget.Toolbar.SavedState savedState = (androidx.appcompat.widget.Toolbar.SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        androidx.appcompat.widget.ActionMenuView actionMenuView = this.mMenuView;
        androidx.appcompat.view.menu.h_renamed hVarD = actionMenuView != null ? actionMenuView.d_renamed() : null;
        if (savedState.expandedMenuItemId != 0 && this.mExpandedMenuPresenter != null && hVarD != null && (menuItemFindItem = hVarD.findItem(savedState.expandedMenuItemId)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (savedState.isOverflowOpen) {
            postShowOverflowMenu();
        }
    }

    private void postShowOverflowMenu() {
        removeCallbacks(this.mShowOverflowMenuRunnable);
        post(this.mShowOverflowMenuRunnable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mShowOverflowMenuRunnable);
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mEatingTouch = false;
        }
        if (!this.mEatingTouch) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.mEatingTouch = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.mEatingTouch = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onHoverEvent(android.view.MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.mEatingHover = false;
        }
        if (!this.mEatingHover) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.mEatingHover = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.mEatingHover = false;
        }
        return true;
    }

    private void measureChildConstrained(android.view.View view, int i_renamed, int i2, int i3, int i4, int i5) {
        android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i_renamed, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height);
        int mode = android.view.View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = java.lang.Math.min(android.view.View.MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = android.view.View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private int measureChildCollapseMargins(android.view.View view, int i_renamed, int i2, int i3, int i4, int[] iArr) {
        android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = java.lang.Math.max(0, i5) + java.lang.Math.max(0, i6);
        iArr[0] = java.lang.Math.max(0, -i5);
        iArr[1] = java.lang.Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i_renamed, getPaddingLeft() + getPaddingRight() + iMax + i2, marginLayoutParams.width), getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    private boolean shouldCollapse() {
        if (!this.mCollapsible) {
            return false;
        }
        int childCount = getChildCount();
        for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
            android.view.View childAt = getChildAt(i_renamed);
            if (shouldLayout(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        char c2;
        char c3;
        int measuredWidth;
        int iMax;
        int iCombineMeasuredStates;
        int measuredWidth2;
        int measuredHeight;
        int iCombineMeasuredStates2;
        int iMax2;
        int[] iArr = this.mTempMargins;
        if (androidx.appcompat.widget.ax_renamed.a_renamed(this)) {
            c3 = 1;
            c2 = 0;
        } else {
            c2 = 1;
            c3 = 0;
        }
        if (shouldLayout(this.mNavButtonView)) {
            measureChildConstrained(this.mNavButtonView, i_renamed, 0, i2, 0, this.mMaxButtonHeight);
            measuredWidth = this.mNavButtonView.getMeasuredWidth() + getHorizontalMargins(this.mNavButtonView);
            iMax = java.lang.Math.max(0, this.mNavButtonView.getMeasuredHeight() + getVerticalMargins(this.mNavButtonView));
            iCombineMeasuredStates = android.view.View.combineMeasuredStates(0, this.mNavButtonView.getMeasuredState());
        } else {
            measuredWidth = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (shouldLayout(this.mCollapseButtonView)) {
            measureChildConstrained(this.mCollapseButtonView, i_renamed, 0, i2, 0, this.mMaxButtonHeight);
            measuredWidth = this.mCollapseButtonView.getMeasuredWidth() + getHorizontalMargins(this.mCollapseButtonView);
            iMax = java.lang.Math.max(iMax, this.mCollapseButtonView.getMeasuredHeight() + getVerticalMargins(this.mCollapseButtonView));
            iCombineMeasuredStates = android.view.View.combineMeasuredStates(iCombineMeasuredStates, this.mCollapseButtonView.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = 0 + java.lang.Math.max(currentContentInsetStart, measuredWidth);
        iArr[c3] = java.lang.Math.max(0, currentContentInsetStart - measuredWidth);
        if (shouldLayout(this.mMenuView)) {
            measureChildConstrained(this.mMenuView, i_renamed, iMax3, i2, 0, this.mMaxButtonHeight);
            measuredWidth2 = this.mMenuView.getMeasuredWidth() + getHorizontalMargins(this.mMenuView);
            iMax = java.lang.Math.max(iMax, this.mMenuView.getMeasuredHeight() + getVerticalMargins(this.mMenuView));
            iCombineMeasuredStates = android.view.View.combineMeasuredStates(iCombineMeasuredStates, this.mMenuView.getMeasuredState());
        } else {
            measuredWidth2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax4 = iMax3 + java.lang.Math.max(currentContentInsetEnd, measuredWidth2);
        iArr[c2] = java.lang.Math.max(0, currentContentInsetEnd - measuredWidth2);
        if (shouldLayout(this.mExpandedActionView)) {
            iMax4 += measureChildCollapseMargins(this.mExpandedActionView, i_renamed, iMax4, i2, 0, iArr);
            iMax = java.lang.Math.max(iMax, this.mExpandedActionView.getMeasuredHeight() + getVerticalMargins(this.mExpandedActionView));
            iCombineMeasuredStates = android.view.View.combineMeasuredStates(iCombineMeasuredStates, this.mExpandedActionView.getMeasuredState());
        }
        if (shouldLayout(this.mLogoView)) {
            iMax4 += measureChildCollapseMargins(this.mLogoView, i_renamed, iMax4, i2, 0, iArr);
            iMax = java.lang.Math.max(iMax, this.mLogoView.getMeasuredHeight() + getVerticalMargins(this.mLogoView));
            iCombineMeasuredStates = android.view.View.combineMeasuredStates(iCombineMeasuredStates, this.mLogoView.getMeasuredState());
        }
        int childCount = getChildCount();
        int iMax5 = iMax;
        int iMeasureChildCollapseMargins = iMax4;
        for (int i3 = 0; i3 < childCount; i3++) {
            android.view.View childAt = getChildAt(i3);
            if (((androidx.appcompat.widget.Toolbar.b_renamed) childAt.getLayoutParams()).f510b == 0 && shouldLayout(childAt)) {
                iMeasureChildCollapseMargins += measureChildCollapseMargins(childAt, i_renamed, iMeasureChildCollapseMargins, i2, 0, iArr);
                iMax5 = java.lang.Math.max(iMax5, childAt.getMeasuredHeight() + getVerticalMargins(childAt));
                iCombineMeasuredStates = android.view.View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
            }
        }
        int i4 = this.mTitleMarginTop + this.mTitleMarginBottom;
        int i5 = this.mTitleMarginStart + this.mTitleMarginEnd;
        if (shouldLayout(this.mTitleTextView)) {
            measureChildCollapseMargins(this.mTitleTextView, i_renamed, iMeasureChildCollapseMargins + i5, i2, i4, iArr);
            int measuredWidth3 = this.mTitleTextView.getMeasuredWidth() + getHorizontalMargins(this.mTitleTextView);
            measuredHeight = this.mTitleTextView.getMeasuredHeight() + getVerticalMargins(this.mTitleTextView);
            iCombineMeasuredStates2 = android.view.View.combineMeasuredStates(iCombineMeasuredStates, this.mTitleTextView.getMeasuredState());
            iMax2 = measuredWidth3;
        } else {
            measuredHeight = 0;
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
        }
        if (shouldLayout(this.mSubtitleTextView)) {
            iMax2 = java.lang.Math.max(iMax2, measureChildCollapseMargins(this.mSubtitleTextView, i_renamed, iMeasureChildCollapseMargins + i5, i2, measuredHeight + i4, iArr));
            measuredHeight += this.mSubtitleTextView.getMeasuredHeight() + getVerticalMargins(this.mSubtitleTextView);
            iCombineMeasuredStates2 = android.view.View.combineMeasuredStates(iCombineMeasuredStates2, this.mSubtitleTextView.getMeasuredState());
        }
        int iMax6 = java.lang.Math.max(iMax5, measuredHeight);
        int paddingLeft = iMeasureChildCollapseMargins + iMax2 + getPaddingLeft() + getPaddingRight();
        int paddingTop = iMax6 + getPaddingTop() + getPaddingBottom();
        int iResolveSizeAndState = android.view.View.resolveSizeAndState(java.lang.Math.max(paddingLeft, getSuggestedMinimumWidth()), i_renamed, (-16777216) & iCombineMeasuredStates2);
        int iResolveSizeAndState2 = android.view.View.resolveSizeAndState(java.lang.Math.max(paddingTop, getSuggestedMinimumHeight()), i2, iCombineMeasuredStates2 << 16);
        if (shouldCollapse()) {
            iResolveSizeAndState2 = 0;
        }
        setMeasuredDimension(iResolveSizeAndState, iResolveSizeAndState2);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:105:0x02a5 A_renamed[LOOP:0: B_renamed:104:0x02a3->B_renamed:105:0x02a5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:108:0x02c7 A_renamed[LOOP:1: B_renamed:107:0x02c5->B_renamed:108:0x02c7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:112:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:117:0x0301 A_renamed[LOOP:2: B_renamed:116:0x02ff->B_renamed:117:0x0301, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:19:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:24:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:29:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:34:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:39:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:40:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:42:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:43:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:49:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:50:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:51:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:53:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:54:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:66:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:76:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:78:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:91:0x022b  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 790
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    private int getViewListMeasuredWidth(java.util.List<android.view.View> list, int[] iArr) {
        int i_renamed = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = i2;
        int i4 = i_renamed;
        int i5 = 0;
        int measuredWidth = 0;
        while (i5 < size) {
            android.view.View view = list.get(i5);
            androidx.appcompat.widget.Toolbar.b_renamed bVar = (androidx.appcompat.widget.Toolbar.b_renamed) view.getLayoutParams();
            int i6 = bVar.leftMargin - i4;
            int i7 = bVar.rightMargin - i3;
            int iMax = java.lang.Math.max(0, i6);
            int iMax2 = java.lang.Math.max(0, i7);
            int iMax3 = java.lang.Math.max(0, -i6);
            int iMax4 = java.lang.Math.max(0, -i7);
            measuredWidth += iMax + view.getMeasuredWidth() + iMax2;
            i5++;
            i3 = iMax4;
            i4 = iMax3;
        }
        return measuredWidth;
    }

    private int layoutChildLeft(android.view.View view, int i_renamed, int[] iArr, int i2) {
        androidx.appcompat.widget.Toolbar.b_renamed bVar = (androidx.appcompat.widget.Toolbar.b_renamed) view.getLayoutParams();
        int i3 = bVar.leftMargin - iArr[0];
        int iMax = i_renamed + java.lang.Math.max(0, i3);
        iArr[0] = java.lang.Math.max(0, -i3);
        int childTop = getChildTop(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, childTop, iMax + measuredWidth, view.getMeasuredHeight() + childTop);
        return iMax + measuredWidth + bVar.rightMargin;
    }

    private int layoutChildRight(android.view.View view, int i_renamed, int[] iArr, int i2) {
        androidx.appcompat.widget.Toolbar.b_renamed bVar = (androidx.appcompat.widget.Toolbar.b_renamed) view.getLayoutParams();
        int i3 = bVar.rightMargin - iArr[1];
        int iMax = i_renamed - java.lang.Math.max(0, i3);
        iArr[1] = java.lang.Math.max(0, -i3);
        int childTop = getChildTop(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, childTop, iMax, view.getMeasuredHeight() + childTop);
        return iMax - (measuredWidth + bVar.leftMargin);
    }

    private int getChildTop(android.view.View view, int i_renamed) {
        androidx.appcompat.widget.Toolbar.b_renamed bVar = (androidx.appcompat.widget.Toolbar.b_renamed) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i_renamed > 0 ? (measuredHeight - i_renamed) / 2 : 0;
        int childVerticalGravity = getChildVerticalGravity(bVar.f264a);
        if (childVerticalGravity == 48) {
            return getPaddingTop() - i2;
        }
        if (childVerticalGravity == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - bVar.bottomMargin) - i2;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        if (iMax < bVar.topMargin) {
            iMax = bVar.topMargin;
        } else {
            int i3 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            if (i3 < bVar.bottomMargin) {
                iMax = java.lang.Math.max(0, iMax - (bVar.bottomMargin - i3));
            }
        }
        return paddingTop + iMax;
    }

    private int getChildVerticalGravity(int i_renamed) {
        int i2 = i_renamed & 112;
        return (i2 == 16 || i2 == 48 || i2 == 80) ? i2 : this.mGravity & 112;
    }

    private void addCustomViewsWithGravity(java.util.List<android.view.View> list, int i_renamed) {
        boolean z_renamed = androidx.core.h_renamed.v_renamed.g_renamed(this) == 1;
        int childCount = getChildCount();
        int iA = androidx.core.h_renamed.c_renamed.a_renamed(i_renamed, androidx.core.h_renamed.v_renamed.g_renamed(this));
        list.clear();
        if (!z_renamed) {
            for (int i2 = 0; i2 < childCount; i2++) {
                android.view.View childAt = getChildAt(i2);
                androidx.appcompat.widget.Toolbar.b_renamed bVar = (androidx.appcompat.widget.Toolbar.b_renamed) childAt.getLayoutParams();
                if (bVar.f510b == 0 && shouldLayout(childAt) && getChildHorizontalGravity(bVar.f264a) == iA) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i3 = childCount - 1; i3 >= 0; i3--) {
            android.view.View childAt2 = getChildAt(i3);
            androidx.appcompat.widget.Toolbar.b_renamed bVar2 = (androidx.appcompat.widget.Toolbar.b_renamed) childAt2.getLayoutParams();
            if (bVar2.f510b == 0 && shouldLayout(childAt2) && getChildHorizontalGravity(bVar2.f264a) == iA) {
                list.add(childAt2);
            }
        }
    }

    private int getChildHorizontalGravity(int i_renamed) {
        int iG = androidx.core.h_renamed.v_renamed.g_renamed(this);
        int iA = androidx.core.h_renamed.c_renamed.a_renamed(i_renamed, iG) & 7;
        return (iA == 1 || iA == 3 || iA == 5) ? iA : iG == 1 ? 5 : 3;
    }

    private boolean shouldLayout(android.view.View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private int getHorizontalMargins(android.view.View view) {
        android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return androidx.core.h_renamed.f_renamed.a_renamed(marginLayoutParams) + androidx.core.h_renamed.f_renamed.b_renamed(marginLayoutParams);
    }

    private int getVerticalMargins(android.view.View view) {
        android.view.ViewGroup.MarginLayoutParams marginLayoutParams = (android.view.ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    @Override // android.view.ViewGroup
    public androidx.appcompat.widget.Toolbar.b_renamed generateLayoutParams(android.util.AttributeSet attributeSet) {
        return new androidx.appcompat.widget.Toolbar.b_renamed(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public androidx.appcompat.widget.Toolbar.b_renamed generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof androidx.appcompat.widget.Toolbar.b_renamed) {
            return new androidx.appcompat.widget.Toolbar.b_renamed((androidx.appcompat.widget.Toolbar.b_renamed) layoutParams);
        }
        if (layoutParams instanceof androidx.appcompat.app.a_renamed.ActionBar_4) {
            return new androidx.appcompat.widget.Toolbar.b_renamed((androidx.appcompat.app.a_renamed.ActionBar_4) layoutParams);
        }
        if (layoutParams instanceof android.view.ViewGroup.MarginLayoutParams) {
            return new androidx.appcompat.widget.Toolbar.b_renamed((android.view.ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new androidx.appcompat.widget.Toolbar.b_renamed(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public androidx.appcompat.widget.Toolbar.b_renamed generateDefaultLayoutParams() {
        return new androidx.appcompat.widget.Toolbar.b_renamed(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof androidx.appcompat.widget.Toolbar.b_renamed);
    }

    private static boolean isCustomView(android.view.View view) {
        return ((androidx.appcompat.widget.Toolbar.b_renamed) view.getLayoutParams()).f510b == 0;
    }

    public androidx.appcompat.widget.z_renamed getWrapper() {
        if (this.mWrapper == null) {
            this.mWrapper = new androidx.appcompat.widget.as_renamed(this, true);
        }
        return this.mWrapper;
    }

    void removeChildrenForExpandedActionView() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            android.view.View childAt = getChildAt(childCount);
            if (((androidx.appcompat.widget.Toolbar.b_renamed) childAt.getLayoutParams()).f510b != 2 && childAt != this.mMenuView) {
                removeViewAt(childCount);
                this.mHiddenViews.add(childAt);
            }
        }
    }

    void addChildrenForExpandedActionView() {
        for (int size = this.mHiddenViews.size() - 1; size >= 0; size--) {
            addView(this.mHiddenViews.get(size));
        }
        this.mHiddenViews.clear();
    }

    private boolean isChildOrHidden(android.view.View view) {
        return view.getParent() == this || this.mHiddenViews.contains(view);
    }

    public void setCollapsible(boolean z_renamed) {
        this.mCollapsible = z_renamed;
        requestLayout();
    }

    public void setMenuCallbacks(androidx.appcompat.view.menu.n_renamed.a_renamed aVar, androidx.appcompat.view.menu.h_renamed.a_renamed aVar2) {
        this.mActionMenuPresenterCallback = aVar;
        this.mMenuBuilderCallback = aVar2;
        androidx.appcompat.widget.ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null) {
            actionMenuView.a_renamed(aVar, aVar2);
        }
    }

    private void ensureContentInsets() {
        if (this.mContentInsets == null) {
            this.mContentInsets = new androidx.appcompat.widget.aj_renamed();
        }
    }

    final android.widget.TextView getTitleTextView() {
        return this.mTitleTextView;
    }

    final android.widget.TextView getSubtitleTextView() {
        return this.mSubtitleTextView;
    }

    androidx.appcompat.widget.ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.mOuterActionMenuPresenter;
    }

    android.content.Context getPopupContext() {
        return this.mPopupContext;
    }

    public static class b_renamed extends androidx.appcompat.app.a_renamed.ActionBar_4 {

        /* renamed from: b_renamed, reason: collision with root package name */
        int f510b;

        public b_renamed(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f510b = 0;
        }

        public b_renamed(int i_renamed, int i2) {
            super(i_renamed, i2);
            this.f510b = 0;
            this.f264a = 8388627;
        }

        public b_renamed(androidx.appcompat.widget.Toolbar.b_renamed bVar) {
            super((androidx.appcompat.app.a_renamed.ActionBar_4) bVar);
            this.f510b = 0;
            this.f510b = bVar.f510b;
        }

        public b_renamed(androidx.appcompat.app.a_renamed.ActionBar_4 c0003a) {
            super(c0003a);
            this.f510b = 0;
        }

        public b_renamed(android.view.ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f510b = 0;
            a_renamed(marginLayoutParams);
        }

        public b_renamed(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f510b = 0;
        }

        void a_renamed(android.view.ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    public static class SavedState extends androidx.customview.view.AbsSavedState {
        public static final android.os.Parcelable.Creator<androidx.appcompat.widget.Toolbar.SavedState> CREATOR = new android.os.Parcelable.ClassLoaderCreator<androidx.appcompat.widget.Toolbar.SavedState>() { // from class: androidx.appcompat.widget.Toolbar.SavedState.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public androidx.appcompat.widget.Toolbar.SavedState createFromParcel(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
                return new androidx.appcompat.widget.Toolbar.SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public androidx.appcompat.widget.Toolbar.SavedState createFromParcel(android.os.Parcel parcel) {
                return new androidx.appcompat.widget.Toolbar.SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public androidx.appcompat.widget.Toolbar.SavedState[] newArray(int i_renamed) {
                return new androidx.appcompat.widget.Toolbar.SavedState[i_renamed];
            }
        };
        int expandedMenuItemId;
        boolean isOverflowOpen;

        public SavedState(android.os.Parcel parcel) {
            this(parcel, null);
        }

        public SavedState(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
            super(parcel, classLoader);
            this.expandedMenuItemId = parcel.readInt();
            this.isOverflowOpen = parcel.readInt() != 0;
        }

        public SavedState(android.os.Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
            super.writeToParcel(parcel, i_renamed);
            parcel.writeInt(this.expandedMenuItemId);
            parcel.writeInt(this.isOverflowOpen ? 1 : 0);
        }
    }

    private class a_renamed implements androidx.appcompat.view.menu.n_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        androidx.appcompat.view.menu.h_renamed f507a;

        /* renamed from: b_renamed, reason: collision with root package name */
        androidx.appcompat.view.menu.j_renamed f508b;

        @Override // androidx.appcompat.view.menu.n_renamed
        public boolean flagActionItems() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.n_renamed
        public int getId() {
            return 0;
        }

        @Override // androidx.appcompat.view.menu.n_renamed
        public void onCloseMenu(androidx.appcompat.view.menu.h_renamed hVar, boolean z_renamed) {
        }

        @Override // androidx.appcompat.view.menu.n_renamed
        public void onRestoreInstanceState(android.os.Parcelable parcelable) {
        }

        @Override // androidx.appcompat.view.menu.n_renamed
        public android.os.Parcelable onSaveInstanceState() {
            return null;
        }

        @Override // androidx.appcompat.view.menu.n_renamed
        public boolean onSubMenuSelected(androidx.appcompat.view.menu.s_renamed sVar) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.n_renamed
        public void setCallback(androidx.appcompat.view.menu.n_renamed.a_renamed aVar) {
        }

        a_renamed() {
        }

        @Override // androidx.appcompat.view.menu.n_renamed
        public void initForMenu(android.content.Context context, androidx.appcompat.view.menu.h_renamed hVar) {
            androidx.appcompat.view.menu.j_renamed jVar;
            androidx.appcompat.view.menu.h_renamed hVar2 = this.f507a;
            if (hVar2 != null && (jVar = this.f508b) != null) {
                hVar2.collapseItemActionView(jVar);
            }
            this.f507a = hVar;
        }

        @Override // androidx.appcompat.view.menu.n_renamed
        public void updateMenuView(boolean z_renamed) {
            if (this.f508b != null) {
                androidx.appcompat.view.menu.h_renamed hVar = this.f507a;
                boolean z2 = false;
                if (hVar != null) {
                    int size = hVar.size();
                    int i_renamed = 0;
                    while (true) {
                        if (i_renamed >= size) {
                            break;
                        }
                        if (this.f507a.getItem(i_renamed) == this.f508b) {
                            z2 = true;
                            break;
                        }
                        i_renamed++;
                    }
                }
                if (z2) {
                    return;
                }
                collapseItemActionView(this.f507a, this.f508b);
            }
        }

        @Override // androidx.appcompat.view.menu.n_renamed
        public boolean expandItemActionView(androidx.appcompat.view.menu.h_renamed hVar, androidx.appcompat.view.menu.j_renamed jVar) {
            androidx.appcompat.widget.Toolbar.this.ensureCollapseButtonView();
            android.view.ViewParent parent = androidx.appcompat.widget.Toolbar.this.mCollapseButtonView.getParent();
            androidx.appcompat.widget.Toolbar toolbar = androidx.appcompat.widget.Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof android.view.ViewGroup) {
                    ((android.view.ViewGroup) parent).removeView(toolbar.mCollapseButtonView);
                }
                androidx.appcompat.widget.Toolbar toolbar2 = androidx.appcompat.widget.Toolbar.this;
                toolbar2.addView(toolbar2.mCollapseButtonView);
            }
            androidx.appcompat.widget.Toolbar.this.mExpandedActionView = jVar.getActionView();
            this.f508b = jVar;
            android.view.ViewParent parent2 = androidx.appcompat.widget.Toolbar.this.mExpandedActionView.getParent();
            androidx.appcompat.widget.Toolbar toolbar3 = androidx.appcompat.widget.Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof android.view.ViewGroup) {
                    ((android.view.ViewGroup) parent2).removeView(toolbar3.mExpandedActionView);
                }
                androidx.appcompat.widget.Toolbar.b_renamed bVarGenerateDefaultLayoutParams = androidx.appcompat.widget.Toolbar.this.generateDefaultLayoutParams();
                bVarGenerateDefaultLayoutParams.f264a = 8388611 | (androidx.appcompat.widget.Toolbar.this.mButtonGravity & 112);
                bVarGenerateDefaultLayoutParams.f510b = 2;
                androidx.appcompat.widget.Toolbar.this.mExpandedActionView.setLayoutParams(bVarGenerateDefaultLayoutParams);
                androidx.appcompat.widget.Toolbar toolbar4 = androidx.appcompat.widget.Toolbar.this;
                toolbar4.addView(toolbar4.mExpandedActionView);
            }
            androidx.appcompat.widget.Toolbar.this.removeChildrenForExpandedActionView();
            androidx.appcompat.widget.Toolbar.this.requestLayout();
            jVar.e_renamed(true);
            if (androidx.appcompat.widget.Toolbar.this.mExpandedActionView instanceof androidx.appcompat.view.c_renamed) {
                ((androidx.appcompat.view.c_renamed) androidx.appcompat.widget.Toolbar.this.mExpandedActionView).a_renamed();
            }
            return true;
        }

        @Override // androidx.appcompat.view.menu.n_renamed
        public boolean collapseItemActionView(androidx.appcompat.view.menu.h_renamed hVar, androidx.appcompat.view.menu.j_renamed jVar) {
            if (androidx.appcompat.widget.Toolbar.this.mExpandedActionView instanceof androidx.appcompat.view.c_renamed) {
                ((androidx.appcompat.view.c_renamed) androidx.appcompat.widget.Toolbar.this.mExpandedActionView).b_renamed();
            }
            androidx.appcompat.widget.Toolbar toolbar = androidx.appcompat.widget.Toolbar.this;
            toolbar.removeView(toolbar.mExpandedActionView);
            androidx.appcompat.widget.Toolbar toolbar2 = androidx.appcompat.widget.Toolbar.this;
            toolbar2.removeView(toolbar2.mCollapseButtonView);
            androidx.appcompat.widget.Toolbar toolbar3 = androidx.appcompat.widget.Toolbar.this;
            toolbar3.mExpandedActionView = null;
            toolbar3.addChildrenForExpandedActionView();
            this.f508b = null;
            androidx.appcompat.widget.Toolbar.this.requestLayout();
            jVar.e_renamed(false);
            return true;
        }
    }
}
