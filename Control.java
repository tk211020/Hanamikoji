import java.util.*;
import java.net.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label; 
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
public class Control implements Initializable{

	
	Image sak = new Image(Control.class.getResourceAsStream("5sak.png")); 
	Image tea = new Image(Control.class.getResourceAsStream("4tea.png")); 
	Image umb = new Image(Control.class.getResourceAsStream("3umb.png")); 
	Image sha = new Image(Control.class.getResourceAsStream("3sha.png")); 
	Image flu = new Image(Control.class.getResourceAsStream("2flu.png")); 
	Image fan = new Image(Control.class.getResourceAsStream("2fan.png")); 
	Image book = new Image(Control.class.getResourceAsStream("2book.png")); 
	Image f1u = new Image(Control.class.getResourceAsStream("f1u.png")); 
	Image f2u = new Image(Control.class.getResourceAsStream("f2u.png")); 
	Image f3u = new Image(Control.class.getResourceAsStream("f3u.png")); 
	Image f4u = new Image(Control.class.getResourceAsStream("f4u.png")); 
	Image r1 = new Image(Control.class.getResourceAsStream("r1.jpg")); 
	Image r2 = new Image(Control.class.getResourceAsStream("r2.jpg")); 
	Image r3 = new Image(Control.class.getResourceAsStream("r3.jpg")); 
	Image r4 = new Image(Control.class.getResourceAsStream("r4.jpg")); 
	Image r5 = new Image(Control.class.getResourceAsStream("r5.jpg")); 
	
	String[] myHands = new String[7];
	String[] pHands = new String[7];
	String[] cards = new String[21];
	String[][] situation= {{"0"," ","琉璃" ," ","0"},{"0"," ","杏樹" ," ","0"},{"0"," ","洋子" ," ","0"},{"0"," ","千春" ," ","0"},{"0"," ","絢音" ," ","0"},{"0"," ","知世" ," ","0"},{"0"," ","彩葉" ," ","0"}};
	String kickCard = "挑掉一張";	//遊戲初始挑掉的禮物名字會存放在這
	String myLastHand = "";	//我密約的牌
	String pLastHand = "";	//電腦密約的牌
	String[] myKickCard = {"null","null"};//我要取捨掉的牌
	String[] pKickCard = {"null","null"};//電腦要取捨掉的牌(寫這個是因為寫電腦的時候會用到)
	int remainNum = 8;

	startGame game = new startGame();
	@FXML
	Button button1,button2,button3,button4;
	@FXML
	Label hint,remain, mycard1,mycard2,mycard3,mycard4,mycard5,mycard6,mycard7,aicard1,aicard2,aicard3,aicard4,aicard5,aicard6,aicard7;
	@FXML
	ImageView p1,p2,p3,p4,p5,p6,p7,deck,myhand1,myhand2,myhand3,myhand4,myhand5,myhand6,myhand7,aihand1,aihand2,aihand3,aihand4,aihand5,aihand6,aihand7,f1o,f2o,f3o,f4o,f1p,f2p,f3p,f4p,f1card,f2card,choosed1,choosed2,choosed3,choosed4,choosed5,choosed6,choosed7,aif1card,aif2card,aifcard1,aifcard2,aifcard3,aifcard4,fchoosed1,fchoosed2,fchoosed3,fchoosed4,rule;
	
	int mycard1n,mycard2n,mycard3n,mycard4n,mycard5n,mycard6n,mycard7n,aicard1n,aicard2n,aicard3n,aicard4n,aicard5n,aicard6n,aicard7n = 0;
	boolean bsU = false;

	public Control(){
	}
	@FXML
	public void buttonStart(ActionEvent event){
			remain.setText("剩下物品:"+ remainNum);
			
			
			button1.setVisible(false);
			hint.setText("press above deck to draw a card");


			java.util.Scanner input = new java.util.Scanner(System.in);
			setGame(cards);
			getData(situation);
			shuffCards(cards);
			kickCard = getCards(cards,myHands,pHands,kickCard);
			setHandImg(myHands);
			printMyHands(myHands);
			System.out.println("");

			bsU = true;

	}
	int i = 0;
	public void buttonRule(){
		button4.setText("next");
		rule.setVisible(true);
		i +=1;
		switch (i){
			case 1:rule.setImage(r1);break;
			case 2:rule.setImage(r2);break;
			case 3:rule.setImage(r3);break;
			case 4:rule.setImage(r4);break;
			case 5:rule.setImage(r5);
				i = 0;
				button4.setText("rule");
				rule.setVisible(false);
				break;
		}
	}
		
