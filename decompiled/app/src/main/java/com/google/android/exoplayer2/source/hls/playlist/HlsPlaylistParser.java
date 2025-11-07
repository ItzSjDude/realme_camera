package com.google.android.exoplayer2.source.hls.playlist;

/* loaded from: classes.dex */
public final class HlsPlaylistParser implements com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist> {
    private static final java.lang.String ATTR_CLOSED_CAPTIONS_NONE = "CLOSED-CAPTIONS=NONE";
    private static final java.lang.String BOOLEAN_FALSE = "NO";
    private static final java.lang.String BOOLEAN_TRUE = "YES";
    private static final java.lang.String KEYFORMAT_IDENTITY = "identity";
    private static final java.lang.String KEYFORMAT_PLAYREADY = "com.microsoft.playready";
    private static final java.lang.String KEYFORMAT_WIDEVINE_PSSH_BINARY = "urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed";
    private static final java.lang.String KEYFORMAT_WIDEVINE_PSSH_JSON = "com.widevine";
    private static final java.lang.String METHOD_AES_128 = "AES-128";
    private static final java.lang.String METHOD_NONE = "NONE";
    private static final java.lang.String METHOD_SAMPLE_AES = "SAMPLE-AES";
    private static final java.lang.String METHOD_SAMPLE_AES_CENC = "SAMPLE-AES-CENC";
    private static final java.lang.String METHOD_SAMPLE_AES_CTR = "SAMPLE-AES-CTR";
    private static final java.lang.String PLAYLIST_HEADER = "#EXTM3U";
    private static final java.lang.String TAG_BYTERANGE = "#EXT-X_renamed-BYTERANGE";
    private static final java.lang.String TAG_DEFINE = "#EXT-X_renamed-DEFINE";
    private static final java.lang.String TAG_DISCONTINUITY = "#EXT-X_renamed-DISCONTINUITY";
    private static final java.lang.String TAG_DISCONTINUITY_SEQUENCE = "#EXT-X_renamed-DISCONTINUITY-SEQUENCE";
    private static final java.lang.String TAG_ENDLIST = "#EXT-X_renamed-ENDLIST";
    private static final java.lang.String TAG_GAP = "#EXT-X_renamed-GAP";
    private static final java.lang.String TAG_INDEPENDENT_SEGMENTS = "#EXT-X_renamed-INDEPENDENT-SEGMENTS";
    private static final java.lang.String TAG_INIT_SEGMENT = "#EXT-X_renamed-MAP";
    private static final java.lang.String TAG_KEY = "#EXT-X_renamed-KEY";
    private static final java.lang.String TAG_MEDIA = "#EXT-X_renamed-MEDIA";
    private static final java.lang.String TAG_MEDIA_DURATION = "#EXTINF";
    private static final java.lang.String TAG_MEDIA_SEQUENCE = "#EXT-X_renamed-MEDIA-SEQUENCE";
    private static final java.lang.String TAG_PLAYLIST_TYPE = "#EXT-X_renamed-PLAYLIST-TYPE";
    private static final java.lang.String TAG_PREFIX = "#EXT";
    private static final java.lang.String TAG_PROGRAM_DATE_TIME = "#EXT-X_renamed-PROGRAM-DATE-TIME";
    private static final java.lang.String TAG_START = "#EXT-X_renamed-START";
    private static final java.lang.String TAG_STREAM_INF = "#EXT-X_renamed-STREAM-INF";
    private static final java.lang.String TAG_TARGET_DURATION = "#EXT-X_renamed-TARGETDURATION";
    private static final java.lang.String TAG_VERSION = "#EXT-X_renamed-VERSION";
    private static final java.lang.String TYPE_AUDIO = "AUDIO";
    private static final java.lang.String TYPE_CLOSED_CAPTIONS = "CLOSED-CAPTIONS";
    private static final java.lang.String TYPE_SUBTITLES = "SUBTITLES";
    private static final java.lang.String TYPE_VIDEO = "VIDEO";
    private final com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist masterPlaylist;
    private static final java.util.regex.Pattern REGEX_AVERAGE_BANDWIDTH = java.util.regex.Pattern.compile("AVERAGE-BANDWIDTH=(\\d_renamed+)\\b_renamed");
    private static final java.util.regex.Pattern REGEX_AUDIO = java.util.regex.Pattern.compile("AUDIO=\"(.+?)\"");
    private static final java.util.regex.Pattern REGEX_BANDWIDTH = java.util.regex.Pattern.compile("[^-]BANDWIDTH=(\\d_renamed+)\\b_renamed");
    private static final java.util.regex.Pattern REGEX_CHANNELS = java.util.regex.Pattern.compile("CHANNELS=\"(.+?)\"");
    private static final java.util.regex.Pattern REGEX_CODECS = java.util.regex.Pattern.compile("CODECS=\"(.+?)\"");
    private static final java.util.regex.Pattern REGEX_RESOLUTION = java.util.regex.Pattern.compile("RESOLUTION=(\\d_renamed+x_renamed\\d_renamed+)");
    private static final java.util.regex.Pattern REGEX_FRAME_RATE = java.util.regex.Pattern.compile("FRAME-RATE=([\\d_renamed\\.]+)\\b_renamed");
    private static final java.util.regex.Pattern REGEX_TARGET_DURATION = java.util.regex.Pattern.compile("#EXT-X_renamed-TARGETDURATION:(\\d_renamed+)\\b_renamed");
    private static final java.util.regex.Pattern REGEX_VERSION = java.util.regex.Pattern.compile("#EXT-X_renamed-VERSION:(\\d_renamed+)\\b_renamed");
    private static final java.util.regex.Pattern REGEX_PLAYLIST_TYPE = java.util.regex.Pattern.compile("#EXT-X_renamed-PLAYLIST-TYPE:(.+)\\b_renamed");
    private static final java.util.regex.Pattern REGEX_MEDIA_SEQUENCE = java.util.regex.Pattern.compile("#EXT-X_renamed-MEDIA-SEQUENCE:(\\d_renamed+)\\b_renamed");
    private static final java.util.regex.Pattern REGEX_MEDIA_DURATION = java.util.regex.Pattern.compile("#EXTINF:([\\d_renamed\\.]+)\\b_renamed");
    private static final java.util.regex.Pattern REGEX_MEDIA_TITLE = java.util.regex.Pattern.compile("#EXTINF:[\\d_renamed\\.]+\\b_renamed,(.+)");
    private static final java.util.regex.Pattern REGEX_TIME_OFFSET = java.util.regex.Pattern.compile("TIME-OFFSET=(-?[\\d_renamed\\.]+)\\b_renamed");
    private static final java.util.regex.Pattern REGEX_BYTERANGE = java.util.regex.Pattern.compile("#EXT-X_renamed-BYTERANGE:(\\d_renamed+(?:@\\d_renamed+)?)\\b_renamed");
    private static final java.util.regex.Pattern REGEX_ATTR_BYTERANGE = java.util.regex.Pattern.compile("BYTERANGE=\"(\\d_renamed+(?:@\\d_renamed+)?)\\b_renamed\"");
    private static final java.util.regex.Pattern REGEX_METHOD = java.util.regex.Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s_renamed*(?:,|$)");
    private static final java.util.regex.Pattern REGEX_KEYFORMAT = java.util.regex.Pattern.compile("KEYFORMAT=\"(.+?)\"");
    private static final java.util.regex.Pattern REGEX_KEYFORMATVERSIONS = java.util.regex.Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");
    private static final java.util.regex.Pattern REGEX_URI = java.util.regex.Pattern.compile("URI=\"(.+?)\"");
    private static final java.util.regex.Pattern REGEX_IV = java.util.regex.Pattern.compile("IV=([^,.*]+)");
    private static final java.util.regex.Pattern REGEX_TYPE = java.util.regex.Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    private static final java.util.regex.Pattern REGEX_LANGUAGE = java.util.regex.Pattern.compile("LANGUAGE=\"(.+?)\"");
    private static final java.util.regex.Pattern REGEX_NAME = java.util.regex.Pattern.compile("NAME=\"(.+?)\"");
    private static final java.util.regex.Pattern REGEX_GROUP_ID = java.util.regex.Pattern.compile("GROUP-ID_renamed=\"(.+?)\"");
    private static final java.util.regex.Pattern REGEX_INSTREAM_ID = java.util.regex.Pattern.compile("INSTREAM-ID_renamed=\"((?:CC|SERVICE)\\d_renamed+)\"");
    private static final java.util.regex.Pattern REGEX_AUTOSELECT = compileBooleanAttrPattern("AUTOSELECT");
    private static final java.util.regex.Pattern REGEX_DEFAULT = compileBooleanAttrPattern("DEFAULT");
    private static final java.util.regex.Pattern REGEX_FORCED = compileBooleanAttrPattern("FORCED");
    private static final java.util.regex.Pattern REGEX_VALUE = java.util.regex.Pattern.compile("VALUE=\"(.+?)\"");
    private static final java.util.regex.Pattern REGEX_IMPORT = java.util.regex.Pattern.compile("IMPORT=\"(.+?)\"");
    private static final java.util.regex.Pattern REGEX_VARIABLE_REFERENCE = java.util.regex.Pattern.compile("\\{\\$([a_renamed-zA-Z0-9\\-_]+)\\}");

