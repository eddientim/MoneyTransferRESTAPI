package utils;

import org.testng.Assert;
import org.testng.annotations.Test;

import utility.AmountUtil;

/**
 * Unit Test
 */
public class AmountUtilTest {

    @Test
    public void test_CountDecimalPlaces_WithSingleDP_Expect_One() {
        final double oneDecimalPlace = 3.0;
        final int decimalPlaces = AmountUtil.countDecimalPlaces(oneDecimalPlace);
        Assert.assertEquals(1, decimalPlaces);
    }



}
