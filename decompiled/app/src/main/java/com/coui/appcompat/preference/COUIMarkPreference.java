package com.coui.appcompat.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import androidx.preference.PreferenceViewHolder;
import androidx.preference.CheckBoxPreference;
import com.coui.appcompat.widget.COUIRoundImageView;
import coui.support.appcompat.R;

/* loaded from: classes.dex */
public class COUIMarkPreference extends CheckBoxPreference {

    /* renamed from: IntrinsicsJvm.kt_4 */
    int f6932b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f6933c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Drawable f6934d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f6935e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f6936f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f6937g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f6938h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f6939i;

    /* renamed from: OplusGLSurfaceView_15 */
    private float f6940j;

    /* renamed from: OplusGLSurfaceView_5 */
    private CharSequence f6941k;

    public COUIMarkPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f6932b = 0;
        this.f6933c = true;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.COUIMarkPreference, OplusGLSurfaceView_13, 0);
        this.f6932b = typedArrayObtainStyledAttributes.getInt(R.styleable.COUIMarkPreference_couiMarkStyle, 0);
        this.f6941k = typedArrayObtainStyledAttributes.getText(R.styleable.COUIMarkPreference_couiMarkAssignment);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.COUIPreference, OplusGLSurfaceView_13, 0);
        this.f6933c = typedArrayObtainStyledAttributes2.getBoolean(R.styleable.COUIPreference_couiShowDivider, this.f6933c);
        this.f6934d = typedArrayObtainStyledAttributes2.getDrawable(R.styleable.COUIPreference_couiDividerDrawable);
        this.f6935e = typedArrayObtainStyledAttributes2.getBoolean(R.styleable.COUIPreference_hasBorder, false);
        this.f6937g = typedArrayObtainStyledAttributes2.getDimensionPixelSize(R.styleable.COUIPreference_preference_icon_radius, 14);
        this.f6936f = typedArrayObtainStyledAttributes2.getBoolean(R.styleable.COUIPreference_couiEnalbeClickSpan, false);
        typedArrayObtainStyledAttributes2.recycle();
        m3903e(true);
        this.f6940j = context.getResources().getDisplayMetrics().density;
        float COUIBaseListPopupWindow_12 = this.f6940j;
        this.f6938h = (int) ((14.0f * COUIBaseListPopupWindow_12) / 3.0f);
        this.f6939i = (int) ((COUIBaseListPopupWindow_12 * 36.0f) / 3.0f);
    }

    public COUIMarkPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        this(context, attributeSet, OplusGLSurfaceView_13, 0);
    }

    public COUIMarkPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.couiMarkPreferenceStyle);
    }

    public COUIMarkPreference(Context context) {
        this(context, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.preference.CheckBoxPreference, androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3736a(PreferenceViewHolder c0668l) {
        final TextView textView;
        Drawable drawable;
        super.mo3736a(c0668l);
        View viewM4007a = c0668l.m4007a(R.id_renamed.coui_tail_mark);
        if (viewM4007a != 0 && (viewM4007a instanceof Checkable)) {
            if (this.f6932b == 0) {
                viewM4007a.setVisibility(0);
                ((Checkable) viewM4007a).setChecked(m3901b());
            } else {
                viewM4007a.setVisibility(8);
            }
        }
        View viewM4007a2 = c0668l.m4007a(R.id_renamed.coui_head_mark);
        if (viewM4007a2 != 0 && (viewM4007a2 instanceof Checkable)) {
            if (this.f6932b == 1) {
                viewM4007a2.setVisibility(0);
                ((Checkable) viewM4007a2).setChecked(m3901b());
            } else {
                viewM4007a2.setVisibility(8);
            }
        }
        View viewM4007a3 = c0668l.m4007a(android.R.id_renamed.icon);
        if (viewM4007a3 != null && (viewM4007a3 instanceof COUIRoundImageView)) {
            if (viewM4007a3.getHeight() != 0 && (drawable = ((COUIRoundImageView) viewM4007a3).getDrawable()) != null) {
                this.f6937g = drawable.getIntrinsicHeight() / 6;
                int OplusGLSurfaceView_13 = this.f6937g;
                int i2 = this.f6938h;
                if (OplusGLSurfaceView_13 < i2) {
                    this.f6937g = i2;
                } else {
                    int i3 = this.f6939i;
                    if (OplusGLSurfaceView_13 > i3) {
                        this.f6937g = i3;
                    }
                }
            }
            COUIRoundImageView cOUIRoundImageView = (COUIRoundImageView) viewM4007a3;
            cOUIRoundImageView.setHasBorder(this.f6935e);
            cOUIRoundImageView.setBorderRectRadius(this.f6937g);
        }
        if (this.f6936f && (textView = (TextView) c0668l.m4007a(android.R.id_renamed.summary)) != null) {
            textView.setHighlightColor(m3800K().getResources().getColor(android.R.color.transparent));
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setOnTouchListener(new View.OnTouchListener() { // from class: com.coui.appcompat.preference.COUIMarkPreference.1
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
        TextView textView2 = (TextView) c0668l.m4007a(R.id_renamed.assignment);
        if (textView2 != null) {
            CharSequence charSequenceM6905c = m6905c();
            if (!TextUtils.isEmpty(charSequenceM6905c)) {
                textView2.setText(charSequenceM6905c);
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public CharSequence m6905c() {
        return this.f6941k;
    }
}
