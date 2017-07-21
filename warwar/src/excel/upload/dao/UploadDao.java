package excel.upload.dao;

import java.util.List;

import excel.upload.domain.Excel;

public interface UploadDao {
	void addExcel(List<Excel> list);
}
