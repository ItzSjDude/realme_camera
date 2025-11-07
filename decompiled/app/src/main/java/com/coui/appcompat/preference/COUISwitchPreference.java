package com.coui.appcompat.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.preference.PreferenceViewHolder;
import androidx.preference.SwitchPreference;
import com.coui.appcompat.widget.COUIRedDotDrawable;
import com.coui.appcompat.widget.COUIRoundImageView;
import com.coui.appcompat.widget.COUISwitch;
import coui.support.appcompat.R;

/* loaded from: classes.dex */
public class COUISwitchPreference extends SwitchPreference {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final C1332a f7005b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f7006c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Drawable f7007d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f7008e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private COUISwitch f7009f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f7010g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f7011h;

    /* renamed from: OplusGLSurfaceView_13 */
    private float f7012i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f7013j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f7014k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f7015l;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f7016m;

    /* renamed from: OplusGLSurfaceView_11 */
    private CharSequence f7017n;

    /* renamed from: o */
    private boolean f7018o;

    /* renamed from: p */
    private CharSequence f7019p;

    /* renamed from: com.coui.appcompat.preference.COUISwitchPreference$PlatformImplementations.kt_3 */
    private class C1332a implements CompoundButton.OnCheckedChangeListener {
        private C1332a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (COUISwitchPreference.this.m3901b() == z) {
                return;
            }
            if (!COUISwitchPreference.this.m6930d(Boolean.valueOf(z))) {
                compoundButton.setChecked(!z);
            } else {
                COUISwitchPreference.this.m3903e(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m6930d(Object obj) {
        if (m3797H() == null) {
            return true;
        }
        return m3797H().onPreferenceChange(this, obj);
    }

    public COUISwitchPreference(Context context) {
        this(context, null);
    }

    public COUISwitchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.switchPreferenceStyle);
    }

    public COUISwitchPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        this(context, attributeSet, OplusGLSurfaceView_13, 0);
    }

