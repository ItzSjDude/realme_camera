package com.oplus.camera.capmode;

import android.media.AudioManager;
import android.media.CamcorderProfile;
import android.media.MediaCodec;
import android.media.MediaRecorder;
import android.os.Build;
import android.view.Surface;
import com.google.android.exoplayer2.util.MimeTypes;
import com.oplus.camera.CameraLog;
import com.oplus.camera.Storage;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.aps.constant.ApsConstant;
import com.oplus.camera.p146gl.OplusGLSurfaceView;
import com.oplus.camera.p181w.CameraThreadExector;
import com.oplus.camera.statistics.model.DcsMsgData;
import com.oplus.camera.statistics.model.FocusAimMsgData;
import com.oplus.camera.util.Util;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: VideoRecorder.java */
/* renamed from: com.oplus.camera.capmode.x */
/* loaded from: classes2.dex */
public class VideoRecorder {

    /* renamed from: PlatformImplementations.kt_3 */
    public static float f13063a;

    /* renamed from: OplusGLSurfaceView_5 */
    private boolean f13073k;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private String f13065c = null;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private boolean f13066d = false;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private AudioManager f13067e = null;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private String f13068f = "";

    /* renamed from: COUIBaseListPopupWindow_11 */
    private float f13069g = -1.0f;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private float f13070h = -1.0f;

    /* renamed from: OplusGLSurfaceView_13 */
    private int f13071i = -1;

    /* renamed from: OplusGLSurfaceView_15 */
    private boolean f13072j = false;

    /* renamed from: IntrinsicsJvm.kt_4 */
    public int f13064b = 0;

    /* renamed from: OplusGLSurfaceView_14 */
    private MediaRecorder f13074l = null;

    /* renamed from: OplusGLSurfaceView_6 */
    private CameraMediaCodec f13075m = null;

    /* renamed from: OplusGLSurfaceView_11 */
    private COUIBaseListPopupWindow_10 f13076n = null;

    /* renamed from: o */
    private COUIBaseListPopupWindow_12 f13077o = null;

    /* renamed from: p */
    private COUIBaseListPopupWindow_11 f13078p = null;

    /* renamed from: q */
    private COUIBaseListPopupWindow_8 f13079q = null;

    /* renamed from: r */
    private IntrinsicsJvm.kt_5 f13080r = null;

