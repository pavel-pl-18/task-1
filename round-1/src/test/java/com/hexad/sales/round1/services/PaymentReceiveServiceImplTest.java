package com.hexad.sales.round1.services;

import com.hexad.sales.round1.entities.rools.PaymentRool;
import com.hexad.sales.round1.entities.rools.RoolsConstants;
import com.hexad.sales.round1.enums.PaymentPurposeType;
import com.hexad.sales.round1.utils.DataStubs;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@Disabled
class PaymentReceiveServiceImplTest {

    PaymentReceiveServiceImpl paymentReceiveService = new PaymentReceiveServiceImpl();
    List<PaymentRool> roolsSet = null;
    {
        roolsSet = DataStubs.getPaymentRoolSet();
    }


    @ParameterizedTest
    @MethodSource("test_determinePaymentPurpose_data")
    void test_determinePaymentPurpose(String stringForCheck, PaymentRool paymentRool) {
        // given

        // when
//        paymentReceiveService.determinePaymentPurpose(roolsSet, stringForCheck);
        // then

    }

    private static Stream<Arguments> test_determinePaymentPurpose_data() {
        return Stream.of(
//                Arguments.of("Hello", 5),
                Arguments.of(RoolsConstants.PATTERN_FOR_PRODUCT, PaymentPurposeType.PRODUCTS));
    }


}