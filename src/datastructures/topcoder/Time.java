package datastructures.topcoder;


public class Time {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Time time = new Time();
		System.out.println(time.whatTime(0));
		System.out.println(time.whatTime(3661));
		System.out.println(time.whatTime(5436));
	}
	
	public String whatTime(int seconds){
		int hours = 0, mins = 0;
		
		if(seconds > 0){
			if(seconds >= 3600){ hours = getHours(seconds); seconds = seconds % 3600; }			
			if (seconds >= 60){ mins = getMins(seconds); seconds = seconds % 60; }
		}else{
			seconds = 0;
		}
		
		return String.valueOf(hours) + ":" + String.valueOf(mins) + ":" + String.valueOf(seconds);
	}
	
	private int getHours(int seconds){
		return seconds / 3600;
	}
	
	private int getMins(int seconds){
		return seconds / 60;
	} 
}
