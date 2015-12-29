

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname=request.getParameter("uname");
		String pass=request.getParameter("password");
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><head><title>loginVerify</title></head><body>");
		if(uname==null||uname.equals(""))
		{
			out.println("<b><i>UserName Cannot be empty</i></b>");
			RequestDispatcher rd=request.getRequestDispatcher("/Login.html");
			rd.include(request, response);
			return;
		}
		if(pass==null||pass.equals(""))
		{
			out.println("<b><i>Password Cannot be empty</i></b>");
			RequestDispatcher rd=request.getRequestDispatcher("/Login.html");
			rd.include(request, response);
			return;
		}
		UserVerify uv=new UserVerify();
		if(uv.validate(uname, pass))
		{
			out.println("<table width=98% height=95 border=1><tr>"
					+ "<td height=45 colspan=2 align=center><font size=5>My kmail</font></td>"
					+ "</tr><tr>"
					+ "<td width=12% height=545 align=center valign=top><p>&nbsp;</p><p><font size=4>"
					+ "<a href='inbox?uname="+uname+"'>Inbox</a>"
					+ "</font></p><p><font size=4>Bulk Mail</font></p>"
					+ "<p><font size=4>Sent Items</font></p>"
					+ "<p><font size=4>Write Mail</font></p>"
					+ "<p><font size=4>"
					+ "<a href='Login.html'>Logout</a></font></p>"
					+ "<p>&nbsp;</p></td>"
					+ "<td width=88% align=left valign=top><p>&nbsp;</p>"
					+ "<p><font size=4>Welcome, "+uname+"</font></p></td></tr>"
					+ "<tr align=center>"
					+ "<td colspan=2><div align=center>@copyrights 2015-2016</div></td>"
					+ "</tr></table>");
			
		}
		else{
			
			out.println("<b><i>UserName or password given are not valid</i></b>");
			RequestDispatcher rd=request.getRequestDispatcher("/Login.html");
			rd.include(request, response);
			return;
		}
		out.println("</body></html>");
		out.flush();
		out.close();
	}

}
