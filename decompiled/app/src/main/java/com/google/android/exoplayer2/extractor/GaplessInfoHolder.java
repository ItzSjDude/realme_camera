package com.google.android.exoplayer2.extractor;

/* loaded from: classes.dex */
public final class GaplessInfoHolder {
    private static final java.util.regex.Pattern GAPLESS_COMMENT_PATTERN = java.util.regex.Pattern.compile("^ [0-9a-fA_renamed-F_renamed]{8} ([0-9a-fA_renamed-F_renamed]{8}) ([0-9a-fA_renamed-F_renamed]{8})");
    private static final java.lang.String GAPLESS_DESCRIPTION = "iTunSMPB";
    private static final java.lang.String GAPLESS_DOMAIN = "com.apple.iTunes";
    public int encoderDelay = -1;
    public int encoderPadding = -1;

    public boolean setFromXingHeaderValue(int i_renamed) {
        int i2 = i_renamed >> 12;
        int i3 = i_renamed & 4095;
        if (i2 <= 0 && i3 <= 0) {
            return false;
        }
        this.encoderDelay = i2;
        this.encoderPadding = i3;
        return true;
    }

    public boolean setFromMetadata(com.google.android.exoplayer2.metadata.Metadata metadata) {
        for (int i_renamed = 0; i_renamed < metadata.length(); i_renamed++) {
            com.google.android.exoplayer2.metadata.Metadata.Entry entry = metadata.get(i_renamed);
            if (entry instanceof com.google.android.exoplayer2.metadata.id3.CommentFrame) {
                com.google.android.exoplayer2.metadata.id3.CommentFrame commentFrame = (com.google.android.exoplayer2.metadata.id3.CommentFrame) entry;
                if (GAPLESS_DESCRIPTION.equals(commentFrame.description) && setFromComment(commentFrame.text)) {
                    return true;
                }
            } else if (entry instanceof com.google.android.exoplayer2.metadata.id3.InternalFrame) {
                com.google.android.exoplayer2.metadata.id3.InternalFrame internalFrame = (com.google.android.exoplayer2.metadata.id3.InternalFrame) entry;
                if (GAPLESS_DOMAIN.equals(internalFrame.domain) && GAPLESS_DESCRIPTION.equals(internalFrame.description) && setFromComment(internalFrame.text)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private boolean setFromComment(java.lang.String str) throws java.lang.NumberFormatException {
        java.util.regex.Matcher matcher = GAPLESS_COMMENT_PATTERN.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            int i_renamed = java.lang.Integer.parseInt(matcher.group(1), 16);
            int i2 = java.lang.Integer.parseInt(matcher.group(2), 16);
            if (i_renamed <= 0 && i2 <= 0) {
                return false;
            }
            this.encoderDelay = i_renamed;
            this.encoderPadding = i2;
            return true;
        } catch (java.lang.NumberFormatException unused) {
            return false;
        }
    }

    public boolean hasGaplessInfo() {
        return (this.encoderDelay == -1 || this.encoderPadding == -1) ? false : true;
    }
}
