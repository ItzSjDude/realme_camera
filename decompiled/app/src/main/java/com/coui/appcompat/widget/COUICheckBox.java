package com.coui.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewDebug;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.widget.ViewUtils_2;
import androidx.appcompat.widget.AppCompatButton;
import com.coui.appcompat.p099a.COUIDarkModeUtil;
import coui.support.appcompat.R;

/* loaded from: classes.dex */
public class COUICheckBox extends AppCompatButton {

    /* renamed from: COUIBaseListPopupWindow_11 */
    private static final int[] f7161g = {R.attr.coui_state_allSelect};

    /* renamed from: COUIBaseListPopupWindow_10 */
    private static final int[] f7162h = {R.attr.coui_state_partSelect};

    /* renamed from: PlatformImplementations.kt_3 */
    private int f7163a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private int f7164b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f7165c;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Drawable f7166e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private InterfaceC1358a f7167f;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f7168i;

    /* renamed from: com.coui.appcompat.widget.COUICheckBox$PlatformImplementations.kt_3 */
    public interface InterfaceC1358a {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo7029a(COUICheckBox cOUICheckBox, int OplusGLSurfaceView_13);
    }

    public COUICheckBox(Context context) {
        this(context, null);
    }

    public COUICheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.couiCheckBoxStyle);
    }

    public COUICheckBox(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        if (attributeSet != null && attributeSet.getStyleAttribute() != 0) {
            this.f7168i = attributeSet.getStyleAttribute();
        } else {
            this.f7168i = OplusGLSurfaceView_13;
        }
        COUIDarkModeUtil.m6400a(this, false);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.COUICheckBox, OplusGLSurfaceView_13, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.COUICheckBox_couiButton);
        if (drawable != null) {
            setButtonDrawable(drawable);
        }
        setState(typedArrayObtainStyledAttributes.getInteger(R.styleable.COUICheckBox_couiCheckBoxState, 0));
        typedArrayObtainStyledAttributes.recycle();
        if (attributeSet != null) {
            this.f7168i = attributeSet.getStyleAttribute();
            if (this.f7168i == 0) {
                this.f7168i = OplusGLSurfaceView_13;
                return;
            }
            return;
        }
        this.f7168i = OplusGLSurfaceView_13;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m7026a() {
        setState(this.f7163a >= 2 ? 0 : 2);
    }

    @Override // android.view.View
    public boolean performClick() {
        m7026a();
        return super.performClick();
    }

    @ViewDebug.ExportedProperty
    public int getState() {
        return this.f7163a;
    }

    public void setState(int OplusGLSurfaceView_13) {
        if (this.f7163a != OplusGLSurfaceView_13) {
            this.f7163a = OplusGLSurfaceView_13;
            refreshDrawableState();
            if (this.f7165c) {
                return;
            }
            this.f7165c = true;
            InterfaceC1358a interfaceC1358a = this.f7167f;
            if (interfaceC1358a != null) {
                interfaceC1358a.mo7029a(this, this.f7163a);
            }
            this.f7165c = false;
        }
    }

    public void setOnStateChangeListener(InterfaceC1358a interfaceC1358a) {
        this.f7167f = interfaceC1358a;
    }

    public void setButtonDrawable(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 == 0 || OplusGLSurfaceView_13 != this.f7164b) {
            this.f7164b = OplusGLSurfaceView_13;
            setButtonDrawable(this.f7164b != 0 ? getResources().getDrawable(this.f7164b) : null);
        }
    }

    public void setButtonDrawable(Drawable drawable) {
        if (drawable != null) {
            Drawable drawable2 = this.f7166e;
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.f7166e);
            }
            drawable.setCallback(this);
            drawable.setState(getDrawableState());
            drawable.setVisible(getVisibility() == 0, false);
            this.f7166e = drawable;
            this.f7166e.setState(null);
            setMinHeight(this.f7166e.getIntrinsicHeight());
        }
        refreshDrawableState();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(COUICheckBox.class.getName());
        if (this.f7163a == 2) {
            accessibilityEvent.setChecked(true);
        } else {
            accessibilityEvent.setChecked(false);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(COUICheckBox.class.getName());
        accessibilityNodeInfo.setCheckable(true);
        if (this.f7163a == 2) {
            accessibilityNodeInfo.setChecked(true);
        } else {
            accessibilityNodeInfo.setChecked(false);
        }
    }

    @Override // android.widget.TextView
    public int getCompoundPaddingLeft() {
        Drawable drawable;
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return (ViewUtils_2.m1623a(this) || (drawable = this.f7166e) == null) ? compoundPaddingLeft : compoundPaddingLeft + drawable.getIntrinsicWidth();
    }

    @Override // android.widget.TextView
    public int getCompoundPaddingRight() {
        Drawable drawable;
        int compoundPaddingRight = super.getCompoundPaddingRight();
        return (!ViewUtils_2.m1623a(this) || (drawable = this.f7166e) == null) ? compoundPaddingRight : compoundPaddingRight + drawable.getIntrinsicWidth();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        int height;
        super.onDraw(canvas);
        Drawable drawable = this.f7166e;
        if (drawable != null) {
            int gravity = getGravity() & 112;
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (gravity != 16) {
                height = gravity != 80 ? 0 : getHeight() - intrinsicHeight;
            } else {
                height = (getHeight() - intrinsicHeight) / 2;
            }
            int OplusGLSurfaceView_13 = intrinsicHeight + height;
            int width = ViewUtils_2.m1623a(this) ? getWidth() - intrinsicWidth : 0;
            if (ViewUtils_2.m1623a(this)) {
                intrinsicWidth = getWidth();
            }
            drawable.setBounds(width, height, intrinsicWidth, OplusGLSurfaceView_13);
            drawable.draw(canvas);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int OplusGLSurfaceView_13) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(OplusGLSurfaceView_13 + 1);
        if (getState() == 1) {
            mergeDrawableStates(iArrOnCreateDrawableState, f7162h);
        }
        if (getState() == 2) {
            mergeDrawableStates(iArrOnCreateDrawableState, f7161g);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f7166e != null) {
            this.f7166e.setState(getDrawableState());
            invalidate();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f7166e;
    }

    @Override // android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f7166e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.coui.appcompat.widget.COUICheckBox.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int OplusGLSurfaceView_13) {
                return new SavedState[OplusGLSurfaceView_13];
            }
        };
        int state;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.state = ((Integer) parcel.readValue(null)).intValue();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            super.writeToParcel(parcel, OplusGLSurfaceView_13);
            parcel.writeValue(Integer.valueOf(this.state));
        }

        public String toString() {
            return "CompoundButton.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " state=" + this.state + "}";
        }
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        setFreezesText(true);
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.state = getState();
        return savedState;
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setState(savedState.state);
        requestLayout();
    }
}
