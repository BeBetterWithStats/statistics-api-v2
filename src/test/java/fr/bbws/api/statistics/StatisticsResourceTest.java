package fr.bbws.api.statistics;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.GsonBuilder;

import fr.bbws.api.statistics.model.PlateAppearance;
import fr.bbws.api.statistics.model.Play;
import fr.bbws.api.statistics.model.Position;

public class StatisticsResourceTest {

    private HttpServer server;
    private WebTarget target;
    final static Logger logger = LogManager.getLogger(StatisticsResourceTest.class.getName());
	
    @Before
    public void setUp() throws Exception {
        // start the server
        server = Main.startServer();
        // create the client
        Client c = ClientBuilder.newClient();

        // uncomment the following line if you want to enable
        // support for JSON in the client (you also have to uncomment
        // dependency on jersey-media-json module in pom.xml and Main.startServer())
        // --
        // c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());

        target = c.target(Main.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    /**
     * 
     */
    @Test
    public void testAPI() {
        String response = target.path("api/").request().get(String.class);
        logger.info("[{}] msg = {}", "testAPI", response);
        assertEquals("Welcome to the Be Better With Stats API !", response);
    }

    /**
     * 
     */
    @Test
    public void testGet_http200() {
    	get("/pa/wyQxF2cBPFkMN3KnQlBj", null, null, null, null, "BATCH");
    }
    
    /**
     * 
     */
    @Test
    public void testGet_http404() {
    	Response response = target.path("api/pa/_noexist").request().get();
    	
    	int httpCode = response.getStatus();
        logger.info("[{}] response.status = {}", "testGet_http404", httpCode);
        
        String json = response.readEntity(String.class);
        logger.info("[{}] response.json = {}", "testGet_http404", json);
        assertEquals(404, response.getStatus());
    }
    
    /**
     * 
     */
    @Test
    public void testAdd_http201() {
    	String inJson = "{\"game\":\"2018-09-22T16:00\",\"state\":\"TEST\",\"what\":\"OUT\",\"when\":\"1st\",\"where\":\"LEFT_FIELD\",\"who\":\"DEMO\"}";
    	PlateAppearance in = new GsonBuilder().create().fromJson(inJson, PlateAppearance.class);
    	Response response = target.path("api/pa/").request(MediaType.APPLICATION_JSON).post(Entity.json( in));
    	
    	int httpCode = response.getStatus();
    	logger.info("[{}] response.status = {}", "testAdd", httpCode);
        assertEquals(201, httpCode);
        
        String json = response.readEntity(String.class);
        logger.info("[{}] response.json = {}", "testAdd", json);
        
        PlateAppearance out = new GsonBuilder().create().fromJson( json, PlateAppearance.class);
        get(out.getId(), Position.LEFT_FIELD, Play.OUT, "1st", "DEMO", "TEST");
    }
    
    
    private void get(String p_id, Position p_where, Play p_what, String p_when, String p_who, String p_state) {
    	logger.info("[{}] id = {}", "get", p_id);
        Response response = target.path("api" + p_id).request().get();
        
        int httpCode = response.getStatus();
        logger.info("[{}] response.status = {}", "get", httpCode);
        assertEquals(200, httpCode);
        
        String json = response.readEntity(String.class);
        logger.info("[{}] response.json = {}", "get", json);
        
        PlateAppearance out = new GsonBuilder().create().fromJson( json, PlateAppearance.class);
        if (p_where != null && p_what != null && StringUtils.isNotEmpty(p_when) && StringUtils.isNotEmpty(p_who) && StringUtils.isNotEmpty(p_state)) {
        	assertEquals(p_where, out.getWhere());
        	assertEquals(p_what, out.getWhat());
        	assertEquals(p_when, out.getWhen());
        	assertEquals(p_who, out.getWho());
        	// assertEquals(p_state, out.getState()); // TODO décomenter lorsque le GET de statisticsResource renverra cet élément
        }
    }
}