	public void drawDeck(){
			remainNum-= 1;
			remain.setText("剩下物品:"+remainNum);
			System.out.println("\n\n抽牌 !");
			int order = drawACard(myHands,cards);
			System.out.println("你抽到的是 : "+myHands[order] );
			setHandImg(myHands);
			printMyHands(myHands);
			hint.setText("take an action!");
			if(remainNum == 0){
				deck.setVisible(false);
			}
	}
	boolean pickonce = false; 
	boolean picktwice = false;
	boolean pick3times = false; 
	int action;
	int c1,c2,c3,c4,c5,c6,c7 = 0;
	int a , b ,c ,d= -1;// pick card

	public void act1(){
		f1o.setImage(f1u);
		hint.setText("使用[密約]:請選擇一張手牌密約 確認後按下ok");

		action = 1;
		pickonce =picktwice=pick3times = false;
		a = b =c =d= -1;
		c1 = c2 = c3 = c4 = c5 = c6 = c7 = 0;
	}
	public void act2(){
		f2o.setImage(f2u);
		hint.setText("使用[取捨]:請選擇兩張手牌丟棄 確認後按下ok");

		action = 2;
		pickonce =picktwice=pick3times = false;
		a = b =c =d= -1;
		c1 = c2 = c3 = c4 = c5 = c6 = c7 = 0;
	}
	public void act3(){
		f3o.setImage(f3u);
		hint.setText("使用[贈與]:請選擇三張手牌 確認後按下ok");
		action = 3;
		pickonce =picktwice=pick3times = false;
		a =b =c =d= -1;
		c1 = c2 = c3 = c4 = c5 = c6 = c7 = 0;
	}
	public void act4(){
		f4o.setImage(f4u);
		hint.setText("使用[競爭]:請選擇四張手牌 確認後按下ok");
		action = 4;
		pickonce =picktwice=pick3times = false;
		a = b =c =d= -1;
		c1 = c2 = c3 = c4 = c5 = c6 = c7 = 0;
	}
	public void click1(){
		switch(action){
			case 1:
				a=0;
				break;
			case 2:
				if (pickonce == true){
					b = 0;
				}
				else{
					a = 0;
					pickonce = true;
				}
				break;
			case 3:
				if (picktwice == true &&pickonce ==true){
					c = 0;
				}
				else if (pickonce ==true){
					b = 0;
					picktwice =true;
				}
				else {	
					a = 0;
					pickonce = true;
				}
				
				break;
			case 4:
				if(pick3times ==true &&picktwice == true &&pickonce ==true){
					d =0;
				}
				else if (picktwice == true &&pickonce ==true){
					c = 0;
					pick3times = true;
				}
				else if (pickonce ==true){
					b = 0;
					picktwice =true;
				}
				else {
					a = 0;
					pickonce = true;
				}
				break;
		}
		c1 = 1;
		choosed1.setVisible(true);
	}
	public void click2(){
		switch(action){
			case 1:
				a=1;
				break;
			case 2:
				if (pickonce == true)
					b = 1;
				else{
					a = 1;
					pickonce = true;
				}
				break;
			case 3:
				if (picktwice == true &&pickonce ==true)
					c = 1;
				else if (pickonce ==true){
					b = 1;
					picktwice =true;
				}
				else {
					a = 1;
					pickonce = true;
				}
				break;
			case 4:
				if(pick3times ==true &&picktwice == true &&pickonce ==true){
					d =1;
				}
				else if (picktwice == true &&pickonce ==true){
					c = 1;
					pick3times = true;
				}
				else if (pickonce ==true){
					b = 1;
					picktwice =true;
				}
				else {
					a = 1;
					pickonce = true;
				}
				break;
				
				
		}
		c2 = 1;
		choosed2.setVisible(true);
	}
	public void click3(){
		switch(action){
			case 1:
				a=2;
				break;
			case 2:
				if (pickonce == true)
					b = 2;
				else{
					a = 2;
					pickonce = true;
				}
				break;
			case 3:
				if (picktwice == true &&pickonce ==true)
					c = 2;
				else if (pickonce ==true){
					b = 2;
					picktwice =true;
				}
				else {
					a = 2;
					pickonce = true;
				}
				break;
			case 4:
				if(pick3times ==true &&picktwice == true &&pickonce ==true){
					d =2;
				}
				else if (picktwice == true &&pickonce ==true){
					c = 2;
					pick3times = true;
				}
				else if (pickonce ==true){
					b = 2;
					picktwice =true;
				}
				else {
					a = 2;
					pickonce = true;
				}
				break;
				
		}
		c3 = 1;
		choosed3.setVisible(true);
	}

