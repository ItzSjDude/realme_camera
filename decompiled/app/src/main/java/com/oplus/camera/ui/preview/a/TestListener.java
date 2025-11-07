package com.oplus.camera.ui.preview.a_renamed;

/* compiled from: FaceBeautyHelp.java */
/* loaded from: classes2.dex */
public class g_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static final int[] f6895a = {0, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70, 70};

    /* renamed from: b_renamed, reason: collision with root package name */
    public static java.util.List<java.lang.String> f6896b = new java.util.ArrayList();

    /* renamed from: c_renamed, reason: collision with root package name */
    public static java.util.List<java.lang.String> f6897c = new java.util.ArrayList();
    public static java.util.List<java.lang.String> d_renamed = new java.util.ArrayList();
    public static java.util.List<java.lang.String> e_renamed = new java.util.ArrayList();
    public static java.util.List<java.lang.String> f_renamed = new java.util.ArrayList();

    public static java.lang.String a_renamed(boolean z_renamed) {
        return z_renamed ? "1" : "0";
    }

    public static void a_renamed() {
        if (f6896b.size() != 0) {
            return;
        }
        f6896b.add("none");
        f6896b.add("rosy_nude");
        f6896b.add("orange_crush");
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_CUSTOM_MAKEUP_TYPE_SNOW)) {
            f6896b.add("snow");
        }
        f6896b.add("first_love");
        f6896b.add("peach_pink");
        f6896b.add("red_velvet");
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_CUSTOM_MAKEUP_TYPE_DREAM)) {
            f6896b.add("dream");
        }
        f6896b.add("sparkling_sea");
        f6896b.add("unique_eyes");
        f6896b.add("midnight");
        f6896b.add("violet_shimmer");
        f6896b.add("smokey");
        f6896b.add("groomed");
        com.oplus.camera.statistics.model.DcsMsgData.initMakeupList();
        f6896b.forEach(new java.util.function.Consumer() { // from class: com.oplus.camera.ui.preview.a_renamed.-$$Lambda$g_renamed$EGpQOOSc1UA87V795W9xaDIp9ZE
            @Override // java.util.function.Consumer
            public final void accept(java.lang.Object obj) {
                com.oplus.camera.ui.preview.a_renamed.g_renamed.a_renamed((java.lang.String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a_renamed(java.lang.String str) {
        f6897c.add("key_beauty_common_makeup_" + str);
        d_renamed.add("key_beauty_portrait_makeup_" + str);
        e_renamed.add("key_beauty_video_makeup_" + str);
        f_renamed.add("key_beauty_night_makeup_" + str);
    }
}
