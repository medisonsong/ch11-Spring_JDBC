package kr.spring.board.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.board.service.BoardService;
import kr.spring.board.vo.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	//로그 처리 (로그 대상 지정)
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	/*
	 * 로그 레벨
	 * FATAL : 가장 심각한 오류
	 * ERROR : 일반적인 오류
	 * WARN : 주의를 요하는 경우
	 * INFO : 런타임 시 관심 있는 내용
	 * DEBUG : 시스템 흐름과 관련된 상세 정보
	 * TRACE : 가장 상세한 정보
	 */
	
	//자바빈(VO) 초기화
	@ModelAttribute
	public BoardVO initCommand() {
		return new BoardVO();
	}
	
	//글쓰기 폼 불러오기
	@GetMapping("/insert.do")
	public String form() {
		return "insertForm";
	}
	
	//유효성 체크
	@PostMapping("/insert.do")
	public String submit(@Valid BoardVO boardVO, BindingResult result) {
		//로그 명시
		log.debug("BoardVO : " + boardVO); // 디버그 형태로 출력 가능
		
		//유효성 체크 결과 오류가 있으면 폼 호출
		if(result.hasErrors()) {
			return form();
		}
		
		//글 등록
		boardService.insertBoard(boardVO);
		
		return "redirect:/list.do";
	}
	
	
	
	//초기화면 불러오기
	@RequestMapping("/list.do")
	public ModelAndView process() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("selectList"); //뷰이름 지정
		
		return mav;
	}
}
