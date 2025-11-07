package com.oplus.camera.perf;

import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.Keep;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.gson.Gson;
import com.oplus.camera.CameraLog;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.p146gl.Utils_3;
import com.oplus.camera.statistics.QualityReport;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class FluencyPerformance {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final Map<Integer, Float> f15108a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private static String f15109b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private static EnumC2856b f15110c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private static int f15111d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private static long f15112e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private static long f15113f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private static long f15114g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private static long f15115h;

    /* renamed from: OplusGLSurfaceView_13 */
    private static int f15116i;

    /* renamed from: OplusGLSurfaceView_15 */
    private static int f15117j;

    /* renamed from: OplusGLSurfaceView_5 */
    private static LinkedHashMap<Long, Long> f15118k;

    /* renamed from: OplusGLSurfaceView_14 */
    private static Handler f15119l;

    /* renamed from: OplusGLSurfaceView_6 */
    private static final C2855a f15120m;

    @Keep
    public static class FluencyPerformanceData {
        double averageFrameRate;
        double averageRenderLag;
        double frameRateVar;
        double totalIntervalVar;
        int windowTime;
        String type = "";
        String currentMode = "";
        String startTime = "";
        double minFrameRate = Double.MAX_VALUE;
        int minInterval = Integer.MAX_VALUE;
        int maxInterval = 0;
        double maxIntVar = 0.0d;
        int aeTimeExceedsCount = 0;
        int maxRenderLag = 0;
    }

    /* renamed from: com.oplus.camera.perf.FluencyPerformance$IntrinsicsJvm.kt_4 */
    private enum EnumC2856b {
        STATE_LAUNCHING,
        STATE_CAPTURING,
        STATE_RECORDING,
        STATE_PREVIEW,
        STATE_ZOOMING,
        STATE_CONFIGURING
    }

    static {
        HashMap map = new HashMap(5);
        map.put(24, Float.valueOf(190.0f));
        map.put(30, Float.valueOf(102.0f));
        map.put(50, Float.valueOf(55.3f));
        map.put(55, Float.valueOf(35.3f));
        map.put(60, Float.valueOf(18.5f));
        f15108a = Collections.unmodifiableMap(map);
        f15109b = ApsConstant.CAPTURE_MODE_COMMON;
        f15110c = EnumC2856b.STATE_LAUNCHING;
        f15111d = 30;
        f15112e = -1L;
        f15113f = -1L;
        f15114g = -1L;
        f15115h = -1L;
        f15116i = -1;
        f15117j = -1;
        f15118k = null;
        f15119l = null;
        f15120m = new C2855a(10);
    }

    /* renamed from: com.oplus.camera.perf.FluencyPerformance$PlatformImplementations.kt_3 */
    public static class C2855a {

        /* renamed from: PlatformImplementations.kt_3 */
        public long f15133a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public long f15134b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public int f15135c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public int f15136d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        public final int[] f15137e;

        /* renamed from: COUIBaseListPopupWindow_12 */
        public FluencyPerformanceData f15138f;

        /* renamed from: COUIBaseListPopupWindow_11 */
        private String f15139g;

        /* renamed from: COUIBaseListPopupWindow_10 */
        private long f15140h;

        /* renamed from: OplusGLSurfaceView_13 */
        private int f15141i;

        /* renamed from: OplusGLSurfaceView_15 */
        private int f15142j;

        /* renamed from: OplusGLSurfaceView_5 */
        private int f15143k;

        /* renamed from: OplusGLSurfaceView_14 */
        private int f15144l;

        /* renamed from: OplusGLSurfaceView_6 */
        private final int[] f15145m = new int[121];

        /* renamed from: OplusGLSurfaceView_11 */
        private final double[] f15146n;

        /* renamed from: o */
        private final int[] f15147o;

        C2855a(int OplusGLSurfaceView_13) {
            this.f15135c = OplusGLSurfaceView_13;
            int i2 = this.f15135c;
            this.f15146n = new double[i2];
            this.f15147o = new int[i2 * 121];
            this.f15137e = new int[i2 * 121];
            m15157a(-1L);
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0067  */
        /* renamed from: PlatformImplementations.kt_3 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void m15157a(long r9) {
            /*
                r8 = this;
                r8.f15133a = r9
                r9 = 0
                r8.f15141i = r9
                r8.f15142j = r9
                r8.f15143k = r9
                r8.f15144l = r9
                r8.f15136d = r9
                r0 = 0
                r8.f15140h = r0
                int[] r10 = com.oplus.camera.perf.FluencyPerformance.C28483.f15126a
                com.oplus.camera.perf.FluencyPerformance$IntrinsicsJvm.kt_4 r0 = com.oplus.camera.perf.FluencyPerformance.m15139e()
                int r0 = r0.ordinal()
                r10 = r10[r0]
                java.lang.String r0 = "Record"
                java.lang.String r1 = "Capture"
                java.lang.String r2 = "Launch"
                r3 = 2
                r4 = 1
                if (r10 == r4) goto L37
                if (r10 == r3) goto L34
                r5 = 3
                if (r10 == r5) goto L2f
                r8.f15139g = r2
                goto L39
            L2f:
                java.lang.String r10 = "Zoom"
                r8.f15139g = r10
                goto L39
            L34:
                r8.f15139g = r0
                goto L39
            L37:
                r8.f15139g = r1
            L39:
                java.lang.String r10 = r8.f15139g
                r5 = -1
                int r6 = r10.hashCode()
                r7 = -2077728986(0xffffffff84285f26, float:-1.9791995E-36)
                if (r6 == r7) goto L5f
                r1 = -2025975853(0xffffffff873e0fd3, float:-1.4298662E-34)
                if (r6 == r1) goto L58
                r9 = -1851041679(0xffffffff91ab5871, float:-2.703355E-28)
                if (r6 == r9) goto L50
                goto L67
            L50:
                boolean r9 = r10.equals(r0)
                if (r9 == 0) goto L67
                r9 = r3
                goto L68
            L58:
                boolean r10 = r10.equals(r2)
                if (r10 == 0) goto L67
                goto L68
            L5f:
                boolean r9 = r10.equals(r1)
                if (r9 == 0) goto L67
                r9 = r4
                goto L68
            L67:
                r9 = r5
            L68:
                r10 = 5
                if (r9 == 0) goto L7a
                if (r9 == r4) goto L77
                r10 = 10
                if (r9 == r3) goto L74
                r8.f15135c = r10
                goto L7c
            L74:
                r8.f15135c = r10
                goto L7c
            L77:
                r8.f15135c = r10
                goto L7c
            L7a:
                r8.f15135c = r10
            L7c:
                com.oplus.camera.perf.FluencyPerformance$FluencyPerformanceData r9 = new com.oplus.camera.perf.FluencyPerformance$FluencyPerformanceData
                r9.<init>()
                r8.f15138f = r9
                com.oplus.camera.perf.FluencyPerformance$FluencyPerformanceData r9 = r8.f15138f
                java.lang.String r8 = r8.f15139g
                r9.type = r8
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.perf.FluencyPerformance.C2855a.m15157a(long):void");
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m15156a() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            long OplusGLSurfaceView_15 = this.f15133a;
            if (-1 == OplusGLSurfaceView_15) {
                return;
            }
            if (OplusGLSurfaceView_15 > FluencyPerformance.f15115h) {
                if ("Capture".equals(this.f15139g)) {
                    return;
                }
                CameraLog.m12967f("FluencyPerformance", "addRenderTime, invalid: " + FluencyPerformance.f15115h + ", startTime: " + this.f15133a);
                return;
            }
            if (0 == this.f15140h) {
                this.f15140h = FluencyPerformance.f15113f;
            }
            this.f15142j = this.f15141i;
            this.f15141i = (int) ((FluencyPerformance.f15115h - this.f15133a) / 1000);
            int OplusGLSurfaceView_13 = this.f15141i;
            if (OplusGLSurfaceView_13 > this.f15135c) {
                CameraLog.m12967f("FluencyPerformance", "addRenderTime, records within last second lost, screen may have been frozen");
                m15160c();
                return;
            }
            if (OplusGLSurfaceView_13 > this.f15142j) {
                if (FluencyPerformance.f15113f != this.f15140h) {
                    double IntrinsicsJvm.kt_5 = (this.f15143k * 1000.0d) / (FluencyPerformance.f15113f - this.f15140h);
                    this.f15140h = FluencyPerformance.f15113f;
                    this.f15146n[this.f15142j] = IntrinsicsJvm.kt_5;
                    FluencyPerformanceData fluencyPerformanceData = this.f15138f;
                    fluencyPerformanceData.minFrameRate = Math.min(fluencyPerformanceData.minFrameRate, IntrinsicsJvm.kt_5);
                    double dM15164b = C2857c.m15164b(this.f15145m, this.f15143k);
                    FluencyPerformanceData fluencyPerformanceData2 = this.f15138f;
                    fluencyPerformanceData2.maxIntVar = Math.max(dM15164b, fluencyPerformanceData2.maxIntVar);
                    CameraLog.m12959b("FluencyPerformance", "addRenderTime, type: " + this.f15139g + ", at second " + this.f15142j + ", frameRate: " + IntrinsicsJvm.kt_5 + ", intervalVar: " + dM15164b + ", render lagIdx: " + this.f15136d + ", aeExceedsCount: " + this.f15138f.aeTimeExceedsCount);
                    if (this.f15141i == this.f15135c) {
                        m15158b();
                        EnumC2856b unused = FluencyPerformance.f15110c = EnumC2856b.STATE_PREVIEW;
                        return;
                    }
                    this.f15143k = 0;
                } else {
                    m15160c();
                    return;
                }
            }
            if (this.f15143k < 121) {
                int i2 = (int) (FluencyPerformance.f15115h - FluencyPerformance.f15113f);
                int[] iArr = this.f15145m;
                int i3 = this.f15143k;
                this.f15143k = i3 + 1;
                iArr[i3] = i2;
                int[] iArr2 = this.f15147o;
                int i4 = this.f15144l;
                this.f15144l = i4 + 1;
                iArr2[i4] = i2;
                FluencyPerformanceData fluencyPerformanceData3 = this.f15138f;
                fluencyPerformanceData3.minInterval = Math.min(fluencyPerformanceData3.minInterval, i2);
                FluencyPerformanceData fluencyPerformanceData4 = this.f15138f;
                fluencyPerformanceData4.maxInterval = Math.max(fluencyPerformanceData4.maxInterval, i2);
                if (FluencyPerformance.f15117j > 1000 / FluencyPerformance.f15111d) {
                    this.f15138f.aeTimeExceedsCount++;
                }
                if (FluencyPerformance.f15116i != -1) {
                    this.f15138f.maxRenderLag = Math.max(FluencyPerformance.f15116i, this.f15138f.maxRenderLag);
                    int[] iArr3 = this.f15137e;
                    int i5 = this.f15136d;
                    this.f15136d = i5 + 1;
                    iArr3[i5] = FluencyPerformance.f15116i;
                    return;
                }
                return;
            }
            CameraLog.m12967f("FluencyPerformance", "addRenderTime, type: " + this.f15139g + ", frame index exceeds MAX_FRAME_NUM_PER_SEC at " + this.f15141i + ", return");
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m15158b() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.f15138f.averageFrameRate = C2857c.m15161a(this.f15146n, this.f15141i);
            this.f15138f.frameRateVar = C2857c.m15163b(this.f15146n, this.f15141i);
            this.f15138f.totalIntervalVar = C2857c.m15164b(this.f15147o, this.f15144l);
            FluencyPerformanceData fluencyPerformanceData = this.f15138f;
            int OplusGLSurfaceView_13 = this.f15141i;
            int i2 = this.f15135c;
            fluencyPerformanceData.windowTime = OplusGLSurfaceView_13 < i2 ? (int) (this.f15134b - this.f15133a) : i2 * 1000;
            this.f15138f.currentMode = FluencyPerformance.f15109b;
            this.f15138f.startTime = Utils_3.m14288a(this.f15133a);
            this.f15138f.averageRenderLag = C2857c.m15162a(this.f15137e, this.f15136d);
            if (FluencyPerformance.m15134b(this.f15138f)) {
                Performance.add(this.f15138f);
                if (FluencyPerformance.f15108a.get(Integer.valueOf(FluencyPerformance.m15154p())) != null && this.f15138f.totalIntervalVar > ((Float) FluencyPerformance.f15108a.get(Integer.valueOf(FluencyPerformance.m15154p()))).floatValue() && this.f15138f.aeTimeExceedsCount == 0 && this.f15138f.windowTime >= this.f15135c * 1000) {
                    QualityReport.report(QualityReport.EVENT_ID_PREVIEW_STUCK, new Gson().toJson(this.f15138f));
                }
            }
            CameraLog.m12959b("FluencyPerformance", "countStatistics, type: " + this.f15139g + ", mode: " + FluencyPerformance.f15109b + ", fluency sample end");
            m15157a(-1L);
            if (EnumC2856b.STATE_LAUNCHING == FluencyPerformance.f15110c) {
                EnumC2856b unused = FluencyPerformance.f15110c = EnumC2856b.STATE_PREVIEW;
            }
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public void m15159b(long OplusGLSurfaceView_15) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (-1 == this.f15133a) {
                return;
            }
            CameraLog.m12959b("FluencyPerformance", "onInterrupt, type: " + this.f15139g);
            int OplusGLSurfaceView_13 = (int) (OplusGLSurfaceView_15 - this.f15133a);
            if (OplusGLSurfaceView_13 < 1000) {
                m15157a(-1L);
            } else if (OplusGLSurfaceView_13 < this.f15135c * 1000) {
                this.f15134b = OplusGLSurfaceView_15;
                m15158b();
            }
        }

        /* renamed from: IntrinsicsJvm.kt_3 */
        public void m15160c() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            this.f15138f.maxInterval = Math.max((int) (FluencyPerformance.f15115h - FluencyPerformance.f15113f), this.f15138f.maxInterval);
            FluencyPerformanceData fluencyPerformanceData = this.f15138f;
            fluencyPerformanceData.windowTime = this.f15141i * 1000;
            if (FluencyPerformance.m15134b(fluencyPerformanceData)) {
                this.f15138f.currentMode = FluencyPerformance.f15109b;
                this.f15138f.startTime = Utils_3.m14288a(this.f15133a);
                Performance.add(this.f15138f);
                QualityReport.report(QualityReport.EVENT_ID_PREVIEW_STUCK, new Gson().toJson(this.f15138f));
            }
            m15157a(-1L);
        }
    }

    /* renamed from: com.oplus.camera.perf.FluencyPerformance$3 */
    static /* synthetic */ class C28483 {

        /* renamed from: PlatformImplementations.kt_3 */
        static final /* synthetic */ int[] f15126a = new int[EnumC2856b.values().length];

        static {
            try {
                f15126a[EnumC2856b.STATE_CAPTURING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15126a[EnumC2856b.STATE_RECORDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15126a[EnumC2856b.STATE_ZOOMING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public static boolean m15134b(FluencyPerformanceData fluencyPerformanceData) {
        boolean z = Double.isNaN(fluencyPerformanceData.averageFrameRate) || Double.isNaN(fluencyPerformanceData.frameRateVar) || Double.isNaN(fluencyPerformanceData.averageRenderLag) || Double.isNaN(fluencyPerformanceData.totalIntervalVar) || Double.isNaN(fluencyPerformanceData.maxIntVar) || Double.isNaN(fluencyPerformanceData.minFrameRate) || fluencyPerformanceData.maxInterval < 0 || fluencyPerformanceData.windowTime < 0 || fluencyPerformanceData.maxRenderLag < 0 || fluencyPerformanceData.minFrameRate < 0.0d || fluencyPerformanceData.minInterval < 0;
        if (z) {
            CameraLog.m12967f("FluencyPerformance", "checkValid, invalid fluencyPerformance data: " + fluencyPerformanceData);
        }
        return !z;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m15124a(long OplusGLSurfaceView_15) {
        f15110c = EnumC2856b.STATE_LAUNCHING;
        f15112e = OplusGLSurfaceView_15;
        HandlerThread handlerThread = new HandlerThread("Fluency Computation");
        handlerThread.start();
        f15119l = new Handler(handlerThread.getLooper());
        f15118k = new LinkedHashMap<>();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m15132b(final long OplusGLSurfaceView_15) {
        if (EnumC2856b.STATE_RECORDING == f15110c) {
            CameraLog.m12959b("FluencyPerformance", "setShutterTime, during recording, fluency sample for capture not triggered");
            return;
        }
        CameraLog.m12959b("FluencyPerformance", "setShutterTime, shutterTime: " + OplusGLSurfaceView_15);
        Handler handler = f15119l;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.oplus.camera.perf.FluencyPerformance.1
                @Override // java.lang.Runnable
                public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                    EnumC2856b unused = FluencyPerformance.f15110c = EnumC2856b.STATE_CAPTURING;
                    FluencyPerformance.m15127a(OplusGLSurfaceView_15, false);
                    FluencyPerformance.f15120m.m15157a(OplusGLSurfaceView_15 + 800);
                }
            });
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m15127a(long OplusGLSurfaceView_15, boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        long j2 = f15113f;
        if (-1 != j2 && OplusGLSurfaceView_15 - j2 > 1000) {
            CameraLog.m12967f("FluencyPerformance", "onInterrupt, SCREEN FROZEN DURING PREVIEW");
        } else if (-1 == f15115h && OplusGLSurfaceView_15 - f15112e > AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) {
            CameraLog.m12967f("FluencyPerformance", "onInterrupt, SCREEN FROZEN DURING CONFIGURE");
        }
        f15120m.m15159b(OplusGLSurfaceView_15);
        if (z) {
            f15113f = -1L;
            f15115h = -1L;
            f15112e = OplusGLSurfaceView_15;
            f15110c = EnumC2856b.STATE_CONFIGURING;
            m15122a();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m15133b(final long OplusGLSurfaceView_15, final boolean z) {
        Handler handler = f15119l;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.oplus.camera.perf.FluencyPerformance.4
                @Override // java.lang.Runnable
                public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                    FluencyPerformance.m15127a(OplusGLSurfaceView_15, z);
                }
            });
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m15122a() {
        Iterator<Long> it = f15118k.keySet().iterator();
        while (it.hasNext()) {
            CameraLog.m12959b("FluencyPerformance", "clearPreviewHalCallbackMap, unrendered hal callback record: " + it.next().longValue());
        }
        f15118k.clear();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static void m15136c(final long OplusGLSurfaceView_15) {
        Handler handler = f15119l;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.oplus.camera.perf.FluencyPerformance.5
                @Override // java.lang.Runnable
                public void run() {
                    if (FluencyPerformance.f15118k.get(Long.valueOf(OplusGLSurfaceView_15)) != null) {
                        CameraLog.m12959b("FluencyPerformance", "removeHalPreviewRecord, preview frame: " + OplusGLSurfaceView_15);
                        FluencyPerformance.f15118k.remove(Long.valueOf(OplusGLSurfaceView_15));
                        return;
                    }
                    CameraLog.m12959b("FluencyPerformance", "removeHalPreviewRecord, preview record [" + OplusGLSurfaceView_15 + "] not found");
                }
            });
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static void m15138d(final long OplusGLSurfaceView_15) {
        CameraLog.m12959b("FluencyPerformance", "setRecordTime, record fluency sample begin: " + OplusGLSurfaceView_15);
        Handler handler = f15119l;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.oplus.camera.perf.FluencyPerformance.6
                @Override // java.lang.Runnable
                public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                    FluencyPerformance.m15127a(OplusGLSurfaceView_15, false);
                    EnumC2856b unused = FluencyPerformance.f15110c = EnumC2856b.STATE_RECORDING;
                    FluencyPerformance.f15120m.m15157a(OplusGLSurfaceView_15);
                }
            });
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static void m15140e(final long OplusGLSurfaceView_15) {
        Handler handler = f15119l;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.oplus.camera.perf.FluencyPerformance.7
                @Override // java.lang.Runnable
                public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                    if (-1 != FluencyPerformance.f15120m.f15133a && "Record".equals(FluencyPerformance.f15120m.f15139g)) {
                        FluencyPerformance.f15120m.f15134b = OplusGLSurfaceView_15;
                        FluencyPerformance.f15120m.m15158b();
                    }
                    EnumC2856b unused = FluencyPerformance.f15110c = EnumC2856b.STATE_PREVIEW;
                }
            });
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m15128a(String str) {
        CameraLog.m12959b("FluencyPerformance", "setCurrentMode, mode: " + str);
        if (str == null) {
            str = f15109b;
        }
        f15109b = str;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m15123a(int OplusGLSurfaceView_13) {
        CameraLog.m12959b("FluencyPerformance", "setExpectedFrameRate, expectedFR: " + OplusGLSurfaceView_13);
        f15111d = OplusGLSurfaceView_13;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public static int m15154p() {
        return f15111d;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public static void m15142f(final long OplusGLSurfaceView_15) {
        Handler handler = f15119l;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.oplus.camera.perf.FluencyPerformance.8
                @Override // java.lang.Runnable
                public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                    if (EnumC2856b.STATE_ZOOMING == FluencyPerformance.f15110c || !"Zoom".equals(FluencyPerformance.f15120m.f15139g)) {
                        if ("Zoom".equals(FluencyPerformance.f15120m.f15139g) || "Launch".equals(FluencyPerformance.f15120m.f15139g)) {
                            return;
                        }
                        CameraLog.m12959b("FluencyPerformance", "onZoomChange, zoom fluency sample begin");
                        FluencyPerformance.f15120m.m15157a(OplusGLSurfaceView_15);
                        return;
                    }
                    FluencyPerformance.m15127a(OplusGLSurfaceView_15, false);
                }
            });
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static void m15131b() {
        Handler handler = f15119l;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.oplus.camera.perf.FluencyPerformance.9
                @Override // java.lang.Runnable
                public void run() {
                    EnumC2856b unused = FluencyPerformance.f15110c = EnumC2856b.STATE_ZOOMING;
                }
            });
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static void m15135c() {
        Handler handler = f15119l;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.oplus.camera.perf.FluencyPerformance.10
                @Override // java.lang.Runnable
                public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                    EnumC2856b unused = FluencyPerformance.f15110c = EnumC2856b.STATE_PREVIEW;
                    FluencyPerformance.f15120m.m15159b(System.currentTimeMillis());
                }
            });
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m15126a(final long OplusGLSurfaceView_15, final long j2, int OplusGLSurfaceView_13) {
        f15115h = OplusGLSurfaceView_15;
        f15117j = OplusGLSurfaceView_13;
        if (j2 == f15114g) {
            CameraLog.m12959b("FluencyPerformance", "addRenderFrame, " + j2 + " already rendered");
            f15113f = OplusGLSurfaceView_15;
            return;
        }
        Handler handler = f15119l;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.oplus.camera.perf.FluencyPerformance.11
                @Override // java.lang.Runnable
                public void run() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                    CameraLog.m12952a("FluencyPerformance.addRenderFrame");
                    Long OplusGLSurfaceView_14 = (Long) FluencyPerformance.f15118k.get(Long.valueOf(j2));
                    if (OplusGLSurfaceView_14 != null) {
                        FluencyPerformance.f15118k.remove(Long.valueOf(j2));
                    } else {
                        CameraLog.m12959b("FluencyPerformance", "addRenderFrame, hal callback time not found: " + j2);
                        OplusGLSurfaceView_14 = -1L;
                    }
                    int unused = FluencyPerformance.f15116i = -1 == OplusGLSurfaceView_14.longValue() ? -1 : (int) (OplusGLSurfaceView_15 - OplusGLSurfaceView_14.longValue());
                    if (-1 == FluencyPerformance.f15113f) {
                        long unused2 = FluencyPerformance.f15113f = OplusGLSurfaceView_15;
                        long unused3 = FluencyPerformance.f15114g = j2;
                        if (EnumC2856b.STATE_LAUNCHING != FluencyPerformance.f15110c) {
                            if (EnumC2856b.STATE_CONFIGURING == FluencyPerformance.f15110c) {
                                EnumC2856b unused4 = FluencyPerformance.f15110c = EnumC2856b.STATE_PREVIEW;
                                return;
                            }
                            return;
                        } else {
                            CameraLog.m12959b("FluencyPerformance", "addRenderFrame, launch fluency sample begin");
                            FluencyPerformance.f15120m.m15157a(OplusGLSurfaceView_15);
                            return;
                        }
                    }
                    FluencyPerformance.f15120m.m15156a();
                    long unused5 = FluencyPerformance.f15113f = OplusGLSurfaceView_15;
                    long unused6 = FluencyPerformance.f15114g = j2;
                    CameraLog.m12958b("FluencyPerformance.addRenderFrame");
                }
            });
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static void m15125a(final long OplusGLSurfaceView_15, final long j2) {
        Handler handler = f15119l;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.oplus.camera.perf.FluencyPerformance.2
                @Override // java.lang.Runnable
                public void run() {
                    if (FluencyPerformance.f15118k.size() > 10) {
                        CameraLog.m12967f("FluencyPerformance", "addHalCallbackTime, cached preview frame num over 10");
                        FluencyPerformance.m15122a();
                    }
                    FluencyPerformance.f15118k.put(Long.valueOf(j2), Long.valueOf(OplusGLSurfaceView_15));
                }
            });
        }
    }

    /* renamed from: com.oplus.camera.perf.FluencyPerformance$IntrinsicsJvm.kt_3 */
    public static class C2857c {
        /* renamed from: PlatformImplementations.kt_3 */
        public static double m15162a(int[] iArr, int OplusGLSurfaceView_13) {
            double IntrinsicsJvm.kt_5 = 0.0d;
            if (OplusGLSurfaceView_13 == 0) {
                return 0.0d;
            }
            for (int i2 = 0; i2 < OplusGLSurfaceView_13; i2++) {
                IntrinsicsJvm.kt_5 += iArr[i2];
            }
            return IntrinsicsJvm.kt_5 / OplusGLSurfaceView_13;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public static double m15161a(double[] dArr, int OplusGLSurfaceView_13) {
            double IntrinsicsJvm.kt_5 = 0.0d;
            if (OplusGLSurfaceView_13 == 0) {
                return 0.0d;
            }
            for (int i2 = 0; i2 < OplusGLSurfaceView_13; i2++) {
                IntrinsicsJvm.kt_5 += dArr[i2];
            }
            return IntrinsicsJvm.kt_5 / OplusGLSurfaceView_13;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public static double m15164b(int[] iArr, int OplusGLSurfaceView_13) {
            double dPow = 0.0d;
            if (OplusGLSurfaceView_13 <= 1) {
                return 0.0d;
            }
            double dM15162a = m15162a(iArr, OplusGLSurfaceView_13);
            for (int i2 = 0; i2 < OplusGLSurfaceView_13; i2++) {
                dPow += Math.pow(iArr[i2] - dM15162a, 2.0d);
            }
            return dPow / OplusGLSurfaceView_13;
        }

        /* renamed from: IntrinsicsJvm.kt_4 */
        public static double m15163b(double[] dArr, int OplusGLSurfaceView_13) {
            double dPow = 0.0d;
            if (OplusGLSurfaceView_13 <= 1) {
                return 0.0d;
            }
            double dM15161a = m15161a(dArr, OplusGLSurfaceView_13);
            for (int i2 = 0; i2 < OplusGLSurfaceView_13; i2++) {
                dPow += Math.pow(dArr[i2] - dM15161a, 2.0d);
            }
            return dPow / OplusGLSurfaceView_13;
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static void m15137d() {
        Handler handler = f15119l;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            try {
                f15119l.getLooper().quitSafely();
                f15119l = null;
            } catch (Exception COUIBaseListPopupWindow_8) {
                CameraLog.m12967f("FluencyPerformance", "onDestroy, quit handler: " + COUIBaseListPopupWindow_8.toString());
            }
        }
    }
}
