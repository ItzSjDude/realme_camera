package com.oplus.camera.s_renamed;

/* compiled from: StarVideoHelper.java */
/* loaded from: classes2.dex */
class a_renamed implements com.oplus.camera.capmode.x_renamed.e_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.content.Context f5319a;

    /* renamed from: c_renamed, reason: collision with root package name */
    private boolean f5321c;
    private com.oplus.camera.capmode.a_renamed d_renamed;
    private com.oplus.camera.ui.CameraUIInterface e_renamed;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.os.Handler f5320b = null;
    private android.util.Size f_renamed = null;
    private java.lang.String g_renamed = null;
    private android.net.Uri h_renamed = null;
    private android.media.CamcorderProfile i_renamed = null;
    private android.content.ContentValues j_renamed = null;
    private android.os.ParcelFileDescriptor k_renamed = null;
    private com.oplus.camera.capmode.x_renamed l_renamed = null;
    private com.oplus.camera.s_renamed.a_renamed.StarVideoHelper_2 m_renamed = null;
    private int n_renamed = 0;
    private int o_renamed = 0;
    private int p_renamed = 0;
    private boolean q_renamed = false;
    private boolean r_renamed = false;

    /* compiled from: StarVideoHelper.java */
    /* renamed from: com.oplus.camera.s_renamed.a_renamed$a_renamed, reason: collision with other inner class name */
    public interface StarVideoHelper_2 extends com.oplus.camera.capmode.x_renamed.f_renamed, com.oplus.camera.capmode.x_renamed.g_renamed, com.oplus.camera.capmode.x_renamed.h_renamed {
    }

    public int c_renamed() {
        return 30;
    }

    public a_renamed(android.content.Context context, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, boolean z_renamed) {
        this.f5319a = null;
        this.f5321c = false;
        this.d_renamed = null;
        this.e_renamed = null;
        this.f5319a = context;
        this.d_renamed = aVar;
        this.e_renamed = cameraUIInterface;
        this.f5321c = z_renamed;
    }

    private int e_renamed() {
        android.media.CamcorderProfile camcorderProfile;
        java.lang.String strJ = j_renamed();
        if ("video_size_4kuhd".equals(strJ)) {
            return 100000000;
        }
        if ("video_size_1080p".equals(strJ) && com.oplus.camera.util.Util.C_renamed() && (camcorderProfile = android.media.CamcorderProfile.get(this.n_renamed, 6)) != null) {
            return camcorderProfile.videoBitRate;
        }
        return 17000000;
    }

    public void a_renamed(int i_renamed) {
        this.n_renamed = i_renamed;
        int width = b_renamed().getWidth();
        int height = b_renamed().getHeight();
        int iE = e_renamed();
        int iC = c_renamed();
        int i2 = com.oplus.ocs.camera.CameraParameter.VideoEncoder.H265.equals(i_renamed()) ? 5 : 2;
        this.i_renamed = android.media.CamcorderProfile.get(this.n_renamed, 6);
        android.media.CamcorderProfile camcorderProfile = this.i_renamed;
        camcorderProfile.videoFrameRate = iC;
        camcorderProfile.videoBitRate = iE;
        camcorderProfile.videoCodec = i2;
        camcorderProfile.videoFrameWidth = width;
        camcorderProfile.videoFrameHeight = height;
    }

    private boolean f_renamed() {
        return !"video_size_1080p".equals(j_renamed()) || com.oplus.ocs.camera.CameraParameter.VideoEncoder.H265.equals(i_renamed());
    }

    public void a_renamed(com.oplus.camera.s_renamed.a_renamed.StarVideoHelper_2 interfaceC0111a) {
        this.m_renamed = interfaceC0111a;
    }

    public void a_renamed() {
        com.oplus.camera.e_renamed.c_renamed("StarVideoHelper", "startRecording E_renamed");
        n_renamed();
        l_renamed();
        this.l_renamed = new com.oplus.camera.capmode.x_renamed(true, this.d_renamed.al_renamed());
        this.l_renamed.c_renamed(false);
        this.l_renamed.h_renamed(false);
        this.l_renamed.i_renamed(false);
        this.l_renamed.j_renamed(true);
        this.l_renamed.a_renamed(false);
        this.l_renamed.a_renamed(java.lang.String.valueOf(this.n_renamed), this.i_renamed);
        android.location.Location locationY = this.d_renamed.y_renamed();
        if (locationY != null) {
            this.l_renamed.a_renamed((float) locationY.getLatitude(), (float) locationY.getLongitude());
        }
        this.l_renamed.o_renamed(this.d_renamed.u_renamed() % 360);
        android.os.ParcelFileDescriptor parcelFileDescriptor = this.k_renamed;
        if (parcelFileDescriptor != null) {
            this.l_renamed.a_renamed(parcelFileDescriptor.getFileDescriptor());
        } else {
            this.l_renamed.b_renamed(this.g_renamed);
        }
        this.l_renamed.g_renamed(f_renamed() ? this.i_renamed.videoBitRate / 2 : this.i_renamed.videoBitRate);
        long jC = com.oplus.camera.Storage.c_renamed(com.oplus.camera.Storage.u_renamed);
        long j_renamed = "on_renamed".equals(com.oplus.camera.Storage.u_renamed) ? com.sensetime.stmobile.STMobileHumanActionNative.ST_MOBILE_BODY_ACTION1 : 0L;
        if (j_renamed > 0 && j_renamed < jC) {
            jC = j_renamed;
        }
        this.l_renamed.a_renamed(jC);
        this.l_renamed.a_renamed((com.oplus.camera.capmode.x_renamed.f_renamed) this.m_renamed);
        this.l_renamed.a_renamed((com.oplus.camera.capmode.x_renamed.h_renamed) this.m_renamed);
        this.l_renamed.a_renamed((com.oplus.camera.capmode.x_renamed.g_renamed) this.m_renamed);
        this.l_renamed.a_renamed(this);
        try {
            this.l_renamed.e_renamed();
            this.l_renamed.b_renamed();
        } catch (java.io.IOException e_renamed) {
            e_renamed.printStackTrace();
        }
        this.q_renamed = true;
        this.o_renamed = 0;
        this.p_renamed = 0;
        com.oplus.camera.e_renamed.c_renamed("StarVideoHelper", "startRecording X_renamed");
    }

    private void g_renamed() {
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("YUV drop padding thread");
        handlerThread.start();
        this.f5320b = new android.os.Handler(handlerThread.getLooper());
    }

    public void a_renamed(com.oplus.ocs.camera.CameraPictureCallback.CameraPictureImage cameraPictureImage) {
        com.oplus.camera.e_renamed.c_renamed("StarVideoHelper", "onYuvImageReceived");
        if (!this.q_renamed || cameraPictureImage == null || this.l_renamed == null) {
            com.oplus.camera.e_renamed.f_renamed("StarVideoHelper", "onYuvImageReceived, mbRecording: " + this.q_renamed);
            return;
        }
        if (this.f5320b == null) {
            g_renamed();
        }
        this.o_renamed++;
        a_renamed(cameraPictureImage.getImage(), cameraPictureImage.getWidth(), cameraPictureImage.getHeight(), cameraPictureImage.getStride(), cameraPictureImage.getScanline(), cameraPictureImage.getOrientation());
    }

    private void a_renamed(final byte[] bArr, final int i_renamed, final int i2, final int i3, final int i4, final int i5) {
        this.f5320b.post(new java.lang.Runnable() { // from class: com.oplus.camera.s_renamed.-$$Lambda$a_renamed$tAJMKsy7gxpDwx53vRMcwkZQXI0
            @Override // java.lang.Runnable
            public final void run() {
                this.f_renamed$0.b_renamed(bArr, i3, i4, i5, i_renamed, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b_renamed(byte[] bArr, int i_renamed, int i2, int i3, int i4, int i5) {
        java.lang.String strValueOf = java.lang.String.valueOf(java.lang.System.currentTimeMillis());
        a_renamed(bArr, this.o_renamed, i_renamed, i2, i3, strValueOf, "original");
        long jUptimeMillis = android.os.SystemClock.uptimeMillis();
        com.oplus.camera.e_renamed.a_renamed("StarVideoHelper", "encodeYuv, time: " + jUptimeMillis + ", byte[]: " + bArr.length);
        byte[] bArrA = com.oplus.camera.util.Util.a_renamed(bArr, i4, i5, i_renamed, i2, true);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("encodeYuv, total deal byte[] cost: ");
        sb.append(android.os.SystemClock.uptimeMillis() - jUptimeMillis);
        com.oplus.camera.e_renamed.a_renamed("StarVideoHelper", sb.toString());
        this.l_renamed.a_renamed(bArrA);
        a_renamed(bArrA, this.o_renamed, i4, i5, i3, strValueOf, "yuv");
    }

    private void a_renamed(byte[] bArr, int i_renamed, int i2, int i3, int i4, java.lang.String str, java.lang.String str2) {
        if (this.r_renamed) {
            com.oplus.camera.util.Util.a_renamed(bArr, "capture_yuv", str + "_" + bArr.length + "_star_video_yuv_" + i_renamed + "_" + i2 + "_" + i3 + "_" + i4 + "_" + str2 + ".yuv");
        }
    }

    public void a_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.c_renamed("StarVideoHelper", "stopRecording E_renamed");
        if (!this.q_renamed) {
            com.oplus.camera.e_renamed.f_renamed("StarVideoHelper", "stopRecording, mbRecording is_renamed false, so return!");
            return;
        }
        this.q_renamed = false;
        com.oplus.camera.capmode.x_renamed xVar = this.l_renamed;
        if (xVar != null) {
            xVar.c_renamed();
            this.l_renamed.a_renamed((com.oplus.camera.capmode.x_renamed.f_renamed) null);
            this.l_renamed.a_renamed((com.oplus.camera.capmode.x_renamed.h_renamed) null);
            this.l_renamed.a_renamed((com.oplus.camera.capmode.x_renamed.g_renamed) null);
            this.l_renamed.a_renamed((com.oplus.camera.capmode.x_renamed.e_renamed) null);
        }
        if (z_renamed) {
            com.oplus.camera.ui.control.e_renamed.d_renamed dVar = new com.oplus.camera.ui.control.e_renamed.d_renamed();
            dVar.k_renamed = 1;
            a_renamed(dVar);
            n_renamed();
            dVar.d_renamed = this.h_renamed;
            this.e_renamed.a_renamed(dVar, false);
        } else {
            n_renamed();
            a_renamed(this.g_renamed);
            this.d_renamed.f_renamed(true);
        }
        this.o_renamed = 0;
        com.oplus.camera.e_renamed.c_renamed("StarVideoHelper", "stopRecording X_renamed");
    }

    public android.util.Size b_renamed() {
        if (this.f_renamed == null) {
            java.lang.String strJ = j_renamed();
            if ("video_size_4kuhd".equals(strJ)) {
                this.f_renamed = new android.util.Size(com.oplus.camera.capmode.w_renamed.VIDEO_4K_FRAME_WIDTH, com.oplus.camera.capmode.w_renamed.VIDEO_4K_FRAME_HEIGHT);
            } else if ("video_size_1080p".equals(strJ)) {
                this.f_renamed = new android.util.Size(com.oplus.camera.capmode.w_renamed.VIDEO_1080P_WIDTH, com.oplus.camera.capmode.w_renamed.VIDEO_1080P_HEIGHT);
            } else {
                this.f_renamed = new android.util.Size(com.oplus.camera.capmode.w_renamed.VIDEO_720P_WIDTH, com.oplus.camera.capmode.w_renamed.VIDEO_720P_HEIGHT);
            }
        }
        return this.f_renamed;
    }

    public int d_renamed() {
        return h_renamed() / c_renamed();
    }

    private int h_renamed() {
        return this.p_renamed;
    }

    private java.lang.String i_renamed() {
        return this.f5319a.getString(com.oplus.camera.R_renamed.string.camera_video_codec_default_value);
    }

    private java.lang.String j_renamed() {
        return com.oplus.camera.aps.config.CameraConfig.getConfigStringValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_STAR_VIDEO_SIZE_TYPE);
    }

    private java.lang.String a_renamed(long j_renamed) {
        return new java.text.SimpleDateFormat(this.f5319a.getResources().getString(com.oplus.camera.R_renamed.string.camera_video_file_name_format), java.util.Locale.US).format(new java.util.Date(j_renamed));
    }

    private java.lang.String k_renamed() {
        java.lang.StringBuilder sb;
        java.lang.String str;
        if (com.oplus.camera.Storage.u_renamed.equals("off")) {
            sb = new java.lang.StringBuilder();
            str = com.oplus.camera.Storage.q_renamed;
        } else {
            sb = new java.lang.StringBuilder();
            str = com.oplus.camera.Storage.l_renamed;
        }
        sb.append(str);
        sb.append('/');
        return sb.toString();
    }

    private void l_renamed() {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        java.lang.String strA = a_renamed(jCurrentTimeMillis);
        java.lang.String str = strA + ".mp4";
        this.g_renamed = k_renamed() + str;
        this.j_renamed = new android.content.ContentValues(7);
        this.j_renamed.put("title", strA);
        this.j_renamed.put("_display_name", str);
        this.j_renamed.put("datetaken", java.lang.Long.valueOf(jCurrentTimeMillis));
        this.j_renamed.put("mime_type", com.google.android.exoplayer2.util.MimeTypes.VIDEO_MP4);
        this.j_renamed.put("relative_path", com.oplus.camera.Storage.e_renamed(null));
        this.j_renamed.put("is_pending", (java.lang.Integer) 1);
        android.content.Context context = this.f5319a;
        this.h_renamed = com.oplus.camera.util.storage.a_renamed.a_renamed(context, context.getContentResolver(), this.j_renamed);
        try {
            this.k_renamed = this.f5319a.getContentResolver().openFileDescriptor(this.h_renamed, "rw");
        } catch (java.io.FileNotFoundException e_renamed) {
            e_renamed.printStackTrace();
        }
        android.util.Size sizeB = b_renamed();
        if (sizeB != null) {
            this.j_renamed.put("resolution", sizeB.getWidth() + "x_renamed" + sizeB.getHeight());
            this.j_renamed.put("width", java.lang.Integer.toString(sizeB.getWidth()));
            this.j_renamed.put("height", java.lang.Integer.toString(sizeB.getHeight()));
        }
        android.location.Location locationY = this.d_renamed.y_renamed();
        if (locationY != null) {
            this.j_renamed.put("latitude", java.lang.Double.valueOf(locationY.getLatitude()));
            this.j_renamed.put("longitude", java.lang.Double.valueOf(locationY.getLongitude()));
        }
        com.oplus.camera.e_renamed.a_renamed("StarVideoHelper", "generateVideoFilename, New video filename: " + this.g_renamed + ", mCurrentVideoUri: " + this.h_renamed + ", videoSize: " + sizeB);
    }

    private void a_renamed(java.lang.String str) {
        com.oplus.camera.e_renamed.a_renamed("StarVideoHelper", "deleteVideoFile, fileName: " + str);
        if (str == null) {
            return;
        }
        java.io.File file = new java.io.File(str);
        if (file.exists() && !file.delete()) {
            com.oplus.camera.e_renamed.a_renamed("StarVideoHelper", "deleteVideoFile, Could not delete " + str);
        }
        if (this.h_renamed != null) {
            try {
                try {
                    this.f5319a.getContentResolver().delete(this.h_renamed, null, null);
                } catch (java.lang.Exception e_renamed) {
                    e_renamed.printStackTrace();
                }
            } finally {
                this.h_renamed = null;
            }
        }
    }

    private long m_renamed() {
        com.oplus.camera.e_renamed.c_renamed("StarVideoHelper", "calcVideoDuration, mEncodeFrameNumber: " + this.p_renamed + ", time: " + (h_renamed() / c_renamed()));
        return (int) (r0 * 1000.0f);
    }

    private void n_renamed() throws java.io.IOException {
        android.os.ParcelFileDescriptor parcelFileDescriptor = this.k_renamed;
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
            } catch (java.io.IOException e_renamed) {
                com.oplus.camera.e_renamed.d_renamed("StarVideoHelper", "closeVideoFileDescriptor, Fail to close fd_renamed", e_renamed);
            }
            this.k_renamed = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:23:0x0099 A_renamed[PHI: r2 r8
      0x0099: PHI (r2v23 android.media.MediaMetadataRetriever) = (r2v13 android.media.MediaMetadataRetriever), (r2v24 android.media.MediaMetadataRetriever) binds: [B_renamed:31:0x00ab, B_renamed:22:0x008d] A_renamed[DONT_GENERATE, DONT_INLINE]
      0x0099: PHI (r8v3 long) = (r8v1 long), (r8v8 long) binds: [B_renamed:31:0x00ab, B_renamed:22:0x008d] A_renamed[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:35:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:36:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:39:0x00e3 A_renamed[Catch: Exception -> 0x014e, TryCatch #1 {Exception -> 0x014e, blocks: (B_renamed:37:0x00df, B_renamed:39:0x00e3, B_renamed:41:0x00f4, B_renamed:43:0x00f8, B_renamed:44:0x0115), top: B_renamed:58:0x00df }] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:49:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:54:0x0164  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean a_renamed(com.oplus.camera.ui.control.e_renamed.d_renamed r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 362
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.s_renamed.a_renamed.a_renamed(com.oplus.camera.ui.control.e_renamed$d_renamed):boolean");
    }

    @Override // com.oplus.camera.capmode.x_renamed.e_renamed
    public long a_renamed(android.media.MediaCodec.BufferInfo bufferInfo) {
        this.p_renamed++;
        return (this.p_renamed * 1000000) / c_renamed();
    }
}
