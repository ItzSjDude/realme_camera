package com.oplus.camera.capmode;

/* compiled from: VideoRecorder.java */
/* loaded from: classes2.dex */
public class x_renamed {

    /* renamed from: a_renamed, reason: collision with root package name */
    public static float f4343a;
    private boolean k_renamed;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.lang.String f4345c = null;
    private boolean d_renamed = false;
    private android.media.AudioManager e_renamed = null;
    private java.lang.String f_renamed = "";
    private float g_renamed = -1.0f;
    private float h_renamed = -1.0f;
    private int i_renamed = -1;
    private boolean j_renamed = false;

    /* renamed from: b_renamed, reason: collision with root package name */
    public int f4344b = 0;
    private android.media.MediaRecorder l_renamed = null;
    private com.oplus.camera.capmode.b_renamed m_renamed = null;
    private com.oplus.camera.capmode.x_renamed.h_renamed n_renamed = null;
    private com.oplus.camera.capmode.x_renamed.f_renamed o_renamed = null;
    private com.oplus.camera.capmode.x_renamed.g_renamed p_renamed = null;
    private com.oplus.camera.capmode.x_renamed.e_renamed q_renamed = null;
    private com.oplus.camera.capmode.x_renamed.d_renamed r_renamed = null;

    /* compiled from: VideoRecorder.java */
    public interface d_renamed {
        void a_renamed(android.view.Surface surface);
    }

    /* compiled from: VideoRecorder.java */
    public interface e_renamed {
        long a_renamed(android.media.MediaCodec.BufferInfo bufferInfo);
    }

    /* compiled from: VideoRecorder.java */
    public interface f_renamed {
        void onError(java.lang.Object obj, int i_renamed, int i2);
    }

    /* compiled from: VideoRecorder.java */
    public interface g_renamed {
        void onException(int i_renamed);
    }

    /* compiled from: VideoRecorder.java */
    public interface h_renamed {
        void onInfo(java.lang.Object obj, int i_renamed, int i2);
    }

    public java.lang.String c_renamed(int i_renamed, int i2) {
        if (i_renamed == 0) {
            if (i2 != 0) {
                if (i2 == 90) {
                    return "2";
                }
                if (i2 != 180) {
                    if (i2 == 270) {
                        return "1";
                    }
                }
            }
            return "3";
        }
        if (i_renamed == 1) {
            if (i2 != 0) {
                if (i2 == 90) {
                    return com.oplus.camera.statistics.model.FocusAimMsgData.KEY_TOUCH_TAKE_PICTURE;
                }
                if (i2 != 180) {
                    if (i2 == 270) {
                        return "5";
                    }
                }
            }
            return "4";
        }
        return "";
    }

    public x_renamed(boolean z_renamed, float f2) {
        this.k_renamed = false;
        this.k_renamed = z_renamed;
        f4343a = f2 * 10.0f;
        h_renamed();
    }

    private void h_renamed() {
        if (this.k_renamed) {
            this.m_renamed = new com.oplus.camera.capmode.b_renamed();
            this.m_renamed.a_renamed(new com.oplus.camera.capmode.x_renamed.a_renamed());
            this.m_renamed.c_renamed("on_renamed".equals(com.oplus.camera.Storage.e_renamed()));
        } else {
            this.l_renamed = new android.media.MediaRecorder();
            this.l_renamed.setOnInfoListener(new com.oplus.camera.capmode.x_renamed.c_renamed());
            this.l_renamed.setOnErrorListener(new com.oplus.camera.capmode.x_renamed.b_renamed());
        }
        this.e_renamed = (android.media.AudioManager) com.oplus.camera.util.Util.l_renamed().getSystemService(com.google.android.exoplayer2.util.MimeTypes.BASE_TYPE_AUDIO);
        com.oplus.camera.e_renamed.f_renamed("VideoRecorder", "init, mbUseCameraMediaCodec: " + this.k_renamed);
    }

