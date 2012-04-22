package projekt.fhv.teama.view.support;

import org.apache.pivot.collections.ArrayList;
import org.apache.pivot.collections.Map;
import org.apache.pivot.wtk.Alert;
import org.apache.pivot.wtk.Application;
import org.apache.pivot.wtk.Dialog;
import org.apache.pivot.wtk.Display;
import org.apache.pivot.wtk.MessageType;


public class BlockingDialogTest implements Application
{

  @Override
  public void startup(Display display, Map<String, String> properties) throws Exception
  {
    log ("Start");
    BlockingDialog bd = new BlockingDialog();
    bd.setContent(new Alert(MessageType.QUESTION, "Warum?", new ArrayList<String>("Ja","Nein")));
    String text = "Vorm BlockingDialog";
    log(text);
    Dialog erg = bd.open(display);
    log ("Nachm BlockingDialog: " + erg.getResult() + ", selected:" + ((Alert)erg).getSelectedOptionIndex());
  }

  public void log(String text)
  {
    System.out.println (text);
  }

  @Override
  public boolean shutdown(boolean optional) throws Exception
  {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void suspend() throws Exception
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void resume() throws Exception
  {
    // TODO Auto-generated method stub

  }

}
