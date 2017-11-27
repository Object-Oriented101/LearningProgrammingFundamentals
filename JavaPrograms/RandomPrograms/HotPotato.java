package RandomPrograms;

public class HotPotato {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int playerCount = 5;
		int totalPasses = 10;

		boolean x = false;
		int currentPass = 1;
		int currentPlayer = 2;
		int[] blacklist = new int[playerCount-1];
		int blackCounter = 0;

		for(int i = 0; i < 5; i++){
			while(!x){
				System.out.println("Passes:"+currentPass + "  Player with potato:"+ currentPlayer);
				if(currentPass != totalPasses){

					if(currentPlayer != playerCount){
						currentPlayer++;
						currentPass++;
					}else{
						currentPlayer = 1;
						currentPass++;
					}
				}else{
					blacklist[blackCounter] = currentPlayer;
					blackCounter++;
					x = true;
				}
			}
		}
	}

	public static void passSimulator(int[] playerArray, int passes){
		/*

		 */

	}
}