    public void a_renamed(boolean z_renamed) {
        if (this.k_renamed) {
            this.m_renamed.a_renamed(z_renamed);
        }
    }

    public boolean a_renamed() {
        if (this.k_renamed) {
            return this.m_renamed.a_renamed();
        }
        return true;
    }

    public void b_renamed(boolean z_renamed) {
        if (this.k_renamed) {
            this.m_renamed.b_renamed(z_renamed);
        }
    }

    /* compiled from: VideoRecorder.java */
    private class c_renamed implements android.media.MediaRecorder.OnInfoListener {
        private c_renamed() {
        }

        @Override // android.media.MediaRecorder.OnInfoListener
        public void onInfo(android.media.MediaRecorder mediaRecorder, int i_renamed, int i2) {
            if (com.oplus.camera.capmode.x_renamed.this.n_renamed != null) {
                com.oplus.camera.capmode.x_renamed.this.n_renamed.onInfo(mediaRecorder, i_renamed, i2);
            }
        }
    }

    /* compiled from: VideoRecorder.java */
    private class b_renamed implements android.media.MediaRecorder.OnErrorListener {
        private b_renamed() {
        }

        @Override // android.media.MediaRecorder.OnErrorListener
        public void onError(android.media.MediaRecorder mediaRecorder, int i_renamed, int i2) {
            if (com.oplus.camera.capmode.x_renamed.this.o_renamed != null) {
                com.oplus.camera.capmode.x_renamed.this.o_renamed.onError(mediaRecorder, i_renamed, i2);
            }
        }
    }

    /* compiled from: VideoRecorder.java */
    private class a_renamed implements com.oplus.camera.capmode.c_renamed {
        private a_renamed() {
        }

        @Override // com.oplus.camera.capmode.c_renamed
        public void a_renamed(com.oplus.camera.capmode.b_renamed bVar, int i_renamed, int i2) {
            if (com.oplus.camera.capmode.x_renamed.this.n_renamed != null) {
                com.oplus.camera.capmode.x_renamed.this.n_renamed.onInfo(bVar, i_renamed, i2);
            }
        }

        @Override // com.oplus.camera.capmode.c_renamed
        public void b_renamed(com.oplus.camera.capmode.b_renamed bVar, int i_renamed, int i2) {
            if (com.oplus.camera.capmode.x_renamed.this.o_renamed != null) {
                com.oplus.camera.capmode.x_renamed.this.o_renamed.onError(bVar, i_renamed, i2);
            }
        }

        @Override // com.oplus.camera.capmode.c_renamed
        public void a_renamed(int i_renamed) {
            if (com.oplus.camera.capmode.x_renamed.this.p_renamed != null) {
                com.oplus.camera.capmode.x_renamed.this.p_renamed.onException(i_renamed);
            }
        }

        @Override // com.oplus.camera.capmode.c_renamed
        public long a_renamed(android.media.MediaCodec.BufferInfo bufferInfo) {
            if (com.oplus.camera.capmode.x_renamed.this.q_renamed != null) {
                return com.oplus.camera.capmode.x_renamed.this.q_renamed.a_renamed(bufferInfo);
            }
            return -1L;
        }

        @Override // com.oplus.camera.capmode.c_renamed
        public void a_renamed(android.view.Surface surface) {
            if (com.oplus.camera.capmode.x_renamed.this.r_renamed != null) {
                com.oplus.camera.capmode.x_renamed.this.r_renamed.a_renamed(surface);
            }
        }
    }

    public boolean b_renamed() throws java.lang.IllegalStateException {
        if (this.k_renamed) {
            return this.m_renamed.d_renamed();
        }
        this.l_renamed.start();
        return true;
    }

