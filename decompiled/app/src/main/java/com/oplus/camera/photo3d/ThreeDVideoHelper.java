package com.oplus.camera.photo3d;

import android.content.ContentValues;
import android.content.Context;
import android.location.Location;
import android.media.CamcorderProfile;
import android.net.Uri;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.util.Size;
import android.view.Surface;
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
import com.sensetime.stmobile.STMobileHumanActionNative;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: ThreeDVideoHelper.java */
/* renamed from: com.oplus.camera.photo3d.IntrinsicsJvm.kt_5 */
/* loaded from: classes2.dex */
public class ThreeDVideoHelper {

    /* renamed from: PlatformImplementations.kt_3 */
    private static final Size f15212a = new Size(VideoMode.VIDEO_1080P_WIDTH, VideoMode.VIDEO_1080P_HEIGHT);

    /* renamed from: IntrinsicsJvm.kt_4 */
    private Context f15213b;

    /* renamed from: IntrinsicsJvm.kt_3 */
    private CameraInterface f15214c;

    /* renamed from: IntrinsicsJvm.kt_5 */
    private CameraUIInterface f15215d;

    /* renamed from: COUIBaseListPopupWindow_8 */
    private CamcorderProfile f15216e = null;

    /* renamed from: COUIBaseListPopupWindow_12 */
    private ContentValues f15217f = null;

    /* renamed from: COUIBaseListPopupWindow_11 */
    private ParcelFileDescriptor f15218g = null;

    /* renamed from: COUIBaseListPopupWindow_10 */
    private VideoRecorder f15219h = null;

    /* renamed from: OplusGLSurfaceView_13 */
    private Size f15220i = null;

    /* renamed from: OplusGLSurfaceView_15 */
    private Uri f15221j = null;

    /* renamed from: OplusGLSurfaceView_5 */
    private String f15222k = null;

    /* renamed from: OplusGLSurfaceView_14 */
    private boolean f15223l = false;

    /* renamed from: OplusGLSurfaceView_6 */
    private int f15224m = 0;

    /* renamed from: OplusGLSurfaceView_11 */
    private IntrinsicsJvm.kt_4 f15225n;

    /* renamed from: o */
    private final Handler f15226o;

    /* compiled from: ThreeDVideoHelper.java */
    /* renamed from: com.oplus.camera.photo3d.IntrinsicsJvm.kt_5$IntrinsicsJvm.kt_4 */
    public interface IntrinsicsJvm.kt_4 {
        /* renamed from: PlatformImplementations.kt_3 */
        void mo15221a(Surface surface);
    }

