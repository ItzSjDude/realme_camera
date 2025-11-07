package com.coui.appcompat.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.preference.Preference;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import androidx.preference.PreferenceViewHolder;
import com.coui.appcompat.widget.COUIScrolledEditText;
import com.coui.appcompat.widget.COUIEditText;
import coui.support.appcompat.R;

/* loaded from: classes.dex */
public class COUIInputPreference extends COUIPreference {

    /* renamed from: PlatformImplementations.kt_3 */
    private COUIEditText f6909a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private CharSequence f6910b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private CharSequence f6911c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private Context f6912d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private View f6913e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f6914f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f6915g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f6916h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f6917i;

    /* renamed from: OplusGLSurfaceView_15 */
    private int f6918j;

    /* renamed from: OplusGLSurfaceView_5 */
    private int f6919k;

    public COUIInputPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.couiInputPreferenceStyle);
    }

    public COUIInputPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        this(context, attributeSet, OplusGLSurfaceView_13, 0);
    }

    public COUIInputPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13);
        this.f6912d = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.COUIInputPreference, OplusGLSurfaceView_13, 0);
        this.f6910b = typedArrayObtainStyledAttributes.getText(R.styleable.COUIInputPreference_couiContent);
        this.f6911c = typedArrayObtainStyledAttributes.getText(R.styleable.COUIInputPreference_couiHint);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.Preference, OplusGLSurfaceView_13, 0);
        this.f6914f = typedArrayObtainStyledAttributes2.getText(R.styleable.Preference_android_title) != null;
        typedArrayObtainStyledAttributes2.recycle();
        this.f6915g = context.getResources().getDimensionPixelSize(R.dimen.coui_input_edit_text_has_title_padding_top);
        this.f6916h = context.getResources().getDimensionPixelSize(R.dimen.coui_input_edit_text_has_title_padding_bottom);
        this.f6917i = context.getResources().getDimensionPixelSize(R.dimen.coui_input_edit_text_no_title_padding_top);
        this.f6918j = context.getResources().getDimensionPixelOffset(R.dimen.coui_input_edit_text_no_title_padding_bottom);
        this.f6919k = context.getResources().getDimensionPixelOffset(R.dimen.coui_input_preference_padding_end);
        this.f6909a = new COUIScrolledEditText(context, attributeSet, R.attr.couiInputPreferenceEditTextStyle);
        this.f6909a.setId(android.R.id_renamed.input);
        this.f6909a.setMaxLines(5);
        this.f6909a.setFastDeletable(true);
        this.f6909a.setVerticalScrollBarEnabled(false);
        this.f6909a.setLineSpacing(0.0f, 1.1f);
        this.f6909a.setGravity(8388627);
        this.f6909a.setTextSize(0, this.f6912d.getResources().getDimensionPixelSize(R.dimen.coui_input_preference_text_size));
        if (this.f6914f) {
            this.f6909a.setPaddingRelative(0, this.f6915g, 0, this.f6916h);
        } else {
            this.f6909a.setPaddingRelative(0, this.f6917i, 0, this.f6918j);
            this.f6909a.setBoxBackgroundMode(0);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m6897c(CharSequence charSequence) {
        COUIEditText cOUIEditText = this.f6909a;
        if (cOUIEditText != null) {
            cOUIEditText.setText(charSequence);
            this.f6910b = charSequence;
            return;
        }
        if (!TextUtils.equals(this.f6910b, charSequence)) {
            mo3748i();
        }
        boolean zMo3754j = mo3754j();
        this.f6910b = charSequence;
        if (charSequence != null) {
            m3842d(charSequence.toString());
        }
        boolean zMo3754j2 = mo3754j();
        if (zMo3754j2 != zMo3754j) {
            mo3830b(zMo3754j2);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public CharSequence m6896b() {
        return this.f6911c;
    }

    @Override // androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    protected Object mo3749a(TypedArray typedArray, int OplusGLSurfaceView_13) {
        return typedArray.getString(OplusGLSurfaceView_13);
    }

    @Override // androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo3825a(boolean z, Object obj) {
        if (TextUtils.isEmpty(this.f6910b)) {
            return;
        }
        m6897c((CharSequence) (z ? m3844e(this.f6910b.toString()) : (String) obj));
    }

    @Override // androidx.preference.Preference
    /* renamed from: OplusGLSurfaceView_15 */
    public boolean mo3754j() {
        return TextUtils.isEmpty(this.f6910b) || super.mo3754j();
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3736a(PreferenceViewHolder c0668l) {
        super.mo3736a(c0668l);
        this.f6913e = c0668l.m4007a(R.id_renamed.coui_preference);
        ViewGroup viewGroup = (ViewGroup) this.f6913e.findViewById(R.id_renamed.edittext_container);
        if (viewGroup != null) {
            if (!this.f6909a.equals((EditText) viewGroup.findViewById(android.R.id_renamed.input))) {
                ViewParent parent = this.f6909a.getParent();
                if (parent != null) {
                    ((ViewGroup) parent).removeView(this.f6909a);
                }
                viewGroup.removeAllViews();
                viewGroup.addView(this.f6909a, -1, -2);
            }
        }
        CharSequence charSequenceM6896b = m6896b();
        if (!TextUtils.isEmpty(charSequenceM6896b)) {
            this.f6909a.setTopHint(charSequenceM6896b);
        }
        this.f6909a.setEnabled(mo3857y());
    }

    @Override // androidx.preference.Preference
    /* renamed from: OplusGLSurfaceView_5 */
    protected Parcelable mo3755k() {
        Parcelable parcelableK = super.mo3755k();
        if (m3793D()) {
            return parcelableK;
        }
        SavedState savedState = new SavedState(parcelableK);
        CharSequence charSequence = this.f6910b;
        if (charSequence != null) {
            savedState.mText = charSequence.toString();
        }
        return savedState;
    }

    @Override // androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo3750a(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.mo3750a(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.mo3750a(savedState.getSuperState());
        m6897c((CharSequence) savedState.mText);
    }

    private static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.coui.appcompat.preference.COUIInputPreference.SavedState.1
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
        String mText;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.mText = parcel.readString();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            super.writeToParcel(parcel, OplusGLSurfaceView_13);
            parcel.writeString(this.mText);
        }
    }
}
