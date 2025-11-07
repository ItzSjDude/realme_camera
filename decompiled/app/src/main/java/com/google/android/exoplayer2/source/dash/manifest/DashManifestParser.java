package com.google.android.exoplayer2.source.dash.manifest;

/* loaded from: classes.dex */
public class DashManifestParser extends org.xml.sax.helpers.DefaultHandler implements com.google.android.exoplayer2.upstream.ParsingLoadable.Parser<com.google.android.exoplayer2.source.dash.manifest.DashManifest> {
    private static final java.lang.String TAG = "MpdParser";
    private final java.lang.String contentId;
    private final org.xmlpull.v1.XmlPullParserFactory xmlParserFactory;
    private static final java.util.regex.Pattern FRAME_RATE_PATTERN = java.util.regex.Pattern.compile("(\\d_renamed+)(?:/(\\d_renamed+))?");
    private static final java.util.regex.Pattern CEA_608_ACCESSIBILITY_PATTERN = java.util.regex.Pattern.compile("CC([1-4])=.*");
    private static final java.util.regex.Pattern CEA_708_ACCESSIBILITY_PATTERN = java.util.regex.Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");

    public DashManifestParser() {
        this(null);
    }

    public DashManifestParser(java.lang.String str) {
        this.contentId = str;
        try {
            this.xmlParserFactory = org.xmlpull.v1.XmlPullParserFactory.newInstance();
        } catch (org.xmlpull.v1.XmlPullParserException e_renamed) {
            throw new java.lang.RuntimeException("Couldn't_renamed create XmlPullParserFactory instance", e_renamed);
        }
    }

