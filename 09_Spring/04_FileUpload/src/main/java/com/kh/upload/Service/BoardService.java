package com.kh.upload.Service;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.upload.dto.BoardDTO;
import com.kh.upload.mapper.BoardMapper;
import com.kh.upload.vo.Board;

@Service
public class BoardService {

	@Autowired
	private BoardMapper mapper;

	public void uploadBoard(Board board) {
		mapper.uploadBoard(board);
		
	}

	public List<BoardDTO> allBoard() {
		List<Board> list = mapper.allBoard();
		List<BoardDTO> dtoList = new ArrayList<BoardDTO>();
		for(Board b : list) {
			BoardDTO dto = new BoardDTO();
			dto.setNo(b.getNo());
			dto.setTitle(b.getTitle());
			Date formatDate = Date.from(b.getCreatedAt().atZone(ZoneId.systemDefault()).toInstant());
			dto.setFormatDate(formatDate);
			dtoList.add(dto);
			//dto 다시 dtoList에 담아주기
		}
		return dtoList;
	}

	public Board select(int no) {
		
		return mapper.select(no);
	}

	public void updateBoard(Board board) {
		mapper.updateBoard(board);
		
	}

	public void deleteBoard(int no) {
		mapper.deleteBoard(no);
		
	}
	
}
