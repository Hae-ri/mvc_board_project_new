package com.javatest.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatest.board.dao.BDao;

public class BReplyCommand implements BCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String bId = request.getParameter("bid");
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String bGroup = request.getParameter("bgroup");
		String bStep = request.getParameter("bstep");
		String bIndent = request.getParameter("bindent");
		
		BDao dao = new BDao();
		dao.reply(bId,bname,btitle,bcontent,bGroup,bStep,bIndent);
	}

}