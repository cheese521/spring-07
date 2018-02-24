package Homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//选择哪种数据库种类---加载驱动（反射）
		//格式 jdbc:mysql://主机ip：端口号/数据库名
		String url="jdbc:mysql://192.168.227.131:3306/bd1";
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
			pstmt = con.prepareStatement("select * from student");			
			//运行sql语句并查看结果 若是增删改 返回受影响的行数 若是查找返回值
			//运行的时候注意要是增删改则调用executeUpdate 返回 int 如果查询 则调用executeQuery 返回 ResultSet
			rs=pstmt.executeQuery();
			//查看结果集
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
