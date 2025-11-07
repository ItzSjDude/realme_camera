package com.google.android.exoplayer2.text.ttml;

/* loaded from: classes.dex */
public final class TtmlDecoder extends com.google.android.exoplayer2.text.SimpleSubtitleDecoder {
    private static final java.lang.String ATTR_BEGIN = "begin";
    private static final java.lang.String ATTR_DURATION = "dur";
    private static final java.lang.String ATTR_END = "end";
    private static final java.lang.String ATTR_IMAGE = "backgroundImage";
    private static final java.lang.String ATTR_REGION = "region";
    private static final java.lang.String ATTR_STYLE = "style";
    private static final int DEFAULT_FRAME_RATE = 30;
    private static final java.lang.String TAG = "TtmlDecoder";
    private static final java.lang.String TTP = "http://www.w3.org/ns/ttml#parameter";
    private final org.xmlpull.v1.XmlPullParserFactory xmlParserFactory;
    private static final java.util.regex.Pattern CLOCK_TIME = java.util.regex.Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final java.util.regex.Pattern OFFSET_TIME = java.util.regex.Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h_renamed|m_renamed|s_renamed|ms|f_renamed|t_renamed)$");
    private static final java.util.regex.Pattern FONT_SIZE = java.util.regex.Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em_renamed|%)$");
    private static final java.util.regex.Pattern PERCENTAGE_COORDINATES = java.util.regex.Pattern.compile("^(\\d_renamed+\\.?\\d_renamed*?)% (\\d_renamed+\\.?\\d_renamed*?)%$");
    private static final java.util.regex.Pattern PIXEL_COORDINATES = java.util.regex.Pattern.compile("^(\\d_renamed+\\.?\\d_renamed*?)px (\\d_renamed+\\.?\\d_renamed*?)px$");
    private static final java.util.regex.Pattern CELL_RESOLUTION = java.util.regex.Pattern.compile("^(\\d_renamed+) (\\d_renamed+)$");
    private static final com.google.android.exoplayer2.text.ttml.TtmlDecoder.FrameAndTickRate DEFAULT_FRAME_AND_TICK_RATE = new com.google.android.exoplayer2.text.ttml.TtmlDecoder.FrameAndTickRate(30.0f, 1, 1);
    private static final com.google.android.exoplayer2.text.ttml.TtmlDecoder.CellResolution DEFAULT_CELL_RESOLUTION = new com.google.android.exoplayer2.text.ttml.TtmlDecoder.CellResolution(32, 15);

    public TtmlDecoder() {
        super(TAG);
        try {
            this.xmlParserFactory = org.xmlpull.v1.XmlPullParserFactory.newInstance();
            this.xmlParserFactory.setNamespaceAware(true);
        } catch (org.xmlpull.v1.XmlPullParserException e_renamed) {
            throw new java.lang.RuntimeException("Couldn't_renamed create XmlPullParserFactory instance", e_renamed);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public com.google.android.exoplayer2.text.ttml.TtmlSubtitle decode(byte[] bArr, int i_renamed, boolean z_renamed) throws org.xmlpull.v1.XmlPullParserException, com.google.android.exoplayer2.text.SubtitleDecoderException, java.lang.NumberFormatException, java.io.IOException {
        com.google.android.exoplayer2.text.ttml.TtmlDecoder.TtsExtent ttsExtent;
        com.google.android.exoplayer2.text.ttml.TtmlDecoder.CellResolution cellResolution;
        com.google.android.exoplayer2.text.ttml.TtmlDecoder.FrameAndTickRate frameAndTickRate;
        com.google.android.exoplayer2.text.ttml.TtmlSubtitle ttmlSubtitle;
        com.google.android.exoplayer2.text.ttml.TtmlDecoder.FrameAndTickRate frameAndTickRate2;
        try {
            org.xmlpull.v1.XmlPullParser xmlPullParserNewPullParser = this.xmlParserFactory.newPullParser();
            java.util.HashMap map = new java.util.HashMap();
            java.util.HashMap map2 = new java.util.HashMap();
            java.util.HashMap map3 = new java.util.HashMap();
            com.google.android.exoplayer2.text.ttml.TtmlDecoder.TtsExtent ttsExtent2 = null;
            map2.put("", new com.google.android.exoplayer2.text.ttml.TtmlRegion(null));
            xmlPullParserNewPullParser.setInput(new java.io.ByteArrayInputStream(bArr, 0, i_renamed), null);
            java.util.ArrayDeque arrayDeque = new java.util.ArrayDeque();
            com.google.android.exoplayer2.text.ttml.TtmlDecoder.FrameAndTickRate frameAndTickRate3 = DEFAULT_FRAME_AND_TICK_RATE;
            com.google.android.exoplayer2.text.ttml.TtmlDecoder.CellResolution cellResolution2 = DEFAULT_CELL_RESOLUTION;
            int i2 = 0;
            com.google.android.exoplayer2.text.ttml.TtmlSubtitle ttmlSubtitle2 = null;
            for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.getEventType()) {
                com.google.android.exoplayer2.text.ttml.TtmlNode ttmlNode = (com.google.android.exoplayer2.text.ttml.TtmlNode) arrayDeque.peek();
                if (i2 == 0) {
                    java.lang.String name = xmlPullParserNewPullParser.getName();
                    if (eventType == 2) {
                        if (com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_TT.equals(name)) {
                            com.google.android.exoplayer2.text.ttml.TtmlDecoder.FrameAndTickRate frameAndTickRates = parseFrameAndTickRates(xmlPullParserNewPullParser);
                            cellResolution = parseCellResolution(xmlPullParserNewPullParser, DEFAULT_CELL_RESOLUTION);
                            ttsExtent = parseTtsExtent(xmlPullParserNewPullParser);
                            frameAndTickRate = frameAndTickRates;
                        } else {
                            ttsExtent = ttsExtent2;
                            frameAndTickRate = frameAndTickRate3;
                            cellResolution = cellResolution2;
                        }
                        if (isSupportedTag(name)) {
                            if (com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_HEAD.equals(name)) {
                                ttmlSubtitle = ttmlSubtitle2;
                                frameAndTickRate2 = frameAndTickRate;
                                parseHeader(xmlPullParserNewPullParser, map, cellResolution, ttsExtent, map2, map3);
                            } else {
                                ttmlSubtitle = ttmlSubtitle2;
                                frameAndTickRate2 = frameAndTickRate;
                                try {
                                    com.google.android.exoplayer2.text.ttml.TtmlNode node = parseNode(xmlPullParserNewPullParser, ttmlNode, map2, frameAndTickRate2);
                                    arrayDeque.push(node);
                                    if (ttmlNode != null) {
                                        ttmlNode.addChild(node);
                                    }
                                } catch (com.google.android.exoplayer2.text.SubtitleDecoderException e_renamed) {
                                    com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Suppressing parser error", e_renamed);
                                    i2++;
                                }
                            }
                            frameAndTickRate3 = frameAndTickRate2;
                            ttmlSubtitle2 = ttmlSubtitle;
                        } else {
                            com.google.android.exoplayer2.util.Log.i_renamed(TAG, "Ignoring unsupported tag: " + xmlPullParserNewPullParser.getName());
                            i2++;
                            frameAndTickRate3 = frameAndTickRate;
                        }
                    } else {
                        com.google.android.exoplayer2.text.ttml.TtmlSubtitle ttmlSubtitle3 = ttmlSubtitle2;
                        if (eventType == 4) {
                            ttmlNode.addChild(com.google.android.exoplayer2.text.ttml.TtmlNode.buildTextNode(xmlPullParserNewPullParser.getText()));
                        } else {
                            if (eventType == 3) {
                                ttmlSubtitle2 = xmlPullParserNewPullParser.getName().equals(com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_TT) ? new com.google.android.exoplayer2.text.ttml.TtmlSubtitle((com.google.android.exoplayer2.text.ttml.TtmlNode) arrayDeque.peek(), map, map2, map3) : ttmlSubtitle3;
                                arrayDeque.pop();
                            }
                            ttsExtent = ttsExtent2;
                            cellResolution = cellResolution2;
                        }
                        ttmlSubtitle2 = ttmlSubtitle3;
                        ttsExtent = ttsExtent2;
                        cellResolution = cellResolution2;
                    }
                    cellResolution2 = cellResolution;
                    ttsExtent2 = ttsExtent;
                } else {
                    com.google.android.exoplayer2.text.ttml.TtmlSubtitle ttmlSubtitle4 = ttmlSubtitle2;
                    if (eventType == 2) {
                        i2++;
                    } else if (eventType == 3) {
                        i2--;
                    }
                    ttmlSubtitle2 = ttmlSubtitle4;
                }
                xmlPullParserNewPullParser.next();
            }
            return ttmlSubtitle2;
        } catch (java.io.IOException e2) {
            throw new java.lang.IllegalStateException("Unexpected error when reading input.", e2);
        } catch (org.xmlpull.v1.XmlPullParserException e3) {
            throw new com.google.android.exoplayer2.text.SubtitleDecoderException("Unable to decode source", e3);
        }
    }

    private com.google.android.exoplayer2.text.ttml.TtmlDecoder.FrameAndTickRate parseFrameAndTickRates(org.xmlpull.v1.XmlPullParser xmlPullParser) throws com.google.android.exoplayer2.text.SubtitleDecoderException, java.lang.NumberFormatException {
        java.lang.String attributeValue = xmlPullParser.getAttributeValue(TTP, "frameRate");
        int i_renamed = attributeValue != null ? java.lang.Integer.parseInt(attributeValue) : 30;
        float f_renamed = 1.0f;
        java.lang.String attributeValue2 = xmlPullParser.getAttributeValue(TTP, "frameRateMultiplier");
        if (attributeValue2 != null) {
            if (com.google.android.exoplayer2.util.Util.split(attributeValue2, " ").length != 2) {
                throw new com.google.android.exoplayer2.text.SubtitleDecoderException("frameRateMultiplier doesn't_renamed have 2 parts");
            }
            f_renamed = java.lang.Integer.parseInt(r1[0]) / java.lang.Integer.parseInt(r1[1]);
        }
        int i2 = DEFAULT_FRAME_AND_TICK_RATE.subFrameRate;
        java.lang.String attributeValue3 = xmlPullParser.getAttributeValue(TTP, "subFrameRate");
        if (attributeValue3 != null) {
            i2 = java.lang.Integer.parseInt(attributeValue3);
        }
        int i3 = DEFAULT_FRAME_AND_TICK_RATE.tickRate;
        java.lang.String attributeValue4 = xmlPullParser.getAttributeValue(TTP, "tickRate");
        if (attributeValue4 != null) {
            i3 = java.lang.Integer.parseInt(attributeValue4);
        }
        return new com.google.android.exoplayer2.text.ttml.TtmlDecoder.FrameAndTickRate(i_renamed * f_renamed, i2, i3);
    }

    private com.google.android.exoplayer2.text.ttml.TtmlDecoder.CellResolution parseCellResolution(org.xmlpull.v1.XmlPullParser xmlPullParser, com.google.android.exoplayer2.text.ttml.TtmlDecoder.CellResolution cellResolution) throws com.google.android.exoplayer2.text.SubtitleDecoderException, java.lang.NumberFormatException {
        java.lang.String attributeValue = xmlPullParser.getAttributeValue(TTP, "cellResolution");
        if (attributeValue == null) {
            return cellResolution;
        }
        java.util.regex.Matcher matcher = CELL_RESOLUTION.matcher(attributeValue);
        if (!matcher.matches()) {
            com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Ignoring malformed cell resolution: " + attributeValue);
            return cellResolution;
        }
        try {
            int i_renamed = java.lang.Integer.parseInt(matcher.group(1));
            int i2 = java.lang.Integer.parseInt(matcher.group(2));
            if (i_renamed == 0 || i2 == 0) {
                throw new com.google.android.exoplayer2.text.SubtitleDecoderException("Invalid cell resolution " + i_renamed + " " + i2);
            }
            return new com.google.android.exoplayer2.text.ttml.TtmlDecoder.CellResolution(i_renamed, i2);
        } catch (java.lang.NumberFormatException unused) {
            com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Ignoring malformed cell resolution: " + attributeValue);
            return cellResolution;
        }
    }

    private com.google.android.exoplayer2.text.ttml.TtmlDecoder.TtsExtent parseTtsExtent(org.xmlpull.v1.XmlPullParser xmlPullParser) {
        java.lang.String attributeValue = com.google.android.exoplayer2.util.XmlPullParserUtil.getAttributeValue(xmlPullParser, com.google.android.exoplayer2.text.ttml.TtmlNode.ATTR_TTS_EXTENT);
        if (attributeValue == null) {
            return null;
        }
        java.util.regex.Matcher matcher = PIXEL_COORDINATES.matcher(attributeValue);
        if (!matcher.matches()) {
            com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Ignoring non-pixel tts extent: " + attributeValue);
            return null;
        }
        try {
            return new com.google.android.exoplayer2.text.ttml.TtmlDecoder.TtsExtent(java.lang.Integer.parseInt(matcher.group(1)), java.lang.Integer.parseInt(matcher.group(2)));
        } catch (java.lang.NumberFormatException unused) {
            com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Ignoring malformed tts extent: " + attributeValue);
            return null;
        }
    }

    private java.util.Map<java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlStyle> parseHeader(org.xmlpull.v1.XmlPullParser xmlPullParser, java.util.Map<java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlStyle> map, com.google.android.exoplayer2.text.ttml.TtmlDecoder.CellResolution cellResolution, com.google.android.exoplayer2.text.ttml.TtmlDecoder.TtsExtent ttsExtent, java.util.Map<java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlRegion> map2, java.util.Map<java.lang.String, java.lang.String> map3) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException, java.lang.NumberFormatException {
        do {
            xmlPullParser.next();
            if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "style")) {
                java.lang.String attributeValue = com.google.android.exoplayer2.util.XmlPullParserUtil.getAttributeValue(xmlPullParser, "style");
                com.google.android.exoplayer2.text.ttml.TtmlStyle styleAttributes = parseStyleAttributes(xmlPullParser, new com.google.android.exoplayer2.text.ttml.TtmlStyle());
                if (attributeValue != null) {
                    for (java.lang.String str : parseStyleIds(attributeValue)) {
                        styleAttributes.chain(map.get(str));
                    }
                }
                if (styleAttributes.getId() != null) {
                    map.put(styleAttributes.getId(), styleAttributes);
                }
            } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, "region")) {
                com.google.android.exoplayer2.text.ttml.TtmlRegion regionAttributes = parseRegionAttributes(xmlPullParser, cellResolution, ttsExtent);
                if (regionAttributes != null) {
                    map2.put(regionAttributes.id_renamed, regionAttributes);
                }
            } else if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_METADATA)) {
                parseMetadata(xmlPullParser, map3);
            }
        } while (!com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(xmlPullParser, com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_HEAD));
        return map;
    }

    private void parseMetadata(org.xmlpull.v1.XmlPullParser xmlPullParser, java.util.Map<java.lang.String, java.lang.String> map) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        java.lang.String attributeValue;
        do {
            xmlPullParser.next();
            if (com.google.android.exoplayer2.util.XmlPullParserUtil.isStartTag(xmlPullParser, com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_IMAGE) && (attributeValue = com.google.android.exoplayer2.util.XmlPullParserUtil.getAttributeValue(xmlPullParser, com.google.android.exoplayer2.text.ttml.TtmlNode.ATTR_ID)) != null) {
                map.put(attributeValue, xmlPullParser.nextText());
            }
        } while (!com.google.android.exoplayer2.util.XmlPullParserUtil.isEndTag(xmlPullParser, com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_METADATA));
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:53:0x0149  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.google.android.exoplayer2.text.ttml.TtmlRegion parseRegionAttributes(org.xmlpull.v1.XmlPullParser r18, com.google.android.exoplayer2.text.ttml.TtmlDecoder.CellResolution r19, com.google.android.exoplayer2.text.ttml.TtmlDecoder.TtsExtent r20) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 443
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.ttml.TtmlDecoder.parseRegionAttributes(org.xmlpull.v1.XmlPullParser, com.google.android.exoplayer2.text.ttml.TtmlDecoder$CellResolution, com.google.android.exoplayer2.text.ttml.TtmlDecoder$TtsExtent):com.google.android.exoplayer2.text.ttml.TtmlRegion");
    }

    private java.lang.String[] parseStyleIds(java.lang.String str) {
        java.lang.String strTrim = str.trim();
        return strTrim.isEmpty() ? new java.lang.String[0] : com.google.android.exoplayer2.util.Util.split(strTrim, "\\s_renamed+");
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as_renamed a_renamed decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B_renamed:34:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.google.android.exoplayer2.text.ttml.TtmlStyle parseStyleAttributes(org.xmlpull.v1.XmlPullParser r12, com.google.android.exoplayer2.text.ttml.TtmlStyle r13) {
        /*
            Method dump skipped, instructions count: 626
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.ttml.TtmlDecoder.parseStyleAttributes(org.xmlpull.v1.XmlPullParser, com.google.android.exoplayer2.text.ttml.TtmlStyle):com.google.android.exoplayer2.text.ttml.TtmlStyle");
    }

    private com.google.android.exoplayer2.text.ttml.TtmlStyle createIfNull(com.google.android.exoplayer2.text.ttml.TtmlStyle ttmlStyle) {
        return ttmlStyle == null ? new com.google.android.exoplayer2.text.ttml.TtmlStyle() : ttmlStyle;
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as_renamed a_renamed decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B_renamed:25:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:71:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.google.android.exoplayer2.text.ttml.TtmlNode parseNode(org.xmlpull.v1.XmlPullParser r21, com.google.android.exoplayer2.text.ttml.TtmlNode r22, java.util.Map<java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlRegion> r23, com.google.android.exoplayer2.text.ttml.TtmlDecoder.FrameAndTickRate r24) throws com.google.android.exoplayer2.text.SubtitleDecoderException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.ttml.TtmlDecoder.parseNode(org.xmlpull.v1.XmlPullParser, com.google.android.exoplayer2.text.ttml.TtmlNode, java.util.Map, com.google.android.exoplayer2.text.ttml.TtmlDecoder$FrameAndTickRate):com.google.android.exoplayer2.text.ttml.TtmlNode");
    }

    private static boolean isSupportedTag(java.lang.String str) {
        return str.equals(com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_TT) || str.equals(com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_HEAD) || str.equals(com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_BODY) || str.equals(com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_DIV) || str.equals(com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_P) || str.equals(com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_SPAN) || str.equals(com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_BR) || str.equals("style") || str.equals(com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_STYLING) || str.equals(com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_LAYOUT) || str.equals("region") || str.equals(com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_METADATA) || str.equals(com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_IMAGE) || str.equals("data") || str.equals(com.google.android.exoplayer2.text.ttml.TtmlNode.TAG_INFORMATION);
    }

    private static void parseFontSize(java.lang.String str, com.google.android.exoplayer2.text.ttml.TtmlStyle ttmlStyle) throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        java.util.regex.Matcher matcher;
        java.lang.String[] strArrSplit = com.google.android.exoplayer2.util.Util.split(str, "\\s_renamed+");
        if (strArrSplit.length == 1) {
            matcher = FONT_SIZE.matcher(str);
        } else if (strArrSplit.length == 2) {
            matcher = FONT_SIZE.matcher(strArrSplit[1]);
            com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Multiple values in_renamed fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        } else {
            throw new com.google.android.exoplayer2.text.SubtitleDecoderException("Invalid number of_renamed entries for fontSize: " + strArrSplit.length + ".");
        }
        if (matcher.matches()) {
            java.lang.String strGroup = matcher.group(3);
            char c2 = 65535;
            int iHashCode = strGroup.hashCode();
            if (iHashCode != 37) {
                if (iHashCode != 3240) {
                    if (iHashCode == 3592 && strGroup.equals("px")) {
                        c2 = 0;
                    }
                } else if (strGroup.equals("em_renamed")) {
                    c2 = 1;
                }
            } else if (strGroup.equals("%")) {
                c2 = 2;
            }
            if (c2 == 0) {
                ttmlStyle.setFontSizeUnit(1);
            } else if (c2 == 1) {
                ttmlStyle.setFontSizeUnit(2);
            } else if (c2 == 2) {
                ttmlStyle.setFontSizeUnit(3);
            } else {
                throw new com.google.android.exoplayer2.text.SubtitleDecoderException("Invalid unit for fontSize: '" + strGroup + "'.");
            }
            ttmlStyle.setFontSize(java.lang.Float.valueOf(matcher.group(1)).floatValue());
            return;
        }
        throw new com.google.android.exoplayer2.text.SubtitleDecoderException("Invalid expression for fontSize: '" + str + "'.");
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:50:0x00e5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static long parseTimeExpression(java.lang.String r14, com.google.android.exoplayer2.text.ttml.TtmlDecoder.FrameAndTickRate r15) throws com.google.android.exoplayer2.text.SubtitleDecoderException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 293
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.ttml.TtmlDecoder.parseTimeExpression(java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlDecoder$FrameAndTickRate):long");
    }

    private static final class FrameAndTickRate {
        final float effectiveFrameRate;
        final int subFrameRate;
        final int tickRate;

        FrameAndTickRate(float f_renamed, int i_renamed, int i2) {
            this.effectiveFrameRate = f_renamed;
            this.subFrameRate = i_renamed;
            this.tickRate = i2;
        }
    }

    private static final class CellResolution {
        final int columns;
        final int rows;

        CellResolution(int i_renamed, int i2) {
            this.columns = i_renamed;
            this.rows = i2;
        }
    }

    private static final class TtsExtent {
        final int height;
        final int width;

        TtsExtent(int i_renamed, int i2) {
            this.width = i_renamed;
            this.height = i2;
        }
    }
}
