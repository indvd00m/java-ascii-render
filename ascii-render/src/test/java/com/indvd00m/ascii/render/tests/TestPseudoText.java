package com.indvd00m.ascii.render.tests;

import com.indvd00m.ascii.render.Canvas;
import com.indvd00m.ascii.render.Point;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContext;
import com.indvd00m.ascii.render.api.IPoint;
import com.indvd00m.ascii.render.elements.PseudoText;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @since 1.1.0
 */
@Ignore
public class TestPseudoText {

	@Test
	public void test01() {
		IContext context = mock(IContext.class);

		String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

		List<String> lines = new ArrayList<String>();
		int lineSymbolsCount = 5;
		StringBuilder sb = new StringBuilder(text);
		for (int i = 0; i < sb.length(); i += lineSymbolsCount) {
			int lastIndex = i + lineSymbolsCount;
			if (lastIndex > sb.length()) {
				lastIndex = sb.length();
			}
			String s = sb.substring(i, lastIndex);
			lines.add(s);
		}

		int width = 80;
		int lineHeight = 20;
		int height = lineHeight * lines.size();

		ICanvas canvas = new Canvas(width, height);

		for (int i = 0; i < lines.size(); i++) {
			String line = lines.get(i);

			int y = i * lineHeight;

			PseudoText t = new PseudoText(line, 0, y, lineHeight);
			IPoint point = t.draw(canvas, context);
			assertEquals(new Point(0, y), point);
		}
		System.out.println(canvas.getText());
	}

	@Test
	public void test02() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(20, 20);
		PseudoText t = new PseudoText("A", true);
		IPoint point = t.draw(canvas, context);
		assertEquals(new Point(0, 0), point);
		String s = "";
		s += "                    \n";
		s += "                    \n";
		s += "                    \n";
		s += "                    \n";
		s += "   ░██░             \n";
		s += "   ░██░             \n";
		s += "   ▓██▓             \n";
		s += "   ████             \n";
		s += "  ░█▓▓█░            \n";
		s += "  ▒█▒▒█▒            \n";
		s += "  ▓█░░█▓            \n";
		s += "  ██░░██            \n";
		s += " ░██████░           \n";
		s += " ▒█▓  ▓█▒           \n";
		s += " ▓█▒  ▒█▓           \n";
		s += " ██░  ░██           \n";
		s += "                    \n";
		s += "                    \n";
		s += "                    \n";
		s += "                    ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

	@Test
	public void test03() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(20, 20);
		PseudoText t = new PseudoText("A", false);
		IPoint point = t.draw(canvas, context);
		assertEquals(new Point(0, 0), point);
		String s = "";
		s += "                    \n";
		s += "                    \n";
		s += "                    \n";
		s += "                    \n";
		s += "    ██              \n";
		s += "    ██              \n";
		s += "   ████             \n";
		s += "   ████             \n";
		s += "   ████             \n";
		s += "   █  █             \n";
		s += "  ██  ██            \n";
		s += "  ██  ██            \n";
		s += "  ██████            \n";
		s += "  ██  ██            \n";
		s += " ██    ██           \n";
		s += " ██    ██           \n";
		s += "                    \n";
		s += "                    \n";
		s += "                    \n";
		s += "                    ";
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

