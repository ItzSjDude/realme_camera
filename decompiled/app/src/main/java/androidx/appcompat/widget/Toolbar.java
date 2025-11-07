package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.p016a.p017a.AppCompatResources;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.p036h.GravityCompat;
import androidx.core.p036h.MarginLayoutParamsCompat;
import androidx.core.p036h.ViewCompat;
import androidx.customview.view.AbsSavedState;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class Toolbar extends ViewGroup {
    private static final String TAG = "Toolbar";
    private MenuPresenter.PlatformImplementations.kt_3 mActionMenuPresenterCallback;
    int mButtonGravity;
    ImageButton mCollapseButtonView;
    private CharSequence mCollapseDescription;
    private Drawable mCollapseIcon;
    private boolean mCollapsible;
    private int mContentInsetEndWithActions;
    private int mContentInsetStartWithNavigation;
    private RtlSpacingHelper mContentInsets;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    View mExpandedActionView;
    private C0300a mExpandedMenuPresenter;
    private int mGravity;
    private final ArrayList<View> mHiddenViews;
    private ImageView mLogoView;
    private int mMaxButtonHeight;
    private MenuBuilder.PlatformImplementations.kt_3 mMenuBuilderCallback;
    private ActionMenuView mMenuView;
    private final ActionMenuView.InterfaceC0266e mMenuViewItemClickListener;
    private ImageButton mNavButtonView;
    InterfaceC0302c mOnMenuItemClickListener;
    private ActionMenuPresenter mOuterActionMenuPresenter;
    private Context mPopupContext;
    private int mPopupTheme;
    private final Runnable mShowOverflowMenuRunnable;
    private CharSequence mSubtitleText;
    private int mSubtitleTextAppearance;
    private ColorStateList mSubtitleTextColor;
    private TextView mSubtitleTextView;
    private final int[] mTempMargins;
    private final ArrayList<View> mTempViews;
    private int mTitleMarginBottom;
    private int mTitleMarginEnd;
    private int mTitleMarginStart;
    private int mTitleMarginTop;
    private CharSequence mTitleText;
    private int mTitleTextAppearance;
    private ColorStateList mTitleTextColor;
    private TextView mTitleTextView;
    private ToolbarWidgetWrapper mWrapper;

    /* renamed from: androidx.appcompat.widget.Toolbar$IntrinsicsJvm.kt_3 */
    public interface InterfaceC0302c {
        /* renamed from: PlatformImplementations.kt_3 */
        boolean mo935a(MenuItem menuItem);
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.mGravity = 8388627;
        this.mTempViews = new ArrayList<>();
        this.mHiddenViews = new ArrayList<>();
        this.mTempMargins = new int[2];
        this.mMenuViewItemClickListener = new ActionMenuView.InterfaceC0266e() { // from class: androidx.appcompat.widget.Toolbar.1
            @Override // androidx.appcompat.widget.ActionMenuView.InterfaceC0266e
            /* renamed from: PlatformImplementations.kt_3 */
            public boolean mo1284a(MenuItem menuItem) {
                if (Toolbar.this.mOnMenuItemClickListener != null) {
                    return Toolbar.this.mOnMenuItemClickListener.mo935a(menuItem);
                }
                return false;
            }
        };
        this.mShowOverflowMenuRunnable = new Runnable() { // from class: androidx.appcompat.widget.Toolbar.2
            @Override // java.lang.Runnable
            public void run() {
                Toolbar.this.showOverflowMenu();
            }
        };
        TintTypedArray c0322arM1541a = TintTypedArray.m1541a(getContext(), attributeSet, R.styleable.Toolbar, OplusGLSurfaceView_13, 0);
        this.mTitleTextAppearance = c0322arM1541a.m1560g(R.styleable.Toolbar_titleTextAppearance, 0);
        this.mSubtitleTextAppearance = c0322arM1541a.m1560g(R.styleable.Toolbar_subtitleTextAppearance, 0);
        this.mGravity = c0322arM1541a.m1552c(R.styleable.Toolbar_android_gravity, this.mGravity);
        this.mButtonGravity = c0322arM1541a.m1552c(R.styleable.Toolbar_buttonGravity, 48);
        int iM1554d = c0322arM1541a.m1554d(R.styleable.Toolbar_titleMargin, 0);
        iM1554d = c0322arM1541a.m1561g(R.styleable.Toolbar_titleMargins) ? c0322arM1541a.m1554d(R.styleable.Toolbar_titleMargins, iM1554d) : iM1554d;
        this.mTitleMarginBottom = iM1554d;
        this.mTitleMarginTop = iM1554d;
        this.mTitleMarginEnd = iM1554d;
        this.mTitleMarginStart = iM1554d;
        int iM1554d2 = c0322arM1541a.m1554d(R.styleable.Toolbar_titleMarginStart, -1);
        if (iM1554d2 >= 0) {
            this.mTitleMarginStart = iM1554d2;
        }
        int iM1554d3 = c0322arM1541a.m1554d(R.styleable.Toolbar_titleMarginEnd, -1);
        if (iM1554d3 >= 0) {
            this.mTitleMarginEnd = iM1554d3;
        }
        int iM1554d4 = c0322arM1541a.m1554d(R.styleable.Toolbar_titleMarginTop, -1);
        if (iM1554d4 >= 0) {
            this.mTitleMarginTop = iM1554d4;
        }
        int iM1554d5 = c0322arM1541a.m1554d(R.styleable.Toolbar_titleMarginBottom, -1);
        if (iM1554d5 >= 0) {
            this.mTitleMarginBottom = iM1554d5;
        }
        this.mMaxButtonHeight = c0322arM1541a.m1556e(R.styleable.Toolbar_maxButtonHeight, -1);
        int iM1554d6 = c0322arM1541a.m1554d(R.styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int iM1554d7 = c0322arM1541a.m1554d(R.styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int iM1556e = c0322arM1541a.m1556e(R.styleable.Toolbar_contentInsetLeft, 0);
        int iM1556e2 = c0322arM1541a.m1556e(R.styleable.Toolbar_contentInsetRight, 0);
        ensureContentInsets();
        this.mContentInsets.m1494b(iM1556e, iM1556e2);
        if (iM1554d6 != Integer.MIN_VALUE || iM1554d7 != Integer.MIN_VALUE) {
            this.mContentInsets.m1491a(iM1554d6, iM1554d7);
        }
        this.mContentInsetStartWithNavigation = c0322arM1541a.m1554d(R.styleable.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.mContentInsetEndWithActions = c0322arM1541a.m1554d(R.styleable.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.mCollapseIcon = c0322arM1541a.m1546a(R.styleable.Toolbar_collapseIcon);
        this.mCollapseDescription = c0322arM1541a.m1553c(R.styleable.Toolbar_collapseContentDescription);
        CharSequence charSequenceM1553c = c0322arM1541a.m1553c(R.styleable.Toolbar_title);
        if (!TextUtils.isEmpty(charSequenceM1553c)) {
            setTitle(charSequenceM1553c);
        }
        CharSequence charSequenceM1553c2 = c0322arM1541a.m1553c(R.styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(charSequenceM1553c2)) {
            setSubtitle(charSequenceM1553c2);
        }
        this.mPopupContext = getContext();
        setPopupTheme(c0322arM1541a.m1560g(R.styleable.Toolbar_popupTheme, 0));
        Drawable drawableM1546a = c0322arM1541a.m1546a(R.styleable.Toolbar_navigationIcon);
        if (drawableM1546a != null) {
            setNavigationIcon(drawableM1546a);
        }
        CharSequence charSequenceM1553c3 = c0322arM1541a.m1553c(R.styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(charSequenceM1553c3)) {
            setNavigationContentDescription(charSequenceM1553c3);
        }
        Drawable drawableM1546a2 = c0322arM1541a.m1546a(R.styleable.Toolbar_logo);
        if (drawableM1546a2 != null) {
            setLogo(drawableM1546a2);
        }
        CharSequence charSequenceM1553c4 = c0322arM1541a.m1553c(R.styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(charSequenceM1553c4)) {
            setLogoDescription(charSequenceM1553c4);
        }
        if (c0322arM1541a.m1561g(R.styleable.Toolbar_titleTextColor)) {
            setTitleTextColor(c0322arM1541a.m1557e(R.styleable.Toolbar_titleTextColor));
        }
        if (c0322arM1541a.m1561g(R.styleable.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(c0322arM1541a.m1557e(R.styleable.Toolbar_subtitleTextColor));
        }
        if (c0322arM1541a.m1561g(R.styleable.Toolbar_menu)) {
            inflateMenu(c0322arM1541a.m1560g(R.styleable.Toolbar_menu, 0));
        }
        c0322arM1541a.m1551b();
    }

    public void setPopupTheme(int OplusGLSurfaceView_13) {
        if (this.mPopupTheme != OplusGLSurfaceView_13) {
            this.mPopupTheme = OplusGLSurfaceView_13;
            if (OplusGLSurfaceView_13 == 0) {
                this.mPopupContext = getContext();
            } else {
                this.mPopupContext = new ContextThemeWrapper(getContext(), OplusGLSurfaceView_13);
            }
        }
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    public void setTitleMargin(int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        this.mTitleMarginStart = OplusGLSurfaceView_13;
        this.mTitleMarginTop = i2;
        this.mTitleMarginEnd = i3;
        this.mTitleMarginBottom = i4;
        requestLayout();
    }

    public int getTitleMarginStart() {
        return this.mTitleMarginStart;
    }

    public void setTitleMarginStart(int OplusGLSurfaceView_13) {
        this.mTitleMarginStart = OplusGLSurfaceView_13;
        requestLayout();
    }

    public int getTitleMarginTop() {
        return this.mTitleMarginTop;
    }

    public void setTitleMarginTop(int OplusGLSurfaceView_13) {
        this.mTitleMarginTop = OplusGLSurfaceView_13;
        requestLayout();
    }

    public int getTitleMarginEnd() {
        return this.mTitleMarginEnd;
    }

    public void setTitleMarginEnd(int OplusGLSurfaceView_13) {
        this.mTitleMarginEnd = OplusGLSurfaceView_13;
        requestLayout();
    }

    public int getTitleMarginBottom() {
        return this.mTitleMarginBottom;
    }

    public void setTitleMarginBottom(int OplusGLSurfaceView_13) {
        this.mTitleMarginBottom = OplusGLSurfaceView_13;
        requestLayout();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int OplusGLSurfaceView_13) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(OplusGLSurfaceView_13);
        }
        ensureContentInsets();
        this.mContentInsets.m1492a(OplusGLSurfaceView_13 == 1);
    }

    public void setLogo(int OplusGLSurfaceView_13) {
        setLogo(AppCompatResources.m732b(getContext(), OplusGLSurfaceView_13));
    }

    public boolean canShowOverflowMenu() {
        ActionMenuView actionMenuView;
        return getVisibility() == 0 && (actionMenuView = this.mMenuView) != null && actionMenuView.m1274a();
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuView actionMenuView = this.mMenuView;
        return actionMenuView != null && actionMenuView.m1281g();
    }

    public boolean isOverflowMenuShowPending() {
        ActionMenuView actionMenuView = this.mMenuView;
        return actionMenuView != null && actionMenuView.m1282h();
    }

    public boolean showOverflowMenu() {
        ActionMenuView actionMenuView = this.mMenuView;
        return actionMenuView != null && actionMenuView.mo1279e();
    }

    public boolean hideOverflowMenu() {
        ActionMenuView actionMenuView = this.mMenuView;
        return actionMenuView != null && actionMenuView.m1280f();
    }

    public void setMenu(MenuBuilder c0236h, ActionMenuPresenter actionMenuPresenter) {
        if (c0236h == null && this.mMenuView == null) {
            return;
        }
        ensureMenuView();
        MenuBuilder c0236hM1278d = this.mMenuView.m1278d();
        if (c0236hM1278d == c0236h) {
            return;
        }
        if (c0236hM1278d != null) {
            c0236hM1278d.removeMenuPresenter(this.mOuterActionMenuPresenter);
            c0236hM1278d.removeMenuPresenter(this.mExpandedMenuPresenter);
        }
        if (this.mExpandedMenuPresenter == null) {
            this.mExpandedMenuPresenter = new C0300a();
        }
        actionMenuPresenter.m1258b(true);
        if (c0236h != null) {
            c0236h.addMenuPresenter(actionMenuPresenter, this.mPopupContext);
            c0236h.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
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
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null) {
            actionMenuView.mo1283i();
        }
    }

    public boolean isTitleTruncated() {
        Layout layout;
        TextView textView = this.mTitleTextView;
        if (textView == null || (layout = textView.getLayout()) == null) {
            return false;
        }
        int lineCount = layout.getLineCount();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < lineCount; OplusGLSurfaceView_13++) {
            if (layout.getEllipsisCount(OplusGLSurfaceView_13) > 0) {
                return true;
            }
        }
        return false;
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            ensureLogoView();
            if (!isChildOrHidden(this.mLogoView)) {
                addSystemView(this.mLogoView, true);
            }
        } else {
            ImageView imageView = this.mLogoView;
            if (imageView != null && isChildOrHidden(imageView)) {
                removeView(this.mLogoView);
                this.mHiddenViews.remove(this.mLogoView);
            }
        }
        ImageView imageView2 = this.mLogoView;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public Drawable getLogo() {
        ImageView imageView = this.mLogoView;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public void setLogoDescription(int OplusGLSurfaceView_13) {
        setLogoDescription(getContext().getText(OplusGLSurfaceView_13));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureLogoView();
        }
        ImageView imageView = this.mLogoView;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.mLogoView;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    private void ensureLogoView() {
        if (this.mLogoView == null) {
            this.mLogoView = new AppCompatImageView(getContext());
        }
    }

    public boolean hasExpandedActionView() {
        C0300a c0300a = this.mExpandedMenuPresenter;
        return (c0300a == null || c0300a.f1697b == null) ? false : true;
    }

    public void collapseActionView() {
        C0300a c0300a = this.mExpandedMenuPresenter;
        MenuItemImpl c0238j = c0300a == null ? null : c0300a.f1697b;
        if (c0238j != null) {
            c0238j.collapseActionView();
        }
    }

    public CharSequence getTitle() {
        return this.mTitleText;
    }

    public void setTitle(int OplusGLSurfaceView_13) {
        setTitle(getContext().getText(OplusGLSurfaceView_13));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.mTitleTextView == null) {
                Context context = getContext();
                this.mTitleTextView = new AppCompatTextView(context);
                this.mTitleTextView.setSingleLine();
                this.mTitleTextView.setEllipsize(TextUtils.TruncateAt.END);
                int OplusGLSurfaceView_13 = this.mTitleTextAppearance;
                if (OplusGLSurfaceView_13 != 0) {
                    this.mTitleTextView.setTextAppearance(context, OplusGLSurfaceView_13);
                }
                ColorStateList colorStateList = this.mTitleTextColor;
                if (colorStateList != null) {
                    this.mTitleTextView.setTextColor(colorStateList);
                }
            }
            if (!isChildOrHidden(this.mTitleTextView)) {
                addSystemView(this.mTitleTextView, true);
            }
        } else {
            TextView textView = this.mTitleTextView;
            if (textView != null && isChildOrHidden(textView)) {
                removeView(this.mTitleTextView);
                this.mHiddenViews.remove(this.mTitleTextView);
            }
        }
        TextView textView2 = this.mTitleTextView;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.mTitleText = charSequence;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitleText;
    }

    public void setSubtitle(int OplusGLSurfaceView_13) {
        setSubtitle(getContext().getText(OplusGLSurfaceView_13));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.mSubtitleTextView == null) {
                Context context = getContext();
                this.mSubtitleTextView = new AppCompatTextView(context);
                this.mSubtitleTextView.setSingleLine();
                this.mSubtitleTextView.setEllipsize(TextUtils.TruncateAt.END);
                int OplusGLSurfaceView_13 = this.mSubtitleTextAppearance;
                if (OplusGLSurfaceView_13 != 0) {
                    this.mSubtitleTextView.setTextAppearance(context, OplusGLSurfaceView_13);
                }
                ColorStateList colorStateList = this.mSubtitleTextColor;
                if (colorStateList != null) {
                    this.mSubtitleTextView.setTextColor(colorStateList);
                }
            }
            if (!isChildOrHidden(this.mSubtitleTextView)) {
                addSystemView(this.mSubtitleTextView, true);
            }
        } else {
            TextView textView = this.mSubtitleTextView;
            if (textView != null && isChildOrHidden(textView)) {
                removeView(this.mSubtitleTextView);
                this.mHiddenViews.remove(this.mSubtitleTextView);
            }
        }
        TextView textView2 = this.mSubtitleTextView;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.mSubtitleText = charSequence;
    }

    public void setTitleTextAppearance(Context context, int OplusGLSurfaceView_13) {
        this.mTitleTextAppearance = OplusGLSurfaceView_13;
        TextView textView = this.mTitleTextView;
        if (textView != null) {
            textView.setTextAppearance(context, OplusGLSurfaceView_13);
        }
    }

    public void setSubtitleTextAppearance(Context context, int OplusGLSurfaceView_13) {
        this.mSubtitleTextAppearance = OplusGLSurfaceView_13;
        TextView textView = this.mSubtitleTextView;
        if (textView != null) {
            textView.setTextAppearance(context, OplusGLSurfaceView_13);
        }
    }

    public void setTitleTextColor(int OplusGLSurfaceView_13) {
        setTitleTextColor(ColorStateList.valueOf(OplusGLSurfaceView_13));
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.mTitleTextColor = colorStateList;
        TextView textView = this.mTitleTextView;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setSubtitleTextColor(int OplusGLSurfaceView_13) {
        setSubtitleTextColor(ColorStateList.valueOf(OplusGLSurfaceView_13));
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.mSubtitleTextColor = colorStateList;
        TextView textView = this.mSubtitleTextView;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.mNavButtonView;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public void setNavigationContentDescription(int OplusGLSurfaceView_13) {
        setNavigationContentDescription(OplusGLSurfaceView_13 != 0 ? getContext().getText(OplusGLSurfaceView_13) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureNavButtonView();
        }
        ImageButton imageButton = this.mNavButtonView;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int OplusGLSurfaceView_13) {
        setNavigationIcon(AppCompatResources.m732b(getContext(), OplusGLSurfaceView_13));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            ensureNavButtonView();
            if (!isChildOrHidden(this.mNavButtonView)) {
                addSystemView(this.mNavButtonView, true);
            }
        } else {
            ImageButton imageButton = this.mNavButtonView;
            if (imageButton != null && isChildOrHidden(imageButton)) {
                removeView(this.mNavButtonView);
                this.mHiddenViews.remove(this.mNavButtonView);
            }
        }
        ImageButton imageButton2 = this.mNavButtonView;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.mNavButtonView;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        ensureNavButtonView();
        this.mNavButtonView.setOnClickListener(onClickListener);
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.mCollapseButtonView;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public void setCollapseContentDescription(int OplusGLSurfaceView_13) {
        setCollapseContentDescription(OplusGLSurfaceView_13 != 0 ? getContext().getText(OplusGLSurfaceView_13) : null);
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureCollapseButtonView();
        }
        ImageButton imageButton = this.mCollapseButtonView;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.mCollapseButtonView;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public void setCollapseIcon(int OplusGLSurfaceView_13) {
        setCollapseIcon(AppCompatResources.m732b(getContext(), OplusGLSurfaceView_13));
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            ensureCollapseButtonView();
            this.mCollapseButtonView.setImageDrawable(drawable);
        } else {
            ImageButton imageButton = this.mCollapseButtonView;
            if (imageButton != null) {
                imageButton.setImageDrawable(this.mCollapseIcon);
            }
        }
    }

    public Menu getMenu() {
        ensureMenu();
        return this.mMenuView.getMenu();
    }

    public void setOverflowIcon(Drawable drawable) {
        ensureMenu();
        this.mMenuView.setOverflowIcon(drawable);
    }

    public Drawable getOverflowIcon() {
        ensureMenu();
        return this.mMenuView.getOverflowIcon();
    }

    private void ensureMenu() {
        ensureMenuView();
        if (this.mMenuView.m1278d() == null) {
            MenuBuilder c0236h = (MenuBuilder) this.mMenuView.getMenu();
            if (this.mExpandedMenuPresenter == null) {
                this.mExpandedMenuPresenter = new C0300a();
            }
            this.mMenuView.setExpandedActionViewsExclusive(true);
            c0236h.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
        }
    }

    private void ensureMenuView() {
        if (this.mMenuView == null) {
            this.mMenuView = new ActionMenuView(getContext());
            this.mMenuView.setPopupTheme(this.mPopupTheme);
            this.mMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
            this.mMenuView.m1273a(this.mActionMenuPresenterCallback, this.mMenuBuilderCallback);
            C0301b c0301bGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            c0301bGenerateDefaultLayoutParams.f1005a = 8388613 | (this.mButtonGravity & 112);
            this.mMenuView.setLayoutParams(c0301bGenerateDefaultLayoutParams);
            addSystemView(this.mMenuView, false);
        }
    }

    private MenuInflater getMenuInflater() {
        return new SupportMenuInflater(getContext());
    }

    public void inflateMenu(int OplusGLSurfaceView_13) {
        getMenuInflater().inflate(OplusGLSurfaceView_13, getMenu());
    }

    public void setOnMenuItemClickListener(InterfaceC0302c interfaceC0302c) {
        this.mOnMenuItemClickListener = interfaceC0302c;
    }

    public void setContentInsetsRelative(int OplusGLSurfaceView_13, int i2) {
        ensureContentInsets();
        this.mContentInsets.m1491a(OplusGLSurfaceView_13, i2);
    }

    public int getContentInsetStart() {
        RtlSpacingHelper c0314aj = this.mContentInsets;
        if (c0314aj != null) {
            return c0314aj.m1495c();
        }
        return 0;
    }

    public int getContentInsetEnd() {
        RtlSpacingHelper c0314aj = this.mContentInsets;
        if (c0314aj != null) {
            return c0314aj.m1496d();
        }
        return 0;
    }

    public void setContentInsetsAbsolute(int OplusGLSurfaceView_13, int i2) {
        ensureContentInsets();
        this.mContentInsets.m1494b(OplusGLSurfaceView_13, i2);
    }

    public int getContentInsetLeft() {
        RtlSpacingHelper c0314aj = this.mContentInsets;
        if (c0314aj != null) {
            return c0314aj.m1490a();
        }
        return 0;
    }

    public int getContentInsetRight() {
        RtlSpacingHelper c0314aj = this.mContentInsets;
        if (c0314aj != null) {
            return c0314aj.m1493b();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int OplusGLSurfaceView_13 = this.mContentInsetStartWithNavigation;
        return OplusGLSurfaceView_13 != Integer.MIN_VALUE ? OplusGLSurfaceView_13 : getContentInsetStart();
    }

    public void setContentInsetStartWithNavigation(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0) {
            OplusGLSurfaceView_13 = Integer.MIN_VALUE;
        }
        if (OplusGLSurfaceView_13 != this.mContentInsetStartWithNavigation) {
            this.mContentInsetStartWithNavigation = OplusGLSurfaceView_13;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public int getContentInsetEndWithActions() {
        int OplusGLSurfaceView_13 = this.mContentInsetEndWithActions;
        return OplusGLSurfaceView_13 != Integer.MIN_VALUE ? OplusGLSurfaceView_13 : getContentInsetEnd();
    }

    public void setContentInsetEndWithActions(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0) {
            OplusGLSurfaceView_13 = Integer.MIN_VALUE;
        }
        if (OplusGLSurfaceView_13 != this.mContentInsetEndWithActions) {
            this.mContentInsetEndWithActions = OplusGLSurfaceView_13;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() != null) {
            return Math.max(getContentInsetStart(), Math.max(this.mContentInsetStartWithNavigation, 0));
        }
        return getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        MenuBuilder c0236hM1278d;
        ActionMenuView actionMenuView = this.mMenuView;
        if ((actionMenuView == null || (c0236hM1278d = actionMenuView.m1278d()) == null || !c0236hM1278d.hasVisibleItems()) ? false : true) {
            return Math.max(getContentInsetEnd(), Math.max(this.mContentInsetEndWithActions, 0));
        }
        return getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        if (ViewCompat.m2885g(this) == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (ViewCompat.m2885g(this) == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    private void ensureNavButtonView() {
        if (this.mNavButtonView == null) {
            this.mNavButtonView = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            C0301b c0301bGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            c0301bGenerateDefaultLayoutParams.f1005a = 8388611 | (this.mButtonGravity & 112);
            this.mNavButtonView.setLayoutParams(c0301bGenerateDefaultLayoutParams);
        }
    }

    void ensureCollapseButtonView() {
        if (this.mCollapseButtonView == null) {
            this.mCollapseButtonView = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            this.mCollapseButtonView.setImageDrawable(this.mCollapseIcon);
            this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
            C0301b c0301bGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            c0301bGenerateDefaultLayoutParams.f1005a = 8388611 | (this.mButtonGravity & 112);
            c0301bGenerateDefaultLayoutParams.f1699b = 2;
            this.mCollapseButtonView.setLayoutParams(c0301bGenerateDefaultLayoutParams);
            this.mCollapseButtonView.setOnClickListener(new View.OnClickListener() { // from class: androidx.appcompat.widget.Toolbar.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Toolbar.this.collapseActionView();
                }
            });
        }
    }

    private void addSystemView(View view, boolean z) {
        C0301b c0301bGenerateLayoutParams;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            c0301bGenerateLayoutParams = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(layoutParams)) {
            c0301bGenerateLayoutParams = generateLayoutParams(layoutParams);
        } else {
            c0301bGenerateLayoutParams = (C0301b) layoutParams;
        }
        c0301bGenerateLayoutParams.f1699b = 1;
        if (z && this.mExpandedActionView != null) {
            view.setLayoutParams(c0301bGenerateLayoutParams);
            this.mHiddenViews.add(view);
        } else {
            addView(view, c0301bGenerateLayoutParams);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        C0300a c0300a = this.mExpandedMenuPresenter;
        if (c0300a != null && c0300a.f1697b != null) {
            savedState.expandedMenuItemId = this.mExpandedMenuPresenter.f1697b.getItemId();
        }
        savedState.isOverflowOpen = isOverflowMenuShowing();
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        ActionMenuView actionMenuView = this.mMenuView;
        MenuBuilder c0236hM1278d = actionMenuView != null ? actionMenuView.m1278d() : null;
        if (savedState.expandedMenuItemId != 0 && this.mExpandedMenuPresenter != null && c0236hM1278d != null && (menuItemFindItem = c0236hM1278d.findItem(savedState.expandedMenuItemId)) != null) {
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
    public boolean onTouchEvent(MotionEvent motionEvent) {
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
    public boolean onHoverEvent(MotionEvent motionEvent) {
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

    private void measureChildConstrained(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(OplusGLSurfaceView_13, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private int measureChildCollapseMargins(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(OplusGLSurfaceView_13, getPaddingLeft() + getPaddingRight() + iMax + i2, marginLayoutParams.width), getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    private boolean shouldCollapse() {
        if (!this.mCollapsible) {
            return false;
        }
        int childCount = getChildCount();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            View childAt = getChildAt(OplusGLSurfaceView_13);
            if (shouldLayout(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
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
        if (ViewUtils_2.m1623a(this)) {
            c3 = 1;
            c2 = 0;
        } else {
            c2 = 1;
            c3 = 0;
        }
        if (shouldLayout(this.mNavButtonView)) {
            measureChildConstrained(this.mNavButtonView, OplusGLSurfaceView_13, 0, i2, 0, this.mMaxButtonHeight);
            measuredWidth = this.mNavButtonView.getMeasuredWidth() + getHorizontalMargins(this.mNavButtonView);
            iMax = Math.max(0, this.mNavButtonView.getMeasuredHeight() + getVerticalMargins(this.mNavButtonView));
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.mNavButtonView.getMeasuredState());
        } else {
            measuredWidth = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (shouldLayout(this.mCollapseButtonView)) {
            measureChildConstrained(this.mCollapseButtonView, OplusGLSurfaceView_13, 0, i2, 0, this.mMaxButtonHeight);
            measuredWidth = this.mCollapseButtonView.getMeasuredWidth() + getHorizontalMargins(this.mCollapseButtonView);
            iMax = Math.max(iMax, this.mCollapseButtonView.getMeasuredHeight() + getVerticalMargins(this.mCollapseButtonView));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.mCollapseButtonView.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = 0 + Math.max(currentContentInsetStart, measuredWidth);
        iArr[c3] = Math.max(0, currentContentInsetStart - measuredWidth);
        if (shouldLayout(this.mMenuView)) {
            measureChildConstrained(this.mMenuView, OplusGLSurfaceView_13, iMax3, i2, 0, this.mMaxButtonHeight);
            measuredWidth2 = this.mMenuView.getMeasuredWidth() + getHorizontalMargins(this.mMenuView);
            iMax = Math.max(iMax, this.mMenuView.getMeasuredHeight() + getVerticalMargins(this.mMenuView));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.mMenuView.getMeasuredState());
        } else {
            measuredWidth2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax4 = iMax3 + Math.max(currentContentInsetEnd, measuredWidth2);
        iArr[c2] = Math.max(0, currentContentInsetEnd - measuredWidth2);
        if (shouldLayout(this.mExpandedActionView)) {
            iMax4 += measureChildCollapseMargins(this.mExpandedActionView, OplusGLSurfaceView_13, iMax4, i2, 0, iArr);
            iMax = Math.max(iMax, this.mExpandedActionView.getMeasuredHeight() + getVerticalMargins(this.mExpandedActionView));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.mExpandedActionView.getMeasuredState());
        }
        if (shouldLayout(this.mLogoView)) {
            iMax4 += measureChildCollapseMargins(this.mLogoView, OplusGLSurfaceView_13, iMax4, i2, 0, iArr);
            iMax = Math.max(iMax, this.mLogoView.getMeasuredHeight() + getVerticalMargins(this.mLogoView));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.mLogoView.getMeasuredState());
        }
        int childCount = getChildCount();
        int iMax5 = iMax;
        int iMeasureChildCollapseMargins = iMax4;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (((C0301b) childAt.getLayoutParams()).f1699b == 0 && shouldLayout(childAt)) {
                iMeasureChildCollapseMargins += measureChildCollapseMargins(childAt, OplusGLSurfaceView_13, iMeasureChildCollapseMargins, i2, 0, iArr);
                iMax5 = Math.max(iMax5, childAt.getMeasuredHeight() + getVerticalMargins(childAt));
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
            }
        }
        int i4 = this.mTitleMarginTop + this.mTitleMarginBottom;
        int i5 = this.mTitleMarginStart + this.mTitleMarginEnd;
        if (shouldLayout(this.mTitleTextView)) {
            measureChildCollapseMargins(this.mTitleTextView, OplusGLSurfaceView_13, iMeasureChildCollapseMargins + i5, i2, i4, iArr);
            int measuredWidth3 = this.mTitleTextView.getMeasuredWidth() + getHorizontalMargins(this.mTitleTextView);
            measuredHeight = this.mTitleTextView.getMeasuredHeight() + getVerticalMargins(this.mTitleTextView);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.mTitleTextView.getMeasuredState());
            iMax2 = measuredWidth3;
        } else {
            measuredHeight = 0;
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
        }
        if (shouldLayout(this.mSubtitleTextView)) {
            iMax2 = Math.max(iMax2, measureChildCollapseMargins(this.mSubtitleTextView, OplusGLSurfaceView_13, iMeasureChildCollapseMargins + i5, i2, measuredHeight + i4, iArr));
            measuredHeight += this.mSubtitleTextView.getMeasuredHeight() + getVerticalMargins(this.mSubtitleTextView);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.mSubtitleTextView.getMeasuredState());
        }
        int iMax6 = Math.max(iMax5, measuredHeight);
        int paddingLeft = iMeasureChildCollapseMargins + iMax2 + getPaddingLeft() + getPaddingRight();
        int paddingTop = iMax6 + getPaddingTop() + getPaddingBottom();
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), OplusGLSurfaceView_13, (-16777216) & iCombineMeasuredStates2);
        int iResolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, iCombineMeasuredStates2 << 16);
        if (shouldCollapse()) {
            iResolveSizeAndState2 = 0;
        }
        setMeasuredDimension(iResolveSizeAndState, iResolveSizeAndState2);
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x02a5 A[LOOP:0: B:104:0x02a3->B:105:0x02a5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02c7 A[LOOP:1: B:107:0x02c5->B:108:0x02c7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0301 A[LOOP:2: B:116:0x02ff->B:117:0x0301, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x022b  */
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

    private int getViewListMeasuredWidth(List<View> list, int[] iArr) {
        int OplusGLSurfaceView_13 = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = i2;
        int i4 = OplusGLSurfaceView_13;
        int i5 = 0;
        int measuredWidth = 0;
        while (i5 < size) {
            View view = list.get(i5);
            C0301b c0301b = (C0301b) view.getLayoutParams();
            int i6 = c0301b.leftMargin - i4;
            int i7 = c0301b.rightMargin - i3;
            int iMax = Math.max(0, i6);
            int iMax2 = Math.max(0, i7);
            int iMax3 = Math.max(0, -i6);
            int iMax4 = Math.max(0, -i7);
            measuredWidth += iMax + view.getMeasuredWidth() + iMax2;
            i5++;
            i3 = iMax4;
            i4 = iMax3;
        }
        return measuredWidth;
    }

    private int layoutChildLeft(View view, int OplusGLSurfaceView_13, int[] iArr, int i2) {
        C0301b c0301b = (C0301b) view.getLayoutParams();
        int i3 = c0301b.leftMargin - iArr[0];
        int iMax = OplusGLSurfaceView_13 + Math.max(0, i3);
        iArr[0] = Math.max(0, -i3);
        int childTop = getChildTop(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, childTop, iMax + measuredWidth, view.getMeasuredHeight() + childTop);
        return iMax + measuredWidth + c0301b.rightMargin;
    }

    private int layoutChildRight(View view, int OplusGLSurfaceView_13, int[] iArr, int i2) {
        C0301b c0301b = (C0301b) view.getLayoutParams();
        int i3 = c0301b.rightMargin - iArr[1];
        int iMax = OplusGLSurfaceView_13 - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int childTop = getChildTop(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, childTop, iMax, view.getMeasuredHeight() + childTop);
        return iMax - (measuredWidth + c0301b.leftMargin);
    }

    private int getChildTop(View view, int OplusGLSurfaceView_13) {
        C0301b c0301b = (C0301b) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = OplusGLSurfaceView_13 > 0 ? (measuredHeight - OplusGLSurfaceView_13) / 2 : 0;
        int childVerticalGravity = getChildVerticalGravity(c0301b.f1005a);
        if (childVerticalGravity == 48) {
            return getPaddingTop() - i2;
        }
        if (childVerticalGravity == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - c0301b.bottomMargin) - i2;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        if (iMax < c0301b.topMargin) {
            iMax = c0301b.topMargin;
        } else {
            int i3 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            if (i3 < c0301b.bottomMargin) {
                iMax = Math.max(0, iMax - (c0301b.bottomMargin - i3));
            }
        }
        return paddingTop + iMax;
    }

    private int getChildVerticalGravity(int OplusGLSurfaceView_13) {
        int i2 = OplusGLSurfaceView_13 & 112;
        return (i2 == 16 || i2 == 48 || i2 == 80) ? i2 : this.mGravity & 112;
    }

    private void addCustomViewsWithGravity(List<View> list, int OplusGLSurfaceView_13) {
        boolean z = ViewCompat.m2885g(this) == 1;
        int childCount = getChildCount();
        int iM2773a = GravityCompat.m2773a(OplusGLSurfaceView_13, ViewCompat.m2885g(this));
        list.clear();
        if (!z) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                C0301b c0301b = (C0301b) childAt.getLayoutParams();
                if (c0301b.f1699b == 0 && shouldLayout(childAt) && getChildHorizontalGravity(c0301b.f1005a) == iM2773a) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i3 = childCount - 1; i3 >= 0; i3--) {
            View childAt2 = getChildAt(i3);
            C0301b c0301b2 = (C0301b) childAt2.getLayoutParams();
            if (c0301b2.f1699b == 0 && shouldLayout(childAt2) && getChildHorizontalGravity(c0301b2.f1005a) == iM2773a) {
                list.add(childAt2);
            }
        }
    }

    private int getChildHorizontalGravity(int OplusGLSurfaceView_13) {
        int iM2885g = ViewCompat.m2885g(this);
        int iM2773a = GravityCompat.m2773a(OplusGLSurfaceView_13, iM2885g) & 7;
        return (iM2773a == 1 || iM2773a == 3 || iM2773a == 5) ? iM2773a : iM2885g == 1 ? 5 : 3;
    }

    private boolean shouldLayout(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private int getHorizontalMargins(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return MarginLayoutParamsCompat.m2783a(marginLayoutParams) + MarginLayoutParamsCompat.m2785b(marginLayoutParams);
    }

    private int getVerticalMargins(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    @Override // android.view.ViewGroup
    public C0301b generateLayoutParams(AttributeSet attributeSet) {
        return new C0301b(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public C0301b generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof C0301b) {
            return new C0301b((C0301b) layoutParams);
        }
        if (layoutParams instanceof ActionBar.PlatformImplementations.kt_3) {
            return new C0301b((ActionBar.PlatformImplementations.kt_3) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new C0301b((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new C0301b(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public C0301b generateDefaultLayoutParams() {
        return new C0301b(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof C0301b);
    }

    private static boolean isCustomView(View view) {
        return ((C0301b) view.getLayoutParams()).f1699b == 0;
    }

    public DecorToolbar getWrapper() {
        if (this.mWrapper == null) {
            this.mWrapper = new ToolbarWidgetWrapper(this, true);
        }
        return this.mWrapper;
    }

    void removeChildrenForExpandedActionView() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((C0301b) childAt.getLayoutParams()).f1699b != 2 && childAt != this.mMenuView) {
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

    private boolean isChildOrHidden(View view) {
        return view.getParent() == this || this.mHiddenViews.contains(view);
    }

    public void setCollapsible(boolean z) {
        this.mCollapsible = z;
        requestLayout();
    }

    public void setMenuCallbacks(MenuPresenter.PlatformImplementations.kt_3 aVar, MenuBuilder.PlatformImplementations.kt_3 aVar2) {
        this.mActionMenuPresenterCallback = aVar;
        this.mMenuBuilderCallback = aVar2;
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null) {
            actionMenuView.m1273a(aVar, aVar2);
        }
    }

    private void ensureContentInsets() {
        if (this.mContentInsets == null) {
            this.mContentInsets = new RtlSpacingHelper();
        }
    }

    final TextView getTitleTextView() {
        return this.mTitleTextView;
    }

    final TextView getSubtitleTextView() {
        return this.mSubtitleTextView;
    }

    ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.mOuterActionMenuPresenter;
    }

    Context getPopupContext() {
        return this.mPopupContext;
    }

    /* renamed from: androidx.appcompat.widget.Toolbar$IntrinsicsJvm.kt_4 */
    public static class C0301b extends ActionBar.PlatformImplementations.kt_3 {

        /* renamed from: IntrinsicsJvm.kt_4 */
        int f1699b;

        public C0301b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1699b = 0;
        }

        public C0301b(int OplusGLSurfaceView_13, int i2) {
            super(OplusGLSurfaceView_13, i2);
            this.f1699b = 0;
            this.f1005a = 8388627;
        }

        public C0301b(C0301b c0301b) {
            super((ActionBar.PlatformImplementations.kt_3) c0301b);
            this.f1699b = 0;
            this.f1699b = c0301b.f1699b;
        }

        public C0301b(ActionBar.PlatformImplementations.kt_3 aVar) {
            super(aVar);
            this.f1699b = 0;
        }

        public C0301b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1699b = 0;
            m1384a(marginLayoutParams);
        }

        public C0301b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1699b = 0;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m1384a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: androidx.appcompat.widget.Toolbar.SavedState.1
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
        int expandedMenuItemId;
        boolean isOverflowOpen;

        public SavedState(Parcel parcel) {
            this(parcel, null);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.expandedMenuItemId = parcel.readInt();
            this.isOverflowOpen = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            super.writeToParcel(parcel, OplusGLSurfaceView_13);
            parcel.writeInt(this.expandedMenuItemId);
            parcel.writeInt(this.isOverflowOpen ? 1 : 0);
        }
    }

    /* renamed from: androidx.appcompat.widget.Toolbar$PlatformImplementations.kt_3 */
    private class C0300a implements MenuPresenter {

        /* renamed from: PlatformImplementations.kt_3 */
        MenuBuilder f1696a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        MenuItemImpl f1697b;

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean flagActionItems() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public int getId() {
            return 0;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void onCloseMenu(MenuBuilder c0236h, boolean z) {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public Parcelable onSaveInstanceState() {
            return null;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean onSubMenuSelected(SubMenuBuilder subMenuC0247s) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void setCallback(MenuPresenter.PlatformImplementations.kt_3 aVar) {
        }

        C0300a() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void initForMenu(Context context, MenuBuilder c0236h) {
            MenuItemImpl c0238j;
            MenuBuilder c0236h2 = this.f1696a;
            if (c0236h2 != null && (c0238j = this.f1697b) != null) {
                c0236h2.collapseItemActionView(c0238j);
            }
            this.f1696a = c0236h;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void updateMenuView(boolean z) {
            if (this.f1697b != null) {
                MenuBuilder c0236h = this.f1696a;
                boolean z2 = false;
                if (c0236h != null) {
                    int size = c0236h.size();
                    int OplusGLSurfaceView_13 = 0;
                    while (true) {
                        if (OplusGLSurfaceView_13 >= size) {
                            break;
                        }
                        if (this.f1696a.getItem(OplusGLSurfaceView_13) == this.f1697b) {
                            z2 = true;
                            break;
                        }
                        OplusGLSurfaceView_13++;
                    }
                }
                if (z2) {
                    return;
                }
                collapseItemActionView(this.f1696a, this.f1697b);
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean expandItemActionView(MenuBuilder c0236h, MenuItemImpl c0238j) {
            Toolbar.this.ensureCollapseButtonView();
            ViewParent parent = Toolbar.this.mCollapseButtonView.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.mCollapseButtonView);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.mCollapseButtonView);
            }
            Toolbar.this.mExpandedActionView = c0238j.getActionView();
            this.f1697b = c0238j;
            ViewParent parent2 = Toolbar.this.mExpandedActionView.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.mExpandedActionView);
                }
                C0301b c0301bGenerateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                c0301bGenerateDefaultLayoutParams.f1005a = 8388611 | (Toolbar.this.mButtonGravity & 112);
                c0301bGenerateDefaultLayoutParams.f1699b = 2;
                Toolbar.this.mExpandedActionView.setLayoutParams(c0301bGenerateDefaultLayoutParams);
                Toolbar toolbar4 = Toolbar.this;
                toolbar4.addView(toolbar4.mExpandedActionView);
            }
            Toolbar.this.removeChildrenForExpandedActionView();
            Toolbar.this.requestLayout();
            c0238j.m1175e(true);
            if (Toolbar.this.mExpandedActionView instanceof CollapsibleActionView) {
                ((CollapsibleActionView) Toolbar.this.mExpandedActionView).mo1058a();
            }
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean collapseItemActionView(MenuBuilder c0236h, MenuItemImpl c0238j) {
            if (Toolbar.this.mExpandedActionView instanceof CollapsibleActionView) {
                ((CollapsibleActionView) Toolbar.this.mExpandedActionView).mo1059b();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.mExpandedActionView);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.mCollapseButtonView);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.mExpandedActionView = null;
            toolbar3.addChildrenForExpandedActionView();
            this.f1697b = null;
            Toolbar.this.requestLayout();
            c0238j.m1175e(false);
            return true;
        }
    }
}
