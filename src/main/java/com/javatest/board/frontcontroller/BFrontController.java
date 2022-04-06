package com.javatest.board.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatest.board.command.*;

/**
 * Servlet implementation class BFrontController
 */
@WebServlet("*.do") // .do�� ������ �ּҸ� ��� �����´�.
public class BFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public BFrontController() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request,response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String viewPage = null;
		BCommand command = null;
		
		String uri = request.getRequestURI(); // ��ü �ּ� (http://localhost:8888/mvc_board_project/write.do)
		String conPath = request.getContextPath(); // context �ּ� (http://localhost:8888/mvc_board_project)
		String com = uri.substring(conPath.length()); // ���� �̵��� �ּ�(/*.do) = ��ü �ּ� - context �ּ�
		
		if(com.equals("/write_view.do")) {
			viewPage = "write_view.jsp";
		} else if(com.equals("/write.do")) {
			command = new BWriteCommand(); 
			command.excute(request, response);
			viewPage = "list.do";
		} else if(com.equals("/list.do")) {
			command = new BListCommand(); 
			command.excute(request, response);
			viewPage = "list.jsp";
			//response.sendRedirect(viewPage); // ������ request ��ü�� ������ ������� ����
		} else if(com.equals("/content_view.do")) {
			command = new BContentCommand(); 
			command.excute(request, response);
			viewPage = "content_view.jsp";
		}
		else if(com.equals("/modify.do")) {
			command = new BModifyCommand(); 
			command.excute(request, response);
			viewPage = "list.do";
		}
		else if(com.equals("/delete.do")) {
			command = new BdeleteCommand(); 
			command.excute(request, response);
			viewPage = "list.do";
		}else if(com.equals("/reply_view.do")) {
			command = new BReplyViewCommand(); 
			command.excute(request, response);
			viewPage = "reply_view.jsp";
		}
		
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		// ���� request ��ü�� �μ��� �־ forward�ϹǷ� ���� request ��ü�� ������ ����� �� ����
	}
}
