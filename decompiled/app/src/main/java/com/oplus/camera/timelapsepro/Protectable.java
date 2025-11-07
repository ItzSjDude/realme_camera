package com.oplus.camera.timelapsepro;

/* compiled from: RecorderHelper.java */
/* loaded from: classes2.dex */
public class c_renamed implements com.oplus.camera.capmode.x_renamed.e_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.content.Context f5677a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private boolean f5678b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.capmode.a_renamed f5679c;
    private com.oplus.camera.ui.CameraUIInterface d_renamed;
    private byte[] e_renamed = null;
    private android.os.ConditionVariable f_renamed = new android.os.ConditionVariable();
    private android.util.Size g_renamed = null;
    private java.lang.String h_renamed = null;
    private android.net.Uri i_renamed = null;
    private android.media.CamcorderProfile j_renamed = null;
    private android.content.ContentValues k_renamed = null;
    private android.os.ParcelFileDescriptor l_renamed = null;
    private com.oplus.camera.capmode.x_renamed m_renamed = null;
    private com.oplus.camera.timelapsepro.c_renamed.a_renamed n_renamed = null;
    private int o_renamed = 0;
    private int p_renamed = 0;
    private int q_renamed = 0;
    private boolean r_renamed = false;
    private boolean s_renamed = false;
    private boolean t_renamed = false;
    private boolean u_renamed = false;
    private java.lang.String v_renamed = null;
    private byte[] w_renamed = null;
    private int x_renamed = 0;

    /* compiled from: RecorderHelper.java */
    public interface a_renamed extends com.oplus.camera.capmode.x_renamed.f_renamed, com.oplus.camera.capmode.x_renamed.g_renamed, com.oplus.camera.capmode.x_renamed.h_renamed {
    }

    public int c_renamed() {
        return 30;
    }

    public c_renamed(android.content.Context context, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface, boolean z_renamed) {
        this.f5677a = null;
        this.f5678b = false;
        this.f5679c = null;
        this.d_renamed = null;
        this.f5677a = context;
        this.f5679c = aVar;
        this.d_renamed = cameraUIInterface;
        this.f5678b = z_renamed;
    }

    private int d_renamed() {
        android.media.CamcorderProfile camcorderProfile;
        java.lang.String strH = h_renamed();
        if ("video_size_4kuhd".equals(strH)) {
            return 100000000;
        }
        if ("video_size_1080p".equals(strH) && com.oplus.camera.util.Util.C_renamed() && (camcorderProfile = android.media.CamcorderProfile.get(this.o_renamed, 6)) != null) {
            return camcorderProfile.videoBitRate;
        }
        return 17000000;
    }

    public void a_renamed(int i_renamed) {
        c_renamed(com.oplus.camera.e_renamed.a_renamed.a_renamed(i_renamed));
        this.o_renamed = i_renamed;
        int width = b_renamed().getWidth();
        int height = b_renamed().getHeight();
        int iD = d_renamed();
        int iC = c_renamed();
        int i2 = com.oplus.ocs.camera.CameraParameter.VideoEncoder.H265.equals(g_renamed()) ? 5 : 2;
        this.j_renamed = android.media.CamcorderProfile.get(this.o_renamed, 6);
        android.media.CamcorderProfile camcorderProfile = this.j_renamed;
        camcorderProfile.videoFrameRate = iC;
        camcorderProfile.videoBitRate = iD;
        camcorderProfile.videoCodec = i2;
        camcorderProfile.videoFrameWidth = width;
        camcorderProfile.videoFrameHeight = height;
    }

    public void a_renamed() {
        com.oplus.camera.e_renamed.c_renamed("RecorderHelper", "startRecording Begin");
        if (this.e_renamed != null) {
            this.e_renamed = null;
        }
        l_renamed();
        j_renamed();
        this.m_renamed = new com.oplus.camera.capmode.x_renamed(true, 0.0f);
        this.m_renamed.c_renamed(false);
        this.m_renamed.h_renamed(false);
        this.m_renamed.i_renamed(false);
        this.m_renamed.j_renamed(true);
        this.m_renamed.a_renamed(false);
        this.m_renamed.a_renamed(java.lang.String.valueOf(this.o_renamed), this.j_renamed);
        android.location.Location locationY = this.f5679c.y_renamed();
        if (locationY != null) {
            this.m_renamed.a_renamed((float) locationY.getLatitude(), (float) locationY.getLongitude());
        }
        this.x_renamed = this.f5679c.u_renamed();
        this.m_renamed.o_renamed(this.x_renamed % 360);
        android.os.ParcelFileDescriptor parcelFileDescriptor = this.l_renamed;
        if (parcelFileDescriptor != null) {
            this.m_renamed.a_renamed(parcelFileDescriptor.getFileDescriptor());
        } else {
            this.m_renamed.b_renamed(this.h_renamed);
        }
        long jC = com.oplus.camera.Storage.c_renamed(com.oplus.camera.Storage.u_renamed);
        long j_renamed = "on_renamed".equals(com.oplus.camera.Storage.u_renamed) ? com.sensetime.stmobile.STMobileHumanActionNative.ST_MOBILE_BODY_ACTION1 : 0L;
        if (j_renamed > 0 && j_renamed < jC) {
            jC = j_renamed;
        }
        this.m_renamed.a_renamed(jC);
        this.m_renamed.a_renamed((com.oplus.camera.capmode.x_renamed.f_renamed) this.n_renamed);
        this.m_renamed.a_renamed((com.oplus.camera.capmode.x_renamed.h_renamed) this.n_renamed);
        this.m_renamed.a_renamed((com.oplus.camera.capmode.x_renamed.g_renamed) this.n_renamed);
        this.m_renamed.a_renamed(this);
        try {
            this.m_renamed.e_renamed();
            this.m_renamed.b_renamed();
        } catch (java.io.IOException e_renamed) {
            e_renamed.printStackTrace();
        }
        this.r_renamed = true;
        this.p_renamed = 0;
        this.q_renamed = 0;
        com.oplus.camera.e_renamed.c_renamed("RecorderHelper", "startRecording End");
    }

    public boolean a_renamed(boolean z_renamed) {
        com.oplus.camera.e_renamed.c_renamed("RecorderHelper", "stopRecording Begin");
        if (!this.r_renamed) {
            com.oplus.camera.e_renamed.f_renamed("RecorderHelper", "stopRecording, mbRecording is_renamed false, so return!");
            return z_renamed;
        }
        byte[] bArr = this.e_renamed;
        if (bArr != null) {
            a_renamed(bArr);
            this.e_renamed = null;
            this.f_renamed.close();
            this.f_renamed.block(50L);
        }
        this.r_renamed = false;
        com.oplus.camera.capmode.x_renamed xVar = this.m_renamed;
        if (xVar != null) {
            xVar.c_renamed();
            this.m_renamed.a_renamed((com.oplus.camera.capmode.x_renamed.f_renamed) null);
            this.m_renamed.a_renamed((com.oplus.camera.capmode.x_renamed.h_renamed) null);
            this.m_renamed.a_renamed((com.oplus.camera.capmode.x_renamed.g_renamed) null);
            this.m_renamed.a_renamed((com.oplus.camera.capmode.x_renamed.e_renamed) null);
        }
        boolean z2 = true;
        if (z_renamed && e_renamed()) {
            com.oplus.camera.ui.control.e_renamed.d_renamed dVar = new com.oplus.camera.ui.control.e_renamed.d_renamed();
            dVar.k_renamed = 1;
            a_renamed(dVar);
            l_renamed();
            dVar.d_renamed = this.i_renamed;
            this.d_renamed.a_renamed(dVar, false);
            if (dVar.d_renamed != null) {
                java.lang.String strB = com.oplus.camera.util.Util.b_renamed(dVar.d_renamed);
                dVar.f6062b = this.x_renamed;
                this.d_renamed.a_renamed(strB, dVar.f6062b);
            }
        } else {
            l_renamed();
            b_renamed(this.h_renamed);
            this.d_renamed.d_renamed(false);
            z2 = false;
        }
        this.p_renamed = 0;
        com.oplus.camera.e_renamed.c_renamed("RecorderHelper", "stopRecording End");
        return z2;
    }

    private boolean e_renamed() {
        com.oplus.camera.capmode.x_renamed xVar = this.m_renamed;
        return xVar != null && xVar.a_renamed();
    }

    public android.util.Size b_renamed() {
        java.lang.String strH = h_renamed();
        if ("video_size_4kuhd".equals(strH)) {
            if (this.u_renamed) {
                this.g_renamed = new android.util.Size(com.oplus.camera.capmode.w_renamed.VIDEO_1080P_WIDTH, com.oplus.camera.capmode.w_renamed.VIDEO_1080P_HEIGHT);
            } else {
                this.g_renamed = new android.util.Size(com.oplus.camera.capmode.w_renamed.VIDEO_4K_FRAME_WIDTH, com.oplus.camera.capmode.w_renamed.VIDEO_4K_FRAME_HEIGHT);
            }
        } else if ("video_size_1080p".equals(strH)) {
            this.g_renamed = new android.util.Size(com.oplus.camera.capmode.w_renamed.VIDEO_1080P_WIDTH, com.oplus.camera.capmode.w_renamed.VIDEO_1080P_HEIGHT);
        } else {
            this.g_renamed = new android.util.Size(com.oplus.camera.capmode.w_renamed.VIDEO_720P_WIDTH, com.oplus.camera.capmode.w_renamed.VIDEO_720P_HEIGHT);
        }
        return this.g_renamed;
    }

    private int f_renamed() {
        return this.q_renamed;
    }

    private java.lang.String g_renamed() {
        return this.f5677a.getString(com.oplus.camera.R_renamed.string.camera_video_codec_default_value);
    }

    private java.lang.String h_renamed() {
        return com.oplus.camera.aps.config.CameraConfig.getConfigStringValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_STAR_VIDEO_SIZE_TYPE);
    }

    private java.lang.String a_renamed(long j_renamed) {
        return new java.text.SimpleDateFormat(this.f5677a.getResources().getString(com.oplus.camera.R_renamed.string.camera_video_file_name_format), java.util.Locale.US).format(new java.util.Date(j_renamed));
    }

    private java.lang.String i_renamed() {
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

    private void j_renamed() {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        java.lang.String strA = a_renamed(jCurrentTimeMillis);
        java.lang.String str = strA + ".mp4";
        this.h_renamed = i_renamed() + str;
        this.k_renamed = new android.content.ContentValues(7);
        this.k_renamed.put("title", strA);
        this.k_renamed.put("_display_name", str);
        this.k_renamed.put("datetaken", java.lang.Long.valueOf(jCurrentTimeMillis));
        this.k_renamed.put("mime_type", com.google.android.exoplayer2.util.MimeTypes.VIDEO_MP4);
        this.k_renamed.put("relative_path", com.oplus.camera.Storage.e_renamed(null));
        this.k_renamed.put("is_pending", (java.lang.Integer) 1);
        android.content.Context context = this.f5677a;
        this.i_renamed = com.oplus.camera.util.storage.a_renamed.a_renamed(context, context.getContentResolver(), this.k_renamed);
        try {
            this.l_renamed = this.f5677a.getContentResolver().openFileDescriptor(this.i_renamed, "rw");
        } catch (java.io.FileNotFoundException e_renamed) {
            e_renamed.printStackTrace();
        }
        android.util.Size sizeB = b_renamed();
        if (sizeB != null) {
            this.k_renamed.put("resolution", sizeB.getWidth() + "x_renamed" + sizeB.getHeight());
            this.k_renamed.put("width", java.lang.Integer.toString(sizeB.getWidth()));
            this.k_renamed.put("height", java.lang.Integer.toString(sizeB.getHeight()));
        }
        android.location.Location locationY = this.f5679c.y_renamed();
        if (locationY != null) {
            this.k_renamed.put("latitude", java.lang.Double.valueOf(locationY.getLatitude()));
            this.k_renamed.put("longitude", java.lang.Double.valueOf(locationY.getLongitude()));
        }
        com.oplus.camera.e_renamed.a_renamed("RecorderHelper", "generateVideoFilename, New video filename: " + this.h_renamed + ", mCurrentVideoUri: " + this.i_renamed + ", videoSize: " + sizeB);
    }

    private void b_renamed(java.lang.String str) {
        com.oplus.camera.e_renamed.a_renamed("RecorderHelper", "deleteVideoFile, fileName: " + str);
        if (str == null) {
            return;
        }
        java.io.File file = new java.io.File(str);
        if (file.exists() && !file.delete()) {
            com.oplus.camera.e_renamed.a_renamed("RecorderHelper", "deleteVideoFile, Could not delete " + str);
        }
        if (this.i_renamed != null) {
            try {
                try {
                    this.f5677a.getContentResolver().delete(this.i_renamed, null, null);
                } catch (java.lang.Exception e_renamed) {
                    e_renamed.printStackTrace();
                }
            } finally {
                this.i_renamed = null;
            }
        }
    }

    private long k_renamed() {
        com.oplus.camera.e_renamed.a_renamed("RecorderHelper", "calcVideoDuration, mEncodeFrameNumber: " + this.q_renamed + ", time: " + (f_renamed() / c_renamed()));
        return (int) (r0 * 1000.0f);
    }

    private void l_renamed() throws java.io.IOException {
        android.os.ParcelFileDescriptor parcelFileDescriptor = this.l_renamed;
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
            } catch (java.io.IOException e_renamed) {
                com.oplus.camera.e_renamed.d_renamed("RecorderHelper", "closeVideoFileDescriptor, Fail to close fd_renamed", e_renamed);
            }
            this.l_renamed = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:23:0x00a4 A_renamed[PHI: r2 r8
      0x00a4: PHI (r2v26 android.media.MediaMetadataRetriever) = (r2v13 android.media.MediaMetadataRetriever), (r2v27 android.media.MediaMetadataRetriever) binds: [B_renamed:31:0x00b6, B_renamed:22:0x0098] A_renamed[DONT_GENERATE, DONT_INLINE]
      0x00a4: PHI (r8v3 long) = (r8v1 long), (r8v8 long) binds: [B_renamed:31:0x00b6, B_renamed:22:0x0098] A_renamed[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:35:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:36:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:39:0x00ee A_renamed[Catch: Exception -> 0x0176, TryCatch #4 {Exception -> 0x0176, blocks: (B_renamed:37:0x00ea, B_renamed:39:0x00ee, B_renamed:41:0x00ff, B_renamed:42:0x010b, B_renamed:44:0x010f, B_renamed:46:0x0113, B_renamed:50:0x0138, B_renamed:51:0x013d, B_renamed:47:0x0133), top: B_renamed:69:0x00ea, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:61:0x018c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean a_renamed(com.oplus.camera.ui.control.e_renamed.d_renamed r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.timelapsepro.c_renamed.a_renamed(com.oplus.camera.ui.control.e_renamed$d_renamed):boolean");
    }

    @Override // com.oplus.camera.capmode.x_renamed.e_renamed
    public long a_renamed(android.media.MediaCodec.BufferInfo bufferInfo) {
        com.oplus.camera.e_renamed.a_renamed("RecorderHelper", "computePresentationTime, mEncodeFrameNumber: " + this.q_renamed);
        this.q_renamed = this.q_renamed + 1;
        return (this.q_renamed * 1000000) / c_renamed();
    }

    public void a_renamed(byte[] bArr) {
        if (this.e_renamed == null) {
            this.e_renamed = new byte[bArr.length];
        }
        java.lang.System.arraycopy(bArr, 0, this.e_renamed, 0, bArr.length);
        this.m_renamed.a_renamed(bArr);
    }

    public void b_renamed(boolean z_renamed) {
        this.t_renamed = z_renamed;
    }

    public void c_renamed(boolean z_renamed) {
        this.u_renamed = z_renamed;
    }

    public void d_renamed(boolean z_renamed) {
        com.oplus.camera.capmode.x_renamed xVar = this.m_renamed;
        if (xVar != null) {
            xVar.b_renamed(z_renamed);
        }
    }

    public void a_renamed(java.lang.String str) {
        java.lang.String str2 = this.v_renamed;
        if (str2 == null || !str2.equals(str)) {
            this.v_renamed = str;
            byte[] bytes = str.getBytes();
            byte[] bArrA = com.oplus.camera.g_renamed.a_renamed.a_renamed(bytes.length + 8);
            byte[] bytes2 = "titl".getBytes();
            this.w_renamed = new byte[bytes.length + 8];
            java.lang.System.arraycopy(bArrA, 0, this.w_renamed, 0, bArrA.length);
            java.lang.System.arraycopy(bytes2, 0, this.w_renamed, 4, bytes2.length);
            java.lang.System.arraycopy(bytes, 0, this.w_renamed, 8, bytes.length);
        }
    }
}