	public void click4(){
		switch(action){
			case 1:
				a=3;
				break;
			case 2:
				if (pickonce == true)
					b = 3;
				else{
					a = 3;
					pickonce = true;
				}
				break;
			case 3:
				if (picktwice == true &&pickonce ==true)
					c = 3;
				else if (pickonce ==true){
					b = 3;
					picktwice =true;
				}
				else {
					a = 3;
					pickonce = true;
				}
				break;
			case 4:
				if(pick3times ==true &&picktwice == true &&pickonce ==true){
					d =3;
				}
				else if (picktwice == true &&pickonce ==true){
					c = 3;
					pick3times = true;
				}
				else if (pickonce ==true){
					b = 3;
					picktwice =true;
				}
				else {
					a = 3;
					pickonce = true;
				}
				break;
				
		}
		c4 = 1;
		choosed4.setVisible(true);
	}
	public void click5(){
		switch(action){
			case 1:
				a=4;
				break;
			case 2:
				if (pickonce == true)
					b = 4;
				else{
					a = 4;
					pickonce = true;
				}
				break;
			case 3:
				if (picktwice == true &&pickonce ==true)
					c = 4;
				else if (pickonce ==true){
					b = 4;
					picktwice =true;
				}
				else {
					a = 4;
					pickonce = true;
				}
				break;
			case 4:
				if(pick3times ==true &&picktwice == true &&pickonce ==true){
					d =4;
				}
				else if (picktwice == true &&pickonce ==true){
					c = 4;
					pick3times = true;
				}
				else if (pickonce ==true){
					b = 4;
					picktwice =true;
				}
				else {
					a = 4;
					pickonce = true;
				}
				break;
				
		}
		c5 = 1;
		choosed5.setVisible(true);
	}
	public void click6(){
		switch(action){
			case 1:
				a=5;
				break;
			case 2:
				if (pickonce == true)
					b = 5;
				else{
					a = 5;
					pickonce = true;
				}
				break;
			case 3:
				if (picktwice == true &&pickonce ==true)
					c = 5;
				else if (pickonce ==true){
					b = 5;
					picktwice =true;
				}
				else {
					a = 5;
					pickonce = true;
				}
				break;
			case 4:
				if(pick3times ==true &&picktwice == true &&pickonce ==true){
					d =5;
				}
				else if (picktwice == true &&pickonce ==true){
					c = 5;
					pick3times = true;
				}
				else if (pickonce ==true){
					b = 5;
					picktwice =true;
				}
				else {
					a = 5;
					pickonce = true;
				}
				break;
				
		}
		c6 = 1;
		choosed6.setVisible(true);
	}
	public void click7(){
		switch(action){
			case 1:
				a=6;
				break;
			case 2:
				if (pickonce == true)
					b = 6;
				else{
					a = 6;
					pickonce = true;
				}
				break;
			case 3:
				if (picktwice == true &&pickonce ==true)
					c = 6;
				else if (pickonce ==true){
					b = 6;
					picktwice =true;
				}
				else {
					a = 6;
					pickonce = true;
				}
				break;
			case 4:
				if(pick3times ==true &&picktwice == true &&pickonce ==true){
					d =6;
				}
				else if (picktwice == true &&pickonce ==true){
					c = 6;
					pick3times = true;
				}
				else if (pickonce ==true){
					b = 6;
					picktwice =true;
				}
				else {
					a = 6;
					pickonce = true;
				}
				break;
			
				
		}
		c7 = 1;
		choosed7.setVisible(true);
	}

