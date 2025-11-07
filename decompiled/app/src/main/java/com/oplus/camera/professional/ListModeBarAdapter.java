package com.oplus.camera.professional;

/* loaded from: classes2.dex */
public class ListModeBarAdapter extends android.widget.BaseAdapter implements android.widget.Filterable {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.view.LayoutInflater f5099a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.util.List<? extends java.util.Map<java.lang.String, ?>> f5100b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private int[] f5101c;
    private java.lang.String[] d_renamed = {"img", "title", "mainTitle"};
    private com.oplus.camera.professional.q_renamed e_renamed;

    @Override // android.widget.Filterable
    public android.widget.Filter getFilter() {
        return null;
    }

    @Override // android.widget.Adapter
    public java.lang.Object getItem(int i_renamed) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i_renamed) {
        return 0L;
    }

    public ListModeBarAdapter(android.content.Context context, java.util.List<? extends java.util.Map<java.lang.String, ?>> list) {
        this.f5099a = (android.view.LayoutInflater) context.getSystemService("layout_inflater");
        this.f5100b = list;
    }

    public void a_renamed(com.oplus.camera.professional.q_renamed qVar) {
        this.e_renamed = qVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        java.util.List<? extends java.util.Map<java.lang.String, ?>> list = this.f5100b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public android.view.View getView(int i_renamed, android.view.View view, android.view.ViewGroup viewGroup) {
        return a_renamed(i_renamed, view, viewGroup, 0);
    }

    public java.lang.String a_renamed(android.view.View view) {
        android.view.View viewFindViewById = view.findViewById(102);
        if (viewFindViewById instanceof com.oplus.camera.professional.l_renamed) {
            return ((com.oplus.camera.professional.l_renamed) viewFindViewById).getItemValueText();
        }
        return null;
    }

    public void a_renamed(int[] iArr) {
        this.f5101c = iArr;
    }

    public void a_renamed(android.view.View view, java.lang.String str) {
        ((com.oplus.camera.professional.l_renamed) view.findViewById(102)).setItemValueText(str);
    }

    public void a_renamed(android.view.View view, int i_renamed, boolean z_renamed) {
        ((com.oplus.camera.professional.l_renamed) view.findViewById(102)).a_renamed(i_renamed, z_renamed);
    }

    public void a_renamed(android.view.View view, boolean z_renamed, boolean z2) {
        ((com.oplus.camera.professional.l_renamed) view.findViewById(102)).a_renamed(z_renamed, z2);
    }

    public void b_renamed(android.view.View view, boolean z_renamed, boolean z2) {
        ((com.oplus.camera.professional.l_renamed) view.findViewById(102)).b_renamed(z_renamed, z2);
    }

    public void a_renamed(android.view.View view, boolean z_renamed) {
        ((com.oplus.camera.professional.l_renamed) view.findViewById(102)).setTouched(z_renamed);
    }

    private android.view.View a_renamed(int i_renamed, android.view.View view, android.view.ViewGroup viewGroup, int i2) {
        if (view == null) {
            view = this.f5099a.inflate(i2, viewGroup, false);
        }
        a_renamed(i_renamed, view);
        return view;
    }

    private void a_renamed(int i_renamed, android.view.View view) {
        java.util.Map<java.lang.String, ?> map;
        if (i_renamed <= this.f5100b.size() - 1 && (map = this.f5100b.get(i_renamed)) != null) {
            java.lang.String[] strArr = this.d_renamed;
            int length = this.f5101c.length;
            android.view.View viewFindViewById = view.findViewById(102);
            java.lang.Object obj = map.get("mainTitle");
            int iIntValue = obj == null ? 0 : ((java.lang.Integer) obj).intValue();
            java.lang.Object obj2 = map.get("main_item_key");
            java.lang.String string = obj2 == null ? "" : obj2.toString();
            com.oplus.camera.professional.l_renamed lVar = (com.oplus.camera.professional.l_renamed) viewFindViewById;
            lVar.setItemTitleImage(iIntValue);
            lVar.setItemValueText(string);
            java.lang.Object obj3 = map.get("main_item_animation");
            if (obj3 != null) {
                lVar.setItemAnimation(((java.lang.Integer) obj3).intValue());
            }
            int iIntValue2 = ((java.lang.Integer) map.get("main_item_index")).intValue();
            lVar.a_renamed(com.oplus.camera.professional.x_renamed.a_renamed(iIntValue2));
            com.oplus.camera.professional.q_renamed qVar = this.e_renamed;
            if (qVar != null) {
                if (qVar.a_renamed(iIntValue2)) {
                    lVar.a_renamed(0, false);
                } else {
                    lVar.a_renamed(8, false);
                }
                lVar.b_renamed(this.e_renamed.b_renamed(iIntValue2), false);
            }
            view.setTag(com.oplus.camera.R_renamed.id_renamed.professional_parameter_index, java.lang.Integer.valueOf(iIntValue2));
        }
    }
}
