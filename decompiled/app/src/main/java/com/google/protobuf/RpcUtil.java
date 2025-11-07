package com.google.protobuf;

/* loaded from: classes.dex */
public final class RpcUtil {
    /* JADX WARN: Multi-variable type inference failed */
    public static <Type extends com.google.protobuf.Message> com.google.protobuf.RpcCallback<Type> specializeCallback(com.google.protobuf.RpcCallback<com.google.protobuf.Message> rpcCallback) {
        return rpcCallback;
    }

    private RpcUtil() {
    }

    public static <Type extends com.google.protobuf.Message> com.google.protobuf.RpcCallback<com.google.protobuf.Message> generalizeCallback(final com.google.protobuf.RpcCallback<Type> rpcCallback, final java.lang.Class<Type> cls, final Type type) {
        return new com.google.protobuf.RpcCallback<com.google.protobuf.Message>() { // from class: com.google.protobuf.RpcUtil.1
            @Override // com.google.protobuf.RpcCallback
            public void run(com.google.protobuf.Message message) {
                com.google.protobuf.Message messageCopyAsType;
                try {
                    messageCopyAsType = (com.google.protobuf.Message) cls.cast(message);
                } catch (java.lang.ClassCastException unused) {
                    messageCopyAsType = com.google.protobuf.RpcUtil.copyAsType(type, message);
                }
                rpcCallback.run(messageCopyAsType);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <Type extends com.google.protobuf.Message> Type copyAsType(Type type, com.google.protobuf.Message message) {
        return (Type) type.newBuilderForType().mergeFrom(message).build();
    }

    public static <ParameterType> com.google.protobuf.RpcCallback<ParameterType> newOneTimeCallback(final com.google.protobuf.RpcCallback<ParameterType> rpcCallback) {
        return new com.google.protobuf.RpcCallback<ParameterType>() { // from class: com.google.protobuf.RpcUtil.2
            private boolean alreadyCalled = false;

            @Override // com.google.protobuf.RpcCallback
            public void run(ParameterType parametertype) {
                synchronized (this) {
                    if (this.alreadyCalled) {
                        throw new com.google.protobuf.RpcUtil.AlreadyCalledException();
                    }
                    this.alreadyCalled = true;
                }
                rpcCallback.run(parametertype);
            }
        };
    }

    public static final class AlreadyCalledException extends java.lang.RuntimeException {
        private static final long serialVersionUID = 5469741279507848266L;

        public AlreadyCalledException() {
            super("This RpcCallback was already called and cannot be_renamed called multiple times.");
        }
    }
}
