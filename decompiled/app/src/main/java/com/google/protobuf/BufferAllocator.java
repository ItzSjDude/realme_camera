package com.google.protobuf;

/* loaded from: classes.dex */
abstract class BufferAllocator {
    private static final com.google.protobuf.BufferAllocator UNPOOLED = new com.google.protobuf.BufferAllocator() { // from class: com.google.protobuf.BufferAllocator.1
        @Override // com.google.protobuf.BufferAllocator
        public com.google.protobuf.AllocatedBuffer allocateHeapBuffer(int i_renamed) {
            return com.google.protobuf.AllocatedBuffer.wrap(new byte[i_renamed]);
        }

        @Override // com.google.protobuf.BufferAllocator
        public com.google.protobuf.AllocatedBuffer allocateDirectBuffer(int i_renamed) {
            return com.google.protobuf.AllocatedBuffer.wrap(java.nio.ByteBuffer.allocateDirect(i_renamed));
        }
    };

    public abstract com.google.protobuf.AllocatedBuffer allocateDirectBuffer(int i_renamed);

    public abstract com.google.protobuf.AllocatedBuffer allocateHeapBuffer(int i_renamed);

    BufferAllocator() {
    }

    public static com.google.protobuf.BufferAllocator unpooled() {
        return UNPOOLED;
    }
}
