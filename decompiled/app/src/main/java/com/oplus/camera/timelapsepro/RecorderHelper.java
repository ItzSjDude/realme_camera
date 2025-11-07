package com.oplus.camera.timelapsepro;

import android.content.ContentValues;
import android.content.Context;
import android.location.Location;
import android.media.CamcorderProfile;
import android.media.MediaCodec;
import android.net.Uri;
import android.os.ConditionVariable;
import android.os.ParcelFileDescriptor;
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
import com.oplus.camera.p141e.CameraCharacteristicsUtil;
import com.oplus.camera.p144g.MP4BoxHeader;
import com.oplus.camera.p172ui.CameraUIInterface;
import com.oplus.camera.p172ui.control.Thumbnail;
import com.oplus.camera.util.Util;
import com.oplus.camera.util.storage.MediaStoreUtil;
import com.oplus.ocs.camera.CameraParameter;
import com.sensetime.stmobile.STMobileHumanActionNative;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: RecorderHelper.java */
/* renamed from: com.oplus.camera.timelapsepro.IntrinsicsJvm.kt_3 */
/* loaded from: classes2.dex */
public class RecorderHelper implements VideoRecorder.COUIBaseListPopupWindow_8 {

    /* renamed from: PlatformImplementations.kt_3 */
    private Context f16820a;

    /* renamed from: IntrinsicsJvm.kt_4 */
    private boolean f16821b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private CameraInterface f16822c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private CameraUIInterface f16823d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private byte[] f16824e = null;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private ConditionVariable f16825f = new ConditionVariable();

    /* renamed from: COUIBaseListPopupWindow_11 */
    private Size f16826g = null;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private String f16827h = null;

    /* renamed from: OplusGLSurfaceView_13 */
    private Uri f16828i = null;

    /* renamed from: OplusGLSurfaceView_15 */
    private CamcorderProfile f16829j = null;

    /* renamed from: OplusGLSurfaceView_5 */
    private ContentValues f16830k = null;

    /* renamed from: OplusGLSurfaceView_14 */
    private ParcelFileDescriptor f16831l = null;

    /* renamed from: OplusGLSurfaceView_6 */
    private VideoRecorder f16832m = null;

    /* renamed from: OplusGLSurfaceView_11 */
    private PlatformImplementations.kt_3 f16833n = null;

    /* renamed from: o */
    private int f16834o = 0;

    /* renamed from: p */
    private int f16835p = 0;

    /* renamed from: q */
    private int f16836q = 0;

    /* renamed from: r */
    private boolean f16837r = false;

    /* renamed from: s */
    private boolean f16838s = false;

    /* renamed from: t */
    private boolean f16839t = false;

    /* renamed from: u */
    private boolean f16840u = false;

    /* renamed from: v */
    private String f16841v = null;

    /* renamed from: w */
    private byte[] f16842w = null;

    /* renamed from: x */
    private int f16843x = 0;

    /* compiled from: RecorderHelper.java */
    /* renamed from: com.oplus.camera.timelapsepro.IntrinsicsJvm.kt_3$PlatformImplementations.kt_3 */
    public interface PlatformImplementations.kt_3 extends VideoRecorder.COUIBaseListPopupWindow_12, VideoRecorder.COUIBaseListPopupWindow_11, VideoRecorder.COUIBaseListPopupWindow_10 {
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public int m17610c() {
        return 30;
    }

