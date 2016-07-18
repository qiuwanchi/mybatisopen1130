package com.secoo.mapper;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.secoo.entity.User;

public class UserMapperTest {

	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void setUp() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindUserById() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserById(1);
		System.out.println(user);
		sqlSession.close();
	}
	
	@Test
	public void testFindUserByUserName() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> userList = userMapper.findUserByUserName("小明");
		System.out.println(userList);
		sqlSession.close();
	}
	
	@Test
	public void testFindUserByUserName2() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<Map<String,String>> mapList = userMapper.findUserByUserName2("小明");
		System.out.println(mapList);
		sqlSession.close();
	}
	
	/**
	 * 一级缓存测试
	 * <br/>
	 * @author qiuwanchi<br/>
	 * @date: 2015年12月1日 <br/>
	 */
	@Test
	public void testCache1() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user1 = userMapper.findUserById(1);
		System.out.println(user1);
		
		User user2 = userMapper.findUserById(1);
		System.out.println(user2);
		
		user1.setUserName("qiuwanchi212");
		userMapper.updateUser(user1);
		sqlSession.commit();
		
		User user3 = userMapper.findUserById(1);
		System.out.println(user3);
		sqlSession.close();
	}

	/**
	 * 二级缓存测试
	 * <br/>
	 * @author qiuwanchi<br/>
	 * @date: 2015年12月1日 <br/>
	 */
	@Test
	public void testCache2() {
		SqlSession sqlSession1 = sqlSessionFactory.openSession();
		SqlSession sqlSession2 = sqlSessionFactory.openSession();
		SqlSession sqlSession3 = sqlSessionFactory.openSession();
		
		UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
		User user1 = userMapper1.findUserById(1);
		System.out.println(user1);
		sqlSession1.close();
		
		/*UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);
		User user3 = userMapper3.findUserById(1);
		user3.setUserName("邱迟生");
		userMapper3.updateUser(user3);
		sqlSession3.commit();
		sqlSession3.close();*/
		UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
		User user2 = userMapper2.findUserById(1);
		System.out.println(user1);
		sqlSession2.close();
		
		
		
	}
}
