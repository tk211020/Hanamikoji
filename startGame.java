import javafx.scene.control.Label; 

	
public class startGame{
	//Secret Deal����K���s�ilastHand(�̫�@��) 
	public String secretDeal(String[] hands,int a,String lastHand,String whoCall,Label hint){
		//�p�G�O���a�ϥΪ��� �|��ܨϥΪ̴���(�U��泣�O)
		if (whoCall.equals("I")) {
			System.out.println("�A���[�K��]" + hands[a]+"\"\n");
		}
		if (whoCall.equals("I")==false){
			hint.setText("�����[�K��] �Щ�P");
			System.out.println("�����[�K��]");
		}
		lastHand = hands[a];
		hands[a] = "null";
		return lastHand;
	}
	//Cost Deal����
	public void costDeal(String[] hands,int a,int b,String whoCall,String[] kickCard,Label hint){
		//�p�G�O���a�ϥΪ��� �|��ܨϥΪ̴���(�U��泣�O)
		if (whoCall.equals("I")){
			System.out.println("[����]�A�˱�F" +hands[a]+" �M "+hands[b]+"\n");
		}
		if (whoCall.equals("I")==false) {
			System.out.println("�����[����]");
			hint.setText("�����[����] �Щ�P");
		}
		hands[a] = "null";
		hands[b] = "null";
	}

	//Kind Gift�ػP(�ȩw�q������Ĥ@�i)
	public void kindGift(String[][] book,String[] hands,int a,int b,int c,String whoCall,Label hint){
		String lost =hands[a] ;
		//�p�G�O���a�ϥΪ��� �|��ܨϥΪ̴���
		
		if (whoCall.equals("I")) {
			System.out.println("[�ػP]�A��� \""+hands[a]+"\",\""+hands[b]+"\",\""+hands[c]+"\"���ػP ����ܤF\"" + lost+"\"\n 	");
			lost =hands[a];
		}
		if (whoCall.equals("I")==false){ //hands[a]�|�ܦ����hands[a]
			hint.setText("���[����]"+"\n�����[�ػP] \n�п�ܤ@�i�d���� �M�w����W��[����]");	
			System.out.println("�����[�ػP]");		
		}
	}
	//���a����ػP���^�� �ߦ��q�����ػP�~�ݭn��
	public String reactKindGift(String a2,String b2,String c2){
		String[] chooseArray = {a2,b2,c2};
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.println("Player use Kind Gift ,pick one card you want");
		for (int i = 0; i < chooseArray.length; i++)
			System.out.println((i+1) +"." + chooseArray[i]);
		return chooseArray[input.nextInt() - 1];
	}

	//Loath Gift�v�� (�ȮɵL�צp��q���w�]��Ĥ@�G�i)
	public void loathGift(String[][] book,String[] hands,int a,int b,int c,int d,String whoCall,Label hint){
		String lost1,lost2 = "";
		//�p�G�O���a�ϥΪ��� �|��ܨϥΪ̴���
		if (whoCall.equals("I")==false){
			System.out.println("�����[�v��]");
			hint.setText("�����[�v��] �п�ܨ�i�d���� �M�w����W��[����]");
		}
		else{
			lost1 = hands[a];
			lost2 = hands[b];
		}
		if (whoCall.equals("I")){		//�p�G�O���a�ϥΪ��� �|��ܨϥΪ̴���
			System.out.print("[�v��]�A�v���F 1.\""+hands[a]+"\"&\""+hands[b]+"\" 2."+"\""+hands[c]+"\"&\""+hands[d]+"\" �ӹ���ܤF 1. ");
			
		}
	}
	//���v���^�� �ߦ��q�����v���~�ݭn��
	public int reactLoathGift(String a2,String b2,String c2,String d2){
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.println("Player use Loath Gift,pick one combination you want");
		System.out.println("1. "+"\""+a2+"\"&\""+b2+"\"  /2. "+"\""+c2+"\"&\""+d2+"\"");
		return input.nextInt();
	}
}