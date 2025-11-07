package com.oplus.camera.filmvideomode;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.filmvideomode.FilmParamsContainer;
import com.oplus.camera.professional.ProfessionalUtil;
import com.oplus.camera.professional.PanelInterface;
import com.oplus.camera.util.Util;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FilmModeBarAdapter.java */
/* renamed from: com.oplus.camera.filmvideomode.COUIBaseListPopupWindow_10 */
/* loaded from: classes2.dex */
public class FilmModeBarAdapter extends RecyclerView.AbstractC0685a<PlatformImplementations.kt_3> {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final String f13657a = "COUIBaseListPopupWindow_10";

    /* renamed from: IntrinsicsJvm.kt_4 */
    private FilmModeBarRecyclerView f13658b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private Activity f13659c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private List<FilmModeItemBarData> f13660d = new ArrayList();

    /* renamed from: COUIBaseListPopupWindow_8 */
    private PanelInterface f13661e = null;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private FilmParamsContainer.IntrinsicsJvm.kt_5 f13662f = null;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f13663g = -1;

    public FilmModeBarAdapter(Activity activity, FilmModeBarRecyclerView c2714i, List<FilmModeItemBarData> list) {
        this.f13658b = null;
        this.f13659c = null;
        this.f13659c = activity;
        this.f13658b = c2714i;
        this.f13660d.addAll(list);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13538a(PanelInterface interfaceC2899q) {
        this.f13661e = interfaceC2899q;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13537a(FilmParamsContainer.IntrinsicsJvm.kt_5 dVar) {
        this.f13662f = dVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public PlatformImplementations.kt_3 onCreateViewHolder(ViewGroup viewGroup, int OplusGLSurfaceView_13) {
        FilmMainBarItem c2709d = new FilmMainBarItem(this.f13659c);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.f13659c.getResources().getDimensionPixelSize(Util.m24498u() ? R.dimen.movie_mode_params_item_width_rack : R.dimen.movie_mode_params_item_width), this.f13659c.getResources().getDimensionPixelSize(Util.m24498u() ? R.dimen.movie_mode_params_item_height_rack : R.dimen.movie_mode_params_item_height));
        c2709d.setId(102);
        c2709d.setRotation(Util.m24498u() ? 0.0f : 90.0f);
        c2709d.setGravity(Util.m24498u() ? 1 : 16);
        c2709d.setLayoutParams(layoutParams);
        return new PlatformImplementations.kt_3(c2709d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    /* renamed from: PlatformImplementations.kt_3, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(PlatformImplementations.kt_3 aVar, int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 > this.f13660d.size() - 1) {
            CameraLog.m12959b(f13657a, "onBindViewHolder, invalid position.");
            return;
        }
        FilmModeItemBarData c2715j = this.f13660d.get(OplusGLSurfaceView_13);
        FilmMainBarItem c2709d = (FilmMainBarItem) aVar.itemView;
        c2709d.setItemIndex(c2715j.m13556e());
        c2709d.setItemTitleImage(c2715j.m13549b());
        c2709d.setItemValueText(c2715j.m13555d());
        c2709d.setItemAnimation(c2715j.m13545a());
        c2709d.m13493a(true);
        PanelInterface interfaceC2899q = this.f13661e;
        if (interfaceC2899q != null) {
            c2709d.m13495b(interfaceC2899q.mo13582b(c2715j.m13556e()), false);
            if (ProfessionalUtil.m16137a(c2715j.m13556e()) && this.f13661e.mo13576a(c2715j.m13556e())) {
                c2709d.m13492a(0, false);
            } else {
                c2709d.m13492a(8, false);
            }
        }
        if (c2715j.m13556e() == this.f13663g) {
            c2715j.m13551b(true);
        }
        c2709d.setSelected(c2715j.m13554c());
        c2709d.setTag(R.id_renamed.professional_parameter_index, Integer.valueOf(c2715j.m13556e()));
        c2709d.setOnClickListener(new View.OnClickListener() { // from class: com.oplus.camera.filmvideomode.-$$Lambda$COUIBaseListPopupWindow_10$O2cG4OBzV6V1bSYg5ehKQ1Mexu8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.COUIBaseListPopupWindow_12$0.m13526b(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public /* synthetic */ void m13526b(View view) {
        if (this.f13662f.mo13424a(view)) {
            int iM13528a = m13528a(view);
            CameraLog.m12959b(f13657a, "onBindViewHolder, onclick view index: " + iM13528a);
            if (iM13528a == 0) {
                view.sendAccessibilityEvent(1);
                ((FilmMainBarItem) view).m13494a(true, true);
                this.f13662f.mo13412a(null, view, iM13528a, iM13528a);
                CameraLog.m12959b(f13657a, "onBindViewHolder, reset item click.");
                return;
            }
            if (-1 != this.f13663g) {
                m13527c();
            }
            FilmParamsContainer.IntrinsicsJvm.kt_5 dVar = this.f13662f;
            if (dVar != null) {
                if (this.f13663g != iM13528a) {
                    FilmModeItemBarData c2715jM13530a = m13530a(iM13528a);
                    if (c2715jM13530a != null) {
                        c2715jM13530a.m13551b(true);
                    }
                    ((FilmMainBarItem) view).m13494a(true, true);
                    this.f13662f.mo13412a(null, view, iM13528a, iM13528a);
                } else {
                    dVar.mo13411a(null, view, iM13528a);
                }
            }
            if (this.f13663g != iM13528a && view != null) {
                this.f13663g = iM13528a;
                view.sendAccessibilityEvent(1);
            } else {
                m13531a();
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    private void m13527c() {
        for (FilmModeItemBarData c2715j : this.f13660d) {
            c2715j.m13551b(false);
            FilmMainBarItem c2709d = (FilmMainBarItem) this.f13658b.m13541a(c2715j.m13556e());
            if (c2709d != null) {
                c2709d.m13494a(false, true);
            } else {
                notifyItemChanged(m13540b(c2715j.m13556e()));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    public int getItemCount() {
        return this.f13660d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0685a
    public long getItemId(int OplusGLSurfaceView_13) {
        return this.f13660d.get(OplusGLSurfaceView_13).m13556e();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13531a() {
        m13527c();
        this.f13663g = -1;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public FilmModeItemBarData m13530a(int OplusGLSurfaceView_13) {
        for (FilmModeItemBarData c2715j : this.f13660d) {
            if (c2715j.m13556e() == OplusGLSurfaceView_13) {
                return c2715j;
            }
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13532a(int OplusGLSurfaceView_13, String str) {
        FilmModeItemBarData c2715jM13530a = m13530a(OplusGLSurfaceView_13);
        if (c2715jM13530a != null) {
            c2715jM13530a.m13547a(str);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13535a(View view, String str) {
        ((FilmMainBarItem) view).setItemValueText(str);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m13539b() {
        return this.f13663g;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13534a(View view, int OplusGLSurfaceView_13, boolean z) {
        ((FilmMainBarItem) view).m13492a(OplusGLSurfaceView_13, z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m13533a(int OplusGLSurfaceView_13, boolean z) {
        FilmModeItemBarData c2715jM13530a = m13530a(OplusGLSurfaceView_13);
        if (c2715jM13530a != null) {
            c2715jM13530a.m13548a(z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public int m13528a(View view) {
        if (view == null) {
            return -1;
        }
        return ((Integer) view.getTag(R.id_renamed.professional_parameter_index)).intValue();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int m13540b(int OplusGLSurfaceView_13) {
        for (int i2 = 0; i2 < this.f13660d.size(); i2++) {
            if (OplusGLSurfaceView_13 == this.f13660d.get(i2).m13556e()) {
                return i2;
            }
        }
        return -1;
    }

    /* compiled from: FilmModeBarAdapter.java */
    /* renamed from: com.oplus.camera.filmvideomode.COUIBaseListPopupWindow_10$PlatformImplementations.kt_3 */
    public class PlatformImplementations.kt_3 extends RecyclerView.AbstractC0707w {
        public PlatformImplementations.kt_3(View view) {
            super(view);
        }
    }
}