    public RecorderHelper(Context context, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface, boolean z) {
        this.f16820a = null;
        this.f16821b = false;
        this.f16822c = null;
        this.f16823d = null;
        this.f16820a = context;
        this.f16822c = interfaceC2646a;
        this.f16823d = cameraUIInterface;
        this.f16821b = z;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int m17594d() {
        CamcorderProfile camcorderProfile;
        String strM17598h = m17598h();
        if ("video_size_4kuhd".equals(strM17598h)) {
            return 100000000;
        }
        if ("video_size_1080p".equals(strM17598h) && Util.m24169C() && (camcorderProfile = CamcorderProfile.get(this.f16834o, 6)) != null) {
            return camcorderProfile.videoBitRate;
        }
        return 17000000;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17604a(int OplusGLSurfaceView_13) {
        m17611c(CameraCharacteristicsUtil.m12974a(OplusGLSurfaceView_13));
        this.f16834o = OplusGLSurfaceView_13;
        int width = m17608b().getWidth();
        int height = m17608b().getHeight();
        int iM17594d = m17594d();
        int iM17610c = m17610c();
        int i2 = CameraParameter.VideoEncoder.H265.equals(m17597g()) ? 5 : 2;
        this.f16829j = CamcorderProfile.get(this.f16834o, 6);
        CamcorderProfile camcorderProfile = this.f16829j;
        camcorderProfile.videoFrameRate = iM17610c;
        camcorderProfile.videoBitRate = iM17594d;
        camcorderProfile.videoCodec = i2;
        camcorderProfile.videoFrameWidth = width;
        camcorderProfile.videoFrameHeight = height;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17603a() {
        CameraLog.m12962c("RecorderHelper", "startRecording Begin");
        if (this.f16824e != null) {
            this.f16824e = null;
        }
        m17602l();
        m17600j();
        this.f16832m = new VideoRecorder(true, 0.0f);
        this.f16832m.m12734c(false);
        this.f16832m.m12750h(false);
        this.f16832m.m12752i(false);
        this.f16832m.m12754j(true);
        this.f16832m.m12721a(false);
        this.f16832m.m12717a(String.valueOf(this.f16834o), this.f16829j);
        Location locationMo10595y = this.f16822c.mo10595y();
        if (locationMo10595y != null) {
            this.f16832m.m12702a((float) locationMo10595y.getLatitude(), (float) locationMo10595y.getLongitude());
        }
        this.f16843x = this.f16822c.mo10591u();
        this.f16832m.m12759o(this.f16843x % 360);
        ParcelFileDescriptor parcelFileDescriptor = this.f16831l;
        if (parcelFileDescriptor != null) {
            this.f16832m.m12714a(parcelFileDescriptor.getFileDescriptor());
        } else {
            this.f16832m.m12727b(this.f16827h);
        }
        long jM11129c = Storage.m11129c(Storage.f12095u);
        long OplusGLSurfaceView_15 = "on".equals(Storage.f12095u) ? STMobileHumanActionNative.ST_MOBILE_BODY_ACTION1 : 0L;
        if (OplusGLSurfaceView_15 > 0 && OplusGLSurfaceView_15 < jM11129c) {
            jM11129c = OplusGLSurfaceView_15;
        }
        this.f16832m.m12706a(jM11129c);
        this.f16832m.m12710a((VideoRecorder.COUIBaseListPopupWindow_12) this.f16833n);
        this.f16832m.m12712a((VideoRecorder.COUIBaseListPopupWindow_10) this.f16833n);
        this.f16832m.m12711a((VideoRecorder.COUIBaseListPopupWindow_11) this.f16833n);
        this.f16832m.m12709a(this);
        try {
            this.f16832m.m12740e();
            this.f16832m.m12730b();
        } catch (IOException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        this.f16837r = true;
        this.f16835p = 0;
        this.f16836q = 0;
        CameraLog.m12962c("RecorderHelper", "startRecording End");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public boolean m17607a(boolean z) {
        CameraLog.m12962c("RecorderHelper", "stopRecording Begin");
        if (!this.f16837r) {
            CameraLog.m12967f("RecorderHelper", "stopRecording, mbRecording is false, so return!");
            return z;
        }
        byte[] bArr = this.f16824e;
        if (bArr != null) {
            m17606a(bArr);
            this.f16824e = null;
            this.f16825f.close();
            this.f16825f.block(50L);
        }
        this.f16837r = false;
        VideoRecorder c2670x = this.f16832m;
        if (c2670x != null) {
            c2670x.m12735c();
            this.f16832m.m12710a((VideoRecorder.COUIBaseListPopupWindow_12) null);
            this.f16832m.m12712a((VideoRecorder.COUIBaseListPopupWindow_10) null);
            this.f16832m.m12711a((VideoRecorder.COUIBaseListPopupWindow_11) null);
            this.f16832m.m12709a((VideoRecorder.COUIBaseListPopupWindow_8) null);
        }
        boolean z2 = true;
        if (z && m17595e()) {
            Thumbnail.IntrinsicsJvm.kt_5 dVar = new Thumbnail.IntrinsicsJvm.kt_5();
            dVar.f18298k = 1;
            m17592a(dVar);
            m17602l();
            dVar.f18291d = this.f16828i;
            this.f16823d.mo18093a(dVar, false);
            if (dVar.f18291d != null) {
                String strM24381b = Util.m24381b(dVar.f18291d);
                dVar.f18289b = this.f16843x;
                this.f16823d.mo18098a(strM24381b, dVar.f18289b);
            }
        } else {
            m17602l();
            m17593b(this.f16827h);
            this.f16823d.mo18199d(false);
            z2 = false;
        }
        this.f16835p = 0;
        CameraLog.m12962c("RecorderHelper", "stopRecording End");
        return z2;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private boolean m17595e() {
        VideoRecorder c2670x = this.f16832m;
        return c2670x != null && c2670x.m12723a();
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public Size m17608b() {
        String strM17598h = m17598h();
        if ("video_size_4kuhd".equals(strM17598h)) {
            if (this.f16840u) {
                this.f16826g = new Size(VideoMode.VIDEO_1080P_WIDTH, VideoMode.VIDEO_1080P_HEIGHT);
            } else {
                this.f16826g = new Size(VideoMode.VIDEO_4K_FRAME_WIDTH, VideoMode.VIDEO_4K_FRAME_HEIGHT);
            }
        } else if ("video_size_1080p".equals(strM17598h)) {
            this.f16826g = new Size(VideoMode.VIDEO_1080P_WIDTH, VideoMode.VIDEO_1080P_HEIGHT);
        } else {
            this.f16826g = new Size(VideoMode.VIDEO_720P_WIDTH, VideoMode.VIDEO_720P_HEIGHT);
        }
        return this.f16826g;
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private int m17596f() {
        return this.f16836q;
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private String m17597g() {
        return this.f16820a.getString(R.string.camera_video_codec_default_value);
    }

    /* renamed from: COUIBaseListPopupWindow_10 */
    private String m17598h() {
        return CameraConfig.getConfigStringValue(ConfigDataBase.KEY_STAR_VIDEO_SIZE_TYPE);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private String m17591a(long OplusGLSurfaceView_15) {
        return new SimpleDateFormat(this.f16820a.getResources().getString(R.string.camera_video_file_name_format), Locale.US).format(new Date(OplusGLSurfaceView_15));
    }

    /* renamed from: OplusGLSurfaceView_13 */
    private String m17599i() {
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

    /* renamed from: OplusGLSurfaceView_15 */
    private void m17600j() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strM17591a = m17591a(jCurrentTimeMillis);
        String str = strM17591a + ".mp4";
        this.f16827h = m17599i() + str;
        this.f16830k = new ContentValues(7);
        this.f16830k.put("title", strM17591a);
        this.f16830k.put("_display_name", str);
        this.f16830k.put("datetaken", Long.valueOf(jCurrentTimeMillis));
        this.f16830k.put("mime_type", MimeTypes.VIDEO_MP4);
        this.f16830k.put("relative_path", Storage.m11140e(null));
        this.f16830k.put("is_pending", (Integer) 1);
        Context context = this.f16820a;
        this.f16828i = MediaStoreUtil.m24650a(context, context.getContentResolver(), this.f16830k);
        try {
            this.f16831l = this.f16820a.getContentResolver().openFileDescriptor(this.f16828i, "rw");
        } catch (FileNotFoundException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        Size sizeM17608b = m17608b();
        if (sizeM17608b != null) {
            this.f16830k.put("resolution", sizeM17608b.getWidth() + "x" + sizeM17608b.getHeight());
            this.f16830k.put("width", Integer.toString(sizeM17608b.getWidth()));
            this.f16830k.put("height", Integer.toString(sizeM17608b.getHeight()));
        }
        Location locationMo10595y = this.f16822c.mo10595y();
        if (locationMo10595y != null) {
            this.f16830k.put("latitude", Double.valueOf(locationMo10595y.getLatitude()));
            this.f16830k.put("longitude", Double.valueOf(locationMo10595y.getLongitude()));
        }
        CameraLog.m12954a("RecorderHelper", "generateVideoFilename, New video filename: " + this.f16827h + ", mCurrentVideoUri: " + this.f16828i + ", videoSize: " + sizeM17608b);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    private void m17593b(String str) {
        CameraLog.m12954a("RecorderHelper", "deleteVideoFile, fileName: " + str);
        if (str == null) {
            return;
        }
        File file = new File(str);
        if (file.exists() && !file.delete()) {
            CameraLog.m12954a("RecorderHelper", "deleteVideoFile, Could not delete " + str);
        }
        if (this.f16828i != null) {
            try {
                try {
                    this.f16820a.getContentResolver().delete(this.f16828i, null, null);
                } catch (Exception COUIBaseListPopupWindow_8) {
                    COUIBaseListPopupWindow_8.printStackTrace();
                }
            } finally {
                this.f16828i = null;
            }
        }
    }

    /* renamed from: OplusGLSurfaceView_5 */
    private long m17601k() {
        CameraLog.m12954a("RecorderHelper", "calcVideoDuration, mEncodeFrameNumber: " + this.f16836q + ", time: " + (m17596f() / m17610c()));
        return (int) (r0 * 1000.0f);
    }

    /* renamed from: OplusGLSurfaceView_14 */
    private void m17602l() throws IOException {
        ParcelFileDescriptor parcelFileDescriptor = this.f16831l;
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
            } catch (IOException COUIBaseListPopupWindow_8) {
                CameraLog.m12965d("RecorderHelper", "closeVideoFileDescriptor, Fail to close fd", COUIBaseListPopupWindow_8);
            }
            this.f16831l = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00a4 A[PHI: r2 r8
      0x00a4: PHI (r2v26 android.media.MediaMetadataRetriever) = (r2v13 android.media.MediaMetadataRetriever), (r2v27 android.media.MediaMetadataRetriever) binds: [B:31:0x00b6, B:22:0x0098] A[DONT_GENERATE, DONT_INLINE]
      0x00a4: PHI (r8v3 long) = (r8v1 long), (r8v8 long) binds: [B:31:0x00b6, B:22:0x0098] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ee A[Catch: Exception -> 0x0176, TryCatch #4 {Exception -> 0x0176, blocks: (B:37:0x00ea, B:39:0x00ee, B:41:0x00ff, B:42:0x010b, B:44:0x010f, B:46:0x0113, B:50:0x0138, B:51:0x013d, B:47:0x0133), top: B:69:0x00ea, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x018c  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean m17592a(com.oplus.camera.p172ui.control.Thumbnail.IntrinsicsJvm.kt_5 r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.timelapsepro.RecorderHelper.m17592a(com.oplus.camera.ui.control.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_5):boolean");
    }

    @Override // com.oplus.camera.capmode.VideoRecorder.COUIBaseListPopupWindow_8
    /* renamed from: PlatformImplementations.kt_3 */
    public long mo12761a(MediaCodec.BufferInfo bufferInfo) {
        CameraLog.m12954a("RecorderHelper", "computePresentationTime, mEncodeFrameNumber: " + this.f16836q);
        this.f16836q = this.f16836q + 1;
        return (this.f16836q * 1000000) / m17610c();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17606a(byte[] bArr) {
        if (this.f16824e == null) {
            this.f16824e = new byte[bArr.length];
        }
        System.arraycopy(bArr, 0, this.f16824e, 0, bArr.length);
        this.f16832m.m12722a(bArr);
    }

    /* renamed from: IntrinsicsJvm.kt_4 */
    public void m17609b(boolean z) {
        this.f16839t = z;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m17611c(boolean z) {
        this.f16840u = z;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    public void m17612d(boolean z) {
        VideoRecorder c2670x = this.f16832m;
        if (c2670x != null) {
            c2670x.m12729b(z);
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m17605a(String str) {
        String str2 = this.f16841v;
        if (str2 == null || !str2.equals(str)) {
            this.f16841v = str;
            byte[] bytes = str.getBytes();
            byte[] bArrM13719a = MP4BoxHeader.m13719a(bytes.length + 8);
            byte[] bytes2 = "titl".getBytes();
            this.f16842w = new byte[bytes.length + 8];
            System.arraycopy(bArrM13719a, 0, this.f16842w, 0, bArrM13719a.length);
            System.arraycopy(bytes2, 0, this.f16842w, 4, bytes2.length);
            System.arraycopy(bytes, 0, this.f16842w, 8, bytes.length);
        }
    }
}
