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
package org.cogroo.tools.tokenizer;

import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import opennlp.tools.tokenize.DefaultTokenContextGenerator;

public class PortugueseTokenContextGenerator extends
    DefaultTokenContextGenerator {

  private static final Pattern itemPattern = Pattern.compile("^\\p{Nd}[\\.)]$");

  public PortugueseTokenContextGenerator(Set<String> inducedAbbreviations) {
    super(inducedAbbreviations);
  }

  @Override
  protected List<String> createContext(String sentence, int index) {
    List<String> preds = super.createContext(sentence, index);

    if (sentence.length() == 2) {
      char current = sentence.charAt(index);
      char prev = sentence.charAt(0);
      if (current == '.') {
        if (Character.isLetter(prev) && Character.isUpperCase(prev)) {
          preds.add("abbname");
        }
      }
      if ((current == '.' || current == ')')
          && itemPattern.matcher(sentence).matches()) {
        preds.add("item");
      }
    }

    return preds;
  }

  @Override
  protected void addCharPreds(String key, char c, List<String> preds) {
    super.addCharPreds(key, c, preds);

    if (c == ':' || c == ',' || c == ';') {
      preds.add(key + "_sep");
    } else if (c == '»' || c == '«') {
     preds.add(key + "_quote");
    }
  }
}
