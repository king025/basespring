package global.ntt.legstar.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import global.ntt.legstar.controllers.LegstarController;
import global.ntt.legstar.controllers.LegstarControllerAdvice;
import global.ntt.legstar.exceptions.ProcessException;
import global.ntt.legstar.models.InquireRmRequest;
import global.ntt.legstar.models.InquireRmResponse;
import global.ntt.legstar.services.RmService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@ExtendWith(MockitoExtension.class)
public class LegstarControllerTest {
    private MockMvc mockMvc;
    @Mock
    RmService rmService;

    @BeforeEach
    void setUp() {
        rmService = mock(RmService.class);
        LegstarController legstarController = new LegstarController(rmService);
        mockMvc = standaloneSetup(legstarController)
                .setControllerAdvice(new LegstarControllerAdvice())
                .build();
    }

    @Test
    public void inquireRmTrailer() throws Exception {
        InquireRmRequest inquireRmRequest = new InquireRmRequest();

        when(rmService.inquireRmTrailer(inquireRmRequest)).thenReturn(InquireRmResponse.builder()
                .accountControl1("123").build());


        mockMvc.perform(MockMvcRequestBuilders
                        .post("/rm/inquire")
                        .headers(new HttpHeaders())
                        .content(asJsonString(inquireRmRequest))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Test
    public void inquireRmTrailer_process_exception() throws Exception {
        InquireRmRequest inquireRmRequest = new InquireRmRequest();

        when(rmService.inquireRmTrailer(inquireRmRequest)).thenThrow(new ProcessException("Process Exception"));


        mockMvc.perform(MockMvcRequestBuilders
                        .post("/rm/inquire")
                        .headers(new HttpHeaders())
                        .content(asJsonString(inquireRmRequest))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnprocessableEntity());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
