package com.kh.mybatis.mapper;
/*
 * 기존의 DAO 역할을 합니다
 * */

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.mybatis.model.dto.SearchDTO;
import com.kh.mybatis.model.vo.Member;

@Mapper
public interface MemberMapper {
    void register(Member vo); // 받은 값을 DB에
    Member login(Member vo);
    List<Member> search(SearchDTO dto);
    List<Member> allMember();
    void update(Member vo);
    void delete(String id);
}