	public void canclick1(){
		if(c1==1){
			c1 =0;
			a = b = c = d = -1;
			choosed1.setVisible(false);
			pickonce = picktwice = pick3times =false;
			
		
		}
	}
	public void canclick2(){
		if(c2==1){
			c2 =0;
			a = b = c = d = -1;
			choosed2.setVisible(false);
			pickonce = picktwice = pick3times =false;
		}
	}
	public void canclick3(){
		if(c3==1){
			c3 =0;
			a = b = c = d = -1;
			choosed3.setVisible(false);
			pickonce = picktwice = pick3times =false;
		}
	}
	public void canclick4(){
		if(c4==1){
			c4 =0;
			a = b = c = d = -1;
			choosed4.setVisible(false);
			pickonce = picktwice = pick3times =false;
		}
	}
	public void canclick5(){
		if(c5==1){
			c5 =0;
			a = b = c = d = -1;
			choosed5.setVisible(false);
			pickonce = picktwice = pick3times =false;
		}
	}
	public void canclick6(){
		if(c6==1){
			c6 =0;
			a = b = c = d = -1;
			choosed6.setVisible(false);
			pickonce = picktwice = pick3times =false;
		}
	}
	public void canclick7(){
			
		if(c7==1){
			c7 =0;
			a = b = c = d = -1;
			choosed7.setVisible(false);
			pickonce = picktwice = pick3times =false;
		}
	}
	String lastHand = "";
	public void okButton(){
		if (action == 1){
			lastHand = game.secretDeal(myHands,a,lastHand,"I",hint);
			
			myLastHand = lastHand;
			choosed1.setVisible(false);
			choosed2.setVisible(false);
			choosed3.setVisible(false);
			choosed4.setVisible(false);
			choosed5.setVisible(false);
			choosed6.setVisible(false);
			choosed7.setVisible(false);
			f1card.setVisible(true);
			myHands[a] = "null";
			setHandImg(myHands);

			
			//ai 密約
			drawACard(pHands,cards);
			remainNum-= 1;
			remain.setText("剩下物品:"+remainNum);
			setHands(pHands);
			game.secretDeal(pHands,0,pLastHand,"player",hint);
			aif1card.setVisible(true);

			

		}
		else if (action == 2){
			game.costDeal(myHands,a,b,"I",myKickCard,hint);
			choosed1.setVisible(false);
			choosed2.setVisible(false);
			choosed3.setVisible(false);
			choosed4.setVisible(false);
			choosed5.setVisible(false);
			choosed6.setVisible(false);
			choosed7.setVisible(false);
			f2card.setVisible(true);
			myHands[a]="null";
			myHands[b]="null";
			setHandImg(myHands);

			//ai取捨
			drawACard(pHands,cards);
			remainNum-= 1;
			remain.setText("剩下物品:"+remainNum);
			setHands(pHands);
			game.costDeal(pHands,0,1,"player",pKickCard,hint);
			aihand6.setVisible(false);
			aif2card.setVisible(true);
		}
		else if (action ==3){
			String lost ="";
			lost = myHands[a];
			game.kindGift(situation,myHands,a,b,c,"I",hint);
			choosed1.setVisible(false);
			choosed2.setVisible(false);
			choosed3.setVisible(false);
			choosed4.setVisible(false);
			choosed5.setVisible(false);
			choosed6.setVisible(false);
			choosed7.setVisible(false);
			switch (lost){
				case "櫻花髮簪":
					aicard1n+= 1;
					aicard1.setText(""+aicard1n);
					break;
				case "茶具":
					aicard2n+= 1;
					aicard2.setText(""+aicard2n);
					break;
				case "油紙傘":
					aicard3n+= 1;
					aicard3.setText(""+aicard3n);
					break;
				case "三味線":
					aicard4n+= 1;
					aicard4.setText(""+aicard4n);
					break;
				case "日式篠笛":
					aicard5n+= 1;
					aicard5.setText(""+aicard5n);
					break;
				case "舞扇":
					aicard6n+= 1;
					aicard6.setText(""+aicard6n);
					break;
				case "古書卷軸":
					aicard7n+= 1;
					aicard7.setText(""+aicard7n);
			}
			switch (myHands[b]){
				case "櫻花髮簪":
					mycard1n+= 1;
					mycard1.setText(""+mycard1n);
					System.out.println("1");
					break;
				case "茶具":
					mycard2n+= 1;
					mycard2.setText(""+mycard2n);
					break;
				case "油紙傘":
					mycard3n+= 1;
					mycard3.setText(""+mycard3n);
					break;
				case "三味線":
					mycard4n+= 1;
					mycard4.setText(""+mycard4n);
					break;
				case "日式篠笛":
					mycard5n+= 1;
					mycard5.setText(""+mycard5n);
					break;
				case "舞扇":
					mycard6n+= 1;
					mycard6.setText(""+mycard6n);
					break;
				case "古書卷軸":
					mycard7n+= 1;
					mycard7.setText(""+mycard7n);
					break;
			}
			switch (myHands[c]){
				case "櫻花髮簪":
					mycard1n+= 1;
					mycard1.setText(""+mycard1n);
					break;
				case "茶具":
					mycard2n+= 1;
					mycard2.setText(""+mycard2n);
					break;
				case "油紙傘":
					mycard3n+= 1;
					mycard3.setText(""+mycard3n);
					break;
				case "三味線":
					mycard4n+= 1;
					mycard4.setText(""+mycard4n);
					break;
				case "日式篠笛":
					mycard5n+= 1;
					mycard5.setText(""+mycard5n);
					break;
				case "舞扇":
					mycard6n+= 1;
					mycard6.setText(""+mycard6n);
					break;
				case "古書卷軸":
					mycard7n+= 1;
					mycard7.setText(""+mycard7n);
					break;
			}
			myHands[a]=myHands[b]=myHands[c]="null";
			setHandImg(myHands);

			//ai贈與 取牌未完成
			drawACard(pHands,cards);
			remainNum-= 1;
			remain.setText("剩下物品:"+remainNum);
			setHands(pHands);
			game.kindGift(situation,pHands,0,1,2,"player",hint);
			aihand5.setVisible(false);
			aihand4.setVisible(false);
			aifcard4.setVisible(true);
			aifcard3.setVisible(true);
			aifcard2.setVisible(true);
			button3.setVisible(true);
		}
		else {//act4
			String lost1 ="";
			String lost2 ="";
			game.loathGift(situation,myHands,a,b,c,d,"I",hint);
			choosed1.setVisible(false);
			choosed2.setVisible(false);
			choosed3.setVisible(false);
			choosed4.setVisible(false);
			choosed5.setVisible(false);
			choosed6.setVisible(false);
			choosed7.setVisible(false);
			lost1 = myHands[a];
			lost2 = myHands[b];
			
			switch (lost1){
				case "櫻花髮簪":
					aicard1n+= 1;
					aicard1.setText(""+aicard1n);
					break;
				case "茶具":
					aicard2n+= 1;
					aicard2.setText(""+aicard2n);
					break;
				case "油紙傘":
					aicard3n+= 1;
					aicard3.setText(""+aicard3n);
					break;
				case "三味線":
					aicard4n+= 1;
					aicard4.setText(""+aicard4n);
					break;
				case "日式篠笛":
					aicard5n+= 1;
					aicard5.setText(""+aicard5n);
					break;
				case "舞扇":
					aicard6n+= 1;
					aicard6.setText(""+aicard6n);
					break;
				case "古書卷軸":
					aicard7n+= 1;
					aicard7.setText(""+aicard7n);
					break;
			}
			switch (lost2){
				case "櫻花髮簪":
					aicard1n+= 1;
					aicard1.setText(""+aicard1n);
					break;
				case "茶具":
					aicard2n+= 1;
					aicard2.setText(""+aicard2n);
					break;
				case "油紙傘":
					aicard3n+= 1;
					aicard3.setText(""+aicard3n);
					break;
				case "三味線":
					aicard4n+= 1;
					aicard4.setText(""+aicard4n);
					break;
				case "日式篠笛":
					aicard5n+= 1;
					aicard5.setText(""+aicard5n);
					break;
				case "舞扇":
					aicard6n+= 1;
					aicard6.setText(""+aicard6n);
					break;
				case "古書卷軸":
					aicard7n+= 1;
					aicard7.setText(""+aicard7n);
					break;
			}
			switch (myHands[c]){
				case "櫻花髮簪":
					mycard1n+= 1;
					mycard1.setText(""+mycard1n);
					break;
				case "茶具":
					mycard2n+= 1;
					mycard2.setText(""+mycard2n);
					break;
				case "油紙傘":
					mycard3n+= 1;
					mycard3.setText(""+mycard3n);
					break;
				case "三味線":
					mycard4n+= 1;
					mycard4.setText(""+mycard4n);
					break;
				case "日式篠笛":
					mycard5n+= 1;
					mycard5.setText(""+mycard5n);
					break;
				case "舞扇":
					mycard6n+= 1;
					mycard6.setText(""+mycard6n);
					break;
				case "古書卷軸":
					mycard7n+= 1;
					mycard7.setText(""+mycard7n);
					break;
			}

			switch (myHands[d]){
				case "櫻花髮簪":
					mycard1n+= 1;
					mycard1.setText(""+mycard1n);
					break;
				case "茶具":
					mycard2n+= 1;
					mycard2.setText(""+mycard2n);
					break;
				case "油紙傘":
					mycard3n+= 1;
					mycard3.setText(""+mycard3n);
					break;
				case "三味線":
					mycard4n+= 1;
					mycard4.setText(""+mycard4n);
					break;
				case "日式篠笛":
					mycard5n+= 1;
					mycard5.setText(""+mycard5n);
					break;
				case "舞扇":
					mycard6n+= 1;
					mycard6.setText(""+mycard6n);
					break;
				case "古書卷軸":
					mycard7n+= 1;
					mycard7.setText(""+mycard7n);
					break;
			}
			myHands[a]=myHands[b]=myHands[c]=myHands[d]="null";
			setHandImg(myHands);

			//ai競爭 取牌未完成
			drawACard(pHands,cards);
			remainNum-= 1;
			remain.setText("剩下物品:"+remainNum);
			setHands(pHands);
			game.loathGift(situation,pHands,0,1,2,3,"player",hint);
			aihand3.setVisible(false);
			aihand2.setVisible(false);
			aihand1.setVisible(false);
			aifcard4.setVisible(true);
			aifcard3.setVisible(true);
			aifcard2.setVisible(true);
			aifcard1.setVisible(true);
			button3.setVisible(true);
		}
	}
	int fc1,fc2,fc3,fc4 = 0;
	public void fclick1(){
		fc1 = 1;
		fchoosed1.setVisible(true);
		if (pickonce == true)
			b = 1;
		else{
			a = 1;
			pickonce = true;
		}
		
	}
	public void fclick2(){
		fc2 = 1;
		fchoosed2.setVisible(true);
		if(action == 3){
			a = 2;
		}
		else{ //action == 4
			if (pickonce == true)
				b = 2;
			else{
				a = 2;
				pickonce = true;
			}
		}		
	}
	public void fclick3(){  
		fc3 = 1;
		if(action == 3){
			a = 3;
		}
		else{ //action == 4
			if (pickonce == true)
				b = 3;
			else{
				a = 3;
				pickonce = true;
			}
		}	
		fchoosed3.setVisible(true);
	}
		
