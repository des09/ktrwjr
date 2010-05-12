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
package bufferings.ktr.wjr.client;

import java.util.List;

import bufferings.ktr.wjr.shared.model.WjrMethodItem;
import bufferings.ktr.wjr.shared.model.WjrStore;

import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.HasWidgets;

/**
 * KtrWjr view interface.
 * 
 * @author bufferings[at]gmail.com
 */
public interface WjrDisplay {

  /**
   * Starts the view.
   * 
   * @param handler
   *          The view event handler.
   * @param container
   *          The view container.
   * @param store
   *          The test store.
   */
  public void go(WjrDisplayHandler handler, HasWidgets container, Element store);

  /**
   * Sets the store data.
   * 
   * @param store
   *          The test store.
   */
  public void setData(WjrStore store);

  /**
   * Gets the checked method items.
   * 
   * @return The checked method items.
   */
  public List<WjrMethodItem> getCheckedMethodItems();

  /**
   * Update the summary of the all tree items and repaints them.
   * 
   * @param store
   *          The test store.
   */
  public void repaintAllTreeItems(WjrStore store);

  /**
   * Update the summary of the ancestor tree items of the method item and
   * repaints them.
   * 
   * When the method is run and the result is updated, you only have to do is
   * updating its ancestors, not all summary items.
   * 
   * @param store
   *          The test store.
   * @param methodItem
   *          The method item.
   */
  public void repaintTreeItemAncestors(WjrStore store, WjrMethodItem methodItem);

  /**
   * Notifies loading succeeded to the view.
   * 
   * @param store
   *          The test store.
   */
  public void notifyLoadingSucceeded(WjrStore store);

  /**
   * Notifies loading failed to the view.
   * 
   * @param caught
   *          The cause.
   */
  public void notifyLoadingFailed(Throwable caught);

  /**
   * Notifies reloading succeeded.
   */
  public void notifyReloadingSucceeded();

  /**
   * Notifies reloading failed to the view.
   * 
   * @param caught
   *          The cause.
   */
  public void notifyReloadingFailed(Throwable caught);

  /**
   * Notifies running the test is filnished.
   * 
   * When the running test is failed, the failed info is set to methodItem, so
   * the failed notifier is not prepared.
   */
  public void notifyRunningFinished();
}