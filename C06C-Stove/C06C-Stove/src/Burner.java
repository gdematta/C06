// Authors- Spencer Groth, Gabe De Matte
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
    	// Update the timer every loop
        if (timer > 0) {
            timer--;  
        }
        
        // This case statement will adjust the temperatures based on the current state. We used the enum values() and ordinal() to cycle through the states.
        if (timer == 0) { 
            switch (mySetting) {
                case OFF: // While off, if the current heat isn't cold, increase the temp by one stage
                    if (myTemperature != Temperature.Cold) {
                        myTemperature = Temperature.values()[myTemperature.ordinal() + 1];
                    }
                    break;
                case LOW: // While low, if the current heat isn't warm or cold, increase the temp by one stage. If it is cold, decrease the temp by one stage
                    if ((myTemperature != Temperature.Warm) && (myTemperature != Temperature.Cold)) {
                        myTemperature = Temperature.values()[myTemperature.ordinal() + 1];
                    } else if (myTemperature == Temperature.Cold) {
                    	myTemperature = Temperature.values()[myTemperature.ordinal() - 1];
                    }
                    break;
                case MEDIUM: // While medium, if the current heat isn't hot or blazing, decrease the temp by one stage. If it is blazing, increase the temp by one stage
                    if ((myTemperature != Temperature.Hot) && (myTemperature != Temperature.Blazing)) {
                        myTemperature = Temperature.values()[myTemperature.ordinal() - 1];
                    } else if (myTemperature == Temperature.Blazing) {
                    	myTemperature = Temperature.values()[myTemperature.ordinal() + 1];
                    }
                    break;
                case HIGH: // While HIGH, if the current heat isn't blazing decrease the temp by one stage
                    if (myTemperature != Temperature.Blazing) {
                        myTemperature = Temperature.values()[myTemperature.ordinal() - 1];
                    }
                    break;
            }
        }

    }

    public String getMyTemperature() {
        switch(myTemperature) {
            case Cold:
                return "cooool";
            case Warm:
                return "warm";
            case Hot:
                return "CAREFUL";
            case Blazing:
                return "VERY HOT! DON'T TOUCH";
            default:
                return "Invalid";
        }
    }

    public void display() {
    	System.out.println("[" + mySetting + "]...." + getMyTemperature());
    }
}