	@Test
	public void test04() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(120, 20);
		PseudoText t = new PseudoText("PseudoText", true);
		IPoint point = t.draw(canvas, context);
		assertEquals(new Point(0, 0), point);
		String s = "";
		s += "                                                                                                                        \n";
		s += "                                                                                                                        \n";
		s += "                                                                                                                        \n";
		s += "                                                ██                                                                      \n";
		s += " ██████▒                                        ██           ██████████                         ██                      \n";
		s += " ██ ░░██▒                                       ██               ██                             ██                      \n";
		s += " ██   ░██                                       ██               ██                             ██                      \n";
		s += " ██   ░██  ░▒████▓▒   ░▓███▒    ██    ██   ▒███▒██   ▒████░      ██       ░▓███▒   ▓██░░██▓   ███████                   \n";
		s += " ██   ░██  ▓█▓░░░▒▓  ░██░░██░   ██    ██  ░██░░███  ░██░░██░     ██      ░██░░██░  ░██▓▓██░     ██                      \n";
		s += " ██ ░░██▒  ██▒░      ▓█▒  ░█▓   ██    ██  ▓█▒  ▒██  ▓█▒  ▒█▓     ██      ▓█▒  ░█▓   ░████░      ██                      \n";
		s += " ██████▒   ▓████▓▒   ██░  ░██   ██    ██  ██░  ░██  ██░  ░██     ██      ██░  ░██    ▒██▒       ██                      \n";
		s += " ██        ░▓█████▒  ████████   ██    ██  ██░  ░██  ██░  ░██     ██      ████████    ░██░       ██                      \n";
		s += " ██           ░░▓██  ██░        ██░  ░██  ██░  ░██  ██░  ░██     ██      ██░         ▓██▓       ██                      \n";
		s += " ██             ░██  ▓█▒        ██░  ░██  ▓█▒  ▒██  ▓█▒  ▒█▓     ██      ▓█▒        ▒████▒      ██░                     \n";
		s += " ██        █▒░░░▓█▓  ░██▒░░▒▓   ▓█▓░░███  ░██░░███  ░██░░██░     ██      ░██▒░░▒▓  ░██▒▒██░     ▓█▒░                    \n";
		s += " ██        ░▓████▒░   ░▓███▓░   ░▓███░██   ▒███▒██   ▒████▒      ██       ░▓███▓░  ▓██░░██▓     ░▓███                   \n";
		s += "                                                                                                                        \n";
		s += "                                                                                                                        \n";
		s += "                                                                                                                        \n";
		s += "                                                                                                                        ";
		System.out.println(s);
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

	@Test
	public void test05() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(120, 20);
		PseudoText t = new PseudoText("PseudoText", false);
		IPoint point = t.draw(canvas, context);
		assertEquals(new Point(0, 0), point);
		String s = "";
		s += "                                                                                                                        \n";
		s += "                                                                                                                        \n";
		s += "                                                                                                                        \n";
		s += "                                                ██                                                                      \n";
		s += " ██████                                         ██           ██████████                         ██                      \n";
		s += " ██   ██                                        ██               ██                             ██                      \n";
		s += " ██    ██                                       ██               ██                             ██                      \n";
		s += " ██    ██    █████     ████     ██    ██    ███ ██    ████       ██        ████    ███  ███   ███████                   \n";
		s += " ██    ██  ██     █   ██  ██    ██    ██   ██  ███   ██  ██      ██       ██  ██    ██████      ██                      \n";
		s += " ██   ██   ██        ██    ██   ██    ██  ██    ██  ██    ██     ██      ██    ██    ████       ██                      \n";
		s += " ██████    ██████    ██    ██   ██    ██  ██    ██  ██    ██     ██      ██    ██     ██        ██                      \n";
		s += " ██         ███████  ████████   ██    ██  ██    ██  ██    ██     ██      ████████     ██        ██                      \n";
		s += " ██             ███  ██         ██    ██  ██    ██  ██    ██     ██      ██          ████       ██                      \n";
		s += " ██              ██  ██         ██    ██  ██    ██  ██    ██     ██      ██          ████       ██                      \n";
		s += " ██        █     ██   ██    █   ███  ███   ██  ███   ██  ██      ██       ██    █   ██  ██      ██                      \n";
		s += " ██         █████      █████     ████ ██    ███ ██    ████       ██        █████   ███  ███      ████                   \n";
		s += "                                                                                                                        \n";
		s += "                                                                                                                        \n";
		s += "                                                                                                                        \n";
		s += "                                                                                                                        ";
		System.out.println(s);
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

	@Test
	public void test06() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(60, 10);
		PseudoText t = new PseudoText("PseudoText", true);
		IPoint point = t.draw(canvas, context);
		assertEquals(new Point(0, 0), point);
		String s = "";
		s += "                                                            \n";
		s += "                          █                                 \n";
		s += " ███▒                     █      █████                      \n";
		s += " █ ░█                     █        █               █        \n";
		s += " █ ░█ ▒███  ░██▒ █  █  ▒█▓█ ▒██▒   █   ░██▒ ▓▒▒▓  ████      \n";
		s += " ███▒ █▒░   █▒░█ █  █  █▒▒█ █▒▒█   █   █▒░█ ░██░   █        \n";
		s += " █    ▒▓█▓  ████ █ ░█  █░░█ █░░█   █   ████  ██    █        \n";
		s += " █      ░█  █░░  █░▒█  █▒▒█ █▒▒█   █   █░░  ░██░   █░       \n";
		s += " █    ███▒  ░███ ▒█▓█  ▒█▓█ ▒██▒   █   ░███ ▓▒▒▓   ▓██      \n";
		s += "                                                            ";
		System.out.println(s);
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

