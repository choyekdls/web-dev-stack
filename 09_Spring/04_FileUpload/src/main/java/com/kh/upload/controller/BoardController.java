package com.kh.upload.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.kh.upload.Service.BoardService;
import com.kh.upload.dto.BoardDTO;
import com.kh.upload.vo.Board;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;

	private final CustomerController customerController;

	BoardController(CustomerController customerController) {
		this.customerController = customerController;
	}

	// @requestMapping으로 해도 되나?
	@GetMapping("/index")
	public String index() {
		return "index";
	}

	public String fileUpload(MultipartFile file) {
		
		// 중복 방지를 위한 UUID 적용
		UUID uuid = UUID.randomUUID();
		String fileName = uuid.toString() + "_" + file.getOriginalFilename();

		File copyFile = new File("\\\\192.168.0.35\\upload\\" + fileName);

		try {
			file.transferTo(copyFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return fileName;
	}

	@PostMapping("/upload")
	public String upload(MultipartFile file) {
		System.out.println("파일 이름 : " + file.getOriginalFilename());
		System.out.println("파일 사이즈 : " + file.getSize());
		System.out.println("파일 파라미터명 : " + file.getName());

		String fileName = fileUpload(file);
		//http://localhost:8081/ + fileName <- url

		return "redirect:/";
	}

	// 파라미터 List<MultipartFile>로
	@PostMapping("multiUpload")
	public String multiUpload(List<MultipartFile> files) {

		// 마..쉽지 않네..
		for (MultipartFile file : files) {
			String fileName = fileUpload(file);
		}

		return "redirect:/";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<BoardDTO> list = service.allBoard();
		model.addAttribute("list", list);
		return "/list";
	}
	
	// @PostMapping("/write)
//	public String write(String title, String content, MultipartFile file) {
//		return "redirect:/list";
//	}
	
	@PostMapping("/write")
	public String uploadBoard(BoardDTO dto) {
		
		// 이미지 업로드 추가
		String url = fileUpload(dto.getFile());
				
		// board 테이블에 데이터 추가
		Board board = new Board();
		board.setTitle(dto.getTitle());
		board.setContent(dto.getContent());
		board.setUrl(url);
		System.out.println(board.getTitle());
		System.out.println(board.getContent());
		System.out.println(board.getUrl());
		service.uploadBoard(board);
		
		System.out.println(board);
		
	    return "redirect:/view?no=" + board.getNo();
	}
	
	// a링크 눌렀을 때 내용 보이게
	
	@GetMapping("/view")
	// 데이터 보여줘야지~ 한다면 Model을 씁시다..항상 모델에 담아주는 것이에요
	public String select(int no, Model model) {
		
		Board board = service.select(no);
		model.addAttribute("board", board);
		return "/view";
		
	}
	
	// 게시글 수정
	
	// 게시글 삭제
	

	
	
	

}
