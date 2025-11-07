package com.coui.appcompat.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import coui.support.appcompat.R;

/* loaded from: classes.dex */
public class COUIButtonBarLayout extends LinearLayout {

    /* renamed from: PlatformImplementations.kt_3 */
    private Context f7138a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Button f7139b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Button f7140c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Button f7141d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private View f7142e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private View f7143f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private View f7144g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private View f7145h;

    /* renamed from: OplusGLSurfaceView_13 */
    private View f7146i;

    /* renamed from: OplusGLSurfaceView_15 */
    private View f7147j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f7148k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f7149l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f7150m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f7151n;

    /* renamed from: o */
    private int f7152o;

    /* renamed from: p */
    private int f7153p;

    /* renamed from: q */
    private int f7154q;

    /* renamed from: r */
    private int f7155r;

    /* renamed from: s */
    private int f7156s;

    /* renamed from: t */
    private int f7157t;

    /* renamed from: u */
    private int f7158u;

    /* renamed from: v */
    private int f7159v;

    /* renamed from: w */
    private boolean f7160w;

    public COUIButtonBarLayout(Context context) {
        super(context, null);
    }

    public COUIButtonBarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public COUIButtonBarLayout(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        m7004a(context);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7004a(Context context) {
        this.f7138a = context;
        this.f7148k = this.f7138a.getResources().getDimensionPixelSize(R.dimen.coui_alert_dialog_button_horizontal_padding);
        this.f7149l = this.f7138a.getResources().getDimensionPixelSize(R.dimen.coui_alert_dialog_button_vertical_padding);
        this.f7152o = this.f7138a.getResources().getDimensionPixelSize(R.dimen.coui_delete_alert_dialog_divider_height);
        this.f7153p = this.f7138a.getResources().getDimensionPixelSize(R.dimen.coui_delete_alert_dialog_button_height);
        this.f7154q = this.f7138a.getResources().getDimensionPixelSize(R.dimen.alert_dialog_item_padding_offset);
        this.f7150m = this.f7138a.getResources().getDimensionPixelSize(R.dimen.alert_dialog_list_item_padding_top);
        this.f7155r = this.f7138a.getResources().getDimensionPixelSize(R.dimen.f24229x8719b4ca);
        this.f7156s = this.f7138a.getResources().getDimensionPixelSize(R.dimen.f24230x97140d78);
        this.f7157t = this.f7138a.getResources().getDimensionPixelSize(R.dimen.f24228x309b744a);
        this.f7158u = this.f7138a.getResources().getDimensionPixelSize(R.dimen.coui_alert_dialog_button_height);
    }

    public void setForceVertical(boolean z) {
        this.f7160w = z;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        super.onMeasure(OplusGLSurfaceView_13, i2);
        m7003a();
        if (this.f7160w || m7005a(getMeasuredWidth())) {
            if (!m7025t()) {
                m7007b();
            }
            m7019n();
            m7020o();
            m7021p();
            m7023r();
            super.onMeasure(OplusGLSurfaceView_13, i2);
            return;
        }
        if (m7025t()) {
            m7013h();
        }
        m7022q();
        m7024s();
        super.onMeasure(OplusGLSurfaceView_13, i2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7003a() {
        if (this.f7139b == null || this.f7140c == null || this.f7141d == null || this.f7142e == null || this.f7143f == null || this.f7144g == null || this.f7145h == null || this.f7146i == null || this.f7147j == null) {
            this.f7139b = (Button) findViewById(android.R.id_renamed.button1);
            this.f7140c = (Button) findViewById(android.R.id_renamed.button2);
            this.f7141d = (Button) findViewById(android.R.id_renamed.button3);
            this.f7142e = findViewById(R.id_renamed.coui_dialog_button_divider_1);
            this.f7143f = findViewById(R.id_renamed.coui_dialog_button_divider_2);
            this.f7144g = (View) getParent();
            this.f7145h = this.f7144g.findViewById(R.id_renamed.topPanel);
            this.f7146i = this.f7144g.findViewById(R.id_renamed.contentPanel);
            this.f7147j = this.f7144g.findViewById(R.id_renamed.customPanel);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m7005a(int OplusGLSurfaceView_13) {
        int buttonCount = getButtonCount();
        if (buttonCount == 0) {
            return false;
        }
        int i2 = ((OplusGLSurfaceView_13 - ((buttonCount - 1) * this.f7152o)) / buttonCount) - (this.f7148k * 2);
        return m7002a(this.f7139b) > i2 || m7002a(this.f7140c) > i2 || m7002a(this.f7141d) > i2;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private int m7002a(Button button) {
        float fMeasureText;
        if (button == null || button.getVisibility() != 0) {
            return 0;
        }
        if (Build.VERSION.SDK_INT >= 28 && button.isAllCaps()) {
            fMeasureText = button.getPaint().measureText(button.getText().toString().toUpperCase());
        } else {
            fMeasureText = button.getPaint().measureText(button.getText().toString());
        }
        return (int) fMeasureText;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m7007b() {
        setOrientation(1);
        setMinimumHeight(0);
        m7010e();
        m7012g();
        m7009d();
        m7011f();
        m7008c();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m7008c() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f7139b.getLayoutParams();
        layoutParams.weight = 0.0f;
        layoutParams.width = -1;
        layoutParams.height = -2;
        this.f7139b.setLayoutParams(layoutParams);
        Button button = this.f7139b;
        int OplusGLSurfaceView_13 = this.f7149l;
        int i2 = this.f7150m;
        button.setPaddingRelative(OplusGLSurfaceView_13, this.f7154q + i2, OplusGLSurfaceView_13, i2);
        this.f7139b.setMinHeight(this.f7153p + this.f7154q);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m7009d() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f7140c.getLayoutParams();
        layoutParams.weight = 0.0f;
        layoutParams.width = -1;
        layoutParams.height = -2;
        this.f7140c.setLayoutParams(layoutParams);
        Button button = this.f7140c;
        int OplusGLSurfaceView_13 = this.f7149l;
        int i2 = this.f7150m;
        button.setPaddingRelative(OplusGLSurfaceView_13, i2, OplusGLSurfaceView_13, this.f7154q + i2);
        this.f7140c.setMinHeight(this.f7153p + this.f7154q);
        bringChildToFront(this.f7140c);
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m7010e() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f7141d.getLayoutParams();
        layoutParams.weight = 0.0f;
        layoutParams.width = -1;
        layoutParams.height = -2;
        this.f7141d.setLayoutParams(layoutParams);
        Button button = this.f7141d;
        int OplusGLSurfaceView_13 = this.f7149l;
        int i2 = this.f7150m;
        button.setPaddingRelative(OplusGLSurfaceView_13, i2, OplusGLSurfaceView_13, i2);
        this.f7141d.setMinHeight(this.f7153p);
        bringChildToFront(this.f7141d);
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m7011f() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f7142e.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = this.f7152o;
        layoutParams.setMarginStart(this.f7155r);
        layoutParams.setMarginEnd(this.f7155r);
        layoutParams.topMargin = this.f7156s;
        layoutParams.bottomMargin = 0;
        this.f7142e.setLayoutParams(layoutParams);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m7012g() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f7143f.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = this.f7152o;
        layoutParams.setMarginStart(this.f7155r);
        layoutParams.setMarginEnd(this.f7155r);
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = 0;
        this.f7143f.setLayoutParams(layoutParams);
        bringChildToFront(this.f7143f);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m7013h() {
        setOrientation(0);
        setMinimumHeight(this.f7158u);
        m7017l();
        m7016k();
        m7018m();
        m7014i();
        m7015j();
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private void m7014i() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f7139b.getLayoutParams();
        layoutParams.weight = 1.0f;
        layoutParams.width = 0;
        layoutParams.height = -1;
        this.f7139b.setLayoutParams(layoutParams);
        Button button = this.f7139b;
        int OplusGLSurfaceView_13 = this.f7148k;
        button.setPaddingRelative(OplusGLSurfaceView_13, 0, OplusGLSurfaceView_13, 0);
        this.f7139b.setMinHeight(0);
        bringChildToFront(this.f7139b);
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m7015j() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f7140c.getLayoutParams();
        layoutParams.weight = 1.0f;
        layoutParams.width = 0;
        layoutParams.height = -1;
        this.f7140c.setLayoutParams(layoutParams);
        Button button = this.f7140c;
        int OplusGLSurfaceView_13 = this.f7148k;
        button.setPaddingRelative(OplusGLSurfaceView_13, 0, OplusGLSurfaceView_13, 0);
        this.f7140c.setMinHeight(0);
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private void m7016k() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f7141d.getLayoutParams();
        layoutParams.weight = 1.0f;
        layoutParams.width = 0;
        layoutParams.height = -1;
        this.f7141d.setLayoutParams(layoutParams);
        Button button = this.f7141d;
        int OplusGLSurfaceView_13 = this.f7148k;
        button.setPaddingRelative(OplusGLSurfaceView_13, 0, OplusGLSurfaceView_13, 0);
        this.f7141d.setMinHeight(0);
        bringChildToFront(this.f7141d);
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private void m7017l() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f7142e.getLayoutParams();
        layoutParams.width = this.f7152o;
        layoutParams.height = -1;
        layoutParams.setMarginStart(0);
        layoutParams.setMarginEnd(0);
        int OplusGLSurfaceView_13 = this.f7157t;
        layoutParams.topMargin = OplusGLSurfaceView_13;
        layoutParams.bottomMargin = OplusGLSurfaceView_13;
        this.f7142e.setLayoutParams(layoutParams);
        bringChildToFront(this.f7142e);
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private void m7018m() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f7143f.getLayoutParams();
        layoutParams.width = this.f7152o;
        layoutParams.height = -1;
        layoutParams.setMarginStart(0);
        layoutParams.setMarginEnd(0);
        int OplusGLSurfaceView_13 = this.f7157t;
        layoutParams.topMargin = OplusGLSurfaceView_13;
        layoutParams.bottomMargin = OplusGLSurfaceView_13;
        this.f7143f.setLayoutParams(layoutParams);
        bringChildToFront(this.f7143f);
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private void m7019n() {
        if (this.f7160w) {
            if (m7006a((View) this.f7140c)) {
                if (m7006a((View) this.f7139b) || m7006a((View) this.f7141d) || m7006a(this.f7145h) || m7006a(this.f7146i) || m7006a(this.f7147j)) {
                    Button button = this.f7140c;
                    int OplusGLSurfaceView_13 = this.f7149l;
                    int i2 = this.f7150m;
                    int i3 = this.f7151n;
                    button.setPaddingRelative(OplusGLSurfaceView_13, i2 + i3, OplusGLSurfaceView_13, i2 + i3);
                    this.f7140c.setMinHeight(this.f7153p + (this.f7151n * 2));
                } else {
                    Button button2 = this.f7140c;
                    int i4 = this.f7149l;
                    int i5 = this.f7150m;
                    button2.setPaddingRelative(i4, this.f7154q + i5, i4, i5);
                    this.f7140c.setMinHeight(this.f7153p + this.f7154q);
                }
            }
            if (m7006a((View) this.f7141d)) {
                if (m7006a((View) this.f7140c)) {
                    if (m7006a((View) this.f7139b) || m7006a(this.f7145h) || m7006a(this.f7146i) || m7006a(this.f7147j)) {
                        Button button3 = this.f7141d;
                        int i6 = this.f7149l;
                        int i7 = this.f7150m;
                        button3.setPaddingRelative(i6, i7, i6, this.f7154q + i7);
                        this.f7141d.setMinHeight(this.f7153p + this.f7154q);
                    } else {
                        Button button4 = this.f7141d;
                        int i8 = this.f7149l;
                        int i9 = this.f7150m;
                        int i10 = this.f7154q;
                        button4.setPaddingRelative(i8, i9 + i10, i8, i9 + i10);
                        this.f7141d.setMinHeight(this.f7153p + (this.f7154q * 2));
                    }
                } else if (m7006a((View) this.f7139b) || m7006a(this.f7145h) || m7006a(this.f7146i) || m7006a(this.f7147j)) {
                    Button button5 = this.f7141d;
                    int i11 = this.f7149l;
                    int i12 = this.f7150m;
                    button5.setPaddingRelative(i11, i12, i11, i12);
                    this.f7141d.setMinHeight(this.f7153p);
                } else {
                    Button button6 = this.f7141d;
                    int i13 = this.f7149l;
                    int i14 = this.f7150m;
                    button6.setPaddingRelative(i13, this.f7154q + i14, i13, i14);
                    this.f7141d.setMinHeight(this.f7153p + this.f7154q);
                }
            }
            if (m7006a((View) this.f7139b)) {
                if (m7006a(this.f7145h) || m7006a(this.f7146i) || m7006a(this.f7147j)) {
                    if (m7006a((View) this.f7140c)) {
                        if (m7006a((View) this.f7141d)) {
                            Button button7 = this.f7139b;
                            int i15 = this.f7149l;
                            int i16 = this.f7150m;
                            button7.setPaddingRelative(i15, i16, i15, i16);
                            this.f7139b.setMinHeight(this.f7153p);
                            return;
                        }
                        Button button8 = this.f7139b;
                        int i17 = this.f7149l;
                        int i18 = this.f7150m;
                        button8.setPaddingRelative(i17, i18, i17, this.f7154q + i18);
                        this.f7139b.setMinHeight(this.f7153p + this.f7154q);
                        return;
                    }
                    if (m7006a((View) this.f7141d)) {
                        Button button9 = this.f7139b;
                        int i19 = this.f7149l;
                        int i20 = this.f7150m;
                        button9.setPaddingRelative(i19, i20, i19, this.f7154q + i20);
                        this.f7139b.setMinHeight(this.f7153p + this.f7154q);
                        return;
                    }
                    Button button10 = this.f7139b;
                    int i21 = this.f7149l;
                    int i22 = this.f7150m;
                    button10.setPaddingRelative(i21, i22, i21, i22);
                    this.f7139b.setMinHeight(this.f7153p);
                    return;
                }
                if (m7006a((View) this.f7140c)) {
                    if (m7006a((View) this.f7141d)) {
                        Button button11 = this.f7139b;
                        int i23 = this.f7149l;
                        int i24 = this.f7150m;
                        button11.setPaddingRelative(i23, this.f7154q + i24, i23, i24);
                        this.f7139b.setMinHeight(this.f7153p + this.f7154q);
                        return;
                    }
                    Button button12 = this.f7139b;
                    int i25 = this.f7149l;
                    int i26 = this.f7150m;
                    int i27 = this.f7154q;
                    button12.setPaddingRelative(i25, i26 + i27, i25, i26 + i27);
                    this.f7139b.setMinHeight(this.f7153p + (this.f7154q * 2));
                    return;
                }
                if (m7006a((View) this.f7141d)) {
                    Button button13 = this.f7139b;
                    int i28 = this.f7149l;
                    int i29 = this.f7150m;
                    int i30 = this.f7154q;
                    button13.setPaddingRelative(i28, i29 + i30, i28, i29 + i30);
                    this.f7139b.setMinHeight(this.f7153p + (this.f7154q * 2));
                    return;
                }
                Button button14 = this.f7139b;
                int i31 = this.f7149l;
                int i32 = this.f7150m;
                button14.setPaddingRelative(i31, this.f7154q + i32, i31, i32);
                this.f7139b.setMinHeight(this.f7153p + this.f7154q);
                return;
            }
            return;
        }
        if (m7006a((View) this.f7139b)) {
            if (m7006a((View) this.f7141d) || m7006a((View) this.f7140c)) {
                Button button15 = this.f7139b;
                int i33 = this.f7149l;
                int i34 = this.f7150m;
                button15.setPaddingRelative(i33, i34, i33, i34);
                this.f7139b.setMinHeight(this.f7153p);
            } else {
                Button button16 = this.f7139b;
                int i35 = this.f7149l;
                int i36 = this.f7150m;
                button16.setPaddingRelative(i35, i36, i35, this.f7154q + i36);
                this.f7139b.setMinHeight(this.f7153p + this.f7154q);
            }
        }
        if (m7006a((View) this.f7141d)) {
            if (m7006a((View) this.f7139b)) {
                if (m7006a((View) this.f7140c)) {
                    Button button17 = this.f7141d;
                    int i37 = this.f7149l;
                    int i38 = this.f7150m;
                    button17.setPaddingRelative(i37, i38, i37, i38);
                    this.f7141d.setMinHeight(this.f7153p);
                } else {
                    Button button18 = this.f7141d;
                    int i39 = this.f7149l;
                    int i40 = this.f7150m;
                    button18.setPaddingRelative(i39, i40, i39, this.f7154q + i40);
                    this.f7141d.setMinHeight(this.f7153p + this.f7154q);
                }
            } else if (m7006a((View) this.f7140c)) {
                Button button19 = this.f7141d;
                int i41 = this.f7149l;
                int i42 = this.f7150m;
                button19.setPaddingRelative(i41, i42, i41, i42);
                this.f7141d.setMinHeight(this.f7153p);
            } else {
                Button button20 = this.f7141d;
                int i43 = this.f7149l;
                int i44 = this.f7150m;
                button20.setPaddingRelative(i43, i44, i43, this.f7154q + i44);
                this.f7141d.setMinHeight(this.f7153p + this.f7154q);
            }
        }
        if (m7006a((View) this.f7140c)) {
            Button button21 = this.f7140c;
            int i45 = this.f7149l;
            int i46 = this.f7150m;
            button21.setPaddingRelative(i45, i46, i45, this.f7154q + i46);
            this.f7140c.setMinHeight(this.f7153p + this.f7154q);
        }
    }

    /* renamed from: o */
    private void m7020o() {
        Button button;
        if (!this.f7160w || m7006a(this.f7145h) || m7006a(this.f7146i) || m7006a(this.f7147j)) {
            return;
        }
        if (getButtonCount() == 1) {
            if (m7006a((View) this.f7139b)) {
                button = this.f7139b;
            } else {
                button = m7006a((View) this.f7141d) ? this.f7141d : this.f7140c;
            }
            button.setBackgroundResource(R.drawable.coui_alert_bottom_dialog_corner_button_background);
            return;
        }
        if (getButtonCount() == 2) {
            (m7006a((View) this.f7139b) ? this.f7139b : this.f7141d).setBackgroundResource(R.drawable.coui_alert_bottom_dialog_corner_button_background);
        } else if (getButtonCount() == 3) {
            this.f7139b.setBackgroundResource(R.drawable.coui_alert_bottom_dialog_corner_button_background);
        }
    }

    /* renamed from: p */
    private void m7021p() {
        if (this.f7160w) {
            if (getButtonCount() != 0) {
                if (m7006a((View) this.f7140c)) {
                    if (m7006a((View) this.f7141d) || m7006a((View) this.f7139b) || m7006a(this.f7145h) || m7006a(this.f7146i) || m7006a(this.f7147j)) {
                        this.f7142e.setVisibility(8);
                        this.f7143f.setVisibility(0);
                        return;
                    } else {
                        this.f7142e.setVisibility(8);
                        this.f7143f.setVisibility(8);
                        return;
                    }
                }
                this.f7142e.setVisibility(8);
                this.f7143f.setVisibility(8);
                return;
            }
            this.f7142e.setVisibility(8);
            this.f7143f.setVisibility(8);
            return;
        }
        if (getButtonCount() != 0) {
            this.f7142e.setVisibility(4);
            this.f7143f.setVisibility(8);
        } else {
            this.f7142e.setVisibility(8);
            this.f7143f.setVisibility(8);
        }
    }

    /* renamed from: q */
    private void m7022q() {
        if (getButtonCount() == 2) {
            if (m7006a((View) this.f7139b)) {
                this.f7142e.setVisibility(8);
                this.f7143f.setVisibility(0);
                return;
            } else {
                this.f7142e.setVisibility(0);
                this.f7143f.setVisibility(8);
                return;
            }
        }
        if (getButtonCount() == 3) {
            this.f7142e.setVisibility(0);
            this.f7143f.setVisibility(0);
        } else {
            this.f7142e.setVisibility(8);
            this.f7143f.setVisibility(8);
        }
    }

    /* renamed from: r */
    private void m7023r() {
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), this.f7159v);
    }

    /* renamed from: s */
    private void m7024s() {
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), 0);
    }

    private int getButtonCount() {
        int OplusGLSurfaceView_13 = m7006a((View) this.f7139b) ? 1 : 0;
        if (m7006a((View) this.f7140c)) {
            OplusGLSurfaceView_13++;
        }
        return m7006a((View) this.f7141d) ? OplusGLSurfaceView_13 + 1 : OplusGLSurfaceView_13;
    }

    /* renamed from: t */
    private boolean m7025t() {
        return getOrientation() == 1;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m7006a(View view) {
        return view.getVisibility() == 0;
    }

    public void setVerButDividerVerMargin(int OplusGLSurfaceView_13) {
        this.f7156s = OplusGLSurfaceView_13;
    }

    public void setVerButVerPadding(int OplusGLSurfaceView_13) {
        this.f7150m = OplusGLSurfaceView_13;
    }

    public void setVerNegButVerPaddingOffset(int OplusGLSurfaceView_13) {
        this.f7151n = OplusGLSurfaceView_13;
    }

    public void setVerPaddingBottom(int OplusGLSurfaceView_13) {
        this.f7159v = OplusGLSurfaceView_13;
    }

    public void setVerButPaddingOffset(int OplusGLSurfaceView_13) {
        this.f7154q = OplusGLSurfaceView_13;
    }
}
