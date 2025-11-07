package com.coui.appcompat.preference;

/* loaded from: classes.dex */
public class COUIMarkPreference extends androidx.preference.CheckBoxPreference {

    /* renamed from: b_renamed, reason: collision with root package name */
    int f2591b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f2592c;
    private android.graphics.drawable.Drawable d_renamed;
    private boolean e_renamed;
    private boolean f_renamed;
    private int g_renamed;
    private int h_renamed;
    private int i_renamed;
    private float j_renamed;
    private java.lang.CharSequence k_renamed;

    public COUIMarkPreference(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        super(context, attributeSet, i_renamed);
        this.f2591b = 0;
        this.f2592c = true;
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, coui.support.appcompat.R_renamed.styleable.COUIMarkPreference, i_renamed, 0);
        this.f2591b = typedArrayObtainStyledAttributes.getInt(coui.support.appcompat.R_renamed.styleable.COUIMarkPreference_couiMarkStyle, 0);
        this.k_renamed = typedArrayObtainStyledAttributes.getText(coui.support.appcompat.R_renamed.styleable.COUIMarkPreference_couiMarkAssignment);
        typedArrayObtainStyledAttributes.recycle();
        android.content.res.TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, coui.support.appcompat.R_renamed.styleable.COUIPreference, i_renamed, 0);
        this.f2592c = typedArrayObtainStyledAttributes2.getBoolean(coui.support.appcompat.R_renamed.styleable.COUIPreference_couiShowDivider, this.f2592c);
        this.d_renamed = typedArrayObtainStyledAttributes2.getDrawable(coui.support.appcompat.R_renamed.styleable.COUIPreference_couiDividerDrawable);
        this.e_renamed = typedArrayObtainStyledAttributes2.getBoolean(coui.support.appcompat.R_renamed.styleable.COUIPreference_hasBorder, false);
        this.g_renamed = typedArrayObtainStyledAttributes2.getDimensionPixelSize(coui.support.appcompat.R_renamed.styleable.COUIPreference_preference_icon_radius, 14);
        this.f_renamed = typedArrayObtainStyledAttributes2.getBoolean(coui.support.appcompat.R_renamed.styleable.COUIPreference_couiEnalbeClickSpan, false);
        typedArrayObtainStyledAttributes2.recycle();
        e_renamed(true);
        this.j_renamed = context.getResources().getDisplayMetrics().density;
        float f_renamed = this.j_renamed;
        this.h_renamed = (int) ((14.0f * f_renamed) / 3.0f);
        this.i_renamed = (int) ((f_renamed * 36.0f) / 3.0f);
    }

    public COUIMarkPreference(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        this(context, attributeSet, i_renamed, 0);
    }

    public COUIMarkPreference(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, coui.support.appcompat.R_renamed.attr.couiMarkPreferenceStyle);
    }

    public COUIMarkPreference(android.content.Context context) {
        this(context, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.preference.CheckBoxPreference, androidx.preference.Preference
    public void a_renamed(androidx.preference.l_renamed lVar) {
        final android.widget.TextView textView;
        android.graphics.drawable.Drawable drawable;
        super.a_renamed(lVar);
        android.view.View viewA = lVar.a_renamed(coui.support.appcompat.R_renamed.id_renamed.coui_tail_mark);
        if (viewA != 0 && (viewA instanceof android.widget.Checkable)) {
            if (this.f2591b == 0) {
                viewA.setVisibility(0);
                ((android.widget.Checkable) viewA).setChecked(b_renamed());
            } else {
                viewA.setVisibility(8);
            }
        }
        android.view.View viewA2 = lVar.a_renamed(coui.support.appcompat.R_renamed.id_renamed.coui_head_mark);
        if (viewA2 != 0 && (viewA2 instanceof android.widget.Checkable)) {
            if (this.f2591b == 1) {
                viewA2.setVisibility(0);
                ((android.widget.Checkable) viewA2).setChecked(b_renamed());
            } else {
                viewA2.setVisibility(8);
            }
        }
        android.view.View viewA3 = lVar.a_renamed(android.R_renamed.id_renamed.icon);
        if (viewA3 != null && (viewA3 instanceof com.coui.appcompat.widget.COUIRoundImageView)) {
            if (viewA3.getHeight() != 0 && (drawable = ((com.coui.appcompat.widget.COUIRoundImageView) viewA3).getDrawable()) != null) {
                this.g_renamed = drawable.getIntrinsicHeight() / 6;
                int i_renamed = this.g_renamed;
                int i2 = this.h_renamed;
                if (i_renamed < i2) {
                    this.g_renamed = i2;
                } else {
                    int i3 = this.i_renamed;
                    if (i_renamed > i3) {
                        this.g_renamed = i3;
                    }
                }
            }
            com.coui.appcompat.widget.COUIRoundImageView cOUIRoundImageView = (com.coui.appcompat.widget.COUIRoundImageView) viewA3;
            cOUIRoundImageView.setHasBorder(this.e_renamed);
            cOUIRoundImageView.setBorderRectRadius(this.g_renamed);
        }
        if (this.f_renamed && (textView = (android.widget.TextView) lVar.a_renamed(android.R_renamed.id_renamed.summary)) != null) {
            textView.setHighlightColor(K_renamed().getResources().getColor(android.R_renamed.color.transparent));
            textView.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
            textView.setOnTouchListener(new android.view.View.OnTouchListener() { // from class: com.coui.appcompat.preference.COUIMarkPreference.1
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
    }

    public java.lang.CharSequence c_renamed() {
        return this.k_renamed;
    }
}
