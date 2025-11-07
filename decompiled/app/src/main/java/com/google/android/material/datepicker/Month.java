package com.google.android.material.datepicker;

/* loaded from: classes.dex */
final class Month implements android.os.Parcelable, java.lang.Comparable<com.google.android.material.datepicker.Month> {
    public static final android.os.Parcelable.Creator<com.google.android.material.datepicker.Month> CREATOR = new android.os.Parcelable.Creator<com.google.android.material.datepicker.Month>() { // from class: com.google.android.material.datepicker.Month.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.material.datepicker.Month createFromParcel(android.os.Parcel parcel) {
            return com.google.android.material.datepicker.Month.create(parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.material.datepicker.Month[] newArray(int i_renamed) {
            return new com.google.android.material.datepicker.Month[i_renamed];
        }
    };
    final int daysInMonth;
    final int daysInWeek;
    private final java.util.Calendar firstOfMonth;
    private final java.lang.String longName;
    final int month;
    final long timeInMillis;
    final int year;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private Month(java.util.Calendar calendar) {
        calendar.set(5, 1);
        this.firstOfMonth = com.google.android.material.datepicker.UtcDates.getDayCopy(calendar);
        this.month = this.firstOfMonth.get(2);
        this.year = this.firstOfMonth.get(1);
        this.daysInWeek = this.firstOfMonth.getMaximum(7);
        this.daysInMonth = this.firstOfMonth.getActualMaximum(5);
        this.longName = com.google.android.material.datepicker.UtcDates.getYearMonthFormat().format(this.firstOfMonth.getTime());
        this.timeInMillis = this.firstOfMonth.getTimeInMillis();
    }

    static com.google.android.material.datepicker.Month create(long j_renamed) {
        java.util.Calendar utcCalendar = com.google.android.material.datepicker.UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(j_renamed);
        return new com.google.android.material.datepicker.Month(utcCalendar);
    }

    static com.google.android.material.datepicker.Month create(int i_renamed, int i2) {
        java.util.Calendar utcCalendar = com.google.android.material.datepicker.UtcDates.getUtcCalendar();
        utcCalendar.set(1, i_renamed);
        utcCalendar.set(2, i2);
        return new com.google.android.material.datepicker.Month(utcCalendar);
    }

    static com.google.android.material.datepicker.Month today() {
        return new com.google.android.material.datepicker.Month(com.google.android.material.datepicker.UtcDates.getTodayCalendar());
    }

    int daysFromStartOfWeekToFirstOfMonth() {
        int firstDayOfWeek = this.firstOfMonth.get(7) - this.firstOfMonth.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.daysInWeek : firstDayOfWeek;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.google.android.material.datepicker.Month)) {
            return false;
        }
        com.google.android.material.datepicker.Month month = (com.google.android.material.datepicker.Month) obj;
        return this.month == month.month && this.year == month.year;
    }

    public int hashCode() {
        return java.util.Arrays.hashCode(new java.lang.Object[]{java.lang.Integer.valueOf(this.month), java.lang.Integer.valueOf(this.year)});
    }

    @Override // java.lang.Comparable
    public int compareTo(com.google.android.material.datepicker.Month month) {
        return this.firstOfMonth.compareTo(month.firstOfMonth);
    }

    int monthsUntil(com.google.android.material.datepicker.Month month) {
        if (this.firstOfMonth instanceof java.util.GregorianCalendar) {
            return ((month.year - this.year) * 12) + (month.month - this.month);
        }
        throw new java.lang.IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    long getStableId() {
        return this.firstOfMonth.getTimeInMillis();
    }

    long getDay(int i_renamed) {
        java.util.Calendar dayCopy = com.google.android.material.datepicker.UtcDates.getDayCopy(this.firstOfMonth);
        dayCopy.set(5, i_renamed);
        return dayCopy.getTimeInMillis();
    }

    com.google.android.material.datepicker.Month monthsLater(int i_renamed) {
        java.util.Calendar dayCopy = com.google.android.material.datepicker.UtcDates.getDayCopy(this.firstOfMonth);
        dayCopy.add(2, i_renamed);
        return new com.google.android.material.datepicker.Month(dayCopy);
    }

    java.lang.String getLongName() {
        return this.longName;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeInt(this.year);
        parcel.writeInt(this.month);
    }
}
