package com.oplus.camera.professional;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import com.oplus.camera.R;
import java.util.List;
import java.util.Map;

/* compiled from: HSListModeBarAdapter.java */
/* renamed from: com.oplus.camera.professional.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class HSListModeBarAdapter extends BaseAdapter implements Filterable {

    /* renamed from: PlatformImplementations.kt_3 */
    private LayoutInflater f15425a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private List<? extends Map<String, ?>> f15426b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int[] f15427c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private String[] f15428d = {"img", "title", "mainTitle"};

    /* renamed from: COUIBaseListPopupWindow_8 */
    private PanelInterface f15429e;

    @Override // android.widget.Filterable
    public Filter getFilter() {
        return null;
    }

    @Override // android.widget.Adapter
    public Object getItem(int OplusGLSurfaceView_13) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int OplusGLSurfaceView_13) {
        return 0L;
    }

    public HSListModeBarAdapter(Context context, List<? extends Map<String, ?>> list) {
        this.f15425a = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f15426b = list;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15422a(PanelInterface interfaceC2899q) {
        this.f15429e = interfaceC2899q;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<? extends Map<String, ?>> list = this.f15426b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public View getView(int OplusGLSurfaceView_13, View view, ViewGroup viewGroup) {
        return m15415a(OplusGLSurfaceView_13, view, viewGroup, 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m15417a(View view) {
        View viewFindViewById = view.findViewById(102);
        if (viewFindViewById instanceof HSMainBarItem) {
            return ((HSMainBarItem) viewFindViewById).getItemValueText();
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15423a(int[] iArr) {
        this.f15427c = iArr;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15419a(View view, String str) {
        ((HSMainBarItem) view.findViewById(102)).setItemValueText(str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15418a(View view, int OplusGLSurfaceView_13, boolean z) {
        ((HSMainBarItem) view.findViewById(102)).m15445a(OplusGLSurfaceView_13, z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15421a(View view, boolean z, boolean z2) {
        ((HSMainBarItem) view.findViewById(102)).m15447a(z, z2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m15424b(View view, boolean z, boolean z2) {
        ((HSMainBarItem) view.findViewById(102)).m15448b(z, z2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15420a(View view, boolean z) {
        ((HSMainBarItem) view.findViewById(102)).setTouched(z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private View m15415a(int OplusGLSurfaceView_13, View view, ViewGroup viewGroup, int i2) {
        if (view == null) {
            view = this.f15425a.inflate(i2, viewGroup, false);
        }
        m15416a(OplusGLSurfaceView_13, view);
        return view;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m15416a(int OplusGLSurfaceView_13, View view) {
        Map<String, ?> map;
        if (OplusGLSurfaceView_13 <= this.f15426b.size() - 1 && (map = this.f15426b.get(OplusGLSurfaceView_13)) != null) {
            String[] strArr = this.f15428d;
            int length = this.f15427c.length;
            View viewFindViewById = view.findViewById(102);
            Object obj = map.get("mainTitle");
            Object obj2 = map.get("main_item_key");
            HSMainBarItem c2888f = (HSMainBarItem) viewFindViewById;
            c2888f.setItemValueText(obj2 == null ? "" : obj2.toString());
            if (OplusGLSurfaceView_13 != 0) {
                c2888f.setItemTitleImage(obj != null ? (String) obj : "");
            }
            Object obj3 = map.get("main_item_animation");
            if (obj3 != null) {
                c2888f.setItemAnimation(((Integer) obj3).intValue());
            }
            int iIntValue = ((Integer) map.get("main_item_index")).intValue();
            c2888f.m15446a(ProfessionalUtil.m16137a(iIntValue));
            PanelInterface interfaceC2899q = this.f15429e;
            if (interfaceC2899q != null) {
                if (interfaceC2899q.mo13576a(iIntValue)) {
                    c2888f.m15445a(0, false);
                } else {
                    c2888f.m15445a(8, false);
                }
                c2888f.m15448b(this.f15429e.mo13582b(iIntValue), false);
            }
            view.setTag(R.id_renamed.professional_parameter_index, Integer.valueOf(iIntValue));
        }
    }
}
