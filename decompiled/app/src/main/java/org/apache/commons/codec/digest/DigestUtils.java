package org.apache.commons.codec.digest;

/* loaded from: classes2.dex */
public class DigestUtils {
    private static final int STREAM_BUFFER_LENGTH = 1024;

    private static byte[] digest(java.security.MessageDigest messageDigest, java.io.InputStream inputStream) throws java.io.IOException {
        byte[] bArr = new byte[1024];
        int i_renamed = inputStream.read(bArr, 0, 1024);
        while (i_renamed > -1) {
            messageDigest.update(bArr, 0, i_renamed);
            i_renamed = inputStream.read(bArr, 0, 1024);
        }
        return messageDigest.digest();
    }

    private static byte[] getBytesUtf8(java.lang.String str) {
        return org.apache.commons.codec.binary.StringUtils.getBytesUtf8(str);
    }

    static java.security.MessageDigest getDigest(java.lang.String str) {
        try {
            return java.security.MessageDigest.getInstance(str);
        } catch (java.security.NoSuchAlgorithmException e_renamed) {
            throw new java.lang.RuntimeException(e_renamed.getMessage());
        }
    }

    private static java.security.MessageDigest getMd5Digest() {
        return getDigest("MD5");
    }

    private static java.security.MessageDigest getSha256Digest() {
        return getDigest("SHA-256");
    }

    private static java.security.MessageDigest getSha384Digest() {
        return getDigest("SHA-384");
    }

    private static java.security.MessageDigest getSha512Digest() {
        return getDigest("SHA-512");
    }

    private static java.security.MessageDigest getShaDigest() {
        return getDigest("SHA");
    }

    public static byte[] md5(byte[] bArr) {
        return getMd5Digest().digest(bArr);
    }

    public static byte[] md5(java.io.InputStream inputStream) throws java.io.IOException {
        return digest(getMd5Digest(), inputStream);
    }

    public static byte[] md5(java.lang.String str) {
        return md5(getBytesUtf8(str));
    }

    public static java.lang.String md5Hex(byte[] bArr) {
        return org.apache.commons.codec.binary.Hex.encodeHexString(md5(bArr));
    }

    public static java.lang.String md5Hex(java.io.InputStream inputStream) throws java.io.IOException {
        return org.apache.commons.codec.binary.Hex.encodeHexString(md5(inputStream));
    }

    public static java.lang.String md5Hex(java.lang.String str) {
        return org.apache.commons.codec.binary.Hex.encodeHexString(md5(str));
    }

    public static byte[] sha(byte[] bArr) {
        return getShaDigest().digest(bArr);
    }

    public static byte[] sha(java.io.InputStream inputStream) throws java.io.IOException {
        return digest(getShaDigest(), inputStream);
    }

    public static byte[] sha(java.lang.String str) {
        return sha(getBytesUtf8(str));
    }

    public static byte[] sha256(byte[] bArr) {
        return getSha256Digest().digest(bArr);
    }

    public static byte[] sha256(java.io.InputStream inputStream) throws java.io.IOException {
        return digest(getSha256Digest(), inputStream);
    }

    public static byte[] sha256(java.lang.String str) {
        return sha256(getBytesUtf8(str));
    }

    public static java.lang.String sha256Hex(byte[] bArr) {
        return org.apache.commons.codec.binary.Hex.encodeHexString(sha256(bArr));
    }

    public static java.lang.String sha256Hex(java.io.InputStream inputStream) throws java.io.IOException {
        return org.apache.commons.codec.binary.Hex.encodeHexString(sha256(inputStream));
    }

    public static java.lang.String sha256Hex(java.lang.String str) {
        return org.apache.commons.codec.binary.Hex.encodeHexString(sha256(str));
    }

    public static byte[] sha384(byte[] bArr) {
        return getSha384Digest().digest(bArr);
    }

    public static byte[] sha384(java.io.InputStream inputStream) throws java.io.IOException {
        return digest(getSha384Digest(), inputStream);
    }

    public static byte[] sha384(java.lang.String str) {
        return sha384(getBytesUtf8(str));
    }

    public static java.lang.String sha384Hex(byte[] bArr) {
        return org.apache.commons.codec.binary.Hex.encodeHexString(sha384(bArr));
    }

    public static java.lang.String sha384Hex(java.io.InputStream inputStream) throws java.io.IOException {
        return org.apache.commons.codec.binary.Hex.encodeHexString(sha384(inputStream));
    }

    public static java.lang.String sha384Hex(java.lang.String str) {
        return org.apache.commons.codec.binary.Hex.encodeHexString(sha384(str));
    }

    public static byte[] sha512(byte[] bArr) {
        return getSha512Digest().digest(bArr);
    }

    public static byte[] sha512(java.io.InputStream inputStream) throws java.io.IOException {
        return digest(getSha512Digest(), inputStream);
    }

    public static byte[] sha512(java.lang.String str) {
        return sha512(getBytesUtf8(str));
    }

    public static java.lang.String sha512Hex(byte[] bArr) {
        return org.apache.commons.codec.binary.Hex.encodeHexString(sha512(bArr));
    }

    public static java.lang.String sha512Hex(java.io.InputStream inputStream) throws java.io.IOException {
        return org.apache.commons.codec.binary.Hex.encodeHexString(sha512(inputStream));
    }

    public static java.lang.String sha512Hex(java.lang.String str) {
        return org.apache.commons.codec.binary.Hex.encodeHexString(sha512(str));
    }

    public static java.lang.String shaHex(byte[] bArr) {
        return org.apache.commons.codec.binary.Hex.encodeHexString(sha(bArr));
    }

    public static java.lang.String shaHex(java.io.InputStream inputStream) throws java.io.IOException {
        return org.apache.commons.codec.binary.Hex.encodeHexString(sha(inputStream));
    }

    public static java.lang.String shaHex(java.lang.String str) {
        return org.apache.commons.codec.binary.Hex.encodeHexString(sha(str));
    }
}
