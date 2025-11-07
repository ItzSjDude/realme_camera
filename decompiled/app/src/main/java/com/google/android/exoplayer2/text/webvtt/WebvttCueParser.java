package com.google.android.exoplayer2.text.webvtt;

/* loaded from: classes.dex */
public final class WebvttCueParser {
    private static final char CHAR_AMPERSAND = '&';
    private static final char CHAR_GREATER_THAN = '>';
    private static final char CHAR_LESS_THAN = '<';
    private static final char CHAR_SEMI_COLON = ';';
    private static final char CHAR_SLASH = '/';
    private static final char CHAR_SPACE = ' ';
    public static final java.util.regex.Pattern CUE_HEADER_PATTERN = java.util.regex.Pattern.compile("^(\\S_renamed+)\\s_renamed+-->\\s_renamed+(\\S_renamed+)(.*)?$");
    private static final java.util.regex.Pattern CUE_SETTING_PATTERN = java.util.regex.Pattern.compile("(\\S_renamed+?):(\\S_renamed+)");
    private static final java.lang.String ENTITY_AMPERSAND = "amp";
    private static final java.lang.String ENTITY_GREATER_THAN = "gt_renamed";
    private static final java.lang.String ENTITY_LESS_THAN = "lt";
    private static final java.lang.String ENTITY_NON_BREAK_SPACE = "nbsp";
    private static final int STYLE_BOLD = 1;
    private static final int STYLE_ITALIC = 2;
    private static final java.lang.String TAG = "WebvttCueParser";
    private static final java.lang.String TAG_BOLD = "b_renamed";
    private static final java.lang.String TAG_CLASS = "c_renamed";
    private static final java.lang.String TAG_ITALIC = "i_renamed";
    private static final java.lang.String TAG_LANG = "lang";
    private static final java.lang.String TAG_UNDERLINE = "u_renamed";
    private static final java.lang.String TAG_VOICE = "v_renamed";
    private final java.lang.StringBuilder textBuilder = new java.lang.StringBuilder();

    public boolean parseCue(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, com.google.android.exoplayer2.text.webvtt.WebvttCue.Builder builder, java.util.List<com.google.android.exoplayer2.text.webvtt.WebvttCssStyle> list) {
        java.lang.String line = parsableByteArray.readLine();
        if (line == null) {
            return false;
        }
        java.util.regex.Matcher matcher = CUE_HEADER_PATTERN.matcher(line);
        if (matcher.matches()) {
            return parseCue(null, matcher, parsableByteArray, builder, this.textBuilder, list);
        }
        java.lang.String line2 = parsableByteArray.readLine();
        if (line2 == null) {
            return false;
        }
        java.util.regex.Matcher matcher2 = CUE_HEADER_PATTERN.matcher(line2);
        if (matcher2.matches()) {
            return parseCue(line.trim(), matcher2, parsableByteArray, builder, this.textBuilder, list);
        }
        return false;
    }

    static void parseCueSettingsList(java.lang.String str, com.google.android.exoplayer2.text.webvtt.WebvttCue.Builder builder) {
        java.util.regex.Matcher matcher = CUE_SETTING_PATTERN.matcher(str);
        while (matcher.find()) {
            java.lang.String strGroup = matcher.group(1);
            java.lang.String strGroup2 = matcher.group(2);
            try {
                if ("line".equals(strGroup)) {
                    parseLineAttribute(strGroup2, builder);
                } else if ("align".equals(strGroup)) {
                    builder.setTextAlignment(parseTextAlignment(strGroup2));
                } else if ("position".equals(strGroup)) {
                    parsePositionAttribute(strGroup2, builder);
                } else if (com.oplus.ocs.camera.CameraParameter.WaterMarkParamKeys.SIZE.equals(strGroup)) {
                    builder.setWidth(com.google.android.exoplayer2.text.webvtt.WebvttParserUtil.parsePercentage(strGroup2));
                } else {
                    com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Unknown cue setting " + strGroup + ":" + strGroup2);
                }
            } catch (java.lang.NumberFormatException unused) {
                com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Skipping bad cue setting: " + matcher.group());
            }
        }
    }

