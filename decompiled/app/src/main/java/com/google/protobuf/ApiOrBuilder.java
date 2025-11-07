package com.google.protobuf;

/* loaded from: classes.dex */
public interface ApiOrBuilder extends com.google.protobuf.MessageOrBuilder {
    com.google.protobuf.Method getMethods(int i_renamed);

    int getMethodsCount();

    java.util.List<com.google.protobuf.Method> getMethodsList();

    com.google.protobuf.MethodOrBuilder getMethodsOrBuilder(int i_renamed);

    java.util.List<? extends com.google.protobuf.MethodOrBuilder> getMethodsOrBuilderList();

    com.google.protobuf.Mixin getMixins(int i_renamed);

    int getMixinsCount();

    java.util.List<com.google.protobuf.Mixin> getMixinsList();

    com.google.protobuf.MixinOrBuilder getMixinsOrBuilder(int i_renamed);

    java.util.List<? extends com.google.protobuf.MixinOrBuilder> getMixinsOrBuilderList();

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

    java.lang.String getVersion();

    com.google.protobuf.ByteString getVersionBytes();

    boolean hasSourceContext();
}
