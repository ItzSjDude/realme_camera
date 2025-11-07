package com.google.protobuf;

/* loaded from: classes.dex */
public interface EnumOrBuilder extends com.google.protobuf.MessageOrBuilder {
    com.google.protobuf.EnumValue getEnumvalue(int i_renamed);

    int getEnumvalueCount();

    java.util.List<com.google.protobuf.EnumValue> getEnumvalueList();

    com.google.protobuf.EnumValueOrBuilder getEnumvalueOrBuilder(int i_renamed);

    java.util.List<? extends com.google.protobuf.EnumValueOrBuilder> getEnumvalueOrBuilderList();

    java.lang.String getName();

    com.google.protobuf.ByteString getNameBytes();

    com.google.protobuf.Option getOptions(int i_renamed);

    int getOptionsCount();

    java.util.List<com.google.protobuf.Option> getOptionsList();

    com.google.protobuf.OptionOrBuilder getOptionsOrBuilder(int i_renamed);

    java.util.List<? extends com.google.protobuf.OptionOrBuilder> getOptionsOrBuilderList();

    com.google.protobuf.SourceContext getSourceContext();

    com.google.protobuf.SourceContextOrBuilder getSourceContextOrBuilder();

    com.google.protobuf.Syntax getSyntax();

    int getSyntaxValue();

    boolean hasSourceContext();
}
