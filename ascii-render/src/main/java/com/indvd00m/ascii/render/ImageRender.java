package com.indvd00m.ascii.render;

import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IImageRender;
import com.indvd00m.ascii.render.util.AsciiUtils;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import static com.indvd00m.ascii.render.util.AsciiUtils.getDejaVuSansMonoFont;
import static com.indvd00m.ascii.render.util.AsciiUtils.repeatChar;

/**
 * @author indvd00m (gotoindvdum[at]gmail[dot]com)
 * @since 2.3.0
 */
public class ImageRender implements IImageRender {

	public static final int FONT_REPLICA_STYLE = 24;
	public static final char SAMPLE_SYMBOL = ' ';
	protected final Font font;

	public ImageRender() {
		this(AsciiUtils.getDejaVuSansMonoFont());
	}

	/**
	 * @param font monospaced font
	 */
	public ImageRender(Font font) {
		this.font = font;
	}

	@Override
	public BufferedImage render(final ICanvas canvas, final int height) {
		int textWidth = canvas.getWidth();
		int textHeight = canvas.getHeight();

		Font fontReplica = getFont().deriveFont(FONT_REPLICA_STYLE);

		final int ascent;
		final int leading;
		final int linesWidth;
		float lineHeight = ((float) height) / textHeight;

		{
			int sampleWidth = (int) ((float) height * textWidth / textHeight);
			String sampleString = repeatChar(SAMPLE_SYMBOL, textWidth);
			BufferedImage sampleImage = new BufferedImage(sampleWidth, height, BufferedImage.TYPE_INT_RGB);
			Graphics2D sampleGraphics = sampleImage.createGraphics();
			sampleGraphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS,
					RenderingHints.VALUE_FRACTIONALMETRICS_ON);
			sampleGraphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
					RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);

			FontMetrics fm = sampleGraphics.getFontMetrics(fontReplica);
			Rectangle2D r2d = fm.getStringBounds(sampleString, sampleGraphics);
			float leadingFactor = (float) fm.getLeading() / fm.getHeight();
			float size = (float) (fontReplica.getSize2D() * lineHeight / (r2d.getHeight() - r2d.getHeight() * leadingFactor));
			fontReplica = fontReplica.deriveFont(size);
			fm = sampleGraphics.getFontMetrics(fontReplica);
			ascent = fm.getAscent();
			leading = fm.getLeading();
			linesWidth = (int) fm.getStringBounds(sampleString, sampleGraphics).getWidth();
		}

		BufferedImage image = new BufferedImage(linesWidth, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics = image.createGraphics();
		graphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);

		Color fontColor = Color.BLACK;
		Color backgroundColor = Color.WHITE;

		graphics.setFont(fontReplica);
		graphics.setColor(backgroundColor);
		graphics.fillRect(0, 0, linesWidth, height);
		graphics.setColor(fontColor);
		for (int i = 0; i < textHeight; i++) {
			String line = canvas.getLine(i);
			graphics.drawString(line, 0, lineHeight * i + ascent + leading);
		}

		return image;
	}


	public Font getFont() {
		return font;
	}

}
