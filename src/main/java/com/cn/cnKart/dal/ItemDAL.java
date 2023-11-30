package com.cn.cnKart.dal;

import com.cn.cnKart.entity.Item;

public interface ItemDAL {
Item getById(int id);
void save(Item item);
void delete(int id);
void update (Item updateItem);
}
