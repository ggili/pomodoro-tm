package ru.greeneyes.project.pomidoro;

import ru.greeneyes.project.pomidoro.model.Config;
import ru.greeneyes.project.pomidoro.model.ControlThread;
import ru.greeneyes.project.pomidoro.model.PomodoroModel;

import javax.swing.*;

/**
 * User: dima
 * Date: May 29, 2010
 */
public class Pomodoro_Playground {
	public static void main(String[] args) {
		PomodoroModel model = new PomodoroModel(new MyConfig());
		new ControlThread(model).start();
		PomodoroPresenter presenter = new PomodoroPresenter(model) {
			@Override
			protected void showPopupBalloon() {}
		};

		JFrame jFrame = new JFrame();
		jFrame.setContentPane(presenter.getContentPane());
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.pack();
		jFrame.setVisible(true);
	}

	private static class MyConfig extends Config {
		@Override
		public long getPomodoroLength() {
			return 5 * 1000;
		}

		@Override
		public long getBreakLength() {
			return 5 * 1000;
		}
	}
}