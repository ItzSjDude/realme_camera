package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import androidx.core.p027a.p028a.TypedArrayUtils;
import androidx.preference.PreferenceManager;

/* loaded from: classes.dex */
public final class PreferenceScreen extends PreferenceGroup {

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f3786b;

    @Override // androidx.preference.PreferenceGroup
    /* renamed from: COUIBaseListPopupWindow_8 */
    protected boolean mo3873e() {
        return false;
    }

    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, TypedArrayUtils.m2306a(context, R.attr.preferenceScreenStyle, android.R.attr.preferenceScreenStyle));
        this.f3786b = true;
    }

    @Override // androidx.preference.Preference
    /* renamed from: COUIBaseListPopupWindow_11 */
    protected void mo3743g() {
        PreferenceManager.IntrinsicsJvm.kt_4 bVarM4004i;
        if (m3849q() != null || m3850r() != null || m3866c() == 0 || (bVarM4004i = m3803N().m4004i()) == null) {
            return;
        }
        bVarM4004i.mo3944b(this);
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public boolean m3882l() {
        return this.f3786b;
    }
}
