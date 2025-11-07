package a_renamed.a_renamed.b_renamed;

/* loaded from: classes.dex */
public class f_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final java.util.Map<java.lang.String, java.lang.Object> f79a = new java.util.HashMap();

    static {
        a_renamed(f79a);
    }

    public static a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed a_renamed(java.util.List<? extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed> list, java.lang.Class cls) {
        for (a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed aVar : list) {
            if (aVar.getClass() == cls) {
                return aVar;
            }
        }
        return null;
    }

    public static java.lang.Object a_renamed(java.lang.String str, java.lang.Object obj, java.util.Map<java.lang.String, java.lang.Object> map) {
        if (obj != null && !map.containsKey(str)) {
            map.put(str, obj);
        }
        return map.get(str);
    }

    public static java.lang.Object a_renamed(java.lang.String str, java.util.Map<java.lang.String, java.lang.Object> map) {
        return a_renamed(str, (java.lang.Object) null, map);
    }

    public static java.lang.Object a_renamed(java.util.List<? extends a_renamed.a_renamed.b_renamed.b_renamed.a_renamed.a_renamed> list, java.lang.String str, java.lang.Object obj) {
        a_renamed.a_renamed.b_renamed.b_renamed.ba_renamed baVar;
        if (a_renamed.a_renamed.b_renamed.b_renamed.ba_renamed.r_renamed.containsKey(str) && obj != null && list != null && (baVar = (a_renamed.a_renamed.b_renamed.b_renamed.ba_renamed) a_renamed(list, a_renamed.a_renamed.b_renamed.b_renamed.ba_renamed.class)) != null) {
            baVar.a_renamed(str, obj);
        }
        if (a_renamed.a_renamed.b_renamed.b_renamed.v_renamed.r_renamed.contains(str) && obj != null) {
            a_renamed.a_renamed.b_renamed.b_renamed.v_renamed vVar = list != null ? (a_renamed.a_renamed.b_renamed.b_renamed.v_renamed) a_renamed(list, a_renamed.a_renamed.b_renamed.b_renamed.v_renamed.class) : null;
            if (obj instanceof java.lang.Object[]) {
                java.lang.Object[] objArr = (java.lang.Object[]) obj;
                float[][] fArr = new float[objArr.length][];
                int length = objArr.length;
                int i_renamed = 0;
                int i2 = 0;
                while (i_renamed < length) {
                    fArr[i2] = (float[]) objArr[i_renamed];
                    i_renamed++;
                    i2++;
                }
                if (vVar == null) {
                    return fArr;
                }
                vVar.a_renamed(str, fArr);
                return fArr;
            }
            if (vVar != null) {
                vVar.a_renamed(str, obj);
            }
        }
        return obj;
    }

    public static void a_renamed(java.util.Map<java.lang.String, java.lang.Object> map) {
        map.clear();
        map.put("local_adjustments", new java.util.ArrayList());
        java.lang.Object objValueOf = java.lang.Float.valueOf(0.0f);
        map.put("rotation", objValueOf);
        map.put("rotate90", objValueOf);
        map.put("flip_y", false);
        map.put("flip_x", false);
        map.put("crop", new float[]{0.0f, 0.0f, 1.0f, 1.0f});
        map.put("distortion_mesh", null);
        map.put("distortion_amount", objValueOf);
        map.put("fringing", objValueOf);
        map.put("distortion_horizontal", objValueOf);
        map.put("distortion_vertical", objValueOf);
        map.put("blur_opacity", java.lang.Float.valueOf(1.0f));
        map.put("color_denoise", objValueOf);
        map.put("luminance_denoise", objValueOf);
        map.put("dehaze", objValueOf);
        map.put("grid_size", new float[]{0.0f, 0.0f});
        map.put(com.oplus.camera.statistics.CameraStatisticsUtil.PORTRAIT_BLUR, objValueOf);
        map.put("diffuse", objValueOf);
        map.put("temperature", objValueOf);
        map.put("tint", objValueOf);
        map.put("exposure", objValueOf);
        map.put("gamma", objValueOf);
        map.put("contrast", objValueOf);
        map.put("highlights", objValueOf);
        map.put("shadows", objValueOf);
        map.put("whites", objValueOf);
        map.put("blacks", objValueOf);
        map.put("clarity", objValueOf);
        map.put("saturation", objValueOf);
        map.put("vibrance", objValueOf);
        map.put("curves_red", new float[][]{new float[]{0.0f, 0.0f}, new float[]{255.0f, 255.0f}});
        map.put("curves_green", new float[][]{new float[]{0.0f, 0.0f}, new float[]{255.0f, 255.0f}});
        map.put("curves_blue", new float[][]{new float[]{0.0f, 0.0f}, new float[]{255.0f, 255.0f}});
        map.put("curves_all", new float[][]{new float[]{0.0f, 0.0f}, new float[]{255.0f, 255.0f}});
        map.put("hue_red", objValueOf);
        map.put("hue_orange", objValueOf);
        map.put("hue_yellow", objValueOf);
        map.put("hue_green", objValueOf);
        map.put("hue_aqua", objValueOf);
        map.put("hue_blue", objValueOf);
        map.put("hue_purple", objValueOf);
        map.put("hue_magenta", objValueOf);
        map.put("saturation_red", objValueOf);
        map.put("saturation_orange", objValueOf);
        map.put("saturation_yellow", objValueOf);
        map.put("saturation_green", objValueOf);
        map.put("saturation_aqua", objValueOf);
        map.put("saturation_blue", objValueOf);
        map.put("saturation_purple", objValueOf);
        map.put("saturation_magenta", objValueOf);
        map.put("luminance_red", objValueOf);
        map.put("luminance_orange", objValueOf);
        map.put("luminance_yellow", objValueOf);
        map.put("luminance_green", objValueOf);
        map.put("luminance_aqua", objValueOf);
        map.put("luminance_blue", objValueOf);
        map.put("luminance_purple", objValueOf);
        map.put("luminance_magenta", objValueOf);
        map.put("highlights_hue", objValueOf);
        map.put("highlights_saturation", objValueOf);
        map.put("shadows_hue", objValueOf);
        map.put("shadows_saturation", objValueOf);
        map.put("balance", objValueOf);
        map.put("sharpen", objValueOf);
        map.put("grain_amount", objValueOf);
        map.put("grain_size", java.lang.Float.valueOf(0.25f));
        map.put("mosaic_size", objValueOf);
        map.put("vignette_amount", objValueOf);
        java.lang.Object objValueOf2 = java.lang.Float.valueOf(0.9f);
        map.put("vignette_feather", objValueOf2);
        map.put("vignette_highlights", java.lang.Float.valueOf(0.5f));
        map.put("vignette_roundness", java.lang.Float.valueOf(-0.3f));
        map.put("vignette_size", objValueOf2);
        map.put(com.google.android.exoplayer2.util.MimeTypes.BASE_TYPE_TEXT, new java.util.ArrayList());
        map.put("textInvertedColor", new float[]{1.0f, 1.0f, 1.0f, 1.0f});
        map.put("textInverted", false);
        map.put("faces", new java.util.ArrayList());
        map.put("face_features", new java.util.ArrayList());
        map.put("spots", new java.util.ArrayList());
    }
}
