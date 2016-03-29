package designPatterns.acombined.djview;

public class DJTestDrive {

	public static void main(String[] args) {
		BeatModelInterface model = new BeatModel();
		@SuppressWarnings("unused")
		ControllerInterface controller = new BeatController(model);
	}
}