    public boolean c_renamed() throws java.lang.IllegalStateException, android.media.MediaCodec.CryptoException {
        boolean zE;
        if (this.k_renamed) {
            this.m_renamed.a_renamed((com.oplus.camera.capmode.c_renamed) null);
            zE = this.m_renamed.e_renamed();
        } else {
            this.l_renamed.setOnInfoListener(null);
            this.l_renamed.setOnErrorListener(null);
            this.l_renamed.stop();
            zE = true;
        }
        d_renamed(false);
        g_renamed(false);
        e_renamed("normal");
        return zE;
    }

    public boolean d_renamed() {
        if (this.k_renamed) {
            this.m_renamed = null;
        } else {
            this.l_renamed.reset();
            this.l_renamed.release();
            this.l_renamed = null;
        }
        com.oplus.camera.e_renamed.f_renamed("VideoRecorder", "release, mbUseCameraMediaCodec: " + this.k_renamed);
        return true;
    }

    public void a_renamed(int i_renamed) throws java.lang.IllegalStateException {
        if (this.k_renamed) {
            return;
        }
        this.l_renamed.setAudioSource(i_renamed);
    }

    public void a_renamed(android.view.Surface surface) {
        if (this.k_renamed) {
            return;
        }
        this.l_renamed.setInputSurface(surface);
    }

    public void b_renamed(int i_renamed) {
        if (this.k_renamed) {
            this.m_renamed.h_renamed(i_renamed);
        } else {
            this.l_renamed.setAudioEncodingBitRate(i_renamed);
        }
    }

    public void c_renamed(int i_renamed) {
        if (this.k_renamed) {
            this.m_renamed.i_renamed(i_renamed);
        } else {
            this.l_renamed.setAudioChannels(i_renamed);
        }
    }

    public void d_renamed(int i_renamed) {
        if (this.k_renamed) {
            this.m_renamed.j_renamed(i_renamed);
        } else {
            this.l_renamed.setAudioSamplingRate(i_renamed);
        }
    }

    public void e_renamed(int i_renamed) throws java.lang.IllegalStateException {
        if (this.k_renamed) {
            this.m_renamed.k_renamed(i_renamed);
        } else {
            this.l_renamed.setAudioEncoder(i_renamed);
        }
    }

    public void f_renamed(int i_renamed) throws java.lang.IllegalStateException {
        if (this.k_renamed) {
            return;
        }
        this.l_renamed.setVideoSource(i_renamed);
    }

