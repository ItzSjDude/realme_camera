package com.google.protobuf;

import com.google.protobuf.ArrayDecoders;
import com.google.protobuf.ByteString;
import com.google.protobuf.Internal;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.WireFormat;
import com.google.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
final class MessageSchema<T> implements Schema<T> {
    private static final int ENFORCE_UTF8_MASK = 536870912;
    private static final int FIELD_TYPE_MASK = 267386880;
    private static final int INTS_PER_FIELD = 3;
    private static final int OFFSET_BITS = 20;
    private static final int OFFSET_MASK = 1048575;
    static final int ONEOF_TYPE_OFFSET = 51;
    private static final int REQUIRED_MASK = 268435456;
    private final int[] buffer;
    private final int checkInitializedCount;
    private final MessageLite defaultInstance;
    private final ExtensionSchema<?> extensionSchema;
    private final boolean hasExtensions;
    private final int[] intArray;
    private final ListFieldSchema listFieldSchema;
    private final boolean lite;
    private final MapFieldSchema mapFieldSchema;
    private final int maxFieldNumber;
    private final int minFieldNumber;
    private final NewInstanceSchema newInstanceSchema;
    private final Object[] objects;
    private final boolean proto3;
    private final int repeatedFieldOffsetStart;
    private final UnknownFieldSchema<?, ?> unknownFieldSchema;
    private final boolean useCachedSizeField;
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final Unsafe UNSAFE = UnsafeUtil.getUnsafe();

    private static boolean isEnforceUtf8(int OplusGLSurfaceView_13) {
        return (OplusGLSurfaceView_13 & 536870912) != 0;
    }

    private static boolean isRequired(int OplusGLSurfaceView_13) {
        return (OplusGLSurfaceView_13 & 268435456) != 0;
    }

    private static long offset(int OplusGLSurfaceView_13) {
        return OplusGLSurfaceView_13 & OFFSET_MASK;
    }

    private static int type(int OplusGLSurfaceView_13) {
        return (OplusGLSurfaceView_13 & FIELD_TYPE_MASK) >>> 20;
    }

    private MessageSchema(int[] iArr, Object[] objArr, int OplusGLSurfaceView_13, int i2, MessageLite messageLite, boolean z, boolean z2, int[] iArr2, int i3, int i4, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        this.buffer = iArr;
        this.objects = objArr;
        this.minFieldNumber = OplusGLSurfaceView_13;
        this.maxFieldNumber = i2;
        this.lite = messageLite instanceof GeneratedMessageLite;
        this.proto3 = z;
        this.hasExtensions = extensionSchema != null && extensionSchema.hasExtensions(messageLite);
        this.useCachedSizeField = z2;
        this.intArray = iArr2;
        this.checkInitializedCount = i3;
        this.repeatedFieldOffsetStart = i4;
        this.newInstanceSchema = newInstanceSchema;
        this.listFieldSchema = listFieldSchema;
        this.unknownFieldSchema = unknownFieldSchema;
        this.extensionSchema = extensionSchema;
        this.defaultInstance = messageLite;
        this.mapFieldSchema = mapFieldSchema;
    }

