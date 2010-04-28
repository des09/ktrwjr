/*
 * Copyright 2010 bufferings[at]gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
 package bufferings.ktr.wjr.client.ui;

import static bufferings.ktr.wjr.client.ui.widget.JQueryUI.*;

import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class WjrPopupPanel extends Composite implements HasText {

  protected boolean isShowing = false;

  protected boolean isHiding = false;

  protected Label label;

  public WjrPopupPanel() {
    HorizontalPanel mainPanel = new HorizontalPanel();
    mainPanel.setHorizontalAlignment(HorizontalPanel.ALIGN_CENTER);
    mainPanel.setVerticalAlignment(HorizontalPanel.ALIGN_MIDDLE);
    mainPanel.setSpacing(5);
    mainPanel.setStyleName(UI_STATE_HIGHLIGHT);
    mainPanel.setSize("200px", "30px");
    mainPanel.setVisible(false);
    mainPanel.getElement().getStyle().setPosition(Position.ABSOLUTE);
    mainPanel.getElement().getStyle().setPropertyPx("left", -9999);
    mainPanel.getElement().setId(DOM.createUniqueId());

    label = new Label();
    label.setStyleName(UI_WIDGET);
    mainPanel.add(label);

    initWidget(mainPanel);
    RootPanel.get().add(this);
  }

  private void adjustPosition() {
    int left = 13;
    int top = (Window.getClientHeight() - 48);

    left += Window.getScrollLeft();
    top += Window.getScrollTop();

    getElement().getStyle().setPropertyPx("left", left);
    getElement().getStyle().setPropertyPx("top", top);
  }

  public void show() {
    if (isVisible() || isShowing) {
      return;
    }
    isShowing = true;
    adjustPosition();
    showAnimation(getElement().getId());
  }

  protected void showCallback() {
    isShowing = false;
  }

  public void hide() {
    if (!isVisible() || isHiding) {
      return;
    }
    isHiding = true;
    hideAnimation(getElement().getId());
  }

  protected void hideCallback() {
    isHiding = false;
  }

  private native void showAnimation(String id)/*-{
    var options = {}
    var callback = this.@bufferings.ktr.wjr.client.ui.WjrPopupPanel::showCallback()();
    $wnd.$("#" + id).show('slide', options, 500, callback);
  }-*/;

  public native void hideAnimation(String id)/*-{
    var options = {}
    var callback = this.@bufferings.ktr.wjr.client.ui.WjrPopupPanel::hideCallback()();
    $wnd.$("#" + id).hide('slide', options, 500, callback);
  }-*/;

  @Override
  public String getText() {
    return label.getText();
  }

  @Override
  public void setText(String text) {
    label.setText(text);
  }
}