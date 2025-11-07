package com.oplus.camera.f_renamed;

/* compiled from: DiagnosisTools.java */
/* loaded from: classes2.dex */
public final class a_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static java.util.LinkedHashMap<java.lang.Long, java.lang.Long> f4460a = new java.util.LinkedHashMap<java.lang.Long, java.lang.Long>() { // from class: com.oplus.camera.f_renamed.a_renamed.1
        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(java.util.Map.Entry<java.lang.Long, java.lang.Long> entry) {
            return size() > 10;
        }
    };

    /* renamed from: b_renamed, reason: collision with root package name */
    private static java.util.LinkedHashMap<java.lang.Long, java.lang.Long> f4461b = new java.util.LinkedHashMap<java.lang.Long, java.lang.Long>() { // from class: com.oplus.camera.f_renamed.a_renamed.2
        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(java.util.Map.Entry<java.lang.Long, java.lang.Long> entry) {
            return size() > 10;
        }
    };

    /* renamed from: c_renamed, reason: collision with root package name */
    private static java.util.concurrent.Executor f4462c = java.util.concurrent.Executors.newSingleThreadExecutor();
    private static long d_renamed = -1;
    private static long e_renamed = -1;
    private static boolean f_renamed = false;

    public static void a_renamed(long j_renamed, long j2) {
        if (f_renamed) {
            return;
        }
        if (j_renamed >= 70 && j_renamed <= 150) {
            f4460a.put(java.lang.Long.valueOf(j2), java.lang.Long.valueOf(j_renamed));
        }
        if (10 == f4460a.size() && a_renamed(f4460a, d_renamed)) {
            java.util.Map.Entry entryB = b_renamed(f4460a);
            if (entryB != null) {
                d_renamed = ((java.lang.Long) entryB.getKey()).longValue();
            }
            android.util.ArrayMap arrayMap = new android.util.ArrayMap();
            arrayMap.put("preview_frame_gap", java.lang.String.valueOf(f4460a));
            a_renamed("070102", arrayMap);
            com.oplus.camera.e_renamed.a_renamed("DiagnosisTools", "map: " + arrayMap);
            f4460a.clear();
        }
    }

    private static boolean a_renamed(java.util.LinkedHashMap<java.lang.Long, java.lang.Long> linkedHashMap, long j_renamed) {
        java.util.Map.Entry entryB = b_renamed(linkedHashMap);
        java.util.Map.Entry entryA = a_renamed(linkedHashMap);
        return entryB != null && entryA != null && ((java.lang.Long) entryB.getKey()).longValue() - ((java.lang.Long) entryA.getKey()).longValue() == 9 && j_renamed < ((java.lang.Long) entryA.getKey()).longValue();
    }

    private static <K_renamed, V_renamed> java.util.Map.Entry<K_renamed, V_renamed> a_renamed(java.util.LinkedHashMap<K_renamed, V_renamed> linkedHashMap) {
        if (linkedHashMap.size() > 0) {
            return (java.util.Map.Entry) linkedHashMap.entrySet().toArray()[0];
        }
        return null;
    }

    private static <K_renamed, V_renamed> java.util.Map.Entry<K_renamed, V_renamed> b_renamed(java.util.LinkedHashMap<K_renamed, V_renamed> linkedHashMap) {
        if (linkedHashMap.size() > 0) {
            return (java.util.Map.Entry) linkedHashMap.entrySet().toArray()[linkedHashMap.size() - 1];
        }
        return null;
    }

    public static void a_renamed(long j_renamed) {
        com.oplus.camera.e_renamed.a_renamed("DiagnosisTools", "reportLaunchTime, launchTime: " + j_renamed);
        if (j_renamed < 2500 || j_renamed > 10000) {
            return;
        }
        android.util.ArrayMap arrayMap = new android.util.ArrayMap();
        arrayMap.put("launch_time", java.lang.String.valueOf(j_renamed));
        a_renamed("070103", arrayMap);
    }

    public static void b_renamed(long j_renamed) {
        com.oplus.camera.e_renamed.a_renamed("DiagnosisTools", "reportCaptureTime, captureTime: " + j_renamed);
        if (j_renamed < 4000 || j_renamed > 10000) {
            return;
        }
        android.util.ArrayMap arrayMap = new android.util.ArrayMap();
        arrayMap.put("capture_time", java.lang.String.valueOf(j_renamed));
        a_renamed("070101", arrayMap);
    }

    public static void c_renamed(long j_renamed) {
        com.oplus.camera.e_renamed.a_renamed("DiagnosisTools", "reportVideoSaveTime, videoSaveTime: " + j_renamed);
        if (j_renamed < 2500 || j_renamed > 10000) {
            return;
        }
        android.util.ArrayMap arrayMap = new android.util.ArrayMap();
        arrayMap.put("video_save_time", java.lang.String.valueOf(j_renamed));
        a_renamed("070105", arrayMap);
    }

    public static void b_renamed(long j_renamed, long j2) {
        if (j_renamed >= 50 && j_renamed <= 150) {
            f4461b.put(java.lang.Long.valueOf(j2), java.lang.Long.valueOf(j_renamed));
        }
        if (10 == f4461b.size() && a_renamed(f4461b, e_renamed)) {
            java.util.Map.Entry entryB = b_renamed(f4461b);
            if (entryB != null) {
                e_renamed = ((java.lang.Long) entryB.getKey()).longValue();
            }
            android.util.ArrayMap arrayMap = new android.util.ArrayMap();
            arrayMap.put("video_recording_frame_gap", java.lang.String.valueOf(f4461b));
            a_renamed("070104", arrayMap);
        }
    }

    private static void a_renamed(final java.lang.String str, final java.util.Map<java.lang.String, java.lang.String> map) {
        com.oplus.camera.e_renamed.a_renamed("DiagnosisTools", "report, eventId: " + str + ", map: " + map);
        f4462c.execute(new java.lang.Runnable() { // from class: com.oplus.camera.f_renamed.a_renamed.3
            @Override // java.lang.Runnable
            public void run() {
                android.os.OplusManager.onStamp(str, map);
            }
        });
    }

    public static void a_renamed() {
        d_renamed = -1L;
        e_renamed = -1L;
        f_renamed = false;
    }
}
