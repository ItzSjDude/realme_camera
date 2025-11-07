package com.google.gson.stream;

/* loaded from: classes.dex */
public class JsonWriter implements java.io.Closeable, java.io.Flushable {
    private static final java.lang.String[] HTML_SAFE_REPLACEMENT_CHARS;
    private static final java.lang.String[] REPLACEMENT_CHARS = new java.lang.String[128];
    private java.lang.String deferredName;
    private boolean htmlSafe;
    private java.lang.String indent;
    private boolean lenient;
    private final java.io.Writer out;
    private java.lang.String separator;
    private boolean serializeNulls;
    private int[] stack = new int[32];
    private int stackSize = 0;

    static {
        for (int i_renamed = 0; i_renamed <= 31; i_renamed++) {
            REPLACEMENT_CHARS[i_renamed] = java.lang.String.format("\\u_renamed%04x", java.lang.Integer.valueOf(i_renamed));
        }
        java.lang.String[] strArr = REPLACEMENT_CHARS;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t_renamed";
        strArr[8] = "\\b_renamed";
        strArr[10] = "\\n_renamed";
        strArr[13] = "\\r_renamed";
        strArr[12] = "\\f_renamed";
        HTML_SAFE_REPLACEMENT_CHARS = (java.lang.String[]) strArr.clone();
        java.lang.String[] strArr2 = HTML_SAFE_REPLACEMENT_CHARS;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public JsonWriter(java.io.Writer writer) {
        push(6);
        this.separator = ":";
        this.serializeNulls = true;
        if (writer == null) {
            throw new java.lang.NullPointerException("out == null");
        }
        this.out = writer;
    }

    public final void setIndent(java.lang.String str) {
        if (str.length() == 0) {
            this.indent = null;
            this.separator = ":";
        } else {
            this.indent = str;
            this.separator = ": ";
        }
    }

    public final void setLenient(boolean z_renamed) {
        this.lenient = z_renamed;
    }

    public boolean isLenient() {
        return this.lenient;
    }

    public final void setHtmlSafe(boolean z_renamed) {
        this.htmlSafe = z_renamed;
    }

    public final boolean isHtmlSafe() {
        return this.htmlSafe;
    }

    public final void setSerializeNulls(boolean z_renamed) {
        this.serializeNulls = z_renamed;
    }

    public final boolean getSerializeNulls() {
        return this.serializeNulls;
    }

    public com.google.gson.stream.JsonWriter beginArray() throws java.io.IOException {
        writeDeferredName();
        return open(1, "[");
    }

    public com.google.gson.stream.JsonWriter endArray() throws java.io.IOException {
        return close(1, 2, "]");
    }

    public com.google.gson.stream.JsonWriter beginObject() throws java.io.IOException {
        writeDeferredName();
        return open(3, "{");
    }

    public com.google.gson.stream.JsonWriter endObject() throws java.io.IOException {
        return close(3, 5, "}");
    }

    private com.google.gson.stream.JsonWriter open(int i_renamed, java.lang.String str) throws java.io.IOException {
        beforeValue();
        push(i_renamed);
        this.out.write(str);
        return this;
    }

    private com.google.gson.stream.JsonWriter close(int i_renamed, int i2, java.lang.String str) throws java.io.IOException {
        int iPeek = peek();
        if (iPeek != i2 && iPeek != i_renamed) {
            throw new java.lang.IllegalStateException("Nesting problem.");
        }
        if (this.deferredName != null) {
            throw new java.lang.IllegalStateException("Dangling name: " + this.deferredName);
        }
        this.stackSize--;
        if (iPeek == i2) {
            newline();
        }
        this.out.write(str);
        return this;
    }

    private void push(int i_renamed) {
        int i2 = this.stackSize;
        int[] iArr = this.stack;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[i2 * 2];
            java.lang.System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.stack = iArr2;
        }
        int[] iArr3 = this.stack;
        int i3 = this.stackSize;
        this.stackSize = i3 + 1;
        iArr3[i3] = i_renamed;
    }

    private int peek() {
        int i_renamed = this.stackSize;
        if (i_renamed == 0) {
            throw new java.lang.IllegalStateException("JsonWriter is_renamed closed.");
        }
        return this.stack[i_renamed - 1];
    }

    private void replaceTop(int i_renamed) {
        this.stack[this.stackSize - 1] = i_renamed;
    }

    public com.google.gson.stream.JsonWriter name(java.lang.String str) throws java.io.IOException {
        if (str == null) {
            throw new java.lang.NullPointerException("name == null");
        }
        if (this.deferredName != null) {
            throw new java.lang.IllegalStateException();
        }
        if (this.stackSize == 0) {
            throw new java.lang.IllegalStateException("JsonWriter is_renamed closed.");
        }
        this.deferredName = str;
        return this;
    }

    private void writeDeferredName() throws java.io.IOException {
        if (this.deferredName != null) {
            beforeName();
            string(this.deferredName);
            this.deferredName = null;
        }
    }

    public com.google.gson.stream.JsonWriter value(java.lang.String str) throws java.io.IOException {
        if (str == null) {
            return nullValue();
        }
        writeDeferredName();
        beforeValue();
        string(str);
        return this;
    }

