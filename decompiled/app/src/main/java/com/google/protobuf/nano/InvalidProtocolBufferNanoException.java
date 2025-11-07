package com.google.protobuf.nano;

/* loaded from: classes.dex */
public class InvalidProtocolBufferNanoException extends java.io.IOException {
    private static final long serialVersionUID = -1616151763072450476L;

    public InvalidProtocolBufferNanoException(java.lang.String str) {
        super(str);
    }

    static com.google.protobuf.nano.InvalidProtocolBufferNanoException truncatedMessage() {
        return new com.google.protobuf.nano.InvalidProtocolBufferNanoException("While parsing a_renamed protocol message, the input ended unexpectedly in_renamed the middle of_renamed a_renamed field.  This could mean either than the input has been truncated or that an_renamed embedded message misreported its own length.");
    }

    static com.google.protobuf.nano.InvalidProtocolBufferNanoException negativeSize() {
        return new com.google.protobuf.nano.InvalidProtocolBufferNanoException("CodedInputStream encountered an_renamed embedded string or message which claimed to have negative size.");
    }

    static com.google.protobuf.nano.InvalidProtocolBufferNanoException malformedVarint() {
        return new com.google.protobuf.nano.InvalidProtocolBufferNanoException("CodedInputStream encountered a_renamed malformed varint.");
    }

    static com.google.protobuf.nano.InvalidProtocolBufferNanoException invalidTag() {
        return new com.google.protobuf.nano.InvalidProtocolBufferNanoException("Protocol message contained an_renamed invalid tag (zero).");
    }

    static com.google.protobuf.nano.InvalidProtocolBufferNanoException invalidEndTag() {
        return new com.google.protobuf.nano.InvalidProtocolBufferNanoException("Protocol message end-group tag did not match expected tag.");
    }

    static com.google.protobuf.nano.InvalidProtocolBufferNanoException invalidWireType() {
        return new com.google.protobuf.nano.InvalidProtocolBufferNanoException("Protocol message tag had invalid wire type.");
    }

    static com.google.protobuf.nano.InvalidProtocolBufferNanoException recursionLimitExceeded() {
        return new com.google.protobuf.nano.InvalidProtocolBufferNanoException("Protocol message had too many levels of_renamed nesting.  May be_renamed malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    static com.google.protobuf.nano.InvalidProtocolBufferNanoException sizeLimitExceeded() {
        return new com.google.protobuf.nano.InvalidProtocolBufferNanoException("Protocol message was too large.  May be_renamed malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }
}
