package com.coui.appcompat.dialog.app;

/* loaded from: classes.dex */
public class COUIAlertController extends com.coui.appcompat.dialog.app.a_renamed {
    private android.content.Context C_renamed;
    private int D_renamed;
    private boolean E_renamed;

    public COUIAlertController(android.content.Context context, androidx.appcompat.app.f_renamed fVar, android.view.Window window) {
        super(context, fVar, window);
        this.E_renamed = true;
        this.C_renamed = context;
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new int[]{coui.support.appcompat.R_renamed.attr.couiCenterAlertDialogButtonTextColor});
        this.D_renamed = typedArrayObtainStyledAttributes.getColor(0, this.C_renamed.getResources().getColor(coui.support.appcompat.R_renamed.color.coui_bottom_alert_dialog_button_text_color));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // com.coui.appcompat.dialog.app.a_renamed
    protected int b_renamed() {
        return h_renamed() ? super.b_renamed() : coui.support.appcompat.R_renamed.layout.coui_bottom_alert_dialog;
    }

    private void g_renamed() {
        android.view.WindowManager.LayoutParams attributes = this.f2436b.getAttributes();
        attributes.width = -1;
        if (h_renamed()) {
            attributes.windowAnimations = coui.support.appcompat.R_renamed.style.Animation_COUI_Dialog_Alpha;
            this.f2436b.setGravity(17);
        } else {
            attributes.windowAnimations = coui.support.appcompat.R_renamed.style.Animation_COUI_Dialog;
            this.f2436b.setGravity(80);
        }
        this.f2436b.setAttributes(attributes);
    }

    private boolean h_renamed() {
        return e_renamed() == 0;
    }

    @Override // com.coui.appcompat.dialog.app.a_renamed
    protected void d_renamed() {
        f_renamed();
        i_renamed();
        g_renamed();
        android.widget.ListView listViewC = c_renamed();
        if (listViewC instanceof com.coui.appcompat.dialog.app.COUIAlertController.COUIRecyclerListView) {
            ((com.coui.appcompat.dialog.app.COUIAlertController.COUIRecyclerListView) listViewC).setNeedClip(j_renamed());
        }
        super.d_renamed();
    }

