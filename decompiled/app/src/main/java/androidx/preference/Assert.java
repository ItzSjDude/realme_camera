package androidx.preference;

/* loaded from: classes.dex */
public abstract class DialogPreference extends androidx.preference.Preference {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.lang.CharSequence f1291a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.lang.CharSequence f1292b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.graphics.drawable.Drawable f1293c;
    private java.lang.CharSequence d_renamed;
    private java.lang.CharSequence e_renamed;
    private int f_renamed;

    public interface a_renamed {
        <T_renamed extends androidx.preference.Preference> T_renamed a_renamed(java.lang.CharSequence charSequence);
    }

    public DialogPreference(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed, int i2) {
        super(context, attributeSet, i_renamed, i2);
        android.content.res.TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.preference.R_renamed.styleable.DialogPreference, i_renamed, i2);
        this.f1291a = androidx.core.a_renamed.a_renamed.g_renamed.b_renamed(typedArrayObtainStyledAttributes, androidx.preference.R_renamed.styleable.DialogPreference_dialogTitle, androidx.preference.R_renamed.styleable.DialogPreference_android_dialogTitle);
        if (this.f1291a == null) {
            this.f1291a = x_renamed();
        }
        this.f1292b = androidx.core.a_renamed.a_renamed.g_renamed.b_renamed(typedArrayObtainStyledAttributes, androidx.preference.R_renamed.styleable.DialogPreference_dialogMessage, androidx.preference.R_renamed.styleable.DialogPreference_android_dialogMessage);
        this.f1293c = androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(typedArrayObtainStyledAttributes, androidx.preference.R_renamed.styleable.DialogPreference_dialogIcon, androidx.preference.R_renamed.styleable.DialogPreference_android_dialogIcon);
        this.d_renamed = androidx.core.a_renamed.a_renamed.g_renamed.b_renamed(typedArrayObtainStyledAttributes, androidx.preference.R_renamed.styleable.DialogPreference_positiveButtonText, androidx.preference.R_renamed.styleable.DialogPreference_android_positiveButtonText);
        this.e_renamed = androidx.core.a_renamed.a_renamed.g_renamed.b_renamed(typedArrayObtainStyledAttributes, androidx.preference.R_renamed.styleable.DialogPreference_negativeButtonText, androidx.preference.R_renamed.styleable.DialogPreference_android_negativeButtonText);
        this.f_renamed = androidx.core.a_renamed.a_renamed.g_renamed.b_renamed(typedArrayObtainStyledAttributes, androidx.preference.R_renamed.styleable.DialogPreference_dialogLayout, androidx.preference.R_renamed.styleable.DialogPreference_android_dialogLayout, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public DialogPreference(android.content.Context context, android.util.AttributeSet attributeSet, int i_renamed) {
        this(context, attributeSet, i_renamed, 0);
    }

    public DialogPreference(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.a_renamed.a_renamed.g_renamed.a_renamed(context, androidx.preference.R_renamed.attr.dialogPreferenceStyle, android.R_renamed.attr.dialogPreferenceStyle));
    }

    public DialogPreference(android.content.Context context) {
        this(context, null);
    }

    public java.lang.CharSequence a_renamed() {
        return this.f1291a;
    }

    public java.lang.CharSequence b_renamed() {
        return this.f1292b;
    }

    public android.graphics.drawable.Drawable c_renamed() {
        return this.f1293c;
    }

    public java.lang.CharSequence d_renamed() {
        return this.d_renamed;
    }

    public java.lang.CharSequence e_renamed() {
        return this.e_renamed;
    }

    public int f_renamed() {
        return this.f_renamed;
    }

    @Override // androidx.preference.Preference
    protected void g_renamed() {
        N_renamed().a_renamed(this);
    }
}