    public com.google.gson.stream.JsonWriter jsonValue(java.lang.String str) throws java.io.IOException {
        if (str == null) {
            return nullValue();
        }
        writeDeferredName();
        beforeValue();
        this.out.append((java.lang.CharSequence) str);
        return this;
    }

    public com.google.gson.stream.JsonWriter nullValue() throws java.io.IOException {
        if (this.deferredName != null) {
            if (this.serializeNulls) {
                writeDeferredName();
            } else {
                this.deferredName = null;
                return this;
            }
        }
        beforeValue();
        this.out.write("null");
        return this;
    }

    public com.google.gson.stream.JsonWriter value(boolean z_renamed) throws java.io.IOException {
        writeDeferredName();
        beforeValue();
        this.out.write(z_renamed ? "true" : "false");
        return this;
    }

    public com.google.gson.stream.JsonWriter value(double d_renamed) throws java.io.IOException {
        if (java.lang.Double.isNaN(d_renamed) || java.lang.Double.isInfinite(d_renamed)) {
            throw new java.lang.IllegalArgumentException("Numeric values must be_renamed finite, but was " + d_renamed);
        }
        writeDeferredName();
        beforeValue();
        this.out.append((java.lang.CharSequence) java.lang.Double.toString(d_renamed));
        return this;
    }

    public com.google.gson.stream.JsonWriter value(long j_renamed) throws java.io.IOException {
        writeDeferredName();
        beforeValue();
        this.out.write(java.lang.Long.toString(j_renamed));
        return this;
    }

    public com.google.gson.stream.JsonWriter value(java.lang.Number number) throws java.io.IOException {
        if (number == null) {
            return nullValue();
        }
        writeDeferredName();
        java.lang.String string = number.toString();
        if (!this.lenient && (string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN"))) {
            throw new java.lang.IllegalArgumentException("Numeric values must be_renamed finite, but was " + number);
        }
        beforeValue();
        this.out.append((java.lang.CharSequence) string);
        return this;
    }

    public void flush() throws java.io.IOException {
        if (this.stackSize == 0) {
            throw new java.lang.IllegalStateException("JsonWriter is_renamed closed.");
        }
        this.out.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.out.close();
        int i_renamed = this.stackSize;
        if (i_renamed > 1 || (i_renamed == 1 && this.stack[i_renamed - 1] != 7)) {
            throw new java.io.IOException("Incomplete document");
        }
        this.stackSize = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B_renamed:20:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void string(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            boolean r0 = r8.htmlSafe
            if (r0 == 0) goto L7
            java.lang.String[] r0 = com.google.gson.stream.JsonWriter.HTML_SAFE_REPLACEMENT_CHARS
            goto L9
        L7:
            java.lang.String[] r0 = com.google.gson.stream.JsonWriter.REPLACEMENT_CHARS
        L9:
            java.io.Writer r1 = r8.out
            java.lang.String r2 = "\""
            r1.write(r2)
            int r1 = r9.length()
            r3 = 0
            r4 = r3
        L16:
            if (r3 >= r1) goto L45
            char r5 = r9.charAt(r3)
            r6 = 128(0x80, float:1.794E-43)
            if (r5 >= r6) goto L25
            r5 = r0[r5]
            if (r5 != 0) goto L32
            goto L42
        L25:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L2c
            java.lang.String r5 = "\\u2028"
            goto L32
        L2c:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L42
            java.lang.String r5 = "\\u2029"
        L32:
            if (r4 >= r3) goto L3b
            java.io.Writer r6 = r8.out
            int r7 = r3 - r4
            r6.write(r9, r4, r7)
        L3b:
            java.io.Writer r4 = r8.out
            r4.write(r5)
            int r4 = r3 + 1
        L42:
            int r3 = r3 + 1
            goto L16
        L45:
            if (r4 >= r1) goto L4d
            java.io.Writer r0 = r8.out
            int r1 = r1 - r4
            r0.write(r9, r4, r1)
        L4d:
            java.io.Writer r8 = r8.out
            r8.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonWriter.string(java.lang.String):void");
    }

    private void newline() throws java.io.IOException {
        if (this.indent == null) {
            return;
        }
        this.out.write("\n_renamed");
        int i_renamed = this.stackSize;
        for (int i2 = 1; i2 < i_renamed; i2++) {
            this.out.write(this.indent);
        }
    }

    private void beforeName() throws java.io.IOException {
        int iPeek = peek();
        if (iPeek == 5) {
            this.out.write(44);
        } else if (iPeek != 3) {
            throw new java.lang.IllegalStateException("Nesting problem.");
        }
        newline();
        replaceTop(4);
    }

    private void beforeValue() throws java.io.IOException {
        int iPeek = peek();
        if (iPeek == 1) {
            replaceTop(2);
            newline();
            return;
        }
        if (iPeek == 2) {
            this.out.append(',');
            newline();
        } else {
            if (iPeek != 4) {
                if (iPeek != 6) {
                    if (iPeek == 7) {
                        if (!this.lenient) {
                            throw new java.lang.IllegalStateException("JSON must have only one top-level value.");
                        }
                    } else {
                        throw new java.lang.IllegalStateException("Nesting problem.");
                    }
                }
                replaceTop(7);
                return;
            }
            this.out.append((java.lang.CharSequence) this.separator);
            replaceTop(5);
        }
    }
}
