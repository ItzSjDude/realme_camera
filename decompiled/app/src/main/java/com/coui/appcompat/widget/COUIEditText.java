package com.coui.appcompat.widget;

import android.R;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.Selection;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.p036h.ViewCompat;
import androidx.core.p036h.p037a.AccessibilityNodeInfoCompat;
import androidx.customview.p039a.ExploreByTouchHelper;
import com.coui.appcompat.p099a.COUIContextUtil;
import com.coui.appcompat.widget.COUICutoutDrawable;
import com.google.android.material.badge.BadgeDrawable;
import java.util.List;

/* loaded from: classes.dex */
public class COUIEditText extends AppCompatEditText {

    /* renamed from: A */
    private float f7220A;

    /* renamed from: B */
    private float f7221B;

    /* renamed from: C */
    private float f7222C;

    /* renamed from: D */
    private int f7223D;

    /* renamed from: E */
    private int f7224E;

    /* renamed from: F */
    private int f7225F;

    /* renamed from: G */
    private int f7226G;

    /* renamed from: H */
    private RectF f7227H;

    /* renamed from: I */
    private ColorStateList f7228I;

    /* renamed from: J */
    private ColorStateList f7229J;

    /* renamed from: K */
    private int f7230K;

    /* renamed from: L */
    private int f7231L;

    /* renamed from: M */
    private int f7232M;

    /* renamed from: N */
    private int f7233N;

    /* renamed from: O */
    private boolean f7234O;

    /* renamed from: P */
    private boolean f7235P;

    /* renamed from: Q */
    private ValueAnimator f7236Q;

    /* renamed from: R */
    private ValueAnimator f7237R;

    /* renamed from: S */
    private ValueAnimator f7238S;

    /* renamed from: T */
    private boolean f7239T;

    /* renamed from: U */
    private boolean f7240U;

    /* renamed from: V */
    private boolean f7241V;

    /* renamed from: W */
    private Paint f7242W;

    /* renamed from: PlatformImplementations.kt_3 */
    private final COUICutoutDrawable.PlatformImplementations.kt_3 f7243a;

    /* renamed from: aa */
    private Paint f7244aa;

    /* renamed from: ab */
    private Paint f7245ab;

    /* renamed from: ac */
    private Paint f7246ac;

    /* renamed from: ad */
    private TextPaint f7247ad;

    /* renamed from: ae */
    private int f7248ae;

    /* renamed from: af */
    private float f7249af;

    /* renamed from: ag */
    private int f7250ag;

    /* renamed from: ah */
    private int f7251ah;

    /* renamed from: ai */
    private int f7252ai;

    /* renamed from: aj */
    private int f7253aj;

    /* renamed from: ak */
    private int f7254ak;

    /* renamed from: al */
    private int f7255al;

    /* renamed from: am */
    private boolean f7256am;

    /* renamed from: an */
    private boolean f7257an;

    /* renamed from: ao */
    private String f7258ao;

    /* renamed from: ap */
    private int f7259ap;

    /* renamed from: aq */
    private COUIErrorEditTextHelper f7260aq;

    /* renamed from: ar */
    private Runnable f7261ar;

    /* renamed from: as */
    private Runnable f7262as;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Interpolator f7263b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Interpolator f7264c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f7265d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Drawable f7266e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Drawable f7267f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private boolean f7268g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private boolean f7269h;

    /* renamed from: OplusGLSurfaceView_13 */
    private boolean f7270i;

    /* renamed from: OplusGLSurfaceView_15 */
    private InterfaceC1377e f7271j;

    /* renamed from: OplusGLSurfaceView_5 */
    private InterfaceC1376d f7272k;

    /* renamed from: OplusGLSurfaceView_14 */
    private int f7273l;

    /* renamed from: OplusGLSurfaceView_6 */
    private Context f7274m;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f7275n;

    /* renamed from: o */
    private boolean f7276o;

    /* renamed from: p */
    private ViewOnClickListenerC1373a f7277p;

    /* renamed from: q */
    private String f7278q;

    /* renamed from: r */
    private C1374b f7279r;

    /* renamed from: s */
    private CharSequence f7280s;

    /* renamed from: t */
    private boolean f7281t;

    /* renamed from: u */
    private CharSequence f7282u;

    /* renamed from: v */
    private boolean f7283v;

    /* renamed from: w */
    private GradientDrawable f7284w;

    /* renamed from: x */
    private int f7285x;

    /* renamed from: y */
    private int f7286y;

    /* renamed from: z */
    private float f7287z;

    /* renamed from: com.coui.appcompat.widget.COUIEditText$IntrinsicsJvm.kt_3 */
    public interface InterfaceC1375c {
        /* renamed from: PlatformImplementations.kt_3 */
        void m7121a(boolean z);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void m7122b(boolean z);
    }

    /* renamed from: com.coui.appcompat.widget.COUIEditText$IntrinsicsJvm.kt_5 */
    public interface InterfaceC1376d {
        /* renamed from: PlatformImplementations.kt_3 */
        boolean m7123a();
    }

    /* renamed from: com.coui.appcompat.widget.COUIEditText$COUIBaseListPopupWindow_8 */
    public interface InterfaceC1377e {
        /* renamed from: PlatformImplementations.kt_3 */
        boolean m7124a();
    }

    public COUIEditText(Context context) {
        this(context, null);
    }

