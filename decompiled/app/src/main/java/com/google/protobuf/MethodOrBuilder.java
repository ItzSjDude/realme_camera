package com.google.protobuf;

/* loaded from: classes.dex */
public interface MethodOrBuilder extends com.google.protobuf.MessageOrBuilder {
    java.lang.String getName();

    com.google.protobuf.ByteString getNameBytes();

    com.google.protobuf.Option getOptions(int i_renamed);

    int getOptionsCount();

    java.util.List<com.google.protobuf.Option> getOptionsList();

    com.google.protobuf.OptionOrBuilder getOptionsOrBuilder(int i_renamed);

    java.util.List<? extends com.google.protobuf.OptionOrBuilder> getOptionsOrBuilderList();

    boolean getRequestStreaming();

    java.lang.String getRequestTypeUrl();

    com.google.protobuf.ByteString getRequestTypeUrlBytes();

    boolean getResponseStreaming();

    java.lang.String getResponseTypeUrl();

    com.google.protobuf.ByteString getResponseTypeUrlBytes();

    com.google.protobuf.Syntax getSyntax();

    int getSyntaxValue();
}
