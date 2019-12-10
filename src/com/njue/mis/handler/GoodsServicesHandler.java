/**
 * 商品操作接口
 */

package com.njue.mis.handler;

import java.util.Vector;

import com.njue.mis.model.Goods;
import com.njue.mis.model.StorageGoods;

public interface GoodsServicesHandler
{
	
	/**
	 * 向数据库中添加新商品
	 * @param goods  封装好的goods对象
	 * @return  执行结果
	 */
	boolean addGoods(Goods goods);
	/**
	 * 从数据库中删除商品
	 * @param id  被删除商品的编号
	 * @return  执行结果
	 */
	boolean deleteGoods(String id);
	/**
	 * 查询数据库中满足条件的商品
	 * @param field 查询的字段
	 * @param value 满足的值
	 * @return 查询结果
	 */
	Vector<Goods> searchGoods(String field,String value);
	/**
	 * 修改商品的价格
	 * @param id 被修改的商品编号
	 * @param price 新的价格
	 * @return 执行结果
	 */
	boolean modifyGoodsPrice(String id,double price);
	/**
	 * 获取所有的商品
	 * @return 商品的集合
	 */
	Vector<Goods> getAllGoods();
	/**
     * 判断商品是否存在
     * @param id 查询的商品编号
     * @return 查询结果
     */
    boolean isExited(String id);
    /**
     * 获取商品的信息
     * @param id 被查询的商品的编号
     * @return 查询结果
     */
    Goods getGoodsInfo(String id);
    /**
	 * 查询库存的商品信息
	 * @return  查询结果集
	 */
	Vector<StorageGoods> getAllStorageGoods();
}
