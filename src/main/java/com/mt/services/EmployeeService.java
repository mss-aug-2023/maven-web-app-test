package com.mt.services;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/employee")
public class EmployeeService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/getEmployeeDetails", method = RequestMethod.GET)
    @ResponseBody
    String getEmployee(HttpServletRequest request,
                       HttpServletResponse response,
                       HttpSession session) {

        List<Map<String, Object>> employees =
                jdbcTemplate.queryForList("SELECT * FROM Employee");

        JSONObject js = new JSONObject();
        js.put("data", employees);

        return js.toString();
    }
}
