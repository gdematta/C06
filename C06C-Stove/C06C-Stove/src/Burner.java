public class Burner {
	
	enum Temperature {
		Blazing,
		Hot,
		Warm,
		Cold
	}
	
	public Temperature myTemperature;
	public Setting mySetting;
	public int timer;
	public final static int TIME_DURATION = 2;
	
	public Burner() {
		this.myTemperature = Temperature.Cold;
		this.mySetting = Setting.OFF;
	}
	
	public void plusButton() {
		switch(mySetting) {
			case OFF:
				mySetting = Setting.LOW;
				break;
			case LOW:
				mySetting = Setting.MEDIUM;
				break;
			case MEDIUM:
				mySetting = Setting.HIGH;
				break;
			case HIGH:
				break;	
		}
		timer = TIME_DURATION;
	}
	
	public void minusButton() {
		switch(mySetting) {
			case HIGH:
				mySetting = Setting.MEDIUM;
				break;
			case MEDIUM:
				mySetting = Setting.LOW;
				break;
			case LOW:
				mySetting = Setting.OFF;
				break;
			case OFF:
				break;	
		}
		timer = TIME_DURATION;
	}
	
	
}