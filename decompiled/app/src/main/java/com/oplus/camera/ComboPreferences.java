package com.oplus.camera;

import android.content.Context;
import android.content.SharedPreferences;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.entry.CameraEntry;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.preview.p177a.FaceBeautyHelp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class ComboPreferences implements SharedPreferences, SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final WeakHashMap<Context, ComboPreferences> f11217a = new WeakHashMap<>();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static HashMap<String, Boolean> f11218b = new HashMap<>();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static HashMap<String, Boolean> f11219c = new HashMap<>();

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static HashMap<String, Boolean> f11220d = new HashMap<>();

    /* renamed from: COUIBaseListPopupWindow_8 */
    private SharedPreferences f11221e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private SharedPreferences f11222f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private CopyOnWriteArrayList<SharedPreferences.OnSharedPreferenceChangeListener> f11223g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private CameraEntry f11224h;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f11225i = 1;

    public ComboPreferences(Context context) {
        this.f11224h = null;
        this.f11221e = context.getSharedPreferences(context.getPackageName() + "_preferences", 0);
        this.f11221e.registerOnSharedPreferenceChangeListener(this);
        if (context instanceof Camera) {
            this.f11224h = ((Camera) context).m9565k();
        }
        synchronized (f11217a) {
            f11217a.put(context, this);
        }
        this.f11223g = new CopyOnWriteArrayList<>();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m11065a(String[] strArr, HashMap<String, Boolean> map) {
        if (strArr == null || strArr.length <= 0 || map == null) {
            return;
        }
        for (String str : strArr) {
            map.put(str, true);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m11064a(List<String> list, HashMap<String, Boolean> map) {
        if (list == null || list.size() <= 0 || map == null) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            map.put(it.next(), true);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m11061a() {
        if (f11219c.isEmpty()) {
            f11219c.put(CameraUIInterface.KEY_CAMERA_ID, true);
            f11219c.put(CameraUIInterface.KEY_RECORD_LOCATION, true);
            f11219c.put(CameraUIInterface.KEY_CAMERA_SOUND, true);
            f11219c.put(CameraUIInterface.KEY_STORAGE_PLACE, true);
            f11219c.put(CameraUIInterface.KEY_CAMERA_FINGERPRINT_SHUTTER, true);
            f11219c.put(CameraUIInterface.KEY_ASSISTANT_LINE, true);
            f11219c.put("pref_allow_network_access", true);
            f11219c.put("pref_camera_statement_key", true);
            f11219c.put("pref_camera_statement_agree", true);
            f11219c.put(CameraUIInterface.KEY_VOLUME_KEY_FUNCTION, true);
            f11219c.put(CameraUIInterface.KEY_MIRROR, true);
            f11219c.put(CameraUIInterface.KEY_LENS_DIRTY_DETECTION, true);
            f11219c.put(CameraUIInterface.KEY_SHARE_AND_MARK, true);
            f11219c.put(CameraUIInterface.KEY_CAMERA_GESTURE_SHUTTER, true);
            f11219c.put(CameraUIInterface.KEY_SLOGAN_OWNER, true);
            f11219c.put("pref_slogan_market_name", true);
            f11219c.put("pref_video_slogan_market_name", true);
            f11219c.put("pref_slogan_version", true);
            f11219c.put("pref_slogan_customize", true);
            f11219c.put("pref_video_slogan_customize", true);
            f11219c.put(CameraUIInterface.KEY_BUBBLE_STICKER, true);
            f11219c.put(CameraUIInterface.KEY_BUBBLE_TYPE_MULTI_VIDEO, true);
            f11219c.put(CameraUIInterface.KEY_BUBBLE_TYPE_AI_ENHANCEMENT_VIDEO, true);
            f11219c.put(CameraUIInterface.KEY_SUPER_EIS_WIDE_TIPS, true);
            f11219c.put(CameraUIInterface.KEY_BUBBLE_SHORT_VIDEO, true);
            f11219c.put(CameraUIInterface.KEY_AI_SCN, true);
            f11219c.put(CameraUIInterface.KEY_PI_AI, true);
            f11219c.put(CameraUIInterface.KEY_FACE_RECTIFY, true);
            f11219c.put(CameraUIInterface.KEY_TRACK_FOCUS, true);
            f11219c.put(CameraUIInterface.KEY_INERTIAL_ZOOM, true);
            f11219c.put(CameraUIInterface.KEY_PHOTO_RATIO, true);
            f11219c.put(CameraUIInterface.KEY_RAW, true);
            f11219c.put(CameraUIInterface.KEY_VIDEO_FILTER_MENU, true);
            f11219c.put(CameraUIInterface.KEY_LAST_CAMERA_GESTURE_SHUTTER, true);
            f11219c.put(CameraUIInterface.KEY_LAST_CAMERA_TAP_SHUTTER, true);
            f11219c.put(CameraUIInterface.KEY_GRADIENTER, true);
            f11219c.put(CameraUIInterface.KEY_CAMERA_TIMER_SHUTTER, true);
            f11219c.put(CameraUIInterface.KEY_CAMERA_EXIT_TIME_STAMP, true);
            f11219c.put(CameraUIInterface.KEY_REPORT_PERMISSION_TIME_STAMP, true);
            f11219c.put(CameraUIInterface.KEY_STICKER_FILTER_INDEX, true);
            f11219c.put(CameraUIInterface.KEY_HIGH_PICTURE_SIZE, true);
            f11219c.put(CameraUIInterface.KEY_PHOTO_HIGH_RESOLUTION, true);
            f11219c.put(CameraUIInterface.KEY_CURRENT_STICKER_UUID, true);
            f11219c.put(CameraUIInterface.KEY_SLOGAN_CUSTOMIZE, true);
            f11219c.put(CameraUIInterface.KEY_LONG_PROCESS_SHUTTER_CHOICE, true);
            f11219c.put(CameraUIInterface.KEY_CAMERA_SLOGAN_VERSION, true);
            f11219c.put(CameraUIInterface.KEY_CAMERA_GRID_VERSION, true);
            f11219c.put(CameraUIInterface.KEY_SLOW_VIDEO_REAR_FPS, true);
            f11219c.put(CameraUIInterface.KEY_VIDEO_CODEC, true);
            f11219c.put(CameraUIInterface.KEY_PHOTO_CODEC, true);
            f11219c.put(CameraUIInterface.KEY_PHOTO_CODEC_CLICK, true);
            f11219c.put(CameraUIInterface.KEY_VIDEO_SELL_EIS, true);
            f11219c.put(CameraUIInterface.KEY_NONE_SAT_ULTRA_WIDE_ANGLE, true);
            f11219c.put(CameraUIInterface.KEY_PORTRAIT_HALF_BODY, true);
            f11219c.put(CameraUIInterface.KEY_PORTRAIT_HALF_BODY_REMOSAIC, true);
            f11219c.put(CameraUIInterface.KEY_SUB_SETTING, true);
            f11219c.put(CameraUIInterface.KEY_VIDEO_HYPER_LAPSE_MENU, true);
            f11219c.put(CameraUIInterface.KEY_HYPER_LAPSE_ZOOM_ULTRA_WIDE_OPEN, true);
            f11219c.put(CameraUIInterface.KEY_ASSIST_GRADIENTER, true);
            f11219c.put(CameraUIInterface.KEY_10_BITS_HEIC_ENCODE, true);
            f11219c.put(CameraUIInterface.KEY_VIDEO_FLASH_MODE, true);
            f11219c.put(CameraUIInterface.KEY_MULTI_CAMERA_TYPE_SELECTED, true);
            f11219c.put(CameraUIInterface.KEY_MULTI_VIDEO_FACEBEAUTY_LEVEL_MENU, true);
            f11219c.put(CameraUIInterface.KEY_MULTI_CAMERA_SHOW_POSITION_STATE, true);
            f11219c.put(CameraUIInterface.KEY_DRAWER_ANCHOR_TIPS, true);
            f11219c.put(CameraUIInterface.KEY_FIRST_BEAUTY_TIPS, true);
            f11219c.put(CameraUIInterface.KEY_PERMISSION_DIALOG_DISPLAYED, true);
            f11219c.put(CameraUIInterface.KEY_SHARE_EDIT_VIDEO_SHOW_EXPAND, true);
            f11219c.put(CameraUIInterface.KEY_BOTTOM_GUIDE_ID_PHOTO_FIRST_TIPS_SHOWED, true);
            f11219c.put(CameraUIInterface.KEY_BUBBLE_TYPE_ZOOM_ULTRA_WIDE, true);
            f11219c.put(CameraUIInterface.KEY_CURRENT_TEMPERATURE, true);
            f11219c.put(CameraUIInterface.KEY_FACE_RECTIFY_SET_DEFAULT_VALUE, true);
            f11219c.put(CameraUIInterface.KEY_CAMERA_PID_HISTORY, true);
            f11219c.put(CameraUIInterface.KEY_SUPPORT_FRONT_FACE_POINT_ANIMATION, true);
            f11219c.put(CameraUIInterface.KEY_DRAWER_SHOW_GUIDE_ANIMATION, true);
            f11219c.put(CameraUIInterface.KEY_AI_ENHANCEMENT_GUIDE_REMINDER_TIMES, true);
            f11219c.put(CameraUIInterface.SHOW_ARROW_ANIMATION, true);
            f11219c.put(CameraUIInterface.KEY_DOUBLE_EXPOSURE_EFFECT_TYPE, true);
            f11219c.put(CameraUIInterface.KEY_BOTTOM_GUIDE_DOUBLE_EXPOSURE, true);
            f11219c.put(CameraUIInterface.KEY_DOUBLE_EXPOSURE_TIPS, true);
            f11219c.put(CameraUIInterface.KEY_DOUBLE_EXPOSURE_OPEN_COUNT, true);
            f11219c.put(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_POSITION, true);
            f11219c.put(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FUNCTION, true);
            f11219c.put(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_AUTHOR, true);
            f11219c.put(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_FIRST_OPEN, true);
            f11219c.put(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_DISPLAY_INFO, true);
            f11219c.put(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_SIZE, true);
            f11219c.put(CameraUIInterface.PRE_KEY_WATERMARK_VISUAL_MAKEUP_FUNCTION, true);
            f11219c.put(CameraUIInterface.PRE_KEY_WATERMARK_LOCATION, true);
            f11219c.put(CameraUIInterface.PRE_KEY_WATERMARK_DATE_AND_TIME, true);
            f11219c.put(CameraUIInterface.PRE_KEY_WATERMARK_PHONE, true);
            f11219c.put(CameraUIInterface.KEY_BOTTOM_GUIDE_MAKEUP_TIPS_SHOWED, true);
            f11219c.put(CameraUIInterface.KEY_IS_ANDROID_S_DATA_MIGRATED, true);
            f11219c.put(CameraUIInterface.KEY_SUPER_CLEAR_PORTRAIT, true);
            f11219c.put(CameraUIInterface.KEY_FILTER_VERSION, true);
            f11219c.put(CameraUIInterface.PRE_MENU_FILTER_ICON_RECEOMMEND_CLICKED, false);
            f11219c.put(CameraUIInterface.PRE_FACE_BEAUTY_ICON_RECEOMMEND_CLICKED, false);
            f11219c.put(CameraUIInterface.PRE_FACE_BEAUTY_FILTER_ICON_RECEOMMEND_CLICKED, false);
            f11219c.put(CameraUIInterface.KEY_BUBBLE_STREET_ROCKER_SHUTTER, true);
            f11219c.put(CameraUIInterface.KEY_HEIF_FORMAT, true);
            f11219c.put(CameraUIInterface.KEY_MIRROR_SETTING, true);
            f11219c.put(CameraUIInterface.KEY_CAMERA_TAP_SHUTTER, true);
            f11219c.put(CameraUIInterface.KEY_HEVC_VIDEO_FORMAT, true);
            f11219c.put(CameraUIInterface.KEY_REFERENCE_LINE, true);
            f11219c.put(CameraUIInterface.KEY_OUT_PREVIEW_GUIDE, true);
            m11065a(CameraUIInterface.KEY_MULTI_VIDEO_CUSTOM_BEAUTY, f11219c);
            CameraLog.m12954a("ComboPreferences", "initFixedGlobalKeys, filled, sFixedGlobalKeys size: " + f11219c.size());
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m11062a(String str) {
        HashMap<String, Boolean> map = f11219c;
        if (map == null || map.containsKey(str)) {
            return;
        }
        f11219c.put(str, true);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static boolean m11068b(String str) {
        HashMap<String, Boolean> map;
        HashMap<String, Boolean> map2;
        m11061a();
        String strM13305d = CameraEntry.m13305d(str);
        return (CameraUIInterface.KEY_SLOW_VIDEO_SIZE.equals(strM13305d) && !CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_SUPPORT_FRONT_SLOW_VIDEO)) || ((map = f11219c) != null && map.containsKey(strM13305d)) || ((map2 = f11218b) != null && map2.containsKey(strM13305d));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public String m11073a(String str, String str2) {
        String strM11071e = m11071e(str);
        if (m11068b(str)) {
            SharedPreferences sharedPreferences = this.f11221e;
            return sharedPreferences == null ? str2 : sharedPreferences.getString(strM11071e, str2);
        }
        SharedPreferences sharedPreferences2 = this.f11222f;
        return sharedPreferences2 == null ? str2 : sharedPreferences2.getString(strM11071e, str2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m11074a(Context context) {
        m11067b(context);
        this.f11221e = null;
        this.f11222f = null;
        CopyOnWriteArrayList<SharedPreferences.OnSharedPreferenceChangeListener> copyOnWriteArrayList = this.f11223g;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
            this.f11223g = null;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m11067b(Context context) {
        synchronized (f11217a) {
            f11217a.remove(context);
        }
    }

    public void setLocalId(Context context, int OplusGLSurfaceView_13) {
        String str = context.getPackageName() + "_preferences_" + OplusGLSurfaceView_13;
        SharedPreferences sharedPreferences = this.f11222f;
        if (sharedPreferences != null) {
            sharedPreferences.unregisterOnSharedPreferenceChangeListener(this);
        }
        this.f11222f = context.getSharedPreferences(str, 0);
        this.f11222f.registerOnSharedPreferenceChangeListener(this);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public SharedPreferences m11072a(Context context, int OplusGLSurfaceView_13) {
        return context.getSharedPreferences(context.getPackageName() + "_preferences_" + OplusGLSurfaceView_13, 0);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public SharedPreferences m11075b() {
        return this.f11221e;
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m11076c(String str) {
        String strM13305d = CameraEntry.m13305d(str);
        HashMap<String, Boolean> map = f11218b;
        if (map == null || map.containsKey(strM13305d)) {
            return;
        }
        f11218b.put(strM13305d, true);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m11077d(String str) {
        String strM13305d = CameraEntry.m13305d(str);
        HashMap<String, Boolean> map = f11218b;
        if (map != null) {
            map.remove(strM13305d);
        }
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        SharedPreferences sharedPreferences;
        String strM11071e = m11071e(str);
        if (m11068b(str) || ((sharedPreferences = this.f11222f) != null && !sharedPreferences.contains(strM11071e))) {
            SharedPreferences sharedPreferences2 = this.f11221e;
            return sharedPreferences2 == null ? str2 : sharedPreferences2.getString(strM11071e, str2);
        }
        SharedPreferences sharedPreferences3 = this.f11222f;
        return sharedPreferences3 == null ? str2 : sharedPreferences3.getString(strM11071e, str2);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int OplusGLSurfaceView_13) {
        SharedPreferences sharedPreferences;
        String strM11071e = m11071e(str);
        if (m11068b(str) || ((sharedPreferences = this.f11222f) != null && !sharedPreferences.contains(strM11071e))) {
            SharedPreferences sharedPreferences2 = this.f11221e;
            return sharedPreferences2 == null ? OplusGLSurfaceView_13 : sharedPreferences2.getInt(strM11071e, OplusGLSurfaceView_13);
        }
        SharedPreferences sharedPreferences3 = this.f11222f;
        return sharedPreferences3 == null ? OplusGLSurfaceView_13 : sharedPreferences3.getInt(strM11071e, OplusGLSurfaceView_13);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long OplusGLSurfaceView_15) {
        SharedPreferences sharedPreferences;
        String strM11071e = m11071e(str);
        if (m11068b(str) || ((sharedPreferences = this.f11222f) != null && !sharedPreferences.contains(strM11071e))) {
            SharedPreferences sharedPreferences2 = this.f11221e;
            return sharedPreferences2 == null ? OplusGLSurfaceView_15 : sharedPreferences2.getLong(strM11071e, OplusGLSurfaceView_15);
        }
        SharedPreferences sharedPreferences3 = this.f11222f;
        return sharedPreferences3 == null ? OplusGLSurfaceView_15 : sharedPreferences3.getLong(strM11071e, OplusGLSurfaceView_15);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float COUIBaseListPopupWindow_12) {
        SharedPreferences sharedPreferences;
        String strM11071e = m11071e(str);
        if (m11068b(str) || ((sharedPreferences = this.f11222f) != null && !sharedPreferences.contains(strM11071e))) {
            SharedPreferences sharedPreferences2 = this.f11221e;
            return sharedPreferences2 == null ? COUIBaseListPopupWindow_12 : sharedPreferences2.getFloat(strM11071e, COUIBaseListPopupWindow_12);
        }
        SharedPreferences sharedPreferences3 = this.f11222f;
        return sharedPreferences3 == null ? COUIBaseListPopupWindow_12 : sharedPreferences3.getFloat(strM11071e, COUIBaseListPopupWindow_12);
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        SharedPreferences sharedPreferences;
        String strM11071e = m11071e(str);
        if (m11068b(str) || ((sharedPreferences = this.f11222f) != null && !sharedPreferences.contains(strM11071e))) {
            SharedPreferences sharedPreferences2 = this.f11221e;
            return sharedPreferences2 == null ? z : sharedPreferences2.getBoolean(strM11071e, z);
        }
        SharedPreferences sharedPreferences3 = this.f11222f;
        return sharedPreferences3 == null ? z : sharedPreferences3.getBoolean(strM11071e, z);
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        SharedPreferences sharedPreferences;
        String strM11071e = m11071e(str);
        if (m11068b(str) || ((sharedPreferences = this.f11222f) != null && !sharedPreferences.contains(strM11071e))) {
            SharedPreferences sharedPreferences2 = this.f11221e;
            return sharedPreferences2 == null ? set : sharedPreferences2.getStringSet(strM11071e, set);
        }
        SharedPreferences sharedPreferences3 = this.f11222f;
        return sharedPreferences3 == null ? set : sharedPreferences3.getStringSet(strM11071e, set);
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        SharedPreferences sharedPreferences;
        String strM11071e = m11071e(str);
        SharedPreferences sharedPreferences2 = this.f11222f;
        return (sharedPreferences2 != null && sharedPreferences2.contains(strM11071e)) || ((sharedPreferences = this.f11221e) != null && sharedPreferences.contains(strM11071e));
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return new SharedPreferencesEditorC2598a();
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        CopyOnWriteArrayList<SharedPreferences.OnSharedPreferenceChangeListener> copyOnWriteArrayList;
        if (onSharedPreferenceChangeListener == null || (copyOnWriteArrayList = this.f11223g) == null || copyOnWriteArrayList.contains(onSharedPreferenceChangeListener)) {
            return;
        }
        this.f11223g.add(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f11223g.remove(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        CopyOnWriteArrayList<SharedPreferences.OnSharedPreferenceChangeListener> copyOnWriteArrayList = this.f11223g;
        if (copyOnWriteArrayList != null) {
            Iterator<SharedPreferences.OnSharedPreferenceChangeListener> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                it.next().onSharedPreferenceChanged(this, str);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static void m11069c() {
        if (f11220d.isEmpty()) {
            f11220d.put(CameraUIInterface.KEY_CAMERA_MODE, true);
            f11220d.put("key_filter_index", true);
            f11220d.put(CameraUIInterface.KEY_PORTRAIT_NEW_STYLE_INDEX, true);
            f11220d.put(CameraUIInterface.KEY_STICKER_FACEBEAUTY_LEVEL_MENU, true);
            f11220d.put(CameraUIInterface.KEY_COMMON_FACEBEAUTY_LEVEL_MENU, true);
            f11220d.put(CameraUIInterface.KEY_PORTRAIT_FACEBEAUTY_LEVEL_MENU, true);
            f11220d.put(CameraUIInterface.KEY_VIDEO_FACEBEAUTY_LEVEL_MENU, true);
            f11220d.put(CameraUIInterface.KEY_NIGHT_FACEBEAUTY_LEVEL_MENU, true);
            f11220d.put(CameraUIInterface.KEY_MULTI_VIDEO_FACEBEAUTY_LEVEL_MENU, true);
            f11220d.put(CameraUIInterface.KEY_GROUPSHOT_FACEBEAUTY_LEVEL_MENU, true);
            f11220d.put(CameraUIInterface.KEY_HIGH_PICTURE_SIZE, true);
            f11220d.put(CameraUIInterface.KEY_AI_HIGH_PIXEL, true);
            m11065a(CameraUIInterface.KEY_COMMON_CUSTOM_BEAUTY, f11220d);
            m11065a(CameraUIInterface.KEY_PORTRAIT_CUSTOM_BEAUTY, f11220d);
            m11065a(CameraUIInterface.KEY_VIDEO_CUSTOM_BEAUTY, f11220d);
            m11065a(CameraUIInterface.KEY_NIGHT_CUSTOM_BEAUTY, f11220d);
            m11065a(CameraUIInterface.KEY_MULTI_VIDEO_CUSTOM_BEAUTY, f11220d);
            m11065a(CameraUIInterface.KEY_STICKER_CUSTOM_FACEBEAUTY, f11220d);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static void m11070d() {
        FaceBeautyHelp.m22552a();
        m11064a(FaceBeautyHelp.f21228c, f11220d);
        m11064a(FaceBeautyHelp.f21230e, f11220d);
        m11064a(FaceBeautyHelp.f21229d, f11220d);
        m11064a(FaceBeautyHelp.f21231f, f11220d);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m11063a(List<String> list) {
        if (list == null || list.size() <= 0 || f11220d.containsKey(list.get(0))) {
            return;
        }
        f11220d.clear();
        m11069c();
        m11070d();
        CameraLog.m12954a("ComboPreferences", "initLaunchSpecifiedKeys, filled, sLaunchSpecifiedKeys size: " + f11220d.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            f11220d.put(it.next(), true);
        }
        CameraLog.m12954a("ComboPreferences", "insertMenuPanelKeys, filled, sLaunchSpecifiedKeys size: " + f11220d.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_8 */
    public String m11071e(String str) {
        m11069c();
        if (!f11220d.containsKey(str)) {
            return str;
        }
        CameraEntry c2701b = this.f11224h;
        if (c2701b != null) {
            return CameraEntry.m13299b(str, c2701b.m13317J());
        }
        return CameraEntry.m13299b(str, this.f11225i);
    }

    /* renamed from: com.oplus.camera.ComboPreferences$PlatformImplementations.kt_3 */
    private class SharedPreferencesEditorC2598a implements SharedPreferences.Editor {

        /* renamed from: IntrinsicsJvm.kt_4 */
        private SharedPreferences.Editor f11227b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        private SharedPreferences.Editor f11228c;

        SharedPreferencesEditorC2598a() {
            if (ComboPreferences.this.f11221e != null) {
                this.f11227b = ComboPreferences.this.f11221e.edit();
            }
            if (ComboPreferences.this.f11222f != null) {
                this.f11228c = ComboPreferences.this.f11222f.edit();
            }
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            SharedPreferences.Editor editor = this.f11227b;
            boolean zCommit = editor != null ? editor.commit() : false;
            SharedPreferences.Editor editor2 = this.f11228c;
            return zCommit && (editor2 != null ? editor2.commit() : false);
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            try {
                if (this.f11227b != null) {
                    this.f11227b.apply();
                }
                if (this.f11228c != null) {
                    this.f11228c.apply();
                }
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            SharedPreferences.Editor editor = this.f11227b;
            if (editor != null) {
                editor.clear();
            }
            SharedPreferences.Editor editor2 = this.f11228c;
            if (editor2 != null) {
                editor2.clear();
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            String strM11071e = ComboPreferences.this.m11071e(str);
            SharedPreferences.Editor editor = this.f11227b;
            if (editor != null) {
                editor.remove(strM11071e);
            }
            SharedPreferences.Editor editor2 = this.f11228c;
            if (editor2 != null) {
                editor2.remove(strM11071e);
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, String str2) {
            SharedPreferences.Editor editor;
            String strM11071e = ComboPreferences.this.m11071e(str);
            if (ComboPreferences.m11068b(str) && (editor = this.f11227b) != null) {
                editor.putString(strM11071e, str2);
            } else {
                SharedPreferences.Editor editor2 = this.f11228c;
                if (editor2 != null) {
                    editor2.putString(strM11071e, str2);
                }
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int OplusGLSurfaceView_13) {
            SharedPreferences.Editor editor;
            String strM11071e = ComboPreferences.this.m11071e(str);
            if (ComboPreferences.m11068b(str) && (editor = this.f11227b) != null) {
                editor.putInt(strM11071e, OplusGLSurfaceView_13);
            } else {
                SharedPreferences.Editor editor2 = this.f11228c;
                if (editor2 != null) {
                    editor2.putInt(strM11071e, OplusGLSurfaceView_13);
                }
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long OplusGLSurfaceView_15) {
            SharedPreferences.Editor editor;
            String strM11071e = ComboPreferences.this.m11071e(str);
            if (ComboPreferences.m11068b(str) && (editor = this.f11227b) != null) {
                editor.putLong(strM11071e, OplusGLSurfaceView_15);
            } else {
                SharedPreferences.Editor editor2 = this.f11228c;
                if (editor2 != null) {
                    editor2.putLong(strM11071e, OplusGLSurfaceView_15);
                }
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float COUIBaseListPopupWindow_12) {
            SharedPreferences.Editor editor;
            String strM11071e = ComboPreferences.this.m11071e(str);
            if (ComboPreferences.m11068b(str) && (editor = this.f11227b) != null) {
                editor.putFloat(strM11071e, COUIBaseListPopupWindow_12);
            } else {
                SharedPreferences.Editor editor2 = this.f11228c;
                if (editor2 != null) {
                    editor2.putFloat(strM11071e, COUIBaseListPopupWindow_12);
                }
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            SharedPreferences.Editor editor;
            String strM11071e = ComboPreferences.this.m11071e(str);
            if (ComboPreferences.m11068b(str) && (editor = this.f11227b) != null) {
                editor.putBoolean(strM11071e, z);
            } else {
                SharedPreferences.Editor editor2 = this.f11228c;
                if (editor2 != null) {
                    editor2.putBoolean(strM11071e, z);
                }
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            SharedPreferences.Editor editor;
            String strM11071e = ComboPreferences.this.m11071e(str);
            if (ComboPreferences.m11068b(str) && (editor = this.f11227b) != null) {
                editor.putStringSet(strM11071e, set);
            } else {
                SharedPreferences.Editor editor2 = this.f11228c;
                if (editor2 != null) {
                    editor2.putStringSet(strM11071e, set);
                }
            }
            return this;
        }
    }
}
