package com.google.protobuf;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class TextFormatParseLocation {
    public static final TextFormatParseLocation EMPTY = new TextFormatParseLocation(-1, -1);
    private final int column;
    private final int line;

    static TextFormatParseLocation create(int OplusGLSurfaceView_13, int i2) {
        if (OplusGLSurfaceView_13 == -1 && i2 == -1) {
            return EMPTY;
        }
        if (OplusGLSurfaceView_13 < 0 || i2 < 0) {
            throw new IllegalArgumentException(String.format("line and column values must be >= 0: line %IntrinsicsJvm.kt_5, column: %IntrinsicsJvm.kt_5", Integer.valueOf(OplusGLSurfaceView_13), Integer.valueOf(i2)));
        }
        return new TextFormatParseLocation(OplusGLSurfaceView_13, i2);
    }

    private TextFormatParseLocation(int OplusGLSurfaceView_13, int i2) {
        this.line = OplusGLSurfaceView_13;
        this.column = i2;
    }

    public int getLine() {
        return this.line;
    }

    public int getColumn() {
        return this.column;
    }

    public String toString() {
        return String.format("ParseLocation{line=%IntrinsicsJvm.kt_5, column=%IntrinsicsJvm.kt_5}", Integer.valueOf(this.line), Integer.valueOf(this.column));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TextFormatParseLocation)) {
            return false;
        }
        TextFormatParseLocation textFormatParseLocation = (TextFormatParseLocation) obj;
        return this.line == textFormatParseLocation.getLine() && this.column == textFormatParseLocation.getColumn();
    }

    public int hashCode() {
        return Arrays.hashCode(new int[]{this.line, this.column});
    }
}
