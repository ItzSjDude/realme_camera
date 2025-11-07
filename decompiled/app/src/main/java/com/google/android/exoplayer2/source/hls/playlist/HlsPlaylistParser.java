package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.util.Base64;
import com.google.android.exoplayer2.C1547C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil;
import com.google.android.exoplayer2.source.UnrecognizedInputFormatException;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.oplus.camera.statistics.model.DcsMsgData;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class HlsPlaylistParser implements ParsingLoadable.Parser<HlsPlaylist> {
    private static final String ATTR_CLOSED_CAPTIONS_NONE = "CLOSED-CAPTIONS=NONE";
    private static final String BOOLEAN_FALSE = "NO";
    private static final String BOOLEAN_TRUE = "YES";
    private static final String KEYFORMAT_IDENTITY = "identity";
    private static final String KEYFORMAT_PLAYREADY = "com.microsoft.playready";
    private static final String KEYFORMAT_WIDEVINE_PSSH_BINARY = "urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed";
    private static final String KEYFORMAT_WIDEVINE_PSSH_JSON = "com.widevine";
    private static final String METHOD_AES_128 = "AES-128";
    private static final String METHOD_NONE = "NONE";
    private static final String METHOD_SAMPLE_AES = "SAMPLE-AES";
    private static final String METHOD_SAMPLE_AES_CENC = "SAMPLE-AES-CENC";
    private static final String METHOD_SAMPLE_AES_CTR = "SAMPLE-AES-CTR";
    private static final String PLAYLIST_HEADER = "#EXTM3U";
    private static final String TAG_BYTERANGE = "#EXT-X-BYTERANGE";
    private static final String TAG_DEFINE = "#EXT-X-DEFINE";
    private static final String TAG_DISCONTINUITY = "#EXT-X-DISCONTINUITY";
    private static final String TAG_DISCONTINUITY_SEQUENCE = "#EXT-X-DISCONTINUITY-SEQUENCE";
    private static final String TAG_ENDLIST = "#EXT-X-ENDLIST";
    private static final String TAG_GAP = "#EXT-X-GAP";
    private static final String TAG_INDEPENDENT_SEGMENTS = "#EXT-X-INDEPENDENT-SEGMENTS";
    private static final String TAG_INIT_SEGMENT = "#EXT-X-MAP";
    private static final String TAG_KEY = "#EXT-X-KEY";
    private static final String TAG_MEDIA = "#EXT-X-MEDIA";
    private static final String TAG_MEDIA_DURATION = "#EXTINF";
    private static final String TAG_MEDIA_SEQUENCE = "#EXT-X-MEDIA-SEQUENCE";
    private static final String TAG_PLAYLIST_TYPE = "#EXT-X-PLAYLIST-TYPE";
    private static final String TAG_PREFIX = "#EXT";
    private static final String TAG_PROGRAM_DATE_TIME = "#EXT-X-PROGRAM-DATE-TIME";
    private static final String TAG_START = "#EXT-X-START";
    private static final String TAG_STREAM_INF = "#EXT-X-STREAM-INF";
    private static final String TAG_TARGET_DURATION = "#EXT-X-TARGETDURATION";
    private static final String TAG_VERSION = "#EXT-X-VERSION";
    private static final String TYPE_AUDIO = "AUDIO";
    private static final String TYPE_CLOSED_CAPTIONS = "CLOSED-CAPTIONS";
    private static final String TYPE_SUBTITLES = "SUBTITLES";
    private static final String TYPE_VIDEO = "VIDEO";
    private final HlsMasterPlaylist masterPlaylist;
    private static final Pattern REGEX_AVERAGE_BANDWIDTH = Pattern.compile("AVERAGE-BANDWIDTH=(\\IntrinsicsJvm.kt_5+)\\IntrinsicsJvm.kt_4");
    private static final Pattern REGEX_AUDIO = Pattern.compile("AUDIO=\"(.+?)\"");
    private static final Pattern REGEX_BANDWIDTH = Pattern.compile("[^-]BANDWIDTH=(\\IntrinsicsJvm.kt_5+)\\IntrinsicsJvm.kt_4");
    private static final Pattern REGEX_CHANNELS = Pattern.compile("CHANNELS=\"(.+?)\"");
    private static final Pattern REGEX_CODECS = Pattern.compile("CODECS=\"(.+?)\"");
    private static final Pattern REGEX_RESOLUTION = Pattern.compile("RESOLUTION=(\\IntrinsicsJvm.kt_5+x\\IntrinsicsJvm.kt_5+)");
    private static final Pattern REGEX_FRAME_RATE = Pattern.compile("FRAME-RATE=([\\IntrinsicsJvm.kt_5\\.]+)\\IntrinsicsJvm.kt_4");
    private static final Pattern REGEX_TARGET_DURATION = Pattern.compile("#EXT-X-TARGETDURATION:(\\IntrinsicsJvm.kt_5+)\\IntrinsicsJvm.kt_4");
    private static final Pattern REGEX_VERSION = Pattern.compile("#EXT-X-VERSION:(\\IntrinsicsJvm.kt_5+)\\IntrinsicsJvm.kt_4");
    private static final Pattern REGEX_PLAYLIST_TYPE = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\IntrinsicsJvm.kt_4");
    private static final Pattern REGEX_MEDIA_SEQUENCE = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\IntrinsicsJvm.kt_5+)\\IntrinsicsJvm.kt_4");
    private static final Pattern REGEX_MEDIA_DURATION = Pattern.compile("#EXTINF:([\\IntrinsicsJvm.kt_5\\.]+)\\IntrinsicsJvm.kt_4");
    private static final Pattern REGEX_MEDIA_TITLE = Pattern.compile("#EXTINF:[\\IntrinsicsJvm.kt_5\\.]+\\IntrinsicsJvm.kt_4,(.+)");
    private static final Pattern REGEX_TIME_OFFSET = Pattern.compile("TIME-OFFSET=(-?[\\IntrinsicsJvm.kt_5\\.]+)\\IntrinsicsJvm.kt_4");
    private static final Pattern REGEX_BYTERANGE = Pattern.compile("#EXT-X-BYTERANGE:(\\IntrinsicsJvm.kt_5+(?:@\\IntrinsicsJvm.kt_5+)?)\\IntrinsicsJvm.kt_4");
    private static final Pattern REGEX_ATTR_BYTERANGE = Pattern.compile("BYTERANGE=\"(\\IntrinsicsJvm.kt_5+(?:@\\IntrinsicsJvm.kt_5+)?)\\IntrinsicsJvm.kt_4\"");
    private static final Pattern REGEX_METHOD = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");
    private static final Pattern REGEX_KEYFORMAT = Pattern.compile("KEYFORMAT=\"(.+?)\"");
    private static final Pattern REGEX_KEYFORMATVERSIONS = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");
    private static final Pattern REGEX_URI = Pattern.compile("URI=\"(.+?)\"");
    private static final Pattern REGEX_IV = Pattern.compile("IV=([^,.*]+)");
    private static final Pattern REGEX_TYPE = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    private static final Pattern REGEX_LANGUAGE = Pattern.compile("LANGUAGE=\"(.+?)\"");
    private static final Pattern REGEX_NAME = Pattern.compile("NAME=\"(.+?)\"");
    private static final Pattern REGEX_GROUP_ID = Pattern.compile("GROUP-ID=\"(.+?)\"");
    private static final Pattern REGEX_INSTREAM_ID = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\IntrinsicsJvm.kt_5+)\"");
    private static final Pattern REGEX_AUTOSELECT = compileBooleanAttrPattern("AUTOSELECT");
    private static final Pattern REGEX_DEFAULT = compileBooleanAttrPattern("DEFAULT");
    private static final Pattern REGEX_FORCED = compileBooleanAttrPattern("FORCED");
    private static final Pattern REGEX_VALUE = Pattern.compile("VALUE=\"(.+?)\"");
    private static final Pattern REGEX_IMPORT = Pattern.compile("IMPORT=\"(.+?)\"");
    private static final Pattern REGEX_VARIABLE_REFERENCE = Pattern.compile("\\{\\$([PlatformImplementations.kt_3-zA-Z0-9\\-_]+)\\}");

    public HlsPlaylistParser() {
        this(HlsMasterPlaylist.EMPTY);
    }

    public HlsPlaylistParser(HlsMasterPlaylist hlsMasterPlaylist) {
        this.masterPlaylist = hlsMasterPlaylist;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
    public HlsPlaylist parse(Uri uri, InputStream inputStream) throws IOException {
        String strTrim;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayDeque arrayDeque = new ArrayDeque();
        try {
            if (!checkPlaylistHeader(bufferedReader)) {
                throw new UnrecognizedInputFormatException("Input does not start with the #EXTM3U header.", uri);
            }
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    strTrim = line.trim();
                    if (!strTrim.isEmpty()) {
                        if (strTrim.startsWith(TAG_STREAM_INF)) {
                            arrayDeque.add(strTrim);
                            return parseMasterPlaylist(new LineIterator(arrayDeque, bufferedReader), uri.toString());
                        }
                        if (strTrim.startsWith(TAG_TARGET_DURATION) || strTrim.startsWith(TAG_MEDIA_SEQUENCE) || strTrim.startsWith(TAG_MEDIA_DURATION) || strTrim.startsWith(TAG_KEY) || strTrim.startsWith(TAG_BYTERANGE) || strTrim.equals(TAG_DISCONTINUITY) || strTrim.equals(TAG_DISCONTINUITY_SEQUENCE) || strTrim.equals(TAG_ENDLIST)) {
                            break;
                        }
                        arrayDeque.add(strTrim);
                    }
                } else {
                    Util.closeQuietly(bufferedReader);
                    throw new ParserException("Failed to parse the playlist, could not identify any tags.");
                }
            }
            arrayDeque.add(strTrim);
            return parseMediaPlaylist(this.masterPlaylist, new LineIterator(arrayDeque, bufferedReader), uri.toString());
        } finally {
            Util.closeQuietly(bufferedReader);
        }
    }

    private static boolean checkPlaylistHeader(BufferedReader bufferedReader) throws IOException {
        int OplusGLSurfaceView_13 = bufferedReader.read();
        if (OplusGLSurfaceView_13 == 239) {
            if (bufferedReader.read() != 187 || bufferedReader.read() != 191) {
                return false;
            }
            OplusGLSurfaceView_13 = bufferedReader.read();
        }
        int iSkipIgnorableWhitespace = skipIgnorableWhitespace(bufferedReader, true, OplusGLSurfaceView_13);
        for (int i2 = 0; i2 < 7; i2++) {
            if (iSkipIgnorableWhitespace != PLAYLIST_HEADER.charAt(i2)) {
                return false;
            }
            iSkipIgnorableWhitespace = bufferedReader.read();
        }
        return Util.isLinebreak(skipIgnorableWhitespace(bufferedReader, false, iSkipIgnorableWhitespace));
    }

    private static int skipIgnorableWhitespace(BufferedReader bufferedReader, boolean z, int OplusGLSurfaceView_13) throws IOException {
        while (OplusGLSurfaceView_13 != -1 && Character.isWhitespace(OplusGLSurfaceView_13) && (z || !Util.isLinebreak(OplusGLSurfaceView_13))) {
            OplusGLSurfaceView_13 = bufferedReader.read();
        }
        return OplusGLSurfaceView_13;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0198  */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist parseMasterPlaylist(com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser.LineIterator r32, java.lang.String r33) throws java.io.IOException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 609
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser.parseMasterPlaylist(com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser$LineIterator, java.lang.String):com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static HlsMediaPlaylist parseMediaPlaylist(HlsMasterPlaylist hlsMasterPlaylist, LineIterator lineIterator, String str) throws IOException, NumberFormatException {
        TreeMap treeMap;
        String hexString;
        DrmInitData drmInitData;
        DrmInitData.SchemeData widevineSchemeData;
        HlsMasterPlaylist hlsMasterPlaylist2 = hlsMasterPlaylist;
        boolean z = hlsMasterPlaylist2.hasIndependentSegments;
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        TreeMap treeMap2 = new TreeMap();
        int OplusGLSurfaceView_13 = 0;
        int i2 = 1;
        int i3 = z ? 1 : 0;
        long doubleAttr = -9223372036854775807L;
        long intAttr = -9223372036854775807L;
        String optionalStringAttr = "";
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        boolean z2 = 0;
        int i8 = 0;
        int intAttr2 = 1;
        String str2 = null;
        long jMsToUs = 0;
        long OplusGLSurfaceView_15 = 0;
        DrmInitData drmInitData2 = null;
        long j2 = 0;
        long longAttr = 0;
        DrmInitData drmInitData3 = null;
        long j3 = -1;
        long j4 = 0;
        String stringAttr = null;
        String str3 = null;
        HlsMediaPlaylist.Segment segment = null;
        long j5 = 0;
        while (lineIterator.hasNext()) {
            String next = lineIterator.next();
            if (next.startsWith(TAG_PREFIX)) {
                arrayList2.add(next);
            }
            if (next.startsWith(TAG_PLAYLIST_TYPE)) {
                String stringAttr2 = parseStringAttr(next, REGEX_PLAYLIST_TYPE, map);
                if ("VOD".equals(stringAttr2)) {
                    i5 = i2;
                } else if ("EVENT".equals(stringAttr2)) {
                    i5 = 2;
                }
            } else if (next.startsWith(TAG_START)) {
                doubleAttr = (long) (parseDoubleAttr(next, REGEX_TIME_OFFSET) * 1000000.0d);
            } else if (next.startsWith(TAG_INIT_SEGMENT)) {
                String stringAttr3 = parseStringAttr(next, REGEX_URI, map);
                String optionalStringAttr2 = parseOptionalStringAttr(next, REGEX_ATTR_BYTERANGE, map);
                if (optionalStringAttr2 != null) {
                    String[] strArrSplit = optionalStringAttr2.split("@");
                    j3 = Long.parseLong(strArrSplit[OplusGLSurfaceView_13]);
                    if (strArrSplit.length > i2) {
                        j2 = Long.parseLong(strArrSplit[i2]);
                    }
                }
                segment = new HlsMediaPlaylist.Segment(stringAttr3, j2, j3);
                j2 = 0;
                j3 = -1;
            } else if (next.startsWith(TAG_TARGET_DURATION)) {
                intAttr = 1000000 * parseIntAttr(next, REGEX_TARGET_DURATION);
            } else if (next.startsWith(TAG_MEDIA_SEQUENCE)) {
                longAttr = parseLongAttr(next, REGEX_MEDIA_SEQUENCE);
                OplusGLSurfaceView_15 = longAttr;
            } else if (next.startsWith(TAG_VERSION)) {
                intAttr2 = parseIntAttr(next, REGEX_VERSION);
            } else {
                if (next.startsWith(TAG_DEFINE)) {
                    String optionalStringAttr3 = parseOptionalStringAttr(next, REGEX_IMPORT, map);
                    if (optionalStringAttr3 != null) {
                        String str4 = hlsMasterPlaylist2.variableDefinitions.get(optionalStringAttr3);
                        if (str4 != null) {
                            map.put(optionalStringAttr3, str4);
                        }
                    } else {
                        map.put(parseStringAttr(next, REGEX_NAME, map), parseStringAttr(next, REGEX_VALUE, map));
                    }
                } else if (next.startsWith(TAG_MEDIA_DURATION)) {
                    long doubleAttr2 = (long) (parseDoubleAttr(next, REGEX_MEDIA_DURATION) * 1000000.0d);
                    optionalStringAttr = parseOptionalStringAttr(next, REGEX_MEDIA_TITLE, "", map);
                    j5 = doubleAttr2;
                } else if (next.startsWith(TAG_KEY)) {
                    String stringAttr4 = parseStringAttr(next, REGEX_METHOD, map);
                    String optionalStringAttr4 = parseOptionalStringAttr(next, REGEX_KEYFORMAT, "identity", map);
                    if (METHOD_NONE.equals(stringAttr4)) {
                        treeMap2.clear();
                        drmInitData3 = null;
                        stringAttr = null;
                        str3 = null;
                    } else {
                        String optionalStringAttr5 = parseOptionalStringAttr(next, REGEX_IV, map);
                        if ("identity".equals(optionalStringAttr4)) {
                            if (METHOD_AES_128.equals(stringAttr4)) {
                                stringAttr = parseStringAttr(next, REGEX_URI, map);
                                str3 = optionalStringAttr5;
                            }
                        } else {
                            if (str2 == null) {
                                str2 = (METHOD_SAMPLE_AES_CENC.equals(stringAttr4) || METHOD_SAMPLE_AES_CTR.equals(stringAttr4)) ? C1547C.CENC_TYPE_cenc : C1547C.CENC_TYPE_cbcs;
                            }
                            if (KEYFORMAT_PLAYREADY.equals(optionalStringAttr4)) {
                                widevineSchemeData = parsePlayReadySchemeData(next, map);
                            } else {
                                widevineSchemeData = parseWidevineSchemeData(next, optionalStringAttr4, map);
                            }
                            if (widevineSchemeData != null) {
                                treeMap2.put(optionalStringAttr4, widevineSchemeData);
                                str3 = optionalStringAttr5;
                                drmInitData3 = null;
                            }
                            stringAttr = null;
                        }
                        str3 = optionalStringAttr5;
                        stringAttr = null;
                    }
                } else if (next.startsWith(TAG_BYTERANGE)) {
                    String[] strArrSplit2 = parseStringAttr(next, REGEX_BYTERANGE, map).split("@");
                    j3 = Long.parseLong(strArrSplit2[OplusGLSurfaceView_13]);
                    if (strArrSplit2.length > i2) {
                        j2 = Long.parseLong(strArrSplit2[i2]);
                    }
                } else if (next.startsWith(TAG_DISCONTINUITY_SEQUENCE)) {
                    i6 = Integer.parseInt(next.substring(next.indexOf(58) + i2));
                    i4 = i2;
                } else if (next.equals(TAG_DISCONTINUITY)) {
                    i8++;
                } else {
                    if (next.startsWith(TAG_PROGRAM_DATE_TIME)) {
                        if (jMsToUs == 0) {
                            jMsToUs = C1547C.msToUs(Util.parseXsDateTime(next.substring(next.indexOf(58) + i2))) - j4;
                        }
                    } else if (next.equals(TAG_GAP)) {
                        z2 = i2;
                    } else if (next.equals(TAG_INDEPENDENT_SEGMENTS)) {
                        i3 = i2;
                    } else if (next.equals(TAG_ENDLIST)) {
                        i7 = i2;
                    } else if (!next.startsWith("#")) {
                        if (stringAttr == null) {
                            hexString = null;
                        } else {
                            hexString = str3 != null ? str3 : Long.toHexString(longAttr);
                        }
                        long j6 = longAttr + 1;
                        if (j3 == -1) {
                            j2 = 0;
                        }
                        if (drmInitData3 != null || treeMap2.isEmpty()) {
                            treeMap = treeMap2;
                            drmInitData = drmInitData3;
                        } else {
                            DrmInitData.SchemeData[] schemeDataArr = (DrmInitData.SchemeData[]) treeMap2.values().toArray(new DrmInitData.SchemeData[OplusGLSurfaceView_13]);
                            drmInitData = new DrmInitData(str2, schemeDataArr);
                            if (drmInitData2 == null) {
                                DrmInitData.SchemeData[] schemeDataArr2 = new DrmInitData.SchemeData[schemeDataArr.length];
                                int i9 = 0;
                                while (i9 < schemeDataArr.length) {
                                    schemeDataArr2[i9] = schemeDataArr[i9].copyWithData(null);
                                    i9++;
                                    treeMap2 = treeMap2;
                                }
                                treeMap = treeMap2;
                                drmInitData2 = new DrmInitData(str2, schemeDataArr2);
                            } else {
                                treeMap = treeMap2;
                            }
                        }
                        arrayList.add(new HlsMediaPlaylist.Segment(replaceVariableReferences(next, map), segment, optionalStringAttr, j5, i8, j4, drmInitData, stringAttr, hexString, j2, j3, z2));
                        j4 += j5;
                        if (j3 != -1) {
                            j2 += j3;
                        }
                        OplusGLSurfaceView_13 = 0;
                        i2 = 1;
                        z2 = 0;
                        j3 = -1;
                        j5 = 0;
                        hlsMasterPlaylist2 = hlsMasterPlaylist;
                        optionalStringAttr = "";
                        longAttr = j6;
                        drmInitData3 = drmInitData;
                    }
                    treeMap2 = treeMap;
                }
                treeMap = treeMap2;
                OplusGLSurfaceView_13 = 0;
                i2 = 1;
                hlsMasterPlaylist2 = hlsMasterPlaylist;
                z2 = z2;
                treeMap2 = treeMap;
            }
        }
        return new HlsMediaPlaylist(i5, str, arrayList2, doubleAttr, jMsToUs, i4, i6, OplusGLSurfaceView_15, intAttr2, intAttr, i3, i7, jMsToUs != 0, drmInitData2, arrayList);
    }

    private static int parseSelectionFlags(String str) {
        int OplusGLSurfaceView_13 = parseOptionalBooleanAttribute(str, REGEX_DEFAULT, false) ? 1 : 0;
        if (parseOptionalBooleanAttribute(str, REGEX_FORCED, false)) {
            OplusGLSurfaceView_13 |= 2;
        }
        return parseOptionalBooleanAttribute(str, REGEX_AUTOSELECT, false) ? OplusGLSurfaceView_13 | 4 : OplusGLSurfaceView_13;
    }

    private static int parseChannelsAttribute(String str, Map<String, String> map) {
        String optionalStringAttr = parseOptionalStringAttr(str, REGEX_CHANNELS, map);
        if (optionalStringAttr != null) {
            return Integer.parseInt(Util.splitAtFirst(optionalStringAttr, "/")[0]);
        }
        return -1;
    }

    private static DrmInitData.SchemeData parsePlayReadySchemeData(String str, Map<String, String> map) throws ParserException {
        if (!"1".equals(parseOptionalStringAttr(str, REGEX_KEYFORMATVERSIONS, "1", map))) {
            return null;
        }
        String stringAttr = parseStringAttr(str, REGEX_URI, map);
        return new DrmInitData.SchemeData(C1547C.PLAYREADY_UUID, MimeTypes.VIDEO_MP4, PsshAtomUtil.buildPsshAtom(C1547C.PLAYREADY_UUID, Base64.decode(stringAttr.substring(stringAttr.indexOf(44)), 0)));
    }

    private static DrmInitData.SchemeData parseWidevineSchemeData(String str, String str2, Map<String, String> map) throws ParserException {
        if (KEYFORMAT_WIDEVINE_PSSH_BINARY.equals(str2)) {
            String stringAttr = parseStringAttr(str, REGEX_URI, map);
            return new DrmInitData.SchemeData(C1547C.WIDEVINE_UUID, MimeTypes.VIDEO_MP4, Base64.decode(stringAttr.substring(stringAttr.indexOf(44)), 0));
        }
        if (!KEYFORMAT_WIDEVINE_PSSH_JSON.equals(str2)) {
            return null;
        }
        try {
            return new DrmInitData.SchemeData(C1547C.WIDEVINE_UUID, "hls", str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException COUIBaseListPopupWindow_8) {
            throw new ParserException(COUIBaseListPopupWindow_8);
        }
    }

    private static int parseIntAttr(String str, Pattern pattern) throws ParserException {
        return Integer.parseInt(parseStringAttr(str, pattern, Collections.emptyMap()));
    }

    private static long parseLongAttr(String str, Pattern pattern) throws ParserException {
        return Long.parseLong(parseStringAttr(str, pattern, Collections.emptyMap()));
    }

    private static double parseDoubleAttr(String str, Pattern pattern) throws ParserException {
        return Double.parseDouble(parseStringAttr(str, pattern, Collections.emptyMap()));
    }

    private static String parseStringAttr(String str, Pattern pattern, Map<String, String> map) throws ParserException {
        String optionalStringAttr = parseOptionalStringAttr(str, pattern, map);
        if (optionalStringAttr != null) {
            return optionalStringAttr;
        }
        throw new ParserException("Couldn't match " + pattern.pattern() + " in " + str);
    }

    private static String parseOptionalStringAttr(String str, Pattern pattern, Map<String, String> map) {
        return parseOptionalStringAttr(str, pattern, null, map);
    }

    private static String parseOptionalStringAttr(String str, Pattern pattern, String str2, Map<String, String> map) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            str2 = matcher.group(1);
        }
        return (map.isEmpty() || str2 == null) ? str2 : replaceVariableReferences(str2, map);
    }

    private static String replaceVariableReferences(String str, Map<String, String> map) {
        Matcher matcher = REGEX_VARIABLE_REFERENCE.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String strGroup = matcher.group(1);
            if (map.containsKey(strGroup)) {
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(map.get(strGroup)));
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    private static boolean parseOptionalBooleanAttribute(String str, Pattern pattern, boolean z) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? matcher.group(1).equals(BOOLEAN_TRUE) : z;
    }

    private static Pattern compileBooleanAttrPattern(String str) {
        return Pattern.compile(str + "=(" + BOOLEAN_FALSE + DcsMsgData.DIVIDER + BOOLEAN_TRUE + ")");
    }

    private static boolean isMediaTagMuxed(List<HlsMasterPlaylist.HlsUrl> list, String str) {
        if (str == null) {
            return true;
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < list.size(); OplusGLSurfaceView_13++) {
            if (str.equals(list.get(OplusGLSurfaceView_13).url)) {
                return true;
            }
        }
        return false;
    }

    private static class LineIterator {
        private final Queue<String> extraLines;
        private String next;
        private final BufferedReader reader;

        public LineIterator(Queue<String> queue, BufferedReader bufferedReader) {
            this.extraLines = queue;
            this.reader = bufferedReader;
        }

        public boolean hasNext() throws IOException {
            if (this.next != null) {
                return true;
            }
            if (!this.extraLines.isEmpty()) {
                this.next = this.extraLines.poll();
                return true;
            }
            do {
                String line = this.reader.readLine();
                this.next = line;
                if (line == null) {
                    return false;
                }
                this.next = this.next.trim();
            } while (this.next.isEmpty());
            return true;
        }

        public String next() throws IOException {
            if (!hasNext()) {
                return null;
            }
            String str = this.next;
            this.next = null;
            return str;
        }
    }
}
