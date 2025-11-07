package com.oplus.camera.panorama;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.Image;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.arcsoft.camera.burstpmk.ArcBurstPMKDef;
import com.arcsoft.camera.burstpmk.BurstPMKEngine;
import com.arcsoft.camera.burstpmk.BurstPMKInitParameter;
import com.arcsoft.camera.burstpmk.ProcessResult;
import com.oplus.camera.CameraLog;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.util.Util;
import java.nio.ByteBuffer;

/* compiled from: RearPanoramaEngine.java */
/* renamed from: com.oplus.camera.panorama.COUIBaseListPopupWindow_11 */
/* loaded from: classes2.dex */
public class RearPanoramaEngine implements BurstPMKEngine.PMKListener {

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int f15087e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int f15088f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private int f15089g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private Handler f15090h;

    /* renamed from: OplusGLSurfaceView_13 */
    private PlatformImplementations.kt_3 f15091i;

    /* renamed from: OplusGLSurfaceView_15 */
    private SensorManager f15092j;

    /* renamed from: OplusGLSurfaceView_5 */
    private Sensor f15093k;

    /* renamed from: PlatformImplementations.kt_3 */
    private BurstPMKEngine f15083a = null;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private BurstPMKInitParameter f15084b = null;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private final int f15085c = 2050;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int f15086d = 1;

    /* renamed from: OplusGLSurfaceView_14 */
    private Image f15094l = null;

