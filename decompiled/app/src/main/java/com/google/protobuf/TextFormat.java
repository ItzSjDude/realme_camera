package com.google.protobuf;

/* loaded from: classes.dex */
public final class TextFormat {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(com.google.protobuf.TextFormat.class.getName());
    private static final com.google.protobuf.TextFormat.Parser PARSER = com.google.protobuf.TextFormat.Parser.newBuilder().build();

    private static int digitValue(byte b2) {
        if (48 > b2 || b2 > 57) {
            return ((97 > b2 || b2 > 122) ? b2 - 65 : b2 - 97) + 10;
        }
        return b2 - 48;
    }

    private static boolean isHex(byte b2) {
        return (48 <= b2 && b2 <= 57) || (97 <= b2 && b2 <= 102) || (65 <= b2 && b2 <= 70);
    }

    private static boolean isOctal(byte b2) {
        return 48 <= b2 && b2 <= 55;
    }

    private TextFormat() {
    }

    @java.lang.Deprecated
    public static void print(com.google.protobuf.MessageOrBuilder messageOrBuilder, java.lang.Appendable appendable) throws java.io.IOException {
        printer().print(messageOrBuilder, appendable);
    }

    @java.lang.Deprecated
    public static void print(com.google.protobuf.UnknownFieldSet unknownFieldSet, java.lang.Appendable appendable) throws java.io.IOException {
        printer().print(unknownFieldSet, appendable);
    }

    @java.lang.Deprecated
    public static void printUnicode(com.google.protobuf.MessageOrBuilder messageOrBuilder, java.lang.Appendable appendable) throws java.io.IOException {
        printer().escapingNonAscii(false).print(messageOrBuilder, appendable);
    }

    @java.lang.Deprecated
    public static void printUnicode(com.google.protobuf.UnknownFieldSet unknownFieldSet, java.lang.Appendable appendable) throws java.io.IOException {
        printer().escapingNonAscii(false).print(unknownFieldSet, appendable);
    }

    public static java.lang.String shortDebugString(com.google.protobuf.MessageOrBuilder messageOrBuilder) {
        return printer().shortDebugString(messageOrBuilder);
    }

    @java.lang.Deprecated
    public static java.lang.String shortDebugString(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
        return printer().shortDebugString(fieldDescriptor, obj);
    }

    @java.lang.Deprecated
    public static java.lang.String shortDebugString(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
        return printer().shortDebugString(unknownFieldSet);
    }

    @java.lang.Deprecated
    public static java.lang.String printToString(com.google.protobuf.MessageOrBuilder messageOrBuilder) {
        return printer().printToString(messageOrBuilder);
    }

    @java.lang.Deprecated
    public static java.lang.String printToString(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
        return printer().printToString(unknownFieldSet);
    }

    @java.lang.Deprecated
    public static java.lang.String printToUnicodeString(com.google.protobuf.MessageOrBuilder messageOrBuilder) {
        return printer().escapingNonAscii(false).printToString(messageOrBuilder);
    }

    @java.lang.Deprecated
    public static java.lang.String printToUnicodeString(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
        return printer().escapingNonAscii(false).printToString(unknownFieldSet);
    }