	@Test
	public void test07() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(60, 10);
		PseudoText t = new PseudoText("PseudoText", false);
		IPoint point = t.draw(canvas, context);
		assertEquals(new Point(0, 0), point);
		String s = "";
		s += "                                                            \n";
		s += "                          █                                 \n";
		s += " ███                      █      █████                      \n";
		s += " █  █                     █        █               █        \n";
		s += " █  █ ████   ██  █  █   ███  ██    █    ██  █  █  ████      \n";
		s += " ███  █     █  █ █  █  █  █ █  █   █   █  █  ██    █        \n";
		s += " █     ███  ████ █  █  █  █ █  █   █   ████  ██    █        \n";
		s += " █       █  █    █  █  █  █ █  █   █   █     ██    █        \n";
		s += " █    ████   ███ ████   ███  ██    █    ███ █  █   ███      \n";
		s += "                                                            ";
		System.out.println(s);
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

	@Test
	public void test08() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(30, 5);
		PseudoText t = new PseudoText("PseudoText", true);
		IPoint point = t.draw(canvas, context);
		assertEquals(new Point(0, 0), point);
		String s = "";
		s += "                              \n";
		s += " ███▓        ████      █      \n";
		s += " ████████░██████ ▓███████     \n";
		s += " ████████▓██████ ▓████▒██     \n";
		s += "                              ";
		System.out.println(s);
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

	@Test
	public void test09() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(30, 5);
		PseudoText t = new PseudoText("PseudoText", false);
		IPoint point = t.draw(canvas, context);
		assertEquals(new Point(0, 0), point);
		String s = "";
		s += "                              \n";
		s += " ████        ████      █      \n";
		s += " ████████ ██████ ████████     \n";
		s += " ███████████████ █████ ██     \n";
		s += "                              ";
		System.out.println(s);
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

