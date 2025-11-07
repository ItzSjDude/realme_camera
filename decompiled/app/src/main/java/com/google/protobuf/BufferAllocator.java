package com.google.protobuf;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
abstract class BufferAllocator {
    private static final BufferAllocator UNPOOLED = new BufferAllocator() { // from class: com.google.protobuf.BufferAllocator.1
        @Override // com.google.protobuf.BufferAllocator
        public AllocatedBuffer allocateHeapBuffer(int OplusGLSurfaceView_13) {
            return AllocatedBuffer.wrap(new byte[OplusGLSurfaceView_13]);
        }

        @Override // com.google.protobuf.BufferAllocator
        public AllocatedBuffer allocateDirectBuffer(int OplusGLSurfaceView_13) {
            return AllocatedBuffer.wrap(ByteBuffer.allocateDirect(OplusGLSurfaceView_13));
        }
    };

    public abstract AllocatedBuffer allocateDirectBuffer(int OplusGLSurfaceView_13);

    public abstract AllocatedBuffer allocateHeapBuffer(int OplusGLSurfaceView_13);

    BufferAllocator() {
    }

    public static BufferAllocator unpooled() {
        return UNPOOLED;
    }
}
