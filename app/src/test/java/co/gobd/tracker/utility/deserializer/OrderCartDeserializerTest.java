package co.gobd.tracker.utility.deserializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import co.gobd.tracker.model.job.order.OrderCart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by fahad on 5/18/16.
 */

@RunWith(JUnit4.class)
public class OrderCartDeserializerTest {

    private Gson gson;

    @Before
    public void setUp() throws Exception {
        gson = new GsonBuilder()
                .registerTypeAdapter(OrderCart.class, new OrderCartDeserializer())
                .create();

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testDeserialize() throws Exception {

        String json = "{\n" +
                "\"PackageList\":[\n" +
                "{\n" +
                "\"Item\":\"Alu\",\n" +
                "\"Quantity\":1,\n" +
                "\"Price\":10.0,\n" +
                "\"VAT\":11.0,\n" +
                "\"Total\":10.0,\n" +
                "\"VATAmount\":1.10,\n" +
                "\"TotalPlusVAT\":11.10,\n" +
                "\"Weight\":1.0\n" +
                "},\n" +
                "{\n" +
                "\"Item\": \"Alu\",\n" +
                "\"Quantity\": 1,\n" +
                "\"Price\": 10,\n" +
                "\"VAT\": 11,\n" +
                "\"Total\": 10,\n" +
                "\"VATAmount\": 1.1,\n" +
                "\"TotalPlusVAT\": 11.1,\n" +
                "\"Weight\": 1\n" +
                "}\n" +
                "],\n" +
                "\"TotalVATAmount\":1.10,\n" +
                "\"SubTotal\":11.10,\n" +
                "\"ServiceCharge\":0.0,\n" +
                "\"TotalWeight\":1.0,\n" +
                "\"TotalToPay\":11.10\n" +
                "}";

        OrderCart orderCart = gson.fromJson(json, OrderCart.class);

        assertNotEquals(orderCart.getPackageList().size(), 0);
        assertEquals(new Double(1.10), orderCart.getTotalVATAmount());
        assertEquals(new Double(11.10), orderCart.getSubTotal());
        assertEquals(new Double(0.0), orderCart.getServiceCharge());
        assertEquals(new Double(1.0), orderCart.getTotalWeight());
        assertEquals(new Double(11.10), orderCart.getTotalToPay());
    }
}