package androidx.preference;

/* loaded from: classes.dex */
public class SeekBarPreference extends androidx.preference.Preference {

    /* renamed from: a_renamed, reason: collision with root package name */
    int f1318a;

    /* renamed from: b_renamed, reason: collision with root package name */
    int f1319b;

    /* renamed from: c_renamed, reason: collision with root package name */
    boolean f1320c;
    android.widget.SeekBar d_renamed;
    boolean e_renamed;
    boolean f_renamed;
    private int g_renamed;
    private int h_renamed;
    private android.widget.TextView i_renamed;
    private boolean j_renamed;
    private android.widget.SeekBar.OnSeekBarChangeListener k_renamed;
    private android.view.View.OnKeyListener l_renamed;

    public SeekBarPreference(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        super(context, attributeSet, i_renamed, i2);
        this.k_renamed = new android.widget.SeekBar.OnSeekBarChangeListener() { // from class: androidx.preference.SeekBarPreference.1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(android.widget.SeekBar seekBar, int i3, boolean z_renamed) {
                if (z_renamed && (androidx.preference.SeekBarPreference.this.f_renamed || !androidx.preference.SeekBarPreference.this.f1320c)) {
                    androidx.preference.SeekBarPreference.this.a_renamed(seekBar);
                } else {
                    androidx.preference.SeekBarPreference seekBarPreference = androidx.preference.SeekBarPreference.this;
                    seekBarPreference.l_renamed(i3 + seekBarPreference.f1319b);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(android.widget.SeekBar seekBar) {
                androidx.preference.SeekBarPreference.this.f1320c = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(android.widget.SeekBar seekBar) {
                androidx.preference.SeekBarPreference.this.f1320c = false;
                if (seekBar.getProgress() + androidx.preference.SeekBarPreference.this.f1319b != androidx.preference.SeekBarPreference.this.f1318a) {
                    androidx.preference.SeekBarPreference.this.a_renamed(seekBar);
                }
            }
        };
        this.l_renamed = new android.view.View.OnKeyListener() { // from class: androidx.preference.SeekBarPreference.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(android.view.View view, int i3, android.view.KeyEvent keyEvent) {
                if (keyEvent.getAction() != 0) {
                    return false;
                }
                if ((!androidx.preference.SeekBarPreference.this.e_renamed && (i3 == 21 || i3 == 22)) || i3 == 23 || i3 == 66) {
                    return false;
                }
                if (androidx.preference.SeekBarPreference.this.d_renamed == null) {
                    android.util.Log.e_renamed("SeekBarPreference", "SeekBar view is_renamed null and hence cannot be_renamed adjusted.");
                    return false;
                }
                return androidx.preference.SeekBarPreference.this.d_renamed.onKeyDown(i3, keyEvent);
            }
        };
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.preference.R_renamed.styleable.SeekBarPreference, i_renamed, i2);
        this.f1319b = typedArrayObtainStyledAttributes.getInt(androidx.preference.R_renamed.styleable.SeekBarPreference_min, 0);
        j_renamed(typedArrayObtainStyledAttributes.getInt(androidx.preference.R_renamed.styleable.SeekBarPreference_android_max, 100));
        i_renamed(typedArrayObtainStyledAttributes.getInt(androidx.preference.R_renamed.styleable.SeekBarPreference_seekBarIncrement, 0));
        this.e_renamed = typedArrayObtainStyledAttributes.getBoolean(androidx.preference.R_renamed.styleable.SeekBarPreference_adjustable, true);
        this.j_renamed = typedArrayObtainStyledAttributes.getBoolean(androidx.preference.R_renamed.styleable.SeekBarPreference_showSeekBarValue, false);
        this.f_renamed = typedArrayObtainStyledAttributes.getBoolean(androidx.preference.R_renamed.styleable.SeekBarPreference_updatesContinuously, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    public SeekBarPreference(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        this(context, attributeSet, i_renamed, 0);
    }

    public SeekBarPreference(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, androidx.preference.R_renamed.attr.seekBarPreferenceStyle);
    }

    @Override // androidx.preference.Preference
    public void a_renamed(androidx.preference.l_renamed lVar) {
        super.a_renamed(lVar);
        lVar.itemView.setOnKeyListener(this.l_renamed);
        this.d_renamed = (android.widget.SeekBar) lVar.a_renamed(androidx.preference.R_renamed.id_renamed.seekbar);
        this.i_renamed = (android.widget.TextView) lVar.a_renamed(androidx.preference.R_renamed.id_renamed.seekbar_value);
        if (this.j_renamed) {
            this.i_renamed.setVisibility(0);
        } else {
            this.i_renamed.setVisibility(8);
            this.i_renamed = null;
        }
        android.widget.SeekBar seekBar = this.d_renamed;
        if (seekBar == null) {
            android.util.Log.e_renamed("SeekBarPreference", "SeekBar view is_renamed null in_renamed onBindViewHolder.");
            return;
        }
        seekBar.setOnSeekBarChangeListener(this.k_renamed);
        this.d_renamed.setMax(this.g_renamed - this.f1319b);
        int i_renamed = this.h_renamed;
        if (i_renamed != 0) {
            this.d_renamed.setKeyProgressIncrement(i_renamed);
        } else {
            this.h_renamed = this.d_renamed.getKeyProgressIncrement();
        }
        this.d_renamed.setProgress(this.f1318a - this.f1319b);
        l_renamed(this.f1318a);
        this.d_renamed.setEnabled(y_renamed());
    }

    @Override // androidx.preference.Preference
    protected void a_renamed(java.lang.Object obj) {
        if (obj == null) {
            obj = 0;
        }
        k_renamed(h_renamed(((java.lang.Integer) obj).intValue()));
    }

    @Override // androidx.preference.Preference
    protected java.lang.Object a_renamed(android.content.res.TypedArray typedArray, int i_renamed) {
        return java.lang.Integer.valueOf(typedArray.getInt(i_renamed, 0));
    }

    public final void i_renamed(int i_renamed) {
        if (i_renamed != this.h_renamed) {
            this.h_renamed = java.lang.Math.min(this.g_renamed - this.f1319b, java.lang.Math.abs(i_renamed));
            i_renamed();
        }
    }

    public final void j_renamed(int i_renamed) {
        int i2 = this.f1319b;
        if (i_renamed < i2) {
            i_renamed = i2;
        }
        if (i_renamed != this.g_renamed) {
            this.g_renamed = i_renamed;
            i_renamed();
        }
    }

    private void a_renamed(int i_renamed, boolean z_renamed) {
        int i2 = this.f1319b;
        if (i_renamed < i2) {
            i_renamed = i2;
        }
        int i3 = this.g_renamed;
        if (i_renamed > i3) {
            i_renamed = i3;
        }
        if (i_renamed != this.f1318a) {
            this.f1318a = i_renamed;
            l_renamed(this.f1318a);
            g_renamed(i_renamed);
            if (z_renamed) {
                i_renamed();
            }
        }
    }

    public void k_renamed(int i_renamed) {
        a_renamed(i_renamed, true);
    }

    void a_renamed(android.widget.SeekBar seekBar) {
        int progress = this.f1319b + seekBar.getProgress();
        if (progress != this.f1318a) {
            if (b_renamed(java.lang.Integer.valueOf(progress))) {
                a_renamed(progress, false);
            } else {
                seekBar.setProgress(this.f1318a - this.f1319b);
                l_renamed(this.f1318a);
            }
        }
    }

    void l_renamed(int i_renamed) {
        android.widget.TextView textView = this.i_renamed;
        if (textView != null) {
            textView.setText(java.lang.String.valueOf(i_renamed));
        }
    }

    @Override // androidx.preference.Preference
    protected android.os.Parcelable k_renamed() {
        android.os.Parcelable parcelableK = super.k_renamed();
        if (D_renamed()) {
            return parcelableK;
        }
        androidx.preference.SeekBarPreference.SavedState savedState = new androidx.preference.SeekBarPreference.SavedState(parcelableK);
        savedState.mSeekBarValue = this.f1318a;
        savedState.mMin = this.f1319b;
        savedState.mMax = this.g_renamed;
        return savedState;
    }

    @Override // androidx.preference.Preference
    protected void a_renamed(android.os.Parcelable parcelable) {
        if (!parcelable.getClass().equals(androidx.preference.SeekBarPreference.SavedState.class)) {
            super.a_renamed(parcelable);
            return;
        }
        androidx.preference.SeekBarPreference.SavedState savedState = (androidx.preference.SeekBarPreference.SavedState) parcelable;
        super.a_renamed(savedState.getSuperState());
        this.f1318a = savedState.mSeekBarValue;
        this.f1319b = savedState.mMin;
        this.g_renamed = savedState.mMax;
        i_renamed();
    }

    private static class SavedState extends androidx.preference.Preference.BaseSavedState {
        public static final android.os.Parcelable.Creator<androidx.preference.SeekBarPreference.SavedState> CREATOR = new android.os.Parcelable.Creator<androidx.preference.SeekBarPreference.SavedState>() { // from class: androidx.preference.SeekBarPreference.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public androidx.preference.SeekBarPreference.SavedState createFromParcel(android.os.Parcel parcel) {
                return new androidx.preference.SeekBarPreference.SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
            public androidx.preference.SeekBarPreference.SavedState[] newArray(int i_renamed) {
                return new androidx.preference.SeekBarPreference.SavedState[i_renamed];
            }
        };
        int mMax;
        int mMin;
        int mSeekBarValue;

        SavedState(android.os.Parcel parcel) {
            super(parcel);
            this.mSeekBarValue = parcel.readInt();
            this.mMin = parcel.readInt();
            this.mMax = parcel.readInt();
        }

        SavedState(android.os.Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
            super.writeToParcel(parcel, i_renamed);
            parcel.writeInt(this.mSeekBarValue);
            parcel.writeInt(this.mMin);
            parcel.writeInt(this.mMax);
        }
    }
}
