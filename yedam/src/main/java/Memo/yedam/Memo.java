package Memo.yedam;

import java.util.List;
import java.util.Scanner;



public class Memo {
	private Scanner scanner = new Scanner(System.in);
	private Memo dao = MemoServiceImpl.getInstance();
	
	
	
	public Memo() {
		while (true) {
			menuPrint();
			int menuNo = menuSelect();
			if (menuNo == 1) {
				selectMenuInsert();
			} else if (menuNo == 2) {
				selectMenuModify();
			} else if (menuNo == 3) {
				selectMenuDelete();
			} else if (menuNo == 4) {
				selectMenuInfo();
			} else if (menuNo == 5) {
				selectMenuList();
			 
			} else if (menuNo == 9) {
				end();
				break;
			}
		}
		
	
			
			
	
		
	}
	
	private void menuPrint() {
		
		System.out.println("========================================");
		System.out.println("1.등록 2.수정 3.삭제 4.메모조회 5.전체조회 6.종료");
		System.out.println("========================================");
		System.out.println("선택>>");
		
	}

private void end() {
		System.out.println("프로그램을 종료합니다");
		
	}

private int menuSelect() {
	int menuNo = 0;
	try {
		menuNo = Integer.parseInt(scanner.nextLine());
	} catch (Exception e) {
		System.out.println("없는 메뉴입니다.");
	}
	return menuNo;
	}

private void selectMenuList() {
		List<MemoVO> list = dao.selectMenuList();
		for(MemoVO memo : list) {
			System.out.println(memo);
		}
		
	}

private void selectMenuInfo() {
		String numb = inputMenonumb();
		
	}

private void selectMenuDelete() {
		
		
	}

private void selectMenuModify() {
		
		
	}

private void selectMenuInsert() {
			
	}




}