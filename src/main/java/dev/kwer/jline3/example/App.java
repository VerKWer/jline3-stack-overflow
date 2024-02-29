package dev.kwer.jline3.example;

import org.jline.reader.LineReaderBuilder;
import org.jline.reader.impl.LineReaderImpl;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.widget.TailTipWidgets;

public final class App {

	public static void main(String[] args) throws Exception {
		try(Terminal terminal = TerminalBuilder.builder().system(true).build()) {
			LineReaderImpl lineReader = (LineReaderImpl)LineReaderBuilder.builder().terminal(terminal).build();
			new TailTipWidgets(lineReader, __ -> null, 0, TailTipWidgets.TipType.COMBINED).enable();
			lineReader.redisplay();
			lineReader.redisplay();
		}
	}

}
