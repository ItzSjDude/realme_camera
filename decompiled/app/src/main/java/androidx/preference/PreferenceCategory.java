package androidx.preference;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.core.p027a.ContextCompat;
import androidx.core.p027a.p028a.TypedArrayUtils;
import androidx.core.p036h.p037a.AccessibilityNodeInfoCompat;

/* loaded from: classes.dex */
public class PreferenceCategory extends PreferenceGroup {
    @Override // androidx.preference.Preference
    /* renamed from: y */
    public boolean mo3857y() {
        return false;
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13, int i2) {
        super(context, attributeSet, OplusGLSurfaceView_13, i2);
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet, int OplusGLSurfaceView_13) {
        this(context, attributeSet, OplusGLSurfaceView_13, 0);
    }

    public PreferenceCategory(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.m2306a(context, R.attr.preferenceCategoryStyle, android.R.attr.preferenceCategoryStyle));
    }

    public PreferenceCategory(Context context) {
        this(context, null);
    }

    @Override // androidx.preference.Preference
    /* renamed from: OplusGLSurfaceView_15 */
    public boolean mo3754j() {
        return !super.mo3857y();
    }

    @Override // androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3736a(PreferenceViewHolder c0668l) {
        TextView textView;
        super.mo3736a(c0668l);
        if (Build.VERSION.SDK_INT >= 28) {
            c0668l.itemView.setAccessibilityHeading(true);
            return;
        }
        if (Build.VERSION.SDK_INT < 21) {
            TypedValue typedValue = new TypedValue();
            if (m3800K().getTheme().resolveAttribute(R.attr.colorAccent, typedValue, true) && (textView = (TextView) c0668l.m4007a(android.R.id_renamed.title)) != null) {
                if (textView.getCurrentTextColor() != ContextCompat.m2254c(m3800K(), R.color.preference_fallback_accent_color)) {
                    return;
                }
                textView.setTextColor(typedValue.data);
            }
        }
    }

    @Override // androidx.preference.Preference
    @Deprecated
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3815a(AccessibilityNodeInfoCompat c0483d) {
        AccessibilityNodeInfoCompat.IntrinsicsJvm.kt_3 cVarM2732u;
        super.mo3815a(c0483d);
        if (Build.VERSION.SDK_INT >= 28 || (cVarM2732u = c0483d.m2732u()) == null) {
            return;
        }
        c0483d.m2691b(AccessibilityNodeInfoCompat.IntrinsicsJvm.kt_3.m2742a(cVarM2732u.m2745c(), cVarM2732u.m2746d(), cVarM2732u.m2743a(), cVarM2732u.m2744b(), true, cVarM2732u.m2747e()));
    }
}