    public COUIEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    @SuppressLint({"WrongConstant"})
    public COUIEditText(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f7243a = new COUICutoutDrawable.PlatformImplementations.kt_3(this);
        this.f7268g = false;
        this.f7269h = false;
        this.f7270i = false;
        this.f7271j = null;
        this.f7272k = null;
        this.f7276o = false;
        this.f7278q = null;
        this.f7279r = null;
        this.f7223D = 2;
        this.f7224E = 4;
        this.f7227H = new RectF();
        this.f7256am = false;
        this.f7257an = false;
        this.f7258ao = "";
        this.f7259ap = 0;
        this.f7261ar = new Runnable() { // from class: com.coui.appcompat.widget.COUIEditText.1
            @Override // java.lang.Runnable
            public void run() {
                COUIEditText.this.setCompoundDrawables(null, null, null, null);
            }
        };
        this.f7262as = new Runnable() { // from class: com.coui.appcompat.widget.COUIEditText.2
            @Override // java.lang.Runnable
            public void run() {
                COUIEditText cOUIEditText = COUIEditText.this;
                cOUIEditText.setCompoundDrawables(null, null, cOUIEditText.f7266e, null);
            }
        };
        if (attributeSet != null) {
            this.f7265d = attributeSet.getStyleAttribute();
        }
        if (this.f7265d == 0) {
            this.f7265d = OplusGLSurfaceView_13;
        }
        this.f7274m = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, coui.support.appcompat.R.styleable.COUIEditText, OplusGLSurfaceView_13, 0);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(coui.support.appcompat.R.styleable.COUIEditText_quickDelete, false);
        this.f7233N = typedArrayObtainStyledAttributes.getColor(coui.support.appcompat.R.styleable.COUIEditText_couiEditTextErrorColor, getResources().getColor(coui.support.appcompat.R.color.coui_error_color_default));
        this.f7266e = typedArrayObtainStyledAttributes.getDrawable(coui.support.appcompat.R.styleable.COUIEditText_couiEditTextDeleteIconNormal);
        this.f7267f = typedArrayObtainStyledAttributes.getDrawable(coui.support.appcompat.R.styleable.COUIEditText_couiEditTextDeleteIconPressed);
        this.f7257an = typedArrayObtainStyledAttributes.getBoolean(coui.support.appcompat.R.styleable.COUIEditText_couiEditTextIsEllipsis, true);
        typedArrayObtainStyledAttributes.recycle();
        setFastDeletable(z);
        Drawable drawable = this.f7266e;
        if (drawable != null) {
            this.f7254ak = drawable.getIntrinsicWidth();
            this.f7255al = this.f7266e.getIntrinsicHeight();
            this.f7266e.setBounds(0, 0, this.f7254ak, this.f7255al);
        }
        Drawable drawable2 = this.f7267f;
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, this.f7254ak, this.f7255al);
        }
        this.f7277p = new ViewOnClickListenerC1373a(this);
        ViewCompat.m2854a(this, this.f7277p);
        ViewCompat.m2867b((View) this, 1);
        this.f7278q = this.f7274m.getString(coui.support.appcompat.R.string.coui_slide_delete);
        this.f7277p.invalidateRoot();
        this.f7260aq = new COUIErrorEditTextHelper(this);
        m7082a(context, attributeSet, OplusGLSurfaceView_13);
        this.f7260aq.m7629a(this.f7233N, this.f7224E, this.f7286y, getCornerRadiiAsArray(), this.f7243a);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7082a(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        this.f7243a.m7581a(new LinearInterpolator());
        this.f7243a.m7589b(new LinearInterpolator());
        this.f7243a.m7586b(BadgeDrawable.TOP_START);
        if (Build.VERSION.SDK_INT >= 21) {
            this.f7263b = new PathInterpolator(0.3f, 0.0f, 0.1f, 1.0f);
            this.f7264c = new PathInterpolator(0.0f, 0.0f, 0.1f, 1.0f);
        } else {
            this.f7263b = new LinearInterpolator();
            this.f7264c = new LinearInterpolator();
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, coui.support.appcompat.R.styleable.COUIEditText, OplusGLSurfaceView_13, coui.support.appcompat.R.style.Widget_COUI_EditText_HintAnim_Line);
        this.f7281t = typedArrayObtainStyledAttributes.getBoolean(coui.support.appcompat.R.styleable.COUIEditText_couiHintEnabled, false);
        if (Build.VERSION.SDK_INT < 23) {
            this.f7281t = false;
            setPadding(0, 0, 0, 0);
            return;
        }
        setTopHint(typedArrayObtainStyledAttributes.getText(coui.support.appcompat.R.styleable.COUIEditText_android_hint));
        if (this.f7281t) {
            this.f7235P = typedArrayObtainStyledAttributes.getBoolean(coui.support.appcompat.R.styleable.COUIEditText_couiHintAnimationEnabled, true);
        }
        this.f7250ag = typedArrayObtainStyledAttributes.getDimensionPixelOffset(coui.support.appcompat.R.styleable.COUIEditText_rectModePaddingTop, 0);
        float dimension = typedArrayObtainStyledAttributes.getDimension(coui.support.appcompat.R.styleable.COUIEditText_cornerRadius, 0.0f);
        this.f7287z = dimension;
        this.f7220A = dimension;
        this.f7221B = dimension;
        this.f7222C = dimension;
        this.f7231L = typedArrayObtainStyledAttributes.getColor(coui.support.appcompat.R.styleable.COUIEditText_couiStrokeColor, COUIContextUtil.m6399a(context, coui.support.appcompat.R.attr.couiPrimaryColor, 0));
        this.f7223D = typedArrayObtainStyledAttributes.getDimensionPixelSize(coui.support.appcompat.R.styleable.COUIEditText_couiStrokeWidth, 0);
        this.f7225F = this.f7223D;
        this.f7252ai = context.getResources().getDimensionPixelOffset(coui.support.appcompat.R.dimen.coui_textinput_line_padding);
        if (this.f7281t) {
            this.f7285x = context.getResources().getDimensionPixelOffset(coui.support.appcompat.R.dimen.coui_textinput_label_cutout_padding);
            this.f7251ah = context.getResources().getDimensionPixelOffset(coui.support.appcompat.R.dimen.coui_textinput_line_padding_top);
            this.f7253aj = context.getResources().getDimensionPixelOffset(coui.support.appcompat.R.dimen.coui_textinput_line_padding_middle);
        }
        int i2 = typedArrayObtainStyledAttributes.getInt(coui.support.appcompat.R.styleable.COUIEditText_couiBackgroundMode, 0);
        setBoxBackgroundMode(i2);
        if (this.f7286y != 0) {
            setBackgroundDrawable(null);
        }
        if (typedArrayObtainStyledAttributes.hasValue(coui.support.appcompat.R.styleable.COUIEditText_android_textColorHint)) {
            ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(coui.support.appcompat.R.styleable.COUIEditText_android_textColorHint);
            this.f7229J = colorStateList;
            this.f7228I = colorStateList;
        }
        this.f7230K = typedArrayObtainStyledAttributes.getColor(coui.support.appcompat.R.styleable.COUIEditText_couiDefaultStrokeColor, 0);
        this.f7232M = typedArrayObtainStyledAttributes.getColor(coui.support.appcompat.R.styleable.COUIEditText_couiDisabledStrokeColor, 0);
        this.f7258ao = typedArrayObtainStyledAttributes.getString(coui.support.appcompat.R.styleable.COUIEditText_couiEditTexttNoEllipsisText);
        setText(this.f7258ao);
        m7113a(typedArrayObtainStyledAttributes.getDimensionPixelSize(coui.support.appcompat.R.styleable.COUIEditText_collapsedTextSize, 0), typedArrayObtainStyledAttributes.getColorStateList(coui.support.appcompat.R.styleable.COUIEditText_collapsedTextColor));
        if (i2 == 2) {
            this.f7243a.m7580a(Typeface.create("sans-serif-medium", 0));
        }
        typedArrayObtainStyledAttributes.recycle();
        this.f7246ac = new Paint();
        this.f7247ad = new TextPaint();
        this.f7247ad.setTextSize(getTextSize());
        this.f7244aa = new Paint();
        this.f7244aa.setColor(this.f7230K);
        this.f7244aa.setStrokeWidth(this.f7223D);
        this.f7245ab = new Paint();
        this.f7245ab.setColor(this.f7232M);
        this.f7245ab.setStrokeWidth(this.f7223D);
        this.f7242W = new Paint();
        this.f7242W.setColor(this.f7231L);
        this.f7242W.setStrokeWidth(this.f7224E);
        m7098g();
    }

    public void setFastDeletable(boolean z) {
        if (this.f7269h != z) {
            this.f7269h = z;
            if (this.f7269h) {
                if (this.f7279r == null) {
                    this.f7279r = new C1374b();
                    addTextChangedListener(this.f7279r);
                }
                this.f7275n = this.f7274m.getResources().getDimensionPixelSize(coui.support.appcompat.R.dimen.coui_edit_text_drawable_padding);
                setCompoundDrawablePadding(this.f7275n);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m7089b(boolean z) {
        if (TextUtils.isEmpty(getText().toString())) {
            if (m7112u()) {
                setPaddingRelative(0, getPaddingTop(), getPaddingEnd(), getPaddingBottom());
            }
            post(this.f7261ar);
            this.f7270i = false;
            return;
        }
        if (z) {
            if (this.f7266e == null || this.f7270i) {
                return;
            }
            if (m7112u()) {
                setPaddingRelative(this.f7254ak + this.f7275n, getPaddingTop(), getPaddingEnd(), getPaddingBottom());
            }
            post(this.f7262as);
            this.f7270i = true;
            return;
        }
        if (this.f7270i) {
            if (m7112u()) {
                setPaddingRelative(0, getPaddingTop(), getPaddingEnd(), getPaddingBottom());
            }
            post(this.f7261ar);
            this.f7270i = false;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z, int OplusGLSurfaceView_13, Rect rect) {
        super.onFocusChanged(z, OplusGLSurfaceView_13, rect);
        if (this.f7269h) {
            m7089b(z);
        }
    }

    public void setOnTextDeletedListener(InterfaceC1377e interfaceC1377e) {
        this.f7271j = interfaceC1377e;
    }

    public void setTextDeletedListener(InterfaceC1376d interfaceC1376d) {
        this.f7272k = interfaceC1376d;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterfaceC1377e interfaceC1377e;
        if (this.f7269h && !TextUtils.isEmpty(getText()) && hasFocus()) {
            Rect rect = new Rect();
            boolean z = m7086a(rect) && rect.contains((int) motionEvent.getX(), (int) motionEvent.getY());
            if (this.f7270i && z) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.f7268g = true;
                    return true;
                }
                if (action == 1) {
                    if (this.f7268g && ((interfaceC1377e = this.f7271j) == null || !interfaceC1377e.m7124a())) {
                        m7091c();
                        this.f7268g = false;
                    }
                } else if (action == 2 && this.f7268g) {
                    return true;
                }
            }
        }
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        this.f7259ap = getSelectionEnd();
        return zOnTouchEvent;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m7086a(Rect rect) {
        int width;
        if (m7111t()) {
            width = (getCompoundPaddingLeft() - this.f7254ak) - this.f7275n;
        } else {
            width = (getWidth() - getCompoundPaddingRight()) + this.f7275n;
        }
        int OplusGLSurfaceView_13 = this.f7254ak + width;
        int height = ((((getHeight() - getCompoundPaddingTop()) - getCompoundPaddingBottom()) - this.f7254ak) / 2) + getCompoundPaddingTop();
        rect.set(width, height, OplusGLSurfaceView_13, this.f7254ak + height);
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (getMaxLines() < 2 && this.f7257an && (parcelable instanceof COUISavedState)) {
            COUISavedState cOUISavedState = (COUISavedState) parcelable;
            if (cOUISavedState.text != null) {
                setText(cOUISavedState.text);
            }
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (getMaxLines() >= 2 || !this.f7257an || isFocused()) {
            return parcelableOnSaveInstanceState;
        }
        COUISavedState cOUISavedState = new COUISavedState(parcelableOnSaveInstanceState);
        cOUISavedState.text = getCouiEditTexttNoEllipsisText();
        return cOUISavedState;
    }

    public static class COUISavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<COUISavedState> CREATOR = new Parcelable.Creator<COUISavedState>() { // from class: com.coui.appcompat.widget.COUIEditText.COUISavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public COUISavedState createFromParcel(Parcel parcel) {
                return new COUISavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public COUISavedState[] newArray(int OplusGLSurfaceView_13) {
                return new COUISavedState[OplusGLSurfaceView_13];
            }
        };
        String text;

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        COUISavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            super.writeToParcel(parcel, OplusGLSurfaceView_13);
            parcel.writeString(this.text);
        }

        public void readFromParcel(Parcel parcel) {
            this.text = parcel.readString();
        }

        private COUISavedState(Parcel parcel) {
            super(parcel);
            this.text = parcel.readString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m7091c() {
        Editable text = getText();
        text.delete(0, text.length());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private boolean m7087a(String str) {
        if (str == null) {
            return false;
        }
        return TextUtils.isEmpty(str);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        if (drawable3 != null) {
            this.f7273l = drawable3.getBounds().width();
        } else {
            this.f7273l = 0;
        }
    }

    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int OplusGLSurfaceView_13, KeyEvent keyEvent) {
        if (this.f7269h && OplusGLSurfaceView_13 == 67) {
            super.onKeyDown(OplusGLSurfaceView_13, keyEvent);
            InterfaceC1376d interfaceC1376d = this.f7272k;
            if (interfaceC1376d == null) {
                return true;
            }
            interfaceC1376d.m7123a();
            return true;
        }
        return super.onKeyDown(OplusGLSurfaceView_13, keyEvent);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        Selection.setSelection(getText(), length());
    }

    @Override // android.view.View
    public void dispatchStartTemporaryDetach() {
        super.dispatchStartTemporaryDetach();
        if (this.f7276o) {
            onStartTemporaryDetach();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m7115a() {
        return this.f7269h && !m7087a(getText().toString()) && hasFocus();
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        ViewOnClickListenerC1373a viewOnClickListenerC1373a;
        if (m7115a() && (viewOnClickListenerC1373a = this.f7277p) != null && viewOnClickListenerC1373a.dispatchHoverEvent(motionEvent)) {
            return true;
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    public int getDeleteButtonLeft() {
        Drawable drawable = this.f7266e;
        return ((getRight() - getLeft()) - getPaddingRight()) - (drawable != null ? drawable.getIntrinsicWidth() : 0);
    }

    private Drawable getBoxBackground() {
        int OplusGLSurfaceView_13 = this.f7286y;
        if (OplusGLSurfaceView_13 == 1 || OplusGLSurfaceView_13 == 2) {
            return this.f7284w;
        }
        return null;
    }

    public void setBoxBackgroundMode(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == this.f7286y) {
            return;
        }
        this.f7286y = OplusGLSurfaceView_13;
        m7093d();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m7093d() {
        m7097f();
        m7099h();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m7096e() {
        ViewCompat.m2868b(this, m7111t() ? getPaddingRight() : getPaddingLeft(), getModePaddingTop(), m7111t() ? getPaddingLeft() : getPaddingRight(), getPaddingBottom());
    }

    private int getModePaddingTop() {
        int iM7592e;
        int iM7591d;
        int OplusGLSurfaceView_13 = this.f7286y;
        if (OplusGLSurfaceView_13 == 1) {
            iM7592e = this.f7251ah + ((int) this.f7243a.m7592e());
            iM7591d = this.f7253aj;
        } else {
            if (OplusGLSurfaceView_13 != 2) {
                return 0;
            }
            iM7592e = this.f7250ag;
            iM7591d = (int) (this.f7243a.m7591d() / 2.0f);
        }
        return iM7592e + iM7591d;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m7097f() {
        int OplusGLSurfaceView_13 = this.f7286y;
        if (OplusGLSurfaceView_13 == 0) {
            this.f7284w = null;
            return;
        }
        if (OplusGLSurfaceView_13 == 2 && this.f7281t && !(this.f7284w instanceof COUICutoutDrawable)) {
            this.f7284w = new COUICutoutDrawable();
        } else if (this.f7284w == null) {
            this.f7284w = new GradientDrawable();
        }
    }

    public int getBoxStrokeColor() {
        return this.f7231L;
    }

    public void setBoxStrokeColor(int OplusGLSurfaceView_13) {
        if (this.f7231L != OplusGLSurfaceView_13) {
            this.f7231L = OplusGLSurfaceView_13;
            this.f7242W.setColor(OplusGLSurfaceView_13);
            m7108q();
        }
    }

    private float[] getCornerRadiiAsArray() {
        float COUIBaseListPopupWindow_12 = this.f7220A;
        float f2 = this.f7287z;
        float f3 = this.f7222C;
        float f4 = this.f7221B;
        return new float[]{COUIBaseListPopupWindow_12, COUIBaseListPopupWindow_12, f2, f2, f3, f3, f4, f4};
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m7098g() {
        m7093d();
        this.f7243a.m7573a(getTextSize());
        int gravity = getGravity();
        this.f7243a.m7586b((gravity & (-113)) | 48);
        this.f7243a.m7574a(gravity);
        if (this.f7228I == null) {
            this.f7228I = getHintTextColors();
        }
        setHint(this.f7281t ? null : "");
        if (TextUtils.isEmpty(this.f7282u)) {
            this.f7280s = getHint();
            setTopHint(this.f7280s);
            setHint(this.f7281t ? null : "");
        }
        this.f7283v = true;
        m7085a(false, true);
        if (this.f7281t) {
            m7096e();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m7114a(boolean z) {
        m7085a(z, false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7085a(boolean z, boolean z2) {
        ColorStateList colorStateList;
        boolean zIsEnabled = isEnabled();
        boolean z3 = !TextUtils.isEmpty(getText());
        if (this.f7228I != null) {
            this.f7228I = getHintTextColors();
            this.f7243a.m7577a(this.f7229J);
            this.f7243a.m7588b(this.f7228I);
        }
        if (!zIsEnabled) {
            this.f7243a.m7577a(ColorStateList.valueOf(this.f7232M));
            this.f7243a.m7588b(ColorStateList.valueOf(this.f7232M));
        } else if (hasFocus() && (colorStateList = this.f7229J) != null) {
            this.f7243a.m7577a(colorStateList);
        }
        if (z3 || (isEnabled() && hasFocus())) {
            if (z2 || this.f7234O) {
                m7092c(z);
            }
        } else if ((z2 || !this.f7234O) && m7116b()) {
            m7095d(z);
        }
        COUIErrorEditTextHelper c1451e = this.f7260aq;
        if (c1451e != null) {
            c1451e.m7635a(this.f7243a);
        }
    }

    public void setTopHint(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 23) {
            setHintInternal(charSequence);
        }
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.f7282u)) {
            return;
        }
        this.f7282u = charSequence;
        this.f7243a.m7582a(charSequence);
        if (!this.f7234O) {
            m7105n();
        }
        COUIErrorEditTextHelper c1451e = this.f7260aq;
        if (c1451e != null) {
            c1451e.m7639b(this.f7243a);
        }
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        if (this.f7281t) {
            return this.f7282u;
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m7116b() {
        return this.f7281t;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.f7281t) {
            this.f7281t = z;
            if (!this.f7281t) {
                this.f7283v = false;
                if (!TextUtils.isEmpty(this.f7282u) && TextUtils.isEmpty(getHint())) {
                    setHint(this.f7282u);
                }
                setHintInternal(null);
                return;
            }
            CharSequence hint = getHint();
            if (!TextUtils.isEmpty(hint)) {
                if (TextUtils.isEmpty(this.f7282u)) {
                    setTopHint(hint);
                }
                setHint((CharSequence) null);
            }
            this.f7283v = true;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m7113a(int OplusGLSurfaceView_13, ColorStateList colorStateList) {
        this.f7243a.m7576a(OplusGLSurfaceView_13, colorStateList);
        this.f7229J = this.f7243a.m7603p();
        m7114a(false);
        this.f7260aq.m7630a(OplusGLSurfaceView_13, colorStateList);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m7099h() {
        if (this.f7286y == 0 || this.f7284w == null || getRight() == 0) {
            return;
        }
        this.f7284w.setBounds(0, getBoundsTop(), getWidth(), getHeight());
        m7102k();
    }

    private int getBoundsTop() {
        int OplusGLSurfaceView_13 = this.f7286y;
        if (OplusGLSurfaceView_13 == 1) {
            return this.f7251ah;
        }
        if (OplusGLSurfaceView_13 != 2) {
            return 0;
        }
        return (int) (this.f7243a.m7591d() / 2.0f);
    }

    public int getLabelMarginTop() {
        if (this.f7281t) {
            return (int) (this.f7243a.m7591d() / 2.0f);
        }
        return 0;
    }

    public Rect getBackgroundRect() {
        int OplusGLSurfaceView_13 = this.f7286y;
        if (OplusGLSurfaceView_13 == 1 || OplusGLSurfaceView_13 == 2) {
            return getBoxBackground().getBounds();
        }
        return null;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private int m7100i() {
        int OplusGLSurfaceView_13 = this.f7286y;
        if (OplusGLSurfaceView_13 == 1) {
            return getBoxBackground().getBounds().top;
        }
        if (OplusGLSurfaceView_13 == 2) {
            return getBoxBackground().getBounds().top - getLabelMarginTop();
        }
        return getPaddingTop();
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private void m7101j() {
        int OplusGLSurfaceView_13 = this.f7286y;
        if (OplusGLSurfaceView_13 == 1) {
            this.f7223D = 0;
        } else if (OplusGLSurfaceView_13 == 2 && this.f7231L == 0) {
            this.f7231L = this.f7229J.getColorForState(getDrawableState(), this.f7229J.getDefaultColor());
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private void m7102k() {
        int OplusGLSurfaceView_13;
        if (this.f7284w == null) {
            return;
        }
        m7101j();
        int i2 = this.f7223D;
        if (i2 > -1 && (OplusGLSurfaceView_13 = this.f7226G) != 0) {
            this.f7284w.setStroke(i2, OplusGLSurfaceView_13);
        }
        this.f7284w.setCornerRadii(getCornerRadiiAsArray());
        invalidate();
    }

    public void setmHintAnimationEnabled(boolean z) {
        this.f7235P = z;
    }

    public void setIsEllipsisEnabled(boolean z) {
        this.f7257an = z;
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private void m7103l() {
        if (isFocused()) {
            if (this.f7256am) {
                setText(this.f7258ao);
                setSelection(this.f7259ap >= getSelectionEnd() ? getSelectionEnd() : this.f7259ap);
            }
            this.f7256am = false;
            return;
        }
        if (this.f7247ad.measureText(String.valueOf(getText())) <= getWidth() || this.f7256am) {
            return;
        }
        this.f7258ao = String.valueOf(getText());
        this.f7256am = true;
        setText(TextUtils.ellipsize(getText(), this.f7247ad, getWidth(), TextUtils.TruncateAt.END));
        if (this.f7240U) {
            setErrorState(true);
        }
    }

    public void setCouiEditTexttNoEllipsisText(String str) {
        this.f7258ao = str;
        setText(this.f7258ao);
    }

    public String getCouiEditTexttNoEllipsisText() {
        if (this.f7256am) {
            return this.f7258ao;
        }
        return String.valueOf(getText());
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (getMaxLines() < 2 && this.f7257an) {
            m7103l();
        }
        if (getHintTextColors() != this.f7228I) {
            m7114a(false);
        }
        if (Build.VERSION.SDK_INT >= 23) {
            int iSave = canvas.save();
            canvas.translate(getScrollX(), getScrollY());
            if (this.f7281t || getText().length() == 0) {
                if (!this.f7260aq.m7638a()) {
                    this.f7243a.m7578a(canvas);
                } else {
                    this.f7260aq.m7634a(canvas, this.f7243a);
                }
            } else {
                canvas.drawText(" ", 0.0f, 0.0f, this.f7246ac);
            }
            if (this.f7284w != null && this.f7286y == 2) {
                if (getScrollX() != 0) {
                    m7099h();
                }
                if (!this.f7260aq.m7638a()) {
                    this.f7284w.draw(canvas);
                } else {
                    this.f7260aq.m7633a(canvas, this.f7284w, this.f7226G);
                }
            }
            if (this.f7286y == 1) {
                int height = (getHeight() - ((int) ((this.f7225F / 2.0d) + 0.5d))) - (getPaddingBottom() - this.f7252ai > 0 ? getPaddingBottom() - this.f7252ai : 0);
                this.f7242W.setAlpha(this.f7248ae);
                if (!isEnabled()) {
                    float COUIBaseListPopupWindow_12 = height;
                    canvas.drawLine(0.0f, COUIBaseListPopupWindow_12, getWidth(), COUIBaseListPopupWindow_12, this.f7245ab);
                } else if (!this.f7260aq.m7638a()) {
                    float f2 = height;
                    canvas.drawLine(0.0f, f2, getWidth(), f2, this.f7244aa);
                    canvas.drawLine(0.0f, f2, this.f7249af * getWidth(), f2, this.f7242W);
                } else {
                    this.f7260aq.m7632a(canvas, height, getWidth(), (int) (this.f7249af * getWidth()), this.f7244aa, this.f7242W);
                }
            }
            canvas.restoreToCount(iSave);
        }
        super.draw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f7260aq.m7631a(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int OplusGLSurfaceView_13, int i2) {
        super.onMeasure(OplusGLSurfaceView_13, i2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int OplusGLSurfaceView_13, int i2, int i3, int i4) {
        super.onLayout(z, OplusGLSurfaceView_13, i2, i3, i4);
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.f7284w != null) {
                m7099h();
            }
            if (this.f7281t) {
                m7096e();
            }
            int compoundPaddingLeft = getCompoundPaddingLeft();
            int width = getWidth() - getCompoundPaddingRight();
            int iM7100i = m7100i();
            this.f7243a.m7575a(compoundPaddingLeft, getCompoundPaddingTop(), width, getHeight() - getCompoundPaddingBottom());
            this.f7243a.m7587b(compoundPaddingLeft, iM7100i, width, getHeight() - getCompoundPaddingBottom());
            this.f7243a.m7600m();
            if (m7104m() && !this.f7234O) {
                m7105n();
            }
            this.f7260aq.m7640c(this.f7243a);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m7092c(boolean z) {
        ValueAnimator valueAnimator = this.f7236Q;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f7236Q.cancel();
        }
        if (z && this.f7235P) {
            m7081a(1.0f);
        } else {
            this.f7243a.m7585b(1.0f);
        }
        this.f7234O = false;
        if (m7104m()) {
            m7105n();
        }
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private boolean m7104m() {
        return Build.VERSION.SDK_INT >= 23 && this.f7281t && !TextUtils.isEmpty(this.f7282u) && (this.f7284w instanceof COUICutoutDrawable);
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private void m7105n() {
        if (m7104m()) {
            RectF rectF = this.f7227H;
            this.f7243a.m7579a(rectF);
            m7083a(rectF);
            ((COUICutoutDrawable) this.f7284w).m7549a(rectF);
        }
    }

    /* renamed from: o */
    private void m7106o() {
        if (m7104m()) {
            ((COUICutoutDrawable) this.f7284w).m7552c();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7083a(RectF rectF) {
        rectF.left -= this.f7285x;
        rectF.top -= this.f7285x;
        rectF.right += this.f7285x;
        rectF.bottom += this.f7285x;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004f  */
    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void drawableStateChanged() {
        /*
            r4 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 23
            if (r0 >= r1) goto La
            super.drawableStateChanged()
            return
        La:
            boolean r0 = r4.f7239T
            if (r0 == 0) goto Lf
            return
        Lf:
            r0 = 1
            r4.f7239T = r0
            super.drawableStateChanged()
            int[] r1 = r4.getDrawableState()
            boolean r2 = r4.f7281t
            r3 = 0
            if (r2 == 0) goto L30
            boolean r2 = androidx.core.p036h.ViewCompat.m2823A(r4)
            if (r2 == 0) goto L2b
            boolean r2 = r4.isEnabled()
            if (r2 == 0) goto L2b
            goto L2c
        L2b:
            r0 = r3
        L2c:
            r4.m7114a(r0)
            goto L33
        L30:
            r4.m7114a(r3)
        L33:
            r4.m7107p()
            boolean r0 = r4.f7281t
            if (r0 == 0) goto L4f
            r4.m7099h()
            r4.m7108q()
            com.coui.appcompat.widget.IntrinsicsJvm.kt_5$PlatformImplementations.kt_3 r0 = r4.f7243a
            if (r0 == 0) goto L4f
            boolean r0 = r0.m7583a(r1)
            r0 = r0 | r3
            com.coui.appcompat.widget.COUIBaseListPopupWindow_8 r2 = r4.f7260aq
            r2.m7637a(r1)
            goto L50
        L4f:
            r0 = r3
        L50:
            if (r0 == 0) goto L55
            r4.invalidate()
        L55:
            r4.f7239T = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coui.appcompat.widget.COUIEditText.drawableStateChanged():void");
    }

    /* renamed from: p */
    private void m7107p() {
        if (this.f7286y != 1) {
            return;
        }
        if (isEnabled()) {
            if (hasFocus()) {
                if (this.f7241V) {
                    return;
                }
                m7109r();
                return;
            } else {
                if (this.f7241V) {
                    m7110s();
                    return;
                }
                return;
            }
        }
        this.f7249af = 0.0f;
    }

    /* renamed from: q */
    private void m7108q() {
        int OplusGLSurfaceView_13;
        if (this.f7284w == null || (OplusGLSurfaceView_13 = this.f7286y) == 0 || OplusGLSurfaceView_13 != 2) {
            return;
        }
        if (!isEnabled()) {
            this.f7226G = this.f7232M;
        } else if (hasFocus()) {
            this.f7226G = this.f7231L;
        } else {
            this.f7226G = this.f7230K;
        }
        m7102k();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m7095d(boolean z) {
        if (this.f7284w != null) {
            Log.IntrinsicsJvm.kt_5("COUIEditText", "mBoxBackground: " + this.f7284w.getBounds());
        }
        ValueAnimator valueAnimator = this.f7236Q;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f7236Q.cancel();
        }
        if (z && this.f7235P) {
            m7081a(0.0f);
        } else {
            this.f7243a.m7585b(0.0f);
        }
        if (m7104m() && ((COUICutoutDrawable) this.f7284w).m7550a()) {
            m7106o();
        }
        this.f7234O = true;
    }

    /* renamed from: r */
    private void m7109r() {
        if (this.f7237R == null) {
            this.f7237R = new ValueAnimator();
            this.f7237R.setInterpolator(this.f7264c);
            this.f7237R.setDuration(250L);
            this.f7237R.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.COUIEditText.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    COUIEditText.this.f7249af = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    COUIEditText.this.invalidate();
                }
            });
        }
        this.f7248ae = 255;
        this.f7237R.setFloatValues(0.0f, 1.0f);
        this.f7237R.start();
        this.f7241V = true;
    }

    /* renamed from: s */
    private void m7110s() {
        if (this.f7238S == null) {
            this.f7238S = new ValueAnimator();
            this.f7238S.setInterpolator(this.f7264c);
            this.f7238S.setDuration(250L);
            this.f7238S.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.COUIEditText.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    COUIEditText.this.f7248ae = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    COUIEditText.this.invalidate();
                }
            });
        }
        this.f7238S.setIntValues(255, 0);
        this.f7238S.start();
        this.f7241V = false;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m7081a(float COUIBaseListPopupWindow_12) {
        if (this.f7243a.m7597j() == COUIBaseListPopupWindow_12) {
            return;
        }
        if (this.f7236Q == null) {
            this.f7236Q = new ValueAnimator();
            this.f7236Q.setInterpolator(this.f7263b);
            this.f7236Q.setDuration(200L);
            this.f7236Q.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coui.appcompat.widget.COUIEditText.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    COUIEditText.this.f7243a.m7585b(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        this.f7236Q.setFloatValues(this.f7243a.m7597j(), COUIBaseListPopupWindow_12);
        this.f7236Q.start();
    }

    /* renamed from: t */
    private boolean m7111t() {
        return getLayoutDirection() == 1;
    }

    public void setErrorState(boolean z) {
        this.f7240U = z;
        this.f7260aq.m7636a(z);
    }

    public void setEditTextErrorColor(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 != this.f7233N) {
            this.f7233N = OplusGLSurfaceView_13;
            this.f7260aq.m7628a(OplusGLSurfaceView_13);
            invalidate();
        }
    }

    public void setDefaultStrokeColor(int OplusGLSurfaceView_13) {
        if (this.f7230K != OplusGLSurfaceView_13) {
            this.f7230K = OplusGLSurfaceView_13;
            this.f7244aa.setColor(OplusGLSurfaceView_13);
            m7108q();
        }
    }

    public void setDisabledStrokeColor(int OplusGLSurfaceView_13) {
        if (this.f7232M != OplusGLSurfaceView_13) {
            this.f7232M = OplusGLSurfaceView_13;
            this.f7245ab.setColor(OplusGLSurfaceView_13);
            m7108q();
        }
    }

    public void setEditTextDeleteIconNormal(Drawable drawable) {
        if (drawable != null) {
            this.f7266e = drawable;
            this.f7254ak = this.f7266e.getIntrinsicWidth();
            this.f7255al = this.f7266e.getIntrinsicHeight();
            this.f7266e.setBounds(0, 0, this.f7254ak, this.f7255al);
            invalidate();
        }
    }

    public void setEditTextDeleteIconPressed(Drawable drawable) {
        if (drawable != null) {
            this.f7267f = drawable;
            this.f7267f.setBounds(0, 0, this.f7254ak, this.f7255al);
            invalidate();
        }
    }

    /* renamed from: com.coui.appcompat.widget.COUIEditText$IntrinsicsJvm.kt_4 */
    private class C1374b implements TextWatcher {
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int OplusGLSurfaceView_13, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int OplusGLSurfaceView_13, int i2, int i3) {
        }

        private C1374b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            COUIEditText cOUIEditText = COUIEditText.this;
            cOUIEditText.m7089b(cOUIEditText.hasFocus());
        }
    }

    /* renamed from: u */
    private boolean m7112u() {
        return (getGravity() & 7) == 1;
    }

    /* renamed from: com.coui.appcompat.widget.COUIEditText$PlatformImplementations.kt_3 */
    public class ViewOnClickListenerC1373a extends ExploreByTouchHelper implements View.OnClickListener {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private View f7294b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private Context f7295c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        private Rect f7296d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        private Rect f7297e;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }

        public ViewOnClickListenerC1373a(View view) {
            super(view);
            this.f7294b = null;
            this.f7295c = null;
            this.f7296d = null;
            this.f7297e = null;
            this.f7294b = view;
            this.f7295c = this.f7294b.getContext();
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private void m7120a() {
            this.f7296d = new Rect();
            this.f7296d.left = COUIEditText.this.getDeleteButtonLeft();
            this.f7296d.right = COUIEditText.this.getWidth();
            Rect rect = this.f7296d;
            rect.top = 0;
            rect.bottom = COUIEditText.this.getHeight();
        }

        @Override // androidx.customview.p039a.ExploreByTouchHelper
        protected int getVirtualViewAt(float COUIBaseListPopupWindow_12, float f2) {
            if (this.f7296d == null) {
                m7120a();
            }
            return (COUIBaseListPopupWindow_12 < ((float) this.f7296d.left) || COUIBaseListPopupWindow_12 > ((float) this.f7296d.right) || f2 < ((float) this.f7296d.top) || f2 > ((float) this.f7296d.bottom) || !COUIEditText.this.m7115a()) ? Integer.MIN_VALUE : 0;
        }

        @Override // androidx.customview.p039a.ExploreByTouchHelper
        protected void onPopulateEventForVirtualView(int OplusGLSurfaceView_13, AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setContentDescription(COUIEditText.this.f7278q);
        }

        @Override // androidx.customview.p039a.ExploreByTouchHelper
        protected void onPopulateNodeForVirtualView(int OplusGLSurfaceView_13, AccessibilityNodeInfoCompat c0483d) {
            if (OplusGLSurfaceView_13 == 0) {
                c0483d.m2702e(COUIEditText.this.f7278q);
                c0483d.m2690b((CharSequence) Button.class.getName());
                c0483d.m2676a(16);
            }
            c0483d.m2687b(m7119a(OplusGLSurfaceView_13));
        }

        /* renamed from: PlatformImplementations.kt_3 */
        private Rect m7119a(int OplusGLSurfaceView_13) {
            if (OplusGLSurfaceView_13 == 0) {
                if (this.f7296d == null) {
                    m7120a();
                }
                return this.f7296d;
            }
            return new Rect();
        }

        @Override // androidx.customview.p039a.ExploreByTouchHelper
        protected void getVisibleVirtualViews(List<Integer> list) {
            if (COUIEditText.this.m7115a()) {
                list.add(0);
            }
        }

        @Override // androidx.customview.p039a.ExploreByTouchHelper
        protected boolean onPerformActionForVirtualView(int OplusGLSurfaceView_13, int i2, Bundle bundle) {
            if (i2 != 16) {
                return false;
            }
            if (OplusGLSurfaceView_13 != 0 || !COUIEditText.this.m7115a()) {
                return true;
            }
            COUIEditText.this.m7091c();
            return true;
        }
    }
}
