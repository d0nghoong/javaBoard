package sec01;
import java.util.*;

public class BoardServiceExample {

	public static void main(String[]args) throws Exception {
		List<Board> list=new ArrayList<>();
		BoardService bse=new BoardService();
		Scanner scanner=new Scanner(System.in);
		
		int number;
		
		bse.print();
		
		while(true) {
		System.out.println("선택: ");
		number=scanner.nextInt();
		
		switch(number) { 
		case 1:bse.print(); break;
		case 2:bse.seeDeep(); break;
		case 3:bse.write(); break;
		case 4:bse.delete(); break;
		case 5:System.out.println("게시판을 종료합니다"); return;
		}
		
		
	}

}
}

