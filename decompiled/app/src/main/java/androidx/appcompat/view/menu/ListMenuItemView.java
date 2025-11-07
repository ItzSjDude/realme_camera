package androidx.appcompat.view.menu;

/* loaded from: classes.dex */
public class ListMenuItemView extends android.widget.LinearLayout implements android.widget.AbsListView.SelectionBoundsAdjuster, androidx.appcompat.view.menu.o_renamed.a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private androidx.appcompat.view.menu.j_renamed f354a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.widget.ImageView f355b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.widget.RadioButton f356c;
    private android.widget.TextView d_renamed;
    private android.widget.CheckBox e_renamed;
    private android.widget.TextView f_renamed;
    private android.widget.ImageView g_renamed;
    private android.widget.ImageView h_renamed;
    private android.widget.LinearLayout i_renamed;
    private android.graphics.drawable.Drawable j_renamed;
    private int k_renamed;
    private android.content.Context l_renamed;
    private boolean m_renamed;
    private android.graphics.drawable.Drawable n_renamed;
    private boolean o_renamed;
    private int p_renamed;
    private android.view.LayoutInflater q_renamed;
    private boolean r_renamed;

    @Override // androidx.appcompat.view.menu.o_renamed.a_renamed
    public boolean prefersCondensedTitle() {
        return false;
    }

    public ListMenuItemView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R_renamed.attr.listMenuViewStyle);
    }

    public ListMenuItemView(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet);
        androidx.appcompat.widget.ar_renamed arVarA = androidx.appcompat.widget.ar_renamed.a_renamed(getContext(), attributeSet, androidx.appcompat.R_renamed.styleable.MenuView, i_renamed, 0);
        this.j_renamed = arVarA.a_renamed(androidx.appcompat.R_renamed.styleable.MenuView_android_itemBackground);
        this.k_renamed = arVarA.g_renamed(androidx.appcompat.R_renamed.styleable.MenuView_android_itemTextAppearance, -1);
        this.m_renamed = arVarA.a_renamed(androidx.appcompat.R_renamed.styleable.MenuView_preserveIconSpacing, false);
        this.l_renamed = context;
        this.n_renamed = arVarA.a_renamed(androidx.appcompat.R_renamed.styleable.MenuView_subMenuArrow);
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{android.R_renamed.attr.divider}, androidx.appcompat.R_renamed.attr.dropDownListViewStyle, 0);
        this.o_renamed = typedArrayObtainStyledAttributes.hasValue(0);
        arVarA.b_renamed();
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        androidx.core.h_renamed.v_renamed.a_renamed(this, this.j_renamed);
        this.d_renamed = (android.widget.TextView) findViewById(androidx.appcompat.R_renamed.id_renamed.title);
        int i_renamed = this.k_renamed;
        if (i_renamed != -1) {
            this.d_renamed.setTextAppearance(this.l_renamed, i_renamed);
        }
        this.f_renamed = (android.widget.TextView) findViewById(androidx.appcompat.R_renamed.id_renamed.shortcut);
        this.g_renamed = (android.widget.ImageView) findViewById(androidx.appcompat.R_renamed.id_renamed.submenuarrow);
        android.widget.ImageView imageView = this.g_renamed;
        if (imageView != null) {
            imageView.setImageDrawable(this.n_renamed);
        }
        this.h_renamed = (android.widget.ImageView) findViewById(androidx.appcompat.R_renamed.id_renamed.group_divider);
        this.i_renamed = (android.widget.LinearLayout) findViewById(androidx.appcompat.R_renamed.id_renamed.content);
    }

    @Override // androidx.appcompat.view.menu.o_renamed.a_renamed
    public void initialize(androidx.appcompat.view.menu.j_renamed jVar, int i_renamed) {
        this.f354a = jVar;
        this.p_renamed = i_renamed;
        setVisibility(jVar.isVisible() ? 0 : 8);
        setTitle(jVar.a_renamed((androidx.appcompat.view.menu.o_renamed.a_renamed) this));
        setCheckable(jVar.isCheckable());
        a_renamed(jVar.f_renamed(), jVar.d_renamed());
        setIcon(jVar.getIcon());
        setEnabled(jVar.isEnabled());
        setSubMenuArrowVisible(jVar.hasSubMenu());
        setContentDescription(jVar.getContentDescription());
    }

    private void a_renamed(android.view.View view) {
        a_renamed(view, -1);
    }

    private void a_renamed(android.view.View view, int i_renamed) {
        android.widget.LinearLayout linearLayout = this.i_renamed;
        if (linearLayout != null) {
            linearLayout.addView(view, i_renamed);
        } else {
            addView(view, i_renamed);
        }
    }

    public void setForceShowIcon(boolean z_renamed) {
        this.r_renamed = z_renamed;
        this.m_renamed = z_renamed;
    }

    public void setTitle(java.lang.CharSequence charSequence) {
        if (charSequence != null) {
            this.d_renamed.setText(charSequence);
            if (this.d_renamed.getVisibility() != 0) {
                this.d_renamed.setVisibility(0);
                return;
            }
            return;
        }
        if (this.d_renamed.getVisibility() != 8) {
            this.d_renamed.setVisibility(8);
        }
    }

    @Override // androidx.appcompat.view.menu.o_renamed.a_renamed
    public androidx.appcompat.view.menu.j_renamed getItemData() {
        return this.f354a;
    }

    public void setCheckable(boolean z_renamed) {
        android.widget.CompoundButton compoundButton;
        android.widget.CompoundButton compoundButton2;
        if (!z_renamed && this.f356c == null && this.e_renamed == null) {
            return;
        }
        if (this.f354a.g_renamed()) {
            if (this.f356c == null) {
                b_renamed();
            }
            compoundButton = this.f356c;
            compoundButton2 = this.e_renamed;
        } else {
            if (this.e_renamed == null) {
                c_renamed();
            }
            compoundButton = this.e_renamed;
            compoundButton2 = this.f356c;
        }
        if (z_renamed) {
            compoundButton.setChecked(this.f354a.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (compoundButton2 == null || compoundButton2.getVisibility() == 8) {
                return;
            }
            compoundButton2.setVisibility(8);
            return;
        }
        android.widget.CheckBox checkBox = this.e_renamed;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        android.widget.RadioButton radioButton = this.f356c;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    public void setChecked(boolean z_renamed) {
        android.widget.CompoundButton compoundButton;
        if (this.f354a.g_renamed()) {
            if (this.f356c == null) {
                b_renamed();
            }
            compoundButton = this.f356c;
        } else {
            if (this.e_renamed == null) {
                c_renamed();
            }
            compoundButton = this.e_renamed;
        }
        compoundButton.setChecked(z_renamed);
    }

    private void setSubMenuArrowVisible(boolean z_renamed) {
        android.widget.ImageView imageView = this.g_renamed;
        if (imageView != null) {
            imageView.setVisibility(z_renamed ? 0 : 8);
        }
    }

    public void a_renamed(boolean z_renamed, char c2) {
        int i_renamed = (z_renamed && this.f354a.f_renamed()) ? 0 : 8;
        if (i_renamed == 0) {
            this.f_renamed.setText(this.f354a.e_renamed());
        }
        if (this.f_renamed.getVisibility() != i_renamed) {
            this.f_renamed.setVisibility(i_renamed);
        }
    }

    public void setIcon(android.graphics.drawable.Drawable drawable) {
        boolean z_renamed = this.f354a.i_renamed() || this.r_renamed;
        if (z_renamed || this.m_renamed) {
            if (this.f355b == null && drawable == null && !this.m_renamed) {
                return;
            }
            if (this.f355b == null) {
                a_renamed();
            }
            if (drawable != null || this.m_renamed) {
                android.widget.ImageView imageView = this.f355b;
                if (!z_renamed) {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
                if (this.f355b.getVisibility() != 0) {
                    this.f355b.setVisibility(0);
                    return;
                }
                return;
            }
            this.f355b.setVisibility(8);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i_renamed, int i2) {
        if (this.f355b != null && this.m_renamed) {
            android.view.ViewGroup.LayoutParams layoutParams = getLayoutParams();
            android.widget.LinearLayout.LayoutParams layoutParams2 = (android.widget.LinearLayout.LayoutParams) this.f355b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i_renamed, i2);
    }

    private void a_renamed() {
        this.f355b = (android.widget.ImageView) getInflater().inflate(androidx.appcompat.R_renamed.layout.abc_list_menu_item_icon, (android.view.ViewGroup) this, false);
        a_renamed(this.f355b, 0);
    }

    private void b_renamed() {
        this.f356c = (android.widget.RadioButton) getInflater().inflate(androidx.appcompat.R_renamed.layout.abc_list_menu_item_radio, (android.view.ViewGroup) this, false);
        a_renamed(this.f356c);
    }

    private void c_renamed() {
        this.e_renamed = (android.widget.CheckBox) getInflater().inflate(androidx.appcompat.R_renamed.layout.abc_list_menu_item_checkbox, (android.view.ViewGroup) this, false);
        a_renamed(this.e_renamed);
    }

    private android.view.LayoutInflater getInflater() {
        if (this.q_renamed == null) {
            this.q_renamed = android.view.LayoutInflater.from(getContext());
        }
        return this.q_renamed;
    }

    public void setGroupDividerEnabled(boolean z_renamed) {
        android.widget.ImageView imageView = this.h_renamed;
        if (imageView != null) {
            imageView.setVisibility((this.o_renamed || !z_renamed) ? 8 : 0);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(android.graphics.Rect rect) {
        android.widget.ImageView imageView = this.h_renamed;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        android.widget.LinearLayout.LayoutParams layoutParams = (android.widget.LinearLayout.LayoutParams) this.h_renamed.getLayoutParams();
        rect.top += this.h_renamed.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }
}
