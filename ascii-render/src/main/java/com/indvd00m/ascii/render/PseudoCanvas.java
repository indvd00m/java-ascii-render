package com.indvd00m.ascii.render;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @since 2.2.0
 */
public class PseudoCanvas extends Canvas {

	public static final char SPACE_CHAR = ' ';

	protected static final Map<Byte, Character> QUADRANTS = new LinkedHashMap<Byte, Character>();

	static {
		QUADRANTS.put(Byte.valueOf((byte) 0x0), ' ');
		QUADRANTS.put(Byte.valueOf((byte) 0x1), '▗');
		QUADRANTS.put(Byte.valueOf((byte) 0x2), '▖');
		QUADRANTS.put(Byte.valueOf((byte) 0x3), '▄');
		QUADRANTS.put(Byte.valueOf((byte) 0x4), '▝');
		QUADRANTS.put(Byte.valueOf((byte) 0x5), '▐');
		QUADRANTS.put(Byte.valueOf((byte) 0x6), '▞');
		QUADRANTS.put(Byte.valueOf((byte) 0x7), '▟');
		QUADRANTS.put(Byte.valueOf((byte) 0x8), '▘');
		QUADRANTS.put(Byte.valueOf((byte) 0x9), '▚');
		QUADRANTS.put(Byte.valueOf((byte) 0xA), '▌');
		QUADRANTS.put(Byte.valueOf((byte) 0xB), '▙');
		QUADRANTS.put(Byte.valueOf((byte) 0xC), '▀');
		QUADRANTS.put(Byte.valueOf((byte) 0xD), '▜');
		QUADRANTS.put(Byte.valueOf((byte) 0xE), '▛');
		QUADRANTS.put(Byte.valueOf((byte) 0xF), '█');
	}

	public PseudoCanvas(int width, int height) {
		super(width, height);
	}

	@Override
	protected void updateCache() {
		StringBuilder pseudoContent = new StringBuilder();
		StringBuilder textContent = new StringBuilder();
		for (Iterator<StringBuilder> it = lines.iterator(); it.hasNext(); ) {
			StringBuilder line1 = it.next();
			textContent.append(line1);
			StringBuilder line2 = null;
			if (it.hasNext()) {
				line2 = it.next();
				textContent.append('\n');
				textContent.append(line2);
			}
			for (int i = 0; i < width; i += 2) {
				char char1 = NULL_CHAR;
				char char2 = NULL_CHAR;
				char char3 = NULL_CHAR;
				char char4 = NULL_CHAR;

				char1 = line1.charAt(i);
				boolean exists24 = i + 1 < width;
				if (exists24) {
					char2 = line1.charAt(i + 1);
				}
				if (line2 != null) {
					char3 = line2.charAt(i);
					if (exists24) {
						char4 = line2.charAt(i + 1);
					}
				}

				char mergedChar = merge(char1, char2, char3, char4);
				pseudoContent.append(mergedChar);
			}
			if (it.hasNext()) {
				pseudoContent.append('\n');
				textContent.append('\n');
			}
		}
		this.cachedLines = textContent.toString();
		this.cachedText = pseudoContent.toString().replace(NULL_CHAR, ' ');
	}

	protected char merge(char char1, char char2, char char3, char char4) {
		byte quadrant = 0x0;
		quadrant |= isEmptyChar(char1) ? 0x0 : 0x8;
		quadrant |= isEmptyChar(char2) ? 0x0 : 0x4;
		quadrant |= isEmptyChar(char3) ? 0x0 : 0x2;
		quadrant |= isEmptyChar(char4) ? 0x0 : 0x1;
		return QUADRANTS.get(quadrant);
	}

	protected boolean isEmptyChar(char c) {
		return c == NULL_CHAR || c == SPACE_CHAR;
	}
}
