package com.kh.upload.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.upload.dto.PagingDTO;
import com.kh.upload.vo.Board;

@Mapper
public interface BoardMapper {
	void uploadBoard(Board board);
	List<Board> allBoard(PagingDTO paging);
	int total(String keyword);
	Board select(int no);
	void updateBoard(Board board);
	void deleteBoard(int no);

}
