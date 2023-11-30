package com.cn.cnKart.dal;

import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cn.cnKart.entity.Item;

import jakarta.persistence.EntityManager;
@Repository
public class ItemDALImpl implements ItemDAL {
@Autowired 
EntityManager entityManager;
@Override
public Item getById(int id) {
Session session =entityManager.unwrap(Session.class);
Item item=session.get(Item.class,id);
return item;
}
//@Override
//public void save(Item item) {
//Session session=entityManager.unwrap(Session.class);
//session.save(item);
//}	
@Override
public void save(Item item) {
	
	Session session = entityManager.unwrap(Session.class);
	session.save(item);
	
}
@Override
public void delete(int id) {
	// TODO Auto-generated method stub
	Session session = entityManager.unwrap(Session.class);
//	session.delete(Item.class, id);  aise karke delete ni kar sakte kyu ki delete fn only requires object as paramter
	Item item=session.get(Item.class,id);
	session.delete(item);
}
@Override
public void update(Item updateItem) {
	// TODO Auto-generated method stub
	Session session = entityManager.unwrap(Session.class);
	//fetch the current item detail from database
	Item currentItem=session.get(Item.class,updateItem.getId());
	//update the details in the current object
	currentItem.setDescription(updateItem.getDescription());
	currentItem.setName(updateItem.getName());
	//update the database
	session.update(currentItem);
	
}


}
