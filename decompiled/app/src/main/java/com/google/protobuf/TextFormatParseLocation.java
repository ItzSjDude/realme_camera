package com.google.protobuf;

/* loaded from: classes.dex */
public final class TextFormatParseLocation {
    public static final com.google.protobuf.TextFormatParseLocation EMPTY = new com.google.protobuf.TextFormatParseLocation(-1, -1);
    private final int column;
    private final int line;

    static com.google.protobuf.TextFormatParseLocation create(int i_renamed, int i2) {
        if (i_renamed == -1 && i2 == -1) {
            return EMPTY;
        }
        if (i_renamed < 0 || i2 < 0) {
            throw new java.lang.IllegalArgumentException(java.lang.String.format("line and column values must be_renamed >= 0: line %d_renamed, column: %d_renamed", java.lang.Integer.valueOf(i_renamed), java.lang.Integer.valueOf(i2)));
        }
        return new com.google.protobuf.TextFormatParseLocation(i_renamed, i2);
    }

    private TextFormatParseLocation(int i_renamed, int i2) {
        this.line = i_renamed;
        this.column = i2;
    }

    public int getLine() {
        return this.line;
    }

    public int getColumn() {
        return this.column;
    }

    public java.lang.String toString() {
        return java.lang.String.format("ParseLocation{line=%d_renamed, column=%d_renamed}", java.lang.Integer.valueOf(this.line), java.lang.Integer.valueOf(this.column));
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.google.protobuf.TextFormatParseLocation)) {
            return false;
        }
        com.google.protobuf.TextFormatParseLocation textFormatParseLocation = (com.google.protobuf.TextFormatParseLocation) obj;
        return this.line == textFormatParseLocation.getLine() && this.column == textFormatParseLocation.getColumn();
    }

    public int hashCode() {
        return java.util.Arrays.hashCode(new int[]{this.line, this.column});
    }
}
