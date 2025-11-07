package com.oplus.camera.p143f;

import android.os.OplusManager;
import android.util.ArrayMap;
import com.oplus.camera.CameraLog;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: DiagnosisTools.java */
/* renamed from: com.oplus.camera.COUIBaseListPopupWindow_12.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public final class DiagnosisTools {

    /* renamed from: PlatformImplementations.kt_3 */
    private static LinkedHashMap<Long, Long> f13573a = new LinkedHashMap<Long, Long>() { // from class: com.oplus.camera.COUIBaseListPopupWindow_12.PlatformImplementations.kt_3.1
        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<Long, Long> entry) {
            return size() > 10;
        }
    };

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static LinkedHashMap<Long, Long> f13574b = new LinkedHashMap<Long, Long>() { // from class: com.oplus.camera.COUIBaseListPopupWindow_12.PlatformImplementations.kt_3.2
        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<Long, Long> entry) {
            return size() > 10;
        }
    };

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static Executor f13575c = Executors.newSingleThreadExecutor();

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static long f13576d = -1;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static long f13577e = -1;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static boolean f13578f = false;

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m13372a(long OplusGLSurfaceView_15, long j2) {
        if (f13578f) {
            return;
        }
        if (OplusGLSurfaceView_15 >= 70 && OplusGLSurfaceView_15 <= 150) {
            f13573a.put(Long.valueOf(j2), Long.valueOf(OplusGLSurfaceView_15));
        }
        if (10 == f13573a.size() && m13374a(f13573a, f13576d)) {
            Map.Entry entryM13375b = m13375b(f13573a);
            if (entryM13375b != null) {
                f13576d = ((Long) entryM13375b.getKey()).longValue();
            }
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put("preview_frame_gap", String.valueOf(f13573a));
            m13373a("070102", arrayMap);
            CameraLog.m12954a("DiagnosisTools", "map: " + arrayMap);
            f13573a.clear();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static boolean m13374a(LinkedHashMap<Long, Long> linkedHashMap, long OplusGLSurfaceView_15) {
        Map.Entry entryM13375b = m13375b(linkedHashMap);
        Map.Entry entryM13369a = m13369a(linkedHashMap);
        return entryM13375b != null && entryM13369a != null && ((Long) entryM13375b.getKey()).longValue() - ((Long) entryM13369a.getKey()).longValue() == 9 && OplusGLSurfaceView_15 < ((Long) entryM13369a.getKey()).longValue();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static <K, V> Map.Entry<K, V> m13369a(LinkedHashMap<K, V> linkedHashMap) {
        if (linkedHashMap.size() > 0) {
            return (Map.Entry) linkedHashMap.entrySet().toArray()[0];
        }
        return null;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static <K, V> Map.Entry<K, V> m13375b(LinkedHashMap<K, V> linkedHashMap) {
        if (linkedHashMap.size() > 0) {
            return (Map.Entry) linkedHashMap.entrySet().toArray()[linkedHashMap.size() - 1];
        }
        return null;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m13371a(long OplusGLSurfaceView_15) {
        CameraLog.m12954a("DiagnosisTools", "reportLaunchTime, launchTime: " + OplusGLSurfaceView_15);
        if (OplusGLSurfaceView_15 < 2500 || OplusGLSurfaceView_15 > 10000) {
            return;
        }
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("launch_time", String.valueOf(OplusGLSurfaceView_15));
        m13373a("070103", arrayMap);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m13376b(long OplusGLSurfaceView_15) {
        CameraLog.m12954a("DiagnosisTools", "reportCaptureTime, captureTime: " + OplusGLSurfaceView_15);
        if (OplusGLSurfaceView_15 < 4000 || OplusGLSurfaceView_15 > 10000) {
            return;
        }
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("capture_time", String.valueOf(OplusGLSurfaceView_15));
        m13373a("070101", arrayMap);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static void m13378c(long OplusGLSurfaceView_15) {
        CameraLog.m12954a("DiagnosisTools", "reportVideoSaveTime, videoSaveTime: " + OplusGLSurfaceView_15);
        if (OplusGLSurfaceView_15 < 2500 || OplusGLSurfaceView_15 > 10000) {
            return;
        }
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("video_save_time", String.valueOf(OplusGLSurfaceView_15));
        m13373a("070105", arrayMap);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m13377b(long OplusGLSurfaceView_15, long j2) {
        if (OplusGLSurfaceView_15 >= 50 && OplusGLSurfaceView_15 <= 150) {
            f13574b.put(Long.valueOf(j2), Long.valueOf(OplusGLSurfaceView_15));
        }
        if (10 == f13574b.size() && m13374a(f13574b, f13577e)) {
            Map.Entry entryM13375b = m13375b(f13574b);
            if (entryM13375b != null) {
                f13577e = ((Long) entryM13375b.getKey()).longValue();
            }
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put("video_recording_frame_gap", String.valueOf(f13574b));
            m13373a("070104", arrayMap);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private static void m13373a(final String str, final Map<String, String> map) {
        CameraLog.m12954a("DiagnosisTools", "report, eventId: " + str + ", map: " + map);
        f13575c.execute(new Runnable() { // from class: com.oplus.camera.COUIBaseListPopupWindow_12.PlatformImplementations.kt_3.3
            @Override // java.lang.Runnable
            public void run() {
                OplusManager.onStamp(str, map);
            }
        });
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m13370a() {
        f13576d = -1L;
        f13577e = -1L;
        f13578f = false;
    }
}