    public void f_renamed() {
        android.view.ViewGroup viewGroup;
        if (this.f2435a == null || this.f2436b == null || (viewGroup = (android.view.ViewGroup) this.f2436b.findViewById(android.R_renamed.id_renamed.content)) == null) {
            return;
        }
        viewGroup.setOnClickListener(!this.E_renamed ? null : new android.view.View.OnClickListener() { // from class: com.coui.appcompat.dialog.app.COUIAlertController.1
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view) {
                if (com.coui.appcompat.dialog.app.COUIAlertController.this.f2435a != null) {
                    com.coui.appcompat.dialog.app.COUIAlertController.this.f2435a.cancel();
                }
            }
        });
    }

    private void i_renamed() {
        android.view.View viewFindViewById = this.f2436b.findViewById(coui.support.appcompat.R_renamed.id_renamed.parentPanel);
        if (viewFindViewById == null || viewFindViewById.getBackground() == null || this.B_renamed == 0) {
            return;
        }
        viewFindViewById.getBackground().setTint(this.B_renamed);
    }

    private boolean j_renamed() {
        return (k_renamed() || l_renamed() || h_renamed()) ? false : true;
    }

    @Override // com.coui.appcompat.dialog.app.a_renamed
    protected void c_renamed(android.view.ViewGroup viewGroup) {
        android.graphics.Typeface typefaceCreate;
        float dimensionPixelSize;
        super.c_renamed(viewGroup);
        if (!(viewGroup instanceof com.coui.appcompat.widget.COUIButtonBarLayout) || this.y_renamed || this.z_renamed) {
            return;
        }
        android.widget.Button button = (android.widget.Button) viewGroup.findViewById(android.R_renamed.id_renamed.button1);
        android.widget.Button button2 = (android.widget.Button) viewGroup.findViewById(android.R_renamed.id_renamed.button2);
        android.widget.Button button3 = (android.widget.Button) viewGroup.findViewById(android.R_renamed.id_renamed.button3);
        if (h_renamed()) {
            typefaceCreate = android.graphics.Typeface.create("sans-serif-medium", 0);
            dimensionPixelSize = this.C_renamed.getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.TD07);
            ((com.coui.appcompat.widget.COUIButtonBarLayout) viewGroup).setVerNegButVerPaddingOffset(0);
        } else {
            typefaceCreate = android.graphics.Typeface.create("sans-serif-regular", 0);
            float dimensionPixelSize2 = this.C_renamed.getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.TD09);
            com.coui.appcompat.widget.COUIButtonBarLayout cOUIButtonBarLayout = (com.coui.appcompat.widget.COUIButtonBarLayout) viewGroup;
            cOUIButtonBarLayout.setVerNegButVerPaddingOffset(this.C_renamed.getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.alert_dialog_list_last_item_padding_offset));
            cOUIButtonBarLayout.setForceVertical(true);
            button.setTextColor(this.D_renamed);
            button2.setTextColor(this.D_renamed);
            button3.setTextColor(this.C_renamed.getResources().getColor(coui.support.appcompat.R_renamed.color.coui_bottom_alert_dialog_button_warning_color));
            dimensionPixelSize = dimensionPixelSize2;
        }
        button.setTypeface(typefaceCreate);
        button.setTextSize(0, dimensionPixelSize);
        button2.setTypeface(typefaceCreate);
        button2.setTextSize(0, dimensionPixelSize);
        button3.setTypeface(typefaceCreate);
        button3.setTextSize(0, dimensionPixelSize);
    }

    @Override // com.coui.appcompat.dialog.app.a_renamed
    protected void b_renamed(android.view.ViewGroup viewGroup) {
        super.b_renamed(viewGroup);
        android.view.ViewGroup viewGroup2 = (android.view.ViewGroup) viewGroup.findViewById(coui.support.appcompat.R_renamed.id_renamed.listPanel);
        if (this.d_renamed != null && viewGroup2 != null && this.e_renamed != null) {
            viewGroup2.addView(this.e_renamed, new android.view.ViewGroup.LayoutParams(-1, -1));
            android.widget.ImageView imageView = (android.widget.ImageView) viewGroup.findViewById(coui.support.appcompat.R_renamed.id_renamed.coui_alert_dialog_list_divider);
            if (imageView != null) {
                imageView.setVisibility(0);
            }
        }
        if (h_renamed()) {
            if (this.d_renamed != null) {
                f_renamed(viewGroup);
                return;
            }
            return;
        }
        e_renamed(viewGroup2);
        if ((this.y_renamed || this.z_renamed) && k_renamed() && l_renamed()) {
            d_renamed(viewGroup);
        }
    }

    private void d_renamed(android.view.ViewGroup viewGroup) {
        if (this.o_renamed != null) {
            this.o_renamed.setPadding(this.o_renamed.getPaddingLeft(), this.C_renamed.getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.center_dialog_scroll_padding_top), this.o_renamed.getPaddingRight(), this.C_renamed.getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.center_dialog_scroll_padding_bottom));
        }
        android.widget.TextView textView = (android.widget.TextView) viewGroup.findViewById(android.R_renamed.id_renamed.message);
        android.widget.FrameLayout.LayoutParams layoutParams = (android.widget.FrameLayout.LayoutParams) textView.getLayoutParams();
        layoutParams.setMarginStart(this.C_renamed.getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.bottom_choice_dialog_message_margin_start));
        layoutParams.setMarginEnd(this.C_renamed.getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.bottom_choice_dialog_message_margin_end));
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(0, this.C_renamed.getResources().getDimensionPixelSize(coui.support.appcompat.R_renamed.dimen.TD07));
        textView.setTextColor(this.C_renamed.getResources().getColor(coui.support.appcompat.R_renamed.color.coui_alert_dialog_content_text_color));
        f_renamed(viewGroup);
    }

    private void e_renamed(android.view.ViewGroup viewGroup) {
        if (this.x_renamed) {
            if (this.o_renamed != null) {
                android.widget.LinearLayout.LayoutParams layoutParams = (android.widget.LinearLayout.LayoutParams) this.o_renamed.getLayoutParams();
                layoutParams.height = 0;
                layoutParams.weight = 1.0f;
                this.o_renamed.setLayoutParams(layoutParams);
            }
            if (viewGroup != null) {
                android.widget.LinearLayout.LayoutParams layoutParams2 = (android.widget.LinearLayout.LayoutParams) viewGroup.getLayoutParams();
                layoutParams2.height = 0;
                layoutParams2.weight = 1.0f;
                viewGroup.setLayoutParams(layoutParams2);
            }
        }
    }

    private void f_renamed(android.view.ViewGroup viewGroup) {
        final android.widget.TextView textView = (android.widget.TextView) viewGroup.findViewById(android.R_renamed.id_renamed.message);
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.coui.appcompat.dialog.app.COUIAlertController.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (textView.getLineCount() > 1) {
                    textView.setTextAlignment(2);
                } else {
                    textView.setTextAlignment(4);
                }
                android.widget.TextView textView2 = textView;
                textView2.setText(textView2.getText());
                textView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    private boolean k_renamed() {
        return !android.text.TextUtils.isEmpty(this.d_renamed);
    }

    private boolean l_renamed() {
        return !android.text.TextUtils.isEmpty(this.f2437c);
    }

    protected void a_renamed(boolean z_renamed) {
        this.E_renamed = z_renamed;
        f_renamed();
    }

    public static class COUIRecyclerListView extends com.coui.appcompat.dialog.app.a_renamed.d_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private android.graphics.Path f2428a;

        /* renamed from: b_renamed, reason: collision with root package name */
        private int f2429b;

        /* renamed from: c_renamed, reason: collision with root package name */
        private boolean f2430c;
        private float[] d_renamed;
        private android.graphics.RectF e_renamed;

        public COUIRecyclerListView(android.content.Context context) {
            this(context, null);
        }

        public COUIRecyclerListView(android.content.Context context, android.util.AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2429b = context.getResources().getDimensionPixelOffset(coui.support.appcompat.R_renamed.dimen.alert_dialog_bottom_corner_radius);
            this.f2428a = new android.graphics.Path();
            this.e_renamed = new android.graphics.RectF();
            int i_renamed = this.f2429b;
            this.d_renamed = new float[]{i_renamed, i_renamed, i_renamed, i_renamed, 0.0f, 0.0f, 0.0f, 0.0f};
        }

        @Override // android.widget.AbsListView, android.view.View
        public void draw(android.graphics.Canvas canvas) {
            canvas.save();
            if (this.f2430c) {
                canvas.clipPath(this.f2428a);
            }
            super.draw(canvas);
            canvas.restore();
        }

        public void setNeedClip(boolean z_renamed) {
            this.f2430c = z_renamed;
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
        protected void onSizeChanged(int i_renamed, int i2, int i3, int i4) {
            super.onSizeChanged(i_renamed, i2, i3, i4);
            this.f2428a.reset();
            this.e_renamed.set(0.0f, 0.0f, i_renamed, i2);
            this.f2428a.addRoundRect(this.e_renamed, this.d_renamed, android.graphics.Path.Direction.CW);
        }
    }

    public static class a_renamed extends com.coui.appcompat.dialog.app.a_renamed.AlertController_4 {
        public java.lang.String V_renamed;

        public a_renamed(android.content.Context context) {
            super(context);
        }

        @Override // com.coui.appcompat.dialog.app.a_renamed.AlertController_4
        public void a_renamed(com.coui.appcompat.dialog.app.a_renamed aVar) {
            super.a_renamed(aVar);
            if (this.w_renamed == null && this.N_renamed == null && this.z_renamed == null) {
                return;
            }
            b_renamed(aVar);
        }

        private void b_renamed(final com.coui.appcompat.dialog.app.a_renamed aVar) {
            if (this.J_renamed) {
                if (this.N_renamed == null) {
                    aVar.p_renamed = new com.coui.appcompat.widget.v_renamed(this.f2448a, aVar.t_renamed, this.w_renamed, this.x_renamed, this.I_renamed, true) { // from class: com.coui.appcompat.dialog.app.COUIAlertController.a_renamed.1
                        @Override // com.coui.appcompat.widget.v_renamed, android.widget.Adapter
                        public android.view.View getView(int i_renamed, android.view.View view, android.view.ViewGroup viewGroup) {
                            android.view.View view2 = super.getView(i_renamed, view, viewGroup);
                            if (com.coui.appcompat.dialog.app.COUIAlertController.a_renamed.this.I_renamed != null && com.coui.appcompat.dialog.app.COUIAlertController.a_renamed.this.I_renamed[i_renamed]) {
                                aVar.e_renamed.setItemChecked(i_renamed, true);
                            }
                            return view2;
                        }
                    };
                } else {
                    aVar.p_renamed = new com.coui.appcompat.widget.w_renamed(this.f2448a, this.N_renamed, aVar.t_renamed, this.O_renamed, this.P_renamed, this.V_renamed, this.J_renamed) { // from class: com.coui.appcompat.dialog.app.COUIAlertController.a_renamed.2
                        @Override // com.coui.appcompat.widget.w_renamed, androidx.b_renamed.a_renamed.a_renamed
                        public void a_renamed(android.view.View view, android.content.Context context, android.database.Cursor cursor) throws java.lang.IllegalArgumentException {
                            super.a_renamed(view, context, cursor);
                            aVar.e_renamed.setItemChecked(cursor.getPosition(), cursor.getInt(cursor.getColumnIndexOrThrow(com.coui.appcompat.dialog.app.COUIAlertController.a_renamed.this.P_renamed)) == 1);
                        }
                    };
                }
            } else if (this.K_renamed) {
                int i_renamed = aVar.u_renamed;
                if (this.N_renamed != null) {
                    aVar.p_renamed = new com.coui.appcompat.widget.w_renamed(this.f2448a, this.N_renamed, i_renamed, this.O_renamed, this.V_renamed);
                } else if (this.z_renamed == null) {
                    aVar.p_renamed = new com.coui.appcompat.widget.v_renamed(this.f2448a, i_renamed, this.w_renamed, this.x_renamed);
                }
            }
            if (this.M_renamed != null) {
                aVar.e_renamed.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() { // from class: com.coui.appcompat.dialog.app.COUIAlertController.a_renamed.3
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public void onItemClick(android.widget.AdapterView<?> adapterView, android.view.View view, int i2, long j_renamed) {
                        if (com.coui.appcompat.dialog.app.COUIAlertController.a_renamed.this.I_renamed != null) {
                            com.coui.appcompat.dialog.app.COUIAlertController.a_renamed.this.I_renamed[i2] = aVar.e_renamed.isItemChecked(i2);
                        }
                        com.coui.appcompat.dialog.app.COUIAlertController.a_renamed.this.M_renamed.onClick(aVar.f2435a, i2, aVar.e_renamed.isItemChecked(i2));
                        if (com.coui.appcompat.dialog.app.COUIAlertController.a_renamed.this.J_renamed) {
                            int i3 = aVar.e_renamed.isItemChecked(i2) ? 2 : 0;
                            if (com.coui.appcompat.dialog.app.COUIAlertController.a_renamed.this.N_renamed == null) {
                                ((com.coui.appcompat.widget.v_renamed) aVar.p_renamed).a_renamed(i3, i2, aVar.e_renamed);
                            } else {
                                ((com.coui.appcompat.widget.w_renamed) aVar.p_renamed).a_renamed(i3, i2, aVar.e_renamed);
                            }
                        }
                    }
                });
            }
        }
    }
}
