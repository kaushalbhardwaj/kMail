

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewMailServlet
 */
//@WebServlet("/viewMail")
public class ViewMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewMailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("uname");
		String mailno=request.getParameter("id");
		MailConnect mc=new MailConnect();
		Mail m=mc.getMail(uname, mailno);
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
				+ "<table width=100% height=82 border=0 cellpadding=0 cellspacing=0>"
				+ "<tr bgcolor=#CCCCCC><th height=34 colspan=2 bgcolor=#CCCCCC>ReadMail</th></tr>"
				+ "<tr bgcolor=#CCCCCC><td width=37% height=54 bgcolor=#FFFFFF>From ID :"
				+ "<strong>"+m.getFromid()+"</strong></td>"
				+ "<td width=63% height=54 bgcolor=#FFFFFF>Subject :"
				+ "<strong>"+m.getSubject()+"</strong></td>"
				+ "</tr><tr bgcolor=#FFFFFF><td height=36 colspan=2><form method=post action=sendReply>"
				+ "<input type=submit name=submit value=Reply>"
				+ "<input type=hidden name=uname value='"+uname+"'>"
				+ "<input type=hidden name=fromid value='"+m.getFromid()+"'>"
				+ "<input type=hidden name=subject value='"+m.getSubject()+"'>"
				+ "<input type=hidden name=content value='"+m.getContent()+"'>"
						+ "</form></td></tr>"
						+ "<tr valign=top bgcolor=#CCCCCC>"
						+ "<td height=375 colspan=2 bgcolor=#FFFFFF><p><strong>Message</strong>:</p>"
						+ "<blockquote><p>"+m.getContent()+"</p></blockquote></td></tr></table>"
						+ "</td></tr><tr align=center><td colspan=2>"
						+ "<div align=center>@Copyrights 2015-16</div></td></tr>"
						+ "</table></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
