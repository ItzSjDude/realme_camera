package com.google.zxing.client.result;

/* loaded from: classes.dex */
public final class AddressBookParsedResult extends com.google.zxing.client.result.ParsedResult {
    private final java.lang.String[] addressTypes;
    private final java.lang.String[] addresses;
    private final java.lang.String birthday;
    private final java.lang.String[] emailTypes;
    private final java.lang.String[] emails;
    private final java.lang.String[] geo;
    private final java.lang.String instantMessenger;
    private final java.lang.String[] names;
    private final java.lang.String[] nicknames;
    private final java.lang.String note;

    /* renamed from: org, reason: collision with root package name */
    private final java.lang.String f3155org;
    private final java.lang.String[] phoneNumbers;
    private final java.lang.String[] phoneTypes;
    private final java.lang.String pronunciation;
    private final java.lang.String title;
    private final java.lang.String[] urls;

    public AddressBookParsedResult(java.lang.String[] strArr, java.lang.String[] strArr2, java.lang.String[] strArr3, java.lang.String[] strArr4, java.lang.String[] strArr5, java.lang.String[] strArr6, java.lang.String[] strArr7) {
        this(strArr, null, null, strArr2, strArr3, strArr4, strArr5, null, null, strArr6, strArr7, null, null, null, null, null);
    }

    public AddressBookParsedResult(java.lang.String[] strArr, java.lang.String[] strArr2, java.lang.String str, java.lang.String[] strArr3, java.lang.String[] strArr4, java.lang.String[] strArr5, java.lang.String[] strArr6, java.lang.String str2, java.lang.String str3, java.lang.String[] strArr7, java.lang.String[] strArr8, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String[] strArr9, java.lang.String[] strArr10) {
        super(com.google.zxing.client.result.ParsedResultType.ADDRESSBOOK);
        if (strArr3 != null && strArr4 != null && strArr3.length != strArr4.length) {
            throw new java.lang.IllegalArgumentException("Phone numbers and types lengths differ");
        }
        if (strArr5 != null && strArr6 != null && strArr5.length != strArr6.length) {
            throw new java.lang.IllegalArgumentException("Emails and types lengths differ");
        }
        if (strArr7 != null && strArr8 != null && strArr7.length != strArr8.length) {
            throw new java.lang.IllegalArgumentException("Addresses and types lengths differ");
        }
        this.names = strArr;
        this.nicknames = strArr2;
        this.pronunciation = str;
        this.phoneNumbers = strArr3;
        this.phoneTypes = strArr4;
        this.emails = strArr5;
        this.emailTypes = strArr6;
        this.instantMessenger = str2;
        this.note = str3;
        this.addresses = strArr7;
        this.addressTypes = strArr8;
        this.f3155org = str4;
        this.birthday = str5;
        this.title = str6;
        this.urls = strArr9;
        this.geo = strArr10;
    }

    public java.lang.String[] getNames() {
        return this.names;
    }

    public java.lang.String[] getNicknames() {
        return this.nicknames;
    }

    public java.lang.String getPronunciation() {
        return this.pronunciation;
    }

    public java.lang.String[] getPhoneNumbers() {
        return this.phoneNumbers;
    }

    public java.lang.String[] getPhoneTypes() {
        return this.phoneTypes;
    }

    public java.lang.String[] getEmails() {
        return this.emails;
    }

    public java.lang.String[] getEmailTypes() {
        return this.emailTypes;
    }

    public java.lang.String getInstantMessenger() {
        return this.instantMessenger;
    }

    public java.lang.String getNote() {
        return this.note;
    }

    public java.lang.String[] getAddresses() {
        return this.addresses;
    }

    public java.lang.String[] getAddressTypes() {
        return this.addressTypes;
    }

    public java.lang.String getTitle() {
        return this.title;
    }

    public java.lang.String getOrg() {
        return this.f3155org;
    }

    public java.lang.String[] getURLs() {
        return this.urls;
    }

    public java.lang.String getBirthday() {
        return this.birthday;
    }

    public java.lang.String[] getGeo() {
        return this.geo;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public java.lang.String getDisplayResult() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(100);
        maybeAppend(this.names, sb);
        maybeAppend(this.nicknames, sb);
        maybeAppend(this.pronunciation, sb);
        maybeAppend(this.title, sb);
        maybeAppend(this.f3155org, sb);
        maybeAppend(this.addresses, sb);
        maybeAppend(this.phoneNumbers, sb);
        maybeAppend(this.emails, sb);
        maybeAppend(this.instantMessenger, sb);
        maybeAppend(this.urls, sb);
        maybeAppend(this.birthday, sb);
        maybeAppend(this.geo, sb);
        maybeAppend(this.note, sb);
        return sb.toString();
    }
}
