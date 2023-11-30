package com.cn.cnKart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.cnKart.dal.ItemDAL;
import com.cn.cnKart.entity.Item;

import jakarta.transaction.Transactional;

@Service
public class ItemService {
	@Autowired
	ItemDAL itemDAL;
	@Transactional
	public Item getItemById(int id) {
		return itemDAL.getById(id);
	}
	@Transactional
	public void saveItem(Item item) {
		itemDAL.save(item);
	}
	@Transactional
	public void delete(int id)
	{
		itemDAL.delete(id);
	}
	@Transactional
	public void update(Item updateItem)
	{
		itemDAL.update(updateItem);
	}
	
}
