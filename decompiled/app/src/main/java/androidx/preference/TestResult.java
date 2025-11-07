package androidx.preference;

/* compiled from: PreferenceGroupAdapter.java */
/* loaded from: classes.dex */
public class h_renamed extends androidx.recyclerview.widget.RecyclerView.a_renamed<androidx.preference.l_renamed> implements androidx.preference.Preference.a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private androidx.preference.PreferenceGroup f1354a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.util.List<androidx.preference.Preference> f1355b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.util.List<androidx.preference.Preference> f1356c;
    private java.util.List<androidx.preference.h_renamed.a_renamed> d_renamed;
    private java.lang.Runnable f_renamed = new java.lang.Runnable() { // from class: androidx.preference.h_renamed.1
        @Override // java.lang.Runnable
        public void run() {
            androidx.preference.h_renamed.this.a_renamed();
        }
    };
    private android.os.Handler e_renamed = new android.os.Handler();

    public h_renamed(androidx.preference.PreferenceGroup preferenceGroup) {
        this.f1354a = preferenceGroup;
        this.f1354a.a_renamed((androidx.preference.Preference.a_renamed) this);
        this.f1355b = new java.util.ArrayList();
        this.f1356c = new java.util.ArrayList();
        this.d_renamed = new java.util.ArrayList();
        androidx.preference.PreferenceGroup preferenceGroup2 = this.f1354a;
        if (preferenceGroup2 instanceof androidx.preference.PreferenceScreen) {
            setHasStableIds(((androidx.preference.PreferenceScreen) preferenceGroup2).l_renamed());
        } else {
            setHasStableIds(true);
        }
        a_renamed();
    }

    void a_renamed() {
        java.util.Iterator<androidx.preference.Preference> it = this.f1355b.iterator();
        while (it.hasNext()) {
            it.next().a_renamed((androidx.preference.Preference.a_renamed) null);
        }
        this.f1355b = new java.util.ArrayList(this.f1355b.size());
        a_renamed(this.f1355b, this.f1354a);
        final java.util.List<androidx.preference.Preference> list = this.f1356c;
        final java.util.List<androidx.preference.Preference> listA = a_renamed(this.f1354a);
        this.f1356c = listA;
        androidx.preference.j_renamed jVarN = this.f1354a.N_renamed();
        if (jVarN != null && jVarN.g_renamed() != null) {
            final androidx.preference.j_renamed.d_renamed dVarG = jVarN.g_renamed();
            androidx.recyclerview.widget.f_renamed.a_renamed(new androidx.recyclerview.widget.f_renamed.a_renamed() { // from class: androidx.preference.h_renamed.2
                @Override // androidx.recyclerview.widget.f_renamed.a_renamed
                public int a_renamed() {
                    return list.size();
                }

                @Override // androidx.recyclerview.widget.f_renamed.a_renamed
                public int b_renamed() {
                    return listA.size();
                }

                @Override // androidx.recyclerview.widget.f_renamed.a_renamed
                public boolean a_renamed(int i_renamed, int i2) {
                    return dVarG.a_renamed((androidx.preference.Preference) list.get(i_renamed), (androidx.preference.Preference) listA.get(i2));
                }

                @Override // androidx.recyclerview.widget.f_renamed.a_renamed
                public boolean b_renamed(int i_renamed, int i2) {
                    return dVarG.b_renamed((androidx.preference.Preference) list.get(i_renamed), (androidx.preference.Preference) listA.get(i2));
                }
            }).a_renamed(this);
        } else {
            notifyDataSetChanged();
        }
        java.util.Iterator<androidx.preference.Preference> it2 = this.f1355b.iterator();
        while (it2.hasNext()) {
            it2.next().Q_renamed();
        }
    }

    private void a_renamed(java.util.List<androidx.preference.Preference> list, androidx.preference.PreferenceGroup preferenceGroup) {
        preferenceGroup.h_renamed();
        int iC = preferenceGroup.c_renamed();
        for (int i_renamed = 0; i_renamed < iC; i_renamed++) {
            androidx.preference.Preference preferenceJ = preferenceGroup.j_renamed(i_renamed);
            list.add(preferenceJ);
            androidx.preference.h_renamed.a_renamed aVar = new androidx.preference.h_renamed.a_renamed(preferenceJ);
            if (!this.d_renamed.contains(aVar)) {
                this.d_renamed.add(aVar);
            }
            if (preferenceJ instanceof androidx.preference.PreferenceGroup) {
                androidx.preference.PreferenceGroup preferenceGroup2 = (androidx.preference.PreferenceGroup) preferenceJ;
                if (preferenceGroup2.e_renamed()) {
                    a_renamed(list, preferenceGroup2);
                }
            }
            preferenceJ.a_renamed((androidx.preference.Preference.a_renamed) this);
        }
    }

    private java.util.List<androidx.preference.Preference> a_renamed(androidx.preference.PreferenceGroup preferenceGroup) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        int iC = preferenceGroup.c_renamed();
        int i_renamed = 0;
        for (int i2 = 0; i2 < iC; i2++) {
            androidx.preference.Preference preferenceJ = preferenceGroup.j_renamed(i2);
            if (preferenceJ.A_renamed()) {
                if (!b_renamed(preferenceGroup) || i_renamed < preferenceGroup.b_renamed()) {
                    arrayList.add(preferenceJ);
                } else {
                    arrayList2.add(preferenceJ);
                }
                if (preferenceJ instanceof androidx.preference.PreferenceGroup) {
                    androidx.preference.PreferenceGroup preferenceGroup2 = (androidx.preference.PreferenceGroup) preferenceJ;
                    if (!preferenceGroup2.e_renamed()) {
                        continue;
                    } else {
                        if (b_renamed(preferenceGroup) && b_renamed(preferenceGroup2)) {
                            throw new java.lang.IllegalStateException("Nesting an_renamed expandable group inside of_renamed another expandable group is_renamed not supported!");
                        }
                        for (androidx.preference.Preference preference : a_renamed(preferenceGroup2)) {
                            if (!b_renamed(preferenceGroup) || i_renamed < preferenceGroup.b_renamed()) {
                                arrayList.add(preference);
                            } else {
                                arrayList2.add(preference);
                            }
                            i_renamed++;
                        }
                    }
                } else {
                    i_renamed++;
                }
            }
        }
        if (b_renamed(preferenceGroup) && i_renamed > preferenceGroup.b_renamed()) {
            arrayList.add(a_renamed(preferenceGroup, arrayList2));
        }
        return arrayList;
    }

    private androidx.preference.b_renamed a_renamed(final androidx.preference.PreferenceGroup preferenceGroup, java.util.List<androidx.preference.Preference> list) {
        androidx.preference.b_renamed bVar = new androidx.preference.b_renamed(preferenceGroup.K_renamed(), list, preferenceGroup.c__renamed());
        bVar.a_renamed(new androidx.preference.Preference.c_renamed() { // from class: androidx.preference.h_renamed.3
            @Override // androidx.preference.Preference.c_renamed
            public boolean onPreferenceClick(androidx.preference.Preference preference) {
                preferenceGroup.i_renamed(Integer.MAX_VALUE);
                androidx.preference.h_renamed.this.b_renamed(preference);
                androidx.preference.PreferenceGroup.a_renamed aVarF = preferenceGroup.f_renamed();
                if (aVarF == null) {
                    return true;
                }
                aVarF.a_renamed();
                return true;
            }
        });
        return bVar;
    }

    private boolean b_renamed(androidx.preference.PreferenceGroup preferenceGroup) {
        return preferenceGroup.b_renamed() != Integer.MAX_VALUE;
    }

    public androidx.preference.Preference a_renamed(int i_renamed) {
        if (i_renamed < 0 || i_renamed >= getItemCount()) {
            return null;
        }
        return this.f1356c.get(i_renamed);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    public int getItemCount() {
        return this.f1356c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    public long getItemId(int i_renamed) {
        if (hasStableIds()) {
            return a_renamed(i_renamed).c__renamed();
        }
        return -1L;
    }

    @Override // androidx.preference.Preference.a_renamed
    public void a_renamed(androidx.preference.Preference preference) {
        int iIndexOf = this.f1356c.indexOf(preference);
        if (iIndexOf != -1) {
            notifyItemChanged(iIndexOf, preference);
        }
    }

    @Override // androidx.preference.Preference.a_renamed
    public void b_renamed(androidx.preference.Preference preference) {
        this.e_renamed.removeCallbacks(this.f_renamed);
        this.e_renamed.post(this.f_renamed);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    public int getItemViewType(int i_renamed) {
        androidx.preference.h_renamed.a_renamed aVar = new androidx.preference.h_renamed.a_renamed(a_renamed(i_renamed));
        int iIndexOf = this.d_renamed.indexOf(aVar);
        if (iIndexOf != -1) {
            return iIndexOf;
        }
        int size = this.d_renamed.size();
        this.d_renamed.add(aVar);
        return size;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public androidx.preference.l_renamed onCreateViewHolder(android.view.ViewGroup viewGroup, int i_renamed) {
        androidx.preference.h_renamed.a_renamed aVar = this.d_renamed.get(i_renamed);
        android.view.LayoutInflater layoutInflaterFrom = android.view.LayoutInflater.from(viewGroup.getContext());
        android.content.res.TypedArray typedArrayObtainStyledAttributes = viewGroup.getContext().obtainStyledAttributes((android.util.AttributeSet) null, androidx.preference.R_renamed.styleable.BackgroundStyle);
        android.graphics.drawable.Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(androidx.preference.R_renamed.styleable.BackgroundStyle_android_selectableItemBackground);
        if (drawable == null) {
            drawable = androidx.appcompat.a_renamed.a_renamed.a_renamed.b_renamed(viewGroup.getContext(), android.R_renamed.drawable.list_selector_background);
        }
        typedArrayObtainStyledAttributes.recycle();
        android.view.View viewInflate = layoutInflaterFrom.inflate(aVar.f1363a, viewGroup, false);
        if (viewInflate.getBackground() == null) {
            androidx.core.h_renamed.v_renamed.a_renamed(viewInflate, drawable);
        }
        android.view.ViewGroup viewGroup2 = (android.view.ViewGroup) viewInflate.findViewById(android.R_renamed.id_renamed.widget_frame);
        if (viewGroup2 != null) {
            if (aVar.f1364b != 0) {
                layoutInflaterFrom.inflate(aVar.f1364b, viewGroup2);
            } else {
                viewGroup2.setVisibility(8);
            }
        }
        return new androidx.preference.l_renamed(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a_renamed
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(androidx.preference.l_renamed lVar, int i_renamed) {
        a_renamed(i_renamed).a_renamed(lVar);
    }

    /* compiled from: PreferenceGroupAdapter.java */
    private static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        int f1363a;

        /* renamed from: b_renamed, reason: collision with root package name */
        int f1364b;

        /* renamed from: c_renamed, reason: collision with root package name */
        java.lang.String f1365c;

        a_renamed(androidx.preference.Preference preference) {
            this.f1365c = preference.getClass().getName();
            this.f1363a = preference.u_renamed();
            this.f1364b = preference.v_renamed();
        }

        public boolean equals(java.lang.Object obj) {
            if (!(obj instanceof androidx.preference.h_renamed.a_renamed)) {
                return false;
            }
            androidx.preference.h_renamed.a_renamed aVar = (androidx.preference.h_renamed.a_renamed) obj;
            return this.f1363a == aVar.f1363a && this.f1364b == aVar.f1364b && android.text.TextUtils.equals(this.f1365c, aVar.f1365c);
        }

        public int hashCode() {
            return ((((527 + this.f1363a) * 31) + this.f1364b) * 31) + this.f1365c.hashCode();
        }
    }
}
