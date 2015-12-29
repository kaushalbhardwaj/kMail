

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class InboxServlet
 */
//@WebServlet("inbox")
public class InboxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InboxServlet() {
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
		out.println("<html><head><title>Inbox Page</title></head>"
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
				+ "<tr bgcolor=#CCCCCC><th width=8%>&nbsp;</th>"
				+ "<th width=26% align=center>From</th>"
				+ "<th width=41%>Subject</th>"
				+ "<th width=25%>Sent Date</th></tr>");
		
		MailConnect mc=new MailConnect();
		Collection c=mc.getMails(uname);
		Iterator i=c.iterator();
		while(i.hasNext())
		{
			Mail m=(Mail)i.next();
			out.println("<tr><td align=center><input type=checkbox name=checkbox></td>"
					+ "<td align=left>"+m.getFromid()+"</td>"
					+ "<td><a href='viewMail?id="+m.getMailid()+"&uname="+uname+"'>"+m.getSubject()
					+ "</a></td>"
					+ "<td>"+m.getSentDate()+"</a></td>"
					+ "<td>"+m.getSentDate()+"</td></tr>");

		}
		out.println("</table><p><font size=4></font></p>"
				+ "</td></tr><tr align=center>"
				+ "<td colspan=2><div align=center>@Copyrights 2015-16</div></td>"
				+ "</tr></table>");
		out.println("</body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
