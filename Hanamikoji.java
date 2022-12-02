 public class Hanamikoji{
	public static void main(String[] args){
		String[] myHands = new String[7];
		String[] pHands = new String[7];
		String[] cards = new String[21];
		String[][] situation= {{"0"," ","琉璃" ," ","0"},{"0"," ","杏樹" ," ","0"},{"0"," ","洋子" ," ","0"},{"0"," ","千春" ," ","0"},{"0"," ","絢音" ," ","0"},{"0"," ","知世" ," ","0"},{"0"," ","彩葉" ," ","0"}};
		String kickCard = "挑掉一張";	//遊戲初始挑掉的禮物名字會存放在這
		String myLastHand = "";	//我密約的牌
		String pLastHand = "";	//電腦密約的牌
		String[] myKickCard = {null,null};//我要取捨掉的牌
		String[] pKickCard = {null,null};//電腦要取捨掉的牌(寫這個是因為寫電腦的時候會用到)

		//new 第一個副程式 準備遊戲
		setGame stack = new setGame(cards);
		java.util.Scanner input = new java.util.Scanner(System.in);
		getData(situation);
		stack.shuffCards(cards);
		kickCard = stack.getCards(cards,myHands,pHands,kickCard);
		printMyHands(myHands);
		//System.out.println("\n被挑掉的牌是 "+kickCard); //撰寫程式檢查用
		System.out.println("");
		//printStack(cards);
		//new 第二個副程式 開始遊戲
		startGame game = new startGame();
		/*
		*預設為我先
		*for() 這邊本來要寫迴圈 但電腦還沒寫好 所以先讓電腦依照1~4的順序動作 而不是進入自我判斷
		*凹進去的部分是電腦的抽牌部分
		*/
			System.out.println("\n\n抽牌 !");
			int order = stack.drawACard(myHands,cards);
			System.out.println("你抽到的是 : "+myHands[order] );
			printMyHands(myHands);
			myLastHand = game.pickAction(situation,myHands,"I",myLastHand,myKickCard);
				stack.drawACard(pHands,cards);
				//printpHands(pHands);
				setHands(pHands);
			game.secretDeal(pHands,0,pLastHand,"player");

			System.out.println("\n\n抽牌 !");
			order = stack.drawACard(myHands,cards);
			System.out.println("你抽到的是 : "+myHands[order] );
			printMyHands(myHands);
			myLastHand = game.pickAction(situation,myHands,"I",myLastHand,myKickCard);
				stack.drawACard(pHands,cards);
				//printpHands(pHands);
				setHands(pHands);
			game.costDeal(pHands,0,1,"player",pKickCard);

			System.out.println("\n\n抽牌 !");
			order = stack.drawACard(myHands,cards);
			System.out.println("你抽到的是 : "+myHands[order] );
			printMyHands(myHands);
			myLastHand = game.pickAction(situation,myHands,"I",myLastHand,myKickCard);
				stack.drawACard(pHands,cards);
				//printpHands(pHands);
				setHands(pHands);
			game.kindGift(situation,pHands,0,1,2,"player");

			System.out.println("\n\n抽牌 !");
			order = stack.drawACard(myHands,cards);
			System.out.println("你抽到的是 : "+myHands[order] );
			printMyHands(myHands);
			myLastHand = game.pickAction(situation,myHands,"I",myLastHand,myKickCard);
				stack.drawACard(pHands,cards);
				//printpHands(pHands);
				setHands(pHands);
			game.loathGift(situation,pHands,0,1,2,3,"player");

		end(situation,myHands,pHands,myLastHand,pLastHand);//結算 把密約打開
		printMyHands(myHands);
	}

	//報告現場狀況
	public static void getData(String[][] data){
		int next_line = 0;
		System.out.println("我方\t傾\t藝者名\t心\t他方");
		for (String[] outside : data)
			for (String inside : outside){
				if (next_line % 5 == 0)
					System.out.print("\n");
				next_line++;
				System.out.print(inside+"\t");
			}
	}
	//印出我方手牌
	public static void printMyHands(String[] myHands){
		setHands(myHands);
		System.out.print("\n你的手牌 :");
		for (int i = 0; i < myHands.length; i++) System.out.print((i + 1)+"."+myHands[i]+" ");
		System.out.print("\n");
	}
	//整理手牌(把null排在後面)
	public static void setHands(String[] hands){
		for (int order = 0; order < hands.length-1; order++)
			for (int temp = order+1; temp < hands.length; temp++)
				if ((hands[order]==null) && (hands[temp] != null) ){
					hands[order] = hands[temp];
					hands[temp] = null;
				}
	}
	//印出敵方手牌(寫著放著 實際狀況不會使用的method 程式撰寫時可能可以用)
	public static void printpHands(String[] pHands){
		System.out.print("\n花一萬美金買取敵人的手牌資訊 : ");
		for (int i = 0; i < pHands.length; i++) System.out.print((i + 1)+"."+pHands[i]+" ");
		System.out.print("\n");
	}
	//印出牌庫(同上 寫著放著 實際狀況不會使用的method 程式撰寫時可能可以用)
	public static void printStack(String[] cards){
		System.out.print("\n牌庫 : ");
		for (int i = 0; i < cards.length; i++)
			if (cards[i] == "被抽走")
				continue;
			else
				System.out.print(cards[i] + " ");
	}

	//結算(計算誰拿幾分 並呼叫vectory)
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
	//勝利宣言 四個值多少 誰贏(或平手)?  (專門給結算呼叫)
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