package com.coui.appcompat.preference;

/* loaded from: classes.dex */
public class COUIPreference extends androidx.preference.Preference {

    /* renamed from: a_renamed, reason: collision with root package name */
    private boolean f2601a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private boolean f2602b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int f2603c;
    private int d_renamed;
    private int e_renamed;
    private int f_renamed;
    private android.view.View g_renamed;
    private android.view.View h_renamed;
    private boolean i_renamed;
    private float j_renamed;
    private int k_renamed;
    private int l_renamed;
    private java.lang.CharSequence m_renamed;
    private int n_renamed;

    public COUIPreference(android.content.Context context) {
        this(context, null);
    }

    public COUIPreference(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2601a = true;
        a_renamed(context, attributeSet, 0, 0);
    }

    public COUIPreference(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.f2601a = true;
        a_renamed(context, attributeSet, i_renamed, 0);
    }

    public COUIPreference(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        super(context, attributeSet, i_renamed);
        this.f2601a = true;
        a_renamed(context, attributeSet, i_renamed, i2);
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, coui.support.appcompat.R_renamed.styleable.COUIPreference, i_renamed, i2);
        this.f2601a = typedArrayObtainStyledAttributes.getBoolean(coui.support.appcompat.R_renamed.styleable.COUIPreference_couiShowDivider, this.f2601a);
        this.f2602b = typedArrayObtainStyledAttributes.getBoolean(coui.support.appcompat.R_renamed.styleable.COUIPreference_hasBorder, false);
        this.f2603c = typedArrayObtainStyledAttributes.getDimensionPixelSize(coui.support.appcompat.R_renamed.styleable.COUIPreference_preference_icon_radius, 14);
        this.i_renamed = typedArrayObtainStyledAttributes.getBoolean(coui.support.appcompat.R_renamed.styleable.COUIPreference_couiEnalbeClickSpan, false);
        typedArrayObtainStyledAttributes.recycle();
        this.j_renamed = context.getResources().getDisplayMetrics().density;
        float f_renamed = this.j_renamed;
        this.k_renamed = (int) ((14.0f * f_renamed) / 3.0f);
        this.l_renamed = (int) ((f_renamed * 36.0f) / 3.0f);
    }

    private void a_renamed(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, coui.support.appcompat.R_renamed.styleable.COUIPreference, i_renamed, i2);
        this.m_renamed = typedArrayObtainStyledAttributes.getText(coui.support.appcompat.R_renamed.styleable.COUIPreference_couiAssignment);
        this.n_renamed = typedArrayObtainStyledAttributes.getInt(coui.support.appcompat.R_renamed.styleable.COUIPreference_couiIconStyle, 1);
        this.d_renamed = typedArrayObtainStyledAttributes.getInt(coui.support.appcompat.R_renamed.styleable.COUIPreference_iconRedDotMode, 0);
        this.e_renamed = typedArrayObtainStyledAttributes.getInt(coui.support.appcompat.R_renamed.styleable.COUIPreference_endRedDotMode, 0);
        this.f_renamed = typedArrayObtainStyledAttributes.getInt(coui.support.appcompat.R_renamed.styleable.COUIPreference_endRedDotNum, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public void a_renamed(androidx.preference.l_renamed lVar) {
        final android.widget.TextView textView;
        android.graphics.drawable.Drawable drawable;
        super.a_renamed(lVar);
        android.view.View viewA = lVar.a_renamed(android.R_renamed.id_renamed.icon);
        android.view.View viewA2 = lVar.a_renamed(coui.support.appcompat.R_renamed.id_renamed.img_layout);
        this.g_renamed = lVar.a_renamed(coui.support.appcompat.R_renamed.id_renamed.img_red_dot);
        this.h_renamed = lVar.a_renamed(coui.support.appcompat.R_renamed.id_renamed.jump_icon_red_dot);
        if (viewA != null && (viewA instanceof com.coui.appcompat.widget.COUIRoundImageView)) {
            if (viewA.getHeight() != 0 && (drawable = ((com.coui.appcompat.widget.COUIRoundImageView) viewA).getDrawable()) != null) {
                this.f2603c = drawable.getIntrinsicHeight() / 6;
                int i_renamed = this.f2603c;
                int i2 = this.k_renamed;
                if (i_renamed < i2) {
                    this.f2603c = i2;
                } else {
                    int i3 = this.l_renamed;
                    if (i_renamed > i3) {
                        this.f2603c = i3;
                    }
                }
            }
            com.coui.appcompat.widget.COUIRoundImageView cOUIRoundImageView = (com.coui.appcompat.widget.COUIRoundImageView) viewA;
            cOUIRoundImageView.setHasBorder(this.f2602b);
            cOUIRoundImageView.setBorderRectRadius(this.f2603c);
            cOUIRoundImageView.setType(this.n_renamed);
        }
        if (this.i_renamed && (textView = (android.widget.TextView) lVar.a_renamed(android.R_renamed.id_renamed.summary)) != null) {
            textView.setHighlightColor(K_renamed().getResources().getColor(android.R_renamed.color.transparent));
            textView.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
            textView.setOnTouchListener(new android.view.View.OnTouchListener() { // from class: com.coui.appcompat.preference.COUIPreference.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
                    int actionMasked = motionEvent.getActionMasked();
                    int selectionStart = textView.getSelectionStart();
                    int selectionEnd = textView.getSelectionEnd();
                    int offsetForPosition = textView.getOffsetForPosition(motionEvent.getX(), motionEvent.getY());
                    boolean z_renamed = selectionStart == selectionEnd || offsetForPosition <= selectionStart || offsetForPosition >= selectionEnd;
                    if (actionMasked != 0) {
                        if (actionMasked == 1 || actionMasked == 3) {
                            textView.setPressed(false);
                            textView.postInvalidateDelayed(70L);
                        }
                    } else {
                        if (z_renamed) {
                            return false;
                        }
                        textView.setPressed(true);
                        textView.invalidate();
                    }
                    return false;
                }
            });
        }
        android.widget.TextView textView2 = (android.widget.TextView) lVar.a_renamed(coui.support.appcompat.R_renamed.id_renamed.assignment);
        if (textView2 != null) {
            java.lang.CharSequence charSequenceC = c_renamed();
            if (!android.text.TextUtils.isEmpty(charSequenceC)) {
                textView2.setText(charSequenceC);
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
        }
        if (viewA2 != null) {
            if (viewA != null) {
                viewA2.setVisibility(viewA.getVisibility());
            } else {
                viewA2.setVisibility(8);
            }
        }
        android.view.View view = this.g_renamed;
        if (view instanceof com.coui.appcompat.widget.COUIHintRedDot) {
            if (this.d_renamed != 0) {
                ((com.coui.appcompat.widget.COUIHintRedDot) view).a_renamed();
                this.g_renamed.setVisibility(0);
                ((com.coui.appcompat.widget.COUIHintRedDot) this.g_renamed).setPointMode(this.d_renamed);
                this.g_renamed.invalidate();
            } else {
                view.setVisibility(8);
            }
        }
        android.view.View view2 = this.h_renamed;
        if (view2 instanceof com.coui.appcompat.widget.COUIHintRedDot) {
            if (this.e_renamed != 0) {
                ((com.coui.appcompat.widget.COUIHintRedDot) view2).a_renamed();
                this.h_renamed.setVisibility(0);
                ((com.coui.appcompat.widget.COUIHintRedDot) this.h_renamed).setPointMode(this.e_renamed);
                ((com.coui.appcompat.widget.COUIHintRedDot) this.h_renamed).setPointNumber(this.f_renamed);
                this.h_renamed.invalidate();
                return;
            }
            view2.setVisibility(8);
        }
    }

    public java.lang.CharSequence c_renamed() {
        return this.m_renamed;
    }

    public void d_renamed(java.lang.CharSequence charSequence) {
        if (android.text.TextUtils.equals(this.m_renamed, charSequence)) {
            return;
        }
        this.m_renamed = charSequence;
        i_renamed();
    }
}
