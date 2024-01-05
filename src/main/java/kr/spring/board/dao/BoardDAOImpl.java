package kr.spring.board.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.spring.board.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{
	private static final String INSERT_SQL = "INSERT INTO aboard (num,writer,title,passwd,content,reg_date) VALUES (aboard_seq.nextval,?,?,?,?,SYSDATE)";
	
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insertBoard(BoardVO board) {
		//update = insert,delete,update 셋다 처리함
		jdbcTemplate.update(INSERT_SQL, 
				new Object[] {board.getWriter(),board.getTitle(),board.getPasswd(),board.getContent()}); //상수, ?에 전달할 데이터 (object배열로 생성)
	}

	@Override
	public int getBoardCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardVO> getBoardList(int startRow, int endRow) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardVO getBoard(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBoard(BoardVO board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBoard(int num) {
		// TODO Auto-generated method stub
		
	}

}
