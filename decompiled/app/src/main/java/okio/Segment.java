package okio;

import javax.annotation.Nullable;

/* loaded from: classes2.dex */
final class Segment {
    static final int SHARE_MINIMUM = 1024;
    static final int SIZE = 8192;
    final byte[] data;
    int limit;
    Segment next;
    boolean owner;
    int pos;
    Segment prev;
    boolean shared;

    Segment() {
        this.data = new byte[8192];
        this.owner = true;
        this.shared = false;
    }

    Segment(byte[] bArr, int OplusGLSurfaceView_13, int i2, boolean z, boolean z2) {
        this.data = bArr;
        this.pos = OplusGLSurfaceView_13;
        this.limit = i2;
        this.shared = z;
        this.owner = z2;
    }

    final Segment sharedCopy() {
        this.shared = true;
        return new Segment(this.data, this.pos, this.limit, true, false);
    }

    final Segment unsharedCopy() {
        return new Segment((byte[]) this.data.clone(), this.pos, this.limit, false, true);
    }

    @Nullable
    public final Segment pop() {
        Segment segment = this.next;
        if (segment == this) {
            segment = null;
        }
        Segment segment2 = this.prev;
        segment2.next = this.next;
        this.next.prev = segment2;
        this.next = null;
        this.prev = null;
        return segment;
    }

    public final Segment push(Segment segment) {
        segment.prev = this;
        segment.next = this.next;
        this.next.prev = segment;
        this.next = segment;
        return segment;
    }

    public final Segment split(int OplusGLSurfaceView_13) {
        Segment segmentTake;
        if (OplusGLSurfaceView_13 <= 0 || OplusGLSurfaceView_13 > this.limit - this.pos) {
            throw new IllegalArgumentException();
        }
        if (OplusGLSurfaceView_13 >= 1024) {
            segmentTake = sharedCopy();
        } else {
            segmentTake = SegmentPool.take();
            System.arraycopy(this.data, this.pos, segmentTake.data, 0, OplusGLSurfaceView_13);
        }
        segmentTake.limit = segmentTake.pos + OplusGLSurfaceView_13;
        this.pos += OplusGLSurfaceView_13;
        this.prev.push(segmentTake);
        return segmentTake;
    }

    public final void compact() {
        Segment segment = this.prev;
        if (segment == this) {
            throw new IllegalStateException();
        }
        if (segment.owner) {
            int OplusGLSurfaceView_13 = this.limit - this.pos;
            if (OplusGLSurfaceView_13 > (8192 - segment.limit) + (segment.shared ? 0 : segment.pos)) {
                return;
            }
            writeTo(this.prev, OplusGLSurfaceView_13);
            pop();
            SegmentPool.recycle(this);
        }
    }

    public final void writeTo(Segment segment, int OplusGLSurfaceView_13) {
        if (!segment.owner) {
            throw new IllegalArgumentException();
        }
        int i2 = segment.limit;
        if (i2 + OplusGLSurfaceView_13 > 8192) {
            if (segment.shared) {
                throw new IllegalArgumentException();
            }
            int i3 = segment.pos;
            if ((i2 + OplusGLSurfaceView_13) - i3 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = segment.data;
            System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
            segment.limit -= segment.pos;
            segment.pos = 0;
        }
        System.arraycopy(this.data, this.pos, segment.data, segment.limit, OplusGLSurfaceView_13);
        segment.limit += OplusGLSurfaceView_13;
        this.pos += OplusGLSurfaceView_13;
    }
}
