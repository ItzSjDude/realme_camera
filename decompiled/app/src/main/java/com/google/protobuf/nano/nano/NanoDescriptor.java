package com.google.protobuf.nano.nano;

/* loaded from: classes.dex */
public abstract class NanoDescriptor {
    public static final com.google.protobuf.nano.Extension<com.google.protobuf.nano.DescriptorProtos.MessageOptions, java.lang.Boolean> legacyOneof = com.google.protobuf.nano.Extension.createPrimitiveTyped(8, java.lang.Boolean.class, 1180950304);
    public static final com.google.protobuf.nano.Extension<com.google.protobuf.nano.DescriptorProtos.MessageOptions, java.lang.Boolean> messageAsLite = com.google.protobuf.nano.Extension.createPrimitiveTyped(8, java.lang.Boolean.class, 1195348696);
    public static final com.google.protobuf.nano.Extension<com.google.protobuf.nano.DescriptorProtos.MessageOptions, java.lang.String> messageUnmungedFileDescriptorName = com.google.protobuf.nano.Extension.createPrimitiveTyped(9, java.lang.String.class, 1522304402);
    public static final com.google.protobuf.nano.Extension<com.google.protobuf.nano.DescriptorProtos.EnumOptions, java.lang.Boolean> enumAsLite = com.google.protobuf.nano.Extension.createPrimitiveTyped(8, java.lang.Boolean.class, 1195355736);
    public static final com.google.protobuf.nano.Extension<com.google.protobuf.nano.DescriptorProtos.EnumOptions, java.lang.Boolean> legacyEnum = com.google.protobuf.nano.Extension.createPrimitiveTyped(8, java.lang.Boolean.class, 1308211224);
    public static final com.google.protobuf.nano.Extension<com.google.protobuf.nano.DescriptorProtos.EnumOptions, java.lang.String> enumUnmungedFileDescriptorName = com.google.protobuf.nano.Extension.createPrimitiveTyped(9, java.lang.String.class, 1522362506);
    public static final com.google.protobuf.nano.Extension<com.google.protobuf.nano.DescriptorProtos.FieldOptions, java.lang.Integer> generateAs = com.google.protobuf.nano.Extension.createPrimitiveTyped(14, java.lang.Integer.class, 1437615632);
    public static final com.google.protobuf.nano.Extension<com.google.protobuf.nano.DescriptorProtos.EnumValueOptions, java.lang.Boolean> watermarkCompliant = com.google.protobuf.nano.Extension.createPrimitiveTyped(8, java.lang.Boolean.class, 1301621224);
    public static final com.google.protobuf.nano.Extension<com.google.protobuf.nano.DescriptorProtos.EnumValueOptions, java.lang.Boolean> emeritus = com.google.protobuf.nano.Extension.createPrimitiveTyped(8, java.lang.Boolean.class, 1307892264);
    public static final com.google.protobuf.nano.Extension<com.google.protobuf.nano.DescriptorProtos.EnumValueOptions, java.lang.Boolean> unmungedDepsCompliant = com.google.protobuf.nano.Extension.createPrimitiveTyped(8, java.lang.Boolean.class, 1362093848);
    public static final com.google.protobuf.nano.Extension<com.google.protobuf.nano.DescriptorProtos.EnumValueOptions, java.lang.String[]> whitelisted = com.google.protobuf.nano.Extension.createRepeatedPrimitiveTyped(9, java.lang.String[].class, 1432768322, 1432768322, 0);
    public static final com.google.protobuf.nano.Extension<com.google.protobuf.nano.DescriptorProtos.FileOptions, java.lang.Integer> munger = com.google.protobuf.nano.Extension.createPrimitiveTyped(14, java.lang.Integer.class, 1243722024);
    public static final com.google.protobuf.nano.Extension<com.google.protobuf.nano.DescriptorProtos.FileOptions, byte[]> encodedMungee = com.google.protobuf.nano.Extension.createPrimitiveTyped(12, byte[].class, 1257962002);
    public static final com.google.protobuf.nano.Extension<com.google.protobuf.nano.DescriptorProtos.FileOptions, java.lang.Boolean> fileAsLite = com.google.protobuf.nano.Extension.createPrimitiveTyped(8, java.lang.Boolean.class, 1445185760);

