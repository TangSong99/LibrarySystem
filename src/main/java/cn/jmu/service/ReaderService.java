package cn.jmu.service;

import java.util.List;

import cn.jmu.entity.Company;
import cn.jmu.entity.Reader;
import cn.jmu.entity.ReaderInfo;

public interface ReaderService {

	public int checkReader(String usernum);
	int addReader(Reader reader);
	int addCompany(Company company);
	Reader findReaderById(String usernum);

    void updateReader(ReaderInfo readerInfo);

    List<ReaderInfo> listReader();

	String findUserpwd(String rnum);
}
