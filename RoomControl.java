
public interface RoomControl {
	public int getRoomNumber();

	public int getTemperatureSensorValue();

	public String getAlarmTextInputValue();

	public boolean isThereSmoke();

	public boolean isThereMotion();

	public boolean isAlarmed();
}
