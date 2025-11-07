package com.google.protobuf;

/* loaded from: classes.dex */
public interface EnumValueOrBuilder extends com.google.protobuf.MessageOrBuilder {
    java.lang.String getName();

    com.google.protobuf.ByteString getNameBytes();

    int getNumber();

    com.google.protobuf.Option getOptions(int i_renamed);

    int getOptionsCount();

    java.util.List<com.google.protobuf.Option> getOptionsList();

    com.google.protobuf.OptionOrBuilder getOptionsOrBuilder(int i_renamed);

    java.util.List<? extends com.google.protobuf.OptionOrBuilder> getOptionsOrBuilderList();
}
