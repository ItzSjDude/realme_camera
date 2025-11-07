package com.oplus.camera.photo3d;

/* compiled from: ThreeDVideoHelper.java */
/* loaded from: classes2.dex */
public class d_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    private static final android.util.Size f5020a = new android.util.Size(com.oplus.camera.capmode.w_renamed.VIDEO_1080P_WIDTH, com.oplus.camera.capmode.w_renamed.VIDEO_1080P_HEIGHT);

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.content.Context f5021b;

    /* renamed from: c_renamed, reason: collision with root package name */
    private com.oplus.camera.capmode.a_renamed f5022c;
    private com.oplus.camera.ui.CameraUIInterface d_renamed;
    private android.media.CamcorderProfile e_renamed = null;
    private android.content.ContentValues f_renamed = null;
    private android.os.ParcelFileDescriptor g_renamed = null;
    private com.oplus.camera.capmode.x_renamed h_renamed = null;
    private android.util.Size i_renamed = null;
    private android.net.Uri j_renamed = null;
    private java.lang.String k_renamed = null;
    private boolean l_renamed = false;
    private int m_renamed = 0;
    private com.oplus.camera.photo3d.d_renamed.b_renamed n_renamed;
    private final android.os.Handler o_renamed;

    /* compiled from: ThreeDVideoHelper.java */
    public interface b_renamed {
        void a_renamed(android.view.Surface surface);
    }

    public d_renamed(android.content.Context context, android.os.Handler handler, com.oplus.camera.capmode.a_renamed aVar, com.oplus.camera.ui.CameraUIInterface cameraUIInterface) {
        this.f5021b = context;
        this.o_renamed = handler;
        this.f5022c = aVar;
        this.d_renamed = cameraUIInterface;
    }

    public void a_renamed() throws java.lang.IllegalStateException, java.io.IOException, java.lang.IllegalArgumentException {
        com.oplus.camera.e_renamed.c_renamed("ThreeDVideoHelper", "startRecording E_renamed");
        a_renamed(0);
        e_renamed();
        f_renamed();
        this.h_renamed = new com.oplus.camera.capmode.x_renamed(true, this.f5022c.al_renamed());
        this.h_renamed.h_renamed(false);
        this.h_renamed.i_renamed(false);
        this.h_renamed.a_renamed(java.lang.String.valueOf(0), this.e_renamed);
        this.d_renamed.b_renamed(this.e_renamed.videoFrameWidth, this.e_renamed.videoFrameHeight);
        android.location.Location locationY = this.f5022c.y_renamed();
        if (locationY != null) {
            this.h_renamed.a_renamed((float) locationY.getLatitude(), (float) locationY.getLongitude());
        }
        this.h_renamed.o_renamed(this.f5022c.v_renamed() % 360);
        android.os.ParcelFileDescriptor parcelFileDescriptor = this.g_renamed;
        if (parcelFileDescriptor != null) {
            this.h_renamed.a_renamed(parcelFileDescriptor.getFileDescriptor());
        } else {
            this.h_renamed.b_renamed(this.k_renamed);
        }
        this.h_renamed.g_renamed(this.e_renamed.videoBitRate);
        long jC = com.oplus.camera.Storage.c_renamed(com.oplus.camera.Storage.u_renamed);
        long j_renamed = "on_renamed".equals(com.oplus.camera.Storage.u_renamed) ? com.sensetime.stmobile.STMobileHumanActionNative.ST_MOBILE_BODY_ACTION1 : 0L;
        if (j_renamed > 0 && j_renamed < jC) {
            jC = j_renamed;
        }
        com.oplus.camera.photo3d.d_renamed.a_renamed aVar = new com.oplus.camera.photo3d.d_renamed.a_renamed();
        this.h_renamed.a_renamed(jC);
        this.h_renamed.a_renamed((com.oplus.camera.capmode.x_renamed.f_renamed) aVar);
        this.h_renamed.a_renamed((com.oplus.camera.capmode.x_renamed.h_renamed) aVar);
        this.h_renamed.a_renamed((com.oplus.camera.capmode.x_renamed.g_renamed) aVar);
        this.h_renamed.a_renamed((com.oplus.camera.capmode.x_renamed.d_renamed) aVar);
        try {
            this.h_renamed.e_renamed();
            this.h_renamed.b_renamed();
        } catch (java.io.IOException e_renamed) {
            e_renamed.printStackTrace();
        }
        this.l_renamed = true;
        com.oplus.camera.e_renamed.c_renamed("ThreeDVideoHelper", "startRecording X_renamed");
    }

    public void a_renamed(int i_renamed) {
        this.m_renamed = i_renamed;
        int width = b_renamed().getWidth();
        int height = b_renamed().getHeight();
        int iD = d_renamed();
        this.e_renamed = android.media.CamcorderProfile.get(this.m_renamed, 6);
        android.media.CamcorderProfile camcorderProfile = this.e_renamed;
        camcorderProfile.videoFrameRate = 30;
        camcorderProfile.videoBitRate = iD;
        camcorderProfile.videoCodec = 2;
        camcorderProfile.videoFrameWidth = width;
        camcorderProfile.videoFrameHeight = height;
    }

    private int d_renamed() {
        android.media.CamcorderProfile camcorderProfile;
        if (!com.oplus.camera.util.Util.C_renamed() || (camcorderProfile = android.media.CamcorderProfile.get(this.m_renamed, 6)) == null) {
            return 17000000;
        }
        return camcorderProfile.videoBitRate;
    }

    private void e_renamed() throws java.io.IOException {
        android.os.ParcelFileDescriptor parcelFileDescriptor = this.g_renamed;
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
            } catch (java.io.IOException e_renamed) {
                com.oplus.camera.e_renamed.d_renamed("ThreeDVideoHelper", "closeVideoFileDescriptor, Fail to close fd_renamed", e_renamed);
            }
            this.g_renamed = null;
        }
    }

    private void f_renamed() {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        java.lang.String strA = a_renamed(jCurrentTimeMillis);
        java.lang.String str = strA + ".mp4";
        this.k_renamed = g_renamed() + str;
        this.f_renamed = new android.content.ContentValues(7);
        this.f_renamed.put("title", strA);
        this.f_renamed.put("_display_name", str);
        this.f_renamed.put("datetaken", java.lang.Long.valueOf(jCurrentTimeMillis));
        this.f_renamed.put("mime_type", com.google.android.exoplayer2.util.MimeTypes.VIDEO_MP4);
        this.f_renamed.put("relative_path", com.oplus.camera.Storage.e_renamed(null));
        this.f_renamed.put("is_pending", (java.lang.Integer) 1);
        android.content.Context context = this.f5021b;
        this.j_renamed = com.oplus.camera.util.storage.a_renamed.a_renamed(context, context.getContentResolver(), this.f_renamed);
        try {
            this.g_renamed = this.f5021b.getContentResolver().openFileDescriptor(this.j_renamed, "rw");
        } catch (java.io.FileNotFoundException e_renamed) {
            e_renamed.printStackTrace();
        }
        android.util.Size sizeB = b_renamed();
        if (sizeB != null) {
            this.f_renamed.put("resolution", sizeB.getWidth() + "x_renamed" + sizeB.getHeight());
            this.f_renamed.put("width", java.lang.Integer.toString(sizeB.getWidth()));
            this.f_renamed.put("height", java.lang.Integer.toString(sizeB.getHeight()));
        }
        android.location.Location locationY = this.f5022c.y_renamed();
        if (locationY != null) {
            this.f_renamed.put("latitude", java.lang.Double.valueOf(locationY.getLatitude()));
            this.f_renamed.put("longitude", java.lang.Double.valueOf(locationY.getLongitude()));
        }
        com.oplus.camera.e_renamed.a_renamed("ThreeDVideoHelper", "generateVideoFilename, New video filename: " + this.k_renamed + ", mCurrentVideoUri: " + this.j_renamed + ", videoSize: " + sizeB);
    }

    private java.lang.String a_renamed(long j_renamed) {
        return new java.text.SimpleDateFormat(this.f5021b.getResources().getString(com.oplus.camera.R_renamed.string.camera_video_file_name_format), java.util.Locale.US).format(new java.util.Date(j_renamed));
    }

    private java.lang.String g_renamed() {
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

    public android.util.Size b_renamed() {
        if (this.i_renamed == null) {
            this.i_renamed = com.oplus.camera.aps.config.CameraConfig.getSizeConfigValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_3D_PHOTO_VIDEO_SIZE);
            if (this.i_renamed == null) {
                this.i_renamed = f5020a;
            }
        }
        return this.i_renamed;
    }

    public void c_renamed() throws java.lang.Throwable {
        com.oplus.camera.e_renamed.c_renamed("ThreeDVideoHelper", "stopRecording E_renamed");
        if (!this.l_renamed) {
            com.oplus.camera.e_renamed.f_renamed("ThreeDVideoHelper", "stopRecording, mbRecording is_renamed false, so return!");
            return;
        }
        this.l_renamed = false;
        com.oplus.camera.capmode.x_renamed xVar = this.h_renamed;
        if (xVar != null) {
            xVar.c_renamed();
            this.h_renamed.a_renamed((com.oplus.camera.capmode.x_renamed.f_renamed) null);
            this.h_renamed.a_renamed((com.oplus.camera.capmode.x_renamed.h_renamed) null);
            this.h_renamed.a_renamed((com.oplus.camera.capmode.x_renamed.g_renamed) null);
            this.h_renamed.a_renamed((com.oplus.camera.capmode.x_renamed.d_renamed) null);
        }
        com.oplus.camera.ui.control.e_renamed.d_renamed dVar = new com.oplus.camera.ui.control.e_renamed.d_renamed();
        dVar.k_renamed = 1;
        a_renamed(dVar);
        e_renamed();
        dVar.d_renamed = this.j_renamed;
        this.d_renamed.a_renamed(dVar, false);
        com.oplus.camera.e_renamed.c_renamed("ThreeDVideoHelper", "stopRecording X_renamed");
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:23:0x0099 A_renamed[PHI: r2 r8
      0x0099: PHI (r2v23 android.media.MediaMetadataRetriever) = (r2v13 android.media.MediaMetadataRetriever), (r2v24 android.media.MediaMetadataRetriever) binds: [B_renamed:31:0x00ab, B_renamed:22:0x008d] A_renamed[DONT_GENERATE, DONT_INLINE]
      0x0099: PHI (r8v3 long) = (r8v1 long), (r8v8 long) binds: [B_renamed:31:0x00ab, B_renamed:22:0x008d] A_renamed[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:35:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:38:0x00d5 A_renamed[Catch: Exception -> 0x013c, TryCatch #1 {Exception -> 0x013c, blocks: (B_renamed:36:0x00d1, B_renamed:38:0x00d5, B_renamed:40:0x00e6, B_renamed:41:0x0103), top: B_renamed:55:0x00d1 }] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:46:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:51:0x0152  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean a_renamed(com.oplus.camera.ui.control.e_renamed.d_renamed r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.photo3d.d_renamed.a_renamed(com.oplus.camera.ui.control.e_renamed$d_renamed):boolean");
    }

    /* compiled from: ThreeDVideoHelper.java */
    class a_renamed implements com.oplus.camera.capmode.x_renamed.d_renamed, com.oplus.camera.capmode.x_renamed.f_renamed, com.oplus.camera.capmode.x_renamed.g_renamed, com.oplus.camera.capmode.x_renamed.h_renamed {
        a_renamed() {
        }

        @Override // com.oplus.camera.capmode.x_renamed.h_renamed
        public void onInfo(java.lang.Object obj, final int i_renamed, int i2) {
            com.oplus.camera.e_renamed.b_renamed("ThreeDVideoHelper", "onInfo, what: " + i_renamed);
            com.oplus.camera.photo3d.d_renamed.this.o_renamed.post(new java.lang.Runnable() { // from class: com.oplus.camera.photo3d.d_renamed.a_renamed.1
                @Override // java.lang.Runnable
                public void run() throws java.lang.Throwable {
                    int i3 = i_renamed;
                    if ((800 == i3 || 800 == i3 || 802 == i3) && com.oplus.camera.photo3d.d_renamed.this.l_renamed) {
                        com.oplus.camera.photo3d.d_renamed.this.c_renamed();
                    }
                }
            });
        }

        @Override // com.oplus.camera.capmode.x_renamed.f_renamed
        public void onError(java.lang.Object obj, final int i_renamed, int i2) {
            com.oplus.camera.e_renamed.f_renamed("ThreeDVideoHelper", "onError, what: " + i_renamed);
            com.oplus.camera.photo3d.d_renamed.this.o_renamed.post(new java.lang.Runnable() { // from class: com.oplus.camera.photo3d.d_renamed.a_renamed.2
                @Override // java.lang.Runnable
                public void run() throws java.lang.Throwable {
                    int i3 = i_renamed;
                    if ((1100 == i3 || 1101 == i3) && com.oplus.camera.photo3d.d_renamed.this.l_renamed) {
                        com.oplus.camera.photo3d.d_renamed.this.c_renamed();
                    }
                }
            });
        }

        @Override // com.oplus.camera.capmode.x_renamed.g_renamed
        public void onException(final int i_renamed) {
            com.oplus.camera.e_renamed.f_renamed("ThreeDVideoHelper", "onException, exceptionCode: " + i_renamed);
            com.oplus.camera.photo3d.d_renamed.this.o_renamed.post(new java.lang.Runnable() { // from class: com.oplus.camera.photo3d.d_renamed.a_renamed.3
                @Override // java.lang.Runnable
                public void run() throws java.lang.Throwable {
                    if (1 == i_renamed && com.oplus.camera.photo3d.d_renamed.this.l_renamed) {
                        com.oplus.camera.photo3d.d_renamed.this.c_renamed();
                    }
                }
            });
        }

        @Override // com.oplus.camera.capmode.x_renamed.d_renamed
        public void a_renamed(android.view.Surface surface) {
            com.oplus.camera.e_renamed.b_renamed("ThreeDVideoHelper", "onEncodeSurfaceCreated, surface: " + surface);
            if (com.oplus.camera.photo3d.d_renamed.this.n_renamed != null) {
                com.oplus.camera.photo3d.d_renamed.this.n_renamed.a_renamed(surface);
            }
        }
    }

    public void a_renamed(com.oplus.camera.photo3d.d_renamed.b_renamed bVar) {
        this.n_renamed = bVar;
    }
}
