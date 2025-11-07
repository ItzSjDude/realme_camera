package com.oplus.camera.filmvideomode;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.COUIRecyclerView;
import androidx.recyclerview.widget.RecyclerView;
import com.oplus.camera.filmvideomode.FilmParamsContainer;
import com.oplus.camera.professional.ProfessionalUtil;

/* compiled from: FilmModeBarRecyclerView.java */
/* renamed from: com.oplus.camera.filmvideomode.OplusGLSurfaceView_13 */
/* loaded from: classes2.dex */
public class FilmModeBarRecyclerView extends COUIRecyclerView {

    /* renamed from: COUIBaseListPopupWindow_12 */
    private FilmModeBarAdapter f13665f;

    public FilmModeBarRecyclerView(Context context) {
        super(context);
        this.f13665f = null;
    }

    public void setOnItemClickListener(FilmParamsContainer.IntrinsicsJvm.kt_5 dVar) {
        this.f13665f.m13537a(dVar);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13542a(int OplusGLSurfaceView_13, String str) {
        this.f13665f.m13532a(OplusGLSurfaceView_13, str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13543a(int OplusGLSurfaceView_13, String str, boolean z) {
        View viewM13541a = m13541a(OplusGLSurfaceView_13);
        this.f13665f.m13532a(OplusGLSurfaceView_13, str);
        this.f13665f.m13533a(OplusGLSurfaceView_13, z);
        if (viewM13541a != null) {
            this.f13665f.m13535a(viewM13541a, str);
            if (ProfessionalUtil.m16137a(OplusGLSurfaceView_13) && z) {
                if (viewM13541a.isSelected()) {
                    this.f13665f.m13534a(viewM13541a, 0, false);
                    return;
                } else {
                    this.f13665f.m13534a(viewM13541a, 0, true);
                    return;
                }
            }
            this.f13665f.m13534a(viewM13541a, 8, true);
            return;
        }
        FilmModeBarAdapter c2713h = this.f13665f;
        c2713h.notifyItemChanged(c2713h.m13540b(OplusGLSurfaceView_13));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13544a(int OplusGLSurfaceView_13, boolean z, boolean z2) {
        View viewM13541a = m13541a(OplusGLSurfaceView_13);
        if (viewM13541a != null) {
            if (viewM13541a instanceof FilmMainBarItem) {
                FilmMainBarItem c2709d = (FilmMainBarItem) viewM13541a;
                c2709d.m13495b(z, true);
                c2709d.m13492a(z2 ? 0 : 8, true);
                return;
            }
            viewM13541a.setEnabled(z);
            return;
        }
        FilmModeBarAdapter c2713h = this.f13665f;
        c2713h.notifyItemChanged(c2713h.m13540b(OplusGLSurfaceView_13));
    }

    @Override // android.view.View
    public boolean isSelected() {
        return getSelectedPosition() != -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.AbstractC0685a abstractC0685a) {
        super.setAdapter(abstractC0685a);
        this.f13665f = (FilmModeBarAdapter) abstractC0685a;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public View m13541a(int OplusGLSurfaceView_13) {
        RecyclerView.AbstractC0707w abstractC0707wFindViewHolderForAdapterPosition = findViewHolderForAdapterPosition(this.f13665f.m13540b(OplusGLSurfaceView_13));
        if (abstractC0707wFindViewHolderForAdapterPosition != null) {
            return abstractC0707wFindViewHolderForAdapterPosition.itemView;
        }
        return null;
    }

    public int getSelectedPosition() {
        FilmModeBarAdapter c2713h = this.f13665f;
        return c2713h.m13540b(c2713h.m13539b());
    }
}
