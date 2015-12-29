

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class MailConnect {
	
	public Collection getMails(String uname)
	{
		try{
			
			Connection con=DriverConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select fromid,subject,sentdate from mails"
					+ " where uname='"+uname+"'");
			ArrayList al=new ArrayList();
			int count=1;
			while(rs.next())
			{
				Mail m=new Mail();
				m.setMailid(count+"");
				m.setFromid(rs.getString(1));
				m.setSubject(rs.getString(2));
				m.setSentDate(rs.getString(3));
				al.add(m);
				count++;
				
			}
			return al;
		}
		catch(Exception e)
		{
			
		}
		return null;
	}
	public Mail getMail(String uname,String id)
	{
		try{
			
			Connection con=DriverConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select fromid, subject, sentdate, content from "
					+ "mails where uname='"+uname+"' and mid="+id);
			if(rs.next())
			{
				Mail m=new Mail();
				m.setFromid(rs.getString(1));
				m.setSubject(rs.getString(2));
				m.setSentDate(rs.getString(3));
				m.setContent(rs.getString(4));
				return m;
			}
		}
		catch(Exception e)
		{
			return null;
			
		}
		return null;
	}

}
