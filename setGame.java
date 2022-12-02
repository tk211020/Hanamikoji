 public class setGame{
	//�ǳƵP�w
	public setGame(String[] emptyArray){
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
		return kick;
	}
	//��P
	public int drawACard(String[] hands,String[] cardStack){
		for( int i = 0; i < hands.length; i++){
			if (hands[i] == null){
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
}