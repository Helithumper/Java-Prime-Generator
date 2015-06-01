
public class TimeClass implements Runnable{
	
	private static int time;
	private static int dif;
	private static int start;
	private static int current_value;
	private static float pdone;
	
	TimeClass(){
		time = 0;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			pdone = current_value - start;
			pdone = pdone / dif;
			pdone = pdone * 100;
			System.out.println(pdone + "%");
			time++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static String getTime(){
		return Integer.toString(time);
	}
	
	public static void setValues(int difference, int startpos){
		dif = difference;
		start = startpos;
	}
	
	public static void setCurrentValue(int value){
		current_value = value;
	}

	
}
