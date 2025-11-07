package com.oplus.camera.p141e;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import java.util.HashMap;

/* compiled from: CameraMetadataKey.java */
/* renamed from: com.oplus.camera.COUIBaseListPopupWindow_8.IntrinsicsJvm.kt_4 */
/* loaded from: classes2.dex */
public class CameraMetadataKey {

    /* renamed from: bF */
    private HashMap<String, CaptureRequest.Key<?>> f13370bF;

    /* renamed from: bG */
    private HashMap<String, CaptureResult.Key<?>> f13371bG;

    /* renamed from: PlatformImplementations.kt_3 */
    public static final CaptureRequest.Key<byte[]> f13261a = new CaptureRequest.Key<>("com.oplus.caller.package.name", byte[].class);

    /* renamed from: IntrinsicsJvm.kt_4 */
    public static final CaptureRequest.Key<Integer> f13314b = new CaptureRequest.Key<>("com.oplus.orms.for.video.blur", Integer.class);

    /* renamed from: IntrinsicsJvm.kt_3 */
    public static final CaptureRequest.Key<float[]> f13346c = new CaptureRequest.Key<>("com.oplus.phone.temperature", float[].class);

    /* renamed from: IntrinsicsJvm.kt_5 */
    public static final CaptureRequest.Key<Integer> f13347d = new CaptureRequest.Key<>("com.oplus.front.flash.mode.auto", Integer.class);

    /* renamed from: COUIBaseListPopupWindow_8 */
    public static final CaptureRequest.Key<Integer> f13348e = new CaptureRequest.Key<>("com.oplus.capture.request.idx", Integer.TYPE);

    /* renamed from: COUIBaseListPopupWindow_12 */
    public static final CaptureResult.Key<int[]> f13349f = new CaptureResult.Key<>("com.qti.stats_control.is_ais_needed", int[].class);

    /* renamed from: COUIBaseListPopupWindow_11 */
    public static final CaptureResult.Key<int[]> f13350g = new CaptureResult.Key<>("com.qti.stats_control.ais_motion_type", int[].class);

    /* renamed from: COUIBaseListPopupWindow_10 */
    public static final CaptureResult.Key<int[]> f13351h = new CaptureResult.Key<>("com.qti.stats_control.ais_is_within_trigger_rgn", int[].class);

    /* renamed from: OplusGLSurfaceView_13 */
    public static final CaptureResult.Key<Byte> f13352i = new CaptureResult.Key<>("com.oplus.is.pdaf.done", Byte.TYPE);

    /* renamed from: OplusGLSurfaceView_15 */
    public static final CaptureResult.Key<int[]> f13353j = new CaptureResult.Key<>("com.oplus.salientobj.move.info", int[].class);

    /* renamed from: OplusGLSurfaceView_5 */
    public static final CaptureRequest.Key<int[]> f13354k = new CaptureRequest.Key<>("com.oplus.BlurlessFrameNum", int[].class);

    /* renamed from: OplusGLSurfaceView_14 */
    public static final CaptureResult.Key<Long> f13355l = new CaptureResult.Key<>("com.oplus.sensor.timestamp", Long.TYPE);

    /* renamed from: OplusGLSurfaceView_6 */
    public static final CaptureResult.Key<Long> f13356m = new CaptureResult.Key<>("com.oplus.ref.frame.timestamp", Long.TYPE);

    /* renamed from: OplusGLSurfaceView_11 */
    public static final CaptureResult.Key<int[]> f13357n = new CaptureResult.Key<>("com.oplus.camera.ois.value.oistoeis", int[].class);

    /* renamed from: o */
    public static final CaptureResult.Key<int[]> f13358o = new CaptureResult.Key<>("com.oplus.camera.gyro.value.gyrotoeis", int[].class);

    /* renamed from: p */
    public static CaptureRequest.Key<int[]> f13359p = new CaptureRequest.Key<>("org.codeaurora.qcamera3.iso_exp_priority.select_priority", int[].class);

    /* renamed from: q */
    public static CaptureRequest.Key<long[]> f13360q = new CaptureRequest.Key<>("org.codeaurora.qcamera3.iso_exp_priority.use_iso_exp_priority", long[].class);

    /* renamed from: r */
    public static final CaptureRequest.Key<Long> f13361r = new CaptureRequest.Key<>("com.oplus.exiftag.datetime", Long.class);

