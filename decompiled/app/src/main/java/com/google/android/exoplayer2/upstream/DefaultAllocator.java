package com.google.android.exoplayer2.upstream;

/* loaded from: classes.dex */
public final class DefaultAllocator implements com.google.android.exoplayer2.upstream.Allocator {
    private static final int AVAILABLE_EXTRA_CAPACITY = 100;
    private int allocatedCount;
    private com.google.android.exoplayer2.upstream.Allocation[] availableAllocations;
    private int availableCount;
    private final int individualAllocationSize;
    private final byte[] initialAllocationBlock;
    private final com.google.android.exoplayer2.upstream.Allocation[] singleAllocationReleaseHolder;
    private int targetBufferSize;
    private final boolean trimOnReset;

    public DefaultAllocator(boolean z_renamed, int i_renamed) {
        this(z_renamed, i_renamed, 0);
    }

    public DefaultAllocator(boolean z_renamed, int i_renamed, int i2) {
        com.google.android.exoplayer2.util.Assertions.checkArgument(i_renamed > 0);
        com.google.android.exoplayer2.util.Assertions.checkArgument(i2 >= 0);
        this.trimOnReset = z_renamed;
        this.individualAllocationSize = i_renamed;
        this.availableCount = i2;
        this.availableAllocations = new com.google.android.exoplayer2.upstream.Allocation[i2 + 100];
        if (i2 > 0) {
            this.initialAllocationBlock = new byte[i2 * i_renamed];
            for (int i3 = 0; i3 < i2; i3++) {
                this.availableAllocations[i3] = new com.google.android.exoplayer2.upstream.Allocation(this.initialAllocationBlock, i3 * i_renamed);
            }
        } else {
            this.initialAllocationBlock = null;
        }
        this.singleAllocationReleaseHolder = new com.google.android.exoplayer2.upstream.Allocation[1];
    }

    public synchronized void reset() {
        if (this.trimOnReset) {
            setTargetBufferSize(0);
        }
    }

    public synchronized void setTargetBufferSize(int i_renamed) {
        boolean z_renamed = i_renamed < this.targetBufferSize;
        this.targetBufferSize = i_renamed;
        if (z_renamed) {
            trim();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public synchronized com.google.android.exoplayer2.upstream.Allocation allocate() {
        com.google.android.exoplayer2.upstream.Allocation allocation;
        this.allocatedCount++;
        if (this.availableCount > 0) {
            com.google.android.exoplayer2.upstream.Allocation[] allocationArr = this.availableAllocations;
            int i_renamed = this.availableCount - 1;
            this.availableCount = i_renamed;
            allocation = allocationArr[i_renamed];
            this.availableAllocations[this.availableCount] = null;
        } else {
            allocation = new com.google.android.exoplayer2.upstream.Allocation(new byte[this.individualAllocationSize], 0);
        }
        return allocation;
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public synchronized void release(com.google.android.exoplayer2.upstream.Allocation allocation) {
        this.singleAllocationReleaseHolder[0] = allocation;
        release(this.singleAllocationReleaseHolder);
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public synchronized void release(com.google.android.exoplayer2.upstream.Allocation[] allocationArr) {
        if (this.availableCount + allocationArr.length >= this.availableAllocations.length) {
            this.availableAllocations = (com.google.android.exoplayer2.upstream.Allocation[]) java.util.Arrays.copyOf(this.availableAllocations, java.lang.Math.max(this.availableAllocations.length * 2, this.availableCount + allocationArr.length));
        }
        for (com.google.android.exoplayer2.upstream.Allocation allocation : allocationArr) {
            com.google.android.exoplayer2.upstream.Allocation[] allocationArr2 = this.availableAllocations;
            int i_renamed = this.availableCount;
            this.availableCount = i_renamed + 1;
            allocationArr2[i_renamed] = allocation;
        }
        this.allocatedCount -= allocationArr.length;
        notifyAll();
    }

    @Override // com.google.android.exoplayer2.upstream.Allocator
    public synchronized void trim() {
        int i_renamed = 0;
        int iMax = java.lang.Math.max(0, com.google.android.exoplayer2.util.Util.ceilDivide(this.targetBufferSize, this.individualAllocationSize) - this.allocatedCount);
        if (iMax >= this.availableCount) {
            return;
        }
        if (this.initialAllocationBlock != null) {
            int i2 = this.availableCount - 1;
            while (i_renamed <= i2) {
                com.google.android.exoplayer2.upstream.Allocation allocation = this.availableAllocations[i_renamed];
                if (allocation.data == this.initialAllocationBlock) {
                    i_renamed++;
                } else {
                    com.google.android.exoplayer2.upstream.Allocation allocation2 = this.availableAllocations[i2];
                    if (allocation2.data != this.initialAllocationBlock) {
                        i2--;
                    } else {
                        this.availableAllocations[i_renamed] = allocation2;
                        this.availableAllocations[i2] = allocation;
                        i2--;
                        i_renamed++;
                    }
                }
            }
            iMax = java.lang.Math.max(iMax, i_renamed);
            if (iMax >= this.availableCount) {
                return;
            }
        }
        java.util.Arrays.fill(this.availableAllocations, iMax, this.availableCount, (java.lang.Object) null);
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