	public void fclick4(){
		fc4 = 1;
		fchoosed4.setVisible(true);
		if(action == 3){
			a = 4;
		}
		else{ //action == 4
			if (pickonce == true)
				b = 4;
			else{
				a = 4;
				pickonce = true;
			}
		}	
	}
	public void canfclick1(){
		if(fc1==1){
			fc1 =0;
			a = b = -1;
			fchoosed1.setVisible(false);
			pickonce =false;
		}
	}
	public void canfclick2(){
		if(fc2==1){
			fc2 =0;
			a = b = -1;
			fchoosed2.setVisible(false);
			pickonce =false;
		}
	}
	public void canfclick3(){
		
		if(fc3==1){
			fc3 =0;
			a = b = -1;
			fchoosed3.setVisible(false);
			pickonce =false;
		}
	}
	public void canfclick4(){
		if(fc4==1){
			fc4 =0;
			a = b = -1;
			fchoosed4.setVisible(false);
			pickonce =false;
		}
	}
	public void buttonRcv(){
		button3.setVisible(false);
		aifcard4.setVisible(false);
		aifcard3.setVisible(false);
		aifcard2.setVisible(false);
		aifcard1.setVisible(false);
		fchoosed4.setVisible(false);
		fchoosed3.setVisible(false);
		fchoosed2.setVisible(false);
		fchoosed1.setVisible(false);
		hint.setText("你[接收]了 \n請抽牌");
		if (remainNum == 0)
			hint.setText("over");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources){
		
	}

