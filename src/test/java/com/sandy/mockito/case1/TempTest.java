package com.sandy.mockito.case1;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by gondals on 12/09/16.
 */
public class TempTest {

    @Mock MarginFetcher marginFetcher;
    @Mock SpendFetcher spendFetcher;
    @InjectMocks InvoiceCalculator invoiceCalculator;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenErrorSpendIsMoreThanInternalAndExternalSpendThenReturnZeroInvoice() throws Exception {
        when(spendFetcher.getInternalSpend(anyLong(), anyLong())).thenReturn(new BigDecimal(100));
        when(spendFetcher.getExternalSpend(anyLong(), anyLong())).thenReturn(new BigDecimal(20));
        doReturn(new BigDecimal(200)).when(spendFetcher).getErrorSpend(anyLong(), anyLong());
        when(marginFetcher.fetchMargin(anyLong(), anyLong())).thenReturn(new BigDecimal(0.40));

        assertEquals(0, invoiceCalculator.computeInvoice(anyLong(), anyLong()).doubleValue(), 0.1);
    }

    @Test
    public void whenMarginIsZeroThenReturnExactSpendAsInvoice() throws Exception {
        when(spendFetcher.getInternalSpend(anyLong(), anyLong())).thenReturn(new BigDecimal(100));
        when(spendFetcher.getExternalSpend(anyLong(), anyLong())).thenReturn(new BigDecimal(20));
        doReturn(new BigDecimal(50)).when(spendFetcher).getErrorSpend(anyLong(), anyLong());
        when(marginFetcher.fetchMargin(anyLong(), anyLong())).thenReturn(BigDecimal.ZERO);

        assertEquals(70, invoiceCalculator.computeInvoice(anyLong(), anyLong()).doubleValue(), 0.1);
    }

    @Test
    public void whenArgumentsPassedToInVoiceCalculatorServiceThenSameArgumentsPassedToSpendAndMarginService() throws Exception {
        Random randomUtil = new Random();
        final long customerNumber = randomUtil.nextLong();
        final long packageId = randomUtil.nextLong();

        when(spendFetcher.getInternalSpend(customerNumber, packageId)).thenReturn(new BigDecimal(100));
        when(spendFetcher.getExternalSpend(customerNumber, packageId)).thenReturn(new BigDecimal(20));
        doReturn(new BigDecimal(50)).when(spendFetcher).getErrorSpend(customerNumber, packageId);
        when(marginFetcher.fetchMargin(customerNumber, packageId)).thenReturn(BigDecimal.ZERO);
        invoiceCalculator.computeInvoice(customerNumber, packageId);

        ArgumentCaptor<Long> customerNumberCaptor = ArgumentCaptor.forClass(Long.class);
        ArgumentCaptor<Long> packageIdCaptor = ArgumentCaptor.forClass(Long.class);

        verify(spendFetcher).getInternalSpend(customerNumberCaptor.capture(), packageIdCaptor.capture());
        assertEquals(customerNumber, customerNumberCaptor.getValue().longValue());
        assertEquals(packageId, packageIdCaptor.getValue().longValue());
    }

    @Test
    public void whenInvoiceCalculatorIsInvokedThenServiceAreInvokedInOrder() throws Exception {
        when(spendFetcher.getInternalSpend(anyLong(), anyLong())).thenReturn(new BigDecimal(100));
        when(spendFetcher.getExternalSpend(anyLong(), anyLong())).thenReturn(new BigDecimal(20));
        doReturn(new BigDecimal(50)).when(spendFetcher).getErrorSpend(anyLong(), anyLong());
        when(marginFetcher.fetchMargin(anyLong(), anyLong())).thenReturn(BigDecimal.ZERO);

        InOrder inOrder = inOrder(marginFetcher, spendFetcher);
        invoiceCalculator.computeInvoice(anyLong(), anyLong());
        inOrder.verify(marginFetcher).fetchMargin(anyLong(), anyLong());
        inOrder.verify(spendFetcher).getInternalSpend(anyLong(), anyLong());
        inOrder.verify(spendFetcher).getExternalSpend(anyLong(), anyLong());
        inOrder.verify(spendFetcher).getErrorSpend(anyLong(), anyLong());
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenInvoiceCalculatorIsCalledWithInvalidDataThenException() throws Exception {
        when(spendFetcher.getInternalSpend(anyLong(), anyLong())).thenReturn(new BigDecimal(100));
        when(spendFetcher.getExternalSpend(anyLong(), anyLong())).thenReturn(new BigDecimal(20));
        doReturn(new BigDecimal(50)).when(spendFetcher).getErrorSpend(anyLong(), anyLong());
        when(marginFetcher.fetchMargin(anyLong(), anyLong())).thenReturn(BigDecimal.ZERO);

        doThrow(IllegalArgumentException.class).when(spendFetcher).getInternalSpend(100, 200);
        invoiceCalculator.computeInvoice(100, 200);
    }

    @Test
    public void whenInvoiceCalculatorIsCalledThenReturnInvoice() throws Exception {
        doAnswer( o -> {
            long customerNo = o.getArgumentAt(0, Long.class);
            long packageId = o.getArgumentAt(1, Long.class);

            if (customerNo == 100 && packageId == 100)
                return new BigDecimal(0.3);
            else
                return new BigDecimal(0.4);

        }).when(marginFetcher).fetchMargin(anyLong(), anyLong());

        when(spendFetcher.getInternalSpend(anyLong(), anyLong())).thenReturn(new BigDecimal(100));
        when(spendFetcher.getExternalSpend(anyLong(), anyLong())).thenReturn(new BigDecimal(20));
        doReturn(new BigDecimal(50)).when(spendFetcher).getErrorSpend(anyLong(), anyLong());

        assertEquals(100, invoiceCalculator.computeInvoice(100, 100).doubleValue(), 0.1);
        assertEquals(116.67, invoiceCalculator.computeInvoice(100, 200).doubleValue(), 0.1);
    }
}
