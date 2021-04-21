package ie.tudublin;

import processing.core.PApplet;

public class Note extends PApplet {
    private char note;
    private int duration;
    private String value;
    private int sort;
    private Boolean status = true;
    
    public Note(char note, int duration, int sort) {
        this.note = note;
        this.duration = duration;
        this.sort = sort;
    }

    public void render(PApplet pa, int count)
    {
        int j = 0;
        switch(note)
        {
            case 'd': j = 1; break;
            case 'c': j = 2; break;
            case 'B': j = 3; break;
            case 'A': j = 4; break;
            case 'G': j = 5; break;
            case 'F': j = 6; break;
            case 'E': j = 7; break;
            case 'D': j = 8; break;
        }
        float borderW = pa.width / 10;
        float borderH = pa.height / 5;
        float x = PApplet.map(sort, 0, count, borderW, pa.width - borderW);
		float r = map(2, 1, 5, borderH * 2, pa.height - borderH * 2) - map(1, 1, 5, borderH * 2, pa.height - borderH * 2);
        float y = PApplet.map(j, 0, 11, borderH * 2 - r / 2, pa.height - borderH * 2 + r);
        pa.noStroke();
        if(status)
        {
            pa.fill(0);
        }
        else
        {
            pa.fill(255,0,0);
        }
        pa.circle(x - r, y, r);
        if(status)
        {
            pa.stroke(0);
        }
        else
        {
            pa.stroke(255,0,0);
        }
        pa.line(x - r + r / 2, y, x - r + r / 2, y - 2 * r - r / 2);
        if(duration == 2)
        {
            pa.line(x - r + r / 2, y - 2 * r - r / 2, x - r + r / 2 + 10, y - 2 * r - r / 2 + 10);
        }
        if(status)
        {
            pa.fill(0);
        }
        else
        {
            pa.fill(255,0,0);
        }
        pa.textAlign(PApplet.CENTER, PApplet.CENTER);
        pa.text(note, x - r, 100);
    }

    public char getNote() {
        return note;
    }

    public void setNote(char note) {
        this.note = note;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        if(duration==1)
        {
            value = "Quaver";
        }
        else if(duration==2)
        {
            value = "Crotchet";
        }
        return note + "\t" + duration + "\t" + value;
    }
}
