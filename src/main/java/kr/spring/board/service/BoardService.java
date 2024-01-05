package kr.spring.board.service;

import java.util.List;

import kr.spring.board.vo.BoardVO;

public interface BoardService {
	public void insertBoard(BoardVO board); //등록
	public int getBoardCount(); //목록 페이지 처리
	public List<BoardVO> getBoardList(int startRow, int endRow); //목록 뿌리기
	public BoardVO getBoard(int num); //표시
	public void updateBoard(BoardVO board); //생성
	public void deleteBoard(int num); //삭제
}
