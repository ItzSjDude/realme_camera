package com.google.android.exoplayer2.text.webvtt;

/* loaded from: classes.dex */
final class CssParser {
    private static final java.lang.String BLOCK_END = "}";
    private static final java.lang.String BLOCK_START = "{";
    private static final java.lang.String PROPERTY_BGCOLOR = "background-color";
    private static final java.lang.String PROPERTY_FONT_FAMILY = "font-family";
    private static final java.lang.String PROPERTY_FONT_STYLE = "font-style";
    private static final java.lang.String PROPERTY_FONT_WEIGHT = "font-weight";
    private static final java.lang.String PROPERTY_TEXT_DECORATION = "text-decoration";
    private static final java.lang.String VALUE_BOLD = "bold";
    private static final java.lang.String VALUE_ITALIC = "italic";
    private static final java.lang.String VALUE_UNDERLINE = "underline";
    private static final java.util.regex.Pattern VOICE_NAME_PATTERN = java.util.regex.Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    private final com.google.android.exoplayer2.util.ParsableByteArray styleInput = new com.google.android.exoplayer2.util.ParsableByteArray();
    private final java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder();

    public com.google.android.exoplayer2.text.webvtt.WebvttCssStyle parseBlock(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        this.stringBuilder.setLength(0);
        int position = parsableByteArray.getPosition();
        skipStyleBlock(parsableByteArray);
        this.styleInput.reset(parsableByteArray.data, parsableByteArray.getPosition());
        this.styleInput.setPosition(position);
        java.lang.String selector = parseSelector(this.styleInput, this.stringBuilder);
        if (selector == null || !BLOCK_START.equals(parseNextToken(this.styleInput, this.stringBuilder))) {
            return null;
        }
        com.google.android.exoplayer2.text.webvtt.WebvttCssStyle webvttCssStyle = new com.google.android.exoplayer2.text.webvtt.WebvttCssStyle();
        applySelectorToStyle(webvttCssStyle, selector);
        java.lang.String nextToken = null;
        boolean z_renamed = false;
        while (!z_renamed) {
            int position2 = this.styleInput.getPosition();
            nextToken = parseNextToken(this.styleInput, this.stringBuilder);
            boolean z2 = nextToken == null || BLOCK_END.equals(nextToken);
            if (!z2) {
                this.styleInput.setPosition(position2);
                parseStyleDeclaration(this.styleInput, webvttCssStyle, this.stringBuilder);
            }
            z_renamed = z2;
        }
        if (BLOCK_END.equals(nextToken)) {
            return webvttCssStyle;
        }
        return null;
    }

    private static java.lang.String parseSelector(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, java.lang.StringBuilder sb) {
        skipWhitespaceAndComments(parsableByteArray);
        if (parsableByteArray.bytesLeft() < 5 || !"::cue".equals(parsableByteArray.readString(5))) {
            return null;
        }
        int position = parsableByteArray.getPosition();
        java.lang.String nextToken = parseNextToken(parsableByteArray, sb);
        if (nextToken == null) {
            return null;
        }
        if (BLOCK_START.equals(nextToken)) {
            parsableByteArray.setPosition(position);
            return "";
        }
        java.lang.String cueTarget = "(".equals(nextToken) ? readCueTarget(parsableByteArray) : null;
        java.lang.String nextToken2 = parseNextToken(parsableByteArray, sb);
        if (!")".equals(nextToken2) || nextToken2 == null) {
            return null;
        }
        return cueTarget;
    }

    private static java.lang.String readCueTarget(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int position = parsableByteArray.getPosition();
        int iLimit = parsableByteArray.limit();
        boolean z_renamed = false;
        while (position < iLimit && !z_renamed) {
            int i_renamed = position + 1;
            z_renamed = ((char) parsableByteArray.data[position]) == ')';
            position = i_renamed;
        }
        return parsableByteArray.readString((position - 1) - parsableByteArray.getPosition()).trim();
    }

    private static void parseStyleDeclaration(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, com.google.android.exoplayer2.text.webvtt.WebvttCssStyle webvttCssStyle, java.lang.StringBuilder sb) {
        skipWhitespaceAndComments(parsableByteArray);
        java.lang.String identifier = parseIdentifier(parsableByteArray, sb);
        if (!"".equals(identifier) && ":".equals(parseNextToken(parsableByteArray, sb))) {
            skipWhitespaceAndComments(parsableByteArray);
            java.lang.String propertyValue = parsePropertyValue(parsableByteArray, sb);
            if (propertyValue == null || "".equals(propertyValue)) {
                return;
            }
            int position = parsableByteArray.getPosition();
            java.lang.String nextToken = parseNextToken(parsableByteArray, sb);
            if (!";".equals(nextToken)) {
                if (!BLOCK_END.equals(nextToken)) {
                    return;
                } else {
                    parsableByteArray.setPosition(position);
                }
            }
            if (com.google.android.exoplayer2.text.ttml.TtmlNode.ATTR_TTS_COLOR.equals(identifier)) {
                webvttCssStyle.setFontColor(com.google.android.exoplayer2.util.ColorParser.parseCssColor(propertyValue));
                return;
            }
            if (PROPERTY_BGCOLOR.equals(identifier)) {
                webvttCssStyle.setBackgroundColor(com.google.android.exoplayer2.util.ColorParser.parseCssColor(propertyValue));
                return;
            }
            if (PROPERTY_TEXT_DECORATION.equals(identifier)) {
                if ("underline".equals(propertyValue)) {
                    webvttCssStyle.setUnderline(true);
                }
            } else {
                if (PROPERTY_FONT_FAMILY.equals(identifier)) {
                    webvttCssStyle.setFontFamily(propertyValue);
                    return;
                }
                if (PROPERTY_FONT_WEIGHT.equals(identifier)) {
                    if ("bold".equals(propertyValue)) {
                        webvttCssStyle.setBold(true);
                    }
                } else if (PROPERTY_FONT_STYLE.equals(identifier) && "italic".equals(propertyValue)) {
                    webvttCssStyle.setItalic(true);
                }
            }
        }
    }

