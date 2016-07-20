package co.gobd.tracker.utility.deserializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Before;
import org.junit.Test;

import co.gobd.tracker.model.job.Location;
import co.gobd.tracker.model.job.order.Order;

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
                "\"NoteToDeliveryMan\":\"Please call and confirm before the pick.\",\n" +
                "\"RequiredChangeFor\":0.0,\n" +
                "\"Name\":\"Delivery Job for ZuumZuum\",\n" +
                "\"From\":{\n" +
                "\"Address\":\"ZigZag\\tMr. Jishad\\t01674004489 / 01912372812\\tLalbag Mor, Banani, Dhaka, Banani, Dhaka\",\n" +
                "\"PostalCode\":\"\",\n" +
                "\"Floor\":\"\",\n" +
                "\"HouseNumber\":\"\",\n" +
                "\"AddressLine1\":\"ZigZag\\tMr. Jishad\\t01674004489 / 01912372812\\tLalbag Mor, Banani, Dhaka\",\n" +
                "\"AddressLine2\":\"\",\n" +
                "\"Country\":\"\",\n" +
                "\"City\":\"Dhaka\",\n" +
                "\"State\":\"\",\n" +
                "\"Locality\":\"Banani\",\n" +
                "\"Point\":{\n" +
                "\"type\":\"Point\",\n" +
                "\"coordinates\":[\n" +
                "]\n" +
                "},\n" +
                "\"Provider\":\"Default\"\n" +
                "},\n" +
                "\"To\":{\n" +
                "\"Address\":\"ZuumZuum HQ, Banani, Dhaka, Banani, Dhaka\",\n" +
                "\"PostalCode\":\"\",\n" +
                "\"Floor\":\"\",\n" +
                "\"HouseNumber\":\"\",\n" +
                "\"AddressLine1\":\"ZuumZuum HQ, Banani, Dhaka\",\n" +
                "\"AddressLine2\":\"\",\n" +
                "\"Country\":\"\",\n" +
                "\"City\":\"Dhaka\",\n" +
                "\"State\":\"\",\n" +
                "\"Locality\":\"Banani\",\n" +
                "\"Point\":{\n" +
                "\"type\":\"Point\",\n" +
                "\"coordinates\":[\n" +
                "]\n" +
                "},\n" +
                "\"Provider\":\"Default\"\n" +
                "},\n" +
                "\"Type\":\"Delivery\",\n" +
                "\"PayloadType\":\"default\",\n" +
                "\"UserId\":\"5766070ab477aa9971d80429\",\n" +
                "\"OrderLocation\":null,\n" +
                "\"ETA\":null,\n" +
                "\"ETAMinutes\":0.0,\n" +
                "\"PaymentMethod\":\"CashOnDelivery\",\n" +
                "\"Description\":\"Supplier pick\",\n" +
                "\"OrderCart\":{\n" +
                "\"PackageList\":[\n" +
                "{\n" +
                "\"Item\":\"T-Shirt\",\n" +
                "\"PicUrl\":null,\n" +
                "\"Quantity\":3,\n" +
                "\"Price\":0.0,\n" +
                "\"VAT\":0.0,\n" +
                "\"Total\":0.0,\n" +
                "\"VATAmount\":0.0,\n" +
                "\"TotalPlusVAT\":0.0,\n" +
                "\"Weight\":0.0\n" +
                "}\n" +
                "],\n" +
                "\"TotalVATAmount\":0.0,\n" +
                "\"SubTotal\":0.0,\n" +
                "\"ServiceCharge\":150.0,\n" +
                "\"TotalWeight\":0.0,\n" +
                "\"TotalToPay\":150.0\n" +
                "}\n" +
                "}";

        Order order = gson.fromJson(json, Order.class);


        assertEquals("Please call and confirm before the pick.", order.getNoteToDeliveryMan());
        assertEquals("Delivery Job for ZuumZuum", order.getName());
        assertEquals("Delivery", order.getType());
        assertEquals("default", order.getPayloadType());
        assertEquals("5766070ab477aa9971d80429", order.getUserId());
        assertEquals(null, order.getOrderLocation());
        assertEquals(null, order.getETA());
        assertEquals(new Double(0.0), order.getETAMinutes());
        assertEquals("CashOnDelivery", order.getPaymentMethod());
    }

    @Test
    public void testGetLocation() throws Exception {

        String json = "{\n" +
                "\"Address\":\"ZuumZuum HQ, Banani, Dhaka, Banani, Dhaka\",\n" +
                "\"PostalCode\":\"\",\n" +
                "\"Floor\":\"\",\n" +
                "\"HouseNumber\":\"\",\n" +
                "\"AddressLine1\":\"ZuumZuum HQ, Banani, Dhaka\",\n" +
                "\"AddressLine2\":\"\",\n" +
                "\"Country\":\"\",\n" +
                "\"City\":\"Dhaka\",\n" +
                "\"State\":\"\",\n" +
                "\"Locality\":\"Banani\",\n" +
                "\"Point\":{\n" +
                "\"type\":\"Point\",\n" +
                "\"coordinates\":[\n" +
                "]\n" +
                "},\n" +
                "\"Provider\":\"Default\"\n" +
                "}";

        Location location = gson.fromJson(json, Location.class);

        assertEquals("ZuumZuum HQ, Banani, Dhaka, Banani, Dhaka", location.getAddress());
        assertEquals("Banani", location.getLocality());


    }
}