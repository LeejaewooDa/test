package excel.upload.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import excel.upload.dao.UploadDao;
import excel.upload.domain.Excel;

@Service
public class UploadService implements IUploadService {
    
	@Autowired
	private UploadDao uploadDao;

	@Override
	public void addExcel(List<Excel> list) {
		System.out.println("addExcel_UploadService");
		uploadDao.addExcel(list);
		
	}

}
