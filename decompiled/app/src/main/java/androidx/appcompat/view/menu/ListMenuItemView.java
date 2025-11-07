package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.p036h.ViewCompat;

/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements AbsListView.SelectionBoundsAdjuster, MenuView.PlatformImplementations.kt_3 {

    /* renamed from: PlatformImplementations.kt_3 */
    private MenuItemImpl f1242a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private ImageView f1243b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private RadioButton f1244c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private TextView f1245d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private CheckBox f1246e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private TextView f1247f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private ImageView f1248g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private ImageView f1249h;

    /* renamed from: OplusGLSurfaceView_13 */
    private LinearLayout f1250i;

    /* renamed from: OplusGLSurfaceView_15 */
    private Drawable f1251j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f1252k;

    /* renamed from: OplusGLSurfaceView_14 */
    private Context f1253l;

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean f1254m;

    /* renamed from: OplusGLSurfaceView_11 */
    private Drawable f1255n;

    /* renamed from: o */
    private boolean f1256o;

    /* renamed from: p */
    private int f1257p;

    /* renamed from: q */
    private LayoutInflater f1258q;

    /* renamed from: r */
    private boolean f1259r;

    @Override // androidx.appcompat.view.menu.MenuView.PlatformImplementations.kt_3
    public boolean prefersCondensedTitle() {
        return false;
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listMenuViewStyle);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet);
        TintTypedArray c0322arM1541a = TintTypedArray.m1541a(getContext(), attributeSet, R.styleable.MenuView, OplusGLSurfaceView_13, 0);
        this.f1251j = c0322arM1541a.m1546a(R.styleable.MenuView_android_itemBackground);
        this.f1252k = c0322arM1541a.m1560g(R.styleable.MenuView_android_itemTextAppearance, -1);
        this.f1254m = c0322arM1541a.m1547a(R.styleable.MenuView_preserveIconSpacing, false);
        this.f1253l = context;
        this.f1255n = c0322arM1541a.m1546a(R.styleable.MenuView_subMenuArrow);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{android.R.attr.divider}, R.attr.dropDownListViewStyle, 0);
        this.f1256o = typedArrayObtainStyledAttributes.hasValue(0);
        c0322arM1541a.m1551b();
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        ViewCompat.m2850a(this, this.f1251j);
        this.f1245d = (TextView) findViewById(R.id_renamed.title);
        int OplusGLSurfaceView_13 = this.f1252k;
        if (OplusGLSurfaceView_13 != -1) {
            this.f1245d.setTextAppearance(this.f1253l, OplusGLSurfaceView_13);
        }
        this.f1247f = (TextView) findViewById(R.id_renamed.shortcut);
        this.f1248g = (ImageView) findViewById(R.id_renamed.submenuarrow);
        ImageView imageView = this.f1248g;
        if (imageView != null) {
            imageView.setImageDrawable(this.f1255n);
        }
        this.f1249h = (ImageView) findViewById(R.id_renamed.group_divider);
        this.f1250i = (LinearLayout) findViewById(R.id_renamed.content);
    }

    @Override // androidx.appcompat.view.menu.MenuView.PlatformImplementations.kt_3
    public void initialize(MenuItemImpl c0238j, int OplusGLSurfaceView_13) {
        this.f1242a = c0238j;
        this.f1257p = OplusGLSurfaceView_13;
        setVisibility(c0238j.isVisible() ? 0 : 8);
        setTitle(c0238j.m1163a((MenuView.PlatformImplementations.kt_3) this));
        setCheckable(c0238j.isCheckable());
        m1093a(c0238j.m1176f(), c0238j.m1172d());
        setIcon(c0238j.getIcon());
        setEnabled(c0238j.isEnabled());
        setSubMenuArrowVisible(c0238j.hasSubMenu());
        setContentDescription(c0238j.getContentDescription());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m1089a(View view) {
        m1090a(view, -1);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m1090a(View view, int OplusGLSurfaceView_13) {
        LinearLayout linearLayout = this.f1250i;
        if (linearLayout != null) {
            linearLayout.addView(view, OplusGLSurfaceView_13);
        } else {
            addView(view, OplusGLSurfaceView_13);
        }
    }

    public void setForceShowIcon(boolean z) {
        this.f1259r = z;
        this.f1254m = z;
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f1245d.setText(charSequence);
            if (this.f1245d.getVisibility() != 0) {
                this.f1245d.setVisibility(0);
                return;
            }
            return;
        }
        if (this.f1245d.getVisibility() != 8) {
            this.f1245d.setVisibility(8);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.PlatformImplementations.kt_3
    public MenuItemImpl getItemData() {
        return this.f1242a;
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (!z && this.f1244c == null && this.f1246e == null) {
            return;
        }
        if (this.f1242a.m1177g()) {
            if (this.f1244c == null) {
                m1091b();
            }
            compoundButton = this.f1244c;
            compoundButton2 = this.f1246e;
        } else {
            if (this.f1246e == null) {
                m1092c();
            }
            compoundButton = this.f1246e;
            compoundButton2 = this.f1244c;
        }
        if (z) {
            compoundButton.setChecked(this.f1242a.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (compoundButton2 == null || compoundButton2.getVisibility() == 8) {
                return;
            }
            compoundButton2.setVisibility(8);
            return;
        }
        CheckBox checkBox = this.f1246e;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.f1244c;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f1242a.m1177g()) {
            if (this.f1244c == null) {
                m1091b();
            }
            compoundButton = this.f1244c;
        } else {
            if (this.f1246e == null) {
                m1092c();
            }
            compoundButton = this.f1246e;
        }
        compoundButton.setChecked(z);
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView = this.f1248g;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m1093a(boolean z, char c2) {
        int OplusGLSurfaceView_13 = (z && this.f1242a.m1176f()) ? 0 : 8;
        if (OplusGLSurfaceView_13 == 0) {
            this.f1247f.setText(this.f1242a.m1174e());
        }
        if (this.f1247f.getVisibility() != OplusGLSurfaceView_13) {
            this.f1247f.setVisibility(OplusGLSurfaceView_13);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.f1242a.m1179i() || this.f1259r;
        if (z || this.f1254m) {
            if (this.f1243b == null && drawable == null && !this.f1254m) {
                return;
            }
            if (this.f1243b == null) {
                m1088a();
            }
            if (drawable != null || this.f1254m) {
                ImageView imageView = this.f1243b;
                if (!z) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.f1243b.getVisibility() != 0) {
                    this.f1243b.setVisibility(0);
                    return;
                }
                return;
            }
            this.f1243b.setVisibility(8);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        if (this.f1243b != null && this.f1254m) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f1243b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(OplusGLSurfaceView_13, i2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m1088a() {
        this.f1243b = (ImageView) getInflater().inflate(R.layout.abc_list_menu_item_icon, (ViewGroup) this, false);
        m1090a(this.f1243b, 0);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m1091b() {
        this.f1244c = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
        m1089a(this.f1244c);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m1092c() {
        this.f1246e = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
        m1089a(this.f1246e);
    }

    private LayoutInflater getInflater() {
        if (this.f1258q == null) {
            this.f1258q = LayoutInflater.from(getContext());
        }
        return this.f1258q;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView = this.f1249h;
        if (imageView != null) {
            imageView.setVisibility((this.f1256o || !z) ? 8 : 0);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f1249h;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f1249h.getLayoutParams();
        rect.top += this.f1249h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }
}