    /* renamed from: s */
    public static final CaptureRequest.Key<byte[]> f13362s = new CaptureRequest.Key<>("com.oplus.exiftag.offsettime", byte[].class);

    /* renamed from: t */
    public static final CaptureResult.Key<int[]> f13363t = new CaptureResult.Key<>("com.oplus.sod.track.region", int[].class);

    /* renamed from: u */
    public static final CameraCharacteristics.Key<int[]> f13364u = new CameraCharacteristics.Key<>("com.oplus.custom.jpeg.size", int[].class);

    /* renamed from: v */
    public static final CameraCharacteristics.Key<int[]> f13365v = new CameraCharacteristics.Key<>("com.oplus.supported.cameraid.type", int[].class);

    /* renamed from: w */
    public static final CameraCharacteristics.Key<int[]> f13366w = new CameraCharacteristics.Key<>("com.mediatek.cshotfeature.availableCShotModes", int[].class);

    /* renamed from: x */
    public static final CameraCharacteristics.Key<int[]> f13367x = new CameraCharacteristics.Key<>("com.mediatek.control.capture.early.notification.support", int[].class);

    /* renamed from: y */
    public static final CameraCharacteristics.Key<int[]> f13368y = new CameraCharacteristics.Key<>("com.mediatek.bgservicefeature.availableprereleasemodes", int[].class);

    /* renamed from: z */
    public static final CameraCharacteristics.Key<int[]> f13369z = new CameraCharacteristics.Key<>("com.oplus.superEis.available.target.fps.ranges", int[].class);

    /* renamed from: A */
    public static final CaptureRequest.Key<Integer> f13235A = new CaptureRequest.Key<>("com.oplus.long.exposure.scene.type", Integer.TYPE);

    /* renamed from: B */
    public static final CaptureRequest.Key<int[]> f13236B = new CaptureRequest.Key<>("com.mediatek.cshotfeature.capture", int[].class);

    /* renamed from: C */
    public static final CaptureRequest.Key<int[]> f13237C = new CaptureRequest.Key<>("com.mediatek.control.capture.early.notification.trigger", int[].class);

    /* renamed from: D */
    public static final CaptureRequest.Key<Long> f13238D = new CaptureRequest.Key<>("com.oplus.sensor.exposureTime", Long.class);

    /* renamed from: E */
    public static final CaptureResult.Key<int[]> f13239E = new CaptureResult.Key<>("com.oplus.iris.aperture.switching", int[].class);

    /* renamed from: F */
    public static final CaptureResult.Key<int[]> f13240F = new CaptureResult.Key<>("com.oplus.beauty3d.analyses.result", int[].class);

    /* renamed from: G */
    public static final CaptureResult.Key<int[]> f13241G = new CaptureResult.Key<>("com.oplus.beauty3d.analyses.ffd", int[].class);

    /* renamed from: H */
    public static final CaptureResult.Key<int[]> f13242H = new CaptureResult.Key<>("com.oplus.beauty3d.custom.result", int[].class);

    /* renamed from: I */
    public static final CaptureResult.Key<int[]> f13243I = new CaptureResult.Key<>("com.oplus.beauty3d.scan.result", int[].class);

    /* renamed from: J */
    public static final CaptureResult.Key<int[]> f13244J = new CaptureResult.Key<>("com.oplus.zoom.state", int[].class);

    /* renamed from: K */
    public static final CaptureResult.Key<Integer> f13245K = new CaptureResult.Key<>("display.iso", Integer.class);

    /* renamed from: L */
    public static final CaptureResult.Key<Integer> f13246L = new CaptureResult.Key<>("post.process", Integer.class);

    /* renamed from: M */
    public static final CaptureResult.Key<byte[]> f13247M = new CaptureResult.Key<>("com.oplus.SensorName", byte[].class);

    /* renamed from: N */
    public static final CaptureResult.Key<int[]> f13248N = new CaptureResult.Key<>("com.mediatek.control.capture.next.ready", int[].class);

    /* renamed from: O */
    public static final CaptureResult.Key<int[]> f13249O = new CaptureResult.Key<>("com.oplus.fb.face.info", int[].class);

    /* renamed from: P */
    public static final CaptureResult.Key<int[]> f13250P = new CaptureResult.Key<>("com.oplus.preview.ffd", int[].class);

    /* renamed from: Q */
    public static final CaptureResult.Key<Integer> f13251Q = new CaptureResult.Key<>("scene.binning", Integer.class);

