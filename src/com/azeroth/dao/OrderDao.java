package com.azeroth.dao;

import com.azeroth.bean.Order;

public interface OrderDao {
  void orderAdd(Order order); //添加订单
  Order oerderFind(String o_id); //查找订单
  void orderUpdate(Order order); //增加订单价格
  void orderCut(Order order); // 减少订单价格
  void updateStatus(String o_id); //更改状态
}
