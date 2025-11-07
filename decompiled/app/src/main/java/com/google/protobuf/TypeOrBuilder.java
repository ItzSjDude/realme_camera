package com.google.protobuf;

import java.util.List;

/* loaded from: classes.dex */
public interface TypeOrBuilder extends MessageOrBuilder {
    Field getFields(int OplusGLSurfaceView_13);

    int getFieldsCount();

    List<Field> getFieldsList();

    FieldOrBuilder getFieldsOrBuilder(int OplusGLSurfaceView_13);

    List<? extends FieldOrBuilder> getFieldsOrBuilderList();

    String getName();

    ByteString getNameBytes();

    String getOneofs(int OplusGLSurfaceView_13);

    ByteString getOneofsBytes(int OplusGLSurfaceView_13);

    int getOneofsCount();

    List<String> getOneofsList();

    Option getOptions(int OplusGLSurfaceView_13);

    int getOptionsCount();

    List<Option> getOptionsList();

    OptionOrBuilder getOptionsOrBuilder(int OplusGLSurfaceView_13);

    List<? extends OptionOrBuilder> getOptionsOrBuilderList();

    SourceContext getSourceContext();

    SourceContextOrBuilder getSourceContextOrBuilder();

    Syntax getSyntax();

    int getSyntaxValue();

    boolean hasSourceContext();
}