    static void parseCueText(java.lang.String str, java.lang.String str2, com.google.android.exoplayer2.text.webvtt.WebvttCue.Builder builder, java.util.List<com.google.android.exoplayer2.text.webvtt.WebvttCssStyle> list) {
        android.text.SpannableStringBuilder spannableStringBuilder = new android.text.SpannableStringBuilder();
        java.util.ArrayDeque arrayDeque = new java.util.ArrayDeque();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i_renamed = 0;
        while (i_renamed < str2.length()) {
            char cCharAt = str2.charAt(i_renamed);
            if (cCharAt == '&') {
                i_renamed++;
                int iIndexOf = str2.indexOf(59, i_renamed);
                int iIndexOf2 = str2.indexOf(32, i_renamed);
                if (iIndexOf == -1) {
                    iIndexOf = iIndexOf2;
                } else if (iIndexOf2 != -1) {
                    iIndexOf = java.lang.Math.min(iIndexOf, iIndexOf2);
                }
                if (iIndexOf != -1) {
                    applyEntity(str2.substring(i_renamed, iIndexOf), spannableStringBuilder);
                    if (iIndexOf == iIndexOf2) {
                        spannableStringBuilder.append(" ");
                    }
                    i_renamed = iIndexOf + 1;
                } else {
                    spannableStringBuilder.append(cCharAt);
                }
            } else if (cCharAt == '<') {
                int iFindEndOfTag = i_renamed + 1;
                if (iFindEndOfTag < str2.length()) {
                    boolean z_renamed = str2.charAt(iFindEndOfTag) == '/';
                    iFindEndOfTag = findEndOfTag(str2, iFindEndOfTag);
                    int i2 = iFindEndOfTag - 2;
                    boolean z2 = str2.charAt(i2) == '/';
                    int i3 = i_renamed + (z_renamed ? 2 : 1);
                    if (!z2) {
                        i2 = iFindEndOfTag - 1;
                    }
                    java.lang.String strSubstring = str2.substring(i3, i2);
                    java.lang.String tagName = getTagName(strSubstring);
                    if (tagName != null && isSupportedTag(tagName)) {
                        if (z_renamed) {
                            while (!arrayDeque.isEmpty()) {
                                com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StartTag startTag = (com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StartTag) arrayDeque.pop();
                                applySpansForTag(str, startTag, spannableStringBuilder, list, arrayList);
                                if (startTag.name.equals(tagName)) {
                                    break;
                                }
                            }
                        } else if (!z2) {
                            arrayDeque.push(com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StartTag.buildStartTag(strSubstring, spannableStringBuilder.length()));
                        }
                    }
                }
                i_renamed = iFindEndOfTag;
            } else {
                spannableStringBuilder.append(cCharAt);
                i_renamed++;
            }
        }
        while (!arrayDeque.isEmpty()) {
            applySpansForTag(str, (com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StartTag) arrayDeque.pop(), spannableStringBuilder, list, arrayList);
        }
        applySpansForTag(str, com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StartTag.buildWholeCueVirtualTag(), spannableStringBuilder, list, arrayList);
        builder.setText(spannableStringBuilder);
    }

    private static boolean parseCue(java.lang.String str, java.util.regex.Matcher matcher, com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, com.google.android.exoplayer2.text.webvtt.WebvttCue.Builder builder, java.lang.StringBuilder sb, java.util.List<com.google.android.exoplayer2.text.webvtt.WebvttCssStyle> list) {
        try {
            builder.setStartTime(com.google.android.exoplayer2.text.webvtt.WebvttParserUtil.parseTimestampUs(matcher.group(1))).setEndTime(com.google.android.exoplayer2.text.webvtt.WebvttParserUtil.parseTimestampUs(matcher.group(2)));
            parseCueSettingsList(matcher.group(3), builder);
            sb.setLength(0);
            while (true) {
                java.lang.String line = parsableByteArray.readLine();
                if (!android.text.TextUtils.isEmpty(line)) {
                    if (sb.length() > 0) {
                        sb.append("\n_renamed");
                    }
                    sb.append(line.trim());
                } else {
                    parseCueText(str, sb.toString(), builder, list);
                    return true;
                }
            }
        } catch (java.lang.NumberFormatException unused) {
            com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Skipping cue with bad header: " + matcher.group());
            return false;
        }
    }

