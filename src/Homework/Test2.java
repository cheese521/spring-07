package Homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//选择哪种数据库种类---加载驱动（反射）
		//格式 jdbc:mysql://主机ip：端口号/数据库名
		String url="jdbc:mysql://192.168.227.131:3306/bd1?useUnicode=true&characterEncoding=utf8";
		String user="root";
		String password="521125";
		Connection con =null;
		PreparedStatement pstmt =null;
		ResultSet rs=null;		
		try {
			//选择哪种数据库种类---加载驱动（反射）
			Class.forName("com.mysql.jdbc.Driver");
			//创建连接 IP 端口号 账号 密码 选择要操作的数据库
			con = DriverManager.getConnection(url, user, password);			
			//创建命令窗口（写sql语句）
			pstmt = con.prepareStatement("insert into student(name,b_id,gerden) values(?,?,?)");
			//注入参数
			pstmt.setString(1, "中华田园犬");
			pstmt.setInt(2, 2);
			pstmt.setInt(3, 1);
			//执行语句
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