    public COUISwitchPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f7005b = new C1332a();
        this.f7006c = true;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.COUIPreference, OplusGLSurfaceView_13, 0);
        this.f7006c = typedArrayObtainStyledAttributes.getBoolean(R.styleable.COUIPreference_couiShowDivider, this.f7006c);
        this.f7007d = typedArrayObtainStyledAttributes.getDrawable(R.styleable.COUIPreference_couiDividerDrawable);
        this.f7008e = typedArrayObtainStyledAttributes.getBoolean(R.styleable.COUIPreference_couiEnalbeClickSpan, false);
        this.f7010g = typedArrayObtainStyledAttributes.getBoolean(R.styleable.COUIPreference_hasBorder, false);
        this.f7011h = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.COUIPreference_preference_icon_radius, 14);
        this.f7017n = typedArrayObtainStyledAttributes.getText(R.styleable.COUIPreference_couiAssignment);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.COUISwitchPreference, OplusGLSurfaceView_13, 0);
        this.f7018o = typedArrayObtainStyledAttributes2.getBoolean(R.styleable.COUISwitchPreference_hasTitleRedDot, false);
        typedArrayObtainStyledAttributes2.recycle();
        this.f7019p = m3856x();
        this.f7012i = context.getResources().getDisplayMetrics().density;
        float COUIBaseListPopupWindow_12 = this.f7012i;
        this.f7013j = (int) ((14.0f * COUIBaseListPopupWindow_12) / 3.0f);
        this.f7014k = (int) ((COUIBaseListPopupWindow_12 * 36.0f) / 3.0f);
        this.f7015l = context.getResources().getDimensionPixelOffset(R.dimen.coui_dot_diameter_small);
        this.f7016m = context.getResources().getDimensionPixelOffset(R.dimen.coui_switch_preference_dot_margin_start);
    }

    @Override // androidx.preference.SwitchPreference, androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3736a(PreferenceViewHolder c0668l) {
        Drawable drawable;
        final TextView textView;
        View viewM4007a = c0668l.m4007a(R.id_renamed.coui_preference);
        if (viewM4007a != null) {
            viewM4007a.setSoundEffectsEnabled(false);
            viewM4007a.setHapticFeedbackEnabled(false);
        }
        View viewM4007a2 = c0668l.m4007a(android.R.id_renamed.switch_widget);
        if (viewM4007a2 instanceof COUISwitch) {
            COUISwitch cOUISwitch = (COUISwitch) viewM4007a2;
            cOUISwitch.m7469d();
            cOUISwitch.setOnCheckedChangeListener(this.f7005b);
            cOUISwitch.setVerticalScrollBarEnabled(false);
            this.f7009f = cOUISwitch;
        }
        super.mo3736a(c0668l);
        if (this.f7008e && (textView = (TextView) c0668l.m4007a(android.R.id_renamed.summary)) != null) {
            textView.setHighlightColor(m3800K().getResources().getColor(android.R.color.transparent));
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setOnTouchListener(new View.OnTouchListener() { // from class: com.coui.appcompat.preference.COUISwitchPreference.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    int actionMasked = motionEvent.getActionMasked();
                    int selectionStart = textView.getSelectionStart();
                    int selectionEnd = textView.getSelectionEnd();
                    int offsetForPosition = textView.getOffsetForPosition(motionEvent.getX(), motionEvent.getY());
                    boolean z = selectionStart == selectionEnd || offsetForPosition <= selectionStart || offsetForPosition >= selectionEnd;
                    if (actionMasked != 0) {
                        if (actionMasked == 1 || actionMasked == 3) {
                            textView.setPressed(false);
                            textView.postInvalidateDelayed(70L);
                        }
                    } else {
                        if (z) {
                            return false;
                        }
                        textView.setPressed(true);
                        textView.invalidate();
                    }
                    return false;
                }
            });
        }
        View viewFindViewById = c0668l.itemView.findViewById(android.R.id_renamed.icon);
        if (viewFindViewById != null && (viewFindViewById instanceof COUIRoundImageView)) {
            if (viewFindViewById.getHeight() != 0 && (drawable = ((COUIRoundImageView) viewFindViewById).getDrawable()) != null) {
                this.f7011h = drawable.getIntrinsicHeight() / 6;
                int OplusGLSurfaceView_13 = this.f7011h;
                int i2 = this.f7013j;
                if (OplusGLSurfaceView_13 < i2) {
                    this.f7011h = i2;
                } else {
                    int i3 = this.f7014k;
                    if (OplusGLSurfaceView_13 > i3) {
                        this.f7011h = i3;
                    }
                }
            }
            COUIRoundImageView cOUIRoundImageView = (COUIRoundImageView) viewFindViewById;
            cOUIRoundImageView.setHasBorder(this.f7010g);
            cOUIRoundImageView.setBorderRectRadius(this.f7011h);
        }
        View viewM4007a3 = c0668l.m4007a(R.id_renamed.img_layout);
        if (viewM4007a3 != null) {
            if (viewFindViewById != null) {
                viewM4007a3.setVisibility(viewFindViewById.getVisibility());
            } else {
                viewM4007a3.setVisibility(8);
            }
        }
        TextView textView2 = (TextView) c0668l.itemView.findViewById(R.id_renamed.assignment);
        if (textView2 != null) {
            CharSequence charSequenceM6932h = m6932h();
            if (!TextUtils.isEmpty(charSequenceM6932h)) {
                textView2.setText(charSequenceM6932h);
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
        }
        TextView textView3 = (TextView) c0668l.m4007a(android.R.id_renamed.title);
        if (this.f7018o) {
            SpannableString spannableString = new SpannableString(((Object) this.f7019p) + " ");
            COUIRedDotDrawable c1488m = new COUIRedDotDrawable(1, 0, m3800K(), new RectF(this.f7016m, 0.0f, r5 + r8, this.f7015l));
            c1488m.setBounds(0, 0, this.f7016m + this.f7015l, (textView3.getLineHeight() / 2) + (this.f7015l / 2));
            spannableString.setSpan(new ImageSpan(c1488m), this.f7019p.length(), this.f7019p.length() + 1, 17);
            textView3.setText(spannableString);
            return;
        }
        textView3.setText(this.f7019p);
    }

    @Override // androidx.preference.Preference
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo3829b(CharSequence charSequence) {
        super.mo3829b(charSequence);
        this.f7019p = m3856x();
    }

    @Override // androidx.preference.TwoStatePreference, androidx.preference.Preference
    /* renamed from: COUIBaseListPopupWindow_11 */
    protected void mo3743g() {
        m6931g(true);
        m6933h(true);
        super.mo3743g();
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m6931g(boolean z) {
        COUISwitch cOUISwitch = this.f7009f;
        if (cOUISwitch != null) {
            cOUISwitch.setShouldPlaySound(z);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m6933h(boolean z) {
        COUISwitch cOUISwitch = this.f7009f;
        if (cOUISwitch != null) {
            cOUISwitch.setTactileFeedbackEnabled(z);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public CharSequence m6932h() {
        return this.f7017n;
    }
}
