package test2;

import java.util.*;
import java.io.*;                                                                                                                                                   

public class BoardService {
int pno=1;
Scanner scanner=new Scanner(System.in);
List<Board> iList=new ArrayList();

	public void print() {
		System.out.println("----------");
		System.out.println("1.목록보기 | 2.상세보기 | 3.글쓰기 | 4.삭제하기 | 5.종료 ");
		System.out.println("----------");
	}
	
	public void seeDeep(){
		try {
		InputStream fis=new FileInputStream("C:\\Users\\이동형\\Desktop\\backend\\java\\eclipse_workspace\\test2\\tis.db");
		ObjectInputStream ois=new ObjectInputStream(fis);
		
		List<Board> list=(List<Board>)ois.readObject();
		if(list.isEmpty()) {System.out.println("게시판이 비었습니다");}
		
		for(Board board:list) {
			System.out.println(board.getPno()+"\t"+board.getName()+"\t"+board.getPrice()+"\t"+board.getStock());
			
		}

	}catch(Exception e) {System.out.println("에러 발생");}
	}
	
	public void write(){
		
		try {
			Board board=new Board();
			
			board.setPno(pno++);
			
			System.out.println("이름을 입력하십시오: ");
			board.setName(scanner.nextLine()); 
			
			System.out.println("가격을 입력하십시오: ");
			board.setPrice(Integer.parseInt(scanner.nextLine()));
			
			System.out.println("재고량을 입력하십시오: ");
			board.setStock(Integer.parseInt(scanner.nextLine()));
			
			iList.add(board);
			
			FileOutputStream fos=new FileOutputStream("C:\\Users\\이동형\\Desktop\\backend\\java\\eclipse_workspace\\test2\\tis.db");
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
		InputStream fis=new FileInputStream("C:\\Users\\이동형\\Desktop\\backend\\java\\eclipse_workspace\\test2\\tis.db");
		ObjectInputStream ois=new ObjectInputStream(fis);
		
		List<Board> list=(List<Board>)ois.readObject();
		int number;
	
		System.out.println("삭제하고 싶은 물품의 상품 번호를 입력하시오:");
		number=scanner.nextInt();
		scanner.nextLine();
		
		Iterator<Board> iter=list.iterator();
		while(iter.hasNext()) {
			Board board=iter.next();
			if(board.getPno()==number) {
				iter.remove();
				FileOutputStream fos=new FileOutputStream("C:\\Users\\이동형\\Desktop\\backend\\java\\eclipse_workspace\\test2\\tis.db");
				ObjectOutputStream oos=new ObjectOutputStream(fos);
				
				oos.writeObject(list);
				oos.flush();  
				oos.close();
				return;
			}
			
		}
		System.out.println("상품 번호가 잘못 되었습니다");
		return;
		}
	catch(Exception e) {System.out.println("에러발생");	

}
	}
	}