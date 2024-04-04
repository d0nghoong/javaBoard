package sec01;

import java.io.*;
import java.util.*;

public class BoardService {
	
	
	
	public void print() {
		System.out.println("----------");
		System.out.println("1.목록보기 | 2.상세보기 | 3.수정하기 | 4.삭제하기 | 5.파일저장 | 6.종료 ");
		System.out.println("----------");
	}
	
	public void seeDeep() throws Exception {
		InputStream fis=new FileInputStream("\tis.db");
		ObjectInputStream ois=new ObjectInputStream(fis);
		
		List<Board> list=(List<Board>)ois.readObject();
		
		for(Board board:list) {
			System.out.println(board.getPno()+"\t"+board.getName()+"\t"+board.getPrice()+"\t"+board.getStock());
			
		}
		
		
	}
	
	public void delete() throws Exception {
		InputStream fis=new FileInputStream("\tis.db");
		ObjectInputStream ois=new ObjectInputStream(fis);
		
		List<Board> list=(List<Board>)ois.readObject();
		Scanner scanner=new Scanner(System.in);
		String name;
		int n=-1;
		
		System.out.println("삭제하고 싶은 물품의 상품명을 작성하십시오:");
		name=scanner.nextLine();
		
		for(Board board:list) {
			if(board.getName()==name) n=board.getPno();
		}
		if(n==-1) {
			System.out.println("상품명이 잘못 되었습니다");
			return;
		}
		
		list.remove(n);
	}
	

}
