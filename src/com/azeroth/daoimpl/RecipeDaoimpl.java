package com.azeroth.daoimpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.azeroth.bean.Case1;
import com.azeroth.bean.Medicine;
import com.azeroth.bean.Recipe;
import com.azeroth.dao.MedicineDao;
import com.azeroth.dao.RecipeDao;
import com.azeroth.utils.DBHelper;

public class RecipeDaoimpl implements RecipeDao {

	@Override
	public void recipeAdd(Recipe recipe) {
		try {
			String sql  = "insert into t_recipe values(?,?,?,?)";
			Object[] obj = {recipe.getRc_id(),recipe.getCase1().getC_id(),recipe.getMedicine().getM_id(),recipe.getRc_count()};
			boolean rs = DBHelper.runSql(sql, obj);
			if(rs) {
				System.out.println("处方添加成功");
			}else {
				System.out.println("处方添加失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Recipe> recipeFindByCid(String c_id) {
		try {
			String sql  = "select * from t_recipe where c_id=?";
			Object[] obj = {c_id};
			ResultSet rs = DBHelper.getRs(sql, obj);
			List<Recipe> recipeList = new ArrayList<Recipe>();
			MedicineDao medDao = new MedicineDaoimpl();
			Case1 case1 = new Case1();
			while(rs.next()) {
				String rc_id = rs.getString("rc_id");
				String m_id = rs.getString("m_id");
				int rc_count = rs.getInt("rc_count");
				Medicine medicine = medDao.findbyMid(m_id);
				case1.setC_id(c_id);
				Recipe recipe = new Recipe(rc_id,medicine,rc_count,case1);
				recipeList.add(recipe);
			}
			return recipeList;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	
	

}
