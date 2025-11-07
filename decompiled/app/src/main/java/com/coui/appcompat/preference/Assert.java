package com.coui.appcompat.preference;

/* loaded from: classes.dex */
public class COUISwitchLoadingPreference extends androidx.preference.SwitchPreferenceCompat {

    /* renamed from: b_renamed, reason: collision with root package name */
    android.view.View f2625b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.coui.appcompat.widget.COUISwitch f2626c;
    private final com.coui.appcompat.preference.COUISwitchLoadingPreference.a_renamed d_renamed;
    private boolean e_renamed;
    private android.graphics.drawable.Drawable f_renamed;
    private boolean g_renamed;
    private com.coui.appcompat.widget.COUISwitch.a_renamed h_renamed;

    private class a_renamed implements android.widget.CompoundButton.OnCheckedChangeListener {
        private a_renamed() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(android.widget.CompoundButton compoundButton, boolean z_renamed) {
            if (!com.coui.appcompat.preference.COUISwitchLoadingPreference.this.d_renamed(java.lang.Boolean.valueOf(z_renamed))) {
                compoundButton.setChecked(!z_renamed);
            } else {
                com.coui.appcompat.preference.COUISwitchLoadingPreference.this.e_renamed(z_renamed);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d_renamed(java.lang.Object obj) {
        if (H_renamed() == null) {
            return true;
        }
        return H_renamed().onPreferenceChange(this, obj);
    }

    public COUISwitchLoadingPreference(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, coui.support.appcompat.R_renamed.attr.couiSwitchLoadPreferenceStyle);
    }

    public COUISwitchLoadingPreference(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        this(context, attributeSet, i_renamed, 0);
    }

    public COUISwitchLoadingPreference(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        super(context, attributeSet, i_renamed);
        this.d_renamed = new com.coui.appcompat.preference.COUISwitchLoadingPreference.a_renamed();
        this.e_renamed = true;
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, coui.support.appcompat.R_renamed.styleable.COUIPreference, i_renamed, 0);
        this.e_renamed = typedArrayObtainStyledAttributes.getBoolean(coui.support.appcompat.R_renamed.styleable.COUIPreference_couiShowDivider, this.e_renamed);
        this.f_renamed = typedArrayObtainStyledAttributes.getDrawable(coui.support.appcompat.R_renamed.styleable.COUIPreference_couiDividerDrawable);
        this.g_renamed = typedArrayObtainStyledAttributes.getBoolean(coui.support.appcompat.R_renamed.styleable.COUIPreference_couiEnalbeClickSpan, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.SwitchPreferenceCompat, androidx.preference.Preference
    public void a_renamed(androidx.preference.l_renamed lVar) {
        final android.widget.TextView textView;
        android.view.View viewA = lVar.a_renamed(coui.support.appcompat.R_renamed.id_renamed.coui_preference);
        if (viewA != null) {
            viewA.setSoundEffectsEnabled(false);
            viewA.setHapticFeedbackEnabled(false);
        }
        this.f2625b = lVar.a_renamed(coui.support.appcompat.R_renamed.id_renamed.switchWidget);
        android.view.View view = this.f2625b;
        if (view instanceof com.coui.appcompat.widget.COUISwitch) {
            com.coui.appcompat.widget.COUISwitch cOUISwitch = (com.coui.appcompat.widget.COUISwitch) view;
            cOUISwitch.setOnCheckedChangeListener(null);
            cOUISwitch.setVerticalScrollBarEnabled(false);
            this.f2626c = cOUISwitch;
        }
        super.a_renamed(lVar);
        android.view.View view2 = this.f2625b;
        if (view2 instanceof com.coui.appcompat.widget.COUISwitch) {
            com.coui.appcompat.widget.COUISwitch cOUISwitch2 = (com.coui.appcompat.widget.COUISwitch) view2;
            cOUISwitch2.setLoadingStyle(true);
            cOUISwitch2.d_renamed();
            cOUISwitch2.setOnLoadingStateChangedListener(this.h_renamed);
            cOUISwitch2.setOnCheckedChangeListener(this.d_renamed);
        }
        if (this.g_renamed && (textView = (android.widget.TextView) lVar.a_renamed(android.R_renamed.id_renamed.summary)) != null) {
            textView.setHighlightColor(K_renamed().getResources().getColor(android.R_renamed.color.transparent));
            textView.setMovementMethod(android.text.method.LinkMovementMethod.getInstance());
            textView.setOnTouchListener(new android.view.View.OnTouchListener() { // from class: com.coui.appcompat.preference.COUISwitchLoadingPreference.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(android.view.View view3, android.view.MotionEvent motionEvent) {
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
        android.view.View viewFindViewById = lVar.itemView.findViewById(android.R_renamed.id_renamed.icon);
        android.view.View viewA2 = lVar.a_renamed(coui.support.appcompat.R_renamed.id_renamed.img_layout);
        if (viewA2 != null) {
            if (viewFindViewById != null) {
                viewA2.setVisibility(viewFindViewById.getVisibility());
            } else {
                viewA2.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.TwoStatePreference, androidx.preference.Preference
    public void g_renamed() {
        com.coui.appcompat.widget.COUISwitch cOUISwitch = this.f2626c;
        if (cOUISwitch != null) {
            cOUISwitch.setShouldPlaySound(true);
            this.f2626c.setTactileFeedbackEnabled(true);
            this.f2626c.b_renamed();
        }
    }
}
