package com.sandy.mockito.case1;

import com.sandy.mockito.case1.InvoiceCalculator;
import com.sandy.mockito.case1.MarginFetcher;
import com.sandy.mockito.case1.SpendFetcher;
import org.junit.Assert;
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

/**
 * Created by gondals on 27/08/16.
 */
public class InvoiceCalculatorTest {

    @Mock private MarginFetcher marginFetcher;
    @Mock private SpendFetcher spendFetcher;
    @InjectMocks private InvoiceCalculator invoiceCalculator;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldComputeZeroInvoiceIfErrorSpendIsMoreThanInternalAndExternalSpend() throws Exception {
        long customerNumber = new Random().nextLong();
        long packageId = new Random().nextLong();

        Mockito.when(spendFetcher.getInternalSpend(customerNumber, packageId)).thenReturn(new BigDecimal(120));
        Mockito.when(spendFetcher.getExternalSpend(customerNumber, packageId)).thenReturn(new BigDecimal(10));
        Mockito.when(spendFetcher.getErrorSpend(customerNumber, packageId)).thenReturn(new BigDecimal(150));
        Mockito.when(marginFetcher.fetchMargin(customerNumber, packageId)).thenReturn(new BigDecimal(0.40));

        Assert.assertEquals(0.0, invoiceCalculator.computeInvoice(customerNumber, packageId).doubleValue(), 0.01);

        // Verify if method is called with specific arguments
        Mockito.verify(spendFetcher).getInternalSpend(customerNumber, packageId);

        // Verify if method is called with any arguments
        Mockito.verify(spendFetcher).getErrorSpend(Mockito.anyLong(), Mockito.anyLong());

        // Verify if method is called with one any argument and other specific value.
        Mockito.verify(spendFetcher).getExternalSpend(Mockito.anyLong(), Mockito.eq(packageId));
    }

    @Test
    public void shouldComputeInvoiceWhenMarginIsZero() throws Exception {
        long customerNumber = new Random().nextLong();
        long packageId = new Random().nextLong();

        Mockito.when(spendFetcher.getInternalSpend(customerNumber, packageId)).thenReturn(new BigDecimal(120));
        Mockito.when(spendFetcher.getExternalSpend(customerNumber, packageId)).thenReturn(new BigDecimal(10));
        Mockito.when(spendFetcher.getErrorSpend(customerNumber, packageId)).thenReturn(new BigDecimal(50));
        Mockito.when(marginFetcher.fetchMargin(customerNumber, packageId)).thenReturn(new BigDecimal(0.0));

        Assert.assertEquals(80.0, invoiceCalculator.computeInvoice(customerNumber, packageId).doubleValue(), 0.01);
    }

    @Test
    public void shouldComputeInvoiceWithSomeMargin() throws Exception {
        long customerNumber = new Random().nextLong();
        long packageId = new Random().nextLong();

        Mockito.when(spendFetcher.getInternalSpend(customerNumber, packageId)).thenReturn(new BigDecimal(120));
        Mockito.when(spendFetcher.getExternalSpend(customerNumber, packageId)).thenReturn(new BigDecimal(10));
        Mockito.when(spendFetcher.getErrorSpend(customerNumber, packageId)).thenReturn(new BigDecimal(50));
        Mockito.when(marginFetcher.fetchMargin(customerNumber, packageId)).thenReturn(new BigDecimal(0.40));

        Assert.assertEquals(133.33, invoiceCalculator.computeInvoice(customerNumber, packageId).doubleValue(), 0.01);
    }

    @Test (expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForCustomer100WhileSendingInvoice() throws Exception {
        long customerNumber = 100;
        long packageId = 23;

        Mockito.doThrow(IllegalArgumentException.class).when(marginFetcher).fetchMargin(Mockito.eq(customerNumber), Mockito.anyLong());
        Mockito.when(spendFetcher.getInternalSpend(customerNumber, packageId)).thenReturn(new BigDecimal(120));
        Mockito.when(spendFetcher.getExternalSpend(customerNumber, packageId)).thenReturn(new BigDecimal(10));
        Mockito.when(spendFetcher.getErrorSpend(customerNumber, packageId)).thenReturn(new BigDecimal(50));

        invoiceCalculator.computeInvoice(customerNumber, packageId);
    }

    @Test
    public void checkOrderOfSpends() throws Exception {
        long customerNumber = 110;
        long packageId = 23;

        Mockito.when(marginFetcher.fetchMargin(Mockito.eq(customerNumber), Mockito.anyLong())).thenReturn(new BigDecimal(0.40));
        Mockito.when(spendFetcher.getInternalSpend(customerNumber, packageId)).thenReturn(new BigDecimal(120));
        Mockito.when(spendFetcher.getExternalSpend(customerNumber, packageId)).thenReturn(new BigDecimal(10));
        Mockito.when(spendFetcher.getErrorSpend(customerNumber, packageId)).thenReturn(new BigDecimal(50));

        invoiceCalculator.computeInvoice(customerNumber, packageId);

        InOrder inOrder = Mockito.inOrder(spendFetcher, marginFetcher);
        inOrder.verify(marginFetcher).fetchMargin(Mockito.anyLong(), Mockito.anyLong());
        inOrder.verify(spendFetcher).getInternalSpend(customerNumber, packageId);
        inOrder.verify(spendFetcher).getExternalSpend(customerNumber, packageId);
        inOrder.verify(spendFetcher).getErrorSpend(customerNumber, packageId);
    }

    @Test
    public void checkArguments() throws Exception {
        long customerNumber = 110;
        long packageId = 23;

        Mockito.when(marginFetcher.fetchMargin(Mockito.eq(customerNumber), Mockito.anyLong())).thenReturn(new BigDecimal(0.40));
        Mockito.when(spendFetcher.getInternalSpend(customerNumber, packageId)).thenReturn(new BigDecimal(120));
        Mockito.when(spendFetcher.getExternalSpend(customerNumber, packageId)).thenReturn(new BigDecimal(10));
        Mockito.when(spendFetcher.getErrorSpend(customerNumber, packageId)).thenReturn(new BigDecimal(50));
        invoiceCalculator.computeInvoice(customerNumber, packageId);

        ArgumentCaptor<Long> customerNoCaptor = ArgumentCaptor.forClass(Long.class);
        ArgumentCaptor<Long> packageIdCaptor = ArgumentCaptor.forClass(Long.class);

        Mockito.verify(spendFetcher).getInternalSpend(customerNoCaptor.capture(), packageIdCaptor.capture());
        Assert.assertEquals(customerNumber, customerNoCaptor.getValue().longValue());
        Assert.assertEquals(packageId, packageIdCaptor.getValue().longValue());
    }

    @Test
    public void returnSomeInternalSpend() throws Exception {
        long customerNumber = 110;
        long packageId = 23;

        Mockito.when(marginFetcher.fetchMargin(Mockito.eq(customerNumber), Mockito.anyLong())).thenReturn(new BigDecimal(0.40));
        Mockito.when(spendFetcher.getExternalSpend(customerNumber, packageId)).thenReturn(new BigDecimal(10));
        Mockito.when(spendFetcher.getErrorSpend(customerNumber, packageId)).thenReturn(new BigDecimal(50));

        Mockito.doAnswer(invocationOnMock -> new BigDecimal(500)).when(spendFetcher).getInternalSpend(Mockito.anyLong(), Mockito.anyLong());

        BigDecimal invoice = invoiceCalculator.computeInvoice(customerNumber, packageId);
        Assert.assertEquals(766.67, invoice.doubleValue(), 0.01);
    }
}
