package io.loustler.massemble.sedgewick.chapter1.list;

import io.loustler.massemble.sedgewick.chapter1.Iterable;

import java.util.function.BiFunction;

public interface List<T> extends Iterable<T> {
  /**
   * Add element into List
   *
   * @param value new element
   */
  void add(T value);

  /**
   * Add all elemetns into List
   *
   * @param values new elements
   */
  void addAll(T... values);

  /**
   * Replace oldValue to newValue
   *
   * @param oldValue old value
   * @param newValue new value
   */
  void replace(T oldValue, T newValue);

  /**
   * Filter this list by Value or Index
   *
   * @param fun Filter function by element and index
   * @return filtered list
   */
  List<T> filter(BiFunction<T, Integer, Boolean> fun);

  /**
   * Filter remove specific element or index
   *
   * @param fun Fitler function by element and index
   * @return A list of not contains specific element and index
   */
  List<T> filterNot(BiFunction<T, Integer, Boolean> fun);

  /**
   * Remove this element
   *
   * @param value element
   * @return
   */
  T remove(T value);

  /**
   * Remove element by index
   *
   * @param index index
   * @return
   */
  T remove(int index);

  /**
   * Check element exists
   *
   * @param value element
   * @return
   */
  boolean exists(T value);

  /**
   * Head element. Same with first element.
   *
   * @return head element
   */
  T head();

  /**
   * List without head(first) element.
   *
   * @return without head element. It must be List, never null.
   */
  List<T> tails();

  /**
   * Last element
   *
   * @return last element
   */
  T last();

  /**
   * First element. Same with head element.
   *
   * @return
   */
  default T first() {
    return head();
  }
}
