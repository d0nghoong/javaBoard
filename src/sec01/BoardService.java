package sec01;

import java.io.*;
import java.util.*;

public class BoardService {
	

import java.util.*;
import java.io.*;                                                                                                                                                   

public class BoardService {
int pno=1;
	
	public void print() {
		System.out.println("----------");
		System.out.println("1.목록보기 | 2.상세보기 | 3.글쓰기 | 4.삭제하기 | 5.종료 ");
		System.out.println("----------");
	}
	
	public void seeDeep() throws Exception {
		InputStream fis=new FileInputStream("C:\\Users\\이동형\\Desktop\\backend\\java\\eclipse_workspace\\Project\\tis.db");
		ObjectInputStream ois=new ObjectInputStream(fis);
		
		List<Board> list=(List<Board>)ois.readObject();
		if(list.isEmpty()) {System.out.println("게시판이 비었습니다");}
		
		for(Board board:list) {
			System.out.println(board.getPno()+"\t"+board.getName()+"\t"+board.getPrice()+"\t"+board.getStock());
			
		}

	}
	
	public void write(){
		
		try {
			Board board=new Board();
			Scanner scanner=new Scanner(System.in);
			List<Board> iList=new ArrayList();
			
			board.pno=pno++;
			
			System.out.println("이름을 입력하십시오: ");
			board.name= scanner.nextLine();
			
			System.out.println("가격을 입력하십시오: ");
			board.price=scanner.nextInt();
			
			System.out.println("재고량을 입력하십시오: ");
			board.stock=scanner.nextInt();
			
			iList.add(board);
			
			FileOutputStream fos=new FileOutputStream("C:\\Users\\이동형\\Desktop\\backend\\java\\eclipse_workspace\\Project\\tis.db");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			
			oos.writeObject(iList);
			oos.flush();
			oos.close();
			
		} catch(Exception e) {
			System.out.println("에러 발생");
		}
		
	}

	
	public void delete(){
		try {
		InputStream fis=new FileInputStream("C:\\Users\\이동형\\Desktop\\backend\\java\\eclipse_workspace\\Project\\tis.db");
		ObjectInputStream ois=new ObjectInputStream(fis);
		
		List<Board> list=(List<Board>)ois.readObject();
		Scanner scanner=new Scanner(System.in);
		String name;
		int n=-1;
		
		System.out.println("삭제하고 싶은 물품의 상품명을 작성하십시오:");
		name=scanner.nextLine();
		
		Iterator<Board> iter=list.iterator();
		while(iter.hasNext()) {
			Board board=iter.next();
			if(board.getName().equals(name)) n=board.getPno();
		
		if(n==-1) {
			System.out.println("상품명이 잘못 되었습니다");
			return;
		}
		
		iter.remove();
			}
		}
	catch(Exception e) {System.out.println("에러발생");	

}
	}
	}

	