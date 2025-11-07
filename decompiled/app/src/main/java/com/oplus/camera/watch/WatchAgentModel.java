package com.oplus.camera.watch;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.util.Size;
import com.google.protobuf.ByteString;
import com.heytap.accessory.bean.PeerAgent;
import com.heytap.accessory.bean.SdkUnsupportedException;
import com.heytap.accessory.bean.UnSupportException;
import com.heytap.accessory.stream.StreamInitializer;
import com.heytap.accessory.stream.StreamTransfer;
import com.oplus.camera.CameraLog;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.jni.IccProfile;
import com.oplus.camera.p172ui.menu.p175a.HeadlineHelper;
import com.oplus.camera.util.Util;
import com.oplus.camera.watch.WatchAgentService;
import com.oplus.camera.watch.proto.WatchAgentProto;
import com.oplus.tblplayer.monitor.ErrorCode;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: WatchAgentModel.java */
/* renamed from: com.oplus.camera.watch.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class WatchAgentModel {

    /* renamed from: PlatformImplementations.kt_3 */
    private static long f23184a;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private WatchAgentService f23186c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private WatchAgentService.WatchAgentSocket f23187d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private PeerAgent f23188e;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private final Object f23185b = new Object();

    /* renamed from: COUIBaseListPopupWindow_12 */
    private StreamTransfer f23189f = null;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private OutputStream f23190g = null;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private InputStream f23191h = null;

    /* renamed from: OplusGLSurfaceView_13 */
    private Handler f23192i = null;

    /* renamed from: OplusGLSurfaceView_15 */
    private PlatformImplementations.kt_3 f23193j = null;

    /* renamed from: OplusGLSurfaceView_5 */
    private ArrayList<byte[]> f23194k = new ArrayList<>();

    /* renamed from: OplusGLSurfaceView_14 */
    private ArrayList<byte[]> f23195l = new ArrayList<>();

    /* renamed from: OplusGLSurfaceView_6 */
    private AtomicBoolean f23196m = new AtomicBoolean(false);

    /* renamed from: OplusGLSurfaceView_11 */
    private byte[] f23197n = new byte[0];

    /* renamed from: o */
    private int f23198o = 80;

    /* renamed from: p */
    private int f23199p = ErrorCode.REASON_DS_FILE;

    /* renamed from: q */
    private int f23200q = 500;

    public WatchAgentModel(WatchAgentService.WatchAgentSocket watchAgentSocket, WatchAgentService watchAgentService, PeerAgent peerAgent) {
        this.f23186c = null;
        this.f23187d = null;
        this.f23188e = null;
        this.f23187d = watchAgentSocket;
        this.f23186c = watchAgentService;
        this.f23188e = peerAgent;
        m24767f();
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m24765e() throws IOException {
        try {
            StreamInitializer.initialize(this.f23186c.getApplicationContext());
            ParcelFileDescriptor[] parcelFileDescriptorArrCreatePipe = ParcelFileDescriptor.createPipe();
            this.f23191h = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptorArrCreatePipe[0]);
            this.f23190g = new ParcelFileDescriptor.AutoCloseOutputStream(parcelFileDescriptorArrCreatePipe[1]);
            this.f23196m.set(true);
        } catch (SdkUnsupportedException | IOException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        this.f23193j = new PlatformImplementations.kt_3();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24769a() throws IOException {
        CameraLog.m12954a("WatchAgentModel", "closeStreamPipeline");
        try {
            try {
                this.f23196m.set(false);
                if (this.f23190g != null) {
                    this.f23190g.flush();
                    this.f23190g.close();
                }
                if (this.f23191h != null) {
                    this.f23191h.close();
                }
            } catch (IOException COUIBaseListPopupWindow_8) {
                COUIBaseListPopupWindow_8.printStackTrace();
            }
        } finally {
            Util.m24277a(this.f23190g);
            Util.m24277a(this.f23191h);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m24777b() throws IOException {
        CameraLog.m12954a("WatchAgentModel", "onDetach");
        m24768g();
        m24769a();
        synchronized (this.f23185b) {
            this.f23195l.clear();
            this.f23194k.clear();
        }
        WatchAgentService.WatchAgentSocket watchAgentSocket = this.f23187d;
        if (watchAgentSocket != null) {
            watchAgentSocket.close();
            this.f23187d = null;
        }
        StreamTransfer streamTransfer = this.f23189f;
        if (streamTransfer != null) {
            streamTransfer.cancelAll();
            this.f23189f.close();
            this.f23189f = null;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m24767f() {
        HandlerThread handlerThread = new HandlerThread("watch message thread");
        handlerThread.start();
        this.f23192i = new Handler(handlerThread.getLooper()) { // from class: com.oplus.camera.watch.IntrinsicsJvm.kt_5.1
            @Override // android.os.Handler
            public void handleMessage(Message message) throws IOException {
                byte[] bArr;
                switch (message.what) {
                    case 100:
                        synchronized (WatchAgentModel.this.f23185b) {
                            bArr = (byte[]) WatchAgentModel.this.f23194k.remove(0);
                            if (!WatchAgentModel.this.f23194k.isEmpty()) {
                                WatchAgentModel.this.f23192i.removeMessages(100);
                                WatchAgentModel.this.f23192i.sendEmptyMessage(100);
                            }
                        }
                        WatchAgentModel.this.m24758a(bArr);
                        return;
                    case 101:
                        break;
                    case 102:
                        WatchAgentModel.this.m24755a(WatchAgentParser.m24780a((Bitmap) message.obj, message.arg1, message.arg2));
                        return;
                    case 103:
                        CameraLog.m12954a("WatchAgentModel", "initMessageThread, send picture");
                        synchronized (WatchAgentModel.this.f23185b) {
                            if (!WatchAgentModel.this.f23195l.isEmpty()) {
                                byte[] bArr2 = (byte[]) WatchAgentModel.this.f23195l.remove(0);
                                if (!WatchAgentModel.this.f23195l.isEmpty()) {
                                    WatchAgentModel.this.f23192i.removeMessages(103);
                                    WatchAgentModel.this.f23192i.sendEmptyMessageDelayed(103, WatchAgentModel.this.f23200q);
                                }
                                message.obj = bArr2;
                                message.arg1 = 19;
                                break;
                            } else {
                                CameraLog.m12954a("WatchAgentModel", "initMessageThread, send picture is empty");
                                return;
                            }
                        }
                    default:
                        return;
                }
                try {
                    WatchAgentModel.this.f23187d.sendUncompressed(104, WatchAgentParser.m24783a((byte[]) message.obj, message.arg1));
                } catch (IOException COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m24758a(byte[] bArr) throws IOException {
        try {
            if (!this.f23196m.get()) {
                CameraLog.m12954a("WatchAgentModel", "queueBuffer, create stream");
                m24765e();
                this.f23189f = new StreamTransfer(this.f23186c, this.f23193j);
                this.f23189f.send(this.f23188e, this.f23191h, 32768);
            }
            if (this.f23196m.get()) {
                this.f23190g.write(WatchAgentParser.m24782a(bArr));
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - f23184a > 10000) {
                f23184a = jCurrentTimeMillis;
                CameraLog.m12954a("WatchAgentModel", "queueBuffer");
            }
        } catch (SdkUnsupportedException | UnSupportException | IOException COUIBaseListPopupWindow_8) {
            m24769a();
            m24776a(bArr, true);
            COUIBaseListPopupWindow_8.printStackTrace();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m24759a(byte[] bArr, int OplusGLSurfaceView_13) {
        synchronized (this.f23185b) {
            if (this.f23192i == null) {
                return;
            }
            CameraLog.m12954a("WatchAgentModel", "postRequestBody, commandId: " + OplusGLSurfaceView_13);
            Message messageObtain = Message.obtain();
            messageObtain.what = 101;
            messageObtain.obj = bArr;
            messageObtain.arg1 = OplusGLSurfaceView_13;
            this.f23192i.sendMessage(messageObtain);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m24761b(Bitmap bitmap, int OplusGLSurfaceView_13, int i2) {
        synchronized (this.f23185b) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 102;
            messageObtain.obj = bitmap;
            messageObtain.arg1 = OplusGLSurfaceView_13;
            messageObtain.arg2 = i2;
            this.f23192i.sendMessage(messageObtain);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m24768g() {
        synchronized (this.f23185b) {
            if (this.f23192i != null) {
                this.f23192i.removeCallbacksAndMessages(null);
                this.f23192i.getLooper().quitSafely();
                this.f23192i = null;
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24774a(String str, Size size, int OplusGLSurfaceView_13) {
        WatchAgentProto.CameraConnectPreviewMessage.Builder builderNewBuilder = WatchAgentProto.CameraConnectPreviewMessage.newBuilder();
        if (size != null) {
            builderNewBuilder.setCodecWidth(size.getWidth());
            builderNewBuilder.setCodecHeight(size.getHeight());
        }
        builderNewBuilder.setCurrentMode(str);
        builderNewBuilder.setCurrentModeName(this.f23186c.getString(HeadlineHelper.m20344a(str)));
        builderNewBuilder.setOrientation(OplusGLSurfaceView_13);
        builderNewBuilder.addAllPhotoModeList(WatchAgentProxy.f23205a);
        m24759a(builderNewBuilder.build().toByteArray(), 1);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24772a(Bitmap bitmap, int OplusGLSurfaceView_13, int i2) {
        m24761b(bitmap.copy(Bitmap.Config.ARGB_8888, true), OplusGLSurfaceView_13, i2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24775a(boolean z) {
        WatchAgentProto.CameraCaptureMessage.Builder builderNewBuilder = WatchAgentProto.CameraCaptureMessage.newBuilder();
        builderNewBuilder.setIsReady(z);
        m24759a(builderNewBuilder.build().toByteArray(), 5);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24771a(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15) {
        WatchAgentProto.CameraRecordMessage.Builder builderNewBuilder = WatchAgentProto.CameraRecordMessage.newBuilder();
        builderNewBuilder.setVideoState(OplusGLSurfaceView_13);
        builderNewBuilder.setRecordTime(OplusGLSurfaceView_15);
        m24759a(builderNewBuilder.build().toByteArray(), 6);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m24778c() {
        m24759a(this.f23197n, 2);
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m24779d() {
        WatchAgentProto.CameraOAFStateMessage.Builder builderNewBuilder = WatchAgentProto.CameraOAFStateMessage.newBuilder();
        builderNewBuilder.setReconnect(true);
        m24759a(builderNewBuilder.build().toByteArray(), 20);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24770a(int OplusGLSurfaceView_13) {
        WatchAgentProto.CameraConfigurationMessage.Builder builderNewBuilder = WatchAgentProto.CameraConfigurationMessage.newBuilder();
        builderNewBuilder.setOrientation(OplusGLSurfaceView_13);
        m24759a(builderNewBuilder.build().toByteArray(), 9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: PlatformImplementations.kt_3 */
    public void m24755a(Bitmap bitmap) {
        byte[] byteArray;
        byte[] bArr;
        if (bitmap == null) {
            CameraLog.m12967f("WatchAgentModel", "constructPictureBody, bitmap is null");
            return;
        }
        if (CameraConfig.getConfigBooleanValue(ConfigDataBase.KEY_FEATURE_DCIP3_SUPPORT)) {
            byteArray = IccProfile.compressBitmap(bitmap, this.f23198o);
        } else {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, this.f23198o, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        CameraLog.m12954a("WatchAgentModel", "constructPictureBody, bytes.length: " + byteArray.length + ", mCaptureQuality: " + this.f23198o + ", mSinglePackageSize: " + this.f23199p);
        int iCeil = (int) Math.ceil((double) ((((float) byteArray.length) * 1.0f) / ((float) this.f23199p)));
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < iCeil; OplusGLSurfaceView_13++) {
            if (OplusGLSurfaceView_13 == iCeil - 1) {
                bArr = new byte[byteArray.length - (this.f23199p * OplusGLSurfaceView_13)];
            } else {
                bArr = new byte[this.f23199p];
            }
            System.arraycopy(byteArray, this.f23199p * OplusGLSurfaceView_13, bArr, 0, bArr.length);
            WatchAgentProto.CameraCaptureDataMessage.Builder builderNewBuilder = WatchAgentProto.CameraCaptureDataMessage.newBuilder();
            builderNewBuilder.setSubPackageIdentify(jCurrentTimeMillis);
            builderNewBuilder.setSubPackageTotal(iCeil);
            builderNewBuilder.setSubPackageIndex(OplusGLSurfaceView_13);
            builderNewBuilder.setPictureData(ByteString.copyFrom(bArr));
            builderNewBuilder.setPackageLength(byteArray.length);
            synchronized (this.f23185b) {
                this.f23195l.add(builderNewBuilder.build().toByteArray());
                if (this.f23192i != null && 1 == this.f23195l.size()) {
                    this.f23192i.sendEmptyMessage(103);
                }
            }
        }
        bitmap.recycle();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24776a(byte[] bArr, boolean z) {
        synchronized (this.f23185b) {
            if (this.f23194k.size() > 10) {
                CameraLog.m12954a("WatchAgentModel", "sendPreviewBuffer, mBufferList is full");
                this.f23194k.remove(0);
            }
            if (z) {
                this.f23194k.add(0, bArr);
            } else {
                this.f23194k.add(bArr);
            }
            if (this.f23192i != null && 1 == this.f23194k.size()) {
                this.f23192i.sendEmptyMessage(100);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24773a(WatchAgentHolder c3568c) {
        this.f23198o = c3568c.m24750g() == 0 ? 80 : c3568c.m24750g();
        this.f23199p = c3568c.m24751h() == 0 ? ErrorCode.REASON_DS_FILE : c3568c.m24751h();
        this.f23200q = c3568c.m24752i() == 0 ? 500 : c3568c.m24752i();
        CameraLog.m12954a("WatchAgentModel", "initModelParams, mCaptureQuality: " + this.f23198o + ", mSinglePackageSize: " + this.f23199p + ", mSinglePackageDelay: " + this.f23200q);
    }

    /* compiled from: WatchAgentModel.java */
    /* renamed from: com.oplus.camera.watch.IntrinsicsJvm.kt_5$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 implements StreamTransfer.EventListener {
        @Override // com.heytap.accessory.stream.StreamTransfer.EventListener
        public void onStreamReceived(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, InputStream inputStream) {
        }

        @Override // com.heytap.accessory.stream.StreamTransfer.EventListener
        public void onTransferRequested(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, int i2) {
        }

        private PlatformImplementations.kt_3() {
        }

        @Override // com.heytap.accessory.stream.StreamTransfer.EventListener
        public void onTransferCompleted(long OplusGLSurfaceView_15, int OplusGLSurfaceView_13, int i2) throws IOException {
            WatchAgentModel.this.m24769a();
        }

        @Override // com.heytap.accessory.stream.StreamTransfer.EventListener
        public void onCancelAllCompleted(int OplusGLSurfaceView_13, int i2) throws IOException {
            WatchAgentModel.this.m24769a();
        }
    }
}