    public ThreeDVideoHelper(Context context, Handler handler, CameraInterface interfaceC2646a, CameraUIInterface cameraUIInterface) {
        this.f15213b = context;
        this.f15226o = handler;
        this.f15214c = interfaceC2646a;
        this.f15215d = cameraUIInterface;
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15240a() throws IllegalStateException, IOException, IllegalArgumentException {
        CameraLog.m12962c("ThreeDVideoHelper", "startRecording E");
        m15241a(0);
        m15237e();
        m15238f();
        this.f15219h = new VideoRecorder(true, this.f15214c.mo10536al());
        this.f15219h.m12750h(false);
        this.f15219h.m12752i(false);
        this.f15219h.m12717a(String.valueOf(0), this.f15216e);
        this.f15215d.mo18165b(this.f15216e.videoFrameWidth, this.f15216e.videoFrameHeight);
        Location locationMo10595y = this.f15214c.mo10595y();
        if (locationMo10595y != null) {
            this.f15219h.m12702a((float) locationMo10595y.getLatitude(), (float) locationMo10595y.getLongitude());
        }
        this.f15219h.m12759o(this.f15214c.mo10592v() % 360);
        ParcelFileDescriptor parcelFileDescriptor = this.f15218g;
        if (parcelFileDescriptor != null) {
            this.f15219h.m12714a(parcelFileDescriptor.getFileDescriptor());
        } else {
            this.f15219h.m12727b(this.f15222k);
        }
        this.f15219h.m12746g(this.f15216e.videoBitRate);
        long jM11129c = Storage.m11129c(Storage.f12095u);
        long OplusGLSurfaceView_15 = "on".equals(Storage.f12095u) ? STMobileHumanActionNative.ST_MOBILE_BODY_ACTION1 : 0L;
        if (OplusGLSurfaceView_15 > 0 && OplusGLSurfaceView_15 < jM11129c) {
            jM11129c = OplusGLSurfaceView_15;
        }
        PlatformImplementations.kt_3 aVar = new PlatformImplementations.kt_3();
        this.f15219h.m12706a(jM11129c);
        this.f15219h.m12710a((VideoRecorder.COUIBaseListPopupWindow_12) aVar);
        this.f15219h.m12712a((VideoRecorder.COUIBaseListPopupWindow_10) aVar);
        this.f15219h.m12711a((VideoRecorder.COUIBaseListPopupWindow_11) aVar);
        this.f15219h.m12708a((VideoRecorder.IntrinsicsJvm.kt_5) aVar);
        try {
            this.f15219h.m12740e();
            this.f15219h.m12730b();
        } catch (IOException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        this.f15223l = true;
        CameraLog.m12962c("ThreeDVideoHelper", "startRecording X");
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15241a(int OplusGLSurfaceView_13) {
        this.f15224m = OplusGLSurfaceView_13;
        int width = m15243b().getWidth();
        int height = m15243b().getHeight();
        int iM15236d = m15236d();
        this.f15216e = CamcorderProfile.get(this.f15224m, 6);
        CamcorderProfile camcorderProfile = this.f15216e;
        camcorderProfile.videoFrameRate = 30;
        camcorderProfile.videoBitRate = iM15236d;
        camcorderProfile.videoCodec = 2;
        camcorderProfile.videoFrameWidth = width;
        camcorderProfile.videoFrameHeight = height;
    }

    /* renamed from: IntrinsicsJvm.kt_5 */
    private int m15236d() {
        CamcorderProfile camcorderProfile;
        if (!Util.m24169C() || (camcorderProfile = CamcorderProfile.get(this.f15224m, 6)) == null) {
            return 17000000;
        }
        return camcorderProfile.videoBitRate;
    }

    /* renamed from: COUIBaseListPopupWindow_8 */
    private void m15237e() throws IOException {
        ParcelFileDescriptor parcelFileDescriptor = this.f15218g;
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
            } catch (IOException COUIBaseListPopupWindow_8) {
                CameraLog.m12965d("ThreeDVideoHelper", "closeVideoFileDescriptor, Fail to close fd", COUIBaseListPopupWindow_8);
            }
            this.f15218g = null;
        }
    }

    /* renamed from: COUIBaseListPopupWindow_12 */
    private void m15238f() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strM15231a = m15231a(jCurrentTimeMillis);
        String str = strM15231a + ".mp4";
        this.f15222k = m15239g() + str;
        this.f15217f = new ContentValues(7);
        this.f15217f.put("title", strM15231a);
        this.f15217f.put("_display_name", str);
        this.f15217f.put("datetaken", Long.valueOf(jCurrentTimeMillis));
        this.f15217f.put("mime_type", MimeTypes.VIDEO_MP4);
        this.f15217f.put("relative_path", Storage.m11140e(null));
        this.f15217f.put("is_pending", (Integer) 1);
        Context context = this.f15213b;
        this.f15221j = MediaStoreUtil.m24650a(context, context.getContentResolver(), this.f15217f);
        try {
            this.f15218g = this.f15213b.getContentResolver().openFileDescriptor(this.f15221j, "rw");
        } catch (FileNotFoundException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8.printStackTrace();
        }
        Size sizeM15243b = m15243b();
        if (sizeM15243b != null) {
            this.f15217f.put("resolution", sizeM15243b.getWidth() + "x" + sizeM15243b.getHeight());
            this.f15217f.put("width", Integer.toString(sizeM15243b.getWidth()));
            this.f15217f.put("height", Integer.toString(sizeM15243b.getHeight()));
        }
        Location locationMo10595y = this.f15214c.mo10595y();
        if (locationMo10595y != null) {
            this.f15217f.put("latitude", Double.valueOf(locationMo10595y.getLatitude()));
            this.f15217f.put("longitude", Double.valueOf(locationMo10595y.getLongitude()));
        }
        CameraLog.m12954a("ThreeDVideoHelper", "generateVideoFilename, New video filename: " + this.f15222k + ", mCurrentVideoUri: " + this.f15221j + ", videoSize: " + sizeM15243b);
    }

    /* renamed from: PlatformImplementations.kt_3 */
    private String m15231a(long OplusGLSurfaceView_15) {
        return new SimpleDateFormat(this.f15213b.getResources().getString(R.string.camera_video_file_name_format), Locale.US).format(new Date(OplusGLSurfaceView_15));
    }

