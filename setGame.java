 public class setGame{
	//準備牌庫
	public setGame(String[] emptyArray){
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
		return kick;
	}
	//抽牌
	public int drawACard(String[] hands,String[] cardStack){
		for( int i = 0; i < hands.length; i++){
			if (hands[i] == null){
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
}