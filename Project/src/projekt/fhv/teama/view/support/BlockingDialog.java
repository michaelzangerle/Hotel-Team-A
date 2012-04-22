package projekt.fhv.teama.view.support;

import static java.lang.Math.min;

import org.apache.pivot.beans.DefaultProperty;
import org.apache.pivot.collections.ArrayList;
import org.apache.pivot.wtk.Alert;
import org.apache.pivot.wtk.Component;
import org.apache.pivot.wtk.ComponentListener;
import org.apache.pivot.wtk.DesktopApplicationContext;
import org.apache.pivot.wtk.DesktopApplicationContext.DisplayListener;
import org.apache.pivot.wtk.Dialog;
import org.apache.pivot.wtk.DialogCloseListener;
import org.apache.pivot.wtk.Dimensions;
import org.apache.pivot.wtk.Display;
import org.apache.pivot.wtk.MessageType;
import org.apache.pivot.wtk.Window;


@DefaultProperty("content")
public class BlockingDialog
{
  private Dialog _content;
  private Window _window = new Window ();
  private final DialogCloseListener _closeListener = new DialogCloseListener()
  {
    
    @Override
    public void dialogClosed(Dialog dialog, boolean modal)
    {
      System.out.println ("closed!");
      _hostDialog.setVisible(false);
    }
  };
  private final ComponentListener _moveListener = new ComponentListener.Adapter()
  {

    /* (sn-Javadoc)
     * @see org.apache.pivot.wtk.ComponentListener.Adapter#locationChanged(org.apache.pivot.wtk.Component, int, int)
     */
    @Override
    public void locationChanged(Component component, int previousX, int previousY)
    {
      log ("locationChanged x=" + component.getX() + ", vorher=" + previousX);
      int x = _hostDialog.getX() + component.getX();
      int y = _hostDialog.getY() + component.getY();
      _hostDialog.setLocation(x, y);
      _content.setLocation(0, 0);
    }

  };
  private HostDialog _hostDialog;

  public BlockingDialog()
  {
  }

  public BlockingDialog(Dialog dialog)
  {
    this ();
    setContent(dialog);
  }

  /**
   * Dialog öffnen und Content zurückgeben. 
   * Daraus lässt sich das Ergebnis mittels {@link Dialog#getResult()} und {@link Alert#getSelectedOption()} ermitteln.
   * @param display Display, dessen Koordinaten über die "Eröffnungsposition" des Dialogs entscheiden.
   * @return Content, welches das Ergebnis enthält.
   */
  public Dialog open(Display display)
  {
    Dimensions pSize = _content.getPreferredSize();
    int width = min(display.getWidth(), pSize.width);
    int height = min(display.getHeight(), pSize.height);
    log("Display x=" + display.getHostWindow().getX());
    _hostDialog = createDisplay(width, height,
        display.getHostWindow().getX() + (display.getWidth() - width) / 2
       ,display.getHostWindow().getY() + (display.getHeight() - height) / 2
       , true, true, true, display.getHostWindow(), null);
    Display newDisplay = _hostDialog.getDisplay();
    _window.open(newDisplay);
    _content.open(_window, _closeListener);
    _hostDialog.setTitle(_content.getTitle());
    _hostDialog.setVisible(true);
    return _content;
  }

  public void setContent(Dialog content)
  {
    _content = content;
    if ( ! content.getComponentListeners().contains(_moveListener))
      content.getComponentListeners().add(_moveListener);
  }

  public Dialog getContent()
  {
    return _content;
  }


  /**
   * Creates a new secondary display.
   * 
   * @param width
   * @param height
   * @param x
   * @param y
   * @param modal
   * @param owner
   */
  private HostDialog createDisplay(int width, int height, int x, int y, boolean modal, boolean resizable,
      boolean undecorated, java.awt.Window owner, DisplayListener displayCloseListener)
  {
    if (DesktopApplicationContext.isFullScreen())
    {
      throw new IllegalStateException();
    }

    final HostDialog hostDialog = new HostDialog(owner, modal, displayCloseListener);
    hostDialog.setLocation(x, y);
    hostDialog.setSize(width, height);
    hostDialog.setResizable(resizable);
    hostDialog.setUndecorated(undecorated);

    return hostDialog;
  }

  private void log(String string)
  {
    //System.out.println (string);
  }
  
  
  
  static public Alert sAlert (MessageType messageType, String message, String title, Display display, Object... options)
  {
    Alert alert = new Alert (messageType, message, new ArrayList<Object>(options));
    alert.setTitle(title);
    BlockingDialog bDialog = new BlockingDialog(alert);
    bDialog.open(display);
    
    return alert;
  }
  
  static public Alert sAlert (MessageType messageType, String message, String title, Display display)
  {
    return sAlert(messageType, message, title, display, "OK");
  }
}
