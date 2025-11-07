package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.preference.Preference;

/* loaded from: classes.dex */
public class SeekBarPreference extends Preference {

    /* renamed from: PlatformImplementations.kt_3 */
    int f3836a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    int f3837b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    boolean f3838c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    SeekBar f3839d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    boolean f3840e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    boolean f3841f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f3842g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int f3843h;

    /* renamed from: OplusGLSurfaceView_13 */
    private TextView f3844i;

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f3845j;

    /* renamed from: OplusGLSurfaceView_5 */
    private SeekBar.OnSeekBarChangeListener f3846k;

    /* renamed from: OplusGLSurfaceView_14 */
    private View.OnKeyListener f3847l;

    public SeekBarPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13, i2);
        this.f3846k = new SeekBar.OnSeekBarChangeListener() { // from class: androidx.preference.SeekBarPreference.1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i3, boolean z) {
                if (z && (SeekBarPreference.this.f3841f || !SeekBarPreference.this.f3838c)) {
                    SeekBarPreference.this.m3884a(seekBar);
                } else {
                    SeekBarPreference seekBarPreference = SeekBarPreference.this;
                    seekBarPreference.m3888l(i3 + seekBarPreference.f3837b);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                SeekBarPreference.this.f3838c = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                SeekBarPreference.this.f3838c = false;
                if (seekBar.getProgress() + SeekBarPreference.this.f3837b != SeekBarPreference.this.f3836a) {
                    SeekBarPreference.this.m3884a(seekBar);
                }
            }
        };
        this.f3847l = new View.OnKeyListener() { // from class: androidx.preference.SeekBarPreference.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i3, KeyEvent keyEvent) {
                if (keyEvent.getAction() != 0) {
                    return false;
                }
                if ((!SeekBarPreference.this.f3840e && (i3 == 21 || i3 == 22)) || i3 == 23 || i3 == 66) {
                    return false;
                }
                if (SeekBarPreference.this.f3839d == null) {
                    Log.COUIBaseListPopupWindow_8("SeekBarPreference", "SeekBar view is null and hence cannot be adjusted.");
                    return false;
                }
                return SeekBarPreference.this.f3839d.onKeyDown(i3, keyEvent);
            }
        };
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SeekBarPreference, OplusGLSurfaceView_13, i2);
        this.f3837b = typedArrayObtainStyledAttributes.getInt(R.styleable.SeekBarPreference_min, 0);
        m3886j(typedArrayObtainStyledAttributes.getInt(R.styleable.SeekBarPreference_android_max, 100));
        m3885i(typedArrayObtainStyledAttributes.getInt(R.styleable.SeekBarPreference_seekBarIncrement, 0));
        this.f3840e = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SeekBarPreference_adjustable, true);
        this.f3845j = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SeekBarPreference_showSeekBarValue, false);
        this.f3841f = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SeekBarPreference_updatesContinuously, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        this(context, attributeSet, OplusGLSurfaceView_13, 0);
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.seekBarPreferenceStyle);
    }

    @Override // androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3736a(PreferenceViewHolder c0668l) {
        super.mo3736a(c0668l);
        c0668l.itemView.setOnKeyListener(this.f3847l);
        this.f3839d = (SeekBar) c0668l.m4007a(R.id_renamed.seekbar);
        this.f3844i = (TextView) c0668l.m4007a(R.id_renamed.seekbar_value);
        if (this.f3845j) {
            this.f3844i.setVisibility(0);
        } else {
            this.f3844i.setVisibility(8);
            this.f3844i = null;
        }
        SeekBar seekBar = this.f3839d;
        if (seekBar == null) {
            Log.COUIBaseListPopupWindow_8("SeekBarPreference", "SeekBar view is null in onBindViewHolder.");
            return;
        }
        seekBar.setOnSeekBarChangeListener(this.f3846k);
        this.f3839d.setMax(this.f3842g - this.f3837b);
        int OplusGLSurfaceView_13 = this.f3843h;
        if (OplusGLSurfaceView_13 != 0) {
            this.f3839d.setKeyProgressIncrement(OplusGLSurfaceView_13);
        } else {
            this.f3843h = this.f3839d.getKeyProgressIncrement();
        }
        this.f3839d.setProgress(this.f3836a - this.f3837b);
        m3888l(this.f3836a);
        this.f3839d.setEnabled(mo3857y());
    }

    @Override // androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo3751a(Object obj) {
        if (obj == null) {
            obj = 0;
        }
        m3887k(m3848h(((Integer) obj).intValue()));
    }

    @Override // androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    protected Object mo3749a(TypedArray typedArray, int OplusGLSurfaceView_13) {
        return Integer.valueOf(typedArray.getInt(OplusGLSurfaceView_13, 0));
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public final void m3885i(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 != this.f3843h) {
            this.f3843h = Math.min(this.f3842g - this.f3837b, Math.abs(OplusGLSurfaceView_13));
            mo3748i();
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public final void m3886j(int OplusGLSurfaceView_13) {
        int i2 = this.f3837b;
        if (OplusGLSurfaceView_13 < i2) {
            OplusGLSurfaceView_13 = i2;
        }
        if (OplusGLSurfaceView_13 != this.f3842g) {
            this.f3842g = OplusGLSurfaceView_13;
            mo3748i();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m3883a(int OplusGLSurfaceView_13, boolean z) {
        int i2 = this.f3837b;
        if (OplusGLSurfaceView_13 < i2) {
            OplusGLSurfaceView_13 = i2;
        }
        int i3 = this.f3842g;
        if (OplusGLSurfaceView_13 > i3) {
            OplusGLSurfaceView_13 = i3;
        }
        if (OplusGLSurfaceView_13 != this.f3836a) {
            this.f3836a = OplusGLSurfaceView_13;
            m3888l(this.f3836a);
            m3847g(OplusGLSurfaceView_13);
            if (z) {
                mo3748i();
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public void m3887k(int OplusGLSurfaceView_13) {
        m3883a(OplusGLSurfaceView_13, true);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m3884a(SeekBar seekBar) {
        int progress = this.f3837b + seekBar.getProgress();
        if (progress != this.f3836a) {
            if (m3831b(Integer.valueOf(progress))) {
                m3883a(progress, false);
            } else {
                seekBar.setProgress(this.f3836a - this.f3837b);
                m3888l(this.f3836a);
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_14 */
    void m3888l(int OplusGLSurfaceView_13) {
        TextView textView = this.f3844i;
        if (textView != null) {
            textView.setText(String.valueOf(OplusGLSurfaceView_13));
        }
    }

    @Override // androidx.preference.Preference
    /* renamed from: OplusGLSurfaceView_5 */
    protected Parcelable mo3755k() {
        Parcelable parcelableMo3755k = super.mo3755k();
        if (m3793D()) {
            return parcelableMo3755k;
        }
        SavedState savedState = new SavedState(parcelableMo3755k);
        savedState.mSeekBarValue = this.f3836a;
        savedState.mMin = this.f3837b;
        savedState.mMax = this.f3842g;
        return savedState;
    }

    @Override // androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo3750a(Parcelable parcelable) {
        if (!parcelable.getClass().equals(SavedState.class)) {
            super.mo3750a(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.mo3750a(savedState.getSuperState());
        this.f3836a = savedState.mSeekBarValue;
        this.f3837b = savedState.mMin;
        this.f3842g = savedState.mMax;
        mo3748i();
    }

    private static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.preference.SeekBarPreference.SavedState.1
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
        int mMax;
        int mMin;
        int mSeekBarValue;

        SavedState(Parcel parcel) {
            super(parcel);
            this.mSeekBarValue = parcel.readInt();
            this.mMin = parcel.readInt();
            this.mMax = parcel.readInt();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int OplusGLSurfaceView_13) {
            super.writeToParcel(parcel, OplusGLSurfaceView_13);
            parcel.writeInt(this.mSeekBarValue);
            parcel.writeInt(this.mMin);
            parcel.writeInt(this.mMax);
        }
    }
}
