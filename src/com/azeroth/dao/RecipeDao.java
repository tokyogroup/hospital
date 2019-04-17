package com.azeroth.dao;

import java.util.List;

import com.azeroth.bean.Recipe;

//处方
public interface RecipeDao {

	
	void recipeAdd(Recipe recipe);//处方添加
	List<Recipe> recipeFindByCid(String cid);//处方查询根据cid
	
}
