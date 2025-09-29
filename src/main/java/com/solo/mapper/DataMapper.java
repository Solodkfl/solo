package com.solo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.solo.dto.ResultDTO;

@Mapper
public interface DataMapper {
  
  @Select("SELECT cnt FROM auth.v_users")
  public List<ResultDTO> findAllUser();

  @Select("SELECT cnt FROM auth.v_files")
  public List<ResultDTO> findAllFile();

}
