package util;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Pagination {
	public int a[] = new int[3];
	public int intPageSize;      //一页显示的记录数
	int intRowCount;      //记录的总数
	int intPageCount;     //总页数
	int intPage;         //当前页，即待显示的页码
	String strPage;
	int i;
	
	public int[] getPage(ResultSet rs,String s){
		
		//设置一页显示的记录数
		intPageSize=50;
		//取得待显示的页码
		strPage=s;
		//判断strPage是否等于null,如果是，显示第一页数据
			if(strPage==null)
			{
			intPage=1;
			}else{
			//将字符串转换为整型
			intPage=java.lang.Integer.parseInt(strPage);
			}
			if(intPage<1)
			{
			intPage=1;
			}
		//获取记录总数
		try {
			rs.last();
			intRowCount=rs.getRow();
			//计算总页数
			intPageCount=(intRowCount+intPageSize-1)/intPageSize;
			//调整待显示的页码
			if(intPage>intPageCount) intPage=intPageCount;
			if(intPageCount>0)
			{
			//将记录指针定位到待显示页的第一条记录上
			rs.absolute((intPage-1)*intPageSize+1);
			}
			a[0]=intRowCount;
			a[1]=intPageCount;
			a[2] = intPage;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return a;
	}
}
