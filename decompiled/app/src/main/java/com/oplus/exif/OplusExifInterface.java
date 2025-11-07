package com.oplus.exif;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.util.SparseIntArray;
import com.meicam.sdk.NvsMediaFileConvertor;
import com.sensetime.stmobile.STMobileHumanActionNative;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class OplusExifInterface {
    private static final String DATETIME_FORMAT_STR = "yyyy:MM:dd HH:mm:ss";
    public static final ByteOrder DEFAULT_BYTE_ORDER;
    public static final int DEFINITION_NULL = 0;
    private static final String GPS_DATE_FORMAT_STR = "yyyy:MM:dd";
    public static final int IFD_NULL = -1;
    private static final String NULL_ARGUMENT_STRING = "Argument is null";
    public static final int TAG_NULL = -1;
    protected static final HashSet<Short> sBannedDefines;
    private OplusExifData mData = new OplusExifData(DEFAULT_BYTE_ORDER);
    private final DateFormat mDateTimeStampFormat = new SimpleDateFormat(DATETIME_FORMAT_STR);
    private final DateFormat mGPSDateStampFormat = new SimpleDateFormat(GPS_DATE_FORMAT_STR);
    private final Calendar mGPSTimeStampCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
    private SparseIntArray mTagInfo = null;
    public static final int TAG_IMAGE_WIDTH = defineTag(0, 256);
    public static final int TAG_IMAGE_LENGTH = defineTag(0, 257);
    public static final int TAG_BITS_PER_SAMPLE = defineTag(0, 258);
    public static final int TAG_COMPRESSION = defineTag(0, 259);
    public static final int TAG_PHOTOMETRIC_INTERPRETATION = defineTag(0, 262);
    public static final int TAG_IMAGE_DESCRIPTION = defineTag(0, 270);
    public static final int TAG_MAKE = defineTag(0, 271);
    public static final int TAG_MODEL = defineTag(0, 272);
    public static final int TAG_STRIP_OFFSETS = defineTag(0, 273);
    public static final int TAG_ORIENTATION = defineTag(0, 274);
    public static final int TAG_SAMPLES_PER_PIXEL = defineTag(0, 277);
    public static final int TAG_ROWS_PER_STRIP = defineTag(0, 278);
    public static final int TAG_STRIP_BYTE_COUNTS = defineTag(0, 279);
    public static final int TAG_X_RESOLUTION = defineTag(0, 282);
    public static final int TAG_Y_RESOLUTION = defineTag(0, 283);
    public static final int TAG_PLANAR_CONFIGURATION = defineTag(0, 284);
    public static final int TAG_RESOLUTION_UNIT = defineTag(0, 296);
    public static final int TAG_TRANSFER_FUNCTION = defineTag(0, 301);
    public static final int TAG_SOFTWARE = defineTag(0, 305);
    public static final int TAG_DATE_TIME = defineTag(0, 306);
    public static final int TAG_ARTIST = defineTag(0, 315);
    public static final int TAG_WHITE_POINT = defineTag(0, 318);
    public static final int TAG_PRIMARY_CHROMATICITIES = defineTag(0, 319);
    public static final int TAG_Y_CB_CR_COEFFICIENTS = defineTag(0, 529);
    public static final int TAG_Y_CB_CR_SUB_SAMPLING = defineTag(0, 530);
    public static final int TAG_Y_CB_CR_POSITIONING = defineTag(0, 531);
    public static final int TAG_REFERENCE_BLACK_WHITE = defineTag(0, 532);
    public static final int TAG_COPYRIGHT = defineTag(0, -32104);
    public static final int TAG_EXIF_IFD = defineTag(0, -30871);
    public static final int TAG_GPS_IFD = defineTag(0, -30683);
    public static final int TAG_JPEG_INTERCHANGE_FORMAT = defineTag(1, 513);
    public static final int TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = defineTag(1, 514);
    public static final int TAG_EXPOSURE_TIME = defineTag(2, -32102);
    public static final int TAG_F_NUMBER = defineTag(2, -32099);
    public static final int TAG_EXPOSURE_PROGRAM = defineTag(2, -30686);
    public static final int TAG_SPECTRAL_SENSITIVITY = defineTag(2, -30684);
    public static final int TAG_ISO_SPEED_RATINGS = defineTag(2, -30681);
    public static final int TAG_OECF = defineTag(2, -30680);
    public static final int TAG_EXIF_VERSION = defineTag(2, -28672);
    public static final int TAG_DATE_TIME_ORIGINAL = defineTag(2, -28669);
    public static final int TAG_DATE_TIME_DIGITIZED = defineTag(2, -28668);
    public static final int TAG_OFFSET_TIME_ORIGINAL = defineTag(2, -28655);
    public static final int TAG_COMPONENTS_CONFIGURATION = defineTag(2, -28415);
    public static final int TAG_COMPRESSED_BITS_PER_PIXEL = defineTag(2, -28414);
    public static final int TAG_SHUTTER_SPEED_VALUE = defineTag(2, -28159);
    public static final int TAG_APERTURE_VALUE = defineTag(2, -28158);
    public static final int TAG_BRIGHTNESS_VALUE = defineTag(2, -28157);
    public static final int TAG_EXPOSURE_BIAS_VALUE = defineTag(2, -28156);
    public static final int TAG_MAX_APERTURE_VALUE = defineTag(2, -28155);
    public static final int TAG_SUBJECT_DISTANCE = defineTag(2, -28154);
    public static final int TAG_METERING_MODE = defineTag(2, -28153);
    public static final int TAG_LIGHT_SOURCE = defineTag(2, -28152);
    public static final int TAG_FLASH = defineTag(2, -28151);
    public static final int TAG_FOCAL_LENGTH = defineTag(2, -28150);
    public static final int TAG_SUBJECT_AREA = defineTag(2, -28140);
    public static final int TAG_MAKER_NOTE = defineTag(2, -28036);
    public static final int TAG_USER_COMMENT = defineTag(2, -28026);
    public static final int TAG_SUB_SEC_TIME = defineTag(2, -28016);
    public static final int TAG_SUB_SEC_TIME_ORIGINAL = defineTag(2, -28015);
    public static final int TAG_SUB_SEC_TIME_DIGITIZED = defineTag(2, -28014);
    public static final int TAG_FLASHPIX_VERSION = defineTag(2, -24576);
    public static final int TAG_COLOR_SPACE = defineTag(2, -24575);
    public static final int TAG_PIXEL_X_DIMENSION = defineTag(2, -24574);
    public static final int TAG_PIXEL_Y_DIMENSION = defineTag(2, -24573);
    public static final int TAG_RELATED_SOUND_FILE = defineTag(2, -24572);
    public static final int TAG_INTEROPERABILITY_IFD = defineTag(2, -24571);
    public static final int TAG_FLASH_ENERGY = defineTag(2, -24053);
    public static final int TAG_SPATIAL_FREQUENCY_RESPONSE = defineTag(2, -24052);
    public static final int TAG_FOCAL_PLANE_X_RESOLUTION = defineTag(2, -24050);
    public static final int TAG_FOCAL_PLANE_Y_RESOLUTION = defineTag(2, -24049);
    public static final int TAG_FOCAL_PLANE_RESOLUTION_UNIT = defineTag(2, -24048);
    public static final int TAG_SUBJECT_LOCATION = defineTag(2, -24044);
    public static final int TAG_EXPOSURE_INDEX = defineTag(2, -24043);
    public static final int TAG_SENSING_METHOD = defineTag(2, -24041);
    public static final int TAG_FILE_SOURCE = defineTag(2, -23808);
    public static final int TAG_SCENE_TYPE = defineTag(2, -23807);
    public static final int TAG_CFA_PATTERN = defineTag(2, -23806);
    public static final int TAG_CUSTOM_RENDERED = defineTag(2, -23551);
    public static final int TAG_EXPOSURE_MODE = defineTag(2, -23550);
    public static final int TAG_WHITE_BALANCE = defineTag(2, -23549);
    public static final int TAG_DIGITAL_ZOOM_RATIO = defineTag(2, -23548);
    public static final int TAG_FOCAL_LENGTH_IN_35_MM_FILE = defineTag(2, -23547);
    public static final int TAG_SCENE_CAPTURE_TYPE = defineTag(2, -23546);
    public static final int TAG_GAIN_CONTROL = defineTag(2, -23545);
    public static final int TAG_CONTRAST = defineTag(2, -23544);
    public static final int TAG_SATURATION = defineTag(2, -23543);
    public static final int TAG_SHARPNESS = defineTag(2, -23542);
    public static final int TAG_DEVICE_SETTING_DESCRIPTION = defineTag(2, -23541);
    public static final int TAG_SUBJECT_DISTANCE_RANGE = defineTag(2, -23540);
    public static final int TAG_IMAGE_UNIQUE_ID = defineTag(2, -23520);
    public static final int TAG_GPS_VERSION_ID = defineTag(4, 0);
    public static final int TAG_GPS_LATITUDE_REF = defineTag(4, 1);
    public static final int TAG_GPS_LATITUDE = defineTag(4, 2);
    public static final int TAG_GPS_LONGITUDE_REF = defineTag(4, 3);
    public static final int TAG_GPS_LONGITUDE = defineTag(4, 4);
    public static final int TAG_GPS_ALTITUDE_REF = defineTag(4, 5);
    public static final int TAG_GPS_ALTITUDE = defineTag(4, 6);
    public static final int TAG_GPS_TIME_STAMP = defineTag(4, 7);
    public static final int TAG_GPS_SATTELLITES = defineTag(4, 8);
    public static final int TAG_GPS_STATUS = defineTag(4, 9);
    public static final int TAG_GPS_MEASURE_MODE = defineTag(4, 10);
    public static final int TAG_GPS_DOP = defineTag(4, 11);
    public static final int TAG_GPS_SPEED_REF = defineTag(4, 12);
    public static final int TAG_GPS_SPEED = defineTag(4, 13);
    public static final int TAG_GPS_TRACK_REF = defineTag(4, 14);
    public static final int TAG_GPS_TRACK = defineTag(4, 15);
    public static final int TAG_GPS_IMG_DIRECTION_REF = defineTag(4, 16);
    public static final int TAG_GPS_IMG_DIRECTION = defineTag(4, 17);
    public static final int TAG_GPS_MAP_DATUM = defineTag(4, 18);
    public static final int TAG_GPS_DEST_LATITUDE_REF = defineTag(4, 19);
    public static final int TAG_GPS_DEST_LATITUDE = defineTag(4, 20);
    public static final int TAG_GPS_DEST_LONGITUDE_REF = defineTag(4, 21);
    public static final int TAG_GPS_DEST_LONGITUDE = defineTag(4, 22);
    public static final int TAG_GPS_DEST_BEARING_REF = defineTag(4, 23);
    public static final int TAG_GPS_DEST_BEARING = defineTag(4, 24);
    public static final int TAG_GPS_DEST_DISTANCE_REF = defineTag(4, 25);
    public static final int TAG_GPS_DEST_DISTANCE = defineTag(4, 26);
    public static final int TAG_GPS_PROCESSING_METHOD = defineTag(4, 27);
    public static final int TAG_GPS_AREA_INFORMATION = defineTag(4, 28);
    public static final int TAG_GPS_DATE_STAMP = defineTag(4, 29);
    public static final int TAG_GPS_DIFFERENTIAL = defineTag(4, 30);
    public static final int TAG_INTEROPERABILITY_INDEX = defineTag(3, 1);
    private static HashSet<Short> sOffsetTags = new HashSet<>();

    public interface ColorSpace {
        public static final short SRGB = 1;
        public static final short UNCALIBRATED = -1;
    }

    public interface ComponentsConfiguration {

        /* renamed from: B */
        public static final short f23366B = 6;

        /* renamed from: CB */
        public static final short f23367CB = 2;

        /* renamed from: CR */
        public static final short f23368CR = 3;

        /* renamed from: G */
        public static final short f23369G = 5;
        public static final short NOT_EXIST = 0;

        /* renamed from: R */
        public static final short f23370R = 4;

        /* renamed from: Y */
        public static final short f23371Y = 1;
    }

    public interface Compression {
        public static final short JPEG = 6;
        public static final short UNCOMPRESSION = 1;
    }

    public interface Contrast {
        public static final short HARD = 2;
        public static final short NORMAL = 0;
        public static final short SOFT = 1;
    }

    public interface ExposureMode {
        public static final short AUTO_BRACKET = 2;
        public static final short AUTO_EXPOSURE = 0;
        public static final short MANUAL_EXPOSURE = 1;
    }

    public interface ExposureProgram {
        public static final short ACTION_PROGRAM = 6;
        public static final short APERTURE_PRIORITY = 3;
        public static final short CREATIVE_PROGRAM = 5;
        public static final short LANDSCAPE_MODE = 8;
        public static final short MANUAL = 1;
        public static final short NORMAL_PROGRAM = 2;
        public static final short NOT_DEFINED = 0;
        public static final short PROTRAIT_MODE = 7;
        public static final short SHUTTER_PRIORITY = 4;
    }

    public interface FileSource {
        public static final short DSC = 3;
    }

    public interface Flash {
        public static final short DID_NOT_FIRED = 0;
        public static final short FIRED = 1;
        public static final short FUNCTION_NO_FUNCTION = 32;
        public static final short FUNCTION_PRESENT = 0;
        public static final short MODE_AUTO_MODE = 24;
        public static final short MODE_COMPULSORY_FLASH_FIRING = 8;
        public static final short MODE_COMPULSORY_FLASH_SUPPRESSION = 16;
        public static final short MODE_UNKNOWN = 0;
        public static final short RED_EYE_REDUCTION_NO_OR_UNKNOWN = 0;
        public static final short RED_EYE_REDUCTION_SUPPORT = 64;
        public static final short RETURN_NO_STROBE_RETURN_DETECTION_FUNCTION = 0;
        public static final short RETURN_STROBE_RETURN_LIGHT_DETECTED = 6;
        public static final short RETURN_STROBE_RETURN_LIGHT_NOT_DETECTED = 4;
    }

    public interface GainControl {
        public static final short HIGH_DOWN = 4;
        public static final short HIGH_UP = 2;
        public static final short LOW_DOWN = 3;
        public static final short LOW_UP = 1;
        public static final short NONE = 0;
    }

    public interface GpsAltitudeRef {
        public static final short SEA_LEVEL = 0;
        public static final short SEA_LEVEL_NEGATIVE = 1;
    }

    public interface GpsDifferential {
        public static final short DIFFERENTIAL_CORRECTION_APPLIED = 1;
        public static final short WITHOUT_DIFFERENTIAL_CORRECTION = 0;
    }

    public interface GpsLatitudeRef {
        public static final String NORTH = "N";
        public static final String SOUTH = "S";
    }

    public interface GpsLongitudeRef {
        public static final String EAST = "E";
        public static final String WEST = "W";
    }

    public interface GpsMeasureMode {
        public static final String MODE_2_DIMENSIONAL = "2";
        public static final String MODE_3_DIMENSIONAL = "3";
    }

    public interface GpsSpeedRef {
        public static final String KILOMETERS = "K";
        public static final String KNOTS = "N";
        public static final String MILES = "M";
    }

    public interface GpsStatus {
        public static final String INTEROPERABILITY = "V";
        public static final String IN_PROGRESS = "A";
    }

    public interface GpsTrackRef {
        public static final String MAGNETIC_DIRECTION = "M";
        public static final String TRUE_DIRECTION = "T";
    }

    public interface LightSource {
        public static final short CLOUDY_WEATHER = 10;
        public static final short COOL_WHITE_FLUORESCENT = 14;
        public static final short D50 = 23;
        public static final short D55 = 20;
        public static final short D65 = 21;
        public static final short D75 = 22;
        public static final short DAYLIGHT = 1;
        public static final short DAYLIGHT_FLUORESCENT = 12;
        public static final short DAY_WHITE_FLUORESCENT = 13;
        public static final short FINE_WEATHER = 9;
        public static final short FLASH = 4;
        public static final short FLUORESCENT = 2;
        public static final short ISO_STUDIO_TUNGSTEN = 24;
        public static final short OTHER = 255;
        public static final short SHADE = 11;
        public static final short STANDARD_LIGHT_A = 17;
        public static final short STANDARD_LIGHT_B = 18;
        public static final short STANDARD_LIGHT_C = 19;
        public static final short TUNGSTEN = 3;
        public static final short UNKNOWN = 0;
        public static final short WHITE_FLUORESCENT = 15;
    }

    public interface MeteringMode {
        public static final short AVERAGE = 1;
        public static final short CENTER_WEIGHTED_AVERAGE = 2;
        public static final short MULTISPOT = 4;
        public static final short OTHER = 255;
        public static final short PARTAIL = 6;
        public static final short PATTERN = 5;
        public static final short SPOT = 3;
        public static final short UNKNOWN = 0;
    }

    public interface Orientation {
        public static final short BOTTOM_LEFT = 3;
        public static final short BOTTOM_RIGHT = 4;
        public static final short LEFT_BOTTOM = 7;
        public static final short LEFT_TOP = 5;
        public static final short RIGHT_BOTTOM = 8;
        public static final short RIGHT_TOP = 6;
        public static final short TOP_LEFT = 1;
        public static final short TOP_RIGHT = 2;
    }

    public interface PhotometricInterpretation {
        public static final short RGB = 2;
        public static final short YCBCR = 6;
    }

    public interface PlanarConfiguration {
        public static final short CHUNKY = 1;
        public static final short PLANAR = 2;
    }

    public interface ResolutionUnit {
        public static final short CENTIMETERS = 3;
        public static final short INCHES = 2;
    }

    public interface Saturation {
        public static final short HIGH = 2;
        public static final short LOW = 1;
        public static final short NORMAL = 0;
    }

    public interface SceneCapture {
        public static final short LANDSCAPE = 1;
        public static final short NIGHT_SCENE = 3;
        public static final short PROTRAIT = 2;
        public static final short STANDARD = 0;
    }

    public interface SceneType {
        public static final short DIRECT_PHOTOGRAPHED = 1;
    }

    public interface SensingMethod {
        public static final short COLOR_SEQUENTIAL_AREA = 5;
        public static final short COLOR_SEQUENTIAL_LINEAR = 8;
        public static final short NOT_DEFINED = 1;
        public static final short ONE_CHIP_COLOR = 2;
        public static final short THREE_CHIP_COLOR = 4;
        public static final short TRILINEAR = 7;
        public static final short TWO_CHIP_COLOR = 3;
    }

    public interface Sharpness {
        public static final short HARD = 2;
        public static final short NORMAL = 0;
        public static final short SOFT = 1;
    }

    public interface SubjectDistance {
        public static final short CLOSE_VIEW = 2;
        public static final short DISTANT_VIEW = 3;
        public static final short MACRO = 1;
        public static final short UNKNOWN = 0;
    }

    public interface WhiteBalance {
        public static final short AUTO = 0;
        public static final short MANUAL = 1;
    }

    public interface YCbCrPositioning {
        public static final short CENTERED = 1;
        public static final short CO_SITED = 2;
    }

    public static int defineTag(int OplusGLSurfaceView_13, short s) {
        return (OplusGLSurfaceView_13 << 16) | (s & ColorSpace.UNCALIBRATED);
    }

    protected static int getAllowedIfdFlagsFromInfo(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 >>> 24;
    }

    protected static int getComponentCountFromInfo(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 & NvsMediaFileConvertor.CONVERTOR_ERROR_UNKNOWN;
    }

    public static int getRotationForOrientationValue(short s) {
        if (s == 1) {
            return 0;
        }
        if (s == 3) {
            return 180;
        }
        if (s != 6) {
            return s != 8 ? 0 : 270;
        }
        return 90;
    }

    public static int getTrueIfd(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 >>> 16;
    }

    public static short getTrueTagKey(int OplusGLSurfaceView_13) {
        return (short) OplusGLSurfaceView_13;
    }

    protected static short getTypeFromInfo(int OplusGLSurfaceView_13) {
        return (short) ((OplusGLSurfaceView_13 >> 16) & 255);
    }

    static {
        sOffsetTags.add(Short.valueOf(getTrueTagKey(TAG_GPS_IFD)));
        sOffsetTags.add(Short.valueOf(getTrueTagKey(TAG_EXIF_IFD)));
        sOffsetTags.add(Short.valueOf(getTrueTagKey(TAG_JPEG_INTERCHANGE_FORMAT)));
        sOffsetTags.add(Short.valueOf(getTrueTagKey(TAG_INTEROPERABILITY_IFD)));
        sOffsetTags.add(Short.valueOf(getTrueTagKey(TAG_STRIP_OFFSETS)));
        sBannedDefines = new HashSet<>(sOffsetTags);
        sBannedDefines.add(Short.valueOf(getTrueTagKey(-1)));
        sBannedDefines.add(Short.valueOf(getTrueTagKey(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH)));
        sBannedDefines.add(Short.valueOf(getTrueTagKey(TAG_STRIP_BYTE_COUNTS)));
        DEFAULT_BYTE_ORDER = ByteOrder.BIG_ENDIAN;
    }

    public OplusExifInterface() {
        this.mGPSDateStampFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    public void readExif(byte[] bArr) throws IOException {
        readExif(new ByteArrayInputStream(bArr));
    }

    public void readExif(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
        }
        OplusExifData oplusExifData = null;
        try {
            oplusExifData = new OplusExifReader(this).read(inputStream);
        } catch (OplusExifInvalidFormatException COUIBaseListPopupWindow_8) {
            throw new IOException("Invalid exif format : " + COUIBaseListPopupWindow_8);
        } catch (Throwable th) {
            Log.COUIBaseListPopupWindow_8("OplusExifInterface", "COUIBaseListPopupWindow_8 = " + th);
        }
        this.mData = oplusExifData;
    }

    public void readExif(String str) throws IOException {
        BufferedInputStream bufferedInputStream;
        if (str == null) {
            throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
        }
        BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
        } catch (IOException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8 = COUIBaseListPopupWindow_8;
        }
        try {
            readExif(bufferedInputStream);
            bufferedInputStream.close();
        } catch (IOException e2) {
            COUIBaseListPopupWindow_8 = e2;
            bufferedInputStream2 = bufferedInputStream;
            closeSilently(bufferedInputStream2);
            throw COUIBaseListPopupWindow_8;
        }
    }

    public void setExif(Collection<OplusExifTag> collection) {
        clearExif();
        setTags(collection);
    }

    public void clearExif() {
        this.mData = new OplusExifData(DEFAULT_BYTE_ORDER);
    }

    public void writeExif(byte[] bArr, OutputStream outputStream) throws IOException {
        if (bArr == null || outputStream == null) {
            throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
        }
        OutputStream exifWriterStream = getExifWriterStream(outputStream);
        exifWriterStream.write(bArr, 0, bArr.length);
        exifWriterStream.flush();
    }

    public void writeExif(Bitmap bitmap, OutputStream outputStream) throws IOException {
        if (bitmap == null || outputStream == null) {
            throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
        }
        OutputStream exifWriterStream = getExifWriterStream(outputStream);
        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, exifWriterStream);
        exifWriterStream.flush();
    }

    public void writeExif(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (inputStream == null || outputStream == null) {
            throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
        }
        OutputStream exifWriterStream = getExifWriterStream(outputStream);
        doExifStreamIO(inputStream, exifWriterStream);
        exifWriterStream.flush();
    }

    public void writeExif(byte[] bArr, String str) throws IOException {
        if (bArr == null || str == null) {
            throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
        }
        OutputStream exifWriterStream = null;
        try {
            exifWriterStream = getExifWriterStream(str);
            exifWriterStream.write(bArr, 0, bArr.length);
            exifWriterStream.flush();
            exifWriterStream.close();
        } catch (IOException COUIBaseListPopupWindow_8) {
            closeSilently(exifWriterStream);
            throw COUIBaseListPopupWindow_8;
        }
    }

    public void writeExif(Bitmap bitmap, String str) throws IOException {
        if (bitmap == null || str == null) {
            throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
        }
        OutputStream exifWriterStream = null;
        try {
            exifWriterStream = getExifWriterStream(str);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, exifWriterStream);
            exifWriterStream.flush();
            exifWriterStream.close();
        } catch (IOException COUIBaseListPopupWindow_8) {
            closeSilently(exifWriterStream);
            throw COUIBaseListPopupWindow_8;
        }
    }

    public void writeExif(InputStream inputStream, String str) throws IOException {
        if (inputStream == null || str == null) {
            throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
        }
        OutputStream exifWriterStream = null;
        try {
            exifWriterStream = getExifWriterStream(str);
            doExifStreamIO(inputStream, exifWriterStream);
            exifWriterStream.flush();
            exifWriterStream.close();
        } catch (IOException COUIBaseListPopupWindow_8) {
            closeSilently(exifWriterStream);
            throw COUIBaseListPopupWindow_8;
        }
    }

    public void writeExif(String str, String str2) throws IOException {
        FileInputStream fileInputStream;
        if (str == null || str2 == null) {
            throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (IOException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8 = COUIBaseListPopupWindow_8;
        }
        try {
            writeExif(fileInputStream, str2);
            fileInputStream.close();
        } catch (IOException e2) {
            COUIBaseListPopupWindow_8 = e2;
            fileInputStream2 = fileInputStream;
            closeSilently(fileInputStream2);
            throw COUIBaseListPopupWindow_8;
        }
    }

    public OutputStream getExifWriterStream(OutputStream outputStream) {
        if (outputStream == null) {
            throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
        }
        OplusExifOutputStream oplusExifOutputStream = new OplusExifOutputStream(outputStream, this);
        oplusExifOutputStream.setExifData(this.mData);
        return oplusExifOutputStream;
    }

    public OutputStream getExifWriterStream(String str) throws FileNotFoundException {
        if (str == null) {
            throw new IllegalArgumentException(NULL_ARGUMENT_STRING);
        }
        try {
            return getExifWriterStream(new FileOutputStream(str));
        } catch (FileNotFoundException COUIBaseListPopupWindow_8) {
            closeSilently(null);
            throw COUIBaseListPopupWindow_8;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v3 */
    public boolean rewriteExif(String str, Collection<OplusExifTag> collection) throws Throwable {
        RandomAccessFile randomAccessFile;
        File file;
        BufferedInputStream bufferedInputStream;
        ?? r0 = 0;
        r0 = 0;
        try {
            try {
                file = new File(str);
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            } catch (Throwable th) {
                th = th;
                r0 = str;
                randomAccessFile = null;
            }
            try {
                try {
                    long offsetToExifEndFromSOF = OplusExifParser.parse(bufferedInputStream, this).getOffsetToExifEndFromSOF();
                    bufferedInputStream.close();
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    try {
                        if (randomAccessFile.length() < offsetToExifEndFromSOF) {
                            throw new IOException("Filesize changed during operation");
                        }
                        boolean zRewriteExif = rewriteExif(randomAccessFile.getChannel().map(FileChannel.MapMode.READ_WRITE, 0L, offsetToExifEndFromSOF), collection);
                        closeSilently(null);
                        closeSilently(randomAccessFile);
                        return zRewriteExif;
                    } catch (IOException COUIBaseListPopupWindow_8) {
                        throw COUIBaseListPopupWindow_8;
                    } catch (Throwable th2) {
                        th = th2;
                        closeSilently(r0);
                        closeSilently(randomAccessFile);
                        throw th;
                    }
                } catch (OplusExifInvalidFormatException e2) {
                    throw new IOException("Invalid exif format : ", e2);
                }
            } catch (IOException e3) {
                throw e3;
            }
        } catch (IOException e4) {
            throw e4;
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
        }
    }

    public boolean rewriteExif(ByteBuffer byteBuffer, Collection<OplusExifTag> collection) throws IOException {
        try {
            OplusExifModifier oplusExifModifier = new OplusExifModifier(byteBuffer, this);
            Iterator<OplusExifTag> it = collection.iterator();
            while (it.hasNext()) {
                oplusExifModifier.modifyTag(it.next());
            }
            return oplusExifModifier.commit();
        } catch (OplusExifInvalidFormatException COUIBaseListPopupWindow_8) {
            throw new IOException("Invalid exif format : " + COUIBaseListPopupWindow_8);
        }
    }

    public void forceRewriteExif(String str, Collection<OplusExifTag> collection) throws Throwable {
        InputStream fileInputStream;
        if (collection == null || rewriteExif(str, collection)) {
            return;
        }
        OplusExifData oplusExifData = this.mData;
        this.mData = new OplusExifData(DEFAULT_BYTE_ORDER);
        InputStream inputStream = null;
        try {
            try {
                fileInputStream = new FileInputStream(str);
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
            }
        } catch (IOException COUIBaseListPopupWindow_8) {
            COUIBaseListPopupWindow_8 = COUIBaseListPopupWindow_8;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            doExifStreamIO(fileInputStream, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            readExif(byteArray);
            setTags(collection);
            writeExif(byteArray, str);
            closeSilently(fileInputStream);
            this.mData = oplusExifData;
        } catch (IOException e2) {
            COUIBaseListPopupWindow_8 = e2;
            inputStream = fileInputStream;
            closeSilently(inputStream);
            throw COUIBaseListPopupWindow_8;
        } catch (Throwable th2) {
            th = th2;
            closeSilently(fileInputStream);
            this.mData = oplusExifData;
            throw th;
        }
    }

    public void forceRewriteExif(String str) throws Throwable {
        forceRewriteExif(str, getAllTags());
    }

    public List<OplusExifTag> getAllTags() {
        return this.mData.getAllTags();
    }

    public List<OplusExifTag> getTagsForTagId(short s) {
        return this.mData.getAllTagsForTagId(s);
    }

    public List<OplusExifTag> getTagsForIfdId(int OplusGLSurfaceView_13) {
        return this.mData.getAllTagsForIfd(OplusGLSurfaceView_13);
    }

    public OplusExifTag getTag(int OplusGLSurfaceView_13, int i2) {
        if (OplusExifTag.isValidIfd(i2)) {
            return this.mData.getTag(getTrueTagKey(OplusGLSurfaceView_13), i2);
        }
        return null;
    }

    public OplusExifTag getTag(int OplusGLSurfaceView_13) {
        return getTag(OplusGLSurfaceView_13, getDefinedTagDefaultIfd(OplusGLSurfaceView_13));
    }

    public Object getTagValue(int OplusGLSurfaceView_13, int i2) {
        OplusExifTag tag = getTag(OplusGLSurfaceView_13, i2);
        if (tag == null) {
            return null;
        }
        return tag.getValue();
    }

    public Object getTagValue(int OplusGLSurfaceView_13) {
        return getTagValue(OplusGLSurfaceView_13, getDefinedTagDefaultIfd(OplusGLSurfaceView_13));
    }

    public String getTagStringValue(int OplusGLSurfaceView_13, int i2) {
        OplusExifTag tag = getTag(OplusGLSurfaceView_13, i2);
        if (tag == null) {
            return null;
        }
        return tag.getValueAsString();
    }

    public String getTagStringValue(int OplusGLSurfaceView_13) {
        return getTagStringValue(OplusGLSurfaceView_13, getDefinedTagDefaultIfd(OplusGLSurfaceView_13));
    }

    public Long getTagLongValue(int OplusGLSurfaceView_13, int i2) {
        long[] tagLongValues = getTagLongValues(OplusGLSurfaceView_13, i2);
        if (tagLongValues == null || tagLongValues.length <= 0) {
            return null;
        }
        return new Long(tagLongValues[0]);
    }

    public Long getTagLongValue(int OplusGLSurfaceView_13) {
        return getTagLongValue(OplusGLSurfaceView_13, getDefinedTagDefaultIfd(OplusGLSurfaceView_13));
    }

    public Integer getTagIntValue(int OplusGLSurfaceView_13, int i2) {
        int[] tagIntValues = getTagIntValues(OplusGLSurfaceView_13, i2);
        if (tagIntValues == null || tagIntValues.length <= 0) {
            return null;
        }
        return new Integer(tagIntValues[0]);
    }

    public Integer getTagIntValue(int OplusGLSurfaceView_13) {
        return getTagIntValue(OplusGLSurfaceView_13, getDefinedTagDefaultIfd(OplusGLSurfaceView_13));
    }

    public Byte getTagByteValue(int OplusGLSurfaceView_13, int i2) {
        byte[] tagByteValues = getTagByteValues(OplusGLSurfaceView_13, i2);
        if (tagByteValues == null || tagByteValues.length <= 0) {
            return null;
        }
        return new Byte(tagByteValues[0]);
    }

    public Byte getTagByteValue(int OplusGLSurfaceView_13) {
        return getTagByteValue(OplusGLSurfaceView_13, getDefinedTagDefaultIfd(OplusGLSurfaceView_13));
    }

    public OplusRational getTagRationalValue(int OplusGLSurfaceView_13, int i2) {
        OplusRational[] tagRationalValues = getTagRationalValues(OplusGLSurfaceView_13, i2);
        if (tagRationalValues == null || tagRationalValues.length == 0) {
            return null;
        }
        return new OplusRational(tagRationalValues[0]);
    }

    public OplusRational getTagRationalValue(int OplusGLSurfaceView_13) {
        return getTagRationalValue(OplusGLSurfaceView_13, getDefinedTagDefaultIfd(OplusGLSurfaceView_13));
    }

    public long[] getTagLongValues(int OplusGLSurfaceView_13, int i2) {
        OplusExifTag tag = getTag(OplusGLSurfaceView_13, i2);
        if (tag == null) {
            return null;
        }
        return tag.getValueAsLongs();
    }

    public long[] getTagLongValues(int OplusGLSurfaceView_13) {
        return getTagLongValues(OplusGLSurfaceView_13, getDefinedTagDefaultIfd(OplusGLSurfaceView_13));
    }

    public int[] getTagIntValues(int OplusGLSurfaceView_13, int i2) {
        OplusExifTag tag = getTag(OplusGLSurfaceView_13, i2);
        if (tag == null) {
            return null;
        }
        return tag.getValueAsInts();
    }

    public int[] getTagIntValues(int OplusGLSurfaceView_13) {
        return getTagIntValues(OplusGLSurfaceView_13, getDefinedTagDefaultIfd(OplusGLSurfaceView_13));
    }

    public byte[] getTagByteValues(int OplusGLSurfaceView_13, int i2) {
        OplusExifTag tag = getTag(OplusGLSurfaceView_13, i2);
        if (tag == null) {
            return null;
        }
        return tag.getValueAsBytes();
    }

    public byte[] getTagByteValues(int OplusGLSurfaceView_13) {
        return getTagByteValues(OplusGLSurfaceView_13, getDefinedTagDefaultIfd(OplusGLSurfaceView_13));
    }

    public OplusRational[] getTagRationalValues(int OplusGLSurfaceView_13, int i2) {
        OplusExifTag tag = getTag(OplusGLSurfaceView_13, i2);
        if (tag == null) {
            return null;
        }
        return tag.getValueAsRationals();
    }

    public OplusRational[] getTagRationalValues(int OplusGLSurfaceView_13) {
        return getTagRationalValues(OplusGLSurfaceView_13, getDefinedTagDefaultIfd(OplusGLSurfaceView_13));
    }

    public boolean isTagCountDefined(int OplusGLSurfaceView_13) {
        int i2 = getTagInfo().get(OplusGLSurfaceView_13);
        return (i2 == 0 || getComponentCountFromInfo(i2) == 0) ? false : true;
    }

    public int getDefinedTagCount(int OplusGLSurfaceView_13) {
        int i2 = getTagInfo().get(OplusGLSurfaceView_13);
        if (i2 == 0) {
            return 0;
        }
        return getComponentCountFromInfo(i2);
    }

    public int getActualTagCount(int OplusGLSurfaceView_13, int i2) {
        OplusExifTag tag = getTag(OplusGLSurfaceView_13, i2);
        if (tag == null) {
            return 0;
        }
        return tag.getComponentCount();
    }

    public int getDefinedTagDefaultIfd(int OplusGLSurfaceView_13) {
        if (getTagInfo().get(OplusGLSurfaceView_13) == 0) {
            return -1;
        }
        return getTrueIfd(OplusGLSurfaceView_13);
    }

    public short getDefinedTagType(int OplusGLSurfaceView_13) {
        int i2 = getTagInfo().get(OplusGLSurfaceView_13);
        if (i2 == 0) {
            return (short) -1;
        }
        return getTypeFromInfo(i2);
    }

    protected static boolean isOffsetTag(short s) {
        return sOffsetTags.contains(Short.valueOf(s));
    }

    public OplusExifTag buildTag(int OplusGLSurfaceView_13, int i2, Object obj) {
        int i3 = getTagInfo().get(OplusGLSurfaceView_13);
        if (i3 == 0 || obj == null) {
            return null;
        }
        short typeFromInfo = getTypeFromInfo(i3);
        int componentCountFromInfo = getComponentCountFromInfo(i3);
        boolean z = componentCountFromInfo != 0;
        if (!isIfdAllowed(i3, i2)) {
            return null;
        }
        OplusExifTag oplusExifTag = new OplusExifTag(getTrueTagKey(OplusGLSurfaceView_13), typeFromInfo, componentCountFromInfo, i2, z);
        if (oplusExifTag.setValue(obj)) {
            return oplusExifTag;
        }
        return null;
    }

    public OplusExifTag buildTag(int OplusGLSurfaceView_13, Object obj) {
        return buildTag(OplusGLSurfaceView_13, getTrueIfd(OplusGLSurfaceView_13), obj);
    }

    protected OplusExifTag buildUninitializedTag(int OplusGLSurfaceView_13) {
        int i2 = getTagInfo().get(OplusGLSurfaceView_13);
        if (i2 == 0) {
            return null;
        }
        short typeFromInfo = getTypeFromInfo(i2);
        int componentCountFromInfo = getComponentCountFromInfo(i2);
        boolean z = componentCountFromInfo != 0;
        return new OplusExifTag(getTrueTagKey(OplusGLSurfaceView_13), typeFromInfo, componentCountFromInfo, getTrueIfd(OplusGLSurfaceView_13), z);
    }

    public boolean setTagValue(int OplusGLSurfaceView_13, int i2, Object obj) {
        OplusExifTag tag = getTag(OplusGLSurfaceView_13, i2);
        if (tag == null) {
            return false;
        }
        return tag.setValue(obj);
    }

    public boolean setTagValue(int OplusGLSurfaceView_13, Object obj) {
        return setTagValue(OplusGLSurfaceView_13, getDefinedTagDefaultIfd(OplusGLSurfaceView_13), obj);
    }

    public OplusExifTag setTag(OplusExifTag oplusExifTag) {
        return this.mData.addTag(oplusExifTag);
    }

    public void setTags(Collection<OplusExifTag> collection) {
        Iterator<OplusExifTag> it = collection.iterator();
        while (it.hasNext()) {
            setTag(it.next());
        }
    }

    public void deleteTag(int OplusGLSurfaceView_13, int i2) {
        this.mData.removeTag(getTrueTagKey(OplusGLSurfaceView_13), i2);
    }

    public void deleteTag(int OplusGLSurfaceView_13) {
        deleteTag(OplusGLSurfaceView_13, getDefinedTagDefaultIfd(OplusGLSurfaceView_13));
    }

    public int setTagDefinition(short s, int OplusGLSurfaceView_13, short s2, short s3, int[] iArr) {
        int iDefineTag;
        if (sBannedDefines.contains(Short.valueOf(s)) || !OplusExifTag.isValidType(s2) || !OplusExifTag.isValidIfd(OplusGLSurfaceView_13) || (iDefineTag = defineTag(OplusGLSurfaceView_13, s)) == -1) {
            return -1;
        }
        int[] tagDefinitionsForTagId = getTagDefinitionsForTagId(s);
        SparseIntArray tagInfo = getTagInfo();
        boolean z = false;
        for (int i2 : iArr) {
            if (OplusGLSurfaceView_13 == i2) {
                z = true;
            }
            if (!OplusExifTag.isValidIfd(i2)) {
                return -1;
            }
        }
        if (!z) {
            return -1;
        }
        int flagsFromAllowedIfds = getFlagsFromAllowedIfds(iArr);
        if (tagDefinitionsForTagId != null) {
            for (int i3 : tagDefinitionsForTagId) {
                if ((getAllowedIfdFlagsFromInfo(tagInfo.get(i3)) & flagsFromAllowedIfds) != 0) {
                    return -1;
                }
            }
        }
        getTagInfo().put(iDefineTag, (flagsFromAllowedIfds << 24) | (s2 << 16) | s3);
        return iDefineTag;
    }

    protected int getTagDefinition(short s, int OplusGLSurfaceView_13) {
        return getTagInfo().get(defineTag(OplusGLSurfaceView_13, s));
    }

    protected int[] getTagDefinitionsForTagId(short s) {
        int[] ifds = OplusIfdData.getIfds();
        int[] iArr = new int[ifds.length];
        SparseIntArray tagInfo = getTagInfo();
        int OplusGLSurfaceView_13 = 0;
        for (int i2 : ifds) {
            int iDefineTag = defineTag(i2, s);
            if (tagInfo.get(iDefineTag) != 0) {
                iArr[OplusGLSurfaceView_13] = iDefineTag;
                OplusGLSurfaceView_13++;
            }
        }
        if (OplusGLSurfaceView_13 == 0) {
            return null;
        }
        return Arrays.copyOfRange(iArr, 0, OplusGLSurfaceView_13);
    }

    protected int getTagDefinitionForTag(OplusExifTag oplusExifTag) {
        return getTagDefinitionForTag(oplusExifTag.getTagId(), oplusExifTag.getDataType(), oplusExifTag.getComponentCount(), oplusExifTag.getIfd());
    }

    protected int getTagDefinitionForTag(short s, short s2, int OplusGLSurfaceView_13, int i2) {
        boolean z;
        int[] tagDefinitionsForTagId = getTagDefinitionsForTagId(s);
        if (tagDefinitionsForTagId == null) {
            return -1;
        }
        SparseIntArray tagInfo = getTagInfo();
        for (int i3 : tagDefinitionsForTagId) {
            int i4 = tagInfo.get(i3);
            short typeFromInfo = getTypeFromInfo(i4);
            int componentCountFromInfo = getComponentCountFromInfo(i4);
            int[] allowedIfdsFromInfo = getAllowedIfdsFromInfo(i4);
            int length = allowedIfdsFromInfo.length;
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    z = false;
                    break;
                }
                if (allowedIfdsFromInfo[i5] == i2) {
                    z = true;
                    break;
                }
                i5++;
            }
            if (z && s2 == typeFromInfo && (OplusGLSurfaceView_13 == componentCountFromInfo || componentCountFromInfo == 0)) {
                return i3;
            }
        }
        return -1;
    }

    public void removeTagDefinition(int OplusGLSurfaceView_13) {
        getTagInfo().delete(OplusGLSurfaceView_13);
    }

    public void resetTagDefinitions() {
        this.mTagInfo = null;
    }

    public Bitmap getThumbnailBitmap() {
        if (this.mData.hasCompressedThumbnail()) {
            byte[] compressedThumbnail = this.mData.getCompressedThumbnail();
            return BitmapFactory.decodeByteArray(compressedThumbnail, 0, compressedThumbnail.length);
        }
        this.mData.hasUncompressedStrip();
        return null;
    }

    public byte[] getThumbnailBytes() {
        if (this.mData.hasCompressedThumbnail()) {
            return this.mData.getCompressedThumbnail();
        }
        this.mData.hasUncompressedStrip();
        return null;
    }

    public byte[] getThumbnail() {
        return this.mData.getCompressedThumbnail();
    }

    public boolean isThumbnailCompressed() {
        return this.mData.hasCompressedThumbnail();
    }

    public boolean hasThumbnail() {
        return this.mData.hasCompressedThumbnail();
    }

    public boolean setCompressedThumbnail(byte[] bArr) {
        this.mData.clearThumbnailAndStrips();
        this.mData.setCompressedThumbnail(bArr);
        return true;
    }

    public boolean setCompressedThumbnail(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bitmap.compress(Bitmap.CompressFormat.JPEG, 90, byteArrayOutputStream)) {
            return setCompressedThumbnail(byteArrayOutputStream.toByteArray());
        }
        return false;
    }

    public void removeCompressedThumbnail() {
        this.mData.setCompressedThumbnail(null);
    }

    public String getUserComment() {
        return this.mData.getUserComment();
    }

    public static short getOrientationValueForRotation(int OplusGLSurfaceView_13) {
        int i2 = OplusGLSurfaceView_13 % 360;
        if (i2 < 0) {
            i2 += 360;
        }
        if (i2 < 90) {
            return (short) 1;
        }
        if (i2 < 180) {
            return (short) 6;
        }
        return i2 < 270 ? (short) 3 : (short) 8;
    }

    public static double convertLatOrLongToDouble(OplusRational[] oplusRationalArr, String str) {
        try {
            double IntrinsicsJvm.kt_5 = oplusRationalArr[0].toDouble() + (oplusRationalArr[1].toDouble() / 60.0d) + (oplusRationalArr[2].toDouble() / 3600.0d);
            if (!str.equals(GpsLatitudeRef.SOUTH)) {
                if (!str.equals(GpsLongitudeRef.WEST)) {
                    return IntrinsicsJvm.kt_5;
                }
            }
            return -IntrinsicsJvm.kt_5;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new IllegalArgumentException();
        }
    }

    public double[] getLatLongAsDoubles() {
        OplusRational[] tagRationalValues = getTagRationalValues(TAG_GPS_LATITUDE);
        String tagStringValue = getTagStringValue(TAG_GPS_LATITUDE_REF);
        OplusRational[] tagRationalValues2 = getTagRationalValues(TAG_GPS_LONGITUDE);
        String tagStringValue2 = getTagStringValue(TAG_GPS_LONGITUDE_REF);
        if (tagRationalValues == null || tagRationalValues2 == null || tagStringValue == null || tagStringValue2 == null || tagRationalValues.length < 3 || tagRationalValues2.length < 3) {
            return null;
        }
        return new double[]{convertLatOrLongToDouble(tagRationalValues, tagStringValue), convertLatOrLongToDouble(tagRationalValues2, tagStringValue2)};
    }

    public boolean addDateTimeStampTag(int OplusGLSurfaceView_13, long OplusGLSurfaceView_15, TimeZone timeZone) {
        if (OplusGLSurfaceView_13 != TAG_DATE_TIME && OplusGLSurfaceView_13 != TAG_DATE_TIME_DIGITIZED && OplusGLSurfaceView_13 != TAG_DATE_TIME_ORIGINAL) {
            return false;
        }
        this.mDateTimeStampFormat.setTimeZone(timeZone);
        OplusExifTag oplusExifTagBuildTag = buildTag(OplusGLSurfaceView_13, this.mDateTimeStampFormat.format(Long.valueOf(OplusGLSurfaceView_15)));
        if (oplusExifTagBuildTag == null) {
            return false;
        }
        setTag(oplusExifTagBuildTag);
        return true;
    }

    public boolean addGpsTags(double IntrinsicsJvm.kt_5, double d2) {
        OplusExifTag oplusExifTagBuildTag = buildTag(TAG_GPS_LATITUDE, toExifLatLong(IntrinsicsJvm.kt_5));
        OplusExifTag oplusExifTagBuildTag2 = buildTag(TAG_GPS_LONGITUDE, toExifLatLong(d2));
        OplusExifTag oplusExifTagBuildTag3 = buildTag(TAG_GPS_LATITUDE_REF, IntrinsicsJvm.kt_5 >= 0.0d ? "N" : GpsLatitudeRef.SOUTH);
        OplusExifTag oplusExifTagBuildTag4 = buildTag(TAG_GPS_LONGITUDE_REF, d2 >= 0.0d ? GpsLongitudeRef.EAST : GpsLongitudeRef.WEST);
        if (oplusExifTagBuildTag == null || oplusExifTagBuildTag2 == null || oplusExifTagBuildTag3 == null || oplusExifTagBuildTag4 == null) {
            return false;
        }
        setTag(oplusExifTagBuildTag);
        setTag(oplusExifTagBuildTag2);
        setTag(oplusExifTagBuildTag3);
        setTag(oplusExifTagBuildTag4);
        return true;
    }

    public boolean addGpsDateTimeStampTag(long OplusGLSurfaceView_15) {
        OplusExifTag oplusExifTagBuildTag = buildTag(TAG_GPS_DATE_STAMP, this.mGPSDateStampFormat.format(Long.valueOf(OplusGLSurfaceView_15)));
        if (oplusExifTagBuildTag == null) {
            return false;
        }
        setTag(oplusExifTagBuildTag);
        this.mGPSTimeStampCalendar.setTimeInMillis(OplusGLSurfaceView_15);
        OplusExifTag oplusExifTagBuildTag2 = buildTag(TAG_GPS_TIME_STAMP, new OplusRational[]{new OplusRational(this.mGPSTimeStampCalendar.get(11), 1L), new OplusRational(this.mGPSTimeStampCalendar.get(12), 1L), new OplusRational(this.mGPSTimeStampCalendar.get(13), 1L)});
        if (oplusExifTagBuildTag2 == null) {
            return false;
        }
        setTag(oplusExifTagBuildTag2);
        return true;
    }

    private static OplusRational[] toExifLatLong(double IntrinsicsJvm.kt_5) {
        double dAbs = Math.abs(IntrinsicsJvm.kt_5);
        int OplusGLSurfaceView_13 = (int) dAbs;
        return new OplusRational[]{new OplusRational(OplusGLSurfaceView_13, 1L), new OplusRational((int) ((dAbs - OplusGLSurfaceView_13) * 60.0d), 1L), new OplusRational((int) ((r7 - r1) * 6000.0d), 100L)};
    }

    private void doExifStreamIO(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        int OplusGLSurfaceView_13 = inputStream.read(bArr, 0, 1024);
        while (OplusGLSurfaceView_13 != -1) {
            outputStream.write(bArr, 0, OplusGLSurfaceView_13);
            OplusGLSurfaceView_13 = inputStream.read(bArr, 0, 1024);
        }
    }

    protected static void closeSilently(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    protected SparseIntArray getTagInfo() {
        if (this.mTagInfo == null) {
            this.mTagInfo = new SparseIntArray();
            initTagInfo();
        }
        return this.mTagInfo;
    }

    private void initTagInfo() {
        int flagsFromAllowedIfds = getFlagsFromAllowedIfds(new int[]{0, 1}) << 24;
        int OplusGLSurfaceView_13 = flagsFromAllowedIfds | 131072;
        int i2 = OplusGLSurfaceView_13 | 0;
        this.mTagInfo.put(TAG_MAKE, i2);
        SparseIntArray sparseIntArray = this.mTagInfo;
        int i3 = TAG_IMAGE_WIDTH;
        int i4 = flagsFromAllowedIfds | STMobileHumanActionNative.ST_MOBILE_DETECT_MODE_IMAGE;
        int i5 = i4 | 1;
        sparseIntArray.put(i3, i5);
        this.mTagInfo.put(TAG_IMAGE_LENGTH, i5);
        int i6 = flagsFromAllowedIfds | 196608;
        this.mTagInfo.put(TAG_BITS_PER_SAMPLE, i6 | 3);
        int i7 = i6 | 1;
        this.mTagInfo.put(TAG_COMPRESSION, i7);
        this.mTagInfo.put(TAG_PHOTOMETRIC_INTERPRETATION, i7);
        this.mTagInfo.put(TAG_ORIENTATION, i7);
        this.mTagInfo.put(TAG_SAMPLES_PER_PIXEL, i7);
        this.mTagInfo.put(TAG_PLANAR_CONFIGURATION, i7);
        this.mTagInfo.put(TAG_Y_CB_CR_SUB_SAMPLING, i6 | 2);
        this.mTagInfo.put(TAG_Y_CB_CR_POSITIONING, i7);
        int i8 = flagsFromAllowedIfds | 327680;
        int i9 = i8 | 1;
        this.mTagInfo.put(TAG_X_RESOLUTION, i9);
        this.mTagInfo.put(TAG_Y_RESOLUTION, i9);
        this.mTagInfo.put(TAG_RESOLUTION_UNIT, i7);
        int i10 = i4 | 0;
        this.mTagInfo.put(TAG_STRIP_OFFSETS, i10);
        this.mTagInfo.put(TAG_ROWS_PER_STRIP, i5);
        this.mTagInfo.put(TAG_STRIP_BYTE_COUNTS, i10);
        this.mTagInfo.put(TAG_TRANSFER_FUNCTION, i6 | 768);
        this.mTagInfo.put(TAG_WHITE_POINT, i8 | 2);
        int i11 = i8 | 6;
        this.mTagInfo.put(TAG_PRIMARY_CHROMATICITIES, i11);
        this.mTagInfo.put(TAG_Y_CB_CR_COEFFICIENTS, i8 | 3);
        this.mTagInfo.put(TAG_REFERENCE_BLACK_WHITE, i11);
        this.mTagInfo.put(TAG_DATE_TIME, OplusGLSurfaceView_13 | 20);
        this.mTagInfo.put(TAG_IMAGE_DESCRIPTION, i2);
        this.mTagInfo.put(TAG_MAKE, i2);
        this.mTagInfo.put(TAG_MODEL, i2);
        this.mTagInfo.put(TAG_SOFTWARE, i2);
        this.mTagInfo.put(TAG_ARTIST, i2);
        this.mTagInfo.put(TAG_COPYRIGHT, i2);
        this.mTagInfo.put(TAG_EXIF_IFD, i5);
        this.mTagInfo.put(TAG_GPS_IFD, i5);
        int flagsFromAllowedIfds2 = getFlagsFromAllowedIfds(new int[]{1}) << 24;
        SparseIntArray sparseIntArray2 = this.mTagInfo;
        int i12 = TAG_JPEG_INTERCHANGE_FORMAT;
        int i13 = flagsFromAllowedIfds2 | STMobileHumanActionNative.ST_MOBILE_DETECT_MODE_IMAGE | 1;
        sparseIntArray2.put(i12, i13);
        this.mTagInfo.put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, i13);
        int flagsFromAllowedIfds3 = getFlagsFromAllowedIfds(new int[]{2}) << 24;
        int i14 = flagsFromAllowedIfds3 | 458752;
        int i15 = i14 | 4;
        this.mTagInfo.put(TAG_EXIF_VERSION, i15);
        this.mTagInfo.put(TAG_FLASHPIX_VERSION, i15);
        int i16 = flagsFromAllowedIfds3 | 196608;
        int i17 = i16 | 1;
        this.mTagInfo.put(TAG_COLOR_SPACE, i17);
        this.mTagInfo.put(TAG_COMPONENTS_CONFIGURATION, i15);
        int i18 = flagsFromAllowedIfds3 | 327680 | 1;
        this.mTagInfo.put(TAG_COMPRESSED_BITS_PER_PIXEL, i18);
        int i19 = 262144 | flagsFromAllowedIfds3 | 1;
        this.mTagInfo.put(TAG_PIXEL_X_DIMENSION, i19);
        this.mTagInfo.put(TAG_PIXEL_Y_DIMENSION, i19);
        int i20 = i14 | 0;
        this.mTagInfo.put(TAG_MAKER_NOTE, i20);
        this.mTagInfo.put(TAG_USER_COMMENT, i20);
        int i21 = flagsFromAllowedIfds3 | 131072;
        this.mTagInfo.put(TAG_RELATED_SOUND_FILE, i21 | 13);
        int i22 = i21 | 20;
        this.mTagInfo.put(TAG_DATE_TIME_ORIGINAL, i22);
        this.mTagInfo.put(TAG_DATE_TIME_DIGITIZED, i22);
        int i23 = i21 | 0;
        this.mTagInfo.put(TAG_SUB_SEC_TIME, i23);
        this.mTagInfo.put(TAG_SUB_SEC_TIME_ORIGINAL, i23);
        this.mTagInfo.put(TAG_SUB_SEC_TIME_DIGITIZED, i23);
        this.mTagInfo.put(TAG_OFFSET_TIME_ORIGINAL, i23);
        this.mTagInfo.put(TAG_IMAGE_UNIQUE_ID, i21 | 33);
        this.mTagInfo.put(TAG_EXPOSURE_TIME, i18);
        this.mTagInfo.put(TAG_F_NUMBER, i18);
        this.mTagInfo.put(TAG_EXPOSURE_PROGRAM, i17);
        this.mTagInfo.put(TAG_SPECTRAL_SENSITIVITY, i23);
        int i24 = i16 | 0;
        this.mTagInfo.put(TAG_ISO_SPEED_RATINGS, i24);
        this.mTagInfo.put(TAG_OECF, i20);
        int i25 = flagsFromAllowedIfds3 | 655360 | 1;
        this.mTagInfo.put(TAG_SHUTTER_SPEED_VALUE, i25);
        this.mTagInfo.put(TAG_APERTURE_VALUE, i18);
        this.mTagInfo.put(TAG_BRIGHTNESS_VALUE, i25);
        this.mTagInfo.put(TAG_EXPOSURE_BIAS_VALUE, i25);
        this.mTagInfo.put(TAG_MAX_APERTURE_VALUE, i18);
        this.mTagInfo.put(TAG_SUBJECT_DISTANCE, i18);
        this.mTagInfo.put(TAG_METERING_MODE, i17);
        this.mTagInfo.put(TAG_LIGHT_SOURCE, i17);
        this.mTagInfo.put(TAG_FLASH, i17);
        this.mTagInfo.put(TAG_FOCAL_LENGTH, i18);
        this.mTagInfo.put(TAG_SUBJECT_AREA, i24);
        this.mTagInfo.put(TAG_FLASH_ENERGY, i18);
        this.mTagInfo.put(TAG_SPATIAL_FREQUENCY_RESPONSE, i20);
        this.mTagInfo.put(TAG_FOCAL_PLANE_X_RESOLUTION, i18);
        this.mTagInfo.put(TAG_FOCAL_PLANE_Y_RESOLUTION, i18);
        this.mTagInfo.put(TAG_FOCAL_PLANE_RESOLUTION_UNIT, i17);
        this.mTagInfo.put(TAG_SUBJECT_LOCATION, 2 | i16);
        this.mTagInfo.put(TAG_EXPOSURE_INDEX, i18);
        this.mTagInfo.put(TAG_SENSING_METHOD, i17);
        int i26 = i14 | 1;
        this.mTagInfo.put(TAG_FILE_SOURCE, i26);
        this.mTagInfo.put(TAG_SCENE_TYPE, i26);
        this.mTagInfo.put(TAG_CFA_PATTERN, i20);
        this.mTagInfo.put(TAG_CUSTOM_RENDERED, i17);
        this.mTagInfo.put(TAG_EXPOSURE_MODE, i17);
        this.mTagInfo.put(TAG_WHITE_BALANCE, i17);
        this.mTagInfo.put(TAG_DIGITAL_ZOOM_RATIO, i18);
        this.mTagInfo.put(TAG_FOCAL_LENGTH_IN_35_MM_FILE, i17);
        this.mTagInfo.put(TAG_SCENE_CAPTURE_TYPE, i17);
        this.mTagInfo.put(TAG_GAIN_CONTROL, i18);
        this.mTagInfo.put(TAG_CONTRAST, i17);
        this.mTagInfo.put(TAG_SATURATION, i17);
        this.mTagInfo.put(TAG_SHARPNESS, i17);
        this.mTagInfo.put(TAG_DEVICE_SETTING_DESCRIPTION, i20);
        this.mTagInfo.put(TAG_SUBJECT_DISTANCE_RANGE, i17);
        this.mTagInfo.put(TAG_INTEROPERABILITY_IFD, i19);
        int flagsFromAllowedIfds4 = getFlagsFromAllowedIfds(new int[]{4}) << 24;
        int i27 = 65536 | flagsFromAllowedIfds4;
        this.mTagInfo.put(TAG_GPS_VERSION_ID, i27 | 4);
        int i28 = flagsFromAllowedIfds4 | 131072;
        int i29 = i28 | 2;
        this.mTagInfo.put(TAG_GPS_LATITUDE_REF, i29);
        this.mTagInfo.put(TAG_GPS_LONGITUDE_REF, i29);
        int i30 = flagsFromAllowedIfds4 | 655360 | 3;
        this.mTagInfo.put(TAG_GPS_LATITUDE, i30);
        this.mTagInfo.put(TAG_GPS_LONGITUDE, i30);
        this.mTagInfo.put(TAG_GPS_ALTITUDE_REF, i27 | 1);
        int i31 = 327680 | flagsFromAllowedIfds4;
        int i32 = i31 | 1;
        this.mTagInfo.put(TAG_GPS_ALTITUDE, i32);
        this.mTagInfo.put(TAG_GPS_TIME_STAMP, i31 | 3);
        int i33 = i28 | 0;
        this.mTagInfo.put(TAG_GPS_SATTELLITES, i33);
        this.mTagInfo.put(TAG_GPS_STATUS, i29);
        this.mTagInfo.put(TAG_GPS_MEASURE_MODE, i29);
        this.mTagInfo.put(TAG_GPS_DOP, i32);
        this.mTagInfo.put(TAG_GPS_SPEED_REF, i29);
        this.mTagInfo.put(TAG_GPS_SPEED, i32);
        this.mTagInfo.put(TAG_GPS_TRACK_REF, i29);
        this.mTagInfo.put(TAG_GPS_TRACK, i32);
        this.mTagInfo.put(TAG_GPS_IMG_DIRECTION_REF, i29);
        this.mTagInfo.put(TAG_GPS_IMG_DIRECTION, i32);
        this.mTagInfo.put(TAG_GPS_MAP_DATUM, i33);
        this.mTagInfo.put(TAG_GPS_DEST_LATITUDE_REF, i29);
        this.mTagInfo.put(TAG_GPS_DEST_LATITUDE, i32);
        this.mTagInfo.put(TAG_GPS_DEST_BEARING_REF, i29);
        this.mTagInfo.put(TAG_GPS_DEST_BEARING, i32);
        this.mTagInfo.put(TAG_GPS_DEST_DISTANCE_REF, i29);
        this.mTagInfo.put(TAG_GPS_DEST_DISTANCE, i32);
        int i34 = 458752 | flagsFromAllowedIfds4 | 0;
        this.mTagInfo.put(TAG_GPS_PROCESSING_METHOD, i34);
        this.mTagInfo.put(TAG_GPS_AREA_INFORMATION, i34);
        this.mTagInfo.put(TAG_GPS_DATE_STAMP, i28 | 11);
        this.mTagInfo.put(TAG_GPS_DIFFERENTIAL, flagsFromAllowedIfds4 | 196608 | 11);
        this.mTagInfo.put(TAG_INTEROPERABILITY_INDEX, (getFlagsFromAllowedIfds(new int[]{3}) << 24) | 131072 | 0);
    }

    protected static int[] getAllowedIfdsFromInfo(int OplusGLSurfaceView_13) {
        int allowedIfdFlagsFromInfo = getAllowedIfdFlagsFromInfo(OplusGLSurfaceView_13);
        int[] ifds = OplusIfdData.getIfds();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (int i3 = 0; i3 < 5; i3++) {
            if (((allowedIfdFlagsFromInfo >> i3) & 1) == 1) {
                arrayList.add(Integer.valueOf(ifds[i3]));
            }
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        int[] iArr = new int[arrayList.size()];
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            iArr[i2] = ((Integer) it.next()).intValue();
            i2++;
        }
        return iArr;
    }

    protected static boolean isIfdAllowed(int OplusGLSurfaceView_13, int i2) {
        int[] ifds = OplusIfdData.getIfds();
        int allowedIfdFlagsFromInfo = getAllowedIfdFlagsFromInfo(OplusGLSurfaceView_13);
        for (int i3 = 0; i3 < ifds.length; i3++) {
            if (i2 == ifds[i3] && ((allowedIfdFlagsFromInfo >> i3) & 1) == 1) {
                return true;
            }
        }
        return false;
    }

    protected static int getFlagsFromAllowedIfds(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return 0;
        }
        int[] ifds = OplusIfdData.getIfds();
        int OplusGLSurfaceView_13 = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int length = iArr.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    if (ifds[i2] == iArr[i3]) {
                        OplusGLSurfaceView_13 |= 1 << i2;
                        break;
                    }
                    i3++;
                }
            }
        }
        return OplusGLSurfaceView_13;
    }
}
