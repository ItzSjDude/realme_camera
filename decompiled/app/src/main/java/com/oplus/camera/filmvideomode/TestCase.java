package com.oplus.camera.filmvideomode;

/* compiled from: FilmMenuAdapter.java */
/* loaded from: classes2.dex */
public class e_renamed extends android.widget.BaseAdapter {

    /* renamed from: a_renamed, reason: collision with root package name */
    private java.util.List<com.oplus.camera.filmvideomode.g_renamed> f4483a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private boolean f4484b = false;

    /* renamed from: c_renamed, reason: collision with root package name */
    private android.content.SharedPreferences f4485c;
    private boolean d_renamed;
    private boolean e_renamed;

    @Override // android.widget.Adapter
    public long getItemId(int i_renamed) {
        return 0L;
    }

    public e_renamed(java.util.List<com.oplus.camera.filmvideomode.g_renamed> list, android.content.SharedPreferences sharedPreferences, boolean z_renamed, boolean z2) {
        this.f4483a = null;
        this.f4485c = null;
        this.d_renamed = false;
        this.e_renamed = false;
        this.f4483a = list == null ? new java.util.ArrayList<>() : list;
        this.f4485c = sharedPreferences;
        this.d_renamed = z_renamed;
        this.e_renamed = z2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f4483a.size();
    }

    @Override // android.widget.Adapter
    /* renamed from: a_renamed, reason: merged with bridge method [inline-methods] */
    public com.oplus.camera.filmvideomode.g_renamed getItem(int i_renamed) {
        return this.f4483a.get(i_renamed);
    }

    public java.util.List<com.oplus.camera.filmvideomode.g_renamed> a_renamed() {
        return this.f4483a;
    }

    public void a_renamed(com.oplus.camera.filmvideomode.f_renamed fVar, int i_renamed) throws android.content.res.Resources.NotFoundException {
        if (fVar == null || i_renamed >= fVar.getChildCount()) {
            return;
        }
        a_renamed(fVar.getChildAt(i_renamed), i_renamed, getItem(i_renamed));
    }