	@Test
	public void test10() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(240, 40);
		PseudoText t = new PseudoText("PseudoText", true);
		IPoint point = t.draw(canvas, context);
		assertEquals(new Point(0, 0), point);
		String s = "";
		s += "                                                                                                                                                                                                                                                \n";
		s += "                                                                                                                                                                                                                                                \n";
		s += "                                                                                                                                                                                                                                                \n";
		s += "                                                                                                                                                                                                                                                \n";
		s += "                                                                                                                                                                                                                                                \n";
		s += "                                                                                                                                                                                                                                                \n";
		s += "                                                                                                 ███                                                                                                                                            \n";
		s += "   ██████████▓▒░                                                                                 ███                        ███████████████████                                                                                                 \n";
		s += "   █████████████▒                                                                                ███                        ███████████████████                                                ███                                              \n";
		s += "   ██████████████▒                                                                               ███                        ███████████████████                                                ███                                              \n";
		s += "   ███    ░░░▓████░                                                                              ███                                ███                                                        ███                                              \n";
		s += "   ███        ░███▓                                                                              ███                                ███                                                        ███                                              \n";
		s += "   ███         ▒███                                                                              ███                                ███                                                        ███                                              \n";
		s += "   ███         ░███       ░▓█████▒░            ░▒█████▒░        ███        ███          ▒▓███▓▒  ███       ░▒▓████▓▒░               ███              ░▒█████▒░        ▓███░      ░███▓    ███████████████                                       \n";
		s += "   ███         ░███      ▒█████████▒          ▒█████████▒       ███        ███        ░████████▓░███      ░██████████░              ███             ▒█████████▒       ░███▓░    ░▓███░    ███████████████                                       \n";
		s += "   ███         ░███     ░███████████         ▓███████████░      ███        ███       ░██████████▓███     ░████████████░             ███            ▓███████████░       ▒███▒    ▒███▒     ███████████████                                       \n";
		s += "   ███         ▒███     ▓███▒░░░░▓██        ▒███▓░░░░▒████░     ███        ███       ▓███▓░░░░▓█████     ▓███▓░░░░▓███▓             ███           ▒███▓░░░░▒████░       ▓███░  ░███▓           ███                                              \n";
		s += "   ███        ░███▓     ███▒      ░▓       ░███▒      ░███▒     ███        ███      ░███▒      ▒████    ░███▒      ▒███░            ███          ░███▒      ░███▒       ░████░░████░           ███                                              \n";
		s += "   ███    ░░░▓████░     ███░               ▒██▒        ▒██▓     ███        ███      ▒███       ░████    ▒███        ███▒            ███          ▒██▒        ▒██▓        ░███▓▓███░            ███                                              \n";
		s += "   ██████████████▒      ███▓░              ▓██░        ░███     ███        ███      ▓██▒        ▒███    ▓██▒        ▒██▓            ███          ▓██░        ░███         ▒██████▒             ███                                              \n";
		s += "   █████████████▒       ▓████▓▒▒░          ████████████████     ███        ███      ███░        ░███    ███░        ░███            ███          ████████████████         ░▓████▓░             ███                                              \n";
		s += "   ██████████▓▒░        ░█████████▒░       ████████████████     ███        ███      ███░        ░███    ███░        ░███            ███          ████████████████          ░████░              ███                                              \n";
		s += "   ███                   ░▓████████▓░      ████████████████     ███        ███      ███░        ░███    ███░        ░███            ███          ████████████████          ░████░              ███                                              \n";
		s += "   ███                     ░░▒▓█████▒      ███                  ███       ░███      ███░        ░███    ███░        ░███            ███          ███                       ▓████▓              ███                                              \n";
		s += "   ███                         ░▒████      ███░                 ███░      ░███      ███░        ░███    ███░        ░███            ███          ███░                     ▒██████▒             ███                                              \n";
		s += "   ███                           ░███      ▓██▒                 ███░      ▒███      ▓██▒        ▒███    ▓██▒        ▒██▓            ███          ▓██▒                    ░███▓▓███░            ███░                                             \n";
		s += "   ███                           ░███      ▒██▓                 ███▒      ▓███      ▒███       ░████    ▒███        ███▒            ███          ▒██▓                   ░████░░████░           ███░                                             \n";
		s += "   ███                  ▓░       ▒███      ░███▓        ░▓      ▓██▓     ░████      ░███▒      ▒████    ░███▒      ▒███░            ███          ░███▓        ░▓        ▓███░  ░███▓           ███▒                                             \n";
		s += "   ███                  ██▓▒░░░░▓███▓       ▒████▒░░░░▒███      ▒███▓░░░▒█████       ▓███▓░░░░▓█████     ▓███▓░░░░▓███▓             ███           ▒████▒░░░░▒███       ▒███▒    ▒███▒          ▓███▒░░                                          \n";
		s += "   ███                  ████████████░        ▓████████████      ░█████████▒███       ░██████████▓███     ░████████████░             ███            ▓████████████      ░███▓      ▓███░         ▒█████████                                       \n";
		s += "   ███                  ▒██████████░          ▒██████████▒       ▒███████▒ ███        ░▓███████▓░███      ░██████████░              ███             ▒██████████▒     ░████░      ░████░         ▓████████                                       \n";
		s += "   ███                    ░▓████▓▒░            ░▒▓████▓░          ░▓███▓░  ███          ▒▓███▓▒  ███       ░▒▓████▓▒░               ███              ░▒▓████▓░       ▓███░        ░███▓          ▒▓██████                                       \n";
		s += "                                                                                                                                                                                                                                                \n";
		s += "                                                                                                                                                                                                                                                \n";
		s += "                                                                                                                                                                                                                                                \n";
		s += "                                                                                                                                                                                                                                                \n";
		s += "                                                                                                                                                                                                                                                \n";
		s += "                                                                                                                                                                                                                                                \n";
		s += "                                                                                                                                                                                                                                                \n";
		s += "                                                                                                                                                                                                                                                ";
		System.out.println(s);
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