    /* renamed from: COUIBaseListPopupWindow_11 */
    private String m15239g() {
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

    /* renamed from: IntrinsicsJvm.kt_4 */
    public Size m15243b() {
        if (this.f15220i == null) {
            this.f15220i = CameraConfig.getSizeConfigValue(ConfigDataBase.KEY_3D_PHOTO_VIDEO_SIZE);
            if (this.f15220i == null) {
                this.f15220i = f15212a;
            }
        }
        return this.f15220i;
    }

    /* renamed from: IntrinsicsJvm.kt_3 */
    public void m15244c() throws Throwable {
        CameraLog.m12962c("ThreeDVideoHelper", "stopRecording E");
        if (!this.f15223l) {
            CameraLog.m12967f("ThreeDVideoHelper", "stopRecording, mbRecording is false, so return!");
            return;
        }
        this.f15223l = false;
        VideoRecorder c2670x = this.f15219h;
        if (c2670x != null) {
            c2670x.m12735c();
            this.f15219h.m12710a((VideoRecorder.COUIBaseListPopupWindow_12) null);
            this.f15219h.m12712a((VideoRecorder.COUIBaseListPopupWindow_10) null);
            this.f15219h.m12711a((VideoRecorder.COUIBaseListPopupWindow_11) null);
            this.f15219h.m12708a((VideoRecorder.IntrinsicsJvm.kt_5) null);
        }
        Thumbnail.IntrinsicsJvm.kt_5 dVar = new Thumbnail.IntrinsicsJvm.kt_5();
        dVar.f18298k = 1;
        m15233a(dVar);
        m15237e();
        dVar.f18291d = this.f15221j;
        this.f15215d.mo18093a(dVar, false);
        CameraLog.m12962c("ThreeDVideoHelper", "stopRecording X");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0099 A[PHI: r2 r8
      0x0099: PHI (r2v23 android.media.MediaMetadataRetriever) = (r2v13 android.media.MediaMetadataRetriever), (r2v24 android.media.MediaMetadataRetriever) binds: [B:31:0x00ab, B:22:0x008d] A[DONT_GENERATE, DONT_INLINE]
      0x0099: PHI (r8v3 long) = (r8v1 long), (r8v8 long) binds: [B:31:0x00ab, B:22:0x008d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d5 A[Catch: Exception -> 0x013c, TryCatch #1 {Exception -> 0x013c, blocks: (B:36:0x00d1, B:38:0x00d5, B:40:0x00e6, B:41:0x0103), top: B:55:0x00d1 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0152  */
    /* renamed from: PlatformImplementations.kt_3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean m15233a(com.oplus.camera.p172ui.control.Thumbnail.IntrinsicsJvm.kt_5 r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.camera.photo3d.ThreeDVideoHelper.m15233a(com.oplus.camera.ui.control.COUIBaseListPopupWindow_8$IntrinsicsJvm.kt_5):boolean");
    }

    /* compiled from: ThreeDVideoHelper.java */
    /* renamed from: com.oplus.camera.photo3d.IntrinsicsJvm.kt_5$PlatformImplementations.kt_3 */
    class PlatformImplementations.kt_3 implements VideoRecorder.IntrinsicsJvm.kt_5, VideoRecorder.COUIBaseListPopupWindow_12, VideoRecorder.COUIBaseListPopupWindow_11, VideoRecorder.COUIBaseListPopupWindow_10 {
        PlatformImplementations.kt_3() {
        }

        @Override // com.oplus.camera.capmode.VideoRecorder.COUIBaseListPopupWindow_10
        public void onInfo(Object obj, final int OplusGLSurfaceView_13, int i2) {
            CameraLog.m12959b("ThreeDVideoHelper", "onInfo, what: " + OplusGLSurfaceView_13);
            ThreeDVideoHelper.this.f15226o.post(new Runnable() { // from class: com.oplus.camera.photo3d.IntrinsicsJvm.kt_5.PlatformImplementations.kt_3.1
                @Override // java.lang.Runnable
                public void run() throws Throwable {
                    int i3 = OplusGLSurfaceView_13;
                    if ((800 == i3 || 800 == i3 || 802 == i3) && ThreeDVideoHelper.this.f15223l) {
                        ThreeDVideoHelper.this.m15244c();
                    }
                }
            });
        }

        @Override // com.oplus.camera.capmode.VideoRecorder.COUIBaseListPopupWindow_12
        public void onError(Object obj, final int OplusGLSurfaceView_13, int i2) {
            CameraLog.m12967f("ThreeDVideoHelper", "onError, what: " + OplusGLSurfaceView_13);
            ThreeDVideoHelper.this.f15226o.post(new Runnable() { // from class: com.oplus.camera.photo3d.IntrinsicsJvm.kt_5.PlatformImplementations.kt_3.2
                @Override // java.lang.Runnable
                public void run() throws Throwable {
                    int i3 = OplusGLSurfaceView_13;
                    if ((1100 == i3 || 1101 == i3) && ThreeDVideoHelper.this.f15223l) {
                        ThreeDVideoHelper.this.m15244c();
                    }
                }
            });
        }

        @Override // com.oplus.camera.capmode.VideoRecorder.COUIBaseListPopupWindow_11
        public void onException(final int OplusGLSurfaceView_13) {
            CameraLog.m12967f("ThreeDVideoHelper", "onException, exceptionCode: " + OplusGLSurfaceView_13);
            ThreeDVideoHelper.this.f15226o.post(new Runnable() { // from class: com.oplus.camera.photo3d.IntrinsicsJvm.kt_5.PlatformImplementations.kt_3.3
                @Override // java.lang.Runnable
                public void run() throws Throwable {
                    if (1 == OplusGLSurfaceView_13 && ThreeDVideoHelper.this.f15223l) {
                        ThreeDVideoHelper.this.m15244c();
                    }
                }
            });
        }

        @Override // com.oplus.camera.capmode.VideoRecorder.IntrinsicsJvm.kt_5
        /* renamed from: PlatformImplementations.kt_3 */
        public void mo12760a(Surface surface) {
            CameraLog.m12959b("ThreeDVideoHelper", "onEncodeSurfaceCreated, surface: " + surface);
            if (ThreeDVideoHelper.this.f15225n != null) {
                ThreeDVideoHelper.this.f15225n.mo15221a(surface);
            }
        }
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public void m15242a(IntrinsicsJvm.kt_4 bVar) {
        this.f15225n = bVar;
    }
}