    /* renamed from: R */
    public static final CaptureResult.Key<Integer> f13252R = new CaptureResult.Key<>("com.oplus.control.face.dr", Integer.class);

    /* renamed from: S */
    public static final CaptureResult.Key<Integer> f13253S = new CaptureResult.Key<>("capture.state", Integer.class);

    /* renamed from: T */
    public static final CaptureResult.Key<int[]> f13254T = new CaptureResult.Key<>("org.codeaurora.qcamera3.manualWB.color_temperature", int[].class);

    /* renamed from: U */
    public static final CaptureResult.Key<float[]> f13255U = new CaptureResult.Key<>("com.oplus.rawhdr.isp.luxindex", float[].class);

    /* renamed from: V */
    public static final CaptureResult.Key<float[]> f13256V = new CaptureResult.Key<>("com.qti.chi.statsaec.AecLux", float[].class);

    /* renamed from: W */
    public static final CaptureResult.Key<int[]> f13257W = new CaptureResult.Key<>("com.mediatek.3afeature.aeLuxIndex", int[].class);

    /* renamed from: X */
    public static final CaptureResult.Key<int[]> f13258X = new CaptureResult.Key<>("com.oplus.focus.is.depth.based", int[].class);

    /* renamed from: Y */
    public static final CaptureResult.Key<int[]> f13259Y = new CaptureResult.Key<>("com.oplus.flashtrigger.state", int[].class);

    /* renamed from: Z */
    public static final CaptureResult.Key<int[]> f13260Z = new CaptureResult.Key<>("com.oplus.MicroDistance", int[].class);

    /* renamed from: aa */
    public static final CaptureResult.Key<int[]> f13288aa = new CaptureResult.Key<>("com.oplus.mono.camera.occlusion.state", int[].class);

    /* renamed from: ab */
    public static final CaptureResult.Key<int[]> f13289ab = new CaptureResult.Key<>("com.qti.stats_control.is_lls_needed", int[].class);

    /* renamed from: ac */
    public static final CaptureResult.Key<int[]> f13290ac = new CaptureResult.Key<>("com.oplus.lls.state", int[].class);

    /* renamed from: ad */
    public static final CaptureResult.Key<int[]> f13291ad = new CaptureResult.Key<>("com.oplus.night.shake.state", int[].class);

    /* renamed from: ae */
    public static final CaptureResult.Key<int[]> f13292ae = new CaptureResult.Key<>("focus.distance", int[].class);

    /* renamed from: af */
    public static final CaptureResult.Key<int[]> f13293af = new CaptureResult.Key<>("com.oplus.facebeauty.level", int[].class);

    /* renamed from: ag */
    public static final CaptureResult.Key<int[]> f13294ag = new CaptureResult.Key<>("com.oplus.facebeauty.custom", int[].class);

    /* renamed from: ah */
    public static final CaptureResult.Key<int[]> f13295ah = new CaptureResult.Key<>("com.oplus.manualWB.color_temperature", int[].class);

    /* renamed from: ai */
    public static final CaptureResult.Key<Integer> f13296ai = new CaptureResult.Key<>("org.quic.camera.eislookahead.FrameDelay", Integer.TYPE);

    /* renamed from: aj */
    public static final CaptureResult.Key<int[]> f13297aj = new CaptureResult.Key<>("com.oplus.ai.scene.app.data", int[].class);

    /* renamed from: ak */
    public static final CaptureResult.Key<int[]> f13298ak = new CaptureResult.Key<>("com.oplus.portrait.bokeh.state", int[].class);

    /* renamed from: al */
    public static final CaptureResult.Key<byte[]> f13299al = new CaptureResult.Key<>("com.oplus.tof.info", byte[].class);

    /* renamed from: am */
    public static final CaptureResult.Key<int[]> f13300am = new CaptureResult.Key<>("com.oplus.af.mw.info", int[].class);

    /* renamed from: an */
    public static final CaptureResult.Key<Integer> f13301an = new CaptureResult.Key<>("com.oplus.ai.scene.app.data.video", Integer.class);

    /* renamed from: ao */
    public static final CaptureResult.Key<Integer> f13302ao = new CaptureResult.Key<>("com.oplus.camera.lens.dirty", Integer.class);

    /* renamed from: ap */
    public static final CaptureResult.Key<Integer> f13303ap = new CaptureResult.Key<>("com.oplus.aps.sat.snapshot.sensors.number", Integer.class);

