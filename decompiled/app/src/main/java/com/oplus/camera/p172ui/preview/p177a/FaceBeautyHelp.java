package com.oplus.camera.p172ui.preview.p177a;

import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.statistics.model.DcsMsgData;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/* compiled from: FaceBeautyHelp.java */
/* renamed from: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public class FaceBeautyHelp {

    /* renamed from: PlatformImplementations.kt_3 */
    public static final int[] f21226a = {0, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70};

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static List<String> f21227b = new ArrayList();

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static List<String> f21228c = new ArrayList();

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static List<String> f21229d = new ArrayList();

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static List<String> f21230e = new ArrayList();

    /* renamed from: COUIBaseListPopupWindow_12 */
    public static List<String> f21231f = new ArrayList();

    /* renamed from: PlatformImplementations.kt_3 */
    public static String m22551a(boolean z) {
        return z ? "1" : "0";
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m22552a() {
        if (f21227b.size() != 0) {
            return;
        }
        f21227b.add("none");
        f21227b.add("rosy_nude");
        f21227b.add("orange_crush");
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_CUSTOM_MAKEUP_TYPE_SNOW)) {
            f21227b.add("snow");
        }
        f21227b.add("first_love");
        f21227b.add("peach_pink");
        f21227b.add("red_velvet");
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_CUSTOM_MAKEUP_TYPE_DREAM)) {
            f21227b.add("dream");
        }
        f21227b.add("sparkling_sea");
        f21227b.add("unique_eyes");
        f21227b.add("midnight");
        f21227b.add("violet_shimmer");
        f21227b.add("smokey");
        f21227b.add("groomed");
        DcsMsgData.initMakeupList();
        f21227b.forEach(new Consumer() { // from class: com.oplus.camera.ui.preview.PlatformImplementations.kt_3.-$$Lambda$COUIBaseListPopupWindow_11$EGpQOOSc1UA87V795W9xaDIp9ZE
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                FaceBeautyHelp.m22553a((String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public static /* synthetic */ void m22553a(String str) {
        f21228c.add("key_beauty_common_makeup_" + str);
        f21229d.add("key_beauty_portrait_makeup_" + str);
        f21230e.add("key_beauty_video_makeup_" + str);
        f21231f.add("key_beauty_night_makeup_" + str);
    }
}
