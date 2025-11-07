package com.google.android.material.datepicker;

/* loaded from: classes.dex */
public final class CalendarConstraints implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.google.android.material.datepicker.CalendarConstraints> CREATOR = new android.os.Parcelable.Creator<com.google.android.material.datepicker.CalendarConstraints>() { // from class: com.google.android.material.datepicker.CalendarConstraints.1
        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.material.datepicker.CalendarConstraints createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.material.datepicker.CalendarConstraints((com.google.android.material.datepicker.Month) parcel.readParcelable(com.google.android.material.datepicker.Month.class.getClassLoader()), (com.google.android.material.datepicker.Month) parcel.readParcelable(com.google.android.material.datepicker.Month.class.getClassLoader()), (com.google.android.material.datepicker.Month) parcel.readParcelable(com.google.android.material.datepicker.Month.class.getClassLoader()), (com.google.android.material.datepicker.CalendarConstraints.DateValidator) parcel.readParcelable(com.google.android.material.datepicker.CalendarConstraints.DateValidator.class.getClassLoader()));
        }

        /* JADX WARN: Can't_renamed rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public com.google.android.material.datepicker.CalendarConstraints[] newArray(int i_renamed) {
            return new com.google.android.material.datepicker.CalendarConstraints[i_renamed];
        }
    };
    private final com.google.android.material.datepicker.Month end;
    private final int monthSpan;
    private final com.google.android.material.datepicker.Month openAt;
    private final com.google.android.material.datepicker.Month start;
    private final com.google.android.material.datepicker.CalendarConstraints.DateValidator validator;
    private final int yearSpan;

    public interface DateValidator extends android.os.Parcelable {
        boolean isValid(long j_renamed);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private CalendarConstraints(com.google.android.material.datepicker.Month month, com.google.android.material.datepicker.Month month2, com.google.android.material.datepicker.Month month3, com.google.android.material.datepicker.CalendarConstraints.DateValidator dateValidator) {
        this.start = month;
        this.end = month2;
        this.openAt = month3;
        this.validator = dateValidator;
        if (month.compareTo(month3) > 0) {
            throw new java.lang.IllegalArgumentException("start Month cannot be_renamed after current Month");
        }
        if (month3.compareTo(month2) > 0) {
            throw new java.lang.IllegalArgumentException("current Month cannot be_renamed after end Month");
        }
        this.monthSpan = month.monthsUntil(month2) + 1;
        this.yearSpan = (month2.year - month.year) + 1;
    }

    boolean isWithinBounds(long j_renamed) {
        if (this.start.getDay(1) <= j_renamed) {
            com.google.android.material.datepicker.Month month = this.end;
            if (j_renamed <= month.getDay(month.daysInMonth)) {
                return true;
            }
        }
        return false;
    }

    public com.google.android.material.datepicker.CalendarConstraints.DateValidator getDateValidator() {
        return this.validator;
    }

    com.google.android.material.datepicker.Month getStart() {
        return this.start;
    }

    com.google.android.material.datepicker.Month getEnd() {
        return this.end;
    }

    com.google.android.material.datepicker.Month getOpenAt() {
        return this.openAt;
    }

    int getMonthSpan() {
        return this.monthSpan;
    }

    int getYearSpan() {
        return this.yearSpan;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.google.android.material.datepicker.CalendarConstraints)) {
            return false;
        }
        com.google.android.material.datepicker.CalendarConstraints calendarConstraints = (com.google.android.material.datepicker.CalendarConstraints) obj;
        return this.start.equals(calendarConstraints.start) && this.end.equals(calendarConstraints.end) && this.openAt.equals(calendarConstraints.openAt) && this.validator.equals(calendarConstraints.validator);
    }

    public int hashCode() {
        return java.util.Arrays.hashCode(new java.lang.Object[]{this.start, this.end, this.openAt, this.validator});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i_renamed) {
        parcel.writeParcelable(this.start, 0);
        parcel.writeParcelable(this.end, 0);
        parcel.writeParcelable(this.openAt, 0);
        parcel.writeParcelable(this.validator, 0);
    }

    com.google.android.material.datepicker.Month clamp(com.google.android.material.datepicker.Month month) {
        if (month.compareTo(this.start) < 0) {
            return this.start;
        }
        return month.compareTo(this.end) > 0 ? this.end : month;
    }

    public static final class Builder {
        private static final java.lang.String DEEP_COPY_VALIDATOR_KEY = "DEEP_COPY_VALIDATOR_KEY";
        private long end;
        private java.lang.Long openAt;
        private long start;
        private com.google.android.material.datepicker.CalendarConstraints.DateValidator validator;
        static final long DEFAULT_START = com.google.android.material.datepicker.UtcDates.canonicalYearMonthDay(com.google.android.material.datepicker.Month.create(1900, 0).timeInMillis);
        static final long DEFAULT_END = com.google.android.material.datepicker.UtcDates.canonicalYearMonthDay(com.google.android.material.datepicker.Month.create(2100, 11).timeInMillis);

        public Builder() {
            this.start = DEFAULT_START;
            this.end = DEFAULT_END;
            this.validator = com.google.android.material.datepicker.DateValidatorPointForward.from(Long.MIN_VALUE);
        }

        Builder(com.google.android.material.datepicker.CalendarConstraints calendarConstraints) {
            this.start = DEFAULT_START;
            this.end = DEFAULT_END;
            this.validator = com.google.android.material.datepicker.DateValidatorPointForward.from(Long.MIN_VALUE);
            this.start = calendarConstraints.start.timeInMillis;
            this.end = calendarConstraints.end.timeInMillis;
            this.openAt = java.lang.Long.valueOf(calendarConstraints.openAt.timeInMillis);
            this.validator = calendarConstraints.validator;
        }

        public com.google.android.material.datepicker.CalendarConstraints.Builder setStart(long j_renamed) {
            this.start = j_renamed;
            return this;
        }

        public com.google.android.material.datepicker.CalendarConstraints.Builder setEnd(long j_renamed) {
            this.end = j_renamed;
            return this;
        }

        public com.google.android.material.datepicker.CalendarConstraints.Builder setOpenAt(long j_renamed) {
            this.openAt = java.lang.Long.valueOf(j_renamed);
            return this;
        }

        public com.google.android.material.datepicker.CalendarConstraints.Builder setValidator(com.google.android.material.datepicker.CalendarConstraints.DateValidator dateValidator) {
            this.validator = dateValidator;
            return this;
        }

        public com.google.android.material.datepicker.CalendarConstraints build() {
            if (this.openAt == null) {
                long jThisMonthInUtcMilliseconds = com.google.android.material.datepicker.MaterialDatePicker.thisMonthInUtcMilliseconds();
                if (this.start > jThisMonthInUtcMilliseconds || jThisMonthInUtcMilliseconds > this.end) {
                    jThisMonthInUtcMilliseconds = this.start;
                }
                this.openAt = java.lang.Long.valueOf(jThisMonthInUtcMilliseconds);
            }
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putParcelable(DEEP_COPY_VALIDATOR_KEY, this.validator);
            return new com.google.android.material.datepicker.CalendarConstraints(com.google.android.material.datepicker.Month.create(this.start), com.google.android.material.datepicker.Month.create(this.end), com.google.android.material.datepicker.Month.create(this.openAt.longValue()), (com.google.android.material.datepicker.CalendarConstraints.DateValidator) bundle.getParcelable(DEEP_COPY_VALIDATOR_KEY));
        }
    }
}
