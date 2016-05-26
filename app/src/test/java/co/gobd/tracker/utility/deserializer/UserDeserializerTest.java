package co.gobd.tracker.utility.deserializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import co.gobd.tracker.model.job.Profile;
import co.gobd.tracker.model.job.User;

import static org.junit.Assert.*;

/**
 * Created by fahad on 5/26/2016.
 */
public class UserDeserializerTest {

    private Gson gson;

    @Before
    public void setUp() throws Exception {

        gson = new GsonBuilder()
                .registerTypeAdapter(UserDeserializer.class, new UserDeserializer())
                .create();


    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testDeserialize() throws Exception {

        String json = "{\n" +
                "\n" +
                "    \"UserName\":\"ZuumZuum\",\n" +
                "    \"Profile\":null,\n" +
                "    \"Id\":\"572745cc5d437156387b186c\",\n" +
                "    \"Type\":\"ENTERPRISE\",\n" +
                "    \"PhoneNumber\":\"\",\n" +
                "    \"Email\":\"zuumzuum@gmail.com\"\n" +
                "\n" +
                "}";

        User user = gson.fromJson(json, User.class);

        assertEquals("ZuumZuum", user.getUserName());
        assertEquals(null, user.getProfile());
        assertEquals("572745cc5d437156387b186c", user.getId());
        assertEquals("ENTERPRISE", user.getType());
        assertEquals("", user.getPhoneNumber());
        assertEquals("zuumzuum@gmail.com", user.getEmail());

    }
}