    @java.lang.Deprecated
    public static void printField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj, java.lang.Appendable appendable) throws java.io.IOException {
        printer().printField(fieldDescriptor, obj, appendable);
    }

    @java.lang.Deprecated
    public static java.lang.String printFieldToString(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
        return printer().printFieldToString(fieldDescriptor, obj);
    }

    @java.lang.Deprecated
    public static void printUnicodeFieldValue(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj, java.lang.Appendable appendable) throws java.io.IOException {
        printer().escapingNonAscii(false).printFieldValue(fieldDescriptor, obj, appendable);
    }

    @java.lang.Deprecated
    public static void printFieldValue(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj, java.lang.Appendable appendable) throws java.io.IOException {
        printer().printFieldValue(fieldDescriptor, obj, appendable);
    }

    public static void printUnknownFieldValue(int i_renamed, java.lang.Object obj, java.lang.Appendable appendable) throws java.io.IOException {
        printUnknownFieldValue(i_renamed, obj, multiLineOutput(appendable));
    }

    private static void printUnknownFieldValue(int i_renamed, java.lang.Object obj, com.google.protobuf.TextFormat.TextGenerator textGenerator) throws java.io.IOException {
        int tagWireType = com.google.protobuf.WireFormat.getTagWireType(i_renamed);
        if (tagWireType == 0) {
            textGenerator.print(unsignedToString(((java.lang.Long) obj).longValue()));
            return;
        }
        if (tagWireType == 1) {
            textGenerator.print(java.lang.String.format((java.util.Locale) null, "0x%016x", (java.lang.Long) obj));
            return;
        }
        if (tagWireType != 2) {
            if (tagWireType == 3) {
                com.google.protobuf.TextFormat.Printer.printUnknownFields((com.google.protobuf.UnknownFieldSet) obj, textGenerator);
                return;
            } else {
                if (tagWireType == 5) {
                    textGenerator.print(java.lang.String.format((java.util.Locale) null, "0x%08x", (java.lang.Integer) obj));
                    return;
                }
                throw new java.lang.IllegalArgumentException("Bad tag: " + i_renamed);
            }
        }
        try {
            com.google.protobuf.UnknownFieldSet from = com.google.protobuf.UnknownFieldSet.parseFrom((com.google.protobuf.ByteString) obj);
            textGenerator.print("{");
            textGenerator.eol();
            textGenerator.indent();
            com.google.protobuf.TextFormat.Printer.printUnknownFields(from, textGenerator);
            textGenerator.outdent();
            textGenerator.print("}");
        } catch (com.google.protobuf.InvalidProtocolBufferException unused) {
            textGenerator.print("\"");
            textGenerator.print(escapeBytes((com.google.protobuf.ByteString) obj));
            textGenerator.print("\"");
        }
    }

    public static com.google.protobuf.TextFormat.Printer printer() {
        return com.google.protobuf.TextFormat.Printer.DEFAULT;
    }

    public static final class Printer {
        private static final com.google.protobuf.TextFormat.Printer DEFAULT = new com.google.protobuf.TextFormat.Printer(true, com.google.protobuf.TypeRegistry.getEmptyTypeRegistry());
        private final boolean escapeNonAscii;
        private final com.google.protobuf.TypeRegistry typeRegistry;

        private Printer(boolean z_renamed, com.google.protobuf.TypeRegistry typeRegistry) {
            this.escapeNonAscii = z_renamed;
            this.typeRegistry = typeRegistry;
        }

        public com.google.protobuf.TextFormat.Printer escapingNonAscii(boolean z_renamed) {
            return new com.google.protobuf.TextFormat.Printer(z_renamed, this.typeRegistry);
        }

        public com.google.protobuf.TextFormat.Printer usingTypeRegistry(com.google.protobuf.TypeRegistry typeRegistry) {
            if (this.typeRegistry != com.google.protobuf.TypeRegistry.getEmptyTypeRegistry()) {
                throw new java.lang.IllegalArgumentException("Only one typeRegistry is_renamed allowed.");
            }
            return new com.google.protobuf.TextFormat.Printer(this.escapeNonAscii, typeRegistry);
        }

        public void print(com.google.protobuf.MessageOrBuilder messageOrBuilder, java.lang.Appendable appendable) throws java.io.IOException {
            print(messageOrBuilder, com.google.protobuf.TextFormat.multiLineOutput(appendable));
        }

        public void print(com.google.protobuf.UnknownFieldSet unknownFieldSet, java.lang.Appendable appendable) throws java.io.IOException {
            printUnknownFields(unknownFieldSet, com.google.protobuf.TextFormat.multiLineOutput(appendable));
        }

        private void print(com.google.protobuf.MessageOrBuilder messageOrBuilder, com.google.protobuf.TextFormat.TextGenerator textGenerator) throws java.io.IOException {
            if (messageOrBuilder.getDescriptorForType().getFullName().equals("google.protobuf.Any") && printAny(messageOrBuilder, textGenerator)) {
                return;
            }
            printMessage(messageOrBuilder, textGenerator);
        }

        private boolean printAny(com.google.protobuf.MessageOrBuilder messageOrBuilder, com.google.protobuf.TextFormat.TextGenerator textGenerator) throws java.io.IOException {
            com.google.protobuf.Descriptors.Descriptor descriptorForType = messageOrBuilder.getDescriptorForType();
            com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptorFindFieldByNumber = descriptorForType.findFieldByNumber(1);
            com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptorFindFieldByNumber2 = descriptorForType.findFieldByNumber(2);
            if (fieldDescriptorFindFieldByNumber != null && fieldDescriptorFindFieldByNumber.getType() == com.google.protobuf.Descriptors.FieldDescriptor.Type.STRING && fieldDescriptorFindFieldByNumber2 != null && fieldDescriptorFindFieldByNumber2.getType() == com.google.protobuf.Descriptors.FieldDescriptor.Type.BYTES) {
                java.lang.String str = (java.lang.String) messageOrBuilder.getField(fieldDescriptorFindFieldByNumber);
                if (str.isEmpty()) {
                    return false;
                }
                java.lang.Object field = messageOrBuilder.getField(fieldDescriptorFindFieldByNumber2);
                try {
                    com.google.protobuf.Descriptors.Descriptor descriptorForTypeUrl = this.typeRegistry.getDescriptorForTypeUrl(str);
                    if (descriptorForTypeUrl == null) {
                        return false;
                    }
                    com.google.protobuf.DynamicMessage.Builder builderNewBuilderForType = com.google.protobuf.DynamicMessage.getDefaultInstance(descriptorForTypeUrl).newBuilderForType();
                    builderNewBuilderForType.mergeFrom((com.google.protobuf.ByteString) field);
                    textGenerator.print("[");
                    textGenerator.print(str);
                    textGenerator.print("] {");
                    textGenerator.eol();
                    textGenerator.indent();
                    print(builderNewBuilderForType, textGenerator);
                    textGenerator.outdent();
                    textGenerator.print("}");
                    textGenerator.eol();
                    return true;
                } catch (com.google.protobuf.InvalidProtocolBufferException unused) {
                }
            }
            return false;
        }

        public java.lang.String printFieldToString(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
            try {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                printField(fieldDescriptor, obj, sb);
                return sb.toString();
            } catch (java.io.IOException e_renamed) {
                throw new java.lang.IllegalStateException(e_renamed);
            }
        }

        public void printField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj, java.lang.Appendable appendable) throws java.io.IOException {
            printField(fieldDescriptor, obj, com.google.protobuf.TextFormat.multiLineOutput(appendable));
        }

        private void printField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj, com.google.protobuf.TextFormat.TextGenerator textGenerator) throws java.io.IOException {
            if (fieldDescriptor.isRepeated()) {
                java.util.Iterator it = ((java.util.List) obj).iterator();
                while (it.hasNext()) {
                    printSingleField(fieldDescriptor, it.next(), textGenerator);
                }
                return;
            }
            printSingleField(fieldDescriptor, obj, textGenerator);
        }

        public void printFieldValue(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj, java.lang.Appendable appendable) throws java.io.IOException {
            printFieldValue(fieldDescriptor, obj, com.google.protobuf.TextFormat.multiLineOutput(appendable));
        }

        private void printFieldValue(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj, com.google.protobuf.TextFormat.TextGenerator textGenerator) throws java.io.IOException {
            java.lang.String strReplace;
            switch (fieldDescriptor.getType()) {
                case INT32:
                case SINT32:
                case SFIXED32:
                    textGenerator.print(((java.lang.Integer) obj).toString());
                    break;
                case INT64:
                case SINT64:
                case SFIXED64:
                    textGenerator.print(((java.lang.Long) obj).toString());
                    break;
                case BOOL:
                    textGenerator.print(((java.lang.Boolean) obj).toString());
                    break;
                case FLOAT:
                    textGenerator.print(((java.lang.Float) obj).toString());
                    break;
                case DOUBLE:
                    textGenerator.print(((java.lang.Double) obj).toString());
                    break;
                case UINT32:
                case FIXED32:
                    textGenerator.print(com.google.protobuf.TextFormat.unsignedToString(((java.lang.Integer) obj).intValue()));
                    break;
                case UINT64:
                case FIXED64:
                    textGenerator.print(com.google.protobuf.TextFormat.unsignedToString(((java.lang.Long) obj).longValue()));
                    break;
                case STRING:
                    textGenerator.print("\"");
                    if (this.escapeNonAscii) {
                        strReplace = com.google.protobuf.TextFormatEscaper.escapeText((java.lang.String) obj);
                    } else {
                        strReplace = com.google.protobuf.TextFormat.escapeDoubleQuotesAndBackslashes((java.lang.String) obj).replace("\n_renamed", "\\n_renamed");
                    }
                    textGenerator.print(strReplace);
                    textGenerator.print("\"");
                    break;
                case BYTES:
                    textGenerator.print("\"");
                    if (obj instanceof com.google.protobuf.ByteString) {
                        textGenerator.print(com.google.protobuf.TextFormat.escapeBytes((com.google.protobuf.ByteString) obj));
                    } else {
                        textGenerator.print(com.google.protobuf.TextFormat.escapeBytes((byte[]) obj));
                    }
                    textGenerator.print("\"");
                    break;
                case ENUM:
                    textGenerator.print(((com.google.protobuf.Descriptors.EnumValueDescriptor) obj).getName());
                    break;
                case MESSAGE:
                case GROUP:
                    print((com.google.protobuf.Message) obj, textGenerator);
                    break;
            }
        }

        public java.lang.String printToString(com.google.protobuf.MessageOrBuilder messageOrBuilder) {
            try {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                print(messageOrBuilder, sb);
                return sb.toString();
            } catch (java.io.IOException e_renamed) {
                throw new java.lang.IllegalStateException(e_renamed);
            }
        }

        public java.lang.String printToString(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
            try {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                print(unknownFieldSet, sb);
                return sb.toString();
            } catch (java.io.IOException e_renamed) {
                throw new java.lang.IllegalStateException(e_renamed);
            }
        }

        public java.lang.String shortDebugString(com.google.protobuf.MessageOrBuilder messageOrBuilder) {
            try {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                print(messageOrBuilder, com.google.protobuf.TextFormat.singleLineOutput(sb));
                return sb.toString();
            } catch (java.io.IOException e_renamed) {
                throw new java.lang.IllegalStateException(e_renamed);
            }
        }

        public java.lang.String shortDebugString(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj) {
            try {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                printField(fieldDescriptor, obj, com.google.protobuf.TextFormat.singleLineOutput(sb));
                return sb.toString();
            } catch (java.io.IOException e_renamed) {
                throw new java.lang.IllegalStateException(e_renamed);
            }
        }

        public java.lang.String shortDebugString(com.google.protobuf.UnknownFieldSet unknownFieldSet) {
            try {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                printUnknownFields(unknownFieldSet, com.google.protobuf.TextFormat.singleLineOutput(sb));
                return sb.toString();
            } catch (java.io.IOException e_renamed) {
                throw new java.lang.IllegalStateException(e_renamed);
            }
        }

        private static void printUnknownFieldValue(int i_renamed, java.lang.Object obj, com.google.protobuf.TextFormat.TextGenerator textGenerator) throws java.io.IOException {
            int tagWireType = com.google.protobuf.WireFormat.getTagWireType(i_renamed);
            if (tagWireType == 0) {
                textGenerator.print(com.google.protobuf.TextFormat.unsignedToString(((java.lang.Long) obj).longValue()));
                return;
            }
            if (tagWireType == 1) {
                textGenerator.print(java.lang.String.format((java.util.Locale) null, "0x%016x", (java.lang.Long) obj));
                return;
            }
            if (tagWireType != 2) {
                if (tagWireType == 3) {
                    printUnknownFields((com.google.protobuf.UnknownFieldSet) obj, textGenerator);
                    return;
                } else {
                    if (tagWireType == 5) {
                        textGenerator.print(java.lang.String.format((java.util.Locale) null, "0x%08x", (java.lang.Integer) obj));
                        return;
                    }
                    throw new java.lang.IllegalArgumentException("Bad tag: " + i_renamed);
                }
            }
            try {
                com.google.protobuf.UnknownFieldSet from = com.google.protobuf.UnknownFieldSet.parseFrom((com.google.protobuf.ByteString) obj);
                textGenerator.print("{");
                textGenerator.eol();
                textGenerator.indent();
                printUnknownFields(from, textGenerator);
                textGenerator.outdent();
                textGenerator.print("}");
            } catch (com.google.protobuf.InvalidProtocolBufferException unused) {
                textGenerator.print("\"");
                textGenerator.print(com.google.protobuf.TextFormat.escapeBytes((com.google.protobuf.ByteString) obj));
                textGenerator.print("\"");
            }
        }

        private void printMessage(com.google.protobuf.MessageOrBuilder messageOrBuilder, com.google.protobuf.TextFormat.TextGenerator textGenerator) throws java.io.IOException {
            for (java.util.Map.Entry<com.google.protobuf.Descriptors.FieldDescriptor, java.lang.Object> entry : messageOrBuilder.getAllFields().entrySet()) {
                printField(entry.getKey(), entry.getValue(), textGenerator);
            }
            printUnknownFields(messageOrBuilder.getUnknownFields(), textGenerator);
        }

        private void printSingleField(com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, java.lang.Object obj, com.google.protobuf.TextFormat.TextGenerator textGenerator) throws java.io.IOException {
            if (fieldDescriptor.isExtension()) {
                textGenerator.print("[");
                if (fieldDescriptor.getContainingType().getOptions().getMessageSetWireFormat() && fieldDescriptor.getType() == com.google.protobuf.Descriptors.FieldDescriptor.Type.MESSAGE && fieldDescriptor.isOptional() && fieldDescriptor.getExtensionScope() == fieldDescriptor.getMessageType()) {
                    textGenerator.print(fieldDescriptor.getMessageType().getFullName());
                } else {
                    textGenerator.print(fieldDescriptor.getFullName());
                }
                textGenerator.print("]");
            } else if (fieldDescriptor.getType() == com.google.protobuf.Descriptors.FieldDescriptor.Type.GROUP) {
                textGenerator.print(fieldDescriptor.getMessageType().getName());
            } else {
                textGenerator.print(fieldDescriptor.getName());
            }
            if (fieldDescriptor.getJavaType() == com.google.protobuf.Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                textGenerator.print(" {");
                textGenerator.eol();
                textGenerator.indent();
            } else {
                textGenerator.print(": ");
            }
            printFieldValue(fieldDescriptor, obj, textGenerator);
            if (fieldDescriptor.getJavaType() == com.google.protobuf.Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                textGenerator.outdent();
                textGenerator.print("}");
            }
            textGenerator.eol();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void printUnknownFields(com.google.protobuf.UnknownFieldSet unknownFieldSet, com.google.protobuf.TextFormat.TextGenerator textGenerator) throws java.io.IOException {
            for (java.util.Map.Entry<java.lang.Integer, com.google.protobuf.UnknownFieldSet.Field> entry : unknownFieldSet.asMap().entrySet()) {
                int iIntValue = entry.getKey().intValue();
                com.google.protobuf.UnknownFieldSet.Field value = entry.getValue();
                printUnknownField(iIntValue, 0, value.getVarintList(), textGenerator);
                printUnknownField(iIntValue, 5, value.getFixed32List(), textGenerator);
                printUnknownField(iIntValue, 1, value.getFixed64List(), textGenerator);
                printUnknownField(iIntValue, 2, value.getLengthDelimitedList(), textGenerator);
                for (com.google.protobuf.UnknownFieldSet unknownFieldSet2 : value.getGroupList()) {
                    textGenerator.print(entry.getKey().toString());
                    textGenerator.print(" {");
                    textGenerator.eol();
                    textGenerator.indent();
                    printUnknownFields(unknownFieldSet2, textGenerator);
                    textGenerator.outdent();
                    textGenerator.print("}");
                    textGenerator.eol();
                }
            }
        }

        private static void printUnknownField(int i_renamed, int i2, java.util.List<?> list, com.google.protobuf.TextFormat.TextGenerator textGenerator) throws java.io.IOException {
            for (java.lang.Object obj : list) {
                textGenerator.print(java.lang.String.valueOf(i_renamed));
                textGenerator.print(": ");
                printUnknownFieldValue(i2, obj, textGenerator);
                textGenerator.eol();
            }
        }
    }

    public static java.lang.String unsignedToString(int i_renamed) {
        if (i_renamed >= 0) {
            return java.lang.Integer.toString(i_renamed);
        }
        return java.lang.Long.toString(i_renamed & 4294967295L);
    }

    public static java.lang.String unsignedToString(long j_renamed) {
        if (j_renamed >= 0) {
            return java.lang.Long.toString(j_renamed);
        }
        return java.math.BigInteger.valueOf(j_renamed & Long.MAX_VALUE).setBit(63).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.google.protobuf.TextFormat.TextGenerator multiLineOutput(java.lang.Appendable appendable) {
        return new com.google.protobuf.TextFormat.TextGenerator(appendable, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.google.protobuf.TextFormat.TextGenerator singleLineOutput(java.lang.Appendable appendable) {
        return new com.google.protobuf.TextFormat.TextGenerator(appendable, true);
    }

    private static final class TextGenerator {
        private boolean atStartOfLine;
        private final java.lang.StringBuilder indent;
        private final java.lang.Appendable output;
        private final boolean singleLineMode;

        private TextGenerator(java.lang.Appendable appendable, boolean z_renamed) {
            this.indent = new java.lang.StringBuilder();
            this.atStartOfLine = false;
            this.output = appendable;
            this.singleLineMode = z_renamed;
        }

        public void indent() {
            this.indent.append("  ");
        }

        public void outdent() {
            int length = this.indent.length();
            if (length == 0) {
                throw new java.lang.IllegalArgumentException(" Outdent() without matching Indent().");
            }
            this.indent.setLength(length - 2);
        }

        public void print(java.lang.CharSequence charSequence) throws java.io.IOException {
            if (this.atStartOfLine) {
                this.atStartOfLine = false;
                this.output.append(this.singleLineMode ? " " : this.indent);
            }
            this.output.append(charSequence);
        }

        public void eol() throws java.io.IOException {
            if (!this.singleLineMode) {
                this.output.append("\n_renamed");
            }
            this.atStartOfLine = true;
        }
    }

    private static final class Tokenizer {
        private int column;
        private java.lang.String currentToken;
        private int line;
        private final java.util.regex.Matcher matcher;
        private int pos;
        private int previousColumn;
        private int previousLine;
        private final java.lang.CharSequence text;
        private static final java.util.regex.Pattern WHITESPACE = java.util.regex.Pattern.compile("(\\s_renamed|(#.*$))++", 8);
        private static final java.util.regex.Pattern TOKEN = java.util.regex.Pattern.compile("[a_renamed-zA-Z_][0-9a-zA-Z_+-]*+|[.]?[0-9+-][0-9a-zA-Z_.+-]*+|\"([^\"\n_renamed\\\\]|\\\\.)*+(\"|\\\\?$)|'([^'\n_renamed\\\\]|\\\\.)*+('|\\\\?$)", 8);
        private static final java.util.regex.Pattern DOUBLE_INFINITY = java.util.regex.Pattern.compile("-?inf(inity)?", 2);
        private static final java.util.regex.Pattern FLOAT_INFINITY = java.util.regex.Pattern.compile("-?inf(inity)?f_renamed?", 2);
        private static final java.util.regex.Pattern FLOAT_NAN = java.util.regex.Pattern.compile("nanf?", 2);

        private Tokenizer(java.lang.CharSequence charSequence) {
            this.pos = 0;
            this.line = 0;
            this.column = 0;
            this.previousLine = 0;
            this.previousColumn = 0;
            this.text = charSequence;
            this.matcher = WHITESPACE.matcher(charSequence);
            skipWhitespace();
            nextToken();
        }

        int getPreviousLine() {
            return this.previousLine;
        }

        int getPreviousColumn() {
            return this.previousColumn;
        }

        int getLine() {
            return this.line;
        }

        int getColumn() {
            return this.column;
        }

        public boolean atEnd() {
            return this.currentToken.length() == 0;
        }

        public void nextToken() {
            this.previousLine = this.line;
            this.previousColumn = this.column;
            while (this.pos < this.matcher.regionStart()) {
                if (this.text.charAt(this.pos) == '\n_renamed') {
                    this.line++;
                    this.column = 0;
                } else {
                    this.column++;
                }
                this.pos++;
            }
            if (this.matcher.regionStart() == this.matcher.regionEnd()) {
                this.currentToken = "";
                return;
            }
            this.matcher.usePattern(TOKEN);
            if (this.matcher.lookingAt()) {
                this.currentToken = this.matcher.group();
                java.util.regex.Matcher matcher = this.matcher;
                matcher.region(matcher.end(), this.matcher.regionEnd());
            } else {
                this.currentToken = java.lang.String.valueOf(this.text.charAt(this.pos));
                java.util.regex.Matcher matcher2 = this.matcher;
                matcher2.region(this.pos + 1, matcher2.regionEnd());
            }
            skipWhitespace();
        }

        private void skipWhitespace() {
            this.matcher.usePattern(WHITESPACE);
            if (this.matcher.lookingAt()) {
                java.util.regex.Matcher matcher = this.matcher;
                matcher.region(matcher.end(), this.matcher.regionEnd());
            }
        }

        public boolean tryConsume(java.lang.String str) {
            if (!this.currentToken.equals(str)) {
                return false;
            }
            nextToken();
            return true;
        }

        public void consume(java.lang.String str) throws com.google.protobuf.TextFormat.ParseException {
            if (tryConsume(str)) {
                return;
            }
            throw parseException("Expected \"" + str + "\".");
        }

        public boolean lookingAtInteger() {
            if (this.currentToken.length() == 0) {
                return false;
            }
            char cCharAt = this.currentToken.charAt(0);
            return ('0' <= cCharAt && cCharAt <= '9') || cCharAt == '-' || cCharAt == '+';
        }

        public boolean lookingAt(java.lang.String str) {
            return this.currentToken.equals(str);
        }

        public java.lang.String consumeIdentifier() throws com.google.protobuf.TextFormat.ParseException {
            for (int i_renamed = 0; i_renamed < this.currentToken.length(); i_renamed++) {
                char cCharAt = this.currentToken.charAt(i_renamed);
                if (('a_renamed' > cCharAt || cCharAt > 'z_renamed') && (('A_renamed' > cCharAt || cCharAt > 'Z_renamed') && !(('0' <= cCharAt && cCharAt <= '9') || cCharAt == '_' || cCharAt == '.'))) {
                    throw parseException("Expected identifier. Found '" + this.currentToken + "'");
                }
            }
            java.lang.String str = this.currentToken;
            nextToken();
            return str;
        }

        public boolean tryConsumeIdentifier() {
            try {
                consumeIdentifier();
                return true;
            } catch (com.google.protobuf.TextFormat.ParseException unused) {
                return false;
            }
        }

        public int consumeInt32() throws com.google.protobuf.TextFormat.ParseException {
            try {
                int int32 = com.google.protobuf.TextFormat.parseInt32(this.currentToken);
                nextToken();
                return int32;
            } catch (java.lang.NumberFormatException e_renamed) {
                throw integerParseException(e_renamed);
            }
        }

        public int consumeUInt32() throws com.google.protobuf.TextFormat.ParseException {
            try {
                int uInt32 = com.google.protobuf.TextFormat.parseUInt32(this.currentToken);
                nextToken();
                return uInt32;
            } catch (java.lang.NumberFormatException e_renamed) {
                throw integerParseException(e_renamed);
            }
        }

        public long consumeInt64() throws com.google.protobuf.TextFormat.ParseException {
            try {
                long int64 = com.google.protobuf.TextFormat.parseInt64(this.currentToken);
                nextToken();
                return int64;
            } catch (java.lang.NumberFormatException e_renamed) {
                throw integerParseException(e_renamed);
            }
        }

        public boolean tryConsumeInt64() {
            try {
                consumeInt64();
                return true;
            } catch (com.google.protobuf.TextFormat.ParseException unused) {
                return false;
            }
        }

        public long consumeUInt64() throws com.google.protobuf.TextFormat.ParseException {
            try {
                long uInt64 = com.google.protobuf.TextFormat.parseUInt64(this.currentToken);
                nextToken();
                return uInt64;
            } catch (java.lang.NumberFormatException e_renamed) {
                throw integerParseException(e_renamed);
            }
        }

        public boolean tryConsumeUInt64() {
            try {
                consumeUInt64();
                return true;
            } catch (com.google.protobuf.TextFormat.ParseException unused) {
                return false;
            }
        }

        public double consumeDouble() throws com.google.protobuf.TextFormat.ParseException, java.lang.NumberFormatException {
            if (DOUBLE_INFINITY.matcher(this.currentToken).matches()) {
                boolean zStartsWith = this.currentToken.startsWith("-");
                nextToken();
                return zStartsWith ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
            }
            if (this.currentToken.equalsIgnoreCase("nan")) {
                nextToken();
                return Double.NaN;
            }
            try {
                double d_renamed = java.lang.Double.parseDouble(this.currentToken);
                nextToken();
                return d_renamed;
            } catch (java.lang.NumberFormatException e_renamed) {
                throw floatParseException(e_renamed);
            }
        }

        public boolean tryConsumeDouble() throws java.lang.NumberFormatException {
            try {
                consumeDouble();
                return true;
            } catch (com.google.protobuf.TextFormat.ParseException unused) {
                return false;
            }
        }

        public float consumeFloat() throws com.google.protobuf.TextFormat.ParseException, java.lang.NumberFormatException {
            if (FLOAT_INFINITY.matcher(this.currentToken).matches()) {
                boolean zStartsWith = this.currentToken.startsWith("-");
                nextToken();
                return zStartsWith ? Float.NEGATIVE_INFINITY : Float.POSITIVE_INFINITY;
            }
            if (FLOAT_NAN.matcher(this.currentToken).matches()) {
                nextToken();
                return Float.NaN;
            }
            try {
                float f_renamed = java.lang.Float.parseFloat(this.currentToken);
                nextToken();
                return f_renamed;
            } catch (java.lang.NumberFormatException e_renamed) {
                throw floatParseException(e_renamed);
            }
        }

        public boolean tryConsumeFloat() throws java.lang.NumberFormatException {
            try {
                consumeFloat();
                return true;
            } catch (com.google.protobuf.TextFormat.ParseException unused) {
                return false;
            }
        }

        public boolean consumeBoolean() throws com.google.protobuf.TextFormat.ParseException {
            if (this.currentToken.equals("true") || this.currentToken.equals("True") || this.currentToken.equals("t_renamed") || this.currentToken.equals("1")) {
                nextToken();
                return true;
            }
            if (this.currentToken.equals("false") || this.currentToken.equals("False") || this.currentToken.equals("f_renamed") || this.currentToken.equals("0")) {
                nextToken();
                return false;
            }
            throw parseException("Expected \"true\" or \"false\". Found \"" + this.currentToken + "\".");
        }

        public java.lang.String consumeString() throws com.google.protobuf.TextFormat.ParseException {
            return consumeByteString().toStringUtf8();
        }

        public boolean tryConsumeString() {
            try {
                consumeString();
                return true;
            } catch (com.google.protobuf.TextFormat.ParseException unused) {
                return false;
            }
        }

        public com.google.protobuf.ByteString consumeByteString() throws com.google.protobuf.TextFormat.ParseException {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            consumeByteString(arrayList);
            while (true) {
                if (this.currentToken.startsWith("'") || this.currentToken.startsWith("\"")) {
                    consumeByteString(arrayList);
                } else {
                    return com.google.protobuf.ByteString.copyFrom(arrayList);
                }
            }
        }

        private void consumeByteString(java.util.List<com.google.protobuf.ByteString> list) throws com.google.protobuf.TextFormat.ParseException {
            char cCharAt = this.currentToken.length() > 0 ? this.currentToken.charAt(0) : (char) 0;
            if (cCharAt != '\"' && cCharAt != '\'') {
                throw parseException("Expected string.");
            }
            if (this.currentToken.length() >= 2) {
                java.lang.String str = this.currentToken;
                if (str.charAt(str.length() - 1) == cCharAt) {
                    try {
                        com.google.protobuf.ByteString byteStringUnescapeBytes = com.google.protobuf.TextFormat.unescapeBytes(this.currentToken.substring(1, this.currentToken.length() - 1));
                        nextToken();
                        list.add(byteStringUnescapeBytes);
                        return;
                    } catch (com.google.protobuf.TextFormat.InvalidEscapeSequenceException e_renamed) {
                        throw parseException(e_renamed.getMessage());
                    }
                }
            }
            throw parseException("String missing ending quote.");
        }

        public com.google.protobuf.TextFormat.ParseException parseException(java.lang.String str) {
            return new com.google.protobuf.TextFormat.ParseException(this.line + 1, this.column + 1, str);
        }

        public com.google.protobuf.TextFormat.ParseException parseExceptionPreviousToken(java.lang.String str) {
            return new com.google.protobuf.TextFormat.ParseException(this.previousLine + 1, this.previousColumn + 1, str);
        }

        private com.google.protobuf.TextFormat.ParseException integerParseException(java.lang.NumberFormatException numberFormatException) {
            return parseException("Couldn't_renamed parse integer: " + numberFormatException.getMessage());
        }

        private com.google.protobuf.TextFormat.ParseException floatParseException(java.lang.NumberFormatException numberFormatException) {
            return parseException("Couldn't_renamed parse number: " + numberFormatException.getMessage());
        }

        public com.google.protobuf.TextFormat.UnknownFieldParseException unknownFieldParseExceptionPreviousToken(java.lang.String str, java.lang.String str2) {
            return new com.google.protobuf.TextFormat.UnknownFieldParseException(this.previousLine + 1, this.previousColumn + 1, str, str2);
        }
    }

    public static class ParseException extends java.io.IOException {
        private static final long serialVersionUID = 3196188060225107702L;
        private final int column;
        private final int line;

        public ParseException(java.lang.String str) {
            this(-1, -1, str);
        }

        public ParseException(int i_renamed, int i2, java.lang.String str) {
            super(java.lang.Integer.toString(i_renamed) + ":" + i2 + ": " + str);
            this.line = i_renamed;
            this.column = i2;
        }

        public int getLine() {
            return this.line;
        }

        public int getColumn() {
            return this.column;
        }
    }

    public static class UnknownFieldParseException extends com.google.protobuf.TextFormat.ParseException {
        private final java.lang.String unknownField;

        public UnknownFieldParseException(java.lang.String str) {
            this(-1, -1, "", str);
        }

        public UnknownFieldParseException(int i_renamed, int i2, java.lang.String str, java.lang.String str2) {
            super(i_renamed, i2, str2);
            this.unknownField = str;
        }

        public java.lang.String getUnknownField() {
            return this.unknownField;
        }
    }

    public static com.google.protobuf.TextFormat.Parser getParser() {
        return PARSER;
    }

    public static void merge(java.lang.Readable readable, com.google.protobuf.Message.Builder builder) throws java.io.IOException {
        PARSER.merge(readable, builder);
    }

    public static void merge(java.lang.CharSequence charSequence, com.google.protobuf.Message.Builder builder) throws com.google.protobuf.TextFormat.ParseException {
        PARSER.merge(charSequence, builder);
    }

    public static <T_renamed extends com.google.protobuf.Message> T_renamed parse(java.lang.CharSequence charSequence, java.lang.Class<T_renamed> cls) throws com.google.protobuf.TextFormat.ParseException {
        com.google.protobuf.Message.Builder builderNewBuilderForType = ((com.google.protobuf.Message) com.google.protobuf.Internal.getDefaultInstance(cls)).newBuilderForType();
        merge(charSequence, builderNewBuilderForType);
        return (T_renamed) builderNewBuilderForType.build();
    }

    public static void merge(java.lang.Readable readable, com.google.protobuf.ExtensionRegistry extensionRegistry, com.google.protobuf.Message.Builder builder) throws java.io.IOException {
        PARSER.merge(readable, extensionRegistry, builder);
    }

    public static void merge(java.lang.CharSequence charSequence, com.google.protobuf.ExtensionRegistry extensionRegistry, com.google.protobuf.Message.Builder builder) throws com.google.protobuf.TextFormat.ParseException {
        PARSER.merge(charSequence, extensionRegistry, builder);
    }

    public static <T_renamed extends com.google.protobuf.Message> T_renamed parse(java.lang.CharSequence charSequence, com.google.protobuf.ExtensionRegistry extensionRegistry, java.lang.Class<T_renamed> cls) throws com.google.protobuf.TextFormat.ParseException {
        com.google.protobuf.Message.Builder builderNewBuilderForType = ((com.google.protobuf.Message) com.google.protobuf.Internal.getDefaultInstance(cls)).newBuilderForType();
        merge(charSequence, extensionRegistry, builderNewBuilderForType);
        return (T_renamed) builderNewBuilderForType.build();
    }

    public static class Parser {
        private static final int BUFFER_SIZE = 4096;
        private final boolean allowUnknownEnumValues;
        private final boolean allowUnknownExtensions;
        private final boolean allowUnknownFields;
        private com.google.protobuf.TextFormatParseInfoTree.Builder parseInfoTreeBuilder;
        private final com.google.protobuf.TextFormat.Parser.SingularOverwritePolicy singularOverwritePolicy;
        private final com.google.protobuf.TypeRegistry typeRegistry;

        public enum SingularOverwritePolicy {
            ALLOW_SINGULAR_OVERWRITES,
            FORBID_SINGULAR_OVERWRITES
        }

        private Parser(com.google.protobuf.TypeRegistry typeRegistry, boolean z_renamed, boolean z2, boolean z3, com.google.protobuf.TextFormat.Parser.SingularOverwritePolicy singularOverwritePolicy, com.google.protobuf.TextFormatParseInfoTree.Builder builder) {
            this.typeRegistry = typeRegistry;
            this.allowUnknownFields = z_renamed;
            this.allowUnknownEnumValues = z2;
            this.allowUnknownExtensions = z3;
            this.singularOverwritePolicy = singularOverwritePolicy;
            this.parseInfoTreeBuilder = builder;
        }

        public static com.google.protobuf.TextFormat.Parser.Builder newBuilder() {
            return new com.google.protobuf.TextFormat.Parser.Builder();
        }

        public static class Builder {
            private boolean allowUnknownFields = false;
            private boolean allowUnknownEnumValues = false;
            private boolean allowUnknownExtensions = false;
            private com.google.protobuf.TextFormat.Parser.SingularOverwritePolicy singularOverwritePolicy = com.google.protobuf.TextFormat.Parser.SingularOverwritePolicy.ALLOW_SINGULAR_OVERWRITES;
            private com.google.protobuf.TextFormatParseInfoTree.Builder parseInfoTreeBuilder = null;
            private com.google.protobuf.TypeRegistry typeRegistry = com.google.protobuf.TypeRegistry.getEmptyTypeRegistry();

            public com.google.protobuf.TextFormat.Parser.Builder setTypeRegistry(com.google.protobuf.TypeRegistry typeRegistry) {
                this.typeRegistry = typeRegistry;
                return this;
            }

            public com.google.protobuf.TextFormat.Parser.Builder setAllowUnknownFields(boolean z_renamed) {
                this.allowUnknownFields = z_renamed;
                return this;
            }

            public com.google.protobuf.TextFormat.Parser.Builder setAllowUnknownExtensions(boolean z_renamed) {
                this.allowUnknownExtensions = z_renamed;
                return this;
            }

            public com.google.protobuf.TextFormat.Parser.Builder setSingularOverwritePolicy(com.google.protobuf.TextFormat.Parser.SingularOverwritePolicy singularOverwritePolicy) {
                this.singularOverwritePolicy = singularOverwritePolicy;
                return this;
            }

            public com.google.protobuf.TextFormat.Parser.Builder setParseInfoTreeBuilder(com.google.protobuf.TextFormatParseInfoTree.Builder builder) {
                this.parseInfoTreeBuilder = builder;
                return this;
            }

            public com.google.protobuf.TextFormat.Parser build() {
                return new com.google.protobuf.TextFormat.Parser(this.typeRegistry, this.allowUnknownFields, this.allowUnknownEnumValues, this.allowUnknownExtensions, this.singularOverwritePolicy, this.parseInfoTreeBuilder);
            }
        }

        public void merge(java.lang.Readable readable, com.google.protobuf.Message.Builder builder) throws java.io.IOException {
            merge(readable, com.google.protobuf.ExtensionRegistry.getEmptyRegistry(), builder);
        }

        public void merge(java.lang.CharSequence charSequence, com.google.protobuf.Message.Builder builder) throws com.google.protobuf.TextFormat.ParseException {
            merge(charSequence, com.google.protobuf.ExtensionRegistry.getEmptyRegistry(), builder);
        }

        public void merge(java.lang.Readable readable, com.google.protobuf.ExtensionRegistry extensionRegistry, com.google.protobuf.Message.Builder builder) throws java.io.IOException {
            merge(toStringBuilder(readable), extensionRegistry, builder);
        }

        private static java.lang.StringBuilder toStringBuilder(java.lang.Readable readable) throws java.io.IOException {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.nio.CharBuffer charBufferAllocate = java.nio.CharBuffer.allocate(4096);
            while (true) {
                int i_renamed = readable.read(charBufferAllocate);
                if (i_renamed == -1) {
                    return sb;
                }
                charBufferAllocate.flip();
                sb.append((java.lang.CharSequence) charBufferAllocate, 0, i_renamed);
            }
        }

        static final class UnknownField {
            final java.lang.String message;
            final com.google.protobuf.TextFormat.Parser.UnknownField.Type type;

            enum Type {
                FIELD,
                EXTENSION
            }

            UnknownField(java.lang.String str, com.google.protobuf.TextFormat.Parser.UnknownField.Type type) {
                this.message = str;
                this.type = type;
            }
        }

        private void checkUnknownFields(java.util.List<com.google.protobuf.TextFormat.Parser.UnknownField> list) throws com.google.protobuf.TextFormat.ParseException {
            int i_renamed;
            boolean z_renamed;
            if (list.isEmpty()) {
                return;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder("Input contains unknown fields and/or extensions:");
            for (com.google.protobuf.TextFormat.Parser.UnknownField unknownField : list) {
                sb.append('\n_renamed');
                sb.append(unknownField.message);
            }
            if (this.allowUnknownFields) {
                com.google.protobuf.TextFormat.logger.warning(sb.toString());
                return;
            }
            if (this.allowUnknownExtensions) {
                java.util.Iterator<com.google.protobuf.TextFormat.Parser.UnknownField> it = list.iterator();
                i_renamed = 0;
                while (true) {
                    if (!it.hasNext()) {
                        z_renamed = true;
                        break;
                    } else {
                        if (it.next().type == com.google.protobuf.TextFormat.Parser.UnknownField.Type.FIELD) {
                            z_renamed = false;
                            break;
                        }
                        i_renamed++;
                    }
                }
                if (z_renamed) {
                    com.google.protobuf.TextFormat.logger.warning(sb.toString());
                    return;
                }
            } else {
                i_renamed = 0;
            }
            java.lang.String[] strArrSplit = list.get(i_renamed).message.split(":");
            throw new com.google.protobuf.TextFormat.ParseException(java.lang.Integer.parseInt(strArrSplit[0]), java.lang.Integer.parseInt(strArrSplit[1]), sb.toString());
        }

        public void merge(java.lang.CharSequence charSequence, com.google.protobuf.ExtensionRegistry extensionRegistry, com.google.protobuf.Message.Builder builder) throws com.google.protobuf.TextFormat.ParseException {
            com.google.protobuf.TextFormat.Tokenizer tokenizer = new com.google.protobuf.TextFormat.Tokenizer(charSequence);
            com.google.protobuf.MessageReflection.BuilderAdapter builderAdapter = new com.google.protobuf.MessageReflection.BuilderAdapter(builder);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            while (!tokenizer.atEnd()) {
                mergeField(tokenizer, extensionRegistry, builderAdapter, arrayList);
            }
            checkUnknownFields(arrayList);
        }

        private void mergeField(com.google.protobuf.TextFormat.Tokenizer tokenizer, com.google.protobuf.ExtensionRegistry extensionRegistry, com.google.protobuf.MessageReflection.MergeTarget mergeTarget, java.util.List<com.google.protobuf.TextFormat.Parser.UnknownField> list) throws com.google.protobuf.TextFormat.ParseException {
            mergeField(tokenizer, extensionRegistry, mergeTarget, this.parseInfoTreeBuilder, list);
        }

        private void mergeField(com.google.protobuf.TextFormat.Tokenizer tokenizer, com.google.protobuf.ExtensionRegistry extensionRegistry, com.google.protobuf.MessageReflection.MergeTarget mergeTarget, com.google.protobuf.TextFormatParseInfoTree.Builder builder, java.util.List<com.google.protobuf.TextFormat.Parser.UnknownField> list) throws com.google.protobuf.TextFormat.ParseException {
            com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptorFindFieldByName;
            com.google.protobuf.ExtensionRegistry.ExtensionInfo extensionInfo;
            int line = tokenizer.getLine();
            int column = tokenizer.getColumn();
            com.google.protobuf.Descriptors.Descriptor descriptorForType = mergeTarget.getDescriptorForType();
            com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor = null;
            if (tokenizer.tryConsume("[")) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder(tokenizer.consumeIdentifier());
                while (tokenizer.tryConsume(".")) {
                    sb.append('.');
                    sb.append(tokenizer.consumeIdentifier());
                }
                com.google.protobuf.ExtensionRegistry.ExtensionInfo extensionInfoFindExtensionByName = mergeTarget.findExtensionByName(extensionRegistry, sb.toString());
                if (extensionInfoFindExtensionByName == null) {
                    list.add(new com.google.protobuf.TextFormat.Parser.UnknownField((tokenizer.getPreviousLine() + 1) + ":" + (tokenizer.getPreviousColumn() + 1) + ":\t_renamed" + descriptorForType.getFullName() + ".[" + ((java.lang.Object) sb) + "]", com.google.protobuf.TextFormat.Parser.UnknownField.Type.EXTENSION));
                } else {
                    if (extensionInfoFindExtensionByName.descriptor.getContainingType() != descriptorForType) {
                        throw tokenizer.parseExceptionPreviousToken("Extension \"" + ((java.lang.Object) sb) + "\" does not extend message type \"" + descriptorForType.getFullName() + "\".");
                    }
                    fieldDescriptor = extensionInfoFindExtensionByName.descriptor;
                }
                tokenizer.consume("]");
                extensionInfo = extensionInfoFindExtensionByName;
                fieldDescriptorFindFieldByName = fieldDescriptor;
            } else {
                java.lang.String strConsumeIdentifier = tokenizer.consumeIdentifier();
                fieldDescriptorFindFieldByName = descriptorForType.findFieldByName(strConsumeIdentifier);
                if (fieldDescriptorFindFieldByName == null && (fieldDescriptorFindFieldByName = descriptorForType.findFieldByName(strConsumeIdentifier.toLowerCase(java.util.Locale.US))) != null && fieldDescriptorFindFieldByName.getType() != com.google.protobuf.Descriptors.FieldDescriptor.Type.GROUP) {
                    fieldDescriptorFindFieldByName = null;
                }
                if (fieldDescriptorFindFieldByName != null && fieldDescriptorFindFieldByName.getType() == com.google.protobuf.Descriptors.FieldDescriptor.Type.GROUP && !fieldDescriptorFindFieldByName.getMessageType().getName().equals(strConsumeIdentifier)) {
                    fieldDescriptorFindFieldByName = null;
                }
                if (fieldDescriptorFindFieldByName == null) {
                    list.add(new com.google.protobuf.TextFormat.Parser.UnknownField((tokenizer.getPreviousLine() + 1) + ":" + (tokenizer.getPreviousColumn() + 1) + ":\t_renamed" + descriptorForType.getFullName() + "." + strConsumeIdentifier, com.google.protobuf.TextFormat.Parser.UnknownField.Type.FIELD));
                }
                extensionInfo = null;
            }
            if (fieldDescriptorFindFieldByName == null) {
                if (tokenizer.tryConsume(":") && !tokenizer.lookingAt("{") && !tokenizer.lookingAt("<")) {
                    skipFieldValue(tokenizer);
                    return;
                } else {
                    skipFieldMessage(tokenizer);
                    return;
                }
            }
            if (fieldDescriptorFindFieldByName.getJavaType() == com.google.protobuf.Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                tokenizer.tryConsume(":");
                if (builder != null) {
                    consumeFieldValues(tokenizer, extensionRegistry, mergeTarget, fieldDescriptorFindFieldByName, extensionInfo, builder.getBuilderForSubMessageField(fieldDescriptorFindFieldByName), list);
                } else {
                    consumeFieldValues(tokenizer, extensionRegistry, mergeTarget, fieldDescriptorFindFieldByName, extensionInfo, builder, list);
                }
            } else {
                tokenizer.consume(":");
                consumeFieldValues(tokenizer, extensionRegistry, mergeTarget, fieldDescriptorFindFieldByName, extensionInfo, builder, list);
            }
            if (builder != null) {
                builder.setLocation(fieldDescriptorFindFieldByName, com.google.protobuf.TextFormatParseLocation.create(line, column));
            }
            if (tokenizer.tryConsume(";")) {
                return;
            }
            tokenizer.tryConsume(",");
        }

        private void consumeFieldValues(com.google.protobuf.TextFormat.Tokenizer tokenizer, com.google.protobuf.ExtensionRegistry extensionRegistry, com.google.protobuf.MessageReflection.MergeTarget mergeTarget, com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, com.google.protobuf.ExtensionRegistry.ExtensionInfo extensionInfo, com.google.protobuf.TextFormatParseInfoTree.Builder builder, java.util.List<com.google.protobuf.TextFormat.Parser.UnknownField> list) throws com.google.protobuf.TextFormat.ParseException {
            if (fieldDescriptor.isRepeated() && tokenizer.tryConsume("[")) {
                if (tokenizer.tryConsume("]")) {
                    return;
                }
                while (true) {
                    consumeFieldValue(tokenizer, extensionRegistry, mergeTarget, fieldDescriptor, extensionInfo, builder, list);
                    if (tokenizer.tryConsume("]")) {
                        return;
                    } else {
                        tokenizer.consume(",");
                    }
                }
            } else {
                consumeFieldValue(tokenizer, extensionRegistry, mergeTarget, fieldDescriptor, extensionInfo, builder, list);
            }
        }

        private void consumeFieldValue(com.google.protobuf.TextFormat.Tokenizer tokenizer, com.google.protobuf.ExtensionRegistry extensionRegistry, com.google.protobuf.MessageReflection.MergeTarget mergeTarget, com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, com.google.protobuf.ExtensionRegistry.ExtensionInfo extensionInfo, com.google.protobuf.TextFormatParseInfoTree.Builder builder, java.util.List<com.google.protobuf.TextFormat.Parser.UnknownField> list) throws com.google.protobuf.TextFormat.ParseException {
            java.lang.String str;
            java.lang.Object objFinish;
            if (this.singularOverwritePolicy == com.google.protobuf.TextFormat.Parser.SingularOverwritePolicy.FORBID_SINGULAR_OVERWRITES && !fieldDescriptor.isRepeated()) {
                if (mergeTarget.hasField(fieldDescriptor)) {
                    throw tokenizer.parseExceptionPreviousToken("Non-repeated field \"" + fieldDescriptor.getFullName() + "\" cannot be_renamed overwritten.");
                }
                if (fieldDescriptor.getContainingOneof() != null && mergeTarget.hasOneof(fieldDescriptor.getContainingOneof())) {
                    com.google.protobuf.Descriptors.OneofDescriptor containingOneof = fieldDescriptor.getContainingOneof();
                    throw tokenizer.parseExceptionPreviousToken("Field \"" + fieldDescriptor.getFullName() + "\" is_renamed specified along with field \"" + mergeTarget.getOneofFieldDescriptor(containingOneof).getFullName() + "\", another member of_renamed oneof \"" + containingOneof.getName() + "\".");
                }
            }
            java.lang.Object objValueOf = null;
            if (fieldDescriptor.getJavaType() == com.google.protobuf.Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                if (tokenizer.tryConsume("<")) {
                    str = ">";
                } else {
                    tokenizer.consume("{");
                    str = "}";
                }
                java.lang.String str2 = str;
                if (fieldDescriptor.getMessageType().getFullName().equals("google.protobuf.Any") && tokenizer.tryConsume("[")) {
                    objFinish = consumeAnyFieldValue(tokenizer, extensionRegistry, fieldDescriptor, builder, list);
                    tokenizer.consume(str2);
                } else {
                    com.google.protobuf.MessageReflection.MergeTarget mergeTargetNewMergeTargetForField = mergeTarget.newMergeTargetForField(fieldDescriptor, extensionInfo != null ? extensionInfo.defaultInstance : null);
                    while (!tokenizer.tryConsume(str2)) {
                        if (tokenizer.atEnd()) {
                            throw tokenizer.parseException("Expected \"" + str2 + "\".");
                        }
                        mergeField(tokenizer, extensionRegistry, mergeTargetNewMergeTargetForField, builder, list);
                    }
                    objFinish = mergeTargetNewMergeTargetForField.finish();
                }
                objValueOf = objFinish;
            } else {
                switch (fieldDescriptor.getType()) {
                    case INT32:
                    case SINT32:
                    case SFIXED32:
                        objValueOf = java.lang.Integer.valueOf(tokenizer.consumeInt32());
                        break;
                    case INT64:
                    case SINT64:
                    case SFIXED64:
                        objValueOf = java.lang.Long.valueOf(tokenizer.consumeInt64());
                        break;
                    case BOOL:
                        objValueOf = java.lang.Boolean.valueOf(tokenizer.consumeBoolean());
                        break;
                    case FLOAT:
                        objValueOf = java.lang.Float.valueOf(tokenizer.consumeFloat());
                        break;
                    case DOUBLE:
                        objValueOf = java.lang.Double.valueOf(tokenizer.consumeDouble());
                        break;
                    case UINT32:
                    case FIXED32:
                        objValueOf = java.lang.Integer.valueOf(tokenizer.consumeUInt32());
                        break;
                    case UINT64:
                    case FIXED64:
                        objValueOf = java.lang.Long.valueOf(tokenizer.consumeUInt64());
                        break;
                    case STRING:
                        objValueOf = tokenizer.consumeString();
                        break;
                    case BYTES:
                        objValueOf = tokenizer.consumeByteString();
                        break;
                    case ENUM:
                        com.google.protobuf.Descriptors.EnumDescriptor enumType = fieldDescriptor.getEnumType();
                        if (tokenizer.lookingAtInteger()) {
                            int iConsumeInt32 = tokenizer.consumeInt32();
                            objValueOf = enumType.findValueByNumber(iConsumeInt32);
                            if (objValueOf == null) {
                                java.lang.String str3 = "Enum type \"" + enumType.getFullName() + "\" has no value with number " + iConsumeInt32 + '.';
                                if (this.allowUnknownEnumValues) {
                                    com.google.protobuf.TextFormat.logger.warning(str3);
                                    return;
                                }
                                throw tokenizer.parseExceptionPreviousToken("Enum type \"" + enumType.getFullName() + "\" has no value with number " + iConsumeInt32 + '.');
                            }
                        } else {
                            java.lang.String strConsumeIdentifier = tokenizer.consumeIdentifier();
                            objValueOf = enumType.findValueByName(strConsumeIdentifier);
                            if (objValueOf == null) {
                                java.lang.String str4 = "Enum type \"" + enumType.getFullName() + "\" has no value named \"" + strConsumeIdentifier + "\".";
                                if (this.allowUnknownEnumValues) {
                                    com.google.protobuf.TextFormat.logger.warning(str4);
                                    return;
                                }
                                throw tokenizer.parseExceptionPreviousToken(str4);
                            }
                        }
                        break;
                    case MESSAGE:
                    case GROUP:
                        throw new java.lang.RuntimeException("Can't_renamed get here.");
                }
            }
            if (fieldDescriptor.isRepeated()) {
                mergeTarget.addRepeatedField(fieldDescriptor, objValueOf);
            } else {
                mergeTarget.setField(fieldDescriptor, objValueOf);
            }
        }

        private java.lang.Object consumeAnyFieldValue(com.google.protobuf.TextFormat.Tokenizer tokenizer, com.google.protobuf.ExtensionRegistry extensionRegistry, com.google.protobuf.Descriptors.FieldDescriptor fieldDescriptor, com.google.protobuf.TextFormatParseInfoTree.Builder builder, java.util.List<com.google.protobuf.TextFormat.Parser.UnknownField> list) throws com.google.protobuf.TextFormat.ParseException {
            java.lang.String str;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            while (true) {
                sb.append(tokenizer.consumeIdentifier());
                if (!tokenizer.tryConsume("]")) {
                    if (tokenizer.tryConsume("/")) {
                        sb.append("/");
                    } else if (tokenizer.tryConsume(".")) {
                        sb.append(".");
                    } else {
                        throw tokenizer.parseExceptionPreviousToken("Expected a_renamed valid type URL.");
                    }
                } else {
                    tokenizer.tryConsume(":");
                    if (tokenizer.tryConsume("<")) {
                        str = ">";
                    } else {
                        tokenizer.consume("{");
                        str = "}";
                    }
                    java.lang.String string = sb.toString();
                    try {
                        com.google.protobuf.Descriptors.Descriptor descriptorForTypeUrl = this.typeRegistry.getDescriptorForTypeUrl(string);
                        if (descriptorForTypeUrl == null) {
                            throw tokenizer.parseException("Unable to parse Any of_renamed type: " + string + ". Please make sure that the TypeRegistry contains the descriptors for the given types.");
                        }
                        com.google.protobuf.DynamicMessage.Builder builderNewBuilderForType = com.google.protobuf.DynamicMessage.getDefaultInstance(descriptorForTypeUrl).newBuilderForType();
                        com.google.protobuf.MessageReflection.BuilderAdapter builderAdapter = new com.google.protobuf.MessageReflection.BuilderAdapter(builderNewBuilderForType);
                        while (!tokenizer.tryConsume(str)) {
                            mergeField(tokenizer, extensionRegistry, builderAdapter, builder, list);
                        }
                        com.google.protobuf.Descriptors.Descriptor messageType = fieldDescriptor.getMessageType();
                        com.google.protobuf.DynamicMessage.Builder builderNewBuilderForType2 = com.google.protobuf.DynamicMessage.getDefaultInstance(messageType).newBuilderForType();
                        builderNewBuilderForType2.setField(messageType.findFieldByName("type_url"), (java.lang.Object) sb.toString());
                        builderNewBuilderForType2.setField(messageType.findFieldByName(com.android.providers.downloads.Downloads.Impl.RequestHeaders.COLUMN_VALUE), (java.lang.Object) builderNewBuilderForType.build().toByteString());
                        return builderNewBuilderForType2.build();
                    } catch (com.google.protobuf.InvalidProtocolBufferException unused) {
                        throw tokenizer.parseException("Invalid valid type URL. Found: " + string);
                    }
                }
            }
        }

        private void skipField(com.google.protobuf.TextFormat.Tokenizer tokenizer) throws com.google.protobuf.TextFormat.ParseException {
            if (tokenizer.tryConsume("[")) {
                do {
                    tokenizer.consumeIdentifier();
                } while (tokenizer.tryConsume("."));
                tokenizer.consume("]");
            } else {
                tokenizer.consumeIdentifier();
            }
            if (tokenizer.tryConsume(":") && !tokenizer.lookingAt("<") && !tokenizer.lookingAt("{")) {
                skipFieldValue(tokenizer);
            } else {
                skipFieldMessage(tokenizer);
            }
            if (tokenizer.tryConsume(";")) {
                return;
            }
            tokenizer.tryConsume(",");
        }

        private void skipFieldMessage(com.google.protobuf.TextFormat.Tokenizer tokenizer) throws com.google.protobuf.TextFormat.ParseException {
            java.lang.String str;
            if (tokenizer.tryConsume("<")) {
                str = ">";
            } else {
                tokenizer.consume("{");
                str = "}";
            }
            while (!tokenizer.lookingAt(">") && !tokenizer.lookingAt("}")) {
                skipField(tokenizer);
            }
            tokenizer.consume(str);
        }

        private void skipFieldValue(com.google.protobuf.TextFormat.Tokenizer tokenizer) throws com.google.protobuf.TextFormat.ParseException {
            if (tokenizer.tryConsumeString()) {
                while (tokenizer.tryConsumeString()) {
                }
                return;
            }
            if (tokenizer.tryConsumeIdentifier() || tokenizer.tryConsumeInt64() || tokenizer.tryConsumeUInt64() || tokenizer.tryConsumeDouble() || tokenizer.tryConsumeFloat()) {
                return;
            }
            throw tokenizer.parseException("Invalid field value: " + tokenizer.currentToken);
        }
    }

    public static java.lang.String escapeBytes(com.google.protobuf.ByteString byteString) {
        return com.google.protobuf.TextFormatEscaper.escapeBytes(byteString);
    }

    public static java.lang.String escapeBytes(byte[] bArr) {
        return com.google.protobuf.TextFormatEscaper.escapeBytes(bArr);
    }

    public static com.google.protobuf.ByteString unescapeBytes(java.lang.CharSequence charSequence) throws com.google.protobuf.TextFormat.InvalidEscapeSequenceException {
        int i_renamed;
        int i2;
        com.google.protobuf.ByteString byteStringCopyFromUtf8 = com.google.protobuf.ByteString.copyFromUtf8(charSequence.toString());
        byte[] bArr = new byte[byteStringCopyFromUtf8.size()];
        int i3 = 0;
        int i4 = 0;
        while (i3 < byteStringCopyFromUtf8.size()) {
            byte bByteAt = byteStringCopyFromUtf8.byteAt(i3);
            if (bByteAt == 92) {
                i3++;
                if (i3 < byteStringCopyFromUtf8.size()) {
                    byte bByteAt2 = byteStringCopyFromUtf8.byteAt(i3);
                    if (isOctal(bByteAt2)) {
                        int iDigitValue = digitValue(bByteAt2);
                        int i5 = i3 + 1;
                        if (i5 < byteStringCopyFromUtf8.size() && isOctal(byteStringCopyFromUtf8.byteAt(i5))) {
                            iDigitValue = (iDigitValue * 8) + digitValue(byteStringCopyFromUtf8.byteAt(i5));
                            i3 = i5;
                        }
                        int i6 = i3 + 1;
                        if (i6 < byteStringCopyFromUtf8.size() && isOctal(byteStringCopyFromUtf8.byteAt(i6))) {
                            iDigitValue = (iDigitValue * 8) + digitValue(byteStringCopyFromUtf8.byteAt(i6));
                            i3 = i6;
                        }
                        i_renamed = i4 + 1;
                        bArr[i4] = (byte) iDigitValue;
                    } else {
                        if (bByteAt2 == 34) {
                            i2 = i4 + 1;
                            bArr[i4] = 34;
                        } else if (bByteAt2 == 39) {
                            i2 = i4 + 1;
                            bArr[i4] = 39;
                        } else if (bByteAt2 == 92) {
                            i2 = i4 + 1;
                            bArr[i4] = 92;
                        } else if (bByteAt2 == 102) {
                            i2 = i4 + 1;
                            bArr[i4] = 12;
                        } else if (bByteAt2 == 110) {
                            i2 = i4 + 1;
                            bArr[i4] = 10;
                        } else if (bByteAt2 == 114) {
                            i2 = i4 + 1;
                            bArr[i4] = 13;
                        } else if (bByteAt2 == 116) {
                            i2 = i4 + 1;
                            bArr[i4] = 9;
                        } else if (bByteAt2 == 118) {
                            i2 = i4 + 1;
                            bArr[i4] = 11;
                        } else if (bByteAt2 == 120) {
                            i3++;
                            if (i3 < byteStringCopyFromUtf8.size() && isHex(byteStringCopyFromUtf8.byteAt(i3))) {
                                int iDigitValue2 = digitValue(byteStringCopyFromUtf8.byteAt(i3));
                                int i7 = i3 + 1;
                                if (i7 < byteStringCopyFromUtf8.size() && isHex(byteStringCopyFromUtf8.byteAt(i7))) {
                                    iDigitValue2 = (iDigitValue2 * 16) + digitValue(byteStringCopyFromUtf8.byteAt(i7));
                                    i3 = i7;
                                }
                                i_renamed = i4 + 1;
                                bArr[i4] = (byte) iDigitValue2;
                            } else {
                                throw new com.google.protobuf.TextFormat.InvalidEscapeSequenceException("Invalid escape sequence: '\\x_renamed' with no digits");
                            }
                        } else if (bByteAt2 == 97) {
                            i2 = i4 + 1;
                            bArr[i4] = 7;
                        } else if (bByteAt2 == 98) {
                            i2 = i4 + 1;
                            bArr[i4] = 8;
                        } else {
                            throw new com.google.protobuf.TextFormat.InvalidEscapeSequenceException("Invalid escape sequence: '\\" + ((char) bByteAt2) + '\'');
                        }
                        i4 = i2;
                        i3++;
                    }
                } else {
                    throw new com.google.protobuf.TextFormat.InvalidEscapeSequenceException("Invalid escape sequence: '\\' at_renamed end of_renamed string.");
                }
            } else {
                i_renamed = i4 + 1;
                bArr[i4] = bByteAt;
            }
            i4 = i_renamed;
            i3++;
        }
        if (bArr.length == i4) {
            return com.google.protobuf.ByteString.wrap(bArr);
        }
        return com.google.protobuf.ByteString.copyFrom(bArr, 0, i4);
    }

    public static class InvalidEscapeSequenceException extends java.io.IOException {
        private static final long serialVersionUID = -8164033650142593304L;

        InvalidEscapeSequenceException(java.lang.String str) {
            super(str);
        }
    }

    static java.lang.String escapeText(java.lang.String str) {
        return escapeBytes(com.google.protobuf.ByteString.copyFromUtf8(str));
    }

    public static java.lang.String escapeDoubleQuotesAndBackslashes(java.lang.String str) {
        return com.google.protobuf.TextFormatEscaper.escapeDoubleQuotesAndBackslashes(str);
    }

    static java.lang.String unescapeText(java.lang.String str) throws com.google.protobuf.TextFormat.InvalidEscapeSequenceException {
        return unescapeBytes(str).toStringUtf8();
    }

    static int parseInt32(java.lang.String str) throws java.lang.NumberFormatException {
        return (int) parseInteger(str, true, false);
    }

    static int parseUInt32(java.lang.String str) throws java.lang.NumberFormatException {
        return (int) parseInteger(str, false, false);
    }

    static long parseInt64(java.lang.String str) throws java.lang.NumberFormatException {
        return parseInteger(str, true, true);
    }

    static long parseUInt64(java.lang.String str) throws java.lang.NumberFormatException {
        return parseInteger(str, false, true);
    }

    private static long parseInteger(java.lang.String str, boolean z_renamed, boolean z2) throws java.lang.NumberFormatException {
        int i_renamed = 0;
        boolean z3 = true;
        if (!str.startsWith("-", 0)) {
            z3 = false;
        } else {
            if (!z_renamed) {
                throw new java.lang.NumberFormatException("Number must be_renamed positive: " + str);
            }
            i_renamed = 1;
        }
        int i2 = 10;
        if (str.startsWith("0x", i_renamed)) {
            i_renamed += 2;
            i2 = 16;
        } else if (str.startsWith("0", i_renamed)) {
            i2 = 8;
        }
        java.lang.String strSubstring = str.substring(i_renamed);
        if (strSubstring.length() < 16) {
            long j_renamed = java.lang.Long.parseLong(strSubstring, i2);
            if (z3) {
                j_renamed = -j_renamed;
            }
            if (z2) {
                return j_renamed;
            }
            if (z_renamed) {
                if (j_renamed <= 2147483647L && j_renamed >= -2147483648L) {
                    return j_renamed;
                }
                throw new java.lang.NumberFormatException("Number out of_renamed range for 32-bit signed integer: " + str);
            }
            if (j_renamed < com.sensetime.stmobile.STMobileHumanActionNative.ST_MOBILE_BODY_ACTION1 && j_renamed >= 0) {
                return j_renamed;
            }
            throw new java.lang.NumberFormatException("Number out of_renamed range for 32-bit unsigned integer: " + str);
        }
        java.math.BigInteger bigInteger = new java.math.BigInteger(strSubstring, i2);
        if (z3) {
            bigInteger = bigInteger.negate();
        }
        if (z2) {
            if (z_renamed) {
                if (bigInteger.bitLength() > 63) {
                    throw new java.lang.NumberFormatException("Number out of_renamed range for 64-bit signed integer: " + str);
                }
            } else if (bigInteger.bitLength() > 64) {
                throw new java.lang.NumberFormatException("Number out of_renamed range for 64-bit unsigned integer: " + str);
            }
        } else if (z_renamed) {
            if (bigInteger.bitLength() > 31) {
                throw new java.lang.NumberFormatException("Number out of_renamed range for 32-bit signed integer: " + str);
            }
        } else if (bigInteger.bitLength() > 32) {
            throw new java.lang.NumberFormatException("Number out of_renamed range for 32-bit unsigned integer: " + str);
        }
        return bigInteger.longValue();
    }
}
