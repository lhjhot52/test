package Memo.yedam;

import java.util.List;

public interface MemoService {
	//전체조회
	List<MemoVO> selectAllList();
	//단건조회
	MemoVO selectMemoInfo(String title);
	
	
	int MemoInsert(MemoVO vo);
	int MemoModify(MemoVO vo);
	int MemoDelete(MemoVO vo);

}