    /* renamed from: aq */
    public static final CaptureResult.Key<int[]> f13304aq = new CaptureResult.Key<>("com.oplus.aps.sat.preview.sensors.mask", int[].class);

    /* renamed from: ar */
    public static final CaptureResult.Key<int[]> f13305ar = new CaptureResult.Key<>("com.oplus.video.neon.tunning.params", int[].class);

    /* renamed from: as */
    public static final CaptureResult.Key<int[]> f13306as = new CaptureResult.Key<>("com.oplus.video.blur.tunning.params", int[].class);

    /* renamed from: at */
    public static final CaptureResult.Key<Integer> f13307at = new CaptureResult.Key<>("com.oplus.explorer.hw.capacity", Integer.class);

    /* renamed from: au */
    public static final CameraCharacteristics.Key<int[]> f13308au = new CameraCharacteristics.Key<>("com.oplus.bokeh.picture.size", int[].class);

    /* renamed from: av */
    public static final CaptureResult.Key<Integer> f13309av = new CaptureResult.Key<>("com.oplus.capture.request.need.preview.stream", Integer.class);

    /* renamed from: aw */
    public static final CaptureRequest.Key<int[]> f13310aw = new CaptureRequest.Key<>("com.mediatek.configure.setting.initrequest", int[].class);

    /* renamed from: ax */
    public static final CameraCharacteristics.Key<int[]> f13311ax = new CameraCharacteristics.Key<>("com.mediatek.hdrfeature.availableHdrModesVideo", int[].class);

    /* renamed from: ay */
    public static final CameraCharacteristics.Key<int[]> f13312ay = new CameraCharacteristics.Key<>("com.oplus.feature.3hdr.support", int[].class);

    /* renamed from: az */
    public static final CaptureRequest.Key<int[]> f13313az = new CaptureRequest.Key<>("com.mediatek.control.capture.hintForIspTuning", int[].class);

    /* renamed from: aA */
    public static final CaptureRequest.Key<Integer> f13262aA = new CaptureRequest.Key<>("com.mediatek.control.capture.hintForIspFrameCount", Integer.class);

    /* renamed from: aB */
    public static final CaptureRequest.Key<Integer> f13263aB = new CaptureRequest.Key<>("com.mediatek.control.capture.hintForIspFrameIndex", Integer.class);

    /* renamed from: aC */
    public static final CaptureRequest.Key<int[]> f13264aC = new CaptureRequest.Key<>("com.mediatek.control.capture.packedRaw.enable", int[].class);

    /* renamed from: aD */
    public static final CaptureRequest.Key<Integer> f13265aD = new CaptureRequest.Key<>("com.mediatek.control.capture.processRaw.enable", Integer.class);

    /* renamed from: aE */
    public static final CaptureRequest.Key<int[]> f13266aE = new CaptureRequest.Key<>("com.mediatek.control.capture.raw.bpp", int[].class);

    /* renamed from: aF */
    public static final CaptureRequest.Key<Byte> f13267aF = new CaptureRequest.Key<>("org.codeaurora.qcamera3.sessionParameters.enableHVXSHDRMode", Byte.TYPE);

    /* renamed from: aG */
    public static final CameraCharacteristics.Key<float[]> f13268aG = new CameraCharacteristics.Key<>("com.oplus.custom.zoom.range", float[].class);

    /* renamed from: aH */
    public static final CameraCharacteristics.Key<float[]> f13269aH = new CameraCharacteristics.Key<>("com.oplus.expert.zoom.range", float[].class);

    /* renamed from: aI */
    public static final CameraCharacteristics.Key<float[]> f13270aI = new CameraCharacteristics.Key<>("com.oplus.ultrawide.zoom.range", float[].class);

    /* renamed from: aJ */
    public static final CameraCharacteristics.Key<float[]> f13271aJ = new CameraCharacteristics.Key<>("com.oplus.custom.video.zoom.range", float[].class);

    /* renamed from: aK */
    public static final CameraCharacteristics.Key<float[]> f13272aK = new CameraCharacteristics.Key<>("com.oplus.custom.video.60fps.zoom.range", float[].class);

    /* renamed from: aL */
    public static final CameraCharacteristics.Key<int[]> f13273aL = new CameraCharacteristics.Key<>("org.codeaurora.qcamera3.logicalCameraType.logical_camera_type", int[].class);

    /* renamed from: aM */
    public static final CameraCharacteristics.Key<int[]> f13274aM = new CameraCharacteristics.Key<>("com.oplus.logical.camera.type", int[].class);