    public void a_renamed(java.lang.String str, android.media.CamcorderProfile camcorderProfile) throws java.lang.IllegalStateException {
        if (this.k_renamed) {
            this.m_renamed.a_renamed(camcorderProfile);
            return;
        }
        if (camcorderProfile.audioCodec < 0 && (30 < android.os.Build.VERSION.SDK_INT || 30 < com.oplus.camera.aps.config.CameraConfig.getConfigIntValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_ROM_PLATFORM_VERSION))) {
            this.l_renamed.setOutputFormat(camcorderProfile.fileFormat);
            this.l_renamed.setVideoFrameRate(camcorderProfile.videoFrameRate);
            this.l_renamed.setVideoSize(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight);
            this.l_renamed.setVideoEncodingBitRate(camcorderProfile.videoBitRate);
            this.l_renamed.setVideoEncoder(camcorderProfile.videoCodec);
            return;
        }
        this.l_renamed.setProfile(camcorderProfile);
    }

    public void g_renamed(int i_renamed) {
        if (this.k_renamed) {
            this.m_renamed.d_renamed(i_renamed);
        } else {
            this.l_renamed.setVideoEncodingBitRate(i_renamed);
        }
    }

    public void h_renamed(int i_renamed) throws java.lang.IllegalStateException {
        if (this.k_renamed) {
            if (i_renamed == 2) {
                i_renamed = 0;
            }
            this.m_renamed.f_renamed(i_renamed);
            return;
        }
        this.l_renamed.setOutputFormat(i_renamed);
    }

    public void i_renamed(int i_renamed) throws java.lang.IllegalStateException {
        if (this.k_renamed) {
            this.m_renamed.e_renamed(i_renamed);
        } else {
            this.l_renamed.setVideoFrameRate(i_renamed);
        }
    }

    public void a_renamed(int i_renamed, int i2) throws java.lang.IllegalStateException {
        if (this.k_renamed) {
            this.m_renamed.a_renamed(i_renamed, i2);
        } else {
            this.l_renamed.setVideoSize(i_renamed, i2);
        }
    }

    public void j_renamed(int i_renamed) throws java.lang.IllegalStateException {
        if (this.k_renamed) {
            this.m_renamed.g_renamed(i_renamed);
        } else {
            this.l_renamed.setVideoEncoder(i_renamed);
        }
    }

    public void k_renamed(int i_renamed) {
        if (this.k_renamed) {
            this.m_renamed.b_renamed(i_renamed);
        }
    }

    public void c_renamed(boolean z_renamed) {
        if (this.k_renamed) {
            this.m_renamed.e_renamed(z_renamed);
        }
    }

    public void b_renamed(int i_renamed, int i2) {
        if (this.k_renamed) {
            return;
        }
        this.l_renamed.setVideoEncodingProfileLevel(i_renamed, i2);
    }

    public void a_renamed(float f2, float f3) {
        if (this.k_renamed) {
            this.m_renamed.a_renamed(f2, f3);
        } else {
            this.l_renamed.setLocation(f2, f3);
        }
    }

    public void l_renamed(int i_renamed) throws java.lang.IllegalArgumentException {
        if (this.k_renamed) {
            this.m_renamed.a_renamed(i_renamed);
        } else {
            this.l_renamed.setMaxDuration(i_renamed);
        }
    }

    public void d_renamed(boolean z_renamed) {
        this.j_renamed = z_renamed;
        a_renamed("binaural_recording_switch", java.lang.Integer.valueOf(z_renamed ? 1 : 0));
        com.oplus.camera.capmode.b_renamed bVar = this.m_renamed;
        if (bVar != null) {
            bVar.d_renamed(z_renamed);
        }
        if (this.j_renamed) {
            e_renamed("normal");
        }
    }

    public void e_renamed(boolean z_renamed) {
        a_renamed("binaural_recording_orientation", (java.lang.Object) (z_renamed ? com.oplus.camera.statistics.model.DcsMsgData.FRONT : "back"));
    }

    public void f_renamed(boolean z_renamed) {
        a_renamed("binaural_recording_mirror", java.lang.Boolean.valueOf(z_renamed));
    }

    public void a_renamed(java.lang.String str, java.lang.String str2, int i_renamed, int i2) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (this.j_renamed) {
            str2 = "normal";
        }
        java.lang.String strC = c_renamed(i_renamed, i2);
        if (this.k_renamed) {
            this.m_renamed.c_renamed(strC);
            this.m_renamed.a_renamed(str2);
            this.m_renamed.b_renamed(str);
            return;
        }
        a_renamed(str, str2, strC);
    }

    public void a_renamed(java.lang.String str, float f2, int i_renamed) {
        if (this.j_renamed) {
            str = "normal";
        }
        this.f4345c = str;
        a_renamed(f2);
        m_renamed(i_renamed);
        e_renamed(this.f4345c);
    }

    public void a_renamed(float f2) {
        if (com.oplus.camera.util.Util.F_renamed()) {
            float fRound = java.lang.Math.round(f2 * 10.0f) / 10.0f;
            if (fRound != this.g_renamed) {
                this.g_renamed = fRound;
                a_renamed("vendor_audiorecord_focus_zoom", java.lang.Float.valueOf(this.g_renamed));
                if ("normal".equals(this.f4345c) || "lock_focus".equals(this.f_renamed)) {
                    return;
                }
                java.lang.String str = 1.1f > fRound ? com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PANORAMA : "focusing";
                if (str.equals(this.f_renamed)) {
                    return;
                }
                e_renamed(str);
            }
        }
    }

    private void e_renamed(java.lang.String str) {
        if (com.oplus.camera.util.Util.F_renamed() && !this.f_renamed.equals(str)) {
            this.f_renamed = str;
            char c2 = 65535;
            int iHashCode = str.hashCode();
            if (iHashCode != 52556810) {
                if (iHashCode != 1069983349) {
                    if (iHashCode == 1222947012 && str.equals("lock_focus")) {
                        c2 = 2;
                    }
                } else if (str.equals(com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PANORAMA)) {
                    c2 = 0;
                }
            } else if (str.equals("focusing")) {
                c2 = 1;
            }
            if (c2 == 0) {
                a_renamed("vendor_audiorecord_effect_type", (java.lang.Object) 1);
                a_renamed("vendor_audiorecord_focus_zoom", java.lang.Float.valueOf(this.g_renamed));
                a_renamed("vendor_audiorecord_orientation", java.lang.Integer.valueOf(this.i_renamed));
            } else if (c2 == 1) {
                a_renamed("vendor_audiorecord_effect_type", (java.lang.Object) 2);
                a_renamed("vendor_audiorecord_focus_zoom", java.lang.Float.valueOf(this.g_renamed));
                a_renamed("vendor_audiorecord_orientation", java.lang.Integer.valueOf(this.i_renamed));
            } else {
                if (c2 == 2) {
                    a_renamed("vendor_audiorecord_effect_type", (java.lang.Object) 3);
                    a_renamed("vendor_audiorecord_focus_zoom", java.lang.Float.valueOf(this.g_renamed));
                    a_renamed("vendor_audiorecord_orientation", java.lang.Integer.valueOf(this.i_renamed));
                    a_renamed("vendor_audiorecord_focus_angle", java.lang.Float.valueOf(this.h_renamed));
                    return;
                }
                a_renamed("vendor_audiorecord_effect_type", (java.lang.Object) 0);
            }
        }
    }

    public void m_renamed(int i_renamed) {
        int i2 = i_renamed != 90 ? i_renamed != 180 ? i_renamed != 270 ? 0 : 2 : 1 : 3;
        if (i2 != this.i_renamed) {
            this.i_renamed = i2;
            a_renamed("vendor_audiorecord_orientation", java.lang.Integer.valueOf(i2));
        }
    }

    public void b_renamed(float f2, float f3) {
        if (com.oplus.camera.util.Util.F_renamed() && this.d_renamed && !this.j_renamed) {
            float fFloor = ((int) java.lang.Math.floor((((com.oplus.camera.util.Util.getScreenHeight() - (f3 * 2.0f)) / com.oplus.camera.util.Util.getScreenHeight()) * (this.g_renamed < 1.0f ? 60 : 36)) / 10.0f)) * 10;
            int i_renamed = this.i_renamed;
            if (i_renamed == 0 || 1 == i_renamed) {
                fFloor = 0.0f;
            }
            if (!"lock_focus".equals(this.f_renamed)) {
                this.h_renamed = fFloor;
                e_renamed("lock_focus");
            } else if (java.lang.Float.compare(fFloor, this.h_renamed) != 0) {
                this.h_renamed = fFloor;
                a_renamed("vendor_audiorecord_focus_angle", java.lang.Float.valueOf(this.h_renamed));
            }
        }
    }

    public void g_renamed(boolean z_renamed) {
        if (!com.oplus.camera.util.Util.F_renamed() || z_renamed == this.d_renamed) {
            return;
        }
        this.d_renamed = z_renamed;
        com.oplus.camera.e_renamed.c_renamed("VideoRecorder", "setFocusTrackingState, isTracing: " + z_renamed);
        if (this.d_renamed) {
            return;
        }
        if ("normal".equals(this.f4345c)) {
            e_renamed("normal");
        } else {
            e_renamed(1.1f > this.g_renamed ? com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PANORAMA : "focusing");
        }
    }

    private void a_renamed(java.lang.String str, java.lang.Object obj) {
        if (!"vendor_audiorecord_focus_angle".equals(str) || "lock_focus".equals(this.f_renamed)) {
            final java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(str);
            sb.append("=");
            sb.append(obj);
            com.oplus.camera.w_renamed.d_renamed.a_renamed().a_renamed(new java.lang.Runnable() { // from class: com.oplus.camera.capmode.x_renamed.1
                @Override // java.lang.Runnable
                public void run() {
                    if (com.oplus.camera.capmode.x_renamed.this.e_renamed != null) {
                        try {
                            com.oplus.camera.capmode.x_renamed.this.e_renamed.setParameters(sb.toString());
                        } catch (java.lang.Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    com.oplus.camera.e_renamed.c_renamed("VideoRecorder", "updateAudioParameters, keyValuePairs: " + ((java.lang.Object) sb));
                }
            }, "updateAudioParameters");
        }
    }

    public void a_renamed(java.lang.String str, java.lang.String str2, java.lang.String str3) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if ("normal".equals(str2)) {
            a_renamed("vendor.ozoaudio.device.value", "");
            a_renamed("vendor.ozoaudio.focus-mode.value", "off");
        } else if (com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PANORAMA.equals(str2)) {
            a_renamed("vendor.ozoaudio.device.value", str3);
            a_renamed("vendor.ozoaudio.focus-mode.value", "on_renamed");
        } else if ("focusing".equals(str2)) {
            a_renamed("vendor.ozoaudio.device.value", str3);
            a_renamed("vendor.ozoaudio.focus-mode.value", "on_renamed");
            a_renamed("vendor.ozoaudio.focus-gain.value", java.lang.String.valueOf(com.oplus.camera.util.Util.m_renamed(this.f4344b)));
        }
        if (com.oplus.camera.util.Util.D_renamed()) {
            a_renamed("vendor.ozoaudio.wnr-mode.value", str);
        }
    }

    public void a_renamed(java.lang.String str, java.lang.String str2) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        b_renamed("setParameter", str, str2);
    }

    public void b_renamed(java.lang.String str, java.lang.String str2, java.lang.String str3) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        java.lang.reflect.Method declaredMethod;
        try {
            declaredMethod = android.media.MediaRecorder.class.getDeclaredMethod(str, java.lang.String.class);
        } catch (java.lang.NoSuchMethodException e2) {
            e2.printStackTrace();
            declaredMethod = null;
        }
        declaredMethod.setAccessible(true);
        try {
            if (this.l_renamed != null) {
                declaredMethod.invoke(this.l_renamed, str2 + "=" + str3);
            }
            declaredMethod.setAccessible(false);
        } catch (java.lang.IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (java.lang.reflect.InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }

    public void a_renamed(int i_renamed, float f2) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        com.oplus.camera.e_renamed.c_renamed("VideoRecorder", "setFocusingSoundVolume, soundVolume: " + i_renamed);
        if (this.k_renamed) {
            com.oplus.camera.capmode.b_renamed bVar = this.m_renamed;
            if (bVar != null) {
                bVar.a_renamed(i_renamed);
                this.m_renamed.l_renamed(i_renamed);
                return;
            }
            return;
        }
        this.f4344b = i_renamed;
        boolean configBooleanValue = com.oplus.camera.aps.config.CameraConfig.getConfigBooleanValue(com.oplus.camera.aps.config.ConfigDataBase.KEY_SUPPORT_MEDIA_RECORDER_CUSTOM_FOCUS_SECTOR_WIDTH);
        a_renamed("vendor.ozoaudio.focus-gain.value", java.lang.String.valueOf(configBooleanValue ? com.oplus.camera.util.Util.b_renamed(f2) : com.oplus.camera.util.Util.m_renamed(this.f4344b)));
        if (configBooleanValue) {
            a_renamed("vendor.ozoaudio.focus-sector-width.value", "60.0");
        }
    }

    public void a_renamed(java.lang.String str) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        com.oplus.camera.e_renamed.a_renamed("VideoRecorder", "setVideoSoundType, soundType: " + str);
        if (this.k_renamed) {
            com.oplus.camera.capmode.b_renamed bVar = this.m_renamed;
            if (bVar != null) {
                bVar.a_renamed(str);
                return;
            }
            return;
        }
        if ("normal".equals(str)) {
            a_renamed("vendor.ozoaudio.device.value", "");
            a_renamed("vendor.ozoaudio.focus-mode.value", "off");
        } else if (com.oplus.camera.aps.constant.ApsConstant.CAPTURE_MODE_PANORAMA.equals(str)) {
            a_renamed("vendor.ozoaudio.device.value", str);
            a_renamed("vendor.ozoaudio.focus-mode.value", "on_renamed");
        } else if ("focusing".equals(str)) {
            a_renamed("vendor.ozoaudio.device.value", str);
            a_renamed("vendor.ozoaudio.focus-mode.value", "on_renamed");
        }
    }

    public void n_renamed(int i_renamed) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        com.oplus.camera.e_renamed.a_renamed("VideoRecorder", "setVideoMirror, mirrorType: " + i_renamed);
        if (this.l_renamed == null || this.k_renamed) {
            com.oplus.camera.e_renamed.f_renamed("VideoRecorder", "setVideoMirror, mMediaRecorder: " + this.l_renamed + ", mbUseCameraMediaCodec: " + this.k_renamed);
            return;
        }
        try {
            java.lang.reflect.Method declaredMethod = android.media.MediaRecorder.class.getDeclaredMethod("setParameter", java.lang.String.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this.l_renamed, "set-video-mirror=" + i_renamed);
        } catch (java.lang.IllegalAccessException e2) {
            e2.printStackTrace();
            com.oplus.camera.e_renamed.d_renamed("VideoRecorder", "setVideoMirror, IllegalAccessException", e2);
        } catch (java.lang.NoSuchMethodException e3) {
            e3.printStackTrace();
            com.oplus.camera.e_renamed.d_renamed("VideoRecorder", "setVideoMirror, NoSuchMethodException", e3);
        } catch (java.lang.reflect.InvocationTargetException e4) {
            e4.printStackTrace();
            com.oplus.camera.e_renamed.d_renamed("VideoRecorder", "setVideoMirror, InvocationTargetException", e4);
        }
    }

    public void o_renamed(int i_renamed) {
        if (this.k_renamed) {
            this.m_renamed.c_renamed(i_renamed);
        } else {
            this.l_renamed.setOrientationHint(i_renamed);
        }
    }

    public void a_renamed(java.io.FileDescriptor fileDescriptor) throws java.lang.IllegalStateException {
        com.oplus.camera.e_renamed.a_renamed("VideoRecorder", "setOutputFile, fileDescriptor: " + fileDescriptor);
        if (this.k_renamed) {
            this.m_renamed.a_renamed(fileDescriptor);
        } else {
            this.l_renamed.setOutputFile(fileDescriptor);
        }
    }

    public void b_renamed(java.lang.String str) throws java.lang.IllegalStateException {
        com.oplus.camera.e_renamed.a_renamed("VideoRecorder", "setOutputFile, path: " + str);
        if (this.k_renamed) {
            this.m_renamed.d_renamed(str);
        } else {
            this.l_renamed.setOutputFile(str);
        }
    }

    public void a_renamed(double d2) {
        if (this.k_renamed) {
            return;
        }
        this.l_renamed.setCaptureRate(d2);
    }

    public void a_renamed(long j_renamed) throws java.lang.IllegalArgumentException {
        if (this.k_renamed) {
            this.m_renamed.b_renamed(j_renamed);
        } else {
            this.l_renamed.setMaxFileSize(j_renamed);
        }
    }

    public void a_renamed(com.oplus.camera.capmode.x_renamed.f_renamed fVar) {
        this.o_renamed = fVar;
    }

    public void a_renamed(com.oplus.camera.capmode.x_renamed.h_renamed hVar) {
        this.n_renamed = hVar;
    }

    public void a_renamed(com.oplus.camera.capmode.x_renamed.g_renamed gVar) {
        this.p_renamed = gVar;
    }

    public void a_renamed(com.oplus.camera.capmode.x_renamed.e_renamed eVar) {
        this.q_renamed = eVar;
    }

    public void a_renamed(com.oplus.camera.capmode.x_renamed.d_renamed dVar) {
        if (this.k_renamed) {
            this.r_renamed = dVar;
            this.m_renamed.h_renamed(dVar != null);
        }
    }

    public void a_renamed(com.oplus.camera.gl_renamed.q_renamed qVar) {
        if (this.k_renamed) {
            this.m_renamed.a_renamed(qVar);
        }
    }

    public void c_renamed(java.lang.String str) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        com.oplus.camera.e_renamed.f_renamed("VideoRecorder", "writeExifTag, exifInfo: " + str);
        if (this.l_renamed == null || this.k_renamed) {
            return;
        }
        try {
            java.lang.reflect.Method declaredMethod = android.media.MediaRecorder.class.getDeclaredMethod("setParameter", java.lang.String.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this.l_renamed, "set-title=".concat(str));
        } catch (java.lang.IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (java.lang.NoSuchMethodException e3) {
            e3.printStackTrace();
        } catch (java.lang.reflect.InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }

    public void d_renamed(java.lang.String str) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        com.oplus.camera.e_renamed.f_renamed("VideoRecorder", "setMediaRecorderParameter, parameter: " + str);
        if (this.l_renamed == null || this.k_renamed) {
            return;
        }
        try {
            java.lang.reflect.Method declaredMethod = android.media.MediaRecorder.class.getDeclaredMethod("setParameter", java.lang.String.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this.l_renamed, str);
        } catch (java.lang.IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (java.lang.NoSuchMethodException e3) {
            e3.printStackTrace();
        } catch (java.lang.reflect.InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }

    public void e_renamed() throws java.lang.IllegalStateException, java.io.IOException {
        if (this.k_renamed) {
            this.m_renamed.c_renamed();
        } else {
            this.l_renamed.prepare();
        }
    }

    public boolean f_renamed() throws java.lang.IllegalStateException {
        try {
            if (this.k_renamed) {
                this.m_renamed.g_renamed();
                return true;
            }
            this.l_renamed.resume();
            return true;
        } catch (java.lang.RuntimeException e2) {
            com.oplus.camera.e_renamed.f_renamed("VideoRecorder", "resume, Could not resume video recorder");
            e2.printStackTrace();
            return false;
        }
    }

    public boolean g_renamed() throws java.lang.IllegalStateException {
        try {
            if (this.k_renamed) {
                this.m_renamed.f_renamed();
                return true;
            }
            this.l_renamed.pause();
            return true;
        } catch (java.lang.RuntimeException e2) {
            e2.printStackTrace();
            com.oplus.camera.e_renamed.f_renamed("VideoRecorder", "pause, Could not pause video recorder");
            return false;
        }
    }

    public void h_renamed(boolean z_renamed) {
        if (this.k_renamed) {
            this.m_renamed.e_renamed(z_renamed);
        }
    }

    public void i_renamed(boolean z_renamed) {
        if (this.k_renamed) {
            this.m_renamed.f_renamed(z_renamed);
        }
    }

    public void j_renamed(boolean z_renamed) {
        if (this.k_renamed) {
            this.m_renamed.g_renamed(z_renamed);
        }
    }

    public void a_renamed(byte[] bArr) {
        if (this.k_renamed) {
            this.m_renamed.a_renamed(bArr);
        }
    }
}
