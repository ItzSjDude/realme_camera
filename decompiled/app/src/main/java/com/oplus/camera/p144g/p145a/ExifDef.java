package com.oplus.camera.p144g.p145a;

import com.meicam.sdk.NvsFxDescription;
import java.util.HashMap;
import p000a.p001a.p003b.p005b.p006a.AbstractC0008a;

/* compiled from: ExifDef.java */
/* renamed from: com.oplus.camera.COUIBaseListPopupWindow_11.PlatformImplementations.kt_3.PlatformImplementations.kt_3 */
/* loaded from: classes2.dex */
public class ExifDef {

    /* renamed from: PlatformImplementations.kt_3 */
    public static HashMap<Integer, ExifTagDef> f13758a = new HashMap<>();

    static {
        f13758a.put(254, new ExifTagDef(254, 4, "NewSubfileType", 1));
        f13758a.put(256, new ExifTagDef(256, 4, "ImageWidth", 1));
        f13758a.put(257, new ExifTagDef(257, 4, "ImageHeight", 1));
        f13758a.put(258, new ExifTagDef(258, 3, "BitsPerSample", 1));
        f13758a.put(259, new ExifTagDef(259, 3, "Compression", 1));
        f13758a.put(262, new ExifTagDef(262, 3, "PhotometricInterpretation", 1));
        f13758a.put(270, new ExifTagDef(270, 2, "ImageDescription", 1));
        f13758a.put(271, new ExifTagDef(271, 2, "Make", 1));
        f13758a.put(272, new ExifTagDef(272, 2, "Model", 1));
        f13758a.put(273, new ExifTagDef(273, 4, "StripOffsets", 1));
        f13758a.put(274, new ExifTagDef(274, 3, "Orientation", 1));
        f13758a.put(277, new ExifTagDef(277, 3, "SamplesPerPixel", 1));
        f13758a.put(278, new ExifTagDef(278, 4, "RowsPerStrip", 1));
        f13758a.put(279, new ExifTagDef(279, 4, "StripByteCounts", 1));
        f13758a.put(282, new ExifTagDef(282, 5, "XResolution", 1));
        f13758a.put(283, new ExifTagDef(283, 5, "YResolution", 1));
        f13758a.put(284, new ExifTagDef(284, 3, "PlanarConfiguration", 1));
        f13758a.put(296, new ExifTagDef(296, 3, "ResolutionUnit", 1));
        f13758a.put(305, new ExifTagDef(305, 2, "Software", 1));
        f13758a.put(306, new ExifTagDef(306, 2, "ModifyDate", 1));
        f13758a.put(322, new ExifTagDef(322, 4, "TileWidth", 1));
        f13758a.put(323, new ExifTagDef(323, 4, "TileLength", 1));
        f13758a.put(324, new ExifTagDef(324, 4, "TileOffsets", 1));
        f13758a.put(325, new ExifTagDef(325, 4, "TileByteCounts", 1));
        f13758a.put(330, new ExifTagDef(330, 4, "SubIFD", 1));
        f13758a.put(Integer.valueOf(AbstractC0008a.KEY_INDEX), new ExifTagDef(AbstractC0008a.KEY_INDEX, 4, "ThumbnailOffset", 1));
        f13758a.put(514, new ExifTagDef(514, 4, "ThumbnailLength", 1));
        f13758a.put(529, new ExifTagDef(529, 5, "YCbCrCoefficients", 1));
        f13758a.put(530, new ExifTagDef(530, 3, "YCbCrSubSampling", 1));
        f13758a.put(531, new ExifTagDef(531, 3, "YCbCrPositioning", 1));
        f13758a.put(532, new ExifTagDef(532, 5, "ReferenceBlackWhite", 1));
        f13758a.put(700, new ExifTagDef(700, 1, "ApplicationNotes", 1));
        f13758a.put(33421, new ExifTagDef(33421, 3, "CFARepeatPatternDim", 1));
        f13758a.put(33422, new ExifTagDef(33422, 1, "CFAPattern", 1));
        f13758a.put(33432, new ExifTagDef(33432, 2, "Copyright", 1));
        f13758a.put(33434, new ExifTagDef(33434, 5, "ExposureTime", 2));
        f13758a.put(33437, new ExifTagDef(33437, 5, "FNumber", 2));
        f13758a.put(34665, new ExifTagDef(34665, 4, "ExifOffset", 1));
        f13758a.put(34853, new ExifTagDef(34853, 4, "GPSInfo", 1));
        f13758a.put(34855, new ExifTagDef(34855, 3, "PhotographicSensitivity", 2));
        f13758a.put(36864, new ExifTagDef(36864, 7, "ExifVersion", 2));
        f13758a.put(36867, new ExifTagDef(36867, 2, "DateTimeOriginal", 2));
        f13758a.put(36880, new ExifTagDef(36880, 2, "OffsetTime", 2));
        f13758a.put(36881, new ExifTagDef(36881, 2, "OffsetTimeOriginal", 2));
        f13758a.put(37377, new ExifTagDef(37377, 10, "ShutterSpeedValue", 2));
        f13758a.put(37378, new ExifTagDef(37378, 5, "ApertureValue", 2));
        f13758a.put(37386, new ExifTagDef(37386, 5, "FocalLength", 2));
        f13758a.put(37398, new ExifTagDef(37398, 1, "TIFF-EPStandardID", 1));
        f13758a.put(37521, new ExifTagDef(37521, 2, "SubSecTimeOriginal", 2));
        f13758a.put(50706, new ExifTagDef(50706, 1, "DNGVersion", 1));
        f13758a.put(50707, new ExifTagDef(50707, 1, "DNGBackwardVersion", 1));
        f13758a.put(50708, new ExifTagDef(50708, 2, "UniqueCameraModel", 1));
        f13758a.put(50710, new ExifTagDef(50710, 1, "CFAPlaneColor", 1));
        f13758a.put(50711, new ExifTagDef(50711, 3, "CFALayout", 1));
        f13758a.put(50713, new ExifTagDef(50713, 3, "BlackLevelRepeatDim", 1));
        f13758a.put(50714, new ExifTagDef(50714, 5, "BlackLevel", 1));
        f13758a.put(50717, new ExifTagDef(50717, 3, "WhiteLevel", 1));
        f13758a.put(50718, new ExifTagDef(50718, 5, "DefaultScale", 1));
        f13758a.put(50719, new ExifTagDef(50719, 5, "DefaultCropOrigin", 1));
        f13758a.put(50720, new ExifTagDef(50720, 5, "DefaultCropSize", 1));
        f13758a.put(50721, new ExifTagDef(50721, 10, "ColorMatrix1", 1));
        f13758a.put(50722, new ExifTagDef(50722, 10, "ColorMatrix2", 1));
        f13758a.put(50723, new ExifTagDef(50723, 10, "CameraCalibration1", 1));
        f13758a.put(50724, new ExifTagDef(50724, 10, "CameraCalibration2", 1));
        f13758a.put(50727, new ExifTagDef(50727, 5, "AnalogBalance", 1));
        f13758a.put(50728, new ExifTagDef(50728, 5, "AsShotNeutral", 1));
        f13758a.put(50730, new ExifTagDef(50730, 10, "BaselineExposure", 1));
        f13758a.put(50731, new ExifTagDef(50731, 5, "BaselineNoise", 1));
        f13758a.put(50732, new ExifTagDef(50732, 5, "BaselineSharpness", 1));
        f13758a.put(50733, new ExifTagDef(50733, 4, "BayerGreenSplit", 1));
        f13758a.put(50734, new ExifTagDef(50734, 5, "LinearResponseLimit", 1));
        f13758a.put(50738, new ExifTagDef(50738, 5, "AntiAliasStrength", 1));
        f13758a.put(50739, new ExifTagDef(50739, 5, "ShadowScale", 1));
        f13758a.put(50778, new ExifTagDef(50778, 3, "CalibrationIlluminant1", 1));
        f13758a.put(50779, new ExifTagDef(50779, 3, "CalibrationIlluminant2", 1));
        f13758a.put(50780, new ExifTagDef(50780, 5, "BestQualityScale", 1));
        f13758a.put(50781, new ExifTagDef(50781, 1, "RawDataUniqueID", 1));
        f13758a.put(50829, new ExifTagDef(50829, 4, "ActiveArea", 1));
        f13758a.put(50936, new ExifTagDef(50936, 2, "ProfileName", 1));
        f13758a.put(50941, new ExifTagDef(50941, 4, "ProfileEmbedPolicy", 1));
        f13758a.put(50964, new ExifTagDef(50964, 10, "ForwardMatrix1", 1));
        f13758a.put(50965, new ExifTagDef(50965, 10, "ForwardMatrix2", 1));
        f13758a.put(50966, new ExifTagDef(50966, 2, "PreviewApplicationName", 1));
        f13758a.put(50967, new ExifTagDef(50967, 2, "PreviewApplicationVersion", 1));
        f13758a.put(50969, new ExifTagDef(50969, 1, "PreviewSettingsDigest", 1));
        f13758a.put(50970, new ExifTagDef(50970, 4, "PreviewColorSpace", 1));
        f13758a.put(50971, new ExifTagDef(50971, 2, "PreviewDateTime", 1));
        f13758a.put(50972, new ExifTagDef(50972, 1, "RawImageDigest", 1));
        f13758a.put(51009, new ExifTagDef(51009, 7, "OpcodeList2", 1));
        f13758a.put(51022, new ExifTagDef(51022, 7, "OpcodeList3", 1));
        f13758a.put(51041, new ExifTagDef(51041, 12, "NoiseProfile", 1));
        f13758a.put(51114, new ExifTagDef(51114, 4, "CacheVersion", 1));
    }

