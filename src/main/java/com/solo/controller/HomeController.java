package com.solo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.solo.dto.ResponseDTO;
import com.solo.dto.ResultDTO;
import com.solo.mapper.DataMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {
  
  private final DataMapper dataMapper;

  @GetMapping("/")
  public String home() {
    return "index";
  }

  @ResponseBody
  @GetMapping(value = "/data", produces = "application/json")
  public ResponseDTO data() {
    List<ResultDTO> users = dataMapper.findAllUser();
    List<ResultDTO> files = dataMapper.findAllFile();
    Map<String, List<ResultDTO>> result = Map.of("users", users, "files", files);
    boolean status = true;
    return ResponseDTO.builder()
      .status(status)
      .result(result)
      .build();
  }

}
