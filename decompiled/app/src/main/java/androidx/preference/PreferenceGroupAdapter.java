package androidx.preference;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.p016a.p017a.AppCompatResources;
import androidx.core.p036h.ViewCompat;
import androidx.preference.PreferenceManager;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: PreferenceGroupAdapter.java */
/* renamed from: androidx.preference.COUIBaseListPopupWindow_10 */
/* loaded from: classes.dex */
public class PreferenceGroupAdapter extends RecyclerView.AbstractC0685a<PreferenceViewHolder> implements Preference.InterfaceC0643a {

    /* renamed from: PlatformImplementations.kt_3 */
    private PreferenceGroup f3898a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private List<Preference> f3899b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private List<Preference> f3900c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private List<PlatformImplementations.kt_3> f3901d;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Runnable f3903f = new Runnable() { // from class: androidx.preference.COUIBaseListPopupWindow_10.1
        @Override // java.lang.Runnable
        public void run() {
            PreferenceGroupAdapter.this.m3964a();
        }
    };

    /* renamed from: COUIBaseListPopupWindow_8 */
    private Handler f3902e = new Handler();

    public PreferenceGroupAdapter(PreferenceGroup preferenceGroup) {
        this.f3898a = preferenceGroup;
        this.f3898a.m3816a((Preference.InterfaceC0643a) this);
        this.f3899b = new ArrayList();
        this.f3900c = new ArrayList();
        this.f3901d = new ArrayList();
        PreferenceGroup preferenceGroup2 = this.f3898a;
        if (preferenceGroup2 instanceof PreferenceScreen) {
            setHasStableIds(((PreferenceScreen) preferenceGroup2).m3882l());
        } else {
            setHasStableIds(true);
        }
        m3964a();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    void m3964a() {
        Iterator<Preference> it = this.f3899b.iterator();
        while (it.hasNext()) {
            it.next().m3816a((Preference.InterfaceC0643a) null);
        }
        this.f3899b = new ArrayList(this.f3899b.size());
        m3960a(this.f3899b, this.f3898a);
        final List<Preference> list = this.f3900c;
        final List<Preference> listM3959a = m3959a(this.f3898a);
        this.f3900c = listM3959a;
        PreferenceManager c0666jN = this.f3898a.m3803N();
        if (c0666jN != null && c0666jN.m4002g() != null) {
            final PreferenceManager.IntrinsicsJvm.kt_5 dVarM4002g = c0666jN.m4002g();
            DiffUtil.m4417a(new DiffUtil.PlatformImplementations.kt_3() { // from class: androidx.preference.COUIBaseListPopupWindow_10.2
                @Override // androidx.recyclerview.widget.DiffUtil.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public int mo3966a() {
                    return list.size();
                }

                @Override // androidx.recyclerview.widget.DiffUtil.PlatformImplementations.kt_3
                /* renamed from: IntrinsicsJvm.kt_4 */
                public int mo3968b() {
                    return listM3959a.size();
                }

                @Override // androidx.recyclerview.widget.DiffUtil.PlatformImplementations.kt_3
                /* renamed from: PlatformImplementations.kt_3 */
                public boolean mo3967a(int OplusGLSurfaceView_13, int i2) {
                    return dVarM4002g.m4005a((Preference) list.get(OplusGLSurfaceView_13), (Preference) listM3959a.get(i2));
                }

                @Override // androidx.recyclerview.widget.DiffUtil.PlatformImplementations.kt_3
                /* renamed from: IntrinsicsJvm.kt_4 */
                public boolean mo3969b(int OplusGLSurfaceView_13, int i2) {
                    return dVarM4002g.m4006b((Preference) list.get(OplusGLSurfaceView_13), (Preference) listM3959a.get(i2));
                }
            }).m4434a(this);
        } else {
            notifyDataSetChanged();
        }
        Iterator<Preference> it2 = this.f3899b.iterator();
        while (it2.hasNext()) {
            it2.next().m3806Q();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m3960a(List<Preference> list, PreferenceGroup preferenceGroup) {
        preferenceGroup.m3876h();
        int iM3866c = preferenceGroup.m3866c();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iM3866c; OplusGLSurfaceView_13++) {
            Preference preferenceM3878j = preferenceGroup.m3878j(OplusGLSurfaceView_13);
            list.add(preferenceM3878j);
            PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3(preferenceM3878j);
            if (!this.f3901d.contains(aVar)) {
                this.f3901d.add(aVar);
            }
            if (preferenceM3878j instanceof PreferenceGroup) {
                PreferenceGroup preferenceGroup2 = (PreferenceGroup) preferenceM3878j;
                if (preferenceGroup2.mo3873e()) {
                    m3960a(list, preferenceGroup2);
                }
            }
            preferenceM3878j.m3816a((Preference.InterfaceC0643a) this);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private List<Preference> m3959a(PreferenceGroup preferenceGroup) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int iM3866c = preferenceGroup.m3866c();
        int OplusGLSurfaceView_13 = 0;
        for (int i2 = 0; i2 < iM3866c; i2++) {
            Preference preferenceM3878j = preferenceGroup.m3878j(i2);
            if (preferenceM3878j.m3790A()) {
                if (!m3961b(preferenceGroup) || OplusGLSurfaceView_13 < preferenceGroup.m3864b()) {
                    arrayList.add(preferenceM3878j);
                } else {
                    arrayList2.add(preferenceM3878j);
                }
                if (preferenceM3878j instanceof PreferenceGroup) {
                    PreferenceGroup preferenceGroup2 = (PreferenceGroup) preferenceM3878j;
                    if (!preferenceGroup2.mo3873e()) {
                        continue;
                    } else {
                        if (m3961b(preferenceGroup) && m3961b(preferenceGroup2)) {
                            throw new IllegalStateException("Nesting an expandable group inside of another expandable group is not supported!");
                        }
                        for (Preference preference : m3959a(preferenceGroup2)) {
                            if (!m3961b(preferenceGroup) || OplusGLSurfaceView_13 < preferenceGroup.m3864b()) {
                                arrayList.add(preference);
                            } else {
                                arrayList2.add(preference);
                            }
                            OplusGLSurfaceView_13++;
                        }
                    }
                } else {
                    OplusGLSurfaceView_13++;
                }
            }
        }
        if (m3961b(preferenceGroup) && OplusGLSurfaceView_13 > preferenceGroup.m3864b()) {
            arrayList.add(m3958a(preferenceGroup, arrayList2));
        }
        return arrayList;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private ExpandButton m3958a(final PreferenceGroup preferenceGroup, List<Preference> list) {
        ExpandButton c0658b = new ExpandButton(preferenceGroup.m3800K(), list, preferenceGroup.mo3839c_());
        c0658b.m3818a(new Preference.InterfaceC0645c() { // from class: androidx.preference.COUIBaseListPopupWindow_10.3
            @Override // androidx.preference.Preference.InterfaceC0645c
            public boolean onPreferenceClick(Preference preference) {
                preferenceGroup.m3877i(Integer.MAX_VALUE);
                PreferenceGroupAdapter.this.mo3862b(preference);
                PreferenceGroup.InterfaceC0650a interfaceC0650aM3875f = preferenceGroup.m3875f();
                if (interfaceC0650aM3875f == null) {
                    return true;
                }
                interfaceC0650aM3875f.m3881a();
                return true;
            }
        });
        return c0658b;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean m3961b(PreferenceGroup preferenceGroup) {
        return preferenceGroup.m3864b() != Integer.MAX_VALUE;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public Preference m3962a(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < 0 || OplusGLSurfaceView_13 >= getItemCount()) {
            return null;
        }
        return this.f3900c.get(OplusGLSurfaceView_13);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    public int getItemCount() {
        return this.f3900c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    public long getItemId(int OplusGLSurfaceView_13) {
        if (hasStableIds()) {
            return m3962a(OplusGLSurfaceView_13).mo3839c_();
        }
        return -1L;
    }

    @Override // androidx.preference.Preference.InterfaceC0643a
    /* renamed from: PlatformImplementations.kt_3 */
    public void mo3861a(Preference preference) {
        int iIndexOf = this.f3900c.indexOf(preference);
        if (iIndexOf != -1) {
            notifyItemChanged(iIndexOf, preference);
        }
    }

    @Override // androidx.preference.Preference.InterfaceC0643a
    /* renamed from: IntrinsicsJvm.kt_4 */
    public void mo3862b(Preference preference) {
        this.f3902e.removeCallbacks(this.f3903f);
        this.f3902e.post(this.f3903f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    public int getItemViewType(int OplusGLSurfaceView_13) {
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3(m3962a(OplusGLSurfaceView_13));
        int iIndexOf = this.f3901d.indexOf(aVar);
        if (iIndexOf != -1) {
            return iIndexOf;
        }
        int size = this.f3901d.size();
        this.f3901d.add(aVar);
        return size;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public PreferenceViewHolder onCreateViewHolder(ViewGroup viewGroup, int OplusGLSurfaceView_13) {
        PlatformImplementations.kt_3 aVar = this.f3901d.get(OplusGLSurfaceView_13);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(viewGroup.getContext());
        TypedArray typedArrayObtainStyledAttributes = viewGroup.getContext().obtainStyledAttributes((AttributeSet) null, R.styleable.BackgroundStyle);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.BackgroundStyle_android_selectableItemBackground);
        if (drawable == null) {
            drawable = AppCompatResources.m732b(viewGroup.getContext(), android.R.drawable.list_selector_background);
        }
        typedArrayObtainStyledAttributes.recycle();
        View viewInflate = layoutInflaterFrom.inflate(aVar.f3911a, viewGroup, false);
        if (viewInflate.getBackground() == null) {
            ViewCompat.m2850a(viewInflate, drawable);
        }
        ViewGroup viewGroup2 = (ViewGroup) viewInflate.findViewById(android.R.id_renamed.widget_frame);
        if (viewGroup2 != null) {
            if (aVar.f3912b != 0) {
                layoutInflaterFrom.inflate(aVar.f3912b, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        return new PreferenceViewHolder(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(PreferenceViewHolder c0668l, int OplusGLSurfaceView_13) {
        m3962a(OplusGLSurfaceView_13).mo3736a(c0668l);
    }

    /* compiled from: PreferenceGroupAdapter.java */
    /* renamed from: androidx.preference.COUIBaseListPopupWindow_10$PlatformImplementations.kt_3 */
    private static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        int f3911a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        int f3912b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        String f3913c;

        PlatformImplementations.kt_3(Preference preference) {
            this.f3913c = preference.getClass().getName();
            this.f3911a = preference.m3853u();
            this.f3912b = preference.m3854v();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof PlatformImplementations.kt_3)) {
                return false;
            }
            PlatformImplementations.kt_3 aVar = (PlatformImplementations.kt_3) obj;
            return this.f3911a == aVar.f3911a && this.f3912b == aVar.f3912b && TextUtils.equals(this.f3913c, aVar.f3913c);
        }

        public int hashCode() {
            return ((((527 + this.f3911a) * 31) + this.f3912b) * 31) + this.f3913c.hashCode();
        }
    }
}
