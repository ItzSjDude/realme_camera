package co.polarr.renderer;

import android.content.res.AssetManager;
import android.content.res.Resources;
import co.polarr.renderer.entities.Adjustment;
import co.polarr.renderer.entities.Context;
import co.polarr.renderer.entities.Cube;
import co.polarr.renderer.entities.FilterItem;
import co.polarr.renderer.entities.FilterPackage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p000a.p001a.p003b.C0101e;
import p000a.p001a.p003b.C0106f;
import p000a.p001a.p003b.p010f.C0109b;
import p000a.p001a.p003b.p010f.C0123p;

/* loaded from: classes.dex */
public class FilterPackageUtil {
    public static final String CUBE_BASE = "cubes/";
    public static final String CUBE_EXT = ".cube";
    public static final String DUAL_LUT_PIX_A = "DL_A";
    public static final String DUAL_LUT_PIX_B = "DL_B";
    public static final String FILTER_FILE = "filters_johnny_32.json";
    public static final String F_DEFAULT = "default";
    public static final String LUT_BASE = "luts/";

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static String f5073b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static String f5074c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static FilterPackage f5075d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static Map<String, Cube> f5076e;
    public static final String F_COMMON_1 = "SkpZ8ebbz";
    public static final String F_COMMON_2 = "Syt2KeZZf";
    public static final String F_COMMON_3 = "r1JaFSZZG";
    public static final String F_COMMON_4 = "BycYf7WWz";
    public static final String F_COMMON_5 = "ByYo3If";
    public static final String F_COMMON_6 = "rJ5g5vPWG";
    public static final String F_FRONT_1 = "BJJAwoigM";
    public static final String F_FRONT_2 = "rkMhq4ZWf";
    public static final String F_FRONT_3 = "B1aMqioxf";
    public static final String F_FRONT_4 = "BJyKIwqxz";
    public static final String F_FRONT_5 = "r1PrfoolG";
    public static final String F_BACK_1 = "B1si_XbZz";
    public static final String F_BACK_2 = "B1nmcmWbG";
    public static final String F_BACK_3 = "ByW7g4bbf";
    public static final String F_BACK_4 = "EyxRbD2UCe";
    public static final String F_BACK_5 = "rkx5u4Zbf";
    public static final String F_MODE_1 = "Sy4uLSTgf";
    public static final String F_MODE_2 = "rJxJtmaez";
    public static final String F_MODE_3 = "B1VLf4peM";
    public static final String F_MODE_4 = "SJ3mbr6ef";
    public static final String F_CUBE_2018_0 = "f_japan_strong.cube.rgb.bin";
    public static final String F_CUBE_2018_6 = "f_fuji_strong.cube.rgb.bin";
    public static final String F_CUBE_2018_7 = "f_candy_water_weak.cube.rgb.bin";
    public static final String F_CUBE_2018_8 = "f_bin_hideaki";
    public static final String F_CUBE_2018_11 = "f_contrast_gray_face_dark";
    public static final String PORTRAIT4_1 = "p4_1.cube.rgb.bin";
    public static final String PORTRAIT4_1B = "p4_1b.cube.rgb.bin";
    public static final String PORTRAIT4_1C = "p4_1c.cube.rgb.bin";
    public static final String PORTRAIT4_2 = "p4_2.cube.rgb.bin";
    public static final String PORTRAIT4_3 = "p4_3.cube.rgb.bin";
    public static final String PORTRAIT4_4 = "p4_4.cube.rgb.bin";
    public static final String BOWU_2020 = "bowu-2.1.cube.rgb.bin";
    public static final String JIARI_2020 = "jiari-2.0.cube.rgb.bin";
    public static final String LVTU_2020 = "lvtu-2.0.cube.rgb.bin";
    public static final String MEIWEI_2020 = "meiwei-2.2.cube.rgb.bin";
    public static final String QIURI_2020 = "qiuri-2.0.cube.rgb.bin";
    public static final String SENLIN_2020 = "senlin-2.0.cube.rgb.bin";
    public static final String YUANQI_2020 = "yuanqi-2.2s.cube.rgb.bin";
    public static final String SKY_BLUE_2020 = "sky-blue.cube.rgb.bin";
    public static final String TREE_GREEN_2020 = "tree-green.cube.rgb.bin";
    public static final String RED_RED_2020 = "red-red.cube.rgb.bin";
    public static final String G_SSX04_2020 = "G-SSX04-1.1.CUBE.rgb.bin";
    public static final String G_GR3SLIDE_2020 = "G-GR3Slide-1.1.CUBE.rgb.bin";
    public static final String G_GR3HC_2020 = "DL_A_G-GR3HC-2.2-softcut.CUBE.rgb.bin";
    public static final String OPLUS_R_BLACK_GOLD_2020 = "oplus-r-black-gold-1.1-RGB.CUBE.rgb.bin";
    public static final String OPLUS_R_CYBERPUNK_2020 = "oplus-r-cyberpunk-RGB.CUBE.rgb.bin";
    public static final String OPLUS_R_INFRA_2020 = "oplus-r-infra-RGB.CUBE.rgb.bin";

