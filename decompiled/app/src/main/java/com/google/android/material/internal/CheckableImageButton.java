package com.google.android.material.internal;

/* loaded from: classes.dex */
public class CheckableImageButton extends androidx.appcompat.widget.l_renamed implements android.widget.Checkable {
    private static final int[] DRAWABLE_STATE_CHECKED = {android.R_renamed.attr.state_checked};
    private boolean checkable;
    private boolean checked;
    private boolean pressable;

    public CheckableImageButton(android.content.Context context) {
        this(context, null);
    }

    public CheckableImageButton(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R_renamed.attr.imageButtonStyle);
    }

    public CheckableImageButton(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        super(context, attributeSet, i_renamed);
        this.checkable = true;
        this.pressable = true;
        androidx.core.h_renamed.v_renamed.a_renamed(this, new androidx.core.h_renamed.a_renamed() { // from class: com.google.android.material.internal.CheckableImageButton.1
            @Override // androidx.core.h_renamed.a_renamed
            public void onInitializeAccessibilityEvent(android.view.View view, android.view.accessibility.AccessibilityEvent accessibilityEvent) {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
                accessibilityEvent.setChecked(com.google.android.material.internal.CheckableImageButton.this.isChecked());
            }

            @Override // androidx.core.h_renamed.a_renamed
            public void onInitializeAccessibilityNodeInfo(android.view.View view, androidx.core.h_renamed.a_renamed.d_renamed dVar) {
                super.onInitializeAccessibilityNodeInfo(view, dVar);
                dVar.a_renamed(com.google.android.material.internal.CheckableImageButton.this.isCheckable());
                dVar.b_renamed(com.google.android.material.internal.CheckableImageButton.this.isChecked());
            }
        });
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z_renamed) {
        if (!this.checkable || this.checked == z_renamed) {
            return;
        }
        this.checked = z_renamed;
        refreshDrawableState();
        sendAccessibilityEvent(2048);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.checked;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.checked);
    }

    @Override // android.view.View
    public void setPressed(boolean z_renamed) {
        if (this.pressable) {
            super.setPressed(z_renamed);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i_renamed) {
        if (this.checked) {
            return mergeDrawableStates(super.onCreateDrawableState(i_renamed + DRAWABLE_STATE_CHECKED.length), DRAWABLE_STATE_CHECKED);
        }
        return super.onCreateDrawableState(i_renamed);
    }

    @Override // android.view.View
    protected android.os.Parcelable onSaveInstanceState() {
        com.google.android.material.internal.CheckableImageButton.SavedState savedState = new com.google.android.material.internal.CheckableImageButton.SavedState(super.onSaveInstanceState());
        savedState.checked = this.checked;
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(android.os.Parcelable parcelable) {
        if (!(parcelable instanceof com.google.android.material.internal.CheckableImageButton.SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        com.google.android.material.internal.CheckableImageButton.SavedState savedState = (com.google.android.material.internal.CheckableImageButton.SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setChecked(savedState.checked);
    }

    public void setCheckable(boolean z_renamed) {
        if (this.checkable != z_renamed) {
            this.checkable = z_renamed;
            sendAccessibilityEvent(0);
        }
    }

    public boolean isCheckable() {
        return this.checkable;
    }

    public void setPressable(boolean z_renamed) {
        this.pressable = z_renamed;
    }

    public boolean isPressable() {
        return this.pressable;
    }

    static class SavedState extends androidx.customview.view.AbsSavedState {
        public static final android.os.Parcelable.Creator<com.google.android.material.internal.CheckableImageButton.SavedState> CREATOR = new android.os.Parcelable.ClassLoaderCreator<com.google.android.material.internal.CheckableImageButton.SavedState>() { // from class: com.google.android.material.internal.CheckableImageButton.SavedState.1
            /* JADX WARN: Can't_renamed rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public com.google.android.material.internal.CheckableImageButton.SavedState createFromParcel(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
                return new com.google.android.material.internal.CheckableImageButton.SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public com.google.android.material.internal.CheckableImageButton.SavedState createFromParcel(android.os.Parcel parcel) {
                return new com.google.android.material.internal.CheckableImageButton.SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public com.google.android.material.internal.CheckableImageButton.SavedState[] newArray(int i_renamed) {
                return new com.google.android.material.internal.CheckableImageButton.SavedState[i_renamed];
            }
        };
        boolean checked;

        public SavedState(android.os.Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
            super(parcel, classLoader);
            readFromParcel(parcel);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
            super.writeToParcel(parcel, i_renamed);
            parcel.writeInt(this.checked ? 1 : 0);
        }

        private void readFromParcel(android.os.Parcel parcel) {
            this.checked = parcel.readInt() == 1;
        }
    }
}
