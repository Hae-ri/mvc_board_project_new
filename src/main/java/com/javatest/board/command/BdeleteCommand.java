package com.javatest.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatest.board.dao.BDao;
import com.javatest.board.dto.BDto;

public class BdeleteCommand implements BCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String bId = request.getParameter("bid");
		
		BDao dao = new BDao();
		dao.delete(bId);
	}

}