	@Test
	public void test11() {
		IContext context = mock(IContext.class);
		ICanvas canvas = new Canvas(240, 40);
		PseudoText t = new PseudoText("PseudoText", false);
		IPoint point = t.draw(canvas, context);
		assertEquals(new Point(0, 0), point);
		String s = "";
		s += "                                                                                                                                                                                                                                                \n";
		s += "                                                                                                                                                                                                                                                \n";
		s += "                                                                                                                                                                                                                                                \n";
		s += "                                                                                                                                                                                                                                                \n";
		s += "                                                                                                                                                                                                                                                \n";
		s += "                                                                                                                                                                                                                                                \n";
		s += "                                                                                                 ███                                                                                                                                            \n";
		s += "   ███████████                                                                                   ███                        ███████████████████                                                                                                 \n";
		s += "   █████████████                                                                                 ███                        ███████████████████                                                ███                                              \n";
		s += "   ██████████████                                                                                ███                        ███████████████████                                                ███                                              \n";
		s += "   ███       █████                                                                               ███                                ███                                                        ███                                              \n";
		s += "   ███         ████                                                                              ███                                ███                                                        ███                                              \n";
		s += "   ███          ███                                                                              ███                                ███                                                        ███                                              \n";
		s += "   ███          ███        ██████                █████          ███        ███           █████   ███         ██████                 ███                █████          ████        ████    ███████████████                                       \n";
		s += "   ███          ███       █████████            █████████        ███        ███         █████████ ███       ██████████               ███              █████████         ████      ████     ███████████████                                       \n";
		s += "   ███          ███      ███████████         ████████████       ███        ███        ██████████████      ████████████              ███            ████████████         ███      ███      ███████████████                                       \n";
		s += "   ███          ███     ████     ███         ████     ████      ███        ███       █████    ██████     █████    █████             ███            ████     ████        ████    ████           ███                                              \n";
		s += "   ███         ████     ███        █        ███        ███      ███        ███       ███        ████     ███        ███             ███           ███        ███         ████  ████            ███                                              \n";
		s += "   ███       █████      ███                 ██          ███     ███        ███       ███        ████    ████        ████            ███           ██          ███         ████████             ███                                              \n";
		s += "   ██████████████       ███                ███          ███     ███        ███      ███          ███    ███          ███            ███          ███          ███          ██████              ███                                              \n";
		s += "   █████████████        ██████             ████████████████     ███        ███      ███          ███    ███          ███            ███          ████████████████          ██████              ███                                              \n";
		s += "   ███████████           █████████         ████████████████     ███        ███      ███          ███    ███          ███            ███          ████████████████           ████               ███                                              \n";
		s += "   ███                    ██████████       ████████████████     ███        ███      ███          ███    ███          ███            ███          ████████████████           ████               ███                                              \n";
		s += "   ███                        ██████       ███                  ███        ███      ███          ███    ███          ███            ███          ███                       ██████              ███                                              \n";
		s += "   ███                           ████      ███                  ███        ███      ███          ███    ███          ███            ███          ███                       ██████              ███                                              \n";
		s += "   ███                            ███      ███                  ███        ███      ███          ███    ███          ███            ███          ███                      ████████             ███                                              \n";
		s += "   ███                            ███       ███                 ███       ████       ███        ████    ████        ████            ███           ███                    ████  ████            ███                                              \n";
		s += "   ███                  █         ███       ███          █      ████      ████       ███        ████     ███        ███             ███           ███          █        ████    ████           ███                                              \n";
		s += "   ███                  ███     █████        ████      ███       ████    █████       █████    ██████     █████    █████             ███            ████      ███        ███      ███           ████                                             \n";
		s += "   ███                  ████████████         █████████████       █████████ ███        ██████████████      ████████████              ███            █████████████       ████      ████           █████████                                       \n";
		s += "   ███                   ██████████           ███████████         ████████ ███         █████████ ███       ██████████               ███             ███████████       ████        ████          █████████                                       \n";
		s += "   ███                     ██████                ██████            █████   ███           █████   ███         ██████                 ███                ██████        ████          ████           ███████                                       \n";
		s += "                                                                                                                                                                                                                                                \n";
		s += "                                                                                                                                                                                                                                                \n";
		s += "                                                                                                                                                                                                                                                \n";
		s += "                                                                                                                                                                                                                                                \n";
		s += "                                                                                                                                                                                                                                                \n";
		s += "                                                                                                                                                                                                                                                \n";
		s += "                                                                                                                                                                                                                                                \n";
		s += "                                                                                                                                                                                                                                                ";
		System.out.println(s);
		System.out.println(canvas.getText());
		assertEquals(s, canvas.getText());
	}

}
