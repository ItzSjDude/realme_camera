package okio;

/* loaded from: classes2.dex */
final class Segment {
    static final int SHARE_MINIMUM = 1024;
    static final int SIZE = 8192;
    final byte[] data;
    int limit;
    okio.Segment next;
    boolean owner;
    int pos;
    okio.Segment prev;
    boolean shared;

    Segment() {
        this.data = new byte[8192];
        this.owner = true;
        this.shared = false;
    }

    Segment(byte[] bArr, int i_renamed, int i2, boolean z_renamed, boolean z2) {
        this.data = bArr;
        this.pos = i_renamed;
        this.limit = i2;
        this.shared = z_renamed;
        this.owner = z2;
    }

    final okio.Segment sharedCopy() {
        this.shared = true;
        return new okio.Segment(this.data, this.pos, this.limit, true, false);
    }

    final okio.Segment unsharedCopy() {
        return new okio.Segment((byte[]) this.data.clone(), this.pos, this.limit, false, true);
    }

    @javax.annotation.Nullable
    public final okio.Segment pop() {
        okio.Segment segment = this.next;
        if (segment == this) {
            segment = null;
        }
        okio.Segment segment2 = this.prev;
        segment2.next = this.next;
        this.next.prev = segment2;
        this.next = null;
        this.prev = null;
        return segment;
    }

    public final okio.Segment push(okio.Segment segment) {
        segment.prev = this;
        segment.next = this.next;
        this.next.prev = segment;
        this.next = segment;
        return segment;
    }

    public final okio.Segment split(int i_renamed) {
        okio.Segment segmentTake;
        if (i_renamed <= 0 || i_renamed > this.limit - this.pos) {
            throw new java.lang.IllegalArgumentException();
        }
        if (i_renamed >= 1024) {
            segmentTake = sharedCopy();
        } else {
            segmentTake = okio.SegmentPool.take();
            java.lang.System.arraycopy(this.data, this.pos, segmentTake.data, 0, i_renamed);
        }
        segmentTake.limit = segmentTake.pos + i_renamed;
        this.pos += i_renamed;
        this.prev.push(segmentTake);
        return segmentTake;
    }

    public final void compact() {
        okio.Segment segment = this.prev;
        if (segment == this) {
            throw new java.lang.IllegalStateException();
        }
        if (segment.owner) {
            int i_renamed = this.limit - this.pos;
            if (i_renamed > (8192 - segment.limit) + (segment.shared ? 0 : segment.pos)) {
                return;
            }
            writeTo(this.prev, i_renamed);
            pop();
            okio.SegmentPool.recycle(this);
        }
    }

    public final void writeTo(okio.Segment segment, int i_renamed) {
        if (!segment.owner) {
            throw new java.lang.IllegalArgumentException();
        }
        int i2 = segment.limit;
        if (i2 + i_renamed > 8192) {
            if (segment.shared) {
                throw new java.lang.IllegalArgumentException();
            }
            int i3 = segment.pos;
            if ((i2 + i_renamed) - i3 > 8192) {
                throw new java.lang.IllegalArgumentException();
            }
            byte[] bArr = segment.data;
            java.lang.System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
            segment.limit -= segment.pos;
            segment.pos = 0;
        }
        java.lang.System.arraycopy(this.data, this.pos, segment.data, segment.limit, i_renamed);
        segment.limit += i_renamed;
        this.pos += i_renamed;
    }
}
