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
	String[][] situation= {{"0"," ","�[��" ," ","0"},{"0"," ","����" ," ","0"},{"0"," ","�v�l" ," ","0"},{"0"," ","�d�K" ," ","0"},{"0"," ","����" ," ","0"},{"0"," ","���@" ," ","0"},{"0"," ","�m��" ," ","0"}};
	String kickCard = "�D���@�i";	//�C����l�D����§���W�r�|�s��b�o
	String myLastHand = "";	//�ڱK�����P
	String pLastHand = "";	//�q���K�����P
	String[] myKickCard = {"null","null"};//�ڭn���˱����P
	String[] pKickCard = {"null","null"};//�q���n���˱����P(�g�o�ӬO�]���g�q�����ɭԷ|�Ψ�)
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
			remain.setText("�ѤU���~:"+ remainNum);
			
			
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
			remain.setText("�ѤU���~:"+remainNum);
			System.out.println("\n\n��P !");
			int order = drawACard(myHands,cards);
			System.out.println("�A��쪺�O : "+myHands[order] );
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
		hint.setText("�ϥ�[�K��]:�п�ܤ@�i��P�K�� �T�{����Uok");

		action = 1;
		pickonce =picktwice=pick3times = false;
		a = b =c =d= -1;
		c1 = c2 = c3 = c4 = c5 = c6 = c7 = 0;
	}
	public void act2(){
		f2o.setImage(f2u);
		hint.setText("�ϥ�[����]:�п�ܨ�i��P��� �T�{����Uok");

		action = 2;
		pickonce =picktwice=pick3times = false;
		a = b =c =d= -1;
		c1 = c2 = c3 = c4 = c5 = c6 = c7 = 0;
	}
	public void act3(){
		f3o.setImage(f3u);
		hint.setText("�ϥ�[�ػP]:�п�ܤT�i��P �T�{����Uok");
		action = 3;
		pickonce =picktwice=pick3times = false;
		a =b =c =d= -1;
		c1 = c2 = c3 = c4 = c5 = c6 = c7 = 0;
	}
	public void act4(){
		f4o.setImage(f4u);
		hint.setText("�ϥ�[�v��]:�п�ܥ|�i��P �T�{����Uok");
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

			
			//ai �K��
			drawACard(pHands,cards);
			remainNum-= 1;
			remain.setText("�ѤU���~:"+remainNum);
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

			//ai����
			drawACard(pHands,cards);
			remainNum-= 1;
			remain.setText("�ѤU���~:"+remainNum);
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
				case "���v¯":
					aicard1n+= 1;
					aicard1.setText(""+aicard1n);
					break;
				case "����":
					aicard2n+= 1;
					aicard2.setText(""+aicard2n);
					break;
				case "�o�ȳ�":
					aicard3n+= 1;
					aicard3.setText(""+aicard3n);
					break;
				case "�T���u":
					aicard4n+= 1;
					aicard4.setText(""+aicard4n);
					break;
				case "�馡�Q��":
					aicard5n+= 1;
					aicard5.setText(""+aicard5n);
					break;
				case "�R��":
					aicard6n+= 1;
					aicard6.setText(""+aicard6n);
					break;
				case "�j�Ѩ��b":
					aicard7n+= 1;
					aicard7.setText(""+aicard7n);
			}
			switch (myHands[b]){
				case "���v¯":
					mycard1n+= 1;
					mycard1.setText(""+mycard1n);
					System.out.println("1");
					break;
				case "����":
					mycard2n+= 1;
					mycard2.setText(""+mycard2n);
					break;
				case "�o�ȳ�":
					mycard3n+= 1;
					mycard3.setText(""+mycard3n);
					break;
				case "�T���u":
					mycard4n+= 1;
					mycard4.setText(""+mycard4n);
					break;
				case "�馡�Q��":
					mycard5n+= 1;
					mycard5.setText(""+mycard5n);
					break;
				case "�R��":
					mycard6n+= 1;
					mycard6.setText(""+mycard6n);
					break;
				case "�j�Ѩ��b":
					mycard7n+= 1;
					mycard7.setText(""+mycard7n);
					break;
			}
			switch (myHands[c]){
				case "���v¯":
					mycard1n+= 1;
					mycard1.setText(""+mycard1n);
					break;
				case "����":
					mycard2n+= 1;
					mycard2.setText(""+mycard2n);
					break;
				case "�o�ȳ�":
					mycard3n+= 1;
					mycard3.setText(""+mycard3n);
					break;
				case "�T���u":
					mycard4n+= 1;
					mycard4.setText(""+mycard4n);
					break;
				case "�馡�Q��":
					mycard5n+= 1;
					mycard5.setText(""+mycard5n);
					break;
				case "�R��":
					mycard6n+= 1;
					mycard6.setText(""+mycard6n);
					break;
				case "�j�Ѩ��b":
					mycard7n+= 1;
					mycard7.setText(""+mycard7n);
					break;
			}
			myHands[a]=myHands[b]=myHands[c]="null";
			setHandImg(myHands);

			//ai�ػP ���P������
			drawACard(pHands,cards);
			remainNum-= 1;
			remain.setText("�ѤU���~:"+remainNum);
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
				case "���v¯":
					aicard1n+= 1;
					aicard1.setText(""+aicard1n);
					break;
				case "����":
					aicard2n+= 1;
					aicard2.setText(""+aicard2n);
					break;
				case "�o�ȳ�":
					aicard3n+= 1;
					aicard3.setText(""+aicard3n);
					break;
				case "�T���u":
					aicard4n+= 1;
					aicard4.setText(""+aicard4n);
					break;
				case "�馡�Q��":
					aicard5n+= 1;
					aicard5.setText(""+aicard5n);
					break;
				case "�R��":
					aicard6n+= 1;
					aicard6.setText(""+aicard6n);
					break;
				case "�j�Ѩ��b":
					aicard7n+= 1;
					aicard7.setText(""+aicard7n);
					break;
			}
			switch (lost2){
				case "���v¯":
					aicard1n+= 1;
					aicard1.setText(""+aicard1n);
					break;
				case "����":
					aicard2n+= 1;
					aicard2.setText(""+aicard2n);
					break;
				case "�o�ȳ�":
					aicard3n+= 1;
					aicard3.setText(""+aicard3n);
					break;
				case "�T���u":
					aicard4n+= 1;
					aicard4.setText(""+aicard4n);
					break;
				case "�馡�Q��":
					aicard5n+= 1;
					aicard5.setText(""+aicard5n);
					break;
				case "�R��":
					aicard6n+= 1;
					aicard6.setText(""+aicard6n);
					break;
				case "�j�Ѩ��b":
					aicard7n+= 1;
					aicard7.setText(""+aicard7n);
					break;
			}
			switch (myHands[c]){
				case "���v¯":
					mycard1n+= 1;
					mycard1.setText(""+mycard1n);
					break;
				case "����":
					mycard2n+= 1;
					mycard2.setText(""+mycard2n);
					break;
				case "�o�ȳ�":
					mycard3n+= 1;
					mycard3.setText(""+mycard3n);
					break;
				case "�T���u":
					mycard4n+= 1;
					mycard4.setText(""+mycard4n);
					break;
				case "�馡�Q��":
					mycard5n+= 1;
					mycard5.setText(""+mycard5n);
					break;
				case "�R��":
					mycard6n+= 1;
					mycard6.setText(""+mycard6n);
					break;
				case "�j�Ѩ��b":
					mycard7n+= 1;
					mycard7.setText(""+mycard7n);
					break;
			}

			switch (myHands[d]){
				case "���v¯":
					mycard1n+= 1;
					mycard1.setText(""+mycard1n);
					break;
				case "����":
					mycard2n+= 1;
					mycard2.setText(""+mycard2n);
					break;
				case "�o�ȳ�":
					mycard3n+= 1;
					mycard3.setText(""+mycard3n);
					break;
				case "�T���u":
					mycard4n+= 1;
					mycard4.setText(""+mycard4n);
					break;
				case "�馡�Q��":
					mycard5n+= 1;
					mycard5.setText(""+mycard5n);
					break;
				case "�R��":
					mycard6n+= 1;
					mycard6.setText(""+mycard6n);
					break;
				case "�j�Ѩ��b":
					mycard7n+= 1;
					mycard7.setText(""+mycard7n);
					break;
			}
			myHands[a]=myHands[b]=myHands[c]=myHands[d]="null";
			setHandImg(myHands);

			//ai�v�� ���P������
			drawACard(pHands,cards);
			remainNum-= 1;
			remain.setText("�ѤU���~:"+remainNum);
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
		hint.setText("�A[����]�F \n�Щ�P");
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
				case "���v¯":
					myhand1.setImage(sak);
					break;
				case "����":
					myhand1.setImage(tea);
					break;
				case "�o�ȳ�":
					myhand1.setImage(umb);
					break;
				case "�T���u":
					myhand1.setImage(sha);
					break;
				case "�馡�Q��":
					myhand1.setImage(flu);
					break;
				case "�j�Ѩ��b":
					myhand1.setImage(book);
					break;
				case "�R��":
					myhand1.setImage(fan);
					break;
				default:
					myhand1.setVisible(false);
					break;
			}
			switch(myHands[1]){
				case "���v¯":
					myhand2.setImage(sak);
					break;
				case "����":
					myhand2.setImage(tea);
					break;
				case "�o�ȳ�":
					myhand2.setImage(umb);
					break;
				case "�T���u":
					myhand2.setImage(sha);
					break;
				case "�馡�Q��":
					myhand2.setImage(flu);
					break;
				case "�j�Ѩ��b":
					myhand2.setImage(book);
					break;
				case "�R��":
					myhand2.setImage(fan);
					break;
				default:
					myhand2.setVisible(false);
					break;
			}
			switch(myHands[2]){
				case "���v¯":
					myhand3.setImage(sak);
					break;
				case "����":
					myhand3.setImage(tea);
					break;
				case "�o�ȳ�":
					myhand3.setImage(umb);
					break;
				case "�T���u":
					myhand3.setImage(sha);
					break;
				case "�馡�Q��":
					myhand3.setImage(flu);
					break;
				case "�j�Ѩ��b":
					myhand3.setImage(book);
					break;
				case "�R��":
					myhand3.setImage(fan);
					break;
				default:
					myhand3.setVisible(false);
					break;
			}
			switch(myHands[3]){
				case "���v¯":
					myhand4.setImage(sak);
					break;
				case "����":
					myhand4.setImage(tea);
					break;
				case "�o�ȳ�":
					myhand4.setImage(umb);
					break;
				case "�T���u":
					myhand4.setImage(sha);
					break;
				case "�馡�Q��":
					myhand4.setImage(flu);
					break;
				case "�j�Ѩ��b":
					myhand4.setImage(book);
					break;
				case "�R��":
					myhand4.setImage(fan);
					break;
				default:
					myhand4.setVisible(false);
					break;
			}
			switch(myHands[4]){
				case "���v¯":
					myhand5.setImage(sak);
					break;
				case "����":
					myhand5.setImage(tea);
					break;
				case "�o�ȳ�":
					myhand5.setImage(umb);
					break;
				case "�T���u":
					myhand5.setImage(sha);
					break;
				case "�馡�Q��":
					myhand5.setImage(flu);
					break;
				case "�j�Ѩ��b":
					myhand5.setImage(book);
					break;
				case "�R��":
					myhand5.setImage(fan);
					break;
				default:
					myhand5.setVisible(false);
					break;
			}	
		
			switch(myHands[5]){
				case "���v¯":
					myhand6.setImage(sak);
					break;
				case "����":
					myhand6.setImage(tea);
					break;
				case "�o�ȳ�":
					myhand6.setImage(umb);
					break;
				case "�T���u":
					myhand6.setImage(sha);
					break;
				case "�馡�Q��":
					myhand6.setImage(flu);
					break;
				case "�j�Ѩ��b":
					myhand6.setImage(book);
					break;
				case "�R��":
					myhand6.setImage(fan);
					break;
				default:
					myhand6.setVisible(false);
					break;
			}
			if(bsU == true){
				switch(myHands[6]){
				case "���v¯":
					myhand7.setImage(sak);
					myhand7.setVisible(true);
					break;
				case "����":
					myhand7.setImage(tea);
					myhand7.setVisible(true);
					break;
				case "�o�ȳ�":
					myhand7.setImage(umb);
					myhand7.setVisible(true);
					break;
				case "�T���u":
					myhand7.setImage(sha);
					myhand7.setVisible(true);
					break;
				case "�馡�Q��":
					myhand7.setImage(flu);
					myhand7.setVisible(true);
					break;
				case "�j�Ѩ��b":
					myhand7.setImage(book);
					myhand7.setVisible(true);
					break;
				case "�R��":
					myhand7.setImage(fan);
					myhand7.setVisible(true);
					break;
				default:
					myhand7.setVisible(false);
					break;
				}
			}
	}
	//�ǳƵP�w
	public void setGame(String[] emptyArray){
		for (int card = 0; card < 5; card++)
			emptyArray[card] = "���v¯";
		for (int card = 5; card < 9; card++)
			emptyArray[card] = "����";
		for (int card = 9; card < 12; card++)
			emptyArray[card] = "�o�ȳ�";
		for (int card = 12; card < 15; card++)
			emptyArray[card] = "�T���u";
		emptyArray[15] = "�馡�Q��";
		emptyArray[16] = "�馡�Q��";
		emptyArray[17] = "�j�Ѩ��b";
		emptyArray[18] = "�j�Ѩ��b";
		emptyArray[19] = "�R��";
		emptyArray[20] = "�R��";
	}
	//�~�P
	public void shuffCards(String[] cardStack){
		java.security.SecureRandom random = new java.security.SecureRandom();
		for (int i = 0; i < cardStack.length; i++){
			int index = random.nextInt(21);
			String temp = cardStack[i];
			cardStack[i] = cardStack[index];
			cardStack[index] = temp;
		}	
	}
	//�o�P
	public String getCards(String[] cardStack,String[] myHands,String[] pHands,String kick){
		kick = cardStack[0];
		cardStack[0] = "�Q�⨫";
		for (int order = 1; order <= 6; order++){
			myHands[order-1] = cardStack[order];
			cardStack[order] = "�Q�⨫";
		}
		for (int order = 7; order <= 12; order++){
			pHands[order-7] = cardStack[order];
			cardStack[order] = "�Q�⨫";
		}
		myHands[6] = "null";
		pHands[6] = "null";
		return kick;
	}
	//��P
	public int drawACard(String[] hands,String[] cardStack){
		for( int i = 0; i < hands.length; i++){
			if (hands[i] == "null"){
				for (int j = 0; j < cardStack.length; j++){
					if (cardStack[j] != "�Q�⨫"){
						hands[i] = cardStack[j];
						cardStack[j] = "�Q�⨫";
						break;
					}
				}
				return i;
			}
		}
		return 0;
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
				if ((hands[order]=="null") && (hands[temp] != "null") ){
					hands[order] = hands[temp];
					hands[temp] = "null";
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

	/*//����(�p��֮��X�� �éI�svectory)
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
	}*/
}