    /* renamed from: aN */
    public static final CameraCharacteristics.Key<int[]> f13275aN = new CameraCharacteristics.Key<>("com.oplus.custom.front.portrait.size", int[].class);

    /* renamed from: aO */
    public static final CaptureRequest.Key<byte[]> f13276aO = new CaptureRequest.Key<>("com.mediatek.control.capture.ispMetaEnable", byte[].class);

    /* renamed from: aP */
    public static final CaptureRequest.Key<byte[]> f13277aP = new CaptureRequest.Key<>("com.mediatek.control.capture.ispTuningRequest", byte[].class);

    /* renamed from: aQ */
    public static final CameraCharacteristics.Key<int[]> f13278aQ = new CameraCharacteristics.Key<>("com.mediatek.control.capture.ispMetaSizeForYuv", int[].class);

    /* renamed from: aR */
    public static final CameraCharacteristics.Key<int[]> f13279aR = new CameraCharacteristics.Key<>("com.mediatek.control.capture.ispMetaSizeForRaw", int[].class);

    /* renamed from: aS */
    public static final CaptureRequest.Key<int[]> f13280aS = new CaptureRequest.Key<>("com.mediatek.control.capture.inSensorZoom.mode", int[].class);

    /* renamed from: aT */
    public static final CaptureRequest.Key<int[]> f13281aT = new CaptureRequest.Key<>("com.mediatek.control.capture.raw10.convertfmt", int[].class);

    /* renamed from: aU */
    public static final CameraCharacteristics.Key<byte[]> f13282aU = new CameraCharacteristics.Key<>("com.oplus.custom.video.endofstream", byte[].class);

    /* renamed from: aV */
    public static final CameraCharacteristics.Key<int[]> f13283aV = new CameraCharacteristics.Key<>("com.mediatek.smvrfeature.availableSmvrModes", int[].class);

    /* renamed from: aW */
    public static final CameraCharacteristics.Key<Integer> f13284aW = new CameraCharacteristics.Key<>("com.oplus.low.ram", Integer.TYPE);

    /* renamed from: aX */
    public static final CameraCharacteristics.Key<float[]> f13285aX = new CameraCharacteristics.Key<>("com.oplus.fov.Angle", float[].class);

    /* renamed from: aY */
    public static final CameraCharacteristics.Key<int[]> f13286aY = new CameraCharacteristics.Key<>("com.oplus.vendor.tag.count", int[].class);

    /* renamed from: aZ */
    public static final CameraCharacteristics.Key<int[]> f13287aZ = new CameraCharacteristics.Key<>("com.oplus.vendor.tag.ids", int[].class);

    /* renamed from: ba */
    public static final CameraCharacteristics.Key<byte[]> f13320ba = new CameraCharacteristics.Key<>("com.oplus.vendor.tag.names", byte[].class);

    /* renamed from: bb */
    public static final CaptureRequest.Key<int[]> f13321bb = new CaptureRequest.Key<>("com.qti.izoom_control.state_izoom_snapshot", int[].class);

    /* renamed from: bc */
    public static final CaptureRequest.Key<int[]> f13322bc = new CaptureRequest.Key<>("com.oplus.MFSRFrameNum", int[].class);

    /* renamed from: bd */
    public static final CaptureRequest.Key<Byte> f13323bd = new CaptureRequest.Key<>("org.quic.camera.CustomNoiseReduction.CustomNoiseReduction", Byte.TYPE);

    /* renamed from: be */
    public static final CaptureRequest.Key<int[]> f13324be = new CaptureRequest.Key<>("com.mediatek.streamingfeature.pipDevices", int[].class);

    /* renamed from: bf */
    public static final CaptureRequest.Key<Integer> f13325bf = new CaptureRequest.Key<>("com.oplus.dualscene.master", Integer.class);

    /* renamed from: bg_renamed */
    public static final CaptureRequest.Key<int[]> f13326bg = new CaptureRequest.Key<>("com.oplus.aps.multiframe.count", int[].class);

    /* renamed from: bh */
    public static final CaptureResult.Key<long[]> f13327bh = new CaptureResult.Key<>("com.oplus.count.down.estimator", long[].class);

    /* renamed from: bi */
    public static final CaptureRequest.Key<Byte> f13328bi = new CaptureRequest.Key<>("com.qti.chi.metadataOwnerInfo.MetadataOwner", Byte.TYPE);

