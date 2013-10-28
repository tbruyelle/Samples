package org.sample;

import android.view.View;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import java.util.Date;

import static org.fest.assertions.api.ANDROID.assertThat;

@RunWith(RobolectricTestRunner.class)
public class DateCountItemTest {

    private DateCountItem dateCountItem;

    @Before
    public void setup() {
        dateCountItem = new DateCountItem(Robolectric.application);
    }

    @Test
    public void assert_display_after_bind() {
        DateCount dateCount = new DateCount(new Date(), 0);
        dateCountItem.bind(dateCount);

        dateCountItem.measure(View.MeasureSpec.makeMeasureSpec(300, View.MeasureSpec.AT_MOST),
                View.MeasureSpec.makeMeasureSpec(100, View.MeasureSpec.AT_MOST));

        assertThat(dateCountItem).isVisible();

        Assert.assertTrue(dateCountItem.date.getMeasuredWidth() > 0);
        Assert.assertTrue(dateCountItem.date.getMeasuredHeight() > 0);
        Assert.assertTrue(dateCountItem.count.getMeasuredWidth() > 0);
        Assert.assertTrue(dateCountItem.count.getMeasuredHeight() > 0);
    }
}
