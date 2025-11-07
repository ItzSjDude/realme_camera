package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.Switch;
import androidx.core.p027a.p028a.TypedArrayUtils;

/* loaded from: classes.dex */
public class SwitchPreference extends TwoStatePreference {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final C0654a f3850b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private CharSequence f3851c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private CharSequence f3852d;

    public SwitchPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13, i2);
        this.f3850b = new C0654a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SwitchPreference, OplusGLSurfaceView_13, i2);
        m3902e((CharSequence) TypedArrayUtils.m2321b(typedArrayObtainStyledAttributes, R.styleable.SwitchPreference_summaryOn, R.styleable.SwitchPreference_android_summaryOn));
        m3904f(TypedArrayUtils.m2321b(typedArrayObtainStyledAttributes, R.styleable.SwitchPreference_summaryOff, R.styleable.SwitchPreference_android_summaryOff));
        m3893c((CharSequence) TypedArrayUtils.m2321b(typedArrayObtainStyledAttributes, R.styleable.SwitchPreference_switchTextOn, R.styleable.SwitchPreference_android_switchTextOn));
        m3894d((CharSequence) TypedArrayUtils.m2321b(typedArrayObtainStyledAttributes, R.styleable.SwitchPreference_switchTextOff, R.styleable.SwitchPreference_android_switchTextOff));
        m3905f(TypedArrayUtils.m2315a(typedArrayObtainStyledAttributes, R.styleable.SwitchPreference_disableDependentsState, R.styleable.SwitchPreference_android_disableDependentsState, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        this(context, attributeSet, OplusGLSurfaceView_13, 0);
    }

    public SwitchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.m2306a(context, R.attr.switchPreferenceStyle, android.R.attr.switchPreferenceStyle));
    }

    public SwitchPreference(Context context) {
        this(context, null);
    }

    @Override // androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3736a(PreferenceViewHolder c0668l) {
        super.mo3736a(c0668l);
        m3892d(c0668l.m4007a(android.R.id_renamed.switch_widget));
        m3900b(c0668l);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m3893c(CharSequence charSequence) {
        this.f3851c = charSequence;
        mo3748i();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m3894d(CharSequence charSequence) {
        this.f3852d = charSequence;
        mo3748i();
    }

    @Override // androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo3735a(View view) {
        super.mo3735a(view);
        m3891c(view);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m3891c(View view) {
        if (((AccessibilityManager) m3800K().getSystemService("accessibility")).isEnabled()) {
            m3892d(view.findViewById(android.R.id_renamed.switch_widget));
            m3899b(view.findViewById(android.R.id_renamed.summary));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m3892d(View view) {
        boolean z = view instanceof Switch;
        if (z) {
            ((Switch) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f3858a);
        }
        if (z) {
            Switch r4 = (Switch) view;
            r4.setTextOn(this.f3851c);
            r4.setTextOff(this.f3852d);
            r4.setOnCheckedChangeListener(this.f3850b);
        }
    }

    /* renamed from: androidx.preference.SwitchPreference$PlatformImplementations.kt_3 */
    private class C0654a implements CompoundButton.OnCheckedChangeListener {
        C0654a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!SwitchPreference.this.m3831b(Boolean.valueOf(z))) {
                compoundButton.setChecked(!z);
            } else {
                SwitchPreference.this.m3903e(z);
            }
        }
    }
}
