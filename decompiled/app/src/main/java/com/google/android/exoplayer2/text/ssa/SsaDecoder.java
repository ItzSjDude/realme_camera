package com.google.android.exoplayer2.text.ssa;

/* loaded from: classes.dex */
public final class SsaDecoder extends com.google.android.exoplayer2.text.SimpleSubtitleDecoder {
    private static final java.lang.String DIALOGUE_LINE_PREFIX = "Dialogue: ";
    private static final java.lang.String FORMAT_LINE_PREFIX = "Format: ";
    private static final java.util.regex.Pattern SSA_TIMECODE_PATTERN = java.util.regex.Pattern.compile("(?:(\\d_renamed+):)?(\\d_renamed+):(\\d_renamed+)(?::|\\.)(\\d_renamed+)");
    private static final java.lang.String TAG = "SsaDecoder";
    private int formatEndIndex;
    private int formatKeyCount;
    private int formatStartIndex;
    private int formatTextIndex;
    private final boolean haveInitializationData;

    public SsaDecoder() {
        this(null);
    }

    public SsaDecoder(java.util.List<byte[]> list) {
        super(TAG);
        if (list != null && !list.isEmpty()) {
            this.haveInitializationData = true;
            java.lang.String strFromUtf8Bytes = com.google.android.exoplayer2.util.Util.fromUtf8Bytes(list.get(0));
            com.google.android.exoplayer2.util.Assertions.checkArgument(strFromUtf8Bytes.startsWith(FORMAT_LINE_PREFIX));
            parseFormatLine(strFromUtf8Bytes);
            parseHeader(new com.google.android.exoplayer2.util.ParsableByteArray(list.get(1)));
            return;
        }
        this.haveInitializationData = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public com.google.android.exoplayer2.text.ssa.SsaSubtitle decode(byte[] bArr, int i_renamed, boolean z_renamed) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        com.google.android.exoplayer2.util.LongArray longArray = new com.google.android.exoplayer2.util.LongArray();
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(bArr, i_renamed);
        if (!this.haveInitializationData) {
            parseHeader(parsableByteArray);
        }
        parseEventBody(parsableByteArray, arrayList, longArray);
        com.google.android.exoplayer2.text.Cue[] cueArr = new com.google.android.exoplayer2.text.Cue[arrayList.size()];
        arrayList.toArray(cueArr);
        return new com.google.android.exoplayer2.text.ssa.SsaSubtitle(cueArr, longArray.toArray());
    }

    private void parseHeader(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        java.lang.String line;
        do {
            line = parsableByteArray.readLine();
            if (line == null) {
                return;
            }
        } while (!line.startsWith("[Events]"));
    }

