package co.gobd.tracker.utility.deserializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import co.gobd.tracker.model.job.Profile;

import static org.junit.Assert.*;

/**
 * Created by fahad on 5/26/2016.
 */
public class ProfileDeserializerTest {

    private Gson gson;

    @Before
    public void setUp() throws Exception {

        gson = new GsonBuilder()
                .registerTypeAdapter(ProfileDeserializer.class , new ProfileDeserializer())
                .create();

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testDeserialize() throws Exception{
        String json = "{\n" +
                        "\n" +
                        "    \"NationalId\":null,\n" +
                        "    \"DriversLicenseId\":null,\n" +
                        "    \"Vehicle\":null,\n" +
                        "    \"FirstName\":null,\n" +
                        "    \"LastName\":null,\n" +
                        "    \"Age\":0,\n" +
                        "    \"Gender\":\"MALE\",\n" +
                        "    \"Address\":null,\n" +
                        "    \"PicUri\":null\n" +
                        "\n" +
                    "}";

        Profile profile = gson.fromJson(json, Profile.class);

        assertEquals(null, profile.getNationalId());
        assertEquals(null, profile.getDriversLicenseId());
        assertEquals(null, profile.getVehicle());
        assertEquals(null, profile.getFirstName());
        assertEquals(null, profile.getLastName());
        assertEquals(new Integer(0), profile.getAge());
        assertEquals("MALE", profile.getGender());
        assertEquals(null, profile.getAddress());
        assertEquals(null, profile.getPicUri());
    }
}