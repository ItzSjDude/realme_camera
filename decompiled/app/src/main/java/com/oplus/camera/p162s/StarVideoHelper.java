package com.oplus.camera.p162s;

import android.content.ContentValues;
import android.content.Context;
import android.location.Location;
import android.media.CamcorderProfile;
import android.media.MediaCodec;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import android.util.Size;
import com.google.android.exoplayer2.util.MimeTypes;
import com.oplus.camera.CameraLog;
import com.oplus.camera.R;
import com.oplus.camera.Storage;
import com.oplus.camera.aps.config.CameraConfig;
import com.oplus.camera.aps.config.ConfigDataBase;
import com.oplus.camera.capmode.VideoMode;
import com.oplus.camera.capmode.VideoRecorder;
import com.oplus.camera.capmode.CameraInterface;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.control.Thumbnail;
import com.oplus.camera.util.Util;
import com.oplus.camera.util.storage.MediaStoreUtil;
import com.oplus.ocs.camera.CameraParameter;
import com.oplus.ocs.camera.CameraPictureCallback;
import com.sensetime.stmobile.STMobileHumanActionNative;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: StarVideoHelper.java */
/* renamed from: com.oplus.camera.s.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
class StarVideoHelper implements VideoRecorder.COUIBaseListPopupWindow_8 {

    /* renamed from: PlatformImplementations.kt_3 */
    private Context f15890a;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private boolean f15892c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private CameraInterface f15893d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private CameraUIInterface f15894e;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Handler f15891b = null;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private Size f15895f = null;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private String f15896g = null;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private Uri f15897h = null;

    /* renamed from: OplusGLSurfaceView_13 */
    private CamcorderProfile f15898i = null;

    /* renamed from: OplusGLSurfaceView_15 */
    private ContentValues f15899j = null;

    /* renamed from: OplusGLSurfaceView_5 */
    private ParcelFileDescriptor f15900k = null;

    /* renamed from: OplusGLSurfaceView_14 */
    private VideoRecorder f15901l = null;

    /* renamed from: OplusGLSurfaceView_6 */
    private PlatformImplementations.kt_3 f15902m = null;

    /* renamed from: OplusGLSurfaceView_11 */
    private int f15903n = 0;

    /* renamed from: o */
    private int f15904o = 0;

    /* renamed from: p */
    private int f15905p = 0;

    /* renamed from: q */
    private boolean f15906q = false;

    /* renamed from: r */
    private boolean f15907r = false;

    /* compiled from: StarVideoHelper.java */
    /* renamed from: com.oplus.camera.s.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 extends VideoRecorder.COUIBaseListPopupWindow_12, VideoRecorder.COUIBaseListPopupWindow_11, VideoRecorder.COUIBaseListPopupWindow_10 {
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int m16329c() {
        return 30;
    }

    public StarVideoHelper(Context context, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface, boolean z) {
        this.f15890a = null;
        this.f15892c = false;
        this.f15893d = null;
        this.f15894e = null;
        this.f15890a = context;
        this.f15893d = interfaceC2646a;
        this.f15894e = cameraUIInterface;
        this.f15892c = z;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private int m16313e() {
        CamcorderProfile camcorderProfile;
        String strM16318j = m16318j();
        if ("video_size_4kuhd".equals(strM16318j)) {
            return 100000000;
        }
        if ("video_size_1080p".equals(strM16318j) && Util.m24169C() && (camcorderProfile = CamcorderProfile.get(this.f15903n, 6)) != null) {
            return camcorderProfile.videoBitRate;
        }
        return 17000000;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16324a(int OplusGLSurfaceView_13) {
        this.f15903n = OplusGLSurfaceView_13;
        int width = m16328b().getWidth();
        int height = m16328b().getHeight();
        int iM16313e = m16313e();
        int iM16329c = m16329c();
        int i2 = CameraParameter.VideoEncoder.H265.equals(m16317i()) ? 5 : 2;
        this.f15898i = CamcorderProfile.get(this.f15903n, 6);
        CamcorderProfile camcorderProfile = this.f15898i;
        camcorderProfile.videoFrameRate = iM16329c;
        camcorderProfile.videoBitRate = iM16313e;
        camcorderProfile.videoCodec = i2;
        camcorderProfile.videoFrameWidth = width;
        camcorderProfile.videoFrameHeight = height;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private boolean m16314f() {
        return !"video_size_1080p".equals(m16318j()) || CameraParameter.VideoEncoder.H265.equals(m16317i());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16325a(PlatformImplementations.kt_3 aVar) {
        this.f15902m = aVar;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16323a() {
        CameraLog.m12962c("StarVideoHelper", "startRecording E");
        m16322n();
        m16320l();
        this.f15901l = new VideoRecorder(true, this.f15893d.mo10536al());
        this.f15901l.m12734c(false);
        this.f15901l.m12750h(false);
        this.f15901l.m12752i(false);
        this.f15901l.m12754j(true);
        this.f15901l.m12721a(false);
        this.f15901l.m12717a(String.valueOf(this.f15903n), this.f15898i);
        Location locationMo10595y = this.f15893d.mo10595y();
        if (locationMo10595y != null) {
            this.f15901l.m12702a((float) locationMo10595y.getLatitude(), (float) locationMo10595y.getLongitude());
        }
        this.f15901l.m12759o(this.f15893d.mo10591u() % 360);
        ParcelFileDescriptor parcelFileDescriptor = this.f15900k;
        if (parcelFileDescriptor != null) {
            this.f15901l.m12714a(parcelFileDescriptor.getFileDescriptor());
        } else {
            this.f15901l.m12727b(this.f15896g);
        }
        this.f15901l.m12746g(m16314f() ? this.f15898i.videoBitRate / 2 : this.f15898i.videoBitRate);
        long jM11129c = Storage.m11129c(Storage.f12095u);
        long OplusGLSurfaceView_15 = "on".equals(Storage.f12095u) ? STMobileHumanActionNative.ST_MOBILE_BODY_ACTION1 : 0L;
        if (OplusGLSurfaceView_15 > 0 && OplusGLSurfaceView_15 < jM11129c) {
            jM11129c = OplusGLSurfaceView_15;
        }
        this.f15901l.m12706a(jM11129c);
        this.f15901l.m12710a((VideoRecorder.COUIBaseListPopupWindow_12) this.f15902m);
        this.f15901l.m12712a((VideoRecorder.COUIBaseListPopupWindow_10) this.f15902m);
        this.f15901l.m12711a((VideoRecorder.COUIBaseListPopupWindow_11) this.f15902m);
        this.f15901l.m12709a(this);
        try {
            this.f15901l.m12740e();
            this.f15901l.m12730b();
        } catch (IOException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        this.f15906q = true;
        this.f15904o = 0;
        this.f15905p = 0;
        CameraLog.m12962c("StarVideoHelper", "startRecording X");
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private void m16315g() {
        HandlerThread handlerThread = new HandlerThread("YUV drop padding thread");
        handlerThread.start();
        this.f15891b = new Handler(handlerThread.getLooper());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16326a(CameraPictureCallback.CameraPictureImage cameraPictureImage) {
        CameraLog.m12962c("StarVideoHelper", "onYuvImageReceived");
        if (!this.f15906q || cameraPictureImage == null || this.f15901l == null) {
            CameraLog.m12967f("StarVideoHelper", "onYuvImageReceived, mbRecording: " + this.f15906q);
            return;
        }
        if (this.f15891b == null) {
            m16315g();
        }
        this.f15904o++;
        m16309a(cameraPictureImage.getImage(), cameraPictureImage.getWidth(), cameraPictureImage.getHeight(), cameraPictureImage.getStride(), cameraPictureImage.getScanline(), cameraPictureImage.getOrientation());
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m16309a(final byte[] bArr, final int OplusGLSurfaceView_13, final int i2, final int i3, final int i4, final int i5) {
        this.f15891b.post(new Runnable() { // from class: com.oplus.camera.s.-$$Lambda$PlatformImplementations.kt_3$tAJMKsy7gxpDwx53vRMcwkZQXI0
            @Override // java.lang.Runnable
            public final void run() {
                this.COUIBaseListPopupWindow_12$0.m16312b(bArr, i3, i4, i5, OplusGLSurfaceView_13, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: IntrinsicsJvm.kt_4 */
    public /* synthetic */ void m16312b(byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5) {
        String strValueOf = String.valueOf(System.currentTimeMillis());
        m16310a(bArr, this.f15904o, OplusGLSurfaceView_13, i2, i3, strValueOf, "original");
        long jUptimeMillis = SystemClock.uptimeMillis();
        CameraLog.m12954a("StarVideoHelper", "encodeYuv, time: " + jUptimeMillis + ", byte[]: " + bArr.length);
        byte[] bArrM24310a = Util.m24310a(bArr, i4, i5, OplusGLSurfaceView_13, i2, true);
        StringBuilder sb = new StringBuilder();
        sb.append("encodeYuv, total deal byte[] cost: ");
        sb.append(SystemClock.uptimeMillis() - jUptimeMillis);
        CameraLog.m12954a("StarVideoHelper", sb.toString());
        this.f15901l.m12722a(bArrM24310a);
        m16310a(bArrM24310a, this.f15904o, i4, i5, i3, strValueOf, "yuv");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m16310a(byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3, int i4, String str, String str2) {
        if (this.f15907r) {
            Util.m24250a(bArr, "capture_yuv", str + "_" + bArr.length + "_star_video_yuv_" + OplusGLSurfaceView_13 + "_" + i2 + "_" + i3 + "_" + i4 + "_" + str2 + ".yuv");
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m16327a(boolean z) {
        CameraLog.m12962c("StarVideoHelper", "stopRecording E");
        if (!this.f15906q) {
            CameraLog.m12967f("StarVideoHelper", "stopRecording, mbRecording is false, so return!");
            return;
        }
        this.f15906q = false;
        VideoRecorder c2670x = this.f15901l;
        if (c2670x != null) {
            c2670x.m12735c();
            this.f15901l.m12710a((VideoRecorder.COUIBaseListPopupWindow_12) null);
            this.f15901l.m12712a((VideoRecorder.COUIBaseListPopupWindow_10) null);
            this.f15901l.m12711a((VideoRecorder.COUIBaseListPopupWindow_11) null);
            this.f15901l.m12709a((VideoRecorder.COUIBaseListPopupWindow_8) null);
        }
        if (z) {
            Thumbnail.IntrinsicsJvm.kt_5 dVar = new Thumbnail.IntrinsicsJvm.kt_5();
            dVar.f18298k = 1;
            m16311a(dVar);
            m16322n();
            dVar.f18291d = this.f15897h;
            this.f15894e.mo18093a(dVar, false);
        } else {
            m16322n();
            m16308a(this.f15896g);
            this.f15893d.mo10569f(true);
        }
        this.f15904o = 0;
        CameraLog.m12962c("StarVideoHelper", "stopRecording X");
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public Size m16328b() {
        if (this.f15895f == null) {
            String strM16318j = m16318j();
            if ("video_size_4kuhd".equals(strM16318j)) {
                this.f15895f = new Size(VideoMode.VIDEO_4K_FRAME_WIDTH, VideoMode.VIDEO_4K_FRAME_HEIGHT);
            } else if ("video_size_1080p".equals(strM16318j)) {
                this.f15895f = new Size(VideoMode.VIDEO_1080P_WIDTH, VideoMode.VIDEO_1080P_HEIGHT);
            } else {
                this.f15895f = new Size(VideoMode.VIDEO_720P_WIDTH, VideoMode.VIDEO_720P_HEIGHT);
            }
        }
        return this.f15895f;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public int m16330d() {
        return m16316h() / m16329c();
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private int m16316h() {
        return this.f15905p;
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private String m16317i() {
        return this.f15890a.getString(R.string.camera_video_codec_default_value);
    }

    /* renamed from: OplusGLSurfaceView_15 */
    private String m16318j() {
        return CameraConfig.getConfigStringValue(ConfigDataBase.KEY_STAR_VIDEO_SIZE_TYPE);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private String m16307a(long OplusGLSurfaceView_15) {
        return new SimpleDateFormat(this.f15890a.getResources().getString(R.string.camera_video_file_name_format), Locale.US).format(new Date(OplusGLSurfaceView_15));
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private String m16319k() {
        StringBuilder sb;
        String str;
        if (Storage.f12095u.equals("off")) {
            sb = new StringBuilder();
            str = Storage.f12091q;
        } else {
            sb = new StringBuilder();
            str = Storage.f12086l;
        }
        sb.append(str);
        sb.append('/');
        return sb.toString();
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private void m16320l() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strM16307a = m16307a(jCurrentTimeMillis);
        String str = strM16307a + ".mp4";
        this.f15896g = m16319k() + str;
        this.f15899j = new ContentValues(7);
        this.f15899j.put("title", strM16307a);
        this.f15899j.put("_display_name", str);
        this.f15899j.put("datetaken", Long.valueOf(jCurrentTimeMillis));
        this.f15899j.put("mime_type", MimeTypes.VIDEO_MP4);
        this.f15899j.put("relative_path", Storage.m11140e(null));
        this.f15899j.put("is_pending", (Integer) 1);
        Context context = this.f15890a;
        this.f15897h = MediaStoreUtil.m24650a(context, context.getContentResolver(), this.f15899j);
        try {
            this.f15900k = this.f15890a.getContentResolver().openFileDescriptor(this.f15897h, "rw");
        } catch (FileNotFoundException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        Size sizeM16328b = m16328b();
        if (sizeM16328b != null) {
            this.f15899j.put("resolution", sizeM16328b.getWidth() + "x" + sizeM16328b.getHeight());
            this.f15899j.put("width", Integer.toString(sizeM16328b.getWidth()));
            this.f15899j.put("height", Integer.toString(sizeM16328b.getHeight()));
        }
        Location locationMo10595y = this.f15893d.mo10595y();
        if (locationMo10595y != null) {
            this.f15899j.put("latitude", Double.valueOf(locationMo10595y.getLatitude()));
            this.f15899j.put("longitude", Double.valueOf(locationMo10595y.getLongitude()));
        }
        CameraLog.m12954a("StarVideoHelper", "generateVideoFilename, New video filename: " + this.f15896g + ", mCurrentVideoUri: " + this.f15897h + ", videoSize: " + sizeM16328b);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private void m16308a(String str) {
        CameraLog.m12954a("StarVideoHelper", "deleteVideoFile, fileName: " + str);
        if (str == null) {
            return;
        }
        File file = new File(str);
        if (file.exists() && !file.delete()) {
            CameraLog.m12954a("StarVideoHelper", "deleteVideoFile, Could not delete " + str);
        }
        if (this.f15897h != null) {
            try {
                try {
                    this.f15890a.getContentResolver().delete(this.f15897h, null, null);
                } catch (Exception COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                }
            } finally {
                this.f15897h = null;
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_6 */
    private long m16321m() {
        CameraLog.m12962c("StarVideoHelper", "calcVideoDuration, mEncodeFrameNumber: " + this.f15905p + ", time: " + (m16316h() / m16329c()));
        return (int) (r0 * 1000.0f);
    }

    /* renamed from: OplusGLSurfaceView_11 */
    private void m16322n() throws IOException {
        ParcelFileDescriptor parcelFileDescriptor = this.f15900k;
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
            } catch (IOException COUIBaseListPopupWindow_8) {
                CameraLog.m12965d("StarVideoHelper", "closeVideoFileDescriptor, Fail to close fd", COUIBaseListPopupWindow_8);
            }
            this.f15900k = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0099 A[PHI: r2 r8
      0x0099: PHI (r2v23 android.media.MediaMetadataRetriever) = (r2v13 android.media.MediaMetadataRetriever), (r2v24 android.media.MediaMetadataRetriever) binds: [B:31:0x00ab, B:22:0x008d] A[DONT_GENERATE, DONT_INLINE]
      0x0099: PHI (r8v3 long) = (r8v1 long), (r8v8 long) binds: [B:31:0x00ab, B:22:0x008d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e3 A[Catch: Exception -> 0x014e, TryCatch #1 {Exception -> 0x014e, blocks: (B:37:0x00df, B:39:0x00e3, B:41:0x00f4, B:43:0x00f8, B:44:0x0115), top: B:58:0x00df }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0164  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean m16311a(com.oplus.camera.p172ui.control.Thumbnail.IntrinsicsJvm.kt_5 r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 362
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.p162s.StarVideoHelper.m16311a(com.oplus.camera.ui.control.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_5):boolean");
    }

    @Override // com.oplus.camera.capmode.VideoRecorder.COUIBaseListPopupWindow_8
    /* renamed from: PlatformImplementations.kt_3 */
    public long mo12761a(MediaCodec.BufferInfo bufferInfo) {
        this.f15905p++;
        return (this.f15905p * 1000000) / m16329c();
    }
}
