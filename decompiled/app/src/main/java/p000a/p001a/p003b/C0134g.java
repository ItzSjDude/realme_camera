package p000a.p001a.p003b;

import co.polarr.renderer.FilterPackageUtil;
import co.polarr.renderer.entities.FilterItem;
import co.polarr.renderer.entities.FilterPackage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_11 */
/* loaded from: classes.dex */
public class C0134g {

    /* renamed from: PlatformImplementations.kt_3 */
    public static List<FilterPackage> f689a = new ArrayList();

    static {
        FilterPackage filterPackage = new FilterPackage();
        filterPackage.pack_id = "Johnny_Filter_Common";
        filterPackage.pack_name = "Common";
        filterPackage.filters = new ArrayList();
        FilterItem filterItem = new FilterItem();
        filterItem.name = "人像风格2019新滤镜一";
        filterItem.f5145id = FilterPackageUtil.PORTRAIT4_1;
        HashMap map = new HashMap();
        Float fValueOf = Float.valueOf(-0.45f);
        map.put("vignette_amount", fValueOf);
        Float fValueOf2 = Float.valueOf(1.0f);
        map.put("vignette_feather", fValueOf2);
        Float fValueOf3 = Float.valueOf(0.5f);
        map.put("vignette_highlights", fValueOf3);
        Float fValueOf4 = Float.valueOf(0.0f);
        map.put("vignette_roundness", fValueOf4);
        map.put("vignette_exposure", fValueOf4);
        map.put("vignette_size", fValueOf2);
        map.put("grain_size", fValueOf4);
        Float fValueOf5 = Float.valueOf(0.35f);
        map.put("grain_amount", fValueOf5);
        Float fValueOf6 = Float.valueOf(0.78f);
        map.put("grain_highlights", fValueOf6);
        map.put("grain_roughness", fValueOf4);
        filterItem.state = map;
        filterPackage.filters.add(filterItem);
        FilterItem filterItem2 = new FilterItem();
        filterItem2.name = "人像风格2019新滤镜一b";
        filterItem2.f5145id = FilterPackageUtil.PORTRAIT4_1B;
        HashMap map2 = new HashMap();
        map2.put("grain_size", fValueOf4);
        map2.put("grain_amount", fValueOf5);
        map2.put("grain_highlights", fValueOf6);
        map2.put("grain_roughness", fValueOf4);
        filterItem2.state = map2;
        filterPackage.filters.add(filterItem2);
        FilterItem filterItem3 = new FilterItem();
        filterItem3.name = "人像风格2019新滤镜一c";
        filterItem3.f5145id = FilterPackageUtil.PORTRAIT4_1C;
        HashMap map3 = new HashMap();
        map3.put("vignette_amount", fValueOf);
        map3.put("vignette_feather", fValueOf2);
        map3.put("vignette_highlights", fValueOf3);
        map3.put("vignette_roundness", fValueOf4);
        map3.put("vignette_exposure", fValueOf4);
        map3.put("vignette_size", fValueOf2);
        filterItem3.state = map3;
        filterPackage.filters.add(filterItem3);
        FilterItem filterItem4 = new FilterItem();
        filterItem4.name = "人像风格2019新滤镜三";
        filterItem4.f5145id = FilterPackageUtil.PORTRAIT4_3;
        HashMap map4 = new HashMap();
        map4.put("overlay_amount", fValueOf2);
        filterItem4.state = map4;
        filterPackage.filters.add(filterItem4);
        f689a.add(filterPackage);
    }
}