    /* JADX WARN: Can't_renamed rename method to resolve collision */
    @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
    public com.google.android.exoplayer2.source.dash.manifest.DashManifest parse(android.net.Uri uri, java.io.InputStream inputStream) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        try {
            org.xmlpull.v1.XmlPullParser xmlPullParserNewPullParser = this.xmlParserFactory.newPullParser();
            xmlPullParserNewPullParser.setInput(inputStream, null);
            if (xmlPullParserNewPullParser.next() != 2 || !"MPD".equals(xmlPullParserNewPullParser.getName())) {
                throw new com.google.android.exoplayer2.ParserException("inputStream does not contain a_renamed valid media presentation description");
            }
            return parseMediaPresentationDescription(xmlPullParserNewPullParser, uri.toString());
        } catch (org.xmlpull.v1.XmlPullParserException e_renamed) {
            throw new com.google.android.exoplayer2.ParserException(e_renamed);
        }
    }

    protected com.google.android.exoplayer2.source.dash.manifest.DashManifest parseMediaPresentationDescription(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException, java.lang.NumberFormatException {
        long j_renamed;
        boolean z_renamed;
        long j2;
        long dateTime = parseDateTime(xmlPullParser, "availabilityStartTime", -9223372036854775807L);
        long duration = parseDuration(xmlPullParser, "mediaPresentationDuration", -9223372036854775807L);
        long duration2 = parseDuration(xmlPullParser, "minBufferTime", -9223372036854775807L);
        java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, com.oplus.ocs.camera.CameraParameter.TiltShiftParamKeys.TYPE);
        boolean z2 = false;
        boolean z3 = attributeValue != null && "dynamic".equals(attributeValue);
        long duration3 = z3 ? parseDuration(xmlPullParser, "minimumUpdatePeriod", -9223372036854775807L) : -9223372036854775807L;
        long duration4 = z3 ? parseDuration(xmlPullParser, "timeShiftBufferDepth", -9223372036854775807L) : -9223372036854775807L;
        long duration5 = z3 ? parseDuration(xmlPullParser, "suggestedPresentationDelay", -9223372036854775807L) : -9223372036854775807L;
        long dateTime2 = parseDateTime(xmlPullParser, "publishTime", -9223372036854775807L);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.google.android.exoplayer2.source.dash.manifest.ProgramInformation programInformation = null;
        com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement utcTiming = null;
        android.net.Uri uri = null;
        long j3 = z3 ? -9223372036854775807L : 0L;
        java.lang.String baseUrl = str;
        boolean z4 = false;
        while (true) {
            xmlPullParser.next();
            if (!com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "BaseURL")) {
                if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "ProgramInformation")) {
                    programInformation = parseProgramInformation(xmlPullParser);
                } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "UTCTiming")) {
                    utcTiming = parseUtcTiming(xmlPullParser);
                } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "Location")) {
                    uri = android.net.Uri.parse(xmlPullParser.nextText());
                } else {
                    if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "Period") && !z4) {
                        z_renamed = z2;
                        android.util.Pair<com.google.android.exoplayer2.source.dash.manifest.Period, java.lang.Long> period = parsePeriod(xmlPullParser, baseUrl, j3);
                        j_renamed = j3;
                        com.google.android.exoplayer2.source.dash.manifest.Period period2 = (com.google.android.exoplayer2.source.dash.manifest.Period) period.first;
                        j2 = duration3;
                        if (period2.startMs != -9223372036854775807L) {
                            long jLongValue = ((java.lang.Long) period.second).longValue();
                            long j4 = jLongValue == -9223372036854775807L ? -9223372036854775807L : period2.startMs + jLongValue;
                            arrayList.add(period2);
                            j_renamed = j4;
                        } else {
                            if (!z3) {
                                throw new com.google.android.exoplayer2.ParserException("Unable to determine start of_renamed period " + arrayList.size());
                            }
                            z4 = true;
                        }
                    } else {
                        j_renamed = j3;
                        z_renamed = z2;
                        j2 = duration3;
                        maybeSkipTag(xmlPullParser);
                    }
                    z2 = z_renamed;
                    j3 = j_renamed;
                }
                j2 = duration3;
            } else if (z2) {
                j_renamed = j3;
                z_renamed = z2;
                j2 = duration3;
                z2 = z_renamed;
                j3 = j_renamed;
            } else {
                baseUrl = parseBaseUrl(xmlPullParser, baseUrl);
                j2 = duration3;
                z2 = true;
            }
            if (com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(xmlPullParser, "MPD")) {
                if (duration != -9223372036854775807L) {
                    j3 = duration;
                } else if (j3 == -9223372036854775807L) {
                    if (!z3) {
                        throw new com.google.android.exoplayer2.ParserException("Unable to determine duration of_renamed static manifest.");
                    }
                    j3 = duration;
                }
                if (arrayList.isEmpty()) {
                    throw new com.google.android.exoplayer2.ParserException("No periods found.");
                }
                return buildMediaPresentationDescription(dateTime, j3, duration2, z3, j2, duration4, duration5, dateTime2, programInformation, utcTiming, uri, arrayList);
            }
            duration3 = j2;
        }
    }

    protected com.google.android.exoplayer2.source.dash.manifest.DashManifest buildMediaPresentationDescription(long j_renamed, long j2, long j3, boolean z_renamed, long j4, long j5, long j6, long j7, com.google.android.exoplayer2.source.dash.manifest.ProgramInformation programInformation, com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement utcTimingElement, android.net.Uri uri, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Period> list) {
        return new com.google.android.exoplayer2.source.dash.manifest.DashManifest(j_renamed, j2, j3, z_renamed, j4, j5, j6, j7, programInformation, utcTimingElement, uri, list);
    }

    protected com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement parseUtcTiming(org.xmlpull.v1.XmlPullParser xmlPullParser) {
        return buildUtcTimingElement(xmlPullParser.getAttributeValue(null, "schemeIdUri"), xmlPullParser.getAttributeValue(null, com.android.providers.downloads.Downloads.Impl.RequestHeaders.COLUMN_VALUE));
    }

    protected com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement buildUtcTimingElement(java.lang.String str, java.lang.String str2) {
        return new com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement(str, str2);
    }

    protected android.util.Pair<com.google.android.exoplayer2.source.dash.manifest.Period, java.lang.Long> parsePeriod(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, long j_renamed) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException, java.lang.NumberFormatException {
        java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, com.google.android.exoplayer2.text.ttml.TtmlNode.ATTR_ID);
        long duration = parseDuration(xmlPullParser, com.google.android.exoplayer2.text.ttml.TtmlNode.START, j_renamed);
        long duration2 = parseDuration(xmlPullParser, com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, -9223372036854775807L);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        boolean z_renamed = false;
        com.google.android.exoplayer2.source.dash.manifest.SegmentBase segmentTemplate = null;
        do {
            xmlPullParser.next();
            if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "BaseURL")) {
                if (!z_renamed) {
                    str = parseBaseUrl(xmlPullParser, str);
                    z_renamed = true;
                }
            } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "AdaptationSet")) {
                arrayList.add(parseAdaptationSet(xmlPullParser, str, segmentTemplate));
            } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "EventStream")) {
                arrayList2.add(parseEventStream(xmlPullParser));
            } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentBase")) {
                segmentTemplate = parseSegmentBase(xmlPullParser, null);
            } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentList")) {
                segmentTemplate = parseSegmentList(xmlPullParser, null);
            } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentTemplate")) {
                segmentTemplate = parseSegmentTemplate(xmlPullParser, null);
            } else {
                maybeSkipTag(xmlPullParser);
            }
        } while (!com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(xmlPullParser, "Period"));
        return android.util.Pair.create(buildPeriod(attributeValue, duration, arrayList, arrayList2), java.lang.Long.valueOf(duration2));
    }

    protected com.google.android.exoplayer2.source.dash.manifest.Period buildPeriod(java.lang.String str, long j_renamed, java.util.List<com.google.android.exoplayer2.source.dash.manifest.AdaptationSet> list, java.util.List<com.google.android.exoplayer2.source.dash.manifest.EventStream> list2) {
        return new com.google.android.exoplayer2.source.dash.manifest.Period(str, j_renamed, list, list2);
    }

    protected com.google.android.exoplayer2.source.dash.manifest.AdaptationSet parseAdaptationSet(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, com.google.android.exoplayer2.source.dash.manifest.SegmentBase segmentBase) throws org.xmlpull.v1.XmlPullParserException, java.lang.NumberFormatException, java.io.IOException {
        int i_renamed;
        java.lang.String str2;
        java.lang.String baseUrl;
        java.util.ArrayList arrayList;
        java.util.ArrayList arrayList2;
        java.util.ArrayList arrayList3;
        java.util.ArrayList arrayList4;
        java.lang.String str3;
        java.lang.String str4;
        org.xmlpull.v1.XmlPullParser xmlPullParser2;
        java.util.ArrayList<com.google.android.exoplayer2.source.dash.manifest.Descriptor> arrayList5;
        com.google.android.exoplayer2.source.dash.manifest.SegmentBase segmentTemplate;
        int iCheckContentTypeConsistency;
        org.xmlpull.v1.XmlPullParser xmlPullParser3 = xmlPullParser;
        int i2 = parseInt(xmlPullParser3, com.google.android.exoplayer2.text.ttml.TtmlNode.ATTR_ID, -1);
        int contentType = parseContentType(xmlPullParser);
        java.lang.String str5 = null;
        java.lang.String attributeValue = xmlPullParser3.getAttributeValue(null, "mimeType");
        java.lang.String attributeValue2 = xmlPullParser3.getAttributeValue(null, "codecs");
        int i3 = parseInt(xmlPullParser3, "width", -1);
        int i4 = parseInt(xmlPullParser3, "height", -1);
        float frameRate = parseFrameRate(xmlPullParser3, -1.0f);
        int i5 = parseInt(xmlPullParser3, "audioSamplingRate", -1);
        java.lang.String str6 = "lang";
        java.lang.String attributeValue3 = xmlPullParser3.getAttributeValue(null, "lang");
        java.lang.String attributeValue4 = xmlPullParser3.getAttributeValue(null, "label");
        java.util.ArrayList arrayList6 = new java.util.ArrayList();
        java.util.ArrayList<com.google.android.exoplayer2.source.dash.manifest.Descriptor> arrayList7 = new java.util.ArrayList<>();
        java.util.ArrayList arrayList8 = new java.util.ArrayList();
        java.util.ArrayList arrayList9 = new java.util.ArrayList();
        java.util.ArrayList arrayList10 = new java.util.ArrayList();
        java.lang.String str7 = str;
        com.google.android.exoplayer2.source.dash.manifest.SegmentBase segmentBase2 = segmentBase;
        int audioChannelConfiguration = -1;
        int i6 = contentType;
        java.lang.String strCheckLanguageConsistency = attributeValue3;
        java.lang.String str8 = null;
        boolean z_renamed = false;
        int role = 0;
        java.util.ArrayList arrayList11 = arrayList6;
        while (true) {
            xmlPullParser.next();
            if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser3, "BaseURL")) {
                if (!z_renamed) {
                    baseUrl = parseBaseUrl(xmlPullParser3, str7);
                    z_renamed = true;
                    arrayList = arrayList10;
                    arrayList2 = arrayList9;
                    arrayList3 = arrayList8;
                    arrayList5 = arrayList7;
                    arrayList4 = arrayList11;
                    str3 = str6;
                    str4 = str5;
                    xmlPullParser2 = xmlPullParser3;
                    iCheckContentTypeConsistency = i6;
                }
                i_renamed = i6;
                str2 = strCheckLanguageConsistency;
                baseUrl = str7;
                arrayList = arrayList10;
                arrayList2 = arrayList9;
                arrayList3 = arrayList8;
                arrayList5 = arrayList7;
                arrayList4 = arrayList11;
                str3 = str6;
                str4 = str5;
                xmlPullParser2 = xmlPullParser3;
                iCheckContentTypeConsistency = i_renamed;
                strCheckLanguageConsistency = str2;
            } else {
                if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser3, "ContentProtection")) {
                    android.util.Pair<java.lang.String, com.google.android.exoplayer2.drm.DrmInitData.SchemeData> contentProtection = parseContentProtection(xmlPullParser);
                    if (contentProtection.first != null) {
                        str8 = (java.lang.String) contentProtection.first;
                    }
                    if (contentProtection.second != null) {
                        arrayList11.add(contentProtection.second);
                    }
                } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser3, "ContentComponent")) {
                    strCheckLanguageConsistency = checkLanguageConsistency(strCheckLanguageConsistency, xmlPullParser3.getAttributeValue(str5, str6));
                    baseUrl = str7;
                    arrayList = arrayList10;
                    arrayList2 = arrayList9;
                    arrayList3 = arrayList8;
                    arrayList5 = arrayList7;
                    arrayList4 = arrayList11;
                    str3 = str6;
                    str4 = str5;
                    xmlPullParser2 = xmlPullParser3;
                    iCheckContentTypeConsistency = checkContentTypeConsistency(i6, parseContentType(xmlPullParser));
                } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser3, "Role")) {
                    role |= parseRole(xmlPullParser);
                } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser3, "AudioChannelConfiguration")) {
                    audioChannelConfiguration = parseAudioChannelConfiguration(xmlPullParser);
                } else {
                    if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser3, "Accessibility")) {
                        arrayList8.add(parseDescriptor(xmlPullParser3, "Accessibility"));
                    } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser3, "SupplementalProperty")) {
                        arrayList9.add(parseDescriptor(xmlPullParser3, "SupplementalProperty"));
                    } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser3, "Representation")) {
                        java.lang.String str9 = strCheckLanguageConsistency;
                        baseUrl = str7;
                        arrayList2 = arrayList9;
                        arrayList3 = arrayList8;
                        arrayList4 = arrayList11;
                        str3 = str6;
                        str4 = str5;
                        com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.RepresentationInfo representation = parseRepresentation(xmlPullParser, str7, attributeValue4, attributeValue, attributeValue2, i3, i4, frameRate, audioChannelConfiguration, i5, str9, role, arrayList3, segmentBase2);
                        int iCheckContentTypeConsistency2 = checkContentTypeConsistency(i6, getContentType(representation.format));
                        arrayList = arrayList10;
                        arrayList.add(representation);
                        iCheckContentTypeConsistency = iCheckContentTypeConsistency2;
                        strCheckLanguageConsistency = str9;
                        arrayList5 = arrayList7;
                        xmlPullParser2 = xmlPullParser;
                    } else {
                        i_renamed = i6;
                        str2 = strCheckLanguageConsistency;
                        baseUrl = str7;
                        arrayList = arrayList10;
                        arrayList2 = arrayList9;
                        arrayList3 = arrayList8;
                        java.util.ArrayList<com.google.android.exoplayer2.source.dash.manifest.Descriptor> arrayList12 = arrayList7;
                        arrayList4 = arrayList11;
                        str3 = str6;
                        str4 = str5;
                        xmlPullParser2 = xmlPullParser;
                        if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentBase")) {
                            segmentTemplate = parseSegmentBase(xmlPullParser2, (com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SingleSegmentBase) segmentBase2);
                        } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentList")) {
                            segmentTemplate = parseSegmentList(xmlPullParser2, (com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentList) segmentBase2);
                        } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser2, "SegmentTemplate")) {
                            segmentTemplate = parseSegmentTemplate(xmlPullParser2, (com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTemplate) segmentBase2);
                        } else {
                            if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser2, "InbandEventStream")) {
                                arrayList5 = arrayList12;
                                arrayList5.add(parseDescriptor(xmlPullParser2, "InbandEventStream"));
                            } else {
                                arrayList5 = arrayList12;
                                if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser)) {
                                    parseAdaptationSetChild(xmlPullParser);
                                }
                            }
                            iCheckContentTypeConsistency = i_renamed;
                            strCheckLanguageConsistency = str2;
                        }
                        segmentBase2 = segmentTemplate;
                        iCheckContentTypeConsistency = i_renamed;
                        strCheckLanguageConsistency = str2;
                        arrayList5 = arrayList12;
                    }
                    i_renamed = i6;
                    str2 = strCheckLanguageConsistency;
                    baseUrl = str7;
                    arrayList = arrayList10;
                    arrayList2 = arrayList9;
                    arrayList3 = arrayList8;
                    arrayList5 = arrayList7;
                    arrayList4 = arrayList11;
                    str3 = str6;
                    str4 = str5;
                    xmlPullParser2 = xmlPullParser3;
                    iCheckContentTypeConsistency = i_renamed;
                    strCheckLanguageConsistency = str2;
                }
                baseUrl = str7;
                arrayList = arrayList10;
                arrayList2 = arrayList9;
                arrayList3 = arrayList8;
                arrayList5 = arrayList7;
                arrayList4 = arrayList11;
                str3 = str6;
                str4 = str5;
                xmlPullParser2 = xmlPullParser3;
                iCheckContentTypeConsistency = i6;
            }
            if (com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(xmlPullParser2, "AdaptationSet")) {
                break;
            }
            xmlPullParser3 = xmlPullParser2;
            arrayList7 = arrayList5;
            i6 = iCheckContentTypeConsistency;
            arrayList9 = arrayList2;
            arrayList8 = arrayList3;
            arrayList11 = arrayList4;
            str6 = str3;
            str5 = str4;
            arrayList10 = arrayList;
            str7 = baseUrl;
        }
        java.util.ArrayList arrayList13 = new java.util.ArrayList(arrayList.size());
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            arrayList13.add(buildRepresentation((com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.RepresentationInfo) arrayList.get(i7), this.contentId, str8, arrayList4, arrayList5));
        }
        return buildAdaptationSet(i2, iCheckContentTypeConsistency, arrayList13, arrayList3, arrayList2);
    }

    protected com.google.android.exoplayer2.source.dash.manifest.AdaptationSet buildAdaptationSet(int i_renamed, int i2, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Representation> list, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list2, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list3) {
        return new com.google.android.exoplayer2.source.dash.manifest.AdaptationSet(i_renamed, i2, list, list2, list3);
    }

    protected int parseContentType(org.xmlpull.v1.XmlPullParser xmlPullParser) {
        java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, "contentType");
        if (android.text.TextUtils.isEmpty(attributeValue)) {
            return -1;
        }
        if (com.google.android.exoplayer2.util.MimeTypes.BASE_TYPE_AUDIO.equals(attributeValue)) {
            return 1;
        }
        if ("video".equals(attributeValue)) {
            return 2;
        }
        return com.google.android.exoplayer2.util.MimeTypes.BASE_TYPE_TEXT.equals(attributeValue) ? 3 : -1;
    }

    protected int getContentType(com.google.android.exoplayer2.Format format) {
        java.lang.String str = format.sampleMimeType;
        if (android.text.TextUtils.isEmpty(str)) {
            return -1;
        }
        if (com.google.android.exoplayer2.util.MimeTypes.isVideo(str)) {
            return 2;
        }
        if (com.google.android.exoplayer2.util.MimeTypes.isAudio(str)) {
            return 1;
        }
        return mimeTypeIsRawText(str) ? 3 : -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B_renamed:78:0x013b A_renamed[LOOP:0: B_renamed:39:0x009b->B_renamed:78:0x013b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:79:0x012c A_renamed[EDGE_INSN: B_renamed:79:0x012c->B_renamed:74:0x012c BREAK  A_renamed[LOOP:0: B_renamed:39:0x009b->B_renamed:78:0x013b], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r3v17, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r3v4, types: [byte[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected android.util.Pair<java.lang.String, com.google.android.exoplayer2.drm.DrmInitData.SchemeData> parseContentProtection(org.xmlpull.v1.XmlPullParser r15) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 321
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.parseContentProtection(org.xmlpull.v1.XmlPullParser):android.util.Pair");
    }

    protected int parseRole(org.xmlpull.v1.XmlPullParser xmlPullParser) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        java.lang.String string = parseString(xmlPullParser, "schemeIdUri", null);
        java.lang.String string2 = parseString(xmlPullParser, com.android.providers.downloads.Downloads.Impl.RequestHeaders.COLUMN_VALUE, null);
        do {
            xmlPullParser.next();
        } while (!com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(xmlPullParser, "Role"));
        return ("urn:mpeg:dash:role:2011".equals(string) && "main".equals(string2)) ? 1 : 0;
    }

    protected void parseAdaptationSetChild(org.xmlpull.v1.XmlPullParser xmlPullParser) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        maybeSkipTag(xmlPullParser);
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:43:0x013e A_renamed[LOOP:0: B_renamed:3:0x0058->B_renamed:43:0x013e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B_renamed:44:0x0100 A_renamed[EDGE_INSN: B_renamed:44:0x0100->B_renamed:37:0x0100 BREAK  A_renamed[LOOP:0: B_renamed:3:0x0058->B_renamed:43:0x013e], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.RepresentationInfo parseRepresentation(org.xmlpull.v1.XmlPullParser r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, int r27, int r28, float r29, int r30, int r31, java.lang.String r32, int r33, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> r34, com.google.android.exoplayer2.source.dash.manifest.SegmentBase r35) throws org.xmlpull.v1.XmlPullParserException, java.lang.NumberFormatException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.parseRepresentation(org.xmlpull.v1.XmlPullParser, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, float, int, int, java.lang.String, int, java.util.List, com.google.android.exoplayer2.source.dash.manifest.SegmentBase):com.google.android.exoplayer2.source.dash.manifest.DashManifestParser$RepresentationInfo");
    }

    protected com.google.android.exoplayer2.Format buildFormat(java.lang.String str, java.lang.String str2, java.lang.String str3, int i_renamed, int i2, float f_renamed, int i3, int i4, int i5, java.lang.String str4, int i6, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list, java.lang.String str5, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list2) {
        java.lang.String str6;
        int cea708AccessibilityChannel;
        java.lang.String sampleMimeType = getSampleMimeType(str3, str5);
        if (sampleMimeType != null) {
            if (com.google.android.exoplayer2.util.MimeTypes.AUDIO_E_AC3.equals(sampleMimeType)) {
                sampleMimeType = parseEac3SupplementalProperties(list2);
            }
            str6 = sampleMimeType;
            if (com.google.android.exoplayer2.util.MimeTypes.isVideo(str6)) {
                return com.google.android.exoplayer2.Format.createVideoContainerFormat(str, str2, str3, str6, str5, i5, i_renamed, i2, f_renamed, null, i6);
            }
            if (com.google.android.exoplayer2.util.MimeTypes.isAudio(str6)) {
                return com.google.android.exoplayer2.Format.createAudioContainerFormat(str, str2, str3, str6, str5, i5, i3, i4, null, i6, str4);
            }
            if (mimeTypeIsRawText(str6)) {
                if (com.google.android.exoplayer2.util.MimeTypes.APPLICATION_CEA608.equals(str6)) {
                    cea708AccessibilityChannel = parseCea608AccessibilityChannel(list);
                } else {
                    cea708AccessibilityChannel = com.google.android.exoplayer2.util.MimeTypes.APPLICATION_CEA708.equals(str6) ? parseCea708AccessibilityChannel(list) : -1;
                }
                return com.google.android.exoplayer2.Format.createTextContainerFormat(str, str2, str3, str6, str5, i5, i6, str4, cea708AccessibilityChannel);
            }
        } else {
            str6 = sampleMimeType;
        }
        return com.google.android.exoplayer2.Format.createContainerFormat(str, str2, str3, str6, str5, i5, i6, str4);
    }

    protected com.google.android.exoplayer2.source.dash.manifest.Representation buildRepresentation(com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.RepresentationInfo representationInfo, java.lang.String str, java.lang.String str2, java.util.ArrayList<com.google.android.exoplayer2.drm.DrmInitData.SchemeData> arrayList, java.util.ArrayList<com.google.android.exoplayer2.source.dash.manifest.Descriptor> arrayList2) {
        com.google.android.exoplayer2.Format formatCopyWithDrmInitData = representationInfo.format;
        if (representationInfo.drmSchemeType != null) {
            str2 = representationInfo.drmSchemeType;
        }
        java.util.ArrayList<com.google.android.exoplayer2.drm.DrmInitData.SchemeData> arrayList3 = representationInfo.drmSchemeDatas;
        arrayList3.addAll(arrayList);
        if (!arrayList3.isEmpty()) {
            filterRedundantIncompleteSchemeDatas(arrayList3);
            formatCopyWithDrmInitData = formatCopyWithDrmInitData.copyWithDrmInitData(new com.google.android.exoplayer2.drm.DrmInitData(str2, arrayList3));
        }
        java.util.ArrayList<com.google.android.exoplayer2.source.dash.manifest.Descriptor> arrayList4 = representationInfo.inbandEventStreams;
        arrayList4.addAll(arrayList2);
        return com.google.android.exoplayer2.source.dash.manifest.Representation.newInstance(str, representationInfo.revisionId, formatCopyWithDrmInitData, representationInfo.baseUrl, representationInfo.segmentBase, arrayList4);
    }

    protected com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SingleSegmentBase parseSegmentBase(org.xmlpull.v1.XmlPullParser xmlPullParser, com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SingleSegmentBase singleSegmentBase) throws org.xmlpull.v1.XmlPullParserException, java.lang.NumberFormatException, java.io.IOException {
        long j_renamed;
        long j2;
        long j3 = parseLong(xmlPullParser, "timescale", singleSegmentBase != null ? singleSegmentBase.timescale : 1L);
        long j4 = parseLong(xmlPullParser, "presentationTimeOffset", singleSegmentBase != null ? singleSegmentBase.presentationTimeOffset : 0L);
        long j5 = singleSegmentBase != null ? singleSegmentBase.indexStart : 0L;
        long j6 = singleSegmentBase != null ? singleSegmentBase.indexLength : 0L;
        java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, "indexRange");
        if (attributeValue != null) {
            java.lang.String[] strArrSplit = attributeValue.split("-");
            long j7 = java.lang.Long.parseLong(strArrSplit[0]);
            j_renamed = (java.lang.Long.parseLong(strArrSplit[1]) - j7) + 1;
            j2 = j7;
        } else {
            j_renamed = j6;
            j2 = j5;
        }
        com.google.android.exoplayer2.source.dash.manifest.RangedUri initialization = singleSegmentBase != null ? singleSegmentBase.initialization : null;
        do {
            xmlPullParser.next();
            if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "Initialization")) {
                initialization = parseInitialization(xmlPullParser);
            } else {
                maybeSkipTag(xmlPullParser);
            }
        } while (!com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(xmlPullParser, "SegmentBase"));
        return buildSingleSegmentBase(initialization, j3, j4, j2, j_renamed);
    }

    protected com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SingleSegmentBase buildSingleSegmentBase(com.google.android.exoplayer2.source.dash.manifest.RangedUri rangedUri, long j_renamed, long j2, long j3, long j4) {
        return new com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SingleSegmentBase(rangedUri, j_renamed, j2, j3, j4);
    }

    protected com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentList parseSegmentList(org.xmlpull.v1.XmlPullParser xmlPullParser, com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentList segmentList) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        long j_renamed = parseLong(xmlPullParser, "timescale", segmentList != null ? segmentList.timescale : 1L);
        long j2 = parseLong(xmlPullParser, "presentationTimeOffset", segmentList != null ? segmentList.presentationTimeOffset : 0L);
        long j3 = parseLong(xmlPullParser, com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, segmentList != null ? segmentList.duration : -9223372036854775807L);
        long j4 = parseLong(xmlPullParser, "startNumber", segmentList != null ? segmentList.startNumber : 1L);
        java.util.List<com.google.android.exoplayer2.source.dash.manifest.RangedUri> arrayList = null;
        com.google.android.exoplayer2.source.dash.manifest.RangedUri initialization = null;
        java.util.List<com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTimelineElement> segmentTimeline = null;
        do {
            xmlPullParser.next();
            if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "Initialization")) {
                initialization = parseInitialization(xmlPullParser);
            } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentTimeline")) {
                segmentTimeline = parseSegmentTimeline(xmlPullParser);
            } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentURL")) {
                if (arrayList == null) {
                    arrayList = new java.util.ArrayList<>();
                }
                arrayList.add(parseSegmentUrl(xmlPullParser));
            } else {
                maybeSkipTag(xmlPullParser);
            }
        } while (!com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(xmlPullParser, "SegmentList"));
        if (segmentList != null) {
            if (initialization == null) {
                initialization = segmentList.initialization;
            }
            if (segmentTimeline == null) {
                segmentTimeline = segmentList.segmentTimeline;
            }
            if (arrayList == null) {
                arrayList = segmentList.mediaSegments;
            }
        }
        return buildSegmentList(initialization, j_renamed, j2, j4, j3, segmentTimeline, arrayList);
    }

    protected com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentList buildSegmentList(com.google.android.exoplayer2.source.dash.manifest.RangedUri rangedUri, long j_renamed, long j2, long j3, long j4, java.util.List<com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTimelineElement> list, java.util.List<com.google.android.exoplayer2.source.dash.manifest.RangedUri> list2) {
        return new com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentList(rangedUri, j_renamed, j2, j3, j4, list, list2);
    }

    protected com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTemplate parseSegmentTemplate(org.xmlpull.v1.XmlPullParser xmlPullParser, com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTemplate segmentTemplate) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        long j_renamed = parseLong(xmlPullParser, "timescale", segmentTemplate != null ? segmentTemplate.timescale : 1L);
        long j2 = parseLong(xmlPullParser, "presentationTimeOffset", segmentTemplate != null ? segmentTemplate.presentationTimeOffset : 0L);
        long j3 = parseLong(xmlPullParser, com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, segmentTemplate != null ? segmentTemplate.duration : -9223372036854775807L);
        long j4 = parseLong(xmlPullParser, "startNumber", segmentTemplate != null ? segmentTemplate.startNumber : 1L);
        com.google.android.exoplayer2.source.dash.manifest.RangedUri initialization = null;
        com.google.android.exoplayer2.source.dash.manifest.UrlTemplate urlTemplate = parseUrlTemplate(xmlPullParser, "media", segmentTemplate != null ? segmentTemplate.mediaTemplate : null);
        com.google.android.exoplayer2.source.dash.manifest.UrlTemplate urlTemplate2 = parseUrlTemplate(xmlPullParser, "initialization", segmentTemplate != null ? segmentTemplate.initializationTemplate : null);
        java.util.List<com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTimelineElement> segmentTimeline = null;
        do {
            xmlPullParser.next();
            if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "Initialization")) {
                initialization = parseInitialization(xmlPullParser);
            } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "SegmentTimeline")) {
                segmentTimeline = parseSegmentTimeline(xmlPullParser);
            } else {
                maybeSkipTag(xmlPullParser);
            }
        } while (!com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(xmlPullParser, "SegmentTemplate"));
        if (segmentTemplate != null) {
            if (initialization == null) {
                initialization = segmentTemplate.initialization;
            }
            if (segmentTimeline == null) {
                segmentTimeline = segmentTemplate.segmentTimeline;
            }
        }
        return buildSegmentTemplate(initialization, j_renamed, j2, j4, j3, segmentTimeline, urlTemplate2, urlTemplate);
    }

    protected com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTemplate buildSegmentTemplate(com.google.android.exoplayer2.source.dash.manifest.RangedUri rangedUri, long j_renamed, long j2, long j3, long j4, java.util.List<com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTimelineElement> list, com.google.android.exoplayer2.source.dash.manifest.UrlTemplate urlTemplate, com.google.android.exoplayer2.source.dash.manifest.UrlTemplate urlTemplate2) {
        return new com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTemplate(rangedUri, j_renamed, j2, j3, j4, list, urlTemplate, urlTemplate2);
    }

    protected com.google.android.exoplayer2.source.dash.manifest.EventStream parseEventStream(org.xmlpull.v1.XmlPullParser xmlPullParser) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        java.lang.String string = parseString(xmlPullParser, "schemeIdUri", "");
        java.lang.String string2 = parseString(xmlPullParser, com.android.providers.downloads.Downloads.Impl.RequestHeaders.COLUMN_VALUE, "");
        long j_renamed = parseLong(xmlPullParser, "timescale", 1L);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(512);
        do {
            xmlPullParser.next();
            if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "Event")) {
                arrayList.add(parseEvent(xmlPullParser, string, string2, j_renamed, byteArrayOutputStream));
            } else {
                maybeSkipTag(xmlPullParser);
            }
        } while (!com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(xmlPullParser, "EventStream"));
        long[] jArr = new long[arrayList.size()];
        com.google.android.exoplayer2.metadata.emsg.EventMessage[] eventMessageArr = new com.google.android.exoplayer2.metadata.emsg.EventMessage[arrayList.size()];
        for (int i_renamed = 0; i_renamed < arrayList.size(); i_renamed++) {
            android.util.Pair pair = (android.util.Pair) arrayList.get(i_renamed);
            jArr[i_renamed] = ((java.lang.Long) pair.first).longValue();
            eventMessageArr[i_renamed] = (com.google.android.exoplayer2.metadata.emsg.EventMessage) pair.second;
        }
        return buildEventStream(string, string2, j_renamed, jArr, eventMessageArr);
    }

    protected com.google.android.exoplayer2.source.dash.manifest.EventStream buildEventStream(java.lang.String str, java.lang.String str2, long j_renamed, long[] jArr, com.google.android.exoplayer2.metadata.emsg.EventMessage[] eventMessageArr) {
        return new com.google.android.exoplayer2.source.dash.manifest.EventStream(str, str2, j_renamed, jArr, eventMessageArr);
    }

    protected android.util.Pair<java.lang.Long, com.google.android.exoplayer2.metadata.emsg.EventMessage> parseEvent(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, java.lang.String str2, long j_renamed, java.io.ByteArrayOutputStream byteArrayOutputStream) throws org.xmlpull.v1.XmlPullParserException, java.lang.IllegalStateException, java.io.IOException, java.lang.IllegalArgumentException {
        long j2 = parseLong(xmlPullParser, com.google.android.exoplayer2.text.ttml.TtmlNode.ATTR_ID, 0L);
        long j3 = parseLong(xmlPullParser, com.oplus.tblplayer.ffmpeg.FFmpegMediaMetadataRetriever.METADATA_KEY_DURATION, -9223372036854775807L);
        long j4 = parseLong(xmlPullParser, "presentationTime", 0L);
        long jScaleLargeTimestamp = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(j3, 1000L, j_renamed);
        long jScaleLargeTimestamp2 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(j4, 1000000L, j_renamed);
        java.lang.String string = parseString(xmlPullParser, "messageData", null);
        byte[] eventObject = parseEventObject(xmlPullParser, byteArrayOutputStream);
        java.lang.Long lValueOf = java.lang.Long.valueOf(jScaleLargeTimestamp2);
        if (string != null) {
            eventObject = com.google.android.exoplayer2.util.Util.getUtf8Bytes(string);
        }
        return android.util.Pair.create(lValueOf, buildEvent(str, str2, j2, jScaleLargeTimestamp, eventObject));
    }

    protected byte[] parseEventObject(org.xmlpull.v1.XmlPullParser xmlPullParser, java.io.ByteArrayOutputStream byteArrayOutputStream) throws org.xmlpull.v1.XmlPullParserException, java.lang.IllegalStateException, java.io.IOException, java.lang.IllegalArgumentException {
        byteArrayOutputStream.reset();
        org.xmlpull.v1.XmlSerializer xmlSerializerNewSerializer = android.util.Xml.newSerializer();
        xmlSerializerNewSerializer.setOutput(byteArrayOutputStream, "UTF-8");
        xmlPullParser.nextToken();
        while (!com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(xmlPullParser, "Event")) {
            switch (xmlPullParser.getEventType()) {
                case 0:
                    xmlSerializerNewSerializer.startDocument(null, false);
                    break;
                case 1:
                    xmlSerializerNewSerializer.endDocument();
                    break;
                case 2:
                    xmlSerializerNewSerializer.startTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    for (int i_renamed = 0; i_renamed < xmlPullParser.getAttributeCount(); i_renamed++) {
                        xmlSerializerNewSerializer.attribute(xmlPullParser.getAttributeNamespace(i_renamed), xmlPullParser.getAttributeName(i_renamed), xmlPullParser.getAttributeValue(i_renamed));
                    }
                    break;
                case 3:
                    xmlSerializerNewSerializer.endTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    break;
                case 4:
                    xmlSerializerNewSerializer.text(xmlPullParser.getText());
                    break;
                case 5:
                    xmlSerializerNewSerializer.cdsect(xmlPullParser.getText());
                    break;
                case 6:
                    xmlSerializerNewSerializer.entityRef(xmlPullParser.getText());
                    break;
                case 7:
                    xmlSerializerNewSerializer.ignorableWhitespace(xmlPullParser.getText());
                    break;
                case 8:
                    xmlSerializerNewSerializer.processingInstruction(xmlPullParser.getText());
                    break;
                case 9:
                    xmlSerializerNewSerializer.comment(xmlPullParser.getText());
                    break;
                case 10:
                    xmlSerializerNewSerializer.docdecl(xmlPullParser.getText());
                    break;
            }
            xmlPullParser.nextToken();
        }
        xmlSerializerNewSerializer.flush();
        return byteArrayOutputStream.toByteArray();
    }

    protected com.google.android.exoplayer2.metadata.emsg.EventMessage buildEvent(java.lang.String str, java.lang.String str2, long j_renamed, long j2, byte[] bArr) {
        return new com.google.android.exoplayer2.metadata.emsg.EventMessage(str, str2, j2, j_renamed, bArr);
    }

    protected java.util.List<com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTimelineElement> parseSegmentTimeline(org.xmlpull.v1.XmlPullParser xmlPullParser) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        long j_renamed = 0;
        do {
            xmlPullParser.next();
            if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, com.oplus.exif.OplusExifInterface.GpsLatitudeRef.SOUTH)) {
                j_renamed = parseLong(xmlPullParser, "t_renamed", j_renamed);
                long j2 = parseLong(xmlPullParser, "d_renamed", -9223372036854775807L);
                int i_renamed = parseInt(xmlPullParser, "r_renamed", 0) + 1;
                for (int i2 = 0; i2 < i_renamed; i2++) {
                    arrayList.add(buildSegmentTimelineElement(j_renamed, j2));
                    j_renamed += j2;
                }
            } else {
                maybeSkipTag(xmlPullParser);
            }
        } while (!com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(xmlPullParser, "SegmentTimeline"));
        return arrayList;
    }

    protected com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTimelineElement buildSegmentTimelineElement(long j_renamed, long j2) {
        return new com.google.android.exoplayer2.source.dash.manifest.SegmentBase.SegmentTimelineElement(j_renamed, j2);
    }

    protected com.google.android.exoplayer2.source.dash.manifest.UrlTemplate parseUrlTemplate(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, com.google.android.exoplayer2.source.dash.manifest.UrlTemplate urlTemplate) {
        java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue != null ? com.google.android.exoplayer2.source.dash.manifest.UrlTemplate.compile(attributeValue) : urlTemplate;
    }

    protected com.google.android.exoplayer2.source.dash.manifest.RangedUri parseInitialization(org.xmlpull.v1.XmlPullParser xmlPullParser) {
        return parseRangedUrl(xmlPullParser, "sourceURL", "range");
    }

    protected com.google.android.exoplayer2.source.dash.manifest.RangedUri parseSegmentUrl(org.xmlpull.v1.XmlPullParser xmlPullParser) {
        return parseRangedUrl(xmlPullParser, "media", "mediaRange");
    }

    protected com.google.android.exoplayer2.source.dash.manifest.RangedUri parseRangedUrl(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, java.lang.String str2) throws java.lang.NumberFormatException {
        long j_renamed;
        long j2;
        java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, str);
        java.lang.String attributeValue2 = xmlPullParser.getAttributeValue(null, str2);
        if (attributeValue2 != null) {
            java.lang.String[] strArrSplit = attributeValue2.split("-");
            j_renamed = java.lang.Long.parseLong(strArrSplit[0]);
            if (strArrSplit.length == 2) {
                j2 = (java.lang.Long.parseLong(strArrSplit[1]) - j_renamed) + 1;
            }
            return buildRangedUri(attributeValue, j_renamed, j2);
        }
        j_renamed = 0;
        j2 = -1;
        return buildRangedUri(attributeValue, j_renamed, j2);
    }

    protected com.google.android.exoplayer2.source.dash.manifest.RangedUri buildRangedUri(java.lang.String str, long j_renamed, long j2) {
        return new com.google.android.exoplayer2.source.dash.manifest.RangedUri(str, j_renamed, j2);
    }

    protected com.google.android.exoplayer2.source.dash.manifest.ProgramInformation parseProgramInformation(org.xmlpull.v1.XmlPullParser xmlPullParser) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        java.lang.String strNextText = null;
        java.lang.String string = parseString(xmlPullParser, "moreInformationURL", null);
        java.lang.String string2 = parseString(xmlPullParser, "lang", null);
        java.lang.String strNextText2 = null;
        java.lang.String strNextText3 = null;
        while (true) {
            xmlPullParser.next();
            if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "Title")) {
                strNextText = xmlPullParser.nextText();
            } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "Source")) {
                strNextText2 = xmlPullParser.nextText();
            } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "Copyright")) {
                strNextText3 = xmlPullParser.nextText();
            } else {
                maybeSkipTag(xmlPullParser);
            }
            java.lang.String str = strNextText3;
            if (com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(xmlPullParser, "ProgramInformation")) {
                return new com.google.android.exoplayer2.source.dash.manifest.ProgramInformation(strNextText, strNextText2, str, string, string2);
            }
            strNextText3 = str;
        }
    }

    protected int parseAudioChannelConfiguration(org.xmlpull.v1.XmlPullParser xmlPullParser) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        java.lang.String string = parseString(xmlPullParser, "schemeIdUri", null);
        int dolbyChannelConfiguration = -1;
        if ("urn:mpeg:dash:23003:3:audio_channel_configuration:2011".equals(string)) {
            dolbyChannelConfiguration = parseInt(xmlPullParser, com.android.providers.downloads.Downloads.Impl.RequestHeaders.COLUMN_VALUE, -1);
        } else if ("tag:dolby.com,2014:dash:audio_channel_configuration:2011".equals(string)) {
            dolbyChannelConfiguration = parseDolbyChannelConfiguration(xmlPullParser);
        }
        do {
            xmlPullParser.next();
        } while (!com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(xmlPullParser, "AudioChannelConfiguration"));
        return dolbyChannelConfiguration;
    }

    public static void maybeSkipTag(org.xmlpull.v1.XmlPullParser xmlPullParser) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser)) {
            int i_renamed = 1;
            while (i_renamed != 0) {
                xmlPullParser.next();
                if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser)) {
                    i_renamed++;
                } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(xmlPullParser)) {
                    i_renamed--;
                }
            }
        }
    }

    private static void filterRedundantIncompleteSchemeDatas(java.util.ArrayList<com.google.android.exoplayer2.drm.DrmInitData.SchemeData> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            com.google.android.exoplayer2.drm.DrmInitData.SchemeData schemeData = arrayList.get(size);
            if (!schemeData.hasData()) {
                int i_renamed = 0;
                while (true) {
                    if (i_renamed >= arrayList.size()) {
                        break;
                    }
                    if (arrayList.get(i_renamed).canReplace(schemeData)) {
                        arrayList.remove(size);
                        break;
                    }
                    i_renamed++;
                }
            }
        }
    }

    private static java.lang.String getSampleMimeType(java.lang.String str, java.lang.String str2) {
        if (com.google.android.exoplayer2.util.MimeTypes.isAudio(str)) {
            return com.google.android.exoplayer2.util.MimeTypes.getAudioMediaMimeType(str2);
        }
        if (com.google.android.exoplayer2.util.MimeTypes.isVideo(str)) {
            return com.google.android.exoplayer2.util.MimeTypes.getVideoMediaMimeType(str2);
        }
        if (mimeTypeIsRawText(str)) {
            return str;
        }
        if (com.google.android.exoplayer2.util.MimeTypes.APPLICATION_MP4.equals(str)) {
            if (str2 != null) {
                if (str2.startsWith("stpp")) {
                    return com.google.android.exoplayer2.util.MimeTypes.APPLICATION_TTML;
                }
                if (str2.startsWith("wvtt")) {
                    return com.google.android.exoplayer2.util.MimeTypes.APPLICATION_MP4VTT;
                }
            }
        } else if (com.google.android.exoplayer2.util.MimeTypes.APPLICATION_RAWCC.equals(str) && str2 != null) {
            if (str2.contains("cea708")) {
                return com.google.android.exoplayer2.util.MimeTypes.APPLICATION_CEA708;
            }
            if (str2.contains("eia608") || str2.contains("cea608")) {
                return com.google.android.exoplayer2.util.MimeTypes.APPLICATION_CEA608;
            }
        }
        return null;
    }

    private static boolean mimeTypeIsRawText(java.lang.String str) {
        return com.google.android.exoplayer2.util.MimeTypes.isText(str) || com.google.android.exoplayer2.util.MimeTypes.APPLICATION_TTML.equals(str) || com.google.android.exoplayer2.util.MimeTypes.APPLICATION_MP4VTT.equals(str) || com.google.android.exoplayer2.util.MimeTypes.APPLICATION_CEA708.equals(str) || com.google.android.exoplayer2.util.MimeTypes.APPLICATION_CEA608.equals(str);
    }

    private static java.lang.String checkLanguageConsistency(java.lang.String str, java.lang.String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        com.google.android.exoplayer2.util.Assertions.checkState(str.equals(str2));
        return str;
    }

    private static int checkContentTypeConsistency(int i_renamed, int i2) {
        if (i_renamed == -1) {
            return i2;
        }
        if (i2 == -1) {
            return i_renamed;
        }
        com.google.android.exoplayer2.util.Assertions.checkState(i_renamed == i2);
        return i_renamed;
    }

    protected static com.google.android.exoplayer2.source.dash.manifest.Descriptor parseDescriptor(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        java.lang.String string = parseString(xmlPullParser, "schemeIdUri", "");
        java.lang.String string2 = parseString(xmlPullParser, com.android.providers.downloads.Downloads.Impl.RequestHeaders.COLUMN_VALUE, null);
        java.lang.String string3 = parseString(xmlPullParser, com.google.android.exoplayer2.text.ttml.TtmlNode.ATTR_ID, null);
        do {
            xmlPullParser.next();
        } while (!com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(xmlPullParser, str));
        return new com.google.android.exoplayer2.source.dash.manifest.Descriptor(string, string2, string3);
    }

    protected static int parseCea608AccessibilityChannel(java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list) {
        for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
            com.google.android.exoplayer2.source.dash.manifest.Descriptor descriptor = list.get(i_renamed);
            if ("urn:scte:dash:cc_renamed:cea-608:2015".equals(descriptor.schemeIdUri) && descriptor.value != null) {
                java.util.regex.Matcher matcher = CEA_608_ACCESSIBILITY_PATTERN.matcher(descriptor.value);
                if (matcher.matches()) {
                    return java.lang.Integer.parseInt(matcher.group(1));
                }
                com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Unable to parse CEA-608 channel number from: " + descriptor.value);
            }
        }
        return -1;
    }

    protected static int parseCea708AccessibilityChannel(java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list) {
        for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
            com.google.android.exoplayer2.source.dash.manifest.Descriptor descriptor = list.get(i_renamed);
            if ("urn:scte:dash:cc_renamed:cea-708:2015".equals(descriptor.schemeIdUri) && descriptor.value != null) {
                java.util.regex.Matcher matcher = CEA_708_ACCESSIBILITY_PATTERN.matcher(descriptor.value);
                if (matcher.matches()) {
                    return java.lang.Integer.parseInt(matcher.group(1));
                }
                com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Unable to parse CEA-708 service block number from: " + descriptor.value);
            }
        }
        return -1;
    }

    protected static java.lang.String parseEac3SupplementalProperties(java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list) {
        for (int i_renamed = 0; i_renamed < list.size(); i_renamed++) {
            com.google.android.exoplayer2.source.dash.manifest.Descriptor descriptor = list.get(i_renamed);
            if ("tag:dolby.com,2014:dash:DolbyDigitalPlusExtensionType:2014".equals(descriptor.schemeIdUri) && "ec_renamed+3".equals(descriptor.value)) {
                return com.google.android.exoplayer2.util.MimeTypes.AUDIO_E_AC3_JOC;
            }
        }
        return com.google.android.exoplayer2.util.MimeTypes.AUDIO_E_AC3;
    }

    protected static float parseFrameRate(org.xmlpull.v1.XmlPullParser xmlPullParser, float f_renamed) throws java.lang.NumberFormatException {
        java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, "frameRate");
        if (attributeValue == null) {
            return f_renamed;
        }
        java.util.regex.Matcher matcher = FRAME_RATE_PATTERN.matcher(attributeValue);
        if (!matcher.matches()) {
            return f_renamed;
        }
        int i_renamed = java.lang.Integer.parseInt(matcher.group(1));
        return !android.text.TextUtils.isEmpty(matcher.group(2)) ? i_renamed / java.lang.Integer.parseInt(r2) : i_renamed;
    }

    protected static long parseDuration(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, long j_renamed) {
        java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j_renamed : com.google.android.exoplayer2.util.Util.parseXsDuration(attributeValue);
    }

    protected static long parseDateTime(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, long j_renamed) throws com.google.android.exoplayer2.ParserException {
        java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j_renamed : com.google.android.exoplayer2.util.Util.parseXsDateTime(attributeValue);
    }

    protected static java.lang.String parseBaseUrl(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        xmlPullParser.next();
        return com.google.android.exoplayer2.util.UriUtil.resolve(str, xmlPullParser.getText());
    }

    protected static int parseInt(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, int i_renamed) {
        java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? i_renamed : java.lang.Integer.parseInt(attributeValue);
    }

    protected static long parseLong(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, long j_renamed) {
        java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j_renamed : java.lang.Long.parseLong(attributeValue);
    }

    protected static java.lang.String parseString(org.xmlpull.v1.XmlPullParser xmlPullParser, java.lang.String str, java.lang.String str2) {
        java.lang.String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? str2 : attributeValue;
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as_renamed a_renamed decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B_renamed:20:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected static int parseDolbyChannelConfiguration(org.xmlpull.v1.XmlPullParser r5) {
        /*
            r0 = 0
            java.lang.String r1 = "value"
            java.lang.String r5 = r5.getAttributeValue(r0, r1)
            java.lang.String r5 = com.google.android.exoplayer2.util.Util.toLowerInvariant(r5)
            r0 = -1
            if (r5 != 0) goto Lf
            return r0
        Lf:
            int r1 = r5.hashCode()
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r1) {
                case 1596796: goto L38;
                case 2937391: goto L2e;
                case 3094035: goto L24;
                case 3133436: goto L1a;
                default: goto L19;
            }
        L19:
            goto L42
        L1a:
            java.lang.String r1 = "fa01"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L42
            r5 = r2
            goto L43
        L24:
            java.lang.String r1 = "f801"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L42
            r5 = r3
            goto L43
        L2e:
            java.lang.String r1 = "a000"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L42
            r5 = r4
            goto L43
        L38:
            java.lang.String r1 = "4000"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L42
            r5 = 0
            goto L43
        L42:
            r5 = r0
        L43:
            if (r5 == 0) goto L52
            if (r5 == r4) goto L51
            if (r5 == r3) goto L4f
            if (r5 == r2) goto L4c
            return r0
        L4c:
            r5 = 8
            return r5
        L4f:
            r5 = 6
            return r5
        L51:
            return r3
        L52:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.manifest.DashManifestParser.parseDolbyChannelConfiguration(org.xmlpull.v1.XmlPullParser):int");
    }

    protected static final class RepresentationInfo {
        public final java.lang.String baseUrl;
        public final java.util.ArrayList<com.google.android.exoplayer2.drm.DrmInitData.SchemeData> drmSchemeDatas;
        public final java.lang.String drmSchemeType;
        public final com.google.android.exoplayer2.Format format;
        public final java.util.ArrayList<com.google.android.exoplayer2.source.dash.manifest.Descriptor> inbandEventStreams;
        public final long revisionId;
        public final com.google.android.exoplayer2.source.dash.manifest.SegmentBase segmentBase;

        public RepresentationInfo(com.google.android.exoplayer2.Format format, java.lang.String str, com.google.android.exoplayer2.source.dash.manifest.SegmentBase segmentBase, java.lang.String str2, java.util.ArrayList<com.google.android.exoplayer2.drm.DrmInitData.SchemeData> arrayList, java.util.ArrayList<com.google.android.exoplayer2.source.dash.manifest.Descriptor> arrayList2, long j_renamed) {
            this.format = format;
            this.baseUrl = str;
            this.segmentBase = segmentBase;
            this.drmSchemeType = str2;
            this.drmSchemeDatas = arrayList;
            this.inbandEventStreams = arrayList2;
            this.revisionId = j_renamed;
        }
    }
}
