package com.oplus.camera.perf;

import androidx.annotation.Keep;
import com.oplus.camera.CameraLog;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.p146gl.Utils_3;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class ComprehensivePerformance {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final ArrayDeque<Long> f15098a = new ArrayDeque<>();

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static final ArrayDeque<CPURunningInfo> f15099b = new ArrayDeque<>();

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static final HashMap<Long, C2843a> f15100c = new HashMap<>();

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static final HashMap<Long, PerformanceRecordData> f15101d = new HashMap<>();

    @Keep
    public static class PerformanceRecordData {
        int cameraId = 0;
        String capMode = "";
        HashMap<String, Long> algoTimes = new HashMap<>();
        long halCollectTime = 0;
        long codecTime = 0;
        long updateTime = 0;
        long apsWaitTime = 0;
        long appWaitTime = 0;
        long reprocessTime = 0;
        long totalTime = 0;
        String cpuInfo = null;

        public long getPictureSaveTime() {
            return this.totalTime;
        }

        public void calAppWaitTime() {
            Iterator<Long> it = this.algoTimes.values().iterator();
            long jLongValue = 0;
            while (it.hasNext()) {
                jLongValue += it.next().longValue();
            }
            this.appWaitTime = (((((this.totalTime - jLongValue) - this.apsWaitTime) - this.halCollectTime) - this.codecTime) - this.updateTime) - this.reprocessTime;
            long OplusGLSurfaceView_15 = this.appWaitTime;
            this.appWaitTime = OplusGLSurfaceView_15 >= 0 ? OplusGLSurfaceView_15 : 0L;
        }

        public boolean isModeNeedReport() {
            return (ApsConstant.CAPTURE_MODE_NIGHT.equals(this.capMode) || ApsConstant.CAPTURE_MODE_PANORAMA.equals(this.capMode)) ? false : true;
        }

        public boolean isNeedReport() {
            if (!isModeNeedReport()) {
                return false;
            }
            long OplusGLSurfaceView_15 = this.totalTime - this.apsWaitTime;
            return OplusGLSurfaceView_15 > 3500 && OplusGLSurfaceView_15 < 8000;
        }
    }

    /* renamed from: com.oplus.camera.perf.ComprehensivePerformance$PlatformImplementations.kt_3 */
    private static class C2843a {

        /* renamed from: PlatformImplementations.kt_3 */
        int f15102a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        String f15103b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        long f15104c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        long f15105d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        long f15106e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        CPURunningInfo f15107f;

        private C2843a() {
            this.f15102a = 0;
            this.f15103b = "";
            this.f15104c = 0L;
            this.f15105d = 0L;
            this.f15106e = 0L;
            this.f15107f = null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m15114a(long OplusGLSurfaceView_15) {
        C2843a c2843a = f15100c.get(Long.valueOf(OplusGLSurfaceView_15));
        if (c2843a == null) {
            CameraLog.m12967f("ComprehensivePerformance", "afterProcessImage, shutter time not found for this identity: " + OplusGLSurfaceView_15);
            return;
        }
        if (c2843a.f15105d == 0) {
            c2843a.f15105d = System.currentTimeMillis();
            CameraLog.m12959b("ComprehensivePerformance", "afterProcessImage, timestamp: " + Utils_3.m14288a(c2843a.f15105d) + ", timestamp: " + OplusGLSurfaceView_15);
            return;
        }
        CameraLog.m12959b("ComprehensivePerformance", "afterProcessImage, reprocessing");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m15116a(HashMap<String, Long> map, long OplusGLSurfaceView_15, Long OplusGLSurfaceView_14) {
        if (map == null || map.isEmpty()) {
            CameraLog.m12967f("ComprehensivePerformance", "onResultCallback, procTimer is empty");
            f15100c.remove(OplusGLSurfaceView_14);
            return;
        }
        if (OplusGLSurfaceView_14 == null || f15100c.get(OplusGLSurfaceView_14) == null) {
            CameraLog.m12967f("ComprehensivePerformance", "onResultCallback, identity is null or event record not found for identity: " + OplusGLSurfaceView_14);
            return;
        }
        C2843a c2843a = f15100c.get(OplusGLSurfaceView_14);
        if (c2843a == null || 0 == c2843a.f15104c || 0 == c2843a.f15105d) {
            CameraLog.m12967f("ComprehensivePerformance", "onResultCallback, invalid record for identity " + OplusGLSurfaceView_14);
            return;
        }
        Long l2 = map.get("codec_time");
        if (l2 == null) {
            CameraLog.m12967f("ComprehensivePerformance", "onResultCallback, codec time lost in apsResult");
            l2 = 0L;
        } else {
            map.remove("codec_time");
        }
        Long l3 = map.get("proc_queue_wait");
        if (l3 == null) {
            CameraLog.m12967f("ComprehensivePerformance", "onResultCallback, APS wait time lost in apsResult");
            l3 = 0L;
        } else {
            map.remove("proc_queue_wait");
        }
        c2843a.f15106e = OplusGLSurfaceView_15;
        PerformanceRecordData performanceRecordData = new PerformanceRecordData();
        performanceRecordData.halCollectTime = c2843a.f15105d - c2843a.f15104c;
        performanceRecordData.apsWaitTime = l3.longValue();
        performanceRecordData.codecTime = l2.longValue();
        performanceRecordData.algoTimes = map;
        Long l4 = map.get("reprocess_time");
        if (l4 != null) {
            performanceRecordData.reprocessTime = l4.longValue();
            map.remove("reprocess_time");
        }
        f15101d.put(OplusGLSurfaceView_14, performanceRecordData);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m15118b(long OplusGLSurfaceView_15) {
        C2843a c2843a = f15100c.get(Long.valueOf(OplusGLSurfaceView_15));
        PerformanceRecordData performanceRecordData = f15101d.get(Long.valueOf(OplusGLSurfaceView_15));
        if (c2843a == null || performanceRecordData == null) {
            CameraLog.m12967f("ComprehensivePerformance", "eventRecord or perfRecord not found");
            return;
        }
        CPURunningInfo c2861a = new CPURunningInfo();
        c2861a.m15181b();
        c2861a.m15182c();
        c2861a.m15179a(c2843a.f15107f);
        long jCurrentTimeMillis = System.currentTimeMillis();
        performanceRecordData.updateTime = jCurrentTimeMillis - c2843a.f15106e;
        performanceRecordData.totalTime = jCurrentTimeMillis - c2843a.f15104c;
        performanceRecordData.calAppWaitTime();
        performanceRecordData.cameraId = c2843a.f15102a;
        performanceRecordData.capMode = c2843a.f15103b;
        performanceRecordData.cpuInfo = c2861a.m15183d() ? c2861a.toString() : "";
        Performance.add(performanceRecordData);
        f15101d.remove(Long.valueOf(OplusGLSurfaceView_15));
        f15100c.remove(Long.valueOf(OplusGLSurfaceView_15));
        if (m15120c()) {
            return;
        }
        c2861a.m15180a(false);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static void m15119c(long OplusGLSurfaceView_15) {
        CameraLog.m12959b("ComprehensivePerformance", "addClickShutterTime, clickShutterTime: " + OplusGLSurfaceView_15);
        CPURunningInfo c2861a = new CPURunningInfo();
        c2861a.m15181b();
        c2861a.m15180a(true);
        if (m15120c()) {
            c2861a.m15182c();
        }
        f15098a.add(Long.valueOf(OplusGLSurfaceView_15));
        f15099b.add(c2861a);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m15113a() {
        Long lPollLast = f15098a.pollLast();
        f15099b.pollLast();
        CameraLog.m12959b("ComprehensivePerformance", "pollClickEventQueue, shutterTime: " + lPollLast);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static long m15117b() {
        Long lPoll = f15098a.poll();
        if (lPoll == null) {
            return -1L;
        }
        return lPoll.longValue();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m15115a(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, String str) {
        long jM15117b = m15117b();
        if (-1 == jM15117b) {
            CameraLog.m12967f("ComprehensivePerformance", "onFirstFrameArrived, no shutter in queue");
            return;
        }
        C2843a c2843a = new C2843a();
        c2843a.f15104c = jM15117b;
        c2843a.f15102a = OplusGLSurfaceView_13;
        c2843a.f15103b = str;
        c2843a.f15107f = f15099b.poll();
        f15100c.put(Long.valueOf(OplusGLSurfaceView_15), c2843a);
        CameraLog.m12959b("ComprehensivePerformance", "onFirstFrameArrived, shutterTime: " + c2843a.f15104c + ", identity: " + OplusGLSurfaceView_15);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static boolean m15120c() {
        return f15098a.size() > 0 || f15100c.size() > 0;
    }
}
