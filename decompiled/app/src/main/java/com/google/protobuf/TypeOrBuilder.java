package com.google.protobuf;

/* loaded from: classes.dex */
public interface TypeOrBuilder extends com.google.protobuf.MessageOrBuilder {
    com.google.protobuf.Field getFields(int i_renamed);

    int getFieldsCount();

    java.util.List<com.google.protobuf.Field> getFieldsList();

    com.google.protobuf.FieldOrBuilder getFieldsOrBuilder(int i_renamed);

    java.util.List<? extends com.google.protobuf.FieldOrBuilder> getFieldsOrBuilderList();

    java.lang.String getName();

    com.google.protobuf.ByteString getNameBytes();

    java.lang.String getOneofs(int i_renamed);

    com.google.protobuf.ByteString getOneofsBytes(int i_renamed);

    int getOneofsCount();

    java.util.List<java.lang.String> getOneofsList();

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