    private static void parseLineAttribute(java.lang.String str, com.google.android.exoplayer2.text.webvtt.WebvttCue.Builder builder) throws java.lang.NumberFormatException {
        int iIndexOf = str.indexOf(44);
        if (iIndexOf != -1) {
            builder.setLineAnchor(parsePositionAnchor(str.substring(iIndexOf + 1)));
            str = str.substring(0, iIndexOf);
        } else {
            builder.setLineAnchor(Integer.MIN_VALUE);
        }
        if (str.endsWith("%")) {
            builder.setLine(com.google.android.exoplayer2.text.webvtt.WebvttParserUtil.parsePercentage(str)).setLineType(0);
            return;
        }
        int i_renamed = java.lang.Integer.parseInt(str);
        if (i_renamed < 0) {
            i_renamed--;
        }
        builder.setLine(i_renamed).setLineType(1);
    }

    private static void parsePositionAttribute(java.lang.String str, com.google.android.exoplayer2.text.webvtt.WebvttCue.Builder builder) throws java.lang.NumberFormatException {
        int iIndexOf = str.indexOf(44);
        if (iIndexOf != -1) {
            builder.setPositionAnchor(parsePositionAnchor(str.substring(iIndexOf + 1)));
            str = str.substring(0, iIndexOf);
        } else {
            builder.setPositionAnchor(Integer.MIN_VALUE);
        }
        builder.setPosition(com.google.android.exoplayer2.text.webvtt.WebvttParserUtil.parsePercentage(str));
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as_renamed a_renamed decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B_renamed:17:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int parsePositionAnchor(java.lang.String r5) {
        /*
            int r0 = r5.hashCode()
            r1 = 0
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r0) {
                case -1364013995: goto L2a;
                case -1074341483: goto L20;
                case 100571: goto L16;
                case 109757538: goto Lc;
                default: goto Lb;
            }
        Lb:
            goto L34
        Lc:
            java.lang.String r0 = "start"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L34
            r0 = r1
            goto L35
        L16:
            java.lang.String r0 = "end"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L34
            r0 = r2
            goto L35
        L20:
            java.lang.String r0 = "middle"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L34
            r0 = r3
            goto L35
        L2a:
            java.lang.String r0 = "center"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L34
            r0 = r4
            goto L35
        L34:
            r0 = -1
        L35:
            if (r0 == 0) goto L58
            if (r0 == r4) goto L57
            if (r0 == r3) goto L57
            if (r0 == r2) goto L56
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Invalid anchor value: "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            java.lang.String r0 = "WebvttCueParser"
            com.google.android.exoplayer2.util.Log.w_renamed(r0, r5)
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            return r5
        L56:
            return r3
        L57:
            return r4
        L58:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.webvtt.WebvttCueParser.parsePositionAnchor(java.lang.String):int");
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as_renamed a_renamed decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B_renamed:23:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.text.Layout.Alignment parseTextAlignment(java.lang.String r6) {
        /*
            int r0 = r6.hashCode()
            r1 = 5
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r0) {
                case -1364013995: goto L3f;
                case -1074341483: goto L35;
                case 100571: goto L2b;
                case 3317767: goto L21;
                case 108511772: goto L17;
                case 109757538: goto Ld;
                default: goto Lc;
            }
        Lc:
            goto L49
        Ld:
            java.lang.String r0 = "start"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L49
            r0 = 0
            goto L4a
        L17:
            java.lang.String r0 = "right"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L49
            r0 = r1
            goto L4a
        L21:
            java.lang.String r0 = "left"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L49
            r0 = r5
            goto L4a
        L2b:
            java.lang.String r0 = "end"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L49
            r0 = r2
            goto L4a
        L35:
            java.lang.String r0 = "middle"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L49
            r0 = r3
            goto L4a
        L3f:
            java.lang.String r0 = "center"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L49
            r0 = r4
            goto L4a
        L49:
            r0 = -1
        L4a:
            if (r0 == 0) goto L74
            if (r0 == r5) goto L74
            if (r0 == r4) goto L71
            if (r0 == r3) goto L71
            if (r0 == r2) goto L6e
            if (r0 == r1) goto L6e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Invalid alignment value: "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            java.lang.String r0 = "WebvttCueParser"
            com.google.android.exoplayer2.util.Log.w_renamed(r0, r6)
            r6 = 0
            return r6
        L6e:
            android.text.Layout$Alignment r6 = android.text.Layout.Alignment.ALIGN_OPPOSITE
            return r6
        L71:
            android.text.Layout$Alignment r6 = android.text.Layout.Alignment.ALIGN_CENTER
            return r6
        L74:
            android.text.Layout$Alignment r6 = android.text.Layout.Alignment.ALIGN_NORMAL
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.webvtt.WebvttCueParser.parseTextAlignment(java.lang.String):android.text.Layout$Alignment");
    }

    private static int findEndOfTag(java.lang.String str, int i_renamed) {
        int iIndexOf = str.indexOf(62, i_renamed);
        return iIndexOf == -1 ? str.length() : iIndexOf + 1;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:23:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void applyEntity(java.lang.String r5, android.text.SpannableStringBuilder r6) {
        /*
            int r0 = r5.hashCode()
            r1 = 3309(0xced, float:4.637E-42)
            r2 = 3
            r3 = 2
            r4 = 1
            if (r0 == r1) goto L38
            r1 = 3464(0xd88, float:4.854E-42)
            if (r0 == r1) goto L2e
            r1 = 96708(0x179c4, float:1.35517E-40)
            if (r0 == r1) goto L24
            r1 = 3374865(0x337f11, float:4.729193E-39)
            if (r0 == r1) goto L1a
            goto L42
        L1a:
            java.lang.String r0 = "nbsp"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L42
            r0 = r3
            goto L43
        L24:
            java.lang.String r0 = "amp"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L42
            r0 = r2
            goto L43
        L2e:
            java.lang.String r0 = "lt"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L42
            r0 = 0
            goto L43
        L38:
            java.lang.String r0 = "gt_renamed"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L42
            r0 = r4
            goto L43
        L42:
            r0 = -1
        L43:
            if (r0 == 0) goto L79
            if (r0 == r4) goto L73
            if (r0 == r3) goto L6d
            if (r0 == r2) goto L67
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "ignoring unsupported entity: '&"
            r6.append(r0)
            r6.append(r5)
            java.lang.String r5 = ";'"
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            java.lang.String r6 = "WebvttCueParser"
            com.google.android.exoplayer2.util.Log.w_renamed(r6, r5)
            goto L7e
        L67:
            r5 = 38
            r6.append(r5)
            goto L7e
        L6d:
            r5 = 32
            r6.append(r5)
            goto L7e
        L73:
            r5 = 62
            r6.append(r5)
            goto L7e
        L79:
            r5 = 60
            r6.append(r5)
        L7e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.webvtt.WebvttCueParser.applyEntity(java.lang.String, android.text.SpannableStringBuilder):void");
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:33:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean isSupportedTag(java.lang.String r8) {
        /*
            int r0 = r8.hashCode()
            r1 = 98
            r2 = 0
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            if (r0 == r1) goto L56
            r1 = 99
            if (r0 == r1) goto L4c
            r1 = 105(0x69, float:1.47E-43)
            if (r0 == r1) goto L42
            r1 = 3314158(0x3291ee, float:4.644125E-39)
            if (r0 == r1) goto L38
            r1 = 117(0x75, float:1.64E-43)
            if (r0 == r1) goto L2e
            r1 = 118(0x76, float:1.65E-43)
            if (r0 == r1) goto L24
            goto L60
        L24:
            java.lang.String r0 = "v_renamed"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L60
            r8 = r3
            goto L61
        L2e:
            java.lang.String r0 = "u_renamed"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L60
            r8 = r4
            goto L61
        L38:
            java.lang.String r0 = "lang"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L60
            r8 = r5
            goto L61
        L42:
            java.lang.String r0 = "i_renamed"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L60
            r8 = r6
            goto L61
        L4c:
            java.lang.String r0 = "c_renamed"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L60
            r8 = r7
            goto L61
        L56:
            java.lang.String r0 = "b_renamed"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L60
            r8 = r2
            goto L61
        L60:
            r8 = -1
        L61:
            if (r8 == 0) goto L6e
            if (r8 == r7) goto L6e
            if (r8 == r6) goto L6e
            if (r8 == r5) goto L6e
            if (r8 == r4) goto L6e
            if (r8 == r3) goto L6e
            return r2
        L6e:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.webvtt.WebvttCueParser.isSupportedTag(java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:38:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void applySpansForTag(java.lang.String r8, com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StartTag r9, android.text.SpannableStringBuilder r10, java.util.List<com.google.android.exoplayer2.text.webvtt.WebvttCssStyle> r11, java.util.List<com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StyleMatch> r12) {
        /*
            int r0 = r9.position
            int r1 = r10.length()
            java.lang.String r2 = r9.name
            int r3 = r2.hashCode()
            r4 = 0
            r5 = 2
            r6 = 1
            if (r3 == 0) goto L67
            r7 = 105(0x69, float:1.47E-43)
            if (r3 == r7) goto L5d
            r7 = 3314158(0x3291ee, float:4.644125E-39)
            if (r3 == r7) goto L53
            r7 = 98
            if (r3 == r7) goto L49
            r7 = 99
            if (r3 == r7) goto L3f
            r7 = 117(0x75, float:1.64E-43)
            if (r3 == r7) goto L35
            r7 = 118(0x76, float:1.65E-43)
            if (r3 == r7) goto L2b
            goto L71
        L2b:
            java.lang.String r3 = "v_renamed"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L71
            r2 = 5
            goto L72
        L35:
            java.lang.String r3 = "u_renamed"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L71
            r2 = r5
            goto L72
        L3f:
            java.lang.String r3 = "c_renamed"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L71
            r2 = 3
            goto L72
        L49:
            java.lang.String r3 = "b_renamed"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L71
            r2 = r4
            goto L72
        L53:
            java.lang.String r3 = "lang"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L71
            r2 = 4
            goto L72
        L5d:
            java.lang.String r3 = "i_renamed"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L71
            r2 = r6
            goto L72
        L67:
            java.lang.String r3 = ""
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L71
            r2 = 6
            goto L72
        L71:
            r2 = -1
        L72:
            r3 = 33
            switch(r2) {
                case 0: goto L8a;
                case 1: goto L81;
                case 2: goto L78;
                case 3: goto L92;
                case 4: goto L92;
                case 5: goto L92;
                case 6: goto L92;
                default: goto L77;
            }
        L77:
            return
        L78:
            android.text.style.UnderlineSpan r2 = new android.text.style.UnderlineSpan
            r2.<init>()
            r10.setSpan(r2, r0, r1, r3)
            goto L92
        L81:
            android.text.style.StyleSpan r2 = new android.text.style.StyleSpan
            r2.<init>(r5)
            r10.setSpan(r2, r0, r1, r3)
            goto L92
        L8a:
            android.text.style.StyleSpan r2 = new android.text.style.StyleSpan
            r2.<init>(r6)
            r10.setSpan(r2, r0, r1, r3)
        L92:
            r12.clear()
            getApplicableStyles(r11, r8, r9, r12)
            int r8 = r12.size()
        L9c:
            if (r4 >= r8) goto Lac
            java.lang.Object r9 = r12.get(r4)
            com.google.android.exoplayer2.text.webvtt.WebvttCueParser$StyleMatch r9 = (com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StyleMatch) r9
            com.google.android.exoplayer2.text.webvtt.WebvttCssStyle r9 = r9.style
            applyStyleToText(r10, r9, r0, r1)
            int r4 = r4 + 1
            goto L9c
        Lac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.webvtt.WebvttCueParser.applySpansForTag(java.lang.String, com.google.android.exoplayer2.text.webvtt.WebvttCueParser$StartTag, android.text.SpannableStringBuilder, java.util.List, java.util.List):void");
    }

    private static void applyStyleToText(android.text.SpannableStringBuilder spannableStringBuilder, com.google.android.exoplayer2.text.webvtt.WebvttCssStyle webvttCssStyle, int i_renamed, int i2) {
        if (webvttCssStyle == null) {
            return;
        }
        if (webvttCssStyle.getStyle() != -1) {
            spannableStringBuilder.setSpan(new android.text.style.StyleSpan(webvttCssStyle.getStyle()), i_renamed, i2, 33);
        }
        if (webvttCssStyle.isLinethrough()) {
            spannableStringBuilder.setSpan(new android.text.style.StrikethroughSpan(), i_renamed, i2, 33);
        }
        if (webvttCssStyle.isUnderline()) {
            spannableStringBuilder.setSpan(new android.text.style.UnderlineSpan(), i_renamed, i2, 33);
        }
        if (webvttCssStyle.hasFontColor()) {
            spannableStringBuilder.setSpan(new android.text.style.ForegroundColorSpan(webvttCssStyle.getFontColor()), i_renamed, i2, 33);
        }
        if (webvttCssStyle.hasBackgroundColor()) {
            spannableStringBuilder.setSpan(new android.text.style.BackgroundColorSpan(webvttCssStyle.getBackgroundColor()), i_renamed, i2, 33);
        }
        if (webvttCssStyle.getFontFamily() != null) {
            spannableStringBuilder.setSpan(new android.text.style.TypefaceSpan(webvttCssStyle.getFontFamily()), i_renamed, i2, 33);
        }
        if (webvttCssStyle.getTextAlign() != null) {
            spannableStringBuilder.setSpan(new android.text.style.AlignmentSpan.Standard(webvttCssStyle.getTextAlign()), i_renamed, i2, 33);
        }
        int fontSizeUnit = webvttCssStyle.getFontSizeUnit();
        if (fontSizeUnit == 1) {
            spannableStringBuilder.setSpan(new android.text.style.AbsoluteSizeSpan((int) webvttCssStyle.getFontSize(), true), i_renamed, i2, 33);
        } else if (fontSizeUnit == 2) {
            spannableStringBuilder.setSpan(new android.text.style.RelativeSizeSpan(webvttCssStyle.getFontSize()), i_renamed, i2, 33);
        } else {
            if (fontSizeUnit != 3) {
                return;
            }
            spannableStringBuilder.setSpan(new android.text.style.RelativeSizeSpan(webvttCssStyle.getFontSize() / 100.0f), i_renamed, i2, 33);
        }
    }

    private static java.lang.String getTagName(java.lang.String str) {
        java.lang.String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return null;
        }
        return com.google.android.exoplayer2.util.Util.splitAtFirst(strTrim, "[ \\.]")[0];
    }

    private static void getApplicableStyles(java.util.List<com.google.android.exoplayer2.text.webvtt.WebvttCssStyle> list, java.lang.String str, com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StartTag startTag, java.util.List<com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StyleMatch> list2) {
        int size = list.size();
        for (int i_renamed = 0; i_renamed < size; i_renamed++) {
            com.google.android.exoplayer2.text.webvtt.WebvttCssStyle webvttCssStyle = list.get(i_renamed);
            int specificityScore = webvttCssStyle.getSpecificityScore(str, startTag.name, startTag.classes, startTag.voice);
            if (specificityScore > 0) {
                list2.add(new com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StyleMatch(specificityScore, webvttCssStyle));
            }
        }
        java.util.Collections.sort(list2);
    }

    private static final class StyleMatch implements java.lang.Comparable<com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StyleMatch> {
        public final int score;
        public final com.google.android.exoplayer2.text.webvtt.WebvttCssStyle style;

        public StyleMatch(int i_renamed, com.google.android.exoplayer2.text.webvtt.WebvttCssStyle webvttCssStyle) {
            this.score = i_renamed;
            this.style = webvttCssStyle;
        }

        @Override // java.lang.Comparable
        public int compareTo(com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StyleMatch styleMatch) {
            return this.score - styleMatch.score;
        }
    }

    private static final class StartTag {
        private static final java.lang.String[] NO_CLASSES = new java.lang.String[0];
        public final java.lang.String[] classes;
        public final java.lang.String name;
        public final int position;
        public final java.lang.String voice;

        private StartTag(java.lang.String str, int i_renamed, java.lang.String str2, java.lang.String[] strArr) {
            this.position = i_renamed;
            this.name = str;
            this.voice = str2;
            this.classes = strArr;
        }

        public static com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StartTag buildStartTag(java.lang.String str, int i_renamed) {
            java.lang.String str2;
            java.lang.String[] strArr;
            java.lang.String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return null;
            }
            int iIndexOf = strTrim.indexOf(" ");
            if (iIndexOf == -1) {
                str2 = "";
            } else {
                java.lang.String strTrim2 = strTrim.substring(iIndexOf).trim();
                strTrim = strTrim.substring(0, iIndexOf);
                str2 = strTrim2;
            }
            java.lang.String[] strArrSplit = com.google.android.exoplayer2.util.Util.split(strTrim, "\\.");
            java.lang.String str3 = strArrSplit[0];
            if (strArrSplit.length > 1) {
                strArr = (java.lang.String[]) java.util.Arrays.copyOfRange(strArrSplit, 1, strArrSplit.length);
            } else {
                strArr = NO_CLASSES;
            }
            return new com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StartTag(str3, i_renamed, str2, strArr);
        }

        public static com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StartTag buildWholeCueVirtualTag() {
            return new com.google.android.exoplayer2.text.webvtt.WebvttCueParser.StartTag("", 0, "", new java.lang.String[0]);
        }
    }
}
