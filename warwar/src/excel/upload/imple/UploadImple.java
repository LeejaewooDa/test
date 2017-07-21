package excel.upload.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import excel.upload.dao.UploadDao;
import excel.upload.domain.Excel;

@Repository
public class UploadImple implements UploadDao {

	private String NAMESPACE="Excel.";
	
	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;

	@Override
	public void addExcel(List<Excel> list) {
		System.out.println("addExcel");
		sqlMapClientTemplate.insert(NAMESPACE+"addExcel", list);
	}
}
