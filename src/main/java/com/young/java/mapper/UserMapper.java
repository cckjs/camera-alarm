package com.young.java.mapper;

import java.util.HashMap;
import java.util.List;



public interface UserMapper {

	/**
	 * 添加用户
	 * @param params
	 */
	void insertUser(UserDomain userDomain);
	
	/**
	 * 通过用户id删除用户
	 * @param userId
	 */
	void deleteUserById(String userId);
	
	/**
	 * 修改用户信息
	 * @param userId
	 */
	void updateUserById(UserDomain userDomain);
	
	/**
	 * 通过id查询详细信息
	 * @param i
	 * @return
	 */
	UserDomain queryUserById(String i);
	
	
	/**
	 * 分页查询用户信息
	 * @param userDomain
	 * @return
	 */
	List<UserDomain> queryUserList(HashMap<String,Object> mapParams);

	/**
	 * 通过用户名和密码登录用户
	 * @param user
	 * @return
	 */
	UserDomain loginUser(UserDomain user);
	
	/**
	 * 通过用户ID得到用的角色
	 * @param id
	 * @return
	 */
	int queryUserRoleById(String id);
	/**
	 * 根据项目空间名称获取空间下所以用户信�?
	 * @param mapParams
	 * @return
	 */
	List<UserDomain> queryUserListbySpacrName(HashMap<String, Object> mapParams);
	
}
