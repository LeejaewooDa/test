package excel.upload.service;

import java.util.List;

import excel.upload.domain.Excel;


public interface IUploadService {
	void addExcel(List<Excel> list);
}