    public void a_renamed(com.oplus.camera.filmvideomode.f_renamed fVar, boolean z_renamed, boolean z2) throws android.content.res.Resources.NotFoundException {
        if (fVar == null || fVar.getChildCount() <= 0) {
            return;
        }
        int childCount = fVar.getChildCount();
        for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
            com.oplus.camera.filmvideomode.g_renamed item = getItem(i_renamed);
            a_renamed(fVar.getChildAt(i_renamed), i_renamed, item);
            if ((z_renamed && item.i_renamed()) || item.j_renamed()) {
                com.oplus.camera.filmvideomode.b_renamed.a_renamed(fVar.getChildAt(i_renamed), i_renamed, getItem(i_renamed).f_renamed(), childCount, z2);
            }
        }
    }

    public void a_renamed(com.oplus.camera.filmvideomode.f_renamed fVar, int i_renamed, boolean z_renamed) throws android.content.res.Resources.NotFoundException {
        a_renamed(fVar, i_renamed, z_renamed, false);
    }

    public void a_renamed(com.oplus.camera.filmvideomode.f_renamed fVar, int i_renamed, boolean z_renamed, boolean z2) throws android.content.res.Resources.NotFoundException {
        if (com.oplus.camera.util.Util.u_renamed()) {
            b_renamed(fVar, z_renamed, z2);
            return;
        }
        if (fVar == null || fVar.getChildCount() <= 0) {
            return;
        }
        if (i_renamed == 0) {
            int childCount = fVar.getChildCount();
            com.oplus.camera.filmvideomode.g_renamed item = getItem(i_renamed);
            this.f4484b = item.e_renamed();
            int i2 = 0;
            while (i2 < childCount) {
                com.oplus.camera.filmvideomode.g_renamed item2 = getItem(i2);
                item2.c_renamed(item.e_renamed() || i2 == 0);
                item2.b_renamed(item.e_renamed() || i2 != 0);
                i2++;
            }
            a_renamed(fVar, z_renamed, false);
        }
    }

    public void b_renamed(com.oplus.camera.filmvideomode.f_renamed fVar, boolean z_renamed, boolean z2) throws android.content.res.Resources.NotFoundException {
        if (fVar == null || fVar.getChildCount() <= 0) {
            return;
        }
        int childCount = fVar.getChildCount();
        this.f4484b = true;
        for (int i_renamed = 0; i_renamed < childCount; i_renamed++) {
            com.oplus.camera.filmvideomode.g_renamed item = getItem(i_renamed);
            item.c_renamed(true);
            item.b_renamed(true);
        }
        a_renamed(fVar, z_renamed, z2);
    }

    public void b_renamed(com.oplus.camera.filmvideomode.f_renamed fVar, int i_renamed, boolean z_renamed, boolean z2) throws android.content.res.Resources.NotFoundException {
        if (fVar == null || fVar.getChildCount() <= 0) {
            return;
        }
        if ((!this.e_renamed && i_renamed == 0) || this.e_renamed) {
            int childCount = fVar.getChildCount();
            com.oplus.camera.filmvideomode.g_renamed item = getItem(i_renamed);
            this.f4484b = false;
            int i2 = 0;
            while (i2 < childCount) {
                com.oplus.camera.filmvideomode.g_renamed item2 = getItem(i2);
                if (this.e_renamed) {
                    item2.c_renamed(false);
                    item2.b_renamed(true);
                } else {
                    item2.c_renamed(i2 == 0);
                    item2.b_renamed(i2 != 0);
                }
                i2++;
            }
            if (!z2) {
                item.b_renamed(true);
            }
            a_renamed(fVar, z_renamed, false);
        }
    }

    @Override // android.widget.Adapter
    public android.view.View getView(int i_renamed, android.view.View view, android.view.ViewGroup viewGroup) throws android.content.res.Resources.NotFoundException {
        if (view == null) {
            view = android.view.LayoutInflater.from(viewGroup.getContext()).inflate(0, viewGroup, false);
        }
        a_renamed(view, i_renamed, getItem(i_renamed));
        return view;
    }

    private void a_renamed(android.view.View view, int i_renamed, com.oplus.camera.filmvideomode.g_renamed gVar) throws android.content.res.Resources.NotFoundException {
        if (gVar == null || view == null) {
            return;
        }
        com.oplus.camera.ui.RotateImageView rotateImageView = (com.oplus.camera.ui.RotateImageView) view;
        android.content.res.Resources resources = view.getResources();
        if (resources == null) {
            return;
        }
        if (gVar.e_renamed()) {
            if (gVar.a_renamed() > 0) {
                rotateImageView.setImageResource(gVar.a_renamed());
            }
        } else if (gVar.c_renamed() > 0) {
            rotateImageView.setImageResource(gVar.c_renamed());
        }
        android.graphics.drawable.Drawable drawable = resources.getDrawable(gVar.d_renamed());
        if (gVar.f_renamed() && gVar.d_renamed() > 0) {
            drawable.setAlpha(255);
        } else {
            drawable.setAlpha(0);
        }
        view.setBackground(drawable);
        view.setVisibility(gVar.g_renamed() ? 0 : 8);
        if ((1 == i_renamed && this.e_renamed) || ((4 == i_renamed && this.d_renamed) || ((2 == i_renamed || 3 == i_renamed) && (!this.d_renamed || !this.e_renamed)))) {
            view.setEnabled(gVar.g_renamed() && this.f4485c.getBoolean(com.oplus.camera.ui.CameraUIInterface.KEY_FILM_VIDEO_EIS_AND_FLASH_ENABLE, true));
        } else {
            view.setEnabled(gVar.g_renamed() && gVar.h_renamed());
        }
    }

    public boolean b_renamed() {
        return this.f4484b;
    }
}