    public HlsPlaylistParser() {
        this(com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.EMPTY);
    }

    public HlsPlaylistParser(com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist hlsMasterPlaylist) {
        this.masterPlaylist = hlsMasterPlaylist;
    }

    /* JADX WARN: Can't_renamed rename method to resolve collision */
    @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
    public com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist parse(android.net.Uri uri, java.io.InputStream inputStream) throws java.io.IOException {
        java.lang.String strTrim;
        java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream));
        java.util.ArrayDeque arrayDeque = new java.util.ArrayDeque();
        try {
            if (!checkPlaylistHeader(bufferedReader)) {
                throw new com.google.android.exoplayer2.source.UnrecognizedInputFormatException("Input does not start with the #EXTM3U header.", uri);
            }
            while (true) {
                java.lang.String line = bufferedReader.readLine();
                if (line != null) {
                    strTrim = line.trim();
                    if (!strTrim.isEmpty()) {
                        if (strTrim.startsWith(TAG_STREAM_INF)) {
                            arrayDeque.add(strTrim);
                            return parseMasterPlaylist(new com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser.LineIterator(arrayDeque, bufferedReader), uri.toString());
                        }
                        if (strTrim.startsWith(TAG_TARGET_DURATION) || strTrim.startsWith(TAG_MEDIA_SEQUENCE) || strTrim.startsWith(TAG_MEDIA_DURATION) || strTrim.startsWith(TAG_KEY) || strTrim.startsWith(TAG_BYTERANGE) || strTrim.equals(TAG_DISCONTINUITY) || strTrim.equals(TAG_DISCONTINUITY_SEQUENCE) || strTrim.equals(TAG_ENDLIST)) {
                            break;
                        }
                        arrayDeque.add(strTrim);
                    }
                } else {
                    com.google.android.exoplayer2.util.Util.closeQuietly(bufferedReader);
                    throw new com.google.android.exoplayer2.ParserException("Failed to parse the playlist, could not identify any tags.");
                }
            }
            arrayDeque.add(strTrim);
            return parseMediaPlaylist(this.masterPlaylist, new com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser.LineIterator(arrayDeque, bufferedReader), uri.toString());
        } finally {
            com.google.android.exoplayer2.util.Util.closeQuietly(bufferedReader);
        }
    }

    private static boolean checkPlaylistHeader(java.io.BufferedReader bufferedReader) throws java.io.IOException {
        int i_renamed = bufferedReader.read();
        if (i_renamed == 239) {
            if (bufferedReader.read() != 187 || bufferedReader.read() != 191) {
                return false;
            }
            i_renamed = bufferedReader.read();
        }
        int iSkipIgnorableWhitespace = skipIgnorableWhitespace(bufferedReader, true, i_renamed);
        for (int i2 = 0; i2 < 7; i2++) {
            if (iSkipIgnorableWhitespace != PLAYLIST_HEADER.charAt(i2)) {
                return false;
            }
            iSkipIgnorableWhitespace = bufferedReader.read();
        }
        return com.google.android.exoplayer2.util.Util.isLinebreak(skipIgnorableWhitespace(bufferedReader, false, iSkipIgnorableWhitespace));
    }

    private static int skipIgnorableWhitespace(java.io.BufferedReader bufferedReader, boolean z_renamed, int i_renamed) throws java.io.IOException {
        while (i_renamed != -1 && java.lang.Character.isWhitespace(i_renamed) && (z_renamed || !com.google.android.exoplayer2.util.Util.isLinebreak(i_renamed))) {
            i_renamed = bufferedReader.read();
        }
        return i_renamed;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B_renamed:61:0x0198  */
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
    private static com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist parseMediaPlaylist(com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist hlsMasterPlaylist, com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser.LineIterator lineIterator, java.lang.String str) throws java.io.IOException, java.lang.NumberFormatException {
        java.util.TreeMap treeMap;
        java.lang.String hexString;
        com.google.android.exoplayer2.drm.DrmInitData drmInitData;
        com.google.android.exoplayer2.drm.DrmInitData.SchemeData widevineSchemeData;
        com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist hlsMasterPlaylist2 = hlsMasterPlaylist;
        boolean z_renamed = hlsMasterPlaylist2.hasIndependentSegments;
        java.util.HashMap map = new java.util.HashMap();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.util.TreeMap treeMap2 = new java.util.TreeMap();
        int i_renamed = 0;
        int i2 = 1;
        int i3 = z_renamed ? 1 : 0;
        long doubleAttr = -9223372036854775807L;
        long intAttr = -9223372036854775807L;
        java.lang.String optionalStringAttr = "";
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        boolean z2 = 0;
        int i8 = 0;
        int intAttr2 = 1;
        java.lang.String str2 = null;
        long jMsToUs = 0;
        long j_renamed = 0;
        com.google.android.exoplayer2.drm.DrmInitData drmInitData2 = null;
        long j2 = 0;
        long longAttr = 0;
        com.google.android.exoplayer2.drm.DrmInitData drmInitData3 = null;
        long j3 = -1;
        long j4 = 0;
        java.lang.String stringAttr = null;
        java.lang.String str3 = null;
        com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment segment = null;
        long j5 = 0;
        while (lineIterator.hasNext()) {
            java.lang.String next = lineIterator.next();
            if (next.startsWith(TAG_PREFIX)) {
                arrayList2.add(next);
            }
            if (next.startsWith(TAG_PLAYLIST_TYPE)) {
                java.lang.String stringAttr2 = parseStringAttr(next, REGEX_PLAYLIST_TYPE, map);
                if ("VOD".equals(stringAttr2)) {
                    i5 = i2;
                } else if ("EVENT".equals(stringAttr2)) {
                    i5 = 2;
                }
            } else if (next.startsWith(TAG_START)) {
                doubleAttr = (long) (parseDoubleAttr(next, REGEX_TIME_OFFSET) * 1000000.0d);
            } else if (next.startsWith(TAG_INIT_SEGMENT)) {
                java.lang.String stringAttr3 = parseStringAttr(next, REGEX_URI, map);
                java.lang.String optionalStringAttr2 = parseOptionalStringAttr(next, REGEX_ATTR_BYTERANGE, map);
                if (optionalStringAttr2 != null) {
                    java.lang.String[] strArrSplit = optionalStringAttr2.split("@");
                    j3 = java.lang.Long.parseLong(strArrSplit[i_renamed]);
                    if (strArrSplit.length > i2) {
                        j2 = java.lang.Long.parseLong(strArrSplit[i2]);
                    }
                }
                segment = new com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment(stringAttr3, j2, j3);
                j2 = 0;
                j3 = -1;
            } else if (next.startsWith(TAG_TARGET_DURATION)) {
                intAttr = 1000000 * parseIntAttr(next, REGEX_TARGET_DURATION);
            } else if (next.startsWith(TAG_MEDIA_SEQUENCE)) {
                longAttr = parseLongAttr(next, REGEX_MEDIA_SEQUENCE);
                j_renamed = longAttr;
            } else if (next.startsWith(TAG_VERSION)) {
                intAttr2 = parseIntAttr(next, REGEX_VERSION);
            } else {
                if (next.startsWith(TAG_DEFINE)) {
                    java.lang.String optionalStringAttr3 = parseOptionalStringAttr(next, REGEX_IMPORT, map);
                    if (optionalStringAttr3 != null) {
                        java.lang.String str4 = hlsMasterPlaylist2.variableDefinitions.get(optionalStringAttr3);
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
                    java.lang.String stringAttr4 = parseStringAttr(next, REGEX_METHOD, map);
                    java.lang.String optionalStringAttr4 = parseOptionalStringAttr(next, REGEX_KEYFORMAT, "identity", map);
                    if (METHOD_NONE.equals(stringAttr4)) {
                        treeMap2.clear();
                        drmInitData3 = null;
                        stringAttr = null;
                        str3 = null;
                    } else {
                        java.lang.String optionalStringAttr5 = parseOptionalStringAttr(next, REGEX_IV, map);
                        if ("identity".equals(optionalStringAttr4)) {
                            if (METHOD_AES_128.equals(stringAttr4)) {
                                stringAttr = parseStringAttr(next, REGEX_URI, map);
                                str3 = optionalStringAttr5;
                            }
                        } else {
                            if (str2 == null) {
                                str2 = (METHOD_SAMPLE_AES_CENC.equals(stringAttr4) || METHOD_SAMPLE_AES_CTR.equals(stringAttr4)) ? com.google.android.exoplayer2.C_renamed.CENC_TYPE_cenc : com.google.android.exoplayer2.C_renamed.CENC_TYPE_cbcs;
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
                    java.lang.String[] strArrSplit2 = parseStringAttr(next, REGEX_BYTERANGE, map).split("@");
                    j3 = java.lang.Long.parseLong(strArrSplit2[i_renamed]);
                    if (strArrSplit2.length > i2) {
                        j2 = java.lang.Long.parseLong(strArrSplit2[i2]);
                    }
                } else if (next.startsWith(TAG_DISCONTINUITY_SEQUENCE)) {
                    i6 = java.lang.Integer.parseInt(next.substring(next.indexOf(58) + i2));
                    i4 = i2;
                } else if (next.equals(TAG_DISCONTINUITY)) {
                    i8++;
                } else {
                    if (next.startsWith(TAG_PROGRAM_DATE_TIME)) {
                        if (jMsToUs == 0) {
                            jMsToUs = com.google.android.exoplayer2.C_renamed.msToUs(com.google.android.exoplayer2.util.Util.parseXsDateTime(next.substring(next.indexOf(58) + i2))) - j4;
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
                            hexString = str3 != null ? str3 : java.lang.Long.toHexString(longAttr);
                        }
                        long j6 = longAttr + 1;
                        if (j3 == -1) {
                            j2 = 0;
                        }
                        if (drmInitData3 != null || treeMap2.isEmpty()) {
                            treeMap = treeMap2;
                            drmInitData = drmInitData3;
                        } else {
                            com.google.android.exoplayer2.drm.DrmInitData.SchemeData[] schemeDataArr = (com.google.android.exoplayer2.drm.DrmInitData.SchemeData[]) treeMap2.values().toArray(new com.google.android.exoplayer2.drm.DrmInitData.SchemeData[i_renamed]);
                            drmInitData = new com.google.android.exoplayer2.drm.DrmInitData(str2, schemeDataArr);
                            if (drmInitData2 == null) {
                                com.google.android.exoplayer2.drm.DrmInitData.SchemeData[] schemeDataArr2 = new com.google.android.exoplayer2.drm.DrmInitData.SchemeData[schemeDataArr.length];
                                int i9 = 0;
                                while (i9 < schemeDataArr.length) {
                                    schemeDataArr2[i9] = schemeDataArr[i9].copyWithData(null);
                                    i9++;
                                    treeMap2 = treeMap2;
                                }
                                treeMap = treeMap2;
                                drmInitData2 = new com.google.android.exoplayer2.drm.DrmInitData(str2, schemeDataArr2);
                            } else {
                                treeMap = treeMap2;
                            }
                        }
                        arrayList.add(new com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment(replaceVariableReferences(next, map), segment, optionalStringAttr, j5, i8, j4, drmInitData, stringAttr, hexString, j2, j3, z2));
                        j4 += j5;
                        if (j3 != -1) {
                            j2 += j3;
                        }
                        i_renamed = 0;
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
                i_renamed = 0;
                i2 = 1;
                hlsMasterPlaylist2 = hlsMasterPlaylist;
                z2 = z2;
                treeMap2 = treeMap;
            }
        }
        return new com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist(i5, str, arrayList2, doubleAttr, jMsToUs, i4, i6, j_renamed, intAttr2, intAttr, i3, i7, jMsToUs != 0, drmInitData2, arrayList);
    }

    private static int parseSelectionFlags(java.lang.String str) {
        int i_renamed = parseOptionalBooleanAttribute(str, REGEX_DEFAULT, false) ? 1 : 0;
        if (parseOptionalBooleanAttribute(str, REGEX_FORCED, false)) {
            i_renamed |= 2;
        }
        return parseOptionalBooleanAttribute(str, REGEX_AUTOSELECT, false) ? i_renamed | 4 : i_renamed;
    }

    private static int parseChannelsAttribute(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        java.lang.String optionalStringAttr = parseOptionalStringAttr(str, REGEX_CHANNELS, map);
        if (optionalStringAttr != null) {
            return java.lang.Integer.parseInt(com.google.android.exoplayer2.util.Util.splitAtFirst(optionalStringAttr, "/")[0]);
        }
        return -1;
    }

    private static com.google.android.exoplayer2.drm.DrmInitData.SchemeData parsePlayReadySchemeData(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) throws com.google.android.exoplayer2.ParserException {
        if (!"1".equals(parseOptionalStringAttr(str, REGEX_KEYFORMATVERSIONS, "1", map))) {
            return null;
        }
        java.lang.String stringAttr = parseStringAttr(str, REGEX_URI, map);
        return new com.google.android.exoplayer2.drm.DrmInitData.SchemeData(com.google.android.exoplayer2.C_renamed.PLAYREADY_UUID, com.google.android.exoplayer2.util.MimeTypes.VIDEO_MP4, com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil.buildPsshAtom(com.google.android.exoplayer2.C_renamed.PLAYREADY_UUID, android.util.Base64.decode(stringAttr.substring(stringAttr.indexOf(44)), 0)));
    }

    private static com.google.android.exoplayer2.drm.DrmInitData.SchemeData parseWidevineSchemeData(java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.String> map) throws com.google.android.exoplayer2.ParserException {
        if (KEYFORMAT_WIDEVINE_PSSH_BINARY.equals(str2)) {
            java.lang.String stringAttr = parseStringAttr(str, REGEX_URI, map);
            return new com.google.android.exoplayer2.drm.DrmInitData.SchemeData(com.google.android.exoplayer2.C_renamed.WIDEVINE_UUID, com.google.android.exoplayer2.util.MimeTypes.VIDEO_MP4, android.util.Base64.decode(stringAttr.substring(stringAttr.indexOf(44)), 0));
        }
        if (!KEYFORMAT_WIDEVINE_PSSH_JSON.equals(str2)) {
            return null;
        }
        try {
            return new com.google.android.exoplayer2.drm.DrmInitData.SchemeData(com.google.android.exoplayer2.C_renamed.WIDEVINE_UUID, "hls", str.getBytes("UTF-8"));
        } catch (java.io.UnsupportedEncodingException e_renamed) {
            throw new com.google.android.exoplayer2.ParserException(e_renamed);
        }
    }

    private static int parseIntAttr(java.lang.String str, java.util.regex.Pattern pattern) throws com.google.android.exoplayer2.ParserException {
        return java.lang.Integer.parseInt(parseStringAttr(str, pattern, java.util.Collections.emptyMap()));
    }

    private static long parseLongAttr(java.lang.String str, java.util.regex.Pattern pattern) throws com.google.android.exoplayer2.ParserException {
        return java.lang.Long.parseLong(parseStringAttr(str, pattern, java.util.Collections.emptyMap()));
    }

    private static double parseDoubleAttr(java.lang.String str, java.util.regex.Pattern pattern) throws com.google.android.exoplayer2.ParserException {
        return java.lang.Double.parseDouble(parseStringAttr(str, pattern, java.util.Collections.emptyMap()));
    }

    private static java.lang.String parseStringAttr(java.lang.String str, java.util.regex.Pattern pattern, java.util.Map<java.lang.String, java.lang.String> map) throws com.google.android.exoplayer2.ParserException {
        java.lang.String optionalStringAttr = parseOptionalStringAttr(str, pattern, map);
        if (optionalStringAttr != null) {
            return optionalStringAttr;
        }
        throw new com.google.android.exoplayer2.ParserException("Couldn't_renamed match " + pattern.pattern() + " in_renamed " + str);
    }

    private static java.lang.String parseOptionalStringAttr(java.lang.String str, java.util.regex.Pattern pattern, java.util.Map<java.lang.String, java.lang.String> map) {
        return parseOptionalStringAttr(str, pattern, null, map);
    }

    private static java.lang.String parseOptionalStringAttr(java.lang.String str, java.util.regex.Pattern pattern, java.lang.String str2, java.util.Map<java.lang.String, java.lang.String> map) {
        java.util.regex.Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            str2 = matcher.group(1);
        }
        return (map.isEmpty() || str2 == null) ? str2 : replaceVariableReferences(str2, map);
    }

    private static java.lang.String replaceVariableReferences(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        java.util.regex.Matcher matcher = REGEX_VARIABLE_REFERENCE.matcher(str);
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        while (matcher.find()) {
            java.lang.String strGroup = matcher.group(1);
            if (map.containsKey(strGroup)) {
                matcher.appendReplacement(stringBuffer, java.util.regex.Matcher.quoteReplacement(map.get(strGroup)));
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    private static boolean parseOptionalBooleanAttribute(java.lang.String str, java.util.regex.Pattern pattern, boolean z_renamed) {
        java.util.regex.Matcher matcher = pattern.matcher(str);
        return matcher.find() ? matcher.group(1).equals(BOOLEAN_TRUE) : z_renamed;
    }

    private static java.util.regex.Pattern compileBooleanAttrPattern(java.lang.String str) {
        return java.util.regex.Pattern.compile(str + "=(" + BOOLEAN_FALSE + com.oplus.camera.statistics.model.DcsMsgData.DIVIDER + BOOLEAN_TRUE + ")");
    }

    private static boolean isMediaTagMuxed(java.util.List<com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist.HlsUrl> list, java.lang.String str) {
        if (str == null) {
            return true;
        }
        for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
            if (str.equals(list.get(i_renamed).url)) {
                return true;
            }
        }
        return false;
    }

    private static class LineIterator {
        private final java.util.Queue<java.lang.String> extraLines;
        private java.lang.String next;
        private final java.io.BufferedReader reader;

        public LineIterator(java.util.Queue<java.lang.String> queue, java.io.BufferedReader bufferedReader) {
            this.extraLines = queue;
            this.reader = bufferedReader;
        }

        public boolean hasNext() throws java.io.IOException {
            if (this.next != null) {
                return true;
            }
            if (!this.extraLines.isEmpty()) {
                this.next = this.extraLines.poll();
                return true;
            }
            do {
                java.lang.String line = this.reader.readLine();
                this.next = line;
                if (line == null) {
                    return false;
                }
                this.next = this.next.trim();
            } while (this.next.isEmpty());
            return true;
        }

        public java.lang.String next() throws java.io.IOException {
            if (!hasNext()) {
                return null;
            }
            java.lang.String str = this.next;
            this.next = null;
            return str;
        }
    }
}
