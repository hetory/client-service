package client;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import client.service.RiskEnum;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ClientEndpointTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_return_created_when_risk_a() throws Exception {
    	
        JSONObject clientDto= new JSONObject()
                .put("name", "Hetory")
                .put("limit", BigDecimal.TEN)
                .put("risk", "A");
        
        this.mockMvc.perform(post("/client")
                .contentType(MediaType.APPLICATION_JSON)
                .content(clientDto.toString()))
                .andDo(print())
                .andExpect(jsonPath("$.name", is("Hetory")))
                .andExpect(jsonPath("$.limit", is(10)))
                .andExpect(jsonPath("$.risk", is("A")))
                .andExpect(status().isCreated());
    }
    
    @Test
    public void should_return_created_when_risk_b() throws Exception {

    	
        JSONObject clientDto= new JSONObject()
                .put("name", "Hetory")
                .put("limit", BigDecimal.TEN)
                .put("risk", "B");
        
        this.mockMvc.perform(post("/client")
                .contentType(MediaType.APPLICATION_JSON)
                .content(clientDto.toString()))
                .andDo(print())
                .andExpect(jsonPath("$.name", is("Hetory")))
                .andExpect(jsonPath("$.limit", is(10)))
                .andExpect(jsonPath("$.risk", is("B")))
                .andExpect(status().isCreated());
    }
    
    @Test
    public void should_return_created_when_risk_c() throws Exception {
    	
        JSONObject clientDto= new JSONObject()
                .put("name", "Hetory")
                .put("limit", BigDecimal.TEN)
                .put("risk", "C");
        
        this.mockMvc.perform(post("/client")
                .contentType(MediaType.APPLICATION_JSON)
                .content(clientDto.toString()))
                .andDo(print())
                .andExpect(jsonPath("$.name", is("Hetory")))
                .andExpect(jsonPath("$.limit", is(10)))
                .andExpect(jsonPath("$.risk", is("C")))
                .andExpect(status().isCreated());
    }
    
	@Test
	public void testRiskEnum() {
		assertEquals("A", RiskEnum.A.getRisk());
		assertEquals("B", RiskEnum.B.getRisk());
		assertEquals("C", RiskEnum.C.getRisk());

		assertEquals(BigDecimal.ZERO, RiskEnum.A.getInterestRate());
		assertEquals(BigDecimal.TEN, RiskEnum.B.getInterestRate());
		assertEquals(new BigDecimal(20), RiskEnum.C.getInterestRate());
	}
}