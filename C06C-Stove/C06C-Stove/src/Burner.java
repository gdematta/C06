public class Burner {
	
	enum Temperature {
		Blazing,
		Hot,
		Warm,
		Cold
	}
	
	public String getMyTemperature() {
		switch(myTemperature) {
			case Cold:
				return("cooool");
			case Warm:
				return("warm");
			case Hot:
				return("CAREFUL");
			case Blazing:
				return("VERY HOT! DON'T TOUCH");
			default:
				return("Invalid");
		}
	}

	public Temperature myTemperature;
	public Setting mySetting;
	public int timer;
	public final static int TIME_DURATION = 2;
	
	public Burner() {
		this.myTemperature = Temperature.Cold;
		this.mySetting = Setting.OFF;
		timer = 0;
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
	
	public void updateTemperature() {
		
	}
}