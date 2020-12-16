package com.example.practice.robot;

import com.example.practice.common.CommonControllerTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import static org.springframework.restdocs.headers.HeaderDocumentation.*;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.linkWithRel;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.links;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class RobotControllerTest extends CommonControllerTest {

    @Test
    @DisplayName("로봇 생성 성공 테스트")
    public void createRobot_Success_Test() throws Exception {
        Robot robot = Robot.builder()
                .id(1L)
                .age(132)
                .name("RobotV")
                .build();

        mockMvc.perform(post("/api/robots")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .accept(MediaTypes.HAL_JSON)
                    .content(objectMapper.writeValueAsString(robot)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("id").exists())
                .andExpect(jsonPath("age").exists())
                .andExpect(jsonPath("name").exists())
                .andExpect(jsonPath("_links.self").exists())
                .andExpect(jsonPath("_links.detail").exists())
                .andExpect(jsonPath("_links.update-robot").exists())
                .andDo(document("create-robot",
                        links(
                                linkWithRel("self").description("link to self"),
                                linkWithRel("detail").description("link to robot detail information"),
                                linkWithRel("update-robot").description("link to update robot")
                        ),
                        requestHeaders(
                                headerWithName(HttpHeaders.ACCEPT).description("accept header"),
                                headerWithName(HttpHeaders.CONTENT_TYPE).description("content type header")
                        ),
                        requestFields(
                                fieldWithPath("id").description("id of new robot"),
                                fieldWithPath("name").description("name of new robot"),
                                fieldWithPath("age").description("age of new robot")
                        ),
                        responseHeaders(
                                headerWithName(HttpHeaders.LOCATION).description("location"),
                                headerWithName(HttpHeaders.CONTENT_TYPE).description("content type herder")
                        ),
                        responseFields(
                                fieldWithPath("id").description("id of new robot"),
                                fieldWithPath("name").description("name of new robot"),
                                fieldWithPath("age").description("age of new robot"),
                                fieldWithPath("_links.self.href").description("link to self"),
                                fieldWithPath("_links.update-robot.href").description("link to update robot"),
                                fieldWithPath("_links.detail.href").description("link to robot detail information")
                        )
                ));
    }

    @Test
    @DisplayName("robot 단건 조회 테스트")
    void queryRobot_success_test() throws Exception {
        final String url = "/api/robots/1";

        mockMvc.perform(get(url)
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .accept(MediaTypes.HAL_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").exists())
                .andExpect(jsonPath("name").exists())
                .andExpect(jsonPath("age").exists())
                .andExpect(jsonPath("_links.self").exists())
                .andExpect(jsonPath("_links.create-robot").exists())
                .andExpect(jsonPath("_links.update-robot").exists());
    }
}