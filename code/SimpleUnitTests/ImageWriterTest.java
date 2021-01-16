package SimpleUnitTests;

//import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import Renderer.ImageWriter;

public class ImageWriterTest {


@Test
public void test()
{

	ImageWriter image = new ImageWriter("image1",500,500,10,10);
	for(int i=0;i<500;i++)
	{
		for(int j=0;j<500;j++)
		{
			if((i%50==0)||(j%50==0))
				image.writePixel(i,j,Color.WHITE);
			else
				image.writePixel(i,j,Color.BLACK);
		}
	}
	image.writeToimage();
}






















}
