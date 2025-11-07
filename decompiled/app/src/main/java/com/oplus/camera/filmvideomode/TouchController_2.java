package com.oplus.camera.filmvideomode;

/* compiled from: FilmSubMenuAdapter.java */
/* loaded from: classes2.dex */
public class m_renamed extends android.widget.BaseAdapter {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.content.Context f4512a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private java.util.ArrayList<com.oplus.camera.filmvideomode.n_renamed> f4513b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.view.LayoutInflater f4514c;

    @Override // android.widget.Adapter
    public long getItemId(int i_renamed) {
        return 0L;
    }

    public m_renamed(android.content.Context context, java.util.ArrayList<com.oplus.camera.filmvideomode.n_renamed> arrayList) {
        this.f4512a = null;
        this.f4513b = null;
        this.f4514c = null;
        this.f4512a = context;
        this.f4514c = android.view.LayoutInflater.from(context);
        if (arrayList == null) {
            this.f4513b = new java.util.ArrayList<>();
        } else {
            this.f4513b = arrayList;
        }
    }

    public void a_renamed(java.util.ArrayList<com.oplus.camera.filmvideomode.n_renamed> arrayList) {
        this.f4513b = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f4513b.size();
    }

    @Override // android.widget.Adapter
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public com.oplus.camera.filmvideomode.n_renamed getItem(int i_renamed) {
        return this.f4513b.get(i_renamed);
    }

    @Override // android.widget.Adapter
    public android.view.View getView(int i_renamed, android.view.View view, android.view.ViewGroup viewGroup) {
        final com.oplus.camera.filmvideomode.n_renamed item = getItem(i_renamed);
        android.widget.FrameLayout frameLayout = (android.widget.FrameLayout) this.f4514c.inflate(com.oplus.camera.R_renamed.layout.film_submenu_item, (android.view.ViewGroup) null);
        ((android.widget.TextView) frameLayout.findViewById(com.oplus.camera.R_renamed.id_renamed.submenu_item_title)).setText(item.b_renamed());
        final com.coui.appcompat.widget.COUISwitch cOUISwitch = (com.coui.appcompat.widget.COUISwitch) frameLayout.findViewById(com.oplus.camera.R_renamed.id_renamed.submenu_item_switch);
        cOUISwitch.setTag(item);
        cOUISwitch.setChecked(item.a_renamed());
        cOUISwitch.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() { // from class: com.oplus.camera.filmvideomode.m_renamed.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(android.widget.CompoundButton compoundButton, boolean z_renamed) {
                item.a_renamed(z_renamed);
                cOUISwitch.setChecked(z_renamed);
                item.c_renamed().a_renamed(z_renamed);
            }
        });
        frameLayout.setOnClickListener(new android.view.View.OnClickListener() { // from class: com.oplus.camera.filmvideomode.m_renamed.2
            @Override // android.view.View.OnClickListener
            public void onClick(android.view.View view2) {
                boolean z_renamed = !item.a_renamed();
                item.a_renamed(z_renamed);
                cOUISwitch.setChecked(z_renamed);
                item.c_renamed().a_renamed(z_renamed);
            }
        });
        return frameLayout;
    }
}
