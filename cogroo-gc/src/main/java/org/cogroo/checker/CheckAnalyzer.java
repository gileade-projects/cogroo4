/**
 * Copyright (C) 2012 cogroo <cogroo@cogroo.org>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.cogroo.checker;

public interface CheckAnalyzer {

  /**
   * Analyzes part of a text or a word.
   * <p>
   * For example, it can search all the sentences in the text or tag every word
   * in a sentence.
   * 
   * @param document
   *          contains the whole text given by the user. After an analysis it
   *          can store the text's sentences, words or its tags.
   */
  public void analyze(CheckDocument document);

}