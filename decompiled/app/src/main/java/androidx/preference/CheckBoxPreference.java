package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.core.p027a.p028a.TypedArrayUtils;

/* loaded from: classes.dex */
public class CheckBoxPreference extends TwoStatePreference {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final C0632a f3707b;

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        this(context, attributeSet, OplusGLSurfaceView_13, 0);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13, i2);
        this.f3707b = new C0632a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CheckBoxPreference, OplusGLSurfaceView_13, i2);
        m3902e((CharSequence) TypedArrayUtils.m2321b(typedArrayObtainStyledAttributes, R.styleable.CheckBoxPreference_summaryOn, R.styleable.CheckBoxPreference_android_summaryOn));
        m3904f(TypedArrayUtils.m2321b(typedArrayObtainStyledAttributes, R.styleable.CheckBoxPreference_summaryOff, R.styleable.CheckBoxPreference_android_summaryOff));
        m3905f(TypedArrayUtils.m2315a(typedArrayObtainStyledAttributes, R.styleable.CheckBoxPreference_disableDependentsState, R.styleable.CheckBoxPreference_android_disableDependentsState, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.m2306a(context, R.attr.checkBoxPreferenceStyle, android.R.attr.checkBoxPreferenceStyle));
    }

    public CheckBoxPreference(Context context) {
        this(context, null);
    }

    @Override // androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3736a(PreferenceViewHolder c0668l) {
        super.mo3736a(c0668l);
        m3734d(c0668l.m4007a(android.R.id_renamed.checkbox));
        m3900b(c0668l);
    }

    @Override // androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo3735a(View view) {
        super.mo3735a(view);
        m3733c(view);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m3733c(View view) {
        if (((AccessibilityManager) m3800K().getSystemService("accessibility")).isEnabled()) {
            m3734d(view.findViewById(android.R.id_renamed.checkbox));
            m3899b(view.findViewById(android.R.id_renamed.summary));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m3734d(View view) {
        boolean z = view instanceof CompoundButton;
        if (z) {
            ((CompoundButton) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f3858a);
        }
        if (z) {
            ((CompoundButton) view).setOnCheckedChangeListener(this.f3707b);
        }
    }

    /* renamed from: androidx.preference.CheckBoxPreference$PlatformImplementations.kt_3 */
    private class C0632a implements CompoundButton.OnCheckedChangeListener {
        C0632a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!CheckBoxPreference.this.m3831b(Boolean.valueOf(z))) {
                compoundButton.setChecked(!z);
            } else {
                CheckBoxPreference.this.m3903e(z);
            }
        }
    }
}
