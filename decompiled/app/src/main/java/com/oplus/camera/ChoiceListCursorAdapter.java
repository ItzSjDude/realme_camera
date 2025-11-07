package com.oplus.camera;

/* compiled from: OplusPlaySound.java */
/* loaded from: classes2.dex */
public class w_renamed implements android.media.SoundPool.OnLoadCompleteListener {

    /* renamed from: a_renamed, reason: collision with root package name */
    private android.media.SoundPool f7383a;

    /* renamed from: b_renamed, reason: collision with root package name */
    private android.content.Context f7384b;
    private android.media.AudioManager e_renamed;
    private boolean f_renamed;
    private android.os.HandlerThread g_renamed;
    private android.os.Handler h_renamed;
    private com.oplus.camera.w_renamed.a_renamed j_renamed;

    /* renamed from: c_renamed, reason: collision with root package name */
    private java.util.HashMap<java.lang.Integer, java.lang.Integer> f7385c = null;
    private java.util.HashMap<java.lang.Integer, java.lang.Boolean> d_renamed = new java.util.HashMap<>();
    private int i_renamed = -1;
    private boolean k_renamed = true;

    public w_renamed(android.content.Context context) {
        this.f_renamed = false;
        this.j_renamed = null;
        this.f_renamed = com.oplus.camera.l_renamed.a_renamed.c_renamed();
        if (this.f_renamed) {
            this.f7383a = new android.media.SoundPool(10, com.oplus.compat.media.a_renamed.f7465a, 1);
        } else {
            this.f7383a = new android.media.SoundPool(10, 1, 1);
        }
        this.f7383a.setOnLoadCompleteListener(this);
        this.j_renamed = new com.oplus.camera.w_renamed.a_renamed();
        this.f7384b = context;
        this.e_renamed = (android.media.AudioManager) this.f7384b.getSystemService(com.google.android.exoplayer2.util.MimeTypes.BASE_TYPE_AUDIO);
        this.g_renamed = new android.os.HandlerThread("OplusPlaySound Thread");
        this.g_renamed.start();
        this.h_renamed = new android.os.Handler(this.g_renamed.getLooper()) { // from class: com.oplus.camera.w_renamed.1
            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                int i_renamed = message.what;
                if (i_renamed == 1) {
                    int i2 = message.arg1;
                    if (com.oplus.camera.w_renamed.this.f_renamed) {
                        if (com.oplus.camera.w_renamed.this.f7385c == null || com.oplus.camera.w_renamed.this.f7383a == null) {
                            return;
                        }
                        com.oplus.camera.w_renamed.this.f7383a.play(((java.lang.Integer) com.oplus.camera.w_renamed.this.f7385c.get(java.lang.Integer.valueOf(i2))).intValue(), 1.0f, 1.0f, 0, 0, 1.0f);
                        return;
                    }
                    if (com.oplus.camera.w_renamed.this.g_renamed() != 2 || com.oplus.camera.w_renamed.this.f7385c == null || com.oplus.camera.w_renamed.this.f7383a == null) {
                        return;
                    }
                    com.oplus.camera.w_renamed.this.f7383a.play(((java.lang.Integer) com.oplus.camera.w_renamed.this.f7385c.get(java.lang.Integer.valueOf(i2))).intValue(), 1.0f, 1.0f, 0, 0, 1.0f);
                    return;
                }
                if (i_renamed != 2) {
                    return;
                }
                int i3 = message.arg1;
                try {
                    com.oplus.camera.w_renamed.this.k_renamed = false;
                    long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                    com.oplus.compat.media.a_renamed.a_renamed(i3);
                    com.oplus.camera.w_renamed.this.k_renamed = true;
                    com.oplus.camera.e_renamed.b_renamed("OplusPlaySound", "setRingerModeInternal, ringerMode: " + i3 + ", take " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis) + " ms.");
                } catch (java.lang.Exception e_renamed) {
                    e_renamed.printStackTrace();
                }
            }
        };
    }

    public void a_renamed() {
        if (this.f7385c == null) {
            this.f7385c = new java.util.HashMap<>();
            if (com.oplus.camera.util.Util.ao_renamed()) {
                this.f7385c.put(0, java.lang.Integer.valueOf(this.f7383a.load(this.f7384b, com.oplus.camera.R_renamed.raw.camera_moon_shutter, 0)));
                this.f7385c.put(3, java.lang.Integer.valueOf(this.f7383a.load(this.f7384b, com.oplus.camera.R_renamed.raw.camera_moon_time_snapshot, 0)));
                this.f7385c.put(1, java.lang.Integer.valueOf(this.f7383a.load(this.f7384b, com.oplus.camera.R_renamed.raw.camera_moon_burst_shutter, 0)));
                this.f7385c.put(2, java.lang.Integer.valueOf(this.f7383a.load(this.f7384b, com.oplus.camera.R_renamed.raw.camera_moon_burst_shutter_end, 0)));
                this.f7385c.put(6, java.lang.Integer.valueOf(this.f7383a.load(this.f7384b, com.oplus.camera.R_renamed.raw.camera_moon_long_exposure_start, 0)));
                this.f7385c.put(7, java.lang.Integer.valueOf(this.f7383a.load(this.f7384b, com.oplus.camera.R_renamed.raw.camera_moon_long_exposure_end, 0)));
            } else {
                this.f7385c.put(0, java.lang.Integer.valueOf(this.f7383a.load(this.f7384b, com.oplus.camera.R_renamed.raw.camera_shutter, 0)));
                this.f7385c.put(3, java.lang.Integer.valueOf(this.f7383a.load(this.f7384b, com.oplus.camera.R_renamed.raw.camera_time_snapshot, 0)));
                this.f7385c.put(1, java.lang.Integer.valueOf(this.f7383a.load(this.f7384b, com.oplus.camera.R_renamed.raw.camera_burst_shutter, 0)));
                this.f7385c.put(2, java.lang.Integer.valueOf(this.f7383a.load(this.f7384b, com.oplus.camera.R_renamed.raw.camera_burst_shutter_end, 0)));
            }
            if (this.f_renamed) {
                this.f7385c.put(4, java.lang.Integer.valueOf(this.f7383a.load(this.f7384b, com.oplus.camera.R_renamed.raw.camera_video_start_jp, 0)));
                this.f7385c.put(5, java.lang.Integer.valueOf(this.f7383a.load(this.f7384b, com.oplus.camera.R_renamed.raw.camera_video_stop_jp, 0)));
            } else if (com.oplus.camera.util.Util.ao_renamed()) {
                this.f7385c.put(4, java.lang.Integer.valueOf(this.f7383a.load(this.f7384b, com.oplus.camera.R_renamed.raw.camera_moon_video_start, 0)));
                this.f7385c.put(5, java.lang.Integer.valueOf(this.f7383a.load(this.f7384b, com.oplus.camera.R_renamed.raw.camera_moon_video_stop, 0)));
            } else {
                this.f7385c.put(4, java.lang.Integer.valueOf(this.f7383a.load(this.f7384b, com.oplus.camera.R_renamed.raw.camera_video_start, 0)));
                this.f7385c.put(5, java.lang.Integer.valueOf(this.f7383a.load(this.f7384b, com.oplus.camera.R_renamed.raw.camera_video_stop, 0)));
            }
            this.j_renamed.a_renamed(4, 5);
        }
    }

    @Override // android.media.SoundPool.OnLoadCompleteListener
    public void onLoadComplete(android.media.SoundPool soundPool, int i_renamed, int i2) {
        if (i2 != 0) {
            com.oplus.camera.e_renamed.f_renamed("OplusPlaySound", "onLoadComplete, load sound fail for soundId: " + i_renamed + ", status: " + i2);
        }
        java.util.HashMap<java.lang.Integer, java.lang.Integer> map = this.f7385c;
        if (map == null || map.entrySet() == null) {
            return;
        }
        for (java.util.Map.Entry<java.lang.Integer, java.lang.Integer> entry : this.f7385c.entrySet()) {
            if (i_renamed == entry.getValue().intValue()) {
                this.d_renamed.put(entry.getKey(), true);
            }
        }
    }

    public boolean a_renamed(int i_renamed) {
        return com.oplus.camera.util.Util.b_renamed(this.d_renamed) && this.d_renamed.containsKey(java.lang.Integer.valueOf(i_renamed)) && this.d_renamed.get(java.lang.Integer.valueOf(i_renamed)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g_renamed() {
        android.media.AudioManager audioManager = this.e_renamed;
        if (audioManager != null) {
            return audioManager.getRingerMode();
        }
        return 2;
    }

    public void b_renamed() {
        android.media.AudioManager audioManager = this.e_renamed;
        if (audioManager != null) {
            this.i_renamed = audioManager.getRingerMode();
        }
    }

    public boolean c_renamed() {
        return this.k_renamed;
    }

    public void d_renamed() {
        com.oplus.camera.e_renamed.b_renamed("OplusPlaySound", "setAudioSilent, mRestoreRingMode: " + this.i_renamed);
        if (this.e_renamed != null) {
            int i_renamed = this.i_renamed;
            if (2 == i_renamed || 1 == i_renamed) {
                this.h_renamed.removeMessages(2);
                this.h_renamed.obtainMessage(2, 0, 0).sendToTarget();
            }
        }
    }

    public void e_renamed() {
        com.oplus.camera.e_renamed.b_renamed("OplusPlaySound", "restoreAudioMode, mRestoreRingMode: " + this.i_renamed);
        if (this.e_renamed != null && 2 == this.i_renamed) {
            this.h_renamed.removeMessages(2);
            this.h_renamed.obtainMessage(2, 2, 0).sendToTarget();
        } else {
            if (this.e_renamed == null || 1 != this.i_renamed) {
                return;
            }
            this.h_renamed.removeMessages(2);
            this.h_renamed.obtainMessage(2, 1, 0).sendToTarget();
        }
    }

    public void b_renamed(int i_renamed) {
        if (this.j_renamed.a_renamed(i_renamed)) {
            this.h_renamed.removeCallbacksAndMessages(null);
            this.h_renamed.obtainMessage(1, i_renamed, 0).sendToTarget();
        }
    }

    public void f_renamed() {
        android.os.HandlerThread handlerThread = this.g_renamed;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.g_renamed = null;
        }
        android.os.Handler handler = this.h_renamed;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.h_renamed = null;
        }
        java.util.HashMap<java.lang.Integer, java.lang.Integer> map = this.f7385c;
        if (map != null) {
            map.clear();
            this.f7385c = null;
        }
        android.media.SoundPool soundPool = this.f7383a;
        if (soundPool != null) {
            soundPool.setOnLoadCompleteListener(null);
            this.f7383a.release();
            this.f7383a = null;
        }
        this.d_renamed.clear();
        this.e_renamed = null;
    }

    /* compiled from: OplusPlaySound.java */
    public static class a_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        private java.util.List<com.oplus.camera.w_renamed.b_renamed> f7387a = new java.util.ArrayList();

        public boolean a_renamed(int i_renamed) {
            for (com.oplus.camera.w_renamed.b_renamed bVar : this.f7387a) {
                if (i_renamed == bVar.f7391a) {
                    bVar.f7393c = true;
                } else if (i_renamed != bVar.f7392b) {
                    continue;
                } else {
                    if (!bVar.f7393c) {
                        return false;
                    }
                    bVar.f7393c = false;
                }
            }
            return true;
        }

        public void a_renamed(int i_renamed, int i2) {
            this.f7387a.add(new com.oplus.camera.w_renamed.b_renamed(i_renamed, i2));
        }
    }

    /* compiled from: OplusPlaySound.java */
    public static class b_renamed {

        /* renamed from: a_renamed, reason: collision with root package name */
        public int f7391a;

        /* renamed from: b_renamed, reason: collision with root package name */
        public int f7392b;

        /* renamed from: c_renamed, reason: collision with root package name */
        public boolean f7393c = false;

        public b_renamed(int i_renamed, int i2) {
            this.f7391a = 0;
            this.f7392b = 0;
            this.f7391a = i_renamed;
            this.f7392b = i2;
        }
    }
}
