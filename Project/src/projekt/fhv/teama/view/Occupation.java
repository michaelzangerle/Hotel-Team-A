package projekt.fhv.teama.view;

import java.net.URL;

import org.apache.pivot.util.concurrent.TaskExecutionException;
import org.apache.pivot.wtk.Border;
import org.apache.pivot.wtk.media.Image;

public class Occupation extends Border{
	
	 private Image flag = null;
	    private String nation = null;
	    private int gold = 0;
	    private int silver = 0;
	    private int bronze = 0;
	 
	    public Image getFlag() {
	        return flag;
	    }
	 
	    public void setFlag(Image flag) {
	        this.flag = flag;
	    }
	 
	    public void setFlag(URL flag) {
	        try {
	            setFlag(Image.load(flag));
	        } catch (TaskExecutionException exception) {
	            throw new IllegalArgumentException(exception);
	        }
	    }
	 
	    public String getNation() {
	        return nation;
	    }
	 
	    public void setNation(String nation) {
	        this.nation = nation;
	    }
	 
	    public int getGold() {
	        return gold;
	    }
	 
	    public void setGold(int gold) {
	        this.gold = gold;
	    }
	 
	    public int getSilver() {
	        return silver;
	    }
	 
	    public void setSilver(int silver) {
	        this.silver = silver;
	    }
	 
	    public int getBronze() {
	        return bronze;
	    }
	 
	    public void setBronze(int bronze) {
	        this.bronze = bronze;
	    }
	 
	    public int getTotal() {
	        return (gold + silver + bronze);
	    }


}
