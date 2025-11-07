package com.google.android.exoplayer2.text.tx3g;

/* loaded from: classes.dex */
public final class Tx3gDecoder extends com.google.android.exoplayer2.text.SimpleSubtitleDecoder {
    private static final char BOM_UTF16_BE = 65279;
    private static final char BOM_UTF16_LE = 65534;
    private static final int DEFAULT_COLOR = -1;
    private static final int DEFAULT_FONT_FACE = 0;
    private static final java.lang.String DEFAULT_FONT_FAMILY = "sans-serif";
    private static final float DEFAULT_VERTICAL_PLACEMENT = 0.85f;
    private static final int FONT_FACE_BOLD = 1;
    private static final int FONT_FACE_ITALIC = 2;
    private static final int FONT_FACE_UNDERLINE = 4;
    private static final int SIZE_ATOM_HEADER = 8;
    private static final int SIZE_BOM_UTF16 = 2;
    private static final int SIZE_SHORT = 2;
    private static final int SIZE_STYLE_RECORD = 12;
    private static final int SPAN_PRIORITY_HIGH = 0;
    private static final int SPAN_PRIORITY_LOW = 16711680;
    private static final java.lang.String TX3G_SERIF = "Serif";
    private static final int TYPE_STYL = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("styl");
    private static final int TYPE_TBOX = com.google.android.exoplayer2.util.Util.getIntegerCodeForString("tbox");
    private int calculatedVideoTrackHeight;
    private boolean customVerticalPlacement;
    private int defaultColorRgba;
    private int defaultFontFace;
    private java.lang.String defaultFontFamily;
    private float defaultVerticalPlacement;
    private final com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray;

    public Tx3gDecoder(java.util.List<byte[]> list) {
        super("Tx3gDecoder");
        this.parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray();
        decodeInitializationData(list);
    }

