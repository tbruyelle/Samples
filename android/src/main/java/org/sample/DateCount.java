package org.sample;

import java.util.Date;

public class DateCount {
    private Date date;
    private int count;

    public DateCount(Date date, int count) {
        this.date = date;
        this.count = count;
    }

    public Date getDate() {
        return date;
    }

    public int getCount() {
        return count;
    }
}
