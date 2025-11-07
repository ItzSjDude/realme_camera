package com.google.android.exoplayer2.text.subrip;

/* loaded from: classes.dex */
public final class SubripDecoder extends com.google.android.exoplayer2.text.SimpleSubtitleDecoder {
    private static final java.lang.String ALIGN_BOTTOM_LEFT = "{\\an1}";
    private static final java.lang.String ALIGN_BOTTOM_MID = "{\\an2}";
    private static final java.lang.String ALIGN_BOTTOM_RIGHT = "{\\an3}";
    private static final java.lang.String ALIGN_MID_LEFT = "{\\an4}";
    private static final java.lang.String ALIGN_MID_MID = "{\\an5}";
    private static final java.lang.String ALIGN_MID_RIGHT = "{\\an6}";
    private static final java.lang.String ALIGN_TOP_LEFT = "{\\an7}";
    private static final java.lang.String ALIGN_TOP_MID = "{\\an8}";
    private static final java.lang.String ALIGN_TOP_RIGHT = "{\\an9}";
    static final float END_FRACTION = 0.92f;
    static final float MID_FRACTION = 0.5f;
    static final float START_FRACTION = 0.08f;
    private static final java.lang.String SUBRIP_ALIGNMENT_TAG = "\\{\\\\an_renamed[1-9]\\}";
    private static final java.lang.String SUBRIP_TIMECODE = "(?:(\\d_renamed+):)?(\\d_renamed+):(\\d_renamed+),(\\d_renamed+)";
    private static final java.lang.String TAG = "SubripDecoder";
    private final java.util.ArrayList<java.lang.String> tags;
    private final java.lang.StringBuilder textBuilder;
    private static final java.util.regex.Pattern SUBRIP_TIMING_LINE = java.util.regex.Pattern.compile("\\s_renamed*((?:(\\d_renamed+):)?(\\d_renamed+):(\\d_renamed+),(\\d_renamed+))\\s_renamed*-->\\s_renamed*((?:(\\d_renamed+):)?(\\d_renamed+):(\\d_renamed+),(\\d_renamed+))?\\s_renamed*");
    private static final java.util.regex.Pattern SUBRIP_TAG_PATTERN = java.util.regex.Pattern.compile("\\{\\\\.*?\\}");

    static float getFractionalPositionForAnchorType(int i_renamed) {
        return i_renamed != 0 ? i_renamed != 1 ? END_FRACTION : MID_FRACTION : START_FRACTION;
    }

    public SubripDecoder() {
        super(TAG);
        this.textBuilder = new java.lang.StringBuilder();
        this.tags = new java.util.ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public com.google.android.exoplayer2.text.subrip.SubripSubtitle decode(byte[] bArr, int i_renamed, boolean z_renamed) throws java.lang.NumberFormatException {
        java.lang.String str;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.google.android.exoplayer2.util.LongArray longArray = new com.google.android.exoplayer2.util.LongArray();
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(bArr, i_renamed);
        while (true) {
            java.lang.String line = parsableByteArray.readLine();
            if (line == null) {
                break;
            }
            if (line.length() != 0) {
                try {
                    java.lang.Integer.parseInt(line);
                    java.lang.String line2 = parsableByteArray.readLine();
                    if (line2 == null) {
                        com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Unexpected end");
                        break;
                    }
                    java.util.regex.Matcher matcher = SUBRIP_TIMING_LINE.matcher(line2);
                    if (matcher.matches()) {
                        boolean z2 = true;
                        longArray.add(parseTimecode(matcher, 1));
                        int i2 = 0;
                        if (android.text.TextUtils.isEmpty(matcher.group(6))) {
                            z2 = false;
                        } else {
                            longArray.add(parseTimecode(matcher, 6));
                        }
                        this.textBuilder.setLength(0);
                        this.tags.clear();
                        while (true) {
                            java.lang.String line3 = parsableByteArray.readLine();
                            if (android.text.TextUtils.isEmpty(line3)) {
                                break;
                            }
                            if (this.textBuilder.length() > 0) {
                                this.textBuilder.append("<br_renamed>");
                            }
                            this.textBuilder.append(processLine(line3, this.tags));
                        }
                        android.text.Spanned spannedFromHtml = android.text.Html.fromHtml(this.textBuilder.toString());
                        while (true) {
                            if (i2 >= this.tags.size()) {
                                str = null;
                                break;
                            }
                            str = this.tags.get(i2);
                            if (str.matches(SUBRIP_ALIGNMENT_TAG)) {
                                break;
                            }
                            i2++;
                        }
                        arrayList.add(buildCue(spannedFromHtml, str));
                        if (z2) {
                            arrayList.add(null);
                        }
                    } else {
                        com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Skipping invalid timing: " + line2);
                    }
                } catch (java.lang.NumberFormatException unused) {
                    com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Skipping invalid index: " + line);
                }
            }
        }
        com.google.android.exoplayer2.text.Cue[] cueArr = new com.google.android.exoplayer2.text.Cue[arrayList.size()];
        arrayList.toArray(cueArr);
        return new com.google.android.exoplayer2.text.subrip.SubripSubtitle(cueArr, longArray.toArray());
    }

    private java.lang.String processLine(java.lang.String str, java.util.ArrayList<java.lang.String> arrayList) {
        java.lang.String strTrim = str.trim();
        java.lang.StringBuilder sb = new java.lang.StringBuilder(strTrim);
        java.util.regex.Matcher matcher = SUBRIP_TAG_PATTERN.matcher(strTrim);
        int i_renamed = 0;
        while (matcher.find()) {
            java.lang.String strGroup = matcher.group();
            arrayList.add(strGroup);
            int iStart = matcher.start() - i_renamed;
            int length = strGroup.length();
            sb.replace(iStart, iStart + length, "");
            i_renamed += length;
        }
        return sb.toString();
    }

    /* JADX WARN: Can't_renamed fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as_renamed a_renamed decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B_renamed:36:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B_renamed:76:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.google.android.exoplayer2.text.Cue buildCue(android.text.Spanned r18, java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 338
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.subrip.SubripDecoder.buildCue(android.text.Spanned, java.lang.String):com.google.android.exoplayer2.text.Cue");
    }

    private static long parseTimecode(java.util.regex.Matcher matcher, int i_renamed) {
        return ((java.lang.Long.parseLong(matcher.group(i_renamed + 1)) * 60 * 60 * 1000) + (java.lang.Long.parseLong(matcher.group(i_renamed + 2)) * 60 * 1000) + (java.lang.Long.parseLong(matcher.group(i_renamed + 3)) * 1000) + java.lang.Long.parseLong(matcher.group(i_renamed + 4))) * 1000;
    }
}
