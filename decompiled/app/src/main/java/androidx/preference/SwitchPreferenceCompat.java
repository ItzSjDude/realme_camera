package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.p027a.p028a.TypedArrayUtils;

/* loaded from: classes.dex */
public class SwitchPreferenceCompat extends TwoStatePreference {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final C0655a f3854b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private CharSequence f3855c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private CharSequence f3856d;

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13, i2);
        this.f3854b = new C0655a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SwitchPreferenceCompat, OplusGLSurfaceView_13, i2);
        m3902e((CharSequence) TypedArrayUtils.m2321b(typedArrayObtainStyledAttributes, R.styleable.SwitchPreferenceCompat_summaryOn, R.styleable.SwitchPreferenceCompat_android_summaryOn));
        m3904f(TypedArrayUtils.m2321b(typedArrayObtainStyledAttributes, R.styleable.SwitchPreferenceCompat_summaryOff, R.styleable.SwitchPreferenceCompat_android_summaryOff));
        m3897c((CharSequence) TypedArrayUtils.m2321b(typedArrayObtainStyledAttributes, R.styleable.SwitchPreferenceCompat_switchTextOn, R.styleable.SwitchPreferenceCompat_android_switchTextOn));
        m3898d((CharSequence) TypedArrayUtils.m2321b(typedArrayObtainStyledAttributes, R.styleable.SwitchPreferenceCompat_switchTextOff, R.styleable.SwitchPreferenceCompat_android_switchTextOff));
        m3905f(TypedArrayUtils.m2315a(typedArrayObtainStyledAttributes, R.styleable.SwitchPreferenceCompat_disableDependentsState, R.styleable.f3835xcfbb45b3, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        this(context, attributeSet, OplusGLSurfaceView_13, 0);
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.switchPreferenceCompatStyle);
    }

    @Override // androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3736a(PreferenceViewHolder c0668l) {
        super.mo3736a(c0668l);
        m3896d(c0668l.m4007a(R.id_renamed.switchWidget));
        m3900b(c0668l);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m3897c(CharSequence charSequence) {
        this.f3855c = charSequence;
        mo3748i();
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m3898d(CharSequence charSequence) {
        this.f3856d = charSequence;
        mo3748i();
    }

    @Override // androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    protected void mo3735a(View view) {
        super.mo3735a(view);
        m3895c(view);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m3895c(View view) {
        if (((AccessibilityManager) m3800K().getSystemService("accessibility")).isEnabled()) {
            m3896d(view.findViewById(R.id_renamed.switchWidget));
            m3899b(view.findViewById(android.R.id_renamed.summary));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: IntrinsicsJvm.kt_5 */
    private void m3896d(View view) {
        boolean z = view instanceof SwitchCompat;
        if (z) {
            ((SwitchCompat) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.f3858a);
        }
        if (z) {
            SwitchCompat switchCompat = (SwitchCompat) view;
            switchCompat.setTextOn(this.f3855c);
            switchCompat.setTextOff(this.f3856d);
            switchCompat.setOnCheckedChangeListener(this.f3854b);
        }
    }

    /* renamed from: androidx.preference.SwitchPreferenceCompat$PlatformImplementations.kt_3 */
    private class C0655a implements CompoundButton.OnCheckedChangeListener {
        C0655a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!SwitchPreferenceCompat.this.m3831b(Boolean.valueOf(z))) {
                compoundButton.setChecked(!z);
            } else {
                SwitchPreferenceCompat.this.m3903e(z);
            }
        }
    }
}
