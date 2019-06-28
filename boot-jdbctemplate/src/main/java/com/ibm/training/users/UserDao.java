package com.ibm.training.users;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ibm.training.bean.User;

@Repository
public class UserDao {
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	public User getUser(int userId) {
		String sql = "select * from userDetails where userId = :uId";
		SqlParameterSource parameterSource = new MapSqlParameterSource("uId", userId);
		
		return namedParameterJdbcTemplate.queryForObject(sql, parameterSource, new UserMapper());
	}
	
	class UserMapper implements RowMapper<User>{

		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setUserName(rs.getString("userName"));
			user.setUserId(rs.getInt("userId"));
			user.setUserAddress(rs.getString("userAddress"));
			user.setPhoneNumber(rs.getInt("phoneNumber"));
			user.setBranchId(rs.getInt("branchId"));
			return user;
		}
		
	}

	public List<User> getUsers() {
		String sql = "select * from userDetails";
		return namedParameterJdbcTemplate.query(sql, new UserMapper());
	}

	public void insertUser(User user) {
		String sql = "insert into userDetails values(:uId,:uName,:uAddress,:phoneNumber,:branchId)";
		SqlParameterSource parameterSource = new MapSqlParameterSource("uId", user.getUserId())
				.addValue("uName", user.getUserName()).addValue("uAddress", user.getUserAddress())
				.addValue("phoneNumber", user.getPhoneNumber()).addValue("branchId", user.getBranchId());
		namedParameterJdbcTemplate.update(sql, parameterSource);
		
	}

	public void updateUser(User user, Integer id) {
		String sql = "update userDetails set userName = :uName where userId = :uId";
		SqlParameterSource parameterSource = new MapSqlParameterSource("uId", user.getUserId())
				.addValue("uName", user.getUserName());
		namedParameterJdbcTemplate.update(sql, parameterSource);
		
	}

	public void deleteUser(Integer id) {
		String sql = "delete from userDetails where userId = :uId";
		SqlParameterSource parameterSource = new MapSqlParameterSource("uId", id);
		namedParameterJdbcTemplate.update(sql, parameterSource);
		
	}

}
