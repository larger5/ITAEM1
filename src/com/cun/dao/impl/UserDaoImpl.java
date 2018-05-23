package com.cun.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cun.dao.UserDao;
import com.cun.entity.User;

/**
 * User 数据库层实现类
 * @author linhongcun
 *
 */
public class UserDaoImpl implements UserDao {

    /**
     * 连接
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
                // ?useUnicode=true&characterEncoding=utf-8解决中文乱码
                "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8", "root", "123");
        return conn;
    }

    /**
     * 断开
     * @param stat
     * @param conn
     * @throws SQLException
     */
    void close(PreparedStatement stat, Connection conn) throws SQLException {
        stat.close();
        conn.close();
    }
	

	@Override
	public User getUserById(Integer id) {
		
		
        String sql = "select * from t_user where id=?";
        User user=new User();
        Connection conn = null;
        PreparedStatement stat=null;
		try {
			conn = getConnection();
	        stat = conn.prepareStatement(sql);
	        stat.setInt(1, id);
	        ResultSet rs = stat.executeQuery();
	        
	        while (rs.next()) {
	        	user.setId(Integer.valueOf(rs.getString("id")));
	        	user.setUser_name(rs.getString("user_name"));
	        	user.setPassword(rs.getString("password"));
	        }
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			close(stat, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