    /* renamed from: OplusGLSurfaceView_6 */
    private SensorEventListener f15095m = new SensorEventListener() { // from class: com.oplus.camera.panorama.COUIBaseListPopupWindow_11.1
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int OplusGLSurfaceView_13) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            int type = sensorEvent.sensor.getType();
            if (4 != type || RearPanoramaEngine.this.f15083a == null) {
                return;
            }
            RearPanoramaEngine.this.f15083a.PushSensorDataIn(type, sensorEvent.values, sensorEvent.timestamp);
        }
    };

    /* compiled from: RearPanoramaEngine.java */
    /* renamed from: com.oplus.camera.panorama.COUIBaseListPopupWindow_11$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo15089a(ProcessResult processResult);

        /* renamed from: IntrinsicsJvm.kt_4 */
        void mo15094b(ProcessResult processResult);

        /* renamed from: COUIBaseListPopupWindow_11 */
        void mo15096g();
    }

    public RearPanoramaEngine(Context context, int OplusGLSurfaceView_13, int i2, PlatformImplementations.kt_3 aVar) {
        this.f15087e = 0;
        this.f15088f = 0;
        this.f15089g = 0;
        this.f15090h = null;
        this.f15091i = null;
        this.f15092j = null;
        this.f15093k = null;
        this.f15087e = OplusGLSurfaceView_13;
        this.f15088f = i2;
        this.f15089g = Util.m24446f(this.f15087e, CameraConfig.getConfigIntValue(ConfigDataBase.KEY_ALIGNED_BITS));
        this.f15091i = aVar;
        HandlerThread handlerThread = new HandlerThread("com/arcsoft/rearpanorama");
        handlerThread.start();
        if (this.f15090h == null) {
            this.f15090h = new Handler(handlerThread.getLooper()) { // from class: com.oplus.camera.panorama.COUIBaseListPopupWindow_11.2
                @Override // android.os.Handler
                public void handleMessage(Message message) throws Throwable {
                    int i3 = message.what;
                    if (i3 == 1) {
                        int i4 = message.arg1;
                        RearPanoramaEngine c2841g = RearPanoramaEngine.this;
                        c2841g.f15083a = new BurstPMKEngine(c2841g, c2841g.f15090h.getLooper(), ArcBurstPMKDef.DEFAUT_JNI_LIB_NAME);
                        RearPanoramaEngine c2841g2 = RearPanoramaEngine.this;
                        c2841g2.f15084b = BurstPMKInitParameter.getDefaultInitParams(c2841g2.f15087e, RearPanoramaEngine.this.f15088f, 2050, RearPanoramaEngine.this.f15086d);
                        if (3 == i4) {
                            RearPanoramaEngine.this.f15084b.deviceDirection = 3;
                        } else if (2 == i4) {
                            RearPanoramaEngine.this.f15084b.deviceDirection = 2;
                        }
                        if (Util.m24498u()) {
                            RearPanoramaEngine.this.f15084b.maxfullResultLength = (int) (RearPanoramaEngine.this.f15087e * 5.3f);
                            RearPanoramaEngine.this.f15084b.thumbnailResultHeightV = RearPanoramaEngine.this.f15084b.maxfullResultLength / 8;
                            CameraLog.m12959b("RearPanoramaEngine", "handleMessage, maxfullResultLength: " + RearPanoramaEngine.this.f15084b.maxfullResultLength + ", thumbnailResultHeightV: " + RearPanoramaEngine.this.f15084b.thumbnailResultHeightV);
                        }
                        RearPanoramaEngine.this.f15083a.Init(RearPanoramaEngine.this.f15084b);
                        return;
                    }
                    if (i3 == 2) {
                        if (RearPanoramaEngine.this.f15083a != null) {
                            RearPanoramaEngine.this.f15083a.Uninit();
                            return;
                        }
                        return;
                    }
                    if (i3 == 3) {
                        if (RearPanoramaEngine.this.f15083a != null) {
                            RearPanoramaEngine.this.f15083a.StopProcessing();
                            return;
                        }
                        return;
                    }
                    if (i3 == 4) {
                        if (RearPanoramaEngine.this.f15083a == null || 28682 != RearPanoramaEngine.this.f15083a.Process((ByteBuffer[]) message.obj, RearPanoramaEngine.this.f15089g)) {
                            return;
                        }
                        removeMessages(3);
                        sendEmptyMessage(3);
                        return;
                    }
                    if (i3 != 5) {
                        return;
                    }
                    Image image = (Image) message.obj;
                    if (RearPanoramaEngine.this.f15083a != null) {
                        int iProcess = RearPanoramaEngine.this.f15083a.Process(new ByteBuffer[]{image.getPlanes()[0].getBuffer(), image.getPlanes()[2].getBuffer()}, RearPanoramaEngine.this.f15089g);
                        if (Util.m24417c()) {
                            Util.m24250a(Util.m24305a(image, 17), "dump_rear", System.currentTimeMillis() + "_" + RearPanoramaEngine.this.f15087e + "x" + RearPanoramaEngine.this.f15088f);
                        }
                        if (28682 == iProcess) {
                            removeMessages(3);
                            sendEmptyMessage(3);
                        }
                    }
                    image.close();
                }
            };
        }
        this.f15092j = (SensorManager) context.getSystemService("sensor");
        this.f15093k = this.f15092j.getDefaultSensor(4);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15108a(int OplusGLSurfaceView_13) {
        Sensor sensor;
        CameraLog.m12954a("RearPanoramaEngine", "init, direction: " + OplusGLSurfaceView_13);
        Handler handler = this.f15090h;
        if (handler != null) {
            handler.removeMessages(1);
            Message messageObtainMessage = this.f15090h.obtainMessage();
            messageObtainMessage.what = 1;
            messageObtainMessage.arg1 = OplusGLSurfaceView_13;
            this.f15090h.sendMessage(messageObtainMessage);
            SensorManager sensorManager = this.f15092j;
            if (sensorManager == null || (sensor = this.f15093k) == null) {
                return;
            }
            sensorManager.registerListener(this.f15095m, sensor, 10000, this.f15090h);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15107a() {
        CameraLog.m12954a("RearPanoramaEngine", "uninit");
        Handler handler = this.f15090h;
        if (handler != null) {
            handler.removeMessages(2);
            this.f15090h.sendEmptyMessage(2);
        }
        SensorManager sensorManager = this.f15092j;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.f15095m);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m15111b() {
        CameraLog.m12954a("RearPanoramaEngine", "destroy");
        Handler handler = this.f15090h;
        if (handler != null) {
            handler.getLooper().quitSafely();
            this.f15090h = null;
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15110a(ByteBuffer[] byteBufferArr) {
        Handler handler = this.f15090h;
        if (handler != null) {
            handler.removeMessages(4);
            this.f15090h.obtainMessage(4, byteBufferArr).sendToTarget();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15109a(Image image) {
        Handler handler = this.f15090h;
        if (handler != null) {
            Image image2 = this.f15094l;
            if (image2 != null && handler.hasMessages(5, image2)) {
                this.f15090h.removeMessages(5, this.f15094l);
                CameraLog.m12966e("RearPanoramaEngine", "onSendImage, skip image process! timestamp:" + this.f15094l.getTimestamp());
                this.f15094l.close();
            }
            this.f15090h.obtainMessage(5, image).sendToTarget();
            this.f15094l = image;
            return;
        }
        image.close();
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m15112c() {
        CameraLog.m12954a("RearPanoramaEngine", "stopProcessing");
        Handler handler = this.f15090h;
        if (handler != null) {
            Image image = this.f15094l;
            if (image != null && handler.hasMessages(5, image)) {
                this.f15090h.removeMessages(5, this.f15094l);
                this.f15094l.close();
            }
            this.f15090h.removeMessages(4);
            this.f15090h.removeMessages(3);
            this.f15090h.sendEmptyMessage(3);
        }
    }

    @Override // com.arcsoft.camera.burstpmk.BurstPMKEngine.PMKListener
    public int onPMKNotify(int OplusGLSurfaceView_13, Object obj) {
        if (OplusGLSurfaceView_13 == 1) {
            return 0;
        }
        if (OplusGLSurfaceView_13 == 2) {
            CameraLog.m12954a("RearPanoramaEngine", "onPMKNotify, onCaptureSuccess");
            this.f15091i.mo15089a((ProcessResult) obj);
            return 0;
        }
        if (OplusGLSurfaceView_13 == 3) {
            CameraLog.m12954a("RearPanoramaEngine", "onPMKNotify, onCaptureFailed");
            this.f15091i.mo15096g();
            return 0;
        }
        if (OplusGLSurfaceView_13 != 4) {
            return 0;
        }
        this.f15091i.mo15094b((ProcessResult) obj);
        return 0;
    }
}
