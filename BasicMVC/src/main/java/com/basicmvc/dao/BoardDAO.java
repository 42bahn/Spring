package com.basicmvc.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	@Autowired
	SqlSessionTemplate sqlsessionTemplate;
	
	public int insert(Map<String, Object> map) {
		return this.sqlsessionTemplate.insert("board.insert", map);
	}
	
	public Map<String, Object> selectDetail(Map<String, Object> map) {
		return this.sqlsessionTemplate.selectOne("board.selectOne", map);
	}
	
	public List<Map<String, Object>> selectAll(Map<String, Object> map) {
		return this.sqlsessionTemplate.selectList("board.selectAll", map);
	}
	
	public int update(Map<String, Object> map) {
		return this.sqlsessionTemplate.update("board.update", map);
	}
	
	public int delete(Map<String, Object> map) {
		return this.sqlsessionTemplate.delete("board.delete", map);
	}
	
	public List<Map<String, Object>> search(Map<String, Object> map) {
		return this.sqlsessionTemplate.selectList("board.search_list", map);
	}
}


