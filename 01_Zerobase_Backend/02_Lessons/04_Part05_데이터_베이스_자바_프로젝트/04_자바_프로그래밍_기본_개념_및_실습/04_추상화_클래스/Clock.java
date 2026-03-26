public class Clock {
    int hour;
    int minute;
    int second;
    
    boolean useAlarmYn;
    int alarmHour;
    int alarmMinute;

    public void alarmOn() {
        this.useAlarmYn = true;
    }

    public void alarmOff() {
        this.useAlarmYn = false;
    }

    public void setAlarm(int alarmHour, int alarmMinute) {
        this.alarmHour = alarmHour;
        this.alarmMinute = alarmMinute;
    }

    public void setTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    
    
}