    private void decodeInitializationData(java.util.List<byte[]> list) {
        if (list != null && list.size() == 1 && (list.get(0).length == 48 || list.get(0).length == 53)) {
            byte[] bArr = list.get(0);
            this.defaultFontFace = bArr[24];
            this.defaultColorRgba = ((bArr[26] & 255) << 24) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
            this.defaultFontFamily = TX3G_SERIF.equals(com.google.android.exoplayer2.util.Util.fromUtf8Bytes(bArr, 43, bArr.length - 43)) ? com.google.android.exoplayer2.C_renamed.SERIF_NAME : "sans-serif";
            this.calculatedVideoTrackHeight = bArr[25] * 20;
            this.customVerticalPlacement = (bArr[0] & 32) != 0;
            if (this.customVerticalPlacement) {
                this.defaultVerticalPlacement = ((bArr[11] & 255) | ((bArr[10] & 255) << 8)) / this.calculatedVideoTrackHeight;
                this.defaultVerticalPlacement = com.google.android.exoplayer2.util.Util.constrainValue(this.defaultVerticalPlacement, 0.0f, 0.95f);
                return;
            } else {
                this.defaultVerticalPlacement = DEFAULT_VERTICAL_PLACEMENT;
                return;
            }
        }
        this.defaultFontFace = 0;
        this.defaultColorRgba = -1;
        this.defaultFontFamily = "sans-serif";
        this.customVerticalPlacement = false;
        this.defaultVerticalPlacement = DEFAULT_VERTICAL_PLACEMENT;
    }

    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    protected com.google.android.exoplayer2.text.Subtitle decode(byte[] bArr, int i_renamed, boolean z_renamed) throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        this.parsableByteArray.reset(bArr, i_renamed);
        java.lang.String subtitleText = readSubtitleText(this.parsableByteArray);
        if (subtitleText.isEmpty()) {
            return com.google.android.exoplayer2.text.tx3g.Tx3gSubtitle.EMPTY;
        }
        android.text.SpannableStringBuilder spannableStringBuilder = new android.text.SpannableStringBuilder(subtitleText);
        attachFontFace(spannableStringBuilder, this.defaultFontFace, 0, 0, spannableStringBuilder.length(), SPAN_PRIORITY_LOW);
        attachColor(spannableStringBuilder, this.defaultColorRgba, -1, 0, spannableStringBuilder.length(), SPAN_PRIORITY_LOW);
        attachFontFamily(spannableStringBuilder, this.defaultFontFamily, "sans-serif", 0, spannableStringBuilder.length(), SPAN_PRIORITY_LOW);
        float fConstrainValue = this.defaultVerticalPlacement;
        while (this.parsableByteArray.bytesLeft() >= 8) {
            int position = this.parsableByteArray.getPosition();
            int i2 = this.parsableByteArray.readInt();
            int i3 = this.parsableByteArray.readInt();
            if (i3 == TYPE_STYL) {
                assertTrue(this.parsableByteArray.bytesLeft() >= 2);
                int unsignedShort = this.parsableByteArray.readUnsignedShort();
                for (int i4 = 0; i4 < unsignedShort; i4++) {
                    applyStyleRecord(this.parsableByteArray, spannableStringBuilder);
                }
            } else if (i3 == TYPE_TBOX && this.customVerticalPlacement) {
                assertTrue(this.parsableByteArray.bytesLeft() >= 2);
                fConstrainValue = com.google.android.exoplayer2.util.Util.constrainValue(this.parsableByteArray.readUnsignedShort() / this.calculatedVideoTrackHeight, 0.0f, 0.95f);
            }
            this.parsableByteArray.setPosition(position + i2);
        }
        return new com.google.android.exoplayer2.text.tx3g.Tx3gSubtitle(new com.google.android.exoplayer2.text.Cue(spannableStringBuilder, null, fConstrainValue, 0, 0, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE));
    }

    private static java.lang.String readSubtitleText(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        char cPeekChar;
        assertTrue(parsableByteArray.bytesLeft() >= 2);
        int unsignedShort = parsableByteArray.readUnsignedShort();
        if (unsignedShort == 0) {
            return "";
        }
        if (parsableByteArray.bytesLeft() >= 2 && ((cPeekChar = parsableByteArray.peekChar()) == 65279 || cPeekChar == 65534)) {
            return parsableByteArray.readString(unsignedShort, java.nio.charset.Charset.forName("UTF-16"));
        }
        return parsableByteArray.readString(unsignedShort, java.nio.charset.Charset.forName("UTF-8"));
    }

    private void applyStyleRecord(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, android.text.SpannableStringBuilder spannableStringBuilder) throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        assertTrue(parsableByteArray.bytesLeft() >= 12);
        int unsignedShort = parsableByteArray.readUnsignedShort();
        int unsignedShort2 = parsableByteArray.readUnsignedShort();
        parsableByteArray.skipBytes(2);
        int unsignedByte = parsableByteArray.readUnsignedByte();
        parsableByteArray.skipBytes(1);
        int i_renamed = parsableByteArray.readInt();
        attachFontFace(spannableStringBuilder, unsignedByte, this.defaultFontFace, unsignedShort, unsignedShort2, 0);
        attachColor(spannableStringBuilder, i_renamed, this.defaultColorRgba, unsignedShort, unsignedShort2, 0);
    }

    private static void attachFontFace(android.text.SpannableStringBuilder spannableStringBuilder, int i_renamed, int i2, int i3, int i4, int i5) {
        if (i_renamed != i2) {
            int i6 = i5 | 33;
            boolean z_renamed = (i_renamed & 1) != 0;
            boolean z2 = (i_renamed & 2) != 0;
            if (z_renamed) {
                if (z2) {
                    spannableStringBuilder.setSpan(new android.text.style.StyleSpan(3), i3, i4, i6);
                } else {
                    spannableStringBuilder.setSpan(new android.text.style.StyleSpan(1), i3, i4, i6);
                }
            } else if (z2) {
                spannableStringBuilder.setSpan(new android.text.style.StyleSpan(2), i3, i4, i6);
            }
            boolean z3 = (i_renamed & 4) != 0;
            if (z3) {
                spannableStringBuilder.setSpan(new android.text.style.UnderlineSpan(), i3, i4, i6);
            }
            if (z3 || z_renamed || z2) {
                return;
            }
            spannableStringBuilder.setSpan(new android.text.style.StyleSpan(0), i3, i4, i6);
        }
    }

    private static void attachColor(android.text.SpannableStringBuilder spannableStringBuilder, int i_renamed, int i2, int i3, int i4, int i5) {
        if (i_renamed != i2) {
            spannableStringBuilder.setSpan(new android.text.style.ForegroundColorSpan((i_renamed >>> 8) | ((i_renamed & 255) << 24)), i3, i4, i5 | 33);
        }
    }

    private static void attachFontFamily(android.text.SpannableStringBuilder spannableStringBuilder, java.lang.String str, java.lang.String str2, int i_renamed, int i2, int i3) {
        if (str != str2) {
            spannableStringBuilder.setSpan(new android.text.style.TypefaceSpan(str), i_renamed, i2, i3 | 33);
        }
    }

    private static void assertTrue(boolean z_renamed) throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        if (!z_renamed) {
            throw new com.google.android.exoplayer2.text.SubtitleDecoderException("Unexpected subtitle format.");
        }
    }
}
