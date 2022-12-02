import javafx.scene.control.Label; 

	
public class startGame{
	//Secret Deal先把密約存進lastHand(最後一手) 
	public String secretDeal(String[] hands,int a,String lastHand,String whoCall,Label hint){
		//如果是玩家使用的話 會顯示使用者提示(下兩行都是)
		if (whoCall.equals("I")) {
			System.out.println("你選擇[密約]" + hands[a]+"\"\n");
		}
		if (whoCall.equals("I")==false){
			hint.setText("對方選擇[密約] 請抽牌");
			System.out.println("對方選擇[密約]");
		}
		lastHand = hands[a];
		hands[a] = "null";
		return lastHand;
	}
	//Cost Deal取捨
	public void costDeal(String[] hands,int a,int b,String whoCall,String[] kickCard,Label hint){
		//如果是玩家使用的話 會顯示使用者提示(下兩行都是)
		if (whoCall.equals("I")){
			System.out.println("[取捨]你捨棄了" +hands[a]+" 和 "+hands[b]+"\n");
		}
		if (whoCall.equals("I")==false) {
			System.out.println("對方選擇[取捨]");
			hint.setText("對方選擇[取捨] 請抽牌");
		}
		hands[a] = "null";
		hands[b] = "null";
	}

	//Kind Gift贈與(暫定電腦必選第一張)
	public void kindGift(String[][] book,String[] hands,int a,int b,int c,String whoCall,Label hint){
		String lost =hands[a] ;
		//如果是玩家使用的話 會顯示使用者提示
		
		if (whoCall.equals("I")) {
			System.out.println("[贈與]你選擇 \""+hands[a]+"\",\""+hands[b]+"\",\""+hands[c]+"\"做贈與 對方選擇了\"" + lost+"\"\n 	");
			lost =hands[a];
		}
		if (whoCall.equals("I")==false){ //hands[a]會變成對方hands[a]
			hint.setText("對方[接收]"+"\n對方選擇[贈與] \n請選擇一張卡接收 決定後按上方[接收]");	
			System.out.println("對方選擇[贈與]");		
		}
	}
	//玩家對於贈與的回應 唯有電腦用贈與才需要用
	public String reactKindGift(String a2,String b2,String c2){
		String[] chooseArray = {a2,b2,c2};
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.println("Player use Kind Gift ,pick one card you want");
		for (int i = 0; i < chooseArray.length; i++)
			System.out.println((i+1) +"." + chooseArray[i]);
		return chooseArray[input.nextInt() - 1];
	}

	//Loath Gift競爭 (暫時無論如何電腦預設選第一二張)
	public void loathGift(String[][] book,String[] hands,int a,int b,int c,int d,String whoCall,Label hint){
		String lost1,lost2 = "";
		//如果是玩家使用的話 會顯示使用者提示
		if (whoCall.equals("I")==false){
			System.out.println("對方選擇[競爭]");
			hint.setText("對方選擇[競爭] 請選擇兩張卡接收 決定後按上方[接收]");
		}
		else{
			lost1 = hands[a];
			lost2 = hands[b];
		}
		if (whoCall.equals("I")){		//如果是玩家使用的話 會顯示使用者提示
			System.out.print("[競爭]你競爭了 1.\""+hands[a]+"\"&\""+hands[b]+"\" 2."+"\""+hands[c]+"\"&\""+hands[d]+"\" 而對手選擇了 1. ");
			
		}
	}
	//對競爭回應 唯有電腦用競爭才需要用
	public int reactLoathGift(String a2,String b2,String c2,String d2){
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.println("Player use Loath Gift,pick one combination you want");
		System.out.println("1. "+"\""+a2+"\"&\""+b2+"\"  /2. "+"\""+c2+"\"&\""+d2+"\"");
		return input.nextInt();
	}
}