    public interface GenerateAs {

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.nano.NanoDescriptor.GenerateAs.class)
        public static final int INVALID = 0;

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.nano.NanoDescriptor.GenerateAs.class)
        public static final int LITE = 2;

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.nano.NanoDescriptor.GenerateAs.class)
        public static final int NANO = 1;

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.nano.NanoDescriptor.GenerateAs.class)
        public static final int OMIT = 3;
    }

    public interface Munger {

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.nano.NanoDescriptor.Munger.class)
        public static final int ADS_EXPRESS_MOBILEAPP = 10;

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.nano.NanoDescriptor.Munger.class)
        public static final int AGSA_PROTO = 2;

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.nano.NanoDescriptor.Munger.class)
        public static final int ANDROID_UTIL_CONVERT_TO_NANO_PROTOS = 7;

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.nano.NanoDescriptor.Munger.class)
        public static final int CLOCKWORK_PROTO = 15;

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.nano.NanoDescriptor.Munger.class)
        public static final int COMMERCE_PAYMENTS_INSTORE_TOOLS_CONVERT_TO_NANO_PROTOS = 6;

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.nano.NanoDescriptor.Munger.class)
        public static final int DOTS = 18;

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.nano.NanoDescriptor.Munger.class)
        public static final int FIXED_CORRECT_PROTO_PLAY_COMMON = 14;

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.nano.NanoDescriptor.Munger.class)
        public static final int FIXED_CORRECT_PROTO_PLAY_ENTERTAINMENT = 3;

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.nano.NanoDescriptor.Munger.class)
        public static final int FIXED_CORRECT_PROTO_PLAY_STORE = 4;

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.nano.NanoDescriptor.Munger.class)
        public static final int GOGGLES_PROTO = 16;

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.nano.NanoDescriptor.Munger.class)
        public static final int HANGOUTS = 12;

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.nano.NanoDescriptor.Munger.class)
        public static final int INNERTUBE = 11;

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.nano.NanoDescriptor.Munger.class)
        public static final int KIDS_MANAGEMENT = 9;

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.nano.NanoDescriptor.Munger.class)
        public static final int NONE = 0;

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.nano.NanoDescriptor.Munger.class)
        public static final int REDUCED_NANO_PROTO = 1;

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.nano.NanoDescriptor.Munger.class)
        public static final int S3_SPEECH_PROTO = 17;

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.nano.NanoDescriptor.Munger.class)
        public static final int SIMUX = 8;

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.nano.NanoDescriptor.Munger.class)
        public static final int TESTING_NOT_WATERMARK_COMPLIANT = 100;

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.nano.NanoDescriptor.Munger.class)
        public static final int TESTING_WATERMARK_COMPLIANT = 101;

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.nano.NanoDescriptor.Munger.class)
        public static final int TVSEARCH = 13;

        @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.nano.NanoDescriptor.Munger.class)
        public static final int WASP = 5;
    }

    private NanoDescriptor() {
    }

    @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.nano.NanoDescriptor.GenerateAs.class)
    public static int checkGenerateAsOrThrow(int i_renamed) {
        if (i_renamed >= 0 && i_renamed <= 3) {
            return i_renamed;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(42);
        sb.append(i_renamed);
        sb.append(" is_renamed not a_renamed valid enum GenerateAs");
        throw new java.lang.IllegalArgumentException(sb.toString());
    }

    @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.nano.NanoDescriptor.GenerateAs.class)
    public static int[] checkGenerateAsOrThrow(int[] iArr) {
        int[] iArr2 = (int[]) iArr.clone();
        for (int i_renamed : iArr2) {
            checkGenerateAsOrThrow(i_renamed);
        }
        return iArr2;
    }

    @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.nano.NanoDescriptor.Munger.class)
    public static int checkMungerOrThrow(int i_renamed) {
        if (i_renamed >= 0 && i_renamed <= 18) {
            return i_renamed;
        }
        if (i_renamed >= 100 && i_renamed <= 101) {
            return i_renamed;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(38);
        sb.append(i_renamed);
        sb.append(" is_renamed not a_renamed valid enum Munger");
        throw new java.lang.IllegalArgumentException(sb.toString());
    }

    @com.google.protobuf.nano.NanoEnumValue(legacy = false, value = com.google.protobuf.nano.nano.NanoDescriptor.Munger.class)
    public static int[] checkMungerOrThrow(int[] iArr) {
        int[] iArr2 = (int[]) iArr.clone();
        for (int i_renamed : iArr2) {
            checkMungerOrThrow(i_renamed);
        }
        return iArr2;
    }
}
