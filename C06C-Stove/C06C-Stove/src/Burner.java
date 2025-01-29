public class Burner {
    
    enum Temperature {
        Blazing,
        Hot,
        Warm,
        Cold
    }
    
    enum Setting {
        OFF,
        LOW,
        MEDIUM,
        HIGH
    }

    public Temperature myTemperature;
    public Setting mySetting;
    public int timer;
    public final static int TIME_DURATION = 2;
    public int heatDuration; // tracks how long the burner has been heating or cooling (on or off)
    
    public Burner() {
        this.myTemperature = Temperature.Cold;
        this.mySetting = Setting.OFF;
        timer = 0;
        heatDuration = 0;
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
        if (timer > 0) {
            timer--;  
        }

        if (mySetting != Setting.OFF) {
            heatDuration++; // increases the duration since the burner was turned on
        } else if (heatDuration > 0) {
            heatDuration--; // slowly decreases when turned off
        }

        if (timer == 0) {
            switch (mySetting) {
                case OFF:
                    if (myTemperature != Temperature.Cold) {
                        myTemperature = Temperature.values()[myTemperature.ordinal() - 1];
                    }
                    break;
                case LOW:
                    if (heatDuration <= TIME_DURATION) {
                        myTemperature = Temperature.Cold; // initially starts as Cold
                    } else if (myTemperature != Temperature.Warm) {
                        myTemperature = Temperature.Warm;
                    }
                    break;
                case MEDIUM:
                    if (myTemperature != Temperature.Hot) {
                        myTemperature = Temperature.Hot;
                    }
                    break;
                case HIGH:
                    if (myTemperature != Temperature.Blazing) {
                        myTemperature = Temperature.Blazing;
                    }
                    break;
            }
        }

        // handles case where burner is turned up from CAREFUL to VERY HOT! DON'T TOUCH!
        if (mySetting == Setting.HIGH && myTemperature == Temperature.Hot) {
            myTemperature = Temperature.Blazing;
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
        int plusSigns = Math.min(heatDuration / TIME_DURATION, 3);
        String status = "[";
        for (int i = 0; i < 3 - plusSigns; i++) status += "-";
        for (int i = 0; i < plusSigns; i++) status += "+";
        status += "]..... " + getMyTemperature();
        
        System.out.println(status);
    }
}