    /* compiled from: ExifDef.java */
    /* renamed from: com.oplus.camera.COUIBaseListPopupWindow_11.PlatformImplementations.kt_3.PlatformImplementations.kt_3$PlatformImplementations.kt_3 */
    public static class PlatformImplementations.kt_3 {

        /* renamed from: PlatformImplementations.kt_3 */
        public static final String[] f13759a = {"", "BYTE", NvsFxDescription.ParamInfoObject.PARAM_TYPE_STRING, "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};

        /* renamed from: IntrinsicsJvm.kt_4 */
        public static final int[] f13760b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};

        /* renamed from: IntrinsicsJvm.kt_3 */
        public int f13761c;

        /* renamed from: IntrinsicsJvm.kt_5 */
        public String f13762d;

        /* renamed from: COUIBaseListPopupWindow_8 */
        public int f13763e;

        public PlatformImplementations.kt_3(int OplusGLSurfaceView_13) {
            this.f13761c = OplusGLSurfaceView_13;
            String[] strArr = f13759a;
            int i2 = this.f13761c;
            this.f13762d = strArr[i2];
            this.f13763e = f13760b[i2];
        }

        public String toString() {
            return ExifUtil.m13770a(Integer.valueOf(this.f13761c)) + " ; count : " + this.f13763e + " ; TypeName : " + this.f13762d;
        }
    }
}
