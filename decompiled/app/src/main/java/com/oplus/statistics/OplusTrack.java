package com.oplus.statistics;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.oplus.statistics.p199a.AtomAgent;
import com.oplus.statistics.p199a.CommonAgent;
import com.oplus.statistics.p199a.DebugAgent;
import com.oplus.statistics.p199a.OnEventAgent;
import com.oplus.statistics.p199a.PageVisitAgent;
import com.oplus.statistics.p199a.StaticPeriodDataRecord;
import com.oplus.statistics.p200b.CommonBatchBean;
import com.oplus.statistics.p200b.CommonBean;
import com.oplus.statistics.p200b.PeriodDataBean;
import com.oplus.statistics.p200b.SettingKeyBean;
import com.oplus.statistics.p200b.SettingKeyDataBean;
import com.oplus.statistics.p201c.AppLifecycleCallbacks;
import com.oplus.statistics.p202d.PreferenceHandler;
import com.oplus.statistics.p203e.ChattyEventTracker;
import com.oplus.statistics.p203e.RequestFireWall;
import com.oplus.statistics.p203e.WorkThread;
import com.oplus.statistics.p204f.ApkInfoUtil;
import com.oplus.statistics.p204f.LogUtil;
import com.oplus.statistics.p204f.VersionUtil;
import com.oplus.statistics.p204f.Supplier;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: OplusTrack.java */
/* renamed from: com.oplus.statistics.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class OplusTrack {
    private static final String CLIENT_START = "ClientStart";
    private static final int FIREWALL_LIMIT = 120;
    public static final int FLAG_SEND_TO_ATOM = 2;
    public static final int FLAG_SEND_TO_DCS = 1;
    private static final int MAX_EVENT_COUNT = 10000;
    private static final int MIN_EVENT_COUNT = 1;
    private static final String TAG = "OplusTrack";
    private static volatile StatisticsExceptionHandler sExceptionHandler;
    private static final Pattern EVENTID_PATTERN = Pattern.compile("^[PlatformImplementations.kt_3-zA-Z0-9\\_\\-]{1,64}$");
    private static final PageVisitAgent sPageVisitAgent = new PageVisitAgent();
    private static final long FIREWALL_LIMIT_TIME = 120000;
    private static final RequestFireWall sFireWall = new RequestFireWall.PlatformImplementations.kt_3(120, FIREWALL_LIMIT_TIME).m25408a();

    static /* synthetic */ String lambda$formatCheck$27() {
        return "EventID is null!";
    }

    static /* synthetic */ String lambda$formatCheck$28() {
        return "EventID format error!";
    }

    static /* synthetic */ String lambda$formatCheck$29() {
        return "EventTag format error!";
    }

    static /* synthetic */ String lambda$formatCheck$30() {
        return "EventCount format error!";
    }

    static /* synthetic */ String lambda$init$0() {
        return "AppCode is empty.";
    }

    static /* synthetic */ String lambda$onError$21() {
        return "onError...";
    }

    static /* synthetic */ String lambda$onPause$19() {
        return "onPause...";
    }

    static /* synthetic */ String lambda$onResume$20() {
        return "onResume...";
    }

    static /* synthetic */ String lambda$onSettingKeyUpdate$7() {
        return "Send data failed! logTag is null.";
    }

    static /* synthetic */ String lambda$removeSsoID$26() {
        return "removeSsoID";
    }

    public static void init(Context context) {
        init(context, null);
    }

    public static void init(Context context, OTrackConfig c3720b) {
        init(context, ApkInfoUtil.m25426d(context), c3720b);
    }

    public static void init(Context context, String str, OTrackConfig c3720b) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            AppLifecycleCallbacks.m25324a().m25327a((Application) applicationContext);
        }
        if (TextUtils.isEmpty(str)) {
            LogUtil.m25431b(TAG, new Supplier() { // from class: com.oplus.statistics.-$$Lambda$IntrinsicsJvm.kt_5$hV76rl-7SP49z_3P6vtPV8EJQBM
                @Override // com.oplus.statistics.p204f.Supplier
                public final Object get() {
                    return OplusTrack.lambda$init$0();
                }
            });
        }
        ApkInfoUtil.m25423a(context, str);
        OTrackContext.m25321a(str, context, c3720b);
        if (c3720b != null) {
            LogUtil.m25429a(c3720b.m25258a() == 1);
        }
    }

    public static boolean onCommon(Context context, String str, String str2, Map<String, String> map) {
        CommonBean c3724d = new CommonBean(context);
        c3724d.m25283b(str);
        c3724d.m25281a(str2);
        c3724d.m25282a(map);
        return onCommon(c3724d, 1);
    }

    public static boolean onCommonBatch(Context context, String str, String str2, List<Map<String, String>> list, int OplusGLSurfaceView_13) throws DataOverSizeException {
        return onCommonBatch(context, "", str, str2, list, OplusGLSurfaceView_13);
    }

    public static boolean onCommonBatch(Context context, String str, String str2, String str3, List<Map<String, String>> list, int OplusGLSurfaceView_13) throws DataOverSizeException {
        CommonBatchBean c3723c = new CommonBatchBean(context);
        c3723c.m25314d(str);
        c3723c.m25283b(str2);
        c3723c.m25281a(str3);
        c3723c.m25278a(list);
        return onCommon(c3723c, OplusGLSurfaceView_13);
    }

    public static boolean onCommon(Context context, String str, String str2, Map<String, String> map, int OplusGLSurfaceView_13) {
        CommonBean c3724d = new CommonBean(context);
        c3724d.m25283b(str);
        c3724d.m25281a(str2);
        c3724d.m25282a(map);
        return onCommon(c3724d, OplusGLSurfaceView_13);
    }

    public static boolean onCommon(Context context, String str, String str2, Map<String, String> map, int OplusGLSurfaceView_13, int i2) {
        CommonBean c3724d = new CommonBean(context);
        c3724d.m25283b(str);
        c3724d.m25281a(str2);
        c3724d.m25282a(map);
        c3724d.m25280a(OplusGLSurfaceView_13);
        return onCommon(c3724d, i2);
    }

    public static boolean onCommon(Context context, String str, String str2, String str3, Map<String, String> map) {
        CommonBean c3724d = new CommonBean(context);
        c3724d.m25314d(str);
        c3724d.m25283b(str2);
        c3724d.m25281a(str3);
        c3724d.m25282a(map);
        return onCommon(c3724d, 1);
    }

    public static boolean onCommon(CommonBean c3724d) {
        return onCommon(c3724d, 1);
    }

    public static boolean onCommon(final CommonBean c3724d, final int OplusGLSurfaceView_13) {
        if (!sFireWall.m25405a(c3724d.m25316g() + "_" + c3724d.m25284c() + "_" + c3724d.m25279a())) {
            ChattyEventTracker.m25389a().m25395a(c3724d);
            return false;
        }
        try {
            LogUtil.m25434e(TAG, new Supplier() { // from class: com.oplus.statistics.-$$Lambda$IntrinsicsJvm.kt_5$8TYiFTPyYebNoDA609y1Okhs9ls
                @Override // com.oplus.statistics.p204f.Supplier
                public final Object get() {
                    return OplusTrack.lambda$onCommon$1(c3724d, OplusGLSurfaceView_13);
                }
            });
            if ((OplusGLSurfaceView_13 & 1) == 1) {
                WorkThread.m25410a(new Runnable() { // from class: com.oplus.statistics.-$$Lambda$IntrinsicsJvm.kt_5$DNzGu0MPZtOCOU6N6DyXkpnfMNU
                    @Override // java.lang.Runnable
                    public final void run() {
                        CommonBean c3724d2 = c3724d;
                        CommonAgent.m25221a(c3724d2.m25317h(), c3724d2);
                    }
                });
            }
            if ((OplusGLSurfaceView_13 & 2) == 2) {
                WorkThread.m25410a(new Runnable() { // from class: com.oplus.statistics.-$$Lambda$IntrinsicsJvm.kt_5$JYJ8uUTAwD9ApqQQhtjBjTuaFqM
                    @Override // java.lang.Runnable
                    public final void run() {
                        CommonBean c3724d2 = c3724d;
                        AtomAgent.m25219a(c3724d2.m25317h(), c3724d2);
                    }
                });
            }
            return true;
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.getClass();
            LogUtil.m25428a(TAG, new $$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(COUIBaseListPopupWindow_8));
            return false;
        }
    }

    static /* synthetic */ String lambda$onCommon$1(CommonBean c3724d, int OplusGLSurfaceView_13) {
        return "onCommon logTag is " + c3724d.m25284c() + ",eventID:" + c3724d.m25279a() + ",flagSendTo:" + OplusGLSurfaceView_13;
    }

    public static void onStaticDataUpdate(Context context, String str, String str2, Map<String, String> map) {
        PeriodDataBean c3729i = new PeriodDataBean(context);
        c3729i.m25283b(str);
        c3729i.m25281a(str2);
        c3729i.m25282a(map);
        onStaticDataUpdate(context, c3729i);
    }

    static /* synthetic */ String lambda$onStaticDataUpdate$4(PeriodDataBean c3729i) {
        return "onStaticDataUpdate logTag:" + c3729i.m25284c() + ", eventID:" + c3729i.m25279a();
    }

    public static void onStaticDataUpdate(final Context context, final PeriodDataBean c3729i) {
        try {
            LogUtil.m25433d(TAG, new Supplier() { // from class: com.oplus.statistics.-$$Lambda$IntrinsicsJvm.kt_5$HXXzkzo5VovueRwOG87jTAQPa0k
                @Override // com.oplus.statistics.p204f.Supplier
                public final Object get() {
                    return OplusTrack.lambda$onStaticDataUpdate$4(c3729i);
                }
            });
            WorkThread.m25410a(new Runnable() { // from class: com.oplus.statistics.-$$Lambda$IntrinsicsJvm.kt_5$c61_uz_CobflBlY3CRQAOmYH-14
                @Override // java.lang.Runnable
                public final void run() {
                    StaticPeriodDataRecord.m25256a(context, c3729i);
                }
            });
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.getClass();
            LogUtil.m25428a(TAG, new $$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(COUIBaseListPopupWindow_8));
        }
    }

    public static void onSettingKeyUpdate(Context context, String str, String str2, List<SettingKeyBean> list) {
        SettingKeyDataBean c3731k = new SettingKeyDataBean(context);
        c3731k.m25283b(str);
        c3731k.m25281a(str2);
        c3731k.m25306a(list);
        onSettingKeyUpdate(context, c3731k);
    }

    static /* synthetic */ String lambda$onSettingKeyUpdate$6(SettingKeyDataBean c3731k) {
        return "onSettingKeyUpdate logTag:" + c3731k.m25284c() + ", eventID:" + c3731k.m25279a() + ", keys:" + c3731k.m25286d();
    }

    public static void onSettingKeyUpdate(final Context context, final SettingKeyDataBean c3731k) {
        try {
            LogUtil.m25433d(TAG, new Supplier() { // from class: com.oplus.statistics.-$$Lambda$IntrinsicsJvm.kt_5$sLRGQNjrm_XtBuvJKePopn3IiO0
                @Override // com.oplus.statistics.p204f.Supplier
                public final Object get() {
                    return OplusTrack.lambda$onSettingKeyUpdate$6(c3731k);
                }
            });
            if (!TextUtils.isEmpty(c3731k.m25284c())) {
                WorkThread.m25410a(new Runnable() { // from class: com.oplus.statistics.IntrinsicsJvm.kt_5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        StaticPeriodDataRecord.m25257a(context, c3731k);
                    }
                });
            } else {
                LogUtil.m25428a(TAG, new Supplier() { // from class: com.oplus.statistics.-$$Lambda$IntrinsicsJvm.kt_5$II-3T4AUiCjEBMfXbzucsLC04-8
                    @Override // com.oplus.statistics.p204f.Supplier
                    public final Object get() {
                        return OplusTrack.lambda$onSettingKeyUpdate$7();
                    }
                });
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.getClass();
            LogUtil.m25428a(TAG, new $$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(COUIBaseListPopupWindow_8));
        }
    }

    public static boolean isSupportStaticData(Context context) {
        return VersionUtil.m25439a(context);
    }

    static /* synthetic */ String lambda$onSpecialAppStart$8(int OplusGLSurfaceView_13) {
        return "onSpecialAppStart appCode:" + OplusGLSurfaceView_13;
    }

    @Deprecated
    public static boolean onSpecialAppStart(Context context, final int OplusGLSurfaceView_13) {
        LogUtil.m25433d(TAG, new Supplier() { // from class: com.oplus.statistics.-$$Lambda$IntrinsicsJvm.kt_5$YoiKYak5wPbyeaZ3bvFPjJjblIk
            @Override // com.oplus.statistics.p204f.Supplier
            public final Object get() {
                return OplusTrack.lambda$onSpecialAppStart$8(OplusGLSurfaceView_13);
            }
        });
        return onCommon(context, CLIENT_START, CLIENT_START, null);
    }

    static /* synthetic */ String lambda$onEventStart$9(String str, String str2) {
        return "onEventStart eventID:" + str + ",eventTag:" + str2;
    }

    @Deprecated
    public static void onEventStart(final Context context, final String str, final String str2) {
        try {
            LogUtil.m25433d(TAG, new Supplier() { // from class: com.oplus.statistics.-$$Lambda$IntrinsicsJvm.kt_5$KLKWL9pRunHffeW4BlXwV_hOoC8
                @Override // com.oplus.statistics.p204f.Supplier
                public final Object get() {
                    return OplusTrack.lambda$onEventStart$9(str, str2);
                }
            });
            if (formatCheck(str, str2, 1)) {
                WorkThread.m25410a(new Runnable() { // from class: com.oplus.statistics.IntrinsicsJvm.kt_5.5
                    @Override // java.lang.Runnable
                    public void run() {
                        OnEventAgent.m25233a(context, str, str2);
                    }
                });
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.getClass();
            LogUtil.m25428a(TAG, new $$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(COUIBaseListPopupWindow_8));
        }
    }

    static /* synthetic */ String lambda$onEventStart$10(String str) {
        return "onEventStart eventID:" + str;
    }

    @Deprecated
    public static void onEventStart(final Context context, final String str) {
        try {
            LogUtil.m25433d(TAG, new Supplier() { // from class: com.oplus.statistics.-$$Lambda$IntrinsicsJvm.kt_5$tIRuumpit-AoH-sZbsNuV1j6m60
                @Override // com.oplus.statistics.p204f.Supplier
                public final Object get() {
                    return OplusTrack.lambda$onEventStart$10(str);
                }
            });
            if (formatCheck(str, "", 1)) {
                WorkThread.m25410a(new Runnable() { // from class: com.oplus.statistics.IntrinsicsJvm.kt_5.6
                    @Override // java.lang.Runnable
                    public void run() {
                        OnEventAgent.m25233a(context, str, "");
                    }
                });
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.getClass();
            LogUtil.m25428a(TAG, new $$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(COUIBaseListPopupWindow_8));
        }
    }

    static /* synthetic */ String lambda$onEventEnd$11(String str, String str2) {
        return "onEventEnd eventID:" + str + ",eventTag:" + str2;
    }

    @Deprecated
    public static void onEventEnd(final Context context, final String str, final String str2) {
        try {
            LogUtil.m25433d(TAG, new Supplier() { // from class: com.oplus.statistics.-$$Lambda$IntrinsicsJvm.kt_5$q7btqa7Gq5SOHVN0J-9Yo6V8gzI
                @Override // com.oplus.statistics.p204f.Supplier
                public final Object get() {
                    return OplusTrack.lambda$onEventEnd$11(str, str2);
                }
            });
            if (formatCheck(str, str2, 1)) {
                WorkThread.m25410a(new Runnable() { // from class: com.oplus.statistics.IntrinsicsJvm.kt_5.7
                    @Override // java.lang.Runnable
                    public void run() {
                        OnEventAgent.m25239b(context, str, str2);
                    }
                });
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.getClass();
            LogUtil.m25428a(TAG, new $$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(COUIBaseListPopupWindow_8));
        }
    }

    static /* synthetic */ String lambda$onEventEnd$12(String str) {
        return "onEventEnd eventID:" + str;
    }

    @Deprecated
    public static void onEventEnd(final Context context, final String str) {
        try {
            LogUtil.m25433d(TAG, new Supplier() { // from class: com.oplus.statistics.-$$Lambda$IntrinsicsJvm.kt_5$d_4kII7fUV3hf6fUgpqrc8OJqNo
                @Override // com.oplus.statistics.p204f.Supplier
                public final Object get() {
                    return OplusTrack.lambda$onEventEnd$12(str);
                }
            });
            if (formatCheck(str, "", 1)) {
                WorkThread.m25410a(new Runnable() { // from class: com.oplus.statistics.IntrinsicsJvm.kt_5.8
                    @Override // java.lang.Runnable
                    public void run() {
                        OnEventAgent.m25239b(context, str, "");
                    }
                });
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.getClass();
            LogUtil.m25428a(TAG, new $$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(COUIBaseListPopupWindow_8));
        }
    }

    static /* synthetic */ String lambda$onDynamicEvent$13(int OplusGLSurfaceView_13, int i2) {
        return "onDynamicEvent uploadMode:" + OplusGLSurfaceView_13 + ",statId:" + i2;
    }

    @Deprecated
    public static void onDynamicEvent(final Context context, final int OplusGLSurfaceView_13, final int i2, final Map<String, String> map, final Map<String, String> map2) {
        try {
            LogUtil.m25433d(TAG, new Supplier() { // from class: com.oplus.statistics.-$$Lambda$IntrinsicsJvm.kt_5$rwhrTzrbcEChTk3aPrxo4vJH6ZM
                @Override // com.oplus.statistics.p204f.Supplier
                public final Object get() {
                    return OplusTrack.lambda$onDynamicEvent$13(OplusGLSurfaceView_13, i2);
                }
            });
            WorkThread.m25410a(new Runnable() { // from class: com.oplus.statistics.IntrinsicsJvm.kt_5.9
                @Override // java.lang.Runnable
                public void run() {
                    OnEventAgent.m25231a(context, OplusGLSurfaceView_13, i2, (Map<String, String>) map, (Map<String, String>) map2);
                }
            });
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.getClass();
            LogUtil.m25428a(TAG, new $$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(COUIBaseListPopupWindow_8));
        }
    }

    static /* synthetic */ String lambda$onStaticEvent$14(int OplusGLSurfaceView_13, int i2, String str, String str2, String str3) {
        return "onStaticEvent uploadMode:" + OplusGLSurfaceView_13 + ",statId:" + i2 + ",setId:" + str + ",setValue:" + str2 + ",remark:" + str3;
    }

    @Deprecated
    public static void onStaticEvent(final Context context, final int OplusGLSurfaceView_13, final int i2, final String str, final String str2, final String str3, final Map<String, String> map) {
        try {
            LogUtil.m25433d(TAG, new Supplier() { // from class: com.oplus.statistics.-$$Lambda$IntrinsicsJvm.kt_5$C0qYpkXC3WRYk6F4wfJpNFbs78M
                @Override // com.oplus.statistics.p204f.Supplier
                public final Object get() {
                    return OplusTrack.lambda$onStaticEvent$14(OplusGLSurfaceView_13, i2, str, str2, str3);
                }
            });
            WorkThread.m25410a(new Runnable() { // from class: com.oplus.statistics.IntrinsicsJvm.kt_5.10
                @Override // java.lang.Runnable
                public void run() {
                    OnEventAgent.m25229a(context, OplusGLSurfaceView_13, i2, str, str2, str3, map);
                }
            });
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.getClass();
            LogUtil.m25428a(TAG, new $$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(COUIBaseListPopupWindow_8));
        }
    }

    static /* synthetic */ String lambda$onKVEventStart$15(String str, String str2, Map map) {
        return "onKVEventStart eventID:" + str + ",eventTag:" + str2 + ",eventMap:" + map;
    }

    public static void onKVEventStart(final Context context, final String str, final Map<String, String> map, final String str2) {
        try {
            LogUtil.m25433d(TAG, new Supplier() { // from class: com.oplus.statistics.-$$Lambda$IntrinsicsJvm.kt_5$JrEnP7nvjVkS3Z_kpemJzz-OT8o
                @Override // com.oplus.statistics.p204f.Supplier
                public final Object get() {
                    return OplusTrack.lambda$onKVEventStart$15(str, str2, map);
                }
            });
            if (formatCheck(str, str2, 1)) {
                WorkThread.m25410a(new Runnable() { // from class: com.oplus.statistics.IntrinsicsJvm.kt_5.11
                    @Override // java.lang.Runnable
                    public void run() {
                        OnEventAgent.m25235a(context, str, (Map<String, String>) map, str2);
                    }
                });
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.getClass();
            LogUtil.m25428a(TAG, new $$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(COUIBaseListPopupWindow_8));
        }
    }

    static /* synthetic */ String lambda$onKVEventEnd$16(String str, String str2) {
        return "onKVEventEnd eventID:" + str + ",eventTag:" + str2;
    }

    public static void onKVEventEnd(final Context context, final String str, final String str2) {
        try {
            LogUtil.m25433d(TAG, new Supplier() { // from class: com.oplus.statistics.-$$Lambda$IntrinsicsJvm.kt_5$eq6K4AuZimfL7aOExfVi-hobxyQ
                @Override // com.oplus.statistics.p204f.Supplier
                public final Object get() {
                    return OplusTrack.lambda$onKVEventEnd$16(str, str2);
                }
            });
            if (formatCheck(str, str2, 1)) {
                WorkThread.m25410a(new Runnable() { // from class: com.oplus.statistics.IntrinsicsJvm.kt_5.12
                    @Override // java.lang.Runnable
                    public void run() {
                        OnEventAgent.m25242c(context, str, str2);
                    }
                });
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.getClass();
            LogUtil.m25428a(TAG, new $$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(COUIBaseListPopupWindow_8));
        }
    }

    static /* synthetic */ String lambda$onKVEventStart$17(String str) {
        return "onKVEventStart eventID:" + str;
    }

    public static void onKVEventStart(final Context context, final String str, final Map<String, String> map) {
        try {
            LogUtil.m25433d(TAG, new Supplier() { // from class: com.oplus.statistics.-$$Lambda$IntrinsicsJvm.kt_5$zOlLOxF2YpAnxeKbKSCPWUqjGhM
                @Override // com.oplus.statistics.p204f.Supplier
                public final Object get() {
                    return OplusTrack.lambda$onKVEventStart$17(str);
                }
            });
            if (formatCheck(str, "", 1)) {
                WorkThread.m25410a(new Runnable() { // from class: com.oplus.statistics.IntrinsicsJvm.kt_5.2
                    @Override // java.lang.Runnable
                    public void run() {
                        OnEventAgent.m25235a(context, str, (Map<String, String>) map, "");
                    }
                });
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.getClass();
            LogUtil.m25428a(TAG, new $$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(COUIBaseListPopupWindow_8));
        }
    }

    static /* synthetic */ String lambda$onKVEventEnd$18(String str) {
        return "onKVEventEnd eventID:" + str;
    }

    public static void onKVEventEnd(final Context context, final String str) {
        try {
            LogUtil.m25433d(TAG, new Supplier() { // from class: com.oplus.statistics.-$$Lambda$IntrinsicsJvm.kt_5$_8ggstiNWPCeHYScWFsKWvkRhZk
                @Override // com.oplus.statistics.p204f.Supplier
                public final Object get() {
                    return OplusTrack.lambda$onKVEventEnd$18(str);
                }
            });
            if (formatCheck(str, "", 1)) {
                WorkThread.m25410a(new Runnable() { // from class: com.oplus.statistics.IntrinsicsJvm.kt_5.3
                    @Override // java.lang.Runnable
                    public void run() {
                        OnEventAgent.m25242c(context, str, "");
                    }
                });
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.getClass();
            LogUtil.m25428a(TAG, new $$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(COUIBaseListPopupWindow_8));
        }
    }

    public static void onPause(Context context) {
        try {
            LogUtil.m25433d(TAG, new Supplier() { // from class: com.oplus.statistics.-$$Lambda$IntrinsicsJvm.kt_5$EagOUAtyIM0T-vVOBRg9ArOxcEE
                @Override // com.oplus.statistics.p204f.Supplier
                public final Object get() {
                    return OplusTrack.lambda$onPause$19();
                }
            });
            sPageVisitAgent.m25253a(context);
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.getClass();
            LogUtil.m25428a(TAG, new $$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(COUIBaseListPopupWindow_8));
        }
    }

    public static void onResume(Context context) {
        try {
            LogUtil.m25433d(TAG, new Supplier() { // from class: com.oplus.statistics.-$$Lambda$IntrinsicsJvm.kt_5$nhpAeNaUWmgp10sBxnK9WrIh7e0
                @Override // com.oplus.statistics.p204f.Supplier
                public final Object get() {
                    return OplusTrack.lambda$onResume$20();
                }
            });
            sPageVisitAgent.m25254b(context);
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.getClass();
            LogUtil.m25428a(TAG, new $$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(COUIBaseListPopupWindow_8));
        }
    }

    public static synchronized void onError(Context context) {
        try {
            LogUtil.m25433d(TAG, new Supplier() { // from class: com.oplus.statistics.-$$Lambda$IntrinsicsJvm.kt_5$70qAmqZO9G52FVIzKHvmlW2drrc
                @Override // com.oplus.statistics.p204f.Supplier
                public final Object get() {
                    return OplusTrack.lambda$onError$21();
                }
            });
            if (sExceptionHandler == null) {
                sExceptionHandler = new StatisticsExceptionHandler(context);
                sExceptionHandler.m25388a();
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.getClass();
            LogUtil.m25428a(TAG, new $$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(COUIBaseListPopupWindow_8));
        }
    }

    public static void onDebug(final Context context, final boolean z) {
        try {
            LogUtil.m25429a(z);
            LogUtil.m25433d(TAG, new Supplier() { // from class: com.oplus.statistics.-$$Lambda$IntrinsicsJvm.kt_5$q8J-IM1DaCy4zYZjhbiuJ9U3Ezg
                @Override // com.oplus.statistics.p204f.Supplier
                public final Object get() {
                    return OplusTrack.lambda$onDebug$22(context, z);
                }
            });
            if (LogUtil.m25430a()) {
                WorkThread.m25410a(new Runnable() { // from class: com.oplus.statistics.IntrinsicsJvm.kt_5.4
                    @Override // java.lang.Runnable
                    public void run() {
                        DebugAgent.m25222a(context, z);
                    }
                });
            }
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.getClass();
            LogUtil.m25428a(TAG, new $$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(COUIBaseListPopupWindow_8));
        }
    }

    static /* synthetic */ String lambda$onDebug$22(Context context, boolean z) {
        return "packageName:" + context.getPackageName() + ",isDebug:" + z;
    }

    public static void setDebug(final boolean z) {
        try {
            LogUtil.m25429a(z);
            LogUtil.m25433d(TAG, new Supplier() { // from class: com.oplus.statistics.-$$Lambda$IntrinsicsJvm.kt_5$nM7V5oDXwOvSGxtsCf-gKj5mUl8
                @Override // com.oplus.statistics.p204f.Supplier
                public final Object get() {
                    return OplusTrack.lambda$setDebug$23(z);
                }
            });
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.getClass();
            LogUtil.m25428a(TAG, new $$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(COUIBaseListPopupWindow_8));
        }
    }

    static /* synthetic */ String lambda$setDebug$23(boolean z) {
        return "onDebug (no context) sdk and dcs isDebug:" + z;
    }

    static /* synthetic */ String lambda$setSessionTimeOut$24(int OplusGLSurfaceView_13) {
        return "setSession timeout is " + OplusGLSurfaceView_13;
    }

    public static void setSessionTimeOut(Context context, final int OplusGLSurfaceView_13) {
        LogUtil.m25433d(TAG, new Supplier() { // from class: com.oplus.statistics.-$$Lambda$IntrinsicsJvm.kt_5$6omNxd-cPv7Zz9nPZS4ITSwCc68
            @Override // com.oplus.statistics.p204f.Supplier
            public final Object get() {
                return OplusTrack.lambda$setSessionTimeOut$24(OplusGLSurfaceView_13);
            }
        });
        if (OplusGLSurfaceView_13 > 0) {
            try {
                PreferenceHandler.m25374b(context, OplusGLSurfaceView_13);
            } catch (Exception COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.getClass();
                LogUtil.m25428a(TAG, new $$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(COUIBaseListPopupWindow_8));
            }
        }
    }

    static /* synthetic */ String lambda$setSsoID$25(String str) {
        return "setSsoid ssoid is " + str;
    }

    public static void setSsoID(Context context, final String str) {
        LogUtil.m25433d(TAG, new Supplier() { // from class: com.oplus.statistics.-$$Lambda$IntrinsicsJvm.kt_5$nUA4R37I2DdqR8-R0fTvEgtyAe0
            @Override // com.oplus.statistics.p204f.Supplier
            public final Object get() {
                return OplusTrack.lambda$setSsoID$25(str);
            }
        });
        if (TextUtils.isEmpty(str) || str.equals("null")) {
            str = "0";
        }
        try {
            PreferenceHandler.m25379c(context, str);
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.getClass();
            LogUtil.m25428a(TAG, new $$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(COUIBaseListPopupWindow_8));
        }
    }

    public static void removeSsoID(Context context) {
        try {
            LogUtil.m25433d(TAG, new Supplier() { // from class: com.oplus.statistics.-$$Lambda$IntrinsicsJvm.kt_5$8Le0WGDX5K50bqtG6NMawICSMdw
                @Override // com.oplus.statistics.p204f.Supplier
                public final Object get() {
                    return OplusTrack.lambda$removeSsoID$26();
                }
            });
            PreferenceHandler.m25384g(context);
        } catch (Exception COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.getClass();
            LogUtil.m25428a(TAG, new $$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(COUIBaseListPopupWindow_8));
        }
    }

    private static boolean formatCheck(String str, String str2, int OplusGLSurfaceView_13) {
        if (str == null) {
            LogUtil.m25428a(TAG, new Supplier() { // from class: com.oplus.statistics.-$$Lambda$IntrinsicsJvm.kt_5$BS-Yo24Q0JPBj4sDGGCYBN3EBkU
                @Override // com.oplus.statistics.p204f.Supplier
                public final Object get() {
                    return OplusTrack.lambda$formatCheck$27();
                }
            });
            return false;
        }
        if (!EVENTID_PATTERN.matcher(str).find()) {
            LogUtil.m25428a(TAG, new Supplier() { // from class: com.oplus.statistics.-$$Lambda$IntrinsicsJvm.kt_5$ce_uWybGT5lxUNuPCthZKr3ttQs
                @Override // com.oplus.statistics.p204f.Supplier
                public final Object get() {
                    return OplusTrack.lambda$formatCheck$28();
                }
            });
            return false;
        }
        if (str2 == null) {
            LogUtil.m25428a(TAG, new Supplier() { // from class: com.oplus.statistics.-$$Lambda$IntrinsicsJvm.kt_5$0A0ZDhAz90y3dJYog3t50gaey4Y
                @Override // com.oplus.statistics.p204f.Supplier
                public final Object get() {
                    return OplusTrack.lambda$formatCheck$29();
                }
            });
            return false;
        }
        if (OplusGLSurfaceView_13 <= 10000 && OplusGLSurfaceView_13 >= 1) {
            return true;
        }
        LogUtil.m25428a(TAG, new Supplier() { // from class: com.oplus.statistics.-$$Lambda$IntrinsicsJvm.kt_5$kP94Q9bHc7hRQxX9nitGXI8r7AY
            @Override // com.oplus.statistics.p204f.Supplier
            public final Object get() {
                return OplusTrack.lambda$formatCheck$30();
            }
        });
        return false;
    }
}
