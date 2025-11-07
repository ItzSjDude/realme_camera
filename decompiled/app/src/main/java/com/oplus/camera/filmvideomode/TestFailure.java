package com.oplus.camera.filmvideomode;

/* compiled from: FilmMenuLayout.java */
/* loaded from: classes2.dex */
public class f_renamed extends android.widget.LinearLayout implements android.view.View.OnClickListener {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.widget.BaseAdapter f4486a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.oplus.camera.filmvideomode.f_renamed.a_renamed f4487b;

    /* compiled from: FilmMenuLayout.java */
    public interface a_renamed {
        void b_renamed(android.view.View view, android.view.View view2, int i_renamed);
    }

    public f_renamed(android.content.Context context) {
        this(context, null);
    }

    public f_renamed(android.content.Context context, android.widget.BaseAdapter baseAdapter) {
        super(context);
        this.f4486a = null;
        this.f4487b = null;
        setLayoutDirection(0);
        setOrientation(0);
        setAdapter(baseAdapter);
    }

    public void setAdapter(android.widget.BaseAdapter baseAdapter) {
        if (baseAdapter == null) {
            return;
        }
        removeAllViews();
        this.f4486a = baseAdapter;
        int count = this.f4486a.getCount();
        for (int i_renamed = 0; i_renamed < count; i_renamed++) {
            android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_mode_menu_width), getContext().getResources().getDimensionPixelSize(com.oplus.camera.R_renamed.dimen.movie_mode_menu_height));
            android.view.View view = this.f4486a.getView(i_renamed, getMenuView(), this);
            if (com.oplus.camera.util.Util.g_renamed() == 0 && !com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_10_BITS_HEIC_ENCODE_SUPPORT) && 2 == i_renamed) {
                layoutParams = new android.widget.LinearLayout.LayoutParams(0, 0);
            }
            view.setOnClickListener(this);
            addView(view, layoutParams);
        }
    }

    private android.view.View getMenuView() {
        com.oplus.camera.ui.RotateImageView rotateImageView = new com.oplus.camera.ui.RotateImageView(getContext());
        rotateImageView.a_renamed(com.oplus.camera.util.Util.u_renamed() ? 0 : 270, false);
        return rotateImageView;
    }

    public void setMenuItemClickListener(com.oplus.camera.filmvideomode.f_renamed.a_renamed aVar) {
        this.f4487b = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        if (this.f4487b != null) {
            this.f4487b.b_renamed(this, view, indexOfChild(view));
        }
    }
}
