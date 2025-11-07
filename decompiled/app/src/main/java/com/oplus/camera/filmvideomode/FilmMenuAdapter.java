package com.oplus.camera.filmvideomode;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.RotateImageView;
import com.oplus.camera.util.Util;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FilmMenuAdapter.java */
/* renamed from: com.oplus.camera.filmvideomode.COUIBaseListPopupWindow_8 */
/* loaded from: classes2.dex */
public class FilmMenuAdapter extends BaseAdapter {

    /* renamed from: PlatformImplementations.kt_3 */
    private List<FilmMenuMode> f13640a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f13641b = false;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private SharedPreferences f13642c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f13643d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean f13644e;

    @Override // android.widget.Adapter
    public long getItemId(int OplusGLSurfaceView_13) {
        return 0L;
    }

    public FilmMenuAdapter(List<FilmMenuMode> list, SharedPreferences sharedPreferences, boolean z, boolean z2) {
        this.f13640a = null;
        this.f13642c = null;
        this.f13643d = false;
        this.f13644e = false;
        this.f13640a = list == null ? new ArrayList<>() : list;
        this.f13642c = sharedPreferences;
        this.f13643d = z;
        this.f13644e = z2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f13640a.size();
    }

    @Override // android.widget.Adapter
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public FilmMenuMode getItem(int OplusGLSurfaceView_13) {
        return this.f13640a.get(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public List<FilmMenuMode> m13498a() {
        return this.f13640a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13499a(FilmMenuLayout viewOnClickListenerC2711f, int OplusGLSurfaceView_13) throws Resources.NotFoundException {
        if (viewOnClickListenerC2711f == null || OplusGLSurfaceView_13 >= viewOnClickListenerC2711f.getChildCount()) {
            return;
        }
        m13496a(viewOnClickListenerC2711f.getChildAt(OplusGLSurfaceView_13), OplusGLSurfaceView_13, getItem(OplusGLSurfaceView_13));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13502a(FilmMenuLayout viewOnClickListenerC2711f, boolean z, boolean z2) throws Resources.NotFoundException {
        if (viewOnClickListenerC2711f == null || viewOnClickListenerC2711f.getChildCount() <= 0) {
            return;
        }
        int childCount = viewOnClickListenerC2711f.getChildCount();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            FilmMenuMode item = getItem(OplusGLSurfaceView_13);
            m13496a(viewOnClickListenerC2711f.getChildAt(OplusGLSurfaceView_13), OplusGLSurfaceView_13, item);
            if ((z && item.m13524i()) || item.m13525j()) {
                FilmAnimatorUtil.m13467a(viewOnClickListenerC2711f.getChildAt(OplusGLSurfaceView_13), OplusGLSurfaceView_13, getItem(OplusGLSurfaceView_13).m13521f(), childCount, z2);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13500a(FilmMenuLayout viewOnClickListenerC2711f, int OplusGLSurfaceView_13, boolean z) throws Resources.NotFoundException {
        m13501a(viewOnClickListenerC2711f, OplusGLSurfaceView_13, z, false);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13501a(FilmMenuLayout viewOnClickListenerC2711f, int OplusGLSurfaceView_13, boolean z, boolean z2) throws Resources.NotFoundException {
        if (Util.m24498u()) {
            m13504b(viewOnClickListenerC2711f, z, z2);
            return;
        }
        if (viewOnClickListenerC2711f == null || viewOnClickListenerC2711f.getChildCount() <= 0) {
            return;
        }
        if (OplusGLSurfaceView_13 == 0) {
            int childCount = viewOnClickListenerC2711f.getChildCount();
            FilmMenuMode item = getItem(OplusGLSurfaceView_13);
            this.f13641b = item.m13519e();
            int i2 = 0;
            while (i2 < childCount) {
                FilmMenuMode item2 = getItem(i2);
                item2.m13514c(item.m13519e() || i2 == 0);
                item2.m13511b(item.m13519e() || i2 != 0);
                i2++;
            }
            m13502a(viewOnClickListenerC2711f, z, false);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m13504b(FilmMenuLayout viewOnClickListenerC2711f, boolean z, boolean z2) throws Resources.NotFoundException {
        if (viewOnClickListenerC2711f == null || viewOnClickListenerC2711f.getChildCount() <= 0) {
            return;
        }
        int childCount = viewOnClickListenerC2711f.getChildCount();
        this.f13641b = true;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < childCount; OplusGLSurfaceView_13++) {
            FilmMenuMode item = getItem(OplusGLSurfaceView_13);
            item.m13514c(true);
            item.m13511b(true);
        }
        m13502a(viewOnClickListenerC2711f, z, z2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m13503b(FilmMenuLayout viewOnClickListenerC2711f, int OplusGLSurfaceView_13, boolean z, boolean z2) throws Resources.NotFoundException {
        if (viewOnClickListenerC2711f == null || viewOnClickListenerC2711f.getChildCount() <= 0) {
            return;
        }
        if ((!this.f13644e && OplusGLSurfaceView_13 == 0) || this.f13644e) {
            int childCount = viewOnClickListenerC2711f.getChildCount();
            FilmMenuMode item = getItem(OplusGLSurfaceView_13);
            this.f13641b = false;
            int i2 = 0;
            while (i2 < childCount) {
                FilmMenuMode item2 = getItem(i2);
                if (this.f13644e) {
                    item2.m13514c(false);
                    item2.m13511b(true);
                } else {
                    item2.m13514c(i2 == 0);
                    item2.m13511b(i2 != 0);
                }
                i2++;
            }
            if (!z2) {
                item.m13511b(true);
            }
            m13502a(viewOnClickListenerC2711f, z, false);
        }
    }

    @Override // android.widget.Adapter
    public View getView(int OplusGLSurfaceView_13, View view, ViewGroup viewGroup) throws Resources.NotFoundException {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(0, viewGroup, false);
        }
        m13496a(view, OplusGLSurfaceView_13, getItem(OplusGLSurfaceView_13));
        return view;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m13496a(View view, int OplusGLSurfaceView_13, FilmMenuMode c2712g) throws Resources.NotFoundException {
        if (c2712g == null || view == null) {
            return;
        }
        RotateImageView rotateImageView = (RotateImageView) view;
        Resources resources = view.getResources();
        if (resources == null) {
            return;
        }
        if (c2712g.m13519e()) {
            if (c2712g.m13506a() > 0) {
                rotateImageView.setImageResource(c2712g.m13506a());
            }
        } else if (c2712g.m13512c() > 0) {
            rotateImageView.setImageResource(c2712g.m13512c());
        }
        Drawable drawable = resources.getDrawable(c2712g.m13515d());
        if (c2712g.m13521f() && c2712g.m13515d() > 0) {
            drawable.setAlpha(255);
        } else {
            drawable.setAlpha(0);
        }
        view.setBackground(drawable);
        view.setVisibility(c2712g.m13522g() ? 0 : 8);
        if ((1 == OplusGLSurfaceView_13 && this.f13644e) || ((4 == OplusGLSurfaceView_13 && this.f13643d) || ((2 == OplusGLSurfaceView_13 || 3 == OplusGLSurfaceView_13) && (!this.f13643d || !this.f13644e)))) {
            view.setEnabled(c2712g.m13522g() && this.f13642c.getBoolean(CameraUIInterface.KEY_FILM_VIDEO_EIS_AND_FLASH_ENABLE, true));
        } else {
            view.setEnabled(c2712g.m13522g() && c2712g.m13523h());
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m13505b() {
        return this.f13641b;
    }
}
