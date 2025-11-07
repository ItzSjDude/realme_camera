package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.core.p027a.p028a.TypedArrayUtils;

/* loaded from: classes.dex */
public abstract class DialogPreference extends Preference {

    /* renamed from: PlatformImplementations.kt_3 */
    private CharSequence f3709a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private CharSequence f3710b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Drawable f3711c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private CharSequence f3712d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private CharSequence f3713e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f3714f;

    /* renamed from: androidx.preference.DialogPreference$PlatformImplementations.kt_3 */
    public interface InterfaceC0633a {
        /* renamed from: PlatformImplementations.kt_3 */
        <T extends Preference> T mo3744a(CharSequence charSequence);
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13, i2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DialogPreference, OplusGLSurfaceView_13, i2);
        this.f3709a = TypedArrayUtils.m2321b(typedArrayObtainStyledAttributes, R.styleable.DialogPreference_dialogTitle, R.styleable.DialogPreference_android_dialogTitle);
        if (this.f3709a == null) {
            this.f3709a = m3856x();
        }
        this.f3710b = TypedArrayUtils.m2321b(typedArrayObtainStyledAttributes, R.styleable.DialogPreference_dialogMessage, R.styleable.DialogPreference_android_dialogMessage);
        this.f3711c = TypedArrayUtils.m2312a(typedArrayObtainStyledAttributes, R.styleable.DialogPreference_dialogIcon, R.styleable.DialogPreference_android_dialogIcon);
        this.f3712d = TypedArrayUtils.m2321b(typedArrayObtainStyledAttributes, R.styleable.DialogPreference_positiveButtonText, R.styleable.DialogPreference_android_positiveButtonText);
        this.f3713e = TypedArrayUtils.m2321b(typedArrayObtainStyledAttributes, R.styleable.DialogPreference_negativeButtonText, R.styleable.DialogPreference_android_negativeButtonText);
        this.f3714f = TypedArrayUtils.m2318b(typedArrayObtainStyledAttributes, R.styleable.DialogPreference_dialogLayout, R.styleable.DialogPreference_android_dialogLayout, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        this(context, attributeSet, OplusGLSurfaceView_13, 0);
    }

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.m2306a(context, R.attr.dialogPreferenceStyle, android.R.attr.dialogPreferenceStyle));
    }

    public DialogPreference(Context context) {
        this(context, null);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public CharSequence m3737a() {
        return this.f3709a;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public CharSequence m3738b() {
        return this.f3710b;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public Drawable m3739c() {
        return this.f3711c;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public CharSequence m3740d() {
        return this.f3712d;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public CharSequence m3741e() {
        return this.f3713e;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public int m3742f() {
        return this.f3714f;
    }

    @Override // androidx.preference.Preference
    /* renamed from: COUIBaseListPopupWindow_11 */
    protected void mo3743g() {
        m3803N().m3991a(this);
    }
}