    /* renamed from: PlatformImplementations.kt_3 */
    public static final String[] f5072a = {"default", F_COMMON_1, F_COMMON_2, F_COMMON_3, F_COMMON_4, F_COMMON_5, F_COMMON_6, F_FRONT_1, F_FRONT_2, F_FRONT_3, F_FRONT_4, F_FRONT_5, F_BACK_1, F_BACK_2, F_BACK_3, F_BACK_4, F_BACK_5, F_MODE_1, F_MODE_2, F_MODE_3, F_MODE_4, F_CUBE_2018_0, F_CUBE_2018_6, F_CUBE_2018_7, F_CUBE_2018_8, F_CUBE_2018_11, PORTRAIT4_1, PORTRAIT4_1B, PORTRAIT4_1C, PORTRAIT4_2, PORTRAIT4_3, PORTRAIT4_4, BOWU_2020, JIARI_2020, LVTU_2020, MEIWEI_2020, QIURI_2020, SENLIN_2020, YUANQI_2020, SKY_BLUE_2020, TREE_GREEN_2020, RED_RED_2020, G_SSX04_2020, G_GR3SLIDE_2020, G_GR3HC_2020, OPLUS_R_BLACK_GOLD_2020, OPLUS_R_CYBERPUNK_2020, OPLUS_R_INFRA_2020};

    public class porender_YuvEf extends LinkedHashMap<String, String> {
        public porender_YuvEf() {
            put("F_COMMON_1", FilterPackageUtil.F_COMMON_1);
            put("F_COMMON_3", FilterPackageUtil.F_COMMON_3);
            put("F_COMMON_4", FilterPackageUtil.F_COMMON_4);
            put("F_COMMON_5", FilterPackageUtil.F_COMMON_5);
            put("F_BACK_2", FilterPackageUtil.F_BACK_2);
            put("F_BACK_3", FilterPackageUtil.F_BACK_3);
            put("BOWU_2020", FilterPackageUtil.BOWU_2020);
            put("JIARI_2020", FilterPackageUtil.JIARI_2020);
            put("LVTU_2020", FilterPackageUtil.LVTU_2020);
            put("MEIWEI_2020", FilterPackageUtil.MEIWEI_2020);
            put("QIURI_2020", FilterPackageUtil.QIURI_2020);
            put("SENLIN_2020", FilterPackageUtil.SENLIN_2020);
            put("YUANQI_2020", FilterPackageUtil.YUANQI_2020);
            put("G_SSX04_2020", FilterPackageUtil.G_SSX04_2020);
            put("G_GR3SLIDE_2020", FilterPackageUtil.G_GR3SLIDE_2020);
            put("G_GR3HC_2020", FilterPackageUtil.G_GR3HC_2020);
            put("OPLUS_R_BLACK_GOLD_2020", FilterPackageUtil.OPLUS_R_BLACK_GOLD_2020);
            put("OPLUS_R_CYBERPUNK_2020", FilterPackageUtil.OPLUS_R_CYBERPUNK_2020);
            put("OPLUS_R_INFRA_2020", FilterPackageUtil.OPLUS_R_INFRA_2020);
        }
    }

    static {
        new porender_YuvEf();
        f5073b = "videofilter_lut/";
        f5074c = null;
        f5076e = new HashMap();
    }

