package projekt.fhv.teama.view.support;

import java.awt.image.BufferedImage;

import org.apache.pivot.collections.Sequence;
import org.apache.pivot.wtk.Component;
import org.apache.pivot.wtk.Container;
import org.apache.pivot.wtk.ContainerListener;
import org.apache.pivot.wtk.DesktopApplicationContext;
import org.apache.pivot.wtk.Display;
import org.apache.pivot.wtk.Window;
import org.apache.pivot.wtk.WindowListener;
import org.apache.pivot.wtk.ApplicationContext.DisplayHost;
import org.apache.pivot.wtk.media.Image;
import org.apache.pivot.wtk.media.Picture;

/**
 * Wird benötigt, um einen DisplayHost zu erzeugen, welcher
 * unabängig vom jetzigen Display geöffnet werden kann.
 * 
 * Dabei kann dann ein blockierendes Dialogfenster geöffnet werden.
 *
 * @author Team A
 * @version 1.1
 */
public class DesktopDisplayHost extends DisplayHost {
  private static final long serialVersionUID = 0;

  private Window rootOwner = null;
  private Runnable updateHostWindowTitleBarCallback = null;

  private WindowListener rootOwnerListener = new WindowListener.Adapter() {
      @Override
      public void titleChanged(Window window, String previousTitle) {
          updateFrameTitleBar();
      }

      @Override
      public void iconAdded(Window window, Image addedIcon) {
          updateFrameTitleBar();
      }

      @Override
      public void iconsRemoved(Window window, int index, Sequence<Image> removed) {
          updateFrameTitleBar();
      }
  };

  public DesktopDisplayHost() {
      Display display = getDisplay();
      display.getContainerListeners().add(new ContainerListener.Adapter() {
          @Override
          public void componentInserted(Container container, int index) {
              if (index == container.getLength() - 1) {
                  updateFrameTitleBar();
              }
          }

          @Override
          public void componentsRemoved(Container container, int index, Sequence<Component> removed) {
              if (index == container.getLength()) {
                  updateFrameTitleBar();
              }
          }

          @Override
          public void componentMoved(Container container, int from, int to) {
              int n = container.getLength();

              if (from == n - 1
                  || to == n - 1) {
                  updateFrameTitleBar();
              }
          }
      });
  }

  private void updateFrameTitleBar() {
      Display display = getDisplay();
      int n = display.getLength();

      Window rootOwner;
      if (n == 0) {
          rootOwner = null;
      } else {
          Window topWindow = (Window)display.get(display.getLength() - 1);
          rootOwner = topWindow.getRootOwner();
      }

      Window previousRootOwner = this.rootOwner;
      if (rootOwner != previousRootOwner) {
          if (previousRootOwner != null) {
              previousRootOwner.getWindowListeners().remove(rootOwnerListener);
          }

          if (rootOwner != null) {
              rootOwner.getWindowListeners().add(rootOwnerListener);
          }

          this.rootOwner = rootOwner;
      }

      if (updateHostWindowTitleBarCallback == null) {
          updateHostWindowTitleBarCallback = new Runnable() {
              @Override
              public void run() {
                  java.awt.Window hostWindow = getDisplay().getHostWindow();

                  if (DesktopDisplayHost.this.rootOwner == null) {
                    //  ((TitledWindow)hostWindow).setTitle(DEFAULT_HOST_WINDOW_TITLE);
                      hostWindow.setIconImage(null);
                  } else {
                    //  ((TitledWindow)hostWindow).setTitle(DesktopDisplayHost.this.rootOwner.getTitle());

                      java.util.ArrayList<BufferedImage> iconImages = new java.util.ArrayList<BufferedImage>();
                      for (Image icon : DesktopDisplayHost.this.rootOwner.getIcons()) {
                          if (icon instanceof Picture) {
                              iconImages.add(((Picture) icon).getBufferedImage());
                          }
                      }

                      if (iconImages.size() == 1) {
                          hostWindow.setIconImage(iconImages.get(0));
                      } else if (iconImages.size() > 1) {
                          hostWindow.setIconImages(iconImages);
                      }
                  }

                  updateHostWindowTitleBarCallback = null;
              }
          };

          DesktopApplicationContext.queueCallback(updateHostWindowTitleBarCallback);
      }
  }
}
