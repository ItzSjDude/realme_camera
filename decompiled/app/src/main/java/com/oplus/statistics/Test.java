package com.oplus.statistics;

/* compiled from: OplusTrack.java */
/* loaded from: classes2.dex */
public class d_renamed {
    private static final java.lang.String CLIENT_START = "ClientStart";
    private static final int FIREWALL_LIMIT = 120;
    public static final int FLAG_SEND_TO_ATOM = 2;
    public static final int FLAG_SEND_TO_DCS = 1;
    private static final int MAX_EVENT_COUNT = 10000;
    private static final int MIN_EVENT_COUNT = 1;
    private static final java.lang.String TAG = "OplusTrack";
    private static volatile com.oplus.statistics.e_renamed sExceptionHandler;
    private static final java.util.regex.Pattern EVENTID_PATTERN = java.util.regex.Pattern.compile("^[a_renamed-zA-Z0-9\\_\\-]{1,64}$");
    private static final com.oplus.statistics.a_renamed.h_renamed sPageVisitAgent = new com.oplus.statistics.a_renamed.h_renamed();
    private static final long FIREWALL_LIMIT_TIME = 120000;
    private static final com.oplus.statistics.e_renamed.b_renamed sFireWall = new com.oplus.statistics.e_renamed.b_renamed.a_renamed(120, FIREWALL_LIMIT_TIME).a_renamed();

    static /* synthetic */ java.lang.String lambda$formatCheck$27() {
        return "EventID is_renamed null!";
    }

    static /* synthetic */ java.lang.String lambda$formatCheck$28() {
        return "EventID format error!";
    }

    static /* synthetic */ java.lang.String lambda$formatCheck$29() {
        return "EventTag format error!";
    }

    static /* synthetic */ java.lang.String lambda$formatCheck$30() {
        return "EventCount format error!";
    }

    static /* synthetic */ java.lang.String lambda$init$0() {
        return "AppCode is_renamed empty.";
    }

    static /* synthetic */ java.lang.String lambda$onError$21() {
        return "onError...";
    }

    static /* synthetic */ java.lang.String lambda$onPause$19() {
        return "onPause...";
    }

    static /* synthetic */ java.lang.String lambda$onResume$20() {
        return "onResume...";
    }

    static /* synthetic */ java.lang.String lambda$onSettingKeyUpdate$7() {
        return "Send data failed! logTag is_renamed null.";
    }

    static /* synthetic */ java.lang.String lambda$removeSsoID$26() {
        return "removeSsoID";
    }

    public static void init(android.content.Context context) {
        init(context, null);
    }

    public static void init(android.content.Context context, com.oplus.statistics.b_renamed bVar) {
        init(context, com.oplus.statistics.f_renamed.b_renamed.d_renamed(context), bVar);
    }