    public static List<FilterPackage> GetAllFilters(Resources resources) {
        C0101e.m438a().m441c();
        return C0101e.m438a().m440b();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as PlatformImplementations.kt_3 decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Map<java.lang.String, java.lang.Object> GetFilterStates(co.polarr.renderer.entities.FilterItem r7, float r8) {
        /*
            Method dump skipped, instructions count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: co.polarr.renderer.FilterPackageUtil.GetFilterStates(co.polarr.renderer.entities.FilterItem, float):java.util.Map");
    }

    public static Map<String, Object> GetRefStates(Map<String, Object> map, float COUIBaseListPopupWindow_12) {
        return m5384a(map, Math.min(1.0f, Math.max(0.0f, COUIBaseListPopupWindow_12)) * 2.0f);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Cube m5383a(String str) {
        try {
            if (f5074c == null) {
                return null;
            }
            Cube cubeFromRaw = Cube.fromRaw(new FileInputStream(new File(f5074c, str)), str);
            f5076e.put(cubeFromRaw.filterID, cubeFromRaw);
            return cubeFromRaw;
        } catch (IOException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as PlatformImplementations.kt_3 decompilation issue */
    /* renamed from: PlatformImplementations.kt_3 */
    public static Map<String, Object> m5384a(Map<String, Object> map, float COUIBaseListPopupWindow_12) throws IllegalAccessException, SecurityException, IllegalArgumentException {
        ArrayList arrayList;
        float fM569a;
        float fMin;
        float f2;
        Map<String, Object> map2 = map;
        HashMap map3 = new HashMap();
        float f3 = 1.0f;
        if (COUIBaseListPopupWindow_12 == 1.0f) {
            map3.putAll(map2);
            return map3;
        }
        Map<String, Object> map4 = C0106f.f516a;
        for (String str : map.keySet()) {
            Object objValueOf = map2.get(str);
            if (objValueOf instanceof Float) {
                if (map4.containsKey(str)) {
                    Float f4 = (Float) objValueOf;
                    float fFloatValue = f4.floatValue();
                    if (map4.get(str) instanceof Float) {
                        fFloatValue = ((Float) map4.get(str)).floatValue();
                    }
                    float fM569a2 = C0123p.m569a(COUIBaseListPopupWindow_12, fFloatValue, f4.floatValue());
                    if ("shadows".equals(str)) {
                        fMin = Math.min(fM569a2, 1.5f);
                        f2 = -1.5f;
                    } else {
                        fMin = Math.min(fM569a2, f3);
                        f2 = -1.0f;
                    }
                    fM569a = Math.max(fMin, f2);
                } else if ("lookup_intensity".equals(str)) {
                    fM569a = C0123p.m569a(COUIBaseListPopupWindow_12, 0.0f, ((Float) objValueOf).floatValue());
                }
                objValueOf = Float.valueOf(fM569a);
            } else {
                char c2 = 65535;
                int OplusGLSurfaceView_13 = 0;
                switch (str.hashCode()) {
                    case -1917275032:
                        if (str.equals("curves_green")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -1829931962:
                        if (str.equals("curves_all")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -1829915850:
                        if (str.equals("curves_red")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -893285803:
                        if (str.equals("curves_blue")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case -366660142:
                        if (str.equals("local_adjustments")) {
                            c2 = 4;
                            break;
                        }
                        break;
                }
                if (c2 == 0 || c2 == 1 || c2 == 2 || c2 == 3) {
                    if (objValueOf instanceof float[][]) {
                        float[][] fArr = (float[][]) objValueOf;
                        float[][] fArr2 = new float[fArr.length][];
                        for (int i2 = 0; i2 < fArr.length; i2++) {
                            float[] fArr3 = fArr[i2];
                            float[] fArrCopyOf = Arrays.copyOf(fArr3, fArr3.length);
                            fArr2[i2] = fArrCopyOf;
                            fArrCopyOf[1] = C0123p.m569a(COUIBaseListPopupWindow_12, fArr3[0], fArr3[1]);
                            fArrCopyOf[1] = (float) C0123p.m567a(fArrCopyOf[1], 0.0d, 255.0d);
                        }
                        map3.put(str, fArr2);
                    }
                } else if (c2 == 4 && (objValueOf instanceof ArrayList) && (arrayList = (ArrayList) objValueOf) != null && !arrayList.isEmpty() && (arrayList.get(0) instanceof Adjustment)) {
                    ArrayList arrayList2 = new ArrayList();
                    int i3 = 0;
                    while (i3 < arrayList.size()) {
                        Adjustment adjustment = (Adjustment) arrayList.get(i3);
                        Adjustment adjustment2 = (Adjustment) C0109b.m465a(C0109b.m466a(adjustment), Adjustment.class);
                        Context.LocalState localState = new Context.LocalState();
                        Field[] fields = Context.LocalState.class.getFields();
                        int length = fields.length;
                        while (OplusGLSurfaceView_13 < length) {
                            Field field = fields[OplusGLSurfaceView_13];
                            int i4 = length;
                            if (field.getType() == Float.TYPE) {
                                try {
                                    field.setFloat(adjustment2.adjustments, C0123p.m569a(COUIBaseListPopupWindow_12, field.getFloat(localState), field.getFloat(adjustment.adjustments)));
                                } catch (Exception COUIBaseListPopupWindow_8) {
                                    COUIBaseListPopupWindow_8.printStackTrace();
                                }
                            }
                            OplusGLSurfaceView_13++;
                            length = i4;
                        }
                        arrayList2.add(adjustment2);
                        i3++;
                        OplusGLSurfaceView_13 = 0;
                    }
                    map3.put(str, arrayList2);
                }
                f3 = 1.0f;
                map2 = map;
            }
            map3.put(str, objValueOf);
            f3 = 1.0f;
            map2 = map;
        }
        return map3;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static boolean m5385a(String str, String str2) {
        Map<String, Object> map;
        FilterItem filterItemM439a = C0101e.m438a().m439a(str);
        return (filterItemM439a == null || (map = filterItemM439a.state) == null || !map.containsKey(str2) || ((Float) filterItemM439a.state.get(str2)).floatValue() == 0.0f) ? false : true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static String[] m5386a(AssetManager assetManager, String str) throws IOException {
        try {
            if (!str.startsWith(DUAL_LUT_PIX_A)) {
                return null;
            }
            String strReplaceFirst = str.replaceFirst(DUAL_LUT_PIX_A, DUAL_LUT_PIX_B);
            InputStream inputStreamOpen = assetManager.open(LUT_BASE + strReplaceFirst);
            if (inputStreamOpen.available() <= 0) {
                return null;
            }
            inputStreamOpen.close();
            return new String[]{str, strReplaceFirst};
        } catch (FileNotFoundException unused) {
            return null;
        } catch (IOException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return null;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static Cube m5387b(AssetManager assetManager, String str) {
        if (f5076e.containsKey(str)) {
            return f5076e.get(str);
        }
        if (str == null) {
            return null;
        }
        try {
            Cube cubeM5383a = m5383a(str);
            if (cubeM5383a != null) {
                return cubeM5383a;
            }
            return Cube.fromRaw(assetManager.open(LUT_BASE + str), str);
        } catch (FileNotFoundException unused) {
            return m5389c(assetManager, str);
        } catch (IOException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return null;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static boolean m5388b(String str) {
        int OplusGLSurfaceView_13 = 0;
        while (true) {
            String[] strArr = f5072a;
            if (OplusGLSurfaceView_13 >= strArr.length) {
                return false;
            }
            if (strArr[OplusGLSurfaceView_13].equals(str)) {
                return true;
            }
            OplusGLSurfaceView_13++;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static Cube m5389c(AssetManager assetManager, String str) {
        try {
            Cube cubeFromRaw = Cube.fromRaw(assetManager.open(f5073b + str), str);
            if (cubeFromRaw != null) {
                f5076e.put(cubeFromRaw.filterID, cubeFromRaw);
            }
            return cubeFromRaw;
        } catch (IOException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
            return null;
        }
    }

    public static FilterPackage getLoadedLuts() {
        FilterPackage filterPackage;
        synchronized (FilterPackageUtil.class) {
            try {
                if (f5075d == null || f5075d.filters == null) {
                    f5075d = new FilterPackage();
                    f5075d.filters = new ArrayList();
                }
                filterPackage = f5075d;
            } finally {
            }
        }
        return filterPackage;
    }

    public static String loadLutBinary(InputStream inputStream, String str) {
        String str2;
        synchronized (FilterPackageUtil.class) {
            try {
                Cube cubeFromInputStream = Cube.fromInputStream(inputStream, str);
                FilterItem filterItem = new FilterItem();
                filterItem.f5145id = cubeFromInputStream.filterID;
                filterItem.name = "" + filterItem.f5145id;
                getLoadedLuts().filters.add(filterItem);
                f5076e.put(str, cubeFromInputStream);
                str2 = cubeFromInputStream.filterID;
            } catch (Exception unused) {
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }

    public static void setLutAssetsPath(String str) {
        f5073b = str;
    }

    public static void setStaticLUTPath(String str) {
        f5074c = str;
    }
}
