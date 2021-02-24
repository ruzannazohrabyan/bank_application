package com.bank.transaction.bank_application.controller;

import com.bank.transaction.bank_application.model.Role;
import com.bank.transaction.bank_application.repository.RoleRepository;
import com.bank.transaction.bank_application.repository.UserRepository;
import com.bank.transaction.bank_application.service.impl.RoleServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.internal.junit.JUnitRule;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
public class RoleController {


    @InjectMocks
    RoleController roleController;

    @MockBean
    RoleServiceImpl roleServiceImpl;

    private MockMvc mockMvc;

    @Test
    public void saveTest() throws Exception {
//        MockHttpServletRequest request = new MockHttpServletRequest();
//        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Role givenRole = new Role(3, "OPERATOR");
        String expectedRole = "{\"id\": 3,\"roleName\":\"OPERATOR\"}";

        Mockito.when(roleServiceImpl.save(Mockito.any(Role.class))).thenReturn(givenRole);
        //Role response =
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/role")
                .accept(MediaType.APPLICATION_JSON)
                .content(expectedRole)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        Assert.assertEquals(HttpStatus.OK, response.getStatus());
        Assert.assertEquals("/localhost:8084/api/role", response.getHeader(HttpHeaders.LOCATION));
    }

    @Test
    public void getAllRolesTest() {
        Role role1 = new Role(1, "ADMIN");
        Role role2 = new Role(2, "USER");
        Role roles = new Role();

    }

}
