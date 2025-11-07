package com.google.protobuf;

/* loaded from: classes.dex */
public class ExtensionRegistryLite {
    static final java.lang.String EXTENSION_CLASS_NAME = "com.google.protobuf.Extension";
    private static boolean doFullRuntimeInheritanceCheck = true;
    private static volatile boolean eagerlyParseMessageSets;
    private static volatile com.google.protobuf.ExtensionRegistryLite emptyRegistry;
    private final java.util.Map<com.google.protobuf.ExtensionRegistryLite.ObjectIntPair, com.google.protobuf.GeneratedMessageLite.GeneratedExtension<?, ?>> extensionsByNumber;
    private static final java.lang.Class<?> extensionClass = resolveExtensionClass();
    static final com.google.protobuf.ExtensionRegistryLite EMPTY_REGISTRY_LITE = new com.google.protobuf.ExtensionRegistryLite(true);

    static java.lang.Class<?> resolveExtensionClass() {
        try {
            return java.lang.Class.forName(EXTENSION_CLASS_NAME);
        } catch (java.lang.ClassNotFoundException unused) {
            return null;
        }
    }

    public static boolean isEagerlyParseMessageSets() {
        return eagerlyParseMessageSets;
    }

    public static void setEagerlyParseMessageSets(boolean z_renamed) {
        eagerlyParseMessageSets = z_renamed;
    }

    public static com.google.protobuf.ExtensionRegistryLite newInstance() {
        return doFullRuntimeInheritanceCheck ? com.google.protobuf.ExtensionRegistryFactory.create() : new com.google.protobuf.ExtensionRegistryLite();
    }

    public static com.google.protobuf.ExtensionRegistryLite getEmptyRegistry() {
        com.google.protobuf.ExtensionRegistryLite extensionRegistryLiteCreateEmpty = emptyRegistry;
        if (extensionRegistryLiteCreateEmpty == null) {
            synchronized (com.google.protobuf.ExtensionRegistryLite.class) {
                extensionRegistryLiteCreateEmpty = emptyRegistry;
                if (extensionRegistryLiteCreateEmpty == null) {
                    extensionRegistryLiteCreateEmpty = doFullRuntimeInheritanceCheck ? com.google.protobuf.ExtensionRegistryFactory.createEmpty() : EMPTY_REGISTRY_LITE;
                    emptyRegistry = extensionRegistryLiteCreateEmpty;
                }
            }
        }
        return extensionRegistryLiteCreateEmpty;
    }

    public com.google.protobuf.ExtensionRegistryLite getUnmodifiable() {
        return new com.google.protobuf.ExtensionRegistryLite(this);
    }

    public <ContainingType extends com.google.protobuf.MessageLite> com.google.protobuf.GeneratedMessageLite.GeneratedExtension<ContainingType, ?> findLiteExtensionByNumber(ContainingType containingtype, int i_renamed) {
        return (com.google.protobuf.GeneratedMessageLite.GeneratedExtension) this.extensionsByNumber.get(new com.google.protobuf.ExtensionRegistryLite.ObjectIntPair(containingtype, i_renamed));
    }

    public final void add(com.google.protobuf.GeneratedMessageLite.GeneratedExtension<?, ?> generatedExtension) {
        this.extensionsByNumber.put(new com.google.protobuf.ExtensionRegistryLite.ObjectIntPair(generatedExtension.getContainingTypeDefaultInstance(), generatedExtension.getNumber()), generatedExtension);
    }

    public final void add(com.google.protobuf.ExtensionLite<?, ?> extensionLite) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        if (com.google.protobuf.GeneratedMessageLite.GeneratedExtension.class.isAssignableFrom(extensionLite.getClass())) {
            add((com.google.protobuf.GeneratedMessageLite.GeneratedExtension<?, ?>) extensionLite);
        }
        if (doFullRuntimeInheritanceCheck && com.google.protobuf.ExtensionRegistryFactory.isFullRegistry(this)) {
            try {
                getClass().getMethod("add", extensionClass).invoke(this, extensionLite);
            } catch (java.lang.Exception e_renamed) {
                throw new java.lang.IllegalArgumentException(java.lang.String.format("Could not invoke ExtensionRegistry#add for %s_renamed", extensionLite), e_renamed);
            }
        }
    }

    ExtensionRegistryLite() {
        this.extensionsByNumber = new java.util.HashMap();
    }

    ExtensionRegistryLite(com.google.protobuf.ExtensionRegistryLite extensionRegistryLite) {
        if (extensionRegistryLite == EMPTY_REGISTRY_LITE) {
            this.extensionsByNumber = java.util.Collections.emptyMap();
        } else {
            this.extensionsByNumber = java.util.Collections.unmodifiableMap(extensionRegistryLite.extensionsByNumber);
        }
    }

    ExtensionRegistryLite(boolean z_renamed) {
        this.extensionsByNumber = java.util.Collections.emptyMap();
    }

    private static final class ObjectIntPair {
        private final int number;
        private final java.lang.Object object;

        ObjectIntPair(java.lang.Object obj, int i_renamed) {
            this.object = obj;
            this.number = i_renamed;
        }

        public int hashCode() {
            return (java.lang.System.identityHashCode(this.object) * com.meicam.sdk.NvsMediaFileConvertor.CONVERTOR_ERROR_UNKNOWN) + this.number;
        }

        public boolean equals(java.lang.Object obj) {
            if (!(obj instanceof com.google.protobuf.ExtensionRegistryLite.ObjectIntPair)) {
                return false;
            }
            com.google.protobuf.ExtensionRegistryLite.ObjectIntPair objectIntPair = (com.google.protobuf.ExtensionRegistryLite.ObjectIntPair) obj;
            return this.object == objectIntPair.object && this.number == objectIntPair.number;
        }
    }
}
