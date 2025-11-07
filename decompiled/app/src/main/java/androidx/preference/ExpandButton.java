package androidx.preference;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ExpandButton.java */
/* renamed from: androidx.preference.IntrinsicsJvm.kt_4 */
/* loaded from: classes.dex */
final class ExpandButton extends Preference {

    /* renamed from: PlatformImplementations.kt_3 */
    private long f3865a;

    ExpandButton(Context context, List<Preference> list, long OplusGLSurfaceView_15) {
        super(context);
        m3914b();
        m3913a(list);
        this.f3865a = OplusGLSurfaceView_15 + 1000000;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m3914b() {
        m3811a(R.layout.expand_button);
        m3845e(R.drawable.ic_arrow_down_24dp);
        m3840d(R.string.expand_button_title);
        m3835c(999);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m3913a(List<Preference> list) {
        ArrayList arrayList = new ArrayList();
        CharSequence string = null;
        for (Preference preference : list) {
            CharSequence charSequenceM3856x = preference.m3856x();
            boolean z = preference instanceof PreferenceGroup;
            if (z && !TextUtils.isEmpty(charSequenceM3856x)) {
                arrayList.add((PreferenceGroup) preference);
            }
            if (arrayList.contains(preference.m3807R())) {
                if (z) {
                    arrayList.add((PreferenceGroup) preference);
                }
            } else if (!TextUtils.isEmpty(charSequenceM3856x)) {
                string = string == null ? charSequenceM3856x : m3800K().getString(R.string.summary_collapsed_preference_list, string, charSequenceM3856x);
            }
        }
        mo3764a(string);
    }

    @Override // androidx.preference.Preference
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3736a(PreferenceViewHolder c0668l) {
        super.mo3736a(c0668l);
        c0668l.m4008a(false);
    }

    @Override // androidx.preference.Preference
    /* renamed from: c_ */
    long mo3839c_() {
        return this.f3865a;
    }
}
