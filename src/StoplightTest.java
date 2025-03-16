import mvc.*;
import stopLight.*;

public class StoplightTest {

	public static void main(String[] args) {
		StoplightFactory myStoplightFactory = new StoplightFactory();
		AppPanel stopLightPanel = new AppPanel(myStoplightFactory);
	}
}