    static <T> MessageSchema<T> newSchema(Class<T> cls, MessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        if (messageInfo instanceof RawMessageInfo) {
            return newSchemaForRawMessageInfo((RawMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
        }
        return newSchemaForMessageInfo((StructuralMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <T> MessageSchema<T> newSchemaForRawMessageInfo(RawMessageInfo rawMessageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        int OplusGLSurfaceView_13;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int iCharAt;
        int i8;
        int iCharAt2;
        int iCharAt3;
        int i9;
        int i10;
        char c2;
        int[] iArr;
        char c3;
        int i11;
        char cCharAt;
        int i12;
        char cCharAt2;
        int i13;
        char cCharAt3;
        char cCharAt4;
        char cCharAt5;
        char cCharAt6;
        char cCharAt7;
        char cCharAt8;
        int i14;
        int i15;
        int i16;
        char c4;
        int iObjectFieldOffset;
        String str;
        int i17;
        Class<?> cls;
        int i18;
        int i19;
        int iObjectFieldOffset2;
        java.lang.reflect.Field fieldReflectField;
        char cCharAt9;
        int i20;
        int i21;
        java.lang.reflect.Field fieldReflectField2;
        java.lang.reflect.Field fieldReflectField3;
        int i22;
        char cCharAt10;
        int i23;
        char cCharAt11;
        int i24;
        char cCharAt12;
        char cCharAt13;
        char cCharAt14;
        boolean z = rawMessageInfo.getSyntax() == ProtoSyntax.PROTO3;
        String stringInfo = rawMessageInfo.getStringInfo();
        int length = stringInfo.length();
        int iCharAt4 = stringInfo.charAt(0);
        char c5 = 55296;
        if (iCharAt4 >= 55296) {
            int i25 = iCharAt4 & 8191;
            int i26 = 1;
            int i27 = 13;
            while (true) {
                OplusGLSurfaceView_13 = i26 + 1;
                cCharAt14 = stringInfo.charAt(i26);
                if (cCharAt14 < 55296) {
                    break;
                }
                i25 |= (cCharAt14 & 8191) << i27;
                i27 += 13;
                i26 = OplusGLSurfaceView_13;
            }
            iCharAt4 = (cCharAt14 << i27) | i25;
        } else {
            OplusGLSurfaceView_13 = 1;
        }
        int i28 = OplusGLSurfaceView_13 + 1;
        int iCharAt5 = stringInfo.charAt(OplusGLSurfaceView_13);
        if (iCharAt5 >= 55296) {
            int i29 = iCharAt5 & 8191;
            int i30 = 13;
            while (true) {
                i2 = i28 + 1;
                cCharAt13 = stringInfo.charAt(i28);
                if (cCharAt13 < 55296) {
                    break;
                }
                i29 |= (cCharAt13 & 8191) << i30;
                i30 += 13;
                i28 = i2;
            }
            iCharAt5 = i29 | (cCharAt13 << i30);
        } else {
            i2 = i28;
        }
        if (iCharAt5 == 0) {
            c3 = 0;
            i9 = 0;
            iCharAt = 0;
            iCharAt2 = 0;
            iCharAt3 = 0;
            i10 = 0;
            iArr = EMPTY_INT_ARRAY;
            c2 = 0;
        } else {
            int i31 = i2 + 1;
            char cCharAt15 = stringInfo.charAt(i2);
            if (cCharAt15 >= 55296) {
                int i32 = cCharAt15 & 8191;
                int i33 = 13;
                while (true) {
                    i3 = i31 + 1;
                    cCharAt8 = stringInfo.charAt(i31);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i32 |= (cCharAt8 & 8191) << i33;
                    i33 += 13;
                    i31 = i3;
                }
                i4 = (cCharAt8 << i33) | i32;
            } else {
                i3 = i31;
                i4 = cCharAt15;
            }
            int i34 = i3 + 1;
            int iCharAt6 = stringInfo.charAt(i3);
            if (iCharAt6 >= 55296) {
                int i35 = iCharAt6 & 8191;
                int i36 = 13;
                while (true) {
                    i5 = i34 + 1;
                    cCharAt7 = stringInfo.charAt(i34);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i35 |= (cCharAt7 & 8191) << i36;
                    i36 += 13;
                    i34 = i5;
                }
                iCharAt6 = i35 | (cCharAt7 << i36);
            } else {
                i5 = i34;
            }
            int i37 = i5 + 1;
            char cCharAt16 = stringInfo.charAt(i5);
            if (cCharAt16 >= 55296) {
                int i38 = cCharAt16 & 8191;
                int i39 = 13;
                while (true) {
                    i6 = i37 + 1;
                    cCharAt6 = stringInfo.charAt(i37);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i38 |= (cCharAt6 & 8191) << i39;
                    i39 += 13;
                    i37 = i6;
                }
                cCharAt16 = ((cCharAt6 << i39) | i38) == true ? 1 : 0;
            } else {
                i6 = i37;
            }
            int i40 = i6 + 1;
            char cCharAt17 = stringInfo.charAt(i6);
            if (cCharAt17 >= 55296) {
                int i41 = cCharAt17 & 8191;
                int i42 = 13;
                while (true) {
                    i7 = i40 + 1;
                    cCharAt5 = stringInfo.charAt(i40);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i41 |= (cCharAt5 & 8191) << i42;
                    i42 += 13;
                    i40 = i7;
                }
                cCharAt17 = ((cCharAt5 << i42) | i41) == true ? 1 : 0;
            } else {
                i7 = i40;
            }
            int i43 = i7 + 1;
            iCharAt = stringInfo.charAt(i7);
            if (iCharAt >= 55296) {
                int i44 = iCharAt & 8191;
                int i45 = 13;
                while (true) {
                    i8 = i43 + 1;
                    cCharAt4 = stringInfo.charAt(i43);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i44 |= (cCharAt4 & 8191) << i45;
                    i45 += 13;
                    i43 = i8;
                }
                iCharAt = (cCharAt4 << i45) | i44;
            } else {
                i8 = i43;
            }
            int i46 = i8 + 1;
            iCharAt2 = stringInfo.charAt(i8);
            if (iCharAt2 >= 55296) {
                int i47 = iCharAt2 & 8191;
                int i48 = 13;
                while (true) {
                    i13 = i46 + 1;
                    cCharAt3 = stringInfo.charAt(i46);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i47 |= (cCharAt3 & 8191) << i48;
                    i48 += 13;
                    i46 = i13;
                }
                iCharAt2 = (cCharAt3 << i48) | i47;
                i46 = i13;
            }
            int i49 = i46 + 1;
            int iCharAt7 = stringInfo.charAt(i46);
            if (iCharAt7 >= 55296) {
                int i50 = iCharAt7 & 8191;
                int i51 = 13;
                while (true) {
                    i12 = i49 + 1;
                    cCharAt2 = stringInfo.charAt(i49);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i50 |= (cCharAt2 & 8191) << i51;
                    i51 += 13;
                    i49 = i12;
                }
                iCharAt7 = i50 | (cCharAt2 << i51);
                i49 = i12;
            }
            int i52 = i49 + 1;
            iCharAt3 = stringInfo.charAt(i49);
            if (iCharAt3 >= 55296) {
                int i53 = 13;
                int i54 = iCharAt3 & 8191;
                int i55 = i52;
                while (true) {
                    i11 = i55 + 1;
                    cCharAt = stringInfo.charAt(i55);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i54 |= (cCharAt & 8191) << i53;
                    i53 += 13;
                    i55 = i11;
                }
                iCharAt3 = i54 | (cCharAt << i53);
                i52 = i11;
            }
            i9 = (i4 * 2) + iCharAt6;
            int i56 = i52;
            i10 = i4;
            c2 = cCharAt16;
            i2 = i56;
            char c6 = cCharAt17;
            iArr = new int[iCharAt3 + iCharAt2 + iCharAt7];
            c3 = c6;
        }
        Unsafe unsafe = UNSAFE;
        Object[] objects = rawMessageInfo.getObjects();
        Class<?> cls2 = rawMessageInfo.getDefaultInstance().getClass();
        int[] iArr2 = new int[iCharAt * 3];
        Object[] objArr = new Object[iCharAt * 2];
        int i57 = iCharAt2 + iCharAt3;
        int i58 = i57;
        int i59 = iCharAt3;
        int i60 = 0;
        int i61 = 0;
        while (i2 < length) {
            int i62 = i2 + 1;
            int iCharAt8 = stringInfo.charAt(i2);
            if (iCharAt8 >= c5) {
                int i63 = 13;
                int i64 = iCharAt8 & 8191;
                int i65 = i62;
                while (true) {
                    i24 = i65 + 1;
                    cCharAt12 = stringInfo.charAt(i65);
                    if (cCharAt12 < c5) {
                        break;
                    }
                    i64 |= (cCharAt12 & 8191) << i63;
                    i63 += 13;
                    i65 = i24;
                }
                iCharAt8 = i64 | (cCharAt12 << i63);
                i14 = i24;
            } else {
                i14 = i62;
            }
            int i66 = i14 + 1;
            int iCharAt9 = stringInfo.charAt(i14);
            int i67 = length;
            char c7 = 55296;
            if (iCharAt9 >= 55296) {
                int i68 = 13;
                int i69 = iCharAt9 & 8191;
                int i70 = i66;
                while (true) {
                    i23 = i70 + 1;
                    cCharAt11 = stringInfo.charAt(i70);
                    if (cCharAt11 < c7) {
                        break;
                    }
                    i69 |= (cCharAt11 & 8191) << i68;
                    i68 += 13;
                    i70 = i23;
                    c7 = 55296;
                }
                iCharAt9 = i69 | (cCharAt11 << i68);
                i15 = i23;
            } else {
                i15 = i66;
            }
            int i71 = i57;
            int i72 = iCharAt9 & 255;
            int i73 = iCharAt3;
            if ((iCharAt9 & 1024) != 0) {
                iArr[i60] = i61;
                i60++;
            }
            boolean z2 = z;
            if (i72 >= 51) {
                int i74 = i15 + 1;
                int iCharAt10 = stringInfo.charAt(i15);
                char c8 = 55296;
                if (iCharAt10 >= 55296) {
                    int i75 = iCharAt10 & 8191;
                    int i76 = 13;
                    while (true) {
                        i22 = i74 + 1;
                        cCharAt10 = stringInfo.charAt(i74);
                        if (cCharAt10 < c8) {
                            break;
                        }
                        i75 |= (cCharAt10 & 8191) << i76;
                        i76 += 13;
                        i74 = i22;
                        c8 = 55296;
                    }
                    iCharAt10 = i75 | (cCharAt10 << i76);
                    i74 = i22;
                }
                int i77 = i72 - 51;
                int i78 = i74;
                if (i77 == 9 || i77 == 17) {
                    i21 = i9 + 1;
                    objArr[((i61 / 3) * 2) + 1] = objects[i9];
                } else if (i77 == 12 && (iCharAt4 & 1) == 1) {
                    i21 = i9 + 1;
                    objArr[((i61 / 3) * 2) + 1] = objects[i9];
                } else {
                    i21 = i9;
                }
                int i79 = iCharAt10 * 2;
                Object obj = objects[i79];
                if (obj instanceof java.lang.reflect.Field) {
                    fieldReflectField2 = (java.lang.reflect.Field) obj;
                } else {
                    fieldReflectField2 = reflectField(cls2, (String) obj);
                    objects[i79] = fieldReflectField2;
                }
                int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldReflectField2);
                int i80 = i79 + 1;
                Object obj2 = objects[i80];
                if (obj2 instanceof java.lang.reflect.Field) {
                    fieldReflectField3 = (java.lang.reflect.Field) obj2;
                } else {
                    fieldReflectField3 = reflectField(cls2, (String) obj2);
                    objects[i80] = fieldReflectField3;
                }
                int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldReflectField3);
                str = stringInfo;
                i17 = iCharAt4;
                i16 = i21;
                iObjectFieldOffset = iObjectFieldOffset3;
                i18 = i78;
                iObjectFieldOffset2 = iObjectFieldOffset4;
                c4 = c3;
                i19 = 0;
                cls = cls2;
            } else {
                i16 = i9 + 1;
                java.lang.reflect.Field fieldReflectField4 = reflectField(cls2, (String) objects[i9]);
                if (i72 == 9 || i72 == 17) {
                    c4 = c3;
                    objArr[((i61 / 3) * 2) + 1] = fieldReflectField4.getType();
                } else {
                    if (i72 == 27 || i72 == 49) {
                        c4 = c3;
                        i20 = i16 + 1;
                        objArr[((i61 / 3) * 2) + 1] = objects[i16];
                    } else if (i72 == 12 || i72 == 30 || i72 == 44) {
                        c4 = c3;
                        if ((iCharAt4 & 1) == 1) {
                            i20 = i16 + 1;
                            objArr[((i61 / 3) * 2) + 1] = objects[i16];
                        }
                    } else if (i72 == 50) {
                        int i81 = i59 + 1;
                        iArr[i59] = i61;
                        int i82 = (i61 / 3) * 2;
                        int i83 = i16 + 1;
                        objArr[i82] = objects[i16];
                        if ((iCharAt9 & 2048) != 0) {
                            i16 = i83 + 1;
                            objArr[i82 + 1] = objects[i83];
                            c4 = c3;
                            i59 = i81;
                        } else {
                            i59 = i81;
                            i16 = i83;
                            c4 = c3;
                        }
                    } else {
                        c4 = c3;
                    }
                    i16 = i20;
                }
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField4);
                if ((iCharAt4 & 1) != 1 || i72 > 17) {
                    str = stringInfo;
                    i17 = iCharAt4;
                    cls = cls2;
                    i18 = i15;
                    i19 = 0;
                    iObjectFieldOffset2 = 0;
                } else {
                    int i84 = i15 + 1;
                    int iCharAt11 = stringInfo.charAt(i15);
                    if (iCharAt11 >= 55296) {
                        int i85 = iCharAt11 & 8191;
                        int i86 = 13;
                        while (true) {
                            i18 = i84 + 1;
                            cCharAt9 = stringInfo.charAt(i84);
                            if (cCharAt9 < 55296) {
                                break;
                            }
                            i85 |= (cCharAt9 & 8191) << i86;
                            i86 += 13;
                            i84 = i18;
                        }
                        iCharAt11 = i85 | (cCharAt9 << i86);
                    } else {
                        i18 = i84;
                    }
                    int i87 = (i10 * 2) + (iCharAt11 / 32);
                    Object obj3 = objects[i87];
                    str = stringInfo;
                    if (obj3 instanceof java.lang.reflect.Field) {
                        fieldReflectField = (java.lang.reflect.Field) obj3;
                    } else {
                        fieldReflectField = reflectField(cls2, (String) obj3);
                        objects[i87] = fieldReflectField;
                    }
                    i17 = iCharAt4;
                    cls = cls2;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldReflectField);
                    i19 = iCharAt11 % 32;
                }
                if (i72 >= 18 && i72 <= 49) {
                    iArr[i58] = iObjectFieldOffset;
                    i58++;
                }
            }
            int i88 = i61 + 1;
            iArr2[i61] = iCharAt8;
            int i89 = i88 + 1;
            iArr2[i88] = ((iCharAt9 & 256) != 0 ? 268435456 : 0) | ((iCharAt9 & 512) != 0 ? 536870912 : 0) | (i72 << 20) | iObjectFieldOffset;
            i61 = i89 + 1;
            iArr2[i89] = (i19 << 20) | iObjectFieldOffset2;
            iCharAt4 = i17;
            cls2 = cls;
            i9 = i16;
            i57 = i71;
            length = i67;
            iCharAt3 = i73;
            c3 = c4;
            i2 = i18;
            z = z2;
            stringInfo = str;
            c5 = 55296;
        }
        return new MessageSchema<>(iArr2, objArr, c2, c3, rawMessageInfo.getDefaultInstance(), z, false, iArr, iCharAt3, i57, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    private static java.lang.reflect.Field reflectField(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            java.lang.reflect.Field[] declaredFields = cls.getDeclaredFields();
            for (java.lang.reflect.Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    static <T> MessageSchema<T> newSchemaForMessageInfo(StructuralMessageInfo structuralMessageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        int fieldNumber;
        int fieldNumber2;
        int OplusGLSurfaceView_13;
        boolean z = structuralMessageInfo.getSyntax() == ProtoSyntax.PROTO3;
        FieldInfo[] fields = structuralMessageInfo.getFields();
        if (fields.length == 0) {
            fieldNumber = 0;
            fieldNumber2 = 0;
        } else {
            fieldNumber = fields[0].getFieldNumber();
            fieldNumber2 = fields[fields.length - 1].getFieldNumber();
        }
        int length = fields.length;
        int[] iArr = new int[length * 3];
        Object[] objArr = new Object[length * 2];
        int i2 = 0;
        int i3 = 0;
        for (FieldInfo fieldInfo : fields) {
            if (fieldInfo.getType() == FieldType.MAP) {
                i2++;
            } else if (fieldInfo.getType().m8337id() >= 18 && fieldInfo.getType().m8337id() <= 49) {
                i3++;
            }
        }
        int[] iArr2 = i2 > 0 ? new int[i2] : null;
        int[] iArr3 = i3 > 0 ? new int[i3] : null;
        int[] checkInitialized = structuralMessageInfo.getCheckInitialized();
        if (checkInitialized == null) {
            checkInitialized = EMPTY_INT_ARRAY;
        }
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i4 < fields.length) {
            FieldInfo fieldInfo2 = fields[i4];
            int fieldNumber3 = fieldInfo2.getFieldNumber();
            storeFieldData(fieldInfo2, iArr, i5, z, objArr);
            if (i6 < checkInitialized.length && checkInitialized[i6] == fieldNumber3) {
                checkInitialized[i6] = i5;
                i6++;
            }
            if (fieldInfo2.getType() == FieldType.MAP) {
                iArr2[i7] = i5;
                i7++;
            } else {
                if (fieldInfo2.getType().m8337id() >= 18 && fieldInfo2.getType().m8337id() <= 49) {
                    OplusGLSurfaceView_13 = i5;
                    iArr3[i8] = (int) UnsafeUtil.objectFieldOffset(fieldInfo2.getField());
                    i8++;
                }
                i4++;
                i5 = OplusGLSurfaceView_13 + 3;
            }
            OplusGLSurfaceView_13 = i5;
            i4++;
            i5 = OplusGLSurfaceView_13 + 3;
        }
        if (iArr2 == null) {
            iArr2 = EMPTY_INT_ARRAY;
        }
        if (iArr3 == null) {
            iArr3 = EMPTY_INT_ARRAY;
        }
        int[] iArr4 = new int[checkInitialized.length + iArr2.length + iArr3.length];
        System.arraycopy(checkInitialized, 0, iArr4, 0, checkInitialized.length);
        System.arraycopy(iArr2, 0, iArr4, checkInitialized.length, iArr2.length);
        System.arraycopy(iArr3, 0, iArr4, checkInitialized.length + iArr2.length, iArr3.length);
        return new MessageSchema<>(iArr, objArr, fieldNumber, fieldNumber2, structuralMessageInfo.getDefaultInstance(), z, true, iArr4, checkInitialized.length, checkInitialized.length + iArr2.length, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void storeFieldData(com.google.protobuf.FieldInfo r7, int[] r8, int r9, boolean r10, java.lang.Object[] r11) {
        /*
            com.google.protobuf.OneofInfo r0 = r7.getOneof()
            r1 = 0
            if (r0 == 0) goto L27
            com.google.protobuf.FieldType r10 = r7.getType()
            int r10 = r10.m8337id()
            int r10 = r10 + 51
            java.lang.reflect.Field r2 = r0.getValueField()
            long r2 = com.google.protobuf.UnsafeUtil.objectFieldOffset(r2)
            int r2 = (int) r2
            java.lang.reflect.Field r0 = r0.getCaseField()
            long r3 = com.google.protobuf.UnsafeUtil.objectFieldOffset(r0)
            int r0 = (int) r3
            r3 = r10
            r10 = r0
        L25:
            r0 = r1
            goto L6b
        L27:
            com.google.protobuf.FieldType r0 = r7.getType()
            java.lang.reflect.Field r2 = r7.getField()
            long r2 = com.google.protobuf.UnsafeUtil.objectFieldOffset(r2)
            int r2 = (int) r2
            int r3 = r0.m8337id()
            if (r10 != 0) goto L58
            boolean r10 = r0.isList()
            if (r10 != 0) goto L58
            boolean r10 = r0.isMap()
            if (r10 != 0) goto L58
            java.lang.reflect.Field r10 = r7.getPresenceField()
            long r4 = com.google.protobuf.UnsafeUtil.objectFieldOffset(r10)
            int r10 = (int) r4
            int r0 = r7.getPresenceMask()
            int r0 = java.lang.Integer.numberOfTrailingZeros(r0)
            goto L6b
        L58:
            java.lang.reflect.Field r10 = r7.getCachedSizeField()
            if (r10 != 0) goto L61
            r10 = r1
            r0 = r10
            goto L6b
        L61:
            java.lang.reflect.Field r10 = r7.getCachedSizeField()
            long r4 = com.google.protobuf.UnsafeUtil.objectFieldOffset(r10)
            int r10 = (int) r4
            goto L25
        L6b:
            int r4 = r7.getFieldNumber()
            r8[r9] = r4
            int r4 = r9 + 1
            boolean r5 = r7.isEnforceUtf8()
            if (r5 == 0) goto L7c
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            goto L7d
        L7c:
            r5 = r1
        L7d:
            boolean r6 = r7.isRequired()
            if (r6 == 0) goto L85
            r1 = 268435456(0x10000000, float:2.5243549E-29)
        L85:
            r1 = r1 | r5
            int r3 = r3 << 20
            r1 = r1 | r3
            r1 = r1 | r2
            r8[r4] = r1
            int r1 = r9 + 2
            int r0 = r0 << 20
            r10 = r10 | r0
            r8[r1] = r10
            java.lang.Class r8 = r7.getMessageFieldClass()
            java.lang.Object r10 = r7.getMapDefaultEntry()
            if (r10 == 0) goto Lbd
            int r9 = r9 / 3
            int r9 = r9 * 2
            java.lang.Object r10 = r7.getMapDefaultEntry()
            r11[r9] = r10
            if (r8 == 0) goto Lae
            int r9 = r9 + 1
            r11[r9] = r8
            goto Lda
        Lae:
            com.google.protobuf.Internal$EnumVerifier r8 = r7.getEnumVerifier()
            if (r8 == 0) goto Lda
            int r9 = r9 + 1
            com.google.protobuf.Internal$EnumVerifier r7 = r7.getEnumVerifier()
            r11[r9] = r7
            goto Lda
        Lbd:
            if (r8 == 0) goto Lc8
            int r9 = r9 / 3
            int r9 = r9 * 2
            int r9 = r9 + 1
            r11[r9] = r8
            goto Lda
        Lc8:
            com.google.protobuf.Internal$EnumVerifier r8 = r7.getEnumVerifier()
            if (r8 == 0) goto Lda
            int r9 = r9 / 3
            int r9 = r9 * 2
            int r9 = r9 + 1
            com.google.protobuf.Internal$EnumVerifier r7 = r7.getEnumVerifier()
            r11[r9] = r7
        Lda:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.storeFieldData(com.google.protobuf.FieldInfo, int[], int, boolean, java.lang.Object[]):void");
    }

    @Override // com.google.protobuf.Schema
    public T newInstance() {
        return (T) this.newInstanceSchema.newInstance(this.defaultInstance);
    }

    @Override // com.google.protobuf.Schema
    public boolean equals(T t, T t2) {
        int length = this.buffer.length;
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < length; OplusGLSurfaceView_13 += 3) {
            if (!equals(t, t2, OplusGLSurfaceView_13)) {
                return false;
            }
        }
        if (!this.unknownFieldSchema.getFromMessage(t).equals(this.unknownFieldSchema.getFromMessage(t2))) {
            return false;
        }
        if (this.hasExtensions) {
            return this.extensionSchema.getExtensions(t).equals(this.extensionSchema.getExtensions(t2));
        }
        return true;
    }

    private boolean equals(T t, T t2, int OplusGLSurfaceView_13) {
        int iTypeAndOffsetAt = typeAndOffsetAt(OplusGLSurfaceView_13);
        long jOffset = offset(iTypeAndOffsetAt);
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                if (arePresentForEquals(t, t2, OplusGLSurfaceView_13) && Double.doubleToLongBits(UnsafeUtil.getDouble(t, jOffset)) == Double.doubleToLongBits(UnsafeUtil.getDouble(t2, jOffset))) {
                    break;
                }
                break;
            case 1:
                if (arePresentForEquals(t, t2, OplusGLSurfaceView_13) && Float.floatToIntBits(UnsafeUtil.getFloat(t, jOffset)) == Float.floatToIntBits(UnsafeUtil.getFloat(t2, jOffset))) {
                    break;
                }
                break;
            case 2:
                if (arePresentForEquals(t, t2, OplusGLSurfaceView_13) && UnsafeUtil.getLong(t, jOffset) == UnsafeUtil.getLong(t2, jOffset)) {
                    break;
                }
                break;
            case 3:
                if (arePresentForEquals(t, t2, OplusGLSurfaceView_13) && UnsafeUtil.getLong(t, jOffset) == UnsafeUtil.getLong(t2, jOffset)) {
                    break;
                }
                break;
            case 4:
                if (arePresentForEquals(t, t2, OplusGLSurfaceView_13) && UnsafeUtil.getInt(t, jOffset) == UnsafeUtil.getInt(t2, jOffset)) {
                    break;
                }
                break;
            case 5:
                if (arePresentForEquals(t, t2, OplusGLSurfaceView_13) && UnsafeUtil.getLong(t, jOffset) == UnsafeUtil.getLong(t2, jOffset)) {
                    break;
                }
                break;
            case 6:
                if (arePresentForEquals(t, t2, OplusGLSurfaceView_13) && UnsafeUtil.getInt(t, jOffset) == UnsafeUtil.getInt(t2, jOffset)) {
                    break;
                }
                break;
            case 7:
                if (arePresentForEquals(t, t2, OplusGLSurfaceView_13) && UnsafeUtil.getBoolean(t, jOffset) == UnsafeUtil.getBoolean(t2, jOffset)) {
                    break;
                }
                break;
            case 8:
                if (arePresentForEquals(t, t2, OplusGLSurfaceView_13) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jOffset), UnsafeUtil.getObject(t2, jOffset))) {
                    break;
                }
                break;
            case 9:
                if (arePresentForEquals(t, t2, OplusGLSurfaceView_13) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jOffset), UnsafeUtil.getObject(t2, jOffset))) {
                    break;
                }
                break;
            case 10:
                if (arePresentForEquals(t, t2, OplusGLSurfaceView_13) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jOffset), UnsafeUtil.getObject(t2, jOffset))) {
                    break;
                }
                break;
            case 11:
                if (arePresentForEquals(t, t2, OplusGLSurfaceView_13) && UnsafeUtil.getInt(t, jOffset) == UnsafeUtil.getInt(t2, jOffset)) {
                    break;
                }
                break;
            case 12:
                if (arePresentForEquals(t, t2, OplusGLSurfaceView_13) && UnsafeUtil.getInt(t, jOffset) == UnsafeUtil.getInt(t2, jOffset)) {
                    break;
                }
                break;
            case 13:
                if (arePresentForEquals(t, t2, OplusGLSurfaceView_13) && UnsafeUtil.getInt(t, jOffset) == UnsafeUtil.getInt(t2, jOffset)) {
                    break;
                }
                break;
            case 14:
                if (arePresentForEquals(t, t2, OplusGLSurfaceView_13) && UnsafeUtil.getLong(t, jOffset) == UnsafeUtil.getLong(t2, jOffset)) {
                    break;
                }
                break;
            case 15:
                if (arePresentForEquals(t, t2, OplusGLSurfaceView_13) && UnsafeUtil.getInt(t, jOffset) == UnsafeUtil.getInt(t2, jOffset)) {
                    break;
                }
                break;
            case 16:
                if (arePresentForEquals(t, t2, OplusGLSurfaceView_13) && UnsafeUtil.getLong(t, jOffset) == UnsafeUtil.getLong(t2, jOffset)) {
                    break;
                }
                break;
            case 17:
                if (arePresentForEquals(t, t2, OplusGLSurfaceView_13) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jOffset), UnsafeUtil.getObject(t2, jOffset))) {
                    break;
                }
                break;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                if (isOneofCaseEqual(t, t2, OplusGLSurfaceView_13) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jOffset), UnsafeUtil.getObject(t2, jOffset))) {
                    break;
                }
                break;
        }
        return true;
    }

    @Override // com.google.protobuf.Schema
    public int hashCode(T t) {
        int OplusGLSurfaceView_13;
        int iHashLong;
        int length = this.buffer.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i3);
            int iNumberAt = numberAt(i3);
            long jOffset = offset(iTypeAndOffsetAt);
            int iHashCode = 37;
            switch (type(iTypeAndOffsetAt)) {
                case 0:
                    OplusGLSurfaceView_13 = i2 * 53;
                    iHashLong = Internal.hashLong(Double.doubleToLongBits(UnsafeUtil.getDouble(t, jOffset)));
                    i2 = OplusGLSurfaceView_13 + iHashLong;
                    break;
                case 1:
                    OplusGLSurfaceView_13 = i2 * 53;
                    iHashLong = Float.floatToIntBits(UnsafeUtil.getFloat(t, jOffset));
                    i2 = OplusGLSurfaceView_13 + iHashLong;
                    break;
                case 2:
                    OplusGLSurfaceView_13 = i2 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t, jOffset));
                    i2 = OplusGLSurfaceView_13 + iHashLong;
                    break;
                case 3:
                    OplusGLSurfaceView_13 = i2 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t, jOffset));
                    i2 = OplusGLSurfaceView_13 + iHashLong;
                    break;
                case 4:
                    OplusGLSurfaceView_13 = i2 * 53;
                    iHashLong = UnsafeUtil.getInt(t, jOffset);
                    i2 = OplusGLSurfaceView_13 + iHashLong;
                    break;
                case 5:
                    OplusGLSurfaceView_13 = i2 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t, jOffset));
                    i2 = OplusGLSurfaceView_13 + iHashLong;
                    break;
                case 6:
                    OplusGLSurfaceView_13 = i2 * 53;
                    iHashLong = UnsafeUtil.getInt(t, jOffset);
                    i2 = OplusGLSurfaceView_13 + iHashLong;
                    break;
                case 7:
                    OplusGLSurfaceView_13 = i2 * 53;
                    iHashLong = Internal.hashBoolean(UnsafeUtil.getBoolean(t, jOffset));
                    i2 = OplusGLSurfaceView_13 + iHashLong;
                    break;
                case 8:
                    OplusGLSurfaceView_13 = i2 * 53;
                    iHashLong = ((String) UnsafeUtil.getObject(t, jOffset)).hashCode();
                    i2 = OplusGLSurfaceView_13 + iHashLong;
                    break;
                case 9:
                    Object object = UnsafeUtil.getObject(t, jOffset);
                    if (object != null) {
                        iHashCode = object.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    OplusGLSurfaceView_13 = i2 * 53;
                    iHashLong = UnsafeUtil.getObject(t, jOffset).hashCode();
                    i2 = OplusGLSurfaceView_13 + iHashLong;
                    break;
                case 11:
                    OplusGLSurfaceView_13 = i2 * 53;
                    iHashLong = UnsafeUtil.getInt(t, jOffset);
                    i2 = OplusGLSurfaceView_13 + iHashLong;
                    break;
                case 12:
                    OplusGLSurfaceView_13 = i2 * 53;
                    iHashLong = UnsafeUtil.getInt(t, jOffset);
                    i2 = OplusGLSurfaceView_13 + iHashLong;
                    break;
                case 13:
                    OplusGLSurfaceView_13 = i2 * 53;
                    iHashLong = UnsafeUtil.getInt(t, jOffset);
                    i2 = OplusGLSurfaceView_13 + iHashLong;
                    break;
                case 14:
                    OplusGLSurfaceView_13 = i2 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t, jOffset));
                    i2 = OplusGLSurfaceView_13 + iHashLong;
                    break;
                case 15:
                    OplusGLSurfaceView_13 = i2 * 53;
                    iHashLong = UnsafeUtil.getInt(t, jOffset);
                    i2 = OplusGLSurfaceView_13 + iHashLong;
                    break;
                case 16:
                    OplusGLSurfaceView_13 = i2 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t, jOffset));
                    i2 = OplusGLSurfaceView_13 + iHashLong;
                    break;
                case 17:
                    Object object2 = UnsafeUtil.getObject(t, jOffset);
                    if (object2 != null) {
                        iHashCode = object2.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    OplusGLSurfaceView_13 = i2 * 53;
                    iHashLong = UnsafeUtil.getObject(t, jOffset).hashCode();
                    i2 = OplusGLSurfaceView_13 + iHashLong;
                    break;
                case 50:
                    OplusGLSurfaceView_13 = i2 * 53;
                    iHashLong = UnsafeUtil.getObject(t, jOffset).hashCode();
                    i2 = OplusGLSurfaceView_13 + iHashLong;
                    break;
                case 51:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        OplusGLSurfaceView_13 = i2 * 53;
                        iHashLong = Internal.hashLong(Double.doubleToLongBits(oneofDoubleAt(t, jOffset)));
                        i2 = OplusGLSurfaceView_13 + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        OplusGLSurfaceView_13 = i2 * 53;
                        iHashLong = Float.floatToIntBits(oneofFloatAt(t, jOffset));
                        i2 = OplusGLSurfaceView_13 + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        OplusGLSurfaceView_13 = i2 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t, jOffset));
                        i2 = OplusGLSurfaceView_13 + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        OplusGLSurfaceView_13 = i2 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t, jOffset));
                        i2 = OplusGLSurfaceView_13 + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        OplusGLSurfaceView_13 = i2 * 53;
                        iHashLong = oneofIntAt(t, jOffset);
                        i2 = OplusGLSurfaceView_13 + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        OplusGLSurfaceView_13 = i2 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t, jOffset));
                        i2 = OplusGLSurfaceView_13 + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        OplusGLSurfaceView_13 = i2 * 53;
                        iHashLong = oneofIntAt(t, jOffset);
                        i2 = OplusGLSurfaceView_13 + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        OplusGLSurfaceView_13 = i2 * 53;
                        iHashLong = Internal.hashBoolean(oneofBooleanAt(t, jOffset));
                        i2 = OplusGLSurfaceView_13 + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        OplusGLSurfaceView_13 = i2 * 53;
                        iHashLong = ((String) UnsafeUtil.getObject(t, jOffset)).hashCode();
                        i2 = OplusGLSurfaceView_13 + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        OplusGLSurfaceView_13 = i2 * 53;
                        iHashLong = UnsafeUtil.getObject(t, jOffset).hashCode();
                        i2 = OplusGLSurfaceView_13 + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        OplusGLSurfaceView_13 = i2 * 53;
                        iHashLong = UnsafeUtil.getObject(t, jOffset).hashCode();
                        i2 = OplusGLSurfaceView_13 + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        OplusGLSurfaceView_13 = i2 * 53;
                        iHashLong = oneofIntAt(t, jOffset);
                        i2 = OplusGLSurfaceView_13 + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        OplusGLSurfaceView_13 = i2 * 53;
                        iHashLong = oneofIntAt(t, jOffset);
                        i2 = OplusGLSurfaceView_13 + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        OplusGLSurfaceView_13 = i2 * 53;
                        iHashLong = oneofIntAt(t, jOffset);
                        i2 = OplusGLSurfaceView_13 + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        OplusGLSurfaceView_13 = i2 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t, jOffset));
                        i2 = OplusGLSurfaceView_13 + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        OplusGLSurfaceView_13 = i2 * 53;
                        iHashLong = oneofIntAt(t, jOffset);
                        i2 = OplusGLSurfaceView_13 + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        OplusGLSurfaceView_13 = i2 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t, jOffset));
                        i2 = OplusGLSurfaceView_13 + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        OplusGLSurfaceView_13 = i2 * 53;
                        iHashLong = UnsafeUtil.getObject(t, jOffset).hashCode();
                        i2 = OplusGLSurfaceView_13 + iHashLong;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int iHashCode2 = (i2 * 53) + this.unknownFieldSchema.getFromMessage(t).hashCode();
        return this.hasExtensions ? (iHashCode2 * 53) + this.extensionSchema.getExtensions(t).hashCode() : iHashCode2;
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T t, T t2) {
        if (t2 == null) {
            throw new NullPointerException();
        }
        for (int OplusGLSurfaceView_13 = 0; OplusGLSurfaceView_13 < this.buffer.length; OplusGLSurfaceView_13 += 3) {
            mergeSingleField(t, t2, OplusGLSurfaceView_13);
        }
        if (this.proto3) {
            return;
        }
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, t, t2);
        if (this.hasExtensions) {
            SchemaUtil.mergeExtensions(this.extensionSchema, t, t2);
        }
    }

    private void mergeSingleField(T t, T t2, int OplusGLSurfaceView_13) {
        int iTypeAndOffsetAt = typeAndOffsetAt(OplusGLSurfaceView_13);
        long jOffset = offset(iTypeAndOffsetAt);
        int iNumberAt = numberAt(OplusGLSurfaceView_13);
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                if (isFieldPresent(t2, OplusGLSurfaceView_13)) {
                    UnsafeUtil.putDouble(t, jOffset, UnsafeUtil.getDouble(t2, jOffset));
                    setFieldPresent(t, OplusGLSurfaceView_13);
                    break;
                }
                break;
            case 1:
                if (isFieldPresent(t2, OplusGLSurfaceView_13)) {
                    UnsafeUtil.putFloat(t, jOffset, UnsafeUtil.getFloat(t2, jOffset));
                    setFieldPresent(t, OplusGLSurfaceView_13);
                    break;
                }
                break;
            case 2:
                if (isFieldPresent(t2, OplusGLSurfaceView_13)) {
                    UnsafeUtil.putLong(t, jOffset, UnsafeUtil.getLong(t2, jOffset));
                    setFieldPresent(t, OplusGLSurfaceView_13);
                    break;
                }
                break;
            case 3:
                if (isFieldPresent(t2, OplusGLSurfaceView_13)) {
                    UnsafeUtil.putLong(t, jOffset, UnsafeUtil.getLong(t2, jOffset));
                    setFieldPresent(t, OplusGLSurfaceView_13);
                    break;
                }
                break;
            case 4:
                if (isFieldPresent(t2, OplusGLSurfaceView_13)) {
                    UnsafeUtil.putInt(t, jOffset, UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t, OplusGLSurfaceView_13);
                    break;
                }
                break;
            case 5:
                if (isFieldPresent(t2, OplusGLSurfaceView_13)) {
                    UnsafeUtil.putLong(t, jOffset, UnsafeUtil.getLong(t2, jOffset));
                    setFieldPresent(t, OplusGLSurfaceView_13);
                    break;
                }
                break;
            case 6:
                if (isFieldPresent(t2, OplusGLSurfaceView_13)) {
                    UnsafeUtil.putInt(t, jOffset, UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t, OplusGLSurfaceView_13);
                    break;
                }
                break;
            case 7:
                if (isFieldPresent(t2, OplusGLSurfaceView_13)) {
                    UnsafeUtil.putBoolean(t, jOffset, UnsafeUtil.getBoolean(t2, jOffset));
                    setFieldPresent(t, OplusGLSurfaceView_13);
                    break;
                }
                break;
            case 8:
                if (isFieldPresent(t2, OplusGLSurfaceView_13)) {
                    UnsafeUtil.putObject(t, jOffset, UnsafeUtil.getObject(t2, jOffset));
                    setFieldPresent(t, OplusGLSurfaceView_13);
                    break;
                }
                break;
            case 9:
                mergeMessage(t, t2, OplusGLSurfaceView_13);
                break;
            case 10:
                if (isFieldPresent(t2, OplusGLSurfaceView_13)) {
                    UnsafeUtil.putObject(t, jOffset, UnsafeUtil.getObject(t2, jOffset));
                    setFieldPresent(t, OplusGLSurfaceView_13);
                    break;
                }
                break;
            case 11:
                if (isFieldPresent(t2, OplusGLSurfaceView_13)) {
                    UnsafeUtil.putInt(t, jOffset, UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t, OplusGLSurfaceView_13);
                    break;
                }
                break;
            case 12:
                if (isFieldPresent(t2, OplusGLSurfaceView_13)) {
                    UnsafeUtil.putInt(t, jOffset, UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t, OplusGLSurfaceView_13);
                    break;
                }
                break;
            case 13:
                if (isFieldPresent(t2, OplusGLSurfaceView_13)) {
                    UnsafeUtil.putInt(t, jOffset, UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t, OplusGLSurfaceView_13);
                    break;
                }
                break;
            case 14:
                if (isFieldPresent(t2, OplusGLSurfaceView_13)) {
                    UnsafeUtil.putLong(t, jOffset, UnsafeUtil.getLong(t2, jOffset));
                    setFieldPresent(t, OplusGLSurfaceView_13);
                    break;
                }
                break;
            case 15:
                if (isFieldPresent(t2, OplusGLSurfaceView_13)) {
                    UnsafeUtil.putInt(t, jOffset, UnsafeUtil.getInt(t2, jOffset));
                    setFieldPresent(t, OplusGLSurfaceView_13);
                    break;
                }
                break;
            case 16:
                if (isFieldPresent(t2, OplusGLSurfaceView_13)) {
                    UnsafeUtil.putLong(t, jOffset, UnsafeUtil.getLong(t2, jOffset));
                    setFieldPresent(t, OplusGLSurfaceView_13);
                    break;
                }
                break;
            case 17:
                mergeMessage(t, t2, OplusGLSurfaceView_13);
                break;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                this.listFieldSchema.mergeListsAt(t, t2, jOffset);
                break;
            case 50:
                SchemaUtil.mergeMap(this.mapFieldSchema, t, t2, jOffset);
                break;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                if (isOneofPresent(t2, iNumberAt, OplusGLSurfaceView_13)) {
                    UnsafeUtil.putObject(t, jOffset, UnsafeUtil.getObject(t2, jOffset));
                    setOneofPresent(t, iNumberAt, OplusGLSurfaceView_13);
                    break;
                }
                break;
            case 60:
                mergeOneofMessage(t, t2, OplusGLSurfaceView_13);
                break;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
                if (isOneofPresent(t2, iNumberAt, OplusGLSurfaceView_13)) {
                    UnsafeUtil.putObject(t, jOffset, UnsafeUtil.getObject(t2, jOffset));
                    setOneofPresent(t, iNumberAt, OplusGLSurfaceView_13);
                    break;
                }
                break;
            case 68:
                mergeOneofMessage(t, t2, OplusGLSurfaceView_13);
                break;
        }
    }

    private void mergeMessage(T t, T t2, int OplusGLSurfaceView_13) {
        long jOffset = offset(typeAndOffsetAt(OplusGLSurfaceView_13));
        if (isFieldPresent(t2, OplusGLSurfaceView_13)) {
            Object object = UnsafeUtil.getObject(t, jOffset);
            Object object2 = UnsafeUtil.getObject(t2, jOffset);
            if (object != null && object2 != null) {
                UnsafeUtil.putObject(t, jOffset, Internal.mergeMessage(object, object2));
                setFieldPresent(t, OplusGLSurfaceView_13);
            } else if (object2 != null) {
                UnsafeUtil.putObject(t, jOffset, object2);
                setFieldPresent(t, OplusGLSurfaceView_13);
            }
        }
    }

    private void mergeOneofMessage(T t, T t2, int OplusGLSurfaceView_13) {
        int iTypeAndOffsetAt = typeAndOffsetAt(OplusGLSurfaceView_13);
        int iNumberAt = numberAt(OplusGLSurfaceView_13);
        long jOffset = offset(iTypeAndOffsetAt);
        if (isOneofPresent(t2, iNumberAt, OplusGLSurfaceView_13)) {
            Object object = UnsafeUtil.getObject(t, jOffset);
            Object object2 = UnsafeUtil.getObject(t2, jOffset);
            if (object != null && object2 != null) {
                UnsafeUtil.putObject(t, jOffset, Internal.mergeMessage(object, object2));
                setOneofPresent(t, iNumberAt, OplusGLSurfaceView_13);
            } else if (object2 != null) {
                UnsafeUtil.putObject(t, jOffset, object2);
                setOneofPresent(t, iNumberAt, OplusGLSurfaceView_13);
            }
        }
    }

    @Override // com.google.protobuf.Schema
    public int getSerializedSize(T t) {
        return this.proto3 ? getSerializedSizeProto3(t) : getSerializedSizeProto2(t);
    }

    private int getSerializedSizeProto2(T t) {
        int OplusGLSurfaceView_13;
        int i2;
        int iComputeDoubleSize;
        int iComputeSizeFixed64ListNoTag;
        int iComputeTagSize;
        int iComputeUInt32SizeNoTag;
        Unsafe unsafe = UNSAFE;
        int i3 = 0;
        int i4 = 0;
        int i5 = -1;
        for (int i6 = 0; i6 < this.buffer.length; i6 += 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i6);
            int iNumberAt = numberAt(i6);
            int iType = type(iTypeAndOffsetAt);
            if (iType <= 17) {
                OplusGLSurfaceView_13 = this.buffer[i6 + 2];
                int i7 = OFFSET_MASK & OplusGLSurfaceView_13;
                int i8 = 1 << (OplusGLSurfaceView_13 >>> 20);
                if (i7 != i5) {
                    i4 = unsafe.getInt(t, i7);
                    i5 = i7;
                }
                i2 = i8;
            } else if (!this.useCachedSizeField || iType < FieldType.DOUBLE_LIST_PACKED.m8337id() || iType > FieldType.SINT64_LIST_PACKED.m8337id()) {
                OplusGLSurfaceView_13 = 0;
                i2 = 0;
            } else {
                OplusGLSurfaceView_13 = this.buffer[i6 + 2] & OFFSET_MASK;
                i2 = 0;
            }
            long jOffset = offset(iTypeAndOffsetAt);
            switch (iType) {
                case 0:
                    if ((i4 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if ((i4 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if ((i4 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeInt64Size(iNumberAt, unsafe.getLong(t, jOffset));
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if ((i4 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt64Size(iNumberAt, unsafe.getLong(t, jOffset));
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if ((i4 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeInt32Size(iNumberAt, unsafe.getInt(t, jOffset));
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if ((i4 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if ((i4 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if ((i4 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if ((i4 & i2) != 0) {
                        Object object = unsafe.getObject(t, jOffset);
                        if (object instanceof ByteString) {
                            iComputeDoubleSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object);
                        } else {
                            iComputeDoubleSize = CodedOutputStream.computeStringSize(iNumberAt, (String) object);
                        }
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if ((i4 & i2) != 0) {
                        iComputeDoubleSize = SchemaUtil.computeSizeMessage(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i6));
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if ((i4 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) unsafe.getObject(t, jOffset));
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if ((i4 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt32Size(iNumberAt, unsafe.getInt(t, jOffset));
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if ((i4 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeEnumSize(iNumberAt, unsafe.getInt(t, jOffset));
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if ((i4 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if ((i4 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if ((i4 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt32Size(iNumberAt, unsafe.getInt(t, jOffset));
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if ((i4 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt64Size(iNumberAt, unsafe.getLong(t, jOffset));
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if ((i4 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) unsafe.getObject(t, jOffset), getMessageFieldSchema(i6));
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i3 += iComputeDoubleSize;
                    break;
                case 19:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i3 += iComputeDoubleSize;
                    break;
                case 20:
                    iComputeDoubleSize = SchemaUtil.computeSizeInt64List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i3 += iComputeDoubleSize;
                    break;
                case 21:
                    iComputeDoubleSize = SchemaUtil.computeSizeUInt64List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i3 += iComputeDoubleSize;
                    break;
                case 22:
                    iComputeDoubleSize = SchemaUtil.computeSizeInt32List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i3 += iComputeDoubleSize;
                    break;
                case 23:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i3 += iComputeDoubleSize;
                    break;
                case 24:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i3 += iComputeDoubleSize;
                    break;
                case 25:
                    iComputeDoubleSize = SchemaUtil.computeSizeBoolList(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i3 += iComputeDoubleSize;
                    break;
                case 26:
                    iComputeDoubleSize = SchemaUtil.computeSizeStringList(iNumberAt, (List) unsafe.getObject(t, jOffset));
                    i3 += iComputeDoubleSize;
                    break;
                case 27:
                    iComputeDoubleSize = SchemaUtil.computeSizeMessageList(iNumberAt, (List) unsafe.getObject(t, jOffset), getMessageFieldSchema(i6));
                    i3 += iComputeDoubleSize;
                    break;
                case 28:
                    iComputeDoubleSize = SchemaUtil.computeSizeByteStringList(iNumberAt, (List) unsafe.getObject(t, jOffset));
                    i3 += iComputeDoubleSize;
                    break;
                case 29:
                    iComputeDoubleSize = SchemaUtil.computeSizeUInt32List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i3 += iComputeDoubleSize;
                    break;
                case 30:
                    iComputeDoubleSize = SchemaUtil.computeSizeEnumList(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i3 += iComputeDoubleSize;
                    break;
                case 31:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i3 += iComputeDoubleSize;
                    break;
                case 32:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i3 += iComputeDoubleSize;
                    break;
                case 33:
                    iComputeDoubleSize = SchemaUtil.computeSizeSInt32List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i3 += iComputeDoubleSize;
                    break;
                case 34:
                    iComputeDoubleSize = SchemaUtil.computeSizeSInt64List(iNumberAt, (List) unsafe.getObject(t, jOffset), false);
                    i3 += iComputeDoubleSize;
                    break;
                case 35:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, OplusGLSurfaceView_13, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i3 += iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        break;
                    }
                case 36:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, OplusGLSurfaceView_13, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i3 += iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        break;
                    }
                case 37:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, OplusGLSurfaceView_13, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i3 += iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        break;
                    }
                case 38:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, OplusGLSurfaceView_13, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i3 += iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        break;
                    }
                case 39:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, OplusGLSurfaceView_13, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i3 += iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        break;
                    }
                case 40:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, OplusGLSurfaceView_13, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i3 += iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        break;
                    }
                case 41:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, OplusGLSurfaceView_13, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i3 += iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        break;
                    }
                case 42:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, OplusGLSurfaceView_13, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i3 += iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        break;
                    }
                case 43:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, OplusGLSurfaceView_13, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i3 += iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        break;
                    }
                case 44:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, OplusGLSurfaceView_13, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i3 += iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        break;
                    }
                case 45:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, OplusGLSurfaceView_13, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i3 += iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        break;
                    }
                case 46:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, OplusGLSurfaceView_13, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i3 += iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        break;
                    }
                case 47:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, OplusGLSurfaceView_13, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i3 += iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        break;
                    }
                case 48:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, OplusGLSurfaceView_13, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        i3 += iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        break;
                    }
                case 49:
                    iComputeDoubleSize = SchemaUtil.computeSizeGroupList(iNumberAt, (List) unsafe.getObject(t, jOffset), getMessageFieldSchema(i6));
                    i3 += iComputeDoubleSize;
                    break;
                case 50:
                    iComputeDoubleSize = this.mapFieldSchema.getSerializedSize(iNumberAt, unsafe.getObject(t, jOffset), getMapFieldDefaultEntry(i6));
                    i3 += iComputeDoubleSize;
                    break;
                case 51:
                    if (isOneofPresent(t, iNumberAt, i6)) {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (isOneofPresent(t, iNumberAt, i6)) {
                        iComputeDoubleSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (isOneofPresent(t, iNumberAt, i6)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt64Size(iNumberAt, oneofLongAt(t, jOffset));
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (isOneofPresent(t, iNumberAt, i6)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt64Size(iNumberAt, oneofLongAt(t, jOffset));
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (isOneofPresent(t, iNumberAt, i6)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt32Size(iNumberAt, oneofIntAt(t, jOffset));
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (isOneofPresent(t, iNumberAt, i6)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (isOneofPresent(t, iNumberAt, i6)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (isOneofPresent(t, iNumberAt, i6)) {
                        iComputeDoubleSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (isOneofPresent(t, iNumberAt, i6)) {
                        Object object2 = unsafe.getObject(t, jOffset);
                        if (object2 instanceof ByteString) {
                            iComputeDoubleSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object2);
                        } else {
                            iComputeDoubleSize = CodedOutputStream.computeStringSize(iNumberAt, (String) object2);
                        }
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (isOneofPresent(t, iNumberAt, i6)) {
                        iComputeDoubleSize = SchemaUtil.computeSizeMessage(iNumberAt, unsafe.getObject(t, jOffset), getMessageFieldSchema(i6));
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (isOneofPresent(t, iNumberAt, i6)) {
                        iComputeDoubleSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) unsafe.getObject(t, jOffset));
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (isOneofPresent(t, iNumberAt, i6)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt32Size(iNumberAt, oneofIntAt(t, jOffset));
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (isOneofPresent(t, iNumberAt, i6)) {
                        iComputeDoubleSize = CodedOutputStream.computeEnumSize(iNumberAt, oneofIntAt(t, jOffset));
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (isOneofPresent(t, iNumberAt, i6)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (isOneofPresent(t, iNumberAt, i6)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (isOneofPresent(t, iNumberAt, i6)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt32Size(iNumberAt, oneofIntAt(t, jOffset));
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (isOneofPresent(t, iNumberAt, i6)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt64Size(iNumberAt, oneofLongAt(t, jOffset));
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (isOneofPresent(t, iNumberAt, i6)) {
                        iComputeDoubleSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) unsafe.getObject(t, jOffset), getMessageFieldSchema(i6));
                        i3 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int unknownFieldsSerializedSize = i3 + getUnknownFieldsSerializedSize(this.unknownFieldSchema, t);
        return this.hasExtensions ? unknownFieldsSerializedSize + this.extensionSchema.getExtensions(t).getSerializedSize() : unknownFieldsSerializedSize;
    }

    private int getSerializedSizeProto3(T t) {
        int iComputeDoubleSize;
        int iComputeSizeFixed64ListNoTag;
        int iComputeTagSize;
        int iComputeUInt32SizeNoTag;
        Unsafe unsafe = UNSAFE;
        int OplusGLSurfaceView_13 = 0;
        for (int i2 = 0; i2 < this.buffer.length; i2 += 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i2);
            int iType = type(iTypeAndOffsetAt);
            int iNumberAt = numberAt(i2);
            long jOffset = offset(iTypeAndOffsetAt);
            int i3 = (iType < FieldType.DOUBLE_LIST_PACKED.m8337id() || iType > FieldType.SINT64_LIST_PACKED.m8337id()) ? 0 : this.buffer[i2 + 2] & OFFSET_MASK;
            switch (iType) {
                case 0:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt64Size(iNumberAt, UnsafeUtil.getLong(t, jOffset));
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt64Size(iNumberAt, UnsafeUtil.getLong(t, jOffset));
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt32Size(iNumberAt, UnsafeUtil.getInt(t, jOffset));
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (isFieldPresent(t, i2)) {
                        Object object = UnsafeUtil.getObject(t, jOffset);
                        if (object instanceof ByteString) {
                            iComputeDoubleSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object);
                        } else {
                            iComputeDoubleSize = CodedOutputStream.computeStringSize(iNumberAt, (String) object);
                        }
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = SchemaUtil.computeSizeMessage(iNumberAt, UnsafeUtil.getObject(t, jOffset), getMessageFieldSchema(i2));
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) UnsafeUtil.getObject(t, jOffset));
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt32Size(iNumberAt, UnsafeUtil.getInt(t, jOffset));
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeEnumSize(iNumberAt, UnsafeUtil.getInt(t, jOffset));
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt32Size(iNumberAt, UnsafeUtil.getInt(t, jOffset));
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt64Size(iNumberAt, UnsafeUtil.getLong(t, jOffset));
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) UnsafeUtil.getObject(t, jOffset), getMessageFieldSchema(i2));
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed64List(iNumberAt, listAt(t, jOffset), false);
                    OplusGLSurfaceView_13 += iComputeDoubleSize;
                    break;
                case 19:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed32List(iNumberAt, listAt(t, jOffset), false);
                    OplusGLSurfaceView_13 += iComputeDoubleSize;
                    break;
                case 20:
                    iComputeDoubleSize = SchemaUtil.computeSizeInt64List(iNumberAt, listAt(t, jOffset), false);
                    OplusGLSurfaceView_13 += iComputeDoubleSize;
                    break;
                case 21:
                    iComputeDoubleSize = SchemaUtil.computeSizeUInt64List(iNumberAt, listAt(t, jOffset), false);
                    OplusGLSurfaceView_13 += iComputeDoubleSize;
                    break;
                case 22:
                    iComputeDoubleSize = SchemaUtil.computeSizeInt32List(iNumberAt, listAt(t, jOffset), false);
                    OplusGLSurfaceView_13 += iComputeDoubleSize;
                    break;
                case 23:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed64List(iNumberAt, listAt(t, jOffset), false);
                    OplusGLSurfaceView_13 += iComputeDoubleSize;
                    break;
                case 24:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed32List(iNumberAt, listAt(t, jOffset), false);
                    OplusGLSurfaceView_13 += iComputeDoubleSize;
                    break;
                case 25:
                    iComputeDoubleSize = SchemaUtil.computeSizeBoolList(iNumberAt, listAt(t, jOffset), false);
                    OplusGLSurfaceView_13 += iComputeDoubleSize;
                    break;
                case 26:
                    iComputeDoubleSize = SchemaUtil.computeSizeStringList(iNumberAt, listAt(t, jOffset));
                    OplusGLSurfaceView_13 += iComputeDoubleSize;
                    break;
                case 27:
                    iComputeDoubleSize = SchemaUtil.computeSizeMessageList(iNumberAt, listAt(t, jOffset), getMessageFieldSchema(i2));
                    OplusGLSurfaceView_13 += iComputeDoubleSize;
                    break;
                case 28:
                    iComputeDoubleSize = SchemaUtil.computeSizeByteStringList(iNumberAt, listAt(t, jOffset));
                    OplusGLSurfaceView_13 += iComputeDoubleSize;
                    break;
                case 29:
                    iComputeDoubleSize = SchemaUtil.computeSizeUInt32List(iNumberAt, listAt(t, jOffset), false);
                    OplusGLSurfaceView_13 += iComputeDoubleSize;
                    break;
                case 30:
                    iComputeDoubleSize = SchemaUtil.computeSizeEnumList(iNumberAt, listAt(t, jOffset), false);
                    OplusGLSurfaceView_13 += iComputeDoubleSize;
                    break;
                case 31:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed32List(iNumberAt, listAt(t, jOffset), false);
                    OplusGLSurfaceView_13 += iComputeDoubleSize;
                    break;
                case 32:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed64List(iNumberAt, listAt(t, jOffset), false);
                    OplusGLSurfaceView_13 += iComputeDoubleSize;
                    break;
                case 33:
                    iComputeDoubleSize = SchemaUtil.computeSizeSInt32List(iNumberAt, listAt(t, jOffset), false);
                    OplusGLSurfaceView_13 += iComputeDoubleSize;
                    break;
                case 34:
                    iComputeDoubleSize = SchemaUtil.computeSizeSInt64List(iNumberAt, listAt(t, jOffset), false);
                    OplusGLSurfaceView_13 += iComputeDoubleSize;
                    break;
                case 35:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    }
                case 36:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    }
                case 37:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    }
                case 38:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    }
                case 39:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    }
                case 40:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    }
                case 41:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    }
                case 42:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    }
                case 43:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    }
                case 44:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    }
                case 45:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    }
                case 46:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    }
                case 47:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    }
                case 48:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(t, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    }
                case 49:
                    iComputeDoubleSize = SchemaUtil.computeSizeGroupList(iNumberAt, listAt(t, jOffset), getMessageFieldSchema(i2));
                    OplusGLSurfaceView_13 += iComputeDoubleSize;
                    break;
                case 50:
                    iComputeDoubleSize = this.mapFieldSchema.getSerializedSize(iNumberAt, UnsafeUtil.getObject(t, jOffset), getMapFieldDefaultEntry(i2));
                    OplusGLSurfaceView_13 += iComputeDoubleSize;
                    break;
                case 51:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt64Size(iNumberAt, oneofLongAt(t, jOffset));
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt64Size(iNumberAt, oneofLongAt(t, jOffset));
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt32Size(iNumberAt, oneofIntAt(t, jOffset));
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        Object object2 = UnsafeUtil.getObject(t, jOffset);
                        if (object2 instanceof ByteString) {
                            iComputeDoubleSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object2);
                        } else {
                            iComputeDoubleSize = CodedOutputStream.computeStringSize(iNumberAt, (String) object2);
                        }
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = SchemaUtil.computeSizeMessage(iNumberAt, UnsafeUtil.getObject(t, jOffset), getMessageFieldSchema(i2));
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) UnsafeUtil.getObject(t, jOffset));
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt32Size(iNumberAt, oneofIntAt(t, jOffset));
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeEnumSize(iNumberAt, oneofIntAt(t, jOffset));
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt32Size(iNumberAt, oneofIntAt(t, jOffset));
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt64Size(iNumberAt, oneofLongAt(t, jOffset));
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) UnsafeUtil.getObject(t, jOffset), getMessageFieldSchema(i2));
                        OplusGLSurfaceView_13 += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
            }
        }
        return OplusGLSurfaceView_13 + getUnknownFieldsSerializedSize(this.unknownFieldSchema, t);
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t) {
        return unknownFieldSchema.getSerializedSize(unknownFieldSchema.getFromMessage(t));
    }

    private static List<?> listAt(Object obj, long OplusGLSurfaceView_15) {
        return (List) UnsafeUtil.getObject(obj, OplusGLSurfaceView_15);
    }

    @Override // com.google.protobuf.Schema
    public void writeTo(T t, Writer writer) throws IOException {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            writeFieldsInDescendingOrder(t, writer);
        } else if (this.proto3) {
            writeFieldsInAscendingOrderProto3(t, writer);
        } else {
            writeFieldsInAscendingOrderProto2(t, writer);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void writeFieldsInAscendingOrderProto2(T r18, com.google.protobuf.Writer r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1484
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.writeFieldsInAscendingOrderProto2(java.lang.Object, com.google.protobuf.Writer):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void writeFieldsInAscendingOrderProto3(T r13, com.google.protobuf.Writer r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1586
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.writeFieldsInAscendingOrderProto3(java.lang.Object, com.google.protobuf.Writer):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void writeFieldsInDescendingOrder(T r11, com.google.protobuf.Writer r12) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1586
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.writeFieldsInDescendingOrder(java.lang.Object, com.google.protobuf.Writer):void");
    }

    private <K, V> void writeMapHelper(Writer writer, int OplusGLSurfaceView_13, Object obj, int i2) throws IOException {
        if (obj != null) {
            writer.writeMap(OplusGLSurfaceView_13, this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i2)), this.mapFieldSchema.forMapData(obj));
        }
    }

    private <UT, UB> void writeUnknownInMessageTo(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t, Writer writer) throws IOException {
        unknownFieldSchema.writeTo(unknownFieldSchema.getFromMessage(t), writer);
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T t, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        if (extensionRegistryLite == null) {
            throw new NullPointerException();
        }
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, t, reader, extensionRegistryLite);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0076, code lost:
    
        r0 = r16.checkInitializedCount;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007a, code lost:
    
        if (r0 >= r16.repeatedFieldOffsetStart) goto L357;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007c, code lost:
    
        r13 = filterMapUnknownEnumValues(r19, r16.intArray[r0], r13, r17);
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:361:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0087, code lost:
    
        if (r13 == null) goto L361;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0089, code lost:
    
        r17.setBuilderToMessage(r19, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x008c, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private <UT, UB, ET extends com.google.protobuf.FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(com.google.protobuf.UnknownFieldSchema<UT, UB> r17, com.google.protobuf.ExtensionSchema<ET> r18, T r19, com.google.protobuf.Reader r20, com.google.protobuf.ExtensionRegistryLite r21) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1718
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.mergeFromHelper(com.google.protobuf.UnknownFieldSchema, com.google.protobuf.ExtensionSchema, java.lang.Object, com.google.protobuf.Reader, com.google.protobuf.ExtensionRegistryLite):void");
    }

    static UnknownFieldSetLite getMutableUnknownFields(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite != UnknownFieldSetLite.getDefaultInstance()) {
            return unknownFieldSetLite;
        }
        UnknownFieldSetLite unknownFieldSetLiteNewInstance = UnknownFieldSetLite.newInstance();
        generatedMessageLite.unknownFields = unknownFieldSetLiteNewInstance;
        return unknownFieldSetLiteNewInstance;
    }

    /* renamed from: com.google.protobuf.MessageSchema$1 */
    static /* synthetic */ class C20681 {

        /* renamed from: $SwitchMap$com$google$protobuf$WireFormat$FieldType */
        static final /* synthetic */ int[] f9282xbcb373fd = new int[WireFormat.FieldType.values().length];

        static {
            try {
                f9282xbcb373fd[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9282xbcb373fd[WireFormat.FieldType.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9282xbcb373fd[WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9282xbcb373fd[WireFormat.FieldType.FIXED32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9282xbcb373fd[WireFormat.FieldType.SFIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9282xbcb373fd[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f9282xbcb373fd[WireFormat.FieldType.SFIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f9282xbcb373fd[WireFormat.FieldType.FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f9282xbcb373fd[WireFormat.FieldType.ENUM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f9282xbcb373fd[WireFormat.FieldType.INT32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f9282xbcb373fd[WireFormat.FieldType.UINT32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f9282xbcb373fd[WireFormat.FieldType.INT64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f9282xbcb373fd[WireFormat.FieldType.UINT64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f9282xbcb373fd[WireFormat.FieldType.MESSAGE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f9282xbcb373fd[WireFormat.FieldType.SINT32.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f9282xbcb373fd[WireFormat.FieldType.SINT64.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f9282xbcb373fd[WireFormat.FieldType.STRING.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private int decodeMapEntryValue(byte[] bArr, int OplusGLSurfaceView_13, int i2, WireFormat.FieldType fieldType, Class<?> cls, ArrayDecoders.Registers registers) throws IOException {
        switch (C20681.f9282xbcb373fd[fieldType.ordinal()]) {
            case 1:
                int iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr, OplusGLSurfaceView_13, registers);
                registers.object1 = Boolean.valueOf(registers.long1 != 0);
                return iDecodeVarint64;
            case 2:
                return ArrayDecoders.decodeBytes(bArr, OplusGLSurfaceView_13, registers);
            case 3:
                registers.object1 = Double.valueOf(ArrayDecoders.decodeDouble(bArr, OplusGLSurfaceView_13));
                return OplusGLSurfaceView_13 + 8;
            case 4:
            case 5:
                registers.object1 = Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, OplusGLSurfaceView_13));
                return OplusGLSurfaceView_13 + 4;
            case 6:
            case 7:
                registers.object1 = Long.valueOf(ArrayDecoders.decodeFixed64(bArr, OplusGLSurfaceView_13));
                return OplusGLSurfaceView_13 + 8;
            case 8:
                registers.object1 = Float.valueOf(ArrayDecoders.decodeFloat(bArr, OplusGLSurfaceView_13));
                return OplusGLSurfaceView_13 + 4;
            case 9:
            case 10:
            case 11:
                int iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr, OplusGLSurfaceView_13, registers);
                registers.object1 = Integer.valueOf(registers.int1);
                return iDecodeVarint32;
            case 12:
            case 13:
                int iDecodeVarint642 = ArrayDecoders.decodeVarint64(bArr, OplusGLSurfaceView_13, registers);
                registers.object1 = Long.valueOf(registers.long1);
                return iDecodeVarint642;
            case 14:
                return ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor((Class) cls), bArr, OplusGLSurfaceView_13, i2, registers);
            case 15:
                int iDecodeVarint322 = ArrayDecoders.decodeVarint32(bArr, OplusGLSurfaceView_13, registers);
                registers.object1 = Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1));
                return iDecodeVarint322;
            case 16:
                int iDecodeVarint643 = ArrayDecoders.decodeVarint64(bArr, OplusGLSurfaceView_13, registers);
                registers.object1 = Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1));
                return iDecodeVarint643;
            case 17:
                return ArrayDecoders.decodeStringRequireUtf8(bArr, OplusGLSurfaceView_13, registers);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r19v0, types: [java.util.Map, java.util.Map<K, V>] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    private <K, V> int decodeMapEntry(byte[] bArr, int OplusGLSurfaceView_13, int i2, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map, ArrayDecoders.Registers registers) throws IOException {
        int iDecodeVarint32;
        int iDecodeVarint322 = ArrayDecoders.decodeVarint32(bArr, OplusGLSurfaceView_13, registers);
        int i3 = registers.int1;
        if (i3 < 0 || i3 > i2 - iDecodeVarint322) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int i4 = iDecodeVarint322 + i3;
        Object obj = metadata.defaultKey;
        Object obj2 = metadata.defaultValue;
        while (iDecodeVarint322 < i4) {
            int i5 = iDecodeVarint322 + 1;
            byte b2 = bArr[iDecodeVarint322];
            if (b2 < 0) {
                iDecodeVarint32 = ArrayDecoders.decodeVarint32(b2, bArr, i5, registers);
                b2 = registers.int1;
            } else {
                iDecodeVarint32 = i5;
            }
            int i6 = b2 >>> 3;
            int i7 = b2 & 7;
            if (i6 == 1) {
                if (i7 == metadata.keyType.getWireType()) {
                    iDecodeVarint322 = decodeMapEntryValue(bArr, iDecodeVarint32, i2, metadata.keyType, null, registers);
                    obj = registers.object1;
                } else {
                    iDecodeVarint322 = ArrayDecoders.skipField(b2, bArr, iDecodeVarint32, i2, registers);
                }
            } else if (i6 == 2 && i7 == metadata.valueType.getWireType()) {
                iDecodeVarint322 = decodeMapEntryValue(bArr, iDecodeVarint32, i2, metadata.valueType, metadata.defaultValue.getClass(), registers);
                obj2 = registers.object1;
            } else {
                iDecodeVarint322 = ArrayDecoders.skipField(b2, bArr, iDecodeVarint32, i2, registers);
            }
        }
        if (iDecodeVarint322 != i4) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        map.put(obj, obj2);
        return i4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int parseRepeatedField(T t, byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int i6, long OplusGLSurfaceView_15, int i7, long j2, ArrayDecoders.Registers registers) throws IOException {
        int iDecodeVarint32List;
        Internal.ProtobufList protobufListMutableCopyWithCapacity2 = (Internal.ProtobufList) UNSAFE.getObject(t, j2);
        if (!protobufListMutableCopyWithCapacity2.isModifiable()) {
            int size = protobufListMutableCopyWithCapacity2.size();
            protobufListMutableCopyWithCapacity2 = protobufListMutableCopyWithCapacity2.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
            UNSAFE.putObject(t, j2, protobufListMutableCopyWithCapacity2);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedDoubleList(bArr, OplusGLSurfaceView_13, protobufListMutableCopyWithCapacity2, registers);
                }
                if (i5 == 1) {
                    return ArrayDecoders.decodeDoubleList(i3, bArr, OplusGLSurfaceView_13, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                break;
            case 19:
            case 36:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedFloatList(bArr, OplusGLSurfaceView_13, protobufListMutableCopyWithCapacity2, registers);
                }
                if (i5 == 5) {
                    return ArrayDecoders.decodeFloatList(i3, bArr, OplusGLSurfaceView_13, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedVarint64List(bArr, OplusGLSurfaceView_13, protobufListMutableCopyWithCapacity2, registers);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeVarint64List(i3, bArr, OplusGLSurfaceView_13, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedVarint32List(bArr, OplusGLSurfaceView_13, protobufListMutableCopyWithCapacity2, registers);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeVarint32List(i3, bArr, OplusGLSurfaceView_13, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedFixed64List(bArr, OplusGLSurfaceView_13, protobufListMutableCopyWithCapacity2, registers);
                }
                if (i5 == 1) {
                    return ArrayDecoders.decodeFixed64List(i3, bArr, OplusGLSurfaceView_13, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedFixed32List(bArr, OplusGLSurfaceView_13, protobufListMutableCopyWithCapacity2, registers);
                }
                if (i5 == 5) {
                    return ArrayDecoders.decodeFixed32List(i3, bArr, OplusGLSurfaceView_13, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                break;
            case 25:
            case 42:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedBoolList(bArr, OplusGLSurfaceView_13, protobufListMutableCopyWithCapacity2, registers);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeBoolList(i3, bArr, OplusGLSurfaceView_13, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                break;
            case 26:
                if (i5 == 2) {
                    if ((OplusGLSurfaceView_15 & 536870912) == 0) {
                        return ArrayDecoders.decodeStringList(i3, bArr, OplusGLSurfaceView_13, i2, protobufListMutableCopyWithCapacity2, registers);
                    }
                    return ArrayDecoders.decodeStringListRequireUtf8(i3, bArr, OplusGLSurfaceView_13, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                break;
            case 27:
                if (i5 == 2) {
                    return ArrayDecoders.decodeMessageList(getMessageFieldSchema(i6), i3, bArr, OplusGLSurfaceView_13, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                break;
            case 28:
                if (i5 == 2) {
                    return ArrayDecoders.decodeBytesList(i3, bArr, OplusGLSurfaceView_13, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                break;
            case 30:
            case 44:
                if (i5 == 2) {
                    iDecodeVarint32List = ArrayDecoders.decodePackedVarint32List(bArr, OplusGLSurfaceView_13, protobufListMutableCopyWithCapacity2, registers);
                } else if (i5 == 0) {
                    iDecodeVarint32List = ArrayDecoders.decodeVarint32List(i3, bArr, OplusGLSurfaceView_13, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) t;
                UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
                if (unknownFieldSetLite == UnknownFieldSetLite.getDefaultInstance()) {
                    unknownFieldSetLite = null;
                }
                UnknownFieldSetLite unknownFieldSetLite2 = (UnknownFieldSetLite) SchemaUtil.filterUnknownEnumList(i4, (List<Integer>) protobufListMutableCopyWithCapacity2, getEnumFieldVerifier(i6), unknownFieldSetLite, (UnknownFieldSchema<UT, UnknownFieldSetLite>) this.unknownFieldSchema);
                if (unknownFieldSetLite2 != null) {
                    generatedMessageLite.unknownFields = unknownFieldSetLite2;
                }
                return iDecodeVarint32List;
            case 33:
            case 47:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedSInt32List(bArr, OplusGLSurfaceView_13, protobufListMutableCopyWithCapacity2, registers);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeSInt32List(i3, bArr, OplusGLSurfaceView_13, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                break;
            case 34:
            case 48:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedSInt64List(bArr, OplusGLSurfaceView_13, protobufListMutableCopyWithCapacity2, registers);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeSInt64List(i3, bArr, OplusGLSurfaceView_13, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                break;
            case 49:
                if (i5 == 3) {
                    return ArrayDecoders.decodeGroupList(getMessageFieldSchema(i6), i3, bArr, OplusGLSurfaceView_13, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                break;
        }
        return OplusGLSurfaceView_13;
    }

    private <K, V> int parseMapField(T t, byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3, long OplusGLSurfaceView_15, ArrayDecoders.Registers registers) throws IOException {
        Object objNewMapField;
        Unsafe unsafe = UNSAFE;
        Object mapFieldDefaultEntry = getMapFieldDefaultEntry(i3);
        Object object = unsafe.getObject(t, OplusGLSurfaceView_15);
        if (this.mapFieldSchema.isImmutable(object)) {
            objNewMapField = this.mapFieldSchema.newMapField(mapFieldDefaultEntry);
            this.mapFieldSchema.mergeFrom(objNewMapField, object);
            unsafe.putObject(t, OplusGLSurfaceView_15, objNewMapField);
        } else {
            objNewMapField = object;
        }
        return decodeMapEntry(bArr, OplusGLSurfaceView_13, i2, this.mapFieldSchema.forMapMetadata(mapFieldDefaultEntry), this.mapFieldSchema.forMutableMapData(objNewMapField), registers);
    }

    private int parseOneofField(T t, byte[] bArr, int OplusGLSurfaceView_13, int i2, int i3, int i4, int i5, int i6, int i7, long OplusGLSurfaceView_15, int i8, ArrayDecoders.Registers registers) throws IOException {
        Unsafe unsafe = UNSAFE;
        long j2 = this.buffer[i8 + 2] & OFFSET_MASK;
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    unsafe.putObject(t, OplusGLSurfaceView_15, Double.valueOf(ArrayDecoders.decodeDouble(bArr, OplusGLSurfaceView_13)));
                    int i9 = OplusGLSurfaceView_13 + 8;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                break;
            case 52:
                if (i5 == 5) {
                    unsafe.putObject(t, OplusGLSurfaceView_15, Float.valueOf(ArrayDecoders.decodeFloat(bArr, OplusGLSurfaceView_13)));
                    int i10 = OplusGLSurfaceView_13 + 4;
                    unsafe.putInt(t, j2, i4);
                    return i10;
                }
                break;
            case 53:
            case 54:
                if (i5 == 0) {
                    int iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr, OplusGLSurfaceView_13, registers);
                    unsafe.putObject(t, OplusGLSurfaceView_15, Long.valueOf(registers.long1));
                    unsafe.putInt(t, j2, i4);
                    return iDecodeVarint64;
                }
                break;
            case 55:
            case 62:
                if (i5 == 0) {
                    int iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr, OplusGLSurfaceView_13, registers);
                    unsafe.putObject(t, OplusGLSurfaceView_15, Integer.valueOf(registers.int1));
                    unsafe.putInt(t, j2, i4);
                    return iDecodeVarint32;
                }
                break;
            case 56:
            case 65:
                if (i5 == 1) {
                    unsafe.putObject(t, OplusGLSurfaceView_15, Long.valueOf(ArrayDecoders.decodeFixed64(bArr, OplusGLSurfaceView_13)));
                    int i11 = OplusGLSurfaceView_13 + 8;
                    unsafe.putInt(t, j2, i4);
                    return i11;
                }
                break;
            case 57:
            case 64:
                if (i5 == 5) {
                    unsafe.putObject(t, OplusGLSurfaceView_15, Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, OplusGLSurfaceView_13)));
                    int i12 = OplusGLSurfaceView_13 + 4;
                    unsafe.putInt(t, j2, i4);
                    return i12;
                }
                break;
            case 58:
                if (i5 == 0) {
                    int iDecodeVarint642 = ArrayDecoders.decodeVarint64(bArr, OplusGLSurfaceView_13, registers);
                    unsafe.putObject(t, OplusGLSurfaceView_15, Boolean.valueOf(registers.long1 != 0));
                    unsafe.putInt(t, j2, i4);
                    return iDecodeVarint642;
                }
                break;
            case 59:
                if (i5 == 2) {
                    int iDecodeVarint322 = ArrayDecoders.decodeVarint32(bArr, OplusGLSurfaceView_13, registers);
                    int i13 = registers.int1;
                    if (i13 == 0) {
                        unsafe.putObject(t, OplusGLSurfaceView_15, "");
                    } else {
                        if ((i6 & 536870912) != 0 && !Utf8.isValidUtf8(bArr, iDecodeVarint322, iDecodeVarint322 + i13)) {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                        unsafe.putObject(t, OplusGLSurfaceView_15, new String(bArr, iDecodeVarint322, i13, Internal.UTF_8));
                        iDecodeVarint322 += i13;
                    }
                    unsafe.putInt(t, j2, i4);
                    return iDecodeVarint322;
                }
                break;
            case 60:
                if (i5 == 2) {
                    int iDecodeMessageField = ArrayDecoders.decodeMessageField(getMessageFieldSchema(i8), bArr, OplusGLSurfaceView_13, i2, registers);
                    Object object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, OplusGLSurfaceView_15) : null;
                    if (object == null) {
                        unsafe.putObject(t, OplusGLSurfaceView_15, registers.object1);
                    } else {
                        unsafe.putObject(t, OplusGLSurfaceView_15, Internal.mergeMessage(object, registers.object1));
                    }
                    unsafe.putInt(t, j2, i4);
                    return iDecodeMessageField;
                }
                break;
            case 61:
                if (i5 == 2) {
                    int iDecodeBytes = ArrayDecoders.decodeBytes(bArr, OplusGLSurfaceView_13, registers);
                    unsafe.putObject(t, OplusGLSurfaceView_15, registers.object1);
                    unsafe.putInt(t, j2, i4);
                    return iDecodeBytes;
                }
                break;
            case 63:
                if (i5 == 0) {
                    int iDecodeVarint323 = ArrayDecoders.decodeVarint32(bArr, OplusGLSurfaceView_13, registers);
                    int i14 = registers.int1;
                    Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(i8);
                    if (enumFieldVerifier == null || enumFieldVerifier.isInRange(i14)) {
                        unsafe.putObject(t, OplusGLSurfaceView_15, Integer.valueOf(i14));
                        unsafe.putInt(t, j2, i4);
                    } else {
                        getMutableUnknownFields(t).storeField(i3, Long.valueOf(i14));
                    }
                    return iDecodeVarint323;
                }
                break;
            case 66:
                if (i5 == 0) {
                    int iDecodeVarint324 = ArrayDecoders.decodeVarint32(bArr, OplusGLSurfaceView_13, registers);
                    unsafe.putObject(t, OplusGLSurfaceView_15, Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1)));
                    unsafe.putInt(t, j2, i4);
                    return iDecodeVarint324;
                }
                break;
            case 67:
                if (i5 == 0) {
                    int iDecodeVarint643 = ArrayDecoders.decodeVarint64(bArr, OplusGLSurfaceView_13, registers);
                    unsafe.putObject(t, OplusGLSurfaceView_15, Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1)));
                    unsafe.putInt(t, j2, i4);
                    return iDecodeVarint643;
                }
                break;
            case 68:
                if (i5 == 3) {
                    int iDecodeGroupField = ArrayDecoders.decodeGroupField(getMessageFieldSchema(i8), bArr, OplusGLSurfaceView_13, i2, (i3 & (-8)) | 4, registers);
                    Object object2 = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, OplusGLSurfaceView_15) : null;
                    if (object2 == null) {
                        unsafe.putObject(t, OplusGLSurfaceView_15, registers.object1);
                    } else {
                        unsafe.putObject(t, OplusGLSurfaceView_15, Internal.mergeMessage(object2, registers.object1));
                    }
                    unsafe.putInt(t, j2, i4);
                    return iDecodeGroupField;
                }
                break;
        }
        return OplusGLSurfaceView_13;
    }

    private Schema getMessageFieldSchema(int OplusGLSurfaceView_13) {
        int i2 = (OplusGLSurfaceView_13 / 3) * 2;
        Schema schema = (Schema) this.objects[i2];
        if (schema != null) {
            return schema;
        }
        Schema<T> schemaSchemaFor = Protobuf.getInstance().schemaFor((Class) this.objects[i2 + 1]);
        this.objects[i2] = schemaSchemaFor;
        return schemaSchemaFor;
    }

    private Object getMapFieldDefaultEntry(int OplusGLSurfaceView_13) {
        return this.objects[(OplusGLSurfaceView_13 / 3) * 2];
    }

    private Internal.EnumVerifier getEnumFieldVerifier(int OplusGLSurfaceView_13) {
        return (Internal.EnumVerifier) this.objects[((OplusGLSurfaceView_13 / 3) * 2) + 1];
    }

    /* JADX WARN: Code restructure failed: missing block: B:120:0x035d, code lost:
    
        if (r0 != r11) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x035f, code lost:
    
        r15 = r30;
        r14 = r31;
        r12 = r32;
        r13 = r34;
        r11 = r35;
        r9 = r36;
        r1 = r17;
        r3 = r18;
        r7 = r19;
        r2 = r20;
        r6 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x03a6, code lost:
    
        if (r0 != r15) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x03c9, code lost:
    
        if (r0 != r15) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x03cc, code lost:
    
        r2 = r0;
        r8 = r18;
        r0 = r35;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:26:0x008f. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    int parseProto2Message(T r31, byte[] r32, int r33, int r34, int r35, com.google.protobuf.ArrayDecoders.Registers r36) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1184
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.parseProto2Message(java.lang.Object, byte[], int, int, int, com.google.protobuf.ArrayDecoders$Registers):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x022b, code lost:
    
        if (r0 != r15) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x022e, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01de, code lost:
    
        if (r0 != r15) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x020c, code lost:
    
        if (r0 != r15) goto L106;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:18:0x005c. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v12, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int parseProto3Message(T r28, byte[] r29, int r30, int r31, com.google.protobuf.ArrayDecoders.Registers r32) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 642
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.parseProto3Message(java.lang.Object, byte[], int, int, com.google.protobuf.ArrayDecoders$Registers):int");
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T t, byte[] bArr, int OplusGLSurfaceView_13, int i2, ArrayDecoders.Registers registers) throws IOException {
        if (this.proto3) {
            parseProto3Message(t, bArr, OplusGLSurfaceView_13, i2, registers);
        } else {
            parseProto2Message(t, bArr, OplusGLSurfaceView_13, i2, 0, registers);
        }
    }

    @Override // com.google.protobuf.Schema
    public void makeImmutable(T t) {
        int OplusGLSurfaceView_13;
        int i2 = this.checkInitializedCount;
        while (true) {
            OplusGLSurfaceView_13 = this.repeatedFieldOffsetStart;
            if (i2 >= OplusGLSurfaceView_13) {
                break;
            }
            long jOffset = offset(typeAndOffsetAt(this.intArray[i2]));
            Object object = UnsafeUtil.getObject(t, jOffset);
            if (object != null) {
                UnsafeUtil.putObject(t, jOffset, this.mapFieldSchema.toImmutable(object));
            }
            i2++;
        }
        int length = this.intArray.length;
        while (OplusGLSurfaceView_13 < length) {
            this.listFieldSchema.makeImmutableListAt(t, this.intArray[OplusGLSurfaceView_13]);
            OplusGLSurfaceView_13++;
        }
        this.unknownFieldSchema.makeImmutable(t);
        if (this.hasExtensions) {
            this.extensionSchema.makeImmutable(t);
        }
    }

    private final <K, V> void mergeMap(Object obj, int OplusGLSurfaceView_13, Object obj2, ExtensionRegistryLite extensionRegistryLite, Reader reader) throws IOException {
        long jOffset = offset(typeAndOffsetAt(OplusGLSurfaceView_13));
        Object object = UnsafeUtil.getObject(obj, jOffset);
        if (object == null) {
            object = this.mapFieldSchema.newMapField(obj2);
            UnsafeUtil.putObject(obj, jOffset, object);
        } else if (this.mapFieldSchema.isImmutable(object)) {
            Object objNewMapField = this.mapFieldSchema.newMapField(obj2);
            this.mapFieldSchema.mergeFrom(objNewMapField, object);
            UnsafeUtil.putObject(obj, jOffset, objNewMapField);
            object = objNewMapField;
        }
        reader.readMap(this.mapFieldSchema.forMutableMapData(object), this.mapFieldSchema.forMapMetadata(obj2), extensionRegistryLite);
    }

    private final <UT, UB> UB filterMapUnknownEnumValues(Object obj, int OplusGLSurfaceView_13, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        Internal.EnumVerifier enumFieldVerifier;
        int iNumberAt = numberAt(OplusGLSurfaceView_13);
        Object object = UnsafeUtil.getObject(obj, offset(typeAndOffsetAt(OplusGLSurfaceView_13)));
        return (object == null || (enumFieldVerifier = getEnumFieldVerifier(OplusGLSurfaceView_13)) == null) ? ub : (UB) filterUnknownEnumMap(OplusGLSurfaceView_13, iNumberAt, this.mapFieldSchema.forMutableMapData(object), enumFieldVerifier, ub, unknownFieldSchema);
    }

    private final <K, V, UT, UB> UB filterUnknownEnumMap(int OplusGLSurfaceView_13, int i2, Map<K, V> map, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        MapEntryLite.Metadata<?, ?> metadataForMapMetadata = this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(OplusGLSurfaceView_13));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!enumVerifier.isInRange(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = unknownFieldSchema.newBuilder();
                }
                ByteString.CodedBuilder codedBuilderNewCodedBuilder = ByteString.newCodedBuilder(MapEntryLite.computeSerializedSize(metadataForMapMetadata, next.getKey(), next.getValue()));
                try {
                    MapEntryLite.writeTo(codedBuilderNewCodedBuilder.getCodedOutput(), metadataForMapMetadata, next.getKey(), next.getValue());
                    unknownFieldSchema.addLengthDelimited(ub, i2, codedBuilderNewCodedBuilder.build());
                    it.remove();
                } catch (IOException COUIBaseListPopupWindow_8) {
                    throw new RuntimeException(COUIBaseListPopupWindow_8);
                }
            }
        }
        return ub;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x007a  */
    @Override // com.google.protobuf.Schema
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean isInitialized(T r13) {
        /*
            r12 = this;
            r0 = 0
            r1 = -1
            r3 = r0
            r2 = r1
            r1 = r3
        L5:
            int r4 = r12.checkInitializedCount
            r5 = 1
            if (r1 >= r4) goto L96
            int[] r4 = r12.intArray
            r4 = r4[r1]
            int r6 = r12.numberAt(r4)
            int r7 = r12.typeAndOffsetAt(r4)
            boolean r8 = r12.proto3
            if (r8 != 0) goto L33
            int[] r8 = r12.buffer
            int r9 = r4 + 2
            r8 = r8[r9]
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r9 = r9 & r8
            int r8 = r8 >>> 20
            int r5 = r5 << r8
            if (r9 == r2) goto L34
            sun.misc.Unsafe r2 = com.google.protobuf.MessageSchema.UNSAFE
            long r10 = (long) r9
            int r2 = r2.getInt(r13, r10)
            r3 = r2
            r2 = r9
            goto L34
        L33:
            r5 = r0
        L34:
            boolean r8 = isRequired(r7)
            if (r8 == 0) goto L41
            boolean r8 = r12.isFieldPresent(r13, r4, r3, r5)
            if (r8 != 0) goto L41
            return r0
        L41:
            int r8 = type(r7)
            r9 = 9
            if (r8 == r9) goto L81
            r9 = 17
            if (r8 == r9) goto L81
            r5 = 27
            if (r8 == r5) goto L7a
            r5 = 60
            if (r8 == r5) goto L69
            r5 = 68
            if (r8 == r5) goto L69
            r5 = 49
            if (r8 == r5) goto L7a
            r5 = 50
            if (r8 == r5) goto L62
            goto L92
        L62:
            boolean r4 = r12.isMapInitialized(r13, r7, r4)
            if (r4 != 0) goto L92
            return r0
        L69:
            boolean r5 = r12.isOneofPresent(r13, r6, r4)
            if (r5 == 0) goto L92
            com.google.protobuf.Schema r4 = r12.getMessageFieldSchema(r4)
            boolean r4 = isInitialized(r13, r7, r4)
            if (r4 != 0) goto L92
            return r0
        L7a:
            boolean r4 = r12.isListInitialized(r13, r7, r4)
            if (r4 != 0) goto L92
            return r0
        L81:
            boolean r5 = r12.isFieldPresent(r13, r4, r3, r5)
            if (r5 == 0) goto L92
            com.google.protobuf.Schema r4 = r12.getMessageFieldSchema(r4)
            boolean r4 = isInitialized(r13, r7, r4)
            if (r4 != 0) goto L92
            return r0
        L92:
            int r1 = r1 + 1
            goto L5
        L96:
            boolean r1 = r12.hasExtensions
            if (r1 == 0) goto La7
            com.google.protobuf.ExtensionSchema<?> r12 = r12.extensionSchema
            com.google.protobuf.FieldSet r12 = r12.getExtensions(r13)
            boolean r12 = r12.isInitialized()
            if (r12 != 0) goto La7
            return r0
        La7:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.MessageSchema.isInitialized(java.lang.Object):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isInitialized(Object obj, int OplusGLSurfaceView_13, Schema schema) {
        return schema.isInitialized(UnsafeUtil.getObject(obj, offset(OplusGLSurfaceView_13)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N> boolean isListInitialized(Object obj, int OplusGLSurfaceView_13, int i2) {
        List list = (List) UnsafeUtil.getObject(obj, offset(OplusGLSurfaceView_13));
        if (list.isEmpty()) {
            return true;
        }
        Schema messageFieldSchema = getMessageFieldSchema(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (!messageFieldSchema.isInitialized(list.get(i3))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [com.google.protobuf.Schema] */
    private boolean isMapInitialized(T t, int OplusGLSurfaceView_13, int i2) {
        Map<?, ?> mapForMapData = this.mapFieldSchema.forMapData(UnsafeUtil.getObject(t, offset(OplusGLSurfaceView_13)));
        if (mapForMapData.isEmpty()) {
            return true;
        }
        if (this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i2)).valueType.getJavaType() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        ?? SchemaFor = 0;
        for (Object obj : mapForMapData.values()) {
            SchemaFor = SchemaFor;
            if (SchemaFor == 0) {
                SchemaFor = Protobuf.getInstance().schemaFor((Class) obj.getClass());
            }
            if (!SchemaFor.isInitialized(obj)) {
                return false;
            }
        }
        return true;
    }

    private void writeString(int OplusGLSurfaceView_13, Object obj, Writer writer) throws IOException {
        if (obj instanceof String) {
            writer.writeString(OplusGLSurfaceView_13, (String) obj);
        } else {
            writer.writeBytes(OplusGLSurfaceView_13, (ByteString) obj);
        }
    }

    private void readString(Object obj, int OplusGLSurfaceView_13, Reader reader) throws IOException {
        if (isEnforceUtf8(OplusGLSurfaceView_13)) {
            UnsafeUtil.putObject(obj, offset(OplusGLSurfaceView_13), reader.readStringRequireUtf8());
        } else if (this.lite) {
            UnsafeUtil.putObject(obj, offset(OplusGLSurfaceView_13), reader.readString());
        } else {
            UnsafeUtil.putObject(obj, offset(OplusGLSurfaceView_13), reader.readBytes());
        }
    }

    private void readStringList(Object obj, int OplusGLSurfaceView_13, Reader reader) throws IOException {
        if (isEnforceUtf8(OplusGLSurfaceView_13)) {
            reader.readStringListRequireUtf8(this.listFieldSchema.mutableListAt(obj, offset(OplusGLSurfaceView_13)));
        } else {
            reader.readStringList(this.listFieldSchema.mutableListAt(obj, offset(OplusGLSurfaceView_13)));
        }
    }

    private <E> void readMessageList(Object obj, int OplusGLSurfaceView_13, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.readMessageList(this.listFieldSchema.mutableListAt(obj, offset(OplusGLSurfaceView_13)), schema, extensionRegistryLite);
    }

    private <E> void readGroupList(Object obj, long OplusGLSurfaceView_15, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.readGroupList(this.listFieldSchema.mutableListAt(obj, OplusGLSurfaceView_15), schema, extensionRegistryLite);
    }

    private int numberAt(int OplusGLSurfaceView_13) {
        return this.buffer[OplusGLSurfaceView_13];
    }

    private int typeAndOffsetAt(int OplusGLSurfaceView_13) {
        return this.buffer[OplusGLSurfaceView_13 + 1];
    }

    private int presenceMaskAndOffsetAt(int OplusGLSurfaceView_13) {
        return this.buffer[OplusGLSurfaceView_13 + 2];
    }

    private static <T> double doubleAt(T t, long OplusGLSurfaceView_15) {
        return UnsafeUtil.getDouble(t, OplusGLSurfaceView_15);
    }

    private static <T> float floatAt(T t, long OplusGLSurfaceView_15) {
        return UnsafeUtil.getFloat(t, OplusGLSurfaceView_15);
    }

    private static <T> int intAt(T t, long OplusGLSurfaceView_15) {
        return UnsafeUtil.getInt(t, OplusGLSurfaceView_15);
    }

    private static <T> long longAt(T t, long OplusGLSurfaceView_15) {
        return UnsafeUtil.getLong(t, OplusGLSurfaceView_15);
    }

    private static <T> boolean booleanAt(T t, long OplusGLSurfaceView_15) {
        return UnsafeUtil.getBoolean(t, OplusGLSurfaceView_15);
    }

    private static <T> double oneofDoubleAt(T t, long OplusGLSurfaceView_15) {
        return ((Double) UnsafeUtil.getObject(t, OplusGLSurfaceView_15)).doubleValue();
    }

    private static <T> float oneofFloatAt(T t, long OplusGLSurfaceView_15) {
        return ((Float) UnsafeUtil.getObject(t, OplusGLSurfaceView_15)).floatValue();
    }

    private static <T> int oneofIntAt(T t, long OplusGLSurfaceView_15) {
        return ((Integer) UnsafeUtil.getObject(t, OplusGLSurfaceView_15)).intValue();
    }

    private static <T> long oneofLongAt(T t, long OplusGLSurfaceView_15) {
        return ((Long) UnsafeUtil.getObject(t, OplusGLSurfaceView_15)).longValue();
    }

    private static <T> boolean oneofBooleanAt(T t, long OplusGLSurfaceView_15) {
        return ((Boolean) UnsafeUtil.getObject(t, OplusGLSurfaceView_15)).booleanValue();
    }

    private boolean arePresentForEquals(T t, T t2, int OplusGLSurfaceView_13) {
        return isFieldPresent(t, OplusGLSurfaceView_13) == isFieldPresent(t2, OplusGLSurfaceView_13);
    }

    private boolean isFieldPresent(T t, int OplusGLSurfaceView_13, int i2, int i3) {
        if (this.proto3) {
            return isFieldPresent(t, OplusGLSurfaceView_13);
        }
        return (i2 & i3) != 0;
    }

    private boolean isFieldPresent(T t, int OplusGLSurfaceView_13) {
        if (this.proto3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(OplusGLSurfaceView_13);
            long jOffset = offset(iTypeAndOffsetAt);
            switch (type(iTypeAndOffsetAt)) {
                case 0:
                    return UnsafeUtil.getDouble(t, jOffset) != 0.0d;
                case 1:
                    return UnsafeUtil.getFloat(t, jOffset) != 0.0f;
                case 2:
                    return UnsafeUtil.getLong(t, jOffset) != 0;
                case 3:
                    return UnsafeUtil.getLong(t, jOffset) != 0;
                case 4:
                    return UnsafeUtil.getInt(t, jOffset) != 0;
                case 5:
                    return UnsafeUtil.getLong(t, jOffset) != 0;
                case 6:
                    return UnsafeUtil.getInt(t, jOffset) != 0;
                case 7:
                    return UnsafeUtil.getBoolean(t, jOffset);
                case 8:
                    Object object = UnsafeUtil.getObject(t, jOffset);
                    if (object instanceof String) {
                        return !((String) object).isEmpty();
                    }
                    if (object instanceof ByteString) {
                        return !ByteString.EMPTY.equals(object);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return UnsafeUtil.getObject(t, jOffset) != null;
                case 10:
                    return !ByteString.EMPTY.equals(UnsafeUtil.getObject(t, jOffset));
                case 11:
                    return UnsafeUtil.getInt(t, jOffset) != 0;
                case 12:
                    return UnsafeUtil.getInt(t, jOffset) != 0;
                case 13:
                    return UnsafeUtil.getInt(t, jOffset) != 0;
                case 14:
                    return UnsafeUtil.getLong(t, jOffset) != 0;
                case 15:
                    return UnsafeUtil.getInt(t, jOffset) != 0;
                case 16:
                    return UnsafeUtil.getLong(t, jOffset) != 0;
                case 17:
                    return UnsafeUtil.getObject(t, jOffset) != null;
                default:
                    throw new IllegalArgumentException();
            }
        }
        int iPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(OplusGLSurfaceView_13);
        return (UnsafeUtil.getInt(t, (long) (iPresenceMaskAndOffsetAt & OFFSET_MASK)) & (1 << (iPresenceMaskAndOffsetAt >>> 20))) != 0;
    }

    private void setFieldPresent(T t, int OplusGLSurfaceView_13) {
        if (this.proto3) {
            return;
        }
        int iPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(OplusGLSurfaceView_13);
        long OplusGLSurfaceView_15 = iPresenceMaskAndOffsetAt & OFFSET_MASK;
        UnsafeUtil.putInt(t, OplusGLSurfaceView_15, UnsafeUtil.getInt(t, OplusGLSurfaceView_15) | (1 << (iPresenceMaskAndOffsetAt >>> 20)));
    }

    private boolean isOneofPresent(T t, int OplusGLSurfaceView_13, int i2) {
        return UnsafeUtil.getInt(t, (long) (presenceMaskAndOffsetAt(i2) & OFFSET_MASK)) == OplusGLSurfaceView_13;
    }

    private boolean isOneofCaseEqual(T t, T t2, int OplusGLSurfaceView_13) {
        long jPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(OplusGLSurfaceView_13) & OFFSET_MASK;
        return UnsafeUtil.getInt(t, jPresenceMaskAndOffsetAt) == UnsafeUtil.getInt(t2, jPresenceMaskAndOffsetAt);
    }

    private void setOneofPresent(T t, int OplusGLSurfaceView_13, int i2) {
        UnsafeUtil.putInt(t, presenceMaskAndOffsetAt(i2) & OFFSET_MASK, OplusGLSurfaceView_13);
    }

    private int positionForFieldNumber(int OplusGLSurfaceView_13) {
        if (OplusGLSurfaceView_13 < this.minFieldNumber || OplusGLSurfaceView_13 > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(OplusGLSurfaceView_13, 0);
    }

    private int positionForFieldNumber(int OplusGLSurfaceView_13, int i2) {
        if (OplusGLSurfaceView_13 < this.minFieldNumber || OplusGLSurfaceView_13 > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(OplusGLSurfaceView_13, i2);
    }

    private int slowPositionForFieldNumber(int OplusGLSurfaceView_13, int i2) {
        int length = (this.buffer.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int iNumberAt = numberAt(i4);
            if (OplusGLSurfaceView_13 == iNumberAt) {
                return i4;
            }
            if (OplusGLSurfaceView_13 < iNumberAt) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    int getSchemaSize() {
        return this.buffer.length * 3;
    }
}
