package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class ScoreDisplay extends PApplet
{
	ArrayList<Note> notes = new ArrayList<Note>();
	//String score = "DEFGABcd";
	//String score = "D2E2F2G2A2B2c2d2";
	String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";

	public float borderW;
	public float borderH;
	public int count;

	void loadScore()
	{
		int sort = 1;
		for(int i = 0; i < score.length(); i++)
		{
			if(i < score.length() - 1 && score.charAt(i+1)=='2')
			{
				String temp1 = score.substring(i, i+2);
				Note nt = new Note(temp1.charAt(0), (int) temp1.charAt(1) - '0', sort);
				notes.add(nt);
				i++;
			}
			else
			{
				String temp2 = score.substring(i, i+1) + "1";
				Note nt = new Note(temp2.charAt(0), (int) temp2.charAt(1) - '0', sort);
				notes.add(nt);
			}
			sort++;
			count++;
		}
	}

	void printScores()
	{
		for(Note nt: notes)
		{
			println(nt);
		}
	}

	void drawGrid()
	{
		for(int i = 0; i < 5; i++)
		{
			float gap = map(i, 1, 5, borderH * 2, height - borderH * 2);
			stroke(0);
			strokeWeight(3);
			line(borderW, gap, width - borderW, gap);
		}
	}

	void drawNotes()
	{
		for(Note nt: notes)
        {
            nt.render(this , count);
        }
	}

	public void mouseMoved()
	{
		float interval = width - borderW * 2;
		float gap = interval / count;
		float r = map(2, 1, 5, borderH * 2, height - borderH * 2) - map(1, 1, 5, borderH * 2, height - borderH * 2);
		for(int i = 0 ; i < count ; i ++)
		{
			float x = i * gap;
			if (mouseX >= x - 20 + borderW + r && mouseX <= x + 20 + borderW + r)
			{
				notes.get(i).setStatus(false);
			}
			else
			{
				notes.get(i).setStatus(true);
			}
		}
	}

	public void settings()
	{
		size(1000, 500);
	}

	public void setup() 
	{
		count = 0;
		loadScore();
		printScores();
		borderW = width / 10;
		borderH = height / 5;
	}

	public void draw()
	{
		background(255);
		drawGrid();
		drawNotes();
	}
}
