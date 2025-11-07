package a_renamed.a_renamed.b_renamed;

/* loaded from: classes.dex */
public class g_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static java.util.List<co_renamed.polarr.renderer.entities.FilterPackage> f155a = new java.util.ArrayList();

    static {
        co_renamed.polarr.renderer.entities.FilterPackage filterPackage = new co_renamed.polarr.renderer.entities.FilterPackage();
        filterPackage.pack_id = "Johnny_Filter_Common";
        filterPackage.pack_name = "Common";
        filterPackage.filters = new java.util.ArrayList();
        co_renamed.polarr.renderer.entities.FilterItem filterItem = new co_renamed.polarr.renderer.entities.FilterItem();
        filterItem.name = "人像风格2019新滤镜一";
        filterItem.id_renamed = co_renamed.polarr.renderer.FilterPackageUtil.PORTRAIT4_1;
        java.util.HashMap map = new java.util.HashMap();
        java.lang.Float fValueOf = java.lang.Float.valueOf(-0.45f);
        map.put("vignette_amount", fValueOf);
        java.lang.Float fValueOf2 = java.lang.Float.valueOf(1.0f);
        map.put("vignette_feather", fValueOf2);
        java.lang.Float fValueOf3 = java.lang.Float.valueOf(0.5f);
        map.put("vignette_highlights", fValueOf3);
        java.lang.Float fValueOf4 = java.lang.Float.valueOf(0.0f);
        map.put("vignette_roundness", fValueOf4);
        map.put("vignette_exposure", fValueOf4);
        map.put("vignette_size", fValueOf2);
        map.put("grain_size", fValueOf4);
        java.lang.Float fValueOf5 = java.lang.Float.valueOf(0.35f);
        map.put("grain_amount", fValueOf5);
        java.lang.Float fValueOf6 = java.lang.Float.valueOf(0.78f);
        map.put("grain_highlights", fValueOf6);
        map.put("grain_roughness", fValueOf4);
        filterItem.state = map;
        filterPackage.filters.add(filterItem);
        co_renamed.polarr.renderer.entities.FilterItem filterItem2 = new co_renamed.polarr.renderer.entities.FilterItem();
        filterItem2.name = "人像风格2019新滤镜一b";
        filterItem2.id_renamed = co_renamed.polarr.renderer.FilterPackageUtil.PORTRAIT4_1B;
        java.util.HashMap map2 = new java.util.HashMap();
        map2.put("grain_size", fValueOf4);
        map2.put("grain_amount", fValueOf5);
        map2.put("grain_highlights", fValueOf6);
        map2.put("grain_roughness", fValueOf4);
        filterItem2.state = map2;
        filterPackage.filters.add(filterItem2);
        co_renamed.polarr.renderer.entities.FilterItem filterItem3 = new co_renamed.polarr.renderer.entities.FilterItem();
        filterItem3.name = "人像风格2019新滤镜一c";
        filterItem3.id_renamed = co_renamed.polarr.renderer.FilterPackageUtil.PORTRAIT4_1C;
        java.util.HashMap map3 = new java.util.HashMap();
        map3.put("vignette_amount", fValueOf);
        map3.put("vignette_feather", fValueOf2);
        map3.put("vignette_highlights", fValueOf3);
        map3.put("vignette_roundness", fValueOf4);
        map3.put("vignette_exposure", fValueOf4);
        map3.put("vignette_size", fValueOf2);
        filterItem3.state = map3;
        filterPackage.filters.add(filterItem3);
        co_renamed.polarr.renderer.entities.FilterItem filterItem4 = new co_renamed.polarr.renderer.entities.FilterItem();
        filterItem4.name = "人像风格2019新滤镜三";
        filterItem4.id_renamed = co_renamed.polarr.renderer.FilterPackageUtil.PORTRAIT4_3;
        java.util.HashMap map4 = new java.util.HashMap();
        map4.put("overlay_amount", fValueOf2);
        filterItem4.state = map4;
        filterPackage.filters.add(filterItem4);
        f155a.add(filterPackage);
    }
}
