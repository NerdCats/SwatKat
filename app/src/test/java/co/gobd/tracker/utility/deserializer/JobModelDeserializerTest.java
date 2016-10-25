package co.gobd.tracker.utility.deserializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.gobd.tracker.model.job.JobModel;

import static org.junit.Assert.assertEquals;

/**
 * Created by fahad on 5/26/2016.
 */

public class JobModelDeserializerTest {

    private Gson gson;

    @Before
    public void setUp() throws Exception {
        gson = new GsonBuilder()
                .registerTypeAdapter(JobModelDeserializer.class, new JobModelDeserializer())
                .create();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testDeserialize() throws Exception {

        String json = "    {\n" +
                "        \"Assets\":{\n" +
                "            \"571f5e155d43711bd0f215ca\":{\n" +
                "                \"AverageRating\":0.0,\n" +
                "                \"UserName\":\"fahad\",\n" +
                "                \"Profile\":{\n" +
                "                    \"NationalId\":null,\n" +
                "                    \"DriversLicenseId\":null,\n" +
                "                    \"Vehicle\":null,\n" +
                "                    \"FirstName\":null,\n" +
                "                    \"LastName\":null,\n" +
                "                    \"Age\":0,\n" +
                "                    \"Gender\":\"MALE\",\n" +
                "                    \"Address\":null,\n" +
                "                    \"PicUri\":null\n" +
                "                },\n" +
                "                \"Id\":\"571f5e155d43711bd0f215ca\",\n" +
                "                \"Type\":\"BIKE_MESSENGER\",\n" +
                "                \"PhoneNumber\":\"\",\n" +
                "                \"Email\":\"fahad@gobd.co\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"Name\":\"Delivery Job for ZuumZuum\",\n" +
                "        \"Order\":{\n" +
                "            \"From\":{\n" +
                "                \"Address\":\", 1 Floor, Rd No 10, Dhaka, Bangladesh, Dhaka\",\n" +
                "                \"PostalCode\":\"\",\n" +
                "                \"Floor\":\"1\",\n" +
                "                \"HouseNumber\":\"\",\n" +
                "                \"AddressLine1\":\"Rd No 10, Dhaka, Bangladesh\",\n" +
                "                \"AddressLine2\":\"\",\n" +
                "                \"Country\":\"\",\n" +
                "                \"City\":\"Dhaka\",\n" +
                "                \"State\":\"\",\n" +
                "                \"Point\":{\n" +
                "                    \"type\":\"Point\",\n" +
                "                    \"coordinates\":[\n" +
                "                        90.413073096424341,\n" +
                "                        23.810867953594631\n" +
                "                    ]\n" +
                "                },\n" +
                "                \"Provider\":\"Default\"\n" +
                "            },\n" +
                "            \"To\":{\n" +
                "                \"Address\":\", 1 Floor, Rd No 22, Dhaka, Bangladesh, Dhaka\",\n" +
                "                \"PostalCode\":\"\",\n" +
                "                \"Floor\":\"1\",\n" +
                "                \"HouseNumber\":\"\",\n" +
                "                \"AddressLine1\":\"Rd No 22, Dhaka, Bangladesh\",\n" +
                "                \"AddressLine2\":\"\",\n" +
                "                \"Country\":\"\",\n" +
                "                \"City\":\"Dhaka\",\n" +
                "                \"State\":\"\",\n" +
                "                \"Point\":{\n" +
                "                    \"type\":\"Point\",\n" +
                "                    \"coordinates\":[\n" +
                "                        90.4065113235265,\n" +
                "                        23.795142360927329\n" +
                "                    ]\n" +
                "                },\n" +
                "                \"Provider\":\"Default\"\n" +
                "            },\n" +
                "            \"PackageDescription\":\"Aloooz\",\n" +
                "            \"OrderCart\":{\n" +
                "                \"PackageList\":[\n" +
                "                    {\n" +
                "                        \"Item\":\"Alu\",\n" +
                "                        \"Quantity\":1,\n" +
                "                        \"Price\":10.0,\n" +
                "                        \"VAT\":11.0,\n" +
                "                        \"Total\":10.0,\n" +
                "                        \"VATAmount\":1.10,\n" +
                "                        \"TotalPlusVAT\":11.10,\n" +
                "                        \"Weight\":1.0\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"Item\":\"Alu\",\n" +
                "                        \"Quantity\":1,\n" +
                "                        \"Price\":10,\n" +
                "                        \"VAT\":11,\n" +
                "                        \"Total\":10,\n" +
                "                        \"VATAmount\":1.1,\n" +
                "                        \"TotalPlusVAT\":11.1,\n" +
                "                        \"Weight\":1\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"TotalVATAmount\":1.10,\n" +
                "                \"SubTotal\":11.10,\n" +
                "                \"ServiceCharge\":0.0,\n" +
                "                \"TotalWeight\":1.0,\n" +
                "                \"TotalToPay\":11.10\n" +
                "            },\n" +
                "            \"NoteToDeliveryMan\":\"Falai dio na tailei hobe\",\n" +
                "            \"Name\":\"\",\n" +
                "            \"Type\":\"Delivery\",\n" +
                "            \"PayloadType\":\"default\",\n" +
                "            \"UserId\":\"572745cc5d437156387b186c\",\n" +
                "            \"OrderLocation\":null,\n" +
                "            \"ETA\":null,\n" +
                "            \"ETAMinutes\":2.0,\n" +
                "            \"PaymentMethod\":\"CashOnDelivery\"\n" +
                "        },\n" +
                "        \"User\":{\n" +
                "            \"UserName\":\"ZuumZuum\",\n" +
                "            \"Profile\":null,\n" +
                "            \"Id\":\"572745cc5d437156387b186c\",\n" +
                "            \"Type\":\"ENTERPRISE\",\n" +
                "            \"PhoneNumber\":\"\",\n" +
                "            \"Email\":\"zuumzuum@gmail.com\"\n" +
                "        },\n" +
                "        \"JobServedBy\":null,\n" +
                "        \"Tasks\":[],\n" +
                "        \"State\":\"IN_PROGRESS\",\n" +
                "        \"CreateTime\":\"2016-05-15T10:56:55.801Z\",\n" +
                "        \"ModifiedTime\":\"2016-05-15T10:57:26.293Z\",\n" +
                "        \"PreferredDeliveryTime\":null,\n" +
                "        \"InvoiceId\":null,\n" +
                "        \"PaymentMethod\":\"CashOnDelivery\",\n" +
                "        \"Deleted\":false,\n" +
                "        \"PaymentStatus\":\"Pending\",\n" +
                "        \"HRID\":\"Job-RZHSRR7B\",\n" +
                "        \"Id\":\"573855f707436d6ff0249fe9\"\n" +
                "    }";

        JobModel jobModel = gson.fromJson(json, JobModel.class);

        assertEquals("Delivery Job for ZuumZuum", jobModel.getName());
        assertEquals("IN_PROGRESS", jobModel.getState());
        assertEquals("2016-05-15T10:56:55.801Z", jobModel.getCreateTime());
        assertEquals("2016-05-15T10:57:26.293Z", jobModel.getModifiedTime());
        assertEquals(null, jobModel.getPreferredDeliveryTime());
        assertEquals(null, jobModel.getInvoiceId());
        assertEquals("CashOnDelivery", jobModel.getPaymentMethod());
        assertEquals("Pending", jobModel.getPaymentStatus());
        assertEquals("Job-RZHSRR7B", jobModel.getHRID());
        assertEquals("573855f707436d6ff0249fe9", jobModel.getId());

    }

    @Test
    public void testGetLocation() throws Exception {

    }
}