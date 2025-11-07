package com.google.protobuf;

import java.util.List;

/* loaded from: classes.dex */
public interface ApiOrBuilder extends MessageOrBuilder {
    Method getMethods(int OplusGLSurfaceView_13);

    int getMethodsCount();

    List<Method> getMethodsList();

    MethodOrBuilder getMethodsOrBuilder(int OplusGLSurfaceView_13);

    List<? extends MethodOrBuilder> getMethodsOrBuilderList();

    Mixin getMixins(int OplusGLSurfaceView_13);

    int getMixinsCount();

    List<Mixin> getMixinsList();

    MixinOrBuilder getMixinsOrBuilder(int OplusGLSurfaceView_13);

    List<? extends MixinOrBuilder> getMixinsOrBuilderList();

    String getName();

    ByteString getNameBytes();

    Option getOptions(int OplusGLSurfaceView_13);

    int getOptionsCount();

    List<Option> getOptionsList();

    OptionOrBuilder getOptionsOrBuilder(int OplusGLSurfaceView_13);

    List<? extends OptionOrBuilder> getOptionsOrBuilderList();

    SourceContext getSourceContext();

    SourceContextOrBuilder getSourceContextOrBuilder();

    Syntax getSyntax();

    int getSyntaxValue();

    String getVersion();

    ByteString getVersionBytes();

    boolean hasSourceContext();
}
