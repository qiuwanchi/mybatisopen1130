package com.secoo.mapper;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.secoo.entity.Orders;

public class OrdersMapperTest {

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
	public void testFindAllOrders() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);

		List<Orders> list = ordersMapper.findAllOrders();
		
		System.out.println(list);
		sqlSession.close();
	}
	
	@Test
	public void testFindAllOrdersResultMap() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapper ordersMapper = sqlSession.getMapper(OrdersMapper.class);

		List<Orders> list = ordersMapper.findAllOrdersResultMap();
		for(Orders order : list){
			System.out.println(order.getUser());
		}
		sqlSession.close();
	}

}
