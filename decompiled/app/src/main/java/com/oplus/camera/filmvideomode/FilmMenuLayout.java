package com.oplus.camera.filmvideomode;

import android.content.Context;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.oplus.camera.R;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.p172ui.RotateImageView;
import com.oplus.camera.util.Util;

/* compiled from: FilmMenuLayout.java */
/* renamed from: com.oplus.camera.filmvideomode.COUIBaseListPopupWindow_12 */
/* loaded from: classes2.dex */
public class FilmMenuLayout extends LinearLayout implements View.OnClickListener {

    /* renamed from: PlatformImplementations.kt_3 */
    private BaseAdapter f13645a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private PlatformImplementations.kt_3 f13646b;

    /* compiled from: FilmMenuLayout.java */
    /* renamed from: com.oplus.camera.filmvideomode.COUIBaseListPopupWindow_12$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo13426b(View view, View view2, int OplusGLSurfaceView_13);
    }

    public FilmMenuLayout(Context context) {
        this(context, null);
    }

    public FilmMenuLayout(Context context, BaseAdapter baseAdapter) {
        super(context);
        this.f13645a = null;
        this.f13646b = null;
        setLayoutDirection(0);
        setOrientation(0);
        setAdapter(baseAdapter);
    }

    public void setAdapter(BaseAdapter baseAdapter) {
        if (baseAdapter == null) {
            return;
        }
        removeAllViews();
        this.f13645a = baseAdapter;
        int count = this.f13645a.getCount();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < count; OplusGLSurfaceView_13++) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.movie_mode_menu_width), getContext().getResources().getDimensionPixelSize(R.dimen.movie_mode_menu_height));
            View view = this.f13645a.getView(OplusGLSurfaceView_13, getMenuView(), this);
            if (Util.m24451g() == 0 && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_10_BITS_HEIC_ENCODE_SUPPORT) && 2 == OplusGLSurfaceView_13) {
                layoutParams = new LinearLayout.LayoutParams(0, 0);
            }
            view.setOnClickListener(this);
            addView(view, layoutParams);
        }
    }

    private View getMenuView() {
        RotateImageView rotateImageView = new RotateImageView(getContext());
        rotateImageView.m18348a(Util.m24498u() ? 0 : 270, false);
        return rotateImageView;
    }

    public void setMenuItemClickListener(PlatformImplementations.kt_3 aVar) {
        this.f13646b = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f13646b != null) {
            this.f13646b.mo13426b(this, view, indexOfChild(view));
        }
    }
}
