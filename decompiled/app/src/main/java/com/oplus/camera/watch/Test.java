package com.oplus.camera.watch;

/* compiled from: WatchAgentModel.java */
/* loaded from: classes2.dex */
public class d_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static long f7415a;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.watch.WatchAgentService f7417c;
    private com.oplus.camera.watch.WatchAgentService.WatchAgentSocket d_renamed;
    private com.heytap.accessory.bean.PeerAgent e_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    private final java.lang.Object f7416b = new java.lang.Object();
    private com.heytap.accessory.stream.StreamTransfer f_renamed = null;
    private java.io.OutputStream g_renamed = null;
    private java.io.InputStream h_renamed = null;
    private android.os.Handler i_renamed = null;
    private com.oplus.camera.watch.d_renamed.a_renamed j_renamed = null;
    private java.util.ArrayList<byte[]> k_renamed = new java.util.ArrayList<>();
    private java.util.ArrayList<byte[]> l_renamed = new java.util.ArrayList<>();
    private java.util.concurrent.atomic.AtomicBoolean m_renamed = new java.util.concurrent.atomic.AtomicBoolean(false);
    private byte[] n_renamed = new byte[0];
    private int o_renamed = 80;
    private int p_renamed = com.oplus.tblplayer.monitor.ErrorCode.REASON_DS_FILE;
    private int q_renamed = 500;

    public d_renamed(com.oplus.camera.watch.WatchAgentService.WatchAgentSocket watchAgentSocket, com.oplus.camera.watch.WatchAgentService watchAgentService, com.heytap.accessory.bean.PeerAgent peerAgent) {
        this.f7417c = null;
        this.d_renamed = null;
        this.e_renamed = null;
        this.d_renamed = watchAgentSocket;
        this.f7417c = watchAgentService;
        this.e_renamed = peerAgent;
        f_renamed();
    }

    private void e_renamed() throws java.io.IOException {
        try {
            com.heytap.accessory.stream.StreamInitializer.initialize(this.f7417c.getApplicationContext());
            android.os.ParcelFileDescriptor[] parcelFileDescriptorArrCreatePipe = android.os.ParcelFileDescriptor.createPipe();
            this.h_renamed = new android.os.ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptorArrCreatePipe[0]);
            this.g_renamed = new android.os.ParcelFileDescriptor.AutoCloseOutputStream(parcelFileDescriptorArrCreatePipe[1]);
            this.m_renamed.set(true);
        } catch (com.heytap.accessory.bean.SdkUnsupportedException | java.io.IOException e_renamed) {
            e_renamed.printStackTrace();
        }
        this.j_renamed = new com.oplus.camera.watch.d_renamed.a_renamed();
    }

    public void a_renamed() throws java.io.IOException {
        com.oplus.camera.e_renamed.a_renamed("WatchAgentModel", "closeStreamPipeline");
        try {
            try {
                this.m_renamed.set(false);
                if (this.g_renamed != null) {
                    this.g_renamed.flush();
                    this.g_renamed.close();
                }
                if (this.h_renamed != null) {
                    this.h_renamed.close();
                }
            } catch (java.io.IOException e_renamed) {
                e_renamed.printStackTrace();
            }
        } finally {
            com.oplus.camera.util.Util.a_renamed(this.g_renamed);
            com.oplus.camera.util.Util.a_renamed(this.h_renamed);
        }
    }

    public void b_renamed() throws java.io.IOException {
        com.oplus.camera.e_renamed.a_renamed("WatchAgentModel", "onDetach");
        g_renamed();
        a_renamed();
        synchronized (this.f7416b) {
            this.l_renamed.clear();
            this.k_renamed.clear();
        }
        com.oplus.camera.watch.WatchAgentService.WatchAgentSocket watchAgentSocket = this.d_renamed;
        if (watchAgentSocket != null) {
            watchAgentSocket.close();
            this.d_renamed = null;
        }
        com.heytap.accessory.stream.StreamTransfer streamTransfer = this.f_renamed;
        if (streamTransfer != null) {
            streamTransfer.cancelAll();
            this.f_renamed.close();
            this.f_renamed = null;
        }
    }

    private void f_renamed() {
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("watch message thread");
        handlerThread.start();
        this.i_renamed = new android.os.Handler(handlerThread.getLooper()) { // from class: com.oplus.camera.watch.d_renamed.1
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) throws java.io.IOException {
                byte[] bArr;
                switch (message.what) {
                    case 100:
                        synchronized (com.oplus.camera.watch.d_renamed.this.f7416b) {
                            bArr = (byte[]) com.oplus.camera.watch.d_renamed.this.k_renamed.remove(0);
                            if (!com.oplus.camera.watch.d_renamed.this.k_renamed.isEmpty()) {
                                com.oplus.camera.watch.d_renamed.this.i_renamed.removeMessages(100);
                                com.oplus.camera.watch.d_renamed.this.i_renamed.sendEmptyMessage(100);
                            }
                        }
                        com.oplus.camera.watch.d_renamed.this.a_renamed(bArr);
                        return;
                    case 101:
                        break;
                    case 102:
                        com.oplus.camera.watch.d_renamed.this.a_renamed(com.oplus.camera.watch.e_renamed.a_renamed((android.graphics.Bitmap) message.obj, message.arg1, message.arg2));
                        return;
                    case 103:
                        com.oplus.camera.e_renamed.a_renamed("WatchAgentModel", "initMessageThread, send picture");
                        synchronized (com.oplus.camera.watch.d_renamed.this.f7416b) {
                            if (!com.oplus.camera.watch.d_renamed.this.l_renamed.isEmpty()) {
                                byte[] bArr2 = (byte[]) com.oplus.camera.watch.d_renamed.this.l_renamed.remove(0);
                                if (!com.oplus.camera.watch.d_renamed.this.l_renamed.isEmpty()) {
                                    com.oplus.camera.watch.d_renamed.this.i_renamed.removeMessages(103);
                                    com.oplus.camera.watch.d_renamed.this.i_renamed.sendEmptyMessageDelayed(103, com.oplus.camera.watch.d_renamed.this.q_renamed);
                                }
                                message.obj = bArr2;
                                message.arg1 = 19;
                                break;
                            } else {
                                com.oplus.camera.e_renamed.a_renamed("WatchAgentModel", "initMessageThread, send picture is_renamed empty");
                                return;
                            }
                        }
                    default:
                        return;
                }
                try {
                    com.oplus.camera.watch.d_renamed.this.d_renamed.sendUncompressed(104, com.oplus.camera.watch.e_renamed.a_renamed((byte[]) message.obj, message.arg1));
                } catch (java.io.IOException e_renamed) {
                    e_renamed.printStackTrace();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(byte[] bArr) throws java.io.IOException {
        try {
            if (!this.m_renamed.get()) {
                com.oplus.camera.e_renamed.a_renamed("WatchAgentModel", "queueBuffer, create stream");
                e_renamed();
                this.f_renamed = new com.heytap.accessory.stream.StreamTransfer(this.f7417c, this.j_renamed);
                this.f_renamed.send(this.e_renamed, this.h_renamed, 32768);
            }
            if (this.m_renamed.get()) {
                this.g_renamed.write(com.oplus.camera.watch.e_renamed.a_renamed(bArr));
            }
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            if (jCurrentTimeMillis - f7415a > 10000) {
                f7415a = jCurrentTimeMillis;
                com.oplus.camera.e_renamed.a_renamed("WatchAgentModel", "queueBuffer");
            }
        } catch (com.heytap.accessory.bean.SdkUnsupportedException | com.heytap.accessory.bean.UnSupportException | java.io.IOException e_renamed) {
            a_renamed();
            a_renamed(bArr, true);
            e_renamed.printStackTrace();
        }
    }

    private void a_renamed(byte[] bArr, int i_renamed) {
        synchronized (this.f7416b) {
            if (this.i_renamed == null) {
                return;
            }
            com.oplus.camera.e_renamed.a_renamed("WatchAgentModel", "postRequestBody, commandId: " + i_renamed);
            android.os.Message messageObtain = android.os.Message.obtain();
            messageObtain.what = 101;
            messageObtain.obj = bArr;
            messageObtain.arg1 = i_renamed;
            this.i_renamed.sendMessage(messageObtain);
        }
    }

    private void b_renamed(android.graphics.Bitmap bitmap, int i_renamed, int i2) {
        synchronized (this.f7416b) {
            android.os.Message messageObtain = android.os.Message.obtain();
            messageObtain.what = 102;
            messageObtain.obj = bitmap;
            messageObtain.arg1 = i_renamed;
            messageObtain.arg2 = i2;
            this.i_renamed.sendMessage(messageObtain);
        }
    }

    private void g_renamed() {
        synchronized (this.f7416b) {
            if (this.i_renamed != null) {
                this.i_renamed.removeCallbacksAndMessages(null);
                this.i_renamed.getLooper().quitSafely();
                this.i_renamed = null;
            }
        }
    }

    public void a_renamed(java.lang.String str, android.util.Size size, int i_renamed) {
        com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.Builder builderNewBuilder = com.oplus.camera.watch.proto.WatchAgentProto.CameraConnectPreviewMessage.newBuilder();
        if (size != null) {
            builderNewBuilder.setCodecWidth(size.getWidth());
            builderNewBuilder.setCodecHeight(size.getHeight());
        }
        builderNewBuilder.setCurrentMode(str);
        builderNewBuilder.setCurrentModeName(this.f7417c.getString(com.oplus.camera.ui.menu.a_renamed.c_renamed.a_renamed(str)));
        builderNewBuilder.setOrientation(i_renamed);
        builderNewBuilder.addAllPhotoModeList(com.oplus.camera.watch.f_renamed.f7422a);
        a_renamed(builderNewBuilder.build().toByteArray(), 1);
    }

    public void a_renamed(android.graphics.Bitmap bitmap, int i_renamed, int i2) {
        b_renamed(bitmap.copy(android.graphics.Bitmap.Config.ARGB_8888, true), i_renamed, i2);
    }

    public void a_renamed(boolean z_renamed) {
        com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.Builder builderNewBuilder = com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureMessage.newBuilder();
        builderNewBuilder.setIsReady(z_renamed);
        a_renamed(builderNewBuilder.build().toByteArray(), 5);
    }

    public void a_renamed(int i_renamed, long j_renamed) {
        com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.Builder builderNewBuilder = com.oplus.camera.watch.proto.WatchAgentProto.CameraRecordMessage.newBuilder();
        builderNewBuilder.setVideoState(i_renamed);
        builderNewBuilder.setRecordTime(j_renamed);
        a_renamed(builderNewBuilder.build().toByteArray(), 6);
    }

    public void c_renamed() {
        a_renamed(this.n_renamed, 2);
    }

    public void d_renamed() {
        com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.Builder builderNewBuilder = com.oplus.camera.watch.proto.WatchAgentProto.CameraOAFStateMessage.newBuilder();
        builderNewBuilder.setReconnect(true);
        a_renamed(builderNewBuilder.build().toByteArray(), 20);
    }

    public void a_renamed(int i_renamed) {
        com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.Builder builderNewBuilder = com.oplus.camera.watch.proto.WatchAgentProto.CameraConfigurationMessage.newBuilder();
        builderNewBuilder.setOrientation(i_renamed);
        a_renamed(builderNewBuilder.build().toByteArray(), 9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a_renamed(android.graphics.Bitmap bitmap) {
        byte[] byteArray;
        byte[] bArr;
        if (bitmap == null) {
            com.oplus.camera.e_renamed.f_renamed("WatchAgentModel", "constructPictureBody, bitmap is_renamed null");
            return;
        }
        if (com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_FEATURE_DCIP3_SUPPORT)) {
            byteArray = com.oplus.camera.jni.IccProfile.compressBitmap(bitmap, this.o_renamed);
        } else {
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, this.o_renamed, byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        com.oplus.camera.e_renamed.a_renamed("WatchAgentModel", "constructPictureBody, bytes.length: " + byteArray.length + ", mCaptureQuality: " + this.o_renamed + ", mSinglePackageSize: " + this.p_renamed);
        int iCeil = (int) java.lang.Math.ceil((double) ((((float) byteArray.length) * 1.0f) / ((float) this.p_renamed)));
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        for (int i_renamed = 0; i_renamed < iCeil; i_renamed++) {
            if (i_renamed == iCeil - 1) {
                bArr = new byte[byteArray.length - (this.p_renamed * i_renamed)];
            } else {
                bArr = new byte[this.p_renamed];
            }
            java.lang.System.arraycopy(byteArray, this.p_renamed * i_renamed, bArr, 0, bArr.length);
            com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.Builder builderNewBuilder = com.oplus.camera.watch.proto.WatchAgentProto.CameraCaptureDataMessage.newBuilder();
            builderNewBuilder.setSubPackageIdentify(jCurrentTimeMillis);
            builderNewBuilder.setSubPackageTotal(iCeil);
            builderNewBuilder.setSubPackageIndex(i_renamed);
            builderNewBuilder.setPictureData(com.google.protobuf.ByteString.copyFrom(bArr));
            builderNewBuilder.setPackageLength(byteArray.length);
            synchronized (this.f7416b) {
                this.l_renamed.add(builderNewBuilder.build().toByteArray());
                if (this.i_renamed != null && 1 == this.l_renamed.size()) {
                    this.i_renamed.sendEmptyMessage(103);
                }
            }
        }
        bitmap.recycle();
    }

    public void a_renamed(byte[] bArr, boolean z_renamed) {
        synchronized (this.f7416b) {
            if (this.k_renamed.size() > 10) {
                com.oplus.camera.e_renamed.a_renamed("WatchAgentModel", "sendPreviewBuffer, mBufferList is_renamed full");
                this.k_renamed.remove(0);
            }
            if (z_renamed) {
                this.k_renamed.add(0, bArr);
            } else {
                this.k_renamed.add(bArr);
            }
            if (this.i_renamed != null && 1 == this.k_renamed.size()) {
                this.i_renamed.sendEmptyMessage(100);
            }
        }
    }

    public void a_renamed(com.oplus.camera.watch.c_renamed cVar) {
        this.o_renamed = cVar.g_renamed() == 0 ? 80 : cVar.g_renamed();
        this.p_renamed = cVar.h_renamed() == 0 ? com.oplus.tblplayer.monitor.ErrorCode.REASON_DS_FILE : cVar.h_renamed();
        this.q_renamed = cVar.i_renamed() == 0 ? 500 : cVar.i_renamed();
        com.oplus.camera.e_renamed.a_renamed("WatchAgentModel", "initModelParams, mCaptureQuality: " + this.o_renamed + ", mSinglePackageSize: " + this.p_renamed + ", mSinglePackageDelay: " + this.q_renamed);
    }

    /* compiled from: WatchAgentModel.java */
    private class a_renamed implements com.heytap.accessory.stream.StreamTransfer.EventListener {
        @Override // com.heytap.accessory.stream.StreamTransfer.EventListener
        public void onStreamReceived(long j_renamed, int i_renamed, java.io.InputStream inputStream) {
        }

        @Override // com.heytap.accessory.stream.StreamTransfer.EventListener
        public void onTransferRequested(long j_renamed, int i_renamed, int i2) {
        }

        private a_renamed() {
        }

        @Override // com.heytap.accessory.stream.StreamTransfer.EventListener
        public void onTransferCompleted(long j_renamed, int i_renamed, int i2) throws java.io.IOException {
            com.oplus.camera.watch.d_renamed.this.a_renamed();
        }

        @Override // com.heytap.accessory.stream.StreamTransfer.EventListener
        public void onCancelAllCompleted(int i_renamed, int i2) throws java.io.IOException {
            com.oplus.camera.watch.d_renamed.this.a_renamed();
        }
    }
}
