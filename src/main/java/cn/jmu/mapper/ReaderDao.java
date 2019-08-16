package cn.jmu.mapper;

import java.util.List;

import cn.jmu.entity.Company;
import cn.jmu.entity.Reader;
import cn.jmu.entity.ReaderInfo;
import org.apache.ibatis.annotations.Param;

public interface ReaderDao {
	int checkReader(String usernum);
	int addReader(Reader reader);
	Reader findReaderById(String usernum);
	int addCompany(Company company);

    void updateReader(@Param("rnum") String rnum, @Param("remail") String remail, @Param("cname") String cname, @Param("ctel") String ctel);

    List<ReaderInfo> listReader( );

    String findUserpwd(String rnum);
}
