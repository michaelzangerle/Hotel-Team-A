package projekt.fhv.teama.view.support;

import java.awt.AWTEvent;
import java.awt.Graphics;
import java.awt.event.WindowEvent;

import org.apache.pivot.wtk.Display;
import org.apache.pivot.wtk.ApplicationContext.DisplayHost;
import org.apache.pivot.wtk.DesktopApplicationContext.DisplayListener;


public class HostDialog extends java.awt.Dialog
{
  private static final long serialVersionUID = 5340356674429280196L;

  private DisplayHost displayHost = new DesktopDisplayHost();

  private DisplayListener displayCloseListener;

  public HostDialog(java.awt.Window owner, boolean modal, DisplayListener displayCloseListener)
  {
    super(owner, modal ? java.awt.Dialog.ModalityType.APPLICATION_MODAL
        : java.awt.Dialog.ModalityType.MODELESS);

    this.displayCloseListener = displayCloseListener;

    enableEvents(AWTEvent.WINDOW_EVENT_MASK);

    // Disable focus traversal keys
    setFocusTraversalKeysEnabled(false);

    // Clear the background
    setBackground(null);

    // Add the display host
    add(displayHost);
  }

  @Override
  public void update(Graphics graphics)
  {
    paint(graphics);
  }

  public Display getDisplay()
  {
    return displayHost.getDisplay();
  }

  @Override
  public String getTitle()
  {
    return super.getTitle();
  }

  @Override
  public void setTitle(String title)
  {
    super.setTitle(title);
  }

  @Override
  public void processWindowEvent(WindowEvent event)
  {
    super.processWindowEvent(event);

    switch (event.getID())
    {
    case WindowEvent.WINDOW_OPENED:
    {
      Display display = displayHost.getDisplay();
      //displays.add(display);

      if (displayCloseListener != null)
      {
        displayCloseListener.hostWindowOpened(display);
      }

      displayHost.requestFocus();

      break;
    }

    case WindowEvent.WINDOW_CLOSING:
    {
      dispose();
      break;
    }

    case WindowEvent.WINDOW_CLOSED:
    {
      Display display = displayHost.getDisplay();
      // displays.remove(display);

      if (displayCloseListener != null)
      {
        displayCloseListener.hostWindowClosed(display);
      }

      break;
    }
    }
  }
}
