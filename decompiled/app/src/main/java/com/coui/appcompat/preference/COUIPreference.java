package com.coui.appcompat.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.preference.PreferenceViewHolder;
import androidx.preference.Preference;
import com.coui.appcompat.widget.COUIHintRedDot;
import com.coui.appcompat.widget.COUIRoundImageView;
import coui.support.appcompat.R;

/* loaded from: classes.dex */
public class COUIPreference extends Preference {

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean f6957a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f6958b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int f6959c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f6960d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f6961e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f6962f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private View f6963g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private View f6964h;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f6965i;

    /* renamed from: OplusGLSurfaceView_15 */
    private float f6966j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f6967k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f6968l;

    /* renamed from: OplusGLSurfaceView_6 */
    private CharSequence f6969m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f6970n;

    public COUIPreference(Context context) {
        this(context, null);
    }

    public COUIPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6957a = true;
        m6913a(context, attributeSet, 0, 0);
    }

    public COUIPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f6957a = true;
        m6913a(context, attributeSet, OplusGLSurfaceView_13, 0);
    }

    public COUIPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f6957a = true;
        m6913a(context, attributeSet, OplusGLSurfaceView_13, i2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.COUIPreference, OplusGLSurfaceView_13, i2);
        this.f6957a = typedArrayObtainStyledAttributes.getBoolean(R.styleable.COUIPreference_couiShowDivider, this.f6957a);
        this.f6958b = typedArrayObtainStyledAttributes.getBoolean(R.styleable.COUIPreference_hasBorder, false);
        this.f6959c = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.COUIPreference_preference_icon_radius, 14);
        this.f6965i = typedArrayObtainStyledAttributes.getBoolean(R.styleable.COUIPreference_couiEnalbeClickSpan, false);
        typedArrayObtainStyledAttributes.recycle();
        this.f6966j = context.getResources().getDisplayMetrics().density;
        float COUIBaseListPopupWindow_12 = this.f6966j;
        this.f6967k = (int) ((14.0f * COUIBaseListPopupWindow_12) / 3.0f);
        this.f6968l = (int) ((COUIBaseListPopupWindow_12 * 36.0f) / 3.0f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m6913a(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.COUIPreference, OplusGLSurfaceView_13, i2);
        this.f6969m = typedArrayObtainStyledAttributes.getText(R.styleable.COUIPreference_couiAssignment);
        this.f6970n = typedArrayObtainStyledAttributes.getInt(R.styleable.COUIPreference_couiIconStyle, 1);
        this.f6960d = typedArrayObtainStyledAttributes.getInt(R.styleable.COUIPreference_iconRedDotMode, 0);
        this.f6961e = typedArrayObtainStyledAttributes.getInt(R.styleable.COUIPreference_endRedDotMode, 0);
        this.f6962f = typedArrayObtainStyledAttributes.getInt(R.styleable.COUIPreference_endRedDotNum, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3736a(PreferenceViewHolder c0668l) {
        final TextView textView;
        Drawable drawable;
        super.mo3736a(c0668l);
        View viewM4007a = c0668l.m4007a(android.R.id_renamed.icon);
        View viewM4007a2 = c0668l.m4007a(R.id_renamed.img_layout);
        this.f6963g = c0668l.m4007a(R.id_renamed.img_red_dot);
        this.f6964h = c0668l.m4007a(R.id_renamed.jump_icon_red_dot);
        if (viewM4007a != null && (viewM4007a instanceof COUIRoundImageView)) {
            if (viewM4007a.getHeight() != 0 && (drawable = ((COUIRoundImageView) viewM4007a).getDrawable()) != null) {
                this.f6959c = drawable.getIntrinsicHeight() / 6;
                int OplusGLSurfaceView_13 = this.f6959c;
                int i2 = this.f6967k;
                if (OplusGLSurfaceView_13 < i2) {
                    this.f6959c = i2;
                } else {
                    int i3 = this.f6968l;
                    if (OplusGLSurfaceView_13 > i3) {
                        this.f6959c = i3;
                    }
                }
            }
            COUIRoundImageView cOUIRoundImageView = (COUIRoundImageView) viewM4007a;
            cOUIRoundImageView.setHasBorder(this.f6958b);
            cOUIRoundImageView.setBorderRectRadius(this.f6959c);
            cOUIRoundImageView.setType(this.f6970n);
        }
        if (this.f6965i && (textView = (TextView) c0668l.m4007a(android.R.id_renamed.summary)) != null) {
            textView.setHighlightColor(m3800K().getResources().getColor(android.R.color.transparent));
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setOnTouchListener(new View.OnTouchListener() { // from class: com.coui.appcompat.preference.COUIPreference.1
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
            CharSequence charSequenceM6914c = m6914c();
            if (!TextUtils.isEmpty(charSequenceM6914c)) {
                textView2.setText(charSequenceM6914c);
                textView2.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
        }
        if (viewM4007a2 != null) {
            if (viewM4007a != null) {
                viewM4007a2.setVisibility(viewM4007a.getVisibility());
            } else {
                viewM4007a2.setVisibility(8);
            }
        }
        View view = this.f6963g;
        if (view instanceof COUIHintRedDot) {
            if (this.f6960d != 0) {
                ((COUIHintRedDot) view).m7140a();
                this.f6963g.setVisibility(0);
                ((COUIHintRedDot) this.f6963g).setPointMode(this.f6960d);
                this.f6963g.invalidate();
            } else {
                view.setVisibility(8);
            }
        }
        View view2 = this.f6964h;
        if (view2 instanceof COUIHintRedDot) {
            if (this.f6961e != 0) {
                ((COUIHintRedDot) view2).m7140a();
                this.f6964h.setVisibility(0);
                ((COUIHintRedDot) this.f6964h).setPointMode(this.f6961e);
                ((COUIHintRedDot) this.f6964h).setPointNumber(this.f6962f);
                this.f6964h.invalidate();
                return;
            }
            view2.setVisibility(8);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public CharSequence m6914c() {
        return this.f6969m;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m6915d(CharSequence charSequence) {
        if (TextUtils.equals(this.f6969m, charSequence)) {
            return;
        }
        this.f6969m = charSequence;
        mo3748i();
    }
}