    static void skipWhitespaceAndComments(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        while (true) {
            for (boolean z_renamed = true; parsableByteArray.bytesLeft() > 0 && z_renamed; z_renamed = false) {
                if (maybeSkipWhitespace(parsableByteArray) || maybeSkipComment(parsableByteArray)) {
                    break;
                }
            }
            return;
        }
    }

    static java.lang.String parseNextToken(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, java.lang.StringBuilder sb) {
        skipWhitespaceAndComments(parsableByteArray);
        if (parsableByteArray.bytesLeft() == 0) {
            return null;
        }
        java.lang.String identifier = parseIdentifier(parsableByteArray, sb);
        if (!"".equals(identifier)) {
            return identifier;
        }
        return "" + ((char) parsableByteArray.readUnsignedByte());
    }

    private static boolean maybeSkipWhitespace(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        char cPeekCharAtPosition = peekCharAtPosition(parsableByteArray, parsableByteArray.getPosition());
        if (cPeekCharAtPosition != '\t_renamed' && cPeekCharAtPosition != '\n_renamed' && cPeekCharAtPosition != '\f_renamed' && cPeekCharAtPosition != '\r_renamed' && cPeekCharAtPosition != ' ') {
            return false;
        }
        parsableByteArray.skipBytes(1);
        return true;
    }

    static void skipStyleBlock(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        while (!android.text.TextUtils.isEmpty(parsableByteArray.readLine())) {
        }
    }

    private static char peekCharAtPosition(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i_renamed) {
        return (char) parsableByteArray.data[i_renamed];
    }

    private static java.lang.String parsePropertyValue(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, java.lang.StringBuilder sb) {
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        boolean z_renamed = false;
        while (!z_renamed) {
            int position = parsableByteArray.getPosition();
            java.lang.String nextToken = parseNextToken(parsableByteArray, sb);
            if (nextToken == null) {
                return null;
            }
            if (BLOCK_END.equals(nextToken) || ";".equals(nextToken)) {
                parsableByteArray.setPosition(position);
                z_renamed = true;
            } else {
                sb2.append(nextToken);
            }
        }
        return sb2.toString();
    }

    private static boolean maybeSkipComment(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int position = parsableByteArray.getPosition();
        int iLimit = parsableByteArray.limit();
        byte[] bArr = parsableByteArray.data;
        if (position + 2 > iLimit) {
            return false;
        }
        int i_renamed = position + 1;
        if (bArr[position] != 47) {
            return false;
        }
        int i2 = i_renamed + 1;
        if (bArr[i_renamed] != 42) {
            return false;
        }
        while (true) {
            int i3 = i2 + 1;
            if (i3 < iLimit) {
                if (((char) bArr[i2]) == '*' && ((char) bArr[i3]) == '/') {
                    i2 = i3 + 1;
                    iLimit = i2;
                } else {
                    i2 = i3;
                }
            } else {
                parsableByteArray.skipBytes(iLimit - parsableByteArray.getPosition());
                return true;
            }
        }
    }

    private static java.lang.String parseIdentifier(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, java.lang.StringBuilder sb) {
        boolean z_renamed = false;
        sb.setLength(0);
        int position = parsableByteArray.getPosition();
        int iLimit = parsableByteArray.limit();
        while (position < iLimit && !z_renamed) {
            char c2 = (char) parsableByteArray.data[position];
            if ((c2 < 'A_renamed' || c2 > 'Z_renamed') && ((c2 < 'a_renamed' || c2 > 'z_renamed') && !((c2 >= '0' && c2 <= '9') || c2 == '#' || c2 == '-' || c2 == '.' || c2 == '_'))) {
                z_renamed = true;
            } else {
                position++;
                sb.append(c2);
            }
        }
        parsableByteArray.skipBytes(position - parsableByteArray.getPosition());
        return sb.toString();
    }

    private void applySelectorToStyle(com.google.android.exoplayer2.text.webvtt.WebvttCssStyle webvttCssStyle, java.lang.String str) {
        if ("".equals(str)) {
            return;
        }
        int iIndexOf = str.indexOf(91);
        if (iIndexOf != -1) {
            java.util.regex.Matcher matcher = VOICE_NAME_PATTERN.matcher(str.substring(iIndexOf));
            if (matcher.matches()) {
                webvttCssStyle.setTargetVoice(matcher.group(1));
            }
            str = str.substring(0, iIndexOf);
        }
        java.lang.String[] strArrSplit = com.google.android.exoplayer2.util.Util.split(str, "\\.");
        java.lang.String str2 = strArrSplit[0];
        int iIndexOf2 = str2.indexOf(35);
        if (iIndexOf2 != -1) {
            webvttCssStyle.setTargetTagName(str2.substring(0, iIndexOf2));
            webvttCssStyle.setTargetId(str2.substring(iIndexOf2 + 1));
        } else {
            webvttCssStyle.setTargetTagName(str2);
        }
        if (strArrSplit.length > 1) {
            webvttCssStyle.setTargetClasses((java.lang.String[]) java.util.Arrays.copyOfRange(strArrSplit, 1, strArrSplit.length));
        }
    }
}
