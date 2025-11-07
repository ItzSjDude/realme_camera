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

/* loaded from: classes2.dex */
public class ListModeBarAdapter extends BaseAdapter implements Filterable {

    /* renamed from: PlatformImplementations.kt_3 */
    private LayoutInflater f15366a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private List<? extends Map<String, ?>> f15367b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private int[] f15368c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private String[] f15369d = {"img", "title", "mainTitle"};

    /* renamed from: COUIBaseListPopupWindow_8 */
    private PanelInterface f15370e;

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

    public ListModeBarAdapter(Context context, List<? extends Map<String, ?>> list) {
        this.f15366a = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f15367b = list;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15371a(PanelInterface interfaceC2899q) {
        this.f15370e = interfaceC2899q;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<? extends Map<String, ?>> list = this.f15367b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public View getView(int OplusGLSurfaceView_13, View view, ViewGroup viewGroup) {
        return m15364a(OplusGLSurfaceView_13, view, viewGroup, 0);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m15366a(View view) {
        View viewFindViewById = view.findViewById(102);
        if (viewFindViewById instanceof MainBarItem) {
            return ((MainBarItem) viewFindViewById).getItemValueText();
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15372a(int[] iArr) {
        this.f15368c = iArr;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15368a(View view, String str) {
        ((MainBarItem) view.findViewById(102)).setItemValueText(str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15367a(View view, int OplusGLSurfaceView_13, boolean z) {
        ((MainBarItem) view.findViewById(102)).m15724a(OplusGLSurfaceView_13, z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15370a(View view, boolean z, boolean z2) {
        ((MainBarItem) view.findViewById(102)).m15726a(z, z2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m15373b(View view, boolean z, boolean z2) {
        ((MainBarItem) view.findViewById(102)).m15727b(z, z2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15369a(View view, boolean z) {
        ((MainBarItem) view.findViewById(102)).setTouched(z);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private View m15364a(int OplusGLSurfaceView_13, View view, ViewGroup viewGroup, int i2) {
        if (view == null) {
            view = this.f15366a.inflate(i2, viewGroup, false);
        }
        m15365a(OplusGLSurfaceView_13, view);
        return view;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m15365a(int OplusGLSurfaceView_13, View view) {
        Map<String, ?> map;
        if (OplusGLSurfaceView_13 <= this.f15367b.size() - 1 && (map = this.f15367b.get(OplusGLSurfaceView_13)) != null) {
            String[] strArr = this.f15369d;
            int length = this.f15368c.length;
            View viewFindViewById = view.findViewById(102);
            Object obj = map.get("mainTitle");
            int iIntValue = obj == null ? 0 : ((Integer) obj).intValue();
            Object obj2 = map.get("main_item_key");
            String string = obj2 == null ? "" : obj2.toString();
            MainBarItem c2894l = (MainBarItem) viewFindViewById;
            c2894l.setItemTitleImage(iIntValue);
            c2894l.setItemValueText(string);
            Object obj3 = map.get("main_item_animation");
            if (obj3 != null) {
                c2894l.setItemAnimation(((Integer) obj3).intValue());
            }
            int iIntValue2 = ((Integer) map.get("main_item_index")).intValue();
            c2894l.m15725a(ProfessionalUtil.m16137a(iIntValue2));
            PanelInterface interfaceC2899q = this.f15370e;
            if (interfaceC2899q != null) {
                if (interfaceC2899q.mo13576a(iIntValue2)) {
                    c2894l.m15724a(0, false);
                } else {
                    c2894l.m15724a(8, false);
                }
                c2894l.m15727b(this.f15370e.mo13582b(iIntValue2), false);
            }
            view.setTag(R.id_renamed.professional_parameter_index, Integer.valueOf(iIntValue2));
        }
    }
}
