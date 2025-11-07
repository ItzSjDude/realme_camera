package com.coui.appcompat.widget.toolbar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.p016a.p017a.AppCompatResources;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.ViewUtils_2;
import androidx.appcompat.widget.Toolbar;
import androidx.core.p036h.GravityCompat;
import androidx.core.p036h.MarginLayoutParamsCompat;
import androidx.core.p036h.MotionEventCompat;
import androidx.core.p036h.ViewCompat;
import com.coui.appcompat.p099a.COUIChangeTextUtil;
import com.coui.appcompat.p099a.COUIRtlSpacingHelper;
import com.coui.appcompat.widget.COUISearchViewAnimate;
import coui.support.appcompat.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class COUIToolbar extends Toolbar {

    /* renamed from: A */
    private boolean f8754A;

    /* renamed from: B */
    private boolean f8755B;

    /* renamed from: C */
    private final ArrayList<View> f8756C;

    /* renamed from: D */
    private final int[] f8757D;

    /* renamed from: E */
    private Toolbar.InterfaceC0302c f8758E;

    /* renamed from: F */
    private final ActionMenuView.InterfaceC0266e f8759F;

    /* renamed from: G */
    private C1524a f8760G;

    /* renamed from: H */
    private MenuPresenter.PlatformImplementations.kt_3 f8761H;

    /* renamed from: I */
    private MenuBuilder.PlatformImplementations.kt_3 f8762I;

    /* renamed from: J */
    private boolean f8763J;

    /* renamed from: K */
    private int f8764K;

    /* renamed from: L */
    private boolean f8765L;

    /* renamed from: M */
    private int f8766M;

    /* renamed from: N */
    private int[] f8767N;

    /* renamed from: O */
    private float f8768O;

    /* renamed from: P */
    private int f8769P;

    /* renamed from: Q */
    private int f8770Q;

    /* renamed from: R */
    private int f8771R;

    /* renamed from: S */
    private int f8772S;

    /* renamed from: T */
    private final int[] f8773T;

    /* renamed from: U */
    private final Runnable f8774U;

    /* renamed from: V */
    private int f8775V;

    /* renamed from: W */
    private float f8776W;

    /* renamed from: PlatformImplementations.kt_3 */
    View f8777a;

    /* renamed from: aa */
    private float f8778aa;

    /* renamed from: IntrinsicsJvm.kt_4 */
    boolean f8779b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private ActionMenuView f8780c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private TextView f8781d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private TextView f8782e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private ImageButton f8783f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private ImageView f8784g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private Drawable f8785h;

    /* renamed from: OplusGLSurfaceView_13 */
    private CharSequence f8786i;

    /* renamed from: OplusGLSurfaceView_15 */
    private ImageButton f8787j;

    /* renamed from: OplusGLSurfaceView_5 */
    private Context f8788k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f8789l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f8790m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f8791n;

    /* renamed from: o */
    private int f8792o;

    /* renamed from: p */
    private int f8793p;

    /* renamed from: q */
    private int f8794q;

    /* renamed from: r */
    private int f8795r;

    /* renamed from: s */
    private int f8796s;

    /* renamed from: t */
    private int f8797t;

    /* renamed from: u */
    private final COUIRtlSpacingHelper f8798u;

    /* renamed from: v */
    private int f8799v;

    /* renamed from: w */
    private CharSequence f8800w;

    /* renamed from: x */
    private CharSequence f8801x;

    /* renamed from: y */
    private int f8802y;

    /* renamed from: z */
    private int f8803z;

    public COUIToolbar(Context context) {
        this(context, null);
    }

    public COUIToolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.toolbarStyle);
    }

    public COUIToolbar(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f8798u = new COUIRtlSpacingHelper();
        this.f8799v = 8388627;
        this.f8756C = new ArrayList<>();
        this.f8757D = new int[2];
        this.f8759F = new ActionMenuView.InterfaceC0266e() { // from class: com.coui.appcompat.widget.toolbar.COUIToolbar.1
            @Override // androidx.appcompat.widget.ActionMenuView.InterfaceC0266e
            /* renamed from: PlatformImplementations.kt_3 */
            public boolean mo1284a(MenuItem menuItem) {
                if (COUIToolbar.this.f8758E != null) {
                    return COUIToolbar.this.f8758E.mo935a(menuItem);
                }
                return false;
            }
        };
        this.f8765L = false;
        this.f8767N = new int[2];
        this.f8768O = 0.0f;
        this.f8773T = new int[2];
        this.f8774U = new Runnable() { // from class: com.coui.appcompat.widget.toolbar.COUIToolbar.2
            @Override // java.lang.Runnable
            public void run() {
                COUIToolbar.this.showOverflowMenu();
            }
        };
        this.f8779b = false;
        setClipToPadding(false);
        setClipChildren(false);
        if (attributeSet != null) {
            this.f8775V = attributeSet.getStyleAttribute();
            if (this.f8775V == 0) {
                this.f8775V = OplusGLSurfaceView_13;
            }
        } else {
            this.f8775V = 0;
        }
        TintTypedArray c0322arM1541a = TintTypedArray.m1541a(getContext(), attributeSet, R.styleable.COUIToolbar, OplusGLSurfaceView_13, 0);
        if (c0322arM1541a.m1561g(R.styleable.COUIToolbar_titleType)) {
            this.f8766M = c0322arM1541a.m1544a(R.styleable.COUIToolbar_titleType, 0);
        }
        this.f8790m = c0322arM1541a.m1560g(R.styleable.COUIToolbar_supportTitleTextAppearance, 0);
        this.f8791n = c0322arM1541a.m1560g(R.styleable.COUIToolbar_supportSubtitleTextAppearance, 0);
        this.f8799v = c0322arM1541a.m1552c(R.styleable.COUIToolbar_android_gravity, this.f8799v);
        this.f8792o = c0322arM1541a.m1552c(R.styleable.COUIToolbar_supportButtonGravity, 48);
        int iM1554d = c0322arM1541a.m1554d(R.styleable.COUIToolbar_supportTitleMargins, 0);
        this.f8797t = iM1554d;
        this.f8796s = iM1554d;
        this.f8795r = iM1554d;
        this.f8794q = iM1554d;
        int iM1554d2 = c0322arM1541a.m1554d(R.styleable.COUIToolbar_supportTitleMarginStart, -1);
        if (iM1554d2 >= 0) {
            this.f8794q = iM1554d2;
        }
        int iM1554d3 = c0322arM1541a.m1554d(R.styleable.COUIToolbar_supportTitleMarginEnd, -1);
        if (iM1554d3 >= 0) {
            this.f8795r = iM1554d3;
        }
        int iM1554d4 = c0322arM1541a.m1554d(R.styleable.COUIToolbar_supportTitleMarginTop, -1);
        if (iM1554d4 >= 0) {
            this.f8796s = iM1554d4;
        }
        int iM1554d5 = c0322arM1541a.m1554d(R.styleable.COUIToolbar_supportTitleMarginBottom, -1);
        if (iM1554d5 >= 0) {
            this.f8797t = iM1554d5;
        }
        this.f8793p = c0322arM1541a.m1556e(R.styleable.COUIToolbar_supportMaxButtonHeight, -1);
        int iM1554d6 = c0322arM1541a.m1554d(R.styleable.COUIToolbar_supportContentInsetStart, Integer.MIN_VALUE);
        int iM1554d7 = c0322arM1541a.m1554d(R.styleable.COUIToolbar_supportContentInsetEnd, Integer.MIN_VALUE);
        this.f8798u.m6457b(c0322arM1541a.m1556e(R.styleable.COUIToolbar_supportContentInsetLeft, 0), c0322arM1541a.m1556e(R.styleable.COUIToolbar_supportContentInsetRight, 0));
        if (iM1554d6 != Integer.MIN_VALUE || iM1554d7 != Integer.MIN_VALUE) {
            this.f8798u.m6454a(iM1554d6, iM1554d7);
        }
        this.f8785h = c0322arM1541a.m1546a(R.styleable.COUIToolbar_supportCollapseIcon);
        this.f8786i = c0322arM1541a.m1553c(R.styleable.COUIToolbar_supportCollapseContentDescription);
        CharSequence charSequenceM1553c = c0322arM1541a.m1553c(R.styleable.COUIToolbar_supportTitle);
        if (!TextUtils.isEmpty(charSequenceM1553c)) {
            setTitle(charSequenceM1553c);
        }
        CharSequence charSequenceM1553c2 = c0322arM1541a.m1553c(R.styleable.COUIToolbar_supportSubtitle);
        if (!TextUtils.isEmpty(charSequenceM1553c2)) {
            setSubtitle(charSequenceM1553c2);
        }
        this.f8788k = getContext();
        setPopupTheme(c0322arM1541a.m1560g(R.styleable.COUIToolbar_supportPopupTheme, 0));
        Drawable drawableM1546a = c0322arM1541a.m1546a(R.styleable.COUIToolbar_supportNavigationIcon);
        if (drawableM1546a != null) {
            setNavigationIcon(drawableM1546a);
        }
        CharSequence charSequenceM1553c3 = c0322arM1541a.m1553c(R.styleable.COUIToolbar_supportNavigationContentDescription);
        if (!TextUtils.isEmpty(charSequenceM1553c3)) {
            setNavigationContentDescription(charSequenceM1553c3);
        }
        this.f8764K = c0322arM1541a.m1556e(R.styleable.Toolbar_android_minHeight, 0);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (c0322arM1541a.m1561g(R.styleable.COUIToolbar_minTitleTextSize)) {
            this.f8778aa = c0322arM1541a.m1556e(R.styleable.COUIToolbar_minTitleTextSize, (int) (displayMetrics.scaledDensity * 16.0f));
        } else {
            this.f8778aa = displayMetrics.scaledDensity * 16.0f;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(this.f8790m, new int[]{android.R.attr.textSize});
        if (typedArrayObtainStyledAttributes != null) {
            this.f8776W = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, (int) (displayMetrics.scaledDensity * 24.0f));
            typedArrayObtainStyledAttributes.recycle();
        }
        if (this.f8766M == 1) {
            this.f8776W = COUIChangeTextUtil.m6388a(this.f8776W, getResources().getConfiguration().fontScale, 2);
            this.f8778aa = COUIChangeTextUtil.m6388a(this.f8778aa, getResources().getConfiguration().fontScale, 2);
        }
        this.f8769P = getContext().getResources().getDimensionPixelOffset(R.dimen.toolbar_normal_menu_padding_left);
        this.f8770Q = getContext().getResources().getDimensionPixelOffset(R.dimen.toolbar_normal_menu_padding_right);
        this.f8771R = getContext().getResources().getDimensionPixelOffset(R.dimen.toolbar_center_title_padding_left);
        this.f8772S = getContext().getResources().getDimensionPixelOffset(R.dimen.toolbar_overflow_menu_padding);
        if (c0322arM1541a.m1561g(R.styleable.COUIToolbar_titleCenter)) {
            this.f8765L = c0322arM1541a.m1547a(R.styleable.COUIToolbar_titleCenter, false);
        }
        setWillNotDraw(false);
        c0322arM1541a.m1551b();
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setPopupTheme(int OplusGLSurfaceView_13) {
        if (this.f8789l != OplusGLSurfaceView_13) {
            this.f8789l = OplusGLSurfaceView_13;
            if (OplusGLSurfaceView_13 == 0) {
                this.f8788k = getContext();
            } else {
                this.f8788k = new ContextThemeWrapper(getContext(), OplusGLSurfaceView_13);
            }
        }
    }

    public void setSearchView(View view) {
        m8221a(view, view != null ? new C1525b(view.getLayoutParams()) : null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m8221a(View view, C1525b c1525b) {
        if (view == null) {
            this.f8779b = false;
            return;
        }
        this.f8779b = view != null;
        C1525b c1525b2 = new C1525b(c1525b);
        c1525b2.f8811d = true;
        c1525b2.f8810c = 0;
        addView(view, 0, c1525b2);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public int getPopupTheme() {
        return this.f8789l;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRtlPropertiesChanged(int OplusGLSurfaceView_13) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(OplusGLSurfaceView_13);
        }
        COUIRtlSpacingHelper c1272p = this.f8798u;
        if (c1272p != null) {
            c1272p.m6455a(OplusGLSurfaceView_13 == 1);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setLogo(int OplusGLSurfaceView_13) {
        setLogo(AppCompatResources.m732b(getContext(), OplusGLSurfaceView_13));
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void dismissPopupMenus() {
        ActionMenuView actionMenuView = this.f8780c;
        if (actionMenuView != null) {
            actionMenuView.mo1283i();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            m8205b();
            if (this.f8784g.getParent() == null) {
                m8197a(this.f8784g);
                m8215e(this.f8784g);
            }
        } else {
            ImageView imageView = this.f8784g;
            if (imageView != null && imageView.getParent() != null) {
                removeView(this.f8784g);
            }
        }
        ImageView imageView2 = this.f8784g;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public Drawable getLogo() {
        ImageView imageView = this.f8784g;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setLogoDescription(int OplusGLSurfaceView_13) {
        setLogoDescription(getContext().getText(OplusGLSurfaceView_13));
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m8205b();
        }
        ImageView imageView = this.f8784g;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public CharSequence getLogoDescription() {
        ImageView imageView = this.f8784g;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m8205b() {
        if (this.f8784g == null) {
            this.f8784g = new ImageView(getContext());
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void collapseActionView() {
        C1524a c1524a = this.f8760G;
        MenuItemImpl c0238j = c1524a == null ? null : c1524a.f8808b;
        if (c0238j != null) {
            c0238j.collapseActionView();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public CharSequence getTitle() {
        return this.f8800w;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(int OplusGLSurfaceView_13) {
        setTitle(getContext().getText(OplusGLSurfaceView_13));
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f8781d == null) {
                Context context = getContext();
                this.f8781d = new TextView(context);
                C1525b c1525bGenerateDefaultLayoutParams = generateDefaultLayoutParams();
                c1525bGenerateDefaultLayoutParams.bottomMargin = this.f8797t;
                c1525bGenerateDefaultLayoutParams.f1005a = 8388613 | (this.f8792o & 112);
                this.f8781d.setLayoutParams(c1525bGenerateDefaultLayoutParams);
                this.f8781d.setSingleLine();
                this.f8781d.setEllipsize(TextUtils.TruncateAt.END);
                int OplusGLSurfaceView_13 = this.f8790m;
                if (OplusGLSurfaceView_13 != 0) {
                    this.f8781d.setTextAppearance(context, OplusGLSurfaceView_13);
                }
                int i2 = this.f8802y;
                if (i2 != 0) {
                    this.f8781d.setTextColor(i2);
                }
                if (this.f8766M == 1) {
                    this.f8781d.setTextSize(0, COUIChangeTextUtil.m6388a(this.f8781d.getTextSize(), getContext().getResources().getConfiguration().fontScale, 2));
                }
            }
            if (this.f8781d.getParent() == null) {
                m8197a(this.f8781d);
                m8215e(this.f8781d);
            }
        } else {
            TextView textView = this.f8781d;
            if (textView != null && textView.getParent() != null) {
                removeView(this.f8781d);
            }
        }
        if (this.f8781d != null) {
            if (Build.VERSION.SDK_INT >= 17) {
                this.f8781d.setTextAlignment(5);
            }
            this.f8781d.setText(charSequence);
            this.f8768O = this.f8781d.getTextSize();
        }
        this.f8800w = charSequence;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public CharSequence getSubtitle() {
        return this.f8801x;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(int OplusGLSurfaceView_13) {
        setSubtitle(getContext().getText(OplusGLSurfaceView_13));
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f8782e == null) {
                Context context = getContext();
                this.f8782e = new TextView(context);
                this.f8782e.setSingleLine();
                this.f8782e.setEllipsize(TextUtils.TruncateAt.END);
                int OplusGLSurfaceView_13 = this.f8791n;
                if (OplusGLSurfaceView_13 != 0) {
                    this.f8782e.setTextAppearance(context, OplusGLSurfaceView_13);
                }
                int i2 = this.f8803z;
                if (i2 != 0) {
                    this.f8782e.setTextColor(i2);
                }
            }
            if (this.f8782e.getParent() == null) {
                m8197a(this.f8782e);
                m8215e(this.f8782e);
            }
        } else {
            TextView textView = this.f8782e;
            if (textView != null && textView.getParent() != null) {
                removeView(this.f8782e);
            }
        }
        if (this.f8782e != null) {
            if (Build.VERSION.SDK_INT >= 17) {
                this.f8782e.setTextAlignment(5);
            }
            this.f8782e.setText(charSequence);
        }
        this.f8801x = charSequence;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitleTextAppearance(Context context, int OplusGLSurfaceView_13) {
        this.f8790m = OplusGLSurfaceView_13;
        TextView textView = this.f8781d;
        if (textView != null) {
            textView.setTextAppearance(context, OplusGLSurfaceView_13);
            if (this.f8766M == 1) {
                this.f8781d.setTextSize(0, COUIChangeTextUtil.m6388a(this.f8781d.getTextSize(), getContext().getResources().getConfiguration().fontScale, 2));
            }
            this.f8776W = this.f8781d.getTextSize();
            this.f8768O = this.f8781d.getTextSize();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitleTextAppearance(Context context, int OplusGLSurfaceView_13) {
        this.f8791n = OplusGLSurfaceView_13;
        TextView textView = this.f8782e;
        if (textView != null) {
            textView.setTextAppearance(context, OplusGLSurfaceView_13);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitleTextColor(int OplusGLSurfaceView_13) {
        this.f8802y = OplusGLSurfaceView_13;
        TextView textView = this.f8781d;
        if (textView != null) {
            textView.setTextColor(OplusGLSurfaceView_13);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitleTextColor(int OplusGLSurfaceView_13) {
        this.f8803z = OplusGLSurfaceView_13;
        TextView textView = this.f8782e;
        if (textView != null) {
            textView.setTextColor(OplusGLSurfaceView_13);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f8783f;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationContentDescription(int OplusGLSurfaceView_13) {
        setNavigationContentDescription(OplusGLSurfaceView_13 != 0 ? getContext().getText(OplusGLSurfaceView_13) : null);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m8214e();
        }
        ImageButton imageButton = this.f8783f;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(int OplusGLSurfaceView_13) {
        setNavigationIcon(AppCompatResources.m732b(getContext(), OplusGLSurfaceView_13));
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            m8214e();
            if (this.f8783f.getParent() == null) {
                m8197a(this.f8783f);
                m8215e(this.f8783f);
            }
        } else {
            ImageButton imageButton = this.f8783f;
            if (imageButton != null && imageButton.getParent() != null) {
                removeView(this.f8783f);
            }
        }
        ImageButton imageButton2 = this.f8783f;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f8783f;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        m8214e();
        this.f8783f.setOnClickListener(onClickListener);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public Menu getMenu() {
        m8210c();
        return this.f8780c.getMenu();
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setOverflowIcon(Drawable drawable) {
        m8210c();
        this.f8780c.setOverflowIcon(drawable);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public Drawable getOverflowIcon() {
        m8210c();
        return this.f8780c.getOverflowIcon();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m8210c() {
        m8213d();
        if (this.f8780c.m1278d() == null) {
            MenuBuilder c0236h = (MenuBuilder) this.f8780c.getMenu();
            if (this.f8760G == null) {
                this.f8760G = new C1524a();
            }
            this.f8780c.setExpandedActionViewsExclusive(true);
            c0236h.addMenuPresenter(this.f8760G, this.f8788k);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m8213d() {
        if (this.f8780c == null) {
            this.f8780c = new COUIActionMenuView(getContext());
            this.f8780c.setPopupTheme(this.f8789l);
            this.f8780c.setOnMenuItemClickListener(this.f8759F);
            this.f8780c.m1273a(this.f8761H, this.f8762I);
            C1525b c1525bGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            if (this.f8765L) {
                c1525bGenerateDefaultLayoutParams.width = -1;
            } else {
                c1525bGenerateDefaultLayoutParams.width = -2;
            }
            c1525bGenerateDefaultLayoutParams.f1005a = 8388613 | (this.f8792o & 112);
            this.f8780c.setLayoutParams(c1525bGenerateDefaultLayoutParams);
            m8197a(this.f8780c);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setOnMenuItemClickListener(Toolbar.InterfaceC0302c interfaceC0302c) {
        this.f8758E = interfaceC0302c;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setContentInsetsRelative(int OplusGLSurfaceView_13, int i2) {
        this.f8798u.m6454a(OplusGLSurfaceView_13, i2);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public int getContentInsetStart() {
        return this.f8798u.m6458c();
    }

    @Override // androidx.appcompat.widget.Toolbar
    public int getContentInsetEnd() {
        return this.f8798u.m6459d();
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setContentInsetsAbsolute(int OplusGLSurfaceView_13, int i2) {
        this.f8798u.m6457b(OplusGLSurfaceView_13, i2);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public int getContentInsetLeft() {
        return this.f8798u.m6453a();
    }

    @Override // androidx.appcompat.widget.Toolbar
    public int getContentInsetRight() {
        return this.f8798u.m6456b();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m8214e() {
        if (this.f8783f == null) {
            this.f8783f = new ImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            C1525b c1525bGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            c1525bGenerateDefaultLayoutParams.f1005a = 8388611 | (this.f8792o & 112);
            this.f8783f.setLayoutParams(c1525bGenerateDefaultLayoutParams);
            this.f8783f.setBackgroundResource(R.drawable.coui_toolbar_menu_bg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m8216f() {
        if (this.f8787j == null) {
            this.f8787j = new ImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            this.f8787j.setImageDrawable(this.f8785h);
            this.f8787j.setContentDescription(this.f8786i);
            C1525b c1525bGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            c1525bGenerateDefaultLayoutParams.f1005a = 8388611 | (this.f8792o & 112);
            c1525bGenerateDefaultLayoutParams.f8810c = 2;
            this.f8787j.setLayoutParams(c1525bGenerateDefaultLayoutParams);
            this.f8787j.setOnClickListener(new View.OnClickListener() { // from class: com.coui.appcompat.widget.toolbar.COUIToolbar.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    COUIToolbar.this.collapseActionView();
                }
            });
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m8197a(View view) {
        C1525b c1525bGenerateLayoutParams;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            c1525bGenerateLayoutParams = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(layoutParams)) {
            c1525bGenerateLayoutParams = generateLayoutParams(layoutParams);
        } else {
            c1525bGenerateLayoutParams = (C1525b) layoutParams;
        }
        c1525bGenerateLayoutParams.f8810c = 1;
        addView(view, c1525bGenerateLayoutParams);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f8774U);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int iM2794a = MotionEventCompat.m2794a(motionEvent);
        if (iM2794a == 0) {
            this.f8754A = false;
        }
        if (!this.f8754A) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (iM2794a == 0 && !zOnTouchEvent) {
                this.f8754A = true;
            }
        }
        if (iM2794a == 1 || iM2794a == 3) {
            this.f8754A = false;
        }
        return true;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int iM2794a = MotionEventCompat.m2794a(motionEvent);
        if (iM2794a == 9) {
            this.f8755B = false;
        }
        if (!this.f8755B) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (iM2794a == 9 && !zOnHoverEvent) {
                this.f8755B = true;
            }
        }
        if (iM2794a == 10 || iM2794a == 3) {
            this.f8755B = false;
        }
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m8198a(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5) {
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

    /* renamed from: PlatformImplementations.kt_3 */
    private int m8193a(View view, int OplusGLSurfaceView_13, int i2, int i3, int i4, int[] iArr) {
        int childMeasureSpec;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        boolean z = false;
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        if ((marginLayoutParams instanceof C1525b) && ((C1525b) marginLayoutParams).f8811d && this.f8779b) {
            z = true;
        }
        if (z) {
            childMeasureSpec = getChildMeasureSpec(OplusGLSurfaceView_13, getContentInsetStart() + iMax + getContentInsetStart(), marginLayoutParams.width);
        } else {
            childMeasureSpec = getChildMeasureSpec(OplusGLSurfaceView_13, getPaddingLeft() + getPaddingRight() + iMax + i2, marginLayoutParams.width);
        }
        view.measure(childMeasureSpec, getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return z ? iMax : view.getMeasuredWidth() + iMax;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean m8217g() {
        if (!this.f8763J) {
            return false;
        }
        int childCount = getChildCount();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            View childAt = getChildAt(OplusGLSurfaceView_13);
            if (m8207b(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) throws Resources.NotFoundException {
        char c2;
        char c3;
        int measuredWidth;
        int iMax;
        int iCombineMeasuredStates;
        int measuredWidth2;
        int i3;
        int i4;
        int iCombineMeasuredStates2;
        int iMax2;
        int measuredHeight;
        char c4;
        char c5;
        int measuredWidth3;
        int iCombineMeasuredStates3;
        int iMax3;
        int i5;
        int iCombineMeasuredStates4;
        int measuredHeight2;
        int iMax4;
        int iCombineMeasuredStates5;
        int i6;
        int i7;
        boolean z = ViewCompat.m2885g(this) == 1;
        if (this.f8765L) {
            int[] iArr = this.f8757D;
            if (ViewUtils_2.m1623a(this)) {
                c5 = 1;
                c4 = 0;
            } else {
                c4 = 1;
                c5 = 0;
            }
            int contentInsetStart = getContentInsetStart();
            int iMax5 = Math.max(contentInsetStart, 0) + 0;
            iArr[c5] = Math.max(0, contentInsetStart - 0);
            if (m8207b(this.f8780c)) {
                m8199a((MenuBuilder) this.f8780c.getMenu(), z);
                m8198a(this.f8780c, OplusGLSurfaceView_13, 0, i2, 0, this.f8793p);
                measuredWidth3 = this.f8780c.getMeasuredWidth() + m8208c(this.f8780c);
                iMax3 = Math.max(0, this.f8780c.getMeasuredHeight() + m8211d(this.f8780c));
                iCombineMeasuredStates3 = View.combineMeasuredStates(0, ViewCompat.m2887h(this.f8780c));
            } else {
                measuredWidth3 = 0;
                iCombineMeasuredStates3 = 0;
                iMax3 = 0;
            }
            int contentInsetEnd = getContentInsetEnd();
            int iMax6 = iMax5 + Math.max(contentInsetEnd, measuredWidth3);
            iArr[c4] = Math.max(0, contentInsetEnd - measuredWidth3);
            if (m8207b(this.f8777a)) {
                iMax6 += m8193a(this.f8777a, OplusGLSurfaceView_13, iMax6, i2, 0, iArr);
                iMax3 = Math.max(iMax3, this.f8777a.getMeasuredHeight() + m8211d(this.f8777a));
                iCombineMeasuredStates3 = View.combineMeasuredStates(iCombineMeasuredStates3, ViewCompat.m2887h(this.f8777a));
            }
            int iCombineMeasuredStates6 = iCombineMeasuredStates3;
            int childCount = getChildCount();
            int iMax7 = iMax3;
            int i8 = 0;
            while (i8 < childCount) {
                View childAt = getChildAt(i8);
                if (((C1525b) childAt.getLayoutParams()).f8810c == 0 && m8207b(childAt)) {
                    i7 = childCount;
                    iMax6 += m8193a(childAt, OplusGLSurfaceView_13, iMax6, i2, 0, iArr);
                    iMax7 = Math.max(iMax7, childAt.getMeasuredHeight() + m8211d(childAt));
                    iCombineMeasuredStates6 = View.combineMeasuredStates(iCombineMeasuredStates6, ViewCompat.m2887h(childAt));
                } else {
                    i7 = childCount;
                    iMax7 = iMax7;
                }
                i8++;
                childCount = i7;
            }
            int i9 = iMax7;
            int i10 = this.f8796s + this.f8797t;
            int i11 = this.f8794q;
            int i12 = this.f8795r;
            if (m8207b(this.f8781d)) {
                this.f8781d.getLayoutParams().width = -2;
                this.f8781d.setTextSize(0, this.f8768O);
                i5 = -2;
                m8193a(this.f8781d, OplusGLSurfaceView_13, 0, i2, i10, iArr);
                int measuredWidth4 = this.f8781d.getMeasuredWidth() + m8208c(this.f8781d);
                measuredHeight2 = this.f8781d.getMeasuredHeight() + m8211d(this.f8781d);
                iCombineMeasuredStates4 = View.combineMeasuredStates(iCombineMeasuredStates6, ViewCompat.m2887h(this.f8781d));
                iMax4 = measuredWidth4;
            } else {
                i5 = -2;
                iCombineMeasuredStates4 = iCombineMeasuredStates6;
                measuredHeight2 = 0;
                iMax4 = 0;
            }
            if (m8207b(this.f8782e)) {
                this.f8782e.getLayoutParams().width = i5;
                i6 = measuredHeight2;
                iMax4 = Math.max(iMax4, m8193a(this.f8782e, OplusGLSurfaceView_13, 0, i2, measuredHeight2 + i10, iArr));
                iCombineMeasuredStates5 = View.combineMeasuredStates(iCombineMeasuredStates4, ViewCompat.m2887h(this.f8782e));
            } else {
                iCombineMeasuredStates5 = iCombineMeasuredStates4;
                i6 = measuredHeight2;
            }
            int iMax8 = Math.max(i9, i6);
            int paddingLeft = iMax6 + iMax4 + getPaddingLeft() + getPaddingRight();
            int paddingTop = iMax8 + getPaddingTop() + getPaddingBottom();
            int iM2837a = ViewCompat.m2837a(Math.max(paddingLeft, getSuggestedMinimumWidth()), OplusGLSurfaceView_13, (-16777216) & iCombineMeasuredStates5);
            int iM2837a2 = ViewCompat.m2837a(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, iCombineMeasuredStates5 << 16);
            if (m8217g()) {
                iM2837a2 = 0;
            }
            setMeasuredDimension(iM2837a, iM2837a2);
            m8202a(this.f8767N);
            int[] iArr2 = this.f8767N;
            int i13 = iArr2[1] - iArr2[0];
            if (m8207b(this.f8781d)) {
                int measuredWidth5 = this.f8781d.getMeasuredWidth();
                int[] iArr3 = this.f8767N;
                if (measuredWidth5 > iArr3[1] - iArr3[0]) {
                    m8193a(this.f8781d, View.MeasureSpec.makeMeasureSpec(i13, Integer.MIN_VALUE), 0, i2, i10, iArr);
                }
            }
            if (m8207b(this.f8782e)) {
                int measuredWidth6 = this.f8782e.getMeasuredWidth();
                int[] iArr4 = this.f8767N;
                if (measuredWidth6 > iArr4[1] - iArr4[0]) {
                    m8193a(this.f8782e, View.MeasureSpec.makeMeasureSpec(i13, Integer.MIN_VALUE), 0, i2, i6 + i10, iArr);
                    return;
                }
                return;
            }
            return;
        }
        int[] iArr5 = this.f8757D;
        if (ViewUtils_2.m1623a(this)) {
            c3 = 1;
            c2 = 0;
        } else {
            c2 = 1;
            c3 = 0;
        }
        if (m8207b(this.f8783f)) {
            m8198a(this.f8783f, OplusGLSurfaceView_13, 0, i2, 0, this.f8793p);
            measuredWidth = this.f8783f.getMeasuredWidth() + m8208c(this.f8783f);
            iMax = Math.max(0, this.f8783f.getMeasuredHeight() + m8211d(this.f8783f));
            iCombineMeasuredStates = View.combineMeasuredStates(0, ViewCompat.m2887h(this.f8783f));
        } else {
            measuredWidth = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (m8207b(this.f8787j)) {
            m8198a(this.f8787j, OplusGLSurfaceView_13, 0, i2, 0, this.f8793p);
            measuredWidth = this.f8787j.getMeasuredWidth() + m8208c(this.f8787j);
            iMax = Math.max(iMax, this.f8787j.getMeasuredHeight() + m8211d(this.f8787j));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, ViewCompat.m2887h(this.f8787j));
        }
        int contentInsetStart2 = getContentInsetStart();
        int iMax9 = 0 + Math.max(contentInsetStart2, measuredWidth);
        iArr5[c3] = Math.max(0, contentInsetStart2 - measuredWidth);
        if (m8207b(this.f8780c)) {
            m8199a((MenuBuilder) this.f8780c.getMenu(), z);
            m8198a(this.f8780c, OplusGLSurfaceView_13, iMax9, i2, 0, this.f8793p);
            measuredWidth2 = this.f8780c.getMeasuredWidth() + m8208c(this.f8780c);
            iMax = Math.max(iMax, this.f8780c.getMeasuredHeight() + m8211d(this.f8780c));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, ViewCompat.m2887h(this.f8780c));
        } else {
            measuredWidth2 = 0;
        }
        int contentInsetEnd2 = getContentInsetEnd();
        int iMax10 = iMax9 + Math.max(contentInsetEnd2, measuredWidth2);
        iArr5[c2] = Math.max(0, contentInsetEnd2 - measuredWidth2);
        if (m8207b(this.f8777a)) {
            iMax10 += m8193a(this.f8777a, OplusGLSurfaceView_13, iMax10, i2, 0, iArr5);
            iMax = Math.max(iMax, this.f8777a.getMeasuredHeight() + m8211d(this.f8777a));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, ViewCompat.m2887h(this.f8777a));
        }
        if (m8207b(this.f8784g)) {
            iMax10 += m8193a(this.f8784g, OplusGLSurfaceView_13, iMax10, i2, 0, iArr5);
            iMax = Math.max(iMax, this.f8784g.getMeasuredHeight() + m8211d(this.f8784g));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, ViewCompat.m2887h(this.f8784g));
        }
        int childCount2 = getChildCount();
        int iM8193a = iMax10;
        for (int i14 = 0; i14 < childCount2; i14++) {
            View childAt2 = getChildAt(i14);
            if (((C1525b) childAt2.getLayoutParams()).f8810c == 0 && m8207b(childAt2)) {
                iM8193a += m8193a(childAt2, OplusGLSurfaceView_13, iM8193a, i2, 0, iArr5);
                iMax = Math.max(iMax, childAt2.getMeasuredHeight() + m8211d(childAt2));
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, ViewCompat.m2887h(childAt2));
            }
        }
        int i15 = this.f8796s + this.f8797t;
        int i16 = this.f8794q + this.f8795r;
        if (m8207b(this.f8781d)) {
            this.f8781d.getLayoutParams().width = -1;
            this.f8781d.setTextSize(0, this.f8768O);
            i4 = 0;
            i3 = -1;
            m8193a(this.f8781d, OplusGLSurfaceView_13, iM8193a + i16, i2, i15, iArr5);
            int measuredWidth7 = this.f8781d.getMeasuredWidth() + m8208c(this.f8781d);
            measuredHeight = this.f8781d.getMeasuredHeight() + m8211d(this.f8781d);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, ViewCompat.m2887h(this.f8781d));
            iMax2 = measuredWidth7;
        } else {
            i3 = -1;
            i4 = 0;
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
            measuredHeight = 0;
        }
        if (m8207b(this.f8782e)) {
            this.f8782e.getLayoutParams().width = i3;
            iMax2 = Math.max(iMax2, m8193a(this.f8782e, OplusGLSurfaceView_13, iM8193a + i16, i2, measuredHeight + i15, iArr5));
            measuredHeight += this.f8782e.getMeasuredHeight() + m8211d(this.f8782e);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, ViewCompat.m2887h(this.f8782e));
        }
        int iMax11 = Math.max(iMax, measuredHeight);
        int paddingLeft2 = iM8193a + iMax2 + getPaddingLeft() + getPaddingRight();
        int paddingTop2 = iMax11 + getPaddingTop() + getPaddingBottom();
        int iM2837a3 = ViewCompat.m2837a(Math.max(paddingLeft2, getSuggestedMinimumWidth()), OplusGLSurfaceView_13, (-16777216) & iCombineMeasuredStates2);
        int iM2837a4 = ViewCompat.m2837a(Math.max(paddingTop2, getSuggestedMinimumHeight()), i2, iCombineMeasuredStates2 << 16);
        if (m8217g()) {
            iM2837a4 = i4;
        }
        setMeasuredDimension(iM2837a3, iM2837a4);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m8199a(MenuBuilder c0236h, boolean z) {
        int paddingLeft;
        if (c0236h == null) {
            return;
        }
        boolean z2 = false;
        if (getChildCount() > 0 && (getChildAt(0) instanceof COUISearchViewAnimate)) {
            z2 = true;
        }
        if (!c0236h.getNonActionItems().isEmpty()) {
            if (z) {
                setPadding(this.f8770Q, getPaddingTop(), this.f8765L ? this.f8771R : this.f8769P, getPaddingBottom());
                return;
            } else {
                setPadding(this.f8765L ? this.f8771R : this.f8769P, getPaddingTop(), this.f8770Q, getPaddingBottom());
                return;
            }
        }
        if (z) {
            setPadding(z2 ? getPaddingLeft() : this.f8770Q, getPaddingTop(), z2 ? getPaddingRight() : this.f8765L ? this.f8771R : this.f8769P, getPaddingBottom());
            return;
        }
        if (z2) {
            paddingLeft = getPaddingLeft();
        } else {
            paddingLeft = this.f8765L ? this.f8771R : this.f8769P;
        }
        setPadding(paddingLeft, getPaddingTop(), z2 ? getPaddingRight() : this.f8770Q, getPaddingBottom());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m8202a(int[] iArr) throws Resources.NotFoundException {
        int measuredWidth;
        int measuredWidth2;
        boolean z = ViewCompat.m2885g(this) == 1;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.coui_actionbar_menuitemview_item_spacing);
        iArr[0] = Math.max(this.f8798u.m6453a(), getPaddingLeft());
        iArr[1] = getMeasuredWidth() - Math.max(this.f8798u.m6456b(), getPaddingRight());
        if (!m8207b(this.f8780c) || this.f8780c.getChildCount() == 0) {
            return;
        }
        if (this.f8780c.getChildCount() == 1) {
            measuredWidth2 = this.f8780c.getChildAt(0).getMeasuredWidth() + dimensionPixelSize + 0;
            measuredWidth = 0;
        } else {
            measuredWidth = this.f8780c.getChildAt(0).getMeasuredWidth() + dimensionPixelSize + 0;
            int measuredWidth3 = 0;
            for (int OplusGLSurfaceView_13 = 1; OplusGLSurfaceView_13 < this.f8780c.getChildCount(); OplusGLSurfaceView_13++) {
                measuredWidth3 += this.f8780c.getChildAt(OplusGLSurfaceView_13).getMeasuredWidth() + dimensionPixelSize;
            }
            measuredWidth2 = measuredWidth3;
        }
        if (z) {
            iArr[0] = iArr[0] + measuredWidth2;
            iArr[1] = iArr[1] - measuredWidth;
        } else {
            iArr[0] = iArr[0] + measuredWidth;
            iArr[1] = iArr[1] - measuredWidth2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0453 A[LOOP:2: B:162:0x0451->B:163:0x0453, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0277  */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 1128
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.widget.toolbar.COUIToolbar.onLayout(boolean, int, int, int, int):void");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m8195a(List<View> list, int[] iArr) {
        int OplusGLSurfaceView_13 = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = i2;
        int i4 = OplusGLSurfaceView_13;
        int i5 = 0;
        int measuredWidth = 0;
        while (i5 < size) {
            View view = list.get(i5);
            C1525b c1525b = (C1525b) view.getLayoutParams();
            int i6 = c1525b.leftMargin - i4;
            int i7 = c1525b.rightMargin - i3;
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

    /* renamed from: PlatformImplementations.kt_3 */
    private int m8194a(View view, int OplusGLSurfaceView_13, int[] iArr, int i2) {
        C1525b c1525b = (C1525b) view.getLayoutParams();
        int i3 = c1525b.leftMargin - iArr[0];
        int iMax = OplusGLSurfaceView_13 + Math.max(0, i3);
        iArr[0] = Math.max(0, -i3);
        int iM8192a = m8192a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iM8192a, iMax + measuredWidth, view.getMeasuredHeight() + iM8192a);
        return iMax + measuredWidth + c1525b.rightMargin;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int m8204b(View view, int OplusGLSurfaceView_13, int[] iArr, int i2) {
        C1525b c1525b = (C1525b) view.getLayoutParams();
        int i3 = c1525b.rightMargin - iArr[1];
        int iMax = OplusGLSurfaceView_13 - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int iM8192a = m8192a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iM8192a, iMax, view.getMeasuredHeight() + iM8192a);
        return iMax - (measuredWidth + c1525b.leftMargin);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m8192a(View view, int OplusGLSurfaceView_13) {
        C1525b c1525b = (C1525b) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = OplusGLSurfaceView_13 > 0 ? (measuredHeight - OplusGLSurfaceView_13) / 2 : 0;
        int iM8191a = m8191a(c1525b.f1005a);
        if (iM8191a == 48) {
            return getPaddingTop() - i2;
        }
        if (iM8191a == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - c1525b.bottomMargin) - i2;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        if (iMax < c1525b.topMargin) {
            iMax = c1525b.topMargin;
        } else {
            int i3 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            if (i3 < c1525b.bottomMargin) {
                iMax = Math.max(0, iMax - (c1525b.bottomMargin - i3));
            }
        }
        return paddingTop + iMax;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m8191a(int OplusGLSurfaceView_13) {
        int i2 = OplusGLSurfaceView_13 & 112;
        return (i2 == 16 || i2 == 48 || i2 == 80) ? i2 : this.f8799v & 112;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m8201a(List<View> list, int OplusGLSurfaceView_13) {
        boolean z = ViewCompat.m2885g(this) == 1;
        int childCount = getChildCount();
        int iM2773a = GravityCompat.m2773a(OplusGLSurfaceView_13, ViewCompat.m2885g(this));
        list.clear();
        if (!z) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                C1525b c1525b = (C1525b) childAt.getLayoutParams();
                if (c1525b.f8810c == 0 && m8207b(childAt) && m8203b(c1525b.f1005a) == iM2773a) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i3 = childCount - 1; i3 >= 0; i3--) {
            View childAt2 = getChildAt(i3);
            C1525b c1525b2 = (C1525b) childAt2.getLayoutParams();
            if (c1525b2.f8810c == 0 && m8207b(childAt2) && m8203b(c1525b2.f1005a) == iM2773a) {
                list.add(childAt2);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int m8203b(int OplusGLSurfaceView_13) {
        int iM2885g = ViewCompat.m2885g(this);
        int iM2773a = GravityCompat.m2773a(OplusGLSurfaceView_13, iM2885g) & 7;
        return (iM2773a == 1 || iM2773a == 3 || iM2773a == 5) ? iM2773a : iM2885g == 1 ? 5 : 3;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m8207b(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int m8208c(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return MarginLayoutParamsCompat.m2783a(marginLayoutParams) + MarginLayoutParamsCompat.m2785b(marginLayoutParams);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int m8211d(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public C1525b generateLayoutParams(AttributeSet attributeSet) {
        return new C1525b(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public C1525b generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof C1525b) {
            return new C1525b((C1525b) layoutParams);
        }
        if (layoutParams instanceof ActionBar.PlatformImplementations.kt_3) {
            return new C1525b((ActionBar.PlatformImplementations.kt_3) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new C1525b((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new C1525b(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public C1525b generateDefaultLayoutParams() {
        return new C1525b(-2, -2);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof C1525b);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void inflateMenu(int OplusGLSurfaceView_13) {
        super.inflateMenu(OplusGLSurfaceView_13);
        ActionMenuView actionMenuView = this.f8780c;
        if (actionMenuView instanceof COUIActionMenuView) {
            ((COUIActionMenuView) actionMenuView).m8236j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChildVisibilityForExpandedActionView(boolean z) {
        int childCount = getChildCount();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            View childAt = getChildAt(OplusGLSurfaceView_13);
            if (((C1525b) childAt.getLayoutParams()).f8810c != 2 && childAt != this.f8780c) {
                childAt.setVisibility(z ? 8 : 0);
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m8215e(View view) {
        if (((C1525b) view.getLayoutParams()).f8810c == 2 || view == this.f8780c) {
            return;
        }
        view.setVisibility(this.f8777a != null ? 8 : 0);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setCollapsible(boolean z) {
        this.f8763J = z;
        requestLayout();
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setMenuCallbacks(MenuPresenter.PlatformImplementations.kt_3 aVar, MenuBuilder.PlatformImplementations.kt_3 aVar2) {
        this.f8761H = aVar;
        this.f8762I = aVar2;
    }

    @Override // android.view.View
    public void setMinimumHeight(int OplusGLSurfaceView_13) {
        this.f8764K = OplusGLSurfaceView_13;
        super.setMinimumHeight(OplusGLSurfaceView_13);
    }

    private int getMinimumHeightCompat() {
        if (Build.VERSION.SDK_INT >= 16) {
            return ViewCompat.m2894m(this);
        }
        return this.f8764K;
    }

    /* renamed from: com.coui.appcompat.widget.toolbar.COUIToolbar$IntrinsicsJvm.kt_4 */
    public static class C1525b extends Toolbar.C0301b {

        /* renamed from: IntrinsicsJvm.kt_3 */
        int f8810c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        boolean f8811d;

        public C1525b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f8810c = 0;
            this.f8811d = false;
        }

        public C1525b(int OplusGLSurfaceView_13, int i2) {
            super(OplusGLSurfaceView_13, i2);
            this.f8810c = 0;
            this.f8811d = false;
            this.f1005a = 8388627;
        }

        public C1525b(C1525b c1525b) {
            super((Toolbar.C0301b) c1525b);
            this.f8810c = 0;
            this.f8811d = false;
            this.f8810c = c1525b.f8810c;
        }

        public C1525b(ActionBar.PlatformImplementations.kt_3 aVar) {
            super(aVar);
            this.f8810c = 0;
            this.f8811d = false;
        }

        public C1525b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f8810c = 0;
            this.f8811d = false;
            m8222a(marginLayoutParams);
        }

        public C1525b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f8810c = 0;
            this.f8811d = false;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        void m8222a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    /* renamed from: com.coui.appcompat.widget.toolbar.COUIToolbar$PlatformImplementations.kt_3 */
    private class C1524a implements MenuPresenter {

        /* renamed from: PlatformImplementations.kt_3 */
        MenuBuilder f8807a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        MenuItemImpl f8808b;

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

        private C1524a() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void initForMenu(Context context, MenuBuilder c0236h) {
            MenuItemImpl c0238j;
            MenuBuilder c0236h2 = this.f8807a;
            if (c0236h2 != null && (c0238j = this.f8808b) != null) {
                c0236h2.collapseItemActionView(c0238j);
            }
            this.f8807a = c0236h;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void updateMenuView(boolean z) {
            if (this.f8808b != null) {
                MenuBuilder c0236h = this.f8807a;
                boolean z2 = false;
                if (c0236h != null) {
                    int size = c0236h.size();
                    int OplusGLSurfaceView_13 = 0;
                    while (true) {
                        if (OplusGLSurfaceView_13 >= size) {
                            break;
                        }
                        if (this.f8807a.getItem(OplusGLSurfaceView_13) == this.f8808b) {
                            z2 = true;
                            break;
                        }
                        OplusGLSurfaceView_13++;
                    }
                }
                if (z2) {
                    return;
                }
                collapseItemActionView(this.f8807a, this.f8808b);
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean expandItemActionView(MenuBuilder c0236h, MenuItemImpl c0238j) {
            COUIToolbar.this.m8216f();
            ViewParent parent = COUIToolbar.this.f8787j.getParent();
            COUIToolbar cOUIToolbar = COUIToolbar.this;
            if (parent != cOUIToolbar) {
                cOUIToolbar.addView(cOUIToolbar.f8787j);
            }
            COUIToolbar.this.f8777a = c0238j.getActionView();
            this.f8808b = c0238j;
            ViewParent parent2 = COUIToolbar.this.f8777a.getParent();
            COUIToolbar cOUIToolbar2 = COUIToolbar.this;
            if (parent2 != cOUIToolbar2) {
                C1525b c1525bGenerateDefaultLayoutParams = cOUIToolbar2.generateDefaultLayoutParams();
                c1525bGenerateDefaultLayoutParams.f1005a = 8388611 | (COUIToolbar.this.f8792o & 112);
                c1525bGenerateDefaultLayoutParams.f8810c = 2;
                COUIToolbar.this.f8777a.setLayoutParams(c1525bGenerateDefaultLayoutParams);
                COUIToolbar cOUIToolbar3 = COUIToolbar.this;
                cOUIToolbar3.addView(cOUIToolbar3.f8777a);
            }
            COUIToolbar.this.setChildVisibilityForExpandedActionView(true);
            COUIToolbar.this.requestLayout();
            c0238j.m1175e(true);
            if (COUIToolbar.this.f8777a instanceof CollapsibleActionView) {
                ((CollapsibleActionView) COUIToolbar.this.f8777a).mo1058a();
            }
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean collapseItemActionView(MenuBuilder c0236h, MenuItemImpl c0238j) {
            if (COUIToolbar.this.f8777a instanceof CollapsibleActionView) {
                ((CollapsibleActionView) COUIToolbar.this.f8777a).mo1059b();
            }
            COUIToolbar cOUIToolbar = COUIToolbar.this;
            cOUIToolbar.removeView(cOUIToolbar.f8777a);
            COUIToolbar cOUIToolbar2 = COUIToolbar.this;
            cOUIToolbar2.removeView(cOUIToolbar2.f8787j);
            COUIToolbar cOUIToolbar3 = COUIToolbar.this;
            cOUIToolbar3.f8777a = null;
            cOUIToolbar3.setChildVisibilityForExpandedActionView(false);
            this.f8808b = null;
            COUIToolbar.this.requestLayout();
            c0238j.m1175e(false);
            return true;
        }
    }

    public void setIsTitleCenterStyle(boolean z) {
        m8213d();
        this.f8765L = z;
        C1525b c1525b = (C1525b) this.f8780c.getLayoutParams();
        if (this.f8765L) {
            c1525b.width = -1;
        } else {
            c1525b.width = -2;
        }
        this.f8780c.setLayoutParams(c1525b);
        requestLayout();
    }

    public boolean getIsTitleCenterStyle() {
        return this.f8765L;
    }

    public void setMinTitleTextSize(float COUIBaseListPopupWindow_12) {
        float f2 = this.f8776W;
        if (COUIBaseListPopupWindow_12 > f2) {
            COUIBaseListPopupWindow_12 = f2;
        }
        this.f8778aa = COUIBaseListPopupWindow_12;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitleMarginStart(int OplusGLSurfaceView_13) {
        this.f8794q = OplusGLSurfaceView_13;
        requestLayout();
    }

    @Override // androidx.appcompat.widget.Toolbar
    public boolean showOverflowMenu() {
        ActionMenuView actionMenuView = this.f8780c;
        if (actionMenuView instanceof COUIActionMenuView) {
            return actionMenuView.mo1279e();
        }
        return super.showOverflowMenu();
    }

    public void setPopupWindowOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        ActionMenuView actionMenuView = this.f8780c;
        if (actionMenuView instanceof COUIActionMenuView) {
            ((COUIActionMenuView) actionMenuView).setPopupWindowOnDismissListener(onDismissListener);
        }
    }

    public void setTitleTextViewTypeface(Typeface typeface) {
        this.f8781d.setTypeface(typeface);
    }
}
