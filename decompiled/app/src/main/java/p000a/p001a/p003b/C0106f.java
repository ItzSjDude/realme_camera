package p000a.p001a.p003b;

import com.google.android.exoplayer2.util.MimeTypes;
import com.oplus.camera.statistics.CameraStatisticsUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p000a.p001a.p003b.p005b.C0039ba;
import p000a.p001a.p003b.p005b.C0085v;
import p000a.p001a.p003b.p005b.p006a.AbstractC0008a;

/* renamed from: PlatformImplementations.kt_3.PlatformImplementations.kt_3.IntrinsicsJvm.kt_4.COUIBaseListPopupWindow_12 */
/* loaded from: classes.dex */
public class C0106f {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final Map<String, Object> f516a = new HashMap();

    static {
        m464a(f516a);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static AbstractC0008a m460a(List<? extends AbstractC0008a> list, Class cls) {
        for (AbstractC0008a abstractC0008a : list) {
            if (abstractC0008a.getClass() == cls) {
                return abstractC0008a;
            }
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Object m461a(String str, Object obj, Map<String, Object> map) {
        if (obj != null && !map.containsKey(str)) {
            map.put(str, obj);
        }
        return map.get(str);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Object m462a(String str, Map<String, Object> map) {
        return m461a(str, (Object) null, map);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Object m463a(List<? extends AbstractC0008a> list, String str, Object obj) {
        C0039ba c0039ba;
        if (C0039ba.f175r.containsKey(str) && obj != null && list != null && (c0039ba = (C0039ba) m460a(list, C0039ba.class)) != null) {
            c0039ba.mo57a(str, obj);
        }
        if (C0085v.f350r.contains(str) && obj != null) {
            C0085v c0085v = list != null ? (C0085v) m460a(list, C0085v.class) : null;
            if (obj instanceof Object[]) {
                Object[] objArr = (Object[]) obj;
                float[][] fArr = new float[objArr.length][];
                int length = objArr.length;
                int OplusGLSurfaceView_13 = 0;
                int i2 = 0;
                while (OplusGLSurfaceView_13 < length) {
                    fArr[i2] = (float[]) objArr[OplusGLSurfaceView_13];
                    OplusGLSurfaceView_13++;
                    i2++;
                }
                if (c0085v == null) {
                    return fArr;
                }
                c0085v.mo57a(str, fArr);
                return fArr;
            }
            if (c0085v != null) {
                c0085v.mo57a(str, obj);
            }
        }
        return obj;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m464a(Map<String, Object> map) {
        map.clear();
        map.put("local_adjustments", new ArrayList());
        Object objValueOf = Float.valueOf(0.0f);
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
        map.put("blur_opacity", Float.valueOf(1.0f));
        map.put("color_denoise", objValueOf);
        map.put("luminance_denoise", objValueOf);
        map.put("dehaze", objValueOf);
        map.put("grid_size", new float[]{0.0f, 0.0f});
        map.put(CameraStatisticsUtil.PORTRAIT_BLUR, objValueOf);
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
        map.put("grain_size", Float.valueOf(0.25f));
        map.put("mosaic_size", objValueOf);
        map.put("vignette_amount", objValueOf);
        Object objValueOf2 = Float.valueOf(0.9f);
        map.put("vignette_feather", objValueOf2);
        map.put("vignette_highlights", Float.valueOf(0.5f));
        map.put("vignette_roundness", Float.valueOf(-0.3f));
        map.put("vignette_size", objValueOf2);
        map.put(MimeTypes.BASE_TYPE_TEXT, new ArrayList());
        map.put("textInvertedColor", new float[]{1.0f, 1.0f, 1.0f, 1.0f});
        map.put("textInverted", false);
        map.put("faces", new ArrayList());
        map.put("face_features", new ArrayList());
        map.put("spots", new ArrayList());
    }
}
