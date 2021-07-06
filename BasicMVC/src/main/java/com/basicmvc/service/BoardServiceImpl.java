package com.basicmvc.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basicmvc.dao.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	BoardDAO boardDao;
	
	@Override
	public String create(Map<String, Object> map) {
		int affectRowCount = this.boardDao.insert(map);
		if (affectRowCount == 1) {
			return map.get("board_id").toString();
		}
		return null;
	}
	
	@Override
	public Map<String, Object> detail(Map<String, Object> map) {
		return this.boardDao.selectDetail(map);
	}
	
	@Override
	public List<Map<String, Object>> list(Map<String, Object> map) {
		return this.boardDao.selectAll(map);
	}
	
	@Override
	public boolean modify(Map<String, Object> map) {
		return this.boardDao.update(map) == 1;
	}
	
	@Override
	public boolean remove(Map<String, Object> map) {
		return this.boardDao.delete(map) == 1;
	}
}
