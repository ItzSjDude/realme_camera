package com.oplus.camera.panorama;

/* compiled from: RearPanoramaEngine.java */
/* loaded from: classes2.dex */
public class g_renamed implements com.arcsoft.camera.burstpmk.BurstPMKEngine.PMKListener {
    private int e_renamed;
    private int f_renamed;
    private int g_renamed;
    private android.os.Handler h_renamed;
    private com.oplus.camera.panorama.g_renamed.a_renamed i_renamed;
    private android.hardware.SensorManager j_renamed;
    private android.hardware.Sensor k_renamed;

    /* renamed from: a_renamed, reason: collision with root package name */
    private com.arcsoft.camera.burstpmk.BurstPMKEngine f4971a = null;

    /* renamed from: b_renamed, reason: collision with root package name */
    private com.arcsoft.camera.burstpmk.BurstPMKInitParameter f4972b = null;

    /* renamed from: c_renamed, reason: collision with root package name */
    private final int f4973c = 2050;
    private int d_renamed = 1;
    private android.media.Image l_renamed = null;
    private android.hardware.SensorEventListener m_renamed = new android.hardware.SensorEventListener() { // from class: com.oplus.camera.panorama.g_renamed.1
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(android.hardware.Sensor sensor, int i_renamed) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(android.hardware.SensorEvent sensorEvent) {
            int type = sensorEvent.sensor.getType();
            if (4 != type || com.oplus.camera.panorama.g_renamed.this.f4971a == null) {
                return;
            }
            com.oplus.camera.panorama.g_renamed.this.f4971a.PushSensorDataIn(type, sensorEvent.values, sensorEvent.timestamp);
        }
    };

    /* compiled from: RearPanoramaEngine.java */
    public interface a_renamed {
        void a_renamed(com.arcsoft.camera.burstpmk.ProcessResult processResult);

        void b_renamed(com.arcsoft.camera.burstpmk.ProcessResult processResult);

        void g_renamed();
    }