    /* compiled from: VideoRecorder.java */
    /* renamed from: com.oplus.camera.capmode.x$IntrinsicsJvm.kt_5 */
    public interface IntrinsicsJvm.kt_5 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo12760a(Surface surface);
    }

    /* compiled from: VideoRecorder.java */
    /* renamed from: com.oplus.camera.capmode.x$COUIBaseListPopupWindow_8 */
    public interface COUIBaseListPopupWindow_8 {
        /* renamed from: PlatformImplementations.kt_3 */
        long mo12761a(MediaCodec.BufferInfo bufferInfo);
    }

    /* compiled from: VideoRecorder.java */
    /* renamed from: com.oplus.camera.capmode.x$COUIBaseListPopupWindow_12 */
    public interface COUIBaseListPopupWindow_12 {
        void onError(Object obj, int OplusGLSurfaceView_13, int i2);
    }

    /* compiled from: VideoRecorder.java */
    /* renamed from: com.oplus.camera.capmode.x$COUIBaseListPopupWindow_11 */
    public interface COUIBaseListPopupWindow_11 {
        void onException(int OplusGLSurfaceView_13);
    }

    /* compiled from: VideoRecorder.java */
    /* renamed from: com.oplus.camera.capmode.x$COUIBaseListPopupWindow_10 */
    public interface COUIBaseListPopupWindow_10 {
        void onInfo(Object obj, int OplusGLSurfaceView_13, int i2);
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public String m12731c(int OplusGLSurfaceView_13, int i2) {
        if (OplusGLSurfaceView_13 == 0) {
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
        if (OplusGLSurfaceView_13 == 1) {
            if (i2 != 0) {
                if (i2 == 90) {
                    return FocusAimMsgData.KEY_TOUCH_TAKE_PICTURE;
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

    public VideoRecorder(boolean z, float f2) {
        this.f13073k = false;
        this.f13073k = z;
        f13063a = f2 * 10.0f;
        m12699h();
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private void m12699h() {
        if (this.f13073k) {
            this.f13075m = new CameraMediaCodec();
            this.f13075m.m12251a(new PlatformImplementations.kt_3());
            this.f13075m.m12266c("on".equals(Storage.m11139e()));
        } else {
            this.f13074l = new MediaRecorder();
            this.f13074l.setOnInfoListener(new IntrinsicsJvm.kt_3());
            this.f13074l.setOnErrorListener(new IntrinsicsJvm.kt_4());
        }
        this.f13067e = (AudioManager) Util.m24472l().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        CameraLog.m12967f("VideoRecorder", "init, mbUseCameraMediaCodec: " + this.f13073k);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12721a(boolean z) {
        if (this.f13073k) {
            this.f13075m.m12255a(z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m12723a() {
        if (this.f13073k) {
            return this.f13075m.m12257a();
        }
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m12729b(boolean z) {
        if (this.f13073k) {
            this.f13075m.m12262b(z);
        }
    }

    /* compiled from: VideoRecorder.java */
    /* renamed from: com.oplus.camera.capmode.x$IntrinsicsJvm.kt_3 */
    private class IntrinsicsJvm.kt_3 implements MediaRecorder.OnInfoListener {
        private IntrinsicsJvm.kt_3() {
        }

        @Override // android.media.MediaRecorder.OnInfoListener
        public void onInfo(MediaRecorder mediaRecorder, int OplusGLSurfaceView_13, int i2) {
            if (VideoRecorder.this.f13076n != null) {
                VideoRecorder.this.f13076n.onInfo(mediaRecorder, OplusGLSurfaceView_13, i2);
            }
        }
    }

    /* compiled from: VideoRecorder.java */
    /* renamed from: com.oplus.camera.capmode.x$IntrinsicsJvm.kt_4 */
    private class IntrinsicsJvm.kt_4 implements MediaRecorder.OnErrorListener {
        private IntrinsicsJvm.kt_4() {
        }

        @Override // android.media.MediaRecorder.OnErrorListener
        public void onError(MediaRecorder mediaRecorder, int OplusGLSurfaceView_13, int i2) {
            if (VideoRecorder.this.f13077o != null) {
                VideoRecorder.this.f13077o.onError(mediaRecorder, OplusGLSurfaceView_13, i2);
            }
        }
    }

    /* compiled from: VideoRecorder.java */
    /* renamed from: com.oplus.camera.capmode.x$PlatformImplementations.kt_3 */
    private class PlatformImplementations.kt_3 implements CameraMediaCodecListener {
        private PlatformImplementations.kt_3() {
        }

        @Override // com.oplus.camera.capmode.CameraMediaCodecListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo12290a(CameraMediaCodec c2648b, int OplusGLSurfaceView_13, int i2) {
            if (VideoRecorder.this.f13076n != null) {
                VideoRecorder.this.f13076n.onInfo(c2648b, OplusGLSurfaceView_13, i2);
            }
        }

        @Override // com.oplus.camera.capmode.CameraMediaCodecListener
        /* renamed from: IntrinsicsJvm.kt_4 */
        public void mo12291b(CameraMediaCodec c2648b, int OplusGLSurfaceView_13, int i2) {
            if (VideoRecorder.this.f13077o != null) {
                VideoRecorder.this.f13077o.onError(c2648b, OplusGLSurfaceView_13, i2);
            }
        }

        @Override // com.oplus.camera.capmode.CameraMediaCodecListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo12288a(int OplusGLSurfaceView_13) {
            if (VideoRecorder.this.f13078p != null) {
                VideoRecorder.this.f13078p.onException(OplusGLSurfaceView_13);
            }
        }

        @Override // com.oplus.camera.capmode.CameraMediaCodecListener
        /* renamed from: PlatformImplementations.kt_3 */
        public long mo12287a(MediaCodec.BufferInfo bufferInfo) {
            if (VideoRecorder.this.f13079q != null) {
                return VideoRecorder.this.f13079q.mo12761a(bufferInfo);
            }
            return -1L;
        }

        @Override // com.oplus.camera.capmode.CameraMediaCodecListener
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo12289a(Surface surface) {
            if (VideoRecorder.this.f13080r != null) {
                VideoRecorder.this.f13080r.mo12760a(surface);
            }
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public boolean m12730b() throws IllegalStateException {
        if (this.f13073k) {
            return this.f13075m.m12270d();
        }
        this.f13074l.start();
        return true;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public boolean m12735c() throws IllegalStateException, MediaCodec.CryptoException {
        boolean zM12273e;
        if (this.f13073k) {
            this.f13075m.m12251a((CameraMediaCodecListener) null);
            zM12273e = this.f13075m.m12273e();
        } else {
            this.f13074l.setOnInfoListener(null);
            this.f13074l.setOnErrorListener(null);
            this.f13074l.stop();
            zM12273e = true;
        }
        m12738d(false);
        m12747g(false);
        m12697e("normal");
        return zM12273e;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public boolean m12739d() {
        if (this.f13073k) {
            this.f13075m = null;
        } else {
            this.f13074l.reset();
            this.f13074l.release();
            this.f13074l = null;
        }
        CameraLog.m12967f("VideoRecorder", "release, mbUseCameraMediaCodec: " + this.f13073k);
        return true;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12703a(int OplusGLSurfaceView_13) throws IllegalStateException {
        if (this.f13073k) {
            return;
        }
        this.f13074l.setAudioSource(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12707a(Surface surface) {
        if (this.f13073k) {
            return;
        }
        this.f13074l.setInputSurface(surface);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m12725b(int OplusGLSurfaceView_13) {
        if (this.f13073k) {
            this.f13075m.m12281h(OplusGLSurfaceView_13);
        } else {
            this.f13074l.setAudioEncodingBitRate(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m12732c(int OplusGLSurfaceView_13) {
        if (this.f13073k) {
            this.f13075m.m12283i(OplusGLSurfaceView_13);
        } else {
            this.f13074l.setAudioChannels(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m12736d(int OplusGLSurfaceView_13) {
        if (this.f13073k) {
            this.f13075m.m12284j(OplusGLSurfaceView_13);
        } else {
            this.f13074l.setAudioSamplingRate(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m12741e(int OplusGLSurfaceView_13) throws IllegalStateException {
        if (this.f13073k) {
            this.f13075m.m12285k(OplusGLSurfaceView_13);
        } else {
            this.f13074l.setAudioEncoder(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m12743f(int OplusGLSurfaceView_13) throws IllegalStateException {
        if (this.f13073k) {
            return;
        }
        this.f13074l.setVideoSource(OplusGLSurfaceView_13);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12717a(String str, CamcorderProfile camcorderProfile) throws IllegalStateException {
        if (this.f13073k) {
            this.f13075m.m12250a(camcorderProfile);
            return;
        }
        if (camcorderProfile.audioCodec < 0 && (30 < Build.VERSION.SDK_INT || 30 < CameraConfig.getConfigIntValue(ConfigDataBase.KEY_ROM_PLATFORM_VERSION))) {
            this.f13074l.setOutputFormat(camcorderProfile.fileFormat);
            this.f13074l.setVideoFrameRate(camcorderProfile.videoFrameRate);
            this.f13074l.setVideoSize(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight);
            this.f13074l.setVideoEncodingBitRate(camcorderProfile.videoBitRate);
            this.f13074l.setVideoEncoder(camcorderProfile.videoCodec);
            return;
        }
        this.f13074l.setProfile(camcorderProfile);
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m12746g(int OplusGLSurfaceView_13) {
        if (this.f13073k) {
            this.f13075m.m12267d(OplusGLSurfaceView_13);
        } else {
            this.f13074l.setVideoEncodingBitRate(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m12749h(int OplusGLSurfaceView_13) throws IllegalStateException {
        if (this.f13073k) {
            if (OplusGLSurfaceView_13 == 2) {
                OplusGLSurfaceView_13 = 0;
            }
            this.f13075m.m12275f(OplusGLSurfaceView_13);
            return;
        }
        this.f13074l.setOutputFormat(OplusGLSurfaceView_13);
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m12751i(int OplusGLSurfaceView_13) throws IllegalStateException {
        if (this.f13073k) {
            this.f13075m.m12271e(OplusGLSurfaceView_13);
        } else {
            this.f13074l.setVideoFrameRate(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12705a(int OplusGLSurfaceView_13, int i2) throws IllegalStateException {
        if (this.f13073k) {
            this.f13075m.m12248a(OplusGLSurfaceView_13, i2);
        } else {
            this.f13074l.setVideoSize(OplusGLSurfaceView_13, i2);
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m12753j(int OplusGLSurfaceView_13) throws IllegalStateException {
        if (this.f13073k) {
            this.f13075m.m12278g(OplusGLSurfaceView_13);
        } else {
            this.f13074l.setVideoEncoder(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    public void m12755k(int OplusGLSurfaceView_13) {
        if (this.f13073k) {
            this.f13075m.m12259b(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m12734c(boolean z) {
        if (this.f13073k) {
            this.f13075m.m12272e(z);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m12726b(int OplusGLSurfaceView_13, int i2) {
        if (this.f13073k) {
            return;
        }
        this.f13074l.setVideoEncodingProfileLevel(OplusGLSurfaceView_13, i2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12702a(float f2, float f3) {
        if (this.f13073k) {
            this.f13075m.m12246a(f2, f3);
        } else {
            this.f13074l.setLocation(f2, f3);
        }
    }

    /* renamed from: OplusGLSurfaceView_14 */
    public void m12756l(int OplusGLSurfaceView_13) throws IllegalArgumentException {
        if (this.f13073k) {
            this.f13075m.m12249a(OplusGLSurfaceView_13);
        } else {
            this.f13074l.setMaxDuration(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m12738d(boolean z) {
        this.f13072j = z;
        m12692a("binaural_recording_switch", Integer.valueOf(z ? 1 : 0));
        CameraMediaCodec c2648b = this.f13075m;
        if (c2648b != null) {
            c2648b.m12269d(z);
        }
        if (this.f13072j) {
            m12697e("normal");
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m12742e(boolean z) {
        m12692a("binaural_recording_orientation", (Object) (z ? DcsMsgData.FRONT : "back"));
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public void m12744f(boolean z) {
        m12692a("binaural_recording_mirror", Boolean.valueOf(z));
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12719a(String str, String str2, int OplusGLSurfaceView_13, int i2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.f13072j) {
            str2 = "normal";
        }
        String strM12731c = m12731c(OplusGLSurfaceView_13, i2);
        if (this.f13073k) {
            this.f13075m.m12265c(strM12731c);
            this.f13075m.m12254a(str2);
            this.f13075m.m12261b(str);
            return;
        }
        m12720a(str, str2, strM12731c);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12716a(String str, float f2, int OplusGLSurfaceView_13) {
        if (this.f13072j) {
            str = "normal";
        }
        this.f13065c = str;
        m12701a(f2);
        m12757m(OplusGLSurfaceView_13);
        m12697e(this.f13065c);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12701a(float f2) {
        if (Util.m24175F()) {
            float fRound = Math.round(f2 * 10.0f) / 10.0f;
            if (fRound != this.f13069g) {
                this.f13069g = fRound;
                m12692a("vendor_audiorecord_focus_zoom", Float.valueOf(this.f13069g));
                if ("normal".equals(this.f13065c) || "lock_focus".equals(this.f13068f)) {
                    return;
                }
                String str = 1.1f > fRound ? ApsConstant.CAPTURE_MODE_PANORAMA : "focusing";
                if (str.equals(this.f13068f)) {
                    return;
                }
                m12697e(str);
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m12697e(String str) {
        if (Util.m24175F() && !this.f13068f.equals(str)) {
            this.f13068f = str;
            char c2 = 65535;
            int iHashCode = str.hashCode();
            if (iHashCode != 52556810) {
                if (iHashCode != 1069983349) {
                    if (iHashCode == 1222947012 && str.equals("lock_focus")) {
                        c2 = 2;
                    }
                } else if (str.equals(ApsConstant.CAPTURE_MODE_PANORAMA)) {
                    c2 = 0;
                }
            } else if (str.equals("focusing")) {
                c2 = 1;
            }
            if (c2 == 0) {
                m12692a("vendor_audiorecord_effect_type", (Object) 1);
                m12692a("vendor_audiorecord_focus_zoom", Float.valueOf(this.f13069g));
                m12692a("vendor_audiorecord_orientation", Integer.valueOf(this.f13071i));
            } else if (c2 == 1) {
                m12692a("vendor_audiorecord_effect_type", (Object) 2);
                m12692a("vendor_audiorecord_focus_zoom", Float.valueOf(this.f13069g));
                m12692a("vendor_audiorecord_orientation", Integer.valueOf(this.f13071i));
            } else {
                if (c2 == 2) {
                    m12692a("vendor_audiorecord_effect_type", (Object) 3);
                    m12692a("vendor_audiorecord_focus_zoom", Float.valueOf(this.f13069g));
                    m12692a("vendor_audiorecord_orientation", Integer.valueOf(this.f13071i));
                    m12692a("vendor_audiorecord_focus_angle", Float.valueOf(this.f13070h));
                    return;
                }
                m12692a("vendor_audiorecord_effect_type", (Object) 0);
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_6 */
    public void m12757m(int OplusGLSurfaceView_13) {
        int i2 = OplusGLSurfaceView_13 != 90 ? OplusGLSurfaceView_13 != 180 ? OplusGLSurfaceView_13 != 270 ? 0 : 2 : 1 : 3;
        if (i2 != this.f13071i) {
            this.f13071i = i2;
            m12692a("vendor_audiorecord_orientation", Integer.valueOf(i2));
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m12724b(float f2, float f3) {
        if (Util.m24175F() && this.f13066d && !this.f13072j) {
            float fFloor = ((int) Math.floor((((Util.getScreenHeight() - (f3 * 2.0f)) / Util.getScreenHeight()) * (this.f13069g < 1.0f ? 60 : 36)) / 10.0f)) * 10;
            int OplusGLSurfaceView_13 = this.f13071i;
            if (OplusGLSurfaceView_13 == 0 || 1 == OplusGLSurfaceView_13) {
                fFloor = 0.0f;
            }
            if (!"lock_focus".equals(this.f13068f)) {
                this.f13070h = fFloor;
                m12697e("lock_focus");
            } else if (Float.compare(fFloor, this.f13070h) != 0) {
                this.f13070h = fFloor;
                m12692a("vendor_audiorecord_focus_angle", Float.valueOf(this.f13070h));
            }
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public void m12747g(boolean z) {
        if (!Util.m24175F() || z == this.f13066d) {
            return;
        }
        this.f13066d = z;
        CameraLog.m12962c("VideoRecorder", "setFocusTrackingState, isTracing: " + z);
        if (this.f13066d) {
            return;
        }
        if ("normal".equals(this.f13065c)) {
            m12697e("normal");
        } else {
            m12697e(1.1f > this.f13069g ? ApsConstant.CAPTURE_MODE_PANORAMA : "focusing");
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m12692a(String str, Object obj) {
        if (!"vendor_audiorecord_focus_angle".equals(str) || "lock_focus".equals(this.f13068f)) {
            final StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("=");
            sb.append(obj);
            CameraThreadExector.m24695a().m24696a(new Runnable() { // from class: com.oplus.camera.capmode.x.1
                @Override // java.lang.Runnable
                public void run() {
                    if (VideoRecorder.this.f13067e != null) {
                        try {
                            VideoRecorder.this.f13067e.setParameters(sb.toString());
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    CameraLog.m12962c("VideoRecorder", "updateAudioParameters, keyValuePairs: " + ((Object) sb));
                }
            }, "updateAudioParameters");
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12720a(String str, String str2, String str3) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if ("normal".equals(str2)) {
            m12718a("vendor.ozoaudio.device.value", "");
            m12718a("vendor.ozoaudio.focus-mode.value", "off");
        } else if (ApsConstant.CAPTURE_MODE_PANORAMA.equals(str2)) {
            m12718a("vendor.ozoaudio.device.value", str3);
            m12718a("vendor.ozoaudio.focus-mode.value", "on");
        } else if ("focusing".equals(str2)) {
            m12718a("vendor.ozoaudio.device.value", str3);
            m12718a("vendor.ozoaudio.focus-mode.value", "on");
            m12718a("vendor.ozoaudio.focus-gain.value", String.valueOf(Util.m24476m(this.f13064b)));
        }
        if (Util.m24170D()) {
            m12718a("vendor.ozoaudio.wnr-mode.value", str);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12718a(String str, String str2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        m12728b("setParameter", str, str2);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m12728b(String str, String str2, String str3) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Method declaredMethod;
        try {
            declaredMethod = MediaRecorder.class.getDeclaredMethod(str, String.class);
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            declaredMethod = null;
        }
        declaredMethod.setAccessible(true);
        try {
            if (this.f13074l != null) {
                declaredMethod.invoke(this.f13074l, str2 + "=" + str3);
            }
            declaredMethod.setAccessible(false);
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12704a(int OplusGLSurfaceView_13, float f2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        CameraLog.m12962c("VideoRecorder", "setFocusingSoundVolume, soundVolume: " + OplusGLSurfaceView_13);
        if (this.f13073k) {
            CameraMediaCodec c2648b = this.f13075m;
            if (c2648b != null) {
                c2648b.m12247a(OplusGLSurfaceView_13);
                this.f13075m.m12286l(OplusGLSurfaceView_13);
                return;
            }
            return;
        }
        this.f13064b = OplusGLSurfaceView_13;
        boolean configBooleanValue = CameraConfig.getConfigBooleanValue(ConfigDataBase.f12543x6a81d9ec);
        m12718a("vendor.ozoaudio.focus-gain.value", String.valueOf(configBooleanValue ? Util.m24364b(f2) : Util.m24476m(this.f13064b)));
        if (configBooleanValue) {
            m12718a("vendor.ozoaudio.focus-sector-width.value", "60.0");
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12715a(String str) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        CameraLog.m12954a("VideoRecorder", "setVideoSoundType, soundType: " + str);
        if (this.f13073k) {
            CameraMediaCodec c2648b = this.f13075m;
            if (c2648b != null) {
                c2648b.m12254a(str);
                return;
            }
            return;
        }
        if ("normal".equals(str)) {
            m12718a("vendor.ozoaudio.device.value", "");
            m12718a("vendor.ozoaudio.focus-mode.value", "off");
        } else if (ApsConstant.CAPTURE_MODE_PANORAMA.equals(str)) {
            m12718a("vendor.ozoaudio.device.value", str);
            m12718a("vendor.ozoaudio.focus-mode.value", "on");
        } else if ("focusing".equals(str)) {
            m12718a("vendor.ozoaudio.device.value", str);
            m12718a("vendor.ozoaudio.focus-mode.value", "on");
        }
    }

    /* renamed from: OplusGLSurfaceView_11 */
    public void m12758n(int OplusGLSurfaceView_13) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        CameraLog.m12954a("VideoRecorder", "setVideoMirror, mirrorType: " + OplusGLSurfaceView_13);
        if (this.f13074l == null || this.f13073k) {
            CameraLog.m12967f("VideoRecorder", "setVideoMirror, mMediaRecorder: " + this.f13074l + ", mbUseCameraMediaCodec: " + this.f13073k);
            return;
        }
        try {
            Method declaredMethod = MediaRecorder.class.getDeclaredMethod("setParameter", String.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this.f13074l, "set-video-mirror=" + OplusGLSurfaceView_13);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            CameraLog.m12965d("VideoRecorder", "setVideoMirror, IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            CameraLog.m12965d("VideoRecorder", "setVideoMirror, NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            CameraLog.m12965d("VideoRecorder", "setVideoMirror, InvocationTargetException", e4);
        }
    }

    /* renamed from: o */
    public void m12759o(int OplusGLSurfaceView_13) {
        if (this.f13073k) {
            this.f13075m.m12264c(OplusGLSurfaceView_13);
        } else {
            this.f13074l.setOrientationHint(OplusGLSurfaceView_13);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12714a(FileDescriptor fileDescriptor) throws IllegalStateException {
        CameraLog.m12954a("VideoRecorder", "setOutputFile, fileDescriptor: " + fileDescriptor);
        if (this.f13073k) {
            this.f13075m.m12253a(fileDescriptor);
        } else {
            this.f13074l.setOutputFile(fileDescriptor);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m12727b(String str) throws IllegalStateException {
        CameraLog.m12954a("VideoRecorder", "setOutputFile, path: " + str);
        if (this.f13073k) {
            this.f13075m.m12268d(str);
        } else {
            this.f13074l.setOutputFile(str);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12700a(double d2) {
        if (this.f13073k) {
            return;
        }
        this.f13074l.setCaptureRate(d2);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12706a(long OplusGLSurfaceView_15) throws IllegalArgumentException {
        if (this.f13073k) {
            this.f13075m.m12260b(OplusGLSurfaceView_15);
        } else {
            this.f13074l.setMaxFileSize(OplusGLSurfaceView_15);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12710a(COUIBaseListPopupWindow_12 fVar) {
        this.f13077o = fVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12712a(COUIBaseListPopupWindow_10 hVar) {
        this.f13076n = hVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12711a(COUIBaseListPopupWindow_11 gVar) {
        this.f13078p = gVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12709a(COUIBaseListPopupWindow_8 eVar) {
        this.f13079q = eVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12708a(IntrinsicsJvm.kt_5 dVar) {
        if (this.f13073k) {
            this.f13080r = dVar;
            this.f13075m.m12282h(dVar != null);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12713a(OplusGLSurfaceView surfaceHolderCallbackC2766q) {
        if (this.f13073k) {
            this.f13075m.m12252a(surfaceHolderCallbackC2766q);
        }
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m12733c(String str) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        CameraLog.m12967f("VideoRecorder", "writeExifTag, exifInfo: " + str);
        if (this.f13074l == null || this.f13073k) {
            return;
        }
        try {
            Method declaredMethod = MediaRecorder.class.getDeclaredMethod("setParameter", String.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this.f13074l, "set-title=".concat(str));
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m12737d(String str) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        CameraLog.m12967f("VideoRecorder", "setMediaRecorderParameter, parameter: " + str);
        if (this.f13074l == null || this.f13073k) {
            return;
        }
        try {
            Method declaredMethod = MediaRecorder.class.getDeclaredMethod("setParameter", String.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this.f13074l, str);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    public void m12740e() throws IllegalStateException, IOException {
        if (this.f13073k) {
            this.f13075m.m12263c();
        } else {
            this.f13074l.prepare();
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    public boolean m12745f() throws IllegalStateException {
        try {
            if (this.f13073k) {
                this.f13075m.m12277g();
                return true;
            }
            this.f13074l.resume();
            return true;
        } catch (RuntimeException e2) {
            CameraLog.m12967f("VideoRecorder", "resume, Could not resume video recorder");
            e2.printStackTrace();
            return false;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    public boolean m12748g() throws IllegalStateException {
        try {
            if (this.f13073k) {
                this.f13075m.m12274f();
                return true;
            }
            this.f13074l.pause();
            return true;
        } catch (RuntimeException e2) {
            e2.printStackTrace();
            CameraLog.m12967f("VideoRecorder", "pause, Could not pause video recorder");
            return false;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    public void m12750h(boolean z) {
        if (this.f13073k) {
            this.f13075m.m12272e(z);
        }
    }

    /* renamed from: OplusGLSurfaceView_13 */
    public void m12752i(boolean z) {
        if (this.f13073k) {
            this.f13075m.m12276f(z);
        }
    }

    /* renamed from: OplusGLSurfaceView_15 */
    public void m12754j(boolean z) {
        if (this.f13073k) {
            this.f13075m.m12279g(z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m12722a(byte[] bArr) {
        if (this.f13073k) {
            this.f13075m.m12256a(bArr);
        }
    }
}
