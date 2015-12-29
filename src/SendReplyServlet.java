

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendReplyServlet
 */
//@WebServlet("/sendReply")
public class SendReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendReplyServlet() {
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
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String uname=request.getParameter("uname");
		String fromid=request.getParameter("fromid");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		
		out.println("<html><head><title>View Mail Page</title></head>"
				+ "<body><table width=98% height=95% border=1><tr>"
				+ "<td height=45 colspan=2 align=center><font size=5>My kmail Site</font></td>"
				+ "</tr><tr><td width=12% height=545 align=center valign=top>"
				+ "<p>&nbsp;</p><p><font size=4>"
				+ "<a href='inbox?uname="+uname+"'>Inbox</a><font></p></td>"
				+ "</font></p><p><font size=4>Bulk Mail</font></p>"
				+ "<p><font size=4>Sent Items</font></p>"
				+ "<p><font size=4>Write Mail</font></p>"
				+ "<p><font size=4>"
				+ "<a href='Login.html'>Logout</a></font></p>"
				+ "<p>&nbsp;</p></td>"
				+ "<td width=88% align=left valign=top><p><font size=4>Welcome,"+uname+"</font></p>"
				+ "<form name=form1 method=post action=/send.html>"
				+ "<table width=100% height=100% border=0 cellpadding=0 cellspacing=0>"
				+ "<tr bgcolor=#CCCCCC><th height=34 colspan=2 bgcolor=#CCCCCC>ReadMail</th></tr>"
				+ "<tr bgcolor=#CCCCCC><td width=15% height=38 bgcolor=#FFFFFF>To :</td>"
				+ "<td width=85%  bgcolor=#FFFFFF>"
				+ "<input type=text name=to id=to value="+fromid+"></td></tr>"
				+ "<tr bgcolor=#CCCCCC><td height=35 bgcolor=#FFFFFF>Subject :</td>"
				+ "<td bgcolor=#FFFFFF><strong>"
				+ "<input name=subject id=subject value='Re:"+subject+"' type=text></strong></td></tr>"
				+ "<tr bgcolor=#FFFFFF><td height=35 bgcolor=#FFFFFF>"
				+ "<strong>Message:</strong></td>"
				+ "<td bgcolor=#FFFFFF>&nbsp;</td></tr>"
				+ "<tr align=left valign=top bgcolor=#CCCCCC><td colspan=2 bgcolor=#FFFFFF>"
				+ "<textarea name=content cols=100 rows=20 id=content>"+content+"</textarea></td></tr>"
				+ "<tr bgcolor=#CCCCCC><td height=35 bgcolor=#FFFFFF>"
				+ "<input type=submit value=Send></td></tr>"
				+ "</table></form></td></tr>"
				+ "<tr align=center><td colspan=2><div align=center>@Copyrights 2015-16</div></td></tr>"
				+ "</table></body></html>");
	}

}
