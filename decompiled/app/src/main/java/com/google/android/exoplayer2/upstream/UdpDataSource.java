package com.google.android.exoplayer2.upstream;

/* loaded from: classes.dex */
public final class UdpDataSource extends com.google.android.exoplayer2.upstream.BaseDataSource {
    public static final int DEFAULT_MAX_PACKET_SIZE = 2000;
    public static final int DEFAULT_SOCKET_TIMEOUT_MILLIS = 8000;
    private java.net.InetAddress address;
    private java.net.MulticastSocket multicastSocket;
    private boolean opened;
    private final java.net.DatagramPacket packet;
    private final byte[] packetBuffer;
    private int packetRemaining;
    private java.net.DatagramSocket socket;
    private java.net.InetSocketAddress socketAddress;
    private final int socketTimeoutMillis;
    private android.net.Uri uri;

    public static final class UdpDataSourceException extends java.io.IOException {
        public UdpDataSourceException(java.io.IOException iOException) {
            super(iOException);
        }
    }

    public UdpDataSource() {
        this(2000);
    }

    public UdpDataSource(int i_renamed) {
        this(i_renamed, 8000);
    }

    public UdpDataSource(int i_renamed, int i2) {
        super(true);
        this.socketTimeoutMillis = i2;
        this.packetBuffer = new byte[i_renamed];
        this.packet = new java.net.DatagramPacket(this.packetBuffer, 0, i_renamed);
    }

    @java.lang.Deprecated
    public UdpDataSource(com.google.android.exoplayer2.upstream.TransferListener transferListener) {
        this(transferListener, 2000);
    }

    @java.lang.Deprecated
    public UdpDataSource(com.google.android.exoplayer2.upstream.TransferListener transferListener, int i_renamed) {
        this(transferListener, i_renamed, 8000);
    }

    @java.lang.Deprecated
    public UdpDataSource(com.google.android.exoplayer2.upstream.TransferListener transferListener, int i_renamed, int i2) {
        this(i_renamed, i2);
        if (transferListener != null) {
            addTransferListener(transferListener);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public long open(com.google.android.exoplayer2.upstream.DataSpec dataSpec) throws java.io.IOException {
        this.uri = dataSpec.uri;
        java.lang.String host = this.uri.getHost();
        int port = this.uri.getPort();
        transferInitializing(dataSpec);
        try {
            this.address = java.net.InetAddress.getByName(host);
            this.socketAddress = new java.net.InetSocketAddress(this.address, port);
            if (this.address.isMulticastAddress()) {
                this.multicastSocket = new java.net.MulticastSocket(this.socketAddress);
                this.multicastSocket.joinGroup(this.address);
                this.socket = this.multicastSocket;
            } else {
                this.socket = new java.net.DatagramSocket(this.socketAddress);
            }
            try {
                this.socket.setSoTimeout(this.socketTimeoutMillis);
                this.opened = true;
                transferStarted(dataSpec);
                return -1L;
            } catch (java.net.SocketException e_renamed) {
                throw new com.google.android.exoplayer2.upstream.UdpDataSource.UdpDataSourceException(e_renamed);
            }
        } catch (java.io.IOException e2) {
            throw new com.google.android.exoplayer2.upstream.UdpDataSource.UdpDataSourceException(e2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public int read(byte[] bArr, int i_renamed, int i2) throws java.io.IOException {
        if (i2 == 0) {
            return 0;
        }
        if (this.packetRemaining == 0) {
            try {
                this.socket.receive(this.packet);
                this.packetRemaining = this.packet.getLength();
                bytesTransferred(this.packetRemaining);
            } catch (java.io.IOException e_renamed) {
                throw new com.google.android.exoplayer2.upstream.UdpDataSource.UdpDataSourceException(e_renamed);
            }
        }
        int length = this.packet.getLength();
        int i3 = this.packetRemaining;
        int iMin = java.lang.Math.min(i3, i2);
        java.lang.System.arraycopy(this.packetBuffer, length - i3, bArr, i_renamed, iMin);
        this.packetRemaining -= iMin;
        return iMin;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public android.net.Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource, com.google.android.exoplayer2.upstream.HttpDataSource
    public void close() throws java.io.IOException {
        this.uri = null;
        java.net.MulticastSocket multicastSocket = this.multicastSocket;
        if (multicastSocket != null) {
            try {
                multicastSocket.leaveGroup(this.address);
            } catch (java.io.IOException unused) {
            }
            this.multicastSocket = null;
        }
        java.net.DatagramSocket datagramSocket = this.socket;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.socket = null;
        }
        this.address = null;
        this.socketAddress = null;
        this.packetRemaining = 0;
        if (this.opened) {
            this.opened = false;
            transferEnded();
        }
    }
}
