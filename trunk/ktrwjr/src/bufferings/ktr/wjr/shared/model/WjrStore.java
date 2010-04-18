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
package bufferings.ktr.wjr.shared.model;

import static bufferings.ktr.wjr.shared.util.Preconditions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * The store of test case models.
 * 
 * @author bufferings[at]gmail.com
 */
public class WjrStore implements IsSerializable {

  /**
   * The root summary item of the store.
   * 
   * @author bufferings[at]gmail.com
   */
  protected static class Root extends WjrSummaryItem {
    /*
     * (non-Javadoc)
     * 
     * @see
     * bufferings.ktr.wjr.shared.model.WjrSummaryItem#fetchChildren(bufferings
     * .ktr.wjr.shared.model.WjrStore)
     */
    @Override
    protected List<? extends WjrStoreItem> fetchChildren(WjrStore store) {
      return store.getClassItems();
    }
  }

  /**
   * The root summary item of the store.
   */
  protected Root root = new Root();

  /**
   * The class items sorted by the class canonical name.
   */
  protected TreeMap<String, WjrClassItem> classItems =
    new TreeMap<String, WjrClassItem>();

  /**
   * The method items sorted by the method canonical name.
   */
  protected TreeMap<String, WjrMethodItem> methodItems =
    new TreeMap<String, WjrMethodItem>();

  /**
   * Adds the class item to the store.
   * 
   * The class canonical name of the classItem must not already be stored.
   * 
   * @param classItem
   *          The class item, cannot be null.
   * @throws NullPointerException
   *           When the classItem parameter is null.
   * @throws IllegalStateException
   *           When the classCanonicalName has already exist.
   */
  public void addClassItem(WjrClassItem classItem) {
    checkNotNull(classItem, "The classItem parameter is null.");

    String classCanonicalName = classItem.getClassCanonicalName();
    checkState(
      !classItems.containsKey(classCanonicalName),
      "The %s has already exist.",
      classCanonicalName);

    classItems.put(classCanonicalName, classItem);
  }

  /**
   * Adds the method item to the store.
   * 
   * The classItem which is the parent of the methodItem must stored in this
   * store, and the methodItem must not already stored.
   * 
   * @param methodItem
   *          The method item, cannot be null.
   * @throws NullPointerException
   *           When the methodItem parameter is null.
   * @throws IllegalStateException
   *           When the classCanonicalName is not found.
   * @throws IllegalStateException
   *           When the methodCanonicalName has already exist.
   */
  public void addMethodItem(WjrMethodItem methodItem) {
    checkNotNull(methodItem, "The methodItem parameter is null.");

    String classCanonicalName = methodItem.getClassCanonicalName();
    checkState(
      classItems.containsKey(classCanonicalName),
      "The %s is not found.",
      classCanonicalName);

    String methodCanonicalName = methodItem.getMethodCanonicalName();
    checkState(
      !methodItems.containsKey(methodCanonicalName),
      "The %s has already exist.",
      methodCanonicalName);

    methodItems.put(methodCanonicalName, methodItem);
  }

  /**
   * Gets the class item from the store. If not found, the exception occurs.
   * 
   * @param classCanonicalName
   *          The class canonical name.
   * @return The class item.
   * @throws NullPointerException
   *           When the classCanonicalName parameter is null.
   * @throws IllegalStateException
   *           When the class item is not found.
   */
  public WjrClassItem getClassItem(String classCanonicalName) {
    checkNotNull(
      classCanonicalName,
      "The classCanonicalName parameter is null.");
    checkState(
      classItems.containsKey(classCanonicalName),
      "The %s is not found.",
      classCanonicalName);

    return classItems.get(classCanonicalName);
  }

  /**
   * Gets the method item from the store. If not found, the exception occurs.
   * 
   * @param methodCanonicalName
   *          The method canonical name.
   * @return The method item.
   * @throws NullPointerException
   *           When the methodCanonicalName parameter is null.
   * @throws IllegalStateException
   *           When the method item is not found.
   */
  public WjrMethodItem getMethodItem(String methodCanonicalName) {
    checkNotNull(
      methodCanonicalName,
      "The methodCanonicalName parameter is null.");
    checkState(
      methodItems.containsKey(methodCanonicalName),
      "The %s is not found.",
      methodCanonicalName);

    return methodItems.get(methodCanonicalName);
  }

  /**
   * Gets the class items.
   * 
   * @return The list of the class items.
   */
  public List<WjrClassItem> getClassItems() {
    return new ArrayList<WjrClassItem>(classItems.values());
  }

  /**
   * Gets the method items belong to the classCanonicalName.
   * 
   * @param classCanonicalName
   *          The class canonical name.
   * @return The list of the method items.
   * @throws NullPointerException
   *           When the classCanonicalName parameter is null.
   * @throws IllegalStateException
   *           The classItem of the classCanonicalName is not found.
   */
  public List<WjrMethodItem> getMethodItems(String classCanonicalName) {
    checkNotNull(
      classCanonicalName,
      "The classCanonicalName parameter is null.");
    checkState(
      classItems.containsKey(classCanonicalName),
      "The %s is not found.",
      classCanonicalName);

    List<WjrMethodItem> items = new ArrayList<WjrMethodItem>();

    SortedMap<String, WjrMethodItem> tailMap =
      methodItems.tailMap(classCanonicalName);
    for (WjrMethodItem item : tailMap.values()) {
      if (item.getClassCanonicalName().equals(classCanonicalName)) {
        items.add(item);
      } else {
        break;
      }
    }
    return items;
  }

  /**
   * Gets the total count.
   * 
   * @return The total count.
   */
  public int getTotalCount() {
    return root.getTotalCount();
  }

  /**
   * Gets the success count.
   * 
   * @return The success count.
   */
  public int getSuccessCount() {
    return root.getSuccessCount();
  }

  /**
   * Gets the failure count.
   * 
   * @return The failure count.
   */
  public int getFailureCount() {
    return root.getFailureCount();
  }

  /**
   * Gets the error count.
   * 
   * @return The error count.
   */
  public int getErrorCount() {
    return root.getErrorCount();
  }

  /**
   * Gets the not yet count.
   * 
   * @return The not yet count.
   */
  public int getNotYetCount() {
    return root.getNotYetCount() + root.getRunningCount();
  }

  /**
   * Updates the summary of the class items. This method does not update the
   * summaries in the class items. If you want to update all summaries, you can
   * use {@link WjrStore#updateAllSummaries()} method.
   */
  public void updateSummary() {
    root.updateSummary(this);
  }

  /**
   * Updates all the summary. First this method updates the summaries in the
   * class items, then updates the summary of the class items.
   */
  public void updateAllSummaries() {
    for (WjrClassItem classItem : classItems.values()) {
      classItem.updateSummary(this);
    }
    root.updateSummary(this);
  }

  /**
   * Clears the results in methodItems and the summaries in classItems and the
   * summary of classItems.
   */
  public void clearAllResultsAndSummaries() {
    root.clearSummary();
    for (WjrMethodItem methodItem : methodItems.values()) {
      methodItem.clearResult();
    }
    for (WjrClassItem classItem : classItems.values()) {
      classItem.clearSummary();
    }
  }

}