    public g_renamed(android.content.Context context, int i_renamed, int i2, com.oplus.camera.panorama.g_renamed.a_renamed aVar) {
        this.e_renamed = 0;
        this.f_renamed = 0;
        this.g_renamed = 0;
        this.h_renamed = null;
        this.i_renamed = null;
        this.j_renamed = null;
        this.k_renamed = null;
        this.e_renamed = i_renamed;
        this.f_renamed = i2;
        this.g_renamed = com.oplus.camera.util.Util.f_renamed(this.e_renamed, com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ALIGNED_BITS));
        this.i_renamed = aVar;
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("com/arcsoft/rearpanorama");
        handlerThread.start();
        if (this.h_renamed == null) {
            this.h_renamed = new android.os.Handler(handlerThread.getLooper()) { // from class: com.oplus.camera.panorama.g_renamed.2
                @Override // android.os.Handler
                public void handleMessage(android.os.Message message) throws java.lang.Throwable {
                    int i3 = message.what;
                    if (i3 == 1) {
                        int i4 = message.arg1;
                        com.oplus.camera.panorama.g_renamed gVar = com.oplus.camera.panorama.g_renamed.this;
                        gVar.f4971a = new com.arcsoft.camera.burstpmk.BurstPMKEngine(gVar, gVar.h_renamed.getLooper(), com.arcsoft.camera.burstpmk.ArcBurstPMKDef.DEFAUT_JNI_LIB_NAME);
                        com.oplus.camera.panorama.g_renamed gVar2 = com.oplus.camera.panorama.g_renamed.this;
                        gVar2.f4972b = com.arcsoft.camera.burstpmk.BurstPMKInitParameter.getDefaultInitParams(gVar2.e_renamed, com.oplus.camera.panorama.g_renamed.this.f_renamed, 2050, com.oplus.camera.panorama.g_renamed.this.d_renamed);
                        if (3 == i4) {
                            com.oplus.camera.panorama.g_renamed.this.f4972b.deviceDirection = 3;
                        } else if (2 == i4) {
                            com.oplus.camera.panorama.g_renamed.this.f4972b.deviceDirection = 2;
                        }
                        if (com.oplus.camera.util.Util.u_renamed()) {
                            com.oplus.camera.panorama.g_renamed.this.f4972b.maxfullResultLength = (int) (com.oplus.camera.panorama.g_renamed.this.e_renamed * 5.3f);
                            com.oplus.camera.panorama.g_renamed.this.f4972b.thumbnailResultHeightV = com.oplus.camera.panorama.g_renamed.this.f4972b.maxfullResultLength / 8;
                            com.oplus.camera.e_renamed.b_renamed("RearPanoramaEngine", "handleMessage, maxfullResultLength: " + com.oplus.camera.panorama.g_renamed.this.f4972b.maxfullResultLength + ", thumbnailResultHeightV: " + com.oplus.camera.panorama.g_renamed.this.f4972b.thumbnailResultHeightV);
                        }
                        com.oplus.camera.panorama.g_renamed.this.f4971a.Init(com.oplus.camera.panorama.g_renamed.this.f4972b);
                        return;
                    }
                    if (i3 == 2) {
                        if (com.oplus.camera.panorama.g_renamed.this.f4971a != null) {
                            com.oplus.camera.panorama.g_renamed.this.f4971a.Uninit();
                            return;
                        }
                        return;
                    }
                    if (i3 == 3) {
                        if (com.oplus.camera.panorama.g_renamed.this.f4971a != null) {
                            com.oplus.camera.panorama.g_renamed.this.f4971a.StopProcessing();
                            return;
                        }
                        return;
                    }
                    if (i3 == 4) {
                        if (com.oplus.camera.panorama.g_renamed.this.f4971a == null || 28682 != com.oplus.camera.panorama.g_renamed.this.f4971a.Process((java.nio.ByteBuffer[]) message.obj, com.oplus.camera.panorama.g_renamed.this.g_renamed)) {
                            return;
                        }
                        removeMessages(3);
                        sendEmptyMessage(3);
                        return;
                    }
                    if (i3 != 5) {
                        return;
                    }
                    android.media.Image image = (android.media.Image) message.obj;
                    if (com.oplus.camera.panorama.g_renamed.this.f4971a != null) {
                        int iProcess = com.oplus.camera.panorama.g_renamed.this.f4971a.Process(new java.nio.ByteBuffer[]{image.getPlanes()[0].getBuffer(), image.getPlanes()[2].getBuffer()}, com.oplus.camera.panorama.g_renamed.this.g_renamed);
                        if (com.oplus.camera.util.Util.c_renamed()) {
                            com.oplus.camera.util.Util.a_renamed(com.oplus.camera.util.Util.a_renamed(image, 17), "dump_rear", java.lang.System.currentTimeMillis() + "_" + com.oplus.camera.panorama.g_renamed.this.e_renamed + "x_renamed" + com.oplus.camera.panorama.g_renamed.this.f_renamed);
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
        this.j_renamed = (android.hardware.SensorManager) context.getSystemService("sensor");
        this.k_renamed = this.j_renamed.getDefaultSensor(4);
    }

    public void a_renamed(int i_renamed) {
        android.hardware.Sensor sensor;
        com.oplus.camera.e_renamed.a_renamed("RearPanoramaEngine", "init, direction: " + i_renamed);
        android.os.Handler handler = this.h_renamed;
        if (handler != null) {
            handler.removeMessages(1);
            android.os.Message messageObtainMessage = this.h_renamed.obtainMessage();
            messageObtainMessage.what = 1;
            messageObtainMessage.arg1 = i_renamed;
            this.h_renamed.sendMessage(messageObtainMessage);
            android.hardware.SensorManager sensorManager = this.j_renamed;
            if (sensorManager == null || (sensor = this.k_renamed) == null) {
                return;
            }
            sensorManager.registerListener(this.m_renamed, sensor, 10000, this.h_renamed);
        }
    }

    public void a_renamed() {
        com.oplus.camera.e_renamed.a_renamed("RearPanoramaEngine", "uninit");
        android.os.Handler handler = this.h_renamed;
        if (handler != null) {
            handler.removeMessages(2);
            this.h_renamed.sendEmptyMessage(2);
        }
        android.hardware.SensorManager sensorManager = this.j_renamed;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this.m_renamed);
        }
    }

    public void b_renamed() {
        com.oplus.camera.e_renamed.a_renamed("RearPanoramaEngine", "destroy");
        android.os.Handler handler = this.h_renamed;
        if (handler != null) {
            handler.getLooper().quitSafely();
            this.h_renamed = null;
        }
    }

    public void a_renamed(java.nio.ByteBuffer[] byteBufferArr) {
        android.os.Handler handler = this.h_renamed;
        if (handler != null) {
            handler.removeMessages(4);
            this.h_renamed.obtainMessage(4, byteBufferArr).sendToTarget();
        }
    }

    public void a_renamed(android.media.Image image) {
        android.os.Handler handler = this.h_renamed;
        if (handler != null) {
            android.media.Image image2 = this.l_renamed;
            if (image2 != null && handler.hasMessages(5, image2)) {
                this.h_renamed.removeMessages(5, this.l_renamed);
                com.oplus.camera.e_renamed.e_renamed("RearPanoramaEngine", "onSendImage, skip image process! timestamp:" + this.l_renamed.getTimestamp());
                this.l_renamed.close();
            }
            this.h_renamed.obtainMessage(5, image).sendToTarget();
            this.l_renamed = image;
            return;
        }
        image.close();
    }

    public void c_renamed() {
        com.oplus.camera.e_renamed.a_renamed("RearPanoramaEngine", "stopProcessing");
        android.os.Handler handler = this.h_renamed;
        if (handler != null) {
            android.media.Image image = this.l_renamed;
            if (image != null && handler.hasMessages(5, image)) {
                this.h_renamed.removeMessages(5, this.l_renamed);
                this.l_renamed.close();
            }
            this.h_renamed.removeMessages(4);
            this.h_renamed.removeMessages(3);
            this.h_renamed.sendEmptyMessage(3);
        }
    }

    @Override // com.arcsoft.camera.burstpmk.BurstPMKEngine.PMKListener
    public int onPMKNotify(int i_renamed, java.lang.Object obj) {
        if (i_renamed == 1) {
            return 0;
        }
        if (i_renamed == 2) {
            com.oplus.camera.e_renamed.a_renamed("RearPanoramaEngine", "onPMKNotify, onCaptureSuccess");
            this.i_renamed.a_renamed((com.arcsoft.camera.burstpmk.ProcessResult) obj);
            return 0;
        }
        if (i_renamed == 3) {
            com.oplus.camera.e_renamed.a_renamed("RearPanoramaEngine", "onPMKNotify, onCaptureFailed");
            this.i_renamed.g_renamed();
            return 0;
        }
        if (i_renamed != 4) {
            return 0;
        }
        this.i_renamed.b_renamed((com.arcsoft.camera.burstpmk.ProcessResult) obj);
        return 0;
    }
}
