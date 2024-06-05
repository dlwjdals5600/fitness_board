package com.fitness.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fitness.board.dto.CommentDto;
import com.fitness.board.service.CommentService;

import jakarta.servlet.http.HttpSession;

@Controller
@ResponseBody
public class CommentController {
	@Autowired
	CommentService service;
	
	@PatchMapping("/comments/{cno}")
	public ResponseEntity<String> modify(@PathVariable("cno") Integer cno, @RequestBody CommentDto dto, HttpSession session){
		String commenter = (String)session.getAttribute("loginId");
		dto.setCommenter(commenter);
		dto.setCno(cno);
		
		try {
			if(service.modify(dto)!=1) {
				throw new Exception("Write failed.");
			}
			return new ResponseEntity<>("WRT_OK",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("WRT_ERR",HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/comments")
	public ResponseEntity<String> write(@RequestBody CommentDto dto, @RequestParam("bno") Integer bno, HttpSession session){
		String commenter = (String)session.getAttribute("loginId");
//		String commenter = "ljm";
		dto.setCommenter(commenter);
		dto.setBno(bno);
		
		try {
			if(service.write(dto) != 1) {
				throw new Exception("Write failed.");
			}
			return new ResponseEntity<>("WRT_OK",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("WRT_ERR",HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/comments/{cno}")
	public ResponseEntity<String> remove(@PathVariable("cno") Integer cno, @RequestParam("bno") Integer bno, HttpSession session) {
		String commenter = (String)session.getAttribute("loginId");
		try {
			System.out.println(cno);
			System.out.println(bno);
			System.out.println(commenter);
			int rowCnt = service.remove(cno, bno, commenter);
			
			if(rowCnt != 1) {
				throw new Exception("Delete Failed");
			}
			return new ResponseEntity<>("DEL_OK", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("DEL_ERR", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/comments")
	public List<CommentDto> list(@RequestParam("bno") Integer bno) {
		List<CommentDto> list = null;
		try {
			list = service.getList(bno);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
