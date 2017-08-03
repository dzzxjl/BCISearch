package util;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Pagination {
	public int a[] = new int[3];
	public int intPageSize;      //һҳ��ʾ�ļ�¼��
	int intRowCount;      //��¼������
	int intPageCount;     //��ҳ��
	int intPage;         //��ǰҳ��������ʾ��ҳ��
	String strPage;
	int i;
	
	public int[] getPage(ResultSet rs,String s){
		
		//����һҳ��ʾ�ļ�¼��
		intPageSize=50;
		//ȡ�ô���ʾ��ҳ��
		strPage=s;
		//�ж�strPage�Ƿ����null,����ǣ���ʾ��һҳ����
			if(strPage==null)
			{
			intPage=1;
			}else{
			//���ַ���ת��Ϊ����
			intPage=java.lang.Integer.parseInt(strPage);
			}
			if(intPage<1)
			{
			intPage=1;
			}
		//��ȡ��¼����
		try {
			rs.last();
			intRowCount=rs.getRow();
			//������ҳ��
			intPageCount=(intRowCount+intPageSize-1)/intPageSize;
			//��������ʾ��ҳ��
			if(intPage>intPageCount) intPage=intPageCount;
			if(intPageCount>0)
			{
			//����¼ָ�붨λ������ʾҳ�ĵ�һ����¼��
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
