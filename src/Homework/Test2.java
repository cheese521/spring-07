package Homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ѡ���������ݿ�����---�������������䣩
		//��ʽ jdbc:mysql://����ip���˿ں�/���ݿ���
		String url="jdbc:mysql://192.168.227.131:3306/bd1?useUnicode=true&characterEncoding=utf8";
		String user="root";
		String password="521125";
		Connection con =null;
		PreparedStatement pstmt =null;
		ResultSet rs=null;		
		try {
			//ѡ���������ݿ�����---�������������䣩
			Class.forName("com.mysql.jdbc.Driver");
			//�������� IP �˿ں� �˺� ���� ѡ��Ҫ���������ݿ�
			con = DriverManager.getConnection(url, user, password);			
			//��������ڣ�дsql��䣩
			pstmt = con.prepareStatement("insert into student(name,b_id,gerden) values(?,?,?)");
			//ע�����
			pstmt.setString(1, "�л���԰Ȯ");
			pstmt.setInt(2, 2);
			pstmt.setInt(3, 1);
			//ִ�����
			int i=pstmt.executeUpdate();
			System.out.println(i);
						
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)
					rs.close();
				if(pstmt!=null)
					pstmt.close();
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