    /* renamed from: bj */
    public static final CaptureResult.Key<Integer> f13329bj = new CaptureResult.Key<>("com.oplus.af.focus.out.of.range", Integer.class);

    /* renamed from: bk */
    public static final CaptureRequest.Key<Rect> f13330bk = new CaptureRequest.Key<>("com.oplus.supernight.reprocess.cropRegion", Rect.class);

    /* renamed from: bl */
    public static final CaptureResult.Key<float[]> f13331bl = new CaptureResult.Key<>("com.qti.stats_control.sgwRGRatio", float[].class);

    /* renamed from: bm */
    public static final CaptureResult.Key<float[]> f13332bm = new CaptureResult.Key<>("com.qti.stats_control.sgwBGRatio", float[].class);

    /* renamed from: bn */
    public static final CaptureResult.Key<float[]> f13333bn = new CaptureResult.Key<>("org.quic.camera2.statsconfigs.AWBDecisionAfterTC", float[].class);

    /* renamed from: bo */
    public static final CaptureResult.Key<float[]> f13334bo = new CaptureResult.Key<>("com.oplus.awb.colorsensor.CCT", float[].class);

    /* renamed from: bp */
    public static final CaptureResult.Key<float[]> f13335bp = new CaptureResult.Key<>("com.qti.stats_control.drc_gain", float[].class);

    /* renamed from: bq */
    public static final CaptureResult.Key<float[]> f13336bq = new CaptureResult.Key<>("com.oplus.gyroSqrCutom", float[].class);

    /* renamed from: br */
    public static final CaptureResult.Key<int[]> f13337br = new CaptureResult.Key<>("com.qti.stats_control.ais_motion_type", int[].class);

    /* renamed from: bs */
    public static final CaptureResult.Key<int[]> f13338bs = new CaptureResult.Key<>("com.qti.stats_control.is_ais_needed", int[].class);

    /* renamed from: bt */
    public static final CaptureResult.Key<int[]> f13339bt = new CaptureResult.Key<>("com.oplus.af.focus.roi", int[].class);

    /* renamed from: bu */
    public static final CaptureResult.Key<int[]> f13340bu = new CaptureResult.Key<>("com.oplus.af.focus.method", int[].class);

    /* renamed from: bv */
    public static final CaptureResult.Key<int[]> f13341bv = new CaptureResult.Key<>("com.oplus.focus.time.cost", int[].class);

    /* renamed from: bw */
    public static final CaptureResult.Key<Integer> f13342bw = new CaptureResult.Key<>("com.oplus.is.laser.dirty", Integer.TYPE);

    /* renamed from: bx */
    public static final CaptureResult.Key<float[]> f13343bx = new CaptureResult.Key<>("com.oplus.mfnr.sharpnessVal", float[].class);

    /* renamed from: by */
    public static final CaptureResult.Key<int[]> f13344by = new CaptureResult.Key<>("com.oplus.aps.sat.snapshot.master.pipeline", int[].class);

    /* renamed from: bz */
    public static final CaptureRequest.Key<Integer> f13345bz = new CaptureRequest.Key<>("com.oplus.asd.scene.value", Integer.class);

    /* renamed from: bA */
    public static final CaptureRequest.Key<Integer> f13315bA = new CaptureRequest.Key<>("com.oplus.aelock.bytouch", Integer.class);

    /* renamed from: bB */
    public static final CaptureRequest.Key<Integer> f13316bB = new CaptureRequest.Key<>("com.oplus.makeup.state", Integer.class);

    /* renamed from: bC */
    public static final CaptureRequest.Key<int[]> f13317bC = new CaptureRequest.Key<>("com.oplus.video.blur.enable", int[].class);

    /* renamed from: bD */
    public static final CaptureRequest.Key<int[]> f13318bD = new CaptureRequest.Key<>("com.oplus.video.neon.enable", int[].class);

    /* renamed from: bE */
    public static final CaptureResult.Key<Integer> f13319bE = new CaptureResult.Key<>("com.oplus.starmode.frameflog", Integer.class);

    public CameraMetadataKey() {
        this.f13370bF = null;
        this.f13371bG = null;
        this.f13370bF = new HashMap<>();
        this.f13371bG = new HashMap<>();
    }

    /* renamed from: PlatformImplementations.kt_3 */
    public static Object m13005a(CaptureResult captureResult, CaptureResult.Key<?> key) {
        try {
            return captureResult.get(key);
        } catch (Exception unused) {
            return null;
        }
    }
}
