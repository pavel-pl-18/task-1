package com.hexad.sales.round1.entities.rools;

import com.hexad.sales.round1.enums.PaymentPurposeType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PaymentRoolImplTest {
    @Test
    void rool_should_be_ok() {
        // given
        PaymentRool paymentRool = new PaymentRoolImpl(RoolsConstants.PATTERN_FOR_PRODUCT,
                PaymentPurposeType.PRODUCTS);
        // when
        PaymentPurposeType actual = paymentRool.determinePaymentPurpose(RoolsConstants.PATTERN_FOR_PRODUCT);
        // then
        assertEquals(actual, paymentRool.getPaymentPurposeType());
    }

    @Test
    void rool_should_not_be_ok_if_string_is_null() {
        // given
        PaymentRool paymentRool = new PaymentRoolImpl(RoolsConstants.PATTERN_FOR_PRODUCT,
                PaymentPurposeType.PRODUCTS);
        // when
        PaymentPurposeType actual = paymentRool.determinePaymentPurpose(null);
        // then
        assertEquals(actual, PaymentPurposeType.UNDEFINED);
    }


    @ParameterizedTest
    @MethodSource("rool_should_not_be_ok_data")
    void rool_should_not_be_ok(String stringForCheck) {
        // given
        PaymentRool paymentRool = new PaymentRoolImpl(RoolsConstants.PATTERN_FOR_PRODUCT,
                PaymentPurposeType.PRODUCTS);
        // when
        PaymentPurposeType actual = paymentRool.determinePaymentPurpose(stringForCheck);
        // then
        assertEquals(actual, PaymentPurposeType.UNDEFINED);
    }

    private static Stream<Arguments> rool_should_not_be_ok_data() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of("999"));
    }}