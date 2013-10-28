package org.sample;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateCountItem extends ViewGroup {

    public TextView date;

    public TextView count;

    public static final DateFormat STD_DATE_FORMAT = new SimpleDateFormat("d MMMM");


    public DateCountItem(Context context) {
        super(context);
        init();
    }

    public DateCountItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    void init() {

        inflate(getContext(), R.layout.date_count, this);

        date = (TextView) findViewById(R.id.date);
        count = (TextView) findViewById(R.id.count);
    }

    public void bind(DateCount dateCount) {
        date.setText(STD_DATE_FORMAT.format(dateCount.getDate()));
        count.setText(String.valueOf(dateCount.getCount()));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        measureChild(date, widthMeasureSpec, heightMeasureSpec);
        measureChild(count, widthMeasureSpec, heightMeasureSpec);

        final int width = getPaddingLeft() + date.getMeasuredWidth()
                + count.getMeasuredWidth() + getPaddingRight();

        final int height = getPaddingTop() + date.getMeasuredHeight()
                + count.getMeasuredHeight() + getPaddingBottom();

        setMeasuredDimension(resolveSize(width, widthMeasureSpec),
                resolveSize(height, heightMeasureSpec));
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        // Center Y based on date view height
        final int baseLine = (b - t) / 2 + date.getMeasuredHeight() / 2;
        final int dateEnd = getPaddingLeft() + date.getMeasuredWidth();
        date.layout(getPaddingLeft(), baseLine - date.getMeasuredHeight(), dateEnd, baseLine);

        final int countStart = r - getPaddingRight() - count.getMeasuredWidth();

        // Determine how the dateCount will be displayed, according to the amount of dp
        // between date and count view.


        count.layout(countStart, baseLine - count.getMeasuredHeight(), r - getPaddingLeft(), baseLine);
    }
}