    public static void init(android.content.Context context, java.lang.String str, com.oplus.statistics.b_renamed bVar) {
        android.content.Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            com.oplus.statistics.c_renamed.a_renamed.a_renamed().a_renamed((android.app.Application) applicationContext);
        }
        if (android.text.TextUtils.isEmpty(str)) {
            com.oplus.statistics.f_renamed.d_renamed.b_renamed(TAG, new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.-$$Lambda$d_renamed$hV76rl-7SP49z_3P6vtPV8EJQBM
                @Override // com.oplus.statistics.f_renamed.e_renamed
                public final java.lang.Object get() {
                    return com.oplus.statistics.d_renamed.lambda$init$0();
                }
            });
        }
        com.oplus.statistics.f_renamed.b_renamed.a_renamed(context, str);
        com.oplus.statistics.c_renamed.a_renamed(str, context, bVar);
        if (bVar != null) {
            com.oplus.statistics.f_renamed.d_renamed.a_renamed(bVar.a_renamed() == 1);
        }
    }

    public static boolean onCommon(android.content.Context context, java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.String> map) {
        com.oplus.statistics.b_renamed.d_renamed dVar = new com.oplus.statistics.b_renamed.d_renamed(context);
        dVar.b_renamed(str);
        dVar.a_renamed(str2);
        dVar.a_renamed(map);
        return onCommon(dVar, 1);
    }

    public static boolean onCommonBatch(android.content.Context context, java.lang.String str, java.lang.String str2, java.util.List<java.util.Map<java.lang.String, java.lang.String>> list, int i_renamed) throws com.oplus.statistics.a_renamed {
        return onCommonBatch(context, "", str, str2, list, i_renamed);
    }

    public static boolean onCommonBatch(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.List<java.util.Map<java.lang.String, java.lang.String>> list, int i_renamed) throws com.oplus.statistics.a_renamed {
        com.oplus.statistics.b_renamed.c_renamed cVar = new com.oplus.statistics.b_renamed.c_renamed(context);
        cVar.d_renamed(str);
        cVar.b_renamed(str2);
        cVar.a_renamed(str3);
        cVar.a_renamed(list);
        return onCommon(cVar, i_renamed);
    }

    public static boolean onCommon(android.content.Context context, java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.String> map, int i_renamed) {
        com.oplus.statistics.b_renamed.d_renamed dVar = new com.oplus.statistics.b_renamed.d_renamed(context);
        dVar.b_renamed(str);
        dVar.a_renamed(str2);
        dVar.a_renamed(map);
        return onCommon(dVar, i_renamed);
    }

    public static boolean onCommon(android.content.Context context, java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.String> map, int i_renamed, int i2) {
        com.oplus.statistics.b_renamed.d_renamed dVar = new com.oplus.statistics.b_renamed.d_renamed(context);
        dVar.b_renamed(str);
        dVar.a_renamed(str2);
        dVar.a_renamed(map);
        dVar.a_renamed(i_renamed);
        return onCommon(dVar, i2);
    }

    public static boolean onCommon(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.util.Map<java.lang.String, java.lang.String> map) {
        com.oplus.statistics.b_renamed.d_renamed dVar = new com.oplus.statistics.b_renamed.d_renamed(context);
        dVar.d_renamed(str);
        dVar.b_renamed(str2);
        dVar.a_renamed(str3);
        dVar.a_renamed(map);
        return onCommon(dVar, 1);
    }

    public static boolean onCommon(com.oplus.statistics.b_renamed.d_renamed dVar) {
        return onCommon(dVar, 1);
    }

    public static boolean onCommon(final com.oplus.statistics.b_renamed.d_renamed dVar, final int i_renamed) {
        if (!sFireWall.a_renamed(dVar.g_renamed() + "_" + dVar.c_renamed() + "_" + dVar.a_renamed())) {
            com.oplus.statistics.e_renamed.a_renamed.a_renamed().a_renamed(dVar);
            return false;
        }
        try {
            com.oplus.statistics.f_renamed.d_renamed.e_renamed(TAG, new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.-$$Lambda$d_renamed$8TYiFTPyYebNoDA609y1Okhs9ls
                @Override // com.oplus.statistics.f_renamed.e_renamed
                public final java.lang.Object get() {
                    return com.oplus.statistics.d_renamed.lambda$onCommon$1(dVar, i_renamed);
                }
            });
            if ((i_renamed & 1) == 1) {
                com.oplus.statistics.e_renamed.c_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.statistics.-$$Lambda$d_renamed$DNzGu0MPZtOCOU6N6DyXkpnfMNU
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.oplus.statistics.b_renamed.d_renamed dVar2 = dVar;
                        com.oplus.statistics.a_renamed.d_renamed.a_renamed(dVar2.h_renamed(), dVar2);
                    }
                });
            }
            if ((i_renamed & 2) == 2) {
                com.oplus.statistics.e_renamed.c_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.statistics.-$$Lambda$d_renamed$JYJ8uUTAwD9ApqQQhtjBjTuaFqM
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.oplus.statistics.b_renamed.d_renamed dVar2 = dVar;
                        com.oplus.statistics.a_renamed.b_renamed.a_renamed(dVar2.h_renamed(), dVar2);
                    }
                });
            }
            return true;
        } catch (java.lang.Exception e_renamed) {
            e_renamed.getClass();
            com.oplus.statistics.f_renamed.d_renamed.a_renamed(TAG, new com.oplus.statistics.$$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(e_renamed));
            return false;
        }
    }

    static /* synthetic */ java.lang.String lambda$onCommon$1(com.oplus.statistics.b_renamed.d_renamed dVar, int i_renamed) {
        return "onCommon logTag is_renamed " + dVar.c_renamed() + ",eventID:" + dVar.a_renamed() + ",flagSendTo:" + i_renamed;
    }

    public static void onStaticDataUpdate(android.content.Context context, java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.String> map) {
        com.oplus.statistics.b_renamed.i_renamed iVar = new com.oplus.statistics.b_renamed.i_renamed(context);
        iVar.b_renamed(str);
        iVar.a_renamed(str2);
        iVar.a_renamed(map);
        onStaticDataUpdate(context, iVar);
    }

    static /* synthetic */ java.lang.String lambda$onStaticDataUpdate$4(com.oplus.statistics.b_renamed.i_renamed iVar) {
        return "onStaticDataUpdate logTag:" + iVar.c_renamed() + ", eventID:" + iVar.a_renamed();
    }

    public static void onStaticDataUpdate(final android.content.Context context, final com.oplus.statistics.b_renamed.i_renamed iVar) {
        try {
            com.oplus.statistics.f_renamed.d_renamed.d_renamed(TAG, new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.-$$Lambda$d_renamed$HXXzkzo5VovueRwOG87jTAQPa0k
                @Override // com.oplus.statistics.f_renamed.e_renamed
                public final java.lang.Object get() {
                    return com.oplus.statistics.d_renamed.lambda$onStaticDataUpdate$4(iVar);
                }
            });
            com.oplus.statistics.e_renamed.c_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.statistics.-$$Lambda$d_renamed$c61_uz_CobflBlY3CRQAOmYH-14
                @Override // java.lang.Runnable
                public final void run() {
                    com.oplus.statistics.a_renamed.i_renamed.a_renamed(context, iVar);
                }
            });
        } catch (java.lang.Exception e_renamed) {
            e_renamed.getClass();
            com.oplus.statistics.f_renamed.d_renamed.a_renamed(TAG, new com.oplus.statistics.$$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(e_renamed));
        }
    }

    public static void onSettingKeyUpdate(android.content.Context context, java.lang.String str, java.lang.String str2, java.util.List<com.oplus.statistics.b_renamed.j_renamed> list) {
        com.oplus.statistics.b_renamed.k_renamed kVar = new com.oplus.statistics.b_renamed.k_renamed(context);
        kVar.b_renamed(str);
        kVar.a_renamed(str2);
        kVar.a_renamed(list);
        onSettingKeyUpdate(context, kVar);
    }

    static /* synthetic */ java.lang.String lambda$onSettingKeyUpdate$6(com.oplus.statistics.b_renamed.k_renamed kVar) {
        return "onSettingKeyUpdate logTag:" + kVar.c_renamed() + ", eventID:" + kVar.a_renamed() + ", keys:" + kVar.d_renamed();
    }

    public static void onSettingKeyUpdate(final android.content.Context context, final com.oplus.statistics.b_renamed.k_renamed kVar) {
        try {
            com.oplus.statistics.f_renamed.d_renamed.d_renamed(TAG, new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.-$$Lambda$d_renamed$sLRGQNjrm_XtBuvJKePopn3IiO0
                @Override // com.oplus.statistics.f_renamed.e_renamed
                public final java.lang.Object get() {
                    return com.oplus.statistics.d_renamed.lambda$onSettingKeyUpdate$6(kVar);
                }
            });
            if (!android.text.TextUtils.isEmpty(kVar.c_renamed())) {
                com.oplus.statistics.e_renamed.c_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.statistics.d_renamed.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.oplus.statistics.a_renamed.i_renamed.a_renamed(context, kVar);
                    }
                });
            } else {
                com.oplus.statistics.f_renamed.d_renamed.a_renamed(TAG, new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.-$$Lambda$d_renamed$II-3T4AUiCjEBMfXbzucsLC04-8
                    @Override // com.oplus.statistics.f_renamed.e_renamed
                    public final java.lang.Object get() {
                        return com.oplus.statistics.d_renamed.lambda$onSettingKeyUpdate$7();
                    }
                });
            }
        } catch (java.lang.Exception e_renamed) {
            e_renamed.getClass();
            com.oplus.statistics.f_renamed.d_renamed.a_renamed(TAG, new com.oplus.statistics.$$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(e_renamed));
        }
    }

    public static boolean isSupportStaticData(android.content.Context context) {
        return com.oplus.statistics.f_renamed.g_renamed.a_renamed(context);
    }

    static /* synthetic */ java.lang.String lambda$onSpecialAppStart$8(int i_renamed) {
        return "onSpecialAppStart appCode:" + i_renamed;
    }

    @java.lang.Deprecated
    public static boolean onSpecialAppStart(android.content.Context context, final int i_renamed) {
        com.oplus.statistics.f_renamed.d_renamed.d_renamed(TAG, new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.-$$Lambda$d_renamed$YoiKYak5wPbyeaZ3bvFPjJjblIk
            @Override // com.oplus.statistics.f_renamed.e_renamed
            public final java.lang.Object get() {
                return com.oplus.statistics.d_renamed.lambda$onSpecialAppStart$8(i_renamed);
            }
        });
        return onCommon(context, CLIENT_START, CLIENT_START, null);
    }

    static /* synthetic */ java.lang.String lambda$onEventStart$9(java.lang.String str, java.lang.String str2) {
        return "onEventStart eventID:" + str + ",eventTag:" + str2;
    }

    @java.lang.Deprecated
    public static void onEventStart(final android.content.Context context, final java.lang.String str, final java.lang.String str2) {
        try {
            com.oplus.statistics.f_renamed.d_renamed.d_renamed(TAG, new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.-$$Lambda$d_renamed$KLKWL9pRunHffeW4BlXwV_hOoC8
                @Override // com.oplus.statistics.f_renamed.e_renamed
                public final java.lang.Object get() {
                    return com.oplus.statistics.d_renamed.lambda$onEventStart$9(str, str2);
                }
            });
            if (formatCheck(str, str2, 1)) {
                com.oplus.statistics.e_renamed.c_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.statistics.d_renamed.5
                    @Override // java.lang.Runnable
                    public void run() {
                        com.oplus.statistics.a_renamed.g_renamed.a_renamed(context, str, str2);
                    }
                });
            }
        } catch (java.lang.Exception e_renamed) {
            e_renamed.getClass();
            com.oplus.statistics.f_renamed.d_renamed.a_renamed(TAG, new com.oplus.statistics.$$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(e_renamed));
        }
    }

    static /* synthetic */ java.lang.String lambda$onEventStart$10(java.lang.String str) {
        return "onEventStart eventID:" + str;
    }

    @java.lang.Deprecated
    public static void onEventStart(final android.content.Context context, final java.lang.String str) {
        try {
            com.oplus.statistics.f_renamed.d_renamed.d_renamed(TAG, new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.-$$Lambda$d_renamed$tIRuumpit-AoH-sZbsNuV1j6m60
                @Override // com.oplus.statistics.f_renamed.e_renamed
                public final java.lang.Object get() {
                    return com.oplus.statistics.d_renamed.lambda$onEventStart$10(str);
                }
            });
            if (formatCheck(str, "", 1)) {
                com.oplus.statistics.e_renamed.c_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.statistics.d_renamed.6
                    @Override // java.lang.Runnable
                    public void run() {
                        com.oplus.statistics.a_renamed.g_renamed.a_renamed(context, str, "");
                    }
                });
            }
        } catch (java.lang.Exception e_renamed) {
            e_renamed.getClass();
            com.oplus.statistics.f_renamed.d_renamed.a_renamed(TAG, new com.oplus.statistics.$$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(e_renamed));
        }
    }

    static /* synthetic */ java.lang.String lambda$onEventEnd$11(java.lang.String str, java.lang.String str2) {
        return "onEventEnd eventID:" + str + ",eventTag:" + str2;
    }

    @java.lang.Deprecated
    public static void onEventEnd(final android.content.Context context, final java.lang.String str, final java.lang.String str2) {
        try {
            com.oplus.statistics.f_renamed.d_renamed.d_renamed(TAG, new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.-$$Lambda$d_renamed$q7btqa7Gq5SOHVN0J-9Yo6V8gzI
                @Override // com.oplus.statistics.f_renamed.e_renamed
                public final java.lang.Object get() {
                    return com.oplus.statistics.d_renamed.lambda$onEventEnd$11(str, str2);
                }
            });
            if (formatCheck(str, str2, 1)) {
                com.oplus.statistics.e_renamed.c_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.statistics.d_renamed.7
                    @Override // java.lang.Runnable
                    public void run() {
                        com.oplus.statistics.a_renamed.g_renamed.b_renamed(context, str, str2);
                    }
                });
            }
        } catch (java.lang.Exception e_renamed) {
            e_renamed.getClass();
            com.oplus.statistics.f_renamed.d_renamed.a_renamed(TAG, new com.oplus.statistics.$$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(e_renamed));
        }
    }

    static /* synthetic */ java.lang.String lambda$onEventEnd$12(java.lang.String str) {
        return "onEventEnd eventID:" + str;
    }

    @java.lang.Deprecated
    public static void onEventEnd(final android.content.Context context, final java.lang.String str) {
        try {
            com.oplus.statistics.f_renamed.d_renamed.d_renamed(TAG, new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.-$$Lambda$d_renamed$d_4kII7fUV3hf6fUgpqrc8OJqNo
                @Override // com.oplus.statistics.f_renamed.e_renamed
                public final java.lang.Object get() {
                    return com.oplus.statistics.d_renamed.lambda$onEventEnd$12(str);
                }
            });
            if (formatCheck(str, "", 1)) {
                com.oplus.statistics.e_renamed.c_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.statistics.d_renamed.8
                    @Override // java.lang.Runnable
                    public void run() {
                        com.oplus.statistics.a_renamed.g_renamed.b_renamed(context, str, "");
                    }
                });
            }
        } catch (java.lang.Exception e_renamed) {
            e_renamed.getClass();
            com.oplus.statistics.f_renamed.d_renamed.a_renamed(TAG, new com.oplus.statistics.$$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(e_renamed));
        }
    }

    static /* synthetic */ java.lang.String lambda$onDynamicEvent$13(int i_renamed, int i2) {
        return "onDynamicEvent uploadMode:" + i_renamed + ",statId:" + i2;
    }

    @java.lang.Deprecated
    public static void onDynamicEvent(final android.content.Context context, final int i_renamed, final int i2, final java.util.Map<java.lang.String, java.lang.String> map, final java.util.Map<java.lang.String, java.lang.String> map2) {
        try {
            com.oplus.statistics.f_renamed.d_renamed.d_renamed(TAG, new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.-$$Lambda$d_renamed$rwhrTzrbcEChTk3aPrxo4vJH6ZM
                @Override // com.oplus.statistics.f_renamed.e_renamed
                public final java.lang.Object get() {
                    return com.oplus.statistics.d_renamed.lambda$onDynamicEvent$13(i_renamed, i2);
                }
            });
            com.oplus.statistics.e_renamed.c_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.statistics.d_renamed.9
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.statistics.a_renamed.g_renamed.a_renamed(context, i_renamed, i2, (java.util.Map<java.lang.String, java.lang.String>) map, (java.util.Map<java.lang.String, java.lang.String>) map2);
                }
            });
        } catch (java.lang.Exception e_renamed) {
            e_renamed.getClass();
            com.oplus.statistics.f_renamed.d_renamed.a_renamed(TAG, new com.oplus.statistics.$$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(e_renamed));
        }
    }

    static /* synthetic */ java.lang.String lambda$onStaticEvent$14(int i_renamed, int i2, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return "onStaticEvent uploadMode:" + i_renamed + ",statId:" + i2 + ",setId:" + str + ",setValue:" + str2 + ",remark:" + str3;
    }

    @java.lang.Deprecated
    public static void onStaticEvent(final android.content.Context context, final int i_renamed, final int i2, final java.lang.String str, final java.lang.String str2, final java.lang.String str3, final java.util.Map<java.lang.String, java.lang.String> map) {
        try {
            com.oplus.statistics.f_renamed.d_renamed.d_renamed(TAG, new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.-$$Lambda$d_renamed$C0qYpkXC3WRYk6F4wfJpNFbs78M
                @Override // com.oplus.statistics.f_renamed.e_renamed
                public final java.lang.Object get() {
                    return com.oplus.statistics.d_renamed.lambda$onStaticEvent$14(i_renamed, i2, str, str2, str3);
                }
            });
            com.oplus.statistics.e_renamed.c_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.statistics.d_renamed.10
                @Override // java.lang.Runnable
                public void run() {
                    com.oplus.statistics.a_renamed.g_renamed.a_renamed(context, i_renamed, i2, str, str2, str3, map);
                }
            });
        } catch (java.lang.Exception e_renamed) {
            e_renamed.getClass();
            com.oplus.statistics.f_renamed.d_renamed.a_renamed(TAG, new com.oplus.statistics.$$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(e_renamed));
        }
    }

    static /* synthetic */ java.lang.String lambda$onKVEventStart$15(java.lang.String str, java.lang.String str2, java.util.Map map) {
        return "onKVEventStart eventID:" + str + ",eventTag:" + str2 + ",eventMap:" + map;
    }

    public static void onKVEventStart(final android.content.Context context, final java.lang.String str, final java.util.Map<java.lang.String, java.lang.String> map, final java.lang.String str2) {
        try {
            com.oplus.statistics.f_renamed.d_renamed.d_renamed(TAG, new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.-$$Lambda$d_renamed$JrEnP7nvjVkS3Z_kpemJzz-OT8o
                @Override // com.oplus.statistics.f_renamed.e_renamed
                public final java.lang.Object get() {
                    return com.oplus.statistics.d_renamed.lambda$onKVEventStart$15(str, str2, map);
                }
            });
            if (formatCheck(str, str2, 1)) {
                com.oplus.statistics.e_renamed.c_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.statistics.d_renamed.11
                    @Override // java.lang.Runnable
                    public void run() {
                        com.oplus.statistics.a_renamed.g_renamed.a_renamed(context, str, (java.util.Map<java.lang.String, java.lang.String>) map, str2);
                    }
                });
            }
        } catch (java.lang.Exception e_renamed) {
            e_renamed.getClass();
            com.oplus.statistics.f_renamed.d_renamed.a_renamed(TAG, new com.oplus.statistics.$$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(e_renamed));
        }
    }

    static /* synthetic */ java.lang.String lambda$onKVEventEnd$16(java.lang.String str, java.lang.String str2) {
        return "onKVEventEnd eventID:" + str + ",eventTag:" + str2;
    }

    public static void onKVEventEnd(final android.content.Context context, final java.lang.String str, final java.lang.String str2) {
        try {
            com.oplus.statistics.f_renamed.d_renamed.d_renamed(TAG, new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.-$$Lambda$d_renamed$eq6K4AuZimfL7aOExfVi-hobxyQ
                @Override // com.oplus.statistics.f_renamed.e_renamed
                public final java.lang.Object get() {
                    return com.oplus.statistics.d_renamed.lambda$onKVEventEnd$16(str, str2);
                }
            });
            if (formatCheck(str, str2, 1)) {
                com.oplus.statistics.e_renamed.c_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.statistics.d_renamed.12
                    @Override // java.lang.Runnable
                    public void run() {
                        com.oplus.statistics.a_renamed.g_renamed.c_renamed(context, str, str2);
                    }
                });
            }
        } catch (java.lang.Exception e_renamed) {
            e_renamed.getClass();
            com.oplus.statistics.f_renamed.d_renamed.a_renamed(TAG, new com.oplus.statistics.$$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(e_renamed));
        }
    }

    static /* synthetic */ java.lang.String lambda$onKVEventStart$17(java.lang.String str) {
        return "onKVEventStart eventID:" + str;
    }

    public static void onKVEventStart(final android.content.Context context, final java.lang.String str, final java.util.Map<java.lang.String, java.lang.String> map) {
        try {
            com.oplus.statistics.f_renamed.d_renamed.d_renamed(TAG, new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.-$$Lambda$d_renamed$zOlLOxF2YpAnxeKbKSCPWUqjGhM
                @Override // com.oplus.statistics.f_renamed.e_renamed
                public final java.lang.Object get() {
                    return com.oplus.statistics.d_renamed.lambda$onKVEventStart$17(str);
                }
            });
            if (formatCheck(str, "", 1)) {
                com.oplus.statistics.e_renamed.c_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.statistics.d_renamed.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.oplus.statistics.a_renamed.g_renamed.a_renamed(context, str, (java.util.Map<java.lang.String, java.lang.String>) map, "");
                    }
                });
            }
        } catch (java.lang.Exception e_renamed) {
            e_renamed.getClass();
            com.oplus.statistics.f_renamed.d_renamed.a_renamed(TAG, new com.oplus.statistics.$$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(e_renamed));
        }
    }

    static /* synthetic */ java.lang.String lambda$onKVEventEnd$18(java.lang.String str) {
        return "onKVEventEnd eventID:" + str;
    }

    public static void onKVEventEnd(final android.content.Context context, final java.lang.String str) {
        try {
            com.oplus.statistics.f_renamed.d_renamed.d_renamed(TAG, new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.-$$Lambda$d_renamed$_8ggstiNWPCeHYScWFsKWvkRhZk
                @Override // com.oplus.statistics.f_renamed.e_renamed
                public final java.lang.Object get() {
                    return com.oplus.statistics.d_renamed.lambda$onKVEventEnd$18(str);
                }
            });
            if (formatCheck(str, "", 1)) {
                com.oplus.statistics.e_renamed.c_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.statistics.d_renamed.3
                    @Override // java.lang.Runnable
                    public void run() {
                        com.oplus.statistics.a_renamed.g_renamed.c_renamed(context, str, "");
                    }
                });
            }
        } catch (java.lang.Exception e_renamed) {
            e_renamed.getClass();
            com.oplus.statistics.f_renamed.d_renamed.a_renamed(TAG, new com.oplus.statistics.$$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(e_renamed));
        }
    }

    public static void onPause(android.content.Context context) {
        try {
            com.oplus.statistics.f_renamed.d_renamed.d_renamed(TAG, new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.-$$Lambda$d_renamed$EagOUAtyIM0T-vVOBRg9ArOxcEE
                @Override // com.oplus.statistics.f_renamed.e_renamed
                public final java.lang.Object get() {
                    return com.oplus.statistics.d_renamed.lambda$onPause$19();
                }
            });
            sPageVisitAgent.a_renamed(context);
        } catch (java.lang.Exception e_renamed) {
            e_renamed.getClass();
            com.oplus.statistics.f_renamed.d_renamed.a_renamed(TAG, new com.oplus.statistics.$$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(e_renamed));
        }
    }

    public static void onResume(android.content.Context context) {
        try {
            com.oplus.statistics.f_renamed.d_renamed.d_renamed(TAG, new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.-$$Lambda$d_renamed$nhpAeNaUWmgp10sBxnK9WrIh7e0
                @Override // com.oplus.statistics.f_renamed.e_renamed
                public final java.lang.Object get() {
                    return com.oplus.statistics.d_renamed.lambda$onResume$20();
                }
            });
            sPageVisitAgent.b_renamed(context);
        } catch (java.lang.Exception e_renamed) {
            e_renamed.getClass();
            com.oplus.statistics.f_renamed.d_renamed.a_renamed(TAG, new com.oplus.statistics.$$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(e_renamed));
        }
    }

    public static synchronized void onError(android.content.Context context) {
        try {
            com.oplus.statistics.f_renamed.d_renamed.d_renamed(TAG, new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.-$$Lambda$d_renamed$70qAmqZO9G52FVIzKHvmlW2drrc
                @Override // com.oplus.statistics.f_renamed.e_renamed
                public final java.lang.Object get() {
                    return com.oplus.statistics.d_renamed.lambda$onError$21();
                }
            });
            if (sExceptionHandler == null) {
                sExceptionHandler = new com.oplus.statistics.e_renamed(context);
                sExceptionHandler.a_renamed();
            }
        } catch (java.lang.Exception e_renamed) {
            e_renamed.getClass();
            com.oplus.statistics.f_renamed.d_renamed.a_renamed(TAG, new com.oplus.statistics.$$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(e_renamed));
        }
    }

    public static void onDebug(final android.content.Context context, final boolean z_renamed) {
        try {
            com.oplus.statistics.f_renamed.d_renamed.a_renamed(z_renamed);
            com.oplus.statistics.f_renamed.d_renamed.d_renamed(TAG, new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.-$$Lambda$d_renamed$q8J-IM1DaCy4zYZjhbiuJ9U3Ezg
                @Override // com.oplus.statistics.f_renamed.e_renamed
                public final java.lang.Object get() {
                    return com.oplus.statistics.d_renamed.lambda$onDebug$22(context, z_renamed);
                }
            });
            if (com.oplus.statistics.f_renamed.d_renamed.a_renamed()) {
                com.oplus.statistics.e_renamed.c_renamed.a_renamed(new java.lang.Runnable() { // from class: com.oplus.statistics.d_renamed.4
                    @Override // java.lang.Runnable
                    public void run() {
                        com.oplus.statistics.a_renamed.e_renamed.a_renamed(context, z_renamed);
                    }
                });
            }
        } catch (java.lang.Exception e_renamed) {
            e_renamed.getClass();
            com.oplus.statistics.f_renamed.d_renamed.a_renamed(TAG, new com.oplus.statistics.$$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(e_renamed));
        }
    }

    static /* synthetic */ java.lang.String lambda$onDebug$22(android.content.Context context, boolean z_renamed) {
        return "packageName:" + context.getPackageName() + ",isDebug:" + z_renamed;
    }

    public static void setDebug(final boolean z_renamed) {
        try {
            com.oplus.statistics.f_renamed.d_renamed.a_renamed(z_renamed);
            com.oplus.statistics.f_renamed.d_renamed.d_renamed(TAG, new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.-$$Lambda$d_renamed$nM7V5oDXwOvSGxtsCf-gKj5mUl8
                @Override // com.oplus.statistics.f_renamed.e_renamed
                public final java.lang.Object get() {
                    return com.oplus.statistics.d_renamed.lambda$setDebug$23(z_renamed);
                }
            });
        } catch (java.lang.Exception e_renamed) {
            e_renamed.getClass();
            com.oplus.statistics.f_renamed.d_renamed.a_renamed(TAG, new com.oplus.statistics.$$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(e_renamed));
        }
    }

    static /* synthetic */ java.lang.String lambda$setDebug$23(boolean z_renamed) {
        return "onDebug (no context) sdk and dcs isDebug:" + z_renamed;
    }

    static /* synthetic */ java.lang.String lambda$setSessionTimeOut$24(int i_renamed) {
        return "setSession timeout is_renamed " + i_renamed;
    }

    public static void setSessionTimeOut(android.content.Context context, final int i_renamed) {
        com.oplus.statistics.f_renamed.d_renamed.d_renamed(TAG, new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.-$$Lambda$d_renamed$6omNxd-cPv7Zz9nPZS4ITSwCc68
            @Override // com.oplus.statistics.f_renamed.e_renamed
            public final java.lang.Object get() {
                return com.oplus.statistics.d_renamed.lambda$setSessionTimeOut$24(i_renamed);
            }
        });
        if (i_renamed > 0) {
            try {
                com.oplus.statistics.d_renamed.b_renamed.b_renamed(context, i_renamed);
            } catch (java.lang.Exception e_renamed) {
                e_renamed.getClass();
                com.oplus.statistics.f_renamed.d_renamed.a_renamed(TAG, new com.oplus.statistics.$$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(e_renamed));
            }
        }
    }

    static /* synthetic */ java.lang.String lambda$setSsoID$25(java.lang.String str) {
        return "setSsoid ssoid is_renamed " + str;
    }

    public static void setSsoID(android.content.Context context, final java.lang.String str) {
        com.oplus.statistics.f_renamed.d_renamed.d_renamed(TAG, new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.-$$Lambda$d_renamed$nUA4R37I2DdqR8-R0fTvEgtyAe0
            @Override // com.oplus.statistics.f_renamed.e_renamed
            public final java.lang.Object get() {
                return com.oplus.statistics.d_renamed.lambda$setSsoID$25(str);
            }
        });
        if (android.text.TextUtils.isEmpty(str) || str.equals("null")) {
            str = "0";
        }
        try {
            com.oplus.statistics.d_renamed.b_renamed.c_renamed(context, str);
        } catch (java.lang.Exception e_renamed) {
            e_renamed.getClass();
            com.oplus.statistics.f_renamed.d_renamed.a_renamed(TAG, new com.oplus.statistics.$$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(e_renamed));
        }
    }

    public static void removeSsoID(android.content.Context context) {
        try {
            com.oplus.statistics.f_renamed.d_renamed.d_renamed(TAG, new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.-$$Lambda$d_renamed$8Le0WGDX5K50bqtG6NMawICSMdw
                @Override // com.oplus.statistics.f_renamed.e_renamed
                public final java.lang.Object get() {
                    return com.oplus.statistics.d_renamed.lambda$removeSsoID$26();
                }
            });
            com.oplus.statistics.d_renamed.b_renamed.g_renamed(context);
        } catch (java.lang.Exception e_renamed) {
            e_renamed.getClass();
            com.oplus.statistics.f_renamed.d_renamed.a_renamed(TAG, new com.oplus.statistics.$$Lambda$myXMwNwgq7ehkoTIK8c6duDhMbk(e_renamed));
        }
    }

    private static boolean formatCheck(java.lang.String str, java.lang.String str2, int i_renamed) {
        if (str == null) {
            com.oplus.statistics.f_renamed.d_renamed.a_renamed(TAG, new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.-$$Lambda$d_renamed$BS-Yo24Q0JPBj4sDGGCYBN3EBkU
                @Override // com.oplus.statistics.f_renamed.e_renamed
                public final java.lang.Object get() {
                    return com.oplus.statistics.d_renamed.lambda$formatCheck$27();
                }
            });
            return false;
        }
        if (!EVENTID_PATTERN.matcher(str).find()) {
            com.oplus.statistics.f_renamed.d_renamed.a_renamed(TAG, new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.-$$Lambda$d_renamed$ce_uWybGT5lxUNuPCthZKr3ttQs
                @Override // com.oplus.statistics.f_renamed.e_renamed
                public final java.lang.Object get() {
                    return com.oplus.statistics.d_renamed.lambda$formatCheck$28();
                }
            });
            return false;
        }
        if (str2 == null) {
            com.oplus.statistics.f_renamed.d_renamed.a_renamed(TAG, new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.-$$Lambda$d_renamed$0A0ZDhAz90y3dJYog3t50gaey4Y
                @Override // com.oplus.statistics.f_renamed.e_renamed
                public final java.lang.Object get() {
                    return com.oplus.statistics.d_renamed.lambda$formatCheck$29();
                }
            });
            return false;
        }
        if (i_renamed <= 10000 && i_renamed >= 1) {
            return true;
        }
        com.oplus.statistics.f_renamed.d_renamed.a_renamed(TAG, new com.oplus.statistics.f_renamed.e_renamed() { // from class: com.oplus.statistics.-$$Lambda$d_renamed$kP94Q9bHc7hRQxX9nitGXI8r7AY
            @Override // com.oplus.statistics.f_renamed.e_renamed
            public final java.lang.Object get() {
                return com.oplus.statistics.d_renamed.lambda$formatCheck$30();
            }
        });
        return false;
    }
}
