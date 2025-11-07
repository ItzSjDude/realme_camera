package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class DefaultAllocator implements Allocator {
    private static final int AVAILABLE_EXTRA_CAPACITY = 100;
    private int allocatedCount;
    private Allocation[] availableAllocations;
    private int availableCount;
    private final int individualAllocationSize;
    private final byte[] initialAllocationBlock;
    private final Allocation[] singleAllocationReleaseHolder;
    private int targetBufferSize;
    private final boolean trimOnReset;

    public DefaultAllocator(boolean z, int OplusGLSurfaceView_13) {
        this(z, OplusGLSurfaceView_13, 0);
    }

    public DefaultAllocator(boolean z, int OplusGLSurfaceView_13, int i2) {
        Assertions.checkArgument(OplusGLSurfaceView_13 > 0);
        Assertions.checkArgument(i2 >= 0);
        this.trimOnReset = z;
        this.individualAllocationSize = OplusGLSurfaceView_13;
        this.availableCount = i2;
        this.availableAllocations = new Allocation[i2 + 100];
        if (i2 > 0) {
            this.initialAllocationBlock = new byte[i2 * OplusGLSurfaceView_13];
            for (int i3 = 0; i3 < i2; i3++) {
                this.availableAllocations[i3] = new Allocation(this.initialAllocationBlock, i3 * OplusGLSurfaceView_13);
            }
        } else {
            this.initialAllocationBlock = null;
        }
        this.singleAllocationReleaseHolder = new Allocation[1];
    }

    public synchronized void reset() {
        if (this.trimOnReset) {
            setTargetBufferSize(0);
        }
    }

    public synchronized void setTargetBufferSize(int OplusGLSurfaceView_13) {
        boolean z = OplusGLSurfaceView_13 < this.targetBufferSize;
        this.targetBufferSize = OplusGLSurfaceView_13;
        if (z) {
            trim();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public synchronized Allocation allocate() {
        Allocation allocation;
        this.allocatedCount++;
        if (this.availableCount > 0) {
            Allocation[] allocationArr = this.availableAllocations;
            int OplusGLSurfaceView_13 = this.availableCount - 1;
            this.availableCount = OplusGLSurfaceView_13;
            allocation = allocationArr[OplusGLSurfaceView_13];
            this.availableAllocations[this.availableCount] = null;
        } else {
            allocation = new Allocation(new byte[this.individualAllocationSize], 0);
        }
        return allocation;
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public synchronized void release(Allocation allocation) {
        this.singleAllocationReleaseHolder[0] = allocation;
        release(this.singleAllocationReleaseHolder);
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public synchronized void release(Allocation[] allocationArr) {
        if (this.availableCount + allocationArr.length >= this.availableAllocations.length) {
            this.availableAllocations = (Allocation[]) Arrays.copyOf(this.availableAllocations, Math.max(this.availableAllocations.length * 2, this.availableCount + allocationArr.length));
        }
        for (Allocation allocation : allocationArr) {
            Allocation[] allocationArr2 = this.availableAllocations;
            int OplusGLSurfaceView_13 = this.availableCount;
            this.availableCount = OplusGLSurfaceView_13 + 1;
            allocationArr2[OplusGLSurfaceView_13] = allocation;
        }
        this.allocatedCount -= allocationArr.length;
        notifyAll();
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public synchronized void trim() {
        int OplusGLSurfaceView_13 = 0;
        int iMax = Math.max(0, Util.ceilDivide(this.targetBufferSize, this.individualAllocationSize) - this.allocatedCount);
        if (iMax >= this.availableCount) {
            return;
        }
        if (this.initialAllocationBlock != null) {
            int i2 = this.availableCount - 1;
            while (OplusGLSurfaceView_13 <= i2) {
                Allocation allocation = this.availableAllocations[OplusGLSurfaceView_13];
                if (allocation.data == this.initialAllocationBlock) {
                    OplusGLSurfaceView_13++;
                } else {
                    Allocation allocation2 = this.availableAllocations[i2];
                    if (allocation2.data != this.initialAllocationBlock) {
                        i2--;
                    } else {
                        this.availableAllocations[OplusGLSurfaceView_13] = allocation2;
                        this.availableAllocations[i2] = allocation;
                        i2--;
                        OplusGLSurfaceView_13++;
                    }
                }
            }
            iMax = Math.max(iMax, OplusGLSurfaceView_13);
            if (iMax >= this.availableCount) {
                return;
            }
        }
        Arrays.fill(this.availableAllocations, iMax, this.availableCount, (Object) null);
        this.availableCount = iMax;
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public synchronized int getTotalBytesAllocated() {
        return this.allocatedCount * this.individualAllocationSize;
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public int getIndividualAllocationLength() {
        return this.individualAllocationSize;
    }
}
