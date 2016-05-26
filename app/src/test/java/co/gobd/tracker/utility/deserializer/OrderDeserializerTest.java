package co.gobd.tracker.utility.deserializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import co.gobd.tracker.model.job.Location;
import co.gobd.tracker.model.job.order.Order;
import co.gobd.tracker.model.job.order.OrderCart;

import static org.junit.Assert.assertEquals;

/**
 * Created by fahad on 5/18/16.
 */

public class OrderDeserializerTest {

    private Gson gson;

    @Before
    public void setUp() throws Exception {
        gson = new GsonBuilder()
                .registerTypeAdapter(Order.class, new OrderDeserializer())
                .create();

    }

    @Test
    public void testDeserialize() throws Exception {

        String json = "{\n" +
                "\"From\":{\n" +
                    "\"Address\":\", 1 Floor, Rd No 10, Dhaka, Bangladesh, Dhaka\",\n" +
                    "\"PostalCode\":\"\",\n" +
                    "\"Floor\":\"1\",\n" +
                    "\"HouseNumber\":\"\",\n" +
                    "\"AddressLine1\":\"Rd No 10, Dhaka, Bangladesh\",\n" +
                    "\"AddressLine2\":\"\",\n" +
                    "\"Country\":\"\",\n" +
                    "\"City\":\"Dhaka\",\n" +
                    "\"State\":\"\",\n" +
                    "\"Point\":{\n" +
                        "\"type\":\"Point\",\n" +
                        "\"coordinates\":[\n" +
                            "90.413073096424341,\n" +
                            "23.810867953594631\n" +
                            "]\n" +
                        "},\n" +
                    "\"Provider\":\"Default\"\n" +
                    "},\n" +

                "\"To\":{\n" +
                    "\"Address\":\", 1 Floor, Rd No 22, Dhaka, Bangladesh, Dhaka\",\n" +
                    "\"PostalCode\":\"\",\n" +
                    "\"Floor\":\"1\",\n" +
                    "\"HouseNumber\":\"\",\n" +
                    "\"AddressLine1\":\"Rd No 22, Dhaka, Bangladesh\",\n" +
                    "\"AddressLine2\":\"\",\n" +
                    "\"Country\":\"\",\n" +
                    "\"City\":\"Dhaka\",\n" +
                    "\"State\":\"\",\n" +
                    "\"Point\":{\n" +
                        "\"type\":\"Point\",\n" +
                        "\"coordinates\":[\n" +
                            "90.4065113235265,\n" +
                            "23.795142360927329\n" +
                            "]\n" +
                        "},\n" +
                    "\"Provider\":\"Default\"\n" +
                    "},\n" +

                "\"PackageDescription\":\"Aloooz\",\n" +

                "\"OrderCart\":{\n" +
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
                    "},\n" +

                "\"NoteToDeliveryMan\":\"Falai dio na tailei hobe\",\n" +

                "\"Name\":\"\",\n" +

                "\"Type\":\"Delivery\",\n" +

                "\"PayloadType\":\"default\",\n" +

                "\"UserId\":\"572745cc5d437156387b186c\",\n" +

                "\"OrderLocation\":null,\n" +

                "\"ETA\":null,\n" +

                "\"ETAMinutes\":2.0,\n" +

                "\"PaymentMethod\":\"CashOnDelivery\"\n" +
                "}";

        Order order = gson.fromJson(json, Order.class);


        assertEquals("Falai dio na tailei hobe", order.getNoteToDeliveryMan());
        assertEquals("", order.getName());
        assertEquals("Delivery", order.getType());
        assertEquals("default", order.getPayloadType());
        assertEquals("572745cc5d437156387b186c", order.getUserId());
        assertEquals(null, order.getOrderLocation());
        assertEquals(null, order.getETA());
        assertEquals(new Double(2.0), order.getETAMinutes());
        assertEquals("CashOnDelivery", order.getPaymentMethod());
    }

    @Test
    public void testGetLocation() throws Exception {

        String json = "{\n" +
                "\"Address\":\", 1 Floor, Rd No 10, Dhaka, Bangladesh, Dhaka\",\n" +
                "\"PostalCode\":\"\",\n" +
                "\"Floor\":\"1\",\n" +
                "\"HouseNumber\":\"\",\n" +
                "\"AddressLine1\":\"Rd No 10, Dhaka, Bangladesh\",\n" +
                "\"AddressLine2\":\"\",\n" +
                "\"Country\":\"\",\n" +
                "\"City\":\"Dhaka\",\n" +
                "\"State\":\"\",\n" +
                "\"Point\":{\n" +
                    "\"type\":\"Point\",\n" +
                    "\"coordinates\":[\n" +
                        "90.413073096424341,\n" +
                        "23.810867953594631\n" +
                    "]\n" +
                "},\n" +
                "\"Provider\":\"Default\"\n" +
                "}";

        Location location = gson.fromJson(json, Location.class);

        assertEquals(", 1 Floor, Rd No 10, Dhaka, Bangladesh, Dhaka", location.getAddress());


    }
}