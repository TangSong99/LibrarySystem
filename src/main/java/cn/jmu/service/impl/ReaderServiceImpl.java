package cn.jmu.service.impl;

import java.util.List;

import cn.jmu.entity.ReaderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jmu.entity.Company;
import cn.jmu.entity.Reader;
import cn.jmu.mapper.ReaderDao;
import cn.jmu.service.ReaderService;

@Service
public class ReaderServiceImpl implements ReaderService{
	@Autowired
	private ReaderDao readerDao;
	@Override
	public int checkReader(String usernum) {
		return readerDao.checkReader(usernum);
	}
	@Override
	public int addReader(Reader reader)
	{
		return readerDao.addReader(reader);
	}
	@Override
	public Reader findReaderById(String usernum)
	{
		return readerDao.findReaderById(usernum);
	}

	@Override
	public void updateReader(ReaderInfo readerInfo) {
		readerDao.updateReader(readerInfo.getRnum(),readerInfo.getRemail(),readerInfo.getCname(),readerInfo.getCtel());
	}

	@Override
	public List<ReaderInfo> listReader( ) {
		//System.out.println("....111"+rnum);
		return readerDao.listReader();
	}

	@Override
	public String findUserpwd(String rnum) {
		return readerDao.findUserpwd(rnum);
	}

	@Override
	public int addCompany(Company company) {
		return readerDao.addCompany(company);
	}



}
