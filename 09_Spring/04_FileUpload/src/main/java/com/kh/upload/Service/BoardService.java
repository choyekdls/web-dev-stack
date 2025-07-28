package com.kh.upload.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.upload.mapper.BoardMapper;
import com.kh.upload.vo.Board;

@Service
public class BoardService implements BoardMapper {

	@Autowired
	private BoardMapper mapper;

	@Override
	public void uploadBoard(Board board) {
		mapper.uploadBoard(board);
		
	}

	@Override
	public List<Board> allBoard() {
		
		return mapper.allBoard();
	}

	@Override
	public Board select(int no) {
		
		return mapper.select(no);
	}

	@Override
	public void updateBoard(Board board) {
		mapper.updateBoard(board);
		
	}

	@Override
	public void deleteBoard(int no) {
		mapper.deleteBoard(no);
		
	}
	
}