    private void parseEventBody(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, java.util.List<com.google.android.exoplayer2.text.Cue> list, com.google.android.exoplayer2.util.LongArray longArray) {
        while (true) {
            java.lang.String line = parsableByteArray.readLine();
            if (line == null) {
                return;
            }
            if (!this.haveInitializationData && line.startsWith(FORMAT_LINE_PREFIX)) {
                parseFormatLine(line);
            } else if (line.startsWith(DIALOGUE_LINE_PREFIX)) {
                parseDialogueLine(line, list, longArray);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:21:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void parseFormatLine(java.lang.String r9) {
        /*
            r8 = this;
            r0 = 8
            java.lang.String r9 = r9.substring(r0)
            java.lang.String r0 = ","
            java.lang.String[] r9 = android.text.TextUtils.split(r9, r0)
            int r0 = r9.length
            r8.formatKeyCount = r0
            r0 = -1
            r8.formatStartIndex = r0
            r8.formatEndIndex = r0
            r8.formatTextIndex = r0
            r1 = 0
            r2 = r1
        L18:
            int r3 = r8.formatKeyCount
            if (r2 >= r3) goto L6d
            r3 = r9[r2]
            java.lang.String r3 = r3.trim()
            java.lang.String r3 = com.google.android.exoplayer2.util.Util.toLowerInvariant(r3)
            int r4 = r3.hashCode()
            r5 = 100571(0x188db, float:1.4093E-40)
            r6 = 2
            r7 = 1
            if (r4 == r5) goto L50
            r5 = 3556653(0x36452d, float:4.983932E-39)
            if (r4 == r5) goto L46
            r5 = 109757538(0x68ac462, float:5.219839E-35)
            if (r4 == r5) goto L3c
            goto L5a
        L3c:
            java.lang.String r4 = "start"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L5a
            r3 = r1
            goto L5b
        L46:
            java.lang.String r4 = "text"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L5a
            r3 = r6
            goto L5b
        L50:
            java.lang.String r4 = "end"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L5a
            r3 = r7
            goto L5b
        L5a:
            r3 = r0
        L5b:
            if (r3 == 0) goto L68
            if (r3 == r7) goto L65
            if (r3 == r6) goto L62
            goto L6a
        L62:
            r8.formatTextIndex = r2
            goto L6a
        L65:
            r8.formatEndIndex = r2
            goto L6a
        L68:
            r8.formatStartIndex = r2
        L6a:
            int r2 = r2 + 1
            goto L18
        L6d:
            int r9 = r8.formatStartIndex
            if (r9 == r0) goto L79
            int r9 = r8.formatEndIndex
            if (r9 == r0) goto L79
            int r9 = r8.formatTextIndex
            if (r9 != r0) goto L7b
        L79:
            r8.formatKeyCount = r1
        L7b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.text.ssa.SsaDecoder.parseFormatLine(java.lang.String):void");
    }

    private void parseDialogueLine(java.lang.String str, java.util.List<com.google.android.exoplayer2.text.Cue> list, com.google.android.exoplayer2.util.LongArray longArray) {
        long timecodeUs;
        if (this.formatKeyCount == 0) {
            com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Skipping dialogue line before complete format: " + str);
            return;
        }
        java.lang.String[] strArrSplit = str.substring(10).split(",", this.formatKeyCount);
        if (strArrSplit.length != this.formatKeyCount) {
            com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Skipping dialogue line with fewer columns than format: " + str);
            return;
        }
        long timecodeUs2 = parseTimecodeUs(strArrSplit[this.formatStartIndex]);
        if (timecodeUs2 == -9223372036854775807L) {
            com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Skipping invalid timing: " + str);
            return;
        }
        java.lang.String str2 = strArrSplit[this.formatEndIndex];
        if (str2.trim().isEmpty()) {
            timecodeUs = -9223372036854775807L;
        } else {
            timecodeUs = parseTimecodeUs(str2);
            if (timecodeUs == -9223372036854775807L) {
                com.google.android.exoplayer2.util.Log.w_renamed(TAG, "Skipping invalid timing: " + str);
                return;
            }
        }
        list.add(new com.google.android.exoplayer2.text.Cue(strArrSplit[this.formatTextIndex].replaceAll("\\{.*?\\}", "").replaceAll("\\\\N_renamed", "\n_renamed").replaceAll("\\\\n_renamed", "\n_renamed")));
        longArray.add(timecodeUs2);
        if (timecodeUs != -9223372036854775807L) {
            list.add(null);
            longArray.add(timecodeUs);
        }
    }

    public static long parseTimecodeUs(java.lang.String str) {
        java.util.regex.Matcher matcher = SSA_TIMECODE_PATTERN.matcher(str);
        if (matcher.matches()) {
            return (java.lang.Long.parseLong(matcher.group(1)) * 60 * 60 * 1000000) + (java.lang.Long.parseLong(matcher.group(2)) * 60 * 1000000) + (java.lang.Long.parseLong(matcher.group(3)) * 1000000) + (java.lang.Long.parseLong(matcher.group(4)) * 10000);
        }
        return -9223372036854775807L;
    }
}
