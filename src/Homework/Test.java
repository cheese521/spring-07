package Homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ѡ���������ݿ�����---�������������䣩
		//��ʽ jdbc:mysql://����ip���˿ں�/���ݿ���
		String url="jdbc:mysql://192.168.227.131:3306/bd1";
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
			pstmt = con.prepareStatement("select * from student");			
			//����sql��䲢�鿴��� ������ɾ�� ������Ӱ������� ���ǲ��ҷ���ֵ
			//���е�ʱ��ע��Ҫ����ɾ�������executeUpdate ���� int �����ѯ �����executeQuery ���� ResultSet
			rs=pstmt.executeQuery();
			//�鿴�����
			while(rs.next()) {
				System.out.println(rs.getInt("id")+" "+rs.getString("name"));
				
			}
			
						
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
