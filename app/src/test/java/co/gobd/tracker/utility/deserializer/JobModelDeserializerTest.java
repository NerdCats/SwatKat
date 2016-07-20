package co.gobd.tracker.utility.deserializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.gobd.tracker.model.job.JobModel;

import static org.junit.Assert.*;

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

        String json = "{\n" +
                "\"Assets\":{\n" +
                "\"57660709b477aa9971d80425\":{\n" +
                "\"AverageRating\":0.0,\n" +
                "\"UserName\":\"enam\",\n" +
                "\"Profile\":{\n" +
                "\"NationalId\":\"\",\n" +
                "\"DriversLicenseId\":\"\",\n" +
                "\"Vehicle\":null,\n" +
                "\"FirstName\":\"Enam\",\n" +
                "\"LastName\":\"Mohammed\",\n" +
                "\"Age\":24,\n" +
                "\"Gender\":\"MALE\",\n" +
                "\"InterestedLocalities\":null,\n" +
                "\"Address\":null,\n" +
                "\"PicUri\":\"https://cdn4.iconfinder.com/data/icons/eldorado-user/40/user-128.png\"\n" +
                "},\n" +
                "\"Id\":\"57660709b477aa9971d80425\",\n" +
                "\"Type\":\"BIKE_MESSENGER\",\n" +
                "\"PhoneNumber\":\"+8801712422524\",\n" +
                "\"Email\":\"enam@gobd.co\"\n" +
                "}\n" +
                "},\n" +
                "\"Name\":\"Delivery Job for ZuumZuum\",\n" +
                "\"Order\":{\n" +
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
                "},\n" +
                "\"User\":{\n" +
                "\"UserName\":\"ZuumZuum\",\n" +
                "\"Profile\":null,\n" +
                "\"Id\":\"5766070ab477aa9971d80429\",\n" +
                "\"Type\":\"ENTERPRISE\",\n" +
                "\"PhoneNumber\":\"+8801911725897\",\n" +
                "\"Email\":\"zuumzuum@gmail.com\"\n" +
                "},\n" +
                "\"JobServedBy\":null,\n" +
                "\"Tasks\":[\n" +
                "{\n" +
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
                "\"id\":\"ac7efb7d-f716-43c2-b279-18c3fcf3ed45\",\n" +
                "\"Type\":\"FetchDeliveryMan\",\n" +
                "\"JobTaskStateString\":\" is completed\",\n" +
                "\"State\":\"COMPLETED\",\n" +
                "\"AssetRef\":\"57660709b477aa9971d80425\",\n" +
                "\"CreateTime\":\"2016-07-19T05:40:26.233Z\",\n" +
                "\"ModifiedTime\":\"2016-07-19T05:42:42.232Z\",\n" +
                "\"CompletionTime\":null,\n" +
                "\"IsReadytoMoveToNextTask\":true,\n" +
                "\"IsDependencySatisfied\":false,\n" +
                "\"IsStartingTask\":true,\n" +
                "\"IsTerminatingTask\":false,\n" +
                "\"ETAFailed\":false\n" +
                "},\n" +
                "{\n" +
                "\"AssetLocation\":null,\n" +
                "\"PickupLocation\":{\n" +
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
                "\"id\":\"01ae7e45-7e0d-45a0-a8ee-86851b4c59a2\",\n" +
                "\"Type\":\"PackagePickUp\",\n" +
                "\"JobTaskStateString\":\" is in progress\",\n" +
                "\"State\":\"IN_PROGRESS\",\n" +
                "\"AssetRef\":\"57660709b477aa9971d80425\",\n" +
                "\"CreateTime\":\"2016-07-19T05:40:26.233Z\",\n" +
                "\"ModifiedTime\":\"2016-07-19T05:40:26.233Z\",\n" +
                "\"CompletionTime\":null,\n" +
                "\"IsReadytoMoveToNextTask\":false,\n" +
                "\"IsDependencySatisfied\":true,\n" +
                "\"IsStartingTask\":false,\n" +
                "\"IsTerminatingTask\":false,\n" +
                "\"ETAFailed\":false\n" +
                "},\n" +
                "{\n" +
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
                "\"id\":\"f1198658-ddd8-4733-a5c6-1e1fd56a5c3d\",\n" +
                "\"Type\":\"Delivery\",\n" +
                "\"JobTaskStateString\":\" is pending\",\n" +
                "\"State\":\"PENDING\",\n" +
                "\"AssetRef\":null,\n" +
                "\"CreateTime\":\"2016-07-19T05:40:26.233Z\",\n" +
                "\"ModifiedTime\":\"2016-07-19T05:40:26.233Z\",\n" +
                "\"CompletionTime\":null,\n" +
                "\"IsReadytoMoveToNextTask\":false,\n" +
                "\"IsDependencySatisfied\":true,\n" +
                "\"IsStartingTask\":false,\n" +
                "\"IsTerminatingTask\":true,\n" +
                "\"ETAFailed\":false\n" +
                "}\n" +
                "],\n" +
                "\"State\":\"IN_PROGRESS\",\n" +
                "\"CreateTime\":\"2016-07-19T05:40:26.233Z\",\n" +
                "\"ModifiedTime\":\"2016-07-19T05:42:42.232Z\",\n" +
                "\"PreferredDeliveryTime\":null,\n" +
                "\"InvoiceId\":null,\n" +
                "\"PaymentMethod\":\"CashOnDelivery\",\n" +
                "\"Deleted\":false,\n" +
                "\"PaymentStatus\":\"Pending\",\n" +
                "\"HRID\":\"Job-W3IM4IMY\",\n" +
                "\"Id\":\"578dbd4a85e54d1ae0953147\"}";

        JobModel jobModel = gson.fromJson(json, JobModel.class);

        assertEquals("Delivery Job for ZuumZuum", jobModel.getName());
        assertEquals(null, jobModel.getJobServedBy());
        assertEquals("IN_PROGRESS", jobModel.getState());
        assertEquals("2016-05-15T10:56:55.801Z", jobModel.getCreateTime());
        assertEquals("2016-05-15T10:57:26.293Z", jobModel.getModifiedTime());
        assertEquals(null, jobModel.getPreferredDeliveryTime());
        assertEquals(null, jobModel.getInvoiceId());
        assertEquals("CashOnDelivery", jobModel.getPaymentMethod());
        assertEquals(false, jobModel.getDeleted());
        assertEquals("Pending", jobModel.getPaymentStatus());
        assertEquals("Job-RZHSRR7B", jobModel.getHRID());
        assertEquals("573855f707436d6ff0249fe9", jobModel.getId());

    }

    @Test
    public void testGetLocation() throws Exception {

    }
}