	public void setHandImg(String[] myHands){
			setHands(myHands);
			myhand1.setVisible(true);
			myhand2.setVisible(true);
			myhand3.setVisible(true);
			myhand4.setVisible(true);
			myhand5.setVisible(true);
			myhand6.setVisible(true);
			switch(myHands[0]){
				case "櫻花髮簪":
					myhand1.setImage(sak);
					break;
				case "茶具":
					myhand1.setImage(tea);
					break;
				case "油紙傘":
					myhand1.setImage(umb);
					break;
				case "三味線":
					myhand1.setImage(sha);
					break;
				case "日式篠笛":
					myhand1.setImage(flu);
					break;
				case "古書卷軸":
					myhand1.setImage(book);
					break;
				case "舞扇":
					myhand1.setImage(fan);
					break;
				default:
					myhand1.setVisible(false);
					break;
			}
			switch(myHands[1]){
				case "櫻花髮簪":
					myhand2.setImage(sak);
					break;
				case "茶具":
					myhand2.setImage(tea);
					break;
				case "油紙傘":
					myhand2.setImage(umb);
					break;
				case "三味線":
					myhand2.setImage(sha);
					break;
				case "日式篠笛":
					myhand2.setImage(flu);
					break;
				case "古書卷軸":
					myhand2.setImage(book);
					break;
				case "舞扇":
					myhand2.setImage(fan);
					break;
				default:
					myhand2.setVisible(false);
					break;
			}
			switch(myHands[2]){
				case "櫻花髮簪":
					myhand3.setImage(sak);
					break;
				case "茶具":
					myhand3.setImage(tea);
					break;
				case "油紙傘":
					myhand3.setImage(umb);
					break;
				case "三味線":
					myhand3.setImage(sha);
					break;
				case "日式篠笛":
					myhand3.setImage(flu);
					break;
				case "古書卷軸":
					myhand3.setImage(book);
					break;
				case "舞扇":
					myhand3.setImage(fan);
					break;
				default:
					myhand3.setVisible(false);
					break;
			}
			switch(myHands[3]){
				case "櫻花髮簪":
					myhand4.setImage(sak);
					break;
				case "茶具":
					myhand4.setImage(tea);
					break;
				case "油紙傘":
					myhand4.setImage(umb);
					break;
				case "三味線":
					myhand4.setImage(sha);
					break;
				case "日式篠笛":
					myhand4.setImage(flu);
					break;
				case "古書卷軸":
					myhand4.setImage(book);
					break;
				case "舞扇":
					myhand4.setImage(fan);
					break;
				default:
					myhand4.setVisible(false);
					break;
			}
			switch(myHands[4]){
				case "櫻花髮簪":
					myhand5.setImage(sak);
					break;
				case "茶具":
					myhand5.setImage(tea);
					break;
				case "油紙傘":
					myhand5.setImage(umb);
					break;
				case "三味線":
					myhand5.setImage(sha);
					break;
				case "日式篠笛":
					myhand5.setImage(flu);
					break;
				case "古書卷軸":
					myhand5.setImage(book);
					break;
				case "舞扇":
					myhand5.setImage(fan);
					break;
				default:
					myhand5.setVisible(false);
					break;
			}	
		
			switch(myHands[5]){
				case "櫻花髮簪":
					myhand6.setImage(sak);
					break;
				case "茶具":
					myhand6.setImage(tea);
					break;
				case "油紙傘":
					myhand6.setImage(umb);
					break;
				case "三味線":
					myhand6.setImage(sha);
					break;
				case "日式篠笛":
					myhand6.setImage(flu);
					break;
				case "古書卷軸":
					myhand6.setImage(book);
					break;
				case "舞扇":
					myhand6.setImage(fan);
					break;
				default:
					myhand6.setVisible(false);
					break;
			}
			if(bsU == true){
				switch(myHands[6]){
				case "櫻花髮簪":
					myhand7.setImage(sak);
					myhand7.setVisible(true);
					break;
				case "茶具":
					myhand7.setImage(tea);
					myhand7.setVisible(true);
					break;
				case "油紙傘":
					myhand7.setImage(umb);
					myhand7.setVisible(true);
					break;
				case "三味線":
					myhand7.setImage(sha);
					myhand7.setVisible(true);
					break;
				case "日式篠笛":
					myhand7.setImage(flu);
					myhand7.setVisible(true);
					break;
				case "古書卷軸":
					myhand7.setImage(book);
					myhand7.setVisible(true);
					break;
				case "舞扇":
					myhand7.setImage(fan);
					myhand7.setVisible(true);
					break;
				default:
					myhand7.setVisible(false);
					break;
				}
			}
	}
	//準備牌庫
	public void setGame(String[] emptyArray){
		for (int card = 0; card < 5; card++)
			emptyArray[card] = "櫻花髮簪";
		for (int card = 5; card < 9; card++)
			emptyArray[card] = "茶具";
		for (int card = 9; card < 12; card++)
			emptyArray[card] = "油紙傘";
		for (int card = 12; card < 15; card++)
			emptyArray[card] = "三味線";
		emptyArray[15] = "日式篠笛";
		emptyArray[16] = "日式篠笛";
		emptyArray[17] = "古書卷軸";
		emptyArray[18] = "古書卷軸";
		emptyArray[19] = "舞扇";
		emptyArray[20] = "舞扇";
	}
	//洗牌
	public void shuffCards(String[] cardStack){
		java.security.SecureRandom random = new java.security.SecureRandom();
		for (int i = 0; i < cardStack.length; i++){
			int index = random.nextInt(21);
			String temp = cardStack[i];
			cardStack[i] = cardStack[index];
			cardStack[index] = temp;
		}	
	}
	//發牌
	public String getCards(String[] cardStack,String[] myHands,String[] pHands,String kick){
		kick = cardStack[0];
		cardStack[0] = "被抽走";
		for (int order = 1; order <= 6; order++){
			myHands[order-1] = cardStack[order];
			cardStack[order] = "被抽走";
		}
		for (int order = 7; order <= 12; order++){
			pHands[order-7] = cardStack[order];
			cardStack[order] = "被抽走";
		}
		myHands[6] = "null";
		pHands[6] = "null";
		return kick;
	}
	//抽牌
	public int drawACard(String[] hands,String[] cardStack){
		for( int i = 0; i < hands.length; i++){
			if (hands[i] == "null"){
				for (int j = 0; j < cardStack.length; j++){
					if (cardStack[j] != "被抽走"){
						hands[i] = cardStack[j];
						cardStack[j] = "被抽走";
						break;
					}
				}
				return i;
			}
		}
		return 0;
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
				if ((hands[order]=="null") && (hands[temp] != "null") ){
					hands[order] = hands[temp];
					hands[temp] = "null";
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

	/*//結算(計算誰拿幾分 並呼叫vectory)
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
	}*/
}