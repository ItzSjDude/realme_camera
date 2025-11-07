package com.google.android.exoplayer2.source.smoothstreaming.manifest;

/* loaded from: classes.dex */
public class SsManifestParser implements com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest> {
    private final org.xmlpull.v1.XmlPullParserFactory xmlParserFactory;

    public SsManifestParser() {
        try {
            this.xmlParserFactory = org.xmlpull.v1.XmlPullParserFactory.newInstance();
        } catch (org.xmlpull.v1.XmlPullParserException e_renamed) {
            throw new java.lang.RuntimeException("Couldn't_renamed create XmlPullParserFactory instance", e_renamed);
        }
    }

    /* JADX WARN: Can't_renamed rename method to resolve collision */
    @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
    public com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest parse(android.net.Uri uri, java.io.InputStream inputStream) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        try {
            org.xmlpull.v1.XmlPullParser xmlPullParserNewPullParser = this.xmlParserFactory.newPullParser();
            xmlPullParserNewPullParser.setInput(inputStream, null);
            return (com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest) new com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.SmoothStreamingMediaParser(null, uri.toString()).parse(xmlPullParserNewPullParser);
        } catch (org.xmlpull.v1.XmlPullParserException e_renamed) {
            throw new com.google.android.exoplayer2.ParserException(e_renamed);
        }
    }

    public static class MissingFieldException extends com.google.android.exoplayer2.ParserException {
        public MissingFieldException(java.lang.String str) {
            super("Missing required field: " + str);
        }
    }

    private static abstract class ElementParser {
        private final java.lang.String baseUri;
        private final java.util.List<android.util.Pair<java.lang.String, java.lang.Object>> normalizedAttributes = new java.util.LinkedList();
        private final com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser parent;
        private final java.lang.String tag;

        protected void addChild(java.lang.Object obj) {
        }

        protected abstract java.lang.Object build();

        protected boolean handleChildInline(java.lang.String str) {
            return false;
        }

        protected void parseEndTag(org.xmlpull.v1.XmlPullParser xmlPullParser) {
        }

        protected void parseStartTag(org.xmlpull.v1.XmlPullParser xmlPullParser) throws com.google.android.exoplayer2.ParserException {
        }

        protected void parseText(org.xmlpull.v1.XmlPullParser xmlPullParser) {
        }

        public ElementParser(com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser elementParser, java.lang.String str, java.lang.String str2) {
            this.parent = elementParser;
            this.baseUri = str;
            this.tag = str2;
        }

        public final java.lang.Object parse(org.xmlpull.v1.XmlPullParser xmlPullParser) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
            boolean z_renamed = false;
            int i_renamed = 0;
            while (true) {
                int eventType = xmlPullParser.getEventType();
                if (eventType == 1) {
                    return null;
                }
                if (eventType == 2) {
                    java.lang.String name = xmlPullParser.getName();
                    if (this.tag.equals(name)) {
                        parseStartTag(xmlPullParser);
                        z_renamed = true;
                    } else if (z_renamed) {
                        if (i_renamed > 0) {
                            i_renamed++;
                        } else if (handleChildInline(name)) {
                            parseStartTag(xmlPullParser);
                        } else {
                            com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser elementParserNewChildParser = newChildParser(this, name, this.baseUri);
                            if (elementParserNewChildParser == null) {
                                i_renamed = 1;
                            } else {
                                addChild(elementParserNewChildParser.parse(xmlPullParser));
                            }
                        }
                    }
                } else if (eventType != 3) {
                    if (eventType == 4 && z_renamed && i_renamed == 0) {
                        parseText(xmlPullParser);
                    }
                } else if (!z_renamed) {
                    continue;
                } else if (i_renamed > 0) {
                    i_renamed--;
                } else {
                    java.lang.String name2 = xmlPullParser.getName();
                    parseEndTag(xmlPullParser);
                    if (!handleChildInline(name2)) {
                        return build();
                    }
                }
                xmlPullParser.next();
            }
        }

        private com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser newChildParser(com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser elementParser, java.lang.String str, java.lang.String str2) {
            if (com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.QualityLevelParser.TAG.equals(str)) {
                return new com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.QualityLevelParser(elementParser, str2);
            }
            if (com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ProtectionParser.TAG.equals(str)) {
                return new com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ProtectionParser(elementParser, str2);
            }
            if (com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.StreamIndexParser.TAG.equals(str)) {
                return new com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.StreamIndexParser(elementParser, str2);
            }
            return null;
        }

        protected final void putNormalizedAttribute(java.lang.String str, java.lang.Object obj) {
            this.normalizedAttributes.add(android.util.Pair.create(str, obj));
        }

        protected final java.lang.Object getNormalizedAttribute(java.lang.String str) {
            for (int i_renamed = 0; i_renamed < this.normalizedAttributes.size(); i_renamed++) {
                android.util.Pair<java.lang.String, java.lang.Object> pair = this.normalizedAttributes.get(i_renamed);
                if (((java.lang.String) pair.first).equals(str)) {
                    return pair.second;
                }
            }
            com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser elementParser = this.parent;
            if (elementParser == null) {
                return null;
            }
            return elementParser.getNormalizedAttribute(str);
        }

        protected final java.lang.String parseRequiredString(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str) throws com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.MissingFieldException {
            java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue != null) {
                return attributeValue;
            }
            throw new com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.MissingFieldException(str);
        }

        protected final int parseInt(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, int i_renamed) throws com.google.android.exoplayer2.ParserException {
            java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue == null) {
                return i_renamed;
            }
            try {
                return java.lang.Integer.parseInt(attributeValue);
            } catch (java.lang.NumberFormatException e_renamed) {
                throw new com.google.android.exoplayer2.ParserException(e_renamed);
            }
        }

        protected final int parseRequiredInt(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str) throws com.google.android.exoplayer2.ParserException {
            java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue != null) {
                try {
                    return java.lang.Integer.parseInt(attributeValue);
                } catch (java.lang.NumberFormatException e_renamed) {
                    throw new com.google.android.exoplayer2.ParserException(e_renamed);
                }
            }
            throw new com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.MissingFieldException(str);
        }

        protected final long parseLong(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, long j_renamed) throws com.google.android.exoplayer2.ParserException {
            java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue == null) {
                return j_renamed;
            }
            try {
                return java.lang.Long.parseLong(attributeValue);
            } catch (java.lang.NumberFormatException e_renamed) {
                throw new com.google.android.exoplayer2.ParserException(e_renamed);
            }
        }

        protected final long parseRequiredLong(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str) throws com.google.android.exoplayer2.ParserException {
            java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue != null) {
                try {
                    return java.lang.Long.parseLong(attributeValue);
                } catch (java.lang.NumberFormatException e_renamed) {
                    throw new com.google.android.exoplayer2.ParserException(e_renamed);
                }
            }
            throw new com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.MissingFieldException(str);
        }

        protected final boolean parseBoolean(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, boolean z_renamed) {
            java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, str);
            return attributeValue != null ? java.lang.Boolean.parseBoolean(attributeValue) : z_renamed;
        }
    }

    private static class SmoothStreamingMediaParser extends com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser {
        private static final java.lang.String KEY_DURATION = "Duration";
        private static final java.lang.String KEY_DVR_WINDOW_LENGTH = "DVRWindowLength";
        private static final java.lang.String KEY_IS_LIVE = "IsLive";
        private static final java.lang.String KEY_LOOKAHEAD_COUNT = "LookaheadCount";
        private static final java.lang.String KEY_MAJOR_VERSION = "MajorVersion";
        private static final java.lang.String KEY_MINOR_VERSION = "MinorVersion";
        private static final java.lang.String KEY_TIME_SCALE = "TimeScale";
        public static final java.lang.String TAG = "SmoothStreamingMedia";
        private long duration;
        private long dvrWindowLength;
        private boolean isLive;
        private int lookAheadCount;
        private int majorVersion;
        private int minorVersion;
        private com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.ProtectionElement protectionElement;
        private final java.util.List<com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement> streamElements;
        private long timescale;

        public SmoothStreamingMediaParser(com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser elementParser, java.lang.String str) {
            super(elementParser, str, TAG);
            this.lookAheadCount = -1;
            this.protectionElement = null;
            this.streamElements = new java.util.LinkedList();
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public void parseStartTag(org.xmlpull.v1.XmlPullParser xmlPullParser) throws com.google.android.exoplayer2.ParserException {
            this.majorVersion = parseRequiredInt(xmlPullParser, KEY_MAJOR_VERSION);
            this.minorVersion = parseRequiredInt(xmlPullParser, KEY_MINOR_VERSION);
            this.timescale = parseLong(xmlPullParser, KEY_TIME_SCALE, 10000000L);
            this.duration = parseRequiredLong(xmlPullParser, KEY_DURATION);
            this.dvrWindowLength = parseLong(xmlPullParser, KEY_DVR_WINDOW_LENGTH, 0L);
            this.lookAheadCount = parseInt(xmlPullParser, KEY_LOOKAHEAD_COUNT, -1);
            this.isLive = parseBoolean(xmlPullParser, KEY_IS_LIVE, false);
            putNormalizedAttribute(KEY_TIME_SCALE, java.lang.Long.valueOf(this.timescale));
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public void addChild(java.lang.Object obj) {
            if (obj instanceof com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement) {
                this.streamElements.add((com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement) obj);
            } else if (obj instanceof com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.ProtectionElement) {
                com.google.android.exoplayer2.util.Assertions.checkState(this.protectionElement == null);
                this.protectionElement = (com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.ProtectionElement) obj;
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public java.lang.Object build() {
            com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement[] streamElementArr = new com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement[this.streamElements.size()];
            this.streamElements.toArray(streamElementArr);
            com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.ProtectionElement protectionElement = this.protectionElement;
            if (protectionElement != null) {
                com.google.android.exoplayer2.drm.DrmInitData drmInitData = new com.google.android.exoplayer2.drm.DrmInitData(new com.google.android.exoplayer2.drm.DrmInitData.SchemeData(protectionElement.uuid, com.google.android.exoplayer2.util.MimeTypes.VIDEO_MP4, this.protectionElement.data));
                for (com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement streamElement : streamElementArr) {
                    int i_renamed = streamElement.type;
                    if (i_renamed == 2 || i_renamed == 1) {
                        com.google.android.exoplayer2.Format[] formatArr = streamElement.formats;
                        for (int i2 = 0; i2 < formatArr.length; i2++) {
                            formatArr[i2] = formatArr[i2].copyWithDrmInitData(drmInitData);
                        }
                    }
                }
            }
            return new com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest(this.majorVersion, this.minorVersion, this.timescale, this.duration, this.dvrWindowLength, this.lookAheadCount, this.isLive, this.protectionElement, streamElementArr);
        }
    }

    private static class ProtectionParser extends com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser {
        private static final int INITIALIZATION_VECTOR_SIZE = 8;
        public static final java.lang.String KEY_SYSTEM_ID = "SystemID";
        public static final java.lang.String TAG = "Protection";
        public static final java.lang.String TAG_PROTECTION_HEADER = "ProtectionHeader";
        private boolean inProtectionHeader;
        private byte[] initData;
        private java.util.UUID uuid;

        public ProtectionParser(com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser elementParser, java.lang.String str) {
            super(elementParser, str, TAG);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public boolean handleChildInline(java.lang.String str) {
            return TAG_PROTECTION_HEADER.equals(str);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public void parseStartTag(org.xmlpull.v1.XmlPullParser xmlPullParser) {
            if (TAG_PROTECTION_HEADER.equals(xmlPullParser.getName())) {
                this.inProtectionHeader = true;
                this.uuid = java.util.UUID.fromString(stripCurlyBraces(xmlPullParser.getAttributeValue(null, KEY_SYSTEM_ID)));
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public void parseText(org.xmlpull.v1.XmlPullParser xmlPullParser) {
            if (this.inProtectionHeader) {
                this.initData = android.util.Base64.decode(xmlPullParser.getText(), 0);
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public void parseEndTag(org.xmlpull.v1.XmlPullParser xmlPullParser) {
            if (TAG_PROTECTION_HEADER.equals(xmlPullParser.getName())) {
                this.inProtectionHeader = false;
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public java.lang.Object build() {
            java.util.UUID uuid = this.uuid;
            return new com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.ProtectionElement(uuid, com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil.buildPsshAtom(uuid, this.initData), buildTrackEncryptionBoxes(this.initData));
        }

        private static com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox[] buildTrackEncryptionBoxes(byte[] bArr) {
            return new com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox[]{new com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox(true, null, 8, getProtectionElementKeyId(bArr), 0, 0, null)};
        }

        private static byte[] getProtectionElementKeyId(byte[] bArr) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (int i_renamed = 0; i_renamed < bArr.length; i_renamed += 2) {
                sb.append((char) bArr[i_renamed]);
            }
            java.lang.String string = sb.toString();
            byte[] bArrDecode = android.util.Base64.decode(string.substring(string.indexOf("<KID>") + 5, string.indexOf("</KID>")), 0);
            swap(bArrDecode, 0, 3);
            swap(bArrDecode, 1, 2);
            swap(bArrDecode, 4, 5);
            swap(bArrDecode, 6, 7);
            return bArrDecode;
        }

        private static void swap(byte[] bArr, int i_renamed, int i2) {
            byte b2 = bArr[i_renamed];
            bArr[i_renamed] = bArr[i2];
            bArr[i2] = b2;
        }

        private static java.lang.String stripCurlyBraces(java.lang.String str) {
            return (str.charAt(0) == '{' && str.charAt(str.length() - 1) == '}') ? str.substring(1, str.length() - 1) : str;
        }
    }

    private static class StreamIndexParser extends com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser {
        private static final java.lang.String KEY_DISPLAY_HEIGHT = "DisplayHeight";
        private static final java.lang.String KEY_DISPLAY_WIDTH = "DisplayWidth";
        private static final java.lang.String KEY_FRAGMENT_DURATION = "d_renamed";
        private static final java.lang.String KEY_FRAGMENT_REPEAT_COUNT = "r_renamed";
        private static final java.lang.String KEY_FRAGMENT_START_TIME = "t_renamed";
        private static final java.lang.String KEY_LANGUAGE = "Language";
        private static final java.lang.String KEY_MAX_HEIGHT = "MaxHeight";
        private static final java.lang.String KEY_MAX_WIDTH = "MaxWidth";
        private static final java.lang.String KEY_NAME = "Name";
        private static final java.lang.String KEY_SUB_TYPE = "Subtype";
        private static final java.lang.String KEY_TIME_SCALE = "TimeScale";
        private static final java.lang.String KEY_TYPE = "Type";
        private static final java.lang.String KEY_TYPE_AUDIO = "audio";
        private static final java.lang.String KEY_TYPE_TEXT = "text";
        private static final java.lang.String KEY_TYPE_VIDEO = "video";
        private static final java.lang.String KEY_URL = "Url";
        public static final java.lang.String TAG = "StreamIndex";
        private static final java.lang.String TAG_STREAM_FRAGMENT = "c_renamed";
        private final java.lang.String baseUri;
        private int displayHeight;
        private int displayWidth;
        private final java.util.List<com.google.android.exoplayer2.Format> formats;
        private java.lang.String language;
        private long lastChunkDuration;
        private int maxHeight;
        private int maxWidth;
        private java.lang.String name;
        private java.util.ArrayList<java.lang.Long> startTimes;
        private java.lang.String subType;
        private long timescale;
        private int type;
        private java.lang.String url;

        public StreamIndexParser(com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser elementParser, java.lang.String str) {
            super(elementParser, str, TAG);
            this.baseUri = str;
            this.formats = new java.util.LinkedList();
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public boolean handleChildInline(java.lang.String str) {
            return TAG_STREAM_FRAGMENT.equals(str);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public void parseStartTag(org.xmlpull.v1.XmlPullParser xmlPullParser) throws com.google.android.exoplayer2.ParserException {
            if (TAG_STREAM_FRAGMENT.equals(xmlPullParser.getName())) {
                parseStreamFragmentStartTag(xmlPullParser);
            } else {
                parseStreamElementStartTag(xmlPullParser);
            }
        }

        private void parseStreamFragmentStartTag(org.xmlpull.v1.XmlPullParser xmlPullParser) throws com.google.android.exoplayer2.ParserException {
            int size = this.startTimes.size();
            long jLongValue = parseLong(xmlPullParser, KEY_FRAGMENT_START_TIME, -9223372036854775807L);
            int i_renamed = 1;
            if (jLongValue == -9223372036854775807L) {
                if (size == 0) {
                    jLongValue = 0;
                } else if (this.lastChunkDuration != -1) {
                    jLongValue = this.startTimes.get(size - 1).longValue() + this.lastChunkDuration;
                } else {
                    throw new com.google.android.exoplayer2.ParserException("Unable to infer start time");
                }
            }
            this.startTimes.add(java.lang.Long.valueOf(jLongValue));
            this.lastChunkDuration = parseLong(xmlPullParser, KEY_FRAGMENT_DURATION, -9223372036854775807L);
            long j_renamed = parseLong(xmlPullParser, KEY_FRAGMENT_REPEAT_COUNT, 1L);
            if (j_renamed > 1 && this.lastChunkDuration == -9223372036854775807L) {
                throw new com.google.android.exoplayer2.ParserException("Repeated chunk with unspecified duration");
            }
            while (true) {
                long j2 = i_renamed;
                if (j2 >= j_renamed) {
                    return;
                }
                this.startTimes.add(java.lang.Long.valueOf((this.lastChunkDuration * j2) + jLongValue));
                i_renamed++;
            }
        }

        private void parseStreamElementStartTag(org.xmlpull.v1.XmlPullParser xmlPullParser) throws com.google.android.exoplayer2.ParserException {
            this.type = parseType(xmlPullParser);
            putNormalizedAttribute(KEY_TYPE, java.lang.Integer.valueOf(this.type));
            if (this.type == 3) {
                this.subType = parseRequiredString(xmlPullParser, KEY_SUB_TYPE);
            } else {
                this.subType = xmlPullParser.getAttributeValue(null, KEY_SUB_TYPE);
            }
            this.name = xmlPullParser.getAttributeValue(null, KEY_NAME);
            this.url = parseRequiredString(xmlPullParser, KEY_URL);
            this.maxWidth = parseInt(xmlPullParser, KEY_MAX_WIDTH, -1);
            this.maxHeight = parseInt(xmlPullParser, KEY_MAX_HEIGHT, -1);
            this.displayWidth = parseInt(xmlPullParser, KEY_DISPLAY_WIDTH, -1);
            this.displayHeight = parseInt(xmlPullParser, KEY_DISPLAY_HEIGHT, -1);
            this.language = xmlPullParser.getAttributeValue(null, KEY_LANGUAGE);
            putNormalizedAttribute(KEY_LANGUAGE, this.language);
            this.timescale = parseInt(xmlPullParser, KEY_TIME_SCALE, -1);
            if (this.timescale == -1) {
                this.timescale = ((java.lang.Long) getNormalizedAttribute(KEY_TIME_SCALE)).longValue();
            }
            this.startTimes = new java.util.ArrayList<>();
        }

        private int parseType(org.xmlpull.v1.XmlPullParser xmlPullParser) throws com.google.android.exoplayer2.ParserException {
            java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, KEY_TYPE);
            if (attributeValue != null) {
                if ("audio".equalsIgnoreCase(attributeValue)) {
                    return 1;
                }
                if ("video".equalsIgnoreCase(attributeValue)) {
                    return 2;
                }
                if ("text".equalsIgnoreCase(attributeValue)) {
                    return 3;
                }
                throw new com.google.android.exoplayer2.ParserException("Invalid key value[" + attributeValue + "]");
            }
            throw new com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.MissingFieldException(KEY_TYPE);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public void addChild(java.lang.Object obj) {
            if (obj instanceof com.google.android.exoplayer2.Format) {
                this.formats.add((com.google.android.exoplayer2.Format) obj);
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public java.lang.Object build() {
            com.google.android.exoplayer2.Format[] formatArr = new com.google.android.exoplayer2.Format[this.formats.size()];
            this.formats.toArray(formatArr);
            return new com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest.StreamElement(this.baseUri, this.url, this.type, this.subType, this.timescale, this.name, this.maxWidth, this.maxHeight, this.displayWidth, this.displayHeight, this.language, formatArr, this.startTimes, this.lastChunkDuration);
        }
    }

    private static class QualityLevelParser extends com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser {
        private static final java.lang.String KEY_BITRATE = "Bitrate";
        private static final java.lang.String KEY_CHANNELS = "Channels";
        private static final java.lang.String KEY_CODEC_PRIVATE_DATA = "CodecPrivateData";
        private static final java.lang.String KEY_FOUR_CC = "FourCC";
        private static final java.lang.String KEY_INDEX = "Index";
        private static final java.lang.String KEY_LANGUAGE = "Language";
        private static final java.lang.String KEY_MAX_HEIGHT = "MaxHeight";
        private static final java.lang.String KEY_MAX_WIDTH = "MaxWidth";
        private static final java.lang.String KEY_NAME = "Name";
        private static final java.lang.String KEY_SAMPLING_RATE = "SamplingRate";
        private static final java.lang.String KEY_TYPE = "Type";
        public static final java.lang.String TAG = "QualityLevel";
        private com.google.android.exoplayer2.Format format;

        public QualityLevelParser(com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser elementParser, java.lang.String str) {
            super(elementParser, str, TAG);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public void parseStartTag(org.xmlpull.v1.XmlPullParser xmlPullParser) throws com.google.android.exoplayer2.ParserException {
            int iIntValue = ((java.lang.Integer) getNormalizedAttribute(KEY_TYPE)).intValue();
            java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, KEY_INDEX);
            java.lang.String str = (java.lang.String) getNormalizedAttribute(KEY_NAME);
            int requiredInt = parseRequiredInt(xmlPullParser, KEY_BITRATE);
            java.lang.String strFourCCToMimeType = fourCCToMimeType(parseRequiredString(xmlPullParser, KEY_FOUR_CC));
            if (iIntValue == 2) {
                this.format = com.google.android.exoplayer2.Format.createVideoContainerFormat(attributeValue, str, com.google.android.exoplayer2.util.MimeTypes.VIDEO_MP4, strFourCCToMimeType, null, requiredInt, parseRequiredInt(xmlPullParser, KEY_MAX_WIDTH), parseRequiredInt(xmlPullParser, KEY_MAX_HEIGHT), -1.0f, buildCodecSpecificData(xmlPullParser.getAttributeValue(null, KEY_CODEC_PRIVATE_DATA)), 0);
                return;
            }
            if (iIntValue != 1) {
                if (iIntValue == 3) {
                    this.format = com.google.android.exoplayer2.Format.createTextContainerFormat(attributeValue, str, com.google.android.exoplayer2.util.MimeTypes.APPLICATION_MP4, strFourCCToMimeType, null, requiredInt, 0, (java.lang.String) getNormalizedAttribute(KEY_LANGUAGE));
                    return;
                } else {
                    this.format = com.google.android.exoplayer2.Format.createContainerFormat(attributeValue, str, com.google.android.exoplayer2.util.MimeTypes.APPLICATION_MP4, strFourCCToMimeType, null, requiredInt, 0, null);
                    return;
                }
            }
            if (strFourCCToMimeType == null) {
                strFourCCToMimeType = com.google.android.exoplayer2.util.MimeTypes.AUDIO_AAC;
            }
            int requiredInt2 = parseRequiredInt(xmlPullParser, KEY_CHANNELS);
            int requiredInt3 = parseRequiredInt(xmlPullParser, KEY_SAMPLING_RATE);
            java.util.List<byte[]> listBuildCodecSpecificData = buildCodecSpecificData(xmlPullParser.getAttributeValue(null, KEY_CODEC_PRIVATE_DATA));
            if (listBuildCodecSpecificData.isEmpty() && com.google.android.exoplayer2.util.MimeTypes.AUDIO_AAC.equals(strFourCCToMimeType)) {
                listBuildCodecSpecificData = java.util.Collections.singletonList(com.google.android.exoplayer2.util.CodecSpecificDataUtil.buildAacLcAudioSpecificConfig(requiredInt3, requiredInt2));
            }
            this.format = com.google.android.exoplayer2.Format.createAudioContainerFormat(attributeValue, str, com.google.android.exoplayer2.util.MimeTypes.AUDIO_MP4, strFourCCToMimeType, null, requiredInt, requiredInt2, requiredInt3, listBuildCodecSpecificData, 0, (java.lang.String) getNormalizedAttribute(KEY_LANGUAGE));
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public java.lang.Object build() {
            return this.format;
        }

        private static java.util.List<byte[]> buildCodecSpecificData(java.lang.String str) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            if (!android.text.TextUtils.isEmpty(str)) {
                byte[] bytesFromHexString = com.google.android.exoplayer2.util.Util.getBytesFromHexString(str);
                byte[][] bArrSplitNalUnits = com.google.android.exoplayer2.util.CodecSpecificDataUtil.splitNalUnits(bytesFromHexString);
                if (bArrSplitNalUnits == null) {
                    arrayList.add(bytesFromHexString);
                } else {
                    java.util.Collections.addAll(arrayList, bArrSplitNalUnits);
                }
            }
            return arrayList;
        }

        private static java.lang.String fourCCToMimeType(java.lang.String str) {
            if (str.equalsIgnoreCase(com.oplus.ocs.camera.CameraParameter.VideoEncoder.H264) || str.equalsIgnoreCase("X264") || str.equalsIgnoreCase("AVC1") || str.equalsIgnoreCase("DAVC")) {
                return com.google.android.exoplayer2.util.MimeTypes.VIDEO_H264;
            }
            if (str.equalsIgnoreCase("AAC") || str.equalsIgnoreCase("AACL") || str.equalsIgnoreCase("AACH") || str.equalsIgnoreCase("AACP")) {
                return com.google.android.exoplayer2.util.MimeTypes.AUDIO_AAC;
            }
            if (str.equalsIgnoreCase("TTML") || str.equalsIgnoreCase("DFXP")) {
                return com.google.android.exoplayer2.util.MimeTypes.APPLICATION_TTML;
            }
            if (str.equalsIgnoreCase("ac_renamed-3") || str.equalsIgnoreCase("dac3")) {
                return com.google.android.exoplayer2.util.MimeTypes.AUDIO_AC3;
            }
            if (str.equalsIgnoreCase("ec_renamed-3") || str.equalsIgnoreCase("dec3")) {
                return com.google.android.exoplayer2.util.MimeTypes.AUDIO_E_AC3;
            }
            if (str.equalsIgnoreCase("dtsc")) {
                return com.google.android.exoplayer2.util.MimeTypes.AUDIO_DTS;
            }
            if (str.equalsIgnoreCase("dtsh") || str.equalsIgnoreCase("dtsl")) {
                return com.google.android.exoplayer2.util.MimeTypes.AUDIO_DTS_HD;
            }
            if (str.equalsIgnoreCase("dtse")) {
                return com.google.android.exoplayer2.util.MimeTypes.AUDIO_DTS_EXPRESS;
            }
            if (str.equalsIgnoreCase("opus")) {
                return com.google.android.exoplayer2.util.MimeTypes.AUDIO_OPUS;
            }
            return null;
        }
    }
}
