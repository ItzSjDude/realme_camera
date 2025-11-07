package com.google.protobuf;

/* loaded from: classes.dex */
final class ExtensionRegistryFactory {
    static final java.lang.Class<?> EXTENSION_REGISTRY_CLASS = reflectExtensionRegistry();
    static final java.lang.String FULL_REGISTRY_CLASS_NAME = "com.google.protobuf.ExtensionRegistry";

    ExtensionRegistryFactory() {
    }

    static java.lang.Class<?> reflectExtensionRegistry() {
        try {
            return java.lang.Class.forName(FULL_REGISTRY_CLASS_NAME);
        } catch (java.lang.ClassNotFoundException unused) {
            return null;
        }
    }

    public static com.google.protobuf.ExtensionRegistryLite create() {
        if (EXTENSION_REGISTRY_CLASS != null) {
            try {
                return invokeSubclassFactory("newInstance");
            } catch (java.lang.Exception unused) {
            }
        }
        return new com.google.protobuf.ExtensionRegistryLite();
    }

    public static com.google.protobuf.ExtensionRegistryLite createEmpty() {
        if (EXTENSION_REGISTRY_CLASS != null) {
            try {
                return invokeSubclassFactory("getEmptyRegistry");
            } catch (java.lang.Exception unused) {
            }
        }
        return com.google.protobuf.ExtensionRegistryLite.EMPTY_REGISTRY_LITE;
    }

    static boolean isFullRegistry(com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) {
        java.lang.Class<?> cls = EXTENSION_REGISTRY_CLASS;
        return cls != null && cls.isAssignableFrom(extensionRegistryLite.getClass());
    }

    private static final com.google.protobuf.ExtensionRegistryLite invokeSubclassFactory(java.lang.String str) throws java.lang.Exception {
        return (com.google.protobuf.ExtensionRegistryLite) EXTENSION_REGISTRY_CLASS.getDeclaredMethod(str, new java.lang.Class[0]).invoke(null, new java.lang.Object[0]);
    }
}
