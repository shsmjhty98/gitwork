package dao;

import java.util.List;

import vo.PhonebookVO;

public interface PhonebookDAOInter {
	public int insert(PhonebookVO pb); // 입력
	public List<PhonebookVO> findAll(); // 전체 출력
	public PhonebookVO findOneById(int idx); // 선택 출력
	public List<PhonebookVO> searchFind(String search); // 모든 항목 검색 출력
	public int update(int idx, PhonebookVO pb); // 수정
	public int delete(int idx); // 삭제
}