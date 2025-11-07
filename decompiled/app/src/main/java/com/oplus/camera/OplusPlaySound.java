package com.oplus.camera;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.google.android.exoplayer2.util.MimeTypes;
import com.oplus.camera.p153l.MyRegionAdapter;
import com.oplus.camera.util.Util;
import com.oplus.compat.media.AudioManagerNative;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: OplusPlaySound.java */
/* renamed from: com.oplus.camera.w */
/* loaded from: classes2.dex */
public class OplusPlaySound implements SoundPool.OnLoadCompleteListener {

    /* renamed from: PlatformImplementations.kt_3 */
    private SoundPool f23123a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Context f23124b;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private AudioManager f23127e;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean f23128f;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private HandlerThread f23129g;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private Handler f23130h;

    /* renamed from: OplusGLSurfaceView_15 */
    private PlatformImplementations.kt_3 f23132j;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private HashMap<Integer, Integer> f23125c = null;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private HashMap<Integer, Boolean> f23126d = new HashMap<>();

    /* renamed from: OplusGLSurfaceView_13 */
    private int f23131i = -1;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f23133k = true;

    public OplusPlaySound(Context context) {
        this.f23128f = false;
        this.f23132j = null;
        this.f23128f = MyRegionAdapter.m14513c();
        if (this.f23128f) {
            this.f23123a = new SoundPool(10, AudioManagerNative.f23279a, 1);
        } else {
            this.f23123a = new SoundPool(10, 1, 1);
        }
        this.f23123a.setOnLoadCompleteListener(this);
        this.f23132j = new PlatformImplementations.kt_3();
        this.f23124b = context;
        this.f23127e = (AudioManager) this.f23124b.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.f23129g = new HandlerThread("OplusPlaySound Thread");
        this.f23129g.start();
        this.f23130h = new Handler(this.f23129g.getLooper()) { // from class: com.oplus.camera.w.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int OplusGLSurfaceView_13 = message.what;
                if (OplusGLSurfaceView_13 == 1) {
                    int i2 = message.arg1;
                    if (OplusPlaySound.this.f23128f) {
                        if (OplusPlaySound.this.f23125c == null || OplusPlaySound.this.f23123a == null) {
                            return;
                        }
                        OplusPlaySound.this.f23123a.play(((Integer) OplusPlaySound.this.f23125c.get(Integer.valueOf(i2))).intValue(), 1.0f, 1.0f, 0, 0, 1.0f);
                        return;
                    }
                    if (OplusPlaySound.this.m24674g() != 2 || OplusPlaySound.this.f23125c == null || OplusPlaySound.this.f23123a == null) {
                        return;
                    }
                    OplusPlaySound.this.f23123a.play(((Integer) OplusPlaySound.this.f23125c.get(Integer.valueOf(i2))).intValue(), 1.0f, 1.0f, 0, 0, 1.0f);
                    return;
                }
                if (OplusGLSurfaceView_13 != 2) {
                    return;
                }
                int i3 = message.arg1;
                try {
                    OplusPlaySound.this.f23133k = false;
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    AudioManagerNative.m24916a(i3);
                    OplusPlaySound.this.f23133k = true;
                    CameraLog.m12959b("OplusPlaySound", "setRingerModeInternal, ringerMode: " + i3 + ", take " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms.");
                } catch (Exception COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                }
            }
        };
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m24675a() {
        if (this.f23125c == null) {
            this.f23125c = new HashMap<>();
            if (Util.m24352ao()) {
                this.f23125c.put(0, Integer.valueOf(this.f23123a.load(this.f23124b, R.raw.camera_moon_shutter, 0)));
                this.f23125c.put(3, Integer.valueOf(this.f23123a.load(this.f23124b, R.raw.camera_moon_time_snapshot, 0)));
                this.f23125c.put(1, Integer.valueOf(this.f23123a.load(this.f23124b, R.raw.camera_moon_burst_shutter, 0)));
                this.f23125c.put(2, Integer.valueOf(this.f23123a.load(this.f23124b, R.raw.camera_moon_burst_shutter_end, 0)));
                this.f23125c.put(6, Integer.valueOf(this.f23123a.load(this.f23124b, R.raw.camera_moon_long_exposure_start, 0)));
                this.f23125c.put(7, Integer.valueOf(this.f23123a.load(this.f23124b, R.raw.camera_moon_long_exposure_end, 0)));
            } else {
                this.f23125c.put(0, Integer.valueOf(this.f23123a.load(this.f23124b, R.raw.camera_shutter, 0)));
                this.f23125c.put(3, Integer.valueOf(this.f23123a.load(this.f23124b, R.raw.camera_time_snapshot, 0)));
                this.f23125c.put(1, Integer.valueOf(this.f23123a.load(this.f23124b, R.raw.camera_burst_shutter, 0)));
                this.f23125c.put(2, Integer.valueOf(this.f23123a.load(this.f23124b, R.raw.camera_burst_shutter_end, 0)));
            }
            if (this.f23128f) {
                this.f23125c.put(4, Integer.valueOf(this.f23123a.load(this.f23124b, R.raw.camera_video_start_jp, 0)));
                this.f23125c.put(5, Integer.valueOf(this.f23123a.load(this.f23124b, R.raw.camera_video_stop_jp, 0)));
            } else if (Util.m24352ao()) {
                this.f23125c.put(4, Integer.valueOf(this.f23123a.load(this.f23124b, R.raw.camera_moon_video_start, 0)));
                this.f23125c.put(5, Integer.valueOf(this.f23123a.load(this.f23124b, R.raw.camera_moon_video_stop, 0)));
            } else {
                this.f23125c.put(4, Integer.valueOf(this.f23123a.load(this.f23124b, R.raw.camera_video_start, 0)));
                this.f23125c.put(5, Integer.valueOf(this.f23123a.load(this.f23124b, R.raw.camera_video_stop, 0)));
            }
            this.f23132j.m24683a(4, 5);
        }
    }

    @Override // android.media.SoundPool.OnLoadCompleteListener
    public void onLoadComplete(SoundPool soundPool, int OplusGLSurfaceView_13, int i2) {
        if (i2 != 0) {
            CameraLog.m12967f("OplusPlaySound", "onLoadComplete, load sound fail for soundId: " + OplusGLSurfaceView_13 + ", status: " + i2);
        }
        HashMap<Integer, Integer> map = this.f23125c;
        if (map == null || map.entrySet() == null) {
            return;
        }
        for (Map.Entry<Integer, Integer> entry : this.f23125c.entrySet()) {
            if (OplusGLSurfaceView_13 == entry.getValue().intValue()) {
                this.f23126d.put(entry.getKey(), true);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m24676a(int OplusGLSurfaceView_13) {
        return Util.m24396b(this.f23126d) && this.f23126d.containsKey(Integer.valueOf(OplusGLSurfaceView_13)) && this.f23126d.get(Integer.valueOf(OplusGLSurfaceView_13)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: COUIBaseListPopupWindow_11 */
    public int m24674g() {
        AudioManager audioManager = this.f23127e;
        if (audioManager != null) {
            return audioManager.getRingerMode();
        }
        return 2;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m24677b() {
        AudioManager audioManager = this.f23127e;
        if (audioManager != null) {
            this.f23131i = audioManager.getRingerMode();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m24679c() {
        return this.f23133k;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m24680d() {
        CameraLog.m12959b("OplusPlaySound", "setAudioSilent, mRestoreRingMode: " + this.f23131i);
        if (this.f23127e != null) {
            int OplusGLSurfaceView_13 = this.f23131i;
            if (2 == OplusGLSurfaceView_13 || 1 == OplusGLSurfaceView_13) {
                this.f23130h.removeMessages(2);
                this.f23130h.obtainMessage(2, 0, 0).sendToTarget();
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m24681e() {
        CameraLog.m12959b("OplusPlaySound", "restoreAudioMode, mRestoreRingMode: " + this.f23131i);
        if (this.f23127e != null && 2 == this.f23131i) {
            this.f23130h.removeMessages(2);
            this.f23130h.obtainMessage(2, 2, 0).sendToTarget();
        } else {
            if (this.f23127e == null || 1 != this.f23131i) {
                return;
            }
            this.f23130h.removeMessages(2);
            this.f23130h.obtainMessage(2, 1, 0).sendToTarget();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m24678b(int OplusGLSurfaceView_13) {
        if (this.f23132j.m24684a(OplusGLSurfaceView_13)) {
            this.f23130h.removeCallbacksAndMessages(null);
            this.f23130h.obtainMessage(1, OplusGLSurfaceView_13, 0).sendToTarget();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m24682f() {
        HandlerThread handlerThread = this.f23129g;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.f23129g = null;
        }
        Handler handler = this.f23130h;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f23130h = null;
        }
        HashMap<Integer, Integer> map = this.f23125c;
        if (map != null) {
            map.clear();
            this.f23125c = null;
        }
        SoundPool soundPool = this.f23123a;
        if (soundPool != null) {
            soundPool.setOnLoadCompleteListener(null);
            this.f23123a.release();
            this.f23123a = null;
        }
        this.f23126d.clear();
        this.f23127e = null;
    }

    /* compiled from: OplusPlaySound.java */
    /* renamed from: com.oplus.camera.w$PlatformImplementations.kt_3 */
    public static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        private List<IntrinsicsJvm.kt_4> f23135a = new ArrayList();

        /* renamed from: PlatformImplementations.kt_3 */
        public boolean m24684a(int OplusGLSurfaceView_13) {
            for (IntrinsicsJvm.kt_4 bVar : this.f23135a) {
                if (OplusGLSurfaceView_13 == bVar.f23140a) {
                    bVar.f23142c = true;
                } else if (OplusGLSurfaceView_13 != bVar.f23141b) {
                    continue;
                } else {
                    if (!bVar.f23142c) {
                        return false;
                    }
                    bVar.f23142c = false;
                }
            }
            return true;
        }

        /* renamed from: PlatformImplementations.kt_3 */
        public void m24683a(int OplusGLSurfaceView_13, int i2) {
            this.f23135a.add(new IntrinsicsJvm.kt_4(OplusGLSurfaceView_13, i2));
        }
    }

    /* compiled from: OplusPlaySound.java */
    /* renamed from: com.oplus.camera.w$IntrinsicsJvm.kt_4 */
    public static class IntrinsicsJvm.kt_4 {

        /* renamed from: PlatformImplementations.kt_3 */
        public int f23140a;

        /* renamed from: IntrinsicsJvm.kt_4 */
        public int f23141b;

        /* renamed from: IntrinsicsJvm.kt_3 */
        public boolean f23142c = false;

        public IntrinsicsJvm.kt_4(int OplusGLSurfaceView_13, int i2) {
            this.f23140a = 0;
            this.f23141b = 0;
            this.f23140a = OplusGLSurfaceView_13;
            this.f23141b = i2;
        }
    }
}
