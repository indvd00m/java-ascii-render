package com.indvd00m.ascii.render.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @since 2.3.0
 */
public class AsciiUtils {

	public static final char NULL_CHAR = '\0';
	public static final String PNG_FORMAT = "png";

	public static String repeatChar(char c, int count) {
		return repeatString(c + "", count);
	}

	public static String repeatString(String s, int count) {
		String repeated = new String(new char[count]).replace(NULL_CHAR + "", s);
		return repeated;
	}

	public static Font readDejaVuSansMonoFont() {
		InputStream is = null;
		try {
			is = AsciiUtils.class.getResourceAsStream("/fonts/DejaVuSansMono/DejaVuSansMono.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, is);
			return font;
		} catch (FontFormatException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

	public static void writeImageToPNG(BufferedImage image, String path) {
		try {
			ImageIO.write(image, PNG_FORMAT, new File(path));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
