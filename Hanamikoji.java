 public class Hanamikoji{
	public static void main(String[] args){
		String[] myHands = new String[7];
		String[] pHands = new String[7];
		String[] cards = new String[21];
		String[][] situation= {{"0"," ","�[��" ," ","0"},{"0"," ","����" ," ","0"},{"0"," ","�v�l" ," ","0"},{"0"," ","�d�K" ," ","0"},{"0"," ","����" ," ","0"},{"0"," ","���@" ," ","0"},{"0"," ","�m��" ," ","0"}};
		String kickCard = "�D���@�i";	//�C����l�D����§���W�r�|�s��b�o
		String myLastHand = "";	//�ڱK�����P
		String pLastHand = "";	//�q���K�����P
		String[] myKickCard = {null,null};//�ڭn���˱����P
		String[] pKickCard = {null,null};//�q���n���˱����P(�g�o�ӬO�]���g�q�����ɭԷ|�Ψ�)

		//new �Ĥ@�ӰƵ{�� �ǳƹC��
		setGame stack = new setGame(cards);
		java.util.Scanner input = new java.util.Scanner(System.in);
		getData(situation);
		stack.shuffCards(cards);
		kickCard = stack.getCards(cards,myHands,pHands,kickCard);
		printMyHands(myHands);
		//System.out.println("\n�Q�D�����P�O "+kickCard); //���g�{���ˬd��
		System.out.println("");
		//printStack(cards);
		//new �ĤG�ӰƵ{�� �}�l�C��
		startGame game = new startGame();
		/*
		*�w�]���ڥ�
		*for() �o�䥻�ӭn�g�j�� ���q���٨S�g�n �ҥH�����q���̷�1~4�����ǰʧ@ �Ӥ��O�i�J�ۧڧP�_
		*�W�i�h�������O�q������P����
		*/
			System.out.println("\n\n��P !");
			int order = stack.drawACard(myHands,cards);
			System.out.println("�A��쪺�O : "+myHands[order] );
			printMyHands(myHands);
			myLastHand = game.pickAction(situation,myHands,"I",myLastHand,myKickCard);
				stack.drawACard(pHands,cards);
				//printpHands(pHands);
				setHands(pHands);
			game.secretDeal(pHands,0,pLastHand,"player");

			System.out.println("\n\n��P !");
			order = stack.drawACard(myHands,cards);
			System.out.println("�A��쪺�O : "+myHands[order] );
			printMyHands(myHands);
			myLastHand = game.pickAction(situation,myHands,"I",myLastHand,myKickCard);
				stack.drawACard(pHands,cards);
				//printpHands(pHands);
				setHands(pHands);
			game.costDeal(pHands,0,1,"player",pKickCard);

			System.out.println("\n\n��P !");
			order = stack.drawACard(myHands,cards);
			System.out.println("�A��쪺�O : "+myHands[order] );
			printMyHands(myHands);
			myLastHand = game.pickAction(situation,myHands,"I",myLastHand,myKickCard);
				stack.drawACard(pHands,cards);
				//printpHands(pHands);
				setHands(pHands);
			game.kindGift(situation,pHands,0,1,2,"player");

			System.out.println("\n\n��P !");
			order = stack.drawACard(myHands,cards);
			System.out.println("�A��쪺�O : "+myHands[order] );
			printMyHands(myHands);
			myLastHand = game.pickAction(situation,myHands,"I",myLastHand,myKickCard);
				stack.drawACard(pHands,cards);
				//printpHands(pHands);
				setHands(pHands);
			game.loathGift(situation,pHands,0,1,2,3,"player");

		end(situation,myHands,pHands,myLastHand,pLastHand);//���� ��K�����}
		printMyHands(myHands);
	}

	//���i�{�����p
	public static void getData(String[][] data){
		int next_line = 0;
		System.out.println("�ڤ�\t��\t���̦W\t��\t�L��");
		for (String[] outside : data)
			for (String inside : outside){
				if (next_line % 5 == 0)
					System.out.print("\n");
				next_line++;
				System.out.print(inside+"\t");
			}
	}
	//�L�X�ڤ��P
	public static void printMyHands(String[] myHands){
		setHands(myHands);
		System.out.print("\n�A����P :");
		for (int i = 0; i < myHands.length; i++) System.out.print((i + 1)+"."+myHands[i]+" ");
		System.out.print("\n");
	}
	//��z��P(��null�Ʀb�᭱)
	public static void setHands(String[] hands){
		for (int order = 0; order < hands.length-1; order++)
			for (int temp = order+1; temp < hands.length; temp++)
				if ((hands[order]==null) && (hands[temp] != null) ){
					hands[order] = hands[temp];
					hands[temp] = null;
				}
	}
	//�L�X�Ĥ��P(�g�۩�� ��ڪ��p���|�ϥΪ�method �{�����g�ɥi��i�H��)
	public static void printpHands(String[] pHands){
		System.out.print("\n��@�U�����R���ĤH����P��T : ");
		for (int i = 0; i < pHands.length; i++) System.out.print((i + 1)+"."+pHands[i]+" ");
		System.out.print("\n");
	}
	//�L�X�P�w(�P�W �g�۩�� ��ڪ��p���|�ϥΪ�method �{�����g�ɥi��i�H��)
	public static void printStack(String[] cards){
		System.out.print("\n�P�w : ");
		for (int i = 0; i < cards.length; i++)
			if (cards[i] == "�Q�⨫")
				continue;
			else
				System.out.print(cards[i] + " ");
	}

	//����(�p��֮��X�� �éI�svectory)
	public static void end(String[][] book,String[] myHands,String[] pHands,String myLastHand,String pLastHand){
		startGame game = new startGame();
		game.plusOne(book,myLastHand,0);
		game.plusOne(book,pLastHand,4);
		int[] gradeLine = {5,4,3,3,2,2,2};
		int myGrade = 0;
		int pGrade = 0;
		int myPoint = 0;
		int pPoint = 0;
		for (int i = 0, myGift = 0, pGift = 0; i < book.length; i++){
			myGift = 0;
 			pGift = 0;
			if (book[i][1].equals("<")) myGift += 0.5;
			if (book[i][3].equals(">")) pGift += 0.5;
			if ((myGift=Integer.parseInt(book[i][0])) == (pGift=Integer.parseInt(book[i][4])) ) continue;
			myGift += Integer.parseInt(book[i][0]);
			pGift += Integer.parseInt(book[i][4]);
			if (myGift > pGift){
				myPoint++;
				myGrade += gradeLine[i];
				book[i][1] = "<";
				book[i][3] = " ";
			}	
			else{
				pPoint++;
				pGrade += gradeLine[i];
				book[i][3] = ">";
				book[i][1] = " ";
			}
		}
		getData(book);
		vectory(myGrade,pGrade,myPoint,pPoint);
	}
	//�ӧQ�Ũ� �|�ӭȦh�� ��Ĺ(�Υ���)?  (�M��������I�s)
	public static void vectory(int gradeA,int gradeB,int pointA,int pointB){
		System.out.println("\n\nYou get " + gradeA + " points, and " + pointA + " artist ~");
		System.out.println("Player get " + gradeB + " points, and " + pointB + " artist.");
		if (gradeA >= 11) System.out.println("You win !(by rule 1/3)");
		else if (gradeB >= 11) System.out.println("You lose......(by rule 1/3)");
		else if (pointA >= 4) System.out.println("You win !(by rule 2/3)");
		else if (pointB >= 4) System.out.println("You lose......(by rule 2/3)");
		else System.out.println("Even even!!(by rule 3/3)");
	}
}