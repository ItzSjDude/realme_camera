package com.google.android.exoplayer2.text.webvtt;

/* loaded from: classes.dex */
public final class WebvttDecoder extends com.google.android.exoplayer2.text.SimpleSubtitleDecoder {
    private static final java.lang.String COMMENT_START = "NOTE";
    private static final int EVENT_COMMENT = 1;
    private static final int EVENT_CUE = 3;
    private static final int EVENT_END_OF_FILE = 0;
    private static final int EVENT_NONE = -1;
    private static final int EVENT_STYLE_BLOCK = 2;
    private static final java.lang.String STYLE_START = "STYLE";
    private final com.google.android.exoplayer2.text.webvtt.CssParser cssParser;
    private final com.google.android.exoplayer2.text.webvtt.WebvttCueParser cueParser;
    private final java.util.List<com.google.android.exoplayer2.text.webvtt.WebvttCssStyle> definedStyles;
    private final com.google.android.exoplayer2.util.ParsableByteArray parsableWebvttData;
    private final com.google.android.exoplayer2.text.webvtt.WebvttCue.Builder webvttCueBuilder;

    public WebvttDecoder() {
        super("WebvttDecoder");
        this.cueParser = new com.google.android.exoplayer2.text.webvtt.WebvttCueParser();
        this.parsableWebvttData = new com.google.android.exoplayer2.util.ParsableByteArray();
        this.webvttCueBuilder = new com.google.android.exoplayer2.text.webvtt.WebvttCue.Builder();
        this.cssParser = new com.google.android.exoplayer2.text.webvtt.CssParser();
        this.definedStyles = new java.util.ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public com.google.android.exoplayer2.text.webvtt.WebvttSubtitle decode(byte[] bArr, int i_renamed, boolean z_renamed) throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        this.parsableWebvttData.reset(bArr, i_renamed);
        this.webvttCueBuilder.reset();
        this.definedStyles.clear();
        try {
            com.google.android.exoplayer2.text.webvtt.WebvttParserUtil.validateWebvttHeaderLine(this.parsableWebvttData);
            while (!android.text.TextUtils.isEmpty(this.parsableWebvttData.readLine())) {
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            while (true) {
                int nextEvent = getNextEvent(this.parsableWebvttData);
                if (nextEvent == 0) {
                    return new com.google.android.exoplayer2.text.webvtt.WebvttSubtitle(arrayList);
                }
                if (nextEvent == 1) {
                    skipComment(this.parsableWebvttData);
                } else if (nextEvent == 2) {
                    if (!arrayList.isEmpty()) {
                        throw new com.google.android.exoplayer2.text.SubtitleDecoderException("A_renamed style block was found after the first cue.");
                    }
                    this.parsableWebvttData.readLine();
                    com.google.android.exoplayer2.text.webvtt.WebvttCssStyle block = this.cssParser.parseBlock(this.parsableWebvttData);
                    if (block != null) {
                        this.definedStyles.add(block);
                    }
                } else if (nextEvent == 3 && this.cueParser.parseCue(this.parsableWebvttData, this.webvttCueBuilder, this.definedStyles)) {
                    arrayList.add(this.webvttCueBuilder.build());
                    this.webvttCueBuilder.reset();
                }
            }
        } catch (com.google.android.exoplayer2.ParserException e_renamed) {
            throw new com.google.android.exoplayer2.text.SubtitleDecoderException(e_renamed);
        }
    }

    private static int getNextEvent(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int position = 0;
        int i_renamed = -1;
        while (i_renamed == -1) {
            position = parsableByteArray.getPosition();
            java.lang.String line = parsableByteArray.readLine();
            if (line == null) {
                i_renamed = 0;
            } else if (STYLE_START.equals(line)) {
                i_renamed = 2;
            } else {
                i_renamed = line.startsWith(COMMENT_START) ? 1 : 3;
            }
        }
        parsableByteArray.setPosition(position);
        return i_renamed;
    }

    private static void skipComment(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        while (!android.text.TextUtils.isEmpty(parsableByteArray.readLine())) {
        }
    }
}
